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
public abstract class AbstractPartTimeDocProEditUI extends com.kingdee.eas.framework.client.EditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractPartTimeDocProEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer2;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer3;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer4;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contdocNumber;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contzjpro;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbyzzPro;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbygdjzPro;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbyyzPro;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbyyxjzPro;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbyknwPro;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbymbPro;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbyxfPro;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbyeyPro;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contzzPro;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contgdjzPro;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contyxjzPro;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contzyPro;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contknwPro;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contmbPro;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contzfPro;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conteyPro;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contdocName;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcityNumber;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcityName;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcity;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbusinessDate;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox txtName;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtSimpleName;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox txtDescription;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtdocNumber;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtzjpro;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtbyzzPro;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtbygdjzPro;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtbyyzPro;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtbyyxjzPro;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtbyknwPro;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtbymbPro;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtbyxfPro;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtbyeyPro;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtzzPro;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtgdjzPro;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtyxjzPro;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtzyPro;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtknwPro;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtmbPro;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtzfPro;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txteyPro;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtdocName;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtcityNumber;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtcityName;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcity;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtbusinessDate;
    protected com.kingdee.eas.mw.pay.PartTimeDocProInfo editData = null;
    /**
     * output class constructor
     */
    public AbstractPartTimeDocProEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractPartTimeDocProEditUI.class.getName());
        this.setUITitle(resHelper.getString("this.title"));
        this.kDLabelContainer1 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer2 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer3 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer4 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contdocNumber = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contzjpro = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbyzzPro = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbygdjzPro = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbyyzPro = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbyyxjzPro = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbyknwPro = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbymbPro = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbyxfPro = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbyeyPro = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contzzPro = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contgdjzPro = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contyxjzPro = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contzyPro = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contknwPro = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contmbPro = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contzfPro = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conteyPro = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contdocName = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcityNumber = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcityName = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcity = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbusinessDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtName = new com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox();
        this.txtSimpleName = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtDescription = new com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox();
        this.txtdocNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtzjpro = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtbyzzPro = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtbygdjzPro = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtbyyzPro = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtbyyxjzPro = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtbyknwPro = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtbymbPro = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtbyxfPro = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtbyeyPro = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtzzPro = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtgdjzPro = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtyxjzPro = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtzyPro = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtknwPro = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtmbPro = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtzfPro = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txteyPro = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtdocName = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtcityNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtcityName = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtcity = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtbusinessDate = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.kDLabelContainer1.setName("kDLabelContainer1");
        this.kDLabelContainer2.setName("kDLabelContainer2");
        this.kDLabelContainer3.setName("kDLabelContainer3");
        this.kDLabelContainer4.setName("kDLabelContainer4");
        this.contdocNumber.setName("contdocNumber");
        this.contzjpro.setName("contzjpro");
        this.contbyzzPro.setName("contbyzzPro");
        this.contbygdjzPro.setName("contbygdjzPro");
        this.contbyyzPro.setName("contbyyzPro");
        this.contbyyxjzPro.setName("contbyyxjzPro");
        this.contbyknwPro.setName("contbyknwPro");
        this.contbymbPro.setName("contbymbPro");
        this.contbyxfPro.setName("contbyxfPro");
        this.contbyeyPro.setName("contbyeyPro");
        this.contzzPro.setName("contzzPro");
        this.contgdjzPro.setName("contgdjzPro");
        this.contyxjzPro.setName("contyxjzPro");
        this.contzyPro.setName("contzyPro");
        this.contknwPro.setName("contknwPro");
        this.contmbPro.setName("contmbPro");
        this.contzfPro.setName("contzfPro");
        this.conteyPro.setName("conteyPro");
        this.contdocName.setName("contdocName");
        this.contcityNumber.setName("contcityNumber");
        this.contcityName.setName("contcityName");
        this.contcity.setName("contcity");
        this.contbusinessDate.setName("contbusinessDate");
        this.txtNumber.setName("txtNumber");
        this.txtName.setName("txtName");
        this.txtSimpleName.setName("txtSimpleName");
        this.txtDescription.setName("txtDescription");
        this.txtdocNumber.setName("txtdocNumber");
        this.txtzjpro.setName("txtzjpro");
        this.txtbyzzPro.setName("txtbyzzPro");
        this.txtbygdjzPro.setName("txtbygdjzPro");
        this.txtbyyzPro.setName("txtbyyzPro");
        this.txtbyyxjzPro.setName("txtbyyxjzPro");
        this.txtbyknwPro.setName("txtbyknwPro");
        this.txtbymbPro.setName("txtbymbPro");
        this.txtbyxfPro.setName("txtbyxfPro");
        this.txtbyeyPro.setName("txtbyeyPro");
        this.txtzzPro.setName("txtzzPro");
        this.txtgdjzPro.setName("txtgdjzPro");
        this.txtyxjzPro.setName("txtyxjzPro");
        this.txtzyPro.setName("txtzyPro");
        this.txtknwPro.setName("txtknwPro");
        this.txtmbPro.setName("txtmbPro");
        this.txtzfPro.setName("txtzfPro");
        this.txteyPro.setName("txteyPro");
        this.txtdocName.setName("txtdocName");
        this.txtcityNumber.setName("txtcityNumber");
        this.txtcityName.setName("txtcityName");
        this.prmtcity.setName("prmtcity");
        this.txtbusinessDate.setName("txtbusinessDate");
        // CoreUI		
        this.btnPrint.setVisible(false);		
        this.btnPrintPreview.setVisible(false);		
        this.menuItemPrint.setVisible(false);		
        this.menuItemPrintPreview.setVisible(false);
        // kDLabelContainer1		
        this.kDLabelContainer1.setBoundLabelText(resHelper.getString("kDLabelContainer1.boundLabelText"));		
        this.kDLabelContainer1.setBoundLabelLength(130);		
        this.kDLabelContainer1.setBoundLabelUnderline(true);		
        this.kDLabelContainer1.setVisible(false);
        // kDLabelContainer2		
        this.kDLabelContainer2.setBoundLabelText(resHelper.getString("kDLabelContainer2.boundLabelText"));		
        this.kDLabelContainer2.setBoundLabelLength(130);		
        this.kDLabelContainer2.setBoundLabelUnderline(true);		
        this.kDLabelContainer2.setVisible(false);
        // kDLabelContainer3		
        this.kDLabelContainer3.setBoundLabelText(resHelper.getString("kDLabelContainer3.boundLabelText"));		
        this.kDLabelContainer3.setBoundLabelLength(130);		
        this.kDLabelContainer3.setBoundLabelUnderline(true);		
        this.kDLabelContainer3.setVisible(false);
        // kDLabelContainer4		
        this.kDLabelContainer4.setBoundLabelText(resHelper.getString("kDLabelContainer4.boundLabelText"));		
        this.kDLabelContainer4.setBoundLabelLength(130);		
        this.kDLabelContainer4.setBoundLabelUnderline(true);		
        this.kDLabelContainer4.setBoundLabelAlignment(7);		
        this.kDLabelContainer4.setVisible(false);
        // contdocNumber		
        this.contdocNumber.setBoundLabelText(resHelper.getString("contdocNumber.boundLabelText"));		
        this.contdocNumber.setBoundLabelLength(130);		
        this.contdocNumber.setBoundLabelUnderline(true);		
        this.contdocNumber.setVisible(true);
        // contzjpro		
        this.contzjpro.setBoundLabelText(resHelper.getString("contzjpro.boundLabelText"));		
        this.contzjpro.setBoundLabelLength(130);		
        this.contzjpro.setBoundLabelUnderline(true);		
        this.contzjpro.setVisible(true);
        // contbyzzPro		
        this.contbyzzPro.setBoundLabelText(resHelper.getString("contbyzzPro.boundLabelText"));		
        this.contbyzzPro.setBoundLabelLength(130);		
        this.contbyzzPro.setBoundLabelUnderline(true);		
        this.contbyzzPro.setVisible(true);
        // contbygdjzPro		
        this.contbygdjzPro.setBoundLabelText(resHelper.getString("contbygdjzPro.boundLabelText"));		
        this.contbygdjzPro.setBoundLabelLength(130);		
        this.contbygdjzPro.setBoundLabelUnderline(true);		
        this.contbygdjzPro.setVisible(true);
        // contbyyzPro		
        this.contbyyzPro.setBoundLabelText(resHelper.getString("contbyyzPro.boundLabelText"));		
        this.contbyyzPro.setBoundLabelLength(130);		
        this.contbyyzPro.setBoundLabelUnderline(true);		
        this.contbyyzPro.setVisible(true);
        // contbyyxjzPro		
        this.contbyyxjzPro.setBoundLabelText(resHelper.getString("contbyyxjzPro.boundLabelText"));		
        this.contbyyxjzPro.setBoundLabelLength(130);		
        this.contbyyxjzPro.setBoundLabelUnderline(true);		
        this.contbyyxjzPro.setVisible(true);
        // contbyknwPro		
        this.contbyknwPro.setBoundLabelText(resHelper.getString("contbyknwPro.boundLabelText"));		
        this.contbyknwPro.setBoundLabelLength(130);		
        this.contbyknwPro.setBoundLabelUnderline(true);		
        this.contbyknwPro.setVisible(true);
        // contbymbPro		
        this.contbymbPro.setBoundLabelText(resHelper.getString("contbymbPro.boundLabelText"));		
        this.contbymbPro.setBoundLabelLength(130);		
        this.contbymbPro.setBoundLabelUnderline(true);		
        this.contbymbPro.setVisible(true);
        // contbyxfPro		
        this.contbyxfPro.setBoundLabelText(resHelper.getString("contbyxfPro.boundLabelText"));		
        this.contbyxfPro.setBoundLabelLength(130);		
        this.contbyxfPro.setBoundLabelUnderline(true);		
        this.contbyxfPro.setVisible(true);
        // contbyeyPro		
        this.contbyeyPro.setBoundLabelText(resHelper.getString("contbyeyPro.boundLabelText"));		
        this.contbyeyPro.setBoundLabelLength(130);		
        this.contbyeyPro.setBoundLabelUnderline(true);		
        this.contbyeyPro.setVisible(true);
        // contzzPro		
        this.contzzPro.setBoundLabelText(resHelper.getString("contzzPro.boundLabelText"));		
        this.contzzPro.setBoundLabelLength(130);		
        this.contzzPro.setBoundLabelUnderline(true);		
        this.contzzPro.setVisible(true);
        // contgdjzPro		
        this.contgdjzPro.setBoundLabelText(resHelper.getString("contgdjzPro.boundLabelText"));		
        this.contgdjzPro.setBoundLabelLength(130);		
        this.contgdjzPro.setBoundLabelUnderline(true);		
        this.contgdjzPro.setVisible(true);
        // contyxjzPro		
        this.contyxjzPro.setBoundLabelText(resHelper.getString("contyxjzPro.boundLabelText"));		
        this.contyxjzPro.setBoundLabelLength(130);		
        this.contyxjzPro.setBoundLabelUnderline(true);		
        this.contyxjzPro.setVisible(true);
        // contzyPro		
        this.contzyPro.setBoundLabelText(resHelper.getString("contzyPro.boundLabelText"));		
        this.contzyPro.setBoundLabelLength(130);		
        this.contzyPro.setBoundLabelUnderline(true);		
        this.contzyPro.setVisible(true);
        // contknwPro		
        this.contknwPro.setBoundLabelText(resHelper.getString("contknwPro.boundLabelText"));		
        this.contknwPro.setBoundLabelLength(130);		
        this.contknwPro.setBoundLabelUnderline(true);		
        this.contknwPro.setVisible(true);
        // contmbPro		
        this.contmbPro.setBoundLabelText(resHelper.getString("contmbPro.boundLabelText"));		
        this.contmbPro.setBoundLabelLength(130);		
        this.contmbPro.setBoundLabelUnderline(true);		
        this.contmbPro.setVisible(true);
        // contzfPro		
        this.contzfPro.setBoundLabelText(resHelper.getString("contzfPro.boundLabelText"));		
        this.contzfPro.setBoundLabelLength(130);		
        this.contzfPro.setBoundLabelUnderline(true);		
        this.contzfPro.setVisible(true);
        // conteyPro		
        this.conteyPro.setBoundLabelText(resHelper.getString("conteyPro.boundLabelText"));		
        this.conteyPro.setBoundLabelLength(130);		
        this.conteyPro.setBoundLabelUnderline(true);		
        this.conteyPro.setVisible(true);
        // contdocName		
        this.contdocName.setBoundLabelText(resHelper.getString("contdocName.boundLabelText"));		
        this.contdocName.setBoundLabelLength(130);		
        this.contdocName.setBoundLabelUnderline(true);		
        this.contdocName.setVisible(true);
        // contcityNumber		
        this.contcityNumber.setBoundLabelText(resHelper.getString("contcityNumber.boundLabelText"));		
        this.contcityNumber.setBoundLabelLength(130);		
        this.contcityNumber.setBoundLabelUnderline(true);		
        this.contcityNumber.setVisible(true);
        // contcityName		
        this.contcityName.setBoundLabelText(resHelper.getString("contcityName.boundLabelText"));		
        this.contcityName.setBoundLabelLength(130);		
        this.contcityName.setBoundLabelUnderline(true);		
        this.contcityName.setVisible(true);
        // contcity		
        this.contcity.setBoundLabelText(resHelper.getString("contcity.boundLabelText"));		
        this.contcity.setBoundLabelLength(130);		
        this.contcity.setBoundLabelUnderline(true);		
        this.contcity.setVisible(true);
        // contbusinessDate		
        this.contbusinessDate.setBoundLabelText(resHelper.getString("contbusinessDate.boundLabelText"));		
        this.contbusinessDate.setBoundLabelLength(100);		
        this.contbusinessDate.setBoundLabelUnderline(true);		
        this.contbusinessDate.setVisible(true);
        // txtNumber		
        this.txtNumber.setMaxLength(80);		
        this.txtNumber.setEnabled(false);		
        this.txtNumber.setVisible(false);		
        this.txtNumber.setOpaque(false);
        // txtName		
        this.txtName.setOpaque(false);		
        this.txtName.setVisible(false);		
        this.txtName.setEnabled(false);
        // txtSimpleName		
        this.txtSimpleName.setMaxLength(80);		
        this.txtSimpleName.setEnabled(false);		
        this.txtSimpleName.setVisible(false);		
        this.txtSimpleName.setOpaque(false);
        // txtDescription		
        this.txtDescription.setEnabled(false);		
        this.txtDescription.setOpaque(false);		
        this.txtDescription.setVisible(false);
        // txtdocNumber		
        this.txtdocNumber.setVisible(true);		
        this.txtdocNumber.setHorizontalAlignment(2);		
        this.txtdocNumber.setMaxLength(100);		
        this.txtdocNumber.setRequired(false);
        // txtzjpro		
        this.txtzjpro.setVisible(true);		
        this.txtzjpro.setHorizontalAlignment(2);		
        this.txtzjpro.setDataType(1);		
        this.txtzjpro.setSupportedEmpty(true);		
        this.txtzjpro.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtzjpro.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtzjpro.setPrecision(10);		
        this.txtzjpro.setRequired(false);
        // txtbyzzPro		
        this.txtbyzzPro.setVisible(true);		
        this.txtbyzzPro.setHorizontalAlignment(2);		
        this.txtbyzzPro.setDataType(1);		
        this.txtbyzzPro.setSupportedEmpty(true);		
        this.txtbyzzPro.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtbyzzPro.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtbyzzPro.setPrecision(10);		
        this.txtbyzzPro.setRequired(false);
        // txtbygdjzPro		
        this.txtbygdjzPro.setVisible(true);		
        this.txtbygdjzPro.setHorizontalAlignment(2);		
        this.txtbygdjzPro.setDataType(1);		
        this.txtbygdjzPro.setSupportedEmpty(true);		
        this.txtbygdjzPro.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtbygdjzPro.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtbygdjzPro.setPrecision(10);		
        this.txtbygdjzPro.setRequired(false);
        // txtbyyzPro		
        this.txtbyyzPro.setVisible(true);		
        this.txtbyyzPro.setHorizontalAlignment(2);		
        this.txtbyyzPro.setDataType(1);		
        this.txtbyyzPro.setSupportedEmpty(true);		
        this.txtbyyzPro.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtbyyzPro.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtbyyzPro.setPrecision(10);		
        this.txtbyyzPro.setRequired(false);
        // txtbyyxjzPro		
        this.txtbyyxjzPro.setVisible(true);		
        this.txtbyyxjzPro.setHorizontalAlignment(2);		
        this.txtbyyxjzPro.setDataType(1);		
        this.txtbyyxjzPro.setSupportedEmpty(true);		
        this.txtbyyxjzPro.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtbyyxjzPro.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtbyyxjzPro.setPrecision(10);		
        this.txtbyyxjzPro.setRequired(false);
        // txtbyknwPro		
        this.txtbyknwPro.setVisible(true);		
        this.txtbyknwPro.setHorizontalAlignment(2);		
        this.txtbyknwPro.setDataType(1);		
        this.txtbyknwPro.setSupportedEmpty(true);		
        this.txtbyknwPro.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtbyknwPro.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtbyknwPro.setPrecision(10);		
        this.txtbyknwPro.setRequired(false);
        // txtbymbPro		
        this.txtbymbPro.setVisible(true);		
        this.txtbymbPro.setHorizontalAlignment(2);		
        this.txtbymbPro.setDataType(1);		
        this.txtbymbPro.setSupportedEmpty(true);		
        this.txtbymbPro.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtbymbPro.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtbymbPro.setPrecision(10);		
        this.txtbymbPro.setRequired(false);
        // txtbyxfPro		
        this.txtbyxfPro.setVisible(true);		
        this.txtbyxfPro.setHorizontalAlignment(2);		
        this.txtbyxfPro.setDataType(1);		
        this.txtbyxfPro.setSupportedEmpty(true);		
        this.txtbyxfPro.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtbyxfPro.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtbyxfPro.setPrecision(10);		
        this.txtbyxfPro.setRequired(false);
        // txtbyeyPro		
        this.txtbyeyPro.setVisible(true);		
        this.txtbyeyPro.setHorizontalAlignment(2);		
        this.txtbyeyPro.setDataType(1);		
        this.txtbyeyPro.setSupportedEmpty(true);		
        this.txtbyeyPro.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtbyeyPro.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtbyeyPro.setPrecision(10);		
        this.txtbyeyPro.setRequired(false);
        // txtzzPro		
        this.txtzzPro.setVisible(true);		
        this.txtzzPro.setHorizontalAlignment(2);		
        this.txtzzPro.setDataType(1);		
        this.txtzzPro.setSupportedEmpty(true);		
        this.txtzzPro.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtzzPro.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtzzPro.setPrecision(10);		
        this.txtzzPro.setRequired(false);
        // txtgdjzPro		
        this.txtgdjzPro.setVisible(true);		
        this.txtgdjzPro.setHorizontalAlignment(2);		
        this.txtgdjzPro.setDataType(1);		
        this.txtgdjzPro.setSupportedEmpty(true);		
        this.txtgdjzPro.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtgdjzPro.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtgdjzPro.setPrecision(10);		
        this.txtgdjzPro.setRequired(false);
        // txtyxjzPro		
        this.txtyxjzPro.setVisible(true);		
        this.txtyxjzPro.setHorizontalAlignment(2);		
        this.txtyxjzPro.setDataType(1);		
        this.txtyxjzPro.setSupportedEmpty(true);		
        this.txtyxjzPro.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtyxjzPro.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtyxjzPro.setPrecision(10);		
        this.txtyxjzPro.setRequired(false);
        // txtzyPro		
        this.txtzyPro.setVisible(true);		
        this.txtzyPro.setHorizontalAlignment(2);		
        this.txtzyPro.setDataType(1);		
        this.txtzyPro.setSupportedEmpty(true);		
        this.txtzyPro.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtzyPro.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtzyPro.setPrecision(10);		
        this.txtzyPro.setRequired(false);
        // txtknwPro		
        this.txtknwPro.setVisible(true);		
        this.txtknwPro.setHorizontalAlignment(2);		
        this.txtknwPro.setDataType(1);		
        this.txtknwPro.setSupportedEmpty(true);		
        this.txtknwPro.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtknwPro.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtknwPro.setPrecision(10);		
        this.txtknwPro.setRequired(false);
        // txtmbPro		
        this.txtmbPro.setVisible(true);		
        this.txtmbPro.setHorizontalAlignment(2);		
        this.txtmbPro.setDataType(1);		
        this.txtmbPro.setSupportedEmpty(true);		
        this.txtmbPro.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtmbPro.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtmbPro.setPrecision(10);		
        this.txtmbPro.setRequired(false);
        // txtzfPro		
        this.txtzfPro.setVisible(true);		
        this.txtzfPro.setHorizontalAlignment(2);		
        this.txtzfPro.setDataType(1);		
        this.txtzfPro.setSupportedEmpty(true);		
        this.txtzfPro.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtzfPro.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtzfPro.setPrecision(10);		
        this.txtzfPro.setRequired(false);
        // txteyPro		
        this.txteyPro.setVisible(true);		
        this.txteyPro.setHorizontalAlignment(2);		
        this.txteyPro.setDataType(1);		
        this.txteyPro.setSupportedEmpty(true);		
        this.txteyPro.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txteyPro.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txteyPro.setPrecision(10);		
        this.txteyPro.setRequired(false);
        // txtdocName		
        this.txtdocName.setVisible(true);		
        this.txtdocName.setHorizontalAlignment(2);		
        this.txtdocName.setMaxLength(100);		
        this.txtdocName.setRequired(false);
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
        // txtbusinessDate		
        this.txtbusinessDate.setVisible(true);		
        this.txtbusinessDate.setHorizontalAlignment(2);		
        this.txtbusinessDate.setMaxLength(100);		
        this.txtbusinessDate.setRequired(false);
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {txtdocNumber,txtbyzzPro,txtzzPro,txtzjpro,txtbygdjzPro,txtbyyxjzPro,txtbyyzPro,txtbyknwPro,txtbymbPro,txtbyxfPro,txtbyeyPro,txtgdjzPro,txtyxjzPro,txtzyPro,txtknwPro,txtmbPro,txtzfPro,txteyPro,txtdocName,txtcityNumber,txtcityName,prmtcity,txtbusinessDate}));
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
        kDLabelContainer1.setBounds(new Rectangle(672, 130, 270, 19));
        this.add(kDLabelContainer1, null);
        kDLabelContainer2.setBounds(new Rectangle(672, 154, 270, 19));
        this.add(kDLabelContainer2, null);
        kDLabelContainer3.setBounds(new Rectangle(341, 178, 270, 19));
        this.add(kDLabelContainer3, null);
        kDLabelContainer4.setBounds(new Rectangle(672, 178, 270, 19));
        this.add(kDLabelContainer4, null);
        contdocNumber.setBounds(new Rectangle(672, 10, 270, 19));
        this.add(contdocNumber, null);
        contzjpro.setBounds(new Rectangle(10, 178, 270, 19));
        this.add(contzjpro, null);
        contbyzzPro.setBounds(new Rectangle(341, 10, 270, 19));
        this.add(contbyzzPro, null);
        contbygdjzPro.setBounds(new Rectangle(341, 34, 270, 19));
        this.add(contbygdjzPro, null);
        contbyyzPro.setBounds(new Rectangle(672, 34, 270, 19));
        this.add(contbyyzPro, null);
        contbyyxjzPro.setBounds(new Rectangle(10, 58, 270, 19));
        this.add(contbyyxjzPro, null);
        contbyknwPro.setBounds(new Rectangle(341, 58, 270, 19));
        this.add(contbyknwPro, null);
        contbymbPro.setBounds(new Rectangle(672, 58, 270, 19));
        this.add(contbymbPro, null);
        contbyxfPro.setBounds(new Rectangle(10, 82, 270, 19));
        this.add(contbyxfPro, null);
        contbyeyPro.setBounds(new Rectangle(341, 82, 270, 19));
        this.add(contbyeyPro, null);
        contzzPro.setBounds(new Rectangle(672, 82, 270, 19));
        this.add(contzzPro, null);
        contgdjzPro.setBounds(new Rectangle(10, 106, 270, 19));
        this.add(contgdjzPro, null);
        contyxjzPro.setBounds(new Rectangle(341, 106, 270, 19));
        this.add(contyxjzPro, null);
        contzyPro.setBounds(new Rectangle(672, 106, 270, 19));
        this.add(contzyPro, null);
        contknwPro.setBounds(new Rectangle(10, 130, 270, 19));
        this.add(contknwPro, null);
        contmbPro.setBounds(new Rectangle(341, 130, 270, 19));
        this.add(contmbPro, null);
        contzfPro.setBounds(new Rectangle(10, 154, 270, 19));
        this.add(contzfPro, null);
        conteyPro.setBounds(new Rectangle(341, 154, 270, 19));
        this.add(conteyPro, null);
        contdocName.setBounds(new Rectangle(10, 34, 270, 19));
        this.add(contdocName, null);
        contcityNumber.setBounds(new Rectangle(10, 202, 270, 19));
        this.add(contcityNumber, null);
        contcityName.setBounds(new Rectangle(341, 202, 270, 19));
        this.add(contcityName, null);
        contcity.setBounds(new Rectangle(10, 10, 270, 19));
        this.add(contcity, null);
        contbusinessDate.setBounds(new Rectangle(672, 202, 270, 19));
        this.add(contbusinessDate, null);
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
        //contzjpro
        contzjpro.setBoundEditor(txtzjpro);
        //contbyzzPro
        contbyzzPro.setBoundEditor(txtbyzzPro);
        //contbygdjzPro
        contbygdjzPro.setBoundEditor(txtbygdjzPro);
        //contbyyzPro
        contbyyzPro.setBoundEditor(txtbyyzPro);
        //contbyyxjzPro
        contbyyxjzPro.setBoundEditor(txtbyyxjzPro);
        //contbyknwPro
        contbyknwPro.setBoundEditor(txtbyknwPro);
        //contbymbPro
        contbymbPro.setBoundEditor(txtbymbPro);
        //contbyxfPro
        contbyxfPro.setBoundEditor(txtbyxfPro);
        //contbyeyPro
        contbyeyPro.setBoundEditor(txtbyeyPro);
        //contzzPro
        contzzPro.setBoundEditor(txtzzPro);
        //contgdjzPro
        contgdjzPro.setBoundEditor(txtgdjzPro);
        //contyxjzPro
        contyxjzPro.setBoundEditor(txtyxjzPro);
        //contzyPro
        contzyPro.setBoundEditor(txtzyPro);
        //contknwPro
        contknwPro.setBoundEditor(txtknwPro);
        //contmbPro
        contmbPro.setBoundEditor(txtmbPro);
        //contzfPro
        contzfPro.setBoundEditor(txtzfPro);
        //conteyPro
        conteyPro.setBoundEditor(txteyPro);
        //contdocName
        contdocName.setBoundEditor(txtdocName);
        //contcityNumber
        contcityNumber.setBoundEditor(txtcityNumber);
        //contcityName
        contcityName.setBoundEditor(txtcityName);
        //contcity
        contcity.setBoundEditor(prmtcity);
        //contbusinessDate
        contbusinessDate.setBoundEditor(txtbusinessDate);

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
		dataBinder.registerBinding("zjpro", java.math.BigDecimal.class, this.txtzjpro, "value");
		dataBinder.registerBinding("byzzPro", java.math.BigDecimal.class, this.txtbyzzPro, "value");
		dataBinder.registerBinding("bygdjzPro", java.math.BigDecimal.class, this.txtbygdjzPro, "value");
		dataBinder.registerBinding("byyzPro", java.math.BigDecimal.class, this.txtbyyzPro, "value");
		dataBinder.registerBinding("byyxjzPro", java.math.BigDecimal.class, this.txtbyyxjzPro, "value");
		dataBinder.registerBinding("byknwPro", java.math.BigDecimal.class, this.txtbyknwPro, "value");
		dataBinder.registerBinding("bymbPro", java.math.BigDecimal.class, this.txtbymbPro, "value");
		dataBinder.registerBinding("byxfPro", java.math.BigDecimal.class, this.txtbyxfPro, "value");
		dataBinder.registerBinding("byeyPro", java.math.BigDecimal.class, this.txtbyeyPro, "value");
		dataBinder.registerBinding("zzPro", java.math.BigDecimal.class, this.txtzzPro, "value");
		dataBinder.registerBinding("gdjzPro", java.math.BigDecimal.class, this.txtgdjzPro, "value");
		dataBinder.registerBinding("yxjzPro", java.math.BigDecimal.class, this.txtyxjzPro, "value");
		dataBinder.registerBinding("zyPro", java.math.BigDecimal.class, this.txtzyPro, "value");
		dataBinder.registerBinding("knwPro", java.math.BigDecimal.class, this.txtknwPro, "value");
		dataBinder.registerBinding("mbPro", java.math.BigDecimal.class, this.txtmbPro, "value");
		dataBinder.registerBinding("zfPro", java.math.BigDecimal.class, this.txtzfPro, "value");
		dataBinder.registerBinding("eyPro", java.math.BigDecimal.class, this.txteyPro, "value");
		dataBinder.registerBinding("docName", String.class, this.txtdocName, "text");
		dataBinder.registerBinding("cityNumber", String.class, this.txtcityNumber, "text");
		dataBinder.registerBinding("cityName", String.class, this.txtcityName, "text");
		dataBinder.registerBinding("city", com.kingdee.eas.basedata.org.CtrlUnitInfo.class, this.prmtcity, "data");
		dataBinder.registerBinding("businessDate", String.class, this.txtbusinessDate, "text");		
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
	    return "com.kingdee.eas.mw.pay.app.PartTimeDocProEditUIHandler";
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
        this.editData = (com.kingdee.eas.mw.pay.PartTimeDocProInfo)ov;
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
		getValidateHelper().registerBindProperty("zjpro", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("byzzPro", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("bygdjzPro", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("byyzPro", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("byyxjzPro", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("byknwPro", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("bymbPro", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("byxfPro", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("byeyPro", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("zzPro", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("gdjzPro", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("yxjzPro", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("zyPro", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("knwPro", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("mbPro", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("zfPro", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("eyPro", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("docName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("cityNumber", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("cityName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("city", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("businessDate", ValidateHelper.ON_SAVE);    		
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
        sic.add(new SelectorItemInfo("zjpro"));
        sic.add(new SelectorItemInfo("byzzPro"));
        sic.add(new SelectorItemInfo("bygdjzPro"));
        sic.add(new SelectorItemInfo("byyzPro"));
        sic.add(new SelectorItemInfo("byyxjzPro"));
        sic.add(new SelectorItemInfo("byknwPro"));
        sic.add(new SelectorItemInfo("bymbPro"));
        sic.add(new SelectorItemInfo("byxfPro"));
        sic.add(new SelectorItemInfo("byeyPro"));
        sic.add(new SelectorItemInfo("zzPro"));
        sic.add(new SelectorItemInfo("gdjzPro"));
        sic.add(new SelectorItemInfo("yxjzPro"));
        sic.add(new SelectorItemInfo("zyPro"));
        sic.add(new SelectorItemInfo("knwPro"));
        sic.add(new SelectorItemInfo("mbPro"));
        sic.add(new SelectorItemInfo("zfPro"));
        sic.add(new SelectorItemInfo("eyPro"));
        sic.add(new SelectorItemInfo("docName"));
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
        sic.add(new SelectorItemInfo("businessDate"));
        return sic;
    }        

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.mw.pay.client", "PartTimeDocProEditUI");
    }

    /**
     * output getEditUIName method
     */
    protected String getEditUIName()
    {
        return com.kingdee.eas.mw.pay.client.PartTimeDocProEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.mw.pay.PartTimeDocProFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.mw.pay.PartTimeDocProInfo objectValue = new com.kingdee.eas.mw.pay.PartTimeDocProInfo();
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