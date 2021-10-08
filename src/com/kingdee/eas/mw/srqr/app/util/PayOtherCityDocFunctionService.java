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
import com.kingdee.eas.mw.pay.DocAchieveUpdateFactory;
import com.kingdee.eas.mw.pay.DocAchieveUpdateInfo;
import com.kingdee.eas.mw.pay.DoctorCostsFactory;
import com.kingdee.eas.mw.pay.DoctorCostsInfo;
import com.kingdee.eas.mw.pay.app.costType;
import com.kingdee.jdbc.rowset.IRowSet;

public class PayOtherCityDocFunctionService {

	private Logger log;
	public PayOtherCityDocFunctionService() {
		this.log = LoggerFactory.getLogger(PayOtherCityDocFunctionService.class);
	}
	/**
	 * 获取医生奖金
	 */
	public HashMap<String,Object>  getDocBonus(Context ctx,String empNum, String clinicNumber,String periodnum,HashMap tempMap,String cityId,String cityNumber,String type , String calType ,String docStageType
			,HashMap<String, BigDecimal> docAllAchieveMap){
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
			
			
			//导入种植
			BigDecimal imzz = BigDecimal.ZERO; 
			//导入固定矫正
			BigDecimal imgdjz = BigDecimal.ZERO; 
			//导入隐形矫正
			BigDecimal imyxjz = BigDecimal.ZERO; 
			//导入牙周
			BigDecimal imyz = BigDecimal.ZERO; 
			//导入口内外
			BigDecimal imknw = BigDecimal.ZERO; 
			//导入美白
			BigDecimal immb = BigDecimal.ZERO; 
			//导入修复
			BigDecimal imxf = BigDecimal.ZERO; 
			//导入儿牙
			BigDecimal imey = BigDecimal.ZERO; 
			
			
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
			//正畸业绩
			BigDecimal zjyeji = BigDecimal.ZERO;  
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
			
			clinicCostSumInfo.setUpgdjzCost(BigDecimal.ZERO);clinicCostSumInfo.setImgdjzCost(BigDecimal.ZERO); 
			clinicCostSumInfo.setUpzzCost(BigDecimal.ZERO);clinicCostSumInfo.setImzzCost(BigDecimal.ZERO);
			clinicCostSumInfo.setUpyxjzCost(BigDecimal.ZERO);clinicCostSumInfo.setImyxjzCost(BigDecimal.ZERO);
			clinicCostSumInfo.setUpyzCost(BigDecimal.ZERO);clinicCostSumInfo.setImyzCost(BigDecimal.ZERO);
			clinicCostSumInfo.setUpknwCost(BigDecimal.ZERO);clinicCostSumInfo.setImknwCost(BigDecimal.ZERO);
			clinicCostSumInfo.setUpmbCost(BigDecimal.ZERO);clinicCostSumInfo.setImmbCost(BigDecimal.ZERO);
			clinicCostSumInfo.setUpxfCost(BigDecimal.ZERO);clinicCostSumInfo.setImxfCost(BigDecimal.ZERO);
			clinicCostSumInfo.setUpeyCost(BigDecimal.ZERO);clinicCostSumInfo.setImeyCost(BigDecimal.ZERO);
			
			clinicCostSumInfo.setEmpNumber(empNum);
			clinicCostSumInfo.setClinicNumber(clinicNumber);
			clinicCostSumInfo.setCityNumber(cityNumber);
			clinicCostSumInfo.setBusinessDate(periodnum); 
			clinicCostSumInfo.setCityName(tempMap.get("cityName").toString());
			clinicCostSumInfo.setEmpName(tempMap.get("empName").toString());
			
			
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
				String  isDoc = "/*dialect*/  SELECT  CFASSNUMBER,nvl(CFBILI,0) as CFBILI  FROM  CT_PAY_DoctorRelation where  cfdocnumber = '"+empNum+"' and cfbusinessdate = '"+periodnum+"'  and cfcityid = '"+cityId+"' and cfasstype = 'yz' ";
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

						if( docAllAchieveMap.get(assNumber+"_zz_DOC_XT_ACHIEVE") != null ){//种植 
							BigDecimal achieve = docAllAchieveMap.get(assNumber+"_zz_DOC_XT_ACHIEVE").multiply(bili);
				  			zz = zz.add(achieve);   
				  		}
						if( docAllAchieveMap.get(assNumber+"_gd_DOC_XT_ACHIEVE") != null  ){//固定矫正 ？
				  			BigDecimal achieve = docAllAchieveMap.get(assNumber+"_gd_DOC_XT_ACHIEVE").multiply(bili).multiply(zjbl);
				  			gdjz= gdjz.add(achieve);  
				  		}
						if( docAllAchieveMap.get(assNumber+"_yx_DOC_XT_ACHIEVE") != null){//隐形矫正
				  			BigDecimal achieve = docAllAchieveMap.get(assNumber+"_yx_DOC_XT_ACHIEVE").multiply(bili).multiply(zjbl);
				  			yxjz= yxjz.add(achieve);  
				  		}
						if( docAllAchieveMap.get(assNumber+"_yz_DOC_XT_ACHIEVE") != null){//牙周 
				  			BigDecimal achieve = docAllAchieveMap.get(assNumber+"_yz_DOC_XT_ACHIEVE").multiply(bili);
				  			yz= yz.add(achieve);  
				  		}
						if( docAllAchieveMap.get(assNumber+"_mb_DOC_XT_ACHIEVE") != null){//美白
				  			BigDecimal achieve = docAllAchieveMap.get(assNumber+"_mb_DOC_XT_ACHIEVE").multiply(bili);
				  			mb= mb.add(achieve);  
				  		} 
						 
						if(   docAllAchieveMap.get(assNumber+"_knw_DOC_XT_ACHIEVE") != null ){//口内外 
				  			BigDecimal achieve = docAllAchieveMap.get(assNumber+"_knw_DOC_XT_ACHIEVE").multiply(bili);
				  			knw = knw.add(achieve);  
				  		}
						if(  docAllAchieveMap.get(assNumber+"_xf_DOC_XT_ACHIEVE") != null ){//修复
				  			BigDecimal achieve = docAllAchieveMap.get(assNumber+"_xf_DOC_XT_ACHIEVE").multiply(bili);
				  			xf= xf.add(achieve);   
				  		}
						if( docAllAchieveMap.get(assNumber+"_ey_DOC_XT_ACHIEVE") != null ){//儿牙
				  			BigDecimal achieve = docAllAchieveMap.get(assNumber+"_ey_DOC_XT_ACHIEVE").multiply(bili);
				  			ey= ey.add(achieve);  
				  		}
						if( docAllAchieveMap.get(assNumber+"_zj_DOC_XT_ACHIEVE") != null ){//正畸
				  			BigDecimal achieve = docAllAchieveMap.get(assNumber+"_zj_DOC_XT_ACHIEVE").multiply(bili).multiply(zjbl);
				  			zjyeji= zjyeji.add(achieve);  
				  		}
					}
					    
				}
				//查看自己是否为医助    如果自己为医助  按照比例取自己的业绩
				
				//一个医助 对应多个医生   有没有情况    不会  
				
				if("".equals(isDocOrAss)){
					String  isAss = " /*dialect*/ SELECT  CFDOCNUMBER,nvl(CFBILI,0) as CFBILI  FROM  CT_PAY_DoctorRelation where  CFASSNUMBER = '"+empNum+"' and cfbusinessdate = '"+periodnum+"'  and cfcityid = '"+cityId+"' and cfasstype = 'yz' ";
					IRowSet isAssRs = com.kingdee.eas.custom.util.DBUtil.executeQuery(ctx,isAss); 
					if(isAssRs!=null && isAssRs.size() > 0){
						  isDocOrAss ="ASS";
						  costEmp  = "'"+empNum+"'";
						  
						  BigDecimal bili = new BigDecimal("0.4");
						  while(isAssRs.next()){	
								String docNumber = isAssRs.getString("CFDOCNUMBER");
								bili = new BigDecimal("1").subtract(new BigDecimal(isAssRs.getString("CFBILI")));
								StringBuffer sqlYJ = new StringBuffer(); 
								  //传递自己的编码  分给医生
								if( docAllAchieveMap.get(empNum+"_zz_DOC_XT_ACHIEVE") != null ){//种植 
									BigDecimal achieve = docAllAchieveMap.get(empNum+"_zz_DOC_XT_ACHIEVE").multiply(bili);
									zz = zz.add(achieve);   
								}
								if( docAllAchieveMap.get(empNum+"_gd_DOC_XT_ACHIEVE") != null  ){//固定矫正 ？
									BigDecimal achieve = docAllAchieveMap.get(empNum+"_gd_DOC_XT_ACHIEVE").multiply(bili).multiply(zjbl);
									gdjz= gdjz.add(achieve);  
								}
								if( docAllAchieveMap.get(empNum+"_yx_DOC_XT_ACHIEVE") != null){//隐形矫正
									BigDecimal achieve = docAllAchieveMap.get(empNum+"_yx_DOC_XT_ACHIEVE").multiply(bili).multiply(zjbl);
									yxjz= yxjz.add(achieve);  
								}
								if( docAllAchieveMap.get(empNum+"_yz_DOC_XT_ACHIEVE") != null){//牙周 
									BigDecimal achieve = docAllAchieveMap.get(empNum+"_yz_DOC_XT_ACHIEVE").multiply(bili);
									yz= yz.add(achieve);  
								}
								if( docAllAchieveMap.get(empNum+"_mb_DOC_XT_ACHIEVE") != null){//美白
									BigDecimal achieve = docAllAchieveMap.get(empNum+"_mb_DOC_XT_ACHIEVE").multiply(bili);
									mb= mb.add(achieve);  
								} 
								 
								if(   docAllAchieveMap.get(empNum+"_knw_DOC_XT_ACHIEVE") != null ){//口内外 
									BigDecimal achieve = docAllAchieveMap.get(empNum+"_knw_DOC_XT_ACHIEVE").multiply(bili);
									knw = knw.add(achieve);  
								}
								if(  docAllAchieveMap.get(empNum+"_xf_DOC_XT_ACHIEVE") != null ){//修复
									BigDecimal achieve = docAllAchieveMap.get(empNum+"_xf_DOC_XT_ACHIEVE").multiply(bili);
									xf= xf.add(achieve);   
								}
								if( docAllAchieveMap.get(empNum+"_ey_DOC_XT_ACHIEVE") != null ){//儿牙
									BigDecimal achieve = docAllAchieveMap.get(empNum+"_ey_DOC_XT_ACHIEVE").multiply(bili);
									ey= ey.add(achieve);  
								}
								if( docAllAchieveMap.get(empNum+"_zj_DOC_XT_ACHIEVE") != null ){//正畸
									BigDecimal achieve = docAllAchieveMap.get(empNum+"_zj_DOC_XT_ACHIEVE").multiply(bili).multiply(zjbl);
									zjyeji= zjyeji.add(achieve);  
								}
							  
						  }
						  
						   
					} 
				} 
				
				if("DOC".equals(isDocOrAss)|| "".equals(isDocOrAss)){
					costEmp ="'"+empNum+"'";
					if( docAllAchieveMap.get(empNum+"_zz_DOC_XT_ACHIEVE") != null ){//种植 
						BigDecimal achieve = docAllAchieveMap.get(empNum+"_zz_DOC_XT_ACHIEVE");
						zz = zz.add(achieve);   
					}
					if( docAllAchieveMap.get(empNum+"_gd_DOC_XT_ACHIEVE") != null  ){//固定矫正 
						BigDecimal achieve = docAllAchieveMap.get(empNum+"_gd_DOC_XT_ACHIEVE").multiply(zjbl);
						gdjz= gdjz.add(achieve);  
					}
					if( docAllAchieveMap.get(empNum+"_yx_DOC_XT_ACHIEVE") != null){//隐形矫正
						BigDecimal achieve = docAllAchieveMap.get(empNum+"_yx_DOC_XT_ACHIEVE").multiply(zjbl);
						yxjz= yxjz.add(achieve);  
					}
					if( docAllAchieveMap.get(empNum+"_yz_DOC_XT_ACHIEVE") != null){//牙周 
						BigDecimal achieve = docAllAchieveMap.get(empNum+"_yz_DOC_XT_ACHIEVE");
						yz= yz.add(achieve);  
					}
					if( docAllAchieveMap.get(empNum+"_mb_DOC_XT_ACHIEVE") != null){//美白
						BigDecimal achieve = docAllAchieveMap.get(empNum+"_mb_DOC_XT_ACHIEVE");
						mb= mb.add(achieve);  
					} 
					 
					if(   docAllAchieveMap.get(empNum+"_knw_DOC_XT_ACHIEVE") != null ){//口内外 
						BigDecimal achieve = docAllAchieveMap.get(empNum+"_knw_DOC_XT_ACHIEVE");
						knw = knw.add(achieve);  
					}
					if(  docAllAchieveMap.get(empNum+"_xf_DOC_XT_ACHIEVE") != null ){//修复
						BigDecimal achieve = docAllAchieveMap.get(empNum+"_xf_DOC_XT_ACHIEVE");
						xf= xf.add(achieve);   
					}
					if( docAllAchieveMap.get(empNum+"_ey_DOC_XT_ACHIEVE") != null ){//儿牙
						BigDecimal achieve = docAllAchieveMap.get(empNum+"_ey_DOC_XT_ACHIEVE");
						ey= ey.add(achieve);  
					}
					if( docAllAchieveMap.get(empNum+"_zj_DOC_XT_ACHIEVE") != null ){//正畸
						BigDecimal achieve = docAllAchieveMap.get(empNum+"_zj_DOC_XT_ACHIEVE").multiply(zjbl);
						zjyeji= zjyeji.add(achieve);  
					} 
				} 	 
				
				imandxtinsertsql +=  ", CFXTZZACHIEVE , cfXTyxjzachieve, CFXTyzAchieve , cfXTknwachieve , cfXTmbachieve , cfXTxfachieve, cfXTeyachieve ";
				imandxtinsertValueSql +=" ,"+zz+" ,"+yxjz+","+yz+","+knw+","+mb+","+xf+","+ey+"  ";
				
				//导入种植
				imzz = docAllAchieveMap.get(empNum+"_ZZ_DOC_IMP_ACHIEVE")==null? BigDecimal.ZERO:docAllAchieveMap.get(empNum+"_ZZ_DOC_IMP_ACHIEVE");
				//导入固定矫正
				imgdjz = docAllAchieveMap.get(empNum+"_GD_DOC_IMP_ACHIEVE")==null? BigDecimal.ZERO:docAllAchieveMap.get(empNum+"_GD_DOC_IMP_ACHIEVE");
				//导入隐形矫正
				imyxjz = docAllAchieveMap.get(empNum+"_YX_DOC_IMP_ACHIEVE")==null? BigDecimal.ZERO:docAllAchieveMap.get(empNum+"_YX_DOC_IMP_ACHIEVE");
				//导入牙周
				imyz = docAllAchieveMap.get(empNum+"_YZ_DOC_IMP_ACHIEVE")==null? BigDecimal.ZERO:docAllAchieveMap.get(empNum+"_YZ_DOC_IMP_ACHIEVE");
				//导入口内外
				imknw = docAllAchieveMap.get(empNum+"_KNW_DOC_IMP_ACHIEVE")==null? BigDecimal.ZERO:docAllAchieveMap.get(empNum+"_KNW_DOC_IMP_ACHIEVE");
				//导入美白
				immb = docAllAchieveMap.get(empNum+"_MB_DOC_IMP_ACHIEVE")==null? BigDecimal.ZERO:docAllAchieveMap.get(empNum+"_MB_DOC_IMP_ACHIEVE");
				//导入修复
				imxf = docAllAchieveMap.get(empNum+"_XF_DOC_IMP_ACHIEVE")==null? BigDecimal.ZERO:docAllAchieveMap.get(empNum+"_XF_DOC_IMP_ACHIEVE");
				//导入儿牙
				imey = docAllAchieveMap.get(empNum+"_EY_DOC_IMP_ACHIEVE")==null? BigDecimal.ZERO:docAllAchieveMap.get(empNum+"_EY_DOC_IMP_ACHIEVE");
				
				zz = zz.add(imzz); 
				if(zjyeji.compareTo(BigDecimal.ZERO) > 0){//正畸有业绩   固定和隐形就不能有业绩
					imandxtinsertsql +=  " , CFXTGDJZACHIEVE ";
					imandxtinsertValueSql += " ,"+zjyeji+" ";
					gdjz= zjyeji.add(imgdjz); 
				}else{
					imandxtinsertsql +=  " , CFXTGDJZACHIEVE ";
					imandxtinsertValueSql += " ,"+gdjz+" ";
					gdjz= gdjz.add(imgdjz); 
				}
		  		
		  		yxjz= yxjz.add(imyxjz); 
		  		yz= yz.add(imyz); 
		  		knw = knw.add(imknw);
		  		mb= mb.add(immb); 
		  		xf= xf.add(imxf);  
		  		ey= ey.add(imey);   
				 
		  		  
