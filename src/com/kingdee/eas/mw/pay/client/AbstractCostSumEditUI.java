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
public abstract class AbstractCostSumEditUI extends com.kingdee.eas.framework.client.CoreBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractCostSumEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCreator;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCreateTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contNumber;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contBizDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contDescription;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contAuditor;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contdoctorNumber;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contqty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contprice;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contamount;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contremark;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contdoctorName;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contperiod;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contclinicNumber;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contclinicName;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcityNumber;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcityName;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contstatus;
    protected com.kingdee.bos.ctrl.swing.KDContainer kDContainer1;
    protected com.kingdee.bos.ctrl.swing.KDContainer kDContainer2;
    protected com.kingdee.bos.ctrl.swing.KDContainer kDContainer3;
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
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtqty;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtprice;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtamount;
    protected com.kingdee.bos.ctrl.swing.KDScrollPane scrollPaneremark;
    protected com.kingdee.bos.ctrl.swing.KDTextArea txtremark;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtdoctorName;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtperiod;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtclinicNumber;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtclinicName;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtcityNumber;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtcityName;
    protected com.kingdee.bos.ctrl.swing.KDComboBox status;
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
    protected com.kingdee.bos.ctrl.swing.KDTabbedPane kDTabbedPane2;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel3;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel4;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contupxhzz;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contupxhyxjz;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contupxhcgjz;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contupxhmb;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contupxhyz;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contupxhey;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contupxhxf;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contupxhknw;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtupxhzz;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtupxhyxjz;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtupxhcgjz;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtupxhmb;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtupxhyz;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtupxhey;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtupxhxf;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtupxhknw;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contupjgfzz;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contupjgfyxjz;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contupjgfcgjz;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contupjgfknw;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contupjgfxf;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contupjgfey;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contupjgfyz;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contupjgfmb;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtupjgfzz;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtupjgfyxjz;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtupjgfcgjz;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtupjgfknw;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtupjgfxf;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtupjgfey;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtupjgfyz;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtupjgfmb;
    protected com.kingdee.bos.ctrl.swing.KDTabbedPane kDTabbedPane3;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel5;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel6;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contallxhzz;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contallxhyxjz;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contallxhcgjz;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contallxhknw;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contallxhxf;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contallxhey;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contallxhyz;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contallxhmb;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtallxhzz;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtallxhyxjz;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtallxhcgjz;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtallxhknw;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtallxhxf;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtallxhey;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtallxhyz;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtallxhmb;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contalljgfzz;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contalljgfyxjz;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contalljgfgdjz;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contalljgfknw;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contalljgfxf;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contalljgfey;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contalljgfyz;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contalljgfmb;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtalljgfzz;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtalljgfyxjz;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtalljgfgdjz;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtalljgfknw;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtalljgfxf;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtalljgfey;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtalljgfyz;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtalljgfmb;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton auditCost;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton unauditCost;
    protected com.kingdee.eas.mw.pay.CostSumInfo editData = null;
    protected ActionAuditCost actionAuditCost = null;
    protected ActionUnAuditCost actionUnAuditCost = null;
    /**
     * output class constructor
     */
    public AbstractCostSumEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractCostSumEditUI.class.getName());
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
        this.contqty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contprice = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contamount = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contremark = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contdoctorName = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contperiod = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contclinicNumber = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contclinicName = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcityNumber = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcityName = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contstatus = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDContainer1 = new com.kingdee.bos.ctrl.swing.KDContainer();
        this.kDContainer2 = new com.kingdee.bos.ctrl.swing.KDContainer();
        this.kDContainer3 = new com.kingdee.bos.ctrl.swing.KDContainer();
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
        this.txtqty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtprice = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtamount = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.scrollPaneremark = new com.kingdee.bos.ctrl.swing.KDScrollPane();
        this.txtremark = new com.kingdee.bos.ctrl.swing.KDTextArea();
        this.txtdoctorName = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtperiod = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtclinicNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtclinicName = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtcityNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtcityName = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.status = new com.kingdee.bos.ctrl.swing.KDComboBox();
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
        this.kDTabbedPane2 = new com.kingdee.bos.ctrl.swing.KDTabbedPane();
        this.kDPanel3 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel4 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.contupxhzz = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contupxhyxjz = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contupxhcgjz = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contupxhmb = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contupxhyz = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contupxhey = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contupxhxf = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contupxhknw = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtupxhzz = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtupxhyxjz = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtupxhcgjz = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtupxhmb = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtupxhyz = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtupxhey = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtupxhxf = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtupxhknw = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.contupjgfzz = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contupjgfyxjz = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contupjgfcgjz = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contupjgfknw = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contupjgfxf = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contupjgfey = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contupjgfyz = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contupjgfmb = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtupjgfzz = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtupjgfyxjz = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtupjgfcgjz = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtupjgfknw = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtupjgfxf = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtupjgfey = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtupjgfyz = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtupjgfmb = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.kDTabbedPane3 = new com.kingdee.bos.ctrl.swing.KDTabbedPane();
        this.kDPanel5 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel6 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.contallxhzz = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contallxhyxjz = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contallxhcgjz = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contallxhknw = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contallxhxf = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contallxhey = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contallxhyz = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contallxhmb = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtallxhzz = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtallxhyxjz = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtallxhcgjz = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtallxhknw = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtallxhxf = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtallxhey = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtallxhyz = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtallxhmb = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.contalljgfzz = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contalljgfyxjz = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contalljgfgdjz = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contalljgfknw = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contalljgfxf = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contalljgfey = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contalljgfyz = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contalljgfmb = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtalljgfzz = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtalljgfyxjz = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtalljgfgdjz = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtalljgfknw = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtalljgfxf = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtalljgfey = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtalljgfyz = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtalljgfmb = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
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
        this.contqty.setName("contqty");
        this.contprice.setName("contprice");
        this.contamount.setName("contamount");
        this.contremark.setName("contremark");
        this.contdoctorName.setName("contdoctorName");
        this.contperiod.setName("contperiod");
        this.contclinicNumber.setName("contclinicNumber");
        this.contclinicName.setName("contclinicName");
        this.contcityNumber.setName("contcityNumber");
        this.contcityName.setName("contcityName");
        this.contstatus.setName("contstatus");
        this.kDContainer1.setName("kDContainer1");
        this.kDContainer2.setName("kDContainer2");
        this.kDContainer3.setName("kDContainer3");
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
        this.txtqty.setName("txtqty");
        this.txtprice.setName("txtprice");
        this.txtamount.setName("txtamount");
        this.scrollPaneremark.setName("scrollPaneremark");
        this.txtremark.setName("txtremark");
        this.txtdoctorName.setName("txtdoctorName");
        this.txtperiod.setName("txtperiod");
        this.txtclinicNumber.setName("txtclinicNumber");
        this.txtclinicName.setName("txtclinicName");
        this.txtcityNumber.setName("txtcityNumber");
        this.txtcityName.setName("txtcityName");
        this.status.setName("status");
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
        this.kDTabbedPane2.setName("kDTabbedPane2");
        this.kDPanel3.setName("kDPanel3");
        this.kDPanel4.setName("kDPanel4");
        this.contupxhzz.setName("contupxhzz");
        this.contupxhyxjz.setName("contupxhyxjz");
        this.contupxhcgjz.setName("contupxhcgjz");
        this.contupxhmb.setName("contupxhmb");
        this.contupxhyz.setName("contupxhyz");
        this.contupxhey.setName("contupxhey");
        this.contupxhxf.setName("contupxhxf");
        this.contupxhknw.setName("contupxhknw");
        this.txtupxhzz.setName("txtupxhzz");
        this.txtupxhyxjz.setName("txtupxhyxjz");
        this.txtupxhcgjz.setName("txtupxhcgjz");
        this.txtupxhmb.setName("txtupxhmb");
        this.txtupxhyz.setName("txtupxhyz");
        this.txtupxhey.setName("txtupxhey");
        this.txtupxhxf.setName("txtupxhxf");
        this.txtupxhknw.setName("txtupxhknw");
        this.contupjgfzz.setName("contupjgfzz");
        this.contupjgfyxjz.setName("contupjgfyxjz");
        this.contupjgfcgjz.setName("contupjgfcgjz");
        this.contupjgfknw.setName("contupjgfknw");
        this.contupjgfxf.setName("contupjgfxf");
        this.contupjgfey.setName("contupjgfey");
        this.contupjgfyz.setName("contupjgfyz");
        this.contupjgfmb.setName("contupjgfmb");
        this.txtupjgfzz.setName("txtupjgfzz");
        this.txtupjgfyxjz.setName("txtupjgfyxjz");
        this.txtupjgfcgjz.setName("txtupjgfcgjz");
        this.txtupjgfknw.setName("txtupjgfknw");
        this.txtupjgfxf.setName("txtupjgfxf");
        this.txtupjgfey.setName("txtupjgfey");
        this.txtupjgfyz.setName("txtupjgfyz");
        this.txtupjgfmb.setName("txtupjgfmb");
        this.kDTabbedPane3.setName("kDTabbedPane3");
        this.kDPanel5.setName("kDPanel5");
        this.kDPanel6.setName("kDPanel6");
        this.contallxhzz.setName("contallxhzz");
        this.contallxhyxjz.setName("contallxhyxjz");
        this.contallxhcgjz.setName("contallxhcgjz");
        this.contallxhknw.setName("contallxhknw");
        this.contallxhxf.setName("contallxhxf");
        this.contallxhey.setName("contallxhey");
        this.contallxhyz.setName("contallxhyz");
        this.contallxhmb.setName("contallxhmb");
        this.txtallxhzz.setName("txtallxhzz");
        this.txtallxhyxjz.setName("txtallxhyxjz");
        this.txtallxhcgjz.setName("txtallxhcgjz");
        this.txtallxhknw.setName("txtallxhknw");
        this.txtallxhxf.setName("txtallxhxf");
        this.txtallxhey.setName("txtallxhey");
        this.txtallxhyz.setName("txtallxhyz");
        this.txtallxhmb.setName("txtallxhmb");
        this.contalljgfzz.setName("contalljgfzz");
        this.contalljgfyxjz.setName("contalljgfyxjz");
        this.contalljgfgdjz.setName("contalljgfgdjz");
        this.contalljgfknw.setName("contalljgfknw");
        this.contalljgfxf.setName("contalljgfxf");
        this.contalljgfey.setName("contalljgfey");
        this.contalljgfyz.setName("contalljgfyz");
        this.contalljgfmb.setName("contalljgfmb");
        this.txtalljgfzz.setName("txtalljgfzz");
        this.txtalljgfyxjz.setName("txtalljgfyxjz");
        this.txtalljgfgdjz.setName("txtalljgfgdjz");
        this.txtalljgfknw.setName("txtalljgfknw");
        this.txtalljgfxf.setName("txtalljgfxf");
        this.txtalljgfey.setName("txtalljgfey");
        this.txtalljgfyz.setName("txtalljgfyz");
        this.txtalljgfmb.setName("txtalljgfmb");
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
        // contqty		
        this.contqty.setBoundLabelText(resHelper.getString("contqty.boundLabelText"));		
        this.contqty.setBoundLabelLength(100);		
        this.contqty.setBoundLabelUnderline(true);		
        this.contqty.setVisible(false);
        // contprice		
        this.contprice.setBoundLabelText(resHelper.getString("contprice.boundLabelText"));		
        this.contprice.setBoundLabelLength(100);		
        this.contprice.setBoundLabelUnderline(true);		
        this.contprice.setVisible(false);
        // contamount		
        this.contamount.setBoundLabelText(resHelper.getString("contamount.boundLabelText"));		
        this.contamount.setBoundLabelLength(100);		
        this.contamount.setBoundLabelUnderline(true);		
        this.contamount.setVisible(true);
        // contremark		
        this.contremark.setBoundLabelText(resHelper.getString("contremark.boundLabelText"));		
        this.contremark.setBoundLabelLength(100);		
        this.contremark.setBoundLabelUnderline(true);		
        this.contremark.setVisible(true);
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
        this.contstatus.setVisible(true);
        // kDContainer1		
        this.kDContainer1.setTitle(resHelper.getString("kDContainer1.title"));
        // kDContainer2		
        this.kDContainer2.setTitle(resHelper.getString("kDContainer2.title"));
        // kDContainer3		
        this.kDContainer3.setTitle(resHelper.getString("kDContainer3.title"));
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
        // txtqty		
        this.txtqty.setVisible(false);		
        this.txtqty.setHorizontalAlignment(2);		
        this.txtqty.setDataType(1);		
        this.txtqty.setSupportedEmpty(true);		
        this.txtqty.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtqty.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtqty.setPrecision(10);		
        this.txtqty.setRequired(false);
        // txtprice		
        this.txtprice.setVisible(false);		
        this.txtprice.setHorizontalAlignment(2);		
        this.txtprice.setDataType(1);		
        this.txtprice.setSupportedEmpty(true);		
        this.txtprice.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtprice.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtprice.setPrecision(10);		
        this.txtprice.setRequired(false);
        // txtamount		
        this.txtamount.setHorizontalAlignment(2);		
        this.txtamount.setDataType(1);		
        this.txtamount.setSupportedEmpty(true);		
        this.txtamount.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtamount.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtamount.setPrecision(10);		
        this.txtamount.setRequired(false);
        // scrollPaneremark
        // txtremark		
        this.txtremark.setRequired(false);		
        this.txtremark.setMaxLength(255);
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
        this.status.addItems(EnumUtils.getEnumList("com.kingdee.eas.mw.pay.app.UpdateCostStatus").toArray());		
        this.status.setRequired(false);
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
        // kDTabbedPane2
        // kDPanel3
        // kDPanel4
        // contupxhzz		
        this.contupxhzz.setBoundLabelText(resHelper.getString("contupxhzz.boundLabelText"));		
        this.contupxhzz.setBoundLabelLength(100);		
        this.contupxhzz.setBoundLabelUnderline(true);		
        this.contupxhzz.setVisible(true);
        // contupxhyxjz		
        this.contupxhyxjz.setBoundLabelText(resHelper.getString("contupxhyxjz.boundLabelText"));		
        this.contupxhyxjz.setBoundLabelLength(100);		
        this.contupxhyxjz.setBoundLabelUnderline(true);		
        this.contupxhyxjz.setVisible(true);
        // contupxhcgjz		
        this.contupxhcgjz.setBoundLabelText(resHelper.getString("contupxhcgjz.boundLabelText"));		
        this.contupxhcgjz.setBoundLabelLength(100);		
        this.contupxhcgjz.setBoundLabelUnderline(true);		
        this.contupxhcgjz.setVisible(true);
        // contupxhmb		
        this.contupxhmb.setBoundLabelText(resHelper.getString("contupxhmb.boundLabelText"));		
        this.contupxhmb.setBoundLabelLength(100);		
        this.contupxhmb.setBoundLabelUnderline(true);		
        this.contupxhmb.setVisible(true);
        // contupxhyz		
        this.contupxhyz.setBoundLabelText(resHelper.getString("contupxhyz.boundLabelText"));		
        this.contupxhyz.setBoundLabelLength(100);		
        this.contupxhyz.setBoundLabelUnderline(true);		
        this.contupxhyz.setVisible(true);
        // contupxhey		
        this.contupxhey.setBoundLabelText(resHelper.getString("contupxhey.boundLabelText"));		
        this.contupxhey.setBoundLabelLength(100);		
        this.contupxhey.setBoundLabelUnderline(true);		
        this.contupxhey.setVisible(true);
        // contupxhxf		
        this.contupxhxf.setBoundLabelText(resHelper.getString("contupxhxf.boundLabelText"));		
        this.contupxhxf.setBoundLabelLength(100);		
        this.contupxhxf.setBoundLabelUnderline(true);		
        this.contupxhxf.setVisible(true);
        // contupxhknw		
        this.contupxhknw.setBoundLabelText(resHelper.getString("contupxhknw.boundLabelText"));		
        this.contupxhknw.setBoundLabelLength(100);		
        this.contupxhknw.setBoundLabelUnderline(true);		
        this.contupxhknw.setVisible(true);
        // txtupxhzz		
        this.txtupxhzz.setVisible(true);		
        this.txtupxhzz.setHorizontalAlignment(2);		
        this.txtupxhzz.setDataType(1);		
        this.txtupxhzz.setSupportedEmpty(true);		
        this.txtupxhzz.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtupxhzz.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtupxhzz.setPrecision(10);		
        this.txtupxhzz.setRequired(false);
        // txtupxhyxjz		
        this.txtupxhyxjz.setVisible(true);		
        this.txtupxhyxjz.setHorizontalAlignment(2);		
        this.txtupxhyxjz.setDataType(1);		
        this.txtupxhyxjz.setSupportedEmpty(true);		
        this.txtupxhyxjz.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtupxhyxjz.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtupxhyxjz.setPrecision(10);		
        this.txtupxhyxjz.setRequired(false);
        // txtupxhcgjz		
        this.txtupxhcgjz.setVisible(true);		
        this.txtupxhcgjz.setHorizontalAlignment(2);		
        this.txtupxhcgjz.setDataType(1);		
        this.txtupxhcgjz.setSupportedEmpty(true);		
        this.txtupxhcgjz.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtupxhcgjz.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtupxhcgjz.setPrecision(10);		
        this.txtupxhcgjz.setRequired(false);
        // txtupxhmb		
        this.txtupxhmb.setVisible(true);		
        this.txtupxhmb.setHorizontalAlignment(2);		
        this.txtupxhmb.setDataType(1);		
        this.txtupxhmb.setSupportedEmpty(true);		
        this.txtupxhmb.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtupxhmb.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtupxhmb.setPrecision(10);		
        this.txtupxhmb.setRequired(false);
        // txtupxhyz		
        this.txtupxhyz.setVisible(true);		
        this.txtupxhyz.setHorizontalAlignment(2);		
        this.txtupxhyz.setDataType(1);		
        this.txtupxhyz.setSupportedEmpty(true);		
        this.txtupxhyz.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtupxhyz.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtupxhyz.setPrecision(10);		
        this.txtupxhyz.setRequired(false);
        // txtupxhey		
        this.txtupxhey.setVisible(true);		
        this.txtupxhey.setHorizontalAlignment(2);		
        this.txtupxhey.setDataType(1);		
        this.txtupxhey.setSupportedEmpty(true);		
        this.txtupxhey.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtupxhey.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtupxhey.setPrecision(10);		
        this.txtupxhey.setRequired(false);
        // txtupxhxf		
        this.txtupxhxf.setVisible(true);		
        this.txtupxhxf.setHorizontalAlignment(2);		
        this.txtupxhxf.setDataType(1);		
        this.txtupxhxf.setSupportedEmpty(true);		
        this.txtupxhxf.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtupxhxf.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtupxhxf.setPrecision(10);		
        this.txtupxhxf.setRequired(false);
        // txtupxhknw		
        this.txtupxhknw.setVisible(true);		
        this.txtupxhknw.setHorizontalAlignment(2);		
        this.txtupxhknw.setDataType(1);		
        this.txtupxhknw.setSupportedEmpty(true);		
        this.txtupxhknw.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtupxhknw.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtupxhknw.setPrecision(10);		
        this.txtupxhknw.setRequired(false);
        // contupjgfzz		
        this.contupjgfzz.setBoundLabelText(resHelper.getString("contupjgfzz.boundLabelText"));		
        this.contupjgfzz.setBoundLabelLength(100);		
        this.contupjgfzz.setBoundLabelUnderline(true);		
        this.contupjgfzz.setVisible(true);
        // contupjgfyxjz		
        this.contupjgfyxjz.setBoundLabelText(resHelper.getString("contupjgfyxjz.boundLabelText"));		
        this.contupjgfyxjz.setBoundLabelLength(100);		
        this.contupjgfyxjz.setBoundLabelUnderline(true);		
        this.contupjgfyxjz.setVisible(true);
        // contupjgfcgjz		
        this.contupjgfcgjz.setBoundLabelText(resHelper.getString("contupjgfcgjz.boundLabelText"));		
        this.contupjgfcgjz.setBoundLabelLength(100);		
        this.contupjgfcgjz.setBoundLabelUnderline(true);		
        this.contupjgfcgjz.setVisible(true);
        // contupjgfknw		
        this.contupjgfknw.setBoundLabelText(resHelper.getString("contupjgfknw.boundLabelText"));		
        this.contupjgfknw.setBoundLabelLength(100);		
        this.contupjgfknw.setBoundLabelUnderline(true);		
        this.contupjgfknw.setVisible(true);
        // contupjgfxf		
        this.contupjgfxf.setBoundLabelText(resHelper.getString("contupjgfxf.boundLabelText"));		
        this.contupjgfxf.setBoundLabelLength(100);		
        this.contupjgfxf.setBoundLabelUnderline(true);		
        this.contupjgfxf.setVisible(true);
        // contupjgfey		
        this.contupjgfey.setBoundLabelText(resHelper.getString("contupjgfey.boundLabelText"));		
        this.contupjgfey.setBoundLabelLength(100);		
        this.contupjgfey.setBoundLabelUnderline(true);		
        this.contupjgfey.setVisible(true);
        // contupjgfyz		
        this.contupjgfyz.setBoundLabelText(resHelper.getString("contupjgfyz.boundLabelText"));		
        this.contupjgfyz.setBoundLabelLength(100);		
        this.contupjgfyz.setBoundLabelUnderline(true);		
        this.contupjgfyz.setVisible(true);
        // contupjgfmb		
        this.contupjgfmb.setBoundLabelText(resHelper.getString("contupjgfmb.boundLabelText"));		
        this.contupjgfmb.setBoundLabelLength(100);		
        this.contupjgfmb.setBoundLabelUnderline(true);		
        this.contupjgfmb.setVisible(true);
        // txtupjgfzz		
        this.txtupjgfzz.setVisible(true);		
        this.txtupjgfzz.setHorizontalAlignment(2);		
        this.txtupjgfzz.setDataType(1);		
        this.txtupjgfzz.setSupportedEmpty(true);		
        this.txtupjgfzz.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtupjgfzz.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtupjgfzz.setPrecision(10);		
        this.txtupjgfzz.setRequired(false);
        // txtupjgfyxjz		
        this.txtupjgfyxjz.setVisible(true);		
        this.txtupjgfyxjz.setHorizontalAlignment(2);		
        this.txtupjgfyxjz.setDataType(1);		
        this.txtupjgfyxjz.setSupportedEmpty(true);		
        this.txtupjgfyxjz.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtupjgfyxjz.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtupjgfyxjz.setPrecision(10);		
        this.txtupjgfyxjz.setRequired(false);
        // txtupjgfcgjz		
        this.txtupjgfcgjz.setVisible(true);		
        this.txtupjgfcgjz.setHorizontalAlignment(2);		
        this.txtupjgfcgjz.setDataType(1);		
        this.txtupjgfcgjz.setSupportedEmpty(true);		
        this.txtupjgfcgjz.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtupjgfcgjz.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtupjgfcgjz.setPrecision(10);		
        this.txtupjgfcgjz.setRequired(false);
        // txtupjgfknw		
        this.txtupjgfknw.setVisible(true);		
        this.txtupjgfknw.setHorizontalAlignment(2);		
        this.txtupjgfknw.setDataType(1);		
        this.txtupjgfknw.setSupportedEmpty(true);		
        this.txtupjgfknw.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtupjgfknw.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtupjgfknw.setPrecision(10);		
        this.txtupjgfknw.setRequired(false);
        // txtupjgfxf		
        this.txtupjgfxf.setVisible(true);		
        this.txtupjgfxf.setHorizontalAlignment(2);		
        this.txtupjgfxf.setDataType(1);		
        this.txtupjgfxf.setSupportedEmpty(true);		
        this.txtupjgfxf.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtupjgfxf.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtupjgfxf.setPrecision(10);		
        this.txtupjgfxf.setRequired(false);
        // txtupjgfey		
        this.txtupjgfey.setVisible(true);		
        this.txtupjgfey.setHorizontalAlignment(2);		
        this.txtupjgfey.setDataType(1);		
        this.txtupjgfey.setSupportedEmpty(true);		
        this.txtupjgfey.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtupjgfey.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtupjgfey.setPrecision(10);		
        this.txtupjgfey.setRequired(false);
        // txtupjgfyz		
        this.txtupjgfyz.setVisible(true);		
        this.txtupjgfyz.setHorizontalAlignment(2);		
        this.txtupjgfyz.setDataType(1);		
        this.txtupjgfyz.setSupportedEmpty(true);		
        this.txtupjgfyz.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtupjgfyz.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtupjgfyz.setPrecision(10);		
        this.txtupjgfyz.setRequired(false);
        // txtupjgfmb		
        this.txtupjgfmb.setVisible(true);		
        this.txtupjgfmb.setHorizontalAlignment(2);		
        this.txtupjgfmb.setDataType(1);		
        this.txtupjgfmb.setSupportedEmpty(true);		
        this.txtupjgfmb.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtupjgfmb.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtupjgfmb.setPrecision(10);		
        this.txtupjgfmb.setRequired(false);
        // kDTabbedPane3
        // kDPanel5
        // kDPanel6
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
        // contallxhknw		
        this.contallxhknw.setBoundLabelText(resHelper.getString("contallxhknw.boundLabelText"));		
        this.contallxhknw.setBoundLabelLength(100);		
        this.contallxhknw.setBoundLabelUnderline(true);		
        this.contallxhknw.setVisible(true);
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
        // txtallxhknw		
        this.txtallxhknw.setVisible(true);		
        this.txtallxhknw.setHorizontalAlignment(2);		
        this.txtallxhknw.setDataType(1);		
        this.txtallxhknw.setSupportedEmpty(true);		
        this.txtallxhknw.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtallxhknw.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtallxhknw.setPrecision(10);		
        this.txtallxhknw.setRequired(false);
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
        // contalljgfgdjz		
        this.contalljgfgdjz.setBoundLabelText(resHelper.getString("contalljgfgdjz.boundLabelText"));		
        this.contalljgfgdjz.setBoundLabelLength(100);		
        this.contalljgfgdjz.setBoundLabelUnderline(true);		
        this.contalljgfgdjz.setVisible(true);
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
        // contalljgfmb		
        this.contalljgfmb.setBoundLabelText(resHelper.getString("contalljgfmb.boundLabelText"));		
        this.contalljgfmb.setBoundLabelLength(100);		
        this.contalljgfmb.setBoundLabelUnderline(true);		
        this.contalljgfmb.setVisible(true);
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
        // txtalljgfgdjz		
        this.txtalljgfgdjz.setVisible(true);		
        this.txtalljgfgdjz.setHorizontalAlignment(2);		
        this.txtalljgfgdjz.setDataType(1);		
        this.txtalljgfgdjz.setSupportedEmpty(true);		
        this.txtalljgfgdjz.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtalljgfgdjz.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtalljgfgdjz.setPrecision(10);		
        this.txtalljgfgdjz.setRequired(false);
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
        // txtalljgfmb		
        this.txtalljgfmb.setVisible(true);		
        this.txtalljgfmb.setHorizontalAlignment(2);		
        this.txtalljgfmb.setDataType(1);		
        this.txtalljgfmb.setSupportedEmpty(true);		
        this.txtalljgfmb.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtalljgfmb.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtalljgfmb.setPrecision(10);		
        this.txtalljgfmb.setRequired(false);
        // auditCost
        this.auditCost.setAction((IItemAction)ActionProxyFactory.getProxy(actionAuditCost, new Class[] { IItemAction.class }, getServiceContext()));		
        this.auditCost.setText(resHelper.getString("auditCost.text"));
        // unauditCost
        this.unauditCost.setAction((IItemAction)ActionProxyFactory.getProxy(actionUnAuditCost, new Class[] { IItemAction.class }, getServiceContext()));		
        this.unauditCost.setText(resHelper.getString("unauditCost.text"));
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {txtNumber,pkBizDate,txtDescription,prmtAuditor,prmtCreator,kDDateCreateTime,prmtLastUpdateUser,kDDateLastUpdateTime,txtdoctorNumber,txtqty,txtprice,txtamount,txtremark,txtdoctorName,txtperiod,txtjgfzz,txtjgfyxjz,txtjgfcgjz,txtjgfknw,txtjgfxf,txtjgfey,txtjgfyz,txtjgfmb,txtxhzz,txtxhyxjz,txtxhcgjz,txtxhknw,txtxhxf,txtxhey,txtxhyz,txtclinicNumber,txtclinicName,txtxhmb,txtcityNumber,txtcityName,status,txtupxhzz,txtupxhyxjz,txtupxhcgjz,txtupxhknw,txtupxhxf,txtupxhey,txtupxhyz,txtupxhmb,txtupjgfzz,txtupjgfyxjz,txtupjgfcgjz,txtupjgfknw,txtupjgfxf,txtupjgfey,txtupjgfyz,txtupjgfmb,txtallxhzz,txtallxhyxjz,txtallxhcgjz,txtallxhknw,txtallxhxf,txtallxhey,txtallxhyz,txtallxhmb,txtalljgfzz,txtalljgfyxjz,txtalljgfgdjz,txtalljgfknw,txtalljgfxf,txtalljgfey,txtalljgfyz,txtalljgfmb,chkiszidai}));
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
        this.setBounds(new Rectangle(0, 0, 1013, 845));
        this.setLayout(null);
        contCreator.setBounds(new Rectangle(341, 730, 270, 19));
        this.add(contCreator, null);
        contCreateTime.setBounds(new Rectangle(672, 730, 270, 19));
        this.add(contCreateTime, null);
        contLastUpdateUser.setBounds(new Rectangle(341, 754, 270, 19));
        this.add(contLastUpdateUser, null);
        contLastUpdateTime.setBounds(new Rectangle(672, 754, 270, 19));
        this.add(contLastUpdateTime, null);
        contNumber.setBounds(new Rectangle(10, 754, 270, 19));
        this.add(contNumber, null);
        contBizDate.setBounds(new Rectangle(672, 778, 270, 19));
        this.add(contBizDate, null);
        contDescription.setBounds(new Rectangle(341, 778, 270, 19));
        this.add(contDescription, null);
        contAuditor.setBounds(new Rectangle(10, 778, 270, 19));
        this.add(contAuditor, null);
        contdoctorNumber.setBounds(new Rectangle(10, 58, 270, 19));
        this.add(contdoctorNumber, null);
        contqty.setBounds(new Rectangle(10, 730, 270, 19));
        this.add(contqty, null);
        contprice.setBounds(new Rectangle(10, 802, 270, 19));
        this.add(contprice, null);
        contamount.setBounds(new Rectangle(672, 34, 270, 19));
        this.add(contamount, null);
        contremark.setBounds(new Rectangle(10, 682, 936, 25));
        this.add(contremark, null);
        contdoctorName.setBounds(new Rectangle(341, 58, 270, 19));
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
        contstatus.setBounds(new Rectangle(672, 58, 270, 19));
        this.add(contstatus, null);
        kDContainer1.setBounds(new Rectangle(10, 106, 950, 192));
        this.add(kDContainer1, null);
        kDContainer2.setBounds(new Rectangle(10, 298, 950, 192));
        this.add(kDContainer2, null);
        kDContainer3.setBounds(new Rectangle(10, 490, 950, 192));
        this.add(kDContainer3, null);
        chkiszidai.setBounds(new Rectangle(10, 82, 270, 19));
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
        //contqty
        contqty.setBoundEditor(txtqty);
        //contprice
        contprice.setBoundEditor(txtprice);
        //contamount
        contamount.setBoundEditor(txtamount);
        //contremark
        contremark.setBoundEditor(scrollPaneremark);
        //scrollPaneremark
        scrollPaneremark.getViewport().add(txtremark, null);
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
        //kDContainer1
        kDContainer1.getContentPane().setLayout(null);        kDTabbedPane1.setBounds(new Rectangle(2, -1, 947, 174));
        kDContainer1.getContentPane().add(kDTabbedPane1, null);
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
        //kDContainer2
        kDContainer2.getContentPane().setLayout(null);        kDTabbedPane2.setBounds(new Rectangle(-1, 1, 947, 174));
        kDContainer2.getContentPane().add(kDTabbedPane2, null);
        //kDTabbedPane2
        kDTabbedPane2.add(kDPanel3, resHelper.getString("kDPanel3.constraints"));
        kDTabbedPane2.add(kDPanel4, resHelper.getString("kDPanel4.constraints"));
        //kDPanel3
        kDPanel3.setLayout(null);        contupxhzz.setBounds(new Rectangle(25, 18, 270, 19));
        kDPanel3.add(contupxhzz, null);
        contupxhyxjz.setBounds(new Rectangle(327, 18, 270, 19));
        kDPanel3.add(contupxhyxjz, null);
        contupxhcgjz.setBounds(new Rectangle(643, 18, 270, 19));
        kDPanel3.add(contupxhcgjz, null);
        contupxhmb.setBounds(new Rectangle(327, 90, 270, 19));
        kDPanel3.add(contupxhmb, null);
        contupxhyz.setBounds(new Rectangle(25, 90, 270, 19));
        kDPanel3.add(contupxhyz, null);
        contupxhey.setBounds(new Rectangle(643, 52, 270, 19));
        kDPanel3.add(contupxhey, null);
        contupxhxf.setBounds(new Rectangle(327, 52, 270, 19));
        kDPanel3.add(contupxhxf, null);
        contupxhknw.setBounds(new Rectangle(25, 52, 270, 19));
        kDPanel3.add(contupxhknw, null);
        //contupxhzz
        contupxhzz.setBoundEditor(txtupxhzz);
        //contupxhyxjz
        contupxhyxjz.setBoundEditor(txtupxhyxjz);
        //contupxhcgjz
        contupxhcgjz.setBoundEditor(txtupxhcgjz);
        //contupxhmb
        contupxhmb.setBoundEditor(txtupxhmb);
        //contupxhyz
        contupxhyz.setBoundEditor(txtupxhyz);
        //contupxhey
        contupxhey.setBoundEditor(txtupxhey);
        //contupxhxf
        contupxhxf.setBoundEditor(txtupxhxf);
        //contupxhknw
        contupxhknw.setBoundEditor(txtupxhknw);
        //kDPanel4
        kDPanel4.setLayout(null);        contupjgfzz.setBounds(new Rectangle(25, 18, 270, 19));
        kDPanel4.add(contupjgfzz, null);
        contupjgfyxjz.setBounds(new Rectangle(327, 18, 270, 19));
        kDPanel4.add(contupjgfyxjz, null);
        contupjgfcgjz.setBounds(new Rectangle(643, 18, 270, 19));
        kDPanel4.add(contupjgfcgjz, null);
        contupjgfknw.setBounds(new Rectangle(25, 52, 270, 19));
        kDPanel4.add(contupjgfknw, null);
        contupjgfxf.setBounds(new Rectangle(327, 52, 270, 19));
        kDPanel4.add(contupjgfxf, null);
        contupjgfey.setBounds(new Rectangle(643, 52, 270, 19));
        kDPanel4.add(contupjgfey, null);
        contupjgfyz.setBounds(new Rectangle(25, 90, 270, 19));
        kDPanel4.add(contupjgfyz, null);
        contupjgfmb.setBounds(new Rectangle(327, 90, 270, 19));
        kDPanel4.add(contupjgfmb, null);
        //contupjgfzz
        contupjgfzz.setBoundEditor(txtupjgfzz);
        //contupjgfyxjz
        contupjgfyxjz.setBoundEditor(txtupjgfyxjz);
        //contupjgfcgjz
        contupjgfcgjz.setBoundEditor(txtupjgfcgjz);
        //contupjgfknw
        contupjgfknw.setBoundEditor(txtupjgfknw);
        //contupjgfxf
        contupjgfxf.setBoundEditor(txtupjgfxf);
        //contupjgfey
        contupjgfey.setBoundEditor(txtupjgfey);
        //contupjgfyz
        contupjgfyz.setBoundEditor(txtupjgfyz);
        //contupjgfmb
        contupjgfmb.setBoundEditor(txtupjgfmb);
        //kDContainer3
        kDContainer3.getContentPane().setLayout(null);        kDTabbedPane3.setBounds(new Rectangle(2, 2, 947, 174));
        kDContainer3.getContentPane().add(kDTabbedPane3, null);
        //kDTabbedPane3
        kDTabbedPane3.add(kDPanel5, resHelper.getString("kDPanel5.constraints"));
        kDTabbedPane3.add(kDPanel6, resHelper.getString("kDPanel6.constraints"));
        //kDPanel5
        kDPanel5.setLayout(null);        contallxhzz.setBounds(new Rectangle(25, 18, 270, 19));
        kDPanel5.add(contallxhzz, null);
        contallxhyxjz.setBounds(new Rectangle(327, 18, 270, 19));
        kDPanel5.add(contallxhyxjz, null);
        contallxhcgjz.setBounds(new Rectangle(643, 18, 270, 19));
        kDPanel5.add(contallxhcgjz, null);
        contallxhknw.setBounds(new Rectangle(25, 52, 270, 19));
        kDPanel5.add(contallxhknw, null);
        contallxhxf.setBounds(new Rectangle(327, 52, 270, 19));
        kDPanel5.add(contallxhxf, null);
        contallxhey.setBounds(new Rectangle(643, 52, 270, 19));
        kDPanel5.add(contallxhey, null);
        contallxhyz.setBounds(new Rectangle(25, 90, 270, 19));
        kDPanel5.add(contallxhyz, null);
        contallxhmb.setBounds(new Rectangle(327, 90, 270, 19));
        kDPanel5.add(contallxhmb, null);
        //contallxhzz
        contallxhzz.setBoundEditor(txtallxhzz);
        //contallxhyxjz
        contallxhyxjz.setBoundEditor(txtallxhyxjz);
        //contallxhcgjz
        contallxhcgjz.setBoundEditor(txtallxhcgjz);
        //contallxhknw
        contallxhknw.setBoundEditor(txtallxhknw);
        //contallxhxf
        contallxhxf.setBoundEditor(txtallxhxf);
        //contallxhey
        contallxhey.setBoundEditor(txtallxhey);
        //contallxhyz
        contallxhyz.setBoundEditor(txtallxhyz);
        //contallxhmb
        contallxhmb.setBoundEditor(txtallxhmb);
        //kDPanel6
        kDPanel6.setLayout(null);        contalljgfzz.setBounds(new Rectangle(25, 18, 270, 19));
        kDPanel6.add(contalljgfzz, null);
        contalljgfyxjz.setBounds(new Rectangle(327, 18, 270, 19));
        kDPanel6.add(contalljgfyxjz, null);
        contalljgfgdjz.setBounds(new Rectangle(643, 18, 270, 19));
        kDPanel6.add(contalljgfgdjz, null);
        contalljgfknw.setBounds(new Rectangle(25, 52, 270, 19));
        kDPanel6.add(contalljgfknw, null);
        contalljgfxf.setBounds(new Rectangle(327, 52, 270, 19));
        kDPanel6.add(contalljgfxf, null);
        contalljgfey.setBounds(new Rectangle(643, 52, 270, 19));
        kDPanel6.add(contalljgfey, null);
        contalljgfyz.setBounds(new Rectangle(25, 90, 270, 19));
        kDPanel6.add(contalljgfyz, null);
        contalljgfmb.setBounds(new Rectangle(327, 90, 270, 19));
        kDPanel6.add(contalljgfmb, null);
        //contalljgfzz
        contalljgfzz.setBoundEditor(txtalljgfzz);
        //contalljgfyxjz
        contalljgfyxjz.setBoundEditor(txtalljgfyxjz);
        //contalljgfgdjz
        contalljgfgdjz.setBoundEditor(txtalljgfgdjz);
        //contalljgfknw
        contalljgfknw.setBoundEditor(txtalljgfknw);
        //contalljgfxf
        contalljgfxf.setBoundEditor(txtalljgfxf);
        //contalljgfey
        contalljgfey.setBoundEditor(txtalljgfey);
        //contalljgfyz
        contalljgfyz.setBoundEditor(txtalljgfyz);
        //contalljgfmb
        contalljgfmb.setBoundEditor(txtalljgfmb);

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
		dataBinder.registerBinding("qty", java.math.BigDecimal.class, this.txtqty, "value");
		dataBinder.registerBinding("price", java.math.BigDecimal.class, this.txtprice, "value");
		dataBinder.registerBinding("amount", java.math.BigDecimal.class, this.txtamount, "value");
		dataBinder.registerBinding("remark", String.class, this.txtremark, "text");
		dataBinder.registerBinding("doctorName", String.class, this.txtdoctorName, "text");
		dataBinder.registerBinding("period", String.class, this.txtperiod, "text");
		dataBinder.registerBinding("clinicNumber", String.class, this.txtclinicNumber, "text");
		dataBinder.registerBinding("clinicName", String.class, this.txtclinicName, "text");
		dataBinder.registerBinding("cityNumber", String.class, this.txtcityNumber, "text");
		dataBinder.registerBinding("cityName", String.class, this.txtcityName, "text");
		dataBinder.registerBinding("status", com.kingdee.eas.mw.pay.app.UpdateCostStatus.class, this.status, "selectedItem");
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
		dataBinder.registerBinding("upxhzz", java.math.BigDecimal.class, this.txtupxhzz, "value");
		dataBinder.registerBinding("upxhyxjz", java.math.BigDecimal.class, this.txtupxhyxjz, "value");
		dataBinder.registerBinding("upxhcgjz", java.math.BigDecimal.class, this.txtupxhcgjz, "value");
		dataBinder.registerBinding("upxhmb", java.math.BigDecimal.class, this.txtupxhmb, "value");
		dataBinder.registerBinding("upxhyz", java.math.BigDecimal.class, this.txtupxhyz, "value");
		dataBinder.registerBinding("upxhey", java.math.BigDecimal.class, this.txtupxhey, "value");
		dataBinder.registerBinding("upxhxf", java.math.BigDecimal.class, this.txtupxhxf, "value");
		dataBinder.registerBinding("upxhknw", java.math.BigDecimal.class, this.txtupxhknw, "value");
		dataBinder.registerBinding("upjgfzz", java.math.BigDecimal.class, this.txtupjgfzz, "value");
		dataBinder.registerBinding("upjgfyxjz", java.math.BigDecimal.class, this.txtupjgfyxjz, "value");
		dataBinder.registerBinding("upjgfcgjz", java.math.BigDecimal.class, this.txtupjgfcgjz, "value");
		dataBinder.registerBinding("upjgfknw", java.math.BigDecimal.class, this.txtupjgfknw, "value");
		dataBinder.registerBinding("upjgfxf", java.math.BigDecimal.class, this.txtupjgfxf, "value");
		dataBinder.registerBinding("upjgfey", java.math.BigDecimal.class, this.txtupjgfey, "value");
		dataBinder.registerBinding("upjgfyz", java.math.BigDecimal.class, this.txtupjgfyz, "value");
		dataBinder.registerBinding("upjgfmb", java.math.BigDecimal.class, this.txtupjgfmb, "value");
		dataBinder.registerBinding("allxhzz", java.math.BigDecimal.class, this.txtallxhzz, "value");
		dataBinder.registerBinding("allxhyxjz", java.math.BigDecimal.class, this.txtallxhyxjz, "value");
		dataBinder.registerBinding("allxhcgjz", java.math.BigDecimal.class, this.txtallxhcgjz, "value");
		dataBinder.registerBinding("allxhknw", java.math.BigDecimal.class, this.txtallxhknw, "value");
		dataBinder.registerBinding("allxhxf", java.math.BigDecimal.class, this.txtallxhxf, "value");
		dataBinder.registerBinding("allxhey", java.math.BigDecimal.class, this.txtallxhey, "value");
		dataBinder.registerBinding("allxhyz", java.math.BigDecimal.class, this.txtallxhyz, "value");
		dataBinder.registerBinding("allxhmb", java.math.BigDecimal.class, this.txtallxhmb, "value");
		dataBinder.registerBinding("alljgfzz", java.math.BigDecimal.class, this.txtalljgfzz, "value");
		dataBinder.registerBinding("alljgfyxjz", java.math.BigDecimal.class, this.txtalljgfyxjz, "value");
		dataBinder.registerBinding("alljgfgdjz", java.math.BigDecimal.class, this.txtalljgfgdjz, "value");
		dataBinder.registerBinding("alljgfknw", java.math.BigDecimal.class, this.txtalljgfknw, "value");
		dataBinder.registerBinding("alljgfxf", java.math.BigDecimal.class, this.txtalljgfxf, "value");
		dataBinder.registerBinding("alljgfey", java.math.BigDecimal.class, this.txtalljgfey, "value");
		dataBinder.registerBinding("alljgfyz", java.math.BigDecimal.class, this.txtalljgfyz, "value");
		dataBinder.registerBinding("alljgfmb", java.math.BigDecimal.class, this.txtalljgfmb, "value");		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.mw.pay.app.CostSumEditUIHandler";
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
        this.editData = (com.kingdee.eas.mw.pay.CostSumInfo)ov;
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
		getValidateHelper().registerBindProperty("qty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("price", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("amount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("remark", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("doctorName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("period", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("clinicNumber", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("clinicName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("cityNumber", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("cityName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("status", ValidateHelper.ON_SAVE);    
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
		getValidateHelper().registerBindProperty("upxhzz", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("upxhyxjz", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("upxhcgjz", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("upxhmb", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("upxhyz", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("upxhey", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("upxhxf", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("upxhknw", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("upjgfzz", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("upjgfyxjz", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("upjgfcgjz", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("upjgfknw", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("upjgfxf", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("upjgfey", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("upjgfyz", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("upjgfmb", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("allxhzz", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("allxhyxjz", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("allxhcgjz", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("allxhknw", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("allxhxf", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("allxhey", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("allxhyz", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("allxhmb", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("alljgfzz", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("alljgfyxjz", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("alljgfgdjz", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("alljgfknw", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("alljgfxf", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("alljgfey", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("alljgfyz", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("alljgfmb", ValidateHelper.ON_SAVE);    		
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
        sic.add(new SelectorItemInfo("qty"));
        sic.add(new SelectorItemInfo("price"));
        sic.add(new SelectorItemInfo("amount"));
        sic.add(new SelectorItemInfo("remark"));
        sic.add(new SelectorItemInfo("doctorName"));
        sic.add(new SelectorItemInfo("period"));
        sic.add(new SelectorItemInfo("clinicNumber"));
        sic.add(new SelectorItemInfo("clinicName"));
        sic.add(new SelectorItemInfo("cityNumber"));
        sic.add(new SelectorItemInfo("cityName"));
        sic.add(new SelectorItemInfo("status"));
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
        sic.add(new SelectorItemInfo("upxhzz"));
        sic.add(new SelectorItemInfo("upxhyxjz"));
        sic.add(new SelectorItemInfo("upxhcgjz"));
        sic.add(new SelectorItemInfo("upxhmb"));
        sic.add(new SelectorItemInfo("upxhyz"));
        sic.add(new SelectorItemInfo("upxhey"));
        sic.add(new SelectorItemInfo("upxhxf"));
        sic.add(new SelectorItemInfo("upxhknw"));
        sic.add(new SelectorItemInfo("upjgfzz"));
        sic.add(new SelectorItemInfo("upjgfyxjz"));
        sic.add(new SelectorItemInfo("upjgfcgjz"));
        sic.add(new SelectorItemInfo("upjgfknw"));
        sic.add(new SelectorItemInfo("upjgfxf"));
        sic.add(new SelectorItemInfo("upjgfey"));
        sic.add(new SelectorItemInfo("upjgfyz"));
        sic.add(new SelectorItemInfo("upjgfmb"));
        sic.add(new SelectorItemInfo("allxhzz"));
        sic.add(new SelectorItemInfo("allxhyxjz"));
        sic.add(new SelectorItemInfo("allxhcgjz"));
        sic.add(new SelectorItemInfo("allxhknw"));
        sic.add(new SelectorItemInfo("allxhxf"));
        sic.add(new SelectorItemInfo("allxhey"));
        sic.add(new SelectorItemInfo("allxhyz"));
        sic.add(new SelectorItemInfo("allxhmb"));
        sic.add(new SelectorItemInfo("alljgfzz"));
        sic.add(new SelectorItemInfo("alljgfyxjz"));
        sic.add(new SelectorItemInfo("alljgfgdjz"));
        sic.add(new SelectorItemInfo("alljgfknw"));
        sic.add(new SelectorItemInfo("alljgfxf"));
        sic.add(new SelectorItemInfo("alljgfey"));
        sic.add(new SelectorItemInfo("alljgfyz"));
        sic.add(new SelectorItemInfo("alljgfmb"));
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
        com.kingdee.eas.mw.pay.CostSumFactory.getRemoteInstance().auditCost(editData);
    }
    	

    /**
     * output actionUnAuditCost_actionPerformed method
     */
    public void actionUnAuditCost_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.mw.pay.CostSumFactory.getRemoteInstance().unAuditCost(editData);
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
            innerActionPerformed("eas", AbstractCostSumEditUI.this, "ActionAuditCost", "actionAuditCost_actionPerformed", e);
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
            innerActionPerformed("eas", AbstractCostSumEditUI.this, "ActionUnAuditCost", "actionUnAuditCost_actionPerformed", e);
        }
    }

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.mw.pay.client", "CostSumEditUI");
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
        return com.kingdee.eas.mw.pay.client.CostSumEditUI.class.getName();
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
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.mw.pay.CostSumInfo objectValue = new com.kingdee.eas.mw.pay.CostSumInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


    	protected String getTDFileName() {
    	return "/bim/mw/pay/CostSum";
	}
    protected IMetaDataPK getTDQueryPK() {
    	return new MetaDataPK("com.kingdee.eas.mw.pay.app.CostSumQuery");
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