package com.kingdee.eas.mw.srqr.app.util;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.icepdf.core.pobjects.fonts.a;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.kingdee.bos.Context;
import com.kingdee.bos.util.BOSUuid;
import com.kingdee.eas.basedata.org.CompanyOrgUnitFactory;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.basedata.org.CtrlUnitInfo;
import com.kingdee.eas.custom.util.DBUtil;
import com.kingdee.eas.mw.pay.ConsultKeepFactory;
import com.kingdee.eas.mw.pay.ConsultKeepInfo;
import com.kingdee.eas.mw.pay.ConsultantProFactory;
import com.kingdee.eas.mw.pay.ScalingCountSumFactory;
import com.kingdee.eas.mw.pay.ScalingTypeInfo;
import com.kingdee.eas.mw.pay.app.PaypostType;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.jdbc.rowset.IRowSet;

public class PayFunctionService {
	private Logger log;
	public PayFunctionService() {
		this.log = LoggerFactory.getLogger(PayFunctionService.class);
	}

	/**
	 * 获取洁牙奖金
	 */
//	public HashMap<String,String> getScalingBonus(Context ctx,String empNum,  String cityNumber,String periodnum,String cityId,HashMap tempMap){
//		HashMap<String,String>  djieyaMap = new HashMap<String,String>();
//		double money = 0.0D;
//		if(empNum == null || empNum.equals("")){
//			this.log.error("员工编码不能为空");
//			return null;
//		}else if(periodnum == null || periodnum.equals("")){
//			this.log.error("期间不能为空");
//			return null;
//		}  
//		try {  
//			//先判断是不是洁牙师
//			if((null == tempMap) || (null == tempMap.get(empNum+"JY")) || "".equals(tempMap.get(empNum+"JY").toString()) ){
//				return null;
//			}else{
//				djieyaMap.put("postType", "JYS");
//				
//				BigDecimal jycount =BigDecimal.ZERO;
//				BigDecimal placount =BigDecimal.ZERO;
//				String importJy = " /*dialect*/ SELECT nvl(sum(cfjycount),0) as JY ,  nvl(sum(cfplacount),0) as PLA FROM  CT_PAY_ScalingBonusUpdate  where cfempnumber = '"+empNum+"' and cfcityid = '"+cityId+"' and cfbusinessdate = '"+periodnum+"'";
//				IRowSet rsImpMb =  DBUtil.executeQuery(ctx,importJy);
//				if(rsImpMb!=null && rsImpMb.size() > 0){
//					  while(rsImpMb.next()){
//						  jycount = new BigDecimal(rsImpMb.getString("JY")); 
//						  placount = new BigDecimal(rsImpMb.getString("PLA")); 
//						  
//						  djieyaMap.put("imjy", jycount.toString());
//						  djieyaMap.put("impla", placount.toString());
//					  }
//				} 
//				BigDecimal  moneyBig = BigDecimal.ZERO; 
//				
//				
//				//是洁牙师
//				//String sqlMBStr = "  /*dialect*/ select  count(1) as thiscount   from  CT_PAY_AchieveDetailTem where  CFRecDotNumber ='"+empNum+"'  and CFClinicNumber='"+clinicNumber+"' and  cfsecclassnumber= '679' and cffirclassnumber= '7' and CFFeeItemDetailNumber != '18658' and  to_char(fbizdate,'YYYYMM') ='"+periodnum+"'  ";
//				String sqlMBStr = "  /*dialect*/ select  count(1) as thiscount   from  CT_PAY_AchieveDetailTem where  CFRecDotNumber ='"+empNum+"'  and  cfcityNumber='"+cityNumber+"'    and  to_char(fbizdate,'YYYYMM') ='"+periodnum+"' "+
//				 "and (EXISTS (SELECT  1 FROM  CT_SRQ_ItemCheck bill inner join  CT_SRQ_ItemCheckentry entry on   bill.fid = entry.fparentid  left JOIN  CT_SRQ_Paytypecategory  item on  item.fid = entry.cffirstitemid  where  bill.cftypenumber = 'JY' and bill.cfcityid = '"+cityId+"'  and  CT_PAY_AchieveDetailTem.CFFirClassNumber = item.fnumber ) "+
//				 "or  EXISTS (SELECT  1 FROM  CT_SRQ_ItemCheck bill inner join  CT_SRQ_ItemCheckEntrysec entry on   bill.fid = entry.fparentid  left JOIN  CT_SRQ_Paytypeitem item on  item.fid = entry.cfseconditemid  where  bill.cftypenumber = 'JY' and bill.cfcityid = '"+cityId+"'  and  CT_PAY_AchieveDetailTem.CFSecClassnumber = item.fnumber ) "+
//				 "or  EXISTS (SELECT  1 FROM  CT_SRQ_ItemCheck bill inner join  CT_SRQ_ItemCheckEntrythi entry on   bill.fid = entry.fparentid  left JOIN  CT_SRQ_PayItem  item on  item.fid = entry.cfitemid  where  bill.cftypenumber = 'JY' and bill.cfcityid = '"+cityId+"' and  CT_PAY_AchieveDetailTem.cffeeitemdetailNUMBER = item.fnumber ) )  ";
//				
//				//HashMap<String,Object> jymap = new HashMap<String,Object>();
//				//HashMap<String,Object> plamap = new HashMap<String,Object>();
//				IRowSet rsMb =  DBUtil.executeQuery(ctx,sqlMBStr);
//				if(rsMb!=null && rsMb.size() > 0){
//					while(rsMb.next()){	
//						djieyaMap.put("xtjy", rsMb.getString("THISCOUNT"));
//						djieyaMap.put("jy", new BigDecimal(rsMb.getString("THISCOUNT")).add(jycount).toString());
//						moneyBig = moneyBig.add(new BigDecimal(rsMb.getString("THISCOUNT")).add(jycount).multiply(new BigDecimal(tempMap.get("jyJY")==null ? "0":tempMap.get("jyJY").toString())));
//					}
//				}else{
//					djieyaMap.put("jy", jycount.toString());
//					djieyaMap.put("xtjy", "0");
//				}
//				
//				//String sqlPLAStr = "  /*dialect*/ select count(1) as thiscount    from  CT_PAY_AchieveDetailTem where  CFRecDotNumber ='"+empNum+"'  and CFClinicNumber='"+clinicNumber+"' and  cfsecclassnumber= '679' and cffirclassnumber= '7' and CFFeeItemDetailNumber = '18658' and  to_char(fbizdate,'YYYYMM') ='"+periodnum+"'   ";
//				String sqlPLAStr = "  /*dialect*/ select count(1) as thiscount    from  CT_PAY_AchieveDetailTem where  CFRecDotNumber ='"+empNum+"' and  cfcityNumber='"+cityNumber+"' and  to_char(fbizdate,'YYYYMM') ='"+periodnum+"' and "+
//				"(EXISTS ( SELECT  1 FROM  CT_SRQ_ItemCheck bill inner join  CT_SRQ_ItemCheckentry entry on   bill.fid = entry.fparentid  left JOIN  CT_SRQ_Paytypecategory  item on  item.fid = entry.cffirstitemid  where  bill.cftypenumber = 'PLA' and bill.cfcityid = '"+cityId+"' and  CT_PAY_AchieveDetailTem.CFFirClassNumber = item.fnumber ) "+
//					" or  EXISTS (SELECT  1 FROM  CT_SRQ_ItemCheck bill inner join  CT_SRQ_ItemCheckEntrysec entry on   bill.fid = entry.fparentid  left JOIN  CT_SRQ_Paytypeitem item on  item.fid = entry.cfseconditemid  where  bill.cftypenumber = 'PLA' and bill.cfcityid = '"+cityId+"' and  CT_PAY_AchieveDetailTem.CFSecClassnumber = item.fnumber ) "+
//					" or  EXISTS (SELECT  1 FROM  CT_SRQ_ItemCheck bill inner join  CT_SRQ_ItemCheckEntrythi entry on   bill.fid = entry.fparentid  left JOIN  CT_SRQ_PayItem  item on  item.fid = entry.cfitemid  where  bill.cftypenumber = 'PLA' and bill.cfcityid = '"+cityId+"' and  CT_PAY_AchieveDetailTem.cffeeitemdetailNUMBER = item.fnumber ) )    ";
//				IRowSet rsPLA =  DBUtil.executeQuery(ctx,sqlPLAStr);
//				if(rsPLA!=null && rsPLA.size() > 0){
//					while(rsPLA.next()){	 
//						djieyaMap.put("xtpla", rsPLA.getString("THISCOUNT"));
//						djieyaMap.put("pla", new BigDecimal(rsPLA.getString("THISCOUNT")).add(placount).toString());
//						moneyBig = moneyBig.add(new BigDecimal(rsPLA.getString("THISCOUNT")).add(placount).multiply(new BigDecimal(tempMap.get("plaJY")==null ? "0":tempMap.get("plaJY").toString())));
//					}
//				}else{
//					djieyaMap.put("pla", placount.toString());
//					djieyaMap.put("xtpla", "0");
//				}  
//				moneyBig.setScale(2,BigDecimal.ROUND_HALF_UP);
//				money =moneyBig.doubleValue();
//				
//				djieyaMap.put("jieyaBonus", money+"");
//			} 
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			this.log.error("系统出现异常，请联系管理员");
//		}  
//		return djieyaMap; 
//	}
	
