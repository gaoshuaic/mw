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
import com.kingdee.bos.util.BOSUuid;
import com.kingdee.eas.base.core.fm.ContextHelperFactory;
import com.kingdee.eas.basedata.framework.app.ParallelSqlExecutor;
import com.kingdee.eas.basedata.org.CompanyOrgUnitFactory;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.basedata.org.CtrlUnitInfo;
import com.kingdee.eas.basedata.org.OrgUnitInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.custom.EAISynTemplate;
import com.kingdee.eas.custom.util.DBUtil;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.mw.pay.AchRoyaltyRuleCollection;
import com.kingdee.eas.mw.pay.AchRoyaltyRuleFactory;
import com.kingdee.eas.mw.pay.AchRoyaltyRuleInfo;
import com.kingdee.eas.mw.pay.BudgetDateCollection;
import com.kingdee.eas.mw.pay.BudgetDateFactory;
import com.kingdee.eas.mw.pay.BudgetDateInfo;
import com.kingdee.eas.mw.pay.CityChannelCollection;
import com.kingdee.eas.mw.pay.CityChannelFactory;
import com.kingdee.eas.mw.pay.CityChannelInfo;
import com.kingdee.eas.mw.pay.ClinicMonthSumFactory;
import com.kingdee.eas.mw.pay.ClinicUpScaleCollection;
import com.kingdee.eas.mw.pay.ClinicUpScaleFactory;
import com.kingdee.eas.mw.pay.ClinicUpScaleInfo;
import com.kingdee.eas.mw.pay.ConsultStageCollection;
import com.kingdee.eas.mw.pay.ConsultStageFactory;
import com.kingdee.eas.mw.pay.ConsultStageInfo;
import com.kingdee.eas.mw.pay.ConsultantProCollection;
import com.kingdee.eas.mw.pay.ConsultantProFactory;
import com.kingdee.eas.mw.pay.ConsultantProInfo;
import com.kingdee.eas.mw.pay.DocCurrencyProCollection;
import com.kingdee.eas.mw.pay.DocCurrencyProFactory;
import com.kingdee.eas.mw.pay.DocCurrencyProInfo;
import com.kingdee.eas.mw.pay.DocStageCollection;
import com.kingdee.eas.mw.pay.DocStageFactory;
import com.kingdee.eas.mw.pay.DocStageInfo;
import com.kingdee.eas.mw.pay.DoctorPerformanceCollection;
import com.kingdee.eas.mw.pay.DoctorPerformanceFactory;
import com.kingdee.eas.mw.pay.DoctorPerformanceInfo;
import com.kingdee.eas.mw.pay.ErrorAchieveFactory;
import com.kingdee.eas.mw.pay.ErrorAchieveInfo;
import com.kingdee.eas.mw.pay.IBudgetDate;
import com.kingdee.eas.mw.pay.IDoctorPerformance;
import com.kingdee.eas.mw.pay.PartTimeDocProCollection;
import com.kingdee.eas.mw.pay.PartTimeDocProFactory;
import com.kingdee.eas.mw.pay.PartTimeDocProInfo;
import com.kingdee.eas.mw.pay.ScalingBonusCollection;
import com.kingdee.eas.mw.pay.ScalingBonusFactory;
import com.kingdee.eas.mw.pay.ScalingBonusInfo;
import com.kingdee.eas.mw.pay.WhiteProportionCollection;
import com.kingdee.eas.mw.pay.WhiteProportionFactory;
import com.kingdee.eas.mw.pay.WhiteProportionInfo;
import com.kingdee.eas.mw.pay.app.util.BaoBiaoFunction;
import com.kingdee.eas.mw.pay.app.util.PayMessage;
import com.kingdee.eas.mw.pay.app.util.SyncEHRAchieveUtil;
import com.kingdee.eas.mw.pay.app.util.TextUtil;
import com.kingdee.eas.mw.srqr.app.util.PayDocDetailService;
import com.kingdee.eas.mw.srqr.app.util.SaleIssueSyncTool;
import com.kingdee.eas.mw.srqr.app.util.SyncCostTool;
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.jdbc.rowset.IRowSet;

