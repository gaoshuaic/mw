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
public abstract class AbstractAchieveDetailEditUI extends com.kingdee.eas.framework.client.CoreBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractAchieveDetailEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCreator;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCreateTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contNumber;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contBizDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contDescription;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contAuditor;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCity;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCaseNumber;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contClinicNumber;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contClinicName;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contName;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contFirSource;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contSecSource;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contTerSource;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contComplainNumber;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contComplainName;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contFirVis;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCreateOrg;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCreater;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contStatus;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contOrder;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contRecDotNumber;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contRecDotName;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contNurseNUmber;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contRecNurse;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contNurseOrderDiag;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contRecConNumber;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contRecConName;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contExcConNumber;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contExcConName;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contFirClassNumber;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contFirClassName;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contSecClassNumber;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contSecClassName;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contFeeItemDetail;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contRecPerson;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contOriPrice;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contIncome;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contDiscount;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contTotalPrice;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contPayment;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contGiftPayment;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcityNumber;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfeeItemDetailNumber;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contisRoutine;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbusiType;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conthisOrderId;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkiscount;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkisneedout;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkisout;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conthisdetailid;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contRecPersonNumber;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtCreator;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateCreateTime;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkBizDate;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtDescription;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtAuditor;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtCity;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtCaseNumber;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtClinicNumber;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtClinicName;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtName;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtFirSource;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtSecSource;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtTerSource;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtComplainNumber;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtComplainName;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtFirVis;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtCreateOrg;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtCreater;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtStatus;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtOrder;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtRecDotNumber;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtRecDotName;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNurseNUmber;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtRecNurse;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNurseOrderDiag;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtRecConNumber;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtRecConName;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtExcConNumber;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtExcConName;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtFirClassNumber;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtFirClassName;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtSecClassNumber;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtSecClassName;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtFeeItemDetail;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtRecPerson;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtQty;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtOriPrice;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtIncome;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtDiscount;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtTotalPrice;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtPayment;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtGiftPayment;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtcityNumber;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtfeeItemDetailNumber;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtisRoutine;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtbusiType;
    protected com.kingdee.bos.ctrl.swing.KDTextField txthisOrderId;
    protected com.kingdee.bos.ctrl.swing.KDTextField txthisdetailid;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtRecPersonNumber;
    protected com.kingdee.eas.mw.pay.AchieveDetailInfo editData = null;
    /**
     * output class constructor
     */
    public AbstractAchieveDetailEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractAchieveDetailEditUI.class.getName());
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
        this.contCity = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contCaseNumber = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contClinicNumber = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contClinicName = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contName = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contFirSource = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contSecSource = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contTerSource = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contComplainNumber = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contComplainName = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contFirVis = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contCreateOrg = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contCreater = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contStatus = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contOrder = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contRecDotNumber = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contRecDotName = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contNurseNUmber = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contRecNurse = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contNurseOrderDiag = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contRecConNumber = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contRecConName = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contExcConNumber = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contExcConName = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contFirClassNumber = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contFirClassName = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contSecClassNumber = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contSecClassName = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contFeeItemDetail = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contRecPerson = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contOriPrice = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contIncome = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contDiscount = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contTotalPrice = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contPayment = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contGiftPayment = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcityNumber = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfeeItemDetailNumber = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contisRoutine = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbusiType = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conthisOrderId = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.chkiscount = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.chkisneedout = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.chkisout = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.conthisdetailid = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contRecPersonNumber = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.prmtCreator = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateCreateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtLastUpdateUser = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateLastUpdateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.pkBizDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtDescription = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtAuditor = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtCity = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtCaseNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtClinicNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtClinicName = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtName = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtFirSource = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtSecSource = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtTerSource = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtComplainNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtComplainName = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtFirVis = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtCreateOrg = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtCreater = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtStatus = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtOrder = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtRecDotNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtRecDotName = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtNurseNUmber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtRecNurse = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtNurseOrderDiag = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtRecConNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtRecConName = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtExcConNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtExcConName = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtFirClassNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtFirClassName = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtSecClassNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtSecClassName = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtFeeItemDetail = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtRecPerson = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtOriPrice = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtIncome = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtDiscount = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtTotalPrice = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtPayment = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtGiftPayment = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtcityNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtfeeItemDetailNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtisRoutine = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtbusiType = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txthisOrderId = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txthisdetailid = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtRecPersonNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.contCreator.setName("contCreator");
        this.contCreateTime.setName("contCreateTime");
        this.contLastUpdateUser.setName("contLastUpdateUser");
        this.contLastUpdateTime.setName("contLastUpdateTime");
        this.contNumber.setName("contNumber");
        this.contBizDate.setName("contBizDate");
        this.contDescription.setName("contDescription");
        this.contAuditor.setName("contAuditor");
        this.contCity.setName("contCity");
        this.contCaseNumber.setName("contCaseNumber");
        this.contClinicNumber.setName("contClinicNumber");
        this.contClinicName.setName("contClinicName");
        this.contName.setName("contName");
        this.contFirSource.setName("contFirSource");
        this.contSecSource.setName("contSecSource");
        this.contTerSource.setName("contTerSource");
        this.contComplainNumber.setName("contComplainNumber");
        this.contComplainName.setName("contComplainName");
        this.contFirVis.setName("contFirVis");
        this.contCreateOrg.setName("contCreateOrg");
        this.contCreater.setName("contCreater");
        this.contStatus.setName("contStatus");
        this.contOrder.setName("contOrder");
        this.contRecDotNumber.setName("contRecDotNumber");
        this.contRecDotName.setName("contRecDotName");
        this.contNurseNUmber.setName("contNurseNUmber");
        this.contRecNurse.setName("contRecNurse");
        this.contNurseOrderDiag.setName("contNurseOrderDiag");
        this.contRecConNumber.setName("contRecConNumber");
        this.contRecConName.setName("contRecConName");
        this.contExcConNumber.setName("contExcConNumber");
        this.contExcConName.setName("contExcConName");
        this.contFirClassNumber.setName("contFirClassNumber");
        this.contFirClassName.setName("contFirClassName");
        this.contSecClassNumber.setName("contSecClassNumber");
        this.contSecClassName.setName("contSecClassName");
        this.contFeeItemDetail.setName("contFeeItemDetail");
        this.contRecPerson.setName("contRecPerson");
        this.contQty.setName("contQty");
        this.contOriPrice.setName("contOriPrice");
        this.contIncome.setName("contIncome");
        this.contDiscount.setName("contDiscount");
        this.contTotalPrice.setName("contTotalPrice");
        this.contPayment.setName("contPayment");
        this.contGiftPayment.setName("contGiftPayment");
        this.contcityNumber.setName("contcityNumber");
        this.contfeeItemDetailNumber.setName("contfeeItemDetailNumber");
        this.contisRoutine.setName("contisRoutine");
        this.contbusiType.setName("contbusiType");
        this.conthisOrderId.setName("conthisOrderId");
        this.chkiscount.setName("chkiscount");
        this.chkisneedout.setName("chkisneedout");
        this.chkisout.setName("chkisout");
        this.conthisdetailid.setName("conthisdetailid");
        this.contRecPersonNumber.setName("contRecPersonNumber");
        this.prmtCreator.setName("prmtCreator");
        this.kDDateCreateTime.setName("kDDateCreateTime");
        this.prmtLastUpdateUser.setName("prmtLastUpdateUser");
        this.kDDateLastUpdateTime.setName("kDDateLastUpdateTime");
        this.txtNumber.setName("txtNumber");
        this.pkBizDate.setName("pkBizDate");
        this.txtDescription.setName("txtDescription");
        this.prmtAuditor.setName("prmtAuditor");
        this.txtCity.setName("txtCity");
        this.txtCaseNumber.setName("txtCaseNumber");
        this.txtClinicNumber.setName("txtClinicNumber");
        this.txtClinicName.setName("txtClinicName");
        this.txtName.setName("txtName");
        this.txtFirSource.setName("txtFirSource");
        this.txtSecSource.setName("txtSecSource");
        this.txtTerSource.setName("txtTerSource");
        this.txtComplainNumber.setName("txtComplainNumber");
        this.txtComplainName.setName("txtComplainName");
        this.txtFirVis.setName("txtFirVis");
        this.txtCreateOrg.setName("txtCreateOrg");
        this.txtCreater.setName("txtCreater");
        this.txtStatus.setName("txtStatus");
        this.txtOrder.setName("txtOrder");
        this.txtRecDotNumber.setName("txtRecDotNumber");
        this.txtRecDotName.setName("txtRecDotName");
        this.txtNurseNUmber.setName("txtNurseNUmber");
        this.txtRecNurse.setName("txtRecNurse");
        this.txtNurseOrderDiag.setName("txtNurseOrderDiag");
        this.txtRecConNumber.setName("txtRecConNumber");
        this.txtRecConName.setName("txtRecConName");
        this.txtExcConNumber.setName("txtExcConNumber");
        this.txtExcConName.setName("txtExcConName");
        this.txtFirClassNumber.setName("txtFirClassNumber");
        this.txtFirClassName.setName("txtFirClassName");
        this.txtSecClassNumber.setName("txtSecClassNumber");
        this.txtSecClassName.setName("txtSecClassName");
        this.txtFeeItemDetail.setName("txtFeeItemDetail");
        this.txtRecPerson.setName("txtRecPerson");
        this.txtQty.setName("txtQty");
        this.txtOriPrice.setName("txtOriPrice");
        this.txtIncome.setName("txtIncome");
        this.txtDiscount.setName("txtDiscount");
        this.txtTotalPrice.setName("txtTotalPrice");
        this.txtPayment.setName("txtPayment");
        this.txtGiftPayment.setName("txtGiftPayment");
        this.txtcityNumber.setName("txtcityNumber");
        this.txtfeeItemDetailNumber.setName("txtfeeItemDetailNumber");
        this.txtisRoutine.setName("txtisRoutine");
        this.txtbusiType.setName("txtbusiType");
        this.txthisOrderId.setName("txthisOrderId");
        this.txthisdetailid.setName("txthisdetailid");
        this.txtRecPersonNumber.setName("txtRecPersonNumber");
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
        // contCity		
        this.contCity.setBoundLabelText(resHelper.getString("contCity.boundLabelText"));		
        this.contCity.setBoundLabelLength(100);		
        this.contCity.setBoundLabelUnderline(true);		
        this.contCity.setVisible(true);
        // contCaseNumber		
        this.contCaseNumber.setBoundLabelText(resHelper.getString("contCaseNumber.boundLabelText"));		
        this.contCaseNumber.setBoundLabelLength(100);		
        this.contCaseNumber.setBoundLabelUnderline(true);		
        this.contCaseNumber.setVisible(true);
        // contClinicNumber		
        this.contClinicNumber.setBoundLabelText(resHelper.getString("contClinicNumber.boundLabelText"));		
        this.contClinicNumber.setBoundLabelLength(100);		
        this.contClinicNumber.setBoundLabelUnderline(true);		
        this.contClinicNumber.setVisible(true);
        // contClinicName		
        this.contClinicName.setBoundLabelText(resHelper.getString("contClinicName.boundLabelText"));		
        this.contClinicName.setBoundLabelLength(100);		
        this.contClinicName.setBoundLabelUnderline(true);		
        this.contClinicName.setVisible(true);
        // contName		
        this.contName.setBoundLabelText(resHelper.getString("contName.boundLabelText"));		
        this.contName.setBoundLabelLength(100);		
        this.contName.setBoundLabelUnderline(true);		
        this.contName.setVisible(true);
        // contFirSource		
        this.contFirSource.setBoundLabelText(resHelper.getString("contFirSource.boundLabelText"));		
        this.contFirSource.setBoundLabelLength(100);		
        this.contFirSource.setBoundLabelUnderline(true);		
        this.contFirSource.setVisible(true);
        // contSecSource		
        this.contSecSource.setBoundLabelText(resHelper.getString("contSecSource.boundLabelText"));		
        this.contSecSource.setBoundLabelLength(100);		
        this.contSecSource.setBoundLabelUnderline(true);		
        this.contSecSource.setVisible(true);
        // contTerSource		
        this.contTerSource.setBoundLabelText(resHelper.getString("contTerSource.boundLabelText"));		
        this.contTerSource.setBoundLabelLength(100);		
        this.contTerSource.setBoundLabelUnderline(true);		
        this.contTerSource.setVisible(true);
        // contComplainNumber		
        this.contComplainNumber.setBoundLabelText(resHelper.getString("contComplainNumber.boundLabelText"));		
        this.contComplainNumber.setBoundLabelLength(100);		
        this.contComplainNumber.setBoundLabelUnderline(true);		
        this.contComplainNumber.setVisible(true);
        // contComplainName		
        this.contComplainName.setBoundLabelText(resHelper.getString("contComplainName.boundLabelText"));		
        this.contComplainName.setBoundLabelLength(100);		
        this.contComplainName.setBoundLabelUnderline(true);		
        this.contComplainName.setVisible(true);
        // contFirVis		
        this.contFirVis.setBoundLabelText(resHelper.getString("contFirVis.boundLabelText"));		
        this.contFirVis.setBoundLabelLength(100);		
        this.contFirVis.setBoundLabelUnderline(true);		
        this.contFirVis.setVisible(true);
        // contCreateOrg		
        this.contCreateOrg.setBoundLabelText(resHelper.getString("contCreateOrg.boundLabelText"));		
        this.contCreateOrg.setBoundLabelLength(100);		
        this.contCreateOrg.setBoundLabelUnderline(true);		
        this.contCreateOrg.setVisible(true);
        // contCreater		
        this.contCreater.setBoundLabelText(resHelper.getString("contCreater.boundLabelText"));		
        this.contCreater.setBoundLabelLength(100);		
        this.contCreater.setBoundLabelUnderline(true);		
        this.contCreater.setVisible(true);
        // contStatus		
        this.contStatus.setBoundLabelText(resHelper.getString("contStatus.boundLabelText"));		
        this.contStatus.setBoundLabelLength(100);		
        this.contStatus.setBoundLabelUnderline(true);		
        this.contStatus.setVisible(true);
        // contOrder		
        this.contOrder.setBoundLabelText(resHelper.getString("contOrder.boundLabelText"));		
        this.contOrder.setBoundLabelLength(100);		
        this.contOrder.setBoundLabelUnderline(true);		
        this.contOrder.setVisible(true);
        // contRecDotNumber		
        this.contRecDotNumber.setBoundLabelText(resHelper.getString("contRecDotNumber.boundLabelText"));		
        this.contRecDotNumber.setBoundLabelLength(100);		
        this.contRecDotNumber.setBoundLabelUnderline(true);		
        this.contRecDotNumber.setVisible(true);
        // contRecDotName		
        this.contRecDotName.setBoundLabelText(resHelper.getString("contRecDotName.boundLabelText"));		
        this.contRecDotName.setBoundLabelLength(100);		
        this.contRecDotName.setBoundLabelUnderline(true);		
        this.contRecDotName.setVisible(true);
        // contNurseNUmber		
        this.contNurseNUmber.setBoundLabelText(resHelper.getString("contNurseNUmber.boundLabelText"));		
        this.contNurseNUmber.setBoundLabelLength(100);		
        this.contNurseNUmber.setBoundLabelUnderline(true);		
        this.contNurseNUmber.setVisible(true);
        // contRecNurse		
        this.contRecNurse.setBoundLabelText(resHelper.getString("contRecNurse.boundLabelText"));		
        this.contRecNurse.setBoundLabelLength(100);		
        this.contRecNurse.setBoundLabelUnderline(true);		
        this.contRecNurse.setVisible(true);
        // contNurseOrderDiag		
        this.contNurseOrderDiag.setBoundLabelText(resHelper.getString("contNurseOrderDiag.boundLabelText"));		
        this.contNurseOrderDiag.setBoundLabelLength(100);		
        this.contNurseOrderDiag.setBoundLabelUnderline(true);		
        this.contNurseOrderDiag.setVisible(true);
        // contRecConNumber		
        this.contRecConNumber.setBoundLabelText(resHelper.getString("contRecConNumber.boundLabelText"));		
        this.contRecConNumber.setBoundLabelLength(100);		
        this.contRecConNumber.setBoundLabelUnderline(true);		
        this.contRecConNumber.setVisible(true);
        // contRecConName		
        this.contRecConName.setBoundLabelText(resHelper.getString("contRecConName.boundLabelText"));		
        this.contRecConName.setBoundLabelLength(100);		
        this.contRecConName.setBoundLabelUnderline(true);		
        this.contRecConName.setVisible(true);
        // contExcConNumber		
        this.contExcConNumber.setBoundLabelText(resHelper.getString("contExcConNumber.boundLabelText"));		
        this.contExcConNumber.setBoundLabelLength(100);		
        this.contExcConNumber.setBoundLabelUnderline(true);		
        this.contExcConNumber.setVisible(true);
        // contExcConName		
        this.contExcConName.setBoundLabelText(resHelper.getString("contExcConName.boundLabelText"));		
        this.contExcConName.setBoundLabelLength(100);		
        this.contExcConName.setBoundLabelUnderline(true);		
        this.contExcConName.setVisible(true);
        // contFirClassNumber		
        this.contFirClassNumber.setBoundLabelText(resHelper.getString("contFirClassNumber.boundLabelText"));		
        this.contFirClassNumber.setBoundLabelLength(100);		
        this.contFirClassNumber.setBoundLabelUnderline(true);		
        this.contFirClassNumber.setVisible(true);
        // contFirClassName		
        this.contFirClassName.setBoundLabelText(resHelper.getString("contFirClassName.boundLabelText"));		
        this.contFirClassName.setBoundLabelLength(100);		
        this.contFirClassName.setBoundLabelUnderline(true);		
        this.contFirClassName.setVisible(true);
        // contSecClassNumber		
        this.contSecClassNumber.setBoundLabelText(resHelper.getString("contSecClassNumber.boundLabelText"));		
        this.contSecClassNumber.setBoundLabelLength(100);		
        this.contSecClassNumber.setBoundLabelUnderline(true);		
        this.contSecClassNumber.setVisible(true);
        // contSecClassName		
        this.contSecClassName.setBoundLabelText(resHelper.getString("contSecClassName.boundLabelText"));		
        this.contSecClassName.setBoundLabelLength(100);		
        this.contSecClassName.setBoundLabelUnderline(true);		
        this.contSecClassName.setVisible(true);
        // contFeeItemDetail		
        this.contFeeItemDetail.setBoundLabelText(resHelper.getString("contFeeItemDetail.boundLabelText"));		
        this.contFeeItemDetail.setBoundLabelLength(100);		
        this.contFeeItemDetail.setBoundLabelUnderline(true);		
        this.contFeeItemDetail.setVisible(true);
        // contRecPerson		
        this.contRecPerson.setBoundLabelText(resHelper.getString("contRecPerson.boundLabelText"));		
        this.contRecPerson.setBoundLabelLength(100);		
        this.contRecPerson.setBoundLabelUnderline(true);		
        this.contRecPerson.setVisible(true);
        // contQty		
        this.contQty.setBoundLabelText(resHelper.getString("contQty.boundLabelText"));		
        this.contQty.setBoundLabelLength(100);		
        this.contQty.setBoundLabelUnderline(true);		
        this.contQty.setVisible(true);
        // contOriPrice		
        this.contOriPrice.setBoundLabelText(resHelper.getString("contOriPrice.boundLabelText"));		
        this.contOriPrice.setBoundLabelLength(100);		
        this.contOriPrice.setBoundLabelUnderline(true);		
        this.contOriPrice.setVisible(true);
        // contIncome		
        this.contIncome.setBoundLabelText(resHelper.getString("contIncome.boundLabelText"));		
        this.contIncome.setBoundLabelLength(100);		
        this.contIncome.setBoundLabelUnderline(true);		
        this.contIncome.setVisible(true);
        // contDiscount		
        this.contDiscount.setBoundLabelText(resHelper.getString("contDiscount.boundLabelText"));		
        this.contDiscount.setBoundLabelLength(100);		
        this.contDiscount.setBoundLabelUnderline(true);		
        this.contDiscount.setVisible(true);
        // contTotalPrice		
        this.contTotalPrice.setBoundLabelText(resHelper.getString("contTotalPrice.boundLabelText"));		
        this.contTotalPrice.setBoundLabelLength(100);		
        this.contTotalPrice.setBoundLabelUnderline(true);		
        this.contTotalPrice.setVisible(true);
        // contPayment		
        this.contPayment.setBoundLabelText(resHelper.getString("contPayment.boundLabelText"));		
        this.contPayment.setBoundLabelLength(100);		
        this.contPayment.setBoundLabelUnderline(true);		
        this.contPayment.setVisible(true);
        // contGiftPayment		
        this.contGiftPayment.setBoundLabelText(resHelper.getString("contGiftPayment.boundLabelText"));		
        this.contGiftPayment.setBoundLabelLength(100);		
        this.contGiftPayment.setBoundLabelUnderline(true);		
        this.contGiftPayment.setVisible(true);
        // contcityNumber		
        this.contcityNumber.setBoundLabelText(resHelper.getString("contcityNumber.boundLabelText"));		
        this.contcityNumber.setBoundLabelLength(100);		
        this.contcityNumber.setBoundLabelUnderline(true);		
        this.contcityNumber.setVisible(true);
        // contfeeItemDetailNumber		
        this.contfeeItemDetailNumber.setBoundLabelText(resHelper.getString("contfeeItemDetailNumber.boundLabelText"));		
        this.contfeeItemDetailNumber.setBoundLabelLength(100);		
        this.contfeeItemDetailNumber.setBoundLabelUnderline(true);		
        this.contfeeItemDetailNumber.setVisible(true);
        // contisRoutine		
        this.contisRoutine.setBoundLabelText(resHelper.getString("contisRoutine.boundLabelText"));		
        this.contisRoutine.setBoundLabelLength(100);		
        this.contisRoutine.setBoundLabelUnderline(true);		
        this.contisRoutine.setVisible(true);
        // contbusiType		
        this.contbusiType.setBoundLabelText(resHelper.getString("contbusiType.boundLabelText"));		
        this.contbusiType.setBoundLabelLength(100);		
        this.contbusiType.setBoundLabelUnderline(true);		
        this.contbusiType.setVisible(true);
        // conthisOrderId		
        this.conthisOrderId.setBoundLabelText(resHelper.getString("conthisOrderId.boundLabelText"));		
        this.conthisOrderId.setBoundLabelLength(100);		
        this.conthisOrderId.setBoundLabelUnderline(true);		
        this.conthisOrderId.setVisible(true);
        // chkiscount		
        this.chkiscount.setText(resHelper.getString("chkiscount.text"));		
        this.chkiscount.setVisible(true);		
        this.chkiscount.setHorizontalAlignment(2);
        // chkisneedout		
        this.chkisneedout.setText(resHelper.getString("chkisneedout.text"));		
        this.chkisneedout.setVisible(true);		
        this.chkisneedout.setHorizontalAlignment(2);
        // chkisout		
        this.chkisout.setText(resHelper.getString("chkisout.text"));		
        this.chkisout.setVisible(true);		
        this.chkisout.setHorizontalAlignment(2);
        // conthisdetailid		
        this.conthisdetailid.setBoundLabelText(resHelper.getString("conthisdetailid.boundLabelText"));		
        this.conthisdetailid.setBoundLabelLength(100);		
        this.conthisdetailid.setBoundLabelUnderline(true);		
        this.conthisdetailid.setVisible(true);
        // contRecPersonNumber		
        this.contRecPersonNumber.setBoundLabelText(resHelper.getString("contRecPersonNumber.boundLabelText"));		
        this.contRecPersonNumber.setBoundLabelLength(100);		
        this.contRecPersonNumber.setBoundLabelUnderline(true);		
        this.contRecPersonNumber.setVisible(true);
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
        // txtCity		
        this.txtCity.setVisible(true);		
        this.txtCity.setHorizontalAlignment(2);		
        this.txtCity.setMaxLength(100);		
        this.txtCity.setRequired(false);
        // txtCaseNumber		
        this.txtCaseNumber.setVisible(true);		
        this.txtCaseNumber.setHorizontalAlignment(2);		
        this.txtCaseNumber.setMaxLength(100);		
        this.txtCaseNumber.setRequired(false);
        // txtClinicNumber		
        this.txtClinicNumber.setVisible(true);		
        this.txtClinicNumber.setHorizontalAlignment(2);		
        this.txtClinicNumber.setMaxLength(100);		
        this.txtClinicNumber.setRequired(false);
        // txtClinicName		
        this.txtClinicName.setVisible(true);		
        this.txtClinicName.setHorizontalAlignment(2);		
        this.txtClinicName.setMaxLength(100);		
        this.txtClinicName.setRequired(false);
        // txtName		
        this.txtName.setVisible(true);		
        this.txtName.setHorizontalAlignment(2);		
        this.txtName.setMaxLength(100);		
        this.txtName.setRequired(false);
        // txtFirSource		
        this.txtFirSource.setVisible(true);		
        this.txtFirSource.setHorizontalAlignment(2);		
        this.txtFirSource.setMaxLength(100);		
        this.txtFirSource.setRequired(false);
        // txtSecSource		
        this.txtSecSource.setVisible(true);		
        this.txtSecSource.setHorizontalAlignment(2);		
        this.txtSecSource.setMaxLength(100);		
        this.txtSecSource.setRequired(false);
        // txtTerSource		
        this.txtTerSource.setVisible(true);		
        this.txtTerSource.setHorizontalAlignment(2);		
        this.txtTerSource.setMaxLength(100);		
        this.txtTerSource.setRequired(false);
        // txtComplainNumber		
        this.txtComplainNumber.setVisible(true);		
        this.txtComplainNumber.setHorizontalAlignment(2);		
        this.txtComplainNumber.setMaxLength(100);		
        this.txtComplainNumber.setRequired(false);
        // txtComplainName		
        this.txtComplainName.setVisible(true);		
        this.txtComplainName.setHorizontalAlignment(2);		
        this.txtComplainName.setMaxLength(100);		
        this.txtComplainName.setRequired(false);
        // txtFirVis		
        this.txtFirVis.setVisible(true);		
        this.txtFirVis.setHorizontalAlignment(2);		
        this.txtFirVis.setMaxLength(100);		
        this.txtFirVis.setRequired(false);
        // txtCreateOrg		
        this.txtCreateOrg.setVisible(true);		
        this.txtCreateOrg.setHorizontalAlignment(2);		
        this.txtCreateOrg.setMaxLength(100);		
        this.txtCreateOrg.setRequired(false);
        // txtCreater		
        this.txtCreater.setVisible(true);		
        this.txtCreater.setHorizontalAlignment(2);		
        this.txtCreater.setMaxLength(100);		
        this.txtCreater.setRequired(false);
        // txtStatus		
        this.txtStatus.setVisible(true);		
        this.txtStatus.setHorizontalAlignment(2);		
        this.txtStatus.setMaxLength(100);		
        this.txtStatus.setRequired(false);
        // txtOrder		
        this.txtOrder.setVisible(true);		
        this.txtOrder.setHorizontalAlignment(2);		
        this.txtOrder.setMaxLength(100);		
        this.txtOrder.setRequired(false);
        // txtRecDotNumber		
        this.txtRecDotNumber.setVisible(true);		
        this.txtRecDotNumber.setHorizontalAlignment(2);		
        this.txtRecDotNumber.setMaxLength(100);		
        this.txtRecDotNumber.setRequired(false);
        // txtRecDotName		
        this.txtRecDotName.setVisible(true);		
        this.txtRecDotName.setHorizontalAlignment(2);		
        this.txtRecDotName.setMaxLength(100);		
        this.txtRecDotName.setRequired(false);
        // txtNurseNUmber		
        this.txtNurseNUmber.setVisible(true);		
        this.txtNurseNUmber.setHorizontalAlignment(2);		
        this.txtNurseNUmber.setMaxLength(100);		
        this.txtNurseNUmber.setRequired(false);
        // txtRecNurse		
        this.txtRecNurse.setVisible(true);		
        this.txtRecNurse.setHorizontalAlignment(2);		
        this.txtRecNurse.setMaxLength(100);		
        this.txtRecNurse.setRequired(false);
        // txtNurseOrderDiag		
        this.txtNurseOrderDiag.setVisible(true);		
        this.txtNurseOrderDiag.setHorizontalAlignment(2);		
        this.txtNurseOrderDiag.setMaxLength(100);		
        this.txtNurseOrderDiag.setRequired(false);
        // txtRecConNumber		
        this.txtRecConNumber.setVisible(true);		
        this.txtRecConNumber.setHorizontalAlignment(2);		
        this.txtRecConNumber.setMaxLength(100);		
        this.txtRecConNumber.setRequired(false);
        // txtRecConName		
        this.txtRecConName.setVisible(true);		
        this.txtRecConName.setHorizontalAlignment(2);		
        this.txtRecConName.setMaxLength(100);		
        this.txtRecConName.setRequired(false);
        // txtExcConNumber		
        this.txtExcConNumber.setVisible(true);		
        this.txtExcConNumber.setHorizontalAlignment(2);		
        this.txtExcConNumber.setMaxLength(100);		
        this.txtExcConNumber.setRequired(false);
        // txtExcConName		
        this.txtExcConName.setVisible(true);		
        this.txtExcConName.setHorizontalAlignment(2);		
        this.txtExcConName.setMaxLength(100);		
        this.txtExcConName.setRequired(false);
        // txtFirClassNumber		
        this.txtFirClassNumber.setVisible(true);		
        this.txtFirClassNumber.setHorizontalAlignment(2);		
        this.txtFirClassNumber.setMaxLength(100);		
        this.txtFirClassNumber.setRequired(false);
        // txtFirClassName		
        this.txtFirClassName.setVisible(true);		
        this.txtFirClassName.setHorizontalAlignment(2);		
        this.txtFirClassName.setMaxLength(100);		
        this.txtFirClassName.setRequired(false);
        // txtSecClassNumber		
        this.txtSecClassNumber.setVisible(true);		
        this.txtSecClassNumber.setHorizontalAlignment(2);		
        this.txtSecClassNumber.setMaxLength(100);		
        this.txtSecClassNumber.setRequired(false);
        // txtSecClassName		
        this.txtSecClassName.setVisible(true);		
        this.txtSecClassName.setHorizontalAlignment(2);		
        this.txtSecClassName.setMaxLength(100);		
        this.txtSecClassName.setRequired(false);
        // txtFeeItemDetail		
        this.txtFeeItemDetail.setVisible(true);		
        this.txtFeeItemDetail.setHorizontalAlignment(2);		
        this.txtFeeItemDetail.setMaxLength(100);		
        this.txtFeeItemDetail.setRequired(false);
        // txtRecPerson		
        this.txtRecPerson.setVisible(true);		
        this.txtRecPerson.setHorizontalAlignment(2);		
        this.txtRecPerson.setMaxLength(100);		
        this.txtRecPerson.setRequired(false);
        // txtQty		
        this.txtQty.setVisible(true);		
        this.txtQty.setHorizontalAlignment(2);		
        this.txtQty.setDataType(1);		
        this.txtQty.setSupportedEmpty(true);		
        this.txtQty.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtQty.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtQty.setPrecision(10);		
        this.txtQty.setRequired(false);
        // txtOriPrice		
        this.txtOriPrice.setVisible(true);		
        this.txtOriPrice.setHorizontalAlignment(2);		
        this.txtOriPrice.setDataType(1);		
        this.txtOriPrice.setSupportedEmpty(true);		
        this.txtOriPrice.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtOriPrice.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtOriPrice.setPrecision(10);		
        this.txtOriPrice.setRequired(false);
        // txtIncome		
        this.txtIncome.setVisible(true);		
        this.txtIncome.setHorizontalAlignment(2);		
        this.txtIncome.setDataType(1);		
        this.txtIncome.setSupportedEmpty(true);		
        this.txtIncome.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtIncome.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtIncome.setPrecision(10);		
        this.txtIncome.setRequired(false);
        // txtDiscount		
        this.txtDiscount.setVisible(true);		
        this.txtDiscount.setHorizontalAlignment(2);		
        this.txtDiscount.setDataType(1);		
        this.txtDiscount.setSupportedEmpty(true);		
        this.txtDiscount.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtDiscount.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtDiscount.setPrecision(10);		
        this.txtDiscount.setRequired(false);
        // txtTotalPrice		
        this.txtTotalPrice.setVisible(true);		
        this.txtTotalPrice.setHorizontalAlignment(2);		
        this.txtTotalPrice.setDataType(1);		
        this.txtTotalPrice.setSupportedEmpty(true);		
        this.txtTotalPrice.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtTotalPrice.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtTotalPrice.setPrecision(10);		
        this.txtTotalPrice.setRequired(false);
        // txtPayment		
        this.txtPayment.setVisible(true);		
        this.txtPayment.setHorizontalAlignment(2);		
        this.txtPayment.setMaxLength(100);		
        this.txtPayment.setRequired(false);
        // txtGiftPayment		
        this.txtGiftPayment.setVisible(true);		
        this.txtGiftPayment.setHorizontalAlignment(2);		
        this.txtGiftPayment.setMaxLength(100);		
        this.txtGiftPayment.setRequired(false);
        // txtcityNumber		
        this.txtcityNumber.setVisible(true);		
        this.txtcityNumber.setHorizontalAlignment(2);		
        this.txtcityNumber.setMaxLength(100);		
        this.txtcityNumber.setRequired(false);
        // txtfeeItemDetailNumber		
        this.txtfeeItemDetailNumber.setVisible(true);		
        this.txtfeeItemDetailNumber.setHorizontalAlignment(2);		
        this.txtfeeItemDetailNumber.setMaxLength(100);		
        this.txtfeeItemDetailNumber.setRequired(false);
        // txtisRoutine		
        this.txtisRoutine.setVisible(true);		
        this.txtisRoutine.setHorizontalAlignment(2);		
        this.txtisRoutine.setMaxLength(100);		
        this.txtisRoutine.setRequired(false);
        // txtbusiType		
        this.txtbusiType.setVisible(true);		
        this.txtbusiType.setHorizontalAlignment(2);		
        this.txtbusiType.setMaxLength(100);		
        this.txtbusiType.setRequired(false);
        // txthisOrderId		
        this.txthisOrderId.setVisible(true);		
        this.txthisOrderId.setHorizontalAlignment(2);		
        this.txthisOrderId.setMaxLength(100);		
        this.txthisOrderId.setRequired(false);
        // txthisdetailid		
        this.txthisdetailid.setVisible(true);		
        this.txthisdetailid.setHorizontalAlignment(2);		
        this.txthisdetailid.setMaxLength(100);		
        this.txthisdetailid.setRequired(false);
        // txtRecPersonNumber		
        this.txtRecPersonNumber.setVisible(true);		
        this.txtRecPersonNumber.setHorizontalAlignment(2);		
        this.txtRecPersonNumber.setMaxLength(100);		
        this.txtRecPersonNumber.setRequired(false);
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {txtCity,txtCaseNumber,txtClinicNumber,txtClinicName,txtName,txtFirSource,txtSecSource,txtTerSource,txtComplainNumber,txtComplainName,txtFirVis,txtCreateOrg,txtCreater,txtStatus,txtOrder,txtRecDotNumber,txtRecDotName,txtNurseNUmber,txtRecNurse,txtNurseOrderDiag,txtRecConNumber,txtRecConName,txtExcConNumber,txtExcConName,txtFirClassNumber,txtFirClassName,txtSecClassNumber,txtSecClassName,txtFeeItemDetail,txtRecPerson,txtQty,txtOriPrice,txtDiscount,txtIncome,txtTotalPrice,txtPayment,txtGiftPayment,txtcityNumber,txtfeeItemDetailNumber,txtisRoutine,txtbusiType,txthisOrderId,chkiscount,chkisneedout,chkisout,txthisdetailid,txtRecPersonNumber}));
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
        this.setBounds(new Rectangle(0, 0, 994, 485));
        this.setLayout(null);
        contCreator.setBounds(new Rectangle(334, 346, 270, 19));
        this.add(contCreator, null);
        contCreateTime.setBounds(new Rectangle(658, 346, 270, 19));
        this.add(contCreateTime, null);
        contLastUpdateUser.setBounds(new Rectangle(334, 370, 270, 19));
        this.add(contLastUpdateUser, null);
        contLastUpdateTime.setBounds(new Rectangle(658, 370, 270, 19));
        this.add(contLastUpdateTime, null);
        contNumber.setBounds(new Rectangle(334, 394, 270, 19));
        this.add(contNumber, null);
        contBizDate.setBounds(new Rectangle(10, 10, 270, 19));
        this.add(contBizDate, null);
        contDescription.setBounds(new Rectangle(10, 394, 270, 19));
        this.add(contDescription, null);
        contAuditor.setBounds(new Rectangle(10, 370, 270, 19));
        this.add(contAuditor, null);
        contCity.setBounds(new Rectangle(334, 10, 270, 19));
        this.add(contCity, null);
        contCaseNumber.setBounds(new Rectangle(658, 10, 270, 19));
        this.add(contCaseNumber, null);
        contClinicNumber.setBounds(new Rectangle(10, 34, 270, 19));
        this.add(contClinicNumber, null);
        contClinicName.setBounds(new Rectangle(334, 34, 270, 19));
        this.add(contClinicName, null);
        contName.setBounds(new Rectangle(658, 34, 270, 19));
        this.add(contName, null);
        contFirSource.setBounds(new Rectangle(10, 58, 270, 19));
        this.add(contFirSource, null);
        contSecSource.setBounds(new Rectangle(334, 58, 270, 19));
        this.add(contSecSource, null);
        contTerSource.setBounds(new Rectangle(658, 58, 270, 19));
        this.add(contTerSource, null);
        contComplainNumber.setBounds(new Rectangle(10, 82, 270, 19));
        this.add(contComplainNumber, null);
        contComplainName.setBounds(new Rectangle(334, 82, 270, 19));
        this.add(contComplainName, null);
        contFirVis.setBounds(new Rectangle(658, 82, 270, 19));
        this.add(contFirVis, null);
        contCreateOrg.setBounds(new Rectangle(10, 106, 270, 19));
        this.add(contCreateOrg, null);
        contCreater.setBounds(new Rectangle(334, 106, 270, 19));
        this.add(contCreater, null);
        contStatus.setBounds(new Rectangle(658, 106, 270, 19));
        this.add(contStatus, null);
        contOrder.setBounds(new Rectangle(658, 130, 270, 19));
        this.add(contOrder, null);
        contRecDotNumber.setBounds(new Rectangle(10, 130, 270, 19));
        this.add(contRecDotNumber, null);
        contRecDotName.setBounds(new Rectangle(334, 130, 270, 19));
        this.add(contRecDotName, null);
        contNurseNUmber.setBounds(new Rectangle(10, 154, 270, 19));
        this.add(contNurseNUmber, null);
        contRecNurse.setBounds(new Rectangle(334, 154, 270, 19));
        this.add(contRecNurse, null);
        contNurseOrderDiag.setBounds(new Rectangle(658, 154, 270, 19));
        this.add(contNurseOrderDiag, null);
        contRecConNumber.setBounds(new Rectangle(10, 178, 270, 19));
        this.add(contRecConNumber, null);
        contRecConName.setBounds(new Rectangle(334, 178, 270, 19));
        this.add(contRecConName, null);
        contExcConNumber.setBounds(new Rectangle(658, 178, 270, 19));
        this.add(contExcConNumber, null);
        contExcConName.setBounds(new Rectangle(10, 202, 270, 19));
        this.add(contExcConName, null);
        contFirClassNumber.setBounds(new Rectangle(334, 202, 270, 19));
        this.add(contFirClassNumber, null);
        contFirClassName.setBounds(new Rectangle(658, 202, 270, 19));
        this.add(contFirClassName, null);
        contSecClassNumber.setBounds(new Rectangle(334, 226, 270, 19));
        this.add(contSecClassNumber, null);
        contSecClassName.setBounds(new Rectangle(658, 226, 270, 19));
        this.add(contSecClassName, null);
        contFeeItemDetail.setBounds(new Rectangle(10, 226, 270, 19));
        this.add(contFeeItemDetail, null);
        contRecPerson.setBounds(new Rectangle(10, 250, 270, 19));
        this.add(contRecPerson, null);
        contQty.setBounds(new Rectangle(334, 250, 270, 19));
        this.add(contQty, null);
        contOriPrice.setBounds(new Rectangle(658, 250, 270, 19));
        this.add(contOriPrice, null);
        contIncome.setBounds(new Rectangle(658, 274, 270, 19));
        this.add(contIncome, null);
        contDiscount.setBounds(new Rectangle(334, 274, 270, 19));
        this.add(contDiscount, null);
        contTotalPrice.setBounds(new Rectangle(10, 274, 270, 19));
        this.add(contTotalPrice, null);
        contPayment.setBounds(new Rectangle(10, 298, 270, 19));
        this.add(contPayment, null);
        contGiftPayment.setBounds(new Rectangle(334, 298, 270, 19));
        this.add(contGiftPayment, null);
        contcityNumber.setBounds(new Rectangle(658, 298, 270, 19));
        this.add(contcityNumber, null);
        contfeeItemDetailNumber.setBounds(new Rectangle(10, 322, 270, 19));
        this.add(contfeeItemDetailNumber, null);
        contisRoutine.setBounds(new Rectangle(334, 322, 270, 19));
        this.add(contisRoutine, null);
        contbusiType.setBounds(new Rectangle(10, 346, 270, 19));
        this.add(contbusiType, null);
        conthisOrderId.setBounds(new Rectangle(658, 322, 270, 19));
        this.add(conthisOrderId, null);
        chkiscount.setBounds(new Rectangle(658, 418, 270, 19));
        this.add(chkiscount, null);
        chkisneedout.setBounds(new Rectangle(10, 418, 270, 19));
        this.add(chkisneedout, null);
        chkisout.setBounds(new Rectangle(334, 418, 270, 19));
        this.add(chkisout, null);
        conthisdetailid.setBounds(new Rectangle(658, 394, 270, 19));
        this.add(conthisdetailid, null);
        contRecPersonNumber.setBounds(new Rectangle(10, 442, 270, 19));
        this.add(contRecPersonNumber, null);
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
        //contCity
        contCity.setBoundEditor(txtCity);
        //contCaseNumber
        contCaseNumber.setBoundEditor(txtCaseNumber);
        //contClinicNumber
        contClinicNumber.setBoundEditor(txtClinicNumber);
        //contClinicName
        contClinicName.setBoundEditor(txtClinicName);
        //contName
        contName.setBoundEditor(txtName);
        //contFirSource
        contFirSource.setBoundEditor(txtFirSource);
        //contSecSource
        contSecSource.setBoundEditor(txtSecSource);
        //contTerSource
        contTerSource.setBoundEditor(txtTerSource);
        //contComplainNumber
        contComplainNumber.setBoundEditor(txtComplainNumber);
        //contComplainName
        contComplainName.setBoundEditor(txtComplainName);
        //contFirVis
        contFirVis.setBoundEditor(txtFirVis);
        //contCreateOrg
        contCreateOrg.setBoundEditor(txtCreateOrg);
        //contCreater
        contCreater.setBoundEditor(txtCreater);
        //contStatus
        contStatus.setBoundEditor(txtStatus);
        //contOrder
        contOrder.setBoundEditor(txtOrder);
        //contRecDotNumber
        contRecDotNumber.setBoundEditor(txtRecDotNumber);
        //contRecDotName
        contRecDotName.setBoundEditor(txtRecDotName);
        //contNurseNUmber
        contNurseNUmber.setBoundEditor(txtNurseNUmber);
        //contRecNurse
        contRecNurse.setBoundEditor(txtRecNurse);
        //contNurseOrderDiag
        contNurseOrderDiag.setBoundEditor(txtNurseOrderDiag);
        //contRecConNumber
        contRecConNumber.setBoundEditor(txtRecConNumber);
        //contRecConName
        contRecConName.setBoundEditor(txtRecConName);
        //contExcConNumber
        contExcConNumber.setBoundEditor(txtExcConNumber);
        //contExcConName
        contExcConName.setBoundEditor(txtExcConName);
        //contFirClassNumber
        contFirClassNumber.setBoundEditor(txtFirClassNumber);
        //contFirClassName
        contFirClassName.setBoundEditor(txtFirClassName);
        //contSecClassNumber
        contSecClassNumber.setBoundEditor(txtSecClassNumber);
        //contSecClassName
        contSecClassName.setBoundEditor(txtSecClassName);
        //contFeeItemDetail
        contFeeItemDetail.setBoundEditor(txtFeeItemDetail);
        //contRecPerson
        contRecPerson.setBoundEditor(txtRecPerson);
        //contQty
        contQty.setBoundEditor(txtQty);
        //contOriPrice
        contOriPrice.setBoundEditor(txtOriPrice);
        //contIncome
        contIncome.setBoundEditor(txtIncome);
        //contDiscount
        contDiscount.setBoundEditor(txtDiscount);
        //contTotalPrice
        contTotalPrice.setBoundEditor(txtTotalPrice);
        //contPayment
        contPayment.setBoundEditor(txtPayment);
        //contGiftPayment
        contGiftPayment.setBoundEditor(txtGiftPayment);
        //contcityNumber
        contcityNumber.setBoundEditor(txtcityNumber);
        //contfeeItemDetailNumber
        contfeeItemDetailNumber.setBoundEditor(txtfeeItemDetailNumber);
        //contisRoutine
        contisRoutine.setBoundEditor(txtisRoutine);
        //contbusiType
        contbusiType.setBoundEditor(txtbusiType);
        //conthisOrderId
        conthisOrderId.setBoundEditor(txthisOrderId);
        //conthisdetailid
        conthisdetailid.setBoundEditor(txthisdetailid);
        //contRecPersonNumber
        contRecPersonNumber.setBoundEditor(txtRecPersonNumber);

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
		dataBinder.registerBinding("iscount", boolean.class, this.chkiscount, "selected");
		dataBinder.registerBinding("isneedout", boolean.class, this.chkisneedout, "selected");
		dataBinder.registerBinding("isout", boolean.class, this.chkisout, "selected");
		dataBinder.registerBinding("creator", com.kingdee.eas.base.permission.UserInfo.class, this.prmtCreator, "data");
		dataBinder.registerBinding("createTime", java.sql.Timestamp.class, this.kDDateCreateTime, "value");
		dataBinder.registerBinding("lastUpdateUser", com.kingdee.eas.base.permission.UserInfo.class, this.prmtLastUpdateUser, "data");
		dataBinder.registerBinding("lastUpdateTime", java.sql.Timestamp.class, this.kDDateLastUpdateTime, "value");
		dataBinder.registerBinding("number", String.class, this.txtNumber, "text");
		dataBinder.registerBinding("bizDate", java.util.Date.class, this.pkBizDate, "value");
		dataBinder.registerBinding("description", String.class, this.txtDescription, "text");
		dataBinder.registerBinding("auditor", com.kingdee.eas.base.permission.UserInfo.class, this.prmtAuditor, "data");
		dataBinder.registerBinding("City", String.class, this.txtCity, "text");
		dataBinder.registerBinding("CaseNumber", String.class, this.txtCaseNumber, "text");
		dataBinder.registerBinding("ClinicNumber", String.class, this.txtClinicNumber, "text");
		dataBinder.registerBinding("ClinicName", String.class, this.txtClinicName, "text");
		dataBinder.registerBinding("Name", String.class, this.txtName, "text");
		dataBinder.registerBinding("FirSource", String.class, this.txtFirSource, "text");
		dataBinder.registerBinding("SecSource", String.class, this.txtSecSource, "text");
		dataBinder.registerBinding("TerSource", String.class, this.txtTerSource, "text");
		dataBinder.registerBinding("ComplainNumber", String.class, this.txtComplainNumber, "text");
		dataBinder.registerBinding("ComplainName", String.class, this.txtComplainName, "text");
		dataBinder.registerBinding("FirVis", String.class, this.txtFirVis, "text");
		dataBinder.registerBinding("CreateOrg", String.class, this.txtCreateOrg, "text");
		dataBinder.registerBinding("Creater", String.class, this.txtCreater, "text");
		dataBinder.registerBinding("Status", String.class, this.txtStatus, "text");
		dataBinder.registerBinding("Order", String.class, this.txtOrder, "text");
		dataBinder.registerBinding("RecDotNumber", String.class, this.txtRecDotNumber, "text");
		dataBinder.registerBinding("RecDotName", String.class, this.txtRecDotName, "text");
		dataBinder.registerBinding("NurseNUmber", String.class, this.txtNurseNUmber, "text");
		dataBinder.registerBinding("RecNurse", String.class, this.txtRecNurse, "text");
		dataBinder.registerBinding("NurseOrderDiag", String.class, this.txtNurseOrderDiag, "text");
		dataBinder.registerBinding("RecConNumber", String.class, this.txtRecConNumber, "text");
		dataBinder.registerBinding("RecConName", String.class, this.txtRecConName, "text");
		dataBinder.registerBinding("ExcConNumber", String.class, this.txtExcConNumber, "text");
		dataBinder.registerBinding("ExcConName", String.class, this.txtExcConName, "text");
		dataBinder.registerBinding("FirClassNumber", String.class, this.txtFirClassNumber, "text");
		dataBinder.registerBinding("FirClassName", String.class, this.txtFirClassName, "text");
		dataBinder.registerBinding("SecClassNumber", String.class, this.txtSecClassNumber, "text");
		dataBinder.registerBinding("SecClassName", String.class, this.txtSecClassName, "text");
		dataBinder.registerBinding("FeeItemDetail", String.class, this.txtFeeItemDetail, "text");
		dataBinder.registerBinding("RecPerson", String.class, this.txtRecPerson, "text");
		dataBinder.registerBinding("Qty", java.math.BigDecimal.class, this.txtQty, "value");
		dataBinder.registerBinding("OriPrice", java.math.BigDecimal.class, this.txtOriPrice, "value");
		dataBinder.registerBinding("Income", java.math.BigDecimal.class, this.txtIncome, "value");
		dataBinder.registerBinding("Discount", java.math.BigDecimal.class, this.txtDiscount, "value");
		dataBinder.registerBinding("TotalPrice", java.math.BigDecimal.class, this.txtTotalPrice, "value");
		dataBinder.registerBinding("Payment", String.class, this.txtPayment, "text");
		dataBinder.registerBinding("GiftPayment", String.class, this.txtGiftPayment, "text");
		dataBinder.registerBinding("cityNumber", String.class, this.txtcityNumber, "text");
		dataBinder.registerBinding("feeItemDetailNumber", String.class, this.txtfeeItemDetailNumber, "text");
		dataBinder.registerBinding("isRoutine", String.class, this.txtisRoutine, "text");
		dataBinder.registerBinding("busiType", String.class, this.txtbusiType, "text");
		dataBinder.registerBinding("hisOrderId", String.class, this.txthisOrderId, "text");
		dataBinder.registerBinding("hisdetailid", String.class, this.txthisdetailid, "text");
		dataBinder.registerBinding("RecPersonNumber", String.class, this.txtRecPersonNumber, "text");		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.mw.pay.app.AchieveDetailEditUIHandler";
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
        this.txtCity.requestFocusInWindow();
    }

	
	

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject)
    {
        IObjectValue ov = dataObject;        	    	
        super.setDataObject(ov);
        this.editData = (com.kingdee.eas.mw.pay.AchieveDetailInfo)ov;
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
		getValidateHelper().registerBindProperty("iscount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("isneedout", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("isout", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("creator", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("createTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lastUpdateUser", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lastUpdateTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("number", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("bizDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("description", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditor", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("City", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("CaseNumber", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("ClinicNumber", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("ClinicName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Name", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("FirSource", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("SecSource", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("TerSource", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("ComplainNumber", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("ComplainName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("FirVis", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("CreateOrg", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Creater", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Status", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Order", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("RecDotNumber", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("RecDotName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("NurseNUmber", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("RecNurse", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("NurseOrderDiag", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("RecConNumber", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("RecConName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("ExcConNumber", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("ExcConName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("FirClassNumber", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("FirClassName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("SecClassNumber", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("SecClassName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("FeeItemDetail", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("RecPerson", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Qty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("OriPrice", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Income", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Discount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("TotalPrice", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Payment", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("GiftPayment", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("cityNumber", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("feeItemDetailNumber", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("isRoutine", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("busiType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("hisOrderId", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("hisdetailid", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("RecPersonNumber", ValidateHelper.ON_SAVE);    		
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
        sic.add(new SelectorItemInfo("iscount"));
        sic.add(new SelectorItemInfo("isneedout"));
        sic.add(new SelectorItemInfo("isout"));
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
        sic.add(new SelectorItemInfo("City"));
        sic.add(new SelectorItemInfo("CaseNumber"));
        sic.add(new SelectorItemInfo("ClinicNumber"));
        sic.add(new SelectorItemInfo("ClinicName"));
        sic.add(new SelectorItemInfo("Name"));
        sic.add(new SelectorItemInfo("FirSource"));
        sic.add(new SelectorItemInfo("SecSource"));
        sic.add(new SelectorItemInfo("TerSource"));
        sic.add(new SelectorItemInfo("ComplainNumber"));
        sic.add(new SelectorItemInfo("ComplainName"));
        sic.add(new SelectorItemInfo("FirVis"));
        sic.add(new SelectorItemInfo("CreateOrg"));
        sic.add(new SelectorItemInfo("Creater"));
        sic.add(new SelectorItemInfo("Status"));
        sic.add(new SelectorItemInfo("Order"));
        sic.add(new SelectorItemInfo("RecDotNumber"));
        sic.add(new SelectorItemInfo("RecDotName"));
        sic.add(new SelectorItemInfo("NurseNUmber"));
        sic.add(new SelectorItemInfo("RecNurse"));
        sic.add(new SelectorItemInfo("NurseOrderDiag"));
        sic.add(new SelectorItemInfo("RecConNumber"));
        sic.add(new SelectorItemInfo("RecConName"));
        sic.add(new SelectorItemInfo("ExcConNumber"));
        sic.add(new SelectorItemInfo("ExcConName"));
        sic.add(new SelectorItemInfo("FirClassNumber"));
        sic.add(new SelectorItemInfo("FirClassName"));
        sic.add(new SelectorItemInfo("SecClassNumber"));
        sic.add(new SelectorItemInfo("SecClassName"));
        sic.add(new SelectorItemInfo("FeeItemDetail"));
        sic.add(new SelectorItemInfo("RecPerson"));
        sic.add(new SelectorItemInfo("Qty"));
        sic.add(new SelectorItemInfo("OriPrice"));
        sic.add(new SelectorItemInfo("Income"));
        sic.add(new SelectorItemInfo("Discount"));
        sic.add(new SelectorItemInfo("TotalPrice"));
        sic.add(new SelectorItemInfo("Payment"));
        sic.add(new SelectorItemInfo("GiftPayment"));
        sic.add(new SelectorItemInfo("cityNumber"));
        sic.add(new SelectorItemInfo("feeItemDetailNumber"));
        sic.add(new SelectorItemInfo("isRoutine"));
        sic.add(new SelectorItemInfo("busiType"));
        sic.add(new SelectorItemInfo("hisOrderId"));
        sic.add(new SelectorItemInfo("hisdetailid"));
        sic.add(new SelectorItemInfo("RecPersonNumber"));
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
        return new MetaDataPK("com.kingdee.eas.mw.pay.client", "AchieveDetailEditUI");
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
        return com.kingdee.eas.mw.pay.client.AchieveDetailEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.mw.pay.AchieveDetailFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.mw.pay.AchieveDetailInfo objectValue = new com.kingdee.eas.mw.pay.AchieveDetailInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


    	protected String getTDFileName() {
    	return "/bim/mw/pay/AchieveDetail";
	}
    protected IMetaDataPK getTDQueryPK() {
    	return new MetaDataPK("com.kingdee.eas.mw.pay.app.AchieveDetailQuery");
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