	/**
	 * 获取洁牙奖金
	 */
	public HashMap<String,String> getScalingBonus(Context ctx,String empNum,  String cityNumber,String periodnum,String cityId,HashMap tempMap,String postNumber
			,Map<String, BigDecimal> scalingMap,HashMap<String,HashMap<String,String>> jyitemMessage,String jyTypeStr ){
		HashMap<String,String>  djieyaMap = new HashMap<String,String>();
		double money = 0.0D;
		if(empNum == null || empNum.equals("")){
			this.log.error("员工编码不能为空");
			return null;
		}else if(periodnum == null || periodnum.equals("")){
			this.log.error("期间不能为空");
			return null;
		}  
		try {  
			//先判断是不是洁牙师
			if((null == tempMap) || (null == tempMap.get(empNum+"JY")) || "".equals(tempMap.get(empNum+"JY").toString()) ){
				return null;
			}else{
				djieyaMap.put("postType", "JYS");
				
				HashMap<String,String> typeMap = new HashMap<String,String>();
				
				String sqlMBStr = "/*dialect*/ ";
				ArrayList<String> arrayList = new ArrayList<String>();
				arrayList = (ArrayList<String>) tempMap.get(cityId+"_JY");
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
						 
						typeMap.put(typeNumber, jyid);
					} 
					
					String  inoneNumber = jyitemMessage.get("one").get(typeNumber);
					String  intwoNumber =  jyitemMessage.get("two").get(typeNumber);
					String  inthreeNumber =  jyitemMessage.get("three").get(typeNumber);
					 
					if(i >0 ){
						sqlMBStr = sqlMBStr+" union ";
					}
					sqlMBStr = sqlMBStr + "  select  count(1) as thiscount  , '"+typeNumber+"' as type  from  CT_PAY_AchieveDetailTem where  "+jyTypeStr+" ='"+empNum+"'  and  cfcityNumber='"+cityNumber+"'    and  to_char(fbizdate,'YYYYMM') ='"+periodnum+"' "+
					 "and ( CT_PAY_AchieveDetailTem.CFFirClassNumber in  ( "+inoneNumber+" ) "+
					 "or   CT_PAY_AchieveDetailTem.CFSecClassnumber in  ( "+intwoNumber+" ) "+
					 "or  CT_PAY_AchieveDetailTem.cffeeitemdetailNUMBER in  ( "+inthreeNumber+" ) )  "; 
					
					i++; 
				} 
				
				IRowSet rsMb =  DBUtil.executeQuery(ctx,sqlMBStr);
				if(rsMb!=null && rsMb.size() > 0){
					while(rsMb.next()){	
						
						String typeNumber = rsMb.getString("TYPE");
						
						BigDecimal jycount =BigDecimal.ZERO;
						BigDecimal xtjycount =BigDecimal.ZERO;
						BigDecimal imjycount =BigDecimal.ZERO; 
						
						imjycount =  scalingMap.get(empNum+"_"+typeNumber +"_IM")==null?BigDecimal.ZERO:scalingMap.get(empNum+"_"+typeNumber +"_IM");     
						xtjycount = new BigDecimal( rsMb.getString("THISCOUNT"));  
						jycount = xtjycount.add(imjycount);

						if(jycount.compareTo(BigDecimal.ZERO) != 0 || xtjycount.compareTo(BigDecimal.ZERO) != 0  || imjycount.compareTo(BigDecimal.ZERO) != 0  ){
							com.kingdee.eas.mw.pay.ScalingCountSumInfo scalingCount = new com.kingdee.eas.mw.pay.ScalingCountSumInfo();
							scalingCount.setBusinessDate(periodnum);
							scalingCount.setCityNumber(cityNumber);
							scalingCount.setCityName(tempMap.get(cityNumber).toString());
							scalingCount.setEmpNumber(empNum); 
							scalingCount.setEmpName(tempMap.get("empName").toString());
							
							String typeid = typeMap.get(typeNumber);
							ScalingTypeInfo type = new ScalingTypeInfo();
							type.setId(BOSUuid.read(typeid));
							scalingCount.setType(type);
							scalingCount.setXtCount(xtjycount);
							scalingCount.setImpCount(imjycount);
							scalingCount.setAllCount(jycount);
							scalingCount.setPost(PaypostType.getEnum(postNumber));
							ScalingCountSumFactory.getLocalInstance(ctx).save(scalingCount);
						} 
					}
				} 
				
				djieyaMap.put("jieyaBonus", money+"");
			} 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.log.error("系统出现异常，请联系管理员");
		}  
		return djieyaMap;
		
	}
	
	/**
	 * 获取美白奖金
	 */
	public HashMap<String,String> getWhiteBonus(Context ctx,String empNum, String cityNumber,String periodnum,String cityId,HashMap tempMap
			,Map<String, BigDecimal> meibaiMap,HashMap<String,HashMap<String,String>> itemMessage){
		HashMap<String,String>  mbMap = new HashMap<String,String>();
		//Context ctx = Tools.getInstance().getCtx(); 
		double money = 0.0D;
		if(empNum == null || empNum.equals("")){
			this.log.error("员工编码不能为空");
			return  null;
		}else if(periodnum == null || periodnum.equals("")){
			this.log.error("期间不能为空");
			return  null;
		} 
		 
		try {
			if((null == tempMap) || (null == tempMap.get(empNum+"MB")) || "".equals(tempMap.get(empNum+"MB").toString()) ){
				return  null;
			}else{
				BigDecimal  achieve = BigDecimal.ZERO; 
				mbMap.put("postType", "JYS");
				
				
				BigDecimal mbachieve =BigDecimal.ZERO;
				if(meibaiMap.get(empNum+"_MB_"+cityId)!= null){
					mbachieve = meibaiMap.get(empNum+"_MB_"+cityId);
					mbMap.put("immbAchieve", mbachieve.toString());
				} 
				String qudao = "";
				BigDecimal  yijibl = new BigDecimal("0");
				BigDecimal  erjibl = new BigDecimal("0"); 
				String  inoneNumber = itemMessage.get("one").get("MB");
				String  intwoNumber = itemMessage.get("two").get("MB");
				String  inthreeNumber = itemMessage.get("three").get("MB");
				 
				
				String mbbili  = tempMap.get("MBBILI")==null?"0":tempMap.get("MBBILI").toString();
				//String sqlMBStr = " /*dialect*/   select nvl(sum(CFIncome)*"+mbbili+",0) as MBMONEY    from  CT_PAY_AchieveDetailTem where   CFRecDotNumber ='"+empNum+"'  and CFClinicNumber='"+clinicNumber+"' and  cfsecclassnumber= '43' and cffirclassnumber= '7' and  cfbusinessdate ='"+periodnum+"'   ";
				String sqlMBStr = "  /*dialect*/ select ( nvl(aa.summ,0)) as  MBACHIEVE  from (  "+
				" select sum(a.allm) as summ from (  SELECT nvl(sum(CFDOCACHIEVE),0) as allm FROM  CT_PAY_AchieveDetailTem where    CFRecDotNumber ='"+empNum+"' and cfcitynumber= '"+cityNumber+"'   and  to_char(fbizdate,'YYYYMM') ='"+periodnum+"' "+
				"and ( CT_PAY_AchieveDetailTem.CFFirClassNumber  in  ( "+inoneNumber+" ) "+
				"or  CT_PAY_AchieveDetailTem.CFSecClassnumber in (  "+intwoNumber+" ) "+
				"or  CT_PAY_AchieveDetailTem.cffeeitemdetailNUMBER  in ( "+inthreeNumber+" ) )    )  a ) aa "; 
				
				
				IRowSet rsmb =  DBUtil.executeQuery(ctx,sqlMBStr);
				if(rsmb!=null && rsmb.size() > 0){
					 while(rsmb.next()){	
						 achieve= new BigDecimal(rsmb.getString("MBACHIEVE")).setScale(2,BigDecimal.ROUND_HALF_UP);
						 mbMap.put("xtmbAchieve", achieve.toString());
						 mbMap.put("mbAchieve", achieve.add(mbachieve).toString());
						 mbMap.put("meiibaiBonus", achieve.add(mbachieve).multiply(new BigDecimal(mbbili)).toString());
					 }
				}
				
				money =achieve.doubleValue();
				//money = Double.parseDouble(tempMap.get(key).toString()); 
			} 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.log.error("系统出现异常，请联系管理员");
		}  
		
		return mbMap;
		
	}
	
	
	/**
	 * 获取咨询师奖金
	 */