public class SyncDataFacadeControllerBean extends AbstractSyncDataFacadeControllerBean
{
    private static Logger logger =  Logger.getLogger("com.kingdee.eas.mw.pay.app.SyncDataFacadeControllerBean");

    
    /**
     * 同步正常计算的城市
     */
    @Override
	protected void _syncEHRAchieve(Context ctx, String businessDate)
			throws BOSException {
		// TODO Auto-generated method stub
		//super._syncEHRAchieve(ctx, businessdate); 
		// TODO Auto-generated method stub
    	TextUtil tt = new TextUtil();
    	
 
    	try {
    		HashMap<String,Object> param = new HashMap<String,Object>();
        	/*param.put("orgNumber","TEXT003");
        	param.put("orgName","测试公司003");
        	//param.put("parorgNumber","cs001");
        	param.put("parorgNumber","MS3101");
        	param.put("deptLevel","公司"); 
			tt.insertNewOrg(ctx, param);*/
    		param.put("FEMPNUMBER", "CS000001");
    		param.put("FEMPNAME", "测试01");
    		param.put("FBEGINDATE", new Date());
    		param.put("FPOSITION", "2754");
    		param.put("FORGNUMBER", "MS6301GXYY001");
    		param.put("FINDATE", new Date());
    		param.put("FEMPTYPE", "试用员工");
    		param.put("FEMILE", "123");
    		param.put("FFolkID", "汉族");
    		param.put("FIDCardNO", "131026199601070616");
    		param.put("FGender", "男");
    		//param.put("FBirthday", value);
    		
    		
    		String aa = (String) tt.insertNewPerson(ctx, param);
    		System.out.print("1111----"+aa);
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//    	try {
//
//    		CtrlUnitInfo  org = ContextHelperFactory.getLocalInstance(ctx).getCurrentUser().getCU();
//            String cityID = org.getId().toString();
//            String cityNumber = org.getNumber();
//            String cityName = org.getName();
//            if(cityNumber.equals("M")){
//            	cityID = "Yv1mDb4vQwW9pjZPUs6iVsznrtQ=";
//            	cityNumber = "MS1101"; 
//            	 
//            }   
//    		String sql = "/*dialect*/SELECT city.fnumber , max(c.fnumber) as PERIODNUM   "+
//    	    " from T_BD_SystemStatusCtrol a  "+
//    	    " inner join T_ORG_COMPANY b on  a.fcompanyid =b.fid "+
//    	    " inner join T_ORG_BaseUnit city on  city.fid =b.fparentid "+
//    	    " inner join T_BD_Period c on  a.FCurrentPeriodID =c.fid  "+
//    	    " where a.FSystemStatusID ='e45c1988-00fd-1000-e000-36b8c0a8500d02A5514C' and  a.FIsStart =1 "+
//    	    " and b.FIsSealUp = 0 and b.FIsBizUnit = 1 and to_char(b.FInvalidDate,'yyyyMMDD')='21991231' and b.fnumber like 'MS%'  and city.fnumber = '"+cityNumber+"'  group  by   city.fnumber  " ;
//    		IRowSet rs = null;
//    		try {
//    			rs =  DBUtil.executeQuery(ctx,sql);
//    			if(rs!=null && rs.size() > 0){
//    				  while(rs.next()){		 
//    					  businessDate = rs.getString("PERIODNUM"); 
//    				  }
//    			 } 
//    		} catch (BOSException e) {
//    			e.printStackTrace();
//    		} catch (java.sql.SQLException e) {
//    			e.printStackTrace();
//    		} 
//    		if(businessDate.equals("")){
//        		Calendar cal = Calendar.getInstance();
//                cal.setTime(new Date());
//                cal.add(Calendar.MONTH, -1);
//                Date date3 = cal.getTime();
//                SimpleDateFormat format3= new SimpleDateFormat("yyyyMM");
//                businessDate = format3.format(date3);    
//        	}else{
//        		String year = businessDate.substring(0, 4);
//        		String month = businessDate.substring(4, 6);
//        		
//        		if(month.equals("01")){
//        			year = (Integer.parseInt(year)-1)+"";
//        		}else{
//        			month = (Integer.parseInt(month)-1)+"";
//        			if(month.length() == 1){month = "0"+month;}
//        		}
//        		businessDate = year+month;
//        	}
//        	 
//    		
//    		
//            String count = ""; 
//            String existCity = " /*dialect*/ select  count(1) C from CT_PAY_PayCity where  cfiscreatecost = '1' and cfcityid = '"+cityID+"' " ;
//            IRowSet cityrow = DbUtil.executeQuery(ctx, existCity );
//        	while (cityrow.next()) { 
//    			count = cityrow.getString("C");  
//        	} 
//            if(!count.equals("") && !count.equals("0") ){ 
//            	 _SyncCityMessage(ctx, cityNumber, cityName); 
//            	 _createCostBuUser( ctx,  businessDate); 
//            }
//		} catch (Exception e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
	}


    /**
     * 同步需要进行成本业绩核对的城市城市
     */ 
	@Override
	protected void _SyncCostAchieve(Context ctx, String periodStr)
			throws BOSException {
		// TODO Auto-generated method stub
		//super._SyncCostAchieve(ctx, businessdate);
		try {
    		if(periodStr== null ||periodStr.equals("")|| periodStr.length() != 6){
    			Calendar cal = Calendar.getInstance();
                cal.setTime(new Date());
                cal.add(Calendar.MONTH, -1);
                Date date3 = cal.getTime();
                SimpleDateFormat format3= new SimpleDateFormat("yyyyMM");
                periodStr = format3.format(date3);   
    		} 

    		
    		HashMap<String, String> cityMap = new HashMap<String, String>();
    		String citysql = "    select orgadmin.fnumber as citynumber , paycity.cfrule as type  from  CT_PAY_PayCity  paycity left join t_org_admin orgadmin on orgadmin.fid = paycity.CFCityID   ";
    		IRowSet cityrow = DbUtil.executeQuery(ctx, citysql);
    		
			while(cityrow.next()){
				String type =  cityrow.getString("TYPE"); 
				String cityNumber = cityrow.getString("CITYNUMBER");  
				cityMap.put(cityNumber, type);
			}
    		
			
			//先查询中间库
			String midSql = ""; 
			if(periodStr.equals("111111")){
				midSql = " /*dialect*/select CITYNUMBER , CITYNAME ,PERIOD from  EAS_HIS_CITYACHIEVE where   EASSIGN = 0 and HISSIGN = 1 and  IGNORE = 0  ";
				
			}else{
				midSql = " /*dialect*/select CITYNUMBER , CITYNAME ,PERIOD from  EAS_HIS_CITYACHIEVE where PERIOD='"+periodStr+"' and EASSIGN = 0 and HISSIGN = 1 and  IGNORE = 0  ";
			}
			
			//String midSql = " /*dialect*/select CITYNUMBER , CITYNAME  from  EAS_HIS_CITYACHIEVE  ";
			List<Map<String, Object>> listMid = EAISynTemplate.query(ctx, "04",midSql); 
		    for(Map<String, Object> mapMid : listMid){
		    	String cityNumber = mapMid.get("CITYNUMBER").toString();
		    	String cityName = mapMid.get("CITYNAME").toString();
		    	String period = mapMid.get("PERIOD").toString();
		    	
		    	if(cityMap.get(cityNumber) != null ){
		    		String rule = cityMap.get(cityNumber);
		    		
		    		
		    		String includeCitySql = " SELECT billorg.fid as bcityid ,billorg.fnumber as bcitynumber , entryorg.fid as ecityid ,entryorg.fnumber  as ecitynumber  from  CT_PAY_PayCity  bill left join CT_PAY_PayCityEntry entry on bill.fid = entry.fparentid  left join   T_ORG_BaseUnit billorg on billorg.fid = bill.cfcityid "+
	          		" left join   T_ORG_BaseUnit entryorg on entryorg.fid = entry.cfincludecityid where billorg.fnumber = '"+cityNumber+"' ";
		    		IRowSet includecityrow = DbUtil.executeQuery(ctx, includeCitySql);
		    		//HashMap<String,ArrayList<String>>  incityMap = new HashMap<String,ArrayList<String>>();
		    		//ArrayList<String> cityArray = new ArrayList<String>();
		  		
		    		String incityStr = " in (";
		    		boolean flag = false;
		    		while(includecityrow.next()){
		    			String bcityid =  includecityrow.getString("BCITYID"); 
			  			String bcityNumber = includecityrow.getString("BCITYNUMBER");  
			  				
			  			String ecityid =  includecityrow.getString("ECITYID"); 
			  			String ecityNumber = includecityrow.getString("ECITYNUMBER");  
			  				
			  			//cityArray.add(ecityNumber); 
			  			incityStr = incityStr + "'"+ecityNumber+"',";
			  			flag = true;
		    		} 
		    		incityStr = incityStr.substring(0,incityStr.length()-1) + " )";
		    		
		    		/*if(rule.equals("CBQR")){
		    			
		    		}else{
		    			SyncEHRAchieveUtil.SyncAchieveRepot(ctx, businessdate, cityNumber,rule);
		    		}*/ 
		    		
		    		/*
		    		 * 全部都按照成本核对的方式进行出库    如果市成本核对的方式 查询期间字段，如果是正常方式，查询业务日期
		    		 */
		    		String errorMsg =  SyncEHRAchieveUtil.SyncAchieveRepot(ctx, period, cityNumber,"CBQR",incityStr);
			    	
			    	//-----------------------------
			    	
			    	ExecutorService pool = Executors.newFixedThreadPool(6);
				    ParallelSqlExecutor pe = new ParallelSqlExecutor(pool); 
				    
			    	CoreBaseCollection collection = new CoreBaseCollection();
			    	HashMap<String,String> detailMap = new HashMap<String,String>();
			    	//查询这个城市 需要出库  未出库的 所有单据
			    	 
			    	String  allAchieve = "/*dialect*/select distinct detail.CFHISORDERID as HISORDERID,  detail.CFHisdetailid as detailid ,  to_char(detail.fbizdate,'YYYYMM') as businessdate from  CT_PAY_AchieveDetailTem detail where  detail.CFIsneedout =1 and detail.CFIsout=0 and detail.cfcitynumber  "+incityStr+"  ";
			    	IRowSet allrow = DbUtil.executeQuery(ctx, allAchieve); 
					while(allrow.next()){
						String orderid = allrow.getString("HISORDERID"); 
						String detailid =  allrow.getString("DETAILID"); 
						String periods = allrow.getString("BUSINESSDATE");  
						detailMap.put(orderid+detailid, periods);
					}  
			    	 
			    	//查询指定期间的销售出库单
			    	String saleSql  = "/*dialect*/ SELECT  distinct city.fid as cityid ,company.fid as comid, bill.fnumber as billNumber, bill.CFHISREQID as hisreqid , bill.cfhisdanjubianma as orderid  ,  entry.CFHISSFXM as SFXM ,entry.CFHISSFXMID as SFXMid  ,entry.CFPAYORDERDETAILID as detailid "+ 
			    	" FROM  T_IM_SALEISSUEBILL bill  inner join T_IM_SALEISSUEentry  entry on bill.fid = entry.FPARENTID  and bill.fmonth  = "+period+"  inner join  T_ORG_BaseUnit company on bill.FSTORAGEORGUNITID = company.fid  inner join T_ORG_BaseUnit city on city.fid= company.FPARENTID "+
			    	" where  city.fnumber  "+incityStr +" and entry.CFHISMINGXIID is not null and  entry.CFHISSFXMID is not null and   bill.cfhisdanjubianma is not null  and bill.CFHISREQID is not null  and  entry.CFPAYORDERDETAILID is not null ";
			    	IRowSet salerow = DbUtil.executeQuery(ctx, saleSql); 
					while(salerow.next()){
						String cityid =  salerow.getString("CITYID"); 
						String comid =  salerow.getString("COMID"); 
						String billNumber =  salerow.getString("BILLNUMBER"); 
						String hisreqid =  salerow.getString("HISREQID"); 
						
						String orderid =  salerow.getString("ORDERID"); 
						
						String sfxm = salerow.getString("SFXM");  
						String sfxmid = salerow.getString("SFXMID");  
						String detailid = salerow.getString("DETAILID").replace("SALE", "");  
					
						if(detailMap.get(orderid+detailid)== null || detailMap.get(orderid+detailid).equals("") || 
								detailMap.get(orderid+detailid)== null || detailMap.get(orderid+detailid).equals("")){
							//异常数据 存下来     已经出库得 或者不存在得    或者不需要出库得
							ErrorAchieveInfo info = new ErrorAchieveInfo();
							CtrlUnitInfo   cityinfo= new CtrlUnitInfo();
							cityinfo.setId(BOSUuid.read(cityid)); 
							info.setCity(cityinfo);
							CompanyOrgUnitInfo  cominfo = new CompanyOrgUnitInfo();
							cominfo.setId(BOSUuid.read(comid));
							info.setClinic(cominfo);
							
							info.setBusinessDate(period);
							info.setSaleoutNumber(billNumber);
							info.setHisorderid(orderid);
							info.setHisorderDetailid(detailid);
							info.setItemNumber(sfxmid);
							info.setItemName(sfxm);
							collection.add(info);
						}else{
							String thisPeriod = detailMap.get(orderid+detailid);
							if(thisPeriod.equals(period)){
								String updateSql = " update CT_PAY_AchieveDetail set    cfisout = 1 where  CFHisdetailid = '"+detailid+"'  ";
								String updateTemSql = " update CT_PAY_AchieveDetailTem set cfbusinessdate = '"+period+"' , cfisout = 1 where  CFHisdetailid = '"+detailid+"'  ";
								pe.getSqlList().add(updateSql);
								pe.getSqlList().add(updateTemSql);
							}else{
								String updateTemSql = " update CT_PAY_AchieveDetailTem set cfbusinessdate = '"+period+"' ,cfisout = 1  where  CFHisdetailid = '"+detailid+"'  ";
								pe.getSqlList().add(updateTemSql);
							}
						}
					}

					if(collection.size()>0){
						ErrorAchieveFactory.getLocalInstance(ctx).save(collection);  
					}
					
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
		    		
					if(errorMsg == null || errorMsg.equals("")){
						String midUpdateSql = " /*dialect*/update  EAS_HIS_CITYACHIEVE set  EASSIGN = 1 , ERRORMSG = ''  where PERIOD='"+period+"' and EASSIGN = 0 and HISSIGN = 1 and  CITYNUMBER    "+incityStr+"  ";
						EAISynTemplate.execute(ctx, "04",midUpdateSql); 
					}else{
						if(errorMsg.length() > 900){
							errorMsg = errorMsg.substring(0, 890)+"...等";
						}
						String midUpdateSql = " /*dialect*/update  EAS_HIS_CITYACHIEVE set  EASSIGN = 2  , ERRORMSG = '"+errorMsg+"'  where PERIOD='"+period+"' and EASSIGN = 0 and HISSIGN = 1 and  CITYNUMBER    "+incityStr+"  ";
						EAISynTemplate.execute(ctx, "04",midUpdateSql); 
					}
		    	}
		    	
		    	 
		    }
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}






	@Override
	protected String _SyncCityMessage(Context ctx, String cityNumber,
			String cityName) throws BOSException {
		// TODO Auto-generated method stub
		//return super._SyncCityMessage(ctx, cityNumber, cityName); 
		
		String businessDate = "";
//		String periodStrSql =  " /*dialect*/ select NVL(max(a.FPeriodYear),'0') as year,NVL(max(a.FPeriodMonth),'0') as month from  T_HR_SCalScheme a left join T_ORG_BaseUnit unit on a.FADMINORGUNITID = unit.fid where  unit.fnumber ='"+cityNumber+"' and FSTATE = 1  "
//		+"and  a.FPeriodYear = ( select  max(b.FPeriodYear  ) from T_HR_SCalScheme b left join T_ORG_BaseUnit unit on b.FADMINORGUNITID = unit.fid where  unit.fnumber ='"+cityNumber+"' and FSTATE = 1  ) ";
//	
//    	IRowSet periodrow = DbUtil.executeQuery(ctx, periodStrSql );
//    	try {
//			while (periodrow.next()) { 
//				String yearStr = periodrow.getString("YEAR");
//				if(!yearStr.equals("0")){
//					String monthStr = periodrow.getInt("MONTH") < 10 ? "0"+periodrow.getString("MONTH") :periodrow.getString("MONTH") ;
//					period = yearStr+monthStr;
//				} 
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}  
    	 
		String sql = "/*dialect*/SELECT city.fnumber , max(c.fnumber) as PERIODNUM   "+
	    " from T_BD_SystemStatusCtrol a  "+
	    " inner join T_ORG_COMPANY b on  a.fcompanyid =b.fid "+
	    " inner join T_ORG_BaseUnit city on  city.fid =b.fparentid "+
	    " inner join T_BD_Period c on  a.FCurrentPeriodID =c.fid  "+
	    " where a.FSystemStatusID ='e45c1988-00fd-1000-e000-36b8c0a8500d02A5514C' and  a.FIsStart =1 "+
	    " and b.FIsSealUp = 0 and b.FIsBizUnit = 1 and to_char(b.FInvalidDate,'yyyyMMDD')='21991231' and b.fnumber like 'MS%'  and city.fnumber = '"+cityNumber+"'  group  by   city.fnumber  " ;
		IRowSet rs = null;
		try {
			rs =  DBUtil.executeQuery(ctx,sql);
			if(rs!=null && rs.size() > 0){
				  while(rs.next()){		 
					  businessDate = rs.getString("PERIODNUM"); 
				  }
			 } 
		} catch (BOSException e) {
			e.printStackTrace();
		} catch (java.sql.SQLException e) {
			e.printStackTrace();
		} 
		if(businessDate.equals("")){
    		Calendar cal = Calendar.getInstance();
            cal.setTime(new Date());
            cal.add(Calendar.MONTH, -1);
            Date date3 = cal.getTime();
            SimpleDateFormat format3= new SimpleDateFormat("yyyyMM");
            businessDate = format3.format(date3);    
    	}else{
    		String year = businessDate.substring(0, 4);
    		String month = businessDate.substring(4, 6);
    		
    		if(month.equals("01")){
    			year = (Integer.parseInt(year)-1)+"";
    		}else{
    			month = (Integer.parseInt(month)-1)+"";
    			if(month.length() == 1){month = "0"+month;}
    		}
    		businessDate = year+month;
    	}
    	 
		
		SyncEHRAchieveUtil.setCityAchieveMsg( ctx, cityNumber,  businessDate , cityName);
        
        
		
    	return  "";
	}
	 


	@Override
	protected void _splitFentanDate(Context ctx, String businessDate)
			throws BOSException {
		String cityid = "";
    	if(businessDate == null || businessDate.equals("") || businessDate.equals("1")){
			
	        Calendar cal2 = Calendar.getInstance();
	        cal2.setTime(new Date()); 
	        
	        Date date2 = cal2.getTime();
	        SimpleDateFormat format2= new SimpleDateFormat("yyyyMM");
	        businessDate = format2.format(date2);   
		}else{
			if(businessDate.indexOf("&") >= 0){
				String[] arr = businessDate.split("&");
				businessDate = arr[0];
				cityid = arr[1];
			}
		} 

    	BaoBiaoFunction baoBiaoFunction = new BaoBiaoFunction();
    	baoBiaoFunction.setCityBaoBiao(ctx, businessDate, cityid);
    	
		// TODO Auto-generated method stub
		//super._splitFentanDate(ctx, businessDate);
		
		
	}

	
	
	@Override
	protected void _initBaseDate(Context ctx, String businessDate)
			throws BOSException {
		// TODO Auto-generated method stub
		//super._initBaseDate(ctx, businessDate);
		
		Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.MONTH, -1); 
        Date date3 = cal.getTime();
        SimpleDateFormat format3= new SimpleDateFormat("yyyyMM");
        String lastbusiness = format3.format(date3);   
        
		if(businessDate == null || businessDate.equals("") || businessDate.equals("1")){
			
	        Calendar cal2 = Calendar.getInstance();
	        cal2.setTime(new Date()); 
	        
	        Date date2 = cal2.getTime();
	        SimpleDateFormat format2= new SimpleDateFormat("yyyyMM");
	        businessDate = format2.format(date2);   
		}else{
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
			Date date = null;
			String monthFormat;
			try {
				date = sdf.parse(businessDate );
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Calendar c = Calendar.getInstance();
			c.setTime(date);
			c.add(Calendar.MONTH, -1); 
			Date lastdate = c.getTime();
			SimpleDateFormat format= new SimpleDateFormat("yyyyMM");
		    lastbusiness = format.format(lastdate);  
		}
		 
		try {
			//薪资岗位
			/*CoreBaseCollection newPayPostCollection = new CoreBaseCollection();
			if(!PayPostFactory.getLocalInstance(ctx).exists(" where businessdate = '"+businessDate+"'") && PayPostFactory.getLocalInstance(ctx).exists(" where businessdate = '"+lastbusiness+"'")){
				PayPostCollection payPostCollection  =  PayPostFactory.getLocalInstance(ctx).getPayPostCollection(" where businessdate = '"+lastbusiness+"'");
				for(int i = 0 ; i < payPostCollection.size() ; i++){
					PayPostInfo info = payPostCollection.get(i); 
					PayPostInfo newInfo = (PayPostInfo) info.clone();
					newInfo.setBusinessdate(businessDate);
					newInfo.setId(null);
					newPayPostCollection.add(newInfo);
				}
			}
			PayPostFactory.getLocalInstance(ctx).save(newPayPostCollection);
			*/
			//洁牙单价
			CoreBaseCollection newScalingBonusCollection = new CoreBaseCollection();
			if(!ScalingBonusFactory.getLocalInstance(ctx).exists(" where businessDate = '"+businessDate+"'") && ScalingBonusFactory.getLocalInstance(ctx).exists(" where businessDate = '"+lastbusiness+"'")){
				ScalingBonusCollection scalingBonusCollection  =  ScalingBonusFactory.getLocalInstance(ctx).getScalingBonusCollection(" where businessdate = '"+lastbusiness+"'");
				for(int i = 0 ; i < scalingBonusCollection.size() ; i++){
					ScalingBonusInfo info = scalingBonusCollection.get(i); 
					ScalingBonusInfo newInfo = (ScalingBonusInfo) info.clone();
					newInfo.setBusinessDate(businessDate);
					newInfo.setId(null);
					newScalingBonusCollection.add(newInfo);
				}
			}
			ScalingBonusFactory.getLocalInstance(ctx).save(newScalingBonusCollection);
			//美白比例
			CoreBaseCollection newWhiteProportionCollection = new CoreBaseCollection();
			if(!WhiteProportionFactory.getLocalInstance(ctx).exists(" where businessdate = '"+businessDate+"'") && WhiteProportionFactory.getLocalInstance(ctx).exists(" where businessdate = '"+lastbusiness+"'")){
				WhiteProportionCollection whiteProportionCollection  =  WhiteProportionFactory.getLocalInstance(ctx).getWhiteProportionCollection(" where businessdate = '"+lastbusiness+"'");
				for(int i = 0 ; i < whiteProportionCollection.size() ; i++){
					WhiteProportionInfo info = whiteProportionCollection.get(i); 
					WhiteProportionInfo newInfo = (WhiteProportionInfo) info.clone();
					newInfo.setBusinessDate(businessDate);
					newInfo.setId(null);
					newWhiteProportionCollection.add(newInfo);
				}
			}
			WhiteProportionFactory.getLocalInstance(ctx).save(newWhiteProportionCollection);
			//咨询比例
			CoreBaseCollection newConsultantProCollection = new CoreBaseCollection();
			if(!ConsultantProFactory.getLocalInstance(ctx).exists(" where businessdate = '"+businessDate+"'") && ConsultantProFactory.getLocalInstance(ctx).exists(" where businessdate = '"+lastbusiness+"'")){
				ConsultantProCollection consultantProCollection  =  ConsultantProFactory.getLocalInstance(ctx).getConsultantProCollection(" where businessdate = '"+lastbusiness+"'");
				for(int i = 0 ; i < consultantProCollection.size() ; i++){
					ConsultantProInfo info = consultantProCollection.get(i); 
					ConsultantProInfo newInfo = (ConsultantProInfo) info.clone();
					newInfo.setBusinessDate(businessDate);
					newInfo.setId(null);
					newConsultantProCollection.add(newInfo);
				}
			}
			ConsultantProFactory.getLocalInstance(ctx).save(newConsultantProCollection);
			
			//绩效 及其他职位 
			CoreBaseCollection newAchRoyaltyRuleCollection = new CoreBaseCollection();
			if(!AchRoyaltyRuleFactory.getLocalInstance(ctx).exists(" where businessdate = '"+businessDate+"'") && AchRoyaltyRuleFactory.getLocalInstance(ctx).exists(" where businessdate = '"+lastbusiness+"'")){
				AchRoyaltyRuleCollection collection  =  AchRoyaltyRuleFactory.getLocalInstance(ctx).getAchRoyaltyRuleCollection(" where businessdate = '"+lastbusiness+"'");
				for(int i = 0 ; i < collection.size() ; i++){
					AchRoyaltyRuleInfo info = collection.get(i); 
					AchRoyaltyRuleInfo newInfo = (AchRoyaltyRuleInfo) info.clone();
					newInfo.setBusinessDate(businessDate);
					newInfo.setId(null);
					newAchRoyaltyRuleCollection.add(newInfo);
				}
			}
			AchRoyaltyRuleFactory.getLocalInstance(ctx).save(newAchRoyaltyRuleCollection);
			
			//医生通用比例
			CoreBaseCollection newDocCurrencyProCollection = new CoreBaseCollection();
			if(!DocCurrencyProFactory.getLocalInstance(ctx).exists(" where businessdate = '"+businessDate+"'") && DocCurrencyProFactory.getLocalInstance(ctx).exists(" where businessdate = '"+lastbusiness+"'")){
				DocCurrencyProCollection collection  =  DocCurrencyProFactory.getLocalInstance(ctx).getDocCurrencyProCollection(" where businessdate = '"+lastbusiness+"'");
				for(int i = 0 ; i < collection.size() ; i++){
					DocCurrencyProInfo info = collection.get(i); 
					DocCurrencyProInfo newInfo = (DocCurrencyProInfo) info.clone();
					newInfo.setBusinessdate(businessDate);
					newInfo.setId(null);
					newDocCurrencyProCollection.add(newInfo);
					 
				}
			}
			DocCurrencyProFactory.getLocalInstance(ctx).save(newDocCurrencyProCollection);
			
			//兼职医生比例
			CoreBaseCollection newPartTimeDocProCollection = new CoreBaseCollection();
			if(!PartTimeDocProFactory.getLocalInstance(ctx).exists(" where businessdate = '"+businessDate+"'") && PartTimeDocProFactory.getLocalInstance(ctx).exists(" where businessdate = '"+lastbusiness+"'")){
				PartTimeDocProCollection collection  =  PartTimeDocProFactory.getLocalInstance(ctx).getPartTimeDocProCollection(" where businessdate = '"+lastbusiness+"'");
				for(int i = 0 ; i < collection.size() ; i++){
					PartTimeDocProInfo info = collection.get(i); 
					PartTimeDocProInfo newInfo = (PartTimeDocProInfo) info.clone();
					newInfo.setBusinessDate(businessDate);
					newInfo.setId(null);
					newPartTimeDocProCollection.add(newInfo);
				}
			}
			PartTimeDocProFactory.getLocalInstance(ctx).save(newPartTimeDocProCollection);
			
			
			//门店及其相关比例
			CoreBaseCollection newClinicUpScaleCollection = new CoreBaseCollection();
			if(!ClinicUpScaleFactory.getLocalInstance(ctx).exists(" where businessdate = '"+businessDate+"'") && ClinicUpScaleFactory.getLocalInstance(ctx).exists(" where businessdate = '"+lastbusiness+"'")){
				ClinicUpScaleCollection collection  =  ClinicUpScaleFactory.getLocalInstance(ctx).getClinicUpScaleCollection(" where businessdate = '"+lastbusiness+"'");
				for(int i = 0 ; i < collection.size() ; i++){
					ClinicUpScaleInfo info = collection.get(i); 
					ClinicUpScaleInfo newInfo = (ClinicUpScaleInfo) info.clone();
					newInfo.setBusinessDate(businessDate);
					newInfo.setId(null);
					newClinicUpScaleCollection.add(newInfo);
				}
			}
			ClinicUpScaleFactory.getLocalInstance(ctx).save(newClinicUpScaleCollection);
			
			
			//渠道折扣配置 
			CoreBaseCollection newCityChannelCollection = new CoreBaseCollection();
			if(!CityChannelFactory.getLocalInstance(ctx).exists(" where businessdate = '"+businessDate+"'") && CityChannelFactory.getLocalInstance(ctx).exists(" where businessdate = '"+lastbusiness+"'")){
				CityChannelCollection collection  =  CityChannelFactory.getLocalInstance(ctx).getCityChannelCollection(" where businessdate = '"+lastbusiness+"'");
				for(int i = 0 ; i < collection.size() ; i++){
					CityChannelInfo info = collection.get(i); 
					CityChannelInfo newInfo = (CityChannelInfo) info.clone();
					newInfo.setBusinessDate(businessDate);
					newInfo.setId(null);
					newCityChannelCollection.add(newInfo);
				}
			}
			CityChannelFactory.getLocalInstance(ctx).save(newCityChannelCollection);
			
			//咨询阶段配置
			CoreBaseCollection newConsultStageCollection = new CoreBaseCollection();
			if(!ConsultStageFactory.getLocalInstance(ctx).exists(" where businessdate = '"+businessDate+"'") && ConsultStageFactory.getLocalInstance(ctx).exists(" where businessdate = '"+lastbusiness+"'")){
				ConsultStageCollection collection  =  ConsultStageFactory.getLocalInstance(ctx).getConsultStageCollection(" where businessdate = '"+lastbusiness+"'");
				for(int i = 0 ; i < collection.size() ; i++){
					ConsultStageInfo info = collection.get(i); 
					ConsultStageInfo newInfo = (ConsultStageInfo) info.clone();
					newInfo.setBusinessDate(businessDate);
					newInfo.setId(null);
					newConsultStageCollection.add(newInfo);
				}
			}
			ConsultStageFactory.getLocalInstance(ctx).save(newConsultStageCollection);
			
			
			//医生阶段配置
			CoreBaseCollection newDocStageCollection = new CoreBaseCollection();
			if(!DocStageFactory.getLocalInstance(ctx).exists(" where businessdate = '"+businessDate+"'") && DocStageFactory.getLocalInstance(ctx).exists(" where businessdate = '"+lastbusiness+"'")){
				DocStageCollection collection  =  DocStageFactory.getLocalInstance(ctx).getDocStageCollection(" where businessdate = '"+lastbusiness+"'");
				for(int i = 0 ; i < collection.size() ; i++){
					DocStageInfo info = collection.get(i); 
					DocStageInfo newInfo = (DocStageInfo) info.clone();
					newInfo.setBusinessDate(businessDate);
					newInfo.setId(null);
					newDocStageCollection.add(newInfo);
				}
			}
			DocStageFactory.getLocalInstance(ctx).save(newDocStageCollection);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected void _SyncItem(Context ctx, String dataBase) throws BOSException {
		List<String> updatesqls = new ArrayList<String>();
		
		
		//查询出来所有二级编码 
		StringBuffer erjiSql = new StringBuffer();
		erjiSql.append("/*dialect*/ select fid, FNUMBER   from  CT_SRQ_Paytypeitem  ");
		IRowSet erjiRows = DbUtil.executeQuery(ctx, erjiSql.toString());
		Map<String, String> erjiMap = new HashMap<String, String>();
		
		
		ExecutorService pool = Executors.newFixedThreadPool(6);
	    ParallelSqlExecutor pe = new ParallelSqlExecutor(pool); 
	    String userId = ContextHelperFactory.getLocalInstance(ctx).getCurrentUser().getId().toString(); 
	    boolean flag = false;
		
		//查询中间表的数据
		String  midSql = new String(); 
		midSql = " select id, FNUMBER ,FNAME ,SECONDCLASS,STATUS from  HIS_SHR_ITEM where FSIGN = 0 or FSIGN is null  ";
		List<Map<String, Object>> rets =  EAISynTemplate.query(ctx, dataBase, midSql);
		
		if(rets.size() > 0){
			//查询eas中已存在的数据
			StringBuffer easSql = new StringBuffer();
			easSql.append("/*dialect*/ select Fid, FNUMBER ,FNAME_l2,cfstatus    from  CT_SRQ_PayItem ");
			IRowSet rows = DbUtil.executeQuery(ctx, easSql.toString());
			try {
				//遍历一级分类
				while (erjiRows.next()) {
					erjiMap.put(erjiRows.getString("fnumber"), erjiRows.getString("fid") );
				}
				
				
				//遍历eas中的数据
				Map<String, String> mapAll = new HashMap<String, String>();
				while (rows.next()) {
					mapAll.put(rows.getString("fnumber"), rows.getString("fname_l2")+ rows.getString("cfstatus"));
				}
				
				for (int i = 0; i < rets.size(); i++) {
					//中间表数据
					String fnumber = rets.get(i).get("FNUMBER").toString();
					String fname = rets.get(i).get("FNAME").toString();
					String secondClass = rets.get(i).get("SECONDCLASS").toString();
					String status = rets.get(i).get("STATUS").toString(); 
					
					
					//eas名字 
					String  mp = mapAll.get(fnumber);
					if(mp == null || mp.equals("")){//新增
						flag = true;
						String erjiID = erjiMap.get(secondClass).toString();
						
						StringBuffer sbr  = new StringBuffer("insert into CT_SRQ_PayItem (FID,FCreatorID,FCreateTime,FLastUpdateUserID,FLastUpdateTime, ");
			    		sbr.append(" FNUMBER,FNAME_L2,CFSecondClassID,CFSTATUS ) ");
			    		sbr.append("values(newbosid('2B2E091F'),'"+userId+"',sysdate,'"+userId+"',sysdate, ");
			    		sbr.append("'"+fnumber+"','"+fname+"','"+erjiID+"','"+status+"' )"); 
			    		pe.getSqlList().add(sbr);
			    		
			    		//String updateSql = "update HIS_SHR_ITEM set FSIGN = 1,FupdateTime = SYSDATE  where  fnumber = '"+fnumber+"'";
			    		//updatesqls.add(updateSql);
					}else{//修改
						if(fname != null && !(fname+status).equals(mp) ){
							flag = true;
							StringBuffer sbr  = new StringBuffer("update   CT_SRQ_PayItem  set FNAME_L2 = '"+fname+"' , cfstatus = '"+status+"', FLastUpdateTime=sysdate ,  FLastUpdateUserID = '"+userId+"' where  fnumber = '"+fnumber+"' "); 
				    		pe.getSqlList().add(sbr);
				    		
				    		//String updateSql = "update HIS_SHR_ITEM set FSIGN = 1,FupdateTime = SYSDATE  where  fnumber = '"+fnumber+"'";
				    		//updatesqls.add(updateSql);
						}
					}
				}
	 
			} catch (Exception e) {
				e.printStackTrace();
			} 
			if(flag){
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
				
				/*if (updatesqls.size() > 0) {
					doInsertSqls(ctx, dataBase, updatesqls);
				}*/
				String updateSql = "update HIS_SHR_ITEM set FSIGN = 1,FupdateTime = SYSDATE  where  FSIGN = 0 or FSIGN is null  ";
				EAISynTemplate.execute(ctx, dataBase, updateSql);
			}
			
		} 
	}

	/**  中间表给 eas   不要弄混
	 * 同步收费项目一级分类
	 */
	@Override
	protected void _SyncItemFirstClass(Context ctx, String dataBase)
			throws BOSException {

		ExecutorService pool = Executors.newFixedThreadPool(6);
	    ParallelSqlExecutor pe = new ParallelSqlExecutor(pool); 
	    String userId = ContextHelperFactory.getLocalInstance(ctx).getCurrentUser().getId().toString(); 
	    boolean flag = false;
		
		//查询中间表的数据
		String  midSql = new String(); 
		midSql = " select id, FNUMBER ,FNAME ,MAINBUSICLASS,STATUS from  HIS_SHR_ITEMFIRSTCLASS  ";
		List<Map<String, Object>> rets = EAISynTemplate.query(ctx, dataBase, midSql);
		
		
		//查询eas中已存在的数据
		StringBuffer easSql = new StringBuffer();
		easSql.append("/*dialect*/ select Fid, FNUMBER ,FNAME_l2 ,cfstatus,cfmiancalss  from  CT_SRQ_Paytypecategory ");
		IRowSet rows = DbUtil.executeQuery(ctx, easSql.toString());
		try {
			//遍历eas中的数据
			Map<String, String> mapAll = new HashMap<String, String>();
			while (rows.next()) {
				mapAll.put(rows.getString("fnumber"), rows.getString("fname_l2")+rows.getString("cfstatus") );
			}
			for (int i = 0; i < rets.size(); i++) {
				//中间表数据
				String fnumber = rets.get(i).get("FNUMBER").toString();
				String fname = rets.get(i).get("FNAME").toString();
				String mainClass = rets.get(i).get("MAINBUSICLASS").toString();
				String status = rets.get(i).get("STATUS").toString(); 
				
				String  mp = mapAll.get(fnumber);//eas名字
				
			
				if(mp == null || mp.equals("")){//新增
					flag = true;
					StringBuffer sbr  = new StringBuffer("insert into CT_SRQ_Paytypecategory (FID,FCreatorID,FCreateTime,FLastUpdateUserID,FLastUpdateTime, ");
		    		sbr.append(" FNUMBER,FNAME_L2,CFMIANCALSS,CFSTATUS) ");
		    		sbr.append("values(newbosid('8CB3E024'),'"+userId+"',sysdate,'"+userId+"',sysdate, ");
		    		sbr.append("'"+fnumber+"','"+fname+"','"+mainClass+"','"+status+"' )"); 
		    		pe.getSqlList().add(sbr);
				}else{//修改
					if( fname != null && !(fname+status).equals(mp)  ){
						flag = true;
						StringBuffer sbr  = new StringBuffer("update   CT_SRQ_Paytypecategory  set FNAME_L2 = '"+fname+"' ,  cfstatus = '"+status+"',FLastUpdateTime=sysdate ,  FLastUpdateUserID = '"+userId+"' where  fnumber = '"+fnumber+"' "); 
			    		pe.getSqlList().add(sbr);
					}
				}
			}
 
		} catch (Exception e) {
			e.printStackTrace();
		} 
		if(flag){
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

	/**
	 * 同步收费项目二级分类
	 */
	@Override
	protected void _SyncItemSecondClass(Context ctx, String dataBase)
			throws BOSException { 
		
		//查询出来所有一级编码 
		StringBuffer yijiSql = new StringBuffer();
		yijiSql.append("/*dialect*/ select fid, FNUMBER   from  CT_SRQ_Paytypecategory ");
		IRowSet yijiRows = DbUtil.executeQuery(ctx, yijiSql.toString());
		Map<String, String> yijiMap = new HashMap<String, String>();
		
		
		ExecutorService pool = Executors.newFixedThreadPool(6);
	    ParallelSqlExecutor pe = new ParallelSqlExecutor(pool); 
	    String userId = ContextHelperFactory.getLocalInstance(ctx).getCurrentUser().getId().toString(); 
	    boolean flag = false;
		
		//查询中间表的数据
		String  midSql = new String(); 
		midSql = " select id, FNUMBER ,FNAME ,FIRSTCLASS,STATUS from  HIS_SHR_ITEMSECONDCLASS  ";
		List<Map<String, Object>> rets = com.kingdee.eas.custom.EAISynTemplate.query(ctx, dataBase, midSql);
		
		
		//查询eas中已存在的数据
		StringBuffer easSql = new StringBuffer();
		easSql.append("/*dialect*/ select Fid, FNUMBER ,FNAME_l2,cfstatus    from  CT_SRQ_Paytypeitem ");
		IRowSet rows = DbUtil.executeQuery(ctx, easSql.toString());
		try {
			//遍历一级分类
			while (yijiRows.next()) {
				yijiMap.put(yijiRows.getString("fnumber"), yijiRows.getString("fid") );
			}
			
			
			//遍历eas中的数据
			Map<String, String> mapAll = new HashMap<String, String>();
			while (rows.next()) {
				mapAll.put(rows.getString("fnumber"), rows.getString("fname_l2")+ rows.getString("cfstatus"));
			}
			
			for (int i = 0; i < rets.size(); i++) {
				//中间表数据
				String fnumber = rets.get(i).get("FNUMBER").toString();
				String fname = rets.get(i).get("FNAME").toString();
				String firstClass = rets.get(i).get("FIRSTCLASS").toString();
				String status = rets.get(i).get("STATUS").toString(); 
				
				
				String  mp = mapAll.get(fnumber);//eas名字 
				if(mp == null || mp.equals("")){//新增
					flag = true;
					String yijiID = yijiMap.get(firstClass).toString();
					
					StringBuffer sbr  = new StringBuffer("insert into CT_SRQ_Paytypeitem (FID,FCreatorID,FCreateTime,FLastUpdateUserID,FLastUpdateTime, ");
		    		sbr.append(" FNUMBER,FNAME_L2,CFCategoryID,CFSTATUS ) ");
		    		sbr.append("values(newbosid('F28E2139'),'"+userId+"',sysdate,'"+userId+"',sysdate, ");
		    		sbr.append("'"+fnumber+"','"+fname+"','"+yijiID+"','"+status+"' )"); 
		    		pe.getSqlList().add(sbr);
				}else{//修改
					if(fname != null && !(fname+status).equals(mp) ){
						flag = true;
						StringBuffer sbr  = new StringBuffer("update   CT_SRQ_Paytypeitem  set FNAME_L2 = '"+fname+"' ,  cfstatus = '"+status+"', FLastUpdateTime=sysdate ,  FLastUpdateUserID = '"+userId+"' where  fnumber = '"+fnumber+"' "); 
			    		pe.getSqlList().add(sbr);
					}
				}
			}
 
		} catch (Exception e) {
			e.printStackTrace();
		} 
		if(flag){
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
	    
	
	/**
	 * 同步收费项目城市
	 */
	@Override
	protected void _SyncItemCity(Context ctx, String dataBase)
			throws BOSException {
		// TODO Auto-generated method stub
		
		List<String> updatesqls = new ArrayList<String>();
		
		ExecutorService pool = Executors.newFixedThreadPool(6);
	    ParallelSqlExecutor pe = new ParallelSqlExecutor(pool); 
	    String userId = ContextHelperFactory.getLocalInstance(ctx).getCurrentUser().getId().toString(); 
	    boolean flag = false;
		
		//查询中间表的数据
		String  midSql = new String(); 
		midSql = " select id, fcityid  ,fitemid  from  His_Item_City_Rela where fsign = 0 and FCITYID is not null ";
		List<Map<String, Object>> rets = EAISynTemplate.query(ctx, dataBase, midSql);
		
		
		//查询eas中已存在的数据
		StringBuffer easSql = new StringBuffer();
		easSql.append("/*dialect*/ select  CFCITY,CFITEM  from  CT_SRQ_ItemCity ");
		IRowSet rows = DbUtil.executeQuery(ctx, easSql.toString());
		try {
			//遍历eas中的数据
			Map<String, String> mapAll = new HashMap<String, String>();
			while (rows.next()) {
				mapAll.put(rows.getString("CFCITY")+rows.getString("CFITEM"), rows.getString("CFCITY")+rows.getString("CFITEM") );
			}
			for (int i = 0; i < rets.size(); i++) {
				//中间表数据
				String id = rets.get(i).get("ID").toString();
				String cityid = rets.get(i).get("FCITYID").toString();
				//String cliincid = rets.get(i).get("CLINICID").toString();
				String sfxmid = rets.get(i).get("FITEMID").toString();
				 
				String  mp = mapAll.get(cityid+sfxmid);//eas名字
				
				if(mp == null || mp.equals("")){//新增
					flag = true;
					StringBuffer sbr  = new StringBuffer("insert into CT_SR_ItemCity (FID,FCreatorID,FCreateTime,FLastUpdateUserID,FLastUpdateTime, ");
		    		sbr.append(" CFCITY,CFITEM ) ");
		    		sbr.append("values(newbosid('3045725A'),'"+userId+"',sysdate,'"+userId+"',sysdate, ");
		    		sbr.append("'"+cityid+"','"+sfxmid+"'  )"); 
		    		pe.getSqlList().add(sbr);
		    		
		    		String updateSql = "update His_Item_City_Rela set FSIGN = 1,FupdateTime = SYSDATE  where  id = '"+id+"'";
		    		updatesqls.add(updateSql);
				}else{//修改
					/*if(fname != null && !fname.equals(mp) ){
						flag = true;
						StringBuffer sbr  = new StringBuffer("update   CT_SRQ_Paytypecategory  set FNAME_L2 = '"+fname+"' , FLastUpdateTime=sysdate ,  FLastUpdateUserID = '"+userId+"' where  fnumber = '"+fnumber+"' "); 
			    		pe.getSqlList().add(sbr);
					}*/
				}
			}
 
		} catch (Exception e) {
			e.printStackTrace();
		} 
		if(flag){
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
			
			if (updatesqls.size() > 0) {
				doInsertSqls(ctx, dataBase, updatesqls);
			}
			/*String updateSql = "update His_Item_City_Rela set FSIGN = 1,FsynTime = SYSDATE  where  FSIGN = 0 and FCITYID is not null ";
			EAISynTemplate.execute(ctx, dataBase, updateSql);*/
		}
	}
	
	
	
	/**
	 * 初始化医生数据
	 * @param ctx
	 * @throws BOSException
	 */
	protected void yisheng(Context ctx,String oldDate,String newDate)
	throws BOSException {
		CoreBaseCollection baseCollection = new CoreBaseCollection(); 
		try {
			IDoctorPerformance iDoctorPerformance = DoctorPerformanceFactory.getLocalInstance(ctx);
			DoctorPerformanceCollection   collection  = iDoctorPerformance.getDoctorPerformanceCollection("where businessDate='"+oldDate+"' ");
			for(int i = 0 ; i < collection.size() ; i++){
				DoctorPerformanceInfo info = collection.get(i);
				
				DoctorPerformanceInfo newInfo = new DoctorPerformanceInfo();
				newInfo = (DoctorPerformanceInfo) info.clone();
				
				newInfo.setId(null);
				newInfo.setBusinessDate(newDate);
				
				/*newInfo.setTarget(BigDecimal.ZERO);
				newInfo.setPerNum(BigDecimal.ZERO);
				newInfo.setAmount(BigDecimal.ZERO);
				newInfo.setOrganization("0");*/
				
				baseCollection.add(newInfo);
			}
			iDoctorPerformance.save(baseCollection);
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 初始化预算表数据
	 * @param ctx
	 * @throws BOSException
	 */
	protected void yusuanbiao(Context ctx,String oldDate,String newDate)
	throws BOSException {
		CoreBaseCollection baseCollection = new CoreBaseCollection(); 
		try {
			IBudgetDate iBudgetDate = BudgetDateFactory.getLocalInstance(ctx);
			BudgetDateCollection   budgetDateCollection  = iBudgetDate.getBudgetDateCollection("where businessDate='"+oldDate+"' ");
			for(int i = 0 ; i < budgetDateCollection.size() ; i++){
				BudgetDateInfo info = budgetDateCollection.get(i);
				
				BudgetDateInfo newInfo = new BudgetDateInfo();
				newInfo = (BudgetDateInfo) info.clone();
				
				newInfo.setId(null);
				newInfo.setBusinessDate(newDate);
				
				/*newInfo.setTarget(BigDecimal.ZERO);
				newInfo.setPerNum(BigDecimal.ZERO);
				newInfo.setAmount(BigDecimal.ZERO);
				newInfo.setOrganization("0");*/
				
				baseCollection.add(newInfo);
			}
			iBudgetDate.save(baseCollection);
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	@Override
	protected void _SyncClinicMonthSum(Context ctx, String dataBase)
			throws BOSException { 
		ExecutorService pool = Executors.newFixedThreadPool(6);
	    ParallelSqlExecutor pe = new ParallelSqlExecutor(pool); 
	    String userId = ContextHelperFactory.getLocalInstance(ctx).getCurrentUser().getId().toString(); 
	    boolean flag = false;
	    
		//查询中间表的数据
		String  midSql = new String(); 
		midSql = " select  FDATE,FCLINICNUMBER,FCLINICNAME,FCITY,FCITYNUMBER,FINCOME,FDIARY,FLIUSHUI from  HIS_CLINIC_MONTH_REPORT where FSIGN = 0  ";
		List<Map<String, Object>> rets = EAISynTemplate.query(ctx, dataBase, midSql); 
		try {
			
			for(int i = 0; i < rets.size(); i++) {
				//中间表数据
				String date = rets.get(i).get("FDATE").toString();
				String[]  arr = date.split("-");
				String year = arr[0];
				String month = arr[1];
				date = date.replace("-", "");
				String clinicId = rets.get(i).get("FCLINICNUMBER").toString();
				if(ClinicMonthSumFactory.getLocalInstance(ctx).exists(" where businessdate = '"+date+"' and clinicid = '"+clinicId+"' ")){
					ClinicMonthSumFactory.getLocalInstance(ctx).delete(" where businessdate = '"+date+"' and clinicid = '"+clinicId+"' "); 
				} 
				String clinicName = rets.get(i).get("FCLINICNAME").toString();
				String city = rets.get(i).get("FCITY").toString(); 
				String cityNumber = rets.get(i).get("FCITYNUMBER").toString(); 
				String income = rets.get(i).get("FINCOME").toString(); 
				String diary = rets.get(i).get("FDIARY").toString(); 
				String liushui = rets.get(i).get("FLIUSHUI").toString(); 
				CompanyOrgUnitInfo company = CompanyOrgUnitFactory.getLocalInstance(ctx).getCompanyOrgUnitInfo(" where id = '"+clinicId+"'");
				CompanyOrgUnitInfo cityInfo =  CompanyOrgUnitFactory.getLocalInstance(ctx).getCompanyOrgUnitInfo(" where id = '"+company.getParent().getId()+"'");
				flag = true;
				StringBuffer sbr  = new StringBuffer("insert into CT_PAY_ClinicMonthSum (FID,FCreatorID,FCreateTime,FLastUpdateUserID,FLastUpdateTime, ");
	    		sbr.append(" cfbusinessdate,CFCLINICNUMBER,CFCLINICNAME,CFCITY,CFCITYNUMBER,CFINCOME,CFDIARY,CFLIUSHUI,cfcityid ,cfclinicid ) ");
	    		sbr.append(" values(newbosid('90056865'),'"+userId+"',sysdate,'"+userId+"',sysdate, ");
	    		//sbr.append("'"+date+"','"+company.getNumber()+"','"+clinicName+"','"+city+"','"+cityNumber+"',"+income+","+diary+",'"+company.getParent().getId().toString()+"' )"); 
	    		sbr.append("'"+date+"','"+company.getNumber()+"','"+clinicName+"','"+cityInfo.getName()+"','"+cityInfo.getNumber()+"',"+income+","+diary+","+liushui+",'"+company.getParent().getId().toString()+"','"+clinicId+"' )");
	    		
	    		pe.getSqlList().add(sbr);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		if(flag){
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
			
			String updateSql = "update HIS_CLINIC_MONTH_REPORT set FSIGN = 1,FsynTime = SYSDATE  where  FSIGN = 0  ";
			EAISynTemplate.execute(ctx, dataBase, updateSql);
		}
	}

	
	@Override
	protected void _createCostBuUser(Context ctx, String businessDate)
			throws BOSException {
		// TODO Auto-generated method stub
		//super._createCostBuUser(ctx, businessdate);
		if(businessDate == null || businessDate.equals("")|| businessDate.equals("1")){
			Calendar cal = Calendar.getInstance();
	        cal.setTime(new Date());
	        cal.add(Calendar.MONTH, -1);
	        
	        Date date3 = cal.getTime();
	        SimpleDateFormat format3= new SimpleDateFormat("yyyyMM");
	        businessDate = format3.format(date3); 
	      
		} 
		
		CtrlUnitInfo  org = ContextHelperFactory.getLocalInstance(ctx).getCurrentUser().getCU();
        String cityID = org.getId().toString();
        String cityNumber = org.getNumber();
        String cityName = org.getName();
        if(cityNumber.equals("M")){
        	//cityID = "Yv1mDb4vQwW9pjZPUs6iVsznrtQ=";
        	//cityNumber = "MS1101"; 
        	cityID = "7ATokYoDQGOgUjHAwkAI2sznrtQ=";
        	cityNumber = "MS3202";
        }
        
       
    	try { 
    		String count = ""; 
            String existCity = " /*dialect*/ select  count(1) C from CT_PAY_PayCity where  cfiscreatecost = '1' and cfcityid = '"+cityID+"' " ;
            IRowSet cityrow = DbUtil.executeQuery(ctx, existCity );
        	while (cityrow.next()) { 
    			count = cityrow.getString("C");  
        	} 
            if(!count.equals("") && !count.equals("0") ){
            	HashMap<String,HashMap<String,String>> itemMessage = new HashMap<String,HashMap<String,String>>();
        		itemMessage = PayMessage.getMBItemMessage(ctx, businessDate ,cityID, itemMessage); 
        		HashMap<String,String>  oneItemMap = itemMessage.get("one");
        		HashMap<String,String>  twoItemMap = itemMessage.get("two");
        		HashMap<String,String>  threeItemMap = itemMessage.get("three"); 
        		
            	StringBuffer updateSql = new StringBuffer();
        		//收费项目
        		updateSql.append( "  /*dialect*/ update T_IM_SaleIssueentry t1 set  t1.CFHISSFXM   = ( select  item.fname_l2 from CT_SRQ_PayItem item   where  item.fnumber  = t1.cfhissfxmid )  ")
        		.append( " where   CFHISMINGXIID  is not null       and   cfhissfxm  is not  null  and CFHISSFXM is null     and  fparentid in ( select bill.fid from  T_IM_SaleIssuebill bill inner join  T_ORG_BaseUnit company on bill.FSTORAGEORGUNITID = company.fid  inner join T_ORG_BaseUnit city on city.fid= company.FPARENTID ")
        		.append( " where  city.fnumber = '"+cityNumber+"'  and   bill.cfhisdanjubianma is not null  and bill.CFHISREQID is not null  and  bill.fmonth  = "+businessDate+" ) ");
        		DbUtil.execute(ctx, updateSql.toString() );
        		//二级
        		updateSql = new StringBuffer();
        		updateSql.append( "  /*dialect*/ update T_IM_SaleIssueentry t1 set  t1.CFHISCHARGEITEMid  = ( select   seconditem.fnumber from CT_SRQ_PayItem item ")
        		.append( " left join  CT_SRQ_Paytypeitem seconditem on  item.cfsecondclassid =   seconditem.fid  where  item.fnumber  = t1.cfhissfxmid )  , ")
        		.append( " t1.CFHISCHARGEITEM  = ( select   seconditem.fname_l2 from CT_SRQ_PayItem item  left join  CT_SRQ_Paytypeitem seconditem on  item.cfsecondclassid =   seconditem.fid  where  item.fnumber  = t1.cfhissfxmid ) ")
        		.append( " where   CFHISMINGXIID  is not null      and   cfhissfxm  is not null   and CFHISCHARGEITEMid is null   ") 
        		.append( " and  fparentid in ( select bill.fid from  T_IM_SaleIssuebill bill inner join  T_ORG_BaseUnit company on bill.FSTORAGEORGUNITID = company.fid  inner join T_ORG_BaseUnit city on city.fid= company.FPARENTID ")
        		.append( " where  city.fnumber = '"+cityNumber+"'  and   bill.cfhisdanjubianma is not null  and bill.CFHISREQID is not null  and  bill.fmonth  = "+businessDate+" ) ");
        		DbUtil.execute(ctx, updateSql.toString() );
        		//一级
        		updateSql = new StringBuffer();
        		updateSql.append( "  /*dialect*/ update T_IM_SaleIssueentry t1 set  t1.CFHISFIRSTITEM   = ( select   firstitem.fnumber from CT_SRQ_Paytypeitem seconditem ")
        		.append( " left join  CT_SRQ_Paytypecategory firstitem on  seconditem.cfcategoryid   = firstitem.fid  where  seconditem.fnumber  = t1.cfhischargeitemid ),")
        		.append( " t1.cfhisfirstitemname = ( select firstitem.fname_l2 from   CT_SRQ_Paytypeitem seconditem ")
        		.append( " left join  CT_SRQ_Paytypecategory firstitem on  seconditem.cfcategoryid   = firstitem.fid  where  seconditem.fnumber  = t1.cfhischargeitemid ) ")
        		.append( " where   CFHISMINGXIID  is not null      and   cfhissfxm  is not null   and CFHISFIRSTITEM is null     ")
        		.append( "and  fparentid in ( select bill.fid from  T_IM_SaleIssuebill bill inner join  T_ORG_BaseUnit company on bill.FSTORAGEORGUNITID = company.fid  inner join T_ORG_BaseUnit city on city.fid= company.FPARENTID ")
        		.append( "where  city.fnumber = '"+cityNumber+"' and   bill.cfhisdanjubianma is not null  and bill.CFHISREQID is not null  and  bill.fmonth  = "+businessDate+"  )    ");
        		DbUtil.execute(ctx, updateSql.toString() );
        		
        		
        		
                String companySql = " SELECT fid FROM  t_org_company where  FPARENTID  = '"+cityID+"'  and FPARENTID in ( select entry.cfincludecityid  from  CT_PAY_PayCity bill   left join CT_PAY_PayCityentry entry on  entry.fparentid = bill.fid where  cfcityid = '"+cityID+"' ) and  FISASSISTANTORG  = 0"+
                " and fnumber not in (SELECT distinct  cfclinicnumber FROM  CT_PAY_COSTSUM where cfperiod = '"+businessDate+"'  and cfcitynumber  in ( select company.fnumber  from  CT_PAY_PayCity bill  left join CT_PAY_PayCityentry entry on  entry.fparentid = bill.fid "+
                " left join  t_org_company company on company.fid = entry.Cfincludecityid where  cfcityid = '"+cityID+"' ) ) ";
                	   
                
            	IRowSet companyrow = DbUtil.executeQuery(ctx, companySql );
            	
            	while (companyrow.next()) { 
    				String companyid  = companyrow.getString("FID");
    				
    				SyncCostTool.SyncCostDetail(ctx,cityNumber,companyid,businessDate,cityID, oneItemMap,twoItemMap,threeItemMap );
    			} 
            } 
    		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//_SyncCityMessage(ctx,cityNumber,cityName);
	}

	@Override
	protected void _putCostDetailAndAll(Context ctx,String businessDate) throws BOSException {
		// TODO Auto-generated method stub
		//super._putCostDetailAndAll(arg0);
		if(businessDate == null || businessDate.equals("")|| businessDate.equals("1")){
			Calendar cal = Calendar.getInstance();
	        cal.setTime(new Date());
	        cal.add(Calendar.MONTH, -1);
	        
	        Date date3 = cal.getTime();
	        SimpleDateFormat format3= new SimpleDateFormat("yyyyMM");
	        businessDate = format3.format(date3); 
	        
	        
		} 
		
		String citySql = " select distinct unit.fid as id ,unit.fnumber as fnumber ,unit.fname_l2 as name from CT_PAY_PayCity paycity left join  CT_PAY_PayCityentry entry on paycity.fid = entry.fparentid  left join T_ORG_BaseUnit unit on entry.cfincludecityid = unit.fid where  paycity.cfiscreatecost = '1'";
    	IRowSet cityrow = DbUtil.executeQuery(ctx, citySql );
    	try {
			while (cityrow.next()) { 
				String cityNumber = cityrow.getString("FNUMBER"); 
				String cityName = cityrow.getString("NAME"); 
				String cityID = cityrow.getString("ID"); 
				 
				
			 	 
            	HashMap<String,HashMap<String,String>> itemMessage = new HashMap<String,HashMap<String,String>>();
        		itemMessage = PayMessage.getMBItemMessage(ctx, businessDate ,cityID, itemMessage); 
        		HashMap<String,String>  oneItemMap = itemMessage.get("one");
        		HashMap<String,String>  twoItemMap = itemMessage.get("two");
        		HashMap<String,String>  threeItemMap = itemMessage.get("three");
        		
        		
        		
				StringBuffer updateSql = new StringBuffer();
				//收费项目
				updateSql.append( "  /*dialect*/ update T_IM_SaleIssueentry t1 set  t1.CFHISSFXM   = ( select  item.fname_l2 from CT_SRQ_PayItem item   where  item.fnumber  = t1.cfhissfxmid )  ")
				.append( " where   CFHISMINGXIID  is not null       and   cfhissfxm  is not  null   and CFHISSFXM  is   null    and  fparentid in ( select bill.fid from  T_IM_SaleIssuebill bill inner join  T_ORG_BaseUnit company on bill.FSTORAGEORGUNITID = company.fid  inner join T_ORG_BaseUnit city on city.fid= company.FPARENTID ")
				.append( " where  city.fnumber = '"+cityNumber+"'  and   bill.cfhisdanjubianma is not null  and bill.CFHISREQID is not null  and  bill.fmonth  = "+businessDate+" ) ");
				DbUtil.execute(ctx, updateSql.toString() );
				//二级
				updateSql = new StringBuffer();
				updateSql.append( "  /*dialect*/ update T_IM_SaleIssueentry t1 set  t1.CFHISCHARGEITEMid  = ( select   seconditem.fnumber from CT_SRQ_PayItem item ")
				.append( " left join  CT_SRQ_Paytypeitem seconditem on  item.cfsecondclassid =   seconditem.fid  where  item.fnumber  = t1.cfhissfxmid )  , ")
				.append( " t1.CFHISCHARGEITEM  = ( select   seconditem.fname_l2 from CT_SRQ_PayItem item  left join  CT_SRQ_Paytypeitem seconditem on  item.cfsecondclassid =   seconditem.fid  where  item.fnumber  = t1.cfhissfxmid ) ")
				.append( " where   CFHISMINGXIID  is not null      and   cfhissfxm  is not null  and  CFHISCHARGEITEMid  is   null      ") 
				.append( " and  fparentid in ( select bill.fid from  T_IM_SaleIssuebill bill inner join  T_ORG_BaseUnit company on bill.FSTORAGEORGUNITID = company.fid  inner join T_ORG_BaseUnit city on city.fid= company.FPARENTID ")
				.append( " where  city.fnumber = '"+cityNumber+"'  and   bill.cfhisdanjubianma is not null  and bill.CFHISREQID is not null  and  bill.fmonth  = "+businessDate+" ) ");
				DbUtil.execute(ctx, updateSql.toString() );
				//一级
				updateSql = new StringBuffer();
				updateSql.append( "  /*dialect*/ update T_IM_SaleIssueentry t1 set  t1.CFHISFIRSTITEM   = ( select   firstitem.fnumber from CT_SRQ_Paytypeitem seconditem ")
				.append( " left join  CT_SRQ_Paytypecategory firstitem on  seconditem.cfcategoryid   = firstitem.fid  where  seconditem.fnumber  = t1.cfhischargeitemid ),")
				.append( " t1.cfhisfirstitemname = ( select firstitem.fname_l2 from   CT_SRQ_Paytypeitem seconditem ")
				.append( " left join  CT_SRQ_Paytypecategory firstitem on  seconditem.cfcategoryid   = firstitem.fid  where  seconditem.fnumber  = t1.cfhischargeitemid ) ")
				.append( " where   CFHISMINGXIID  is not null      and   cfhissfxm  is not null  and  CFHISFIRSTITEM  is   null       ")
				.append( "and  fparentid in ( select bill.fid from  T_IM_SaleIssuebill bill inner join  T_ORG_BaseUnit company on bill.FSTORAGEORGUNITID = company.fid  inner join T_ORG_BaseUnit city on city.fid= company.FPARENTID ")
				.append( "where  city.fnumber = '"+cityNumber+"' and   bill.cfhisdanjubianma is not null  and bill.CFHISREQID is not null  and  bill.fmonth  = "+businessDate+"  )    ");
				DbUtil.execute(ctx, updateSql.toString() );
				
				String companySql = " SELECT fid FROM  t_org_company where  FPARENTID  = '"+cityID+"' and  FISASSISTANTORG  = 0 and fnumber not in (SELECT distinct  cfclinicnumber FROM  CT_PAY_COSTSUM where cfperiod = '"+businessDate+"'  and cfcitynumber = '"+cityNumber+"') ";
				
		    	IRowSet companyrow = DbUtil.executeQuery(ctx, companySql );
		    	boolean flag = false;
		    	while (companyrow.next()) { 
		    		flag = true;
		    		String companyid  = companyrow.getString("FID"); 
		    		SyncCostTool.SyncCostDetail(ctx,cityNumber,companyid,businessDate,cityID, oneItemMap,twoItemMap,threeItemMap );
		    	}
		    	if(flag){
		    		//_SyncCityMessage(ctx,cityNumber,cityName);
		    	}
		    	
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	protected void _setAchieveSum(Context ctx, String dataBase,String cityNum)
			throws BOSException {
		// TODO Auto-generated method stub
		//super._setAchieveSum(ctx, dataBase);   
	    String userId = ContextHelperFactory.getLocalInstance(ctx).getCurrentUser().getId().toString(); 
	    boolean flag = false; 
		Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.MONTH, -1);
        Date date3 = cal.getTime();
        SimpleDateFormat format3= new SimpleDateFormat("yyyyMM");
        String businessDate = format3.format(date3);   
          
        
        String cityStr = "";
		if(cityNum.length()>0){
			cityStr = " and unit.fnumber = '"+cityNum+"' ";
		}
		
        try {
        	if(dataBase.length() == 6){
            	businessDate = dataBase;  
            }else{
            	String periodStrSql =  " /*dialect*/ select max(a.FPeriodYear) as year,max(a.FPeriodMonth) as month from  T_HR_SCalScheme a left join T_ORG_BaseUnit unit on a.FADMINORGUNITID = unit.fid where  unit.fnumber ='"+cityNum+"' and FSTATE = 1  "
        		+"and  a.FPeriodYear = ( select  max(b.FPeriodYear  ) from T_HR_SCalScheme b left join T_ORG_BaseUnit unit on b.FADMINORGUNITID = unit.fid where  unit.fnumber ='"+cityNum+"' and FSTATE = 1  ) ";
        	
            	IRowSet periodrow = DbUtil.executeQuery(ctx, periodStrSql );
            	while (periodrow.next()) { 
            		String yearStr = periodrow.getString("YEAR");
            		String monthStr = periodrow.getInt("MONTH") < 10 ? "0"+periodrow.getString("MONTH") :periodrow.getString("MONTH") ;
            		businessDate = yearStr+monthStr;
            	} 
            }
        	
        	
        	String citySql = "/*dialect*/  select distinct unit.fid as id ,unit.fnumber as fnumber ,unit.fname_l2 as name , nvl(paycity.fname_l2,'A') citytype  from CT_PAY_PayCity paycity left join T_ORG_BaseUnit unit on paycity.cfcityid = unit.fid  where  1=1 "+cityStr;
        	IRowSet cityrow = DbUtil.executeQuery(ctx, citySql );
        	while (cityrow.next()) { 
        		String cityNumber = cityrow.getString("FNUMBER"); 
            	String cityName = cityrow.getString("NAME"); 
            	String cityID = cityrow.getString("ID");  
        		
            	String citytype = cityrow.getString("CITYTYPE");  
    			//if(!ClinicAchieveCosthSumFactory.getLocalInstance(ctx).exists(" where businessdate = '"+businessDate+"' and citynumber = '"+cityNumber+"'")){
    				
    			//}
            	PayDocDetailService docDetail = new PayDocDetailService();
				if(citytype.equals("B")){//上海
					if(dataBase.length() == 6){ 
	                	
	                	String deletesql = " delete  CT_PAY_ClinicAchieveCosthSum where cfbusinessdate = '"+businessDate+"' and cfcitynumber = '"+cityNumber+"'  " ;
	                	DbUtil.execute(ctx, deletesql);
	                	deletesql =" delete  CT_PAY_AchienementSum where cfbusinessdate = '"+businessDate+"' and cfcitynumber = '"+cityNumber+"' ";
	                	DbUtil.execute(ctx, deletesql);
	                	deletesql =" delete  CT_PAY_ClinicCostSum where cfbusinessdate = '"+businessDate+"' and cfcitynumber = '"+cityNumber+"'   "; 
	                	DbUtil.execute(ctx, deletesql);
	                	deletesql =" delete  CT_PAY_ScalingCountSum where cfbusinessdate = '"+businessDate+"' and cfcitynumber = '"+cityNumber+"'"; 
	                	DbUtil.execute(ctx, deletesql);
	                }
					docDetail.doShangHai(ctx,businessDate,userId,cityID,cityNumber,cityName,flag);
				}else if(citytype.equals("C")){//宁波
					if(dataBase.length() == 6){ 
	                	
	                	String deletesql = " delete  CT_PAY_ClinicAchieveCosthSum where cfbusinessdate = '"+businessDate+"' and cfcitynumber = '"+cityNumber+"'  " ;
	                	DbUtil.execute(ctx, deletesql);
	                	deletesql =" delete  CT_PAY_AchienementSum where cfbusinessdate = '"+businessDate+"' and cfcitynumber = '"+cityNumber+"' ";
	                	DbUtil.execute(ctx, deletesql);
	                	deletesql =" delete  CT_PAY_ClinicCostSum where cfbusinessdate = '"+businessDate+"' and cfcitynumber = '"+cityNumber+"'   "; 
	                	DbUtil.execute(ctx, deletesql);
	                	deletesql =" delete  CT_PAY_ScalingCountSum where cfbusinessdate = '"+businessDate+"' and cfcitynumber = '"+cityNumber+"'"; 
	                	DbUtil.execute(ctx, deletesql);
	                }
					docDetail.doNingBo(ctx,businessDate,userId,cityID,cityNumber,cityName,flag);
				}else if(citytype.equals("A")){//北京
					 if(dataBase.length() == 6){ 
    	                	//String deletesql = " delete  CT_PAY_ClinicAchieveCosthInit where cfbusinessdate = '"+businessDate+"' and cfcitynumber = '"+cityNumber+"'"+sqlStr; 
    	                	//DbUtil.execute(ctx, deletesql);
    	                	String deletesql = " delete  CT_PAY_ClinicAchieveCosthSum where cfbusinessdate = '"+businessDate+"' and cfcitynumber = '"+cityNumber+"'" ;
    	                	DbUtil.execute(ctx, deletesql);
    	                	deletesql =" delete  CT_PAY_AchienementSum where cfbusinessdate = '"+businessDate+"' and cfcitynumber = '"+cityNumber+"'";
    	                	DbUtil.execute(ctx, deletesql);
    	                	deletesql =" delete  CT_PAY_ClinicCostSum where cfbusinessdate = '"+businessDate+"' and cfcitynumber = '"+cityNumber+"'"; 
    	                	DbUtil.execute(ctx, deletesql);
    	                	
    	                	deletesql =" delete  CT_PAY_ScalingCountSum where cfbusinessdate = '"+businessDate+"' and cfcitynumber = '"+cityNumber+"'"; 
    	                	DbUtil.execute(ctx, deletesql);
    	            } 
					docDetail.doBeiJing(ctx,businessDate,userId,cityID,cityNumber,cityName,flag);
					//if(cityNumber.equals("MS1101") || cityNumber.equals("MS4408") ){ 
				}
        	}
		} catch (Exception e) {
			e.printStackTrace(); 
		}  
	}
	

	private void doInsertSqls(Context ctx, String dataBase,List<String> sqls){
		try {
			int size = sqls.size();
			int qian = (int)Math.ceil(size/10000);
			if(size%10000 >0){
				qian ++;
			}
			for(int i = 0 ; i < qian ; i++){
				List<String> sumSqls =  new ArrayList<String>();
			
				if(size < (i+1)*10000 ){
					sumSqls = sqls.subList(i*10000, size);
				}else{
					sumSqls = sqls.subList(i*10000, (i+1)*10000);
				}
				EAISynTemplate.executeBatch(ctx, dataBase, sumSqls);
			
			}
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} 

	/**
	 * 同步收费项目校验
	 */
	@Override
	protected void _SyncClinicCheck(Context ctx, String dataBase)
			throws BOSException {
		
		/*ItemCheckCollection itemCollection = ItemCheckFactory.getLocalInstance(ctx).getItemCheckCollection("where city = 'Yv1mDb4vQwW9pjZPUs6iVsznrtQ=' ");
		
		
		HashMap<String, String> cityMap = new HashMap<String, String>();
		String citysql = "    select orgadmin.fid as fid  ,orgadmin.fname_l2 as fname   from  CT_PAY_PayCity  paycity left join t_org_admin orgadmin on orgadmin.fid = paycity.CFCityID   where paycity.CFCityID  not  in (select distinct cfcityid from CT_SRQ_ItemCheck ) ";
		IRowSet cityrow = DbUtil.executeQuery(ctx, citysql);
		
		try {
			while(cityrow.next()){
				String name =  cityrow.getString("FNAME"); 
				String fid = cityrow.getString("FID");   
				
				
				AdminOrgUnitInfo admin = new AdminOrgUnitInfo();
				admin.setId(BOSUuid.read(fid));
				
				CoreBaseCollection newitemCollection = new CoreBaseCollection();
				
				Iterator<ItemCheckInfo> it = itemCollection.iterator() ;
				while(it.hasNext()) {
					ItemCheckInfo item = it.next() ;
					
					ItemCheckInfo newitem = new ItemCheckInfo(); 
					newitem.setCity(admin);
					newitem.setTypeNumber(item.getTypeNumber());
					newitem.setTypeName(item.getTypeName());
					String id = ItemCheckFactory.getLocalInstance(ctx).save(newitem).toString();
					newitem.setId(BOSUuid.read(id)); 
					ItemCheckEntryCollection entry =  item.getEntrys();
					Iterator<ItemCheckEntryInfo> entryit = entry.iterator() ;
					while(entryit.hasNext()) {
						ItemCheckEntryInfo entryinfo = entryit.next() ;
						ItemCheckEntryInfo newentry = new  ItemCheckEntryInfo();
						newentry = entryinfo;
						newentry.setId(null);
						newentry.setParent(newitem);
						ItemCheckEntryFactory.getLocalInstance(ctx).save(newentry);
					}  
					newitemCollection.add(newitem);  
				}  
				//ItemCheckFactory.getLocalInstance(ctx).save(newitemCollection);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		/*Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.MONTH, -1); 
        Date date3 = cal.getTime();
        SimpleDateFormat format3= new SimpleDateFormat("yyyyMM");
        String lastbusiness = format3.format(date3);   
        
		if(businessDate == null || businessDate.equals("") || businessDate.equals("1")){
			
	        Calendar cal2 = Calendar.getInstance();
	        cal2.setTime(new Date()); 
	        
	        Date date2 = cal2.getTime();
	        SimpleDateFormat format2= new SimpleDateFormat("yyyyMM");
	        businessDate = format2.format(date2);   
		}else{
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
			Date date = null;
			String monthFormat;
			try {
				date = sdf.parse(businessDate );
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Calendar c = Calendar.getInstance();
			c.setTime(date);
			c.add(Calendar.MONTH, -1); 
			Date lastdate = c.getTime();
			SimpleDateFormat format= new SimpleDateFormat("yyyyMM");
		    lastbusiness = format.format(lastdate);  
		}
		 
		try { 
			
			//渠道折扣配置 
			CoreBaseCollection newCityChannelCollection = new CoreBaseCollection();
			if(!CityChannelFactory.getLocalInstance(ctx).exists(" where businessdate = '"+businessDate+"'") && CityChannelFactory.getLocalInstance(ctx).exists(" where businessdate = '"+lastbusiness+"'")){
				CityChannelCollection collection  =  CityChannelFactory.getLocalInstance(ctx).getCityChannelCollection(" where businessdate = '"+lastbusiness+"'");
				for(int i = 0 ; i < collection.size() ; i++){
					CityChannelInfo info = collection.get(i); 
					CityChannelInfo newInfo = (CityChannelInfo) info.clone();
					newInfo.setBusinessDate(businessDate);
					newInfo.setId(null);
					newCityChannelCollection.add(newInfo);
				}
			}
			CityChannelFactory.getLocalInstance(ctx).save(newCityChannelCollection);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/ 
		 
		//update CT_PAY_AchieveDetailTem SET  cfcountachieve = cfincome , cfzxachieve  = cfincome ,  cfdocachieve = cfincome   where cfcitynumber = 'MS1101'


		//update CT_PAY_AchieveDetailTem SET  cfcountachieve = cfpayment , cfzxachieve  = cfpayment ,  cfdocachieve = cfpayment   where cfcitynumber != 'MS1101'
		try{
			String citysql = "/*dialect*/  select  to_char(fbizdate, 'yyyymm')  businessdate ,cfcitynumber  as citynumber  from    CT_PAY_AchieveDetailTem  where   cfcitynumber = 'MS1101'  AND  to_char(fbizdate, 'yyyymm') = '202009' group  by  to_char(fbizdate, 'yyyymm') ,cfcitynumber ";
	    	IRowSet cityrow = DbUtil.executeQuery(ctx, citysql); 
			while(cityrow.next()){ 
				String citynumber = cityrow.getString("CITYNUMBER"); 
				String businessdate = cityrow.getString("BUSINESSDATE"); 
				
				String incityStr =  " in ('MS3101','CG01') ";
				if(citynumber.equals("MS3101") || citynumber.equals("CG01") ){
					incityStr =  " in ('MS3101','CG01') ";
				}else{
					incityStr =  "in ('"+citynumber+"')";
				}
				
				//SyncEHRAchieveUtil.SyncAchieveRepot(  ctx, businessdate, cityNumber,type);
				String gifamount = "0";
				String freework = "0";
				String docSql = " /*dialect*/  select company.fnumber,nvl(doc.CFGIFAMOUNTPRO,0) as  CFGIFAMOUNTPRO , nvl(doc.CFFREEWORKPRO,0) as CFFREEWORKPRO  from  CT_PAY_DocCurrencyPro doc   left join t_org_company company on company.fid = doc.cfcityid    where  doc.cfbusinessdate = '"+businessdate+"'  and company.fnumber "+incityStr+" ";
				IRowSet doccityrow = DbUtil.executeQuery(ctx, docSql); 
				while(doccityrow.next()){
					gifamount = doccityrow.getString("CFGIFAMOUNTPRO").equals("")? "0": doccityrow.getString("CFGIFAMOUNTPRO");   
					freework =  doccityrow.getString("CFFREEWORKPRO").equals("")? "0": doccityrow.getString("CFFREEWORKPRO");    
					 
					if(citynumber.equals("MS3101") || citynumber.equals("CG01")){
						String sql1 = "/*dialect*/  update CT_PAY_AchieveDetailTem set   cfcountachieve =  nvl( cforiprice*cfqty *"+freework+",0) , cfdocachieve =  nvl( cforiprice*cfqty *"+freework+",0)  , cfzxachieve =  nvl( cforiprice*cfqty *"+freework+",0)  "
		    			+"where  cfcitynumber "+incityStr+"  and  to_char(fbizdate,'YYYYMM') = '"+businessdate+"'  and cfincome  =0  and  cfpayment =0 and cfbusitype = '挂号消费'"; 
		    			DbUtil.execute(ctx, sql1);
		    			
		    			String sqlfreework = "/*dialect*/  update CT_PAY_AchieveDetailTem set cfcountachieve =  (nvl(cfpayment,0)-(nvl(cfgiftpayment,0)*"+gifamount+")) , cfdocachieve =  (nvl(cfpayment,0)-(nvl(cfgiftpayment,0)*"+gifamount+"))   , cfzxachieve =  (nvl(cfpayment,0)-(nvl(cfgiftpayment,0)*"+gifamount+")) "
		    			+" where  cfcitynumber "+incityStr+"  and  to_char(fbizdate,'YYYYMM') = '"+businessdate+"'   and (cfincome!=0 or cfpayment!=0) ";
		    			DbUtil.execute(ctx, sqlfreework); 
					}
				} 
				
				
				
				String  channelsql = " /*dialect*/ select  nvl(channel.fsimplename,'CFPAYMENT') as payziduan  ,cfchannelType , cfchannel  , cfdiscount ,nvl(cfincludezx,0)  as includezx, nvl(cfincludedoc,0)  as includedoc  from CT_PAY_CityChannel channel left join t_org_company company on company.fid = channel.cfcityid  "
					+"  where  channel.cfbusinessdate = '"+businessdate+"' and company.fnumber "+incityStr+" ";
				IRowSet channelrow = DbUtil.executeQuery(ctx, channelsql); 
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
							SyncEHRAchieveUtil.updateAchieve( ctx, incityStr,  businessdate, channelType, cfchannel, discount,"ZX",gifamount,freework);
						}
						if(includedoc != null && "1".equals(includedoc)){
							SyncEHRAchieveUtil.updateAchieve( ctx, incityStr,  businessdate, channelType, cfchannel, discount,"DOC",gifamount,freework);
						}
					}
					
				
				}
			}
		}catch (Exception e) { 
			e.printStackTrace(); 
		}
		
		
		
		
		
		
		/*String str = "T_BC_BIZACCOUNTOUTBILL";
		
		BizAccountOutBillInfo  accountInfo =  new  BizAccountOutBillInfo();
		PersonInfo  applyPerson = new PersonInfo();
		applyPerson.setId(BOSUuid.read("MXaw2cvIQTOFbJy4xxoD7IDvfe0="));
		accountInfo.setApplier(applyPerson);//申请人
		
		PositionInfo positionInfo = new  PositionInfo();
		accountInfo.setPosition(positionInfo);//职位
		
		
		accountInfo.get("paid");
		accountInfo.setTel("187166666666");//联系电话
		accountInfo.setAccessoryCount(0);//附件数
		accountInfo.setCause("");//事由
		AdminOrgUnitInfo applyAdmin = new AdminOrgUnitInfo();
		applyAdmin.setId(BOSUuid.read("00000000-0000-0000-0000-000000000000CCE7AED4"));
		accountInfo.setOrgUnit(applyAdmin);//申请部门
		accountInfo.setBizReqDate(new Date());//申请日期
		accountInfo.setPrior(PriorEnum.LOW);//紧急程度
		accountInfo.setState(StateEnum.NEW);//单据状态
		accountInfo.setBillDate(new Date());//制单日期
		
		UserInfo userInfo = new UserInfo();
		userInfo.setId(BOSUuid.read("00000000-0000-0000-0000-000000000000CCE7AED4"));
		accountInfo.setBiller(userInfo);//制单人
		accountInfo.setBillTypeCode(BizCollBillTypeEnum.BIZ_ACCOUNT_OUT );//单据类型
		 
		accountInfo.setApplierUser(userInfo);//申请人（用户）
		
		
		CostCenterOrgUnitInfo costCenterInfo  = new  CostCenterOrgUnitInfo();
		accountInfo.setCostedDept(costCenterInfo);//费用支付部门
		
		
		CompanyOrgUnitInfo  companyInfo  = new CompanyOrgUnitInfo ();
		companyInfo.setId(BOSUuid.read("00000000-0000-0000-0000-000000000000CCE7AED4"));
		accountInfo.setCompany(companyInfo);//公司
		
		CurrencyInfo  currencyInfo  = new CurrencyInfo ();
		currencyInfo.setId(BOSUuid.read("dfd38d11-00fd-1000-e000-1ebdc0a8100dDEB58FDC")); 
		accountInfo.setCurrencyType(currencyInfo);//币别
		BigDecimal amoount = new BigDecimal("0");
		accountInfo.setAmount(amoount);//合计金额
		
		BigDecimal budgetAmount = new BigDecimal("0");
		accountInfo.setBudgetAmount(budgetAmount);//预计数额
		
		BigDecimal budgetBalance = new BigDecimal("0");
		accountInfo.setBudgetBalance(budgetBalance);//预算差额
	 
		BigDecimal amountApproved = new BigDecimal("0");
		accountInfo.setAmountApproved(amountApproved);//核定金额
		
		BigDecimal amountSendedBack = new BigDecimal("0");
		accountInfo.setAmountSendedBack(amountSendedBack);//还款金额
		
		BigDecimal amountStriked = new BigDecimal("0");
		accountInfo.setAmountStriked(amountStriked);//冲账
		
		BigDecimal amountEncashed = new BigDecimal("0");
		accountInfo.setAmountEncashed(amountEncashed);//付现
		
		BigDecimal amountRefunded = new BigDecimal("0");
		accountInfo.setAmountRefunded(amountRefunded);//应退款
		
		accountInfo.setAccessoryCount(0);
		
		BigDecimal amountCopy = new BigDecimal("0");
		accountInfo.setAmountCopy(amountCopy);//合计金额副本
		
		accountInfo.setFiVouchered(false);//是否生成凭证
		accountInfo.setAmountUsed(BigDecimal.ZERO);//以用金额
		accountInfo.setAmountBalance(BigDecimal.ZERO);//可用金额
		accountInfo.setAmountControlType(AmountControlTypeEnum.oneTOone );//可超额控制
		
		CompanyOrgUnitInfo  appcompanyInfo  = new CompanyOrgUnitInfo ();
		appcompanyInfo.setId(BOSUuid.read("00000000-0000-0000-0000-000000000000CCE7AED4"));
		accountInfo.setApplierCompany(appcompanyInfo);//申请人公司
		
		accountInfo.setIsOverBudget(false);//是否超预算
		
		BigDecimal amountPaid = new BigDecimal("0");
		accountInfo.setAmountPaid(amountPaid);//已付金额
		
		BigDecimal amountNotPaid = new BigDecimal("0");
		accountInfo.setAmountNotPaid(amountNotPaid);//未付金额
		
		BigDecimal amountPayable = new BigDecimal("0");
		accountInfo.setAmountPayable(amountPayable);//应付金额
		
		accountInfo.setIsWithTax(false);//是否含税
		
		 
		
		//对外报销单分录
		BizAccountOutBillEntryInfo  entry =  new  BizAccountOutBillEntryInfo();
		OperationTypeInfo  operationTypeInfo = new OperationTypeInfo();
		operationTypeInfo.setId(BOSUuid.read("z69WGhxuTGS7nR5KBBTmhsmL+aM="));
		entry.setOperationType(operationTypeInfo);//业务类别
		
		CostCenterOrgUnitInfo  costCenterOrgUnitInfo  = new CostCenterOrgUnitInfo ();
		costCenterOrgUnitInfo.setId(BOSUuid.read("00000000-0000-0000-0000-000000000000CCE7AED4"));
		entry.setCostCenter(costCenterOrgUnitInfo);//费用承担部门
		
		CompanyOrgUnitInfo  companyOrgUnitInfo  = new CompanyOrgUnitInfo ();
		companyOrgUnitInfo.setId(BOSUuid.read("00000000-0000-0000-0000-000000000000CCE7AED4"));
		entry.setCompany(companyOrgUnitInfo);//费用承担公司


		entry.setReceiveState(EntryStateEnum.UNDONE );//应收状态 
		entry.setPayState(EntryStateEnum.UNDONE );//应付状态
		entry.setHappenTime(new Date());//发生时间
		
		BigDecimal amount = new BigDecimal("0");
		entry.setAmount(amount);//金额
		
		BigDecimal entryAmountApproved = new BigDecimal("0");
		entry.setAmountApproved(entryAmountApproved);//核定金额
		
		BigDecimal entryBudgetDo = new BigDecimal("0");
		entry.setBudgetDo(entryBudgetDo);//预算扣减值
		 
		ExpenseTypeInfo expenseTypeInfo = new ExpenseTypeInfo();
		expenseTypeInfo.setId(BOSUuid.read("N9cSMi2xTEahpEqkakb1UnjkvJQ="));
		entry.setExpenseType(expenseTypeInfo);//费用类型 
		
		BigDecimal entryBudgetUsed = new BigDecimal("0");
		entry.setBudgetUsed(entryBudgetUsed);//使用的预算
		
		
		entry.setCurrencyType(currencyInfo);//币别
		
		entry.setExchangeRate(BigDecimal.ONE);//汇率
		//entry.setConvertMode(ConvertModeEnum.ENDPERIODEXCHANGERATE );//汇率则算方式
		
		
		entry.setBudgetBalance(BigDecimal.ZERO);//可用预算
		
		
		BigDecimal entryAmountApprovedOri = new BigDecimal("0"); 
		entry.setAmountApprovedOri(entryAmountApprovedOri);//核定金额原币
		
		entry.setExchangeRatePrecision(4);//汇率精度
		
		BigDecimal entryAmountOri = new BigDecimal("0");
		entry.setAmountOri(entryAmountOri);//金额原币
		BigDecimal taxRate = new BigDecimal("0");
		entry.setTaxRate(taxRate);//税率
		BigDecimal tax = new BigDecimal("0");
		entry.setTax(tax);//税额
		
		
		BigDecimal entryTaxApproved = new BigDecimal("0");
		entry.setTaxApproved(entryTaxApproved);//核定税额
		
		BigDecimal entryAmountApprovedWithoutTax = new BigDecimal("0");
		entry.setAmountApprovedWithoutTax(entryAmountApprovedWithoutTax);//原币核定不含税额
		  
		BigDecimal entryAmountOriWithoutTax = new BigDecimal("0");
		entry.setAmountOriWithoutTax(entryAmountOriWithoutTax);//原币核定不含金额
		 
		
		BigDecimal entryAmountWithoutTax = new BigDecimal("0");
		entry.setAmountWithoutTax(entryAmountWithoutTax);//不含税金额
		 
		
		entry.setPurpose("");//费用用途
		//entry.setInvoiceNum("1");//发票数量
		accountInfo.getEntries().add(entry);
		
		//accountInfo.get
		//T_BC_BizAOBAE   多收款人分录
		//收款信息  
		BizAccountOutBillAccountEntryInfo bizAccountOutBillEntryInfo = new BizAccountOutBillAccountEntryInfo(); 
		
		bizAccountOutBillEntryInfo.setPayerName("");//收款人
		bizAccountOutBillEntryInfo.setPayerBank("");//银行账号
		bizAccountOutBillEntryInfo.setCurrencyType(currencyInfo);//币别
		
		OpenAreaInfo openAreaInfo = new OpenAreaInfo();
		bizAccountOutBillEntryInfo.setOpenArea(openAreaInfo);//开户地
		bizAccountOutBillEntryInfo.setExchangeRate(BigDecimal.ONE);//汇率
		//bizAccountOutBillEntryInfo.setConvertMode(ConvertModeEnum.ENDPERIODEXCHANGERATE);//汇率折算方式
		bizAccountOutBillEntryInfo.setExchangeRatePrecision(4);//汇率精度
		
		BigDecimal accountAmount = new BigDecimal("0");
		bizAccountOutBillEntryInfo.setAmount(accountAmount);//本位币金额
		
		BigDecimal accountAmountOri = new BigDecimal("0");
		bizAccountOutBillEntryInfo.setAmountOri(accountAmountOri);//原币金额
		
		SettlementTypeInfo settlementTypeInfo = new SettlementTypeInfo();
		bizAccountOutBillEntryInfo.setPayMode(settlementTypeInfo );//支付方式
		
		bizAccountOutBillEntryInfo.setPayerType(PayerTypeEnum.supplier );//收款人类型
		
		BEBankInfo BEBankInfo  = new BEBankInfo(); 
		bizAccountOutBillEntryInfo.setPayerBankF7(BEBankInfo);//收款银行
		
		bizAccountOutBillEntryInfo.setBill(accountInfo);
		
		
		//T_BC_BizAccountOutBillPayEntry   付款明细分录
		
		
		//T_BC_BizOutTicketEntry  发票信息
		
		//	申请核销分录	申请核销分录		T_BC_BizAOBRCE
		
		
		//借款核销分录	借款核销分录		T_BC_BizAOBLCE
		try {
			BizAccountOutBillFactory.getLocalInstance(ctx).save(accountInfo);
			BizAccountOutBillAccountEntryFactory.getLocalInstance(ctx).save(bizAccountOutBillEntryInfo);
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}

	
}