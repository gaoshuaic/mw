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
public abstract class AbstractDoctorPerformanceEditUI extends com.kingdee.eas.framework.client.CoreBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractDoctorPerformanceEditUI.class);
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
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contzzProportion;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contperformanceBase;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contzzBase;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contgdProportion;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contgdBase;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contyxProportion;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contyxBase;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contxfProportion;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contxfBase;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conteyProportion;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conteyBase;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contknProportion;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contknBase;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contmbProportion;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contmbBase;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contzbProportion;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contzbBase;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contqtProportion;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contqtBase;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contimportDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbusinessDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcityName;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcityNumber;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcity;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contzjBiLi;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contdocKeepType;
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
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtzzProportion;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtperformanceBase;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtzzBase;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtgdProportion;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtgdBase;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtyxProportion;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtyxBase;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtxfProportion;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtxfBase;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txteyProportion;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txteyBase;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtknProportion;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtknBase;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtmbProportion;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtmbBase;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtzbProportion;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtzbBase;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtqtProportion;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtqtBase;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkimportDate;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtbusinessDate;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtcityName;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtcityNumber;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcity;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtzjBiLi;
    protected com.kingdee.bos.ctrl.swing.KDComboBox docKeepType;
    protected com.kingdee.eas.mw.pay.DoctorPerformanceInfo editData = null;
    /**
     * output class constructor
     */
    public AbstractDoctorPerformanceEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractDoctorPerformanceEditUI.class.getName());
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
        this.contzzProportion = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contperformanceBase = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contzzBase = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contgdProportion = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contgdBase = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contyxProportion = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contyxBase = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contxfProportion = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contxfBase = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conteyProportion = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conteyBase = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contknProportion = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contknBase = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contmbProportion = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contmbBase = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contzbProportion = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contzbBase = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contqtProportion = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contqtBase = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contimportDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbusinessDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcityName = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcityNumber = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcity = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contzjBiLi = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contdocKeepType = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
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
        this.txtzzProportion = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtperformanceBase = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtzzBase = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtgdProportion = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtgdBase = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtyxProportion = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtyxBase = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtxfProportion = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtxfBase = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txteyProportion = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txteyBase = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtknProportion = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtknBase = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtmbProportion = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtmbBase = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtzbProportion = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtzbBase = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtqtProportion = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtqtBase = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.pkimportDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtbusinessDate = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtcityName = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtcityNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtcity = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtzjBiLi = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.docKeepType = new com.kingdee.bos.ctrl.swing.KDComboBox();
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
        this.contzzProportion.setName("contzzProportion");
        this.contperformanceBase.setName("contperformanceBase");
        this.contzzBase.setName("contzzBase");
        this.contgdProportion.setName("contgdProportion");
        this.contgdBase.setName("contgdBase");
        this.contyxProportion.setName("contyxProportion");
        this.contyxBase.setName("contyxBase");
        this.contxfProportion.setName("contxfProportion");
        this.contxfBase.setName("contxfBase");
        this.conteyProportion.setName("conteyProportion");
        this.conteyBase.setName("conteyBase");
        this.contknProportion.setName("contknProportion");
        this.contknBase.setName("contknBase");
        this.contmbProportion.setName("contmbProportion");
        this.contmbBase.setName("contmbBase");
        this.contzbProportion.setName("contzbProportion");
        this.contzbBase.setName("contzbBase");
        this.contqtProportion.setName("contqtProportion");
        this.contqtBase.setName("contqtBase");
        this.contimportDate.setName("contimportDate");
        this.contbusinessDate.setName("contbusinessDate");
        this.contcityName.setName("contcityName");
        this.contcityNumber.setName("contcityNumber");
        this.contcity.setName("contcity");
        this.contzjBiLi.setName("contzjBiLi");
        this.contdocKeepType.setName("contdocKeepType");
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
        this.txtzzProportion.setName("txtzzProportion");
        this.txtperformanceBase.setName("txtperformanceBase");
        this.txtzzBase.setName("txtzzBase");
        this.txtgdProportion.setName("txtgdProportion");
        this.txtgdBase.setName("txtgdBase");
        this.txtyxProportion.setName("txtyxProportion");
        this.txtyxBase.setName("txtyxBase");
        this.txtxfProportion.setName("txtxfProportion");
        this.txtxfBase.setName("txtxfBase");
        this.txteyProportion.setName("txteyProportion");
        this.txteyBase.setName("txteyBase");
        this.txtknProportion.setName("txtknProportion");
        this.txtknBase.setName("txtknBase");
        this.txtmbProportion.setName("txtmbProportion");
        this.txtmbBase.setName("txtmbBase");
        this.txtzbProportion.setName("txtzbProportion");
        this.txtzbBase.setName("txtzbBase");
        this.txtqtProportion.setName("txtqtProportion");
        this.txtqtBase.setName("txtqtBase");
        this.pkimportDate.setName("pkimportDate");
        this.txtbusinessDate.setName("txtbusinessDate");
        this.txtcityName.setName("txtcityName");
        this.txtcityNumber.setName("txtcityNumber");
        this.prmtcity.setName("prmtcity");
        this.txtzjBiLi.setName("txtzjBiLi");
        this.docKeepType.setName("docKeepType");
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
        // contzzProportion		
        this.contzzProportion.setBoundLabelText(resHelper.getString("contzzProportion.boundLabelText"));		
        this.contzzProportion.setBoundLabelLength(100);		
        this.contzzProportion.setBoundLabelUnderline(true);		
        this.contzzProportion.setVisible(true);
        // contperformanceBase		
        this.contperformanceBase.setBoundLabelText(resHelper.getString("contperformanceBase.boundLabelText"));		
        this.contperformanceBase.setBoundLabelLength(100);		
        this.contperformanceBase.setBoundLabelUnderline(true);		
        this.contperformanceBase.setVisible(true);
        // contzzBase		
        this.contzzBase.setBoundLabelText(resHelper.getString("contzzBase.boundLabelText"));		
        this.contzzBase.setBoundLabelLength(100);		
        this.contzzBase.setBoundLabelUnderline(true);		
        this.contzzBase.setVisible(true);
        // contgdProportion		
        this.contgdProportion.setBoundLabelText(resHelper.getString("contgdProportion.boundLabelText"));		
        this.contgdProportion.setBoundLabelLength(100);		
        this.contgdProportion.setBoundLabelUnderline(true);		
        this.contgdProportion.setVisible(true);
        // contgdBase		
        this.contgdBase.setBoundLabelText(resHelper.getString("contgdBase.boundLabelText"));		
        this.contgdBase.setBoundLabelLength(100);		
        this.contgdBase.setBoundLabelUnderline(true);		
        this.contgdBase.setVisible(true);
        // contyxProportion		
        this.contyxProportion.setBoundLabelText(resHelper.getString("contyxProportion.boundLabelText"));		
        this.contyxProportion.setBoundLabelLength(100);		
        this.contyxProportion.setBoundLabelUnderline(true);		
        this.contyxProportion.setVisible(true);
        // contyxBase		
        this.contyxBase.setBoundLabelText(resHelper.getString("contyxBase.boundLabelText"));		
        this.contyxBase.setBoundLabelLength(100);		
        this.contyxBase.setBoundLabelUnderline(true);		
        this.contyxBase.setVisible(true);
        // contxfProportion		
        this.contxfProportion.setBoundLabelText(resHelper.getString("contxfProportion.boundLabelText"));		
        this.contxfProportion.setBoundLabelLength(100);		
        this.contxfProportion.setBoundLabelUnderline(true);		
        this.contxfProportion.setVisible(true);
        // contxfBase		
        this.contxfBase.setBoundLabelText(resHelper.getString("contxfBase.boundLabelText"));		
        this.contxfBase.setBoundLabelLength(100);		
        this.contxfBase.setBoundLabelUnderline(true);		
        this.contxfBase.setVisible(true);
        // conteyProportion		
        this.conteyProportion.setBoundLabelText(resHelper.getString("conteyProportion.boundLabelText"));		
        this.conteyProportion.setBoundLabelLength(100);		
        this.conteyProportion.setBoundLabelUnderline(true);		
        this.conteyProportion.setVisible(true);
        // conteyBase		
        this.conteyBase.setBoundLabelText(resHelper.getString("conteyBase.boundLabelText"));		
        this.conteyBase.setBoundLabelLength(100);		
        this.conteyBase.setBoundLabelUnderline(true);		
        this.conteyBase.setVisible(true);
        // contknProportion		
        this.contknProportion.setBoundLabelText(resHelper.getString("contknProportion.boundLabelText"));		
        this.contknProportion.setBoundLabelLength(100);		
        this.contknProportion.setBoundLabelUnderline(true);		
        this.contknProportion.setVisible(true);
        // contknBase		
        this.contknBase.setBoundLabelText(resHelper.getString("contknBase.boundLabelText"));		
        this.contknBase.setBoundLabelLength(100);		
        this.contknBase.setBoundLabelUnderline(true);		
        this.contknBase.setVisible(true);
        // contmbProportion		
        this.contmbProportion.setBoundLabelText(resHelper.getString("contmbProportion.boundLabelText"));		
        this.contmbProportion.setBoundLabelLength(100);		
        this.contmbProportion.setBoundLabelUnderline(true);		
        this.contmbProportion.setVisible(true);
        // contmbBase		
        this.contmbBase.setBoundLabelText(resHelper.getString("contmbBase.boundLabelText"));		
        this.contmbBase.setBoundLabelLength(100);		
        this.contmbBase.setBoundLabelUnderline(true);		
        this.contmbBase.setVisible(true);
        // contzbProportion		
        this.contzbProportion.setBoundLabelText(resHelper.getString("contzbProportion.boundLabelText"));		
        this.contzbProportion.setBoundLabelLength(100);		
        this.contzbProportion.setBoundLabelUnderline(true);		
        this.contzbProportion.setVisible(true);
        // contzbBase		
        this.contzbBase.setBoundLabelText(resHelper.getString("contzbBase.boundLabelText"));		
        this.contzbBase.setBoundLabelLength(100);		
        this.contzbBase.setBoundLabelUnderline(true);		
        this.contzbBase.setVisible(true);
        // contqtProportion		
        this.contqtProportion.setBoundLabelText(resHelper.getString("contqtProportion.boundLabelText"));		
        this.contqtProportion.setBoundLabelLength(100);		
        this.contqtProportion.setBoundLabelUnderline(true);		
        this.contqtProportion.setVisible(true);
        // contqtBase		
        this.contqtBase.setBoundLabelText(resHelper.getString("contqtBase.boundLabelText"));		
        this.contqtBase.setBoundLabelLength(100);		
        this.contqtBase.setBoundLabelUnderline(true);		
        this.contqtBase.setVisible(true);
        // contimportDate		
        this.contimportDate.setBoundLabelText(resHelper.getString("contimportDate.boundLabelText"));		
        this.contimportDate.setBoundLabelLength(100);		
        this.contimportDate.setBoundLabelUnderline(true);		
        this.contimportDate.setVisible(true);
        // contbusinessDate		
        this.contbusinessDate.setBoundLabelText(resHelper.getString("contbusinessDate.boundLabelText"));		
        this.contbusinessDate.setBoundLabelLength(100);		
        this.contbusinessDate.setBoundLabelUnderline(true);		
        this.contbusinessDate.setVisible(true);
        // contcityName		
        this.contcityName.setBoundLabelText(resHelper.getString("contcityName.boundLabelText"));		
        this.contcityName.setBoundLabelLength(100);		
        this.contcityName.setBoundLabelUnderline(true);		
        this.contcityName.setVisible(true);
        // contcityNumber		
        this.contcityNumber.setBoundLabelText(resHelper.getString("contcityNumber.boundLabelText"));		
        this.contcityNumber.setBoundLabelLength(100);		
        this.contcityNumber.setBoundLabelUnderline(true);		
        this.contcityNumber.setVisible(true);
        // contcity		
        this.contcity.setBoundLabelText(resHelper.getString("contcity.boundLabelText"));		
        this.contcity.setBoundLabelLength(100);		
        this.contcity.setBoundLabelUnderline(true);		
        this.contcity.setVisible(true);
        // contzjBiLi		
        this.contzjBiLi.setBoundLabelText(resHelper.getString("contzjBiLi.boundLabelText"));		
        this.contzjBiLi.setBoundLabelLength(100);		
        this.contzjBiLi.setBoundLabelUnderline(true);		
        this.contzjBiLi.setVisible(true);
        // contdocKeepType		
        this.contdocKeepType.setBoundLabelText(resHelper.getString("contdocKeepType.boundLabelText"));		
        this.contdocKeepType.setBoundLabelLength(100);		
        this.contdocKeepType.setBoundLabelUnderline(true);		
        this.contdocKeepType.setVisible(true);
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
        // txtzzProportion		
        this.txtzzProportion.setVisible(true);		
        this.txtzzProportion.setHorizontalAlignment(2);		
        this.txtzzProportion.setDataType(1);		
        this.txtzzProportion.setSupportedEmpty(true);		
        this.txtzzProportion.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtzzProportion.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtzzProportion.setPrecision(10);		
        this.txtzzProportion.setRequired(false);
        // txtperformanceBase		
        this.txtperformanceBase.setVisible(true);		
        this.txtperformanceBase.setHorizontalAlignment(2);		
        this.txtperformanceBase.setDataType(1);		
        this.txtperformanceBase.setSupportedEmpty(true);		
        this.txtperformanceBase.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtperformanceBase.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtperformanceBase.setPrecision(10);		
        this.txtperformanceBase.setRequired(false);
        // txtzzBase		
        this.txtzzBase.setVisible(true);		
        this.txtzzBase.setHorizontalAlignment(2);		
        this.txtzzBase.setDataType(1);		
        this.txtzzBase.setSupportedEmpty(true);		
        this.txtzzBase.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtzzBase.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtzzBase.setPrecision(10);		
        this.txtzzBase.setRequired(false);
        // txtgdProportion		
        this.txtgdProportion.setVisible(true);		
        this.txtgdProportion.setHorizontalAlignment(2);		
        this.txtgdProportion.setDataType(1);		
        this.txtgdProportion.setSupportedEmpty(true);		
        this.txtgdProportion.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtgdProportion.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtgdProportion.setPrecision(10);		
        this.txtgdProportion.setRequired(false);
        // txtgdBase		
        this.txtgdBase.setVisible(true);		
        this.txtgdBase.setHorizontalAlignment(2);		
        this.txtgdBase.setDataType(1);		
        this.txtgdBase.setSupportedEmpty(true);		
        this.txtgdBase.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtgdBase.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtgdBase.setPrecision(10);		
        this.txtgdBase.setRequired(false);
        // txtyxProportion		
        this.txtyxProportion.setVisible(true);		
        this.txtyxProportion.setHorizontalAlignment(2);		
        this.txtyxProportion.setDataType(1);		
        this.txtyxProportion.setSupportedEmpty(true);		
        this.txtyxProportion.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtyxProportion.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtyxProportion.setPrecision(10);		
        this.txtyxProportion.setRequired(false);
        // txtyxBase		
        this.txtyxBase.setVisible(true);		
        this.txtyxBase.setHorizontalAlignment(2);		
        this.txtyxBase.setDataType(1);		
        this.txtyxBase.setSupportedEmpty(true);		
        this.txtyxBase.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtyxBase.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtyxBase.setPrecision(10);		
        this.txtyxBase.setRequired(false);
        // txtxfProportion		
        this.txtxfProportion.setVisible(true);		
        this.txtxfProportion.setHorizontalAlignment(2);		
        this.txtxfProportion.setDataType(1);		
        this.txtxfProportion.setSupportedEmpty(true);		
        this.txtxfProportion.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtxfProportion.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtxfProportion.setPrecision(10);		
        this.txtxfProportion.setRequired(false);
        // txtxfBase		
        this.txtxfBase.setVisible(true);		
        this.txtxfBase.setHorizontalAlignment(2);		
        this.txtxfBase.setDataType(1);		
        this.txtxfBase.setSupportedEmpty(true);		
        this.txtxfBase.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtxfBase.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtxfBase.setPrecision(10);		
        this.txtxfBase.setRequired(false);
        // txteyProportion		
        this.txteyProportion.setVisible(true);		
        this.txteyProportion.setHorizontalAlignment(2);		
        this.txteyProportion.setDataType(1);		
        this.txteyProportion.setSupportedEmpty(true);		
        this.txteyProportion.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txteyProportion.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txteyProportion.setPrecision(10);		
        this.txteyProportion.setRequired(false);
        // txteyBase		
        this.txteyBase.setVisible(true);		
        this.txteyBase.setHorizontalAlignment(2);		
        this.txteyBase.setDataType(1);		
        this.txteyBase.setSupportedEmpty(true);		
        this.txteyBase.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txteyBase.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txteyBase.setPrecision(10);		
        this.txteyBase.setRequired(false);
        // txtknProportion		
        this.txtknProportion.setVisible(true);		
        this.txtknProportion.setHorizontalAlignment(2);		
        this.txtknProportion.setDataType(1);		
        this.txtknProportion.setSupportedEmpty(true);		
        this.txtknProportion.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtknProportion.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtknProportion.setPrecision(10);		
        this.txtknProportion.setRequired(false);
        // txtknBase		
        this.txtknBase.setVisible(true);		
        this.txtknBase.setHorizontalAlignment(2);		
        this.txtknBase.setDataType(1);		
        this.txtknBase.setSupportedEmpty(true);		
        this.txtknBase.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtknBase.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtknBase.setPrecision(10);		
        this.txtknBase.setRequired(false);
        // txtmbProportion		
        this.txtmbProportion.setVisible(true);		
        this.txtmbProportion.setHorizontalAlignment(2);		
        this.txtmbProportion.setDataType(1);		
        this.txtmbProportion.setSupportedEmpty(true);		
        this.txtmbProportion.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtmbProportion.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtmbProportion.setPrecision(10);		
        this.txtmbProportion.setRequired(false);
        // txtmbBase		
        this.txtmbBase.setVisible(true);		
        this.txtmbBase.setHorizontalAlignment(2);		
        this.txtmbBase.setDataType(1);		
        this.txtmbBase.setSupportedEmpty(true);		
        this.txtmbBase.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtmbBase.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtmbBase.setPrecision(10);		
        this.txtmbBase.setRequired(false);
        // txtzbProportion		
        this.txtzbProportion.setVisible(true);		
        this.txtzbProportion.setHorizontalAlignment(2);		
        this.txtzbProportion.setDataType(1);		
        this.txtzbProportion.setSupportedEmpty(true);		
        this.txtzbProportion.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtzbProportion.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtzbProportion.setPrecision(10);		
        this.txtzbProportion.setRequired(false);
        // txtzbBase		
        this.txtzbBase.setVisible(true);		
        this.txtzbBase.setHorizontalAlignment(2);		
        this.txtzbBase.setDataType(1);		
        this.txtzbBase.setSupportedEmpty(true);		
        this.txtzbBase.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtzbBase.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtzbBase.setPrecision(10);		
        this.txtzbBase.setRequired(false);
        // txtqtProportion		
        this.txtqtProportion.setVisible(true);		
        this.txtqtProportion.setHorizontalAlignment(2);		
        this.txtqtProportion.setDataType(1);		
        this.txtqtProportion.setSupportedEmpty(true);		
        this.txtqtProportion.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtqtProportion.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtqtProportion.setPrecision(10);		
        this.txtqtProportion.setRequired(false);
        // txtqtBase		
        this.txtqtBase.setVisible(true);		
        this.txtqtBase.setHorizontalAlignment(2);		
        this.txtqtBase.setDataType(1);		
        this.txtqtBase.setSupportedEmpty(true);		
        this.txtqtBase.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtqtBase.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtqtBase.setPrecision(10);		
        this.txtqtBase.setRequired(false);
        // pkimportDate		
        this.pkimportDate.setVisible(true);		
        this.pkimportDate.setRequired(false);
        // txtbusinessDate		
        this.txtbusinessDate.setVisible(true);		
        this.txtbusinessDate.setHorizontalAlignment(2);		
        this.txtbusinessDate.setMaxLength(100);		
        this.txtbusinessDate.setRequired(false);
        // txtcityName		
        this.txtcityName.setVisible(true);		
        this.txtcityName.setHorizontalAlignment(2);		
        this.txtcityName.setMaxLength(100);		
        this.txtcityName.setRequired(false);
        // txtcityNumber		
        this.txtcityNumber.setVisible(true);		
        this.txtcityNumber.setHorizontalAlignment(2);		
        this.txtcityNumber.setMaxLength(100);		
        this.txtcityNumber.setRequired(false);
        // prmtcity		
        this.prmtcity.setQueryInfo("com.kingdee.eas.basedata.org.app.CUQuery");		
        this.prmtcity.setVisible(true);		
        this.prmtcity.setEditable(true);		
        this.prmtcity.setDisplayFormat("$name$");		
        this.prmtcity.setEditFormat("$number$");		
        this.prmtcity.setCommitFormat("$number$");		
        this.prmtcity.setRequired(false);
        // txtzjBiLi		
        this.txtzjBiLi.setVisible(true);		
        this.txtzjBiLi.setHorizontalAlignment(2);		
        this.txtzjBiLi.setDataType(1);		
        this.txtzjBiLi.setSupportedEmpty(true);		
        this.txtzjBiLi.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtzjBiLi.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtzjBiLi.setPrecision(10);		
        this.txtzjBiLi.setRequired(false);
        // docKeepType		
        this.docKeepType.setVisible(true);		
        this.docKeepType.addItems(EnumUtils.getEnumList("com.kingdee.eas.mw.pay.app.DocKeepType").toArray());		
        this.docKeepType.setRequired(false);
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {txtmzNumber,txtmzName,txtempNumber,txtempName,txtperformanceBase,txtzzProportion,txtzzBase,txtgdProportion,txtgdBase,txtyxProportion,txtyxBase,txtxfProportion,txtxfBase,txteyProportion,txteyBase,txtknProportion,txtknBase,txtmbProportion,txtmbBase,txtzbProportion,txtzbBase,txtqtProportion,txtqtBase,pkimportDate,txtbusinessDate,txtcityName,txtcityNumber,prmtcity,txtzjBiLi,docKeepType}));
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
        this.setBounds(new Rectangle(0, 0, 1013, 341));
        this.setLayout(null);
        contCreator.setBounds(new Rectangle(672, 178, 270, 19));
        this.add(contCreator, null);
        contCreateTime.setBounds(new Rectangle(672, 202, 270, 19));
        this.add(contCreateTime, null);
        contLastUpdateUser.setBounds(new Rectangle(341, 226, 270, 19));
        this.add(contLastUpdateUser, null);
        contLastUpdateTime.setBounds(new Rectangle(672, 226, 270, 19));
        this.add(contLastUpdateTime, null);
        contNumber.setBounds(new Rectangle(341, 250, 270, 19));
        this.add(contNumber, null);
        contBizDate.setBounds(new Rectangle(10, 202, 270, 19));
        this.add(contBizDate, null);
        contDescription.setBounds(new Rectangle(341, 202, 270, 19));
        this.add(contDescription, null);
        contAuditor.setBounds(new Rectangle(10, 226, 270, 19));
        this.add(contAuditor, null);
        contmzNumber.setBounds(new Rectangle(672, 250, 270, 19));
        this.add(contmzNumber, null);
        contmzName.setBounds(new Rectangle(341, 274, 270, 19));
        this.add(contmzName, null);
        contempNumber.setBounds(new Rectangle(341, 10, 270, 19));
        this.add(contempNumber, null);
        contempName.setBounds(new Rectangle(672, 10, 270, 19));
        this.add(contempName, null);
        contzzProportion.setBounds(new Rectangle(341, 34, 270, 19));
        this.add(contzzProportion, null);
        contperformanceBase.setBounds(new Rectangle(10, 34, 270, 19));
        this.add(contperformanceBase, null);
        contzzBase.setBounds(new Rectangle(672, 34, 270, 19));
        this.add(contzzBase, null);
        contgdProportion.setBounds(new Rectangle(10, 58, 270, 19));
        this.add(contgdProportion, null);
        contgdBase.setBounds(new Rectangle(341, 58, 270, 19));
        this.add(contgdBase, null);
        contyxProportion.setBounds(new Rectangle(672, 58, 270, 19));
        this.add(contyxProportion, null);
        contyxBase.setBounds(new Rectangle(10, 82, 270, 19));
        this.add(contyxBase, null);
        contxfProportion.setBounds(new Rectangle(341, 82, 270, 19));
        this.add(contxfProportion, null);
        contxfBase.setBounds(new Rectangle(672, 82, 270, 19));
        this.add(contxfBase, null);
        conteyProportion.setBounds(new Rectangle(10, 106, 270, 19));
        this.add(conteyProportion, null);
        conteyBase.setBounds(new Rectangle(341, 106, 270, 19));
        this.add(conteyBase, null);
        contknProportion.setBounds(new Rectangle(672, 106, 270, 19));
        this.add(contknProportion, null);
        contknBase.setBounds(new Rectangle(10, 130, 270, 19));
        this.add(contknBase, null);
        contmbProportion.setBounds(new Rectangle(341, 130, 270, 19));
        this.add(contmbProportion, null);
        contmbBase.setBounds(new Rectangle(672, 130, 270, 19));
        this.add(contmbBase, null);
        contzbProportion.setBounds(new Rectangle(10, 154, 270, 19));
        this.add(contzbProportion, null);
        contzbBase.setBounds(new Rectangle(341, 154, 270, 19));
        this.add(contzbBase, null);
        contqtProportion.setBounds(new Rectangle(672, 154, 270, 19));
        this.add(contqtProportion, null);
        contqtBase.setBounds(new Rectangle(10, 178, 270, 19));
        this.add(contqtBase, null);
        contimportDate.setBounds(new Rectangle(10, 250, 270, 19));
        this.add(contimportDate, null);
        contbusinessDate.setBounds(new Rectangle(341, 178, 270, 19));
        this.add(contbusinessDate, null);
        contcityName.setBounds(new Rectangle(10, 274, 270, 19));
        this.add(contcityName, null);
        contcityNumber.setBounds(new Rectangle(672, 274, 270, 19));
        this.add(contcityNumber, null);
        contcity.setBounds(new Rectangle(10, 10, 270, 19));
        this.add(contcity, null);
        contzjBiLi.setBounds(new Rectangle(10, 298, 270, 19));
        this.add(contzjBiLi, null);
        contdocKeepType.setBounds(new Rectangle(341, 298, 270, 19));
        this.add(contdocKeepType, null);
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
        //contzzProportion
        contzzProportion.setBoundEditor(txtzzProportion);
        //contperformanceBase
        contperformanceBase.setBoundEditor(txtperformanceBase);
        //contzzBase
        contzzBase.setBoundEditor(txtzzBase);
        //contgdProportion
        contgdProportion.setBoundEditor(txtgdProportion);
        //contgdBase
        contgdBase.setBoundEditor(txtgdBase);
        //contyxProportion
        contyxProportion.setBoundEditor(txtyxProportion);
        //contyxBase
        contyxBase.setBoundEditor(txtyxBase);
        //contxfProportion
        contxfProportion.setBoundEditor(txtxfProportion);
        //contxfBase
        contxfBase.setBoundEditor(txtxfBase);
        //conteyProportion
        conteyProportion.setBoundEditor(txteyProportion);
        //conteyBase
        conteyBase.setBoundEditor(txteyBase);
        //contknProportion
        contknProportion.setBoundEditor(txtknProportion);
        //contknBase
        contknBase.setBoundEditor(txtknBase);
        //contmbProportion
        contmbProportion.setBoundEditor(txtmbProportion);
        //contmbBase
        contmbBase.setBoundEditor(txtmbBase);
        //contzbProportion
        contzbProportion.setBoundEditor(txtzbProportion);
        //contzbBase
        contzbBase.setBoundEditor(txtzbBase);
        //contqtProportion
        contqtProportion.setBoundEditor(txtqtProportion);
        //contqtBase
        contqtBase.setBoundEditor(txtqtBase);
        //contimportDate
        contimportDate.setBoundEditor(pkimportDate);
        //contbusinessDate
        contbusinessDate.setBoundEditor(txtbusinessDate);
        //contcityName
        contcityName.setBoundEditor(txtcityName);
        //contcityNumber
        contcityNumber.setBoundEditor(txtcityNumber);
        //contcity
        contcity.setBoundEditor(prmtcity);
        //contzjBiLi
        contzjBiLi.setBoundEditor(txtzjBiLi);
        //contdocKeepType
        contdocKeepType.setBoundEditor(docKeepType);

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
		dataBinder.registerBinding("zzProportion", java.math.BigDecimal.class, this.txtzzProportion, "value");
		dataBinder.registerBinding("performanceBase", java.math.BigDecimal.class, this.txtperformanceBase, "value");
		dataBinder.registerBinding("zzBase", java.math.BigDecimal.class, this.txtzzBase, "value");
		dataBinder.registerBinding("gdProportion", java.math.BigDecimal.class, this.txtgdProportion, "value");
		dataBinder.registerBinding("gdBase", java.math.BigDecimal.class, this.txtgdBase, "value");
		dataBinder.registerBinding("yxProportion", java.math.BigDecimal.class, this.txtyxProportion, "value");
		dataBinder.registerBinding("yxBase", java.math.BigDecimal.class, this.txtyxBase, "value");
		dataBinder.registerBinding("xfProportion", java.math.BigDecimal.class, this.txtxfProportion, "value");
		dataBinder.registerBinding("xfBase", java.math.BigDecimal.class, this.txtxfBase, "value");
		dataBinder.registerBinding("eyProportion", java.math.BigDecimal.class, this.txteyProportion, "value");
		dataBinder.registerBinding("eyBase", java.math.BigDecimal.class, this.txteyBase, "value");
		dataBinder.registerBinding("knProportion", java.math.BigDecimal.class, this.txtknProportion, "value");
		dataBinder.registerBinding("knBase", java.math.BigDecimal.class, this.txtknBase, "value");
		dataBinder.registerBinding("mbProportion", java.math.BigDecimal.class, this.txtmbProportion, "value");
		dataBinder.registerBinding("mbBase", java.math.BigDecimal.class, this.txtmbBase, "value");
		dataBinder.registerBinding("zbProportion", java.math.BigDecimal.class, this.txtzbProportion, "value");
		dataBinder.registerBinding("zbBase", java.math.BigDecimal.class, this.txtzbBase, "value");
		dataBinder.registerBinding("qtProportion", java.math.BigDecimal.class, this.txtqtProportion, "value");
		dataBinder.registerBinding("qtBase", java.math.BigDecimal.class, this.txtqtBase, "value");
		dataBinder.registerBinding("importDate", java.util.Date.class, this.pkimportDate, "value");
		dataBinder.registerBinding("businessDate", String.class, this.txtbusinessDate, "text");
		dataBinder.registerBinding("cityName", String.class, this.txtcityName, "text");
		dataBinder.registerBinding("cityNumber", String.class, this.txtcityNumber, "text");
		dataBinder.registerBinding("city", com.kingdee.eas.basedata.org.CtrlUnitInfo.class, this.prmtcity, "data");
		dataBinder.registerBinding("zjBiLi", java.math.BigDecimal.class, this.txtzjBiLi, "value");
		dataBinder.registerBinding("docKeepType", com.kingdee.eas.mw.pay.app.DocKeepType.class, this.docKeepType, "selectedItem");		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.mw.pay.app.DoctorPerformanceEditUIHandler";
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
        this.editData = (com.kingdee.eas.mw.pay.DoctorPerformanceInfo)ov;
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
	 * ????????§µ??
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
		getValidateHelper().registerBindProperty("zzProportion", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("performanceBase", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("zzBase", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("gdProportion", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("gdBase", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("yxProportion", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("yxBase", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("xfProportion", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("xfBase", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("eyProportion", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("eyBase", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("knProportion", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("knBase", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("mbProportion", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("mbBase", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("zbProportion", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("zbBase", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("qtProportion", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("qtBase", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("importDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("businessDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("cityName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("cityNumber", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("city", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("zjBiLi", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("docKeepType", ValidateHelper.ON_SAVE);    		
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
        sic.add(new SelectorItemInfo("zzProportion"));
        sic.add(new SelectorItemInfo("performanceBase"));
        sic.add(new SelectorItemInfo("zzBase"));
        sic.add(new SelectorItemInfo("gdProportion"));
        sic.add(new SelectorItemInfo("gdBase"));
        sic.add(new SelectorItemInfo("yxProportion"));
        sic.add(new SelectorItemInfo("yxBase"));
        sic.add(new SelectorItemInfo("xfProportion"));
        sic.add(new SelectorItemInfo("xfBase"));
        sic.add(new SelectorItemInfo("eyProportion"));
        sic.add(new SelectorItemInfo("eyBase"));
        sic.add(new SelectorItemInfo("knProportion"));
        sic.add(new SelectorItemInfo("knBase"));
        sic.add(new SelectorItemInfo("mbProportion"));
        sic.add(new SelectorItemInfo("mbBase"));
        sic.add(new SelectorItemInfo("zbProportion"));
        sic.add(new SelectorItemInfo("zbBase"));
        sic.add(new SelectorItemInfo("qtProportion"));
        sic.add(new SelectorItemInfo("qtBase"));
        sic.add(new SelectorItemInfo("importDate"));
        sic.add(new SelectorItemInfo("businessDate"));
        sic.add(new SelectorItemInfo("cityName"));
        sic.add(new SelectorItemInfo("cityNumber"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("city.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("city.id"));
        	sic.add(new SelectorItemInfo("city.number"));
        	sic.add(new SelectorItemInfo("city.name"));
		}
        sic.add(new SelectorItemInfo("zjBiLi"));
        sic.add(new SelectorItemInfo("docKeepType"));
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
        return new MetaDataPK("com.kingdee.eas.mw.pay.client", "DoctorPerformanceEditUI");
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
        return com.kingdee.eas.mw.pay.client.DoctorPerformanceEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.mw.pay.DoctorPerformanceFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.mw.pay.DoctorPerformanceInfo objectValue = new com.kingdee.eas.mw.pay.DoctorPerformanceInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


    	protected String getTDFileName() {
    	return "/bim/mw/pay/DoctorPerformance";
	}
    protected IMetaDataPK getTDQueryPK() {
    	return new MetaDataPK("com.kingdee.eas.mw.pay.app.DoctorPerformanceQuery");
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
		vo.put("docKeepType","wu");
        
    }        
	protected void setFieldsNull(com.kingdee.bos.dao.AbstractObjectValue arg0) {
		super.setFieldsNull(arg0);
		arg0.put("number",null);
	}

}