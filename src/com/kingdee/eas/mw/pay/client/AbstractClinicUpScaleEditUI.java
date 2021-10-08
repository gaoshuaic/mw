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
public abstract class AbstractClinicUpScaleEditUI extends com.kingdee.eas.framework.client.EditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractClinicUpScaleEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer2;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer3;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer4;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcity;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contclinic;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conthigAmount;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contrewardAmount;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contpassPro;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contaddAmount;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contachievePro;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbusinessDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbigShopPrice;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsmallShopAmount;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox txtName;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtSimpleName;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox txtDescription;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcity;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtclinic;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txthigAmount;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtrewardAmount;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtpassPro;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtaddAmount;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtachievePro;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtbusinessDate;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtbigShopPrice;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtsmallShopAmount;
    protected com.kingdee.eas.mw.pay.ClinicUpScaleInfo editData = null;
    /**
     * output class constructor
     */
    public AbstractClinicUpScaleEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractClinicUpScaleEditUI.class.getName());
        this.setUITitle(resHelper.getString("this.title"));
        this.kDLabelContainer1 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer2 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer3 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer4 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcity = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contclinic = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conthigAmount = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contrewardAmount = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contpassPro = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contaddAmount = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contachievePro = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbusinessDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbigShopPrice = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contsmallShopAmount = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtName = new com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox();
        this.txtSimpleName = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtDescription = new com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox();
        this.prmtcity = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtclinic = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txthigAmount = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtrewardAmount = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtpassPro = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtaddAmount = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtachievePro = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtbusinessDate = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtbigShopPrice = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtsmallShopAmount = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.kDLabelContainer1.setName("kDLabelContainer1");
        this.kDLabelContainer2.setName("kDLabelContainer2");
        this.kDLabelContainer3.setName("kDLabelContainer3");
        this.kDLabelContainer4.setName("kDLabelContainer4");
        this.contcity.setName("contcity");
        this.contclinic.setName("contclinic");
        this.conthigAmount.setName("conthigAmount");
        this.contrewardAmount.setName("contrewardAmount");
        this.contpassPro.setName("contpassPro");
        this.contaddAmount.setName("contaddAmount");
        this.contachievePro.setName("contachievePro");
        this.contbusinessDate.setName("contbusinessDate");
        this.contbigShopPrice.setName("contbigShopPrice");
        this.contsmallShopAmount.setName("contsmallShopAmount");
        this.txtNumber.setName("txtNumber");
        this.txtName.setName("txtName");
        this.txtSimpleName.setName("txtSimpleName");
        this.txtDescription.setName("txtDescription");
        this.prmtcity.setName("prmtcity");
        this.prmtclinic.setName("prmtclinic");
        this.txthigAmount.setName("txthigAmount");
        this.txtrewardAmount.setName("txtrewardAmount");
        this.txtpassPro.setName("txtpassPro");
        this.txtaddAmount.setName("txtaddAmount");
        this.txtachievePro.setName("txtachievePro");
        this.txtbusinessDate.setName("txtbusinessDate");
        this.txtbigShopPrice.setName("txtbigShopPrice");
        this.txtsmallShopAmount.setName("txtsmallShopAmount");
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
        // contcity		
        this.contcity.setBoundLabelText(resHelper.getString("contcity.boundLabelText"));		
        this.contcity.setBoundLabelLength(100);		
        this.contcity.setBoundLabelUnderline(true);		
        this.contcity.setVisible(true);
        // contclinic		
        this.contclinic.setBoundLabelText(resHelper.getString("contclinic.boundLabelText"));		
        this.contclinic.setBoundLabelLength(100);		
        this.contclinic.setBoundLabelUnderline(true);		
        this.contclinic.setVisible(true);
        // conthigAmount		
        this.conthigAmount.setBoundLabelText(resHelper.getString("conthigAmount.boundLabelText"));		
        this.conthigAmount.setBoundLabelLength(100);		
        this.conthigAmount.setBoundLabelUnderline(true);		
        this.conthigAmount.setVisible(true);
        // contrewardAmount		
        this.contrewardAmount.setBoundLabelText(resHelper.getString("contrewardAmount.boundLabelText"));		
        this.contrewardAmount.setBoundLabelLength(100);		
        this.contrewardAmount.setBoundLabelUnderline(true);		
        this.contrewardAmount.setVisible(true);
        // contpassPro		
        this.contpassPro.setBoundLabelText(resHelper.getString("contpassPro.boundLabelText"));		
        this.contpassPro.setBoundLabelLength(100);		
        this.contpassPro.setBoundLabelUnderline(true);		
        this.contpassPro.setVisible(true);
        // contaddAmount		
        this.contaddAmount.setBoundLabelText(resHelper.getString("contaddAmount.boundLabelText"));		
        this.contaddAmount.setBoundLabelLength(100);		
        this.contaddAmount.setBoundLabelUnderline(true);		
        this.contaddAmount.setVisible(true);
        // contachievePro		
        this.contachievePro.setBoundLabelText(resHelper.getString("contachievePro.boundLabelText"));		
        this.contachievePro.setBoundLabelLength(100);		
        this.contachievePro.setBoundLabelUnderline(true);		
        this.contachievePro.setVisible(true);
        // contbusinessDate		
        this.contbusinessDate.setBoundLabelText(resHelper.getString("contbusinessDate.boundLabelText"));		
        this.contbusinessDate.setBoundLabelLength(100);		
        this.contbusinessDate.setBoundLabelUnderline(true);		
        this.contbusinessDate.setVisible(true);
        // contbigShopPrice		
        this.contbigShopPrice.setBoundLabelText(resHelper.getString("contbigShopPrice.boundLabelText"));		
        this.contbigShopPrice.setBoundLabelLength(100);		
        this.contbigShopPrice.setBoundLabelUnderline(true);		
        this.contbigShopPrice.setVisible(true);
        // contsmallShopAmount		
        this.contsmallShopAmount.setBoundLabelText(resHelper.getString("contsmallShopAmount.boundLabelText"));		
        this.contsmallShopAmount.setBoundLabelLength(100);		
        this.contsmallShopAmount.setBoundLabelUnderline(true);		
        this.contsmallShopAmount.setVisible(true);
        // txtNumber		
        this.txtNumber.setMaxLength(80);
        // txtName
        // txtSimpleName		
        this.txtSimpleName.setMaxLength(80);
        // txtDescription
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
        // txthigAmount		
        this.txthigAmount.setVisible(true);		
        this.txthigAmount.setHorizontalAlignment(2);		
        this.txthigAmount.setDataType(1);		
        this.txthigAmount.setSupportedEmpty(true);		
        this.txthigAmount.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txthigAmount.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txthigAmount.setPrecision(10);		
        this.txthigAmount.setRequired(false);
        // txtrewardAmount		
        this.txtrewardAmount.setVisible(true);		
        this.txtrewardAmount.setHorizontalAlignment(2);		
        this.txtrewardAmount.setDataType(1);		
        this.txtrewardAmount.setSupportedEmpty(true);		
        this.txtrewardAmount.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtrewardAmount.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtrewardAmount.setPrecision(10);		
        this.txtrewardAmount.setRequired(false);
        // txtpassPro		
        this.txtpassPro.setVisible(true);		
        this.txtpassPro.setHorizontalAlignment(2);		
        this.txtpassPro.setDataType(1);		
        this.txtpassPro.setSupportedEmpty(true);		
        this.txtpassPro.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtpassPro.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtpassPro.setPrecision(10);		
        this.txtpassPro.setRequired(false);
        // txtaddAmount		
        this.txtaddAmount.setVisible(true);		
        this.txtaddAmount.setHorizontalAlignment(2);		
        this.txtaddAmount.setDataType(1);		
        this.txtaddAmount.setSupportedEmpty(true);		
        this.txtaddAmount.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtaddAmount.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtaddAmount.setPrecision(10);		
        this.txtaddAmount.setRequired(false);
        // txtachievePro		
        this.txtachievePro.setVisible(true);		
        this.txtachievePro.setHorizontalAlignment(2);		
        this.txtachievePro.setDataType(1);		
        this.txtachievePro.setSupportedEmpty(true);		
        this.txtachievePro.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtachievePro.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtachievePro.setPrecision(10);		
        this.txtachievePro.setRequired(false);
        // txtbusinessDate		
        this.txtbusinessDate.setVisible(true);		
        this.txtbusinessDate.setHorizontalAlignment(2);		
        this.txtbusinessDate.setMaxLength(100);		
        this.txtbusinessDate.setRequired(false);
        // txtbigShopPrice		
        this.txtbigShopPrice.setVisible(true);		
        this.txtbigShopPrice.setHorizontalAlignment(2);		
        this.txtbigShopPrice.setDataType(1);		
        this.txtbigShopPrice.setSupportedEmpty(true);		
        this.txtbigShopPrice.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtbigShopPrice.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtbigShopPrice.setPrecision(10);		
        this.txtbigShopPrice.setRequired(false);
        // txtsmallShopAmount		
        this.txtsmallShopAmount.setVisible(true);		
        this.txtsmallShopAmount.setHorizontalAlignment(2);		
        this.txtsmallShopAmount.setDataType(1);		
        this.txtsmallShopAmount.setSupportedEmpty(true);		
        this.txtsmallShopAmount.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtsmallShopAmount.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtsmallShopAmount.setPrecision(10);		
        this.txtsmallShopAmount.setRequired(false);
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {prmtcity,prmtclinic,txthigAmount,txtrewardAmount,txtpassPro,txtaddAmount,txtachievePro,txtbusinessDate,txtbigShopPrice,txtsmallShopAmount}));
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
        this.setBounds(new Rectangle(0, 0, 1013, 149));
        this.setLayout(null);
        kDLabelContainer1.setBounds(new Rectangle(10, 82, 270, 19));
        this.add(kDLabelContainer1, null);
        kDLabelContainer2.setBounds(new Rectangle(341, 82, 270, 19));
        this.add(kDLabelContainer2, null);
        kDLabelContainer3.setBounds(new Rectangle(672, 82, 270, 19));
        this.add(kDLabelContainer3, null);
        kDLabelContainer4.setBounds(new Rectangle(672, 58, 270, 19));
        this.add(kDLabelContainer4, null);
        contcity.setBounds(new Rectangle(10, 10, 270, 19));
        this.add(contcity, null);
        contclinic.setBounds(new Rectangle(341, 10, 270, 19));
        this.add(contclinic, null);
        conthigAmount.setBounds(new Rectangle(10, 34, 270, 19));
        this.add(conthigAmount, null);
        contrewardAmount.setBounds(new Rectangle(341, 34, 270, 19));
        this.add(contrewardAmount, null);
        contpassPro.setBounds(new Rectangle(10, 58, 270, 19));
        this.add(contpassPro, null);
        contaddAmount.setBounds(new Rectangle(672, 34, 270, 19));
        this.add(contaddAmount, null);
        contachievePro.setBounds(new Rectangle(341, 58, 270, 19));
        this.add(contachievePro, null);
        contbusinessDate.setBounds(new Rectangle(672, 10, 270, 19));
        this.add(contbusinessDate, null);
        contbigShopPrice.setBounds(new Rectangle(10, 106, 270, 19));
        this.add(contbigShopPrice, null);
        contsmallShopAmount.setBounds(new Rectangle(341, 106, 270, 19));
        this.add(contsmallShopAmount, null);
        //kDLabelContainer1
        kDLabelContainer1.setBoundEditor(txtNumber);
        //kDLabelContainer2
        kDLabelContainer2.setBoundEditor(txtName);
        //kDLabelContainer3
        kDLabelContainer3.setBoundEditor(txtSimpleName);
        //kDLabelContainer4
        kDLabelContainer4.setBoundEditor(txtDescription);
        //contcity
        contcity.setBoundEditor(prmtcity);
        //contclinic
        contclinic.setBoundEditor(prmtclinic);
        //conthigAmount
        conthigAmount.setBoundEditor(txthigAmount);
        //contrewardAmount
        contrewardAmount.setBoundEditor(txtrewardAmount);
        //contpassPro
        contpassPro.setBoundEditor(txtpassPro);
        //contaddAmount
        contaddAmount.setBoundEditor(txtaddAmount);
        //contachievePro
        contachievePro.setBoundEditor(txtachievePro);
        //contbusinessDate
        contbusinessDate.setBoundEditor(txtbusinessDate);
        //contbigShopPrice
        contbigShopPrice.setBoundEditor(txtbigShopPrice);
        //contsmallShopAmount
        contsmallShopAmount.setBoundEditor(txtsmallShopAmount);

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
		dataBinder.registerBinding("city", com.kingdee.eas.basedata.org.CtrlUnitInfo.class, this.prmtcity, "data");
		dataBinder.registerBinding("clinic", com.kingdee.eas.basedata.org.CompanyOrgUnitInfo.class, this.prmtclinic, "data");
		dataBinder.registerBinding("higAmount", java.math.BigDecimal.class, this.txthigAmount, "value");
		dataBinder.registerBinding("rewardAmount", java.math.BigDecimal.class, this.txtrewardAmount, "value");
		dataBinder.registerBinding("passPro", java.math.BigDecimal.class, this.txtpassPro, "value");
		dataBinder.registerBinding("addAmount", java.math.BigDecimal.class, this.txtaddAmount, "value");
		dataBinder.registerBinding("achievePro", java.math.BigDecimal.class, this.txtachievePro, "value");
		dataBinder.registerBinding("businessDate", String.class, this.txtbusinessDate, "text");
		dataBinder.registerBinding("bigShopPrice", java.math.BigDecimal.class, this.txtbigShopPrice, "value");
		dataBinder.registerBinding("smallShopAmount", java.math.BigDecimal.class, this.txtsmallShopAmount, "value");		
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
	    return "com.kingdee.eas.mw.pay.app.ClinicUpScaleEditUIHandler";
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
        this.prmtcity.requestFocusInWindow();
    }

	
	

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject)
    {
        IObjectValue ov = dataObject;        	    	
        super.setDataObject(ov);
        this.editData = (com.kingdee.eas.mw.pay.ClinicUpScaleInfo)ov;
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
		getValidateHelper().registerBindProperty("city", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("clinic", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("higAmount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("rewardAmount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("passPro", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("addAmount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("achievePro", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("businessDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("bigShopPrice", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("smallShopAmount", ValidateHelper.ON_SAVE);    		
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
        sic.add(new SelectorItemInfo("higAmount"));
        sic.add(new SelectorItemInfo("rewardAmount"));
        sic.add(new SelectorItemInfo("passPro"));
        sic.add(new SelectorItemInfo("addAmount"));
        sic.add(new SelectorItemInfo("achievePro"));
        sic.add(new SelectorItemInfo("businessDate"));
        sic.add(new SelectorItemInfo("bigShopPrice"));
        sic.add(new SelectorItemInfo("smallShopAmount"));
        return sic;
    }        

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.mw.pay.client", "ClinicUpScaleEditUI");
    }

    /**
     * output getEditUIName method
     */
    protected String getEditUIName()
    {
        return com.kingdee.eas.mw.pay.client.ClinicUpScaleEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.mw.pay.ClinicUpScaleFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.mw.pay.ClinicUpScaleInfo objectValue = new com.kingdee.eas.mw.pay.ClinicUpScaleInfo();
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