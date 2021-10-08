package com.kingdee.eas.mw.pay.app.util;

import java.text.ParseException;
import java.util.Date;
import java.util.Map;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.framework.ejb.HistoryUtil;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemCollection;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.metadata.entity.SelectorItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.util.BOSUuid;
import com.kingdee.eas.base.core.hr.util.HRParamUtil;
import com.kingdee.eas.basedata.org.AdminOrgUnitInfo;
import com.kingdee.eas.basedata.org.PositionInfo;
import com.kingdee.eas.basedata.person.PersonCollection;
import com.kingdee.eas.basedata.person.PersonFactory;
import com.kingdee.eas.basedata.person.PersonInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.hr.affair.EmpEnrollBizBillEntryCollection;
import com.kingdee.eas.hr.affair.EmpEnrollBizBillEntryFactory;
import com.kingdee.eas.hr.base.AffairActioniOperateException;
import com.kingdee.eas.hr.base.EmpLaborRelationDomainFacadeFactory;
import com.kingdee.eas.hr.base.EmpLaborRelationFactory;
import com.kingdee.eas.hr.base.EmpLaborRelationInfo;
import com.kingdee.eas.hr.base.EmpLaborRelationInfo.EnrollInfo;
import com.kingdee.eas.hr.base.BaseException;
import com.kingdee.eas.hr.base.EmpLaborRelationHisInfo;
import com.kingdee.eas.hr.base.EmpPosOrgRelationCollection;
import com.kingdee.eas.hr.base.EmpPosOrgRelationFacadeFactory;
import com.kingdee.eas.hr.base.EmpPositionInfo;
import com.kingdee.eas.hr.base.EmployeeTypeFactory;
import com.kingdee.eas.hr.base.EmployeeTypeInfo;
import com.kingdee.eas.hr.base.HRBizData;
import com.kingdee.eas.hr.base.IEmpLaborRelation;
import com.kingdee.eas.hr.base.IEmpLaborRelationDomainFacade;
import com.kingdee.eas.hr.base.IEmpPosOrgRelationFacade;
import com.kingdee.eas.hr.base.IEmployeeType;
import com.kingdee.eas.hr.base.LogActionTypeEnum;
import com.kingdee.eas.hr.base.PositionStatuEnum;
import com.kingdee.eas.hr.base.app.EmpPosOrgRelationQueryHelper;
import com.kingdee.eas.hr.base.app.his.HistoryVersionUtil;
import com.kingdee.eas.hr.base.app.util.EmpLaborRelationUtil;
import com.kingdee.eas.hr.base.app.util.HRBizDefineAppUtils;
import com.kingdee.eas.hr.base.app.util.SHRSameDatePersonChangeUtil;
import com.kingdee.eas.hr.base.util.HRUtil;
import com.kingdee.eas.hr.base.util.HRUtilExtend;
import com.kingdee.eas.hr.base.util.IDCardCommonUtil;
import com.kingdee.eas.hr.emp.EmpQuickAddNewInfoFactory;
import com.kingdee.eas.hr.emp.EmpQuickAddNewInfoInfo;
import com.kingdee.eas.hr.emp.EmployeeTypeEnum;
import com.kingdee.eas.hr.emp.IEmpQuickAddNewInfo;
import com.kingdee.eas.hr.emp.IPersonOptFacade;
import com.kingdee.eas.hr.emp.IPersonOtherInfo;
import com.kingdee.eas.hr.emp.IPersonPhoto;
import com.kingdee.eas.hr.emp.IPersonPosition;
import com.kingdee.eas.hr.emp.IPersonPositionOptFacade;
import com.kingdee.eas.hr.emp.PersonOptFacadeFactory;
import com.kingdee.eas.hr.emp.PersonOtherInfoFactory;
import com.kingdee.eas.hr.emp.PersonOtherInfoInfo;
import com.kingdee.eas.hr.emp.PersonPhotoFactory;
import com.kingdee.eas.hr.emp.PersonPhotoInfo;
import com.kingdee.eas.hr.emp.PersonPositionFactory;
import com.kingdee.eas.hr.emp.PersonPositionInfo;
import com.kingdee.eas.hr.emp.PersonPositionOptFacadeFactory;
import com.kingdee.eas.hr.org.HRAdminOrgException;
import com.kingdee.eas.hr.org.JobSequenceInfo;
import com.kingdee.eas.hr.org.util.OrgAdjLockManager; 
import com.kingdee.util.DateTimeUtils;
import com.kingdee.util.StringUtils;
import java.util.Date;
import org.apache.log4j.Logger;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.sql.ParserException;
import com.kingdee.bos.util.BOSUuid;
import com.kingdee.eas.basedata.hraux.FolkFactory;
import com.kingdee.eas.basedata.hraux.FolkInfo;
import com.kingdee.eas.basedata.org.AdminOrgUnitFactory;
import com.kingdee.eas.basedata.org.AdminOrgUnitInfo;
import com.kingdee.eas.basedata.org.HROrgUnitFactory;
import com.kingdee.eas.basedata.org.HROrgUnitInfo;
import com.kingdee.eas.basedata.org.JobInfo;
import com.kingdee.eas.basedata.org.OrgUnitLayerTypeFactory;
import com.kingdee.eas.basedata.org.OrgUnitLayerTypeInfo;
import com.kingdee.eas.basedata.org.PositionFactory;
import com.kingdee.eas.basedata.org.PositionInfo;
import com.kingdee.eas.basedata.person.Genders;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.hr.base.AffairActionReasonInfo;
import com.kingdee.eas.hr.base.EmployeeTypeFactory;
import com.kingdee.eas.hr.base.EmployeeTypeInfo;
import com.kingdee.eas.hr.base.HRBizDefineInfo;
import com.kingdee.eas.hr.emp.EmpQuickAddNewInfoInfo;
import com.kingdee.eas.hr.emp.EmpQuickAddNewInfoInitFacadeFactory;
import com.kingdee.eas.hr.emp.app.EmpQuickAddNewInfoUtil;
import com.kingdee.eas.hr.emp.app.PersonOptBaseInfo;
import com.kingdee.eas.hr.emp.app.util.GetJobInfosUtil;
import com.kingdee.eas.hr.emp.app.util.SHREmpOptBizManageTool;
import com.kingdee.eas.hr.org.OrgUnitOptFacadeFactory;

