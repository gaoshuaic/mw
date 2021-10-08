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
public abstract class AbstractDocAchieveUpdateEditUI extends com.kingdee.eas.framework.client.EditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractDocAchieveUpdateEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer2;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer3;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer4;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contdocNumber;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contdocName;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbusinessDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contzzAchieve;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contyxjzAchieve;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contgdjzAchieve;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contknwAchieve;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contxfAchieve;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conteyAchieve;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contyzAchieve;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contallAchieve;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contjzmoney;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contclinicNumber;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contclinicName;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contmbAchieve;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcityNumber;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcityName;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcity;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkiszidai;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contclinic;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox txtName;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtSimpleName;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox txtDescription;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtdocNumber;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtdocName;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtbusinessDate;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtzzAchieve;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtyxjzAchieve;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtgdjzAchieve;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtknwAchieve;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtxfAchieve;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txteyAchieve;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtyzAchieve;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtallAchieve;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtjzmoney;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtclinicNumber;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtclinicName;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtmbAchieve;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtcityNumber;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtcityName;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcity;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtclinic;
    protected com.kingdee.eas.mw.pay.DocAchieveUpdateInfo editData = null;
    /**
     * output class constructor
     */
    public AbstractDocAchieveUpdateEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractDocAchieveUpdateEditUI.class.getName());
        this.setUITitle(resHelper.getString("this.title"));
        this.kDLabelContainer1 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer2 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer3 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer4 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contdocNumber = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contdocName = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbusinessDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contzzAchieve = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contyxjzAchieve = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contgdjzAchieve = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contknwAchieve = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contxfAchieve = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conteyAchieve = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contyzAchieve = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contallAchieve = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contjzmoney = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contclinicNumber = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contclinicName = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contmbAchieve = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcityNumber = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcityName = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcity = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.chkiszidai = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.contclinic = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtName = new com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox();
        this.txtSimpleName = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtDescription = new com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox();
        this.txtdocNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtdocName = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtbusinessDate = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtzzAchieve = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtyxjzAchieve = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtgdjzAchieve = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtknwAchieve = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtxfAchieve = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txteyAchieve = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtyzAchieve = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtallAchieve = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtjzmoney = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtclinicNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtclinicName = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtmbAchieve = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtcityNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtcityName = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtcity = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtclinic = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDLabelContainer1.setName("kDLabelContainer1");
        this.kDLabelContainer2.setName("kDLabelContainer2");
        this.kDLabelContainer3.setName("kDLabelContainer3");
        this.kDLabelContainer4.setName("kDLabelContainer4");
        this.contdocNumber.setName("contdocNumber");
        this.contdocName.setName("contdocName");
        this.contbusinessDate.setName("contbusinessDate");
        this.contzzAchieve.setName("contzzAchieve");
        this.contyxjzAchieve.setName("contyxjzAchieve");
        this.contgdjzAchieve.setName("contgdjzAchieve");
        this.contknwAchieve.setName("contknwAchieve");
        this.contxfAchieve.setName("contxfAchieve");
        this.conteyAchieve.setName("conteyAchieve");
        this.contyzAchieve.setName("contyzAchieve");
        this.contallAchieve.setName("contallAchieve");
        this.contjzmoney.setName("contjzmoney");
        this.contclinicNumber.setName("contclinicNumber");
        this.contclinicName.setName("contclinicName");
        this.contmbAchieve.setName("contmbAchieve");
        this.contcityNumber.setName("contcityNumber");
        this.contcityName.setName("contcityName");
        this.contcity.setName("contcity");
        this.chkiszidai.setName("chkiszidai");
        this.contclinic.setName("contclinic");
        this.txtNumber.setName("txtNumber");
        this.txtName.setName("txtName");
        this.txtSimpleName.setName("txtSimpleName");
        this.txtDescription.setName("txtDescription");
        this.txtdocNumber.setName("txtdocNumber");
        this.txtdocName.setName("txtdocName");
        this.txtbusinessDate.setName("txtbusinessDate");
        this.txtzzAchieve.setName("txtzzAchieve");
        this.txtyxjzAchieve.setName("txtyxjzAchieve");
        this.txtgdjzAchieve.setName("txtgdjzAchieve");
        this.txtknwAchieve.setName("txtknwAchieve");
        this.txtxfAchieve.setName("txtxfAchieve");
        this.txteyAchieve.setName("txteyAchieve");
        this.txtyzAchieve.setName("txtyzAchieve");
        this.txtallAchieve.setName("txtallAchieve");
        this.txtjzmoney.setName("txtjzmoney");
        this.txtclinicNumber.setName("txtclinicNumber");
        this.txtclinicName.setName("txtclinicName");
        this.txtmbAchieve.setName("txtmbAchieve");
        this.txtcityNumber.setName("txtcityNumber");
        this.txtcityName.setName("txtcityName");
        this.prmtcity.setName("prmtcity");
        this.prmtclinic.setName("prmtclinic");
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
        // kDLabelContainer4		
        this.kDLabelContainer4.setBoundLabelText(resHelper.getString("kDLabelContainer4.boundLabelText"));		
        this.kDLabelContainer4.setBoundLabelLength(100);		
        this.kDLabelContainer4.setBoundLabelUnderline(true);		
        this.kDLabelContainer4.setBoundLabelAlignment(7);		
        this.kDLabelContainer4.setVisible(true);
        // contdocNumber		
        this.contdocNumber.setBoundLabelText(resHelper.getString("contdocNumber.boundLabelText"));		
        this.contdocNumber.setBoundLabelLength(100);		
        this.contdocNumber.setBoundLabelUnderline(true);		
        this.contdocNumber.setVisible(true);
        // contdocName		
        this.contdocName.setBoundLabelText(resHelper.getString("contdocName.boundLabelText"));		
        this.contdocName.setBoundLabelLength(100);		
        this.contdocName.setBoundLabelUnderline(true);		
        this.contdocName.setVisible(true);
        // contbusinessDate		
        this.contbusinessDate.setBoundLabelText(resHelper.getString("contbusinessDate.boundLabelText"));		
        this.contbusinessDate.setBoundLabelLength(100);		
        this.contbusinessDate.setBoundLabelUnderline(true);		
        this.contbusinessDate.setVisible(true);
        // contzzAchieve		
        this.contzzAchieve.setBoundLabelText(resHelper.getString("contzzAchieve.boundLabelText"));		
        this.contzzAchieve.setBoundLabelLength(100);		
        this.contzzAchieve.setBoundLabelUnderline(true);		
        this.contzzAchieve.setVisible(true);
        // contyxjzAchieve		
        this.contyxjzAchieve.setBoundLabelText(resHelper.getString("contyxjzAchieve.boundLabelText"));		
        this.contyxjzAchieve.setBoundLabelLength(100);		
        this.contyxjzAchieve.setBoundLabelUnderline(true);		
        this.contyxjzAchieve.setVisible(true);
        // contgdjzAchieve		
        this.contgdjzAchieve.setBoundLabelText(resHelper.getString("contgdjzAchieve.boundLabelText"));		
        this.contgdjzAchieve.setBoundLabelLength(100);		
        this.contgdjzAchieve.setBoundLabelUnderline(true);		
        this.contgdjzAchieve.setVisible(true);
        // contknwAchieve		
        this.contknwAchieve.setBoundLabelText(resHelper.getString("contknwAchieve.boundLabelText"));		
        this.contknwAchieve.setBoundLabelLength(100);		
        this.contknwAchieve.setBoundLabelUnderline(true);		
        this.contknwAchieve.setVisible(true);
        // contxfAchieve		
        this.contxfAchieve.setBoundLabelText(resHelper.getString("contxfAchieve.boundLabelText"));		
        this.contxfAchieve.setBoundLabelLength(100);		
        this.contxfAchieve.setBoundLabelUnderline(true);		
        this.contxfAchieve.setVisible(true);
        // conteyAchieve		
        this.conteyAchieve.setBoundLabelText(resHelper.getString("conteyAchieve.boundLabelText"));		
        this.conteyAchieve.setBoundLabelLength(100);		
        this.conteyAchieve.setBoundLabelUnderline(true);		
        this.conteyAchieve.setVisible(true);
        // contyzAchieve		
        this.contyzAchieve.setBoundLabelText(resHelper.getString("contyzAchieve.boundLabelText"));		
        this.contyzAchieve.setBoundLabelLength(100);		
        this.contyzAchieve.setBoundLabelUnderline(true);		
        this.contyzAchieve.setVisible(true);
        // contallAchieve		
        this.contallAchieve.setBoundLabelText(resHelper.getString("contallAchieve.boundLabelText"));		
        this.contallAchieve.setBoundLabelLength(100);		
        this.contallAchieve.setBoundLabelUnderline(true);		
        this.contallAchieve.setVisible(true);
        // contjzmoney		
        this.contjzmoney.setBoundLabelText(resHelper.getString("contjzmoney.boundLabelText"));		
        this.contjzmoney.setBoundLabelLength(100);		
        this.contjzmoney.setBoundLabelUnderline(true);		
        this.contjzmoney.setVisible(true);
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
        // contmbAchieve		
        this.contmbAchieve.setBoundLabelText(resHelper.getString("contmbAchieve.boundLabelText"));		
        this.contmbAchieve.setBoundLabelLength(100);		
        this.contmbAchieve.setBoundLabelUnderline(true);		
        this.contmbAchieve.setVisible(true);
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
        // txtNumber		
        this.txtNumber.setMaxLength(80);
        // txtName
        // txtSimpleName		
        this.txtSimpleName.setMaxLength(80);
        // txtDescription
        // txtdocNumber		
        this.txtdocNumber.setVisible(true);		
        this.txtdocNumber.setHorizontalAlignment(2);		
        this.txtdocNumber.setMaxLength(100);		
        this.txtdocNumber.setRequired(false);
        // txtdocName		
        this.txtdocName.setVisible(true);		
        this.txtdocName.setHorizontalAlignment(2);		
        this.txtdocName.setMaxLength(100);		
        this.txtdocName.setRequired(false);
        // txtbusinessDate		
        this.txtbusinessDate.setVisible(true);		
        this.txtbusinessDate.setHorizontalAlignment(2);		
        this.txtbusinessDate.setMaxLength(100);		
        this.txtbusinessDate.setRequired(false);
        // txtzzAchieve		
        this.txtzzAchieve.setVisible(true);		
        this.txtzzAchieve.setHorizontalAlignment(2);		
        this.txtzzAchieve.setDataType(1);		
        this.txtzzAchieve.setSupportedEmpty(true);		
        this.txtzzAchieve.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtzzAchieve.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtzzAchieve.setPrecision(10);		
        this.txtzzAchieve.setRequired(false);
        // txtyxjzAchieve		
        this.txtyxjzAchieve.setVisible(true);		
        this.txtyxjzAchieve.setHorizontalAlignment(2);		
        this.txtyxjzAchieve.setDataType(1);		
        this.txtyxjzAchieve.setSupportedEmpty(true);		
        this.txtyxjzAchieve.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtyxjzAchieve.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtyxjzAchieve.setPrecision(10);		
        this.txtyxjzAchieve.setRequired(false);
        // txtgdjzAchieve		
        this.txtgdjzAchieve.setVisible(true);		
        this.txtgdjzAchieve.setHorizontalAlignment(2);		
        this.txtgdjzAchieve.setDataType(1);		
        this.txtgdjzAchieve.setSupportedEmpty(true);		
        this.txtgdjzAchieve.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtgdjzAchieve.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtgdjzAchieve.setPrecision(10);		
        this.txtgdjzAchieve.setRequired(false);
        // txtknwAchieve		
        this.txtknwAchieve.setVisible(true);		
        this.txtknwAchieve.setHorizontalAlignment(2);		
        this.txtknwAchieve.setDataType(1);		
        this.txtknwAchieve.setSupportedEmpty(true);		
        this.txtknwAchieve.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtknwAchieve.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtknwAchieve.setPrecision(10);		
        this.txtknwAchieve.setRequired(false);
        // txtxfAchieve		
        this.txtxfAchieve.setVisible(true);		
        this.txtxfAchieve.setHorizontalAlignment(2);		
        this.txtxfAchieve.setDataType(1);		
        this.txtxfAchieve.setSupportedEmpty(true);		
        this.txtxfAchieve.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtxfAchieve.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtxfAchieve.setPrecision(10);		
        this.txtxfAchieve.setRequired(false);
        // txteyAchieve		
        this.txteyAchieve.setVisible(true);		
        this.txteyAchieve.setHorizontalAlignment(2);		
        this.txteyAchieve.setDataType(1);		
        this.txteyAchieve.setSupportedEmpty(true);		
        this.txteyAchieve.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txteyAchieve.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txteyAchieve.setPrecision(10);		
        this.txteyAchieve.setRequired(false);
        // txtyzAchieve		
        this.txtyzAchieve.setVisible(true);		
        this.txtyzAchieve.setHorizontalAlignment(2);		
        this.txtyzAchieve.setDataType(1);		
        this.txtyzAchieve.setSupportedEmpty(true);		
        this.txtyzAchieve.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtyzAchieve.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtyzAchieve.setPrecision(10);		
        this.txtyzAchieve.setRequired(false);
        // txtallAchieve		
        this.txtallAchieve.setVisible(true);		
        this.txtallAchieve.setHorizontalAlignment(2);		
        this.txtallAchieve.setDataType(1);		
        this.txtallAchieve.setSupportedEmpty(true);		
        this.txtallAchieve.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtallAchieve.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtallAchieve.setPrecision(10);		
        this.txtallAchieve.setRequired(false);
        // txtjzmoney		
        this.txtjzmoney.setVisible(true);		
        this.txtjzmoney.setHorizontalAlignment(2);		
        this.txtjzmoney.setDataType(1);		
        this.txtjzmoney.setSupportedEmpty(true);		
        this.txtjzmoney.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtjzmoney.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtjzmoney.setPrecision(10);		
        this.txtjzmoney.setRequired(false);
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
        // txtmbAchieve		
        this.txtmbAchieve.setVisible(true);		
        this.txtmbAchieve.setHorizontalAlignment(2);		
        this.txtmbAchieve.setDataType(1);		
        this.txtmbAchieve.setSupportedEmpty(true);		
        this.txtmbAchieve.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtmbAchieve.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtmbAchieve.setPrecision(10);		
        this.txtmbAchieve.setRequired(false);
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
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {txtdocNumber,txtdocName,txtbusinessDate,txtzzAchieve,txtyxjzAchieve,txtgdjzAchieve,txtknwAchieve,txtxfAchieve,txteyAchieve,txtyzAchieve,txtallAchieve,txtjzmoney,txtclinicNumber,txtclinicName,txtmbAchieve,txtcityNumber,txtcityName,prmtcity,chkiszidai,prmtclinic}));
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
        this.setBounds(new Rectangle(0, 0, 1013, 221));
        this.setLayout(null);
        kDLabelContainer1.setBounds(new Rectangle(672, 106, 270, 19));
        this.add(kDLabelContainer1, null);
        kDLabelContainer2.setBounds(new Rectangle(10, 130, 270, 19));
        this.add(kDLabelContainer2, null);
        kDLabelContainer3.setBounds(new Rectangle(341, 130, 270, 19));
        this.add(kDLabelContainer3, null);
        kDLabelContainer4.setBounds(new Rectangle(672, 130, 270, 19));
        this.add(kDLabelContainer4, null);
        contdocNumber.setBounds(new Rectangle(10, 10, 270, 19));
        this.add(contdocNumber, null);
        contdocName.setBounds(new Rectangle(341, 10, 270, 19));
        this.add(contdocName, null);
        contbusinessDate.setBounds(new Rectangle(672, 10, 270, 19));
        this.add(contbusinessDate, null);
        contzzAchieve.setBounds(new Rectangle(672, 34, 270, 19));
        this.add(contzzAchieve, null);
        contyxjzAchieve.setBounds(new Rectangle(10, 58, 270, 19));
        this.add(contyxjzAchieve, null);
        contgdjzAchieve.setBounds(new Rectangle(341, 58, 270, 19));
        this.add(contgdjzAchieve, null);
        contknwAchieve.setBounds(new Rectangle(672, 58, 270, 19));
        this.add(contknwAchieve, null);
        contxfAchieve.setBounds(new Rectangle(10, 82, 270, 19));
        this.add(contxfAchieve, null);
        conteyAchieve.setBounds(new Rectangle(341, 82, 270, 19));
        this.add(conteyAchieve, null);
        contyzAchieve.setBounds(new Rectangle(672, 82, 270, 19));
        this.add(contyzAchieve, null);
        contallAchieve.setBounds(new Rectangle(341, 106, 270, 19));
        this.add(contallAchieve, null);
        contjzmoney.setBounds(new Rectangle(10, 106, 270, 19));
        this.add(contjzmoney, null);
        contclinicNumber.setBounds(new Rectangle(672, 154, 270, 19));
        this.add(contclinicNumber, null);
        contclinicName.setBounds(new Rectangle(10, 178, 270, 19));
        this.add(contclinicName, null);
        contmbAchieve.setBounds(new Rectangle(341, 34, 270, 19));
        this.add(contmbAchieve, null);
        contcityNumber.setBounds(new Rectangle(10, 154, 270, 19));
        this.add(contcityNumber, null);
        contcityName.setBounds(new Rectangle(341, 154, 270, 19));
        this.add(contcityName, null);
        contcity.setBounds(new Rectangle(10, 34, 270, 19));
        this.add(contcity, null);
        chkiszidai.setBounds(new Rectangle(341, 178, 270, 19));
        this.add(chkiszidai, null);
        contclinic.setBounds(new Rectangle(672, 178, 270, 19));
        this.add(contclinic, null);
        //kDLabelContainer1
        kDLabelContainer1.setBoundEditor(txtNumber);
        //kDLabelContainer2
        kDLabelContainer2.setBoundEditor(txtName);
        //kDLabelContainer3
        kDLabelContainer3.setBoundEditor(txtSimpleName);
        //kDLabelContainer4
        kDLabelContainer4.setBoundEditor(txtDescription);
        //contdocNumber
        contdocNumber.setBoundEditor(txtdocNumber);
        //contdocName
        contdocName.setBoundEditor(txtdocName);
        //contbusinessDate
        contbusinessDate.setBoundEditor(txtbusinessDate);
        //contzzAchieve
        contzzAchieve.setBoundEditor(txtzzAchieve);
        //contyxjzAchieve
        contyxjzAchieve.setBoundEditor(txtyxjzAchieve);
        //contgdjzAchieve
        contgdjzAchieve.setBoundEditor(txtgdjzAchieve);
        //contknwAchieve
        contknwAchieve.setBoundEditor(txtknwAchieve);
        //contxfAchieve
        contxfAchieve.setBoundEditor(txtxfAchieve);
        //conteyAchieve
        conteyAchieve.setBoundEditor(txteyAchieve);
        //contyzAchieve
        contyzAchieve.setBoundEditor(txtyzAchieve);
        //contallAchieve
        contallAchieve.setBoundEditor(txtallAchieve);
        //contjzmoney
        contjzmoney.setBoundEditor(txtjzmoney);
        //contclinicNumber
        contclinicNumber.setBoundEditor(txtclinicNumber);
        //contclinicName
        contclinicName.setBoundEditor(txtclinicName);
        //contmbAchieve
        contmbAchieve.setBoundEditor(txtmbAchieve);
        //contcityNumber
        contcityNumber.setBoundEditor(txtcityNumber);
        //contcityName
        contcityName.setBoundEditor(txtcityName);
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
		dataBinder.registerBinding("iszidai", boolean.class, this.chkiszidai, "selected");
		dataBinder.registerBinding("number", String.class, this.txtNumber, "text");
		dataBinder.registerBinding("name", String.class, this.txtName, "_multiLangItem");
		dataBinder.registerBinding("simpleName", String.class, this.txtSimpleName, "text");
		dataBinder.registerBinding("description", String.class, this.txtDescription, "_multiLangItem");
		dataBinder.registerBinding("docNumber", String.class, this.txtdocNumber, "text");
		dataBinder.registerBinding("docName", String.class, this.txtdocName, "text");
		dataBinder.registerBinding("businessDate", String.class, this.txtbusinessDate, "text");
		dataBinder.registerBinding("zzAchieve", java.math.BigDecimal.class, this.txtzzAchieve, "value");
		dataBinder.registerBinding("yxjzAchieve", java.math.BigDecimal.class, this.txtyxjzAchieve, "value");
		dataBinder.registerBinding("gdjzAchieve", java.math.BigDecimal.class, this.txtgdjzAchieve, "value");
		dataBinder.registerBinding("knwAchieve", java.math.BigDecimal.class, this.txtknwAchieve, "value");
		dataBinder.registerBinding("xfAchieve", java.math.BigDecimal.class, this.txtxfAchieve, "value");
		dataBinder.registerBinding("eyAchieve", java.math.BigDecimal.class, this.txteyAchieve, "value");
		dataBinder.registerBinding("yzAchieve", java.math.BigDecimal.class, this.txtyzAchieve, "value");
		dataBinder.registerBinding("allAchieve", java.math.BigDecimal.class, this.txtallAchieve, "value");
		dataBinder.registerBinding("jzmoney", java.math.BigDecimal.class, this.txtjzmoney, "value");
		dataBinder.registerBinding("clinicNumber", String.class, this.txtclinicNumber, "text");
		dataBinder.registerBinding("clinicName", String.class, this.txtclinicName, "text");
		dataBinder.registerBinding("mbAchieve", java.math.BigDecimal.class, this.txtmbAchieve, "value");
		dataBinder.registerBinding("cityNumber", String.class, this.txtcityNumber, "text");
		dataBinder.registerBinding("cityName", String.class, this.txtcityName, "text");
		dataBinder.registerBinding("city", com.kingdee.eas.basedata.org.CtrlUnitInfo.class, this.prmtcity, "data");
		dataBinder.registerBinding("clinic", com.kingdee.eas.basedata.org.CompanyOrgUnitInfo.class, this.prmtclinic, "data");		
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
	    return "com.kingdee.eas.mw.pay.app.DocAchieveUpdateEditUIHandler";
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
        this.txtdocNumber.requestFocusInWindow();
    }

	
	

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject)
    {
        IObjectValue ov = dataObject;        	    	
        super.setDataObject(ov);
        this.editData = (com.kingdee.eas.mw.pay.DocAchieveUpdateInfo)ov;
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
		getValidateHelper().registerBindProperty("number", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("name", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("simpleName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("description", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("docNumber", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("docName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("businessDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("zzAchieve", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("yxjzAchieve", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("gdjzAchieve", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("knwAchieve", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("xfAchieve", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("eyAchieve", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("yzAchieve", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("allAchieve", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("jzmoney", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("clinicNumber", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("clinicName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("mbAchieve", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("cityNumber", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("cityName", ValidateHelper.ON_SAVE);    
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
        sic.add(new SelectorItemInfo("iszidai"));
        sic.add(new SelectorItemInfo("number"));
        sic.add(new SelectorItemInfo("name"));
        sic.add(new SelectorItemInfo("simpleName"));
        sic.add(new SelectorItemInfo("description"));
        sic.add(new SelectorItemInfo("docNumber"));
        sic.add(new SelectorItemInfo("docName"));
        sic.add(new SelectorItemInfo("businessDate"));
        sic.add(new SelectorItemInfo("zzAchieve"));
        sic.add(new SelectorItemInfo("yxjzAchieve"));
        sic.add(new SelectorItemInfo("gdjzAchieve"));
        sic.add(new SelectorItemInfo("knwAchieve"));
        sic.add(new SelectorItemInfo("xfAchieve"));
        sic.add(new SelectorItemInfo("eyAchieve"));
        sic.add(new SelectorItemInfo("yzAchieve"));
        sic.add(new SelectorItemInfo("allAchieve"));
        sic.add(new SelectorItemInfo("jzmoney"));
        sic.add(new SelectorItemInfo("clinicNumber"));
        sic.add(new SelectorItemInfo("clinicName"));
        sic.add(new SelectorItemInfo("mbAchieve"));
        sic.add(new SelectorItemInfo("cityNumber"));
        sic.add(new SelectorItemInfo("cityName"));
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
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.mw.pay.client", "DocAchieveUpdateEditUI");
    }

    /**
     * output getEditUIName method
     */
    protected String getEditUIName()
    {
        return com.kingdee.eas.mw.pay.client.DocAchieveUpdateEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.mw.pay.DocAchieveUpdateFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.mw.pay.DocAchieveUpdateInfo objectValue = new com.kingdee.eas.mw.pay.DocAchieveUpdateInfo();
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
    }        
	protected void setFieldsNull(com.kingdee.bos.dao.AbstractObjectValue arg0) {
		super.setFieldsNull(arg0);
		arg0.put("number",null);
	}

}