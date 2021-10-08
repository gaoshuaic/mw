package com.kingdee.eas.mw.srqr.app.util;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.util.BOSUuid;
import com.kingdee.eas.basedata.framework.app.ParallelSqlExecutor;
import com.kingdee.eas.basedata.org.CompanyOrgUnitFactory;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.basedata.org.CtrlUnitInfo;
import com.kingdee.eas.basedata.person.PersonFactory;
import com.kingdee.eas.basedata.person.PersonInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.custom.util.DBUtil;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.mw.pay.AchienementSumCollection;
import com.kingdee.eas.mw.pay.AchienementSumFactory;
import com.kingdee.eas.mw.pay.AchienementSumInfo;
import com.kingdee.eas.mw.pay.ClinicAchieveCosthSumFactory;
import com.kingdee.eas.mw.pay.ClinicAchieveCosthSumInfo;
import com.kingdee.eas.mw.pay.ClinicComSubFactory;
import com.kingdee.eas.mw.pay.ClinicComSubInfo;
import com.kingdee.eas.mw.pay.ScalingCountSumCollection;
import com.kingdee.eas.mw.pay.ScalingCountSumFactory;
import com.kingdee.eas.mw.pay.ScalingTypeInfo;
import com.kingdee.eas.mw.pay.app.PaypostType;
import com.kingdee.eas.mw.pay.app.util.PayMessage;
import com.kingdee.eas.mw.pay.app.util.SyncEHRAchieveUtil;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.jdbc.rowset.IRowSet;

public class PayDocDetailService {

	private Logger log;
	public PayDocDetailService() {
		this.log = LoggerFactory.getLogger(PayBeiJingDocFunctionService.class);
	}
	

	public void doBeiJing(Context ctx, String businessDate,String userId,String cityID,String cityNumber,String cityName,boolean flag) throws Exception, BOSException, SQLException{
		ExecutorService pool = Executors.newFixedThreadPool(6);
	    ParallelSqlExecutor pe = new ParallelSqlExecutor(pool); 
	    HashMap<Object, Object> tempMap = new HashMap<Object, Object>();
        HashMap<Object, Object> doctempMap = new HashMap<Object, Object>();
       
        HashMap<Object, Object> zixunMap = new HashMap<Object, Object>();
        HashMap<Object, Object> otherMap = new HashMap<Object, Object>();
        HashMap<Object, Object> shopGoalMap = new HashMap<Object, Object>();
        
        Map<String, String> mapAll = new HashMap<String, String>();
		PayFunctionService payFunctionService = new PayFunctionService();
		PayBeiJingDocFunctionService payDocFunctionService= new PayBeiJingDocFunctionService();
		PayZhanJiangDocFunctionService payZJDocFunctionService= new PayZhanJiangDocFunctionService(); 
		
		PayOtherCityDocFunctionService otherCitypayDocFunctionService= new PayOtherCityDocFunctionService(); 
		
		String includeCitySql ="/*dialect*/ SELECT bill.cfrule as RULE,billorg.fid as bcityid ,billorg.fnumber as bcitynumber , entryorg.fid as ecityid ,entryorg.fnumber  as ecitynumber  from  CT_PAY_PayCity  bill left join CT_PAY_PayCityEntry entry on bill.fid = entry.fparentid  left join   T_ORG_BaseUnit billorg on billorg.fid = bill.cfcityid "+
  		" left join   T_ORG_BaseUnit entryorg on entryorg.fid = entry.cfincludecityid where billorg.fnumber = '"+cityNumber+"' ";
		IRowSet includecityrow = DbUtil.executeQuery(ctx, includeCitySql);
		//HashMap<String,ArrayList<String>>  incityMap = new HashMap<String,ArrayList<String>>();
		//ArrayList<String> cityArray = new ArrayList<String>();
		
		String type = "";
		String incityidStr = " in (";
		String incityNumStr = " in (";
		while(includecityrow.next()){
			type = includecityrow.getString("RULE");
			
  			String ecityid =  includecityrow.getString("ECITYID"); 
  			String ecityNumber = includecityrow.getString("ECITYNUMBER");  
  				
  			incityidStr = incityidStr + "'"+ecityid+"',"; 
  			incityNumStr = incityNumStr + "'"+ecityNumber+"',"; 
		} 
		incityidStr = incityidStr.substring(0,incityidStr.length()-1) + " )";
		incityNumStr = incityNumStr.substring(0,incityNumStr.length()-1) + " )";
		
    	tempMap = PayMessage.getYJmbMessage(ctx,businessDate, cityID,tempMap);
        
    	
		doctempMap = PayMessage.getDocMessage(ctx, businessDate,cityID, doctempMap);
		
		doctempMap.put("cityName", cityName);
		tempMap.put(cityNumber, cityName);
		zixunMap = PayMessage.getZiXunMessage(ctx, businessDate ,cityID , zixunMap);
		
		otherMap= PayMessage.getOtherMessage(ctx, businessDate ,cityID, otherMap);
		shopGoalMap = PayMessage.getShopGoalMessage(ctx, businessDate ,cityID, shopGoalMap);
    
		
		String  calType = "";
		String  calTypeSql = "/*dialect*/  SELECT   CFCALTYPE  FROM CT_PAY_DocCurrencyPro  where  cfcityid= '"+cityID+"' and cfbusinessdate='"+businessDate+"'";
		IRowSet calTypeRs = com.kingdee.eas.custom.util.DBUtil.executeQuery(ctx,calTypeSql);
		if(calTypeRs!=null && calTypeRs.size() > 0){
			while(calTypeRs.next()){
				calType = calTypeRs.getString("CFCALTYPE");
			}
		}
		
		
		String  jyTypeStr = "CFRecDotNumber";
		String  jyTypeStrSql = "/*dialect*/  select nvl(FDESCRIPTION_L2,'CFRecDotNumber') as  JYTYPESTR  from  CT_PAY_PayCity  WHERE     cfcityid= '"+cityID+"' ";
		IRowSet jyTypeStrRs = com.kingdee.eas.custom.util.DBUtil.executeQuery(ctx,jyTypeStrSql);
		if(jyTypeStrRs!=null && jyTypeStrRs.size() > 0){
			while(jyTypeStrRs.next()){
				jyTypeStr = jyTypeStrRs.getString("JYTYPESTR");
			}
		}
		

		 
			 
		 
		/**
		
		  	insert into CT_PAY_ScalingBonusUpdate ( fid,fcreatorid , fcreatetime,flastupdateuserid,flastupdatetime,fcontrolunitid , cfempnumber, 
		cfempname, cfjycount,cfbusinessdate ,cfcityid ,CFJyTypeID)
		select newbosid('7A9C8E73') , fcreatorid , fcreatetime,flastupdateuserid,flastupdatetime,fcontrolunitid , cfempnumber, cfempname, cfjycount,cfbusinessdate ,cfcityid , 'jbYAAAIwzmgfr4zv' 
		from   CT_PAY_ScalingBonusUpdate  where  cfjytypeid is  null  and cfjycount != 0 
		
		北京市_JY		
		北京市_PLA	
	
		insert into CT_PAY_ScalingBonusUpdate (fid,fcreatorid , fcreatetime,flastupdateuserid,flastupdatetime,fcontrolunitid , cfempnumber, cfempname, cfjycount,cfbusinessdate ,cfcityid ,CFJyTypeID)
		select  newbosid('7A9C8E73') ,  fcreatorid , fcreatetime,flastupdateuserid,flastupdatetime,fcontrolunitid , cfempnumber, cfempname, cfplacount,cfbusinessdate ,cfcityid ,'jbYAAAIwzmkfr4zv' 
		from   CT_PAY_ScalingBonusUpdate  where  cfjytypeid is  null  and cfplacount != 0 
		
		  
		 
		 */
		//导入洁牙次数
		Map<String, BigDecimal> scalingMap = new HashMap<String, BigDecimal>();
		//查询洁牙导入的信息
		String importJy = " /*dialect*/ SELECT nvl(sum(sca.cfjycount),0) as JY , sca.cfempnumber EMPNUMBER , type.cfjynumber JYNUMBER FROM  CT_PAY_ScalingBonusUpdate sca left join CT_PAY_ScalingType type on  sca.CFJyTypeID  = type.fid  and type.cfcityid = '"+cityID+"'  "+
		"  where   sca.cfcityid = '"+cityID+"' and sca.cfbusinessdate = '"+businessDate+"'    group by sca.cfempnumber ,type.cfjynumber ";
		IRowSet rsImpJy =  DBUtil.executeQuery(ctx,importJy);
		if(rsImpJy!=null && rsImpJy.size() > 0){
			  while(rsImpJy.next()){ 
				  String empNumber = rsImpJy.getString("EMPNUMBER"); 
				  String jyNumber = rsImpJy.getString("JYNUMBER"); 
				  BigDecimal imjycount = new BigDecimal(rsImpJy.getString("JY"));    
				  scalingMap.put(empNumber+"_"+jyNumber +"_IM", imjycount);
			  }
		}  
		//导入美白业绩 
		Map<String, BigDecimal> meibaigMap = new HashMap<String, BigDecimal>();
		String importMb = " /*dialect*/ SELECT  cfempnumber , nvl(sum(cfmbachieve),0) as MB FROM  CT_PAY_WhiteBonusUpdate   where  cfcityid = '"+cityID+"' and cfbusinessdate = '"+businessDate+"' group by cfempnumber ";
		IRowSet rsImpMb =  DBUtil.executeQuery(ctx,importMb);
		if(rsImpMb!=null && rsImpMb.size() > 0){
			  while(rsImpMb.next()){
				  BigDecimal mbachieve = new BigDecimal(rsImpMb.getString("MB"));  
				  meibaigMap.put(rsImpMb.getString("CFEMPNUMBER")+"_MB_"+cityID, mbachieve);
			  }
		} 
		
		HashMap<String,String> docCalTypeStagemap = new HashMap<String,String>();
		String docCalTypeSql = " /*dialect*/ select  distinct CFEmpNumber , nvl(cfisallachieve,0)  cfisallachieve,cfcaltype    from  CT_PAY_DocStage docStage  where  CFCityID = '"+cityID+"' and CFBusinessDate = "+businessDate+"  and  "
			+"  exists ( select 1 from (select CFEmpNumber ,max(cfendamount) as maxamount from  CT_PAY_DocStage  where  CFCityID = '"+cityID+"' and CFBusinessDate = "+businessDate+"  group  by CFEmpNumber ,CFType) a where a.CFEmpNumber = docStage.CFEmpNumber   and  a.maxamount = docStage.cfendamount ) ";
		IRowSet docCalTypers = com.kingdee.eas.custom.util.DBUtil.executeQuery(ctx,docCalTypeSql);
		if(docCalTypers!=null && docCalTypers.size() > 0){
			 while(docCalTypers.next()){	
				 String isallAchieve = docCalTypers.getString("CFISALLACHIEVE");
				 String doccalType = docCalTypers.getString("CFCALTYPE");
				 docCalTypeStagemap.put(docCalTypers.getString("CFEMPNUMBER"), isallAchieve+"&"+doccalType); 
			 }
		}
		
		
		HashMap<String,String> docExisStagemap = new HashMap<String,String>();
		String docExistSql = " /*dialect*/ select  distinct CFEmpNumber ,CFType  from  CT_PAY_DocStage docStage  where  CFCityID = '"+cityID+"' and CFBusinessDate = "+businessDate+"  and  "
			+"  exists ( select 1 from (select CFEmpNumber ,CFType,max(cfendamount) as maxamount from  CT_PAY_DocStage  where  CFCityID = '"+cityID+"' and CFBusinessDate = "+businessDate+"  group  by CFEmpNumber ,CFType) a where a.CFEmpNumber = docStage.CFEmpNumber  and  a.CFType =docStage.CFType and  a.maxamount = docStage.cfendamount ) ";
		IRowSet docExistrs = com.kingdee.eas.custom.util.DBUtil.executeQuery(ctx,docExistSql);
		if(docExistrs!=null && docExistrs.size() > 0){
			 while(docExistrs.next()){	
				 String doctype = docExistrs.getString("CFTYPE");
				 if(docExisStagemap.get(docExistrs.getString("CFEMPNUMBER")) == null ){
					 docExisStagemap.put(docExistrs.getString("CFEMPNUMBER"), doctype);
				 }else{
					 String docExtype = docExisStagemap.get(docExistrs.getString("CFEMPNUMBER"));
					 docExisStagemap.put(docExistrs.getString("CFEMPNUMBER"), docExtype+"&"+doctype);
				 }
				 
			 }
		}
		
		//免工作量比例
		BigDecimal freeWorkPro = BigDecimal.ZERO;  
		//赠金比例
		BigDecimal gifAmountPro = BigDecimal.ZERO; 
		
		HashMap tongyongmap = (HashMap)tempMap.get("TONGYONGBILI_DOC");  
		
		HashMap<String,HashMap<String,String>> itemMessage = new HashMap<String,HashMap<String,String>>();
		itemMessage = PayMessage.getMBItemMessage(ctx, businessDate ,cityID, itemMessage); 
		HashMap<String,String>  oneItemMap = itemMessage.get("one");
		HashMap<String,String>  twoItemMap = itemMessage.get("two");
		HashMap<String,String>  threeItemMap = itemMessage.get("three");
		
		//获得医生的总业绩 
		HashMap<String, BigDecimal> docAllAchieveMap = getOtherDocAchieveMessage(ctx, businessDate,cityID,tongyongmap,type,incityNumStr,cityNumber,
				oneItemMap,twoItemMap,threeItemMap);
		
		 
		//洁牙
		HashMap<String,String>  jieyaTypeMap = new HashMap<String,String>(); 
		HashMap<String,HashMap<String,String>> jyitemMessage = new HashMap<String,HashMap<String,String>>();
		jyitemMessage = PayMessage.getJYItemMessage(ctx, businessDate ,cityID, jyitemMessage);
		 
		
		String  deleteFentan = "/*dialect*/   delete  CT_PAY_DocAchieveUpdate where    cfcityid= '"+cityID+"' and cfbusinessdate='"+businessDate+"' and  fname_l2 = '分摊扣除业绩'";
		com.kingdee.eas.custom.util.DBUtil.execute(ctx,deleteFentan);
		
		//洁牙师 护士
		StringBuffer hsSql = new StringBuffer();//  and  cfrecdotnumber in ('MS110100043','MS110100146','MS110100067' ) 
		//docSql.append("/*dialect*/ select   distinct  cfrecdotnumber from  CT_PAY_AchieveDetailtem  where  cfcitynumber = '"+cityNumber+"'   and cfrecdotnumber is  not null and   to_char(fbizdate,'YYYYMM') ='"+businessDate+"'   and exists (select 1 from CT_PAY_PayPost paypost where paypost.cfcityid ='"+cityID+"' and  paypost.cfstatus='qy'  and paypost.cfpostnumber  != 'MZYYZJ'  and paypost.cfempnumber = CT_PAY_AchieveDetailtem.cfrecdotnumber)   group by   cfrecdotnumber  ");
		hsSql.append("/*dialect*/  select   distinct  paypost.cfempnumber as  cfrecdotnumber, paypost.cfempname as cfempname , paypost.CFPOSTNUMBER as  CFPOSTNUMBER   from CT_PAY_PayPost paypost where paypost.cfcityid ='"+cityID+"' and  paypost.cfstatus='qy'   and paypost.cfpostnumber   in ('JYS','HS','YS','JZYS') and  paypost.cfbusinessdate = '"+businessDate+"'   ");
		
		IRowSet docrow = DbUtil.executeQuery(ctx, hsSql.toString());
	
		//遍历eas中的数据 
		while (docrow.next()) { 
		//while (docrow.size() == 0) { 
			String postType = ""; 
			String clinicNumber = "";
			String clinicName = "";
			String paypost = docrow.getString("CFPOSTNUMBER");  
			String docNumer = docrow.getString("CFRECDOTNUMBER");  
			String docName = docrow.getString("CFEMPNAME");  
			 
			String fdocStageType = "";
			if(docExisStagemap.size() >0 && docExisStagemap.get(docNumer) != null){
				fdocStageType = docExisStagemap.get(docNumer) ;
			}
			String fdocCalType = "0";
			if(docCalTypeStagemap.size() >0 && docCalTypeStagemap.get(docNumer) != null){
				fdocCalType = docCalTypeStagemap.get(docNumer) ;
				
			}
			doctempMap.put(docNumer+"_DOCCALTYPE", fdocCalType);
			
			HashMap<String,String>  djieyaMap = new HashMap<String,String>();
			HashMap<String,String>  mbMap = new HashMap<String,String>();
			
			HashMap<String,Object>  docMap = new HashMap<String,Object>();
			String insertSql = "";
			String insertValueSql = "";
			//洁牙
			String jyCount = "0"; String plaCount = "0";     
			tempMap.put("empName", docName);
			//djieyaMap = payFunctionService.getScalingBonus(ctx,docNumer,  cityNumber, businessDate,cityID, tempMap);
			djieyaMap = payFunctionService.getScalingBonus(ctx,docNumer,  cityNumber, businessDate,cityID,tempMap, paypost,scalingMap,jyitemMessage,jyTypeStr);
			
			//美白
			String meiibaiBonus = "0"; String mbAchieve = "0"; String immbAchieve = "0"; String xtmbAchieve = "0"; 
			mbMap = payFunctionService.getWhiteBonus(ctx,docNumer, cityNumber, businessDate, cityID,tempMap,meibaigMap,itemMessage);
			if( null !=  mbMap  ){
				if(  null !=  mbMap.get("meiibaiBonus")   ){meiibaiBonus = mbMap.get("meiibaiBonus");}
				if(  null !=  mbMap.get("mbAchieve")   ){mbAchieve = mbMap.get("mbAchieve");} 
				if(  null !=  mbMap.get("immbAchieve")   ){immbAchieve = mbMap.get("immbAchieve");} 
				if(  null !=  mbMap.get("xtmbAchieve")   ){xtmbAchieve = mbMap.get("xtmbAchieve");} 
				postType =  mbMap.get("postType")==null? "":mbMap.get("postType").toString(); 
			}
			String docJiangjin = "0";
			String cost = "0";
			
			doctempMap.put("empName", docName);
			
			String imandxtinsertsql = "";
			String imandxtinsertValueSql = "";
			 
			docMap = otherCitypayDocFunctionService.getDocBonus(ctx,docNumer, "", businessDate, doctempMap,cityID,cityNumber,type ,calType ,fdocStageType,docAllAchieveMap);
			//医生奖金
			//docMap = payDocFunctionService.getDocBonus(ctx,docNumer, "", businessDate, doctempMap,cityID,cityNumber,type ,calType);
			/*if("MS1101".equals(cityNumber)){
				docMap = payDocFunctionService.getDocBonus(ctx,docNumer, "", businessDate, doctempMap,cityID,cityNumber,type ,calType , fdocStageType);
			}else{ 
				//docMap = payZJDocFunctionService.getDocBonus(ctx,docNumer, "", businessDate, doctempMap,cityID,cityNumber,type ,calType);
				docMap = otherCitypayDocFunctionService.getDocBonus(ctx,docNumer, "", businessDate, doctempMap,cityID,cityNumber,type ,calType ,fdocStageType,docAllAchieveMap);
			}*/
			if(docMap != null){
				docJiangjin = docMap.get("JIANGJIN")==null ? "0":docMap.get("JIANGJIN").toString();
				cost = docMap.get("COST")==null ? "0":docMap.get("COST").toString(); 
				
				if(meiibaiBonus.equals("0") || meiibaiBonus.equals("0.0")){
					meiibaiBonus = docMap.get("mbMoney")==null ? "0":docMap.get("mbMoney").toString(); 
				}
				
				if(docMap.get("postType")!=null ){postType =  docMap.get("postType").toString(); }
				
				imandxtinsertsql =  docMap.get("imandxtinsertsql")==null ? "":docMap.get("imandxtinsertsql").toString();
				imandxtinsertValueSql = docMap.get("imandxtinsertValueSql")==null ? "":docMap.get("imandxtinsertValueSql").toString();
				
				insertSql = docMap.get("INSERTSQL")==null ? "":docMap.get("INSERTSQL").toString();
				insertValueSql = docMap.get("INSERTVALUESQL")==null ? "":docMap.get("INSERTVALUESQL").toString();
			} 
			postType =  docrow.getString("CFPOSTNUMBER"); 
			
			flag = true;
			
			/*if( BigDecimal.ZERO.compareTo(new BigDecimal(docJiangjin)) != 0  || BigDecimal.ZERO.compareTo(new BigDecimal(meiibaiBonus)) != 0  ){
				
			}*/ 
			StringBuffer sbr  = new StringBuffer(" /*dialect*/insert into CT_PAY_AchienementSum (FID,FCreatorID,FCreateTime,FLastUpdateUserID,FLastUpdateTime, ");
    		sbr.append("cfposttype,cfbusinessdate, CFCLINICNUMBER,CFCLINICName,cfempnumber,cfempname,CFCITYNUMBER,CFCITYName,CFScalingBonus, CFWhiteBonus , CFDocBonus , CFDOCCOST , CFConBonus ,CFOtherPostBonus ,CFShopGoalBonus ) ");
    		sbr.append("values(newbosid('4AF58046'),'"+userId+"',sysdate,'"+userId+"',sysdate, ");
    		sbr.append(" '"+postType+"',  '"+businessDate+"','"+clinicNumber+"','"+clinicName+"' ,'"+docNumer+"','"+docName+"','"+cityNumber+"','"+cityName+"' , 0  , "+meiibaiBonus+" ,"+docJiangjin+" , "+cost+" , 0 ,0,0  )"); 
    		//sbr.append("'"+clinicNumber+"','' ,'"+docNumer+"','','"+cityNumber+"','' , "+jieyaBonus+" , "+meiibaiBonus+" ,"+docBonus+"   )"); 
    		pe.getSqlList().add(sbr);
    		
    		if( null == docMap.get("EXISTS") || "NO".equals(docMap.get("EXISTS").toString())){
    			StringBuffer sbr2  = new StringBuffer(" /*dialect*/insert into CT_PAY_ClinicAchieveCosthSum (FID,FCreatorID,FCreateTime,FLastUpdateUserID,FLastUpdateTime, ");
    			sbr2.append(" cfimjycount,cfimplacount,cfxtjycount,cfxtplacount,CFIMWhiteAchieve,CFXTWhiteAchieve, ");
	    		sbr2.append(" cfposttype , cfbusinessdate, CFCLINICNUMBER,CFCLINICName,cfempnumber,cfempname,CFCITYNUMBER,CFCITYName,CFJyCount, CFPlaCount , CFWhiteAchieve  "+insertSql+" "+imandxtinsertsql+" ) ");
	    		sbr2.append("values(newbosid('20D1E187'),'"+userId+"',sysdate,'"+userId+"',sysdate, ");
	    		sbr2.append(" 0, 0 , 0 , 0 , "+immbAchieve+","+xtmbAchieve+",");
	    		sbr2.append(" '"+postType+"', '"+businessDate+"','"+clinicNumber+"','"+clinicName+"' ,'"+docNumer+"','"+docName+"','"+cityNumber+"','"+cityName+"' , 0  , 0  ,"+mbAchieve+"  "+insertValueSql+" "+imandxtinsertValueSql+")");  
	    		pe.getSqlList().add(sbr2);
	    		
    		}else{
    			ClinicAchieveCosthSumInfo  clinicAchieveCosthSumInfo =  (ClinicAchieveCosthSumInfo) docMap.get("ClinicAchieveCosthSumInfo");
    			clinicAchieveCosthSumInfo.setJyCount(clinicAchieveCosthSumInfo.getJyCount().add(new BigDecimal(jyCount)));
    			clinicAchieveCosthSumInfo.setPlaCount(clinicAchieveCosthSumInfo.getPlaCount().add(new BigDecimal(plaCount)));
    			clinicAchieveCosthSumInfo.setWhiteAchieve(clinicAchieveCosthSumInfo.getWhiteAchieve().add(new BigDecimal(mbAchieve))); 
    		 
    			ClinicAchieveCosthSumFactory.getLocalInstance(ctx).save(clinicAchieveCosthSumInfo);
    		}
		} 
  
		String  zxZiDuan = "CFRecConNumber";
		if(businessDate.equals("202012")){
			zxZiDuan = "CFExcConNumber";
		}else{
			String zxziduanSql = "/*dialect*/SELECT  (CASE   WHEN FDESCRIPTION_L2 is  null  THEN 'CFRecConNumber' WHEN FDESCRIPTION_L2= '0'  THEN 'CFExcConNumber' ELSE 'CFRecConNumber' END ) as ZD FROM  CT_PAY_CityChannel   where   cfcityid = '"+cityID+"' and cfbusinessdate = '"+businessDate+"'";
			IRowSet rsZiDuanZX =  DBUtil.executeQuery(ctx,zxziduanSql);
			if(rsZiDuanZX!=null && rsZiDuanZX.size() > 0){
				  while(rsZiDuanZX.next()){	 
					  zxZiDuan = rsZiDuanZX.getString("ZD"); 
				  }
			}
		} 
		
		
		StringBuffer zixunSql = new StringBuffer();  
		zixunSql.append("/*dialect*/  select   distinct  paypost.cfempnumber as CFExcConNumber ,  nvl(paypost.cfclinicid,'') as  CFCLINICID  from CT_PAY_PayPost paypost where paypost.cfcityid ='"+cityID+"' and  paypost.cfstatus='qy'   and paypost.cfpostnumber   in ('ZXS', 'MZYYZJ') and  paypost.cfbusinessdate = '"+businessDate+"' and  not  exists  (select     1   from  CT_PAY_AchRoyaltyRule  rule   where  rule.cfbusinessdate = '"+businessDate+"' and rule.cfcityid = '"+cityID+"' and  rule.cfempnumber = paypost.cfempnumber )   ");
	 
		IRowSet zxRow = DbUtil.executeQuery(ctx, zixunSql.toString());	 
		while (zxRow.next()) { 
		//if (zxRow.size()== 0 ) { 
			String postType = "";
			
			String clinicid= "";
			String clinicNumber = "";
			String clinicName = "";
			//String clinicName = zxRow.getString("CFCLINICNAME"); 
			String docNumer = zxRow.getString("CFEXCCONNUMBER"); 
			if(zxRow.getObject("CFCLINICID") != null && !zxRow.getString("CFCLINICID").equals("")){
				// zxRow.getString("CFCITYNUMBER")  实际上是门诊编码   
				clinicid = zxRow.getString("CFCLINICID"); 
				CompanyOrgUnitInfo com = CompanyOrgUnitFactory.getLocalInstance(ctx).getCompanyOrgUnitInfo("where id='"+clinicid+"'");
				clinicName = com.getName();
				clinicNumber = com.getNumber();
			}
			
			PersonInfo person = PersonFactory.getLocalInstance(ctx).getPersonCollection(" where number = '"+docNumer+"' " ).get(0); 
			if(person != null ){
				mapAll.put(docNumer, "1");
				//咨询
				HashMap<String,String>  zxMap = new HashMap<String,String>();
				String zixunBonus = "0";
				String zxAchieve = "0";
				String imzxAchieve = "0";
				String xtzxAchieve = "0";
				
				
				String shopGoalBonus =  "0";
				
				zxMap = payFunctionService.getConsultantBonus(ctx,docNumer, cityNumber, businessDate,cityID, zixunMap,zxZiDuan); 
				 
				if( null !=  zxMap  ){
					if(  null !=  zxMap.get("zixunBonus")   ){
						zixunBonus = zxMap.get("zixunBonus");
					}
					if(  null !=  zxMap.get("zxAchieve")   ){
						zxAchieve = zxMap.get("zxAchieve");
					} 
					if(  null !=  zxMap.get("imzxAchieve")   ){
						imzxAchieve = zxMap.get("imzxAchieve");
					} 
					if(  null !=  zxMap.get("xtzxAchieve")   ){
						xtzxAchieve = zxMap.get("xtzxAchieve");
					} 
					
					postType = zxMap.get("postType");
				} 
				
				//其他职位绩效
				HashMap<String,String>  getOtherMap = new HashMap<String,String>();
				String otherBonus = "0";
				String otherAchieve = "0";
				//if("MS1101".equals(cityNumber)){
					if( (null == otherMap.get(docNumer+"_OT2")) || "".equals(otherMap.get(docNumer+"_OT2").toString()) ){
						getOtherMap = payFunctionService.getOtherPostAch(ctx,docNumer, cityNumber, businessDate,cityID, otherMap,zxZiDuan);
					}
					if(null !=getOtherMap && null != getOtherMap.get("otherBonus") && null != getOtherMap.get("otherAchieve")){
						otherBonus = getOtherMap.get("otherBonus");
						otherAchieve = getOtherMap.get("otherAchieve");
						zxAchieve = otherAchieve;
						imzxAchieve = getOtherMap.get("imotherAchieve");
						xtzxAchieve = getOtherMap.get("xtotherAchieve");
						postType = getOtherMap.get("postType");
						if(getOtherMap.get("wanchengMoney")!= null && !getOtherMap.get("wanchengMoney").toString().equals("")){
							  shopGoalBonus = getOtherMap.get("wanchengMoney").toString();
						}
					}
				/*}else{
					
				}*/
				
				
				
				//获取门店目标
				//double shopGoalBonus = payFunctionService.getShopGoal(ctx,docNumer, "", businessDate, shopGoalMap);
				
				flag = true;
				StringBuffer sbr  = new StringBuffer(" /*dialect*/ insert into CT_PAY_AchienementSum (FID,FCreatorID,FCreateTime,FLastUpdateUserID,FLastUpdateTime, ");
	    		sbr.append(" cfposttype,cfbusinessdate, CFCLINICNUMBER,CFCLINICName,cfempnumber,cfempname,CFCITYNUMBER,CFCITYName,CFScalingBonus, CFWhiteBonus , CFDocBonus , CFConBonus ,CFOtherPostBonus ,CFShopGoalBonus ) ");
	    		sbr.append("values(newbosid('4AF58046'),'"+userId+"',sysdate,'"+userId+"',sysdate, ");
	    		//sbr.append("'"+clinicNumber+"','"+clinicName+"' ,'"+docNumer+"','"+docName+"','"+cityNumber+"','"+cityName+"' , 0 ,0,0,"+zixunBonus+","+otherBonus+" ,"+shopGoalBonus+"  ) "); 
	    		//sbr.append(" '"+businessDate+"','"+clinicNumber+"','"+clinicName+"' ,'"+docNumer+"','','"+cityNumber+"','"+cityName+"' , 0 ,0,0,"+zixunBonus+","+otherBonus+" ,"+shopGoalBonus+"  ) ");
	    		sbr.append("  '"+postType+"', '"+businessDate+"','"+clinicNumber+"','"+clinicName+"' ,'"+docNumer+"','"+person.getName()+"','"+cityNumber+"','"+cityName+"' , 0 ,0,0,"+zixunBonus+","+otherBonus+" ,"+shopGoalBonus+"  ) ");
	    		pe.getSqlList().add(sbr);
	    		
	    		StringBuffer sbr2  = new StringBuffer(" /*dialect*/insert into CT_PAY_ClinicAchieveCosthSum (FID,FCreatorID,FCreateTime,FLastUpdateUserID,FLastUpdateTime, ");
	    		sbr2.append(" cfposttype , cfbusinessdate, CFCLINICNUMBER,CFCLINICName,cfempnumber,cfempname,CFCITYNUMBER,CFCITYName, CFZxAchieve,CFimZxAchieve,CFxtZxAchieve ) ");
	    		sbr2.append("values(newbosid('20D1E187'),'"+userId+"',sysdate,'"+userId+"',sysdate, ");
	    		sbr2.append("'"+postType+"','"+businessDate+"','','' ,'"+docNumer+"','"+person.getName()+"','"+cityNumber+"','"+cityName+"' ,"+zxAchieve+" ,"+imzxAchieve+","+xtzxAchieve+")");  
	    		
	    		
	    		pe.getSqlList().add(sbr2);
	    		
	    		StringBuffer sbr3  = new StringBuffer(" /*dialect*/insert into CT_PAY_ClinicAchieveCosthInit (FID,FCreatorID,FCreateTime,FLastUpdateUserID,FLastUpdateTime, ");
	    		sbr3.append(" cfposttype , cfbusinessdate, CFCLINICNUMBER,CFCLINICName,cfempnumber,cfempname,CFCITYNUMBER,CFCITYName, CFZxAchieve ) ");
	    		sbr3.append("values(newbosid('F965A954'),'"+userId+"',sysdate,'"+userId+"',sysdate, ");
	    		sbr3.append("'"+postType+"','"+businessDate+"','','' ,'"+docNumer+"','"+person.getName()+"','"+cityNumber+"','"+cityName+"' ,"+zxAchieve+" )");  
	    		//pe.getSqlList().add(sbr3);
			} 
		}
		if("MS1101".equals(cityNumber)){

			String postSql = "/*dialect*/ SELECT    cfempnumber, nvl(cfempname,'') as EMPNAME, nvl(CFCLINICNUMBER,'') as CLINICNUMBER, nvl(CFCLINICNAME,'') as CLINICNAME,CFCITYNUMBER,CFCITYNAME   FROM CT_PAY_AchRoyaltyRule where  cfbusinessdate = '"+businessDate+"' and cfstatus='qy' and cfempnumber  is not  null and  cfcityid= '"+cityID+"'  ";
			IRowSet rs = com.kingdee.eas.custom.util.DBUtil.executeQuery(ctx,postSql);
			
			if(rs!=null && rs.size() > 0){
			//if(rs!=null && rs.size() == 0){
				  while(rs.next()){	      					  
					  if( null !=rs.getObject("CFEMPNUMBER") && !"".equals(rs.getString("CFEMPNUMBER")) ){
						  String postType = "";
						  
						  String  empNumber= rs.getString("CFEMPNUMBER");
						  String clinicNumber = rs.getString("CLINICNUMBER")== null? "":rs.getString("CLINICNUMBER");
						  String clinicName = rs.getString("CLINICNAME")== null? "":rs.getString("CLINICNAME");
						    
						  String empName = rs.getString("EMPNAME"); 
						  //其他职位绩效
						  //double otherBonus = payFunctionService.getOtherPostAch(ctx,empNumber, clinicNumber, businessDate, otherMap);
						  
						  String otherAchieve = "0";
						  String imotherAchieve = "0";
						  String xtotherAchieve = "0";
						  HashMap<String,String>  getOtherMap = new HashMap<String,String>();
						  String otherBonus = "0"; 
						  String shopGoalBonus =  "0";
						  getOtherMap = payFunctionService.getOtherPostAch(ctx,empNumber, cityNumber, businessDate,cityID, otherMap,zxZiDuan);
						  if(null !=getOtherMap && null != getOtherMap.get("otherBonus") && null != getOtherMap.get("otherAchieve")){
							  otherBonus = getOtherMap.get("otherBonus"); 
							  otherAchieve = getOtherMap.get("otherAchieve"); 
							  imotherAchieve = getOtherMap.get("imotherAchieve"); 
							  xtotherAchieve = getOtherMap.get("xtotherAchieve"); 
							  
							 
							  if(getOtherMap.get("wanchengMoney")!= null && !getOtherMap.get("wanchengMoney").toString().equals("")){
								  shopGoalBonus = getOtherMap.get("wanchengMoney").toString();
							  }
						  }
						  //获取门店目标
	        			
						  postType = "CSYYZJ";
						  flag = true;
						  StringBuffer sbr  = new StringBuffer(" /*dialect*/ insert into CT_PAY_AchienementSum (FID,FCreatorID,FCreateTime,FLastUpdateUserID,FLastUpdateTime, fsimplename ,");
				    	  sbr.append(" cfposttype, cfbusinessdate, CFCLINICNUMBER,CFCLINICName,cfempnumber,cfempname,CFCITYNUMBER,CFCITYName,CFScalingBonus, CFWhiteBonus , CFDocBonus , CFConBonus ,CFOtherPostBonus ,CFShopGoalBonus ) ");
				    	  sbr.append("values(newbosid('4AF58046'),'"+userId+"',sysdate,'"+userId+"',sysdate, '1',");
				    	  sbr.append(" '"+postType+"',  '"+businessDate+"','"+clinicNumber+"','"+clinicName+"' ,'"+empNumber+"','"+empName+"','"+cityNumber+"','"+cityName+"' , 0 ,0,0,0,"+otherBonus+" ,"+shopGoalBonus+"  ) "); 
				    	  //sbr.append(" '"+businessDate+"','"+clinicNumber+"','"+clinicName+"' ,'"+empNumber+"','','"+cityNumber+"','"+cityName+"' , 0 ,0,0,0,"+otherBonus+" ,0  ) ");
				    	  pe.getSqlList().add(sbr); 
				    	  
				    	  StringBuffer sbr2  = new StringBuffer(" /*dialect*/insert into CT_PAY_ClinicAchieveCosthSum (FID,FCreatorID,FCreateTime,FLastUpdateUserID,FLastUpdateTime, ");
				    	  sbr2.append("cfposttype , cfbusinessdate, CFCLINICNUMBER,CFCLINICName,cfempnumber,cfempname,CFCITYNUMBER,CFCITYName, CFZxAchieve ,CFimZxAchieve, CFxtZxAchieve) ");
				    	  sbr2.append("values(newbosid('20D1E187'),'"+userId+"',sysdate,'"+userId+"',sysdate, ");
				    	  sbr2.append(" '"+postType+"', '"+businessDate+"','','' ,'"+empNumber+"','"+empName+"','"+cityNumber+"','"+cityName+"' ,"+otherAchieve+" ,"+imotherAchieve+"  ,"+xtotherAchieve+"  )");  
		    	    		
				    	  pe.getSqlList().add(sbr2);
				    	  
				    	  
				    	  StringBuffer sbr3  = new StringBuffer(" /*dialect*/insert into CT_PAY_ClinicAchieveCosthInit (FID,FCreatorID,FCreateTime,FLastUpdateUserID,FLastUpdateTime, ");
				    	  sbr3.append("cfposttype , cfbusinessdate, CFCLINICNUMBER,CFCLINICName,cfempnumber,cfempname,CFCITYNUMBER,CFCITYName, CFZxAchieve ) ");
				    	  sbr3.append("values(newbosid('F965A954'),'"+userId+"',sysdate,'"+userId+"',sysdate, ");
				    	  sbr3.append(" '"+postType+"','"+businessDate+"','','' ,'"+empNumber+"','"+empName+"','"+cityNumber+"','"+cityName+"' ,"+otherAchieve+" )");  
		    	    		
				    	 // pe.getSqlList().add(sbr3);
					  }
				  }
			 }   
		} 
		if(flag){
			 
			Calendar caldele = Calendar.getInstance();
			caldele.setTime(new Date());
			caldele.add(Calendar.MONTH, -3);
	        Date dateDele = caldele.getTime();
	        SimpleDateFormat formatdelete= new SimpleDateFormat("yyyyMM");
	        String deleDate = formatdelete.format(dateDele);
			//StringBuffer sbr  = new StringBuffer(" /*dialect*/  delete CT_PAY_AchieveDetailtem where   fbizdate =  to_date('"+deleDate+"','YYYYMM') "); 
    		//pe.getSqlList().add(sbr);
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
		CoreBaseCollection baseCollection = new CoreBaseCollection();
		//医助 转给医生奖金
		//String assToDocSql = " SELECT  CFDOCNUMBER,CFDOCNAME,CFASSNUMBER,CFBILI FROM  CT_PAY_DoctorRelation where  cfcityid='"+cityID+"' and cfbusinessdate = '"+businessDate+"' and cfasstype = 'ys'  ";
		String assToDocSql = " SELECT  CFDOCNUMBER,CFDOCNAME,CFASSNUMBER,CFBILI FROM  CT_PAY_DoctorRelation where  cfcityid='"+cityID+"' and cfbusinessdate = '"+businessDate+"' and cfasstype = 'qt'  ";
		IRowSet assToDocrow = DbUtil.executeQuery(ctx, assToDocSql); 
		//遍历eas中的数据 
		while(assToDocrow.next()){ 
			String docNumber = assToDocrow.getString("CFDOCNUMBER");
			String docName = assToDocrow.getString("CFDOCNAME");
			String assNumber = assToDocrow.getString("CFASSNUMBER");
			BigDecimal bili = assToDocrow.getBigDecimal("CFBILI");
			if(AchienementSumFactory.getLocalInstance(ctx).exists(" where citynumber='"+cityNumber+"' and businessdate = '"+businessDate+"'  and empnumber='"+assNumber+"' ")){
				AchienementSumCollection collection = AchienementSumFactory.getLocalInstance(ctx).getAchienementSumCollection(" where citynumber='"+cityNumber+"' and businessdate = '"+businessDate+"'  and empnumber='"+assNumber+"' ");
				for(int i=0;i<collection.size();i++){
					AchienementSumInfo info  = collection.get(i);
					BigDecimal assBouns = info.getDocBonus()==null ?BigDecimal.ZERO:info.getDocBonus();
					String clinicNumber = info.getClinicNumber();
					if(assBouns.compareTo(BigDecimal.ZERO) > 0 ){
						BigDecimal assToDocBouns = info.getAssToDocBouns()==null ?BigDecimal.ZERO:info.getAssToDocBouns();
						info.setAssToDocBouns(assToDocBouns.add(assBouns.multiply(bili)).negate());
						baseCollection.add(info);
						AchienementSumInfo docinfo  = new AchienementSumInfo();
						if(AchienementSumFactory.getLocalInstance(ctx).exists(" where   citynumber='"+cityNumber+"' and businessdate = '"+businessDate+"'  and empnumber='"+docNumber+"' ")){
							docinfo = AchienementSumFactory.getLocalInstance(ctx).getAchienementSumCollection(" where   citynumber='"+cityNumber+"' and businessdate = '"+businessDate+"'  and empnumber='"+docNumber+"' ").get(0);
							BigDecimal docassToDocBouns = docinfo.getAssToDocBouns()==null ?BigDecimal.ZERO:docinfo.getAssToDocBouns();
							docinfo.setAssToDocBouns(docassToDocBouns.add(assBouns.multiply(bili)));
							baseCollection.add(docinfo);
						}else{
							docinfo =  (AchienementSumInfo) info.clone();
							docinfo.setId(null);
							docinfo.setEmpName(docName);
							docinfo.setEmpNumber(docNumber);
							docinfo.setAssToDocBouns( assBouns.multiply(bili));
							docinfo.setDocCost(BigDecimal.ZERO);
							docinfo.setDocBonus(BigDecimal.ZERO);
							
							baseCollection.add(docinfo);
						}
					}
				}
			}
		}
		AchienementSumFactory.getLocalInstance(ctx).save(baseCollection);
		
		
		ExecutorService pool3 = Executors.newFixedThreadPool(1);
	    ParallelSqlExecutor pe3 = new ParallelSqlExecutor(pool3);   
	    pe3.getSqlList().add(" update  CT_PAY_ClinicAchieveCosthSum set cfpostname = '客服' where cfbusinessdate = '"+businessDate+"' and cfcitynumber = '"+cityNumber+"' and cfposttype = 'KF' ");
	    pe3.getSqlList().add(" update  CT_PAY_ClinicAchieveCosthSum set cfpostname = '护士' where cfbusinessdate = '"+businessDate+"' and cfcitynumber = '"+cityNumber+"' and cfposttype = 'HS' ");
	    pe3.getSqlList().add(" update  CT_PAY_ClinicAchieveCosthSum set cfpostname = '洁牙师' where cfbusinessdate = '"+businessDate+"' and cfcitynumber = '"+cityNumber+"' and cfposttype = 'JYS' ");
	    pe3.getSqlList().add(" update  CT_PAY_ClinicAchieveCosthSum set cfpostname = '咨询师' where cfbusinessdate = '"+businessDate+"' and cfcitynumber = '"+cityNumber+"' and cfposttype = 'ZXS' ");
	    pe3.getSqlList().add(" update  CT_PAY_ClinicAchieveCosthSum set cfpostname = '医生' where cfbusinessdate = '"+businessDate+"' and cfcitynumber = '"+cityNumber+"' and cfposttype = 'YS' ");
	    pe3.getSqlList().add(" update  CT_PAY_ClinicAchieveCosthSum set cfpostname = '院长' where cfbusinessdate = '"+businessDate+"' and cfcitynumber = '"+cityNumber+"' and cfposttype = 'YZ' "); 
    	pe3.getSqlList().add(" update  CT_PAY_ClinicAchieveCosthSum set cfpostname = '门诊运营总监' where cfbusinessdate = '"+businessDate+"' and cfcitynumber = '"+cityNumber+"' and cfposttype = 'MZYYZJ' "); 
    	pe3.getSqlList().add(" update  CT_PAY_ClinicAchieveCosthSum set cfpostname = '兼职医生' where cfbusinessdate = '"+businessDate+"' and cfcitynumber = '"+cityNumber+"' and cfposttype = 'JZYS' "); 
    	pe3.getSqlList().add(" update  CT_PAY_ClinicAchieveCosthSum set cfpostname = '特殊兼职医生' where cfbusinessdate = '"+businessDate+"' and cfcitynumber = '"+cityNumber+"' and cfposttype = 'TSJZYS' ");
    	pe3.getSqlList().add(" update  CT_PAY_ClinicAchieveCosthSum set cfpostname = '城市运营总监' where cfbusinessdate = '"+businessDate+"' and cfcitynumber = '"+cityNumber+"' and cfposttype = 'CSYYZJ' ");
    	
    	
    	pe3.getSqlList().add(" update  CT_PAY_AchienementSum set cfpostname = '客服' where cfbusinessdate = '"+businessDate+"' and cfcitynumber = '"+cityNumber+"' and cfposttype = 'KF' ");
 	    pe3.getSqlList().add(" update  CT_PAY_AchienementSum set cfpostname = '护士' where cfbusinessdate = '"+businessDate+"' and cfcitynumber = '"+cityNumber+"' and cfposttype = 'HS' ");
 	    pe3.getSqlList().add(" update  CT_PAY_AchienementSum set cfpostname = '洁牙师' where cfbusinessdate = '"+businessDate+"' and cfcitynumber = '"+cityNumber+"' and cfposttype = 'JYS' ");
 	    pe3.getSqlList().add(" update  CT_PAY_AchienementSum set cfpostname = '咨询师' where cfbusinessdate = '"+businessDate+"' and cfcitynumber = '"+cityNumber+"' and cfposttype = 'ZXS' ");
 	    pe3.getSqlList().add(" update  CT_PAY_AchienementSum set cfpostname = '医生' where cfbusinessdate = '"+businessDate+"' and cfcitynumber = '"+cityNumber+"' and cfposttype = 'YS' ");
 	    pe3.getSqlList().add(" update  CT_PAY_AchienementSum set cfpostname = '院长' where cfbusinessdate = '"+businessDate+"' and cfcitynumber = '"+cityNumber+"' and cfposttype = 'YZ' "); 
     	pe3.getSqlList().add(" update  CT_PAY_AchienementSum set cfpostname = '门诊运营总监' where cfbusinessdate = '"+businessDate+"' and cfcitynumber = '"+cityNumber+"' and cfposttype = 'MZYYZJ' "); 
     	pe3.getSqlList().add(" update  CT_PAY_AchienementSum set cfpostname = '兼职医生' where cfbusinessdate = '"+businessDate+"' and cfcitynumber = '"+cityNumber+"' and cfposttype = 'JZYS' "); 
     	pe3.getSqlList().add(" update  CT_PAY_AchienementSum set cfpostname = '特殊兼职医生' where cfbusinessdate = '"+businessDate+"' and cfcitynumber = '"+cityNumber+"' and cfposttype = 'TSJZYS' ");
     	pe3.getSqlList().add(" update  CT_PAY_AchienementSum set cfpostname = '城市运营总监' where cfbusinessdate = '"+businessDate+"' and cfcitynumber = '"+cityNumber+"' and cfposttype = 'CSYYZJ' ");
     	 
    	
     	pe3.getSqlList().add(" update  CT_PAY_ScalingCountSum set cfpostname = '客服' where cfbusinessdate = '"+businessDate+"' and cfcitynumber = '"+cityNumber+"' and cfpost = 'KF' ");
 	    pe3.getSqlList().add(" update  CT_PAY_ScalingCountSum set cfpostname = '护士' where cfbusinessdate = '"+businessDate+"' and cfcitynumber = '"+cityNumber+"' and cfpost = 'HS' ");
 	    pe3.getSqlList().add(" update  CT_PAY_ScalingCountSum set cfpostname = '洁牙师' where cfbusinessdate = '"+businessDate+"' and cfcitynumber = '"+cityNumber+"' and cfpost = 'JYS' ");
 	    pe3.getSqlList().add(" update  CT_PAY_ScalingCountSum set cfpostname = '咨询师' where cfbusinessdate = '"+businessDate+"' and cfcitynumber = '"+cityNumber+"' and cfpost = 'ZXS' ");
 	    pe3.getSqlList().add(" update  CT_PAY_ScalingCountSum set cfpostname = '医生' where cfbusinessdate = '"+businessDate+"' and cfcitynumber = '"+cityNumber+"' and cfpost = 'YS' ");
 	    pe3.getSqlList().add(" update  CT_PAY_ScalingCountSum set cfpostname = '院长' where cfbusinessdate = '"+businessDate+"' and cfcitynumber = '"+cityNumber+"' and cfpost = 'YZ' "); 
     	pe3.getSqlList().add(" update  CT_PAY_ScalingCountSum set cfpostname = '门诊运营总监' where cfbusinessdate = '"+businessDate+"' and cfcitynumber = '"+cityNumber+"' and cfpost = 'MZYYZJ' "); 
     	pe3.getSqlList().add(" update  CT_PAY_ScalingCountSum set cfpostname = '兼职医生' where cfbusinessdate = '"+businessDate+"' and cfcitynumber = '"+cityNumber+"' and cfpost = 'JZYS' "); 
     	pe3.getSqlList().add(" update  CT_PAY_ScalingCountSum set cfpostname = '特殊兼职医生' where cfbusinessdate = '"+businessDate+"' and cfcitynumber = '"+cityNumber+"' and cfpost = 'TSJZYS' ");
     	pe3.getSqlList().add(" update  CT_PAY_ScalingCountSum set cfpostname = '城市运营总监' where cfbusinessdate = '"+businessDate+"' and cfcitynumber = '"+cityNumber+"' and cfpost = 'CSYYZJ' ");
     	 
    	
    	try {
			pe3.executeUpdate(ctx);
			pool3.shutdown(); 
		} catch (EASBizException e) { 
			e.printStackTrace();
			pool3.shutdown(); 
		} catch (BOSException e) { 
			e.printStackTrace();
			pool3.shutdown(); 
		}
		pool3.shutdown();  
	}


	
	
	/**
	 *  上海薪酬计算方式
	 * @param ctx
	 * @param businessDate
	 * @param userId
	 * @param cityID
	 * @param cityNumber
	 * @param cityName
	 * @param flag
	 * @throws Exception
	 * @throws BOSException
	 * @throws SQLException
	 */
	public void doShangHai(Context ctx, String businessDate,String userId,String cityID,String cityNumber,String cityName,boolean flag) throws Exception, BOSException, SQLException{
		
		/*String updateDOCyuliu = " update CT_PAY_OtherBonusSpilt set CFDocKeepBouns = 0 where CFBusinessdate = '"+businessDate+"' and CFCityID = '"+cityID+"'" ;
		DbUtil.execute(ctx, updateDOCyuliu);*/
		
		String updateDOCyuliu = " /*dialect*/update   CT_PAY_OtherBonusSpilt a  set  a.CFDOCKEEPBOUNS = ( " 
			+" select (case when cfdockeeptype = 'wu' then 0 when cfdockeeptype = 'two' then 2000 when cfdockeeptype = 'four' then 4000 when cfdockeeptype = 'eight' then 8000 when cfdockeeptype = 'pro' then 0.2 end ) keepamount "
			+" from CT_PAY_DoctorPerformance where cfdockeeptype is not null and cfbusinessdate = '"+businessDate+"' and   cfcityid = '"+cityID+"' "
			+" and  a.cfbusinessdate = cfbusinessdate and a.cfcityid = cfcityid and a.cfempnumber = cfempnumber ) where  a.cfbusinessdate = '"+businessDate+"'   and a.CFDOCKEEPBOUNS >0 ";
		DbUtil.execute(ctx, updateDOCyuliu);
	  
		updateDOCyuliu = " /*dialect*/ update CT_PAY_OtherBonusSpilt set CFDocKeepBouns = CFDocKeepBouns*nvl(CFMonthBase,0) where CFDocKeepBouns= 0.2 and CFBusinessdate = '"+businessDate+"' and CFCityID = '"+cityID+"'   "    ;
		DbUtil.execute(ctx, updateDOCyuliu);
		
		
		ExecutorService pool = Executors.newFixedThreadPool(6);
	    ParallelSqlExecutor pe = new ParallelSqlExecutor(pool); 
	    HashMap<Object, Object> tempMap = new HashMap<Object, Object>();
        HashMap<Object, Object> doctempMap = new HashMap<Object, Object>();
       
        HashMap<Object, Object> zixunMap = new HashMap<Object, Object>();
        //HashMap<Object, Object> dianZhangMap = new HashMap<Object, Object>();
        HashMap<Object, Object> shopMDGoalMap = new HashMap<Object, Object>();
        HashMap<Object, Object> kefuMap = new HashMap<Object, Object>();
        
        
        
        
        //先删除咨询预留的数据
        String deleteZXKeepSql = " /*dialect*/   delete  CT_PAY_ConsultKeep  where  CFCityID = '"+cityID+"'  and  CFBusinessDate ='"+businessDate+"' "; 
		DbUtil.execute(ctx, deleteZXKeepSql); 
        
        
        Map<String, String> mapAll = new HashMap<String, String>();
		PayFunctionService payFunctionService = new PayFunctionService();  
		PayShangHaiDocFunctionService payDocFunctionService= new PayShangHaiDocFunctionService();
		PayShangHaiDocCopyFunctionService payShangHaiDocCopyFunctionService= new PayShangHaiDocCopyFunctionService();
		
		String includeCitySql ="/*dialect*/ SELECT bill.cfrule as RULE,billorg.fid as bcityid ,billorg.fnumber as bcitynumber , entryorg.fid as ecityid ,entryorg.fnumber  as ecitynumber  from  CT_PAY_PayCity  bill left join CT_PAY_PayCityEntry entry on bill.fid = entry.fparentid  left join   T_ORG_BaseUnit billorg on billorg.fid = bill.cfcityid "+
  		" left join   T_ORG_BaseUnit entryorg on entryorg.fid = entry.cfincludecityid where billorg.fnumber = '"+cityNumber+"' ";
		IRowSet includecityrow = DbUtil.executeQuery(ctx, includeCitySql);
		//HashMap<String,ArrayList<String>>  incityMap = new HashMap<String,ArrayList<String>>();
		//ArrayList<String> cityArray = new ArrayList<String>();
		
		String type = "";
		String incityidStr = " in (";
		String incityNumStr = " in (";
		while(includecityrow.next()){
			type = includecityrow.getString("RULE");
			
  			String ecityid =  includecityrow.getString("ECITYID"); 
  			String ecityNumber = includecityrow.getString("ECITYNUMBER");   
  			incityidStr = incityidStr + "'"+ecityid+"',"; 
  			incityNumStr = incityNumStr + "'"+ecityNumber+"',"; 
		} 
		incityidStr = incityidStr.substring(0,incityidStr.length()-1) + " )";
		incityNumStr = incityNumStr.substring(0,incityNumStr.length()-1) + " )";
		 
		
		String companyIdSql =  " select base.fid as clinicid ,base.fnumber as clinicnumber,base.fname_l2 as  clinicname  from  CT_PAY_BudgetDate budge  " +
			" inner join T_ORG_BaseUnit base  on base.fid =  budge.cfcompanyid " +
			" where     budge.cfbusinessdate = '"+businessDate+"' and  base.FPARENTID   "+incityidStr+"   ";
		
		IRowSet comrow = DbUtil.executeQuery(ctx, companyIdSql.toString()); 
		
		ArrayList<HashMap<String, String>> companyList = new ArrayList<HashMap<String, String>>(); 
	    
	    HashMap<String ,HashMap<String, String>> companyMap = new HashMap<String ,HashMap<String, String>>();
	    while(comrow.next()){
	    	String clinicid = comrow.getString("CLINICID");
	    	String clinicNumber = comrow.getString("CLINICNUMBER");
			String clinicName = comrow.getString("CLINICNAME");
			HashMap<String, String> map= new HashMap<String, String>();
			map.put("CLINICNUMBER", clinicNumber);
			map.put("CLINICNAME", clinicName);
			map.put("CLINICID", clinicid);
			companyList.add(map);
			companyMap.put(clinicNumber,map);
	    }
	    
	    HashMap<String, String> personMap = new  HashMap<String, String>(); 
	    String  personSql = " select fname_l2 as name , fnumber  from t_bd_person where FCONTROLUNITID "+incityidStr+" ";
	    IRowSet personrow = DbUtil.executeQuery(ctx, personSql); 
	    while(personrow.next()){
	    	String name = personrow.getString("NAME");
	    	String number = personrow.getString("FNUMBER"); 
	    	personMap.put(number,name);
	    }
	    
	    
 
	    String dateSql = "";
		if(type.equals("ZC")){
			dateSql = "  to_char(tem.fbizdate, 'yyyymm') = '"+businessDate+"' and  ";
		}else if(type.equals("CBQR")){
			dateSql = "  tem.CFBUSINESSDATE = '"+businessDate+"' and  (tem.cfisneedout = 0 or ( tem.cfisneedout=1 and tem.cfisout = 1))  and  ";
		}
		
	  
			
		//查询医生所对应的门诊业绩是否存在
	    HashMap<String, String>  existYSMap = new HashMap<String, String>(); 
 
	    String existYSSql = " /*dialect*/ select   distinct  nvl(a.clinicnumber,'') as clinicnumber , nvl(a.cfrecdotnumber,'') as cfdocnumber    FROM ( SELECT   distinct  paypost.cfempnumber as  cfrecdotnumber ,nvl(tem.cfclinicnumber,'') as clinicnumber  from CT_PAY_PayPost paypost  "+
		"  inner join  CT_PAY_AchieveDetailTem tem on tem.CFRECDOTNUMBER  = paypost.cfempnumber and  "+dateSql+" tem.cfcitynumber "+incityNumStr+"   "+
		"  where   paypost.cfcityid ='"+cityID+"'  and  paypost.cfstatus='qy'   and paypost.cfpostnumber   in ('YS','JZYS','YZ') and  paypost.cfbusinessdate = '"+businessDate+"' and cfrecdotnumber is not null   "+
		"  union   SELECT   distinct  nvl(cfdocnumber,'') as cfdocnumber  ,nvl(cfclinicnumber,'') as clinicnumber  FROM  CT_PAY_DocAchieveUpdate  where cfcityid = '"+cityID+"' and cfbusinessdate = '"+businessDate+"' and  fname_l2 is null    ) a ";
	    
	    
	    IRowSet existYSrow = DbUtil.executeQuery(ctx, existYSSql.toString()); 
		//遍历eas中的数据 
		while (existYSrow.next()) { 
			String ysNumer = existYSrow.getString("CFDOCNUMBER"); 
			String clinicNumber = existYSrow.getString("CLINICNUMBER"); 
			existYSMap.put(ysNumer+clinicNumber,"1");
		}
		
		//查询咨询相关所对应的门诊业绩是否存在 
	    HashMap<String, String>  existZXMap = new HashMap<String, String>(); 
	    String existZXSql = "/*dialect*/  select distinct  paypost.cfempnumber AS EMPNUMBER ,baseunit.fnumber AS CLINICNUMBER from  CT_PAY_PayPost  paypost  left join T_ORG_BaseUnit baseunit on  baseunit.fid = paypost.cfclinicid "+
	    " where   paypost.cfbusinessdate = '"+businessDate+"' and (paypost.cfpostnumber='MZYYZJ' or paypost.cfpostnumber='FMZYYZJ' or paypost.cfpostnumber='CSYYZJ' ) and  paypost.cfcityid='"+cityID+"' and paypost.cfstatus = 'qy'"+
	    " union   select  distinct import.cfempnumber AS EMPNUMBER , import.cfclinicnumber AS CLINICNUMBER from CT_PAY_ConsultantBonusUpdate  import where   import.cfbusinessdate = '"+businessDate+"'  and  import.cfcityid='"+cityID+"'  ";
	    IRowSet existZXrow = DbUtil.executeQuery(ctx, existZXSql.toString()); 
		//遍历eas中的数据 
		while (existZXrow.next()) {  
			if(existZXrow.getObject("CLINICNUMBER")!= null && !existZXrow.getObject("CLINICNUMBER").equals("") ){
				String empNumer = existZXrow.getString("EMPNUMBER"); 
				String clinicNumber = existZXrow.getString("CLINICNUMBER"); 
				existZXMap.put(empNumer+clinicNumber,"1");
			} 
		}
	    
    	tempMap = PayMessage.getSHYJmbMessage(ctx,businessDate, cityID,tempMap);
        
		doctempMap = PayMessage.getDocMessage(ctx, businessDate,cityID, doctempMap);
		
		doctempMap.put("cityName", cityName);
		tempMap.put(cityNumber, cityName);
		zixunMap = PayMessage.getSHZiXunMessage(ctx, businessDate ,cityID , zixunMap);
		
		//dianZhangMap= PayMessage.getSHShopGoalMessage(ctx, businessDate ,cityID, dianZhangMap);
		
		shopMDGoalMap = PayMessage.getSHShopGoalMessage(ctx, businessDate ,cityID, shopMDGoalMap);
    
		kefuMap = PayMessage.getSHKeFuMessage(ctx, businessDate ,cityID, kefuMap);
 
		//查询上海洁牙导入的信息
		String importJy = " /*dialect*/ SELECT nvl(sum(sca.cfjycount),0) as JY , sca.cfempnumber EMPNUMBER ,  sca.cfclinicnumber CLINICNUMBER,type.cfjynumber JYNUMBER FROM  CT_PAY_ScalingBonusUpdate sca left join CT_PAY_ScalingType type on  sca.CFJyTypeID  = type.fid  and type.cfcityid = '"+cityID+"'  "+
		"  where   sca.cfcityid = '"+cityID+"' and sca.cfbusinessdate = '"+businessDate+"'    group by sca.cfempnumber ,  sca.cfclinicnumber,type.cfjynumber ";
		Map<String, BigDecimal> scalingMap  = getShangHaiImpScalingCoount(ctx,importJy);
		 
		
		HashMap<String,HashMap<String,String>>  jieyaAllTypeMap = new HashMap<String,HashMap<String,String>>();
		jieyaAllTypeMap = PayMessage.getJYItemMessage(ctx,businessDate,cityID,jieyaAllTypeMap);
		
		HashMap<String,String>  jieyaitemStrMap = PayMessage.getJYItemMessage(ctx,businessDate,cityID);
		String jieyaOneItem = jieyaitemStrMap.get("onejyStr");
		String jieyaTwoItem = jieyaitemStrMap.get("twojyStr");
		String jieyaThreeItem = jieyaitemStrMap.get("threejyStr");
		
		//把已经给医生计算的业绩不给医生计算
		String  updateHSSql = " /*dialect*/   update  CT_PAY_AchieveDetailTem  set cfiscount = 0   where  cfcitynumber "+incityNumStr+" and  to_char(fbizdate,'YYYYMM') = '"+businessDate+"' "+
		" AND  ( CFFIRCLASSNUMBER in ("+jieyaOneItem+") or CFSECCLASSNUMBER  in ("+jieyaTwoItem+") or  CFFeeItemDetailNumber in ("+jieyaThreeItem+") ) and CFNURSENUMBER   is not null  ";
		DbUtil.execute(ctx, updateHSSql); 
		
		 
		//获得护士所有的洁牙汇总
		HashMap<String,BigDecimal>  xtJieYaCountMap  = getSHJieYaXTCount(ctx,incityNumStr,cityNumber, businessDate,cityID, tempMap,scalingMap,jieyaAllTypeMap);
		 
		//护士 --洁牙
		StringBuffer hsSql = new StringBuffer();
		hsSql.append(" /*dialect*/select  a.cfrecdotnumber as cfrecdotnumber  , a.clinicnumber as clinicnumber  from ( ");
		hsSql.append("		select emplist.cfrecdotnumber , emplist.clinicnumber   from  ( ");
		hsSql.append("			select  tem.cfnursenumber cfrecdotnumber , tem.cfclinicnumber clinicnumber  from  CT_PAY_AchieveDetailTem  tem where  cfcitynumber   "+incityNumStr+" and to_char(fbizdate,'YYYYMM') = '"+businessDate+"' ");
		hsSql.append("			and tem.cfnursenumber  in  ( select   distinct  paypost.cfempnumber as  cfrecdotnumber  from CT_PAY_PayPost paypost where paypost.cfcityid ='"+cityID+"' and  paypost.cfstatus='qy'   and paypost.cfpostnumber ='HS' and  paypost.cfbusinessdate = '"+businessDate+"' )    ");
		hsSql.append("          and  ( CFFIRCLASSNUMBER in ("+jieyaOneItem+") or CFSECCLASSNUMBER  in ("+jieyaTwoItem+") or  CFFeeItemDetailNumber in ("+jieyaThreeItem+") ) ");
		hsSql.append("		)  emplist  "); 
		hsSql.append(" union    select cfempnumber as cfrecdotnumber  , cfclinicnumber clinicnumber  from  CT_PAY_ScalingBonusUpdate  emplist ");
		hsSql.append("  where  cfcityid ='"+cityID+"'  and  cfbusinessdate =  '"+businessDate+"'    "); 
		hsSql.append(" ) a    ");
			
		
		IRowSet hsrow = DbUtil.executeQuery(ctx, hsSql.toString()); 
		//遍历eas中的数据 
		
		CoreBaseCollection scalingCountSumCollection = new CoreBaseCollection();
		while (hsrow.next()) { 
		//while (hsrow.size() < 0) { 
			String clinicNumber = hsrow.getString("CLINICNUMBER");
			HashMap<String, String> cliniMap = companyMap.get(clinicNumber); 
			String clinicName = cliniMap.get("CLINICNAME");
			String docNumer = hsrow.getString("CFRECDOTNUMBER"); 
			String empName = "";
			
			if(personMap.get(docNumer) != null){
				empName  = personMap.get(docNumer);
			}else{
				PersonInfo person = PersonFactory.getLocalInstance(ctx).getPersonCollection(" where number = '"+docNumer+"' " ).get(0);
				if( person != null){
					empName = person.getName();
					personMap.put(docNumer, empName);
				}
				
			}
			
			String postType = ""; 
			tempMap.put("empName",empName);
			tempMap.put("clinicName",clinicName);
			HashMap<String,String>  djieyaMap = new HashMap<String,String>();
			HashMap<String,String>  mbMap = new HashMap<String,String>();
			
			HashMap<String,Object>  docMap = new HashMap<String,Object>();
		 
			//djieyaMap = payFunctionService.getSHHSScalingBonus(ctx,docNumer, clinicNumber, cityNumber, businessDate,cityID, tempMap);
			//djieyaMap = payFunctionService.getSHHSScalingBonus(ctx,docNumer, clinicNumber, cityNumber, businessDate,cityID, tempMap,"HS",scalingMap,jieyaTypeMap);
			
			ArrayList<String> arrayList = new ArrayList<String>();
			arrayList = (ArrayList<String>) tempMap.get(cityID+"_JY");
			  
			int i = 0;
			for(String str : arrayList ){
				String[] arr = str.split("#");
				String typeNumber = "";
				String typeName = "";
				String jyNumber = "";
				String jyid = "";
				if(arr.length == 1 ){
					typeNumber = arr[0];  
				}else if(arr.length == 2){
					typeNumber = arr[0];  typeName = arr[1]; jyNumber = typeNumber;
				}else if(arr.length == 3){
					typeNumber = arr[0];  typeName = arr[1]; jyNumber = arr[2];
				}else if(arr.length == 4){
					typeNumber = arr[0];  typeName = arr[1]; jyNumber = arr[2]; jyid = arr[3];
				} 
				BigDecimal jycount =BigDecimal.ZERO;
				BigDecimal xtjycount =BigDecimal.ZERO;
				BigDecimal imjycount =BigDecimal.ZERO;
				 
				imjycount =  scalingMap.get(docNumer+"_"+clinicNumber+"_"+jyNumber +"_IM")==null?BigDecimal.ZERO:scalingMap.get(docNumer+"_"+clinicNumber+"_"+jyNumber +"_IM"); 
				xtjycount = xtJieYaCountMap.get(docNumer+"_"+clinicNumber+"_"+jyNumber +"_XT")==null?BigDecimal.ZERO:xtJieYaCountMap.get(docNumer+"_"+clinicNumber+"_"+jyNumber +"_XT"); 
				if(imjycount==null){
					imjycount=BigDecimal.ZERO;
				}
				jycount = xtjycount.add(imjycount);
				
				if(jycount.compareTo(BigDecimal.ZERO) != 0 || xtjycount.compareTo(BigDecimal.ZERO) != 0   ){
					com.kingdee.eas.mw.pay.ScalingCountSumInfo scalingCount = new com.kingdee.eas.mw.pay.ScalingCountSumInfo();
					scalingCount.setBusinessDate(businessDate);
					scalingCount.setCityNumber(cityNumber);
					scalingCount.setCityName(tempMap.get(cityNumber).toString());
					scalingCount.setEmpNumber(docNumer); 
					scalingCount.setEmpName(empName);
					
					scalingCount.setClinicNumber(clinicNumber); 
					scalingCount.setClinicName(clinicName);
					
					 
					ScalingTypeInfo sctype = new ScalingTypeInfo();
					sctype.setId(BOSUuid.read(jyid));
					scalingCount.setType(sctype);
					scalingCount.setXtCount(xtjycount);
					scalingCount.setImpCount(imjycount);
					scalingCount.setAllCount(jycount);
					scalingCount.setPost(PaypostType.getEnum("HS"));
					scalingCountSumCollection.add(scalingCount);
					//ScalingCountSumFactory.getLocalInstance(ctx).save(scalingCount);
				}  
				i++; 
			} 
		} 

		if(scalingCountSumCollection.size() > 0 ){
			ScalingCountSumFactory.getLocalInstance(ctx).save(scalingCountSumCollection);
		}
		
		
		//免工作量比例
		BigDecimal freeWorkPro = BigDecimal.ZERO;  
		//赠金比例
		BigDecimal gifAmountPro = BigDecimal.ZERO; 
		
		HashMap tongyongmap = (HashMap)tempMap.get("TONGYONGBILI_DOC");
		freeWorkPro = new BigDecimal(tongyongmap.get("CFFREEWORKPRO").toString());   
		gifAmountPro =  new BigDecimal(tongyongmap.get("CFGIFAMOUNTPRO").toString());
		String mbbili  = tempMap.get("MBBILI").toString();
		
		
		HashMap<String,HashMap<String,String>> itemMessage = new HashMap<String,HashMap<String,String>>();
		itemMessage = PayMessage.getMBItemMessage(ctx, businessDate ,cityID, itemMessage); 
		HashMap<String,String>  oneItemMap = itemMessage.get("one");
		HashMap<String,String>  twoItemMap = itemMessage.get("two");
		HashMap<String,String>  threeItemMap = itemMessage.get("three");
		
		String mbOne = "''";
		String mbTwo = "''";
		String mbThree = "''";
		mbOne = oneItemMap.get("MB")==null? "''": oneItemMap.get("MB");
		mbTwo = twoItemMap.get("MB")==null? "''": twoItemMap.get("MB");
		mbThree = threeItemMap.get("MB")==null? "''": threeItemMap.get("MB"); 
		 
		
		BigDecimal mbachieve =BigDecimal.ZERO;
		 
		HashMap<String,BigDecimal> mbAllMap = new HashMap<String,BigDecimal>();
		String sqlMBStr = " /*dialect*/ SELECT cfempnumber,cfclinicnumber,nvl(sum(cfmbachieve),0) as MB, 'IM' AS TYPE  FROM  CT_PAY_WhiteBonusUpdate   "+
					    " where   cfcityid = '"+cityID+"' and  cfbusinessdate = '"+businessDate+"' group by cfempnumber,cfclinicnumber "+
					    " union select  cfnursenumber,  cfclinicnumber ,sum(MBACHIEVE )  as MBACHIEVE , 'XT' AS TYPE from  ( "+
						" select cfnursenumber,  cfclinicnumber, (nvl(sum(tem.cfpayment),0)- nvl(sum(nvl(tem.cfgiftpayment,0) *"+gifAmountPro+" ),0) ) as MBACHIEVE   FROM  CT_PAY_AchieveDetailTem tem  "+
						" where     to_char(fbizdate,'YYYYMM') ='"+businessDate+"'   and    cfcitynumber "+incityNumStr+"  and    (cfincome!=0 or cfpayment!=0) and  cfnursenumber is not  null and "+
					    " (tem.cffirclassnumber in  ("+mbOne+") or tem.cfsecclassnumber in ("+mbTwo+") or tem.cffeeitemdetailnumber in  ("+mbThree+") )  group by    cfnursenumber,  cfclinicnumber    "+
					    " union select  cfnursenumber,  cfclinicnumber ,(nvl(sum(cforiprice*cfqty)*"+freeWorkPro+",0)) as MBACHIEVE   FROM  CT_PAY_AchieveDetailTem tem "+
					    " where  to_char(fbizdate,'YYYYMM') ='"+businessDate+"'  and cfcitynumber "+incityNumStr+"  and cfincome=0 and  cfpayment=0   and cfnursenumber is not  null and "+
					    " ( tem.cffirclassnumber in  ("+mbOne+") or tem.cfsecclassnumber in ("+mbTwo+") or tem.cffeeitemdetailnumber in  ("+mbThree+") ) group by    cfnursenumber,  cfclinicnumber    ) group by    cfnursenumber,  cfclinicnumber    ";
		IRowSet rsMbMb =  DBUtil.executeQuery(ctx,sqlMBStr);
		if(rsMbMb!=null && rsMbMb.size() > 0){
		//if(rsMbMb!=null && rsMbMb.size() ==  0){
			  while(rsMbMb.next()){
				  mbachieve = new BigDecimal(rsMbMb.getString("MB"));  
				  String mbtype = rsMbMb.getString("TYPE");
				  String clinicNumber = rsMbMb.getString("CFCLINICNUMBER");
				  String empNumber = rsMbMb.getString("CFEMPNUMBER");
				  mbAllMap.put(empNumber+"_"+clinicNumber+"_"+mbtype, mbachieve);
			  }
		}
		
		//护士 --美白
		StringBuffer hsMBSql = new StringBuffer();//  
		hsMBSql.append(" /*dialect*/select  a.cfrecdotnumber as cfrecdotnumber  , a.clinicnumber as clinicnumber from ( ");
		hsMBSql.append("		select emplist.cfrecdotnumber , emplist.clinicnumber   from  ( ");
		hsMBSql.append("			select  tem.cfnursenumber cfrecdotnumber , tem.cfclinicnumber clinicnumber  from  CT_PAY_AchieveDetailTem  tem where  cfcitynumber "+incityNumStr+" and to_char(fbizdate,'YYYYMM') = '"+businessDate+"' ");
		hsMBSql.append("			and tem.cfnursenumber  in  ( select   distinct  paypost.cfempnumber as  cfrecdotnumber  from CT_PAY_PayPost paypost where paypost.cfcityid ='"+cityID+"' and  paypost.cfstatus='qy'   and paypost.cfpostnumber ='HS' and  paypost.cfbusinessdate = '"+businessDate+"' )    ");
		hsMBSql.append("          and  (  tem.cffirclassnumber in  ("+mbOne+") or tem.cfsecclassnumber in ("+mbTwo+") or tem.cffeeitemdetailnumber in  ("+mbThree+") )  ");
		hsMBSql.append("		)  emplist   ");  
		hsMBSql.append(" union select cfempnumber as cfrecdotnumber   , cfclinicnumber clinicnumber    from  CT_PAY_WhiteBonusUpdate emplist ");
		hsMBSql.append("   where  cfcityid ='"+cityID+"'   and  cfbusinessdate =  '"+businessDate+"'  ");
		hsMBSql.append(" ) a  ");
			
		
		IRowSet hsMBrow = DbUtil.executeQuery(ctx, hsMBSql.toString()); 
		//遍历eas中的数据 
		while (hsMBrow.next()) { 
		//while (hsrow.size() < 0) { 
			String clinicNumber = hsMBrow.getString("CLINICNUMBER");
			HashMap<String, String> cliniMap = companyMap.get(clinicNumber); 
			String clinicName = cliniMap.get("CLINICNAME");
			String docNumer = hsMBrow.getString("CFRECDOTNUMBER"); 
			String empName = "";
			
			if(personMap.get(docNumer) != null){
				empName  = personMap.get(docNumer);
			}else{
				PersonInfo person = PersonFactory.getLocalInstance(ctx).getPersonCollection(" where number = '"+docNumer+"' " ).get(0);
				if( person != null){
					empName = person.getName();
					personMap.put(docNumer, empName);
				}
			}
			String postType = ""; 
			tempMap.put("empName",empName); 
			HashMap<String,String>  mbMap = new HashMap<String,String>();
			
			HashMap<String,Object>  docMap = new HashMap<String,Object>(); 
			 
			BigDecimal immbAchieve = mbAllMap.get(docNumer+"_"+clinicNumber+"_IM");
			if(immbAchieve == null ){
				immbAchieve = BigDecimal.ZERO;
			}
			BigDecimal xtmbAchieve = mbAllMap.get(docNumer+"_"+clinicNumber+"_XT");
			if(xtmbAchieve == null ){
				xtmbAchieve = BigDecimal.ZERO;
			}
			 
			postType =  "HS"; 
			
			//美白 
			BigDecimal mbAchieve = xtmbAchieve.add(immbAchieve);  
			BigDecimal meiibaiBonus = BigDecimal.ZERO;
			
			meiibaiBonus = mbAchieve.multiply(new BigDecimal(mbbili));
			
			//mbMap = payFunctionService.getSHHSWhiteBonus(ctx,docNumer,clinicNumber, cityNumber, businessDate, cityID,tempMap , oneItemMap ,twoItemMap , threeItemMap);
			 
			String docJiangjin = "0";
			String cost = "0"; 
			doctempMap.put("empName", empName);
			 
			   
			if(  BigDecimal.ZERO.compareTo(meiibaiBonus) !=0  ){
				flag = true;
				StringBuffer sbr  = new StringBuffer(" /*dialect*/insert into CT_PAY_AchienementSum (FID,FCreatorID,FCreateTime,FLastUpdateUserID,FLastUpdateTime, ");
	    		sbr.append("cfposttype,cfbusinessdate, CFCLINICNUMBER,CFCLINICName,cfempnumber,cfempname,CFCITYNUMBER,CFCITYName,CFScalingBonus, CFWhiteBonus , CFDocBonus , CFDOCCOST , CFConBonus ,CFOtherPostBonus ,CFShopGoalBonus ) ");
	    		sbr.append("values(newbosid('4AF58046'),'"+userId+"',sysdate,'"+userId+"',sysdate, ");
	    		sbr.append(" '"+postType+"',  '"+businessDate+"','"+clinicNumber+"','"+clinicName+"' ,'"+docNumer+"','"+empName+"','"+cityNumber+"','"+cityName+"' , 0  , "+meiibaiBonus+" ,"+docJiangjin+" , "+cost+" , 0 ,0,0  )"); 
	    		//sbr.append("'"+clinicNumber+"','' ,'"+docNumer+"','','"+cityNumber+"','' , "+jieyaBonus+" , "+meiibaiBonus+" ,"+docBonus+"   )"); 
	    		
	    		if( null == docMap.get("EXISTS") || "NO".equals(docMap.get("EXISTS").toString())){
	    			StringBuffer sbr2  = new StringBuffer(" /*dialect*/insert into CT_PAY_ClinicAchieveCosthSum (FID,FCreatorID,FCreateTime,FLastUpdateUserID,FLastUpdateTime, ");
	    			sbr2.append(" cfimjycount,cfimplacount,cfxtjycount,cfxtplacount,CFIMWhiteAchieve,CFXTWhiteAchieve, ");
	    			sbr2.append(" CFXtcosydzCount,CFImcosydzCount,CFCosydzCount,CFXtcosyfdzCount,CFImcosyfdzCount,CFCosyfdzCount, ");
		    		sbr2.append(" cfposttype , cfbusinessdate, CFCLINICNUMBER,CFCLINICName,cfempnumber,cfempname,CFCITYNUMBER,CFCITYName,CFJyCount, CFPlaCount , CFWhiteAchieve  ) ");
		    		sbr2.append("values(newbosid('20D1E187'),'"+userId+"',sysdate,'"+userId+"',sysdate, ");
		    		sbr2.append("  0,0,0,0, "+immbAchieve+","+xtmbAchieve+",");
		    		sbr2.append(" 0,0,0,0, 0,0,");
		    		sbr2.append(" '"+postType+"', '"+businessDate+"','"+clinicNumber+"','"+clinicName+"' ,'"+docNumer+"','"+empName+"','"+cityNumber+"','"+cityName+"' ,0 ,0 ,"+mbAchieve+" )");  
		    		pe.getSqlList().add(sbr2); 
		    		
	    		}else{
	    			ClinicAchieveCosthSumInfo  clinicAchieveCosthSumInfo =  (ClinicAchieveCosthSumInfo) docMap.get("ClinicAchieveCosthSumInfo"); 
	    			clinicAchieveCosthSumInfo.setWhiteAchieve(clinicAchieveCosthSumInfo.getWhiteAchieve().add(mbAchieve)); 
	    		 
	    			ClinicAchieveCosthSumFactory.getLocalInstance(ctx).save(clinicAchieveCosthSumInfo);
	    		}
	    		pe.getSqlList().add(sbr);
			} 
			
		}
		
		
		HashMap<String,HashMap<String,String>>  zxAchieveMap = new HashMap<String,HashMap<String,String>>();
		String zximSql = "/*dialect*/ SELECT cfempnumber,cfclinicnumber,nvl(sum(cfzxachieve),0) as ZX , nvl(sum(cfallGenAchieve),0)  as QK , nvl(sum(cfzpAchieve),0)  as ZB   FROM  CT_PAY_ConsultantBonusUpdate   where   cfcityid = '"+cityID+"' and  cfbusinessdate = '"+businessDate+"'  group by cfempnumber,cfclinicnumber";
		IRowSet rsImZX =  DBUtil.executeQuery(ctx,zximSql);
		if(rsImZX!=null && rsImZX.size() > 0){
			  while(rsImZX.next()){	
				  HashMap<String,String>  zxMap = new HashMap<String,String>();
				  zxMap.put("QK", rsImZX.getString("QK"));
				  zxMap.put("ZX", rsImZX.getString("ZX"));
				  zxMap.put("CFEMPNUMBER", rsImZX.getString("CFEMPNUMBER"));
				  zxMap.put("CFCLINICNUMBER", rsImZX.getString("CFCLINICNUMBER"));
				  zxMap.put("ZB", rsImZX.getString("ZB")); 
				  zxAchieveMap.put(rsImZX.getString("CFEMPNUMBER")+"_"+rsImZX.getString("CFCLINICNUMBER"), zxMap);
			  }
		}
		
		
		shopMDGoalMap.put("cityName", cityName); 
		String postSql = "/*dialect*/ select   distinct  paypost.cfempnumber as CFEMPNUMBER ,  paypost.cfpostnumber as POSTTYPE  from CT_PAY_PayPost paypost where paypost.cfcityid ='"+cityID+"' and  paypost.cfstatus='qy'   and paypost.cfpostnumber in ('MZYYZJ','FMZYYZJ','CSYYZJ') and  paypost.cfbusinessdate = '"+businessDate+"'  ";//'MS310100198','MS310100064','MS310100244',
		IRowSet rs = com.kingdee.eas.custom.util.DBUtil.executeQuery(ctx,postSql); 
		if(rs!=null && rs.size() > 0){
		//if(rs!=null && rs.size() == 0){
			  while(rs.next()){	  
				  String empNumber= rs.getString("CFEMPNUMBER");
				  String empName = "";
				  if(personMap.get(empNumber) != null){
						empName  = personMap.get(empNumber);
				  }else{
					  PersonInfo person = PersonFactory.getLocalInstance(ctx).getPersonCollection(" where number = '"+empNumber+"' " ).get(0);
					  
					  if( person != null){
							empName = person.getName();
							personMap.put(empNumber, empName);
					  }
				  }
					
				  
				  String postType= rs.getString("POSTTYPE");
				  for(int i=0; i <companyList.size();i++) { 
					  String clinicNumber = companyList.get(i).get("CLINICNUMBER");
					  String clinicName = companyList.get(i).get("CLINICNAME");
					  String clinicId = companyList.get(i).get("CLINICID");  
					  if(existZXMap.get(empNumber+clinicNumber)!= null && existZXMap.get(empNumber+clinicNumber).equals("1")){
						  //PersonInfo person = PersonFactory.getLocalInstance(ctx).getPersonCollection(" where number = '"+empNumber+"' " ).get(0);
						  
						  shopMDGoalMap.put("empName", empName);
						 
						  String companyId = ""; 
						  String postClinicSql = "/*dialect*/  select   distinct  nvl(paypost.cfclinicid,'') as  CFCLINICID,paypost.cfpostnumber  as POSTNUMBER  from CT_PAY_PayPost paypost where paypost.cfempnumber ='"+empNumber+"' and  paypost.cfcityid ='"+cityID+"' and  paypost.cfclinicid ='"+clinicId+"' and  paypost.cfstatus='qy'   and paypost.cfpostnumber   in ('MZYYZJ','FMZYYZJ','CSYYZJ')  and  paypost.cfbusinessdate = '"+businessDate+"' ";
						  IRowSet clinicrs = com.kingdee.eas.custom.util.DBUtil.executeQuery(ctx,postClinicSql); 
						  HashMap<String, String> clinicMap = new HashMap<String, String>();
						  while(clinicrs.next()){	 
							 companyId =  clinicrs.getString("CFCLINICID")== null? "":clinicrs.getString("CFCLINICID");  
							 postType =  clinicrs.getString("POSTNUMBER")== null? "":clinicrs.getString("POSTNUMBER");  
						  }
						  boolean clinicflag = false;
						  if(!companyId.equals("")){
							  clinicflag = true;
						  }/*else{
							  //不是这个门店的店长或者副店长  那就是咨询师
							  postType = "ZXS";
						  }*/
						  
						  HashMap<String,String>  getDianZhangMap = new HashMap<String,String>();
						  String imotherAchieve = "0";
						  String xtotherAchieve = "0";
						  //门店业绩提成
						  String shopMDAmount = "0"; 
						  //门店达成目标 奖励金额
						  String getGlopAmount =  "0";
						  //咨询金额
						  String zxAmount =  "0";
						  String allAmount =  "0";
						  String allKeAchieve = "0";
						  
						  HashMap<String,String>  zxMap = new HashMap<String,String>();
						  if(zxAchieveMap.get(empNumber+"_"+clinicNumber) != null){
							  zxMap = zxAchieveMap.get(empNumber+"_"+clinicNumber);
						  }
						  getDianZhangMap = payFunctionService.getSHDZPostAch(ctx,empNumber,clinicName,clinicNumber, cityNumber,cityID, businessDate,clinicflag, shopMDGoalMap,postType,zxMap);
						  if(null !=getDianZhangMap && null != getDianZhangMap.get("allAmount")  ){
							  allAmount = getDianZhangMap.get("allAmount"); 
							  imotherAchieve = getDianZhangMap.get("imotherAchieve"); 
							  xtotherAchieve = getDianZhangMap.get("xtotherAchieve"); 
							  
							  shopMDAmount = getDianZhangMap.get("shopMDAmount"); 
							  getGlopAmount = getDianZhangMap.get("getGlopAmount"); 
							  zxAmount = getDianZhangMap.get("zxAmount");  
							  //allKeAchieve = getDianZhangMap.get("qkAchieve"); 
							   
						  }
						  //获取门店目标
						  if(BigDecimal.ZERO.compareTo(new BigDecimal(shopMDAmount)) !=0 || BigDecimal.ZERO.compareTo(new BigDecimal(getGlopAmount)) !=0 || BigDecimal.ZERO.compareTo(new BigDecimal(zxAmount)) !=0  ){
							   
							  flag = true;
							  StringBuffer sbr  = new StringBuffer(" /*dialect*/ insert into CT_PAY_AchienementSum (FID,FCreatorID,FCreateTime,FLastUpdateUserID,FLastUpdateTime, fsimplename ,");
					    	  sbr.append(" cfposttype, cfbusinessdate, CFCLINICNUMBER,CFCLINICName,cfempnumber,cfempname,CFCITYNUMBER,CFCITYName,CFScalingBonus, CFWhiteBonus , CFDocBonus , CFConBonus ,CFOtherPostBonus ,CFShopGoalBonus ) ");
					    	  sbr.append("values(newbosid('4AF58046'),'"+userId+"',sysdate,'"+userId+"',sysdate, '1',");
					    	  sbr.append(" '"+postType+"',  '"+businessDate+"','"+clinicNumber+"','"+clinicName+"' ,'"+empNumber+"','"+empName+"','"+cityNumber+"','"+cityName+"' , 0 ,0,0,"+zxAmount+","+shopMDAmount+" ,"+getGlopAmount+"  ) "); 
					    	  //sbr.append(" '"+businessDate+"','"+clinicNumber+"','"+clinicName+"' ,'"+empNumber+"','','"+cityNumber+"','"+cityName+"' , 0 ,0,0,0,"+otherBonus+" ,0  ) ");
					    	  pe.getSqlList().add(sbr); 
					    	  
					    	  StringBuffer sbr2  = new StringBuffer(" /*dialect*/insert into CT_PAY_ClinicAchieveCosthSum (FID,FCreatorID,FCreateTime,FLastUpdateUserID,FLastUpdateTime, ");
					    	  sbr2.append("cfposttype , cfbusinessdate, CFCLINICNUMBER,CFCLINICName,cfempnumber,cfempname,CFCITYNUMBER,CFCITYName, CFZxAchieve ,CFimZxAchieve, CFxtZxAchieve ,cfallKeAchieve) ");
					    	  sbr2.append("values(newbosid('20D1E187'),'"+userId+"',sysdate,'"+userId+"',sysdate, ");
					    	  sbr2.append(" '"+postType+"', '"+businessDate+"','"+clinicNumber+"','"+clinicName+"' ,'"+empNumber+"','"+empName+"','"+cityNumber+"','"+cityName+"' ,"+imotherAchieve+" ,"+imotherAchieve+"  ,"+xtotherAchieve+" ,"+allKeAchieve+" )");  
			    	    		
					    	  pe.getSqlList().add(sbr2); 
						  }
					  }
					  
				  }
				   
			  }
		 }   
		 
		zixunMap.put("cityName", cityName); 
		//咨询师
		String zxSql = "/*dialect*/  select   distinct  paypost.cfempnumber as CFEMPNUMBER   , paypost.cfpostnumber as POSYNUMBER from CT_PAY_PayPost paypost where paypost.cfcityid ='"+cityID+"' and  paypost.cfstatus='qy'   and paypost.cfpostnumber   in ( 'ZXS','KF') and  paypost.cfbusinessdate = '"+businessDate+"'  ";
		IRowSet zxrs = com.kingdee.eas.custom.util.DBUtil.executeQuery(ctx,zxSql); 
		if(zxrs!=null && zxrs.size() > 0){
		//if(zxrs!=null && zxrs.size() == 0){
			while(zxrs.next()){	     
				String empNumber= zxrs.getString("CFEMPNUMBER");
				String empName = "";
				if(personMap.get(empNumber) != null){
					empName  = personMap.get(empNumber);
				}else{
					 PersonInfo person = PersonFactory.getLocalInstance(ctx).getPersonCollection(" where number = '"+empNumber+"' " ).get(0);
					 if( person != null){
							empName = person.getName();
							personMap.put(empNumber, empName);
					 }
				}
				
				String postType= zxrs.getString("POSYNUMBER");  
				zixunMap.put("empName", empName);
				for(int i=0; i <companyList.size();i++) {  
					String clinicNumber = companyList.get(i).get("CLINICNUMBER");
					String clinicName = companyList.get(i).get("CLINICNAME");
					
					//String postType = "ZXS"; 
					if(existZXMap.get(empNumber+clinicNumber) != null && existZXMap.get(empNumber+clinicNumber).equals("1")){
						HashMap<String,String>  zxMap = new HashMap<String,String>();
						if(zxAchieveMap.get(empNumber+"_"+clinicNumber) != null){
							zxMap = zxAchieveMap.get(empNumber+"_"+clinicNumber);
						}
						String zixunBonus = "0";
						String zxAchieve = "0";
						String imzxAchieve = "0";
						String xtzxAchieve = "0";
						String allKeAchieve = "0";
						
						zxMap = payFunctionService.getSHConsultantBonus(ctx,empNumber,clinicNumber,clinicName, cityNumber, businessDate,cityID, zixunMap,zxMap); 
						if( null !=  zxMap  ){
							if(  null !=  zxMap.get("zixunBonus")   ){
								zixunBonus = zxMap.get("zixunBonus");
							}
							if(  null !=  zxMap.get("zxAchieve")   ){
								zxAchieve = zxMap.get("zxAchieve");
							} 
							if(  null !=  zxMap.get("imzxAchieve")   ){
								imzxAchieve = zxMap.get("imzxAchieve");
							} 
							if(  null !=  zxMap.get("xtzxAchieve")   ){
								xtzxAchieve = zxMap.get("xtzxAchieve");
							} 
							/*if(  null !=  zxMap.get("qkAchieve")   ){
								allKeAchieve = zxMap.get("qkAchieve");
							}  */
							postType = zxMap.get("postType");
						} 
						if(BigDecimal.ZERO.compareTo(new BigDecimal(zixunBonus)) !=0){
							flag = true;
							StringBuffer sbr  = new StringBuffer(" /*dialect*/ insert into CT_PAY_AchienementSum (FID,FCreatorID,FCreateTime,FLastUpdateUserID,FLastUpdateTime, ");
				    		sbr.append(" cfposttype,cfbusinessdate, CFCLINICNUMBER,CFCLINICName,cfempnumber,cfempname,CFCITYNUMBER,CFCITYName,CFScalingBonus, CFWhiteBonus , CFDocBonus , CFConBonus ,CFOtherPostBonus ,CFShopGoalBonus ) ");
				    		sbr.append("values(newbosid('4AF58046'),'"+userId+"',sysdate,'"+userId+"',sysdate, ");
				    		//sbr.append("'"+clinicNumber+"','"+clinicName+"' ,'"+docNumer+"','"+docName+"','"+cityNumber+"','"+cityName+"' , 0 ,0,0,"+zixunBonus+","+otherBonus+" ,"+shopGoalBonus+"  ) "); 
				    		//sbr.append(" '"+businessDate+"','"+clinicNumber+"','"+clinicName+"' ,'"+docNumer+"','','"+cityNumber+"','"+cityName+"' , 0 ,0,0,"+zixunBonus+","+otherBonus+" ,"+shopGoalBonus+"  ) ");
				    		sbr.append("  '"+postType+"', '"+businessDate+"','"+clinicNumber+"','"+clinicName+"' ,'"+empNumber+"','"+empName+"','"+cityNumber+"','"+cityName+"' , 0 ,0,0,"+zixunBonus+", 0 ,0  ) ");
				    		pe.getSqlList().add(sbr);
				    		
				    		StringBuffer sbr2  = new StringBuffer(" /*dialect*/insert into CT_PAY_ClinicAchieveCosthSum (FID,FCreatorID,FCreateTime,FLastUpdateUserID,FLastUpdateTime, ");
				    		sbr2.append(" cfposttype , cfbusinessdate, CFCLINICNUMBER,CFCLINICName,cfempnumber,cfempname,CFCITYNUMBER,CFCITYName, CFZxAchieve,CFimZxAchieve,CFxtZxAchieve ,cfallKeAchieve ) ");
				    		sbr2.append("values(newbosid('20D1E187'),'"+userId+"',sysdate,'"+userId+"',sysdate, ");
				    		sbr2.append("'"+postType+"','"+businessDate+"','"+clinicNumber+"','"+clinicName+"' ,'"+empNumber+"','"+empName+"','"+cityNumber+"','"+cityName+"' ,"+zxAchieve+" ,"+imzxAchieve+","+xtzxAchieve+" ,"+allKeAchieve+")");  
				    		
				    		pe.getSqlList().add(sbr2);
				    		
						}
					} 
				}
			}
		}
		
		String  calType = "";
		String  calTypeSql = "/*dialect*/  SELECT   CFCALTYPE  FROM CT_PAY_DocCurrencyPro  where  cfcityid= '"+cityID+"' and cfbusinessdate='"+businessDate+"'";
		IRowSet calTypeRs = com.kingdee.eas.custom.util.DBUtil.executeQuery(ctx,calTypeSql);
		if(calTypeRs!=null && calTypeRs.size() > 0){
			while(calTypeRs.next()){
				calType = calTypeRs.getString("CFCALTYPE");
			}
		}
		if("ljxy".equals(calType)){
			String  deleteFentan = "/*dialect*/   delete  CT_PAY_DocAchieveUpdate where    cfcityid= '"+cityID+"' and cfbusinessdate='"+businessDate+"' and  fname_l2 = '分摊扣除业绩'";
			com.kingdee.eas.custom.util.DBUtil.execute(ctx,deleteFentan);
		}
		 
		
		HashMap<String,String> docExisStagemap = new HashMap<String,String>();
		String docExistSql = " /*dialect*/ select  distinct CFEmpNumber ,CFType  from  CT_PAY_DocStage where  CFCityID = '"+cityID+"' and CFBusinessDate = "+businessDate+"    ";
		IRowSet docExistrs = com.kingdee.eas.custom.util.DBUtil.executeQuery(ctx,docExistSql);
		if(docExistrs!=null && docExistrs.size() > 0){
			 while(docExistrs.next()){	
				 String doctype = docExistrs.getString("CFTYPE");
				 if(docExisStagemap.get(docExistrs.getString("CFEMPNUMBER")) == null ){
					 docExisStagemap.put(docExistrs.getString("CFEMPNUMBER"), doctype);
				 }else{
					 String docExtype = docExisStagemap.get(docExistrs.getString("CFEMPNUMBER"));
					 docExisStagemap.put(docExistrs.getString("CFEMPNUMBER"), docExtype+"|"+doctype);
				 }
				 
			 }
		}
		
		//获得医生的总业绩 
		HashMap<String, BigDecimal> docAllAchieveMap = getSHDocAchieveMessage(ctx, businessDate,cityID,tongyongmap,type,incityNumStr,cityNumber,
				oneItemMap,twoItemMap,threeItemMap);
		
		//医生 
		StringBuffer docSql = new StringBuffer();//  and  cfrecdotnumber in ('MS110100043','MS110100146','MS110100067' ) 
		//docSql.append("/*dialect*/ select   distinct  cfrecdotnumber from  CT_PAY_AchieveDetailtem  where  cfcitynumber = '"+cityNumber+"'   and cfrecdotnumber is  not null and   to_char(fbizdate,'YYYYMM') ='"+businessDate+"'   and exists (select 1 from CT_PAY_PayPost paypost where paypost.cfcityid ='"+cityID+"' and  paypost.cfstatus='qy'  and paypost.cfpostnumber  != 'MZYYZJ'  and paypost.cfempnumber = CT_PAY_AchieveDetailtem.cfrecdotnumber)   group by   cfrecdotnumber  ");
		docSql.append("/*dialect*/ select distinct a.cfrecdotnumber as cfrecdotnumber from ( select   distinct  paypost.cfempnumber as  cfrecdotnumber   from CT_PAY_PayPost paypost where paypost.cfcityid ='"+cityID+"' and  paypost.cfstatus='qy'   and paypost.cfpostnumber   in ('YS','JZYS','YZ') and  paypost.cfbusinessdate = '"+businessDate+"'   ");
		docSql.append("     union   SELECT   distinct  nvl(cfdocnumber,'') as cfrecdotnumber  FROM  CT_PAY_DocAchieveUpdate  where cfcityid = '"+cityID+"' and cfbusinessdate = '"+businessDate+"' and  fname_l2 is null   ");
		docSql.append("   union  SELECT  distinct  nvl(cfempnumber,'') as cfrecdotnumber     FROM  CT_PAY_DoctorCosts  where     cfcityid = '"+cityID+"' and cfbusinessdate = '"+businessDate+"' and  CFPerformanceBase is null    ");
		docSql.append("   union  SELECT  distinct  nvl(cfdoctornumber,'') as cfrecdotnumber     FROM  CT_PAY_CostSum  where    cfcitynumber "+incityNumStr+" and cfperiod = '"+businessDate+"' and  fdescription is null  ");
		docSql.append("   union  select nvl(cfdocnumber,'') as cfrecdotnumber   from   CT_PAY_DoctorRelation where  cfcityid ='"+cityID+"' and cfbusinessdate ='"+businessDate+"'    ");
		docSql.append("   union  select nvl(cfassnumber ,'') as cfrecdotnumber  from   CT_PAY_DoctorRelation where  cfcityid ='"+cityID+"' and cfbusinessdate = '"+businessDate+"'  ) a ");
  
	        	  
		IRowSet docrow = DbUtil.executeQuery(ctx, docSql.toString()); 
		//遍历eas中的数据 
		while (docrow.next()) { 
		//while (docrow.size() < 0) { 
			String docNumer = docrow.getString("CFRECDOTNUMBER"); 
			if(docNumer.equals("MS310101861") || docNumer.equals("MS310101950") || docNumer.equals("MS310101924")){
				BigDecimal docAcsshieve  = BigDecimal.ZERO;
				docAcsshieve  = BigDecimal.ZERO;
			}
			String fdocStageType = "";
			if(docExisStagemap.size() >0 && docExisStagemap.get(docNumer) != null){
				fdocStageType = docExisStagemap.get(docNumer) ;
			}
			//HashMap tongyongmap = (HashMap)doctempMap.get("TONGYONGBILI_DOC"); 
			
			BigDecimal docAchieve  = BigDecimal.ZERO;
			BigDecimal docZidaiAchieve  = BigDecimal.ZERO;
			
			//--查询这个医生的所有业绩
			if((null != doctempMap) && (null != doctempMap.get(docNumer+"_DOC"))){
				if(docAllAchieveMap.get(docNumer+"_DOC_ALL_ACHIEVE")!= null){
					docAchieve = docAllAchieveMap.get(docNumer+"_DOC_ALL_ACHIEVE");
				}
				//docAchieve = SyncEHRAchieveUtil.getSHDocAllAchieve(ctx,docNumer, businessDate,cityID,tongyongmap,type,incityNumStr);
			}
		
			
			for(int i=0; i <companyList.size();i++) { 
				String clinicNumber = companyList.get(i).get("CLINICNUMBER");
				String clinicName = companyList.get(i).get("CLINICNAME");
				String postType ="";
				
				if(existYSMap.get(docNumer+clinicNumber)!= null && existYSMap.get(docNumer+clinicNumber).equals("1")){

					String empName = "";
					if(personMap.get(docNumer) != null){
						empName  = personMap.get(docNumer);
					}else{
						PersonInfo person = PersonFactory.getLocalInstance(ctx).getPersonCollection(" where number = '"+docNumer+"' " ).get(0);
						 
						if( person != null){
							empName = person.getName();
							personMap.put(docNumer, empName);
					   }
					}
					HashMap<String,String>  djieyaMap = new HashMap<String,String>();
					HashMap<String,String>  mbMap = new HashMap<String,String>();
					
					HashMap<String,Object>  docMap = new HashMap<String,Object>();
					String insertSql = "";
					String insertValueSql = "";
					//洁牙
					String jyCount = "0";
					String plaCount = "0";    
					String imjyCount = "0";
					String implaCount = "0";    
					String xtjyCount = "0";
					String xtplaCount = "0";    
					String jieyaBonus = "0";  
					
					//美白
					String meiibaiBonus = "0"; 
					String mbAchieve = "0"; 
					String immbAchieve = "0"; 
					String xtmbAchieve = "0";  
					String docJiangjin = "0";
					String cost = "0";
					
					doctempMap.put("empName", empName);
					
					String imandxtinsertsql = "";
					String imandxtinsertValueSql = "";
					 
					//医生奖金
					//docMap = payDocFunctionService.getDocBonus(ctx,docNumer, clinicNumber, clinicName,businessDate, doctempMap,cityID,cityNumber,docAchieve,docZidaiAchieve,type,calType,fdocStageType);
					if(docAchieve.compareTo(BigDecimal.ZERO) > 0 ){
						docMap = payShangHaiDocCopyFunctionService.getDocBonus(ctx,docNumer, clinicNumber, clinicName,businessDate, doctempMap,cityID,cityNumber,docAchieve,docZidaiAchieve,type,calType,fdocStageType, docAllAchieveMap
								, oneItemMap, twoItemMap, threeItemMap);
						if(docMap != null){
							docJiangjin = docMap.get("JIANGJIN")==null ? "0":docMap.get("JIANGJIN").toString();
							cost = docMap.get("COST")==null ? "0":docMap.get("COST").toString(); 
							
							/*if(meiibaiBonus.equals("0") || meiibaiBonus.equals("0.0")){
								meiibaiBonus = docMap.get("mbMoney")==null ? "0":docMap.get("mbMoney").toString(); 
							}*/
							
							if(docMap.get("postType")!=null ){postType =  docMap.get("postType").toString(); }
							
							imandxtinsertsql =  docMap.get("imandxtinsertsql")==null ? "":docMap.get("imandxtinsertsql").toString();
							imandxtinsertValueSql = docMap.get("imandxtinsertValueSql")==null ? "":docMap.get("imandxtinsertValueSql").toString();
							
							insertSql = docMap.get("INSERTSQL")==null ? "":docMap.get("INSERTSQL").toString();
							insertValueSql = docMap.get("INSERTVALUESQL")==null ? "":docMap.get("INSERTVALUESQL").toString();
						}
					}
					
					
					flag = true;
					if(BigDecimal.ZERO.compareTo(new BigDecimal(docJiangjin)) !=0  ){
						StringBuffer sbr  = new StringBuffer(" /*dialect*/insert into CT_PAY_AchienementSum (FID,FCreatorID,FCreateTime,FLastUpdateUserID,FLastUpdateTime, ");
			    		sbr.append("cfposttype,cfbusinessdate, CFCLINICNUMBER,CFCLINICName,cfempnumber,cfempname,CFCITYNUMBER,CFCITYName,CFScalingBonus, CFWhiteBonus , CFDocBonus , CFDOCCOST , CFConBonus ,CFOtherPostBonus ,CFShopGoalBonus ) ");
			    		sbr.append("values(newbosid('4AF58046'),'"+userId+"',sysdate,'"+userId+"',sysdate, ");
			    		sbr.append(" '"+postType+"',  '"+businessDate+"','"+clinicNumber+"','"+clinicName+"' ,'"+docNumer+"','"+empName+"','"+cityNumber+"','"+cityName+"' , "+jieyaBonus+"  , "+meiibaiBonus+" ,"+docJiangjin+" , "+cost+" , 0 ,0,0  )"); 
			    		//sbr.append("'"+clinicNumber+"','' ,'"+docNumer+"','','"+cityNumber+"','' , "+jieyaBonus+" , "+meiibaiBonus+" ,"+docBonus+"   )"); 
			    		
			    		if( null == docMap.get("EXISTS") || "NO".equals(docMap.get("EXISTS").toString())){
			    			StringBuffer sbr2  = new StringBuffer(" /*dialect*/insert into CT_PAY_ClinicAchieveCosthSum (FID,FCreatorID,FCreateTime,FLastUpdateUserID,FLastUpdateTime, ");
			    			sbr2.append(" cfimjycount,cfimplacount,cfxtjycount,cfxtplacount,CFIMWhiteAchieve,CFXTWhiteAchieve, ");
				    		sbr2.append(" cfposttype , cfbusinessdate, CFCLINICNUMBER,CFCLINICName,cfempnumber,cfempname,CFCITYNUMBER,CFCITYName,CFJyCount, CFPlaCount , CFWhiteAchieve  "+insertSql+" "+imandxtinsertsql+" ) ");
				    		sbr2.append("values(newbosid('20D1E187'),'"+userId+"',sysdate,'"+userId+"',sysdate, ");
				    		sbr2.append(" "+imjyCount+","+implaCount+","+xtjyCount+","+xtplaCount+", "+immbAchieve+","+xtmbAchieve+",");
				    		sbr2.append(" '"+postType+"', '"+businessDate+"','"+clinicNumber+"','"+clinicName+"' ,'"+docNumer+"','"+empName+"','"+cityNumber+"','"+cityName+"' ,"+jyCount+" ,"+plaCount+" ,"+mbAchieve+"  "+insertValueSql+" "+imandxtinsertValueSql+")");  
				    		pe.getSqlList().add(sbr2);
			 
			    		}else{
			    			ClinicAchieveCosthSumInfo  clinicAchieveCosthSumInfo =  (ClinicAchieveCosthSumInfo) docMap.get("ClinicAchieveCosthSumInfo");
			    			clinicAchieveCosthSumInfo.setJyCount(clinicAchieveCosthSumInfo.getJyCount().add(new BigDecimal(jyCount)));
			    			clinicAchieveCosthSumInfo.setPlaCount(clinicAchieveCosthSumInfo.getPlaCount().add(new BigDecimal(plaCount)));
			    			clinicAchieveCosthSumInfo.setWhiteAchieve(clinicAchieveCosthSumInfo.getWhiteAchieve().add(new BigDecimal(mbAchieve)));  
			    			ClinicAchieveCosthSumFactory.getLocalInstance(ctx).save(clinicAchieveCosthSumInfo);
			    		}
			    		pe.getSqlList().add(sbr);
					}
				} 
			}
		} 
		if(flag){
			Calendar caldele = Calendar.getInstance();
			caldele.setTime(new Date());
			caldele.add(Calendar.MONTH, -3);
	        Date dateDele = caldele.getTime();
	        SimpleDateFormat formatdelete= new SimpleDateFormat("yyyyMM");
	        String deleDate = formatdelete.format(dateDele);
			//StringBuffer sbr  = new StringBuffer(" /*dialect*/  delete CT_PAY_AchieveDetailtem where   fbizdate =  to_date('"+deleDate+"','YYYYMM') "); 
    		//pe.getSqlList().add(sbr);
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
		pool = Executors.newFixedThreadPool(6);
		pe = new ParallelSqlExecutor(pool); 
		flag = false;
		
		
		
		//获得客服相关的数据信息
		HashMap<String,BigDecimal>  kfImpMap = new HashMap<String,BigDecimal>(); 
		
		//周边比例 
		BigDecimal zbPro = BigDecimal.ZERO;    
		zbPro = new BigDecimal(kefuMap.get("KEFU_ZHOUBIANPRO").toString());    
		 
		String importKF = " /*dialect*/ SELECT cfempnumber,cfclinicnumber,nvl(sum(cfzpachieve),0) as kf FROM  CT_PAY_ConsultantBonusUpdate   where   cfcityid = '"+cityID+"' and cfbusinessdate = '"+businessDate+"' group by cfempnumber,cfclinicnumber  ";
		IRowSet rsKFImpMb =  DBUtil.executeQuery(ctx,importKF);
		if(rsKFImpMb!=null && rsKFImpMb.size() > 0){
			  while(rsKFImpMb.next()){
				  BigDecimal zbachieve = new BigDecimal(rsKFImpMb.getString("KF"));  
				  String clincnumber = rsKFImpMb.getString("CFCLINICNUMBER");
				  String empnumber = rsKFImpMb.getString("CFEMPNUMBER");
				  kfImpMap.put(empnumber+"_"+clincnumber+"imkfAchieve", zbachieve);
			  }
		}
		
		//赠金比例
		gifAmountPro = BigDecimal.ZERO; 
		tongyongmap = (HashMap)tempMap.get("TONGYONGBILI_DOC");
		gifAmountPro =  new BigDecimal(tongyongmap.get("CFGIFAMOUNTPRO").toString());
		
		HashMap<String,BigDecimal>  kfXTMap = new HashMap<String,BigDecimal>(); 
		String sqlKFXTStr = "  /*dialect*/ select  cfclinicnumber, cfrecpersonnumber , nvl(sum(cfpayment),0)-(nvl(sum(cfgiftpayment),0)*"+gifAmountPro+") as KFACHIEVE   FROM  CT_PAY_AchieveDetailTem tem "+
		"  where   cfcitynumber "+incityNumStr+" and  to_char(fbizdate,'YYYYMM') ='"+businessDate+"'  and  cfsecclassnumber  ='75' group by cfclinicnumber, cfrecpersonnumber    ";
		
		IRowSet rsKFXTmb =  DBUtil.executeQuery(ctx,sqlKFXTStr);
		if(rsKFXTmb!=null && rsKFXTmb.size() > 0){
			  while(rsKFXTmb.next()){	
				  BigDecimal achieve= new BigDecimal(rsKFXTmb.getString("KFACHIEVE")).setScale(2,BigDecimal.ROUND_HALF_UP);
				  String clincnumber = rsKFXTmb.getString("CFCLINICNUMBER");
				  String empnumber = rsKFXTmb.getString("CFRECPERSONNUMBER"); 
				  kfXTMap.put(empnumber+"_"+clincnumber+"xtkfAchieve", achieve); 
			  }
		}
		  
		//客服
		String kfSql = " /*dialect*/   SELECT  distinct a.cfrecdotnumber ,a.clinicnumber from  ( select   distinct  paypost.cfempnumber as  cfrecdotnumber , tem.cfclinicnumber as clinicnumber   from CT_PAY_PayPost paypost  inner join CT_PAY_AchieveDetailTem tem on tem.cfrecpersonnumber  = paypost.cfempnumber and  to_char(fbizdate,'YYYYMM') = '"+businessDate+"'  and cfcitynumber = '"+cityNumber+"' "
			+" where paypost.cfpostnumber = 'KF'  and  paypost.cfcityid ='"+cityID+"' and  paypost.cfstatus='qy'   and  paypost.cfbusinessdate = '"+businessDate+"' "+
			" union select cfempnumber as cfrecdotnumber , cfclinicnumber as clinicnumber  from  CT_PAY_ConsultantBonusUpdate  where  cfcityid ='"+cityID+"'  and cfbusinessdate = '"+businessDate+"' and cfzpachieve >0 ) a ";
		 
		IRowSet kfrow = DbUtil.executeQuery(ctx, kfSql); 
		//遍历eas中的数据 
		while (kfrow.next()) { 
			String postType = "KF";
			String clinicNumber =  kfrow.getString("CLINICNUMBER"); 
			String kfNumer = kfrow.getString("CFRECDOTNUMBER"); 
			
			HashMap<String, String> cliniMap = companyMap.get(clinicNumber); 
			String clinicName = ""; 
			if(cliniMap != null){
				clinicName = cliniMap.get("CLINICNAME"); 
			}else{
				CompanyOrgUnitInfo orgUnit = CompanyOrgUnitFactory.getLocalInstance(ctx).getCompanyOrgUnitCollection(" where number = '"+clinicNumber+"' " ).get(0);
				clinicName = orgUnit.getName();
				
				HashMap<String, String> map= new HashMap<String, String>();
				map.put("CLINICNUMBER", clinicNumber);
				map.put("CLINICNAME", clinicName);
				map.put("CLINICID", orgUnit.getId().toString()); 
				companyMap.put(clinicNumber,map);

			} 
			String empName = "";
			if(personMap.get(kfNumer) != null){
				empName  = personMap.get(kfNumer);
			}else{
				PersonInfo person = PersonFactory.getLocalInstance(ctx).getPersonCollection(" where number = '"+kfNumer+"' " ).get(0);
				 
				if( person != null){
					empName = person.getName();
					personMap.put(kfNumer, empName);
			   }
			}
			HashMap<String,String>  kfMap = new HashMap<String,String>(); 
			//客服奖金
			//kfMap = payFunctionService.getSHKeFuBonus(ctx,kfNumer, clinicNumber,cityNumber,businessDate,cityID, kefuMap);
			
			//kfImpMap.get(kfNumer+"_"+clinicNumber+"imkfAchieve");
			//kfXTMap.get(kfNumer+"_"+clinicNumber+"xtkfAchieve"); 
			
			postType = "KF";
			
			BigDecimal imkfAchieve = kfImpMap.get(kfNumer+"_"+clinicNumber+"imkfAchieve")==null? BigDecimal.ZERO:kfImpMap.get(kfNumer+"_"+clinicNumber+"imkfAchieve");
			BigDecimal xtkfAchieve =  kfXTMap.get(kfNumer+"_"+clinicNumber+"xtkfAchieve")==null? BigDecimal.ZERO:kfXTMap.get(kfNumer+"_"+clinicNumber+"xtkfAchieve");
			
			
			BigDecimal kfAchieve = imkfAchieve.add(xtkfAchieve);
			BigDecimal kfBonus = kfAchieve.multiply(zbPro);

			if(BigDecimal.ZERO.compareTo(kfBonus) !=0  || BigDecimal.ZERO.compareTo(kfAchieve) !=0  ){
				if(AchienementSumFactory.getLocalInstance(ctx).exists(" where  empnumber='"+kfNumer+"' and  clinicnumber ='"+clinicNumber+"' and  businessdate='"+businessDate+"'  ")){
					AchienementSumInfo info = AchienementSumFactory.getLocalInstance(ctx).getAchienementSumInfo(" where  empnumber='"+kfNumer+"' and  clinicnumber ='"+clinicNumber+"'  and  businessdate='"+businessDate+"'  ");
					info.setKfBonus(kfBonus);
					ClinicAchieveCosthSumInfo achieveinfo = ClinicAchieveCosthSumFactory.getLocalInstance(ctx).getClinicAchieveCosthSumInfo(" where  empnumber='"+kfNumer+"' and  clinicnumber ='"+clinicNumber+"'   and  businessdate='"+businessDate+"'  ");
					achieveinfo.setAllKeAchieve(kfAchieve);
					achieveinfo.setImAllKeAchieve(imkfAchieve);
					achieveinfo.setXtAllKeAchieve(xtkfAchieve);
					AchienementSumFactory.getLocalInstance(ctx).save(info);
					ClinicAchieveCosthSumFactory.getLocalInstance(ctx).save(achieveinfo);
				}else{
					flag = true;
					StringBuffer sbr  = new StringBuffer(" /*dialect*/ insert into CT_PAY_AchienementSum (FID,FCreatorID,FCreateTime,FLastUpdateUserID,FLastUpdateTime, ");
		    		sbr.append(" cfposttype,cfbusinessdate, CFCLINICNUMBER,CFCLINICName,cfempnumber,cfempname,CFCITYNUMBER,CFCITYName,CFScalingBonus, CFWhiteBonus , CFDocBonus , CFConBonus ,CFOtherPostBonus ,CFShopGoalBonus,CFKFBONUS ) ");
		    		sbr.append("values(newbosid('4AF58046'),'"+userId+"',sysdate,'"+userId+"',sysdate, ");
		    		//sbr.append("'"+clinicNumber+"','"+clinicName+"' ,'"+docNumer+"','"+docName+"','"+cityNumber+"','"+cityName+"' , 0 ,0,0,"+zixunBonus+","+otherBonus+" ,"+shopGoalBonus+"  ) "); 
		    		//sbr.append(" '"+businessDate+"','"+clinicNumber+"','"+clinicName+"' ,'"+docNumer+"','','"+cityNumber+"','"+cityName+"' , 0 ,0,0,"+zixunBonus+","+otherBonus+" ,"+shopGoalBonus+"  ) ");
		    		sbr.append("  '"+postType+"', '"+businessDate+"','"+clinicNumber+"','"+clinicName+"' ,'"+kfNumer+"','"+empName+"','"+cityNumber+"','"+cityName+"' , 0 ,0,0,0, 0 ,0 ,"+kfBonus+" ) ");
		    		pe.getSqlList().add(sbr);
		    		
		    		StringBuffer sbr2  = new StringBuffer(" /*dialect*/insert into CT_PAY_ClinicAchieveCosthSum (FID,FCreatorID,FCreateTime,FLastUpdateUserID,FLastUpdateTime, ");
		    		sbr2.append(" cfposttype , cfbusinessdate, CFCLINICNUMBER,CFCLINICName,cfempnumber,cfempname,CFCITYNUMBER,CFCITYName, CFALLKEAchieve,CFimallkeAchieve,CFxtallkeAchieve ) ");
		    		sbr2.append("values(newbosid('20D1E187'),'"+userId+"',sysdate,'"+userId+"',sysdate, ");
		    		sbr2.append("'"+postType+"','"+businessDate+"','"+clinicNumber+"','"+clinicName+"' ,'"+kfNumer+"','"+empName+"','"+cityNumber+"','"+cityName+"' ,"+kfAchieve+" ,"+imkfAchieve+","+xtkfAchieve+")");  
		    		 
		    		pe.getSqlList().add(sbr2);
				}
				
			}
		}
		
		if(flag){
			 
			Calendar caldele = Calendar.getInstance();
			caldele.setTime(new Date());
			caldele.add(Calendar.MONTH, -3);
	        Date dateDele = caldele.getTime();
	        SimpleDateFormat formatdelete= new SimpleDateFormat("yyyyMM");
	        String deleDate = formatdelete.format(dateDele);
			//StringBuffer sbr  = new StringBuffer(" /*dialect*/  delete CT_PAY_AchieveDetailtem where   fbizdate =  to_date('"+deleDate+"','YYYYMM') "); 
    		//pe.getSqlList().add(sbr);
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
		
		//计算大众点评扣款
		//先删除对应月份的数据
		CoreBaseCollection subCollection = new CoreBaseCollection();
		ClinicComSubFactory.getLocalInstance(ctx).delete(" where city = '"+cityID+"' and businessdate = '"+businessDate+"' ");
		
		String subSql = " /*dialect*/  select paypost.cfpostnumber  as postNumber, paypost.cfempnumber as  dotnumber  , budgeDate.cfcompanyid  AS  COMPANYID, case when  budgeDate.cfclinicshop = 'dd' then nvl(clinicUp.cfbigshopprice,0)/2*nvl(message.cfbadnum,0) when budgeDate.cfclinicshop = 'xd' then  nvl(clinicUp.cfsmallshopamount,0)/2*nvl(message.cfbadnum,0)   else 0 end  as SUBAMOUNT, " +
		"  nvl(message.cfbadnum,0) as BADNUM from CT_PAY_PayPost paypost inner join  T_ORG_BaseUnit baseunit on baseunit.fid =  paypost.cfclinicid  left join CT_PAY_BudgetDate  budgeDate on budgeDate.cfcompanyid = paypost.cfclinicid and  budgeDate.cfbusinessdate =  paypost.cfbusinessdate  left join CT_PAY_ClinicUpScale  clinicUp on clinicUp.cfcityid = paypost.cfcityid and  clinicUp.cfbusinessdate =  paypost.cfbusinessdate  " +
		" left join CT_PAY_DepartMonthMsg message  on message.cfcityid = paypost.cfcityid and  message.cfmznumber = baseunit.fnumber and paypost.cfbusinessdate = message.cfbusinessdate " +
		" where paypost.cfcityid  ='"+cityID+"'  and  paypost.cfstatus='qy'   and paypost.cfpostnumber   in ('MZYYZJ','YZ') and  paypost.cfbusinessdate = '"+businessDate+"'  and  message.cfbadnum  >0   " +
		" union  select paypost.cfpostnumber  as postNumber, paypost.cfempnumber as  dotnumber  , budgeDate.cfcompanyid  AS  COMPANYID, case when  budgeDate.cfclinicshop = 'dd' then nvl(clinicUp.cfbigshopprice,0)/2*nvl(message.cfbadnum,0) when budgeDate.cfclinicshop = 'xd' then  nvl(clinicUp.cfsmallshopamount,0)/2*nvl(message.cfbadnum,0)   else 0 end  as SUBAMOUNT, " +
		"  nvl(message.cfbadnum,0) as BADNUM from CT_PAY_PayPost paypost inner join  T_ORG_BaseUnit baseunit on baseunit.fid =  paypost.cfclinicid  left join CT_PAY_BudgetDate  budgeDate on budgeDate.cfcompanyid = paypost.cfclinicid and  budgeDate.cfbusinessdate =  paypost.cfbusinessdate  left join CT_PAY_ClinicUpScale  clinicUp on clinicUp.cfcityid = paypost.cfcityid and  clinicUp.cfbusinessdate =  paypost.cfbusinessdate  " +
		" left join CT_PAY_DepartMonthMsg message  on message.cfcityid = paypost.cfcityid and  message.cfmznumber = baseunit.fnumber and paypost.cfbusinessdate = message.cfbusinessdate " +
		" where paypost.cfcityid  ='"+cityID+"'  and  paypost.cfstatus='qy'   and paypost.cfpostnumber ='FMZYYZJ'  and  paypost.cfbusinessdate = '"+businessDate+"'  and  message.cfbadnum  >0  and not exists ( select 1 from  CT_PAY_PayPost post2  where post2.cfstatus='qy'   and post2.cfpostnumber   = 'MZYYZJ'  and   post2.cfcityid  ='"+cityID+"' and  post2.cfbusinessdate = '"+businessDate+"' and  post2.cfclinicid = paypost.cfclinicid ) ";
		IRowSet subrow = DbUtil.executeQuery(ctx, subSql); 
		//遍历eas中的数据 
		CtrlUnitInfo ctrlUnitInfo = new CtrlUnitInfo();
		ctrlUnitInfo.setId(BOSUuid.read(cityID));
		while (subrow.next()) { 
			String companyid = subrow.getString("COMPANYID");
			String docNumber = subrow.getString("DOTNUMBER");
			 
			String empName = "";
			if(personMap.get(docNumber) != null){
				empName  = personMap.get(docNumber);
			}else{
				PersonInfo person = PersonFactory.getLocalInstance(ctx).getPersonCollection(" where number = '"+docNumber+"' " ).get(0);
				 
				if( person != null){
					empName = person.getName();
					personMap.put(docNumber, empName);
			   }
			}
			
			ClinicComSubInfo info = new  ClinicComSubInfo(); 
			if(ClinicComSubFactory.getLocalInstance(ctx).exists(" where clinic='"+companyid+"'  and empnumber='"+docNumber+"'  and businessdate='"+businessDate+"'  ")){
				info = ClinicComSubFactory.getLocalInstance(ctx).getClinicComSubInfo(" where clinic='"+companyid+"'  and empnumber='"+docNumber+"' and businessdate='"+businessDate+"' ");
				BigDecimal badNum = info.getBadNum()==null ?  BigDecimal.ZERO:info.getBadNum();
				info.setBadNum(subrow.getBigDecimal("BADNUM"));
				
				BigDecimal subAmount = info.getSubAmount()==null ?  BigDecimal.ZERO:info.getSubAmount();
				info.setSubAmount(subrow.getBigDecimal("SUBAMOUNT"));
			}else{
				info.setCity(ctrlUnitInfo);
				CompanyOrgUnitInfo companyInfo = new CompanyOrgUnitInfo();
				companyInfo.setId(BOSUuid.read(companyid));
				info.setClinic(companyInfo); 
				companyInfo = CompanyOrgUnitFactory.getLocalInstance(ctx).getCompanyOrgUnitInfo(" where id = '"+companyid+"' ");
				info.setClinicName(companyInfo.getName());
				info.setClinicNumber(companyInfo.getNumber());
				info.setBadNum(subrow.getBigDecimal("BADNUM"));
				info.setSubAmount(subrow.getBigDecimal("SUBAMOUNT"));
				info.setBusinessdate(businessDate);
				info.setEmpName(empName);
				info.setEmpNumber(docNumber);
				info.setPostNumber(PaypostType.getEnum(subrow.getString("POSTNUMBER")));
			} 
			subCollection.add(info);
		}	 
		ClinicComSubFactory.getLocalInstance(ctx).save(subCollection) ;
		
		
		
		CoreBaseCollection baseCollection = new CoreBaseCollection();
		//医助 转给医生奖金
		//String assToDocSql = " SELECT  CFDOCNUMBER,CFDOCNAME,CFASSNUMBER,CFBILI FROM  CT_PAY_DoctorRelation where  cfcityid='"+cityID+"' and cfbusinessdate = '"+businessDate+"' and cfasstype = 'ys'  ";
		String assToDocSql = " SELECT  CFDOCNUMBER,CFDOCNAME,CFASSNUMBER,CFBILI FROM  CT_PAY_DoctorRelation where  cfcityid='"+cityID+"' and cfbusinessdate = '"+businessDate+"' and cfasstype = 'qt'  ";
		IRowSet assToDocrow = DbUtil.executeQuery(ctx, assToDocSql); 
		//遍历eas中的数据 
		while(assToDocrow.next()){ 
			String docNumber = assToDocrow.getString("CFDOCNUMBER");
			String docName = assToDocrow.getString("CFDOCNAME");
			String assNumber = assToDocrow.getString("CFASSNUMBER");
			BigDecimal bili = assToDocrow.getBigDecimal("CFBILI");
			if(AchienementSumFactory.getLocalInstance(ctx).exists(" where citynumber='"+cityNumber+"' and businessdate = '"+businessDate+"'  and empnumber='"+assNumber+"' ")){
				AchienementSumCollection collection = AchienementSumFactory.getLocalInstance(ctx).getAchienementSumCollection(" where citynumber='"+cityNumber+"' and businessdate = '"+businessDate+"'  and empnumber='"+assNumber+"' ");
				for(int i=0;i<collection.size();i++){
					AchienementSumInfo info  = collection.get(i);
					BigDecimal assBouns = info.getDocBonus()==null ?BigDecimal.ZERO:info.getDocBonus();
					String clinicNumber = info.getClinicNumber();
					if(assBouns.compareTo(BigDecimal.ZERO) > 0 ){
						BigDecimal assToDocBouns = info.getAssToDocBouns()==null ?BigDecimal.ZERO:info.getAssToDocBouns();
						info.setAssToDocBouns(assToDocBouns.add(assBouns.multiply(bili)).negate());
						baseCollection.add(info);
						AchienementSumInfo docinfo  = new AchienementSumInfo();
						if(AchienementSumFactory.getLocalInstance(ctx).exists(" where  clinicnumber = '"+clinicNumber+"' and citynumber='"+cityNumber+"' and businessdate = '"+businessDate+"'  and empnumber='"+docNumber+"' ")){
							docinfo = AchienementSumFactory.getLocalInstance(ctx).getAchienementSumCollection(" where  clinicnumber = '"+clinicNumber+"' and citynumber='"+cityNumber+"' and businessdate = '"+businessDate+"'  and empnumber='"+docNumber+"' ").get(0);
							BigDecimal docassToDocBouns = docinfo.getAssToDocBouns()==null ?BigDecimal.ZERO:docinfo.getAssToDocBouns();
							docinfo.setAssToDocBouns(docassToDocBouns.add(assBouns.multiply(bili)));
							baseCollection.add(docinfo);
						}else{
							docinfo =  (AchienementSumInfo) info.clone();
							docinfo.setId(null);
							docinfo.setEmpName(docName);
							docinfo.setEmpNumber(docNumber);
							docinfo.setAssToDocBouns( assBouns.multiply(bili));
							docinfo.setDocCost(BigDecimal.ZERO);
							docinfo.setDocBonus(BigDecimal.ZERO);
							
							baseCollection.add(docinfo);
						}
					}
				}
			}
		}
		AchienementSumFactory.getLocalInstance(ctx).save(baseCollection);
		
		
	  
		ExecutorService pool3 = Executors.newFixedThreadPool(1);
	    ParallelSqlExecutor pe3 = new ParallelSqlExecutor(pool3);   
	    pe3.getSqlList().add(" update  CT_PAY_ClinicAchieveCosthSum set cfpostname = '客服' where cfbusinessdate = '"+businessDate+"' and cfcitynumber = '"+cityNumber+"' and cfposttype = 'KF' ");
	    pe3.getSqlList().add(" update  CT_PAY_ClinicAchieveCosthSum set cfpostname = '护士' where cfbusinessdate = '"+businessDate+"' and cfcitynumber = '"+cityNumber+"' and cfposttype = 'HS' ");
	    pe3.getSqlList().add(" update  CT_PAY_ClinicAchieveCosthSum set cfpostname = '洁牙师' where cfbusinessdate = '"+businessDate+"' and cfcitynumber = '"+cityNumber+"' and cfposttype = 'JYS' ");
	    pe3.getSqlList().add(" update  CT_PAY_ClinicAchieveCosthSum set cfpostname = '咨询师' where cfbusinessdate = '"+businessDate+"' and cfcitynumber = '"+cityNumber+"' and cfposttype = 'ZXS' ");
	    pe3.getSqlList().add(" update  CT_PAY_ClinicAchieveCosthSum set cfpostname = '医生' where cfbusinessdate = '"+businessDate+"' and cfcitynumber = '"+cityNumber+"' and cfposttype = 'YS' ");
	    pe3.getSqlList().add(" update  CT_PAY_ClinicAchieveCosthSum set cfpostname = '院长' where cfbusinessdate = '"+businessDate+"' and cfcitynumber = '"+cityNumber+"' and cfposttype = 'YZ' "); 
    	pe3.getSqlList().add(" update  CT_PAY_ClinicAchieveCosthSum set cfpostname = '门诊运营总监' where cfbusinessdate = '"+businessDate+"' and cfcitynumber = '"+cityNumber+"' and cfposttype = 'MZYYZJ' "); 
    	pe3.getSqlList().add(" update  CT_PAY_ClinicAchieveCosthSum set cfpostname = '兼职医生' where cfbusinessdate = '"+businessDate+"' and cfcitynumber = '"+cityNumber+"' and cfposttype = 'JZYS' "); 
    	pe3.getSqlList().add(" update  CT_PAY_ClinicAchieveCosthSum set cfpostname = '特殊兼职医生' where cfbusinessdate = '"+businessDate+"' and cfcitynumber = '"+cityNumber+"' and cfposttype = 'TSJZYS' ");
    	pe3.getSqlList().add(" update  CT_PAY_ClinicAchieveCosthSum set cfpostname = '城市运营总监' where cfbusinessdate = '"+businessDate+"' and cfcitynumber = '"+cityNumber+"' and cfposttype = 'CSYYZJ' ");
    	
    	
    	pe3.getSqlList().add(" update  CT_PAY_AchienementSum set cfpostname = '客服' where cfbusinessdate = '"+businessDate+"' and cfcitynumber = '"+cityNumber+"' and cfposttype = 'KF' ");
 	    pe3.getSqlList().add(" update  CT_PAY_AchienementSum set cfpostname = '护士' where cfbusinessdate = '"+businessDate+"' and cfcitynumber = '"+cityNumber+"' and cfposttype = 'HS' ");
 	    pe3.getSqlList().add(" update  CT_PAY_AchienementSum set cfpostname = '洁牙师' where cfbusinessdate = '"+businessDate+"' and cfcitynumber = '"+cityNumber+"' and cfposttype = 'JYS' ");
 	    pe3.getSqlList().add(" update  CT_PAY_AchienementSum set cfpostname = '咨询师' where cfbusinessdate = '"+businessDate+"' and cfcitynumber = '"+cityNumber+"' and cfposttype = 'ZXS' ");
 	    pe3.getSqlList().add(" update  CT_PAY_AchienementSum set cfpostname = '医生' where cfbusinessdate = '"+businessDate+"' and cfcitynumber = '"+cityNumber+"' and cfposttype = 'YS' ");
 	    pe3.getSqlList().add(" update  CT_PAY_AchienementSum set cfpostname = '院长' where cfbusinessdate = '"+businessDate+"' and cfcitynumber = '"+cityNumber+"' and cfposttype = 'YZ' "); 
     	pe3.getSqlList().add(" update  CT_PAY_AchienementSum set cfpostname = '门诊运营总监' where cfbusinessdate = '"+businessDate+"' and cfcitynumber = '"+cityNumber+"' and cfposttype = 'MZYYZJ' "); 
     	pe3.getSqlList().add(" update  CT_PAY_AchienementSum set cfpostname = '兼职医生' where cfbusinessdate = '"+businessDate+"' and cfcitynumber = '"+cityNumber+"' and cfposttype = 'JZYS' "); 
     	pe3.getSqlList().add(" update  CT_PAY_AchienementSum set cfpostname = '特殊兼职医生' where cfbusinessdate = '"+businessDate+"' and cfcitynumber = '"+cityNumber+"' and cfposttype = 'TSJZYS' ");
     	pe3.getSqlList().add(" update  CT_PAY_AchienementSum set cfpostname = '城市运营总监' where cfbusinessdate = '"+businessDate+"' and cfcitynumber = '"+cityNumber+"' and cfposttype = 'CSYYZJ' ");
     	 
    	
     	pe3.getSqlList().add(" update  CT_PAY_ScalingCountSum set cfpostname = '客服' where cfbusinessdate = '"+businessDate+"' and cfcitynumber = '"+cityNumber+"' and cfpost = 'KF' ");
 	    pe3.getSqlList().add(" update  CT_PAY_ScalingCountSum set cfpostname = '护士' where cfbusinessdate = '"+businessDate+"' and cfcitynumber = '"+cityNumber+"' and cfpost = 'HS' ");
 	    pe3.getSqlList().add(" update  CT_PAY_ScalingCountSum set cfpostname = '洁牙师' where cfbusinessdate = '"+businessDate+"' and cfcitynumber = '"+cityNumber+"' and cfpost = 'JYS' ");
 	    pe3.getSqlList().add(" update  CT_PAY_ScalingCountSum set cfpostname = '咨询师' where cfbusinessdate = '"+businessDate+"' and cfcitynumber = '"+cityNumber+"' and cfpost = 'ZXS' ");
 	    pe3.getSqlList().add(" update  CT_PAY_ScalingCountSum set cfpostname = '医生' where cfbusinessdate = '"+businessDate+"' and cfcitynumber = '"+cityNumber+"' and cfpost = 'YS' ");
 	    pe3.getSqlList().add(" update  CT_PAY_ScalingCountSum set cfpostname = '院长' where cfbusinessdate = '"+businessDate+"' and cfcitynumber = '"+cityNumber+"' and cfpost = 'YZ' "); 
     	pe3.getSqlList().add(" update  CT_PAY_ScalingCountSum set cfpostname = '门诊运营总监' where cfbusinessdate = '"+businessDate+"' and cfcitynumber = '"+cityNumber+"' and cfpost = 'MZYYZJ' "); 
     	pe3.getSqlList().add(" update  CT_PAY_ScalingCountSum set cfpostname = '兼职医生' where cfbusinessdate = '"+businessDate+"' and cfcitynumber = '"+cityNumber+"' and cfpost = 'JZYS' "); 
     	pe3.getSqlList().add(" update  CT_PAY_ScalingCountSum set cfpostname = '特殊兼职医生' where cfbusinessdate = '"+businessDate+"' and cfcitynumber = '"+cityNumber+"' and cfpost = 'TSJZYS' ");
     	pe3.getSqlList().add(" update  CT_PAY_ScalingCountSum set cfpostname = '城市运营总监' where cfbusinessdate = '"+businessDate+"' and cfcitynumber = '"+cityNumber+"' and cfpost = 'CSYYZJ' ");
    	/*pe3.getSqlList().add(" update  CT_PAY_PayPost set fsimplename = '1' where cfcityid = '"+cityID+"'  and  cfbusinessdate = '"+businessDate+"' ");
    	pe3.getSqlList().add(" update  CT_PAY_ScalingBonusUpdate set fsimplename = '1' where cfcityid = '"+cityID+"'  and  cfbusinessdate = '"+businessDate+"'  ");
    	pe3.getSqlList().add(" update  CT_PAY_WhiteBonusUpdate set fsimplename = '1' where cfcityid = '"+cityID+"'  and  cfbusinessdate = '"+businessDate+"'  ");
    	pe3.getSqlList().add(" update  CT_PAY_DocAchieveUpdate set fsimplename = '1' where cfcityid = '"+cityID+"'  and  cfbusinessdate = '"+businessDate+"'  ");
    	pe3.getSqlList().add(" update  CT_PAY_DoctorCosts set CFPerformanceBase = '1' where     cfcityid = '"+cityID+"' and cfbusinessdate = '"+businessDate+"'   "); 
    	pe3.getSqlList().add(" update  CT_PAY_CostSum set fdescription = '1' where      cfcitynumber "+incityNumStr+" and cfperiod = '"+businessDate+"'   ");*/


    	try {
			pe3.executeUpdate(ctx);
			pool3.shutdown(); 
		} catch (EASBizException e) { 
			e.printStackTrace();
			pool3.shutdown(); 
		} catch (BOSException e) { 
			e.printStackTrace();
			pool3.shutdown(); 
		}
		pool3.shutdown();  
	}
 
	
	
	
	

	
	/**
	 *  上海薪酬计算方式
	 * @param ctx
	 * @param businessDate
	 * @param userId
	 * @param cityID
	 * @param cityNumber
	 * @param cityName
	 * @param flag
	 * @throws Exception
	 * @throws BOSException
	 * @throws SQLException
	 */
	public void doNingBo(Context ctx, String businessDate,String userId,String cityID,String cityNumber,String cityName,boolean flag) throws Exception, BOSException, SQLException{
		
  
		ExecutorService pool = Executors.newFixedThreadPool(6);
	    ParallelSqlExecutor pe = new ParallelSqlExecutor(pool); 
	    HashMap<Object, Object> tempMap = new HashMap<Object, Object>();
        HashMap<Object, Object> doctempMap = new HashMap<Object, Object>();
       
        HashMap<Object, Object> zixunMap = new HashMap<Object, Object>();
        //HashMap<Object, Object> dianZhangMap = new HashMap<Object, Object>();
        HashMap<Object, Object> shopMDGoalMap = new HashMap<Object, Object>();
        HashMap<Object, Object> kefuMap = new HashMap<Object, Object>();
         
        
        Map<String, String> mapAll = new HashMap<String, String>();
		PayFunctionService payFunctionService = new PayFunctionService();  
		PayShangHaiDocFunctionService payDocFunctionService= new PayShangHaiDocFunctionService();
		PayNingBoDocCopyFunctionService payNingBoDocCopyFunctionService= new PayNingBoDocCopyFunctionService();
		
		String includeCitySql ="/*dialect*/ SELECT bill.cfrule as RULE,billorg.fid as bcityid ,billorg.fnumber as bcitynumber , entryorg.fid as ecityid ,entryorg.fnumber  as ecitynumber  from  CT_PAY_PayCity  bill left join CT_PAY_PayCityEntry entry on bill.fid = entry.fparentid  left join   T_ORG_BaseUnit billorg on billorg.fid = bill.cfcityid "+
  		" left join   T_ORG_BaseUnit entryorg on entryorg.fid = entry.cfincludecityid where billorg.fnumber = '"+cityNumber+"' ";
		IRowSet includecityrow = DbUtil.executeQuery(ctx, includeCitySql);
	 
		
		String type = "";
		String incityidStr = " in (";
		String incityNumStr = " in (";
		while(includecityrow.next()){
			type = includecityrow.getString("RULE");
			
  			String ecityid =  includecityrow.getString("ECITYID"); 
  			String ecityNumber = includecityrow.getString("ECITYNUMBER");   
  			incityidStr = incityidStr + "'"+ecityid+"',"; 
  			incityNumStr = incityNumStr + "'"+ecityNumber+"',"; 
		} 
		incityidStr = incityidStr.substring(0,incityidStr.length()-1) + " )";
		incityNumStr = incityNumStr.substring(0,incityNumStr.length()-1) + " )";
		 
		
		String companyIdSql =  " select base.fid as clinicid ,base.fnumber as clinicnumber,base.fname_l2 as  clinicname  from  CT_PAY_BudgetDate budge  " +
			" inner join T_ORG_BaseUnit base  on base.fid =  budge.cfcompanyid " +
			" where     budge.cfbusinessdate = '"+businessDate+"' and  base.FPARENTID   "+incityidStr+"   ";
		
		IRowSet comrow = DbUtil.executeQuery(ctx, companyIdSql.toString()); 
		
		ArrayList<HashMap<String, String>> companyList = new ArrayList<HashMap<String, String>>(); 
	    
	    HashMap<String ,HashMap<String, String>> companyMap = new HashMap<String ,HashMap<String, String>>();
	    while(comrow.next()){
	    	String clinicid = comrow.getString("CLINICID");
	    	String clinicNumber = comrow.getString("CLINICNUMBER");
			String clinicName = comrow.getString("CLINICNAME");
			HashMap<String, String> map= new HashMap<String, String>();
			map.put("CLINICNUMBER", clinicNumber);
			map.put("CLINICNAME", clinicName);
			map.put("CLINICID", clinicid);
			companyList.add(map);
			companyMap.put(clinicNumber,map);
	    }
	    
	    HashMap<String, String> personMap = new  HashMap<String, String>(); 
	    String  personSql = " select fname_l2 as name , fnumber  from t_bd_person where FCONTROLUNITID "+incityidStr+" ";
	    IRowSet personrow = DbUtil.executeQuery(ctx, personSql); 
	    while(personrow.next()){
	    	String name = personrow.getString("NAME");
	    	String number = personrow.getString("FNUMBER"); 
	    	personMap.put(number,name);
	    }
	      
	    String dateSql = "";
		if(type.equals("ZC")){
			dateSql = "  to_char(tem.fbizdate, 'yyyymm') = '"+businessDate+"' and  ";
		}else if(type.equals("CBQR")){
			dateSql = "  tem.CFBUSINESSDATE = '"+businessDate+"' and  (tem.cfisneedout = 0 or ( tem.cfisneedout=1 and tem.cfisout = 1))  and  ";
		} 
			
		//查询医生所对应的门诊业绩是否存在
	    HashMap<String, String>  existYSMap = new HashMap<String, String>(); 
 
	    String existYSSql = " /*dialect*/ select   distinct  nvl(a.clinicnumber,'') as clinicnumber , nvl(a.cfrecdotnumber,'') as cfdocnumber    FROM ( SELECT   distinct  paypost.cfempnumber as  cfrecdotnumber ,nvl(tem.cfclinicnumber,'') as clinicnumber  from CT_PAY_PayPost paypost  "+
		"  inner join  CT_PAY_AchieveDetailTem tem on tem.CFRECDOTNUMBER  = paypost.cfempnumber and  "+dateSql+" tem.cfcitynumber "+incityNumStr+"   "+
		"  where   paypost.cfcityid ='"+cityID+"'  and  paypost.cfstatus='qy'   and paypost.cfpostnumber   in ('YS','JZYS','YZ') and  paypost.cfbusinessdate = '"+businessDate+"' and cfrecdotnumber is not null   "+
		"  union   SELECT   distinct  nvl(cfdocnumber,'') as cfdocnumber  ,nvl(cfclinicnumber,'') as clinicnumber  FROM  CT_PAY_DocAchieveUpdate  where cfcityid = '"+cityID+"' and cfbusinessdate = '"+businessDate+"' and  fname_l2 is null    ) a ";
	    
	    
	    IRowSet existYSrow = DbUtil.executeQuery(ctx, existYSSql.toString()); 
		//遍历eas中的数据 
		while (existYSrow.next()) { 
			String ysNumer = existYSrow.getString("CFDOCNUMBER"); 
			String clinicNumber = existYSrow.getString("CLINICNUMBER"); 
			existYSMap.put(ysNumer+clinicNumber,"1");
		}
		 
		//查询咨询相关所对应的门诊业绩是否存在 
	    HashMap<String, String>  existZXMap = new HashMap<String, String>(); 
	    String existZXSql = "/*dialect*/  select distinct  paypost.cfempnumber AS EMPNUMBER ,baseunit.fnumber AS CLINICNUMBER from  CT_PAY_PayPost  paypost  left join T_ORG_BaseUnit baseunit on  baseunit.fid = paypost.cfclinicid "+
	    " where   paypost.cfbusinessdate = '"+businessDate+"' and (paypost.cfpostnumber='MZYYZJ' or paypost.cfpostnumber='FMZYYZJ' or paypost.cfpostnumber='CSYYZJ' ) and  paypost.cfcityid='"+cityID+"' and paypost.cfstatus = 'qy'"+
	    " union   select  distinct import.cfempnumber AS EMPNUMBER , import.cfclinicnumber AS CLINICNUMBER from CT_PAY_ConsultantBonusUpdate  import where   import.cfbusinessdate = '"+businessDate+"'  and  import.cfcityid='"+cityID+"'  ";
	    IRowSet existZXrow = DbUtil.executeQuery(ctx, existZXSql.toString()); 
		//遍历eas中的数据 
		while (existZXrow.next()) {  
			if(existZXrow.getObject("CLINICNUMBER")!= null && !existZXrow.getObject("CLINICNUMBER").equals("") ){
				String empNumer = existZXrow.getString("EMPNUMBER"); 
				String clinicNumber = existZXrow.getString("CLINICNUMBER"); 
				existZXMap.put(empNumer+clinicNumber,"1");
			} 
		}
		
    	tempMap = PayMessage.getSHYJmbMessage(ctx,businessDate, cityID,tempMap);
        
		doctempMap = PayMessage.getDocMessage(ctx, businessDate,cityID, doctempMap);
		
		doctempMap.put("cityName", cityName);
		tempMap.put(cityNumber, cityName);
		zixunMap = PayMessage.getSHZiXunMessage(ctx, businessDate ,cityID , zixunMap);
		
		//dianZhangMap= PayMessage.getSHShopGoalMessage(ctx, businessDate ,cityID, dianZhangMap);
		
		shopMDGoalMap = PayMessage.getSHShopGoalMessage(ctx, businessDate ,cityID, shopMDGoalMap);
    
		kefuMap = PayMessage.getSHKeFuMessage(ctx, businessDate ,cityID, kefuMap);
 
		//查询洁牙导入的信息
		String importJy = " /*dialect*/ SELECT nvl(sum(sca.cfjycount),0) as JY , sca.cfempnumber EMPNUMBER ,  sca.cfclinicnumber CLINICNUMBER,type.cfjynumber JYNUMBER FROM  CT_PAY_ScalingBonusUpdate sca left join CT_PAY_ScalingType type on  sca.CFJyTypeID  = type.fid  and type.cfcityid = '"+cityID+"'  "+
		"  where   sca.cfcityid = '"+cityID+"' and sca.cfbusinessdate = '"+businessDate+"'    group by sca.cfempnumber ,  sca.cfclinicnumber,type.cfjynumber ";
		Map<String, BigDecimal> scalingMap  = getShangHaiImpScalingCoount(ctx,importJy);
		 
		
		HashMap<String,HashMap<String,String>>  jieyaAllTypeMap = new HashMap<String,HashMap<String,String>>();
		jieyaAllTypeMap = PayMessage.getJYItemMessage(ctx,businessDate,cityID,jieyaAllTypeMap);
		
		HashMap<String,String>  jieyaitemStrMap = PayMessage.getJYItemMessage(ctx,businessDate,cityID);
		String jieyaOneItem = jieyaitemStrMap.get("onejyStr");
		String jieyaTwoItem = jieyaitemStrMap.get("twojyStr");
		String jieyaThreeItem = jieyaitemStrMap.get("threejyStr");
		
		//把已经给医生计算的业绩不给医生计算
		String  updateHSSql = " /*dialect*/   update  CT_PAY_AchieveDetailTem  set cfiscount = 0   where  cfcitynumber "+incityNumStr+" and  to_char(fbizdate,'YYYYMM') = '"+businessDate+"' "+
		" AND  ( CFFIRCLASSNUMBER in ("+jieyaOneItem+") or CFSECCLASSNUMBER  in ("+jieyaTwoItem+") or  CFFeeItemDetailNumber in ("+jieyaThreeItem+") )   ";
		DbUtil.execute(ctx, updateHSSql); 
		
		 
		//获得护士所有的洁牙汇总
		HashMap<String,BigDecimal>  xtJieYaCountMap  = getSHJieYaXTCount(ctx,incityNumStr,cityNumber, businessDate,cityID, tempMap,scalingMap,jieyaAllTypeMap);
		 
		//护士 --洁牙
		StringBuffer hsSql = new StringBuffer();
		hsSql.append(" /*dialect*/select  a.cfrecdotnumber as cfrecdotnumber  , a.clinicnumber as clinicnumber  from ( ");
		hsSql.append("		select emplist.cfrecdotnumber , emplist.clinicnumber   from  ( ");
		hsSql.append("			select  tem.cfnursenumber cfrecdotnumber , tem.cfclinicnumber clinicnumber  from  CT_PAY_AchieveDetailTem  tem where  cfcitynumber   "+incityNumStr+" and to_char(fbizdate,'YYYYMM') = '"+businessDate+"' ");
		hsSql.append("			and tem.cfnursenumber  in  ( select   distinct  paypost.cfempnumber as  cfrecdotnumber  from CT_PAY_PayPost paypost where paypost.cfcityid ='"+cityID+"' and  paypost.cfstatus='qy'   and paypost.cfpostnumber ='HS' and  paypost.cfbusinessdate = '"+businessDate+"' )    ");
		hsSql.append("          and  ( CFFIRCLASSNUMBER in ("+jieyaOneItem+") or CFSECCLASSNUMBER  in ("+jieyaTwoItem+") or  CFFeeItemDetailNumber in ("+jieyaThreeItem+") ) ");
		hsSql.append("		)  emplist  "); 
		hsSql.append(" union    select cfempnumber as cfrecdotnumber  , cfclinicnumber clinicnumber  from  CT_PAY_ScalingBonusUpdate  emplist ");
		hsSql.append("  where  cfcityid ='"+cityID+"'  and  cfbusinessdate =  '"+businessDate+"'    "); 
		hsSql.append(" ) a    ");
			
		
		IRowSet hsrow = DbUtil.executeQuery(ctx, hsSql.toString()); 
		//遍历eas中的数据 
		
		CoreBaseCollection scalingCountSumCollection = new CoreBaseCollection();
		while (hsrow.next()) { 
		//while (hsrow.size() < 0) { 
			String clinicNumber = hsrow.getString("CLINICNUMBER");
			HashMap<String, String> cliniMap = companyMap.get(clinicNumber); 
			String clinicName = cliniMap.get("CLINICNAME");
			String docNumer = hsrow.getString("CFRECDOTNUMBER"); 
			String empName = "";
			
			if(personMap.get(docNumer) != null){
				empName  = personMap.get(docNumer);
			}else{
				PersonInfo person = PersonFactory.getLocalInstance(ctx).getPersonCollection(" where number = '"+docNumer+"' " ).get(0);
				if( person != null){
					empName = person.getName();
					personMap.put(docNumer, empName);
				}
				
			}
			
			String postType = ""; 
			tempMap.put("empName",empName);
			tempMap.put("clinicName",clinicName);
			HashMap<String,String>  djieyaMap = new HashMap<String,String>();
			HashMap<String,String>  mbMap = new HashMap<String,String>();
			
			HashMap<String,Object>  docMap = new HashMap<String,Object>();
		  
			ArrayList<String> arrayList = new ArrayList<String>();
			arrayList = (ArrayList<String>) tempMap.get(cityID+"_JY");
			  
			int i = 0;
			for(String str : arrayList ){
				String[] arr = str.split("#");
				String typeNumber = "";
				String typeName = "";
				String jyNumber = "";
				String jyid = "";
				if(arr.length == 1 ){
					typeNumber = arr[0];  
				}else if(arr.length == 2){
					typeNumber = arr[0];  typeName = arr[1]; jyNumber = typeNumber;
				}else if(arr.length == 3){
					typeNumber = arr[0];  typeName = arr[1]; jyNumber = arr[2];
				}else if(arr.length == 4){
					typeNumber = arr[0];  typeName = arr[1]; jyNumber = arr[2]; jyid = arr[3];
				} 
				BigDecimal jycount =BigDecimal.ZERO;
				BigDecimal xtjycount =BigDecimal.ZERO;
				BigDecimal imjycount =BigDecimal.ZERO;
				 
				imjycount =  scalingMap.get(docNumer+"_"+clinicNumber+"_"+jyNumber +"_IM")==null?BigDecimal.ZERO:scalingMap.get(docNumer+"_"+clinicNumber+"_"+jyNumber +"_IM"); 
				xtjycount = xtJieYaCountMap.get(docNumer+"_"+clinicNumber+"_"+jyNumber +"_XT")==null?BigDecimal.ZERO:xtJieYaCountMap.get(docNumer+"_"+clinicNumber+"_"+jyNumber +"_XT"); 
				if(imjycount==null){
					imjycount=BigDecimal.ZERO;
				}
				jycount = xtjycount.add(imjycount);
				
				if(jycount.compareTo(BigDecimal.ZERO) != 0 || xtjycount.compareTo(BigDecimal.ZERO) != 0   ){
					com.kingdee.eas.mw.pay.ScalingCountSumInfo scalingCount = new com.kingdee.eas.mw.pay.ScalingCountSumInfo();
					scalingCount.setBusinessDate(businessDate);
					scalingCount.setCityNumber(cityNumber);
					scalingCount.setCityName(tempMap.get(cityNumber).toString());
					scalingCount.setEmpNumber(docNumer); 
					scalingCount.setEmpName(empName);
					
					scalingCount.setClinicNumber(clinicNumber); 
					scalingCount.setClinicName(clinicName); 
					ScalingTypeInfo sctype = new ScalingTypeInfo();
					sctype.setId(BOSUuid.read(jyid));
					scalingCount.setType(sctype);
					scalingCount.setXtCount(xtjycount);
					scalingCount.setImpCount(imjycount);
					scalingCount.setAllCount(jycount);
					scalingCount.setPost(PaypostType.getEnum("HS"));
					scalingCountSumCollection.add(scalingCount);
					//ScalingCountSumFactory.getLocalInstance(ctx).save(scalingCount);
				}  
				i++; 
			} 
		} 
		if(scalingCountSumCollection.size() > 0 ){
			ScalingCountSumFactory.getLocalInstance(ctx).save(scalingCountSumCollection);
		}
		
		//免工作量比例
		BigDecimal freeWorkPro = BigDecimal.ZERO;  
		//赠金比例
		BigDecimal gifAmountPro = BigDecimal.ZERO; 
		
		HashMap tongyongmap = (HashMap)tempMap.get("TONGYONGBILI_DOC");
		freeWorkPro = new BigDecimal(tongyongmap.get("CFFREEWORKPRO").toString());   
		gifAmountPro =  new BigDecimal(tongyongmap.get("CFGIFAMOUNTPRO").toString());
		String mbbili  = tempMap.get("MBBILI").toString();
		
		
		HashMap<String,HashMap<String,String>> itemMessage = new HashMap<String,HashMap<String,String>>();
		itemMessage = PayMessage.getMBItemMessage(ctx, businessDate ,cityID, itemMessage); 
		HashMap<String,String>  oneItemMap = itemMessage.get("one");
		HashMap<String,String>  twoItemMap = itemMessage.get("two");
		HashMap<String,String>  threeItemMap = itemMessage.get("three");
		
		String mbOne = "''";
		String mbTwo = "''";
		String mbThree = "''";
		mbOne = oneItemMap.get("MB")==null? "''": oneItemMap.get("MB");
		mbTwo = twoItemMap.get("MB")==null? "''": twoItemMap.get("MB");
		mbThree = threeItemMap.get("MB")==null? "''": threeItemMap.get("MB"); 
		 
		
		BigDecimal mbachieve =BigDecimal.ZERO;
		 
		HashMap<String,BigDecimal> mbAllMap = new HashMap<String,BigDecimal>();
		String sqlMBStr = " /*dialect*/ SELECT cfempnumber,cfclinicnumber,nvl(sum(cfmbachieve),0) as MB, 'IM' AS TYPE  FROM  CT_PAY_WhiteBonusUpdate   "+
					    " where   cfcityid = '"+cityID+"' and  cfbusinessdate = '"+businessDate+"' group by cfempnumber,cfclinicnumber "+
					    " union select  cfnursenumber,  cfclinicnumber ,sum(MBACHIEVE )  as MBACHIEVE , 'XT' AS TYPE from  ( "+
						" select cfnursenumber,  cfclinicnumber, (nvl(sum(tem.cfpayment),0)- nvl(sum(nvl(tem.cfgiftpayment,0) *"+gifAmountPro+" ),0) ) as MBACHIEVE   FROM  CT_PAY_AchieveDetailTem tem  "+
						" where     to_char(fbizdate,'YYYYMM') ='"+businessDate+"'   and    cfcitynumber "+incityNumStr+"  and    (cfincome!=0 or cfpayment!=0) and  cfnursenumber is not  null and "+
					    " (tem.cffirclassnumber in  ("+mbOne+") or tem.cfsecclassnumber in ("+mbTwo+") or tem.cffeeitemdetailnumber in  ("+mbThree+") )  group by    cfnursenumber,  cfclinicnumber    "+
					    " union select  cfnursenumber,  cfclinicnumber ,(nvl(sum(cforiprice*cfqty)*"+freeWorkPro+",0)) as MBACHIEVE   FROM  CT_PAY_AchieveDetailTem tem "+
					    " where  to_char(fbizdate,'YYYYMM') ='"+businessDate+"'  and cfcitynumber "+incityNumStr+"  and cfincome=0 and  cfpayment=0   and cfnursenumber is not  null and "+
					    " ( tem.cffirclassnumber in  ("+mbOne+") or tem.cfsecclassnumber in ("+mbTwo+") or tem.cffeeitemdetailnumber in  ("+mbThree+") ) group by    cfnursenumber,  cfclinicnumber    ) group by    cfnursenumber,  cfclinicnumber    ";
		IRowSet rsMbMb =  DBUtil.executeQuery(ctx,sqlMBStr);
		if(rsMbMb!=null && rsMbMb.size() > 0){
		//if(rsMbMb!=null && rsMbMb.size() ==  0){
			  while(rsMbMb.next()){
				  mbachieve = new BigDecimal(rsMbMb.getString("MB"));  
				  String mbtype = rsMbMb.getString("TYPE");
				  String clinicNumber = rsMbMb.getString("CFCLINICNUMBER");
				  String empNumber = rsMbMb.getString("CFEMPNUMBER");
				  mbAllMap.put(empNumber+"_"+clinicNumber+"_"+mbtype, mbachieve);
			  }
		}
		
		//护士 --美白
		StringBuffer hsMBSql = new StringBuffer();//  
		hsMBSql.append(" /*dialect*/select  a.cfrecdotnumber as cfrecdotnumber  , a.clinicnumber as clinicnumber from ( ");
		hsMBSql.append("		select emplist.cfrecdotnumber , emplist.clinicnumber   from  ( ");
		hsMBSql.append("			select  tem.cfnursenumber cfrecdotnumber , tem.cfclinicnumber clinicnumber  from  CT_PAY_AchieveDetailTem  tem where  cfcitynumber "+incityNumStr+" and to_char(fbizdate,'YYYYMM') = '"+businessDate+"' ");
		hsMBSql.append("			and tem.cfnursenumber  in  ( select   distinct  paypost.cfempnumber as  cfrecdotnumber  from CT_PAY_PayPost paypost where paypost.cfcityid ='"+cityID+"' and  paypost.cfstatus='qy'   and paypost.cfpostnumber ='HS' and  paypost.cfbusinessdate = '"+businessDate+"' )    ");
		hsMBSql.append("          and  (  tem.cffirclassnumber in  ("+mbOne+") or tem.cfsecclassnumber in ("+mbTwo+") or tem.cffeeitemdetailnumber in  ("+mbThree+") )  ");
		hsMBSql.append("		)  emplist   ");  
		hsMBSql.append(" union select cfempnumber as cfrecdotnumber   , cfclinicnumber clinicnumber    from  CT_PAY_WhiteBonusUpdate emplist ");
		hsMBSql.append("   where  cfcityid ='"+cityID+"'   and  cfbusinessdate =  '"+businessDate+"'  ");
		hsMBSql.append(" ) a  ");
			
		
		IRowSet hsMBrow = DbUtil.executeQuery(ctx, hsMBSql.toString()); 
		//遍历eas中的数据 
		while (hsMBrow.next()) { 
		//while (hsrow.size() < 0) { 
			String clinicNumber = hsMBrow.getString("CLINICNUMBER");
			HashMap<String, String> cliniMap = companyMap.get(clinicNumber); 
			String clinicName = cliniMap.get("CLINICNAME");
			String docNumer = hsMBrow.getString("CFRECDOTNUMBER"); 
			String empName = "";
			
			if(personMap.get(docNumer) != null){
				empName  = personMap.get(docNumer);
			}else{
				PersonInfo person = PersonFactory.getLocalInstance(ctx).getPersonCollection(" where number = '"+docNumer+"' " ).get(0);
				if( person != null){
					empName = person.getName();
					personMap.put(docNumer, empName);
				}
			}
			String postType = ""; 
			tempMap.put("empName",empName); 
			HashMap<String,String>  mbMap = new HashMap<String,String>();
			
			HashMap<String,Object>  docMap = new HashMap<String,Object>(); 
			 
			BigDecimal immbAchieve = mbAllMap.get(docNumer+"_"+clinicNumber+"_IM");
			if(immbAchieve == null ){
				immbAchieve = BigDecimal.ZERO;
			}
			BigDecimal xtmbAchieve = mbAllMap.get(docNumer+"_"+clinicNumber+"_XT");
			if(xtmbAchieve == null ){
				xtmbAchieve = BigDecimal.ZERO;
			}
			 
			postType =  "HS"; 
			
			//美白 
			BigDecimal mbAchieve = xtmbAchieve.add(immbAchieve);  
			BigDecimal meiibaiBonus = BigDecimal.ZERO;
			
			meiibaiBonus = mbAchieve.multiply(new BigDecimal(mbbili));
			
			//mbMap = payFunctionService.getSHHSWhiteBonus(ctx,docNumer,clinicNumber, cityNumber, businessDate, cityID,tempMap , oneItemMap ,twoItemMap , threeItemMap);
			 
			String docJiangjin = "0";
			String cost = "0"; 
			doctempMap.put("empName", empName);
			 
			   
			if(  BigDecimal.ZERO.compareTo(meiibaiBonus) !=0  ){
				flag = true;
				StringBuffer sbr  = new StringBuffer(" /*dialect*/insert into CT_PAY_AchienementSum (FID,FCreatorID,FCreateTime,FLastUpdateUserID,FLastUpdateTime, ");
	    		sbr.append("cfposttype,cfbusinessdate, CFCLINICNUMBER,CFCLINICName,cfempnumber,cfempname,CFCITYNUMBER,CFCITYName,CFScalingBonus, CFWhiteBonus , CFDocBonus , CFDOCCOST , CFConBonus ,CFOtherPostBonus ,CFShopGoalBonus ) ");
	    		sbr.append("values(newbosid('4AF58046'),'"+userId+"',sysdate,'"+userId+"',sysdate, ");
	    		sbr.append(" '"+postType+"',  '"+businessDate+"','"+clinicNumber+"','"+clinicName+"' ,'"+docNumer+"','"+empName+"','"+cityNumber+"','"+cityName+"' , 0  , "+meiibaiBonus+" ,"+docJiangjin+" , "+cost+" , 0 ,0,0  )"); 
	    		//sbr.append("'"+clinicNumber+"','' ,'"+docNumer+"','','"+cityNumber+"','' , "+jieyaBonus+" , "+meiibaiBonus+" ,"+docBonus+"   )"); 
	    		
	    		if( null == docMap.get("EXISTS") || "NO".equals(docMap.get("EXISTS").toString())){
	    			StringBuffer sbr2  = new StringBuffer(" /*dialect*/insert into CT_PAY_ClinicAchieveCosthSum (FID,FCreatorID,FCreateTime,FLastUpdateUserID,FLastUpdateTime, ");
	    			sbr2.append(" cfimjycount,cfimplacount,cfxtjycount,cfxtplacount,CFIMWhiteAchieve,CFXTWhiteAchieve, ");
	    			sbr2.append(" CFXtcosydzCount,CFImcosydzCount,CFCosydzCount,CFXtcosyfdzCount,CFImcosyfdzCount,CFCosyfdzCount, ");
		    		sbr2.append(" cfposttype , cfbusinessdate, CFCLINICNUMBER,CFCLINICName,cfempnumber,cfempname,CFCITYNUMBER,CFCITYName,CFJyCount, CFPlaCount , CFWhiteAchieve  ) ");
		    		sbr2.append("values(newbosid('20D1E187'),'"+userId+"',sysdate,'"+userId+"',sysdate, ");
		    		sbr2.append("  0,0,0,0, "+immbAchieve+","+xtmbAchieve+",");
		    		sbr2.append(" 0,0,0,0, 0,0,");
		    		sbr2.append(" '"+postType+"', '"+businessDate+"','"+clinicNumber+"','"+clinicName+"' ,'"+docNumer+"','"+empName+"','"+cityNumber+"','"+cityName+"' ,0 ,0 ,"+mbAchieve+" )");  
		    		pe.getSqlList().add(sbr2); 
		    		
	    		}else{
	    			ClinicAchieveCosthSumInfo  clinicAchieveCosthSumInfo =  (ClinicAchieveCosthSumInfo) docMap.get("ClinicAchieveCosthSumInfo"); 
	    			clinicAchieveCosthSumInfo.setWhiteAchieve(clinicAchieveCosthSumInfo.getWhiteAchieve().add(mbAchieve)); 
	    		 
	    			ClinicAchieveCosthSumFactory.getLocalInstance(ctx).save(clinicAchieveCosthSumInfo);
	    		}
	    		pe.getSqlList().add(sbr);
			} 
			
		}
		
		
		HashMap<String,HashMap<String,String>>  zxAchieveMap = new HashMap<String,HashMap<String,String>>();
		String zximSql = "/*dialect*/ SELECT cfempnumber,cfclinicnumber,nvl(sum(cfzxachieve),0) as ZX , nvl(sum(cfallGenAchieve),0)  as QK , nvl(sum(cfzpAchieve),0)  as ZB   FROM  CT_PAY_ConsultantBonusUpdate   where   cfcityid = '"+cityID+"' and  cfbusinessdate = '"+businessDate+"'  group by cfempnumber,cfclinicnumber";
		IRowSet rsImZX =  DBUtil.executeQuery(ctx,zximSql);
		if(rsImZX!=null && rsImZX.size() > 0){
			  while(rsImZX.next()){	
				  HashMap<String,String>  zxMap = new HashMap<String,String>();
				  zxMap.put("QK", rsImZX.getString("QK"));
				  zxMap.put("ZX", rsImZX.getString("ZX"));
				  zxMap.put("CFEMPNUMBER", rsImZX.getString("CFEMPNUMBER"));
				  zxMap.put("CFCLINICNUMBER", rsImZX.getString("CFCLINICNUMBER"));
				  zxMap.put("ZB", rsImZX.getString("ZB")); 
				  zxAchieveMap.put(rsImZX.getString("CFEMPNUMBER")+"_"+rsImZX.getString("CFCLINICNUMBER"), zxMap);
			  }
		}
		
		
		shopMDGoalMap.put("cityName", cityName); 
		String postSql = "/*dialect*/ select   distinct  paypost.cfempnumber as CFEMPNUMBER ,  paypost.cfpostnumber as POSTTYPE  from CT_PAY_PayPost paypost where paypost.cfcityid ='"+cityID+"' and  paypost.cfstatus='qy'   and paypost.cfpostnumber in ('MZYYZJ','FMZYYZJ','CSYYZJ') and  paypost.cfbusinessdate = '"+businessDate+"'  ";//'MS310100198','MS310100064','MS310100244',
		IRowSet rs = com.kingdee.eas.custom.util.DBUtil.executeQuery(ctx,postSql); 
		if(rs!=null && rs.size() > 0){
		//if(rs!=null && rs.size() == 0){
			  while(rs.next()){	  
				  String empNumber= rs.getString("CFEMPNUMBER");
				  String empName = "";
				  if(personMap.get(empNumber) != null){
						empName  = personMap.get(empNumber);
				  }else{
					  PersonInfo person = PersonFactory.getLocalInstance(ctx).getPersonCollection(" where number = '"+empNumber+"' " ).get(0);
					  
					  if( person != null){
							empName = person.getName();
							personMap.put(empNumber, empName);
					  }
				  }
					
				  
				  String postType= rs.getString("POSTTYPE");
				  for(int i=0; i <companyList.size();i++) { 
					  String clinicNumber = companyList.get(i).get("CLINICNUMBER");
					  String clinicName = companyList.get(i).get("CLINICNAME");
					  String clinicId = companyList.get(i).get("CLINICID");  
					  if(existZXMap.get(empNumber+clinicNumber)!= null && existZXMap.get(empNumber+clinicNumber).equals("1")){
						  //PersonInfo person = PersonFactory.getLocalInstance(ctx).getPersonCollection(" where number = '"+empNumber+"' " ).get(0);
						  
						  shopMDGoalMap.put("empName", empName);
						 
						  String companyId = ""; 
						  String postClinicSql = "/*dialect*/  select   distinct  nvl(paypost.cfclinicid,'') as  CFCLINICID,paypost.cfpostnumber  as POSTNUMBER  from CT_PAY_PayPost paypost where paypost.cfempnumber ='"+empNumber+"' and  paypost.cfcityid ='"+cityID+"' and  paypost.cfclinicid ='"+clinicId+"' and  paypost.cfstatus='qy'   and paypost.cfpostnumber   in ('MZYYZJ','FMZYYZJ','CSYYZJ')  and  paypost.cfbusinessdate = '"+businessDate+"' ";
						  IRowSet clinicrs = com.kingdee.eas.custom.util.DBUtil.executeQuery(ctx,postClinicSql); 
						  HashMap<String, String> clinicMap = new HashMap<String, String>();
						  while(clinicrs.next()){	 
							 companyId =  clinicrs.getString("CFCLINICID")== null? "":clinicrs.getString("CFCLINICID");  
							 postType =  clinicrs.getString("POSTNUMBER")== null? "":clinicrs.getString("POSTNUMBER");  
						  }
						  boolean clinicflag = false;
						  if(!companyId.equals("")){
							  clinicflag = true;
						  }/*else{
							  //不是这个门店的店长或者副店长  那就是咨询师
							  postType = "ZXS";
						  }*/
						  
						  HashMap<String,String>  getDianZhangMap = new HashMap<String,String>();
						  String imotherAchieve = "0";
						  String xtotherAchieve = "0";
						  //门店业绩提成
						  String shopMDAmount = "0"; 
						  //门店达成目标 奖励金额
						  String getGlopAmount =  "0";
						  //咨询金额
						  String zxAmount =  "0";
						  String allAmount =  "0";
						  String allKeAchieve = "0";
						  
						  HashMap<String,String>  zxMap = new HashMap<String,String>();
						  if(zxAchieveMap.get(empNumber+"_"+clinicNumber) != null){
							  zxMap = zxAchieveMap.get(empNumber+"_"+clinicNumber);
						  }
						  getDianZhangMap = payFunctionService.getSHDZPostAch(ctx,empNumber,clinicName,clinicNumber, cityNumber,cityID, businessDate,clinicflag, shopMDGoalMap,postType,zxMap);
						  if(null !=getDianZhangMap && null != getDianZhangMap.get("allAmount")  ){
							  allAmount = getDianZhangMap.get("allAmount"); 
							  imotherAchieve = getDianZhangMap.get("imotherAchieve"); 
							  xtotherAchieve = getDianZhangMap.get("xtotherAchieve"); 
							  
							  shopMDAmount = getDianZhangMap.get("shopMDAmount"); 
							  getGlopAmount = getDianZhangMap.get("getGlopAmount"); 
							  zxAmount = getDianZhangMap.get("zxAmount");  
							  //allKeAchieve = getDianZhangMap.get("qkAchieve"); 
							   
						  }
						  //获取门店目标
						  if(BigDecimal.ZERO.compareTo(new BigDecimal(shopMDAmount)) !=0 || BigDecimal.ZERO.compareTo(new BigDecimal(getGlopAmount)) !=0 || BigDecimal.ZERO.compareTo(new BigDecimal(zxAmount)) !=0  ){
							   
							  flag = true;
							  StringBuffer sbr  = new StringBuffer(" /*dialect*/ insert into CT_PAY_AchienementSum (FID,FCreatorID,FCreateTime,FLastUpdateUserID,FLastUpdateTime, fsimplename ,");
					    	  sbr.append(" cfposttype, cfbusinessdate, CFCLINICNUMBER,CFCLINICName,cfempnumber,cfempname,CFCITYNUMBER,CFCITYName,CFScalingBonus, CFWhiteBonus , CFDocBonus , CFConBonus ,CFOtherPostBonus ,CFShopGoalBonus ) ");
					    	  sbr.append("values(newbosid('4AF58046'),'"+userId+"',sysdate,'"+userId+"',sysdate, '1',");
					    	  sbr.append(" '"+postType+"',  '"+businessDate+"','"+clinicNumber+"','"+clinicName+"' ,'"+empNumber+"','"+empName+"','"+cityNumber+"','"+cityName+"' , 0 ,0,0,"+zxAmount+","+shopMDAmount+" ,"+getGlopAmount+"  ) "); 
					    	  //sbr.append(" '"+businessDate+"','"+clinicNumber+"','"+clinicName+"' ,'"+empNumber+"','','"+cityNumber+"','"+cityName+"' , 0 ,0,0,0,"+otherBonus+" ,0  ) ");
					    	  pe.getSqlList().add(sbr); 
					    	  
					    	  StringBuffer sbr2  = new StringBuffer(" /*dialect*/insert into CT_PAY_ClinicAchieveCosthSum (FID,FCreatorID,FCreateTime,FLastUpdateUserID,FLastUpdateTime, ");
					    	  sbr2.append("cfposttype , cfbusinessdate, CFCLINICNUMBER,CFCLINICName,cfempnumber,cfempname,CFCITYNUMBER,CFCITYName, CFZxAchieve ,CFimZxAchieve, CFxtZxAchieve ,cfallKeAchieve) ");
					    	  sbr2.append("values(newbosid('20D1E187'),'"+userId+"',sysdate,'"+userId+"',sysdate, ");
					    	  sbr2.append(" '"+postType+"', '"+businessDate+"','"+clinicNumber+"','"+clinicName+"' ,'"+empNumber+"','"+empName+"','"+cityNumber+"','"+cityName+"' ,"+imotherAchieve+" ,"+imotherAchieve+"  ,"+xtotherAchieve+" ,"+allKeAchieve+" )");  
			    	    		
					    	  pe.getSqlList().add(sbr2); 
						  }
					  }
					  
				  }
				   
			  }
		 }   
		 
		zixunMap.put("cityName", cityName); 
		//咨询师
		String zxSql = "/*dialect*/  select   distinct  paypost.cfempnumber as CFEMPNUMBER   , paypost.cfpostnumber as POSYNUMBER from CT_PAY_PayPost paypost where paypost.cfcityid ='"+cityID+"' and  paypost.cfstatus='qy'   and paypost.cfpostnumber   in ( 'ZXS','KF') and  paypost.cfbusinessdate = '"+businessDate+"'  ";
		IRowSet zxrs = com.kingdee.eas.custom.util.DBUtil.executeQuery(ctx,zxSql); 
		if(zxrs!=null && zxrs.size() > 0){
		//if(zxrs!=null && zxrs.size() == 0){
			while(zxrs.next()){	     
				String empNumber= zxrs.getString("CFEMPNUMBER");
				String empName = "";
				if(personMap.get(empNumber) != null){
					empName  = personMap.get(empNumber);
				}else{
					 PersonInfo person = PersonFactory.getLocalInstance(ctx).getPersonCollection(" where number = '"+empNumber+"' " ).get(0);
					 if( person != null){
							empName = person.getName();
							personMap.put(empNumber, empName);
					 }
				}
				String postType= zxrs.getString("POSYNUMBER");  
				zixunMap.put("empName", empName);
				for(int i=0; i <companyList.size();i++) {  
					String clinicNumber = companyList.get(i).get("CLINICNUMBER");
					String clinicName = companyList.get(i).get("CLINICNAME");
					
					//String postType = "ZXS"; 
					if(existZXMap.get(empNumber+clinicNumber) != null && existZXMap.get(empNumber+clinicNumber).equals("1")){
						HashMap<String,String>  zxMap = new HashMap<String,String>();
						if(zxAchieveMap.get(empNumber+"_"+clinicNumber) != null){
							zxMap = zxAchieveMap.get(empNumber+"_"+clinicNumber);
						}
						String zixunBonus = "0";
						String zxAchieve = "0";
						String imzxAchieve = "0";
						String xtzxAchieve = "0";
						String allKeAchieve = "0";
						
						zxMap = payFunctionService.getSHConsultantBonus(ctx,empNumber,clinicNumber,clinicName, cityNumber, businessDate,cityID, zixunMap,zxMap); 
						if( null !=  zxMap  ){
							if(  null !=  zxMap.get("zixunBonus")   ){
								zixunBonus = zxMap.get("zixunBonus");
							}
							if(  null !=  zxMap.get("zxAchieve")   ){
								zxAchieve = zxMap.get("zxAchieve");
							} 
							if(  null !=  zxMap.get("imzxAchieve")   ){
								imzxAchieve = zxMap.get("imzxAchieve");
							} 
							if(  null !=  zxMap.get("xtzxAchieve")   ){
								xtzxAchieve = zxMap.get("xtzxAchieve");
							} 
							/*if(  null !=  zxMap.get("qkAchieve")   ){
								allKeAchieve = zxMap.get("qkAchieve");
							}  */
							postType = zxMap.get("postType");
						} 
						if(BigDecimal.ZERO.compareTo(new BigDecimal(zixunBonus)) !=0){
							flag = true;
							StringBuffer sbr  = new StringBuffer(" /*dialect*/ insert into CT_PAY_AchienementSum (FID,FCreatorID,FCreateTime,FLastUpdateUserID,FLastUpdateTime, ");
				    		sbr.append(" cfposttype,cfbusinessdate, CFCLINICNUMBER,CFCLINICName,cfempnumber,cfempname,CFCITYNUMBER,CFCITYName,CFScalingBonus, CFWhiteBonus , CFDocBonus , CFConBonus ,CFOtherPostBonus ,CFShopGoalBonus ) ");
				    		sbr.append("values(newbosid('4AF58046'),'"+userId+"',sysdate,'"+userId+"',sysdate, ");
				    		//sbr.append("'"+clinicNumber+"','"+clinicName+"' ,'"+docNumer+"','"+docName+"','"+cityNumber+"','"+cityName+"' , 0 ,0,0,"+zixunBonus+","+otherBonus+" ,"+shopGoalBonus+"  ) "); 
				    		//sbr.append(" '"+businessDate+"','"+clinicNumber+"','"+clinicName+"' ,'"+docNumer+"','','"+cityNumber+"','"+cityName+"' , 0 ,0,0,"+zixunBonus+","+otherBonus+" ,"+shopGoalBonus+"  ) ");
				    		sbr.append("  '"+postType+"', '"+businessDate+"','"+clinicNumber+"','"+clinicName+"' ,'"+empNumber+"','"+empName+"','"+cityNumber+"','"+cityName+"' , 0 ,0,0,"+zixunBonus+", 0 ,0  ) ");
				    		pe.getSqlList().add(sbr);
				    		
				    		StringBuffer sbr2  = new StringBuffer(" /*dialect*/insert into CT_PAY_ClinicAchieveCosthSum (FID,FCreatorID,FCreateTime,FLastUpdateUserID,FLastUpdateTime, ");
				    		sbr2.append(" cfposttype , cfbusinessdate, CFCLINICNUMBER,CFCLINICName,cfempnumber,cfempname,CFCITYNUMBER,CFCITYName, CFZxAchieve,CFimZxAchieve,CFxtZxAchieve ,cfallKeAchieve ) ");
				    		sbr2.append("values(newbosid('20D1E187'),'"+userId+"',sysdate,'"+userId+"',sysdate, ");
				    		sbr2.append("'"+postType+"','"+businessDate+"','"+clinicNumber+"','"+clinicName+"' ,'"+empNumber+"','"+empName+"','"+cityNumber+"','"+cityName+"' ,"+zxAchieve+" ,"+imzxAchieve+","+xtzxAchieve+" ,"+allKeAchieve+")");  
				    		
				    		pe.getSqlList().add(sbr2);
				    		
						}
					} 
				}
			}
		}
		
		String  calType = "";
		String  calTypeSql = "/*dialect*/  SELECT   CFCALTYPE  FROM CT_PAY_DocCurrencyPro  where  cfcityid= '"+cityID+"' and cfbusinessdate='"+businessDate+"'";
		IRowSet calTypeRs = com.kingdee.eas.custom.util.DBUtil.executeQuery(ctx,calTypeSql);
		if(calTypeRs!=null && calTypeRs.size() > 0){
			while(calTypeRs.next()){
				calType = calTypeRs.getString("CFCALTYPE");
			}
		}
		if("ljxy".equals(calType)){
			String  deleteFentan = "/*dialect*/   delete  CT_PAY_DocAchieveUpdate where    cfcityid= '"+cityID+"' and cfbusinessdate='"+businessDate+"' and  fname_l2 = '分摊扣除业绩'";
			com.kingdee.eas.custom.util.DBUtil.execute(ctx,deleteFentan);
		}
		 
		
		HashMap<String,String> docExisStagemap = new HashMap<String,String>();
		String docExistSql = " /*dialect*/ select  distinct CFEmpNumber ,CFType  from  CT_PAY_DocStage where  CFCityID = '"+cityID+"' and CFBusinessDate = "+businessDate+"    ";
		IRowSet docExistrs = com.kingdee.eas.custom.util.DBUtil.executeQuery(ctx,docExistSql);
		if(docExistrs!=null && docExistrs.size() > 0){
			 while(docExistrs.next()){	
				 String doctype = docExistrs.getString("CFTYPE");
				 if(docExisStagemap.get(docExistrs.getString("CFEMPNUMBER")) == null ){
					 docExisStagemap.put(docExistrs.getString("CFEMPNUMBER"), doctype);
				 }else{
					 String docExtype = docExisStagemap.get(docExistrs.getString("CFEMPNUMBER"));
					 docExisStagemap.put(docExistrs.getString("CFEMPNUMBER"), docExtype+"|"+doctype);
				 }
				 
			 }
		}
		
		//获得医生的总业绩 
		HashMap<String, BigDecimal> docAllAchieveMap = getSHDocAchieveMessage(ctx, businessDate,cityID,tongyongmap,type,incityNumStr,cityNumber,
				oneItemMap,twoItemMap,threeItemMap);
		
		//医生 
		StringBuffer docSql = new StringBuffer();//  and  cfrecdotnumber in ('MS110100043','MS110100146','MS110100067' ) 
		//docSql.append("/*dialect*/ select   distinct  cfrecdotnumber from  CT_PAY_AchieveDetailtem  where  cfcitynumber = '"+cityNumber+"'   and cfrecdotnumber is  not null and   to_char(fbizdate,'YYYYMM') ='"+businessDate+"'   and exists (select 1 from CT_PAY_PayPost paypost where paypost.cfcityid ='"+cityID+"' and  paypost.cfstatus='qy'  and paypost.cfpostnumber  != 'MZYYZJ'  and paypost.cfempnumber = CT_PAY_AchieveDetailtem.cfrecdotnumber)   group by   cfrecdotnumber  ");
		docSql.append("/*dialect*/ select distinct a.cfrecdotnumber as cfrecdotnumber from ( select   distinct  paypost.cfempnumber as  cfrecdotnumber   from CT_PAY_PayPost paypost where paypost.cfcityid ='"+cityID+"' and  paypost.cfstatus='qy'   and paypost.cfpostnumber   in ('YS','JZYS','YZ') and  paypost.cfbusinessdate = '"+businessDate+"'   ");
		docSql.append("     union   SELECT   distinct  nvl(cfdocnumber,'') as cfrecdotnumber  FROM  CT_PAY_DocAchieveUpdate  where cfcityid = '"+cityID+"' and cfbusinessdate = '"+businessDate+"' and  fname_l2 is null   ");
		docSql.append("   union  SELECT  distinct  nvl(cfempnumber,'') as cfrecdotnumber     FROM  CT_PAY_DoctorCosts  where     cfcityid = '"+cityID+"' and cfbusinessdate = '"+businessDate+"' and  CFPerformanceBase is null    ");
		docSql.append("   union  SELECT  distinct  nvl(cfdoctornumber,'') as cfrecdotnumber     FROM  CT_PAY_CostSum  where    cfcitynumber "+incityNumStr+" and cfperiod = '"+businessDate+"' and  fdescription is null  ");
		docSql.append("   union  select nvl(cfdocnumber,'') as cfrecdotnumber   from   CT_PAY_DoctorRelation where  cfcityid ='"+cityID+"' and cfbusinessdate ='"+businessDate+"'    ");
		docSql.append("   union  select nvl(cfassnumber ,'') as cfrecdotnumber  from   CT_PAY_DoctorRelation where  cfcityid ='"+cityID+"' and cfbusinessdate = '"+businessDate+"'  ) a ");
  
	        	  
		IRowSet docrow = DbUtil.executeQuery(ctx, docSql.toString()); 
		//遍历eas中的数据 
		while (docrow.next()) { 
		//while (docrow.size() < 0) { 
			String docNumer = docrow.getString("CFRECDOTNUMBER"); 
			 
			String fdocStageType = "";
			if(docExisStagemap.size() >0 && docExisStagemap.get(docNumer) != null){
				fdocStageType = docExisStagemap.get(docNumer) ;
			}
			//HashMap tongyongmap = (HashMap)doctempMap.get("TONGYONGBILI_DOC"); 
			
			BigDecimal docAchieve  = BigDecimal.ZERO;
			BigDecimal docZidaiAchieve  = BigDecimal.ZERO;
			
			//--查询这个医生的所有业绩
			if((null != doctempMap) && (null != doctempMap.get(docNumer+"_DOC"))){
				if(docAllAchieveMap.get(docNumer+"_DOC_ALL_ACHIEVE")!= null){
					docAchieve = docAllAchieveMap.get(docNumer+"_DOC_ALL_ACHIEVE");
				}
				//docAchieve = SyncEHRAchieveUtil.getSHDocAllAchieve(ctx,docNumer, businessDate,cityID,tongyongmap,type,incityNumStr);
			}
		
			
			for(int i=0; i <companyList.size();i++) { 
				String clinicNumber = companyList.get(i).get("CLINICNUMBER");
				String clinicName = companyList.get(i).get("CLINICNAME");
				String postType ="";
				
				if(existYSMap.get(docNumer+clinicNumber)!= null && existYSMap.get(docNumer+clinicNumber).equals("1")){

					String empName = "";
					if(personMap.get(docNumer) != null){
						empName  = personMap.get(docNumer);
					}else{
						PersonInfo person = PersonFactory.getLocalInstance(ctx).getPersonCollection(" where number = '"+docNumer+"' " ).get(0); 
						if( person != null){
							empName = person.getName();
							personMap.put(docNumer, empName);
					   }
					}
					HashMap<String,String>  djieyaMap = new HashMap<String,String>();
					HashMap<String,String>  mbMap = new HashMap<String,String>();
					
					HashMap<String,Object>  docMap = new HashMap<String,Object>();
					String insertSql = "";
					String insertValueSql = "";
					//洁牙
					String jyCount = "0";
					String plaCount = "0";    
					String imjyCount = "0";
					String implaCount = "0";    
					String xtjyCount = "0";
					String xtplaCount = "0";    
					String jieyaBonus = "0";  
					
					//美白
					String meiibaiBonus = "0"; 
					String mbAchieve = "0"; 
					String immbAchieve = "0"; 
					String xtmbAchieve = "0";  
					String docJiangjin = "0";
					String cost = "0";
					
					doctempMap.put("empName", empName);
					
					String imandxtinsertsql = "";
					String imandxtinsertValueSql = "";
					 
					//医生奖金
					//docMap = payDocFunctionService.getDocBonus(ctx,docNumer, clinicNumber, clinicName,businessDate, doctempMap,cityID,cityNumber,docAchieve,docZidaiAchieve,type,calType,fdocStageType);
					
					docMap = payNingBoDocCopyFunctionService.getDocBonus(ctx,docNumer, clinicNumber, clinicName,businessDate, doctempMap,cityID,cityNumber,docAchieve,docZidaiAchieve,type,calType,fdocStageType, docAllAchieveMap
							, oneItemMap, twoItemMap, threeItemMap);
					if(docMap != null){
						docJiangjin = docMap.get("JIANGJIN")==null ? "0":docMap.get("JIANGJIN").toString();
						cost = docMap.get("COST")==null ? "0":docMap.get("COST").toString(); 
						
						/*if(meiibaiBonus.equals("0") || meiibaiBonus.equals("0.0")){
							meiibaiBonus = docMap.get("mbMoney")==null ? "0":docMap.get("mbMoney").toString(); 
						}*/
						
						if(docMap.get("postType")!=null ){postType =  docMap.get("postType").toString(); }
						
						imandxtinsertsql =  docMap.get("imandxtinsertsql")==null ? "":docMap.get("imandxtinsertsql").toString();
						imandxtinsertValueSql = docMap.get("imandxtinsertValueSql")==null ? "":docMap.get("imandxtinsertValueSql").toString();
						
						insertSql = docMap.get("INSERTSQL")==null ? "":docMap.get("INSERTSQL").toString();
						insertValueSql = docMap.get("INSERTVALUESQL")==null ? "":docMap.get("INSERTVALUESQL").toString();
					}
					
					flag = true;
					if(BigDecimal.ZERO.compareTo(new BigDecimal(docJiangjin)) !=0  ){
						StringBuffer sbr  = new StringBuffer(" /*dialect*/insert into CT_PAY_AchienementSum (FID,FCreatorID,FCreateTime,FLastUpdateUserID,FLastUpdateTime, ");
			    		sbr.append("cfposttype,cfbusinessdate, CFCLINICNUMBER,CFCLINICName,cfempnumber,cfempname,CFCITYNUMBER,CFCITYName,CFScalingBonus, CFWhiteBonus , CFDocBonus , CFDOCCOST , CFConBonus ,CFOtherPostBonus ,CFShopGoalBonus ) ");
			    		sbr.append("values(newbosid('4AF58046'),'"+userId+"',sysdate,'"+userId+"',sysdate, ");
			    		sbr.append(" '"+postType+"',  '"+businessDate+"','"+clinicNumber+"','"+clinicName+"' ,'"+docNumer+"','"+empName+"','"+cityNumber+"','"+cityName+"' , "+jieyaBonus+"  , "+meiibaiBonus+" ,"+docJiangjin+" , "+cost+" , 0 ,0,0  )"); 
			    		//sbr.append("'"+clinicNumber+"','' ,'"+docNumer+"','','"+cityNumber+"','' , "+jieyaBonus+" , "+meiibaiBonus+" ,"+docBonus+"   )"); 
			    		
			    		if( null == docMap.get("EXISTS") || "NO".equals(docMap.get("EXISTS").toString())){
			    			StringBuffer sbr2  = new StringBuffer(" /*dialect*/insert into CT_PAY_ClinicAchieveCosthSum (FID,FCreatorID,FCreateTime,FLastUpdateUserID,FLastUpdateTime, ");
			    			sbr2.append(" cfimjycount,cfimplacount,cfxtjycount,cfxtplacount,CFIMWhiteAchieve,CFXTWhiteAchieve, ");
				    		sbr2.append(" cfposttype , cfbusinessdate, CFCLINICNUMBER,CFCLINICName,cfempnumber,cfempname,CFCITYNUMBER,CFCITYName,CFJyCount, CFPlaCount , CFWhiteAchieve  "+insertSql+" "+imandxtinsertsql+" ) ");
				    		sbr2.append("values(newbosid('20D1E187'),'"+userId+"',sysdate,'"+userId+"',sysdate, ");
				    		sbr2.append(" "+imjyCount+","+implaCount+","+xtjyCount+","+xtplaCount+", "+immbAchieve+","+xtmbAchieve+",");
				    		sbr2.append(" '"+postType+"', '"+businessDate+"','"+clinicNumber+"','"+clinicName+"' ,'"+docNumer+"','"+empName+"','"+cityNumber+"','"+cityName+"' ,"+jyCount+" ,"+plaCount+" ,"+mbAchieve+"  "+insertValueSql+" "+imandxtinsertValueSql+")");  
				    		pe.getSqlList().add(sbr2);
			 
			    		}else{
			    			ClinicAchieveCosthSumInfo  clinicAchieveCosthSumInfo =  (ClinicAchieveCosthSumInfo) docMap.get("ClinicAchieveCosthSumInfo");
			    			clinicAchieveCosthSumInfo.setJyCount(clinicAchieveCosthSumInfo.getJyCount().add(new BigDecimal(jyCount)));
			    			clinicAchieveCosthSumInfo.setPlaCount(clinicAchieveCosthSumInfo.getPlaCount().add(new BigDecimal(plaCount)));
			    			clinicAchieveCosthSumInfo.setWhiteAchieve(clinicAchieveCosthSumInfo.getWhiteAchieve().add(new BigDecimal(mbAchieve)));  
			    			ClinicAchieveCosthSumFactory.getLocalInstance(ctx).save(clinicAchieveCosthSumInfo);
			    		}
			    		pe.getSqlList().add(sbr);
					}
				} 
			}
		} 
		if(flag){
			Calendar caldele = Calendar.getInstance();
			caldele.setTime(new Date());
			caldele.add(Calendar.MONTH, -3);
	        Date dateDele = caldele.getTime();
	        SimpleDateFormat formatdelete= new SimpleDateFormat("yyyyMM");
	        String deleDate = formatdelete.format(dateDele);
			//StringBuffer sbr  = new StringBuffer(" /*dialect*/  delete CT_PAY_AchieveDetailtem where   fbizdate =  to_date('"+deleDate+"','YYYYMM') "); 
    		//pe.getSqlList().add(sbr);
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
		pool = Executors.newFixedThreadPool(6);
		pe = new ParallelSqlExecutor(pool); 
		flag = false;
		
		
		
		//获得客服相关的数据信息
		HashMap<String,BigDecimal>  kfImpMap = new HashMap<String,BigDecimal>(); 
		
		//周边比例 
		BigDecimal zbPro = BigDecimal.ZERO;    
		zbPro = new BigDecimal(kefuMap.get("KEFU_ZHOUBIANPRO").toString());    
		 
		String importKF = " /*dialect*/ SELECT cfempnumber,cfclinicnumber,nvl(sum(cfzpachieve),0) as kf FROM  CT_PAY_ConsultantBonusUpdate   where   cfcityid = '"+cityID+"' and cfbusinessdate = '"+businessDate+"' group by cfempnumber,cfclinicnumber  ";
		IRowSet rsKFImpMb =  DBUtil.executeQuery(ctx,importKF);
		if(rsKFImpMb!=null && rsKFImpMb.size() > 0){
			  while(rsKFImpMb.next()){
				  BigDecimal zbachieve = new BigDecimal(rsKFImpMb.getString("KF"));  
				  String clincnumber = rsKFImpMb.getString("CFCLINICNUMBER");
				  String empnumber = rsKFImpMb.getString("CFEMPNUMBER");
				  kfImpMap.put(empnumber+"_"+clincnumber+"imkfAchieve", zbachieve);
			  }
		}
		
		//赠金比例
		gifAmountPro = BigDecimal.ZERO; 
		tongyongmap = (HashMap)tempMap.get("TONGYONGBILI_DOC");
		gifAmountPro =  new BigDecimal(tongyongmap.get("CFGIFAMOUNTPRO").toString());
		
		HashMap<String,BigDecimal>  kfXTMap = new HashMap<String,BigDecimal>(); 
		String sqlKFXTStr = "  /*dialect*/ select  cfclinicnumber, cfrecpersonnumber , nvl(sum(cfpayment),0)-(nvl(sum(cfgiftpayment),0)*"+gifAmountPro+")  as KFACHIEVE   FROM  CT_PAY_AchieveDetailTem tem where   cfcitynumber "+incityNumStr+" and  to_char(fbizdate,'YYYYMM') ='"+businessDate+"'  and  cfsecclassnumber  ='75' group by cfclinicnumber, cfrecpersonnumber    ";
		
		IRowSet rsKFXTmb =  DBUtil.executeQuery(ctx,sqlKFXTStr);
		if(rsKFXTmb!=null && rsKFXTmb.size() > 0){
			  while(rsKFXTmb.next()){	
				  BigDecimal achieve= new BigDecimal(rsKFXTmb.getString("KFACHIEVE")).setScale(2,BigDecimal.ROUND_HALF_UP);
				  String clincnumber = rsKFXTmb.getString("CFCLINICNUMBER");
				  String empnumber = rsKFXTmb.getString("CFRECPERSONNUMBER"); 
				  kfXTMap.put(empnumber+"_"+clincnumber+"xtkfAchieve", achieve); 
			  }
		}
		  
		//客服
		String kfSql = " /*dialect*/   SELECT  distinct a.cfrecdotnumber ,a.clinicnumber from  ( select   distinct  paypost.cfempnumber as  cfrecdotnumber , tem.cfclinicnumber as clinicnumber   from CT_PAY_PayPost paypost  inner join CT_PAY_AchieveDetailTem tem on tem.cfrecpersonnumber  = paypost.cfempnumber and  to_char(fbizdate,'YYYYMM') = '"+businessDate+"'  and cfcitynumber = '"+cityNumber+"' "
			+" where paypost.cfpostnumber = 'KF'  and  paypost.cfcityid ='"+cityID+"' and  paypost.cfstatus='qy'   and  paypost.cfbusinessdate = '"+businessDate+"' "+
			" union select cfempnumber as cfrecdotnumber , cfclinicnumber as clinicnumber  from  CT_PAY_ConsultantBonusUpdate  where  cfcityid ='"+cityID+"'  and cfbusinessdate = '"+businessDate+"' and cfzpachieve >0 ) a ";
		 
		IRowSet kfrow = DbUtil.executeQuery(ctx, kfSql); 
		//遍历eas中的数据 
		while (kfrow.next()) { 
			String postType = "KF";
			String clinicNumber =  kfrow.getString("CLINICNUMBER"); 
			String kfNumer = kfrow.getString("CFRECDOTNUMBER"); 
			
			HashMap<String, String> cliniMap = companyMap.get(clinicNumber); 
			String clinicName = ""; 
			if(cliniMap != null){
				clinicName = cliniMap.get("CLINICNAME"); 
			}else{
				CompanyOrgUnitInfo orgUnit = CompanyOrgUnitFactory.getLocalInstance(ctx).getCompanyOrgUnitCollection(" where number = '"+clinicNumber+"' " ).get(0);
				clinicName = orgUnit.getName();
				
				HashMap<String, String> map= new HashMap<String, String>();
				map.put("CLINICNUMBER", clinicNumber);
				map.put("CLINICNAME", clinicName);
				map.put("CLINICID", orgUnit.getId().toString()); 
				companyMap.put(clinicNumber,map);

			} 
			String empName = "";
			if(personMap.get(kfNumer) != null){
				empName  = personMap.get(kfNumer);
			}else{
				PersonInfo person = PersonFactory.getLocalInstance(ctx).getPersonCollection(" where number = '"+kfNumer+"' " ).get(0);
				 
				if( person != null){
					empName = person.getName();
					personMap.put(kfNumer, empName);
			   }
			}
			HashMap<String,String>  kfMap = new HashMap<String,String>(); 
			//客服奖金
			//kfMap = payFunctionService.getSHKeFuBonus(ctx,kfNumer, clinicNumber,cityNumber,businessDate,cityID, kefuMap);
			
			//kfImpMap.get(kfNumer+"_"+clinicNumber+"imkfAchieve");
			//kfXTMap.get(kfNumer+"_"+clinicNumber+"xtkfAchieve"); 
			
			postType = "KF";
			
			BigDecimal imkfAchieve = kfImpMap.get(kfNumer+"_"+clinicNumber+"imkfAchieve")==null? BigDecimal.ZERO:kfImpMap.get(kfNumer+"_"+clinicNumber+"imkfAchieve");
			BigDecimal xtkfAchieve =  kfXTMap.get(kfNumer+"_"+clinicNumber+"xtkfAchieve")==null? BigDecimal.ZERO:kfXTMap.get(kfNumer+"_"+clinicNumber+"xtkfAchieve");
			
			
			BigDecimal kfAchieve = imkfAchieve.add(xtkfAchieve);
			BigDecimal kfBonus = kfAchieve.multiply(zbPro);

			if(BigDecimal.ZERO.compareTo(kfBonus) !=0  || BigDecimal.ZERO.compareTo(kfAchieve) !=0  ){
				if(AchienementSumFactory.getLocalInstance(ctx).exists(" where  empnumber='"+kfNumer+"' and  clinicnumber ='"+clinicNumber+"' and  businessdate='"+businessDate+"'  ")){
					AchienementSumInfo info = AchienementSumFactory.getLocalInstance(ctx).getAchienementSumInfo(" where  empnumber='"+kfNumer+"' and  clinicnumber ='"+clinicNumber+"'  and  businessdate='"+businessDate+"'  ");
					info.setKfBonus(kfBonus);
					ClinicAchieveCosthSumInfo achieveinfo = ClinicAchieveCosthSumFactory.getLocalInstance(ctx).getClinicAchieveCosthSumInfo(" where  empnumber='"+kfNumer+"' and  clinicnumber ='"+clinicNumber+"'   and  businessdate='"+businessDate+"'  ");
					achieveinfo.setAllKeAchieve(kfAchieve);
					achieveinfo.setImAllKeAchieve(imkfAchieve);
					achieveinfo.setXtAllKeAchieve(xtkfAchieve);
					AchienementSumFactory.getLocalInstance(ctx).save(info);
					ClinicAchieveCosthSumFactory.getLocalInstance(ctx).save(achieveinfo);
				}else{
					flag = true;
					StringBuffer sbr  = new StringBuffer(" /*dialect*/ insert into CT_PAY_AchienementSum (FID,FCreatorID,FCreateTime,FLastUpdateUserID,FLastUpdateTime, ");
		    		sbr.append(" cfposttype,cfbusinessdate, CFCLINICNUMBER,CFCLINICName,cfempnumber,cfempname,CFCITYNUMBER,CFCITYName,CFScalingBonus, CFWhiteBonus , CFDocBonus , CFConBonus ,CFOtherPostBonus ,CFShopGoalBonus,CFKFBONUS ) ");
		    		sbr.append("values(newbosid('4AF58046'),'"+userId+"',sysdate,'"+userId+"',sysdate, ");
		    		//sbr.append("'"+clinicNumber+"','"+clinicName+"' ,'"+docNumer+"','"+docName+"','"+cityNumber+"','"+cityName+"' , 0 ,0,0,"+zixunBonus+","+otherBonus+" ,"+shopGoalBonus+"  ) "); 
		    		//sbr.append(" '"+businessDate+"','"+clinicNumber+"','"+clinicName+"' ,'"+docNumer+"','','"+cityNumber+"','"+cityName+"' , 0 ,0,0,"+zixunBonus+","+otherBonus+" ,"+shopGoalBonus+"  ) ");
		    		sbr.append("  '"+postType+"', '"+businessDate+"','"+clinicNumber+"','"+clinicName+"' ,'"+kfNumer+"','"+empName+"','"+cityNumber+"','"+cityName+"' , 0 ,0,0,0, 0 ,0 ,"+kfBonus+" ) ");
		    		pe.getSqlList().add(sbr);
		    		
		    		StringBuffer sbr2  = new StringBuffer(" /*dialect*/insert into CT_PAY_ClinicAchieveCosthSum (FID,FCreatorID,FCreateTime,FLastUpdateUserID,FLastUpdateTime, ");
		    		sbr2.append(" cfposttype , cfbusinessdate, CFCLINICNUMBER,CFCLINICName,cfempnumber,cfempname,CFCITYNUMBER,CFCITYName, CFALLKEAchieve,CFimallkeAchieve,CFxtallkeAchieve ) ");
		    		sbr2.append("values(newbosid('20D1E187'),'"+userId+"',sysdate,'"+userId+"',sysdate, ");
		    		sbr2.append("'"+postType+"','"+businessDate+"','"+clinicNumber+"','"+clinicName+"' ,'"+kfNumer+"','"+empName+"','"+cityNumber+"','"+cityName+"' ,"+kfAchieve+" ,"+imkfAchieve+","+xtkfAchieve+")");  
		    		 
		    		pe.getSqlList().add(sbr2);
				}
				
			}
		}
		
		if(flag){
			 
			Calendar caldele = Calendar.getInstance();
			caldele.setTime(new Date());
			caldele.add(Calendar.MONTH, -3);
	        Date dateDele = caldele.getTime();
	        SimpleDateFormat formatdelete= new SimpleDateFormat("yyyyMM");
	        String deleDate = formatdelete.format(dateDele);
			//StringBuffer sbr  = new StringBuffer(" /*dialect*/  delete CT_PAY_AchieveDetailtem where   fbizdate =  to_date('"+deleDate+"','YYYYMM') "); 
    		//pe.getSqlList().add(sbr);
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
		
		//计算大众点评扣款
		//先删除对应月份的数据
		CoreBaseCollection subCollection = new CoreBaseCollection();
		ClinicComSubFactory.getLocalInstance(ctx).delete(" where city = '"+cityID+"' and businessdate = '"+businessDate+"' ");
		
		String subSql = " /*dialect*/  select paypost.cfpostnumber  as postNumber, paypost.cfempnumber as  dotnumber  , budgeDate.cfcompanyid  AS  COMPANYID, case when  budgeDate.cfclinicshop = 'dd' then nvl(clinicUp.cfbigshopprice,0)/2*nvl(message.cfbadnum,0) when budgeDate.cfclinicshop = 'xd' then  nvl(clinicUp.cfsmallshopamount,0)/2*nvl(message.cfbadnum,0)   else 0 end  as SUBAMOUNT, " +
		"  nvl(message.cfbadnum,0) as BADNUM from CT_PAY_PayPost paypost inner join  T_ORG_BaseUnit baseunit on baseunit.fid =  paypost.cfclinicid  left join CT_PAY_BudgetDate  budgeDate on budgeDate.cfcompanyid = paypost.cfclinicid and  budgeDate.cfbusinessdate =  paypost.cfbusinessdate  left join CT_PAY_ClinicUpScale  clinicUp on clinicUp.cfcityid = paypost.cfcityid and  clinicUp.cfbusinessdate =  paypost.cfbusinessdate  " +
		" left join CT_PAY_DepartMonthMsg message  on message.cfcityid = paypost.cfcityid and  message.cfmznumber = baseunit.fnumber and paypost.cfbusinessdate = message.cfbusinessdate " +
		" where paypost.cfcityid  ='"+cityID+"'  and  paypost.cfstatus='qy'   and paypost.cfpostnumber   in ('MZYYZJ','YZ') and  paypost.cfbusinessdate = '"+businessDate+"'  and  message.cfbadnum  >0   " +
		" union  select paypost.cfpostnumber  as postNumber, paypost.cfempnumber as  dotnumber  , budgeDate.cfcompanyid  AS  COMPANYID, case when  budgeDate.cfclinicshop = 'dd' then nvl(clinicUp.cfbigshopprice,0)/2*nvl(message.cfbadnum,0) when budgeDate.cfclinicshop = 'xd' then  nvl(clinicUp.cfsmallshopamount,0)/2*nvl(message.cfbadnum,0)   else 0 end  as SUBAMOUNT, " +
		"  nvl(message.cfbadnum,0) as BADNUM from CT_PAY_PayPost paypost inner join  T_ORG_BaseUnit baseunit on baseunit.fid =  paypost.cfclinicid  left join CT_PAY_BudgetDate  budgeDate on budgeDate.cfcompanyid = paypost.cfclinicid and  budgeDate.cfbusinessdate =  paypost.cfbusinessdate  left join CT_PAY_ClinicUpScale  clinicUp on clinicUp.cfcityid = paypost.cfcityid and  clinicUp.cfbusinessdate =  paypost.cfbusinessdate  " +
		" left join CT_PAY_DepartMonthMsg message  on message.cfcityid = paypost.cfcityid and  message.cfmznumber = baseunit.fnumber and paypost.cfbusinessdate = message.cfbusinessdate " +
		" where paypost.cfcityid  ='"+cityID+"'  and  paypost.cfstatus='qy'   and paypost.cfpostnumber ='FMZYYZJ'  and  paypost.cfbusinessdate = '"+businessDate+"'  and  message.cfbadnum  >0  and not exists ( select 1 from  CT_PAY_PayPost post2  where post2.cfstatus='qy'   and post2.cfpostnumber   = 'MZYYZJ'  and   post2.cfcityid  ='"+cityID+"' and  post2.cfbusinessdate = '"+businessDate+"' and  post2.cfclinicid = paypost.cfclinicid ) ";
		IRowSet subrow = DbUtil.executeQuery(ctx, subSql); 
		//遍历eas中的数据 
		CtrlUnitInfo ctrlUnitInfo = new CtrlUnitInfo();
		ctrlUnitInfo.setId(BOSUuid.read(cityID));
		while (subrow.next()) { 
			String companyid = subrow.getString("COMPANYID");
			String docNumber = subrow.getString("DOTNUMBER");
			 
			String empName = "";
			if(personMap.get(docNumber) != null){
				empName  = personMap.get(docNumber);
			}else{
				PersonInfo person = PersonFactory.getLocalInstance(ctx).getPersonCollection(" where number = '"+docNumber+"' " ).get(0);
				 
				if( person != null){
					empName = person.getName();
					personMap.put(docNumber, empName);
			   }
			}
			
			ClinicComSubInfo info = new  ClinicComSubInfo(); 
			if(ClinicComSubFactory.getLocalInstance(ctx).exists(" where clinic='"+companyid+"'  and empnumber='"+docNumber+"'  and businessdate='"+businessDate+"'  ")){
				info = ClinicComSubFactory.getLocalInstance(ctx).getClinicComSubInfo(" where clinic='"+companyid+"'  and empnumber='"+docNumber+"' and businessdate='"+businessDate+"' ");
				BigDecimal badNum = info.getBadNum()==null ?  BigDecimal.ZERO:info.getBadNum();
				info.setBadNum(subrow.getBigDecimal("BADNUM"));
				
				BigDecimal subAmount = info.getSubAmount()==null ?  BigDecimal.ZERO:info.getSubAmount();
				info.setSubAmount(subrow.getBigDecimal("SUBAMOUNT"));
			}else{
				info.setCity(ctrlUnitInfo);
				CompanyOrgUnitInfo companyInfo = new CompanyOrgUnitInfo();
				companyInfo.setId(BOSUuid.read(companyid));
				info.setClinic(companyInfo); 
				companyInfo = CompanyOrgUnitFactory.getLocalInstance(ctx).getCompanyOrgUnitInfo(" where id = '"+companyid+"' ");
				info.setClinicName(companyInfo.getName());
				info.setClinicNumber(companyInfo.getNumber());
				info.setBadNum(subrow.getBigDecimal("BADNUM"));
				info.setSubAmount(subrow.getBigDecimal("SUBAMOUNT"));
				info.setBusinessdate(businessDate);
				info.setEmpName(empName);
				info.setEmpNumber(docNumber);
				info.setPostNumber(PaypostType.getEnum(subrow.getString("POSTNUMBER")));
			} 
			subCollection.add(info);
		}	 
		ClinicComSubFactory.getLocalInstance(ctx).save(subCollection) ;
		
		
		
		CoreBaseCollection baseCollection = new CoreBaseCollection();
		//医助 转给医生奖金
		String assToDocSql = " SELECT  CFDOCNUMBER,CFDOCNAME,CFASSNUMBER,CFBILI FROM  CT_PAY_DoctorRelation where  cfcityid='"+cityID+"' and cfbusinessdate = '"+businessDate+"' and cfasstype = 'qt' ";
		IRowSet assToDocrow = DbUtil.executeQuery(ctx, assToDocSql); 
		//遍历eas中的数据 
		while(assToDocrow.next()){ 
			String docNumber = assToDocrow.getString("CFDOCNUMBER");
			String docName = assToDocrow.getString("CFDOCNAME");
			String assNumber = assToDocrow.getString("CFASSNUMBER");
			BigDecimal bili = assToDocrow.getBigDecimal("CFBILI");
			if(AchienementSumFactory.getLocalInstance(ctx).exists(" where citynumber='"+cityNumber+"' and businessdate = '"+businessDate+"'  and empnumber='"+assNumber+"' ")){
				AchienementSumCollection collection = AchienementSumFactory.getLocalInstance(ctx).getAchienementSumCollection(" where citynumber='"+cityNumber+"' and businessdate = '"+businessDate+"'  and empnumber='"+assNumber+"' ");
				for(int i=0;i<collection.size();i++){
					AchienementSumInfo info  = collection.get(i);
					BigDecimal assBouns = info.getDocBonus()==null ?BigDecimal.ZERO:info.getDocBonus();
					String clinicNumber = info.getClinicNumber();
					if(assBouns.compareTo(BigDecimal.ZERO) > 0 ){
						BigDecimal assToDocBouns = info.getAssToDocBouns()==null ?BigDecimal.ZERO:info.getAssToDocBouns();
						info.setAssToDocBouns(assToDocBouns.add(assBouns.multiply(bili)).negate());
						baseCollection.add(info);
						AchienementSumInfo docinfo  = new AchienementSumInfo();
						if(AchienementSumFactory.getLocalInstance(ctx).exists(" where  clinicnumber = '"+clinicNumber+"' and citynumber='"+cityNumber+"' and businessdate = '"+businessDate+"'  and empnumber='"+docNumber+"' ")){
							docinfo = AchienementSumFactory.getLocalInstance(ctx).getAchienementSumCollection(" where  clinicnumber = '"+clinicNumber+"' and citynumber='"+cityNumber+"' and businessdate = '"+businessDate+"'  and empnumber='"+docNumber+"' ").get(0);
							BigDecimal docassToDocBouns = docinfo.getAssToDocBouns()==null ?BigDecimal.ZERO:docinfo.getAssToDocBouns();
							docinfo.setAssToDocBouns(docassToDocBouns.add(assBouns.multiply(bili)));
							baseCollection.add(docinfo);
						}else{
							docinfo =  (AchienementSumInfo) info.clone();
							docinfo.setId(null);
							docinfo.setEmpName(docName);
							docinfo.setEmpNumber(docNumber);
							docinfo.setAssToDocBouns( assBouns.multiply(bili));
							docinfo.setDocCost(BigDecimal.ZERO);
							docinfo.setDocBonus(BigDecimal.ZERO);
							
							baseCollection.add(docinfo);
						}
					}
				}
			}
		}
		AchienementSumFactory.getLocalInstance(ctx).save(baseCollection);
		
		
	  
		ExecutorService pool3 = Executors.newFixedThreadPool(1);
	    ParallelSqlExecutor pe3 = new ParallelSqlExecutor(pool3);   
	    pe3.getSqlList().add(" update  CT_PAY_ClinicAchieveCosthSum set cfpostname = '客服' where cfbusinessdate = '"+businessDate+"' and cfcitynumber = '"+cityNumber+"' and cfposttype = 'KF' ");
	    pe3.getSqlList().add(" update  CT_PAY_ClinicAchieveCosthSum set cfpostname = '护士' where cfbusinessdate = '"+businessDate+"' and cfcitynumber = '"+cityNumber+"' and cfposttype = 'HS' ");
	    pe3.getSqlList().add(" update  CT_PAY_ClinicAchieveCosthSum set cfpostname = '洁牙师' where cfbusinessdate = '"+businessDate+"' and cfcitynumber = '"+cityNumber+"' and cfposttype = 'JYS' ");
	    pe3.getSqlList().add(" update  CT_PAY_ClinicAchieveCosthSum set cfpostname = '咨询师' where cfbusinessdate = '"+businessDate+"' and cfcitynumber = '"+cityNumber+"' and cfposttype = 'ZXS' ");
	    pe3.getSqlList().add(" update  CT_PAY_ClinicAchieveCosthSum set cfpostname = '医生' where cfbusinessdate = '"+businessDate+"' and cfcitynumber = '"+cityNumber+"' and cfposttype = 'YS' ");
	    pe3.getSqlList().add(" update  CT_PAY_ClinicAchieveCosthSum set cfpostname = '院长' where cfbusinessdate = '"+businessDate+"' and cfcitynumber = '"+cityNumber+"' and cfposttype = 'YZ' "); 
    	pe3.getSqlList().add(" update  CT_PAY_ClinicAchieveCosthSum set cfpostname = '门诊运营总监' where cfbusinessdate = '"+businessDate+"' and cfcitynumber = '"+cityNumber+"' and cfposttype = 'MZYYZJ' "); 
    	pe3.getSqlList().add(" update  CT_PAY_ClinicAchieveCosthSum set cfpostname = '兼职医生' where cfbusinessdate = '"+businessDate+"' and cfcitynumber = '"+cityNumber+"' and cfposttype = 'JZYS' "); 
    	pe3.getSqlList().add(" update  CT_PAY_ClinicAchieveCosthSum set cfpostname = '特殊兼职医生' where cfbusinessdate = '"+businessDate+"' and cfcitynumber = '"+cityNumber+"' and cfposttype = 'TSJZYS' ");
    	pe3.getSqlList().add(" update  CT_PAY_ClinicAchieveCosthSum set cfpostname = '城市运营总监' where cfbusinessdate = '"+businessDate+"' and cfcitynumber = '"+cityNumber+"' and cfposttype = 'CSYYZJ' ");
    	
    	
    	pe3.getSqlList().add(" update  CT_PAY_AchienementSum set cfpostname = '客服' where cfbusinessdate = '"+businessDate+"' and cfcitynumber = '"+cityNumber+"' and cfposttype = 'KF' ");
 	    pe3.getSqlList().add(" update  CT_PAY_AchienementSum set cfpostname = '护士' where cfbusinessdate = '"+businessDate+"' and cfcitynumber = '"+cityNumber+"' and cfposttype = 'HS' ");
 	    pe3.getSqlList().add(" update  CT_PAY_AchienementSum set cfpostname = '洁牙师' where cfbusinessdate = '"+businessDate+"' and cfcitynumber = '"+cityNumber+"' and cfposttype = 'JYS' ");
 	    pe3.getSqlList().add(" update  CT_PAY_AchienementSum set cfpostname = '咨询师' where cfbusinessdate = '"+businessDate+"' and cfcitynumber = '"+cityNumber+"' and cfposttype = 'ZXS' ");
 	    pe3.getSqlList().add(" update  CT_PAY_AchienementSum set cfpostname = '医生' where cfbusinessdate = '"+businessDate+"' and cfcitynumber = '"+cityNumber+"' and cfposttype = 'YS' ");
 	    pe3.getSqlList().add(" update  CT_PAY_AchienementSum set cfpostname = '院长' where cfbusinessdate = '"+businessDate+"' and cfcitynumber = '"+cityNumber+"' and cfposttype = 'YZ' "); 
     	pe3.getSqlList().add(" update  CT_PAY_AchienementSum set cfpostname = '门诊运营总监' where cfbusinessdate = '"+businessDate+"' and cfcitynumber = '"+cityNumber+"' and cfposttype = 'MZYYZJ' "); 
     	pe3.getSqlList().add(" update  CT_PAY_AchienementSum set cfpostname = '兼职医生' where cfbusinessdate = '"+businessDate+"' and cfcitynumber = '"+cityNumber+"' and cfposttype = 'JZYS' "); 
     	pe3.getSqlList().add(" update  CT_PAY_AchienementSum set cfpostname = '特殊兼职医生' where cfbusinessdate = '"+businessDate+"' and cfcitynumber = '"+cityNumber+"' and cfposttype = 'TSJZYS' ");
     	pe3.getSqlList().add(" update  CT_PAY_AchienementSum set cfpostname = '城市运营总监' where cfbusinessdate = '"+businessDate+"' and cfcitynumber = '"+cityNumber+"' and cfposttype = 'CSYYZJ' ");
     	 
    	
     	pe3.getSqlList().add(" update  CT_PAY_ScalingCountSum set cfpostname = '客服' where cfbusinessdate = '"+businessDate+"' and cfcitynumber = '"+cityNumber+"' and cfpost = 'KF' ");
 	    pe3.getSqlList().add(" update  CT_PAY_ScalingCountSum set cfpostname = '护士' where cfbusinessdate = '"+businessDate+"' and cfcitynumber = '"+cityNumber+"' and cfpost = 'HS' ");
 	    pe3.getSqlList().add(" update  CT_PAY_ScalingCountSum set cfpostname = '洁牙师' where cfbusinessdate = '"+businessDate+"' and cfcitynumber = '"+cityNumber+"' and cfpost = 'JYS' ");
 	    pe3.getSqlList().add(" update  CT_PAY_ScalingCountSum set cfpostname = '咨询师' where cfbusinessdate = '"+businessDate+"' and cfcitynumber = '"+cityNumber+"' and cfpost = 'ZXS' ");
 	    pe3.getSqlList().add(" update  CT_PAY_ScalingCountSum set cfpostname = '医生' where cfbusinessdate = '"+businessDate+"' and cfcitynumber = '"+cityNumber+"' and cfpost = 'YS' ");
 	    pe3.getSqlList().add(" update  CT_PAY_ScalingCountSum set cfpostname = '院长' where cfbusinessdate = '"+businessDate+"' and cfcitynumber = '"+cityNumber+"' and cfpost = 'YZ' "); 
     	pe3.getSqlList().add(" update  CT_PAY_ScalingCountSum set cfpostname = '门诊运营总监' where cfbusinessdate = '"+businessDate+"' and cfcitynumber = '"+cityNumber+"' and cfpost = 'MZYYZJ' "); 
     	pe3.getSqlList().add(" update  CT_PAY_ScalingCountSum set cfpostname = '兼职医生' where cfbusinessdate = '"+businessDate+"' and cfcitynumber = '"+cityNumber+"' and cfpost = 'JZYS' "); 
     	pe3.getSqlList().add(" update  CT_PAY_ScalingCountSum set cfpostname = '特殊兼职医生' where cfbusinessdate = '"+businessDate+"' and cfcitynumber = '"+cityNumber+"' and cfpost = 'TSJZYS' ");
     	pe3.getSqlList().add(" update  CT_PAY_ScalingCountSum set cfpostname = '城市运营总监' where cfbusinessdate = '"+businessDate+"' and cfcitynumber = '"+cityNumber+"' and cfpost = 'CSYYZJ' ");
    	/*pe3.getSqlList().add(" update  CT_PAY_PayPost set fsimplename = '1' where cfcityid = '"+cityID+"'  and  cfbusinessdate = '"+businessDate+"' ");
    	pe3.getSqlList().add(" update  CT_PAY_ScalingBonusUpdate set fsimplename = '1' where cfcityid = '"+cityID+"'  and  cfbusinessdate = '"+businessDate+"'  ");
    	pe3.getSqlList().add(" update  CT_PAY_WhiteBonusUpdate set fsimplename = '1' where cfcityid = '"+cityID+"'  and  cfbusinessdate = '"+businessDate+"'  ");
    	pe3.getSqlList().add(" update  CT_PAY_DocAchieveUpdate set fsimplename = '1' where cfcityid = '"+cityID+"'  and  cfbusinessdate = '"+businessDate+"'  ");
    	pe3.getSqlList().add(" update  CT_PAY_DoctorCosts set CFPerformanceBase = '1' where     cfcityid = '"+cityID+"' and cfbusinessdate = '"+businessDate+"'   "); 
    	pe3.getSqlList().add(" update  CT_PAY_CostSum set fdescription = '1' where      cfcitynumber "+incityNumStr+" and cfperiod = '"+businessDate+"'   ");*/


    	try {
			pe3.executeUpdate(ctx);
			pool3.shutdown(); 
		} catch (EASBizException e) { 
			e.printStackTrace();
			pool3.shutdown(); 
		} catch (BOSException e) { 
			e.printStackTrace();
			pool3.shutdown(); 
		}
		pool3.shutdown();  
	}
 
	  
	
	private HashMap<String, BigDecimal> getSHJieYaXTCount(Context ctx, String incityNumStr, String cityNumber, String businessDate, String cityId, HashMap<Object, Object> tempMap,
			Map<String, BigDecimal> scalingMap, HashMap<String,HashMap<String,String>>  jieyaAllTypeMap) {
		// TODO Auto-generated method stub
		HashMap<String, BigDecimal> map = new HashMap<String, BigDecimal>();
		
		ArrayList<String> arrayList = new ArrayList<String>();
		
		arrayList = (ArrayList<String>) tempMap.get(cityId+"_JY");  
		String sqlMBStr = "/*dialect*/ ";
		int i = 0;
		for(String str : arrayList ){
			String[] arr = str.split("#");
			String typeNumber = "";
			String typeName = "";
			String jyNumber = "";
			String jyid = "";
			if(arr.length == 1 ){
				typeNumber = arr[0];  
			}else if(arr.length == 2){
				typeNumber = arr[0]; 
				typeName = arr[1];
				jyNumber = typeNumber;
			}else if(arr.length == 3){
				typeNumber = arr[0]; 
				typeName = arr[1];
				jyNumber = arr[2];
			}else if(arr.length == 4){
				typeNumber = arr[0]; 
				typeName = arr[1];
				jyNumber = arr[2];
				jyid = arr[3];
			}
			HashMap<String,String>  oneItemMap = new HashMap<String,String>();
			HashMap<String,String>  twoItemMap = new HashMap<String,String>();
			HashMap<String,String>  threeItemMap = new HashMap<String,String>();
			
			oneItemMap = jieyaAllTypeMap.get("one");
			twoItemMap = jieyaAllTypeMap.get("two");
			threeItemMap = jieyaAllTypeMap.get("three");
			
			String  inOneItemNumber =  "''";
			String  inTwoItemNumber =  "''";
			String  inThreeItemNumber =  "''";
			
			
			String  notinOneItemNumber = "''";
			String  notinTwoItemNumber = "''";
			String  notinThreeItemNumber = "''";
		
			if(oneItemMap!= null){
				inOneItemNumber = oneItemMap.get(typeNumber)==null? "''":oneItemMap.get(typeNumber);
				notinOneItemNumber = oneItemMap.get("SSJYDZ")==null? "''":oneItemMap.get("SSJYDZ");
			}
			if(twoItemMap!= null){
				inTwoItemNumber = twoItemMap.get(typeNumber)==null? "''":twoItemMap.get(typeNumber);
				notinTwoItemNumber = twoItemMap.get("SSJYDZ")==null? "''":twoItemMap.get("SSJYDZ");;
							
			}
			if(threeItemMap!= null){
				inThreeItemNumber = threeItemMap.get(typeNumber)==null? "''":threeItemMap.get(typeNumber);
				notinThreeItemNumber = threeItemMap.get("SSJYDZ")==null? "''":threeItemMap.get("SSJYDZ");
				
			} 
			
			if(cityNumber.equals("MS3101")){
				String dzStr = "";
				String dz1Str = "";
				if(typeNumber.contains("FDZ")){
					dzStr = " and (tem.cfnurseorderdiag is null or tem.cfnurseorderdiag='')  ";
					dz1Str = "and ( tem1.cfnurseorderdiag is null or tem1.cfnurseorderdiag=''   ) ";
				}else if(typeNumber.contains("DZ")){
					dzStr = " and  tem.cfnurseorderdiag = '是'  ";
					dz1Str = " and tem1.cfnurseorderdiag = '是'  ";
				}
				
				if(i >0 ){
					sqlMBStr = sqlMBStr+" union ";
				}
				
				//and  tem1.cfrecdotnumber is not null 
				if(typeNumber.equals("JYDZ") || typeNumber.equals("JYFDZ")){//洁牙 
					sqlMBStr = sqlMBStr+" select cfnursenumber,CFClinicNumber,count(1) as THISCOUNT , '"+typeNumber+"' as type from ( " +
								" SELECT  tem.cfnursenumber, tem.CFClinicNumber,count(1) FROM  CT_PAY_AchieveDetailTem tem  where  cfcitynumber "+incityNumStr+" and to_char(fbizdate,'YYYYMM') ='"+businessDate+"'  and tem.CFBUSITYPE='挂号消费'  " + 
								" "+dzStr+"   and tem.cfnursenumber   is not null and  ( tem.CFFIRCLASSNUMBER in ("+inOneItemNumber+") or tem.CFSECCLASSNUMBER  in ("+inTwoItemNumber+") or  tem.CFFeeItemDetailNumber in ("+inThreeItemNumber+") )" +
								" and NOT EXISTS ( SELECT 1 FROM  CT_PAY_AchieveDetailTem tem1  where cfcitynumber "+incityNumStr+" and to_char(tem1.fbizdate,'YYYYMM') ='"+businessDate+"' and tem1.CFBUSITYPE='挂号消费'   " +
								" 	"+dz1Str+"	 and tem1.cfhisorderid = tem.cfhisorderid  and  ( tem1.CFFIRCLASSNUMBER in ("+notinOneItemNumber+") or tem1.CFSECCLASSNUMBER  in ("+notinTwoItemNumber+") or  tem1.CFFeeItemDetailNumber in ("+notinThreeItemNumber+") )  "+
								" 	)group by cfhisorderid,tem.cfnursenumber, tem.CFClinicNumber ) group by  cfnursenumber,CFClinicNumber ";
				}else{//舒适
					sqlMBStr = sqlMBStr+" select cfnursenumber,CFClinicNumber,count(1) as THISCOUNT, '"+typeNumber+"' as type   from ( SELECT  tem.cfnursenumber, tem.CFClinicNumber,count(1) FROM  CT_PAY_AchieveDetailTem tem  where   cfcitynumber "+incityNumStr+"  and to_char(fbizdate,'YYYYMM') ='"+businessDate+"' and tem.CFBUSITYPE='挂号消费'   "+ 
					   "   "+dzStr+"    and tem.cfnursenumber   is not null "+
					   "  and  ( tem.CFFIRCLASSNUMBER in ("+inOneItemNumber+") or tem.CFSECCLASSNUMBER  in ("+inTwoItemNumber+") or  tem.CFFeeItemDetailNumber in ("+inThreeItemNumber+") ) group by cfhisorderid,tem.cfnursenumber, tem.CFClinicNumber ) group by  cfnursenumber,CFClinicNumber   "; 
				}
				i++; 
			}else{ 
				if(i >0 ){
					sqlMBStr = sqlMBStr+" union ";
				} 
				sqlMBStr = sqlMBStr+" select cfnursenumber,CFClinicNumber,count(1) as THISCOUNT , '"+typeNumber+"' as type from ( " +
				" SELECT  tem.cfnursenumber, tem.CFClinicNumber,count(1) FROM  CT_PAY_AchieveDetailTem tem  where  cfcitynumber "+incityNumStr+" and to_char(fbizdate,'YYYYMM') ='"+businessDate+"'  and tem.CFBUSITYPE='挂号消费'  " + 
				"  and tem.cfnursenumber   is not null and  ( tem.CFFIRCLASSNUMBER in ("+inOneItemNumber+") or tem.CFSECCLASSNUMBER  in ("+inTwoItemNumber+") or  tem.CFFeeItemDetailNumber in ("+inThreeItemNumber+") )" +
				"  group by cfhisorderid,tem.cfnursenumber, tem.CFClinicNumber ) group by  cfnursenumber,CFClinicNumber ";
 
				i++; 
			}
			
		}
		
		try {
			IRowSet rsMb = DBUtil.executeQuery(ctx,sqlMBStr);
			if(rsMb!=null && rsMb.size() > 0){
				while(rsMb.next()){	 
					String jyNumber = rsMb.getString("TYPE"); 
					String empNumber = rsMb.getString("CFNURSENUMBER"); 
					String clinicNumber = rsMb.getString("CFCLINICNUMBER"); 
					BigDecimal thisCount = rsMb.getBigDecimal("THISCOUNT"); 
					map.put(empNumber+"_"+clinicNumber+"_"+jyNumber+"_XT", thisCount);
				}
			} 
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return map;
	}


	
	
	
	
	
	private Map<String, BigDecimal> getShangHaiImpScalingCoount(Context ctx,
			String importJy) throws BOSException, SQLException {
		Map<String, BigDecimal> scalingMap = new HashMap<String, BigDecimal>();
		IRowSet rsImpMb =  DBUtil.executeQuery(ctx,importJy);
		if(rsImpMb!=null && rsImpMb.size() > 0){ 
			  while(rsImpMb.next()){ 
				  String empNumber = rsImpMb.getString("EMPNUMBER");
				  String clinicNumber = rsImpMb.getString("CLINICNUMBER");
				  String jyNumber = rsImpMb.getString("JYNUMBER"); 
				  BigDecimal imjycount = new BigDecimal(rsImpMb.getString("JY"));    
				  scalingMap.put(empNumber+"_"+clinicNumber+"_"+jyNumber +"_IM", imjycount);
			  }
		} 
		return scalingMap;
	}


	private HashMap<String, BigDecimal> getSHDocAchieveMessage(Context ctx, String periodnum,String cityId,HashMap tongyongmap 
			,String type,String incityNumStr,String  cityNumber,HashMap<String,String> oneItemMap,HashMap<String,String>  twoItemMap,HashMap<String,String>  threeItemMap){  
		// TODO Auto-generated method stub
		HashMap<String, BigDecimal> map = new  HashMap<String, BigDecimal>();
		//种植
		String zzOneItem = "''"; if(oneItemMap.get("ZZ")!= null)    zzOneItem = oneItemMap.get("ZZ");
		String zzTwoItem = "''"; if(twoItemMap.get("ZZ")!= null)    zzTwoItem = twoItemMap.get("ZZ");
		String zzThreeItem = "''"; if(threeItemMap.get("ZZ")!= null)  zzThreeItem = threeItemMap.get("ZZ");
		//正畸
		String zjOneItem = "''"; if(oneItemMap.get("ZJ")!= null)    zjOneItem = oneItemMap.get("ZJ");
		String zjTwoItem = "''"; if(twoItemMap.get("ZJ")!= null)    zjTwoItem = twoItemMap.get("ZJ");
		String zjThreeItem = "''"; if(threeItemMap.get("ZJ")!= null)  zjThreeItem = threeItemMap.get("ZJ");
		
		//固定 
		String gdOneItem = "''"; if(oneItemMap.get("GD")!= null)    gdOneItem = oneItemMap.get("GD");
		String gdTwoItem = "''"; if(twoItemMap.get("GD")!= null)    gdTwoItem = twoItemMap.get("GD");
		String gdThreeItem = "''"; if(threeItemMap.get("GD")!= null)  gdThreeItem = threeItemMap.get("GD");
		//隐形
		String yxOneItem = "''"; if(oneItemMap.get("YX")!= null)    yxOneItem = oneItemMap.get("YX");
		String yxTwoItem = "''"; if(twoItemMap.get("YX")!= null)    yxTwoItem = twoItemMap.get("YX");
		String yxThreeItem = "''"; if(threeItemMap.get("YX")!= null)  yxThreeItem = threeItemMap.get("YX");
		
		
		//修复
		String xfOneItem = "''"; if(oneItemMap.get("XF")!= null)    xfOneItem = oneItemMap.get("XF");
		String xfTwoItem = "''"; if(twoItemMap.get("XF")!= null)    xfTwoItem = twoItemMap.get("XF");
		String xfThreeItem = "''"; if(threeItemMap.get("XF")!= null)  xfThreeItem = threeItemMap.get("XF");
		//儿牙
		String eyOneItem = "''"; if(oneItemMap.get("EY")!= null)    eyOneItem = oneItemMap.get("EY");
		String eyTwoItem = "''"; if(twoItemMap.get("EY")!= null)    eyTwoItem = twoItemMap.get("EY");
		String eyThreeItem = "''"; if(threeItemMap.get("EY")!= null)  eyThreeItem = threeItemMap.get("EY");
		//口内外
		String knwOneItem = "''"; if(oneItemMap.get("KNW")!= null)    knwOneItem = oneItemMap.get("KNW");
		String knwTwoItem = "''"; if(twoItemMap.get("KNW")!= null)    knwTwoItem = twoItemMap.get("KNW");
		String knwThreeItem = "''"; if(threeItemMap.get("KNW")!= null)  knwThreeItem = threeItemMap.get("KNW");
		//牙周
		String yzOneItem = "''"; if(oneItemMap.get("YZ")!= null)    yzOneItem = oneItemMap.get("YZ");
		String yzTwoItem = "''"; if(twoItemMap.get("YZ")!= null)    yzTwoItem = twoItemMap.get("YZ");
		String yzThreeItem = "''"; if(threeItemMap.get("YZ")!= null)  yzThreeItem = threeItemMap.get("YZ");
		//美白
		String mbOneItem = "''"; if(oneItemMap.get("MB")!= null)    mbOneItem = oneItemMap.get("MB");
		String mbTwoItem = "''"; if(twoItemMap.get("MB")!= null)    mbTwoItem = twoItemMap.get("MB");
		String mbThreeItem = "''"; if(threeItemMap.get("MB")!= null)  mbThreeItem = threeItemMap.get("MB");

 
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
			 
		try {
			//医生总业绩
			StringBuffer sqlYJ = new StringBuffer(); 
			if(cityNumber.equals("MS3101")){
				//种植免工作量业绩 
				sqlYJ.append(" /*dialect*/select sum(a.amount)  as allachieve  , a.cfrecdotnumber from ( ").append("\r\n")
				//种植非免工作量业绩
				.append("   select (nvl(sum(cfdocachieve),0))  as amount , cfrecdotnumber  from  CT_PAY_AchieveDetailTem  where  "+dateSql+" (cfincome!=0 or cfpayment!=0)   and cfiscount= 1  and cfcitynumber "+incityNumStr+" and cfrecdotnumber is not null  ").append("\r\n")
				.append("  and  ( cffirclassnumber in  ("+zzOneItem+") or cfsecclassnumber in ("+zzTwoItem+") or cffeeitemdetailnumber in  ("+zzThreeItem+")  )GROUP BY cfrecdotnumber ").append("\r\n")
				//隐形非免工作量业绩
				.append(" union  select (nvl(sum(cfdocachieve),0))  as amount, cfrecdotnumber  from  CT_PAY_AchieveDetailTem  where  "+dateSql+"  (cfincome!=0 or cfpayment!=0)  and CFISROUTINE = '否'  and cfiscount= 1 and cfcitynumber "+incityNumStr+" and cfrecdotnumber is not null  ").append("\r\n")
				 .append("  and  ( cffirclassnumber in  ("+yxOneItem+") or cfsecclassnumber in ("+yxTwoItem+") or cffeeitemdetailnumber in  ("+yxThreeItem+")  )GROUP BY cfrecdotnumber  ").append("\r\n")
				//常规非免工作量业绩
				.append(" union   select (nvl(sum(cfdocachieve),0))  as amount, cfrecdotnumber  from  CT_PAY_AchieveDetailTem  where   "+dateSql+" (cfincome!=0 or cfpayment!=0)   and CFISROUTINE = '是'  and cfiscount= 1  and cfcitynumber "+incityNumStr+" and cfrecdotnumber is not null ").append("\r\n")
				.append("  and  ( cffirclassnumber in  ("+gdOneItem+") or cfsecclassnumber in ("+gdTwoItem+") or cffeeitemdetailnumber in  ("+gdThreeItem+") ) GROUP BY cfrecdotnumber ").append("\r\n")
				//口内外非免工作量业绩
				.append(" union  select (nvl(sum(cfdocachieve),0))  as amount, cfrecdotnumber  from  CT_PAY_AchieveDetailTem  where  "+dateSql+"  (cfincome!=0 or cfpayment!=0)   and cfiscount= 1 and cfcitynumber "+incityNumStr+" and cfrecdotnumber is not null   ").append("\r\n")
				 .append("  and  ( cffirclassnumber in  ("+knwOneItem+") or cfsecclassnumber in ("+knwTwoItem+") or cffeeitemdetailnumber in  ("+knwThreeItem+")  )GROUP BY cfrecdotnumber ").append("\r\n")
				//儿牙非免工作量业绩
				.append(" union  select (nvl(sum(cfdocachieve),0))  as amount , cfrecdotnumber from  CT_PAY_AchieveDetailTem  where "+dateSql+"  (cfincome!=0 or cfpayment!=0)    and cfiscount= 1 and cfcitynumber "+incityNumStr+" and cfrecdotnumber is not null   ").append("\r\n")
				.append("  and  ( cffirclassnumber in  ("+eyOneItem+") or cfsecclassnumber in ("+eyTwoItem+") or cffeeitemdetailnumber in  ("+eyThreeItem+") ) GROUP BY cfrecdotnumber ").append("\r\n")
				//修复非免工作量业绩
				.append(" union  select (nvl(sum(cfdocachieve),0))  as amount, cfrecdotnumber  from  CT_PAY_AchieveDetailTem  where  "+dateSql+"  (cfincome!=0 or cfpayment!=0)    and cfiscount= 1 and cfcitynumber "+incityNumStr+" and cfrecdotnumber is not null ").append("\r\n")
				.append("  and  ( cffirclassnumber in  ("+xfOneItem+") or cfsecclassnumber in ("+xfTwoItem+") or cffeeitemdetailnumber in  ("+xfThreeItem+")  ) GROUP BY cfrecdotnumber ").append("\r\n")
				//正畸非免工作量业绩
				.append(" union   select (nvl(sum(cfdocachieve),0))  as amount, cfrecdotnumber  from  CT_PAY_AchieveDetailTem  where   "+dateSql+" (cfincome!=0 or cfpayment!=0)    and cfiscount= 1  and cfcitynumber "+incityNumStr+" and cfrecdotnumber is not null ").append("\r\n")
				.append("  and  ( cffirclassnumber in  ("+zjOneItem+") or cfsecclassnumber in ("+zjTwoItem+") or cffeeitemdetailnumber in  ("+zjThreeItem+") ) GROUP BY cfrecdotnumber ").append("\r\n")
				//导入业绩
				.append(" union SELECT  nvl( sum(cfzzachieve),0)+nvl(sum(cfyxjzachieve),0)+nvl(sum(cfgdjzachieve),0)+nvl(sum(cfknwachieve),0)+nvl(sum(cfxfachieve),0)+nvl(sum(cfeyachieve),0)   as   amount, cfdocnumber cfrecdotnumber FROM  CT_PAY_DocAchieveUpdate where cfcityid = '"+cityId+"' and  cfbusinessdate = '"+periodnum+"'  and ( cfiszidai = 0 or cfiszidai is null) and  fname_l2 is null and cfdocnumber is not null   GROUP BY cfdocnumber   ) a   GROUP BY cfrecdotnumber "); 
				
			}else{
				//种植免工作量业绩 
				sqlYJ.append(" /*dialect*/select sum(a.amount)  as allachieve  , a.cfrecdotnumber from ( ").append("\r\n")
				//种植非免工作量业绩
				.append("   select (nvl(sum(cfdocachieve),0))  as amount , cfrecdotnumber  from  CT_PAY_AchieveDetailTem  where  "+dateSql+"   cfiscount= 1  and cfcitynumber "+incityNumStr+" and cfrecdotnumber is not null  ").append("\r\n")
				.append("  and  ( cffirclassnumber in  ("+zzOneItem+") or cfsecclassnumber in ("+zzTwoItem+") or cffeeitemdetailnumber in  ("+zzThreeItem+")  )GROUP BY cfrecdotnumber ").append("\r\n")
				//隐形非免工作量业绩
				.append(" union  select (nvl(sum(cfdocachieve),0))  as amount, cfrecdotnumber  from  CT_PAY_AchieveDetailTem  where  "+dateSql+"   CFISROUTINE = '否'  and cfiscount= 1 and cfcitynumber "+incityNumStr+" and cfrecdotnumber is not null  ").append("\r\n")
				 .append("  and  ( cffirclassnumber in  ("+yxOneItem+") or cfsecclassnumber in ("+yxTwoItem+") or cffeeitemdetailnumber in  ("+yxThreeItem+")  )GROUP BY cfrecdotnumber  ").append("\r\n")
				//常规非免工作量业绩
				.append(" union   select (nvl(sum(cfdocachieve),0))  as amount, cfrecdotnumber  from  CT_PAY_AchieveDetailTem  where   "+dateSql+"   CFISROUTINE = '是'  and cfiscount= 1  and cfcitynumber "+incityNumStr+" and cfrecdotnumber is not null ").append("\r\n")
				.append("  and  ( cffirclassnumber in  ("+gdOneItem+") or cfsecclassnumber in ("+gdTwoItem+") or cffeeitemdetailnumber in  ("+gdThreeItem+") ) GROUP BY cfrecdotnumber ").append("\r\n")
				//口内外非免工作量业绩
				.append(" union  select (nvl(sum(cfdocachieve),0))  as amount, cfrecdotnumber  from  CT_PAY_AchieveDetailTem  where  "+dateSql+"   cfiscount= 1 and cfcitynumber "+incityNumStr+" and cfrecdotnumber is not null   ").append("\r\n")
				 .append("  and  ( cffirclassnumber in  ("+knwOneItem+") or cfsecclassnumber in ("+knwTwoItem+") or cffeeitemdetailnumber in  ("+knwThreeItem+")  )GROUP BY cfrecdotnumber ").append("\r\n")
				//儿牙非免工作量业绩
				.append(" union  select (nvl(sum(cfdocachieve),0))  as amount , cfrecdotnumber from  CT_PAY_AchieveDetailTem  where "+dateSql+"   cfiscount= 1 and cfcitynumber "+incityNumStr+" and cfrecdotnumber is not null   ").append("\r\n")
				.append("  and  ( cffirclassnumber in  ("+eyOneItem+") or cfsecclassnumber in ("+eyTwoItem+") or cffeeitemdetailnumber in  ("+eyThreeItem+") ) GROUP BY cfrecdotnumber ").append("\r\n")
				//牙周非免工作量业绩
				.append(" union  select (nvl(sum(cfdocachieve),0))  as amount , cfrecdotnumber from  CT_PAY_AchieveDetailTem  where "+dateSql+"   cfiscount= 1 and cfcitynumber "+incityNumStr+" and cfrecdotnumber is not null   ").append("\r\n")
				.append("  and  ( cffirclassnumber in  ("+yzOneItem+") or cfsecclassnumber in ("+yzTwoItem+") or cffeeitemdetailnumber in  ("+yzThreeItem+") ) GROUP BY cfrecdotnumber ").append("\r\n")
				 
				//修复非免工作量业绩
				.append(" union  select (nvl(sum(cfdocachieve),0))  as amount, cfrecdotnumber  from  CT_PAY_AchieveDetailTem  where  "+dateSql+"   cfiscount= 1 and cfcitynumber "+incityNumStr+" and cfrecdotnumber is not null ").append("\r\n")
				.append("  and  ( cffirclassnumber in  ("+xfOneItem+") or cfsecclassnumber in ("+xfTwoItem+") or cffeeitemdetailnumber in  ("+xfThreeItem+")  ) GROUP BY cfrecdotnumber ").append("\r\n")
				//正畸非免工作量业绩
				.append(" union   select (nvl(sum(cfdocachieve),0))  as amount, cfrecdotnumber  from  CT_PAY_AchieveDetailTem  where   "+dateSql+"   cfiscount= 1  and cfcitynumber "+incityNumStr+" and cfrecdotnumber is not null ").append("\r\n")
				.append("  and  ( cffirclassnumber in  ("+zjOneItem+") or cfsecclassnumber in ("+zjTwoItem+") or cffeeitemdetailnumber in  ("+zjThreeItem+") ) GROUP BY cfrecdotnumber ").append("\r\n")
				//导入业绩
				.append(" union SELECT  nvl( sum(cfzzachieve),0)+nvl(sum(cfyxjzachieve),0)+nvl(sum(cfgdjzachieve),0)+nvl(sum(cfknwachieve),0)+nvl(sum(cfxfachieve),0)+nvl(sum(cfeyachieve),0)   as   amount, cfdocnumber cfrecdotnumber FROM  CT_PAY_DocAchieveUpdate where cfcityid = '"+cityId+"' and  cfbusinessdate = '"+periodnum+"'  and ( cfiszidai = 0 or cfiszidai is null) and  fname_l2 is null and cfdocnumber is not null   GROUP BY cfdocnumber   ) a   GROUP BY cfrecdotnumber "); 
				
			}
			
			System.out.println("--"+sqlYJ.toString());
			
			IRowSet yjrs = com.kingdee.eas.custom.util.DBUtil.executeQuery(ctx,sqlYJ.toString());
			if(yjrs!=null && yjrs.size() > 0){ 
				while(yjrs.next()){	
					BigDecimal allachieve =  new BigDecimal(yjrs.getString("ALLACHIEVE"));
					String empNumber =  yjrs.getString("CFRECDOTNUMBER") ;
					map.put(empNumber+"_DOC_ALL_ACHIEVE", allachieve);
				}
			}
			
			//医生系统业绩
			StringBuffer sqlDocXt= new StringBuffer(); 
			if(cityNumber.equals("MS3101")){
				//种植免工作量业绩
				sqlDocXt.append("  /*dialect*/select sum(amount) as sumamount , 'freezz' as type,cfrecdotnumber,cfclinicnumber from ( select  (nvl(sum(cfdocachieve),0)) as amount,cfrecdotnumber, cfclinicnumber  from  CT_PAY_AchieveDetailTem  where "+dateSql+"  cfcitynumber "+incityNumStr+" and  cfincome  =0  and  cfpayment =0  and cfiscount= 1 and cfbusitype = '挂号消费' and cfrecdotnumber is not null ").append("\r\n")
				.append("  and  ( cffirclassnumber in  ("+zzOneItem+") or cfsecclassnumber in ("+zzTwoItem+") or cffeeitemdetailnumber in  ("+zzThreeItem+") )group by cfrecdotnumber,cfclinicnumber ) group by cfrecdotnumber,cfclinicnumber  ").append("\r\n")
				 //种植非免工作量业绩
				.append(" union select sum(amount) as sumamount , 'zz' as type,cfrecdotnumber,cfclinicnumber from ( select  (nvl(sum(cfdocachieve),0)) as amount ,cfrecdotnumber, cfclinicnumber from  CT_PAY_AchieveDetailTem where   "+dateSql+"  cfcitynumber "+incityNumStr+" and (cfincome!=0 or cfpayment!=0)   and cfiscount= 1  and cfrecdotnumber is not null ").append("\r\n")
				.append("  and  ( cffirclassnumber in  ("+zzOneItem+") or cfsecclassnumber in ("+zzTwoItem+") or cffeeitemdetailnumber in  ("+zzThreeItem+") )group by cfrecdotnumber,cfclinicnumber ) group by cfrecdotnumber,cfclinicnumber  ").append("\r\n")
				  
				//隐形免工作量
				.append(" union select sum(amount) as sumamount , 'freeyx' as type,cfrecdotnumber,cfclinicnumber from ( select  (nvl(sum(cfdocachieve),0)) as amount ,cfrecdotnumber, cfclinicnumber from  CT_PAY_AchieveDetailTem  where "+dateSql+"  cfcitynumber "+incityNumStr+" and  cfincome  =0  and  cfpayment =0  and CFISROUTINE = '否'   and cfbusitype = '挂号消费'  and cfiscount= 1 and cfrecdotnumber is not null ").append("\r\n")
				.append("  and  ( cffirclassnumber in  ("+yxOneItem+") or cfsecclassnumber in ("+yxTwoItem+") or cffeeitemdetailnumber in  ("+yxThreeItem+") ) group by cfrecdotnumber,cfclinicnumber ) group by cfrecdotnumber,cfclinicnumber ").append("\r\n")
				//隐形非免工作量业绩
				.append(" union select sum(amount) as sumamount , 'yx' as type,cfrecdotnumber,cfclinicnumber from ( select  (nvl(sum(cfdocachieve),0)) as amount,cfrecdotnumber, cfclinicnumber  from  CT_PAY_AchieveDetailTem  where "+dateSql+"  cfcitynumber "+incityNumStr+" and  (cfincome!=0 or cfpayment!=0)   and CFISROUTINE = '否'    and cfiscount= 1 and cfrecdotnumber is not null ").append("\r\n")
				.append("  and  ( cffirclassnumber in  ("+yxOneItem+") or cfsecclassnumber in ("+yxTwoItem+") or cffeeitemdetailnumber in  ("+yxThreeItem+") ) group by cfrecdotnumber,cfclinicnumber ) group by cfrecdotnumber,cfclinicnumber  ").append("\r\n")
				
				//常规免工作量
				.append(" union select sum(amount) as sumamount , 'freegd' as type,cfrecdotnumber,cfclinicnumber from ( select  (nvl(sum(cfdocachieve),0)) as amount,cfrecdotnumber, cfclinicnumber  from  CT_PAY_AchieveDetailTem  where "+dateSql+"  cfcitynumber "+incityNumStr+" and   cfincome  =0  and  cfpayment =0   and CFISROUTINE = '是'  and cfbusitype = '挂号消费'  and cfiscount= 1 and cfrecdotnumber is not null ").append("\r\n")
				.append("  and  ( cffirclassnumber in  ("+gdOneItem+") or cfsecclassnumber in ("+gdTwoItem+") or cffeeitemdetailnumber in  ("+gdThreeItem+") ) group by cfrecdotnumber,cfclinicnumber ) group by cfrecdotnumber,cfclinicnumber ").append("\r\n")
				//常规非免工作量业绩
				.append(" union select sum(amount) as sumamount , 'gd' as type,cfrecdotnumber,cfclinicnumber from ( select  (nvl(sum(cfdocachieve),0)) as amount,cfrecdotnumber, cfclinicnumber  from  CT_PAY_AchieveDetailTem  where "+dateSql+"  cfcitynumber "+incityNumStr+" and  (cfincome!=0 or cfpayment!=0) and CFISROUTINE = '是'  and cfiscount= 1 and cfrecdotnumber is not null ").append("\r\n")
				.append("  and  ( cffirclassnumber in  ("+gdOneItem+") or cfsecclassnumber in ("+gdTwoItem+") or cffeeitemdetailnumber in  ("+gdThreeItem+") ) group by cfrecdotnumber,cfclinicnumber ) group by cfrecdotnumber,cfclinicnumber  ").append("\r\n")
				//口内外免工作量
				.append(" union select sum(amount) as sumamount , 'freeknw' as type,cfrecdotnumber,cfclinicnumber from ( select (nvl(sum(cfdocachieve),0)) as amount ,cfrecdotnumber, cfclinicnumber from  CT_PAY_AchieveDetailTem  where "+dateSql+"  cfcitynumber "+incityNumStr+" and  cfincome  =0  and  cfpayment =0   and cfbusitype = '挂号消费'  and cfiscount= 1 and cfrecdotnumber is not null ").append("\r\n")
				.append("  and  ( cffirclassnumber in  ("+knwOneItem+") or cfsecclassnumber in ("+knwTwoItem+") or cffeeitemdetailnumber in  ("+knwThreeItem+") ) group by cfrecdotnumber,cfclinicnumber ) group by cfrecdotnumber,cfclinicnumber ") .append("\r\n")
				//口内外非免工作量业绩
				.append(" union select sum(amount) as sumamount , 'knw' as type,cfrecdotnumber,cfclinicnumber from ( select (nvl(sum(cfdocachieve),0)) as amount,cfrecdotnumber, cfclinicnumber from  CT_PAY_AchieveDetailTem  where "+dateSql+"  cfcitynumber "+incityNumStr+" and   (cfincome!=0 or cfpayment!=0)  and cfiscount= 1 and cfrecdotnumber is not null ").append("\r\n")
				.append("  and  ( cffirclassnumber in  ("+knwOneItem+") or cfsecclassnumber in ("+knwTwoItem+") or cffeeitemdetailnumber in  ("+knwThreeItem+") ) group by cfrecdotnumber,cfclinicnumber ) group by cfrecdotnumber,cfclinicnumber  ").append("\r\n")
				  
				//儿牙免工作量
				.append(" union select sum(amount) as sumamount , 'freeey' as type,cfrecdotnumber,cfclinicnumber from ( select (nvl(sum(cfdocachieve),0))as amount,cfrecdotnumber, cfclinicnumber  from  CT_PAY_AchieveDetailTem  where "+dateSql+"  cfcitynumber "+incityNumStr+" and   cfincome  =0  and  cfpayment =0  and cfbusitype = '挂号消费'  and cfiscount= 1 and cfrecdotnumber is not null ").append("\r\n")
				.append("  and  ( cffirclassnumber in  ("+eyOneItem+") or cfsecclassnumber in ("+eyTwoItem+") or cffeeitemdetailnumber in  ("+eyThreeItem+") ) group by cfrecdotnumber,cfclinicnumber ) group by cfrecdotnumber,cfclinicnumber  ") .append("\r\n")
				//儿牙非免工作量业绩
				.append(" union select sum(amount) as sumamount , 'ey' as type,cfrecdotnumber,cfclinicnumber from ( select (nvl(sum(cfdocachieve),0)) as amount,cfrecdotnumber, cfclinicnumber  from  CT_PAY_AchieveDetailTem  where "+dateSql+" cfcitynumber "+incityNumStr+" and  (cfincome!=0 or cfpayment!=0)  and cfiscount= 1 and cfrecdotnumber is not null ").append("\r\n")
				.append("  and  ( cffirclassnumber in  ("+eyOneItem+") or cfsecclassnumber in ("+eyTwoItem+") or cffeeitemdetailnumber in  ("+eyThreeItem+") ) group by cfrecdotnumber,cfclinicnumber ) group by cfrecdotnumber,cfclinicnumber  ").append("\r\n")
				 
				//修复免工作量
				.append(" union select sum(amount) as sumamount , 'freexf' as type,cfrecdotnumber,cfclinicnumber from ( select (nvl(sum(cfdocachieve),0)) as amount ,cfrecdotnumber, cfclinicnumber from  CT_PAY_AchieveDetailTem  where "+dateSql+"  cfcitynumber "+incityNumStr+" and  cfincome  =0  and  cfpayment =0  and cfbusitype = '挂号消费'   and cfiscount= 1 and cfrecdotnumber is not null ").append("\r\n")
				.append("  and  ( cffirclassnumber in  ("+xfOneItem+") or cfsecclassnumber in ("+xfTwoItem+") or cffeeitemdetailnumber in  ("+xfThreeItem+") ) group by cfrecdotnumber,cfclinicnumber ) group by cfrecdotnumber,cfclinicnumber  ") .append("\r\n")
				//修复非免工作量业绩
				.append(" union select sum(amount) as sumamount , 'xf' as type,cfrecdotnumber,cfclinicnumber from ( select (nvl(sum(cfdocachieve),0)) as amount ,cfrecdotnumber, cfclinicnumber from  CT_PAY_AchieveDetailTem  where "+dateSql+"  cfcitynumber "+incityNumStr+" and  (cfincome!=0 or cfpayment!=0) and cfiscount= 1 and cfrecdotnumber is not null ").append("\r\n")
				.append("  and  ( cffirclassnumber in  ("+xfOneItem+") or cfsecclassnumber in ("+xfTwoItem+") or cffeeitemdetailnumber in  ("+xfThreeItem+") ) group by cfrecdotnumber,cfclinicnumber ) group by cfrecdotnumber,cfclinicnumber  ").append("\r\n")
				
				//牙周免工作量    牙周：一级分类洁牙牙周美白，二级分类牙周治疗、激光：全归医生    二级分类洁牙、美白（部分收费项表一）：如果有接诊护士，算接诊护士，不算接诊医生
				.append(" union  select sum(amount) as sumamount , 'freeyz' as type,cfrecdotnumber,cfclinicnumber from ( select  (nvl(sum(cfdocachieve),0)) as amount ,cfrecdotnumber, cfclinicnumber from  CT_PAY_AchieveDetailTem  where "+dateSql+"  cfcitynumber "+incityNumStr+"   and cfincome  =0  and  cfpayment =0  and cfbusitype = '挂号消费'  and cfiscount= 1  and cfrecdotnumber is not null ").append("\r\n")
				.append("  and  ( cffirclassnumber in  ("+yzOneItem+") or cfsecclassnumber in ("+yzTwoItem+") or cffeeitemdetailnumber in  ("+yzThreeItem+") ) group by cfrecdotnumber,cfclinicnumber )group by cfrecdotnumber,cfclinicnumber   ").append("\r\n")
			  
				//牙周非免工作量业绩
				.append(" union select sum(amount) as sumamount , 'yz' as type,cfrecdotnumber,cfclinicnumber from ( select  (nvl(sum(cfdocachieve),0)) as amount,cfrecdotnumber, cfclinicnumber  from  CT_PAY_AchieveDetailTem  where "+dateSql+"  cfcitynumber "+incityNumStr+" and  (cfincome!=0 or cfpayment!=0)    and cfiscount= 1  and cfrecdotnumber is not null ").append("\r\n")
				.append("  and  ( cffirclassnumber in  ("+yzOneItem+") or cfsecclassnumber in ("+yzTwoItem+") or cffeeitemdetailnumber in  ("+yzThreeItem+") ) group by cfrecdotnumber,cfclinicnumber  ) group by cfrecdotnumber,cfclinicnumber  ").append("\r\n")
				
				//正畸免工作量
				.append(" union select sum(amount) as sumamount , 'freezj' as type,cfrecdotnumber,cfclinicnumber from ( select (nvl(sum(cfdocachieve),0)) as amount ,cfrecdotnumber, cfclinicnumber from  CT_PAY_AchieveDetailTem  where "+dateSql+"  cfcitynumber "+incityNumStr+" and  cfincome  =0  and  cfpayment =0  and cfbusitype = '挂号消费'   and cfiscount= 1 and cfrecdotnumber is not null ").append("\r\n")
				.append("  and  ( cffirclassnumber in  ("+zjOneItem+") or cfsecclassnumber in ("+zjTwoItem+") or cffeeitemdetailnumber in  ("+zjThreeItem+") ) group by cfrecdotnumber,cfclinicnumber ) group by cfrecdotnumber,cfclinicnumber  ") .append("\r\n")
				//正畸非免工作量业绩
				.append(" union select sum(amount) as sumamount , 'zj' as type,cfrecdotnumber,cfclinicnumber from ( select (nvl(sum(cfdocachieve),0)) as amount ,cfrecdotnumber, cfclinicnumber from  CT_PAY_AchieveDetailTem  where "+dateSql+"  cfcitynumber "+incityNumStr+" and  (cfincome!=0 or cfpayment!=0) and cfiscount= 1 and cfrecdotnumber is not null ").append("\r\n")
				.append("  and  ( cffirclassnumber in  ("+zjOneItem+") or cfsecclassnumber in ("+zjTwoItem+") or cffeeitemdetailnumber in  ("+zjThreeItem+") ) group by cfrecdotnumber,cfclinicnumber ) group by cfrecdotnumber,cfclinicnumber  ").append("\r\n");
				 
			}else{
				//种植非免工作量业绩
				sqlDocXt.append(" /*dialect*/ select sum(amount) as sumamount , 'zz' as type,cfrecdotnumber,cfclinicnumber from ( select  (nvl(sum(cfdocachieve),0)) as amount ,cfrecdotnumber, cfclinicnumber from  CT_PAY_AchieveDetailTem where   "+dateSql+"  cfcitynumber "+incityNumStr+"   and cfrecdotnumber is not null ").append("\r\n")
				.append("  and  ( cffirclassnumber in  ("+zzOneItem+") or cfsecclassnumber in ("+zzTwoItem+") or cffeeitemdetailnumber in  ("+zzThreeItem+") )group by cfrecdotnumber,cfclinicnumber ) group by cfrecdotnumber,cfclinicnumber  ").append("\r\n")
				
				//隐形非免工作量业绩
				.append(" union select sum(amount) as sumamount , 'yx' as type,cfrecdotnumber,cfclinicnumber from ( select  (nvl(sum(cfdocachieve),0)) as amount,cfrecdotnumber, cfclinicnumber  from  CT_PAY_AchieveDetailTem  where "+dateSql+"  cfcitynumber "+incityNumStr+"    and CFISROUTINE = '否'    and cfiscount= 1 and cfrecdotnumber is not null ").append("\r\n")
				.append("  and  ( cffirclassnumber in  ("+yxOneItem+") or cfsecclassnumber in ("+yxTwoItem+") or cffeeitemdetailnumber in  ("+yxThreeItem+") ) group by cfrecdotnumber,cfclinicnumber ) group by cfrecdotnumber,cfclinicnumber  ").append("\r\n")
				
				//常规非免工作量业绩
				.append(" union select sum(amount) as sumamount , 'gd' as type,cfrecdotnumber,cfclinicnumber from ( select  (nvl(sum(cfdocachieve),0)) as amount,cfrecdotnumber, cfclinicnumber  from  CT_PAY_AchieveDetailTem  where "+dateSql+"  cfcitynumber "+incityNumStr+"  and CFISROUTINE = '是'  and cfiscount= 1 and cfrecdotnumber is not null ").append("\r\n")
				.append("  and  ( cffirclassnumber in  ("+gdOneItem+") or cfsecclassnumber in ("+gdTwoItem+") or cffeeitemdetailnumber in  ("+gdThreeItem+") ) group by cfrecdotnumber,cfclinicnumber ) group by cfrecdotnumber,cfclinicnumber  ").append("\r\n")
				//口内外非免工作量业绩
				.append(" union select sum(amount) as sumamount , 'knw' as type,cfrecdotnumber,cfclinicnumber from ( select (nvl(sum(cfdocachieve),0)) as amount,cfrecdotnumber, cfclinicnumber from  CT_PAY_AchieveDetailTem  where "+dateSql+"  cfcitynumber "+incityNumStr+"   and cfiscount= 1 and cfrecdotnumber is not null ").append("\r\n")
				.append("  and  ( cffirclassnumber in  ("+knwOneItem+") or cfsecclassnumber in ("+knwTwoItem+") or cffeeitemdetailnumber in  ("+knwThreeItem+") ) group by cfrecdotnumber,cfclinicnumber ) group by cfrecdotnumber,cfclinicnumber  ").append("\r\n")
				  
				//儿牙非免工作量业绩
				.append(" union select sum(amount) as sumamount , 'ey' as type,cfrecdotnumber,cfclinicnumber from ( select (nvl(sum(cfdocachieve),0)) as amount,cfrecdotnumber, cfclinicnumber  from  CT_PAY_AchieveDetailTem  where "+dateSql+" cfcitynumber "+incityNumStr+"  and cfiscount= 1 and cfrecdotnumber is not null ").append("\r\n")
				.append("  and  ( cffirclassnumber in  ("+eyOneItem+") or cfsecclassnumber in ("+eyTwoItem+") or cffeeitemdetailnumber in  ("+eyThreeItem+") ) group by cfrecdotnumber,cfclinicnumber ) group by cfrecdotnumber,cfclinicnumber  ").append("\r\n")
				
				//修复非免工作量业绩
				.append(" union select sum(amount) as sumamount , 'xf' as type,cfrecdotnumber,cfclinicnumber from ( select (nvl(sum(cfdocachieve),0)) as amount ,cfrecdotnumber, cfclinicnumber from  CT_PAY_AchieveDetailTem  where "+dateSql+"  cfcitynumber "+incityNumStr+"  and cfiscount= 1 and cfrecdotnumber is not null ").append("\r\n")
				.append("  and  ( cffirclassnumber in  ("+xfOneItem+") or cfsecclassnumber in ("+xfTwoItem+") or cffeeitemdetailnumber in  ("+xfThreeItem+") ) group by cfrecdotnumber,cfclinicnumber ) group by cfrecdotnumber,cfclinicnumber  ").append("\r\n")
				
				//牙周非免工作量业绩
				.append(" union select sum(amount) as sumamount , 'yz' as type,cfrecdotnumber,cfclinicnumber from ( select  (nvl(sum(cfdocachieve),0)) as amount,cfrecdotnumber, cfclinicnumber  from  CT_PAY_AchieveDetailTem  where "+dateSql+"  cfcitynumber "+incityNumStr+"   and cfiscount= 1  and cfrecdotnumber is not null ").append("\r\n")
				.append("  and  ( cffirclassnumber in  ("+yzOneItem+") or cfsecclassnumber in ("+yzTwoItem+") or cffeeitemdetailnumber in  ("+yzThreeItem+") ) group by cfrecdotnumber,cfclinicnumber  ) group by cfrecdotnumber,cfclinicnumber  ").append("\r\n")
				
				//正畸非免工作量业绩
				.append(" union select sum(amount) as sumamount , 'zj' as type,cfrecdotnumber,cfclinicnumber from ( select  (nvl(sum(cfdocachieve),0)) as amount,cfrecdotnumber, cfclinicnumber  from  CT_PAY_AchieveDetailTem  where "+dateSql+"  cfcitynumber "+incityNumStr+"   and cfiscount= 1  and cfrecdotnumber is not null ").append("\r\n")
				.append("  and  ( cffirclassnumber in  ("+zjOneItem+") or cfsecclassnumber in ("+zjTwoItem+") or cffeeitemdetailnumber in  ("+zjThreeItem+") ) group by cfrecdotnumber,cfclinicnumber  ) group by cfrecdotnumber,cfclinicnumber  ").append("\r\n");
				
			}
			IRowSet docXTrs = com.kingdee.eas.custom.util.DBUtil.executeQuery(ctx,sqlDocXt);
		  	if(docXTrs!=null && docXTrs.size() > 0){ 
			  	while(docXTrs.next()){	
			  		String clinicNumber = docXTrs.getString("CFCLINICNUMBER");
			  		String empNumber = docXTrs.getString("CFRECDOTNUMBER");
			  		String thistype = docXTrs.getString("TYPE");
			  		BigDecimal amount = docXTrs.getBigDecimal("SUMAMOUNT");
			  		map.put(empNumber+"_"+clinicNumber+"_"+thistype+"_DOC_XT_ACHIEVE", amount); 
			  	}
			}
		  	
		  	//医生导入业绩
		  	StringBuffer sqlDocImp= new StringBuffer(); 
		  	sqlDocImp.append("  /*dialect*/ SELECT cfdocnumber,cfclinicnumber ,nvl( sum(cfzzachieve),0) as ZZ , nvl(sum(cfyxjzachieve),0) as YXJZ , nvl(sum(cfgdjzachieve),0) as GDJZ , nvl(sum(cfknwachieve),0) as KNW , nvl(sum(cfxfachieve),0) as XF , nvl(sum(cfeyachieve),0) as EY , nvl(sum(cfyzachieve),0) as YZ , nvl(sum(cfmbachieve),0) as MB , nvl(sum(cfjzmoney),0) as JZ   ").append("\r\n")
			.append(" FROM  CT_PAY_DocAchieveUpdate where cfcityid = '"+cityId+"'   and  cfbusinessdate = '"+periodnum+"' and ( cfiszidai = 0 or cfiszidai is null)   and  fname_l2 is null  group  by cfdocnumber,cfclinicnumber  ");
		  	IRowSet docIMPrs = com.kingdee.eas.custom.util.DBUtil.executeQuery(ctx,sqlDocImp);
		  	if(docIMPrs!=null && docIMPrs.size() > 0){ 
			  	while(docIMPrs.next()){	
			  		String clinicNumber = docIMPrs.getString("CFCLINICNUMBER");
			  		String empNumber = docIMPrs.getString("CFDOCNUMBER");
			  		 
			  		BigDecimal zzamount = docIMPrs.getBigDecimal("ZZ");
			  		BigDecimal yxjzamount = docIMPrs.getBigDecimal("YXJZ");
			  		BigDecimal gdjzamount = docIMPrs.getBigDecimal("GDJZ");
			  		BigDecimal knwamount = docIMPrs.getBigDecimal("KNW");
			  		
			  		BigDecimal xfamount = docIMPrs.getBigDecimal("XF");
			  		BigDecimal eyamount = docIMPrs.getBigDecimal("EY");
			  		BigDecimal yzamount = docIMPrs.getBigDecimal("YZ");
			  		BigDecimal mbamount = docIMPrs.getBigDecimal("MB");
			  		BigDecimal jzamount = docIMPrs.getBigDecimal("JZ");
			  		map.put(empNumber+"_"+clinicNumber+"_ZZ_DOC_IMP_ACHIEVE", zzamount); 
			  		map.put(empNumber+"_"+clinicNumber+"_YX_DOC_IMP_ACHIEVE", yxjzamount); 
			  		map.put(empNumber+"_"+clinicNumber+"_GD_DOC_IMP_ACHIEVE", gdjzamount); 
			  		map.put(empNumber+"_"+clinicNumber+"_KNW_DOC_IMP_ACHIEVE", knwamount); 
			  		map.put(empNumber+"_"+clinicNumber+"_XF_DOC_IMP_ACHIEVE", xfamount); 
			  		map.put(empNumber+"_"+clinicNumber+"_EY_DOC_IMP_ACHIEVE", eyamount); 
			  		map.put(empNumber+"_"+clinicNumber+"_YZ_DOC_IMP_ACHIEVE", yzamount); 
			  		map.put(empNumber+"_"+clinicNumber+"_MB_DOC_IMP_ACHIEVE", mbamount); 
			  		map.put(empNumber+"_"+clinicNumber+"_JZ_DOC_IMP_ACHIEVE", jzamount); 
			  	}
		  	} 
		  	
		  	//医生导入成本
		  	StringBuffer sqlCBImp= new StringBuffer(); 
		  	sqlCBImp.append(" /*dialect*/select ( nvl(sum(cfzjcost),0) ) as summ,'zz' as type ,cfempNumber,cfMZNUMBER  FROM  CT_PAY_DoctorCosts  where CFBUSINESSDATE ='"+periodnum+"'   and cfcityid='"+cityId+"'  and (cfiszidai is null or cfiszidai = 0) group by cfempNumber,cfMZNUMBER ").append("\r\n")
		  	.append(" union select ( nvl(sum(cfyxcost),0) ) as summ,'yxjz' as type,cfempNumber,cfMZNUMBER   FROM CT_PAY_DoctorCosts  where CFBUSINESSDATE ='"+periodnum+"'    and cfcityid='"+cityId+"' and (cfiszidai is null or cfiszidai = 0) group by cfempNumber,cfMZNUMBER ").append("\r\n")
			.append(" union select ( nvl(sum(cfgdcost),0) ) as summ,'gdjz' as type,cfempNumber,cfMZNUMBER   FROM CT_PAY_DoctorCosts  where CFBUSINESSDATE ='"+periodnum+"'  and cfcityid='"+cityId+"' and (cfiszidai is null or cfiszidai = 0) group by cfempNumber,cfMZNUMBER  ").append("\r\n")
			.append(" union select ( nvl(sum(cfkncost),0)) as summ,'knw' as type,cfempNumber,cfMZNUMBER   FROM CT_PAY_DoctorCosts  where CFBUSINESSDATE ='"+periodnum+"'  and cfcityid='"+cityId+"'   and (cfiszidai is null or cfiszidai = 0)  group by cfempNumber,cfMZNUMBER  ").append("\r\n")
			.append(" union select ( nvl(sum(cfxfcost),0) ) as summ,'xf' as type,cfempNumber,cfMZNUMBER   FROM CT_PAY_DoctorCosts  where CFBUSINESSDATE ='"+periodnum+"' and cfcityid='"+cityId+"'  and (cfiszidai is null or cfiszidai = 0) group by cfempNumber,cfMZNUMBER  ").append("\r\n")
			.append(" union select ( nvl(sum(cfeycost),0)) as summ,'ey' as type ,cfempNumber,cfMZNUMBER  FROM CT_PAY_DoctorCosts  where CFBUSINESSDATE ='"+periodnum+"'   and cfcityid='"+cityId+"'  and (cfiszidai is null or cfiszidai = 0) group by cfempNumber,cfMZNUMBER   ").append("\r\n")
			.append(" union select ( nvl(sum(cfzbcost),0)) as summ,'yz' as type ,cfempNumber,cfMZNUMBER  FROM CT_PAY_DoctorCosts  where CFBUSINESSDATE ='"+periodnum+"'  and cfcityid='"+cityId+"'  and (cfiszidai is null or cfiszidai = 0) group by cfempNumber,cfMZNUMBER  ").append("\r\n")
			.append(" union select ( nvl(sum(cfmbcost),0)) as summ,'mb' as type,cfempNumber,cfMZNUMBER  FROM CT_PAY_DoctorCosts  where CFBUSINESSDATE ='"+periodnum+"'  and cfcityid='"+cityId+"'   and (cfiszidai is null or cfiszidai = 0)  group by cfempNumber,cfMZNUMBER ").append("\r\n");
		  	IRowSet docCBIMPrs = com.kingdee.eas.custom.util.DBUtil.executeQuery(ctx,sqlCBImp);
		  	if(docCBIMPrs!=null && docCBIMPrs.size() > 0){ 
		  		while(docCBIMPrs.next()){
		  			String clinicNumber = docCBIMPrs.getString("CFMZNUMBER");
			  		String empNumber = docCBIMPrs.getString("CFEMPNUMBER");
			  		String thistype = docCBIMPrs.getString("TYPE");
			  		BigDecimal amount = docCBIMPrs.getBigDecimal("SUMM");
			  		map.put(empNumber+"_"+clinicNumber+"_"+thistype+"_DOC_IMP_CB", amount); 
		  		}
		  	}
			
		  	//护士长调整成本
		  	StringBuffer sqlCBHSZ= new StringBuffer(); 
		  	sqlCBHSZ.append(" /*dialect*/ select ( nvl(sum(cfxhzz),0) +nvl(sum(cfjgfzz),0)) as summ,'zz' as type ,cfdoctornumber, cfclinicnumber  from  CT_PAY_CostByUpdate  where cfperiod = '"+periodnum+"' and cfcitynumber='"+cityNumber+"' and (cfiszidai is null or cfiszidai = 0) group by cfdoctornumber, cfclinicnumber   union ").append("\r\n")
			.append(" 	select ( nvl(sum(cfxhyxjz),0) +nvl(sum(cfjgfyxjz),0)) as summ,'yxjz' as type,cfdoctornumber, cfclinicnumber   from  CT_PAY_CostByUpdate  where cfperiod = '"+periodnum+"' and cfcitynumber='"+cityNumber+"'  and (cfiszidai is null or cfiszidai = 0) group by cfdoctornumber, cfclinicnumber  union ").append("\r\n")
			.append(" 	select ( nvl(sum(cfxhcgjz),0) +nvl(sum(cfjgfcgjz),0)) as summ,'gdjz' as type,cfdoctornumber, cfclinicnumber   from  CT_PAY_CostByUpdate  where cfperiod = '"+periodnum+"' and cfcitynumber='"+cityNumber+"'  and (cfiszidai is null or cfiszidai = 0) group by cfdoctornumber, cfclinicnumber   union ").append("\r\n")
			.append(" 	select ( nvl(sum(cfxhknw),0) +nvl(sum(cfjgfknw),0)) as summ,'knw' as type,cfdoctornumber, cfclinicnumber   from  CT_PAY_CostByUpdate  where cfperiod = '"+periodnum+"'and cfcitynumber='"+cityNumber+"' and (cfiszidai is null or cfiszidai = 0) group by cfdoctornumber, cfclinicnumber   union ").append("\r\n")
			.append(" 	select ( nvl(sum(cfxhxf),0) +nvl(sum(cfjgfxf),0)) as summ,'xf' as type,cfdoctornumber, cfclinicnumber   from  CT_PAY_CostByUpdate  where cfperiod = '"+periodnum+"' and cfcitynumber='"+cityNumber+"' and (cfiszidai is null or cfiszidai = 0) group by cfdoctornumber, cfclinicnumber  union ").append("\r\n")
			.append(" 	select ( nvl(sum(cfxhey),0) +nvl(sum(cfjgfey),0)) as summ,'ey' as type,cfdoctornumber, cfclinicnumber   from  CT_PAY_CostByUpdate  where cfperiod = '"+periodnum+"' and cfcitynumber='"+cityNumber+"' and (cfiszidai is null or cfiszidai = 0) group by cfdoctornumber, cfclinicnumber  union ").append("\r\n")
			.append(" 	select ( nvl(sum(cfxhyz),0) +nvl(sum(cfjgfyz),0)) as summ,'yz' as type,cfdoctornumber, cfclinicnumber   from  CT_PAY_CostByUpdate  where cfperiod = '"+periodnum+"' and cfcitynumber='"+cityNumber+"' and (cfiszidai is null or cfiszidai = 0) group by cfdoctornumber, cfclinicnumber  union ").append("\r\n")
			.append(" 	select ( nvl(sum(cfjgfmb),0) +nvl(sum(cfxhmb),0) ) as summ,'mb' as type,cfdoctornumber, cfclinicnumber   from  CT_PAY_CostByUpdate  where cfperiod = '"+periodnum+"' and cfcitynumber='"+cityNumber+"'  and (cfiszidai is null or cfiszidai = 0) group by cfdoctornumber, cfclinicnumber   ");
			IRowSet docCBHSZrs = com.kingdee.eas.custom.util.DBUtil.executeQuery(ctx,sqlCBHSZ);
		  	if(docCBHSZrs!=null && docCBHSZrs.size() > 0){ 
		  		while(docCBHSZrs.next()){
		  			String clinicNumber = docCBHSZrs.getString("CFCLINICNUMBER");
			  		String empNumber = docCBHSZrs.getString("CFDOCTORNUMBER");
			  		String thistype = docCBHSZrs.getString("TYPE");
			  		BigDecimal amount = docCBHSZrs.getBigDecimal("SUMM");
			  		map.put(empNumber+"_"+clinicNumber+"_"+thistype+"_DOC_HSZ_CB", amount); 
		  		}
		  	}
			//销售出库调整成本
		  	StringBuffer sqlCBXSCK= new StringBuffer(); 
		  	sqlCBXSCK.append(" /*dialect*/select ( nvl(sum(cfxhzz),0) +nvl(sum(cfjgfzz),0)) as summ,'zz' as type ,cfdoctornumber,cfclinicnumber from  CT_PAY_CostSum where cfperiod = '"+periodnum+"' and cfcitynumber='"+cityNumber+"'group by cfdoctornumber,cfclinicnumber  union ").append("\r\n")
		  	.append(" 	select ( nvl(sum(cfxhyxjz),0) +nvl(sum(cfjgfyxjz),0)) as summ,'yxjz' as type ,cfdoctornumber,cfclinicnumber  from  CT_PAY_CostSum where cfperiod = '"+periodnum+"' and cfcitynumber='"+cityNumber+"'  group by cfdoctornumber,cfclinicnumber   union ").append("\r\n")
			.append(" 	select ( nvl(sum(cfxhcgjz),0) +nvl(sum(cfjgfcgjz),0)) as summ,'gdjz' as type ,cfdoctornumber,cfclinicnumber  from  CT_PAY_CostSum where cfperiod = '"+periodnum+"'  and cfcitynumber='"+cityNumber+"' group by cfdoctornumber,cfclinicnumber    union ").append("\r\n")
			.append(" 	select ( nvl(sum(cfxhknw),0) +nvl(sum(cfjgfknw),0)) as summ,'knw' as type ,cfdoctornumber,cfclinicnumber  from  CT_PAY_CostSum where cfperiod = '"+periodnum+"'  and cfcitynumber='"+cityNumber+"'  group by cfdoctornumber,cfclinicnumber   union ").append("\r\n")
			.append(" 	select ( nvl(sum(cfxhxf),0) +nvl(sum(cfjgfxf),0)) as summ,'xf' as type ,cfdoctornumber,cfclinicnumber  from  CT_PAY_CostSum where cfperiod = '"+periodnum+"'   and cfcitynumber='"+cityNumber+"' group by cfdoctornumber,cfclinicnumber   union ").append("\r\n")
			.append(" 	select ( nvl(sum(cfxhey),0) +nvl(sum(cfjgfey),0)) as summ,'ey' as type ,cfdoctornumber,cfclinicnumber  from  CT_PAY_CostSum where cfperiod = '"+periodnum+"' and cfcitynumber='"+cityNumber+"' group by cfdoctornumber,cfclinicnumber   union ").append("\r\n")
			.append(" 	select ( nvl(sum(cfxhyz),0) +nvl(sum(cfjgfyz),0)) as summ,'yz' as type ,cfdoctornumber,cfclinicnumber  from  CT_PAY_CostSum where cfperiod = '"+periodnum+"'  and cfcitynumber='"+cityNumber+"'   group by cfdoctornumber,cfclinicnumber  union ").append("\r\n")
			.append(" 	select ( nvl(sum(cfjgfmb),0) +nvl(sum(cfxhmb),0) ) as summ,'mb' as type ,cfdoctornumber,cfclinicnumber  from  CT_PAY_CostSum where cfperiod = '"+periodnum+"'  and cfcitynumber='"+cityNumber+"' group by cfdoctornumber,cfclinicnumber    ");
		  	IRowSet docCBXDCKrs = com.kingdee.eas.custom.util.DBUtil.executeQuery(ctx,sqlCBXSCK);
		  	if(docCBXDCKrs!=null && docCBXDCKrs.size() > 0){ 
		  		while(docCBXDCKrs.next()){
		  			String clinicNumber = docCBXDCKrs.getString("CFCLINICNUMBER");
			  		String empNumber = docCBXDCKrs.getString("CFDOCTORNUMBER");
			  		String thistype = docCBXDCKrs.getString("TYPE");
			  		BigDecimal amount = docCBXDCKrs.getBigDecimal("SUMM");
			  		map.put(empNumber+"_"+clinicNumber+"_"+thistype+"_DOC_XSCK_CB", amount); 
		  		}
		  	}  
		  	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   
		
		 
		return map;
	}


	private HashMap<String, BigDecimal> getOtherDocAchieveMessage(Context ctx, String periodnum,String cityId,HashMap tongyongmap 
			,String type,String incityNumStr,String  cityNumber,HashMap<String,String> oneItemMap,HashMap<String,String>  twoItemMap,HashMap<String,String>  threeItemMap){  
		// TODO Auto-generated method stub
		HashMap<String, BigDecimal> map = new  HashMap<String, BigDecimal>();
		//种植
		String zzOneItem = "''"; if(oneItemMap.get("ZZ")!= null)    zzOneItem = oneItemMap.get("ZZ");
		String zzTwoItem = "''"; if(twoItemMap.get("ZZ")!= null)    zzTwoItem = twoItemMap.get("ZZ");
		String zzThreeItem = "''"; if(threeItemMap.get("ZZ")!= null)  zzThreeItem = threeItemMap.get("ZZ");
		//正畸
		String zjOneItem = "''"; if(oneItemMap.get("ZJ")!= null)    zjOneItem = oneItemMap.get("ZJ");
		String zjTwoItem = "''"; if(twoItemMap.get("ZJ")!= null)    zjTwoItem = twoItemMap.get("ZJ");
		String zjThreeItem = "''"; if(threeItemMap.get("ZJ")!= null)  zjThreeItem = threeItemMap.get("ZJ");
		//固定 
		String gdOneItem = "''"; if(oneItemMap.get("GD")!= null)    gdOneItem = oneItemMap.get("GD");
		String gdTwoItem = "''"; if(twoItemMap.get("GD")!= null)    gdTwoItem = twoItemMap.get("GD");
		String gdThreeItem = "''"; if(threeItemMap.get("GD")!= null)  gdThreeItem = threeItemMap.get("GD");
		//隐形
		String yxOneItem = "''"; if(oneItemMap.get("YX")!= null)    yxOneItem = oneItemMap.get("YX");
		String yxTwoItem = "''"; if(twoItemMap.get("YX")!= null)    yxTwoItem = twoItemMap.get("YX");
		String yxThreeItem = "''"; if(threeItemMap.get("YX")!= null)  yxThreeItem = threeItemMap.get("YX");
		
		//修复
		String xfOneItem = "''"; if(oneItemMap.get("XF")!= null)    xfOneItem = oneItemMap.get("XF");
		String xfTwoItem = "''"; if(twoItemMap.get("XF")!= null)    xfTwoItem = twoItemMap.get("XF");
		String xfThreeItem = "''"; if(threeItemMap.get("XF")!= null)  xfThreeItem = threeItemMap.get("XF");
		//儿牙
		String eyOneItem = "''"; if(oneItemMap.get("EY")!= null)    eyOneItem = oneItemMap.get("EY");
		String eyTwoItem = "''"; if(twoItemMap.get("EY")!= null)    eyTwoItem = twoItemMap.get("EY");
		String eyThreeItem = "''"; if(threeItemMap.get("EY")!= null)  eyThreeItem = threeItemMap.get("EY");
		//口内外
		String knwOneItem = "''"; if(oneItemMap.get("KNW")!= null)    knwOneItem = oneItemMap.get("KNW");
		String knwTwoItem = "''"; if(twoItemMap.get("KNW")!= null)    knwTwoItem = twoItemMap.get("KNW");
		String knwThreeItem = "''"; if(threeItemMap.get("KNW")!= null)  knwThreeItem = threeItemMap.get("KNW");
		//牙周
		String yzOneItem = "''"; if(oneItemMap.get("YZ")!= null)    yzOneItem = oneItemMap.get("YZ");
		String yzTwoItem = "''"; if(twoItemMap.get("YZ")!= null)    yzTwoItem = twoItemMap.get("YZ");
		String yzThreeItem = "''"; if(threeItemMap.get("YZ")!= null)  yzThreeItem = threeItemMap.get("YZ");
		//美白
		String mbOneItem = "''"; if(oneItemMap.get("MB")!= null)    mbOneItem = oneItemMap.get("MB");
		String mbTwoItem = "''"; if(twoItemMap.get("MB")!= null)    mbTwoItem = twoItemMap.get("MB");
		String mbThreeItem = "''"; if(threeItemMap.get("MB")!= null)  mbThreeItem = threeItemMap.get("MB");

 
    	//免工作量比例
		BigDecimal freeWorkPro = BigDecimal.ZERO;  
		//赠金比例
		BigDecimal gifAmountPro = BigDecimal.ZERO;  
		  
		String dateSql = "";
		if(type.equals("ZC")){
			dateSql = "  to_char(fbizdate, 'yyyymm') = '"+periodnum+"' and  ";
		}else if(type.equals("CBQR")){
			dateSql = "  CFBUSINESSDATE = '"+periodnum+"' and  (cfisneedout = 0 or ( cfisneedout=1 and cfisout = 1))  and  ";
		}
			
		try {
//			//医生总业绩
//			StringBuffer sqlYJ = new StringBuffer(); 
//			//种植免工作量业绩 
//			sqlYJ.append(" /*dialect*/select sum(a.amount)  as allachieve  , a.cfrecdotnumber from ( ").append("\r\n")
//			//种植非免工作量业绩
//			.append("   select (nvl(sum(cfdocachieve),0))  as amount , cfrecdotnumber  from  CT_PAY_AchieveDetailTem  where  "+dateSql+" (cfincome!=0 or cfpayment!=0)   and cfiscount= 1  and cfcitynumber "+incityNumStr+" and cfrecdotnumber is not null  ").append("\r\n")
//			.append("  and  ( cffirclassnumber in  ("+zzOneItem+") or cfsecclassnumber in ("+zzTwoItem+") or cffeeitemdetailnumber in  ("+zzThreeItem+")  )GROUP BY cfrecdotnumber ").append("\r\n")
//			//隐形非免工作量业绩
//			.append(" union  select (nvl(sum(cfdocachieve),0))  as amount, cfrecdotnumber  from  CT_PAY_AchieveDetailTem  where  "+dateSql+"  (cfincome!=0 or cfpayment!=0) and cffirclassNumber ='4' and CFISROUTINE = '否'  and cfiscount= 1 and cfcitynumber "+incityNumStr+" and cfrecdotnumber is not null  ").append("\r\n")
//			 .append("  and  ( cffirclassnumber in  ("+zjOneItem+") or cfsecclassnumber in ("+zjTwoItem+") or cffeeitemdetailnumber in  ("+zjThreeItem+")  )GROUP BY cfrecdotnumber  ").append("\r\n")
//			//常规非免工作量业绩
//			.append(" union   select (nvl(sum(cfdocachieve),0))  as amount, cfrecdotnumber  from  CT_PAY_AchieveDetailTem  where   "+dateSql+" (cfincome!=0 or cfpayment!=0) and cffirclassNumber ='4' and CFISROUTINE = '是'  and cfiscount= 1  and cfcitynumber "+incityNumStr+" and cfrecdotnumber is not null ").append("\r\n")
//			.append("  and  ( cffirclassnumber in  ("+zjOneItem+") or cfsecclassnumber in ("+zjTwoItem+") or cffeeitemdetailnumber in  ("+zjThreeItem+") ) GROUP BY cfrecdotnumber ").append("\r\n")
//			//口内外非免工作量业绩
//			.append(" union  select (nvl(sum(cfdocachieve),0))  as amount, cfrecdotnumber  from  CT_PAY_AchieveDetailTem  where  "+dateSql+"  (cfincome!=0 or cfpayment!=0) and cffirclassNumber ='1'  and cfiscount= 1 and cfcitynumber "+incityNumStr+" and cfrecdotnumber is not null   ").append("\r\n")
//			 .append("  and  ( cffirclassnumber in  ("+knwOneItem+") or cfsecclassnumber in ("+knwTwoItem+") or cffeeitemdetailnumber in  ("+knwThreeItem+")  )GROUP BY cfrecdotnumber ").append("\r\n")
//			//儿牙非免工作量业绩
//			.append(" union  select (nvl(sum(cfdocachieve),0))  as amount , cfrecdotnumber from  CT_PAY_AchieveDetailTem  where "+dateSql+"  (cfincome!=0 or cfpayment!=0) and cffirclassNumber ='6'  and cfiscount= 1 and cfcitynumber "+incityNumStr+" and cfrecdotnumber is not null   ").append("\r\n")
//			.append("  and  ( cffirclassnumber in  ("+eyOneItem+") or cfsecclassnumber in ("+eyTwoItem+") or cffeeitemdetailnumber in  ("+eyThreeItem+") ) GROUP BY cfrecdotnumber ").append("\r\n")
//			//修复非免工作量业绩
//			.append(" union  select (nvl(sum(cfdocachieve),0))  as amount, cfrecdotnumber  from  CT_PAY_AchieveDetailTem  where  "+dateSql+"  (cfincome!=0 or cfpayment!=0) and cffirclassNumber ='2'  and cfiscount= 1 and cfcitynumber "+incityNumStr+" and cfrecdotnumber is not null ").append("\r\n")
//			.append("  and  ( cffirclassnumber in  ("+xfOneItem+") or cfsecclassnumber in ("+xfTwoItem+") or cffeeitemdetailnumber in  ("+xfThreeItem+")  ) GROUP BY cfrecdotnumber ").append("\r\n")
//			//导入业绩
//			.append(" union SELECT  nvl( sum(cfzzachieve),0)+nvl(sum(cfyxjzachieve),0)+nvl(sum(cfgdjzachieve),0)+nvl(sum(cfknwachieve),0)+nvl(sum(cfxfachieve),0)+nvl(sum(cfeyachieve),0)   as   amount, cfdocnumber cfrecdotnumber FROM  CT_PAY_DocAchieveUpdate where cfcityid = '"+cityId+"' and  cfbusinessdate = '"+periodnum+"'  and ( cfiszidai = 0 or cfiszidai is null) and  fname_l2 is null and cfdocnumber is not null   GROUP BY cfdocnumber   ) a   GROUP BY cfrecdotnumber "); 
//			
//			System.out.println("--"+sqlYJ.toString());
//			
//			IRowSet yjrs = com.kingdee.eas.custom.util.DBUtil.executeQuery(ctx,sqlYJ.toString());
//			if(yjrs!=null && yjrs.size() > 0){ 
//				while(yjrs.next()){	
//					BigDecimal allachieve =  new BigDecimal(yjrs.getString("ALLACHIEVE"));
//					String empNumber =  yjrs.getString("CFRECDOTNUMBER") ;
//					map.put(empNumber+"_DOC_ALL_ACHIEVE", allachieve);
//				}
//			}
			  
			 
			
			//医生系统业绩
			StringBuffer sqlDocXt= new StringBuffer(); 
			//种植 
			sqlDocXt.append("  /*dialect*/select sum(amount) as sumamount , 'zz' as type,cfrecdotnumber from ( select  (nvl(sum(cfdocachieve),0)) as amount,cfrecdotnumber  from  CT_PAY_AchieveDetailTem  where "+dateSql+"  cfcitynumber "+incityNumStr+" and   cfrecdotnumber is not null ").append("\r\n")
			.append("  and  ( cffirclassnumber in  ("+zzOneItem+") or cfsecclassnumber in ("+zzTwoItem+") or cffeeitemdetailnumber in  ("+zzThreeItem+") )group by cfrecdotnumber ) group by cfrecdotnumber  ").append("\r\n")
		 
			//常规  
			.append(" union select sum(amount) as sumamount , 'gd' as type,cfrecdotnumber from ( select  (nvl(sum(cfdocachieve),0)) as amount ,cfrecdotnumber from  CT_PAY_AchieveDetailTem  where "+dateSql+"  cfcitynumber "+incityNumStr+"   and CFISROUTINE = '是'   and cfrecdotnumber is not null ").append("\r\n")
			.append(" and   not exists ( SELECT 1 FROM  CT_SRQ_ClinicItem clinicItem left join  CT_SRQ_ClinicItemEntry  entry  on clinicItem.fid = entry.fparentid  left join CT_SRQ_PayItem payItem on payItem.fid = entry.cfitemid  where clinicItem.cfcityid = '"+cityId+"' and  clinicItem.cfproject = '口内外正畸' and   CT_PAY_AchieveDetailTem.CFFeeItemDetailNumber = payItem.fnumber) ").append("\r\n")
			.append("  and  ( cffirclassnumber in  ("+gdOneItem+") or cfsecclassnumber in ("+gdTwoItem+") or cffeeitemdetailnumber in  ("+gdThreeItem+") ) group by cfrecdotnumber ) group by cfrecdotnumber ").append("\r\n")
			 
			//隐形 
			.append(" union select sum(amount) as sumamount , 'yx' as type,cfrecdotnumber from ( select  (nvl(sum(cfdocachieve),0)) as amount,cfrecdotnumber  from  CT_PAY_AchieveDetailTem  where "+dateSql+"  cfcitynumber "+incityNumStr+" and CFISROUTINE = '否'  and cfrecdotnumber is not null ").append("\r\n")
			.append(" and   not exists ( SELECT 1 FROM  CT_SRQ_ClinicItem clinicItem left join  CT_SRQ_ClinicItemEntry  entry  on clinicItem.fid = entry.fparentid  left join CT_SRQ_PayItem payItem on payItem.fid = entry.cfitemid  where clinicItem.cfcityid = '"+cityId+"' and  clinicItem.cfproject = '口内外正畸' and   CT_PAY_AchieveDetailTem.CFFeeItemDetailNumber = payItem.fnumber) ").append("\r\n")
			.append("  and  ( cffirclassnumber in  ("+yxOneItem+") or cfsecclassnumber in ("+yxTwoItem+") or cffeeitemdetailnumber in  ("+yxThreeItem+") ) group by cfrecdotnumber ) group by cfrecdotnumber ").append("\r\n")
			//口内外
			.append(" union select sum(amount) as sumamount , 'knw' as type,cfrecdotnumber from ( select (nvl(sum(cfdocachieve),0)) as amount ,cfrecdotnumber from  CT_PAY_AchieveDetailTem  where "+dateSql+"  cfcitynumber "+incityNumStr+"  and cfrecdotnumber is not null ").append("\r\n")
			.append(" and ( exists ( SELECT 1 FROM  CT_SRQ_ClinicItem clinicItem left join  CT_SRQ_ClinicItemEntry  entry  on clinicItem.fid = entry.fparentid  left join CT_SRQ_PayItem payItem on payItem.fid = entry.cfitemid  where clinicItem.cfcityid = '"+cityId+"' and  clinicItem.cfproject = '口内外' and   CT_PAY_AchieveDetailTem.CFFeeItemDetailNumber = payItem.fnumber) ").append("\r\n")
			.append(" or   cffirclassnumber in  ("+knwOneItem+") or cfsecclassnumber in ("+knwTwoItem+") or cffeeitemdetailnumber in  ("+knwThreeItem+") ) group by cfrecdotnumber ) group by cfrecdotnumber ") .append("\r\n")
			 
			//儿牙
			.append(" union select sum(amount) as sumamount , 'ey' as type,cfrecdotnumber from ( select (nvl(sum(cfdocachieve),0))as amount,cfrecdotnumber  from  CT_PAY_AchieveDetailTem  where "+dateSql+"  cfcitynumber "+incityNumStr+"  and cfrecdotnumber is not null ").append("\r\n")
			.append("  and  ( cffirclassnumber in  ("+eyOneItem+") or cfsecclassnumber in ("+eyTwoItem+") or cffeeitemdetailnumber in  ("+eyThreeItem+") ) group by cfrecdotnumber ) group by cfrecdotnumber  ") .append("\r\n")
		
			//修复
			.append(" union select sum(amount) as sumamount , 'xf' as type,cfrecdotnumber from ( select (nvl(sum(cfdocachieve),0)) as amount ,cfrecdotnumber from  CT_PAY_AchieveDetailTem  where "+dateSql+"  cfcitynumber "+incityNumStr+" and cfrecdotnumber is not null ").append("\r\n")
			.append("  and  ( cffirclassnumber in  ("+xfOneItem+") or cfsecclassnumber in ("+xfTwoItem+") or cffeeitemdetailnumber in  ("+xfThreeItem+") ) group by cfrecdotnumber ) group by cfrecdotnumber  ") .append("\r\n")
			
			//牙周
			.append(" union  select sum(amount) as sumamount , 'yz' as type,cfrecdotnumber from ( select  (nvl(sum(cfdocachieve),0)) as amount ,cfrecdotnumber from  CT_PAY_AchieveDetailTem  where "+dateSql+"  cfcitynumber "+incityNumStr+"  and cfrecdotnumber is not null ").append("\r\n")
			.append("  and  ( cffirclassnumber in  ("+yzOneItem+") or cfsecclassnumber in ("+yzTwoItem+") or cffeeitemdetailnumber in  ("+yzThreeItem+") ) group by cfrecdotnumber )group by cfrecdotnumber   ").append("\r\n")
		    
			//美白
			.append(" union  select sum(amount) as sumamount , 'mb' as type,cfrecdotnumber from ( select  (nvl(sum(cfdocachieve),0)) as amount ,cfrecdotnumber from  CT_PAY_AchieveDetailTem  where "+dateSql+"  cfcitynumber "+incityNumStr+"  and cfrecdotnumber is not null ").append("\r\n")
			.append("  and  ( cffirclassnumber in  ("+mbOneItem+") or cfsecclassnumber in ("+mbTwoItem+") or cffeeitemdetailnumber in  ("+mbThreeItem+") ) group by cfrecdotnumber )group by cfrecdotnumber   ").append("\r\n")
		  
			//正畸
			.append(" union  select sum(amount) as sumamount , 'zj' as type,cfrecdotnumber from ( select  (nvl(sum(cfdocachieve),0)) as amount ,cfrecdotnumber from  CT_PAY_AchieveDetailTem  where "+dateSql+"  cfcitynumber "+incityNumStr+"  and cfrecdotnumber is not null ").append("\r\n")
			.append("  and  ( cffirclassnumber in  ("+zjOneItem+") or cfsecclassnumber in ("+zjTwoItem+") or cffeeitemdetailnumber in  ("+zjThreeItem+") ) group by cfrecdotnumber )group by cfrecdotnumber   ").append("\r\n");
			
			IRowSet docXTrs = com.kingdee.eas.custom.util.DBUtil.executeQuery(ctx,sqlDocXt);
		  	if(docXTrs!=null && docXTrs.size() > 0){ 
			  	while(docXTrs.next()){	 
			  		String empNumber = docXTrs.getString("CFRECDOTNUMBER");
			  		String thistype = docXTrs.getString("TYPE");
			  		BigDecimal amount = docXTrs.getBigDecimal("SUMAMOUNT");
			  		map.put(empNumber+"_"+thistype+"_DOC_XT_ACHIEVE", amount); 
			  	}
			}
		  	
		  	//医生导入业绩
		  	StringBuffer sqlDocImp= new StringBuffer(); 
		  	sqlDocImp.append("  /*dialect*/ SELECT cfdocnumber ,nvl( sum(cfzzachieve),0) as ZZ , nvl(sum(cfyxjzachieve),0) as YXJZ , nvl(sum(cfgdjzachieve),0) as GDJZ , nvl(sum(cfknwachieve),0) as KNW , nvl(sum(cfxfachieve),0) as XF , nvl(sum(cfeyachieve),0) as EY , nvl(sum(cfyzachieve),0) as YZ , nvl(sum(cfmbachieve),0) as MB , nvl(sum(cfjzmoney),0) as JZ   ").append("\r\n")
			.append(" FROM  CT_PAY_DocAchieveUpdate where cfcityid = '"+cityId+"'   and  cfbusinessdate = '"+periodnum+"' and ( cfiszidai = 0 or cfiszidai is null)   and  fname_l2 is null  group  by cfdocnumber  ");
		  	IRowSet docIMPrs = com.kingdee.eas.custom.util.DBUtil.executeQuery(ctx,sqlDocImp);
		  	if(docIMPrs!=null && docIMPrs.size() > 0){ 
			  	while(docIMPrs.next()){	 
			  		String empNumber = docIMPrs.getString("CFDOCNUMBER");
			  		 
			  		BigDecimal zzamount = docIMPrs.getBigDecimal("ZZ");
			  		BigDecimal yxjzamount = docIMPrs.getBigDecimal("YXJZ");
			  		BigDecimal gdjzamount = docIMPrs.getBigDecimal("GDJZ");
			  		BigDecimal knwamount = docIMPrs.getBigDecimal("KNW");
			  		
			  		BigDecimal xfamount = docIMPrs.getBigDecimal("XF");
			  		BigDecimal eyamount = docIMPrs.getBigDecimal("EY");
			  		BigDecimal yzamount = docIMPrs.getBigDecimal("YZ");
			  		BigDecimal mbamount = docIMPrs.getBigDecimal("MB");
			  		BigDecimal jzamount = docIMPrs.getBigDecimal("JZ");
			  		map.put(empNumber +"_ZZ_DOC_IMP_ACHIEVE", zzamount); 
			  		map.put(empNumber +"_YX_DOC_IMP_ACHIEVE", yxjzamount); 
			  		map.put(empNumber +"_GD_DOC_IMP_ACHIEVE", gdjzamount); 
			  		map.put(empNumber +"_KNW_DOC_IMP_ACHIEVE", knwamount); 
			  		map.put(empNumber +"_XF_DOC_IMP_ACHIEVE", xfamount); 
			  		map.put(empNumber +"_EY_DOC_IMP_ACHIEVE", eyamount); 
			  		map.put(empNumber +"_YZ_DOC_IMP_ACHIEVE", yzamount); 
			  		map.put(empNumber +"_MB_DOC_IMP_ACHIEVE", mbamount); 
			  		map.put(empNumber +"_JZ_DOC_IMP_ACHIEVE", jzamount); 
			  	}
		  	} 
		  	
//		  	//医生导入成本
//		  	StringBuffer sqlCBImp= new StringBuffer(); 
//		  	sqlCBImp.append(" /*dialect*/select ( nvl(sum(cfzjcost),0) ) as summ,'zz' as type ,cfempNumber  FROM  CT_PAY_DoctorCosts  where CFBUSINESSDATE ='"+periodnum+"'   and cfcityid='"+cityId+"'  and (cfiszidai is null or cfiszidai = 0) group by cfempNumber ").append("\r\n")
//		  	.append(" union select ( nvl(sum(cfyxcost),0) ) as summ,'yxjz' as type,cfempNumber   FROM CT_PAY_DoctorCosts  where CFBUSINESSDATE ='"+periodnum+"'    and cfcityid='"+cityId+"' and (cfiszidai is null or cfiszidai = 0) group by cfempNumber ").append("\r\n")
//			.append(" union select ( nvl(sum(cfgdcost),0) ) as summ,'gdjz' as type,cfempNumber   FROM CT_PAY_DoctorCosts  where CFBUSINESSDATE ='"+periodnum+"'  and cfcityid='"+cityId+"' and (cfiszidai is null or cfiszidai = 0) group by cfempNumber  ").append("\r\n")
//			.append(" union select ( nvl(sum(cfkncost),0)) as summ,'knw' as type,cfempNumber   FROM CT_PAY_DoctorCosts  where CFBUSINESSDATE ='"+periodnum+"'  and cfcityid='"+cityId+"'   and (cfiszidai is null or cfiszidai = 0)  group by cfempNumber  ").append("\r\n")
//			.append(" union select ( nvl(sum(cfxfcost),0) ) as summ,'xf' as type,cfempNumber   FROM CT_PAY_DoctorCosts  where CFBUSINESSDATE ='"+periodnum+"' and cfcityid='"+cityId+"'  and (cfiszidai is null or cfiszidai = 0) group by cfempNumber  ").append("\r\n")
//			.append(" union select ( nvl(sum(cfeycost),0)) as summ,'ey' as type ,cfempNumber  FROM CT_PAY_DoctorCosts  where CFBUSINESSDATE ='"+periodnum+"'   and cfcityid='"+cityId+"'  and (cfiszidai is null or cfiszidai = 0) group by cfempNumber   ").append("\r\n")
//			.append(" union select ( nvl(sum(cfzbcost),0)) as summ,'yz' as type ,cfempNumber  FROM CT_PAY_DoctorCosts  where CFBUSINESSDATE ='"+periodnum+"'  and cfcityid='"+cityId+"'  and (cfiszidai is null or cfiszidai = 0) group by cfempNumber  ").append("\r\n")
//			.append(" union select ( nvl(sum(cfmbcost),0)) as summ,'mb' as type,cfempNumber  FROM CT_PAY_DoctorCosts  where CFBUSINESSDATE ='"+periodnum+"'  and cfcityid='"+cityId+"'   and (cfiszidai is null or cfiszidai = 0)  group by cfempNumber ").append("\r\n");
//		  	IRowSet docCBIMPrs = com.kingdee.eas.custom.util.DBUtil.executeQuery(ctx,sqlCBImp);
//		  	if(docCBIMPrs!=null && docCBIMPrs.size() > 0){ 
//		  		while(docCBIMPrs.next()){ 
//			  		String empNumber = docCBIMPrs.getString("CFEMPNUMBER");
//			  		String thistype = docCBIMPrs.getString("TYPE");
//			  		BigDecimal amount = docCBIMPrs.getBigDecimal("SUMM");
//			  		map.put(empNumber+"_"+thistype+"_DOC_IMP_CB", amount); 
//		  		}
//		  	}
//			
//		  	//护士长调整成本
//		  	StringBuffer sqlCBHSZ= new StringBuffer(); 
//		  	sqlCBHSZ.append(" /*dialect*/ select ( nvl(sum(cfxhzz),0) +nvl(sum(cfjgfzz),0)) as summ,'zz' as type ,cfdoctornumber  from  CT_PAY_CostByUpdate  where cfperiod = '"+periodnum+"' and cfcitynumber='"+cityNumber+"' and (cfiszidai is null or cfiszidai = 0) group by cfdoctornumber   union ").append("\r\n")
//			.append(" 	select ( nvl(sum(cfxhyxjz),0) +nvl(sum(cfjgfyxjz),0)) as summ,'yxjz' as type,cfdoctornumber   from  CT_PAY_CostByUpdate  where cfperiod = '"+periodnum+"' and cfcitynumber='"+cityNumber+"'  and (cfiszidai is null or cfiszidai = 0) group by cfdoctornumber  union ").append("\r\n")
//			.append(" 	select ( nvl(sum(cfxhcgjz),0) +nvl(sum(cfjgfcgjz),0)) as summ,'gdjz' as type,cfdoctornumber   from  CT_PAY_CostByUpdate  where cfperiod = '"+periodnum+"' and cfcitynumber='"+cityNumber+"'  and (cfiszidai is null or cfiszidai = 0) group by cfdoctornumber   union ").append("\r\n")
//			.append(" 	select ( nvl(sum(cfxhknw),0) +nvl(sum(cfjgfknw),0)) as summ,'knw' as type,cfdoctornumber   from  CT_PAY_CostByUpdate  where cfperiod = '"+periodnum+"'and cfcitynumber='"+cityNumber+"' and (cfiszidai is null or cfiszidai = 0) group by cfdoctornumber   union ").append("\r\n")
//			.append(" 	select ( nvl(sum(cfxhxf),0) +nvl(sum(cfjgfxf),0)) as summ,'xf' as type,cfdoctornumber   from  CT_PAY_CostByUpdate  where cfperiod = '"+periodnum+"' and cfcitynumber='"+cityNumber+"' and (cfiszidai is null or cfiszidai = 0) group by cfdoctornumber  union ").append("\r\n")
//			.append(" 	select ( nvl(sum(cfxhey),0) +nvl(sum(cfjgfey),0)) as summ,'ey' as type,cfdoctornumber   from  CT_PAY_CostByUpdate  where cfperiod = '"+periodnum+"' and cfcitynumber='"+cityNumber+"' and (cfiszidai is null or cfiszidai = 0) group by cfdoctornumber  union ").append("\r\n")
//			.append(" 	select ( nvl(sum(cfxhyz),0) +nvl(sum(cfjgfyz),0)) as summ,'yz' as type,cfdoctornumber   from  CT_PAY_CostByUpdate  where cfperiod = '"+periodnum+"' and cfcitynumber='"+cityNumber+"' and (cfiszidai is null or cfiszidai = 0) group by cfdoctornumber  union ").append("\r\n")
//			.append(" 	select ( nvl(sum(cfjgfmb),0) +nvl(sum(cfxhmb),0) ) as summ,'mb' as type,cfdoctornumber   from  CT_PAY_CostByUpdate  where cfperiod = '"+periodnum+"' and cfcitynumber='"+cityNumber+"'  and (cfiszidai is null or cfiszidai = 0) group by cfdoctornumber   ");
//			IRowSet docCBHSZrs = com.kingdee.eas.custom.util.DBUtil.executeQuery(ctx,sqlCBHSZ);
//		  	if(docCBHSZrs!=null && docCBHSZrs.size() > 0){ 
//		  		while(docCBHSZrs.next()){
//			  		String empNumber = docCBHSZrs.getString("CFDOCTORNUMBER");
//			  		String thistype = docCBHSZrs.getString("TYPE");
//			  		BigDecimal amount = docCBHSZrs.getBigDecimal("SUMM");
//			  		map.put(empNumber+"_"+thistype+"_DOC_HSZ_CB", amount); 
//		  		}
//		  	}
//			//销售出库调整成本
//		  	StringBuffer sqlCBXSCK= new StringBuffer(); 
//		  	sqlCBXSCK.append(" /*dialect*/select ( nvl(sum(cfxhzz),0) +nvl(sum(cfjgfzz),0)) as summ,'zz' as type ,cfdoctornumber,cfclinicnumber from  CT_PAY_CostSum where cfperiod = '"+periodnum+"' and cfcitynumber='"+cityNumber+"'group by cfdoctornumber,cfclinicnumber  union ").append("\r\n")
//		  	.append(" 	select ( nvl(sum(cfxhyxjz),0) +nvl(sum(cfjgfyxjz),0)) as summ,'yxjz' as type ,cfdoctornumber,cfclinicnumber  from  CT_PAY_CostSum where cfperiod = '"+periodnum+"' and cfcitynumber='"+cityNumber+"'  group by cfdoctornumber,cfclinicnumber   union ").append("\r\n")
//			.append(" 	select ( nvl(sum(cfxhcgjz),0) +nvl(sum(cfjgfcgjz),0)) as summ,'gdjz' as type ,cfdoctornumber,cfclinicnumber  from  CT_PAY_CostSum where cfperiod = '"+periodnum+"'  and cfcitynumber='"+cityNumber+"' group by cfdoctornumber,cfclinicnumber    union ").append("\r\n")
//			.append(" 	select ( nvl(sum(cfxhknw),0) +nvl(sum(cfjgfknw),0)) as summ,'knw' as type ,cfdoctornumber,cfclinicnumber  from  CT_PAY_CostSum where cfperiod = '"+periodnum+"'  and cfcitynumber='"+cityNumber+"'  group by cfdoctornumber,cfclinicnumber   union ").append("\r\n")
//			.append(" 	select ( nvl(sum(cfxhxf),0) +nvl(sum(cfjgfxf),0)) as summ,'xf' as type ,cfdoctornumber,cfclinicnumber  from  CT_PAY_CostSum where cfperiod = '"+periodnum+"'   and cfcitynumber='"+cityNumber+"' group by cfdoctornumber,cfclinicnumber   union ").append("\r\n")
//			.append(" 	select ( nvl(sum(cfxhey),0) +nvl(sum(cfjgfey),0)) as summ,'ey' as type ,cfdoctornumber,cfclinicnumber  from  CT_PAY_CostSum where cfperiod = '"+periodnum+"' and cfcitynumber='"+cityNumber+"' group by cfdoctornumber,cfclinicnumber   union ").append("\r\n")
//			.append(" 	select ( nvl(sum(cfxhyz),0) +nvl(sum(cfjgfyz),0)) as summ,'yz' as type ,cfdoctornumber,cfclinicnumber  from  CT_PAY_CostSum where cfperiod = '"+periodnum+"'  and cfcitynumber='"+cityNumber+"'   group by cfdoctornumber,cfclinicnumber  union ").append("\r\n")
//			.append(" 	select ( nvl(sum(cfjgfmb),0) +nvl(sum(cfxhmb),0) ) as summ,'mb' as type ,cfdoctornumber,cfclinicnumber  from  CT_PAY_CostSum where cfperiod = '"+periodnum+"'  and cfcitynumber='"+cityNumber+"' group by cfdoctornumber,cfclinicnumber    ");
//		  	IRowSet docCBXDCKrs = com.kingdee.eas.custom.util.DBUtil.executeQuery(ctx,sqlCBXSCK);
//		  	if(docCBXDCKrs!=null && docCBXDCKrs.size() > 0){ 
//		  		while(docCBXDCKrs.next()){
//			  		String empNumber = docCBXDCKrs.getString("CFDOCTORNUMBER");
//			  		String thistype = docCBXDCKrs.getString("TYPE");
//			  		BigDecimal amount = docCBXDCKrs.getBigDecimal("SUMM");
//			  		map.put(empNumber+"_"+thistype+"_DOC_XSCK_CB", amount); 
//		  		}
//		  	}  
		  	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   
		
		 
		return map;
	}
 
	
}