public class TextUtil {

	public Object insertNewOrg(Context ctx,Map param) throws EASBizException,
	BOSException {
		 
		boolean hasExist = false;

		String orgNumber = (String)param.get("orgNumber");
		String orgName = (String)param.get("orgName");
		String parorgNumber = (String)param.get("parorgNumber");
		String deptLevel = (String)param.get("deptLevel");
		
		AdminOrgUnitInfo adminOrgInfo = new AdminOrgUnitInfo();
		adminOrgInfo.setNumber(orgNumber);
		adminOrgInfo.setName(orgName);

		
		AdminOrgUnitInfo  parentOrg =  new AdminOrgUnitInfo();
		 
		String id= "";
		
		try { 
			if(OrgUnitLayerTypeFactory.getLocalInstance(ctx).exists(" where name = '"+deptLevel+"' ")){
				OrgUnitLayerTypeInfo  orgUnitLayerTypeInfo = OrgUnitLayerTypeFactory.getLocalInstance(ctx).getOrgUnitLayerTypeCollection(" where name = '"+deptLevel+"' ").get(0);
				parentOrg.setUnitLayerType(orgUnitLayerTypeInfo);
			}else{ 
				System.out.println("找不到行政组织类型！"); 
				return null;
			}
			if(hasExistNum(ctx, parorgNumber)){
				String exitOql = "where number = '" + parorgNumber + "'";
				parentOrg = AdminOrgUnitFactory.getLocalInstance(ctx).getAdminOrgUnitCollection(exitOql).get(0); 
				
				adminOrgInfo.setParent(parentOrg);
			}else{
				System.out.println("找不到上级行政组织！"); 
				return null;
			}
			hasExist = hasExistNum(ctx, orgNumber);
			
			id = submitData(ctx,  adminOrgInfo, hasExist);
			
		} catch (Exception e) { 
			e.printStackTrace();
		} 
		return id;
		
//		String errorMsg = "";
//		String errorStatus = "0";
//		String returnStatus = "success";
//		String orgNumber = (String)param.get("orgNumber");
//		String orgName = (String)param.get("orgName");
//		String parorgNumber = (String)param.get("parorgNumber");
//		String deptLevel = (String)param.get("deptLevel");
//		//新增  修改  删除
//		String status =  (String)param.get("status");
//		Calendar cal=Calendar.getInstance();
//		try {
//			 
//			AdminOrgUnitCollection adcoll=AdminOrgUnitFactory.getLocalInstance(ctx).getAdminOrgUnitCollection("where number='"+orgNumber+"'");
//			cal.setTime(new Date()); 
//
//			
//			
//    		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//    		String updatetime=sdf.format(new Date()).substring(11); 
//    		SelectorItemCollection sic=new SelectorItemCollection();
//			sic.add(new SelectorItemInfo("*"));
//			sic.add(new SelectorItemInfo("cu.*"));
//			FullOrgUnitInfo fullOrg =null;
//			boolean isAdd=false;
//    		if(adcoll.size()>0){
//    			errorStatus = "组织修改;";
//    			errorMsg = "组织修改成功;";
//				//组织存在，修改组织
//				fullOrg=FullOrgUnitFactory.getLocalInstance(ctx).getFullOrgUnitInfo(new ObjectUuidPK(adcoll.get(0).getId()));
//				String cancel="1";
//				if( status !=null&&!status.equals("")){
//					 cancel= status ;
//				}else{
//					 cancel="0";
//				}
//				if(cancel.equals("1")){ 
//	    			fullOrg.setIsOUSealUp(true);
//	    		}else if(cancel.equals("0")){
//	    			if(fullOrg.isIsOUSealUp()){
//	    				fullOrg.setIsOUSealUp(false); 
//	    			}else{
//	    					 
//	    			}
//	    		}
//				
//				
//				AdminOrgUnitCollection adscoll=AdminOrgUnitFactory.getLocalInstance(ctx).getAdminOrgUnitCollection("where number='"+parorgNumber+"'");
//    			if(!fullOrg.getName().equals(orgName)){
//    				fullOrg.setName(orgName);
//    			}
//    			//上级组织更新
//    			if(adscoll.size()>0){
//    				FullOrgUnitInfo superadmin=new FullOrgUnitInfo();
//        			superadmin.setId(adscoll.get(0).getId());
//        			if(!fullOrg.getParent().getId().toString().equals(superadmin.getId().toString())){
//        				System.out.println("-----------------旧"+fullOrg.getId()+"----------新"+superadmin.getId());
//        				fullOrg.setParent(superadmin);	
//        			}
//        		}else{
//        			errorStatus = "失败;";
//					errorMsg = errorMsg+"上级组织不存在;" ;
//					returnStatus = "error";
//        		}
//    			fullOrg.put("isCus", new Boolean(true));
//    			FullOrgUnitFactory.getLocalInstance(ctx).update(new ObjectUuidPK(fullOrg.getId()), fullOrg);
//    			 
//    		}else{
//				//组织不存在，新增组织
//				isAdd=true;
//				errorStatus = "组织新增;";
//				errorMsg = "组织新增成功;";
//				fullOrg = new FullOrgUnitInfo();
//				//创建基本组织
//				fullOrg.setNumber(orgNumber);
//				fullOrg.setName(orgName);
//				 
//				
//				AdminOrgUnitCollection adscoll=AdminOrgUnitFactory.getLocalInstance(ctx).getAdminOrgUnitCollection("where number='"+parorgNumber+"'"); 
//				if(adscoll.size()>0){
//					FullOrgUnitInfo superadmin=new FullOrgUnitInfo();
//					superadmin.setId(adscoll.get(0).getId());
//					fullOrg.setParent(superadmin);	
//					CUBDControlCollection  cuctrol=CUBDControlUtils.loadDefaultCUBDControl(ctx);
//					//fullOrg.put("CUBDControl", cuctrol);
//					fullOrg.setIsCU(false);
//					//fullOrg.put("isCus", new Boolean(true));
//					
//					fullOrg.setIsAdminOrgUnit(true);
//					 
//    				
//					FullOrgUnitFactory.getLocalInstance(ctx).save(fullOrg);
//					IObjectPK pk=FullOrgUnitFactory.getLocalInstance(ctx).submit(fullOrg);
//					fullOrg=FullOrgUnitFactory.getLocalInstance(ctx).getFullOrgUnitInfo(pk);
//				}else{
//					errorStatus = "失败;";
//					errorMsg = errorMsg+"上级组织不存在;" ;
//					returnStatus = "error";
//				}
//    		}
//    		
//    		if(errorStatus.length() >0 && !errorStatus.equals("失败;")){
//    			//新增行政组织	 组织单元类型 
//    			OrgTypeHelper orgTypeHelper = new OrgTypeHelper();
//    			fullOrg.setIsAdminOrgUnit(true);
//    			OUPartAdminInfo admin=fullOrg.getPartAdmin();
//    			if(admin==null){
//    				admin=new OUPartAdminInfo();
//    			}
//    			if(deptLevel!=null&&!deptLevel.equals("")){
//    				OrgUnitLayerTypeInfo ltinfo=OrgUnitLayerTypeFactory.getLocalInstance(ctx).getOrgUnitLayerTypeInfo("where name='"+deptLevel+"'");
//    				admin.setUnitLayerType(ltinfo);
//    				admin.setEFFDT(new Date());
//    				admin.setIsIndependence(true);
//    				orgTypeHelper.addOrgType(OrgType.Admin);
//    				fullOrg.setPartAdmin(admin);
//    				BizParentAndDelegateInfo PDValueInfo=new BizParentAndDelegateInfo();
//    				AdminOrgUnitInfo adminOrgUnitInfo=AdminOrgUnitFactory.getLocalInstance(ctx).getAdminOrgUnitInfo(new ObjectUuidPK(fullOrg.getParent().getId().toString()),sic);
//    				PDValueInfo.setAdminParent(adminOrgUnitInfo);
//    				//fullOrg.put("PDValueInfo", PDValueInfo);
//    				if(!isAdd){
//    					//成本中心
//    					if(fullOrg.isIsCostOrgUnit()){
//    						OUPartCostCenterInfo costInfo=fullOrg.getPartCostCenter();
//    						CostCenterOrgUnitInfo  cspInfo=null;
//    						cspInfo=CostCenterOrgUnitFactory.getLocalInstance(ctx).getCostCenterOrgUnitInfo(new ObjectUuidPK(fullOrg.getParent().getId().toString()),sic);
//    						PDValueInfo.setCostParent(cspInfo);
//    						orgTypeHelper.addOrgType(OrgType.CostCenter);
//    						fullOrg.setPartCostCenter(costInfo);
//    					}
//    				}
//    				fullOrg.setOrgTypeStr(orgTypeHelper.createOrgTypeStrBySet());
//    				FullOrgUnitFactory.getLocalInstance(ctx).submit(fullOrg);
//    				//设置委托组织
//    				OrgUnitRelationInfo orgUnitInfo=new OrgUnitRelationInfo();
//    				orgUnitInfo.setFromUnit(fullOrg);
//    				orgUnitInfo.put("fromType", OrgType.Admin);
//    				orgUnitInfo.put("toType", OrgType.Company);
//    				PDValueInfo.getDelegateCollection().add(orgUnitInfo);
//    				if(fullOrg.isIsCostOrgUnit()){
//    					orgUnitInfo=new OrgUnitRelationInfo();
//    					orgUnitInfo.setFromUnit(fullOrg);
//    					orgUnitInfo.setToUnit(fullOrg);
//    					orgUnitInfo.put("fromType", OrgType.Admin);
//    					orgUnitInfo.put("toType", OrgType.CostCenter);
//    					PDValueInfo.getDelegateCollection().add(orgUnitInfo);
//    				}
//    				fullOrg.put("PDValueInfo", PDValueInfo);
//    				FullOrgUnitFactory.getLocalInstance(ctx).submit(fullOrg);
//    				errorStatus = errorStatus+"新增行政组织成功;";
//    				 
//    			}else{ 
//    	    		errorStatus = "失败;";
//    				errorMsg = errorMsg+"组织层次类型不能为空;" ;
//    				returnStatus = "error";
//    			} 
//    		} 
//		} catch (EASBizException e) {
//			e.printStackTrace();
//		} 
//		//String  sqlInsert = "/*dialect*/ insert into t_log_msg (number,name,thistime,type,msg,status) values( '"+orgNumber+";"+parorgNumber+"','"+orgName+"',getdate() ,'组织','"+errorMsg+"','"+errorStatus+"') ";
//		String  sqlInsert = "/*dialect*/ insert into t_log_msg (number,name,thistime,type,msg,status) values( '"+orgNumber+";"+parorgNumber+"','"+orgName+"',sysdate ,'组织','"+errorMsg+"','"+errorStatus+"') ";
//		DbUtil.execute(ctx, sqlInsert); 
//		List resullt = new ArrayList();
//		Map map = new HashMap();
//		map.put("status", returnStatus);
//		map.put("msg", errorMsg);
//		return resullt;
	}
	
