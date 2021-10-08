package com.kingdee.eas.mw.srqr.app.util;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.sql.RowSet;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.util.BOSUuid;
import com.kingdee.eas.base.core.fm.ContextHelperFactory;
import com.kingdee.eas.base.permission.UserInfo;
import com.kingdee.eas.basedata.framework.app.ParallelSqlExecutor;
import com.kingdee.eas.basedata.master.material.MaterialFactory;
import com.kingdee.eas.basedata.master.material.MaterialInfo;
import com.kingdee.eas.basedata.org.CompanyOrgUnitFactory;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.basedata.org.CtrlUnitFactory;
import com.kingdee.eas.basedata.org.CtrlUnitInfo;
import com.kingdee.eas.basedata.org.OrgUnitInfo;
import com.kingdee.eas.basedata.org.StorageOrgUnitFactory;
import com.kingdee.eas.basedata.org.StorageOrgUnitInfo;
import com.kingdee.eas.basedata.person.PersonFactory;
import com.kingdee.eas.basedata.person.PersonInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.custom.app.DateBaseProcessType;
import com.kingdee.eas.custom.app.DateBasetype;
import com.kingdee.eas.custom.app.unit.AppUnit;
import com.kingdee.eas.custom.util.DBUtil;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.mw.pay.CostDetailFactory;
import com.kingdee.eas.mw.pay.CostDetailInfo;
import com.kingdee.eas.mw.pay.CostSumCollection;
import com.kingdee.eas.mw.pay.CostSumFactory;
import com.kingdee.eas.mw.pay.CostSumInfo;
import com.kingdee.eas.mw.pay.ICostDetail;
import com.kingdee.eas.mw.srqr.CostComputeHeaderLogFactory;
import com.kingdee.eas.mw.srqr.CostComputeHeaderLogInfo;
import com.kingdee.eas.mw.srqr.ICostComputeHeaderLog;
import com.kingdee.eas.mw.srqr.ISaleIssueHisLog;
import com.kingdee.eas.mw.srqr.SaleIssueHisLogFactory;
import com.kingdee.eas.mw.srqr.SaleIssueHisLogInfo;
import com.kingdee.eas.mw.srqr.app.status;
import com.kingdee.eas.scm.im.inv.ISaleIssueBill;
import com.kingdee.eas.scm.im.inv.SaleIssueBillCollection;
import com.kingdee.eas.scm.im.inv.SaleIssueBillFactory;
import com.kingdee.eas.scm.im.inv.SaleIssueBillInfo;
import com.kingdee.eas.scm.im.inv.SaleIssueEntryCollection;
import com.kingdee.eas.scm.im.inv.SaleIssueEntryInfo;
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.jdbc.rowset.IRowSet;

public class SyncCostTool {

