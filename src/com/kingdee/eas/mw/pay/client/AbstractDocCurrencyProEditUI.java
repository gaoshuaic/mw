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
public abstract class AbstractDocCurrencyProEditUI extends com.kingdee.eas.framework.client.EditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractDocCurrencyProEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer2;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer3;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer4;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contzzbl;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contgdjzbl;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contyxjzbl;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contyzzlbl;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contknwbl;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contmbbl;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contxfbl;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conteybl;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contzjbl;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcityNumber;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcityName;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcity;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcalType;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbusinessdate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfreeWorkPro;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsourcePro;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfirstSource;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contgifAmountPro;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbkPrice;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contqkPrice;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox txtName;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtSimpleName;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox txtDescription;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtzzbl;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtgdjzbl;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtyxjzbl;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtyzzlbl;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtknwbl;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtmbbl;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtxfbl;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txteybl;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtzjbl;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtcityNumber;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtcityName;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcity;
    protected com.kingdee.bos.ctrl.swing.KDComboBox calType;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtbusinessdate;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtfreeWorkPro;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtsourcePro;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtfirstSource;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtgifAmountPro;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtbkPrice;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtqkPrice;
    protected com.kingdee.eas.mw.pay.DocCurrencyProInfo editData = null;
    /**
     * output class constructor
     */
    public AbstractDocCurrencyProEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractDocCurrencyProEditUI.class.getName());
        this.setUITitle(resHelper.getString("this.title"));
        this.kDLabelContainer1 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer2 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer3 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer4 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contzzbl = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contgdjzbl = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contyxjzbl = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contyzzlbl = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contknwbl = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contmbbl = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contxfbl = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conteybl = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contzjbl = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcityNumber = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcityName = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcity = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcalType = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbusinessdate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfreeWorkPro = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contsourcePro = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfirstSource = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contgifAmountPro = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbkPrice = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contqkPrice = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtName = new com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox();
        this.txtSimpleName = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtDescription = new com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox();
        this.txtzzbl = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtgdjzbl = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtyxjzbl = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtyzzlbl = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtknwbl = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtmbbl = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtxfbl = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txteybl = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtzjbl = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtcityNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtcityName = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtcity = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.calType = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.txtbusinessdate = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtfreeWorkPro = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtsourcePro = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtfirstSource = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtgifAmountPro = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtbkPrice = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtqkPrice = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.kDLabelContainer1.setName("kDLabelContainer1");
        this.kDLabelContainer2.setName("kDLabelContainer2");
        this.kDLabelContainer3.setName("kDLabelContainer3");
        this.kDLabelContainer4.setName("kDLabelContainer4");
        this.contzzbl.setName("contzzbl");
        this.contgdjzbl.setName("contgdjzbl");
        this.contyxjzbl.setName("contyxjzbl");
        this.contyzzlbl.setName("contyzzlbl");
        this.contknwbl.setName("contknwbl");
        this.contmbbl.setName("contmbbl");
        this.contxfbl.setName("contxfbl");
        this.conteybl.setName("conteybl");
        this.contzjbl.setName("contzjbl");
        this.contcityNumber.setName("contcityNumber");
        this.contcityName.setName("contcityName");
        this.contcity.setName("contcity");
        this.contcalType.setName("contcalType");
        this.contbusinessdate.setName("contbusinessdate");
        this.contfreeWorkPro.setName("contfreeWorkPro");
        this.contsourcePro.setName("contsourcePro");
        this.contfirstSource.setName("contfirstSource");
        this.contgifAmountPro.setName("contgifAmountPro");
        this.contbkPrice.setName("contbkPrice");
        this.contqkPrice.setName("contqkPrice");
        this.txtNumber.setName("txtNumber");
        this.txtName.setName("txtName");
        this.txtSimpleName.setName("txtSimpleName");
        this.txtDescription.setName("txtDescription");
        this.txtzzbl.setName("txtzzbl");
        this.txtgdjzbl.setName("txtgdjzbl");
        this.txtyxjzbl.setName("txtyxjzbl");
        this.txtyzzlbl.setName("txtyzzlbl");
        this.txtknwbl.setName("txtknwbl");
        this.txtmbbl.setName("txtmbbl");
        this.txtxfbl.setName("txtxfbl");
        this.txteybl.setName("txteybl");
        this.txtzjbl.setName("txtzjbl");
        this.txtcityNumber.setName("txtcityNumber");
        this.txtcityName.setName("txtcityName");
        this.prmtcity.setName("prmtcity");
        this.calType.setName("calType");
        this.txtbusinessdate.setName("txtbusinessdate");
        this.txtfreeWorkPro.setName("txtfreeWorkPro");
        this.txtsourcePro.setName("txtsourcePro");
        this.txtfirstSource.setName("txtfirstSource");
        this.txtgifAmountPro.setName("txtgifAmountPro");
        this.txtbkPrice.setName("txtbkPrice");
        this.txtqkPrice.setName("txtqkPrice");
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
        // contzzbl		
        this.contzzbl.setBoundLabelText(resHelper.getString("contzzbl.boundLabelText"));		
        this.contzzbl.setBoundLabelLength(100);		
        this.contzzbl.setBoundLabelUnderline(true);		
        this.contzzbl.setVisible(true);
        // contgdjzbl		
        this.contgdjzbl.setBoundLabelText(resHelper.getString("contgdjzbl.boundLabelText"));		
        this.contgdjzbl.setBoundLabelLength(100);		
        this.contgdjzbl.setBoundLabelUnderline(true);		
        this.contgdjzbl.setVisible(true);
        // contyxjzbl		
        this.contyxjzbl.setBoundLabelText(resHelper.getString("contyxjzbl.boundLabelText"));		
        this.contyxjzbl.setBoundLabelLength(100);		
        this.contyxjzbl.setBoundLabelUnderline(true);		
        this.contyxjzbl.setVisible(true);
        // contyzzlbl		
        this.contyzzlbl.setBoundLabelText(resHelper.getString("contyzzlbl.boundLabelText"));		
        this.contyzzlbl.setBoundLabelLength(100);		
        this.contyzzlbl.setBoundLabelUnderline(true);		
        this.contyzzlbl.setVisible(true);
        // contknwbl		
        this.contknwbl.setBoundLabelText(resHelper.getString("contknwbl.boundLabelText"));		
        this.contknwbl.setBoundLabelLength(100);		
        this.contknwbl.setBoundLabelUnderline(true);		
        this.contknwbl.setVisible(true);
        // contmbbl		
        this.contmbbl.setBoundLabelText(resHelper.getString("contmbbl.boundLabelText"));		
        this.contmbbl.setBoundLabelLength(100);		
        this.contmbbl.setBoundLabelUnderline(true);		
        this.contmbbl.setVisible(true);
        // contxfbl		
        this.contxfbl.setBoundLabelText(resHelper.getString("contxfbl.boundLabelText"));		
        this.contxfbl.setBoundLabelLength(100);		
        this.contxfbl.setBoundLabelUnderline(true);		
        this.contxfbl.setVisible(true);
        // conteybl		
        this.conteybl.setBoundLabelText(resHelper.getString("conteybl.boundLabelText"));		
        this.conteybl.setBoundLabelLength(100);		
        this.conteybl.setBoundLabelUnderline(true);		
        this.conteybl.setVisible(true);
        // contzjbl		
        this.contzjbl.setBoundLabelText(resHelper.getString("contzjbl.boundLabelText"));		
        this.contzjbl.setBoundLabelLength(100);		
        this.contzjbl.setBoundLabelUnderline(true);		
        this.contzjbl.setVisible(true);
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
        // contcalType		
        this.contcalType.setBoundLabelText(resHelper.getString("contcalType.boundLabelText"));		
        this.contcalType.setBoundLabelLength(100);		
        this.contcalType.setBoundLabelUnderline(true);		
        this.contcalType.setVisible(true);
        // contbusinessdate		
        this.contbusinessdate.setBoundLabelText(resHelper.getString("contbusinessdate.boundLabelText"));		
        this.contbusinessdate.setBoundLabelLength(100);		
        this.contbusinessdate.setBoundLabelUnderline(true);		
        this.contbusinessdate.setVisible(true);
        // contfreeWorkPro		
        this.contfreeWorkPro.setBoundLabelText(resHelper.getString("contfreeWorkPro.boundLabelText"));		
        this.contfreeWorkPro.setBoundLabelLength(100);		
        this.contfreeWorkPro.setBoundLabelUnderline(true);		
        this.contfreeWorkPro.setVisible(true);
        // contsourcePro		
        this.contsourcePro.setBoundLabelText(resHelper.getString("contsourcePro.boundLabelText"));		
        this.contsourcePro.setBoundLabelLength(100);		
        this.contsourcePro.setBoundLabelUnderline(true);		
        this.contsourcePro.setVisible(true);
        // contfirstSource		
        this.contfirstSource.setBoundLabelText(resHelper.getString("contfirstSource.boundLabelText"));		
        this.contfirstSource.setBoundLabelLength(100);		
        this.contfirstSource.setBoundLabelUnderline(true);		
        this.contfirstSource.setVisible(true);
        // contgifAmountPro		
        this.contgifAmountPro.setBoundLabelText(resHelper.getString("contgifAmountPro.boundLabelText"));		
        this.contgifAmountPro.setBoundLabelLength(100);		
        this.contgifAmountPro.setBoundLabelUnderline(true);		
        this.contgifAmountPro.setVisible(true);
        // contbkPrice		
        this.contbkPrice.setBoundLabelText(resHelper.getString("contbkPrice.boundLabelText"));		
        this.contbkPrice.setBoundLabelLength(100);		
        this.contbkPrice.setBoundLabelUnderline(true);		
        this.contbkPrice.setVisible(true);
        // contqkPrice		
        this.contqkPrice.setBoundLabelText(resHelper.getString("contqkPrice.boundLabelText"));		
        this.contqkPrice.setBoundLabelLength(100);		
        this.contqkPrice.setBoundLabelUnderline(true);		
        this.contqkPrice.setVisible(true);
        // txtNumber		
        this.txtNumber.setMaxLength(80);
        // txtName
        // txtSimpleName		
        this.txtSimpleName.setMaxLength(80);		
        this.txtSimpleName.setOpaque(false);		
        this.txtSimpleName.setVisible(false);		
        this.txtSimpleName.setEnabled(false);
        // txtDescription		
        this.txtDescription.setEnabled(false);		
        this.txtDescription.setVisible(false);		
        this.txtDescription.setOpaque(false);
        // txtzzbl		
        this.txtzzbl.setVisible(true);		
        this.txtzzbl.setHorizontalAlignment(2);		
        this.txtzzbl.setDataType(1);		
        this.txtzzbl.setSupportedEmpty(true);		
        this.txtzzbl.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtzzbl.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtzzbl.setPrecision(10);		
        this.txtzzbl.setRequired(false);
        // txtgdjzbl		
        this.txtgdjzbl.setVisible(true);		
        this.txtgdjzbl.setHorizontalAlignment(2);		
        this.txtgdjzbl.setDataType(1);		
        this.txtgdjzbl.setSupportedEmpty(true);		
        this.txtgdjzbl.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtgdjzbl.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtgdjzbl.setPrecision(10);		
        this.txtgdjzbl.setRequired(false);
        // txtyxjzbl		
        this.txtyxjzbl.setVisible(true);		
        this.txtyxjzbl.setHorizontalAlignment(2);		
        this.txtyxjzbl.setDataType(1);		
        this.txtyxjzbl.setSupportedEmpty(true);		
        this.txtyxjzbl.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtyxjzbl.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtyxjzbl.setPrecision(10);		
        this.txtyxjzbl.setRequired(false);
        // txtyzzlbl		
        this.txtyzzlbl.setVisible(true);		
        this.txtyzzlbl.setHorizontalAlignment(2);		
        this.txtyzzlbl.setDataType(1);		
        this.txtyzzlbl.setSupportedEmpty(true);		
        this.txtyzzlbl.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtyzzlbl.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtyzzlbl.setPrecision(10);		
        this.txtyzzlbl.setRequired(false);
        // txtknwbl		
        this.txtknwbl.setVisible(true);		
        this.txtknwbl.setHorizontalAlignment(2);		
        this.txtknwbl.setDataType(1);		
        this.txtknwbl.setSupportedEmpty(true);		
        this.txtknwbl.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtknwbl.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtknwbl.setPrecision(10);		
        this.txtknwbl.setRequired(false);
        // txtmbbl		
        this.txtmbbl.setVisible(true);		
        this.txtmbbl.setHorizontalAlignment(2);		
        this.txtmbbl.setDataType(1);		
        this.txtmbbl.setSupportedEmpty(true);		
        this.txtmbbl.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtmbbl.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtmbbl.setPrecision(10);		
        this.txtmbbl.setRequired(false);
        // txtxfbl		
        this.txtxfbl.setVisible(true);		
        this.txtxfbl.setHorizontalAlignment(2);		
        this.txtxfbl.setDataType(1);		
        this.txtxfbl.setSupportedEmpty(true);		
        this.txtxfbl.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtxfbl.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtxfbl.setPrecision(10);		
        this.txtxfbl.setRequired(false);
        // txteybl		
        this.txteybl.setVisible(true);		
        this.txteybl.setHorizontalAlignment(2);		
        this.txteybl.setDataType(1);		
        this.txteybl.setSupportedEmpty(true);		
        this.txteybl.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txteybl.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txteybl.setPrecision(10);		
        this.txteybl.setRequired(false);
        // txtzjbl		
        this.txtzjbl.setVisible(true);		
        this.txtzjbl.setHorizontalAlignment(2);		
        this.txtzjbl.setDataType(1);		
        this.txtzjbl.setSupportedEmpty(true);		
        this.txtzjbl.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtzjbl.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtzjbl.setPrecision(10);		
        this.txtzjbl.setRequired(false);
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
        // calType		
        this.calType.setVisible(true);		
        this.calType.addItems(EnumUtils.getEnumList("com.kingdee.eas.mw.pay.app.calDocAchieveType").toArray());		
        this.calType.setRequired(false);
        // txtbusinessdate		
        this.txtbusinessdate.setVisible(true);		
        this.txtbusinessdate.setHorizontalAlignment(2);		
        this.txtbusinessdate.setMaxLength(100);		
        this.txtbusinessdate.setRequired(false);
        // txtfreeWorkPro		
        this.txtfreeWorkPro.setVisible(true);		
        this.txtfreeWorkPro.setHorizontalAlignment(2);		
        this.txtfreeWorkPro.setDataType(1);		
        this.txtfreeWorkPro.setSupportedEmpty(true);		
        this.txtfreeWorkPro.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtfreeWorkPro.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtfreeWorkPro.setPrecision(10);		
        this.txtfreeWorkPro.setRequired(false);
        // txtsourcePro		
        this.txtsourcePro.setVisible(true);		
        this.txtsourcePro.setHorizontalAlignment(2);		
        this.txtsourcePro.setDataType(1);		
        this.txtsourcePro.setSupportedEmpty(true);		
        this.txtsourcePro.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtsourcePro.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtsourcePro.setPrecision(10);		
        this.txtsourcePro.setRequired(false);
        // txtfirstSource		
        this.txtfirstSource.setVisible(true);		
        this.txtfirstSource.setHorizontalAlignment(2);		
        this.txtfirstSource.setMaxLength(255);		
        this.txtfirstSource.setRequired(false);
        // txtgifAmountPro		
        this.txtgifAmountPro.setVisible(true);		
        this.txtgifAmountPro.setHorizontalAlignment(2);		
        this.txtgifAmountPro.setDataType(1);		
        this.txtgifAmountPro.setSupportedEmpty(true);		
        this.txtgifAmountPro.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtgifAmountPro.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtgifAmountPro.setPrecision(10);		
        this.txtgifAmountPro.setRequired(false);
        // txtbkPrice		
        this.txtbkPrice.setVisible(true);		
        this.txtbkPrice.setHorizontalAlignment(2);		
        this.txtbkPrice.setDataType(1);		
        this.txtbkPrice.setSupportedEmpty(true);		
        this.txtbkPrice.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtbkPrice.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtbkPrice.setPrecision(10);		
        this.txtbkPrice.setRequired(false);
        // txtqkPrice		
        this.txtqkPrice.setVisible(true);		
        this.txtqkPrice.setHorizontalAlignment(2);		
        this.txtqkPrice.setDataType(1);		
        this.txtqkPrice.setSupportedEmpty(true);		
        this.txtqkPrice.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtqkPrice.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtqkPrice.setPrecision(10);		
        this.txtqkPrice.setRequired(false);
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {txtzzbl,txtgdjzbl,txtyxjzbl,txtyzzlbl,txtknwbl,txtmbbl,txtxfbl,txteybl,txtzjbl,txtcityNumber,txtcityName,prmtcity,calType,txtbusinessdate,txtfreeWorkPro,txtsourcePro,txtfirstSource,txtgifAmountPro,txtbkPrice,txtqkPrice}));
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
        kDLabelContainer1.setBounds(new Rectangle(341, 10, 270, 19));
        this.add(kDLabelContainer1, null);
        kDLabelContainer2.setBounds(new Rectangle(672, 10, 270, 19));
        this.add(kDLabelContainer2, null);
        kDLabelContainer3.setBounds(new Rectangle(672, 82, 270, 19));
        this.add(kDLabelContainer3, null);
        kDLabelContainer4.setBounds(new Rectangle(672, 58, 270, 19));
        this.add(kDLabelContainer4, null);
        contzzbl.setBounds(new Rectangle(10, 34, 270, 19));
        this.add(contzzbl, null);
        contgdjzbl.setBounds(new Rectangle(341, 34, 270, 19));
        this.add(contgdjzbl, null);
        contyxjzbl.setBounds(new Rectangle(672, 34, 270, 19));
        this.add(contyxjzbl, null);
        contyzzlbl.setBounds(new Rectangle(10, 58, 270, 19));
        this.add(contyzzlbl, null);
        contknwbl.setBounds(new Rectangle(341, 58, 270, 19));
        this.add(contknwbl, null);
        contmbbl.setBounds(new Rectangle(10, 82, 270, 19));
        this.add(contmbbl, null);
        contxfbl.setBounds(new Rectangle(341, 82, 270, 19));
        this.add(contxfbl, null);
        conteybl.setBounds(new Rectangle(10, 106, 270, 19));
        this.add(conteybl, null);
        contzjbl.setBounds(new Rectangle(341, 106, 270, 19));
        this.add(contzjbl, null);
        contcityNumber.setBounds(new Rectangle(10, 130, 270, 19));
        this.add(contcityNumber, null);
        contcityName.setBounds(new Rectangle(672, 106, 270, 19));
        this.add(contcityName, null);
        contcity.setBounds(new Rectangle(10, 10, 270, 19));
        this.add(contcity, null);
        contcalType.setBounds(new Rectangle(341, 130, 270, 19));
        this.add(contcalType, null);
        contbusinessdate.setBounds(new Rectangle(672, 130, 270, 19));
        this.add(contbusinessdate, null);
        contfreeWorkPro.setBounds(new Rectangle(10, 154, 270, 19));
        this.add(contfreeWorkPro, null);
        contsourcePro.setBounds(new Rectangle(341, 154, 270, 19));
        this.add(contsourcePro, null);
        contfirstSource.setBounds(new Rectangle(672, 154, 270, 19));
        this.add(contfirstSource, null);
        contgifAmountPro.setBounds(new Rectangle(10, 178, 270, 19));
        this.add(contgifAmountPro, null);
        contbkPrice.setBounds(new Rectangle(341, 178, 270, 19));
        this.add(contbkPrice, null);
        contqkPrice.setBounds(new Rectangle(672, 178, 270, 19));
        this.add(contqkPrice, null);
        //kDLabelContainer1
        kDLabelContainer1.setBoundEditor(txtNumber);
        //kDLabelContainer2
        kDLabelContainer2.setBoundEditor(txtName);
        //kDLabelContainer3
        kDLabelContainer3.setBoundEditor(txtSimpleName);
        //kDLabelContainer4
        kDLabelContainer4.setBoundEditor(txtDescription);
        //contzzbl
        contzzbl.setBoundEditor(txtzzbl);
        //contgdjzbl
        contgdjzbl.setBoundEditor(txtgdjzbl);
        //contyxjzbl
        contyxjzbl.setBoundEditor(txtyxjzbl);
        //contyzzlbl
        contyzzlbl.setBoundEditor(txtyzzlbl);
        //contknwbl
        contknwbl.setBoundEditor(txtknwbl);
        //contmbbl
        contmbbl.setBoundEditor(txtmbbl);
        //contxfbl
        contxfbl.setBoundEditor(txtxfbl);
        //conteybl
        conteybl.setBoundEditor(txteybl);
        //contzjbl
        contzjbl.setBoundEditor(txtzjbl);
        //contcityNumber
        contcityNumber.setBoundEditor(txtcityNumber);
        //contcityName
        contcityName.setBoundEditor(txtcityName);
        //contcity
        contcity.setBoundEditor(prmtcity);
        //contcalType
        contcalType.setBoundEditor(calType);
        //contbusinessdate
        contbusinessdate.setBoundEditor(txtbusinessdate);
        //contfreeWorkPro
        contfreeWorkPro.setBoundEditor(txtfreeWorkPro);
        //contsourcePro
        contsourcePro.setBoundEditor(txtsourcePro);
        //contfirstSource
        contfirstSource.setBoundEditor(txtfirstSource);
        //contgifAmountPro
        contgifAmountPro.setBoundEditor(txtgifAmountPro);
        //contbkPrice
        contbkPrice.setBoundEditor(txtbkPrice);
        //contqkPrice
        contqkPrice.setBoundEditor(txtqkPrice);

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
		dataBinder.registerBinding("zzbl", java.math.BigDecimal.class, this.txtzzbl, "value");
		dataBinder.registerBinding("gdjzbl", java.math.BigDecimal.class, this.txtgdjzbl, "value");
		dataBinder.registerBinding("yxjzbl", java.math.BigDecimal.class, this.txtyxjzbl, "value");
		dataBinder.registerBinding("yzzlbl", java.math.BigDecimal.class, this.txtyzzlbl, "value");
		dataBinder.registerBinding("knwbl", java.math.BigDecimal.class, this.txtknwbl, "value");
		dataBinder.registerBinding("mbbl", java.math.BigDecimal.class, this.txtmbbl, "value");
		dataBinder.registerBinding("xfbl", java.math.BigDecimal.class, this.txtxfbl, "value");
		dataBinder.registerBinding("eybl", java.math.BigDecimal.class, this.txteybl, "value");
		dataBinder.registerBinding("zjbl", java.math.BigDecimal.class, this.txtzjbl, "value");
		dataBinder.registerBinding("cityNumber", String.class, this.txtcityNumber, "text");
		dataBinder.registerBinding("cityName", String.class, this.txtcityName, "text");
		dataBinder.registerBinding("city", com.kingdee.eas.basedata.org.CtrlUnitInfo.class, this.prmtcity, "data");
		dataBinder.registerBinding("calType", com.kingdee.eas.mw.pay.app.calDocAchieveType.class, this.calType, "selectedItem");
		dataBinder.registerBinding("businessdate", String.class, this.txtbusinessdate, "text");
		dataBinder.registerBinding("freeWorkPro", java.math.BigDecimal.class, this.txtfreeWorkPro, "value");
		dataBinder.registerBinding("sourcePro", java.math.BigDecimal.class, this.txtsourcePro, "value");
		dataBinder.registerBinding("firstSource", String.class, this.txtfirstSource, "text");
		dataBinder.registerBinding("gifAmountPro", java.math.BigDecimal.class, this.txtgifAmountPro, "value");
		dataBinder.registerBinding("bkPrice", java.math.BigDecimal.class, this.txtbkPrice, "value");
		dataBinder.registerBinding("qkPrice", java.math.BigDecimal.class, this.txtqkPrice, "value");		
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
	    return "com.kingdee.eas.mw.pay.app.DocCurrencyProEditUIHandler";
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
        this.txtzzbl.requestFocusInWindow();
    }

	
	

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject)
    {
        IObjectValue ov = dataObject;        	    	
        super.setDataObject(ov);
        this.editData = (com.kingdee.eas.mw.pay.DocCurrencyProInfo)ov;
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
		getValidateHelper().registerBindProperty("zzbl", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("gdjzbl", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("yxjzbl", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("yzzlbl", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("knwbl", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("mbbl", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("xfbl", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("eybl", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("zjbl", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("cityNumber", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("cityName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("city", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("calType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("businessdate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("freeWorkPro", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("sourcePro", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("firstSource", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("gifAmountPro", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("bkPrice", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("qkPrice", ValidateHelper.ON_SAVE);    		
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
        sic.add(new SelectorItemInfo("zzbl"));
        sic.add(new SelectorItemInfo("gdjzbl"));
        sic.add(new SelectorItemInfo("yxjzbl"));
        sic.add(new SelectorItemInfo("yzzlbl"));
        sic.add(new SelectorItemInfo("knwbl"));
        sic.add(new SelectorItemInfo("mbbl"));
        sic.add(new SelectorItemInfo("xfbl"));
        sic.add(new SelectorItemInfo("eybl"));
        sic.add(new SelectorItemInfo("zjbl"));
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
        sic.add(new SelectorItemInfo("calType"));
        sic.add(new SelectorItemInfo("businessdate"));
        sic.add(new SelectorItemInfo("freeWorkPro"));
        sic.add(new SelectorItemInfo("sourcePro"));
        sic.add(new SelectorItemInfo("firstSource"));
        sic.add(new SelectorItemInfo("gifAmountPro"));
        sic.add(new SelectorItemInfo("bkPrice"));
        sic.add(new SelectorItemInfo("qkPrice"));
        return sic;
    }        

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.mw.pay.client", "DocCurrencyProEditUI");
    }

    /**
     * output getEditUIName method
     */
    protected String getEditUIName()
    {
        return com.kingdee.eas.mw.pay.client.DocCurrencyProEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.mw.pay.DocCurrencyProFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.mw.pay.DocCurrencyProInfo objectValue = new com.kingdee.eas.mw.pay.DocCurrencyProInfo();
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
		vo.put("calType","zskc");
        
    }        
	protected void setFieldsNull(com.kingdee.bos.dao.AbstractObjectValue arg0) {
		super.setFieldsNull(arg0);
		arg0.put("number",null);
	}

}