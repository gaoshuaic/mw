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
public abstract class AbstractClinicMonthSumEditUI extends com.kingdee.eas.framework.client.EditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractClinicMonthSumEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer2;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer3;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer4;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbusinessDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcityNumber;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcity;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contclinicNumber;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contclinicName;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contdiary;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer continCome;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcityid;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contclinicid;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contliushui;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox txtName;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtSimpleName;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox txtDescription;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtbusinessDate;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtcityNumber;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtcity;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtclinicNumber;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtclinicName;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtdiary;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtinCome;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtcityid;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtclinicid;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtliushui;
    protected com.kingdee.eas.mw.pay.ClinicMonthSumInfo editData = null;
    /**
     * output class constructor
     */
    public AbstractClinicMonthSumEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractClinicMonthSumEditUI.class.getName());
        this.setUITitle(resHelper.getString("this.title"));
        this.kDLabelContainer1 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer2 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer3 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer4 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbusinessDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcityNumber = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcity = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contclinicNumber = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contclinicName = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contdiary = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.continCome = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcityid = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contclinicid = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contliushui = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtName = new com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox();
        this.txtSimpleName = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtDescription = new com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox();
        this.txtbusinessDate = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtcityNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtcity = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtclinicNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtclinicName = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtdiary = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtinCome = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtcityid = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtclinicid = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtliushui = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.kDLabelContainer1.setName("kDLabelContainer1");
        this.kDLabelContainer2.setName("kDLabelContainer2");
        this.kDLabelContainer3.setName("kDLabelContainer3");
        this.kDLabelContainer4.setName("kDLabelContainer4");
        this.contbusinessDate.setName("contbusinessDate");
        this.contcityNumber.setName("contcityNumber");
        this.contcity.setName("contcity");
        this.contclinicNumber.setName("contclinicNumber");
        this.contclinicName.setName("contclinicName");
        this.contdiary.setName("contdiary");
        this.continCome.setName("continCome");
        this.contcityid.setName("contcityid");
        this.contclinicid.setName("contclinicid");
        this.contliushui.setName("contliushui");
        this.txtNumber.setName("txtNumber");
        this.txtName.setName("txtName");
        this.txtSimpleName.setName("txtSimpleName");
        this.txtDescription.setName("txtDescription");
        this.txtbusinessDate.setName("txtbusinessDate");
        this.txtcityNumber.setName("txtcityNumber");
        this.txtcity.setName("txtcity");
        this.txtclinicNumber.setName("txtclinicNumber");
        this.txtclinicName.setName("txtclinicName");
        this.txtdiary.setName("txtdiary");
        this.txtinCome.setName("txtinCome");
        this.txtcityid.setName("txtcityid");
        this.txtclinicid.setName("txtclinicid");
        this.txtliushui.setName("txtliushui");
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
        // contcity		
        this.contcity.setBoundLabelText(resHelper.getString("contcity.boundLabelText"));		
        this.contcity.setBoundLabelLength(100);		
        this.contcity.setBoundLabelUnderline(true);		
        this.contcity.setVisible(true);
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
        // contdiary		
        this.contdiary.setBoundLabelText(resHelper.getString("contdiary.boundLabelText"));		
        this.contdiary.setBoundLabelLength(100);		
        this.contdiary.setBoundLabelUnderline(true);		
        this.contdiary.setVisible(true);
        // continCome		
        this.continCome.setBoundLabelText(resHelper.getString("continCome.boundLabelText"));		
        this.continCome.setBoundLabelLength(100);		
        this.continCome.setBoundLabelUnderline(true);		
        this.continCome.setVisible(true);
        // contcityid		
        this.contcityid.setBoundLabelText(resHelper.getString("contcityid.boundLabelText"));		
        this.contcityid.setBoundLabelLength(100);		
        this.contcityid.setBoundLabelUnderline(true);		
        this.contcityid.setVisible(true);
        // contclinicid		
        this.contclinicid.setBoundLabelText(resHelper.getString("contclinicid.boundLabelText"));		
        this.contclinicid.setBoundLabelLength(100);		
        this.contclinicid.setBoundLabelUnderline(true);		
        this.contclinicid.setVisible(true);
        // contliushui		
        this.contliushui.setBoundLabelText(resHelper.getString("contliushui.boundLabelText"));		
        this.contliushui.setBoundLabelLength(100);		
        this.contliushui.setBoundLabelUnderline(true);		
        this.contliushui.setVisible(true);
        // txtNumber		
        this.txtNumber.setMaxLength(80);
        // txtName
        // txtSimpleName		
        this.txtSimpleName.setMaxLength(80);
        // txtDescription
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
        // txtcity		
        this.txtcity.setVisible(true);		
        this.txtcity.setHorizontalAlignment(2);		
        this.txtcity.setMaxLength(100);		
        this.txtcity.setRequired(false);
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
        // txtdiary		
        this.txtdiary.setVisible(true);		
        this.txtdiary.setHorizontalAlignment(2);		
        this.txtdiary.setDataType(1);		
        this.txtdiary.setSupportedEmpty(true);		
        this.txtdiary.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtdiary.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtdiary.setPrecision(10);		
        this.txtdiary.setRequired(false);
        // txtinCome		
        this.txtinCome.setVisible(true);		
        this.txtinCome.setHorizontalAlignment(2);		
        this.txtinCome.setDataType(1);		
        this.txtinCome.setSupportedEmpty(true);		
        this.txtinCome.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtinCome.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtinCome.setPrecision(10);		
        this.txtinCome.setRequired(false);
        // txtcityid		
        this.txtcityid.setVisible(true);		
        this.txtcityid.setHorizontalAlignment(2);		
        this.txtcityid.setMaxLength(100);		
        this.txtcityid.setRequired(false);
        // txtclinicid		
        this.txtclinicid.setVisible(true);		
        this.txtclinicid.setHorizontalAlignment(2);		
        this.txtclinicid.setMaxLength(100);		
        this.txtclinicid.setRequired(false);
        // txtliushui		
        this.txtliushui.setVisible(true);		
        this.txtliushui.setHorizontalAlignment(2);		
        this.txtliushui.setDataType(1);		
        this.txtliushui.setSupportedEmpty(true);		
        this.txtliushui.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtliushui.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtliushui.setPrecision(10);		
        this.txtliushui.setRequired(false);
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {txtbusinessDate,txtcityNumber,txtcity,txtclinicNumber,txtclinicName,txtinCome,txtdiary,txtcityid,txtclinicid,txtliushui}));
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
        kDLabelContainer1.setBounds(new Rectangle(341, 58, 270, 19));
        this.add(kDLabelContainer1, null);
        kDLabelContainer2.setBounds(new Rectangle(672, 58, 270, 19));
        this.add(kDLabelContainer2, null);
        kDLabelContainer3.setBounds(new Rectangle(10, 82, 270, 19));
        this.add(kDLabelContainer3, null);
        kDLabelContainer4.setBounds(new Rectangle(341, 82, 270, 19));
        this.add(kDLabelContainer4, null);
        contbusinessDate.setBounds(new Rectangle(10, 10, 270, 19));
        this.add(contbusinessDate, null);
        contcityNumber.setBounds(new Rectangle(341, 10, 270, 19));
        this.add(contcityNumber, null);
        contcity.setBounds(new Rectangle(672, 10, 270, 19));
        this.add(contcity, null);
        contclinicNumber.setBounds(new Rectangle(10, 34, 270, 19));
        this.add(contclinicNumber, null);
        contclinicName.setBounds(new Rectangle(341, 34, 270, 19));
        this.add(contclinicName, null);
        contdiary.setBounds(new Rectangle(10, 58, 270, 19));
        this.add(contdiary, null);
        continCome.setBounds(new Rectangle(672, 34, 270, 19));
        this.add(continCome, null);
        contcityid.setBounds(new Rectangle(672, 82, 270, 19));
        this.add(contcityid, null);
        contclinicid.setBounds(new Rectangle(10, 106, 270, 19));
        this.add(contclinicid, null);
        contliushui.setBounds(new Rectangle(341, 106, 270, 19));
        this.add(contliushui, null);
        //kDLabelContainer1
        kDLabelContainer1.setBoundEditor(txtNumber);
        //kDLabelContainer2
        kDLabelContainer2.setBoundEditor(txtName);
        //kDLabelContainer3
        kDLabelContainer3.setBoundEditor(txtSimpleName);
        //kDLabelContainer4
        kDLabelContainer4.setBoundEditor(txtDescription);
        //contbusinessDate
        contbusinessDate.setBoundEditor(txtbusinessDate);
        //contcityNumber
        contcityNumber.setBoundEditor(txtcityNumber);
        //contcity
        contcity.setBoundEditor(txtcity);
        //contclinicNumber
        contclinicNumber.setBoundEditor(txtclinicNumber);
        //contclinicName
        contclinicName.setBoundEditor(txtclinicName);
        //contdiary
        contdiary.setBoundEditor(txtdiary);
        //continCome
        continCome.setBoundEditor(txtinCome);
        //contcityid
        contcityid.setBoundEditor(txtcityid);
        //contclinicid
        contclinicid.setBoundEditor(txtclinicid);
        //contliushui
        contliushui.setBoundEditor(txtliushui);

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
		dataBinder.registerBinding("businessDate", String.class, this.txtbusinessDate, "text");
		dataBinder.registerBinding("cityNumber", String.class, this.txtcityNumber, "text");
		dataBinder.registerBinding("city", String.class, this.txtcity, "text");
		dataBinder.registerBinding("clinicNumber", String.class, this.txtclinicNumber, "text");
		dataBinder.registerBinding("clinicName", String.class, this.txtclinicName, "text");
		dataBinder.registerBinding("diary", java.math.BigDecimal.class, this.txtdiary, "value");
		dataBinder.registerBinding("inCome", java.math.BigDecimal.class, this.txtinCome, "value");
		dataBinder.registerBinding("cityid", String.class, this.txtcityid, "text");
		dataBinder.registerBinding("clinicid", String.class, this.txtclinicid, "text");
		dataBinder.registerBinding("liushui", java.math.BigDecimal.class, this.txtliushui, "value");		
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
	    return "com.kingdee.eas.mw.pay.app.ClinicMonthSumEditUIHandler";
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
        this.txtbusinessDate.requestFocusInWindow();
    }

	
	

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject)
    {
        IObjectValue ov = dataObject;        	    	
        super.setDataObject(ov);
        this.editData = (com.kingdee.eas.mw.pay.ClinicMonthSumInfo)ov;
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
		getValidateHelper().registerBindProperty("businessDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("cityNumber", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("city", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("clinicNumber", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("clinicName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("diary", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("inCome", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("cityid", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("clinicid", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("liushui", ValidateHelper.ON_SAVE);    		
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
        sic.add(new SelectorItemInfo("businessDate"));
        sic.add(new SelectorItemInfo("cityNumber"));
        sic.add(new SelectorItemInfo("city"));
        sic.add(new SelectorItemInfo("clinicNumber"));
        sic.add(new SelectorItemInfo("clinicName"));
        sic.add(new SelectorItemInfo("diary"));
        sic.add(new SelectorItemInfo("inCome"));
        sic.add(new SelectorItemInfo("cityid"));
        sic.add(new SelectorItemInfo("clinicid"));
        sic.add(new SelectorItemInfo("liushui"));
        return sic;
    }        

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.mw.pay.client", "ClinicMonthSumEditUI");
    }

    /**
     * output getEditUIName method
     */
    protected String getEditUIName()
    {
        return com.kingdee.eas.mw.pay.client.ClinicMonthSumEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.mw.pay.ClinicMonthSumFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.mw.pay.ClinicMonthSumInfo objectValue = new com.kingdee.eas.mw.pay.ClinicMonthSumInfo();
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