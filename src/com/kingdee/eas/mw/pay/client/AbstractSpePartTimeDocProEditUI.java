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
public abstract class AbstractSpePartTimeDocProEditUI extends com.kingdee.eas.framework.client.EditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractSpePartTimeDocProEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer2;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer3;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer4;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contdocNumber;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contdocName;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contgdzztPrice;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contzdzztPrice;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contddzztPrice;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contntPrice;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contwtPrice;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contgjyPrice;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contxgfPrice;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contdgfPrice;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contxgmPrice;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contdgmPrice;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contzzpro;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contgdjzpro;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contyxjzpro;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contyzpro;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contknwpro;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contmbpro;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contxhpro;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conteypro;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contzjPro;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox txtName;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtSimpleName;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox txtDescription;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtdocNumber;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtdocName;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtgdzztPrice;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtzdzztPrice;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtddzztPrice;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtntPrice;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtwtPrice;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtgjyPrice;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtxgfPrice;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtdgfPrice;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtxgmPrice;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtdgmPrice;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtzzpro;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtgdjzpro;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtyxjzpro;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtyzpro;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtknwpro;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtmbpro;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtxhpro;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txteypro;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtzjPro;
    protected com.kingdee.eas.mw.pay.SpePartTimeDocProInfo editData = null;
    /**
     * output class constructor
     */
    public AbstractSpePartTimeDocProEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractSpePartTimeDocProEditUI.class.getName());
        this.setUITitle(resHelper.getString("this.title"));
        this.kDLabelContainer1 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer2 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer3 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer4 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contdocNumber = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contdocName = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contgdzztPrice = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contzdzztPrice = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contddzztPrice = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contntPrice = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contwtPrice = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contgjyPrice = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contxgfPrice = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contdgfPrice = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contxgmPrice = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contdgmPrice = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contzzpro = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contgdjzpro = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contyxjzpro = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contyzpro = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contknwpro = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contmbpro = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contxhpro = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conteypro = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contzjPro = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtName = new com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox();
        this.txtSimpleName = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtDescription = new com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox();
        this.txtdocNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtdocName = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtgdzztPrice = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtzdzztPrice = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtddzztPrice = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtntPrice = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtwtPrice = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtgjyPrice = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtxgfPrice = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtdgfPrice = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtxgmPrice = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtdgmPrice = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtzzpro = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtgdjzpro = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtyxjzpro = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtyzpro = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtknwpro = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtmbpro = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtxhpro = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txteypro = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtzjPro = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.kDLabelContainer1.setName("kDLabelContainer1");
        this.kDLabelContainer2.setName("kDLabelContainer2");
        this.kDLabelContainer3.setName("kDLabelContainer3");
        this.kDLabelContainer4.setName("kDLabelContainer4");
        this.contdocNumber.setName("contdocNumber");
        this.contdocName.setName("contdocName");
        this.contgdzztPrice.setName("contgdzztPrice");
        this.contzdzztPrice.setName("contzdzztPrice");
        this.contddzztPrice.setName("contddzztPrice");
        this.contntPrice.setName("contntPrice");
        this.contwtPrice.setName("contwtPrice");
        this.contgjyPrice.setName("contgjyPrice");
        this.contxgfPrice.setName("contxgfPrice");
        this.contdgfPrice.setName("contdgfPrice");
        this.contxgmPrice.setName("contxgmPrice");
        this.contdgmPrice.setName("contdgmPrice");
        this.contzzpro.setName("contzzpro");
        this.contgdjzpro.setName("contgdjzpro");
        this.contyxjzpro.setName("contyxjzpro");
        this.contyzpro.setName("contyzpro");
        this.contknwpro.setName("contknwpro");
        this.contmbpro.setName("contmbpro");
        this.contxhpro.setName("contxhpro");
        this.conteypro.setName("conteypro");
        this.contzjPro.setName("contzjPro");
        this.txtNumber.setName("txtNumber");
        this.txtName.setName("txtName");
        this.txtSimpleName.setName("txtSimpleName");
        this.txtDescription.setName("txtDescription");
        this.txtdocNumber.setName("txtdocNumber");
        this.txtdocName.setName("txtdocName");
        this.txtgdzztPrice.setName("txtgdzztPrice");
        this.txtzdzztPrice.setName("txtzdzztPrice");
        this.txtddzztPrice.setName("txtddzztPrice");
        this.txtntPrice.setName("txtntPrice");
        this.txtwtPrice.setName("txtwtPrice");
        this.txtgjyPrice.setName("txtgjyPrice");
        this.txtxgfPrice.setName("txtxgfPrice");
        this.txtdgfPrice.setName("txtdgfPrice");
        this.txtxgmPrice.setName("txtxgmPrice");
        this.txtdgmPrice.setName("txtdgmPrice");
        this.txtzzpro.setName("txtzzpro");
        this.txtgdjzpro.setName("txtgdjzpro");
        this.txtyxjzpro.setName("txtyxjzpro");
        this.txtyzpro.setName("txtyzpro");
        this.txtknwpro.setName("txtknwpro");
        this.txtmbpro.setName("txtmbpro");
        this.txtxhpro.setName("txtxhpro");
        this.txteypro.setName("txteypro");
        this.txtzjPro.setName("txtzjPro");
        // CoreUI		
        this.btnPrint.setVisible(false);		
        this.btnPrintPreview.setVisible(false);		
        this.menuItemPrint.setVisible(false);		
        this.menuItemPrintPreview.setVisible(false);
        // kDLabelContainer1		
        this.kDLabelContainer1.setBoundLabelText(resHelper.getString("kDLabelContainer1.boundLabelText"));		
        this.kDLabelContainer1.setBoundLabelLength(100);		
        this.kDLabelContainer1.setBoundLabelUnderline(true);		
        this.kDLabelContainer1.setVisible(false);
        // kDLabelContainer2		
        this.kDLabelContainer2.setBoundLabelText(resHelper.getString("kDLabelContainer2.boundLabelText"));		
        this.kDLabelContainer2.setBoundLabelLength(100);		
        this.kDLabelContainer2.setBoundLabelUnderline(true);		
        this.kDLabelContainer2.setVisible(false);
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
        // contgdzztPrice		
        this.contgdzztPrice.setBoundLabelText(resHelper.getString("contgdzztPrice.boundLabelText"));		
        this.contgdzztPrice.setBoundLabelLength(100);		
        this.contgdzztPrice.setBoundLabelUnderline(true);		
        this.contgdzztPrice.setVisible(true);
        // contzdzztPrice		
        this.contzdzztPrice.setBoundLabelText(resHelper.getString("contzdzztPrice.boundLabelText"));		
        this.contzdzztPrice.setBoundLabelLength(100);		
        this.contzdzztPrice.setBoundLabelUnderline(true);		
        this.contzdzztPrice.setVisible(true);
        // contddzztPrice		
        this.contddzztPrice.setBoundLabelText(resHelper.getString("contddzztPrice.boundLabelText"));		
        this.contddzztPrice.setBoundLabelLength(100);		
        this.contddzztPrice.setBoundLabelUnderline(true);		
        this.contddzztPrice.setVisible(true);
        // contntPrice		
        this.contntPrice.setBoundLabelText(resHelper.getString("contntPrice.boundLabelText"));		
        this.contntPrice.setBoundLabelLength(100);		
        this.contntPrice.setBoundLabelUnderline(true);		
        this.contntPrice.setVisible(true);
        // contwtPrice		
        this.contwtPrice.setBoundLabelText(resHelper.getString("contwtPrice.boundLabelText"));		
        this.contwtPrice.setBoundLabelLength(100);		
        this.contwtPrice.setBoundLabelUnderline(true);		
        this.contwtPrice.setVisible(true);
        // contgjyPrice		
        this.contgjyPrice.setBoundLabelText(resHelper.getString("contgjyPrice.boundLabelText"));		
        this.contgjyPrice.setBoundLabelLength(100);		
        this.contgjyPrice.setBoundLabelUnderline(true);		
        this.contgjyPrice.setVisible(true);
        // contxgfPrice		
        this.contxgfPrice.setBoundLabelText(resHelper.getString("contxgfPrice.boundLabelText"));		
        this.contxgfPrice.setBoundLabelLength(100);		
        this.contxgfPrice.setBoundLabelUnderline(true);		
        this.contxgfPrice.setVisible(true);
        // contdgfPrice		
        this.contdgfPrice.setBoundLabelText(resHelper.getString("contdgfPrice.boundLabelText"));		
        this.contdgfPrice.setBoundLabelLength(100);		
        this.contdgfPrice.setBoundLabelUnderline(true);		
        this.contdgfPrice.setVisible(true);
        // contxgmPrice		
        this.contxgmPrice.setBoundLabelText(resHelper.getString("contxgmPrice.boundLabelText"));		
        this.contxgmPrice.setBoundLabelLength(100);		
        this.contxgmPrice.setBoundLabelUnderline(true);		
        this.contxgmPrice.setVisible(true);
        // contdgmPrice		
        this.contdgmPrice.setBoundLabelText(resHelper.getString("contdgmPrice.boundLabelText"));		
        this.contdgmPrice.setBoundLabelLength(100);		
        this.contdgmPrice.setBoundLabelUnderline(true);		
        this.contdgmPrice.setVisible(true);
        // contzzpro		
        this.contzzpro.setBoundLabelText(resHelper.getString("contzzpro.boundLabelText"));		
        this.contzzpro.setBoundLabelLength(100);		
        this.contzzpro.setBoundLabelUnderline(true);		
        this.contzzpro.setVisible(true);
        // contgdjzpro		
        this.contgdjzpro.setBoundLabelText(resHelper.getString("contgdjzpro.boundLabelText"));		
        this.contgdjzpro.setBoundLabelLength(100);		
        this.contgdjzpro.setBoundLabelUnderline(true);		
        this.contgdjzpro.setVisible(true);
        // contyxjzpro		
        this.contyxjzpro.setBoundLabelText(resHelper.getString("contyxjzpro.boundLabelText"));		
        this.contyxjzpro.setBoundLabelLength(100);		
        this.contyxjzpro.setBoundLabelUnderline(true);		
        this.contyxjzpro.setVisible(true);
        // contyzpro		
        this.contyzpro.setBoundLabelText(resHelper.getString("contyzpro.boundLabelText"));		
        this.contyzpro.setBoundLabelLength(100);		
        this.contyzpro.setBoundLabelUnderline(true);		
        this.contyzpro.setVisible(true);
        // contknwpro		
        this.contknwpro.setBoundLabelText(resHelper.getString("contknwpro.boundLabelText"));		
        this.contknwpro.setBoundLabelLength(100);		
        this.contknwpro.setBoundLabelUnderline(true);		
        this.contknwpro.setVisible(true);
        // contmbpro		
        this.contmbpro.setBoundLabelText(resHelper.getString("contmbpro.boundLabelText"));		
        this.contmbpro.setBoundLabelLength(100);		
        this.contmbpro.setBoundLabelUnderline(true);		
        this.contmbpro.setVisible(true);
        // contxhpro		
        this.contxhpro.setBoundLabelText(resHelper.getString("contxhpro.boundLabelText"));		
        this.contxhpro.setBoundLabelLength(100);		
        this.contxhpro.setBoundLabelUnderline(true);		
        this.contxhpro.setVisible(true);
        // conteypro		
        this.conteypro.setBoundLabelText(resHelper.getString("conteypro.boundLabelText"));		
        this.conteypro.setBoundLabelLength(100);		
        this.conteypro.setBoundLabelUnderline(true);		
        this.conteypro.setVisible(true);
        // contzjPro		
        this.contzjPro.setBoundLabelText(resHelper.getString("contzjPro.boundLabelText"));		
        this.contzjPro.setBoundLabelLength(100);		
        this.contzjPro.setBoundLabelUnderline(true);		
        this.contzjPro.setVisible(true);
        // txtNumber		
        this.txtNumber.setMaxLength(80);		
        this.txtNumber.setEnabled(false);		
        this.txtNumber.setVisible(false);		
        this.txtNumber.setOpaque(false);
        // txtName		
        this.txtName.setEnabled(false);		
        this.txtName.setVisible(false);		
        this.txtName.setOpaque(false);
        // txtSimpleName		
        this.txtSimpleName.setMaxLength(80);		
        this.txtSimpleName.setOpaque(false);		
        this.txtSimpleName.setVisible(false);		
        this.txtSimpleName.setEnabled(false);
        // txtDescription		
        this.txtDescription.setEnabled(false);		
        this.txtDescription.setVisible(false);		
        this.txtDescription.setOpaque(false);
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
        // txtgdzztPrice		
        this.txtgdzztPrice.setVisible(true);		
        this.txtgdzztPrice.setHorizontalAlignment(2);		
        this.txtgdzztPrice.setDataType(1);		
        this.txtgdzztPrice.setSupportedEmpty(true);		
        this.txtgdzztPrice.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtgdzztPrice.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtgdzztPrice.setPrecision(10);		
        this.txtgdzztPrice.setRequired(false);
        // txtzdzztPrice		
        this.txtzdzztPrice.setVisible(true);		
        this.txtzdzztPrice.setHorizontalAlignment(2);		
        this.txtzdzztPrice.setDataType(1);		
        this.txtzdzztPrice.setSupportedEmpty(true);		
        this.txtzdzztPrice.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtzdzztPrice.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtzdzztPrice.setPrecision(10);		
        this.txtzdzztPrice.setRequired(false);
        // txtddzztPrice		
        this.txtddzztPrice.setVisible(true);		
        this.txtddzztPrice.setHorizontalAlignment(2);		
        this.txtddzztPrice.setDataType(1);		
        this.txtddzztPrice.setSupportedEmpty(true);		
        this.txtddzztPrice.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtddzztPrice.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtddzztPrice.setPrecision(10);		
        this.txtddzztPrice.setRequired(false);
        // txtntPrice		
        this.txtntPrice.setVisible(true);		
        this.txtntPrice.setHorizontalAlignment(2);		
        this.txtntPrice.setDataType(1);		
        this.txtntPrice.setSupportedEmpty(true);		
        this.txtntPrice.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtntPrice.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtntPrice.setPrecision(10);		
        this.txtntPrice.setRequired(false);
        // txtwtPrice		
        this.txtwtPrice.setVisible(true);		
        this.txtwtPrice.setHorizontalAlignment(2);		
        this.txtwtPrice.setDataType(1);		
        this.txtwtPrice.setSupportedEmpty(true);		
        this.txtwtPrice.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtwtPrice.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtwtPrice.setPrecision(10);		
        this.txtwtPrice.setRequired(false);
        // txtgjyPrice		
        this.txtgjyPrice.setVisible(true);		
        this.txtgjyPrice.setHorizontalAlignment(2);		
        this.txtgjyPrice.setDataType(1);		
        this.txtgjyPrice.setSupportedEmpty(true);		
        this.txtgjyPrice.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtgjyPrice.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtgjyPrice.setPrecision(10);		
        this.txtgjyPrice.setRequired(false);
        // txtxgfPrice		
        this.txtxgfPrice.setVisible(true);		
        this.txtxgfPrice.setHorizontalAlignment(2);		
        this.txtxgfPrice.setDataType(1);		
        this.txtxgfPrice.setSupportedEmpty(true);		
        this.txtxgfPrice.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtxgfPrice.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtxgfPrice.setPrecision(10);		
        this.txtxgfPrice.setRequired(false);
        // txtdgfPrice		
        this.txtdgfPrice.setVisible(true);		
        this.txtdgfPrice.setHorizontalAlignment(2);		
        this.txtdgfPrice.setDataType(1);		
        this.txtdgfPrice.setSupportedEmpty(true);		
        this.txtdgfPrice.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtdgfPrice.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtdgfPrice.setPrecision(10);		
        this.txtdgfPrice.setRequired(false);
        // txtxgmPrice		
        this.txtxgmPrice.setVisible(true);		
        this.txtxgmPrice.setHorizontalAlignment(2);		
        this.txtxgmPrice.setDataType(1);		
        this.txtxgmPrice.setSupportedEmpty(true);		
        this.txtxgmPrice.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtxgmPrice.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtxgmPrice.setPrecision(10);		
        this.txtxgmPrice.setRequired(false);
        // txtdgmPrice		
        this.txtdgmPrice.setVisible(true);		
        this.txtdgmPrice.setHorizontalAlignment(2);		
        this.txtdgmPrice.setDataType(1);		
        this.txtdgmPrice.setSupportedEmpty(true);		
        this.txtdgmPrice.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtdgmPrice.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtdgmPrice.setPrecision(10);		
        this.txtdgmPrice.setRequired(false);
        // txtzzpro		
        this.txtzzpro.setVisible(true);		
        this.txtzzpro.setHorizontalAlignment(2);		
        this.txtzzpro.setDataType(1);		
        this.txtzzpro.setSupportedEmpty(true);		
        this.txtzzpro.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtzzpro.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtzzpro.setPrecision(10);		
        this.txtzzpro.setRequired(false);
        // txtgdjzpro		
        this.txtgdjzpro.setVisible(true);		
        this.txtgdjzpro.setHorizontalAlignment(2);		
        this.txtgdjzpro.setDataType(1);		
        this.txtgdjzpro.setSupportedEmpty(true);		
        this.txtgdjzpro.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtgdjzpro.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtgdjzpro.setPrecision(10);		
        this.txtgdjzpro.setRequired(false);
        // txtyxjzpro		
        this.txtyxjzpro.setVisible(true);		
        this.txtyxjzpro.setHorizontalAlignment(2);		
        this.txtyxjzpro.setDataType(1);		
        this.txtyxjzpro.setSupportedEmpty(true);		
        this.txtyxjzpro.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtyxjzpro.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtyxjzpro.setPrecision(10);		
        this.txtyxjzpro.setRequired(false);
        // txtyzpro		
        this.txtyzpro.setVisible(true);		
        this.txtyzpro.setHorizontalAlignment(2);		
        this.txtyzpro.setDataType(1);		
        this.txtyzpro.setSupportedEmpty(true);		
        this.txtyzpro.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtyzpro.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtyzpro.setPrecision(10);		
        this.txtyzpro.setRequired(false);
        // txtknwpro		
        this.txtknwpro.setVisible(true);		
        this.txtknwpro.setHorizontalAlignment(2);		
        this.txtknwpro.setDataType(1);		
        this.txtknwpro.setSupportedEmpty(true);		
        this.txtknwpro.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtknwpro.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtknwpro.setPrecision(10);		
        this.txtknwpro.setRequired(false);
        // txtmbpro		
        this.txtmbpro.setVisible(true);		
        this.txtmbpro.setHorizontalAlignment(2);		
        this.txtmbpro.setDataType(1);		
        this.txtmbpro.setSupportedEmpty(true);		
        this.txtmbpro.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtmbpro.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtmbpro.setPrecision(10);		
        this.txtmbpro.setRequired(false);
        // txtxhpro		
        this.txtxhpro.setVisible(true);		
        this.txtxhpro.setHorizontalAlignment(2);		
        this.txtxhpro.setDataType(1);		
        this.txtxhpro.setSupportedEmpty(true);		
        this.txtxhpro.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtxhpro.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtxhpro.setPrecision(10);		
        this.txtxhpro.setRequired(false);
        // txteypro		
        this.txteypro.setVisible(true);		
        this.txteypro.setHorizontalAlignment(2);		
        this.txteypro.setDataType(1);		
        this.txteypro.setSupportedEmpty(true);		
        this.txteypro.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txteypro.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txteypro.setPrecision(10);		
        this.txteypro.setRequired(false);
        // txtzjPro		
        this.txtzjPro.setVisible(true);		
        this.txtzjPro.setHorizontalAlignment(2);		
        this.txtzjPro.setDataType(1);		
        this.txtzjPro.setSupportedEmpty(true);		
        this.txtzjPro.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtzjPro.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtzjPro.setPrecision(10);		
        this.txtzjPro.setRequired(false);
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {txtdocNumber,txtdocName,txtgdzztPrice,txtzdzztPrice,txtddzztPrice,txtntPrice,txtwtPrice,txtgjyPrice,txtxgfPrice,txtdgfPrice,txtxgmPrice,txtdgmPrice,txtzzpro,txtgdjzpro,txtyxjzpro,txtyzpro,txtknwpro,txtmbpro,txtxhpro,txteypro,txtzjPro}));
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
        kDLabelContainer1.setBounds(new Rectangle(10, 202, 270, 19));
        this.add(kDLabelContainer1, null);
        kDLabelContainer2.setBounds(new Rectangle(10, 178, 270, 19));
        this.add(kDLabelContainer2, null);
        kDLabelContainer3.setBounds(new Rectangle(341, 178, 270, 19));
        this.add(kDLabelContainer3, null);
        kDLabelContainer4.setBounds(new Rectangle(672, 178, 270, 19));
        this.add(kDLabelContainer4, null);
        contdocNumber.setBounds(new Rectangle(10, 10, 270, 19));
        this.add(contdocNumber, null);
        contdocName.setBounds(new Rectangle(341, 10, 270, 19));
        this.add(contdocName, null);
        contgdzztPrice.setBounds(new Rectangle(672, 10, 270, 19));
        this.add(contgdzztPrice, null);
        contzdzztPrice.setBounds(new Rectangle(10, 34, 270, 19));
        this.add(contzdzztPrice, null);
        contddzztPrice.setBounds(new Rectangle(341, 34, 270, 19));
        this.add(contddzztPrice, null);
        contntPrice.setBounds(new Rectangle(672, 34, 270, 19));
        this.add(contntPrice, null);
        contwtPrice.setBounds(new Rectangle(10, 58, 270, 19));
        this.add(contwtPrice, null);
        contgjyPrice.setBounds(new Rectangle(341, 58, 270, 19));
        this.add(contgjyPrice, null);
        contxgfPrice.setBounds(new Rectangle(672, 58, 270, 19));
        this.add(contxgfPrice, null);
        contdgfPrice.setBounds(new Rectangle(10, 82, 270, 19));
        this.add(contdgfPrice, null);
        contxgmPrice.setBounds(new Rectangle(341, 82, 270, 19));
        this.add(contxgmPrice, null);
        contdgmPrice.setBounds(new Rectangle(672, 82, 270, 19));
        this.add(contdgmPrice, null);
        contzzpro.setBounds(new Rectangle(10, 106, 270, 19));
        this.add(contzzpro, null);
        contgdjzpro.setBounds(new Rectangle(341, 106, 270, 19));
        this.add(contgdjzpro, null);
        contyxjzpro.setBounds(new Rectangle(672, 106, 270, 19));
        this.add(contyxjzpro, null);
        contyzpro.setBounds(new Rectangle(10, 130, 270, 19));
        this.add(contyzpro, null);
        contknwpro.setBounds(new Rectangle(341, 130, 270, 19));
        this.add(contknwpro, null);
        contmbpro.setBounds(new Rectangle(672, 130, 270, 19));
        this.add(contmbpro, null);
        contxhpro.setBounds(new Rectangle(10, 154, 270, 19));
        this.add(contxhpro, null);
        conteypro.setBounds(new Rectangle(341, 154, 270, 19));
        this.add(conteypro, null);
        contzjPro.setBounds(new Rectangle(672, 154, 270, 19));
        this.add(contzjPro, null);
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
        //contgdzztPrice
        contgdzztPrice.setBoundEditor(txtgdzztPrice);
        //contzdzztPrice
        contzdzztPrice.setBoundEditor(txtzdzztPrice);
        //contddzztPrice
        contddzztPrice.setBoundEditor(txtddzztPrice);
        //contntPrice
        contntPrice.setBoundEditor(txtntPrice);
        //contwtPrice
        contwtPrice.setBoundEditor(txtwtPrice);
        //contgjyPrice
        contgjyPrice.setBoundEditor(txtgjyPrice);
        //contxgfPrice
        contxgfPrice.setBoundEditor(txtxgfPrice);
        //contdgfPrice
        contdgfPrice.setBoundEditor(txtdgfPrice);
        //contxgmPrice
        contxgmPrice.setBoundEditor(txtxgmPrice);
        //contdgmPrice
        contdgmPrice.setBoundEditor(txtdgmPrice);
        //contzzpro
        contzzpro.setBoundEditor(txtzzpro);
        //contgdjzpro
        contgdjzpro.setBoundEditor(txtgdjzpro);
        //contyxjzpro
        contyxjzpro.setBoundEditor(txtyxjzpro);
        //contyzpro
        contyzpro.setBoundEditor(txtyzpro);
        //contknwpro
        contknwpro.setBoundEditor(txtknwpro);
        //contmbpro
        contmbpro.setBoundEditor(txtmbpro);
        //contxhpro
        contxhpro.setBoundEditor(txtxhpro);
        //conteypro
        conteypro.setBoundEditor(txteypro);
        //contzjPro
        contzjPro.setBoundEditor(txtzjPro);

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
		dataBinder.registerBinding("docNumber", String.class, this.txtdocNumber, "text");
		dataBinder.registerBinding("docName", String.class, this.txtdocName, "text");
		dataBinder.registerBinding("gdzztPrice", java.math.BigDecimal.class, this.txtgdzztPrice, "value");
		dataBinder.registerBinding("zdzztPrice", java.math.BigDecimal.class, this.txtzdzztPrice, "value");
		dataBinder.registerBinding("ddzztPrice", java.math.BigDecimal.class, this.txtddzztPrice, "value");
		dataBinder.registerBinding("ntPrice", java.math.BigDecimal.class, this.txtntPrice, "value");
		dataBinder.registerBinding("wtPrice", java.math.BigDecimal.class, this.txtwtPrice, "value");
		dataBinder.registerBinding("gjyPrice", java.math.BigDecimal.class, this.txtgjyPrice, "value");
		dataBinder.registerBinding("xgfPrice", java.math.BigDecimal.class, this.txtxgfPrice, "value");
		dataBinder.registerBinding("dgfPrice", java.math.BigDecimal.class, this.txtdgfPrice, "value");
		dataBinder.registerBinding("xgmPrice", java.math.BigDecimal.class, this.txtxgmPrice, "value");
		dataBinder.registerBinding("dgmPrice", java.math.BigDecimal.class, this.txtdgmPrice, "value");
		dataBinder.registerBinding("zzpro", java.math.BigDecimal.class, this.txtzzpro, "value");
		dataBinder.registerBinding("gdjzpro", java.math.BigDecimal.class, this.txtgdjzpro, "value");
		dataBinder.registerBinding("yxjzpro", java.math.BigDecimal.class, this.txtyxjzpro, "value");
		dataBinder.registerBinding("yzpro", java.math.BigDecimal.class, this.txtyzpro, "value");
		dataBinder.registerBinding("knwpro", java.math.BigDecimal.class, this.txtknwpro, "value");
		dataBinder.registerBinding("mbpro", java.math.BigDecimal.class, this.txtmbpro, "value");
		dataBinder.registerBinding("xhpro", java.math.BigDecimal.class, this.txtxhpro, "value");
		dataBinder.registerBinding("eypro", java.math.BigDecimal.class, this.txteypro, "value");
		dataBinder.registerBinding("zjPro", java.math.BigDecimal.class, this.txtzjPro, "value");		
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
	    return "com.kingdee.eas.mw.pay.app.SpePartTimeDocProEditUIHandler";
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
        this.editData = (com.kingdee.eas.mw.pay.SpePartTimeDocProInfo)ov;
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
		getValidateHelper().registerBindProperty("docNumber", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("docName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("gdzztPrice", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("zdzztPrice", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("ddzztPrice", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("ntPrice", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("wtPrice", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("gjyPrice", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("xgfPrice", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("dgfPrice", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("xgmPrice", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("dgmPrice", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("zzpro", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("gdjzpro", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("yxjzpro", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("yzpro", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("knwpro", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("mbpro", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("xhpro", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("eypro", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("zjPro", ValidateHelper.ON_SAVE);    		
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
        sic.add(new SelectorItemInfo("docNumber"));
        sic.add(new SelectorItemInfo("docName"));
        sic.add(new SelectorItemInfo("gdzztPrice"));
        sic.add(new SelectorItemInfo("zdzztPrice"));
        sic.add(new SelectorItemInfo("ddzztPrice"));
        sic.add(new SelectorItemInfo("ntPrice"));
        sic.add(new SelectorItemInfo("wtPrice"));
        sic.add(new SelectorItemInfo("gjyPrice"));
        sic.add(new SelectorItemInfo("xgfPrice"));
        sic.add(new SelectorItemInfo("dgfPrice"));
        sic.add(new SelectorItemInfo("xgmPrice"));
        sic.add(new SelectorItemInfo("dgmPrice"));
        sic.add(new SelectorItemInfo("zzpro"));
        sic.add(new SelectorItemInfo("gdjzpro"));
        sic.add(new SelectorItemInfo("yxjzpro"));
        sic.add(new SelectorItemInfo("yzpro"));
        sic.add(new SelectorItemInfo("knwpro"));
        sic.add(new SelectorItemInfo("mbpro"));
        sic.add(new SelectorItemInfo("xhpro"));
        sic.add(new SelectorItemInfo("eypro"));
        sic.add(new SelectorItemInfo("zjPro"));
        return sic;
    }        

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.mw.pay.client", "SpePartTimeDocProEditUI");
    }

    /**
     * output getEditUIName method
     */
    protected String getEditUIName()
    {
        return com.kingdee.eas.mw.pay.client.SpePartTimeDocProEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.mw.pay.SpePartTimeDocProFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.mw.pay.SpePartTimeDocProInfo objectValue = new com.kingdee.eas.mw.pay.SpePartTimeDocProInfo();
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