	protected String submitData(Context ctx,  
			AdminOrgUnitInfo adminOrgInfo, boolean hasExist) throws ParserException,
			EASBizException, BOSException {
		 
		String pkStr = "";
		adminOrgInfo.put("notNeedGenerateObjectNumber", Boolean.valueOf(true));
 

		processJuridicalCompany(ctx, adminOrgInfo);
		adminOrgInfo.setEFFDT(new Date());
		adminOrgInfo.setIsJuridicalCompany(false);
		adminOrgInfo.setExtendedProperty("historyOperateState", "revise");
		if (  hasExist  ) { 
			Object responPositionExistFlag = adminOrgInfo.get("responPositionExist");
			if (responPositionExistFlag == null) {
				adminOrgInfo.put("formImportAndNoUpdateResponPosition", "true");
			}
			adminOrgInfo.put("prefix", "adminorgext_");
			pkStr = OrgUnitOptFacadeFactory.getLocalInstance(ctx).updateAdminOrg(adminOrgInfo).toString();
		} else {
			if (!(adminOrgInfo.containsKey("index"))) {
				adminOrgInfo.setIndex(0);
			}
			pkStr = OrgUnitOptFacadeFactory.getLocalInstance(ctx).addNewAdminOrg(adminOrgInfo).toString();
			
		}
		return pkStr;
	}

