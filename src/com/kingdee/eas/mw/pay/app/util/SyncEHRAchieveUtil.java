package com.kingdee.eas.mw.pay.app.util;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.eas.base.core.fm.ContextHelperFactory;
import com.kingdee.eas.basedata.framework.app.ParallelSqlExecutor;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.custom.EAISynTemplate;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.jdbc.rowset.IRowSet;

public class SyncEHRAchieveUtil {


    public static String SyncAchieveRepot(Context ctx,String businessdate,String cityNum,String type,String incityStr) throws Exception{
    	
    	List<String> sqls = new ArrayList<String>();
    	ExecutorService pool = Executors.newFixedThreadPool(6);
	    ParallelSqlExecutor pe = new ParallelSqlExecutor(pool); 
	    String userId = ContextHelperFactory.getLocalInstance(ctx).getCurrentUser().getId().toString(); 
	    boolean flag = false;
	    Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String errorMsg = "";
		 
		//HashMap<String,String> detailMap = new HashMap<String,String>();
		//校验信息是否存在
		String existSql = " /*dialect*/ SELECT count(1) as C FROM   CT_PAY_AchieveDetail  where  cfcitynumber "+incityStr+" and  to_char(fbizdate,'YYYYMM') ='"+businessdate+"'    ";
		IRowSet existrow = DbUtil.executeQuery(ctx, existSql); 
		while(existrow.next()){
			BigDecimal count =  existrow.getBigDecimal("C");  
			if(count.compareTo(BigDecimal.ZERO)>0){
				//说明存在  需要删除
				String deleteSql = " /*dialect*/ delete CT_PAY_AchieveDetail where  cfcitynumber   "+incityStr+"  and  to_char(fbizdate,'YYYYMM') ='"+businessdate+"'    ";
				
				//String deleteTemSql = " /*dialect*/ delete CT_PAY_AchieveDetailTem where  cfcitynumber   "+incityStr+"  and  to_char(fbizdate,'YYYYMM') ='"+businessdate+"' and cfbusinessdate = '"+businessdate+"'   ";
				String deleteTemSql = " /*dialect*/ delete CT_PAY_AchieveDetailTem where  cfcitynumber   "+incityStr+"  and  to_char(fbizdate,'YYYYMM') ='"+businessdate+"'   ";
				DbUtil.execute(ctx, deleteSql); 
				DbUtil.execute(ctx, deleteTemSql); 
				
//				String sqldetail = " /*dialect*/ select  CFFEEITEMDETAILNUMBER   from  CT_PAY_AchieveDetailTem where  cfcitynumber  "+incityStr+"  and  to_char(fbizdate,'YYYYMM') ='"+businessdate+"' and cfbusinessdate != '"+businessdate+"'  ";
//				IRowSet detailrow = DbUtil.executeQuery(ctx, sqldetail); 
//				while(detailrow.next()){
//					String feeItemDetailNumber = detailrow.getObject("FFEEITEMDETAILNUMBER")== null ? "":detailrow.getObject("FFEEITEMDETAILNUMBER").toString(); 
//					if(!feeItemDetailNumber.equals("")){
//						detailMap.put(feeItemDetailNumber, feeItemDetailNumber);
//					}
//					
//				} 
			}
		}
		// 业绩 天数 汇总查询
		HashMap<String,String> hisMap = new HashMap<String,String>();
		String sqlCheck = "/*dialect*/ select FCityNumber AS CITYNUMBER,FClinicNumber AS CLINICNUMBER,FDate AS FDATE ,count(1) as fcount from HIS_EHR_report where fSign = 0  and  FCityNumber "+incityStr+"  group by  FCityNumber ,FClinicNumber ,FDate ";
    	List<Map<String, Object>> listCheck = EAISynTemplate.query(ctx, "04",sqlCheck.toString());
    	for (Map<String, Object> mapCheck : listCheck) {
    		String thisCount = mapCheck.get("FCOUNT")== null ? "":mapCheck.get("FCOUNT").toString();  
    		String clinicnumber = mapCheck.get("CLINICNUMBER")== null ? "":mapCheck.get("CLINICNUMBER").toString();  
    		String citynumber = mapCheck.get("CITYNUMBER")== null ? "":mapCheck.get("CITYNUMBER").toString();  
    		String date = mapCheck.get("FDATE")== null ? "":mapCheck.get("FDATE").toString();  
    		
    		hisMap.put(clinicnumber+date, thisCount);
    	}
    	
    	
    	
    	String payZiDuan  = "CFPAYMENT";
    	String  channelsql = " /*dialect*/ select nvl(channel.fsimplename,'CFPAYMENT') as payziduan  ,company.fnumber,cfchannelType , cfchannel  , cfdiscount ,nvl(cfincludezx,0)  as includezx, nvl(cfincludedoc,0)  as includedoc  from CT_PAY_CityChannel channel left join t_org_company company on company.fid = channel.cfcityid  "
			+"  where  channel.cfbusinessdate = '"+businessdate+"' and company.fnumber "+incityStr+"  order by  cfdiscount ";
		IRowSet channelrow = DbUtil.executeQuery(ctx, channelsql); 
		while(channelrow.next()){
			payZiDuan = channelrow.getString("PAYZIDUAN"); 
		
		}
		
		
		//删除信息之后重新进行同步
	    String sqlClinic = "/*dialect*/ select  id, FDate,FCityNumber ,FClinicNumber,FRecordCount  from HIS_EHR_REPORT_RECORD where fSign = 0 and FCITYNUMBER   "+incityStr+"  and substr(replace(fdate,'-',''),0,6)='"+businessdate+"'   ";
	    List<Map<String, Object>> listClinic = EAISynTemplate.query(ctx, "04",sqlClinic.toString());
	    
	    for(Map<String, Object> mapClinic : listClinic){
	    	String fid = mapClinic.get("ID")== null ? "":mapClinic.get("ID").toString(); 
	    	String cityNumber = mapClinic.get("FCITYNUMBER")== null ? "":mapClinic.get("FCITYNUMBER").toString(); 
	    	String clinicNumber = mapClinic.get("FCLINICNUMBER")== null ? "":mapClinic.get("FCLINICNUMBER").toString(); 
	    	String recordCount = mapClinic.get("FRECORDCOUNT")== null ? "0":mapClinic.get("FRECORDCOUNT").toString(); 
	    	String fdate = mapClinic.get("FDATE")== null ? "":mapClinic.get("FDATE").toString(); 
	    	 
	    	
	    	//String sqlCheck = "/*dialect*/ select count(1) as fcount from HIS_EHR_report where fSign = 0  and FCityNumber='"+cityNumber+"' and FClinicNumber='"+clinicNumber+"' and FDate = '"+fdate+"'";
	    	//List<Map<String, Object>> listCheck = EAISynTemplate.query(ctx, "04",sqlCheck.toString());
	    	
	    	//for (Map<String, Object> mapCheck : listCheck) {
	    	if(hisMap.get(clinicNumber+fdate) != null){
	    		String thisCount = hisMap.get(clinicNumber+fdate).equals("") ? "0":hisMap.get(clinicNumber+fdate);   
	    		
	    		if(Integer.parseInt(thisCount) == Integer.parseInt(recordCount) ){
	    			String sql = "/*dialect*/  select  FID,FDate,FCityNumber,FCity, FClinicNumber,FClinicName,FCaseNumber,FPatientName,FFirSource,FSecSource,FTerSource ,FComplainNumber,FComplainName,FCreateOrg,FCreator, FFirVis,FStatus,FOrder,FRecDotNumber,FRecDotName, " +
	    			" FNurseNUmber,FRecNurse,FNurseOrderDiag, FRecConNumber,FRecConName,FExcConNumber,FExcConName,FRecPonDotNumber,FRecPonDotName,FNumber,FCreatorNumber,FCreatorName, " +
	    			" FFirClassNumber, FFirClassName,FSecClassNumber,FSecClassName,FFeeItemDetail,FRecPerson,FQty,FOriPrice,FTotalPrice,FDiscount,FIncome,FPayment,FGiftPayment, " +
	    			" FBusType,fSign,FsynTime ,FsynLog,FFeeItemDetailNumber ,FIsRoutine ,forderid ,FISNEEDOUT,FORDERDETAILID,FRECPERSONNUMBER  from HIS_EHR_report where fSign = 0  and FCityNumber "+incityStr+"  and FClinicNumber='"+clinicNumber+"' and FDate='"+fdate+"'";
	    			 
	    	    	List<Map<String, Object>> list = EAISynTemplate.query(ctx, "04",sql.toString());
	    	    	System.out.println("--------------------------" + list.size());
	    	    	for (Map<String, Object> map : list) {
	    	    		String fidRecod = map.get("FID")== null ? "":map.get("FID").toString(); 
	    				String date = map.get("FDATE")== null ? "":map.get("FDATE").toString(); 
	    				 String city = map.get("FCITY")== null ? "":map.get("FCITY").toString(); 
	    				 //String clinicNumber = map.get("FCLINICNUMBER")== null ? "":map.get("FCLINICNUMBER").toString();   
	    				 String clinicName = map.get("FCLINICNAME")== null ? "":map.get("FCLINICNAME").toString(); 
	    				 String caseNumber = map.get("FCASENUMBER")== null ? "":map.get("FCASENUMBER").toString(); 
	    				 String patientName = map.get("FPATIENTNAME")== null ? "":map.get("FPATIENTNAME").toString(); 
	    				 String firSource = map.get("FFIRSOURCE")== null ? "":map.get("FFIRSOURCE").toString(); 
	    				 String secSource = map.get("FSECSOURCE")== null ? "":map.get("FSECSOURCE").toString(); 
	    				 String terSource = map.get("FTERSOURCE")== null ? "":map.get("FTERSOURCE").toString(); 
	    				 String complainNumber = map.get("FCOMPLAINNUMBER")== null ? "":map.get("FCOMPLAINNUMBER").toString(); 
	    				 String complainName = map.get("FCOMPLAINNAME")== null ? "":map.get("FCOMPLAINNAME").toString(); 
	    				 String createOrg = map.get("FCREATEORG")== null ? "":map.get("FCREATEORG").toString(); 
	    				 String creator = map.get("FCREATOR")== null ? "":map.get("FCREATOR").toString(); 
	    				 String firVis = map.get("FFIRVIS")== null ? "":map.get("FFIRVIS").toString(); 
	    				 String status = map.get("FSTATUS")== null ? "":map.get("FSTATUS").toString(); 
	    				 String order = map.get("FORDER")== null ? "":map.get("FORDER").toString(); 
	    				 String recDotNumber = map.get("FRECDOTNUMBER")== null ? "":map.get("FRECDOTNUMBER").toString(); 
	    				 String recDotName = map.get("FRECDOTNAME")== null ? "":map.get("FRECDOTNAME").toString(); 
	    				 
	    				 //FNurseNUmber,FRecNurse,FNurseOrderDiag, FRecConNumber,FRecConName,FExcConNumber,FExcConName,FRecPonDotNumber,FRecPonDotName,FNumber,FCreatorNumber,FCreatorName,
	    				 String nurseNUmber = map.get("FNURSENUMBER")== null ? "":map.get("FNURSENUMBER").toString(); 
	    				 String recNurse = map.get("FRECNURSE")== null ? "":map.get("FRECNURSE").toString(); 
	    				 String nurseOrderDiag = map.get("FNURSEORDERDIAG")== null ? "":map.get("FNURSEORDERDIAG").toString(); 
	    				 String recConNumber = map.get("FRECCONNUMBER")== null ? "":map.get("FRECCONNUMBER").toString(); 
	    				 String recConName = map.get("FRECCONNAME")== null ? "":map.get("FRECCONNAME").toString(); 
	    				 String excConNumber = map.get("FEXCCONNUMBER")== null ? "":map.get("FEXCCONNUMBER").toString(); 
	    				 String excConName = map.get("FEXCCONNAME")== null ? "":map.get("FEXCCONNAME").toString(); 
	    				 String recPonDotNumber = map.get("FRECPONDOTNUMBER")== null ? "":map.get("FRECPONDOTNUMBER").toString(); 
	    				 String recPonDotName = map.get("FRECPONDOTNAME")== null ? "":map.get("FRECPONDOTNAME").toString(); 
	    				 String number = map.get("FNUMBER")== null ? "":map.get("FNUMBER").toString(); 
	    				 String creatorNumber = map.get("FCREATORNUMBER")== null ? "":map.get("FCREATORNUMBER").toString(); 
	    				 String creatorName = map.get("FCREATORNAME")== null ? "":map.get("FCREATORNAME").toString(); 
	    				 
	    				//FFirClassNumber, FFirClassName,FSecClassNumber,FSecClassName,FFeeItemDetail,FRecPerson,FQty,FOriPrice,FTotalPrice,FDiscount,FIncome,FPayment,FGiftPayment
	    				 String firClassNumber = map.get("FFIRCLASSNUMBER")== null ? "":map.get("FFIRCLASSNUMBER").toString(); 
	    				 String firClassName = map.get("FFIRCLASSNAME")== null ? "":map.get("FFIRCLASSNAME").toString(); 
	    				 String secClassNumber = map.get("FSECCLASSNUMBER")== null ? "":map.get("FSECCLASSNUMBER").toString(); 
	    				 String secClassName = map.get("FSECCLASSNAME")== null ? "":map.get("FSECCLASSNAME").toString(); 
	    				 String feeItemDetail = map.get("FFEEITEMDETAIL")== null ? "":map.get("FFEEITEMDETAIL").toString(); 
	    				 
	    				 feeItemDetail = feeItemDetail.replace("'", "");
	    				 
	    				 String recPerson = map.get("FRECPERSON")== null ? "":map.get("FRECPERSON").toString(); 
	    				 String qty = map.get("FQTY")== null|| map.get("FQTY").toString().equals("")  ? "0":map.get("FQTY").toString(); 
	    				 String oriPrice = map.get("FORIPRICE")== null || map.get("FORIPRICE").toString().equals("") ? "0":map.get("FORIPRICE").toString(); 
	    				 String totalPrice = map.get("FTOTALPRICE")== null || map.get("FTOTALPRICE").toString().equals("") ? "0":map.get("FTOTALPRICE").toString(); 
	    				 String discount = map.get("FDISCOUNT")== null|| map.get("FDISCOUNT").toString().equals("") ? "0":map.get("FDISCOUNT").toString(); 
	    				 String income = map.get("FINCOME")== null || map.get("FINCOME").toString().equals("") ?"0":map.get("FINCOME").toString(); 
	    				 String payment = map.get("FPAYMENT")== null || map.get("FPAYMENT").toString().equals("") ? "0":map.get("FPAYMENT").toString(); 
	    				 String giftPayment = map.get("FGIFTPAYMENT")== null || map.get("FGIFTPAYMENT").toString().equals("") ? "0":map.get("FGIFTPAYMENT").toString(); 
	    				 
	    				 
	    				 //FBusType,fSign
	    				 String busType = map.get("FBUSTYPE")== null ? "":map.get("FBUSTYPE").toString(); 
	    				 //String sign = map.get("fSign")== null ? "0":map.get("fSign").toString();  
	    				 String feeItemDetailNumber = map.get("FFEEITEMDETAILNUMBER")== null ? "":map.get("FFEEITEMDETAILNUMBER").toString(); 
	    				 String isRoutine = map.get("FISROUTINE")== null || map.get("FISROUTINE").toString().equals("") ? "0":map.get("FISROUTINE").toString(); 
	    				 //String cityNumber = map.get("FCITYNUMBER")== null ? "":map.get("FCITYNUMBER").toString(); 
	    				 String forderid = map.get("FORDERID")== null ? "":map.get("FORDERID").toString(); 
	    				 
	    				 String isneedout = map.get("FISNEEDOUT")== null ? "0":map.get("FISNEEDOUT").toString(); 
	    				 if(isneedout.equals("")){
	    					 isneedout = "0";
	    				 }
	    				 String isout ="0";
	    				 String orderDetailid = map.get("FORDERDETAILID")== null ? "":map.get("FORDERDETAILID").toString(); 
	    				 String recPersonNumber = map.get("FRECPERSONNUMBER")== null ? "":map.get("FRECPERSONNUMBER").toString(); 
	    				 /*if(type.equals("ZC")){
	    					 isout ="1";
	    				 }*/
	    				 String period = businessdate;
	    				 if(isneedout.equals("1")){
	    					 period = "";
	    				 }
	    				 if(isRoutine.equals("1")){
	    					 isRoutine = "是";
	    				 }else if(isRoutine.equals("0")){
	    					 isRoutine = "否";
	    				 }
	    				 flag = true;
	    				 
	    				 String docincome = "0"; 
	    				 String zxincome = "0"; 
	    				 String countAchieve = "0";
	    				 if(payZiDuan.equals("CFPAYMENT") ){
	    					 docincome = payment;
	    					 zxincome = payment;
	    					 countAchieve = payment;
	    				 }else{  
	    					 docincome = income;
	    					 zxincome = income;
	    					 countAchieve = income;
	    				 }
	    				 
	    				 StringBuffer sbr  = new StringBuffer(" /*dialect*/ insert into CT_PAY_AchieveDetail (FID,FCreatorID,FCreateTime,FLastUpdateUserID,FLastUpdateTime, fcontrolunitid  ,fhandlerid ,cfiscount,");
	    				// sbr.append(" FbizDate,CFCity, CFClinicNumber,CFClinicName,CFCaseNumber,cfName,CFFirSource,CFSecSource,CFTerSource ,CFComplainNumber,CFComplainName,CFCreateOrg,CFCreater, CFFirVis,CFStatus,CFOrder,CFRecDotNumber,CFRecDotName,  ");
	    				 sbr.append(" FbizDate,CFCity, CFClinicNumber,CFClinicName,CFCaseNumber,cfName,CFFirSource,CFSecSource,CFTerSource ,CFComplainNumber,CFComplainName,CFCreateOrg,CFCreater, CFFirVis,CFStatus,CFOrder,  ");
	    				 sbr.append("  CFNurseNUmber,CFRecNurse,CFNurseOrderDiag, CFRecConNumber,CFRecConName,CFExcConNumber,CFExcConName,CFRecDotNumber,CFRecDotName,FNumber, ");
	    				 sbr.append(" CFFirClassNumber, CFFirClassName,CFSecClassNumber,CFSecClassName,CFFeeItemDetail,CFRecPerson,CFQty,CFOriPrice,CFTotalPrice,CFDiscount,CFIncome,CFPayment,CFGiftPayment,CFBusiType,CFCityNumber,CFFEEITEMDETAILNUMBER,CFISROUTINE,CFHisOrderId ,CFHisdetailid,CFIsneedout,CFIsout,CFRECPERSONNUMBER )  ");
	    				 sbr.append(" values(newbosid('C9F3CC10'),'"+userId+"',sysdate,'"+userId+"',sysdate, '00000000-0000-0000-0000-000000000000CCE7AED4','"+userId+"',1,");  
	    				 //sbr.append("to_date('"+date+"', 'yyyy/mm/dd'),'"+city+"','"+clinicNumber+"','"+clinicName+"','"+caseNumber+"' ,'"+patientName+"' ,'"+firSource+"' ,'"+secSource+"' ,'"+terSource+"' ,'"+complainNumber+"' ,'"+complainName+"','"+createOrg+"' ,'"+creator+"' ,'"+firVis+"' ,'"+status+"' ,'"+order+"' ,'"+recDotNumber+"' ,'"+recDotName+"' ,  "); 
	    				 sbr.append(" to_date('"+date+"', 'yyyy/mm/dd'),'"+city+"','"+clinicNumber+"','"+clinicName+"','"+caseNumber+"' ,'"+patientName+"' ,'"+firSource+"' ,'"+secSource+"' ,'"+terSource+"' ,'"+complainNumber+"' ,'"+complainName+"','"+createOrg+"' ,'"+creator+"' ,'"+firVis+"' ,'"+status+"' ,'"+order+"' , ");
	    				 sbr.append(" '"+nurseNUmber+"' ,'"+recNurse+"','"+nurseOrderDiag+"','"+recConNumber+"','"+recConName+"' ,'"+excConNumber+"' ,'"+excConName+"' ,'"+recDotNumber+"' ,'"+recDotName+"' ,'"+number+"' , "); 
	    				 sbr.append(" '"+firClassNumber+"' ,'"+firClassName+"','"+secClassNumber+"','"+secClassName+"','"+feeItemDetail+"' ,'"+recPerson+"' ,"+qty+" ,"+oriPrice+","+totalPrice+" ,"+discount+" ,"+income+" ,"+payment+" , "+giftPayment+" ,'"+busType+"','"+cityNumber+"','"+feeItemDetailNumber+"','"+isRoutine+"','"+forderid+"','"+orderDetailid+"',"+isneedout+","+isout+",'"+recPersonNumber+"' "); 
	    				 
	    				 sbr.append(  " )");
	    				 pe.getSqlList().add(sbr);
	    				 //if(type.equals("ZC") || detailMap.get(orderDetailid)==null || detailMap.get(orderDetailid).equals("") ){
	    				 //if(detailMap.get(orderDetailid)==null || detailMap.get(orderDetailid).equals("") ){
	    					 StringBuffer sbr2  = new StringBuffer(" /*dialect*/ insert into CT_PAY_AchieveDetailTem (FID,FCreatorID,FCreateTime,FLastUpdateUserID,FLastUpdateTime, fcontrolunitid  ,fhandlerid ,cfiscount,cfbusinessdate,");
		    				 // sbr2.append(" FbizDate,CFCity, CFClinicNumber,CFClinicName,CFCaseNumber,cfName,CFFirSource,CFSecSource,CFTerSource ,CFComplainNumber,CFComplainName,CFCreateOrg,CFCreater, CFFirVis,CFStatus,CFOrder,CFRecDotNumber,CFRecDotName,  ");
		    				 sbr2.append(" FbizDate,CFCity, CFClinicNumber,CFClinicName,CFCaseNumber,cfName,CFFirSource,CFSecSource,CFTerSource ,CFComplainNumber,CFComplainName,CFCreateOrg,CFCreater, CFFirVis,CFStatus,CFOrder,  ");
		    				 sbr2.append("  CFNurseNUmber,CFRecNurse,CFNurseOrderDiag, CFRecConNumber,CFRecConName,CFExcConNumber,CFExcConName,CFRecDotNumber,CFRecDotName,FNumber, ");
		    				 sbr2.append(" CFFirClassNumber, CFFirClassName,CFSecClassNumber,CFSecClassName,CFFeeItemDetail,CFRecPerson,CFQty,CFOriPrice,CFTotalPrice,CFDiscount,CFIncome,CFPayment,CFGiftPayment,CFBusiType,CFCityNumber,CFFEEITEMDETAILNUMBER,CFISROUTINE,CFHisOrderId ,CFHisdetailid,CFIsneedout,CFIsout,CFRECPERSONNUMBER,CFDocAchieve,CFZxAchieve,CFcountAchieve )  ");
		    				 sbr2.append(" values(newbosid('69F141EC'),'"+userId+"',sysdate,'"+userId+"',sysdate, '00000000-0000-0000-0000-000000000000CCE7AED4','"+userId+"', 1 , '"+period+"',");
		    				 //sbr2.append("to_date('"+date+"', 'yyyy/mm/dd'),'"+city+"','"+clinicNumber+"','"+clinicName+"','"+caseNumber+"' ,'"+patientName+"' ,'"+firSource+"' ,'"+secSource+"' ,'"+terSource+"' ,'"+complainNumber+"' ,'"+complainName+"','"+createOrg+"' ,'"+creator+"' ,'"+firVis+"' ,'"+status+"' ,'"+order+"' ,'"+recDotNumber+"' ,'"+recDotName+"' ,  "); 
		    				 sbr2.append(" to_date('"+date+"', 'yyyy/mm/dd'),'"+city+"','"+clinicNumber+"','"+clinicName+"','"+caseNumber+"' ,'"+patientName+"' ,'"+firSource+"' ,'"+secSource+"' ,'"+terSource+"' ,'"+complainNumber+"' ,'"+complainName+"','"+createOrg+"' ,'"+creator+"' ,'"+firVis+"' ,'"+status+"' ,'"+order+"' , ");
		    				 sbr2.append(" '"+nurseNUmber+"' ,'"+recNurse+"','"+nurseOrderDiag+"','"+recConNumber+"','"+recConName+"' ,'"+excConNumber+"' ,'"+excConName+"' ,'"+recDotNumber+"' ,'"+recDotName+"'  ,'"+number+"' , "); 
		    				 sbr2.append(" '"+firClassNumber+"' ,'"+firClassName+"','"+secClassNumber+"','"+secClassName+"','"+feeItemDetail+"' ,'"+recPerson+"' ,"+qty+" ,"+oriPrice+","+totalPrice+" ,"+discount+" ,"+income+" ,"+payment+" , "+giftPayment+" ,'"+busType+"','"+cityNumber+"','"+feeItemDetailNumber+"','"+isRoutine+"','"+forderid+"','"+orderDetailid+"',"+isneedout+","+isout+",'"+recPersonNumber+"' ");
		    				 sbr2.append(  " ,"+docincome+","+zxincome+" , "+countAchieve+" ");
		    				 sbr2.append(  " )");
		    				 pe.getSqlList().add(sbr2);
	    					 
	    				 //}
	    				 
	    				 String updatMidsql = "   update  HIS_EHR_REPORT  set fSign =1 ,FSYNTIME = sysdate  where  fid = '"+fidRecod+"' ";
		 	    			
		 	    		 sqls.add(updatMidsql);

	    			}
	    	    	if(list.size() > 0){
	    	    		String updatMidsql = "   update  HIS_EHR_REPORT_RECORD  set fSign =1 ,FSYNTIME = sysdate  where  id = '"+fid+"' ";
	 	    			
	 	    			sqls.add(updatMidsql);
		    		}
	    		}else{//状态修改为2
	    			String updatMidsql = "   update  HIS_EHR_REPORT_RECORD  set fSign = 2 ,FSYNTIME = sysdate  where  id = '"+fid+"' ";
	    			errorMsg = errorMsg+"日期"+fdate+"得门诊"+clinicNumber+"条数异常;"; 
	    			sqls.add(updatMidsql);
	    		}
	    		
	    	}
	    }
	    
		if(flag){
			 //  批量插入
			try {
				pe.executeUpdate(ctx);
				pool.shutdown(); 
			} catch (EASBizException e) { 
				e.printStackTrace();
				pool.shutdown(); 
			} catch (BOSException e) { 
				e.printStackTrace();
				pool.shutdown(); 
			}
			pool.shutdown(); 
		     
			String citynumber = cityNum ;
			if(citynumber.equals("CG01")){
				citynumber = "MS3101";
			}
			
			String gifamount = "0";
			String freework = "0";
			
			String docSql = " /*dialect*/  select company.fnumber,nvl(doc.CFGIFAMOUNTPRO,0) as  CFGIFAMOUNTPRO , nvl(doc.CFFREEWORKPRO,0) as CFFREEWORKPRO  from  CT_PAY_DocCurrencyPro doc  "+
					" left join t_org_company company on company.fid = doc.cfcityid    where  doc.cfbusinessdate = '"+businessdate+"'  and company.fnumber "+incityStr+" ";
			IRowSet doccityrow = DbUtil.executeQuery(ctx, docSql); 
			while(doccityrow.next()){
				gifamount = doccityrow.getString("CFGIFAMOUNTPRO").equals("")? "0": doccityrow.getString("CFGIFAMOUNTPRO");   
				freework =  doccityrow.getString("CFFREEWORKPRO").equals("")? "0": doccityrow.getString("CFFREEWORKPRO");    
				  
				if(!cityNum.equals("MS1101")){
					if(!freework.equals("0")){
						String sql1 = "/*dialect*/  update CT_PAY_AchieveDetailTem set   cfcountachieve =  nvl( cforiprice*cfqty *"+freework+",0) , cfzxachieve =  nvl( cforiprice*cfqty *"+freework+",0)  "
		    			+"where  cfcitynumber "+incityStr+"  and  to_char(fbizdate,'YYYYMM') = '"+businessdate+"'  and cfincome  =0  and  cfpayment =0 and cfbusitype = '挂号消费'"; 
		    			DbUtil.execute(ctx, sql1);
					}
					if(!gifamount.equals("0")){
						String sqlfreework = "/*dialect*/  update CT_PAY_AchieveDetailTem set  cfcountachieve =  (nvl(cfpayment,0)-(nvl(cfgiftpayment,0)*"+gifamount+")) , cfzxachieve =  (nvl(cfpayment,0)-(nvl(cfgiftpayment,0)*"+gifamount+")) "
		    			+" where  cfcitynumber "+incityStr+"  and  to_char(fbizdate,'YYYYMM') = '"+businessdate+"'   and (cfincome!=0 or cfpayment!=0) ";
		    			DbUtil.execute(ctx, sqlfreework); 
					}
				}
			}
			
			
			channelsql = " /*dialect*/ select nvl(channel.fsimplename,'CFPAYMENT') as payziduan  ,company.fnumber,cfchannelType , cfchannel  , cfdiscount ,nvl(cfincludezx,0)  as includezx, nvl(cfincludedoc,0)  as includedoc  from CT_PAY_CityChannel channel left join t_org_company company on company.fid = channel.cfcityid  "
				+"  where  channel.cfbusinessdate = '"+businessdate+"' and company.fnumber "+incityStr+" ";
			channelrow = DbUtil.executeQuery(ctx, channelsql); 
			while(channelrow.next()){ 
				BigDecimal discount =  channelrow.getBigDecimal("CFDISCOUNT");   
				String includezx =  channelrow.getString("INCLUDEZX");  
				String includedoc =  channelrow.getString("INCLUDEDOC");  
				String channelType  =  channelrow.getString("CFCHANNELTYPE");  
				String cfchannel  =  channelrow.getString("CFCHANNEL");  
				
				if(cfchannel!= null && !cfchannel.equals("")){
					cfchannel = cfchannel.replace("，", ",");
					cfchannel = "'"+cfchannel.replace(",", "','")+"'";
					if(includezx != null && "1".equals(includezx)){
						updateAchieve( ctx, incityStr,  businessdate, channelType, cfchannel, discount,"ZX",gifamount,freework);
					}
					if(includedoc != null && "1".equals(includedoc)){
						updateAchieve( ctx, incityStr,  businessdate, channelType, cfchannel, discount,"DOC",gifamount,freework);
					}
				}
			}
			
			while(existrow.next()){
				if (sqls.size() > 0) {
					EAISynTemplate.executeBatch(ctx, "04", sqls);
				}
			}
			
		}
		return  errorMsg;
    }
    public static void updateAchieve(Context ctx,String incityStr, String businessdate,String channelType,String cfchannel,BigDecimal discount,String includeType ,String gifamount,String freework ){
    	String ziduan = "";
    	if(includeType.equals("ZX")){
    		ziduan = "CFZxAchieve";
    	}else if(includeType.equals("DOC")){
    		ziduan = "CFDocAchieve";
    	} 
    	try {
    		if(incityStr.indexOf("MS3101") >=0  || incityStr.indexOf("CG01") >=0  ){
    			String sql = "/*dialect*/  update CT_PAY_AchieveDetailTem set "+ziduan+" =  cfcountachieve  *  "+discount+" where  cfcitynumber "+incityStr+"  and cffirclassNumber in ('3','4')  and  to_char(fbizdate,'YYYYMM') = '"+businessdate+"'  "+
            	" AND "+channelType+" in ("+cfchannel+") "; 
     			DbUtil.execute(ctx, sql);
    		}else{
    			String sql = "/*dialect*/  update CT_PAY_AchieveDetailTem set "+ziduan+" =   cfcountachieve *  "+discount+" where  cfcitynumber "+incityStr+"  and  to_char(fbizdate,'YYYYMM') = '"+businessdate+"'  "+
            	" AND "+channelType+" in ("+cfchannel+") "; 
     			DbUtil.execute(ctx, sql);
    		}
//    		String sql = "/*dialect*/  update CT_PAY_AchieveDetailTem set "+ziduan+" =  "+ziduan+" *  "+discount+" where  cfcitynumber "+incityStr+"  and  to_char(fbizdate,'YYYYMM') = '"+businessdate+"'  "+
//        	" AND "+channelType+" in ("+cfchannel+") "; 
//			DbUtil.execute(ctx, sql);
//    		
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
    }
    
    public static BigDecimal getSHDocAllAchieve(Context ctx,String empNum, String periodnum,String cityId,HashMap tongyongmap ,String type,String incityNumStr){
    	BigDecimal allachieve = BigDecimal.ZERO;
    	//免工作量比例
		BigDecimal freeWorkPro = BigDecimal.ZERO; 
	 
		//赠金比例
		BigDecimal gifAmountPro = BigDecimal.ZERO;  
		 
		freeWorkPro = new BigDecimal(tongyongmap.get("CFFREEWORKPRO").toString());   
		gifAmountPro =  new BigDecimal(tongyongmap.get("CFGIFAMOUNTPRO").toString());
	    
		
		String dateSql = "";
		if(type.equals("ZC")){
			dateSql = "  to_char(fbizdate, 'yyyymm') = '"+periodnum+"' and  ";
		}else if(type.equals("CBQR")){
			dateSql = "  CFBUSINESSDATE = '"+periodnum+"' and  (cfisneedout = 0 or ( cfisneedout=1 and cfisout = 1))  and  ";
		}
		StringBuffer sqlYJ = new StringBuffer(); 
		//种植免工作量业绩

		sqlYJ.append(" /*dialect*/select sum(a.sumamount)  as allachieve from ( ").append("\r\n")
		//种植非免工作量业绩
		.append(" select sum(amount) as sumamount , 'zz' as type from ( select    (nvl(sum(cfdocachieve),0))  as amount  from  CT_PAY_AchieveDetailTem  where  "+dateSql+"   cfrecdotnumber = '"+empNum+"'  and    (cfincome!=0 or cfpayment!=0) and cffirclassNumber ='3'    and cfiscount= 1  and cfcitynumber "+incityNumStr+" ) ").append("\r\n")
		 
		//隐形非免工作量业绩
		.append(" union select sum(amount) as sumamount , 'yx' as type from ( select   (nvl(sum(cfdocachieve),0))  as amount  from  CT_PAY_AchieveDetailTem  where  "+dateSql+"   cfrecdotnumber = '"+empNum+"'   and (cfincome!=0 or cfpayment!=0) and cffirclassNumber ='4' and CFISROUTINE = '否'  and cfiscount= 1 and cfcitynumber "+incityNumStr+" ) ").append("\r\n")
		 
		//常规非免工作量业绩
		.append(" union select sum(amount) as sumamount , 'gd' as type from ( select   (nvl(sum(cfdocachieve),0))  as amount  from  CT_PAY_AchieveDetailTem  where   "+dateSql+" cfrecdotnumber = '"+empNum+"'  and  (cfincome!=0 or cfpayment!=0) and cffirclassNumber ='4' and CFISROUTINE = '是'  and cfiscount= 1  and cfcitynumber "+incityNumStr+") ").append("\r\n")
		 
		//口内外非免工作量业绩
		.append(" union select sum(amount) as sumamount , 'knw' as type from ( select (nvl(sum(cfdocachieve),0))  as amount  from  CT_PAY_AchieveDetailTem  where  "+dateSql+"  cfrecdotnumber = '"+empNum+"'    and (cfincome!=0 or cfpayment!=0) and cffirclassNumber ='1'  and cfiscount= 1 and cfcitynumber "+incityNumStr+" )").append("\r\n")
		  
		//儿牙非免工作量业绩
		.append(" union select sum(amount) as sumamount , 'ey' as type from ( select (nvl(sum(cfdocachieve),0))  as amount  from  CT_PAY_AchieveDetailTem  where "+dateSql+"  cfrecdotnumber = '"+empNum+"'   and (cfincome!=0 or cfpayment!=0) and cffirclassNumber ='6'  and cfiscount= 1 and cfcitynumber "+incityNumStr+" )").append("\r\n")
		 
		//修复非免工作量业绩
		.append(" union select sum(amount) as sumamount , 'xf' as type from ( select (nvl(sum(cfdocachieve),0))  as amount  from  CT_PAY_AchieveDetailTem  where  "+dateSql+" cfrecdotnumber = '"+empNum+"'   and (cfincome!=0 or cfpayment!=0) and cffirclassNumber ='2'  and cfiscount= 1 and cfcitynumber "+incityNumStr+" )").append("\r\n")
		
		.append(" union SELECT  nvl( sum(cfzzachieve),0)+nvl(sum(cfyxjzachieve),0)+nvl(sum(cfgdjzachieve),0)+nvl(sum(cfknwachieve),0)+nvl(sum(cfxfachieve),0)+nvl(sum(cfeyachieve),0)   as   sumamount , 'import' as type  FROM  CT_PAY_DocAchieveUpdate where cfcityid = '"+cityId+"' and cfdocnumber = '"+empNum+"'    and  cfbusinessdate = '"+periodnum+"'  and ( cfiszidai = 0 or cfiszidai is null) and  fname_l2 is null   ) a "); 
		
		/*select sum(amount) as sumamount , 'freezz' as type from ( select   nvl(sum(cforiprice*cfqty)*0.6,0)*0.9 as amount  from  CT_PAY_AchieveDetailTem  where cfrecdotnumber = 'MS310101833'  and  cfclinicnumber ='MS3101WLMZ022' and  cfcitynumber = 'MS3101' and to_char(fbizdate,'YYYYMM') ='202006' and cfincome  =0  and  cfpayment =0 and cffirclassNumber ='3' and cffirsource in  ('传统推广','电商平台','渠道推广','网络推广','体检转化' ) and cfbusitype = '挂号消费'  
		union select   nvl(sum(cforiprice*cfqty)*0.6,0)  as amount  from  CT_PAY_AchieveDetailTem  where cfrecdotnumber = 'MS310101833'  and  cfclinicnumber ='MS3101WLMZ022' and  cfcitynumber = 'MS3101' and to_char(fbizdate,'YYYYMM') ='202006' and cfincome  =0  and  cfpayment =0 and cffirclassNumber ='3' and cffirsource not in  ('传统推广','电商平台','渠道推广','网络推广','体检转化' ) and cfbusitype = '挂号消费' )  */
		System.out.println("--"+sqlYJ.toString());
		
		try {
  			IRowSet yjrs = com.kingdee.eas.custom.util.DBUtil.executeQuery(ctx,sqlYJ.toString());
  			if(yjrs!=null && yjrs.size() > 0){ 
  				while(yjrs.next()){	
  					allachieve =  new BigDecimal(yjrs.getString("ALLACHIEVE"));
  				}
		  	}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   		
		  	
	  	
				
		return allachieve;
	}
    
    
    public static BigDecimal getSHFeiZiDaiAchieve(Context ctx,String empNum, String periodnum,String cityId,HashMap tongyongmap  ){
    	BigDecimal allachieve = BigDecimal.ZERO;
    	//免工作量比例
		BigDecimal freeWorkPro = BigDecimal.ZERO; 
		//一级渠道比例
		BigDecimal firSourcePro = BigDecimal.ZERO; 
		//一级渠道
		String firSource = "";
		//赠金比例
		BigDecimal gifAmountPro = BigDecimal.ZERO;  
		 
		freeWorkPro = new BigDecimal(tongyongmap.get("CFFREEWORKPRO").toString());  
		firSourcePro = new BigDecimal(tongyongmap.get("CFSOURCEPRO").toString());  
		firSource = tongyongmap.get("CFFIRSTSOURCE").toString(); 
		gifAmountPro =  new BigDecimal(tongyongmap.get("CFGIFAMOUNTPRO").toString());
		if(firSource.length() >0 ){
			String[] arr = firSource.split(",");
			firSource = "";
			for(int i=0;i<arr.length ;i++){
				firSource =  firSource+"'"+arr[i]+"',";
			}
			firSource =firSource.substring(0,firSource.length()-1);
		}   
		
    	

    	StringBuffer sqlYJ = new StringBuffer();
		sqlYJ.append(" /*dialect*/select sum(a.sumamount)  as allachieve from ( ").append("\r\n")
		//种植免工作量业绩 
		//.append(" select sum(amount) as sumamount , 'freezz' as type from ( select   nvl(sum(cforiprice*cfqty)*"+freeWorkPro+",0)*"+firSourcePro+" as amount  from  CT_PAY_AchieveDetailTem  where cfrecdotnumber = '"+empNum+"'  and  CFBUSINESSDATE  ='"+periodnum+"' and cfincome  =0  and  cfpayment =0 and cfiscount= 1 and cffirclassNumber ='3'  and cfiscount= 1 and cffirsource in ( "+firSource+" ) and cfbusitype = '挂号消费' ").append("\r\n")
		//.append(" )union ").append("\r\n")
		//种植非免工作量业绩
		.append("  select sum(amount) as sumamount , 'zz' as type from ( select    (nvl(sum(cfpayment),0)-(nvl(sum(cfgiftpayment),0)*"+gifAmountPro+"))*"+firSourcePro+" as amount  from  CT_PAY_AchieveDetailTem  where cfrecdotnumber = '"+empNum+"'  and  CFBUSINESSDATE  ='"+periodnum+"' and (cfincome!=0 or cfpayment!=0) and cffirclassNumber ='3'  and cfiscount= 1 and cffirsource in ( "+firSource+" )   ").append("\r\n")
		.append(" ) ").append("\r\n")
		
		//隐形免工作量
		//.append(" union select sum(amount) as sumamount , 'freeyx' as type from ( select   nvl(sum(cforiprice*cfqty)*"+freeWorkPro+",0)*"+firSourcePro+" as amount  from  CT_PAY_AchieveDetailTem  where cfrecdotnumber = '"+empNum+"'  and  CFBUSINESSDATE  ='"+periodnum+"' and cfincome  =0  and  cfpayment =0 and cffirclassNumber ='4' and CFISROUTINE = '否'  and cfiscount= 1 and cffirsource in ( "+firSource+" ) and cfbusitype = '挂号消费' ").append("\r\n")
		//.append(" ) ").append("\r\n")
		//隐形非免工作量业绩
		.append(" union select sum(amount) as sumamount , 'yx' as type from ( select   (nvl(sum(cfpayment),0)-(nvl(sum(cfgiftpayment),0)*"+gifAmountPro+"))*"+firSourcePro+" as amount  from  CT_PAY_AchieveDetailTem  where cfrecdotnumber = '"+empNum+"'  and  CFBUSINESSDATE  ='"+periodnum+"' and (cfincome!=0 or cfpayment!=0) and cffirclassNumber ='4' and CFISROUTINE = '否'  and cfiscount= 1 and cffirsource in ( "+firSource+" )   ").append("\r\n")
		.append(" ) ").append("\r\n")
		
		//常规免工作量
		//.append(" union select sum(amount) as sumamount , 'freegd' as type from ( select   nvl(sum(cforiprice*cfqty)*"+freeWorkPro+",0)*"+firSourcePro+" as amount  from  CT_PAY_AchieveDetailTem  where cfrecdotnumber = '"+empNum+"'  and  CFBUSINESSDATE  ='"+periodnum+"' and cfincome  =0  and  cfpayment =0 and cffirclassNumber ='4' and CFISROUTINE = '是'  and cfiscount= 1 and cffirsource in ( "+firSource+" ) and cfbusitype = '挂号消费' ").append("\r\n")
		//.append(" ) ").append("\r\n")
		//常规非免工作量业绩
		.append(" union select sum(amount) as sumamount , 'gd' as type from ( select   (nvl(sum(cfpayment),0)-(nvl(sum(cfgiftpayment),0)*"+gifAmountPro+"))*"+firSourcePro+" as amount  from  CT_PAY_AchieveDetailTem  where cfrecdotnumber = '"+empNum+"'  and  CFBUSINESSDATE  ='"+periodnum+"' and (cfincome!=0 or cfpayment!=0) and cffirclassNumber ='4' and CFISROUTINE = '是'  and cfiscount= 1 and cffirsource in ( "+firSource+" )   ").append("\r\n")
		.append(" ) ").append("\r\n")
		
		//口内外免工作量
		//.append(" union select sum(amount) as sumamount , 'freeknw' as type from ( select nvl(sum(cforiprice*cfqty)*"+freeWorkPro+",0) as amount  from  CT_PAY_AchieveDetailTem  where cfrecdotnumber = '"+empNum+"'  and  CFBUSINESSDATE  ='"+periodnum+"' and cfincome  =0  and  cfpayment =0 and cffirclassNumber ='1'  and cfbusitype = '挂号消费' and cfiscount= 1 and cffirsource in ( "+firSource+" )  )") .append("\r\n")
		//口内外非免工作量业绩
		.append(" union select sum(amount) as sumamount , 'knw' as type from ( select (nvl(sum(cfpayment),0)-(nvl(sum(cfgiftpayment),0)*"+gifAmountPro+")) as amount  from  CT_PAY_AchieveDetailTem  where cfrecdotnumber = '"+empNum+"'  and  CFBUSINESSDATE  ='"+periodnum+"' and (cfincome!=0 or cfpayment!=0) and cffirclassNumber ='1'  and cfiscount= 1 and cffirsource in ( "+firSource+" )  )").append("\r\n")
		  
		//儿牙免工作量
		//.append(" union select sum(amount) as sumamount , 'freeey' as type from ( select nvl(sum(cforiprice*cfqty)*"+freeWorkPro+",0) as amount  from  CT_PAY_AchieveDetailTem  where cfrecdotnumber = '"+empNum+"'  and  CFBUSINESSDATE  ='"+periodnum+"' and cfincome  =0  and  cfpayment =0 and cffirclassNumber ='6'  and cfbusitype = '挂号消费'  and cfiscount= 1 and cffirsource in ( "+firSource+" ) )") .append("\r\n")
		//儿牙非免工作量业绩
		.append(" union select sum(amount) as sumamount , 'ey' as type from ( select (nvl(sum(cfpayment),0)-(nvl(sum(cfgiftpayment),0)*"+gifAmountPro+")) as amount  from  CT_PAY_AchieveDetailTem  where cfrecdotnumber = '"+empNum+"'  and  CFBUSINESSDATE  ='"+periodnum+"' and (cfincome!=0 or cfpayment!=0) and cffirclassNumber ='6' and cfiscount= 1 and cffirsource in ( "+firSource+" )  )").append("\r\n")
		 
		//修复免工作量
		//.append(" union select sum(amount) as sumamount , 'freexf' as type from ( select nvl(sum(cforiprice*cfqty)*"+freeWorkPro+",0) as amount  from  CT_PAY_AchieveDetailTem  where cfrecdotnumber = '"+empNum+"'  and  CFBUSINESSDATE  ='"+periodnum+"' and cfincome  =0  and  cfpayment =0 and cffirclassNumber ='2'  and cfbusitype = '挂号消费'  and cfiscount= 1 and cffirsource in ( "+firSource+" )  )") .append("\r\n")
		//修复非免工作量业绩
		.append(" union select sum(amount) as sumamount , 'xf' as type from ( select (nvl(sum(cfpayment),0)-(nvl(sum(cfgiftpayment),0)*"+gifAmountPro+")) as amount  from  CT_PAY_AchieveDetailTem  where cfrecdotnumber = '"+empNum+"'  and  CFBUSINESSDATE  ='"+periodnum+"' and (cfincome!=0 or cfpayment!=0) and cffirclassNumber ='2'  and cfiscount= 1 and cffirsource in ( "+firSource+" ) )").append("\r\n")
		
		//牙周免工作量    牙周：一级分类洁牙牙周美白，二级分类牙周治疗、激光：全归医生    二级分类洁牙、美白（部分收费项表一）：如果有接诊护士，算接诊护士，不算接诊医生
		//
		//.append(" union select sum(amount) as sumamount , 'freeyz' as type from ( select nvl(sum(cforiprice*cfqty)*"+freeWorkPro+",0) as amount  from  CT_PAY_AchieveDetailTem  where cfrecdotnumber = '"+empNum+"'  and  CFBUSINESSDATE  ='"+periodnum+"' and cfincome  =0  and  cfpayment =0 and cffirclassNumber ='7' and cfbusitype = '挂号消费'   and cfiscount= 1 and cffirsource in ( "+firSource+" )  and   ").append("\r\n")
		//.append(" ( EXISTS (SELECT  1  FROM  CT_SRQ_ItemCheck bill  inner join CT_SRQ_ItemCheckEntry entry on entry.fparentid = bill.fid  left JOIN  CT_SRQ_Paytypeitem  second on second.fid = entry.cfseconditemid   where cfcityid = '"+cityId+"' and  cftypenumber = 'YZ' and second.fnumber = CT_PAY_AchieveDetailTem.CFSECCLASSNUMBER ) or  EXISTS (SELECT  1  FROM  CT_SRQ_ItemCheck bill  inner join CT_SRQ_ItemCheckEntry entry on entry.fparentid = bill.fid left JOIN  CT_SRQ_PayItem  item on  item.fid = entry.cfitemid  where cfcityid = '"+cityId+"' and  cftypenumber = 'YZ' and item.fnumber = CT_PAY_AchieveDetailTem.CFFEEITEMDETAILNUMBER ) ) ").append("\r\n")
		//.append(" union select nvl(sum(cforiprice*cfqty)*"+freeWorkPro+",0) as amount  from  CT_PAY_AchieveDetailTem  where cfrecdotnumber = '"+empNum+"'  and  CFBUSINESSDATE  ='"+periodnum+"' and cfincome  =0  and  cfpayment =0 and cffirclassNumber ='7'  and cfbusitype = '挂号消费'  and cfiscount= 1 and cffirsource in ( "+firSource+" )   and  not EXISTS ( SELECT 1 FROM  CT_PAY_PayPost  paypost where paypost.cfcityid = '"+cityId+"' and paypost.cfbusinessdate = '"+periodnum+"' and cfpostnumber ='HS' AND CFSTATUS = 'qy' and paypost.cfempnumber = CT_PAY_AchieveDetailTem.CFNURSENUMBER  )  and  ").append("\r\n")
		//.append(" ( EXISTS (SELECT  1  FROM  CT_SRQ_ItemCheck bill  inner join CT_SRQ_ItemCheckEntry entry on entry.fparentid = bill.fid  left JOIN  CT_SRQ_Paytypeitem  second on second.fid = entry.cfseconditemid   where cfcityid = '"+cityId+"' and  cftypenumber in ('JY','MB')  and second.fnumber = CT_PAY_AchieveDetailTem.CFSECCLASSNUMBER ) or  EXISTS (SELECT  1  FROM  CT_SRQ_ItemCheck bill  inner join CT_SRQ_ItemCheckEntry entry on entry.fparentid = bill.fid left JOIN  CT_SRQ_PayItem  item on  item.fid = entry.cfitemid  where cfcityid = '"+cityId+"' and  cftypenumber in ('JY','MB') and item.fnumber = CT_PAY_AchieveDetailTem.CFFEEITEMDETAILNUMBER ) ) )").append("\r\n")
		
		//牙周不算总业绩
		//牙周非免工作量业绩
		/*.append(" union select sum(amount) as sumamount , 'yz' as type from ( select (nvl(sum(cfpayment),0)-(nvl(sum(cfgiftpayment),0)*"+gifAmountPro+")) as amount  from  CT_PAY_AchieveDetailTem  where cfrecdotnumber = '"+empNum+"'  and  CFBUSINESSDATE  ='"+periodnum+"' and (cfincome!=0 or cfpayment!=0) and cffirclassNumber ='7'  and cfiscount= 1  and cffirsource in ( "+firSource+" )  and   ").append("\r\n")
		.append(" ( EXISTS (SELECT  1  FROM  CT_SRQ_ItemCheck bill  inner join CT_SRQ_ItemCheckEntry entry on entry.fparentid = bill.fid  left JOIN  CT_SRQ_Paytypeitem  second on second.fid = entry.cfseconditemid   where cfcityid = '"+cityId+"' and  cftypenumber = 'YZ' and second.fnumber = CT_PAY_AchieveDetailTem.CFSECCLASSNUMBER ) or  EXISTS (SELECT  1  FROM  CT_SRQ_ItemCheck bill  inner join CT_SRQ_ItemCheckEntry entry on entry.fparentid = bill.fid left JOIN  CT_SRQ_PayItem  item on  item.fid = entry.cfitemid  where cfcityid = '"+cityId+"' and  cftypenumber = 'YZ' and item.fnumber = CT_PAY_AchieveDetailTem.CFFEEITEMDETAILNUMBER ) ) ").append("\r\n")
		.append(" union select (nvl(sum(cfpayment),0)-(nvl(sum(cfgiftpayment),0)*"+gifAmountPro+")) as amount  from  CT_PAY_AchieveDetailTem  where cfrecdotnumber = '"+empNum+"'  and  CFBUSINESSDATE  ='"+periodnum+"' and (cfincome!=0 or cfpayment!=0) and cffirclassNumber ='7'  and cfiscount= 1  and cffirsource in ( "+firSource+" )   and  not EXISTS ( SELECT 1 FROM  CT_PAY_PayPost  paypost where paypost.cfcityid = '"+cityId+"' and paypost.cfbusinessdate = '"+periodnum+"' and cfpostnumber ='HS' AND CFSTATUS = 'qy' and paypost.cfempnumber = CT_PAY_AchieveDetailTem.CFNURSENUMBER  )  and  ").append("\r\n")
		.append(" ( EXISTS (SELECT  1  FROM  CT_SRQ_ItemCheck bill  inner join CT_SRQ_ItemCheckEntry entry on entry.fparentid = bill.fid  left JOIN  CT_SRQ_Paytypeitem  second on second.fid = entry.cfseconditemid   where cfcityid = '"+cityId+"' and  cftypenumber in ('JY','MB')  and second.fnumber = CT_PAY_AchieveDetailTem.CFSECCLASSNUMBER ) or  EXISTS (SELECT  1  FROM  CT_SRQ_ItemCheck bill  inner join CT_SRQ_ItemCheckEntry entry on entry.fparentid = bill.fid left JOIN  CT_SRQ_PayItem  item on  item.fid = entry.cfitemid  where cfcityid = '"+cityId+"' and  cftypenumber in ('JY','MB') and item.fnumber = CT_PAY_AchieveDetailTem.CFFEEITEMDETAILNUMBER ) ) )").append("\r\n")
		 */
		.append(" union SELECT  nvl( sum(cfzzachieve),0)+nvl(sum(cfyxjzachieve),0)+nvl(sum(cfgdjzachieve),0)+nvl(sum(cfknwachieve),0)+nvl(sum(cfxfachieve),0)+nvl(sum(cfeyachieve),0)    as   sumamount , 'import' as type  FROM  CT_PAY_DocAchieveUpdate where cfcityid = '"+cityId+"' and cfdocnumber = '"+empNum+"'    and  cfbusinessdate = '"+periodnum+"'  and   ( cfiszidai = 0 or cfiszidai is null)    ) a "); 
		
		System.out.println("--"+sqlYJ.toString());
		
		try {
  			IRowSet yjrs = com.kingdee.eas.custom.util.DBUtil.executeQuery(ctx,sqlYJ.toString());
  			if(yjrs!=null && yjrs.size() > 0){ 
  				while(yjrs.next()){	
  					allachieve =  new BigDecimal(yjrs.getString("ALLACHIEVE"));
  				}
		  	}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   		
		  	 
		return allachieve;
	}
    
    public static BigDecimal getSHZiDaiAchieve(Context ctx,String empNum, String periodnum,String cityId,HashMap tongyongmap  ){
    	BigDecimal allachieve = BigDecimal.ZERO;
    	//免工作量比例
		BigDecimal freeWorkPro = BigDecimal.ZERO; 
		//一级渠道比例
		BigDecimal firSourcePro = BigDecimal.ZERO; 
		//一级渠道
		String firSource = "";
		//赠金比例
		BigDecimal gifAmountPro = BigDecimal.ZERO;  
		 
		freeWorkPro = new BigDecimal(tongyongmap.get("CFFREEWORKPRO").toString());  
		firSourcePro = new BigDecimal(tongyongmap.get("CFSOURCEPRO").toString());  
		firSource = tongyongmap.get("CFFIRSTSOURCE").toString(); 
		gifAmountPro =  new BigDecimal(tongyongmap.get("CFGIFAMOUNTPRO").toString());
		if(firSource.length() >0 ){
			String[] arr = firSource.split(",");
			firSource = "";
			for(int i=0;i<arr.length ;i++){
				firSource =  firSource+"'"+arr[i]+"',";
			}
			firSource =firSource.substring(0,firSource.length()-1);
		}   
		
    	

		StringBuffer sqlYJ = new StringBuffer(); 
		// 自带患者的一级渠道都是不打折的取得  所以 免工作量 和 不免工作量的  都不打折扣
		sqlYJ.append(" /*dialect*/select sum(a.sumamount)  as allachieve from ( ").append("\r\n");
		//种植免工作量业绩
		//sqlYJ..append(" select sum(amount) as sumamount , 'freezz' as type from (select nvl(sum(cforiprice*cfqty)*"+freeWorkPro+",0) as amount  from  CT_PAY_AchieveDetailTem  where cfrecdotnumber = '"+empNum+"' and  CFBUSINESSDATE  and cfincome  =0  and  cfpayment =0   and cfiscount= 1 and cffirclassNumber ='3' and cffirsource not in ( "+firSource+" ) and cfbusitype = '挂号消费' )  ").append("\r\n");
		//种植非免工作量业绩 union
		sqlYJ.append("  select sum(amount) as sumamount , 'zz' as type from ( select nvl(sum(cfpayment),0)-(nvl(sum(cfgiftpayment),0)*"+gifAmountPro+") as amount  from  CT_PAY_AchieveDetailTem  where cfrecdotnumber = '"+empNum+"'   and  CFBUSINESSDATE  and (cfincome!=0 or cfpayment!=0)  and cfiscount= 1 and cffirclassNumber ='3' and cffirsource not in ( "+firSource+" )  )    ").append("\r\n");
		//隐形免工作量
		//sqlYJ.append(" union select sum(amount) as sumamount , 'freeyx' as type from (select nvl(sum(cforiprice*cfqty)*"+freeWorkPro+",0)  as amount  from  CT_PAY_AchieveDetailTem  where cfrecdotnumber = '"+empNum+"'   and  CFBUSINESSDATE  and cfincome  =0  and  cfpayment =0  and cfiscount= 1 and cffirclassNumber ='4' and CFISROUTINE = '否' and cffirsource not in ( "+firSource+" ) and cfbusitype = '挂号消费' )   ").append("\r\n");
		//隐形非免工作量业绩
		sqlYJ.append(" union select sum(amount) as sumamount , 'yx' as type from (select   nvl(sum(cfpayment),0)-(nvl(sum(cfgiftpayment),0)*0.5)  as amount  from  CT_PAY_AchieveDetailTem  where cfrecdotnumber = '"+empNum+"'   and  CFBUSINESSDATE  and (cfincome!=0 or cfpayment!=0)  and cfiscount= 1 and cffirclassNumber ='4' and CFISROUTINE = '否' and cffirsource not in ( "+firSource+" )  )  ").append("\r\n");
		//常规免工作量
		//sqlYJ.append(" union select sum(amount) as sumamount , 'freegd' as type from (select   nvl(sum(cforiprice*cfqty)*"+freeWorkPro+",0)  as amount  from  CT_PAY_AchieveDetailTem  where cfrecdotnumber = '"+empNum+"'   and  CFBUSINESSDATE  and cfincome  =0  and  cfpayment =0  and cfiscount= 1 and cffirclassNumber ='4' and CFISROUTINE = '是' and cffirsource not in ( "+firSource+" ) and cfbusitype = '挂号消费' )  ").append("\r\n");
		//常规非免工作量业绩
		sqlYJ.append(" union select sum(amount) as sumamount , 'gd' as type from (select   nvl(sum(cfpayment),0)-(nvl(sum(cfgiftpayment),0)*"+gifAmountPro+")  as amount  from  CT_PAY_AchieveDetailTem  where cfrecdotnumber = '"+empNum+"'   and  CFBUSINESSDATE  and (cfincome!=0 or cfpayment!=0)   and cfiscount= 1 and cffirclassNumber ='4' and CFISROUTINE = '是' and cffirsource not in ( "+firSource+" )  )   ").append("\r\n");
		//口内外免工作量
		//sqlYJ.append(" union select sum(amount) as sumamount , 'freeknw' as type from ( select nvl(sum(cforiprice*cfqty)*"+freeWorkPro+",0) as amount  from  CT_PAY_AchieveDetailTem  where cfrecdotnumber = '"+empNum+"'  and  CFBUSINESSDATE  and cfincome  =0  and  cfpayment =0  and cfiscount= 1 and cffirclassNumber ='1' and cffirsource not in ( "+firSource+" )  and cfbusitype = '挂号消费' )   ").append("\r\n");
		//口内外非免工作量业绩
		sqlYJ.append(" union select sum(amount) as sumamount , 'knw' as type from ( select (nvl(sum(cfpayment),0)-(nvl(sum(cfgiftpayment),0)*"+gifAmountPro+")) as amount  from  CT_PAY_AchieveDetailTem  where cfrecdotnumber = '"+empNum+"'  and  CFBUSINESSDATE  and (cfincome!=0 or cfpayment!=0)  and cfiscount= 1 and cffirsource not in ( "+firSource+" )  and cffirclassNumber ='1' )   ").append("\r\n");
		//儿牙免工作量
		//sqlYJ.append(" union select sum(amount) as sumamount , 'freeey' as type from ( select nvl(sum(cforiprice*cfqty)*"+freeWorkPro+",0) as amount  from  CT_PAY_AchieveDetailTem  where cfrecdotnumber = '"+empNum+"'  and  CFBUSINESSDATE  and cfincome  =0  and  cfpayment =0   and cfiscount= 1 and cffirclassNumber ='6' and cffirsource not in ( "+firSource+" )  and cfbusitype = '挂号消费' )  ").append("\r\n");
		//儿牙非免工作量业绩
		sqlYJ.append(" union select sum(amount) as sumamount , 'ey' as type from ( select (nvl(sum(cfpayment),0)-(nvl(sum(cfgiftpayment),0)*"+gifAmountPro+")) as amount  from  CT_PAY_AchieveDetailTem  where cfrecdotnumber = '"+empNum+"'  and  CFBUSINESSDATE  and (cfincome!=0 or cfpayment!=0)  and cfiscount= 1 and cffirsource not in ( "+firSource+" )  and cffirclassNumber ='6' )   ").append("\r\n");
		//修复免工作量
		//sqlYJ.append(" union select sum(amount) as sumamount , 'freexf' as type from ( select nvl(sum(cforiprice*cfqty)*"+freeWorkPro+",0) as amount  from  CT_PAY_AchieveDetailTem  where cfrecdotnumber = '"+empNum+"'  and  CFBUSINESSDATE  and cfincome  =0  and  cfpayment =0  and cfiscount= 1 and cffirclassNumber ='2' and cffirsource not in ( "+firSource+" )   and cfbusitype = '挂号消费' ) ").append("\r\n");
		//修复非免工作量业绩
		sqlYJ.append(" union select sum(amount) as sumamount , 'xf' as type from ( select (nvl(sum(cfpayment),0)-(nvl(sum(cfgiftpayment),0)*"+gifAmountPro+")) as amount  from  CT_PAY_AchieveDetailTem  where cfrecdotnumber = '"+empNum+"'  and  CFBUSINESSDATE  and (cfincome!=0 or cfpayment!=0)  and cfiscount= 1 and cffirsource not in ( "+firSource+" )  and cffirclassNumber ='2' )   ").append("\r\n");
		//牙周免工作量    牙周：一级分类洁牙牙周美白，二级分类牙周治疗、激光：全归医生    二级分类洁牙、美白（部分收费项表一）：如果有接诊护士，算接诊护士，不算接诊医生
		//sqlYJ.append(" union select sum(amount) as sumamount , 'freeyz' as type from ( select nvl(sum(cforiprice*cfqty)*"+freeWorkPro+",0) as amount  from  CT_PAY_AchieveDetailTem  where cfrecdotnumber = '"+empNum+"'  and  CFBUSINESSDATE  and cfincome  =0  and  cfpayment =0 and cffirclassNumber ='7' and cfbusitype = '挂号消费'  and cfiscount= 1 and cffirsource not in ( "+firSource+" )  and   ").append("\r\n");
		//sqlYJ.append(" ( EXISTS (SELECT  1  FROM  CT_SRQ_ItemCheck bill  inner join CT_SRQ_ItemCheckEntry entry on entry.fparentid = bill.fid  left JOIN  CT_SRQ_Paytypeitem  second on second.fid = entry.cfseconditemid   where cfcityid = '"+cityId+"' and  cftypenumber = 'YZ' and second.fnumber = CT_PAY_AchieveDetailTem.CFSECCLASSNUMBER ) or  EXISTS (SELECT  1  FROM  CT_SRQ_ItemCheck bill  inner join CT_SRQ_ItemCheckEntry entry on entry.fparentid = bill.fid left JOIN  CT_SRQ_PayItem  item on  item.fid = entry.cfitemid  where cfcityid = '"+cityId+"' and  cftypenumber = 'YZ' and item.fnumber = CT_PAY_AchieveDetailTem.CFFEEITEMDETAILNUMBER ) )   ").append("\r\n");
		//sqlYJ.append("  union select nvl(sum(cforiprice*cfqty)*"+freeWorkPro+",0) as amount  from  CT_PAY_AchieveDetailTem  where cfrecdotnumber = '"+empNum+"'  and  CFBUSINESSDATE  and cfincome  =0  and  cfpayment =0 and cffirclassNumber ='7'  and cfbusitype = '挂号消费'  and cfiscount= 1 and cffirsource not in ( "+firSource+" )  and  not EXISTS ( SELECT 1 FROM  CT_PAY_PayPost  paypost where paypost.cfcityid = '"+cityId+"' and paypost.cfbusinessdate = '"+periodnum+"' and cfpostnumber ='HS' AND CFSTATUS = 'qy' and paypost.cfempnumber = CT_PAY_AchieveDetailTem.CFNURSENUMBER  )  and  ").append("\r\n");
		//sqlYJ.append("  ( EXISTS (SELECT  1  FROM  CT_SRQ_ItemCheck bill  inner join CT_SRQ_ItemCheckEntry entry on entry.fparentid = bill.fid  left JOIN  CT_SRQ_Paytypeitem  second on second.fid = entry.cfseconditemid   where cfcityid = '"+cityId+"' and  cftypenumber in ('JY','MB')  and second.fnumber = CT_PAY_AchieveDetailTem.CFSECCLASSNUMBER ) or  EXISTS (SELECT  1  FROM  CT_SRQ_ItemCheck bill  inner join CT_SRQ_ItemCheckEntry entry on entry.fparentid = bill.fid left JOIN  CT_SRQ_PayItem  item on  item.fid = entry.cfitemid  where cfcityid = '"+cityId+"' and  cftypenumber in ('JY','MB') and item.fnumber = CT_PAY_AchieveDetailTem.CFFEEITEMDETAILNUMBER ) ) )  ").append("\r\n");
		
		//牙周不算总业绩
		//牙周非免工作量业绩
		/*sqlYJ.append(" union select sum(amount) as sumamount , 'yz' as type from ( select (nvl(sum(cfpayment),0)-(nvl(sum(cfgiftpayment),0)*"+gifAmountPro+")) as amount  from  CT_PAY_AchieveDetailTem  where cfrecdotnumber = '"+empNum+"'  and  CFBUSINESSDATE  and (cfincome!=0 or cfpayment!=0) and cffirclassNumber ='7'  and cfiscount= 1 and cffirsource not in ( "+firSource+" )  and   ").append("\r\n");
		sqlYJ.append(" ( EXISTS (SELECT  1  FROM  CT_SRQ_ItemCheck bill  inner join CT_SRQ_ItemCheckEntry entry on entry.fparentid = bill.fid  left JOIN  CT_SRQ_Paytypeitem  second on second.fid = entry.cfseconditemid   where cfcityid = '"+cityId+"' and  cftypenumber = 'YZ' and second.fnumber = CT_PAY_AchieveDetailTem.CFSECCLASSNUMBER ) or  EXISTS (SELECT  1  FROM  CT_SRQ_ItemCheck bill  inner join CT_SRQ_ItemCheckEntry entry on entry.fparentid = bill.fid left JOIN  CT_SRQ_PayItem  item on  item.fid = entry.cfitemid  where cfcityid = '"+cityId+"' and  cftypenumber = 'YZ' and item.fnumber = CT_PAY_AchieveDetailTem.CFFEEITEMDETAILNUMBER ) )   ").append("\r\n");
		sqlYJ.append(" union select (nvl(sum(cfpayment),0)-(nvl(sum(cfgiftpayment),0)*"+gifAmountPro+")) as amount  from  CT_PAY_AchieveDetailTem  where cfrecdotnumber = '"+empNum+"'  and  CFBUSINESSDATE  and (cfincome!=0 or cfpayment!=0) and cffirclassNumber ='7'  and cfiscount= 1 and cffirsource not in ( "+firSource+" )  and  not EXISTS ( SELECT 1 FROM  CT_PAY_PayPost  paypost where paypost.cfcityid = '"+cityId+"' and paypost.cfbusinessdate = '"+periodnum+"' and cfpostnumber ='HS' AND CFSTATUS = 'qy' and paypost.cfempnumber = CT_PAY_AchieveDetailTem.CFNURSENUMBER  )  and   ").append("\r\n");
		sqlYJ.append(" ( EXISTS (SELECT  1  FROM  CT_SRQ_ItemCheck bill  inner join CT_SRQ_ItemCheckEntry entry on entry.fparentid = bill.fid  left JOIN  CT_SRQ_Paytypeitem  second on second.fid = entry.cfseconditemid   where cfcityid = '"+cityId+"' and  cftypenumber in ('JY','MB')  and second.fnumber = CT_PAY_AchieveDetailTem.CFSECCLASSNUMBER ) or  EXISTS (SELECT  1  FROM  CT_SRQ_ItemCheck bill  inner join CT_SRQ_ItemCheckEntry entry on entry.fparentid = bill.fid left JOIN  CT_SRQ_PayItem  item on  item.fid = entry.cfitemid  where cfcityid = '"+cityId+"' and  cftypenumber in ('JY','MB') and item.fnumber = CT_PAY_AchieveDetailTem.CFFEEITEMDETAILNUMBER ) ) )").append("\r\n");
		*/
		sqlYJ.append(" union SELECT  nvl( sum(cfzzachieve),0)+nvl(sum(cfyxjzachieve),0)+nvl(sum(cfgdjzachieve),0)+nvl(sum(cfknwachieve),0)+nvl(sum(cfxfachieve),0)+nvl(sum(cfeyachieve),0)    as   sumamount , 'import' as type  FROM  CT_PAY_DocAchieveUpdate where cfcityid = '"+cityId+"' and cfdocnumber = '"+empNum+"'    and  cfbusinessdate = '"+periodnum+"'  and   cfiszidai = 1   ) a ");
		System.out.println("--"+sqlYJ.toString());
		
		try {
  			IRowSet yjrs = com.kingdee.eas.custom.util.DBUtil.executeQuery(ctx,sqlYJ.toString());
  			if(yjrs!=null && yjrs.size() > 0){ 
  				while(yjrs.next()){	
  					allachieve =  new BigDecimal(yjrs.getString("ALLACHIEVE"));
  				}
		  	}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   		
		  	 
		return allachieve;
	}
    
    
    public static void setCityAchieveMsg(Context ctx,String cityNumber, String period ,String cityName) {
    	 
    	String includeCitySql = " SELECT billorg.fid as bcityid ,billorg.fnumber as bcitynumber , entryorg.fid as ecityid ,entryorg.fnumber  as ecitynumber  from  CT_PAY_PayCity "+
    	" bill left join CT_PAY_PayCityEntry entry on bill.fid = entry.fparentid  left join   T_ORG_BaseUnit billorg on billorg.fid = bill.cfcityid "+
    	" left join   T_ORG_BaseUnit entryorg on entryorg.fid = entry.cfincludecityid where billorg.fnumber = '"+cityNumber+"' ";
		IRowSet includecityrow;
		try {
			includecityrow = DbUtil.executeQuery(ctx, includeCitySql);
			
			HashMap<String,ArrayList<String>>  incityMap = new HashMap<String,ArrayList<String>>();
			ArrayList<String> cityArray = new ArrayList<String>();
			
			try {
				while(includecityrow.next()){
					String bcityid =  includecityrow.getString("BCITYID"); 
					String bcityNumber = includecityrow.getString("BCITYNUMBER");  
					
					String ecityid =  includecityrow.getString("ECITYID"); 
					String ecityNumber = includecityrow.getString("ECITYNUMBER");  
					
					cityArray.add(ecityNumber); 
					
				}
				incityMap.put(cityNumber, cityArray);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		    
		    String sql = " select * from  EAS_HIS_CITYACHIEVE where citynumber='"+cityNumber+"' and period='"+period+"'  ";
				List<Map<String, Object>> rets = EAISynTemplate.query(ctx, "04", sql);  
				if(rets.size() >0){
					
					for(int i= 0 ;i<cityArray.size(); i++ ){  
				        String incCity = cityArray.get(i);
				        String updatesql = " update  EAS_HIS_CITYACHIEVE set eassign=0 , hissign=0 where citynumber='"+incCity+"' and period='"+period+"'  ";
						EAISynTemplate.execute(ctx, "04", updatesql);
				    }  
					 
				}else{
					
					String sformat = "MMddhhmmssSSS";
					int num = 3;
					String idStr = getDate(sformat) + getRandomNum(num);
					Long id = Long.valueOf(idStr);
					for(int i= 0 ;i<cityArray.size(); i++ ){  
				        String incCity = cityArray.get(i);
				        
				        if(incCity.equals(cityNumber)){
				        	String insertSql =" insert into EAS_HIS_CITYACHIEVE (id,citynumber,cityname,period,eassign,hissign,IGNORE)values("+id+",'"+cityNumber+"','"+cityName+"','"+period+"',0,0,0)";
							EAISynTemplate.execute(ctx, "04", insertSql);
				        }else if(incCity.equals("CG01")){
				        	String insertSql =" insert into EAS_HIS_CITYACHIEVE (id,citynumber,cityname,period,eassign,hissign,IGNORE)values("+id+",'CG01','上海参股店','"+period+"',0,0,1)";
							EAISynTemplate.execute(ctx, "04", insertSql);
				        } 
				    }   
				}  
		} catch (BOSException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
	}
    

	public static String getDate(String sformat) {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat(sformat);
		String dateString = formatter.format(currentTime);
		return dateString;
	}
	public static String getRandomNum(int num){
		String numStr = "";
		for(int i = 0; i < num; i++){
			numStr += (int)(10*(Math.random()));
		}
		return numStr;
	}
}
