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
public abstract class AbstractConsultantProEditUI extends com.kingdee.eas.framework.client.EditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractConsultantProEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer2;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer3;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer4;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfirst;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfirstMoney;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsecond;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsecondMoney;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contthird;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contyysl;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcityNumber;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcityName;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcity;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contshopSize;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbusinessDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbiliPro;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contdiscount;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conttype;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contkeepPro;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contzbPro;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox txtName;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtSimpleName;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox txtDescription;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtfirst;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtfirstMoney;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtsecond;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtsecondMoney;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtthird;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtyysl;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtcityNumber;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtcityName;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcity;
    protected com.kingdee.bos.ctrl.swing.KDComboBox shopSize;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtbusinessDate;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtbiliPro;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtdiscount;
    protected com.kingdee.bos.ctrl.swing.KDTextField txttype;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtkeepPro;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtzbPro;
    protected com.kingdee.eas.mw.pay.ConsultantProInfo editData = null;
    /**
     * output class constructor
     */
    public AbstractConsultantProEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractConsultantProEditUI.class.getName());
        this.setUITitle(resHelper.getString("this.title"));
        this.kDLabelContainer1 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer2 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer3 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer4 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfirst = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfirstMoney = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contsecond = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contsecondMoney = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contthird = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contyysl = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcityNumber = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcityName = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcity = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contshopSize = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbusinessDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbiliPro = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contdiscount = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conttype = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contkeepPro = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contzbPro = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtName = new com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox();
        this.txtSimpleName = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtDescription = new com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox();
        this.txtfirst = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtfirstMoney = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtsecond = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtsecondMoney = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtthird = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtyysl = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtcityNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtcityName = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtcity = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.shopSize = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.txtbusinessDate = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtbiliPro = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtdiscount = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txttype = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtkeepPro = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtzbPro = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.kDLabelContainer1.setName("kDLabelContainer1");
        this.kDLabelContainer2.setName("kDLabelContainer2");
        this.kDLabelContainer3.setName("kDLabelContainer3");
        this.kDLabelContainer4.setName("kDLabelContainer4");
        this.contfirst.setName("contfirst");
        this.contfirstMoney.setName("contfirstMoney");
        this.contsecond.setName("contsecond");
        this.contsecondMoney.setName("contsecondMoney");
        this.contthird.setName("contthird");
        this.contyysl.setName("contyysl");
        this.contcityNumber.setName("contcityNumber");
        this.contcityName.setName("contcityName");
        this.contcity.setName("contcity");
        this.contshopSize.setName("contshopSize");
        this.contbusinessDate.setName("contbusinessDate");
        this.contbiliPro.setName("contbiliPro");
        this.contdiscount.setName("contdiscount");
        this.conttype.setName("conttype");
        this.contkeepPro.setName("contkeepPro");
        this.contzbPro.setName("contzbPro");
        this.txtNumber.setName("txtNumber");
        this.txtName.setName("txtName");
        this.txtSimpleName.setName("txtSimpleName");
        this.txtDescription.setName("txtDescription");
        this.txtfirst.setName("txtfirst");
        this.txtfirstMoney.setName("txtfirstMoney");
        this.txtsecond.setName("txtsecond");
        this.txtsecondMoney.setName("txtsecondMoney");
        this.txtthird.setName("txtthird");
        this.txtyysl.setName("txtyysl");
        this.txtcityNumber.setName("txtcityNumber");
        this.txtcityName.setName("txtcityName");
        this.prmtcity.setName("prmtcity");
        this.shopSize.setName("shopSize");
        this.txtbusinessDate.setName("txtbusinessDate");
        this.txtbiliPro.setName("txtbiliPro");
        this.txtdiscount.setName("txtdiscount");
        this.txttype.setName("txttype");
        this.txtkeepPro.setName("txtkeepPro");
        this.txtzbPro.setName("txtzbPro");
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
        // contfirst		
        this.contfirst.setBoundLabelText(resHelper.getString("contfirst.boundLabelText"));		
        this.contfirst.setBoundLabelLength(100);		
        this.contfirst.setBoundLabelUnderline(true);		
        this.contfirst.setVisible(true);
        // contfirstMoney		
        this.contfirstMoney.setBoundLabelText(resHelper.getString("contfirstMoney.boundLabelText"));		
        this.contfirstMoney.setBoundLabelLength(100);		
        this.contfirstMoney.setBoundLabelUnderline(true);		
        this.contfirstMoney.setVisible(true);
        // contsecond		
        this.contsecond.setBoundLabelText(resHelper.getString("contsecond.boundLabelText"));		
        this.contsecond.setBoundLabelLength(100);		
        this.contsecond.setBoundLabelUnderline(true);		
        this.contsecond.setVisible(true);
        // contsecondMoney		
        this.contsecondMoney.setBoundLabelText(resHelper.getString("contsecondMoney.boundLabelText"));		
        this.contsecondMoney.setBoundLabelLength(100);		
        this.contsecondMoney.setBoundLabelUnderline(true);		
        this.contsecondMoney.setVisible(true);
        // contthird		
        this.contthird.setBoundLabelText(resHelper.getString("contthird.boundLabelText"));		
        this.contthird.setBoundLabelLength(100);		
        this.contthird.setBoundLabelUnderline(true);		
        this.contthird.setVisible(true);
        // contyysl		
        this.contyysl.setBoundLabelText(resHelper.getString("contyysl.boundLabelText"));		
        this.contyysl.setBoundLabelLength(100);		
        this.contyysl.setBoundLabelUnderline(true);		
        this.contyysl.setVisible(false);
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
        // contshopSize		
        this.contshopSize.setBoundLabelText(resHelper.getString("contshopSize.boundLabelText"));		
        this.contshopSize.setBoundLabelLength(100);		
        this.contshopSize.setBoundLabelUnderline(true);		
        this.contshopSize.setVisible(true);
        // contbusinessDate		
        this.contbusinessDate.setBoundLabelText(resHelper.getString("contbusinessDate.boundLabelText"));		
        this.contbusinessDate.setBoundLabelLength(100);		
        this.contbusinessDate.setBoundLabelUnderline(true);		
        this.contbusinessDate.setVisible(true);
        // contbiliPro		
        this.contbiliPro.setBoundLabelText(resHelper.getString("contbiliPro.boundLabelText"));		
        this.contbiliPro.setBoundLabelLength(100);		
        this.contbiliPro.setBoundLabelUnderline(true);		
        this.contbiliPro.setVisible(true);
        // contdiscount		
        this.contdiscount.setBoundLabelText(resHelper.getString("contdiscount.boundLabelText"));		
        this.contdiscount.setBoundLabelLength(100);		
        this.contdiscount.setBoundLabelUnderline(true);		
        this.contdiscount.setVisible(true);
        // conttype		
        this.conttype.setBoundLabelText(resHelper.getString("conttype.boundLabelText"));		
        this.conttype.setBoundLabelLength(100);		
        this.conttype.setBoundLabelUnderline(true);		
        this.conttype.setVisible(true);
        // contkeepPro		
        this.contkeepPro.setBoundLabelText(resHelper.getString("contkeepPro.boundLabelText"));		
        this.contkeepPro.setBoundLabelLength(100);		
        this.contkeepPro.setBoundLabelUnderline(true);		
        this.contkeepPro.setVisible(true);
        // contzbPro		
        this.contzbPro.setBoundLabelText(resHelper.getString("contzbPro.boundLabelText"));		
        this.contzbPro.setBoundLabelLength(100);		
        this.contzbPro.setBoundLabelUnderline(true);		
        this.contzbPro.setVisible(true);
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
        // txtfirst		
        this.txtfirst.setVisible(true);		
        this.txtfirst.setHorizontalAlignment(2);		
        this.txtfirst.setDataType(1);		
        this.txtfirst.setSupportedEmpty(true);		
        this.txtfirst.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtfirst.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtfirst.setPrecision(10);		
        this.txtfirst.setRequired(false);
        // txtfirstMoney		
        this.txtfirstMoney.setVisible(true);		
        this.txtfirstMoney.setHorizontalAlignment(2);		
        this.txtfirstMoney.setDataType(1);		
        this.txtfirstMoney.setSupportedEmpty(true);		
        this.txtfirstMoney.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtfirstMoney.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtfirstMoney.setPrecision(10);		
        this.txtfirstMoney.setRequired(false);
        // txtsecond		
        this.txtsecond.setVisible(true);		
        this.txtsecond.setHorizontalAlignment(2);		
        this.txtsecond.setDataType(1);		
        this.txtsecond.setSupportedEmpty(true);		
        this.txtsecond.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtsecond.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtsecond.setPrecision(10);		
        this.txtsecond.setRequired(false);
        // txtsecondMoney		
        this.txtsecondMoney.setVisible(true);		
        this.txtsecondMoney.setHorizontalAlignment(2);		
        this.txtsecondMoney.setDataType(1);		
        this.txtsecondMoney.setSupportedEmpty(true);		
        this.txtsecondMoney.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtsecondMoney.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtsecondMoney.setPrecision(10);		
        this.txtsecondMoney.setRequired(false);
        // txtthird		
        this.txtthird.setVisible(true);		
        this.txtthird.setHorizontalAlignment(2);		
        this.txtthird.setDataType(1);		
        this.txtthird.setSupportedEmpty(true);		
        this.txtthird.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtthird.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtthird.setPrecision(10);		
        this.txtthird.setRequired(false);
        // txtyysl		
        this.txtyysl.setVisible(false);		
        this.txtyysl.setHorizontalAlignment(2);		
        this.txtyysl.setDataType(1);		
        this.txtyysl.setSupportedEmpty(true);		
        this.txtyysl.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtyysl.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtyysl.setPrecision(10);		
        this.txtyysl.setRequired(false);		
        this.txtyysl.setEnabled(false);		
        this.txtyysl.setOpaque(false);
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
        // shopSize		
        this.shopSize.setVisible(true);		
        this.shopSize.addItems(EnumUtils.getEnumList("com.kingdee.eas.mw.pay.app.ShopSize").toArray());		
        this.shopSize.setRequired(false);
        // txtbusinessDate		
        this.txtbusinessDate.setVisible(true);		
        this.txtbusinessDate.setHorizontalAlignment(2);		
        this.txtbusinessDate.setMaxLength(100);		
        this.txtbusinessDate.setRequired(false);
        // txtbiliPro		
        this.txtbiliPro.setVisible(true);		
        this.txtbiliPro.setHorizontalAlignment(2);		
        this.txtbiliPro.setDataType(1);		
        this.txtbiliPro.setSupportedEmpty(true);		
        this.txtbiliPro.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtbiliPro.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtbiliPro.setPrecision(10);		
        this.txtbiliPro.setRequired(false);
        // txtdiscount		
        this.txtdiscount.setVisible(true);		
        this.txtdiscount.setHorizontalAlignment(2);		
        this.txtdiscount.setDataType(1);		
        this.txtdiscount.setSupportedEmpty(true);		
        this.txtdiscount.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtdiscount.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtdiscount.setPrecision(10);		
        this.txtdiscount.setRequired(false);
        // txttype		
        this.txttype.setVisible(true);		
        this.txttype.setHorizontalAlignment(2);		
        this.txttype.setMaxLength(100);		
        this.txttype.setRequired(false);
        // txtkeepPro		
        this.txtkeepPro.setVisible(true);		
        this.txtkeepPro.setHorizontalAlignment(2);		
        this.txtkeepPro.setDataType(1);		
        this.txtkeepPro.setSupportedEmpty(true);		
        this.txtkeepPro.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtkeepPro.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtkeepPro.setPrecision(10);		
        this.txtkeepPro.setRequired(false);
        // txtzbPro		
        this.txtzbPro.setVisible(true);		
        this.txtzbPro.setHorizontalAlignment(2);		
        this.txtzbPro.setDataType(1);		
        this.txtzbPro.setSupportedEmpty(true);		
        this.txtzbPro.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtzbPro.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtzbPro.setPrecision(10);		
        this.txtzbPro.setRequired(false);
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {txtfirst,txtfirstMoney,txtsecond,txtsecondMoney,txtthird,txtyysl,txtcityNumber,txtcityName,prmtcity,shopSize,txtbusinessDate,txtbiliPro,txtdiscount,txttype,txtkeepPro,txtzbPro}));
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
        this.setBounds(new Rectangle(0, 0, 1013, 197));
        this.setLayout(null);
        kDLabelContainer1.setBounds(new Rectangle(10, 106, 270, 19));
        this.add(kDLabelContainer1, null);
        kDLabelContainer2.setBounds(new Rectangle(341, 10, 270, 19));
        this.add(kDLabelContainer2, null);
        kDLabelContainer3.setBounds(new Rectangle(672, 82, 270, 19));
        this.add(kDLabelContainer3, null);
        kDLabelContainer4.setBounds(new Rectangle(10, 82, 270, 19));
        this.add(kDLabelContainer4, null);
        contfirst.setBounds(new Rectangle(10, 34, 270, 19));
        this.add(contfirst, null);
        contfirstMoney.setBounds(new Rectangle(672, 10, 270, 19));
        this.add(contfirstMoney, null);
        contsecond.setBounds(new Rectangle(341, 34, 270, 19));
        this.add(contsecond, null);
        contsecondMoney.setBounds(new Rectangle(672, 34, 270, 19));
        this.add(contsecondMoney, null);
        contthird.setBounds(new Rectangle(10, 58, 270, 19));
        this.add(contthird, null);
        contyysl.setBounds(new Rectangle(341, 82, 270, 19));
        this.add(contyysl, null);
        contcityNumber.setBounds(new Rectangle(341, 58, 270, 19));
        this.add(contcityNumber, null);
        contcityName.setBounds(new Rectangle(672, 58, 270, 19));
        this.add(contcityName, null);
        contcity.setBounds(new Rectangle(341, 106, 270, 19));
        this.add(contcity, null);
        contshopSize.setBounds(new Rectangle(10, 10, 270, 19));
        this.add(contshopSize, null);
        contbusinessDate.setBounds(new Rectangle(672, 106, 270, 19));
        this.add(contbusinessDate, null);
        contbiliPro.setBounds(new Rectangle(341, 130, 270, 19));
        this.add(contbiliPro, null);
        contdiscount.setBounds(new Rectangle(672, 130, 270, 19));
        this.add(contdiscount, null);
        conttype.setBounds(new Rectangle(10, 130, 270, 19));
        this.add(conttype, null);
        contkeepPro.setBounds(new Rectangle(10, 154, 270, 19));
        this.add(contkeepPro, null);
        contzbPro.setBounds(new Rectangle(341, 154, 270, 19));
        this.add(contzbPro, null);
        //kDLabelContainer1
        kDLabelContainer1.setBoundEditor(txtNumber);
        //kDLabelContainer2
        kDLabelContainer2.setBoundEditor(txtName);
        //kDLabelContainer3
        kDLabelContainer3.setBoundEditor(txtSimpleName);
        //kDLabelContainer4
        kDLabelContainer4.setBoundEditor(txtDescription);
        //contfirst
        contfirst.setBoundEditor(txtfirst);
        //contfirstMoney
        contfirstMoney.setBoundEditor(txtfirstMoney);
        //contsecond
        contsecond.setBoundEditor(txtsecond);
        //contsecondMoney
        contsecondMoney.setBoundEditor(txtsecondMoney);
        //contthird
        contthird.setBoundEditor(txtthird);
        //contyysl
        contyysl.setBoundEditor(txtyysl);
        //contcityNumber
        contcityNumber.setBoundEditor(txtcityNumber);
        //contcityName
        contcityName.setBoundEditor(txtcityName);
        //contcity
        contcity.setBoundEditor(prmtcity);
        //contshopSize
        contshopSize.setBoundEditor(shopSize);
        //contbusinessDate
        contbusinessDate.setBoundEditor(txtbusinessDate);
        //contbiliPro
        contbiliPro.setBoundEditor(txtbiliPro);
        //contdiscount
        contdiscount.setBoundEditor(txtdiscount);
        //conttype
        conttype.setBoundEditor(txttype);
        //contkeepPro
        contkeepPro.setBoundEditor(txtkeepPro);
        //contzbPro
        contzbPro.setBoundEditor(txtzbPro);

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
		dataBinder.registerBinding("first", java.math.BigDecimal.class, this.txtfirst, "value");
		dataBinder.registerBinding("firstMoney", java.math.BigDecimal.class, this.txtfirstMoney, "value");
		dataBinder.registerBinding("second", java.math.BigDecimal.class, this.txtsecond, "value");
		dataBinder.registerBinding("secondMoney", java.math.BigDecimal.class, this.txtsecondMoney, "value");
		dataBinder.registerBinding("third", java.math.BigDecimal.class, this.txtthird, "value");
		dataBinder.registerBinding("yysl", java.math.BigDecimal.class, this.txtyysl, "value");
		dataBinder.registerBinding("cityNumber", String.class, this.txtcityNumber, "text");
		dataBinder.registerBinding("cityName", String.class, this.txtcityName, "text");
		dataBinder.registerBinding("city", com.kingdee.eas.basedata.org.CtrlUnitInfo.class, this.prmtcity, "data");
		dataBinder.registerBinding("shopSize", com.kingdee.eas.mw.pay.app.ShopSize.class, this.shopSize, "selectedItem");
		dataBinder.registerBinding("businessDate", String.class, this.txtbusinessDate, "text");
		dataBinder.registerBinding("biliPro", java.math.BigDecimal.class, this.txtbiliPro, "value");
		dataBinder.registerBinding("discount", java.math.BigDecimal.class, this.txtdiscount, "value");
		dataBinder.registerBinding("type", String.class, this.txttype, "text");
		dataBinder.registerBinding("keepPro", java.math.BigDecimal.class, this.txtkeepPro, "value");
		dataBinder.registerBinding("zbPro", java.math.BigDecimal.class, this.txtzbPro, "value");		
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
	    return "com.kingdee.eas.mw.pay.app.ConsultantProEditUIHandler";
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
        this.txtfirst.requestFocusInWindow();
    }

	
	

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject)
    {
        IObjectValue ov = dataObject;        	    	
        super.setDataObject(ov);
        this.editData = (com.kingdee.eas.mw.pay.ConsultantProInfo)ov;
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
		getValidateHelper().registerBindProperty("first", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("firstMoney", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("second", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("secondMoney", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("third", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("yysl", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("cityNumber", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("cityName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("city", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("shopSize", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("businessDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("biliPro", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("discount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("type", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("keepPro", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("zbPro", ValidateHelper.ON_SAVE);    		
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
        sic.add(new SelectorItemInfo("first"));
        sic.add(new SelectorItemInfo("firstMoney"));
        sic.add(new SelectorItemInfo("second"));
        sic.add(new SelectorItemInfo("secondMoney"));
        sic.add(new SelectorItemInfo("third"));
        sic.add(new SelectorItemInfo("yysl"));
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
        sic.add(new SelectorItemInfo("shopSize"));
        sic.add(new SelectorItemInfo("businessDate"));
        sic.add(new SelectorItemInfo("biliPro"));
        sic.add(new SelectorItemInfo("discount"));
        sic.add(new SelectorItemInfo("type"));
        sic.add(new SelectorItemInfo("keepPro"));
        sic.add(new SelectorItemInfo("zbPro"));
        return sic;
    }        

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.mw.pay.client", "ConsultantProEditUI");
    }

    /**
     * output getEditUIName method
     */
    protected String getEditUIName()
    {
        return com.kingdee.eas.mw.pay.client.ConsultantProEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.mw.pay.ConsultantProFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.mw.pay.ConsultantProInfo objectValue = new com.kingdee.eas.mw.pay.ConsultantProInfo();
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
		vo.put("shopSize","dd");
        
    }        
	protected void setFieldsNull(com.kingdee.bos.dao.AbstractObjectValue arg0) {
		super.setFieldsNull(arg0);
		arg0.put("number",null);
	}

}