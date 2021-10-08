package com.kingdee.eas.mw.pay.app;

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

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.util.BOSUuid;
import com.kingdee.eas.base.core.fm.ContextHelperFactory;
import com.kingdee.eas.basedata.framework.app.ParallelSqlExecutor;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.basedata.org.CtrlUnitInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.custom.EAISynTemplate;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.mw.pay.AchieveDetailInfo;
import com.kingdee.eas.mw.pay.ErrorAchieveFactory;
import com.kingdee.eas.mw.pay.ErrorAchieveInfo;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.jdbc.rowset.IRowSet;

public class AchieveDetailControllerBeanEx extends com.kingdee.eas.mw.pay.app.AchieveDetailControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.mw.pay.app.AchieveDetailControllerBeanEx");
    
    
    @Override
	protected void _syncMiddata(Context ctx, IObjectValue model)
			throws BOSException { 
    	String businessdate = "202006";
		// TODO Auto-generated method stub
    	try {
    		if(businessdate== null ||businessdate.equals("")|| businessdate.length() != 6){
    			Calendar cal = Calendar.getInstance();
                cal.setTime(new Date());
                cal.add(Calendar.MONTH, -1);
                Date date3 = cal.getTime();
                SimpleDateFormat format3= new SimpleDateFormat("yyyyMM");
                businessdate = format3.format(date3);   
    		}  
	    	//先处理正常城市的
	    	String citysql = "/*dialect*/ select city.CFRule as rule ,baseunit.fnumber  as citynumer  from  CT_PAY_PayCity city  left join T_ORG_BaseUnit baseunit on baseunit.fid =city.cfcityid  where city.CFRule = 'ZC' ";
	    	IRowSet cityrow = DbUtil.executeQuery(ctx, citysql); 
			while(cityrow.next()){
				String type =  cityrow.getString("RULE"); 
				String cityNumber = cityrow.getString("CITYNUMBER"); 
				SyncAchieveRepot(  ctx, businessdate, cityNumber,type);
			}
			
			//处理按照成本和对的
			
			//先查询中间库
			String midSql = " /*dialect*/select CITYNUMBER , CITYNAME  from  EAS_HIS_CITYACHIEVE where PERIOD='"+businessdate+"' and EASSIGN = 0 and HISSIGN = 1 ";
			List<Map<String, Object>> listMid = EAISynTemplate.query(ctx, "04",midSql); 
		    for(Map<String, Object> mapMid : listMid){
		    	String cityNumber = mapMid.get("CITYNUMBER").toString();
		    	String cityName = mapMid.get("CITYNAME").toString();
		    	SyncAchieveRepot(ctx, businessdate, cityNumber,"CBQR");
		    	
		    	
		    	//-----------------------------
		    	
		    	ExecutorService pool = Executors.newFixedThreadPool(6);
			    ParallelSqlExecutor pe = new ParallelSqlExecutor(pool); 
			    
		    	CoreBaseCollection collection = new CoreBaseCollection();
		    	HashMap<String,String> detailMap = new HashMap<String,String>();
		    	//查询这个城市 需要出库  未出库的 所有单据
		    	String  allAchieve = "/*dialect*/select  detail.CFHisdetailid as detailid ,  to_char(detail.fbizdate,'YYYYMM') as businessdate  CT_PAY_AchieveDetail detail where  detail.CFIsneedout =1 and detail.CFIsout=1 and  ";
		    	IRowSet allrow = DbUtil.executeQuery(ctx, allAchieve); 
				while(allrow.next()){
					String detailid =  allrow.getString("DETAILID"); 
					String period = allrow.getString("BUSINESSDATE");  
					detailMap.put(detailid, period);
				}
		    	
		    	String sqlC = " city.fnumber "; 
		    	if(cityNumber.equals("MS3101")){
		    		sqlC = sqlC + " in ('MS3101','CG01') ";
		    	}else{
		    		sqlC = sqlC + " ='"+cityNumber+"' ";
		    	}
		    	//查询指定期间的销售出库单
		    	String saleSql  = "/*dialect*/ SELECT   city.fid as cityid ,company.fid as comid, bill.fnumber as billNumber, bill.CFHISREQID as hisreqid ,  entry.CFHISSFXM as SFXM ,entry.CFHISSFXMID as SFXMid  ,entry.CFSALEENTRYID as detailid "+ 
		    	" FROM  T_IM_SALEISSUEBILL bill  inner join T_IM_SALEISSUEentry  entry on bill.fid = entry.FPARENTID  and bill.fmonth  = "+businessdate+"  inner join  T_ORG_BaseUnit company on bill.FSTORAGEORGUNITID = company.fid  inner join T_ORG_BaseUnit city on city.fid= company.FPARENTID "+
		    	" where  "+sqlC +" and entry.CFHISMINGXIID is not null and  entry.CFHISSFXMID is not null and   bill.cfhisdanjubianma is not null  and bill.CFHISREQID is not null  and  entry.CFSALEENTRYID is not null ";
		    	IRowSet salerow = DbUtil.executeQuery(ctx, saleSql); 
				while(salerow.next()){
					String cityid =  salerow.getString("CITYID"); 
					String comid =  salerow.getString("COMPANYID"); 
					String billNumber =  salerow.getString("BILLNUMBER"); 
					String hisreqid =  salerow.getString("HISREQID"); 
					
					String sfxm = cityrow.getString("SFXM");  
					String sfxmid = cityrow.getString("SFXMID");  
					String detailid = cityrow.getString("DETAILID");  
					
					
					if(detailMap.get(detailid)== null || detailMap.get(detailid).equals("")){
						//异常数据 存下来
						ErrorAchieveInfo info = new ErrorAchieveInfo();
						CtrlUnitInfo   cityinfo= new CtrlUnitInfo();
						cityinfo.setId(BOSUuid.read(cityid)); 
						info.setCity(cityinfo);
						CompanyOrgUnitInfo  cominfo = new CompanyOrgUnitInfo ();
						cominfo.setId(BOSUuid.read(comid));
						info.setClinic(cominfo);
						
						info.setBusinessDate(businessdate);
						info.setSaleoutNumber(billNumber);
						info.setHisorderid(hisreqid);
						info.setHisorderDetailid(detailid);
						info.setItemNumber(sfxmid);
						info.setItemName(sfxm);
						collection.add(info);
					}else{
						String thisPeriod = detailMap.get(detailid);
						if(thisPeriod.equals(businessdate)){
							String updateSql = " update CT_PAY_AchieveDetail set cfisout = 1 where  CFHisdetailid = '"+detailid+"'  ";
							String updateTemSql = " update CT_PAY_AchieveDetailTem set cfisout = 1 where  CFHisdetailid = '"+detailid+"'  ";
							pe.getSqlList().add(updateSql);
							pe.getSqlList().add(updateTemSql);
						}else{
							String updateTemSql = " update CT_PAY_AchieveDetailTem set cfbusinessdate = '"+businessdate+"' where  CFHisdetailid = '"+detailid+"'  ";
							pe.getSqlList().add(updateTemSql);
						}
					}
				}

				ErrorAchieveFactory.getLocalInstance(ctx).save(collection);  
				if(pe.getSqlList().size() >0 ){
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
				      
				}
		    	 
		    }
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
	} 
    
    private void SyncAchieveRepot(Context ctx,String businessdate,String cityNum,String type) throws Exception{
    	
    	List<String> sqls = new ArrayList<String>();
    	ExecutorService pool = Executors.newFixedThreadPool(6);
	    ParallelSqlExecutor pe = new ParallelSqlExecutor(pool); 
	    String userId = ContextHelperFactory.getLocalInstance(ctx).getCurrentUser().getId().toString(); 
	    boolean flag = false;
	    Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    
		HashMap<String,String> detailMap = new HashMap<String,String>();
		//校验信息是否存在
		String existSql = " SELECT count(1) as C FROM   CT_PAY_AchieveDetail  where  cfcitynumber = '"+cityNum+"' and  to_char(fbizdate,'YYYYMM') ='"+businessdate+"'    ";
		IRowSet existrow = DbUtil.executeQuery(ctx, existSql); 
		while(existrow.next()){
			BigDecimal count =  existrow.getBigDecimal("C");  
			if(count.compareTo(BigDecimal.ZERO)>0){
				//说明只存在  需要删除
				String deleteSql = " delete CT_PAY_AchieveDetail where  cfcitynumber = '"+cityNum+"' and  to_char(fbizdate,'YYYYMM') ='"+businessdate+"'    ";
				
				String deleteTemSql = " delete CT_PAY_AchieveDetailTem where  cfcitynumber = '"+cityNum+"' and  to_char(fbizdate,'YYYYMM') ='"+businessdate+"' and cfbusinessdate = '"+businessdate+"'   ";
				DbUtil.execute(ctx, deleteSql); 
				DbUtil.execute(ctx, deleteTemSql); 
				
				String sqldetail = " select  CFFEEITEMDETAILNUMBER   from  CT_PAY_AchieveDetailTem where  cfcitynumber = '"+cityNum+"' and  to_char(fbizdate,'YYYYMM') ='"+businessdate+"' and cfbusinessdate != '"+businessdate+"'  ";
				IRowSet detailrow = DbUtil.executeQuery(ctx, sqldetail); 
				while(detailrow.next()){
					String feeItemDetailNumber = detailrow.getObject("FFEEITEMDETAILNUMBER")== null ? "":detailrow.getObject("FFEEITEMDETAILNUMBER").toString(); 
					if(!feeItemDetailNumber.equals("")){
						detailMap.put(feeItemDetailNumber, feeItemDetailNumber);
					}
					
				} 
			}
		}
		//删除信息之后重新进行同步
	    String sqlClinic = " select  id, FDate,FCityNumber ,FClinicNumber,FRecordCount  from HIS_EHR_REPORT_RECORD where fSign = 0 and FCITYNUMBER = '"+cityNum+"'and substr(replace(fdate,'-',''),0,6)='"+businessdate+"'  ";
	    List<Map<String, Object>> listClinic = EAISynTemplate.query(ctx, "04",sqlClinic.toString());
	    
	    for(Map<String, Object> mapClinic : listClinic){
	    	String fid = mapClinic.get("ID")== null ? "":mapClinic.get("ID").toString(); 
	    	String cityNumber = mapClinic.get("FCITYNUMBER")== null ? "":mapClinic.get("FCITYNUMBER").toString(); 
	    	String clinicNumber = mapClinic.get("FCLINICNUMBER")== null ? "":mapClinic.get("FCLINICNUMBER").toString(); 
	    	String recordCount = mapClinic.get("FRECORDCOUNT")== null ? "0":mapClinic.get("FRECORDCOUNT").toString(); 
	    	String fdate = mapClinic.get("FDATE")== null ? "":mapClinic.get("FDATE").toString(); 
	    	 
	    	
	    	String sqlCheck = "select count(1) as fcount from HIS_EHR_report where fSign = 0  and FCityNumber='"+cityNumber+"' and FClinicNumber='"+clinicNumber+"' and FDate = '"+fdate+"'";
	    	List<Map<String, Object>> listCheck = EAISynTemplate.query(ctx, "04",sqlCheck.toString());
	    	
	    	for (Map<String, Object> mapCheck : listCheck) {
	    		String thisCount = mapCheck.get("FCOUNT")== null ? "":mapCheck.get("FCOUNT").toString();   
	    		
	    		if(Integer.parseInt(thisCount) == Integer.parseInt(recordCount) ){
	    			String sql = " select  FID,FDate,FCityNumber,FCity, FClinicNumber,FClinicName,FCaseNumber,FPatientName,FFirSource,FSecSource,FTerSource ,FComplainNumber,FComplainName,FCreateOrg,FCreator, FFirVis,FStatus,FOrder,FRecDotNumber,FRecDotName, " +
	    			" FNurseNUmber,FRecNurse,FNurseOrderDiag, FRecConNumber,FRecConName,FExcConNumber,FExcConName,FRecPonDotNumber,FRecPonDotName,FNumber,FCreatorNumber,FCreatorName, " +
	    			" FFirClassNumber, FFirClassName,FSecClassNumber,FSecClassName,FFeeItemDetail,FRecPerson,FQty,FOriPrice,FTotalPrice,FDiscount,FIncome,FPayment,FGiftPayment, " +
	    			" FBusType,fSign,FsynTime ,FsynLog,FFeeItemDetailNumber ,FIsRoutine ,forderid ,FISNEEDOUT,FORDERDETAILID  from HIS_EHR_report where fSign = 0  and FCityNumber='"+cityNumber+"' and FClinicNumber='"+clinicNumber+"' and FDate='"+fdate+"'";
	    	    
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
	    				 
	    				 String isneedout = map.get("FISNEEDOUT")== null ? "1":map.get("FISNEEDOUT").toString(); 
	    				 String isout ="0";
	    				 String orderDetailid = map.get("FORDERDETAILID")== null ? "":map.get("FORDERDETAILID").toString(); 
	    				 if(type.equals("ZC")){
	    					 isout ="1";
	    				 }
	    				
	    				 if(isRoutine.equals("1")){
	    					 isRoutine = "是";
	    				 }else if(isRoutine.equals("0")){
	    					 isRoutine = "否";
	    				 }
	    				 flag = true;
	    				 StringBuffer sbr  = new StringBuffer(" /*dialect*/ insert into CT_PAY_AchieveDetail (FID,FCreatorID,FCreateTime,FLastUpdateUserID,FLastUpdateTime, fcontrolunitid  ,fhandlerid ,cfiscount,");
	    				// sbr.append(" FbizDate,CFCity, CFClinicNumber,CFClinicName,CFCaseNumber,cfName,CFFirSource,CFSecSource,CFTerSource ,CFComplainNumber,CFComplainName,CFCreateOrg,CFCreater, CFFirVis,CFStatus,CFOrder,CFRecDotNumber,CFRecDotName,  ");
	    				 sbr.append(" FbizDate,CFCity, CFClinicNumber,CFClinicName,CFCaseNumber,cfName,CFFirSource,CFSecSource,CFTerSource ,CFComplainNumber,CFComplainName,CFCreateOrg,CFCreater, CFFirVis,CFStatus,CFOrder,  ");
	    				 sbr.append("  CFNurseNUmber,CFRecNurse,CFNurseOrderDiag, CFRecConNumber,CFRecConName,CFExcConNumber,CFExcConName,CFRecDotNumber,CFRecDotName,FNumber, ");
	    				 sbr.append(" CFFirClassNumber, CFFirClassName,CFSecClassNumber,CFSecClassName,CFFeeItemDetail,CFRecPerson,CFQty,CFOriPrice,CFTotalPrice,CFDiscount,CFIncome,CFPayment,CFGiftPayment,CFBusiType,CFCityNumber,CFFEEITEMDETAILNUMBER,CFISROUTINE,CFHisOrderId ,CFHisdetailid,CFIsneedout,CFIsout )  ");
	    				 sbr.append(" values(newbosid('C9F3CC10'),'"+userId+"',sysdate,'"+userId+"',sysdate, '00000000-0000-0000-0000-000000000000CCE7AED4','"+userId+"',1,");  
	    				 //sbr.append("to_date('"+date+"', 'yyyy/mm/dd'),'"+city+"','"+clinicNumber+"','"+clinicName+"','"+caseNumber+"' ,'"+patientName+"' ,'"+firSource+"' ,'"+secSource+"' ,'"+terSource+"' ,'"+complainNumber+"' ,'"+complainName+"','"+createOrg+"' ,'"+creator+"' ,'"+firVis+"' ,'"+status+"' ,'"+order+"' ,'"+recDotNumber+"' ,'"+recDotName+"' ,  "); 
	    				 sbr.append(" to_date('"+date+"', 'yyyy/mm/dd'),'"+city+"','"+clinicNumber+"','"+clinicName+"','"+caseNumber+"' ,'"+patientName+"' ,'"+firSource+"' ,'"+secSource+"' ,'"+terSource+"' ,'"+complainNumber+"' ,'"+complainName+"','"+createOrg+"' ,'"+creator+"' ,'"+firVis+"' ,'"+status+"' ,'"+order+"' , ");
	    				 sbr.append(" '"+nurseNUmber+"' ,'"+recNurse+"','"+nurseOrderDiag+"','"+recConNumber+"','"+recConName+"' ,'"+excConNumber+"' ,'"+excConName+"' ,'"+recDotNumber+"' ,'"+recDotName+"' ,'"+number+"' , "); 
	    				 sbr.append(" '"+firClassNumber+"' ,'"+firClassName+"','"+secClassNumber+"','"+secClassName+"','"+feeItemDetail+"' ,'"+recPerson+"' ,"+qty+" ,"+oriPrice+","+totalPrice+" ,"+discount+" ,"+income+" ,"+payment+" , "+giftPayment+" ,'"+busType+"','"+cityNumber+"','"+feeItemDetailNumber+"','"+isRoutine+"','"+forderid+"','"+orderDetailid+"',"+isneedout+","+isout+" "); 
	    				 
	    				 sbr.append(  " )");
	    				 pe.getSqlList().add(sbr);
	    				 if(!type.equals("ZC") && detailMap.get(orderDetailid).equals("")){
	    					 
	    					 StringBuffer sbr2  = new StringBuffer(" /*dialect*/ insert into CT_PAY_AchieveDetailTem (FID,FCreatorID,FCreateTime,FLastUpdateUserID,FLastUpdateTime, fcontrolunitid  ,fhandlerid ,cfiscount,cfbusinessdate,");
		    				 // sbr2.append(" FbizDate,CFCity, CFClinicNumber,CFClinicName,CFCaseNumber,cfName,CFFirSource,CFSecSource,CFTerSource ,CFComplainNumber,CFComplainName,CFCreateOrg,CFCreater, CFFirVis,CFStatus,CFOrder,CFRecDotNumber,CFRecDotName,  ");
		    				 sbr2.append(" FbizDate,CFCity, CFClinicNumber,CFClinicName,CFCaseNumber,cfName,CFFirSource,CFSecSource,CFTerSource ,CFComplainNumber,CFComplainName,CFCreateOrg,CFCreater, CFFirVis,CFStatus,CFOrder,  ");
		    				 sbr2.append("  CFNurseNUmber,CFRecNurse,CFNurseOrderDiag, CFRecConNumber,CFRecConName,CFExcConNumber,CFExcConName,CFRecDotNumber,CFRecDotName,FNumber, ");
		    				 sbr2.append(" CFFirClassNumber, CFFirClassName,CFSecClassNumber,CFSecClassName,CFFeeItemDetail,CFRecPerson,CFQty,CFOriPrice,CFTotalPrice,CFDiscount,CFIncome,CFPayment,CFGiftPayment,CFBusiType,CFCityNumber,CFFEEITEMDETAILNUMBER,CFISROUTINE,CFHisOrderId ,CFHisdetailid,CFIsneedout,CFIsout )  ");
		    				 sbr2.append(" values(newbosid('69F141EC'),'"+userId+"',sysdate,'"+userId+"',sysdate, '00000000-0000-0000-0000-000000000000CCE7AED4','"+userId+"', 1 , '"+businessdate+"',");
		    				 //sbr2.append("to_date('"+date+"', 'yyyy/mm/dd'),'"+city+"','"+clinicNumber+"','"+clinicName+"','"+caseNumber+"' ,'"+patientName+"' ,'"+firSource+"' ,'"+secSource+"' ,'"+terSource+"' ,'"+complainNumber+"' ,'"+complainName+"','"+createOrg+"' ,'"+creator+"' ,'"+firVis+"' ,'"+status+"' ,'"+order+"' ,'"+recDotNumber+"' ,'"+recDotName+"' ,  "); 
		    				 sbr2.append(" to_date('"+date+"', 'yyyy/mm/dd'),'"+city+"','"+clinicNumber+"','"+clinicName+"','"+caseNumber+"' ,'"+patientName+"' ,'"+firSource+"' ,'"+secSource+"' ,'"+terSource+"' ,'"+complainNumber+"' ,'"+complainName+"','"+createOrg+"' ,'"+creator+"' ,'"+firVis+"' ,'"+status+"' ,'"+order+"' , ");
		    				 sbr2.append(" '"+nurseNUmber+"' ,'"+recNurse+"','"+nurseOrderDiag+"','"+recConNumber+"','"+recConName+"' ,'"+excConNumber+"' ,'"+excConName+"' ,'"+recDotNumber+"' ,'"+recDotName+"'  ,'"+number+"' , "); 
		    				 sbr2.append(" '"+firClassNumber+"' ,'"+firClassName+"','"+secClassNumber+"','"+secClassName+"','"+feeItemDetail+"' ,'"+recPerson+"' ,"+qty+" ,"+oriPrice+","+totalPrice+" ,"+discount+" ,"+income+" ,"+payment+" , "+giftPayment+" ,'"+busType+"','"+cityNumber+"','"+feeItemDetailNumber+"','"+isRoutine+"','"+forderid+"','"+orderDetailid+"',"+isneedout+","+isout+" ");
		    				 
		    				 sbr2.append(  " )");
		    				 pe.getSqlList().add(sbr2);
	    				 }
	    				 
	    				 
	    				 String updatMidsql = "   update  HIS_EHR_REPORT  set fSign =1 ,FSYNTIME = sysdate  where  fid = '"+fidRecod+"' ";
		 	    			
		 	    			sqls.add(updatMidsql);

	    			}
	    	    	if(list.size() > 0){
	    	    		String updatMidsql = "   update  HIS_EHR_REPORT_RECORD  set fSign =1 ,FSYNTIME = sysdate  where  id = '"+fid+"' ";
	 	    			
	 	    			sqls.add(updatMidsql);
		    		}
	    		}else{//状态修改为2
	    			String updatMidsql = "   update  HIS_EHR_REPORT_RECORD  set fSign = 2 ,FSYNTIME = sysdate  where  id = '"+fid+"' ";
	    			
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
		     
			if (sqls.size() > 0) {
				EAISynTemplate.executeBatch(ctx, "04", sqls);
			}
		}
    }
    
    
}				
