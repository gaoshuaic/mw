/**
 * output package name
 */
package com.kingdee.eas.mw.pay.client;

import org.apache.log4j.*;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.border.*;
import javax.swing.BorderFactory;
import javax.swing.event.*;
import javax.swing.KeyStroke;

import com.kingdee.bos.ctrl.swing.*;
import com.kingdee.bos.ctrl.kdf.table.*;
import com.kingdee.bos.ctrl.kdf.data.event.*;
import com.kingdee.bos.dao.*;
import com.kingdee.bos.dao.query.*;
import com.kingdee.bos.metadata.*;
import com.kingdee.bos.metadata.entity.*;
import com.kingdee.bos.ui.face.*;
import com.kingdee.bos.ui.util.ResourceBundleHelper;
import com.kingdee.bos.util.BOSUuid;
import com.kingdee.bos.service.ServiceContext;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.enums.EnumUtils;
import com.kingdee.bos.ui.face.UIRuleUtil;
import com.kingdee.bos.ctrl.swing.event.*;
import com.kingdee.bos.ctrl.kdf.table.event.*;
import com.kingdee.bos.ctrl.extendcontrols.*;
import com.kingdee.bos.ctrl.kdf.util.render.*;
import com.kingdee.bos.ui.face.IItemAction;
import com.kingdee.eas.framework.batchHandler.RequestContext;
import com.kingdee.bos.ui.util.IUIActionPostman;
import com.kingdee.bos.appframework.client.servicebinding.ActionProxyFactory;
import com.kingdee.bos.appframework.uistatemanage.ActionStateConst;
import com.kingdee.bos.appframework.validator.ValidateHelper;
import com.kingdee.bos.appframework.uip.UINavigator;


/**
 * output class name
 */
