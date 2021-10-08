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
public abstract class AbstractDocHISBiLiEditUI extends com.kingdee.eas.framework.client.EditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractDocHISBiLiEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer2;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer3;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer4;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contyijikou;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conterjikou;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contyxkou;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contgdkou;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contyxshengyukou;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contgdshengyukou;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contyijiqudao;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conterjiqudao;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox txtName;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtSimpleName;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox txtDescription;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtyijikou;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txterjikou;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtyxkou;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtgdkou;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtyxshengyukou;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtgdshengyukou;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtyijiqudao;
    protected com.kingdee.bos.ctrl.swing.KDTextField txterjiqudao;
    protected com.kingdee.eas.mw.pay.DocHISBiLiInfo editData = null;
    /**
     * output class constructor
     */
    public AbstractDocHISBiLiEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractDocHISBiLiEditUI.class.getName());
        this.setUITitle(resHelper.getString("this.title"));
        this.kDLabelContainer1 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer2 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer3 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer4 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contyijikou = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conterjikou = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contyxkou = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contgdkou = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contyxshengyukou = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contgdshengyukou = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contyijiqudao = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conterjiqudao = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtName = new com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox();
        this.txtSimpleName = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtDescription = new com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox();
        this.txtyijikou = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txterjikou = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtyxkou = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtgdkou = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtyxshengyukou = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtgdshengyukou = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtyijiqudao = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txterjiqudao = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.kDLabelContainer1.setName("kDLabelContainer1");
        this.kDLabelContainer2.setName("kDLabelContainer2");
        this.kDLabelContainer3.setName("kDLabelContainer3");
        this.kDLabelContainer4.setName("kDLabelContainer4");
        this.contyijikou.setName("contyijikou");
        this.conterjikou.setName("conterjikou");
        this.contyxkou.setName("contyxkou");
        this.contgdkou.setName("contgdkou");
        this.contyxshengyukou.setName("contyxshengyukou");
        this.contgdshengyukou.setName("contgdshengyukou");
        this.contyijiqudao.setName("contyijiqudao");
        this.conterjiqudao.setName("conterjiqudao");
        this.txtNumber.setName("txtNumber");
        this.txtName.setName("txtName");
        this.txtSimpleName.setName("txtSimpleName");
        this.txtDescription.setName("txtDescription");
        this.txtyijikou.setName("txtyijikou");
        this.txterjikou.setName("txterjikou");
        this.txtyxkou.setName("txtyxkou");
        this.txtgdkou.setName("txtgdkou");
        this.txtyxshengyukou.setName("txtyxshengyukou");
        this.txtgdshengyukou.setName("txtgdshengyukou");
        this.txtyijiqudao.setName("txtyijiqudao");
        this.txterjiqudao.setName("txterjiqudao");
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
        // contyijikou		
        this.contyijikou.setBoundLabelText(resHelper.getString("contyijikou.boundLabelText"));		
        this.contyijikou.setBoundLabelLength(100);		
        this.contyijikou.setBoundLabelUnderline(true);		
        this.contyijikou.setVisible(true);
        // conterjikou		
        this.conterjikou.setBoundLabelText(resHelper.getString("conterjikou.boundLabelText"));		
        this.conterjikou.setBoundLabelLength(100);		
        this.conterjikou.setBoundLabelUnderline(true);		
        this.conterjikou.setVisible(true);
        // contyxkou		
        this.contyxkou.setBoundLabelText(resHelper.getString("contyxkou.boundLabelText"));		
        this.contyxkou.setBoundLabelLength(100);		
        this.contyxkou.setBoundLabelUnderline(true);		
        this.contyxkou.setVisible(true);
        // contgdkou		
        this.contgdkou.setBoundLabelText(resHelper.getString("contgdkou.boundLabelText"));		
        this.contgdkou.setBoundLabelLength(100);		
        this.contgdkou.setBoundLabelUnderline(true);		
        this.contgdkou.setVisible(true);
        // contyxshengyukou		
        this.contyxshengyukou.setBoundLabelText(resHelper.getString("contyxshengyukou.boundLabelText"));		
        this.contyxshengyukou.setBoundLabelLength(100);		
        this.contyxshengyukou.setBoundLabelUnderline(true);		
        this.contyxshengyukou.setVisible(true);
        // contgdshengyukou		
        this.contgdshengyukou.setBoundLabelText(resHelper.getString("contgdshengyukou.boundLabelText"));		
        this.contgdshengyukou.setBoundLabelLength(100);		
        this.contgdshengyukou.setBoundLabelUnderline(true);		
        this.contgdshengyukou.setVisible(true);
        // contyijiqudao		
        this.contyijiqudao.setBoundLabelText(resHelper.getString("contyijiqudao.boundLabelText"));		
        this.contyijiqudao.setBoundLabelLength(100);		
        this.contyijiqudao.setBoundLabelUnderline(true);		
        this.contyijiqudao.setVisible(true);
        // conterjiqudao		
        this.conterjiqudao.setBoundLabelText(resHelper.getString("conterjiqudao.boundLabelText"));		
        this.conterjiqudao.setBoundLabelLength(100);		
        this.conterjiqudao.setBoundLabelUnderline(true);		
        this.conterjiqudao.setVisible(true);
        // txtNumber		
        this.txtNumber.setMaxLength(80);
        // txtName
        // txtSimpleName		
        this.txtSimpleName.setMaxLength(80);
        // txtDescription
        // txtyijikou		
        this.txtyijikou.setVisible(true);		
        this.txtyijikou.setHorizontalAlignment(2);		
        this.txtyijikou.setDataType(1);		
        this.txtyijikou.setSupportedEmpty(true);		
        this.txtyijikou.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtyijikou.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtyijikou.setPrecision(10);		
        this.txtyijikou.setRequired(false);
        // txterjikou		
        this.txterjikou.setVisible(true);		
        this.txterjikou.setHorizontalAlignment(2);		
        this.txterjikou.setDataType(1);		
        this.txterjikou.setSupportedEmpty(true);		
        this.txterjikou.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txterjikou.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txterjikou.setPrecision(10);		
        this.txterjikou.setRequired(false);
        // txtyxkou		
        this.txtyxkou.setVisible(true);		
        this.txtyxkou.setHorizontalAlignment(2);		
        this.txtyxkou.setDataType(1);		
        this.txtyxkou.setSupportedEmpty(true);		
        this.txtyxkou.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtyxkou.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtyxkou.setPrecision(10);		
        this.txtyxkou.setRequired(false);
        // txtgdkou		
        this.txtgdkou.setVisible(true);		
        this.txtgdkou.setHorizontalAlignment(2);		
        this.txtgdkou.setDataType(1);		
        this.txtgdkou.setSupportedEmpty(true);		
        this.txtgdkou.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtgdkou.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtgdkou.setPrecision(10);		
        this.txtgdkou.setRequired(false);
        // txtyxshengyukou		
        this.txtyxshengyukou.setVisible(true);		
        this.txtyxshengyukou.setHorizontalAlignment(2);		
        this.txtyxshengyukou.setDataType(1);		
        this.txtyxshengyukou.setSupportedEmpty(true);		
        this.txtyxshengyukou.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtyxshengyukou.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtyxshengyukou.setPrecision(10);		
        this.txtyxshengyukou.setRequired(false);
        // txtgdshengyukou		
        this.txtgdshengyukou.setVisible(true);		
        this.txtgdshengyukou.setHorizontalAlignment(2);		
        this.txtgdshengyukou.setDataType(1);		
        this.txtgdshengyukou.setSupportedEmpty(true);		
        this.txtgdshengyukou.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtgdshengyukou.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtgdshengyukou.setPrecision(10);		
        this.txtgdshengyukou.setRequired(false);
        // txtyijiqudao		
        this.txtyijiqudao.setVisible(true);		
        this.txtyijiqudao.setHorizontalAlignment(2);		
        this.txtyijiqudao.setMaxLength(100);		
        this.txtyijiqudao.setRequired(false);
        // txterjiqudao		
        this.txterjiqudao.setVisible(true);		
        this.txterjiqudao.setHorizontalAlignment(2);		
        this.txterjiqudao.setMaxLength(100);		
        this.txterjiqudao.setRequired(false);
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {txtyijikou,txterjikou,txtyxkou,txtgdkou,txtyxshengyukou,txtgdshengyukou,txtyijiqudao,txterjiqudao}));
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
        this.setBounds(new Rectangle(0, 0, 1013, 125));
        this.setLayout(null);
        kDLabelContainer1.setBounds(new Rectangle(341, 82, 270, 19));
        this.add(kDLabelContainer1, null);
        kDLabelContainer2.setBounds(new Rectangle(341, 58, 270, 19));
        this.add(kDLabelContainer2, null);
        kDLabelContainer3.setBounds(new Rectangle(672, 82, 270, 19));
        this.add(kDLabelContainer3, null);
        kDLabelContainer4.setBounds(new Rectangle(10, 82, 270, 19));
        this.add(kDLabelContainer4, null);
        contyijikou.setBounds(new Rectangle(10, 10, 270, 19));
        this.add(contyijikou, null);
        conterjikou.setBounds(new Rectangle(341, 10, 270, 19));
        this.add(conterjikou, null);
        contyxkou.setBounds(new Rectangle(672, 10, 270, 19));
        this.add(contyxkou, null);
        contgdkou.setBounds(new Rectangle(10, 34, 270, 19));
        this.add(contgdkou, null);
        contyxshengyukou.setBounds(new Rectangle(341, 34, 270, 19));
        this.add(contyxshengyukou, null);
        contgdshengyukou.setBounds(new Rectangle(672, 34, 270, 19));
        this.add(contgdshengyukou, null);
        contyijiqudao.setBounds(new Rectangle(10, 58, 270, 19));
        this.add(contyijiqudao, null);
        conterjiqudao.setBounds(new Rectangle(672, 58, 270, 19));
        this.add(conterjiqudao, null);
        //kDLabelContainer1
        kDLabelContainer1.setBoundEditor(txtNumber);
        //kDLabelContainer2
        kDLabelContainer2.setBoundEditor(txtName);
        //kDLabelContainer3
        kDLabelContainer3.setBoundEditor(txtSimpleName);
        //kDLabelContainer4
        kDLabelContainer4.setBoundEditor(txtDescription);
        //contyijikou
        contyijikou.setBoundEditor(txtyijikou);
        //conterjikou
        conterjikou.setBoundEditor(txterjikou);
        //contyxkou
        contyxkou.setBoundEditor(txtyxkou);
        //contgdkou
        contgdkou.setBoundEditor(txtgdkou);
        //contyxshengyukou
        contyxshengyukou.setBoundEditor(txtyxshengyukou);
        //contgdshengyukou
        contgdshengyukou.setBoundEditor(txtgdshengyukou);
        //contyijiqudao
        contyijiqudao.setBoundEditor(txtyijiqudao);
        //conterjiqudao
        conterjiqudao.setBoundEditor(txterjiqudao);

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
		dataBinder.registerBinding("yijikou", java.math.BigDecimal.class, this.txtyijikou, "value");
		dataBinder.registerBinding("erjikou", java.math.BigDecimal.class, this.txterjikou, "value");
		dataBinder.registerBinding("yxkou", java.math.BigDecimal.class, this.txtyxkou, "value");
		dataBinder.registerBinding("gdkou", java.math.BigDecimal.class, this.txtgdkou, "value");
		dataBinder.registerBinding("yxshengyukou", java.math.BigDecimal.class, this.txtyxshengyukou, "value");
		dataBinder.registerBinding("gdshengyukou", java.math.BigDecimal.class, this.txtgdshengyukou, "value");
		dataBinder.registerBinding("yijiqudao", String.class, this.txtyijiqudao, "text");
		dataBinder.registerBinding("erjiqudao", String.class, this.txterjiqudao, "text");		
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
	    return "com.kingdee.eas.mw.pay.app.DocHISBiLiEditUIHandler";
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
        this.txtyijikou.requestFocusInWindow();
    }

	
	

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject)
    {
        IObjectValue ov = dataObject;        	    	
        super.setDataObject(ov);
        this.editData = (com.kingdee.eas.mw.pay.DocHISBiLiInfo)ov;
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
		getValidateHelper().registerBindProperty("yijikou", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("erjikou", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("yxkou", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("gdkou", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("yxshengyukou", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("gdshengyukou", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("yijiqudao", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("erjiqudao", ValidateHelper.ON_SAVE);    		
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
        sic.add(new SelectorItemInfo("yijikou"));
        sic.add(new SelectorItemInfo("erjikou"));
        sic.add(new SelectorItemInfo("yxkou"));
        sic.add(new SelectorItemInfo("gdkou"));
        sic.add(new SelectorItemInfo("yxshengyukou"));
        sic.add(new SelectorItemInfo("gdshengyukou"));
        sic.add(new SelectorItemInfo("yijiqudao"));
        sic.add(new SelectorItemInfo("erjiqudao"));
        return sic;
    }        

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.mw.pay.client", "DocHISBiLiEditUI");
    }

    /**
     * output getEditUIName method
     */
    protected String getEditUIName()
    {
        return com.kingdee.eas.mw.pay.client.DocHISBiLiEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.mw.pay.DocHISBiLiFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.mw.pay.DocHISBiLiInfo objectValue = new com.kingdee.eas.mw.pay.DocHISBiLiInfo();
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