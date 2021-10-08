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

import mondrian.rolap.BitKey.Big;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.util.BOSUuid;
import com.kingdee.eas.base.core.fm.ContextHelperFactory;
import com.kingdee.eas.basedata.framework.app.ParallelSqlExecutor;
import com.kingdee.eas.basedata.org.CompanyOrgUnitFactory;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.basedata.org.CtrlUnitInfo;
import com.kingdee.eas.mw.pay.ClinicCostSumFactory;
import com.kingdee.eas.mw.pay.ClinicCostSumInfo;
import com.kingdee.eas.mw.pay.DocAchieveUpdateFactory;
import com.kingdee.eas.mw.pay.DocAchieveUpdateInfo;
import com.kingdee.eas.mw.pay.DoctorCostsFactory;
import com.kingdee.eas.mw.pay.DoctorCostsInfo;
import com.kingdee.eas.mw.pay.app.costType;
import com.kingdee.jdbc.rowset.IRowSet;

public class PayNingBoDocCopyFunctionService { 

	private Logger log;
	public PayNingBoDocCopyFunctionService() {
		this.log = LoggerFactory.getLogger(PayNingBoDocCopyFunctionService.class);
	}
	 
	/**
	 * ��ȡҽ������    û������ ������������
	 * 
	 * @throws Exception 
	 */
	public HashMap<String,Object>  getDocBonus(Context ctx,String empNum, String clinicNumber,String clinicName,String periodnum,HashMap tempMap,String cityId,
			String cityNumber,BigDecimal docAchieve,BigDecimal docZidaiAchieve,String type ,String calType ,String docStageType
			,HashMap<String, BigDecimal> docAllAchieveMap
			,HashMap<String,String> oneItemMap,HashMap<String,String>  twoItemMap,HashMap<String,String>  threeItemMap ) throws Exception{
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
		CompanyOrgUnitInfo orgUnit = CompanyOrgUnitFactory.getLocalInstance(ctx).getCompanyOrgUnitCollection(" where number = '"+clinicNumber+"' " ).get(0);
		
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
		//����ҵ��
		BigDecimal zjyeji = BigDecimal.ZERO; 
		
		
		//��������
		BigDecimal zjbl = new BigDecimal("1"); 
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
		//�⹤��������
		BigDecimal freeWorkPro = BigDecimal.ZERO; 
		//һ����������
		BigDecimal firSourcePro = BigDecimal.ZERO; 
		//һ������
		String firSource = "";
		//�������
		BigDecimal gifAmountPro = BigDecimal.ZERO; 
		
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
		clinicCostSumInfo.setClinicName(clinicName);
		clinicCostSumInfo.setCityNumber(cityNumber);
		clinicCostSumInfo.setBusinessDate(periodnum); 
		clinicCostSumInfo.setCityName(tempMap.get("cityName").toString());
		clinicCostSumInfo.setEmpName(tempMap.get("empName").toString());
		
		
		HashMap tongyongmap = (HashMap)tempMap.get("TONGYONGBILI_DOC");
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
		}else{
			firSource = "''";
		}   
		  
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
			biliMap.put("zj",zjbl ); 

			if( docAllAchieveMap.get(empNum+"_"+clinicNumber+"_zz_DOC_XT_ACHIEVE") != null ){//��ֲ 
				BigDecimal achieve = docAllAchieveMap.get(empNum+"_"+clinicNumber+"_zz_DOC_XT_ACHIEVE");
	  			zz = zz.add(achieve);   
	  		}
			if( docAllAchieveMap.get(empNum+"_"+clinicNumber+"_gd_DOC_XT_ACHIEVE") != null  ){//�̶�����  
	  			BigDecimal achieve = docAllAchieveMap.get(empNum+"_"+clinicNumber+"_gd_DOC_XT_ACHIEVE");
	  			gdjz= gdjz.add(achieve);  
	  		}
			
			if( docAllAchieveMap.get(empNum+"_"+clinicNumber+"_zj_DOC_XT_ACHIEVE") != null ){//����
				BigDecimal achieve = docAllAchieveMap.get(empNum+"_"+clinicNumber+"_zj_DOC_XT_ACHIEVE").multiply(zjbl);
				zjyeji= zjyeji.add(achieve);  
			} 
			
			if( docAllAchieveMap.get(empNum+"_"+clinicNumber+"_yx_DOC_XT_ACHIEVE") != null){//���ν���
	  			BigDecimal achieve = docAllAchieveMap.get(empNum+"_"+clinicNumber+"_yx_DOC_XT_ACHIEVE");
	  			yxjz= yxjz.add(achieve);   
	  		}
			if( docAllAchieveMap.get(empNum+"_"+clinicNumber+"_yz_DOC_XT_ACHIEVE") != null){//����  ����
	  			BigDecimal achieve = docAllAchieveMap.get(empNum+"_"+clinicNumber+"_yz_DOC_XT_ACHIEVE");
	  			yz= yz.add(achieve); 
	  		}
			if( docAllAchieveMap.get(empNum+"_"+clinicNumber+"_mb_DOC_XT_ACHIEVE") != null){//����
	  			BigDecimal achieve = docAllAchieveMap.get(empNum+"_"+clinicNumber+"_mb_DOC_XT_ACHIEVE");
	  			mb= mb.add(achieve); 
	  		}
			if(   docAllAchieveMap.get(empNum+"_"+clinicNumber+"_knw_DOC_XT_ACHIEVE") != null ){//������ ��
	  			BigDecimal achieve = docAllAchieveMap.get(empNum+"_"+clinicNumber+"_knw_DOC_XT_ACHIEVE");
	  			knw = knw.add(achieve);  
	  		}
			if(  docAllAchieveMap.get(empNum+"_"+clinicNumber+"_xf_DOC_XT_ACHIEVE") != null ){//�޸�
	  			BigDecimal achieve = docAllAchieveMap.get(empNum+"_"+clinicNumber+"_xf_DOC_XT_ACHIEVE");
	  			xf= xf.add(achieve);   
	  		}
			if( docAllAchieveMap.get(empNum+"_"+clinicNumber+"_ey_DOC_XT_ACHIEVE") != null ){//����
	  			BigDecimal achieve = docAllAchieveMap.get(empNum+"_"+clinicNumber+"_ey_DOC_XT_ACHIEVE");
	  			zjyeji= zjyeji.add(achieve);   
	  		}

			imandxtinsertsql +=  ", CFXTZZACHIEVE  , cfXTyxjzachieve, CFXTyzAchieve , cfXTknwachieve , cfXTmbachieve , cfXTxfachieve, cfXTeyachieve ";
			imandxtinsertValueSql +=" ,"+zz+" ,"+yxjz+","+yz+","+knw+","+mb+","+xf+","+ey+"  ";

			//������ֲ
			imzz = docAllAchieveMap.get(empNum+"_"+clinicNumber+"_ZZ_DOC_IMP_ACHIEVE")==null? BigDecimal.ZERO:docAllAchieveMap.get(empNum+"_"+clinicNumber+"_ZZ_DOC_IMP_ACHIEVE");
			//����̶�����
			imgdjz = docAllAchieveMap.get(empNum+"_"+clinicNumber+"_GD_DOC_IMP_ACHIEVE")==null? BigDecimal.ZERO:docAllAchieveMap.get(empNum+"_"+clinicNumber+"_GD_DOC_IMP_ACHIEVE");
			//�������ν���
			imyxjz = docAllAchieveMap.get(empNum+"_"+clinicNumber+"_YX_DOC_IMP_ACHIEVE")==null? BigDecimal.ZERO:docAllAchieveMap.get(empNum+"_"+clinicNumber+"_YX_DOC_IMP_ACHIEVE");
			//��������
			imyz = docAllAchieveMap.get(empNum+"_"+clinicNumber+"_YZ_DOC_IMP_ACHIEVE")==null? BigDecimal.ZERO:docAllAchieveMap.get(empNum+"_"+clinicNumber+"_YZ_DOC_IMP_ACHIEVE");
			//���������
			imknw = docAllAchieveMap.get(empNum+"_"+clinicNumber+"_KNW_DOC_IMP_ACHIEVE")==null? BigDecimal.ZERO:docAllAchieveMap.get(empNum+"_"+clinicNumber+"_KNW_DOC_IMP_ACHIEVE");
			//��������
			immb = docAllAchieveMap.get(empNum+"_"+clinicNumber+"_MB_DOC_IMP_ACHIEVE")==null? BigDecimal.ZERO:docAllAchieveMap.get(empNum+"_"+clinicNumber+"_MB_DOC_IMP_ACHIEVE");
			//�����޸�
			imxf = docAllAchieveMap.get(empNum+"_"+clinicNumber+"_XF_DOC_IMP_ACHIEVE")==null? BigDecimal.ZERO:docAllAchieveMap.get(empNum+"_"+clinicNumber+"_XF_DOC_IMP_ACHIEVE");
			//�������
			imey = docAllAchieveMap.get(empNum+"_"+clinicNumber+"_EY_DOC_IMP_ACHIEVE")==null? BigDecimal.ZERO:docAllAchieveMap.get(empNum+"_"+clinicNumber+"_EY_DOC_IMP_ACHIEVE");
			