public abstract class AbstractServiceAmountEditUI extends com.kingdee.eas.framework.client.CoreBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractServiceAmountEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCreator;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCreateTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contNumber;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contBizDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contDescription;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contAuditor;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contmzNumber;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contmzName;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contempNumber;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contempName;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conthlAmount;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contklxsAmount;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contmdzyAmount;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contkhAmount;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbusinessDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contimportDate;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtCreator;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateCreateTime;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkBizDate;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtDescription;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtAuditor;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtmzNumber;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtmzName;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtempNumber;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtempName;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txthlAmount;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtklxsAmount;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtmdzyAmount;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtkhAmount;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtbusinessDate;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkimportDate;
    protected com.kingdee.eas.mw.pay.ServiceAmountInfo editData = null;
    /**
     * output class constructor
     */
    public AbstractServiceAmountEditUI() throws Exception
    {
        super();
        this.defaultObjectName = "editData";
        jbInit();
        
        initUIP();
    }

    /**
     * output jbInit method
     */
    private void jbInit() throws Exception
    {
        this.resHelper = new ResourceBundleHelper(AbstractServiceAmountEditUI.class.getName());
        this.setUITitle(resHelper.getString("this.title"));
        //actionSubmit
        String _tempStr = null;
        actionSubmit.setEnabled(true);
        actionSubmit.setDaemonRun(false);

        actionSubmit.putValue(ItemAction.ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl S"));
        _tempStr = resHelper.getString("ActionSubmit.SHORT_DESCRIPTION");
        actionSubmit.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
        _tempStr = resHelper.getString("ActionSubmit.LONG_DESCRIPTION");
        actionSubmit.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
        _tempStr = resHelper.getString("ActionSubmit.NAME");
        actionSubmit.putValue(ItemAction.NAME, _tempStr);
        this.actionSubmit.setBindWorkFlow(true);
         this.actionSubmit.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionSubmit.addService(new com.kingdee.eas.framework.client.service.NetFunctionService());
         this.actionSubmit.addService(new com.kingdee.eas.framework.client.service.UserMonitorService());
        //actionPrint
        actionPrint.setEnabled(true);
        actionPrint.setDaemonRun(false);

        actionPrint.putValue(ItemAction.ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl P"));
        _tempStr = resHelper.getString("ActionPrint.SHORT_DESCRIPTION");
        actionPrint.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
        _tempStr = resHelper.getString("ActionPrint.LONG_DESCRIPTION");
        actionPrint.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
        _tempStr = resHelper.getString("ActionPrint.NAME");
        actionPrint.putValue(ItemAction.NAME, _tempStr);
         this.actionPrint.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionPrint.addService(new com.kingdee.eas.framework.client.service.NetFunctionService());
         this.actionPrint.addService(new com.kingdee.eas.framework.client.service.UserMonitorService());
        //actionPrintPreview
        actionPrintPreview.setEnabled(true);
        actionPrintPreview.setDaemonRun(false);

        actionPrintPreview.putValue(ItemAction.ACCELERATOR_KEY, KeyStroke.getKeyStroke("shift ctrl P"));
        _tempStr = resHelper.getString("ActionPrintPreview.SHORT_DESCRIPTION");
        actionPrintPreview.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
        _tempStr = resHelper.getString("ActionPrintPreview.LONG_DESCRIPTION");
        actionPrintPreview.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
        _tempStr = resHelper.getString("ActionPrintPreview.NAME");
        actionPrintPreview.putValue(ItemAction.NAME, _tempStr);
         this.actionPrintPreview.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionPrintPreview.addService(new com.kingdee.eas.framework.client.service.NetFunctionService());
         this.actionPrintPreview.addService(new com.kingdee.eas.framework.client.service.UserMonitorService());
        this.contCreator = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contCreateTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contLastUpdateUser = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contLastUpdateTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contNumber = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contBizDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contDescription = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contAuditor = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contmzNumber = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contmzName = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contempNumber = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contempName = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conthlAmount = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contklxsAmount = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contmdzyAmount = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contkhAmount = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbusinessDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contimportDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.prmtCreator = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateCreateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtLastUpdateUser = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateLastUpdateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.pkBizDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtDescription = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtAuditor = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtmzNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtmzName = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtempNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtempName = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txthlAmount = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtklxsAmount = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtmdzyAmount = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtkhAmount = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtbusinessDate = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.pkimportDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.contCreator.setName("contCreator");
        this.contCreateTime.setName("contCreateTime");
        this.contLastUpdateUser.setName("contLastUpdateUser");
        this.contLastUpdateTime.setName("contLastUpdateTime");
        this.contNumber.setName("contNumber");
        this.contBizDate.setName("contBizDate");
        this.contDescription.setName("contDescription");
        this.contAuditor.setName("contAuditor");
        this.contmzNumber.setName("contmzNumber");
        this.contmzName.setName("contmzName");
        this.contempNumber.setName("contempNumber");
        this.contempName.setName("contempName");
        this.conthlAmount.setName("conthlAmount");
        this.contklxsAmount.setName("contklxsAmount");
        this.contmdzyAmount.setName("contmdzyAmount");
        this.contkhAmount.setName("contkhAmount");
        this.contbusinessDate.setName("contbusinessDate");
        this.contimportDate.setName("contimportDate");
        this.prmtCreator.setName("prmtCreator");
        this.kDDateCreateTime.setName("kDDateCreateTime");
        this.prmtLastUpdateUser.setName("prmtLastUpdateUser");
        this.kDDateLastUpdateTime.setName("kDDateLastUpdateTime");
        this.txtNumber.setName("txtNumber");
        this.pkBizDate.setName("pkBizDate");
        this.txtDescription.setName("txtDescription");
        this.prmtAuditor.setName("prmtAuditor");
        this.txtmzNumber.setName("txtmzNumber");
        this.txtmzName.setName("txtmzName");
        this.txtempNumber.setName("txtempNumber");
        this.txtempName.setName("txtempName");
        this.txthlAmount.setName("txthlAmount");
        this.txtklxsAmount.setName("txtklxsAmount");
        this.txtmdzyAmount.setName("txtmdzyAmount");
        this.txtkhAmount.setName("txtkhAmount");
        this.txtbusinessDate.setName("txtbusinessDate");
        this.pkimportDate.setName("pkimportDate");
        // CoreUI		
        this.btnTraceUp.setVisible(false);		
        this.btnTraceDown.setVisible(false);		
        this.btnCreateTo.setVisible(true);		
        this.btnAddLine.setVisible(false);		
        this.btnCopyLine.setVisible(false);		
        this.btnInsertLine.setVisible(false);		
        this.btnRemoveLine.setVisible(false);		
        this.btnAuditResult.setVisible(false);		
        this.separator1.setVisible(false);		
        this.menuItemCreateTo.setVisible(true);		
        this.separator3.setVisible(false);		
        this.menuItemTraceUp.setVisible(false);		
        this.menuItemTraceDown.setVisible(false);		
        this.menuTable1.setVisible(false);		
        this.menuItemAddLine.setVisible(false);		
        this.menuItemCopyLine.setVisible(false);		
        this.menuItemInsertLine.setVisible(false);		
        this.menuItemRemoveLine.setVisible(false);		
        this.menuItemViewSubmitProccess.setVisible(false);		
        this.menuItemViewDoProccess.setVisible(false);		
        this.menuItemAuditResult.setVisible(false);
        // contCreator		
        this.contCreator.setBoundLabelText(resHelper.getString("contCreator.boundLabelText"));		
        this.contCreator.setBoundLabelLength(100);		
        this.contCreator.setBoundLabelUnderline(true);		
        this.contCreator.setEnabled(false);
        // contCreateTime		
        this.contCreateTime.setBoundLabelText(resHelper.getString("contCreateTime.boundLabelText"));		
        this.contCreateTime.setBoundLabelLength(100);		
        this.contCreateTime.setBoundLabelUnderline(true);		
        this.contCreateTime.setEnabled(false);
        // contLastUpdateUser		
        this.contLastUpdateUser.setBoundLabelText(resHelper.getString("contLastUpdateUser.boundLabelText"));		
        this.contLastUpdateUser.setBoundLabelLength(100);		
        this.contLastUpdateUser.setBoundLabelUnderline(true);		
        this.contLastUpdateUser.setEnabled(false);		
        this.contLastUpdateUser.setVisible(false);
        // contLastUpdateTime		
        this.contLastUpdateTime.setBoundLabelText(resHelper.getString("contLastUpdateTime.boundLabelText"));		
        this.contLastUpdateTime.setBoundLabelLength(100);		
        this.contLastUpdateTime.setBoundLabelUnderline(true);		
        this.contLastUpdateTime.setEnabled(false);		
        this.contLastUpdateTime.setVisible(false);
        // contNumber		
        this.contNumber.setBoundLabelText(resHelper.getString("contNumber.boundLabelText"));		
        this.contNumber.setBoundLabelLength(100);		
        this.contNumber.setBoundLabelUnderline(true);
        // contBizDate		
        this.contBizDate.setBoundLabelText(resHelper.getString("contBizDate.boundLabelText"));		
        this.contBizDate.setBoundLabelLength(100);		
        this.contBizDate.setBoundLabelUnderline(true);		
        this.contBizDate.setBoundLabelAlignment(7);		
        this.contBizDate.setVisible(true);
        // contDescription		
        this.contDescription.setBoundLabelText(resHelper.getString("contDescription.boundLabelText"));		
        this.contDescription.setBoundLabelLength(100);		
        this.contDescription.setBoundLabelUnderline(true);
        // contAuditor		
        this.contAuditor.setBoundLabelText(resHelper.getString("contAuditor.boundLabelText"));		
        this.contAuditor.setBoundLabelLength(100);		
        this.contAuditor.setBoundLabelUnderline(true);
        // contmzNumber		
        this.contmzNumber.setBoundLabelText(resHelper.getString("contmzNumber.boundLabelText"));		
        this.contmzNumber.setBoundLabelLength(100);		
        this.contmzNumber.setBoundLabelUnderline(true);		
        this.contmzNumber.setVisible(true);
        // contmzName		
        this.contmzName.setBoundLabelText(resHelper.getString("contmzName.boundLabelText"));		
        this.contmzName.setBoundLabelLength(100);		
        this.contmzName.setBoundLabelUnderline(true);		
        this.contmzName.setVisible(true);
        // contempNumber		
        this.contempNumber.setBoundLabelText(resHelper.getString("contempNumber.boundLabelText"));		
        this.contempNumber.setBoundLabelLength(100);		
        this.contempNumber.setBoundLabelUnderline(true);		
        this.contempNumber.setVisible(true);
        // contempName		
        this.contempName.setBoundLabelText(resHelper.getString("contempName.boundLabelText"));		
        this.contempName.setBoundLabelLength(100);		
        this.contempName.setBoundLabelUnderline(true);		
        this.contempName.setVisible(true);
        // conthlAmount		
        this.conthlAmount.setBoundLabelText(resHelper.getString("conthlAmount.boundLabelText"));		
        this.conthlAmount.setBoundLabelLength(100);		
        this.conthlAmount.setBoundLabelUnderline(true);		
        this.conthlAmount.setVisible(true);
        // contklxsAmount		
        this.contklxsAmount.setBoundLabelText(resHelper.getString("contklxsAmount.boundLabelText"));		
        this.contklxsAmount.setBoundLabelLength(100);		
        this.contklxsAmount.setBoundLabelUnderline(true);		
        this.contklxsAmount.setVisible(true);
        // contmdzyAmount		
        this.contmdzyAmount.setBoundLabelText(resHelper.getString("contmdzyAmount.boundLabelText"));		
        this.contmdzyAmount.setBoundLabelLength(100);		
        this.contmdzyAmount.setBoundLabelUnderline(true);		
        this.contmdzyAmount.setVisible(true);
        // contkhAmount		
        this.contkhAmount.setBoundLabelText(resHelper.getString("contkhAmount.boundLabelText"));		
        this.contkhAmount.setBoundLabelLength(100);		
        this.contkhAmount.setBoundLabelUnderline(true);		
        this.contkhAmount.setVisible(true);
        // contbusinessDate		
        this.contbusinessDate.setBoundLabelText(resHelper.getString("contbusinessDate.boundLabelText"));		
        this.contbusinessDate.setBoundLabelLength(100);		
        this.contbusinessDate.setBoundLabelUnderline(true);		
        this.contbusinessDate.setVisible(true);
        // contimportDate		
        this.contimportDate.setBoundLabelText(resHelper.getString("contimportDate.boundLabelText"));		
        this.contimportDate.setBoundLabelLength(100);		
        this.contimportDate.setBoundLabelUnderline(true);		
        this.contimportDate.setVisible(true);
        // prmtCreator		
        this.prmtCreator.setEnabled(false);
        // kDDateCreateTime		
        this.kDDateCreateTime.setTimeEnabled(true);		
        this.kDDateCreateTime.setEnabled(false);
        // prmtLastUpdateUser		
        this.prmtLastUpdateUser.setEnabled(false);
        // kDDateLastUpdateTime		
        this.kDDateLastUpdateTime.setTimeEnabled(true);		
        this.kDDateLastUpdateTime.setEnabled(false);
        // txtNumber		
        this.txtNumber.setMaxLength(80);
        // pkBizDate		
        this.pkBizDate.setVisible(true);		
        this.pkBizDate.setEnabled(true);
        // txtDescription		
        this.txtDescription.setMaxLength(80);
        // prmtAuditor		
        this.prmtAuditor.setEnabled(false);
        // txtmzNumber		
        this.txtmzNumber.setVisible(true);		
        this.txtmzNumber.setHorizontalAlignment(2);		
        this.txtmzNumber.setMaxLength(100);		
        this.txtmzNumber.setRequired(false);
        // txtmzName		
        this.txtmzName.setVisible(true);		
        this.txtmzName.setHorizontalAlignment(2);		
        this.txtmzName.setMaxLength(100);		
        this.txtmzName.setRequired(false);
        // txtempNumber		
        this.txtempNumber.setVisible(true);		
        this.txtempNumber.setHorizontalAlignment(2);		
        this.txtempNumber.setMaxLength(100);		
        this.txtempNumber.setRequired(false);
        // txtempName		
        this.txtempName.setVisible(true);		
        this.txtempName.setHorizontalAlignment(2);		
        this.txtempName.setMaxLength(100);		
        this.txtempName.setRequired(false);
        // txthlAmount		
        this.txthlAmount.setVisible(true);		
        this.txthlAmount.setHorizontalAlignment(2);		
        this.txthlAmount.setDataType(1);		
        this.txthlAmount.setSupportedEmpty(true);		
        this.txthlAmount.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txthlAmount.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txthlAmount.setPrecision(2);		
        this.txthlAmount.setRequired(false);
        // txtklxsAmount		
        this.txtklxsAmount.setVisible(true);		
        this.txtklxsAmount.setHorizontalAlignment(2);		
        this.txtklxsAmount.setDataType(1);		
        this.txtklxsAmount.setSupportedEmpty(true);		
        this.txtklxsAmount.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtklxsAmount.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtklxsAmount.setPrecision(2);		
        this.txtklxsAmount.setRequired(false);
        // txtmdzyAmount		
        this.txtmdzyAmount.setVisible(true);		
        this.txtmdzyAmount.setHorizontalAlignment(2);		
        this.txtmdzyAmount.setDataType(1);		
        this.txtmdzyAmount.setSupportedEmpty(true);		
        this.txtmdzyAmount.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtmdzyAmount.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtmdzyAmount.setPrecision(2);		
        this.txtmdzyAmount.setRequired(false);
        // txtkhAmount		
        this.txtkhAmount.setVisible(true);		
        this.txtkhAmount.setHorizontalAlignment(2);		
        this.txtkhAmount.setDataType(1);		
        this.txtkhAmount.setSupportedEmpty(true);		
        this.txtkhAmount.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtkhAmount.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtkhAmount.setPrecision(2);		
        this.txtkhAmount.setRequired(false);
        // txtbusinessDate		
        this.txtbusinessDate.setVisible(true);		
        this.txtbusinessDate.setHorizontalAlignment(2);		
        this.txtbusinessDate.setMaxLength(100);		
        this.txtbusinessDate.setRequired(false);
        // pkimportDate		
        this.pkimportDate.setVisible(true);		
        this.pkimportDate.setRequired(false);
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {txtmzNumber,txtmzName,txtempNumber,txtempName,txthlAmount,txtklxsAmount,txtmdzyAmount,txtkhAmount,txtbusinessDate,pkimportDate}));
        this.setFocusCycleRoot(true);
		//Register control's property binding
		registerBindings();
		registerUIState();


    }

	public com.kingdee.bos.ctrl.swing.KDToolBar[] getUIMultiToolBar(){
		java.util.List list = new java.util.ArrayList();
		com.kingdee.bos.ctrl.swing.KDToolBar[] bars = super.getUIMultiToolBar();
		if (bars != null) {
			list.addAll(java.util.Arrays.asList(bars));
		}
		return (com.kingdee.bos.ctrl.swing.KDToolBar[])list.toArray(new com.kingdee.bos.ctrl.swing.KDToolBar[list.size()]);
	}




    /**
     * output initUIContentLayout method
     */
    public void initUIContentLayout()
    {
        this.setBounds(new Rectangle(0, 0, 1013, 173));
        this.setLayout(null);
        contCreator.setBounds(new Rectangle(341, 106, 270, 19));
        this.add(contCreator, null);
        contCreateTime.setBounds(new Rectangle(672, 106, 270, 19));
        this.add(contCreateTime, null);
        contLastUpdateUser.setBounds(new Rectangle(10, 130, 270, 19));
        this.add(contLastUpdateUser, null);
        contLastUpdateTime.setBounds(new Rectangle(341, 130, 270, 19));
        this.add(contLastUpdateTime, null);
        contNumber.setBounds(new Rectangle(10, 82, 270, 19));
        this.add(contNumber, null);
        contBizDate.setBounds(new Rectangle(341, 82, 270, 19));
        this.add(contBizDate, null);
        contDescription.setBounds(new Rectangle(672, 82, 270, 19));
        this.add(contDescription, null);
        contAuditor.setBounds(new Rectangle(10, 106, 270, 19));
        this.add(contAuditor, null);
        contmzNumber.setBounds(new Rectangle(10, 10, 270, 19));
        this.add(contmzNumber, null);
        contmzName.setBounds(new Rectangle(341, 10, 270, 19));
        this.add(contmzName, null);
        contempNumber.setBounds(new Rectangle(672, 10, 270, 19));
        this.add(contempNumber, null);
        contempName.setBounds(new Rectangle(10, 34, 270, 19));
        this.add(contempName, null);
        conthlAmount.setBounds(new Rectangle(341, 34, 270, 19));
        this.add(conthlAmount, null);
        contklxsAmount.setBounds(new Rectangle(672, 34, 270, 19));
        this.add(contklxsAmount, null);
        contmdzyAmount.setBounds(new Rectangle(10, 58, 270, 19));
        this.add(contmdzyAmount, null);
        contkhAmount.setBounds(new Rectangle(341, 58, 270, 19));
        this.add(contkhAmount, null);
        contbusinessDate.setBounds(new Rectangle(672, 58, 270, 19));
        this.add(contbusinessDate, null);
        contimportDate.setBounds(new Rectangle(672, 132, 270, 19));
        this.add(contimportDate, null);
        //contCreator
        contCreator.setBoundEditor(prmtCreator);
        //contCreateTime
        contCreateTime.setBoundEditor(kDDateCreateTime);
        //contLastUpdateUser
        contLastUpdateUser.setBoundEditor(prmtLastUpdateUser);
        //contLastUpdateTime
        contLastUpdateTime.setBoundEditor(kDDateLastUpdateTime);
        //contNumber
        contNumber.setBoundEditor(txtNumber);
        //contBizDate
        contBizDate.setBoundEditor(pkBizDate);
        //contDescription
        contDescription.setBoundEditor(txtDescription);
        //contAuditor
        contAuditor.setBoundEditor(prmtAuditor);
        //contmzNumber
        contmzNumber.setBoundEditor(txtmzNumber);
        //contmzName
        contmzName.setBoundEditor(txtmzName);
        //contempNumber
        contempNumber.setBoundEditor(txtempNumber);
        //contempName
        contempName.setBoundEditor(txtempName);
        //conthlAmount
        conthlAmount.setBoundEditor(txthlAmount);
        //contklxsAmount
        contklxsAmount.setBoundEditor(txtklxsAmount);
        //contmdzyAmount
        contmdzyAmount.setBoundEditor(txtmdzyAmount);
        //contkhAmount
        contkhAmount.setBoundEditor(txtkhAmount);
        //contbusinessDate
        contbusinessDate.setBoundEditor(txtbusinessDate);
        //contimportDate
        contimportDate.setBoundEditor(pkimportDate);

    }


    /**
     * output initUIMenuBarLayout method
     */
    public void initUIMenuBarLayout()
    {
        this.menuBar.add(menuFile);
        this.menuBar.add(menuEdit);
        this.menuBar.add(MenuService);
        this.menuBar.add(menuView);
        this.menuBar.add(menuBiz);
        this.menuBar.add(menuTable1);
        this.menuBar.add(menuTool);
        this.menuBar.add(menuWorkflow);
        this.menuBar.add(menuHelp);
        //menuFile
        menuFile.add(menuItemAddNew);
        menuFile.add(kDSeparator1);
        menuFile.add(menuItemCloudFeed);
        menuFile.add(menuItemSave);
        menuFile.add(menuItemCloudScreen);
        menuFile.add(menuItemSubmit);
        menuFile.add(menuItemCloudShare);
        menuFile.add(menuSubmitOption);
        menuFile.add(kdSeparatorFWFile1);
        menuFile.add(rMenuItemSubmit);
        menuFile.add(rMenuItemSubmitAndAddNew);
        menuFile.add(rMenuItemSubmitAndPrint);
        menuFile.add(separatorFile1);
        menuFile.add(MenuItemAttachment);
        menuFile.add(kDSeparator2);
        menuFile.add(menuItemPageSetup);
        menuFile.add(menuItemPrint);
        menuFile.add(menuItemPrintPreview);
        menuFile.add(kDSeparator6);
        menuFile.add(menuItemSendMail);
        menuFile.add(kDSeparator3);
        menuFile.add(menuItemExitCurrent);
        //menuSubmitOption
        menuSubmitOption.add(chkMenuItemSubmitAndAddNew);
        menuSubmitOption.add(chkMenuItemSubmitAndPrint);
        //menuEdit
        menuEdit.add(menuItemCopy);
        menuEdit.add(menuItemEdit);
        menuEdit.add(menuItemRemove);
        menuEdit.add(kDSeparator4);
        menuEdit.add(menuItemReset);
        menuEdit.add(separator1);
        menuEdit.add(menuItemCreateFrom);
        menuEdit.add(menuItemCreateTo);
        menuEdit.add(menuItemCopyFrom);
        menuEdit.add(separatorEdit1);
        menuEdit.add(menuItemEnterToNextRow);
        menuEdit.add(separator2);
        //MenuService
        MenuService.add(MenuItemKnowStore);
        MenuService.add(MenuItemAnwser);
        MenuService.add(SepratorService);
        MenuService.add(MenuItemRemoteAssist);
        //menuView
        menuView.add(menuItemFirst);
        menuView.add(menuItemPre);
        menuView.add(menuItemNext);
        menuView.add(menuItemLast);
        menuView.add(separator3);
        menuView.add(menuItemTraceUp);
        menuView.add(menuItemTraceDown);
        menuView.add(kDSeparator7);
        menuView.add(menuItemLocate);
        //menuBiz
        menuBiz.add(menuItemCancelCancel);
        menuBiz.add(menuItemCancel);
        menuBiz.add(MenuItemVoucher);
        menuBiz.add(menuItemDelVoucher);
        menuBiz.add(MenuItemPCVoucher);
        menuBiz.add(menuItemDelPCVoucher);
        //menuTable1
        menuTable1.add(menuItemAddLine);
        menuTable1.add(menuItemCopyLine);
        menuTable1.add(menuItemInsertLine);
        menuTable1.add(menuItemRemoveLine);
        //menuTool
        menuTool.add(menuItemSendMessage);
        menuTool.add(menuItemMsgFormat);
        menuTool.add(menuItemCalculator);
        menuTool.add(menuItemToolBarCustom);
        //menuWorkflow
        menuWorkflow.add(menuItemStartWorkFlow);
        menuWorkflow.add(separatorWF1);
        menuWorkflow.add(menuItemViewSubmitProccess);
        menuWorkflow.add(menuItemViewDoProccess);
        menuWorkflow.add(MenuItemWFG);
        menuWorkflow.add(menuItemWorkFlowList);
        menuWorkflow.add(separatorWF2);
        menuWorkflow.add(menuItemMultiapprove);
        menuWorkflow.add(menuItemNextPerson);
        menuWorkflow.add(menuItemAuditResult);
        menuWorkflow.add(kDSeparator5);
        menuWorkflow.add(kDMenuItemSendMessage);
        //menuHelp
        menuHelp.add(menuItemHelp);
        menuHelp.add(kDSeparator12);
        menuHelp.add(menuItemRegPro);
        menuHelp.add(menuItemPersonalSite);
        menuHelp.add(helpseparatorDiv);
        menuHelp.add(menuitemProductval);
        menuHelp.add(kDSeparatorProduct);
        menuHelp.add(menuItemAbout);

    }

    /**
     * output initUIToolBarLayout method
     */
    public void initUIToolBarLayout()
    {
        this.toolBar.add(btnAddNew);
        this.toolBar.add(btnCloud);
        this.toolBar.add(btnEdit);
        this.toolBar.add(btnXunTong);
        this.toolBar.add(btnSave);
        this.toolBar.add(kDSeparatorCloud);
        this.toolBar.add(btnReset);
        this.toolBar.add(btnSubmit);
        this.toolBar.add(btnCopy);
        this.toolBar.add(btnRemove);
        this.toolBar.add(btnCancelCancel);
        this.toolBar.add(btnCancel);
        this.toolBar.add(btnAttachment);
        this.toolBar.add(separatorFW1);
        this.toolBar.add(btnPageSetup);
        this.toolBar.add(btnPrint);
        this.toolBar.add(btnPrintPreview);
        this.toolBar.add(separatorFW2);
        this.toolBar.add(btnFirst);
        this.toolBar.add(btnPre);
        this.toolBar.add(btnNext);
        this.toolBar.add(btnLast);
        this.toolBar.add(separatorFW3);
        this.toolBar.add(btnTraceUp);
        this.toolBar.add(btnTraceDown);
        this.toolBar.add(btnWorkFlowG);
        this.toolBar.add(btnSignature);
        this.toolBar.add(btnViewSignature);
        this.toolBar.add(separatorFW4);
        this.toolBar.add(btnNumberSign);
        this.toolBar.add(separatorFW7);
        this.toolBar.add(btnCreateFrom);
        this.toolBar.add(btnCopyFrom);
        this.toolBar.add(btnCreateTo);
        this.toolBar.add(separatorFW5);
        this.toolBar.add(separatorFW8);
        this.toolBar.add(btnAddLine);
        this.toolBar.add(btnCopyLine);
        this.toolBar.add(btnInsertLine);
        this.toolBar.add(btnRemoveLine);
        this.toolBar.add(separatorFW6);
        this.toolBar.add(separatorFW9);
        this.toolBar.add(btnVoucher);
        this.toolBar.add(btnDelVoucher);
        this.toolBar.add(btnPCVoucher);
        this.toolBar.add(btnDelPCVoucher);
        this.toolBar.add(btnAuditResult);
        this.toolBar.add(btnMultiapprove);
        this.toolBar.add(btnWFViewdoProccess);
        this.toolBar.add(btnWFViewSubmitProccess);
        this.toolBar.add(btnNextPerson);


    }

	//Regiester control's property binding.
	private void registerBindings(){
		dataBinder.registerBinding("creator", com.kingdee.eas.base.permission.UserInfo.class, this.prmtCreator, "data");
		dataBinder.registerBinding("createTime", java.sql.Timestamp.class, this.kDDateCreateTime, "value");
		dataBinder.registerBinding("lastUpdateUser", com.kingdee.eas.base.permission.UserInfo.class, this.prmtLastUpdateUser, "data");
		dataBinder.registerBinding("lastUpdateTime", java.sql.Timestamp.class, this.kDDateLastUpdateTime, "value");
		dataBinder.registerBinding("number", String.class, this.txtNumber, "text");
		dataBinder.registerBinding("bizDate", java.util.Date.class, this.pkBizDate, "value");
		dataBinder.registerBinding("description", String.class, this.txtDescription, "text");
		dataBinder.registerBinding("auditor", com.kingdee.eas.base.permission.UserInfo.class, this.prmtAuditor, "data");
		dataBinder.registerBinding("mzNumber", String.class, this.txtmzNumber, "text");
		dataBinder.registerBinding("mzName", String.class, this.txtmzName, "text");
		dataBinder.registerBinding("empNumber", String.class, this.txtempNumber, "text");
		dataBinder.registerBinding("empName", String.class, this.txtempName, "text");
		dataBinder.registerBinding("hlAmount", java.math.BigDecimal.class, this.txthlAmount, "value");
		dataBinder.registerBinding("klxsAmount", java.math.BigDecimal.class, this.txtklxsAmount, "value");
		dataBinder.registerBinding("mdzyAmount", java.math.BigDecimal.class, this.txtmdzyAmount, "value");
		dataBinder.registerBinding("khAmount", java.math.BigDecimal.class, this.txtkhAmount, "value");
		dataBinder.registerBinding("businessDate", String.class, this.txtbusinessDate, "text");
		dataBinder.registerBinding("importDate", java.util.Date.class, this.pkimportDate, "value");		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.mw.pay.app.ServiceAmountEditUIHandler";
	}
	public IUIActionPostman prepareInit() {
		IUIActionPostman clientHanlder = super.prepareInit();
		if (clientHanlder != null) {
			RequestContext request = new RequestContext();
    		request.setClassName(getUIHandlerClassName());
			clientHanlder.setRequestContext(request);
		}
		return clientHanlder;
    }
	
	public boolean isPrepareInit() {
    	return false;
    }
    protected void initUIP() {
        super.initUIP();
    }


    /**
     * output onShow method
     */
    public void onShow() throws Exception
    {
        super.onShow();
        this.txtmzNumber.requestFocusInWindow();
    }

	
	

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject)
    {
        IObjectValue ov = dataObject;        	    	
        super.setDataObject(ov);
        this.editData = (com.kingdee.eas.mw.pay.ServiceAmountInfo)ov;
    }
    protected void removeByPK(IObjectPK pk) throws Exception {
    	IObjectValue editData = this.editData;
    	super.removeByPK(pk);
    	recycleNumberByOrg(editData,"NONE",editData.getString("number"));
    }
    
    protected void recycleNumberByOrg(IObjectValue editData,String orgType,String number) {
        if (!StringUtils.isEmpty(number))
        {
            try {
            	String companyID = null;            
            	com.kingdee.eas.base.codingrule.ICodingRuleManager iCodingRuleManager = com.kingdee.eas.base.codingrule.CodingRuleManagerFactory.getRemoteInstance();
				if(!com.kingdee.util.StringUtils.isEmpty(orgType) && !"NONE".equalsIgnoreCase(orgType) && com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit(com.kingdee.eas.basedata.org.OrgType.getEnum(orgType))!=null) {
					companyID =com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit(com.kingdee.eas.basedata.org.OrgType.getEnum(orgType)).getString("id");
				}
				else if (com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit() != null) {
					companyID = ((com.kingdee.eas.basedata.org.OrgUnitInfo)com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit()).getString("id");
            	}				
				if (!StringUtils.isEmpty(companyID) && iCodingRuleManager.isExist(editData, companyID) && iCodingRuleManager.isUseIntermitNumber(editData, companyID)) {
					iCodingRuleManager.recycleNumber(editData,companyID,number);					
				}
            }
            catch (Exception e)
            {
                handUIException(e);
            }
        }
    }
    protected void setAutoNumberByOrg(String orgType) {
    	if (editData == null) return;
		if (editData.getNumber() == null) {
            try {
            	String companyID = null;
				if(!com.kingdee.util.StringUtils.isEmpty(orgType) && !"NONE".equalsIgnoreCase(orgType) && com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit(com.kingdee.eas.basedata.org.OrgType.getEnum(orgType))!=null) {
					companyID = com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit(com.kingdee.eas.basedata.org.OrgType.getEnum(orgType)).getString("id");
				}
				else if (com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit() != null) {
					companyID = ((com.kingdee.eas.basedata.org.OrgUnitInfo)com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit()).getString("id");
            	}
				com.kingdee.eas.base.codingrule.ICodingRuleManager iCodingRuleManager = com.kingdee.eas.base.codingrule.CodingRuleManagerFactory.getRemoteInstance();
		        if (iCodingRuleManager.isExist(editData, companyID)) {
		            if (iCodingRuleManager.isAddView(editData, companyID)) {
		            	editData.setNumber(iCodingRuleManager.getNumber(editData,companyID));
		            }
	                txtNumber.setEnabled(false);
		        }
            }
            catch (Exception e) {
                handUIException(e);
                this.oldData = editData;
                com.kingdee.eas.util.SysUtil.abort();
            } 
        } 
        else {
            if (editData.getNumber().trim().length() > 0) {
                txtNumber.setText(editData.getNumber());
            }
        }
    }

    /**
     * output loadFields method
     */
    public void loadFields()
    {
        		setAutoNumberByOrg("NONE");
        dataBinder.loadFields();
    }
		protected void setOrgF7(KDBizPromptBox f7,com.kingdee.eas.basedata.org.OrgType orgType) throws Exception
		{
			com.kingdee.eas.basedata.org.client.f7.NewOrgUnitFilterInfoProducer oufip = new com.kingdee.eas.basedata.org.client.f7.NewOrgUnitFilterInfoProducer(orgType);
			oufip.getModel().setIsCUFilter(true);
			f7.setFilterInfoProducer(oufip);
		}

    /**
     * output storeFields method
     */
    public void storeFields()
    {
		dataBinder.storeFields();
    }

	/**
	 * ????????????
	 */
	protected void registerValidator() {
    	getValidateHelper().setCustomValidator( getValidator() );
		getValidateHelper().registerBindProperty("creator", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("createTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lastUpdateUser", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lastUpdateTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("number", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("bizDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("description", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditor", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("mzNumber", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("mzName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("empNumber", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("empName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("hlAmount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("klxsAmount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("mdzyAmount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("khAmount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("businessDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("importDate", ValidateHelper.ON_SAVE);    		
	}



    /**
     * output setOprtState method
     */
    public void setOprtState(String oprtType)
    {
        super.setOprtState(oprtType);
        if (STATUS_ADDNEW.equals(this.oprtState)) {
        } else if (STATUS_EDIT.equals(this.oprtState)) {
        } else if (STATUS_VIEW.equals(this.oprtState)) {
        } else if (STATUS_FINDVIEW.equals(this.oprtState)) {
        }
    }

    /**
     * output getSelectors method
     */
    public SelectorItemCollection getSelectors()
    {
        SelectorItemCollection sic = new SelectorItemCollection();
		String selectorAll = System.getProperty("selector.all");
		if(StringUtils.isEmpty(selectorAll)){
			selectorAll = "true";
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("creator.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("creator.id"));
        	sic.add(new SelectorItemInfo("creator.number"));
        	sic.add(new SelectorItemInfo("creator.name"));
		}
        sic.add(new SelectorItemInfo("createTime"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("lastUpdateUser.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("lastUpdateUser.id"));
        	sic.add(new SelectorItemInfo("lastUpdateUser.number"));
        	sic.add(new SelectorItemInfo("lastUpdateUser.name"));
		}
        sic.add(new SelectorItemInfo("lastUpdateTime"));
        sic.add(new SelectorItemInfo("number"));
        sic.add(new SelectorItemInfo("bizDate"));
        sic.add(new SelectorItemInfo("description"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("auditor.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("auditor.id"));
        	sic.add(new SelectorItemInfo("auditor.number"));
        	sic.add(new SelectorItemInfo("auditor.name"));
		}
        sic.add(new SelectorItemInfo("mzNumber"));
        sic.add(new SelectorItemInfo("mzName"));
        sic.add(new SelectorItemInfo("empNumber"));
        sic.add(new SelectorItemInfo("empName"));
        sic.add(new SelectorItemInfo("hlAmount"));
        sic.add(new SelectorItemInfo("klxsAmount"));
        sic.add(new SelectorItemInfo("mdzyAmount"));
        sic.add(new SelectorItemInfo("khAmount"));
        sic.add(new SelectorItemInfo("businessDate"));
        sic.add(new SelectorItemInfo("importDate"));
        return sic;
    }        
    	

    /**
     * output actionSubmit_actionPerformed method
     */
    public void actionSubmit_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionSubmit_actionPerformed(e);
    }
    	

    /**
     * output actionPrint_actionPerformed method
     */
    public void actionPrint_actionPerformed(ActionEvent e) throws Exception
    {
        ArrayList idList = new ArrayList();
    	if (editData != null && !StringUtils.isEmpty(editData.getString("id"))) {
    		idList.add(editData.getString("id"));
    	}
        if (idList == null || idList.size() == 0 || getTDQueryPK() == null || getTDFileName() == null)
            return;
        com.kingdee.bos.ctrl.kdf.data.impl.BOSQueryDelegate data = new com.kingdee.eas.framework.util.CommonDataProvider(idList,getTDQueryPK());
        com.kingdee.bos.ctrl.report.forapp.kdnote.client.KDNoteHelper appHlp = new com.kingdee.bos.ctrl.report.forapp.kdnote.client.KDNoteHelper();
        appHlp.print(getTDFileName(), data, javax.swing.SwingUtilities.getWindowAncestor(this));
    }
    	

    /**
     * output actionPrintPreview_actionPerformed method
     */
    public void actionPrintPreview_actionPerformed(ActionEvent e) throws Exception
    {
        ArrayList idList = new ArrayList();
        if (editData != null && !StringUtils.isEmpty(editData.getString("id"))) {
    		idList.add(editData.getString("id"));
    	}
        if (idList == null || idList.size() == 0 || getTDQueryPK() == null || getTDFileName() == null)
            return;
        com.kingdee.bos.ctrl.kdf.data.impl.BOSQueryDelegate data = new com.kingdee.eas.framework.util.CommonDataProvider(idList,getTDQueryPK());
        com.kingdee.bos.ctrl.report.forapp.kdnote.client.KDNoteHelper appHlp = new com.kingdee.bos.ctrl.report.forapp.kdnote.client.KDNoteHelper();
        appHlp.printPreview(getTDFileName(), data, javax.swing.SwingUtilities.getWindowAncestor(this));
    }
	public RequestContext prepareActionSubmit(IItemAction itemAction) throws Exception {
			RequestContext request = super.prepareActionSubmit(itemAction);		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionSubmit() {
    	return false;
    }
	public RequestContext prepareActionPrint(IItemAction itemAction) throws Exception {
			RequestContext request = super.prepareActionPrint(itemAction);		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionPrint() {
    	return false;
    }
	public RequestContext prepareActionPrintPreview(IItemAction itemAction) throws Exception {
			RequestContext request = super.prepareActionPrintPreview(itemAction);		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionPrintPreview() {
    	return false;
    }

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.mw.pay.client", "ServiceAmountEditUI");
    }
    /**
     * output isBindWorkFlow method
     */
    public boolean isBindWorkFlow()
    {
        return true;
    }

    /**
     * output getEditUIName method
     */
    protected String getEditUIName()
    {
        return com.kingdee.eas.mw.pay.client.ServiceAmountEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.mw.pay.ServiceAmountFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.mw.pay.ServiceAmountInfo objectValue = new com.kingdee.eas.mw.pay.ServiceAmountInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


    	protected String getTDFileName() {
    	return "/bim/mw/pay/ServiceAmount";
	}
    protected IMetaDataPK getTDQueryPK() {
    	return new MetaDataPK("com.kingdee.eas.mw.pay.app.ServiceAmountQuery");
	}
    

    /**
     * output getDetailTable method
     */
    protected KDTable getDetailTable() {        
        return null;
	}
    /**
     * output applyDefaultValue method
     */
    protected void applyDefaultValue(IObjectValue vo) {        
    }        
	protected void setFieldsNull(com.kingdee.bos.dao.AbstractObjectValue arg0) {
		super.setFieldsNull(arg0);
		arg0.put("number",null);
	}

}