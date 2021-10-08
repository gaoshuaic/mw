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
public abstract class AbstractDoctorCostsEditUI extends com.kingdee.eas.framework.client.CoreBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractDoctorCostsEditUI.class);
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
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contPerformanceBase;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contzjCost;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contgdCost;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contyxCost;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contxfCost;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conteyCost;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contknCost;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contmbCost;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contzbCost;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contqtCost;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contimportDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbusinessDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcityNumber;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcityName;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcostType;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcity;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkiszidai;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contclinic;
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
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtPerformanceBase;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtzjCost;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtgdCost;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtyxCost;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtxfCost;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txteyCost;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtknCost;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtmbCost;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtzbCost;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtqtCost;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkimportDate;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtbusinessDate;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtcityNumber;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtcityName;
    protected com.kingdee.bos.ctrl.swing.KDComboBox costType;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcity;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtclinic;
    protected com.kingdee.eas.mw.pay.DoctorCostsInfo editData = null;
    /**
     * output class constructor
     */
    public AbstractDoctorCostsEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractDoctorCostsEditUI.class.getName());
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
        this.contPerformanceBase = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contzjCost = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contgdCost = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contyxCost = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contxfCost = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conteyCost = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contknCost = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contmbCost = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contzbCost = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contqtCost = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contimportDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbusinessDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcityNumber = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcityName = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcostType = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcity = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.chkiszidai = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.contclinic = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
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
        this.txtPerformanceBase = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtzjCost = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtgdCost = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtyxCost = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtxfCost = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txteyCost = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtknCost = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtmbCost = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtzbCost = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtqtCost = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.pkimportDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtbusinessDate = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtcityNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtcityName = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.costType = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.prmtcity = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtclinic = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
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
        this.contPerformanceBase.setName("contPerformanceBase");
        this.contzjCost.setName("contzjCost");
        this.contgdCost.setName("contgdCost");
        this.contyxCost.setName("contyxCost");
        this.contxfCost.setName("contxfCost");
        this.conteyCost.setName("conteyCost");
        this.contknCost.setName("contknCost");
        this.contmbCost.setName("contmbCost");
        this.contzbCost.setName("contzbCost");
        this.contqtCost.setName("contqtCost");
        this.contimportDate.setName("contimportDate");
        this.contbusinessDate.setName("contbusinessDate");
        this.contcityNumber.setName("contcityNumber");
        this.contcityName.setName("contcityName");
        this.contcostType.setName("contcostType");
        this.contcity.setName("contcity");
        this.chkiszidai.setName("chkiszidai");
        this.contclinic.setName("contclinic");
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
        this.txtPerformanceBase.setName("txtPerformanceBase");
        this.txtzjCost.setName("txtzjCost");
        this.txtgdCost.setName("txtgdCost");
        this.txtyxCost.setName("txtyxCost");
        this.txtxfCost.setName("txtxfCost");
        this.txteyCost.setName("txteyCost");
        this.txtknCost.setName("txtknCost");
        this.txtmbCost.setName("txtmbCost");
        this.txtzbCost.setName("txtzbCost");
        this.txtqtCost.setName("txtqtCost");
        this.pkimportDate.setName("pkimportDate");
        this.txtbusinessDate.setName("txtbusinessDate");
        this.txtcityNumber.setName("txtcityNumber");
        this.txtcityName.setName("txtcityName");
        this.costType.setName("costType");
        this.prmtcity.setName("prmtcity");
        this.prmtclinic.setName("prmtclinic");
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
        // contPerformanceBase		
        this.contPerformanceBase.setBoundLabelText(resHelper.getString("contPerformanceBase.boundLabelText"));		
        this.contPerformanceBase.setBoundLabelLength(100);		
        this.contPerformanceBase.setBoundLabelUnderline(true);		
        this.contPerformanceBase.setVisible(true);
        // contzjCost		
        this.contzjCost.setBoundLabelText(resHelper.getString("contzjCost.boundLabelText"));		
        this.contzjCost.setBoundLabelLength(100);		
        this.contzjCost.setBoundLabelUnderline(true);		
        this.contzjCost.setVisible(true);
        // contgdCost		
        this.contgdCost.setBoundLabelText(resHelper.getString("contgdCost.boundLabelText"));		
        this.contgdCost.setBoundLabelLength(100);		
        this.contgdCost.setBoundLabelUnderline(true);		
        this.contgdCost.setVisible(true);
        // contyxCost		
        this.contyxCost.setBoundLabelText(resHelper.getString("contyxCost.boundLabelText"));		
        this.contyxCost.setBoundLabelLength(100);		
        this.contyxCost.setBoundLabelUnderline(true);		
        this.contyxCost.setVisible(true);
        // contxfCost		
        this.contxfCost.setBoundLabelText(resHelper.getString("contxfCost.boundLabelText"));		
        this.contxfCost.setBoundLabelLength(100);		
        this.contxfCost.setBoundLabelUnderline(true);		
        this.contxfCost.setVisible(true);
        // conteyCost		
        this.conteyCost.setBoundLabelText(resHelper.getString("conteyCost.boundLabelText"));		
        this.conteyCost.setBoundLabelLength(100);		
        this.conteyCost.setBoundLabelUnderline(true);		
        this.conteyCost.setVisible(true);
        // contknCost		
        this.contknCost.setBoundLabelText(resHelper.getString("contknCost.boundLabelText"));		
        this.contknCost.setBoundLabelLength(100);		
        this.contknCost.setBoundLabelUnderline(true);		
        this.contknCost.setVisible(true);
        // contmbCost		
        this.contmbCost.setBoundLabelText(resHelper.getString("contmbCost.boundLabelText"));		
        this.contmbCost.setBoundLabelLength(100);		
        this.contmbCost.setBoundLabelUnderline(true);		
        this.contmbCost.setVisible(true);
        // contzbCost		
        this.contzbCost.setBoundLabelText(resHelper.getString("contzbCost.boundLabelText"));		
        this.contzbCost.setBoundLabelLength(100);		
        this.contzbCost.setBoundLabelUnderline(true);		
        this.contzbCost.setVisible(true);
        // contqtCost		
        this.contqtCost.setBoundLabelText(resHelper.getString("contqtCost.boundLabelText"));		
        this.contqtCost.setBoundLabelLength(100);		
        this.contqtCost.setBoundLabelUnderline(true);		
        this.contqtCost.setVisible(true);
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
        // contcostType		
        this.contcostType.setBoundLabelText(resHelper.getString("contcostType.boundLabelText"));		
        this.contcostType.setBoundLabelLength(100);		
        this.contcostType.setBoundLabelUnderline(true);		
        this.contcostType.setVisible(true);
        // contcity		
        this.contcity.setBoundLabelText(resHelper.getString("contcity.boundLabelText"));		
        this.contcity.setBoundLabelLength(100);		
        this.contcity.setBoundLabelUnderline(true);		
        this.contcity.setVisible(true);
        // chkiszidai		
        this.chkiszidai.setText(resHelper.getString("chkiszidai.text"));		
        this.chkiszidai.setVisible(true);		
        this.chkiszidai.setHorizontalAlignment(2);
        // contclinic		
        this.contclinic.setBoundLabelText(resHelper.getString("contclinic.boundLabelText"));		
        this.contclinic.setBoundLabelLength(100);		
        this.contclinic.setBoundLabelUnderline(true);		
        this.contclinic.setVisible(true);
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
        // txtPerformanceBase		
        this.txtPerformanceBase.setVisible(true);		
        this.txtPerformanceBase.setHorizontalAlignment(2);		
        this.txtPerformanceBase.setDataType(1);		
        this.txtPerformanceBase.setSupportedEmpty(true);		
        this.txtPerformanceBase.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtPerformanceBase.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtPerformanceBase.setPrecision(10);		
        this.txtPerformanceBase.setRequired(false);
        // txtzjCost		
        this.txtzjCost.setVisible(true);		
        this.txtzjCost.setHorizontalAlignment(2);		
        this.txtzjCost.setDataType(1);		
        this.txtzjCost.setSupportedEmpty(true);		
        this.txtzjCost.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtzjCost.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtzjCost.setPrecision(10);		
        this.txtzjCost.setRequired(false);
        // txtgdCost		
        this.txtgdCost.setVisible(true);		
        this.txtgdCost.setHorizontalAlignment(2);		
        this.txtgdCost.setDataType(1);		
        this.txtgdCost.setSupportedEmpty(true);		
        this.txtgdCost.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtgdCost.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtgdCost.setPrecision(10);		
        this.txtgdCost.setRequired(false);
        // txtyxCost		
        this.txtyxCost.setVisible(true);		
        this.txtyxCost.setHorizontalAlignment(2);		
        this.txtyxCost.setDataType(1);		
        this.txtyxCost.setSupportedEmpty(true);		
        this.txtyxCost.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtyxCost.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtyxCost.setPrecision(10);		
        this.txtyxCost.setRequired(false);
        // txtxfCost		
        this.txtxfCost.setVisible(true);		
        this.txtxfCost.setHorizontalAlignment(2);		
        this.txtxfCost.setDataType(1);		
        this.txtxfCost.setSupportedEmpty(true);		
        this.txtxfCost.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtxfCost.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtxfCost.setPrecision(10);		
        this.txtxfCost.setRequired(false);
        // txteyCost		
        this.txteyCost.setVisible(true);		
        this.txteyCost.setHorizontalAlignment(2);		
        this.txteyCost.setDataType(1);		
        this.txteyCost.setSupportedEmpty(true);		
        this.txteyCost.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txteyCost.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txteyCost.setPrecision(10);		
        this.txteyCost.setRequired(false);
        // txtknCost		
        this.txtknCost.setVisible(true);		
        this.txtknCost.setHorizontalAlignment(2);		
        this.txtknCost.setDataType(1);		
        this.txtknCost.setSupportedEmpty(true);		
        this.txtknCost.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtknCost.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtknCost.setPrecision(10);		
        this.txtknCost.setRequired(false);
        // txtmbCost		
        this.txtmbCost.setVisible(true);		
        this.txtmbCost.setHorizontalAlignment(2);		
        this.txtmbCost.setDataType(1);		
        this.txtmbCost.setSupportedEmpty(true);		
        this.txtmbCost.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtmbCost.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtmbCost.setPrecision(10);		
        this.txtmbCost.setRequired(false);
        // txtzbCost		
        this.txtzbCost.setVisible(true);		
        this.txtzbCost.setHorizontalAlignment(2);		
        this.txtzbCost.setDataType(1);		
        this.txtzbCost.setSupportedEmpty(true);		
        this.txtzbCost.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtzbCost.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtzbCost.setPrecision(10);		
        this.txtzbCost.setRequired(false);
        // txtqtCost		
        this.txtqtCost.setVisible(true);		
        this.txtqtCost.setHorizontalAlignment(2);		
        this.txtqtCost.setDataType(1);		
        this.txtqtCost.setSupportedEmpty(true);		
        this.txtqtCost.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtqtCost.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtqtCost.setPrecision(10);		
        this.txtqtCost.setRequired(false);
        // pkimportDate		
        this.pkimportDate.setVisible(true);		
        this.pkimportDate.setRequired(false);
        // txtbusinessDate		
        this.txtbusinessDate.setVisible(true);		
        this.txtbusinessDate.setHorizontalAlignment(2);		
        this.txtbusinessDate.setMaxLength(100);		
        this.txtbusinessDate.setRequired(false);
        // txtcityNumber		
        this.txtcityNumber.setVisible(true);		
        this.txtcityNumber.setHorizontalAlignment(2);		
        this.txtcityNumber.setMaxLength(100);		
        this.txtcityNumber.setRequired(false);
        // txtcityName		
        this.txtcityName.setVisible(true);		
        this.txtcityName.setHorizontalAlignment(2);		
        this.txtcityName.setMaxLength(100);		
        this.txtcityName.setRequired(false);
        // costType		
        this.costType.setVisible(true);		
        this.costType.addItems(EnumUtils.getEnumList("com.kingdee.eas.mw.pay.app.costType").toArray());		
        this.costType.setRequired(false);
        // prmtcity		
        this.prmtcity.setQueryInfo("com.kingdee.eas.basedata.org.app.CUQuery");		
        this.prmtcity.setVisible(true);		
        this.prmtcity.setEditable(true);		
        this.prmtcity.setDisplayFormat("$name$");		
        this.prmtcity.setEditFormat("$number$");		
        this.prmtcity.setCommitFormat("$number$");		
        this.prmtcity.setRequired(false);
        // prmtclinic		
        this.prmtclinic.setQueryInfo("com.kingdee.eas.basedata.org.app.CompanyOrgUnitQuery");		
        this.prmtclinic.setVisible(true);		
        this.prmtclinic.setEditable(true);		
        this.prmtclinic.setDisplayFormat("$name$");		
        this.prmtclinic.setEditFormat("$number$");		
        this.prmtclinic.setCommitFormat("$number$");		
        this.prmtclinic.setRequired(false);
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {txtmzNumber,txtmzName,txtempNumber,txtempName,txtPerformanceBase,txtzjCost,txtgdCost,txtyxCost,txtxfCost,txteyCost,txtknCost,txtmbCost,txtzbCost,txtqtCost,pkimportDate,txtbusinessDate,txtcityNumber,txtcityName,costType,prmtcity,chkiszidai,prmtclinic}));
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
        this.setBounds(new Rectangle(0, 0, 1013, 269));
        this.setLayout(null);
        contCreator.setBounds(new Rectangle(672, 130, 270, 19));
        this.add(contCreator, null);
        contCreateTime.setBounds(new Rectangle(672, 154, 270, 19));
        this.add(contCreateTime, null);
        contLastUpdateUser.setBounds(new Rectangle(341, 178, 270, 19));
        this.add(contLastUpdateUser, null);
        contLastUpdateTime.setBounds(new Rectangle(672, 178, 270, 19));
        this.add(contLastUpdateTime, null);
        contNumber.setBounds(new Rectangle(672, 106, 270, 19));
        this.add(contNumber, null);
        contBizDate.setBounds(new Rectangle(10, 154, 270, 19));
        this.add(contBizDate, null);
        contDescription.setBounds(new Rectangle(341, 154, 270, 19));
        this.add(contDescription, null);
        contAuditor.setBounds(new Rectangle(10, 178, 270, 19));
        this.add(contAuditor, null);
        contmzNumber.setBounds(new Rectangle(672, 10, 270, 19));
        this.add(contmzNumber, null);
        contmzName.setBounds(new Rectangle(10, 34, 270, 19));
        this.add(contmzName, null);
        contempNumber.setBounds(new Rectangle(341, 34, 270, 19));
        this.add(contempNumber, null);
        contempName.setBounds(new Rectangle(672, 34, 270, 19));
        this.add(contempName, null);
        contPerformanceBase.setBounds(new Rectangle(10, 58, 270, 19));
        this.add(contPerformanceBase, null);
        contzjCost.setBounds(new Rectangle(341, 58, 270, 19));
        this.add(contzjCost, null);
        contgdCost.setBounds(new Rectangle(672, 58, 270, 19));
        this.add(contgdCost, null);
        contyxCost.setBounds(new Rectangle(10, 82, 270, 19));
        this.add(contyxCost, null);
        contxfCost.setBounds(new Rectangle(341, 82, 270, 19));
        this.add(contxfCost, null);
        conteyCost.setBounds(new Rectangle(672, 82, 270, 19));
        this.add(conteyCost, null);
        contknCost.setBounds(new Rectangle(10, 106, 270, 19));
        this.add(contknCost, null);
        contmbCost.setBounds(new Rectangle(341, 106, 270, 19));
        this.add(contmbCost, null);
        contzbCost.setBounds(new Rectangle(10, 130, 270, 19));
        this.add(contzbCost, null);
        contqtCost.setBounds(new Rectangle(341, 202, 270, 19));
        this.add(contqtCost, null);
        contimportDate.setBounds(new Rectangle(10, 202, 270, 19));
        this.add(contimportDate, null);
        contbusinessDate.setBounds(new Rectangle(341, 10, 270, 19));
        this.add(contbusinessDate, null);
        contcityNumber.setBounds(new Rectangle(672, 202, 270, 19));
        this.add(contcityNumber, null);
        contcityName.setBounds(new Rectangle(10, 226, 270, 19));
        this.add(contcityName, null);
        contcostType.setBounds(new Rectangle(341, 130, 270, 19));
        this.add(contcostType, null);
        contcity.setBounds(new Rectangle(10, 10, 270, 19));
        this.add(contcity, null);
        chkiszidai.setBounds(new Rectangle(341, 226, 270, 19));
        this.add(chkiszidai, null);
        contclinic.setBounds(new Rectangle(672, 226, 270, 19));
        this.add(contclinic, null);
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
        //contPerformanceBase
        contPerformanceBase.setBoundEditor(txtPerformanceBase);
        //contzjCost
        contzjCost.setBoundEditor(txtzjCost);
        //contgdCost
        contgdCost.setBoundEditor(txtgdCost);
        //contyxCost
        contyxCost.setBoundEditor(txtyxCost);
        //contxfCost
        contxfCost.setBoundEditor(txtxfCost);
        //conteyCost
        conteyCost.setBoundEditor(txteyCost);
        //contknCost
        contknCost.setBoundEditor(txtknCost);
        //contmbCost
        contmbCost.setBoundEditor(txtmbCost);
        //contzbCost
        contzbCost.setBoundEditor(txtzbCost);
        //contqtCost
        contqtCost.setBoundEditor(txtqtCost);
        //contimportDate
        contimportDate.setBoundEditor(pkimportDate);
        //contbusinessDate
        contbusinessDate.setBoundEditor(txtbusinessDate);
        //contcityNumber
        contcityNumber.setBoundEditor(txtcityNumber);
        //contcityName
        contcityName.setBoundEditor(txtcityName);
        //contcostType
        contcostType.setBoundEditor(costType);
        //contcity
        contcity.setBoundEditor(prmtcity);
        //contclinic
        contclinic.setBoundEditor(prmtclinic);

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
		dataBinder.registerBinding("iszidai", boolean.class, this.chkiszidai, "selected");
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
		dataBinder.registerBinding("PerformanceBase", java.math.BigDecimal.class, this.txtPerformanceBase, "value");
		dataBinder.registerBinding("zjCost", java.math.BigDecimal.class, this.txtzjCost, "value");
		dataBinder.registerBinding("gdCost", java.math.BigDecimal.class, this.txtgdCost, "value");
		dataBinder.registerBinding("yxCost", java.math.BigDecimal.class, this.txtyxCost, "value");
		dataBinder.registerBinding("xfCost", java.math.BigDecimal.class, this.txtxfCost, "value");
		dataBinder.registerBinding("eyCost", java.math.BigDecimal.class, this.txteyCost, "value");
		dataBinder.registerBinding("knCost", java.math.BigDecimal.class, this.txtknCost, "value");
		dataBinder.registerBinding("mbCost", java.math.BigDecimal.class, this.txtmbCost, "value");
		dataBinder.registerBinding("zbCost", java.math.BigDecimal.class, this.txtzbCost, "value");
		dataBinder.registerBinding("qtCost", java.math.BigDecimal.class, this.txtqtCost, "value");
		dataBinder.registerBinding("importDate", java.util.Date.class, this.pkimportDate, "value");
		dataBinder.registerBinding("businessDate", String.class, this.txtbusinessDate, "text");
		dataBinder.registerBinding("cityNumber", String.class, this.txtcityNumber, "text");
		dataBinder.registerBinding("cityName", String.class, this.txtcityName, "text");
		dataBinder.registerBinding("costType", com.kingdee.eas.mw.pay.app.costType.class, this.costType, "selectedItem");
		dataBinder.registerBinding("city", com.kingdee.eas.basedata.org.CtrlUnitInfo.class, this.prmtcity, "data");
		dataBinder.registerBinding("clinic", com.kingdee.eas.basedata.org.CompanyOrgUnitInfo.class, this.prmtclinic, "data");		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.mw.pay.app.DoctorCostsEditUIHandler";
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
        this.editData = (com.kingdee.eas.mw.pay.DoctorCostsInfo)ov;
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
		getValidateHelper().registerBindProperty("mzNumber", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("mzName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("empNumber", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("empName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("PerformanceBase", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("zjCost", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("gdCost", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("yxCost", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("xfCost", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("eyCost", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("knCost", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("mbCost", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("zbCost", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("qtCost", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("importDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("businessDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("cityNumber", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("cityName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("costType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("city", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("clinic", ValidateHelper.ON_SAVE);    		
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
        sic.add(new SelectorItemInfo("mzNumber"));
        sic.add(new SelectorItemInfo("mzName"));
        sic.add(new SelectorItemInfo("empNumber"));
        sic.add(new SelectorItemInfo("empName"));
        sic.add(new SelectorItemInfo("PerformanceBase"));
        sic.add(new SelectorItemInfo("zjCost"));
        sic.add(new SelectorItemInfo("gdCost"));
        sic.add(new SelectorItemInfo("yxCost"));
        sic.add(new SelectorItemInfo("xfCost"));
        sic.add(new SelectorItemInfo("eyCost"));
        sic.add(new SelectorItemInfo("knCost"));
        sic.add(new SelectorItemInfo("mbCost"));
        sic.add(new SelectorItemInfo("zbCost"));
        sic.add(new SelectorItemInfo("qtCost"));
        sic.add(new SelectorItemInfo("importDate"));
        sic.add(new SelectorItemInfo("businessDate"));
        sic.add(new SelectorItemInfo("cityNumber"));
        sic.add(new SelectorItemInfo("cityName"));
        sic.add(new SelectorItemInfo("costType"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("city.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("city.id"));
        	sic.add(new SelectorItemInfo("city.number"));
        	sic.add(new SelectorItemInfo("city.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("clinic.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("clinic.id"));
        	sic.add(new SelectorItemInfo("clinic.number"));
        	sic.add(new SelectorItemInfo("clinic.name"));
		}
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
        return new MetaDataPK("com.kingdee.eas.mw.pay.client", "DoctorCostsEditUI");
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
        return com.kingdee.eas.mw.pay.client.DoctorCostsEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.mw.pay.DoctorCostsFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.mw.pay.DoctorCostsInfo objectValue = new com.kingdee.eas.mw.pay.DoctorCostsInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


    	protected String getTDFileName() {
    	return "/bim/mw/pay/DoctorCosts";
	}
    protected IMetaDataPK getTDQueryPK() {
    	return new MetaDataPK("com.kingdee.eas.mw.pay.app.DoctorCostsQuery");
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
		vo.put("costType","dz");
        
    }        
	protected void setFieldsNull(com.kingdee.bos.dao.AbstractObjectValue arg0) {
		super.setFieldsNull(arg0);
		arg0.put("number",null);
	}

}