/**
 * output package name
 */
package com.kingdee.eas.mw.pay.client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import org.apache.log4j.Logger;

import com.kingdee.bos.Context;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.ISQLExecutor;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ui.face.IUIWindow;
import com.kingdee.bos.ui.face.UIException;
import com.kingdee.bos.ui.face.UIFactory;
import com.kingdee.bos.util.BOSUuid;
import com.kingdee.eas.base.permission.UserInfo;
import com.kingdee.eas.basedata.org.AdminOrgUnitFactory;
import com.kingdee.eas.basedata.org.AdminOrgUnitInfo;
import com.kingdee.eas.common.client.OprtState;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.common.client.UIContext;
import com.kingdee.eas.common.client.UIFactoryName;
import com.kingdee.eas.custom.app.unit.AppUnit;
import com.kingdee.eas.hr.emp.PersonPositionFactory;
import com.kingdee.eas.hr.emp.PersonPositionInfo;
import com.kingdee.eas.mw.pay.CostSumFactory;
import com.kingdee.eas.mw.pay.CostSumInfo;
import com.kingdee.eas.mw.pay.ICostSum;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.jdbc.rowset.IRowSet;

/**
 * output class name
 */
public class CostSumListUI extends AbstractCostSumListUI
{
    private static final Logger logger = CoreUIObject.getLogger(CostSumListUI.class);
    
    /**
     * output class constructor
     */
    public CostSumListUI() throws Exception
    {
        super();
    }

    
    @Override
	public void actionProduceCost_actionPerformed(ActionEvent e)
			throws Exception {
		// TODO Auto-generated method stub
		super.actionProduceCost_actionPerformed(e);
	}


	/**
     * output storeFields method
     */
    public void storeFields()
    {
        super.storeFields();
    }
    @Override
	public void onLoad() throws Exception { 
        // btnAuditBat
        this.auditCost.setIcon(com.kingdee.eas.util.client.EASResource.getIcon("imgTbtn_auditbatch"));
        // btnUnAuditBat	
        this.unauditCost.setIcon(com.kingdee.eas.util.client.EASResource.getIcon("imgTbtn_unauditbatch")); 
       
		super.onLoad();
		createCost.setIcon(com.kingdee.eas.util.client.EASResource.getIcon("imgTbtn_syncpurview"));// 图标
		createCost.addActionListener(new ActionListener() {// 添加点击事件
			@Override
			public void actionPerformed(ActionEvent e) {
				ShowWind();
				
			} 
		});
	}
    