/*
				if( docAllAchieveMap.get(empNum+"_zz_DOC_IMP_CB") != null ){//种植
					  zzcb =docAllAchieveMap.get(empNum+"_zz_DOC_IMP_CB");  
					  clinicCostSumInfo.setImzzCost(zzcb);
				}
				if( docAllAchieveMap.get(empNum+"_gdjz_DOC_IMP_CB")!= null  ){//固定矫正
					  gdjzcb= docAllAchieveMap.get(empNum+"_gdjz_DOC_IMP_CB") ;  
					  clinicCostSumInfo.setImgdjzCost(gdjzcb);
				}
				if( docAllAchieveMap.get(empNum+"_yxjz_DOC_IMP_CB") != null ){//隐形矫正
					  yxjzcb= docAllAchieveMap.get(empNum+"_yxjz_DOC_IMP_CB");  
					  clinicCostSumInfo.setImyxjzCost(yxjzcb);
				}
				if( docAllAchieveMap.get(empNum+"_yz_DOC_IMP_CB")  != null  ){//牙周
					  yzcb=docAllAchieveMap.get(empNum+"_yz_DOC_IMP_CB") ;  
					  clinicCostSumInfo.setImyzCost(yzcb);
				}
				if( docAllAchieveMap.get(empNum+"_knw_DOC_IMP_CB")  != null ){//口内外
					  knwcb =docAllAchieveMap.get(empNum+"_knw_DOC_IMP_CB") ; 
					  clinicCostSumInfo.setImknwCost(knwcb);
				}
				if(  docAllAchieveMap.get(empNum+"_mb_DOC_IMP_CB")  != null ){//美白
					  mbcb= docAllAchieveMap.get(empNum+"_mb_DOC_IMP_CB") ;  
					  clinicCostSumInfo.setImmbCost(mbcb);
				}
				if( docAllAchieveMap.get(empNum+"_xf_DOC_IMP_CB")  != null ){//修复
					  xfcb= docAllAchieveMap.get(empNum+"_xf_DOC_IMP_CB") ;  
					  clinicCostSumInfo.setImxfCost(xfcb);
				}
				if(  docAllAchieveMap.get(empNum+"_ey_DOC_IMP_CB")  != null ){//儿牙
					  eycb=docAllAchieveMap.get(empNum+"_ey_DOC_IMP_CB");  
					  clinicCostSumInfo.setImeyCost(eycb); 
				}*/
				
				 
			    //获得 导入的成本
				StringBuffer sqlImportCB = new StringBuffer(); 
				sqlImportCB = getImportChengBenSql( costEmp,  cityId, periodnum, sqlImportCB);
				IRowSet imporytbrs = com.kingdee.eas.custom.util.DBUtil.executeQuery(ctx,sqlImportCB.toString());
				if(imporytbrs!=null && imporytbrs.size() > 0){
					  while(imporytbrs.next()){	
						  if("zz".equals(imporytbrs.getString("TYPE"))){//种植
							  zzcb =new BigDecimal(imporytbrs.getString("SUMM")); 
							  //costAll = costAll.add(zzcb);
							   
							  clinicCostSumInfo.setImzzCost(zzcb);
						  }else if("gdjz".equals(imporytbrs.getString("TYPE"))){//固定矫正
							  gdjzcb=new BigDecimal(imporytbrs.getString("SUMM")); 
							  //costAll = costAll.add(gdjzcb);
							   
							  clinicCostSumInfo.setImgdjzCost(gdjzcb);
						  }else if("yxjz".equals(imporytbrs.getString("TYPE"))){//隐形矫正
							  yxjzcb=new BigDecimal(imporytbrs.getString("SUMM")); 
							  //costAll = costAll.add(yxjzcb);
							   
							  clinicCostSumInfo.setImyxjzCost(yxjzcb);
						  }else if("yz".equals(imporytbrs.getString("TYPE"))){//牙周
							  yzcb=new BigDecimal(imporytbrs.getString("SUMM")); 
							  //costAll = costAll.add(yzcb);
							   
							  clinicCostSumInfo.setImyzCost(yzcb);
						  }else if("knw".equals(imporytbrs.getString("TYPE"))){//口内外
							  knwcb =new BigDecimal(imporytbrs.getString("SUMM"));
							  //costAll = costAll.add(knwcb);
							   
							  clinicCostSumInfo.setImknwCost(knwcb);
						  }else if("mb".equals(imporytbrs.getString("TYPE"))){//美白
							  mbcb=new BigDecimal(imporytbrs.getString("SUMM")); 
							  //costAll = costAll.add(mbcb); 
							  
							  clinicCostSumInfo.setImmbCost(mbcb);
						  }else if("xf".equals(imporytbrs.getString("TYPE"))){//修复
							  xfcb=new BigDecimal(imporytbrs.getString("SUMM")); 
							  //costAll = costAll.add(xfcb);
							   
							  clinicCostSumInfo.setImxfCost(xfcb);
						  }else if("ey".equals(imporytbrs.getString("TYPE"))){//儿牙
							  eycb=new BigDecimal(imporytbrs.getString("SUMM")); 
							  //costAll = costAll.add(eycb);
							  
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
							  //costAll = costAll.add(new BigDecimal(hushiCBrs.getString("SUMM"))); 
							  clinicCostSumInfo.setUpzzCost(new BigDecimal(hushiCBrs.getString("SUMM")));
						  }else if("gdjz".equals(hushiCBrs.getString("TYPE"))){//固定矫正
							  gdjzcb = gdjzcb.add(new BigDecimal(hushiCBrs.getString("SUMM"))); 
							  //costAll = costAll.add(new BigDecimal(hushiCBrs.getString("SUMM")));
							    
							  clinicCostSumInfo.setUpgdjzCost(new BigDecimal(hushiCBrs.getString("SUMM")));
						  }else if("yxjz".equals(hushiCBrs.getString("TYPE"))){//隐形矫正
							  yxjzcb = yxjzcb.add(new BigDecimal(hushiCBrs.getString("SUMM"))); 
							  //costAll = costAll.add(new BigDecimal(hushiCBrs.getString("SUMM"))); 
							  
							  clinicCostSumInfo.setUpyxjzCost(new BigDecimal(hushiCBrs.getString("SUMM")));
						  }else if("yz".equals(hushiCBrs.getString("TYPE"))){//牙周
							  yzcb = yzcb.add(new BigDecimal(hushiCBrs.getString("SUMM"))); 
							  //costAll = costAll.add(new BigDecimal(hushiCBrs.getString("SUMM"))); 
							  
							  clinicCostSumInfo.setUpyzCost(new BigDecimal(hushiCBrs.getString("SUMM")));
						  }else if("knw".equals(hushiCBrs.getString("TYPE"))){//口内外
							  knwcb = knwcb.add(new BigDecimal(hushiCBrs.getString("SUMM")));
							  //costAll = costAll.add(new BigDecimal(hushiCBrs.getString("SUMM"))); 
							  
							  clinicCostSumInfo.setUpknwCost(new BigDecimal(hushiCBrs.getString("SUMM")));
						  }else if("mb".equals(hushiCBrs.getString("TYPE"))){//美白
							  mbcb = mbcb.add(new BigDecimal(hushiCBrs.getString("SUMM"))); 
							  //costAll = costAll.add(new BigDecimal(hushiCBrs.getString("SUMM")));  
							  
							  clinicCostSumInfo.setUpmbCost(new BigDecimal(hushiCBrs.getString("SUMM")));
						  }else if("xf".equals(hushiCBrs.getString("TYPE"))){//修复
							  xfcb = xfcb.add(new BigDecimal(hushiCBrs.getString("SUMM"))); 
							  //costAll = costAll.add(new BigDecimal(hushiCBrs.getString("SUMM"))); 
							  
							  clinicCostSumInfo.setUpxfCost(new BigDecimal(hushiCBrs.getString("SUMM")));
						  }else if("ey".equals(hushiCBrs.getString("TYPE"))){//儿牙
							  eycb = eycb.add(new BigDecimal(hushiCBrs.getString("SUMM"))); 
							  //costAll = costAll.add(new BigDecimal(hushiCBrs.getString("SUMM")));  
							  
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
							  //costAll = costAll.add(new BigDecimal(cbrs.getString("SUMM"))); 

							  clinicCostSumInfo.setZzCost(new BigDecimal(cbrs.getString("SUMM")));
						  }else if("gdjz".equals(cbrs.getString("TYPE"))){//固定矫正
							  gdjzcb = gdjzcb.add(new BigDecimal(cbrs.getString("SUMM"))); 
							  //costAll = costAll.add(new BigDecimal(cbrs.getString("SUMM"))); 
							  
							  clinicCostSumInfo.setGdjzCost(new BigDecimal(cbrs.getString("SUMM")));
						  }else if("yxjz".equals(cbrs.getString("TYPE"))){//隐形矫正
							  yxjzcb = yxjzcb.add(new BigDecimal(cbrs.getString("SUMM"))); 
							  //costAll = costAll.add(new BigDecimal(cbrs.getString("SUMM"))); 
							  
							  clinicCostSumInfo.setYxjzCost(new BigDecimal(cbrs.getString("SUMM")));
						  }else if("yz".equals(cbrs.getString("TYPE"))){//牙周
							  yzcb = yzcb.add(new BigDecimal(cbrs.getString("SUMM"))); 
							  //costAll = costAll.add(new BigDecimal(cbrs.getString("SUMM"))); 
							  
							  clinicCostSumInfo.setYzCost(new BigDecimal(cbrs.getString("SUMM")));
						  }else if("knw".equals(cbrs.getString("TYPE"))){//口内外
							  knwcb = knwcb.add(new BigDecimal(cbrs.getString("SUMM")));
							  //costAll = costAll.add(new BigDecimal(cbrs.getString("SUMM"))); 
							  
							  clinicCostSumInfo.setKnwCost(new BigDecimal(cbrs.getString("SUMM")));
						  }else if("mb".equals(cbrs.getString("TYPE"))){//美白
							  mbcb = mbcb.add(new BigDecimal(cbrs.getString("SUMM"))); 
							  //costAll = costAll.add(new BigDecimal(cbrs.getString("SUMM"))); 
							  
							  clinicCostSumInfo.setMbCost(new BigDecimal(cbrs.getString("SUMM")));
						  }else if("xf".equals(cbrs.getString("TYPE"))){//修复
							  xfcb = xfcb.add(new BigDecimal(cbrs.getString("SUMM"))); 
							  //costAll = costAll.add(new BigDecimal(cbrs.getString("SUMM"))); 
							  
							  clinicCostSumInfo.setXfCost(new BigDecimal(cbrs.getString("SUMM")));
						  }else if("ey".equals(cbrs.getString("TYPE"))){//儿牙
							  eycb = eycb.add(new BigDecimal(cbrs.getString("SUMM"))); 
							  //costAll = costAll.add(new BigDecimal(cbrs.getString("SUMM"))); 
							  
							  clinicCostSumInfo.setEyCost(new BigDecimal(cbrs.getString("SUMM")));
						  }   
					  }
					  
				}    
				 
				
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
					if(DoctorCostsFactory.getLocalInstance(ctx).exists("where BusinessDate='"+nextPeriod+"' and city = '"+cityId+"' and EmpNumber='"+empNum+"' and CostType='yk' and (Description is null or Description!='分摊扣除业绩')")){
						DoctorCostsFactory.getLocalInstance(ctx).delete("where BusinessDate='"+nextPeriod+"' and city = '"+cityId+"' and EmpNumber='"+empNum+"' and CostType='yk' and (Description is null or Description!='分摊扣除业绩')");	
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
					
//					if(DocAchieveUpdateFactory.getLocalInstance(ctx).exists("where BusinessDate='"+periodnum+"' and city = '"+cityId+"' and docNumber='"+empNum+"'   and Name='分摊扣除业绩' ")){
//						DocAchieveUpdateFactory.getLocalInstance(ctx).delete("where BusinessDate='"+periodnum+"' and city = '"+cityId+"' and docNumber='"+empNum+"'   and Name='分摊扣除业绩' "); 
//					}
					DocAchieveUpdateInfo docAchieveUpdateThis =new DocAchieveUpdateInfo();
					docAchieveUpdateThis.setBusinessDate(periodnum); 
					ctrlUnitInfo.setId(BOSUuid.read(cityId));
					docAchieveUpdateThis.setCity(ctrlUnitInfo);
					docAchieveUpdateThis.setCityNumber(cityNumber);
					docAchieveUpdateThis.setDocNumber(empNum);
					docAchieveUpdateThis.setDocName(tempMap.get("empName").toString()); 
					docAchieveUpdateThis.setName("分摊扣除业绩"); 
					boolean flag = false;
					if(null != allMap.get("negzz")){
						//clinicCostSumInfo.setImzzCost(clinicCostSumInfo.getImzzCost().add(allMap.get("negzz")));
						docAchieveUpdateThis.setZzAchieve(allMap.get("negzz").negate());
						imzz = imzz.add(allMap.get("negzz").negate());
						
						zz = zz.add(allMap.get("negzz").negate());
						
						flag = true;
					}
					if(null != allMap.get("neggdjz")){
						//clinicCostSumInfo.setImgdjzCost(clinicCostSumInfo.getImgdjzCost().add(allMap.get("neggdjz")));
						docAchieveUpdateThis.setGdjzAchieve(allMap.get("neggdjz").negate());
						imgdjz = imgdjz.add(allMap.get("neggdjz").negate());
						
						gdjz = gdjz.add(allMap.get("neggdjz").negate());
						flag = true;
					}
					if(null != allMap.get("negyxjz")){
						//clinicCostSumInfo.setImyxjzCost(clinicCostSumInfo.getImyxjzCost().add(allMap.get("negyxjz")));
						docAchieveUpdateThis.setYxjzAchieve(allMap.get("negyxjz").negate());
						imyxjz = imyxjz.add(allMap.get("negyxjz").negate());
						
						yxjz = yxjz.add(allMap.get("negyxjz").negate());
						flag = true;
					}
					if(null != allMap.get("negyz")){
						//clinicCostSumInfo.setImyzCost(clinicCostSumInfo.getImyzCost().add(allMap.get("negyz")));
						docAchieveUpdateThis.setYzAchieve(allMap.get("negyz").negate());
						imyz = imyz.add(allMap.get("neggdjz").negate());
						
						yz = yz.add(allMap.get("neggdjz").negate());
						flag = true;
					}
					if(null != allMap.get("negknw")){
						//clinicCostSumInfo.setImknwCost(clinicCostSumInfo.getImknwCost().add(allMap.get("negknw")));
						docAchieveUpdateThis.setKnwAchieve(allMap.get("negknw"));
						imknw = imknw.add(allMap.get("negknw").negate());
						
						knw = knw.add(allMap.get("negknw").negate());
						flag = true;
					}
					if(null != allMap.get("negxf")){
						//clinicCostSumInfo.setImxfCost(clinicCostSumInfo.getImxfCost().add(allMap.get("negxf")));
						docAchieveUpdateThis.setXfAchieve(allMap.get("negxf").negate());
						imxf = imxf.add(allMap.get("negxf").negate());
						
						xf = xf.add(allMap.get("negxf").negate());
						flag = true;
					}
					if(null != allMap.get("negey")){
						//clinicCostSumInfo.setImeyCost(clinicCostSumInfo.getImeyCost().add(allMap.get("negey")));
						docAchieveUpdateThis.setEyAchieve(allMap.get("negey").negate());
						imey = imey.add(allMap.get("negey").negate());
						
						ey = ey.add(allMap.get("negey").negate()); 
						flag = true;
					}
					if(flag){
						DocAchieveUpdateFactory.getLocalInstance(ctx).save(docAchieveUpdateThis);
					}
					
				}else{ 
					zzBase = zz.subtract(zzcb).compareTo(BigDecimal.ZERO)<0?BigDecimal.ZERO:zz.subtract(zzcb);
					gdjzBase = gdjz.subtract(gdjzcb).compareTo(BigDecimal.ZERO)<0?BigDecimal.ZERO:gdjz.subtract(gdjzcb);
					yxjzBase = yxjz.subtract(yxjzcb).compareTo(BigDecimal.ZERO)<0?BigDecimal.ZERO:yxjz.subtract(yxjzcb);
					yzBase = yz.subtract(yzcb).compareTo(BigDecimal.ZERO)<0?BigDecimal.ZERO:yz.subtract(yzcb);
					knwBase = knw.subtract(knwcb).compareTo(BigDecimal.ZERO)<0?BigDecimal.ZERO:knw.subtract(knwcb);
					//BigDecimal mbBase = mb.subtract(mbcb).compareTo(BigDecimal.ZERO)<0?BigDecimal.ZERO:mb.subtract(mbcb);
					xfBase = xf.subtract(xfcb).compareTo(BigDecimal.ZERO)<0?BigDecimal.ZERO:xf.subtract(xfcb);
					eyBase = ey.subtract(eycb).compareTo(BigDecimal.ZERO)<0?BigDecimal.ZERO:ey.subtract(eycb);
					
				} 
				BigDecimal sumAchieve =  zz.add(gdjz).add(yxjz).add(yz).add(knw).add(mb).add(xf).add(ey);
				BigDecimal allBase = zzBase.add(gdjzBase).add(yxjzBase).add(yzBase).add(knwBase).add(xfBase).add(eyBase);
				if(allBase.compareTo(BigDecimal.ZERO) <=0 ){
					allBase = new BigDecimal("1");
				} 
				
				//各个病种的业绩基数
				BigDecimal zzBaseData = docBase.multiply(zzBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP));
				BigDecimal gdBaseData = docBase.multiply(gdjzBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP));
				BigDecimal yxBaseData = docBase.multiply(yxjzBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP));
				BigDecimal yzBaseData = docBase.multiply(yzBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP));
				BigDecimal knwBaseData = docBase.multiply(knwBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP));
				BigDecimal mbBaseData = BigDecimal.ZERO;
				BigDecimal xfBaseData = docBase.multiply(xfBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP));
				BigDecimal eyBaseData = docBase.multiply(eyBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP));
				BigDecimal allBaseData = sumAchieve; 
				
				
				//各个病种业绩所占比例
				BigDecimal zzBasePro =  zzBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP);
				BigDecimal gdBasePro =   gdjzBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP);
				BigDecimal yxBasePro =  yxjzBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP);
				BigDecimal yzBasePro =  yzBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP);
				BigDecimal knwBasePro =  knwBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP);
				BigDecimal mbBasePro = BigDecimal.ZERO;
				BigDecimal xfBasePro =  xfBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP);
				BigDecimal eyBasePro =  eyBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP);
				
				
				//--------------------
				HashMap<String,BigDecimal> bingzhongMap = new HashMap<String,BigDecimal>();
				  
				if(docStageType.length() >0){ 
					String fdocCalType = tempMap.get(empNum+"_DOCCALTYPE").toString();
					
					//默认使用阶梯和 不使用全部业绩
					String isallAchieve = "0";
					String docCalType = "CalStageAchieve";
					
					String[] arrCalType = fdocCalType.split("&");
					if(arrCalType.length == 1){
						if(arrCalType[0].equals("0") || arrCalType[0].equals("1") ){
							isallAchieve = arrCalType[0]; 
						}else if(arrCalType[0].equals("CalStageAchieve") || arrCalType[0].equals("GetThisStagePro") ){ 
							docCalType = arrCalType[0];
						}
					}else{
						isallAchieve = arrCalType[0]; 
						docCalType = arrCalType[1].equals("null")? "CalStageAchieve" : arrCalType[1];
					}
					
					String[] arrStage = docStageType.split("&");
					
					for(int ii = 0 ; ii < arrStage.length ; ii++ ){
						String incType = arrStage[ii]; 
						BigDecimal achieve = BigDecimal.ZERO;
						
						if(isallAchieve.equals("1")){ //如果去最高业绩  只能使用最高业绩提成比例
							achieve = sumAchieve;
							
							String docStageSql = " /*dialect*/ select CFBusinessDate , CFType , CFEmpNumber , CFEmpName , nvl(CFBrginAmount,0) as CFBrginAmount , nvl(CFEndAmount,0) as CFEndAmount ,nvl(CFPro,0) as CFPro  , nvl(CFBaseAchieve,0) as CFBaseAchieve  "+
							"  from  CT_PAY_DocStage where  CFEmpNumber = '"+empNum+"' and CFCityID = '"+cityId+"' and CFBusinessDate = "+periodnum+"  and CFType='"+incType+"'  order by CFBrginAmount ";
							IRowSet docStagers = com.kingdee.eas.custom.util.DBUtil.executeQuery(ctx,docStageSql);
							if(docStagers!=null && docStagers.size() > 0){
								  while(docStagers.next()){	
									  String typeStage =  (String) docStagers.getObject("CFTYPE");
									  BigDecimal beginAmount =  (BigDecimal)docStagers.getObject("CFBRGINAMOUNT");
									  BigDecimal endAmount =  (BigDecimal)docStagers.getObject("CFENDAMOUNT");
									  BigDecimal pro =  (BigDecimal)docStagers.getObject("CFPRO"); 
									  BigDecimal baseAchieve =  (BigDecimal)docStagers.getObject("CFBASEACHIEVE");  
									  String empNumber =  (String)docStagers.getObject("CFEMPNUMBER");  
									  
									  //处于这个阶段
									  if(achieve.compareTo(beginAmount) > 0 &&  achieve.compareTo(endAmount) <= 0 ){
										  //赋予比例 
										  if(typeStage.indexOf("ZZ") >= 0){ zzbi = pro;}
										  if(typeStage.indexOf("YX") >= 0){ yxjzbi = pro;}
										  if(typeStage.indexOf("GD") >= 0){ gdjzbi = pro;}
									      if(typeStage.indexOf("KNW")>= 0){ knwbi = pro;}
										  if(typeStage.indexOf("XF") >= 0){ xfbi = pro;}
										  if(typeStage.indexOf("EY") >= 0){ eybi = pro;}
										  if(typeStage.indexOf("YZ") >= 0){ yzbi = pro;}
										  if(typeStage.indexOf("MB") >= 0){ mbbi = pro;} 
										  if(typeStage.indexOf("ZJ") >= 0){ gdjzbi = pro;} 
										  break;
									  } 

								  }
							}
						}else{ 
							
							String[] brrType = incType.split(",");
							for( int j = 0 ; j < brrType.length ; j++  ){
								String typeNum = brrType[j];
								if(typeNum.equals("ZZ")){ achieve = achieve.add(zzBase) ; }
								else if(typeNum.equals("YX")) {achieve = achieve.add(yxjzBase);}
								else if(typeNum.equals("GD")) {achieve = achieve.add(gdjzBase) ;}
								else if(typeNum.equals("KNW")){achieve = achieve.add(knwBase);}
								else if(typeNum.equals("XF")) {achieve = achieve.add(xfBase) ;}
								else if(typeNum.equals("EY")) {achieve = achieve.add(eyBase) ;}
								else if(typeNum.equals("YZ")) {achieve = achieve.add(yzBase) ;}
								else if(typeNum.equals("MB")) {achieve = achieve.add(mb );}  
								else if(typeNum.equals("ZJ")) {achieve = achieve.add(gdjzBase);} 
							}
							
							//获得最高业绩的提成比例
							if("GetThisStagePro".equals(docCalType)){
								String docStageSql = " /*dialect*/ select CFBusinessDate , CFType , CFEmpNumber , CFEmpName , nvl(CFBrginAmount,0) as CFBrginAmount , nvl(CFEndAmount,0) as CFEndAmount ,nvl(CFPro,0) as CFPro  , nvl(CFBaseAchieve,0) as CFBaseAchieve  "+
								"  from  CT_PAY_DocStage where  CFEmpNumber = '"+empNum+"' and CFCityID = '"+cityId+"' and CFBusinessDate = "+periodnum+"  and CFType='"+incType+"'  order by CFBrginAmount ";
								IRowSet docStagers = com.kingdee.eas.custom.util.DBUtil.executeQuery(ctx,docStageSql);
								if(docStagers!=null && docStagers.size() > 0){
									  while(docStagers.next()){	
										  String typeStage =  (String) docStagers.getObject("CFTYPE");
										  BigDecimal beginAmount =  (BigDecimal)docStagers.getObject("CFBRGINAMOUNT");
										  BigDecimal endAmount =  (BigDecimal)docStagers.getObject("CFENDAMOUNT");
										  BigDecimal pro =  (BigDecimal)docStagers.getObject("CFPRO"); 
										  BigDecimal baseAchieve =  (BigDecimal)docStagers.getObject("CFBASEACHIEVE");  
										  String empNumber =  (String)docStagers.getObject("CFEMPNUMBER");  
										  
										  if( baseAchieve.compareTo(BigDecimal.ZERO) > 0){
											  if(typeStage.indexOf("ZZ") >= 0){  zzBaseData =  zzBasePro.multiply(baseAchieve);  }
											  if(typeStage.indexOf("YX") >= 0){  yxBaseData =  yxBasePro.multiply(baseAchieve);  }
											  if(typeStage.indexOf("GD") >= 0){  gdBaseData =  gdBasePro.multiply(baseAchieve);  }
										      if(typeStage.indexOf("KNW")>= 0){  knwBaseData =  knwBasePro.multiply(baseAchieve);  }
											  if(typeStage.indexOf("XF") >= 0){  xfBaseData =  xfBasePro.multiply(baseAchieve); }
											  if(typeStage.indexOf("EY") >= 0){  eyBaseData =  eyBasePro.multiply(baseAchieve);  }
											  if(typeStage.indexOf("YZ") >= 0){  yzBaseData =  yzBasePro.multiply(baseAchieve); }
											  if(typeStage.indexOf("MB") >= 0){  mbBaseData =  mbBasePro.multiply(baseAchieve);  } 
											  if(typeStage.indexOf("ZJ") >= 0){  gdBaseData =  gdBasePro.multiply(baseAchieve);  } 
										  }
										  //处于这个阶段
										  if(achieve.compareTo(beginAmount) > 0 &&  achieve.compareTo(endAmount) <= 0 ){
											  //赋予比例 
											  if(typeStage.indexOf("ZZ") >= 0){ zzbi = pro;   }
											  if(typeStage.indexOf("YX") >= 0){ yxjzbi = pro;   }
											  if(typeStage.indexOf("GD") >= 0){ gdjzbi = pro;   }
										      if(typeStage.indexOf("KNW")>= 0){ knwbi = pro;   }
											  if(typeStage.indexOf("XF") >= 0){ xfbi = pro;  }
											  if(typeStage.indexOf("EY") >= 0){ eybi = pro;    }
											  if(typeStage.indexOf("YZ") >= 0){ yzbi = pro;  }
											  if(typeStage.indexOf("MB") >= 0){ mbbi = pro;   } 
											  if(typeStage.indexOf("ZJ") >= 0){ gdjzbi = pro;  } 
											  break; 
										  }

									  }
								}
							}else{//分阶段进行计算
								//zz   xf  ey   
								BigDecimal thisAllAchieve = achieve;
								
								BigDecimal zzthisMoney = BigDecimal.ZERO;
								BigDecimal gdjzthisMoney = BigDecimal.ZERO;
								BigDecimal yxjzthisMoney = BigDecimal.ZERO;
								BigDecimal yzthisMoney = BigDecimal.ZERO;
								BigDecimal knwthisMoney = BigDecimal.ZERO;
								BigDecimal mbthisMoney = BigDecimal.ZERO;
								BigDecimal xfthisMoney = BigDecimal.ZERO;
								BigDecimal eythisMoney = BigDecimal.ZERO;
								
								 
								String docStageSql = " /*dialect*/ select CFBusinessDate , CFType , CFEmpNumber , CFEmpName , nvl(CFBrginAmount,0) as CFBrginAmount , nvl(CFEndAmount,0) as CFEndAmount ,nvl(CFPro,0) as CFPro  , nvl(CFBaseAchieve,0) as CFBaseAchieve  "+
								"  from  CT_PAY_DocStage where  CFEmpNumber = '"+empNum+"' and CFCityID = '"+cityId+"' and CFBusinessDate = "+periodnum+"  and CFType='"+incType+"'  order by CFBrginAmount ";
								IRowSet docStagers = com.kingdee.eas.custom.util.DBUtil.executeQuery(ctx,docStageSql);
								if(docStagers!=null && docStagers.size() > 0){
									  while(docStagers.next()){	
										  String typeStage =  (String) docStagers.getObject("CFTYPE");
										  BigDecimal beginAmount =  (BigDecimal)docStagers.getObject("CFBRGINAMOUNT");
										  BigDecimal endAmount =  (BigDecimal)docStagers.getObject("CFENDAMOUNT");
										  BigDecimal pro =  (BigDecimal)docStagers.getObject("CFPRO"); 
										  BigDecimal baseAchieve =  (BigDecimal)docStagers.getObject("CFBASEACHIEVE");  
										  String empNumber =  (String)docStagers.getObject("CFEMPNUMBER");  
										   
										  BigDecimal baseAchieveThis = BigDecimal.ZERO;  
										  if(baseAchieve.compareTo(BigDecimal.ZERO) > 0 ){
											  if(typeStage.equals("ZZ") ){  zzBaseData =  zzBasePro.multiply(baseAchieve);  baseAchieveThis = achieve.subtract(zzBaseData);
											  }else if(typeStage.equals("YX") ){  yxBaseData =  yxBasePro.multiply(baseAchieve);   baseAchieveThis = achieve.subtract(yxBaseData);
											  }else if(typeStage.equals("GD") || typeStage.equals("ZJ") ){ gdBaseData =  gdBasePro.multiply(baseAchieve);  baseAchieveThis = achieve.subtract(gdBaseData);
											  }else if(typeStage.equals("KNW")){ knwBaseData =  knwBasePro.multiply(baseAchieve);  baseAchieveThis = achieve.subtract(knwBaseData);
										      }else if(typeStage.equals("XF") ){ xfBaseData =  xfBasePro.multiply(baseAchieve);   baseAchieveThis = achieve.subtract(xfBaseData);
											  }else if(typeStage.equals("EY") ){ eyBaseData =  eyBasePro.multiply(baseAchieve);  baseAchieveThis = achieve.subtract(eyBaseData);
											  }else if(typeStage.equals("YZ") ){ yzBaseData =  yzBasePro.multiply(baseAchieve);   baseAchieveThis = achieve.subtract(yzBaseData);
											  }else if(typeStage.equals("MB") ){ mbBaseData =  mbBasePro.multiply(baseAchieve);   baseAchieveThis = achieve.subtract(mbBaseData);
											  }
										  }else{
											  baseAchieveThis = thisAllAchieve;
										  }
										  
										  if(baseAchieveThis.compareTo(beginAmount) < 1 ){
											  //break;
										  }else if(baseAchieveThis.compareTo(endAmount) < 1 ){
											  if(typeStage.equals("ZZ") ){  zzthisMoney = thisAllAchieve.subtract(zzBaseData).multiply(pro).add(zzthisMoney);  } 
											  else if(typeStage.equals("YX") ){  yxjzthisMoney = thisAllAchieve.subtract(yxBaseData).multiply(pro).add(yxjzthisMoney);  }
											  else if(typeStage.equals("GD") || typeStage.equals("ZJ") ){   gdjzthisMoney = thisAllAchieve.subtract(gdBaseData).multiply(pro).add(gdjzthisMoney); }
											  else if(typeStage.equals("KNW") ){  knwthisMoney = thisAllAchieve.subtract(knwBaseData).multiply(pro).add(knwthisMoney);  }
											  else if(typeStage.equals("XF") ){  xfthisMoney = thisAllAchieve.subtract(xfBaseData).multiply(pro).add(xfthisMoney); }
											  else if(typeStage.equals("EY") ){  eythisMoney = thisAllAchieve.subtract(eyBaseData).multiply(pro).add(eythisMoney); }
											  else if(typeStage.equals("YZ") ){  yzthisMoney = thisAllAchieve.subtract(yzBaseData).multiply(pro).add(yzthisMoney); }
											  else if(typeStage.equals("MB") ){  mbthisMoney = thisAllAchieve.subtract(mbBaseData).multiply(pro).add(mbthisMoney); }  
											  break;  
										  }else if(baseAchieveThis.compareTo(endAmount) == 1){
											  if(typeStage.equals("ZZ") ){  zzthisMoney = endAmount.subtract(beginAmount).multiply(pro).add(zzthisMoney); thisAllAchieve = achieve.subtract(endAmount);  } 
											  else if(typeStage.equals("YX") ){  yxjzthisMoney = endAmount.subtract(beginAmount).multiply(pro).add(yxjzthisMoney);  thisAllAchieve = achieve.subtract(endAmount); }
											  else if(typeStage.equals("GD") || typeStage.equals("ZJ") ){   gdjzthisMoney = endAmount.subtract(beginAmount).multiply(pro).add(gdjzthisMoney);  thisAllAchieve = achieve.subtract(endAmount);}
											  else if(typeStage.equals("KNW") ){ knwthisMoney = endAmount.subtract(beginAmount).multiply(pro).add(knwthisMoney); thisAllAchieve = achieve.subtract(endAmount); }
											  else if(typeStage.equals("XF") ){  xfthisMoney = endAmount.subtract(beginAmount).multiply(pro).add(xfthisMoney);thisAllAchieve = achieve.subtract(endAmount);}
											  else if(typeStage.equals("EY") ){  eythisMoney = endAmount.subtract(beginAmount).multiply(pro).add(eythisMoney);thisAllAchieve = achieve.subtract(endAmount);}
											  else if(typeStage.equals("YZ") ){  yzthisMoney = endAmount.subtract(beginAmount).multiply(pro).add(yzthisMoney);thisAllAchieve = achieve.subtract(endAmount);}
											  else if(typeStage.equals("MB") ){  mbthisMoney = endAmount.subtract(beginAmount).multiply(pro).add(mbthisMoney);thisAllAchieve = achieve.subtract(endAmount);
											  }   
										  } 
									 }
									 if(zzthisMoney.compareTo(BigDecimal.ZERO) > 0){  bingzhongMap.put("zz", zzthisMoney); }
									 if(gdjzthisMoney.compareTo(BigDecimal.ZERO) > 0){  bingzhongMap.put("gd", gdjzthisMoney); }
									 if(yxjzthisMoney.compareTo(BigDecimal.ZERO) > 0){ bingzhongMap.put("yx", yxjzthisMoney); }
									 if(knwthisMoney.compareTo(BigDecimal.ZERO) > 0){ bingzhongMap.put("knw", knwthisMoney); }
									 if(mbthisMoney.compareTo(BigDecimal.ZERO) > 0){  bingzhongMap.put("mb", mbthisMoney);  }
									 if(xfthisMoney.compareTo(BigDecimal.ZERO) > 0){ bingzhongMap.put("xf", xfthisMoney); }
									 if(eythisMoney.compareTo(BigDecimal.ZERO) > 0){ bingzhongMap.put("ey", eythisMoney); }
									 if(yzthisMoney.compareTo(BigDecimal.ZERO) > 0){ bingzhongMap.put("yz", yzthisMoney); }
								}
							}
						} 
						
					}
				}
				
				
				insertSql +=  ", CFZZbase , CFGDbase , cfyxbase, CFyzbase , cfknwbase , cfmbbase , cfxfbase, cfeybase ,cfallbase ";
				insertValueSql +=" ,"+zzBaseData+" ,"+gdBaseData+ ","+yxBaseData+","+yzBaseData+ ","+knwBaseData+","+0+ ","+xfBaseData+","+eyBaseData+" ,"+sumAchieve+" ";
				//","+docBase.multiply(xfBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP))+","+docBase.multiply(eyBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP))+" ,"+allBase+" ";
				
				insertSql +=  ", CFZZpro , CFGDpro , cfyxpro, CFyzpro , cfknwpro , cfmbpro , cfxfpro, cfeypro  ";
				insertValueSql +=" ,"+zzBasePro+" ,"+gdBasePro+ ","+yxBasePro+","+yzBasePro+ ","+knwBasePro+","+0+ ","+xfBasePro+","+ eyBasePro+" ";
				
				
				
				imandxtinsertsql +=  ", CFIMZZACHIEVE , CFIMGDJZACHIEVE , cfIMyxjzachieve, CFIMyzAchieve , cfIMknwachieve , cfIMmbachieve , cfIMxfachieve, cfIMeyachieve ";
				imandxtinsertValueSql +=" ,"+imzz+" ,"+imgdjz+","+imyxjz +","+imyz+","+imknw+","+immb+","+imxf+"," + ""+imey+"  ";
				
				insertSql +=  ", CFZZACHIEVE , CFGDJZACHIEVE , cfyxjzachieve, CFZyAchieve , cfknwachieve , cfmbachieve , cfxfachieve, cfeyachieve ";
				insertValueSql +=" ,"+zz+" ,"+gdjz+","+yxjz+","+yz+","+knw+","+mb+","+xf+","+ey+"  ";
				
				 
				
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
					/*zzMoney = zzBase.subtract(docBase.multiply(zzBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP))).compareTo(BigDecimal.ZERO) > 0 ? zzBase.subtract(docBase.multiply(zzBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP))).multiply(zzbi):BigDecimal.ZERO;
					gdjzMoney = gdjzBase.subtract(docBase.multiply(gdjzBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP))).compareTo(BigDecimal.ZERO) > 0 ? gdjzBase.subtract(docBase.multiply(gdjzBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP))).multiply(gdjzbi):BigDecimal.ZERO;
					yxjzMoney = yxjzBase.subtract(docBase.multiply(yxjzBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP))).compareTo(BigDecimal.ZERO) > 0 ? yxjzBase.subtract(docBase.multiply(yxjzBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP))).multiply(yxjzbi):BigDecimal.ZERO;
					yzMoney = yzBase.subtract(docBase.multiply(yzBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP))).compareTo(BigDecimal.ZERO) > 0 ? yzBase.subtract(docBase.multiply(yzBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP))).multiply(yzbi):BigDecimal.ZERO;
					knwMoney = knwBase.subtract(docBase.multiply(knwBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP))).compareTo(BigDecimal.ZERO) > 0 ? knwBase.subtract(docBase.multiply(knwBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP))).multiply(knwbi):BigDecimal.ZERO;
					//BigDecimal mbMoney = mb.subtract(mbcb).subtract(docBase.multiply(mbBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP))).compareTo(BigDecimal.ZERO) > 0 ? mb.subtract(mbcb).subtract(docBase.multiply(mbBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP))).multiply(mbbi):BigDecimal.ZERO;
					
					xfMoney = xfBase.subtract(docBase.multiply(xfBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP))).compareTo(BigDecimal.ZERO) > 0 ? xfBase.subtract(docBase.multiply(xfBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP))).multiply(xfbi):BigDecimal.ZERO;
					eyMoney = eyBase.subtract(docBase.multiply(eyBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP))).compareTo(BigDecimal.ZERO) > 0 ? eyBase.subtract(docBase.multiply(eyBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP))).multiply(eybi):BigDecimal.ZERO;
					*/
					
					if(bingzhongMap.get("zz") == null){
						zzMoney = zzBase.subtract(zzBaseData).compareTo(BigDecimal.ZERO) > 0 ? zzBase.subtract(zzBaseData).multiply(zzbi):BigDecimal.ZERO;
					}else{
						zzMoney = bingzhongMap.get("zz");
					}
					if(bingzhongMap.get("gd") == null){
						gdjzMoney = gdjzBase.subtract(gdBaseData).compareTo(BigDecimal.ZERO) > 0 ? gdjzBase.subtract(gdBaseData).multiply(gdjzbi):BigDecimal.ZERO;
					}else{
						gdjzMoney = bingzhongMap.get("gd");
					}
					if(bingzhongMap.get("yx") == null){
						yxjzMoney = yxjzBase.subtract(yxBaseData).compareTo(BigDecimal.ZERO) > 0 ? yxjzBase.subtract(yxBaseData).multiply(yxjzbi):BigDecimal.ZERO;
					}else{
						yxjzMoney = bingzhongMap.get("yx");
					}
					if(bingzhongMap.get("yz") == null){
						yzMoney = yzBase.subtract(yzBaseData).compareTo(BigDecimal.ZERO) > 0 ? yzBase.subtract(yzBaseData).multiply(yzbi):BigDecimal.ZERO;
					}else{
						yzMoney = bingzhongMap.get("yz");
					}
					if(bingzhongMap.get("knw") == null){
						knwMoney = knwBase.subtract(knwBaseData).compareTo(BigDecimal.ZERO) > 0 ? knwBase.subtract(knwBaseData).multiply(knwbi):BigDecimal.ZERO;
					}else{
						knwMoney = bingzhongMap.get("knw");
					}
					if(bingzhongMap.get("xf") == null){
						xfMoney = xfBase.subtract(xfBaseData).compareTo(BigDecimal.ZERO) > 0 ? xfBase.subtract(xfBaseData).multiply(xfbi):BigDecimal.ZERO;
					}else{
						xfMoney = bingzhongMap.get("xf");
					}
					if(bingzhongMap.get("ey") == null){
						eyMoney = eyBase.subtract(eyBaseData).compareTo(BigDecimal.ZERO) > 0 ? eyBase.subtract(eyBaseData).multiply(eybi):BigDecimal.ZERO;
					}else{
						eyMoney = bingzhongMap.get("ey");
					} 
					//BigDecimal mbMoney = mb.subtract(mbcb).subtract(docBase.multiply(mbBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP))).compareTo(BigDecimal.ZERO) > 0 ? mb.subtract(mbcb).subtract(docBase.multiply(mbBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP))).multiply(mbbi):BigDecimal.ZERO;
					
				}

 
				clinicCostSumInfo.setAllzzCost(clinicCostSumInfo.getUpzzCost().add(clinicCostSumInfo.getZzCost()).add(clinicCostSumInfo.getImzzCost()));
				clinicCostSumInfo.setAllgdjzCost(clinicCostSumInfo.getUpgdjzCost().add(clinicCostSumInfo.getGdjzCost()).add(clinicCostSumInfo.getImgdjzCost())); 
				clinicCostSumInfo.setAllyxjzCost(clinicCostSumInfo.getUpyxjzCost().add(clinicCostSumInfo.getYxjzCost()).add(clinicCostSumInfo.getImyxjzCost()));
				clinicCostSumInfo.setAllyzCost(clinicCostSumInfo.getUpyzCost().add(clinicCostSumInfo.getYzCost()).add(clinicCostSumInfo.getImyzCost()));
				clinicCostSumInfo.setAllknwCost(clinicCostSumInfo.getUpknwCost().add(clinicCostSumInfo.getKnwCost()).add(clinicCostSumInfo.getImknwCost()));
				clinicCostSumInfo.setAllmbCost(clinicCostSumInfo.getUpmbCost().add(clinicCostSumInfo.getMbCost()).add(clinicCostSumInfo.getImmbCost()));
				clinicCostSumInfo.setAllxfCost(clinicCostSumInfo.getUpxfCost().add(clinicCostSumInfo.getXfCost()).add(clinicCostSumInfo.getImxfCost()));
				clinicCostSumInfo.setAlleyCost(clinicCostSumInfo.getUpeyCost().add(clinicCostSumInfo.getEyCost()).add(clinicCostSumInfo.getImeyCost()));
				
				insertSql +=  ", cfzzcost , cfgdjzcost , cfyxjzcost , cfyzcost , cfknwcost , cfmbcost , cfxfcost , cfeycost  ";
				insertValueSql += " ,"+clinicCostSumInfo.getAllzzCost()+" ,"+clinicCostSumInfo.getAllgdjzCost()
				+" ,"+clinicCostSumInfo.getAllyxjzCost()+" ,"+clinicCostSumInfo.getAllyzCost() 
				+" ,"+clinicCostSumInfo.getAllknwCost()+" ,"+clinicCostSumInfo.getAllmbCost()
				+" ,"+clinicCostSumInfo.getAllxfCost()+" ,"+clinicCostSumInfo.getAlleyCost();
				
				 
				
				//美白也算入医生奖金
				if(bingzhongMap.get("mb") == null){ mbMoney = mb.subtract(mbcb).compareTo(BigDecimal.ZERO) > 0 ? mb.subtract(mbcb).multiply(mbbi):mb.subtract(mbcb).multiply(mbbi);  }
				else{  eyMoney = bingzhongMap.get("mb"); }
				
				//money = zzMoney.add(gdjzMoney).add(yxjzMoney).add(yzMoney).add(knwMoney).add(mbMoney).add(xfMoney).add(eyMoney).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
				money = zzMoney.add(gdjzMoney).add(yxjzMoney).add(yzMoney).add(knwMoney).add(xfMoney).add(eyMoney).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
				
				/*
				insertSql +=  ", CFZZbase , CFGDbase , cfyxbase, CFyzbase , cfknwbase , cfmbbase , cfxfbase, cfeybase ,cfallbase ";
				insertValueSql +=" ,"+docBase.multiply(zzBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP))+" ,"+docBase.multiply(gdjzBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP))+
				","+docBase.multiply(yxjzBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP))+","+docBase.multiply(yzBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP))+
				","+docBase.multiply(knwBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP))+","+0+
				","+docBase.multiply(xfBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP))+","+docBase.multiply(eyBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP))+" ,"+sumAchieve+" ";
				//","+docBase.multiply(xfBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP))+","+docBase.multiply(eyBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP))+" ,"+allBase+" ";
				
				insertSql +=  ", CFZZpro , CFGDpro , cfyxpro, CFyzpro , cfknwpro , cfmbpro , cfxfpro, cfeypro  ";
				insertValueSql +=" ,"+zzBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP)+" ,"+gdjzBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP)+
				","+yxjzBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP)+","+yzBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP)+
				","+knwBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP)+","+0+
				","+xfBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP)+","+ eyBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP)+" ";
				*/
				
				
				
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
					
					String dateSql = "";
					if(type.equals("ZC")){
						dateSql = "  to_char(fbizdate, 'yyyymm') = '"+periodnum+"' and  ";
					}else if(type.equals("CBQR")){
						dateSql = "  CFBUSINESSDATE = '"+periodnum+"' and  (cfisneedout = 0 or ( cfisneedout=1 and cfisout = 1))  and  ";
					}
					
					
					BigDecimal bymoney = BigDecimal.ZERO;
					String haveZidaisql = " /*dialect*/ select count(1) as thisnum from  CT_PAY_AchieveDetailTem where    "+dateSql+"  CFSecSource = '自带'  and  CFRecDotNumber ='"+empNum+"' and CFCityNumber='"+cityNumber+"'  ";
					
					IRowSet haveZidairs = com.kingdee.eas.custom.util.DBUtil.executeQuery(ctx,haveZidaisql.toString());
					if(haveZidairs!=null && haveZidairs.size() > 0){
						 while(haveZidairs.next()){	
							 int num= haveZidairs.getInt("THISNUM");
							 if(num > 0){
								 bymoney = docZiDai(ctx ,map,empNum,  cityNumber, periodnum,  clinicNumber ,tempMap,cityId,calType,type);
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
					  		
					  		//导入种植
							imzz = yjImprs.getBigDecimal("ZZ");
							//导入固定矫正
							imgdjz =yjImprs.getBigDecimal("GDJZ");
							//导入隐形矫正
							imyxjz = yjImprs.getBigDecimal("YXJZ");
							//导入牙周
							imyz = yjImprs.getBigDecimal("YZ");
							//导入口内外
							imknw = yjImprs.getBigDecimal("KNW");
							//导入美白
							immb = yjImprs.getBigDecimal("MB");
							//导入修复
							imxf = yjImprs.getBigDecimal("XF");
							//导入儿牙
							imey = yjImprs.getBigDecimal("EY");
							 
						}
					}
				  	
				  	//imandxtinsertsql +=  ", CFIMZZACHIEVE , CFIMGDJZACHIEVE , cfIMyxjzachieve, CFIMyzAchieve , cfIMknwachieve , cfIMmbachieve , cfIMxfachieve, cfIMeyachieve ";
					//imandxtinsertValueSql +=" ,"+zz+" ,"+gdjz+","+yxjz+","+yz+","+knw+","+mb+","+xf+","+ey+"  ";
					
					//再计算非自带患者的
					StringBuffer sqlFZD = new StringBuffer(); 
					sqlFZD = getFeiZiDaiSql( ctx,empNum,  cityNumber, periodnum, empName,zj,cityId,type);
					System.out.println(sqlFZD);
					IRowSet fzdrs = com.kingdee.eas.custom.util.DBUtil.executeQuery(ctx,sqlFZD.toString());
					if(fzdrs!=null && fzdrs.size() > 0){
						  while(fzdrs.next()){	 
							  if("zz".equals(fzdrs.getString("TYPE"))){//种植
								  zz =zz.add(new BigDecimal(fzdrs.getString("SUMM")));  
								  
								  imandxtinsertsql +=  ", CFXTZZACHIEVE  ";
								  imandxtinsertValueSql +=" ,"+new BigDecimal(fzdrs.getString("SUMM"))+" ";
									
							  }else if("gdjz".equals(fzdrs.getString("TYPE"))){//固定矫正 ？
								  gdjz=gdjz.add(new BigDecimal(fzdrs.getString("SUMM")));  
								  
								  imandxtinsertsql +=  "  , CFXTGDJZACHIEVE  ";
									imandxtinsertValueSql +="   ,"+new BigDecimal(fzdrs.getString("SUMM"))+" ";
							  }else if("yxjz".equals(fzdrs.getString("TYPE"))){//隐形矫正
								  yxjz=yxjz.add(new BigDecimal(fzdrs.getString("SUMM")));  
								  
								  imandxtinsertsql +=  " , cfXTyxjzachieve ";
								  imandxtinsertValueSql +="  ,"+new BigDecimal(fzdrs.getString("SUMM"))+" ";
							  }else if("yz".equals(fzdrs.getString("TYPE"))){//牙周 ？
								  yz=yz.add(new BigDecimal(fzdrs.getString("SUMM")));  
								  
								  imandxtinsertsql +=  " , CFXTyzAchieve  ";
									imandxtinsertValueSql +=" ,"+new BigDecimal(fzdrs.getString("SUMM"))+"  ";
							  }else if("knw".equals(fzdrs.getString("TYPE"))){//口内外 ？
								  knw =knw.add(new BigDecimal(fzdrs.getString("SUMM"))); 
								  
								  imandxtinsertsql +=  "  , cfXTknwachieve   ";
								  imandxtinsertValueSql +="  ,"+new BigDecimal(fzdrs.getString("SUMM"))+"  ";
							  }else if("mb".equals(fzdrs.getString("TYPE"))){//美白
								  mb=mb.add(new BigDecimal(fzdrs.getString("SUMM")));  
								  
								  imandxtinsertsql +=  "  , cfXTmbachieve ";
								 imandxtinsertValueSql +="  ,"+new BigDecimal(fzdrs.getString("SUMM"))+"   ";
							  }else if("xf".equals(fzdrs.getString("TYPE"))){//修复
								  xf=xf.add(new BigDecimal(fzdrs.getString("SUMM")));  
								  
								  imandxtinsertsql +=  " , cfXTxfachieve ";
								  imandxtinsertValueSql +=" ,"+new BigDecimal(fzdrs.getString("SUMM"))+"  ";
							  }else if("ey".equals(fzdrs.getString("TYPE"))){//儿牙
								  ey=ey.add(new BigDecimal(fzdrs.getString("SUMM")));  
								  
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
								  //costAll = costAll.add(zzcb);
								   
								  clinicCostSumInfo.setImzzCost(zzcb);
							  }else if("gdjz".equals(imporytbrs.getString("TYPE"))){//固定矫正
								  gdjzcb=new BigDecimal(imporytbrs.getString("SUMM")); 
								  //costAll = costAll.add(gdjzcb);
								   
								  clinicCostSumInfo.setImgdjzCost(gdjzcb);
							  }else if("yxjz".equals(imporytbrs.getString("TYPE"))){//隐形矫正
								  yxjzcb=new BigDecimal(imporytbrs.getString("SUMM")); 
								  //costAll = costAll.add(yxjzcb);
								   
								  clinicCostSumInfo.setImyxjzCost(yxjzcb);
							  }else if("yz".equals(imporytbrs.getString("TYPE"))){//牙周
								  yzcb=new BigDecimal(imporytbrs.getString("SUMM")); 
								  //costAll = costAll.add(yzcb);
								   
								  clinicCostSumInfo.setImyzCost(yzcb);
							  }else if("knw".equals(imporytbrs.getString("TYPE"))){//口内外
								  knwcb =new BigDecimal(imporytbrs.getString("SUMM"));
								  //costAll = costAll.add(knwcb);
								   
								  clinicCostSumInfo.setImknwCost(knwcb);
							  }else if("mb".equals(imporytbrs.getString("TYPE"))){//美白
								  mbcb=new BigDecimal(imporytbrs.getString("SUMM")); 
								  //costAll = costAll.add(mbcb); 
								  
								  clinicCostSumInfo.setImmbCost(mbcb);
							  }else if("xf".equals(imporytbrs.getString("TYPE"))){//修复
								  xfcb=new BigDecimal(imporytbrs.getString("SUMM")); 
								  //costAll = costAll.add(xfcb);
								   
								  clinicCostSumInfo.setImxfCost(xfcb);
							  }else if("ey".equals(imporytbrs.getString("TYPE"))){//儿牙
								  eycb=new BigDecimal(imporytbrs.getString("SUMM")); 
								  //costAll = costAll.add(eycb);
								  
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
								  //costAll = costAll.add(new BigDecimal(hushiCBrs.getString("SUMM"))); 
								  clinicCostSumInfo.setUpzzCost(new BigDecimal(hushiCBrs.getString("SUMM")));
							  }else if("gdjz".equals(hushiCBrs.getString("TYPE"))){//固定矫正
								  gdjzcb = gdjzcb.add(new BigDecimal(hushiCBrs.getString("SUMM"))); 
								  //costAll = costAll.add(new BigDecimal(hushiCBrs.getString("SUMM")));
								    
								  clinicCostSumInfo.setUpgdjzCost(new BigDecimal(hushiCBrs.getString("SUMM")));
							  }else if("yxjz".equals(hushiCBrs.getString("TYPE"))){//隐形矫正
								  yxjzcb = yxjzcb.add(new BigDecimal(hushiCBrs.getString("SUMM"))); 
								  //costAll = costAll.add(new BigDecimal(hushiCBrs.getString("SUMM"))); 
								  
								  clinicCostSumInfo.setUpyxjzCost(new BigDecimal(hushiCBrs.getString("SUMM")));
							  }else if("yz".equals(hushiCBrs.getString("TYPE"))){//牙周
								  yzcb = yzcb.add(new BigDecimal(hushiCBrs.getString("SUMM"))); 
								  //costAll = costAll.add(new BigDecimal(hushiCBrs.getString("SUMM"))); 
								  
								  clinicCostSumInfo.setUpyzCost(new BigDecimal(hushiCBrs.getString("SUMM")));
							  }else if("knw".equals(hushiCBrs.getString("TYPE"))){//口内外
								  knwcb = knwcb.add(new BigDecimal(hushiCBrs.getString("SUMM")));
								  //costAll = costAll.add(new BigDecimal(hushiCBrs.getString("SUMM"))); 
								  
								  clinicCostSumInfo.setUpknwCost(new BigDecimal(hushiCBrs.getString("SUMM")));
							  }else if("mb".equals(hushiCBrs.getString("TYPE"))){//美白
								  mbcb = mbcb.add(new BigDecimal(hushiCBrs.getString("SUMM"))); 
								  //costAll = costAll.add(new BigDecimal(hushiCBrs.getString("SUMM")));  
								  
								  clinicCostSumInfo.setUpmbCost(new BigDecimal(hushiCBrs.getString("SUMM")));
							  }else if("xf".equals(hushiCBrs.getString("TYPE"))){//修复
								  xfcb = xfcb.add(new BigDecimal(hushiCBrs.getString("SUMM"))); 
								  //costAll = costAll.add(new BigDecimal(hushiCBrs.getString("SUMM"))); 
								  
								  clinicCostSumInfo.setUpxfCost(new BigDecimal(hushiCBrs.getString("SUMM")));
							  }else if("ey".equals(hushiCBrs.getString("TYPE"))){//儿牙
								  eycb = eycb.add(new BigDecimal(hushiCBrs.getString("SUMM"))); 
								  //costAll = costAll.add(new BigDecimal(hushiCBrs.getString("SUMM")));  
								  
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

								  clinicCostSumInfo.setZzCost(new BigDecimal(cbrs.getString("SUMM")));
							  }else if("gdjz".equals(cbrs.getString("TYPE"))){//固定矫正
								  gdjzcb = gdjzcb.add(new BigDecimal(cbrs.getString("SUMM"))); 
								  costAll = costAll.add(new BigDecimal(cbrs.getString("SUMM"))); 
								  
								  clinicCostSumInfo.setGdjzCost(new BigDecimal(cbrs.getString("SUMM")));
							  }else if("yxjz".equals(cbrs.getString("TYPE"))){//隐形矫正
								  yxjzcb = yxjzcb.add(new BigDecimal(cbrs.getString("SUMM"))); 
								  costAll = costAll.add(new BigDecimal(cbrs.getString("SUMM"))); 
								  
								  clinicCostSumInfo.setYxjzCost(new BigDecimal(cbrs.getString("SUMM")));
							  }else if("yz".equals(cbrs.getString("TYPE"))){//牙周
								  yzcb = yzcb.add(new BigDecimal(cbrs.getString("SUMM"))); 
								  costAll = costAll.add(new BigDecimal(cbrs.getString("SUMM"))); 
								  
								  clinicCostSumInfo.setYzCost(new BigDecimal(cbrs.getString("SUMM")));
							  }else if("knw".equals(cbrs.getString("TYPE"))){//口内外
								  knwcb = knwcb.add(new BigDecimal(cbrs.getString("SUMM")));
								  costAll = costAll.add(new BigDecimal(cbrs.getString("SUMM"))); 
								  
								  clinicCostSumInfo.setKnwCost(new BigDecimal(cbrs.getString("SUMM")));
							  }else if("mb".equals(cbrs.getString("TYPE"))){//美白
								  mbcb = mbcb.add(new BigDecimal(cbrs.getString("SUMM"))); 
								  costAll = costAll.add(new BigDecimal(cbrs.getString("SUMM"))); 
								  
								  clinicCostSumInfo.setMbCost(new BigDecimal(cbrs.getString("SUMM")));
							  }else if("xf".equals(cbrs.getString("TYPE"))){//修复
								  xfcb = xfcb.add(new BigDecimal(cbrs.getString("SUMM"))); 
								  costAll = costAll.add(new BigDecimal(cbrs.getString("SUMM"))); 
								  
								  clinicCostSumInfo.setXfCost(new BigDecimal(cbrs.getString("SUMM")));
							  }else if("ey".equals(cbrs.getString("TYPE"))){//儿牙
								  eycb = eycb.add(new BigDecimal(cbrs.getString("SUMM"))); 
								  costAll = costAll.add(new BigDecimal(cbrs.getString("SUMM"))); 
								  
								  clinicCostSumInfo.setEyCost(new BigDecimal(cbrs.getString("SUMM")));
							  }   
						  }
						  
					}  
					
					
					
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
						
						if(DoctorCostsFactory.getLocalInstance(ctx).exists("where BusinessDate='"+nextPeriod+"' and city = '"+cityId+"' and EmpNumber='"+empNum+"' and CostType='yk'  and (Description is null or Description!='分摊扣除业绩') ")){
							DoctorCostsFactory.getLocalInstance(ctx).delete("where BusinessDate='"+nextPeriod+"' and city = '"+cityId+"' and EmpNumber='"+empNum+"' and CostType='yk' and (Description is null or Description!='分摊扣除业绩') "); 
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
						doctorCostsInfo.setIszidai(true);
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
						 
						
			
//						if(DocAchieveUpdateFactory.getLocalInstance(ctx).exists("where BusinessDate='"+periodnum+"' and city = '"+cityId+"' and docNumber='"+empNum+"' and Name='分摊扣除业绩' ")){
//							DocAchieveUpdateFactory.getLocalInstance(ctx).delete("where BusinessDate='"+periodnum+"' and city = '"+cityId+"' and docNumber='"+empNum+"'  and Name='分摊扣除业绩' "); 
//						}
						DocAchieveUpdateInfo docAchieveUpdateThis =new DocAchieveUpdateInfo();
						docAchieveUpdateThis.setBusinessDate(periodnum); 
						ctrlUnitInfo.setId(BOSUuid.read(cityId));
						docAchieveUpdateThis.setCity(ctrlUnitInfo);
						docAchieveUpdateThis.setCityNumber(cityNumber);
						docAchieveUpdateThis.setDocNumber(empNum);
						docAchieveUpdateThis.setDocName(tempMap.get("empName").toString()); 
						docAchieveUpdateThis.setName("分摊扣除业绩");  
						boolean flag = false;
						if(null != allMap.get("negzz")){
							//clinicCostSumInfo.setImzzCost(clinicCostSumInfo.getImzzCost().add(allMap.get("negzz")));
							docAchieveUpdateThis.setZzAchieve(allMap.get("negzz").negate());
							imzz = imzz.add(allMap.get("negzz").negate());
							
							zz = zz.add(allMap.get("negzz").negate());
							
							flag = true;
						}
						if(null != allMap.get("neggdjz")){
							//clinicCostSumInfo.setImgdjzCost(clinicCostSumInfo.getImgdjzCost().add(allMap.get("neggdjz")));
							docAchieveUpdateThis.setGdjzAchieve(allMap.get("neggdjz").negate());
							imgdjz = imgdjz.add(allMap.get("neggdjz").negate());
							
							gdjz = gdjz.add(allMap.get("neggdjz").negate());
							flag = true;
						}
						if(null != allMap.get("negyxjz")){
							//clinicCostSumInfo.setImyxjzCost(clinicCostSumInfo.getImyxjzCost().add(allMap.get("negyxjz")));
							docAchieveUpdateThis.setYxjzAchieve(allMap.get("negyxjz").negate());
							imyxjz = imyxjz.add(allMap.get("negyxjz").negate());
							
							yxjz = yxjz.add(allMap.get("negyxjz").negate());
							flag = true;
						}
						if(null != allMap.get("negyz")){
							//clinicCostSumInfo.setImyzCost(clinicCostSumInfo.getImyzCost().add(allMap.get("negyz")));
							docAchieveUpdateThis.setYzAchieve(allMap.get("negyz").negate());
							imyz = imyz.add(allMap.get("neggdjz").negate());
							
							yz = yz.add(allMap.get("neggdjz").negate());
							flag = true;
						}
						if(null != allMap.get("negknw")){
							//clinicCostSumInfo.setImknwCost(clinicCostSumInfo.getImknwCost().add(allMap.get("negknw")));
							docAchieveUpdateThis.setKnwAchieve(allMap.get("negknw"));
							imknw = imknw.add(allMap.get("negknw").negate());
							
							knw = knw.add(allMap.get("negknw").negate());
							flag = true;
						}
						if(null != allMap.get("negxf")){
							//clinicCostSumInfo.setImxfCost(clinicCostSumInfo.getImxfCost().add(allMap.get("negxf")));
							docAchieveUpdateThis.setXfAchieve(allMap.get("negxf").negate());
							imxf = imxf.add(allMap.get("negxf").negate());
							
							xf = xf.add(allMap.get("negxf").negate());
							flag = true;
						}
						if(null != allMap.get("negey")){
							//clinicCostSumInfo.setImeyCost(clinicCostSumInfo.getImeyCost().add(allMap.get("negey")));
							docAchieveUpdateThis.setEyAchieve(allMap.get("negey").negate());
							imey = imey.add(allMap.get("negey").negate());
							
							ey = ey.add(allMap.get("negey").negate()); 
							flag = true;
						}
						if(flag){
							DocAchieveUpdateFactory.getLocalInstance(ctx).save(docAchieveUpdateThis);
						}
					}else{//不进行延扣
						 
						 
						if(zzbi.compareTo(gdjzbi)==0&&zzbi.compareTo(yxjzbi)==0&&zzbi.compareTo(yzbi)==0&&zzbi.compareTo(knwbi)==0&&zzbi.compareTo(xfbi)==0&&zzbi.compareTo(eybi)==0){
							zzBase = zz.subtract(zzcb);
							gdjzBase = gdjz.subtract(gdjzcb);
							yxjzBase = yxjz.subtract(yxjzcb);
							yzBase = yz.subtract(yzcb);
							knwBase = knw.subtract(knwcb);
							//BigDecimal mbBase = mb.subtract(mbcb).compareTo(BigDecimal.ZERO)<0?BigDecimal.ZERO:mb.subtract(mbcb);
							xfBase = xf.subtract(xfcb);
							eyBase = ey.subtract(eycb);
						}else{
							zzBase = zz.subtract(zzcb).compareTo(BigDecimal.ZERO)<0?BigDecimal.ZERO:zz.subtract(zzcb);
							gdjzBase = gdjz.subtract(gdjzcb).compareTo(BigDecimal.ZERO)<0?BigDecimal.ZERO:gdjz.subtract(gdjzcb);
							yxjzBase = yxjz.subtract(yxjzcb).compareTo(BigDecimal.ZERO)<0?BigDecimal.ZERO:yxjz.subtract(yxjzcb);
							yzBase = yz.subtract(yzcb).compareTo(BigDecimal.ZERO)<0?BigDecimal.ZERO:yz.subtract(yzcb);
							knwBase = knw.subtract(knwcb).compareTo(BigDecimal.ZERO)<0?BigDecimal.ZERO:knw.subtract(knwcb);
							//BigDecimal mbBase = mb.subtract(mbcb).compareTo(BigDecimal.ZERO)<0?BigDecimal.ZERO:mb.subtract(mbcb);
							xfBase = xf.subtract(xfcb).compareTo(BigDecimal.ZERO)<0?BigDecimal.ZERO:xf.subtract(xfcb);
							eyBase = ey.subtract(eycb).compareTo(BigDecimal.ZERO)<0?BigDecimal.ZERO:ey.subtract(eycb);
						}
					
						
					} 
					

					imandxtinsertsql +=  ", CFIMZZACHIEVE , CFIMGDJZACHIEVE , cfIMyxjzachieve, CFIMyzAchieve , cfIMknwachieve , cfIMmbachieve , cfIMxfachieve, cfIMeyachieve ";
					imandxtinsertValueSql +=" ,"+imzz+" ,"+imgdjz+","+imyxjz +","+imyz+","+imknw+","+immb+","+imxf+"," + ""+imey+"  ";
					
					insertSql +=  ", CFZZACHIEVE , CFGDJZACHIEVE , cfyxjzachieve, CFZyAchieve , cfknwachieve , cfmbachieve , cfxfachieve, cfeyachieve ";
					insertValueSql +=" ,"+zz+" ,"+gdjz+","+yxjz+","+yz+","+knw+","+mb+","+xf+","+ey+"  ";
					
					
					 
					clinicCostSumInfo.setAllzzCost(clinicCostSumInfo.getUpzzCost().add(clinicCostSumInfo.getZzCost()).add(clinicCostSumInfo.getImzzCost()));
					clinicCostSumInfo.setAllgdjzCost(clinicCostSumInfo.getUpgdjzCost().add(clinicCostSumInfo.getGdjzCost()).add(clinicCostSumInfo.getImgdjzCost()));
					clinicCostSumInfo.setAllyxjzCost(clinicCostSumInfo.getUpyxjzCost().add(clinicCostSumInfo.getYxjzCost()).add(clinicCostSumInfo.getImyxjzCost()));
					clinicCostSumInfo.setAllyzCost(clinicCostSumInfo.getUpyzCost().add(clinicCostSumInfo.getYzCost()).add(clinicCostSumInfo.getImyzCost()));
					clinicCostSumInfo.setAllknwCost(clinicCostSumInfo.getUpknwCost().add(clinicCostSumInfo.getKnwCost()).add(clinicCostSumInfo.getImknwCost()));
					clinicCostSumInfo.setAllmbCost(clinicCostSumInfo.getUpmbCost().add(clinicCostSumInfo.getMbCost()).add(clinicCostSumInfo.getImmbCost()));
					clinicCostSumInfo.setAllxfCost(clinicCostSumInfo.getUpxfCost().add(clinicCostSumInfo.getXfCost()).add(clinicCostSumInfo.getImxfCost()));
					clinicCostSumInfo.setAlleyCost(clinicCostSumInfo.getUpeyCost().add(clinicCostSumInfo.getEyCost()).add(clinicCostSumInfo.getImeyCost()));
					
					insertSql +=  ", cfzzcost , cfgdjzcost , cfyxjzcost , cfyzcost , cfknwcost , cfmbcost , cfxfcost , cfeycost  ";
					insertValueSql += " ,"+clinicCostSumInfo.getAllzzCost()+" ,"+clinicCostSumInfo.getAllgdjzCost()
					+" ,"+clinicCostSumInfo.getAllyxjzCost()+" ,"+clinicCostSumInfo.getAllyzCost() 
					+" ,"+clinicCostSumInfo.getAllknwCost()+" ,"+clinicCostSumInfo.getAllmbCost()
					+" ,"+clinicCostSumInfo.getAllxfCost()+" ,"+clinicCostSumInfo.getAlleyCost();
					 
					
				 
					BigDecimal allBase = zzBase.add(gdjzBase).add(yxjzBase).add(yzBase).add(knwBase).add(xfBase).add(eyBase);
					if(allBase.compareTo(BigDecimal.ZERO) <=0 ){
						allBase = new BigDecimal("1");
					}
					 
					
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
						if(zzbi.compareTo(gdjzbi)==0&&zzbi.compareTo(yxjzbi)==0&&zzbi.compareTo(yzbi)==0&&zzbi.compareTo(knwbi)==0&&zzbi.compareTo(xfbi)==0&&zzbi.compareTo(eybi)==0){
							zzMoney =   zzBase.multiply(zzbi);
							gdjzMoney =  gdjzBase.multiply(gdjzbi);
							yxjzMoney =  yxjzBase.multiply(yxjzbi);
							yzMoney =   yzBase.multiply(yzbi);
							knwMoney =  knwBase.multiply(knwbi);
							//BigDecimal mbMoney = mb.subtract(mbcb).subtract(docBase.multiply(mbBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP))).compareTo(BigDecimal.ZERO) > 0 ? mb.subtract(mbcb).subtract(docBase.multiply(mbBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP))).multiply(mbbi):BigDecimal.ZERO;
							
							xfMoney =   xfBase.multiply(xfbi);
							eyMoney =  eyBase.multiply(eybi);
							
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
						
					}
					mbMoney = mb.subtract(mbcb).compareTo(BigDecimal.ZERO) > 0 ? mb.subtract(mbcb).multiply(mbbi):mb.subtract(mbcb).multiply(mbbi);
					
					//BigDecimal noybyMoney = zzMoney.add(gdjzMoney).add(yxjzMoney).add(yzMoney).add(knwMoney).add(mbMoney).add(xfMoney).add(eyMoney).setScale(2,BigDecimal.ROUND_HALF_UP); 
					
					BigDecimal noybyMoney = zzMoney.add(gdjzMoney).add(yxjzMoney).add(yzMoney).add(knwMoney).add(xfMoney).add(eyMoney).setScale(2,BigDecimal.ROUND_HALF_UP);
					 
					BigDecimal sumAchieve =  zz.add(gdjz).add(yxjz).add(yz).add(knw).add(mb).add(xf).add(ey);
					insertSql += ",cfsumachieve, CFZZmoney, CFGDJZmoney, CFYXJZmoney, CFYZmoney, CFKNWmoney, CFMBmoney, CFXFmoney, CFEYmoney ";
					insertValueSql += " ,"+sumAchieve+", "+zzMoney+" ,"+(gdjzMoney)+","+(yxjzMoney)+" " +
						" ,"+(yzMoney)+" ,"+(knwMoney)+" ,"+(mbMoney)+" "+
						" ,"+xfMoney+" ,"+(eyMoney)+" ";
					
					insertSql +=  ", CFZZpro , CFGDpro , cfyxpro, CFyzpro , cfknwpro , cfmbpro , cfxfpro, cfeypro  ";
					insertValueSql +=" ,"+zzBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP)+" ,"+gdjzBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP)+
					","+yxjzBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP)+","+yzBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP)+
					","+knwBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP)+","+0+
					","+xfBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP)+","+ eyBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP)+" ";
					
					docMap.put("EXISTS", "NO");
					docMap.put("mbMoney", mbMoney+"");
					docMap.put("JIANGJIN", bymoney.add(noybyMoney)+"");
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
		.append(" FROM  CT_PAY_DocAchieveUpdate where cfcityid = '"+cityId+"' and ( cfiszidai = 0 or cfiszidai is null) and cfdocnumber  ='"+empNum+"'  and  cfbusinessdate = '"+periodnum+"' and  fname_l2 is null ");
		 

		return sqlYJ;
	}

	
	/**
	 * 统计医生的业绩
	 * @param empNum
	 * @param clinicNumber
	 * @param periodnum
	 * @param sqlYJ
	 * @return
	 * @throws Exception 
	 */

	public StringBuffer getYeJiSql(Context ctx,String empNum, String cityNumber,String periodnum,StringBuffer sqlYJ,String cityId,BigDecimal zjbl,String type) throws Exception{
		String dateSql = "";
		if(type.equals("ZC")){
			dateSql = "  to_char(fbizdate, 'yyyymm') = '"+periodnum+"' and  ";
		}else if(type.equals("CBQR")){
			dateSql = "  CFBUSINESSDATE = '"+periodnum+"' and  (cfisneedout = 0 or ( cfisneedout=1 and cfisout = 1))  and  ";
		}
		
		//种植   and CFClinicNumber='"+clinicNumber+"'
		sqlYJ.append("  /*dialect*/ select aa.summ,'zz' as type from ( ");
		sqlYJ.append(" select sum(a.allm) as summ from ( ");
		sqlYJ.append(" SELECT nvl((sum(CFDocAchieve)),0) as allm FROM  CT_PAY_AchieveDetailTem where    "+dateSql+"   CFRecDotNumber ='"+empNum+"'  and CFCityNumber='"+cityNumber+"' "+
				" and (EXISTS (SELECT  1 FROM  CT_SRQ_ItemCheck bill inner join  CT_SRQ_ItemCheckentry entry on   bill.fid = entry.fparentid  left JOIN  CT_SRQ_Paytypecategory  item on  item.fid = entry.cffirstitemid  where  bill.cftypenumber = 'ZZ' and bill.cfcityid = '"+cityId+"' and  CT_PAY_AchieveDetailTem.CFFirClassNumber = item.fnumber ) "+
				"or  EXISTS (SELECT  1 FROM  CT_SRQ_ItemCheck bill inner join  CT_SRQ_ItemCheckEntrysec entry on   bill.fid = entry.fparentid  left JOIN  CT_SRQ_Paytypeitem item on  item.fid = entry.cfseconditemid  where  bill.cftypenumber = 'ZZ' and bill.cfcityid = '"+cityId+"' and  CT_PAY_AchieveDetailTem.CFSecClassnumber = item.fnumber ) "+
				"or  EXISTS (SELECT  1 FROM  CT_SRQ_ItemCheck bill inner join  CT_SRQ_ItemCheckEntrythi entry on   bill.fid = entry.fparentid  left JOIN  CT_SRQ_PayItem  item on  item.fid = entry.cfitemid  where  bill.cftypenumber = 'ZZ' and bill.cfcityid = '"+cityId+"' and  CT_PAY_AchieveDetailTem.cffeeitemdetailNUMBER = item.fnumber ) )   ");
		sqlYJ.append(" ) a ) aa ");
		sqlYJ.append(" union ");
		//固定矫正
		sqlYJ.append(" select bb.summ,'gdjz' as type from (select sum(b.allm) as summ from (");
		sqlYJ.append(" SELECT nvl((sum(CFDocAchieve) *"+zjbl+"),0) as allm FROM  CT_PAY_AchieveDetailTem where    "+dateSql+"   CFIsRoutine='是' and   CFRecDotNumber ='"+empNum+"'  and CFCityNumber='"+cityNumber+"' "+
				"and   not exists ( SELECT 1 FROM  CT_SRQ_ClinicItem clinicItem left join  CT_SRQ_ClinicItemEntry  entry  on clinicItem.fid = entry.fparentid  left join CT_SRQ_PayItem payItem on payItem.fid = entry.cfitemid  where clinicItem.cfcityid = '"+cityId+"' and  clinicItem.cfproject = '口内外正畸' and   CT_PAY_AchieveDetailTem.CFFeeItemDetailNumber = payItem.fnumber) "+
				"and ( EXISTS (SELECT  1 FROM  CT_SRQ_ItemCheck bill inner join  CT_SRQ_ItemCheckentry entry on   bill.fid = entry.fparentid  left JOIN  CT_SRQ_Paytypecategory  item on  item.fid = entry.cffirstitemid  where  bill.cftypenumber = 'GD' and bill.cfcityid = '"+cityId+"' and  CT_PAY_AchieveDetailTem.CFFirClassNumber = item.fnumber ) "+
				"or  EXISTS (SELECT  1 FROM  CT_SRQ_ItemCheck bill inner join  CT_SRQ_ItemCheckEntrysec entry on   bill.fid = entry.fparentid  left JOIN  CT_SRQ_Paytypeitem item on  item.fid = entry.cfseconditemid  where  bill.cftypenumber = 'GD' and bill.cfcityid = '"+cityId+"' and  CT_PAY_AchieveDetailTem.CFSecClassnumber = item.fnumber ) "+
				"or  EXISTS (SELECT  1 FROM  CT_SRQ_ItemCheck bill inner join  CT_SRQ_ItemCheckEntrythi entry on   bill.fid = entry.fparentid  left JOIN  CT_SRQ_PayItem  item on  item.fid = entry.cfitemid  where  bill.cftypenumber = 'GD' and bill.cfcityid = '"+cityId+"' and  CT_PAY_AchieveDetailTem.cffeeitemdetailNUMBER = item.fnumber ) )  ");
		sqlYJ.append(" ) b) bb ");
		sqlYJ.append(" union ");
		//隐形矫正
		sqlYJ.append(" select cc.summ,'yxjz' as type from (select sum(c.allm) as summ from ( ");
		sqlYJ.append(" SELECT nvl((sum(CFDocAchieve) *"+zjbl+"),0) as allm FROM  CT_PAY_AchieveDetailTem where    "+dateSql+"   CFIsRoutine='否' and    CFRecDotNumber ='"+empNum+"' and CFCityNumber='"+cityNumber+"'   "+
				"and    not exists ( SELECT 1 FROM  CT_SRQ_ClinicItem clinicItem left join  CT_SRQ_ClinicItemEntry  entry  on clinicItem.fid = entry.fparentid  left join CT_SRQ_PayItem payItem on payItem.fid = entry.cfitemid  where clinicItem.cfcityid = '"+cityId+"' and  clinicItem.cfproject = '口内外正畸' and   CT_PAY_AchieveDetailTem.CFFeeItemDetailNumber = payItem.fnumber) "+
				"and ( EXISTS (SELECT  1 FROM  CT_SRQ_ItemCheck bill inner join  CT_SRQ_ItemCheckentry entry on   bill.fid = entry.fparentid  left JOIN  CT_SRQ_Paytypecategory  item on  item.fid = entry.cffirstitemid  where  bill.cftypenumber = 'YX' and bill.cfcityid = '"+cityId+"' and  CT_PAY_AchieveDetailTem.CFFirClassNumber = item.fnumber ) "+
				"or  EXISTS (SELECT  1 FROM  CT_SRQ_ItemCheck bill inner join  CT_SRQ_ItemCheckEntrysec entry on   bill.fid = entry.fparentid  left JOIN  CT_SRQ_Paytypeitem item on  item.fid = entry.cfseconditemid  where  bill.cftypenumber = 'YX' and bill.cfcityid = '"+cityId+"' and  CT_PAY_AchieveDetailTem.CFSecClassnumber = item.fnumber ) "+
				"or  EXISTS (SELECT  1 FROM  CT_SRQ_ItemCheck bill inner join  CT_SRQ_ItemCheckEntrythi entry on   bill.fid = entry.fparentid  left JOIN  CT_SRQ_PayItem  item on  item.fid = entry.cfitemid  where  bill.cftypenumber = 'YX' and bill.cfcityid = '"+cityId+"' and  CT_PAY_AchieveDetailTem.cffeeitemdetailNUMBER = item.fnumber ) ) ");
		sqlYJ.append(" ) c) cc ");
		sqlYJ.append(" union ");
		//牙周
		sqlYJ.append(" select dd.summ,'yz' as type from (select sum(d.allm) as summ from ( ");
		sqlYJ.append(" SELECT nvl((sum(CFDocAchieve)),0) as allm FROM  CT_PAY_AchieveDetailTem where    "+dateSql+"   CFRecDotNumber ='"+empNum+"'   and CFCityNumber='"+cityNumber+"' "+
				"and ( EXISTS (SELECT  1 FROM  CT_SRQ_ItemCheck bill inner join  CT_SRQ_ItemCheckentry entry on   bill.fid = entry.fparentid  left JOIN  CT_SRQ_Paytypecategory  item on  item.fid = entry.cffirstitemid  where  bill.cftypenumber = 'YZ' and bill.cfcityid = '"+cityId+"' and  CT_PAY_AchieveDetailTem.CFFirClassNumber = item.fnumber ) "+
				"or  EXISTS (SELECT  1 FROM  CT_SRQ_ItemCheck bill inner join  CT_SRQ_ItemCheckEntrysec entry on   bill.fid = entry.fparentid  left JOIN  CT_SRQ_Paytypeitem item on  item.fid = entry.cfseconditemid  where  bill.cftypenumber = 'YZ' and bill.cfcityid = '"+cityId+"' and  CT_PAY_AchieveDetailTem.CFSecClassnumber = item.fnumber ) "+
				"or  EXISTS (SELECT  1 FROM  CT_SRQ_ItemCheck bill inner join  CT_SRQ_ItemCheckEntrythi entry on   bill.fid = entry.fparentid  left JOIN  CT_SRQ_PayItem  item on  item.fid = entry.cfitemid  where  bill.cftypenumber = 'YZ' and bill.cfcityid = '"+cityId+"' and  CT_PAY_AchieveDetailTem.cffeeitemdetailNUMBER = item.fnumber ) ) ");
		sqlYJ.append(" ) d) dd ");
		sqlYJ.append(" union ");
		//口内外
		sqlYJ.append(" select ee.summ,'knw' as type from (select sum(e.allm) as summ from ( ");
		sqlYJ.append(" SELECT nvl((sum(CFDocAchieve)),0) as allm FROM  CT_PAY_AchieveDetailTem where    "+dateSql+"   CFRecDotNumber ='"+empNum+"'   and    CFCityNumber='"+cityNumber+"' "+
				"and ( exists ( SELECT 1 FROM  CT_SRQ_ClinicItem clinicItem left join  CT_SRQ_ClinicItemEntry  entry  on clinicItem.fid = entry.fparentid  left join CT_SRQ_PayItem payItem on payItem.fid = entry.cfitemid  where clinicItem.cfcityid = '"+cityId+"' and  clinicItem.cfproject = '口内外' and   CT_PAY_AchieveDetailTem.CFFeeItemDetailNumber = payItem.fnumber) "+
				"or ( EXISTS (SELECT  1 FROM  CT_SRQ_ItemCheck bill inner join  CT_SRQ_ItemCheckentry entry on   bill.fid = entry.fparentid  left JOIN  CT_SRQ_Paytypecategory  item on  item.fid = entry.cffirstitemid  where  bill.cftypenumber = 'KNW' and bill.cfcityid = '"+cityId+"' and  CT_PAY_AchieveDetailTem.CFFirClassNumber = item.fnumber ) "+
				"or  EXISTS (SELECT  1 FROM  CT_SRQ_ItemCheck bill inner join  CT_SRQ_ItemCheckEntrysec entry on   bill.fid = entry.fparentid  left JOIN  CT_SRQ_Paytypeitem item on  item.fid = entry.cfseconditemid  where  bill.cftypenumber = 'KNW' and bill.cfcityid = '"+cityId+"' and  CT_PAY_AchieveDetailTem.CFSecClassnumber = item.fnumber ) "+
				"or  EXISTS (SELECT  1 FROM  CT_SRQ_ItemCheck bill inner join  CT_SRQ_ItemCheckEntrythi entry on   bill.fid = entry.fparentid  left JOIN  CT_SRQ_PayItem  item on  item.fid = entry.cfitemid  where  bill.cftypenumber = 'KNW' and bill.cfcityid = '"+cityId+"' and  CT_PAY_AchieveDetailTem.cffeeitemdetailNUMBER = item.fnumber ) ) ) ");
		sqlYJ.append(" ) e) ee ");
		sqlYJ.append(" union ");
		// 美白
		sqlYJ.append(" select ff.summ,'mb' as type from (select sum(f.allm) as summ from ( ");
		sqlYJ.append(" SELECT nvl((sum(CFDocAchieve)),0) as allm FROM  CT_PAY_AchieveDetailTem where    "+dateSql+"   CFRecDotNumber ='"+empNum+"'  and CFCityNumber='"+cityNumber+"'   "+
				" and ( EXISTS (SELECT  1 FROM  CT_SRQ_ItemCheck bill inner join  CT_SRQ_ItemCheckentry entry on   bill.fid = entry.fparentid  left JOIN  CT_SRQ_Paytypecategory  item on  item.fid = entry.cffirstitemid  where  bill.cftypenumber = 'MB' and bill.cfcityid = '"+cityId+"' and  CT_PAY_AchieveDetailTem.CFFirClassNumber = item.fnumber ) "+
				"or  EXISTS (SELECT  1 FROM  CT_SRQ_ItemCheck bill inner join  CT_SRQ_ItemCheckEntrysec entry on   bill.fid = entry.fparentid  left JOIN  CT_SRQ_Paytypeitem item on  item.fid = entry.cfseconditemid  where  bill.cftypenumber = 'MB' and bill.cfcityid = '"+cityId+"' and  CT_PAY_AchieveDetailTem.CFSecClassnumber = item.fnumber ) "+
				"or  EXISTS (SELECT  1 FROM  CT_SRQ_ItemCheck bill inner join  CT_SRQ_ItemCheckEntrythi entry on   bill.fid = entry.fparentid  left JOIN  CT_SRQ_PayItem  item on  item.fid = entry.cfitemid  where  bill.cftypenumber = 'MB' and bill.cfcityid = '"+cityId+"' and  CT_PAY_AchieveDetailTem.cffeeitemdetailNUMBER = item.fnumber ) )   ");
		sqlYJ.append(" ) f) ff ");
		sqlYJ.append(" union ");
		//修复
		sqlYJ.append(" select gg.summ,'xf' as type from (select sum(g.allm) as summ from ( ");
		sqlYJ.append(" SELECT nvl((sum(CFDocAchieve)),0) as allm FROM  CT_PAY_AchieveDetailTem where    "+dateSql+"   CFRecDotNumber ='"+empNum+"' and CFCityNumber='"+cityNumber+"'  "+
				"and ( EXISTS (SELECT  1 FROM  CT_SRQ_ItemCheck bill inner join  CT_SRQ_ItemCheckentry entry on   bill.fid = entry.fparentid  left JOIN  CT_SRQ_Paytypecategory  item on  item.fid = entry.cffirstitemid  where  bill.cftypenumber = 'XF' and bill.cfcityid = '"+cityId+"' and  CT_PAY_AchieveDetailTem.CFFirClassNumber = item.fnumber ) "+
				"or  EXISTS (SELECT  1 FROM  CT_SRQ_ItemCheck bill inner join  CT_SRQ_ItemCheckEntrysec entry on   bill.fid = entry.fparentid  left JOIN  CT_SRQ_Paytypeitem item on  item.fid = entry.cfseconditemid  where  bill.cftypenumber = 'XF' and bill.cfcityid = '"+cityId+"' and  CT_PAY_AchieveDetailTem.CFSecClassnumber = item.fnumber ) "+
				"or  EXISTS (SELECT  1 FROM  CT_SRQ_ItemCheck bill inner join  CT_SRQ_ItemCheckEntrythi entry on   bill.fid = entry.fparentid  left JOIN  CT_SRQ_PayItem  item on  item.fid = entry.cfitemid  where  bill.cftypenumber = 'XF' and bill.cfcityid = '"+cityId+"' and  CT_PAY_AchieveDetailTem.cffeeitemdetailNUMBER = item.fnumber ) )   ");
		sqlYJ.append(" ) g) gg ");
		sqlYJ.append(" union ");
		// 儿牙
		sqlYJ.append(" select hh.summ,'ey' as type from (select sum(h.allm) as summ from ( ");
		sqlYJ.append(" SELECT nvl((sum(CFDocAchieve)),0) as allm FROM  CT_PAY_AchieveDetailTem where    "+dateSql+"   CFRecDotNumber ='"+empNum+"' and CFCityNumber='"+cityNumber+"'  "+
				"and ( EXISTS (SELECT  1 FROM  CT_SRQ_ItemCheck bill inner join  CT_SRQ_ItemCheckentry entry on   bill.fid = entry.fparentid  left JOIN  CT_SRQ_Paytypecategory  item on  item.fid = entry.cffirstitemid  where  bill.cftypenumber = 'EY' and bill.cfcityid = '"+cityId+"' and  CT_PAY_AchieveDetailTem.CFFirClassNumber = item.fnumber ) "+
				"or  EXISTS (SELECT  1 FROM  CT_SRQ_ItemCheck bill inner join  CT_SRQ_ItemCheckEntrysec entry on   bill.fid = entry.fparentid  left JOIN  CT_SRQ_Paytypeitem item on  item.fid = entry.cfseconditemid  where  bill.cftypenumber = 'EY' and bill.cfcityid = '"+cityId+"' and  CT_PAY_AchieveDetailTem.CFSecClassnumber = item.fnumber ) "+
				"or  EXISTS (SELECT  1 FROM  CT_SRQ_ItemCheck bill inner join  CT_SRQ_ItemCheckEntrythi entry on   bill.fid = entry.fparentid  left JOIN  CT_SRQ_PayItem  item on  item.fid = entry.cfitemid  where  bill.cftypenumber = 'EY' and bill.cfcityid = '"+cityId+"' and  CT_PAY_AchieveDetailTem.cffeeitemdetailNUMBER = item.fnumber ) )  ");
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
	public  static StringBuffer getZiDaiYeJiSql(String empNum, String cityNumber,String periodnum,String empName,BigDecimal zj,String cityId,String type){
		String dateSql = "";
		if(type.equals("ZC")){
			dateSql = "  to_char(fbizdate, 'yyyymm') = '"+periodnum+"' and  ";
		}else if(type.equals("CBQR")){
			dateSql = "  CFBUSINESSDATE = '"+periodnum+"' and  (cfisneedout = 0 or ( cfisneedout=1 and cfisout = 1))  and  ";
		}
		
		
		StringBuffer sqlYJ = new StringBuffer(); 
		sqlYJ.append("  /*dialect*/ SELECT nvl(sum(CFDocAchieve),0) as summ,'zz' as type FROM  CT_PAY_AchieveDetailTem  where    "+dateSql+"   CFSecSource = '自带'  and  CFRecDotNumber ='"+empNum+"'  and CFCityNumber='"+cityNumber+"' "+
				" and (EXISTS (SELECT  1 FROM  CT_SRQ_ItemCheck bill inner join  CT_SRQ_ItemCheckentry entry on   bill.fid = entry.fparentid  left JOIN  CT_SRQ_Paytypecategory  item on  item.fid = entry.cffirstitemid  where  bill.cftypenumber = 'ZZ' and bill.cfcityid = '"+cityId+"' and  CT_PAY_AchieveDetailTem.CFFirClassNumber = item.fnumber ) "+
				" or  EXISTS (SELECT  1 FROM  CT_SRQ_ItemCheck bill inner join  CT_SRQ_ItemCheckEntrysec entry on   bill.fid = entry.fparentid  left JOIN  CT_SRQ_Paytypeitem item on  item.fid = entry.cfseconditemid  where  bill.cftypenumber = 'ZZ' and bill.cfcityid = '"+cityId+"' and  CT_PAY_AchieveDetailTem.CFSecClassnumber = item.fnumber ) "+
				"or  EXISTS (SELECT  1 FROM  CT_SRQ_ItemCheck bill inner join  CT_SRQ_ItemCheckEntrythi entry on   bill.fid = entry.fparentid  left JOIN  CT_SRQ_PayItem  item on  item.fid = entry.cfitemid  where  bill.cftypenumber = 'ZZ' and bill.cfcityid = '"+cityId+"' and  CT_PAY_AchieveDetailTem.cffeeitemdetailNUMBER = item.fnumber ) )   ");
		
		sqlYJ.append("  union SELECT nvl(sum(CFDocAchieve)*"+zj+",0) as summ,'gdjz' as type FROM  CT_PAY_AchieveDetailTem where    "+dateSql+"   CFSecSource = '自带'   and CFIsRoutine='是'  and  CFRecDotNumber ='"+empNum+"'  and CFCityNumber='"+cityNumber+"' "+
				"and    not exists ( SELECT 1 FROM  CT_SRQ_ClinicItem clinicItem left join  CT_SRQ_ClinicItemEntry  entry  on clinicItem.fid = entry.fparentid  left join CT_SRQ_PayItem payItem on payItem.fid = entry.cfitemid  where clinicItem.cfcityid = '"+cityId+"' and  clinicItem.cfproject = '口内外正畸' and   CT_PAY_AchieveDetailTem.CFFeeItemDetailNumber = payItem.fnumber) "+
				"and ( EXISTS (SELECT  1 FROM  CT_SRQ_ItemCheck bill inner join  CT_SRQ_ItemCheckentry entry on   bill.fid = entry.fparentid  left JOIN  CT_SRQ_Paytypecategory  item on  item.fid = entry.cffirstitemid  where  bill.cftypenumber = 'GD' and bill.cfcityid = '"+cityId+"' and  CT_PAY_AchieveDetailTem.CFFirClassNumber = item.fnumber ) "+
				"or  EXISTS (SELECT  1 FROM  CT_SRQ_ItemCheck bill inner join  CT_SRQ_ItemCheckEntrysec entry on   bill.fid = entry.fparentid  left JOIN  CT_SRQ_Paytypeitem item on  item.fid = entry.cfseconditemid  where  bill.cftypenumber = 'GD' and bill.cfcityid = '"+cityId+"' and  CT_PAY_AchieveDetailTem.CFSecClassnumber = item.fnumber ) "+
				"or  EXISTS (SELECT  1 FROM  CT_SRQ_ItemCheck bill inner join  CT_SRQ_ItemCheckEntrythi entry on   bill.fid = entry.fparentid  left JOIN  CT_SRQ_PayItem  item on  item.fid = entry.cfitemid  where  bill.cftypenumber = 'GD' and bill.cfcityid = '"+cityId+"' and  CT_PAY_AchieveDetailTem.cffeeitemdetailNUMBER = item.fnumber ) ) ");
		
		sqlYJ.append("  union SELECT nvl(sum(CFDocAchieve)*"+zj+",0) as summ,'yxjz' as type FROM  CT_PAY_AchieveDetailTem where    "+dateSql+"   CFSecSource = '自带'  and CFIsRoutine='否'  and  CFRecDotNumber ='"+empNum+"'  and CFCityNumber='"+cityNumber+"' "+
				"and   not exists ( SELECT 1 FROM  CT_SRQ_ClinicItem clinicItem left join  CT_SRQ_ClinicItemEntry  entry  on clinicItem.fid = entry.fparentid  left join CT_SRQ_PayItem payItem on payItem.fid = entry.cfitemid  where clinicItem.cfcityid = '"+cityId+"' and  clinicItem.cfproject = '口内外正畸' and   CT_PAY_AchieveDetailTem.CFFeeItemDetailNumber = payItem.fnumber) "+
				" and ( EXISTS (SELECT  1 FROM  CT_SRQ_ItemCheck bill inner join  CT_SRQ_ItemCheckentry entry on   bill.fid = entry.fparentid  left JOIN  CT_SRQ_Paytypecategory  item on  item.fid = entry.cffirstitemid  where  bill.cftypenumber = 'YX' and bill.cfcityid = '"+cityId+"' and  CT_PAY_AchieveDetailTem.CFFirClassNumber = item.fnumber ) "+
				"or  EXISTS (SELECT  1 FROM  CT_SRQ_ItemCheck bill inner join  CT_SRQ_ItemCheckEntrysec entry on   bill.fid = entry.fparentid  left JOIN  CT_SRQ_Paytypeitem item on  item.fid = entry.cfseconditemid  where  bill.cftypenumber = 'YX' and bill.cfcityid = '"+cityId+"' and  CT_PAY_AchieveDetailTem.CFSecClassnumber = item.fnumber ) "+
				"or  EXISTS (SELECT  1 FROM  CT_SRQ_ItemCheck bill inner join  CT_SRQ_ItemCheckEntrythi entry on   bill.fid = entry.fparentid  left JOIN  CT_SRQ_PayItem  item on  item.fid = entry.cfitemid  where  bill.cftypenumber = 'YX' and bill.cfcityid = '"+cityId+"' and  CT_PAY_AchieveDetailTem.cffeeitemdetailNUMBER = item.fnumber ) )  ");
		
		sqlYJ.append("  union SELECT nvl(sum(CFDocAchieve),0) as summ,'yz' as type FROM  CT_PAY_AchieveDetailTem where    "+dateSql+"   CFSecSource = '自带'     and  CFRecDotNumber ='"+empNum+"'  and CFCityNumber='"+cityNumber+"' "+
				"and ( EXISTS (SELECT  1 FROM  CT_SRQ_ItemCheck bill inner join  CT_SRQ_ItemCheckentry entry on   bill.fid = entry.fparentid  left JOIN  CT_SRQ_Paytypecategory  item on  item.fid = entry.cffirstitemid  where  bill.cftypenumber = 'YZ' and bill.cfcityid = '"+cityId+"' and  CT_PAY_AchieveDetailTem.CFFirClassNumber = item.fnumber ) "+
				"or  EXISTS (SELECT  1 FROM  CT_SRQ_ItemCheck bill inner join  CT_SRQ_ItemCheckEntrysec entry on   bill.fid = entry.fparentid  left JOIN  CT_SRQ_Paytypeitem item on  item.fid = entry.cfseconditemid  where  bill.cftypenumber = 'YZ' and bill.cfcityid = '"+cityId+"' and  CT_PAY_AchieveDetailTem.CFSecClassnumber = item.fnumber ) "+
				"or  EXISTS (SELECT  1 FROM  CT_SRQ_ItemCheck bill inner join  CT_SRQ_ItemCheckEntrythi entry on   bill.fid = entry.fparentid  left JOIN  CT_SRQ_PayItem  item on  item.fid = entry.cfitemid  where  bill.cftypenumber = 'YZ' and bill.cfcityid = '"+cityId+"' and  CT_PAY_AchieveDetailTem.cffeeitemdetailNUMBER = item.fnumber ) ) ");
		
		sqlYJ.append("  union SELECT nvl(sum(CFDocAchieve),0) as summ,'knw' as type FROM  CT_PAY_AchieveDetailTem where    "+dateSql+"  CFSecSource = '自带'  and  CFRecDotNumber ='"+empNum+"'  and CFCityNumber='"+cityNumber+"' "+
				"and  (  exists ( SELECT 1 FROM  CT_SRQ_ClinicItem clinicItem left join  CT_SRQ_ClinicItemEntry  entry  on clinicItem.fid = entry.fparentid  left join CT_SRQ_PayItem payItem on payItem.fid = entry.cfitemid  where clinicItem.cfcityid = '"+cityId+"' and  clinicItem.cfproject = '口内外' and   CT_PAY_AchieveDetailTem.CFFeeItemDetailNumber = payItem.fnumber) "+
				"or ( EXISTS (SELECT  1 FROM  CT_SRQ_ItemCheck bill inner join  CT_SRQ_ItemCheckentry entry on   bill.fid = entry.fparentid  left JOIN  CT_SRQ_Paytypecategory  item on  item.fid = entry.cffirstitemid  where  bill.cftypenumber = 'KNW' and bill.cfcityid = '"+cityId+"' and  CT_PAY_AchieveDetailTem.CFFirClassNumber = item.fnumber ) "+
				"or  EXISTS (SELECT  1 FROM  CT_SRQ_ItemCheck bill inner join  CT_SRQ_ItemCheckEntrysec entry on   bill.fid = entry.fparentid  left JOIN  CT_SRQ_Paytypeitem item on  item.fid = entry.cfseconditemid  where  bill.cftypenumber = 'KNW' and bill.cfcityid = '"+cityId+"' and  CT_PAY_AchieveDetailTem.CFSecClassnumber = item.fnumber ) "+
				"or  EXISTS (SELECT  1 FROM  CT_SRQ_ItemCheck bill inner join  CT_SRQ_ItemCheckEntrythi entry on   bill.fid = entry.fparentid  left JOIN  CT_SRQ_PayItem  item on  item.fid = entry.cfitemid  where  bill.cftypenumber = 'KNW' and bill.cfcityid = '"+cityId+"' and  CT_PAY_AchieveDetailTem.cffeeitemdetailNUMBER = item.fnumber ) )  )");
		
		sqlYJ.append("  union SELECT nvl(sum(CFDocAchieve),0) as summ,'mb' as type FROM  CT_PAY_AchieveDetailTem where    "+dateSql+"   CFSecSource = '自带' and  CFRecDotNumber ='"+empNum+"'  and CFCityNumber='"+cityNumber+"'  "+
				"and ( EXISTS (SELECT  1 FROM  CT_SRQ_ItemCheck bill inner join  CT_SRQ_ItemCheckentry entry on   bill.fid = entry.fparentid  left JOIN  CT_SRQ_Paytypecategory  item on  item.fid = entry.cffirstitemid  where  bill.cftypenumber = 'MB' and bill.cfcityid = '"+cityId+"' and  CT_PAY_AchieveDetailTem.CFFirClassNumber = item.fnumber ) "+
				"or  EXISTS (SELECT  1 FROM  CT_SRQ_ItemCheck bill inner join  CT_SRQ_ItemCheckEntrysec entry on   bill.fid = entry.fparentid  left JOIN  CT_SRQ_Paytypeitem item on  item.fid = entry.cfseconditemid  where  bill.cftypenumber = 'MB' and bill.cfcityid = '"+cityId+"' and  CT_PAY_AchieveDetailTem.CFSecClassnumber = item.fnumber ) "+
				"or  EXISTS (SELECT  1 FROM  CT_SRQ_ItemCheck bill inner join  CT_SRQ_ItemCheckEntrythi entry on   bill.fid = entry.fparentid  left JOIN  CT_SRQ_PayItem  item on  item.fid = entry.cfitemid  where  bill.cftypenumber = 'MB' and bill.cfcityid = '"+cityId+"' and  CT_PAY_AchieveDetailTem.cffeeitemdetailNUMBER = item.fnumber ) )    ");
		
		sqlYJ.append("  union SELECT nvl(sum(CFDocAchieve),0) as summ,'xf' as type FROM  CT_PAY_AchieveDetailTem where    "+dateSql+"   CFSecSource = '自带'   and  CFRecDotNumber ='"+empNum+"'  and CFCityNumber='"+cityNumber+"' "+
				" and ( EXISTS (SELECT  1 FROM  CT_SRQ_ItemCheck bill inner join  CT_SRQ_ItemCheckentry entry on   bill.fid = entry.fparentid  left JOIN  CT_SRQ_Paytypecategory  item on  item.fid = entry.cffirstitemid  where  bill.cftypenumber = 'XF' and bill.cfcityid = '"+cityId+"' and  CT_PAY_AchieveDetailTem.CFFirClassNumber = item.fnumber ) "+
				"or  EXISTS (SELECT  1 FROM  CT_SRQ_ItemCheck bill inner join  CT_SRQ_ItemCheckEntrysec entry on   bill.fid = entry.fparentid  left JOIN  CT_SRQ_Paytypeitem item on  item.fid = entry.cfseconditemid  where  bill.cftypenumber = 'XF' and bill.cfcityid = '"+cityId+"' and  CT_PAY_AchieveDetailTem.CFSecClassnumber = item.fnumber ) "+
				"or  EXISTS (SELECT  1 FROM  CT_SRQ_ItemCheck bill inner join  CT_SRQ_ItemCheckEntrythi entry on   bill.fid = entry.fparentid  left JOIN  CT_SRQ_PayItem  item on  item.fid = entry.cfitemid  where  bill.cftypenumber = 'XF' and bill.cfcityid = '"+cityId+"' and  CT_PAY_AchieveDetailTem.cffeeitemdetailNUMBER = item.fnumber ) )  ");
		
		sqlYJ.append("  union SELECT nvl(sum(CFDocAchieve),0) as summ,'ey' as type FROM  CT_PAY_AchieveDetailTem where    "+dateSql+"   CFSecSource = '自带'   and  CFRecDotNumber ='"+empNum+"'  and CFCityNumber='"+cityNumber+"'  "+
				"and ( EXISTS (SELECT  1 FROM  CT_SRQ_ItemCheck bill inner join  CT_SRQ_ItemCheckentry entry on   bill.fid = entry.fparentid  left JOIN  CT_SRQ_Paytypecategory  item on  item.fid = entry.cffirstitemid  where  bill.cftypenumber = 'EY' and bill.cfcityid = '"+cityId+"' and  CT_PAY_AchieveDetailTem.CFFirClassNumber = item.fnumber ) "+
				"or  EXISTS (SELECT  1 FROM  CT_SRQ_ItemCheck bill inner join  CT_SRQ_ItemCheckEntrysec entry on   bill.fid = entry.fparentid  left JOIN  CT_SRQ_Paytypeitem item on  item.fid = entry.cfseconditemid  where  bill.cftypenumber = 'EY' and bill.cfcityid = '"+cityId+"' and  CT_PAY_AchieveDetailTem.CFSecClassnumber = item.fnumber ) "+
				"or  EXISTS (SELECT  1 FROM  CT_SRQ_ItemCheck bill inner join  CT_SRQ_ItemCheckEntrythi entry on   bill.fid = entry.fparentid  left JOIN  CT_SRQ_PayItem  item on  item.fid = entry.cfitemid  where  bill.cftypenumber = 'EY' and bill.cfcityid = '"+cityId+"' and  CT_PAY_AchieveDetailTem.cffeeitemdetailNUMBER = item.fnumber ) ) ");
		
		return sqlYJ;
	}
	
	/**
	 * 统计兼职医生非自带患者的业绩
	 * @param empNum
	 * @param clinicNumber
	 * @param periodnum
	 * @param sqlYJ
	 * @return
	 * @throws Exception 
	 */	
	public static StringBuffer getFeiZiDaiSql(Context ctx,String empNum, String cityNumber,String periodnum,String empName,BigDecimal zj,String cityId,String type) throws Exception{
		String dateSql = "";
		if(type.equals("ZC")){
			dateSql = "  to_char(fbizdate, 'yyyymm') = '"+periodnum+"' and  ";
		}else if(type.equals("CBQR")){
			dateSql = "  CFBUSINESSDATE = '"+periodnum+"' and  (cfisneedout = 0 or ( cfisneedout=1 and cfisout = 1))  and  ";
		} 
		
		StringBuffer sqlYJ = new StringBuffer(); 
		//种植
		sqlYJ.append("  /*dialect*/ select aa.summ,'zz' as type from ( ");
		sqlYJ.append(" select sum(a.allm) as summ from ( ");
		sqlYJ.append(" SELECT nvl((sum(cfdocachieve)),0) as allm FROM  CT_PAY_AchieveDetailTem where    "+dateSql+"  CFSecSource != '自带'  and  CFRecDotNumber ='"+empNum+"'  and CFCityNumber='"+cityNumber+"'   "+
				"and  (EXISTS (SELECT  1 FROM  CT_SRQ_ItemCheck bill inner join  CT_SRQ_ItemCheckentry entry on   bill.fid = entry.fparentid  left JOIN  CT_SRQ_Paytypecategory  item on  item.fid = entry.cffirstitemid  where  bill.cftypenumber = 'ZZ' and bill.cfcityid = '"+cityId+"' and  CT_PAY_AchieveDetailTem.CFFirClassNumber = item.fnumber ) "+
				"or  EXISTS (SELECT  1 FROM  CT_SRQ_ItemCheck bill inner join  CT_SRQ_ItemCheckEntrysec entry on   bill.fid = entry.fparentid  left JOIN  CT_SRQ_Paytypeitem item on  item.fid = entry.cfseconditemid  where  bill.cftypenumber = 'ZZ' and bill.cfcityid = '"+cityId+"' and  CT_PAY_AchieveDetailTem.CFSecClassnumber = item.fnumber ) "+
				"or  EXISTS (SELECT  1 FROM  CT_SRQ_ItemCheck bill inner join  CT_SRQ_ItemCheckEntrythi entry on   bill.fid = entry.fparentid  left JOIN  CT_SRQ_PayItem  item on  item.fid = entry.cfitemid  where  bill.cftypenumber = 'ZZ' and bill.cfcityid = '"+cityId+"' and  CT_PAY_AchieveDetailTem.cffeeitemdetailNUMBER = item.fnumber ) )   ");
		sqlYJ.append(" ) a ) aa ");
		sqlYJ.append(" union ");
		//固定矫正
		sqlYJ.append(" select bb.summ,'gdjz' as type from (select sum(b.allm) as summ from (");
		sqlYJ.append(" SELECT nvl((sum(cfdocachieve)*"+zj+"),0) as allm FROM  CT_PAY_AchieveDetailTem where    "+dateSql+"     CFSecSource != '自带'    and CFIsRoutine='是'  and   CFRecDotNumber ='"+empNum+"'  and CFCityNumber='"+cityNumber+"' "+
				"and    not exists ( SELECT 1 FROM  CT_SRQ_ClinicItem clinicItem left join  CT_SRQ_ClinicItemEntry  entry  on clinicItem.fid = entry.fparentid  left join CT_SRQ_PayItem payItem on payItem.fid = entry.cfitemid  where clinicItem.cfcityid = '"+cityId+"' and  clinicItem.cfproject = '口内外正畸' and   CT_PAY_AchieveDetailTem.CFFeeItemDetailNumber = payItem.fnumber) "+
				"and ( EXISTS (SELECT  1 FROM  CT_SRQ_ItemCheck bill inner join  CT_SRQ_ItemCheckentry entry on   bill.fid = entry.fparentid  left JOIN  CT_SRQ_Paytypecategory  item on  item.fid = entry.cffirstitemid  where  bill.cftypenumber = 'GD' and bill.cfcityid = '"+cityId+"' and  CT_PAY_AchieveDetailTem.CFFirClassNumber = item.fnumber ) "+
				"or  EXISTS (SELECT  1 FROM  CT_SRQ_ItemCheck bill inner join  CT_SRQ_ItemCheckEntrysec entry on   bill.fid = entry.fparentid  left JOIN  CT_SRQ_Paytypeitem item on  item.fid = entry.cfseconditemid  where  bill.cftypenumber = 'GD' and bill.cfcityid = '"+cityId+"' and  CT_PAY_AchieveDetailTem.CFSecClassnumber = item.fnumber ) "+
				"or  EXISTS (SELECT  1 FROM  CT_SRQ_ItemCheck bill inner join  CT_SRQ_ItemCheckEntrythi entry on   bill.fid = entry.fparentid  left JOIN  CT_SRQ_PayItem  item on  item.fid = entry.cfitemid  where  bill.cftypenumber = 'GD' and bill.cfcityid = '"+cityId+"' and  CT_PAY_AchieveDetailTem.cffeeitemdetailNUMBER = item.fnumber ) )  ");
		sqlYJ.append(" ) b) bb ");
		sqlYJ.append(" union ");
		//隐形矫正
		sqlYJ.append(" select cc.summ,'yxjz' as type from (select sum(c.allm) as summ from ( ");
		sqlYJ.append(" SELECT nvl((sum(cfdocachieve)*"+zj+"),0) as allm FROM  CT_PAY_AchieveDetailTem where     "+dateSql+"   CFSecSource != '自带'   and CFIsRoutine='否'  and   CFRecDotNumber ='"+empNum+"'  and CFCityNumber='"+cityNumber+"' "+
				"and   not exists ( SELECT 1 FROM  CT_SRQ_ClinicItem clinicItem left join  CT_SRQ_ClinicItemEntry  entry  on clinicItem.fid = entry.fparentid  left join CT_SRQ_PayItem payItem on payItem.fid = entry.cfitemid  where clinicItem.cfcityid = '"+cityId+"' and  clinicItem.cfproject = '口内外正畸' and   CT_PAY_AchieveDetailTem.CFFeeItemDetailNumber = payItem.fnumber) "+
				"and ( EXISTS (SELECT  1 FROM  CT_SRQ_ItemCheck bill inner join  CT_SRQ_ItemCheckentry entry on   bill.fid = entry.fparentid  left JOIN  CT_SRQ_Paytypecategory  item on  item.fid = entry.cffirstitemid  where  bill.cftypenumber = 'YX' and bill.cfcityid = '"+cityId+"' and  CT_PAY_AchieveDetailTem.CFFirClassNumber = item.fnumber ) "+
				"or  EXISTS (SELECT  1 FROM  CT_SRQ_ItemCheck bill inner join  CT_SRQ_ItemCheckEntrysec entry on   bill.fid = entry.fparentid  left JOIN  CT_SRQ_Paytypeitem item on  item.fid = entry.cfseconditemid  where  bill.cftypenumber = 'YX' and bill.cfcityid = '"+cityId+"' and  CT_PAY_AchieveDetailTem.CFSecClassnumber = item.fnumber ) "+
				"or  EXISTS (SELECT  1 FROM  CT_SRQ_ItemCheck bill inner join  CT_SRQ_ItemCheckEntrythi entry on   bill.fid = entry.fparentid  left JOIN  CT_SRQ_PayItem  item on  item.fid = entry.cfitemid  where  bill.cftypenumber = 'YX' and bill.cfcityid = '"+cityId+"' and  CT_PAY_AchieveDetailTem.cffeeitemdetailNUMBER = item.fnumber ) ) ");
		sqlYJ.append(" ) c) cc ");
		sqlYJ.append(" union ");
		//牙周
		sqlYJ.append(" select dd.summ,'yz' as type from (select sum(d.allm) as summ from ( ");
		sqlYJ.append(" SELECT nvl((sum(cfdocachieve)),0) as allm FROM  CT_PAY_AchieveDetailTem where    "+dateSql+"  CFSecSource != '自带'    and   CFRecDotNumber ='"+empNum+"'  and CFCityNumber='"+cityNumber+"' "+
				"and ( EXISTS (SELECT  1 FROM  CT_SRQ_ItemCheck bill inner join  CT_SRQ_ItemCheckentry entry on   bill.fid = entry.fparentid  left JOIN  CT_SRQ_Paytypecategory  item on  item.fid = entry.cffirstitemid  where  bill.cftypenumber = 'YZ' and bill.cfcityid = '"+cityId+"' and  CT_PAY_AchieveDetailTem.CFFirClassNumber = item.fnumber ) "+
				"or  EXISTS (SELECT  1 FROM  CT_SRQ_ItemCheck bill inner join  CT_SRQ_ItemCheckEntrysec entry on   bill.fid = entry.fparentid  left JOIN  CT_SRQ_Paytypeitem item on  item.fid = entry.cfseconditemid  where  bill.cftypenumber = 'YZ' and bill.cfcityid = '"+cityId+"' and  CT_PAY_AchieveDetailTem.CFSecClassnumber = item.fnumber ) "+
				"or  EXISTS (SELECT  1 FROM  CT_SRQ_ItemCheck bill inner join  CT_SRQ_ItemCheckEntrythi entry on   bill.fid = entry.fparentid  left JOIN  CT_SRQ_PayItem  item on  item.fid = entry.cfitemid  where  bill.cftypenumber = 'YZ' and bill.cfcityid = '"+cityId+"' and  CT_PAY_AchieveDetailTem.cffeeitemdetailNUMBER = item.fnumber ) )  ");
		sqlYJ.append(" ) d) dd ");
		sqlYJ.append(" union ");
		//口内外
		/*sqlYJ.append(" select ee.summ,'knw' as type from (select sum(e.allm) as summ from ( ");
		sqlYJ.append(" SELECT nvl((sum(cfdocachieve)*"+yijibl+"),0) as allm FROM  CT_PAY_AchieveDetailTem where  CFFIRSOURCE = '渠道推广'  and CFTERSOURCE != '"+empName+"'   and  CFFirClassNumber='1'  and CFSecClassnumber in ('762','646')  and   CFRecDotNumber ='"+empNum+"'  and CFClinicNumber='"+clinicNumber+"'       ");
		sqlYJ.append(" union  SELECT  nvl((sum(cfdocachieve)*"+erjibl+"),0) as allm FROM  CT_PAY_AchieveDetailTem  where  CFTerSource = '老吾老'  and CFTERSOURCE != '"+empName+"'  and  CFFirClassNumber='1'  and CFSecClassnumber in ('762','646')  and   CFRecDotNumber ='"+empNum+"'  and CFClinicNumber='"+clinicNumber+"' ");
		sqlYJ.append(" union  SELECT  nvl(sum(cfdocachieve),0) as allm FROM  CT_PAY_AchieveDetailTem  where   (CFTerSource != '老吾老' or CFTerSource is null )  and CFFIRSOURCE !=  '渠道推广' and CFTERSOURCE != '"+empName+"'   and  CFFirClassNumber='1'  and CFSecClassnumber in ('762','646')  and   CFRecDotNumber ='"+empNum+"'  and CFClinicNumber='"+clinicNumber+"'   ");
		sqlYJ.append(" ) e) ee ");
		sqlYJ.append(" union ");*/
		sqlYJ.append(" select ee.summ,'knw' as type from (select sum(e.allm) as summ from ( ");
		sqlYJ.append(" SELECT nvl((sum(cfdocachieve)),0) as allm FROM  CT_PAY_AchieveDetailTem where    "+dateSql+"    CFSecSource != '自带'   and   CFRecDotNumber ='"+empNum+"'  and CFCityNumber='"+cityNumber+"' "+
				"and   ( exists ( SELECT 1 FROM  CT_SRQ_ClinicItem clinicItem left join  CT_SRQ_ClinicItemEntry  entry  on clinicItem.fid = entry.fparentid  left join CT_SRQ_PayItem payItem on payItem.fid = entry.cfitemid  where clinicItem.cfcityid = '"+cityId+"' and  clinicItem.cfproject = '口内外' and   CT_PAY_AchieveDetailTem.CFFeeItemDetailNumber = payItem.fnumber ) "+
				"or ( EXISTS (SELECT  1 FROM  CT_SRQ_ItemCheck bill inner join  CT_SRQ_ItemCheckentry entry on   bill.fid = entry.fparentid  left JOIN  CT_SRQ_Paytypecategory  item on  item.fid = entry.cffirstitemid  where  bill.cftypenumber = 'KNW' and bill.cfcityid = '"+cityId+"' and  CT_PAY_AchieveDetailTem.CFFirClassNumber = item.fnumber ) "+
				"or  EXISTS (SELECT  1 FROM  CT_SRQ_ItemCheck bill inner join  CT_SRQ_ItemCheckEntrysec entry on   bill.fid = entry.fparentid  left JOIN  CT_SRQ_Paytypeitem item on  item.fid = entry.cfseconditemid  where  bill.cftypenumber = 'KNW' and bill.cfcityid = '"+cityId+"' and  CT_PAY_AchieveDetailTem.CFSecClassnumber = item.fnumber ) "+
				"or  EXISTS (SELECT  1 FROM  CT_SRQ_ItemCheck bill inner join  CT_SRQ_ItemCheckEntrythi entry on   bill.fid = entry.fparentid  left JOIN  CT_SRQ_PayItem  item on  item.fid = entry.cfitemid  where  bill.cftypenumber = 'KNW' and bill.cfcityid = '"+cityId+"' and  CT_PAY_AchieveDetailTem.cffeeitemdetailNUMBER = item.fnumber ) ) )");
		sqlYJ.append(" ) e) ee ");
		sqlYJ.append(" union ");
		// 美白
		sqlYJ.append(" select ff.summ,'mb' as type from (select sum(f.allm) as summ from ( ");
		sqlYJ.append(" SELECT nvl((sum(cfdocachieve)),0) as allm FROM  CT_PAY_AchieveDetailTem where     "+dateSql+"    CFSecSource != '自带'  and   CFRecDotNumber ='"+empNum+"'  and CFCityNumber='"+cityNumber+"'  "+
				"and ( EXISTS (SELECT  1 FROM  CT_SRQ_ItemCheck bill inner join  CT_SRQ_ItemCheckentry entry on   bill.fid = entry.fparentid  left JOIN  CT_SRQ_Paytypecategory  item on  item.fid = entry.cffirstitemid  where  bill.cftypenumber = 'MB' and bill.cfcityid = '"+cityId+"' and  CT_PAY_AchieveDetailTem.CFFirClassNumber = item.fnumber ) "+
				"or  EXISTS (SELECT  1 FROM  CT_SRQ_ItemCheck bill inner join  CT_SRQ_ItemCheckEntrysec entry on   bill.fid = entry.fparentid  left JOIN  CT_SRQ_Paytypeitem item on  item.fid = entry.cfseconditemid  where  bill.cftypenumber = 'MB' and bill.cfcityid = '"+cityId+"' and  CT_PAY_AchieveDetailTem.CFSecClassnumber = item.fnumber ) "+
				"or  EXISTS (SELECT  1 FROM  CT_SRQ_ItemCheck bill inner join  CT_SRQ_ItemCheckEntrythi entry on   bill.fid = entry.fparentid  left JOIN  CT_SRQ_PayItem  item on  item.fid = entry.cfitemid  where  bill.cftypenumber = 'MB' and bill.cfcityid = '"+cityId+"' and  CT_PAY_AchieveDetailTem.cffeeitemdetailNUMBER = item.fnumber ) )     ");
		sqlYJ.append(" ) f) ff ");
		sqlYJ.append(" union ");
		//修复
		sqlYJ.append(" select gg.summ,'xf' as type from (select sum(g.allm) as summ from ( ");
		sqlYJ.append(" SELECT nvl((sum(cfdocachieve)),0) as allm FROM  CT_PAY_AchieveDetailTem where    "+dateSql+"   CFSecSource != '自带'   and   CFRecDotNumber ='"+empNum+"'  and CFCityNumber='"+cityNumber+"' "+
				" and ( EXISTS (SELECT  1 FROM  CT_SRQ_ItemCheck bill inner join  CT_SRQ_ItemCheckentry entry on   bill.fid = entry.fparentid  left JOIN  CT_SRQ_Paytypecategory  item on  item.fid = entry.cffirstitemid  where  bill.cftypenumber = 'XF' and bill.cfcityid = '"+cityId+"' and  CT_PAY_AchieveDetailTem.CFFirClassNumber = item.fnumber ) "+
				"or  EXISTS (SELECT  1 FROM  CT_SRQ_ItemCheck bill inner join  CT_SRQ_ItemCheckEntrysec entry on   bill.fid = entry.fparentid  left JOIN  CT_SRQ_Paytypeitem item on  item.fid = entry.cfseconditemid  where  bill.cftypenumber = 'XF' and bill.cfcityid = '"+cityId+"' and  CT_PAY_AchieveDetailTem.CFSecClassnumber = item.fnumber ) "+
				"or  EXISTS (SELECT  1 FROM  CT_SRQ_ItemCheck bill inner join  CT_SRQ_ItemCheckEntrythi entry on   bill.fid = entry.fparentid  left JOIN  CT_SRQ_PayItem  item on  item.fid = entry.cfitemid  where  bill.cftypenumber = 'XF' and bill.cfcityid = '"+cityId+"' and  CT_PAY_AchieveDetailTem.cffeeitemdetailNUMBER = item.fnumber ) )      ");
		sqlYJ.append(" ) g) gg ");
		sqlYJ.append(" union ");
		// 儿牙
		sqlYJ.append(" select hh.summ,'ey' as type from (select sum(h.allm) as summ from ( ");
		sqlYJ.append(" SELECT nvl((sum(cfdocachieve)),0) as allm FROM  CT_PAY_AchieveDetailTem where    "+dateSql+"    CFSecSource != '自带'   and   CFRecDotNumber ='"+empNum+"'  and CFCityNumber='"+cityNumber+"'   "+
				" and ( EXISTS (SELECT  1 FROM  CT_SRQ_ItemCheck bill inner join  CT_SRQ_ItemCheckentry entry on   bill.fid = entry.fparentid  left JOIN  CT_SRQ_Paytypecategory  item on  item.fid = entry.cffirstitemid  where  bill.cftypenumber = 'EY' and bill.cfcityid = '"+cityId+"' and  CT_PAY_AchieveDetailTem.CFFirClassNumber = item.fnumber ) "+
				"or  EXISTS (SELECT  1 FROM  CT_SRQ_ItemCheck bill inner join  CT_SRQ_ItemCheckEntrysec entry on   bill.fid = entry.fparentid  left JOIN  CT_SRQ_Paytypeitem item on  item.fid = entry.cfseconditemid  where  bill.cftypenumber = 'EY' and bill.cfcityid = '"+cityId+"' and  CT_PAY_AchieveDetailTem.CFSecClassnumber = item.fnumber ) "+
				"or  EXISTS (SELECT  1 FROM  CT_SRQ_ItemCheck bill inner join  CT_SRQ_ItemCheckEntrythi entry on   bill.fid = entry.fparentid  left JOIN  CT_SRQ_PayItem  item on  item.fid = entry.cfitemid  where  bill.cftypenumber = 'EY' and bill.cfcityid = '"+cityId+"' and  CT_PAY_AchieveDetailTem.cffeeitemdetailNUMBER = item.fnumber ) )   ");
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
				        	
				        	allMap.put("neg"+key,value);
				        	
			                negValue = negValue.add(value.multiply(bili).divide(negBili,6,BigDecimal.ROUND_HALF_UP).abs());
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
				        	
				        	allMap.put("neg"+key,value.abs());
				        	
		                    negit.remove();
		                	negMap.remove(negKey);
		                	negit = negMap.keySet().iterator();
		                	
		                    break;
		                }else{//正数  多出一部分
		                	negit.remove();
		                	negMap.remove(negKey);
		                	negit = negMap.keySet().iterator();
		                	 
		                	allMap.put("neg"+key,negValue.multiply(negBili).divide(bili,6,BigDecimal.ROUND_HALF_UP).abs());
		                	
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
	}
	
	private  BigDecimal docZiDai(Context ctx, HashMap map ,String empNum, String cityNumber,String periodnum ,String clinicNumber , HashMap tempMap ,String cityId,String calType,String type){ 
		ExecutorService pool = Executors.newFixedThreadPool(6);
	    ParallelSqlExecutor pe = new ParallelSqlExecutor(pool); 
	    String userId = ContextHelperFactory.getLocalInstance(ctx).getCurrentUser().getId().toString(); 
	    
	    //导入种植
		BigDecimal imzz = BigDecimal.ZERO ;
		//导入固定矫正
		BigDecimal imgdjz = BigDecimal.ZERO; 
		//导入隐形矫正
		BigDecimal imyxjz = BigDecimal.ZERO; 
		//导入牙周
		BigDecimal imyz = BigDecimal.ZERO; 
		//导入口内外
		BigDecimal imknw = BigDecimal.ZERO; 
		//导入美白
		BigDecimal immb = BigDecimal.ZERO; 
		//导入修复
		BigDecimal imxf = BigDecimal.ZERO; 
		//导入儿牙
		BigDecimal imey = BigDecimal.ZERO; 
		
	    BigDecimal bymoney  = BigDecimal.ZERO;
	    
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
		
		clinicCostSumInfo.setUpgdjzCost(BigDecimal.ZERO);clinicCostSumInfo.setImgdjzCost(BigDecimal.ZERO); 
		clinicCostSumInfo.setUpzzCost(BigDecimal.ZERO);clinicCostSumInfo.setImzzCost(BigDecimal.ZERO);
		clinicCostSumInfo.setUpyxjzCost(BigDecimal.ZERO);clinicCostSumInfo.setImyxjzCost(BigDecimal.ZERO);
		clinicCostSumInfo.setUpyzCost(BigDecimal.ZERO);clinicCostSumInfo.setImyzCost(BigDecimal.ZERO);
		clinicCostSumInfo.setUpknwCost(BigDecimal.ZERO);clinicCostSumInfo.setImknwCost(BigDecimal.ZERO);
		clinicCostSumInfo.setUpmbCost(BigDecimal.ZERO);clinicCostSumInfo.setImmbCost(BigDecimal.ZERO);
		clinicCostSumInfo.setUpxfCost(BigDecimal.ZERO);clinicCostSumInfo.setImxfCost(BigDecimal.ZERO);
		clinicCostSumInfo.setUpeyCost(BigDecimal.ZERO);clinicCostSumInfo.setImeyCost(BigDecimal.ZERO);
		
		clinicCostSumInfo.setEmpNumber(empNum);

		clinicCostSumInfo.setCityNumber(cityNumber);
		clinicCostSumInfo.setBusinessDate(periodnum); 
		clinicCostSumInfo.setCityName(tempMap.get("cityName").toString());
		clinicCostSumInfo.setEmpName(tempMap.get("empName").toString());
		clinicCostSumInfo.setIzzidai(true);
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
		 
		HashMap<String,BigDecimal> biliMap = new HashMap<String,BigDecimal>(); 
		biliMap.put("zz",byzzbl );
		biliMap.put("gdjz",bygdjzbl );
		biliMap.put("yxjz",byyxjzbl );
		biliMap.put("yz",byyzbl );
		biliMap.put("knw",byknwbl );
		biliMap.put("mb",bymbbl );
		biliMap.put("xf",byxfbl );
		biliMap.put("ey",byeybl ); 
		
		
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
			  		
			  		
			  	   //导入种植
					imzz = yjImprs.getBigDecimal("ZZ");
					//导入固定矫正
					imgdjz =yjImprs.getBigDecimal("GDJZ");
					//导入隐形矫正
					imyxjz = yjImprs.getBigDecimal("YXJZ");
					//导入牙周
					imyz = yjImprs.getBigDecimal("YZ");
					//导入口内外
					imknw = yjImprs.getBigDecimal("KNW");
					//导入美白
					immb = yjImprs.getBigDecimal("MB");
					//导入修复
					imxf = yjImprs.getBigDecimal("XF");
					//导入儿牙
					imey = yjImprs.getBigDecimal("EY");
			  		 
				}
			}
		  	
			//计算自带患者的 业绩
			StringBuffer sqlZD = new StringBuffer(); 
			sqlZD = getZiDaiYeJiSql( empNum,  cityNumber, periodnum, empName,zj,cityId,type);
			IRowSet zdrs = com.kingdee.eas.custom.util.DBUtil.executeQuery(ctx,sqlZD.toString());
			if(zdrs!=null && zdrs.size() > 0){
				  while(zdrs.next()){	  
					  if("zz".equals(zdrs.getString("TYPE"))){//种植
						  byzz =byzz.add(new BigDecimal(zdrs.getString("SUMM")));  
						  
						  imandxtinsertsql +=  ", CFXTZZACHIEVE  ";
						  imandxtinsertValueSql +=" ,"+new BigDecimal(zdrs.getString("SUMM"))+" ";
						  
					  }else if("gdjz".equals(zdrs.getString("TYPE"))){//固定矫正  
						  bygdjz=bygdjz.add(new BigDecimal(zdrs.getString("SUMM")));  
						  
						  imandxtinsertsql +=  "  , CFXTGDJZACHIEVE  ";
						  imandxtinsertValueSql +="   ,"+new BigDecimal(zdrs.getString("SUMM"))+" ";
					  }else if("yxjz".equals(zdrs.getString("TYPE"))){//隐形矫正
						  byyxjz=byyxjz.add(new BigDecimal(zdrs.getString("SUMM")));  
						  
						  imandxtinsertsql +=  " , cfXTyxjzachieve ";
						  imandxtinsertValueSql +="  ,"+new BigDecimal(zdrs.getString("SUMM"))+" ";
					  }else if("yz".equals(zdrs.getString("TYPE"))){//牙周 ？
						  byyz=byyz.add(new BigDecimal(zdrs.getString("SUMM")));  
						  
						  imandxtinsertsql +=  " , CFXTyzAchieve  ";
						  imandxtinsertValueSql +=" ,"+new BigDecimal(zdrs.getString("SUMM"))+"  ";
					  }else if("knw".equals(zdrs.getString("TYPE"))){//口内外 ？
						  byknw =byknw.add(new BigDecimal(zdrs.getString("SUMM"))); 
						  

						  imandxtinsertsql +=  "  , cfXTknwachieve   ";
						  imandxtinsertValueSql +="  ,"+new BigDecimal(zdrs.getString("SUMM"))+"  ";
						  
					  }else if("mb".equals(zdrs.getString("TYPE"))){//美白
						  bymb=bymb.add(new BigDecimal(zdrs.getString("SUMM")));  
						  
						  imandxtinsertsql +=  "  , cfXTmbachieve ";
							 imandxtinsertValueSql +="  ,"+new BigDecimal(zdrs.getString("SUMM"))+"   ";
					  }else if("xf".equals(zdrs.getString("TYPE"))){//修复
						  byxf=byxf.add(new BigDecimal(zdrs.getString("SUMM")));  
						  
						  imandxtinsertsql +=  " , cfXTxfachieve ";
						  imandxtinsertValueSql +=" ,"+new BigDecimal(zdrs.getString("SUMM"))+"  ";
					  }else if("ey".equals(zdrs.getString("TYPE"))){//儿牙
						  byey=byey.add(new BigDecimal(zdrs.getString("SUMM")));  
						  
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
		
			BigDecimal zzBase =  BigDecimal.ZERO;
			BigDecimal gdjzBase = BigDecimal.ZERO;
			BigDecimal yxjzBase = BigDecimal.ZERO;
			BigDecimal yzBase = BigDecimal.ZERO;
			BigDecimal knwBase = BigDecimal.ZERO; 
			BigDecimal xfBase = BigDecimal.ZERO;
			BigDecimal eyBase = BigDecimal.ZERO;
			if(calType != null  && calType.equals("zskc")){
				
				HashMap<String,BigDecimal> allMap =  setJingWork( byzz, zzcb, bygdjz, gdjzcb, byyxjz, yxjzcb, byyz, yzcb, byknw, knwcb, byxf, xfcb, byey, eycb,  biliMap, calType);
				String nextPeriod  = getNextPeriod( periodnum);
				if(DoctorCostsFactory.getLocalInstance(ctx).exists("where BusinessDate='"+nextPeriod+"' and city = '"+cityId+"' and EmpNumber='"+empNum+"' and CostType='yk' and (Description is null or Description!='分摊扣除业绩') ")){
					DoctorCostsFactory.getLocalInstance(ctx).delete("where BusinessDate='"+nextPeriod+"' and city = '"+cityId+"' and EmpNumber='"+empNum+"' and CostType='yk' and (Description is null or Description!='分摊扣除业绩')");	
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
				doctorCostsInfo.setIszidai(true);
				
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
				
//				if(DocAchieveUpdateFactory.getLocalInstance(ctx).exists("where BusinessDate='"+periodnum+"' and city = '"+cityId+"' and docNumber='"+empNum+"'   and  Name='分摊扣除业绩' ")){
//					DocAchieveUpdateFactory.getLocalInstance(ctx).delete("where BusinessDate='"+periodnum+"' and city = '"+cityId+"' and docNumber='"+empNum+"'   and Name='分摊扣除业绩' "); 
//				}
				
				DocAchieveUpdateInfo docAchieveUpdateThis =new DocAchieveUpdateInfo();
				docAchieveUpdateThis.setBusinessDate(periodnum); 
				ctrlUnitInfo.setId(BOSUuid.read(cityId));
				docAchieveUpdateThis.setCity(ctrlUnitInfo);
				docAchieveUpdateThis.setCityNumber(cityNumber);
				docAchieveUpdateThis.setDocNumber(empNum);
				docAchieveUpdateThis.setDocName(tempMap.get("empName").toString()); 
				docAchieveUpdateThis.setName("分摊扣除业绩");  
				docAchieveUpdateThis.setIszidai(true);
				boolean flag = false;
				if(null != allMap.get("negzz")){
					//clinicCostSumInfo.setImzzCost(clinicCostSumInfo.getImzzCost().add(allMap.get("negzz")));
					docAchieveUpdateThis.setZzAchieve(allMap.get("negzz").negate());
					imzz = imzz.add(allMap.get("negzz").negate());
					
					byzz = byzz.add(allMap.get("negzz").negate());
					
					flag = true;
				}
				if(null != allMap.get("neggdjz")){
					//clinicCostSumInfo.setImgdjzCost(clinicCostSumInfo.getImgdjzCost().add(allMap.get("neggdjz")));
					docAchieveUpdateThis.setGdjzAchieve(allMap.get("neggdjz").negate());
					imgdjz = imgdjz.add(allMap.get("neggdjz").negate());
					
					bygdjz = bygdjz.add(allMap.get("neggdjz").negate());
					flag = true;
				}
				if(null != allMap.get("negyxjz")){
					//clinicCostSumInfo.setImyxjzCost(clinicCostSumInfo.getImyxjzCost().add(allMap.get("negyxjz")));
					docAchieveUpdateThis.setYxjzAchieve(allMap.get("negyxjz").negate());
					imyxjz = imyxjz.add(allMap.get("negyxjz").negate());
					
					byyxjz = byyxjz.add(allMap.get("negyxjz").negate());
					flag = true;
				}
				if(null != allMap.get("negyz")){
					//clinicCostSumInfo.setImyzCost(clinicCostSumInfo.getImyzCost().add(allMap.get("negyz")));
					docAchieveUpdateThis.setYzAchieve(allMap.get("negyz").negate());
					imyz = imyz.add(allMap.get("neggdjz").negate());
					
					byyz = byyz.add(allMap.get("neggdjz").negate());
					flag = true;
				}
				if(null != allMap.get("negknw")){
					//clinicCostSumInfo.setImknwCost(clinicCostSumInfo.getImknwCost().add(allMap.get("negknw")));
					docAchieveUpdateThis.setKnwAchieve(allMap.get("negknw"));
					imknw = imknw.add(allMap.get("negknw").negate());
					
					byknw = byknw.add(allMap.get("negknw").negate());
					flag = true;
				}
				if(null != allMap.get("negxf")){
					//clinicCostSumInfo.setImxfCost(clinicCostSumInfo.getImxfCost().add(allMap.get("negxf")));
					docAchieveUpdateThis.setXfAchieve(allMap.get("negxf").negate());
					imxf = imxf.add(allMap.get("negxf").negate());
					
					byxf = byxf.add(allMap.get("negxf").negate());
					flag = true;
				}
				if(null != allMap.get("negey")){
					//clinicCostSumInfo.setImeyCost(clinicCostSumInfo.getImeyCost().add(allMap.get("negey")));
					docAchieveUpdateThis.setEyAchieve(allMap.get("negey").negate());
					imey = imey.add(allMap.get("negey").negate());
					
					byey = byey.add(allMap.get("negey").negate()); 
					flag = true;
				}
				if(flag){
					DocAchieveUpdateFactory.getLocalInstance(ctx).save(docAchieveUpdateThis);
				}
				
			}else{//不进行延扣     
				zzBase = zzBase.compareTo(BigDecimal.ZERO)<0?BigDecimal.ZERO:zzBase;
				gdjzBase = gdjzBase.compareTo(BigDecimal.ZERO)<0?BigDecimal.ZERO:gdjzBase;
				yxjzBase = yxjzBase.compareTo(BigDecimal.ZERO)<0?BigDecimal.ZERO:yxjzBase;
				yzBase = yzBase.compareTo(BigDecimal.ZERO)<0?BigDecimal.ZERO:yzBase;
				knwBase = knwBase.compareTo(BigDecimal.ZERO)<0?BigDecimal.ZERO:knwBase;
				
				xfBase = xfBase.compareTo(BigDecimal.ZERO)<0?BigDecimal.ZERO:xfBase;
				eyBase = eyBase.compareTo(BigDecimal.ZERO)<0?BigDecimal.ZERO:eyBase;
				
			} 

			imandxtinsertsql +=  ", CFIMZZACHIEVE , CFIMGDJZACHIEVE , cfIMyxjzachieve, CFIMyzAchieve , cfIMknwachieve , cfIMmbachieve , cfIMxfachieve, cfIMeyachieve ";
			imandxtinsertValueSql +=" ,"+imzz+" ,"+imgdjz+","+imyxjz +","+imyz+","+imknw+","+immb+","+imxf+"," + ""+imey+"  ";
			
			insertSql +=  ", CFZZACHIEVE , CFGDJZACHIEVE , cfyxjzachieve, CFZyAchieve , cfknwachieve , cfmbachieve , cfxfachieve, cfeyachieve ";
			insertValueSql +=" ,"+byzz+" ,"+bygdjz+","+byyxjz+","+byyz+","+byknw+","+bymb+","+byxf+","+byey+"  ";
			
			
			//自带患者 用减去成本 
			BigDecimal byzzMoney = zzBase.compareTo(BigDecimal.ZERO) > 0 ? zzBase.multiply(byzzbl):BigDecimal.ZERO;
			BigDecimal bygdjzMoney = gdjzBase.compareTo(BigDecimal.ZERO) > 0 ? gdjzBase.multiply(bygdjzbl):BigDecimal.ZERO;
			BigDecimal byyxjzMoney = yxjzBase.compareTo(BigDecimal.ZERO) > 0 ? yxjzBase.multiply(byyxjzbl):BigDecimal.ZERO;
			BigDecimal byyzMoney = yzBase.compareTo(BigDecimal.ZERO) > 0 ? yzBase.multiply(byyzbl):BigDecimal.ZERO;
			BigDecimal byknwMoney = knwBase.compareTo(BigDecimal.ZERO) > 0 ? knwBase.multiply(byknwbl):BigDecimal.ZERO;
			BigDecimal bymbMoney = bymb.subtract(mbcb).compareTo(BigDecimal.ZERO) > 0 ? bymb.subtract(mbcb).multiply(bymbbl):BigDecimal.ZERO;
			BigDecimal byxfMoney = xfBase.compareTo(BigDecimal.ZERO) > 0 ? xfBase.multiply(byxfbl):BigDecimal.ZERO;
			BigDecimal byeyMoney = eyBase.compareTo(BigDecimal.ZERO) > 0 ? eyBase.multiply(byeybl):BigDecimal.ZERO;
			
			
			bymoney = byzzMoney.add(bygdjzMoney).add(byyxjzMoney).add(byyzMoney).add(byknwMoney).add(bymbMoney).add(byxfMoney).add(byeyMoney)
			.setScale(2,BigDecimal.ROUND_HALF_UP);  
			
			
			clinicCostSumInfo.setAllgdjzCost(clinicCostSumInfo.getUpgdjzCost().add(clinicCostSumInfo.getImgdjzCost())); 
			clinicCostSumInfo.setAllzzCost(clinicCostSumInfo.getUpzzCost().add(clinicCostSumInfo.getImzzCost()));
			clinicCostSumInfo.setAllyxjzCost(clinicCostSumInfo.getUpyxjzCost().add(clinicCostSumInfo.getImyxjzCost()));
			//clinicCostSumInfo.setAllyzCost(clinicCostSumInfo.getUpyzCost().add(clinicCostSumInfo.getImyzCost()));
			clinicCostSumInfo.setAllknwCost(clinicCostSumInfo.getUpknwCost().add(clinicCostSumInfo.getImknwCost()));
			clinicCostSumInfo.setAllmbCost(clinicCostSumInfo.getUpmbCost().add(clinicCostSumInfo.getImmbCost()));
			clinicCostSumInfo.setAllxfCost(clinicCostSumInfo.getUpxfCost().add(clinicCostSumInfo.getImxfCost()));
			clinicCostSumInfo.setAlleyCost(clinicCostSumInfo.getUpeyCost().add(clinicCostSumInfo.getImeyCost()));
			ClinicCostSumFactory.getLocalInstance(ctx).save(clinicCostSumInfo);
			
			//
			costAll = costAll.add(clinicCostSumInfo.getAllzzCost()).add(clinicCostSumInfo.getAllgdjzCost())
			.add(clinicCostSumInfo.getAllyxjzCost()).add(clinicCostSumInfo.getAllyzCost())
			.add(clinicCostSumInfo.getAllknwCost()).add(clinicCostSumInfo.getAllmbCost())
			.add(clinicCostSumInfo.getAllxfCost()).add(clinicCostSumInfo.getAlleyCost()); 
			
			insertSql +=  ", cfzzcost , cfgdjzcost , cfyxjzcost , cfyzcost , cfknwcost , cfmbcost , cfxfcost , cfeycost  ";
			insertValueSql += " ,"+clinicCostSumInfo.getAllzzCost()+" ,"+clinicCostSumInfo.getAllgdjzCost()
				+" ,"+clinicCostSumInfo.getAllyxjzCost()+" ,"+clinicCostSumInfo.getAllyzCost() 
				+" ,"+clinicCostSumInfo.getAllknwCost()+" ,"+clinicCostSumInfo.getAllmbCost()
				+" ,"+clinicCostSumInfo.getAllxfCost()+" ,"+clinicCostSumInfo.getAlleyCost();
			
			
			clinicCostSumInfo.setAllgdjzCost(clinicCostSumInfo.getUpgdjzCost().add(clinicCostSumInfo.getImgdjzCost())); 
			clinicCostSumInfo.setAllzzCost(clinicCostSumInfo.getUpzzCost().add(clinicCostSumInfo.getImzzCost()));
			clinicCostSumInfo.setAllyxjzCost(clinicCostSumInfo.getUpyxjzCost().add(clinicCostSumInfo.getImyxjzCost()));
			clinicCostSumInfo.setAllyzCost(clinicCostSumInfo.getUpyzCost().add(clinicCostSumInfo.getImyzCost()));
			clinicCostSumInfo.setAllknwCost(clinicCostSumInfo.getUpknwCost().add(clinicCostSumInfo.getImknwCost()));
			clinicCostSumInfo.setAllmbCost(clinicCostSumInfo.getUpmbCost().add(clinicCostSumInfo.getImmbCost()));
			clinicCostSumInfo.setAllxfCost(clinicCostSumInfo.getUpxfCost().add(clinicCostSumInfo.getImxfCost()));
			clinicCostSumInfo.setAlleyCost(clinicCostSumInfo.getUpeyCost().add(clinicCostSumInfo.getImeyCost()));
			ClinicCostSumFactory.getLocalInstance(ctx).save(clinicCostSumInfo);
			BigDecimal cost = clinicCostSumInfo.getAllgdjzCost().add(clinicCostSumInfo.getAllzzCost()).add(clinicCostSumInfo.getAllyxjzCost())
				.add(clinicCostSumInfo.getAllyzCost()).add(clinicCostSumInfo.getAllknwCost()).add(clinicCostSumInfo.getAllmbCost())
				.add(clinicCostSumInfo.getAllxfCost()).add(clinicCostSumInfo.getAlleyCost());
			//
			BigDecimal sumAchieve =  byzz.add(bygdjz).add(byyxjz).add(byyz).add(byknw).add(bymb).add(byxf).add(byey);   
			insertSql += ",cfsumachieve, CFZZmoney, CFGDJZmoney, CFYXJZmoney, CFYZmoney, CFKNWmoney, CFMBmoney, CFXFmoney, CFEYmoney ";
			insertValueSql += ","+sumAchieve+" ,"+bymoney+", "+byzzMoney+" ,"+bygdjzMoney+","+byyxjzMoney+" " +
				" ,"+byyzMoney+" ,"+byknwMoney+" ,"+bymbMoney+" "+
				" ,"+byxfMoney+" ,"+byeyMoney+" ";
			
			
			BigDecimal allBase = zzBase.add(gdjzBase).add(yxjzBase).add(yzBase).add(knwBase).add(xfBase).add(eyBase);
			insertSql +=  ", CFZZpro , CFGDpro , cfyxpro, CFyzpro , cfknwpro , cfmbpro , cfxfpro, cfeypro  ";
			insertValueSql +=" ,"+zzBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP)+" ,"+gdjzBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP)+
			","+yxjzBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP)+","+yzBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP)+
			","+knwBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP)+","+0+
			","+xfBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP)+","+ eyBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP)+" ";
			
			StringBuffer sbr2  = new StringBuffer(" /*dialect*/insert into CT_PAY_ClinicAchieveCosthSum (FID,FCreatorID,FCreateTime,FLastUpdateUserID,FLastUpdateTime, ");
			sbr2.append(" cfposttype , cfbusinessdate, CFCLINICNUMBER,CFCLINICName,cfempnumber,cfempname,CFCITYNUMBER,CFCITYName,CFJyCount, CFPlaCount , CFWhiteAchieve  "+insertSql+" "+imandxtinsertsql+",cfiszidai  ) ");
    		sbr2.append("values(newbosid('20D1E187'),'"+userId+"',sysdate,'"+userId+"',sysdate, ");
    		sbr2.append(" 'JZYS', '"+periodnum+"','"+clinicNumber+"','' ,'"+empNum+"','"+tempMap.get("empName").toString()+"','"+cityNumber+"','"+tempMap.get("cityName").toString()+"' ,"+0+" ,"+0+" ,"+0+"  "+insertValueSql+" "+imandxtinsertValueSql+",1 )");  
    		pe.getSqlList().add(sbr2);
    		
    		//StringBuffer sbr3  = new StringBuffer(" /*dialect*/insert into CT_PAY_ClinicAchieveCosthInit (FID,FCreatorID,FCreateTime,FLastUpdateUserID,FLastUpdateTime, ");
    		/*sbr3.append(" cfposttype , cfbusinessdate, CFCLINICNUMBER,CFCLINICName,cfempnumber,cfempname,CFCITYNUMBER,CFCITYName,CFJyCount, CFPlaCount , CFWhiteAchieve  "+insertSql+" ) ");
    		sbr3.append("values(newbosid('F965A954'),'"+userId+"',sysdate,'"+userId+"',sysdate, ");
    		sbr3.append(" 'JZYS', '"+periodnum+"','"+clinicNumber+"','' ,'"+empNum+"','"+tempMap.get("empName").toString()+"','"+cityNumber+"','"+tempMap.get("cityName").toString()+"' ,"+0+" ,"+0+" ,"+0+"  "+insertValueSql+")");  
    		pe.getSqlList().add(sbr3);*/
    		
    		pe.executeUpdate(ctx);
			pool.shutdown();   
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			pool.shutdown(); 
		}
		
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
		.append(" FROM  CT_PAY_DocAchieveUpdate where cfcityid = '"+cityId+"' and  cfiszidai = 1 and cfdocnumber = '"+empNum+"' and  cfbusinessdate = '"+periodnum+"' and  fname_l2 is null ");
		  
		return sqlYJ;
	}
}
