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
public abstract class AbstractAchRoyaltyRuleEditUI extends com.kingdee.eas.framework.client.EditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractAchRoyaltyRuleEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer2;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer3;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer4;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contstatus;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contempNumber;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contempName;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcityNumber;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcityName;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbaseAch;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contshopPro;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contpersonPro;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbusinessPro;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contreduceAmount;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contrewardAmount;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contclinicNumber;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contclinicName;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contotherNumber;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contclinic;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcity;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contclinicType;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contshopProText;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbusinessProText;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contpersonProText;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbasePay;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contclinicbaseAch;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbusinessDate;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox txtName;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtSimpleName;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox txtDescription;
    protected com.kingdee.bos.ctrl.swing.KDComboBox status;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtempNumber;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtempName;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtcityNumber;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtcityName;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtbaseAch;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtshopPro;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtpersonPro;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtbusinessPro;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtreduceAmount;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtrewardAmount;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtclinicNumber;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtclinicName;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtotherNumber;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtclinic;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcity;
    protected com.kingdee.bos.ctrl.swing.KDComboBox clinicType;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtshopProText;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtbusinessProText;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtpersonProText;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtbasePay;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtclinicbaseAch;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtbusinessDate;
    protected com.kingdee.eas.mw.pay.AchRoyaltyRuleInfo editData = null;
    /**
     * output class constructor
     */
    public AbstractAchRoyaltyRuleEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractAchRoyaltyRuleEditUI.class.getName());
        this.setUITitle(resHelper.getString("this.title"));
        this.kDLabelContainer1 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer2 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer3 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer4 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contstatus = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contempNumber = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contempName = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcityNumber = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcityName = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbaseAch = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contshopPro = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contpersonPro = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbusinessPro = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contreduceAmount = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contrewardAmount = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contclinicNumber = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contclinicName = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contotherNumber = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contclinic = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcity = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contclinicType = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contshopProText = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbusinessProText = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contpersonProText = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbasePay = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contclinicbaseAch = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbusinessDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtName = new com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox();
        this.txtSimpleName = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtDescription = new com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox();
        this.status = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.txtempNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtempName = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtcityNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtcityName = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtbaseAch = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtshopPro = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtpersonPro = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtbusinessPro = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtreduceAmount = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtrewardAmount = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtclinicNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtclinicName = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtotherNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtclinic = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtcity = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.clinicType = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.txtshopProText = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtbusinessProText = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtpersonProText = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtbasePay = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtclinicbaseAch = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtbusinessDate = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.kDLabelContainer1.setName("kDLabelContainer1");
        this.kDLabelContainer2.setName("kDLabelContainer2");
        this.kDLabelContainer3.setName("kDLabelContainer3");
        this.kDLabelContainer4.setName("kDLabelContainer4");
        this.contstatus.setName("contstatus");
        this.contempNumber.setName("contempNumber");
        this.contempName.setName("contempName");
        this.contcityNumber.setName("contcityNumber");
        this.contcityName.setName("contcityName");
        this.contbaseAch.setName("contbaseAch");
        this.contshopPro.setName("contshopPro");
        this.contpersonPro.setName("contpersonPro");
        this.contbusinessPro.setName("contbusinessPro");
        this.contreduceAmount.setName("contreduceAmount");
        this.contrewardAmount.setName("contrewardAmount");
        this.contclinicNumber.setName("contclinicNumber");
        this.contclinicName.setName("contclinicName");
        this.contotherNumber.setName("contotherNumber");
        this.contclinic.setName("contclinic");
        this.contcity.setName("contcity");
        this.contclinicType.setName("contclinicType");
        this.contshopProText.setName("contshopProText");
        this.contbusinessProText.setName("contbusinessProText");
        this.contpersonProText.setName("contpersonProText");
        this.contbasePay.setName("contbasePay");
        this.contclinicbaseAch.setName("contclinicbaseAch");
        this.contbusinessDate.setName("contbusinessDate");
        this.txtNumber.setName("txtNumber");
        this.txtName.setName("txtName");
        this.txtSimpleName.setName("txtSimpleName");
        this.txtDescription.setName("txtDescription");
        this.status.setName("status");
        this.txtempNumber.setName("txtempNumber");
        this.txtempName.setName("txtempName");
        this.txtcityNumber.setName("txtcityNumber");
        this.txtcityName.setName("txtcityName");
        this.txtbaseAch.setName("txtbaseAch");
        this.txtshopPro.setName("txtshopPro");
        this.txtpersonPro.setName("txtpersonPro");
        this.txtbusinessPro.setName("txtbusinessPro");
        this.txtreduceAmount.setName("txtreduceAmount");
        this.txtrewardAmount.setName("txtrewardAmount");
        this.txtclinicNumber.setName("txtclinicNumber");
        this.txtclinicName.setName("txtclinicName");
        this.txtotherNumber.setName("txtotherNumber");
        this.prmtclinic.setName("prmtclinic");
        this.prmtcity.setName("prmtcity");
        this.clinicType.setName("clinicType");
        this.txtshopProText.setName("txtshopProText");
        this.txtbusinessProText.setName("txtbusinessProText");
        this.txtpersonProText.setName("txtpersonProText");
        this.txtbasePay.setName("txtbasePay");
        this.txtclinicbaseAch.setName("txtclinicbaseAch");
        this.txtbusinessDate.setName("txtbusinessDate");
        // CoreUI		
        this.btnPrint.setVisible(false);		
        this.btnPrintPreview.setVisible(false);		
        this.menuItemPrint.setVisible(false);		
        this.menuItemPrintPreview.setVisible(false);
        // kDLabelContainer1		
        this.kDLabelContainer1.setBoundLabelText(resHelper.getString("kDLabelContainer1.boundLabelText"));		
        this.kDLabelContainer1.setBoundLabelLength(100);		
        this.kDLabelContainer1.setBoundLabelUnderline(true);
        // kDLabelContainer2		
        this.kDLabelContainer2.setBoundLabelText(resHelper.getString("kDLabelContainer2.boundLabelText"));		
        this.kDLabelContainer2.setBoundLabelLength(100);		
        this.kDLabelContainer2.setBoundLabelUnderline(true);
        // kDLabelContainer3		
        this.kDLabelContainer3.setBoundLabelText(resHelper.getString("kDLabelContainer3.boundLabelText"));		
        this.kDLabelContainer3.setBoundLabelLength(100);		
        this.kDLabelContainer3.setBoundLabelUnderline(true);		
        this.kDLabelContainer3.setVisible(false);
        // kDLabelContainer4		
        this.kDLabelContainer4.setBoundLabelText(resHelper.getString("kDLabelContainer4.boundLabelText"));		
        this.kDLabelContainer4.setBoundLabelLength(100);		
        this.kDLabelContainer4.setBoundLabelUnderline(true);		
        this.kDLabelContainer4.setBoundLabelAlignment(7);		
        this.kDLabelContainer4.setVisible(false);
        // contstatus		
        this.contstatus.setBoundLabelText(resHelper.getString("contstatus.boundLabelText"));		
        this.contstatus.setBoundLabelLength(100);		
        this.contstatus.setBoundLabelUnderline(true);		
        this.contstatus.setVisible(true);
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
        // contbaseAch		
        this.contbaseAch.setBoundLabelText(resHelper.getString("contbaseAch.boundLabelText"));		
        this.contbaseAch.setBoundLabelLength(100);		
        this.contbaseAch.setBoundLabelUnderline(true);		
        this.contbaseAch.setVisible(true);
        // contshopPro		
        this.contshopPro.setBoundLabelText(resHelper.getString("contshopPro.boundLabelText"));		
        this.contshopPro.setBoundLabelLength(100);		
        this.contshopPro.setBoundLabelUnderline(true);		
        this.contshopPro.setVisible(true);
        // contpersonPro		
        this.contpersonPro.setBoundLabelText(resHelper.getString("contpersonPro.boundLabelText"));		
        this.contpersonPro.setBoundLabelLength(100);		
        this.contpersonPro.setBoundLabelUnderline(true);		
        this.contpersonPro.setVisible(true);
        // contbusinessPro		
        this.contbusinessPro.setBoundLabelText(resHelper.getString("contbusinessPro.boundLabelText"));		
        this.contbusinessPro.setBoundLabelLength(100);		
        this.contbusinessPro.setBoundLabelUnderline(true);		
        this.contbusinessPro.setVisible(true);
        // contreduceAmount		
        this.contreduceAmount.setBoundLabelText(resHelper.getString("contreduceAmount.boundLabelText"));		
        this.contreduceAmount.setBoundLabelLength(100);		
        this.contreduceAmount.setBoundLabelUnderline(true);		
        this.contreduceAmount.setVisible(true);
        // contrewardAmount		
        this.contrewardAmount.setBoundLabelText(resHelper.getString("contrewardAmount.boundLabelText"));		
        this.contrewardAmount.setBoundLabelLength(100);		
        this.contrewardAmount.setBoundLabelUnderline(true);		
        this.contrewardAmount.setVisible(true);
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
        // contotherNumber		
        this.contotherNumber.setBoundLabelText(resHelper.getString("contotherNumber.boundLabelText"));		
        this.contotherNumber.setBoundLabelLength(100);		
        this.contotherNumber.setBoundLabelUnderline(true);		
        this.contotherNumber.setVisible(true);
        // contclinic		
        this.contclinic.setBoundLabelText(resHelper.getString("contclinic.boundLabelText"));		
        this.contclinic.setBoundLabelLength(100);		
        this.contclinic.setBoundLabelUnderline(true);		
        this.contclinic.setVisible(true);
        // contcity		
        this.contcity.setBoundLabelText(resHelper.getString("contcity.boundLabelText"));		
        this.contcity.setBoundLabelLength(100);		
        this.contcity.setBoundLabelUnderline(true);		
        this.contcity.setVisible(true);
        // contclinicType		
        this.contclinicType.setBoundLabelText(resHelper.getString("contclinicType.boundLabelText"));		
        this.contclinicType.setBoundLabelLength(100);		
        this.contclinicType.setBoundLabelUnderline(true);		
        this.contclinicType.setVisible(true);
        // contshopProText		
        this.contshopProText.setBoundLabelText(resHelper.getString("contshopProText.boundLabelText"));		
        this.contshopProText.setBoundLabelLength(100);		
        this.contshopProText.setBoundLabelUnderline(true);		
        this.contshopProText.setVisible(true);
        // contbusinessProText		
        this.contbusinessProText.setBoundLabelText(resHelper.getString("contbusinessProText.boundLabelText"));		
        this.contbusinessProText.setBoundLabelLength(100);		
        this.contbusinessProText.setBoundLabelUnderline(true);		
        this.contbusinessProText.setVisible(true);
        // contpersonProText		
        this.contpersonProText.setBoundLabelText(resHelper.getString("contpersonProText.boundLabelText"));		
        this.contpersonProText.setBoundLabelLength(100);		
        this.contpersonProText.setBoundLabelUnderline(true);		
        this.contpersonProText.setVisible(true);
        // contbasePay		
        this.contbasePay.setBoundLabelText(resHelper.getString("contbasePay.boundLabelText"));		
        this.contbasePay.setBoundLabelLength(100);		
        this.contbasePay.setBoundLabelUnderline(true);		
        this.contbasePay.setVisible(true);
        // contclinicbaseAch		
        this.contclinicbaseAch.setBoundLabelText(resHelper.getString("contclinicbaseAch.boundLabelText"));		
        this.contclinicbaseAch.setBoundLabelLength(100);		
        this.contclinicbaseAch.setBoundLabelUnderline(true);		
        this.contclinicbaseAch.setVisible(true);
        // contbusinessDate		
        this.contbusinessDate.setBoundLabelText(resHelper.getString("contbusinessDate.boundLabelText"));		
        this.contbusinessDate.setBoundLabelLength(100);		
        this.contbusinessDate.setBoundLabelUnderline(true);		
        this.contbusinessDate.setVisible(true);
        // txtNumber		
        this.txtNumber.setMaxLength(80);
        // txtName
        // txtSimpleName		
        this.txtSimpleName.setMaxLength(80);		
        this.txtSimpleName.setEnabled(false);		
        this.txtSimpleName.setVisible(false);		
        this.txtSimpleName.setOpaque(false);
        // txtDescription		
        this.txtDescription.setEnabled(false);		
        this.txtDescription.setVisible(false);		
        this.txtDescription.setOpaque(false);
        // status		
        this.status.setVisible(true);		
        this.status.addItems(EnumUtils.getEnumList("com.kingdee.eas.mw.pay.app.PayPostStatus").toArray());		
        this.status.setRequired(false);
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
        // txtbaseAch		
        this.txtbaseAch.setVisible(true);		
        this.txtbaseAch.setHorizontalAlignment(2);		
        this.txtbaseAch.setDataType(1);		
        this.txtbaseAch.setSupportedEmpty(true);		
        this.txtbaseAch.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtbaseAch.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtbaseAch.setPrecision(2);		
        this.txtbaseAch.setRequired(false);
        // txtshopPro		
        this.txtshopPro.setVisible(true);		
        this.txtshopPro.setHorizontalAlignment(2);		
        this.txtshopPro.setDataType(1);		
        this.txtshopPro.setSupportedEmpty(true);		
        this.txtshopPro.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtshopPro.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtshopPro.setPrecision(10);		
        this.txtshopPro.setRequired(false);
        // txtpersonPro		
        this.txtpersonPro.setVisible(true);		
        this.txtpersonPro.setHorizontalAlignment(2);		
        this.txtpersonPro.setDataType(1);		
        this.txtpersonPro.setSupportedEmpty(true);		
        this.txtpersonPro.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtpersonPro.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtpersonPro.setPrecision(10);		
        this.txtpersonPro.setRequired(false);
        // txtbusinessPro		
        this.txtbusinessPro.setVisible(true);		
        this.txtbusinessPro.setHorizontalAlignment(2);		
        this.txtbusinessPro.setDataType(1);		
        this.txtbusinessPro.setSupportedEmpty(true);		
        this.txtbusinessPro.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtbusinessPro.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtbusinessPro.setPrecision(10);		
        this.txtbusinessPro.setRequired(false);
        // txtreduceAmount		
        this.txtreduceAmount.setVisible(true);		
        this.txtreduceAmount.setHorizontalAlignment(2);		
        this.txtreduceAmount.setDataType(1);		
        this.txtreduceAmount.setSupportedEmpty(true);		
        this.txtreduceAmount.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtreduceAmount.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtreduceAmount.setPrecision(10);		
        this.txtreduceAmount.setRequired(false);
        // txtrewardAmount		
        this.txtrewardAmount.setVisible(true);		
        this.txtrewardAmount.setHorizontalAlignment(2);		
        this.txtrewardAmount.setDataType(1);		
        this.txtrewardAmount.setSupportedEmpty(true);		
        this.txtrewardAmount.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtrewardAmount.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtrewardAmount.setPrecision(10);		
        this.txtrewardAmount.setRequired(false);
        // txtclinicNumber		
        this.txtclinicNumber.setVisible(true);		
        this.txtclinicNumber.setHorizontalAlignment(2);		
        this.txtclinicNumber.setMaxLength(100);		
        this.txtclinicNumber.setRequired(false);
        // txtclinicName		
        this.txtclinicName.setVisible(true);		
        this.txtclinicName.setHorizontalAlignment(2);		
        this.txtclinicName.setMaxLength(100);		
        this.txtclinicName.setRequired(false);
        // txtotherNumber		
        this.txtotherNumber.setVisible(true);		
        this.txtotherNumber.setHorizontalAlignment(2);		
        this.txtotherNumber.setMaxLength(100);		
        this.txtotherNumber.setRequired(false);
        // prmtclinic		
        this.prmtclinic.setQueryInfo("com.kingdee.eas.basedata.org.app.CompanyOrgUnitQuery");		
        this.prmtclinic.setVisible(true);		
        this.prmtclinic.setEditable(true);		
        this.prmtclinic.setDisplayFormat("$name$");		
        this.prmtclinic.setEditFormat("$number$");		
        this.prmtclinic.setCommitFormat("$number$");		
        this.prmtclinic.setRequired(false);
        // prmtcity		
        this.prmtcity.setQueryInfo("com.kingdee.eas.basedata.org.app.CUQuery");		
        this.prmtcity.setVisible(true);		
        this.prmtcity.setEditable(true);		
        this.prmtcity.setDisplayFormat("$name$");		
        this.prmtcity.setEditFormat("$number$");		
        this.prmtcity.setCommitFormat("$number$");		
        this.prmtcity.setRequired(false);
        // clinicType		
        this.clinicType.setVisible(true);		
        this.clinicType.addItems(EnumUtils.getEnumList("com.kingdee.eas.mw.pay.app.ClinicOtherSize").toArray());		
        this.clinicType.setRequired(false);
        // txtshopProText		
        this.txtshopProText.setVisible(true);		
        this.txtshopProText.setHorizontalAlignment(2);		
        this.txtshopProText.setMaxLength(100);		
        this.txtshopProText.setRequired(false);
        // txtbusinessProText		
        this.txtbusinessProText.setVisible(true);		
        this.txtbusinessProText.setHorizontalAlignment(2);		
        this.txtbusinessProText.setMaxLength(100);		
        this.txtbusinessProText.setRequired(false);
        // txtpersonProText		
        this.txtpersonProText.setVisible(true);		
        this.txtpersonProText.setHorizontalAlignment(2);		
        this.txtpersonProText.setMaxLength(100);		
        this.txtpersonProText.setRequired(false);
        // txtbasePay		
        this.txtbasePay.setVisible(true);		
        this.txtbasePay.setHorizontalAlignment(2);		
        this.txtbasePay.setDataType(1);		
        this.txtbasePay.setSupportedEmpty(true);		
        this.txtbasePay.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtbasePay.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtbasePay.setPrecision(10);		
        this.txtbasePay.setRequired(false);
        // txtclinicbaseAch		
        this.txtclinicbaseAch.setVisible(true);		
        this.txtclinicbaseAch.setHorizontalAlignment(2);		
        this.txtclinicbaseAch.setDataType(1);		
        this.txtclinicbaseAch.setSupportedEmpty(true);		
        this.txtclinicbaseAch.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtclinicbaseAch.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtclinicbaseAch.setPrecision(10);		
        this.txtclinicbaseAch.setRequired(false);
        // txtbusinessDate		
        this.txtbusinessDate.setVisible(true);		
        this.txtbusinessDate.setHorizontalAlignment(2);		
        this.txtbusinessDate.setMaxLength(100);		
        this.txtbusinessDate.setRequired(false);
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {status,txtempNumber,txtempName,txtcityNumber,txtcityName,txtbaseAch,txtshopPro,txtpersonPro,txtbusinessPro,txtreduceAmount,txtrewardAmount,txtclinicNumber,txtclinicName,txtotherNumber,prmtclinic,prmtcity,clinicType,txtshopProText,txtbusinessProText,txtpersonProText,txtbasePay,txtclinicbaseAch,txtbusinessDate}));
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
        this.setBounds(new Rectangle(0, 0, 1013, 245));
        this.setLayout(null);
        kDLabelContainer1.setBounds(new Rectangle(672, 154, 270, 19));
        this.add(kDLabelContainer1, null);
        kDLabelContainer2.setBounds(new Rectangle(341, 10, 270, 19));
        this.add(kDLabelContainer2, null);
        kDLabelContainer3.setBounds(new Rectangle(341, 154, 270, 19));
        this.add(kDLabelContainer3, null);
        kDLabelContainer4.setBounds(new Rectangle(10, 178, 270, 19));
        this.add(kDLabelContainer4, null);
        contstatus.setBounds(new Rectangle(672, 10, 270, 19));
        this.add(contstatus, null);
        contempNumber.setBounds(new Rectangle(672, 34, 270, 19));
        this.add(contempNumber, null);
        contempName.setBounds(new Rectangle(10, 58, 270, 19));
        this.add(contempName, null);
        contcityNumber.setBounds(new Rectangle(341, 130, 270, 19));
        this.add(contcityNumber, null);
        contcityName.setBounds(new Rectangle(10, 202, 270, 19));
        this.add(contcityName, null);
        contbaseAch.setBounds(new Rectangle(341, 82, 270, 19));
        this.add(contbaseAch, null);
        contshopPro.setBounds(new Rectangle(341, 106, 270, 19));
        this.add(contshopPro, null);
        contpersonPro.setBounds(new Rectangle(672, 106, 270, 19));
        this.add(contpersonPro, null);
        contbusinessPro.setBounds(new Rectangle(672, 82, 270, 19));
        this.add(contbusinessPro, null);
        contreduceAmount.setBounds(new Rectangle(10, 130, 270, 19));
        this.add(contreduceAmount, null);
        contrewardAmount.setBounds(new Rectangle(672, 58, 270, 19));
        this.add(contrewardAmount, null);
        contclinicNumber.setBounds(new Rectangle(341, 202, 270, 19));
        this.add(contclinicNumber, null);
        contclinicName.setBounds(new Rectangle(341, 178, 270, 19));
        this.add(contclinicName, null);
        contotherNumber.setBounds(new Rectangle(10, 10, 270, 19));
        this.add(contotherNumber, null);
        contclinic.setBounds(new Rectangle(341, 34, 270, 19));
        this.add(contclinic, null);
        contcity.setBounds(new Rectangle(10, 34, 270, 19));
        this.add(contcity, null);
        contclinicType.setBounds(new Rectangle(10, 82, 270, 19));
        this.add(contclinicType, null);
        contshopProText.setBounds(new Rectangle(10, 154, 270, 19));
        this.add(contshopProText, null);
        contbusinessProText.setBounds(new Rectangle(672, 178, 270, 19));
        this.add(contbusinessProText, null);
        contpersonProText.setBounds(new Rectangle(672, 130, 270, 19));
        this.add(contpersonProText, null);
        contbasePay.setBounds(new Rectangle(341, 58, 270, 19));
        this.add(contbasePay, null);
        contclinicbaseAch.setBounds(new Rectangle(10, 106, 270, 19));
        this.add(contclinicbaseAch, null);
        contbusinessDate.setBounds(new Rectangle(672, 202, 270, 19));
        this.add(contbusinessDate, null);
        //kDLabelContainer1
        kDLabelContainer1.setBoundEditor(txtNumber);
        //kDLabelContainer2
        kDLabelContainer2.setBoundEditor(txtName);
        //kDLabelContainer3
        kDLabelContainer3.setBoundEditor(txtSimpleName);
        //kDLabelContainer4
        kDLabelContainer4.setBoundEditor(txtDescription);
        //contstatus
        contstatus.setBoundEditor(status);
        //contempNumber
        contempNumber.setBoundEditor(txtempNumber);
        //contempName
        contempName.setBoundEditor(txtempName);
        //contcityNumber
        contcityNumber.setBoundEditor(txtcityNumber);
        //contcityName
        contcityName.setBoundEditor(txtcityName);
        //contbaseAch
        contbaseAch.setBoundEditor(txtbaseAch);
        //contshopPro
        contshopPro.setBoundEditor(txtshopPro);
        //contpersonPro
        contpersonPro.setBoundEditor(txtpersonPro);
        //contbusinessPro
        contbusinessPro.setBoundEditor(txtbusinessPro);
        //contreduceAmount
        contreduceAmount.setBoundEditor(txtreduceAmount);
        //contrewardAmount
        contrewardAmount.setBoundEditor(txtrewardAmount);
        //contclinicNumber
        contclinicNumber.setBoundEditor(txtclinicNumber);
        //contclinicName
        contclinicName.setBoundEditor(txtclinicName);
        //contotherNumber
        contotherNumber.setBoundEditor(txtotherNumber);
        //contclinic
        contclinic.setBoundEditor(prmtclinic);
        //contcity
        contcity.setBoundEditor(prmtcity);
        //contclinicType
        contclinicType.setBoundEditor(clinicType);
        //contshopProText
        contshopProText.setBoundEditor(txtshopProText);
        //contbusinessProText
        contbusinessProText.setBoundEditor(txtbusinessProText);
        //contpersonProText
        contpersonProText.setBoundEditor(txtpersonProText);
        //contbasePay
        contbasePay.setBoundEditor(txtbasePay);
        //contclinicbaseAch
        contclinicbaseAch.setBoundEditor(txtclinicbaseAch);
        //contbusinessDate
        contbusinessDate.setBoundEditor(txtbusinessDate);

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
        this.menuBar.add(menuTool);
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
        //menuBiz
        menuBiz.add(menuItemCancelCancel);
        menuBiz.add(menuItemCancel);
        //menuTool
        menuTool.add(menuItemMsgFormat);
        menuTool.add(menuItemSendMessage);
        menuTool.add(menuItemCalculator);
        menuTool.add(menuItemToolBarCustom);
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
        this.toolBar.add(btnReset);
        this.toolBar.add(kDSeparatorCloud);
        this.toolBar.add(btnSave);
        this.toolBar.add(btnSubmit);
        this.toolBar.add(btnCopy);
        this.toolBar.add(btnRemove);
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
        this.toolBar.add(btnCancelCancel);
        this.toolBar.add(btnCancel);


    }

	//Regiester control's property binding.
	private void registerBindings(){
		dataBinder.registerBinding("number", String.class, this.txtNumber, "text");
		dataBinder.registerBinding("name", String.class, this.txtName, "_multiLangItem");
		dataBinder.registerBinding("simpleName", String.class, this.txtSimpleName, "text");
		dataBinder.registerBinding("description", String.class, this.txtDescription, "_multiLangItem");
		dataBinder.registerBinding("status", com.kingdee.eas.mw.pay.app.PayPostStatus.class, this.status, "selectedItem");
		dataBinder.registerBinding("empNumber", String.class, this.txtempNumber, "text");
		dataBinder.registerBinding("empName", String.class, this.txtempName, "text");
		dataBinder.registerBinding("cityNumber", String.class, this.txtcityNumber, "text");
		dataBinder.registerBinding("cityName", String.class, this.txtcityName, "text");
		dataBinder.registerBinding("baseAch", java.math.BigDecimal.class, this.txtbaseAch, "value");
		dataBinder.registerBinding("shopPro", java.math.BigDecimal.class, this.txtshopPro, "value");
		dataBinder.registerBinding("personPro", java.math.BigDecimal.class, this.txtpersonPro, "value");
		dataBinder.registerBinding("businessPro", java.math.BigDecimal.class, this.txtbusinessPro, "value");
		dataBinder.registerBinding("reduceAmount", java.math.BigDecimal.class, this.txtreduceAmount, "value");
		dataBinder.registerBinding("rewardAmount", java.math.BigDecimal.class, this.txtrewardAmount, "value");
		dataBinder.registerBinding("clinicNumber", String.class, this.txtclinicNumber, "text");
		dataBinder.registerBinding("clinicName", String.class, this.txtclinicName, "text");
		dataBinder.registerBinding("otherNumber", String.class, this.txtotherNumber, "text");
		dataBinder.registerBinding("clinic", com.kingdee.eas.basedata.org.CompanyOrgUnitInfo.class, this.prmtclinic, "data");
		dataBinder.registerBinding("city", com.kingdee.eas.basedata.org.CtrlUnitInfo.class, this.prmtcity, "data");
		dataBinder.registerBinding("clinicType", com.kingdee.eas.mw.pay.app.ClinicOtherSize.class, this.clinicType, "selectedItem");
		dataBinder.registerBinding("shopProText", String.class, this.txtshopProText, "text");
		dataBinder.registerBinding("businessProText", String.class, this.txtbusinessProText, "text");
		dataBinder.registerBinding("personProText", String.class, this.txtpersonProText, "text");
		dataBinder.registerBinding("basePay", java.math.BigDecimal.class, this.txtbasePay, "value");
		dataBinder.registerBinding("clinicbaseAch", java.math.BigDecimal.class, this.txtclinicbaseAch, "value");
		dataBinder.registerBinding("businessDate", String.class, this.txtbusinessDate, "text");		
	}
	//Regiester UI State
	private void registerUIState(){
	        getActionManager().registerUIState(STATUS_ADDNEW, this.txtName, ActionStateConst.ENABLED);
	        getActionManager().registerUIState(STATUS_ADDNEW, this.txtDescription, ActionStateConst.ENABLED);
	        getActionManager().registerUIState(STATUS_ADDNEW, this.txtNumber, ActionStateConst.ENABLED);
	        getActionManager().registerUIState(STATUS_ADDNEW, this.txtSimpleName, ActionStateConst.ENABLED);
	        getActionManager().registerUIState(STATUS_EDIT, this.txtName, ActionStateConst.ENABLED);
	        getActionManager().registerUIState(STATUS_EDIT, this.txtDescription, ActionStateConst.ENABLED);
	        getActionManager().registerUIState(STATUS_EDIT, this.txtNumber, ActionStateConst.ENABLED);
	        getActionManager().registerUIState(STATUS_EDIT, this.txtSimpleName, ActionStateConst.ENABLED);					 	        		
	        getActionManager().registerUIState(STATUS_VIEW, this.txtName, ActionStateConst.DISABLED);					 	        		
	        getActionManager().registerUIState(STATUS_VIEW, this.txtDescription, ActionStateConst.DISABLED);					 	        		
	        getActionManager().registerUIState(STATUS_VIEW, this.txtNumber, ActionStateConst.DISABLED);					 	        		
	        getActionManager().registerUIState(STATUS_VIEW, this.txtSimpleName, ActionStateConst.DISABLED);		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.mw.pay.app.AchRoyaltyRuleEditUIHandler";
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
        this.status.requestFocusInWindow();
    }

	
	

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject)
    {
        IObjectValue ov = dataObject;        	    	
        super.setDataObject(ov);
        this.editData = (com.kingdee.eas.mw.pay.AchRoyaltyRuleInfo)ov;
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
		getValidateHelper().registerBindProperty("number", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("name", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("simpleName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("description", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("status", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("empNumber", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("empName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("cityNumber", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("cityName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("baseAch", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("shopPro", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("personPro", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("businessPro", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("reduceAmount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("rewardAmount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("clinicNumber", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("clinicName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("otherNumber", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("clinic", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("city", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("clinicType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("shopProText", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("businessProText", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("personProText", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("basePay", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("clinicbaseAch", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("businessDate", ValidateHelper.ON_SAVE);    		
	}



    /**
     * output setOprtState method
     */
    public void setOprtState(String oprtType)
    {
        super.setOprtState(oprtType);
        if (STATUS_ADDNEW.equals(this.oprtState)) {
		            this.txtName.setEnabled(true);
		            this.txtDescription.setEnabled(true);
		            this.txtNumber.setEnabled(true);
		            this.txtSimpleName.setEnabled(true);
        } else if (STATUS_EDIT.equals(this.oprtState)) {
		            this.txtName.setEnabled(true);
		            this.txtDescription.setEnabled(true);
		            this.txtNumber.setEnabled(true);
		            this.txtSimpleName.setEnabled(true);
        } else if (STATUS_VIEW.equals(this.oprtState)) {
		            this.txtName.setEnabled(false);
		            this.txtDescription.setEnabled(false);
		            this.txtNumber.setEnabled(false);
		            this.txtSimpleName.setEnabled(false);
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
        sic.add(new SelectorItemInfo("number"));
        sic.add(new SelectorItemInfo("name"));
        sic.add(new SelectorItemInfo("simpleName"));
        sic.add(new SelectorItemInfo("description"));
        sic.add(new SelectorItemInfo("status"));
        sic.add(new SelectorItemInfo("empNumber"));
        sic.add(new SelectorItemInfo("empName"));
        sic.add(new SelectorItemInfo("cityNumber"));
        sic.add(new SelectorItemInfo("cityName"));
        sic.add(new SelectorItemInfo("baseAch"));
        sic.add(new SelectorItemInfo("shopPro"));
        sic.add(new SelectorItemInfo("personPro"));
        sic.add(new SelectorItemInfo("businessPro"));
        sic.add(new SelectorItemInfo("reduceAmount"));
        sic.add(new SelectorItemInfo("rewardAmount"));
        sic.add(new SelectorItemInfo("clinicNumber"));
        sic.add(new SelectorItemInfo("clinicName"));
        sic.add(new SelectorItemInfo("otherNumber"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("clinic.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("clinic.id"));
        	sic.add(new SelectorItemInfo("clinic.number"));
        	sic.add(new SelectorItemInfo("clinic.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("city.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("city.id"));
        	sic.add(new SelectorItemInfo("city.number"));
        	sic.add(new SelectorItemInfo("city.name"));
		}
        sic.add(new SelectorItemInfo("clinicType"));
        sic.add(new SelectorItemInfo("shopProText"));
        sic.add(new SelectorItemInfo("businessProText"));
        sic.add(new SelectorItemInfo("personProText"));
        sic.add(new SelectorItemInfo("basePay"));
        sic.add(new SelectorItemInfo("clinicbaseAch"));
        sic.add(new SelectorItemInfo("businessDate"));
        return sic;
    }        

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.mw.pay.client", "AchRoyaltyRuleEditUI");
    }

    /**
     * output getEditUIName method
     */
    protected String getEditUIName()
    {
        return com.kingdee.eas.mw.pay.client.AchRoyaltyRuleEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.mw.pay.AchRoyaltyRuleFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.mw.pay.AchRoyaltyRuleInfo objectValue = new com.kingdee.eas.mw.pay.AchRoyaltyRuleInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
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
		vo.put("status","qy");
vo.put("clinicType","dd");
        
    }        
	protected void setFieldsNull(com.kingdee.bos.dao.AbstractObjectValue arg0) {
		super.setFieldsNull(arg0);
		arg0.put("number",null);
	}

}