			zz = zz.add(imzz); 
			if(zjyeji.compareTo(BigDecimal.ZERO) > 0){//������ҵ��   �̶������ξͲ�����ҵ��
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
			  
			if( docAllAchieveMap.get(empNum+"_"+clinicNumber+"_zz_DOC_IMP_CB") != null ){//��ֲ
				  zzcb =docAllAchieveMap.get(empNum+"_"+clinicNumber+"_zz_DOC_IMP_CB");  
				  clinicCostSumInfo.setImzzCost(zzcb);
			 }
			if( docAllAchieveMap.get(empNum+"_"+clinicNumber+"_gdjz_DOC_IMP_CB")!= null  ){//�̶�����
				  gdjzcb= docAllAchieveMap.get(empNum+"_"+clinicNumber+"_gdjz_DOC_IMP_CB") ;  
				  clinicCostSumInfo.setImgdjzCost(gdjzcb);
			 }
			if( docAllAchieveMap.get(empNum+"_"+clinicNumber+"_yxjz_DOC_IMP_CB") != null ){//���ν���
				  yxjzcb= docAllAchieveMap.get(empNum+"_"+clinicNumber+"_yxjz_DOC_IMP_CB");  
				  clinicCostSumInfo.setImyxjzCost(yxjzcb);
			 }
			if( docAllAchieveMap.get(empNum+"_"+clinicNumber+"_yz_DOC_IMP_CB")  != null  ){//����
				  yzcb=docAllAchieveMap.get(empNum+"_"+clinicNumber+"_yz_DOC_IMP_CB") ;  
				  clinicCostSumInfo.setImyzCost(yzcb);
			 }
			if( docAllAchieveMap.get(empNum+"_"+clinicNumber+"_knw_DOC_IMP_CB")  != null ){//������
				  knwcb =docAllAchieveMap.get(empNum+"_"+clinicNumber+"_knw_DOC_IMP_CB") ; 
				  clinicCostSumInfo.setImknwCost(knwcb);
			 }
			if(  docAllAchieveMap.get(empNum+"_"+clinicNumber+"_mb_DOC_IMP_CB")  != null ){//����
				  mbcb= docAllAchieveMap.get(empNum+"_"+clinicNumber+"_mb_DOC_IMP_CB") ;  
				  clinicCostSumInfo.setImmbCost(mbcb);
			 }
			if( docAllAchieveMap.get(empNum+"_"+clinicNumber+"_xf_DOC_IMP_CB")  != null ){//�޸�
				  xfcb= docAllAchieveMap.get(empNum+"_"+clinicNumber+"_xf_DOC_IMP_CB") ;  
				  clinicCostSumInfo.setImxfCost(xfcb);
			 }
			if(  docAllAchieveMap.get(empNum+"_"+clinicNumber+"_ey_DOC_IMP_CB")  != null ){//����
				  eycb=docAllAchieveMap.get(empNum+"_"+clinicNumber+"_ey_DOC_IMP_CB");  
				  clinicCostSumInfo.setImeyCost(eycb);
				   
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
			if( docAllAchieveMap.get(empNum+"_"+clinicNumber+"_zz_DOC_HSZ_CB") != null ){//��ֲ
				  zzcb = zzcb.add(docAllAchieveMap.get(empNum+"_"+clinicNumber+"_zz_DOC_HSZ_CB"));  
				  clinicCostSumInfo.setUpzzCost(docAllAchieveMap.get(empNum+"_"+clinicNumber+"_zz_DOC_HSZ_CB"));
			}
			if( docAllAchieveMap.get(empNum+"_"+clinicNumber+"_gdjz_DOC_HSZ_CB") != null ){//�̶�����
				  gdjzcb = gdjzcb.add(docAllAchieveMap.get(empNum+"_"+clinicNumber+"_gdjz_DOC_HSZ_CB") );  
				  clinicCostSumInfo.setUpgdjzCost(docAllAchieveMap.get(empNum+"_"+clinicNumber+"_gdjz_DOC_HSZ_CB") );
			}
			if( docAllAchieveMap.get(empNum+"_"+clinicNumber+"_yxjz_DOC_HSZ_CB") != null){//���ν���
				  yxjzcb = yxjzcb.add( docAllAchieveMap.get(empNum+"_"+clinicNumber+"_yxjz_DOC_HSZ_CB"));  
				  clinicCostSumInfo.setUpyxjzCost( docAllAchieveMap.get(empNum+"_"+clinicNumber+"_yxjz_DOC_HSZ_CB"));
			}
			if( docAllAchieveMap.get(empNum+"_"+clinicNumber+"_yz_DOC_HSZ_CB") != null){//����
				  yzcb = yzcb.add(docAllAchieveMap.get(empNum+"_"+clinicNumber+"_yz_DOC_HSZ_CB"));  
				  clinicCostSumInfo.setUpyzCost(docAllAchieveMap.get(empNum+"_"+clinicNumber+"_yz_DOC_HSZ_CB"));
			}
			if( docAllAchieveMap.get(empNum+"_"+clinicNumber+"_knw_DOC_HSZ_CB") != null){//������
				  knwcb = knwcb.add( docAllAchieveMap.get(empNum+"_"+clinicNumber+"_knw_DOC_HSZ_CB")); 
				  clinicCostSumInfo.setUpknwCost( docAllAchieveMap.get(empNum+"_"+clinicNumber+"_knw_DOC_HSZ_CB"));
			}
			if( docAllAchieveMap.get(empNum+"_"+clinicNumber+"_mb_DOC_HSZ_CB") != null){//����
				  mbcb = mbcb.add(docAllAchieveMap.get(empNum+"_"+clinicNumber+"_mb_DOC_HSZ_CB"));  
				  clinicCostSumInfo.setUpmbCost(docAllAchieveMap.get(empNum+"_"+clinicNumber+"_mb_DOC_HSZ_CB"));
			}
			if( docAllAchieveMap.get(empNum+"_"+clinicNumber+"_xf_DOC_HSZ_CB") != null){//�޸�
				  xfcb = xfcb.add(docAllAchieveMap.get(empNum+"_"+clinicNumber+"_xf_DOC_HSZ_CB") );  
				  clinicCostSumInfo.setUpxfCost(docAllAchieveMap.get(empNum+"_"+clinicNumber+"_xf_DOC_HSZ_CB") );
			}
			if( docAllAchieveMap.get(empNum+"_"+clinicNumber+"_ey_DOC_HSZ_CB") != null){//����
				  eycb = eycb.add( docAllAchieveMap.get(empNum+"_"+clinicNumber+"_ey_DOC_HSZ_CB"));  
				  clinicCostSumInfo.setUpeyCost( docAllAchieveMap.get(empNum+"_"+clinicNumber+"_ey_DOC_HSZ_CB"));
			}   
			
			
			//������۳���ĳɱ�
			if( docAllAchieveMap.get(empNum+"_"+clinicNumber+"_zz_DOC_XSCK_CB") != null ){//��ֲ
				  zzcb = zzcb.add(docAllAchieveMap.get(empNum+"_"+clinicNumber+"_zz_DOC_XSCK_CB")); 
				  clinicCostSumInfo.setZzCost(docAllAchieveMap.get(empNum+"_"+clinicNumber+"_zz_DOC_XSCK_CB"));
			}
			if( docAllAchieveMap.get(empNum+"_"+clinicNumber+"_gdjz_DOC_XSCK_CB") != null ){//�̶�����
				  gdjzcb = gdjzcb.add(docAllAchieveMap.get(empNum+"_"+clinicNumber+"_gdjz_DOC_XSCK_CB")); 
				  clinicCostSumInfo.setGdjzCost(docAllAchieveMap.get(empNum+"_"+clinicNumber+"_gdjz_DOC_XSCK_CB"));
			}
			if( docAllAchieveMap.get(empNum+"_"+clinicNumber+"_yxjz_DOC_XSCK_CB") != null ){//���ν���
				  yxjzcb = yxjzcb.add(docAllAchieveMap.get(empNum+"_"+clinicNumber+"_yxjz_DOC_XSCK_CB")); 
				  clinicCostSumInfo.setYxjzCost(docAllAchieveMap.get(empNum+"_"+clinicNumber+"_yxjz_DOC_XSCK_CB"));
			}
			if( docAllAchieveMap.get(empNum+"_"+clinicNumber+"_yz_DOC_XSCK_CB") != null ){//����
				  yzcb = yzcb.add(docAllAchieveMap.get(empNum+"_"+clinicNumber+"_yz_DOC_XSCK_CB")); 
				  clinicCostSumInfo.setYzCost(docAllAchieveMap.get(empNum+"_"+clinicNumber+"_yz_DOC_XSCK_CB"));
			}
			if( docAllAchieveMap.get(empNum+"_"+clinicNumber+"_knw_DOC_XSCK_CB") != null ){//������
				  knwcb = knwcb.add(docAllAchieveMap.get(empNum+"_"+clinicNumber+"_knw_DOC_XSCK_CB"));
				  clinicCostSumInfo.setKnwCost(docAllAchieveMap.get(empNum+"_"+clinicNumber+"_knw_DOC_XSCK_CB"));
			}
			if( docAllAchieveMap.get(empNum+"_"+clinicNumber+"_mb_DOC_XSCK_CB") != null ){//����
				  mbcb = mbcb.add(docAllAchieveMap.get(empNum+"_"+clinicNumber+"_mb_DOC_XSCK_CB")); 
				  clinicCostSumInfo.setMbCost(docAllAchieveMap.get(empNum+"_"+clinicNumber+"_mb_DOC_XSCK_CB"));
			}
			if( docAllAchieveMap.get(empNum+"_"+clinicNumber+"_xf_DOC_XSCK_CB") != null ){//�޸�
				  xfcb = xfcb.add(docAllAchieveMap.get(empNum+"_"+clinicNumber+"_xf_DOC_XSCK_CB")); 
				  clinicCostSumInfo.setXfCost(docAllAchieveMap.get(empNum+"_"+clinicNumber+"_xf_DOC_XSCK_CB"));
			}
			if( docAllAchieveMap.get(empNum+"_"+clinicNumber+"_ey_DOC_XSCK_CB") != null ){//����
				  eycb = eycb.add( docAllAchieveMap.get(empNum+"_"+clinicNumber+"_ey_DOC_XSCK_CB")); 
				  clinicCostSumInfo.setEyCost( docAllAchieveMap.get(empNum+"_"+clinicNumber+"_ey_DOC_XSCK_CB"));
			} 
			 
			BigDecimal allAchieve = zz.add(gdjz).add(yxjz).add(yz).add(knw).add(mb).add(xf).add(ey);
			 
			
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
				if(DoctorCostsFactory.getLocalInstance(ctx).exists("where BusinessDate='"+nextPeriod+"' and city = '"+cityId+"' and EmpNumber='"+empNum+"' and CostType='yk' and (Description is null or Description!='��̯�۳�ҵ��') ")){
					DoctorCostsFactory.getLocalInstance(ctx).delete("where BusinessDate='"+nextPeriod+"' and city = '"+cityId+"' and EmpNumber='"+empNum+"' and CostType='yk' and (Description is null or Description!='��̯�۳�ҵ��')");	
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
				}else if(allMap.get("all").compareTo(BigDecimal.ZERO) <0 ){//����Ǹ���  ˵��û������
					
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
				
				if(DocAchieveUpdateFactory.getLocalInstance(ctx).exists("where BusinessDate='"+periodnum+"' and city = '"+cityId+"' and docNumber='"+empNum+"'   and name='��̯�۳�ҵ��' ")){
					DocAchieveUpdateFactory.getLocalInstance(ctx).delete("where BusinessDate='"+periodnum+"' and city = '"+cityId+"' and docNumber='"+empNum+"'   and name='��̯�۳�ҵ��' "); 
				}
				DocAchieveUpdateInfo docAchieveUpdateThis =new DocAchieveUpdateInfo();
				docAchieveUpdateThis.setBusinessDate(periodnum); 
				ctrlUnitInfo.setId(BOSUuid.read(cityId));
				docAchieveUpdateThis.setCity(ctrlUnitInfo);
				docAchieveUpdateThis.setCityNumber(cityNumber);
				
				docAchieveUpdateThis.setClinic(orgUnit);
				docAchieveUpdateThis.setClinicName(orgUnit.getName()); 
				docAchieveUpdateThis.setClinicNumber(orgUnit.getNumber()); 
				
				docAchieveUpdateThis.setDocNumber(empNum);
				docAchieveUpdateThis.setDocName(tempMap.get("empName").toString()); 
				docAchieveUpdateThis.setName("��̯�۳�ҵ��"); 
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
			}else{//�������ӿ�   
				zzBase = zz.subtract(zzcb).compareTo(BigDecimal.ZERO)<0?BigDecimal.ZERO:zz.subtract(zzcb);
				gdjzBase = gdjz.subtract(gdjzcb).compareTo(BigDecimal.ZERO)<0?BigDecimal.ZERO:gdjz.subtract(gdjzcb);
				yxjzBase = yxjz.subtract(yxjzcb).compareTo(BigDecimal.ZERO)<0?BigDecimal.ZERO:yxjz.subtract(yxjzcb);
				yzBase = yz.subtract(yzcb).compareTo(BigDecimal.ZERO)<0?BigDecimal.ZERO:yz.subtract(yzcb);
				knwBase = knw.subtract(knwcb).compareTo(BigDecimal.ZERO)<0?BigDecimal.ZERO:knw.subtract(knwcb);
				BigDecimal mbBase = mb.subtract(mbcb).compareTo(BigDecimal.ZERO)<0?BigDecimal.ZERO:mb.subtract(mbcb);
				xfBase = xf.subtract(xfcb).compareTo(BigDecimal.ZERO)<0?BigDecimal.ZERO:xf.subtract(xfcb);
				eyBase = ey.subtract(eycb).compareTo(BigDecimal.ZERO)<0?BigDecimal.ZERO:ey.subtract(eycb);
				
			} 
			 
			 
			imandxtinsertsql +=  ", CFIMZZACHIEVE , CFIMGDJZACHIEVE , cfIMyxjzachieve, CFIMyzAchieve , cfIMknwachieve , cfIMmbachieve , cfIMxfachieve, cfIMeyachieve ";
			imandxtinsertValueSql +=" ,"+imzz+" ,"+imgdjz+","+imyxjz +","+imyz+","+imknw+","+immb+","+imxf+"," + ""+imey+"  ";
			
			insertSql +=  ", CFZZACHIEVE , CFGDJZACHIEVE , cfyxjzachieve, CFZyAchieve , cfknwachieve , cfmbachieve , cfxfachieve, cfeyachieve,cfallbase ";
			insertValueSql +=" ,"+zz+" ,"+gdjz+","+yxjz+","+yz+","+knw+","+mb+","+xf+","+ey+" ,"+docAchieve+" ";
			
			
			//----------------
			//���ҽ�����������Ĺ�����
			BigDecimal sumAchieve =  zz.add(gdjz).add(yxjz).add(yz).add(knw).add(mb).add(xf).add(ey); 
			 
			BigDecimal allBase = zzBase.add(gdjzBase).add(yxjzBase).add(yzBase).add(knwBase).add(xfBase).add(eyBase);
			
			//���ҽ�����еĹ�����
			allBase = docAchieve;
			if(allBase.compareTo(BigDecimal.ZERO) <=0 ){
				allBase = new BigDecimal("1");
			}    
			 
			
			//�������ֵ�ҵ������
			BigDecimal zzBaseData =docBase.multiply(zz.divide(allBase,6, BigDecimal.ROUND_HALF_UP));
			BigDecimal gdBaseData = docBase.multiply(gdjz.divide(allBase,6, BigDecimal.ROUND_HALF_UP));
			BigDecimal yxBaseData = docBase.multiply(yxjz.divide(allBase,6, BigDecimal.ROUND_HALF_UP));
			BigDecimal yzBaseData = docBase.multiply(yz.divide(allBase,6, BigDecimal.ROUND_HALF_UP));
			BigDecimal knwBaseData = docBase.multiply(knw.divide(allBase,6, BigDecimal.ROUND_HALF_UP));
			BigDecimal mbBaseData = BigDecimal.ZERO;
			BigDecimal xfBaseData = docBase.multiply(xf.divide(allBase,6, BigDecimal.ROUND_HALF_UP));
			BigDecimal eyBaseData = docBase.multiply(ey.divide(allBase,6, BigDecimal.ROUND_HALF_UP));
			BigDecimal allBaseData = sumAchieve;  
			
			//��������ҵ����ռ����
			BigDecimal zzBasePro =  zz.divide(allBase,6, BigDecimal.ROUND_HALF_UP);
			BigDecimal gdBasePro =   gdjz.divide(allBase,6, BigDecimal.ROUND_HALF_UP);
			BigDecimal yxBasePro =  yxjz.divide(allBase,6, BigDecimal.ROUND_HALF_UP);
			BigDecimal yzBasePro =  yz.divide(allBase,6, BigDecimal.ROUND_HALF_UP);
			BigDecimal knwBasePro =  knw.divide(allBase,6, BigDecimal.ROUND_HALF_UP);
			BigDecimal mbBasePro = BigDecimal.ZERO;
			BigDecimal xfBasePro =  xf.divide(allBase,6, BigDecimal.ROUND_HALF_UP);
			BigDecimal eyBasePro =  ey.divide(allBase,6, BigDecimal.ROUND_HALF_UP);
			
			
			
			HashMap<String,BigDecimal> bingzhongMap = new HashMap<String,BigDecimal>();
			  
			if(docStageType.length() >0){ 
				String fdocCalType = tempMap.get(empNum+"_DOCCALTYPE").toString();
				
				//Ĭ��ʹ�ý��ݺ� ��ʹ��ȫ��ҵ��
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
					
					if(isallAchieve.equals("1")){ //���ȥ���ҵ��  ֻ��ʹ�����ҵ����ɱ���
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
								  
								  //��������׶�
								  if(achieve.compareTo(beginAmount) > 0 &&  achieve.compareTo(endAmount) <= 0 ){
									  //������� 
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
						
						//������ҵ������ɱ���
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
									  //��������׶�
									  if(achieve.compareTo(beginAmount) > 0 &&  achieve.compareTo(endAmount) <= 0 ){
										  //������� 
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
									  }/*else{
										  break;
									  }*/

								  }
							}
						}else{//�ֽ׶ν��м���
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
										  }else if(typeStage.equals("YX") ){ yxBaseData =  yxBasePro.multiply(baseAchieve);   baseAchieveThis = achieve.subtract(yxBaseData);
										  }else if(typeStage.equals("GD") || typeStage.equals("ZJ") ){   gdBaseData =  gdBasePro.multiply(baseAchieve);  baseAchieveThis = achieve.subtract(gdBaseData);
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
										  
									  }else if(baseAchieveThis.compareTo(endAmount) < 1 ){
										  if(typeStage.equals("ZZ") ){  zzthisMoney = thisAllAchieve.subtract(zzBaseData).multiply(pro).add(zzthisMoney);  } 
										  else if(typeStage.equals("YX") ){  yxjzthisMoney = thisAllAchieve.subtract(yxBaseData).multiply(pro).add(yxjzthisMoney);  }
										  else if(typeStage.equals("GD") || typeStage.equals("ZJ") ){   gdjzthisMoney = thisAllAchieve.subtract(gdBaseData).multiply(pro).add(gdjzthisMoney); }
										  else if(typeStage.equals("KNW") ){ knwthisMoney = thisAllAchieve.subtract(knwBaseData).multiply(pro).add(knwthisMoney);  }
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
			
			
			
			insertSql +=  ", CFZZbase , CFGDbase , cfyxbase, CFyzbase , cfknwbase , cfmbbase , cfxfbase, cfeybase  ";
			insertValueSql +=" ,"+zzBaseData+" ,"+gdBaseData+","+yxBaseData+","+yzBaseData+ ","+knwBaseData+","+0+ ","+xfBaseData+","+eyBaseData+" ";
			 
			if(allBase.compareTo(BigDecimal.ZERO) <= 0){
				insertSql +=  ", CFZZpro , CFGDpro , cfyxpro, CFyzpro , cfknwpro , cfmbpro , cfxfpro, cfeypro  ";
				insertValueSql +=" ,0 ,0,0,0,0,0,0,0 ";
			}else{
				insertSql +=  ", CFZZpro , CFGDpro , cfyxpro, CFyzpro , cfknwpro , cfmbpro , cfxfpro, cfeypro  ";
				insertValueSql +=" ,"+zzBasePro+" ,"+gdBasePro+ ","+yxBasePro+","+yzBasePro+ ","+knwBasePro+","+mbBasePro+ ","+xfBasePro+","+eyBasePro+" "; 
			}
			
			
			clinicCostSumInfo.setAllzzCost(clinicCostSumInfo.getUpzzCost().add(clinicCostSumInfo.getZzCost()).add(clinicCostSumInfo.getImzzCost()));
			clinicCostSumInfo.setAllgdjzCost(clinicCostSumInfo.getUpgdjzCost().add(clinicCostSumInfo.getGdjzCost()).add(clinicCostSumInfo.getImgdjzCost())); 
			clinicCostSumInfo.setAllyxjzCost(clinicCostSumInfo.getUpyxjzCost().add(clinicCostSumInfo.getYxjzCost()).add(clinicCostSumInfo.getImyxjzCost()));
			clinicCostSumInfo.setAllyzCost(clinicCostSumInfo.getUpyzCost().add(clinicCostSumInfo.getYzCost()).add(clinicCostSumInfo.getImyzCost()));
			clinicCostSumInfo.setAllknwCost(clinicCostSumInfo.getUpknwCost().add(clinicCostSumInfo.getKnwCost()).add(clinicCostSumInfo.getImknwCost()));
			clinicCostSumInfo.setAllmbCost(clinicCostSumInfo.getUpmbCost().add(clinicCostSumInfo.getMbCost()).add(clinicCostSumInfo.getImmbCost()));
			clinicCostSumInfo.setAllxfCost(clinicCostSumInfo.getUpxfCost().add(clinicCostSumInfo.getXfCost()).add(clinicCostSumInfo.getImxfCost()));
			clinicCostSumInfo.setAlleyCost(clinicCostSumInfo.getUpeyCost().add(clinicCostSumInfo.getEyCost()).add(clinicCostSumInfo.getImeyCost()));
			 
			costAll = costAll.add(clinicCostSumInfo.getAllzzCost()).add(clinicCostSumInfo.getAllgdjzCost())
			.add(clinicCostSumInfo.getAllyxjzCost()).add(clinicCostSumInfo.getAllyzCost())
			.add(clinicCostSumInfo.getAllknwCost()).add(clinicCostSumInfo.getAllmbCost())
			.add(clinicCostSumInfo.getAllxfCost()).add(clinicCostSumInfo.getAlleyCost()); 
			
			insertSql +=  ", cfzzcost , cfgdjzcost , cfyxjzcost , cfyzcost , cfknwcost , cfmbcost , cfxfcost , cfeycost  ";
			insertValueSql += " ,"+clinicCostSumInfo.getAllzzCost()+" ,"+clinicCostSumInfo.getAllgdjzCost()
				+" ,"+clinicCostSumInfo.getAllyxjzCost()+" ,"+clinicCostSumInfo.getAllyzCost() 
				+" ,"+clinicCostSumInfo.getAllknwCost()+" ,"+clinicCostSumInfo.getAllmbCost()
				+" ,"+clinicCostSumInfo.getAllxfCost()+" ,"+clinicCostSumInfo.getAlleyCost();
			
			
			
			
			BigDecimal zzMoney = BigDecimal.ZERO;
			BigDecimal gdjzMoney = BigDecimal.ZERO;
			BigDecimal yxjzMoney = BigDecimal.ZERO;
			BigDecimal yzMoney = BigDecimal.ZERO;
			BigDecimal knwMoney = BigDecimal.ZERO;
			BigDecimal mbMoney = BigDecimal.ZERO;
			BigDecimal xfMoney = BigDecimal.ZERO;
			BigDecimal eyMoney = BigDecimal.ZERO;
			if(allBase.compareTo(BigDecimal.ZERO) <=0 ){
				allBase = BigDecimal.ONE;
			}else{
				if(bingzhongMap.get("zz") == null){ zzMoney = zzBase.subtract(zzBaseData).compareTo(BigDecimal.ZERO) > 0 ? zzBase.subtract(zzBaseData).multiply(zzbi):BigDecimal.ZERO; }
				else{ zzMoney = bingzhongMap.get("zz"); }
				
				if(bingzhongMap.get("gd") == null){ gdjzMoney = gdjzBase.subtract(gdBaseData).compareTo(BigDecimal.ZERO) > 0 ? gdjzBase.subtract(gdBaseData).multiply(gdjzbi):BigDecimal.ZERO;  }
				else{ gdjzMoney = bingzhongMap.get("gd");  }
				
				if(bingzhongMap.get("yx") == null){ yxjzMoney = yxjzBase.subtract(yxBaseData).compareTo(BigDecimal.ZERO) > 0 ? yxjzBase.subtract(yxBaseData).multiply(yxjzbi):BigDecimal.ZERO; }
				else{ yxjzMoney = bingzhongMap.get("yx"); }
				
				if(bingzhongMap.get("yz") == null){ yzMoney = yzBase.subtract(yzBaseData).compareTo(BigDecimal.ZERO) > 0 ? yzBase.subtract(yzBaseData).multiply(yzbi):BigDecimal.ZERO;  }
				else{ yzMoney = bingzhongMap.get("yz"); }
				
				if(bingzhongMap.get("knw") == null){ knwMoney = knwBase.subtract(knwBaseData).compareTo(BigDecimal.ZERO) > 0 ? knwBase.subtract(knwBaseData).multiply(knwbi):BigDecimal.ZERO;  }
				else{ knwMoney = bingzhongMap.get("knw"); }
				
				if(bingzhongMap.get("xf") == null){ xfMoney = xfBase.subtract(xfBaseData).compareTo(BigDecimal.ZERO) > 0 ? xfBase.subtract(xfBaseData).multiply(xfbi):BigDecimal.ZERO;  }
				else{ xfMoney = bingzhongMap.get("xf"); }
				
				if(bingzhongMap.get("ey") == null){ eyMoney = eyBase.subtract(eyBaseData).compareTo(BigDecimal.ZERO) > 0 ? eyBase.subtract(eyBaseData).multiply(eybi):BigDecimal.ZERO; }
				else{ eyMoney = bingzhongMap.get("ey"); }
				 
			}
			//����Ҳ����ҽ������
			if(bingzhongMap.get("mb") == null){ mbMoney = mb.subtract(mbcb).compareTo(BigDecimal.ZERO) > 0 ? mb.subtract(mbcb).multiply(mbbi):mb.subtract(mbcb).multiply(mbbi);  }
			else{  eyMoney = bingzhongMap.get("mb"); }
			
			
			money = zzMoney.add(gdjzMoney).add(yxjzMoney).add(yzMoney).add(knwMoney).add(xfMoney).add(eyMoney).add(mbMoney).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
	   
			 
			insertSql += ",cfsumachieve, CFZZmoney, CFGDJZmoney, CFYXJZmoney, CFYZmoney, CFKNWmoney, CFMBmoney, CFXFmoney, CFEYmoney ";
			insertValueSql += " ,"+sumAchieve+", "+zzMoney+" ,"+gdjzMoney+","+yxjzMoney+" " +
				" ,"+yzMoney+" ,"+knwMoney+" ,"+mbMoney+" "+
				" ,"+xfMoney+" ,"+eyMoney+" ";
			docMap.put("EXISTS", "NO");
			docMap.put("JIANGJIN", money+"");
			docMap.put("mbMoney", mbMoney+"");
			docMap.put("COST", costAll.toString());
		  	
		}
		//��ְҽ��
		if((null == tempMap) || (null == tempMap.get(empNum+"_JZDOC"))){
			
		}else{
			//��ͨ��ְҽ��
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
				
				/*HashMap tongyongmap = (HashMap)tempMap.get("TONGYONGBILI_DOC");
				freeWorkPro = new BigDecimal(tongyongmap.get("CFFREEWORKPRO").toString());  
				firSourcePro = new BigDecimal(tongyongmap.get("CFSOURCEPRO").toString());  
				firSource = tongyongmap.get("CFFIRSTSOURCE").toString(); 
				gifAmountPro =  new BigDecimal(tongyongmap.get("CFGIFAMOUNTPRO").toString());*/
				
				//��ְҽ���������� �Դ��ͷ��Դ� 

				// �鿴��û�д�ҽ�����Դ�ҵ��
				
				String dateSql = "";
				if(type.equals("ZC")){
					dateSql = "  to_char(fbizdate, 'yyyymm') = '"+periodnum+"' and  ";
				}else if(type.equals("CBQR")){
					dateSql = "  CFBUSINESSDATE = '"+periodnum+"' and  (cfisneedout = 0 or ( cfisneedout=1 and cfisout = 1))  and  ";
				}
				
				BigDecimal bymoney = BigDecimal.ZERO;
				String haveZidaisql = " /*dialect*/ select count(1) as thisnum from  CT_PAY_AchieveDetailTem where  "+dateSql+"   CFRecDotNumber ='"+empNum+"' and cfclinicnumber='"+clinicNumber+"' and CFFIRSOURCE  not in ('��ͳ�ƹ�','����ƽ̨','�����ƹ�','�����ƹ�','���ת��')    and CFCityNumber='"+cityNumber+"' ";
				
				IRowSet haveZidairs = com.kingdee.eas.custom.util.DBUtil.executeQuery(ctx,haveZidaisql.toString());
				if(haveZidairs!=null && haveZidairs.size() > 0){
					 while(haveZidairs.next()){	
						 int num= haveZidairs.getInt("THISNUM");
						 if(num > 0){
							 bymoney = docZiDai(ctx ,map,empNum,  cityNumber, periodnum,  clinicNumber,clinicName ,tempMap,cityId,firSource,firSourcePro,freeWorkPro,gifAmountPro ,calType,type
									 , oneItemMap, twoItemMap, threeItemMap);
						 }
					 }
					 
				}
				
				String empName = map.get("CFDOCNAME").toString();
				

				StringBuffer sqlImportYJ = new StringBuffer(); 
				sqlImportYJ = getSHYeJiImpSql( empNum, clinicNumber, cityNumber, periodnum, sqlImportYJ, cityId,zjbl);
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
				  		
				  	    //������ֲ
						imzz = yjImprs.getBigDecimal("ZZ");
						//����̶�����
						imgdjz =yjImprs.getBigDecimal("GDJZ");
						//�������ν���
						imyxjz = yjImprs.getBigDecimal("YXJZ");
						//��������
						imyz = yjImprs.getBigDecimal("YZ");
						//���������
						imknw = yjImprs.getBigDecimal("KNW");
						//��������
						immb = yjImprs.getBigDecimal("MB");
						//�����޸�
						imxf = yjImprs.getBigDecimal("XF");
						//�������
						imey = yjImprs.getBigDecimal("EY"); 
					}
				}
			  	BigDecimal nofreeClinic = BigDecimal.ZERO;
			  	nofreeClinic = zz.add(gdjz).add(yxjz).add(knw).add(xf).add(ey);
			    //�ټ�����Դ����ߵ�
				StringBuffer sqlFZD = new StringBuffer(); 
				sqlFZD = getSHFeiZiDaiSql(empNum,clinicNumber,periodnum,cityId,cityNumber,firSource,firSourcePro,freeWorkPro,gifAmountPro,type
						, oneItemMap, twoItemMap,  threeItemMap );
				System.out.println(sqlFZD);
				IRowSet yjrs = com.kingdee.eas.custom.util.DBUtil.executeQuery(ctx,sqlFZD.toString());
				if(yjrs!=null && yjrs.size() > 0){ 
				  	while(yjrs.next()){	
				  		if("zz".equals(yjrs.getString("TYPE"))){//��ֲ 
				  			zz = zz.add(new BigDecimal(yjrs.getString("SUMAMOUNT")));  
				  			imandxtinsertsql += ", CFXTZZACHIEVE ";
				  			imandxtinsertValueSql += ","+new BigDecimal(yjrs.getString("SUMAMOUNT"))+"";
				  			 
				  			nofreeClinic = nofreeClinic.add(new BigDecimal(yjrs.getString("SUMAMOUNT")));
				  			
				  		}else if("gd".equals(yjrs.getString("TYPE"))){//�̶����� ��
				  			gdjz= gdjz.add(new BigDecimal(yjrs.getString("SUMAMOUNT"))); 
				  			imandxtinsertsql += ", CFXTGDJZACHIEVE ";
				  			imandxtinsertValueSql += ","+new BigDecimal(yjrs.getString("SUMAMOUNT"))+"";
				  			 
				  			nofreeClinic = nofreeClinic.add(new BigDecimal(yjrs.getString("SUMAMOUNT")));
				  		}else if("yx".equals(yjrs.getString("TYPE"))){//���ν���
				  			yxjz= yxjz.add(new BigDecimal(yjrs.getString("SUMAMOUNT"))); 
				  			imandxtinsertsql += ", cfXTyxjzachieve ";
				  			imandxtinsertValueSql += ","+new BigDecimal(yjrs.getString("SUMAMOUNT"))+"";
				  			 
				  			nofreeClinic = nofreeClinic.add(new BigDecimal(yjrs.getString("SUMAMOUNT")));
				  		}else if("yz".equals(yjrs.getString("TYPE"))){//����  
				  			mb= mb.add(new BigDecimal(yjrs.getString("SUMAMOUNT"))); 
				  			imandxtinsertsql += ", CFXTmbAchieve ";
				  			imandxtinsertValueSql += ","+new BigDecimal(yjrs.getString("SUMAMOUNT"))+"";
				  		}else if("knw".equals(yjrs.getString("TYPE"))){//������ ��
				  			knw = knw.add(new BigDecimal(yjrs.getString("SUMAMOUNT"))); 
				  			imandxtinsertsql += ", cfXTknwachieve ";
				  			imandxtinsertValueSql += ","+new BigDecimal(yjrs.getString("SUMAMOUNT"))+"";
				  			 
				  			nofreeClinic = nofreeClinic.add(new BigDecimal(yjrs.getString("SUMAMOUNT")));
				  		}else if("xf".equals(yjrs.getString("TYPE"))){//�޸�
				  			xf= xf.add(new BigDecimal(yjrs.getString("SUMAMOUNT")));  
				  			imandxtinsertsql += ", cfXTxfachieve ";
				  			imandxtinsertValueSql += ","+new BigDecimal(yjrs.getString("SUMAMOUNT"))+"";
				  			 
				  			nofreeClinic = nofreeClinic.add(new BigDecimal(yjrs.getString("SUMAMOUNT")));
				  		}else if("ey".equals(yjrs.getString("TYPE"))){//����
				  			ey= ey.add(new BigDecimal(yjrs.getString("SUMAMOUNT"))); 
				  			imandxtinsertsql += ", cfXTeyachieve ";
				  			imandxtinsertValueSql += ","+new BigDecimal(yjrs.getString("SUMAMOUNT"))+"";
				  			 
				  			nofreeClinic = nofreeClinic.add(new BigDecimal(yjrs.getString("SUMAMOUNT")));
				  		}else if("freezz".equals(yjrs.getString("TYPE"))){//��ֲ 
				  			zz = zz.add(new BigDecimal(yjrs.getString("SUMAMOUNT"))); 
				  			imandxtinsertsql += ", CFfreeZZACHIEVE ";
				  			imandxtinsertValueSql += ","+new BigDecimal(yjrs.getString("SUMAMOUNT"))+"";
				  		}else if("freegd".equals(yjrs.getString("TYPE"))){//�̶����� ��
				  			gdjz= gdjz.add(new BigDecimal(yjrs.getString("SUMAMOUNT"))); 
				  			imandxtinsertsql += ", CFfreeGDJZACHIEVE ";
				  			imandxtinsertValueSql += ","+new BigDecimal(yjrs.getString("SUMAMOUNT"))+"";
				  		}else if("freeyx".equals(yjrs.getString("TYPE"))){//���ν���
				  			yxjz= yxjz.add(new BigDecimal(yjrs.getString("SUMAMOUNT"))); 
				  			imandxtinsertsql += ", CFfreeyxjzachieve ";
				  			imandxtinsertValueSql += ","+new BigDecimal(yjrs.getString("SUMAMOUNT"))+"";
				  		}else if("freeyz".equals(yjrs.getString("TYPE"))){//����  
//				  			mb= mb.add(new BigDecimal(yjrs.getString("SUMAMOUNT")));  
//				  			imandxtinsertsql += ", CFfreembAchieve ";
//				  			imandxtinsertValueSql += ","+new BigDecimal(yjrs.getString("SUMAMOUNT"))+""; 
			  			
				  		    //��������û���⹤����
				  			imandxtinsertsql += ", CFfreembAchieve ";
				  			imandxtinsertValueSql += ", 0 "; 
				  		}else if("freeknw".equals(yjrs.getString("TYPE"))){//������ ��
				  			knw = knw.add(new BigDecimal(yjrs.getString("SUMAMOUNT")));  
				  			imandxtinsertsql += ",CFfreeknwachieve ";
				  			imandxtinsertValueSql += ","+new BigDecimal(yjrs.getString("SUMAMOUNT"))+"";
				  		}else if("freexf".equals(yjrs.getString("TYPE"))){//�޸�
				  			xf= xf.add(new BigDecimal(yjrs.getString("SUMAMOUNT")));  
				  			imandxtinsertsql += ", CFfreexfachieve ";
				  			imandxtinsertValueSql += ","+new BigDecimal(yjrs.getString("SUMAMOUNT"))+""; 
				  		}else if("freeey".equals(yjrs.getString("TYPE"))){//����
				  			ey= ey.add(new BigDecimal(yjrs.getString("SUMAMOUNT")));  
				  			imandxtinsertsql += ", CFfreeeyachieve ";
				  			imandxtinsertValueSql += ","+new BigDecimal(yjrs.getString("SUMAMOUNT"))+"";
				  		}  
				  		
					}
				} 
				
				
			  	
				//��� ����ĳɱ�
				StringBuffer sqlImportCB = new StringBuffer(); 
				sqlImportCB = getImportChengBenSql( empNum,clinicNumber,  cityId, periodnum, sqlImportCB);
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
				sqlHushiCB = getSHHushiChengBenSql( empNum, clinicNumber, cityNumber, periodnum, sqlHushiCB);
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
				sqlCB = getSHChengBenSql( empNum,clinicNumber,  cityNumber, periodnum, sqlCB);
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
				
				
				if(calType != null  && calType.equals("zskc")){
					
					//������ۿ�  
					//�������   �൱�������и�    �����ܺ�  �п��ܴ���0  Ҳ�п���С��0  ���滹�����и�
					HashMap<String,BigDecimal> allMap =  setJingWork( zz, zzcb, gdjz, gdjzcb, yxjz, yxjzcb, yz, yzcb, knw, knwcb, xf, xfcb, ey, eycb,  biliMap, calType);
					String nextPeriod  = getNextPeriod( periodnum);
					
					if(DoctorCostsFactory.getLocalInstance(ctx).exists("where BusinessDate='"+nextPeriod+"' and city = '"+cityId+"' and EmpNumber='"+empNum+"' and CostType='yk'  and (Description is null or Description!='��̯�۳�ҵ��') ")){
						DoctorCostsFactory.getLocalInstance(ctx).delete("where BusinessDate='"+nextPeriod+"' and city = '"+cityId+"' and EmpNumber='"+empNum+"' and CostType='yk' and (Description is null or Description!='��̯�۳�ҵ��')  "); 
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
					}else if(allMap.get("all").compareTo(BigDecimal.ZERO) <0 ){//����Ǹ���  ˵��û������
						
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
					 
					
					if(DocAchieveUpdateFactory.getLocalInstance(ctx).exists("where BusinessDate='"+periodnum+"' and city = '"+cityId+"' and docNumber='"+empNum+"'   and Name='��̯�۳�ҵ��' ")){
						DocAchieveUpdateFactory.getLocalInstance(ctx).delete("where BusinessDate='"+periodnum+"' and city = '"+cityId+"' and docNumber='"+empNum+"'   and Name='��̯�۳�ҵ��' "); 
					} 
					DocAchieveUpdateInfo docAchieveUpdateThis =new DocAchieveUpdateInfo();
					docAchieveUpdateThis.setBusinessDate(periodnum); 
					ctrlUnitInfo.setId(BOSUuid.read(cityId));
					docAchieveUpdateThis.setCity(ctrlUnitInfo);
					docAchieveUpdateThis.setCityNumber(cityNumber);
					
					docAchieveUpdateThis.setClinic(orgUnit);
					docAchieveUpdateThis.setClinicName(orgUnit.getName()); 
					docAchieveUpdateThis.setClinicNumber(orgUnit.getNumber()); 
					docAchieveUpdateThis.setDocNumber(empNum);
					docAchieveUpdateThis.setDocName(tempMap.get("empName").toString()); 
					docAchieveUpdateThis.setName("��̯�۳�ҵ��");  
					boolean flag = false;
					if(null != allMap.get("negzz")){
						//clinicCostSumInfo.setImzzCost(clinicCostSumInfo.getImzzCost().add(allMap.get("negzz")));
						docAchieveUpdateThis.setZzAchieve(allMap.get("negzz").negate());
						imzz = imzz.add(allMap.get("negzz").negate());
						
						zz = zz.add(allMap.get("negzz").negate());
						
						nofreeClinic = nofreeClinic.add(allMap.get("negzz").negate());
						
						flag = true;
					}
					if(null != allMap.get("neggdjz")){
						//clinicCostSumInfo.setImgdjzCost(clinicCostSumInfo.getImgdjzCost().add(allMap.get("neggdjz")));
						docAchieveUpdateThis.setGdjzAchieve(allMap.get("neggdjz").negate());
						imgdjz = imgdjz.add(allMap.get("neggdjz").negate());
						
						gdjz = gdjz.add(allMap.get("neggdjz").negate());

						nofreeClinic = nofreeClinic.add(allMap.get("neggdjz").negate());
						
						flag = true;
					}
					if(null != allMap.get("negyxjz")){
						//clinicCostSumInfo.setImyxjzCost(clinicCostSumInfo.getImyxjzCost().add(allMap.get("negyxjz")));
						docAchieveUpdateThis.setYxjzAchieve(allMap.get("negyxjz").negate());
						imyxjz = imyxjz.add(allMap.get("negyxjz").negate());
						
						yxjz = yxjz.add(allMap.get("negyxjz").negate());
						
						nofreeClinic = nofreeClinic.add(allMap.get("negyxjz").negate());
						
						flag = true;
					}
					if(null != allMap.get("negyz")){
						//clinicCostSumInfo.setImyzCost(clinicCostSumInfo.getImyzCost().add(allMap.get("negyz")));
						docAchieveUpdateThis.setYzAchieve(allMap.get("negyz").negate());
						imyz = imyz.add(allMap.get("negyz").negate());
						
						yz = yz.add(allMap.get("negyz").negate());
						flag = true;
					}
					if(null != allMap.get("negknw")){
						//clinicCostSumInfo.setImknwCost(clinicCostSumInfo.getImknwCost().add(allMap.get("negknw")));
						docAchieveUpdateThis.setKnwAchieve(allMap.get("negknw"));
						imknw = imknw.add(allMap.get("negknw").negate());
						
						knw = knw.add(allMap.get("negknw").negate());
						nofreeClinic = nofreeClinic.add(allMap.get("negknw").negate());
						
						flag = true;
					}
					if(null != allMap.get("negxf")){
						//clinicCostSumInfo.setImxfCost(clinicCostSumInfo.getImxfCost().add(allMap.get("negxf")));
						docAchieveUpdateThis.setXfAchieve(allMap.get("negxf").negate());
						imxf = imxf.add(allMap.get("negxf").negate());
						
						xf = xf.add(allMap.get("negxf").negate());
						nofreeClinic = nofreeClinic.add(allMap.get("negxf").negate());
						flag = true;
					}
					if(null != allMap.get("negey")){
						//clinicCostSumInfo.setImeyCost(clinicCostSumInfo.getImeyCost().add(allMap.get("negey")));
						docAchieveUpdateThis.setEyAchieve(allMap.get("negey").negate());
						imey = imey.add(allMap.get("negey").negate());
						
						ey = ey.add(allMap.get("negey").negate()); 
						
						nofreeClinic = nofreeClinic.add(allMap.get("negey").negate());
						flag = true;
					}
					if(flag){
						DocAchieveUpdateFactory.getLocalInstance(ctx).save(docAchieveUpdateThis);
					}
				}else{//�������ӿ� 
					zzBase = zz.subtract(zzcb).compareTo(BigDecimal.ZERO)<0?BigDecimal.ZERO:zz.subtract(zzcb);
					gdjzBase = gdjz.subtract(gdjzcb).compareTo(BigDecimal.ZERO)<0?BigDecimal.ZERO:gdjz.subtract(gdjzcb);
					yxjzBase = yxjz.subtract(yxjzcb).compareTo(BigDecimal.ZERO)<0?BigDecimal.ZERO:yxjz.subtract(yxjzcb);
					yzBase = yz.subtract(yzcb).compareTo(BigDecimal.ZERO)<0?BigDecimal.ZERO:yz.subtract(yzcb);
					knwBase = knw.subtract(knwcb).compareTo(BigDecimal.ZERO)<0?BigDecimal.ZERO:knw.subtract(knwcb);
					//BigDecimal mbBase = mb.subtract(mbcb).compareTo(BigDecimal.ZERO)<0?BigDecimal.ZERO:mb.subtract(mbcb);
					xfBase = xf.subtract(xfcb).compareTo(BigDecimal.ZERO)<0?BigDecimal.ZERO:xf.subtract(xfcb);
					eyBase = ey.subtract(eycb).compareTo(BigDecimal.ZERO)<0?BigDecimal.ZERO:ey.subtract(eycb); 
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
				 
				costAll = costAll.add(clinicCostSumInfo.getAllzzCost()).add(clinicCostSumInfo.getAllgdjzCost())
				.add(clinicCostSumInfo.getAllyxjzCost()).add(clinicCostSumInfo.getAllyzCost())
				.add(clinicCostSumInfo.getAllknwCost()).add(clinicCostSumInfo.getAllmbCost())
				.add(clinicCostSumInfo.getAllxfCost()).add(clinicCostSumInfo.getAlleyCost()); 
				
				insertSql +=  ", cfzzcost , cfgdjzcost , cfyxjzcost , cfyzcost , cfknwcost , cfmbcost , cfxfcost , cfeycost  ";
				insertValueSql += " ,"+clinicCostSumInfo.getAllzzCost()+" ,"+clinicCostSumInfo.getAllgdjzCost()
					+" ,"+clinicCostSumInfo.getAllyxjzCost()+" ,"+clinicCostSumInfo.getAllyzCost() 
					+" ,"+clinicCostSumInfo.getAllknwCost()+" ,"+clinicCostSumInfo.getAllmbCost()
					+" ,"+clinicCostSumInfo.getAllxfCost()+" ,"+clinicCostSumInfo.getAlleyCost();
				
				BigDecimal sumAchieve =  zz.add(gdjz).add(yxjz).add(yz).add(knw).add(mb).add(xf).add(ey);  
				if(sumAchieve.compareTo(BigDecimal.ZERO) <= 0){
					insertSql +=  ", CFZZpro , CFGDpro , cfyxpro, CFyzpro , cfknwpro , cfmbpro , cfxfpro, cfeypro  ";
					insertValueSql +=" ,0 ,0,0,0,0,0,0,0 ";
				}else{
					insertSql +=  ", CFZZpro , CFGDpro , cfyxpro, CFyzpro , cfknwpro , cfmbpro , cfxfpro, cfeypro  ";
					insertValueSql +=" ,"+zz.divide(sumAchieve,6, BigDecimal.ROUND_HALF_UP)+" ,"+gdjz.divide(sumAchieve,6, BigDecimal.ROUND_HALF_UP)+
					","+yxjz.divide(sumAchieve,6, BigDecimal.ROUND_HALF_UP)+","+0+
					","+knw.divide(sumAchieve,6, BigDecimal.ROUND_HALF_UP)+","+0+
					","+xf.divide(sumAchieve,6, BigDecimal.ROUND_HALF_UP)+","+ey.divide(sumAchieve,6, BigDecimal.ROUND_HALF_UP)+" ";
				}
				
				

				
				BigDecimal allBase = zzBase.add(gdjzBase).add(yxjzBase).add(yzBase).add(knwBase).add(xfBase).add(eyBase);
				
				//allBase = docAchieve; 
				
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
					//yzMoney = yzBase.subtract(docBase.multiply(yzBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP))).compareTo(BigDecimal.ZERO) > 0 ? yzBase.subtract(docBase.multiply(yzBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP))).multiply(yzbi):BigDecimal.ZERO;
					knwMoney = knwBase.subtract(docBase.multiply(knwBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP))).compareTo(BigDecimal.ZERO) > 0 ? knwBase.subtract(docBase.multiply(knwBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP))).multiply(knwbi):BigDecimal.ZERO;
					 
					xfMoney = xfBase.subtract(docBase.multiply(xfBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP))).compareTo(BigDecimal.ZERO) > 0 ? xfBase.subtract(docBase.multiply(xfBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP))).multiply(xfbi):BigDecimal.ZERO;
					eyMoney = eyBase.subtract(docBase.multiply(eyBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP))).compareTo(BigDecimal.ZERO) > 0 ? eyBase.subtract(docBase.multiply(eyBase.divide(allBase,6, BigDecimal.ROUND_HALF_UP))).multiply(eybi):BigDecimal.ZERO;
					
				}
				//����Ҳ����ҽ������
				mbMoney = mb.subtract(mbcb).compareTo(BigDecimal.ZERO) > 0 ? mb.subtract(mbcb).multiply(mbbi):mb.subtract(mbcb).multiply(mbbi); 
				BigDecimal noybyMoney = zzMoney.add(gdjzMoney).add(yxjzMoney).add(yzMoney).add(knwMoney).add(xfMoney).add(eyMoney).add(mbMoney).setScale(2,BigDecimal.ROUND_HALF_UP);
				 
				
				
				insertSql += ",cfsumachieve, CFZZmoney, CFGDJZmoney, CFYXJZmoney, CFYZmoney, CFKNWmoney, CFMBmoney, CFXFmoney, CFEYmoney ";
				insertValueSql += " ,"+nofreeClinic+", "+zzMoney+" ,"+(gdjzMoney)+","+(yxjzMoney)+" " +
					" ,"+(yzMoney)+" ,"+(knwMoney)+" ,"+(mbMoney)+" "+
					" ,"+xfMoney+" ,"+(eyMoney)+" ";
				docMap.put("EXISTS", "NO");
				docMap.put("mbMoney", mbMoney+"");
				docMap.put("JIANGJIN", bymoney.add(noybyMoney)+"");
				docMap.put("COST", costAll.toString()); 
			  	
				
			}
		}
		docMap.put("INSERTSQL",insertSql);
		docMap.put("INSERTVALUESQL",insertValueSql); 
		ClinicCostSumFactory.getLocalInstance(ctx).save(clinicCostSumInfo);
		docMap.put("imandxtinsertsql",imandxtinsertsql);
		docMap.put("imandxtinsertValueSql",imandxtinsertValueSql);  
		return docMap;
	}
	
	public static StringBuffer getSHPTDocAchieve(String empNum, String clinicNumber,String periodnum,String cityId,String cityNumber,String firSource,BigDecimal firSourcePro ,BigDecimal freeWorkPro,BigDecimal gifAmountPro,String type){
		
		
		String dateSql = "";
		if(type.equals("ZC")){
			dateSql = "  to_char(fbizdate, 'yyyymm') = '"+periodnum+"' and  ";
		}else if(type.equals("CBQR")){
			dateSql = "  CFBUSINESSDATE = '"+periodnum+"' and  (cfisneedout = 0 or ( cfisneedout=1 and cfisout = 1))  and  ";
		}
		
		
		StringBuffer sqlYJ = new StringBuffer(); 
		//��ֲ�⹤����ҵ��
		sqlYJ.append("  /*dialect*/select sum(amount) as sumamount , 'freezz' as type from ( select    (nvl(sum(cfdocachieve),0)) as amount  from  CT_PAY_AchieveDetailTem  where "+dateSql+" cfrecdotnumber = '"+empNum+"'  and  cfclinicnumber ='"+clinicNumber+"'  and cfincome  =0  and  cfpayment =0 and cffirclassNumber ='3'   and cfiscount= 1 and cfbusitype = '�Һ�����' ) ").append("\r\n")
		 //��ֲ���⹤����ҵ��
		.append(" union select sum(amount) as sumamount , 'zz' as type from ( select    (nvl(sum(cfdocachieve),0)) as amount  from  CT_PAY_AchieveDetailTem where   "+dateSql+" cfrecdotnumber = '"+empNum+"'  and  cfclinicnumber ='"+clinicNumber+"'   and (cfincome!=0 or cfpayment!=0) and cffirclassNumber ='3'  and cfiscount= 1 ) ").append("\r\n")
		
		//�����⹤����
		.append(" union select sum(amount) as sumamount , 'freeyx' as type from ( select    (nvl(sum(cfdocachieve),0)) as amount  from  CT_PAY_AchieveDetailTem  where "+dateSql+" cfrecdotnumber = '"+empNum+"'  and  cfclinicnumber ='"+clinicNumber+"'   and cfincome  =0  and  cfpayment =0 and cffirclassNumber ='4' and CFISROUTINE = '��'   and cfbusitype = '�Һ�����'  and cfiscount= 1 )").append("\r\n")
		//���η��⹤����ҵ��
		.append(" union select sum(amount) as sumamount , 'yx' as type from ( select    (nvl(sum(cfdocachieve),0)) as amount  from  CT_PAY_AchieveDetailTem  where "+dateSql+"cfrecdotnumber = '"+empNum+"'  and  cfclinicnumber ='"+clinicNumber+"'   and (cfincome!=0 or cfpayment!=0) and cffirclassNumber ='4' and CFISROUTINE = '��'    and cfiscount= 1 ) ").append("\r\n")
		
		//�����⹤����
		.append(" union select sum(amount) as sumamount , 'freegd' as type from ( select    (nvl(sum(cfdocachieve),0)) as amount  from  CT_PAY_AchieveDetailTem  where "+dateSql+" cfrecdotnumber = '"+empNum+"'  and  cfclinicnumber ='"+clinicNumber+"'  and cfincome  =0  and  cfpayment =0 and cffirclassNumber ='4' and CFISROUTINE = '��'  and cfbusitype = '�Һ�����'  and cfiscount= 1 )").append("\r\n")
		//������⹤����ҵ��
		.append(" union select sum(amount) as sumamount , 'gd' as type from ( select    (nvl(sum(cfdocachieve),0)) as amount  from  CT_PAY_AchieveDetailTem  where "+dateSql+" cfrecdotnumber = '"+empNum+"'  and  cfclinicnumber ='"+clinicNumber+"'  and (cfincome!=0 or cfpayment!=0) and cffirclassNumber ='4' and CFISROUTINE = '��'  and cfiscount= 1 )  ").append("\r\n")
		//�������⹤����
		.append(" union select sum(amount) as sumamount , 'freeknw' as type from ( select  (nvl(sum(cfdocachieve),0)) as amount  from  CT_PAY_AchieveDetailTem  where "+dateSql+" cfrecdotnumber = '"+empNum+"'  and  cfclinicnumber ='"+clinicNumber+"'  and cfincome  =0  and  cfpayment =0 and cffirclassNumber ='1'  and cfbusitype = '�Һ�����'  and cfiscount= 1 )") .append("\r\n")
		//��������⹤����ҵ��
		.append(" union select sum(amount) as sumamount , 'knw' as type from ( select  (nvl(sum(cfdocachieve),0)) as amount  from  CT_PAY_AchieveDetailTem  where "+dateSql+" cfrecdotnumber = '"+empNum+"'  and  cfclinicnumber ='"+clinicNumber+"'  and (cfincome!=0 or cfpayment!=0) and cffirclassNumber ='1'  and cfiscount= 1 )").append("\r\n")
		  
		//�����⹤����
		.append(" union select sum(amount) as sumamount , 'freeey' as type from ( select  (nvl(sum(cfdocachieve),0))as amount  from  CT_PAY_AchieveDetailTem  where "+dateSql+" cfrecdotnumber = '"+empNum+"'  and  cfclinicnumber ='"+clinicNumber+"'  and cfincome  =0  and  cfpayment =0 and cffirclassNumber ='6'  and cfbusitype = '�Һ�����'  and cfiscount= 1 )") .append("\r\n")
		//�������⹤����ҵ��
		.append(" union select sum(amount) as sumamount , 'ey' as type from ( select  (nvl(sum(cfdocachieve),0)) as amount  from  CT_PAY_AchieveDetailTem  where "+dateSql+" cfrecdotnumber = '"+empNum+"'  and  cfclinicnumber ='"+clinicNumber+"'  and (cfincome!=0 or cfpayment!=0) and cffirclassNumber ='6'  and cfiscount= 1 )").append("\r\n")
		 
		//�޸��⹤����
		.append(" union select sum(amount) as sumamount , 'freexf' as type from ( select  (nvl(sum(cfdocachieve),0)) as amount  from  CT_PAY_AchieveDetailTem  where "+dateSql+" cfrecdotnumber = '"+empNum+"'  and  cfclinicnumber ='"+clinicNumber+"'  and cfincome  =0  and  cfpayment =0 and cffirclassNumber ='2'  and cfbusitype = '�Һ�����'   and cfiscount= 1 )") .append("\r\n")
		//�޸����⹤����ҵ��
		.append(" union select sum(amount) as sumamount , 'xf' as type from ( select  (nvl(sum(cfdocachieve),0)) as amount  from  CT_PAY_AchieveDetailTem  where "+dateSql+" cfrecdotnumber = '"+empNum+"'  and  cfclinicnumber ='"+clinicNumber+"'  and (cfincome!=0 or cfpayment!=0) and cffirclassNumber ='2'  and cfiscount= 1  )").append("\r\n")
		
		//�����⹤����    ���ܣ�һ����������������ף����������������ơ����⣺ȫ��ҽ��    ����������������ף������շ����һ��������н��ﻤʿ������ﻤʿ���������ҽ��
		//
//		.append(" union  select sum(amount) as sumamount , 'freeyz' as type from ( select nvl(sum(cforiprice*cfqty)*"+freeWorkPro+",0) as amount  from  CT_PAY_AchieveDetailTem  where "+dateSql+"  cfrecdotnumber = '"+empNum+"'  and  cfclinicnumber ='"+clinicNumber+"'  and cfincome  =0  and  cfpayment =0 and cffirclassNumber ='7' and cfbusitype = '�Һ�����'  and cfiscount= 1 and   ").append("\r\n")
//		.append(" ( EXISTS (SELECT  1  FROM  CT_SRQ_ItemCheck bill  inner join CT_SRQ_ItemCheckEntry entry on entry.fparentid = bill.fid  left JOIN  CT_SRQ_Paytypeitem  second on second.fid = entry.cfseconditemid   where cfcityid = '"+cityId+"' and  cftypenumber = 'YZ' and second.fnumber = CT_PAY_AchieveDetailTem.CFSECCLASSNUMBER ) or  EXISTS (SELECT  1  FROM  CT_SRQ_ItemCheck bill  inner join CT_SRQ_ItemCheckEntry entry on entry.fparentid = bill.fid left JOIN  CT_SRQ_PayItem  item on  item.fid = entry.cfitemid  where cfcityid = '"+cityId+"' and  cftypenumber = 'YZ' and item.fnumber = CT_PAY_AchieveDetailTem.CFFEEITEMDETAILNUMBER ) ) ").append("\r\n")
//		.append(" union select nvl(sum(cforiprice*cfqty)*"+freeWorkPro+",0) as amount  from  CT_PAY_AchieveDetailTem  where "+dateSql+" cfrecdotnumber = '"+empNum+"'  and  cfclinicnumber ='"+clinicNumber+"'  and cfincome  =0  and  cfpayment =0 and cffirclassNumber ='7'  and cfbusitype = '�Һ�����'  and cfiscount= 1 and  not EXISTS ( SELECT 1 FROM  CT_PAY_PayPost  paypost where paypost.cfcityid = '"+cityId+"' and paypost.cfbusinessdate = '"+periodnum+"' and cfpostnumber ='HS' AND CFSTATUS = 'qy' and paypost.cfempnumber = CT_PAY_AchieveDetailTem.CFNURSENUMBER  )  and  ").append("\r\n")
//		.append(" ( EXISTS (SELECT  1  FROM  CT_SRQ_ItemCheck bill  inner join CT_SRQ_ItemCheckEntry entry on entry.fparentid = bill.fid  left JOIN  CT_SRQ_Paytypeitem  second on second.fid = entry.cfseconditemid   where cfcityid = '"+cityId+"' and  cftypenumber in ('JY','MB')  and second.fnumber = CT_PAY_AchieveDetailTem.CFSECCLASSNUMBER ) or  EXISTS (SELECT  1  FROM  CT_SRQ_ItemCheck bill  inner join CT_SRQ_ItemCheckEntry entry on entry.fparentid = bill.fid left JOIN  CT_SRQ_PayItem  item on  item.fid = entry.cfitemid  where cfcityid = '"+cityId+"' and  cftypenumber in ('JY','MB') and item.fnumber = CT_PAY_AchieveDetailTem.CFFEEITEMDETAILNUMBER ) ) )").append("\r\n")
//		
//		//���ܷ��⹤����ҵ��
//		.append(" union select sum(amount) as sumamount , 'yz' as type from ( select (nvl(sum(cfpayment),0)-(nvl(sum(cfgiftpayment),0)*"+gifAmountPro+")) as amount  from  CT_PAY_AchieveDetailTem  where "+dateSql+" cfrecdotnumber = '"+empNum+"'  and  cfclinicnumber ='"+clinicNumber+"'  and (cfincome!=0 or cfpayment!=0) and cffirclassNumber ='7'   and cfiscount= 1  and   ").append("\r\n")
//		.append(" ( EXISTS (SELECT  1  FROM  CT_SRQ_ItemCheck bill  inner join CT_SRQ_ItemCheckEntry entry on entry.fparentid = bill.fid  left JOIN  CT_SRQ_Paytypeitem  second on second.fid = entry.cfseconditemid   where cfcityid = '"+cityId+"' and  cftypenumber = 'YZ' and second.fnumber = CT_PAY_AchieveDetailTem.CFSECCLASSNUMBER ) or  EXISTS (SELECT  1  FROM  CT_SRQ_ItemCheck bill  inner join CT_SRQ_ItemCheckEntry entry on entry.fparentid = bill.fid left JOIN  CT_SRQ_PayItem  item on  item.fid = entry.cfitemid  where cfcityid = '"+cityId+"' and  cftypenumber = 'YZ' and item.fnumber = CT_PAY_AchieveDetailTem.CFFEEITEMDETAILNUMBER ) ) ").append("\r\n")
//		.append(" union select (nvl(sum(cfpayment),0)-(nvl(sum(cfgiftpayment),0)*"+gifAmountPro+")) as amount  from  CT_PAY_AchieveDetailTem  where "+dateSql+" cfrecdotnumber = '"+empNum+"'  and  cfclinicnumber ='"+clinicNumber+"'  and (cfincome!=0 or cfpayment!=0) and cffirclassNumber ='7'  and cfiscount= 1  and  not EXISTS ( SELECT 1 FROM  CT_PAY_PayPost  paypost where paypost.cfcityid = '"+cityId+"' and paypost.cfbusinessdate = '"+periodnum+"' and cfpostnumber ='HS' AND CFSTATUS = 'qy' and paypost.cfempnumber = CT_PAY_AchieveDetailTem.CFNURSENUMBER  )  and  ").append("\r\n")
//		.append(" ( EXISTS (SELECT  1  FROM  CT_SRQ_ItemCheck bill  inner join CT_SRQ_ItemCheckEntry entry on entry.fparentid = bill.fid  left JOIN  CT_SRQ_Paytypeitem  second on second.fid = entry.cfseconditemid   where cfcityid = '"+cityId+"' and  cftypenumber in ('JY','MB')  and second.fnumber = CT_PAY_AchieveDetailTem.CFSECCLASSNUMBER ) or  EXISTS (SELECT  1  FROM  CT_SRQ_ItemCheck bill  inner join CT_SRQ_ItemCheckEntry entry on entry.fparentid = bill.fid left JOIN  CT_SRQ_PayItem  item on  item.fid = entry.cfitemid  where cfcityid = '"+cityId+"' and  cftypenumber in ('JY','MB') and item.fnumber = CT_PAY_AchieveDetailTem.CFFEEITEMDETAILNUMBER ) ) )");
//		
		.append(" union  select sum(amount) as sumamount , 'freeyz' as type from ( select  (nvl(sum(cfdocachieve),0)) as amount  from  CT_PAY_AchieveDetailTem  where "+dateSql+"  cfrecdotnumber = '"+empNum+"'  and  cfclinicnumber ='"+clinicNumber+"'  and cfincome  =0  and  cfpayment =0 and cffirclassNumber ='7' and cfbusitype = '�Һ�����'  and cfiscount= 1   ").append("\r\n")
		.append("   ").append("\r\n")
		.append("   )").append("\r\n")
		
		//���ܷ��⹤����ҵ��
		.append(" union select sum(amount) as sumamount , 'yz' as type from ( select  (nvl(sum(cfdocachieve),0)) as amount  from  CT_PAY_AchieveDetailTem  where "+dateSql+" cfrecdotnumber = '"+empNum+"'  and  cfclinicnumber ='"+clinicNumber+"'  and (cfincome!=0 or cfpayment!=0) and cffirclassNumber ='7'   and cfiscount= 1    ").append("\r\n")
		.append("  ").append("\r\n")
		.append("  )");
		
		/*select sum(amount) as sumamount , 'freezz' as type from ( select   nvl(sum(cforiprice*cfqty)*0.6,0)*0.9 as amount  from  CT_PAY_AchieveDetailTem  where cfrecdotnumber = 'MS310101833'  and  cfclinicnumber ='MS3101WLMZ022' and  cfcitynumber = 'MS3101' and cfbusinessdate ='202006' and cfincome  =0  and  cfpayment =0 and cffirclassNumber ='3' and cffirsource in  ('��ͳ�ƹ�','����ƽ̨','�����ƹ�','�����ƹ�','���ת��' ) and cfbusitype = '�Һ�����'  
		union select   nvl(sum(cforiprice*cfqty)*0.6,0)  as amount  from  CT_PAY_AchieveDetailTem  where cfrecdotnumber = 'MS310101833'  and  cfclinicnumber ='MS3101WLMZ022' and  cfcitynumber = 'MS3101' and cfbusinessdate ='202006' and cfincome  =0  and  cfpayment =0 and cffirclassNumber ='3' and cffirsource not in  ('��ͳ�ƹ�','����ƽ̨','�����ƹ�','�����ƹ�','���ת��' ) and cfbusitype = '�Һ�����' )  */
		
				
		return sqlYJ;
	}

	public static StringBuffer getSHFeiZiDaiSql(String empNum, String clinicNumber,String periodnum,String cityId,String cityNumber,String firSource,BigDecimal firSourcePro ,BigDecimal freeWorkPro,BigDecimal gifAmountPro,String type
			,HashMap<String,String> oneItemMap,HashMap<String,String>  twoItemMap,HashMap<String,String>  threeItemMap){
		HashMap<String, BigDecimal> map = new  HashMap<String, BigDecimal>();
		//��ֲ
		String zzOneItem = "''"; if(oneItemMap.get("ZZ")!= null)    zzOneItem = oneItemMap.get("ZZ");
		String zzTwoItem = "''"; if(twoItemMap.get("ZZ")!= null)    zzTwoItem = twoItemMap.get("ZZ");
		String zzThreeItem = "''"; if(threeItemMap.get("ZZ")!= null)  zzThreeItem = threeItemMap.get("ZZ");
		//����
		String zjOneItem = "''"; if(oneItemMap.get("ZJ")!= null)    zjOneItem = oneItemMap.get("ZJ");
		String zjTwoItem = "''"; if(twoItemMap.get("ZJ")!= null)    zjTwoItem = twoItemMap.get("ZJ");
		String zjThreeItem = "''"; if(threeItemMap.get("ZJ")!= null)  zjThreeItem = threeItemMap.get("ZJ");
		//�޸�
		String xfOneItem = "''"; if(oneItemMap.get("XF")!= null)    xfOneItem = oneItemMap.get("XF");
		String xfTwoItem = "''"; if(twoItemMap.get("XF")!= null)    xfTwoItem = twoItemMap.get("XF");
		String xfThreeItem = "''"; if(threeItemMap.get("XF")!= null)  xfThreeItem = threeItemMap.get("XF");
		//����
		String eyOneItem = "''"; if(oneItemMap.get("EY")!= null)    eyOneItem = oneItemMap.get("EY");
		String eyTwoItem = "''"; if(twoItemMap.get("EY")!= null)    eyTwoItem = twoItemMap.get("EY");
		String eyThreeItem = "''"; if(threeItemMap.get("EY")!= null)  eyThreeItem = threeItemMap.get("EY");
		//������
		String knwOneItem = "''"; if(oneItemMap.get("KNW")!= null)    knwOneItem = oneItemMap.get("KNW");
		String knwTwoItem = "''"; if(twoItemMap.get("KNW")!= null)    knwTwoItem = twoItemMap.get("KNW");
		String knwThreeItem = "''"; if(threeItemMap.get("KNW")!= null)  knwThreeItem = threeItemMap.get("KNW");
		//����
		String yzOneItem = "''"; if(oneItemMap.get("YZ")!= null)    yzOneItem = oneItemMap.get("YZ");
		String yzTwoItem = "''"; if(twoItemMap.get("YZ")!= null)    yzTwoItem = twoItemMap.get("YZ");
		String yzThreeItem = "''"; if(threeItemMap.get("YZ")!= null)  yzThreeItem = threeItemMap.get("YZ"); 
		
		
		String dateSql = "";
		if(type.equals("ZC")){
			dateSql = "  to_char(fbizdate, 'yyyymm') = '"+periodnum+"' and  ";
		}else if(type.equals("CBQR")){
			dateSql = "  CFBUSINESSDATE = '"+periodnum+"' and  (cfisneedout = 0 or ( cfisneedout=1 and cfisout = 1))  and  ";
		}
		
		StringBuffer sqlYJ = new StringBuffer();
		//��ֲ�⹤����ҵ��
		sqlYJ.append("  /*dialect*/select sum(amount) as sumamount , 'freezz' as type from ( select    (nvl(sum(cfdocachieve),0)) as amount  from  CT_PAY_AchieveDetailTem  where "+dateSql+" cfrecdotnumber = '"+empNum+"'  and  cfclinicnumber ='"+clinicNumber+"'  and cfincome  =0  and  cfpayment =0 and cfiscount= 1 "+
				" and ( cffirclassnumber in  ("+zzOneItem+") or cfsecclassnumber in ("+zzTwoItem+") or cffeeitemdetailnumber in  ("+zzThreeItem+")  )  and cfiscount= 1 and cffirsource in ( "+firSource+" ) and cfbusitype = '�Һ�����' ").append("\r\n")
		.append(" ) ").append("\r\n")
		//��ֲ���⹤����ҵ��
		.append(" union select sum(amount) as sumamount , 'zz' as type from ( select     (nvl(sum(cfdocachieve),0)) as amount  from  CT_PAY_AchieveDetailTem  where "+dateSql+" cfrecdotnumber = '"+empNum+"'  and  cfclinicnumber ='"+clinicNumber+"'  and (cfincome!=0 or cfpayment!=0) "+
				" and ( cffirclassnumber in  ("+zzOneItem+") or cfsecclassnumber in ("+zzTwoItem+") or cffeeitemdetailnumber in  ("+zzThreeItem+")  )  and cfiscount= 1 and cffirsource in ( "+firSource+" )   ").append("\r\n")
		.append(" ) ").append("\r\n")
		
		//�����⹤����
		.append(" union select sum(amount) as sumamount , 'freeyx' as type from ( select    (nvl(sum(cfdocachieve),0)) as amount  from  CT_PAY_AchieveDetailTem  where "+dateSql+" cfrecdotnumber = '"+empNum+"'  and  cfclinicnumber ='"+clinicNumber+"'  and cfincome  =0  and  cfpayment =0 "+
				" and ( cffirclassnumber in  ("+zjOneItem+") or cfsecclassnumber in ("+zjTwoItem+") or cffeeitemdetailnumber in  ("+zjThreeItem+")  ) and CFISROUTINE = '��'  and cfiscount= 1 and cffirsource in ( "+firSource+" ) and cfbusitype = '�Һ�����' ").append("\r\n")
		.append(" ) ").append("\r\n")
		//���η��⹤����ҵ��
		.append(" union select sum(amount) as sumamount , 'yx' as type from ( select    (nvl(sum(cfdocachieve),0)) as amount  from  CT_PAY_AchieveDetailTem  where "+dateSql+" cfrecdotnumber = '"+empNum+"'  and  cfclinicnumber ='"+clinicNumber+"'  and (cfincome!=0 or cfpayment!=0)  "+
				" and ( cffirclassnumber in  ("+zjOneItem+") or cfsecclassnumber in ("+zjTwoItem+") or cffeeitemdetailnumber in  ("+zjThreeItem+")  )  and CFISROUTINE = '��'  and cfiscount= 1 and cffirsource in ( "+firSource+" )   ").append("\r\n")
		.append(" ) ").append("\r\n")
		
		//�����⹤����
		.append(" union select sum(amount) as sumamount , 'freegd' as type from ( select    (nvl(sum(cfdocachieve),0)) as amount  from  CT_PAY_AchieveDetailTem  where "+dateSql+" cfrecdotnumber = '"+empNum+"'  and  cfclinicnumber ='"+clinicNumber+"'  and cfincome  =0  and  cfpayment =0  "+
				" and ( cffirclassnumber in  ("+zjOneItem+") or cfsecclassnumber in ("+zjTwoItem+") or cffeeitemdetailnumber in  ("+zjThreeItem+")  )  and CFISROUTINE = '��'  and cfiscount= 1 and cffirsource in ( "+firSource+" ) and cfbusitype = '�Һ�����' ").append("\r\n")
		.append(" ) ").append("\r\n")
		//������⹤����ҵ��
		.append(" union select sum(amount) as sumamount , 'gd' as type from ( select    (nvl(sum(cfdocachieve),0)) as amount  from  CT_PAY_AchieveDetailTem  where "+dateSql+"   cfrecdotnumber = '"+empNum+"'  and  cfclinicnumber ='"+clinicNumber+"'  and (cfincome!=0 or cfpayment!=0)  "+
				" and ( cffirclassnumber in  ("+zjOneItem+") or cfsecclassnumber in ("+zjTwoItem+") or cffeeitemdetailnumber in  ("+zjThreeItem+")  )  and CFISROUTINE = '��'  and cfiscount= 1 and cffirsource in ( "+firSource+" )   ").append("\r\n")
		.append(" ) ").append("\r\n")
		
		//�������⹤����
		.append(" union select sum(amount) as sumamount , 'freeknw' as type from ( select  (nvl(sum(cfdocachieve),0))  as amount  from  CT_PAY_AchieveDetailTem  where "+dateSql+"  cfrecdotnumber = '"+empNum+"'  and  cfclinicnumber ='"+clinicNumber+"'  and cfincome  =0  and  cfpayment =0  "+
				" and ( cffirclassnumber in  ("+knwOneItem+") or cfsecclassnumber in ("+knwTwoItem+") or cffeeitemdetailnumber in  ("+knwThreeItem+")  )   and cfbusitype = '�Һ�����' and cfiscount= 1 and cffirsource in ( "+firSource+" )  )") .append("\r\n")
		//��������⹤����ҵ��
		.append(" union select sum(amount) as sumamount , 'knw' as type from ( select  (nvl(sum(cfdocachieve),0)) as amount  from  CT_PAY_AchieveDetailTem  where "+dateSql+"  cfrecdotnumber = '"+empNum+"'  and  cfclinicnumber ='"+clinicNumber+"'  and (cfincome!=0 or cfpayment!=0)  "+
				" and ( cffirclassnumber in  ("+knwOneItem+") or cfsecclassnumber in ("+knwTwoItem+") or cffeeitemdetailnumber in  ("+knwThreeItem+")  )   and cfiscount= 1 and cffirsource in ( "+firSource+" )  )").append("\r\n")
		  
		//�����⹤����
		.append(" union select sum(amount) as sumamount , 'freeey' as type from ( select  (nvl(sum(cfdocachieve),0)) as amount  from  CT_PAY_AchieveDetailTem  where "+dateSql+"  cfrecdotnumber = '"+empNum+"'  and  cfclinicnumber ='"+clinicNumber+"'  and cfincome  =0  and  cfpayment =0  "+
				" and ( cffirclassnumber in  ("+eyOneItem+") or cfsecclassnumber in ("+eyTwoItem+") or cffeeitemdetailnumber in  ("+eyThreeItem+")  )   and cfbusitype = '�Һ�����'  and cfiscount= 1 and cffirsource in ( "+firSource+" ) )") .append("\r\n")
		//�������⹤����ҵ��
		.append(" union select sum(amount) as sumamount , 'ey' as type from ( select  (nvl(sum(cfdocachieve),0))  as amount  from  CT_PAY_AchieveDetailTem  where "+dateSql+"  cfrecdotnumber = '"+empNum+"'  and  cfclinicnumber ='"+clinicNumber+"'  and (cfincome!=0 or cfpayment!=0)  "+
				" and ( cffirclassnumber in  ("+eyOneItem+") or cfsecclassnumber in ("+eyTwoItem+") or cffeeitemdetailnumber in  ("+eyThreeItem+")  )  and cfiscount= 1 and cffirsource in ( "+firSource+" )  )").append("\r\n")
		 
		//�޸��⹤����
		.append(" union select sum(amount) as sumamount , 'freexf' as type from ( select  (nvl(sum(cfdocachieve),0))  as amount  from  CT_PAY_AchieveDetailTem  where "+dateSql+"  cfrecdotnumber = '"+empNum+"'  and  cfclinicnumber ='"+clinicNumber+"'  and cfincome  =0  and  cfpayment =0  "+
				" and ( cffirclassnumber in  ("+xfOneItem+") or cfsecclassnumber in ("+xfTwoItem+") or cffeeitemdetailnumber in  ("+xfThreeItem+")  )   and cfbusitype = '�Һ�����'  and cfiscount= 1 and cffirsource in ( "+firSource+" )  )") .append("\r\n")
		//�޸����⹤����ҵ��
		.append(" union select sum(amount) as sumamount , 'xf' as type from ( select  (nvl(sum(cfdocachieve),0))  as amount  from  CT_PAY_AchieveDetailTem  where "+dateSql+"  cfrecdotnumber = '"+empNum+"'  and  cfclinicnumber ='"+clinicNumber+"'  and (cfincome!=0 or cfpayment!=0)  "+
				" and ( cffirclassnumber in  ("+xfOneItem+") or cfsecclassnumber in ("+xfTwoItem+") or cffeeitemdetailnumber in  ("+xfThreeItem+")  )   and cfiscount= 1 and cffirsource in ( "+firSource+" ) )").append("\r\n")
		
//		//�����⹤����    ���ܣ�һ����������������ף����������������ơ����⣺ȫ��ҽ��    ����������������ף������շ����һ��������н��ﻤʿ������ﻤʿ���������ҽ��
//		//
//		.append(" union select sum(amount) as sumamount , 'freeyz' as type from ( select nvl(sum(cforiprice*cfqty)*"+freeWorkPro+",0) as amount  from  CT_PAY_AchieveDetailTem  where "+dateSql+"  cfrecdotnumber = '"+empNum+"'  and  cfclinicnumber ='"+clinicNumber+"'  and cfincome  =0  and  cfpayment =0 and cffirclassNumber ='7' and cfbusitype = '�Һ�����'   and cfiscount= 1 and cffirsource in ( "+firSource+" )  and   ").append("\r\n")
//		.append(" ( EXISTS (SELECT  1  FROM  CT_SRQ_ItemCheck bill  inner join CT_SRQ_ItemCheckEntry entry on entry.fparentid = bill.fid  left JOIN  CT_SRQ_Paytypeitem  second on second.fid = entry.cfseconditemid   where cfcityid = '"+cityId+"' and  cftypenumber = 'YZ' and second.fnumber = CT_PAY_AchieveDetailTem.CFSECCLASSNUMBER ) or  EXISTS (SELECT  1  FROM  CT_SRQ_ItemCheck bill  inner join CT_SRQ_ItemCheckEntry entry on entry.fparentid = bill.fid left JOIN  CT_SRQ_PayItem  item on  item.fid = entry.cfitemid  where cfcityid = '"+cityId+"' and  cftypenumber = 'YZ' and item.fnumber = CT_PAY_AchieveDetailTem.CFFEEITEMDETAILNUMBER ) ) ").append("\r\n")
//		.append(" union select nvl(sum(cforiprice*cfqty)*"+freeWorkPro+",0) as amount  from  CT_PAY_AchieveDetailTem  where "+dateSql+"  cfrecdotnumber = '"+empNum+"'  and  cfclinicnumber ='"+clinicNumber+"'  and cfincome  =0  and  cfpayment =0 and cffirclassNumber ='7'  and cfbusitype = '�Һ�����'  and cfiscount= 1 and cffirsource in ( "+firSource+" )   and  not EXISTS ( SELECT 1 FROM  CT_PAY_PayPost  paypost where paypost.cfcityid = '"+cityId+"' and paypost.cfbusinessdate = '"+periodnum+"' and cfpostnumber ='HS' AND CFSTATUS = 'qy' and paypost.cfempnumber = CT_PAY_AchieveDetailTem.CFNURSENUMBER  )  and  ").append("\r\n")
//		.append(" ( EXISTS (SELECT  1  FROM  CT_SRQ_ItemCheck bill  inner join CT_SRQ_ItemCheckEntry entry on entry.fparentid = bill.fid  left JOIN  CT_SRQ_Paytypeitem  second on second.fid = entry.cfseconditemid   where cfcityid = '"+cityId+"' and  cftypenumber in ('JY','MB')  and second.fnumber = CT_PAY_AchieveDetailTem.CFSECCLASSNUMBER ) or  EXISTS (SELECT  1  FROM  CT_SRQ_ItemCheck bill  inner join CT_SRQ_ItemCheckEntry entry on entry.fparentid = bill.fid left JOIN  CT_SRQ_PayItem  item on  item.fid = entry.cfitemid  where cfcityid = '"+cityId+"' and  cftypenumber in ('JY','MB') and item.fnumber = CT_PAY_AchieveDetailTem.CFFEEITEMDETAILNUMBER ) ) )").append("\r\n")
//		
//		//���ܷ��⹤����ҵ��
//		.append(" union select sum(amount) as sumamount , 'yz' as type from ( select (nvl(sum(cfpayment),0)-(nvl(sum(cfgiftpayment),0)*"+gifAmountPro+")) as amount  from  CT_PAY_AchieveDetailTem  where "+dateSql+"  cfrecdotnumber = '"+empNum+"'  and  cfclinicnumber ='"+clinicNumber+"'  and (cfincome!=0 or cfpayment!=0) and cffirclassNumber ='7'  and cfiscount= 1  and cffirsource in ( "+firSource+" )  and   ").append("\r\n")
//		.append(" ( EXISTS (SELECT  1  FROM  CT_SRQ_ItemCheck bill  inner join CT_SRQ_ItemCheckEntry entry on entry.fparentid = bill.fid  left JOIN  CT_SRQ_Paytypeitem  second on second.fid = entry.cfseconditemid   where cfcityid = '"+cityId+"' and  cftypenumber = 'YZ' and second.fnumber = CT_PAY_AchieveDetailTem.CFSECCLASSNUMBER ) or  EXISTS (SELECT  1  FROM  CT_SRQ_ItemCheck bill  inner join CT_SRQ_ItemCheckEntry entry on entry.fparentid = bill.fid left JOIN  CT_SRQ_PayItem  item on  item.fid = entry.cfitemid  where cfcityid = '"+cityId+"' and  cftypenumber = 'YZ' and item.fnumber = CT_PAY_AchieveDetailTem.CFFEEITEMDETAILNUMBER ) ) ").append("\r\n")
//		.append(" union select (nvl(sum(cfpayment),0)-(nvl(sum(cfgiftpayment),0)*"+gifAmountPro+")) as amount  from  CT_PAY_AchieveDetailTem  where "+dateSql+"  cfrecdotnumber = '"+empNum+"'  and  cfclinicnumber ='"+clinicNumber+"'  and (cfincome!=0 or cfpayment!=0) and cffirclassNumber ='7'  and cfiscount= 1  and cffirsource in ( "+firSource+" )   and  not EXISTS ( SELECT 1 FROM  CT_PAY_PayPost  paypost where paypost.cfcityid = '"+cityId+"' and paypost.cfbusinessdate = '"+periodnum+"' and cfpostnumber ='HS' AND CFSTATUS = 'qy' and paypost.cfempnumber = CT_PAY_AchieveDetailTem.CFNURSENUMBER  )  and  ").append("\r\n")
//		.append(" ( EXISTS (SELECT  1  FROM  CT_SRQ_ItemCheck bill  inner join CT_SRQ_ItemCheckEntry entry on entry.fparentid = bill.fid  left JOIN  CT_SRQ_Paytypeitem  second on second.fid = entry.cfseconditemid   where cfcityid = '"+cityId+"' and  cftypenumber in ('JY','MB')  and second.fnumber = CT_PAY_AchieveDetailTem.CFSECCLASSNUMBER ) or  EXISTS (SELECT  1  FROM  CT_SRQ_ItemCheck bill  inner join CT_SRQ_ItemCheckEntry entry on entry.fparentid = bill.fid left JOIN  CT_SRQ_PayItem  item on  item.fid = entry.cfitemid  where cfcityid = '"+cityId+"' and  cftypenumber in ('JY','MB') and item.fnumber = CT_PAY_AchieveDetailTem.CFFEEITEMDETAILNUMBER ) ) )");

		//�����⹤����    ���ܣ�һ����������������ף����������������ơ����⣺ȫ��ҽ��    ����������������ף������շ����һ��������н��ﻤʿ������ﻤʿ���������ҽ��
		//
		.append(" union select sum(amount) as sumamount , 'freeyz' as type from ( select  (nvl(sum(cfdocachieve),0)) as amount  from  CT_PAY_AchieveDetailTem  where "+dateSql+"  cfrecdotnumber = '"+empNum+"'  and  cfclinicnumber ='"+clinicNumber+"'  and cfincome  =0  and  cfpayment =0  "+
				" and ( cffirclassnumber in  ("+yzOneItem+") or cfsecclassnumber in ("+yzTwoItem+") or cffeeitemdetailnumber in  ("+yzThreeItem+")  )  and cfbusitype = '�Һ�����'   and cfiscount= 1 and cffirsource in ( "+firSource+" )      ").append("\r\n")
		 
		.append("").append("\r\n")
		.append("  )").append("\r\n")
		
		//���ܷ��⹤����ҵ��
		.append(" union select sum(amount) as sumamount , 'yz' as type from ( select  (nvl(sum(cfdocachieve),0)) as amount  from  CT_PAY_AchieveDetailTem  where "+dateSql+"  cfrecdotnumber = '"+empNum+"'  and  cfclinicnumber ='"+clinicNumber+"'  and (cfincome!=0 or cfpayment!=0)  "+
				" and ( cffirclassnumber in  ("+yzOneItem+") or cfsecclassnumber in ("+yzTwoItem+") or cffeeitemdetailnumber in  ("+yzThreeItem+")  )   and cfiscount= 1  and cffirsource in ( "+firSource+" )    ").append("\r\n")
		.append(" ").append("\r\n")
		.append(" ").append("\r\n")
		.append("  )");
		
		
		/*select sum(amount) as sumamount , 'freezz' as type from ( select   nvl(sum(cforiprice*cfqty)*0.6,0)*0.9 as amount  from  CT_PAY_AchieveDetailTem  where cfrecdotnumber = 'MS310101833'  and  cfclinicnumber ='MS3101WLMZ022' and  cfcitynumber = 'MS3101' and cfbusinessdate ='202006' and cfincome  =0  and  cfpayment =0 and cffirclassNumber ='3' and cffirsource in  ('��ͳ�ƹ�','����ƽ̨','�����ƹ�','�����ƹ�','���ת��' ) and cfbusitype = '�Һ�����'  
		union select   nvl(sum(cforiprice*cfqty)*0.6,0)  as amount  from  CT_PAY_AchieveDetailTem  where cfrecdotnumber = 'MS310101833'  and  cfclinicnumber ='MS3101WLMZ022' and  cfcitynumber = 'MS3101' and cfbusinessdate ='202006' and cfincome  =0  and  cfpayment =0 and cffirclassNumber ='3' and cffirsource not in  ('��ͳ�ƹ�','����ƽ̨','�����ƹ�','�����ƹ�','���ת��' ) and cfbusitype = '�Һ�����' )  */
		
				
		return sqlYJ;
	}

	public StringBuffer getSHYeJiImpSql(String empNum, String clinicNumber ,String cityNumber,String periodnum,StringBuffer sqlYJ,String cityId,BigDecimal zjbl){
		//��ֲ   and CFClinicNumber='"+clinicNumber+"'
		sqlYJ.append("  /*dialect*/ SELECT  nvl( sum(cfzzachieve),0) as ZZ , nvl(sum(cfyxjzachieve),0) as YXJZ , nvl(sum(cfgdjzachieve),0) as GDJZ , nvl(sum(cfknwachieve),0) as KNW , nvl(sum(cfxfachieve),0) as XF , nvl(sum(cfeyachieve),0) as EY , nvl(sum(cfyzachieve),0) as YZ , nvl(sum(cfmbachieve),0) as MB , nvl(sum(cfjzmoney),0) as JZ   ").append("\r\n")
		.append(" FROM  CT_PAY_DocAchieveUpdate where cfcityid = '"+cityId+"' and cfdocnumber = '"+empNum+"'  and cfclinicnumber ='"+clinicNumber+"' and  cfbusinessdate = '"+periodnum+"' and ( cfiszidai = 0 or cfiszidai is null)   and  fname_l2 is null  ");
		 

		return sqlYJ;
	}
	
	public StringBuffer getImportChengBenSql(String empNums , String clinicNumber , String cityID,String periodnum,StringBuffer sqlCB){ 
		sqlCB.append(" /*dialect*/select ( nvl(sum(cfzjcost),0) ) as summ,'zz' as type   FROM  CT_PAY_DoctorCosts  where CFBUSINESSDATE ='"+periodnum+"' and cfMZNUMBER='"+clinicNumber+"' and cfcityid='"+cityID+"'  and  cfempNumber ='"+empNums+"' and (cfiszidai is null or cfiszidai = 0) ").append("\r\n");
		sqlCB.append(" union select ( nvl(sum(cfyxcost),0) ) as summ,'yxjz' as type   FROM CT_PAY_DoctorCosts  where CFBUSINESSDATE ='"+periodnum+"'  and cfMZNUMBER='"+clinicNumber+"'  and cfcityid='"+cityID+"' and  cfempNumber ='"+empNums+"' and (cfiszidai is null or cfiszidai = 0) ").append("\r\n");
		sqlCB.append(" 	 union select ( nvl(sum(cfgdcost),0) ) as summ,'gdjz' as type   FROM CT_PAY_DoctorCosts  where CFBUSINESSDATE ='"+periodnum+"'  and cfMZNUMBER='"+clinicNumber+"' and cfcityid='"+cityID+"'  and  cfempNumber ='"+empNums+"' and (cfiszidai is null or cfiszidai = 0) ").append("\r\n");
		sqlCB.append(" 	 union select ( nvl(sum(cfkncost),0)) as summ,'knw' as type   FROM CT_PAY_DoctorCosts  where CFBUSINESSDATE ='"+periodnum+"' and cfMZNUMBER='"+clinicNumber+"' and cfcityid='"+cityID+"'  and  cfempNumber ='"+empNums+"'  and (cfiszidai is null or cfiszidai = 0)  ").append("\r\n");
		sqlCB.append(" 	 union select ( nvl(sum(cfxfcost),0) ) as summ,'xf' as type   FROM CT_PAY_DoctorCosts  where CFBUSINESSDATE ='"+periodnum+"' and cfMZNUMBER='"+clinicNumber+"' and cfcityid='"+cityID+"'  and  cfempNumber  ='"+empNums+"' and (cfiszidai is null or cfiszidai = 0) ").append("\r\n");
		sqlCB.append(" 	 union select ( nvl(sum(cfeycost),0)) as summ,'ey' as type   FROM CT_PAY_DoctorCosts  where CFBUSINESSDATE ='"+periodnum+"'  and cfMZNUMBER='"+clinicNumber+"' and cfcityid='"+cityID+"'  and  cfempNumber  ='"+empNums+"'  and (cfiszidai is null or cfiszidai = 0)  ").append("\r\n");
		sqlCB.append(" 	 union select ( nvl(sum(cfzbcost),0)) as summ,'yz' as type   FROM CT_PAY_DoctorCosts  where CFBUSINESSDATE ='"+periodnum+"' and cfMZNUMBER='"+clinicNumber+"'  and cfcityid='"+cityID+"' and  cfempNumber ='"+empNums+"'  and (cfiszidai is null or cfiszidai = 0) ").append("\r\n");
		sqlCB.append(" 	 union select ( nvl(sum(cfmbcost),0)) as summ,'mb' as type  FROM CT_PAY_DoctorCosts  where CFBUSINESSDATE ='"+periodnum+"' and cfMZNUMBER='"+clinicNumber+"'  and cfcityid='"+cityID+"' and  cfempNumber ='"+empNums+"'  and (cfiszidai is null or cfiszidai = 0) ").append("\r\n");
		
		return sqlCB;
	}
	
	public StringBuffer getSHHushiChengBenSql(String empNums, String clinicNumber, String cityNumber,String periodnum,StringBuffer sqlCB ){
		
		sqlCB.append(" /*dialect*/ select ( nvl(sum(cfxhzz),0) +nvl(sum(cfjgfzz),0)) as summ,'zz' as type  from  CT_PAY_CostByUpdate  where cfperiod = '"+periodnum+"' and cfclinicnumber='"+clinicNumber+"'  and cfcitynumber='"+cityNumber+"' and  cfdoctornumber  ='"+empNums+"'  and (cfiszidai is null or cfiszidai = 0)  union ").append("\r\n");
		sqlCB.append(" 	select ( nvl(sum(cfxhyxjz),0) +nvl(sum(cfjgfyxjz),0)) as summ,'yxjz' as type  from  CT_PAY_CostByUpdate  where cfperiod = '"+periodnum+"' and cfclinicnumber='"+clinicNumber+"' and cfcitynumber='"+cityNumber+"'  and  cfdoctornumber ='"+empNums+"'  and (cfiszidai is null or cfiszidai = 0) union ").append("\r\n");
		sqlCB.append(" 	select ( nvl(sum(cfxhcgjz),0) +nvl(sum(cfjgfcgjz),0)) as summ,'gdjz' as type  from  CT_PAY_CostByUpdate  where cfperiod = '"+periodnum+"' and cfclinicnumber='"+clinicNumber+"' and cfcitynumber='"+cityNumber+"'   and  cfdoctornumber  ='"+empNums+"'  and (cfiszidai is null or cfiszidai = 0)  union ").append("\r\n");
		sqlCB.append(" 	select ( nvl(sum(cfxhknw),0) +nvl(sum(cfjgfknw),0)) as summ,'knw' as type  from  CT_PAY_CostByUpdate  where cfperiod = '"+periodnum+"' and cfclinicnumber='"+clinicNumber+"' and cfcitynumber='"+cityNumber+"'    and  cfdoctornumber  ='"+empNums+"' and (cfiszidai is null or cfiszidai = 0)  union ").append("\r\n");
		sqlCB.append(" 	select ( nvl(sum(cfxhxf),0) +nvl(sum(cfjgfxf),0)) as summ,'xf' as type  from  CT_PAY_CostByUpdate  where cfperiod = '"+periodnum+"' and cfclinicnumber='"+clinicNumber+"'  and cfcitynumber='"+cityNumber+"' and  cfdoctornumber  ='"+empNums+"'  and (cfiszidai is null or cfiszidai = 0) union ").append("\r\n");
		sqlCB.append(" 	select ( nvl(sum(cfxhey),0) +nvl(sum(cfjgfey),0)) as summ,'ey' as type  from  CT_PAY_CostByUpdate  where cfperiod = '"+periodnum+"' and cfclinicnumber='"+clinicNumber+"' and cfcitynumber='"+cityNumber+"'  and  cfdoctornumber ='"+empNums+"' and (cfiszidai is null or cfiszidai = 0) union ").append("\r\n");
		sqlCB.append(" 	select ( nvl(sum(cfxhyz),0) +nvl(sum(cfjgfyz),0)) as summ,'yz' as type  from  CT_PAY_CostByUpdate  where cfperiod = '"+periodnum+"' and cfclinicnumber='"+clinicNumber+"' and cfcitynumber='"+cityNumber+"'   and  cfdoctornumber  ='"+empNums+"' and (cfiszidai is null or cfiszidai = 0) union ").append("\r\n");
		sqlCB.append(" 	select ( nvl(sum(cfjgfmb),0) +nvl(sum(cfxhmb),0) ) as summ,'mb' as type  from  CT_PAY_CostByUpdate  where cfperiod = '"+periodnum+"' and cfclinicnumber='"+clinicNumber+"' and cfcitynumber='"+cityNumber+"'  and  cfdoctornumber  ='"+empNums+"'  and (cfiszidai is null or cfiszidai = 0)  ");
		
		
		
		return sqlCB;
	}
	
	/**
	 * ͳ��ҽ���ĳɱ�
	 * @param empNum
	 * @param cityNumber
	 * @param periodnum
	 * @param sqlCB
	 * @return
	 */
	public StringBuffer getSHChengBenSql(String empNums, String clinicNumber ,String cityNumber,String periodnum,StringBuffer sqlCB){
		sqlCB.append(" /*dialect*/select ( nvl(sum(cfxhzz),0) +nvl(sum(cfjgfzz),0)) as summ,'zz' as type  from  CT_PAY_CostSum where cfperiod = '"+periodnum+"' and cfclinicnumber ='"+clinicNumber+"' and cfcitynumber='"+cityNumber+"' and  cfdoctornumber  ='"+empNums+"'  union ").append("\r\n");
		sqlCB.append(" 	select ( nvl(sum(cfxhyxjz),0) +nvl(sum(cfjgfyxjz),0)) as summ,'yxjz' as type  from  CT_PAY_CostSum where cfperiod = '"+periodnum+"'  and cfclinicnumber ='"+clinicNumber+"' and cfcitynumber='"+cityNumber+"'  and  cfdoctornumber  ='"+empNums+"'  union ").append("\r\n");
		sqlCB.append(" 	select ( nvl(sum(cfxhcgjz),0) +nvl(sum(cfjgfcgjz),0)) as summ,'gdjz' as type  from  CT_PAY_CostSum where cfperiod = '"+periodnum+"'  and cfclinicnumber ='"+clinicNumber+"'  and cfcitynumber='"+cityNumber+"'   and  cfdoctornumber  ='"+empNums+"'    union ").append("\r\n");
		sqlCB.append(" 	select ( nvl(sum(cfxhknw),0) +nvl(sum(cfjgfknw),0)) as summ,'knw' as type  from  CT_PAY_CostSum where cfperiod = '"+periodnum+"'  and cfclinicnumber ='"+clinicNumber+"'  and cfcitynumber='"+cityNumber+"'    and  cfdoctornumber ='"+empNums+"'    union ").append("\r\n");
		sqlCB.append(" 	select ( nvl(sum(cfxhxf),0) +nvl(sum(cfjgfxf),0)) as summ,'xf' as type  from  CT_PAY_CostSum where cfperiod = '"+periodnum+"'   and cfclinicnumber ='"+clinicNumber+"'   and cfcitynumber='"+cityNumber+"' and  cfdoctornumber  ='"+empNums+"'   union ").append("\r\n");
		sqlCB.append(" 	select ( nvl(sum(cfxhey),0) +nvl(sum(cfjgfey),0)) as summ,'ey' as type  from  CT_PAY_CostSum where cfperiod = '"+periodnum+"'  and cfclinicnumber ='"+clinicNumber+"'   and cfcitynumber='"+cityNumber+"'  and  cfdoctornumber ='"+empNums+"'   union ").append("\r\n");
		sqlCB.append(" 	select ( nvl(sum(cfxhyz),0) +nvl(sum(cfjgfyz),0)) as summ,'yz' as type  from  CT_PAY_CostSum where cfperiod = '"+periodnum+"'  and cfclinicnumber ='"+clinicNumber+"'  and cfcitynumber='"+cityNumber+"'   and  cfdoctornumber  ='"+empNums+"'  union ").append("\r\n");
		sqlCB.append(" 	select ( nvl(sum(cfjgfmb),0) +nvl(sum(cfxhmb),0) ) as summ,'mb' as type  from  CT_PAY_CostSum where cfperiod = '"+periodnum+"'  and cfclinicnumber ='"+clinicNumber+"'   and cfcitynumber='"+cityNumber+"'  and  cfdoctornumber  ='"+empNums+"'   ");
		
		
		
		return sqlCB;
	}


	
	private  BigDecimal docZiDai(Context ctx, HashMap map ,String empNum, String cityNumber,String periodnum ,String clinicNumber,String clinicName , HashMap tempMap ,String cityId,
			String firSource,BigDecimal firSourcePro,BigDecimal freeWorkPro,BigDecimal gifAmountPro,String calType,String type
			,HashMap<String,String> oneItemMap,HashMap<String,String>  twoItemMap,HashMap<String,String>  threeItemMap){ 
		ExecutorService pool = Executors.newFixedThreadPool(6);
	    ParallelSqlExecutor pe = new ParallelSqlExecutor(pool); 
	    String userId = ContextHelperFactory.getLocalInstance(ctx).getCurrentUser().getId().toString(); 
	    BigDecimal bymoney = BigDecimal.ZERO;
		
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
		
		BigDecimal costAll = BigDecimal.ZERO; 
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
		clinicCostSumInfo.setClinicName(clinicName);
		clinicCostSumInfo.setClinicNumber(clinicNumber);
		clinicCostSumInfo.setCityNumber(cityNumber);
		clinicCostSumInfo.setBusinessDate(periodnum); 
		clinicCostSumInfo.setCityName(tempMap.get("cityName").toString());
		clinicCostSumInfo.setEmpName(tempMap.get("empName").toString());
		clinicCostSumInfo.setIzzidai(true);
		//�����Դ�����
		//�Դ����� ��ֲ ҵ��
		BigDecimal byzz = BigDecimal.ZERO;
		//�Դ����� �̶�����ҵ��
		BigDecimal bygdjz = BigDecimal.ZERO; 
		//�Դ����� ���ν���ҵ��
		BigDecimal byyxjz = BigDecimal.ZERO; 
		//�Դ����� ����ҵ��
		BigDecimal byyz = BigDecimal.ZERO; 
		//�Դ����� ������ҵ��
		BigDecimal byknw = BigDecimal.ZERO; 
		//�Դ����� ����ҵ��
		BigDecimal bymb = BigDecimal.ZERO; 
		//�Դ����� �޸�ҵ��
		BigDecimal byxf = BigDecimal.ZERO; 
		//�Դ����� ����ҵ��
		BigDecimal byey = BigDecimal.ZERO; 
		
		//�Դ����� ��ֲ 
		BigDecimal byzzbl = new BigDecimal(map.get("CFBYZZPRO").toString());
		//�Դ����� �̶�����
		BigDecimal bygdjzbl = new BigDecimal(map.get("CFBYGDJZPRO").toString());
		//�Դ����� ���ν���
		BigDecimal byyxjzbl =  new BigDecimal(map.get("CFBYYXJZPRO").toString());
		//�Դ����� ����
		BigDecimal byyzbl =  new BigDecimal(map.get("CFBYYZPRO").toString());//?
		//�Դ����� ������
		BigDecimal byknwbl = new BigDecimal(map.get("CFBYKNWPRO").toString());
		//�Դ����� ����
		BigDecimal bymbbl = new BigDecimal(map.get("CFBYMBPRO").toString());
		//�Դ����� �޸�
		BigDecimal byxfbl = new BigDecimal(map.get("CFBYXFPRO").toString());
		//�Դ����� ����
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
		biliMap.put("zj",BigDecimal.ONE );
		
		String insertSql =  "";
		String insertValueSql = "";
		String imandxtinsertsql = "";
		String imandxtinsertValueSql = "";
		try {  
			String empName = map.get("CFDOCNAME").toString();
			

			StringBuffer sqlImportYJ = new StringBuffer(); 
			sqlImportYJ = getSHYeJiZIDaiImpSql( empNum, clinicNumber, cityNumber, periodnum, sqlImportYJ, cityId);
		  	System.out.println("--"+sqlImportYJ);
		  	IRowSet yjImprs = com.kingdee.eas.custom.util.DBUtil.executeQuery(ctx,sqlImportYJ.toString());
		  	if(yjImprs!=null && yjImprs.size() > 0){ 
			  	while(yjImprs.next()){	
			  		byzz = byzz.add(new BigDecimal(yjImprs.getString("ZZ"))); 
			  		byzz= byzz.add(new BigDecimal(yjImprs.getString("GDJZ"))); 
			  		byzz= byzz.add(new BigDecimal(yjImprs.getString("YXJZ"))); 
			  		byzz= byzz.add(new BigDecimal(yjImprs.getString("YZ"))); 
			  		byzz = byzz.add(new BigDecimal(yjImprs.getString("KNW")));
			  		byzz= byzz.add(new BigDecimal(yjImprs.getString("MB"))); 
			  		byzz= byzz.add(new BigDecimal(yjImprs.getString("XF")));  
			  		byzz= byzz.add(new BigDecimal(yjImprs.getString("EY")));   
			  		
			  	    //������ֲ
					imzz =  imzz.add(yjImprs.getBigDecimal("ZZ"));
					//����̶�����
					imzz = imzz.add(yjImprs.getBigDecimal("GDJZ"));
					//�������ν���
					imzz =  imzz.add(yjImprs.getBigDecimal("YXJZ"));
					//��������
					imzz =  imzz.add(yjImprs.getBigDecimal("YZ"));
					//���������
					imzz =  imzz.add(yjImprs.getBigDecimal("KNW"));
					//��������
					imzz =  imzz.add(yjImprs.getBigDecimal("MB"));
					//�����޸�
					imzz = imzz.add(yjImprs.getBigDecimal("XF"));
					//�������
					imzz =  imzz.add(yjImprs.getBigDecimal("EY"));
				}
			}
		  	 
			BigDecimal noFreeAchieve = BigDecimal.ZERO; 
			BigDecimal freeAchieve = BigDecimal.ZERO; 
			noFreeAchieve = noFreeAchieve.add(imzz).add(imgdjz).add(imyxjz).add(imyz).add(imknw).add(imxf).add(imey);
			//�����Դ����ߵ� ҵ��
			StringBuffer sqlZD = new StringBuffer();
			sqlZD = getSHZiDaiYeJiSql( empNum,clinicNumber,  cityNumber, periodnum, empName,cityId,firSource,firSourcePro,freeWorkPro,gifAmountPro,type
					, oneItemMap, twoItemMap,  threeItemMap );
			System.out.println("--"+sqlZD);
			IRowSet zdrs = com.kingdee.eas.custom.util.DBUtil.executeQuery(ctx,sqlZD.toString());
			if(zdrs!=null && zdrs.size() > 0){
				  while(zdrs.next()){	  
					  if(!zdrs.getString("TYPE").contains("free")){//��ֲ
						  byzz =byzz.add(new BigDecimal(zdrs.getString("SUMAMOUNT")));   
						  noFreeAchieve =noFreeAchieve.add(new BigDecimal(zdrs.getString("SUMAMOUNT")));
					  }else {//�⹤����
						  byzz = byzz.add(new BigDecimal(zdrs.getString("SUMAMOUNT"))); 
						  freeAchieve = freeAchieve .add(new BigDecimal(zdrs.getString("SUMAMOUNT")));   
					  } 
				  }
				 
			} 
			imandxtinsertsql +=  ", CFXTZZACHIEVE  ";
			imandxtinsertValueSql +=" ,"+noFreeAchieve+" "; 
			  
			imandxtinsertsql += ", CFfreeZZACHIEVE ";
  			imandxtinsertValueSql += ","+freeAchieve+""; 
  			
			//�Դ����߳ɱ�
			StringBuffer sqlImportCB = new StringBuffer(); 
			sqlImportCB = getSHImportZiDaiChengBenSql( "'"+empNum+"'", clinicNumber, cityId, periodnum, sqlImportCB);
			IRowSet imporytbrs = com.kingdee.eas.custom.util.DBUtil.executeQuery(ctx,sqlImportCB.toString());
			if(imporytbrs!=null && imporytbrs.size() > 0){
				while(imporytbrs.next()){	
					 zzcb =new BigDecimal(imporytbrs.getString("SUMM"));  
				  }
			} 
			clinicCostSumInfo.setImzzCost(zzcb);
			
			//��� ��ʿ�����ĳɱ�
			StringBuffer sqlHushiCB = new StringBuffer(); 
			sqlHushiCB = getSHHushiZiDaiChengBenSql( "'"+empNum+"'", clinicNumber, cityId, periodnum, sqlHushiCB);
			IRowSet hushiCBrs;
			BigDecimal hushiCost  = BigDecimal.ZERO;
			hushiCBrs = com.kingdee.eas.custom.util.DBUtil.executeQuery(ctx,sqlHushiCB.toString());
			
			if(hushiCBrs!=null && hushiCBrs.size() > 0){
				while(hushiCBrs.next()){	
					   zzcb = zzcb.add(new BigDecimal(hushiCBrs.getString("SUMM"))); 
					   //costAll = costAll.add(new BigDecimal(hushiCBrs.getString("SUMM")));  
					   hushiCost = hushiCost.add(new BigDecimal(hushiCBrs.getString("SUMM"))); 
					  
				  }
			} 
			clinicCostSumInfo.setUpzzCost(hushiCost);
			
			BigDecimal zzBase =  BigDecimal.ZERO;
			zzBase = byzz.subtract(zzcb).compareTo(BigDecimal.ZERO)<0?BigDecimal.ZERO:byzz.subtract(zzcb);
			zzBase = zzBase.compareTo(BigDecimal.ZERO)<0?BigDecimal.ZERO:zzBase;  
			
			imandxtinsertsql +=  ", CFIMZZACHIEVE , CFIMGDJZACHIEVE , cfIMyxjzachieve, CFIMyzAchieve , cfIMknwachieve , cfIMmbachieve , cfIMxfachieve, cfIMeyachieve ";
			imandxtinsertValueSql +=" ,"+imzz+" ,"+imgdjz+","+imyxjz +","+imyz+","+imknw+","+immb+","+imxf+"," + ""+imey+"  ";
			

			insertSql +=  ", CFZZACHIEVE , CFGDJZACHIEVE , cfyxjzachieve, CFZyAchieve , cfknwachieve , cfmbachieve , cfxfachieve, cfeyachieve ";
			insertValueSql +=" ,"+byzz+" ,"+bygdjz+","+byyxjz+","+byyz+","+byknw+","+bymb+","+byxf+","+byey+"  ";
			
			
			//�Դ����� �ü�ȥ�ɱ� 
			BigDecimal byzzMoney = zzBase.compareTo(BigDecimal.ZERO) > 0 ? zzBase.multiply(byzzbl):BigDecimal.ZERO; 
			
			insertSql += " , CFZZmoney, CFGDJZmoney, CFYXJZmoney, CFYZmoney, CFKNWmoney, CFMBmoney, CFXFmoney, CFEYmoney ";
			insertValueSql +=  ", "+byzzMoney+" ,0,0" +
				" ,0 ,0 ,0 "+
				" ,0 ,0 ";
			
			
			bymoney = byzzMoney.setScale(2,BigDecimal.ROUND_HALF_UP);  
			
			
			clinicCostSumInfo.setAllzzCost(clinicCostSumInfo.getUpzzCost().add(clinicCostSumInfo.getImzzCost())); 
			ClinicCostSumFactory.getLocalInstance(ctx).save(clinicCostSumInfo);
			
			//
			costAll = costAll.add(clinicCostSumInfo.getAllzzCost()); 
			
			BigDecimal sumAchieve =  byzz.add(bygdjz).add(byyxjz).add(byyz).add(byknw).add(bymb).add(byxf).add(byey); 
			
			insertSql +=  ", cfzzcost , cfgdjzcost , cfyxjzcost , cfyzcost , cfknwcost , cfmbcost , cfxfcost , cfeycost  ";
			insertValueSql += " ,"+clinicCostSumInfo.getAllzzCost()+" ,0"
				+" ,0,0"
				+" ,0 ,0"
				+" ,0 ,0";
			 
			if(sumAchieve.compareTo(BigDecimal.ZERO) <= 0){
				insertSql +=  ", CFZZpro , CFGDpro , cfyxpro, CFyzpro , cfknwpro , cfmbpro , cfxfpro, cfeypro  ";
				insertValueSql +=" ,0 ,0,0,0,0,0,0,0 ";
			}else{
				insertSql +=  ", CFZZpro , CFGDpro , cfyxpro, CFyzpro , cfknwpro , cfmbpro , cfxfpro, cfeypro  ";
				insertValueSql +=" ,"+byzz.divide(sumAchieve,6, BigDecimal.ROUND_HALF_UP)+" ,"+bygdjz.divide(sumAchieve,6, BigDecimal.ROUND_HALF_UP)+
				","+byyxjz.divide(sumAchieve,6, BigDecimal.ROUND_HALF_UP)+","+0+
				","+byknw.divide(sumAchieve,6, BigDecimal.ROUND_HALF_UP)+","+0+
				","+byxf.divide(sumAchieve,6, BigDecimal.ROUND_HALF_UP)+","+byey.divide(sumAchieve,6, BigDecimal.ROUND_HALF_UP)+" ";
				
			}
			 
			
			
			StringBuffer sbr2  = new StringBuffer(" /*dialect*/insert into CT_PAY_ClinicAchieveCosthSum (FID,FCreatorID,FCreateTime,FLastUpdateUserID,FLastUpdateTime, ");
    		sbr2.append(" cfposttype , cfbusinessdate, CFCLINICNUMBER,CFCLINICName,cfempnumber,cfempname,CFCITYNUMBER,CFCITYName,CFJyCount, CFPlaCount , CFWhiteAchieve  "+insertSql+" "+imandxtinsertsql+",cfiszidai,cfsumachieve ) ");
    		sbr2.append("values(newbosid('20D1E187'),'"+userId+"',sysdate,'"+userId+"',sysdate, ");
    		sbr2.append(" 'JZYS', '"+periodnum+"','"+clinicNumber+"','"+clinicName+"' ,'"+empNum+"','"+tempMap.get("empName").toString()+"','"+cityNumber+"','"+tempMap.get("cityName").toString()+"' ,"+0+" ,"+0+" ,"+0+"  "+insertValueSql+" "+imandxtinsertValueSql+",1,"+noFreeAchieve+")");  
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
	
	
	public  StringBuffer getSHHushiZiDaiChengBenSql(String empNums, String clinicNumber ,String cityNumber,String periodnum,StringBuffer sqlCB){
		sqlCB.append(" /*dialect*/ select ( nvl(sum(cfxhzz),0) +nvl(sum(cfjgfzz),0)) as summ,'zz' as type  from  CT_PAY_CostByUpdate  where cfperiod = '"+periodnum+"' and cfclinicnumber='"+clinicNumber+"'  and cfcitynumber='"+cityNumber+"' and  cfdoctornumber ="+empNums+"  and cfiszidai = 1   union ").append("\r\n");
		sqlCB.append(" 	select ( nvl(sum(cfxhyxjz),0) +nvl(sum(cfjgfyxjz),0)) as summ,'yxjz' as type  from  CT_PAY_CostByUpdate  where cfperiod = '"+periodnum+"' and cfclinicnumber='"+clinicNumber+"'  and cfcitynumber='"+cityNumber+"'  and  cfdoctornumber ="+empNums+" and cfiszidai = 1  union ").append("\r\n");
		sqlCB.append(" 	select ( nvl(sum(cfxhcgjz),0) +nvl(sum(cfjgfcgjz),0)) as summ,'gdjz' as type  from  CT_PAY_CostByUpdate  where cfperiod = '"+periodnum+"' and cfclinicnumber='"+clinicNumber+"'  and cfcitynumber='"+cityNumber+"'   and  cfdoctornumber  ="+empNums+"  and cfiszidai = 1  union ").append("\r\n");
		sqlCB.append(" 	select ( nvl(sum(cfxhknw),0) +nvl(sum(cfjgfknw),0)) as summ,'knw' as type  from  CT_PAY_CostByUpdate  where cfperiod = '"+periodnum+"' and cfclinicnumber='"+clinicNumber+"'  and cfcitynumber='"+cityNumber+"'    and  cfdoctornumber  ="+empNums+" and cfiszidai = 1   union ").append("\r\n");
		sqlCB.append(" 	select ( nvl(sum(cfxhxf),0) +nvl(sum(cfjgfxf),0)) as summ,'xf' as type  from  CT_PAY_CostByUpdate  where cfperiod = '"+periodnum+"'  and cfclinicnumber='"+clinicNumber+"'  and cfcitynumber='"+cityNumber+"' and  cfdoctornumber ="+empNums+" and cfiszidai = 1  union ").append("\r\n");
		sqlCB.append(" 	select ( nvl(sum(cfxhey),0) +nvl(sum(cfjgfey),0)) as summ,'ey' as type  from  CT_PAY_CostByUpdate  where cfperiod = '"+periodnum+"'  and cfclinicnumber='"+clinicNumber+"'  and cfcitynumber='"+cityNumber+"'  and  cfdoctornumber  ="+empNums+"  and cfiszidai = 1  union ").append("\r\n");
		sqlCB.append(" 	select ( nvl(sum(cfxhyz),0) +nvl(sum(cfjgfyz),0)) as summ,'yz' as type  from  CT_PAY_CostByUpdate  where cfperiod = '"+periodnum+"' and cfclinicnumber='"+clinicNumber+"'  and cfcitynumber='"+cityNumber+"'   and  cfdoctornumber  ="+empNums+"   and cfiszidai = 1  union ").append("\r\n");
		sqlCB.append(" 	select ( nvl(sum(cfjgfmb),0) +nvl(sum(cfxhmb),0) ) as summ,'mb' as type  from  CT_PAY_CostByUpdate  where cfperiod = '"+periodnum+"' and cfclinicnumber='"+clinicNumber+"'  and cfcitynumber='"+cityNumber+"'  and  cfdoctornumber  ="+empNums+"  and cfiszidai = 1   ");
		
		return sqlCB;
	}
	
	public StringBuffer getSHImportZiDaiChengBenSql(String empNums, String clinicNumber ,String cityID,String periodnum,StringBuffer sqlCB){ 
		sqlCB.append(" /*dialect*/select ( nvl(sum(cfzjcost),0) ) as summ,'zz' as type   FROM  CT_PAY_DoctorCosts  where CFBUSINESSDATE ='"+periodnum+"' and cfMZNUMBER='"+clinicNumber+"' and cfcityid='"+cityID+"'  and  cfempNumber ="+empNums+"  and cfiszidai = 1  ").append("\r\n");
		sqlCB.append(" union select ( nvl(sum(cfyxcost),0) ) as summ,'yxjz' as type   FROM CT_PAY_DoctorCosts  where CFBUSINESSDATE ='"+periodnum+"'  and cfMZNUMBER='"+clinicNumber+"'   and cfcityid='"+cityID+"' and  cfempNumber  ="+empNums+" and cfiszidai = 1  ").append("\r\n");
		sqlCB.append(" 	 union select ( nvl(sum(cfgdcost),0) ) as summ,'gdjz' as type   FROM CT_PAY_DoctorCosts  where CFBUSINESSDATE ='"+periodnum+"'  and cfMZNUMBER='"+clinicNumber+"'  and cfcityid='"+cityID+"'  and  cfempNumber ="+empNums+"  and cfiszidai = 1  ").append("\r\n");
		sqlCB.append(" 	 union select ( nvl(sum(cfkncost),0)) as summ,'knw' as type   FROM CT_PAY_DoctorCosts  where CFBUSINESSDATE ='"+periodnum+"'  and cfMZNUMBER='"+clinicNumber+"'  and cfcityid='"+cityID+"'  and  cfempNumber  ="+empNums+"  and cfiszidai = 1   ").append("\r\n");
		sqlCB.append(" 	 union select ( nvl(sum(cfxfcost),0) ) as summ,'xf' as type   FROM CT_PAY_DoctorCosts  where CFBUSINESSDATE ='"+periodnum+"'  and cfMZNUMBER='"+clinicNumber+"'  and cfcityid='"+cityID+"'  and  cfempNumber ="+empNums+"  and cfiszidai = 1  ").append("\r\n");
		sqlCB.append(" 	 union select ( nvl(sum(cfeycost),0)) as summ,'ey' as type   FROM CT_PAY_DoctorCosts  where CFBUSINESSDATE ='"+periodnum+"'  and cfMZNUMBER='"+clinicNumber+"'  and cfcityid='"+cityID+"'  and  cfempNumber ="+empNums+"  and cfiszidai = 1   ").append("\r\n");
		sqlCB.append(" 	 union select ( nvl(sum(cfzbcost),0)) as summ,'yz' as type   FROM CT_PAY_DoctorCosts  where CFBUSINESSDATE ='"+periodnum+"'  and cfMZNUMBER='"+clinicNumber+"'  and cfcityid='"+cityID+"' and  cfempNumber ="+empNums+"  and cfiszidai = 1  ").append("\r\n");
		sqlCB.append(" 	 union select ( nvl(sum(cfmbcost),0)) as summ,'mb' as type  FROM CT_PAY_DoctorCosts  where CFBUSINESSDATE ='"+periodnum+"'  and cfMZNUMBER='"+clinicNumber+"'  and cfcityid='"+cityID+"' and  cfempNumber  ="+empNums+"  and cfiszidai = 1  ").append("\r\n");
		
		return sqlCB;
	}
	public StringBuffer getSHYeJiZIDaiImpSql(String empNum, String clinicNumber , String cityNumber,String periodnum,StringBuffer sqlYJ,String cityId){
		//��ֲ   and CFClinicNumber='"+clinicNumber+"'
		sqlYJ.append("  /*dialect*/ SELECT  nvl( sum(cfzzachieve),0) as ZZ , nvl(sum(cfyxjzachieve),0) as YXJZ , nvl(sum(cfgdjzachieve),0) as GDJZ , nvl(sum(cfknwachieve),0) as KNW , nvl(sum(cfxfachieve),0) as XF , nvl(sum(cfeyachieve),0) as EY , nvl(sum(cfyzachieve),0) as YZ , nvl(sum(cfmbachieve),0) as MB , nvl(sum(cfjzmoney),0) as JZ   ").append("\r\n")
		.append(" FROM  CT_PAY_DocAchieveUpdate where  cfiszidai = 1  and cfclinicnumber ='"+clinicNumber+"'  and cfdocnumber = '"+empNum+"' and  cfbusinessdate = '"+periodnum+"' and cfcityid = '"+cityId+"'  and  fname_l2 is null  ");
		  
		return sqlYJ;
	} 
	
	/**
	 * ͳ�Ƽ�ְҽ���Դ����ߵ�ҵ��
	 * @param empNum
	 * @param clinicNumber
	 * @param periodnum
	 * @param empName
	 * @return
	 */
	public  static StringBuffer getSHZiDaiYeJiSql(String empNum, String clinicNumber ,String cityNumber,String periodnum,String empName, String cityId,String firSource,BigDecimal firSourcePro,BigDecimal freeWorkPro,BigDecimal gifAmountPro,String type
			,HashMap<String,String> oneItemMap,HashMap<String,String>  twoItemMap,HashMap<String,String>  threeItemMap){
		HashMap<String, BigDecimal> map = new  HashMap<String, BigDecimal>();
		//��ֲ
		String zzOneItem = "''"; if(oneItemMap.get("ZZ")!= null)    zzOneItem = oneItemMap.get("ZZ");
		String zzTwoItem = "''"; if(twoItemMap.get("ZZ")!= null)    zzTwoItem = twoItemMap.get("ZZ");
		String zzThreeItem = "''"; if(threeItemMap.get("ZZ")!= null)  zzThreeItem = threeItemMap.get("ZZ");
		//����
		String zjOneItem = "''"; if(oneItemMap.get("ZJ")!= null)    zjOneItem = oneItemMap.get("ZJ");
		String zjTwoItem = "''"; if(twoItemMap.get("ZJ")!= null)    zjTwoItem = twoItemMap.get("ZJ");
		String zjThreeItem = "''"; if(threeItemMap.get("ZJ")!= null)  zjThreeItem = threeItemMap.get("ZJ");
		//�޸�
		String xfOneItem = "''"; if(oneItemMap.get("XF")!= null)    xfOneItem = oneItemMap.get("XF");
		String xfTwoItem = "''"; if(twoItemMap.get("XF")!= null)    xfTwoItem = twoItemMap.get("XF");
		String xfThreeItem = "''"; if(threeItemMap.get("XF")!= null)  xfThreeItem = threeItemMap.get("XF");
		//����
		String eyOneItem = "''"; if(oneItemMap.get("EY")!= null)    eyOneItem = oneItemMap.get("EY");
		String eyTwoItem = "''"; if(twoItemMap.get("EY")!= null)    eyTwoItem = twoItemMap.get("EY");
		String eyThreeItem = "''"; if(threeItemMap.get("EY")!= null)  eyThreeItem = threeItemMap.get("EY");
		//������
		String knwOneItem = "''"; if(oneItemMap.get("KNW")!= null)    knwOneItem = oneItemMap.get("KNW");
		String knwTwoItem = "''"; if(twoItemMap.get("KNW")!= null)    knwTwoItem = twoItemMap.get("KNW");
		String knwThreeItem = "''"; if(threeItemMap.get("KNW")!= null)  knwThreeItem = threeItemMap.get("KNW");
		//����
		String yzOneItem = "''"; if(oneItemMap.get("YZ")!= null)    yzOneItem = oneItemMap.get("YZ");
		String yzTwoItem = "''"; if(twoItemMap.get("YZ")!= null)    yzTwoItem = twoItemMap.get("YZ");
		String yzThreeItem = "''"; if(threeItemMap.get("YZ")!= null)  yzThreeItem = threeItemMap.get("YZ");
		//����
		String mbOneItem = "''"; if(oneItemMap.get("MB")!= null)    mbOneItem = oneItemMap.get("MB");
		String mbTwoItem = "''"; if(twoItemMap.get("MB")!= null)    mbTwoItem = twoItemMap.get("MB");
		String mbThreeItem = "''"; if(threeItemMap.get("MB")!= null)  mbThreeItem = threeItemMap.get("MB");
		String dateSql = "";
		if(type.equals("ZC")){
			dateSql = "  to_char(fbizdate, 'yyyymm') = '"+periodnum+"' and  ";
		}else if(type.equals("CBQR")){
			dateSql = "  CFBUSINESSDATE = '"+periodnum+"' and  (cfisneedout = 0 or ( cfisneedout=1 and cfisout = 1))  and  ";
		}
		
		StringBuffer sqlYJ = new StringBuffer(); 
		// �Դ����ߵ�һ���������ǲ����۵�ȡ��  ���� �⹤���� �� ���⹤������  �������ۿ�
		 //��ֲ�⹤����ҵ��
		sqlYJ.append(" /*dialect*/select sum(amount) as sumamount , 'freezz' as type from (select  (nvl(sum(cfdocachieve),0)) as amount  from  CT_PAY_AchieveDetailTem  where "+dateSql+"  cfrecdotnumber = '"+empNum+"' and  cfclinicnumber ='"+clinicNumber+"'  and cfincome  =0  and  cfpayment =0   and cfiscount= 1 "+
				" and ( cffirclassnumber in  ("+zzOneItem+") or cfsecclassnumber in ("+zzTwoItem+") or cffeeitemdetailnumber in  ("+zzThreeItem+")  )  and cffirsource not in ( "+firSource+" ) and cfbusitype = '�Һ�����' )  ").append("\r\n");
		//��ֲ���⹤����ҵ��
		sqlYJ.append(" union select sum(amount) as sumamount , 'zz' as type from ( select  (nvl(sum(cfdocachieve),0)) as amount  from  CT_PAY_AchieveDetailTem  where "+dateSql+"  cfrecdotnumber = '"+empNum+"'   and  cfclinicnumber ='"+clinicNumber+"'  and (cfincome!=0 or cfpayment!=0)  and cfiscount= 1 "+
				" and ( cffirclassnumber in  ("+zzOneItem+") or cfsecclassnumber in ("+zzTwoItem+") or cffeeitemdetailnumber in  ("+zzThreeItem+")  )  and cffirsource not in ( "+firSource+" )  )    ").append("\r\n");
		//�����⹤����
		sqlYJ.append(" union select sum(amount) as sumamount , 'freeyx' as type from (select  (nvl(sum(cfdocachieve),0))  as amount  from  CT_PAY_AchieveDetailTem  where "+dateSql+"  cfrecdotnumber = '"+empNum+"'   and  cfclinicnumber ='"+clinicNumber+"'  and cfincome  =0  and  cfpayment =0  and cfiscount= 1 "+
				" and ( cffirclassnumber in  ("+zjOneItem+") or cfsecclassnumber in ("+zjTwoItem+") or cffeeitemdetailnumber in  ("+zjThreeItem+")  )  and CFISROUTINE = '��' and cffirsource not in ( "+firSource+" ) and cfbusitype = '�Һ�����' )   ").append("\r\n");
		//���η��⹤����ҵ��
		sqlYJ.append(" union select sum(amount) as sumamount , 'yx' as type from (select   (nvl(sum(cfdocachieve),0)) as amount  from  CT_PAY_AchieveDetailTem  where "+dateSql+"  cfrecdotnumber = '"+empNum+"'   and  cfclinicnumber ='"+clinicNumber+"'  and (cfincome!=0 or cfpayment!=0)  and cfiscount= 1 "+
				" and ( cffirclassnumber in  ("+zjOneItem+") or cfsecclassnumber in ("+zjTwoItem+") or cffeeitemdetailnumber in  ("+zjThreeItem+")  )  and CFISROUTINE = '��' and cffirsource not in ( "+firSource+" )  )  ").append("\r\n");
		//�����⹤����
		sqlYJ.append(" union select sum(amount) as sumamount , 'freegd' as type from (select   (nvl(sum(cfdocachieve),0))  as amount  from  CT_PAY_AchieveDetailTem  where "+dateSql+"  cfrecdotnumber = '"+empNum+"'   and  cfclinicnumber ='"+clinicNumber+"'  and cfincome  =0  and  cfpayment =0  and cfiscount= 1 "+
				" and ( cffirclassnumber in  ("+zjOneItem+") or cfsecclassnumber in ("+zjTwoItem+") or cffeeitemdetailnumber in  ("+zjThreeItem+")  )  and CFISROUTINE = '��' and cffirsource not in ( "+firSource+" ) and cfbusitype = '�Һ�����' )  ").append("\r\n");
		//������⹤����ҵ��
		sqlYJ.append(" union select sum(amount) as sumamount , 'gd' as type from (select    (nvl(sum(cfdocachieve),0))  as amount  from  CT_PAY_AchieveDetailTem  where "+dateSql+"  cfrecdotnumber = '"+empNum+"'   and  cfclinicnumber ='"+clinicNumber+"'  and (cfincome!=0 or cfpayment!=0)   and cfiscount= 1 "+
				" and ( cffirclassnumber in  ("+zjOneItem+") or cfsecclassnumber in ("+zjTwoItem+") or cffeeitemdetailnumber in  ("+zjThreeItem+")  )  and CFISROUTINE = '��' and cffirsource not in ( "+firSource+" )  )   ").append("\r\n");
		//�������⹤����
		sqlYJ.append(" union select sum(amount) as sumamount , 'freeknw' as type from ( select  (nvl(sum(cfdocachieve),0)) as amount  from  CT_PAY_AchieveDetailTem  where "+dateSql+"  cfrecdotnumber = '"+empNum+"'  and  cfclinicnumber ='"+clinicNumber+"'  and cfincome  =0  and  cfpayment =0  and cfiscount= 1 "+
				" and ( cffirclassnumber in  ("+knwOneItem+") or cfsecclassnumber in ("+knwTwoItem+") or cffeeitemdetailnumber in  ("+knwThreeItem+")  )  and cffirsource not in ( "+firSource+" )  and cfbusitype = '�Һ�����' )   ").append("\r\n");
		//��������⹤����ҵ��
		sqlYJ.append(" union select sum(amount) as sumamount , 'knw' as type from ( select  (nvl(sum(cfdocachieve),0)) as amount  from  CT_PAY_AchieveDetailTem  where "+dateSql+"  cfrecdotnumber = '"+empNum+"'  and  cfclinicnumber ='"+clinicNumber+"'  and (cfincome!=0 or cfpayment!=0)  and cfiscount= 1 and cffirsource not in ( "+firSource+" )  "+
				" and ( cffirclassnumber in  ("+knwOneItem+") or cfsecclassnumber in ("+knwTwoItem+") or cffeeitemdetailnumber in  ("+knwThreeItem+")  )  )   ").append("\r\n");
		//�����⹤����
		sqlYJ.append(" union select sum(amount) as sumamount , 'freeey' as type from ( select  (nvl(sum(cfdocachieve),0)) as amount  from  CT_PAY_AchieveDetailTem  where "+dateSql+"  cfrecdotnumber = '"+empNum+"'  and  cfclinicnumber ='"+clinicNumber+"'  and cfincome  =0  and  cfpayment =0   and cfiscount= 1 "+
				" and ( cffirclassnumber in  ("+eyOneItem+") or cfsecclassnumber in ("+eyTwoItem+") or cffeeitemdetailnumber in  ("+eyThreeItem+")  )  and cffirsource not in ( "+firSource+" )  and cfbusitype = '�Һ�����' )  ").append("\r\n");
		//�������⹤����ҵ��
		sqlYJ.append(" union select sum(amount) as sumamount , 'ey' as type from ( select  (nvl(sum(cfdocachieve),0)) as amount  from  CT_PAY_AchieveDetailTem  where "+dateSql+"  cfrecdotnumber = '"+empNum+"'  and  cfclinicnumber ='"+clinicNumber+"'  and (cfincome!=0 or cfpayment!=0)  and cfiscount= 1 and cffirsource not in ( "+firSource+" )  "+
				" and ( cffirclassnumber in  ("+eyOneItem+") or cfsecclassnumber in ("+eyTwoItem+") or cffeeitemdetailnumber in  ("+eyThreeItem+")  )  )   ").append("\r\n");
		//�޸��⹤����
		sqlYJ.append(" union select sum(amount) as sumamount , 'freexf' as type from ( select  (nvl(sum(cfdocachieve),0)) as amount  from  CT_PAY_AchieveDetailTem  where "+dateSql+"  cfrecdotnumber = '"+empNum+"'  and  cfclinicnumber ='"+clinicNumber+"'  and cfincome  =0  and  cfpayment =0  and cfiscount= 1 "+
				" and ( cffirclassnumber in  ("+xfOneItem+") or cfsecclassnumber in ("+xfTwoItem+") or cffeeitemdetailnumber in  ("+xfThreeItem+")  )  and cffirsource not in ( "+firSource+" )   and cfbusitype = '�Һ�����' ) ").append("\r\n");
		//�޸����⹤����ҵ��
		sqlYJ.append(" union select sum(amount) as sumamount , 'xf' as type from ( select  (nvl(sum(cfdocachieve),0)) as amount  from  CT_PAY_AchieveDetailTem  where "+dateSql+"  cfrecdotnumber = '"+empNum+"'  and  cfclinicnumber ='"+clinicNumber+"'  and (cfincome!=0 or cfpayment!=0)  and cfiscount= 1 and cffirsource not in ( "+firSource+" )  "+
				" and ( cffirclassnumber in  ("+xfOneItem+") or cfsecclassnumber in ("+xfTwoItem+") or cffeeitemdetailnumber in  ("+xfThreeItem+")  )  )   ").append("\r\n");
//		//�����⹤����    ���ܣ�һ����������������ף����������������ơ����⣺ȫ��ҽ��    ����������������ף������շ����һ��������н��ﻤʿ������ﻤʿ���������ҽ��
//		sqlYJ.append(" union select sum(amount) as sumamount , 'freeyz' as type from ( select nvl(sum(cforiprice*cfqty)*"+freeWorkPro+",0) as amount  from  CT_PAY_AchieveDetailTem  where "+dateSql+"  cfrecdotnumber = '"+empNum+"'  and  cfclinicnumber ='"+clinicNumber+"'  and cfincome  =0  and  cfpayment =0 and cffirclassNumber ='7' and cfbusitype = '�Һ�����'  and cfiscount= 1 and cffirsource not in ( "+firSource+" )  and   ").append("\r\n");
//		sqlYJ.append(" ( EXISTS (SELECT  1  FROM  CT_SRQ_ItemCheck bill  inner join CT_SRQ_ItemCheckEntry entry on entry.fparentid = bill.fid  left JOIN  CT_SRQ_Paytypeitem  second on second.fid = entry.cfseconditemid   where cfcityid = '"+cityId+"' and  cftypenumber = 'YZ' and second.fnumber = CT_PAY_AchieveDetailTem.CFSECCLASSNUMBER ) or  EXISTS (SELECT  1  FROM  CT_SRQ_ItemCheck bill  inner join CT_SRQ_ItemCheckEntry entry on entry.fparentid = bill.fid left JOIN  CT_SRQ_PayItem  item on  item.fid = entry.cfitemid  where cfcityid = '"+cityId+"' and  cftypenumber = 'YZ' and item.fnumber = CT_PAY_AchieveDetailTem.CFFEEITEMDETAILNUMBER ) )   ").append("\r\n");
//		sqlYJ.append("  union select nvl(sum(cforiprice*cfqty)*"+freeWorkPro+",0) as amount  from  CT_PAY_AchieveDetailTem  where "+dateSql+"  cfrecdotnumber = '"+empNum+"'  and  cfclinicnumber ='"+clinicNumber+"'  and cfincome  =0  and  cfpayment =0 and cffirclassNumber ='7'  and cfbusitype = '�Һ�����'  and cfiscount= 1 and cffirsource not in ( "+firSource+" )  and  not EXISTS ( SELECT 1 FROM  CT_PAY_PayPost  paypost where paypost.cfcityid = '"+cityId+"' and paypost.cfbusinessdate = '"+periodnum+"' and cfpostnumber ='HS' AND CFSTATUS = 'qy' and paypost.cfempnumber = CT_PAY_AchieveDetailTem.CFNURSENUMBER  )  and  ").append("\r\n");
//		sqlYJ.append("  ( EXISTS (SELECT  1  FROM  CT_SRQ_ItemCheck bill  inner join CT_SRQ_ItemCheckEntry entry on entry.fparentid = bill.fid  left JOIN  CT_SRQ_Paytypeitem  second on second.fid = entry.cfseconditemid   where cfcityid = '"+cityId+"' and  cftypenumber in ('JY','MB')  and second.fnumber = CT_PAY_AchieveDetailTem.CFSECCLASSNUMBER ) or  EXISTS (SELECT  1  FROM  CT_SRQ_ItemCheck bill  inner join CT_SRQ_ItemCheckEntry entry on entry.fparentid = bill.fid left JOIN  CT_SRQ_PayItem  item on  item.fid = entry.cfitemid  where cfcityid = '"+cityId+"' and  cftypenumber in ('JY','MB') and item.fnumber = CT_PAY_AchieveDetailTem.CFFEEITEMDETAILNUMBER ) ) )  ").append("\r\n");
//		//���ܷ��⹤����ҵ��
//		sqlYJ.append(" union select sum(amount) as sumamount , 'yz' as type from ( select (nvl(sum(cfpayment),0)-(nvl(sum(cfgiftpayment),0)*"+gifAmountPro+")) as amount  from  CT_PAY_AchieveDetailTem  where "+dateSql+"  cfrecdotnumber = '"+empNum+"'  and  cfclinicnumber ='"+clinicNumber+"'  and (cfincome!=0 or cfpayment!=0) and cffirclassNumber ='7'  and cfiscount= 1 and cffirsource not in ( "+firSource+" )  and   ").append("\r\n");
//		sqlYJ.append(" ( EXISTS (SELECT  1  FROM  CT_SRQ_ItemCheck bill  inner join CT_SRQ_ItemCheckEntry entry on entry.fparentid = bill.fid  left JOIN  CT_SRQ_Paytypeitem  second on second.fid = entry.cfseconditemid   where cfcityid = '"+cityId+"' and  cftypenumber = 'YZ' and second.fnumber = CT_PAY_AchieveDetailTem.CFSECCLASSNUMBER ) or  EXISTS (SELECT  1  FROM  CT_SRQ_ItemCheck bill  inner join CT_SRQ_ItemCheckEntry entry on entry.fparentid = bill.fid left JOIN  CT_SRQ_PayItem  item on  item.fid = entry.cfitemid  where cfcityid = '"+cityId+"' and  cftypenumber = 'YZ' and item.fnumber = CT_PAY_AchieveDetailTem.CFFEEITEMDETAILNUMBER ) )   ").append("\r\n");
//		sqlYJ.append(" union select (nvl(sum(cfpayment),0)-(nvl(sum(cfgiftpayment),0)*"+gifAmountPro+")) as amount  from  CT_PAY_AchieveDetailTem  where "+dateSql+"  cfrecdotnumber = '"+empNum+"'  and  cfclinicnumber ='"+clinicNumber+"'  and (cfincome!=0 or cfpayment!=0) and cffirclassNumber ='7'  and cfiscount= 1 and cffirsource not in ( "+firSource+" )  and  not EXISTS ( SELECT 1 FROM  CT_PAY_PayPost  paypost where paypost.cfcityid = '"+cityId+"' and paypost.cfbusinessdate = '"+periodnum+"' and cfpostnumber ='HS' AND CFSTATUS = 'qy' and paypost.cfempnumber = CT_PAY_AchieveDetailTem.CFNURSENUMBER  )  and   ").append("\r\n");
//		sqlYJ.append(" ( EXISTS (SELECT  1  FROM  CT_SRQ_ItemCheck bill  inner join CT_SRQ_ItemCheckEntry entry on entry.fparentid = bill.fid  left JOIN  CT_SRQ_Paytypeitem  second on second.fid = entry.cfseconditemid   where cfcityid = '"+cityId+"' and  cftypenumber in ('JY','MB')  and second.fnumber = CT_PAY_AchieveDetailTem.CFSECCLASSNUMBER ) or  EXISTS (SELECT  1  FROM  CT_SRQ_ItemCheck bill  inner join CT_SRQ_ItemCheckEntry entry on entry.fparentid = bill.fid left JOIN  CT_SRQ_PayItem  item on  item.fid = entry.cfitemid  where cfcityid = '"+cityId+"' and  cftypenumber in ('JY','MB') and item.fnumber = CT_PAY_AchieveDetailTem.CFFEEITEMDETAILNUMBER ) ) )");

		//�����⹤����    ���ܣ�һ����������������ף����������������ơ����⣺ȫ��ҽ��    ����������������ף������շ����һ��������н��ﻤʿ������ﻤʿ���������ҽ��
		sqlYJ.append(" union select sum(amount) as sumamount , 'freeyz' as type from ( select  (nvl(sum(cfdocachieve),0)) as amount  from  CT_PAY_AchieveDetailTem  where "+dateSql+"  cfrecdotnumber = '"+empNum+"'  and  cfclinicnumber ='"+clinicNumber+"'  and cfincome  =0  and  cfpayment =0 "+
				" and ( cffirclassnumber in  ("+yzOneItem+") or cfsecclassnumber in ("+yzTwoItem+") or cffeeitemdetailnumber in  ("+yzThreeItem+")  )  and cfbusitype = '�Һ�����'  and cfiscount= 1 and cffirsource not in ( "+firSource+" )     ").append("\r\n");
		sqlYJ.append("   ").append("\r\n");
		sqlYJ.append("   )  ").append("\r\n");
		//���ܷ��⹤����ҵ��
		sqlYJ.append(" union select sum(amount) as sumamount , 'yz' as type from ( select  (nvl(sum(cfdocachieve),0)) as amount  from  CT_PAY_AchieveDetailTem  where "+dateSql+"  cfrecdotnumber = '"+empNum+"'  and  cfclinicnumber ='"+clinicNumber+"'  and (cfincome!=0 or cfpayment!=0) "+
				" and ( cffirclassnumber in  ("+yzOneItem+") or cfsecclassnumber in ("+yzTwoItem+") or cffeeitemdetailnumber in  ("+yzThreeItem+")  )   and cfiscount= 1 and cffirsource not in ( "+firSource+" )     ").append("\r\n");
		sqlYJ.append(" ").append("\r\n");
		sqlYJ.append(" )");
		  
		
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
        //Ȼ��ͨ���Ƚ�����ʵ������
        Collections.sort(list,new Comparator<Map.Entry<String,BigDecimal>>() {
            //��������
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
		if(calType != null  && calType.equals("zskc")){//����۳�
			//���� ����map  ����ƽ������ 
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
				        	
				        if(negValue.multiply(negBili).negate().compareTo(value.multiply(bili)) > 0){//û�е���  ������
				        	it.remove();
				        	justMap.remove(key);
				        	it = justMap.keySet().iterator();
				        	
				        	allMap.put("neg"+key,value.abs());
				        	
			                negValue = negValue.add(value.multiply(bili).divide(negBili,6,BigDecimal.ROUND_HALF_UP));
			                negMap.put(negKey,negValue);
			                /*negit.remove();
			                negMap.remove(negKey);
			                negMap.put(negKey,negValue);
			                negit = negMap.keySet().iterator();*/
			                
			                if(justMap.size() == 0){
			                	break;
			                }
			            }else if(negValue.multiply(negBili).compareTo(value.multiply(bili)) == 0){//�պõ���
		                    it.remove();
		                    justMap.remove(key);
				        	it = justMap.keySet().iterator();
				        	
				        	allMap.put("neg"+key,value.abs());
				        	
		                    negit.remove();
		                	negMap.remove(negKey);
		                	negit = negMap.keySet().iterator();
		                	
		                    break;
		                }else{//����  ���һ����
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
	    //allMap ��ֻ���������  ȫ����  ȫ�Ǹ�    ����ֻ��0
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
	
	private  BigDecimal docZiDai1(Context ctx, HashMap map ,String empNum, String cityNumber,String periodnum ,String clinicNumber,String clinicName , HashMap tempMap ,String cityId,
			String firSource,BigDecimal firSourcePro,BigDecimal freeWorkPro,BigDecimal gifAmountPro,String calType,String type
			,HashMap<String,String> oneItemMap,HashMap<String,String>  twoItemMap,HashMap<String,String>  threeItemMap){ 
		ExecutorService pool = Executors.newFixedThreadPool(6);
	    ParallelSqlExecutor pe = new ParallelSqlExecutor(pool); 
	    String userId = ContextHelperFactory.getLocalInstance(ctx).getCurrentUser().getId().toString(); 
	    BigDecimal bymoney = BigDecimal.ZERO;
		
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
		
		BigDecimal costAll = BigDecimal.ZERO; 
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
		clinicCostSumInfo.setClinicName(clinicName);
		clinicCostSumInfo.setClinicNumber(clinicNumber);
		clinicCostSumInfo.setCityNumber(cityNumber);
		clinicCostSumInfo.setBusinessDate(periodnum); 
		clinicCostSumInfo.setCityName(tempMap.get("cityName").toString());
		clinicCostSumInfo.setEmpName(tempMap.get("empName").toString());
		clinicCostSumInfo.setIzzidai(true);
		//�����Դ�����
		//�Դ����� ��ֲ ҵ��
		BigDecimal byzz = BigDecimal.ZERO;
		//�Դ����� �̶�����ҵ��
		BigDecimal bygdjz = BigDecimal.ZERO; 
		//�Դ����� ���ν���ҵ��
		BigDecimal byyxjz = BigDecimal.ZERO; 
		//�Դ����� ����ҵ��
		BigDecimal byyz = BigDecimal.ZERO; 
		//�Դ����� ������ҵ��
		BigDecimal byknw = BigDecimal.ZERO; 
		//�Դ����� ����ҵ��
		BigDecimal bymb = BigDecimal.ZERO; 
		//�Դ����� �޸�ҵ��
		BigDecimal byxf = BigDecimal.ZERO; 
		//�Դ����� ����ҵ��
		BigDecimal byey = BigDecimal.ZERO; 
		
		//�Դ����� ��ֲ 
		BigDecimal byzzbl = new BigDecimal(map.get("CFBYZZPRO").toString());
		//�Դ����� �̶�����
		BigDecimal bygdjzbl = new BigDecimal(map.get("CFBYGDJZPRO").toString());
		//�Դ����� ���ν���
		BigDecimal byyxjzbl =  new BigDecimal(map.get("CFBYYXJZPRO").toString());
		//�Դ����� ����
		BigDecimal byyzbl =  new BigDecimal(map.get("CFBYYZPRO").toString());//?
		//�Դ����� ������
		BigDecimal byknwbl = new BigDecimal(map.get("CFBYKNWPRO").toString());
		//�Դ����� ����
		BigDecimal bymbbl = new BigDecimal(map.get("CFBYMBPRO").toString());
		//�Դ����� �޸�
		BigDecimal byxfbl = new BigDecimal(map.get("CFBYXFPRO").toString());
		//�Դ����� ����
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
		biliMap.put("zj",BigDecimal.ONE );
		
		String insertSql =  "";
		String insertValueSql = "";
		String imandxtinsertsql = "";
		String imandxtinsertValueSql = "";
		try {  
			String empName = map.get("CFDOCNAME").toString();
			

			StringBuffer sqlImportYJ = new StringBuffer(); 
			sqlImportYJ = getSHYeJiZIDaiImpSql( empNum, clinicNumber, cityNumber, periodnum, sqlImportYJ, cityId);
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
			  		
			  	    //������ֲ
					imzz = yjImprs.getBigDecimal("ZZ");
					//����̶�����
					imgdjz =yjImprs.getBigDecimal("GDJZ");
					//�������ν���
					imyxjz = yjImprs.getBigDecimal("YXJZ");
					//��������
					imyz = yjImprs.getBigDecimal("YZ");
					//���������
					imknw = yjImprs.getBigDecimal("KNW");
					//��������
					immb = yjImprs.getBigDecimal("MB");
					//�����޸�
					imxf = yjImprs.getBigDecimal("XF");
					//�������
					imey = yjImprs.getBigDecimal("EY");
			  		 
				}
			}
		  	 
			BigDecimal noFreeAchieve = BigDecimal.ZERO; 
			BigDecimal freeAchieve = BigDecimal.ZERO; 
			noFreeAchieve = noFreeAchieve.add(imzz).add(imgdjz).add(imyxjz).add(imyz).add(imknw).add(imxf).add(imey);
			//�����Դ����ߵ� ҵ��
			StringBuffer sqlZD = new StringBuffer();
			sqlZD = getSHZiDaiYeJiSql( empNum,clinicNumber,  cityNumber, periodnum, empName,cityId,firSource,firSourcePro,freeWorkPro,gifAmountPro,type
					, oneItemMap, twoItemMap,  threeItemMap );
			System.out.println("--"+sqlZD);
			IRowSet zdrs = com.kingdee.eas.custom.util.DBUtil.executeQuery(ctx,sqlZD.toString());
			
			if(zdrs!=null && zdrs.size() > 0){
				  while(zdrs.next()){	  
					  if("zz".equals(zdrs.getString("TYPE"))  ){//��ֲ
						  byzz =byzz.add(new BigDecimal(zdrs.getString("SUMAMOUNT")));  
						  
						  imandxtinsertsql +=  ", CFXTZZACHIEVE  ";
						  imandxtinsertValueSql +=" ,"+new BigDecimal(zdrs.getString("SUMAMOUNT"))+" "; 
						  
						  noFreeAchieve =noFreeAchieve.add(new BigDecimal(zdrs.getString("SUMAMOUNT")));
					  }else if("gd".equals(zdrs.getString("TYPE"))   ){//�̶�����  
						  bygdjz=bygdjz.add(new BigDecimal(zdrs.getString("SUMAMOUNT")));  
						  
						  imandxtinsertsql +=  "  , CFXTGDJZACHIEVE  ";
						  imandxtinsertValueSql +="   ,"+new BigDecimal(zdrs.getString("SUMAMOUNT"))+" "; 
						  
						  noFreeAchieve =noFreeAchieve.add(new BigDecimal(zdrs.getString("SUMAMOUNT")));
					  }else if("yx".equals(zdrs.getString("TYPE")) ){//���ν���
						  byyxjz=byyxjz.add(new BigDecimal(zdrs.getString("SUMAMOUNT")));  
						  
						  imandxtinsertsql +=  " , cfXTyxjzachieve ";
						  imandxtinsertValueSql +="  ,"+new BigDecimal(zdrs.getString("SUMAMOUNT"))+" "; 
						  
						  noFreeAchieve =noFreeAchieve.add(new BigDecimal(zdrs.getString("SUMAMOUNT")));
					  }/*else if("yz".equals(zdrs.getString("TYPE")) || "freezz".equals(zdrs.getString("TYPE")) ){//���� ��
						  byyz=byyz.add(new BigDecimal(zdrs.getString("SUMM"))); 
						  insertSql +=  ", CFZyAchieve ";
						  insertValueSql += " ,"+byyz;
						  
						  imandxtinsertsql +=  " , CFXTyzAchieve  ";
						  imandxtinsertValueSql +=" ,"+new BigDecimal(zdrs.getString("SUMM"))+"  ";
					  }*/else if("knw".equals(zdrs.getString("TYPE"))  ){//������ ��
						  byknw =byknw.add(new BigDecimal(zdrs.getString("SUMAMOUNT"))); 
						  

						  imandxtinsertsql +=  "  , cfXTknwachieve   ";
						  imandxtinsertValueSql +="  ,"+new BigDecimal(zdrs.getString("SUMAMOUNT"))+"  "; 
						  
						  noFreeAchieve =noFreeAchieve.add(new BigDecimal(zdrs.getString("SUMAMOUNT")));
					  }else if("yz".equals(zdrs.getString("TYPE")) ){//����
						  bymb=bymb.add(new BigDecimal(zdrs.getString("SUMAMOUNT")));  
						  
						  imandxtinsertsql +=  "  , cfXTmbachieve ";
						  imandxtinsertValueSql +="  ,"+new BigDecimal(zdrs.getString("SUMAMOUNT"))+"   ";
					  }else if("xf".equals(zdrs.getString("TYPE"))  ){//�޸�
						  byxf=byxf.add(new BigDecimal(zdrs.getString("SUMAMOUNT")));  
						  
						  imandxtinsertsql +=  " , cfXTxfachieve ";
						  imandxtinsertValueSql +=" ,"+new BigDecimal(zdrs.getString("SUMAMOUNT"))+"  "; 

						  noFreeAchieve =noFreeAchieve.add(new BigDecimal(zdrs.getString("SUMAMOUNT")));
					  }else if("ey".equals(zdrs.getString("TYPE"))  ){//����
						  byey=byey.add(new BigDecimal(zdrs.getString("SUMAMOUNT")));  
						  
						  imandxtinsertsql +=  " , cfXTeyachieve ";
						  imandxtinsertValueSql +=" ,"+new BigDecimal(zdrs.getString("SUMAMOUNT"))+"  ";
						   
						  noFreeAchieve =noFreeAchieve.add(new BigDecimal(zdrs.getString("SUMAMOUNT")));
					  }else if("freezz".equals(zdrs.getString("TYPE"))){//��ֲ 
						    byzz = byzz.add(new BigDecimal(zdrs.getString("SUMAMOUNT"))); 
				  			imandxtinsertsql += ", CFfreeZZACHIEVE ";
				  			imandxtinsertValueSql += ","+new BigDecimal(zdrs.getString("SUMAMOUNT"))+"";
				  		}else if("freegd".equals(zdrs.getString("TYPE"))){//�̶����� ��
				  			bygdjz= bygdjz.add(new BigDecimal(zdrs.getString("SUMAMOUNT"))); 
				  			imandxtinsertsql += ", CFfreeGDJZACHIEVE ";
				  			imandxtinsertValueSql += ","+new BigDecimal(zdrs.getString("SUMAMOUNT"))+"";
				  		}else if("freeyx".equals(zdrs.getString("TYPE"))){//���ν���
				  			byyxjz= byyxjz.add(new BigDecimal(zdrs.getString("SUMAMOUNT"))); 
				  			imandxtinsertsql += ", CFfreeyxjzachieve ";
				  			imandxtinsertValueSql += ","+new BigDecimal(zdrs.getString("SUMAMOUNT"))+"";
				  		}else if("freeyz".equals(zdrs.getString("TYPE"))){//����  
//				  			bymb= bymb.add(new BigDecimal(zdrs.getString("SUMAMOUNT")));  
//				  			imandxtinsertsql += ", CFfreembAchieve ";
//				  			imandxtinsertValueSql += ","+new BigDecimal(zdrs.getString("SUMAMOUNT"))+""; 
				  			
				  		    //��������û���⹤����
				  			imandxtinsertsql += ", CFfreembAchieve ";
				  			imandxtinsertValueSql += ", 0 "; 
				  		}else if("freeknw".equals(zdrs.getString("TYPE"))){//������ ��
				  			byknw = byknw.add(new BigDecimal(zdrs.getString("SUMAMOUNT")));  
				  			imandxtinsertsql += ",CFfreeknwachieve ";
				  			imandxtinsertValueSql += ","+new BigDecimal(zdrs.getString("SUMAMOUNT"))+"";
				  		}else if("freexf".equals(zdrs.getString("TYPE"))){//�޸�
				  			byxf= byxf.add(new BigDecimal(zdrs.getString("SUMAMOUNT")));  
				  			imandxtinsertsql += ", CFfreexfachieve ";
				  			imandxtinsertValueSql += ","+new BigDecimal(zdrs.getString("SUMAMOUNT"))+""; 
				  		}else if("freeey".equals(zdrs.getString("TYPE"))){//����
				  			byey= byey.add(new BigDecimal(zdrs.getString("SUMAMOUNT")));  
				  			imandxtinsertsql += ", CFfreeeyachieve ";
				  			imandxtinsertValueSql += ","+new BigDecimal(zdrs.getString("SUMAMOUNT"))+"";
				  		}  
				  		
				  }
				 
			}  
  			
			//�Դ����߳ɱ�
			StringBuffer sqlImportCB = new StringBuffer(); 
			sqlImportCB = getSHImportZiDaiChengBenSql( "'"+empNum+"'", clinicNumber, cityId, periodnum, sqlImportCB);
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
			
			//��� ��ʿ�����ĳɱ�
			StringBuffer sqlHushiCB = new StringBuffer(); 
			sqlHushiCB = getSHHushiZiDaiChengBenSql( "'"+empNum+"'", clinicNumber, cityId, periodnum, sqlHushiCB);
			IRowSet hushiCBrs;
			
			hushiCBrs = com.kingdee.eas.custom.util.DBUtil.executeQuery(ctx,sqlHushiCB.toString());
			
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
						  
						  
						  clinicCostSumInfo.setYzCost(new BigDecimal(hushiCBrs.getString("SUMM")));
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

			BigDecimal zzBase =  BigDecimal.ZERO;
			BigDecimal gdjzBase = BigDecimal.ZERO;
			BigDecimal yxjzBase = BigDecimal.ZERO;
			BigDecimal yzBase = BigDecimal.ZERO;
			BigDecimal knwBase = BigDecimal.ZERO; 
			BigDecimal xfBase = BigDecimal.ZERO;
			BigDecimal eyBase = BigDecimal.ZERO;
			if(calType != null  && calType.equals("zskc")){
				CompanyOrgUnitInfo orgUnit = CompanyOrgUnitFactory.getLocalInstance(ctx).getCompanyOrgUnitCollection(" where number = '"+clinicNumber+"' " ).get(0); 
				HashMap<String,BigDecimal> allMap =  setJingWork( byzz, zzcb, bygdjz, gdjzcb, byyxjz, yxjzcb, byyz, yzcb, byknw, knwcb, byxf, xfcb, byey, eycb,  biliMap, calType);
				String nextPeriod  = getNextPeriod( periodnum);
				if(DoctorCostsFactory.getLocalInstance(ctx).exists("where BusinessDate='"+nextPeriod+"' and city = '"+cityId+"' and EmpNumber='"+empNum+"' and CostType='yk' and (Description is null or Description!='��̯�۳�ҵ��') ")){
					DoctorCostsFactory.getLocalInstance(ctx).delete("where BusinessDate='"+nextPeriod+"' and city = '"+cityId+"' and EmpNumber='"+empNum+"' and CostType='yk' and (Description is null or Description!='��̯�۳�ҵ��')");	
				}
				
				DoctorCostsInfo doctorCostsInfo =new DoctorCostsInfo();
				doctorCostsInfo.setBusinessDate(nextPeriod);
				CtrlUnitInfo ctrlUnitInfo = new CtrlUnitInfo();
				ctrlUnitInfo.setId(BOSUuid.read(cityId));
				doctorCostsInfo.setCity(ctrlUnitInfo);
				doctorCostsInfo.setCityNumber(cityNumber);
				
				
				doctorCostsInfo.setClinic(orgUnit); 
				
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
				}else if(allMap.get("all").compareTo(BigDecimal.ZERO) <0 ){//����Ǹ���  ˵��û������
					
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
				
				if(DocAchieveUpdateFactory.getLocalInstance(ctx).exists("where BusinessDate='"+periodnum+"' and city = '"+cityId+"' and docNumber='"+empNum+"'   and Name='��̯�۳�ҵ��' ")){
					DocAchieveUpdateFactory.getLocalInstance(ctx).delete("where BusinessDate='"+periodnum+"' and city = '"+cityId+"' and docNumber='"+empNum+"'   and Name='��̯�۳�ҵ��' "); 
				}
				DocAchieveUpdateInfo docAchieveUpdateThis =new DocAchieveUpdateInfo();
				docAchieveUpdateThis.setBusinessDate(periodnum); 
				ctrlUnitInfo.setId(BOSUuid.read(cityId));
				docAchieveUpdateThis.setCity(ctrlUnitInfo);
				docAchieveUpdateThis.setCityNumber(cityNumber);
				 
				docAchieveUpdateThis.setClinic(orgUnit);
				docAchieveUpdateThis.setClinicName(orgUnit.getName()); 
				docAchieveUpdateThis.setClinicNumber(orgUnit.getNumber()); 
				
				docAchieveUpdateThis.setDocNumber(empNum);
				docAchieveUpdateThis.setDocName(tempMap.get("empName").toString()); 
				docAchieveUpdateThis.setName("��̯�۳�ҵ��");  
				docAchieveUpdateThis.setIszidai(true);
				boolean flag = false;
				if(null != allMap.get("negzz")){
					//clinicCostSumInfo.setImzzCost(clinicCostSumInfo.getImzzCost().add(allMap.get("negzz")));
					docAchieveUpdateThis.setZzAchieve(allMap.get("negzz").negate());
					imzz = imzz.add(allMap.get("negzz").negate());
					
					byzz = byzz.add(allMap.get("negzz").negate());
					
					noFreeAchieve = noFreeAchieve.add(allMap.get("negzz").negate());
					flag = true;
				}
				if(null != allMap.get("neggdjz")){
					//clinicCostSumInfo.setImgdjzCost(clinicCostSumInfo.getImgdjzCost().add(allMap.get("neggdjz")));
					docAchieveUpdateThis.setGdjzAchieve(allMap.get("neggdjz").negate());
					imgdjz = imgdjz.add(allMap.get("neggdjz").negate());
					
					bygdjz = bygdjz.add(allMap.get("neggdjz").negate());
					
					noFreeAchieve = noFreeAchieve.add(allMap.get("neggdjz").negate());
					flag = true;
				}
				if(null != allMap.get("negyxjz")){
					//clinicCostSumInfo.setImyxjzCost(clinicCostSumInfo.getImyxjzCost().add(allMap.get("negyxjz")));
					docAchieveUpdateThis.setYxjzAchieve(allMap.get("negyxjz").negate());
					imyxjz = imyxjz.add(allMap.get("negyxjz").negate());
					
					byyxjz = byyxjz.add(allMap.get("negyxjz").negate());
					
					noFreeAchieve = noFreeAchieve.add(allMap.get("negyxjz").negate());
					flag = true;
				}
				if(null != allMap.get("negyz")){
					//clinicCostSumInfo.setImyzCost(clinicCostSumInfo.getImyzCost().add(allMap.get("negyz")));
					docAchieveUpdateThis.setYzAchieve(allMap.get("negyz").negate());
					imyz = imyz.add(allMap.get("negyz").negate());
					
					byyz = byyz.add(allMap.get("negyz").negate());
					noFreeAchieve = noFreeAchieve.add(allMap.get("negyz").negate());
					flag = true;
				}
				if(null != allMap.get("negknw")){
					//clinicCostSumInfo.setImknwCost(clinicCostSumInfo.getImknwCost().add(allMap.get("negknw")));
					docAchieveUpdateThis.setKnwAchieve(allMap.get("negknw"));
					imknw = imknw.add(allMap.get("negknw").negate());
					
					byknw = byknw.add(allMap.get("negknw").negate());
					noFreeAchieve = noFreeAchieve.add(allMap.get("negknw").negate());
					flag = true;
				}
				if(null != allMap.get("negxf")){
					//clinicCostSumInfo.setImxfCost(clinicCostSumInfo.getImxfCost().add(allMap.get("negxf")));
					docAchieveUpdateThis.setXfAchieve(allMap.get("negxf").negate());
					imxf = imxf.add(allMap.get("negxf").negate());
					
					byxf = byxf.add(allMap.get("negxf").negate());
					noFreeAchieve = noFreeAchieve.add(allMap.get("negxf").negate());
					flag = true;
				}
				if(null != allMap.get("negey")){
					//clinicCostSumInfo.setImeyCost(clinicCostSumInfo.getImeyCost().add(allMap.get("negey")));
					docAchieveUpdateThis.setEyAchieve(allMap.get("negey").negate());
					imey = imey.add(allMap.get("negey").negate());
					
					byey = byey.add(allMap.get("negey").negate()); 
					noFreeAchieve = noFreeAchieve.add(allMap.get("negey").negate());
					flag = true;
				}
				if(flag){
					DocAchieveUpdateFactory.getLocalInstance(ctx).save(docAchieveUpdateThis);
				}
				
			}else{//�������ӿ�     
//				zzBase = zzBase.compareTo(BigDecimal.ZERO)<0?BigDecimal.ZERO:zzBase;
//				gdjzBase = gdjzBase.compareTo(BigDecimal.ZERO)<0?BigDecimal.ZERO:gdjzBase;
//				yxjzBase = yxjzBase.compareTo(BigDecimal.ZERO)<0?BigDecimal.ZERO:yxjzBase;
//				yzBase = yzBase.compareTo(BigDecimal.ZERO)<0?BigDecimal.ZERO:yzBase;
//				knwBase = knwBase.compareTo(BigDecimal.ZERO)<0?BigDecimal.ZERO:knwBase;
//				
//				xfBase = xfBase.compareTo(BigDecimal.ZERO)<0?BigDecimal.ZERO:xfBase;
//				eyBase = eyBase.compareTo(BigDecimal.ZERO)<0?BigDecimal.ZERO:eyBase;
				
				
				zzBase = byzz.subtract(zzcb).compareTo(BigDecimal.ZERO)<0?BigDecimal.ZERO:byzz.subtract(zzcb);
				gdjzBase = bygdjz.subtract(gdjzcb).compareTo(BigDecimal.ZERO)<0?BigDecimal.ZERO:bygdjz.subtract(gdjzcb);
				yxjzBase = byyxjz.subtract(yxjzcb).compareTo(BigDecimal.ZERO)<0?BigDecimal.ZERO:byyxjz.subtract(yxjzcb);
				yzBase = byyz.subtract(yzcb).compareTo(BigDecimal.ZERO)<0?BigDecimal.ZERO:byyz.subtract(yzcb);
				knwBase = byknw.subtract(knwcb).compareTo(BigDecimal.ZERO)<0?BigDecimal.ZERO:byknw.subtract(knwcb); 
				xfBase = byxf.subtract(xfcb).compareTo(BigDecimal.ZERO)<0?BigDecimal.ZERO:byxf.subtract(xfcb);
				eyBase = byey.subtract(eycb).compareTo(BigDecimal.ZERO)<0?BigDecimal.ZERO:byey.subtract(eycb);
				
			} 
			imandxtinsertsql +=  ", CFIMZZACHIEVE , CFIMGDJZACHIEVE , cfIMyxjzachieve, CFIMyzAchieve , cfIMknwachieve , cfIMmbachieve , cfIMxfachieve, cfIMeyachieve ";
			imandxtinsertValueSql +=" ,"+imzz+" ,"+imgdjz+","+imyxjz +","+imyz+","+imknw+","+immb+","+imxf+"," + ""+imey+"  ";
			

			insertSql +=  ", CFZZACHIEVE , CFGDJZACHIEVE , cfyxjzachieve, CFZyAchieve , cfknwachieve , cfmbachieve , cfxfachieve, cfeyachieve ";
			insertValueSql +=" ,"+byzz+" ,"+bygdjz+","+byyxjz+","+byyz+","+byknw+","+bymb+","+byxf+","+byey+"  ";
			
			
			//�Դ����� �ü�ȥ�ɱ� 
			BigDecimal byzzMoney = zzBase.compareTo(BigDecimal.ZERO) > 0 ? zzBase.multiply(byzzbl):BigDecimal.ZERO;
			BigDecimal bygdjzMoney = gdjzBase.compareTo(BigDecimal.ZERO) > 0 ? gdjzBase.multiply(bygdjzbl):BigDecimal.ZERO;
			BigDecimal byyxjzMoney = yxjzBase.compareTo(BigDecimal.ZERO) > 0 ? yxjzBase.multiply(byyxjzbl):BigDecimal.ZERO;
			BigDecimal byyzMoney = yzBase.compareTo(BigDecimal.ZERO) > 0 ? yzBase.multiply(byyzbl):BigDecimal.ZERO;
			BigDecimal byknwMoney = knwBase.compareTo(BigDecimal.ZERO) > 0 ? knwBase.multiply(byknwbl):BigDecimal.ZERO;
			BigDecimal bymbMoney = bymb.subtract(mbcb).compareTo(BigDecimal.ZERO) > 0 ? bymb.subtract(mbcb).multiply(bymbbl):BigDecimal.ZERO;
			BigDecimal byxfMoney = xfBase.compareTo(BigDecimal.ZERO) > 0 ? xfBase.multiply(byxfbl):BigDecimal.ZERO;
			BigDecimal byeyMoney = eyBase.compareTo(BigDecimal.ZERO) > 0 ? eyBase.multiply(byeybl):BigDecimal.ZERO;
			
			insertSql += " , CFZZmoney, CFGDJZmoney, CFYXJZmoney, CFYZmoney, CFKNWmoney, CFMBmoney, CFXFmoney, CFEYmoney ";
			insertValueSql +=  ", "+byzzMoney+" ,"+bygdjzMoney+","+byyxjzMoney+" " +
				" ,"+byyzMoney+" ,"+byknwMoney+" ,"+bymbMoney+" "+
				" ,"+byxfMoney+" ,"+byeyMoney+" ";
			
			
			bymoney = byzzMoney.add(bygdjzMoney).add(byyxjzMoney).add(byyzMoney).add(byknwMoney).add(bymbMoney).add(byxfMoney).add(byeyMoney)
			.setScale(2,BigDecimal.ROUND_HALF_UP);  
			
			
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
			costAll = costAll.add(clinicCostSumInfo.getAllzzCost()).add(clinicCostSumInfo.getAllgdjzCost())
			.add(clinicCostSumInfo.getAllyxjzCost()).add(clinicCostSumInfo.getAllyzCost())
			.add(clinicCostSumInfo.getAllknwCost()).add(clinicCostSumInfo.getAllmbCost())
			.add(clinicCostSumInfo.getAllxfCost()).add(clinicCostSumInfo.getAlleyCost()); 
			
			BigDecimal sumAchieve =  byzz.add(bygdjz).add(byyxjz).add(byyz).add(byknw).add(bymb).add(byxf).add(byey); 
			
			insertSql +=  ", cfzzcost , cfgdjzcost , cfyxjzcost , cfyzcost , cfknwcost , cfmbcost , cfxfcost , cfeycost  ";
			insertValueSql += " ,"+clinicCostSumInfo.getAllzzCost()+" ,"+clinicCostSumInfo.getAllgdjzCost()
				+" ,"+clinicCostSumInfo.getAllyxjzCost()+" ,"+clinicCostSumInfo.getAllyzCost() 
				+" ,"+clinicCostSumInfo.getAllknwCost()+" ,"+clinicCostSumInfo.getAllmbCost()
				+" ,"+clinicCostSumInfo.getAllxfCost()+" ,"+clinicCostSumInfo.getAlleyCost();
			 
			if(sumAchieve.compareTo(BigDecimal.ZERO) <= 0){
				insertSql +=  ", CFZZpro , CFGDpro , cfyxpro, CFyzpro , cfknwpro , cfmbpro , cfxfpro, cfeypro  ";
				insertValueSql +=" ,0 ,0,0,0,0,0,0,0 ";
			}else{
				insertSql +=  ", CFZZpro , CFGDpro , cfyxpro, CFyzpro , cfknwpro , cfmbpro , cfxfpro, cfeypro  ";
				insertValueSql +=" ,"+byzz.divide(sumAchieve,6, BigDecimal.ROUND_HALF_UP)+" ,"+bygdjz.divide(sumAchieve,6, BigDecimal.ROUND_HALF_UP)+
				","+byyxjz.divide(sumAchieve,6, BigDecimal.ROUND_HALF_UP)+","+0+
				","+byknw.divide(sumAchieve,6, BigDecimal.ROUND_HALF_UP)+","+0+
				","+byxf.divide(sumAchieve,6, BigDecimal.ROUND_HALF_UP)+","+byey.divide(sumAchieve,6, BigDecimal.ROUND_HALF_UP)+" ";
				
			}
			 
			
			
			StringBuffer sbr2  = new StringBuffer(" /*dialect*/insert into CT_PAY_ClinicAchieveCosthSum (FID,FCreatorID,FCreateTime,FLastUpdateUserID,FLastUpdateTime, ");
    		sbr2.append(" cfposttype , cfbusinessdate, CFCLINICNUMBER,CFCLINICName,cfempnumber,cfempname,CFCITYNUMBER,CFCITYName,CFJyCount, CFPlaCount , CFWhiteAchieve  "+insertSql+" "+imandxtinsertsql+",cfiszidai,cfsumachieve ) ");
    		sbr2.append("values(newbosid('20D1E187'),'"+userId+"',sysdate,'"+userId+"',sysdate, ");
    		sbr2.append(" 'JZYS', '"+periodnum+"','"+clinicNumber+"','"+clinicName+"' ,'"+empNum+"','"+tempMap.get("empName").toString()+"','"+cityNumber+"','"+tempMap.get("cityName").toString()+"' ,"+0+" ,"+0+" ,"+0+"  "+insertValueSql+" "+imandxtinsertValueSql+",1,"+noFreeAchieve+")");  
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



	
}