	private void processJuridicalCompany(Context ctx,
			AdminOrgUnitInfo adminOrgInfo) throws BOSException {
		if (((adminOrgInfo.isIsJuridicalCompany())&& (adminOrgInfo.get("isJuridicalCompany") != null) && (adminOrgInfo.get("isJuridicalCompany") != ""))
				
			|| (   (((adminOrgInfo.get("juridicalperson") == null)|| (adminOrgInfo.get("juridicalperson") == "") || (adminOrgInfo.get("juridicalperson") == "/")))
			    && (((adminOrgInfo.get("setupdate") == null)|| (adminOrgInfo.get("setupdate") == "") || (adminOrgInfo.get("setupdate") == "/")))
			    && (((adminOrgInfo.get("endupdate") == null)|| (adminOrgInfo.get("endupdate") == "") || (adminOrgInfo.get("endupdate") == "/")))
				&& (((adminOrgInfo.get("taxNumber") == null)|| (adminOrgInfo.get("taxNumber") == "") || (adminOrgInfo.get("taxNumber") == "/")))
				&& (((adminOrgInfo.get("registtype") == null)|| (adminOrgInfo.get("registtype") == "") || (adminOrgInfo.get("registtype") == "/")))
			   )
			) {
			return;
		}

		throw new BOSException("填写法人代表等信息时，“是否法人公司”需设置为是");
	}
	
	private boolean hasExistNum(Context ctx, String number) throws EASBizException, BOSException {
		boolean hasExist = false;
		String exitOql = "where number = '" + number + "'";
		hasExist = AdminOrgUnitFactory.getLocalInstance(ctx).exists(exitOql);
		return hasExist;
	}



