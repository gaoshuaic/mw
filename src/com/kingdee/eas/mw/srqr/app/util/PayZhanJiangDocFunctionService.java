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

public class PayZhanJiangDocFunctionService {

	private Logger log;
	public PayZhanJiangDocFunctionService() {
		this.log = LoggerFactory.getLogger(PayZhanJiangDocFunctionService.class);
	}
	/**
	 * ��ȡҽ������
	 */
	public HashMap<String,Object>  getDocBonus(Context ctx,String empNum, String clinicNumber,String periodnum,HashMap tempMap,String cityId,String cityNumber,String type , String calType){
		//Context ctx = Tools.getInstance().getCtx(); 
		//ֻ����ͨҽ������ҽ��
		HashMap<String,Object>  docMap = new HashMap<String,Object>();
		String insertSql =  "";
		String insertValueSql = "";
		
		String imandxtinsertsql = "";
		String imandxtinsertValueSql = "";
		double money = 0.0D;
		if(empNum == null || empNum.equals("")){
			this.log.error("Ա�����벻��Ϊ��");
			return null;
		}else if(periodnum == null || periodnum.equals("")){
			this.log.error("�ڼ䲻��Ϊ��");
			return null;
		}
		try{  
			BigDecimal costAll = BigDecimal.ZERO; 
			
			//ҽ������ҵ��
			BigDecimal docBase = BigDecimal.ZERO; 

			//��ֲ����
			BigDecimal zzbi = BigDecimal.ZERO; 
			//�̶���������
			BigDecimal gdjzbi = BigDecimal.ZERO; 
			//���ν�������
			BigDecimal yxjzbi = BigDecimal.ZERO; 
			//���ܱ���
			BigDecimal yzbi = BigDecimal.ZERO; 
			//���������
			BigDecimal knwbi = BigDecimal.ZERO; 
			//���ױ���
			BigDecimal mbbi = BigDecimal.ZERO; 
			//�޸�����
			BigDecimal xfbi = BigDecimal.ZERO; 
			//��������
			BigDecimal eybi = BigDecimal.ZERO; 
		
			
			//------------�˴������ֱ���ǽ�����
			//������ֲ
			BigDecimal imzz = BigDecimal.ZERO; 
			//����̶�����
			BigDecimal imgdjz = BigDecimal.ZERO; 
			//�������ν���
			BigDecimal imyxjz = BigDecimal.ZERO; 
			//��������
			BigDecimal imyz = BigDecimal.ZERO; 
			//���������
			BigDecimal imknw = BigDecimal.ZERO; 
			//��������
			BigDecimal immb = BigDecimal.ZERO; 
			//�����޸�
			BigDecimal imxf = BigDecimal.ZERO; 
			//�������
			BigDecimal imey = BigDecimal.ZERO; 
			
			
			//��ֲ
			BigDecimal zz = BigDecimal.ZERO; 
			//�̶�����
			BigDecimal gdjz = BigDecimal.ZERO; 
			//���ν���
			BigDecimal yxjz = BigDecimal.ZERO; 
			//����
			BigDecimal yz = BigDecimal.ZERO; 
			//������
			BigDecimal knw = BigDecimal.ZERO; 
			//����
			BigDecimal mb = BigDecimal.ZERO; 
			//�޸�
			BigDecimal xf = BigDecimal.ZERO; 
			//����
			BigDecimal ey = BigDecimal.ZERO;  
			//��ֲ�ɱ�
			BigDecimal zzcb = BigDecimal.ZERO; 
			//�̶������ɱ�
			BigDecimal gdjzcb = BigDecimal.ZERO; 
			//���ν����ɱ�
			BigDecimal yxjzcb = BigDecimal.ZERO; 
			//���ܳɱ�
			BigDecimal yzcb = BigDecimal.ZERO; 
			//������ɱ�
			BigDecimal knwcb = BigDecimal.ZERO; 
			//���׳ɱ�
			BigDecimal mbcb = BigDecimal.ZERO; 
			//�޸��ɱ�
			BigDecimal xfcb = BigDecimal.ZERO; 
			//�����ɱ�
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
			//��ͨҽ��
			if((null == tempMap) || (null == tempMap.get(empNum+"_DOC"))){
				
			}else{
				HashMap map = new HashMap();
				
				map = (HashMap) tempMap.get(empNum+"_"+"TL_DOC");
				
				if (map == null || map.get("CFPERFORMANCEBASE")== null){
					return docMap;
				}
				docMap.put("postType", "YS");
				//ҽ������ҵ��
				docBase = new BigDecimal(map.get("CFPERFORMANCEBASE").toString());  
				
				//ȡҽ��ҵ������ı���
				zzbi = new BigDecimal(map.get("CFZZPROPORTION").toString());
				gdjzbi = new BigDecimal(map.get("CFGDPROPORTION").toString());
				yxjzbi = new BigDecimal(map.get("CFYXPROPORTION").toString());
				yzbi = new BigDecimal(map.get("CFZBPROPORTION").toString());//?
				knwbi = new BigDecimal(map.get("CFKNPROPORTION").toString());
				mbbi = new BigDecimal(map.get("CFMBPROPORTION").toString());
				xfbi = new BigDecimal(map.get("CFXFPROPORTION").toString());
				eybi = new BigDecimal(map.get("CFEYPROPORTION").toString());  
				 
				
				biliMap.put("zz",zzbi );
				biliMap.put("gdjz",gdjzbi );
				biliMap.put("yxjz",yxjzbi );
				biliMap.put("yz",yzbi );
				biliMap.put("knw",knwbi );
				biliMap.put("mb",mbbi );
				biliMap.put("xf",xfbi );
				biliMap.put("ey",eybi ); 
				  
				//��ѯҽ����ҵ��  
				StringBuffer sqlYJ = new StringBuffer(); 
			  	sqlYJ = getYeJiSql( empNum,  cityNumber, periodnum, cityId,sqlYJ ,type);
			  	System.out.println("--"+sqlYJ);
			  	IRowSet yjrs = com.kingdee.eas.custom.util.DBUtil.executeQuery(ctx,sqlYJ.toString());
			  	if(yjrs!=null && yjrs.size() > 0){ 
				  	while(yjrs.next()){	
				  		if("zz".equals(yjrs.getString("TYPE"))){//��ֲ
				  			zz = zz.add(new BigDecimal(yjrs.getString("SUMM"))); 
				  		}else if("gdjz".equals(yjrs.getString("TYPE"))){//�̶����� ��
				  			gdjz= gdjz.add(new BigDecimal(yjrs.getString("SUMM"))); 
				  		}else if("yxjz".equals(yjrs.getString("TYPE"))){//���ν���
				  			yxjz= yxjz.add(new BigDecimal(yjrs.getString("SUMM"))); 
				  		}else if("yz".equals(yjrs.getString("TYPE"))){//���� ��
				  			yz= yz.add(new BigDecimal(yjrs.getString("SUMM"))); 
				  		}else if("knw".equals(yjrs.getString("TYPE"))){//������ ��
				  			knw = knw.add(new BigDecimal(yjrs.getString("SUMM")));
				  		}else if("mb".equals(yjrs.getString("TYPE"))){//����
				  			mb= mb.add(new BigDecimal(yjrs.getString("SUMM"))); 
				  		}else if("xf".equals(yjrs.getString("TYPE"))){//�޸�
				  			xf= xf.add(new BigDecimal(yjrs.getString("SUMM")));  
				  		}else if("ey".equals(yjrs.getString("TYPE"))){//����
				  			ey= ey.add(new BigDecimal(yjrs.getString("SUMM"))); 
				  		} 
					}
				} 	
				
				imandxtinsertsql +=  ", CFXTZZACHIEVE , CFXTGDJZACHIEVE , cfXTyxjzachieve, CFXTyzAchieve , cfXTknwachieve , cfXTmbachieve , cfXTxfachieve, cfXTeyachieve ";
				imandxtinsertValueSql +=" ,"+zz+" ,"+gdjz+","+yxjz+","+yz+","+knw+","+mb+","+xf+","+ey+"  ";
				 
				BigDecimal zzMoney = BigDecimal.ZERO;
				BigDecimal gdjzMoney = BigDecimal.ZERO;
				BigDecimal yxjzMoney = BigDecimal.ZERO;
				BigDecimal yzMoney = BigDecimal.ZERO;
				BigDecimal knwMoney = BigDecimal.ZERO;
				BigDecimal mbMoney = BigDecimal.ZERO;
				BigDecimal xfMoney = BigDecimal.ZERO;
				BigDecimal eyMoney = BigDecimal.ZERO;
				BigDecimal buchaMoney = BigDecimal.ZERO;
				StringBuffer sqlImportYJ = new StringBuffer(); 
				sqlImportYJ = getYeJiImpSql( empNum,  cityNumber, periodnum, sqlImportYJ, cityId);
				System.out.println("--"+sqlImportYJ);
				IRowSet yjImprs = com.kingdee.eas.custom.util.DBUtil.executeQuery(ctx,sqlImportYJ.toString());
				if(yjImprs!=null && yjImprs.size() > 0){ 
				  	while(yjImprs.next()){	
				  		zzMoney = new BigDecimal(yjImprs.getString("ZZ")); 
				  		gdjzMoney= new BigDecimal(yjImprs.getString("GDJZ")); 
				  		yxjzMoney= new BigDecimal(yjImprs.getString("YXJZ")); 
				  		yzMoney= new BigDecimal(yjImprs.getString("YZ")); 
				  		knwMoney = new BigDecimal(yjImprs.getString("KNW"));
				  		mbMoney=new BigDecimal(yjImprs.getString("MB")); 
				  		xfMoney= new BigDecimal(yjImprs.getString("XF"));  
				  		eyMoney= new BigDecimal(yjImprs.getString("EY"));   
				  		buchaMoney= new BigDecimal(yjImprs.getString("JZ"));   
					} 
				} 
				
			    //��� ����ĳɱ�
				StringBuffer sqlImportCB = new StringBuffer(); 
				sqlImportCB = getImportChengBenSql( empNum,  cityId, periodnum, sqlImportCB);
				IRowSet imporytbrs = com.kingdee.eas.custom.util.DBUtil.executeQuery(ctx,sqlImportCB.toString());
				if(imporytbrs!=null && imporytbrs.size() > 0){
					  while(imporytbrs.next()){	
						  if("zz".equals(imporytbrs.getString("TYPE"))){//��ֲ
							  zzcb =new BigDecimal(imporytbrs.getString("SUMM")); 
							  //costAll = costAll.add(zzcb);
							   
							  clinicCostSumInfo.setImzzCost(zzcb);
						  }else if("gdjz".equals(imporytbrs.getString("TYPE"))){//�̶�����
							  gdjzcb=new BigDecimal(imporytbrs.getString("SUMM")); 
							  //costAll = costAll.add(gdjzcb);
							   
							  clinicCostSumInfo.setImgdjzCost(gdjzcb);
						  }else if("yxjz".equals(imporytbrs.getString("TYPE"))){//���ν���
							  yxjzcb=new BigDecimal(imporytbrs.getString("SUMM")); 
							  //costAll = costAll.add(yxjzcb);
							   
							  clinicCostSumInfo.setImyxjzCost(yxjzcb);
						  }else if("yz".equals(imporytbrs.getString("TYPE"))){//����
							  yzcb=new BigDecimal(imporytbrs.getString("SUMM")); 
							  //costAll = costAll.add(yzcb);
							   
							  clinicCostSumInfo.setImyzCost(yzcb);
						  }else if("knw".equals(imporytbrs.getString("TYPE"))){//������
							  knwcb =new BigDecimal(imporytbrs.getString("SUMM"));
							  //costAll = costAll.add(knwcb);
							   
							  clinicCostSumInfo.setImknwCost(knwcb);
						  }else if("mb".equals(imporytbrs.getString("TYPE"))){//����
							  mbcb=new BigDecimal(imporytbrs.getString("SUMM")); 
							  //costAll = costAll.add(mbcb); 
							  
							  clinicCostSumInfo.setImmbCost(mbcb);
						  }else if("xf".equals(imporytbrs.getString("TYPE"))){//�޸�
							  xfcb=new BigDecimal(imporytbrs.getString("SUMM")); 
							  //costAll = costAll.add(xfcb);
							   
							  clinicCostSumInfo.setImxfCost(xfcb);
						  }else if("ey".equals(imporytbrs.getString("TYPE"))){//����
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
				
				//��� ��ʿ�����ĳɱ�
				StringBuffer sqlHushiCB = new StringBuffer(); 
				sqlHushiCB = getHushiChengBenSql( empNum,  cityNumber, periodnum, sqlHushiCB);
				IRowSet hushiCBrs = com.kingdee.eas.custom.util.DBUtil.executeQuery(ctx,sqlHushiCB.toString());
				if(hushiCBrs!=null && hushiCBrs.size() > 0){
					 while(hushiCBrs.next()){	
						  if("zz".equals(hushiCBrs.getString("TYPE"))){//��ֲ
							  zzcb = zzcb.add(new BigDecimal(hushiCBrs.getString("SUMM"))); 
							  //costAll = costAll.add(new BigDecimal(hushiCBrs.getString("SUMM"))); 
							  clinicCostSumInfo.setUpzzCost(new BigDecimal(hushiCBrs.getString("SUMM")));
						  }else if("gdjz".equals(hushiCBrs.getString("TYPE"))){//�̶�����
							  gdjzcb = gdjzcb.add(new BigDecimal(hushiCBrs.getString("SUMM"))); 
							  //costAll = costAll.add(new BigDecimal(hushiCBrs.getString("SUMM")));
							    
							  clinicCostSumInfo.setUpgdjzCost(new BigDecimal(hushiCBrs.getString("SUMM")));
						  }else if("yxjz".equals(hushiCBrs.getString("TYPE"))){//���ν���
							  yxjzcb = yxjzcb.add(new BigDecimal(hushiCBrs.getString("SUMM"))); 
							  //costAll = costAll.add(new BigDecimal(hushiCBrs.getString("SUMM"))); 
							  
							  clinicCostSumInfo.setUpyxjzCost(new BigDecimal(hushiCBrs.getString("SUMM")));
						  }else if("yz".equals(hushiCBrs.getString("TYPE"))){//����
							  yzcb = yzcb.add(new BigDecimal(hushiCBrs.getString("SUMM"))); 
							  //costAll = costAll.add(new BigDecimal(hushiCBrs.getString("SUMM"))); 
							  
							  clinicCostSumInfo.setUpyzCost(new BigDecimal(hushiCBrs.getString("SUMM")));
						  }else if("knw".equals(hushiCBrs.getString("TYPE"))){//������
							  knwcb = knwcb.add(new BigDecimal(hushiCBrs.getString("SUMM")));
							  //costAll = costAll.add(new BigDecimal(hushiCBrs.getString("SUMM"))); 
							  
							  clinicCostSumInfo.setUpknwCost(new BigDecimal(hushiCBrs.getString("SUMM")));
						  }else if("mb".equals(hushiCBrs.getString("TYPE"))){//����
							  mbcb = mbcb.add(new BigDecimal(hushiCBrs.getString("SUMM"))); 
							  //costAll = costAll.add(new BigDecimal(hushiCBrs.getString("SUMM")));  
							  
							  clinicCostSumInfo.setUpmbCost(new BigDecimal(hushiCBrs.getString("SUMM")));
						  }else if("xf".equals(hushiCBrs.getString("TYPE"))){//�޸�
							  xfcb = xfcb.add(new BigDecimal(hushiCBrs.getString("SUMM"))); 
							  //costAll = costAll.add(new BigDecimal(hushiCBrs.getString("SUMM"))); 
							  
							  clinicCostSumInfo.setUpxfCost(new BigDecimal(hushiCBrs.getString("SUMM")));
						  }else if("ey".equals(hushiCBrs.getString("TYPE"))){//����
							  eycb = eycb.add(new BigDecimal(hushiCBrs.getString("SUMM"))); 
							  //costAll = costAll.add(new BigDecimal(hushiCBrs.getString("SUMM")));  
							  
							  clinicCostSumInfo.setUpeyCost(new BigDecimal(hushiCBrs.getString("SUMM")));
						  }   
					  }
				} 
				//������۳���ĳɱ�
				StringBuffer sqlCB = new StringBuffer();
				sqlCB = getChengBenSql( empNum,  cityNumber, periodnum, sqlCB);
				IRowSet cbrs = com.kingdee.eas.custom.util.DBUtil.executeQuery(ctx,sqlCB.toString());
				if(cbrs!=null && cbrs.size() > 0){
					  while(cbrs.next()){	
						  if("zz".equals(cbrs.getString("TYPE"))){//��ֲ
							  zzcb = zzcb.add(new BigDecimal(cbrs.getString("SUMM"))); 
							  //costAll = costAll.add(new BigDecimal(cbrs.getString("SUMM"))); 

							  clinicCostSumInfo.setZzCost(new BigDecimal(cbrs.getString("SUMM")));
						  }else if("gdjz".equals(cbrs.getString("TYPE"))){//�̶�����
							  gdjzcb = gdjzcb.add(new BigDecimal(cbrs.getString("SUMM"))); 
							  //costAll = costAll.add(new BigDecimal(cbrs.getString("SUMM"))); 
							  
							  clinicCostSumInfo.setGdjzCost(new BigDecimal(cbrs.getString("SUMM")));
						  }else if("yxjz".equals(cbrs.getString("TYPE"))){//���ν���
							  yxjzcb = yxjzcb.add(new BigDecimal(cbrs.getString("SUMM"))); 
							  //costAll = costAll.add(new BigDecimal(cbrs.getString("SUMM"))); 
							  
							  clinicCostSumInfo.setYxjzCost(new BigDecimal(cbrs.getString("SUMM")));
						  }else if("yz".equals(cbrs.getString("TYPE"))){//����
							  yzcb = yzcb.add(new BigDecimal(cbrs.getString("SUMM"))); 
							  //costAll = costAll.add(new BigDecimal(cbrs.getString("SUMM"))); 
							  
							  clinicCostSumInfo.setYzCost(new BigDecimal(cbrs.getString("SUMM")));
						  }else if("knw".equals(cbrs.getString("TYPE"))){//������
							  knwcb = knwcb.add(new BigDecimal(cbrs.getString("SUMM")));
							  //costAll = costAll.add(new BigDecimal(cbrs.getString("SUMM"))); 
							  
							  clinicCostSumInfo.setKnwCost(new BigDecimal(cbrs.getString("SUMM")));
						  }else if("mb".equals(cbrs.getString("TYPE"))){//����
							  mbcb = mbcb.add(new BigDecimal(cbrs.getString("SUMM"))); 
							  //costAll = costAll.add(new BigDecimal(cbrs.getString("SUMM"))); 
							  
							  clinicCostSumInfo.setMbCost(new BigDecimal(cbrs.getString("SUMM")));
						  }else if("xf".equals(cbrs.getString("TYPE"))){//�޸�
							  xfcb = xfcb.add(new BigDecimal(cbrs.getString("SUMM"))); 
							  //costAll = costAll.add(new BigDecimal(cbrs.getString("SUMM"))); 
							  
							  clinicCostSumInfo.setXfCost(new BigDecimal(cbrs.getString("SUMM")));
						  }else if("ey".equals(cbrs.getString("TYPE"))){//����
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
				
				zzBase = zz.subtract(zzcb).compareTo(BigDecimal.ZERO)<0?BigDecimal.ZERO:zz.subtract(zzcb);
				gdjzBase = gdjz.subtract(gdjzcb).compareTo(BigDecimal.ZERO)<0?BigDecimal.ZERO:gdjz.subtract(gdjzcb);
				yxjzBase = yxjz.subtract(yxjzcb).compareTo(BigDecimal.ZERO)<0?BigDecimal.ZERO:yxjz.subtract(yxjzcb);
				yzBase = yz.subtract(yzcb).compareTo(BigDecimal.ZERO)<0?BigDecimal.ZERO:yz.subtract(yzcb);
				knwBase = knw.subtract(knwcb).compareTo(BigDecimal.ZERO)<0?BigDecimal.ZERO:knw.subtract(knwcb);
				//BigDecimal mbBase = mb.subtract(mbcb).compareTo(BigDecimal.ZERO)<0?BigDecimal.ZERO:mb.subtract(mbcb);
				xfBase = xf.subtract(xfcb).compareTo(BigDecimal.ZERO)<0?BigDecimal.ZERO:xf.subtract(xfcb);
				eyBase = ey.subtract(eycb).compareTo(BigDecimal.ZERO)<0?BigDecimal.ZERO:ey.subtract(eycb);
				
				
				BigDecimal sumAchieve =  zz.add(gdjz).add(yxjz).add(yz).add(knw).add(mb).add(xf).add(ey);
				
				imandxtinsertsql +=  ", CFIMZZACHIEVE , CFIMGDJZACHIEVE , cfIMyxjzachieve, CFIMyzAchieve , cfIMknwachieve , cfIMmbachieve , cfIMxfachieve, cfIMeyachieve ";
				imandxtinsertValueSql +=" ,"+imzz+" ,"+imgdjz+","+imyxjz +","+imyz+","+imknw+","+immb+","+imxf+"," + ""+imey+"  ";
				
				insertSql +=  ", CFZZACHIEVE , CFGDJZACHIEVE , cfyxjzachieve, CFZyAchieve , cfknwachieve , cfmbachieve , cfxfachieve, cfeyachieve ";
				insertValueSql +=" ,"+zz+" ,"+gdjz+","+yxjz+","+yz+","+knw+","+mb+","+xf+","+ey+"  ";
				
				 
				
				 
				BigDecimal allBase = zzBase.add(gdjzBase).add(yxjzBase).add(yzBase).add(knwBase).add(xfBase).add(eyBase);
				if(allBase.compareTo(BigDecimal.ZERO) <=0 ){
					allBase = new BigDecimal("1");
				} 
				/*BigDecimal zzMoney = BigDecimal.ZERO;
				BigDecimal gdjzMoney = BigDecimal.ZERO;
				BigDecimal yxjzMoney = BigDecimal.ZERO;
				BigDecimal yzMoney = BigDecimal.ZERO;
				BigDecimal knwMoney = BigDecimal.ZERO;
				BigDecimal mbMoney = BigDecimal.ZERO;
				BigDecimal xfMoney = BigDecimal.ZERO;
				BigDecimal eyMoney = BigDecimal.ZERO;*/
				/*if(allBase.compareTo(BigDecimal.ZERO) <=0 ){
					
				}else{
					zzMoney = zzBase.subtract(docBase.multiply(zzBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP))).compareTo(BigDecimal.ZERO) > 0 ? zzBase.subtract(docBase.multiply(zzBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP))).multiply(zzbi):BigDecimal.ZERO;
					gdjzMoney = gdjzBase.subtract(docBase.multiply(gdjzBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP))).compareTo(BigDecimal.ZERO) > 0 ? gdjzBase.subtract(docBase.multiply(gdjzBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP))).multiply(gdjzbi):BigDecimal.ZERO;
					yxjzMoney = yxjzBase.subtract(docBase.multiply(yxjzBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP))).compareTo(BigDecimal.ZERO) > 0 ? yxjzBase.subtract(docBase.multiply(yxjzBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP))).multiply(yxjzbi):BigDecimal.ZERO;
					yzMoney = yzBase.subtract(docBase.multiply(yzBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP))).compareTo(BigDecimal.ZERO) > 0 ? yzBase.subtract(docBase.multiply(yzBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP))).multiply(yzbi):BigDecimal.ZERO;
					knwMoney = knwBase.subtract(docBase.multiply(knwBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP))).compareTo(BigDecimal.ZERO) > 0 ? knwBase.subtract(docBase.multiply(knwBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP))).multiply(knwbi):BigDecimal.ZERO;
					//BigDecimal mbMoney = mb.subtract(mbcb).subtract(docBase.multiply(mbBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP))).compareTo(BigDecimal.ZERO) > 0 ? mb.subtract(mbcb).subtract(docBase.multiply(mbBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP))).multiply(mbbi):BigDecimal.ZERO;
					
					xfMoney = xfBase.subtract(docBase.multiply(xfBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP))).compareTo(BigDecimal.ZERO) > 0 ? xfBase.subtract(docBase.multiply(xfBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP))).multiply(xfbi):BigDecimal.ZERO;
					eyMoney = eyBase.subtract(docBase.multiply(eyBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP))).compareTo(BigDecimal.ZERO) > 0 ? eyBase.subtract(docBase.multiply(eyBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP))).multiply(eybi):BigDecimal.ZERO;
					
				}*/


				
				
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
				
				 
				
				
				mbMoney = mb.subtract(mbcb).compareTo(BigDecimal.ZERO) > 0 ? mb.subtract(mbcb).multiply(mbbi):mb.subtract(mbcb).multiply(mbbi);
				//money = zzMoney.add(gdjzMoney).add(yxjzMoney).add(yzMoney).add(knwMoney).add(mbMoney).add(xfMoney).add(eyMoney).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
				money = zzMoney.add(gdjzMoney).add(yxjzMoney).add(yzMoney).add(knwMoney).add(xfMoney).add(eyMoney).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
				
				
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
				
				
				
				
				insertSql += ",cfsumachieve, CFZZmoney, CFGDJZmoney, CFYXJZmoney, CFYZmoney, CFKNWmoney, CFMBmoney, CFXFmoney, CFEYmoney ";
				insertValueSql += " ,"+sumAchieve+", "+zzMoney+" ,"+gdjzMoney+","+yxjzMoney+" " +
					" ,"+yzMoney+" ,"+knwMoney+" ,"+mbMoney+" "+
					" ,"+xfMoney+" ,"+eyMoney+" ";
				docMap.put("EXISTS", "NO");
				docMap.put("JIANGJIN", money+"");
				docMap.put("mbMoney", mbMoney+"");
				docMap.put("COST", costAll.toString());
				
					  
			} 
			docMap.put("INSERTSQL",insertSql);
			docMap.put("INSERTVALUESQL",insertValueSql); 
			
			docMap.put("imandxtinsertsql",imandxtinsertsql);
			docMap.put("imandxtinsertValueSql",imandxtinsertValueSql);  
			
			ClinicCostSumFactory.getLocalInstance(ctx).save(clinicCostSumInfo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.log.error("ϵͳ�����쳣������ϵ����Ա");
		}   
		
		
		return docMap;
	}
	
	public StringBuffer getYeJiImpSql(String empNum, String cityNumber,String periodnum,StringBuffer sqlYJ,String cityId){
		//��ֲ   and CFClinicNumber='"+clinicNumber+"'
		sqlYJ.append("  /*dialect*/ SELECT  nvl( sum(cfzzachieve),0) as ZZ , nvl(sum(cfyxjzachieve),0) as YXJZ , nvl(sum(cfgdjzachieve),0) as GDJZ , nvl(sum(cfknwachieve),0) as KNW , nvl(sum(cfxfachieve),0) as XF , nvl(sum(cfeyachieve),0) as EY , nvl(sum(cfyzachieve),0) as YZ , nvl(sum(cfmbachieve),0) as MB , nvl(sum(cfjzmoney),0) as JZ   ")
		.append(" FROM  CT_PAY_DocAchieveUpdate where cfcityid = '"+cityId+"' and ( cfiszidai = 0 or cfiszidai is null) and cfdocnumber  ='"+empNum+"'  and  cfbusinessdate = '"+periodnum+"' and  fname_l2 is null ");
		 
		return sqlYJ;
	}

	
	/**
	 * ͳ��ҽ����ҵ��
	 * @param empNum
	 * @param clinicNumber
	 * @param periodnum
	 * @param sqlYJ
	 * @return
	 */

	public StringBuffer getYeJiSql(String empNum, String cityNumber,String periodnum,String cityId,StringBuffer sqlYJ ,String type){
		String dateSql = "";
		if(type.equals("ZC")){
			dateSql = "  to_char(fbizdate, 'yyyymm') = '"+periodnum+"' and  ";
		}else if(type.equals("CBQR")){
			dateSql = "  CFBUSINESSDATE = '"+periodnum+"' and  (cfisneedout = 0 or ( cfisneedout=1 and cfisout = 1))  and  ";
		} 
		//��ֲ   and CFClinicNumber='"+clinicNumber+"'
		sqlYJ.append("  /*dialect*/ select aa.summ,'zz' as type from ( ");
		sqlYJ.append(" select sum(a.allm) as summ from ( ");
		sqlYJ.append(" SELECT nvl(sum(CFINCOME),0) as allm FROM  CT_PAY_AchieveDetailTem  where    "+dateSql+"  cfiscount = 1 and  CFRecDotNumber ='"+empNum+"'  and CFCityNumber='"+cityNumber+"'  and (EXISTS (SELECT  1 FROM  CT_SRQ_ItemCheck bill inner join  CT_SRQ_ItemCheckentry entry on   bill.fid = entry.fparentid  left JOIN  CT_SRQ_Paytypecategory  item on  item.fid = entry.cffirstitemid  where  bill.cftypenumber = 'ZZ' and bill.cfcityid = '"+cityId+"' and  CT_PAY_AchieveDetailTem.CFFirClassNumber = item.fnumber ) or  EXISTS (SELECT  1 FROM  CT_SRQ_ItemCheck bill inner join  CT_SRQ_ItemCheckentry entry on   bill.fid = entry.fparentid  left JOIN  CT_SRQ_Paytypeitem item on  item.fid = entry.cfseconditemid  where  bill.cftypenumber = 'ZZ' and bill.cfcityid = '"+cityId+"' and  CT_PAY_AchieveDetailTem.CFSecClassnumber = item.fnumber ) or  EXISTS (SELECT  1 FROM  CT_SRQ_ItemCheck bill inner join  CT_SRQ_ItemCheckentry entry on   bill.fid = entry.fparentid  left JOIN  CT_SRQ_PayItem  item on  item.fid = entry.cfitemid  where  bill.cftypenumber = 'ZZ' and bill.cfcityid = '"+cityId+"' and  CT_PAY_AchieveDetailTem.cffeeitemdetailNUMBER = item.fnumber ) )  ");
		sqlYJ.append(" ) a ) aa ");
		sqlYJ.append(" union ");
		//�̶�����
		sqlYJ.append(" select bb.summ,'gdjz' as type from (select sum(b.allm) as summ from (");
		sqlYJ.append(" SELECT nvl(sum(CFINCOME),0) as allm FROM  CT_PAY_AchieveDetailTem  where     "+dateSql+"    cfiscount = 1 and   CFIsRoutine='��' and   CFRecDotNumber ='"+empNum+"' and CFCityNumber='"+cityNumber+"' and ( EXISTS (SELECT  1 FROM  CT_SRQ_ItemCheck bill inner join  CT_SRQ_ItemCheckentry entry on   bill.fid = entry.fparentid  left JOIN  CT_SRQ_Paytypecategory  item on  item.fid = entry.cffirstitemid  where  bill.cftypenumber = 'GD' and bill.cfcityid = '"+cityId+"' and  CT_PAY_AchieveDetailTem.CFFirClassNumber = item.fnumber ) or  EXISTS (SELECT  1 FROM  CT_SRQ_ItemCheck bill inner join  CT_SRQ_ItemCheckentry entry on   bill.fid = entry.fparentid  left JOIN  CT_SRQ_Paytypeitem item on  item.fid = entry.cfseconditemid  where  bill.cftypenumber = 'GD' and bill.cfcityid = '"+cityId+"' and  CT_PAY_AchieveDetailTem.CFSecClassnumber = item.fnumber ) or  EXISTS (SELECT  1 FROM  CT_SRQ_ItemCheck bill inner join  CT_SRQ_ItemCheckentry entry on   bill.fid = entry.fparentid  left JOIN  CT_SRQ_PayItem  item on  item.fid = entry.cfitemid  where  bill.cftypenumber = 'GD' and bill.cfcityid = '"+cityId+"' and  CT_PAY_AchieveDetailTem.cffeeitemdetailNUMBER = item.fnumber ) ) ");
		sqlYJ.append(" ) b) bb ");
		sqlYJ.append(" union ");
		//���ν���
		sqlYJ.append(" select cc.summ,'yxjz' as type from (select sum(c.allm) as summ from ( ");
		sqlYJ.append(" SELECT nvl(sum(CFINCOME),0) as allm FROM  CT_PAY_AchieveDetailTem  where    "+dateSql+"   cfiscount = 1 and  CFIsRoutine='��' and   CFRecDotNumber ='"+empNum+"'  and CFCityNumber='"+cityNumber+"' and ( EXISTS (SELECT  1 FROM  CT_SRQ_ItemCheck bill inner join  CT_SRQ_ItemCheckentry entry on   bill.fid = entry.fparentid  left JOIN  CT_SRQ_Paytypecategory  item on  item.fid = entry.cffirstitemid  where  bill.cftypenumber = 'YX' and bill.cfcityid = '"+cityId+"' and  CT_PAY_AchieveDetailTem.CFFirClassNumber = item.fnumber ) or  EXISTS (SELECT  1 FROM  CT_SRQ_ItemCheck bill inner join  CT_SRQ_ItemCheckentry entry on   bill.fid = entry.fparentid  left JOIN  CT_SRQ_Paytypeitem item on  item.fid = entry.cfseconditemid  where  bill.cftypenumber = 'YX' and bill.cfcityid = '"+cityId+"' and  CT_PAY_AchieveDetailTem.CFSecClassnumber = item.fnumber ) or  EXISTS (SELECT  1 FROM  CT_SRQ_ItemCheck bill inner join  CT_SRQ_ItemCheckentry entry on   bill.fid = entry.fparentid  left JOIN  CT_SRQ_PayItem  item on  item.fid = entry.cfitemid  where  bill.cftypenumber = 'YX' and bill.cfcityid = '"+cityId+"' and  CT_PAY_AchieveDetailTem.cffeeitemdetailNUMBER = item.fnumber ) ) ");
		sqlYJ.append(" ) c) cc ");
		sqlYJ.append(" union ");
		//����
		sqlYJ.append(" select dd.summ,'yz' as type from (select sum(d.allm) as summ from ( ");
		sqlYJ.append(" SELECT nvl(sum(CFINCOME),0) as allm FROM  CT_PAY_AchieveDetailTem  where    "+dateSql+"     cfiscount = 1 and   CFRecDotNumber ='"+empNum+"'   and CFCityNumber='"+cityNumber+"' and ( EXISTS (SELECT  1 FROM  CT_SRQ_ItemCheck bill inner join  CT_SRQ_ItemCheckentry entry on   bill.fid = entry.fparentid  left JOIN  CT_SRQ_Paytypecategory  item on  item.fid = entry.cffirstitemid  where  bill.cftypenumber = 'YZ' and bill.cfcityid = '"+cityId+"' and  CT_PAY_AchieveDetailTem.CFFirClassNumber = item.fnumber ) or  EXISTS (SELECT  1 FROM  CT_SRQ_ItemCheck bill inner join  CT_SRQ_ItemCheckentry entry on   bill.fid = entry.fparentid  left JOIN  CT_SRQ_Paytypeitem item on  item.fid = entry.cfseconditemid  where  bill.cftypenumber = 'YZ' and bill.cfcityid = '"+cityId+"' and  CT_PAY_AchieveDetailTem.CFSecClassnumber = item.fnumber ) or  EXISTS (SELECT  1 FROM  CT_SRQ_ItemCheck bill inner join  CT_SRQ_ItemCheckentry entry on   bill.fid = entry.fparentid  left JOIN  CT_SRQ_PayItem  item on  item.fid = entry.cfitemid  where  bill.cftypenumber = 'YZ' and bill.cfcityid = '"+cityId+"' and  CT_PAY_AchieveDetailTem.cffeeitemdetailNUMBER = item.fnumber ) )  ");
		sqlYJ.append(" ) d) dd ");
		sqlYJ.append(" union ");
		//������
		sqlYJ.append(" select ee.summ,'knw' as type from (select sum(e.allm) as summ from ( ");
		sqlYJ.append(" SELECT nvl(sum(CFINCOME),0) as allm FROM  CT_PAY_AchieveDetailTem  where    "+dateSql+"     cfiscount = 1 and   CFRecDotNumber ='"+empNum+"' and CFCityNumber='"+cityNumber+"'  and ( EXISTS (SELECT  1 FROM  CT_SRQ_ItemCheck bill inner join  CT_SRQ_ItemCheckentry entry on   bill.fid = entry.fparentid  left JOIN  CT_SRQ_Paytypecategory  item on  item.fid = entry.cffirstitemid  where  bill.cftypenumber = 'KNW' and bill.cfcityid = '"+cityId+"' and  CT_PAY_AchieveDetailTem.CFFirClassNumber = item.fnumber ) or  EXISTS (SELECT  1 FROM  CT_SRQ_ItemCheck bill inner join  CT_SRQ_ItemCheckentry entry on   bill.fid = entry.fparentid  left JOIN  CT_SRQ_Paytypeitem item on  item.fid = entry.cfseconditemid  where  bill.cftypenumber = 'KNW' and bill.cfcityid = '"+cityId+"' and  CT_PAY_AchieveDetailTem.CFSecClassnumber = item.fnumber ) or  EXISTS (SELECT  1 FROM  CT_SRQ_ItemCheck bill inner join  CT_SRQ_ItemCheckentry entry on   bill.fid = entry.fparentid  left JOIN  CT_SRQ_PayItem  item on  item.fid = entry.cfitemid  where  bill.cftypenumber = 'KNW' and bill.cfcityid = '"+cityId+"' and  CT_PAY_AchieveDetailTem.cffeeitemdetailNUMBER = item.fnumber ) ) ");
		sqlYJ.append(" ) e) ee ");
		sqlYJ.append(" union ");
		// ����
		sqlYJ.append(" select ff.summ,'mb' as type from (select sum(f.allm) as summ from ( ");
		sqlYJ.append(" SELECT nvl(sum(CFINCOME),0) as allm FROM  CT_PAY_AchieveDetailTem  where    "+dateSql+"      cfiscount = 1 and  CFRecDotNumber ='"+empNum+"' and CFCityNumber='"+cityNumber+"'  and ( EXISTS (SELECT  1 FROM  CT_SRQ_ItemCheck bill inner join  CT_SRQ_ItemCheckentry entry on   bill.fid = entry.fparentid  left JOIN  CT_SRQ_Paytypecategory  item on  item.fid = entry.cffirstitemid  where  bill.cftypenumber = 'MB' and bill.cfcityid = '"+cityId+"' and  CT_PAY_AchieveDetailTem.CFFirClassNumber = item.fnumber ) or  EXISTS (SELECT  1 FROM  CT_SRQ_ItemCheck bill inner join  CT_SRQ_ItemCheckentry entry on   bill.fid = entry.fparentid  left JOIN  CT_SRQ_Paytypeitem item on  item.fid = entry.cfseconditemid  where  bill.cftypenumber = 'MB' and bill.cfcityid = '"+cityId+"' and  CT_PAY_AchieveDetailTem.CFSecClassnumber = item.fnumber ) or  EXISTS (SELECT  1 FROM  CT_SRQ_ItemCheck bill inner join  CT_SRQ_ItemCheckentry entry on   bill.fid = entry.fparentid  left JOIN  CT_SRQ_PayItem  item on  item.fid = entry.cfitemid  where  bill.cftypenumber = 'MB' and bill.cfcityid = '"+cityId+"' and  CT_PAY_AchieveDetailTem.cffeeitemdetailNUMBER = item.fnumber ) )  ");
		sqlYJ.append(" ) f) ff ");
		sqlYJ.append(" union ");
		//�޸�
		sqlYJ.append(" select gg.summ,'xf' as type from (select sum(g.allm) as summ from ( ");
		sqlYJ.append(" SELECT nvl(sum(CFINCOME),0) as allm FROM  CT_PAY_AchieveDetailTem  where    "+dateSql+"      cfiscount = 1 and  CFRecDotNumber ='"+empNum+"'  and CFCityNumber='"+cityNumber+"'  and ( EXISTS (SELECT  1 FROM  CT_SRQ_ItemCheck bill inner join  CT_SRQ_ItemCheckentry entry on   bill.fid = entry.fparentid  left JOIN  CT_SRQ_Paytypecategory  item on  item.fid = entry.cffirstitemid  where  bill.cftypenumber = 'XF' and bill.cfcityid = '"+cityId+"' and  CT_PAY_AchieveDetailTem.CFFirClassNumber = item.fnumber ) or  EXISTS (SELECT  1 FROM  CT_SRQ_ItemCheck bill inner join  CT_SRQ_ItemCheckentry entry on   bill.fid = entry.fparentid  left JOIN  CT_SRQ_Paytypeitem item on  item.fid = entry.cfseconditemid  where  bill.cftypenumber = 'XF' and bill.cfcityid = '"+cityId+"' and  CT_PAY_AchieveDetailTem.CFSecClassnumber = item.fnumber ) or  EXISTS (SELECT  1 FROM  CT_SRQ_ItemCheck bill inner join  CT_SRQ_ItemCheckentry entry on   bill.fid = entry.fparentid  left JOIN  CT_SRQ_PayItem  item on  item.fid = entry.cfitemid  where  bill.cftypenumber = 'XF' and bill.cfcityid = '"+cityId+"' and  CT_PAY_AchieveDetailTem.cffeeitemdetailNUMBER = item.fnumber ) )  ");
		sqlYJ.append(" ) g) gg ");
		sqlYJ.append(" union ");
		// ����
		sqlYJ.append(" select hh.summ,'ey' as type from (select sum(h.allm) as summ from ( ");
		sqlYJ.append(" SELECT nvl(sum(CFINCOME),0) as allm FROM  CT_PAY_AchieveDetailTem  where    "+dateSql+"      cfiscount = 1 and  CFRecDotNumber ='"+empNum+"' and CFCityNumber='"+cityNumber+"'  and ( EXISTS (SELECT  1 FROM  CT_SRQ_ItemCheck bill inner join  CT_SRQ_ItemCheckentry entry on   bill.fid = entry.fparentid  left JOIN  CT_SRQ_Paytypecategory  item on  item.fid = entry.cffirstitemid  where  bill.cftypenumber = 'EY' and bill.cfcityid = '"+cityId+"' and  CT_PAY_AchieveDetailTem.CFFirClassNumber = item.fnumber ) or  EXISTS (SELECT  1 FROM  CT_SRQ_ItemCheck bill inner join  CT_SRQ_ItemCheckentry entry on   bill.fid = entry.fparentid  left JOIN  CT_SRQ_Paytypeitem item on  item.fid = entry.cfseconditemid  where  bill.cftypenumber = 'EY' and bill.cfcityid = '"+cityId+"' and  CT_PAY_AchieveDetailTem.CFSecClassnumber = item.fnumber ) or  EXISTS (SELECT  1 FROM  CT_SRQ_ItemCheck bill inner join  CT_SRQ_ItemCheckentry entry on   bill.fid = entry.fparentid  left JOIN  CT_SRQ_PayItem  item on  item.fid = entry.cfitemid  where  bill.cftypenumber = 'EY' and bill.cfcityid = '"+cityId+"' and  CT_PAY_AchieveDetailTem.cffeeitemdetailNUMBER = item.fnumber ) )  ");
		sqlYJ.append(" ) h) hh ");
 

		return sqlYJ;
	}
	
	/**
	 * ͳ��ҽ���ĳɱ�
	 * @param empNum
	 * @param cityNumber
	 * @param periodnum
	 * @param sqlCB
	 * @return
	 */
	public StringBuffer getChengBenSql(String empNums, String cityNumber,String periodnum,StringBuffer sqlCB){
		sqlCB.append(" /*dialect*/select ( nvl(sum(cfxhzz),0) +nvl(sum(cfjgfzz),0)) as summ,'zz' as type  from  CT_PAY_CostSum where cfperiod = '"+periodnum+"' and cfcitynumber='"+cityNumber+"' and  cfdoctornumber = '"+empNums+"'  union ");
		sqlCB.append(" 	select ( nvl(sum(cfxhyxjz),0) +nvl(sum(cfjgfyxjz),0)) as summ,'yxjz' as type  from  CT_PAY_CostSum where cfperiod = '"+periodnum+"' and cfcitynumber='"+cityNumber+"'  and  cfdoctornumber = '"+empNums+"'   union ");
		sqlCB.append(" 	select ( nvl(sum(cfxhcgjz),0) +nvl(sum(cfjgfcgjz),0)) as summ,'gdjz' as type  from  CT_PAY_CostSum where cfperiod = '"+periodnum+"' and cfcitynumber='"+cityNumber+"'   and  cfdoctornumber = '"+empNums+"'   union ");
		sqlCB.append(" 	select ( nvl(sum(cfxhknw),0) +nvl(sum(cfjgfknw),0)) as summ,'knw' as type  from  CT_PAY_CostSum where cfperiod = '"+periodnum+"' and cfcitynumber='"+cityNumber+"'    and  cfdoctornumber = '"+empNums+"'    union ");
		sqlCB.append(" 	select ( nvl(sum(cfxhxf),0) +nvl(sum(cfjgfxf),0)) as summ,'xf' as type  from  CT_PAY_CostSum where cfperiod = '"+periodnum+"'   and cfcitynumber='"+cityNumber+"' and  cfdoctornumber  = '"+empNums+"'   union ");
		sqlCB.append(" 	select ( nvl(sum(cfxhey),0) +nvl(sum(cfjgfey),0)) as summ,'ey' as type  from  CT_PAY_CostSum where cfperiod = '"+periodnum+"'  and cfcitynumber='"+cityNumber+"'  and  cfdoctornumber  = '"+empNums+"'   union ");
		sqlCB.append(" 	select ( nvl(sum(cfxhyz),0) +nvl(sum(cfjgfyz),0)) as summ,'yz' as type  from  CT_PAY_CostSum where cfperiod = '"+periodnum+"' and cfcitynumber='"+cityNumber+"'   and  cfdoctornumber = '"+empNums+"'  union ");
		sqlCB.append(" 	select ( nvl(sum(cfjgfmb),0) +nvl(sum(cfxhmb),0) ) as summ,'mb' as type  from  CT_PAY_CostSum where cfperiod = '"+periodnum+"'  and cfcitynumber='"+cityNumber+"'  and  cfdoctornumber = '"+empNums+"'   ");
		
		
		return sqlCB;
	}
	
	public StringBuffer getHushiChengBenSql(String empNums, String cityNumber,String periodnum,StringBuffer sqlCB){
		
		sqlCB.append(" /*dialect*/ select ( nvl(sum(cfxhzz),0) +nvl(sum(cfjgfzz),0)) as summ,'zz' as type  from  CT_PAY_CostByUpdate  where cfperiod = '"+periodnum+"' and cfcitynumber='"+cityNumber+"' and  cfdoctornumber = '"+empNums+"' and (cfiszidai is null or cfiszidai = 0)  union ");
		sqlCB.append(" 	select ( nvl(sum(cfxhyxjz),0) +nvl(sum(cfjgfyxjz),0)) as summ,'yxjz' as type  from  CT_PAY_CostByUpdate  where cfperiod = '"+periodnum+"' and cfcitynumber='"+cityNumber+"'  and  cfdoctornumber = '"+empNums+"' and (cfiszidai is null or cfiszidai = 0) union ");
		sqlCB.append(" 	select ( nvl(sum(cfxhcgjz),0) +nvl(sum(cfjgfcgjz),0)) as summ,'gdjz' as type  from  CT_PAY_CostByUpdate  where cfperiod = '"+periodnum+"' and cfcitynumber='"+cityNumber+"'   and  cfdoctornumber = '"+empNums+"' and (cfiszidai is null or cfiszidai = 0)  union ");
		sqlCB.append(" 	select ( nvl(sum(cfxhknw),0) +nvl(sum(cfjgfknw),0)) as summ,'knw' as type  from  CT_PAY_CostByUpdate  where cfperiod = '"+periodnum+"' and cfcitynumber='"+cityNumber+"'    and  cfdoctornumber = '"+empNums+"'and (cfiszidai is null or cfiszidai = 0)  union ");
		sqlCB.append(" 	select ( nvl(sum(cfxhxf),0) +nvl(sum(cfjgfxf),0)) as summ,'xf' as type  from  CT_PAY_CostByUpdate  where cfperiod = '"+periodnum+"'   and cfcitynumber='"+cityNumber+"' and  cfdoctornumber  = '"+empNums+"' and (cfiszidai is null or cfiszidai = 0) union ");
		sqlCB.append(" 	select ( nvl(sum(cfxhey),0) +nvl(sum(cfjgfey),0)) as summ,'ey' as type  from  CT_PAY_CostByUpdate  where cfperiod = '"+periodnum+"'  and cfcitynumber='"+cityNumber+"'  and  cfdoctornumber  = '"+empNums+"' and (cfiszidai is null or cfiszidai = 0) union ");
		sqlCB.append(" 	select ( nvl(sum(cfxhyz),0) +nvl(sum(cfjgfyz),0)) as summ,'yz' as type  from  CT_PAY_CostByUpdate  where cfperiod = '"+periodnum+"' and cfcitynumber='"+cityNumber+"'   and  cfdoctornumber = '"+empNums+"'  and (cfiszidai is null or cfiszidai = 0) union ");
		sqlCB.append(" 	select ( nvl(sum(cfjgfmb),0) +nvl(sum(cfxhmb),0) ) as summ,'mb' as type  from  CT_PAY_CostByUpdate  where cfperiod = '"+periodnum+"'  and cfcitynumber='"+cityNumber+"'  and  cfdoctornumber = '"+empNums+"' and (cfiszidai is null or cfiszidai = 0)  ");
		
		
		
		return sqlCB;
	}
	
	public StringBuffer getImportChengBenSql(String empNums, String cityID,String periodnum,StringBuffer sqlCB){ 
		sqlCB.append(" /*dialect*/select ( nvl(sum(cfzjcost),0) ) as summ,'zz' as type   FROM  CT_PAY_DoctorCosts  where CFBUSINESSDATE ='"+periodnum+"' and cfcityid='"+cityID+"'  and  cfempNumber = '"+empNums+"' and (cfiszidai is null or cfiszidai = 0) ");
		sqlCB.append(" union select ( nvl(sum(cfyxcost),0) ) as summ,'yxjz' as type   FROM CT_PAY_DoctorCosts  where CFBUSINESSDATE ='"+periodnum+"'   and cfcityid='"+cityID+"' and  cfempNumber = '"+empNums+"'and (cfiszidai is null or cfiszidai = 0) ");
		sqlCB.append(" 	 union select ( nvl(sum(cfgdcost),0) ) as summ,'gdjz' as type   FROM CT_PAY_DoctorCosts  where CFBUSINESSDATE ='"+periodnum+"'  and cfcityid='"+cityID+"'  and  cfempNumber = '"+empNums+"' and (cfiszidai is null or cfiszidai = 0) ");
		sqlCB.append(" 	 union select ( nvl(sum(cfkncost),0)) as summ,'knw' as type   FROM CT_PAY_DoctorCosts  where CFBUSINESSDATE ='"+periodnum+"' and cfcityid='"+cityID+"'  and  cfempNumber = '"+empNums+"' and (cfiszidai is null or cfiszidai = 0)  ");
		sqlCB.append(" 	 union select ( nvl(sum(cfxfcost),0) ) as summ,'xf' as type   FROM CT_PAY_DoctorCosts  where CFBUSINESSDATE ='"+periodnum+"' and cfcityid='"+cityID+"'  and  cfempNumber = '"+empNums+"' and (cfiszidai is null or cfiszidai = 0) ");
		sqlCB.append(" 	 union select ( nvl(sum(cfeycost),0)) as summ,'ey' as type   FROM CT_PAY_DoctorCosts  where CFBUSINESSDATE ='"+periodnum+"'  and cfcityid='"+cityID+"'  and  cfempNumber = '"+empNums+"' and (cfiszidai is null or cfiszidai = 0)  ");
		sqlCB.append(" 	 union select ( nvl(sum(cfzbcost),0)) as summ,'yz' as type   FROM CT_PAY_DoctorCosts  where CFBUSINESSDATE ='"+periodnum+"'  and cfcityid='"+cityID+"' and  cfempNumber = '"+empNums+"' and (cfiszidai is null or cfiszidai = 0) ");
		sqlCB.append(" 	 union select ( nvl(sum(cfmbcost),0)) as summ,'mb' as type  FROM CT_PAY_DoctorCosts  where CFBUSINESSDATE ='"+periodnum+"'  and cfcityid='"+cityID+"' and  cfempNumber = '"+empNums+"' and (cfiszidai is null or cfiszidai = 0) ");
		
		return sqlCB;
	}
	 
	 
	
	 
}

