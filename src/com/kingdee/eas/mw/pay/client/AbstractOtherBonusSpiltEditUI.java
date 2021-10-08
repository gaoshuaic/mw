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
public abstract class AbstractOtherBonusSpiltEditUI extends com.kingdee.eas.framework.client.EditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractOtherBonusSpiltEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer2;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer3;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer4;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contpostName;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contempNumber;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contempName;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contclinicNumber;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contclinicName;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contpostNumber;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contclinic;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcity;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbusinessdate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcardSellBonus;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contotherBounsOne;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contotherBounsTwo;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contdocAssBouns;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contshopHelp;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contgoodBouns;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contmarktBouns;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conttoDocBouns;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contdocKeepBouns;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contdocKeepType;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contkefuBouns;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conthuliBouns;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contconvertBouns;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contmonthBase;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbkCount;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contqkCount;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contholdAmount;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contxrayallow;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contnianzhongmoney;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contjidumoney;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contnianzhongfentan;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contjidufentan;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox txtName;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtSimpleName;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox txtDescription;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtpostName;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtempNumber;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtempName;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtclinicNumber;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtclinicName;
    protected com.kingdee.bos.ctrl.swing.KDComboBox postNumber;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtclinic;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcity;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtbusinessdate;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtcardSellBonus;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtotherBounsOne;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtotherBounsTwo;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtdocAssBouns;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtshopHelp;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtgoodBouns;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtmarktBouns;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txttoDocBouns;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtdocKeepBouns;
    protected com.kingdee.bos.ctrl.swing.KDComboBox docKeepType;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtkefuBouns;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txthuliBouns;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtconvertBouns;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtmonthBase;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtbkCount;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtqkCount;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtholdAmount;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtxrayallow;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtnianzhongmoney;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtjidumoney;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtnianzhongfentan;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtjidufentan;
    protected com.kingdee.eas.mw.pay.OtherBonusSpiltInfo editData = null;
    /**
     * output class constructor
     */
    public AbstractOtherBonusSpiltEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractOtherBonusSpiltEditUI.class.getName());
        this.setUITitle(resHelper.getString("this.title"));
        this.kDLabelContainer1 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer2 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer3 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer4 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contpostName = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contempNumber = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contempName = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contclinicNumber = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contclinicName = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contpostNumber = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contclinic = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcity = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbusinessdate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcardSellBonus = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contotherBounsOne = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contotherBounsTwo = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contdocAssBouns = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contshopHelp = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contgoodBouns = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contmarktBouns = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conttoDocBouns = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contdocKeepBouns = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contdocKeepType = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contkefuBouns = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conthuliBouns = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contconvertBouns = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contmonthBase = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbkCount = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contqkCount = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contholdAmount = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contxrayallow = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contnianzhongmoney = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contjidumoney = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contnianzhongfentan = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contjidufentan = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtName = new com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox();
        this.txtSimpleName = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtDescription = new com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox();
        this.txtpostName = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtempNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtempName = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtclinicNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtclinicName = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.postNumber = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.prmtclinic = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtcity = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtbusinessdate = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtcardSellBonus = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtotherBounsOne = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtotherBounsTwo = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtdocAssBouns = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtshopHelp = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtgoodBouns = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtmarktBouns = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txttoDocBouns = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtdocKeepBouns = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.docKeepType = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.txtkefuBouns = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txthuliBouns = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtconvertBouns = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtmonthBase = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtbkCount = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtqkCount = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtholdAmount = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtxrayallow = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtnianzhongmoney = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtjidumoney = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtnianzhongfentan = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtjidufentan = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.kDLabelContainer1.setName("kDLabelContainer1");
        this.kDLabelContainer2.setName("kDLabelContainer2");
        this.kDLabelContainer3.setName("kDLabelContainer3");
        this.kDLabelContainer4.setName("kDLabelContainer4");
        this.contpostName.setName("contpostName");
        this.contempNumber.setName("contempNumber");
        this.contempName.setName("contempName");
        this.contclinicNumber.setName("contclinicNumber");
        this.contclinicName.setName("contclinicName");
        this.contpostNumber.setName("contpostNumber");
        this.contclinic.setName("contclinic");
        this.contcity.setName("contcity");
        this.contbusinessdate.setName("contbusinessdate");
        this.contcardSellBonus.setName("contcardSellBonus");
        this.contotherBounsOne.setName("contotherBounsOne");
        this.contotherBounsTwo.setName("contotherBounsTwo");
        this.contdocAssBouns.setName("contdocAssBouns");
        this.contshopHelp.setName("contshopHelp");
        this.contgoodBouns.setName("contgoodBouns");
        this.contmarktBouns.setName("contmarktBouns");
        this.conttoDocBouns.setName("conttoDocBouns");
        this.contdocKeepBouns.setName("contdocKeepBouns");
        this.contdocKeepType.setName("contdocKeepType");
        this.contkefuBouns.setName("contkefuBouns");
        this.conthuliBouns.setName("conthuliBouns");
        this.contconvertBouns.setName("contconvertBouns");
        this.contmonthBase.setName("contmonthBase");
        this.contbkCount.setName("contbkCount");
        this.contqkCount.setName("contqkCount");
        this.contholdAmount.setName("contholdAmount");
        this.contxrayallow.setName("contxrayallow");
        this.contnianzhongmoney.setName("contnianzhongmoney");
        this.contjidumoney.setName("contjidumoney");
        this.contnianzhongfentan.setName("contnianzhongfentan");
        this.contjidufentan.setName("contjidufentan");
        this.txtNumber.setName("txtNumber");
        this.txtName.setName("txtName");
        this.txtSimpleName.setName("txtSimpleName");
        this.txtDescription.setName("txtDescription");
        this.txtpostName.setName("txtpostName");
        this.txtempNumber.setName("txtempNumber");
        this.txtempName.setName("txtempName");
        this.txtclinicNumber.setName("txtclinicNumber");
        this.txtclinicName.setName("txtclinicName");
        this.postNumber.setName("postNumber");
        this.prmtclinic.setName("prmtclinic");
        this.prmtcity.setName("prmtcity");
        this.txtbusinessdate.setName("txtbusinessdate");
        this.txtcardSellBonus.setName("txtcardSellBonus");
        this.txtotherBounsOne.setName("txtotherBounsOne");
        this.txtotherBounsTwo.setName("txtotherBounsTwo");
        this.txtdocAssBouns.setName("txtdocAssBouns");
        this.txtshopHelp.setName("txtshopHelp");
        this.txtgoodBouns.setName("txtgoodBouns");
        this.txtmarktBouns.setName("txtmarktBouns");
        this.txttoDocBouns.setName("txttoDocBouns");
        this.txtdocKeepBouns.setName("txtdocKeepBouns");
        this.docKeepType.setName("docKeepType");
        this.txtkefuBouns.setName("txtkefuBouns");
        this.txthuliBouns.setName("txthuliBouns");
        this.txtconvertBouns.setName("txtconvertBouns");
        this.txtmonthBase.setName("txtmonthBase");
        this.txtbkCount.setName("txtbkCount");
        this.txtqkCount.setName("txtqkCount");
        this.txtholdAmount.setName("txtholdAmount");
        this.txtxrayallow.setName("txtxrayallow");
        this.txtnianzhongmoney.setName("txtnianzhongmoney");
        this.txtjidumoney.setName("txtjidumoney");
        this.txtnianzhongfentan.setName("txtnianzhongfentan");
        this.txtjidufentan.setName("txtjidufentan");
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
        // contpostName		
        this.contpostName.setBoundLabelText(resHelper.getString("contpostName.boundLabelText"));		
        this.contpostName.setBoundLabelLength(100);		
        this.contpostName.setBoundLabelUnderline(true);		
        this.contpostName.setVisible(true);
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
        // contpostNumber		
        this.contpostNumber.setBoundLabelText(resHelper.getString("contpostNumber.boundLabelText"));		
        this.contpostNumber.setBoundLabelLength(100);		
        this.contpostNumber.setBoundLabelUnderline(true);		
        this.contpostNumber.setVisible(true);
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
        // contbusinessdate		
        this.contbusinessdate.setBoundLabelText(resHelper.getString("contbusinessdate.boundLabelText"));		
        this.contbusinessdate.setBoundLabelLength(100);		
        this.contbusinessdate.setBoundLabelUnderline(true);		
        this.contbusinessdate.setVisible(true);
        // contcardSellBonus		
        this.contcardSellBonus.setBoundLabelText(resHelper.getString("contcardSellBonus.boundLabelText"));		
        this.contcardSellBonus.setBoundLabelLength(100);		
        this.contcardSellBonus.setBoundLabelUnderline(true);		
        this.contcardSellBonus.setVisible(true);
        // contotherBounsOne		
        this.contotherBounsOne.setBoundLabelText(resHelper.getString("contotherBounsOne.boundLabelText"));		
        this.contotherBounsOne.setBoundLabelLength(100);		
        this.contotherBounsOne.setBoundLabelUnderline(true);		
        this.contotherBounsOne.setVisible(true);
        // contotherBounsTwo		
        this.contotherBounsTwo.setBoundLabelText(resHelper.getString("contotherBounsTwo.boundLabelText"));		
        this.contotherBounsTwo.setBoundLabelLength(100);		
        this.contotherBounsTwo.setBoundLabelUnderline(true);		
        this.contotherBounsTwo.setVisible(true);
        // contdocAssBouns		
        this.contdocAssBouns.setBoundLabelText(resHelper.getString("contdocAssBouns.boundLabelText"));		
        this.contdocAssBouns.setBoundLabelLength(100);		
        this.contdocAssBouns.setBoundLabelUnderline(true);		
        this.contdocAssBouns.setVisible(true);
        // contshopHelp		
        this.contshopHelp.setBoundLabelText(resHelper.getString("contshopHelp.boundLabelText"));		
        this.contshopHelp.setBoundLabelLength(100);		
        this.contshopHelp.setBoundLabelUnderline(true);		
        this.contshopHelp.setVisible(true);
        // contgoodBouns		
        this.contgoodBouns.setBoundLabelText(resHelper.getString("contgoodBouns.boundLabelText"));		
        this.contgoodBouns.setBoundLabelLength(100);		
        this.contgoodBouns.setBoundLabelUnderline(true);		
        this.contgoodBouns.setVisible(true);
        // contmarktBouns		
        this.contmarktBouns.setBoundLabelText(resHelper.getString("contmarktBouns.boundLabelText"));		
        this.contmarktBouns.setBoundLabelLength(100);		
        this.contmarktBouns.setBoundLabelUnderline(true);		
        this.contmarktBouns.setVisible(true);
        // conttoDocBouns		
        this.conttoDocBouns.setBoundLabelText(resHelper.getString("conttoDocBouns.boundLabelText"));		
        this.conttoDocBouns.setBoundLabelLength(100);		
        this.conttoDocBouns.setBoundLabelUnderline(true);		
        this.conttoDocBouns.setVisible(true);
        // contdocKeepBouns		
        this.contdocKeepBouns.setBoundLabelText(resHelper.getString("contdocKeepBouns.boundLabelText"));		
        this.contdocKeepBouns.setBoundLabelLength(100);		
        this.contdocKeepBouns.setBoundLabelUnderline(true);		
        this.contdocKeepBouns.setVisible(true);
        // contdocKeepType		
        this.contdocKeepType.setBoundLabelText(resHelper.getString("contdocKeepType.boundLabelText"));		
        this.contdocKeepType.setBoundLabelLength(100);		
        this.contdocKeepType.setBoundLabelUnderline(true);		
        this.contdocKeepType.setVisible(true);
        // contkefuBouns		
        this.contkefuBouns.setBoundLabelText(resHelper.getString("contkefuBouns.boundLabelText"));		
        this.contkefuBouns.setBoundLabelLength(100);		
        this.contkefuBouns.setBoundLabelUnderline(true);		
        this.contkefuBouns.setVisible(true);
        // conthuliBouns		
        this.conthuliBouns.setBoundLabelText(resHelper.getString("conthuliBouns.boundLabelText"));		
        this.conthuliBouns.setBoundLabelLength(100);		
        this.conthuliBouns.setBoundLabelUnderline(true);		
        this.conthuliBouns.setVisible(true);
        // contconvertBouns		
        this.contconvertBouns.setBoundLabelText(resHelper.getString("contconvertBouns.boundLabelText"));		
        this.contconvertBouns.setBoundLabelLength(100);		
        this.contconvertBouns.setBoundLabelUnderline(true);		
        this.contconvertBouns.setVisible(true);
        // contmonthBase		
        this.contmonthBase.setBoundLabelText(resHelper.getString("contmonthBase.boundLabelText"));		
        this.contmonthBase.setBoundLabelLength(100);		
        this.contmonthBase.setBoundLabelUnderline(true);		
        this.contmonthBase.setVisible(true);
        // contbkCount		
        this.contbkCount.setBoundLabelText(resHelper.getString("contbkCount.boundLabelText"));		
        this.contbkCount.setBoundLabelLength(100);		
        this.contbkCount.setBoundLabelUnderline(true);		
        this.contbkCount.setVisible(true);
        // contqkCount		
        this.contqkCount.setBoundLabelText(resHelper.getString("contqkCount.boundLabelText"));		
        this.contqkCount.setBoundLabelLength(100);		
        this.contqkCount.setBoundLabelUnderline(true);		
        this.contqkCount.setVisible(true);
        // contholdAmount		
        this.contholdAmount.setBoundLabelText(resHelper.getString("contholdAmount.boundLabelText"));		
        this.contholdAmount.setBoundLabelLength(100);		
        this.contholdAmount.setBoundLabelUnderline(true);		
        this.contholdAmount.setVisible(true);
        // contxrayallow		
        this.contxrayallow.setBoundLabelText(resHelper.getString("contxrayallow.boundLabelText"));		
        this.contxrayallow.setBoundLabelLength(100);		
        this.contxrayallow.setBoundLabelUnderline(true);		
        this.contxrayallow.setVisible(true);
        // contnianzhongmoney		
        this.contnianzhongmoney.setBoundLabelText(resHelper.getString("contnianzhongmoney.boundLabelText"));		
        this.contnianzhongmoney.setBoundLabelLength(100);		
        this.contnianzhongmoney.setBoundLabelUnderline(true);		
        this.contnianzhongmoney.setVisible(true);
        // contjidumoney		
        this.contjidumoney.setBoundLabelText(resHelper.getString("contjidumoney.boundLabelText"));		
        this.contjidumoney.setBoundLabelLength(100);		
        this.contjidumoney.setBoundLabelUnderline(true);		
        this.contjidumoney.setVisible(true);
        // contnianzhongfentan		
        this.contnianzhongfentan.setBoundLabelText(resHelper.getString("contnianzhongfentan.boundLabelText"));		
        this.contnianzhongfentan.setBoundLabelLength(100);		
        this.contnianzhongfentan.setBoundLabelUnderline(true);		
        this.contnianzhongfentan.setVisible(true);
        // contjidufentan		
        this.contjidufentan.setBoundLabelText(resHelper.getString("contjidufentan.boundLabelText"));		
        this.contjidufentan.setBoundLabelLength(100);		
        this.contjidufentan.setBoundLabelUnderline(true);		
        this.contjidufentan.setVisible(true);
        // txtNumber		
        this.txtNumber.setMaxLength(80);
        // txtName
        // txtSimpleName		
        this.txtSimpleName.setMaxLength(80);
        // txtDescription
        // txtpostName		
        this.txtpostName.setVisible(true);		
        this.txtpostName.setHorizontalAlignment(2);		
        this.txtpostName.setMaxLength(100);		
        this.txtpostName.setRequired(false);
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
        // postNumber		
        this.postNumber.setVisible(true);		
        this.postNumber.addItems(EnumUtils.getEnumList("com.kingdee.eas.mw.pay.app.PaypostType").toArray());		
        this.postNumber.setRequired(false);
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
        // txtbusinessdate		
        this.txtbusinessdate.setVisible(true);		
        this.txtbusinessdate.setHorizontalAlignment(2);		
        this.txtbusinessdate.setMaxLength(100);		
        this.txtbusinessdate.setRequired(false);
        // txtcardSellBonus		
        this.txtcardSellBonus.setVisible(true);		
        this.txtcardSellBonus.setHorizontalAlignment(2);		
        this.txtcardSellBonus.setDataType(1);		
        this.txtcardSellBonus.setSupportedEmpty(true);		
        this.txtcardSellBonus.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtcardSellBonus.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtcardSellBonus.setPrecision(10);		
        this.txtcardSellBonus.setRequired(false);
        // txtotherBounsOne		
        this.txtotherBounsOne.setVisible(true);		
        this.txtotherBounsOne.setHorizontalAlignment(2);		
        this.txtotherBounsOne.setDataType(1);		
        this.txtotherBounsOne.setSupportedEmpty(true);		
        this.txtotherBounsOne.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtotherBounsOne.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtotherBounsOne.setPrecision(10);		
        this.txtotherBounsOne.setRequired(false);
        // txtotherBounsTwo		
        this.txtotherBounsTwo.setVisible(true);		
        this.txtotherBounsTwo.setHorizontalAlignment(2);		
        this.txtotherBounsTwo.setDataType(1);		
        this.txtotherBounsTwo.setSupportedEmpty(true);		
        this.txtotherBounsTwo.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtotherBounsTwo.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtotherBounsTwo.setPrecision(10);		
        this.txtotherBounsTwo.setRequired(false);
        // txtdocAssBouns		
        this.txtdocAssBouns.setVisible(true);		
        this.txtdocAssBouns.setHorizontalAlignment(2);		
        this.txtdocAssBouns.setDataType(1);		
        this.txtdocAssBouns.setSupportedEmpty(true);		
        this.txtdocAssBouns.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtdocAssBouns.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtdocAssBouns.setPrecision(10);		
        this.txtdocAssBouns.setRequired(false);
        // txtshopHelp		
        this.txtshopHelp.setVisible(true);		
        this.txtshopHelp.setHorizontalAlignment(2);		
        this.txtshopHelp.setDataType(1);		
        this.txtshopHelp.setSupportedEmpty(true);		
        this.txtshopHelp.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtshopHelp.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtshopHelp.setPrecision(10);		
        this.txtshopHelp.setRequired(false);
        // txtgoodBouns		
        this.txtgoodBouns.setVisible(true);		
        this.txtgoodBouns.setHorizontalAlignment(2);		
        this.txtgoodBouns.setDataType(1);		
        this.txtgoodBouns.setSupportedEmpty(true);		
        this.txtgoodBouns.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtgoodBouns.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtgoodBouns.setPrecision(10);		
        this.txtgoodBouns.setRequired(false);
        // txtmarktBouns		
        this.txtmarktBouns.setVisible(true);		
        this.txtmarktBouns.setHorizontalAlignment(2);		
        this.txtmarktBouns.setDataType(1);		
        this.txtmarktBouns.setSupportedEmpty(true);		
        this.txtmarktBouns.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtmarktBouns.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtmarktBouns.setPrecision(10);		
        this.txtmarktBouns.setRequired(false);
        // txttoDocBouns		
        this.txttoDocBouns.setVisible(true);		
        this.txttoDocBouns.setHorizontalAlignment(2);		
        this.txttoDocBouns.setDataType(1);		
        this.txttoDocBouns.setSupportedEmpty(true);		
        this.txttoDocBouns.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txttoDocBouns.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txttoDocBouns.setPrecision(10);		
        this.txttoDocBouns.setRequired(false);
        // txtdocKeepBouns		
        this.txtdocKeepBouns.setVisible(true);		
        this.txtdocKeepBouns.setHorizontalAlignment(2);		
        this.txtdocKeepBouns.setDataType(1);		
        this.txtdocKeepBouns.setSupportedEmpty(true);		
        this.txtdocKeepBouns.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtdocKeepBouns.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtdocKeepBouns.setPrecision(10);		
        this.txtdocKeepBouns.setRequired(false);
        // docKeepType		
        this.docKeepType.setVisible(true);		
        this.docKeepType.addItems(EnumUtils.getEnumList("com.kingdee.eas.mw.pay.app.DocKeepType").toArray());		
        this.docKeepType.setRequired(false);
        // txtkefuBouns		
        this.txtkefuBouns.setVisible(true);		
        this.txtkefuBouns.setHorizontalAlignment(2);		
        this.txtkefuBouns.setDataType(1);		
        this.txtkefuBouns.setSupportedEmpty(true);		
        this.txtkefuBouns.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtkefuBouns.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtkefuBouns.setPrecision(10);		
        this.txtkefuBouns.setRequired(false);
        // txthuliBouns		
        this.txthuliBouns.setVisible(true);		
        this.txthuliBouns.setHorizontalAlignment(2);		
        this.txthuliBouns.setDataType(1);		
        this.txthuliBouns.setSupportedEmpty(true);		
        this.txthuliBouns.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txthuliBouns.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txthuliBouns.setPrecision(10);		
        this.txthuliBouns.setRequired(false);
        // txtconvertBouns		
        this.txtconvertBouns.setVisible(true);		
        this.txtconvertBouns.setHorizontalAlignment(2);		
        this.txtconvertBouns.setDataType(1);		
        this.txtconvertBouns.setSupportedEmpty(true);		
        this.txtconvertBouns.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtconvertBouns.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtconvertBouns.setPrecision(10);		
        this.txtconvertBouns.setRequired(false);
        // txtmonthBase		
        this.txtmonthBase.setVisible(true);		
        this.txtmonthBase.setHorizontalAlignment(2);		
        this.txtmonthBase.setDataType(1);		
        this.txtmonthBase.setSupportedEmpty(true);		
        this.txtmonthBase.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtmonthBase.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtmonthBase.setPrecision(10);		
        this.txtmonthBase.setRequired(false);
        // txtbkCount		
        this.txtbkCount.setVisible(true);		
        this.txtbkCount.setHorizontalAlignment(2);		
        this.txtbkCount.setDataType(1);		
        this.txtbkCount.setSupportedEmpty(true);		
        this.txtbkCount.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtbkCount.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtbkCount.setPrecision(10);		
        this.txtbkCount.setRequired(false);
        // txtqkCount		
        this.txtqkCount.setVisible(true);		
        this.txtqkCount.setHorizontalAlignment(2);		
        this.txtqkCount.setDataType(1);		
        this.txtqkCount.setSupportedEmpty(true);		
        this.txtqkCount.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtqkCount.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtqkCount.setPrecision(10);		
        this.txtqkCount.setRequired(false);
        // txtholdAmount		
        this.txtholdAmount.setVisible(true);		
        this.txtholdAmount.setHorizontalAlignment(2);		
        this.txtholdAmount.setDataType(1);		
        this.txtholdAmount.setSupportedEmpty(true);		
        this.txtholdAmount.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtholdAmount.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtholdAmount.setPrecision(10);		
        this.txtholdAmount.setRequired(false);
        // txtxrayallow		
        this.txtxrayallow.setVisible(true);		
        this.txtxrayallow.setHorizontalAlignment(2);		
        this.txtxrayallow.setDataType(1);		
        this.txtxrayallow.setSupportedEmpty(true);		
        this.txtxrayallow.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtxrayallow.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtxrayallow.setPrecision(10);		
        this.txtxrayallow.setRequired(false);
        // txtnianzhongmoney		
        this.txtnianzhongmoney.setVisible(true);		
        this.txtnianzhongmoney.setHorizontalAlignment(2);		
        this.txtnianzhongmoney.setDataType(1);		
        this.txtnianzhongmoney.setSupportedEmpty(true);		
        this.txtnianzhongmoney.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtnianzhongmoney.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtnianzhongmoney.setPrecision(10);		
        this.txtnianzhongmoney.setRequired(false);
        // txtjidumoney		
        this.txtjidumoney.setVisible(true);		
        this.txtjidumoney.setHorizontalAlignment(2);		
        this.txtjidumoney.setDataType(1);		
        this.txtjidumoney.setSupportedEmpty(true);		
        this.txtjidumoney.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtjidumoney.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtjidumoney.setPrecision(10);		
        this.txtjidumoney.setRequired(false);
        // txtnianzhongfentan		
        this.txtnianzhongfentan.setVisible(true);		
        this.txtnianzhongfentan.setHorizontalAlignment(2);		
        this.txtnianzhongfentan.setDataType(1);		
        this.txtnianzhongfentan.setSupportedEmpty(true);		
        this.txtnianzhongfentan.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtnianzhongfentan.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtnianzhongfentan.setPrecision(10);		
        this.txtnianzhongfentan.setRequired(false);
        // txtjidufentan		
        this.txtjidufentan.setVisible(true);		
        this.txtjidufentan.setHorizontalAlignment(2);		
        this.txtjidufentan.setDataType(1);		
        this.txtjidufentan.setSupportedEmpty(true);		
        this.txtjidufentan.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtjidufentan.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtjidufentan.setPrecision(10);		
        this.txtjidufentan.setRequired(false);
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {txtpostName,txtempNumber,txtempName,txtclinicNumber,txtclinicName,postNumber,prmtclinic,prmtcity,txtbusinessdate,txtcardSellBonus,txtotherBounsOne,txtotherBounsTwo,txtdocAssBouns,txtshopHelp,txtgoodBouns,txtmarktBouns,txttoDocBouns,txtdocKeepBouns,docKeepType,txtkefuBouns,txthuliBouns,txtconvertBouns,txtmonthBase,txtbkCount,txtqkCount,txtholdAmount,txtxrayallow,txtnianzhongmoney,txtjidumoney,txtnianzhongfentan,txtjidufentan}));
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
        this.setBounds(new Rectangle(0, 0, 1013, 317));
        this.setLayout(null);
        kDLabelContainer1.setBounds(new Rectangle(672, 178, 270, 19));
        this.add(kDLabelContainer1, null);
        kDLabelContainer2.setBounds(new Rectangle(341, 202, 270, 19));
        this.add(kDLabelContainer2, null);
        kDLabelContainer3.setBounds(new Rectangle(10, 202, 270, 19));
        this.add(kDLabelContainer3, null);
        kDLabelContainer4.setBounds(new Rectangle(672, 154, 270, 19));
        this.add(kDLabelContainer4, null);
        contpostName.setBounds(new Rectangle(341, 130, 270, 19));
        this.add(contpostName, null);
        contempNumber.setBounds(new Rectangle(10, 34, 270, 19));
        this.add(contempNumber, null);
        contempName.setBounds(new Rectangle(341, 34, 270, 19));
        this.add(contempName, null);
        contclinicNumber.setBounds(new Rectangle(341, 10, 270, 19));
        this.add(contclinicNumber, null);
        contclinicName.setBounds(new Rectangle(672, 10, 270, 19));
        this.add(contclinicName, null);
        contpostNumber.setBounds(new Rectangle(10, 58, 270, 19));
        this.add(contpostNumber, null);
        contclinic.setBounds(new Rectangle(10, 130, 270, 19));
        this.add(contclinic, null);
        contcity.setBounds(new Rectangle(10, 10, 270, 19));
        this.add(contcity, null);
        contbusinessdate.setBounds(new Rectangle(672, 34, 270, 19));
        this.add(contbusinessdate, null);
        contcardSellBonus.setBounds(new Rectangle(341, 58, 270, 19));
        this.add(contcardSellBonus, null);
        contotherBounsOne.setBounds(new Rectangle(672, 58, 270, 19));
        this.add(contotherBounsOne, null);
        contotherBounsTwo.setBounds(new Rectangle(10, 82, 270, 19));
        this.add(contotherBounsTwo, null);
        contdocAssBouns.setBounds(new Rectangle(341, 82, 270, 19));
        this.add(contdocAssBouns, null);
        contshopHelp.setBounds(new Rectangle(672, 82, 270, 19));
        this.add(contshopHelp, null);
        contgoodBouns.setBounds(new Rectangle(10, 106, 270, 19));
        this.add(contgoodBouns, null);
        contmarktBouns.setBounds(new Rectangle(341, 106, 270, 19));
        this.add(contmarktBouns, null);
        conttoDocBouns.setBounds(new Rectangle(672, 106, 270, 19));
        this.add(conttoDocBouns, null);
        contdocKeepBouns.setBounds(new Rectangle(672, 130, 270, 19));
        this.add(contdocKeepBouns, null);
        contdocKeepType.setBounds(new Rectangle(10, 154, 270, 19));
        this.add(contdocKeepType, null);
        contkefuBouns.setBounds(new Rectangle(341, 154, 270, 19));
        this.add(contkefuBouns, null);
        conthuliBouns.setBounds(new Rectangle(10, 178, 270, 19));
        this.add(conthuliBouns, null);
        contconvertBouns.setBounds(new Rectangle(341, 178, 270, 19));
        this.add(contconvertBouns, null);
        contmonthBase.setBounds(new Rectangle(672, 202, 270, 19));
        this.add(contmonthBase, null);
        contbkCount.setBounds(new Rectangle(10, 226, 270, 19));
        this.add(contbkCount, null);
        contqkCount.setBounds(new Rectangle(341, 226, 270, 19));
        this.add(contqkCount, null);
        contholdAmount.setBounds(new Rectangle(672, 226, 270, 19));
        this.add(contholdAmount, null);
        contxrayallow.setBounds(new Rectangle(10, 250, 270, 19));
        this.add(contxrayallow, null);
        contnianzhongmoney.setBounds(new Rectangle(341, 250, 270, 19));
        this.add(contnianzhongmoney, null);
        contjidumoney.setBounds(new Rectangle(10, 274, 270, 19));
        this.add(contjidumoney, null);
        contnianzhongfentan.setBounds(new Rectangle(672, 250, 270, 19));
        this.add(contnianzhongfentan, null);
        contjidufentan.setBounds(new Rectangle(341, 274, 270, 19));
        this.add(contjidufentan, null);
        //kDLabelContainer1
        kDLabelContainer1.setBoundEditor(txtNumber);
        //kDLabelContainer2
        kDLabelContainer2.setBoundEditor(txtName);
        //kDLabelContainer3
        kDLabelContainer3.setBoundEditor(txtSimpleName);
        //kDLabelContainer4
        kDLabelContainer4.setBoundEditor(txtDescription);
        //contpostName
        contpostName.setBoundEditor(txtpostName);
        //contempNumber
        contempNumber.setBoundEditor(txtempNumber);
        //contempName
        contempName.setBoundEditor(txtempName);
        //contclinicNumber
        contclinicNumber.setBoundEditor(txtclinicNumber);
        //contclinicName
        contclinicName.setBoundEditor(txtclinicName);
        //contpostNumber
        contpostNumber.setBoundEditor(postNumber);
        //contclinic
        contclinic.setBoundEditor(prmtclinic);
        //contcity
        contcity.setBoundEditor(prmtcity);
        //contbusinessdate
        contbusinessdate.setBoundEditor(txtbusinessdate);
        //contcardSellBonus
        contcardSellBonus.setBoundEditor(txtcardSellBonus);
        //contotherBounsOne
        contotherBounsOne.setBoundEditor(txtotherBounsOne);
        //contotherBounsTwo
        contotherBounsTwo.setBoundEditor(txtotherBounsTwo);
        //contdocAssBouns
        contdocAssBouns.setBoundEditor(txtdocAssBouns);
        //contshopHelp
        contshopHelp.setBoundEditor(txtshopHelp);
        //contgoodBouns
        contgoodBouns.setBoundEditor(txtgoodBouns);
        //contmarktBouns
        contmarktBouns.setBoundEditor(txtmarktBouns);
        //conttoDocBouns
        conttoDocBouns.setBoundEditor(txttoDocBouns);
        //contdocKeepBouns
        contdocKeepBouns.setBoundEditor(txtdocKeepBouns);
        //contdocKeepType
        contdocKeepType.setBoundEditor(docKeepType);
        //contkefuBouns
        contkefuBouns.setBoundEditor(txtkefuBouns);
        //conthuliBouns
        conthuliBouns.setBoundEditor(txthuliBouns);
        //contconvertBouns
        contconvertBouns.setBoundEditor(txtconvertBouns);
        //contmonthBase
        contmonthBase.setBoundEditor(txtmonthBase);
        //contbkCount
        contbkCount.setBoundEditor(txtbkCount);
        //contqkCount
        contqkCount.setBoundEditor(txtqkCount);
        //contholdAmount
        contholdAmount.setBoundEditor(txtholdAmount);
        //contxrayallow
        contxrayallow.setBoundEditor(txtxrayallow);
        //contnianzhongmoney
        contnianzhongmoney.setBoundEditor(txtnianzhongmoney);
        //contjidumoney
        contjidumoney.setBoundEditor(txtjidumoney);
        //contnianzhongfentan
        contnianzhongfentan.setBoundEditor(txtnianzhongfentan);
        //contjidufentan
        contjidufentan.setBoundEditor(txtjidufentan);

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
		dataBinder.registerBinding("postName", String.class, this.txtpostName, "text");
		dataBinder.registerBinding("empNumber", String.class, this.txtempNumber, "text");
		dataBinder.registerBinding("empName", String.class, this.txtempName, "text");
		dataBinder.registerBinding("clinicNumber", String.class, this.txtclinicNumber, "text");
		dataBinder.registerBinding("clinicName", String.class, this.txtclinicName, "text");
		dataBinder.registerBinding("postNumber", com.kingdee.eas.mw.pay.app.PaypostType.class, this.postNumber, "selectedItem");
		dataBinder.registerBinding("clinic", com.kingdee.eas.basedata.org.CompanyOrgUnitInfo.class, this.prmtclinic, "data");
		dataBinder.registerBinding("city", com.kingdee.eas.basedata.org.CtrlUnitInfo.class, this.prmtcity, "data");
		dataBinder.registerBinding("businessdate", String.class, this.txtbusinessdate, "text");
		dataBinder.registerBinding("cardSellBonus", java.math.BigDecimal.class, this.txtcardSellBonus, "value");
		dataBinder.registerBinding("otherBounsOne", java.math.BigDecimal.class, this.txtotherBounsOne, "value");
		dataBinder.registerBinding("otherBounsTwo", java.math.BigDecimal.class, this.txtotherBounsTwo, "value");
		dataBinder.registerBinding("docAssBouns", java.math.BigDecimal.class, this.txtdocAssBouns, "value");
		dataBinder.registerBinding("shopHelp", java.math.BigDecimal.class, this.txtshopHelp, "value");
		dataBinder.registerBinding("goodBouns", java.math.BigDecimal.class, this.txtgoodBouns, "value");
		dataBinder.registerBinding("marktBouns", java.math.BigDecimal.class, this.txtmarktBouns, "value");
		dataBinder.registerBinding("toDocBouns", java.math.BigDecimal.class, this.txttoDocBouns, "value");
		dataBinder.registerBinding("docKeepBouns", java.math.BigDecimal.class, this.txtdocKeepBouns, "value");
		dataBinder.registerBinding("docKeepType", com.kingdee.eas.mw.pay.app.DocKeepType.class, this.docKeepType, "selectedItem");
		dataBinder.registerBinding("kefuBouns", java.math.BigDecimal.class, this.txtkefuBouns, "value");
		dataBinder.registerBinding("huliBouns", java.math.BigDecimal.class, this.txthuliBouns, "value");
		dataBinder.registerBinding("convertBouns", java.math.BigDecimal.class, this.txtconvertBouns, "value");
		dataBinder.registerBinding("monthBase", java.math.BigDecimal.class, this.txtmonthBase, "value");
		dataBinder.registerBinding("bkCount", java.math.BigDecimal.class, this.txtbkCount, "value");
		dataBinder.registerBinding("qkCount", java.math.BigDecimal.class, this.txtqkCount, "value");
		dataBinder.registerBinding("holdAmount", java.math.BigDecimal.class, this.txtholdAmount, "value");
		dataBinder.registerBinding("xrayallow", java.math.BigDecimal.class, this.txtxrayallow, "value");
		dataBinder.registerBinding("nianzhongmoney", java.math.BigDecimal.class, this.txtnianzhongmoney, "value");
		dataBinder.registerBinding("jidumoney", java.math.BigDecimal.class, this.txtjidumoney, "value");
		dataBinder.registerBinding("nianzhongfentan", java.math.BigDecimal.class, this.txtnianzhongfentan, "value");
		dataBinder.registerBinding("jidufentan", java.math.BigDecimal.class, this.txtjidufentan, "value");		
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
	    return "com.kingdee.eas.mw.pay.app.OtherBonusSpiltEditUIHandler";
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
        this.txtpostName.requestFocusInWindow();
    }

	
	

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject)
    {
        IObjectValue ov = dataObject;        	    	
        super.setDataObject(ov);
        this.editData = (com.kingdee.eas.mw.pay.OtherBonusSpiltInfo)ov;
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
		getValidateHelper().registerBindProperty("postName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("empNumber", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("empName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("clinicNumber", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("clinicName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("postNumber", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("clinic", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("city", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("businessdate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("cardSellBonus", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("otherBounsOne", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("otherBounsTwo", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("docAssBouns", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("shopHelp", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("goodBouns", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("marktBouns", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("toDocBouns", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("docKeepBouns", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("docKeepType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("kefuBouns", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("huliBouns", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("convertBouns", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("monthBase", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("bkCount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("qkCount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("holdAmount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("xrayallow", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("nianzhongmoney", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("jidumoney", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("nianzhongfentan", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("jidufentan", ValidateHelper.ON_SAVE);    		
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
        sic.add(new SelectorItemInfo("postName"));
        sic.add(new SelectorItemInfo("empNumber"));
        sic.add(new SelectorItemInfo("empName"));
        sic.add(new SelectorItemInfo("clinicNumber"));
        sic.add(new SelectorItemInfo("clinicName"));
        sic.add(new SelectorItemInfo("postNumber"));
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
        sic.add(new SelectorItemInfo("businessdate"));
        sic.add(new SelectorItemInfo("cardSellBonus"));
        sic.add(new SelectorItemInfo("otherBounsOne"));
        sic.add(new SelectorItemInfo("otherBounsTwo"));
        sic.add(new SelectorItemInfo("docAssBouns"));
        sic.add(new SelectorItemInfo("shopHelp"));
        sic.add(new SelectorItemInfo("goodBouns"));
        sic.add(new SelectorItemInfo("marktBouns"));
        sic.add(new SelectorItemInfo("toDocBouns"));
        sic.add(new SelectorItemInfo("docKeepBouns"));
        sic.add(new SelectorItemInfo("docKeepType"));
        sic.add(new SelectorItemInfo("kefuBouns"));
        sic.add(new SelectorItemInfo("huliBouns"));
        sic.add(new SelectorItemInfo("convertBouns"));
        sic.add(new SelectorItemInfo("monthBase"));
        sic.add(new SelectorItemInfo("bkCount"));
        sic.add(new SelectorItemInfo("qkCount"));
        sic.add(new SelectorItemInfo("holdAmount"));
        sic.add(new SelectorItemInfo("xrayallow"));
        sic.add(new SelectorItemInfo("nianzhongmoney"));
        sic.add(new SelectorItemInfo("jidumoney"));
        sic.add(new SelectorItemInfo("nianzhongfentan"));
        sic.add(new SelectorItemInfo("jidufentan"));
        return sic;
    }        

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.mw.pay.client", "OtherBonusSpiltEditUI");
    }

    /**
     * output getEditUIName method
     */
    protected String getEditUIName()
    {
        return com.kingdee.eas.mw.pay.client.OtherBonusSpiltEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.mw.pay.OtherBonusSpiltFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.mw.pay.OtherBonusSpiltInfo objectValue = new com.kingdee.eas.mw.pay.OtherBonusSpiltInfo();
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
		vo.put("docKeepType","wu");
        
    }        
	protected void setFieldsNull(com.kingdee.bos.dao.AbstractObjectValue arg0) {
		super.setFieldsNull(arg0);
		arg0.put("number",null);
	}

}