	public Object insertNewPerson(Context ctx,Map param) throws EASBizException,BOSException {
		 
		boolean hasExist = false;

		EmpQuickAddNewInfoInfo info = new EmpQuickAddNewInfoInfo(); 
		
		//员工编码	FEMPNUMBER
		String  empNumber =  (String)param.get("FEMPNUMBER");
		info.setNumber(empNumber);
		//姓名	FEMPNAME
		String  empName =  (String)param.get("FEMPNAME");
		info.setName(empName);
		
		
		//当前任职开始日期	FBEGINDATE
		Date  beginDate =  (Date)param.get("FBEGINDATE");
		info.setEFFDT(beginDate); 
		
		//职位	FPOSITION
		String  position =  (String)param.get("FPOSITION");
		if(PositionFactory.getLocalInstance(ctx).exists(" where number = '"+position+"'")){
			PositionInfo positionInfo =  PositionFactory.getLocalInstance(ctx).getPositionCollection(" where number = '"+position+"'").get(0);
			info.setPosition(positionInfo);
		}else{
			return "所选中的职位不存在，请在SHR系统中进行维护。";
		}
		
		
		//所属行政组织编码	FORGNUMBER
		String  orgNumber =  (String)param.get("FORGNUMBER"); 
		if(AdminOrgUnitFactory.getLocalInstance(ctx).exists(" where number = '"+orgNumber+"'")){
			AdminOrgUnitInfo adminOrgUnitInfo =  AdminOrgUnitFactory.getLocalInstance(ctx).getAdminOrgUnitCollection(" where number = '"+orgNumber+"'").get(0);
			info.setAdminOrg(adminOrgUnitInfo);
		}else{
			return "所选中的组织不存在，请在SHR系统中进行维护。";
		}
		
		if(HROrgUnitFactory.getLocalInstance(ctx).exists(" where number = 'M'")){
			//HROrgUnitInfo hrOrgUnitInfo =  HROrgUnitFactory.getLocalInstance(ctx).getHROrgUnitCollection(" where number = '"+orgNumber+"'").get(0);
			HROrgUnitInfo hrOrgUnitInfo =  HROrgUnitFactory.getLocalInstance(ctx).getHROrgUnitCollection(" where number = 'M'").get(0);
			info.setHrOrgUnit(hrOrgUnitInfo);
		}else{
			return "所选中的组织不存在，请在SHR系统中进行维护。";
		}
		
		
		
//		//任职类型	FPOSTTYPE
//		String  postType =  (String)param.get("FPOSTTYPE"); 
//		info.set(adminOrgUnitInfo);
		
		//入职日期	FINDATE
		Date  inDate =  (Date)param.get("FINDATE");
		info.setEnterDate(inDate);
		info.setJoinGroupDate(inDate);
		info.setJobStartDate(inDate);
		//用工关系状态	FEMPTYPE
		String  empType =  (String)param.get("FEMPTYPE");
		
		if(EmployeeTypeFactory.getLocalInstance(ctx).exists(" where name = '试用员工'")){
			EmployeeTypeInfo employeeTypeInfo =  EmployeeTypeFactory.getLocalInstance(ctx).getEmployeeTypeCollection(" where name = '试用员工'").get(0);
			info.setLaborRelationState(employeeTypeInfo);
		}else{
			return "所选中的用工关系状态不存在，请在SHR系统中进行维护。";
		}
		
		
		//邮箱	FEMILE
		String  emile =  (String)param.get("FEMILE");
		info.setEmail(emile);
		//民族	FFolkID
		String  folkid =  (String)param.get("FFolkID"); 
		if(FolkFactory.getLocalInstance(ctx).exists(" where name = '"+folkid+"'")){
			FolkInfo folkInfo = FolkFactory.getLocalInstance(ctx).getFolkCollection(" where name = '"+folkid+"'").get(0);
			info.setMyFolk(folkInfo);
		}else{
			return "所选中的民族不存在，请在SHR系统中进行维护。";
		}
		 
		//性别	FGender
		String  fender =  (String)param.get("FGender");
		if(fender.equals("男") || fender.equals("1") ){
			info.setGender(Genders.Male);
		}else{
			info.setGender(Genders.Female);
		}
		//出生日期	FBirthday
		Date  birthday =  (Date)param.get("FBirthday");
		info.setBirthday(birthday);
//		//政治面貌	FPoliticalFaceID
//		String  politicalFaceID =  (String)param.get("FPoliticalFaceID");
//		//手机号	FCell
//		String  cell =  (String)param.get("FCell");
		//身份证号	FIDCardNO
		String  idCardNO =  (String)param.get("FIDCardNO");
		info.setIdCardNO(idCardNO);
		//护照号	FPassportNO
//		String  passportNO =  (String)param.get("FPassportNO");
//		//生育状况	FWedID
//		String  wedID =  (String)param.get("FWedID");
//		
		//变动操作
		HRBizDefineInfo hrBizDefineInfo = new HRBizDefineInfo();
		hrBizDefineInfo.setId(BOSUuid.read("P/OSDCPfQXqU0TB/LQoA6uZovtk="));
		info.setActionDef(hrBizDefineInfo);
		
		//变动类型 
		AffairActionReasonInfo affairActionReasonInfo = new AffairActionReasonInfo();
		affairActionReasonInfo.setId(BOSUuid.read("EsEKwrCMQ+6PnuELVFdjcJYRae4=")); 
		info.setActionType(affairActionReasonInfo);
		 
		
		
		
		if ((info.getEFFDT() == null) || (info.getJoinGroupDate() == null)
				|| (info.getEnterDate() == null)) {
			throw new BOSException("时间不能为空 ");
		}

		if (info.getPosition() == null) {
			throw new BOSException("职位不能为空");
		}
		OrgAdjLockManager.checkIfOrgLocked(ctx, null, info.getPosition()
				.getId().toString());
		
		PersonOptBaseInfo personOptInfo = new PersonOptBaseInfo();
		PersonInfo personInfo = preparedPersonInfo(ctx, info);
		PersonPositionInfo ppInfo = preparedPersonPositionInfo(ctx, info);
		ppInfo.setPerson(personInfo);

		personOptInfo.setPerson(personInfo);
		personOptInfo.setPersonPosition(ppInfo);

		String isAddUser = (String) info.get("isAddUser");
		String userNumber = (String) info.get("userName");
		if (isAddUser != null) {
			personInfo.put("isAddUser", isAddUser);
		}
		if (userNumber != null) {
			personInfo.put("userNumber", userNumber);
		}

		IObjectPK pk = PersonOptFacadeFactory.getLocalInstance(ctx).personAddNew(info.getJoinGroupDate(), personOptInfo);
		personInfo.setId(BOSUuid.read(pk.toString()));
		
		HRBizData bizData = infosConvertToBizData(ctx,
				info, personInfo);
		bizData.setActionSource(LogActionTypeEnum.quickAddNew);
		EmpPosOrgRelationFacadeFactory.getLocalInstance(ctx)
				.operateHRBizDefine(bizData);
		
		afterInitialize(ctx, info, personInfo);
		
		return EmpQuickAddNewInfoFactory.getLocalInstance(ctx).addnew(info);
		//IObjectPK pk = EmpQuickAddNewInfoInitFacadeFactory.getLocalInstance(ctx).employeeInitialize(info); 
		 
	}
	
	private void afterInitialize(Context ctx, EmpQuickAddNewInfoInfo info,
			PersonInfo personInfo) throws EASBizException, BOSException {
		EmployeeTypeInfo emptypeInfo = personInfo.getEmployeeType();
		emptypeInfo = EmployeeTypeFactory.getLocalInstance(ctx)
				.getEmployeeTypeInfo(
						"where id ='" + emptypeInfo.getId().toString() + "'");

		personInfo.setEmployeeType(emptypeInfo);

		doWithEmpLaborRelatioinFields(ctx, info, personInfo);

		doWithPersonPhoto(ctx, info, personInfo);

		doWithDateFields(ctx, info, personInfo);
	}
	

	private void doWithDateFields(Context ctx, EmpQuickAddNewInfoInfo info,
			PersonInfo personInfo) throws EASBizException, BOSException {
		EmployeeTypeInfo emptypeInfo = personInfo.getEmployeeType();
		emptypeInfo = EmployeeTypeFactory.getLocalInstance(ctx)
				.getEmployeeTypeInfo(
						"where id ='" + emptypeInfo.getId().toString() + "'");
		EmployeeTypeEnum inservice = emptypeInfo.getInService();

		if (EmployeeTypeEnum.DIMISSION.equals(inservice)) {
			String oql = "where person ='" + personInfo.getId().toString()
					+ "'";
			PersonPositionInfo ppInfo = PersonPositionFactory.getLocalInstance(
					ctx).getPersonPositionInfo(oql);
			ppInfo.setLeftDate(info.getEFFDT());
			ppInfo.setLeftCompanyDate(HRUtil.getBeforeDate(info.getEFFDT()));
			SelectorItemCollection selector = new SelectorItemCollection();
			selector.add(new SelectorItemInfo("leftDate"));
			selector.add(new SelectorItemInfo("leftCompanyDate"));
			PersonPositionOptFacadeFactory.getLocalInstance(ctx)
					.updatePartialWithHis(ppInfo, selector);
		}

		if (EmployeeTypeEnum.RETIRE.equals(inservice)) {
			String oql = "where person ='" + personInfo.getId().toString()
					+ "'";
			PersonOtherInfoInfo pOtherInfo = PersonOtherInfoFactory
					.getLocalInstance(ctx).getPersonOtherInfoInfo(oql);
			pOtherInfo.setRetireDate(info.getEFFDT());
			SelectorItemCollection selector = new SelectorItemCollection();
			selector.add(new SelectorItemInfo("retireDate"));
			PersonOtherInfoFactory.getLocalInstance(ctx).updatePartial(
					pOtherInfo, selector);
		}

		if (EmployeeTypeEnum.RERETAIN.equals(inservice)) {
			String oql = "where person ='" + personInfo.getId().toString()
					+ "'";
			EmpLaborRelationInfo empLaborRelationDB = EmpLaborRelationFactory
					.getLocalInstance(ctx).getEmpLaborRelationInfo(oql);
			empLaborRelationDB.setReinviteDate(info.getEFFDT());
			SelectorItemCollection selector = new SelectorItemCollection();
			selector.add(new SelectorItemInfo("reinviteDate"));
			EmpLaborRelationDomainFacadeFactory.getLocalInstance(ctx)
					.updatePartialWithHis(empLaborRelationDB, selector);
		}
	}

