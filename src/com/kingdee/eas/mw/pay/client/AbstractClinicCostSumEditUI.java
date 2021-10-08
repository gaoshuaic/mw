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
public abstract class AbstractClinicCostSumEditUI extends com.kingdee.eas.framework.client.EditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractClinicCostSumEditUI.class);
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
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contclinicName;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contzzCost;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contgdjzCost;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contyxjzCost;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contyzCost;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contknwCost;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contmbCost;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contxfCost;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conteyCost;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contimzzCost;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contimgdjzCost;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contimyxjzCost;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contimyzCost;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contimknwCost;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contimmbCost;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contimeyCost;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contimxfCost;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkizzidai;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contupzzCost;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contupyxjzCost;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contupgdjzCost;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contupknwCost;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contupxfCost;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contupeyCost;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contupmbCost;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contallzzCost;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contallgdjzCost;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contallknwCost;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contallxfCost;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contalleyCost;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contallyzCost;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contallmbCost;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contupyzCost;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contallyxjzCost;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contstatus;
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
    protected com.kingdee.bos.ctrl.swing.KDTextField txtclinicName;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtzzCost;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtgdjzCost;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtyxjzCost;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtyzCost;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtknwCost;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtmbCost;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtxfCost;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txteyCost;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtimzzCost;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtimgdjzCost;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtimyxjzCost;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtimyzCost;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtimknwCost;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtimmbCost;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtimeyCost;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtimxfCost;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtupzzCost;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtupyxjzCost;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtupgdjzCost;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtupknwCost;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtupxfCost;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtupeyCost;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtupmbCost;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtallzzCost;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtallgdjzCost;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtallknwCost;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtallxfCost;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtalleyCost;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtallyzCost;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtallmbCost;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtupyzCost;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtallyxjzCost;
    protected com.kingdee.bos.ctrl.swing.KDComboBox status;
    protected com.kingdee.eas.mw.pay.ClinicCostSumInfo editData = null;
    /**
     * output class constructor
     */
    public AbstractClinicCostSumEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractClinicCostSumEditUI.class.getName());
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
        this.contclinicName = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contzzCost = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contgdjzCost = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contyxjzCost = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contyzCost = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contknwCost = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contmbCost = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contxfCost = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conteyCost = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contimzzCost = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contimgdjzCost = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contimyxjzCost = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contimyzCost = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contimknwCost = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contimmbCost = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contimeyCost = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contimxfCost = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.chkizzidai = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.contupzzCost = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contupyxjzCost = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contupgdjzCost = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contupknwCost = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contupxfCost = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contupeyCost = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contupmbCost = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contallzzCost = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contallgdjzCost = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contallknwCost = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contallxfCost = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contalleyCost = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contallyzCost = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contallmbCost = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contupyzCost = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contallyxjzCost = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contstatus = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
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
        this.txtclinicName = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtzzCost = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtgdjzCost = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtyxjzCost = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtyzCost = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtknwCost = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtmbCost = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtxfCost = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txteyCost = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtimzzCost = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtimgdjzCost = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtimyxjzCost = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtimyzCost = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtimknwCost = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtimmbCost = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtimeyCost = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtimxfCost = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtupzzCost = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtupyxjzCost = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtupgdjzCost = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtupknwCost = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtupxfCost = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtupeyCost = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtupmbCost = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtallzzCost = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtallgdjzCost = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtallknwCost = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtallxfCost = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtalleyCost = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtallyzCost = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtallmbCost = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtupyzCost = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtallyxjzCost = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.status = new com.kingdee.bos.ctrl.swing.KDComboBox();
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
        this.contclinicName.setName("contclinicName");
        this.contzzCost.setName("contzzCost");
        this.contgdjzCost.setName("contgdjzCost");
        this.contyxjzCost.setName("contyxjzCost");
        this.contyzCost.setName("contyzCost");
        this.contknwCost.setName("contknwCost");
        this.contmbCost.setName("contmbCost");
        this.contxfCost.setName("contxfCost");
        this.conteyCost.setName("conteyCost");
        this.contimzzCost.setName("contimzzCost");
        this.contimgdjzCost.setName("contimgdjzCost");
        this.contimyxjzCost.setName("contimyxjzCost");
        this.contimyzCost.setName("contimyzCost");
        this.contimknwCost.setName("contimknwCost");
        this.contimmbCost.setName("contimmbCost");
        this.contimeyCost.setName("contimeyCost");
        this.contimxfCost.setName("contimxfCost");
        this.chkizzidai.setName("chkizzidai");
        this.contupzzCost.setName("contupzzCost");
        this.contupyxjzCost.setName("contupyxjzCost");
        this.contupgdjzCost.setName("contupgdjzCost");
        this.contupknwCost.setName("contupknwCost");
        this.contupxfCost.setName("contupxfCost");
        this.contupeyCost.setName("contupeyCost");
        this.contupmbCost.setName("contupmbCost");
        this.contallzzCost.setName("contallzzCost");
        this.contallgdjzCost.setName("contallgdjzCost");
        this.contallknwCost.setName("contallknwCost");
        this.contallxfCost.setName("contallxfCost");
        this.contalleyCost.setName("contalleyCost");
        this.contallyzCost.setName("contallyzCost");
        this.contallmbCost.setName("contallmbCost");
        this.contupyzCost.setName("contupyzCost");
        this.contallyxjzCost.setName("contallyxjzCost");
        this.contstatus.setName("contstatus");
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
        this.txtclinicName.setName("txtclinicName");
        this.txtzzCost.setName("txtzzCost");
        this.txtgdjzCost.setName("txtgdjzCost");
        this.txtyxjzCost.setName("txtyxjzCost");
        this.txtyzCost.setName("txtyzCost");
        this.txtknwCost.setName("txtknwCost");
        this.txtmbCost.setName("txtmbCost");
        this.txtxfCost.setName("txtxfCost");
        this.txteyCost.setName("txteyCost");
        this.txtimzzCost.setName("txtimzzCost");
        this.txtimgdjzCost.setName("txtimgdjzCost");
        this.txtimyxjzCost.setName("txtimyxjzCost");
        this.txtimyzCost.setName("txtimyzCost");
        this.txtimknwCost.setName("txtimknwCost");
        this.txtimmbCost.setName("txtimmbCost");
        this.txtimeyCost.setName("txtimeyCost");
        this.txtimxfCost.setName("txtimxfCost");
        this.txtupzzCost.setName("txtupzzCost");
        this.txtupyxjzCost.setName("txtupyxjzCost");
        this.txtupgdjzCost.setName("txtupgdjzCost");
        this.txtupknwCost.setName("txtupknwCost");
        this.txtupxfCost.setName("txtupxfCost");
        this.txtupeyCost.setName("txtupeyCost");
        this.txtupmbCost.setName("txtupmbCost");
        this.txtallzzCost.setName("txtallzzCost");
        this.txtallgdjzCost.setName("txtallgdjzCost");
        this.txtallknwCost.setName("txtallknwCost");
        this.txtallxfCost.setName("txtallxfCost");
        this.txtalleyCost.setName("txtalleyCost");
        this.txtallyzCost.setName("txtallyzCost");
        this.txtallmbCost.setName("txtallmbCost");
        this.txtupyzCost.setName("txtupyzCost");
        this.txtallyxjzCost.setName("txtallyxjzCost");
        this.status.setName("status");
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
        // contclinicName		
        this.contclinicName.setBoundLabelText(resHelper.getString("contclinicName.boundLabelText"));		
        this.contclinicName.setBoundLabelLength(100);		
        this.contclinicName.setBoundLabelUnderline(true);		
        this.contclinicName.setVisible(true);
        // contzzCost		
        this.contzzCost.setBoundLabelText(resHelper.getString("contzzCost.boundLabelText"));		
        this.contzzCost.setBoundLabelLength(100);		
        this.contzzCost.setBoundLabelUnderline(true);		
        this.contzzCost.setVisible(true);
        // contgdjzCost		
        this.contgdjzCost.setBoundLabelText(resHelper.getString("contgdjzCost.boundLabelText"));		
        this.contgdjzCost.setBoundLabelLength(100);		
        this.contgdjzCost.setBoundLabelUnderline(true);		
        this.contgdjzCost.setVisible(true);
        // contyxjzCost		
        this.contyxjzCost.setBoundLabelText(resHelper.getString("contyxjzCost.boundLabelText"));		
        this.contyxjzCost.setBoundLabelLength(100);		
        this.contyxjzCost.setBoundLabelUnderline(true);		
        this.contyxjzCost.setVisible(true);
        // contyzCost		
        this.contyzCost.setBoundLabelText(resHelper.getString("contyzCost.boundLabelText"));		
        this.contyzCost.setBoundLabelLength(100);		
        this.contyzCost.setBoundLabelUnderline(true);		
        this.contyzCost.setVisible(true);
        // contknwCost		
        this.contknwCost.setBoundLabelText(resHelper.getString("contknwCost.boundLabelText"));		
        this.contknwCost.setBoundLabelLength(100);		
        this.contknwCost.setBoundLabelUnderline(true);		
        this.contknwCost.setVisible(true);
        // contmbCost		
        this.contmbCost.setBoundLabelText(resHelper.getString("contmbCost.boundLabelText"));		
        this.contmbCost.setBoundLabelLength(100);		
        this.contmbCost.setBoundLabelUnderline(true);		
        this.contmbCost.setVisible(true);
        // contxfCost		
        this.contxfCost.setBoundLabelText(resHelper.getString("contxfCost.boundLabelText"));		
        this.contxfCost.setBoundLabelLength(100);		
        this.contxfCost.setBoundLabelUnderline(true);		
        this.contxfCost.setVisible(true);
        // conteyCost		
        this.conteyCost.setBoundLabelText(resHelper.getString("conteyCost.boundLabelText"));		
        this.conteyCost.setBoundLabelLength(100);		
        this.conteyCost.setBoundLabelUnderline(true);		
        this.conteyCost.setVisible(true);
        // contimzzCost		
        this.contimzzCost.setBoundLabelText(resHelper.getString("contimzzCost.boundLabelText"));		
        this.contimzzCost.setBoundLabelLength(100);		
        this.contimzzCost.setBoundLabelUnderline(true);		
        this.contimzzCost.setVisible(true);
        // contimgdjzCost		
        this.contimgdjzCost.setBoundLabelText(resHelper.getString("contimgdjzCost.boundLabelText"));		
        this.contimgdjzCost.setBoundLabelLength(100);		
        this.contimgdjzCost.setBoundLabelUnderline(true);		
        this.contimgdjzCost.setVisible(true);
        // contimyxjzCost		
        this.contimyxjzCost.setBoundLabelText(resHelper.getString("contimyxjzCost.boundLabelText"));		
        this.contimyxjzCost.setBoundLabelLength(100);		
        this.contimyxjzCost.setBoundLabelUnderline(true);		
        this.contimyxjzCost.setVisible(true);
        // contimyzCost		
        this.contimyzCost.setBoundLabelText(resHelper.getString("contimyzCost.boundLabelText"));		
        this.contimyzCost.setBoundLabelLength(100);		
        this.contimyzCost.setBoundLabelUnderline(true);		
        this.contimyzCost.setVisible(true);
        // contimknwCost		
        this.contimknwCost.setBoundLabelText(resHelper.getString("contimknwCost.boundLabelText"));		
        this.contimknwCost.setBoundLabelLength(100);		
        this.contimknwCost.setBoundLabelUnderline(true);		
        this.contimknwCost.setVisible(true);
        // contimmbCost		
        this.contimmbCost.setBoundLabelText(resHelper.getString("contimmbCost.boundLabelText"));		
        this.contimmbCost.setBoundLabelLength(100);		
        this.contimmbCost.setBoundLabelUnderline(true);		
        this.contimmbCost.setVisible(true);
        // contimeyCost		
        this.contimeyCost.setBoundLabelText(resHelper.getString("contimeyCost.boundLabelText"));		
        this.contimeyCost.setBoundLabelLength(100);		
        this.contimeyCost.setBoundLabelUnderline(true);		
        this.contimeyCost.setVisible(true);
        // contimxfCost		
        this.contimxfCost.setBoundLabelText(resHelper.getString("contimxfCost.boundLabelText"));		
        this.contimxfCost.setBoundLabelLength(100);		
        this.contimxfCost.setBoundLabelUnderline(true);		
        this.contimxfCost.setVisible(true);
        // chkizzidai		
        this.chkizzidai.setText(resHelper.getString("chkizzidai.text"));		
        this.chkizzidai.setVisible(true);		
        this.chkizzidai.setHorizontalAlignment(2);
        // contupzzCost		
        this.contupzzCost.setBoundLabelText(resHelper.getString("contupzzCost.boundLabelText"));		
        this.contupzzCost.setBoundLabelLength(100);		
        this.contupzzCost.setBoundLabelUnderline(true);		
        this.contupzzCost.setVisible(true);
        // contupyxjzCost		
        this.contupyxjzCost.setBoundLabelText(resHelper.getString("contupyxjzCost.boundLabelText"));		
        this.contupyxjzCost.setBoundLabelLength(100);		
        this.contupyxjzCost.setBoundLabelUnderline(true);		
        this.contupyxjzCost.setVisible(true);
        // contupgdjzCost		
        this.contupgdjzCost.setBoundLabelText(resHelper.getString("contupgdjzCost.boundLabelText"));		
        this.contupgdjzCost.setBoundLabelLength(100);		
        this.contupgdjzCost.setBoundLabelUnderline(true);		
        this.contupgdjzCost.setVisible(true);
        // contupknwCost		
        this.contupknwCost.setBoundLabelText(resHelper.getString("contupknwCost.boundLabelText"));		
        this.contupknwCost.setBoundLabelLength(100);		
        this.contupknwCost.setBoundLabelUnderline(true);		
        this.contupknwCost.setVisible(true);
        // contupxfCost		
        this.contupxfCost.setBoundLabelText(resHelper.getString("contupxfCost.boundLabelText"));		
        this.contupxfCost.setBoundLabelLength(100);		
        this.contupxfCost.setBoundLabelUnderline(true);		
        this.contupxfCost.setVisible(true);
        // contupeyCost		
        this.contupeyCost.setBoundLabelText(resHelper.getString("contupeyCost.boundLabelText"));		
        this.contupeyCost.setBoundLabelLength(100);		
        this.contupeyCost.setBoundLabelUnderline(true);		
        this.contupeyCost.setVisible(true);
        // contupmbCost		
        this.contupmbCost.setBoundLabelText(resHelper.getString("contupmbCost.boundLabelText"));		
        this.contupmbCost.setBoundLabelLength(100);		
        this.contupmbCost.setBoundLabelUnderline(true);		
        this.contupmbCost.setVisible(true);
        // contallzzCost		
        this.contallzzCost.setBoundLabelText(resHelper.getString("contallzzCost.boundLabelText"));		
        this.contallzzCost.setBoundLabelLength(100);		
        this.contallzzCost.setBoundLabelUnderline(true);		
        this.contallzzCost.setVisible(true);
        // contallgdjzCost		
        this.contallgdjzCost.setBoundLabelText(resHelper.getString("contallgdjzCost.boundLabelText"));		
        this.contallgdjzCost.setBoundLabelLength(100);		
        this.contallgdjzCost.setBoundLabelUnderline(true);		
        this.contallgdjzCost.setVisible(true);
        // contallknwCost		
        this.contallknwCost.setBoundLabelText(resHelper.getString("contallknwCost.boundLabelText"));		
        this.contallknwCost.setBoundLabelLength(100);		
        this.contallknwCost.setBoundLabelUnderline(true);		
        this.contallknwCost.setVisible(true);
        // contallxfCost		
        this.contallxfCost.setBoundLabelText(resHelper.getString("contallxfCost.boundLabelText"));		
        this.contallxfCost.setBoundLabelLength(100);		
        this.contallxfCost.setBoundLabelUnderline(true);		
        this.contallxfCost.setVisible(true);
        // contalleyCost		
        this.contalleyCost.setBoundLabelText(resHelper.getString("contalleyCost.boundLabelText"));		
        this.contalleyCost.setBoundLabelLength(100);		
        this.contalleyCost.setBoundLabelUnderline(true);		
        this.contalleyCost.setVisible(true);
        // contallyzCost		
        this.contallyzCost.setBoundLabelText(resHelper.getString("contallyzCost.boundLabelText"));		
        this.contallyzCost.setBoundLabelLength(100);		
        this.contallyzCost.setBoundLabelUnderline(true);		
        this.contallyzCost.setVisible(true);
        // contallmbCost		
        this.contallmbCost.setBoundLabelText(resHelper.getString("contallmbCost.boundLabelText"));		
        this.contallmbCost.setBoundLabelLength(100);		
        this.contallmbCost.setBoundLabelUnderline(true);		
        this.contallmbCost.setVisible(true);
        // contupyzCost		
        this.contupyzCost.setBoundLabelText(resHelper.getString("contupyzCost.boundLabelText"));		
        this.contupyzCost.setBoundLabelLength(100);		
        this.contupyzCost.setBoundLabelUnderline(true);		
        this.contupyzCost.setVisible(true);
        // contallyxjzCost		
        this.contallyxjzCost.setBoundLabelText(resHelper.getString("contallyxjzCost.boundLabelText"));		
        this.contallyxjzCost.setBoundLabelLength(100);		
        this.contallyxjzCost.setBoundLabelUnderline(true);		
        this.contallyxjzCost.setVisible(true);
        // contstatus		
        this.contstatus.setBoundLabelText(resHelper.getString("contstatus.boundLabelText"));		
        this.contstatus.setBoundLabelLength(100);		
        this.contstatus.setBoundLabelUnderline(true);		
        this.contstatus.setVisible(true);
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
        // txtclinicName		
        this.txtclinicName.setVisible(true);		
        this.txtclinicName.setHorizontalAlignment(2);		
        this.txtclinicName.setMaxLength(100);		
        this.txtclinicName.setRequired(false);
        // txtzzCost		
        this.txtzzCost.setVisible(true);		
        this.txtzzCost.setHorizontalAlignment(2);		
        this.txtzzCost.setDataType(1);		
        this.txtzzCost.setSupportedEmpty(true);		
        this.txtzzCost.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtzzCost.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtzzCost.setPrecision(10);		
        this.txtzzCost.setRequired(false);
        // txtgdjzCost		
        this.txtgdjzCost.setVisible(true);		
        this.txtgdjzCost.setHorizontalAlignment(2);		
        this.txtgdjzCost.setDataType(1);		
        this.txtgdjzCost.setSupportedEmpty(true);		
        this.txtgdjzCost.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtgdjzCost.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtgdjzCost.setPrecision(10);		
        this.txtgdjzCost.setRequired(false);
        // txtyxjzCost		
        this.txtyxjzCost.setVisible(true);		
        this.txtyxjzCost.setHorizontalAlignment(2);		
        this.txtyxjzCost.setDataType(1);		
        this.txtyxjzCost.setSupportedEmpty(true);		
        this.txtyxjzCost.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtyxjzCost.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtyxjzCost.setPrecision(10);		
        this.txtyxjzCost.setRequired(false);
        // txtyzCost		
        this.txtyzCost.setVisible(true);		
        this.txtyzCost.setHorizontalAlignment(2);		
        this.txtyzCost.setDataType(1);		
        this.txtyzCost.setSupportedEmpty(true);		
        this.txtyzCost.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtyzCost.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtyzCost.setPrecision(10);		
        this.txtyzCost.setRequired(false);
        // txtknwCost		
        this.txtknwCost.setVisible(true);		
        this.txtknwCost.setHorizontalAlignment(2);		
        this.txtknwCost.setDataType(1);		
        this.txtknwCost.setSupportedEmpty(true);		
        this.txtknwCost.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtknwCost.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtknwCost.setPrecision(10);		
        this.txtknwCost.setRequired(false);
        // txtmbCost		
        this.txtmbCost.setVisible(true);		
        this.txtmbCost.setHorizontalAlignment(2);		
        this.txtmbCost.setDataType(1);		
        this.txtmbCost.setSupportedEmpty(true);		
        this.txtmbCost.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtmbCost.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtmbCost.setPrecision(10);		
        this.txtmbCost.setRequired(false);
        // txtxfCost		
        this.txtxfCost.setVisible(true);		
        this.txtxfCost.setHorizontalAlignment(2);		
        this.txtxfCost.setDataType(1);		
        this.txtxfCost.setSupportedEmpty(true);		
        this.txtxfCost.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtxfCost.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtxfCost.setPrecision(10);		
        this.txtxfCost.setRequired(false);
        // txteyCost		
        this.txteyCost.setVisible(true);		
        this.txteyCost.setHorizontalAlignment(2);		
        this.txteyCost.setDataType(1);		
        this.txteyCost.setSupportedEmpty(true);		
        this.txteyCost.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txteyCost.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txteyCost.setPrecision(10);		
        this.txteyCost.setRequired(false);
        // txtimzzCost		
        this.txtimzzCost.setVisible(true);		
        this.txtimzzCost.setHorizontalAlignment(2);		
        this.txtimzzCost.setDataType(1);		
        this.txtimzzCost.setSupportedEmpty(true);		
        this.txtimzzCost.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtimzzCost.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtimzzCost.setPrecision(10);		
        this.txtimzzCost.setRequired(false);
        // txtimgdjzCost		
        this.txtimgdjzCost.setVisible(true);		
        this.txtimgdjzCost.setHorizontalAlignment(2);		
        this.txtimgdjzCost.setDataType(1);		
        this.txtimgdjzCost.setSupportedEmpty(true);		
        this.txtimgdjzCost.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtimgdjzCost.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtimgdjzCost.setPrecision(10);		
        this.txtimgdjzCost.setRequired(false);
        // txtimyxjzCost		
        this.txtimyxjzCost.setVisible(true);		
        this.txtimyxjzCost.setHorizontalAlignment(2);		
        this.txtimyxjzCost.setDataType(1);		
        this.txtimyxjzCost.setSupportedEmpty(true);		
        this.txtimyxjzCost.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtimyxjzCost.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtimyxjzCost.setPrecision(10);		
        this.txtimyxjzCost.setRequired(false);
        // txtimyzCost		
        this.txtimyzCost.setVisible(true);		
        this.txtimyzCost.setHorizontalAlignment(2);		
        this.txtimyzCost.setDataType(1);		
        this.txtimyzCost.setSupportedEmpty(true);		
        this.txtimyzCost.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtimyzCost.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtimyzCost.setPrecision(10);		
        this.txtimyzCost.setRequired(false);
        // txtimknwCost		
        this.txtimknwCost.setVisible(true);		
        this.txtimknwCost.setHorizontalAlignment(2);		
        this.txtimknwCost.setDataType(1);		
        this.txtimknwCost.setSupportedEmpty(true);		
        this.txtimknwCost.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtimknwCost.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtimknwCost.setPrecision(10);		
        this.txtimknwCost.setRequired(false);
        // txtimmbCost		
        this.txtimmbCost.setVisible(true);		
        this.txtimmbCost.setHorizontalAlignment(2);		
        this.txtimmbCost.setDataType(1);		
        this.txtimmbCost.setSupportedEmpty(true);		
        this.txtimmbCost.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtimmbCost.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtimmbCost.setPrecision(10);		
        this.txtimmbCost.setRequired(false);
        // txtimeyCost		
        this.txtimeyCost.setVisible(true);		
        this.txtimeyCost.setHorizontalAlignment(2);		
        this.txtimeyCost.setDataType(1);		
        this.txtimeyCost.setSupportedEmpty(true);		
        this.txtimeyCost.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtimeyCost.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtimeyCost.setPrecision(10);		
        this.txtimeyCost.setRequired(false);
        // txtimxfCost		
        this.txtimxfCost.setVisible(true);		
        this.txtimxfCost.setHorizontalAlignment(2);		
        this.txtimxfCost.setDataType(1);		
        this.txtimxfCost.setSupportedEmpty(true);		
        this.txtimxfCost.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtimxfCost.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtimxfCost.setPrecision(10);		
        this.txtimxfCost.setRequired(false);
        // txtupzzCost		
        this.txtupzzCost.setVisible(true);		
        this.txtupzzCost.setHorizontalAlignment(2);		
        this.txtupzzCost.setDataType(1);		
        this.txtupzzCost.setSupportedEmpty(true);		
        this.txtupzzCost.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtupzzCost.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtupzzCost.setPrecision(10);		
        this.txtupzzCost.setRequired(false);
        // txtupyxjzCost		
        this.txtupyxjzCost.setVisible(true);		
        this.txtupyxjzCost.setHorizontalAlignment(2);		
        this.txtupyxjzCost.setDataType(1);		
        this.txtupyxjzCost.setSupportedEmpty(true);		
        this.txtupyxjzCost.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtupyxjzCost.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtupyxjzCost.setPrecision(10);		
        this.txtupyxjzCost.setRequired(false);
        // txtupgdjzCost		
        this.txtupgdjzCost.setVisible(true);		
        this.txtupgdjzCost.setHorizontalAlignment(2);		
        this.txtupgdjzCost.setDataType(1);		
        this.txtupgdjzCost.setSupportedEmpty(true);		
        this.txtupgdjzCost.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtupgdjzCost.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtupgdjzCost.setPrecision(10);		
        this.txtupgdjzCost.setRequired(false);
        // txtupknwCost		
        this.txtupknwCost.setVisible(true);		
        this.txtupknwCost.setHorizontalAlignment(2);		
        this.txtupknwCost.setDataType(1);		
        this.txtupknwCost.setSupportedEmpty(true);		
        this.txtupknwCost.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtupknwCost.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtupknwCost.setPrecision(10);		
        this.txtupknwCost.setRequired(false);
        // txtupxfCost		
        this.txtupxfCost.setVisible(true);		
        this.txtupxfCost.setHorizontalAlignment(2);		
        this.txtupxfCost.setDataType(1);		
        this.txtupxfCost.setSupportedEmpty(true);		
        this.txtupxfCost.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtupxfCost.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtupxfCost.setPrecision(10);		
        this.txtupxfCost.setRequired(false);
        // txtupeyCost		
        this.txtupeyCost.setVisible(true);		
        this.txtupeyCost.setHorizontalAlignment(2);		
        this.txtupeyCost.setDataType(1);		
        this.txtupeyCost.setSupportedEmpty(true);		
        this.txtupeyCost.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtupeyCost.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtupeyCost.setPrecision(10);		
        this.txtupeyCost.setRequired(false);
        // txtupmbCost		
        this.txtupmbCost.setVisible(true);		
        this.txtupmbCost.setHorizontalAlignment(2);		
        this.txtupmbCost.setDataType(1);		
        this.txtupmbCost.setSupportedEmpty(true);		
        this.txtupmbCost.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtupmbCost.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtupmbCost.setPrecision(10);		
        this.txtupmbCost.setRequired(false);
        // txtallzzCost		
        this.txtallzzCost.setVisible(true);		
        this.txtallzzCost.setHorizontalAlignment(2);		
        this.txtallzzCost.setDataType(1);		
        this.txtallzzCost.setSupportedEmpty(true);		
        this.txtallzzCost.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtallzzCost.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtallzzCost.setPrecision(10);		
        this.txtallzzCost.setRequired(false);
        // txtallgdjzCost		
        this.txtallgdjzCost.setVisible(true);		
        this.txtallgdjzCost.setHorizontalAlignment(2);		
        this.txtallgdjzCost.setDataType(1);		
        this.txtallgdjzCost.setSupportedEmpty(true);		
        this.txtallgdjzCost.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtallgdjzCost.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtallgdjzCost.setPrecision(10);		
        this.txtallgdjzCost.setRequired(false);
        // txtallknwCost		
        this.txtallknwCost.setVisible(true);		
        this.txtallknwCost.setHorizontalAlignment(2);		
        this.txtallknwCost.setDataType(1);		
        this.txtallknwCost.setSupportedEmpty(true);		
        this.txtallknwCost.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtallknwCost.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtallknwCost.setPrecision(10);		
        this.txtallknwCost.setRequired(false);
        // txtallxfCost		
        this.txtallxfCost.setVisible(true);		
        this.txtallxfCost.setHorizontalAlignment(2);		
        this.txtallxfCost.setDataType(1);		
        this.txtallxfCost.setSupportedEmpty(true);		
        this.txtallxfCost.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtallxfCost.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtallxfCost.setPrecision(10);		
        this.txtallxfCost.setRequired(false);
        // txtalleyCost		
        this.txtalleyCost.setVisible(true);		
        this.txtalleyCost.setHorizontalAlignment(2);		
        this.txtalleyCost.setDataType(1);		
        this.txtalleyCost.setSupportedEmpty(true);		
        this.txtalleyCost.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtalleyCost.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtalleyCost.setPrecision(10);		
        this.txtalleyCost.setRequired(false);
        // txtallyzCost		
        this.txtallyzCost.setVisible(true);		
        this.txtallyzCost.setHorizontalAlignment(2);		
        this.txtallyzCost.setDataType(1);		
        this.txtallyzCost.setSupportedEmpty(true);		
        this.txtallyzCost.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtallyzCost.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtallyzCost.setPrecision(10);		
        this.txtallyzCost.setRequired(false);
        // txtallmbCost		
        this.txtallmbCost.setVisible(true);		
        this.txtallmbCost.setHorizontalAlignment(2);		
        this.txtallmbCost.setDataType(1);		
        this.txtallmbCost.setSupportedEmpty(true);		
        this.txtallmbCost.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtallmbCost.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtallmbCost.setPrecision(10);		
        this.txtallmbCost.setRequired(false);
        // txtupyzCost		
        this.txtupyzCost.setVisible(true);		
        this.txtupyzCost.setHorizontalAlignment(2);		
        this.txtupyzCost.setDataType(1);		
        this.txtupyzCost.setSupportedEmpty(true);		
        this.txtupyzCost.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtupyzCost.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtupyzCost.setPrecision(10);		
        this.txtupyzCost.setRequired(false);
        // txtallyxjzCost		
        this.txtallyxjzCost.setVisible(true);		
        this.txtallyxjzCost.setHorizontalAlignment(2);		
        this.txtallyxjzCost.setDataType(1);		
        this.txtallyxjzCost.setSupportedEmpty(true);		
        this.txtallyxjzCost.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtallyxjzCost.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtallyxjzCost.setPrecision(10);		
        this.txtallyxjzCost.setRequired(false);
        // status		
        this.status.setVisible(true);		
        this.status.addItems(EnumUtils.getEnumList("com.kingdee.eas.mw.pay.app.UpdateCostStatus").toArray());		
        this.status.setRequired(false);
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {txtbusinessDate,txtempNumber,txtempName,txtclinicNumber,txtcityNumber,txtcityName,txtclinicName,txtzzCost,txtgdjzCost,txtyxjzCost,txtyzCost,txtknwCost,txtmbCost,txtxfCost,txteyCost,chkizzidai,txtupzzCost,txtupyxjzCost,txtupgdjzCost,txtupknwCost,txtupxfCost,txtupeyCost,txtupmbCost,txtallzzCost,txtallgdjzCost,txtallknwCost,txtallxfCost,txtalleyCost,txtallyzCost,txtallmbCost,txtupyzCost,txtallyxjzCost,status}));
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
        this.setBounds(new Rectangle(0, 0, 1013, 389));
        this.setLayout(null);
        kDLabelContainer1.setBounds(new Rectangle(10, 346, 270, 19));
        this.add(kDLabelContainer1, null);
        kDLabelContainer2.setBounds(new Rectangle(341, 322, 270, 19));
        this.add(kDLabelContainer2, null);
        kDLabelContainer3.setBounds(new Rectangle(672, 322, 270, 19));
        this.add(kDLabelContainer3, null);
        kDLabelContainer4.setBounds(new Rectangle(341, 346, 270, 19));
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
        contclinicName.setBounds(new Rectangle(10, 58, 270, 19));
        this.add(contclinicName, null);
        contzzCost.setBounds(new Rectangle(672, 58, 270, 19));
        this.add(contzzCost, null);
        contgdjzCost.setBounds(new Rectangle(10, 82, 270, 19));
        this.add(contgdjzCost, null);
        contyxjzCost.setBounds(new Rectangle(341, 82, 270, 19));
        this.add(contyxjzCost, null);
        contyzCost.setBounds(new Rectangle(10, 106, 270, 19));
        this.add(contyzCost, null);
        contknwCost.setBounds(new Rectangle(672, 82, 270, 19));
        this.add(contknwCost, null);
        contmbCost.setBounds(new Rectangle(341, 106, 270, 19));
        this.add(contmbCost, null);
        contxfCost.setBounds(new Rectangle(672, 106, 270, 19));
        this.add(contxfCost, null);
        conteyCost.setBounds(new Rectangle(10, 130, 270, 19));
        this.add(conteyCost, null);
        contimzzCost.setBounds(new Rectangle(341, 130, 270, 19));
        this.add(contimzzCost, null);
        contimgdjzCost.setBounds(new Rectangle(672, 130, 270, 19));
        this.add(contimgdjzCost, null);
        contimyxjzCost.setBounds(new Rectangle(10, 154, 270, 19));
        this.add(contimyxjzCost, null);
        contimyzCost.setBounds(new Rectangle(341, 154, 270, 19));
        this.add(contimyzCost, null);
        contimknwCost.setBounds(new Rectangle(672, 154, 270, 19));
        this.add(contimknwCost, null);
        contimmbCost.setBounds(new Rectangle(10, 178, 270, 19));
        this.add(contimmbCost, null);
        contimeyCost.setBounds(new Rectangle(341, 178, 270, 19));
        this.add(contimeyCost, null);
        contimxfCost.setBounds(new Rectangle(672, 178, 270, 19));
        this.add(contimxfCost, null);
        chkizzidai.setBounds(new Rectangle(341, 58, 270, 19));
        this.add(chkizzidai, null);
        contupzzCost.setBounds(new Rectangle(10, 202, 270, 19));
        this.add(contupzzCost, null);
        contupyxjzCost.setBounds(new Rectangle(341, 202, 270, 19));
        this.add(contupyxjzCost, null);
        contupgdjzCost.setBounds(new Rectangle(672, 202, 270, 19));
        this.add(contupgdjzCost, null);
        contupknwCost.setBounds(new Rectangle(10, 226, 270, 19));
        this.add(contupknwCost, null);
        contupxfCost.setBounds(new Rectangle(341, 226, 270, 19));
        this.add(contupxfCost, null);
        contupeyCost.setBounds(new Rectangle(672, 226, 270, 19));
        this.add(contupeyCost, null);
        contupmbCost.setBounds(new Rectangle(341, 250, 270, 19));
        this.add(contupmbCost, null);
        contallzzCost.setBounds(new Rectangle(672, 250, 270, 19));
        this.add(contallzzCost, null);
        contallgdjzCost.setBounds(new Rectangle(341, 274, 270, 19));
        this.add(contallgdjzCost, null);
        contallknwCost.setBounds(new Rectangle(672, 274, 270, 19));
        this.add(contallknwCost, null);
        contallxfCost.setBounds(new Rectangle(10, 298, 270, 19));
        this.add(contallxfCost, null);
        contalleyCost.setBounds(new Rectangle(341, 298, 270, 19));
        this.add(contalleyCost, null);
        contallyzCost.setBounds(new Rectangle(672, 298, 270, 19));
        this.add(contallyzCost, null);
        contallmbCost.setBounds(new Rectangle(10, 322, 270, 19));
        this.add(contallmbCost, null);
        contupyzCost.setBounds(new Rectangle(10, 250, 270, 19));
        this.add(contupyzCost, null);
        contallyxjzCost.setBounds(new Rectangle(10, 274, 270, 19));
        this.add(contallyxjzCost, null);
        contstatus.setBounds(new Rectangle(672, 346, 270, 19));
        this.add(contstatus, null);
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
        //contclinicName
        contclinicName.setBoundEditor(txtclinicName);
        //contzzCost
        contzzCost.setBoundEditor(txtzzCost);
        //contgdjzCost
        contgdjzCost.setBoundEditor(txtgdjzCost);
        //contyxjzCost
        contyxjzCost.setBoundEditor(txtyxjzCost);
        //contyzCost
        contyzCost.setBoundEditor(txtyzCost);
        //contknwCost
        contknwCost.setBoundEditor(txtknwCost);
        //contmbCost
        contmbCost.setBoundEditor(txtmbCost);
        //contxfCost
        contxfCost.setBoundEditor(txtxfCost);
        //conteyCost
        conteyCost.setBoundEditor(txteyCost);
        //contimzzCost
        contimzzCost.setBoundEditor(txtimzzCost);
        //contimgdjzCost
        contimgdjzCost.setBoundEditor(txtimgdjzCost);
        //contimyxjzCost
        contimyxjzCost.setBoundEditor(txtimyxjzCost);
        //contimyzCost
        contimyzCost.setBoundEditor(txtimyzCost);
        //contimknwCost
        contimknwCost.setBoundEditor(txtimknwCost);
        //contimmbCost
        contimmbCost.setBoundEditor(txtimmbCost);
        //contimeyCost
        contimeyCost.setBoundEditor(txtimeyCost);
        //contimxfCost
        contimxfCost.setBoundEditor(txtimxfCost);
        //contupzzCost
        contupzzCost.setBoundEditor(txtupzzCost);
        //contupyxjzCost
        contupyxjzCost.setBoundEditor(txtupyxjzCost);
        //contupgdjzCost
        contupgdjzCost.setBoundEditor(txtupgdjzCost);
        //contupknwCost
        contupknwCost.setBoundEditor(txtupknwCost);
        //contupxfCost
        contupxfCost.setBoundEditor(txtupxfCost);
        //contupeyCost
        contupeyCost.setBoundEditor(txtupeyCost);
        //contupmbCost
        contupmbCost.setBoundEditor(txtupmbCost);
        //contallzzCost
        contallzzCost.setBoundEditor(txtallzzCost);
        //contallgdjzCost
        contallgdjzCost.setBoundEditor(txtallgdjzCost);
        //contallknwCost
        contallknwCost.setBoundEditor(txtallknwCost);
        //contallxfCost
        contallxfCost.setBoundEditor(txtallxfCost);
        //contalleyCost
        contalleyCost.setBoundEditor(txtalleyCost);
        //contallyzCost
        contallyzCost.setBoundEditor(txtallyzCost);
        //contallmbCost
        contallmbCost.setBoundEditor(txtallmbCost);
        //contupyzCost
        contupyzCost.setBoundEditor(txtupyzCost);
        //contallyxjzCost
        contallyxjzCost.setBoundEditor(txtallyxjzCost);
        //contstatus
        contstatus.setBoundEditor(status);

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
		dataBinder.registerBinding("izzidai", boolean.class, this.chkizzidai, "selected");
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
		dataBinder.registerBinding("clinicName", String.class, this.txtclinicName, "text");
		dataBinder.registerBinding("zzCost", java.math.BigDecimal.class, this.txtzzCost, "value");
		dataBinder.registerBinding("gdjzCost", java.math.BigDecimal.class, this.txtgdjzCost, "value");
		dataBinder.registerBinding("yxjzCost", java.math.BigDecimal.class, this.txtyxjzCost, "value");
		dataBinder.registerBinding("yzCost", java.math.BigDecimal.class, this.txtyzCost, "value");
		dataBinder.registerBinding("knwCost", java.math.BigDecimal.class, this.txtknwCost, "value");
		dataBinder.registerBinding("mbCost", java.math.BigDecimal.class, this.txtmbCost, "value");
		dataBinder.registerBinding("xfCost", java.math.BigDecimal.class, this.txtxfCost, "value");
		dataBinder.registerBinding("eyCost", java.math.BigDecimal.class, this.txteyCost, "value");
		dataBinder.registerBinding("imzzCost", java.math.BigDecimal.class, this.txtimzzCost, "value");
		dataBinder.registerBinding("imgdjzCost", java.math.BigDecimal.class, this.txtimgdjzCost, "value");
		dataBinder.registerBinding("imyxjzCost", java.math.BigDecimal.class, this.txtimyxjzCost, "value");
		dataBinder.registerBinding("imyzCost", java.math.BigDecimal.class, this.txtimyzCost, "value");
		dataBinder.registerBinding("imknwCost", java.math.BigDecimal.class, this.txtimknwCost, "value");
		dataBinder.registerBinding("immbCost", java.math.BigDecimal.class, this.txtimmbCost, "value");
		dataBinder.registerBinding("imeyCost", java.math.BigDecimal.class, this.txtimeyCost, "value");
		dataBinder.registerBinding("imxfCost", java.math.BigDecimal.class, this.txtimxfCost, "value");
		dataBinder.registerBinding("upzzCost", java.math.BigDecimal.class, this.txtupzzCost, "value");
		dataBinder.registerBinding("upyxjzCost", java.math.BigDecimal.class, this.txtupyxjzCost, "value");
		dataBinder.registerBinding("upgdjzCost", java.math.BigDecimal.class, this.txtupgdjzCost, "value");
		dataBinder.registerBinding("upknwCost", java.math.BigDecimal.class, this.txtupknwCost, "value");
		dataBinder.registerBinding("upxfCost", java.math.BigDecimal.class, this.txtupxfCost, "value");
		dataBinder.registerBinding("upeyCost", java.math.BigDecimal.class, this.txtupeyCost, "value");
		dataBinder.registerBinding("upmbCost", java.math.BigDecimal.class, this.txtupmbCost, "value");
		dataBinder.registerBinding("allzzCost", java.math.BigDecimal.class, this.txtallzzCost, "value");
		dataBinder.registerBinding("allgdjzCost", java.math.BigDecimal.class, this.txtallgdjzCost, "value");
		dataBinder.registerBinding("allknwCost", java.math.BigDecimal.class, this.txtallknwCost, "value");
		dataBinder.registerBinding("allxfCost", java.math.BigDecimal.class, this.txtallxfCost, "value");
		dataBinder.registerBinding("alleyCost", java.math.BigDecimal.class, this.txtalleyCost, "value");
		dataBinder.registerBinding("allyzCost", java.math.BigDecimal.class, this.txtallyzCost, "value");
		dataBinder.registerBinding("allmbCost", java.math.BigDecimal.class, this.txtallmbCost, "value");
		dataBinder.registerBinding("upyzCost", java.math.BigDecimal.class, this.txtupyzCost, "value");
		dataBinder.registerBinding("allyxjzCost", java.math.BigDecimal.class, this.txtallyxjzCost, "value");
		dataBinder.registerBinding("status", com.kingdee.eas.mw.pay.app.UpdateCostStatus.class, this.status, "selectedItem");		
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
	    return "com.kingdee.eas.mw.pay.app.ClinicCostSumEditUIHandler";
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
        this.editData = (com.kingdee.eas.mw.pay.ClinicCostSumInfo)ov;
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
		getValidateHelper().registerBindProperty("izzidai", ValidateHelper.ON_SAVE);    
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
		getValidateHelper().registerBindProperty("clinicName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("zzCost", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("gdjzCost", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("yxjzCost", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("yzCost", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("knwCost", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("mbCost", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("xfCost", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("eyCost", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("imzzCost", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("imgdjzCost", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("imyxjzCost", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("imyzCost", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("imknwCost", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("immbCost", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("imeyCost", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("imxfCost", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("upzzCost", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("upyxjzCost", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("upgdjzCost", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("upknwCost", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("upxfCost", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("upeyCost", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("upmbCost", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("allzzCost", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("allgdjzCost", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("allknwCost", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("allxfCost", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("alleyCost", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("allyzCost", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("allmbCost", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("upyzCost", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("allyxjzCost", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("status", ValidateHelper.ON_SAVE);    		
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
        sic.add(new SelectorItemInfo("izzidai"));
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
        sic.add(new SelectorItemInfo("clinicName"));
        sic.add(new SelectorItemInfo("zzCost"));
        sic.add(new SelectorItemInfo("gdjzCost"));
        sic.add(new SelectorItemInfo("yxjzCost"));
        sic.add(new SelectorItemInfo("yzCost"));
        sic.add(new SelectorItemInfo("knwCost"));
        sic.add(new SelectorItemInfo("mbCost"));
        sic.add(new SelectorItemInfo("xfCost"));
        sic.add(new SelectorItemInfo("eyCost"));
        sic.add(new SelectorItemInfo("imzzCost"));
        sic.add(new SelectorItemInfo("imgdjzCost"));
        sic.add(new SelectorItemInfo("imyxjzCost"));
        sic.add(new SelectorItemInfo("imyzCost"));
        sic.add(new SelectorItemInfo("imknwCost"));
        sic.add(new SelectorItemInfo("immbCost"));
        sic.add(new SelectorItemInfo("imeyCost"));
        sic.add(new SelectorItemInfo("imxfCost"));
        sic.add(new SelectorItemInfo("upzzCost"));
        sic.add(new SelectorItemInfo("upyxjzCost"));
        sic.add(new SelectorItemInfo("upgdjzCost"));
        sic.add(new SelectorItemInfo("upknwCost"));
        sic.add(new SelectorItemInfo("upxfCost"));
        sic.add(new SelectorItemInfo("upeyCost"));
        sic.add(new SelectorItemInfo("upmbCost"));
        sic.add(new SelectorItemInfo("allzzCost"));
        sic.add(new SelectorItemInfo("allgdjzCost"));
        sic.add(new SelectorItemInfo("allknwCost"));
        sic.add(new SelectorItemInfo("allxfCost"));
        sic.add(new SelectorItemInfo("alleyCost"));
        sic.add(new SelectorItemInfo("allyzCost"));
        sic.add(new SelectorItemInfo("allmbCost"));
        sic.add(new SelectorItemInfo("upyzCost"));
        sic.add(new SelectorItemInfo("allyxjzCost"));
        sic.add(new SelectorItemInfo("status"));
        return sic;
    }        

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.mw.pay.client", "ClinicCostSumEditUI");
    }

    /**
     * output getEditUIName method
     */
    protected String getEditUIName()
    {
        return com.kingdee.eas.mw.pay.client.ClinicCostSumEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.mw.pay.ClinicCostSumFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.mw.pay.ClinicCostSumInfo objectValue = new com.kingdee.eas.mw.pay.ClinicCostSumInfo();
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
		vo.put("status","wsh");
        
    }        
	protected void setFieldsNull(com.kingdee.bos.dao.AbstractObjectValue arg0) {
		super.setFieldsNull(arg0);
		arg0.put("number",null);
	}

}