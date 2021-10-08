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
public abstract class AbstractAchienementSumEditUI extends com.kingdee.eas.framework.client.EditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractAchienementSumEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer2;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer3;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer4;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbusinessDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contempNumber;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contempName;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contclinicNumber;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcityNumber;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcityName;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contscalingBonus;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contwhiteBonus;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contconBonus;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contotherPostBonus;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contdocBonus;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contdocCost;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contshopGoalBonus;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contclinicName;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contpostType;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contpostName;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contassToDocBouns;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contkfBonus;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox txtName;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtSimpleName;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox txtDescription;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtbusinessDate;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtempNumber;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtempName;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtclinicNumber;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtcityNumber;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtcityName;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtscalingBonus;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtwhiteBonus;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtconBonus;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtotherPostBonus;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtdocBonus;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtdocCost;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtshopGoalBonus;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtclinicName;
    protected com.kingdee.bos.ctrl.swing.KDComboBox postType;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtpostName;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtassToDocBouns;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtkfBonus;
    protected com.kingdee.eas.mw.pay.AchienementSumInfo editData = null;
    /**
     * output class constructor
     */
    public AbstractAchienementSumEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractAchienementSumEditUI.class.getName());
        this.setUITitle(resHelper.getString("this.title"));
        this.kDLabelContainer1 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer2 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer3 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer4 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbusinessDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contempNumber = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contempName = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contclinicNumber = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcityNumber = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcityName = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contscalingBonus = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contwhiteBonus = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contconBonus = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contotherPostBonus = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contdocBonus = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contdocCost = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contshopGoalBonus = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contclinicName = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contpostType = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contpostName = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contassToDocBouns = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contkfBonus = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtName = new com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox();
        this.txtSimpleName = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtDescription = new com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox();
        this.txtbusinessDate = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtempNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtempName = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtclinicNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtcityNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtcityName = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtscalingBonus = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtwhiteBonus = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtconBonus = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtotherPostBonus = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtdocBonus = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtdocCost = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtshopGoalBonus = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtclinicName = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.postType = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.txtpostName = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtassToDocBouns = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtkfBonus = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.kDLabelContainer1.setName("kDLabelContainer1");
        this.kDLabelContainer2.setName("kDLabelContainer2");
        this.kDLabelContainer3.setName("kDLabelContainer3");
        this.kDLabelContainer4.setName("kDLabelContainer4");
        this.contbusinessDate.setName("contbusinessDate");
        this.contempNumber.setName("contempNumber");
        this.contempName.setName("contempName");
        this.contclinicNumber.setName("contclinicNumber");
        this.contcityNumber.setName("contcityNumber");
        this.contcityName.setName("contcityName");
        this.contscalingBonus.setName("contscalingBonus");
        this.contwhiteBonus.setName("contwhiteBonus");
        this.contconBonus.setName("contconBonus");
        this.contotherPostBonus.setName("contotherPostBonus");
        this.contdocBonus.setName("contdocBonus");
        this.contdocCost.setName("contdocCost");
        this.contshopGoalBonus.setName("contshopGoalBonus");
        this.contclinicName.setName("contclinicName");
        this.contpostType.setName("contpostType");
        this.contpostName.setName("contpostName");
        this.contassToDocBouns.setName("contassToDocBouns");
        this.contkfBonus.setName("contkfBonus");
        this.txtNumber.setName("txtNumber");
        this.txtName.setName("txtName");
        this.txtSimpleName.setName("txtSimpleName");
        this.txtDescription.setName("txtDescription");
        this.txtbusinessDate.setName("txtbusinessDate");
        this.txtempNumber.setName("txtempNumber");
        this.txtempName.setName("txtempName");
        this.txtclinicNumber.setName("txtclinicNumber");
        this.txtcityNumber.setName("txtcityNumber");
        this.txtcityName.setName("txtcityName");
        this.txtscalingBonus.setName("txtscalingBonus");
        this.txtwhiteBonus.setName("txtwhiteBonus");
        this.txtconBonus.setName("txtconBonus");
        this.txtotherPostBonus.setName("txtotherPostBonus");
        this.txtdocBonus.setName("txtdocBonus");
        this.txtdocCost.setName("txtdocCost");
        this.txtshopGoalBonus.setName("txtshopGoalBonus");
        this.txtclinicName.setName("txtclinicName");
        this.postType.setName("postType");
        this.txtpostName.setName("txtpostName");
        this.txtassToDocBouns.setName("txtassToDocBouns");
        this.txtkfBonus.setName("txtkfBonus");
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
        // contscalingBonus		
        this.contscalingBonus.setBoundLabelText(resHelper.getString("contscalingBonus.boundLabelText"));		
        this.contscalingBonus.setBoundLabelLength(100);		
        this.contscalingBonus.setBoundLabelUnderline(true);		
        this.contscalingBonus.setVisible(true);
        // contwhiteBonus		
        this.contwhiteBonus.setBoundLabelText(resHelper.getString("contwhiteBonus.boundLabelText"));		
        this.contwhiteBonus.setBoundLabelLength(100);		
        this.contwhiteBonus.setBoundLabelUnderline(true);		
        this.contwhiteBonus.setVisible(true);
        // contconBonus		
        this.contconBonus.setBoundLabelText(resHelper.getString("contconBonus.boundLabelText"));		
        this.contconBonus.setBoundLabelLength(100);		
        this.contconBonus.setBoundLabelUnderline(true);		
        this.contconBonus.setVisible(true);
        // contotherPostBonus		
        this.contotherPostBonus.setBoundLabelText(resHelper.getString("contotherPostBonus.boundLabelText"));		
        this.contotherPostBonus.setBoundLabelLength(100);		
        this.contotherPostBonus.setBoundLabelUnderline(true);		
        this.contotherPostBonus.setVisible(true);
        // contdocBonus		
        this.contdocBonus.setBoundLabelText(resHelper.getString("contdocBonus.boundLabelText"));		
        this.contdocBonus.setBoundLabelLength(100);		
        this.contdocBonus.setBoundLabelUnderline(true);		
        this.contdocBonus.setVisible(true);
        // contdocCost		
        this.contdocCost.setBoundLabelText(resHelper.getString("contdocCost.boundLabelText"));		
        this.contdocCost.setBoundLabelLength(100);		
        this.contdocCost.setBoundLabelUnderline(true);		
        this.contdocCost.setVisible(true);
        // contshopGoalBonus		
        this.contshopGoalBonus.setBoundLabelText(resHelper.getString("contshopGoalBonus.boundLabelText"));		
        this.contshopGoalBonus.setBoundLabelLength(100);		
        this.contshopGoalBonus.setBoundLabelUnderline(true);		
        this.contshopGoalBonus.setVisible(true);
        // contclinicName		
        this.contclinicName.setBoundLabelText(resHelper.getString("contclinicName.boundLabelText"));		
        this.contclinicName.setBoundLabelLength(100);		
        this.contclinicName.setBoundLabelUnderline(true);		
        this.contclinicName.setVisible(true);
        // contpostType		
        this.contpostType.setBoundLabelText(resHelper.getString("contpostType.boundLabelText"));		
        this.contpostType.setBoundLabelLength(100);		
        this.contpostType.setBoundLabelUnderline(true);		
        this.contpostType.setVisible(true);
        // contpostName		
        this.contpostName.setBoundLabelText(resHelper.getString("contpostName.boundLabelText"));		
        this.contpostName.setBoundLabelLength(100);		
        this.contpostName.setBoundLabelUnderline(true);		
        this.contpostName.setVisible(true);
        // contassToDocBouns		
        this.contassToDocBouns.setBoundLabelText(resHelper.getString("contassToDocBouns.boundLabelText"));		
        this.contassToDocBouns.setBoundLabelLength(100);		
        this.contassToDocBouns.setBoundLabelUnderline(true);		
        this.contassToDocBouns.setVisible(true);
        // contkfBonus		
        this.contkfBonus.setBoundLabelText(resHelper.getString("contkfBonus.boundLabelText"));		
        this.contkfBonus.setBoundLabelLength(100);		
        this.contkfBonus.setBoundLabelUnderline(true);		
        this.contkfBonus.setVisible(true);
        // txtNumber		
        this.txtNumber.setMaxLength(80);		
        this.txtNumber.setVisible(false);
        // txtName		
        this.txtName.setVisible(false);
        // txtSimpleName		
        this.txtSimpleName.setMaxLength(80);
        // txtDescription		
        this.txtDescription.setVisible(false);
        // txtbusinessDate		
        this.txtbusinessDate.setHorizontalAlignment(2);		
        this.txtbusinessDate.setMaxLength(100);		
        this.txtbusinessDate.setRequired(false);
        // txtempNumber		
        this.txtempNumber.setHorizontalAlignment(2);		
        this.txtempNumber.setMaxLength(100);		
        this.txtempNumber.setRequired(false);
        // txtempName		
        this.txtempName.setHorizontalAlignment(2);		
        this.txtempName.setMaxLength(100);		
        this.txtempName.setRequired(false);
        // txtclinicNumber		
        this.txtclinicNumber.setHorizontalAlignment(2);		
        this.txtclinicNumber.setMaxLength(100);		
        this.txtclinicNumber.setRequired(false);
        // txtcityNumber		
        this.txtcityNumber.setHorizontalAlignment(2);		
        this.txtcityNumber.setMaxLength(100);		
        this.txtcityNumber.setRequired(false);
        // txtcityName		
        this.txtcityName.setHorizontalAlignment(2);		
        this.txtcityName.setMaxLength(100);		
        this.txtcityName.setRequired(false);
        // txtscalingBonus		
        this.txtscalingBonus.setHorizontalAlignment(2);		
        this.txtscalingBonus.setDataType(1);		
        this.txtscalingBonus.setSupportedEmpty(true);		
        this.txtscalingBonus.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtscalingBonus.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtscalingBonus.setPrecision(10);		
        this.txtscalingBonus.setRequired(false);
        // txtwhiteBonus		
        this.txtwhiteBonus.setHorizontalAlignment(2);		
        this.txtwhiteBonus.setDataType(1);		
        this.txtwhiteBonus.setSupportedEmpty(true);		
        this.txtwhiteBonus.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtwhiteBonus.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtwhiteBonus.setPrecision(10);		
        this.txtwhiteBonus.setRequired(false);
        // txtconBonus		
        this.txtconBonus.setHorizontalAlignment(2);		
        this.txtconBonus.setDataType(1);		
        this.txtconBonus.setSupportedEmpty(true);		
        this.txtconBonus.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtconBonus.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtconBonus.setPrecision(10);		
        this.txtconBonus.setRequired(false);
        // txtotherPostBonus		
        this.txtotherPostBonus.setHorizontalAlignment(2);		
        this.txtotherPostBonus.setDataType(1);		
        this.txtotherPostBonus.setSupportedEmpty(true);		
        this.txtotherPostBonus.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtotherPostBonus.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtotherPostBonus.setPrecision(10);		
        this.txtotherPostBonus.setRequired(false);
        // txtdocBonus		
        this.txtdocBonus.setHorizontalAlignment(2);		
        this.txtdocBonus.setDataType(1);		
        this.txtdocBonus.setSupportedEmpty(true);		
        this.txtdocBonus.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtdocBonus.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtdocBonus.setPrecision(10);		
        this.txtdocBonus.setRequired(false);
        // txtdocCost		
        this.txtdocCost.setHorizontalAlignment(2);		
        this.txtdocCost.setDataType(1);		
        this.txtdocCost.setSupportedEmpty(true);		
        this.txtdocCost.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtdocCost.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtdocCost.setPrecision(10);		
        this.txtdocCost.setRequired(false);
        // txtshopGoalBonus		
        this.txtshopGoalBonus.setHorizontalAlignment(2);		
        this.txtshopGoalBonus.setDataType(1);		
        this.txtshopGoalBonus.setSupportedEmpty(true);		
        this.txtshopGoalBonus.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtshopGoalBonus.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtshopGoalBonus.setPrecision(10);		
        this.txtshopGoalBonus.setRequired(false);
        // txtclinicName		
        this.txtclinicName.setHorizontalAlignment(2);		
        this.txtclinicName.setMaxLength(100);		
        this.txtclinicName.setRequired(false);
        // postType		
        this.postType.setVisible(true);		
        this.postType.addItems(EnumUtils.getEnumList("com.kingdee.eas.mw.pay.app.PaypostType").toArray());		
        this.postType.setRequired(false);
        // txtpostName		
        this.txtpostName.setVisible(true);		
        this.txtpostName.setHorizontalAlignment(2);		
        this.txtpostName.setMaxLength(100);		
        this.txtpostName.setRequired(false);
        // txtassToDocBouns		
        this.txtassToDocBouns.setVisible(true);		
        this.txtassToDocBouns.setHorizontalAlignment(2);		
        this.txtassToDocBouns.setDataType(1);		
        this.txtassToDocBouns.setSupportedEmpty(true);		
        this.txtassToDocBouns.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtassToDocBouns.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtassToDocBouns.setPrecision(10);		
        this.txtassToDocBouns.setRequired(false);
        // txtkfBonus		
        this.txtkfBonus.setVisible(true);		
        this.txtkfBonus.setHorizontalAlignment(2);		
        this.txtkfBonus.setDataType(1);		
        this.txtkfBonus.setSupportedEmpty(true);		
        this.txtkfBonus.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtkfBonus.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtkfBonus.setPrecision(10);		
        this.txtkfBonus.setRequired(false);
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {txtName,txtNumber,txtDescription,txtSimpleName,txtbusinessDate,txtempNumber,txtempName,txtclinicNumber,txtcityNumber,txtcityName,txtscalingBonus,txtwhiteBonus,txtconBonus,txtotherPostBonus,txtdocBonus,txtdocCost,txtshopGoalBonus,txtclinicName,postType,txtpostName,txtassToDocBouns,txtkfBonus}));
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
        kDLabelContainer1.setBounds(new Rectangle(341, 106, 270, 19));
        this.add(kDLabelContainer1, null);
        kDLabelContainer2.setBounds(new Rectangle(672, 106, 270, 19));
        this.add(kDLabelContainer2, null);
        kDLabelContainer3.setBounds(new Rectangle(341, 130, 270, 19));
        this.add(kDLabelContainer3, null);
        kDLabelContainer4.setBounds(new Rectangle(672, 130, 270, 19));
        this.add(kDLabelContainer4, null);
        contbusinessDate.setBounds(new Rectangle(10, 10, 270, 19));
        this.add(contbusinessDate, null);
        contempNumber.setBounds(new Rectangle(341, 10, 270, 19));
        this.add(contempNumber, null);
        contempName.setBounds(new Rectangle(672, 10, 270, 19));
        this.add(contempName, null);
        contclinicNumber.setBounds(new Rectangle(672, 34, 270, 19));
        this.add(contclinicNumber, null);
        contcityNumber.setBounds(new Rectangle(10, 34, 270, 19));
        this.add(contcityNumber, null);
        contcityName.setBounds(new Rectangle(341, 34, 270, 19));
        this.add(contcityName, null);
        contscalingBonus.setBounds(new Rectangle(341, 58, 270, 19));
        this.add(contscalingBonus, null);
        contwhiteBonus.setBounds(new Rectangle(672, 58, 270, 19));
        this.add(contwhiteBonus, null);
        contconBonus.setBounds(new Rectangle(10, 82, 270, 19));
        this.add(contconBonus, null);
        contotherPostBonus.setBounds(new Rectangle(341, 82, 270, 19));
        this.add(contotherPostBonus, null);
        contdocBonus.setBounds(new Rectangle(672, 82, 270, 19));
        this.add(contdocBonus, null);
        contdocCost.setBounds(new Rectangle(10, 106, 270, 19));
        this.add(contdocCost, null);
        contshopGoalBonus.setBounds(new Rectangle(10, 130, 270, 19));
        this.add(contshopGoalBonus, null);
        contclinicName.setBounds(new Rectangle(10, 58, 270, 19));
        this.add(contclinicName, null);
        contpostType.setBounds(new Rectangle(10, 154, 270, 19));
        this.add(contpostType, null);
        contpostName.setBounds(new Rectangle(341, 154, 270, 19));
        this.add(contpostName, null);
        contassToDocBouns.setBounds(new Rectangle(672, 154, 270, 19));
        this.add(contassToDocBouns, null);
        contkfBonus.setBounds(new Rectangle(10, 178, 270, 19));
        this.add(contkfBonus, null);
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
        //contempNumber
        contempNumber.setBoundEditor(txtempNumber);
        //contempName
        contempName.setBoundEditor(txtempName);
        //contclinicNumber
        contclinicNumber.setBoundEditor(txtclinicNumber);
        //contcityNumber
        contcityNumber.setBoundEditor(txtcityNumber);
        //contcityName
        contcityName.setBoundEditor(txtcityName);
        //contscalingBonus
        contscalingBonus.setBoundEditor(txtscalingBonus);
        //contwhiteBonus
        contwhiteBonus.setBoundEditor(txtwhiteBonus);
        //contconBonus
        contconBonus.setBoundEditor(txtconBonus);
        //contotherPostBonus
        contotherPostBonus.setBoundEditor(txtotherPostBonus);
        //contdocBonus
        contdocBonus.setBoundEditor(txtdocBonus);
        //contdocCost
        contdocCost.setBoundEditor(txtdocCost);
        //contshopGoalBonus
        contshopGoalBonus.setBoundEditor(txtshopGoalBonus);
        //contclinicName
        contclinicName.setBoundEditor(txtclinicName);
        //contpostType
        contpostType.setBoundEditor(postType);
        //contpostName
        contpostName.setBoundEditor(txtpostName);
        //contassToDocBouns
        contassToDocBouns.setBoundEditor(txtassToDocBouns);
        //contkfBonus
        contkfBonus.setBoundEditor(txtkfBonus);

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
		dataBinder.registerBinding("empNumber", String.class, this.txtempNumber, "text");
		dataBinder.registerBinding("empName", String.class, this.txtempName, "text");
		dataBinder.registerBinding("clinicNumber", String.class, this.txtclinicNumber, "text");
		dataBinder.registerBinding("cityNumber", String.class, this.txtcityNumber, "text");
		dataBinder.registerBinding("cityName", String.class, this.txtcityName, "text");
		dataBinder.registerBinding("scalingBonus", java.math.BigDecimal.class, this.txtscalingBonus, "value");
		dataBinder.registerBinding("whiteBonus", java.math.BigDecimal.class, this.txtwhiteBonus, "value");
		dataBinder.registerBinding("conBonus", java.math.BigDecimal.class, this.txtconBonus, "value");
		dataBinder.registerBinding("otherPostBonus", java.math.BigDecimal.class, this.txtotherPostBonus, "value");
		dataBinder.registerBinding("docBonus", java.math.BigDecimal.class, this.txtdocBonus, "value");
		dataBinder.registerBinding("docCost", java.math.BigDecimal.class, this.txtdocCost, "value");
		dataBinder.registerBinding("shopGoalBonus", java.math.BigDecimal.class, this.txtshopGoalBonus, "value");
		dataBinder.registerBinding("clinicName", String.class, this.txtclinicName, "text");
		dataBinder.registerBinding("postType", com.kingdee.eas.mw.pay.app.PaypostType.class, this.postType, "selectedItem");
		dataBinder.registerBinding("postName", String.class, this.txtpostName, "text");
		dataBinder.registerBinding("assToDocBouns", java.math.BigDecimal.class, this.txtassToDocBouns, "value");
		dataBinder.registerBinding("kfBonus", java.math.BigDecimal.class, this.txtkfBonus, "value");		
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
	    return "com.kingdee.eas.mw.pay.app.AchienementSumEditUIHandler";
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
        this.txtName.requestFocusInWindow();
    }

	
	

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject)
    {
        IObjectValue ov = dataObject;        	    	
        super.setDataObject(ov);
        this.editData = (com.kingdee.eas.mw.pay.AchienementSumInfo)ov;
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
		getValidateHelper().registerBindProperty("number", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("name", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("simpleName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("description", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("businessDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("empNumber", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("empName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("clinicNumber", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("cityNumber", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("cityName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("scalingBonus", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("whiteBonus", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("conBonus", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("otherPostBonus", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("docBonus", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("docCost", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("shopGoalBonus", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("clinicName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("postType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("postName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("assToDocBouns", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("kfBonus", ValidateHelper.ON_SAVE);    		
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
        sic.add(new SelectorItemInfo("empNumber"));
        sic.add(new SelectorItemInfo("empName"));
        sic.add(new SelectorItemInfo("clinicNumber"));
        sic.add(new SelectorItemInfo("cityNumber"));
        sic.add(new SelectorItemInfo("cityName"));
        sic.add(new SelectorItemInfo("scalingBonus"));
        sic.add(new SelectorItemInfo("whiteBonus"));
        sic.add(new SelectorItemInfo("conBonus"));
        sic.add(new SelectorItemInfo("otherPostBonus"));
        sic.add(new SelectorItemInfo("docBonus"));
        sic.add(new SelectorItemInfo("docCost"));
        sic.add(new SelectorItemInfo("shopGoalBonus"));
        sic.add(new SelectorItemInfo("clinicName"));
        sic.add(new SelectorItemInfo("postType"));
        sic.add(new SelectorItemInfo("postName"));
        sic.add(new SelectorItemInfo("assToDocBouns"));
        sic.add(new SelectorItemInfo("kfBonus"));
        return sic;
    }        

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.mw.pay.client", "AchienementSumEditUI");
    }

    /**
     * output getEditUIName method
     */
    protected String getEditUIName()
    {
        return com.kingdee.eas.mw.pay.client.AchienementSumEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.mw.pay.AchienementSumFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.mw.pay.AchienementSumInfo objectValue = new com.kingdee.eas.mw.pay.AchienementSumInfo();
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
		vo.put("postType","ZXS");
        
    }        
	protected void setFieldsNull(com.kingdee.bos.dao.AbstractObjectValue arg0) {
		super.setFieldsNull(arg0);
		arg0.put("number",null);
	}

}