package com.kingdee.eas.mw.pay.app.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.kingdee.bos.Context;  
import com.kingdee.eas.custom.util.DBUtil;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.jdbc.rowset.IRowSet;

public class PayMessage {


	public static HashMap getShopGoalMessage(Context ctx, String periodnum, String cityid,HashMap tempMap){
		try {
			//String postSql = "/*dialect*/ select distinct CFEMPNUMBER  from CT_PAY_PayPost  where cfstatus = 'qy' and cfpostName in ('运营经理','运营总监') ";
			String postSql = "/*dialect*/ select distinct CFEMPNUMBER,CFCLINICID  from CT_PAY_PayPost  where  cfcityid ='"+cityid+"' and  cfstatus = 'qy' and cfpostNumber =   'MZYYZJ' and cfbusinessdate ='"+periodnum+"' ";
			IRowSet rs = com.kingdee.eas.custom.util.DBUtil.executeQuery(ctx,postSql);
			if(rs!=null && rs.size() > 0){
				  while(rs.next()){	
					  tempMap.put(rs.getObject("CFEMPNUMBER")+"_MD", rs.getObject("CFCLINICID") );
				  }
			 }
			//String yySql = "  SELECT CFMONEY   FROM  CT_PAY_ShopGoalBonus   ";
			String yySql = "   select  paypost.CFEMPNUMBER  ,paypost.CFCLINICID, a.cfrewardamount as CFMONEY from CT_PAY_PayPost paypost left join  CT_PAY_BudgetDate budgetDate  on    paypost.CFCLINICID = budgetDate.cfcompanyid and budgetDate.cfbusinessdate ='"+periodnum+"'  " +
			" left join   CT_PAY_AchRoyaltyRule  a  on   budgetDate.cfclinicshop =  a.cfclinictype  and  a.cfcityid= '"+cityid+"'  where  paypost.cfcityid ='"+cityid+"' and  paypost.cfstatus = 'qy' and paypost.cfpostNumber =   'MZYYZJ' and paypost.cfbusinessdate ='"+periodnum+"' and a.cfbusinessdate = '"+periodnum+"'   ";
			IRowSet yyrs = com.kingdee.eas.custom.util.DBUtil.executeQuery(ctx,yySql);
			if(yyrs!=null && yyrs.size() > 0){
				  while(yyrs.next()){	
					  tempMap.put(yyrs.getObject("CFEMPNUMBER")+"_"+yyrs.getObject("CFCLINICID")+"_MONEY_MD", yyrs.getObject("CFMONEY") );
				  }
			 }
			 
			String sqlSJStr = " /*dialect*/  select   nvl(CFIncome,0)  as thiscount , nvl(cfdiary,0) as pay  ,CFCLINICID  from  CT_PAY_ClinicMonthSum where   cfbusinessdate =  '"+periodnum+"' and   cfcityid= '"+cityid+"'    ";
			
			IRowSet rsSJ =  DBUtil.executeQuery(ctx,sqlSJStr);
			if(rsSJ!=null && rsSJ.size() > 0){
				  while(rsSJ.next()){	
					  if("".equals( rsSJ.getString("CFCLINICID"))){
						  tempMap.put("null__SJMD", "");
					  }else{
						  tempMap.put(rsSJ.getString("CFCLINICID")+"_SJMD", rsSJ.getString("THISCOUNT"));
						  tempMap.put(rsSJ.getString("CFCLINICID")+"_SJPAY", rsSJ.getString("PAY"));
					  }
					   
				  }
			 } 
			
			String sqlMBStr = " /*dialect*/ SELECT  max(CFTarget) as thiscount ,CFCOMPANYID FROM CT_PAY_BudgetDate where CFBUSINESSDATE = '"+periodnum+"'  group by CFCOMPANYID ";
		
			IRowSet rsMBSR =  DBUtil.executeQuery(ctx,sqlMBStr);
			if(rsMBSR!=null && rsMBSR.size() > 0){
				  while(rsMBSR.next()){	
					  if("".equals( rsMBSR.getString("CFCOMPANYID"))){
						  tempMap.put("null_MBMD", "");
					  }else{
						  tempMap.put( rsMBSR.getString("CFCOMPANYID")+"_MBMD", rsMBSR.getString("THISCOUNT"));
					  }
				  }
			 } 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tempMap;
	}
	
	/**
	 * 获得其他绩效相关信息
	 * @param ctx
	 * @param periodnum
	 * @param tempMap
	 * @return
	 */
	public static HashMap getOtherMessage(Context ctx, String periodnum, String cityID,HashMap tempMap){
		try {
			 
			String postSql = "/*dialect*/ select distinct CFEMPNUMBER ,CFCLINICID from CT_PAY_PayPost  where  cfcityid ='"+cityID+"' and  cfstatus = 'qy'  and CFPOSTNUMBER ='MZYYZJ'  and  cfbusinessdate ='"+periodnum+"' and cfempnumber not in ( select distinct cfempnumber from CT_PAY_AchRoyaltyRule   where cfempnumber is not null and cfcityid= '"+cityID+"'  and  cfbusinessdate = '"+periodnum+"' ) ";
			//
			IRowSet rs = com.kingdee.eas.custom.util.DBUtil.executeQuery(ctx,postSql);
			if(rs!=null && rs.size() > 0){
				  while(rs.next()){	
					  tempMap.put(rs.getObject("CFEMPNUMBER")+"_OT", rs.getObject("CFCLINICID") );
				  }
			 }   
			//String postSql2 = "/*dialect*/ select distinct CFEMPNUMBER  from CT_PAY_PayPost  where cfstatus = 'qy' and  (  cfempnumber  in ( select distinct cfempnumber from CT_PAY_AchRoyaltyRule  where cfempnumber is not null  ) ) ";
			String postSql2 = "/*dialect*/ select distinct cfempnumber from CT_PAY_AchRoyaltyRule  where cfempnumber is not null and  cfcityid= '"+cityID+"'  and  cfbusinessdate = '"+periodnum+"' ";
			IRowSet rs2 = com.kingdee.eas.custom.util.DBUtil.executeQuery(ctx,postSql2);
			if(rs2!=null && rs2.size() > 0){
				  while(rs2.next()){	
					  tempMap.put(rs2.getObject("CFEMPNUMBER")+"_OT2", "2" );
				  }
			 } 
			
			//String ruleSql = "/*dialect*/ select FNUMBER,CFEMPNUMBER,CFCITYNUMBER,CFBASEACH,CFSHOPPRO,CFPERSONPRO,CFBUSINESSPRO,CFREDUCEAMOUNT,CFREWARDAMOUNT,CFCLINICNUMBER  from CT_PAY_AchRoyaltyRule  where cfstatus = 'qy'   ";
			
			String ruleSql =  " /*dialect*/  select a.cfothernumber as FNUMBER,a.cfclinictype as clinicsize,a.CFEMPNUMBER,a.CFCITYID,a.CFBASEACH,a.CFSHOPPRO,a.CFPERSONPRO,a.CFBUSINESSPRO,a.CFREDUCEAMOUNT,a.CFREWARDAMOUNT,a.CFCLINICID,a.CFBASEPAY,a.CFCLINICBASEACH,(budgetDate.cftarget*10000) as target  from CT_PAY_AchRoyaltyRule  a "+
			" left join  CT_PAY_BudgetDate budgetDate  on    a.cfclinicid = budgetDate.cfcompanyid and budgetDate.cfbusinessdate ='"+periodnum+"'  where a.cfstatus = 'qy'  and  a.cfcityid='"+cityID+"' and    a.cfbusinessdate = '"+periodnum+"'";
			IRowSet rulers = com.kingdee.eas.custom.util.DBUtil.executeQuery(ctx,ruleSql);
			if(rulers!=null && rulers.size() > 0){
				  while(rulers.next()){	
					  HashMap map = new HashMap();
					  map.put("CFEMPNUMBER", rulers.getObject("CFEMPNUMBER"));
					  map.put("CLINICSIZE", rulers.getObject("CLINICSIZE"));
					  
					  map.put("CFCITYID", rulers.getObject("CFCITYID"));
					  map.put("CFBASEACH", rulers.getObject("CFBASEACH"));
					  map.put("CFSHOPPRO", rulers.getObject("CFSHOPPRO"));
					  map.put("CFPERSONPRO", rulers.getObject("CFPERSONPRO"));
					  map.put("CFBUSINESSPRO", rulers.getObject("CFBUSINESSPRO"));
					  map.put("CFREDUCEAMOUNT", rulers.getObject("CFREDUCEAMOUNT"));
					  map.put("CFREWARDAMOUNT", rulers.getObject("CFREWARDAMOUNT")); 
					  map.put("CFCLINICID", rulers.getObject("CFCLINICID")); 
					  map.put("TARGET", rulers.getObject("TARGET")); 
					  if(null == rulers.getObject("FNUMBER") || "".equals(rulers.getObject("FNUMBER").toString())){
						  tempMap.put(rulers.getObject("CLINICSIZE")+"_OTHER", map  );
					  }else{
						  tempMap.put(rulers.getObject("FNUMBER")+"_OTHER", map  );
					  }
					  
					  //绩效提成规则配置基础资料中    编码使用员工编码加    _OTHER   形成
				  }
			}
			
			//在预算表中获得门店的大小
			String yySql = "  SELECT  CFCLINICSHOP ,CFCOMPANYID,CFTARGET  FROM  CT_PAY_BudgetDate where CFBUSINESSDATE = '"+periodnum+"' ";
			IRowSet ysbrs = com.kingdee.eas.custom.util.DBUtil.executeQuery(ctx,yySql);
			if(ysbrs!=null && ysbrs.size() > 0){
				  while(ysbrs.next()){	
					  tempMap.put(ysbrs.getObject("CFCOMPANYID")+"_OT_SHOPYY", ysbrs.getString("CFCLINICSHOP") );
					  tempMap.put(ysbrs.getObject("CFCOMPANYID")+"_OT_SHOPTARGET", ysbrs.getObject("CFTARGET") );
				  }
			}
			 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tempMap;
	}
	/**
	 * 获得咨询师相关信息
	 * @param ctx
	 * @param periodnum
	 * @param tempMap
	 * @return
	 */
	public static HashMap getZiXunMessage(Context ctx, String periodnum,String cityid ,HashMap tempMap){
		try {
			String postSql = "/*dialect*/ select distinct CFEMPNUMBER  from CT_PAY_PayPost  where  cfcityid ='"+cityid+"' and  cfstatus = 'qy' and cfpostNumber =  'ZXS' and  cfbusinessdate ='"+periodnum+"' ";
			IRowSet rs = com.kingdee.eas.custom.util.DBUtil.executeQuery(ctx,postSql);
			if(rs!=null && rs.size() > 0){
				  while(rs.next()){	
					  tempMap.put(rs.getObject("CFEMPNUMBER")+"_ZX", "1" );
				  }
			}   
			
			HashMap<String,String> typeMap = new HashMap<String,String>();
			 
			//因为 咨询师的提成比例不是根据所造门诊的牙椅数量决定的  而是根据自己和门诊所谈的提成来区分大店小店的  所以 每个咨询师对于不同的门诊自带提成比例
			String zxbilisql = "  /*dialect*/ SELECT cfempnumber, cfcontypeid FROM  CT_PAY_EmpShopDeploy where cfbusinessdate= '"+periodnum+"' and  cfcityid= '"+cityid+"'  ";
			IRowSet zxbilirs = com.kingdee.eas.custom.util.DBUtil.executeQuery(ctx,zxbilisql);
			if(zxbilirs!=null && zxbilirs.size() > 0){
				  while(zxbilirs.next()){	 
					  tempMap.put(zxbilirs.getString("CFEMPNUMBER")+"_"+"_SHOP", zxbilirs.getString("CFCONTYPEID")); 
					  typeMap.put(zxbilirs.getString("CFCONTYPEID"), zxbilirs.getString("CFCONTYPEID"));
				  }
			}
			
			
			
			int  biaozhunYY = 8;
			//获得门店标准
			String mdSql = " /*dialect*/  SELECT   cfshopsize as  fnumber ,  nvl(cfyysl,0) as cfyysl ,cffirst,cffirstmoney,cfsecond,cfsecondmoney,cfthird FROM CT_PAY_ConsultantPro  where  cfcityid= '"+cityid+"' and cfbusinessdate= '"+periodnum+"' ";
			IRowSet mdrs = com.kingdee.eas.custom.util.DBUtil.executeQuery(ctx,mdSql);
			if(mdrs!=null && mdrs.size() > 0){
				  while(mdrs.next()){	
					  HashMap map = new HashMap();
					  map.put("CFFIRST", mdrs.getObject("CFFIRST"));
					  map.put("CFFIRSTMONEY", mdrs.getObject("CFFIRSTMONEY"));
					  map.put("CFSECOND", mdrs.getObject("CFSECOND"));
					  map.put("CFSECONDMONEY", mdrs.getObject("CFSECONDMONEY"));
					  map.put("CFTHIRD", mdrs.getObject("CFTHIRD"));
					  biaozhunYY = Integer.parseInt(mdrs.getObject("CFYYSL").toString());
					  tempMap.put(mdrs.getObject("FNUMBER")+"_YY", map );
				  }
				  tempMap.put( "biaozhunYY", biaozhunYY  );
			}
		  
			for (Map.Entry<String, String> entry : typeMap.entrySet()) {
	            String typeid = entry.getKey();
	            //获得咨询阶段提成比例
				String zxjdSql = " /*dialect*/  SELECT   cftypeid, cfbeginamount,cfendamount,cfpro  FROM CT_PAY_ConsultStage  where  cftypeid = '"+typeid+"' and cfcityid= '"+cityid+"'  and cfbusinessdate= '"+periodnum+"'   order by  cftypeid  , cfbeginamount ";
				IRowSet zxjdrs = com.kingdee.eas.custom.util.DBUtil.executeQuery(ctx,zxjdSql);
				ArrayList<HashMap<Object, Object>> arraylist = new ArrayList<HashMap<Object, Object>> ();
				if(zxjdrs!=null && zxjdrs.size() > 0){
					while(zxjdrs.next()){	
					  HashMap map = new HashMap();
					  String type = zxjdrs.getString("CFTYPEID");
					  map.put("CFBEGINAMOUNT", zxjdrs.getObject("CFBEGINAMOUNT"));
					  map.put("CFENDAMOUNT", zxjdrs.getObject("CFENDAMOUNT"));
					  map.put("CFPRO", zxjdrs.getObject("CFPRO")); 
					  arraylist.add(map);
					  //Collections.reverse(list);//将list集合倒序排列取出,时间最新的在最上面
				  	} 		  
				}
				tempMap.put(typeid+"_"+cityid, arraylist); 
	        }
			 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tempMap;
	}
	
	/**
	 * 获得洁牙师相关信息
	 * @param ctx
	 * @param tempMap
	 * @return
	 */
//	public static HashMap getYJmbMessage(Context ctx,String periodnum, String cityid,HashMap tempMap){
//		try {
//			String includeDoc = "";
//			Map<String,String> map = new HashMap<String,String>();
//			//洁牙  派力奥  单价
//			String priceSql = "/*dialect*/ SELECT cfjynumber as FNUMBER ,cfprice,cfincludeDoc FROM CT_PAY_ScalingBonus  where cfcityid = '"+cityid+"' and  cfbusinessdate ='"+periodnum+"' ";
//			IRowSet pricers = com.kingdee.eas.custom.util.DBUtil.executeQuery(ctx,priceSql);
//			if(pricers!=null && pricers.size() > 0){
//				  while(pricers.next()){	
//					  tempMap.put(pricers.getObject("FNUMBER")+"JY", pricers.getObject("CFPRICE") ); 
//					  map.put(pricers.getObject("CFINCLUDEDOC").toString(),pricers.getObject("CFINCLUDEDOC").toString());
//				  }
//			}
//			String jysSql = "";
//			if(map.size()== 1 && map.get("Y")!= null){
//				includeDoc = "Y";
//			}else{
//				includeDoc = "N";
//			}
//			if(!"UCHn/mwiRumqGu9pJIgV4MznrtQ=".equals(cityid)){ 
//				if(includeDoc.equals("Y")){
//					jysSql = "/*dialect*/ select distinct CFEMPNUMBER  from CT_PAY_PayPost  where  cfcityid ='"+cityid+"' and  cfstatus = 'qy' and cfpostnumber in ( 'JYS' ,'YS','JZYS') and  cfbusinessdate ='"+periodnum+"'";
//				}else{
//					jysSql = "/*dialect*/ select distinct CFEMPNUMBER  from CT_PAY_PayPost  where   cfcityid ='"+cityid+"' and cfstatus = 'qy' and cfpostnumber in ( 'JYS') and  cfbusinessdate ='"+periodnum+"'  ";
//				} 
//				//美白提成比例
//				String mbbiliSql = "/*dialect*/ select distinct CFPROPORTION   from CT_PAY_WHITEPROPORTION   where cfcityid = '"+cityid+"' and  cfbusinessdate ='"+periodnum+"'   ";
//				IRowSet mbbilirs = com.kingdee.eas.custom.util.DBUtil.executeQuery(ctx,mbbiliSql);
//				if(mbbilirs!=null && mbbilirs.size() > 0){
//					  while(mbbilirs.next()){	 
//						  tempMap.put("MBBILI", mbbilirs.getString("CFPROPORTION") );
//						   
//					  }
//				}
//			}else if("UCHn/mwiRumqGu9pJIgV4MznrtQ=".equals(cityid)){
//				if(includeDoc.equals("Y")){
//					jysSql = "/*dialect*/ select distinct CFEMPNUMBER  from CT_PAY_PayPost  where  cfcityid ='"+cityid+"' and  cfstatus = 'qy' and cfpostnumber in ( 'JYS' ,'HS','YS','JZYS') and  cfbusinessdate ='"+periodnum+"'";
//				}else{
//					jysSql = "/*dialect*/ select distinct CFEMPNUMBER  from CT_PAY_PayPost  where   cfcityid ='"+cityid+"' and cfstatus = 'qy' and cfpostnumber in ( 'JYS','HS') and  cfbusinessdate ='"+periodnum+"'  ";
//				} 
//			}
//			IRowSet jysrs = com.kingdee.eas.custom.util.DBUtil.executeQuery(ctx,jysSql);
//			if(jysrs!=null && jysrs.size() > 0){
//				  while(jysrs.next()){	
//					  tempMap.put(jysrs.getObject("CFEMPNUMBER")+"JY", jysrs.getObject("CFEMPNUMBER") ); 
//				  }
//			} 
//			String mbSql = "/*dialect*/ select distinct CFEMPNUMBER  from CT_PAY_PayPost  where   cfcityid ='"+cityid+"' and  cfstatus = 'qy' and cfpostnumber ='JYS' and  cfbusinessdate ='"+periodnum+"' ";
//			IRowSet mbsrs = com.kingdee.eas.custom.util.DBUtil.executeQuery(ctx,mbSql);
//			if(mbsrs!=null && mbsrs.size() > 0){
//				  while(mbsrs.next()){	 
//					  tempMap.put(mbsrs.getObject("CFEMPNUMBER")+"MB", mbsrs.getObject("CFEMPNUMBER") );
//				  }
//			 }
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return tempMap;
//	}
	
	public static HashMap getYJmbMessage(Context ctx,String periodnum, String cityid,HashMap tempMap){
		try {
			String includeDoc = "";
			Map<String,String> map = new HashMap<String,String>();
			//获得洁牙类型
			String jytypeSql = "/*dialect*/ SELECT item.CFTypeNumber CFTYPENUMBER,item.CFTypeName CFTYPENAME ,scaling.cfjynumber CFJYNUMBER  , item.cfjytypeid  TYPEID FROM CT_SRQ_ItemCheck item "+
			"left join  CT_PAY_ScalingType scaling on scaling.fid = item.cfjytypeid  and scaling.cfcityid = '"+cityid+"'   where item.cfjytypeid is not null and item.cfcityid = '"+cityid+"' ";
			IRowSet jytypers = com.kingdee.eas.custom.util.DBUtil.executeQuery(ctx,jytypeSql);
			ArrayList<String> arrayList = new ArrayList<String>();
			if(jytypers!=null && jytypers.size() > 0){
				  while(jytypers.next()){	
					  HashMap typemap = new HashMap();
					  arrayList.add(jytypers.getObject("CFTYPENUMBER")+"#"+jytypers.getObject("CFTYPENAME")+"#"+jytypers.getObject("CFJYNUMBER")+"#"+jytypers.getObject("TYPEID"));  
				  }
			}
			tempMap.put(cityid+"_JY", arrayList );  
			//是否包含医生
			String priceSql = "/*dialect*/ SELECT distinct cfincludeDoc FROM CT_PAY_ScalingBonus  where cfcityid = '"+cityid+"' and  cfbusinessdate ='"+periodnum+"' ";
			IRowSet pricers = com.kingdee.eas.custom.util.DBUtil.executeQuery(ctx,priceSql);
			if(pricers!=null && pricers.size() > 0){
				  while(pricers.next()){	 
					  map.put(pricers.getObject("CFINCLUDEDOC").toString(),pricers.getObject("CFINCLUDEDOC").toString());
				  }
			}
			
			String jysSql = "";
			if(map.size()== 1 && map.get("Y")!= null){
				includeDoc = "Y";
			}else{
				includeDoc = "N";
			}
			if(!"UCHn/mwiRumqGu9pJIgV4MznrtQ=".equals(cityid)){ 
				if(includeDoc.equals("Y")){
					jysSql = "/*dialect*/ select distinct CFEMPNUMBER  from CT_PAY_PayPost  where  cfcityid ='"+cityid+"' and  cfstatus = 'qy' and cfpostnumber in ( 'JYS' ,'YS','JZYS') and  cfbusinessdate ='"+periodnum+"'";
				}else{
					jysSql = "/*dialect*/ select distinct CFEMPNUMBER  from CT_PAY_PayPost  where   cfcityid ='"+cityid+"' and cfstatus = 'qy' and cfpostnumber in ( 'JYS') and  cfbusinessdate ='"+periodnum+"'  ";
				} 
				//美白提成比例
				String mbbiliSql = "/*dialect*/ select distinct CFPROPORTION   from CT_PAY_WHITEPROPORTION   where cfcityid = '"+cityid+"' and  cfbusinessdate ='"+periodnum+"'   ";
				IRowSet mbbilirs = com.kingdee.eas.custom.util.DBUtil.executeQuery(ctx,mbbiliSql);
				if(mbbilirs!=null && mbbilirs.size() > 0){
					  while(mbbilirs.next()){	 
						  tempMap.put("MBBILI", mbbilirs.getString("CFPROPORTION") );
						   
					  }
				}else{
					tempMap.put("MBBILI", "0" );
				}
			}else if("UCHn/mwiRumqGu9pJIgV4MznrtQ=".equals(cityid)){
				if(includeDoc.equals("Y")){
					jysSql = "/*dialect*/ select distinct CFEMPNUMBER  from CT_PAY_PayPost  where  cfcityid ='"+cityid+"' and  cfstatus = 'qy' and cfpostnumber in ( 'JYS' ,'HS','YS','JZYS') and  cfbusinessdate ='"+periodnum+"'";
				}else{
					jysSql = "/*dialect*/ select distinct CFEMPNUMBER  from CT_PAY_PayPost  where   cfcityid ='"+cityid+"' and cfstatus = 'qy' and cfpostnumber in ( 'JYS','HS') and  cfbusinessdate ='"+periodnum+"'  ";
				} 
			}
			IRowSet jysrs = com.kingdee.eas.custom.util.DBUtil.executeQuery(ctx,jysSql);
			if(jysrs!=null && jysrs.size() > 0){
				  while(jysrs.next()){	
					  tempMap.put(jysrs.getObject("CFEMPNUMBER")+"JY", jysrs.getObject("CFEMPNUMBER") ); 
				  }
			} 
			String mbSql = "/*dialect*/ select distinct CFEMPNUMBER  from CT_PAY_PayPost  where   cfcityid ='"+cityid+"' and  cfstatus = 'qy' and cfpostnumber ='JYS' and  cfbusinessdate ='"+periodnum+"' ";
			IRowSet mbsrs = com.kingdee.eas.custom.util.DBUtil.executeQuery(ctx,mbSql);
			if(mbsrs!=null && mbsrs.size() > 0){
				  while(mbsrs.next()){	 
					  tempMap.put(mbsrs.getObject("CFEMPNUMBER")+"MB", mbsrs.getObject("CFEMPNUMBER") );
				  }
			 }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tempMap;
	}
	
	/**
	 * 获得医生相关信息
	 * @param ctx
	 * @param periodnum
	 * @param tempMap
	 * @return
	 */
	public static HashMap getDocMessage(Context ctx, String periodnum , String cityID ,HashMap tempMap){
		try {
			//获得医生岗位
			String docSql = "/*dialect*/ select distinct CFEMPNUMBER  from CT_PAY_PayPost  where  cfcityid ='"+cityID+"' and  cfstatus = 'qy' and cfpostNumber in ( 'YS' ,'YZ') and  cfbusinessdate ='"+periodnum+"' ";
			IRowSet docrs = com.kingdee.eas.custom.util.DBUtil.executeQuery(ctx,docSql);
			if(docrs!=null && docrs.size() > 0){
				  while(docrs.next()){	
					  tempMap.put(docrs.getObject("CFEMPNUMBER")+"_DOC", docrs.getObject("CFEMPNUMBER") );
				  }
			}
			//获得兼职医生岗位
			String jzDocSql = "/*dialect*/ select distinct CFEMPNUMBER  from CT_PAY_PayPost  where  cfcityid ='"+cityID+"' and  cfstatus = 'qy' and cfpostNumber ='JZYS' and  cfbusinessdate ='"+periodnum+"' ";
			IRowSet jzDocrs = com.kingdee.eas.custom.util.DBUtil.executeQuery(ctx,jzDocSql);
			if(jzDocrs!=null && jzDocrs.size() > 0){
				  while(jzDocrs.next()){	
					  tempMap.put(jzDocrs.getObject("CFEMPNUMBER")+"_JZDOC", jzDocrs.getObject("CFEMPNUMBER") );
				  }
			} 
			//获得医生业绩及其医生特使固定比例
			String tlSql = "/*dialect*/ SELECT  CFMZNUMBER,CFEMPNUMBER,nvl(CFPERFORMANCEBASE ,0) CFPERFORMANCEBASE,nvl(CFZZPROPORTION ,0) CFZZPROPORTION,nvl(CFGDPROPORTION ,0) CFGDPROPORTION,nvl(CFYXPROPORTION ,0) CFYXPROPORTION,nvl(CFXFPROPORTION ,0) CFXFPROPORTION,nvl(CFEYPROPORTION ,0) CFEYPROPORTION,nvl(CFKNPROPORTION ,0) CFKNPROPORTION,nvl(CFMBPROPORTION ,0) CFMBPROPORTION,nvl(CFZBPROPORTION ,0) CFZBPROPORTION,nvl(CFQTPROPORTION,0) CFQTPROPORTION,nvl(CFZJBILI,1) CFZJBILI FROM  CT_PAY_DoctorPerformance where CFBUSINESSDATE='"+periodnum+"'  and cfcityid= '"+cityID+"'  ";
			IRowSet tlrs = com.kingdee.eas.custom.util.DBUtil.executeQuery(ctx,tlSql);
			if(tlrs!=null && tlrs.size() > 0){
				  while(tlrs.next()){	
					  HashMap map = new HashMap();
					  map.put("CFPERFORMANCEBASE", tlrs.getObject("CFPERFORMANCEBASE"));
					  map.put("CFZZPROPORTION", tlrs.getObject("CFZZPROPORTION"));
					  map.put("CFGDPROPORTION", tlrs.getObject("CFGDPROPORTION"));
					  map.put("CFYXPROPORTION", tlrs.getObject("CFYXPROPORTION"));
					  map.put("CFXFPROPORTION", tlrs.getObject("CFXFPROPORTION")); 
					  map.put("CFEYPROPORTION", tlrs.getObject("CFEYPROPORTION"));
					  map.put("CFKNPROPORTION", tlrs.getObject("CFKNPROPORTION"));
					  map.put("CFMBPROPORTION", tlrs.getObject("CFMBPROPORTION")); 
					  map.put("CFQTPROPORTION", tlrs.getObject("CFQTPROPORTION")); 
					  map.put("CFZJBILI", tlrs.getObject("CFZJBILI")); 
					  map.put("CFZBPROPORTION", tlrs.getObject("CFZBPROPORTION")); 
					  tempMap.put(tlrs.getObject("CFEMPNUMBER")+"_" +"TL_DOC", map );
				  }
			} 
			
			
			//获得医生通用比例
			String tongyongSql = "/*dialect*/ SELECT CFZZBL,CFGDJZBL,CFYXJZBL,CFYZZLBL,CFKNWBL,CFMBBL,CFXFBL,CFEYBL,CFZJBL, CFFREEWORKPRO,CFFIRSTSOURCE,CFSOURCEPRO,CFGIFAMOUNTPRO FROM CT_PAY_DocCurrencyPro  where  cfcityid= '"+cityID+"' and  CFBUSINESSDATE='"+periodnum+"' ";
			IRowSet tyblrs = com.kingdee.eas.custom.util.DBUtil.executeQuery(ctx,tongyongSql);
			if(tyblrs!=null && tyblrs.size() > 0){
				  while(tyblrs.next()){	
					  HashMap map = new HashMap();
					  map.put("CFZZBL", tyblrs.getObject("CFZZBL"));
					  map.put("CFGDJZBL", tyblrs.getObject("CFGDJZBL"));
					  map.put("CFYXJZBL", tyblrs.getObject("CFYXJZBL"));
					  map.put("CFYZZLBL", tyblrs.getObject("CFYZZLBL"));
					  map.put("CFKNWBL", tyblrs.getObject("CFKNWBL")); 
					  map.put("CFMBBL", tyblrs.getObject("CFMBBL"));
					  map.put("CFXFBL", tyblrs.getObject("CFXFBL"));
					  map.put("CFEYBL", tyblrs.getObject("CFEYBL")); 
					  map.put("CFZJBL", tyblrs.getObject("CFZJBL")); 
					  
					  map.put("CFFREEWORKPRO", tyblrs.getObject("CFFREEWORKPRO")); 
					  map.put("CFFIRSTSOURCE", tyblrs.getObject("CFFIRSTSOURCE")); 
					  map.put("CFSOURCEPRO", tyblrs.getObject("CFSOURCEPRO"));  
					  map.put("CFGIFAMOUNTPRO", tyblrs.getObject("CFGIFAMOUNTPRO"));  
					   
					  tempMap.put("TONGYONGBILI_DOC", map );
				  }
			}else{
				HashMap map = new HashMap();
				map.put("CFZZBL", "0");
				map.put("CFGDJZBL", "0");
				map.put("CFYXJZBL", "0");
				map.put("CFYZZLBL", "0");
				map.put("CFKNWBL", "0"); 
				map.put("CFMBBL", "0");
				map.put("CFXFBL", "0");
				map.put("CFEYBL", "0"); 
				map.put("CFZJBL", "0"); 
				  
				map.put("CFFREEWORKPRO", "0"); 
				map.put("CFFIRSTSOURCE", "0"); 
				map.put("CFSOURCEPRO", "0");  
				map.put("CFGIFAMOUNTPRO", "0");  
				   
				tempMap.put("TONGYONGBILI_DOC", map );
			} 
			//获得特殊医生 
			String teshuSql = "/*dialect*/ SELECT CFDOCNUMBER FROM CT_PAY_specialdoc where  cfcityid= '"+cityID+"' ";
			IRowSet teshurs = com.kingdee.eas.custom.util.DBUtil.executeQuery(ctx,teshuSql);
			if(teshurs!=null && teshurs.size() > 0){
				  while(tyblrs.next()){	 
					  tempMap.put(tyblrs.getObject("CFDOCNUMBER")+"_TESHUDOC", "1" );
				  }
			}
			//获得兼职医生   及其比例
			String jianzhiSql = "/*dialect*/ SELECT CFDOCNUMBER,CFDOCNAME,CFBYZZPRO,CFBYGDJZPRO,CFBYYXJZPRO,CFBYYZPRO,CFBYKNWPRO,CFBYMBPRO,CFBYXFPRO,CFBYEYPRO,CFZZPRO,CFGDJZPRO,CFYXJZPRO,CFZYPRO,CFKNWPRO,CFMBPRO,CFZFPRO,CFEYPRO,CFZJPRO FROM CT_PAY_PARTTIMEDOCPRO where cfcityid= '"+cityID+"' and cfbusinessdate='"+periodnum+"' ";
			IRowSet jianzhirs = com.kingdee.eas.custom.util.DBUtil.executeQuery(ctx,jianzhiSql);
			if(jianzhirs!=null && jianzhirs.size() > 0){
				  while(jianzhirs.next()){	
					  HashMap map = new HashMap();
					  map.put("CFDOCNAME", jianzhirs.getObject("CFDOCNAME"));
					  map.put("CFBYZZPRO", jianzhirs.getObject("CFBYZZPRO"));
					  map.put("CFBYGDJZPRO", jianzhirs.getObject("CFBYGDJZPRO"));
					  map.put("CFBYYXJZPRO", jianzhirs.getObject("CFBYYXJZPRO")); 
					  map.put("CFBYYZPRO", jianzhirs.getObject("CFBYYZPRO")); 
					  map.put("CFBYKNWPRO", jianzhirs.getObject("CFBYKNWPRO"));
					  map.put("CFBYMBPRO", jianzhirs.getObject("CFBYMBPRO"));
					  map.put("CFBYXFPRO", jianzhirs.getObject("CFBYXFPRO"));  
					  map.put("CFBYEYPRO", jianzhirs.getObject("CFBYEYPRO")); 
					  map.put("CFZZPRO", jianzhirs.getObject("CFZZPRO"));
					  map.put("CFGDJZPRO", jianzhirs.getObject("CFGDJZPRO"));
					  map.put("CFYXJZPRO", jianzhirs.getObject("CFYXJZPRO"));  
					  map.put("CFYZPRO", jianzhirs.getObject("CFZYPRO")); 
					  map.put("CFKNWPRO", jianzhirs.getObject("CFKNWPRO"));
					  map.put("CFMBPRO", jianzhirs.getObject("CFMBPRO"));
					  map.put("CFXFPRO", jianzhirs.getObject("CFZFPRO")); 
					  map.put("CFEYPRO", jianzhirs.getObject("CFEYPRO"));
					  map.put("CFZJPRO", jianzhirs.getObject("CFZJPRO"));  
					  tempMap.put(jianzhirs.getObject("CFDOCNUMBER")+"_JIANZHIDOC", map );
				  }
			}
			  
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tempMap;
	}
	

	
	/**
	 * 获得洁牙师相关信息
	 * @param ctx
	 * @param tempMap
	 * @return
	 */
//	public static HashMap getSHYJmbMessage(Context ctx,String periodnum, String cityid,HashMap tempMap){
//		try {
//			String includeDoc = "";
//			Map<String,String> map = new HashMap<String,String>();
//			//点诊 50   非点诊 30    单价
//			String priceSql = "/*dialect*/ SELECT cfjynumber as FNUMBER ,cfprice,cfincludeDoc FROM CT_PAY_ScalingBonus  where cfcityid = '"+cityid+"' and  cfbusinessdate ='"+periodnum+"' ";
//			IRowSet pricers = com.kingdee.eas.custom.util.DBUtil.executeQuery(ctx,priceSql);
//			if(pricers!=null && pricers.size() > 0){
//				  while(pricers.next()){	
//					  tempMap.put(pricers.getObject("FNUMBER")+"HS", pricers.getObject("CFPRICE")); 
//					  map.put(pricers.getObject("CFINCLUDEDOC").toString(),pricers.getObject("CFINCLUDEDOC").toString());
//				  }
//			}
//			if(map.size()== 1 && map.get("N")!= null){
//				includeDoc = "N";
//			}else{
//				includeDoc = "Y";
//			}
//			String jysSql = "";
//			if(includeDoc.equals("Y")){
//				jysSql = "/*dialect*/ select distinct CFEMPNUMBER  from CT_PAY_PayPost  where  cfcityid ='"+cityid+"' and  cfstatus = 'qy' and cfpostnumber in ( 'HS' ,'YS','JZYS') and  cfbusinessdate ='"+periodnum+"'";
//			}else{
//				jysSql = "/*dialect*/ select distinct CFEMPNUMBER  from CT_PAY_PayPost  where   cfcityid ='"+cityid+"' and cfstatus = 'qy' and cfpostnumber = 'HS' and  cfbusinessdate ='"+periodnum+"'  ";
//			}
//			IRowSet jysrs = com.kingdee.eas.custom.util.DBUtil.executeQuery(ctx,jysSql);
//			if(jysrs!=null && jysrs.size() > 0){
//				  while(jysrs.next()){	
//					  tempMap.put(jysrs.getObject("CFEMPNUMBER")+"HS", jysrs.getObject("CFEMPNUMBER") ); 
//				  }
//			 } 
//			String mbSql = "/*dialect*/ select distinct CFEMPNUMBER  from CT_PAY_PayPost  where   cfcityid ='"+cityid+"' and  cfstatus = 'qy' and cfpostnumber ='HS' and  cfbusinessdate ='"+periodnum+"' ";
//			IRowSet mbsrs = com.kingdee.eas.custom.util.DBUtil.executeQuery(ctx,mbSql);
//			if(mbsrs!=null && mbsrs.size() > 0){
//				  while(mbsrs.next()){	 
//					  tempMap.put(mbsrs.getObject("CFEMPNUMBER")+"MB", mbsrs.getObject("CFEMPNUMBER") );
//				  }
//			 }
//			 
//			//美白提成比例
//			String mbbiliSql = "/*dialect*/ select distinct CFPROPORTION   from CT_PAY_WHITEPROPORTION   where cfcityid = '"+cityid+"' and  cfbusinessdate ='"+periodnum+"'   ";
//			IRowSet mbbilirs = com.kingdee.eas.custom.util.DBUtil.executeQuery(ctx,mbbiliSql);
//			if(mbbilirs!=null && mbbilirs.size() > 0){
//				  while(mbbilirs.next()){	 
//					  tempMap.put("MBBILI", mbbilirs.getString("CFPROPORTION") );
//					   
//				  }
//			}
//			
//			//获得医生通用比例 获得赠金折扣比例
//			String tongyongSql = "/*dialect*/ SELECT   CFFREEWORKPRO,CFGIFAMOUNTPRO FROM CT_PAY_DocCurrencyPro  where  cfcityid= '"+cityid+"' and  CFBUSINESSDATE='"+periodnum+"' ";
//			IRowSet tyblrs = com.kingdee.eas.custom.util.DBUtil.executeQuery(ctx,tongyongSql);
//			if(tyblrs!=null && tyblrs.size() > 0){
//				  while(tyblrs.next()){	
//					  HashMap docmap = new HashMap(); 
//					  
//					  docmap.put("CFFREEWORKPRO", tyblrs.getObject("CFFREEWORKPRO"));  
//					  docmap.put("CFGIFAMOUNTPRO", tyblrs.getObject("CFGIFAMOUNTPRO"));  
//					   
//					  tempMap.put("TONGYONGBILI_DOC", docmap );
//				  }
//			} 
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return tempMap;
//	}

	/**
	 * 获得洁牙师相关信息
	 * @param ctx
	 * @param tempMap
	 * @return
	 */
	public static HashMap getSHYJmbMessage(Context ctx,String periodnum, String cityid,HashMap tempMap){
		try {
			String includeDoc = ""; 
			Map<String,String> map = new HashMap<String,String>();
			//获得洁牙类型
			String jytypeSql = "/*dialect*/ SELECT item.CFTypeNumber CFTYPENUMBER,item.CFTypeName CFTYPENAME ,scaling.cfjynumber CFJYNUMBER  , item.cfjytypeid  TYPEID FROM CT_SRQ_ItemCheck item "+
			"left join  CT_PAY_ScalingType scaling on scaling.fid = item.cfjytypeid  and scaling.cfcityid = '"+cityid+"'   where item.cfjytypeid is not null and item.cfcityid = '"+cityid+"' ";
			IRowSet jytypers = com.kingdee.eas.custom.util.DBUtil.executeQuery(ctx,jytypeSql);
			ArrayList<String> arrayList = new ArrayList<String>();
			if(jytypers!=null && jytypers.size() > 0){
				  while(jytypers.next()){	
					  HashMap typemap = new HashMap();
					  arrayList.add(jytypers.getObject("CFTYPENUMBER")+"#"+jytypers.getObject("CFTYPENAME")+"#"+jytypers.getObject("CFJYNUMBER")+"#"+jytypers.getObject("TYPEID"));  
				  }
			}
			tempMap.put(cityid+"_JY", arrayList );  
			//是否包含医生
			String priceSql = "/*dialect*/ SELECT distinct cfincludeDoc FROM CT_PAY_ScalingBonus  where cfcityid = '"+cityid+"' and  cfbusinessdate ='"+periodnum+"' ";
			IRowSet pricers = com.kingdee.eas.custom.util.DBUtil.executeQuery(ctx,priceSql);
			if(pricers!=null && pricers.size() > 0){
				  while(pricers.next()){	 
					  map.put(pricers.getObject("CFINCLUDEDOC").toString(),pricers.getObject("CFINCLUDEDOC").toString());
				  }
			}
			if(map.size()== 1 && map.get("N")!= null){
				includeDoc = "N";
			}else{
				includeDoc = "Y";
			}
			String jysSql = "";
			if(includeDoc.equals("Y")){
				jysSql = "/*dialect*/ select distinct CFEMPNUMBER  from CT_PAY_PayPost  where  cfcityid ='"+cityid+"' and  cfstatus = 'qy' and cfpostnumber in ( 'HS' ,'YS','JZYS') and  cfbusinessdate ='"+periodnum+"'";
			}else{
				jysSql = "/*dialect*/ select distinct CFEMPNUMBER  from CT_PAY_PayPost  where   cfcityid ='"+cityid+"' and cfstatus = 'qy' and cfpostnumber = 'HS' and  cfbusinessdate ='"+periodnum+"'  ";
			}
			IRowSet jysrs = com.kingdee.eas.custom.util.DBUtil.executeQuery(ctx,jysSql);
			if(jysrs!=null && jysrs.size() > 0){
				  while(jysrs.next()){	
					  tempMap.put(jysrs.getObject("CFEMPNUMBER")+"HS", jysrs.getObject("CFEMPNUMBER") ); 
				  }
			} 
			
			
			String mbSql = "/*dialect*/ select distinct CFEMPNUMBER  from CT_PAY_PayPost  where   cfcityid ='"+cityid+"' and  cfstatus = 'qy' and cfpostnumber ='HS' and  cfbusinessdate ='"+periodnum+"' ";
			IRowSet mbsrs = com.kingdee.eas.custom.util.DBUtil.executeQuery(ctx,mbSql);
			if(mbsrs!=null && mbsrs.size() > 0){
				  while(mbsrs.next()){	 
					  tempMap.put(mbsrs.getObject("CFEMPNUMBER")+"MB", mbsrs.getObject("CFEMPNUMBER") );
				  }
			}
			 
			//美白提成比例
			String mbbiliSql = "/*dialect*/ select distinct CFPROPORTION   from CT_PAY_WHITEPROPORTION   where cfcityid = '"+cityid+"' and  cfbusinessdate ='"+periodnum+"'   ";
			IRowSet mbbilirs = com.kingdee.eas.custom.util.DBUtil.executeQuery(ctx,mbbiliSql);
			if(mbbilirs!=null && mbbilirs.size() > 0){
				  while(mbbilirs.next()){	 
					  tempMap.put("MBBILI", mbbilirs.getString("CFPROPORTION") );
					   
				  }
			}else{
				tempMap.put("MBBILI", "0" );
			}
			
			//获得医生通用比例 获得赠金折扣比例
			String tongyongSql = "/*dialect*/ SELECT   CFFREEWORKPRO,CFGIFAMOUNTPRO FROM CT_PAY_DocCurrencyPro  where  cfcityid= '"+cityid+"' and  CFBUSINESSDATE='"+periodnum+"' ";
			IRowSet tyblrs = com.kingdee.eas.custom.util.DBUtil.executeQuery(ctx,tongyongSql);
			if(tyblrs!=null && tyblrs.size() > 0){
				  while(tyblrs.next()){	
					  HashMap docmap = new HashMap();  
					  docmap.put("CFFREEWORKPRO", tyblrs.getObject("CFFREEWORKPRO"));  
					  docmap.put("CFGIFAMOUNTPRO", tyblrs.getObject("CFGIFAMOUNTPRO"));   
					  tempMap.put("TONGYONGBILI_DOC", docmap );
				  }
			}else{
				HashMap docmap = new HashMap(); 
				docmap.put("CFFREEWORKPRO", "0");  
				docmap.put("CFGIFAMOUNTPRO", "0");  
				tempMap.put("TONGYONGBILI_DOC", docmap );
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tempMap;
	}
	/**
	 * 获得上海咨询师相关信息
	 * @param ctx
	 * @param periodnum
	 * @param tempMap
	 * @return
	 */
	public static HashMap getSHZiXunMessage(Context ctx, String periodnum,String cityid ,HashMap tempMap){
		try {
			String postSql = "/*dialect*/ select distinct CFEMPNUMBER  from CT_PAY_PayPost  where  cfcityid ='"+cityid+"' and  cfstatus = 'qy' and cfpostNumber =  'ZXS' and  cfbusinessdate ='"+periodnum+"' ";
			IRowSet rs = com.kingdee.eas.custom.util.DBUtil.executeQuery(ctx,postSql);
			if(rs!=null && rs.size() > 0){
				  while(rs.next()){	
					  tempMap.put(rs.getObject("CFEMPNUMBER")+"_ZX", "1" );
				  }
			 }   
			 
			HashMap<String,String> typeMap = new HashMap<String,String>();
			//因为 咨询师的提成比例不是根据所造门诊的牙椅数量决定的  而是根据自己和门诊所谈的提成来区分大店小店的  所以 每个咨询师对于不同的门诊自带提成比例
			String zxbilisql = "  /*dialect*/ SELECT cfempnumber, cfcontypeid FROM  CT_PAY_EmpShopDeploy where cfbusinessdate= '"+periodnum+"' and  cfcityid= '"+cityid+"'  ";
			IRowSet zxbilirs = com.kingdee.eas.custom.util.DBUtil.executeQuery(ctx,zxbilisql);
			if(zxbilirs!=null && zxbilirs.size() > 0){
				  while(zxbilirs.next()){	 
					  tempMap.put(zxbilirs.getString("CFEMPNUMBER")+"_"+"_SHOP", zxbilirs.getString("CFCONTYPEID")); 
					  typeMap.put(zxbilirs.getString("CFCONTYPEID"), zxbilirs.getString("CFCONTYPEID"));
				  }
			}
			 
			int  biaozhunYY = 8;
			//获得门店标准    nvl( ,0)
			String mdSql = " /*dialect*/  SELECT nvl( cfyysl,0) cfyysl,nvl(cffirst ,0) cffirst,nvl(cffirstmoney ,0) cffirstmoney,nvl(cfsecond ,0) cfsecond,nvl(cfsecondmoney ,0) cfsecondmoney,"+
			" nvl(cfthird ,0) cfthird,nvl(cftype ,0) cftype , nvl(cfbilipro ,0) cfbilipro,nvl(cfdiscount ,0) cfdiscount,nvl(cfkeepPro ,0) cfkeepPro FROM CT_PAY_ConsultantPro "+
			" where  cfcityid= '"+cityid+"' and cfbusinessdate= '"+periodnum+"' ";
			IRowSet mdrs = com.kingdee.eas.custom.util.DBUtil.executeQuery(ctx,mdSql);
			if(mdrs!=null && mdrs.size() > 0){
				  while(mdrs.next()){	
					  HashMap map = new HashMap();  
					  map.put("CFBILIPRO", mdrs.getObject("CFBILIPRO"));
					  map.put("CFDISCOUNT", mdrs.getObject("CFDISCOUNT"));
					  map.put("CFKEEPPRO", mdrs.getObject("CFKEEPPRO"));
					  tempMap.put( "SHZIXUN_YY", map );
				  }
				  tempMap.put( "biaozhunYY", biaozhunYY  );
			}else{
				HashMap map = new HashMap();  
				map.put("CFBILIPRO", "0");
				map.put("CFDISCOUNT", "0");
				map.put("CFKEEPPRO", "0");
				tempMap.put( "SHZIXUN_YY", map ); 
				tempMap.put( "biaozhunYY", biaozhunYY  );
			} 
			
			
			for (Map.Entry<String, String> entry : typeMap.entrySet()) {
	            String typeid = entry.getKey();
	            //获得咨询阶段提成比例
				String zxjdSql = " /*dialect*/  SELECT   cftypeid, cfbeginamount,cfendamount,cfpro  FROM CT_PAY_ConsultStage  where  cftypeid = '"+typeid+"' and cfcityid= '"+cityid+"'  and cfbusinessdate= '"+periodnum+"'   order by  cftypeid  , cfbeginamount ";
				IRowSet zxjdrs = com.kingdee.eas.custom.util.DBUtil.executeQuery(ctx,zxjdSql);
				ArrayList<HashMap<Object, Object>> arraylist = new ArrayList<HashMap<Object, Object>> ();
				if(zxjdrs!=null && zxjdrs.size() > 0){
					while(zxjdrs.next()){	
					  HashMap map = new HashMap();
					  String type = zxjdrs.getString("CFTYPEID");
					  map.put("CFBEGINAMOUNT", zxjdrs.getObject("CFBEGINAMOUNT"));
					  map.put("CFENDAMOUNT", zxjdrs.getObject("CFENDAMOUNT"));
					  map.put("CFPRO", zxjdrs.getObject("CFPRO")); 
					  arraylist.add(map);
					  
				  	} 		  
				}
				tempMap.put(typeid+"_"+cityid, arraylist); 
	        }
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tempMap;
	}

	
	public static HashMap getSHShopGoalMessage(Context ctx, String periodnum, String cityid,HashMap tempMap){
		try {
			HashMap<String,String> typeMap = new HashMap<String,String>();
			//因为 咨询师的提成比例不是根据所造门诊的牙椅数量决定的  而是根据自己和门诊所谈的提成来区分大店小店的  所以 每个咨询师对于不同的门诊自带提成比例
			String zxbilisql = "  /*dialect*/ SELECT cfempnumber, cfcontypeid FROM  CT_PAY_EmpShopDeploy where cfbusinessdate= '"+periodnum+"' and  cfcityid= '"+cityid+"'  ";
			IRowSet zxbilirs = com.kingdee.eas.custom.util.DBUtil.executeQuery(ctx,zxbilisql);
			if(zxbilirs!=null && zxbilirs.size() > 0){
				  while(zxbilirs.next()){	 
					  tempMap.put(zxbilirs.getString("CFEMPNUMBER")+"_"+"_SHOP", zxbilirs.getString("CFCONTYPEID")); 
					  typeMap.put(zxbilirs.getString("CFCONTYPEID"), zxbilirs.getString("CFCONTYPEID"));
				  }
			}
			
			for (Map.Entry<String, String> entry : typeMap.entrySet()) {
	            String typeid = entry.getKey();
	            //获得咨询阶段提成比例
				String zxjdSql = " /*dialect*/  SELECT   cftypeid, cfbeginamount,cfendamount,cfpro  FROM CT_PAY_ConsultStage  where  cftypeid = '"+typeid+"' and cfcityid= '"+cityid+"'  and cfbusinessdate= '"+periodnum+"'   order by  cftypeid  , cfbeginamount ";
				IRowSet zxjdrs = com.kingdee.eas.custom.util.DBUtil.executeQuery(ctx,zxjdSql);
				ArrayList<HashMap<Object, Object>> arraylist = new ArrayList<HashMap<Object, Object>> ();
				if(zxjdrs!=null && zxjdrs.size() > 0){
					while(zxjdrs.next()){	
					  HashMap map = new HashMap();
					  String type = zxjdrs.getString("CFTYPEID");
					  map.put("CFBEGINAMOUNT", zxjdrs.getObject("CFBEGINAMOUNT"));
					  map.put("CFENDAMOUNT", zxjdrs.getObject("CFENDAMOUNT"));
					  map.put("CFPRO", zxjdrs.getObject("CFPRO")); 
					  arraylist.add(map);
					  
				  	} 		  
				}
				tempMap.put(typeid+"_"+cityid, arraylist); 
	        }
			
			String postSql = "/*dialect*/ select distinct CFEMPNUMBER,CFCLINICID  from CT_PAY_PayPost  where  cfcityid ='"+cityid+"' and  cfstatus = 'qy' and cfpostNumber in ( 'MZYYZJ',  'FMZYYZJ' ,'CSYYZJ')  and cfbusinessdate ='"+periodnum+"' ";
			IRowSet rs = com.kingdee.eas.custom.util.DBUtil.executeQuery(ctx,postSql);
			if(rs!=null && rs.size() > 0){
				  while(rs.next()){	
					  tempMap.put(rs.getObject("CFEMPNUMBER")+"_MD", rs.getObject("CFCLINICID") );
				  }
			 }
			//String yySql = "  SELECT CFMONEY   FROM  CT_PAY_ShopGoalBonus   ";
			String yySql = "   SELECT  CFHIGAMOUNT,CFREWARDAMOUNT,CFPASSPRO,CFADDAMOUNT,CFACHIEVEPRO  FROM  CT_PAY_ClinicUpScale where cfcityid  = '"+cityid+"'   and  cfbusinessdate = '"+periodnum+"'  ";
			IRowSet yyrs = com.kingdee.eas.custom.util.DBUtil.executeQuery(ctx,yySql);
			if(yyrs!=null && yyrs.size() > 0){
				  while(yyrs.next()){	
					  HashMap map = new HashMap();
					  map.put("CFHIGAMOUNT", yyrs.getObject("CFHIGAMOUNT"));
					  map.put("CFREWARDAMOUNT", yyrs.getObject("CFREWARDAMOUNT"));
					  map.put("CFPASSPRO", yyrs.getObject("CFPASSPRO"));
					  map.put("CFADDAMOUNT", yyrs.getObject("CFADDAMOUNT"));
					  map.put("CFACHIEVEPRO", yyrs.getObject("CFACHIEVEPRO"));
					  tempMap.put(cityid+"_"+periodnum+"_MONEY_MD", map );
				  }
			 }
			 
			String sqlSJStr = " /*dialect*/  select   nvl(CFIncome,0)  as thiscount , nvl(cfdiary,0) as pay  ,CFCLINICID  from  CT_PAY_ClinicMonthSum where   cfbusinessdate =  '"+periodnum+"' and   cfcityid= '"+cityid+"'    ";
			
			IRowSet rsSJ =  DBUtil.executeQuery(ctx,sqlSJStr);
			if(rsSJ!=null && rsSJ.size() > 0){
				  while(rsSJ.next()){	
					  if("".equals( rsSJ.getString("CFCLINICID"))){
						  tempMap.put("null__SJMD", "");
					  }else{
						  tempMap.put(rsSJ.getString("CFCLINICID")+"_SJMD", rsSJ.getString("THISCOUNT"));
						  tempMap.put(rsSJ.getString("CFCLINICID")+"_SJPAY", rsSJ.getString("PAY"));
					  }
					   
				  }
			 } 
			
			String sqlMBStr = " /*dialect*/ SELECT  max(CFTarget) as thiscount,CFCOMPANYID FROM CT_PAY_BudgetDate where CFBUSINESSDATE = '"+periodnum+"'  group by CFCOMPANYID ";
		
			IRowSet rsMBSR =  DBUtil.executeQuery(ctx,sqlMBStr);
			if(rsMBSR!=null && rsMBSR.size() > 0){
				  while(rsMBSR.next()){	
					  if("".equals( rsMBSR.getString("CFCOMPANYID"))){
						  tempMap.put("null_MBMD", "");
					  }else{
						  tempMap.put( rsMBSR.getString("CFCOMPANYID")+"_MBMD", rsMBSR.getString("THISCOUNT"));
					  }
				  }
			}
			
			int  biaozhunYY = 8;
			//获得门店标准    nvl( ,0)
			String mdSql = " /*dialect*/  SELECT nvl( cfyysl,0) cfyysl,nvl(cffirst ,0) cffirst,nvl(cffirstmoney ,0) cffirstmoney,nvl(cfsecond ,0) cfsecond,nvl(cfsecondmoney ,0) cfsecondmoney,"+
			" nvl(cfthird ,0) cfthird,nvl(cftype ,0) cftype , nvl(cfbilipro ,0) cfbilipro,nvl(cfdiscount ,0) cfdiscount,nvl(cfkeepPro ,0) cfkeepPro FROM CT_PAY_ConsultantPro "+
			" where  cfcityid= '"+cityid+"' and cfbusinessdate= '"+periodnum+"' ";
			IRowSet mdrs = com.kingdee.eas.custom.util.DBUtil.executeQuery(ctx,mdSql);
			if(mdrs!=null && mdrs.size() > 0){
				  while(mdrs.next()){	
					  HashMap map = new HashMap(); 
					  map.put("CFBILIPRO", mdrs.getObject("CFBILIPRO"));
					  map.put("CFDISCOUNT", mdrs.getObject("CFDISCOUNT"));
					  map.put("CFKEEPPRO", mdrs.getObject("CFKEEPPRO"));
					  tempMap.put( periodnum+"_"+periodnum, map );
				  }
				  tempMap.put( "biaozhunYY", biaozhunYY  );
			 }else{
					HashMap map = new HashMap();  
					map.put("CFBILIPRO", "0");
					map.put("CFDISCOUNT", "0");
					map.put("CFKEEPPRO", "0");
					tempMap.put( "SHZIXUN_YY", map ); 
					tempMap.put( "biaozhunYY", biaozhunYY  );
				} 
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tempMap;
	}
	
	//获得客服相关信息
	public static HashMap getSHKeFuMessage(Context ctx, String periodnum, String cityid,HashMap tempMap){
		try {
			     
			//获得门店标准
			String mdSql = " /*dialect*/  SELECT  distinct  cfzbpro  as ZBPRO FROM CT_PAY_ConsultantPro  where  cfcityid= '"+cityid+"' and cfbusinessdate= '"+periodnum+"' ";
			IRowSet mdrs = com.kingdee.eas.custom.util.DBUtil.executeQuery(ctx,mdSql);
			if(mdrs!=null && mdrs.size() > 0){
				  while(mdrs.next()){	  
					  tempMap.put( "KEFU_ZHOUBIANPRO", mdrs.getObject("ZBPRO") );
				  } 
			 }else{
				 tempMap.put( "KEFU_ZHOUBIANPRO", "0" );
			 }
			 
			//获得获得赠金比例
			String tongyongSql = "/*dialect*/ SELECT CFZZBL,CFGDJZBL,CFYXJZBL,CFYZZLBL,CFKNWBL,CFMBBL,CFXFBL,CFEYBL,CFZJBL, CFFREEWORKPRO,CFFIRSTSOURCE,CFSOURCEPRO,CFGIFAMOUNTPRO FROM CT_PAY_DocCurrencyPro  where  cfcityid= '"+cityid+"' and  CFBUSINESSDATE='"+periodnum+"' ";
			IRowSet tyblrs = com.kingdee.eas.custom.util.DBUtil.executeQuery(ctx,tongyongSql);
			if(tyblrs!=null && tyblrs.size() > 0){
				  while(tyblrs.next()){	
					  HashMap map = new HashMap();  
					  map.put("CFGIFAMOUNTPRO", tyblrs.getObject("CFGIFAMOUNTPRO"));  
					   
					  tempMap.put("TONGYONGBILI_DOC", map );
				  }
			}else{
				HashMap map = new HashMap();  
				map.put("CFGIFAMOUNTPRO", "0");  
				   
				tempMap.put("TONGYONGBILI_DOC", map );
			} 
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tempMap;
	}
	
	public static HashMap<String,HashMap<String,String>> getJYItemMessage(Context ctx, String periodnum, String cityID ,HashMap<String,HashMap<String,String>> jyitemMessage){
		
		try {
			String  onejyStr = "";
			String  twojyStr = "";
			String  threejyStr = ""; 
			HashMap<String,String>  oneItemMap = new HashMap<String,String>();
			StringBuffer jyTypeSql =  new StringBuffer();
			jyTypeSql.append(" /*dialect*/SELECT  bill.cftypenumber as CFTYPENNUMBER,item.fnumber as itemnumber FROM  CT_SRQ_ItemCheck bill ");
			jyTypeSql.append(" inner join CT_PAY_ScalingType type on bill.CFJyTypeID=type.fid and type.cfcityid = '"+cityID+"'  ");
			jyTypeSql.append(" inner join  CT_SRQ_ItemCheckEntry entry on   bill.fid = entry.fparentid  ");
			jyTypeSql.append(" inner JOIN  CT_SRQ_Paytypecategory  item on  item.fid = entry.cffirstitemid   ");
			jyTypeSql.append(" where      bill.cfcityid = '"+cityID+"'  and  bill.cfisjy = 1  order by CFTYPENUMBER");
			IRowSet jytyperow = DbUtil.executeQuery(ctx, jyTypeSql.toString()); 
			while (jytyperow.next()) { 
				String typenumber = jytyperow.getString("CFTYPENNUMBER");//   
				String itemNumber = jytyperow.getString("ITEMNUMBER");
				if(oneItemMap.get(typenumber) == null || oneItemMap.get(typenumber).equals("")){
					oneItemMap.put(typenumber, "'"+itemNumber+"'");
				}else{
					String strItem = oneItemMap.get(typenumber);
					oneItemMap.put(typenumber,strItem+ ",'"+itemNumber+"'");
				}
				onejyStr = onejyStr+"'"+itemNumber+"',";
			}
			jyitemMessage.put("one", oneItemMap);
			
			HashMap<String,String>  twoItemMap = new HashMap<String,String>();
			jyTypeSql = new StringBuffer(); 
			jyTypeSql.append(" /*dialect*/SELECT  bill.cftypenumber as CFTYPENNUMBER,item.fnumber as itemnumber FROM  CT_SRQ_ItemCheck bill ");
			jyTypeSql.append(" inner join CT_PAY_ScalingType type on bill.CFJyTypeID=type.fid and type.cfcityid = '"+cityID+"'  ");
			jyTypeSql.append(" inner join  CT_SRQ_ItemCheckEntrysec entry on   bill.fid = entry.fparentid  ");
			jyTypeSql.append(" inner JOIN  CT_SRQ_Paytypeitem  item on  item.fid = entry.cfseconditemid       ");
			jyTypeSql.append(" where      bill.cfcityid = '"+cityID+"'  and  bill.cfisjy = 1     order by CFTYPENUMBER");
			IRowSet jytyperow2 = DbUtil.executeQuery(ctx, jyTypeSql.toString()); 
			while (jytyperow2.next()) { 
				String typenumber = jytyperow2.getString("CFTYPENNUMBER");   
				String itemNumber = jytyperow2.getString("ITEMNUMBER");
				if(twoItemMap.get(typenumber) == null || twoItemMap.get(typenumber).equals("")){
					twoItemMap.put(typenumber, "'"+itemNumber+"'");
				}else{
					String strItem = twoItemMap.get(typenumber);
					twoItemMap.put(typenumber,strItem+ ",'"+itemNumber+"'");
				}
				twojyStr = twojyStr+"'"+itemNumber+"',";
			}

			jyitemMessage.put("two", twoItemMap);
			 
			HashMap<String,String>  threeItemMap = new HashMap<String,String>();
			jyTypeSql =  new StringBuffer();
			jyTypeSql.append(" /*dialect*/SELECT  bill.cftypenumber as CFTYPENNUMBER,item.fnumber as itemnumber FROM  CT_SRQ_ItemCheck bill ");
			jyTypeSql.append(" inner join CT_PAY_ScalingType type on bill.CFJyTypeID=type.fid and type.cfcityid = '"+cityID+"'  ");
			jyTypeSql.append(" inner join  CT_SRQ_ItemCheckEntrythi entry on   bill.fid = entry.fparentid  ");
			jyTypeSql.append(" inner JOIN  CT_SRQ_PayItem  item on  item.fid = entry.cfitemid   ");
			jyTypeSql.append(" where      bill.cfcityid = '"+cityID+"'  and  bill.cfisjy = 1   order by CFTYPENUMBER");
			IRowSet jytyperow3 = DbUtil.executeQuery(ctx, jyTypeSql.toString()); 
			while (jytyperow3.next()) { 
				String typenumber = jytyperow3.getString("CFTYPENNUMBER");//   
				String itemNumber = jytyperow3.getString("ITEMNUMBER");
				if(threeItemMap.get(typenumber) == null || threeItemMap.get(typenumber).equals("")){
					threeItemMap.put(typenumber, "'"+itemNumber+"'");
				}else{
					String strItem = threeItemMap.get(typenumber);
					threeItemMap.put(typenumber,strItem+ ",'"+itemNumber+"'");
				}
				threejyStr = threejyStr+"'"+itemNumber+"',";
			}
			jyitemMessage.put("three", threeItemMap);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jyitemMessage;
	}
	
	
	public static HashMap<String,String> getJYItemMessage(Context ctx, String periodnum, String cityID ){
		HashMap<String,String> itemMap = new HashMap<String,String>();
		try {
			String  onejyStr = "";
			String  twojyStr = "";
			String  threejyStr = ""; 
			 
			StringBuffer jyTypeSql =  new StringBuffer();
			jyTypeSql.append(" /*dialect*/SELECT  bill.cftypenumber as CFTYPENNUMBER,item.fnumber as itemnumber FROM  CT_SRQ_ItemCheck bill ");
			jyTypeSql.append(" inner join CT_PAY_ScalingType type on bill.CFJyTypeID=type.fid and type.cfcityid = '"+cityID+"'  ");
			jyTypeSql.append(" inner join  CT_SRQ_ItemCheckEntry entry on   bill.fid = entry.fparentid  ");
			jyTypeSql.append(" inner JOIN  CT_SRQ_Paytypecategory  item on  item.fid = entry.cffirstitemid   ");
			jyTypeSql.append(" where      bill.cfcityid = '"+cityID+"'  and  bill.cfisjy = 1  order by CFTYPENUMBER");
			IRowSet jytyperow = DbUtil.executeQuery(ctx, jyTypeSql.toString()); 
			while (jytyperow.next()) { 
				String typenumber = jytyperow.getString("CFTYPENNUMBER");//   
				String itemNumber = jytyperow.getString("ITEMNUMBER"); 
				onejyStr = onejyStr+"'"+itemNumber+"',";
			}
			if(onejyStr.equals("")){
				onejyStr = "''";
			}else{
				onejyStr = onejyStr.substring(0,onejyStr.length()-1);
			}
			itemMap.put("onejyStr", onejyStr);
			
			 
			jyTypeSql = new StringBuffer(); 
			jyTypeSql.append(" /*dialect*/SELECT  bill.cftypenumber as CFTYPENNUMBER,item.fnumber as itemnumber FROM  CT_SRQ_ItemCheck bill ");
			jyTypeSql.append(" inner join CT_PAY_ScalingType type on bill.CFJyTypeID=type.fid and type.cfcityid = '"+cityID+"'  ");
			jyTypeSql.append(" inner join  CT_SRQ_ItemCheckEntrysec entry on   bill.fid = entry.fparentid  ");
			jyTypeSql.append(" inner JOIN  CT_SRQ_Paytypeitem  item on  item.fid = entry.cfseconditemid       ");
			jyTypeSql.append(" where      bill.cfcityid = '"+cityID+"'  and  bill.cfisjy = 1    order by CFTYPENUMBER");
			IRowSet jytyperow2 = DbUtil.executeQuery(ctx, jyTypeSql.toString()); 
			while (jytyperow2.next()) { 
				String typenumber = jytyperow2.getString("CFTYPENNUMBER");//   
				String itemNumber = jytyperow2.getString("ITEMNUMBER"); 
				twojyStr = twojyStr+"'"+itemNumber+"',";
			}
			if(twojyStr.equals("")){
				twojyStr = "''";
			}else{
				twojyStr = twojyStr.substring(0,twojyStr.length()-1);
			}
			itemMap.put("twojyStr", twojyStr);
			 
			 
			jyTypeSql =  new StringBuffer();
			jyTypeSql.append(" /*dialect*/SELECT  bill.cftypenumber as CFTYPENNUMBER,item.fnumber as itemnumber FROM  CT_SRQ_ItemCheck bill ");
			jyTypeSql.append(" inner join CT_PAY_ScalingType type on bill.CFJyTypeID=type.fid and type.cfcityid = '"+cityID+"'  ");
			jyTypeSql.append(" inner join  CT_SRQ_ItemCheckEntrythi entry on   bill.fid = entry.fparentid  ");
			jyTypeSql.append(" inner JOIN  CT_SRQ_PayItem  item on  item.fid = entry.cfitemid   ");
			jyTypeSql.append(" where      bill.cfcityid = '"+cityID+"'  and  bill.cfisjy = 1   order by CFTYPENUMBER");
			IRowSet jytyperow3 = DbUtil.executeQuery(ctx, jyTypeSql.toString()); 
			while (jytyperow3.next()) { 
				String typenumber = jytyperow3.getString("CFTYPENNUMBER");//   
				String itemNumber = jytyperow3.getString("ITEMNUMBER"); 
				threejyStr = threejyStr+"'"+itemNumber+"',";
			}
			if(threejyStr.equals("")){
				threejyStr = "''";
			}else{
				threejyStr = threejyStr.substring(0,threejyStr.length()-1);
			}
			itemMap.put("threejyStr", threejyStr);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return itemMap;
	}

	public static HashMap<String,HashMap<String,String>>  getMBItemMessage(Context ctx, String periodnum, String cityID ,
			HashMap<String,HashMap<String,String>>  itemMessage){
		
		try {
			
			 
			HashMap<String,String>  oneItemMap = new HashMap<String,String>();
			StringBuffer oneItempeMapSql =  new StringBuffer();
			oneItempeMapSql.append(" /*dialect*/SELECT  bill.cftypenumber as CFTYPENNUMBER,item.fnumber  as itemnumber  FROM  CT_SRQ_ItemCheck bill  ");
			oneItempeMapSql.append(" inner join  CT_SRQ_ItemCheckEntry   entry on   bill.fid = entry.fparentid   ");
			oneItempeMapSql.append(" inner JOIN  CT_SRQ_Paytypecategory  item on  item.fid = entry.cffirstitemid    	 "); 
			oneItempeMapSql.append(" where  bill.cfcityid =  '"+cityID+"'   and  (bill.cfisjy is null or   bill.cfisjy = 0)    order by CFTYPENUMBER");
			IRowSet oneItemrow = DbUtil.executeQuery(ctx, oneItempeMapSql.toString()); 
			while (oneItemrow.next()) { 
				String typenumber = oneItemrow.getString("CFTYPENNUMBER");//  收费项目配置表中的
				String itemNumber = oneItemrow.getString("ITEMNUMBER");
				if(oneItemMap.get(typenumber) == null || oneItemMap.get(typenumber).equals("")){
					oneItemMap.put(typenumber, "'"+itemNumber+"'");
				}else{
					String strItem = oneItemMap.get(typenumber);
					oneItemMap.put(typenumber,strItem+ ",'"+itemNumber+"'");
				} 
			}
			itemMessage.put("one", oneItemMap); 
			HashMap<String,String>  twoItemMap = new HashMap<String,String>();
			StringBuffer twoItempeMapSql =  new StringBuffer();
			twoItempeMapSql.append(" /*dialect*/SELECT  bill.cftypenumber as CFTYPENNUMBER,item.fnumber  as itemnumber  FROM  CT_SRQ_ItemCheck bill  ");
			twoItempeMapSql.append(" inner join  CT_SRQ_ItemCheckEntrysec   entry on   bill.fid = entry.fparentid   ");
			twoItempeMapSql.append(" inner JOIN  CT_SRQ_Paytypeitem  item on  item.fid = entry.cfseconditemid    	 "); 
			twoItempeMapSql.append(" where  bill.cfcityid =  '"+cityID+"'   and   (bill.cfisjy is null or   bill.cfisjy = 0)     order by CFTYPENUMBER");
			IRowSet twoItemrow = DbUtil.executeQuery(ctx, twoItempeMapSql.toString()); 
			while (twoItemrow.next()) { 
				String typenumber = twoItemrow.getString("CFTYPENNUMBER");//  收费项目配置表中的
				String itemNumber = twoItemrow.getString("ITEMNUMBER");
				if(twoItemMap.get(typenumber) == null || twoItemMap.get(typenumber).equals("")){
					twoItemMap.put(typenumber, "'"+itemNumber+"'");
				}else{
					String strItem = twoItemMap.get(typenumber);
					twoItemMap.put(typenumber,strItem+ ",'"+itemNumber+"'");
				} 
			}
			itemMessage.put("two", twoItemMap);
			
			HashMap<String,String>  threeItemMap = new HashMap<String,String>();
			StringBuffer threeItempeMapSql =  new StringBuffer();
			threeItempeMapSql.append(" /*dialect*/SELECT  bill.cftypenumber as CFTYPENNUMBER,item.fnumber  as itemnumber  FROM  CT_SRQ_ItemCheck bill    ");
			threeItempeMapSql.append(" inner join  CT_SRQ_ItemCheckEntrythi entry on   bill.fid = entry.fparentid     ");
			threeItempeMapSql.append(" inner JOIN  CT_SRQ_PayItem  item on  item.fid = entry.cfitemid  "); 
			threeItempeMapSql.append(" where      bill.cfcityid =  '"+cityID+"'   and   (bill.cfisjy is null or   bill.cfisjy = 0)    order by CFTYPENUMBER");
			IRowSet threeItemrow = DbUtil.executeQuery(ctx, threeItempeMapSql.toString()); 
			while (threeItemrow.next()) { 
				String typenumber = threeItemrow.getString("CFTYPENNUMBER");//  收费项目配置表中的
				String itemNumber = threeItemrow.getString("ITEMNUMBER");
				if(threeItemMap.get(typenumber) == null || threeItemMap.get(typenumber).equals("")){
					threeItemMap.put(typenumber, "'"+itemNumber+"'");
				}else{
					String strItem = threeItemMap.get(typenumber);
					threeItemMap.put(typenumber,strItem+ ",'"+itemNumber+"'");
				}
				 
			}
			itemMessage.put("three", threeItemMap);
			 
			 
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return itemMessage;
	}
	
}
