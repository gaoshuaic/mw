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
public abstract class AbstractScalingCountSumEditUI extends com.kingdee.eas.framework.client.EditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractScalingCountSumEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer2;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer3;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer4;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcityNumber;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcityName;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contclinicNumber;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contclinicName;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contempNumber;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contempName;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbusinessDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contpost;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contpostName;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contxtCount;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contimpCount;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contallCount;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conttype;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox txtName;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtSimpleName;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox txtDescription;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtcityNumber;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtcityName;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtclinicNumber;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtclinicName;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtempNumber;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtempName;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtbusinessDate;
    protected com.kingdee.bos.ctrl.swing.KDComboBox post;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtpostName;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtxtCount;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtimpCount;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtallCount;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmttype;
    protected com.kingdee.eas.mw.pay.ScalingCountSumInfo editData = null;
    /**
     * output class constructor
     */
    public AbstractScalingCountSumEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractScalingCountSumEditUI.class.getName());
        this.setUITitle(resHelper.getString("this.title"));
        this.kDLabelContainer1 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer2 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer3 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer4 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcityNumber = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcityName = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contclinicNumber = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contclinicName = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contempNumber = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contempName = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbusinessDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contpost = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contpostName = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contxtCount = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contimpCount = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contallCount = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conttype = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtName = new com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox();
        this.txtSimpleName = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtDescription = new com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox();
        this.txtcityNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtcityName = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtclinicNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtclinicName = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtempNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtempName = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtbusinessDate = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.post = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.txtpostName = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtxtCount = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtimpCount = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtallCount = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.prmttype = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDLabelContainer1.setName("kDLabelContainer1");
        this.kDLabelContainer2.setName("kDLabelContainer2");
        this.kDLabelContainer3.setName("kDLabelContainer3");
        this.kDLabelContainer4.setName("kDLabelContainer4");
        this.contcityNumber.setName("contcityNumber");
        this.contcityName.setName("contcityName");
        this.contclinicNumber.setName("contclinicNumber");
        this.contclinicName.setName("contclinicName");
        this.contempNumber.setName("contempNumber");
        this.contempName.setName("contempName");
        this.contbusinessDate.setName("contbusinessDate");
        this.contpost.setName("contpost");
        this.contpostName.setName("contpostName");
        this.contxtCount.setName("contxtCount");
        this.contimpCount.setName("contimpCount");
        this.contallCount.setName("contallCount");
        this.conttype.setName("conttype");
        this.txtNumber.setName("txtNumber");
        this.txtName.setName("txtName");
        this.txtSimpleName.setName("txtSimpleName");
        this.txtDescription.setName("txtDescription");
        this.txtcityNumber.setName("txtcityNumber");
        this.txtcityName.setName("txtcityName");
        this.txtclinicNumber.setName("txtclinicNumber");
        this.txtclinicName.setName("txtclinicName");
        this.txtempNumber.setName("txtempNumber");
        this.txtempName.setName("txtempName");
        this.txtbusinessDate.setName("txtbusinessDate");
        this.post.setName("post");
        this.txtpostName.setName("txtpostName");
        this.txtxtCount.setName("txtxtCount");
        this.txtimpCount.setName("txtimpCount");
        this.txtallCount.setName("txtallCount");
        this.prmttype.setName("prmttype");
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
        // contbusinessDate		
        this.contbusinessDate.setBoundLabelText(resHelper.getString("contbusinessDate.boundLabelText"));		
        this.contbusinessDate.setBoundLabelLength(100);		
        this.contbusinessDate.setBoundLabelUnderline(true);		
        this.contbusinessDate.setVisible(true);
        // contpost		
        this.contpost.setBoundLabelText(resHelper.getString("contpost.boundLabelText"));		
        this.contpost.setBoundLabelLength(100);		
        this.contpost.setBoundLabelUnderline(true);		
        this.contpost.setVisible(true);
        // contpostName		
        this.contpostName.setBoundLabelText(resHelper.getString("contpostName.boundLabelText"));		
        this.contpostName.setBoundLabelLength(100);		
        this.contpostName.setBoundLabelUnderline(true);		
        this.contpostName.setVisible(true);
        // contxtCount		
        this.contxtCount.setBoundLabelText(resHelper.getString("contxtCount.boundLabelText"));		
        this.contxtCount.setBoundLabelLength(100);		
        this.contxtCount.setBoundLabelUnderline(true);		
        this.contxtCount.setVisible(true);
        // contimpCount		
        this.contimpCount.setBoundLabelText(resHelper.getString("contimpCount.boundLabelText"));		
        this.contimpCount.setBoundLabelLength(100);		
        this.contimpCount.setBoundLabelUnderline(true);		
        this.contimpCount.setVisible(true);
        // contallCount		
        this.contallCount.setBoundLabelText(resHelper.getString("contallCount.boundLabelText"));		
        this.contallCount.setBoundLabelLength(100);		
        this.contallCount.setBoundLabelUnderline(true);		
        this.contallCount.setVisible(true);
        // conttype		
        this.conttype.setBoundLabelText(resHelper.getString("conttype.boundLabelText"));		
        this.conttype.setBoundLabelLength(100);		
        this.conttype.setBoundLabelUnderline(true);		
        this.conttype.setVisible(true);
        // txtNumber		
        this.txtNumber.setMaxLength(80);
        // txtName
        // txtSimpleName		
        this.txtSimpleName.setMaxLength(80);
        // txtDescription
        // txtcityNumber		
        this.txtcityNumber.setVisible(true);		
        this.txtcityNumber.setHorizontalAlignment(2);		
        this.txtcityNumber.setMaxLength(80);		
        this.txtcityNumber.setRequired(false);
        // txtcityName		
        this.txtcityName.setVisible(true);		
        this.txtcityName.setHorizontalAlignment(2);		
        this.txtcityName.setMaxLength(100);		
        this.txtcityName.setRequired(false);
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
        // txtbusinessDate		
        this.txtbusinessDate.setVisible(true);		
        this.txtbusinessDate.setHorizontalAlignment(2);		
        this.txtbusinessDate.setMaxLength(100);		
        this.txtbusinessDate.setRequired(false);
        // post		
        this.post.setVisible(true);		
        this.post.addItems(EnumUtils.getEnumList("com.kingdee.eas.mw.pay.app.PaypostType").toArray());		
        this.post.setRequired(false);
        // txtpostName		
        this.txtpostName.setVisible(true);		
        this.txtpostName.setHorizontalAlignment(2);		
        this.txtpostName.setMaxLength(100);		
        this.txtpostName.setRequired(false);
        // txtxtCount		
        this.txtxtCount.setVisible(true);		
        this.txtxtCount.setHorizontalAlignment(2);		
        this.txtxtCount.setDataType(1);		
        this.txtxtCount.setSupportedEmpty(true);		
        this.txtxtCount.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtxtCount.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtxtCount.setPrecision(10);		
        this.txtxtCount.setRequired(false);
        // txtimpCount		
        this.txtimpCount.setVisible(true);		
        this.txtimpCount.setHorizontalAlignment(2);		
        this.txtimpCount.setDataType(1);		
        this.txtimpCount.setSupportedEmpty(true);		
        this.txtimpCount.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtimpCount.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtimpCount.setPrecision(10);		
        this.txtimpCount.setRequired(false);
        // txtallCount		
        this.txtallCount.setVisible(true);		
        this.txtallCount.setHorizontalAlignment(2);		
        this.txtallCount.setDataType(1);		
        this.txtallCount.setSupportedEmpty(true);		
        this.txtallCount.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtallCount.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtallCount.setPrecision(10);		
        this.txtallCount.setRequired(false);
        // prmttype		
        this.prmttype.setQueryInfo("com.kingdee.eas.mw.pay.app.ScalingTypeQuery");		
        this.prmttype.setVisible(true);		
        this.prmttype.setEditable(true);		
        this.prmttype.setDisplayFormat("$name$");		
        this.prmttype.setEditFormat("$number$");		
        this.prmttype.setCommitFormat("$number$");		
        this.prmttype.setRequired(false);
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {txtcityNumber,txtcityName,txtclinicNumber,txtclinicName,txtempNumber,txtempName,txtbusinessDate,post,txtpostName,txtxtCount,txtimpCount,txtallCount,prmttype}));
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
        this.setBounds(new Rectangle(0, 0, 1013, 173));
        this.setLayout(null);
        kDLabelContainer1.setBounds(new Rectangle(341, 106, 270, 19));
        this.add(kDLabelContainer1, null);
        kDLabelContainer2.setBounds(new Rectangle(672, 106, 270, 19));
        this.add(kDLabelContainer2, null);
        kDLabelContainer3.setBounds(new Rectangle(10, 130, 270, 19));
        this.add(kDLabelContainer3, null);
        kDLabelContainer4.setBounds(new Rectangle(341, 130, 270, 19));
        this.add(kDLabelContainer4, null);
        contcityNumber.setBounds(new Rectangle(10, 10, 270, 19));
        this.add(contcityNumber, null);
        contcityName.setBounds(new Rectangle(341, 10, 270, 19));
        this.add(contcityName, null);
        contclinicNumber.setBounds(new Rectangle(672, 10, 270, 19));
        this.add(contclinicNumber, null);
        contclinicName.setBounds(new Rectangle(10, 34, 270, 19));
        this.add(contclinicName, null);
        contempNumber.setBounds(new Rectangle(341, 34, 270, 19));
        this.add(contempNumber, null);
        contempName.setBounds(new Rectangle(672, 34, 270, 19));
        this.add(contempName, null);
        contbusinessDate.setBounds(new Rectangle(10, 58, 270, 19));
        this.add(contbusinessDate, null);
        contpost.setBounds(new Rectangle(672, 58, 270, 19));
        this.add(contpost, null);
        contpostName.setBounds(new Rectangle(10, 82, 270, 19));
        this.add(contpostName, null);
        contxtCount.setBounds(new Rectangle(341, 82, 270, 19));
        this.add(contxtCount, null);
        contimpCount.setBounds(new Rectangle(672, 82, 270, 19));
        this.add(contimpCount, null);
        contallCount.setBounds(new Rectangle(10, 106, 270, 19));
        this.add(contallCount, null);
        conttype.setBounds(new Rectangle(341, 58, 270, 19));
        this.add(conttype, null);
        //kDLabelContainer1
        kDLabelContainer1.setBoundEditor(txtNumber);
        //kDLabelContainer2
        kDLabelContainer2.setBoundEditor(txtName);
        //kDLabelContainer3
        kDLabelContainer3.setBoundEditor(txtSimpleName);
        //kDLabelContainer4
        kDLabelContainer4.setBoundEditor(txtDescription);
        //contcityNumber
        contcityNumber.setBoundEditor(txtcityNumber);
        //contcityName
        contcityName.setBoundEditor(txtcityName);
        //contclinicNumber
        contclinicNumber.setBoundEditor(txtclinicNumber);
        //contclinicName
        contclinicName.setBoundEditor(txtclinicName);
        //contempNumber
        contempNumber.setBoundEditor(txtempNumber);
        //contempName
        contempName.setBoundEditor(txtempName);
        //contbusinessDate
        contbusinessDate.setBoundEditor(txtbusinessDate);
        //contpost
        contpost.setBoundEditor(post);
        //contpostName
        contpostName.setBoundEditor(txtpostName);
        //contxtCount
        contxtCount.setBoundEditor(txtxtCount);
        //contimpCount
        contimpCount.setBoundEditor(txtimpCount);
        //contallCount
        contallCount.setBoundEditor(txtallCount);
        //conttype
        conttype.setBoundEditor(prmttype);

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
		dataBinder.registerBinding("cityNumber", String.class, this.txtcityNumber, "text");
		dataBinder.registerBinding("cityName", String.class, this.txtcityName, "text");
		dataBinder.registerBinding("clinicNumber", String.class, this.txtclinicNumber, "text");
		dataBinder.registerBinding("clinicName", String.class, this.txtclinicName, "text");
		dataBinder.registerBinding("empNumber", String.class, this.txtempNumber, "text");
		dataBinder.registerBinding("empName", String.class, this.txtempName, "text");
		dataBinder.registerBinding("businessDate", String.class, this.txtbusinessDate, "text");
		dataBinder.registerBinding("post", com.kingdee.eas.mw.pay.app.PaypostType.class, this.post, "selectedItem");
		dataBinder.registerBinding("postName", String.class, this.txtpostName, "text");
		dataBinder.registerBinding("xtCount", java.math.BigDecimal.class, this.txtxtCount, "value");
		dataBinder.registerBinding("impCount", java.math.BigDecimal.class, this.txtimpCount, "value");
		dataBinder.registerBinding("allCount", java.math.BigDecimal.class, this.txtallCount, "value");
		dataBinder.registerBinding("type", com.kingdee.eas.mw.pay.ScalingTypeInfo.class, this.prmttype, "data");		
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
	    return "com.kingdee.eas.mw.pay.app.ScalingCountSumEditUIHandler";
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
        this.txtcityNumber.requestFocusInWindow();
    }

	
	

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject)
    {
        IObjectValue ov = dataObject;        	    	
        super.setDataObject(ov);
        this.editData = (com.kingdee.eas.mw.pay.ScalingCountSumInfo)ov;
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
	 * ????????????
	 */
	protected void registerValidator() {
    	getValidateHelper().setCustomValidator( getValidator() );
		getValidateHelper().registerBindProperty("number", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("name", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("simpleName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("description", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("cityNumber", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("cityName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("clinicNumber", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("clinicName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("empNumber", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("empName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("businessDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("post", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("postName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("xtCount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("impCount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("allCount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("type", ValidateHelper.ON_SAVE);    		
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
        sic.add(new SelectorItemInfo("cityNumber"));
        sic.add(new SelectorItemInfo("cityName"));
        sic.add(new SelectorItemInfo("clinicNumber"));
        sic.add(new SelectorItemInfo("clinicName"));
        sic.add(new SelectorItemInfo("empNumber"));
        sic.add(new SelectorItemInfo("empName"));
        sic.add(new SelectorItemInfo("businessDate"));
        sic.add(new SelectorItemInfo("post"));
        sic.add(new SelectorItemInfo("postName"));
        sic.add(new SelectorItemInfo("xtCount"));
        sic.add(new SelectorItemInfo("impCount"));
        sic.add(new SelectorItemInfo("allCount"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("type.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("type.id"));
        	sic.add(new SelectorItemInfo("type.number"));
        	sic.add(new SelectorItemInfo("type.name"));
		}
        return sic;
    }        

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.mw.pay.client", "ScalingCountSumEditUI");
    }

    /**
     * output getEditUIName method
     */
    protected String getEditUIName()
    {
        return com.kingdee.eas.mw.pay.client.ScalingCountSumEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.mw.pay.ScalingCountSumFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.mw.pay.ScalingCountSumInfo objectValue = new com.kingdee.eas.mw.pay.ScalingCountSumInfo();
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
		vo.put("post","KF");
        
    }        
	protected void setFieldsNull(com.kingdee.bos.dao.AbstractObjectValue arg0) {
		super.setFieldsNull(arg0);
		arg0.put("number",null);
	}

}