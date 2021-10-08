/**
 * output package name
 */
package com.kingdee.eas.mw.pay.client;

import java.awt.event.*;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.query.ISQLExecutor;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.bos.kscript.debug.ObjectValue;
import com.kingdee.eas.base.permission.UserInfo;
import com.kingdee.eas.basedata.org.AdminOrgUnitFactory;
import com.kingdee.eas.basedata.org.AdminOrgUnitInfo;
import com.kingdee.eas.basedata.org.CtrlUnitInfo;
import com.kingdee.eas.basedata.person.PersonInfo;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.custom.app.unit.AppUnit;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.hr.emp.PersonPositionFactory;
import com.kingdee.eas.hr.emp.PersonPositionInfo;
import com.kingdee.eas.mw.pay.CostByUpdateInfo;
import com.kingdee.eas.mw.pay.CostSumFactory;
import com.kingdee.eas.mw.pay.ICostSum;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.swing.event.DataChangeEvent;
import com.kingdee.bos.ctrl.swing.event.DataChangeListener;

/**
 * output class name
 */
public class CostByUpdateEditUI extends AbstractCostByUpdateEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(CostByUpdateEditUI.class);
    
    /**
     * output class constructor
     */
    public CostByUpdateEditUI() throws Exception
    {
        super();
    }
    
    @Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub 
    	this.auditCost.setHideActionText(true);
    	this.unauditCost.setHideActionText(true);
    	
    	addListeners();
    	 
    	this.contcityNumber.setEnabled(false);
    	this.contcityName.setEnabled(false);
    	//this.contperiod.setEnabled(false);
    	this.contdoctorName.setEnabled(false);
    	this.contdoctorNumber.setEnabled(false);
    	this.contclinicNumber.setEnabled(false);
    	this.contclinicName.setEnabled(false);
    	
    	this.contsumxhzz.setEnabled(false);
    	this.contsumxhyxjz.setEnabled(false);
    	this.contsumxhcgjz.setEnabled(false);
    	this.contsumxhknw.setEnabled(false);
    	this.contsumxhxf.setEnabled(false);
    	this.contsumxhey.setEnabled(false);
    	this.contsumxhyz.setEnabled(false);
    	this.contsumxhmb.setEnabled(false);
    	
    	this.contsumjgfzz.setEnabled(false);
    	this.contsumjgfyxjz.setEnabled(false);
    	this.contsumjgfcgjz.setEnabled(false);
    	this.contsumjgfknw.setEnabled(false);
    	this.contsumjgfxf.setEnabled(false);
    	this.contsumjgfey.setEnabled(false);
    	this.contsumjgfyz.setEnabled(false);
    	this.contsumjgfmb.setEnabled(false);
    	  
    	this.contallxhzz.setEnabled(false);
    	this.contallxhyxjz.setEnabled(false);
    	this.contallxhcgjz.setEnabled(false);
    	this.txtallzhknw.setEnabled(false);
    	this.contallxhxf.setEnabled(false);
    	this.contallxhey.setEnabled(false);
    	this.contallxhyz.setEnabled(false);
    	this.contallxhmb.setEnabled(false);
    	
    	this.contalljgfzz.setEnabled(false);
    	this.contalljgfyxjz.setEnabled(false);
    	this.contalljgfcgjz.setEnabled(false);
    	this.contalljgfknw.setEnabled(false);
    	this.contalljgfxf.setEnabled(false);
    	this.contalljgfey.setEnabled(false);
    	this.contalljgfyz.setEnabled(false);
    	this.contalljgdmb.setEnabled(false);
    	
		super.onLoad();
		this.prmtdoctor.setQueryInfo("com.kingdee.eas.hr.affair.app.PersonAllQuery");		
	}
    /**
     * output createNewData method
     */
    protected com.kingdee.bos.dao.IObjectValue createNewData()
    {
    	com.kingdee.eas.mw.pay.CostByUpdateInfo objectValue = new com.kingdee.eas.mw.pay.CostByUpdateInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
        
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.MONTH, -1);
        Date date3 = cal.getTime();
        SimpleDateFormat format3= new SimpleDateFormat("yyyyMM");
        String businessDate = format3.format(date3);  
       
    	UserInfo userInfo=  SysContext.getSysContext().getCurrentUserInfo();// userInfo
        SysContext.getSysContext().getCurrentCtrlUnit();
        String cuid = userInfo.getCU().getId().toString(); 
        AdminOrgUnitInfo cityInfo;
		try {
			cityInfo = AdminOrgUnitFactory.getRemoteInstance().getAdminOrgUnitCollection("where id= '" + cuid +"'").get(0);
			 
			if(userInfo.getPersonId() != null){
				PersonPositionInfo PersonPosition = PersonPositionFactory.getRemoteInstance().getPersonPositionInfo("where person = '" + userInfo.getPersonId().getId() + "'"); 
				objectValue.setCityName(cityInfo.getName());
				objectValue.setCityNumber(cityInfo.getNumber());
				
				AdminOrgUnitInfo deptInfo = AdminOrgUnitFactory.getRemoteInstance().getAdminOrgUnitCollection("where id= '" + PersonPosition.getPersonDep().getId() +"'").get(0);
	  			AdminOrgUnitInfo companyInfo = AdminOrgUnitFactory.getRemoteInstance().getAdminOrgUnitCollection("where id= '" + deptInfo.getParent().getId() +"'").get(0);
	  			 
				
				objectValue.setClinicName(companyInfo.getName());
				objectValue.setClinicNumber(companyInfo.getNumber());
			}
			objectValue.setIszidai(false);
  			
			objectValue.setPeriod(businessDate);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
        return objectValue;
    }

    protected void addListeners() {
    	prmtdoctor.addDataChangeListener(new DataChangeListener(){ 
			@Override
			public void dataChanged(DataChangeEvent paramDataChangeEvent) { 
				// TODO Auto-generated method stub
				PersonInfo person = (PersonInfo)paramDataChangeEvent.getNewValue();  
				try {
					txtdoctorName.setStringValue(person.getName());
					txtdoctorNumber.setStringValue(person.getNumber());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} 
		});
    	//加工费种植
    	txtjgfzz.addDataChangeListener(new DataChangeListener(){ 
			@Override
			public void dataChanged(DataChangeEvent paramDataChangeEvent) {  
				BigDecimal all = (BigDecimal)paramDataChangeEvent.getNewValue();  
				try { txtalljgfzz.setValue( all.add(new BigDecimal(txtsumjgfzz.getStringValue()==null? "0":txtsumjgfzz.getStringValue())));
				} catch (Exception e) {  e.printStackTrace(); }
			} 
		});
    	//加工费隐形矫正
    	txtjgfyxjz.addDataChangeListener(new DataChangeListener(){ 
			@Override
			public void dataChanged(DataChangeEvent paramDataChangeEvent) {  
				BigDecimal all = (BigDecimal)paramDataChangeEvent.getNewValue();  
				try { txtalljgfyxjz.setValue( all.add(new BigDecimal(txtsumjgfyxjz.getStringValue()==null? "0":txtsumjgfyxjz.getStringValue())));
				} catch (Exception e) {  e.printStackTrace(); }
			} 
		});
    	//加工费常规矫正
    	txtjgfcgjz.addDataChangeListener(new DataChangeListener(){ 
			@Override
			public void dataChanged(DataChangeEvent paramDataChangeEvent) {  
				BigDecimal all = (BigDecimal)paramDataChangeEvent.getNewValue();  
				try { txtalljgfcgjz.setValue( all.add(new BigDecimal(txtsumjgfcgjz.getStringValue()==null? "0":txtsumjgfcgjz.getStringValue())));
				} catch (Exception e) {  e.printStackTrace(); }
			} 
		});
    	//加工费口内外
    	txtjgfknw.addDataChangeListener(new DataChangeListener(){ 
			@Override
			public void dataChanged(DataChangeEvent paramDataChangeEvent) {  
				BigDecimal all = (BigDecimal)paramDataChangeEvent.getNewValue();  
				try { txtalljgfknw.setValue( all.add(new BigDecimal(txtsumjgfknw.getStringValue()==null? "0":txtsumjgfknw.getStringValue())));
				} catch (Exception e) {  e.printStackTrace(); }
			} 
		});
    	//加工费修复
    	txtjgfxf.addDataChangeListener(new DataChangeListener(){ 
			@Override
			public void dataChanged(DataChangeEvent paramDataChangeEvent) {  
				BigDecimal all = (BigDecimal)paramDataChangeEvent.getNewValue();  
				try { txtalljgfxf.setValue( all.add(new BigDecimal(txtsumjgfxf.getStringValue()==null? "0":txtsumjgfxf.getStringValue())));
				} catch (Exception e) {  e.printStackTrace(); }
			} 
		});
    	//加工费儿牙
    	txtjgfey.addDataChangeListener(new DataChangeListener(){ 
			@Override
			public void dataChanged(DataChangeEvent paramDataChangeEvent) {  
				BigDecimal all = (BigDecimal)paramDataChangeEvent.getNewValue();  
				try { txtalljgfey.setValue( all.add(new BigDecimal(txtsumjgfey.getStringValue()==null? "0":txtsumjgfey.getStringValue())));
				} catch (Exception e) {  e.printStackTrace(); }
			} 
		});
    	//加工费牙周
    	txtjgfyz.addDataChangeListener(new DataChangeListener(){ 
			@Override
			public void dataChanged(DataChangeEvent paramDataChangeEvent) {  
				BigDecimal all = (BigDecimal)paramDataChangeEvent.getNewValue();  
				try { txtalljgfyz.setValue( all.add(new BigDecimal(txtsumjgfyz.getStringValue()==null? "0":txtsumjgfyz.getStringValue())));
				} catch (Exception e) {  e.printStackTrace(); }
			} 
		});
    	//加工费美白
    	txtjgfmb.addDataChangeListener(new DataChangeListener(){ 
			@Override
			public void dataChanged(DataChangeEvent paramDataChangeEvent) {  
				BigDecimal all = (BigDecimal)paramDataChangeEvent.getNewValue();  
				try { txtalljgdmb.setValue( all.add(new BigDecimal(txtsumjgfmb.getStringValue()==null? "0":txtsumjgfmb.getStringValue())));
				} catch (Exception e) {  e.printStackTrace(); }
			} 
		}); 
    	//消耗种植
    	txtxhzz.addDataChangeListener(new DataChangeListener(){ 
			@Override
			public void dataChanged(DataChangeEvent paramDataChangeEvent) {  
				BigDecimal all = (BigDecimal)paramDataChangeEvent.getNewValue();  
				try { txtallxhzz.setValue( all.add(new BigDecimal(txtsumxhzz.getStringValue()==null? "0":txtsumxhzz.getStringValue())));
				} catch (Exception e) {  e.printStackTrace(); }
			} 
		});
    	//消耗隐形矫正
    	txtxhyxjz.addDataChangeListener(new DataChangeListener(){ 
			@Override
			public void dataChanged(DataChangeEvent paramDataChangeEvent) {  
				BigDecimal all = (BigDecimal)paramDataChangeEvent.getNewValue();  
				try { txtallxhyxjz.setValue( all.add(new BigDecimal(txtsumxhyxjz.getStringValue()==null? "0":txtsumxhyxjz.getStringValue())));
				} catch (Exception e) {  e.printStackTrace(); }
			} 
		});
    	//消耗常规矫正
    	txtxhcgjz.addDataChangeListener(new DataChangeListener(){ 
			@Override
			public void dataChanged(DataChangeEvent paramDataChangeEvent) {  
				BigDecimal all = (BigDecimal)paramDataChangeEvent.getNewValue();  
				try { txtallxhcgjz.setValue( all.add(new BigDecimal(txtsumxhcgjz.getStringValue()==null? "0":txtsumxhcgjz.getStringValue())));
				} catch (Exception e) {  e.printStackTrace(); }
			} 
		});
    	//消耗口内外
    	txtxhknw.addDataChangeListener(new DataChangeListener(){ 
			@Override
			public void dataChanged(DataChangeEvent paramDataChangeEvent) {  
				BigDecimal all = (BigDecimal)paramDataChangeEvent.getNewValue();  
				try { txtallzhknw.setValue( all.add(new BigDecimal(txtsumxhknw.getStringValue()==null? "0":txtsumxhknw.getStringValue())));
				} catch (Exception e) {  e.printStackTrace(); }
			} 
		});
    	//消耗修复
    	txtxhxf.addDataChangeListener(new DataChangeListener(){ 
			@Override
			public void dataChanged(DataChangeEvent paramDataChangeEvent) {  
				BigDecimal all = (BigDecimal)paramDataChangeEvent.getNewValue();  
				try { txtallxhxf.setValue( all.add(new BigDecimal(txtsumxhxf.getStringValue()==null? "0":txtsumxhxf.getStringValue())));
				} catch (Exception e) {  e.printStackTrace(); }
			} 
		});
    	//消耗儿牙
    	txtxhey.addDataChangeListener(new DataChangeListener(){ 
			@Override
			public void dataChanged(DataChangeEvent paramDataChangeEvent) {  
				BigDecimal all = (BigDecimal)paramDataChangeEvent.getNewValue();  
				try { txtallxhey.setValue( all.add(new BigDecimal(txtsumxhey.getStringValue()==null? "0":txtsumxhey.getStringValue())));
				} catch (Exception e) {  e.printStackTrace(); }
			} 
		});
    	//消耗牙周
    	txtxhyz.addDataChangeListener(new DataChangeListener(){ 
			@Override
			public void dataChanged(DataChangeEvent paramDataChangeEvent) {  
				BigDecimal all = (BigDecimal)paramDataChangeEvent.getNewValue();  
				try { txtallxhyz.setValue( all.add(new BigDecimal(txtsumxhyz.getStringValue()==null? "0":txtsumxhyz.getStringValue())));
				} catch (Exception e) {  e.printStackTrace(); }
			} 
		});
    	//消耗美白
    	txtxhmb.addDataChangeListener(new DataChangeListener(){ 
			@Override
			public void dataChanged(DataChangeEvent paramDataChangeEvent) {  
				BigDecimal all = (BigDecimal)paramDataChangeEvent.getNewValue();  
				try { txtallxhmb.setValue( all.add(new BigDecimal(txtsumxhmb.getStringValue()==null? "0":txtsumxhmb.getStringValue())));
				} catch (Exception e) {  e.printStackTrace(); }
			} 
		});
    }
 
    
    /**
     * output actionEdit_actionPerformed
     */
    public void actionEdit_actionPerformed(ActionEvent e) throws Exception
    {
        
        String thisid = editData.getId().toString();
    	 
		
        String sql = "SELECT  *  FROM   CT_PAY_COSTSUM where cfstatus in ('ysh','yqr') and  fid = (select fsrcobjectid  from T_BOT_Relation where  FDestObjectID ='" + thisid + "')"; 
		ISQLExecutor executor = SQLExecutorFactory.getRemoteInstance(sql);
		IRowSet rowSet = executor.executeSQL(); //获取结果集
		if((rowSet.size() > 0)){
			MsgBox.showWarning("上游单据已审核或已确认，禁止修改！");
		}else{ 
			super.actionEdit_actionPerformed(e);
		}
    }
    
    /**
     * output actionSubmitOption_actionPerformed
     */
    public void actionSubmitOption_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionSubmitOption_actionPerformed(e);
         
    }
    
    /**
     * output actionSave_actionPerformed
     */
    public void actionSave_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionSave_actionPerformed(e);
        ICostSum con = CostSumFactory.getRemoteInstance();
        con.setAllCost("2", editData.get("ID").toString());  
    }
    /**
     * output actionSubmit_actionPerformed
     */
    public void actionSubmit_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionSubmit_actionPerformed(e);
        ICostSum con = CostSumFactory.getRemoteInstance();
        con.setAllCost("2", editData.get("ID").toString());  
    }
	/**
     * output loadFields method
     */
    public void loadFields()
    {
        super.loadFields();
    }

    /**
     * output storeFields method
     */
    public void storeFields()
    {
        super.storeFields();
    }

    /**
     * output btnAddLine_actionPerformed method
     */
    protected void btnAddLine_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
        super.btnAddLine_actionPerformed(e);
    }

    /**
     * output menuItemEnterToNextRow_itemStateChanged method
     */
    protected void menuItemEnterToNextRow_itemStateChanged(java.awt.event.ItemEvent e) throws Exception
    {
        super.menuItemEnterToNextRow_itemStateChanged(e);
    }

    /**
     * output MenuItemPCVoucher_actionPerformed method
     */
    protected void MenuItemPCVoucher_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
        super.MenuItemPCVoucher_actionPerformed(e);
    }

    /**
     * output menuItemDelPCVoucher_actionPerformed method
     */
    protected void menuItemDelPCVoucher_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
        super.menuItemDelPCVoucher_actionPerformed(e);
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
     * output actionFirst_actionPerformed
     */
    public void actionFirst_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionFirst_actionPerformed(e);
    }

    /**
     * output actionPre_actionPerformed
     */
    public void actionPre_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionPre_actionPerformed(e);
    }

    /**
     * output actionNext_actionPerformed
     */
    public void actionNext_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionNext_actionPerformed(e);
    }

    /**
     * output actionLast_actionPerformed
     */
    public void actionLast_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionLast_actionPerformed(e);
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
     * output actionCopy_actionPerformed
     */
    public void actionCopy_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionCopy_actionPerformed(e);
    }

    /**
     * output actionAddNew_actionPerformed
     */
    public void actionAddNew_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionAddNew_actionPerformed(e);
    }

   

    /**
     * output actionRemove_actionPerformed
     */
    public void actionRemove_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionRemove_actionPerformed(e);
    }

    /**
     * output actionAttachment_actionPerformed
     */
    public void actionAttachment_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionAttachment_actionPerformed(e);
    }

   

    /**
     * output actionReset_actionPerformed
     */
    public void actionReset_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionReset_actionPerformed(e);
    }

    /**
     * output actionMsgFormat_actionPerformed
     */
    public void actionMsgFormat_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionMsgFormat_actionPerformed(e);
    }

    /**
     * output actionAddLine_actionPerformed
     */
    public void actionAddLine_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionAddLine_actionPerformed(e);
    }

    /**
     * output actionCopyLine_actionPerformed
     */
    public void actionCopyLine_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionCopyLine_actionPerformed(e);
    }

    /**
     * output actionInsertLine_actionPerformed
     */
    public void actionInsertLine_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionInsertLine_actionPerformed(e);
    }

    /**
     * output actionRemoveLine_actionPerformed
     */
    public void actionRemoveLine_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionRemoveLine_actionPerformed(e);
    }

    /**
     * output actionCreateFrom_actionPerformed
     */
    public void actionCreateFrom_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionCreateFrom_actionPerformed(e);
    }

    /**
     * output actionCopyFrom_actionPerformed
     */
    public void actionCopyFrom_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionCopyFrom_actionPerformed(e);
    }

    /**
     * output actionAuditResult_actionPerformed
     */
    public void actionAuditResult_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionAuditResult_actionPerformed(e);
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
     * output actionViewSubmitProccess_actionPerformed
     */
    public void actionViewSubmitProccess_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionViewSubmitProccess_actionPerformed(e);
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
     * output actionStartWorkFlow_actionPerformed
     */
    public void actionStartWorkFlow_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionStartWorkFlow_actionPerformed(e);
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
     * output actionWorkFlowG_actionPerformed
     */
    public void actionWorkFlowG_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionWorkFlowG_actionPerformed(e);
    }

    /**
     * output actionCreateTo_actionPerformed
     */
    public void actionCreateTo_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionCreateTo_actionPerformed(e);
    }

    /**
     * output actionSendingMessage_actionPerformed
     */
    public void actionSendingMessage_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionSendingMessage_actionPerformed(e);
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
     * output actionViewSignature_actionPerformed
     */
    public void actionViewSignature_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionViewSignature_actionPerformed(e);
    }

    /**
     * output actionSendMail_actionPerformed
     */
    public void actionSendMail_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionSendMail_actionPerformed(e);
    }

    /**
     * output actionLocate_actionPerformed
     */
    public void actionLocate_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionLocate_actionPerformed(e);
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
     * output actionAuditCost_actionPerformed
     */
    public void actionAuditCost_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionAuditCost_actionPerformed(e);
    }

    /**
     * output actionUnAuditCost_actionPerformed
     */
    public void actionUnAuditCost_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionUnAuditCost_actionPerformed(e);
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.mw.pay.CostByUpdateFactory.getRemoteInstance();
    }

    /**
     * output createNewDetailData method
     */
    protected IObjectValue createNewDetailData(KDTable table)
    {
		
        return null;
    }

    

}