    private void ShowWind() {
		UIContext context = new UIContext(this);  
		IUIWindow window; 
		String path = "com.kingdee.eas.mw.pay.client.SelectCostDateEditUI";
		try {
			window = UIFactory.createUIFactory(UIFactoryName.MODEL).create(path, context, null, OprtState.VIEW);
			window.show();
			 
			IObjectValue iObjectValue;
			try {
				//iObjectValue = getValue(iObjectPk );
				//setDataObject(iObjectValue);
	  	        loadFields();
	  	        //setSave(true);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (UIException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}
    
    @Override
	public void actionAuditCost_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		//super.actionAuditCost_actionPerformed(e);
    	List<String> ids = getSelectedIdValues();
		if(ids == null || ids.isEmpty() || ids.size() == 0){
			MsgBox.showWarning("请选择记录！");
			SysUtil.abort();
		}else{
			ICostSum con = CostSumFactory.getRemoteInstance();
			StringBuffer str = new StringBuffer();
			for(String id :ids){
				//str.append("'"+id+"',");
				str.append(""+id+",");
				con.setAllCost("1", id);
			}
			CostSumInfo info = new CostSumInfo();
			info.setDescription(str.toString()); 
			String returnMsg = con.auditCost(info);
			if(returnMsg.equals("")){
				MsgBox.showWarning("成本审核成功！");
			}else{
				returnMsg = returnMsg.substring(0,returnMsg.length()-1);
				MsgBox.showWarning(returnMsg+"单据已确认，无法审核。");
			}
			
		} 
		super.actionRefresh_actionPerformed(e);
	}

	@Override
	public void actionUnAuditCost_actionPerformed(ActionEvent e)
			throws Exception {
		// TODO Auto-generated method stub
		//super.actionUnAuditCost_actionPerformed(e);
		List<String> ids = getSelectedIdValues();
		if(ids == null || ids.isEmpty() || ids.size() == 0){
			MsgBox.showWarning("请选择记录！");
			SysUtil.abort();
		}else{
			StringBuffer str = new StringBuffer();
			for(String id :ids){
				//str.append("'"+id+"',");
				str.append(""+id+",");
			}
			CostSumInfo info = new CostSumInfo();
			info.setDescription(str.toString());
			ICostSum con = CostSumFactory.getRemoteInstance();
			String returnMsg = con.unAuditCost(info);
			if(returnMsg.equals("")){
				MsgBox.showWarning("成本反审核成功！");
			}else{
				returnMsg = returnMsg.substring(0,returnMsg.length()-1);
				MsgBox.showWarning(returnMsg+"单据已确认，无法反审核。");
			}
		} 
		super.actionRefresh_actionPerformed(e);
	}

	/**
     * output actionCreateTo_actionPerformed
     */
    public void actionCreateTo_actionPerformed(ActionEvent e) throws Exception
    {
    	boolean falg = true;
    	List<String> ids = getSelectedIdValues();
    	String thisid = "";
    	for(String id :ids){
    		thisid = id.toString();
    		CostSumInfo info = CostSumFactory.getRemoteInstance().getCostSumInfo(new ObjectUuidPK(BOSUuid.read(id)));
    		if(info.getStatus().getValue().equals("ysh")){
    			falg = false;
    		}
		}
    	if(falg){
    		
    		String sql = "select * from T_BOT_Relation where fsrcobjectid='" + thisid + "'"; 
    		ISQLExecutor executor = SQLExecutorFactory.getRemoteInstance(sql);
    		IRowSet rowSet = executor.executeSQL(); //获取结果集
    		if((rowSet.size() > 0)){
    			MsgBox.showWarning("已有下游单据！");
    		}else{
    			super.actionCreateTo_actionPerformed(e);
    		}  
    	}else{
    		MsgBox.showWarning("请先将成本单据反审核！");
    	}
    	
    }
    
    /**
     * output actionEdit_actionPerformed
     */
    public void actionEdit_actionPerformed(ActionEvent e) throws Exception
    {
    	/*boolean falg = true;
    	List<String> ids = getSelectedIdValues();
    	for(String id :ids){
    		CostSumInfo info = CostSumFactory.getRemoteInstance().getCostSumInfo(new ObjectUuidPK(BOSUuid.read(id)));
    		if(info.getStatus().getValue().equals("ysh")){
    			falg = false;
    		}
		}
    	if(falg){
    		super.actionEdit_actionPerformed(e);
    	}else{
    		MsgBox.showWarning("本单据已审核，不能修改！");
    	}*/
		MsgBox.showWarning("本单据数据不能修改！");
        
    }
    
    @Override
	protected FilterInfo getDefaultFilterForQuery() {
    	 FilterInfo filter = new FilterInfo();
         UserInfo userInfo=  SysContext.getSysContext().getCurrentUserInfo();
         String cuid = userInfo.getCU().getId().toString();
         String userid =  userInfo.getId().toString();
         
         String companyId = userInfo.getDefOrgUnit().getId().toString();
         
         boolean flagOrg = false;  
         try {
        	 String orgSql  = " SELECT count(1) as C FROM  T_PM_UserRoleOrg roleorg left  join T_PM_Role role on roleorg.FROLEID = role.fid  where role.fnumber ='hushiCostUpdate' and   roleorg.FUSERID  =  '"+userid+"'  ";
             ISQLExecutor executorOrg =  SQLExecutorFactory.getRemoteInstance(orgSql);
             IRowSet orgrs = executorOrg.executeSQL(); //获取结果集 
             if(orgrs!=null && orgrs.size() > 0){
				  while(orgrs.next()){	
					  if(orgrs.getObject("C")!=null && !"".equals(orgrs.getObject("C").toString()))
						 if( Integer.parseInt(orgrs.getObject("C").toString()) > 0 )
							 flagOrg = true; 
				  }
			 } 
             if("00000000-0000-0000-0000-000000000000CCE7AED4".equals(cuid)){
            	flagOrg = true; 
             }
             if(flagOrg){
            	 boolean flag = false;  
                 if("00000000-0000-0000-0000-000000000000CCE7AED4".equals(cuid)){
                	 flag = true;
                 }else{
                	 String sql  = " SELECT FNUMBER   FROM  T_ORG_Company where fid  = '"+cuid+"'  ";
                     String number = "";
                     ISQLExecutor executor =  SQLExecutorFactory.getRemoteInstance(sql);
                     IRowSet rs = executor.executeSQL(); //获取结果集 
                     if(rs!=null && rs.size() > 0){
                             while(rs.next()){     
                                   if(rs.getObject("FNUMBER")!=null &&  !"".equals(rs.getObject("FNUMBER").toString())){
                                  	 number =  rs.getObject("FNUMBER").toString(); 
                                   }  
                             }
                     }   
                     if(!flag){//只能查看自己的
                  	   		filter.getFilterItems().add(new FilterItemInfo("CityNumber",number,CompareType.EQUALS ));  
                  	   		

	                  	   	PersonPositionInfo PersonPosition = PersonPositionFactory.getRemoteInstance().getPersonPositionInfo("where person = '" + userInfo.getPersonId().getId() + "'"); 
	            			AdminOrgUnitInfo deptInfo = AdminOrgUnitFactory.getRemoteInstance().getAdminOrgUnitCollection("where id= '" + PersonPosition.getPersonDep().getId() +"'").get(0);
	                   	 
                  	   		if(deptInfo !=null && deptInfo.getParent().getId() != null){
			                	 String sqlCom  = " SELECT FNUMBER   FROM  T_ORG_Company where fid  = '"+deptInfo.getParent().getId()+"'  ";
			                     String numberCom = "";
			                     ISQLExecutor executorCom =  SQLExecutorFactory.getRemoteInstance(sqlCom);
			                     IRowSet rsCom = executorCom.executeSQL(); //获取结果集 
			                     if(rsCom!=null && rsCom.size() > 0){
			                         while(rsCom.next()){     
			                               if(rsCom.getObject("FNUMBER")!=null &&  !"".equals(rsCom.getObject("FNUMBER").toString())){
			                            	   numberCom =  rsCom.getObject("FNUMBER").toString(); 
			                            	   filter.getFilterItems().add(new FilterItemInfo("CLINICNUMBER",numberCom,CompareType.EQUALS ));  
			                               }  
			                         }
			                     }   
			                 }
                     } 
                     
                     
                 }
             }else{
            	 filter.getFilterItems().add(new FilterItemInfo("CityNumber","!!!!!!",CompareType.EQUALS ));  
             }
             filter.getFilterItems().add(new FilterItemInfo("DOCTORNUMBER","null",CompareType.NOTEMPTY ));  
         } catch (Exception e) {
             e.printStackTrace();
       }
         return filter;
	}
    
	/**
     * output tblMain_tableClicked method
     */
    protected void tblMain_tableClicked(com.kingdee.bos.ctrl.kdf.table.event.KDTMouseEvent e) throws Exception
    {
        super.tblMain_tableClicked(e);
    }

    /**
     * output tblMain_tableSelectChanged method
     */
    protected void tblMain_tableSelectChanged(com.kingdee.bos.ctrl.kdf.table.event.KDTSelectEvent e) throws Exception
    {
        super.tblMain_tableSelectChanged(e);
    }

    /**
     * output menuItemImportData_actionPerformed method
     */
    protected void menuItemImportData_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
        super.menuItemImportData_actionPerformed(e);
    }

    /**
     * output menuItemPCVoucher_actionPerformed method
     */
    protected void menuItemPCVoucher_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
        super.menuItemPCVoucher_actionPerformed(e);
    }

