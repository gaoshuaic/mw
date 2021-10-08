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
public abstract class AbstractCostByUpdateEditUI extends com.kingdee.eas.framework.client.CoreBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractCostByUpdateEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCreator;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCreateTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contNumber;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contBizDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contDescription;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contAuditor;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contdoctorNumber;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contdoctorName;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contperiod;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contclinicNumber;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contclinicName;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcityNumber;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcityName;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contstatus;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contdoctor;
    protected com.kingdee.bos.ctrl.swing.KDContainer kDContainer1;
    protected com.kingdee.bos.ctrl.swing.KDContainer kDContainer2;
    protected com.kingdee.bos.ctrl.swing.KDContainer kDContainer3;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contremake;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkiszidai;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtCreator;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateCreateTime;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkBizDate;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtDescription;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtAuditor;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtdoctorNumber;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtdoctorName;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtperiod;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtclinicNumber;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtclinicName;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtcityNumber;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtcityName;
    protected com.kingdee.bos.ctrl.swing.KDComboBox status;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtdoctor;
    protected com.kingdee.bos.ctrl.swing.KDTabbedPane kDTabbedPane2;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel3;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel4;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsumxhzz;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsumxhyxjz;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsumxhcgjz;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsumxhknw;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsumxhxf;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsumxhey;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsumxhyz;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsumxhmb;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtsumxhzz;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtsumxhyxjz;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtsumxhcgjz;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtsumxhknw;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtsumxhxf;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtsumxhey;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtsumxhyz;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtsumxhmb;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsumjgfzz;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsumjgfyxjz;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsumjgfcgjz;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsumjgfknw;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsumjgfxf;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsumjgfey;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsumjgfyz;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsumjgfmb;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtsumjgfzz;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtsumjgfyxjz;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtsumjgfcgjz;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtsumjgfknw;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtsumjgfxf;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtsumjgfey;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtsumjgfyz;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtsumjgfmb;
    protected com.kingdee.bos.ctrl.swing.KDTabbedPane kDTabbedPane1;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel1;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel2;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contxhzz;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contxhyxjz;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contxhcgjz;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contxhknw;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contxhxf;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contxhey;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contxhyz;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contxhmb;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtxhzz;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtxhyxjz;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtxhcgjz;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtxhknw;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtxhxf;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtxhey;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtxhyz;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtxhmb;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contjgfyxjz;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contjgfcgjz;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contjgfknw;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contjgfxf;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contjgfey;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contjgfyz;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contjgfmb;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contjgfzz;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtjgfyxjz;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtjgfcgjz;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtjgfknw;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtjgfxf;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtjgfey;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtjgfyz;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtjgfmb;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtjgfzz;
    protected com.kingdee.bos.ctrl.swing.KDTabbedPane kDTabbedPane3;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel6;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel5;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contallxhzz;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contallxhyxjz;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contallxhcgjz;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contallzhknw;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contallxhxf;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contallxhey;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contallxhyz;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contallxhmb;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtallxhzz;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtallxhyxjz;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtallxhcgjz;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtallzhknw;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtallxhxf;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtallxhey;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtallxhyz;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtallxhmb;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contalljgfzz;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contalljgfyxjz;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contalljgfcgjz;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contalljgfknw;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contalljgfxf;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contalljgfey;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contalljgfyz;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contalljgdmb;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtalljgfzz;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtalljgfyxjz;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtalljgfcgjz;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtalljgfknw;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtalljgfxf;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtalljgfey;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtalljgfyz;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtalljgdmb;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtremake;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton auditCost;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton unauditCost;
    protected com.kingdee.eas.mw.pay.CostByUpdateInfo editData = null;
    protected ActionAuditCost actionAuditCost = null;
    protected ActionUnAuditCost actionUnAuditCost = null;
    /**
     * output class constructor
     */
    public AbstractCostByUpdateEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractCostByUpdateEditUI.class.getName());
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
        //actionAuditCost
        this.actionAuditCost = new ActionAuditCost(this);
        getActionManager().registerAction("actionAuditCost", actionAuditCost);
        this.actionAuditCost.setExtendProperty("canForewarn", "true");
        this.actionAuditCost.setExtendProperty("userDefined", "true");
        this.actionAuditCost.setExtendProperty("isObjectUpdateLock", "false");
         this.actionAuditCost.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionAuditCost.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
        //actionUnAuditCost
        this.actionUnAuditCost = new ActionUnAuditCost(this);
        getActionManager().registerAction("actionUnAuditCost", actionUnAuditCost);
        this.actionUnAuditCost.setExtendProperty("canForewarn", "true");
        this.actionUnAuditCost.setExtendProperty("userDefined", "true");
        this.actionUnAuditCost.setExtendProperty("isObjectUpdateLock", "false");
         this.actionUnAuditCost.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionUnAuditCost.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
        this.contCreator = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contCreateTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contLastUpdateUser = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contLastUpdateTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contNumber = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contBizDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contDescription = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contAuditor = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contdoctorNumber = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contdoctorName = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contperiod = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contclinicNumber = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contclinicName = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcityNumber = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcityName = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contstatus = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contdoctor = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDContainer1 = new com.kingdee.bos.ctrl.swing.KDContainer();
        this.kDContainer2 = new com.kingdee.bos.ctrl.swing.KDContainer();
        this.kDContainer3 = new com.kingdee.bos.ctrl.swing.KDContainer();
        this.contremake = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.chkiszidai = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.prmtCreator = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateCreateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtLastUpdateUser = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateLastUpdateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.pkBizDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtDescription = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtAuditor = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtdoctorNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtdoctorName = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtperiod = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtclinicNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtclinicName = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtcityNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtcityName = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.status = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.prmtdoctor = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDTabbedPane2 = new com.kingdee.bos.ctrl.swing.KDTabbedPane();
        this.kDPanel3 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel4 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.contsumxhzz = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contsumxhyxjz = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contsumxhcgjz = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contsumxhknw = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contsumxhxf = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contsumxhey = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contsumxhyz = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contsumxhmb = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtsumxhzz = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtsumxhyxjz = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtsumxhcgjz = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtsumxhknw = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtsumxhxf = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtsumxhey = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtsumxhyz = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtsumxhmb = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.contsumjgfzz = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contsumjgfyxjz = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contsumjgfcgjz = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contsumjgfknw = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contsumjgfxf = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contsumjgfey = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contsumjgfyz = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contsumjgfmb = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtsumjgfzz = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtsumjgfyxjz = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtsumjgfcgjz = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtsumjgfknw = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtsumjgfxf = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtsumjgfey = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtsumjgfyz = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtsumjgfmb = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.kDTabbedPane1 = new com.kingdee.bos.ctrl.swing.KDTabbedPane();
        this.kDPanel1 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel2 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.contxhzz = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contxhyxjz = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contxhcgjz = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contxhknw = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contxhxf = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contxhey = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contxhyz = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contxhmb = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtxhzz = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtxhyxjz = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtxhcgjz = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtxhknw = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtxhxf = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtxhey = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtxhyz = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtxhmb = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.contjgfyxjz = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contjgfcgjz = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contjgfknw = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contjgfxf = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contjgfey = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contjgfyz = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contjgfmb = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contjgfzz = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtjgfyxjz = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtjgfcgjz = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtjgfknw = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtjgfxf = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtjgfey = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtjgfyz = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtjgfmb = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtjgfzz = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.kDTabbedPane3 = new com.kingdee.bos.ctrl.swing.KDTabbedPane();
        this.kDPanel6 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel5 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.contallxhzz = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contallxhyxjz = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contallxhcgjz = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contallzhknw = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contallxhxf = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contallxhey = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contallxhyz = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contallxhmb = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtallxhzz = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtallxhyxjz = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtallxhcgjz = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtallzhknw = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtallxhxf = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtallxhey = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtallxhyz = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtallxhmb = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.contalljgfzz = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contalljgfyxjz = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contalljgfcgjz = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contalljgfknw = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contalljgfxf = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contalljgfey = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contalljgfyz = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contalljgdmb = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtalljgfzz = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtalljgfyxjz = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtalljgfcgjz = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtalljgfknw = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtalljgfxf = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtalljgfey = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtalljgfyz = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtalljgdmb = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtremake = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.auditCost = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.unauditCost = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.contCreator.setName("contCreator");
        this.contCreateTime.setName("contCreateTime");
        this.contLastUpdateUser.setName("contLastUpdateUser");
        this.contLastUpdateTime.setName("contLastUpdateTime");
        this.contNumber.setName("contNumber");
        this.contBizDate.setName("contBizDate");
        this.contDescription.setName("contDescription");
        this.contAuditor.setName("contAuditor");
        this.contdoctorNumber.setName("contdoctorNumber");
        this.contdoctorName.setName("contdoctorName");
        this.contperiod.setName("contperiod");
        this.contclinicNumber.setName("contclinicNumber");
        this.contclinicName.setName("contclinicName");
        this.contcityNumber.setName("contcityNumber");
        this.contcityName.setName("contcityName");
        this.contstatus.setName("contstatus");
        this.contdoctor.setName("contdoctor");
        this.kDContainer1.setName("kDContainer1");
        this.kDContainer2.setName("kDContainer2");
        this.kDContainer3.setName("kDContainer3");
        this.contremake.setName("contremake");
        this.chkiszidai.setName("chkiszidai");
        this.prmtCreator.setName("prmtCreator");
        this.kDDateCreateTime.setName("kDDateCreateTime");
        this.prmtLastUpdateUser.setName("prmtLastUpdateUser");
        this.kDDateLastUpdateTime.setName("kDDateLastUpdateTime");
        this.txtNumber.setName("txtNumber");
        this.pkBizDate.setName("pkBizDate");
        this.txtDescription.setName("txtDescription");
        this.prmtAuditor.setName("prmtAuditor");
        this.txtdoctorNumber.setName("txtdoctorNumber");
        this.txtdoctorName.setName("txtdoctorName");
        this.txtperiod.setName("txtperiod");
        this.txtclinicNumber.setName("txtclinicNumber");
        this.txtclinicName.setName("txtclinicName");
        this.txtcityNumber.setName("txtcityNumber");
        this.txtcityName.setName("txtcityName");
        this.status.setName("status");
        this.prmtdoctor.setName("prmtdoctor");
        this.kDTabbedPane2.setName("kDTabbedPane2");
        this.kDPanel3.setName("kDPanel3");
        this.kDPanel4.setName("kDPanel4");
        this.contsumxhzz.setName("contsumxhzz");
        this.contsumxhyxjz.setName("contsumxhyxjz");
        this.contsumxhcgjz.setName("contsumxhcgjz");
        this.contsumxhknw.setName("contsumxhknw");
        this.contsumxhxf.setName("contsumxhxf");
        this.contsumxhey.setName("contsumxhey");
        this.contsumxhyz.setName("contsumxhyz");
        this.contsumxhmb.setName("contsumxhmb");
        this.txtsumxhzz.setName("txtsumxhzz");
        this.txtsumxhyxjz.setName("txtsumxhyxjz");
        this.txtsumxhcgjz.setName("txtsumxhcgjz");
        this.txtsumxhknw.setName("txtsumxhknw");
        this.txtsumxhxf.setName("txtsumxhxf");
        this.txtsumxhey.setName("txtsumxhey");
        this.txtsumxhyz.setName("txtsumxhyz");
        this.txtsumxhmb.setName("txtsumxhmb");
        this.contsumjgfzz.setName("contsumjgfzz");
        this.contsumjgfyxjz.setName("contsumjgfyxjz");
        this.contsumjgfcgjz.setName("contsumjgfcgjz");
        this.contsumjgfknw.setName("contsumjgfknw");
        this.contsumjgfxf.setName("contsumjgfxf");
        this.contsumjgfey.setName("contsumjgfey");
        this.contsumjgfyz.setName("contsumjgfyz");
        this.contsumjgfmb.setName("contsumjgfmb");
        this.txtsumjgfzz.setName("txtsumjgfzz");
        this.txtsumjgfyxjz.setName("txtsumjgfyxjz");
        this.txtsumjgfcgjz.setName("txtsumjgfcgjz");
        this.txtsumjgfknw.setName("txtsumjgfknw");
        this.txtsumjgfxf.setName("txtsumjgfxf");
        this.txtsumjgfey.setName("txtsumjgfey");
        this.txtsumjgfyz.setName("txtsumjgfyz");
        this.txtsumjgfmb.setName("txtsumjgfmb");
        this.kDTabbedPane1.setName("kDTabbedPane1");
        this.kDPanel1.setName("kDPanel1");
        this.kDPanel2.setName("kDPanel2");
        this.contxhzz.setName("contxhzz");
        this.contxhyxjz.setName("contxhyxjz");
        this.contxhcgjz.setName("contxhcgjz");
        this.contxhknw.setName("contxhknw");
        this.contxhxf.setName("contxhxf");
        this.contxhey.setName("contxhey");
        this.contxhyz.setName("contxhyz");
        this.contxhmb.setName("contxhmb");
        this.txtxhzz.setName("txtxhzz");
        this.txtxhyxjz.setName("txtxhyxjz");
        this.txtxhcgjz.setName("txtxhcgjz");
        this.txtxhknw.setName("txtxhknw");
        this.txtxhxf.setName("txtxhxf");
        this.txtxhey.setName("txtxhey");
        this.txtxhyz.setName("txtxhyz");
        this.txtxhmb.setName("txtxhmb");
        this.contjgfyxjz.setName("contjgfyxjz");
        this.contjgfcgjz.setName("contjgfcgjz");
        this.contjgfknw.setName("contjgfknw");
        this.contjgfxf.setName("contjgfxf");
        this.contjgfey.setName("contjgfey");
        this.contjgfyz.setName("contjgfyz");
        this.contjgfmb.setName("contjgfmb");
        this.contjgfzz.setName("contjgfzz");
        this.txtjgfyxjz.setName("txtjgfyxjz");
        this.txtjgfcgjz.setName("txtjgfcgjz");
        this.txtjgfknw.setName("txtjgfknw");
        this.txtjgfxf.setName("txtjgfxf");
        this.txtjgfey.setName("txtjgfey");
        this.txtjgfyz.setName("txtjgfyz");
        this.txtjgfmb.setName("txtjgfmb");
        this.txtjgfzz.setName("txtjgfzz");
        this.kDTabbedPane3.setName("kDTabbedPane3");
        this.kDPanel6.setName("kDPanel6");
        this.kDPanel5.setName("kDPanel5");
        this.contallxhzz.setName("contallxhzz");
        this.contallxhyxjz.setName("contallxhyxjz");
        this.contallxhcgjz.setName("contallxhcgjz");
        this.contallzhknw.setName("contallzhknw");
        this.contallxhxf.setName("contallxhxf");
        this.contallxhey.setName("contallxhey");
        this.contallxhyz.setName("contallxhyz");
        this.contallxhmb.setName("contallxhmb");
        this.txtallxhzz.setName("txtallxhzz");
        this.txtallxhyxjz.setName("txtallxhyxjz");
        this.txtallxhcgjz.setName("txtallxhcgjz");
        this.txtallzhknw.setName("txtallzhknw");
        this.txtallxhxf.setName("txtallxhxf");
        this.txtallxhey.setName("txtallxhey");
        this.txtallxhyz.setName("txtallxhyz");
        this.txtallxhmb.setName("txtallxhmb");
        this.contalljgfzz.setName("contalljgfzz");
        this.contalljgfyxjz.setName("contalljgfyxjz");
        this.contalljgfcgjz.setName("contalljgfcgjz");
        this.contalljgfknw.setName("contalljgfknw");
        this.contalljgfxf.setName("contalljgfxf");
        this.contalljgfey.setName("contalljgfey");
        this.contalljgfyz.setName("contalljgfyz");
        this.contalljgdmb.setName("contalljgdmb");
        this.txtalljgfzz.setName("txtalljgfzz");
        this.txtalljgfyxjz.setName("txtalljgfyxjz");
        this.txtalljgfcgjz.setName("txtalljgfcgjz");
        this.txtalljgfknw.setName("txtalljgfknw");
        this.txtalljgfxf.setName("txtalljgfxf");
        this.txtalljgfey.setName("txtalljgfey");
        this.txtalljgfyz.setName("txtalljgfyz");
        this.txtalljgdmb.setName("txtalljgdmb");
        this.txtremake.setName("txtremake");
        this.auditCost.setName("auditCost");
        this.unauditCost.setName("unauditCost");
        // CoreUI		
        this.btnTraceUp.setVisible(false);		
        this.btnTraceDown.setVisible(false);		
        this.btnCreateTo.setVisible(true);		
        this.btnAddLine.setVisible(false);		
        this.btnCopyLine.setVisible(false);		
        this.btnInsertLine.setVisible(false);		
        this.btnRemoveLine.setVisible(false);		
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
        this.contCreator.setVisible(false);
        // contCreateTime		
        this.contCreateTime.setBoundLabelText(resHelper.getString("contCreateTime.boundLabelText"));		
        this.contCreateTime.setBoundLabelLength(100);		
        this.contCreateTime.setBoundLabelUnderline(true);		
        this.contCreateTime.setEnabled(false);		
        this.contCreateTime.setVisible(false);
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
        this.contNumber.setVisible(false);
        // contBizDate		
        this.contBizDate.setBoundLabelText(resHelper.getString("contBizDate.boundLabelText"));		
        this.contBizDate.setBoundLabelLength(100);		
        this.contBizDate.setBoundLabelUnderline(true);		
        this.contBizDate.setBoundLabelAlignment(7);		
        this.contBizDate.setVisible(false);
        // contDescription		
        this.contDescription.setBoundLabelText(resHelper.getString("contDescription.boundLabelText"));		
        this.contDescription.setBoundLabelLength(100);		
        this.contDescription.setBoundLabelUnderline(true);		
        this.contDescription.setVisible(false);
        // contAuditor		
        this.contAuditor.setBoundLabelText(resHelper.getString("contAuditor.boundLabelText"));		
        this.contAuditor.setBoundLabelLength(100);		
        this.contAuditor.setBoundLabelUnderline(true);		
        this.contAuditor.setVisible(false);
        // contdoctorNumber		
        this.contdoctorNumber.setBoundLabelText(resHelper.getString("contdoctorNumber.boundLabelText"));		
        this.contdoctorNumber.setBoundLabelLength(100);		
        this.contdoctorNumber.setBoundLabelUnderline(true);		
        this.contdoctorNumber.setVisible(true);
        // contdoctorName		
        this.contdoctorName.setBoundLabelText(resHelper.getString("contdoctorName.boundLabelText"));		
        this.contdoctorName.setBoundLabelLength(100);		
        this.contdoctorName.setBoundLabelUnderline(true);		
        this.contdoctorName.setVisible(true);
        // contperiod		
        this.contperiod.setBoundLabelText(resHelper.getString("contperiod.boundLabelText"));		
        this.contperiod.setBoundLabelLength(100);		
        this.contperiod.setBoundLabelUnderline(true);		
        this.contperiod.setVisible(true);
        // contclinicNumber		
        this.contclinicNumber.setBoundLabelText(resHelper.getString("contclinicNumber.boundLabelText"));		
        this.contclinicNumber.setBoundLabelLength(100);		
        this.contclinicNumber.setBoundLabelUnderline(true);		
        this.contclinicNumber.setVisible(true);
        // contclinicName		
        this.contclinicName.setBoundLabelText(resHelper.getString("contclinicName.boundLabelText"));		
        this.contclinicName.setBoundLabelLength(100);		
        this.contclinicName.setBoundLabelUnderline(true);		
        this.contclinicName.setVisible(true);
        // contcityNumber		
        this.contcityNumber.setBoundLabelText(resHelper.getString("contcityNumber.boundLabelText"));		
        this.contcityNumber.setBoundLabelLength(100);		
        this.contcityNumber.setBoundLabelUnderline(true);		
        this.contcityNumber.setVisible(true);
        // contcityName		
        this.contcityName.setBoundLabelText(resHelper.getString("contcityName.boundLabelText"));		
        this.contcityName.setBoundLabelLength(100);		
        this.contcityName.setBoundLabelUnderline(true);		
        this.contcityName.setVisible(true);
        // contstatus		
        this.contstatus.setBoundLabelText(resHelper.getString("contstatus.boundLabelText"));		
        this.contstatus.setBoundLabelLength(100);		
        this.contstatus.setBoundLabelUnderline(true);		
        this.contstatus.setVisible(false);
        // contdoctor		
        this.contdoctor.setBoundLabelText(resHelper.getString("contdoctor.boundLabelText"));		
        this.contdoctor.setBoundLabelLength(100);		
        this.contdoctor.setBoundLabelUnderline(true);		
        this.contdoctor.setVisible(true);
        // kDContainer1		
        this.kDContainer1.setTitle(resHelper.getString("kDContainer1.title"));
        // kDContainer2		
        this.kDContainer2.setTitle(resHelper.getString("kDContainer2.title"));
        // kDContainer3		
        this.kDContainer3.setTitle(resHelper.getString("kDContainer3.title"));
        // contremake		
        this.contremake.setBoundLabelText(resHelper.getString("contremake.boundLabelText"));		
        this.contremake.setBoundLabelLength(100);		
        this.contremake.setBoundLabelUnderline(true);		
        this.contremake.setVisible(true);
        // chkiszidai		
        this.chkiszidai.setText(resHelper.getString("chkiszidai.text"));		
        this.chkiszidai.setVisible(true);		
        this.chkiszidai.setHorizontalAlignment(2);
        // prmtCreator		
        this.prmtCreator.setEnabled(false);		
        this.prmtCreator.setVisible(false);
        // kDDateCreateTime		
        this.kDDateCreateTime.setTimeEnabled(true);		
        this.kDDateCreateTime.setEnabled(false);		
        this.kDDateCreateTime.setVisible(false);
        // prmtLastUpdateUser		
        this.prmtLastUpdateUser.setEnabled(false);		
        this.prmtLastUpdateUser.setVisible(false);
        // kDDateLastUpdateTime		
        this.kDDateLastUpdateTime.setTimeEnabled(true);		
        this.kDDateLastUpdateTime.setEnabled(false);		
        this.kDDateLastUpdateTime.setVisible(false);
        // txtNumber		
        this.txtNumber.setMaxLength(80);		
        this.txtNumber.setVisible(false);
        // pkBizDate		
        this.pkBizDate.setVisible(false);		
        this.pkBizDate.setEnabled(true);
        // txtDescription		
        this.txtDescription.setMaxLength(80);		
        this.txtDescription.setVisible(false);
        // prmtAuditor		
        this.prmtAuditor.setEnabled(false);		
        this.prmtAuditor.setVisible(false);
        // txtdoctorNumber		
        this.txtdoctorNumber.setHorizontalAlignment(2);		
        this.txtdoctorNumber.setMaxLength(100);		
        this.txtdoctorNumber.setRequired(false);
        // txtdoctorName		
        this.txtdoctorName.setHorizontalAlignment(2);		
        this.txtdoctorName.setMaxLength(100);		
        this.txtdoctorName.setRequired(false);
        // txtperiod		
        this.txtperiod.setHorizontalAlignment(2);		
        this.txtperiod.setMaxLength(100);		
        this.txtperiod.setRequired(false);
        // txtclinicNumber		
        this.txtclinicNumber.setHorizontalAlignment(2);		
        this.txtclinicNumber.setMaxLength(100);		
        this.txtclinicNumber.setRequired(false);
        // txtclinicName		
        this.txtclinicName.setHorizontalAlignment(2);		
        this.txtclinicName.setMaxLength(100);		
        this.txtclinicName.setRequired(false);
        // txtcityNumber		
        this.txtcityNumber.setHorizontalAlignment(2);		
        this.txtcityNumber.setMaxLength(100);		
        this.txtcityNumber.setRequired(false);
        // txtcityName		
        this.txtcityName.setHorizontalAlignment(2);		
        this.txtcityName.setMaxLength(100);		
        this.txtcityName.setRequired(false);
        // status		
        this.status.setVisible(false);		
        this.status.addItems(EnumUtils.getEnumList("com.kingdee.eas.mw.pay.app.UpdateCostStatus").toArray());		
        this.status.setRequired(false);
        // prmtdoctor		
        this.prmtdoctor.setQueryInfo("com.kingdee.eas.basedata.person.app.PersonFilterQuery");		
        this.prmtdoctor.setVisible(true);		
        this.prmtdoctor.setEditable(true);		
        this.prmtdoctor.setDisplayFormat("$name$");		
        this.prmtdoctor.setEditFormat("$number$");		
        this.prmtdoctor.setCommitFormat("$number$");		
        this.prmtdoctor.setRequired(false);
        // kDTabbedPane2
        // kDPanel3
        // kDPanel4
        // contsumxhzz		
        this.contsumxhzz.setBoundLabelText(resHelper.getString("contsumxhzz.boundLabelText"));		
        this.contsumxhzz.setBoundLabelLength(100);		
        this.contsumxhzz.setBoundLabelUnderline(true);		
        this.contsumxhzz.setVisible(true);
        // contsumxhyxjz		
        this.contsumxhyxjz.setBoundLabelText(resHelper.getString("contsumxhyxjz.boundLabelText"));		
        this.contsumxhyxjz.setBoundLabelLength(100);		
        this.contsumxhyxjz.setBoundLabelUnderline(true);		
        this.contsumxhyxjz.setVisible(true);
        // contsumxhcgjz		
        this.contsumxhcgjz.setBoundLabelText(resHelper.getString("contsumxhcgjz.boundLabelText"));		
        this.contsumxhcgjz.setBoundLabelLength(100);		
        this.contsumxhcgjz.setBoundLabelUnderline(true);		
        this.contsumxhcgjz.setVisible(true);
        // contsumxhknw		
        this.contsumxhknw.setBoundLabelText(resHelper.getString("contsumxhknw.boundLabelText"));		
        this.contsumxhknw.setBoundLabelLength(100);		
        this.contsumxhknw.setBoundLabelUnderline(true);		
        this.contsumxhknw.setVisible(true);
        // contsumxhxf		
        this.contsumxhxf.setBoundLabelText(resHelper.getString("contsumxhxf.boundLabelText"));		
        this.contsumxhxf.setBoundLabelLength(100);		
        this.contsumxhxf.setBoundLabelUnderline(true);		
        this.contsumxhxf.setVisible(true);
        // contsumxhey		
        this.contsumxhey.setBoundLabelText(resHelper.getString("contsumxhey.boundLabelText"));		
        this.contsumxhey.setBoundLabelLength(100);		
        this.contsumxhey.setBoundLabelUnderline(true);		
        this.contsumxhey.setVisible(true);
        // contsumxhyz		
        this.contsumxhyz.setBoundLabelText(resHelper.getString("contsumxhyz.boundLabelText"));		
        this.contsumxhyz.setBoundLabelLength(100);		
        this.contsumxhyz.setBoundLabelUnderline(true);		
        this.contsumxhyz.setVisible(true);
        // contsumxhmb		
        this.contsumxhmb.setBoundLabelText(resHelper.getString("contsumxhmb.boundLabelText"));		
        this.contsumxhmb.setBoundLabelLength(100);		
        this.contsumxhmb.setBoundLabelUnderline(true);		
        this.contsumxhmb.setVisible(true);
        // txtsumxhzz		
        this.txtsumxhzz.setVisible(true);		
        this.txtsumxhzz.setHorizontalAlignment(2);		
        this.txtsumxhzz.setDataType(1);		
        this.txtsumxhzz.setSupportedEmpty(true);		
        this.txtsumxhzz.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtsumxhzz.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtsumxhzz.setPrecision(10);		
        this.txtsumxhzz.setRequired(false);
        // txtsumxhyxjz		
        this.txtsumxhyxjz.setVisible(true);		
        this.txtsumxhyxjz.setHorizontalAlignment(2);		
        this.txtsumxhyxjz.setDataType(1);		
        this.txtsumxhyxjz.setSupportedEmpty(true);		
        this.txtsumxhyxjz.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtsumxhyxjz.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtsumxhyxjz.setPrecision(10);		
        this.txtsumxhyxjz.setRequired(false);
        // txtsumxhcgjz		
        this.txtsumxhcgjz.setVisible(true);		
        this.txtsumxhcgjz.setHorizontalAlignment(2);		
        this.txtsumxhcgjz.setDataType(1);		
        this.txtsumxhcgjz.setSupportedEmpty(true);		
        this.txtsumxhcgjz.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtsumxhcgjz.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtsumxhcgjz.setPrecision(10);		
        this.txtsumxhcgjz.setRequired(false);
        // txtsumxhknw		
        this.txtsumxhknw.setVisible(true);		
        this.txtsumxhknw.setHorizontalAlignment(2);		
        this.txtsumxhknw.setDataType(1);		
        this.txtsumxhknw.setSupportedEmpty(true);		
        this.txtsumxhknw.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtsumxhknw.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtsumxhknw.setPrecision(10);		
        this.txtsumxhknw.setRequired(false);
        // txtsumxhxf		
        this.txtsumxhxf.setVisible(true);		
        this.txtsumxhxf.setHorizontalAlignment(2);		
        this.txtsumxhxf.setDataType(1);		
        this.txtsumxhxf.setSupportedEmpty(true);		
        this.txtsumxhxf.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtsumxhxf.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtsumxhxf.setPrecision(10);		
        this.txtsumxhxf.setRequired(false);
        // txtsumxhey		
        this.txtsumxhey.setVisible(true);		
        this.txtsumxhey.setHorizontalAlignment(2);		
        this.txtsumxhey.setDataType(1);		
        this.txtsumxhey.setSupportedEmpty(true);		
        this.txtsumxhey.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtsumxhey.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtsumxhey.setPrecision(10);		
        this.txtsumxhey.setRequired(false);
        // txtsumxhyz		
        this.txtsumxhyz.setVisible(true);		
        this.txtsumxhyz.setHorizontalAlignment(2);		
        this.txtsumxhyz.setDataType(1);		
        this.txtsumxhyz.setSupportedEmpty(true);		
        this.txtsumxhyz.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtsumxhyz.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtsumxhyz.setPrecision(10);		
        this.txtsumxhyz.setRequired(false);
        // txtsumxhmb		
        this.txtsumxhmb.setVisible(true);		
        this.txtsumxhmb.setHorizontalAlignment(2);		
        this.txtsumxhmb.setDataType(1);		
        this.txtsumxhmb.setSupportedEmpty(true);		
        this.txtsumxhmb.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtsumxhmb.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtsumxhmb.setPrecision(10);		
        this.txtsumxhmb.setRequired(false);
        // contsumjgfzz		
        this.contsumjgfzz.setBoundLabelText(resHelper.getString("contsumjgfzz.boundLabelText"));		
        this.contsumjgfzz.setBoundLabelLength(100);		
        this.contsumjgfzz.setBoundLabelUnderline(true);		
        this.contsumjgfzz.setVisible(true);
        // contsumjgfyxjz		
        this.contsumjgfyxjz.setBoundLabelText(resHelper.getString("contsumjgfyxjz.boundLabelText"));		
        this.contsumjgfyxjz.setBoundLabelLength(100);		
        this.contsumjgfyxjz.setBoundLabelUnderline(true);		
        this.contsumjgfyxjz.setVisible(true);
        // contsumjgfcgjz		
        this.contsumjgfcgjz.setBoundLabelText(resHelper.getString("contsumjgfcgjz.boundLabelText"));		
        this.contsumjgfcgjz.setBoundLabelLength(100);		
        this.contsumjgfcgjz.setBoundLabelUnderline(true);		
        this.contsumjgfcgjz.setVisible(true);
        // contsumjgfknw		
        this.contsumjgfknw.setBoundLabelText(resHelper.getString("contsumjgfknw.boundLabelText"));		
        this.contsumjgfknw.setBoundLabelLength(100);		
        this.contsumjgfknw.setBoundLabelUnderline(true);		
        this.contsumjgfknw.setVisible(true);
        // contsumjgfxf		
        this.contsumjgfxf.setBoundLabelText(resHelper.getString("contsumjgfxf.boundLabelText"));		
        this.contsumjgfxf.setBoundLabelLength(100);		
        this.contsumjgfxf.setBoundLabelUnderline(true);		
        this.contsumjgfxf.setVisible(true);
        // contsumjgfey		
        this.contsumjgfey.setBoundLabelText(resHelper.getString("contsumjgfey.boundLabelText"));		
        this.contsumjgfey.setBoundLabelLength(100);		
        this.contsumjgfey.setBoundLabelUnderline(true);		
        this.contsumjgfey.setVisible(true);
        // contsumjgfyz		
        this.contsumjgfyz.setBoundLabelText(resHelper.getString("contsumjgfyz.boundLabelText"));		
        this.contsumjgfyz.setBoundLabelLength(100);		
        this.contsumjgfyz.setBoundLabelUnderline(true);		
        this.contsumjgfyz.setVisible(true);
        // contsumjgfmb		
        this.contsumjgfmb.setBoundLabelText(resHelper.getString("contsumjgfmb.boundLabelText"));		
        this.contsumjgfmb.setBoundLabelLength(100);		
        this.contsumjgfmb.setBoundLabelUnderline(true);		
        this.contsumjgfmb.setVisible(true);
        // txtsumjgfzz		
        this.txtsumjgfzz.setVisible(true);		
        this.txtsumjgfzz.setHorizontalAlignment(2);		
        this.txtsumjgfzz.setDataType(1);		
        this.txtsumjgfzz.setSupportedEmpty(true);		
        this.txtsumjgfzz.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtsumjgfzz.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtsumjgfzz.setPrecision(10);		
        this.txtsumjgfzz.setRequired(false);
        // txtsumjgfyxjz		
        this.txtsumjgfyxjz.setVisible(true);		
        this.txtsumjgfyxjz.setHorizontalAlignment(2);		
        this.txtsumjgfyxjz.setDataType(1);		
        this.txtsumjgfyxjz.setSupportedEmpty(true);		
        this.txtsumjgfyxjz.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtsumjgfyxjz.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtsumjgfyxjz.setPrecision(10);		
        this.txtsumjgfyxjz.setRequired(false);
        // txtsumjgfcgjz		
        this.txtsumjgfcgjz.setVisible(true);		
        this.txtsumjgfcgjz.setHorizontalAlignment(2);		
        this.txtsumjgfcgjz.setDataType(1);		
        this.txtsumjgfcgjz.setSupportedEmpty(true);		
        this.txtsumjgfcgjz.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtsumjgfcgjz.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtsumjgfcgjz.setPrecision(10);		
        this.txtsumjgfcgjz.setRequired(false);
        // txtsumjgfknw		
        this.txtsumjgfknw.setVisible(true);		
        this.txtsumjgfknw.setHorizontalAlignment(2);		
        this.txtsumjgfknw.setDataType(1);		
        this.txtsumjgfknw.setSupportedEmpty(true);		
        this.txtsumjgfknw.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtsumjgfknw.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtsumjgfknw.setPrecision(10);		
        this.txtsumjgfknw.setRequired(false);
        // txtsumjgfxf		
        this.txtsumjgfxf.setVisible(true);		
        this.txtsumjgfxf.setHorizontalAlignment(2);		
        this.txtsumjgfxf.setDataType(1);		
        this.txtsumjgfxf.setSupportedEmpty(true);		
        this.txtsumjgfxf.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtsumjgfxf.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtsumjgfxf.setPrecision(10);		
        this.txtsumjgfxf.setRequired(false);
        // txtsumjgfey		
        this.txtsumjgfey.setVisible(true);		
        this.txtsumjgfey.setHorizontalAlignment(2);		
        this.txtsumjgfey.setDataType(1);		
        this.txtsumjgfey.setSupportedEmpty(true);		
        this.txtsumjgfey.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtsumjgfey.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtsumjgfey.setPrecision(10);		
        this.txtsumjgfey.setRequired(false);
        // txtsumjgfyz		
        this.txtsumjgfyz.setVisible(true);		
        this.txtsumjgfyz.setHorizontalAlignment(2);		
        this.txtsumjgfyz.setDataType(1);		
        this.txtsumjgfyz.setSupportedEmpty(true);		
        this.txtsumjgfyz.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtsumjgfyz.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtsumjgfyz.setPrecision(10);		
        this.txtsumjgfyz.setRequired(false);
        // txtsumjgfmb		
        this.txtsumjgfmb.setVisible(true);		
        this.txtsumjgfmb.setHorizontalAlignment(2);		
        this.txtsumjgfmb.setDataType(1);		
        this.txtsumjgfmb.setSupportedEmpty(true);		
        this.txtsumjgfmb.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtsumjgfmb.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtsumjgfmb.setPrecision(10);		
        this.txtsumjgfmb.setRequired(false);
        // kDTabbedPane1
        // kDPanel1
        // kDPanel2
        // contxhzz		
        this.contxhzz.setBoundLabelText(resHelper.getString("contxhzz.boundLabelText"));		
        this.contxhzz.setBoundLabelLength(100);		
        this.contxhzz.setBoundLabelUnderline(true);		
        this.contxhzz.setVisible(true);
        // contxhyxjz		
        this.contxhyxjz.setBoundLabelText(resHelper.getString("contxhyxjz.boundLabelText"));		
        this.contxhyxjz.setBoundLabelLength(100);		
        this.contxhyxjz.setBoundLabelUnderline(true);		
        this.contxhyxjz.setVisible(true);
        // contxhcgjz		
        this.contxhcgjz.setBoundLabelText(resHelper.getString("contxhcgjz.boundLabelText"));		
        this.contxhcgjz.setBoundLabelLength(100);		
        this.contxhcgjz.setBoundLabelUnderline(true);		
        this.contxhcgjz.setVisible(true);
        // contxhknw		
        this.contxhknw.setBoundLabelText(resHelper.getString("contxhknw.boundLabelText"));		
        this.contxhknw.setBoundLabelLength(100);		
        this.contxhknw.setBoundLabelUnderline(true);		
        this.contxhknw.setVisible(true);
        // contxhxf		
        this.contxhxf.setBoundLabelText(resHelper.getString("contxhxf.boundLabelText"));		
        this.contxhxf.setBoundLabelLength(100);		
        this.contxhxf.setBoundLabelUnderline(true);		
        this.contxhxf.setVisible(true);
        // contxhey		
        this.contxhey.setBoundLabelText(resHelper.getString("contxhey.boundLabelText"));		
        this.contxhey.setBoundLabelLength(100);		
        this.contxhey.setBoundLabelUnderline(true);		
        this.contxhey.setVisible(true);
        // contxhyz		
        this.contxhyz.setBoundLabelText(resHelper.getString("contxhyz.boundLabelText"));		
        this.contxhyz.setBoundLabelLength(100);		
        this.contxhyz.setBoundLabelUnderline(true);		
        this.contxhyz.setVisible(true);
        // contxhmb		
        this.contxhmb.setBoundLabelText(resHelper.getString("contxhmb.boundLabelText"));		
        this.contxhmb.setBoundLabelLength(100);		
        this.contxhmb.setBoundLabelUnderline(true);		
        this.contxhmb.setVisible(true);
        // txtxhzz		
        this.txtxhzz.setHorizontalAlignment(2);		
        this.txtxhzz.setDataType(1);		
        this.txtxhzz.setSupportedEmpty(true);		
        this.txtxhzz.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtxhzz.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtxhzz.setPrecision(10);		
        this.txtxhzz.setRequired(false);
        // txtxhyxjz		
        this.txtxhyxjz.setHorizontalAlignment(2);		
        this.txtxhyxjz.setDataType(1);		
        this.txtxhyxjz.setSupportedEmpty(true);		
        this.txtxhyxjz.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtxhyxjz.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtxhyxjz.setPrecision(10);		
        this.txtxhyxjz.setRequired(false);
        // txtxhcgjz		
        this.txtxhcgjz.setHorizontalAlignment(2);		
        this.txtxhcgjz.setDataType(1);		
        this.txtxhcgjz.setSupportedEmpty(true);		
        this.txtxhcgjz.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtxhcgjz.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtxhcgjz.setPrecision(10);		
        this.txtxhcgjz.setRequired(false);
        // txtxhknw		
        this.txtxhknw.setHorizontalAlignment(2);		
        this.txtxhknw.setDataType(1);		
        this.txtxhknw.setSupportedEmpty(true);		
        this.txtxhknw.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtxhknw.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtxhknw.setPrecision(10);		
        this.txtxhknw.setRequired(false);
        // txtxhxf		
        this.txtxhxf.setHorizontalAlignment(2);		
        this.txtxhxf.setDataType(1);		
        this.txtxhxf.setSupportedEmpty(true);		
        this.txtxhxf.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtxhxf.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtxhxf.setPrecision(10);		
        this.txtxhxf.setRequired(false);
        // txtxhey		
        this.txtxhey.setHorizontalAlignment(2);		
        this.txtxhey.setDataType(1);		
        this.txtxhey.setSupportedEmpty(true);		
        this.txtxhey.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtxhey.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtxhey.setPrecision(10);		
        this.txtxhey.setRequired(false);
        // txtxhyz		
        this.txtxhyz.setHorizontalAlignment(2);		
        this.txtxhyz.setDataType(1);		
        this.txtxhyz.setSupportedEmpty(true);		
        this.txtxhyz.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtxhyz.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtxhyz.setPrecision(10);		
        this.txtxhyz.setRequired(false);
        // txtxhmb		
        this.txtxhmb.setHorizontalAlignment(2);		
        this.txtxhmb.setDataType(1);		
        this.txtxhmb.setSupportedEmpty(true);		
        this.txtxhmb.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtxhmb.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtxhmb.setPrecision(10);		
        this.txtxhmb.setRequired(false);
        // contjgfyxjz		
        this.contjgfyxjz.setBoundLabelText(resHelper.getString("contjgfyxjz.boundLabelText"));		
        this.contjgfyxjz.setBoundLabelLength(100);		
        this.contjgfyxjz.setBoundLabelUnderline(true);		
        this.contjgfyxjz.setVisible(true);
        // contjgfcgjz		
        this.contjgfcgjz.setBoundLabelText(resHelper.getString("contjgfcgjz.boundLabelText"));		
        this.contjgfcgjz.setBoundLabelLength(100);		
        this.contjgfcgjz.setBoundLabelUnderline(true);		
        this.contjgfcgjz.setVisible(true);
        // contjgfknw		
        this.contjgfknw.setBoundLabelText(resHelper.getString("contjgfknw.boundLabelText"));		
        this.contjgfknw.setBoundLabelLength(100);		
        this.contjgfknw.setBoundLabelUnderline(true);		
        this.contjgfknw.setVisible(true);
        // contjgfxf		
        this.contjgfxf.setBoundLabelText(resHelper.getString("contjgfxf.boundLabelText"));		
        this.contjgfxf.setBoundLabelLength(100);		
        this.contjgfxf.setBoundLabelUnderline(true);		
        this.contjgfxf.setVisible(true);
        // contjgfey		
        this.contjgfey.setBoundLabelText(resHelper.getString("contjgfey.boundLabelText"));		
        this.contjgfey.setBoundLabelLength(100);		
        this.contjgfey.setBoundLabelUnderline(true);		
        this.contjgfey.setVisible(true);
        // contjgfyz		
        this.contjgfyz.setBoundLabelText(resHelper.getString("contjgfyz.boundLabelText"));		
        this.contjgfyz.setBoundLabelLength(100);		
        this.contjgfyz.setBoundLabelUnderline(true);		
        this.contjgfyz.setVisible(true);
        // contjgfmb		
        this.contjgfmb.setBoundLabelText(resHelper.getString("contjgfmb.boundLabelText"));		
        this.contjgfmb.setBoundLabelLength(100);		
        this.contjgfmb.setBoundLabelUnderline(true);		
        this.contjgfmb.setVisible(true);
        // contjgfzz		
        this.contjgfzz.setBoundLabelText(resHelper.getString("contjgfzz.boundLabelText"));		
        this.contjgfzz.setBoundLabelLength(100);		
        this.contjgfzz.setBoundLabelUnderline(true);		
        this.contjgfzz.setVisible(true);
        // txtjgfyxjz		
        this.txtjgfyxjz.setHorizontalAlignment(2);		
        this.txtjgfyxjz.setDataType(1);		
        this.txtjgfyxjz.setSupportedEmpty(true);		
        this.txtjgfyxjz.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtjgfyxjz.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtjgfyxjz.setPrecision(10);		
        this.txtjgfyxjz.setRequired(false);
        // txtjgfcgjz		
        this.txtjgfcgjz.setHorizontalAlignment(2);		
        this.txtjgfcgjz.setDataType(1);		
        this.txtjgfcgjz.setSupportedEmpty(true);		
        this.txtjgfcgjz.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtjgfcgjz.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtjgfcgjz.setPrecision(10);		
        this.txtjgfcgjz.setRequired(false);
        // txtjgfknw		
        this.txtjgfknw.setHorizontalAlignment(2);		
        this.txtjgfknw.setDataType(1);		
        this.txtjgfknw.setSupportedEmpty(true);		
        this.txtjgfknw.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtjgfknw.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtjgfknw.setPrecision(10);		
        this.txtjgfknw.setRequired(false);
        // txtjgfxf		
        this.txtjgfxf.setHorizontalAlignment(2);		
        this.txtjgfxf.setDataType(1);		
        this.txtjgfxf.setSupportedEmpty(true);		
        this.txtjgfxf.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtjgfxf.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtjgfxf.setPrecision(10);		
        this.txtjgfxf.setRequired(false);
        // txtjgfey		
        this.txtjgfey.setHorizontalAlignment(2);		
        this.txtjgfey.setDataType(1);		
        this.txtjgfey.setSupportedEmpty(true);		
        this.txtjgfey.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtjgfey.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtjgfey.setPrecision(10);		
        this.txtjgfey.setRequired(false);
        // txtjgfyz		
        this.txtjgfyz.setHorizontalAlignment(2);		
        this.txtjgfyz.setDataType(1);		
        this.txtjgfyz.setSupportedEmpty(true);		
        this.txtjgfyz.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtjgfyz.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtjgfyz.setPrecision(10);		
        this.txtjgfyz.setRequired(false);
        // txtjgfmb		
        this.txtjgfmb.setHorizontalAlignment(2);		
        this.txtjgfmb.setDataType(1);		
        this.txtjgfmb.setSupportedEmpty(true);		
        this.txtjgfmb.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtjgfmb.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtjgfmb.setPrecision(10);		
        this.txtjgfmb.setRequired(false);
        // txtjgfzz		
        this.txtjgfzz.setHorizontalAlignment(2);		
        this.txtjgfzz.setDataType(1);		
        this.txtjgfzz.setSupportedEmpty(true);		
        this.txtjgfzz.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtjgfzz.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtjgfzz.setPrecision(10);		
        this.txtjgfzz.setRequired(false);
        // kDTabbedPane3
        // kDPanel6
        // kDPanel5
        // contallxhzz		
        this.contallxhzz.setBoundLabelText(resHelper.getString("contallxhzz.boundLabelText"));		
        this.contallxhzz.setBoundLabelLength(100);		
        this.contallxhzz.setBoundLabelUnderline(true);		
        this.contallxhzz.setVisible(true);
        // contallxhyxjz		
        this.contallxhyxjz.setBoundLabelText(resHelper.getString("contallxhyxjz.boundLabelText"));		
        this.contallxhyxjz.setBoundLabelLength(100);		
        this.contallxhyxjz.setBoundLabelUnderline(true);		
        this.contallxhyxjz.setVisible(true);
        // contallxhcgjz		
        this.contallxhcgjz.setBoundLabelText(resHelper.getString("contallxhcgjz.boundLabelText"));		
        this.contallxhcgjz.setBoundLabelLength(100);		
        this.contallxhcgjz.setBoundLabelUnderline(true);		
        this.contallxhcgjz.setVisible(true);
        // contallzhknw		
        this.contallzhknw.setBoundLabelText(resHelper.getString("contallzhknw.boundLabelText"));		
        this.contallzhknw.setBoundLabelLength(100);		
        this.contallzhknw.setBoundLabelUnderline(true);		
        this.contallzhknw.setVisible(true);
        // contallxhxf		
        this.contallxhxf.setBoundLabelText(resHelper.getString("contallxhxf.boundLabelText"));		
        this.contallxhxf.setBoundLabelLength(100);		
        this.contallxhxf.setBoundLabelUnderline(true);		
        this.contallxhxf.setVisible(true);
        // contallxhey		
        this.contallxhey.setBoundLabelText(resHelper.getString("contallxhey.boundLabelText"));		
        this.contallxhey.setBoundLabelLength(100);		
        this.contallxhey.setBoundLabelUnderline(true);		
        this.contallxhey.setVisible(true);
        // contallxhyz		
        this.contallxhyz.setBoundLabelText(resHelper.getString("contallxhyz.boundLabelText"));		
        this.contallxhyz.setBoundLabelLength(100);		
        this.contallxhyz.setBoundLabelUnderline(true);		
        this.contallxhyz.setVisible(true);
        // contallxhmb		
        this.contallxhmb.setBoundLabelText(resHelper.getString("contallxhmb.boundLabelText"));		
        this.contallxhmb.setBoundLabelLength(100);		
        this.contallxhmb.setBoundLabelUnderline(true);		
        this.contallxhmb.setVisible(true);
        // txtallxhzz		
        this.txtallxhzz.setVisible(true);		
        this.txtallxhzz.setHorizontalAlignment(2);		
        this.txtallxhzz.setDataType(1);		
        this.txtallxhzz.setSupportedEmpty(true);		
        this.txtallxhzz.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtallxhzz.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtallxhzz.setPrecision(10);		
        this.txtallxhzz.setRequired(false);
        // txtallxhyxjz		
        this.txtallxhyxjz.setVisible(true);		
        this.txtallxhyxjz.setHorizontalAlignment(2);		
        this.txtallxhyxjz.setDataType(1);		
        this.txtallxhyxjz.setSupportedEmpty(true);		
        this.txtallxhyxjz.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtallxhyxjz.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtallxhyxjz.setPrecision(10);		
        this.txtallxhyxjz.setRequired(false);
        // txtallxhcgjz		
        this.txtallxhcgjz.setVisible(true);		
        this.txtallxhcgjz.setHorizontalAlignment(2);		
        this.txtallxhcgjz.setDataType(1);		
        this.txtallxhcgjz.setSupportedEmpty(true);		
        this.txtallxhcgjz.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtallxhcgjz.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtallxhcgjz.setPrecision(10);		
        this.txtallxhcgjz.setRequired(false);
        // txtallzhknw		
        this.txtallzhknw.setVisible(true);		
        this.txtallzhknw.setHorizontalAlignment(2);		
        this.txtallzhknw.setDataType(1);		
        this.txtallzhknw.setSupportedEmpty(true);		
        this.txtallzhknw.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtallzhknw.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtallzhknw.setPrecision(10);		
        this.txtallzhknw.setRequired(false);
        // txtallxhxf		
        this.txtallxhxf.setVisible(true);		
        this.txtallxhxf.setHorizontalAlignment(2);		
        this.txtallxhxf.setDataType(1);		
        this.txtallxhxf.setSupportedEmpty(true);		
        this.txtallxhxf.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtallxhxf.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtallxhxf.setPrecision(10);		
        this.txtallxhxf.setRequired(false);
        // txtallxhey		
        this.txtallxhey.setVisible(true);		
        this.txtallxhey.setHorizontalAlignment(2);		
        this.txtallxhey.setDataType(1);		
        this.txtallxhey.setSupportedEmpty(true);		
        this.txtallxhey.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtallxhey.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtallxhey.setPrecision(10);		
        this.txtallxhey.setRequired(false);
        // txtallxhyz		
        this.txtallxhyz.setVisible(true);		
        this.txtallxhyz.setHorizontalAlignment(2);		
        this.txtallxhyz.setDataType(1);		
        this.txtallxhyz.setSupportedEmpty(true);		
        this.txtallxhyz.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtallxhyz.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtallxhyz.setPrecision(10);		
        this.txtallxhyz.setRequired(false);
        // txtallxhmb		
        this.txtallxhmb.setVisible(true);		
        this.txtallxhmb.setHorizontalAlignment(2);		
        this.txtallxhmb.setDataType(1);		
        this.txtallxhmb.setSupportedEmpty(true);		
        this.txtallxhmb.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtallxhmb.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtallxhmb.setPrecision(10);		
        this.txtallxhmb.setRequired(false);
        // contalljgfzz		
        this.contalljgfzz.setBoundLabelText(resHelper.getString("contalljgfzz.boundLabelText"));		
        this.contalljgfzz.setBoundLabelLength(100);		
        this.contalljgfzz.setBoundLabelUnderline(true);		
        this.contalljgfzz.setVisible(true);
        // contalljgfyxjz		
        this.contalljgfyxjz.setBoundLabelText(resHelper.getString("contalljgfyxjz.boundLabelText"));		
        this.contalljgfyxjz.setBoundLabelLength(100);		
        this.contalljgfyxjz.setBoundLabelUnderline(true);		
        this.contalljgfyxjz.setVisible(true);
        // contalljgfcgjz		
        this.contalljgfcgjz.setBoundLabelText(resHelper.getString("contalljgfcgjz.boundLabelText"));		
        this.contalljgfcgjz.setBoundLabelLength(100);		
        this.contalljgfcgjz.setBoundLabelUnderline(true);		
        this.contalljgfcgjz.setVisible(true);
        // contalljgfknw		
        this.contalljgfknw.setBoundLabelText(resHelper.getString("contalljgfknw.boundLabelText"));		
        this.contalljgfknw.setBoundLabelLength(100);		
        this.contalljgfknw.setBoundLabelUnderline(true);		
        this.contalljgfknw.setVisible(true);
        // contalljgfxf		
        this.contalljgfxf.setBoundLabelText(resHelper.getString("contalljgfxf.boundLabelText"));		
        this.contalljgfxf.setBoundLabelLength(100);		
        this.contalljgfxf.setBoundLabelUnderline(true);		
        this.contalljgfxf.setVisible(true);
        // contalljgfey		
        this.contalljgfey.setBoundLabelText(resHelper.getString("contalljgfey.boundLabelText"));		
        this.contalljgfey.setBoundLabelLength(100);		
        this.contalljgfey.setBoundLabelUnderline(true);		
        this.contalljgfey.setVisible(true);
        // contalljgfyz		
        this.contalljgfyz.setBoundLabelText(resHelper.getString("contalljgfyz.boundLabelText"));		
        this.contalljgfyz.setBoundLabelLength(100);		
        this.contalljgfyz.setBoundLabelUnderline(true);		
        this.contalljgfyz.setVisible(true);
        // contalljgdmb		
        this.contalljgdmb.setBoundLabelText(resHelper.getString("contalljgdmb.boundLabelText"));		
        this.contalljgdmb.setBoundLabelLength(100);		
        this.contalljgdmb.setBoundLabelUnderline(true);		
        this.contalljgdmb.setVisible(true);
        // txtalljgfzz		
        this.txtalljgfzz.setVisible(true);		
        this.txtalljgfzz.setHorizontalAlignment(2);		
        this.txtalljgfzz.setDataType(1);		
        this.txtalljgfzz.setSupportedEmpty(true);		
        this.txtalljgfzz.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtalljgfzz.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtalljgfzz.setPrecision(10);		
        this.txtalljgfzz.setRequired(false);
        // txtalljgfyxjz		
        this.txtalljgfyxjz.setVisible(true);		
        this.txtalljgfyxjz.setHorizontalAlignment(2);		
        this.txtalljgfyxjz.setDataType(1);		
        this.txtalljgfyxjz.setSupportedEmpty(true);		
        this.txtalljgfyxjz.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtalljgfyxjz.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtalljgfyxjz.setPrecision(10);		
        this.txtalljgfyxjz.setRequired(false);
        // txtalljgfcgjz		
        this.txtalljgfcgjz.setVisible(true);		
        this.txtalljgfcgjz.setHorizontalAlignment(2);		
        this.txtalljgfcgjz.setDataType(1);		
        this.txtalljgfcgjz.setSupportedEmpty(true);		
        this.txtalljgfcgjz.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtalljgfcgjz.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtalljgfcgjz.setPrecision(10);		
        this.txtalljgfcgjz.setRequired(false);
        // txtalljgfknw		
        this.txtalljgfknw.setVisible(true);		
        this.txtalljgfknw.setHorizontalAlignment(2);		
        this.txtalljgfknw.setDataType(1);		
        this.txtalljgfknw.setSupportedEmpty(true);		
        this.txtalljgfknw.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtalljgfknw.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtalljgfknw.setPrecision(10);		
        this.txtalljgfknw.setRequired(false);
        // txtalljgfxf		
        this.txtalljgfxf.setVisible(true);		
        this.txtalljgfxf.setHorizontalAlignment(2);		
        this.txtalljgfxf.setDataType(1);		
        this.txtalljgfxf.setSupportedEmpty(true);		
        this.txtalljgfxf.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtalljgfxf.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtalljgfxf.setPrecision(10);		
        this.txtalljgfxf.setRequired(false);
        // txtalljgfey		
        this.txtalljgfey.setVisible(true);		
        this.txtalljgfey.setHorizontalAlignment(2);		
        this.txtalljgfey.setDataType(1);		
        this.txtalljgfey.setSupportedEmpty(true);		
        this.txtalljgfey.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtalljgfey.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtalljgfey.setPrecision(10);		
        this.txtalljgfey.setRequired(false);
        // txtalljgfyz		
        this.txtalljgfyz.setVisible(true);		
        this.txtalljgfyz.setHorizontalAlignment(2);		
        this.txtalljgfyz.setDataType(1);		
        this.txtalljgfyz.setSupportedEmpty(true);		
        this.txtalljgfyz.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtalljgfyz.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtalljgfyz.setPrecision(10);		
        this.txtalljgfyz.setRequired(false);
        // txtalljgdmb		
        this.txtalljgdmb.setVisible(true);		
        this.txtalljgdmb.setHorizontalAlignment(2);		
        this.txtalljgdmb.setDataType(1);		
        this.txtalljgdmb.setSupportedEmpty(true);		
        this.txtalljgdmb.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtalljgdmb.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtalljgdmb.setPrecision(10);		
        this.txtalljgdmb.setRequired(false);
        // txtremake		
        this.txtremake.setVisible(true);		
        this.txtremake.setHorizontalAlignment(2);		
        this.txtremake.setMaxLength(255);		
        this.txtremake.setRequired(false);
        // auditCost
        this.auditCost.setAction((IItemAction)ActionProxyFactory.getProxy(actionAuditCost, new Class[] { IItemAction.class }, getServiceContext()));		
        this.auditCost.setText(resHelper.getString("auditCost.text"));
        // unauditCost
        this.unauditCost.setAction((IItemAction)ActionProxyFactory.getProxy(actionUnAuditCost, new Class[] { IItemAction.class }, getServiceContext()));		
        this.unauditCost.setText(resHelper.getString("unauditCost.text"));
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {txtNumber,pkBizDate,txtDescription,prmtAuditor,prmtCreator,kDDateCreateTime,prmtLastUpdateUser,kDDateLastUpdateTime,txtdoctorNumber,txtdoctorName,txtperiod,txtjgfzz,txtjgfyxjz,txtjgfcgjz,txtjgfknw,txtjgfxf,txtjgfey,txtjgfyz,txtjgfmb,txtxhzz,txtxhyxjz,txtxhcgjz,txtxhknw,txtxhxf,txtxhey,txtxhyz,txtclinicNumber,txtclinicName,txtxhmb,txtcityNumber,txtcityName,status,txtsumxhzz,txtsumxhyxjz,txtsumxhcgjz,txtsumxhknw,txtsumxhxf,txtsumxhey,txtsumxhyz,txtsumxhmb,txtsumjgfzz,txtsumjgfyxjz,txtsumjgfcgjz,txtsumjgfknw,txtsumjgfxf,txtsumjgfey,txtsumjgfyz,txtsumjgfmb,txtalljgfzz,txtalljgfyxjz,txtalljgfcgjz,txtalljgfknw,txtalljgfxf,txtalljgfey,txtalljgfyz,txtalljgdmb,txtallxhzz,txtallxhyxjz,txtallxhcgjz,txtallzhknw,txtallxhxf,txtallxhey,txtallxhyz,txtallxhmb,prmtdoctor,txtremake,chkiszidai}));
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
        this.setBounds(new Rectangle(0, 0, 1013, 704));
        this.setLayout(null);
        contCreator.setBounds(new Rectangle(16, 733, 270, 19));
        this.add(contCreator, null);
        contCreateTime.setBounds(new Rectangle(347, 733, 270, 19));
        this.add(contCreateTime, null);
        contLastUpdateUser.setBounds(new Rectangle(678, 733, 270, 19));
        this.add(contLastUpdateUser, null);
        contLastUpdateTime.setBounds(new Rectangle(347, 757, 270, 19));
        this.add(contLastUpdateTime, null);
        contNumber.setBounds(new Rectangle(16, 757, 270, 19));
        this.add(contNumber, null);
        contBizDate.setBounds(new Rectangle(678, 757, 270, 19));
        this.add(contBizDate, null);
        contDescription.setBounds(new Rectangle(347, 781, 270, 19));
        this.add(contDescription, null);
        contAuditor.setBounds(new Rectangle(678, 781, 270, 19));
        this.add(contAuditor, null);
        contdoctorNumber.setBounds(new Rectangle(341, 58, 270, 19));
        this.add(contdoctorNumber, null);
        contdoctorName.setBounds(new Rectangle(10, 58, 270, 19));
        this.add(contdoctorName, null);
        contperiod.setBounds(new Rectangle(672, 10, 270, 19));
        this.add(contperiod, null);
        contclinicNumber.setBounds(new Rectangle(10, 34, 270, 19));
        this.add(contclinicNumber, null);
        contclinicName.setBounds(new Rectangle(341, 34, 270, 19));
        this.add(contclinicName, null);
        contcityNumber.setBounds(new Rectangle(10, 10, 270, 19));
        this.add(contcityNumber, null);
        contcityName.setBounds(new Rectangle(341, 10, 270, 19));
        this.add(contcityName, null);
        contstatus.setBounds(new Rectangle(16, 781, 270, 19));
        this.add(contstatus, null);
        contdoctor.setBounds(new Rectangle(672, 34, 270, 19));
        this.add(contdoctor, null);
        kDContainer1.setBounds(new Rectangle(10, 106, 950, 180));
        this.add(kDContainer1, null);
        kDContainer2.setBounds(new Rectangle(10, 298, 950, 180));
        this.add(kDContainer2, null);
        kDContainer3.setBounds(new Rectangle(10, 493, 950, 180));
        this.add(kDContainer3, null);
        contremake.setBounds(new Rectangle(10, 82, 600, 19));
        this.add(contremake, null);
        chkiszidai.setBounds(new Rectangle(672, 58, 270, 19));
        this.add(chkiszidai, null);
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
        //contdoctorNumber
        contdoctorNumber.setBoundEditor(txtdoctorNumber);
        //contdoctorName
        contdoctorName.setBoundEditor(txtdoctorName);
        //contperiod
        contperiod.setBoundEditor(txtperiod);
        //contclinicNumber
        contclinicNumber.setBoundEditor(txtclinicNumber);
        //contclinicName
        contclinicName.setBoundEditor(txtclinicName);
        //contcityNumber
        contcityNumber.setBoundEditor(txtcityNumber);
        //contcityName
        contcityName.setBoundEditor(txtcityName);
        //contstatus
        contstatus.setBoundEditor(status);
        //contdoctor
        contdoctor.setBoundEditor(prmtdoctor);
        //kDContainer1
        kDContainer1.getContentPane().setLayout(null);        kDTabbedPane2.setBounds(new Rectangle(-1, -1, 947, 160));
        kDContainer1.getContentPane().add(kDTabbedPane2, null);
        //kDTabbedPane2
        kDTabbedPane2.add(kDPanel3, resHelper.getString("kDPanel3.constraints"));
        kDTabbedPane2.add(kDPanel4, resHelper.getString("kDPanel4.constraints"));
        //kDPanel3
        kDPanel3.setLayout(null);        contsumxhzz.setBounds(new Rectangle(25, 18, 270, 19));
        kDPanel3.add(contsumxhzz, null);
        contsumxhyxjz.setBounds(new Rectangle(327, 18, 270, 19));
        kDPanel3.add(contsumxhyxjz, null);
        contsumxhcgjz.setBounds(new Rectangle(643, 18, 270, 19));
        kDPanel3.add(contsumxhcgjz, null);
        contsumxhknw.setBounds(new Rectangle(25, 52, 270, 19));
        kDPanel3.add(contsumxhknw, null);
        contsumxhxf.setBounds(new Rectangle(327, 52, 270, 19));
        kDPanel3.add(contsumxhxf, null);
        contsumxhey.setBounds(new Rectangle(643, 52, 270, 19));
        kDPanel3.add(contsumxhey, null);
        contsumxhyz.setBounds(new Rectangle(25, 90, 270, 19));
        kDPanel3.add(contsumxhyz, null);
        contsumxhmb.setBounds(new Rectangle(327, 90, 270, 19));
        kDPanel3.add(contsumxhmb, null);
        //contsumxhzz
        contsumxhzz.setBoundEditor(txtsumxhzz);
        //contsumxhyxjz
        contsumxhyxjz.setBoundEditor(txtsumxhyxjz);
        //contsumxhcgjz
        contsumxhcgjz.setBoundEditor(txtsumxhcgjz);
        //contsumxhknw
        contsumxhknw.setBoundEditor(txtsumxhknw);
        //contsumxhxf
        contsumxhxf.setBoundEditor(txtsumxhxf);
        //contsumxhey
        contsumxhey.setBoundEditor(txtsumxhey);
        //contsumxhyz
        contsumxhyz.setBoundEditor(txtsumxhyz);
        //contsumxhmb
        contsumxhmb.setBoundEditor(txtsumxhmb);
        //kDPanel4
        kDPanel4.setLayout(null);        contsumjgfzz.setBounds(new Rectangle(25, 18, 270, 19));
        kDPanel4.add(contsumjgfzz, null);
        contsumjgfyxjz.setBounds(new Rectangle(327, 18, 270, 19));
        kDPanel4.add(contsumjgfyxjz, null);
        contsumjgfcgjz.setBounds(new Rectangle(643, 18, 270, 19));
        kDPanel4.add(contsumjgfcgjz, null);
        contsumjgfknw.setBounds(new Rectangle(25, 52, 270, 19));
        kDPanel4.add(contsumjgfknw, null);
        contsumjgfxf.setBounds(new Rectangle(327, 52, 270, 19));
        kDPanel4.add(contsumjgfxf, null);
        contsumjgfey.setBounds(new Rectangle(643, 52, 270, 19));
        kDPanel4.add(contsumjgfey, null);
        contsumjgfyz.setBounds(new Rectangle(25, 90, 270, 19));
        kDPanel4.add(contsumjgfyz, null);
        contsumjgfmb.setBounds(new Rectangle(327, 90, 270, 19));
        kDPanel4.add(contsumjgfmb, null);
        //contsumjgfzz
        contsumjgfzz.setBoundEditor(txtsumjgfzz);
        //contsumjgfyxjz
        contsumjgfyxjz.setBoundEditor(txtsumjgfyxjz);
        //contsumjgfcgjz
        contsumjgfcgjz.setBoundEditor(txtsumjgfcgjz);
        //contsumjgfknw
        contsumjgfknw.setBoundEditor(txtsumjgfknw);
        //contsumjgfxf
        contsumjgfxf.setBoundEditor(txtsumjgfxf);
        //contsumjgfey
        contsumjgfey.setBoundEditor(txtsumjgfey);
        //contsumjgfyz
        contsumjgfyz.setBoundEditor(txtsumjgfyz);
        //contsumjgfmb
        contsumjgfmb.setBoundEditor(txtsumjgfmb);
        //kDContainer2
        kDContainer2.getContentPane().setLayout(null);        kDTabbedPane1.setBounds(new Rectangle(0, 0, 947, 174));
        kDContainer2.getContentPane().add(kDTabbedPane1, null);
        //kDTabbedPane1
        kDTabbedPane1.add(kDPanel1, resHelper.getString("kDPanel1.constraints"));
        kDTabbedPane1.add(kDPanel2, resHelper.getString("kDPanel2.constraints"));
        //kDPanel1
        kDPanel1.setLayout(null);        contxhzz.setBounds(new Rectangle(25, 18, 270, 19));
        kDPanel1.add(contxhzz, null);
        contxhyxjz.setBounds(new Rectangle(327, 18, 270, 19));
        kDPanel1.add(contxhyxjz, null);
        contxhcgjz.setBounds(new Rectangle(643, 18, 270, 19));
        kDPanel1.add(contxhcgjz, null);
        contxhknw.setBounds(new Rectangle(25, 52, 270, 19));
        kDPanel1.add(contxhknw, null);
        contxhxf.setBounds(new Rectangle(327, 52, 270, 19));
        kDPanel1.add(contxhxf, null);
        contxhey.setBounds(new Rectangle(643, 52, 270, 19));
        kDPanel1.add(contxhey, null);
        contxhyz.setBounds(new Rectangle(25, 90, 270, 19));
        kDPanel1.add(contxhyz, null);
        contxhmb.setBounds(new Rectangle(327, 90, 270, 19));
        kDPanel1.add(contxhmb, null);
        //contxhzz
        contxhzz.setBoundEditor(txtxhzz);
        //contxhyxjz
        contxhyxjz.setBoundEditor(txtxhyxjz);
        //contxhcgjz
        contxhcgjz.setBoundEditor(txtxhcgjz);
        //contxhknw
        contxhknw.setBoundEditor(txtxhknw);
        //contxhxf
        contxhxf.setBoundEditor(txtxhxf);
        //contxhey
        contxhey.setBoundEditor(txtxhey);
        //contxhyz
        contxhyz.setBoundEditor(txtxhyz);
        //contxhmb
        contxhmb.setBoundEditor(txtxhmb);
        //kDPanel2
        kDPanel2.setLayout(null);        contjgfyxjz.setBounds(new Rectangle(327, 18, 270, 19));
        kDPanel2.add(contjgfyxjz, null);
        contjgfcgjz.setBounds(new Rectangle(643, 18, 270, 19));
        kDPanel2.add(contjgfcgjz, null);
        contjgfknw.setBounds(new Rectangle(25, 52, 270, 19));
        kDPanel2.add(contjgfknw, null);
        contjgfxf.setBounds(new Rectangle(327, 52, 270, 19));
        kDPanel2.add(contjgfxf, null);
        contjgfey.setBounds(new Rectangle(643, 52, 270, 19));
        kDPanel2.add(contjgfey, null);
        contjgfyz.setBounds(new Rectangle(25, 90, 270, 19));
        kDPanel2.add(contjgfyz, null);
        contjgfmb.setBounds(new Rectangle(327, 90, 270, 19));
        kDPanel2.add(contjgfmb, null);
        contjgfzz.setBounds(new Rectangle(25, 18, 270, 19));
        kDPanel2.add(contjgfzz, null);
        //contjgfyxjz
        contjgfyxjz.setBoundEditor(txtjgfyxjz);
        //contjgfcgjz
        contjgfcgjz.setBoundEditor(txtjgfcgjz);
        //contjgfknw
        contjgfknw.setBoundEditor(txtjgfknw);
        //contjgfxf
        contjgfxf.setBoundEditor(txtjgfxf);
        //contjgfey
        contjgfey.setBoundEditor(txtjgfey);
        //contjgfyz
        contjgfyz.setBoundEditor(txtjgfyz);
        //contjgfmb
        contjgfmb.setBoundEditor(txtjgfmb);
        //contjgfzz
        contjgfzz.setBoundEditor(txtjgfzz);
        //kDContainer3
        kDContainer3.getContentPane().setLayout(null);        kDTabbedPane3.setBounds(new Rectangle(2, 2, 947, 174));
        kDContainer3.getContentPane().add(kDTabbedPane3, null);
        //kDTabbedPane3
        kDTabbedPane3.add(kDPanel6, resHelper.getString("kDPanel6.constraints"));
        kDTabbedPane3.add(kDPanel5, resHelper.getString("kDPanel5.constraints"));
        //kDPanel6
        kDPanel6.setLayout(null);        contallxhzz.setBounds(new Rectangle(25, 18, 270, 19));
        kDPanel6.add(contallxhzz, null);
        contallxhyxjz.setBounds(new Rectangle(327, 18, 270, 19));
        kDPanel6.add(contallxhyxjz, null);
        contallxhcgjz.setBounds(new Rectangle(643, 18, 270, 19));
        kDPanel6.add(contallxhcgjz, null);
        contallzhknw.setBounds(new Rectangle(25, 52, 270, 19));
        kDPanel6.add(contallzhknw, null);
        contallxhxf.setBounds(new Rectangle(327, 52, 270, 19));
        kDPanel6.add(contallxhxf, null);
        contallxhey.setBounds(new Rectangle(643, 52, 270, 19));
        kDPanel6.add(contallxhey, null);
        contallxhyz.setBounds(new Rectangle(25, 90, 270, 19));
        kDPanel6.add(contallxhyz, null);
        contallxhmb.setBounds(new Rectangle(327, 90, 270, 19));
        kDPanel6.add(contallxhmb, null);
        //contallxhzz
        contallxhzz.setBoundEditor(txtallxhzz);
        //contallxhyxjz
        contallxhyxjz.setBoundEditor(txtallxhyxjz);
        //contallxhcgjz
        contallxhcgjz.setBoundEditor(txtallxhcgjz);
        //contallzhknw
        contallzhknw.setBoundEditor(txtallzhknw);
        //contallxhxf
        contallxhxf.setBoundEditor(txtallxhxf);
        //contallxhey
        contallxhey.setBoundEditor(txtallxhey);
        //contallxhyz
        contallxhyz.setBoundEditor(txtallxhyz);
        //contallxhmb
        contallxhmb.setBoundEditor(txtallxhmb);
        //kDPanel5
        kDPanel5.setLayout(null);        contalljgfzz.setBounds(new Rectangle(25, 18, 270, 19));
        kDPanel5.add(contalljgfzz, null);
        contalljgfyxjz.setBounds(new Rectangle(327, 18, 270, 19));
        kDPanel5.add(contalljgfyxjz, null);
        contalljgfcgjz.setBounds(new Rectangle(643, 18, 270, 19));
        kDPanel5.add(contalljgfcgjz, null);
        contalljgfknw.setBounds(new Rectangle(25, 52, 270, 19));
        kDPanel5.add(contalljgfknw, null);
        contalljgfxf.setBounds(new Rectangle(327, 52, 270, 19));
        kDPanel5.add(contalljgfxf, null);
        contalljgfey.setBounds(new Rectangle(643, 52, 270, 19));
        kDPanel5.add(contalljgfey, null);
        contalljgfyz.setBounds(new Rectangle(25, 90, 270, 19));
        kDPanel5.add(contalljgfyz, null);
        contalljgdmb.setBounds(new Rectangle(327, 90, 270, 19));
        kDPanel5.add(contalljgdmb, null);
        //contalljgfzz
        contalljgfzz.setBoundEditor(txtalljgfzz);
        //contalljgfyxjz
        contalljgfyxjz.setBoundEditor(txtalljgfyxjz);
        //contalljgfcgjz
        contalljgfcgjz.setBoundEditor(txtalljgfcgjz);
        //contalljgfknw
        contalljgfknw.setBoundEditor(txtalljgfknw);
        //contalljgfxf
        contalljgfxf.setBoundEditor(txtalljgfxf);
        //contalljgfey
        contalljgfey.setBoundEditor(txtalljgfey);
        //contalljgfyz
        contalljgfyz.setBoundEditor(txtalljgfyz);
        //contalljgdmb
        contalljgdmb.setBoundEditor(txtalljgdmb);
        //contremake
        contremake.setBoundEditor(txtremake);

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
        this.toolBar.add(auditCost);
        this.toolBar.add(btnWFViewSubmitProccess);
        this.toolBar.add(unauditCost);
        this.toolBar.add(btnNextPerson);


    }

	//Regiester control's property binding.
	private void registerBindings(){
		dataBinder.registerBinding("iszidai", boolean.class, this.chkiszidai, "selected");
		dataBinder.registerBinding("creator", com.kingdee.eas.base.permission.UserInfo.class, this.prmtCreator, "data");
		dataBinder.registerBinding("createTime", java.sql.Timestamp.class, this.kDDateCreateTime, "value");
		dataBinder.registerBinding("lastUpdateUser", com.kingdee.eas.base.permission.UserInfo.class, this.prmtLastUpdateUser, "data");
		dataBinder.registerBinding("lastUpdateTime", java.sql.Timestamp.class, this.kDDateLastUpdateTime, "value");
		dataBinder.registerBinding("number", String.class, this.txtNumber, "text");
		dataBinder.registerBinding("bizDate", java.util.Date.class, this.pkBizDate, "value");
		dataBinder.registerBinding("description", String.class, this.txtDescription, "text");
		dataBinder.registerBinding("auditor", com.kingdee.eas.base.permission.UserInfo.class, this.prmtAuditor, "data");
		dataBinder.registerBinding("doctorNumber", String.class, this.txtdoctorNumber, "text");
		dataBinder.registerBinding("doctorName", String.class, this.txtdoctorName, "text");
		dataBinder.registerBinding("period", String.class, this.txtperiod, "text");
		dataBinder.registerBinding("clinicNumber", String.class, this.txtclinicNumber, "text");
		dataBinder.registerBinding("clinicName", String.class, this.txtclinicName, "text");
		dataBinder.registerBinding("cityNumber", String.class, this.txtcityNumber, "text");
		dataBinder.registerBinding("cityName", String.class, this.txtcityName, "text");
		dataBinder.registerBinding("status", com.kingdee.eas.mw.pay.app.UpdateCostStatus.class, this.status, "selectedItem");
		dataBinder.registerBinding("doctor", com.kingdee.eas.basedata.person.PersonInfo.class, this.prmtdoctor, "data");
		dataBinder.registerBinding("sumxhzz", java.math.BigDecimal.class, this.txtsumxhzz, "value");
		dataBinder.registerBinding("sumxhyxjz", java.math.BigDecimal.class, this.txtsumxhyxjz, "value");
		dataBinder.registerBinding("sumxhcgjz", java.math.BigDecimal.class, this.txtsumxhcgjz, "value");
		dataBinder.registerBinding("sumxhknw", java.math.BigDecimal.class, this.txtsumxhknw, "value");
		dataBinder.registerBinding("sumxhxf", java.math.BigDecimal.class, this.txtsumxhxf, "value");
		dataBinder.registerBinding("sumxhey", java.math.BigDecimal.class, this.txtsumxhey, "value");
		dataBinder.registerBinding("sumxhyz", java.math.BigDecimal.class, this.txtsumxhyz, "value");
		dataBinder.registerBinding("sumxhmb", java.math.BigDecimal.class, this.txtsumxhmb, "value");
		dataBinder.registerBinding("sumjgfzz", java.math.BigDecimal.class, this.txtsumjgfzz, "value");
		dataBinder.registerBinding("sumjgfyxjz", java.math.BigDecimal.class, this.txtsumjgfyxjz, "value");
		dataBinder.registerBinding("sumjgfcgjz", java.math.BigDecimal.class, this.txtsumjgfcgjz, "value");
		dataBinder.registerBinding("sumjgfknw", java.math.BigDecimal.class, this.txtsumjgfknw, "value");
		dataBinder.registerBinding("sumjgfxf", java.math.BigDecimal.class, this.txtsumjgfxf, "value");
		dataBinder.registerBinding("sumjgfey", java.math.BigDecimal.class, this.txtsumjgfey, "value");
		dataBinder.registerBinding("sumjgfyz", java.math.BigDecimal.class, this.txtsumjgfyz, "value");
		dataBinder.registerBinding("sumjgfmb", java.math.BigDecimal.class, this.txtsumjgfmb, "value");
		dataBinder.registerBinding("xhzz", java.math.BigDecimal.class, this.txtxhzz, "value");
		dataBinder.registerBinding("xhyxjz", java.math.BigDecimal.class, this.txtxhyxjz, "value");
		dataBinder.registerBinding("xhcgjz", java.math.BigDecimal.class, this.txtxhcgjz, "value");
		dataBinder.registerBinding("xhknw", java.math.BigDecimal.class, this.txtxhknw, "value");
		dataBinder.registerBinding("xhxf", java.math.BigDecimal.class, this.txtxhxf, "value");
		dataBinder.registerBinding("xhey", java.math.BigDecimal.class, this.txtxhey, "value");
		dataBinder.registerBinding("xhyz", java.math.BigDecimal.class, this.txtxhyz, "value");
		dataBinder.registerBinding("xhmb", java.math.BigDecimal.class, this.txtxhmb, "value");
		dataBinder.registerBinding("jgfyxjz", java.math.BigDecimal.class, this.txtjgfyxjz, "value");
		dataBinder.registerBinding("jgfcgjz", java.math.BigDecimal.class, this.txtjgfcgjz, "value");
		dataBinder.registerBinding("jgfknw", java.math.BigDecimal.class, this.txtjgfknw, "value");
		dataBinder.registerBinding("jgfxf", java.math.BigDecimal.class, this.txtjgfxf, "value");
		dataBinder.registerBinding("jgfey", java.math.BigDecimal.class, this.txtjgfey, "value");
		dataBinder.registerBinding("jgfyz", java.math.BigDecimal.class, this.txtjgfyz, "value");
		dataBinder.registerBinding("jgfmb", java.math.BigDecimal.class, this.txtjgfmb, "value");
		dataBinder.registerBinding("jgfzz", java.math.BigDecimal.class, this.txtjgfzz, "value");
		dataBinder.registerBinding("allxhzz", java.math.BigDecimal.class, this.txtallxhzz, "value");
		dataBinder.registerBinding("allxhyxjz", java.math.BigDecimal.class, this.txtallxhyxjz, "value");
		dataBinder.registerBinding("allxhcgjz", java.math.BigDecimal.class, this.txtallxhcgjz, "value");
		dataBinder.registerBinding("allzhknw", java.math.BigDecimal.class, this.txtallzhknw, "value");
		dataBinder.registerBinding("allxhxf", java.math.BigDecimal.class, this.txtallxhxf, "value");
		dataBinder.registerBinding("allxhey", java.math.BigDecimal.class, this.txtallxhey, "value");
		dataBinder.registerBinding("allxhyz", java.math.BigDecimal.class, this.txtallxhyz, "value");
		dataBinder.registerBinding("allxhmb", java.math.BigDecimal.class, this.txtallxhmb, "value");
		dataBinder.registerBinding("alljgfzz", java.math.BigDecimal.class, this.txtalljgfzz, "value");
		dataBinder.registerBinding("alljgfyxjz", java.math.BigDecimal.class, this.txtalljgfyxjz, "value");
		dataBinder.registerBinding("alljgfcgjz", java.math.BigDecimal.class, this.txtalljgfcgjz, "value");
		dataBinder.registerBinding("alljgfknw", java.math.BigDecimal.class, this.txtalljgfknw, "value");
		dataBinder.registerBinding("alljgfxf", java.math.BigDecimal.class, this.txtalljgfxf, "value");
		dataBinder.registerBinding("alljgfey", java.math.BigDecimal.class, this.txtalljgfey, "value");
		dataBinder.registerBinding("alljgfyz", java.math.BigDecimal.class, this.txtalljgfyz, "value");
		dataBinder.registerBinding("alljgdmb", java.math.BigDecimal.class, this.txtalljgdmb, "value");
		dataBinder.registerBinding("remake", String.class, this.txtremake, "text");		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.mw.pay.app.CostByUpdateEditUIHandler";
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
        this.txtNumber.requestFocusInWindow();
    }

	
	

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject)
    {
        IObjectValue ov = dataObject;        	    	
        super.setDataObject(ov);
        this.editData = (com.kingdee.eas.mw.pay.CostByUpdateInfo)ov;
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
		getValidateHelper().registerBindProperty("iszidai", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("creator", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("createTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lastUpdateUser", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lastUpdateTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("number", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("bizDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("description", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditor", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("doctorNumber", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("doctorName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("period", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("clinicNumber", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("clinicName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("cityNumber", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("cityName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("status", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("doctor", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("sumxhzz", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("sumxhyxjz", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("sumxhcgjz", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("sumxhknw", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("sumxhxf", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("sumxhey", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("sumxhyz", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("sumxhmb", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("sumjgfzz", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("sumjgfyxjz", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("sumjgfcgjz", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("sumjgfknw", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("sumjgfxf", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("sumjgfey", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("sumjgfyz", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("sumjgfmb", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("xhzz", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("xhyxjz", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("xhcgjz", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("xhknw", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("xhxf", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("xhey", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("xhyz", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("xhmb", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("jgfyxjz", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("jgfcgjz", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("jgfknw", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("jgfxf", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("jgfey", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("jgfyz", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("jgfmb", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("jgfzz", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("allxhzz", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("allxhyxjz", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("allxhcgjz", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("allzhknw", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("allxhxf", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("allxhey", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("allxhyz", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("allxhmb", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("alljgfzz", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("alljgfyxjz", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("alljgfcgjz", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("alljgfknw", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("alljgfxf", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("alljgfey", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("alljgfyz", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("alljgdmb", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("remake", ValidateHelper.ON_SAVE);    		
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
        sic.add(new SelectorItemInfo("iszidai"));
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
        sic.add(new SelectorItemInfo("doctorNumber"));
        sic.add(new SelectorItemInfo("doctorName"));
        sic.add(new SelectorItemInfo("period"));
        sic.add(new SelectorItemInfo("clinicNumber"));
        sic.add(new SelectorItemInfo("clinicName"));
        sic.add(new SelectorItemInfo("cityNumber"));
        sic.add(new SelectorItemInfo("cityName"));
        sic.add(new SelectorItemInfo("status"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("doctor.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("doctor.id"));
        	sic.add(new SelectorItemInfo("doctor.number"));
        	sic.add(new SelectorItemInfo("doctor.name"));
		}
        sic.add(new SelectorItemInfo("sumxhzz"));
        sic.add(new SelectorItemInfo("sumxhyxjz"));
        sic.add(new SelectorItemInfo("sumxhcgjz"));
        sic.add(new SelectorItemInfo("sumxhknw"));
        sic.add(new SelectorItemInfo("sumxhxf"));
        sic.add(new SelectorItemInfo("sumxhey"));
        sic.add(new SelectorItemInfo("sumxhyz"));
        sic.add(new SelectorItemInfo("sumxhmb"));
        sic.add(new SelectorItemInfo("sumjgfzz"));
        sic.add(new SelectorItemInfo("sumjgfyxjz"));
        sic.add(new SelectorItemInfo("sumjgfcgjz"));
        sic.add(new SelectorItemInfo("sumjgfknw"));
        sic.add(new SelectorItemInfo("sumjgfxf"));
        sic.add(new SelectorItemInfo("sumjgfey"));
        sic.add(new SelectorItemInfo("sumjgfyz"));
        sic.add(new SelectorItemInfo("sumjgfmb"));
        sic.add(new SelectorItemInfo("xhzz"));
        sic.add(new SelectorItemInfo("xhyxjz"));
        sic.add(new SelectorItemInfo("xhcgjz"));
        sic.add(new SelectorItemInfo("xhknw"));
        sic.add(new SelectorItemInfo("xhxf"));
        sic.add(new SelectorItemInfo("xhey"));
        sic.add(new SelectorItemInfo("xhyz"));
        sic.add(new SelectorItemInfo("xhmb"));
        sic.add(new SelectorItemInfo("jgfyxjz"));
        sic.add(new SelectorItemInfo("jgfcgjz"));
        sic.add(new SelectorItemInfo("jgfknw"));
        sic.add(new SelectorItemInfo("jgfxf"));
        sic.add(new SelectorItemInfo("jgfey"));
        sic.add(new SelectorItemInfo("jgfyz"));
        sic.add(new SelectorItemInfo("jgfmb"));
        sic.add(new SelectorItemInfo("jgfzz"));
        sic.add(new SelectorItemInfo("allxhzz"));
        sic.add(new SelectorItemInfo("allxhyxjz"));
        sic.add(new SelectorItemInfo("allxhcgjz"));
        sic.add(new SelectorItemInfo("allzhknw"));
        sic.add(new SelectorItemInfo("allxhxf"));
        sic.add(new SelectorItemInfo("allxhey"));
        sic.add(new SelectorItemInfo("allxhyz"));
        sic.add(new SelectorItemInfo("allxhmb"));
        sic.add(new SelectorItemInfo("alljgfzz"));
        sic.add(new SelectorItemInfo("alljgfyxjz"));
        sic.add(new SelectorItemInfo("alljgfcgjz"));
        sic.add(new SelectorItemInfo("alljgfknw"));
        sic.add(new SelectorItemInfo("alljgfxf"));
        sic.add(new SelectorItemInfo("alljgfey"));
        sic.add(new SelectorItemInfo("alljgfyz"));
        sic.add(new SelectorItemInfo("alljgdmb"));
        sic.add(new SelectorItemInfo("remake"));
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
    	

    /**
     * output actionAuditCost_actionPerformed method
     */
    public void actionAuditCost_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.mw.pay.CostByUpdateFactory.getRemoteInstance().auditCost(editData);
    }
    	

    /**
     * output actionUnAuditCost_actionPerformed method
     */
    public void actionUnAuditCost_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.mw.pay.CostByUpdateFactory.getRemoteInstance().unAuditCost(editData);
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
	public RequestContext prepareActionAuditCost(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionAuditCost() {
    	return false;
    }
	public RequestContext prepareActionUnAuditCost(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionUnAuditCost() {
    	return false;
    }

    /**
     * output ActionAuditCost class
     */     
    protected class ActionAuditCost extends ItemAction {     
    
        public ActionAuditCost()
        {
            this(null);
        }

        public ActionAuditCost(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionAuditCost.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionAuditCost.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionAuditCost.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractCostByUpdateEditUI.this, "ActionAuditCost", "actionAuditCost_actionPerformed", e);
        }
    }

    /**
     * output ActionUnAuditCost class
     */     
    protected class ActionUnAuditCost extends ItemAction {     
    
        public ActionUnAuditCost()
        {
            this(null);
        }

        public ActionUnAuditCost(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionUnAuditCost.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionUnAuditCost.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionUnAuditCost.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractCostByUpdateEditUI.this, "ActionUnAuditCost", "actionUnAuditCost_actionPerformed", e);
        }
    }

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.mw.pay.client", "CostByUpdateEditUI");
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
        return com.kingdee.eas.mw.pay.client.CostByUpdateEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.mw.pay.CostByUpdateFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.mw.pay.CostByUpdateInfo objectValue = new com.kingdee.eas.mw.pay.CostByUpdateInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


    	protected String getTDFileName() {
    	return "/bim/mw/pay/CostByUpdate";
	}
    protected IMetaDataPK getTDQueryPK() {
    	return new MetaDataPK("com.kingdee.eas.mw.pay.app.CostByUpdateQuery");
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
		vo.put("status","wsh");
        
    }        
	protected void setFieldsNull(com.kingdee.bos.dao.AbstractObjectValue arg0) {
		super.setFieldsNull(arg0);
		arg0.put("number",null);
	}

}