	private void doWithPersonPhoto(Context ctx, IObjectValue model,
			PersonInfo pInfo) throws BOSException, EASBizException {
		if ((model.get("tempperid") != null)
				&& (!("".equals(model.get("tempperid"))))) {
			String tempperid = model.get("tempperid").toString();
			IPersonPhoto personPhoto = PersonPhotoFactory.getLocalInstance(ctx);
			FilterInfo filterInfo = new FilterInfo();

			filterInfo.getFilterItems().add(
					new FilterItemInfo("person", tempperid));
			EntityViewInfo entityViewInfo = new EntityViewInfo();
			entityViewInfo.setFilter(filterInfo);
			CoreBaseCollection coll = personPhoto.getCollection(entityViewInfo);
			PersonPhotoInfo personPhotoInfo = null;
			if (coll.size() > 0) {
				personPhotoInfo = (PersonPhotoInfo) coll.get(0);
				PersonPhotoInfo addPhoto = new PersonPhotoInfo();
				addPhoto.setPerson(pInfo);
				addPhoto.setImageDataSource(personPhotoInfo
						.getImageDataSource());
				addPhoto.setImageData(personPhotoInfo.getImageData());
				addPhoto.setSourceImageHeight(personPhotoInfo
						.getSourceImageHeight());
				addPhoto.setSourceImageWidth(personPhotoInfo
						.getSourceImageWidth());
				addPhoto.setImageContentType(personPhotoInfo
						.getImageContentType());
				personPhoto.addnew(addPhoto);
				personPhoto.delete(new ObjectUuidPK(personPhotoInfo.getId()));
			}
		}
	}
 
	
	private void doWithEmpLaborRelatioinFields(Context ctx,
			EmpQuickAddNewInfoInfo info, PersonInfo personInfo)
			throws EASBizException, BOSException {
		EmpLaborRelationInfo.EnrollInfo enrollInfo = new EmpLaborRelationInfo.EnrollInfo();
		enrollInfo.setEnrollAgain(false);
		enrollInfo.setEnrollDate(info.getEnterDate());
		enrollInfo.setPlanFormalDate(info.getPlanFormalDate());
		enrollInfo.setTryoutMonth(info.getProbation());

		EmpLaborRelationUtil.doWithEnrollEmpLaborRelatioinFields(ctx,
				enrollInfo, personInfo.getId().toString());
	}
	
	private PersonPositionInfo preparedPersonPositionInfo(Context ctx,
			EmpQuickAddNewInfoInfo info) throws BOSException, EASBizException {
		PersonPositionInfo ppInfo = new PersonPositionInfo();
		ppInfo.setPrimaryPosition(info.getPosition());
		ppInfo.setPersonDep(info.getAdminOrg());
		ppInfo.setCompany(HRUtilExtend.getCompany(ctx, info.getAdminOrg()));
		ppInfo.setJoinDate(info.getEnterDate());
		ppInfo.setJoinGroupDate(info.getJoinGroupDate());
		ppInfo.setJoinGroupDateCur(info.getEnterDate());

		ppInfo.setEFFDT(info.getEFFDT());
		ppInfo.setLEFFDT(HistoryUtil.getMaxDate());
		ppInfo.setStartDateTime(ppInfo.getEFFDT());
		ppInfo.setEndDateTime(HistoryVersionUtil.getMaxEndDate());
		ppInfo.setVersion(1);
		ppInfo.setIsLatestInAday(true);
		return ppInfo;
	}
	
	private PersonInfo preparedPersonInfo(Context ctx,
			EmpQuickAddNewInfoInfo info) throws EASBizException, BOSException {
		PersonInfo pInfo = new PersonInfo();
		pInfo.setNumber(info.getNumber());
		pInfo.setName(info.getName());
		String idCardNO = info.getIdCardNO();
		if (!(StringUtils.isEmpty(idCardNO))) {
			info.setIdCardNO(IDCardCommonUtil.upperIdCardNo(idCardNO));
		}
		pInfo.setIdCardNO(info.getIdCardNO());
		pInfo.setPassportNO(info.getPassportNO());
		pInfo.setEmployeeType(info.getLaborRelationState());
		pInfo.setEFFDT(info.getJoinGroupDate());
		pInfo.setCell(info.getTelNum());
		pInfo.setEmail(info.getEmail());
		pInfo.setHrOrgUnit(info.getHrOrgUnit());

		AdminOrgUnitInfo adminOrg = getAdminInfoByPosition(ctx, info.getPosition());
		if (pInfo.get("notNeedGenerateObjectNumber") == null) {
			HRUtilExtend.setPersonNumber(ctx, pInfo, adminOrg);
			info.setNumber(pInfo.getNumber());
		}
		pInfo.put("notNeedGenerateObjectNumber", Boolean.valueOf(true));

		setBirthdayAndSexOfPerson(ctx, info, adminOrg,
				pInfo);

		checkEnrollPerson(ctx, info);

		checkPersonInAffairProcess(ctx, info.getNumber());
		return pInfo;
	}
	 