	public static void SyncCostDetail(Context ctx,String thiscityNumber,String companyid,String businessDate,String cityID
			,HashMap<String,String> oneItemMap,HashMap<String,String>  twoItemMap,HashMap<String,String>  threeItemMap){
		
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

		
		
		PayBeiJingDocFunctionService payDocFunctionService= new PayBeiJingDocFunctionService();
		OrgUnitInfo unit =  ContextUtil.getCurrentOrgUnit(ctx) ;
		String sql = "select '"+companyid+"' as COMPANYID ,fid as PERIODID , fnumber as PERIODNUM  from  T_BD_Period where  fnumber = "+businessDate+" ";
		List ls = new ArrayList();
		  IRowSet rs = null;
			try {
				rs = com.kingdee.eas.custom.util.DBUtil.executeQuery(ctx,sql);
				if(rs!=null && rs.size() > 0){
					  while(rs.next()){		 
						Map mp = new HashMap();	  
						mp.put("companyid", rs.getObject("COMPANYID"));
						mp.put("periodid", rs.getObject("PERIODID"));
						mp.put("periodnum", rs.getObject("PERIODNUM"));
						ls.add(mp);
					  }
				 } 
			} catch (BOSException e) {
				e.printStackTrace();
			} catch (java.sql.SQLException e) {
				e.printStackTrace();
			}  
         
		if(ls!=null &&  ls.size() > 0){
			//SaleIssueBillInfo info = null;
			SaleIssueBillCollection coll = new SaleIssueBillCollection();
			try {
				ISaleIssueBill isf = SaleIssueBillFactory.getLocalInstance(ctx);
				ICostComputeHeaderLog icchl = CostComputeHeaderLogFactory.getLocalInstance(ctx);
				CoreBaseCollection  collection = new CoreBaseCollection();
				 
				String periodid="";
				String periodNum = "";
				String handerID="";
				CoreBaseCollection costDetailCollectoin = new CoreBaseCollection();
				CoreBaseCollection logCollectoin = new CoreBaseCollection();
				ISaleIssueHisLog ish = SaleIssueHisLogFactory.getLocalInstance(ctx);
				ICostDetail icostDetail = CostDetailFactory.getLocalInstance(ctx);
				for(int j =0 ; j <ls.size() ; j++){
					  Map mp = (Map) ls.get(j);
					  companyid = (String) mp.get("companyid");
					  periodid = (String) mp.get("periodid");
					  periodNum = (String) mp.get("periodnum").toString();
					  
					  handerID = getRportHeaderID(ctx,companyid,periodid);
					if(handerID!=null && handerID.length()>0){
						List<String> billNumberList = getLISHIBillNumberByComIDAndPeriod(ctx,companyid,periodNum);
						if(billNumberList!=null && billNumberList.size()>0){
							for(String issnumber : billNumberList){
								if(isf.exists("where number='"+issnumber+"'")){
									
									SaleIssueBillInfo info = isf.getSaleIssueBillInfo("where number='"+issnumber+"'");
									if(info!=null && info.getNumber()!=null && !"".equals(info.getNumber())){
										//if(createHisLog(ctx,info,status.Cost)!=null) 
										//新加
										CoreBaseCollection costColl = createCostDetail(ctx,info,periodNum,status.Cost);
										if(costColl!=null && costColl.size() >0){ 
											costDetailCollectoin.addCollection(costColl);
										} 
									}
								
								}
							}
						}
						CostComputeHeaderLogInfo item = new CostComputeHeaderLogInfo(); 
						Calendar cal=Calendar.getInstance();
					    cal.setTime(new Date());
					    Timestamp tt =  new Timestamp(cal.getTimeInMillis());
						item.setNumber(handerID);
						item.setName(companyid);
 						item.setDescription(periodid);
				    	CtrlUnitInfo cu = new CtrlUnitInfo();
				    	cu.setId(BOSUuid.read("00000000-0000-0000-0000-000000000000CCE7AED4"));
				    	item.setCU(cu);
				    	UserInfo userInfo = ContextUtil.getCurrentUserInfo(ctx);
				    	item.setCreator(userInfo);
				    	item.setLastUpdateUser(userInfo);
				    	item.setCreateTime(tt);
				    	item.setLastUpdateTime(tt);
				    	collection.add(item);
					}
				}
				 
				boolean flag = false;
				if(collection.size()>0 && costDetailCollectoin.size()>0){
					flag = true;
					icostDetail.addnewBatchData(costDetailCollectoin);
				}
				if(collection.size()>0 && costDetailCollectoin.size()>0){
					String userId = ContextHelperFactory.getLocalInstance(ctx).getCurrentUser().getId().toString(); 
					
					StringBuffer sbr  = new StringBuffer(" /*dialect*/  insert into CT_PAY_CostSum (FID,FCreatorID,FCreateTime,FLastUpdateUserID,FLastUpdateTime,fcontrolunitid  ,fhandlerid ,fbizdate , ");
					sbr.append("  CFDoctorNumber,CFDoctorName, cfperiod,cfclinicnumber,cfclinicname ,cfcitynumber,cfcityname,cfstatus  )"); 
			    	sbr.append("  select  distinct  newbosid('5DA507CC'),'"+userId+"',sysdate,'"+userId+"',sysdate,'00000000-0000-0000-0000-000000000000CCE7AED4','"+userId+"', sysdate, CFDoctorNumber  , CFDoctorName  ,cfperiod ,cfclinicnumber,cfclinicname ,cfcitynumber,cfcityname,'wsh' from  CT_PAY_CostDetail  "); 
			    	sbr.append("  where    not  exists (select 1 from CT_PAY_CostSum where  CT_PAY_CostSum.cfdoctorNumber||CT_PAY_CostSum.cfclinicnumber = CT_PAY_CostDetail.cfDocAndClinic and   CT_PAY_CostSum.cfperiod = '"+periodNum+"')  and cfperiod = '"+periodNum+"'   group by CFDoctorNumber  , CFDoctorName  ,cfperiod ,cfclinicnumber,cfclinicname,cfcitynumber,cfcityname");
			    	System.out.println(sbr.toString());
			    	DbUtil.execute(ctx, sbr.toString());
			    	
			    	if(thiscityNumber.equals("MS3101") || thiscityNumber.equals("CG01")){
			    		StringBuffer updatesbr   = new StringBuffer(" /*dialect*/  update  CT_PAY_CostSum  a set a.CFAmount = ( select nvl(sum(b.cfamount),0) as  amount  from CT_PAY_CostDetail b  where   b.cfcitynumber IN ( 'MS3101','CG01') and b.cfperiod =   '"+periodNum+"'  and a.CFDoctorNumber = b.CFDoctorNumber and a.cfclinicnumber = b.cfclinicnumber  group by  b.CFDoctorNumber , b.cfperiod  ,b.cfclinicnumber   ) ");
				    	//加工费   隐形矫正
			    		updatesbr.append(" 	 ,a.cfjgfyxjz = (select nvl(sum(b.cfamount),0) as  amount  from CT_PAY_CostDetail b  where   b.cfcitynumber IN ( 'MS3101','CG01') and  b.cfperiod =  '"+periodNum+"'  and b.cftype = 'W301(加工费)' and  b.cfmaterial= 'JGF002' and (b.cfiscgjz != '1' or b.cfiscgjz is null) and a.CFDoctorNumber = b.CFDoctorNumber  and a.cfclinicnumber = b.cfclinicnumber group by  b.CFDoctorNumber , b.cfperiod ,b.cfclinicnumber  ) ");
			    		//加工费    常规矫正
			    		updatesbr.append(" 	,a.cfjgfcgjz = (select nvl(sum(b.cfamount),0) as  amount  from CT_PAY_CostDetail b  where   b.cfcitynumber IN ( 'MS3101','CG01') and  b.cfperiod =  '"+periodNum+"'  and b.cftype = 'W301(加工费)' and  b.cfmaterial= 'JGF002' and b.cfiscgjz = '1' and a.CFDoctorNumber = b.CFDoctorNumber  and a.cfclinicnumber = b.cfclinicnumber group by  b.CFDoctorNumber , b.cfperiod ,b.cfclinicnumber  ) ");
			    		//加工费    儿牙
			    		updatesbr.append(" ,a.cfjgfey = (select nvl(sum(b.cfamount),0) as  amount  from CT_PAY_CostDetail b  where   b.cfcitynumber IN ( 'MS3101','CG01') and  b.cfperiod =   '"+periodNum+"'  and b.cftype = 'W301(加工费)' and  b.cfmaterial= 'JGF005'  and a.CFDoctorNumber = b.CFDoctorNumber and a.cfclinicnumber = b.cfclinicnumber  group by  b.CFDoctorNumber , b.cfperiod ,b.cfclinicnumber ) ");
			    		//加工费  种植
			    		updatesbr.append("  ,a.cfjgfzz = (select nvl(sum(b.cfamount),0) as  amount  from CT_PAY_CostDetail b  where   b.cfcitynumber IN ( 'MS3101','CG01') and  b.cfperiod =  '"+periodNum+"'  and b.cftype = 'W301(加工费)' and  b.cfmaterial= 'JGF001'  and a.CFDoctorNumber = b.CFDoctorNumber and a.cfclinicnumber = b.cfclinicnumber  group by  b.CFDoctorNumber , b.cfperiod ,b.cfclinicnumber ) "); 
			    		//加工费  修复
				    	updatesbr.append("  ,a.cfjgfxf = (select nvl(sum(b.cfamount),0) as  amount  from CT_PAY_CostDetail b  where   b.cfcitynumber IN ( 'MS3101','CG01') and  b.cfperiod =  '"+periodNum+"'  and b.cftype = 'W301(加工费)' and  b.cfmaterial= 'JGF003'  and a.CFDoctorNumber = b.CFDoctorNumber and a.cfclinicnumber = b.cfclinicnumber  group by  b.CFDoctorNumber , b.cfperiod ,b.cfclinicnumber ) ");
				    	//加工费  口内外
				    	//updatesbr.append("  ,a.cfjgfknw = (select sum(b.cfamount)as  amount  from CT_PAY_CostDetail b  where   b.cfperiod =  '"+periodNum+"'  and b.cftype = 'W301(加工费)' and  b.cfmaterial= ''  and a.CFDoctorNumber = b.CFDoctorNumber   group by  b.CFDoctorNumber , b.cfperiod  ) ");
				    	//加工费  牙周
				    	//updatesbr.append("  ,a.cfjgfyz = (select sum(b.cfamount)as  amount  from CT_PAY_CostDetail b  where   b.cfperiod =  '"+periodNum+"'  and b.cftype = 'W301(加工费)' and  b.cfmaterial= ''  and a.CFDoctorNumber = b.CFDoctorNumber   group by  b.CFDoctorNumber , b.cfperiod  ) ");
				    	//加工费  美白
				    	//updatesbr.append("  ,a.cfjgfmb = (select sum(b.cfamount)as  amount  from CT_PAY_CostDetail b  where   b.cfperiod =  '"+periodNum+"'  and b.cftype = 'W301(加工费)' and  b.cfmaterial= ''  and a.CFDoctorNumber = b.CFDoctorNumber   group by  b.CFDoctorNumber , b.cfperiod  ) ");
			    		
			    		//消耗   种植 1
				    	updatesbr.append(" ,a.cfxhzz = (select nvl(sum(b.cfamount),0) as  amount  from CT_PAY_CostDetail b  where   b.cfcitynumber IN ( 'MS3101','CG01') and  b.cfperiod =  '"+periodNum+"'  and b.CFFirItem = '3'  and a.CFDoctorNumber = b.CFDoctorNumber and a.cfclinicnumber = b.cfclinicnumber  group by  b.CFDoctorNumber , b.cfperiod ,b.cfclinicnumber  ) ");
				    	//消耗   修复 1
				    	updatesbr.append(" ,a.cfxhxf = (select nvl(sum(b.cfamount),0) as  amount  from CT_PAY_CostDetail b  where   b.cfcitynumber IN ( 'MS3101','CG01') and  b.cfperiod =  '"+periodNum+"'  and b.CFFirItem = '2'  and a.CFDoctorNumber = b.CFDoctorNumber and a.cfclinicnumber = b.cfclinicnumber  group by  b.CFDoctorNumber , b.cfperiod ,b.cfclinicnumber  ) ");
				    	//消耗   儿牙  1
				    	updatesbr.append(" ,a.cfxhey = (select nvl(sum(b.cfamount),0) as  amount  from CT_PAY_CostDetail b  where   b.cfcitynumber IN ( 'MS3101','CG01') and  b.cfperiod =  '"+periodNum+"'  and b.CFFirItem = '6'    and a.CFDoctorNumber = b.CFDoctorNumber and a.cfclinicnumber = b.cfclinicnumber  group by  b.CFDoctorNumber , b.cfperiod ,b.cfclinicnumber  ) ");
				    	//消耗   牙周
				    	//updatesbr.append(" ,a.cfxhyz = (select nvl(sum(b.cfamount),0) as  amount  from CT_PAY_CostDetail b  where   b.cfperiod =  '"+periodNum+"'  and b.CFHisChargeItem in (select erji.fnumber from CT_SRQ_Paytypeitem erji left join CT_SRQ_Paytypecategory yiji on yiji.fid = erji.CFCategoryID  where yiji.fnumber = '7'  )     and a.CFDoctorNumber = b.CFDoctorNumber  and a.cfclinicnumber = b.cfclinicnumber group by  b.CFDoctorNumber , b.cfperiod ,b.cfclinicnumber  ) ");
				    	//updatesbr.append(" ,a.cfxhyz = (select nvl(sum(b.cfamount),0) as  amount  from CT_PAY_CostDetail b  where   b.cfperiod =  '"+periodNum+"'  and b.CFFirItem = '7'    and a.CFDoctorNumber = b.CFDoctorNumber and a.cfclinicnumber = b.cfclinicnumber  group by  b.CFDoctorNumber , b.cfperiod ,b.cfclinicnumber  ) ");
				    	updatesbr.append(" ,a.cfxhyz = 0 ");
				    	
				    	//消耗   隐形矫正
				    	updatesbr.append(" ,a.cfxhyxjz = (select nvl(sum(b.cfamount),0) as  amount  from CT_PAY_CostDetail b   where   b.cfcitynumber IN ( 'MS3101','CG01') and  b.cfperiod =  '"+periodNum+"'  and b.CFFirItem ='4' and (b.cfiscgjz != '1' or b.cfiscgjz is null)    and a.CFDoctorNumber = b.CFDoctorNumber and a.cfclinicnumber = b.cfclinicnumber  group by  b.CFDoctorNumber , b.cfperiod ,b.cfclinicnumber  ) ");
				    	//消耗   常规矫正 
				    	updatesbr.append(" ,a.cfxhcgjz = (select nvl(sum(b.cfamount),0) as  amount  from CT_PAY_CostDetail b   where   b.cfcitynumber IN ( 'MS3101','CG01') and  b.cfperiod =  '"+periodNum+"'  and b.CFFirItem ='4'  and b.cfiscgjz = '1'                            and a.CFDoctorNumber = b.CFDoctorNumber and a.cfclinicnumber = b.cfclinicnumber  group by  b.CFDoctorNumber , b.cfperiod ,b.cfclinicnumber  )  ");
				    	//消耗   口内外
				    	updatesbr.append(" ,a.cfxhknw =  (select nvl(sum(b.cfamount),0) as  amount  from CT_PAY_CostDetail b   where   b.cfcitynumber IN ( 'MS3101','CG01') and  b.cfperiod =  '"+periodNum+"'  and b.CFFirItem = '1'  and a.CFDoctorNumber = b.CFDoctorNumber and a.cfclinicnumber = b.cfclinicnumber  group by  b.CFDoctorNumber , b.cfperiod ,b.cfclinicnumber  ) ");
				    	
				    	//消耗 美白
				    	updatesbr.append(" ,a.cfxhmb = (select nvl(sum(b.cfamount),0) as  amount  from CT_PAY_CostDetail b  where   b.cfcitynumber IN ( 'MS3101','CG01') and  b.cfperiod =  '"+periodNum+"'  and b.CFFirItem = '7'    and a.CFDoctorNumber = b.CFDoctorNumber and a.cfclinicnumber = b.cfclinicnumber  group by  b.CFDoctorNumber , b.cfperiod ,b.cfclinicnumber  )   where  a.cfperiod =   '"+periodNum+"' and  a.cfcitynumber IN ( 'MS3101','CG01')  ");
				    	//updatesbr.append("  left join CT_SRQ_PayItem  payitem on payitem.fid = entry.cfitemid  where bill.CFProject = '口内外' and payitem.cfstatus='启用' )    and a.CFDoctorNumber = b.CFDoctorNumber   group by  b.CFDoctorNumber , b.cfperiod  ) ");
				    	System.out.println(updatesbr.toString());
			    		DbUtil.execute(ctx, updatesbr.toString());
			    	}else if(thiscityNumber.equals("MS1101")){
			    	//}else{
			    		StringBuffer updatesbr   = new StringBuffer(" /*dialect*/  update  CT_PAY_CostSum  a set a.CFAmount = ( select nvl(sum(b.cfamount),0) as  amount  from CT_PAY_CostDetail b  where   b.cfcitynumber  = '"+thiscityNumber+"' and  b.cfperiod =   '"+periodNum+"'  and a.CFDoctorNumber = b.CFDoctorNumber and a.cfclinicnumber = b.cfclinicnumber  group by  b.CFDoctorNumber , b.cfperiod  ,b.cfclinicnumber   ) ");
				    	//加工费   隐形矫正
			    		updatesbr.append(" 	 ,a.cfjgfyxjz = (select nvl(sum(b.cfamount),0) as  amount  from CT_PAY_CostDetail b  where   b.cfcitynumber  = '"+thiscityNumber+"' and  b.cfperiod =  '"+periodNum+"'  and b.cftype = 'W301(加工费)' and  b.cfmaterial= 'JGF002' and (b.cfiscgjz != '1' or b.cfiscgjz is null) and a.CFDoctorNumber = b.CFDoctorNumber  and a.cfclinicnumber = b.cfclinicnumber group by  b.CFDoctorNumber , b.cfperiod ,b.cfclinicnumber  ) ");
			    		//加工费    常规矫正
			    		updatesbr.append(" 	,a.cfjgfcgjz = (select nvl(sum(b.cfamount),0) as  amount  from CT_PAY_CostDetail b  where   b.cfcitynumber  = '"+thiscityNumber+"' and  b.cfperiod =  '"+periodNum+"'  and b.cftype = 'W301(加工费)' and  b.cfmaterial= 'JGF002' and b.cfiscgjz = '1' and a.CFDoctorNumber = b.CFDoctorNumber  and a.cfclinicnumber = b.cfclinicnumber group by  b.CFDoctorNumber , b.cfperiod ,b.cfclinicnumber  ) ");
			    		//加工费    儿牙
			    		updatesbr.append(" ,a.cfjgfey = (select nvl(sum(b.cfamount),0) as  amount  from CT_PAY_CostDetail b  where   b.cfcitynumber  = '"+thiscityNumber+"' and  b.cfperiod =   '"+periodNum+"'  and b.cftype = 'W301(加工费)' and  b.cfmaterial= 'JGF005'  and a.CFDoctorNumber = b.CFDoctorNumber and a.cfclinicnumber = b.cfclinicnumber  group by  b.CFDoctorNumber , b.cfperiod ,b.cfclinicnumber ) ");
			    		//加工费  种植
			    		updatesbr.append("  ,a.cfjgfzz = (select nvl(sum(b.cfamount),0) as  amount  from CT_PAY_CostDetail b  where   b.cfcitynumber  = '"+thiscityNumber+"' and  b.cfperiod =  '"+periodNum+"'  and b.cftype = 'W301(加工费)' and  b.cfmaterial= 'JGF001'  and a.CFDoctorNumber = b.CFDoctorNumber and a.cfclinicnumber = b.cfclinicnumber  group by  b.CFDoctorNumber , b.cfperiod ,b.cfclinicnumber ) "); 
			    		//加工费  修复
				    	updatesbr.append("  ,a.cfjgfxf = (select nvl(sum(b.cfamount),0) as  amount  from CT_PAY_CostDetail b  where   b.cfcitynumber  = '"+thiscityNumber+"' and  b.cfperiod =  '"+periodNum+"'  and b.cftype = 'W301(加工费)' and  b.cfmaterial= 'JGF003'  and a.CFDoctorNumber = b.CFDoctorNumber and a.cfclinicnumber = b.cfclinicnumber  group by  b.CFDoctorNumber , b.cfperiod ,b.cfclinicnumber ) ");
				    	//加工费  口内外
				    	//updatesbr.append("  ,a.cfjgfknw = (select sum(b.cfamount)as  amount  from CT_PAY_CostDetail b  where   b.cfperiod =  '"+periodNum+"'  and b.cftype = 'W301(加工费)' and  b.cfmaterial= ''  and a.CFDoctorNumber = b.CFDoctorNumber   group by  b.CFDoctorNumber , b.cfperiod  ) ");
				    	//加工费  牙周
				    	//updatesbr.append("  ,a.cfjgfyz = (select sum(b.cfamount)as  amount  from CT_PAY_CostDetail b  where   b.cfperiod =  '"+periodNum+"'  and b.cftype = 'W301(加工费)' and  b.cfmaterial= ''  and a.CFDoctorNumber = b.CFDoctorNumber   group by  b.CFDoctorNumber , b.cfperiod  ) ");
				    	//加工费  美白
				    	//updatesbr.append("  ,a.cfjgfmb = (select sum(b.cfamount)as  amount  from CT_PAY_CostDetail b  where   b.cfperiod =  '"+periodNum+"'  and b.cftype = 'W301(加工费)' and  b.cfmaterial= ''  and a.CFDoctorNumber = b.CFDoctorNumber   group by  b.CFDoctorNumber , b.cfperiod  ) ");
			    		
				    	//消耗   种植 1
				    	updatesbr.append(" ,a.cfxhzz = (select nvl(sum(b.cfamount),0) as  amount  from CT_PAY_CostDetail b  where   b.cfcitynumber  = '"+thiscityNumber+"' and  b.cfperiod =  '"+periodNum+"'  and b.CFFirItem = '3'  and a.CFDoctorNumber = b.CFDoctorNumber and a.cfclinicnumber = b.cfclinicnumber  group by  b.CFDoctorNumber , b.cfperiod ,b.cfclinicnumber  ) ");
				    	//消耗   修复 1
				    	updatesbr.append(" ,a.cfxhxf = (select nvl(sum(b.cfamount),0) as  amount  from CT_PAY_CostDetail b  where   b.cfcitynumber  = '"+thiscityNumber+"' and  b.cfperiod =  '"+periodNum+"'  and b.CFFirItem = '2'  and a.CFDoctorNumber = b.CFDoctorNumber and a.cfclinicnumber = b.cfclinicnumber  group by  b.CFDoctorNumber , b.cfperiod ,b.cfclinicnumber  ) ");
				    	//消耗   儿牙  1
				    	updatesbr.append(" ,a.cfxhey = (select nvl(sum(b.cfamount),0) as  amount  from CT_PAY_CostDetail b  where   b.cfcitynumber  = '"+thiscityNumber+"' and  b.cfperiod =  '"+periodNum+"'  and b.CFFirItem = '6'    and a.CFDoctorNumber = b.CFDoctorNumber and a.cfclinicnumber = b.cfclinicnumber  group by  b.CFDoctorNumber , b.cfperiod ,b.cfclinicnumber  ) ");
				    	//消耗   牙周
				    	//updatesbr.append(" ,a.cfxhyz = (select nvl(sum(b.cfamount),0) as  amount  from CT_PAY_CostDetail b  where   b.cfperiod =  '"+periodNum+"'  and b.CFHisChargeItem in (select erji.fnumber from CT_SRQ_Paytypeitem erji left join CT_SRQ_Paytypecategory yiji on yiji.fid = erji.CFCategoryID  where yiji.fnumber = '7'  )     and a.CFDoctorNumber = b.CFDoctorNumber  and a.cfclinicnumber = b.cfclinicnumber group by  b.CFDoctorNumber , b.cfperiod ,b.cfclinicnumber  ) ");
				    	updatesbr.append(" ,a.cfxhyz = (select nvl(sum(b.cfamount),0) as  amount  from CT_PAY_CostDetail b left join T_ORG_BaseUnit c on c.fnumber = b.cfcitynumber   where   b.cfcitynumber  = '"+thiscityNumber+"' and  b.cfperiod =  '"+periodNum+"'  and  exists ( SELECT 1 FROM  CT_SRQ_ClinicItem clinicItem left join  CT_SRQ_ClinicItemEntry  entry  on clinicItem.fid = entry.fparentid  left join CT_SRQ_PayItem payItem on payItem.fid = entry.cfitemid  where clinicItem.cfcityid = c.fid  and  clinicItem.cfproject = '牙周' and   b.cfhispaytypedetail = payItem.fnumber)    and a.CFDoctorNumber = b.CFDoctorNumber  and a.cfclinicnumber = b.cfclinicnumber group by  b.CFDoctorNumber , b.cfperiod ,b.cfclinicnumber  ) ");
				    	
				    	//消耗   隐形矫正
				    	updatesbr.append(" ,a.cfxhyxjz = (select nvl(sum(b.cfamount),0) as  amount  from CT_PAY_CostDetail b  left join T_ORG_BaseUnit c on c.fnumber = b.cfcitynumber  where   b.cfcitynumber  = '"+thiscityNumber+"' and  b.cfperiod =  '"+periodNum+"'  and b.CFFirItem ='4' and (b.cfiscgjz != '1' or b.cfiscgjz is null)  and not exists ( SELECT 1 FROM  CT_SRQ_ClinicItem clinicItem left join  CT_SRQ_ClinicItemEntry  entry  on clinicItem.fid = entry.fparentid  left join CT_SRQ_PayItem payItem on payItem.fid = entry.cfitemid  where clinicItem.cfcityid = c.fid and  clinicItem.cfproject = '口内外正畸' and   b.cfhispaytypedetail = payItem.fnumber) and a.CFDoctorNumber = b.CFDoctorNumber and a.cfclinicnumber = b.cfclinicnumber  group by  b.CFDoctorNumber , b.cfperiod ,b.cfclinicnumber  ) ");
				    	//消耗   常规矫正 
				    	updatesbr.append(" ,a.cfxhcgjz = (select nvl(sum(b.cfamount),0)  as  amount  from CT_PAY_CostDetail b left join T_ORG_BaseUnit c on c.fnumber = b.cfcitynumber  where   b.cfcitynumber  = '"+thiscityNumber+"' and  b.cfperiod =  '"+periodNum+"'  and b.CFFirItem ='4'  and b.cfiscgjz = '1'  and not exists ( SELECT 1 FROM  CT_SRQ_ClinicItem clinicItem left join  CT_SRQ_ClinicItemEntry  entry  on clinicItem.fid = entry.fparentid  left join CT_SRQ_PayItem payItem on payItem.fid = entry.cfitemid  where clinicItem.cfcityid = c.fid and  clinicItem.cfproject = '口内外正畸' and   b.cfhispaytypedetail = payItem.fnumber)  and a.CFDoctorNumber = b.CFDoctorNumber and a.cfclinicnumber = b.cfclinicnumber  group by  b.CFDoctorNumber , b.cfperiod ,b.cfclinicnumber  ) ");
				    	//消耗 美白
				    	updatesbr.append(" ,a.cfxhmb = (select nvl(sum(b.cfamount),0) as  amount  from CT_PAY_CostDetail b  where   b.cfcitynumber  = '"+thiscityNumber+"' and  b.cfperiod =  '"+periodNum+"'  and b.CFFirItem = '7' and b.CFHisChargeItem = '43'   and a.CFDoctorNumber = b.CFDoctorNumber and a.cfclinicnumber = b.cfclinicnumber  group by  b.CFDoctorNumber , b.cfperiod ,b.cfclinicnumber  ) where  a.cfperiod =   '"+periodNum+"' and  a.cfcitynumber = '"+thiscityNumber+"'  ");
				    	//消耗   口内外
				    	//updatesbr.append(" ,a.xhknw = (select sum(b.cfamount)as  amount  from CT_PAY_CostDetail b  where   b.cfperiod =  '"+periodNum+"'  and b.CFHIschargeitem in (select payitem.fnumber from CT_SRQ_ClinicItem  bill left join CT_SRQ_ClinicItementry entry on bill.fid = entry.fparentid  ");
				    	//updatesbr.append("  left join CT_SRQ_PayItem  payitem on payitem.fid = entry.cfitemid  where bill.CFProject = '口内外' and payitem.cfstatus='启用' )    and a.CFDoctorNumber = b.CFDoctorNumber   group by  b.CFDoctorNumber , b.cfperiod  ) ");
				    	System.out.println(updatesbr.toString());
			    		DbUtil.execute(ctx, updatesbr.toString());
			    		
			    		//消耗口内外单独处理
			    		ExecutorService pool = Executors.newFixedThreadPool(6);
			    	    ParallelSqlExecutor pe = new ParallelSqlExecutor(pool); 
			    	    CompanyOrgUnitInfo orgUnitInfo = CompanyOrgUnitFactory.getLocalInstance(ctx).getCompanyOrgUnitInfo("where id = '"+companyid+"'");
						String orgNumber = orgUnitInfo.getNumber();
			    		CostSumCollection costSumCollection = CostSumFactory.getLocalInstance(ctx).getCostSumCollection(" where period =  '"+periodNum+"' and  clinicnumber ='"+orgNumber+"' ");
			    		Iterator<CostSumInfo> it = costSumCollection.iterator();
						while(it.hasNext()){
							CostSumInfo costSumInfo = it.next();
							BigDecimal docAmount = new BigDecimal(0);
							String doctorNum = costSumInfo.getDoctorNumber();
							String clinicNumber = costSumInfo.getClinicNumber();
							StringBuffer easSql = new StringBuffer(); 
							easSql.append("/*dialect*/ select distinct CFCityNumber  as CITYNUM from  CT_PAY_CostDetail where  cfclinicnumber = '"+clinicNumber+"'  and CFDoctorNumber = '"+doctorNum+"' and cfperiod =  '"+periodNum+"' ");
							IRowSet rows = DbUtil.executeQuery(ctx, easSql.toString());
							while (rows.next()) {
								String cityNumber = rows.getString("CITYNUM");
								
								StringBuffer amountSql =new StringBuffer() ;
//								amountSql.append("/*dialect*/ select nvl(sum(a.cfamount),0) as AMOUNT from CT_PAY_CostDetail a where a.CFDoctorNumber = '"+doctorNum+"' and a.cfperiod =  '"+periodNum+"' and a.CFCityNumber =  '"+cityNumber+"'  and a.cfclinicnumber =  '"+clinicNumber+"' ");
//								amountSql.append(" and  exists  ( select 1 from CT_SRQ_ClinicItem  bill left join CT_SRQ_ClinicItementry entry on bill.fid = entry.fparentid  left join CT_SRQ_PayItem  payitem on payitem.fid = entry.cfitemid   ");
//								amountSql.append(" left join T_ORG_CtrlUnit ctrlunit on ctrlunit.fid = bill.cfcityid where bill.CFProject = '口内外' and  ctrlunit.fnumber = '"+cityNumber+"' and a.cfhispaytypedetail= payitem.fnumber ) ");
 							
								amountSql.append("/*dialect*/ select nvl(sum(a.cfamount),0) as AMOUNT from CT_PAY_CostDetail a where a.CFDoctorNumber = '"+doctorNum+"' and a.cfperiod =  '"+periodNum+"' and a.CFCityNumber =  '"+cityNumber+"'  and a.cfclinicnumber =  '"+clinicNumber+"' ");
								amountSql.append(" and  exists  ( SELECT  1 FROM  CT_SRQ_ItemCheck bill inner join  CT_SRQ_ItemCheckEntrythi entry on  entry.cfitemid is not null and  bill.fid = entry.fparentid  left JOIN  CT_SRQ_PayItem  item on  item.fid = entry.cfitemid   ");
								amountSql.append(" where  bill.cftypenumber = 'KNW' and bill.cfcityid = '"+cityID+"' and a.CFHisPayTypeDetail = item.fnumber  ) ");
 							
								 
								
								IRowSet rowsAmoount = DbUtil.executeQuery(ctx, amountSql.toString());
								while (rowsAmoount.next()) {
									if(rowsAmoount.getBigDecimal("AMOUNT")!= null  ){
										docAmount = docAmount.add(rowsAmoount.getBigDecimal("AMOUNT"));
									}   
								}
							}
							if(docAmount.compareTo(BigDecimal.ZERO) > 0){
								flag = true;  
								StringBuffer sbfr  = new StringBuffer(" update CT_PAY_CostSum set FLastUpdateTime = sysdate , CFXhknw = "+docAmount+" where fid ='"+costSumInfo.getId().toString()+"' ");
					    		
					    		pe.getSqlList().add(sbfr);
							} 
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
						
						//if( !CostEhrDetailFactory.getLocalInstance(ctx).exists("where businessdate = '"+periodNum+"'")){
						//整理插入 成本EHR详情
//						String  insertCostEhrSql = " /*dialect*/ insert into CT_PAY_CostEhrDetail (FID,FCreatorID,FCreateTime,FLastUpdateUserID,FLastUpdateTime,fcontrolunitid  ,fhandlerid ,fbizdate , " +
//						"  CFHisOrderId,CFFeeItemDetailNumber,CFFeeItemDetail,CFQty,CFCost, cfbusinessdate, cfclinicnumber,cfclinicname )  " +
//						" select newbosid('611BD221'),'"+userId+"',sysdate,'"+userId+"',sysdate,'00000000-0000-0000-0000-000000000000CCE7AED4','"+userId+"' ,sysdate , " +
//						" detail.cfhsiid , detail.cfhispaytypedetail, detail.CFHisPayTypeDetailName, sum(detail.cfqty),sum(detail.cfamount),'"+periodNum+"',detail.cfclinicnumber ,detail.cfclinicname  from CT_PAY_CostDetail  detail where detail.cfclinicnumber = '"+orgNumber+"' " +
//						"  group by  detail.cfhsiid , detail.cfhispaytypedetail,detail.CFHisPayTypeDetailName ,detail.cfclinicnumber ,detail.cfclinicname order by  detail.cfhsiid , detail.cfhispaytypedetail , detail.CFHisPayTypeDetailName ,detail.cfclinicnumber ,detail.cfclinicname ";
//						DBUtil.execute(ctx,insertCostEhrSql);
//						
//						String updatCostEhreSql = " /*dialect*/ update CT_PAY_CostEhrDetail a  set (a.CFCity ,a.cfcitynumber   ,a.cfcasenumber  ,a.cfname   ,a.cfcomplainnumber ,a.cfcomplainname ,a.cffirsource  , " +
//						" a.cfsecsource ,a.cftersource  ,a.cffirvis ,a.cfcreateorg ,a.cfcreater ,a.cfstatus ,a.cfrecdotnumber ,a.cforder  ,a.cfrecdotname ,a.cfnursenumber  ,a.cfrecnurse ,a.cfrecconnumber ,a.cfrecconname , " +
//						" a.cfexcconnumber ,a.cfexcconname  ,a.cffirclassnumber  ,a.cffirclassname ,a.cfsecclassnumber ,a.cfsecclassname  ,a.cfrecperson ,a.CFNurseOrderDiag) =   ( " +
//						" SELECT distinct  b.CFCity ,b.cfcitynumber    ,b.cfcasenumber  ,b.cfname   ,b.cfcomplainnumber ,b.cfcomplainname ,b.cffirsource  , " +
//						" b.cfsecsource ,b.cftersource  ,b.cffirvis ,b.cfcreateorg ,b.cfcreater ,b.cfstatus ,b.cfrecdotnumber ,b.cforder  ,b.cfrecdotname ,b.cfnursenumber  ,b.cfrecnurse ,b.cfrecconnumber ,b.cfrecconname , " +
//						" b.cfexcconnumber ,b.cfexcconname  ,b.cffirclassnumber  ,b.cffirclassname ,b.cfsecclassnumber ,b.cfsecclassname  ,b.cfrecperson , b.CFNurseOrderDiag  FROM CT_PAY_AchieveDetail b where   b.CFHisOrderId = a.CFHisOrderId  and  b.CFFeeItemDetailNumber= a.CFFeeItemDetailNumber and to_char(b.fbizdate,'YYYYMM') ='"+periodNum+"' and  b.cfclinicnumber='"+orgNumber+"' ) where  a.cfbusinessdate = '"+periodNum+"' and  a.cfclinicnumber='"+orgNumber+"'";
//						DBUtil.execute(ctx,updatCostEhreSql); 
					//}
			    	}else{
			    		StringBuffer updatesbr   = new StringBuffer(" /*dialect*/  update  CT_PAY_CostSum  a set a.CFAmount = ( select nvl(sum(b.cfamount),0) as  amount  from CT_PAY_CostDetail b  where   b.cfcitynumber ='"+thiscityNumber+"' and b.cfperiod =   '"+periodNum+"'  and a.CFDoctorNumber = b.CFDoctorNumber and a.cfclinicnumber = b.cfclinicnumber  group by  b.CFDoctorNumber , b.cfperiod  ,b.cfclinicnumber   ) ").append("\r\n");
				    	//加工费   隐形矫正
			    		updatesbr.append(" 	 ,a.cfjgfyxjz = (select nvl(sum(b.cfamount),0) as  amount  from CT_PAY_CostDetail b  where   b.cfcitynumber ='"+thiscityNumber+"' and  b.cfperiod =  '"+periodNum+"'  and b.cftype = 'W301(加工费)' and  b.cfmaterial= 'JGF002' and (b.cfiscgjz != '1' or b.cfiscgjz is null) and a.CFDoctorNumber = b.CFDoctorNumber  and a.cfclinicnumber = b.cfclinicnumber group by  b.CFDoctorNumber , b.cfperiod ,b.cfclinicnumber  ) ").append("\r\n");
			    		//加工费    常规矫正
			    		updatesbr.append(" 	,a.cfjgfcgjz = (select nvl(sum(b.cfamount),0) as  amount  from CT_PAY_CostDetail b  where   b.cfcitynumber ='"+thiscityNumber+"' and  b.cfperiod =  '"+periodNum+"'  and b.cftype = 'W301(加工费)' and  b.cfmaterial= 'JGF002' and b.cfiscgjz = '1' and a.CFDoctorNumber = b.CFDoctorNumber  and a.cfclinicnumber = b.cfclinicnumber group by  b.CFDoctorNumber , b.cfperiod ,b.cfclinicnumber  ) ").append("\r\n");
			    		//加工费    儿牙
			    		updatesbr.append(" ,a.cfjgfey = (select nvl(sum(b.cfamount),0) as  amount  from CT_PAY_CostDetail b  where   b.cfcitynumber ='"+thiscityNumber+"' and  b.cfperiod =   '"+periodNum+"'  and b.cftype = 'W301(加工费)' and  b.cfmaterial= 'JGF005'  and a.CFDoctorNumber = b.CFDoctorNumber and a.cfclinicnumber = b.cfclinicnumber  group by  b.CFDoctorNumber , b.cfperiod ,b.cfclinicnumber ) ").append("\r\n");
			    		//加工费  种植
			    		updatesbr.append("  ,a.cfjgfzz = (select nvl(sum(b.cfamount),0) as  amount  from CT_PAY_CostDetail b  where   b.cfcitynumber  ='"+thiscityNumber+"' and  b.cfperiod =  '"+periodNum+"'  and b.cftype = 'W301(加工费)' and  b.cfmaterial= 'JGF001'  and a.CFDoctorNumber = b.CFDoctorNumber and a.cfclinicnumber = b.cfclinicnumber  group by  b.CFDoctorNumber , b.cfperiod ,b.cfclinicnumber ) ").append("\r\n"); 
			    		//加工费  修复
				    	updatesbr.append("  ,a.cfjgfxf = (select nvl(sum(b.cfamount),0) as  amount  from CT_PAY_CostDetail b  where   b.cfcitynumber ='"+thiscityNumber+"' and  b.cfperiod =  '"+periodNum+"'  and b.cftype = 'W301(加工费)' and  b.cfmaterial= 'JGF003'  and a.CFDoctorNumber = b.CFDoctorNumber and a.cfclinicnumber = b.cfclinicnumber  group by  b.CFDoctorNumber , b.cfperiod ,b.cfclinicnumber ) ").append("\r\n");
				    	//加工费  口内外
				    	//updatesbr.append("  ,a.cfjgfknw = (select sum(b.cfamount)as  amount  from CT_PAY_CostDetail b  where   b.cfperiod =  '"+periodNum+"'  and b.cftype = 'W301(加工费)' and  b.cfmaterial= ''  and a.CFDoctorNumber = b.CFDoctorNumber   group by  b.CFDoctorNumber , b.cfperiod  ) ");
				    	//加工费  牙周
				    	//updatesbr.append("  ,a.cfjgfyz = (select sum(b.cfamount)as  amount  from CT_PAY_CostDetail b  where   b.cfperiod =  '"+periodNum+"'  and b.cftype = 'W301(加工费)' and  b.cfmaterial= ''  and a.CFDoctorNumber = b.CFDoctorNumber   group by  b.CFDoctorNumber , b.cfperiod  ) ");
				    	//加工费  美白
				    	//updatesbr.append("  ,a.cfjgfmb = (select sum(b.cfamount)as  amount  from CT_PAY_CostDetail b  where   b.cfperiod =  '"+periodNum+"'  and b.cftype = 'W301(加工费)' and  b.cfmaterial= ''  and a.CFDoctorNumber = b.CFDoctorNumber   group by  b.CFDoctorNumber , b.cfperiod  ) ");
			    		
				    	//消耗   种植 1
				    	updatesbr.append(" ,a.cfxhzz = (select nvl(sum(b.cfamount),0) as  amount  from CT_PAY_CostDetail b  where   b.cfcitynumber  = '"+thiscityNumber+"' and  b.cfperiod =  '"+periodNum+"'    and a.CFDoctorNumber = b.CFDoctorNumber and a.cfclinicnumber = b.cfclinicnumber  "+
				    			" and (   b.CFFirItem in  ("+zzOneItem+")  or b.CFHisChargeItem in  ("+zzTwoItem+")  or b.cfhispaytypedetail in  ("+zzThreeItem+")   )  \r\n" 
				    			+"group by  b.CFDoctorNumber , b.cfperiod ,b.cfclinicnumber  ) ");
				    	//消耗   修复 1
				    	updatesbr.append(" ,a.cfxhxf = (select nvl(sum(b.cfamount),0) as  amount  from CT_PAY_CostDetail b  where   b.cfcitynumber  = '"+thiscityNumber+"' and  b.cfperiod =  '"+periodNum+"'  "+
				    			" and (   b.CFFirItem in  ("+xfOneItem+")  or b.CFHisChargeItem in  ("+xfTwoItem+")  or b.cfhispaytypedetail in  ("+xfThreeItem+")    )  \r\n"
				    			+"  and a.CFDoctorNumber = b.CFDoctorNumber and a.cfclinicnumber = b.cfclinicnumber  group by  b.CFDoctorNumber , b.cfperiod ,b.cfclinicnumber  ) ");
				    	//消耗   儿牙  1
				    	updatesbr.append(" ,a.cfxhey = (select nvl(sum(b.cfamount),0) as  amount  from CT_PAY_CostDetail b  where   b.cfcitynumber  = '"+thiscityNumber+"' and  b.cfperiod =  '"+periodNum+"'    "+
				    			" and (   b.CFFirItem in  ("+eyOneItem+")  or b.CFHisChargeItem in  ("+eyTwoItem+")  or b.cfhispaytypedetail in  ("+eyThreeItem+")   )  \r\n"
				    			+"    and a.CFDoctorNumber = b.CFDoctorNumber and a.cfclinicnumber = b.cfclinicnumber  group by  b.CFDoctorNumber , b.cfperiod ,b.cfclinicnumber  ) ");
				    	//消耗   牙周
				    	//updatesbr.append(" ,a.cfxhyz = (select nvl(sum(b.cfamount),0) as  amount  from CT_PAY_CostDetail b  where   b.cfperiod =  '"+periodNum+"'  and b.CFHisChargeItem in (select erji.fnumber from CT_SRQ_Paytypeitem erji left join CT_SRQ_Paytypecategory yiji on yiji.fid = erji.CFCategoryID  where yiji.fnumber = '7'  )     and a.CFDoctorNumber = b.CFDoctorNumber  and a.cfclinicnumber = b.cfclinicnumber group by  b.CFDoctorNumber , b.cfperiod ,b.cfclinicnumber  ) ");
				    	updatesbr.append(" ,a.cfxhyz = (select nvl(sum(b.cfamount),0) as  amount  from CT_PAY_CostDetail b left join T_ORG_BaseUnit c on c.fnumber = b.cfcitynumber   where   b.cfcitynumber  = '"+thiscityNumber+"' and  b.cfperiod =  '"+periodNum+"'  "+
				    			" and (   b.CFFirItem in  ("+yzOneItem+")  or b.CFHisChargeItem in  ("+yzTwoItem+")  or b.cfhispaytypedetail in  ("+yzThreeItem+")  )  \r\n"
				    			+"   and a.CFDoctorNumber = b.CFDoctorNumber  and a.cfclinicnumber = b.cfclinicnumber group by  b.CFDoctorNumber , b.cfperiod ,b.cfclinicnumber  ) ");
				    	
				    	if(!zjOneItem.equals("''") || !zjTwoItem.equals("''") || !zjThreeItem.equals("''")   ){
				    		//消耗   正畸
					    	updatesbr.append(" ,a.cfxhcgjz = (select nvl(sum(b.cfamount),0)  as  amount  from CT_PAY_CostDetail b left join T_ORG_BaseUnit c on c.fnumber = b.cfcitynumber  where   b.cfcitynumber  = '"+thiscityNumber+"' and  b.cfperiod =  '"+periodNum+"' "+
					    			" and (   b.CFFirItem in  ("+zjOneItem+")  or b.CFHisChargeItem in  ("+zjTwoItem+")  or b.cfhispaytypedetail in  ("+zjThreeItem+")  )  \r\n"
					    			+"   and a.CFDoctorNumber = b.CFDoctorNumber and a.cfclinicnumber = b.cfclinicnumber  group by  b.CFDoctorNumber , b.cfperiod ,b.cfclinicnumber  ) ");
					    	
				    	}else{
				    		//消耗   常规矫正 
					    	updatesbr.append(" ,a.cfxhcgjz = (select nvl(sum(b.cfamount),0)  as  amount  from CT_PAY_CostDetail b left join T_ORG_BaseUnit c on c.fnumber = b.cfcitynumber  where   b.cfcitynumber  = '"+thiscityNumber+"' and  b.cfperiod =  '"+periodNum+"' "+
					    			" and (   b.CFFirItem in  ("+gdOneItem+")  or b.CFHisChargeItem in  ("+gdTwoItem+")  or b.cfhispaytypedetail in  ("+gdThreeItem+")  )  \r\n"
					    			+"   and b.cfiscgjz = '1'  and a.CFDoctorNumber = b.CFDoctorNumber and a.cfclinicnumber = b.cfclinicnumber  group by  b.CFDoctorNumber , b.cfperiod ,b.cfclinicnumber  ) ");
					    	
				    	}
				    	//消耗   隐形矫正
				    	updatesbr.append(" ,a.cfxhyxjz = (select nvl(sum(b.cfamount),0) as  amount  from CT_PAY_CostDetail b  left join T_ORG_BaseUnit c on c.fnumber = b.cfcitynumber  where   b.cfcitynumber  = '"+thiscityNumber+"' and  b.cfperiod =  '"+periodNum+"' "+
				    			" and (   b.CFFirItem in  ("+yxOneItem+")  or b.CFHisChargeItem in  ("+yxTwoItem+")  or b.cfhispaytypedetail in  ("+yxThreeItem+")   )  \r\n"
				    			+"   and (b.cfiscgjz != '1' or b.cfiscgjz is null)  and a.CFDoctorNumber = b.CFDoctorNumber and a.cfclinicnumber = b.cfclinicnumber  group by  b.CFDoctorNumber , b.cfperiod ,b.cfclinicnumber  ) ");
				    	//消耗 美白
				    	updatesbr.append(" ,a.cfxhmb = (select nvl(sum(b.cfamount),0) as  amount  from CT_PAY_CostDetail b  where   b.cfcitynumber  = '"+thiscityNumber+"' and  b.cfperiod =  '"+periodNum+"' "+
				    			" and (   b.CFFirItem in  ("+mbOneItem+")  or b.CFHisChargeItem in  ("+mbTwoItem+")  or b.cfhispaytypedetail in  ("+mbThreeItem+")   )  \r\n"
				    			+"   and a.CFDoctorNumber = b.CFDoctorNumber and a.cfclinicnumber = b.cfclinicnumber  group by  b.CFDoctorNumber , b.cfperiod ,b.cfclinicnumber  )  ");
				    	//消耗   口内外
				    	updatesbr.append(" ,a.cfxhknw = (select sum(b.cfamount)as  amount  from CT_PAY_CostDetail b  where   b.cfperiod =  '"+periodNum+"'   "+
				    			" and (  b.CFFirItem in  ("+knwOneItem+")  or b.CFHisChargeItem in  ("+knwTwoItem+")  or b.cfhispaytypedetail in  ("+knwThreeItem+")   )  \r\n"
				    			+"  and a.CFDoctorNumber = b.CFDoctorNumber and a.cfclinicnumber = b.cfclinicnumber  group by  b.CFDoctorNumber , b.cfperiod ,b.cfclinicnumber  )  where  a.cfperiod =   '"+periodNum+"' and  a.cfcitynumber = '"+thiscityNumber+"' ");
				    	System.out.println(updatesbr.toString()); 
			    		DbUtil.execute(ctx, updatesbr.toString());
			    	}
					
				}
				
			} catch (BOSException e) {
 				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 *   获取 存货结转明细报告报告头 根据财务组织id 和 会计期间id
	 * @param ctx
	 * @param companyID 财务组织id
	 * @param periodID  会计期间id
	 * @return
	 */
	private static String getRportHeaderID(Context ctx,String companyID,String periodID){
		String handerId ="";
		if(companyID!=null && !"".equals(companyID)&& periodID!=null && !"".equals(periodID)){
		String sql = "/*dialect*/select FID from (select FID from T_CL_CostComputeRportHeader" +
				" where FCOMPANYID = '"+companyID+"' and FPERIODID ='"+periodID+"'"+
				" and not exists(SELECT * from CT_SRQ_CostComputeHeaderLog where CT_SRQ_CostComputeHeaderLog.FNumber = T_CL_CostComputeRportHeader.FID ) "+
				" order by FCREATETIME desc ) where rownum<=1 " ;
		  IRowSet rs = null;
			try {
				rs = com.kingdee.eas.custom.util.DBUtil.executeQuery(ctx,sql);
				if(rs!=null && rs.size() > 0){
					  if(rs.next()){	
						  if(rs.getObject("FID")!=null && !"".equals(rs.getObject("FID").toString()))
							  handerId = rs.getObject("FID").toString();
					  }
				 } 
			} catch (BOSException e) {
				e.printStackTrace();
			} catch (java.sql.SQLException e) {
				e.printStackTrace();
			} 
		}
		return handerId;
	}
	
	
	private static List<String> getLISHIBillNumberByComIDAndPeriod(Context ctx,String companyid , String period){
		List<String>  list = new ArrayList<String> ();
		if(companyid!=null && !"".equals(companyid)){
		String sql ="/*dialect*/select DISTINCT a.FNUMBER  as FBILLNUMBER  from T_IM_SaleIssueBill a "+
		" INNER JOIN T_IM_SALEISSUEENTRY b on a.FID =b.FPARENTID "+
		" where a.FMONTH ='"+period+"' and a.FSTORAGEORGUNITID ='"+companyid+"'  and "+
		" b.FACTUALCOST > 0 and b.CFHISMINGXIID is not null and b.CFHISSFXMID is not null and "+
		" a.cfhisdanjubianma is not null  and a.CFHISREQID is not null    ";

		IRowSet rs = null;
			try {
				rs = com.kingdee.eas.custom.util.DBUtil.executeQuery(ctx,sql);
				if(rs!=null && rs.size() > 0){
					  while(rs.next()){	
						  if(rs.getObject("FBILLNUMBER")!=null && !"".equals(rs.getObject("FBILLNUMBER").toString()))
							  list.add(rs.getObject("FBILLNUMBER").toString());
					  }
				 } 
			} catch (BOSException e) {
				e.printStackTrace();
			} catch (java.sql.SQLException e) {
				e.printStackTrace();
			} 
		}
		return list;
	}
	

	private static CoreBaseCollection createCostDetail(Context ctx,SaleIssueBillInfo info,String periodNum,status st){
		 SaleIssueHisLogInfo logInfo =null;
		 CoreBaseCollection items = new CoreBaseCollection();
		 UserInfo userInfo = ContextUtil.getCurrentUserInfo(ctx);
		 Calendar cal=Calendar.getInstance();
	    cal.setTime(new Date());
	    Timestamp tt =  new Timestamp(cal.getTimeInMillis());
		 try{
	 		 if(info.get("hisdanjubianma")!=null&&!"".equals(info.get("hisdanjubianma").toString())
	 			//&&info.get("HisReqID")!=null&&!"".equals(info.get("HisReqID").toString())
	 			&&info.getBizType()!=null && info.getBizType().getId()!=null&&
	 			"d8e80652-010e-1000-e000-04c5c0a812202407435C".equals(info.getBizType().getId().toString())
	 			){
	 			//&&!info.getNumber().startsWith("*VMI")){
	 		       String saleNumber = info.getNumber(); 
	 		       
	 		       //城市
	 		       CtrlUnitInfo cityInfo =  CtrlUnitFactory.getLocalInstance(ctx).getCtrlUnitInfo(" where id = '"+info.getCU().getId()+"'");
	 		       
	 		       //公司
	 		       StorageOrgUnitInfo  company =  StorageOrgUnitFactory.getLocalInstance(ctx).getStorageOrgUnitInfo( new ObjectUuidPK(info.getStorageOrgUnit().getId()) ) ;
	 		       
	 		       //医生
	 		      PersonInfo person = null; 
	 		       if(info.get("yisheng")!=null&&!"".equals(info.get("yisheng").toString())){
	 		    	   person = PersonFactory.getLocalInstance(ctx).getPersonInfo( new ObjectUuidPK (((PersonInfo) info.get("yisheng")).getId()))   ;
	 		       } 
			 		   
			 		   SaleIssueEntryCollection entryCollection = info.getEntry();
				       Iterator<SaleIssueEntryInfo> it = entryCollection.iterator(); 
				       ISaleIssueHisLog ish = SaleIssueHisLogFactory.getLocalInstance(ctx);
					 while (it.hasNext()) { 
				    	 SaleIssueEntryInfo  entry = it.next();
				    	 String mateiralid = entry.getMaterial().getId().toString();
				    	 //高值
				    	 String sqlMaterialW1 = " select  count(1) as NUM  from  T_BD_Material material  left join  T_BD_MaterialGroup mgroup on mgroup.fid = material.FMATERIALGROUPID "+ 
				    		 	" where material.fid  = '"+mateiralid+"' and mgroup.fid = 'Dtmk86FlSCmVG2q3RQFBp8efwEI='"; 
				    	 RowSet row = DbUtil.executeQuery(ctx, sqlMaterialW1 );
				    	 int  flag = 0;
				    	 while(row.next()){	
							  if(row.getObject("NUM")!=null && !"".equals(row.getObject("NUM").toString()))
								 if( Integer.parseInt(row.getObject("NUM").toString()) > 0 )
									 flag = 1; 
						  }
				    	 
				    	 //加工费
				    	 if(flag ==0){
				    		 String sqlMaterialW301 = " select  count(1) as NUM  from  T_BD_Material material  left join  T_BD_MaterialGroup mgroup on mgroup.fid = material.FMATERIALGROUPID "+ 
				    		 	" where material.fid  = '"+mateiralid+"' and mgroup.fid = 'J8UPSmsXTsiFAotNMetsXsefwEI='"; 
					    	 RowSet row2 = DbUtil.executeQuery(ctx, sqlMaterialW301 ); 
					    	 while(row2.next()){	
								  if(row2.getObject("NUM")!=null && !"".equals(row2.getObject("NUM").toString()))
									 if( Integer.parseInt(row2.getObject("NUM").toString()) > 0 )
										 flag = 2; 
							  } 
				    	 }
				    	
				    	 
				    	 if( //entry.get("hismingxiid")!=null && !"".equals(entry.get("hismingxiid").toString())&&
						    		"8r0AAAAEaOnC73rf".equals(entry.getInvUpdateType().getId().toString()) && flag !=0){
				    		 	//遍历销售出库单分录，判断是否是高值  ，如果是  设置成本明细数据
					    		CostDetailInfo item = new CostDetailInfo();
					    		//城市
					    		item.setCityNumber(cityInfo.getNumber());
					    		item.setCityName(cityInfo.getName());
					    		//公司
					    		item.setClinicNumber(company.getNumber());
					    		item.setClinicName(company.getName());
					    		//医生
					    		if(person != null){
					    			item.setDoctorNumber(person.getNumber());
						    		item.setDoctorName(person.getName());
						    		
						    		item.setDocAndClinic(person.getNumber()+company.getNumber());
					    		}
					    		
					    		//销售出库编码
					    		item.setSaleOutNumber(saleNumber);
					    		//his销售订单id  HIS销售订单分录ID  ？
					    		item.setHsiId(info.get("HISdanjubianma").toString());
					    		item.setHisDetailID(entry.get("saleentryid")==null?"":entry.get("saleentryid").toString());
					    		if(entry.get("saleentryid")!=null){
					    			if(entry.get("saleentryid").toString().startsWith("SALE"))
						    			item.setHisDetailID(entry.get("saleentryid").toString().substring(4));
							    	else
							    		item.setHisDetailID(entry.get("saleentryid").toString());	
					    		}else{
					    			item.setHisDetailID("");	
					    		}
					    		
					    		
					    		//技加工物料
					    		MaterialInfo  materialInfo  = MaterialFactory.getLocalInstance(ctx).getMaterialInfo(new ObjectUuidPK(entry.getMaterial().getId()) ) ;
					    		item.setMaterial(materialInfo.getNumber());
					    		item.setMaterialName(materialInfo.getName());
					    		
					    		if(flag == 1){
					    			item.setType("W1(高值)"); 
					    			
					    		}else if(flag == 2 ){
					    			item.setType("W301(加工费)");
					    			/*if(materialInfo.getNumber().equals("JGF002")){
					    				item.setIscgjz(entry.getString("iscgjz")) ;
					    			}*/
					    		}
					    		
					    		
					    		if(entry.get("hisFirstItem") != null){
					    			item.setFirItem(entry.getString("hisFirstItem"));
					    		}
					    		if(entry.get("hisFirstItemName") != null){
					    			item.setFirItemName(entry.getString("hisFirstItemName"));
					    		}
					    		
					    		if(entry.get("hisChargeItemID") != null){
					    			item.setHisChargeItem(entry.getString("hisChargeItemID"));
					    		}
					    		if(entry.get("hisChargeItem") != null){
					    			item.setHisChargeItemName(entry.getString("hisChargeItem"));
					    		}
					    		/*if(entry.get("hismingxiid") != null){
					    			item.setHisPayTypeDetail(entry.getString("hismingxiid"));
					    		} */
					    		if(entry.get("hissfxmid") != null){
					    			item.setHisPayTypeDetail(entry.getString("hissfxmid"));
					    		} 
					    		/*if(entry.get("hisshoufeixiangmumingxi") != null){
					    			item.setHisPayTypeDetailName(entry.getString("hisshoufeixiangmumingxi"));
					    		}*/
					    		/*if(entry.get("hisshoufeixiangmumingxi") != null){
					    			item.setHisPayTypeDetailName(entry.getString("hisshoufeixiangmumingxi"));
					    		}*/
					    		if(entry.get("hissfxm") != null){
					    			item.setHisPayTypeDetailName(entry.getString("hissfxm"));
					    		}
					    		
					    		if(entry.get("iscgjz") != null){
					    			item.setIscgjz(entry.getString("iscgjz")) ;
					    		}
					    		
					    		
					    		item.setAmount(entry.getActualCost());
					    		item.setQty(entry.getQty()); 
					    		item.setPrice(entry.getSalePrice());  
					    		item.setRemark(entry.getRemark());
					    		
					    		item.setPeriod(periodNum); 
					    		
					    		
					    		CtrlUnitInfo cu = new CtrlUnitInfo();
						    	cu.setId(BOSUuid.read("00000000-0000-0000-0000-000000000000CCE7AED4"));
						    	item.setCU(cu);  
					    		item.setBizDate(new Date());
					    		item.setHandler(userInfo);
					    		item.setCreator(userInfo);
					    		item.setCreateTime(tt);
					    		item.setLastUpdateTime(tt);
					    		item.setLastUpdateUser(userInfo);
					    		
					    		if(st == status.Cost){
					    			if(!judgeCostDetailExists(ctx,item) ){
					    				items.add(item);
					    			}
					    		}
					    		
				    	 }
				     } 
	  		        
	 		   }
	 		}catch(Exception e){
				AppUnit.insertLog(ctx, DateBaseProcessType.AddNew, DateBasetype.HIS_SaleOut,info.getNumber(),info.getNumber(),"成本汇总单据保存失败");//记录日志
	 		}
	 	 return items;
	}
	
	private static boolean judgeCostDetailExists(Context ctx,CostDetailInfo info){
		boolean flag = false;
		String sql = "select count(1) C from CT_PAY_CostDetail " +
				" where CFCITYNUMBER = '"+info.getCityNumber()+"' and CFCLINICNUMBER = '"+info.getClinicNumber()+"' " +
			    " and CFDOCTORNUMBER = '"+info.getDoctorNumber()+"' and CFSaleOutNumber = '"+info.getSaleOutNumber()+"'" +
			    " and CFHsiId = '"+info.getHsiId()+"'  and CFMaterial ='"+info.getMaterial()+"' and cfperiod = '"+info.getPeriod()+"' ";
		if(info.getHisDetailID() != null  && !"".equals(info.getHisDetailID()) ){
			sql = sql + " and CFHisDetailID =   '"+info.getHisDetailID()+"' ";
		}
		  IRowSet rs = null;
			try {
				rs = com.kingdee.eas.custom.util.DBUtil.executeQuery(ctx,sql);
				if(rs!=null && rs.size() > 0){
					  while(rs.next()){	
						  if(rs.getObject("C")!=null && !"".equals(rs.getObject("C").toString()))
							 if( Integer.parseInt(rs.getObject("C").toString()) > 0 )
								 flag = true; 
					  }
				 } 
			} catch (BOSException e) {
				e.printStackTrace();
			} catch (java.sql.SQLException e) {
				e.printStackTrace();
			} 
		
		return flag ;
	}
}
