package com.kingdee.eas.mw.srqr.app.util;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.kingdee.bos.Context;
import com.kingdee.bos.util.BOSUuid;
import com.kingdee.eas.base.core.fm.ContextHelperFactory;
import com.kingdee.eas.basedata.framework.app.ParallelSqlExecutor;
import com.kingdee.eas.basedata.org.CtrlUnitInfo;
import com.kingdee.eas.mw.pay.ClinicCostSumFactory;
import com.kingdee.eas.mw.pay.ClinicCostSumInfo;
import com.kingdee.eas.mw.pay.DoctorCostsFactory;
import com.kingdee.eas.mw.pay.DoctorCostsInfo;
import com.kingdee.eas.mw.pay.app.costType;
import com.kingdee.jdbc.rowset.IRowSet;

public class PayDocFunctionService {

	private Logger log;
	public PayDocFunctionService() {
		this.log = LoggerFactory.getLogger(PayDocFunctionService.class);
	}
	/**
	 * 获取医生奖金
	 */
	public HashMap<String,Object>  getDocBonus(Context ctx,String empNum, String clinicNumber,String periodnum,HashMap tempMap,String cityId,String cityNumber){
		//Context ctx = Tools.getInstance().getCtx(); 
		//只有普通医生才有医助
		HashMap<String,Object>  docMap = new HashMap<String,Object>();
		String insertSql =  "";
		String insertValueSql = "";
		
		String imandxtinsertsql = "";
		String imandxtinsertValueSql = "";
		double money = 0.0D;
		if(empNum == null || empNum.equals("")){
			this.log.error("员工编码不能为空");
			return null;
		}else if(periodnum == null || periodnum.equals("")){
			this.log.error("期间不能为空");
			return null;
		}
		try{ 
			
			BigDecimal costAll = BigDecimal.ZERO; 
			
			//医生基础业绩
			BigDecimal docBase = BigDecimal.ZERO; 

			//种植比例
			BigDecimal zzbi = BigDecimal.ZERO; 
			//固定矫正比例
			BigDecimal gdjzbi = BigDecimal.ZERO; 
			//隐形矫正比例
			BigDecimal yxjzbi = BigDecimal.ZERO; 
			//牙周比例
			BigDecimal yzbi = BigDecimal.ZERO; 
			//口内外比例
			BigDecimal knwbi = BigDecimal.ZERO; 
			//美白比例
			BigDecimal mbbi = BigDecimal.ZERO; 
			//修复比例
			BigDecimal xfbi = BigDecimal.ZERO; 
			//儿牙比例
			BigDecimal eybi = BigDecimal.ZERO; 
			
			//种植
			BigDecimal zz = BigDecimal.ZERO; 
			//固定矫正
			BigDecimal gdjz = BigDecimal.ZERO; 
			//隐形矫正
			BigDecimal yxjz = BigDecimal.ZERO; 
			//牙周
			BigDecimal yz = BigDecimal.ZERO; 
			//口内外
			BigDecimal knw = BigDecimal.ZERO; 
			//美白
			BigDecimal mb = BigDecimal.ZERO; 
			//修复
			BigDecimal xf = BigDecimal.ZERO; 
			//儿牙
			BigDecimal ey = BigDecimal.ZERO; 
			//正畸比例
			BigDecimal zjbl = new BigDecimal("0.8"); 
			//种植成本
			BigDecimal zzcb = BigDecimal.ZERO; 
			//固定矫正成本
			BigDecimal gdjzcb = BigDecimal.ZERO; 
			//隐形矫正成本
			BigDecimal yxjzcb = BigDecimal.ZERO; 
			//牙周成本
			BigDecimal yzcb = BigDecimal.ZERO; 
			//口内外成本
			BigDecimal knwcb = BigDecimal.ZERO; 
			//美白成本
			BigDecimal mbcb = BigDecimal.ZERO; 
			//修复成本
			BigDecimal xfcb = BigDecimal.ZERO; 
			//儿牙成本
			BigDecimal eycb = BigDecimal.ZERO; 
			
			ClinicCostSumInfo clinicCostSumInfo = new ClinicCostSumInfo();
			clinicCostSumInfo.setEmpNumber(empNum);
			clinicCostSumInfo.setClinicNumber(clinicNumber);
			clinicCostSumInfo.setCityNumber(cityNumber);
			clinicCostSumInfo.setBusinessDate(periodnum); 
			clinicCostSumInfo.setCityName(tempMap.get("cityName").toString());
			clinicCostSumInfo.setEmpName(tempMap.get("empName").toString());
			
			String  calType = "";
			String  calTypeSql = "/*dialect*/  SELECT   CFCALTYPE  FROM CT_PAY_DocCurrencyPro  where  cfcityid= '"+cityId+"' and cfbusinessdate='"+periodnum+"'";
			IRowSet calTypeRs = com.kingdee.eas.custom.util.DBUtil.executeQuery(ctx,calTypeSql);
			if(calTypeRs!=null && calTypeRs.size() > 0){
				while(calTypeRs.next()){
					calType = calTypeRs.getString("CFCALTYPE");
				}
			}
			HashMap<String,BigDecimal> biliMap = new HashMap<String,BigDecimal>(); 
			//普通医生
			if((null == tempMap) || (null == tempMap.get(empNum+"_DOC"))){
				
			}else{
				HashMap map = new HashMap();
				
				map = (HashMap) tempMap.get(empNum+"_"+"TL_DOC");
				
				if (map == null || map.get("CFPERFORMANCEBASE")== null){
					return docMap;
				}
				docMap.put("postType", "YS");
				//医生基础业绩
				docBase = new BigDecimal(map.get("CFPERFORMANCEBASE").toString());  
				
				//取医生业绩里面的比例
				zzbi = new BigDecimal(map.get("CFZZPROPORTION").toString());
				gdjzbi = new BigDecimal(map.get("CFGDPROPORTION").toString());
				yxjzbi = new BigDecimal(map.get("CFYXPROPORTION").toString());
				yzbi = new BigDecimal(map.get("CFZBPROPORTION").toString());//?
				knwbi = new BigDecimal(map.get("CFKNPROPORTION").toString());
				mbbi = new BigDecimal(map.get("CFMBPROPORTION").toString());
				xfbi = new BigDecimal(map.get("CFXFPROPORTION").toString());
				eybi = new BigDecimal(map.get("CFEYPROPORTION").toString()); 
				zjbl = new BigDecimal(map.get("CFZJBILI").toString());  
				/*if(null != tempMap.get(empNum+"_TESHUDOC") &&  !"".equals(tempMap.get(empNum+"_TESHUDOC"))){
					//特殊情况
					
					
				}else{
					//正常情况
					//通用map
					HashMap tymap = new HashMap();
					tymap = (HashMap) tempMap.get("TONGYONGBILI_DOC");
					
					zzbi = new BigDecimal(tymap.get("CFZZBL").toString());
					gdjzbi = new BigDecimal(tymap.get("CFGDJZBL").toString());
					yxjzbi = new BigDecimal(tymap.get("CFYXJZBL").toString());
					yzbi = new BigDecimal(tymap.get("CFYZZLBL").toString());//?
					knwbi = new BigDecimal(tymap.get("CFKNWBL").toString());
					mbbi = new BigDecimal(tymap.get("CFMBBL").toString());
					xfbi = new BigDecimal(tymap.get("CFXFBL").toString());
					eybi = new BigDecimal(tymap.get("CFEYBL").toString()); 
					zjbl = new BigDecimal(tymap.get("CFZJBL").toString()); 
				}*/
				
				biliMap.put("zz",zzbi );
				biliMap.put("gdjz",gdjzbi );
				biliMap.put("yxjz",yxjzbi );
				biliMap.put("yz",yzbi );
				biliMap.put("knw",knwbi );
				biliMap.put("mb",mbbi );
				biliMap.put("xf",xfbi );
				biliMap.put("ey",eybi );
				biliMap.put("zj",zjbl );
				
				//查询医生的业绩 
				
				//即是医生 又是医助  ？？？  不可能有
				
				//不是医生  就是医助  要不就是没有这个关系
				String isDocOrAss = "";
				String  costEmp = "";
				int i = 0;
				//查看医生是否有医助
				//如果有医助  查询出来医助  然后按照比例获取业绩
				//-------
				String  isDoc = "/*dialect*/  SELECT  CFASSNUMBER,nvl(CFBILI,0) as CFBILI  FROM  CT_PAY_DoctorRelation where  cfdocnumber = '"+empNum+"' and cfbusinessdate = '"+periodnum+"'  and cfcityid = '"+cityId+"' ";
				IRowSet isDocRs = com.kingdee.eas.custom.util.DBUtil.executeQuery(ctx,isDoc);
				if(isDocRs!=null && isDocRs.size() > 0){
					  isDocOrAss ="DOC";
					  while(isDocRs.next()){	
						  String assNumber = isDocRs.getString("CFASSNUMBER");
						  if(i==0){
							  costEmp  = " '"+empNum+ "','"+assNumber+"' ";
							  i++;
						  }else{
							  costEmp  = costEmp + ",'"+assNumber+"' ";
						  }
						  BigDecimal bili = new BigDecimal(isDocRs.getString("CFBILI"));
						  
						  StringBuffer sqlYJ = new StringBuffer(); 
						  sqlYJ = getYeJiSql( assNumber,  cityNumber, periodnum, sqlYJ, cityId,zjbl);
						  System.out.println("--"+sqlYJ);
						  IRowSet yjrs = com.kingdee.eas.custom.util.DBUtil.executeQuery(ctx,sqlYJ.toString());
						  if(yjrs!=null && yjrs.size() > 0){
							  	while(yjrs.next()){
							  		if("zz".equals(yjrs.getString("TYPE"))){//种植
							  			zz = zz.add(new BigDecimal(yjrs.getString("SUMM")).multiply(bili)); 
							  		}else if("gdjz".equals(yjrs.getString("TYPE"))){//固定矫正 ？
							  			gdjz= gdjz.add(new BigDecimal(yjrs.getString("SUMM")).multiply(bili)); 
							  		}else if("yxjz".equals(yjrs.getString("TYPE"))){//隐形矫正
							  			yxjz= yxjz.add(new BigDecimal(yjrs.getString("SUMM")).multiply(bili)); 
							  		}else if("yz".equals(yjrs.getString("TYPE"))){//牙周 ？
							  			yz= yz.add(new BigDecimal(yjrs.getString("SUMM")).multiply(bili)); 
							  		}else if("knw".equals(yjrs.getString("TYPE"))){//口内外 ？
							  			knw = knw.add(new BigDecimal(yjrs.getString("SUMM")).multiply(bili));
							  		}else if("mb".equals(yjrs.getString("TYPE"))){//美白
							  			//mb= mb.add(new BigDecimal(yjrs.getString("SUMM")).multiply(bili)); 
							  		}else if("xf".equals(yjrs.getString("TYPE"))){//修复
							  			xf= xf.add(new BigDecimal(yjrs.getString("SUMM")).multiply(bili));  
							  		}else if("ey".equals(yjrs.getString("TYPE"))){//儿牙
							  			ey= ey.add(new BigDecimal(yjrs.getString("SUMM")).multiply(bili)); 
							  		} 
							  }
						  } 
					  }
				}
				//查看自己是否为医助    如果自己为医助  按照比例取自己的业绩
				
				//一个医助 对应多个医生   有没有情况    不会  
				
				if("".equals(isDocOrAss)){
					String  isAss = " /*dialect*/ SELECT  CFDOCNUMBER,nvl(CFBILI,0) as CFBILI  FROM  CT_PAY_DoctorRelation where  CFASSNUMBER = '"+empNum+"' and cfbusinessdate = '"+periodnum+"'  and cfcityid = '"+cityId+"' ";
					IRowSet isAssRs = com.kingdee.eas.custom.util.DBUtil.executeQuery(ctx,isAss);
					if(isAssRs!=null && isAssRs.size() > 0){
						  isDocOrAss ="ASS";
						  costEmp  = "'"+empNum+"'";
						  while(isAssRs.next()){	
							  String docNumber = isAssRs.getString("CFDOCNUMBER");
							  BigDecimal bili = new BigDecimal("1").subtract(new BigDecimal(isAssRs.getString("CFBILI")));
							  
							  StringBuffer sqlYJ = new StringBuffer(); 
							  //传递自己的编码  分给医生
							  sqlYJ = getYeJiSql( empNum,  cityNumber, periodnum, sqlYJ, cityId,zjbl);
							  System.out.println("--"+sqlYJ);
							  IRowSet yjrs = com.kingdee.eas.custom.util.DBUtil.executeQuery(ctx,sqlYJ.toString());
							  if(yjrs!=null && yjrs.size() > 0){
								  	while(yjrs.next()){	
								  		if("zz".equals(yjrs.getString("TYPE"))){//种植
								  			zz = zz.add(new BigDecimal(yjrs.getString("SUMM")).multiply(bili)); 
								  		}else if("gdjz".equals(yjrs.getString("TYPE"))){//固定矫正 ？
								  			gdjz= gdjz.add(new BigDecimal(yjrs.getString("SUMM")).multiply(bili)); 
								  		}else if("yxjz".equals(yjrs.getString("TYPE"))){//隐形矫正
								  			yxjz= yxjz.add(new BigDecimal(yjrs.getString("SUMM")).multiply(bili)); 
								  		}else if("yz".equals(yjrs.getString("TYPE"))){//牙周 ？
								  			yz= yz.add(new BigDecimal(yjrs.getString("SUMM")).multiply(bili)); 
								  		}else if("knw".equals(yjrs.getString("TYPE"))){//口内外 ？
								  			knw = knw.add(new BigDecimal(yjrs.getString("SUMM")).multiply(bili));
								  		}else if("mb".equals(yjrs.getString("TYPE"))){//美白
								  			//mb= mb.add(new BigDecimal(yjrs.getString("SUMM")).multiply(bili)); 
								  			mb= mb.add(new BigDecimal(yjrs.getString("SUMM"))); 
								  		}else if("xf".equals(yjrs.getString("TYPE"))){//修复
								  			xf= xf.add(new BigDecimal(yjrs.getString("SUMM")).multiply(bili));  
								  		}else if("ey".equals(yjrs.getString("TYPE"))){//儿牙
								  			ey= ey.add(new BigDecimal(yjrs.getString("SUMM")).multiply(bili)); 
								  		} 
								  }
							  } 
						  }
					}
					
				} 
				
				if("DOC".equals(isDocOrAss)|| "".equals(isDocOrAss)){
					StringBuffer sqlYJ = new StringBuffer(); 
				  	sqlYJ = getYeJiSql( empNum,  cityNumber, periodnum, sqlYJ, cityId,zjbl);
				  	System.out.println("--"+sqlYJ);
				  	IRowSet yjrs = com.kingdee.eas.custom.util.DBUtil.executeQuery(ctx,sqlYJ.toString());
				  	if(yjrs!=null && yjrs.size() > 0){
				  	costEmp ="'"+empNum+"'";
					  	while(yjrs.next()){	
					  		if("zz".equals(yjrs.getString("TYPE"))){//种植
					  			zz = zz.add(new BigDecimal(yjrs.getString("SUMM"))); 
					  		}else if("gdjz".equals(yjrs.getString("TYPE"))){//固定矫正 ？
					  			gdjz= gdjz.add(new BigDecimal(yjrs.getString("SUMM"))); 
					  		}else if("yxjz".equals(yjrs.getString("TYPE"))){//隐形矫正
					  			yxjz= yxjz.add(new BigDecimal(yjrs.getString("SUMM"))); 
					  		}else if("yz".equals(yjrs.getString("TYPE"))){//牙周 ？
					  			yz= yz.add(new BigDecimal(yjrs.getString("SUMM"))); 
					  		}else if("knw".equals(yjrs.getString("TYPE"))){//口内外 ？
					  			knw = knw.add(new BigDecimal(yjrs.getString("SUMM")));
					  		}else if("mb".equals(yjrs.getString("TYPE"))){//美白
					  			mb= mb.add(new BigDecimal(yjrs.getString("SUMM"))); 
					  		}else if("xf".equals(yjrs.getString("TYPE"))){//修复
					  			xf= xf.add(new BigDecimal(yjrs.getString("SUMM")));  
					  		}else if("ey".equals(yjrs.getString("TYPE"))){//儿牙
					  			ey= ey.add(new BigDecimal(yjrs.getString("SUMM"))); 
					  		} 
						}
					} 
					
				} 	
				
				imandxtinsertsql +=  ", CFXTZZACHIEVE , CFXTGDJZACHIEVE , cfXTyxjzachieve, CFXTyzAchieve , cfXTknwachieve , cfXTmbachieve , cfXTxfachieve, cfXTeyachieve ";
				imandxtinsertValueSql +=" ,"+zz+" ,"+gdjz+","+yxjz+","+yz+","+knw+","+mb+","+xf+","+ey+"  ";
				
				
				
				StringBuffer sqlImportYJ = new StringBuffer(); 
				sqlImportYJ = getYeJiImpSql( empNum,  cityNumber, periodnum, sqlImportYJ, cityId,zjbl);
			  	System.out.println("--"+sqlImportYJ);
			  	IRowSet yjImprs = com.kingdee.eas.custom.util.DBUtil.executeQuery(ctx,sqlImportYJ.toString());
			  	if(yjImprs!=null && yjImprs.size() > 0){ 
				  	while(yjImprs.next()){	
				  		zz = zz.add(new BigDecimal(yjImprs.getString("ZZ"))); 
				  		gdjz= gdjz.add(new BigDecimal(yjImprs.getString("GDJZ"))); 
				  		yxjz= yxjz.add(new BigDecimal(yjImprs.getString("YXJZ"))); 
				  		yz= yz.add(new BigDecimal(yjImprs.getString("YZ"))); 
				  		knw = knw.add(new BigDecimal(yjImprs.getString("KNW")));
				  		mb= mb.add(new BigDecimal(yjImprs.getString("MB"))); 
				  		xf= xf.add(new BigDecimal(yjImprs.getString("XF")));  
				  		ey= ey.add(new BigDecimal(yjImprs.getString("EY")));  
				  		
				  		imandxtinsertsql +=  ", CFIMZZACHIEVE , CFIMGDJZACHIEVE , cfIMyxjzachieve, CFIMyzAchieve , cfIMknwachieve , cfIMmbachieve , cfIMxfachieve, cfIMeyachieve ";
						imandxtinsertValueSql +=" ,"+new BigDecimal(yjImprs.getString("ZZ"))+" ,"+new BigDecimal(yjImprs.getString("GDJZ"))+","+new BigDecimal(yjImprs.getString("YXJZ"))
						+","+new BigDecimal(yjImprs.getString("YZ"))+","+new BigDecimal(yjImprs.getString("KNW"))+","+new BigDecimal(yjImprs.getString("MB"))+","+new BigDecimal(yjImprs.getString("XF"))+"," +
								""+new BigDecimal(yjImprs.getString("EY"))+"  ";
					}
				  	
					
				} 
				 

				//zz.add(new BigDecimal("-3880.64"));
				//knw = knw.add(new BigDecimal("-4872.32"));
				//xf  = xf.add(new BigDecimal("-21250"));
				//gdjz = new BigDecimal("40067.712").subtract(new BigDecimal("1887.321429"));
				
				
				 
			  	
			    //获得 导入的成本
				StringBuffer sqlImportCB = new StringBuffer(); 
				sqlImportCB = getImportChengBenSql( costEmp,  cityId, periodnum, sqlImportCB);
				IRowSet imporytbrs = com.kingdee.eas.custom.util.DBUtil.executeQuery(ctx,sqlImportCB.toString());
				if(imporytbrs!=null && imporytbrs.size() > 0){
					  while(imporytbrs.next()){	
						  if("zz".equals(imporytbrs.getString("TYPE"))){//种植
							  zzcb =new BigDecimal(imporytbrs.getString("SUMM")); 
							  costAll = costAll.add(zzcb);
							   
							  clinicCostSumInfo.setImzzCost(zzcb);
						  }else if("gdjz".equals(imporytbrs.getString("TYPE"))){//固定矫正
							  gdjzcb=new BigDecimal(imporytbrs.getString("SUMM")); 
							  costAll = costAll.add(gdjzcb);
							   
							  clinicCostSumInfo.setImgdjzCost(gdjzcb);
						  }else if("yxjz".equals(imporytbrs.getString("TYPE"))){//隐形矫正
							  yxjzcb=new BigDecimal(imporytbrs.getString("SUMM")); 
							  costAll = costAll.add(yxjzcb);
							   
							  clinicCostSumInfo.setImyxjzCost(yxjzcb);
						  }else if("yz".equals(imporytbrs.getString("TYPE"))){//牙周
							  yzcb=new BigDecimal(imporytbrs.getString("SUMM")); 
							  costAll = costAll.add(yzcb);
							   
							  clinicCostSumInfo.setImyzCost(yzcb);
						  }else if("knw".equals(imporytbrs.getString("TYPE"))){//口内外
							  knwcb =new BigDecimal(imporytbrs.getString("SUMM"));
							  costAll = costAll.add(knwcb);
							   
							  clinicCostSumInfo.setImknwCost(knwcb);
						  }else if("mb".equals(imporytbrs.getString("TYPE"))){//美白
							  mbcb=new BigDecimal(imporytbrs.getString("SUMM")); 
							  costAll = costAll.add(mbcb); 
							  
							  clinicCostSumInfo.setImmbCost(mbcb);
						  }else if("xf".equals(imporytbrs.getString("TYPE"))){//修复
							  xfcb=new BigDecimal(imporytbrs.getString("SUMM")); 
							  costAll = costAll.add(xfcb);
							   
							  clinicCostSumInfo.setImxfCost(xfcb);
						  }else if("ey".equals(imporytbrs.getString("TYPE"))){//儿牙
							  eycb=new BigDecimal(imporytbrs.getString("SUMM")); 
							  costAll = costAll.add(eycb);
							  
							  clinicCostSumInfo.setImeyCost(eycb);
							   
						  }  
					  }
				}  
				
				
				clinicCostSumInfo.setUpzzCost(BigDecimal.ZERO);
				clinicCostSumInfo.setUpgdjzCost(BigDecimal.ZERO); 
				clinicCostSumInfo.setUpyxjzCost(BigDecimal.ZERO); 
				clinicCostSumInfo.setUpyzCost(BigDecimal.ZERO); 
				clinicCostSumInfo.setUpknwCost(BigDecimal.ZERO); 
				clinicCostSumInfo.setUpmbCost(BigDecimal.ZERO); 
				clinicCostSumInfo.setUpxfCost(BigDecimal.ZERO); 
				clinicCostSumInfo.setUpeyCost(BigDecimal.ZERO);
				
				clinicCostSumInfo.setZzCost(BigDecimal.ZERO);
				clinicCostSumInfo.setGdjzCost(BigDecimal.ZERO);
				clinicCostSumInfo.setYxjzCost(BigDecimal.ZERO);
				clinicCostSumInfo.setYzCost(BigDecimal.ZERO);
				clinicCostSumInfo.setKnwCost(BigDecimal.ZERO);
				clinicCostSumInfo.setMbCost(BigDecimal.ZERO);
				clinicCostSumInfo.setXfCost(BigDecimal.ZERO);
				clinicCostSumInfo.setEyCost(BigDecimal.ZERO);
				
				//获得 护士调整的成本
				StringBuffer sqlHushiCB = new StringBuffer(); 
				sqlHushiCB = getHushiChengBenSql( costEmp,  cityNumber, periodnum, sqlHushiCB,isDocOrAss);
				IRowSet hushiCBrs = com.kingdee.eas.custom.util.DBUtil.executeQuery(ctx,sqlHushiCB.toString());
				if(hushiCBrs!=null && hushiCBrs.size() > 0){
					 while(hushiCBrs.next()){	
						  if("zz".equals(hushiCBrs.getString("TYPE"))){//种植
							  zzcb = zzcb.add(new BigDecimal(hushiCBrs.getString("SUMM"))); 
							  costAll = costAll.add(new BigDecimal(hushiCBrs.getString("SUMM"))); 
							  clinicCostSumInfo.setUpzzCost(new BigDecimal(hushiCBrs.getString("SUMM")));
						  }else if("gdjz".equals(hushiCBrs.getString("TYPE"))){//固定矫正
							  gdjzcb = gdjzcb.add(new BigDecimal(hushiCBrs.getString("SUMM"))); 
							  costAll = costAll.add(new BigDecimal(hushiCBrs.getString("SUMM")));
							    
							  clinicCostSumInfo.setUpgdjzCost(new BigDecimal(hushiCBrs.getString("SUMM")));
						  }else if("yxjz".equals(hushiCBrs.getString("TYPE"))){//隐形矫正
							  yxjzcb = yxjzcb.add(new BigDecimal(hushiCBrs.getString("SUMM"))); 
							  costAll = costAll.add(new BigDecimal(hushiCBrs.getString("SUMM"))); 
							  
							  clinicCostSumInfo.setUpyxjzCost(new BigDecimal(hushiCBrs.getString("SUMM")));
						  }else if("yz".equals(hushiCBrs.getString("TYPE"))){//牙周
							  yzcb = yzcb.add(new BigDecimal(hushiCBrs.getString("SUMM"))); 
							  costAll = costAll.add(new BigDecimal(hushiCBrs.getString("SUMM"))); 
							  
							  clinicCostSumInfo.setUpyzCost(new BigDecimal(hushiCBrs.getString("SUMM")));
						  }else if("knw".equals(hushiCBrs.getString("TYPE"))){//口内外
							  knwcb = knwcb.add(new BigDecimal(hushiCBrs.getString("SUMM")));
							  costAll = costAll.add(new BigDecimal(hushiCBrs.getString("SUMM"))); 
							  
							  clinicCostSumInfo.setUpknwCost(new BigDecimal(hushiCBrs.getString("SUMM")));
						  }else if("mb".equals(hushiCBrs.getString("TYPE"))){//美白
							  mbcb = mbcb.add(new BigDecimal(hushiCBrs.getString("SUMM"))); 
							  costAll = costAll.add(new BigDecimal(hushiCBrs.getString("SUMM")));  
							  
							  clinicCostSumInfo.setUpmbCost(new BigDecimal(hushiCBrs.getString("SUMM")));
						  }else if("xf".equals(hushiCBrs.getString("TYPE"))){//修复
							  xfcb = xfcb.add(new BigDecimal(hushiCBrs.getString("SUMM"))); 
							  costAll = costAll.add(new BigDecimal(hushiCBrs.getString("SUMM"))); 
							  
							  clinicCostSumInfo.setUpxfCost(new BigDecimal(hushiCBrs.getString("SUMM")));
						  }else if("ey".equals(hushiCBrs.getString("TYPE"))){//儿牙
							  eycb = eycb.add(new BigDecimal(hushiCBrs.getString("SUMM"))); 
							  costAll = costAll.add(new BigDecimal(hushiCBrs.getString("SUMM")));  
							  
							  clinicCostSumInfo.setUpeyCost(new BigDecimal(hushiCBrs.getString("SUMM")));
						  }   
					  }
				} 
				//获得销售出库的成本
				StringBuffer sqlCB = new StringBuffer();
				sqlCB = getChengBenSql( costEmp,  cityNumber, periodnum, sqlCB,isDocOrAss);
				IRowSet cbrs = com.kingdee.eas.custom.util.DBUtil.executeQuery(ctx,sqlCB.toString());
				if(cbrs!=null && cbrs.size() > 0){
					  while(cbrs.next()){	
						  if("zz".equals(cbrs.getString("TYPE"))){//种植
							  zzcb = zzcb.add(new BigDecimal(cbrs.getString("SUMM"))); 
							  costAll = costAll.add(new BigDecimal(cbrs.getString("SUMM")));
							  
							  insertSql +=  ", cfzzcost ";
							  insertValueSql += " ,"+zzcb;

							  clinicCostSumInfo.setZzCost(new BigDecimal(cbrs.getString("SUMM")));
						  }else if("gdjz".equals(cbrs.getString("TYPE"))){//固定矫正
							  gdjzcb = gdjzcb.add(new BigDecimal(cbrs.getString("SUMM"))); 
							  costAll = costAll.add(new BigDecimal(cbrs.getString("SUMM")));
							  
							  insertSql +=  ", cfgdjzcost ";
							  insertValueSql += " ,"+gdjzcb;
							  
							  clinicCostSumInfo.setGdjzCost(new BigDecimal(cbrs.getString("SUMM")));
						  }else if("yxjz".equals(cbrs.getString("TYPE"))){//隐形矫正
							  yxjzcb = yxjzcb.add(new BigDecimal(cbrs.getString("SUMM"))); 
							  costAll = costAll.add(new BigDecimal(cbrs.getString("SUMM")));
							  
							  insertSql +=  ", cfyxjzcost ";
							  insertValueSql += " ,"+yxjzcb;
							  
							  clinicCostSumInfo.setYxjzCost(new BigDecimal(cbrs.getString("SUMM")));
						  }else if("yz".equals(cbrs.getString("TYPE"))){//牙周
							  yzcb = yzcb.add(new BigDecimal(cbrs.getString("SUMM"))); 
							  costAll = costAll.add(new BigDecimal(cbrs.getString("SUMM")));
							  
							  insertSql +=  ", cfyzcost ";
							  insertValueSql += " ,"+yzcb;
							  
							  clinicCostSumInfo.setYzCost(new BigDecimal(cbrs.getString("SUMM")));
						  }else if("knw".equals(cbrs.getString("TYPE"))){//口内外
							  knwcb = knwcb.add(new BigDecimal(cbrs.getString("SUMM")));
							  costAll = costAll.add(new BigDecimal(cbrs.getString("SUMM")));
							  
							  insertSql +=  ", cfknwcost ";
							  insertValueSql += " ,"+knwcb;
							  
							  clinicCostSumInfo.setKnwCost(new BigDecimal(cbrs.getString("SUMM")));
						  }else if("mb".equals(cbrs.getString("TYPE"))){//美白
							  mbcb = mbcb.add(new BigDecimal(cbrs.getString("SUMM"))); 
							  costAll = costAll.add(new BigDecimal(cbrs.getString("SUMM")));
							  insertSql +=  ", cfmbcost ";
							  insertValueSql += " ,"+mbcb;
							  
							  clinicCostSumInfo.setMbCost(new BigDecimal(cbrs.getString("SUMM")));
						  }else if("xf".equals(cbrs.getString("TYPE"))){//修复
							  xfcb = xfcb.add(new BigDecimal(cbrs.getString("SUMM"))); 
							  costAll = costAll.add(new BigDecimal(cbrs.getString("SUMM")));
							  
							  insertSql +=  ", cfxfcost ";
							  insertValueSql += " ,"+xfcb;
							  
							  clinicCostSumInfo.setXfCost(new BigDecimal(cbrs.getString("SUMM")));
						  }else if("ey".equals(cbrs.getString("TYPE"))){//儿牙
							  eycb = eycb.add(new BigDecimal(cbrs.getString("SUMM"))); 
							  costAll = costAll.add(new BigDecimal(cbrs.getString("SUMM")));
							  
							  insertSql +=  ", cfeycost ";
							  insertValueSql += " ,"+eycb;
							  
							  clinicCostSumInfo.setEyCost(new BigDecimal(cbrs.getString("SUMM")));
						  }   
					  }
					  
				}  
				clinicCostSumInfo.setAllgdjzCost(clinicCostSumInfo.getUpgdjzCost().add(clinicCostSumInfo.getGdjzCost()).add(clinicCostSumInfo.getImgdjzCost())); 
				clinicCostSumInfo.setAllzzCost(clinicCostSumInfo.getUpzzCost().add(clinicCostSumInfo.getZzCost()).add(clinicCostSumInfo.getImzzCost()));
				clinicCostSumInfo.setAllyxjzCost(clinicCostSumInfo.getUpyxjzCost().add(clinicCostSumInfo.getYxjzCost()).add(clinicCostSumInfo.getImyxjzCost()));
				clinicCostSumInfo.setAllyzCost(clinicCostSumInfo.getUpyzCost().add(clinicCostSumInfo.getYzCost()).add(clinicCostSumInfo.getImyzCost()));
				clinicCostSumInfo.setAllknwCost(clinicCostSumInfo.getUpknwCost().add(clinicCostSumInfo.getKnwCost()).add(clinicCostSumInfo.getImknwCost()));
				clinicCostSumInfo.setAllmbCost(clinicCostSumInfo.getUpmbCost().add(clinicCostSumInfo.getMbCost()).add(clinicCostSumInfo.getImmbCost()));
				clinicCostSumInfo.setAllxfCost(clinicCostSumInfo.getUpxfCost().add(clinicCostSumInfo.getXfCost()).add(clinicCostSumInfo.getImxfCost()));
				clinicCostSumInfo.setAlleyCost(clinicCostSumInfo.getUpeyCost().add(clinicCostSumInfo.getEyCost()).add(clinicCostSumInfo.getImeyCost()));
				
				BigDecimal sumAchieve =  zz.add(gdjz).add(yxjz).add(yz).add(knw).add(mb).add(xf).add(ey);
				
				
				insertSql +=  ", CFZZACHIEVE , CFGDJZACHIEVE , cfyxjzachieve, CFZyAchieve , cfknwachieve , cfmbachieve , cfxfachieve, cfeyachieve ";
				insertValueSql +=" ,"+zz+" ,"+gdjz+","+yxjz+","+yz+","+knw+","+mb+","+xf+","+ey+"  ";
				
				
				
				
				
				
				BigDecimal zzBase =  BigDecimal.ZERO;
				BigDecimal gdjzBase = BigDecimal.ZERO;
				BigDecimal yxjzBase = BigDecimal.ZERO;
				BigDecimal yzBase = BigDecimal.ZERO;
				BigDecimal knwBase = BigDecimal.ZERO; 
				BigDecimal xfBase = BigDecimal.ZERO;
				BigDecimal eyBase = BigDecimal.ZERO;
				
				
				
				if(calType != null  && calType.equals("zskc")){
					
					HashMap<String,BigDecimal> allMap =  setJingWork( zz, zzcb, gdjz, gdjzcb, yxjz, yxjzcb, yz, yzcb, knw, knwcb, xf, xfcb, ey, eycb,  biliMap, calType);
					String nextPeriod  = getNextPeriod( periodnum);
					if(DoctorCostsFactory.getLocalInstance(ctx).exists("where BusinessDate='"+nextPeriod+"' and city = '"+cityId+"' and EmpNumber='"+empNum+"' and CostType='yk' ")){
						DoctorCostsFactory.getLocalInstance(ctx).delete("where BusinessDate='"+nextPeriod+"' and city = '"+cityId+"' and EmpNumber='"+empNum+"' and CostType='yk' ");	
					}
					
					DoctorCostsInfo doctorCostsInfo =new DoctorCostsInfo();
					doctorCostsInfo.setBusinessDate(nextPeriod);
					CtrlUnitInfo ctrlUnitInfo = new CtrlUnitInfo();
					ctrlUnitInfo.setId(BOSUuid.read(cityId));
					doctorCostsInfo.setCity(ctrlUnitInfo);
					doctorCostsInfo.setCityNumber(cityNumber);
					doctorCostsInfo.setEmpNumber(empNum);
					doctorCostsInfo.setEmpName(tempMap.get("empName").toString());
					doctorCostsInfo.setCostType(costType.yk);
					
					if(allMap.get("all").compareTo(BigDecimal.ZERO) > 0){
						if(null != allMap.get("zz")){
							zzBase = allMap.get("zz");
						}
						if(null != allMap.get("gdjz")){
							gdjzBase = allMap.get("gdjz");
						}
						if(null != allMap.get("yxjz")){
							yxjzBase = allMap.get("yxjz");
						}
						if(null != allMap.get("yz")){
							yzBase = allMap.get("yz");
						}
						if(null != allMap.get("knw")){
							knwBase = allMap.get("knw");
						}
						if(null != allMap.get("xf")){
							xfBase = allMap.get("xf");
						}
						if(null != allMap.get("ey")){
							eyBase = allMap.get("ey");
						}
					}else if(allMap.get("all").compareTo(BigDecimal.ZERO) <0 ){//如果是负数  说明没有正数
						
						if(null != allMap.get("zz")){
							zzBase = allMap.get("zz").compareTo(BigDecimal.ZERO)<0?BigDecimal.ZERO:allMap.get("zz");
							doctorCostsInfo.setZbCost(allMap.get("zz").negate());
						}
						if(null != allMap.get("gdjz")){
							gdjzBase = allMap.get("gdjz").compareTo(BigDecimal.ZERO)<0?BigDecimal.ZERO:allMap.get("gdjz");
							doctorCostsInfo.setGdCost(allMap.get("gdjz").negate());
						}
						if(null != allMap.get("yxjz")){
							yxjzBase = allMap.get("yxjz").compareTo(BigDecimal.ZERO)<0?BigDecimal.ZERO:allMap.get("yxjz");
							doctorCostsInfo.setYxCost(allMap.get("yxjz").negate());
						}
						if(null != allMap.get("yz")){
							yzBase = allMap.get("yz").compareTo(BigDecimal.ZERO)<0?BigDecimal.ZERO:allMap.get("yz");
							doctorCostsInfo.setZbCost(allMap.get("yz").negate());
						}
						if(null != allMap.get("knw")){
							knwBase = allMap.get("knw").compareTo(BigDecimal.ZERO)<0?BigDecimal.ZERO:allMap.get("knw");
							doctorCostsInfo.setKnCost(allMap.get("knw").negate());
						}
						if(null != allMap.get("xf")){
							xfBase = allMap.get("xf").compareTo(BigDecimal.ZERO)<0?BigDecimal.ZERO:allMap.get("xf");
							doctorCostsInfo.setXfCost(allMap.get("xf").negate());
						}
						if(null != allMap.get("ey")){
							eyBase = allMap.get("ey").compareTo(BigDecimal.ZERO)<0?BigDecimal.ZERO:allMap.get("ey");
							doctorCostsInfo.setEyCost(allMap.get("ey").negate());
						}
						
						DoctorCostsFactory.getLocalInstance(ctx).save(doctorCostsInfo);
					}
					
				}else{//不进行延扣
					/*boolean flagCost = false;
					if(null != allMap.get("zz")  ){
						if(allMap.get("zz").compareTo(BigDecimal.ZERO) > 0 ){
							zzBase = allMap.get("zz");
						}else{
							flagCost = true;
							doctorCostsInfo.setZbCost(allMap.get("zz").negate());
						} 
					} 
					if(null != allMap.get("gdjz") ){
						if(allMap.get("gdjz").compareTo(BigDecimal.ZERO) > 0 ){
							gdjzBase = allMap.get("gdjz");
						}else{
							flagCost = true;
							doctorCostsInfo.setGdCost(allMap.get("gdjz").negate());
						} 
					}
					if(null != allMap.get("yxjz") ){
						if(allMap.get("yxjz").compareTo(BigDecimal.ZERO) > 0 ){
							yxjzBase = allMap.get("yxjz");
						}else{
							flagCost = true;
							doctorCostsInfo.setYxCost(allMap.get("yxjz").negate());
						}
					}
					if(null != allMap.get("yz")   ){
						if(allMap.get("yz").compareTo(BigDecimal.ZERO) > 0){
							yzBase = allMap.get("yz");
						}else{
							flagCost = true;
							doctorCostsInfo.setYxCost(allMap.get("yz").negate());
						}
						
					}
					if(null != allMap.get("knw") ){
						if( allMap.get("knw").compareTo(BigDecimal.ZERO) > 0 ){
							knwBase = allMap.get("knw");
						}else{
							flagCost = true;
							doctorCostsInfo.setKnCost(allMap.get("knw").negate());
						}
						
					}
					if(null != allMap.get("xf")  ){
						if(allMap.get("xf").compareTo(BigDecimal.ZERO) > 0){
							xfBase = allMap.get("xf");
						}else{
							flagCost = true;
							doctorCostsInfo.setXfCost(allMap.get("xf").negate());
						}
						
					}
					if(null != allMap.get("ey") ){
						if(allMap.get("ey").compareTo(BigDecimal.ZERO) > 0 ){
							eyBase = allMap.get("ey");
						}else{
							flagCost = true;
							doctorCostsInfo.setEyCost(allMap.get("ey").negate());
						}  
					}
					if(flagCost){
						DoctorCostsFactory.getLocalInstance(ctx).save(doctorCostsInfo);
					}*/
					zzBase = zz.subtract(zzcb).compareTo(BigDecimal.ZERO)<0?BigDecimal.ZERO:zz.subtract(zzcb);
					gdjzBase = gdjz.subtract(gdjzcb).compareTo(BigDecimal.ZERO)<0?BigDecimal.ZERO:gdjz.subtract(gdjzcb);
					yxjzBase = yxjz.subtract(yxjzcb).compareTo(BigDecimal.ZERO)<0?BigDecimal.ZERO:yxjz.subtract(yxjzcb);
					yzBase = yz.subtract(yzcb).compareTo(BigDecimal.ZERO)<0?BigDecimal.ZERO:yz.subtract(yzcb);
					knwBase = knw.subtract(knwcb).compareTo(BigDecimal.ZERO)<0?BigDecimal.ZERO:knw.subtract(knwcb);
					//BigDecimal mbBase = mb.subtract(mbcb).compareTo(BigDecimal.ZERO)<0?BigDecimal.ZERO:mb.subtract(mbcb);
					xfBase = xf.subtract(xfcb).compareTo(BigDecimal.ZERO)<0?BigDecimal.ZERO:xf.subtract(xfcb);
					eyBase = ey.subtract(eycb).compareTo(BigDecimal.ZERO)<0?BigDecimal.ZERO:ey.subtract(eycb);
					
				} 
				
				/*BigDecimal zzBase = zz.subtract(zzcb).compareTo(BigDecimal.ZERO)<0?BigDecimal.ZERO:zz.subtract(zzcb);
				BigDecimal gdjzBase = gdjz.subtract(gdjzcb).compareTo(BigDecimal.ZERO)<0?BigDecimal.ZERO:gdjz.subtract(gdjzcb);
				BigDecimal yxjzBase = yxjz.subtract(yxjzcb).compareTo(BigDecimal.ZERO)<0?BigDecimal.ZERO:yxjz.subtract(yxjzcb);
				BigDecimal yzBase = yz.subtract(yzcb).compareTo(BigDecimal.ZERO)<0?BigDecimal.ZERO:yz.subtract(yzcb);
				BigDecimal knwBase = knw.subtract(knwcb).compareTo(BigDecimal.ZERO)<0?BigDecimal.ZERO:knw.subtract(knwcb);
				//BigDecimal mbBase = mb.subtract(mbcb).compareTo(BigDecimal.ZERO)<0?BigDecimal.ZERO:mb.subtract(mbcb);
				BigDecimal xfBase = xf.subtract(xfcb).compareTo(BigDecimal.ZERO)<0?BigDecimal.ZERO:xf.subtract(xfcb);
				BigDecimal eyBase = ey.subtract(eycb).compareTo(BigDecimal.ZERO)<0?BigDecimal.ZERO:ey.subtract(eycb);*/
				
				 
				BigDecimal allBase = zzBase.add(gdjzBase).add(yxjzBase).add(yzBase).add(knwBase).add(xfBase).add(eyBase);
				if(allBase.compareTo(BigDecimal.ZERO) <=0 ){
					allBase = new BigDecimal("1");
				}
				/*BigDecimal zzMoney = zz.subtract(zzcb).subtract(docBase.multiply(zzBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP))).compareTo(BigDecimal.ZERO) > 0 ? zz.subtract(zzcb).subtract(docBase.multiply(zzBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP))).multiply(zzbi):BigDecimal.ZERO;
				BigDecimal gdjzMoney = gdjz.subtract(gdjzcb).subtract(docBase.multiply(gdjzBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP))).compareTo(BigDecimal.ZERO) > 0 ? gdjz.subtract(gdjzcb).subtract(docBase.multiply(gdjzBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP))).multiply(gdjzbi):BigDecimal.ZERO;
				BigDecimal yxjzMoney = yxjz.subtract(yxjzcb).subtract(docBase.multiply(yxjzBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP))).compareTo(BigDecimal.ZERO) > 0 ?yxjz.subtract(yxjzcb).subtract(docBase.multiply(yxjzBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP))).multiply(yxjzbi):BigDecimal.ZERO;
				BigDecimal yzMoney = yz.subtract(yzcb).subtract(docBase.multiply(yzBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP))).compareTo(BigDecimal.ZERO) > 0 ? yz.subtract(yzcb).subtract(docBase.multiply(yzBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP))).multiply(yzbi):BigDecimal.ZERO;
				BigDecimal knwMoney = knw.subtract(knwcb).subtract(docBase.multiply(knwBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP))).compareTo(BigDecimal.ZERO) > 0 ? knw.subtract(knwcb).subtract(docBase.multiply(knwBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP))).multiply(knwbi):BigDecimal.ZERO;
				//BigDecimal mbMoney = mb.subtract(mbcb).subtract(docBase.multiply(mbBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP))).compareTo(BigDecimal.ZERO) > 0 ? mb.subtract(mbcb).subtract(docBase.multiply(mbBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP))).multiply(mbbi):BigDecimal.ZERO;
				BigDecimal mbMoney = mb.subtract(mbcb).compareTo(BigDecimal.ZERO) > 0 ? mb.subtract(mbcb).multiply(mbbi):mb.subtract(mbcb).multiply(mbbi);
				BigDecimal xfMoney = xf.subtract(xfcb).subtract(docBase.multiply(xfBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP))).compareTo(BigDecimal.ZERO) > 0 ? xf.subtract(xfcb).subtract(docBase.multiply(xfBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP))).multiply(xfbi):BigDecimal.ZERO;
				BigDecimal eyMoney = ey.subtract(eycb).subtract(docBase.multiply(eyBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP))).compareTo(BigDecimal.ZERO) > 0 ? ey.subtract(eycb).subtract(docBase.multiply(eyBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP))).multiply(eybi):BigDecimal.ZERO;
				*/
				BigDecimal zzMoney = BigDecimal.ZERO;
				BigDecimal gdjzMoney = BigDecimal.ZERO;
				BigDecimal yxjzMoney = BigDecimal.ZERO;
				BigDecimal yzMoney = BigDecimal.ZERO;
				BigDecimal knwMoney = BigDecimal.ZERO;
				BigDecimal mbMoney = BigDecimal.ZERO;
				BigDecimal xfMoney = BigDecimal.ZERO;
				BigDecimal eyMoney = BigDecimal.ZERO;
				if(allBase.compareTo(BigDecimal.ZERO) <=0 ){
					
				}else{
					zzMoney = zzBase.subtract(docBase.multiply(zzBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP))).compareTo(BigDecimal.ZERO) > 0 ? zzBase.subtract(docBase.multiply(zzBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP))).multiply(zzbi):BigDecimal.ZERO;
					gdjzMoney = gdjzBase.subtract(docBase.multiply(gdjzBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP))).compareTo(BigDecimal.ZERO) > 0 ? gdjzBase.subtract(docBase.multiply(gdjzBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP))).multiply(gdjzbi):BigDecimal.ZERO;
					yxjzMoney = yxjzBase.subtract(docBase.multiply(yxjzBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP))).compareTo(BigDecimal.ZERO) > 0 ? yxjzBase.subtract(docBase.multiply(yxjzBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP))).multiply(yxjzbi):BigDecimal.ZERO;
					yzMoney = yzBase.subtract(docBase.multiply(yzBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP))).compareTo(BigDecimal.ZERO) > 0 ? yzBase.subtract(docBase.multiply(yzBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP))).multiply(yzbi):BigDecimal.ZERO;
					knwMoney = knwBase.subtract(docBase.multiply(knwBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP))).compareTo(BigDecimal.ZERO) > 0 ? knwBase.subtract(docBase.multiply(knwBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP))).multiply(knwbi):BigDecimal.ZERO;
					//BigDecimal mbMoney = mb.subtract(mbcb).subtract(docBase.multiply(mbBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP))).compareTo(BigDecimal.ZERO) > 0 ? mb.subtract(mbcb).subtract(docBase.multiply(mbBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP))).multiply(mbbi):BigDecimal.ZERO;
					
					xfMoney = xfBase.subtract(docBase.multiply(xfBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP))).compareTo(BigDecimal.ZERO) > 0 ? xfBase.subtract(docBase.multiply(xfBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP))).multiply(xfbi):BigDecimal.ZERO;
					eyMoney = eyBase.subtract(docBase.multiply(eyBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP))).compareTo(BigDecimal.ZERO) > 0 ? eyBase.subtract(docBase.multiply(eyBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP))).multiply(eybi):BigDecimal.ZERO;
					
				}
				mbMoney = mb.subtract(mbcb).compareTo(BigDecimal.ZERO) > 0 ? mb.subtract(mbcb).multiply(mbbi):mb.subtract(mbcb).multiply(mbbi);
				//money = zzMoney.add(gdjzMoney).add(yxjzMoney).add(yzMoney).add(knwMoney).add(mbMoney).add(xfMoney).add(eyMoney).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
				money = zzMoney.add(gdjzMoney).add(yxjzMoney).add(yzMoney).add(knwMoney).add(xfMoney).add(eyMoney).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
				
				
				insertSql += ",cfsumachieve, CFZZmoney, CFGDJZmoney, CFYXJZmoney, CFYZmoney, CFKNWmoney, CFMBmoney, CFXFmoney, CFEYmoney ";
				insertValueSql += " ,"+sumAchieve+", "+zzMoney+" ,"+gdjzMoney+","+yxjzMoney+" " +
					" ,"+yzMoney+" ,"+knwMoney+" ,"+mbMoney+" "+
					" ,"+xfMoney+" ,"+eyMoney+" ";
				docMap.put("EXISTS", "NO");
				docMap.put("JIANGJIN", money+"");
				docMap.put("mbMoney", mbMoney+"");
				docMap.put("COST", costAll.toString());
				
					  
			}
			//兼职医生
			if((null == tempMap) || (null == tempMap.get(empNum+"_JZDOC"))){
				
			}else{
				
				//普通兼职医生
				if( null != tempMap.get(empNum+"_JIANZHIDOC")  ){
					HashMap map = new HashMap(); 
					map = (HashMap) tempMap.get(empNum+"_JIANZHIDOC");
					
					docMap.put("postType", "JZYS");
					
					
					zzbi = new BigDecimal(map.get("CFZZPRO").toString());
					gdjzbi = new BigDecimal(map.get("CFGDJZPRO").toString());
					yxjzbi = new BigDecimal(map.get("CFYXJZPRO").toString());
					yzbi = new BigDecimal(map.get("CFYZPRO").toString());//?
					knwbi = new BigDecimal(map.get("CFKNWPRO").toString());
					mbbi = new BigDecimal(map.get("CFMBPRO").toString());
					xfbi = new BigDecimal(map.get("CFXFPRO").toString());
					eybi = new BigDecimal(map.get("CFEYPRO").toString()); 
					
					biliMap.put("zz",zzbi );
					biliMap.put("gdjz",gdjzbi );
					biliMap.put("yxjz",yxjzbi );
					biliMap.put("yz",yzbi );
					biliMap.put("knw",knwbi );
					biliMap.put("mb",mbbi );
					biliMap.put("xf",xfbi );
					biliMap.put("ey",eybi );
					biliMap.put("zj",zjbl );
					
					//兼职医生生成两条 自带和非自带 

					// 查看有没有此医生的自带业绩
					
					BigDecimal bymoney = BigDecimal.ZERO;
					String haveZidaisql = " /*dialect*/ select count(1) as thisnum from  CT_PAY_AchieveDetailTem where CFSecSource = '自带'  and  CFRecDotNumber ='"+empNum+"' and CFCityNumber='"+cityNumber+"'and  to_char(fbizdate,'YYYYMM') ='"+periodnum+"'";
					
					IRowSet haveZidairs = com.kingdee.eas.custom.util.DBUtil.executeQuery(ctx,haveZidaisql.toString());
					if(haveZidairs!=null && haveZidairs.size() > 0){
						 while(haveZidairs.next()){	
							 int num= haveZidairs.getInt("THISNUM");
							 if(num > 0){
								 bymoney = docZiDai(ctx ,map,empNum,  cityNumber, periodnum,  clinicNumber ,tempMap,cityId);
							 }
						 }
						 
					}  
					BigDecimal zj = new BigDecimal(map.get("CFZJPRO").toString()); 
					String empName = map.get("CFDOCNAME").toString();
					

					StringBuffer sqlImportYJ = new StringBuffer(); 
					sqlImportYJ = getYeJiImpSql( empNum,  cityNumber, periodnum, sqlImportYJ, cityId,zjbl);
				  	System.out.println("--"+sqlImportYJ);
				  	IRowSet yjImprs = com.kingdee.eas.custom.util.DBUtil.executeQuery(ctx,sqlImportYJ.toString());
				  	if(yjImprs!=null && yjImprs.size() > 0){ 
					  	while(yjImprs.next()){	
					  		zz = zz.add(new BigDecimal(yjImprs.getString("ZZ"))); 
					  		gdjz= gdjz.add(new BigDecimal(yjImprs.getString("GDJZ"))); 
					  		yxjz= yxjz.add(new BigDecimal(yjImprs.getString("YXJZ"))); 
					  		yz= yz.add(new BigDecimal(yjImprs.getString("YZ"))); 
					  		knw = knw.add(new BigDecimal(yjImprs.getString("KNW")));
					  		mb= mb.add(new BigDecimal(yjImprs.getString("MB"))); 
					  		xf= xf.add(new BigDecimal(yjImprs.getString("XF")));  
					  		ey= ey.add(new BigDecimal(yjImprs.getString("EY")));  
					  		
					  		imandxtinsertsql +=  ", CFIMZZACHIEVE , CFIMGDJZACHIEVE , cfIMyxjzachieve, CFIMyzAchieve , cfIMknwachieve , cfIMmbachieve , cfIMxfachieve, cfIMeyachieve ";
							imandxtinsertValueSql +=" ,"+new BigDecimal(yjImprs.getString("ZZ"))+" ,"+new BigDecimal(yjImprs.getString("GDJZ"))+","+new BigDecimal(yjImprs.getString("YXJZ"))
							+","+new BigDecimal(yjImprs.getString("YZ"))+","+new BigDecimal(yjImprs.getString("KNW"))+","+new BigDecimal(yjImprs.getString("MB"))+","+new BigDecimal(yjImprs.getString("XF"))+"," +
									""+new BigDecimal(yjImprs.getString("EY"))+"  ";
						}
					}
				  	
				  	//imandxtinsertsql +=  ", CFIMZZACHIEVE , CFIMGDJZACHIEVE , cfIMyxjzachieve, CFIMyzAchieve , cfIMknwachieve , cfIMmbachieve , cfIMxfachieve, cfIMeyachieve ";
					//imandxtinsertValueSql +=" ,"+zz+" ,"+gdjz+","+yxjz+","+yz+","+knw+","+mb+","+xf+","+ey+"  ";
					
					//再计算非自带患者的
					StringBuffer sqlFZD = new StringBuffer(); 
					sqlFZD = getFeiZiDaiSql( empNum,  cityNumber, periodnum, empName,zj,cityId);
					System.out.println(sqlFZD);
					IRowSet fzdrs = com.kingdee.eas.custom.util.DBUtil.executeQuery(ctx,sqlFZD.toString());
					if(fzdrs!=null && fzdrs.size() > 0){
						  while(fzdrs.next()){	 
							  if("zz".equals(fzdrs.getString("TYPE"))){//种植
								  zz =zz.add(new BigDecimal(fzdrs.getString("SUMM"))); 
								  insertSql +=  ", CFZZACHIEVE ";
								  insertValueSql +=" ,"+zz;
								  
								  imandxtinsertsql +=  ", CFXTZZACHIEVE  ";
								  imandxtinsertValueSql +=" ,"+new BigDecimal(fzdrs.getString("SUMM"))+" ";
									
							  }else if("gdjz".equals(fzdrs.getString("TYPE"))){//固定矫正 ？
								  gdjz=gdjz.add(new BigDecimal(fzdrs.getString("SUMM"))); 
								  insertSql +=  ", CFGDJZACHIEVE ";
								  insertValueSql+=" ,"+gdjz;
								  
								  imandxtinsertsql +=  "  , CFXTGDJZACHIEVE  ";
									imandxtinsertValueSql +="   ,"+new BigDecimal(fzdrs.getString("SUMM"))+" ";
							  }else if("yxjz".equals(fzdrs.getString("TYPE"))){//隐形矫正
								  yxjz=yxjz.add(new BigDecimal(fzdrs.getString("SUMM"))); 
								  insertSql +=  ", cfyxjzachieve ";
								  insertValueSql += " ,"+yxjz;
								  
								  imandxtinsertsql +=  " , cfXTyxjzachieve ";
								  imandxtinsertValueSql +="  ,"+new BigDecimal(fzdrs.getString("SUMM"))+" ";
							  }else if("yz".equals(fzdrs.getString("TYPE"))){//牙周 ？
								  yz=yz.add(new BigDecimal(fzdrs.getString("SUMM"))); 
								  insertSql +=  ", CFZyAchieve ";
								  insertValueSql += " ,"+yz;
								  
								  imandxtinsertsql +=  " , CFXTyzAchieve  ";
									imandxtinsertValueSql +=" ,"+new BigDecimal(fzdrs.getString("SUMM"))+"  ";
							  }else if("knw".equals(fzdrs.getString("TYPE"))){//口内外 ？
								  knw =knw.add(new BigDecimal(fzdrs.getString("SUMM")));
								  insertSql +=  ", cfknwachieve ";
								  insertValueSql += " ,"+knw;
								  
								  imandxtinsertsql +=  "  , cfXTknwachieve   ";
								  imandxtinsertValueSql +="  ,"+new BigDecimal(fzdrs.getString("SUMM"))+"  ";
							  }else if("mb".equals(fzdrs.getString("TYPE"))){//美白
								  mb=mb.add(new BigDecimal(fzdrs.getString("SUMM"))); 
								  insertSql +=  ", cfmbachieve ";
								  insertValueSql += " ,"+mb;
								  
								  imandxtinsertsql +=  "  , cfXTmbachieve ";
								 imandxtinsertValueSql +="  ,"+new BigDecimal(fzdrs.getString("SUMM"))+"   ";
							  }else if("xf".equals(fzdrs.getString("TYPE"))){//修复
								  xf=xf.add(new BigDecimal(fzdrs.getString("SUMM"))); 
								  insertSql +=  ", cfxfachieve ";
								  insertValueSql += " ,"+xf;
								  
								  imandxtinsertsql +=  " , cfXTxfachieve ";
								  imandxtinsertValueSql +=" ,"+new BigDecimal(fzdrs.getString("SUMM"))+"  ";
							  }else if("ey".equals(fzdrs.getString("TYPE"))){//儿牙
								  ey=ey.add(new BigDecimal(fzdrs.getString("SUMM"))); 
								  insertSql +=  ", cfeyachieve ";
								  insertValueSql += " ,"+ey;
								  
								  imandxtinsertsql +=  " , cfXTeyachieve ";
								  imandxtinsertValueSql +=" ,"+new BigDecimal(fzdrs.getString("SUMM"))+"  ";
							  } 
						  }
					}
					//yxjz = yxjz.add(new BigDecimal("21264"));
					//gdjz = gdjz.add(new BigDecimal("4239.79"));
					//获得 导入的成本
					StringBuffer sqlImportCB = new StringBuffer(); 
					sqlImportCB = getImportChengBenSql( "'"+empNum+"'",  cityId, periodnum, sqlImportCB);
					IRowSet imporytbrs = com.kingdee.eas.custom.util.DBUtil.executeQuery(ctx,sqlImportCB.toString());
					if(imporytbrs!=null && imporytbrs.size() > 0){
						while(imporytbrs.next()){	
							  if("zz".equals(imporytbrs.getString("TYPE"))){//种植
								  zzcb =new BigDecimal(imporytbrs.getString("SUMM")); 
								  costAll = costAll.add(zzcb);
								   
								  clinicCostSumInfo.setImzzCost(zzcb);
							  }else if("gdjz".equals(imporytbrs.getString("TYPE"))){//固定矫正
								  gdjzcb=new BigDecimal(imporytbrs.getString("SUMM")); 
								  costAll = costAll.add(gdjzcb);
								   
								  clinicCostSumInfo.setImgdjzCost(gdjzcb);
							  }else if("yxjz".equals(imporytbrs.getString("TYPE"))){//隐形矫正
								  yxjzcb=new BigDecimal(imporytbrs.getString("SUMM")); 
								  costAll = costAll.add(yxjzcb);
								   
								  clinicCostSumInfo.setImyxjzCost(yxjzcb);
							  }else if("yz".equals(imporytbrs.getString("TYPE"))){//牙周
								  yzcb=new BigDecimal(imporytbrs.getString("SUMM")); 
								  costAll = costAll.add(yzcb);
								   
								  clinicCostSumInfo.setImyzCost(yzcb);
							  }else if("knw".equals(imporytbrs.getString("TYPE"))){//口内外
								  knwcb =new BigDecimal(imporytbrs.getString("SUMM"));
								  costAll = costAll.add(knwcb);
								   
								  clinicCostSumInfo.setImknwCost(knwcb);
							  }else if("mb".equals(imporytbrs.getString("TYPE"))){//美白
								  mbcb=new BigDecimal(imporytbrs.getString("SUMM")); 
								  costAll = costAll.add(mbcb); 
								  
								  clinicCostSumInfo.setImmbCost(mbcb);
							  }else if("xf".equals(imporytbrs.getString("TYPE"))){//修复
								  xfcb=new BigDecimal(imporytbrs.getString("SUMM")); 
								  costAll = costAll.add(xfcb);
								   
								  clinicCostSumInfo.setImxfCost(xfcb);
							  }else if("ey".equals(imporytbrs.getString("TYPE"))){//儿牙
								  eycb=new BigDecimal(imporytbrs.getString("SUMM")); 
								  costAll = costAll.add(eycb);
								  
								  clinicCostSumInfo.setImeyCost(eycb);
								   
							  }  
						  }
					} 
					
					//获得 护士调整的成本
					StringBuffer sqlHushiCB = new StringBuffer(); 
					sqlHushiCB = getHushiChengBenSql( "'"+empNum+"'",  cityNumber, periodnum, sqlHushiCB,"");
					IRowSet hushiCBrs = com.kingdee.eas.custom.util.DBUtil.executeQuery(ctx,sqlHushiCB.toString());
					if(hushiCBrs!=null && hushiCBrs.size() > 0){
						while(hushiCBrs.next()){	
							  if("zz".equals(hushiCBrs.getString("TYPE"))){//种植
								  zzcb = zzcb.add(new BigDecimal(hushiCBrs.getString("SUMM"))); 
								  costAll = costAll.add(new BigDecimal(hushiCBrs.getString("SUMM"))); 
								  clinicCostSumInfo.setUpzzCost(new BigDecimal(hushiCBrs.getString("SUMM")));
							  }else if("gdjz".equals(hushiCBrs.getString("TYPE"))){//固定矫正
								  gdjzcb = gdjzcb.add(new BigDecimal(hushiCBrs.getString("SUMM"))); 
								  costAll = costAll.add(new BigDecimal(hushiCBrs.getString("SUMM")));
								    
								  clinicCostSumInfo.setUpgdjzCost(new BigDecimal(hushiCBrs.getString("SUMM")));
							  }else if("yxjz".equals(hushiCBrs.getString("TYPE"))){//隐形矫正
								  yxjzcb = yxjzcb.add(new BigDecimal(hushiCBrs.getString("SUMM"))); 
								  costAll = costAll.add(new BigDecimal(hushiCBrs.getString("SUMM"))); 
								  
								  clinicCostSumInfo.setUpyxjzCost(new BigDecimal(hushiCBrs.getString("SUMM")));
							  }else if("yz".equals(hushiCBrs.getString("TYPE"))){//牙周
								  yzcb = yzcb.add(new BigDecimal(hushiCBrs.getString("SUMM"))); 
								  costAll = costAll.add(new BigDecimal(hushiCBrs.getString("SUMM"))); 
								  
								  clinicCostSumInfo.setUpyzCost(new BigDecimal(hushiCBrs.getString("SUMM")));
							  }else if("knw".equals(hushiCBrs.getString("TYPE"))){//口内外
								  knwcb = knwcb.add(new BigDecimal(hushiCBrs.getString("SUMM")));
								  costAll = costAll.add(new BigDecimal(hushiCBrs.getString("SUMM"))); 
								  
								  clinicCostSumInfo.setUpknwCost(new BigDecimal(hushiCBrs.getString("SUMM")));
							  }else if("mb".equals(hushiCBrs.getString("TYPE"))){//美白
								  mbcb = mbcb.add(new BigDecimal(hushiCBrs.getString("SUMM"))); 
								  costAll = costAll.add(new BigDecimal(hushiCBrs.getString("SUMM")));  
								  
								  clinicCostSumInfo.setUpmbCost(new BigDecimal(hushiCBrs.getString("SUMM")));
							  }else if("xf".equals(hushiCBrs.getString("TYPE"))){//修复
								  xfcb = xfcb.add(new BigDecimal(hushiCBrs.getString("SUMM"))); 
								  costAll = costAll.add(new BigDecimal(hushiCBrs.getString("SUMM"))); 
								  
								  clinicCostSumInfo.setUpxfCost(new BigDecimal(hushiCBrs.getString("SUMM")));
							  }else if("ey".equals(hushiCBrs.getString("TYPE"))){//儿牙
								  eycb = eycb.add(new BigDecimal(hushiCBrs.getString("SUMM"))); 
								  costAll = costAll.add(new BigDecimal(hushiCBrs.getString("SUMM")));  
								  
								  clinicCostSumInfo.setUpeyCost(new BigDecimal(hushiCBrs.getString("SUMM")));
							  }   
						  }
					} 
					
					//获得销售出库的成本
					StringBuffer sqlCB = new StringBuffer();
					sqlCB = getChengBenSql( "'"+empNum+"'",  cityNumber, periodnum, sqlCB,"");
					IRowSet cbrs = com.kingdee.eas.custom.util.DBUtil.executeQuery(ctx,sqlCB.toString());
					if(cbrs!=null && cbrs.size() > 0){
						 while(cbrs.next()){	
							  if("zz".equals(cbrs.getString("TYPE"))){//种植
								  zzcb = zzcb.add(new BigDecimal(cbrs.getString("SUMM"))); 
								  costAll = costAll.add(new BigDecimal(cbrs.getString("SUMM")));
								  
								  insertSql +=  ", cfzzcost ";
								  insertValueSql += " ,"+zzcb;

								  clinicCostSumInfo.setZzCost(new BigDecimal(cbrs.getString("SUMM")));
							  }else if("gdjz".equals(cbrs.getString("TYPE"))){//固定矫正
								  gdjzcb = gdjzcb.add(new BigDecimal(cbrs.getString("SUMM"))); 
								  costAll = costAll.add(new BigDecimal(cbrs.getString("SUMM")));
								  
								  insertSql +=  ", cfgdjzcost ";
								  insertValueSql += " ,"+gdjzcb;
								  
								  clinicCostSumInfo.setGdjzCost(new BigDecimal(cbrs.getString("SUMM")));
							  }else if("yxjz".equals(cbrs.getString("TYPE"))){//隐形矫正
								  yxjzcb = yxjzcb.add(new BigDecimal(cbrs.getString("SUMM"))); 
								  costAll = costAll.add(new BigDecimal(cbrs.getString("SUMM")));
								  
								  insertSql +=  ", cfyxjzcost ";
								  insertValueSql += " ,"+yxjzcb;
								  
								  clinicCostSumInfo.setYxjzCost(new BigDecimal(cbrs.getString("SUMM")));
							  }else if("yz".equals(cbrs.getString("TYPE"))){//牙周
								  yzcb = yzcb.add(new BigDecimal(cbrs.getString("SUMM"))); 
								  costAll = costAll.add(new BigDecimal(cbrs.getString("SUMM")));
								  
								  insertSql +=  ", cfyzcost ";
								  insertValueSql += " ,"+yzcb;
								  
								  clinicCostSumInfo.setYzCost(new BigDecimal(cbrs.getString("SUMM")));
							  }else if("knw".equals(cbrs.getString("TYPE"))){//口内外
								  knwcb = knwcb.add(new BigDecimal(cbrs.getString("SUMM")));
								  costAll = costAll.add(new BigDecimal(cbrs.getString("SUMM")));
								  
								  insertSql +=  ", cfknwcost ";
								  insertValueSql += " ,"+knwcb;
								  
								  clinicCostSumInfo.setKnwCost(new BigDecimal(cbrs.getString("SUMM")));
							  }else if("mb".equals(cbrs.getString("TYPE"))){//美白
								  mbcb = mbcb.add(new BigDecimal(cbrs.getString("SUMM"))); 
								  costAll = costAll.add(new BigDecimal(cbrs.getString("SUMM")));
								  insertSql +=  ", cfmbcost ";
								  insertValueSql += " ,"+mbcb;
								  
								  clinicCostSumInfo.setMbCost(new BigDecimal(cbrs.getString("SUMM")));
							  }else if("xf".equals(cbrs.getString("TYPE"))){//修复
								  xfcb = xfcb.add(new BigDecimal(cbrs.getString("SUMM"))); 
								  costAll = costAll.add(new BigDecimal(cbrs.getString("SUMM")));
								  
								  insertSql +=  ", cfxfcost ";
								  insertValueSql += " ,"+xfcb;
								  
								  clinicCostSumInfo.setXfCost(new BigDecimal(cbrs.getString("SUMM")));
							  }else if("ey".equals(cbrs.getString("TYPE"))){//儿牙
								  eycb = eycb.add(new BigDecimal(cbrs.getString("SUMM"))); 
								  costAll = costAll.add(new BigDecimal(cbrs.getString("SUMM")));
								  
								  insertSql +=  ", cfeycost ";
								  insertValueSql += " ,"+eycb;
								  
								  clinicCostSumInfo.setEyCost(new BigDecimal(cbrs.getString("SUMM")));
							  }   
						  }
						  
					}  
					clinicCostSumInfo.setAllgdjzCost(clinicCostSumInfo.getUpgdjzCost().add(clinicCostSumInfo.getGdjzCost()).add(clinicCostSumInfo.getImgdjzCost())); 
					clinicCostSumInfo.setAllzzCost(clinicCostSumInfo.getUpzzCost().add(clinicCostSumInfo.getZzCost()).add(clinicCostSumInfo.getImzzCost()));
					clinicCostSumInfo.setAllyxjzCost(clinicCostSumInfo.getUpyxjzCost().add(clinicCostSumInfo.getYxjzCost()).add(clinicCostSumInfo.getImyxjzCost()));
					clinicCostSumInfo.setAllyzCost(clinicCostSumInfo.getUpyzCost().add(clinicCostSumInfo.getYzCost()).add(clinicCostSumInfo.getImyzCost()));
					clinicCostSumInfo.setAllknwCost(clinicCostSumInfo.getUpknwCost().add(clinicCostSumInfo.getKnwCost()).add(clinicCostSumInfo.getImknwCost()));
					clinicCostSumInfo.setAllmbCost(clinicCostSumInfo.getUpmbCost().add(clinicCostSumInfo.getMbCost()).add(clinicCostSumInfo.getImmbCost()));
					clinicCostSumInfo.setAllxfCost(clinicCostSumInfo.getUpxfCost().add(clinicCostSumInfo.getXfCost()).add(clinicCostSumInfo.getImxfCost()));
					clinicCostSumInfo.setAlleyCost(clinicCostSumInfo.getUpeyCost().add(clinicCostSumInfo.getEyCost()).add(clinicCostSumInfo.getImeyCost()));
					
					
					
					BigDecimal zzBase =  BigDecimal.ZERO;
					BigDecimal gdjzBase = BigDecimal.ZERO;
					BigDecimal yxjzBase = BigDecimal.ZERO;
					BigDecimal yzBase = BigDecimal.ZERO;
					BigDecimal knwBase = BigDecimal.ZERO; 
					BigDecimal xfBase = BigDecimal.ZERO;
					BigDecimal eyBase = BigDecimal.ZERO;
					
					
					if(calType != null  && calType.equals("zskc")){
						
						//如果是折扣  
						//如果不是   相当于有正有负    但是总和  有可能大于0  也有可能小于0  里面还有正有负
						HashMap<String,BigDecimal> allMap =  setJingWork( zz, zzcb, gdjz, gdjzcb, yxjz, yxjzcb, yz, yzcb, knw, knwcb, xf, xfcb, ey, eycb,  biliMap, calType);
						String nextPeriod  = getNextPeriod( periodnum);
						
						if(DoctorCostsFactory.getLocalInstance(ctx).exists("where BusinessDate='"+nextPeriod+"' and city = '"+cityId+"' and EmpNumber='"+empNum+"' and CostType='yk' ")){
							DoctorCostsFactory.getLocalInstance(ctx).delete("where BusinessDate='"+nextPeriod+"' and city = '"+cityId+"' and EmpNumber='"+empNum+"' and CostType='yk' "); 
						}
						
						DoctorCostsInfo doctorCostsInfo =new DoctorCostsInfo();
						doctorCostsInfo.setBusinessDate(nextPeriod);
						CtrlUnitInfo ctrlUnitInfo = new CtrlUnitInfo();
						ctrlUnitInfo.setId(BOSUuid.read(cityId));
						doctorCostsInfo.setCity(ctrlUnitInfo);
						doctorCostsInfo.setCityNumber(cityNumber);
						doctorCostsInfo.setEmpNumber(empNum);
						doctorCostsInfo.setEmpName(tempMap.get("empName").toString());
						doctorCostsInfo.setCostType(costType.yk);
						
						if(allMap.get("all").compareTo(BigDecimal.ZERO) > 0){
							if(null != allMap.get("zz")){
								zzBase = allMap.get("zz");
							}
							if(null != allMap.get("gdjz")){
								gdjzBase = allMap.get("gdjz");
							}
							if(null != allMap.get("yxjz")){
								yxjzBase = allMap.get("yxjz");
							}
							if(null != allMap.get("yz")){
								yzBase = allMap.get("yz");
							}
							if(null != allMap.get("knw")){
								knwBase = allMap.get("knw");
							}
							if(null != allMap.get("xf")){
								xfBase = allMap.get("xf");
							}
							if(null != allMap.get("ey")){
								eyBase = allMap.get("ey");
							}
						}else if(allMap.get("all").compareTo(BigDecimal.ZERO) <0 ){//如果是负数  说明没有正数
							
							if(null != allMap.get("zz")){
								zzBase = allMap.get("zz").compareTo(BigDecimal.ZERO)<0?BigDecimal.ZERO:allMap.get("zz");
								doctorCostsInfo.setZbCost(allMap.get("zz").negate());
							}
							if(null != allMap.get("gdjz")){
								gdjzBase = allMap.get("gdjz").compareTo(BigDecimal.ZERO)<0?BigDecimal.ZERO:allMap.get("gdjz");
								doctorCostsInfo.setGdCost(allMap.get("gdjz").negate());
							}
							if(null != allMap.get("yxjz")){
								yxjzBase = allMap.get("yxjz").compareTo(BigDecimal.ZERO)<0?BigDecimal.ZERO:allMap.get("yxjz");
								doctorCostsInfo.setYxCost(allMap.get("yxjz").negate());
							}
							if(null != allMap.get("yz")){
								yzBase = allMap.get("yz").compareTo(BigDecimal.ZERO)<0?BigDecimal.ZERO:allMap.get("yz");
								doctorCostsInfo.setZbCost(allMap.get("yz").negate());
							}
							if(null != allMap.get("knw")){
								knwBase = allMap.get("knw").compareTo(BigDecimal.ZERO)<0?BigDecimal.ZERO:allMap.get("knw");
								doctorCostsInfo.setKnCost(allMap.get("knw").negate());
							}
							if(null != allMap.get("xf")){
								xfBase = allMap.get("xf").compareTo(BigDecimal.ZERO)<0?BigDecimal.ZERO:allMap.get("xf");
								doctorCostsInfo.setXfCost(allMap.get("xf").negate());
							}
							if(null != allMap.get("ey")){
								eyBase = allMap.get("ey").compareTo(BigDecimal.ZERO)<0?BigDecimal.ZERO:allMap.get("ey");
								doctorCostsInfo.setEyCost(allMap.get("ey").negate());
							}
							
							DoctorCostsFactory.getLocalInstance(ctx).save(doctorCostsInfo);
						}
						
					}else{//不进行延扣
						/*boolean flagCost = false;
						if(null != allMap.get("zz")  ){
							if(allMap.get("zz").compareTo(BigDecimal.ZERO) > 0 ){
								zzBase = allMap.get("zz");
							}else{
								flagCost = true;
								doctorCostsInfo.setZbCost(allMap.get("zz").negate());
							} 
						} 
						if(null != allMap.get("gdjz") ){
							if(allMap.get("gdjz").compareTo(BigDecimal.ZERO) > 0 ){
								gdjzBase = allMap.get("gdjz");
							}else{
								flagCost = true;
								doctorCostsInfo.setGdCost(allMap.get("gdjz").negate());
							} 
						}
						if(null != allMap.get("yxjz") ){
							if(allMap.get("yxjz").compareTo(BigDecimal.ZERO) > 0 ){
								yxjzBase = allMap.get("yxjz");
							}else{
								flagCost = true;
								doctorCostsInfo.setYxCost(allMap.get("yxjz").negate());
							}
						}
						if(null != allMap.get("yz")   ){
							if(allMap.get("yz").compareTo(BigDecimal.ZERO) > 0){
								yzBase = allMap.get("yz");
							}else{
								flagCost = true;
								doctorCostsInfo.setYxCost(allMap.get("yz").negate());
							}
							
						}
						if(null != allMap.get("knw") ){
							if( allMap.get("knw").compareTo(BigDecimal.ZERO) > 0 ){
								knwBase = allMap.get("knw");
							}else{
								flagCost = true;
								doctorCostsInfo.setKnCost(allMap.get("knw").negate());
							}
							
						}
						if(null != allMap.get("xf")  ){
							if(allMap.get("xf").compareTo(BigDecimal.ZERO) > 0){
								xfBase = allMap.get("xf");
							}else{
								flagCost = true;
								doctorCostsInfo.setXfCost(allMap.get("xf").negate());
							}
							
						}
						if(null != allMap.get("ey") ){
							if(allMap.get("ey").compareTo(BigDecimal.ZERO) > 0 ){
								eyBase = allMap.get("ey");
							}else{
								flagCost = true;
								doctorCostsInfo.setEyCost(allMap.get("ey").negate());
							}  
						}
						if(flagCost){
							DoctorCostsFactory.getLocalInstance(ctx).save(doctorCostsInfo);
						}*/
						zzBase = zz.subtract(zzcb).compareTo(BigDecimal.ZERO)<0?BigDecimal.ZERO:zz.subtract(zzcb);
						gdjzBase = gdjz.subtract(gdjzcb).compareTo(BigDecimal.ZERO)<0?BigDecimal.ZERO:gdjz.subtract(gdjzcb);
						yxjzBase = yxjz.subtract(yxjzcb).compareTo(BigDecimal.ZERO)<0?BigDecimal.ZERO:yxjz.subtract(yxjzcb);
						yzBase = yz.subtract(yzcb).compareTo(BigDecimal.ZERO)<0?BigDecimal.ZERO:yz.subtract(yzcb);
						knwBase = knw.subtract(knwcb).compareTo(BigDecimal.ZERO)<0?BigDecimal.ZERO:knw.subtract(knwcb);
						//BigDecimal mbBase = mb.subtract(mbcb).compareTo(BigDecimal.ZERO)<0?BigDecimal.ZERO:mb.subtract(mbcb);
						xfBase = xf.subtract(xfcb).compareTo(BigDecimal.ZERO)<0?BigDecimal.ZERO:xf.subtract(xfcb);
						eyBase = ey.subtract(eycb).compareTo(BigDecimal.ZERO)<0?BigDecimal.ZERO:ey.subtract(eycb);
						
					} 
					
					/*BigDecimal zzBase = zz.subtract(zzcb).compareTo(BigDecimal.ZERO)<0?BigDecimal.ZERO:zz.subtract(zzcb);
					BigDecimal gdjzBase = gdjz.subtract(gdjzcb).compareTo(BigDecimal.ZERO)<0?BigDecimal.ZERO:gdjz.subtract(gdjzcb);
					BigDecimal yxjzBase = yxjz.subtract(yxjzcb).compareTo(BigDecimal.ZERO)<0?BigDecimal.ZERO:yxjz.subtract(yxjzcb);
					BigDecimal yzBase = yz.subtract(yzcb).compareTo(BigDecimal.ZERO)<0?BigDecimal.ZERO:yz.subtract(yzcb);
					BigDecimal knwBase = knw.subtract(knwcb).compareTo(BigDecimal.ZERO)<0?BigDecimal.ZERO:knw.subtract(knwcb);
					//BigDecimal mbBase = mb.subtract(mbcb).compareTo(BigDecimal.ZERO)<0?BigDecimal.ZERO:mb.subtract(mbcb);
					BigDecimal xfBase = xf.subtract(xfcb).compareTo(BigDecimal.ZERO)<0?BigDecimal.ZERO:xf.subtract(xfcb);
					BigDecimal eyBase = ey.subtract(eycb).compareTo(BigDecimal.ZERO)<0?BigDecimal.ZERO:ey.subtract(eycb);*/
					 
					BigDecimal allBase = zzBase.add(gdjzBase).add(yxjzBase).add(yzBase).add(knwBase).add(xfBase).add(eyBase);
					if(allBase.compareTo(BigDecimal.ZERO) <=0 ){
						allBase = new BigDecimal("1");
					}
					/*BigDecimal zzMoney = zz.subtract(zzcb).subtract(docBase.multiply(zzBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP))).compareTo(BigDecimal.ZERO) > 0 ? zz.subtract(zzcb).subtract(docBase.multiply(zzBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP))).multiply(zzbi):BigDecimal.ZERO;
					BigDecimal gdjzMoney = gdjz.subtract(gdjzcb).subtract(docBase.multiply(gdjzBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP))).compareTo(BigDecimal.ZERO) > 0 ? gdjz.subtract(gdjzcb).subtract(docBase.multiply(gdjzBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP))).multiply(gdjzbi):BigDecimal.ZERO;
					BigDecimal yxjzMoney = yxjz.subtract(yxjzcb).subtract(docBase.multiply(yxjzBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP))).compareTo(BigDecimal.ZERO) > 0 ?yxjz.subtract(yxjzcb).subtract(docBase.multiply(yxjzBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP))).multiply(yxjzbi):BigDecimal.ZERO;
					BigDecimal yzMoney = yz.subtract(yzcb).subtract(docBase.multiply(yzBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP))).compareTo(BigDecimal.ZERO) > 0 ? yz.subtract(yzcb).subtract(docBase.multiply(yzBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP))).multiply(yzbi):BigDecimal.ZERO;
					BigDecimal knwMoney = knw.subtract(knwcb).subtract(docBase.multiply(knwBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP))).compareTo(BigDecimal.ZERO) > 0 ? knw.subtract(knwcb).subtract(docBase.multiply(knwBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP))).multiply(knwbi):BigDecimal.ZERO;
					//BigDecimal mbMoney = mb.subtract(mbcb).subtract(docBase.multiply(mbBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP))).compareTo(BigDecimal.ZERO) > 0 ? mb.subtract(mbcb).subtract(docBase.multiply(mbBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP))).multiply(mbbi):BigDecimal.ZERO;
					BigDecimal mbMoney = mb.subtract(mbcb).compareTo(BigDecimal.ZERO) > 0 ? mb.subtract(mbcb).multiply(mbbi):mb.subtract(mbcb).multiply(mbbi);
					BigDecimal xfMoney = xf.subtract(xfcb).subtract(docBase.multiply(xfBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP))).compareTo(BigDecimal.ZERO) > 0 ? xf.subtract(xfcb).subtract(docBase.multiply(xfBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP))).multiply(xfbi):BigDecimal.ZERO;
					BigDecimal eyMoney = ey.subtract(eycb).subtract(docBase.multiply(eyBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP))).compareTo(BigDecimal.ZERO) > 0 ? ey.subtract(eycb).subtract(docBase.multiply(eyBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP))).multiply(eybi):BigDecimal.ZERO;
					*/
					
					BigDecimal zzMoney = BigDecimal.ZERO;
					BigDecimal gdjzMoney = BigDecimal.ZERO;
					BigDecimal yxjzMoney = BigDecimal.ZERO;
					BigDecimal yzMoney = BigDecimal.ZERO;
					BigDecimal knwMoney = BigDecimal.ZERO;
					BigDecimal mbMoney = BigDecimal.ZERO;
					BigDecimal xfMoney = BigDecimal.ZERO;
					BigDecimal eyMoney = BigDecimal.ZERO;
					if(allBase.compareTo(BigDecimal.ZERO) <=0 ){
						
					}else{ 
						zzMoney = zzBase.subtract(docBase.multiply(zzBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP))).compareTo(BigDecimal.ZERO) > 0 ? zzBase.subtract(docBase.multiply(zzBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP))).multiply(zzbi):BigDecimal.ZERO;
						gdjzMoney = gdjzBase.subtract(docBase.multiply(gdjzBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP))).compareTo(BigDecimal.ZERO) > 0 ? gdjzBase.subtract(docBase.multiply(gdjzBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP))).multiply(gdjzbi):BigDecimal.ZERO;
						yxjzMoney = yxjzBase.subtract(docBase.multiply(yxjzBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP))).compareTo(BigDecimal.ZERO) > 0 ? yxjzBase.subtract(docBase.multiply(yxjzBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP))).multiply(yxjzbi):BigDecimal.ZERO;
						yzMoney = yzBase.subtract(docBase.multiply(yzBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP))).compareTo(BigDecimal.ZERO) > 0 ? yzBase.subtract(docBase.multiply(yzBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP))).multiply(yzbi):BigDecimal.ZERO;
						knwMoney = knwBase.subtract(docBase.multiply(knwBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP))).compareTo(BigDecimal.ZERO) > 0 ? knwBase.subtract(docBase.multiply(knwBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP))).multiply(knwbi):BigDecimal.ZERO;
						//BigDecimal mbMoney = mb.subtract(mbcb).subtract(docBase.multiply(mbBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP))).compareTo(BigDecimal.ZERO) > 0 ? mb.subtract(mbcb).subtract(docBase.multiply(mbBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP))).multiply(mbbi):BigDecimal.ZERO;
						
						xfMoney = xfBase.subtract(docBase.multiply(xfBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP))).compareTo(BigDecimal.ZERO) > 0 ? xfBase.subtract(docBase.multiply(xfBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP))).multiply(xfbi):BigDecimal.ZERO;
						eyMoney = eyBase.subtract(docBase.multiply(eyBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP))).compareTo(BigDecimal.ZERO) > 0 ? eyBase.subtract(docBase.multiply(eyBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP))).multiply(eybi):BigDecimal.ZERO;
						
					}
					mbMoney = mb.subtract(mbcb).compareTo(BigDecimal.ZERO) > 0 ? mb.subtract(mbcb).multiply(mbbi):mb.subtract(mbcb).multiply(mbbi);
					
					//BigDecimal noybyMoney = zzMoney.add(gdjzMoney).add(yxjzMoney).add(yzMoney).add(knwMoney).add(mbMoney).add(xfMoney).add(eyMoney).setScale(2,BigDecimal.ROUND_HALF_UP); 
					
					BigDecimal noybyMoney = zzMoney.add(gdjzMoney).add(yxjzMoney).add(yzMoney).add(knwMoney).add(xfMoney).add(eyMoney).setScale(2,BigDecimal.ROUND_HALF_UP);
					
					BigDecimal sumAchieve =  zz.add(gdjz).add(yxjz).add(yz).add(knw).add(mb).add(xf).add(ey);
					insertSql += ",cfsumachieve, CFZZmoney, CFGDJZmoney, CFYXJZmoney, CFYZmoney, CFKNWmoney, CFMBmoney, CFXFmoney, CFEYmoney ";
					insertValueSql += " ,"+sumAchieve+", "+zzMoney+" ,"+(gdjzMoney)+","+(yxjzMoney)+" " +
						" ,"+(yzMoney)+" ,"+(knwMoney)+" ,"+(mbMoney)+" "+
						" ,"+xfMoney+" ,"+(eyMoney)+" ";
					docMap.put("EXISTS", "NO");
					docMap.put("mbMoney", mbMoney+"");
					docMap.put("JIANGJIN", bymoney.add(noybyMoney)+"");
					docMap.put("COST", costAll.toString()); 
					
				}else if(null != tempMap.get(empNum+"_SPEJIANZHIDOC")){//特殊兼职医生
					BigDecimal allMoney = BigDecimal.ZERO; 
					HashMap map =  (HashMap) tempMap.get(empNum+"_SPEJIANZHIDOC");
					BigDecimal zj = new BigDecimal(map.get("CFZJPRO").toString()); 
					String empName = map.get("CFDOCNAME").toString();
					
					//获得特殊兼职医生的提成比例
					zzbi = new BigDecimal(map.get("CFZZPRO").toString());
					gdjzbi = new BigDecimal(map.get("CFGDJZPRO").toString());
					yxjzbi = new BigDecimal(map.get("CFYXJZPRO").toString());
					yzbi = new BigDecimal(map.get("CFYZPRO").toString());//?
					knwbi = new BigDecimal(map.get("CFKNWPRO").toString());
					mbbi = new BigDecimal(map.get("CFMBPRO").toString());
					xfbi = new BigDecimal(map.get("CFXFPRO").toString());
					eybi = new BigDecimal(map.get("CFEYPRO").toString()); 

					StringBuffer sqlSpeZZ = new StringBuffer(); 
					//先计算种植颗数的奖金  
					sqlSpeZZ = getZhongZhiSql( empNum,  cityNumber, periodnum, empName,cityId,map);
					IRowSet speZZrs = com.kingdee.eas.custom.util.DBUtil.executeQuery(ctx,sqlSpeZZ);
					if(speZZrs!=null && speZZrs.size() > 0){
						  while(speZZrs.next()){	
							  allMoney = new BigDecimal(speZZrs.getString("ALLSUM"));
						  }
					}
					//再计算其他所有的  
					StringBuffer sqlOther = new StringBuffer(); 
					sqlOther = getOtherAllSql( empNum,  cityNumber, periodnum, empName,cityId,zj,map);
					IRowSet otherrs = com.kingdee.eas.custom.util.DBUtil.executeQuery(ctx,sqlOther);
					if(otherrs!=null && otherrs.size() > 0){
						  while(otherrs.next()){	
							  if("zz".equals(otherrs.getString("TYPE"))){//种植
								  zz =new BigDecimal(otherrs.getString("SUMM")); 
								  insertSql +=  ", CFZZACHIEVE ";
								  insertValueSql +=" ,"+zz+" ";
							  }else if("gdjz".equals(otherrs.getString("TYPE"))){//固定矫正 ？
								  gdjz=new BigDecimal(otherrs.getString("SUMM")); 
								  insertSql +=  ", CFGDJZACHIEVE ";
								  insertValueSql+=" ,"+gdjz;
							  }else if("yxjz".equals(otherrs.getString("TYPE"))){//隐形矫正
								  yxjz=new BigDecimal(otherrs.getString("SUMM")); 
								  insertSql +=  ", cfyxjzachieve ";
								  insertValueSql += " ,"+yxjz;
							  }else if("yz".equals(otherrs.getString("TYPE"))){//牙周 ？
								  yz=new BigDecimal(otherrs.getString("SUMM")); 
								  insertSql +=  ", CFZyAchieve ";
								  insertValueSql += " ,"+yz;
							  }else if("knw".equals(otherrs.getString("TYPE"))){//口内外 ？
								  knw =new BigDecimal(otherrs.getString("SUMM"));
								  insertSql +=  ", cfknwachieve ";
								  insertValueSql += " ,"+knw;
							  }else if("mb".equals(otherrs.getString("TYPE"))){//美白
								  mb=new BigDecimal(otherrs.getString("SUMM")); 
								  insertSql +=  ", cfmbachieve ";
								  insertValueSql += " ,"+mb;
							  }else if("xf".equals(otherrs.getString("TYPE"))){//修复
								  xf=new BigDecimal(otherrs.getString("SUMM")); 
								  insertSql +=  ", cfxfachieve ";
								  insertValueSql += " ,"+xf;
							  }else if("ey".equals(otherrs.getString("TYPE"))){//儿牙
								  ey=new BigDecimal(otherrs.getString("SUMM")); 
								  insertSql +=  ", cfeyachieve ";
								  insertValueSql += " ,"+ey;
							  } 
						  }
					}
					
					//获得 导入的成本
					StringBuffer sqlImportCB = new StringBuffer(); 
					sqlImportCB = getImportChengBenSql( "'"+empNum+"'",  cityId, periodnum, sqlImportCB);
					IRowSet imporytbrs = com.kingdee.eas.custom.util.DBUtil.executeQuery(ctx,sqlImportCB.toString());
					if(imporytbrs!=null && imporytbrs.size() > 0){
						  while(imporytbrs.next()){	
							  if("zz".equals(imporytbrs.getString("TYPE"))){//种植
								  zzcb =new BigDecimal(imporytbrs.getString("SUMM")); 
								  costAll = costAll.add(zzcb);
								   
								  clinicCostSumInfo.setImzzCost(zzcb);
							  }else if("gdjz".equals(imporytbrs.getString("TYPE"))){//固定矫正
								  gdjzcb=new BigDecimal(imporytbrs.getString("SUMM")); 
								  costAll = costAll.add(gdjzcb);
								   
								  clinicCostSumInfo.setImgdjzCost(gdjzcb);
							  }else if("yxjz".equals(imporytbrs.getString("TYPE"))){//隐形矫正
								  yxjzcb=new BigDecimal(imporytbrs.getString("SUMM")); 
								  costAll = costAll.add(yxjzcb);
								   
								  clinicCostSumInfo.setImyxjzCost(yxjzcb);
							  }else if("yz".equals(imporytbrs.getString("TYPE"))){//牙周
								  yzcb=new BigDecimal(imporytbrs.getString("SUMM")); 
								  costAll = costAll.add(yzcb);
								   
								  clinicCostSumInfo.setImyzCost(yzcb);
							  }else if("knw".equals(imporytbrs.getString("TYPE"))){//口内外
								  knwcb =new BigDecimal(imporytbrs.getString("SUMM"));
								  costAll = costAll.add(knwcb);
								   
								  clinicCostSumInfo.setImknwCost(knwcb);
							  }else if("mb".equals(imporytbrs.getString("TYPE"))){//美白
								  mbcb=new BigDecimal(imporytbrs.getString("SUMM")); 
								  costAll = costAll.add(mbcb); 
								  
								  clinicCostSumInfo.setImmbCost(mbcb);
							  }else if("xf".equals(imporytbrs.getString("TYPE"))){//修复
								  xfcb=new BigDecimal(imporytbrs.getString("SUMM")); 
								  costAll = costAll.add(xfcb);
								   
								  clinicCostSumInfo.setImxfCost(xfcb);
							  }else if("ey".equals(imporytbrs.getString("TYPE"))){//儿牙
								  eycb=new BigDecimal(imporytbrs.getString("SUMM")); 
								  costAll = costAll.add(eycb);
								  
								  clinicCostSumInfo.setImeyCost(eycb);
								   
							  }  
						  }
					} 
					//获得 护士调整的成本
					StringBuffer sqlHushiCB = new StringBuffer(); 
					sqlHushiCB = getHushiChengBenSql( "'"+empNum+"'",  cityNumber, periodnum, sqlHushiCB,"");
					IRowSet hushiCBrs = com.kingdee.eas.custom.util.DBUtil.executeQuery(ctx,sqlHushiCB.toString());
					if(hushiCBrs!=null && hushiCBrs.size() > 0){
						 while(hushiCBrs.next()){	
							  if("zz".equals(hushiCBrs.getString("TYPE"))){//种植
								  zzcb = zzcb.add(new BigDecimal(hushiCBrs.getString("SUMM"))); 
								  costAll = costAll.add(new BigDecimal(hushiCBrs.getString("SUMM"))); 
								  
								  clinicCostSumInfo.setZzCost(new BigDecimal(hushiCBrs.getString("SUMM")));
							  }else if("gdjz".equals(hushiCBrs.getString("TYPE"))){//固定矫正
								  gdjzcb = gdjzcb.add(new BigDecimal(hushiCBrs.getString("SUMM"))); 
								  costAll = costAll.add(new BigDecimal(hushiCBrs.getString("SUMM")));
								    
								  clinicCostSumInfo.setGdjzCost(new BigDecimal(hushiCBrs.getString("SUMM")));
							  }else if("yxjz".equals(hushiCBrs.getString("TYPE"))){//隐形矫正
								  yxjzcb = yxjzcb.add(new BigDecimal(hushiCBrs.getString("SUMM"))); 
								  costAll = costAll.add(new BigDecimal(hushiCBrs.getString("SUMM"))); 
								  
								  clinicCostSumInfo.setYxjzCost(new BigDecimal(hushiCBrs.getString("SUMM")));
							  }else if("yz".equals(hushiCBrs.getString("TYPE"))){//牙周
								  yzcb = yzcb.add(new BigDecimal(hushiCBrs.getString("SUMM"))); 
								  costAll = costAll.add(new BigDecimal(hushiCBrs.getString("SUMM"))); 
								  
								  clinicCostSumInfo.setYzCost(new BigDecimal(hushiCBrs.getString("SUMM")));
							  }else if("knw".equals(hushiCBrs.getString("TYPE"))){//口内外
								  knwcb = knwcb.add(new BigDecimal(hushiCBrs.getString("SUMM")));
								  costAll = costAll.add(new BigDecimal(hushiCBrs.getString("SUMM"))); 
								  
								  clinicCostSumInfo.setKnwCost(new BigDecimal(hushiCBrs.getString("SUMM")));
							  }else if("mb".equals(hushiCBrs.getString("TYPE"))){//美白
								  mbcb = mbcb.add(new BigDecimal(hushiCBrs.getString("SUMM"))); 
								  costAll = costAll.add(new BigDecimal(hushiCBrs.getString("SUMM")));  
								  
								  clinicCostSumInfo.setMbCost(new BigDecimal(hushiCBrs.getString("SUMM")));
							  }else if("xf".equals(hushiCBrs.getString("TYPE"))){//修复
								  xfcb = xfcb.add(new BigDecimal(hushiCBrs.getString("SUMM"))); 
								  costAll = costAll.add(new BigDecimal(hushiCBrs.getString("SUMM"))); 
								  
								  clinicCostSumInfo.setXfCost(new BigDecimal(hushiCBrs.getString("SUMM")));
							  }else if("ey".equals(hushiCBrs.getString("TYPE"))){//儿牙
								  eycb = eycb.add(new BigDecimal(hushiCBrs.getString("SUMM"))); 
								  costAll = costAll.add(new BigDecimal(hushiCBrs.getString("SUMM")));  
								  
								  clinicCostSumInfo.setEyCost(new BigDecimal(hushiCBrs.getString("SUMM")));
							  }   
						  }
					} 
					
					
					//再计算销售出库成本
					StringBuffer sqlCB = new StringBuffer(); 
					sqlCB = getChengBenSql( "'"+empNum+"'",  cityNumber, periodnum, sqlCB,"");
					IRowSet cbrs = com.kingdee.eas.custom.util.DBUtil.executeQuery(ctx,sqlCB.toString());
					if(cbrs!=null && cbrs.size() > 0){
						  while(cbrs.next()){	
							  if("zz".equals(cbrs.getString("TYPE"))){//种植
								  zzcb = zzcb.add(new BigDecimal(cbrs.getString("SUMM"))); 
								  costAll = costAll.add(new BigDecimal(cbrs.getString("SUMM")));
								  
								  insertSql +=  ", cfzzcost ";
								  insertValueSql += " ,"+zzcb;
								   
								  clinicCostSumInfo.setZzCost(clinicCostSumInfo.getZzCost().add(new BigDecimal(cbrs.getString("SUMM"))));
							  }else if("gdjz".equals(cbrs.getString("TYPE"))){//固定矫正
								  gdjzcb = gdjzcb.add(new BigDecimal(cbrs.getString("SUMM"))); 
								  costAll = costAll.add(new BigDecimal(cbrs.getString("SUMM")));
								  
								  insertSql +=  ", cfgdjzcost ";
								  insertValueSql += " ,"+gdjzcb;
								  
								  clinicCostSumInfo.setGdjzCost(clinicCostSumInfo.getGdjzCost().add(new BigDecimal(cbrs.getString("SUMM"))));
							  }else if("yxjz".equals(cbrs.getString("TYPE"))){//隐形矫正
								  yxjzcb = yxjzcb.add(new BigDecimal(cbrs.getString("SUMM"))); 
								  costAll = costAll.add(new BigDecimal(cbrs.getString("SUMM")));
								  
								  insertSql +=  ", cfyxjzcost ";
								  insertValueSql += " ,"+yxjzcb;
								  
								  clinicCostSumInfo.setYxjzCost(clinicCostSumInfo.getYxjzCost().add(new BigDecimal(cbrs.getString("SUMM"))));
							  }else if("yz".equals(cbrs.getString("TYPE"))){//牙周
								  yzcb = yzcb.add(new BigDecimal(cbrs.getString("SUMM"))); 
								  costAll = costAll.add(new BigDecimal(cbrs.getString("SUMM")));
								  
								  insertSql +=  ", cfyzcost ";
								  insertValueSql += " ,"+yzcb;
								  
								  clinicCostSumInfo.setYzCost(clinicCostSumInfo.getYzCost().add(new BigDecimal(cbrs.getString("SUMM"))));
							  }else if("knw".equals(cbrs.getString("TYPE"))){//口内外
								  knwcb = knwcb.add(new BigDecimal(cbrs.getString("SUMM")));
								  costAll = costAll.add(new BigDecimal(cbrs.getString("SUMM")));
								  
								  insertSql +=  ", cfknwcost ";
								  insertValueSql += " ,"+knwcb;
								  
								  clinicCostSumInfo.setKnwCost(clinicCostSumInfo.getKnwCost().add(new BigDecimal(cbrs.getString("SUMM"))));
							  }else if("mb".equals(cbrs.getString("TYPE"))){//美白
								  mbcb = mbcb.add(new BigDecimal(cbrs.getString("SUMM"))); 
								  costAll = costAll.add(new BigDecimal(cbrs.getString("SUMM")));
								  insertSql +=  ", cfmbcost ";
								  insertValueSql += " ,"+mbcb;
								  
								  clinicCostSumInfo.setMbCost(clinicCostSumInfo.getMbCost().add(new BigDecimal(cbrs.getString("SUMM"))));
							  }else if("xf".equals(cbrs.getString("TYPE"))){//修复
								  xfcb = xfcb.add(new BigDecimal(cbrs.getString("SUMM"))); 
								  costAll = costAll.add(new BigDecimal(cbrs.getString("SUMM")));
								  
								  insertSql +=  ", cfxfcost ";
								  insertValueSql += " ,"+xfcb;
								  
								  clinicCostSumInfo.setXfCost(clinicCostSumInfo.getXfCost().add(new BigDecimal(cbrs.getString("SUMM"))));
							  }else if("ey".equals(cbrs.getString("TYPE"))){//儿牙
								  eycb = eycb.add(new BigDecimal(cbrs.getString("SUMM"))); 
								  costAll = costAll.add(new BigDecimal(cbrs.getString("SUMM")));
								  
								  insertSql +=  ", cfeycost ";
								  insertValueSql += " ,"+eycb;
								  
								  clinicCostSumInfo.setEyCost(clinicCostSumInfo.getEyCost().add(new BigDecimal(cbrs.getString("SUMM"))));
							  }   
						  }
						  
					} 
					
					BigDecimal zzBase = zz.subtract(zzcb).compareTo(BigDecimal.ZERO)<0?BigDecimal.ZERO:zz.subtract(zzcb);
					BigDecimal gdjzBase = gdjz.subtract(gdjzcb).compareTo(BigDecimal.ZERO)<0?BigDecimal.ZERO:gdjz.subtract(gdjzcb);
					BigDecimal yxjzBase = yxjz.subtract(yxjzcb).compareTo(BigDecimal.ZERO)<0?BigDecimal.ZERO:yxjz.subtract(yxjzcb);
					BigDecimal yzBase = yz.subtract(yzcb).compareTo(BigDecimal.ZERO)<0?BigDecimal.ZERO:yz.subtract(yzcb);
					BigDecimal knwBase = knw.subtract(knwcb).compareTo(BigDecimal.ZERO)<0?BigDecimal.ZERO:knw.subtract(knwcb);
					BigDecimal mbBase = mb.subtract(mbcb).compareTo(BigDecimal.ZERO)<0?BigDecimal.ZERO:mb.subtract(mbcb);
					BigDecimal xfBase = xf.subtract(xfcb).compareTo(BigDecimal.ZERO)<0?BigDecimal.ZERO:xf.subtract(xfcb);
					BigDecimal eyBase = ey.subtract(eycb).compareTo(BigDecimal.ZERO)<0?BigDecimal.ZERO:ey.subtract(eycb);
					
					BigDecimal allBase = zzBase.add(gdjzBase).add(yxjzBase).add(yzBase).add(knwBase).add(mbBase).add(xfBase).add(eyBase);
					
					BigDecimal zzMoney = zz.subtract(zzcb).subtract(docBase.multiply(zzBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP))).compareTo(BigDecimal.ZERO) > 0 ? zz.subtract(zzcb).subtract(docBase.multiply(zzBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP))).multiply(zzbi):BigDecimal.ZERO;
					BigDecimal gdjzMoney = gdjz.subtract(gdjzcb).subtract(docBase.multiply(gdjzBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP))).compareTo(BigDecimal.ZERO) > 0 ? gdjz.subtract(gdjzcb).subtract(docBase.multiply(gdjzBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP))).multiply(gdjzbi):BigDecimal.ZERO;
					BigDecimal yxjzMoney = yxjz.subtract(yxjzcb).subtract(docBase.multiply(yxjzBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP))).compareTo(BigDecimal.ZERO) > 0 ?yxjz.subtract(yxjzcb).subtract(docBase.multiply(yxjzBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP))).multiply(yxjzbi):BigDecimal.ZERO;
					BigDecimal yzMoney = yz.subtract(yzcb).subtract(docBase.multiply(yzBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP))).compareTo(BigDecimal.ZERO) > 0 ? yz.subtract(yzcb).subtract(docBase.multiply(yzBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP))).multiply(yzbi):BigDecimal.ZERO;
					BigDecimal knwMoney = knw.subtract(knwcb).subtract(docBase.multiply(knwBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP))).compareTo(BigDecimal.ZERO) > 0 ? knw.subtract(knwcb).subtract(docBase.multiply(knwBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP))).multiply(knwbi):BigDecimal.ZERO;
					BigDecimal mbMoney = mb.subtract(mbcb).subtract(docBase.multiply(mbBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP))).compareTo(BigDecimal.ZERO) > 0 ? mb.subtract(mbcb).subtract(docBase.multiply(mbBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP))).multiply(mbbi):BigDecimal.ZERO;
					BigDecimal xfMoney = xf.subtract(xfcb).subtract(docBase.multiply(xfBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP))).compareTo(BigDecimal.ZERO) > 0 ? xf.subtract(xfcb).subtract(docBase.multiply(xfBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP))).multiply(xfbi):BigDecimal.ZERO;
					BigDecimal eyMoney = ey.subtract(eycb).subtract(docBase.multiply(eyBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP))).compareTo(BigDecimal.ZERO) > 0 ? ey.subtract(eycb).subtract(docBase.multiply(eyBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP))).multiply(eybi):BigDecimal.ZERO;
					
					money = zzMoney.add(gdjzMoney).add(yxjzMoney).add(yzMoney).add(knwMoney).add(mbMoney).add(xfMoney).add(eyMoney).add(allMoney)
					.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
					 
					BigDecimal sumAchieve =  zz.add(gdjz).add(yxjz).add(yz).add(knw).add(mb).add(xf).add(ey);
					insertSql += ",cfsumachieve, CFZZmoney, CFGDJZmoney, CFYXJZmoney, CFYZmoney, CFKNWmoney, CFMBmoney, CFXFmoney, CFEYmoney,CFOTHERMONEY ";
					insertValueSql += " ,"+sumAchieve+", "+zzMoney+" ,"+gdjzMoney+","+yxjzMoney+" " +
						" ,"+yzMoney+" ,"+knwMoney+" ,"+mbMoney+" "+
						" ,"+xfMoney+" ,"+eyMoney+","+allMoney+" ";
					docMap.put("EXISTS", "NO");

					docMap.put("JIANGJIN", money+"");
					docMap.put("COST", costAll.toString()); 
				}
				
				
			} 
			docMap.put("INSERTSQL",insertSql);
			docMap.put("INSERTVALUESQL",insertValueSql); 
			
			docMap.put("imandxtinsertsql",imandxtinsertsql);
			docMap.put("imandxtinsertValueSql",imandxtinsertValueSql);  
			
			ClinicCostSumFactory.getLocalInstance(ctx).save(clinicCostSumInfo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.log.error("系统出现异常，请联系管理员");
		}   
		
		
		return docMap;
	}
	
	public StringBuffer getYeJiImpSql(String empNum, String cityNumber,String periodnum,StringBuffer sqlYJ,String cityId,BigDecimal zjbl){
		//种植   and CFClinicNumber='"+clinicNumber+"'
		sqlYJ.append("  /*dialect*/ SELECT  nvl( sum(cfzzachieve),0) as ZZ , nvl(sum(cfyxjzachieve),0) as YXJZ , nvl(sum(cfgdjzachieve),0) as GDJZ , nvl(sum(cfknwachieve),0) as KNW , nvl(sum(cfxfachieve),0) as XF , nvl(sum(cfeyachieve),0) as EY , nvl(sum(cfyzachieve),0) as YZ , nvl(sum(cfmbachieve),0) as MB , nvl(sum(cfjzmoney),0) as JZ   ")
		.append(" FROM  CT_PAY_DocAchieveUpdate where cfcityid = '"+cityId+"' and ( cfiszidai = 0 or cfiszidai is null) and cfdocnumber = '"+empNum+"' and  cfbusinessdate = '"+periodnum+"' ");
		 

		return sqlYJ;
	}

	
	/**
	 * 统计医生的业绩
	 * @param empNum
	 * @param clinicNumber
	 * @param periodnum
	 * @param sqlYJ
	 * @return
	 */

	public StringBuffer getYeJiSql(String empNum, String cityNumber,String periodnum,StringBuffer sqlYJ,String cityId,BigDecimal zjbl){
		//种植   and CFClinicNumber='"+clinicNumber+"'
		sqlYJ.append("  /*dialect*/ select aa.summ,'zz' as type from ( ");
		sqlYJ.append(" select sum(a.allm) as summ from ( ");
		sqlYJ.append(" SELECT nvl((sum(CFINCOME)*0.9),0) as allm FROM  CT_PAY_AchieveDetailTem where  CFFIRSOURCE = '渠道推广' and  CFFirClassNumber='3' and  CFRecDotNumber ='"+empNum+"'  and CFCityNumber='"+cityNumber+"' and  to_char(fbizdate,'YYYYMM') ='"+periodnum+"'   ");
		sqlYJ.append(" union  SELECT  nvl((sum(CFINCOME)*0.82),0) as allm FROM  CT_PAY_AchieveDetailTem  where  CFTerSource = '老吾老' and  CFFirClassNumber='3'  and   CFRecDotNumber ='"+empNum+"'  and CFCityNumber='"+cityNumber+"'  and  to_char(fbizdate,'YYYYMM') ='"+periodnum+"'   ");
		sqlYJ.append(" union  SELECT  nvl(sum(CFINCOME),0) as allm FROM  CT_PAY_AchieveDetailTem  where  (CFTerSource != '老吾老' or CFTerSource is null ) and CFFIRSOURCE != '渠道推广' and  CFFirClassNumber='3'  and   CFRecDotNumber ='"+empNum+"'  and CFCityNumber='"+cityNumber+"' and  to_char(fbizdate,'YYYYMM') ='"+periodnum+"'   ");
		sqlYJ.append(" ) a ) aa ");
		sqlYJ.append(" union ");
		//固定矫正
		sqlYJ.append(" select bb.summ,'gdjz' as type from (select sum(b.allm) as summ from (");
		sqlYJ.append(" SELECT nvl((sum(CFINCOME)*0.9*"+zjbl+"),0) as allm FROM  CT_PAY_AchieveDetailTem where  CFFIRSOURCE = '渠道推广' and  CFFirClassNumber='4' and CFIsRoutine='是' and   CFRecDotNumber ='"+empNum+"'  and CFCityNumber='"+cityNumber+"' and  to_char(fbizdate,'YYYYMM') ='"+periodnum+"' and not exists ( SELECT 1 FROM  CT_SRQ_ClinicItem clinicItem left join  CT_SRQ_ClinicItemEntry  entry  on clinicItem.fid = entry.fparentid  left join CT_SRQ_PayItem payItem on payItem.fid = entry.cfitemid  where clinicItem.cfcityid = '"+cityId+"' and  clinicItem.cfproject = '口内外正畸' and   CT_PAY_AchieveDetailTem.CFFeeItemDetailNumber = payItem.fnumber)   ");
		sqlYJ.append(" union  SELECT  nvl((sum(CFINCOME)*0.82*"+zjbl+"),0) as allm FROM  CT_PAY_AchieveDetailTem  where  CFTerSource = '老吾老' and  CFFirClassNumber='4'   and CFIsRoutine='是' and   CFRecDotNumber ='"+empNum+"'  and CFCityNumber='"+cityNumber+"' and  to_char(fbizdate,'YYYYMM') ='"+periodnum+"' and not exists ( SELECT 1 FROM  CT_SRQ_ClinicItem clinicItem left join  CT_SRQ_ClinicItemEntry  entry  on clinicItem.fid = entry.fparentid  left join CT_SRQ_PayItem payItem on payItem.fid = entry.cfitemid  where clinicItem.cfcityid = '"+cityId+"' and  clinicItem.cfproject = '口内外正畸' and   CT_PAY_AchieveDetailTem.CFFeeItemDetailNumber = payItem.fnumber)  ");
		sqlYJ.append(" union  SELECT  nvl(sum(CFINCOME)*"+zjbl+",0) as allm FROM  CT_PAY_AchieveDetailTem  where   (CFTerSource != '老吾老' or CFTerSource is null )  and CFFIRSOURCE !=  '渠道推广'  and  CFFirClassNumber='4'  and CFIsRoutine='是' and   CFRecDotNumber ='"+empNum+"' and CFCityNumber='"+cityNumber+"'  and  to_char(fbizdate,'YYYYMM') ='"+periodnum+"'  and not exists ( SELECT 1 FROM  CT_SRQ_ClinicItem clinicItem left join  CT_SRQ_ClinicItemEntry  entry  on clinicItem.fid = entry.fparentid  left join CT_SRQ_PayItem payItem on payItem.fid = entry.cfitemid  where clinicItem.cfcityid = '"+cityId+"' and  clinicItem.cfproject = '口内外正畸' and   CT_PAY_AchieveDetailTem.CFFeeItemDetailNumber = payItem.fnumber)  ");
		sqlYJ.append(" ) b) bb ");
		sqlYJ.append(" union ");
		//隐形矫正
		sqlYJ.append(" select cc.summ,'yxjz' as type from (select sum(c.allm) as summ from ( ");
		sqlYJ.append(" SELECT nvl((sum(CFINCOME)*0.9*"+zjbl+"),0) as allm FROM  CT_PAY_AchieveDetailTem where  CFFIRSOURCE = '渠道推广'  and  CFFirClassNumber='4'  and CFIsRoutine='否' and    CFRecDotNumber ='"+empNum+"' and CFCityNumber='"+cityNumber+"'   and  to_char(fbizdate,'YYYYMM') ='"+periodnum+"'  and not exists ( SELECT 1 FROM  CT_SRQ_ClinicItem clinicItem left join  CT_SRQ_ClinicItemEntry  entry  on clinicItem.fid = entry.fparentid  left join CT_SRQ_PayItem payItem on payItem.fid = entry.cfitemid  where clinicItem.cfcityid = '"+cityId+"' and  clinicItem.cfproject = '口内外正畸' and   CT_PAY_AchieveDetailTem.CFFeeItemDetailNumber = payItem.fnumber)  ");
		sqlYJ.append(" union  SELECT  nvl((sum(CFINCOME)*0.82*"+zjbl+"),0) as allm FROM  CT_PAY_AchieveDetailTem  where  CFTerSource = '老吾老'  and  CFFirClassNumber='4'  and CFIsRoutine='否'   and   CFRecDotNumber ='"+empNum+"'  and CFCityNumber='"+cityNumber+"'  and  to_char(fbizdate,'YYYYMM') ='"+periodnum+"'  and not exists ( SELECT 1 FROM  CT_SRQ_ClinicItem clinicItem left join  CT_SRQ_ClinicItemEntry  entry  on clinicItem.fid = entry.fparentid  left join CT_SRQ_PayItem payItem on payItem.fid = entry.cfitemid  where clinicItem.cfcityid = '"+cityId+"' and  clinicItem.cfproject = '口内外正畸' and   CT_PAY_AchieveDetailTem.CFFeeItemDetailNumber = payItem.fnumber)  ");
		sqlYJ.append(" union  SELECT  nvl(sum(CFINCOME)*"+zjbl+",0) as allm FROM  CT_PAY_AchieveDetailTem  where  (CFTerSource != '老吾老' or CFTerSource is null )  and CFFIRSOURCE !=  '渠道推广'   and  CFFirClassNumber='4'   and CFIsRoutine='否' and   CFRecDotNumber ='"+empNum+"'  and CFCityNumber='"+cityNumber+"' and  to_char(fbizdate,'YYYYMM') ='"+periodnum+"'  and not exists ( SELECT 1 FROM  CT_SRQ_ClinicItem clinicItem left join  CT_SRQ_ClinicItemEntry  entry  on clinicItem.fid = entry.fparentid  left join CT_SRQ_PayItem payItem on payItem.fid = entry.cfitemid  where clinicItem.cfcityid = '"+cityId+"' and  clinicItem.cfproject = '口内外正畸' and   CT_PAY_AchieveDetailTem.CFFeeItemDetailNumber = payItem.fnumber)  ");
		sqlYJ.append(" ) c) cc ");
		sqlYJ.append(" union ");
		//牙周
		sqlYJ.append(" select dd.summ,'yz' as type from (select sum(d.allm) as summ from ( ");
		sqlYJ.append(" SELECT nvl((sum(CFINCOME)*0.9),0) as allm FROM  CT_PAY_AchieveDetailTem where  CFFIRSOURCE = '渠道推广'     and   CFRecDotNumber ='"+empNum+"'   and CFCityNumber='"+cityNumber+"' and  to_char(fbizdate,'YYYYMM') ='"+periodnum+"' and exists ( SELECT 1 FROM  CT_SRQ_ClinicItem clinicItem left join  CT_SRQ_ClinicItemEntry  entry  on clinicItem.fid = entry.fparentid  left join CT_SRQ_PayItem payItem on payItem.fid = entry.cfitemid  where clinicItem.cfcityid = '"+cityId+"' and  clinicItem.cfproject = '牙周' and   CT_PAY_AchieveDetailTem.CFFeeItemDetailNumber = payItem.fnumber)  ");
		sqlYJ.append(" union  SELECT  nvl((sum(CFINCOME)*0.82),0) as allm FROM  CT_PAY_AchieveDetailTem  where  CFTerSource = '老吾老'    and   CFRecDotNumber ='"+empNum+"' and CFCityNumber='"+cityNumber+"'  and  to_char(fbizdate,'YYYYMM') ='"+periodnum+"'  and exists ( SELECT 1 FROM  CT_SRQ_ClinicItem clinicItem left join  CT_SRQ_ClinicItemEntry  entry  on clinicItem.fid = entry.fparentid  left join CT_SRQ_PayItem payItem on payItem.fid = entry.cfitemid  where clinicItem.cfcityid = '"+cityId+"' and  clinicItem.cfproject = '牙周' and   CT_PAY_AchieveDetailTem.CFFeeItemDetailNumber = payItem.fnumber)  ");
		sqlYJ.append(" union  SELECT  nvl(sum(CFINCOME),0) as allm FROM  CT_PAY_AchieveDetailTem  where   (CFTerSource != '老吾老' or CFTerSource is null ) and CFFIRSOURCE !=  '渠道推广'     and   CFRecDotNumber ='"+empNum+"'   and CFCityNumber='"+cityNumber+"' and  to_char(fbizdate,'YYYYMM') ='"+periodnum+"' and exists ( SELECT 1 FROM  CT_SRQ_ClinicItem clinicItem left join  CT_SRQ_ClinicItemEntry  entry  on clinicItem.fid = entry.fparentid  left join CT_SRQ_PayItem payItem on payItem.fid = entry.cfitemid  where clinicItem.cfcityid = '"+cityId+"' and  clinicItem.cfproject = '牙周' and   CT_PAY_AchieveDetailTem.CFFeeItemDetailNumber = payItem.fnumber)  ");
		sqlYJ.append(" ) d) dd ");
		sqlYJ.append(" union ");
		//口内外
		sqlYJ.append(" select ee.summ,'knw' as type from (select sum(e.allm) as summ from ( ");
		sqlYJ.append(" SELECT nvl((sum(CFINCOME)*0.9),0) as allm FROM  CT_PAY_AchieveDetailTem where  CFFIRSOURCE = '渠道推广'   and   CFRecDotNumber ='"+empNum+"'   and  to_char(fbizdate,'YYYYMM') ='"+periodnum+"' and CFCityNumber='"+cityNumber+"' and exists ( SELECT 1 FROM  CT_SRQ_ClinicItem clinicItem left join  CT_SRQ_ClinicItemEntry  entry  on clinicItem.fid = entry.fparentid  left join CT_SRQ_PayItem payItem on payItem.fid = entry.cfitemid  where clinicItem.cfcityid = '"+cityId+"' and  clinicItem.cfproject = '口内外' and   CT_PAY_AchieveDetailTem.CFFeeItemDetailNumber = payItem.fnumber)  ");
		sqlYJ.append(" union  SELECT  nvl((sum(CFINCOME)*0.82),0) as allm FROM  CT_PAY_AchieveDetailTem  where  CFTerSource = '老吾老'   and   CFRecDotNumber ='"+empNum+"'   and  to_char(fbizdate,'YYYYMM') ='"+periodnum+"' and CFCityNumber='"+cityNumber+"' and exists ( SELECT 1 FROM  CT_SRQ_ClinicItem clinicItem left join  CT_SRQ_ClinicItemEntry  entry  on clinicItem.fid = entry.fparentid  left join CT_SRQ_PayItem payItem on payItem.fid = entry.cfitemid  where clinicItem.cfcityid = '"+cityId+"' and  clinicItem.cfproject = '口内外' and   CT_PAY_AchieveDetailTem.CFFeeItemDetailNumber = payItem.fnumber) ");
		sqlYJ.append(" union  SELECT  nvl(sum(CFINCOME),0) as allm FROM  CT_PAY_AchieveDetailTem  where  (CFTerSource != '老吾老' or CFTerSource is null )  and CFFIRSOURCE !=  '渠道推广'  and   CFRecDotNumber ='"+empNum+"' and CFCityNumber='"+cityNumber+"'  and  to_char(fbizdate,'YYYYMM') ='"+periodnum+"' and exists ( SELECT 1 FROM  CT_SRQ_ClinicItem clinicItem left join  CT_SRQ_ClinicItemEntry  entry  on clinicItem.fid = entry.fparentid  left join CT_SRQ_PayItem payItem on payItem.fid = entry.cfitemid  where clinicItem.cfcityid = '"+cityId+"' and  clinicItem.cfproject = '口内外' and   CT_PAY_AchieveDetailTem.CFFeeItemDetailNumber = payItem.fnumber)  ");
		sqlYJ.append(" ) e) ee ");
		sqlYJ.append(" union ");
		// 美白
		sqlYJ.append(" select ff.summ,'mb' as type from (select sum(f.allm) as summ from ( ");
		sqlYJ.append(" SELECT nvl((sum(CFINCOME)*0.9),0) as allm FROM  CT_PAY_AchieveDetailTem where  CFFIRSOURCE = '渠道推广' and  CFFirClassNumber='7'  and CFSecClassnumber='43' and   CFRecDotNumber ='"+empNum+"'  and CFCityNumber='"+cityNumber+"' and  to_char(fbizdate,'YYYYMM') ='"+periodnum+"'  ");
		sqlYJ.append(" union  SELECT  nvl((sum(CFINCOME)*0.82),0) as allm FROM  CT_PAY_AchieveDetailTem  where  CFTerSource = '老吾老' and  CFFirClassNumber='7'  and CFSecClassnumber='43'and   CFRecDotNumber ='"+empNum+"'   and CFCityNumber='"+cityNumber+"' and  to_char(fbizdate,'YYYYMM') ='"+periodnum+"'   ");
		sqlYJ.append(" union  SELECT  nvl(sum(CFINCOME),0) as allm FROM  CT_PAY_AchieveDetailTem  where  (CFTerSource != '老吾老' or CFTerSource is null ) and CFFIRSOURCE !=  '渠道推广' and  CFFirClassNumber='7'  and CFSecClassnumber='43' and   CFRecDotNumber ='"+empNum+"' and CFCityNumber='"+cityNumber+"'  and  to_char(fbizdate,'YYYYMM') ='"+periodnum+"'   ");
		sqlYJ.append(" ) f) ff ");
		sqlYJ.append(" union ");
		//修复
		sqlYJ.append(" select gg.summ,'xf' as type from (select sum(g.allm) as summ from ( ");
		sqlYJ.append(" SELECT nvl((sum(CFINCOME)*0.9),0) as allm FROM  CT_PAY_AchieveDetailTem where  CFFIRSOURCE = '渠道推广'   and  CFFirClassNumber='2'  and   CFRecDotNumber ='"+empNum+"' and CFCityNumber='"+cityNumber+"'  and  to_char(fbizdate,'YYYYMM') ='"+periodnum+"'  ");
		sqlYJ.append(" union  SELECT  nvl((sum(CFINCOME)*0.82),0) as allm FROM  CT_PAY_AchieveDetailTem  where  CFTerSource = '老吾老'  and  CFFirClassNumber='2'  and   CFRecDotNumber ='"+empNum+"'   and CFCityNumber='"+cityNumber+"' and  to_char(fbizdate,'YYYYMM') ='"+periodnum+"'  ");
		sqlYJ.append(" union  SELECT  nvl(sum(CFINCOME),0) as allm FROM  CT_PAY_AchieveDetailTem  where   (CFTerSource != '老吾老' or CFTerSource is null ) and  CFFirClassNumber='2'  and CFFIRSOURCE !=  '渠道推广' and   CFRecDotNumber ='"+empNum+"'  and CFCityNumber='"+cityNumber+"'  and  to_char(fbizdate,'YYYYMM') ='"+periodnum+"'  ");
		sqlYJ.append(" ) g) gg ");
		sqlYJ.append(" union ");
		// 儿牙
		sqlYJ.append(" select hh.summ,'ey' as type from (select sum(h.allm) as summ from ( ");
		sqlYJ.append(" SELECT nvl((sum(CFINCOME)*0.9),0) as allm FROM  CT_PAY_AchieveDetailTem where  CFFIRSOURCE = '渠道推广' and  CFFirClassNumber='6'  and   CFRecDotNumber ='"+empNum+"' and CFCityNumber='"+cityNumber+"' and  to_char(fbizdate,'YYYYMM') ='"+periodnum+"'   ");
		sqlYJ.append(" union  SELECT  nvl((sum(CFINCOME)*0.82),0) as allm FROM  CT_PAY_AchieveDetailTem  where  CFTerSource = '老吾老'  and  CFFirClassNumber='6'  and   CFRecDotNumber ='"+empNum+"' and CFCityNumber='"+cityNumber+"'  and  to_char(fbizdate,'YYYYMM') ='"+periodnum+"'  ");
		sqlYJ.append(" union  SELECT  nvl(sum(CFINCOME),0) as allm FROM  CT_PAY_AchieveDetailTem  where   (CFTerSource != '老吾老' or CFTerSource is null )  and CFFIRSOURCE !=  '渠道推广'  and  CFFirClassNumber='6'  and   CFRecDotNumber ='"+empNum+"' and CFCityNumber='"+cityNumber+"' and  to_char(fbizdate,'YYYYMM') ='"+periodnum+"'  ");
		sqlYJ.append(" ) h) hh ");

		return sqlYJ;
	}
	
	/**
	 * 统计医生的成本
	 * @param empNum
	 * @param cityNumber
	 * @param periodnum
	 * @param sqlCB
	 * @return
	 */
	public StringBuffer getChengBenSql(String empNums, String cityNumber,String periodnum,StringBuffer sqlCB,String  isDocOrAss){
		if("ASS".equals(isDocOrAss)){//如果是助理  只统计美白成本
			sqlCB.append(" /*dialect*/select 0 as summ,'zz' as type  from  CT_PAY_CostSum where cfperiod = '"+periodnum+"' and cfcitynumber='"+cityNumber+"' and  cfdoctornumber in ("+empNums+")  union ");
			sqlCB.append(" 	select 0 as summ,'yxjz' as type  from  CT_PAY_CostSum where cfperiod = '"+periodnum+"' and cfcitynumber='"+cityNumber+"'  and  cfdoctornumber in ("+empNums+")   union ");
			sqlCB.append(" 	select 0 as summ,'gdjz' as type  from  CT_PAY_CostSum where cfperiod = '"+periodnum+"' and cfcitynumber='"+cityNumber+"'   and  cfdoctornumber in ("+empNums+")   union ");
			sqlCB.append(" 	select 0 as summ,'knw' as type  from  CT_PAY_CostSum where cfperiod = '"+periodnum+"' and cfcitynumber='"+cityNumber+"'    and  cfdoctornumber in ("+empNums+")    union ");
			sqlCB.append(" 	select 0 as summ,'xf' as type  from  CT_PAY_CostSum where cfperiod = '"+periodnum+"'   and cfcitynumber='"+cityNumber+"' and  cfdoctornumber  in ("+empNums+")   union ");
			sqlCB.append(" 	select 0 as summ,'ey' as type  from  CT_PAY_CostSum where cfperiod = '"+periodnum+"'  and cfcitynumber='"+cityNumber+"'  and  cfdoctornumber  in ("+empNums+")   union ");
			sqlCB.append(" 	select 0 as summ,'yz' as type  from  CT_PAY_CostSum where cfperiod = '"+periodnum+"' and cfcitynumber='"+cityNumber+"'   and  cfdoctornumber in ("+empNums+")  union ");
			sqlCB.append(" 	select 0 as summ,'mb' as type  from  CT_PAY_CostSum where cfperiod = '"+periodnum+"'  and cfcitynumber='"+cityNumber+"'  and  cfdoctornumber in ("+empNums+")   ");
			
		}else{
			sqlCB.append(" /*dialect*/select ( nvl(sum(cfxhzz),0) +nvl(sum(cfjgfzz),0)) as summ,'zz' as type  from  CT_PAY_CostSum where cfperiod = '"+periodnum+"' and cfcitynumber='"+cityNumber+"' and  cfdoctornumber in ("+empNums+")  union ");
			sqlCB.append(" 	select ( nvl(sum(cfxhyxjz),0) +nvl(sum(cfjgfyxjz),0)) as summ,'yxjz' as type  from  CT_PAY_CostSum where cfperiod = '"+periodnum+"' and cfcitynumber='"+cityNumber+"'  and  cfdoctornumber in ("+empNums+")   union ");
			sqlCB.append(" 	select ( nvl(sum(cfxhcgjz),0) +nvl(sum(cfjgfcgjz),0)) as summ,'gdjz' as type  from  CT_PAY_CostSum where cfperiod = '"+periodnum+"' and cfcitynumber='"+cityNumber+"'   and  cfdoctornumber in ("+empNums+")   union ");
			sqlCB.append(" 	select ( nvl(sum(cfxhknw),0) +nvl(sum(cfjgfknw),0)) as summ,'knw' as type  from  CT_PAY_CostSum where cfperiod = '"+periodnum+"' and cfcitynumber='"+cityNumber+"'    and  cfdoctornumber in ("+empNums+")    union ");
			sqlCB.append(" 	select ( nvl(sum(cfxhxf),0) +nvl(sum(cfjgfxf),0)) as summ,'xf' as type  from  CT_PAY_CostSum where cfperiod = '"+periodnum+"'   and cfcitynumber='"+cityNumber+"' and  cfdoctornumber  in ("+empNums+")   union ");
			sqlCB.append(" 	select ( nvl(sum(cfxhey),0) +nvl(sum(cfjgfey),0)) as summ,'ey' as type  from  CT_PAY_CostSum where cfperiod = '"+periodnum+"'  and cfcitynumber='"+cityNumber+"'  and  cfdoctornumber  in ("+empNums+")   union ");
			sqlCB.append(" 	select ( nvl(sum(cfxhyz),0) +nvl(sum(cfjgfyz),0)) as summ,'yz' as type  from  CT_PAY_CostSum where cfperiod = '"+periodnum+"' and cfcitynumber='"+cityNumber+"'   and  cfdoctornumber in ("+empNums+")  union ");
			sqlCB.append(" 	select ( nvl(sum(cfjgfmb),0) +nvl(sum(cfxhmb),0) ) as summ,'mb' as type  from  CT_PAY_CostSum where cfperiod = '"+periodnum+"'  and cfcitynumber='"+cityNumber+"'  and  cfdoctornumber in ("+empNums+")   ");
			
		}
		
		
		return sqlCB;
	}
	
	public StringBuffer getHushiChengBenSql(String empNums, String cityNumber,String periodnum,StringBuffer sqlCB,String  isDocOrAss){
		
		if("ASS".equals(isDocOrAss)){//如果是助理  只统计美白成本
			sqlCB.append(" /*dialect*/ select 0 as summ,'zz' as type  from  CT_PAY_CostByUpdate  where cfperiod = '"+periodnum+"' and cfcitynumber='"+cityNumber+"' and  cfdoctornumber in ("+empNums+") and (cfiszidai is null or cfiszidai = 0)  union ");
			sqlCB.append(" 	select 0 as summ,'yxjz' as type  from  CT_PAY_CostByUpdate  where cfperiod = '"+periodnum+"' and cfcitynumber='"+cityNumber+"'  and  cfdoctornumber in ("+empNums+") and (cfiszidai is null or cfiszidai = 0) union ");
			sqlCB.append(" 	select 0 as summ,'gdjz' as type  from  CT_PAY_CostByUpdate  where cfperiod = '"+periodnum+"' and cfcitynumber='"+cityNumber+"'   and  cfdoctornumber in ("+empNums+") and (cfiszidai is null or cfiszidai = 0)  union ");
			sqlCB.append(" 	select 0 as summ,'knw' as type  from  CT_PAY_CostByUpdate  where cfperiod = '"+periodnum+"' and cfcitynumber='"+cityNumber+"'    and  cfdoctornumber in ("+empNums+")and (cfiszidai is null or cfiszidai = 0)  union ");
			sqlCB.append(" 	select 0 as summ,'xf' as type  from  CT_PAY_CostByUpdate  where cfperiod = '"+periodnum+"'   and cfcitynumber='"+cityNumber+"' and  cfdoctornumber  in ("+empNums+") and (cfiszidai is null or cfiszidai = 0) union ");
			sqlCB.append(" 	select 0 as summ,'ey' as type  from  CT_PAY_CostByUpdate  where cfperiod = '"+periodnum+"'  and cfcitynumber='"+cityNumber+"'  and  cfdoctornumber  in ("+empNums+") and (cfiszidai is null or cfiszidai = 0) union ");
			sqlCB.append(" 	select 0 as summ,'yz' as type  from  CT_PAY_CostByUpdate  where cfperiod = '"+periodnum+"' and cfcitynumber='"+cityNumber+"'   and  cfdoctornumber in ("+empNums+")  and (cfiszidai is null or cfiszidai = 0) union ");
			sqlCB.append(" 	select ( nvl(sum(cfjgfmb),0) +nvl(sum(cfxhmb),0) ) as summ,'mb' as type  from  CT_PAY_CostByUpdate  where cfperiod = '"+periodnum+"'  and cfcitynumber='"+cityNumber+"'  and  cfdoctornumber in ("+empNums+") and (cfiszidai is null or cfiszidai = 0)  ");
			
		}else{
			sqlCB.append(" /*dialect*/ select ( nvl(sum(cfxhzz),0) +nvl(sum(cfjgfzz),0)) as summ,'zz' as type  from  CT_PAY_CostByUpdate  where cfperiod = '"+periodnum+"' and cfcitynumber='"+cityNumber+"' and  cfdoctornumber in ("+empNums+") and (cfiszidai is null or cfiszidai = 0)  union ");
			sqlCB.append(" 	select ( nvl(sum(cfxhyxjz),0) +nvl(sum(cfjgfyxjz),0)) as summ,'yxjz' as type  from  CT_PAY_CostByUpdate  where cfperiod = '"+periodnum+"' and cfcitynumber='"+cityNumber+"'  and  cfdoctornumber in ("+empNums+") and (cfiszidai is null or cfiszidai = 0) union ");
			sqlCB.append(" 	select ( nvl(sum(cfxhcgjz),0) +nvl(sum(cfjgfcgjz),0)) as summ,'gdjz' as type  from  CT_PAY_CostByUpdate  where cfperiod = '"+periodnum+"' and cfcitynumber='"+cityNumber+"'   and  cfdoctornumber in ("+empNums+") and (cfiszidai is null or cfiszidai = 0)  union ");
			sqlCB.append(" 	select ( nvl(sum(cfxhknw),0) +nvl(sum(cfjgfknw),0)) as summ,'knw' as type  from  CT_PAY_CostByUpdate  where cfperiod = '"+periodnum+"' and cfcitynumber='"+cityNumber+"'    and  cfdoctornumber in ("+empNums+")and (cfiszidai is null or cfiszidai = 0)  union ");
			sqlCB.append(" 	select ( nvl(sum(cfxhxf),0) +nvl(sum(cfjgfxf),0)) as summ,'xf' as type  from  CT_PAY_CostByUpdate  where cfperiod = '"+periodnum+"'   and cfcitynumber='"+cityNumber+"' and  cfdoctornumber  in ("+empNums+") and (cfiszidai is null or cfiszidai = 0) union ");
			sqlCB.append(" 	select ( nvl(sum(cfxhey),0) +nvl(sum(cfjgfey),0)) as summ,'ey' as type  from  CT_PAY_CostByUpdate  where cfperiod = '"+periodnum+"'  and cfcitynumber='"+cityNumber+"'  and  cfdoctornumber  in ("+empNums+") and (cfiszidai is null or cfiszidai = 0) union ");
			sqlCB.append(" 	select ( nvl(sum(cfxhyz),0) +nvl(sum(cfjgfyz),0)) as summ,'yz' as type  from  CT_PAY_CostByUpdate  where cfperiod = '"+periodnum+"' and cfcitynumber='"+cityNumber+"'   and  cfdoctornumber in ("+empNums+")  and (cfiszidai is null or cfiszidai = 0) union ");
			sqlCB.append(" 	select ( nvl(sum(cfjgfmb),0) +nvl(sum(cfxhmb),0) ) as summ,'mb' as type  from  CT_PAY_CostByUpdate  where cfperiod = '"+periodnum+"'  and cfcitynumber='"+cityNumber+"'  and  cfdoctornumber in ("+empNums+") and (cfiszidai is null or cfiszidai = 0)  ");
			
		}
		
		
		return sqlCB;
	}
	
	public StringBuffer getImportChengBenSql(String empNums, String cityID,String periodnum,StringBuffer sqlCB){ 
		sqlCB.append(" /*dialect*/select ( nvl(sum(cfzjcost),0) ) as summ,'zz' as type   FROM  CT_PAY_DoctorCosts  where CFBUSINESSDATE ='"+periodnum+"' and cfcityid='"+cityID+"'  and  cfempNumber in ("+empNums+") and (cfiszidai is null or cfiszidai = 0) ");
		sqlCB.append(" union select ( nvl(sum(cfyxcost),0) ) as summ,'yxjz' as type   FROM CT_PAY_DoctorCosts  where CFBUSINESSDATE ='"+periodnum+"'   and cfcityid='"+cityID+"' and  cfempNumber in ("+empNums+")and (cfiszidai is null or cfiszidai = 0) ");
		sqlCB.append(" 	 union select ( nvl(sum(cfgdcost),0) ) as summ,'gdjz' as type   FROM CT_PAY_DoctorCosts  where CFBUSINESSDATE ='"+periodnum+"'  and cfcityid='"+cityID+"'  and  cfempNumber in ("+empNums+") and (cfiszidai is null or cfiszidai = 0) ");
		sqlCB.append(" 	 union select ( nvl(sum(cfkncost),0)) as summ,'knw' as type   FROM CT_PAY_DoctorCosts  where CFBUSINESSDATE ='"+periodnum+"' and cfcityid='"+cityID+"'  and  cfempNumber in ("+empNums+") and (cfiszidai is null or cfiszidai = 0)  ");
		sqlCB.append(" 	 union select ( nvl(sum(cfxfcost),0) ) as summ,'xf' as type   FROM CT_PAY_DoctorCosts  where CFBUSINESSDATE ='"+periodnum+"' and cfcityid='"+cityID+"'  and  cfempNumber in ("+empNums+") and (cfiszidai is null or cfiszidai = 0) ");
		sqlCB.append(" 	 union select ( nvl(sum(cfeycost),0)) as summ,'ey' as type   FROM CT_PAY_DoctorCosts  where CFBUSINESSDATE ='"+periodnum+"'  and cfcityid='"+cityID+"'  and  cfempNumber in ("+empNums+") and (cfiszidai is null or cfiszidai = 0)  ");
		sqlCB.append(" 	 union select ( nvl(sum(cfzbcost),0)) as summ,'yz' as type   FROM CT_PAY_DoctorCosts  where CFBUSINESSDATE ='"+periodnum+"'  and cfcityid='"+cityID+"' and  cfempNumber in ("+empNums+") and (cfiszidai is null or cfiszidai = 0) ");
		sqlCB.append(" 	 union select ( nvl(sum(cfmbcost),0)) as summ,'mb' as type  FROM CT_PAY_DoctorCosts  where CFBUSINESSDATE ='"+periodnum+"'  and cfcityid='"+cityID+"' and  cfempNumber in ("+empNums+") and (cfiszidai is null or cfiszidai = 0) ");
		
		return sqlCB;
	}
	
	
	
	/**
	 * 统计兼职医生自带患者的业绩
	 * @param empNum
	 * @param clinicNumber
	 * @param periodnum
	 * @param empName
	 * @return
	 */
	public  static StringBuffer getZiDaiYeJiSql(String empNum, String cityNumber,String periodnum,String empName,BigDecimal zj,String cityId){
		StringBuffer sqlYJ = new StringBuffer(); 
		sqlYJ.append("  /*dialect*/ SELECT nvl(sum(CFINCOME),0) as summ,'zz' as type FROM  CT_PAY_AchieveDetailTem  where CFSecSource = '自带' and  CFFirClassNumber='3' and  CFRecDotNumber ='"+empNum+"'  and CFCityNumber='"+cityNumber+"'and  to_char(fbizdate,'YYYYMM') ='"+periodnum+"'   ");
		sqlYJ.append("  union SELECT nvl(sum(CFINCOME)*"+zj+",0) as summ,'gdjz' as type FROM  CT_PAY_AchieveDetailTem where CFSecSource = '自带' and  CFFirClassNumber='4'  and CFIsRoutine='是'  and  CFRecDotNumber ='"+empNum+"'  and CFCityNumber='"+cityNumber+"' and  to_char(fbizdate,'YYYYMM') ='"+periodnum+"' and not exists ( SELECT 1 FROM  CT_SRQ_ClinicItem clinicItem left join  CT_SRQ_ClinicItemEntry  entry  on clinicItem.fid = entry.fparentid  left join CT_SRQ_PayItem payItem on payItem.fid = entry.cfitemid  where clinicItem.cfcityid = '"+cityId+"' and  clinicItem.cfproject = '口内外正畸' and   CT_PAY_AchieveDetailTem.CFFeeItemDetailNumber = payItem.fnumber) ");
		sqlYJ.append("  union SELECT nvl(sum(CFINCOME)*"+zj+",0) as summ,'yxjz' as type FROM  CT_PAY_AchieveDetailTem where CFSecSource = '自带' and  CFFirClassNumber='4'  and CFIsRoutine='否'  and  CFRecDotNumber ='"+empNum+"'  and CFCityNumber='"+cityNumber+"' and  to_char(fbizdate,'YYYYMM') ='"+periodnum+"' and not exists ( SELECT 1 FROM  CT_SRQ_ClinicItem clinicItem left join  CT_SRQ_ClinicItemEntry  entry  on clinicItem.fid = entry.fparentid  left join CT_SRQ_PayItem payItem on payItem.fid = entry.cfitemid  where clinicItem.cfcityid = '"+cityId+"' and  clinicItem.cfproject = '口内外正畸' and   CT_PAY_AchieveDetailTem.CFFeeItemDetailNumber = payItem.fnumber) ");
		sqlYJ.append("  union SELECT nvl(sum(CFINCOME),0) as summ,'yz' as type FROM  CT_PAY_AchieveDetailTem where CFSecSource = '自带'     and CFSecClassnumber='45'  and  CFRecDotNumber ='"+empNum+"'  and CFCityNumber='"+cityNumber+"' and  to_char(fbizdate,'YYYYMM') ='"+periodnum+"' and exists ( SELECT 1 FROM  CT_SRQ_ClinicItem clinicItem left join  CT_SRQ_ClinicItemEntry  entry  on clinicItem.fid = entry.fparentid  left join CT_SRQ_PayItem payItem on payItem.fid = entry.cfitemid  where clinicItem.cfcityid = '"+cityId+"' and  clinicItem.cfproject = '牙周' and   CT_PAY_AchieveDetailTem.CFFeeItemDetailNumber = payItem.fnumber) ");
		sqlYJ.append("  union SELECT nvl(sum(CFINCOME),0) as summ,'knw' as type FROM  CT_PAY_AchieveDetailTem where CFSecSource = '自带'  and  CFRecDotNumber ='"+empNum+"'  and CFCityNumber='"+cityNumber+"' and  to_char(fbizdate,'YYYYMM') ='"+periodnum+"'  and exists ( SELECT 1 FROM  CT_SRQ_ClinicItem clinicItem left join  CT_SRQ_ClinicItemEntry  entry  on clinicItem.fid = entry.fparentid  left join CT_SRQ_PayItem payItem on payItem.fid = entry.cfitemid  where clinicItem.cfcityid = '"+cityId+"' and  clinicItem.cfproject = '口内外' and   CT_PAY_AchieveDetailTem.CFFeeItemDetailNumber = payItem.fnumber)  ");
		sqlYJ.append("  union SELECT nvl(sum(CFINCOME),0) as summ,'mb' as type FROM  CT_PAY_AchieveDetailTem where CFSecSource = '自带' and  CFFirClassNumber='7'  and CFSecClassnumber='43' and  CFRecDotNumber ='"+empNum+"'  and CFCityNumber='"+cityNumber+"' and  to_char(fbizdate,'YYYYMM') ='"+periodnum+"'  ");
		sqlYJ.append("  union SELECT nvl(sum(CFINCOME),0) as summ,'xf' as type FROM  CT_PAY_AchieveDetailTem where CFSecSource = '自带' and  CFFirClassNumber='2'  and  CFRecDotNumber ='"+empNum+"'  and CFCityNumber='"+cityNumber+"' and  to_char(fbizdate,'YYYYMM') ='"+periodnum+"'  ");
		sqlYJ.append("  union SELECT nvl(sum(CFINCOME),0) as summ,'ey' as type FROM  CT_PAY_AchieveDetailTem where CFSecSource = '自带'  and  CFFirClassNumber='6'  and  CFRecDotNumber ='"+empNum+"'  and CFCityNumber='"+cityNumber+"' and  to_char(fbizdate,'YYYYMM') ='"+periodnum+"'  ");
		
		return sqlYJ;
	}
	
	/**
	 * 统计兼职医生非自带患者的业绩
	 * @param empNum
	 * @param clinicNumber
	 * @param periodnum
	 * @param sqlYJ
	 * @return
	 */	
	public static StringBuffer getFeiZiDaiSql(String empNum, String cityNumber,String periodnum,String empName,BigDecimal zj,String cityId){
		StringBuffer sqlYJ = new StringBuffer(); 
		//种植
		sqlYJ.append("  /*dialect*/ select aa.summ,'zz' as type from ( ");
		sqlYJ.append(" select sum(a.allm) as summ from ( ");
		sqlYJ.append(" SELECT nvl((sum(CFINCOME)*0.9),0) as allm FROM  CT_PAY_AchieveDetailTem where  CFFIRSOURCE = '渠道推广' and CFSecSource != '自带'  and  CFFirClassNumber='3' and  CFRecDotNumber ='"+empNum+"'  and CFCityNumber='"+cityNumber+"' and  to_char(fbizdate,'YYYYMM') ='"+periodnum+"'  ");
		sqlYJ.append(" union  SELECT  nvl((sum(CFINCOME)*0.82),0) as allm FROM  CT_PAY_AchieveDetailTem  where  CFTerSource = '老吾老' and CFSecSource != '自带'  and  CFFirClassNumber='3'  and   CFRecDotNumber ='"+empNum+"'  and CFCityNumber='"+cityNumber+"' and  to_char(fbizdate,'YYYYMM') ='"+periodnum+"'   ");
		sqlYJ.append(" union  SELECT  nvl(sum(CFINCOME),0) as allm FROM  CT_PAY_AchieveDetailTem  where  ((CFTerSource != '老吾老'  and   CFSecSource != '自带' ) or CFTerSource is null )  and CFFIRSOURCE != '渠道推广'   and  CFFirClassNumber='3'  and   CFRecDotNumber ='"+empNum+"'  and CFCityNumber='"+cityNumber+"' and  to_char(fbizdate,'YYYYMM') ='"+periodnum+"'   ");
		sqlYJ.append(" ) a ) aa ");
		sqlYJ.append(" union ");
		//固定矫正
		sqlYJ.append(" select bb.summ,'gdjz' as type from (select sum(b.allm) as summ from (");
		sqlYJ.append(" SELECT nvl((sum(CFINCOME)*0.9*"+zj+"),0) as allm FROM  CT_PAY_AchieveDetailTem where  CFFIRSOURCE = '渠道推广' and  CFSecSource != '自带'  and  CFFirClassNumber='4'  and CFIsRoutine='是'  and   CFRecDotNumber ='"+empNum+"'  and CFCityNumber='"+cityNumber+"' and  to_char(fbizdate,'YYYYMM') ='"+periodnum+"'  and not exists ( SELECT 1 FROM  CT_SRQ_ClinicItem clinicItem left join  CT_SRQ_ClinicItemEntry  entry  on clinicItem.fid = entry.fparentid  left join CT_SRQ_PayItem payItem on payItem.fid = entry.cfitemid  where clinicItem.cfcityid = '"+cityId+"' and  clinicItem.cfproject = '口内外正畸' and   CT_PAY_AchieveDetailTem.CFFeeItemDetailNumber = payItem.fnumber)  ");
		sqlYJ.append(" union  SELECT  nvl((sum(CFINCOME)*0.82*"+zj+"),0) as allm FROM  CT_PAY_AchieveDetailTem  where  CFTerSource = '老吾老'  and  CFSecSource != '自带' and  CFFirClassNumber='4'  and CFIsRoutine='是'  and   CFRecDotNumber ='"+empNum+"'  and CFCityNumber='"+cityNumber+"' and  to_char(fbizdate,'YYYYMM') ='"+periodnum+"' and not exists ( SELECT 1 FROM  CT_SRQ_ClinicItem clinicItem left join  CT_SRQ_ClinicItemEntry  entry  on clinicItem.fid = entry.fparentid  left join CT_SRQ_PayItem payItem on payItem.fid = entry.cfitemid  where clinicItem.cfcityid = '"+cityId+"' and  clinicItem.cfproject = '口内外正畸' and   CT_PAY_AchieveDetailTem.CFFeeItemDetailNumber = payItem.fnumber)   ");
		sqlYJ.append(" union  SELECT  nvl(sum(CFINCOME)*"+zj+",0) as allm FROM  CT_PAY_AchieveDetailTem  where   ((CFTerSource != '老吾老'  and   CFSecSource != '自带' )  or CFTerSource is null ) and CFFIRSOURCE !=  '渠道推广'    and  CFFirClassNumber='4'  and CFIsRoutine='是'  and   CFRecDotNumber ='"+empNum+"'  and CFCityNumber='"+cityNumber+"' and  to_char(fbizdate,'YYYYMM') ='"+periodnum+"' and not exists ( SELECT 1 FROM  CT_SRQ_ClinicItem clinicItem left join  CT_SRQ_ClinicItemEntry  entry  on clinicItem.fid = entry.fparentid  left join CT_SRQ_PayItem payItem on payItem.fid = entry.cfitemid  where clinicItem.cfcityid = '"+cityId+"' and  clinicItem.cfproject = '口内外正畸' and   CT_PAY_AchieveDetailTem.CFFeeItemDetailNumber = payItem.fnumber)  ");
		sqlYJ.append(" ) b) bb ");
		sqlYJ.append(" union ");
		//隐形矫正
		sqlYJ.append(" select cc.summ,'yxjz' as type from (select sum(c.allm) as summ from ( ");
		sqlYJ.append(" SELECT nvl((sum(CFINCOME)*0.9*"+zj+"),0) as allm FROM  CT_PAY_AchieveDetailTem where  CFFIRSOURCE = '渠道推广'  and   CFSecSource != '自带'  and  CFFirClassNumber='4'  and CFIsRoutine='否'  and   CFRecDotNumber ='"+empNum+"'  and CFCityNumber='"+cityNumber+"' and  to_char(fbizdate,'YYYYMM') ='"+periodnum+"'  and not exists ( SELECT 1 FROM  CT_SRQ_ClinicItem clinicItem left join  CT_SRQ_ClinicItemEntry  entry  on clinicItem.fid = entry.fparentid  left join CT_SRQ_PayItem payItem on payItem.fid = entry.cfitemid  where clinicItem.cfcityid = '"+cityId+"' and  clinicItem.cfproject = '口内外正畸' and   CT_PAY_AchieveDetailTem.CFFeeItemDetailNumber = payItem.fnumber)  ");
		sqlYJ.append(" union  SELECT  nvl((sum(CFINCOME)*0.82*"+zj+"),0) as allm FROM  CT_PAY_AchieveDetailTem  where  CFTerSource = '老吾老'  and CFSecSource != '自带' and  CFFirClassNumber='4'  and CFIsRoutine='否'   and   CFRecDotNumber ='"+empNum+"'  and CFCityNumber='"+cityNumber+"' and  to_char(fbizdate,'YYYYMM') ='"+periodnum+"'  and not exists ( SELECT 1 FROM  CT_SRQ_ClinicItem clinicItem left join  CT_SRQ_ClinicItemEntry  entry  on clinicItem.fid = entry.fparentid  left join CT_SRQ_PayItem payItem on payItem.fid = entry.cfitemid  where clinicItem.cfcityid = '"+cityId+"' and  clinicItem.cfproject = '口内外正畸' and   CT_PAY_AchieveDetailTem.CFFeeItemDetailNumber = payItem.fnumber)   ");
		sqlYJ.append(" union  SELECT  nvl(sum(CFINCOME)*"+zj+",0) as allm FROM  CT_PAY_AchieveDetailTem  where   ((CFTerSource != '老吾老'    and CFSecSource != '自带' )  or CFTerSource is null )  and CFFIRSOURCE !=  '渠道推广'    and  CFFirClassNumber='4'  and CFIsRoutine='否'   and   CFRecDotNumber ='"+empNum+"'  and CFCityNumber='"+cityNumber+"' and  to_char(fbizdate,'YYYYMM') ='"+periodnum+"' and not exists ( SELECT 1 FROM  CT_SRQ_ClinicItem clinicItem left join  CT_SRQ_ClinicItemEntry  entry  on clinicItem.fid = entry.fparentid  left join CT_SRQ_PayItem payItem on payItem.fid = entry.cfitemid  where clinicItem.cfcityid = '"+cityId+"' and  clinicItem.cfproject = '口内外正畸' and   CT_PAY_AchieveDetailTem.CFFeeItemDetailNumber = payItem.fnumber)   ");
		sqlYJ.append(" ) c) cc ");
		sqlYJ.append(" union ");
		//牙周
		sqlYJ.append(" select dd.summ,'yz' as type from (select sum(d.allm) as summ from ( ");
		sqlYJ.append(" SELECT nvl((sum(CFINCOME)*0.9),0) as allm FROM  CT_PAY_AchieveDetailTem where  CFFIRSOURCE = '渠道推广'  and CFSecSource != '自带'    and   CFRecDotNumber ='"+empNum+"'  and CFCityNumber='"+cityNumber+"' and  to_char(fbizdate,'YYYYMM') ='"+periodnum+"' and exists ( SELECT 1 FROM  CT_SRQ_ClinicItem clinicItem left join  CT_SRQ_ClinicItemEntry  entry  on clinicItem.fid = entry.fparentid  left join CT_SRQ_PayItem payItem on payItem.fid = entry.cfitemid  where clinicItem.cfcityid = '"+cityId+"' and  clinicItem.cfproject = '牙周' and   CT_PAY_AchieveDetailTem.CFFeeItemDetailNumber = payItem.fnumber)  ");
		sqlYJ.append(" union  SELECT  nvl((sum(CFINCOME)*0.82),0) as allm FROM  CT_PAY_AchieveDetailTem  where  CFTerSource = '老吾老' and CFSecSource != '自带'  and   CFRecDotNumber ='"+empNum+"'  and CFCityNumber='"+cityNumber+"' and  to_char(fbizdate,'YYYYMM') ='"+periodnum+"' and exists ( SELECT 1 FROM  CT_SRQ_ClinicItem clinicItem left join  CT_SRQ_ClinicItemEntry  entry  on clinicItem.fid = entry.fparentid  left join CT_SRQ_PayItem payItem on payItem.fid = entry.cfitemid  where clinicItem.cfcityid = '"+cityId+"' and  clinicItem.cfproject = '牙周' and   CT_PAY_AchieveDetailTem.CFFeeItemDetailNumber = payItem.fnumber)  ");
		sqlYJ.append(" union  SELECT  nvl(sum(CFINCOME),0) as allm FROM  CT_PAY_AchieveDetailTem  where   ((CFTerSource != '老吾老'  and CFSecSource != '自带' )  or CFTerSource is null )  and CFFIRSOURCE !=  '渠道推广'       and   CFRecDotNumber ='"+empNum+"'  and CFCityNumber='"+cityNumber+"' and  to_char(fbizdate,'YYYYMM') ='"+periodnum+"' and exists ( SELECT 1 FROM  CT_SRQ_ClinicItem clinicItem left join  CT_SRQ_ClinicItemEntry  entry  on clinicItem.fid = entry.fparentid  left join CT_SRQ_PayItem payItem on payItem.fid = entry.cfitemid  where clinicItem.cfcityid = '"+cityId+"' and  clinicItem.cfproject = '牙周' and   CT_PAY_AchieveDetailTem.CFFeeItemDetailNumber = payItem.fnumber)   ");
		sqlYJ.append(" ) d) dd ");
		sqlYJ.append(" union ");
		//口内外
		/*sqlYJ.append(" select ee.summ,'knw' as type from (select sum(e.allm) as summ from ( ");
		sqlYJ.append(" SELECT nvl((sum(CFINCOME)*0.9),0) as allm FROM  CT_PAY_AchieveDetailTem where  CFFIRSOURCE = '渠道推广'  and CFTERSOURCE != '"+empName+"'   and  CFFirClassNumber='1'  and CFSecClassnumber in ('762','646')  and   CFRecDotNumber ='"+empNum+"'  and CFClinicNumber='"+clinicNumber+"' and  to_char(fbizdate,'YYYYMM') ='"+periodnum+"'  ");
		sqlYJ.append(" union  SELECT  nvl((sum(CFINCOME)*0.82),0) as allm FROM  CT_PAY_AchieveDetailTem  where  CFTerSource = '老吾老'  and CFTERSOURCE != '"+empName+"'  and  CFFirClassNumber='1'  and CFSecClassnumber in ('762','646')  and   CFRecDotNumber ='"+empNum+"'  and CFClinicNumber='"+clinicNumber+"' and  to_char(fbizdate,'YYYYMM') ='"+periodnum+"'  ");
		sqlYJ.append(" union  SELECT  nvl(sum(CFINCOME),0) as allm FROM  CT_PAY_AchieveDetailTem  where   (CFTerSource != '老吾老' or CFTerSource is null )  and CFFIRSOURCE !=  '渠道推广' and CFTERSOURCE != '"+empName+"'   and  CFFirClassNumber='1'  and CFSecClassnumber in ('762','646')  and   CFRecDotNumber ='"+empNum+"'  and CFClinicNumber='"+clinicNumber+"' and  to_char(fbizdate,'YYYYMM') ='"+periodnum+"'   ");
		sqlYJ.append(" ) e) ee ");
		sqlYJ.append(" union ");*/
		sqlYJ.append(" select ee.summ,'knw' as type from (select sum(e.allm) as summ from ( ");
		sqlYJ.append(" SELECT nvl((sum(CFINCOME)*0.9),0) as allm FROM  CT_PAY_AchieveDetailTem where  CFFIRSOURCE = '渠道推广'  and CFSecSource != '自带'   and   CFRecDotNumber ='"+empNum+"'  and CFCityNumber='"+cityNumber+"' and  to_char(fbizdate,'YYYYMM') ='"+periodnum+"' and exists ( SELECT 1 FROM  CT_SRQ_ClinicItem clinicItem left join  CT_SRQ_ClinicItemEntry  entry  on clinicItem.fid = entry.fparentid  left join CT_SRQ_PayItem payItem on payItem.fid = entry.cfitemid  where clinicItem.cfcityid = '"+cityId+"' and  clinicItem.cfproject = '口内外' and   CT_PAY_AchieveDetailTem.CFFeeItemDetailNumber = payItem.fnumber) ");
		sqlYJ.append(" union  SELECT  nvl((sum(CFINCOME)*0.82),0) as allm FROM  CT_PAY_AchieveDetailTem  where  CFTerSource = '老吾老'  and CFSecSource != '自带'   and   CFRecDotNumber ='"+empNum+"'  and CFCityNumber='"+cityNumber+"' and  to_char(fbizdate,'YYYYMM') ='"+periodnum+"' and exists ( SELECT 1 FROM  CT_SRQ_ClinicItem clinicItem left join  CT_SRQ_ClinicItemEntry  entry  on clinicItem.fid = entry.fparentid  left join CT_SRQ_PayItem payItem on payItem.fid = entry.cfitemid  where clinicItem.cfcityid = '"+cityId+"' and  clinicItem.cfproject = '口内外' and   CT_PAY_AchieveDetailTem.CFFeeItemDetailNumber = payItem.fnumber) ");
		sqlYJ.append(" union  SELECT  nvl(sum(CFINCOME),0) as allm FROM  CT_PAY_AchieveDetailTem  where   ((CFTerSource != '老吾老'  and CFSecSource != '自带' )  or CFTerSource is null )  and CFFIRSOURCE !=  '渠道推广'    and   CFRecDotNumber ='"+empNum+"'  and CFCityNumber='"+cityNumber+"' and  to_char(fbizdate,'YYYYMM') ='"+periodnum+"' and exists ( SELECT 1 FROM  CT_SRQ_ClinicItem clinicItem left join  CT_SRQ_ClinicItemEntry  entry  on clinicItem.fid = entry.fparentid  left join CT_SRQ_PayItem payItem on payItem.fid = entry.cfitemid  where clinicItem.cfcityid = '"+cityId+"' and  clinicItem.cfproject = '口内外' and   CT_PAY_AchieveDetailTem.CFFeeItemDetailNumber = payItem.fnumber)  ");
		sqlYJ.append(" ) e) ee ");
		sqlYJ.append(" union ");
		// 美白
		sqlYJ.append(" select ff.summ,'mb' as type from (select sum(f.allm) as summ from ( ");
		sqlYJ.append(" SELECT nvl((sum(CFINCOME)*0.9),0) as allm FROM  CT_PAY_AchieveDetailTem where  CFFIRSOURCE = '渠道推广' and  CFSecSource != '自带' and CFFirClassNumber='7'  and CFSecClassnumber='43' and   CFRecDotNumber ='"+empNum+"'  and CFCityNumber='"+cityNumber+"' and  to_char(fbizdate,'YYYYMM') ='"+periodnum+"'   ");
		sqlYJ.append(" union  SELECT  nvl((sum(CFINCOME)*0.82),0) as allm FROM  CT_PAY_AchieveDetailTem  where  CFTerSource = '老吾老' and CFSecSource != '自带' and CFFirClassNumber='7'  and CFSecClassnumber='43'and   CFRecDotNumber ='"+empNum+"'  and CFCityNumber='"+cityNumber+"' and  to_char(fbizdate,'YYYYMM') ='"+periodnum+"'  ");
		sqlYJ.append(" union  SELECT  nvl(sum(CFINCOME),0) as allm FROM  CT_PAY_AchieveDetailTem  where   ((CFTerSource != '老吾老'  and CFSecSource != '自带' )  or CFTerSource is null )  and CFFIRSOURCE !=  '渠道推广' and  CFFirClassNumber='7'  and CFSecClassnumber='43' and   CFRecDotNumber ='"+empNum+"'  and CFCityNumber='"+cityNumber+"' and  to_char(fbizdate,'YYYYMM') ='"+periodnum+"'  ");
		sqlYJ.append(" ) f) ff ");
		sqlYJ.append(" union ");
		//修复
		sqlYJ.append(" select gg.summ,'xf' as type from (select sum(g.allm) as summ from ( ");
		sqlYJ.append(" SELECT nvl((sum(CFINCOME)*0.9),0) as allm FROM  CT_PAY_AchieveDetailTem where  CFFIRSOURCE = '渠道推广'  and CFSecSource != '自带'  and  CFFirClassNumber='2'  and   CFRecDotNumber ='"+empNum+"'  and CFCityNumber='"+cityNumber+"' and  to_char(fbizdate,'YYYYMM') ='"+periodnum+"'   ");
		sqlYJ.append(" union  SELECT  nvl((sum(CFINCOME)*0.82),0) as allm FROM  CT_PAY_AchieveDetailTem  where  CFTerSource = '老吾老'  and CFSecSource != '自带'  and  CFFirClassNumber='2'  and   CFRecDotNumber ='"+empNum+"'  and CFCityNumber='"+cityNumber+"' and  to_char(fbizdate,'YYYYMM') ='"+periodnum+"'  ");
		sqlYJ.append(" union  SELECT  nvl(sum(CFINCOME),0) as allm FROM  CT_PAY_AchieveDetailTem  where  ((CFTerSource != '老吾老'  and CFSecSource != '自带' )  or CFTerSource is null )   and  CFFirClassNumber='2'  and CFFIRSOURCE !=  '渠道推广' and   CFRecDotNumber ='"+empNum+"'  and CFCityNumber='"+cityNumber+"' and  to_char(fbizdate,'YYYYMM') ='"+periodnum+"'  ");
		sqlYJ.append(" ) g) gg ");
		sqlYJ.append(" union ");
		// 儿牙
		sqlYJ.append(" select hh.summ,'ey' as type from (select sum(h.allm) as summ from ( ");
		sqlYJ.append(" SELECT nvl((sum(CFINCOME)*0.9),0) as allm FROM  CT_PAY_AchieveDetailTem where  CFFIRSOURCE = '渠道推广'  and CFSecSource != '自带'and  CFFirClassNumber='6'  and   CFRecDotNumber ='"+empNum+"'  and CFCityNumber='"+cityNumber+"' and  to_char(fbizdate,'YYYYMM') ='"+periodnum+"'   ");
		sqlYJ.append(" union  SELECT  nvl((sum(CFINCOME)*0.82),0) as allm FROM  CT_PAY_AchieveDetailTem  where  CFTerSource = '老吾老'  and CFSecSource != '自带'  and  CFFirClassNumber='6'  and   CFRecDotNumber ='"+empNum+"'  and CFCityNumber='"+cityNumber+"' and  to_char(fbizdate,'YYYYMM') ='"+periodnum+"'  ");
		sqlYJ.append(" union  SELECT  nvl(sum(CFINCOME),0) as allm FROM  CT_PAY_AchieveDetailTem  where   ((CFTerSource != '老吾老'  and CFSecSource != '自带' )  or CFTerSource is null ) and CFFIRSOURCE !=  '渠道推广'    and  CFFirClassNumber='6'  and   CFRecDotNumber ='"+empNum+"'  and CFCityNumber='"+cityNumber+"' and  to_char(fbizdate,'YYYYMM') ='"+periodnum+"'  ");
		sqlYJ.append(" ) h) hh ");

		return sqlYJ;
	}


	/**
	 * 统计特殊兼职医生 种植 的业绩
	 * @param empNum
	 * @param clinicNumber
	 * @param periodnum
	 * @param sqlYJ
	 * @return
	 */
	
	public static StringBuffer getZhongZhiSql(String empNum, String cityNumber,String periodnum,String empName,String cityId,HashMap map){
		    
		//高档
		String gd =  map.get("CFGDZZTPRICE").toString();
		//中档
		String zd =  map.get("CFZDZZTPRICE").toString();
		//低档
		String dd =  map.get("CFDDZZTPRICE").toString();
		//内提
		String nt =  map.get("CFNTPRICE").toString();
		//外提
		String wt =  map.get("CFWTPRICE").toString();
		//骨胶原
		String gjy =  map.get("CFGJYPRICE").toString();
		//大骨粉
		String dgf =  map.get("CFDGFPRICE").toString();
		//小骨粉
		String xgf =  map.get("CFXGFPRICE").toString();
		//大骨膜
		String fgm = map.get("CFDGMPRICE").toString();
		//小骨膜
		String xgm =  map.get("CFXGMPRICE").toString(); 
		StringBuffer sql = new StringBuffer(); 
		sql.append(" /*dialect*/  select nvl(sum(a.SUMM) ,0) as ALLSUM FROM ( select nvl( sum(cfincome),0)*"+gd+" as SUMM, 'gd' as TYPE from CT_PAY_AchieveDetailTem where CFRecDotNumber ='"+empNum+"'  and CFCityNumber='"+cityNumber+"' and  to_char(fbizdate,'YYYYMM') ='"+periodnum+"'  and   exists ( SELECT  1 FROM  CT_SRQ_ClinicItem clinicItem  ");
		sql.append(" left join  CT_SRQ_ClinicItemEntry  entry on clinicItem.fid = entry.fparentid  left join CT_SRQ_PayItem payItem on payItem.fid = entry.cfitemid  where clinicItem.cfcityid = '"+cityId+"' and  cfproject = '高档种植体'    and  CT_PAY_AchieveDetailTem.CFFeeItemDetailNumber = payItem.fnumber )  ");
		sql.append(" union  select nvl( sum(cfincome),0)*"+zd+" as SUMM, 'zd' as TYPE  from CT_PAY_AchieveDetailTem where CFRecDotNumber ='"+empNum+"'  and CFCityNumber='"+cityNumber+"' and   and  to_char(fbizdate,'YYYYMM') ='"+periodnum+"'  and exists( SELECT  1 FROM  CT_SRQ_ClinicItem clinicItem left join  CT_SRQ_ClinicItemEntry  entry   ");
		sql.append(" on clinicItem.fid = entry.fparentid  left join CT_SRQ_PayItem payItem on payItem.fid = entry.cfitemid  where clinicItem.cfcityid = '"+cityId+"' and  cfproject = '中档种植体'  and  CT_PAY_AchieveDetailTem.CFFeeItemDetailNumber = payItem.fnumber )  ");
		sql.append(" union  select nvl( sum(cfincome),0)*"+dd+" as SUMM, 'dd' as TYPE  from CT_PAY_AchieveDetailTem where  CFRecDotNumber ='"+empNum+"'  and CFCityNumber='"+cityNumber+"' and      to_char(fbizdate,'YYYYMM') ='"+periodnum+"'  and exists ( SELECT  1 FROM  CT_SRQ_ClinicItem clinicItem left join  CT_SRQ_ClinicItemEntry  entry   ");
		sql.append(" on clinicItem.fid = entry.fparentid  left join CT_SRQ_PayItem payItem on payItem.fid = entry.cfitemid  where clinicItem.cfcityid = '"+cityId+"=' and  cfproject = '低档种植体'  and  CT_PAY_AchieveDetailTem.CFFeeItemDetailNumber = payItem.fnumber )  ");
		sql.append(" union  select nvl( sum(cfincome),0)*"+nt+" as SUMM, 'nt' as TYPE  from CT_PAY_AchieveDetailTem where  CFRecDotNumber ='"+empNum+"'  and CFCityNumber='"+cityNumber+"' and      to_char(fbizdate,'YYYYMM') ='"+periodnum+"'  and exists ( SELECT  1 FROM  CT_SRQ_ClinicItem clinicItem left join  CT_SRQ_ClinicItemEntry  entry   ");
		sql.append(" on clinicItem.fid = entry.fparentid left join CT_SRQ_PayItem payItem on payItem.fid = entry.cfitemid  where clinicItem.cfcityid = '"+cityId+"=' and  cfproject = '内提手术费'  and  CT_PAY_AchieveDetailTem.CFFeeItemDetailNumber = payItem.fnumber )  ");
		sql.append(" union  select nvl( sum(cfincome),0)*"+wt+" as SUMM, 'wt' as TYPE  from CT_PAY_AchieveDetailTem where  CFRecDotNumber ='"+empNum+"'  and CFCityNumber='"+cityNumber+"' and  to_char(fbizdate,'YYYYMM') ='"+periodnum+"' and exists( SELECT  1 FROM  CT_SRQ_ClinicItem clinicItem left join  CT_SRQ_ClinicItemEntry  entry   ");
		sql.append(" on clinicItem.fid = entry.fparentid left join CT_SRQ_PayItem payItem on payItem.fid = entry.cfitemid  where clinicItem.cfcityid = '"+cityId+"=' and  cfproject = '外提手术费'  and  CT_PAY_AchieveDetailTem.CFFeeItemDetailNumber = payItem.fnumber )  ");
		sql.append(" union  select nvl( sum(cfincome),0)*"+gjy+" as SUMM, 'gjy' as TYPE  from CT_PAY_AchieveDetailTem where  CFRecDotNumber ='"+empNum+"'  and CFCityNumber='"+cityNumber+"' and  to_char(fbizdate,'YYYYMM') ='"+periodnum+"'  and exists ( SELECT  1 FROM  CT_SRQ_ClinicItem clinicItem left join  CT_SRQ_ClinicItemEntry  entry   ");
		sql.append(" on clinicItem.fid = entry.fparentid left join CT_SRQ_PayItem payItem on payItem.fid = entry.cfitemid  where clinicItem.cfcityid = '"+cityId+"=' and  cfproject = '骨胶原'  and  CT_PAY_AchieveDetailTem.CFFeeItemDetailNumber = payItem.fnumber )  ");
		sql.append(" union  select nvl( sum(cfincome),0)*"+xgf+" as SUMM, 'xgf' as TYPE  from CT_PAY_AchieveDetailTem where  CFRecDotNumber ='"+empNum+"'  and CFCityNumber='"+cityNumber+"' and  to_char(fbizdate,'YYYYMM') ='"+periodnum+"'  and exists ( SELECT  1 FROM  CT_SRQ_ClinicItem clinicItem left join  CT_SRQ_ClinicItemEntry  entry   ");
		sql.append(" on clinicItem.fid = entry.fparentid left join CT_SRQ_PayItem payItem on payItem.fid = entry.cfitemid  where clinicItem.cfcityid = '"+cityId+"=' and  cfproject = '小骨粉'  and  CT_PAY_AchieveDetailTem.CFFeeItemDetailNumber = payItem.fnumber )  ");
		sql.append(" union  select nvl( sum(cfincome),0)*"+dgf+" as SUMM, 'dgf' as TYPE  from CT_PAY_AchieveDetailTem where  CFRecDotNumber ='"+empNum+"'  and CFCityNumber='"+cityNumber+"' and  to_char(fbizdate,'YYYYMM') ='"+periodnum+"'  and exists ( SELECT  1 FROM  CT_SRQ_ClinicItem clinicItem left join  CT_SRQ_ClinicItemEntry  entry   ");
		sql.append(" on clinicItem.fid = entry.fparentid left join CT_SRQ_PayItem payItem on payItem.fid = entry.cfitemid  where clinicItem.cfcityid = '"+cityId+"=' and  cfproject = '大骨粉'  and  CT_PAY_AchieveDetailTem.CFFeeItemDetailNumber = payItem.fnumber )  ");
		sql.append(" union  select nvl( sum(cfincome),0)*"+xgm+" as SUMM, 'xgm' as TYPE  from CT_PAY_AchieveDetailTem where  CFRecDotNumber ='"+empNum+"'  and CFCityNumber='"+cityNumber+"'and  to_char(fbizdate,'YYYYMM') ='"+periodnum+"'  and exists ( SELECT  1 FROM  CT_SRQ_ClinicItem clinicItem left join  CT_SRQ_ClinicItemEntry  entry   ");
		sql.append(" on clinicItem.fid = entry.fparentid left join CT_SRQ_PayItem payItem on payItem.fid = entry.cfitemid  where clinicItem.cfcityid = '"+cityId+"=' and  cfproject = '小骨膜'   and  CT_PAY_AchieveDetailTem.CFFeeItemDetailNumber = payItem.fnumber) ");
		sql.append(" union  select nvl( sum(cfincome),0)*"+fgm+" as SUMM, 'dgm' as TYPE  from CT_PAY_AchieveDetailTem where  CFRecDotNumber ='"+empNum+"'  and CFCityNumber='"+cityNumber+"' and  to_char(fbizdate,'YYYYMM') ='"+periodnum+"'  and exists ( SELECT  1 FROM  CT_SRQ_ClinicItem clinicItem left join  CT_SRQ_ClinicItemEntry  entry   ");
		sql.append(" on clinicItem.fid = entry.fparentid left join CT_SRQ_PayItem payItem on payItem.fid = entry.cfitemid  where clinicItem.cfcityid = '"+cityId+"=' and  cfproject = '大骨膜'  and  CT_PAY_AchieveDetailTem.CFFeeItemDetailNumber = payItem.fnumber ) ) a  ");
		
		return sql;
	}
	
	public  static StringBuffer getOtherAllSql(String empNum, String cityNumber,String periodnum,String empName,String cityId,BigDecimal zj,HashMap map){
	    
		StringBuffer sqlYJ = new StringBuffer(); 
		//种植
		sqlYJ.append("  /*dialect*/ select aa.summ,'zz' as type from ( ");
		sqlYJ.append(" select sum(a.allm) as summ from ( ");
		sqlYJ.append(" SELECT nvl((sum(CFINCOME)*0.9),0) as allm FROM  CT_PAY_AchieveDetailTem where  CFFIRSOURCE = '渠道推广'   and  CFFirClassNumber='3' and  CFRecDotNumber ='"+empNum+"'  and CFCityNumber='"+cityNumber+"' and  to_char(fbizdate,'YYYYMM') ='"+periodnum+"'   ");
		sqlYJ.append(" and CFFeeItemDetailNumber not IN ( SELECT  payItem.fnumber FROM  CT_SRQ_ClinicItem clinicItem left join  CT_SRQ_ClinicItemEntry  entry  on clinicItem.fid = entry.fparentid  left join CT_SRQ_PayItem payItem on payItem.fid = entry.cfitemid  ");
		sqlYJ.append("	where clinicItem.cfcityid = '"+cityId+"' and  cfproject in ('高档种植体','中档种植体','低档种植体','内提手术费','外提手术费','骨胶原','小骨粉','大骨粉','小骨膜','大骨膜' )) ");
		sqlYJ.append(" union  SELECT  nvl((sum(CFINCOME)*0.82),0) as allm FROM  CT_PAY_AchieveDetailTem  where  CFFIRSOURCE = '老吾老'   and  CFFirClassNumber='3'  and   CFRecDotNumber ='"+empNum+"'  and CFCityNumber='"+cityNumber+"' and  to_char(fbizdate,'YYYYMM') ='"+periodnum+"'   ");
		sqlYJ.append(" and CFFeeItemDetailNumber not IN ( SELECT  payItem.fnumber FROM  CT_SRQ_ClinicItem clinicItem left join  CT_SRQ_ClinicItemEntry  entry  on clinicItem.fid = entry.fparentid  left join CT_SRQ_PayItem payItem on payItem.fid = entry.cfitemid  ");
		sqlYJ.append("	where clinicItem.cfcityid = '"+cityId+"' and  cfproject in ('高档种植体','中档种植体','低档种植体','内提手术费','外提手术费','骨胶原','小骨粉','大骨粉','小骨膜','大骨膜' )) ");
		sqlYJ.append(" union  SELECT  nvl(sum(CFINCOME),0) as allm FROM  CT_PAY_AchieveDetailTem  where  ((CFTerSource != '老吾老'    )  or CFTerSource is null )   and CFFIRSOURCE != '渠道推广'   and  CFFirClassNumber='3'  and   CFRecDotNumber ='"+empNum+"'  and CFCityNumber='"+cityNumber+"' and  to_char(fbizdate,'YYYYMM') ='"+periodnum+"'   ");
		sqlYJ.append(" and CFFeeItemDetailNumber not IN ( SELECT  payItem.fnumber FROM  CT_SRQ_ClinicItem clinicItem left join  CT_SRQ_ClinicItemEntry  entry  on clinicItem.fid = entry.fparentid  left join CT_SRQ_PayItem payItem on payItem.fid = entry.cfitemid  ");
		sqlYJ.append("	where clinicItem.cfcityid = '"+cityId+"' and  cfproject in ('高档种植体','中档种植体','低档种植体','内提手术费','外提手术费','骨胶原','小骨粉','大骨粉','小骨膜','大骨膜' ))");
		sqlYJ.append(" ) a ) aa ");
		sqlYJ.append(" union ");
		//固定矫正
		
		sqlYJ.append(" select bb.summ,'gdjz' as type from (select sum(b.allm) as summ from (");
		sqlYJ.append(" SELECT nvl((sum(CFINCOME)*0.9*"+zj+"),0) as allm FROM  CT_PAY_AchieveDetailTem where  CFFIRSOURCE = '渠道推广'   and  CFFirClassNumber='4'  and CFIsRoutine='是'  and   CFRecDotNumber ='"+empNum+"'  and CFCityNumber='"+cityNumber+"' and  to_char(fbizdate,'YYYYMM') ='"+periodnum+"' and not exists ( SELECT 1 FROM  CT_SRQ_ClinicItem clinicItem left join  CT_SRQ_ClinicItemEntry  entry  on clinicItem.fid = entry.fparentid  left join CT_SRQ_PayItem payItem on payItem.fid = entry.cfitemid  where clinicItem.cfcityid = '"+cityId+"' and  clinicItem.cfproject = '口内外正畸' and   CT_PAY_AchieveDetailTem.CFFeeItemDetailNumber = payItem.fnumber)   ");
		sqlYJ.append(" union  SELECT  nvl((sum(CFINCOME)*0.82*"+zj+"),0) as allm FROM  CT_PAY_AchieveDetailTem  where  CFTerSource = '老吾老'    and  CFFirClassNumber='4'  and CFIsRoutine='是'  and   CFRecDotNumber ='"+empNum+"'  and CFCityNumber='"+cityNumber+"' and  to_char(fbizdate,'YYYYMM') ='"+periodnum+"' and not exists ( SELECT 1 FROM  CT_SRQ_ClinicItem clinicItem left join  CT_SRQ_ClinicItemEntry  entry  on clinicItem.fid = entry.fparentid  left join CT_SRQ_PayItem payItem on payItem.fid = entry.cfitemid  where clinicItem.cfcityid = '"+cityId+"' and  clinicItem.cfproject = '口内外正畸' and   CT_PAY_AchieveDetailTem.CFFeeItemDetailNumber = payItem.fnumber)   ");
		sqlYJ.append(" union  SELECT  nvl(sum(CFINCOME)*"+zj+",0) as allm FROM  CT_PAY_AchieveDetailTem  where  ((CFTerSource != '老吾老'  )  or CFTerSource is null )  and CFFIRSOURCE !=  '渠道推广'     and  CFFirClassNumber='4'  and CFIsRoutine='是'  and   CFRecDotNumber ='"+empNum+"'  and CFCityNumber='"+cityNumber+"' and  to_char(fbizdate,'YYYYMM') ='"+periodnum+"'  and not exists ( SELECT 1 FROM  CT_SRQ_ClinicItem clinicItem left join  CT_SRQ_ClinicItemEntry  entry  on clinicItem.fid = entry.fparentid  left join CT_SRQ_PayItem payItem on payItem.fid = entry.cfitemid  where clinicItem.cfcityid = '"+cityId+"' and  clinicItem.cfproject = '口内外正畸' and   CT_PAY_AchieveDetailTem.CFFeeItemDetailNumber = payItem.fnumber)  ");
		sqlYJ.append(" ) b) bb ");
		sqlYJ.append(" union ");
		//隐形矫正
		sqlYJ.append(" select cc.summ,'yxjz' as type from (select sum(c.allm) as summ from ( ");
		sqlYJ.append(" SELECT nvl((sum(CFINCOME)*0.9*"+zj+"),0) as allm FROM  CT_PAY_AchieveDetailTem where  CFFIRSOURCE = '渠道推广'    and  CFFirClassNumber='4'  and CFIsRoutine='否' and   CFRecDotNumber ='"+empNum+"'  and CFCityNumber='"+cityNumber+"' and  to_char(fbizdate,'YYYYMM') ='"+periodnum+"'  and not exists ( SELECT 1 FROM  CT_SRQ_ClinicItem clinicItem left join  CT_SRQ_ClinicItemEntry  entry  on clinicItem.fid = entry.fparentid  left join CT_SRQ_PayItem payItem on payItem.fid = entry.cfitemid  where clinicItem.cfcityid = '"+cityId+"' and  clinicItem.cfproject = '口内外正畸' and   CT_PAY_AchieveDetailTem.CFFeeItemDetailNumber = payItem.fnumber)  ");
		sqlYJ.append(" union  SELECT  nvl((sum(CFINCOME)*0.82*"+zj+"),0) as allm FROM  CT_PAY_AchieveDetailTem  where  CFTerSource = '老吾老'   and  CFFirClassNumber='4'  and CFIsRoutine='否'   and   CFRecDotNumber ='"+empNum+"'  and CFCityNumber='"+cityNumber+"' and  to_char(fbizdate,'YYYYMM') ='"+periodnum+"'  and not exists ( SELECT 1 FROM  CT_SRQ_ClinicItem clinicItem left join  CT_SRQ_ClinicItemEntry  entry  on clinicItem.fid = entry.fparentid  left join CT_SRQ_PayItem payItem on payItem.fid = entry.cfitemid  where clinicItem.cfcityid = '"+cityId+"' and  clinicItem.cfproject = '口内外正畸' and   CT_PAY_AchieveDetailTem.CFFeeItemDetailNumber = payItem.fnumber)   ");
		sqlYJ.append(" union  SELECT  nvl(sum(CFINCOME)*"+zj+",0) as allm FROM  CT_PAY_AchieveDetailTem  where  ((CFTerSource != '老吾老'   )  or CFTerSource is null )  and CFFIRSOURCE !=  '渠道推广'    and  CFFirClassNumber='4'  and CFIsRoutine='否'   and   CFRecDotNumber ='"+empNum+"'  and CFCityNumber='"+cityNumber+"' and  to_char(fbizdate,'YYYYMM') ='"+periodnum+"'  and not exists ( SELECT 1 FROM  CT_SRQ_ClinicItem clinicItem left join  CT_SRQ_ClinicItemEntry  entry  on clinicItem.fid = entry.fparentid  left join CT_SRQ_PayItem payItem on payItem.fid = entry.cfitemid  where clinicItem.cfcityid = '"+cityId+"' and  clinicItem.cfproject = '口内外正畸' and   CT_PAY_AchieveDetailTem.CFFeeItemDetailNumber = payItem.fnumber)  ");
		sqlYJ.append(" ) c) cc ");
		sqlYJ.append(" union ");
		//牙周
		sqlYJ.append(" select dd.summ,'yz' as type from (select sum(d.allm) as summ from ( ");
		sqlYJ.append(" SELECT nvl((sum(CFINCOME)*0.9),0) as allm FROM  CT_PAY_AchieveDetailTem where  CFFIRSOURCE = '渠道推广'    and     CFRecDotNumber ='"+empNum+"'  and CFCityNumber='"+cityNumber+"' and  to_char(fbizdate,'YYYYMM') ='"+periodnum+"'  and exists ( SELECT 1 FROM  CT_SRQ_ClinicItem clinicItem left join  CT_SRQ_ClinicItemEntry  entry  on clinicItem.fid = entry.fparentid  left join CT_SRQ_PayItem payItem on payItem.fid = entry.cfitemid  where clinicItem.cfcityid = '"+cityId+"' and  clinicItem.cfproject = '牙周' and   CT_PAY_AchieveDetailTem.CFFeeItemDetailNumber = payItem.fnumber) ");
		sqlYJ.append(" union  SELECT  nvl((sum(CFINCOME)*0.82),0) as allm FROM  CT_PAY_AchieveDetailTem  where  CFTerSource = '老吾老'   and     CFRecDotNumber ='"+empNum+"'  and CFCityNumber='"+cityNumber+"'and  to_char(fbizdate,'YYYYMM') ='"+periodnum+"'  and exists ( SELECT 1 FROM  CT_SRQ_ClinicItem clinicItem left join  CT_SRQ_ClinicItemEntry  entry  on clinicItem.fid = entry.fparentid  left join CT_SRQ_PayItem payItem on payItem.fid = entry.cfitemid  where clinicItem.cfcityid = '"+cityId+"' and  clinicItem.cfproject = '牙周' and   CT_PAY_AchieveDetailTem.CFFeeItemDetailNumber = payItem.fnumber)  ");
		sqlYJ.append(" union  SELECT  nvl(sum(CFINCOME),0) as allm FROM  CT_PAY_AchieveDetailTem  where   ((CFTerSource != '老吾老'   )  or CFTerSource is null ) and CFFIRSOURCE !=  '渠道推广'     and     CFRecDotNumber ='"+empNum+"'  and CFCityNumber='"+cityNumber+"' and  to_char(fbizdate,'YYYYMM') ='"+periodnum+"' ) and exists ( SELECT 1 FROM  CT_SRQ_ClinicItem clinicItem left join  CT_SRQ_ClinicItemEntry  entry  on clinicItem.fid = entry.fparentid  left join CT_SRQ_PayItem payItem on payItem.fid = entry.cfitemid  where clinicItem.cfcityid = '"+cityId+"' and  clinicItem.cfproject = '牙周' and   CT_PAY_AchieveDetailTem.CFFeeItemDetailNumber = payItem.fnumber)  ");
		sqlYJ.append(" ) d) dd ");
		sqlYJ.append(" union ");
		//口内外
		sqlYJ.append(" select ee.summ,'knw' as type from (select sum(e.allm) as summ from ( ");
		sqlYJ.append(" SELECT nvl((sum(CFINCOME)*0.9),0) as allm FROM  CT_PAY_AchieveDetailTem where  CFFIRSOURCE = '渠道推广'   and   CFRecDotNumber ='"+empNum+"'  and CFCityNumber='"+cityNumber+"' and  to_char(fbizdate,'YYYYMM') ='"+periodnum+"'  and exists ( SELECT 1 FROM  CT_SRQ_ClinicItem clinicItem left join  CT_SRQ_ClinicItemEntry  entry  on clinicItem.fid = entry.fparentid  left join CT_SRQ_PayItem payItem on payItem.fid = entry.cfitemid  where clinicItem.cfcityid = '"+cityId+"' and  clinicItem.cfproject = '口内外' and   CT_PAY_AchieveDetailTem.CFFeeItemDetailNumber = payItem.fnumber) ");
		sqlYJ.append(" union  SELECT  nvl((sum(CFINCOME)*0.82),0) as allm FROM  CT_PAY_AchieveDetailTem  where  CFTerSource = '老吾老'     and   CFRecDotNumber ='"+empNum+"'  and CFCityNumber='"+cityNumber+"' and  to_char(fbizdate,'YYYYMM') ='"+periodnum+"' and exists ( SELECT 1 FROM  CT_SRQ_ClinicItem clinicItem left join  CT_SRQ_ClinicItemEntry  entry  on clinicItem.fid = entry.fparentid  left join CT_SRQ_PayItem payItem on payItem.fid = entry.cfitemid  where clinicItem.cfcityid = '"+cityId+"' and  clinicItem.cfproject = '口内外' and   CT_PAY_AchieveDetailTem.CFFeeItemDetailNumber = payItem.fnumber) ");
		sqlYJ.append(" union  SELECT  nvl(sum(CFINCOME),0) as allm FROM  CT_PAY_AchieveDetailTem  where  ((CFTerSource != '老吾老'   )  or CFTerSource is null )  and CFFIRSOURCE !=  '渠道推广'    and   CFRecDotNumber ='"+empNum+"'  and CFCityNumber='"+cityNumber+"' and  to_char(fbizdate,'YYYYMM') ='"+periodnum+"' and exists ( SELECT 1 FROM  CT_SRQ_ClinicItem clinicItem left join  CT_SRQ_ClinicItemEntry  entry  on clinicItem.fid = entry.fparentid  left join CT_SRQ_PayItem payItem on payItem.fid = entry.cfitemid  where clinicItem.cfcityid = '"+cityId+"' and  clinicItem.cfproject = '口内外' and   CT_PAY_AchieveDetailTem.CFFeeItemDetailNumber = payItem.fnumber)  ");
		sqlYJ.append(" ) e) ee ");
		sqlYJ.append(" union ");
		// 美白
		sqlYJ.append(" select ff.summ,'mb' as type from (select sum(f.allm) as summ from ( ");
		sqlYJ.append(" SELECT nvl((sum(CFINCOME)*0.9),0) as allm FROM  CT_PAY_AchieveDetailTem where  CFFIRSOURCE = '渠道推广' and  CFFirClassNumber='7'  and CFSecClassnumber='43' and   CFRecDotNumber ='"+empNum+"'  and CFCityNumber='"+cityNumber+"' and  to_char(fbizdate,'YYYYMM') ='"+periodnum+"'  ");
		sqlYJ.append(" union  SELECT  nvl((sum(CFINCOME)*0.82),0) as allm FROM  CT_PAY_AchieveDetailTem  where  CFTerSource = '老吾老' and  CFFirClassNumber='7'  and CFSecClassnumber='43'and   CFRecDotNumber ='"+empNum+"'  and CFCityNumber='"+cityNumber+"' and  to_char(fbizdate,'YYYYMM') ='"+periodnum+"'  ");
		sqlYJ.append(" union  SELECT  nvl(sum(CFINCOME),0) as allm FROM  CT_PAY_AchieveDetailTem  where   ((CFTerSource != '老吾老'    )  or CFTerSource is null )  and CFFIRSOURCE !=  '渠道推广' and  CFFirClassNumber='7'  and CFSecClassnumber='43' and   CFRecDotNumber ='"+empNum+"'  and CFCityNumber='"+cityNumber+"' and  to_char(fbizdate,'YYYYMM') ='"+periodnum+"'  ");
		sqlYJ.append(" ) f) ff ");
		sqlYJ.append(" union ");
		//修复
		sqlYJ.append(" select gg.summ,'xf' as type from (select sum(g.allm) as summ from ( ");
		sqlYJ.append(" SELECT nvl((sum(CFINCOME)*0.9),0) as allm FROM  CT_PAY_AchieveDetailTem where  CFFIRSOURCE = '渠道推广'      and  CFFirClassNumber='2'  and   CFRecDotNumber ='"+empNum+"'  and CFCityNumber='"+cityNumber+"' and  to_char(fbizdate,'YYYYMM') ='"+periodnum+"'  ");
		sqlYJ.append(" union  SELECT  nvl((sum(CFINCOME)*0.82),0) as allm FROM  CT_PAY_AchieveDetailTem  where  CFTerSource = '老吾老'    and  CFFirClassNumber='2'  and   CFRecDotNumber ='"+empNum+"'  and CFCityNumber='"+cityNumber+"' and  to_char(fbizdate,'YYYYMM') ='"+periodnum+"'  ");
		sqlYJ.append(" union  SELECT  nvl(sum(CFINCOME),0) as allm FROM  CT_PAY_AchieveDetailTem  where   ((CFTerSource != '老吾老'   )  or CFTerSource is null )   and  CFFirClassNumber='2'  and CFFIRSOURCE !=  '渠道推广' and   CFRecDotNumber ='"+empNum+"'  and CFCityNumber='"+cityNumber+"' and  to_char(fbizdate,'YYYYMM') ='"+periodnum+"'  ");
		sqlYJ.append(" ) g) gg ");
		sqlYJ.append(" union ");
		// 儿牙
		sqlYJ.append(" select hh.summ,'ey' as type from (select sum(h.allm) as summ from ( ");
		sqlYJ.append(" SELECT nvl((sum(CFINCOME)*0.9),0) as allm FROM  CT_PAY_AchieveDetailTem where  CFFIRSOURCE = '渠道推广'  and  CFFirClassNumber='6'  and   CFRecDotNumber ='"+empNum+"'  and CFCityNumber='"+cityNumber+"' and  to_char(fbizdate,'YYYYMM') ='"+periodnum+"'   ");
		sqlYJ.append(" union  SELECT  nvl((sum(CFINCOME)*0.82),0) as allm FROM  CT_PAY_AchieveDetailTem  where  CFTerSource = '老吾老'    and  CFFirClassNumber='6'  and   CFRecDotNumber ='"+empNum+"'  and CFCityNumber='"+cityNumber+"' and  to_char(fbizdate,'YYYYMM') ='"+periodnum+"'  ");
		sqlYJ.append(" union  SELECT  nvl(sum(CFINCOME),0) as allm FROM  CT_PAY_AchieveDetailTem  where   ((CFTerSource != '老吾老'    )  or CFTerSource is null )  and CFFIRSOURCE !=  '渠道推广'     and  CFFirClassNumber='6'  and   CFRecDotNumber ='"+empNum+"'  and CFCityNumber='"+cityNumber+"' and  to_char(fbizdate,'YYYYMM') ='"+periodnum+"'  ");
		sqlYJ.append(" ) h) hh ");
		
		
		/*
		sqlYJ.append(" SELECT nvl((sum(CFINCOME)*0.9),0) as allm FROM  CT_PAY_AchieveDetailTem where  CFFIRSOURCE = '渠道推广' and CFTERSOURCE != '"+empName+"'  and  CFFirClassNumber='3' and  CFRecDotNumber ='"+empNum+"'  and CFClinicNumber='"+clinicNumber+"' and  to_char(fbizdate,'YYYYMM') ='"+periodnum+"'   ");
		sqlYJ.append(" and CFFeeItemDetailNumber not IN ( SELECT  payItem.fnumber FROM  CT_SRQ_ClinicItem clinicItem left join  CT_SRQ_ClinicItemEntry  entry  on clinicItem.fid = entry.fparentid  left join CT_SRQ_PayItem payItem on payItem.fid = entry.cfitemid  ");
		sqlYJ.append("	where clinicItem.cfcityid = '"+cityId+"' and  cfproject in ('高档种植体','中档种植体','低档种植体','内提手术费','外提手术费','骨胶原','小骨粉','大骨粉','小骨膜','大骨膜' )) ");
		sqlYJ.append(" union  SELECT  nvl((sum(CFINCOME)*0.82),0) as allm FROM  CT_PAY_AchieveDetailTem  where  CFFIRSOURCE = '老吾老' and CFTERSOURCE != '"+empName+"'  and  CFFirClassNumber='3'  and   CFRecDotNumber ='"+empNum+"'  and CFClinicNumber='"+clinicNumber+"' and  to_char(fbizdate,'YYYYMM') ='"+periodnum+"'   ");
		sqlYJ.append(" and CFFeeItemDetailNumber not IN ( SELECT  payItem.fnumber FROM  CT_SRQ_ClinicItem clinicItem left join  CT_SRQ_ClinicItemEntry  entry  on clinicItem.fid = entry.fparentid  left join CT_SRQ_PayItem payItem on payItem.fid = entry.cfitemid  ");
		sqlYJ.append("	where clinicItem.cfcityid = '"+cityId+"' and  cfproject in ('高档种植体','中档种植体','低档种植体','内提手术费','外提手术费','骨胶原','小骨粉','大骨粉','小骨膜','大骨膜' )) ");
		sqlYJ.append(" union  SELECT  nvl(sum(CFINCOME),0) as allm FROM  CT_PAY_AchieveDetailTem  where  ((CFTerSource != '老吾老'  and CFTERSOURCE != '"+empName+"' )  or CFTerSource is null )   and CFFIRSOURCE != '渠道推广'   and  CFFirClassNumber='3'  and   CFRecDotNumber ='"+empNum+"'  and CFClinicNumber='"+clinicNumber+"' and  to_char(fbizdate,'YYYYMM') ='"+periodnum+"'   ");
		sqlYJ.append(" and CFFeeItemDetailNumber not IN ( SELECT  payItem.fnumber FROM  CT_SRQ_ClinicItem clinicItem left join  CT_SRQ_ClinicItemEntry  entry  on clinicItem.fid = entry.fparentid  left join CT_SRQ_PayItem payItem on payItem.fid = entry.cfitemid  ");
		sqlYJ.append("	where clinicItem.cfcityid = '"+cityId+"' and  cfproject in ('高档种植体','中档种植体','低档种植体','内提手术费','外提手术费','骨胶原','小骨粉','大骨粉','小骨膜','大骨膜' ))");
		sqlYJ.append(" ) a ) aa ");
		sqlYJ.append(" union ");
		//固定矫正
		sqlYJ.append(" select bb.summ,'gdjz' as type from (select sum(b.allm) as summ from (");
		sqlYJ.append(" SELECT nvl((sum(CFINCOME)*0.9*"+zj+"),0) as allm FROM  CT_PAY_AchieveDetailTem where  CFFIRSOURCE = '渠道推广' and CFTERSOURCE != '"+empName+"'  and  CFFirClassNumber='4'  and CFSecClassnumber='677' and   CFRecDotNumber ='"+empNum+"'  and CFClinicNumber='"+clinicNumber+"' and  to_char(fbizdate,'YYYYMM') ='"+periodnum+"' and not exists ( SELECT 1 FROM  CT_SRQ_ClinicItem clinicItem left join  CT_SRQ_ClinicItemEntry  entry  on clinicItem.fid = entry.fparentid  left join CT_SRQ_PayItem payItem on payItem.fid = entry.cfitemid  where clinicItem.cfcityid = '"+cityId+"' and  clinicItem.cfproject = '口内外正畸' and   CT_PAY_AchieveDetailTem.CFFeeItemDetailNumber = payItem.fnumber)   ");
		sqlYJ.append(" union  SELECT  nvl((sum(CFINCOME)*0.82*"+zj+"),0) as allm FROM  CT_PAY_AchieveDetailTem  where  CFTerSource = '老吾老'  and CFTERSOURCE != '"+empName+"' and  CFFirClassNumber='4'  and CFSecClassnumber='677' and   CFRecDotNumber ='"+empNum+"'  and CFClinicNumber='"+clinicNumber+"' and  to_char(fbizdate,'YYYYMM') ='"+periodnum+"' and not exists ( SELECT 1 FROM  CT_SRQ_ClinicItem clinicItem left join  CT_SRQ_ClinicItemEntry  entry  on clinicItem.fid = entry.fparentid  left join CT_SRQ_PayItem payItem on payItem.fid = entry.cfitemid  where clinicItem.cfcityid = '"+cityId+"' and  clinicItem.cfproject = '口内外正畸' and   CT_PAY_AchieveDetailTem.CFFeeItemDetailNumber = payItem.fnumber)   ");
		sqlYJ.append(" union  SELECT  nvl(sum(CFINCOME)*"+zj+",0) as allm FROM  CT_PAY_AchieveDetailTem  where  ((CFTerSource != '老吾老'  and CFTERSOURCE != '"+empName+"' )  or CFTerSource is null )  and CFFIRSOURCE !=  '渠道推广'     and  CFFirClassNumber='4'  and CFSecClassnumber='677' and   CFRecDotNumber ='"+empNum+"'  and CFClinicNumber='"+clinicNumber+"' and  to_char(fbizdate,'YYYYMM') ='"+periodnum+"'  and not exists ( SELECT 1 FROM  CT_SRQ_ClinicItem clinicItem left join  CT_SRQ_ClinicItemEntry  entry  on clinicItem.fid = entry.fparentid  left join CT_SRQ_PayItem payItem on payItem.fid = entry.cfitemid  where clinicItem.cfcityid = '"+cityId+"' and  clinicItem.cfproject = '口内外正畸' and   CT_PAY_AchieveDetailTem.CFFeeItemDetailNumber = payItem.fnumber)  ");
		sqlYJ.append(" ) b) bb ");
		sqlYJ.append(" union ");
		//隐形矫正
		sqlYJ.append(" select cc.summ,'yxjz' as type from (select sum(c.allm) as summ from ( ");
		sqlYJ.append(" SELECT nvl((sum(CFINCOME)*0.9*"+zj+"),0) as allm FROM  CT_PAY_AchieveDetailTem where  CFFIRSOURCE = '渠道推广'  and CFTERSOURCE != '"+empName+"'  and  CFFirClassNumber='4'  and CFSecClassnumber='678' and   CFRecDotNumber ='"+empNum+"'  and CFClinicNumber='"+clinicNumber+"' and  to_char(fbizdate,'YYYYMM') ='"+periodnum+"'  and not exists ( SELECT 1 FROM  CT_SRQ_ClinicItem clinicItem left join  CT_SRQ_ClinicItemEntry  entry  on clinicItem.fid = entry.fparentid  left join CT_SRQ_PayItem payItem on payItem.fid = entry.cfitemid  where clinicItem.cfcityid = '"+cityId+"' and  clinicItem.cfproject = '口内外正畸' and   CT_PAY_AchieveDetailTem.CFFeeItemDetailNumber = payItem.fnumber)  ");
		sqlYJ.append(" union  SELECT  nvl((sum(CFINCOME)*0.82*"+zj+"),0) as allm FROM  CT_PAY_AchieveDetailTem  where  CFTerSource = '老吾老'  and CFTERSOURCE != '"+empName+"'  and  CFFirClassNumber='4'  and CFSecClassnumber='678'  and   CFRecDotNumber ='"+empNum+"'  and CFClinicNumber='"+clinicNumber+"' and  to_char(fbizdate,'YYYYMM') ='"+periodnum+"'  and not exists ( SELECT 1 FROM  CT_SRQ_ClinicItem clinicItem left join  CT_SRQ_ClinicItemEntry  entry  on clinicItem.fid = entry.fparentid  left join CT_SRQ_PayItem payItem on payItem.fid = entry.cfitemid  where clinicItem.cfcityid = '"+cityId+"' and  clinicItem.cfproject = '口内外正畸' and   CT_PAY_AchieveDetailTem.CFFeeItemDetailNumber = payItem.fnumber)   ");
		sqlYJ.append(" union  SELECT  nvl(sum(CFINCOME)*"+zj+",0) as allm FROM  CT_PAY_AchieveDetailTem  where  ((CFTerSource != '老吾老'  and CFTERSOURCE != '"+empName+"' )  or CFTerSource is null )  and CFFIRSOURCE !=  '渠道推广'    and  CFFirClassNumber='4'  and CFSecClassnumber='678'  and   CFRecDotNumber ='"+empNum+"'  and CFClinicNumber='"+clinicNumber+"' and  to_char(fbizdate,'YYYYMM') ='"+periodnum+"'  and not exists ( SELECT 1 FROM  CT_SRQ_ClinicItem clinicItem left join  CT_SRQ_ClinicItemEntry  entry  on clinicItem.fid = entry.fparentid  left join CT_SRQ_PayItem payItem on payItem.fid = entry.cfitemid  where clinicItem.cfcityid = '"+cityId+"' and  clinicItem.cfproject = '口内外正畸' and   CT_PAY_AchieveDetailTem.CFFeeItemDetailNumber = payItem.fnumber)  ");
		sqlYJ.append(" ) c) cc ");
		sqlYJ.append(" union ");
		//牙周
		sqlYJ.append(" select dd.summ,'yz' as type from (select sum(d.allm) as summ from ( ");
		sqlYJ.append(" SELECT nvl((sum(CFINCOME)*0.9),0) as allm FROM  CT_PAY_AchieveDetailTem where  CFFIRSOURCE = '渠道推广'  and CFTERSOURCE != '"+empName+"'  and     CFRecDotNumber ='"+empNum+"'  and CFClinicNumber='"+clinicNumber+"' and  to_char(fbizdate,'YYYYMM') ='"+periodnum+"'  and exists ( SELECT 1 FROM  CT_SRQ_ClinicItem clinicItem left join  CT_SRQ_ClinicItemEntry  entry  on clinicItem.fid = entry.fparentid  left join CT_SRQ_PayItem payItem on payItem.fid = entry.cfitemid  where clinicItem.cfcityid = '"+cityId+"' and  clinicItem.cfproject = '牙周' and   CT_PAY_AchieveDetailTem.CFFeeItemDetailNumber = payItem.fnumber) ");
		sqlYJ.append(" union  SELECT  nvl((sum(CFINCOME)*0.82),0) as allm FROM  CT_PAY_AchieveDetailTem  where  CFTerSource = '老吾老' and CFTERSOURCE != '"+empName+"'  and     CFRecDotNumber ='"+empNum+"'  and CFClinicNumber='"+clinicNumber+"'and  to_char(fbizdate,'YYYYMM') ='"+periodnum+"'  and exists ( SELECT 1 FROM  CT_SRQ_ClinicItem clinicItem left join  CT_SRQ_ClinicItemEntry  entry  on clinicItem.fid = entry.fparentid  left join CT_SRQ_PayItem payItem on payItem.fid = entry.cfitemid  where clinicItem.cfcityid = '"+cityId+"' and  clinicItem.cfproject = '牙周' and   CT_PAY_AchieveDetailTem.CFFeeItemDetailNumber = payItem.fnumber)  ");
		sqlYJ.append(" union  SELECT  nvl(sum(CFINCOME),0) as allm FROM  CT_PAY_AchieveDetailTem  where   ((CFTerSource != '老吾老'  and CFTERSOURCE != '"+empName+"' )  or CFTerSource is null ) and CFFIRSOURCE !=  '渠道推广'     and     CFRecDotNumber ='"+empNum+"'  and CFClinicNumber='"+clinicNumber+"' and  to_char(fbizdate,'YYYYMM') ='"+periodnum+"' ) and exists ( SELECT 1 FROM  CT_SRQ_ClinicItem clinicItem left join  CT_SRQ_ClinicItemEntry  entry  on clinicItem.fid = entry.fparentid  left join CT_SRQ_PayItem payItem on payItem.fid = entry.cfitemid  where clinicItem.cfcityid = '"+cityId+"' and  clinicItem.cfproject = '牙周' and   CT_PAY_AchieveDetailTem.CFFeeItemDetailNumber = payItem.fnumber)  ");
		sqlYJ.append(" ) d) dd ");
		sqlYJ.append(" union ");
		//口内外
		sqlYJ.append(" select ee.summ,'knw' as type from (select sum(e.allm) as summ from ( ");
		sqlYJ.append(" SELECT nvl((sum(CFINCOME)*0.9),0) as allm FROM  CT_PAY_AchieveDetailTem where  CFFIRSOURCE = '渠道推广'  and CFTERSOURCE != '"+empName+"'   and   CFRecDotNumber ='"+empNum+"'  and CFClinicNumber='"+clinicNumber+"' and  to_char(fbizdate,'YYYYMM') ='"+periodnum+"'  and exists ( SELECT 1 FROM  CT_SRQ_ClinicItem clinicItem left join  CT_SRQ_ClinicItemEntry  entry  on clinicItem.fid = entry.fparentid  left join CT_SRQ_PayItem payItem on payItem.fid = entry.cfitemid  where clinicItem.cfcityid = '"+cityId+"' and  clinicItem.cfproject = '口内外' and   CT_PAY_AchieveDetailTem.CFFeeItemDetailNumber = payItem.fnumber) ");
		sqlYJ.append(" union  SELECT  nvl((sum(CFINCOME)*0.82),0) as allm FROM  CT_PAY_AchieveDetailTem  where  CFTerSource = '老吾老'  and CFTERSOURCE != '"+empName+"'  and   CFRecDotNumber ='"+empNum+"'  and CFClinicNumber='"+clinicNumber+"' and  to_char(fbizdate,'YYYYMM') ='"+periodnum+"' and exists ( SELECT 1 FROM  CT_SRQ_ClinicItem clinicItem left join  CT_SRQ_ClinicItemEntry  entry  on clinicItem.fid = entry.fparentid  left join CT_SRQ_PayItem payItem on payItem.fid = entry.cfitemid  where clinicItem.cfcityid = '"+cityId+"' and  clinicItem.cfproject = '口内外' and   CT_PAY_AchieveDetailTem.CFFeeItemDetailNumber = payItem.fnumber) ");
		sqlYJ.append(" union  SELECT  nvl(sum(CFINCOME),0) as allm FROM  CT_PAY_AchieveDetailTem  where  ((CFTerSource != '老吾老'  and CFTERSOURCE != '"+empName+"' )  or CFTerSource is null )  and CFFIRSOURCE !=  '渠道推广'    and   CFRecDotNumber ='"+empNum+"'  and CFClinicNumber='"+clinicNumber+"' and  to_char(fbizdate,'YYYYMM') ='"+periodnum+"' and exists ( SELECT 1 FROM  CT_SRQ_ClinicItem clinicItem left join  CT_SRQ_ClinicItemEntry  entry  on clinicItem.fid = entry.fparentid  left join CT_SRQ_PayItem payItem on payItem.fid = entry.cfitemid  where clinicItem.cfcityid = '"+cityId+"' and  clinicItem.cfproject = '口内外' and   CT_PAY_AchieveDetailTem.CFFeeItemDetailNumber = payItem.fnumber)  ");
		sqlYJ.append(" ) e) ee ");
		sqlYJ.append(" union ");
		// 美白
		sqlYJ.append(" select ff.summ,'mb' as type from (select sum(f.allm) as summ from ( ");
		sqlYJ.append(" SELECT nvl((sum(CFINCOME)*0.9),0) as allm FROM  CT_PAY_AchieveDetailTem where  CFFIRSOURCE = '渠道推广' and  CFFirClassNumber='7'  and CFSecClassnumber='43' and   CFRecDotNumber ='"+empNum+"'  and CFClinicNumber='"+clinicNumber+"' and  to_char(fbizdate,'YYYYMM') ='"+periodnum+"'  ");
		sqlYJ.append(" union  SELECT  nvl((sum(CFINCOME)*0.82),0) as allm FROM  CT_PAY_AchieveDetailTem  where  CFTerSource = '老吾老' and  CFFirClassNumber='7'  and CFSecClassnumber='43'and   CFRecDotNumber ='"+empNum+"'  and CFClinicNumber='"+clinicNumber+"' and  to_char(fbizdate,'YYYYMM') ='"+periodnum+"'  ");
		sqlYJ.append(" union  SELECT  nvl(sum(CFINCOME),0) as allm FROM  CT_PAY_AchieveDetailTem  where   ((CFTerSource != '老吾老'  and CFTERSOURCE != '"+empName+"' )  or CFTerSource is null )  and CFFIRSOURCE !=  '渠道推广' and  CFFirClassNumber='7'  and CFSecClassnumber='43' and   CFRecDotNumber ='"+empNum+"'  and CFClinicNumber='"+clinicNumber+"' and  to_char(fbizdate,'YYYYMM') ='"+periodnum+"'  ");
		sqlYJ.append(" ) f) ff ");
		sqlYJ.append(" union ");
		sqlYJ.append(" select gg.summ,'xf' as type from (select sum(g.allm) as summ from ( ");
		//修复
		sqlYJ.append(" SELECT nvl((sum(CFINCOME)*0.9),0) as allm FROM  CT_PAY_AchieveDetailTem where  CFFIRSOURCE = '渠道推广'  and CFTERSOURCE != '"+empName+"'   and  CFFirClassNumber='2'  and   CFRecDotNumber ='"+empNum+"'  and CFClinicNumber='"+clinicNumber+"' and  to_char(fbizdate,'YYYYMM') ='"+periodnum+"'  ");
		sqlYJ.append(" union  SELECT  nvl((sum(CFINCOME)*0.82),0) as allm FROM  CT_PAY_AchieveDetailTem  where  CFTerSource = '老吾老'  and CFTERSOURCE != '"+empName+"'  and  CFFirClassNumber='2'  and   CFRecDotNumber ='"+empNum+"'  and CFClinicNumber='"+clinicNumber+"' and  to_char(fbizdate,'YYYYMM') ='"+periodnum+"'  ");
		sqlYJ.append(" union  SELECT  nvl(sum(CFINCOME),0) as allm FROM  CT_PAY_AchieveDetailTem  where   ((CFTerSource != '老吾老'  and CFTERSOURCE != '"+empName+"' )  or CFTerSource is null )   and  CFFirClassNumber='2'  and CFFIRSOURCE !=  '渠道推广' and   CFRecDotNumber ='"+empNum+"'  and CFClinicNumber='"+clinicNumber+"' and  to_char(fbizdate,'YYYYMM') ='"+periodnum+"'  ");
		sqlYJ.append(" ) g) gg ");
		sqlYJ.append(" union ");
		// 儿牙
		sqlYJ.append(" select hh.summ,'ey' as type from (select sum(h.allm) as summ from ( ");
		sqlYJ.append(" SELECT nvl((sum(CFINCOME)*0.9),0) as allm FROM  CT_PAY_AchieveDetailTem where  CFFIRSOURCE = '渠道推广'  and CFTERSOURCE != '"+empName+"' and  CFFirClassNumber='6'  and   CFRecDotNumber ='"+empNum+"'  and CFClinicNumber='"+clinicNumber+"' and  to_char(fbizdate,'YYYYMM') ='"+periodnum+"'   ");
		sqlYJ.append(" union  SELECT  nvl((sum(CFINCOME)*0.82),0) as allm FROM  CT_PAY_AchieveDetailTem  where  CFTerSource = '老吾老'  and CFTERSOURCE != '"+empName+"'  and  CFFirClassNumber='6'  and   CFRecDotNumber ='"+empNum+"'  and CFClinicNumber='"+clinicNumber+"' and  to_char(fbizdate,'YYYYMM') ='"+periodnum+"'  ");
		sqlYJ.append(" union  SELECT  nvl(sum(CFINCOME),0) as allm FROM  CT_PAY_AchieveDetailTem  where   ((CFTerSource != '老吾老'  and CFTERSOURCE != '"+empName+"' )  or CFTerSource is null )  and CFFIRSOURCE !=  '渠道推广'     and  CFFirClassNumber='6'  and   CFRecDotNumber ='"+empNum+"'  and CFClinicNumber='"+clinicNumber+"' and  to_char(fbizdate,'YYYYMM') ='"+periodnum+"'  ");
		sqlYJ.append(" ) h) hh ");*/

		return sqlYJ;
	}
	
	
	private  static HashMap<String,BigDecimal> setJingWork(BigDecimal zz,BigDecimal zzcb,BigDecimal gdjz,BigDecimal gdjzcb,BigDecimal yxjz,BigDecimal yxjzcb,
			BigDecimal yz,BigDecimal yzcb,BigDecimal knw,BigDecimal knwcb,BigDecimal xf,BigDecimal xfcb,BigDecimal ey,BigDecimal eycb,HashMap<String,BigDecimal> biliMap,String calType){
		LinkedHashMap<String,BigDecimal> negMap = new LinkedHashMap<String,BigDecimal>();
		LinkedHashMap<String,BigDecimal> justMap = new LinkedHashMap<String,BigDecimal>();
		LinkedHashMap<String,BigDecimal> allMap = new LinkedHashMap<String,BigDecimal>();
		BigDecimal zzBase = zz.subtract(zzcb);
		if(zzBase.compareTo(BigDecimal.ZERO)<0){
			negMap.put("zz", zzBase);
		}else if(zzBase.compareTo(BigDecimal.ZERO)>0){
			justMap.put("zz", zzBase);
		}
		BigDecimal gdjzBase = gdjz.subtract(gdjzcb);
		if(gdjzBase.compareTo(BigDecimal.ZERO)<0){
			negMap.put("gdjz", gdjzBase);
		}else if(gdjzBase.compareTo(BigDecimal.ZERO)>0){
			justMap.put("gdjz", gdjzBase);
		}
		BigDecimal yxjzBase = yxjz.subtract(yxjzcb);
		if(yxjzBase.compareTo(BigDecimal.ZERO)<0){
			negMap.put("yxjz", yxjzBase);
		}else if(yxjzBase.compareTo(BigDecimal.ZERO)>0){
			justMap.put("yxjz", yxjzBase);
		} 
		BigDecimal yzBase =  yz.subtract(yzcb);
		if(yzBase.compareTo(BigDecimal.ZERO)<0){
			negMap.put("yz", yzBase);
		}else if(yzBase.compareTo(BigDecimal.ZERO)>0){
			justMap.put("yz", yzBase);
		} 
		BigDecimal knwBase = knw.subtract(knwcb); 
		if(knwBase.compareTo(BigDecimal.ZERO)<0){
			negMap.put("knw", knwBase);
		}else if(knwBase.compareTo(BigDecimal.ZERO)>0){
			justMap.put("knw", knwBase);
		} 
		BigDecimal xfBase = xf.subtract(xfcb);
		if(xfBase.compareTo(BigDecimal.ZERO)<0){
			negMap.put("xf", xfBase);
		}else if(xfBase.compareTo(BigDecimal.ZERO)>0){
			justMap.put("xf", xfBase);
		} 
		BigDecimal eyBase = ey.subtract(eycb);
		if(eyBase.compareTo(BigDecimal.ZERO)<0){
			negMap.put("ey", eyBase);
		}else if(eyBase.compareTo(BigDecimal.ZERO)>0){
			justMap.put("ey", eyBase);
		} 
		//justMap.remove("xf");
		List<Map.Entry<String,BigDecimal>> list = new ArrayList<Map.Entry<String,BigDecimal>>(justMap.entrySet());
        //然后通过比较器来实现排序
        Collections.sort(list,new Comparator<Map.Entry<String,BigDecimal>>() {
            //降序排序
            public int compare(Map.Entry<String, BigDecimal> o1,
                               Map.Entry<String, BigDecimal> o2) {
                //return o1.getValue().compareTo(o2.getValue());
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        justMap.clear();
        //System.out.println(justMap.size());
        for(Map.Entry<String,BigDecimal> mapping:list){
            //System.out.println(mapping.getKey()+":"+mapping.getValue());
            justMap.put(mapping.getKey(),mapping.getValue());
        }  
		Iterator negit = negMap.keySet().iterator();
		if(calType != null  && calType.equals("zskc")){//折算扣除
			//遍历 负数map  进行平均处理 
			while(negit.hasNext()){ 
					if(justMap.size() > 0){
					String negKey = negit.next().toString(); 
					BigDecimal negValue = negMap.get(negKey) ; 
					BigDecimal negBili = biliMap.get(negKey);
					Iterator it = justMap.keySet().iterator();
				    while(it.hasNext()){
				    	String key = it.next().toString();
				        BigDecimal value =  justMap.get(key);
				        BigDecimal bili = biliMap.get(key);
				        	
				        if(negValue.multiply(negBili).negate().compareTo(value.multiply(bili)) > 0){//没有抵消  负数多
				        	it.remove();
				        	justMap.remove(key);
				        	it = justMap.keySet().iterator();
				        	
			                negValue = negValue.add(value.multiply(bili).divide(negBili,6,BigDecimal.ROUND_HALF_UP));
			                negMap.put(negKey,negValue);
			                /*negit.remove();
			                negMap.remove(negKey);
			                negMap.put(negKey,negValue);
			                negit = negMap.keySet().iterator();*/
			                
			                if(justMap.size() == 0){
			                	break;
			                }
			            }else if(negValue.multiply(negBili).compareTo(value.multiply(bili)) == 0){//刚好抵消
		                    it.remove();
		                    justMap.remove(key);
				        	it = justMap.keySet().iterator();
				        	
		                    negit.remove();
		                	negMap.remove(negKey);
		                	negit = negMap.keySet().iterator();
		                	
		                    break;
		                }else{//正数  多出一部分
		                	negit.remove();
		                	negMap.remove(negKey);
		                	negit = negMap.keySet().iterator();
		                	 
		                	value = value.add(negValue.multiply(negBili).divide(bili,6,BigDecimal.ROUND_HALF_UP));
		                    justMap.put(key,value);
		                    break;
		                }
				        
				        if(justMap.size() == 0){
					    	 
		                	break;
		                }
				    }
				}else{
					break;
				}
			}
		}  
		BigDecimal allCount = BigDecimal.ZERO;
		negit = negMap.keySet().iterator();
		while(negit.hasNext()){
			String negKey = negit.next().toString(); 
			BigDecimal negValue = negMap.get(negKey) ; 
			allMap.put(negKey, negValue);
			allCount = allCount.add(negValue);
		}
		//justMap.put("xf",new BigDecimal("62741"));
		Iterator it = justMap.keySet().iterator();
	    while(it.hasNext()){
	    	String key = it.next().toString();
	        BigDecimal value =  justMap.get(key);
	        allMap.put(key, value);
	        allCount = allCount.add(value);
	    }
	    //allMap 中只有两种情况  全是正  全是负    或者只有0
	    allMap.put("all", allCount);
	    return allMap;
		
	} 
	private  static String getNextPeriod(String period){
		String nextPeriod = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
	    Date date;
	    try {
	        date = sdf.parse(period);
	        //
	        Calendar caldele = Calendar.getInstance();
	        caldele.setTime(date);
	        caldele.add(Calendar.MONTH, 1);
	        Date dateDele = caldele.getTime();
	        SimpleDateFormat formatdelete= new SimpleDateFormat("yyyyMM");
	        nextPeriod = formatdelete.format(dateDele); 
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
		return nextPeriod;
		
		
		/*BigDecimal zzBase =  BigDecimal.ZERO;
		BigDecimal gdjzBase = BigDecimal.ZERO;
		BigDecimal yxjzBase = BigDecimal.ZERO;
		BigDecimal yzBase = BigDecimal.ZERO;
		BigDecimal knwBase = BigDecimal.ZERO; 
		BigDecimal xfBase = BigDecimal.ZERO;
		BigDecimal eyBase = BigDecimal.ZERO;
		
		
		if(allMap.get("all").compareTo(BigDecimal.ZERO) > 0){
			if(null != allMap.get("zz")){
				zzBase = allMap.get("zz");
			}
			if(null != allMap.get("gdjz")){
				gdjzBase = allMap.get("gdjz");
			}
			if(null != allMap.get("yxjz")){
				yxjzBase = allMap.get("yxjz");
			}
			if(null != allMap.get("yz")){
				yzBase = allMap.get("yz");
			}
			if(null != allMap.get("knw")){
				knwBase = allMap.get("knw");
			}
			if(null != allMap.get("xf")){
				xfBase = allMap.get("xf");
			}
			if(null != allMap.get("ey")){
				eyBase = allMap.get("ey");
			}
		}else if(allMap.get("all").compareTo(BigDecimal.ZERO) <0 ){
			DoctorCostsInfo doctorCostsInfo =new DoctorCostsInfo();
			doctorCostsInfo.setBusinessDate(nextPeriod);
			CtrlUnitInfo ctrlUnitInfo = new CtrlUnitInfo();
			ctrlUnitInfo.setId(BOSUuid.read(cityId));
			doctorCostsInfo.setCity(ctrlUnitInfo);
			doctorCostsInfo.setCityNumber(cityNumber);
			doctorCostsInfo.setEmpNumber(empNum);
			doctorCostsInfo.setCostType(costType.yk);
			if(null != allMap.get("zz")){
				zzBase = allMap.get("zz").compareTo(BigDecimal.ZERO)<0?BigDecimal.ZERO:allMap.get("zz");
				doctorCostsInfo.setZbCost(allMap.get("zz").negate());
			}
			if(null != allMap.get("gdjz")){
				gdjzBase = allMap.get("gdjz").compareTo(BigDecimal.ZERO)<0?BigDecimal.ZERO:allMap.get("gdjz");
				doctorCostsInfo.setGdCost(allMap.get("gdjz").negate());
			}
			if(null != allMap.get("yxjz")){
				yxjzBase = allMap.get("yxjz").compareTo(BigDecimal.ZERO)<0?BigDecimal.ZERO:allMap.get("yxjz");
				doctorCostsInfo.setYxCost(allMap.get("yxjz").negate());
			}
			if(null != allMap.get("yz")){
				yzBase = allMap.get("yz").compareTo(BigDecimal.ZERO)<0?BigDecimal.ZERO:allMap.get("yz");
				doctorCostsInfo.setZbCost(allMap.get("yz").negate());
			}
			if(null != allMap.get("knw")){
				knwBase = allMap.get("knw").compareTo(BigDecimal.ZERO)<0?BigDecimal.ZERO:allMap.get("knw");
				doctorCostsInfo.setKnCost(allMap.get("knw").negate());
			}
			if(null != allMap.get("xf")){
				xfBase = allMap.get("xf").compareTo(BigDecimal.ZERO)<0?BigDecimal.ZERO:allMap.get("xf");
				doctorCostsInfo.setXfCost(allMap.get("xf").negate());
			}
			if(null != allMap.get("ey")){
				eyBase = allMap.get("ey").compareTo(BigDecimal.ZERO)<0?BigDecimal.ZERO:allMap.get("ey");
				doctorCostsInfo.setEyCost(allMap.get("ey").negate());
			}
			DoctorCostsFactory.getLocalInstance(ctx).save(doctorCostsInfo);
		}*/
		
	}
	
	private  BigDecimal docZiDai(Context ctx, HashMap map ,String empNum, String cityNumber,String periodnum ,String clinicNumber , HashMap tempMap ,String cityId){ 
		ExecutorService pool = Executors.newFixedThreadPool(6);
	    ParallelSqlExecutor pe = new ParallelSqlExecutor(pool); 
	    String userId = ContextHelperFactory.getLocalInstance(ctx).getCurrentUser().getId().toString(); 
	    
		
		BigDecimal costAll = BigDecimal.ZERO; 
		//种植成本
		BigDecimal zzcb = BigDecimal.ZERO; 
		//固定矫正成本
		BigDecimal gdjzcb = BigDecimal.ZERO; 
		//隐形矫正成本
		BigDecimal yxjzcb = BigDecimal.ZERO; 
		//牙周成本
		BigDecimal yzcb = BigDecimal.ZERO; 
		//口内外成本
		BigDecimal knwcb = BigDecimal.ZERO; 
		//美白成本
		BigDecimal mbcb = BigDecimal.ZERO; 
		//修复成本
		BigDecimal xfcb = BigDecimal.ZERO; 
		//儿牙成本
		BigDecimal eycb = BigDecimal.ZERO; 
		
		ClinicCostSumInfo clinicCostSumInfo = new ClinicCostSumInfo();
		clinicCostSumInfo.setEmpNumber(empNum);
		clinicCostSumInfo.setClinicNumber(clinicNumber);
		clinicCostSumInfo.setCityNumber(cityNumber);
		clinicCostSumInfo.setBusinessDate(periodnum); 
		clinicCostSumInfo.setCityName(tempMap.get("cityName").toString());
		clinicCostSumInfo.setEmpName(tempMap.get("empName").toString());
		
		//计算自带患者
		//自带患者 种植 业绩
		BigDecimal byzz = BigDecimal.ZERO;
		//自带患者 固定矫正业绩
		BigDecimal bygdjz = BigDecimal.ZERO; 
		//自带患者 隐形矫正业绩
		BigDecimal byyxjz = BigDecimal.ZERO; 
		//自带患者 牙周业绩
		BigDecimal byyz = BigDecimal.ZERO; 
		//自带患者 口内外业绩
		BigDecimal byknw = BigDecimal.ZERO; 
		//自带患者 美白业绩
		BigDecimal bymb = BigDecimal.ZERO; 
		//自带患者 修复业绩
		BigDecimal byxf = BigDecimal.ZERO; 
		//自带患者 儿牙业绩
		BigDecimal byey = BigDecimal.ZERO; 
		
		//自带患者 种植 
		BigDecimal byzzbl = new BigDecimal(map.get("CFBYZZPRO").toString());
		//自带患者 固定矫正
		BigDecimal bygdjzbl = new BigDecimal(map.get("CFBYGDJZPRO").toString());
		//自带患者 隐形矫正
		BigDecimal byyxjzbl =  new BigDecimal(map.get("CFBYYXJZPRO").toString());
		//自带患者 牙周
		BigDecimal byyzbl =  new BigDecimal(map.get("CFBYYZPRO").toString());//?
		//自带患者 口内外
		BigDecimal byknwbl = new BigDecimal(map.get("CFBYKNWPRO").toString());
		//自带患者 美白
		BigDecimal bymbbl = new BigDecimal(map.get("CFBYMBPRO").toString());
		//自带患者 修复
		BigDecimal byxfbl = new BigDecimal(map.get("CFBYXFPRO").toString());
		//自带患者 儿牙
		BigDecimal byeybl =  new BigDecimal(map.get("CFBYEYPRO").toString()); 
		 
		String insertSql =  "";
		String insertValueSql = "";
		String imandxtinsertsql = "";
		String imandxtinsertValueSql = "";
		try { 
			BigDecimal zj = new BigDecimal(map.get("CFZJPRO").toString()); 
			String empName = map.get("CFDOCNAME").toString();
			

			StringBuffer sqlImportYJ = new StringBuffer(); 
			sqlImportYJ = getYeJiZIDaiImpSql( empNum,  cityNumber, periodnum, sqlImportYJ, cityId);
		  	System.out.println("--"+sqlImportYJ);
		  	IRowSet yjImprs = com.kingdee.eas.custom.util.DBUtil.executeQuery(ctx,sqlImportYJ.toString());
		  	if(yjImprs!=null && yjImprs.size() > 0){ 
			  	while(yjImprs.next()){	
			  		byzz = byzz.add(new BigDecimal(yjImprs.getString("ZZ"))); 
			  		bygdjz= bygdjz.add(new BigDecimal(yjImprs.getString("GDJZ"))); 
			  		byyxjz= byyxjz.add(new BigDecimal(yjImprs.getString("YXJZ"))); 
			  		byyz= byyz.add(new BigDecimal(yjImprs.getString("YZ"))); 
			  		byknw = byknw.add(new BigDecimal(yjImprs.getString("KNW")));
			  		bymb= bymb.add(new BigDecimal(yjImprs.getString("MB"))); 
			  		byxf= byxf.add(new BigDecimal(yjImprs.getString("XF")));  
			  		byey= byey.add(new BigDecimal(yjImprs.getString("EY")));  
			  		
			  		imandxtinsertsql +=  ", CFIMZZACHIEVE , CFIMGDJZACHIEVE , cfIMyxjzachieve, CFIMyzAchieve , cfIMknwachieve , cfIMmbachieve , cfIMxfachieve, cfIMeyachieve ";
					imandxtinsertValueSql +=" ,"+new BigDecimal(yjImprs.getString("ZZ"))+" ,"+new BigDecimal(yjImprs.getString("GDJZ"))+","+new BigDecimal(yjImprs.getString("YXJZ"))
					+","+new BigDecimal(yjImprs.getString("YZ"))+","+new BigDecimal(yjImprs.getString("KNW"))+","+new BigDecimal(yjImprs.getString("MB"))+","+new BigDecimal(yjImprs.getString("XF"))+"," +
							""+new BigDecimal(yjImprs.getString("EY"))+"  ";
				}
			}
		  	
			//计算自带患者的 业绩
			StringBuffer sqlZD = new StringBuffer(); 
			sqlZD = getZiDaiYeJiSql( empNum,  cityNumber, periodnum, empName,zj,cityId);
			IRowSet zdrs = com.kingdee.eas.custom.util.DBUtil.executeQuery(ctx,sqlZD.toString());
			if(zdrs!=null && zdrs.size() > 0){
				  while(zdrs.next()){	  
					  if("zz".equals(zdrs.getString("TYPE"))){//种植
						  byzz =byzz.add(new BigDecimal(zdrs.getString("SUMM"))); 
						  insertSql +=  ", CFZZACHIEVE ";
						  insertValueSql +=" ,"+byzz;
						  
						  imandxtinsertsql +=  ", CFXTZZACHIEVE  ";
						  imandxtinsertValueSql +=" ,"+new BigDecimal(zdrs.getString("SUMM"))+" ";
						  
					  }else if("gdjz".equals(zdrs.getString("TYPE"))){//固定矫正  
						  bygdjz=bygdjz.add(new BigDecimal(zdrs.getString("SUMM"))); 
						  insertSql +=  ", CFGDJZACHIEVE ";
						  insertValueSql+=" ,"+bygdjz;
						  
						  imandxtinsertsql +=  "  , CFXTGDJZACHIEVE  ";
						  imandxtinsertValueSql +="   ,"+new BigDecimal(zdrs.getString("SUMM"))+" ";
					  }else if("yxjz".equals(zdrs.getString("TYPE"))){//隐形矫正
						  byyxjz=byyxjz.add(new BigDecimal(zdrs.getString("SUMM"))); 
						  insertSql +=  ", cfyxjzachieve ";
						  insertValueSql += " ,"+byyxjz;
						  
						  imandxtinsertsql +=  " , cfXTyxjzachieve ";
						  imandxtinsertValueSql +="  ,"+new BigDecimal(zdrs.getString("SUMM"))+" ";
					  }else if("yz".equals(zdrs.getString("TYPE"))){//牙周 ？
						  byyz=byyz.add(new BigDecimal(zdrs.getString("SUMM"))); 
						  insertSql +=  ", CFZyAchieve ";
						  insertValueSql += " ,"+byyz;
						  
						  imandxtinsertsql +=  " , CFXTyzAchieve  ";
							imandxtinsertValueSql +=" ,"+new BigDecimal(zdrs.getString("SUMM"))+"  ";
					  }else if("knw".equals(zdrs.getString("TYPE"))){//口内外 ？
						  byknw =byknw.add(new BigDecimal(zdrs.getString("SUMM")));
						  insertSql +=  ", cfknwachieve ";
						  insertValueSql += " ,"+byknw;
						  

						  imandxtinsertsql +=  "  , cfXTknwachieve   ";
						  imandxtinsertValueSql +="  ,"+new BigDecimal(zdrs.getString("SUMM"))+"  ";
						  
					  }else if("mb".equals(zdrs.getString("TYPE"))){//美白
						  bymb=bymb.add(new BigDecimal(zdrs.getString("SUMM"))); 
						  insertSql +=  ", cfmbachieve ";
						  insertValueSql += " ,"+bymb;
						  
						  imandxtinsertsql +=  "  , cfXTmbachieve ";
							 imandxtinsertValueSql +="  ,"+new BigDecimal(zdrs.getString("SUMM"))+"   ";
					  }else if("xf".equals(zdrs.getString("TYPE"))){//修复
						  byxf=byxf.add(new BigDecimal(zdrs.getString("SUMM"))); 
						  insertSql +=  ", cfxfachieve ";
						  insertValueSql += " ,"+byxf;
						  
						  imandxtinsertsql +=  " , cfXTxfachieve ";
						  imandxtinsertValueSql +=" ,"+new BigDecimal(zdrs.getString("SUMM"))+"  ";
					  }else if("ey".equals(zdrs.getString("TYPE"))){//儿牙
						  byey=byey.add(new BigDecimal(zdrs.getString("SUMM"))); 
						  insertSql +=  ", cfeyachieve ";
						  insertValueSql += " ,"+byey;
						  
						  imandxtinsertsql +=  " , cfXTeyachieve ";
						  imandxtinsertValueSql +=" ,"+new BigDecimal(zdrs.getString("SUMM"))+"  ";
					  }
				  }
				 
			} 
			  
			//自带患者成本
			StringBuffer sqlImportCB = new StringBuffer(); 
			sqlImportCB = getImportZiDaiChengBenSql( "'"+empNum+"'",  cityId, periodnum, sqlImportCB);
			IRowSet imporytbrs = com.kingdee.eas.custom.util.DBUtil.executeQuery(ctx,sqlImportCB.toString());
			if(imporytbrs!=null && imporytbrs.size() > 0){
				while(imporytbrs.next()){	
					  if("zz".equals(imporytbrs.getString("TYPE"))){//种植
						  zzcb =new BigDecimal(imporytbrs.getString("SUMM")); 
						  costAll = costAll.add(zzcb);
						   
						  clinicCostSumInfo.setImzzCost(zzcb);
					  }else if("gdjz".equals(imporytbrs.getString("TYPE"))){//固定矫正
						  gdjzcb=new BigDecimal(imporytbrs.getString("SUMM")); 
						  costAll = costAll.add(gdjzcb);
						   
						  clinicCostSumInfo.setImgdjzCost(gdjzcb);
					  }else if("yxjz".equals(imporytbrs.getString("TYPE"))){//隐形矫正
						  yxjzcb=new BigDecimal(imporytbrs.getString("SUMM")); 
						  costAll = costAll.add(yxjzcb);
						   
						  clinicCostSumInfo.setImyxjzCost(yxjzcb);
					  }else if("yz".equals(imporytbrs.getString("TYPE"))){//牙周
						  yzcb=new BigDecimal(imporytbrs.getString("SUMM")); 
						  costAll = costAll.add(yzcb);
						   
						  clinicCostSumInfo.setImyzCost(yzcb);
					  }else if("knw".equals(imporytbrs.getString("TYPE"))){//口内外
						  knwcb =new BigDecimal(imporytbrs.getString("SUMM"));
						  costAll = costAll.add(knwcb);
						   
						  clinicCostSumInfo.setImknwCost(knwcb);
					  }else if("mb".equals(imporytbrs.getString("TYPE"))){//美白
						  mbcb=new BigDecimal(imporytbrs.getString("SUMM")); 
						  costAll = costAll.add(mbcb); 
						  
						  clinicCostSumInfo.setImmbCost(mbcb);
					  }else if("xf".equals(imporytbrs.getString("TYPE"))){//修复
						  xfcb=new BigDecimal(imporytbrs.getString("SUMM")); 
						  costAll = costAll.add(xfcb);
						   
						  clinicCostSumInfo.setImxfCost(xfcb);
					  }else if("ey".equals(imporytbrs.getString("TYPE"))){//儿牙
						  eycb=new BigDecimal(imporytbrs.getString("SUMM")); 
						  costAll = costAll.add(eycb);
						  
						  clinicCostSumInfo.setImeyCost(eycb);
						   
					  }  
				  }
			} 
			
			//获得 护士调整的成本
			StringBuffer sqlHushiCB = new StringBuffer(); 
			sqlHushiCB = getHushiZiDaiChengBenSql( "'"+empNum+"'",  cityId, periodnum, sqlHushiCB);
			IRowSet hushiCBrs;
			
				hushiCBrs = com.kingdee.eas.custom.util.DBUtil.executeQuery(ctx,sqlHushiCB.toString());
			
			if(hushiCBrs!=null && hushiCBrs.size() > 0){
				while(hushiCBrs.next()){	
					  if("zz".equals(hushiCBrs.getString("TYPE"))){//种植
						  zzcb = zzcb.add(new BigDecimal(hushiCBrs.getString("SUMM"))); 
						  costAll = costAll.add(new BigDecimal(hushiCBrs.getString("SUMM"))); 
						  insertSql +=  ", cfzzcost ";
						  insertValueSql += " ,"+zzcb;
						  clinicCostSumInfo.setUpzzCost(new BigDecimal(hushiCBrs.getString("SUMM")));
					  }else if("gdjz".equals(hushiCBrs.getString("TYPE"))){//固定矫正
						  gdjzcb = gdjzcb.add(new BigDecimal(hushiCBrs.getString("SUMM"))); 
						  costAll = costAll.add(new BigDecimal(hushiCBrs.getString("SUMM")));
						    
						  insertSql +=  ", cfgdjzcost ";
						  insertValueSql += " ,"+gdjzcb;
						  
						  clinicCostSumInfo.setUpgdjzCost(new BigDecimal(hushiCBrs.getString("SUMM")));
					  }else if("yxjz".equals(hushiCBrs.getString("TYPE"))){//隐形矫正
						  yxjzcb = yxjzcb.add(new BigDecimal(hushiCBrs.getString("SUMM"))); 
						  costAll = costAll.add(new BigDecimal(hushiCBrs.getString("SUMM"))); 
						  
						  insertSql +=  ", cfyxjzcost ";
						  insertValueSql += " ,"+yxjzcb;
						  
						  clinicCostSumInfo.setUpyxjzCost(new BigDecimal(hushiCBrs.getString("SUMM")));
					  }else if("yz".equals(hushiCBrs.getString("TYPE"))){//牙周
						  yzcb = yzcb.add(new BigDecimal(hushiCBrs.getString("SUMM"))); 
						  costAll = costAll.add(new BigDecimal(hushiCBrs.getString("SUMM"))); 
						  
						  insertSql +=  ", cfyzcost ";
						  insertValueSql += " ,"+yzcb;
						  
						  clinicCostSumInfo.setYzCost(new BigDecimal(hushiCBrs.getString("SUMM")));
					  }else if("knw".equals(hushiCBrs.getString("TYPE"))){//口内外
						  knwcb = knwcb.add(new BigDecimal(hushiCBrs.getString("SUMM")));
						  costAll = costAll.add(new BigDecimal(hushiCBrs.getString("SUMM"))); 
						  
						  insertSql +=  ", cfknwcost ";
						  insertValueSql += " ,"+knwcb;
						  
						  clinicCostSumInfo.setUpknwCost(new BigDecimal(hushiCBrs.getString("SUMM")));
					  }else if("mb".equals(hushiCBrs.getString("TYPE"))){//美白
						  mbcb = mbcb.add(new BigDecimal(hushiCBrs.getString("SUMM"))); 
						  costAll = costAll.add(new BigDecimal(hushiCBrs.getString("SUMM")));  
						  
						  insertSql +=  ", cfmbcost ";
						  insertValueSql += " ,"+mbcb;
						  
						  clinicCostSumInfo.setUpmbCost(new BigDecimal(hushiCBrs.getString("SUMM")));
					  }else if("xf".equals(hushiCBrs.getString("TYPE"))){//修复
						  xfcb = xfcb.add(new BigDecimal(hushiCBrs.getString("SUMM"))); 
						  costAll = costAll.add(new BigDecimal(hushiCBrs.getString("SUMM"))); 
						  
						  insertSql +=  ", cfxfcost ";
						  insertValueSql += " ,"+xfcb;
						  
						  clinicCostSumInfo.setUpxfCost(new BigDecimal(hushiCBrs.getString("SUMM")));
					  }else if("ey".equals(hushiCBrs.getString("TYPE"))){//儿牙
						  eycb = eycb.add(new BigDecimal(hushiCBrs.getString("SUMM"))); 
						  costAll = costAll.add(new BigDecimal(hushiCBrs.getString("SUMM")));  
						  
						  insertSql +=  ", cfeycost ";
						  insertValueSql += " ,"+eycb;
						  
						  clinicCostSumInfo.setUpeyCost(new BigDecimal(hushiCBrs.getString("SUMM")));
					  } 
				  }
			} 
		
			clinicCostSumInfo.setAllgdjzCost(clinicCostSumInfo.getUpgdjzCost().add(clinicCostSumInfo.getImgdjzCost())); 
			clinicCostSumInfo.setAllzzCost(clinicCostSumInfo.getUpzzCost().add(clinicCostSumInfo.getImzzCost()));
			clinicCostSumInfo.setAllyxjzCost(clinicCostSumInfo.getUpyxjzCost().add(clinicCostSumInfo.getImyxjzCost()));
			clinicCostSumInfo.setAllyzCost(clinicCostSumInfo.getUpyzCost().add(clinicCostSumInfo.getImyzCost()));
			clinicCostSumInfo.setAllknwCost(clinicCostSumInfo.getUpknwCost().add(clinicCostSumInfo.getImknwCost()));
			clinicCostSumInfo.setAllmbCost(clinicCostSumInfo.getUpmbCost().add(clinicCostSumInfo.getImmbCost()));
			clinicCostSumInfo.setAllxfCost(clinicCostSumInfo.getUpxfCost().add(clinicCostSumInfo.getImxfCost()));
			clinicCostSumInfo.setAlleyCost(clinicCostSumInfo.getUpeyCost().add(clinicCostSumInfo.getImeyCost()));
			ClinicCostSumFactory.getLocalInstance(ctx).save(clinicCostSumInfo);
			
			//
			 
			StringBuffer sbr2  = new StringBuffer(" /*dialect*/insert into CT_PAY_ClinicAchieveCosthSum (FID,FCreatorID,FCreateTime,FLastUpdateUserID,FLastUpdateTime, ");
			
    		sbr2.append(" cfposttype , cfbusinessdate, CFCLINICNUMBER,CFCLINICName,cfempnumber,cfempname,CFCITYNUMBER,CFCITYName,CFJyCount, CFPlaCount , CFWhiteAchieve  "+insertSql+" "+imandxtinsertsql+" ) ");
    		sbr2.append("values(newbosid('20D1E187'),'"+userId+"',sysdate,'"+userId+"',sysdate, ");
    		sbr2.append(" 'JZYS', '"+periodnum+"','"+clinicNumber+"','' ,'"+empNum+"','"+tempMap.get("empName").toString()+"','"+cityNumber+"','"+tempMap.get("cityName").toString()+"' ,"+0+" ,"+0+" ,"+0+"  "+insertValueSql+" "+imandxtinsertValueSql+")");  
    		pe.getSqlList().add(sbr2);
    		
    		StringBuffer sbr3  = new StringBuffer(" /*dialect*/insert into CT_PAY_ClinicAchieveCosthInit (FID,FCreatorID,FCreateTime,FLastUpdateUserID,FLastUpdateTime, ");
    		sbr3.append(" cfposttype , cfbusinessdate, CFCLINICNUMBER,CFCLINICName,cfempnumber,cfempname,CFCITYNUMBER,CFCITYName,CFJyCount, CFPlaCount , CFWhiteAchieve  "+insertSql+" ) ");
    		sbr3.append("values(newbosid('F965A954'),'"+userId+"',sysdate,'"+userId+"',sysdate, ");
    		sbr3.append(" 'JZYS', '"+periodnum+"','"+clinicNumber+"','' ,'"+empNum+"','"+tempMap.get("empName").toString()+"','"+cityNumber+"','"+tempMap.get("cityName").toString()+"' ,"+0+" ,"+0+" ,"+0+"  "+insertValueSql+")");  
    		pe.getSqlList().add(sbr3);
    		
    		pe.executeUpdate(ctx);
			pool.shutdown();   
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			pool.shutdown(); 
		}
		//自带患者 用减去成本 
		
		BigDecimal byzzMoney = byzz.subtract(zzcb).compareTo(BigDecimal.ZERO) > 0 ? byzz.subtract(zzcb).multiply(byzzbl):BigDecimal.ZERO;
		BigDecimal bygdjzMoney = bygdjz.subtract(gdjzcb).compareTo(BigDecimal.ZERO) > 0 ? bygdjz.subtract(gdjzcb).multiply(bygdjzbl):BigDecimal.ZERO;
		BigDecimal byyxjzMoney = byyxjz.subtract(yxjzcb).compareTo(BigDecimal.ZERO) > 0 ? byyxjz.subtract(yxjzcb).multiply(byyxjzbl):BigDecimal.ZERO;
		BigDecimal byyzMoney = byyz.subtract(yzcb).compareTo(BigDecimal.ZERO) > 0 ? byyz.subtract(yzcb).multiply(byyzbl):BigDecimal.ZERO;
		BigDecimal byknwMoney = byknw.subtract(knwcb).compareTo(BigDecimal.ZERO) > 0 ? byknw.subtract(knwcb).multiply(byknwbl):BigDecimal.ZERO;
		BigDecimal bymbMoney = bymb.subtract(mbcb).compareTo(BigDecimal.ZERO) > 0 ? bymb.subtract(mbcb).multiply(bymbbl):BigDecimal.ZERO;
		BigDecimal byxfMoney = byxf.subtract(xfcb).compareTo(BigDecimal.ZERO) > 0 ? byxf.subtract(xfcb).multiply(byxfbl):BigDecimal.ZERO;
		BigDecimal byeyMoney = byey.subtract(eycb).compareTo(BigDecimal.ZERO) > 0 ? byey.subtract(eycb).multiply(byeybl):BigDecimal.ZERO;
		
		BigDecimal bymoney = byzzMoney.add(bygdjzMoney).add(byyxjzMoney).add(byyzMoney).add(byknwMoney).add(bymbMoney).add(byxfMoney).add(byeyMoney)
			.setScale(2,BigDecimal.ROUND_HALF_UP); 
		
		
		
		
		
		return bymoney;
		
	}
	
	public  StringBuffer getHushiZiDaiChengBenSql(String empNums, String cityNumber,String periodnum,StringBuffer sqlCB){
		sqlCB.append(" /*dialect*/ select ( nvl(sum(cfxhzz),0) +nvl(sum(cfjgfzz),0)) as summ,'zz' as type  from  CT_PAY_CostByUpdate  where cfperiod = '"+periodnum+"' and cfcitynumber='"+cityNumber+"' and  cfdoctornumber in ("+empNums+") and cfiszidai = 1   union ");
		sqlCB.append(" 	select ( nvl(sum(cfxhyxjz),0) +nvl(sum(cfjgfyxjz),0)) as summ,'yxjz' as type  from  CT_PAY_CostByUpdate  where cfperiod = '"+periodnum+"' and cfcitynumber='"+cityNumber+"'  and  cfdoctornumber in ("+empNums+") and cfiszidai = 1  union ");
		sqlCB.append(" 	select ( nvl(sum(cfxhcgjz),0) +nvl(sum(cfjgfcgjz),0)) as summ,'gdjz' as type  from  CT_PAY_CostByUpdate  where cfperiod = '"+periodnum+"' and cfcitynumber='"+cityNumber+"'   and  cfdoctornumber in ("+empNums+") and cfiszidai = 1  union ");
		sqlCB.append(" 	select ( nvl(sum(cfxhknw),0) +nvl(sum(cfjgfknw),0)) as summ,'knw' as type  from  CT_PAY_CostByUpdate  where cfperiod = '"+periodnum+"' and cfcitynumber='"+cityNumber+"'    and  cfdoctornumber in ("+empNums+")and cfiszidai = 1   union ");
		sqlCB.append(" 	select ( nvl(sum(cfxhxf),0) +nvl(sum(cfjgfxf),0)) as summ,'xf' as type  from  CT_PAY_CostByUpdate  where cfperiod = '"+periodnum+"'   and cfcitynumber='"+cityNumber+"' and  cfdoctornumber  in ("+empNums+") and cfiszidai = 1  union ");
		sqlCB.append(" 	select ( nvl(sum(cfxhey),0) +nvl(sum(cfjgfey),0)) as summ,'ey' as type  from  CT_PAY_CostByUpdate  where cfperiod = '"+periodnum+"'  and cfcitynumber='"+cityNumber+"'  and  cfdoctornumber  in ("+empNums+") and cfiszidai = 1  union ");
		sqlCB.append(" 	select ( nvl(sum(cfxhyz),0) +nvl(sum(cfjgfyz),0)) as summ,'yz' as type  from  CT_PAY_CostByUpdate  where cfperiod = '"+periodnum+"' and cfcitynumber='"+cityNumber+"'   and  cfdoctornumber in ("+empNums+")  and cfiszidai = 1  union ");
		sqlCB.append(" 	select ( nvl(sum(cfjgfmb),0) +nvl(sum(cfxhmb),0) ) as summ,'mb' as type  from  CT_PAY_CostByUpdate  where cfperiod = '"+periodnum+"'  and cfcitynumber='"+cityNumber+"'  and  cfdoctornumber in ("+empNums+") and cfiszidai = 1   ");
		
		return sqlCB;
	}
	
	public StringBuffer getImportZiDaiChengBenSql(String empNums, String cityID,String periodnum,StringBuffer sqlCB){ 
		sqlCB.append(" /*dialect*/select ( nvl(sum(cfzjcost),0) ) as summ,'zz' as type   FROM  CT_PAY_DoctorCosts  where CFBUSINESSDATE ='"+periodnum+"' and cfcityid='"+cityID+"'  and  cfempNumber in ("+empNums+") and cfiszidai = 1  ");
		sqlCB.append(" union select ( nvl(sum(cfyxcost),0) ) as summ,'yxjz' as type   FROM CT_PAY_DoctorCosts  where CFBUSINESSDATE ='"+periodnum+"'   and cfcityid='"+cityID+"' and  cfempNumber in ("+empNums+")and cfiszidai = 1  ");
		sqlCB.append(" 	 union select ( nvl(sum(cfgdcost),0) ) as summ,'gdjz' as type   FROM CT_PAY_DoctorCosts  where CFBUSINESSDATE ='"+periodnum+"'  and cfcityid='"+cityID+"'  and  cfempNumber in ("+empNums+") and cfiszidai = 1  ");
		sqlCB.append(" 	 union select ( nvl(sum(cfkncost),0)) as summ,'knw' as type   FROM CT_PAY_DoctorCosts  where CFBUSINESSDATE ='"+periodnum+"' and cfcityid='"+cityID+"'  and  cfempNumber in ("+empNums+") and cfiszidai = 1   ");
		sqlCB.append(" 	 union select ( nvl(sum(cfxfcost),0) ) as summ,'xf' as type   FROM CT_PAY_DoctorCosts  where CFBUSINESSDATE ='"+periodnum+"' and cfcityid='"+cityID+"'  and  cfempNumber in ("+empNums+") and cfiszidai = 1  ");
		sqlCB.append(" 	 union select ( nvl(sum(cfeycost),0)) as summ,'ey' as type   FROM CT_PAY_DoctorCosts  where CFBUSINESSDATE ='"+periodnum+"'  and cfcityid='"+cityID+"'  and  cfempNumber in ("+empNums+") and cfiszidai = 1   ");
		sqlCB.append(" 	 union select ( nvl(sum(cfzbcost),0)) as summ,'yz' as type   FROM CT_PAY_DoctorCosts  where CFBUSINESSDATE ='"+periodnum+"'  and cfcityid='"+cityID+"' and  cfempNumber in ("+empNums+") and cfiszidai = 1  ");
		sqlCB.append(" 	 union select ( nvl(sum(cfmbcost),0)) as summ,'mb' as type  FROM CT_PAY_DoctorCosts  where CFBUSINESSDATE ='"+periodnum+"'  and cfcityid='"+cityID+"' and  cfempNumber in ("+empNums+") and cfiszidai = 1  ");
		
		return sqlCB;
	}
	public StringBuffer getYeJiZIDaiImpSql(String empNum, String cityNumber,String periodnum,StringBuffer sqlYJ,String cityId){
		//种植   and CFClinicNumber='"+clinicNumber+"'
		sqlYJ.append("  /*dialect*/ SELECT  nvl( sum(cfzzachieve),0) as ZZ , nvl(sum(cfyxjzachieve),0) as YXJZ , nvl(sum(cfgdjzachieve),0) as GDJZ , nvl(sum(cfknwachieve),0) as KNW , nvl(sum(cfxfachieve),0) as XF , nvl(sum(cfeyachieve),0) as EY , nvl(sum(cfyzachieve),0) as YZ , nvl(sum(cfmbachieve),0) as MB , nvl(sum(cfjzmoney),0) as JZ   ")
		.append(" FROM  CT_PAY_DocAchieveUpdate where cfcityid = '"+cityId+"' and ( cfiszidai = 0 or cfiszidai is null) and cfdocnumber = '"+empNum+"' and  cfbusinessdate = '"+periodnum+"' ");
		  
		return sqlYJ;
	}
}