    /**
     * output actionPageSetup_actionPerformed
     */
    public void actionPageSetup_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionPageSetup_actionPerformed(e);
    }

    /**
     * output actionExitCurrent_actionPerformed
     */
    public void actionExitCurrent_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionExitCurrent_actionPerformed(e);
    }

    /**
     * output actionHelp_actionPerformed
     */
    public void actionHelp_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionHelp_actionPerformed(e);
    }

    /**
     * output actionAbout_actionPerformed
     */
    public void actionAbout_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionAbout_actionPerformed(e);
    }

    /**
     * output actionOnLoad_actionPerformed
     */
    public void actionOnLoad_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionOnLoad_actionPerformed(e);
    }

    /**
     * output actionSendMessage_actionPerformed
     */
    public void actionSendMessage_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionSendMessage_actionPerformed(e);
    }

    /**
     * output actionCalculator_actionPerformed
     */
    public void actionCalculator_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionCalculator_actionPerformed(e);
    }

    /**
     * output actionExport_actionPerformed
     */
    public void actionExport_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionExport_actionPerformed(e);
    }

    /**
     * output actionExportSelected_actionPerformed
     */
    public void actionExportSelected_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionExportSelected_actionPerformed(e);
    }

    /**
     * output actionRegProduct_actionPerformed
     */
    public void actionRegProduct_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionRegProduct_actionPerformed(e);
    }

    /**
     * output actionPersonalSite_actionPerformed
     */
    public void actionPersonalSite_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionPersonalSite_actionPerformed(e);
    }

    /**
     * output actionProcductVal_actionPerformed
     */
    public void actionProcductVal_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionProcductVal_actionPerformed(e);
    }

    /**
     * output actionExportSave_actionPerformed
     */
    public void actionExportSave_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionExportSave_actionPerformed(e);
    }

    /**
     * output actionExportSelectedSave_actionPerformed
     */
    public void actionExportSelectedSave_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionExportSelectedSave_actionPerformed(e);
    }

    /**
     * output actionKnowStore_actionPerformed
     */
    public void actionKnowStore_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionKnowStore_actionPerformed(e);
    }

    /**
     * output actionAnswer_actionPerformed
     */
    public void actionAnswer_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionAnswer_actionPerformed(e);
    }

    /**
     * output actionRemoteAssist_actionPerformed
     */
    public void actionRemoteAssist_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionRemoteAssist_actionPerformed(e);
    }

    /**
     * output actionPopupCopy_actionPerformed
     */
    public void actionPopupCopy_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionPopupCopy_actionPerformed(e);
    }

    /**
     * output actionHTMLForMail_actionPerformed
     */
    public void actionHTMLForMail_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionHTMLForMail_actionPerformed(e);
    }

    /**
     * output actionExcelForMail_actionPerformed
     */
    public void actionExcelForMail_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionExcelForMail_actionPerformed(e);
    }

    /**
     * output actionHTMLForRpt_actionPerformed
     */
    public void actionHTMLForRpt_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionHTMLForRpt_actionPerformed(e);
    }

    /**
     * output actionExcelForRpt_actionPerformed
     */
    public void actionExcelForRpt_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionExcelForRpt_actionPerformed(e);
    }

    /**
     * output actionLinkForRpt_actionPerformed
     */
    public void actionLinkForRpt_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionLinkForRpt_actionPerformed(e);
    }

    /**
     * output actionPopupPaste_actionPerformed
     */
    public void actionPopupPaste_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionPopupPaste_actionPerformed(e);
    }

    /**
     * output actionToolBarCustom_actionPerformed
     */
    public void actionToolBarCustom_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionToolBarCustom_actionPerformed(e);
    }

    /**
     * output actionCloudFeed_actionPerformed
     */
    public void actionCloudFeed_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionCloudFeed_actionPerformed(e);
    }

    /**
     * output actionCloudShare_actionPerformed
     */
    public void actionCloudShare_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionCloudShare_actionPerformed(e);
    }

    /**
     * output actionCloudScreen_actionPerformed
     */
    public void actionCloudScreen_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionCloudScreen_actionPerformed(e);
    }

    /**
     * output actionXunTongFeed_actionPerformed
     */
    public void actionXunTongFeed_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionXunTongFeed_actionPerformed(e);
    }

    /**
     * output actionAddNew_actionPerformed
     */
    public void actionAddNew_actionPerformed(ActionEvent e) throws Exception
    {
        //super.actionAddNew_actionPerformed(e);
    	MsgBox.showWarning("本单据不能新增！");
    }

    /**
     * output actionView_actionPerformed
     */
    public void actionView_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionView_actionPerformed(e);
    }

   

    /**
     * output actionRemove_actionPerformed
     */
    public void actionRemove_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionRemove_actionPerformed(e);
    }

    /**
     * output actionRefresh_actionPerformed
     */
    public void actionRefresh_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionRefresh_actionPerformed(e);
    }

    /**
     * output actionPrint_actionPerformed
     */
    public void actionPrint_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionPrint_actionPerformed(e);
    }

    /**
     * output actionPrintPreview_actionPerformed
     */
    public void actionPrintPreview_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionPrintPreview_actionPerformed(e);
    }

    /**
     * output actionLocate_actionPerformed
     */
    public void actionLocate_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionLocate_actionPerformed(e);
    }

    /**
     * output actionQuery_actionPerformed
     */
    public void actionQuery_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionQuery_actionPerformed(e);
    }

    /**
     * output actionImportData_actionPerformed
     */
    public void actionImportData_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionImportData_actionPerformed(e);
    }

    /**
     * output actionAttachment_actionPerformed
     */
    public void actionAttachment_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionAttachment_actionPerformed(e);
    }

    /**
     * output actionExportData_actionPerformed
     */
    public void actionExportData_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionExportData_actionPerformed(e);
    }

    /**
     * output actionToExcel_actionPerformed
     */
    public void actionToExcel_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionToExcel_actionPerformed(e);
    }

    /**
     * output actionStartWorkFlow_actionPerformed
     */
    public void actionStartWorkFlow_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionStartWorkFlow_actionPerformed(e);
    }

    /**
     * output actionPublishReport_actionPerformed
     */
    public void actionPublishReport_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionPublishReport_actionPerformed(e);
    }

    /**
     * output actionCancel_actionPerformed
     */
    public void actionCancel_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionCancel_actionPerformed(e);
    }

    /**
     * output actionCancelCancel_actionPerformed
     */
    public void actionCancelCancel_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionCancelCancel_actionPerformed(e);
    }

    /**
     * output actionQueryScheme_actionPerformed
     */
    public void actionQueryScheme_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionQueryScheme_actionPerformed(e);
    }

    

    /**
     * output actionCopyTo_actionPerformed
     */
    public void actionCopyTo_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionCopyTo_actionPerformed(e);
    }

    /**
     * output actionTraceUp_actionPerformed
     */
    public void actionTraceUp_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionTraceUp_actionPerformed(e);
    }

    /**
     * output actionTraceDown_actionPerformed
     */
    public void actionTraceDown_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionTraceDown_actionPerformed(e);
    }

    /**
     * output actionVoucher_actionPerformed
     */
    public void actionVoucher_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionVoucher_actionPerformed(e);
    }

    /**
     * output actionDelVoucher_actionPerformed
     */
    public void actionDelVoucher_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionDelVoucher_actionPerformed(e);
    }

    /**
     * output actionAuditResult_actionPerformed
     */
    public void actionAuditResult_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionAuditResult_actionPerformed(e);
    }

    /**
     * output actionViewDoProccess_actionPerformed
     */
    public void actionViewDoProccess_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionViewDoProccess_actionPerformed(e);
    }

    /**
     * output actionMultiapprove_actionPerformed
     */
    public void actionMultiapprove_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionMultiapprove_actionPerformed(e);
    }

    /**
     * output actionNextPerson_actionPerformed
     */
    public void actionNextPerson_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionNextPerson_actionPerformed(e);
    }

    /**
     * output actionWorkFlowG_actionPerformed
     */
    public void actionWorkFlowG_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionWorkFlowG_actionPerformed(e);
    }

    /**
     * output actionSendSmsMessage_actionPerformed
     */
    public void actionSendSmsMessage_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionSendSmsMessage_actionPerformed(e);
    }

    /**
     * output actionSignature_actionPerformed
     */
    public void actionSignature_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionSignature_actionPerformed(e);
    }

    /**
     * output actionWorkflowList_actionPerformed
     */
    public void actionWorkflowList_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionWorkflowList_actionPerformed(e);
    }

    /**
     * output actoinViewSignature_actionPerformed
     */
    public void actoinViewSignature_actionPerformed(ActionEvent e) throws Exception
    {
        super.actoinViewSignature_actionPerformed(e);
    }

    /**
     * output actionNumberSign_actionPerformed
     */
    public void actionNumberSign_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionNumberSign_actionPerformed(e);
    }

    /**
     * output actionPCVoucher_actionPerformed
     */
    public void actionPCVoucher_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionPCVoucher_actionPerformed(e);
    }

    /**
     * output actionDelPCVoucher_actionPerformed
     */
    public void actionDelPCVoucher_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionDelPCVoucher_actionPerformed(e);
    }

    /**
     * output actionTDPrint_actionPerformed
     */
    public void actionTDPrint_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionTDPrint_actionPerformed(e);
    }

    /**
     * output actionTDPrintPreview_actionPerformed
     */
    public void actionTDPrintPreview_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionTDPrintPreview_actionPerformed(e);
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.mw.pay.CostSumFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected com.kingdee.bos.dao.IObjectValue createNewData()
    {
        com.kingdee.eas.mw.pay.CostSumInfo objectValue = new com.kingdee.eas.mw.pay.CostSumInfo();
		
        return objectValue;
    }

}