	protected static AdminOrgUnitInfo getAdminInfoByPosition(Context ctx,
			PositionInfo position) throws EASBizException, BOSException {
		SelectorItemCollection sic = new SelectorItemCollection();
		sic.add(new SelectorItemInfo("id"));
		sic.add(new SelectorItemInfo("adminOrgUnit.id"));
		sic.add(new SelectorItemInfo("adminOrgUnit.name"));
		sic.add(new SelectorItemInfo("adminOrgUnit.number"));

		PositionInfo pInfo = PositionFactory.getLocalInstance(ctx)
				.getPositionInfo(new ObjectUuidPK(position.getId().toString()),
						sic);

		return pInfo.getAdminOrgUnit();
	}

	protected static void setBirthdayAndSexOfPerson(Context ctx,
			EmpQuickAddNewInfoInfo info, AdminOrgUnitInfo adminOrg,
			PersonInfo pInfo) throws BOSException, EASBizException {
		String idCardNO = info.getIdCardNO();
		HROrgUnitInfo hrOrgUnit = info.getHrOrgUnit();
		String paramNum = "IS_IDCARD_VERIFY";
		if (!(StringUtils.isEmpty(idCardNO))) {
			IDCardCommonUtil iDCardCommonUtil = null;
			boolean isIDCardVerify = false;
			if (hrOrgUnit != null)
				isIDCardVerify = HRParamUtil.getParamOfHR(ctx, paramNum,
						hrOrgUnit.getId().toString());
			try {
				iDCardCommonUtil = new IDCardCommonUtil(idCardNO,
						isIDCardVerify);
				String birthday = "";
				Genders sex = null;
				if (isIDCardVerify) {
					birthday = iDCardCommonUtil.getBirthday();
					sex = iDCardCommonUtil.getGenders();
				}
				if (pInfo.getGender() == null) {
					pInfo.setGender(sex);
				}
				if ((pInfo.getBirthday() == null)
						&& (!(StringUtils.isEmpty(birthday))))
					pInfo.setBirthday(DateTimeUtils.parseDate(birthday));
			} catch (BaseException e) {
				throw e;
			} catch (ParseException e) {
				throw new BOSException(e);
			}
		}
	}
	
	protected static void checkEnrollPerson(Context ctx,
			EmpQuickAddNewInfoInfo info) throws BOSException, EASBizException {
		String idCardNo = info.getIdCardNO();
		if (!(StringUtils.isEmpty(idCardNo))) {
			info.setIdCardNO(IDCardCommonUtil.upperIdCardNo(idCardNo));
		}
		String passportNo = info.getPassportNO();
		String idString = "";

		PersonCollection pCol = new PersonCollection();
		SelectorItemCollection sic = new SelectorItemCollection();
		sic.add(new SelectorItemInfo("id"));
		sic.add(new SelectorItemInfo("name"));
		sic.add(new SelectorItemInfo("number"));
		sic.add(new SelectorItemInfo("employeeType.id"));
		sic.add(new SelectorItemInfo("employeeType.name"));
		sic.add(new SelectorItemInfo("employeeType.number"));
		EntityViewInfo view = new EntityViewInfo();
		view.setSelector(sic);

		if (!(StringUtils.isEmpty(idCardNo))) {
			String idCardNumber = idCardNo.trim();
			String _idCardNumber = "";
			boolean isCheckIDCard18To15 = HRParamUtil.getParamOfHR(ctx,
					"IsCheckIDCardNO18To15", null);
			if (!(isCheckIDCard18To15)) {
				_idCardNumber = idCardNumber;
			} else if (idCardNumber.length() == 15) {
				_idCardNumber = IDCardCommonUtil.IDCardNO15To18(idCardNumber);
			} else {
				_idCardNumber = IDCardCommonUtil.IDCardNO18To15(idCardNumber);
			}

			FilterInfo filter = new FilterInfo();

			filter.getFilterItems().add(
					new FilterItemInfo("idCardNO", idCardNumber));
			filter.getFilterItems().add(
					new FilterItemInfo("idCardNO", _idCardNumber));
			filter.setMaskString("(#0 or #1)");
			idString = "身份证号";
			view.setFilter(filter);
			pCol = PersonFactory.getLocalInstance(ctx)
					.getPersonCollection(view);
		}
		if ((pCol.size() == 0) && (!(StringUtils.isEmpty(passportNo)))) {
			FilterInfo filter = new FilterInfo();

			filter.getFilterItems().add(
					new FilterItemInfo("passportNO", passportNo));
			idString = "护照号";
			view.setFilter(filter);
			pCol = PersonFactory.getLocalInstance(ctx)
					.getPersonCollection(view);
		}

		if (pCol.size() > 0) {
			EmpPosOrgRelationQueryHelper help = new EmpPosOrgRelationQueryHelper();
			EmpPosOrgRelationCollection eCol = help.getCurrntEmpOrgRelation(
					ctx, pCol.get(0).getId().toString());
			if (eCol.size() > 0)
				throw new AffairActioniOperateException(
						AffairActioniOperateException.ENROLLAGAINEXISTS,
						new Object[] { idString,
								eCol.get(0).getAdminOrg().getName(),
								pCol.get(0).getEmployeeType().getName(),
								pCol.get(0).getName() });
		}
	}
	
