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
public abstract class AbstractDocStageEditUI extends com.kingdee.eas.framework.client.EditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractDocStageEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer2;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer3;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer4;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcity;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbusinessDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conttype;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contclinicNumber;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contclinicName;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbrginAmount;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contendAmount;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contpro;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbaseAchieve;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contincludeBZ;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contempNumber;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contempName;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkisAllAchieve;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcalType;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox txtName;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtSimpleName;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox txtDescription;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcity;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtbusinessDate;
    protected com.kingdee.bos.ctrl.swing.KDTextField txttype;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtclinicNumber;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtclinicName;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtbrginAmount;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtendAmount;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtpro;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtbaseAchieve;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtincludeBZ;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtempNumber;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtempName;
    protected com.kingdee.bos.ctrl.swing.KDComboBox calType;
    protected com.kingdee.eas.mw.pay.DocStageInfo editData = null;
    /**
     * output class constructor
     */
    public AbstractDocStageEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractDocStageEditUI.class.getName());
        this.setUITitle(resHelper.getString("this.title"));
        this.kDLabelContainer1 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer2 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer3 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer4 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcity = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbusinessDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conttype = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contclinicNumber = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contclinicName = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbrginAmount = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contendAmount = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contpro = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbaseAchieve = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contincludeBZ = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contempNumber = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contempName = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.chkisAllAchieve = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.contcalType = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtName = new com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox();
        this.txtSimpleName = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtDescription = new com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox();
        this.prmtcity = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtbusinessDate = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txttype = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtclinicNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtclinicName = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtbrginAmount = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtendAmount = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtpro = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtbaseAchieve = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtincludeBZ = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtempNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtempName = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.calType = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.kDLabelContainer1.setName("kDLabelContainer1");
        this.kDLabelContainer2.setName("kDLabelContainer2");
        this.kDLabelContainer3.setName("kDLabelContainer3");
        this.kDLabelContainer4.setName("kDLabelContainer4");
        this.contcity.setName("contcity");
        this.contbusinessDate.setName("contbusinessDate");
        this.conttype.setName("conttype");
        this.contclinicNumber.setName("contclinicNumber");
        this.contclinicName.setName("contclinicName");
        this.contbrginAmount.setName("contbrginAmount");
        this.contendAmount.setName("contendAmount");
        this.contpro.setName("contpro");
        this.contbaseAchieve.setName("contbaseAchieve");
        this.contincludeBZ.setName("contincludeBZ");
        this.contempNumber.setName("contempNumber");
        this.contempName.setName("contempName");
        this.chkisAllAchieve.setName("chkisAllAchieve");
        this.contcalType.setName("contcalType");
        this.txtNumber.setName("txtNumber");
        this.txtName.setName("txtName");
        this.txtSimpleName.setName("txtSimpleName");
        this.txtDescription.setName("txtDescription");
        this.prmtcity.setName("prmtcity");
        this.txtbusinessDate.setName("txtbusinessDate");
        this.txttype.setName("txttype");
        this.txtclinicNumber.setName("txtclinicNumber");
        this.txtclinicName.setName("txtclinicName");
        this.txtbrginAmount.setName("txtbrginAmount");
        this.txtendAmount.setName("txtendAmount");
        this.txtpro.setName("txtpro");
        this.txtbaseAchieve.setName("txtbaseAchieve");
        this.txtincludeBZ.setName("txtincludeBZ");
        this.txtempNumber.setName("txtempNumber");
        this.txtempName.setName("txtempName");
        this.calType.setName("calType");
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
        // contbusinessDate		
        this.contbusinessDate.setBoundLabelText(resHelper.getString("contbusinessDate.boundLabelText"));		
        this.contbusinessDate.setBoundLabelLength(100);		
        this.contbusinessDate.setBoundLabelUnderline(true);		
        this.contbusinessDate.setVisible(true);
        // conttype		
        this.conttype.setBoundLabelText(resHelper.getString("conttype.boundLabelText"));		
        this.conttype.setBoundLabelLength(100);		
        this.conttype.setBoundLabelUnderline(true);		
        this.conttype.setVisible(true);
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
        // contbrginAmount		
        this.contbrginAmount.setBoundLabelText(resHelper.getString("contbrginAmount.boundLabelText"));		
        this.contbrginAmount.setBoundLabelLength(100);		
        this.contbrginAmount.setBoundLabelUnderline(true);		
        this.contbrginAmount.setVisible(true);
        // contendAmount		
        this.contendAmount.setBoundLabelText(resHelper.getString("contendAmount.boundLabelText"));		
        this.contendAmount.setBoundLabelLength(100);		
        this.contendAmount.setBoundLabelUnderline(true);		
        this.contendAmount.setVisible(true);
        // contpro		
        this.contpro.setBoundLabelText(resHelper.getString("contpro.boundLabelText"));		
        this.contpro.setBoundLabelLength(100);		
        this.contpro.setBoundLabelUnderline(true);		
        this.contpro.setVisible(true);
        // contbaseAchieve		
        this.contbaseAchieve.setBoundLabelText(resHelper.getString("contbaseAchieve.boundLabelText"));		
        this.contbaseAchieve.setBoundLabelLength(100);		
        this.contbaseAchieve.setBoundLabelUnderline(true);		
        this.contbaseAchieve.setVisible(true);
        // contincludeBZ		
        this.contincludeBZ.setBoundLabelText(resHelper.getString("contincludeBZ.boundLabelText"));		
        this.contincludeBZ.setBoundLabelLength(100);		
        this.contincludeBZ.setBoundLabelUnderline(true);		
        this.contincludeBZ.setVisible(true);
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
        // chkisAllAchieve		
        this.chkisAllAchieve.setText(resHelper.getString("chkisAllAchieve.text"));		
        this.chkisAllAchieve.setVisible(true);		
        this.chkisAllAchieve.setHorizontalAlignment(2);
        // contcalType		
        this.contcalType.setBoundLabelText(resHelper.getString("contcalType.boundLabelText"));		
        this.contcalType.setBoundLabelLength(100);		
        this.contcalType.setBoundLabelUnderline(true);		
        this.contcalType.setVisible(true);
        // txtNumber		
        this.txtNumber.setMaxLength(80);
        // txtName
        // txtSimpleName		
        this.txtSimpleName.setMaxLength(80);
        // txtDescription
        // prmtcity		
        this.prmtcity.setQueryInfo("com.kingdee.eas.basedata.org.app.AdminItemQuery");		
        this.prmtcity.setVisible(true);		
        this.prmtcity.setEditable(true);		
        this.prmtcity.setDisplayFormat("$name$");		
        this.prmtcity.setEditFormat("$number$");		
        this.prmtcity.setCommitFormat("$number$");		
        this.prmtcity.setRequired(false);
        // txtbusinessDate		
        this.txtbusinessDate.setVisible(true);		
        this.txtbusinessDate.setHorizontalAlignment(2);		
        this.txtbusinessDate.setMaxLength(100);		
        this.txtbusinessDate.setRequired(false);
        // txttype		
        this.txttype.setVisible(true);		
        this.txttype.setHorizontalAlignment(2);		
        this.txttype.setMaxLength(100);		
        this.txttype.setRequired(false);
        // txtclinicNumber		
        this.txtclinicNumber.setVisible(true);		
        this.txtclinicNumber.setHorizontalAlignment(2);		
        this.txtclinicNumber.setMaxLength(100);		
        this.txtclinicNumber.setRequired(false);
        // txtclinicName		
        this.txtclinicName.setVisible(true);		
        this.txtclinicName.setHorizontalAlignment(2);		
        this.txtclinicName.setMaxLength(200);		
        this.txtclinicName.setRequired(false);
        // txtbrginAmount		
        this.txtbrginAmount.setVisible(true);		
        this.txtbrginAmount.setHorizontalAlignment(2);		
        this.txtbrginAmount.setDataType(1);		
        this.txtbrginAmount.setSupportedEmpty(true);		
        this.txtbrginAmount.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtbrginAmount.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtbrginAmount.setPrecision(10);		
        this.txtbrginAmount.setRequired(false);
        // txtendAmount		
        this.txtendAmount.setVisible(true);		
        this.txtendAmount.setHorizontalAlignment(2);		
        this.txtendAmount.setDataType(1);		
        this.txtendAmount.setSupportedEmpty(true);		
        this.txtendAmount.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtendAmount.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtendAmount.setPrecision(10);		
        this.txtendAmount.setRequired(false);
        // txtpro		
        this.txtpro.setVisible(true);		
        this.txtpro.setHorizontalAlignment(2);		
        this.txtpro.setDataType(1);		
        this.txtpro.setSupportedEmpty(true);		
        this.txtpro.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtpro.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtpro.setPrecision(10);		
        this.txtpro.setRequired(false);
        // txtbaseAchieve		
        this.txtbaseAchieve.setVisible(true);		
        this.txtbaseAchieve.setHorizontalAlignment(2);		
        this.txtbaseAchieve.setDataType(1);		
        this.txtbaseAchieve.setSupportedEmpty(true);		
        this.txtbaseAchieve.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtbaseAchieve.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtbaseAchieve.setPrecision(10);		
        this.txtbaseAchieve.setRequired(false);
        // txtincludeBZ		
        this.txtincludeBZ.setVisible(true);		
        this.txtincludeBZ.setHorizontalAlignment(2);		
        this.txtincludeBZ.setMaxLength(100);		
        this.txtincludeBZ.setRequired(false);
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
        // calType		
        this.calType.setVisible(true);		
        this.calType.addItems(EnumUtils.getEnumList("com.kingdee.eas.mw.pay.app.CalculationType").toArray());		
        this.calType.setRequired(false);
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {prmtcity,txtbusinessDate,txttype,txtclinicNumber,txtclinicName,txtbrginAmount,txtendAmount,txtpro,txtbaseAchieve,txtincludeBZ,txtempNumber,txtempName,chkisAllAchieve,calType}));
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
        kDLabelContainer1.setBounds(new Rectangle(672, 82, 270, 19));
        this.add(kDLabelContainer1, null);
        kDLabelContainer2.setBounds(new Rectangle(341, 106, 270, 19));
        this.add(kDLabelContainer2, null);
        kDLabelContainer3.setBounds(new Rectangle(672, 106, 270, 19));
        this.add(kDLabelContainer3, null);
        kDLabelContainer4.setBounds(new Rectangle(10, 130, 270, 19));
        this.add(kDLabelContainer4, null);
        contcity.setBounds(new Rectangle(10, 10, 270, 19));
        this.add(contcity, null);
        contbusinessDate.setBounds(new Rectangle(341, 10, 270, 19));
        this.add(contbusinessDate, null);
        conttype.setBounds(new Rectangle(672, 10, 270, 19));
        this.add(conttype, null);
        contclinicNumber.setBounds(new Rectangle(10, 34, 270, 19));
        this.add(contclinicNumber, null);
        contclinicName.setBounds(new Rectangle(341, 34, 270, 19));
        this.add(contclinicName, null);
        contbrginAmount.setBounds(new Rectangle(341, 58, 270, 19));
        this.add(contbrginAmount, null);
        contendAmount.setBounds(new Rectangle(672, 58, 270, 19));
        this.add(contendAmount, null);
        contpro.setBounds(new Rectangle(10, 82, 270, 19));
        this.add(contpro, null);
        contbaseAchieve.setBounds(new Rectangle(341, 82, 270, 19));
        this.add(contbaseAchieve, null);
        contincludeBZ.setBounds(new Rectangle(10, 106, 270, 19));
        this.add(contincludeBZ, null);
        contempNumber.setBounds(new Rectangle(10, 58, 270, 19));
        this.add(contempNumber, null);
        contempName.setBounds(new Rectangle(672, 34, 270, 19));
        this.add(contempName, null);
        chkisAllAchieve.setBounds(new Rectangle(341, 130, 270, 19));
        this.add(chkisAllAchieve, null);
        contcalType.setBounds(new Rectangle(672, 130, 270, 19));
        this.add(contcalType, null);
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
        //contbusinessDate
        contbusinessDate.setBoundEditor(txtbusinessDate);
        //conttype
        conttype.setBoundEditor(txttype);
        //contclinicNumber
        contclinicNumber.setBoundEditor(txtclinicNumber);
        //contclinicName
        contclinicName.setBoundEditor(txtclinicName);
        //contbrginAmount
        contbrginAmount.setBoundEditor(txtbrginAmount);
        //contendAmount
        contendAmount.setBoundEditor(txtendAmount);
        //contpro
        contpro.setBoundEditor(txtpro);
        //contbaseAchieve
        contbaseAchieve.setBoundEditor(txtbaseAchieve);
        //contincludeBZ
        contincludeBZ.setBoundEditor(txtincludeBZ);
        //contempNumber
        contempNumber.setBoundEditor(txtempNumber);
        //contempName
        contempName.setBoundEditor(txtempName);
        //contcalType
        contcalType.setBoundEditor(calType);

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
		dataBinder.registerBinding("isAllAchieve", boolean.class, this.chkisAllAchieve, "selected");
		dataBinder.registerBinding("number", String.class, this.txtNumber, "text");
		dataBinder.registerBinding("name", String.class, this.txtName, "_multiLangItem");
		dataBinder.registerBinding("simpleName", String.class, this.txtSimpleName, "text");
		dataBinder.registerBinding("description", String.class, this.txtDescription, "_multiLangItem");
		dataBinder.registerBinding("city", com.kingdee.eas.basedata.org.AdminOrgUnitInfo.class, this.prmtcity, "data");
		dataBinder.registerBinding("businessDate", String.class, this.txtbusinessDate, "text");
		dataBinder.registerBinding("type", String.class, this.txttype, "text");
		dataBinder.registerBinding("clinicNumber", String.class, this.txtclinicNumber, "text");
		dataBinder.registerBinding("clinicName", String.class, this.txtclinicName, "text");
		dataBinder.registerBinding("brginAmount", java.math.BigDecimal.class, this.txtbrginAmount, "value");
		dataBinder.registerBinding("endAmount", java.math.BigDecimal.class, this.txtendAmount, "value");
		dataBinder.registerBinding("pro", java.math.BigDecimal.class, this.txtpro, "value");
		dataBinder.registerBinding("baseAchieve", java.math.BigDecimal.class, this.txtbaseAchieve, "value");
		dataBinder.registerBinding("includeBZ", String.class, this.txtincludeBZ, "text");
		dataBinder.registerBinding("empNumber", String.class, this.txtempNumber, "text");
		dataBinder.registerBinding("empName", String.class, this.txtempName, "text");
		dataBinder.registerBinding("calType", com.kingdee.eas.mw.pay.app.CalculationType.class, this.calType, "selectedItem");		
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
	    return "com.kingdee.eas.mw.pay.app.DocStageEditUIHandler";
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
        this.editData = (com.kingdee.eas.mw.pay.DocStageInfo)ov;
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
	 * ????????��??
	 */
	protected void registerValidator() {
    	getValidateHelper().setCustomValidator( getValidator() );
		getValidateHelper().registerBindProperty("isAllAchieve", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("number", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("name", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("simpleName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("description", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("city", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("businessDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("type", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("clinicNumber", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("clinicName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("brginAmount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("endAmount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("pro", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("baseAchieve", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("includeBZ", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("empNumber", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("empName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("calType", ValidateHelper.ON_SAVE);    		
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
        sic.add(new SelectorItemInfo("isAllAchieve"));
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
        sic.add(new SelectorItemInfo("businessDate"));
        sic.add(new SelectorItemInfo("type"));
        sic.add(new SelectorItemInfo("clinicNumber"));
        sic.add(new SelectorItemInfo("clinicName"));
        sic.add(new SelectorItemInfo("brginAmount"));
        sic.add(new SelectorItemInfo("endAmount"));
        sic.add(new SelectorItemInfo("pro"));
        sic.add(new SelectorItemInfo("baseAchieve"));
        sic.add(new SelectorItemInfo("includeBZ"));
        sic.add(new SelectorItemInfo("empNumber"));
        sic.add(new SelectorItemInfo("empName"));
        sic.add(new SelectorItemInfo("calType"));
        return sic;
    }        

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.mw.pay.client", "DocStageEditUI");
    }

    /**
     * output getEditUIName method
     */
    protected String getEditUIName()
    {
        return com.kingdee.eas.mw.pay.client.DocStageEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.mw.pay.DocStageFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.mw.pay.DocStageInfo objectValue = new com.kingdee.eas.mw.pay.DocStageInfo();
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
		vo.put("calType","CalStageAchieve");
        
    }        
	protected void setFieldsNull(com.kingdee.bos.dao.AbstractObjectValue arg0) {
		super.setFieldsNull(arg0);
		arg0.put("number",null);
	}

}