//	public HashMap<String,String> getConsultantBonus(Context ctx,String empNum, String cityNumber,String periodnum,String cityId,HashMap tempMap){
//		//Context ctx = Tools.getInstance().getCtx(); 
//		HashMap<String,String>  zxMap = new HashMap<String,String>();
//		double money = 0.0D;
//		if(empNum == null || empNum.equals("")){
//			this.log.error("员工编码不能为空");
//			return null;
//		}else if(periodnum == null || periodnum.equals("")){
//			this.log.error("期间不能为空");
//			return null;
//		}
//		 
//		try { 
//			//判断是否是咨询师 
//			if((null == tempMap) || (null == tempMap.get(empNum+"_ZX")) || "".equals(tempMap.get(empNum+"_ZX").toString()) ){
//				 
//			}else{  
//				int bzyy = 8;
//				if( null !=tempMap.get("biaozhunYY") && !"".equals(tempMap.get("biaozhunYY"))){
//					bzyy =Integer.parseInt(tempMap.get("biaozhunYY").toString());
//				}
//				  
//				HashMap blmap = new HashMap();
//			
//				if(tempMap.get(empNum+"_"+"_SHOP") == null){
//					if(tempMap.get( "xd_YY") != null){
//						blmap = (HashMap) tempMap.get("xd_YY");
//					}else if(tempMap.get( "xd_YY") != null){
//						blmap = (HashMap) tempMap.get("dd_YY");
//					}
//				}else{
//					String shopSize =tempMap.get(empNum+"_"+"_SHOP").toString();
//					blmap = (HashMap) tempMap.get(shopSize+"_YY");
//				}
//				
//				
//				BigDecimal first = new BigDecimal(blmap.get("CFFIRST").toString());
//				BigDecimal firstMoney = new BigDecimal(blmap.get("CFFIRSTMONEY").toString());
//				BigDecimal second = new BigDecimal(blmap.get("CFSECOND").toString());
//				BigDecimal secondMoney = new BigDecimal(blmap.get("CFSECONDMONEY").toString());
//				BigDecimal third = new BigDecimal(blmap.get("CFTHIRD").toString());
//				
//				BigDecimal moneyBig = BigDecimal.ZERO;
//				
//				
//				String zximSql = "/*dialect*/SELECT nvl(sum(cfzxachieve),0) as ZX FROM  CT_PAY_ConsultantBonusUpdate   where cfempnumber = '"+empNum+"' and cfcityid = '"+cityId+"' and cfbusinessdate = '"+periodnum+"'";
//				IRowSet rsImZX =  DBUtil.executeQuery(ctx,zximSql);
//				if(rsImZX!=null && rsImZX.size() > 0){
//					  while(rsImZX.next()){	
//						  moneyBig = new BigDecimal(rsImZX.getString("ZX"));
//						  zxMap.put("imzxAchieve",moneyBig.toString());
//					  }
//				 } 
//				 
//				
//				String  zxZiDuan = "CFRecConNumber";
//				if(periodnum.equals("202012")){
//					zxZiDuan = "CFExcConNumber";
//				}else{
//					String zxziduanSql = "/*dialect*/SELECT distinct (CASE   WHEN FDESCRIPTION_L2 is  null  THEN 'CFRecConNumber' WHEN FDESCRIPTION_L2= '0'  THEN 'CFExcConNumber' ELSE 'CFRecConNumber' END ) as ZD FROM  CT_PAY_CityChannel   where   cfcityid = '"+cityId+"' and cfbusinessdate = '"+periodnum+"'";
//					IRowSet rsZiDuanZX =  DBUtil.executeQuery(ctx,zxziduanSql);
//					if(rsZiDuanZX!=null && rsZiDuanZX.size() > 0){
//						while(rsZiDuanZX.next()){	 
//							zxZiDuan = rsZiDuanZX.getString("ZD"); 
//						}
//					}
//				}
//				 
//				
//				String sqlMBStr = "";
//				if("MS1101".equals(cityNumber)){
//					sqlMBStr = "  /*dialect*/  select nvl(sum(CFzxAchieve),0)   as MONEY   from  CT_PAY_AchieveDetailTem where   cfcitynumber= '"+cityNumber+"' and    "+zxZiDuan+"='"+empNum+"'  and    to_char(fbizdate,'YYYYMM') ='"+periodnum+"'  ";
//				}else{
//					sqlMBStr = "  /*dialect*/  select nvl(sum(CFzxAchieve),0)   as MONEY   from  CT_PAY_AchieveDetailTem where   cfcitynumber= '"+cityNumber+"' and    "+zxZiDuan+"='"+empNum+"'  and    to_char(fbizdate,'YYYYMM') ='"+periodnum+"'  ";
//				}
//				
//			
//				IRowSet rsZX =  DBUtil.executeQuery(ctx,sqlMBStr);
//				if(rsZX!=null && rsZX.size() > 0){
//					while(rsZX.next()){	
//						zxMap.put("xtzxAchieve",new BigDecimal(rsZX.getString("MONEY")).toString());
//						moneyBig = moneyBig.add(new BigDecimal(rsZX.getString("MONEY")));
//						zxMap.put("zxAchieve",moneyBig.toString());
//						if(moneyBig.compareTo(firstMoney) <1){//第一阶段 
//							moneyBig = moneyBig.multiply(first).setScale(2,BigDecimal.ROUND_HALF_UP);
//						}else if(moneyBig.compareTo(secondMoney) <1){//第二阶段 
//							//moneyBig = moneyBig.multiply(second).setScale(2,BigDecimal.ROUND_HALF_UP);
//							moneyBig = firstMoney.multiply(first).add( moneyBig.subtract(firstMoney).multiply(second)).setScale(2,BigDecimal.ROUND_HALF_UP);
//						}else{//第三阶段  
//							//moneyBig = moneyBig.multiply(third).setScale(2,BigDecimal.ROUND_HALF_UP);
//							moneyBig = firstMoney.multiply(first).add(secondMoney.subtract(firstMoney).multiply(second)).add(moneyBig.subtract(secondMoney).multiply(third)).setScale(2,BigDecimal.ROUND_HALF_UP);
//						}
//					}
//					money = moneyBig.doubleValue(); 
//				} 
//				zxMap.put("zixunBonus",money+"");
//				zxMap.put("postType", "ZXS"); 
//			}  
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			this.log.error("系统出现异常，请联系管理员");
//		}   
//		return zxMap;
//		
//	}
	 
	
	public HashMap<String,String> getConsultantBonus(Context ctx,String empNum, String cityNumber,String periodnum,String cityId,HashMap tempMap,String  zxZiDuan){
		//Context ctx = Tools.getInstance().getCtx(); 
		HashMap<String,String>  zxMap = new HashMap<String,String>();
		double money = 0.0D;
		if(empNum == null || empNum.equals("")){
			this.log.error("员工编码不能为空");
			return null;
		}else if(periodnum == null || periodnum.equals("")){
			this.log.error("期间不能为空");
			return null;
		}
		 
		try { 
			//判断是否是咨询师 
			if((null == tempMap) || (null == tempMap.get(empNum+"_ZX")) || "".equals(tempMap.get(empNum+"_ZX").toString()) ){
				 
			}else{   
				BigDecimal moneyBig = BigDecimal.ZERO; 
				BigDecimal allAchieve = BigDecimal.ZERO; 
				BigDecimal achieve = BigDecimal.ZERO; 
				String zximSql = "/*dialect*/SELECT nvl(sum(cfzxachieve),0) as ZX FROM  CT_PAY_ConsultantBonusUpdate   where cfempnumber = '"+empNum+"' and cfcityid = '"+cityId+"' and cfbusinessdate = '"+periodnum+"'";
				IRowSet rsImZX =  DBUtil.executeQuery(ctx,zximSql);
				if(rsImZX!=null && rsImZX.size() > 0){
					  while(rsImZX.next()){	
						  allAchieve = new BigDecimal(rsImZX.getString("ZX"));
						  zxMap.put("imzxAchieve",allAchieve.toString());
					  }
				}  
				 
				String sqlMBStr =  "  /*dialect*/  select nvl(sum(CFzxAchieve),0)   as MONEY   from  CT_PAY_AchieveDetailTem where   cfcitynumber= '"+cityNumber+"' and    "+zxZiDuan+"='"+empNum+"'  and    to_char(fbizdate,'YYYYMM') ='"+periodnum+"'  ";
//				if("MS1101".equals(cityNumber)){
//					sqlMBStr = "  /*dialect*/  select nvl(sum(CFzxAchieve),0)   as MONEY   from  CT_PAY_AchieveDetailTem where   cfcitynumber= '"+cityNumber+"' and    "+zxZiDuan+"='"+empNum+"'  and    to_char(fbizdate,'YYYYMM') ='"+periodnum+"'  ";
//				}else{
//					sqlMBStr = "  /*dialect*/  select nvl(sum(CFzxAchieve),0)   as MONEY   from  CT_PAY_AchieveDetailTem where   cfcitynumber= '"+cityNumber+"' and    "+zxZiDuan+"='"+empNum+"'  and    to_char(fbizdate,'YYYYMM') ='"+periodnum+"'  ";
//				} 
				IRowSet rsZX =  DBUtil.executeQuery(ctx,sqlMBStr);
				if(rsZX!=null && rsZX.size() > 0){
					while(rsZX.next()){	
						zxMap.put("xtzxAchieve",new BigDecimal(rsZX.getString("MONEY")).toString());
						allAchieve = allAchieve.add(new BigDecimal(rsZX.getString("MONEY")));
						zxMap.put("zxAchieve",allAchieve.toString()); 
					}
					
				} 
				achieve = allAchieve;//标志业绩  不变
				
				ArrayList<HashMap> arrayList = new ArrayList<HashMap>();
				if(tempMap.get(empNum+"_"+"_SHOP") != null){
					String zxType = tempMap.get(empNum+"_"+"_SHOP").toString();
					arrayList = (ArrayList<HashMap>) tempMap.get(zxType+"_"+cityId);
				}else{
					 
				} 
				for(HashMap map  : arrayList){ 
					BigDecimal beginAmount = new BigDecimal(map.get("CFBEGINAMOUNT").toString());
					BigDecimal endAmount = new BigDecimal(map.get("CFENDAMOUNT").toString());
					BigDecimal pro = new BigDecimal(map.get("CFPRO").toString()); 
					if(achieve.compareTo(beginAmount) < 1 ){
						break;
					}else if(achieve.compareTo(endAmount) < 1 ){
						moneyBig = allAchieve.multiply(pro).add(moneyBig);
						
						break;
					}else if(achieve.compareTo(endAmount) == 1){
						moneyBig = endAmount.subtract(beginAmount).multiply(pro).add(moneyBig);
						allAchieve = achieve.subtract(endAmount);
					} 
		        } 
				
				money = moneyBig.doubleValue(); 
				
				zxMap.put("zixunBonus",money+"");
				zxMap.put("postType", "ZXS"); 
			}  
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.log.error("系统出现异常，请联系管理员");
		}   
		return zxMap;
	}
	
	
	/**
	 * 
	 * @param ctx
	 * @param empNum
	 * @param cityNumber   就普通运营总监用到了 
	 * @param periodnum
	 * @param tempMap
	 * @return
	 */
	public HashMap<String,String>  getOtherPostAch(Context ctx,String empNum, String cityNumber,String periodnum,String thiscityid,HashMap tempMap,String  zxZiDuan){
		//Context ctx = Tools.getInstance().getCtx(); 
		HashMap<String,String>  getOtherMap = new HashMap<String,String>();
		BigDecimal money = BigDecimal.ZERO;
		if(empNum == null || empNum.equals("")){
			this.log.error("员工编码不能为空");
			return getOtherMap;
		}else if(periodnum == null || periodnum.equals("")){
			this.log.error("期间不能为空");
			return getOtherMap;
		}/*else if(clinicNumber == null || clinicNumber.equals("")){
			this.log.error("门诊编码不能为空");
			return 0.0D;
		}*/
		String clinicId = "";
		try{ 
			if((null == tempMap) || (null == tempMap.get(empNum+"_OT")) || "".equals(tempMap.get(empNum+"_OT").toString()) ){
				 
			}else{ 
				clinicId =  tempMap.get(empNum+"_OT").toString();
				CompanyOrgUnitInfo com = CompanyOrgUnitFactory.getLocalInstance(ctx).getCompanyOrgUnitInfo("where id='"+clinicId+"'");
				String clinicNumber = com.getNumber();
				BigDecimal moneyBig =  BigDecimal.ZERO;
				BigDecimal moneyPay =  BigDecimal.ZERO;
				BigDecimal shopTrget = BigDecimal.ZERO;
				
				BigDecimal moneyPer =  BigDecimal.ZERO;
				// nvl(monthSum.cfdiary,0) as pay 
				String sqlShop = "  /*dialect*/ select   nvl(monthSum.CFIncome,0)  as thiscount , nvl(monthSum.cfliushui,0) as pay ,(budgetDate.cftarget*10000) as target from  CT_PAY_ClinicMonthSum   monthSum  "+
				" left join  CT_PAY_BudgetDate  budgetDate  on  budgetDate.cfcompanyid = monthSum.CFclinicid and budgetDate.cfbusinessdate =  '"+periodnum+"'    where   CFClinicNumber='"+clinicNumber+"'  and  monthSum.cfbusinessdate =  '"+periodnum+"' ";
				IRowSet rsShop =  DBUtil.executeQuery(ctx,sqlShop);
				if(rsShop!=null && rsShop.size() > 0){
					  while(rsShop.next()){	
						  //门诊营收总业绩
						  moneyBig  = new BigDecimal (rsShop.getString("THISCOUNT"));  
						  moneyPay = new BigDecimal (rsShop.getString("PAY"));  
						  //目标业绩
						  shopTrget =   new BigDecimal(rsShop.getString("TARGET")); 
					  }
				} 
				BigDecimal improtAchieve =  BigDecimal.ZERO;
				BigDecimal xtprotAchieve =  BigDecimal.ZERO;
				String zximSql = "/*dialect*/SELECT nvl(sum(cfzxachieve),0) as ZX FROM  CT_PAY_ConsultantBonusUpdate   where cfempnumber = '"+empNum+"' and cfcityid = '"+thiscityid+"' and cfbusinessdate = '"+periodnum+"'";
				IRowSet rsImZX =  DBUtil.executeQuery(ctx,zximSql);
				if(rsImZX!=null && rsImZX.size() > 0){
					 while(rsImZX.next()){	
						 improtAchieve = new BigDecimal(rsImZX.getString("ZX"));
						  
					 }
				}
				
				String sqlPer = sqlPer = "  /*dialect*/  select nvl(sum(CFzxAchieve),0)   as MONEY   from  CT_PAY_AchieveDetailTem where   cfcitynumber= '"+cityNumber+"' and    "+zxZiDuan+"='"+empNum+"'  and    to_char(fbizdate,'YYYYMM') ='"+periodnum+"'  ";
//				if("MS1101".equals(cityNumber)){
//					sqlPer = "  /*dialect*/  select nvl(sum(CFzxAchieve),0)   as MONEY   from  CT_PAY_AchieveDetailTem where   cfcitynumber= '"+cityNumber+"' and    "+zxZiDuan+"='"+empNum+"'  and    to_char(fbizdate,'YYYYMM') ='"+periodnum+"'  ";
//				}else{
//					sqlPer = "  /*dialect*/  select nvl(sum(CFzxAchieve),0)   as MONEY   from  CT_PAY_AchieveDetailTem where   cfcitynumber= '"+cityNumber+"' and    "+zxZiDuan+"='"+empNum+"'  and    to_char(fbizdate,'YYYYMM') ='"+periodnum+"'  ";
//				}
				IRowSet rsPer =  DBUtil.executeQuery(ctx,sqlPer);
				if(rsPer!=null && rsPer.size() > 0){
					  while(rsPer.next()){
						  //个人营收总业绩
						  xtprotAchieve =new BigDecimal (rsPer.getString("MONEY"));
						  moneyPer  = improtAchieve.add(new BigDecimal (rsPer.getString("MONEY")));  
					  }
				}  
				String clinicsize = tempMap.get(clinicId+"_OT_SHOPYY").toString(); 
				HashMap map = new HashMap();
				map = (HashMap) tempMap.get(clinicsize+"_OTHER");
				//基础业绩
				BigDecimal baseYJ =   new BigDecimal(map.get("CFBASEACH").toString());
				//门店提成比例
				BigDecimal shoptichengBiLi =   new BigDecimal(map.get("CFSHOPPRO").toString());
				//个人咨询提成比例
				BigDecimal pertichengBiLi =   new BigDecimal(map.get("CFPERSONPRO").toString()); 
				//完成奖励
				BigDecimal wanchengMoney =   new BigDecimal(map.get("CFREWARDAMOUNT").toString()); 
				
				//门店奖金最后计算
				if(moneyBig.compareTo(shopTrget) < 0  && moneyPay.compareTo(shopTrget)<0){//实际营收小于 目标业绩
					wanchengMoney = wanchengMoney.negate(); 
				}else if(moneyBig.compareTo(shopTrget) > 0  &&  moneyPay.compareTo(shopTrget) > 0){
					
				}else{
					wanchengMoney = BigDecimal.ZERO;
				}
				//wanchengMoney = BigDecimal.ZERO;
				//money = moneyBig.subtract(baseYJ).multiply(shoptichengBiLi).add(moneyPer.multiply(pertichengBiLi)).add(wanchengMoney).setScale(2,BigDecimal.ROUND_HALF_UP);
				money = moneyBig.subtract(baseYJ).multiply(shoptichengBiLi).add(moneyPer.multiply(pertichengBiLi)).setScale(2,BigDecimal.ROUND_HALF_UP);
				 
				getOtherMap.put("otherBonus", money+"");
				getOtherMap.put("otherAchieve", moneyPer+"");
				getOtherMap.put("imotherAchieve", improtAchieve+"");
				getOtherMap.put("xtotherAchieve", xtprotAchieve+"");
				getOtherMap.put("wanchengMoney", wanchengMoney+"");
				getOtherMap.put("postType", "MZYYZJ");
				return getOtherMap;
				//money = Double.parseDouble(tempMap.get(key).toString()); 
			} 
			
			if((null == tempMap) || (null == tempMap.get(empNum+"_OT2")) || "".equals(tempMap.get(empNum+"_OT2").toString()) ){
				 
			}else{ 
				getOtherMap.put("postType",  "CSYYZJ");
				
				BigDecimal moneyBig =  BigDecimal.ZERO;
				BigDecimal moneyPer =  BigDecimal.ZERO;
				BigDecimal moneyPay =  BigDecimal.ZERO;
				HashMap map = new HashMap();

				map = (HashMap) tempMap.get(empNum+"_OTHER_OTHER");
				
				//基础业绩  --事业部基础业绩
				BigDecimal baseYJ =   new BigDecimal(map.get("CFBASEACH")== null? "0":map.get("CFBASEACH").toString());
				 
				//城市总提成比例   ---事业部提成比例
				BigDecimal businessBiLi  =   new BigDecimal(map.get("CFBUSINESSPRO")== null? "0": map.get("CFBUSINESSPRO").toString());
				 
				//扣除奖励 --减少金额
				BigDecimal subAmount =   new BigDecimal(map.get("CFREDUCEAMOUNT")== null? "0":map.get("CFREDUCEAMOUNT").toString()); 
				
				
				String cityId = map.get("CFCITYID").toString();
				
				
				BigDecimal imotherAchieve =  BigDecimal.ZERO;
				BigDecimal xtotherAchieve =  BigDecimal.ZERO;
				String zximSql = "/*dialect*/SELECT nvl(sum(cfzxachieve),0) as ZX FROM  CT_PAY_ConsultantBonusUpdate   where cfempnumber = '"+empNum+"' and cfcityid = '"+thiscityid+"' and cfbusinessdate = '"+periodnum+"'";
				IRowSet rsImZX =  DBUtil.executeQuery(ctx,zximSql);
				if(rsImZX!=null && rsImZX.size() > 0){
					  while(rsImZX.next()){	
						  imotherAchieve = new BigDecimal(rsImZX.getString("ZX"));
					  }
				 }
				getOtherMap.put("improtAchieve", imotherAchieve+"");
				if( null == map.get("CFCLINICID") || "".equals(map.get("CFCLINICID").toString()) ){
					//String sqlShop = " /*dialect*/   select nvl(sum(CFIncome),0)  as OTMONEY   from  CT_PAY_AchieveDetailTem where   CFCityNumber='"+cityNum+"' and  cfbusinessdate ='"+periodnum+"'  ";
					String sqlShop = " /*dialect*/  SELECT nvl(sum(cfincome),0) as OTMONEY  FROM   CT_PAY_ClinicMonthSum where  cfcityid = '"+cityId+"' and cfbusinessdate = '"+periodnum+"' ";
					IRowSet rsShop =  DBUtil.executeQuery(ctx,sqlShop);
					if(rsShop!=null && rsShop.size() > 0){
						  while(rsShop.next()){	
							  //城市营收总业绩
							  moneyBig  = new BigDecimal (rsShop.getString("OTMONEY"));  
						  }
					}  
					
					money = moneyBig.subtract(baseYJ).multiply(businessBiLi).subtract( subAmount).setScale(2,BigDecimal.ROUND_HALF_UP); 
					getOtherMap.put("otherBonus", money+"");
					getOtherMap.put("otherAchieve", 0+"");
					getOtherMap.put("xtotherAchieve", 0+"");
					return getOtherMap;
				}else{
					
					//查询所有咨询师的咨询业绩
					String sqlShop = " /*dialect*/  SELECT nvl(sum(cfincome),0) as OTMONEY  FROM   CT_PAY_AchieveDetailtem where  CFCityNumber='"+cityNumber+"' and  to_char(fbizdate,'YYYYMM') ='"+periodnum+"'  and  CFExcConNumber in (SELECT cfempnumber FROM CT_PAY_PayPost  where cfbusinessdate ='"+periodnum+"'  and  CFPOSTNUMBER = 'ZXS' and cfstatus='qy')";
					IRowSet rsShop =  DBUtil.executeQuery(ctx,sqlShop);
					if(rsShop!=null && rsShop.size() > 0){
						  while(rsShop.next()){	
							  ///城市营收总业绩
							  //所有咨询师的资讯业绩
							  xtotherAchieve = new BigDecimal (rsShop.getString("OTMONEY"));
							  moneyBig  = imotherAchieve.add(new BigDecimal (rsShop.getString("OTMONEY")));  
						  }
					}  
					
					//如果是  对比城市总业绩 并且查看门店
					BigDecimal moneyShopAll =  BigDecimal.ZERO;
					clinicId = map.get("CFCLINICID").toString();
					
					String sqlShopClinic = "  /*dialect*/ select   nvl( CFIncome,0)  as thiscount , nvl( cfliushui,0) as pay    from  CT_PAY_ClinicMonthSum   where   CFClinicid='"+clinicId+"'  and   cfbusinessdate =  '"+periodnum+"'   ";

					IRowSet rsShopClinic =  DBUtil.executeQuery(ctx,sqlShopClinic);
					if(rsShopClinic!=null && rsShopClinic.size() > 0){
						  while(rsShopClinic.next()){	
							  //门诊营收总业绩
							  moneyShopAll  = new BigDecimal (rsShopClinic.getString("THISCOUNT"));  
							  moneyPay = new BigDecimal (rsShopClinic.getString("PAY"));  
						  }
					} 
					//获得 牙椅数
					String  clinicSize = tempMap.get(clinicId+"_OT_SHOPYY").toString(); 
					HashMap mapShop = new HashMap();
					mapShop = (HashMap) tempMap.get(clinicSize+"_OTHER");
					//门店 完成奖励
					BigDecimal wanchengMoney =   new BigDecimal(mapShop.get("CFREWARDAMOUNT").toString()); 
					//门诊的  目标业绩              moneyShopAll 门诊实际营收
					BigDecimal shopTrget =   new BigDecimal(map.get("TARGET").toString()); 
					if(moneyShopAll.compareTo(shopTrget) < 0  && moneyPay.compareTo(shopTrget)<0){//实际营收小于 目标业绩
						wanchengMoney = wanchengMoney.negate(); 
					}else if(moneyShopAll.compareTo(shopTrget) > 0  &&  moneyPay.compareTo(shopTrget) > 0){//都大于
						
					}else {
						wanchengMoney = BigDecimal.ZERO;
					}
					//wanchengMoney = BigDecimal.ZERO;
					money = moneyBig.subtract(baseYJ).multiply(businessBiLi).subtract( subAmount).add(wanchengMoney).setScale(2,BigDecimal.ROUND_HALF_UP);
					getOtherMap.put("otherBonus", money+"");
					getOtherMap.put("otherAchieve", moneyBig+"");
					getOtherMap.put("xtotherAchieve", xtotherAchieve+"");
					getOtherMap.put("wanchengMoney", wanchengMoney+"");
					return getOtherMap;
					
					//----------------------------------------------------------
					
//					BigDecimal wanchengMoney =   new BigDecimal(map.get("CFREWARDAMOUNT").toString());
//					
//					
//					//所关联门诊id
//					String clinicID= map.get("CFCLINICID").toString();
//					//底薪
//					BigDecimal basePay =   new BigDecimal(map.get("CFBASEPAY").toString());
//					
//					BigDecimal achieveNoMy =  BigDecimal.ZERO;
//					//String sqlShop = " /*dialect*/  SELECT nvl(sum(cfincome),0) as OTMONEY  FROM   CT_PAY_AchieveDetailtem where  CFCityNumber='"+cityNumber+"' and  cfbusinessdate ='"+periodnum+"'  and  CFExcConNumber in (SELECT cfempnumber FROM CT_PAY_PayPost  where CFPOSTNUMBER = 'ZXS' and cfstatus='qy' and cfbusinessdate ='"+periodnum+"')";
//					//查询自己管理门诊外  相应城市的门店业绩
//					String sqlShop = " /*dialect*/  SELECT nvl(sum(cfincome),0) as OTMONEY  FROM   CT_PAY_ClinicMonthSum where  cfcityid = '"+cityId+"' and cfbusinessdate = '"+periodnum+"' and  cfclinicid !='"+clinicID+"' ";
//					IRowSet rsShop =  DBUtil.executeQuery(ctx,sqlShop);
//					if(rsShop!=null && rsShop.size() > 0){
//						  while(rsShop.next()){	 
//							  achieveNoMy = new BigDecimal (rsShop.getString("OTMONEY"));
//							 /* xtotherAchieve = new BigDecimal (rsShop.getString("OTMONEY"));
//							  moneyBig  = imotherAchieve.add(new BigDecimal (rsShop.getString("OTMONEY")));  */
//						  }
//					}  
//					
//					// 门诊基础业绩
//					BigDecimal baseClinic =   new BigDecimal(map.get("CFCLINICBASEACH")== null? "0":map.get("CFCLINICBASEACH").toString());
//					 
//					//门诊提成比例
//					BigDecimal clinicBiLi  =   new BigDecimal(map.get("CFSHOPPRO")== null? "0": map.get("CFSHOPPRO").toString());
//					 
//					BigDecimal achieveMy =  BigDecimal.ZERO;
//					//查询自己的管理门诊  相应城市的门店业绩
//					String sqlShopMy = " /*dialect*/  SELECT nvl(sum(cfincome),0) as OTMONEY  FROM   CT_PAY_ClinicMonthSum where  cfcityid = '"+cityId+"' and cfbusinessdate = '"+periodnum+"' and  cfclinicid ='"+clinicID+"' ";
//					IRowSet rsShopMy =  DBUtil.executeQuery(ctx,sqlShopMy);
//					if(rsShopMy!=null && rsShopMy.size() > 0){
//						  while(rsShopMy.next()){	 
//							  achieveMy = new BigDecimal (rsShopMy.getString("OTMONEY"));
//							 /* xtotherAchieve = new BigDecimal (rsShop.getString("OTMONEY"));
//							  moneyBig  = imotherAchieve.add(new BigDecimal (rsShop.getString("OTMONEY")));  */
//						  }
//					}  
//					
//					//如果是  对比城市总业绩 并且查看门店 
//					clinicId = map.get("CFCLINICID").toString(); 
//					String sqlShopClinic = "  /*dialect*/ select   nvl( CFIncome,0)  as thiscount , nvl( cfdiary,0) as pay    from  CT_PAY_ClinicMonthSum   where   CFClinicid='"+clinicId+"'  and   cfbusinessdate =  '"+periodnum+"'   ";
//
//					IRowSet rsShopClinic =  DBUtil.executeQuery(ctx,sqlShopClinic);
//					if(rsShopClinic!=null && rsShopClinic.size() > 0){
//						  while(rsShopClinic.next()){	
//							  //门诊营收总业绩
//							  achieveMy  = new BigDecimal (rsShopClinic.getString("THISCOUNT"));  
//							  moneyPay = new BigDecimal (rsShopClinic.getString("PAY"));  
//						  }
//					}
//					
//					//牙椅界限
//					//int yyjx = Integer.parseInt(tempMap.get("OT_YYJX").toString());
//					//获得 牙椅数
//					//String  clinicSize = tempMap.get(clinicId+"_OT_SHOPYY").toString(); 
//					//HashMap mapShop = new HashMap();
//					//mapShop = (HashMap) tempMap.get(clinicSize+"_OTHER");
//					//门店 完成奖励
//					//BigDecimal wanchengMoney =   new BigDecimal(mapShop.get("CFREWARDAMOUNT").toString()); 
//					//门诊的  目标业绩              moneyShopAll 门诊实际营收
//					BigDecimal shopTrget =   new BigDecimal(map.get("TARGET").toString()); 
//					if(achieveMy.compareTo(shopTrget) < 0  && moneyPay.compareTo(shopTrget)<0){//实际营收小于 目标业绩
//						wanchengMoney = wanchengMoney.negate(); 
//					}else if(achieveMy.compareTo(shopTrget) > 0  &&  moneyPay.compareTo(shopTrget) > 0){//都大于
//						
//					}else {
//						wanchengMoney = BigDecimal.ZERO;
//					} 
//					
//					BigDecimal jyTeamAchieve = BigDecimal.ZERO;
//					BigDecimal jeyaTeamBiLi = BigDecimal.ZERO;
//					if(empNum.equals("MS110100204")){
//						//洁牙师团队业绩？
//						//如果是  对比城市总业绩 并且查看门店  
//						//String sqlJYTeam = "  /*dialect*/ SELECT nvl(sum(cfzxachieve),0) as ZX FROM  CT_PAY_ConsultantBonusUpdate   where cfempnumber = '"+empNum+"' and cfcityid = '"+thiscityid+"' and cfbusinessdate = '"+periodnum+"'"; 
//						/*IRowSet rslJYTeam  =  DBUtil.executeQuery(ctx,sqlJYTeam);
//						if(rslJYTeam!=null && rslJYTeam.size() > 0){
//							  while(rslJYTeam.next()){	
//								  //门诊营收总业绩
//								  jyTeamAchieve  = new BigDecimal (rslJYTeam.getString("ZX"));   
//							  }
//						}*/
//						
//						//个人咨询提成比例
//						if(map.get("CFPERSONPRO")!=null  &&  !map.get("CFPERSONPRO").toString().equals("")){
//							jeyaTeamBiLi =   new BigDecimal(map.get("CFPERSONPRO").toString()); 
//						} 
//					}
//					
//					//咨询提成
//					BigDecimal noMyMoney = achieveNoMy.subtract(baseYJ).multiply(businessBiLi);
//					//门诊提成
//					BigDecimal myMoney = achieveMy.subtract(baseClinic).multiply(clinicBiLi);
//					
//					money = noMyMoney.add(myMoney).add(jyTeamAchieve.add(imotherAchieve).multiply(jeyaTeamBiLi )).setScale(2,BigDecimal.ROUND_HALF_UP);
//					getOtherMap.put("otherBonus", money+"");
//					getOtherMap.put("otherAchieve", moneyBig+"");
//					getOtherMap.put("xtotherAchieve", jyTeamAchieve+"");
//					getOtherMap.put("wanchengMoney", wanchengMoney+"");
					
				}
				 
				//money = Double.parseDouble(tempMap.get(key).toString()); 
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.log.error("系统出现异常，请联系管理员");
		}  
		
		return getOtherMap;
		
	}
	
	
	
	public void text(Context ctx,String empNum, String cityNumber,String periodnum,HashMap tempMap){
		//完成业绩奖励
//		BigDecimal wanchengMoney =   new BigDecimal(map.get("CFREWARDAMOUNT").toString());
//		
//		
//		//所关联门诊id
//		String clinicID= map.get("CFCLINICID").toString();
//		//底薪
//		BigDecimal basePay =   new BigDecimal(map.get("CFBASEPAY").toString());
//		
//		BigDecimal achieveNoMy =  BigDecimal.ZERO;
//		//String sqlShop = " /*dialect*/  SELECT nvl(sum(cfincome),0) as OTMONEY  FROM   CT_PAY_AchieveDetailtem where  CFCityNumber='"+cityNumber+"' and  cfbusinessdate ='"+periodnum+"'  and  CFExcConNumber in (SELECT cfempnumber FROM CT_PAY_PayPost  where CFPOSTNUMBER = 'ZXS' and cfstatus='qy' and cfbusinessdate ='"+periodnum+"')";
//		//查询自己管理门诊外  相应城市的门店业绩
//		String sqlShop = " /*dialect*/  SELECT nvl(sum(cfincome),0) as OTMONEY  FROM   CT_PAY_ClinicMonthSum where  cfcityid = '"+cityId+"' and cfbusinessdate = '"+periodnum+"' and  cfclinicid !='"+clinicID+"' ";
//		IRowSet rsShop =  DBUtil.executeQuery(ctx,sqlShop);
//		if(rsShop!=null && rsShop.size() > 0){
//			  while(rsShop.next()){	 
//				  achieveNoMy = new BigDecimal (rsShop.getString("OTMONEY"));
//				 /* xtotherAchieve = new BigDecimal (rsShop.getString("OTMONEY"));
//				  moneyBig  = imotherAchieve.add(new BigDecimal (rsShop.getString("OTMONEY")));  */
//			  }
//		}  
//		
//		// 门诊基础业绩
//		BigDecimal baseClinic =   new BigDecimal(map.get("CFCLINICBASEACH")== null? "0":map.get("CFCLINICBASEACH").toString());
//		 
//		//门诊提成比例
//		BigDecimal clinicBiLi  =   new BigDecimal(map.get("CFSHOPPRO")== null? "0": map.get("CFSHOPPRO").toString());
//		 
//		BigDecimal achieveMy =  BigDecimal.ZERO;
//		//查询自己的管理门诊  相应城市的门店业绩
//		String sqlShopMy = " /*dialect*/  SELECT nvl(sum(cfincome),0) as OTMONEY  FROM   CT_PAY_ClinicMonthSum where  cfcityid = '"+cityId+"' and cfbusinessdate = '"+periodnum+"' and  cfclinicid ='"+clinicID+"' ";
//		IRowSet rsShopMy =  DBUtil.executeQuery(ctx,sqlShopMy);
//		if(rsShopMy!=null && rsShopMy.size() > 0){
//			  while(rsShopMy.next()){	 
//				  achieveMy = new BigDecimal (rsShopMy.getString("OTMONEY"));
//				 /* xtotherAchieve = new BigDecimal (rsShop.getString("OTMONEY"));
//				  moneyBig  = imotherAchieve.add(new BigDecimal (rsShop.getString("OTMONEY")));  */
//			  }
//		}  
//		
//		//如果是  对比城市总业绩 并且查看门店 
//		clinicId = map.get("CFCLINICID").toString(); 
//		String sqlShopClinic = "  /*dialect*/ select   nvl( CFIncome,0)  as thiscount , nvl( cfdiary,0) as pay    from  CT_PAY_ClinicMonthSum   where   CFClinicid='"+clinicId+"'  and   cfbusinessdate =  '"+periodnum+"'   ";
//
//		IRowSet rsShopClinic =  DBUtil.executeQuery(ctx,sqlShopClinic);
//		if(rsShopClinic!=null && rsShopClinic.size() > 0){
//			  while(rsShopClinic.next()){	
//				  //门诊营收总业绩
//				  achieveMy  = new BigDecimal (rsShopClinic.getString("THISCOUNT"));  
//				  moneyPay = new BigDecimal (rsShopClinic.getString("PAY"));  
//			  }
//		}
//		
//		//牙椅界限
//		//int yyjx = Integer.parseInt(tempMap.get("OT_YYJX").toString());
//		//获得 牙椅数
//		//String  clinicSize = tempMap.get(clinicId+"_OT_SHOPYY").toString(); 
//		//HashMap mapShop = new HashMap();
//		//mapShop = (HashMap) tempMap.get(clinicSize+"_OTHER");
//		//门店 完成奖励
//		//BigDecimal wanchengMoney =   new BigDecimal(mapShop.get("CFREWARDAMOUNT").toString()); 
//		//门诊的  目标业绩              moneyShopAll 门诊实际营收
//		BigDecimal shopTrget =   new BigDecimal(map.get("TARGET").toString()); 
//		if(achieveMy.compareTo(shopTrget) < 0  && moneyPay.compareTo(shopTrget)<0){//实际营收小于 目标业绩
//			wanchengMoney = wanchengMoney.negate(); 
//		}else if(achieveMy.compareTo(shopTrget) > 0  &&  moneyPay.compareTo(shopTrget) > 0){//都大于
//			
//		}else {
//			wanchengMoney = BigDecimal.ZERO;
//		} 
//		
//		BigDecimal jyTeamAchieve = BigDecimal.ZERO;
//		//洁牙师团队业绩？
//		//如果是  对比城市总业绩 并且查看门店  
//		//String sqlJYTeam = "  /*dialect*/ SELECT nvl(sum(cfzxachieve),0) as ZX FROM  CT_PAY_ConsultantBonusUpdate   where cfempnumber = '"+empNum+"' and cfcityid = '"+thiscityid+"' and cfbusinessdate = '"+periodnum+"'"; 
//		/*IRowSet rslJYTeam  =  DBUtil.executeQuery(ctx,sqlJYTeam);
//		if(rslJYTeam!=null && rslJYTeam.size() > 0){
//			  while(rslJYTeam.next()){	
//				  //门诊营收总业绩
//				  jyTeamAchieve  = new BigDecimal (rslJYTeam.getString("ZX"));   
//			  }
//		}*/
//		BigDecimal jeyaTeamBiLi = BigDecimal.ZERO;
//		//个人咨询提成比例
//		if(map.get("CFPERSONPRO")!=null  &&  !map.get("CFPERSONPRO").toString().equals("")){
//			jeyaTeamBiLi =   new BigDecimal(map.get("CFPERSONPRO").toString()); 
//		} 
//		//咨询提成
//		BigDecimal noMyMoney = achieveNoMy.subtract(baseYJ).multiply(businessBiLi);
//		//门诊提成
//		BigDecimal myMoney = achieveMy.subtract(baseClinic).multiply(clinicBiLi);
//		
//		money = noMyMoney.add(myMoney).add(jyTeamAchieve.add(imotherAchieve).multiply(jeyaTeamBiLi )).setScale(2,BigDecimal.ROUND_HALF_UP);
//		getOtherMap.put("otherBonus", money+"");
//		getOtherMap.put("otherAchieve", moneyBig+"");
//		getOtherMap.put("xtotherAchieve", jyTeamAchieve+"");
//		getOtherMap.put("wanchengMoney", wanchengMoney+"");
		
	}
	
	
	/**
	 * 获取门店目标
	 */
	public double getShopGoal(Context ctx,String empNum, String cityNumber,String periodnum,HashMap tempMap){
		//Context ctx = Tools.getInstance().getCtx(); 
		double money = 0.0D;
		if(empNum == null || empNum.equals("")){
			this.log.error("员工编码不能为空");
			return 0.0D;
		}else if(periodnum == null || periodnum.equals("")){
			this.log.error("期间不能为空");
			return 0.0D;
		} 
		String clinicID = "";
		try {  
			if((null == tempMap) || (null == tempMap.get(empNum+"_MD")) || "".equals(tempMap.get(empNum+"_MD").toString()) ){
				 return 0.0D;
			}else{
				//clinicNumber = tempMap.get(empNum+"_MD").toString();
				clinicID = tempMap.get(empNum+"_MD").toString();
				 
				BigDecimal mdjj = new BigDecimal(tempMap.get(empNum+"_"+clinicID+"_MONEY_MD").toString());
				 
				if( null == tempMap.get(clinicID+"_SJMD")  ||"".equals(tempMap.get(clinicID+"_SJMD"))){
					return money;
				}
				if( null == tempMap.get(clinicID+"_SJPAY")  ||"".equals(tempMap.get(clinicID+"_SJPAY"))){
					return money;
				}
				if( null == tempMap.get(clinicID+"_MBMD")  ||"".equals(tempMap.get(clinicID+"_MBMD"))){
					return money;
				}
				
				BigDecimal sj = new BigDecimal(tempMap.get(clinicID+"_SJMD").toString());
				
				BigDecimal pay = new BigDecimal(tempMap.get(clinicID+"_SJPAY").toString());
				
				BigDecimal mb = new BigDecimal(tempMap.get(clinicID+"_MBMD").toString()+"0000");
				
				
				if(sj.compareTo(mb) > 0 && pay.compareTo(mb) >0 ){//大于等于门店标准
					return mdjj.doubleValue();
				}else if(sj.compareTo(mb) < 0 && pay.compareTo(mb) < 0 ){
					return mdjj.negate().doubleValue();
				}else {
					return 0.0D;
				}

				//money = Double.parseDouble(tempMap.get(key).toString()); 
			} 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.log.error("系统出现异常，请联系管理员");
		}  
		
		return money;
		
	}
	  

	/**
	 * 上海护士获取洁牙奖金
	 */
//	public HashMap<String,String> getSHHSScalingBonus(Context ctx,String empNum,String clinicNumber, String cityNumber,String periodnum,String cityId,HashMap tempMap,
//			String postNumber,Map<String, BigDecimal> scalingMap,HashMap<String,String>  jieyaTypeMap ){ 
//		
//		
//		HashMap<String,String>  djieyaMap = new HashMap<String,String>();
//		double money = 0.0D;
//		if(empNum == null || empNum.equals("")){
//			this.log.error("员工编码不能为空");
//			return null;
//		}else if(periodnum == null || periodnum.equals("")){
//			this.log.error("期间不能为空");
//			return null;
//		}  
//		try {  
//			//先判断是不是洁牙师
//			if((null == tempMap) || (null == tempMap.get(empNum+"HS")) || "".equals(tempMap.get(empNum+"HS").toString()) ){
//				return null;
//			}else{
//				djieyaMap.put("postType", "HS");
//				
//				ArrayList<String> arrayList = new ArrayList<String>();
//				arrayList = (ArrayList<String>) tempMap.get(cityId+"_JY");
//				HashMap<String,String> typeMap = new HashMap<String,String>();
//				
//				String sqlMBStr = "/*dialect*/ ";
//				int i = 0;
//				for(String str : arrayList ){
//					String[] arr = str.split("#");
//					String typeNumber = "";
//					String typeName = "";
//					String jyNumber = "";
//					String jyid = "";
//					if(arr.length == 1 ){
//						typeNumber = arr[0];  
//					}else if(arr.length == 2){
//						typeNumber = arr[0]; 
//						typeName = arr[1];
//						jyNumber = typeNumber;
//					}else if(arr.length == 3){
//						typeNumber = arr[0]; 
//						typeName = arr[1];
//						jyNumber = arr[2];
//					}else if(arr.length == 4){
//						typeNumber = arr[0]; 
//						typeName = arr[1];
//						jyNumber = arr[2];
//						jyid = arr[3];
//						
//						typeMap.put(typeNumber, jyid);
//					}
//					
//					String  notinItemNumber = "";
//					String  inItemNumber = jieyaTypeMap.get(typeNumber);
//					notinItemNumber = jieyaTypeMap.get("SSJYDZ");
//					
//					 
//					String dzStr = "";
//					String dz1Str = "";
//					if(typeNumber.contains("FDZ")){
//						dzStr = " and (tem.cfnurseorderdiag is null or tem.cfnurseorderdiag='')  ";
//						dz1Str = "and ( tem1.cfnurseorderdiag is null or tem1.cfnurseorderdiag=''   ) ";
//					}else if(typeNumber.contains("DZ")){
//						dzStr = " and  tem.cfnurseorderdiag = '是'  ";
//						dz1Str = " and tem1.cfnurseorderdiag = '是'  ";
//					}
//					
//					if(i >0 ){
//						sqlMBStr = sqlMBStr+" union ";
//					}
//					if(typeNumber.equals("JYDZ") || typeNumber.equals("JYFDZ")){//洁牙 
//						sqlMBStr = sqlMBStr+" select count(1) as THISCOUNT , '"+typeNumber+"' as type from ( " +
//									" SELECT count(1) FROM  CT_PAY_AchieveDetailTem tem  where   tem.cfnursenumber = '"+empNum+"' and tem.CFClinicNumber='"+clinicNumber+"' and to_char(fbizdate,'YYYYMM') ='"+periodnum+"'  and tem.CFBUSITYPE='挂号消费'  " + 
//									" "+dzStr+"  and tem.cfrecdotnumber is not null     and  tem.cffeeitemdetailNUMBER in ("+inItemNumber+") " +
//									" and NOT EXISTS ( SELECT 1 FROM  CT_PAY_AchieveDetailTem tem1  where tem1.cfnursenumber = '"+empNum+"'  and  tem1.CFClinicNumber='"+clinicNumber+"'  and to_char(tem1.fbizdate,'YYYYMM') ='"+periodnum+"' and tem1.CFBUSITYPE='挂号消费'   " +
//									" 	"+dz1Str+"	and  tem1.cfrecdotnumber is not null  and tem1.cfhisorderid = tem.cfhisorderid   and  tem1.cffeeitemdetailNUMBER in  ( "+notinItemNumber+" )   "+
//									" 	)group by cfhisorderid )  ";
//					}else{//舒适
//						sqlMBStr = sqlMBStr+" select count(1) as THISCOUNT, '"+typeNumber+"' as type   from ( SELECT count(1) FROM  CT_PAY_AchieveDetailTem tem  where  tem.cfnursenumber = '"+empNum+"' and tem.CFClinicNumber='"+clinicNumber+"' and to_char(fbizdate,'YYYYMM') ='"+periodnum+"' and tem.CFBUSITYPE='挂号消费'   "+ 
//						   "   "+dzStr+" and tem.cfrecdotnumber is not null    and  tem.cffeeitemdetailNUMBER in ("+inItemNumber+")   group by cfhisorderid )    "; 
//					}
//					i++; 
//				}
//				
//				IRowSet rsMb =  DBUtil.executeQuery(ctx,sqlMBStr);
//				if(rsMb!=null && rsMb.size() > 0){
//					while(rsMb.next()){	
//						
//						String jyNumber = rsMb.getString("TYPE");
//						BigDecimal jycount =BigDecimal.ZERO;
//						BigDecimal xtjycount =BigDecimal.ZERO;
//						BigDecimal imjycount =BigDecimal.ZERO;
//						 
//						imjycount =  scalingMap.get(empNum+"_"+clinicNumber+"_"+jyNumber +"_IM"); 
//						xtjycount = new BigDecimal( rsMb.getString("THISCOUNT")); 
//						if(imjycount==null){
//							imjycount=BigDecimal.ZERO;
//						}
//						jycount = xtjycount.add(imjycount);
//						
//						if(jycount.compareTo(BigDecimal.ZERO) != 0 || xtjycount.compareTo(BigDecimal.ZERO) != 0   ){
//							com.kingdee.eas.mw.pay.ScalingCountSumInfo scalingCount = new com.kingdee.eas.mw.pay.ScalingCountSumInfo();
//							scalingCount.setBusinessDate(periodnum);
//							scalingCount.setCityNumber(cityNumber);
//							scalingCount.setCityName(tempMap.get(cityNumber).toString());
//							scalingCount.setEmpNumber(empNum); 
//							scalingCount.setEmpName(tempMap.get("empName").toString());
//							
//							scalingCount.setClinicNumber(clinicNumber); 
//							scalingCount.setClinicName(tempMap.get("clinicName").toString());
//							
//							String typeid = typeMap.get(jyNumber);
//							ScalingTypeInfo type = new ScalingTypeInfo();
//							type.setId(BOSUuid.read(typeid));
//							scalingCount.setType(type);
//							
//							scalingCount.setXtCount(xtjycount);
//							scalingCount.setImpCount(imjycount);
//							scalingCount.setAllCount(jycount);
//							scalingCount.setPost(PaypostType.getEnum(postNumber));
//							ScalingCountSumFactory.getLocalInstance(ctx).save(scalingCount);
//						}
//						
//					}
//				} 
//			} 
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			this.log.error("系统出现异常，请联系管理员");
//		}   
//		return djieyaMap; 
//	}
//	
	/**
	 * 上海护士获取美白奖金
	 */
//	public HashMap<String,String> getSHHSWhiteBonus(Context ctx,String empNum,String clinicNumber, String cityNumber,String periodnum,String cityId,HashMap tempMap
//			,HashMap<String,String>  oneItemMap ,HashMap<String,String>  twoItemMap , HashMap<String,String>  threeItemMap){
//		HashMap<String,String>  mbMap = new HashMap<String,String>();
//		//Context ctx = Tools.getInstance().getCtx(); 
//		double money = 0.0D;
//		if(empNum == null || empNum.equals("")){
//			this.log.error("员工编码不能为空");
//			return  null;
//		}else if(periodnum == null || periodnum.equals("")){
//			this.log.error("期间不能为空");
//			return  null;
//		}  
//		try {   
//			String mbOne = "";
//			String mbTwo = "";
//			String mbThree = "";
//			mbOne = oneItemMap.get("MB");
//			mbTwo = twoItemMap.get("MB");
//			mbThree = threeItemMap.get("MB");
//			
//			if((null == tempMap) || (null == tempMap.get(empNum+"MB")) || "".equals(tempMap.get(empNum+"MB").toString()) ){
//				return  null;
//			}else{
//				BigDecimal  achieve = BigDecimal.ZERO; 
//				mbMap.put("postType", "HS"); 
//				//免工作量比例
//				BigDecimal freeWorkPro = BigDecimal.ZERO;  
//				//赠金比例
//				BigDecimal gifAmountPro = BigDecimal.ZERO; 
//				
//				HashMap tongyongmap = (HashMap)tempMap.get("TONGYONGBILI_DOC");
//				freeWorkPro = new BigDecimal(tongyongmap.get("CFFREEWORKPRO").toString());   
//				gifAmountPro =  new BigDecimal(tongyongmap.get("CFGIFAMOUNTPRO").toString());
//				
//				BigDecimal mbachieve =BigDecimal.ZERO;
//				String importJy = " /*dialect*/ SELECT nvl(sum(cfmbachieve),0) as MB FROM  CT_PAY_WhiteBonusUpdate   where cfempnumber = '"+empNum+"' and cfcityid = '"+cityId+"' and  cfbusinessdate = '"+periodnum+"' and cfclinicnumber ='"+clinicNumber+"' ";
//				IRowSet rsImpMb =  DBUtil.executeQuery(ctx,importJy);
//				if(rsImpMb!=null && rsImpMb.size() > 0){
//					  while(rsImpMb.next()){
//						  mbachieve = new BigDecimal(rsImpMb.getString("MB"));  
//						  mbMap.put("immbAchieve", mbachieve.toString());
//					  }
//				}
//				
//				String mbbili  = tempMap.get("MBBILI").toString();
//				 
//				String sqlMBStr = "  /*dialect*/  select  sum(MBACHIEVE )  as MBACHIEVE from ( select (nvl(sum(tem.cfpayment),0)- nvl(sum(nvl(tem.cfgiftpayment,0) *"+gifAmountPro+" ),0) ) as MBACHIEVE   FROM  CT_PAY_AchieveDetailTem tem where  tem.cfnursenumber = '"+empNum+"'  and  cfclinicnumber='"+clinicNumber+"' and  to_char(fbizdate,'YYYYMM') ='"+periodnum+"' and (cfincome!=0 or cfpayment!=0)   and     "+
//					"    (  tem.cffirclassnumber in  ("+mbOne+") or tem.cfsecclassnumber in ("+mbTwo+") or tem.cffeeitemdetailnumber in  ("+mbThree+") )    "+
//					" union select (nvl(sum(cforiprice*cfqty)*"+freeWorkPro+",0)) as MBACHIEVE   FROM  CT_PAY_AchieveDetailTem tem where  tem.cfnursenumber = '"+empNum+"'  and cfclinicnumber='"+clinicNumber+"' and  to_char(fbizdate,'YYYYMM') ='"+periodnum+"' and cfincome=0 and  cfpayment=0   and     "+
//					"    (  tem.cffirclassnumber in  ("+mbOne+") or tem.cfsecclassnumber in ("+mbTwo+") or tem.cffeeitemdetailnumber in  ("+mbThree+") ) )   ";
//				
//				IRowSet rsmb =  DBUtil.executeQuery(ctx,sqlMBStr);
//				if(rsmb!=null && rsmb.size() > 0){
//					  while(rsmb.next()){	
//						  achieve= new BigDecimal(rsmb.getString("MBACHIEVE")).setScale(2,BigDecimal.ROUND_HALF_UP);
//						  mbMap.put("xtmbAchieve", achieve.toString());
//						  mbMap.put("mbAchieve", achieve.add(mbachieve).toString());
//						  mbMap.put("meiibaiBonus", achieve.add(mbachieve).multiply(new BigDecimal(mbbili)).toString());
//					  }
//				} 
//				money =achieve.doubleValue(); 
//			} 
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			this.log.error("系统出现异常，请联系管理员");
//		}   
//		return mbMap; 
//	}
	
	
	/**
	 * 
	 * @param ctx
	 * @param empNum
	 * @param cityNumber   上海的店长/副店长
	 * @param periodnum
	 * @param tempMap
	 * @return
	 */ 
	public HashMap<String,String>  getSHDZPostAch(Context ctx,String empNum,String clinicName ,String clinicNumber,String cityNumber,String cityid,String periodnum,boolean clinicFlag,HashMap tempMap,String postType,HashMap<String,String>  zxMap ){
		//Context ctx = Tools.getInstance().getCtx(); 
		HashMap<String,String>  getOtherMap = new HashMap<String,String>();
		BigDecimal money = BigDecimal.ZERO;
		if(empNum == null || empNum.equals("")){
			this.log.error("员工编码不能为空");
			return getOtherMap;
		}else if(periodnum == null || periodnum.equals("")){
			this.log.error("期间不能为空");
			return getOtherMap;
		}/*else if(clinicNumber == null || clinicNumber.equals("")){
			this.log.error("门诊编码不能为空");
			return 0.0D;
		}*/
		String clinicId = "";
		try{ 
			  
			if((null == tempMap) || (null == tempMap.get(empNum+"_MD")) || "".equals(tempMap.get(empNum+"_MD").toString()) ){
				 
			}else{  
				BigDecimal moneyBig =  BigDecimal.ZERO;
				BigDecimal moneyPay =  BigDecimal.ZERO;
				BigDecimal shopTrget = BigDecimal.ZERO;
				
				BigDecimal moneyPer =  BigDecimal.ZERO;
				 
				//门店达成目标 奖励金额
				BigDecimal getGlopAmount = BigDecimal.ZERO;
				
				BigDecimal shopMDAmount = BigDecimal.ZERO;
				if(clinicFlag){
					String sqlShop = " /*dialect*/ select   nvl(monthSum.CFIncome,0)  as thiscount , nvl(monthSum.cfdiary,0) as pay ,(budgetDate.cftarget*10000) as target from  CT_PAY_ClinicMonthSum   monthSum  "+
					" left join  CT_PAY_BudgetDate  budgetDate  on  budgetDate.cfcompanyid = monthSum.CFclinicid and budgetDate.cfbusinessdate =  '"+periodnum+"'    where   CFClinicNumber='"+clinicNumber+"'  and  monthSum.cfbusinessdate =  '"+periodnum+"' ";
					IRowSet rsShop =  DBUtil.executeQuery(ctx,sqlShop);
					if(rsShop!=null && rsShop.size() > 0){
						  while(rsShop.next()){	
							  //门诊营收总业绩 
							  moneyPay = new BigDecimal (rsShop.getString("PAY"));  
							  //moneyPay = new BigDecimal (rsShop.getString("THISCOUNT"));  
							  //目标业绩
							  shopTrget =   new BigDecimal(rsShop.getString("TARGET")); 
						  }
					} 
					//门店达成奖励
					HashMap map = (HashMap) tempMap.get(cityid+"_"+periodnum+"_MONEY_MD"); 
					//封顶金额
					BigDecimal higAmount  = new BigDecimal(map.get("CFHIGAMOUNT").toString());
					//奖励金额
					BigDecimal rewardAmount  = new BigDecimal(map.get("CFREWARDAMOUNT").toString());
					//额定比例
					BigDecimal passPro  = new BigDecimal(map.get("CFPASSPRO").toString());
					//超额定奖励金额
					BigDecimal addAmount  = new BigDecimal(map.get("CFADDAMOUNT").toString()); 
					  
					if(shopTrget.compareTo(BigDecimal.ZERO) != 0){
						System.out.print("----------");
						if(moneyPay.divide(shopTrget,2, BigDecimal.ROUND_HALF_UP).compareTo(BigDecimal.ONE) > 0){//总支付业绩超过目标业绩
							getGlopAmount = rewardAmount;
							
							BigDecimal passAllPro = moneyPay.divide(shopTrget,2, BigDecimal.ROUND_HALF_UP).subtract(BigDecimal.ONE);
							if(passAllPro.divide(passPro).compareTo(BigDecimal.ONE) >= 0){
								BigDecimal passCount = passAllPro.divide(passPro).setScale(0, BigDecimal.ROUND_DOWN );
								getGlopAmount = getGlopAmount.add(passCount.multiply(addAmount));
							}
							if(getGlopAmount.compareTo(higAmount) > 0){
								getGlopAmount = higAmount;
							}
						}
					}
					getOtherMap.put("getGlopAmount", getGlopAmount+"");
					//如果是副店长   没有门诊业绩提成
					if(!postType.equals("FMZYYZJ")){
						//业绩提成比例
						BigDecimal achievePro  = new BigDecimal(map.get("CFACHIEVEPRO").toString()); 
						if("MS3101WLMZ006".equals(clinicNumber)){
							achievePro = new BigDecimal("0.005");
						}
						//门店业绩提成
						shopMDAmount = moneyPay.multiply(achievePro);
					}
					getOtherMap.put("shopMDAmount", shopMDAmount+""); 
				}else{
					getOtherMap.put("getGlopAmount", getGlopAmount+"");
					getOtherMap.put("shopMDAmount", shopMDAmount+"");
				}
				//咨询奖金计算
				BigDecimal improtAchieve =  BigDecimal.ZERO;
				BigDecimal qkAchieve =  BigDecimal.ZERO;
				BigDecimal xtprotAchieve =  BigDecimal.ZERO;
				
//				String zximSql = "/*dialect*/ SELECT nvl(sum(cfzxachieve),0) as ZX , nvl(sum(cfallGenAchieve),0)  as QK   FROM  CT_PAY_ConsultantBonusUpdate   where  cfempnumber = '"+empNum+"'  and cfcityid = '"+cityid+"' and  cfbusinessdate = '"+periodnum+"'   and  cfclinicnumber = '"+clinicNumber+"' ";
//				IRowSet rsImZX =  DBUtil.executeQuery(ctx,zximSql);
//				if(rsImZX!=null && rsImZX.size() > 0){
//					  while(rsImZX.next()){	
//						  improtAchieve = new BigDecimal(rsImZX.getString("ZX"));
//						  qkAchieve= new BigDecimal(rsImZX.getString("QK"));
//					  }
//				}
				
				if(zxMap != null && zxMap.size() >0){
					improtAchieve = new BigDecimal(zxMap.get("ZX"));
					qkAchieve = new BigDecimal(zxMap.get("QK"));
				}
				HashMap shopBiliMap = (HashMap) tempMap.get(periodnum+"_"+periodnum);  
				BigDecimal biliPro = new BigDecimal(shopBiliMap.get("CFBILIPRO").toString());
				BigDecimal discount = new BigDecimal(shopBiliMap.get("CFDISCOUNT").toString());
				BigDecimal keepPro = new BigDecimal(shopBiliMap.get("CFKEEPPRO").toString());
				
				ArrayList<HashMap> arrayList = new ArrayList<HashMap>(); 
				if(tempMap.get(empNum+"_"+"_SHOP") != null){
					String zxType = tempMap.get(empNum+"_"+"_SHOP").toString(); 
					arrayList = (ArrayList<HashMap>) tempMap.get(zxType+"_"+cityid);
				}else{
					 
				} 
				BigDecimal achieve = BigDecimal.ZERO; 
				achieve = improtAchieve;
				for(HashMap map  : arrayList){ 
					BigDecimal beginAmount = new BigDecimal(map.get("CFBEGINAMOUNT").toString());
					BigDecimal endAmount = new BigDecimal(map.get("CFENDAMOUNT").toString());
					BigDecimal pro = new BigDecimal(map.get("CFPRO").toString()); 
					if(achieve.compareTo(beginAmount) < 1 ){//总业绩小于当前开始阶段金额
						break;
					}else if(achieve.compareTo(endAmount) < 1 ){//总业绩小于当前结束阶段金额
						moneyBig = improtAchieve.multiply(pro).add(moneyBig);
						break;
					}else if(achieve.compareTo(endAmount) == 1){//总业绩大于当前开始阶段金额
						moneyBig = endAmount.subtract(beginAmount).multiply(pro).add(moneyBig);
						improtAchieve = achieve.subtract(endAmount);
					}
		        } 
				 
				//if(improtAchieve.compareTo(BigDecimal.ZERO)!=0 && qkAchieve.divide(improtAchieve).compareTo(biliPro) < 0){
				if( qkAchieve.compareTo(biliPro) < 0){
					moneyBig = moneyBig.multiply(discount);
				}
				
				if(moneyBig.compareTo(BigDecimal.ZERO) >0 && keepPro.compareTo(BigDecimal.ZERO) >0 ){
					BigDecimal keepBouns = moneyBig.multiply(keepPro).setScale(2,BigDecimal.ROUND_HALF_UP);
					ConsultKeepInfo consultKeepInfo = new ConsultKeepInfo();
					consultKeepInfo.setEmpNumber(empNum);
					consultKeepInfo.setClinicNumber(clinicNumber);
					consultKeepInfo.setClinicName(clinicName);
					consultKeepInfo.setCityNumber(cityNumber);
					consultKeepInfo.setBusinessDate(periodnum); 
					consultKeepInfo.setCityName(tempMap.get("cityName").toString());
					consultKeepInfo.setEmpName(tempMap.get("empName").toString());
					CtrlUnitInfo ctrl = new  CtrlUnitInfo();
					ctrl.setId(BOSUuid.read(cityid));
					consultKeepInfo.setCity(ctrl);
					consultKeepInfo.setKeepBouns(keepBouns);
					ConsultKeepFactory.getLocalInstance(ctx).save(consultKeepInfo);
				}
				
				moneyBig = moneyBig.multiply(BigDecimal.ONE.subtract(keepPro)).setScale(2,BigDecimal.ROUND_HALF_UP);
				money = moneyBig.add(shopMDAmount ).add(getGlopAmount );
				getOtherMap.put("allAmount", money+"");
				
				
				getOtherMap.put("imotherAchieve", achieve+"");
				getOtherMap.put("xtotherAchieve", xtprotAchieve+"");
				getOtherMap.put("zxAmount", moneyBig+"");
				//getOtherMap.put("qkAchieve",qkAchieve+"");
				getOtherMap.put("zxAchieve",achieve.toString());
				
				getOtherMap.put("postType", "MZYYZJ");
				return getOtherMap;
				//money = Double.parseDouble(tempMap.get(key).toString()); 
			}  
			 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.log.error("系统出现异常，请联系管理员");
		}  
		
		return getOtherMap;
		
	}
	
	
	/**
	 * 获取咨询师奖金
	 */
	public HashMap<String,String> getSHConsultantBonus(Context ctx,String empNum, String clinicNumber ,String  clinicName,String cityNumber,String periodnum,String cityId,HashMap tempMap,HashMap<String,String>  zxMap ){
		//Context ctx = Tools.getInstance().getCtx(); 
		HashMap<String,String>  retzxMap = new HashMap<String,String>();
		double money = 0.0D;
		if(empNum == null || empNum.equals("")){
			this.log.error("员工编码不能为空");
			return null;
		}else if(periodnum == null || periodnum.equals("")){
			this.log.error("期间不能为空");
			return null;
		}
		 
		try { 
			//判断是否是咨询师 
			if((null == tempMap) || (null == tempMap.get(empNum+"_ZX")) || "".equals(tempMap.get(empNum+"_ZX").toString()) ){
				 
			}else{
				BigDecimal achieve = BigDecimal.ZERO; 
				BigDecimal moneyBig = BigDecimal.ZERO;
				//咨询奖金计算
				BigDecimal improtAchieve =  BigDecimal.ZERO;
				BigDecimal qkAchieve =  BigDecimal.ZERO;
				BigDecimal xtprotAchieve =  BigDecimal.ZERO;
				
 
				
				if(zxMap != null && zxMap.size() >0){
					improtAchieve = new BigDecimal(zxMap.get("ZX"));
					qkAchieve = new BigDecimal(zxMap.get("QK"));
				} 
				achieve = improtAchieve;
				ArrayList<HashMap> arrayList = new ArrayList<HashMap>(); 
				if(tempMap.get(empNum+"_"+"_SHOP") != null){
					String zxType = tempMap.get(empNum+"_"+"_SHOP").toString(); 
					arrayList = (ArrayList<HashMap>) tempMap.get(zxType+"_"+cityId);
				}else{
					 
				} 
				for(HashMap map  : arrayList){ 
					BigDecimal beginAmount = new BigDecimal(map.get("CFBEGINAMOUNT").toString());
					BigDecimal endAmount = new BigDecimal(map.get("CFENDAMOUNT").toString());
					BigDecimal pro = new BigDecimal(map.get("CFPRO").toString()); 
					if(achieve.compareTo(beginAmount) < 1 ){//总业绩小于当前开始阶段金额
						break;
					}else if(achieve.compareTo(endAmount) < 1 ){//总业绩小于当前结束阶段金额
						moneyBig = improtAchieve.multiply(pro).add(moneyBig);
						break;
					}else if(achieve.compareTo(endAmount) == 1){//总业绩大于当前开始阶段金额
						moneyBig = endAmount.subtract(beginAmount).multiply(pro).add(moneyBig);
						improtAchieve = achieve.subtract(endAmount);
					}
		        }  
				HashMap shopBiliMap = (HashMap) tempMap.get("SHZIXUN_YY");   
				BigDecimal biliPro = new BigDecimal(shopBiliMap.get("CFBILIPRO").toString());
				BigDecimal discount = new BigDecimal(shopBiliMap.get("CFDISCOUNT").toString());
				BigDecimal keepPro = new BigDecimal(shopBiliMap.get("CFKEEPPRO").toString());
				
				//if(improtAchieve.compareTo(BigDecimal.ZERO)!=0 && qkAchieve.divide(improtAchieve).compareTo(biliPro) < 0){
				if( qkAchieve.compareTo(biliPro) < 0){
					moneyBig = moneyBig.multiply(discount);
				}
				
				//资金预留处理 
				if(moneyBig.compareTo(BigDecimal.ZERO) >0 && keepPro.compareTo(BigDecimal.ZERO) >0){
					BigDecimal keepBouns = moneyBig.multiply(keepPro);
					ConsultKeepInfo consultKeepInfo = new ConsultKeepInfo();
					consultKeepInfo.setEmpNumber(empNum);
					consultKeepInfo.setClinicNumber(clinicNumber);
					consultKeepInfo.setClinicName(clinicName);
					consultKeepInfo.setCityNumber(cityNumber);
					consultKeepInfo.setBusinessDate(periodnum); 
					consultKeepInfo.setCityName(tempMap.get("cityName").toString());
					consultKeepInfo.setEmpName(tempMap.get("empName").toString());
					CtrlUnitInfo ctrl = new  CtrlUnitInfo();
					ctrl.setId(BOSUuid.read(cityId));
					consultKeepInfo.setCity(ctrl);
					consultKeepInfo.setKeepBouns(keepBouns);
					ConsultKeepFactory.getLocalInstance(ctx).save(consultKeepInfo);
				}

				
				moneyBig = moneyBig.multiply(BigDecimal.ONE.subtract(keepPro));
				retzxMap.put("zixunBonus",moneyBig+"");
				retzxMap.put("postType", "ZXS");
				retzxMap.put("imzxAchieve",achieve.toString());
				retzxMap.put("xtzxAchieve","0");
				retzxMap.put("zxAchieve",achieve.toString());
				
				retzxMap.put("qkAchieve",qkAchieve+"");
				
				 
			}  
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.log.error("系统出现异常，请联系管理员");
		}  
		return retzxMap;
	}
	 
	
	
	
//	public HashMap<String,String> getSHKeFuBonus(Context ctx,String empNum,String clinicNumber, String cityNumber,String periodnum,String cityId,HashMap tempMap){
//		HashMap<String,String>  kfMap = new HashMap<String,String>();
//		//Context ctx = Tools.getInstance().getCtx(); 
//		double money = 0.0D;
//		if(empNum == null || empNum.equals("")){
//			this.log.error("员工编码不能为空");
//			return  null;
//		}else if(periodnum == null || periodnum.equals("")){
//			this.log.error("期间不能为空");
//			return  null;
//		} 
//		//赠金比例
//		BigDecimal gifAmountPro = BigDecimal.ZERO; 
//		HashMap tongyongmap = (HashMap)tempMap.get("TONGYONGBILI_DOC");
//		gifAmountPro =  new BigDecimal(tongyongmap.get("CFGIFAMOUNTPRO").toString());
//		 
//		try {  
//			
//			BigDecimal  achieve = BigDecimal.ZERO; 
//			kfMap.put("postType", "KF");
//			
//			//周边比例
//			BigDecimal zbPro = BigDecimal.ZERO;    
//			zbPro = new BigDecimal(tempMap.get("KEFU_ZHOUBIANPRO").toString());    
//			
//			BigDecimal zbachieve =BigDecimal.ZERO;
//			String importJy = " /*dialect*/ SELECT nvl(sum(cfzpachieve),0) as kf FROM  CT_PAY_ConsultantBonusUpdate   where cfempnumber = '"+empNum+"' and cfcityid = '"+cityId+"' and cfbusinessdate = '"+periodnum+"' and cfclinicnumber ='"+clinicNumber+"' ";
//			IRowSet rsImpMb =  DBUtil.executeQuery(ctx,importJy);
//			if(rsImpMb!=null && rsImpMb.size() > 0){
//				  while(rsImpMb.next()){
//					  zbachieve = new BigDecimal(rsImpMb.getString("KF"));  
//					  kfMap.put("imkfAchieve", zbachieve.toString());
//				  }
//			 }
//			 
//			
//			String sqlMBStr = "  /*dialect*/ select  nvl(sum(cfpayment),0)-(nvl(sum(cfgiftpayment),0)*"+gifAmountPro+")  as KFACHIEVE   FROM  CT_PAY_AchieveDetailTem tem where   cfclinicnumber='"+clinicNumber+"' and tem.cfrecpersonnumber = '"+empNum+"'  and to_char(fbizdate,'YYYYMM') ='"+periodnum+"'  and  cfsecclassnumber  ='75'    ";
//			
//			IRowSet rsmb =  DBUtil.executeQuery(ctx,sqlMBStr);
//			if(rsmb!=null && rsmb.size() > 0){
//				  while(rsmb.next()){	
//					  achieve= new BigDecimal(rsmb.getString("KFACHIEVE")).setScale(2,BigDecimal.ROUND_HALF_UP);
//					  kfMap.put("xtkfAchieve", achieve.toString());
//					  kfMap.put("kfAchieve", achieve.add(zbachieve).toString());
//					  kfMap.put("kfBonus", achieve.add(zbachieve).multiply(zbPro).toString());
//				  }
//			}
//			
//			money =achieve.doubleValue();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			this.log.error("系统出现异常，请联系管理员");
//		}  
//		
//		return kfMap;
//		
//	}
 
}