	protected static void checkPersonInAffairProcess(Context ctx, String number)
	throws BOSException, AffairActioniOperateException {
		Date curDate = DateTimeUtils.truncateDate(new Date());
		EntityViewInfo viewInfo = new EntityViewInfo();
		SelectorItemCollection sic = new SelectorItemCollection();
		FilterInfo filter = new FilterInfo();
		sic.add(new SelectorItemInfo("id"));
		filter.getFilterItems().add(new FilterItemInfo("empNumber", number));
		
		filter.getFilterItems().add(
				new FilterItemInfo("bill.billState", Integer.valueOf(0)));
		filter.getFilterItems().add(
				new FilterItemInfo("bill.billState", Integer.valueOf(1)));
		filter.getFilterItems().add(
				new FilterItemInfo("bill.billState", Integer.valueOf(2)));
		
		filter.getFilterItems().add(
				new FilterItemInfo("bizDate", curDate,
						CompareType.GREATER_EQUALS));
		filter.getFilterItems().add(
				new FilterItemInfo("bill.billState", Integer.valueOf(3)));
		filter.setMaskString(" #0 and (#1 or #2 or #3 or (#4 and #5))");
		viewInfo.setSelector(sic);
		viewInfo.setFilter(filter);
		EmpEnrollBizBillEntryCollection col = EmpEnrollBizBillEntryFactory
				.getLocalInstance(ctx).getEmpEnrollBizBillEntryCollection(
						viewInfo);
		if (col.size() > 0)
			throw new AffairActioniOperateException(
					AffairActioniOperateException.ENROLLISEXISTS);
	}

	
	protected static HRBizData infosConvertToBizData(Context ctx,
			EmpQuickAddNewInfoInfo info, PersonInfo pInfo)
			throws EASBizException, BOSException {
		HRBizData bizData = new HRBizData();
		if (info.getActionDef() == null) {
			throw new AffairActioniOperateException(
					AffairActioniOperateException.HRBIZDEFINENOTNULL);
		}
		if (info.getEFFDT() == null) {
			throw new AffairActioniOperateException(
					AffairActioniOperateException.EFFECTDATEISNULL);
		}

		if (info.getActionDef() != null) {
			HRBizDefineInfo hrbizDefineInfo = HRBizDefineAppUtils
					.getHRBizDefineInfo(ctx, info.getActionDef().getId()
							.toString());
			bizData.setHrbizDefine(hrbizDefineInfo);
		}
		bizData.setActionReason(info.getActionReason());
		bizData.setActionType(info.getActionType());

		if (info.getId() != null) {
			bizData.setEntryID(info.getId().toString());
		}
		bizData.setStartDate(info.getEFFDT());

		EmpPositionInfo oldPositionInfo = new EmpPositionInfo();
		oldPositionInfo.setPersonInfo(pInfo);
		bizData.setOldPosition(oldPositionInfo);

		EmpPositionInfo newPositionInfo = new EmpPositionInfo();

		AdminOrgUnitInfo adminOrgUnitInfo = info.getAdminOrg();
		AdminOrgUnitInfo companyInfo = info.getCompany();
		if (adminOrgUnitInfo == null) {
			adminOrgUnitInfo = getAdminInfoByPosition(ctx, info.getPosition());
		}
		if ((adminOrgUnitInfo != null) && (companyInfo == null)) {
			companyInfo = HRUtilExtend.getCompany(ctx, adminOrgUnitInfo);
		}
		newPositionInfo.setCompany(companyInfo);
		newPositionInfo.setAdminInfo(adminOrgUnitInfo);
		newPositionInfo.setPositionInfo(info.getPosition());
		newPositionInfo.setPositionStateEnum(PositionStatuEnum.Active);
		newPositionInfo.setEmployeeType(info.getLaborRelationState());
		newPositionInfo.setPersonInfo(pInfo);
		EmpLaborRelationHisInfo empLaborRelationHisInfo = new EmpLaborRelationHisInfo();
		empLaborRelationHisInfo.setEmployerUnit(info.getEmployerUnit());
		newPositionInfo.setEmpLabrRelationHisInfo(empLaborRelationHisInfo);

		bizData.setNewPosition(newPositionInfo);
		bizData.setCompany(HRUtilExtend.getCompany(ctx, adminOrgUnitInfo));

		bizData.setRemark(info.getDescription());

		JobInfo jobInfo = (JobInfo) GetJobInfosUtil.geJogFamilyInfo(ctx,
				info.getPosition()).get("jobInfo");
		JobSequenceInfo jobSequenceInfo = GetJobInfosUtil.getJobSequenceInfo(
				ctx, jobInfo, info.getJobGrade());

		bizData.setJobGradeInfo(info.getJobGrade());
		bizData.setJobLevelInfo(info.getJobLevel());

		bizData.setJobSequenceInfo(jobSequenceInfo);

		bizData.setHrOrgUnitInfo(SHREmpOptBizManageTool
				.getManageHROByAdminOrg(ctx, bizData.getNewPosition()
						.getAdminInfo().getId().toString()));
		bizData.setUseDefault(true);

		if ("P/OSDCPfQXqU0TB/LQoA6uZovtk=".equals(info.getActionDef().getId()
				.toString())) {
			bizData.setSameDatePersonChange(false);
			bizData.setStartDateTime(bizData.getStartDate());
			bizData.setPreEndDateTime(HistoryVersionUtil
					.getPreRecordEndDateTime(bizData.getStartDate()));
		} else {
			String personId = pInfo.getId().toString();
			SHRSameDatePersonChangeUtil util = new SHRSameDatePersonChangeUtil();
			boolean isSameDatePersonChange = util.isSameDatePersonChange(ctx,
					personId, info.getEFFDT(), 1);
			if (isSameDatePersonChange) {
				bizData.setSameDatePersonChange(true);
				bizData.setStartDateTime(HistoryVersionUtil
						.getStartDateTimeFromEFFDT(bizData.getStartDate()));
				bizData.setPreEndDateTime(HistoryVersionUtil
						.getPreRecordEndDateTime(bizData.getStartDateTime()));
			} else {
				bizData.setSameDatePersonChange(false);
				bizData.setStartDateTime(bizData.getStartDate());
				bizData.setPreEndDateTime(HistoryVersionUtil
						.getPreRecordEndDateTime(bizData.getStartDate()));
			}
		}
		return bizData;
	}
}
