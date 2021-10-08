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
public abstract class AbstractDocDetailBonusEditUI extends com.kingdee.eas.framework.client.EditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractDocDetailBonusEditUI.class);
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
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contjyCount;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contplaCount;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contzzAchieve;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contzzCost;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contgdjzAchieve;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contgdjzCost;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contyxjzAchieve;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contyxjzCost;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contzyAchieve;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contyzCost;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contknwAchieve;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contknwCost;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contmbAchieve;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contmbCost;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contxfAchieve;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contxfCost;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conteyAchieve;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conteyCost;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsumAchieve;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contzzMoney;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contgdjzMoney;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contyxjzMoney;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contknwMoney;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contyzMoney;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contmbMoney;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contxfMoney;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conteyMoney;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contotherMoney;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contzzBase;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contclinicAchieve;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contyxjzBase;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contgdjzBase;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contknwBase;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contxfBase;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conteyBase;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contyzBase;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contmbBase;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contclinicBase;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsumMoney;
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
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtjyCount;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtplaCount;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtzzAchieve;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtzzCost;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtgdjzAchieve;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtgdjzCost;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtyxjzAchieve;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtyxjzCost;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtzyAchieve;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtyzCost;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtknwAchieve;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtknwCost;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtmbAchieve;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtmbCost;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtxfAchieve;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtxfCost;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txteyAchieve;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txteyCost;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtsumAchieve;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtzzMoney;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtgdjzMoney;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtyxjzMoney;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtknwMoney;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtyzMoney;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtmbMoney;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtxfMoney;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txteyMoney;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtotherMoney;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtzzBase;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtclinicAchieve;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtyxjzBase;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtgdjzBase;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtknwBase;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtxfBase;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txteyBase;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtyzBase;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtmbBase;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtclinicBase;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtsumMoney;
    protected com.kingdee.eas.mw.pay.DocDetailBonusInfo editData = null;
    /**
     * output class constructor
     */
    public AbstractDocDetailBonusEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractDocDetailBonusEditUI.class.getName());
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
        this.contjyCount = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contplaCount = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contzzAchieve = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contzzCost = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contgdjzAchieve = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contgdjzCost = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contyxjzAchieve = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contyxjzCost = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contzyAchieve = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contyzCost = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contknwAchieve = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contknwCost = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contmbAchieve = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contmbCost = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contxfAchieve = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contxfCost = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conteyAchieve = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conteyCost = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contsumAchieve = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contzzMoney = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contgdjzMoney = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contyxjzMoney = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contknwMoney = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contyzMoney = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contmbMoney = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contxfMoney = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conteyMoney = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contotherMoney = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contzzBase = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contclinicAchieve = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contyxjzBase = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contgdjzBase = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contknwBase = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contxfBase = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conteyBase = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contyzBase = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contmbBase = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contclinicBase = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contsumMoney = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
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
        this.txtjyCount = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtplaCount = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtzzAchieve = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtzzCost = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtgdjzAchieve = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtgdjzCost = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtyxjzAchieve = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtyxjzCost = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtzyAchieve = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtyzCost = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtknwAchieve = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtknwCost = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtmbAchieve = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtmbCost = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtxfAchieve = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtxfCost = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txteyAchieve = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txteyCost = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtsumAchieve = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtzzMoney = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtgdjzMoney = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtyxjzMoney = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtknwMoney = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtyzMoney = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtmbMoney = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtxfMoney = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txteyMoney = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtotherMoney = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtzzBase = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtclinicAchieve = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtyxjzBase = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtgdjzBase = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtknwBase = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtxfBase = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txteyBase = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtyzBase = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtmbBase = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtclinicBase = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtsumMoney = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
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
        this.contjyCount.setName("contjyCount");
        this.contplaCount.setName("contplaCount");
        this.contzzAchieve.setName("contzzAchieve");
        this.contzzCost.setName("contzzCost");
        this.contgdjzAchieve.setName("contgdjzAchieve");
        this.contgdjzCost.setName("contgdjzCost");
        this.contyxjzAchieve.setName("contyxjzAchieve");
        this.contyxjzCost.setName("contyxjzCost");
        this.contzyAchieve.setName("contzyAchieve");
        this.contyzCost.setName("contyzCost");
        this.contknwAchieve.setName("contknwAchieve");
        this.contknwCost.setName("contknwCost");
        this.contmbAchieve.setName("contmbAchieve");
        this.contmbCost.setName("contmbCost");
        this.contxfAchieve.setName("contxfAchieve");
        this.contxfCost.setName("contxfCost");
        this.conteyAchieve.setName("conteyAchieve");
        this.conteyCost.setName("conteyCost");
        this.contsumAchieve.setName("contsumAchieve");
        this.contzzMoney.setName("contzzMoney");
        this.contgdjzMoney.setName("contgdjzMoney");
        this.contyxjzMoney.setName("contyxjzMoney");
        this.contknwMoney.setName("contknwMoney");
        this.contyzMoney.setName("contyzMoney");
        this.contmbMoney.setName("contmbMoney");
        this.contxfMoney.setName("contxfMoney");
        this.conteyMoney.setName("conteyMoney");
        this.contotherMoney.setName("contotherMoney");
        this.contzzBase.setName("contzzBase");
        this.contclinicAchieve.setName("contclinicAchieve");
        this.contyxjzBase.setName("contyxjzBase");
        this.contgdjzBase.setName("contgdjzBase");
        this.contknwBase.setName("contknwBase");
        this.contxfBase.setName("contxfBase");
        this.conteyBase.setName("conteyBase");
        this.contyzBase.setName("contyzBase");
        this.contmbBase.setName("contmbBase");
        this.contclinicBase.setName("contclinicBase");
        this.contsumMoney.setName("contsumMoney");
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
        this.txtjyCount.setName("txtjyCount");
        this.txtplaCount.setName("txtplaCount");
        this.txtzzAchieve.setName("txtzzAchieve");
        this.txtzzCost.setName("txtzzCost");
        this.txtgdjzAchieve.setName("txtgdjzAchieve");
        this.txtgdjzCost.setName("txtgdjzCost");
        this.txtyxjzAchieve.setName("txtyxjzAchieve");
        this.txtyxjzCost.setName("txtyxjzCost");
        this.txtzyAchieve.setName("txtzyAchieve");
        this.txtyzCost.setName("txtyzCost");
        this.txtknwAchieve.setName("txtknwAchieve");
        this.txtknwCost.setName("txtknwCost");
        this.txtmbAchieve.setName("txtmbAchieve");
        this.txtmbCost.setName("txtmbCost");
        this.txtxfAchieve.setName("txtxfAchieve");
        this.txtxfCost.setName("txtxfCost");
        this.txteyAchieve.setName("txteyAchieve");
        this.txteyCost.setName("txteyCost");
        this.txtsumAchieve.setName("txtsumAchieve");
        this.txtzzMoney.setName("txtzzMoney");
        this.txtgdjzMoney.setName("txtgdjzMoney");
        this.txtyxjzMoney.setName("txtyxjzMoney");
        this.txtknwMoney.setName("txtknwMoney");
        this.txtyzMoney.setName("txtyzMoney");
        this.txtmbMoney.setName("txtmbMoney");
        this.txtxfMoney.setName("txtxfMoney");
        this.txteyMoney.setName("txteyMoney");
        this.txtotherMoney.setName("txtotherMoney");
        this.txtzzBase.setName("txtzzBase");
        this.txtclinicAchieve.setName("txtclinicAchieve");
        this.txtyxjzBase.setName("txtyxjzBase");
        this.txtgdjzBase.setName("txtgdjzBase");
        this.txtknwBase.setName("txtknwBase");
        this.txtxfBase.setName("txtxfBase");
        this.txteyBase.setName("txteyBase");
        this.txtyzBase.setName("txtyzBase");
        this.txtmbBase.setName("txtmbBase");
        this.txtclinicBase.setName("txtclinicBase");
        this.txtsumMoney.setName("txtsumMoney");
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
        // contjyCount		
        this.contjyCount.setBoundLabelText(resHelper.getString("contjyCount.boundLabelText"));		
        this.contjyCount.setBoundLabelLength(100);		
        this.contjyCount.setBoundLabelUnderline(true);		
        this.contjyCount.setVisible(true);
        // contplaCount		
        this.contplaCount.setBoundLabelText(resHelper.getString("contplaCount.boundLabelText"));		
        this.contplaCount.setBoundLabelLength(100);		
        this.contplaCount.setBoundLabelUnderline(true);		
        this.contplaCount.setVisible(true);
        // contzzAchieve		
        this.contzzAchieve.setBoundLabelText(resHelper.getString("contzzAchieve.boundLabelText"));		
        this.contzzAchieve.setBoundLabelLength(100);		
        this.contzzAchieve.setBoundLabelUnderline(true);		
        this.contzzAchieve.setVisible(true);
        // contzzCost		
        this.contzzCost.setBoundLabelText(resHelper.getString("contzzCost.boundLabelText"));		
        this.contzzCost.setBoundLabelLength(100);		
        this.contzzCost.setBoundLabelUnderline(true);		
        this.contzzCost.setVisible(true);
        // contgdjzAchieve		
        this.contgdjzAchieve.setBoundLabelText(resHelper.getString("contgdjzAchieve.boundLabelText"));		
        this.contgdjzAchieve.setBoundLabelLength(100);		
        this.contgdjzAchieve.setBoundLabelUnderline(true);		
        this.contgdjzAchieve.setVisible(true);
        // contgdjzCost		
        this.contgdjzCost.setBoundLabelText(resHelper.getString("contgdjzCost.boundLabelText"));		
        this.contgdjzCost.setBoundLabelLength(100);		
        this.contgdjzCost.setBoundLabelUnderline(true);		
        this.contgdjzCost.setVisible(true);
        // contyxjzAchieve		
        this.contyxjzAchieve.setBoundLabelText(resHelper.getString("contyxjzAchieve.boundLabelText"));		
        this.contyxjzAchieve.setBoundLabelLength(100);		
        this.contyxjzAchieve.setBoundLabelUnderline(true);		
        this.contyxjzAchieve.setVisible(true);
        // contyxjzCost		
        this.contyxjzCost.setBoundLabelText(resHelper.getString("contyxjzCost.boundLabelText"));		
        this.contyxjzCost.setBoundLabelLength(100);		
        this.contyxjzCost.setBoundLabelUnderline(true);		
        this.contyxjzCost.setVisible(true);
        // contzyAchieve		
        this.contzyAchieve.setBoundLabelText(resHelper.getString("contzyAchieve.boundLabelText"));		
        this.contzyAchieve.setBoundLabelLength(100);		
        this.contzyAchieve.setBoundLabelUnderline(true);		
        this.contzyAchieve.setVisible(true);
        // contyzCost		
        this.contyzCost.setBoundLabelText(resHelper.getString("contyzCost.boundLabelText"));		
        this.contyzCost.setBoundLabelLength(100);		
        this.contyzCost.setBoundLabelUnderline(true);		
        this.contyzCost.setVisible(true);
        // contknwAchieve		
        this.contknwAchieve.setBoundLabelText(resHelper.getString("contknwAchieve.boundLabelText"));		
        this.contknwAchieve.setBoundLabelLength(100);		
        this.contknwAchieve.setBoundLabelUnderline(true);		
        this.contknwAchieve.setVisible(true);
        // contknwCost		
        this.contknwCost.setBoundLabelText(resHelper.getString("contknwCost.boundLabelText"));		
        this.contknwCost.setBoundLabelLength(100);		
        this.contknwCost.setBoundLabelUnderline(true);		
        this.contknwCost.setVisible(true);
        // contmbAchieve		
        this.contmbAchieve.setBoundLabelText(resHelper.getString("contmbAchieve.boundLabelText"));		
        this.contmbAchieve.setBoundLabelLength(100);		
        this.contmbAchieve.setBoundLabelUnderline(true);		
        this.contmbAchieve.setVisible(true);
        // contmbCost		
        this.contmbCost.setBoundLabelText(resHelper.getString("contmbCost.boundLabelText"));		
        this.contmbCost.setBoundLabelLength(100);		
        this.contmbCost.setBoundLabelUnderline(true);		
        this.contmbCost.setVisible(true);
        // contxfAchieve		
        this.contxfAchieve.setBoundLabelText(resHelper.getString("contxfAchieve.boundLabelText"));		
        this.contxfAchieve.setBoundLabelLength(100);		
        this.contxfAchieve.setBoundLabelUnderline(true);		
        this.contxfAchieve.setVisible(true);
        // contxfCost		
        this.contxfCost.setBoundLabelText(resHelper.getString("contxfCost.boundLabelText"));		
        this.contxfCost.setBoundLabelLength(100);		
        this.contxfCost.setBoundLabelUnderline(true);		
        this.contxfCost.setVisible(true);
        // conteyAchieve		
        this.conteyAchieve.setBoundLabelText(resHelper.getString("conteyAchieve.boundLabelText"));		
        this.conteyAchieve.setBoundLabelLength(100);		
        this.conteyAchieve.setBoundLabelUnderline(true);		
        this.conteyAchieve.setVisible(true);
        // conteyCost		
        this.conteyCost.setBoundLabelText(resHelper.getString("conteyCost.boundLabelText"));		
        this.conteyCost.setBoundLabelLength(100);		
        this.conteyCost.setBoundLabelUnderline(true);		
        this.conteyCost.setVisible(true);
        // contsumAchieve		
        this.contsumAchieve.setBoundLabelText(resHelper.getString("contsumAchieve.boundLabelText"));		
        this.contsumAchieve.setBoundLabelLength(100);		
        this.contsumAchieve.setBoundLabelUnderline(true);		
        this.contsumAchieve.setVisible(true);
        // contzzMoney		
        this.contzzMoney.setBoundLabelText(resHelper.getString("contzzMoney.boundLabelText"));		
        this.contzzMoney.setBoundLabelLength(100);		
        this.contzzMoney.setBoundLabelUnderline(true);		
        this.contzzMoney.setVisible(true);
        // contgdjzMoney		
        this.contgdjzMoney.setBoundLabelText(resHelper.getString("contgdjzMoney.boundLabelText"));		
        this.contgdjzMoney.setBoundLabelLength(100);		
        this.contgdjzMoney.setBoundLabelUnderline(true);		
        this.contgdjzMoney.setVisible(true);
        // contyxjzMoney		
        this.contyxjzMoney.setBoundLabelText(resHelper.getString("contyxjzMoney.boundLabelText"));		
        this.contyxjzMoney.setBoundLabelLength(100);		
        this.contyxjzMoney.setBoundLabelUnderline(true);		
        this.contyxjzMoney.setVisible(true);
        // contknwMoney		
        this.contknwMoney.setBoundLabelText(resHelper.getString("contknwMoney.boundLabelText"));		
        this.contknwMoney.setBoundLabelLength(100);		
        this.contknwMoney.setBoundLabelUnderline(true);		
        this.contknwMoney.setVisible(true);
        // contyzMoney		
        this.contyzMoney.setBoundLabelText(resHelper.getString("contyzMoney.boundLabelText"));		
        this.contyzMoney.setBoundLabelLength(100);		
        this.contyzMoney.setBoundLabelUnderline(true);		
        this.contyzMoney.setVisible(true);
        // contmbMoney		
        this.contmbMoney.setBoundLabelText(resHelper.getString("contmbMoney.boundLabelText"));		
        this.contmbMoney.setBoundLabelLength(100);		
        this.contmbMoney.setBoundLabelUnderline(true);		
        this.contmbMoney.setVisible(true);
        // contxfMoney		
        this.contxfMoney.setBoundLabelText(resHelper.getString("contxfMoney.boundLabelText"));		
        this.contxfMoney.setBoundLabelLength(100);		
        this.contxfMoney.setBoundLabelUnderline(true);		
        this.contxfMoney.setVisible(true);
        // conteyMoney		
        this.conteyMoney.setBoundLabelText(resHelper.getString("conteyMoney.boundLabelText"));		
        this.conteyMoney.setBoundLabelLength(100);		
        this.conteyMoney.setBoundLabelUnderline(true);		
        this.conteyMoney.setVisible(true);
        // contotherMoney		
        this.contotherMoney.setBoundLabelText(resHelper.getString("contotherMoney.boundLabelText"));		
        this.contotherMoney.setBoundLabelLength(100);		
        this.contotherMoney.setBoundLabelUnderline(true);		
        this.contotherMoney.setVisible(true);
        // contzzBase		
        this.contzzBase.setBoundLabelText(resHelper.getString("contzzBase.boundLabelText"));		
        this.contzzBase.setBoundLabelLength(100);		
        this.contzzBase.setBoundLabelUnderline(true);		
        this.contzzBase.setVisible(true);
        // contclinicAchieve		
        this.contclinicAchieve.setBoundLabelText(resHelper.getString("contclinicAchieve.boundLabelText"));		
        this.contclinicAchieve.setBoundLabelLength(100);		
        this.contclinicAchieve.setBoundLabelUnderline(true);		
        this.contclinicAchieve.setVisible(true);
        // contyxjzBase		
        this.contyxjzBase.setBoundLabelText(resHelper.getString("contyxjzBase.boundLabelText"));		
        this.contyxjzBase.setBoundLabelLength(100);		
        this.contyxjzBase.setBoundLabelUnderline(true);		
        this.contyxjzBase.setVisible(true);
        // contgdjzBase		
        this.contgdjzBase.setBoundLabelText(resHelper.getString("contgdjzBase.boundLabelText"));		
        this.contgdjzBase.setBoundLabelLength(100);		
        this.contgdjzBase.setBoundLabelUnderline(true);		
        this.contgdjzBase.setVisible(true);
        // contknwBase		
        this.contknwBase.setBoundLabelText(resHelper.getString("contknwBase.boundLabelText"));		
        this.contknwBase.setBoundLabelLength(100);		
        this.contknwBase.setBoundLabelUnderline(true);		
        this.contknwBase.setVisible(true);
        // contxfBase		
        this.contxfBase.setBoundLabelText(resHelper.getString("contxfBase.boundLabelText"));		
        this.contxfBase.setBoundLabelLength(100);		
        this.contxfBase.setBoundLabelUnderline(true);		
        this.contxfBase.setVisible(true);
        // conteyBase		
        this.conteyBase.setBoundLabelText(resHelper.getString("conteyBase.boundLabelText"));		
        this.conteyBase.setBoundLabelLength(100);		
        this.conteyBase.setBoundLabelUnderline(true);		
        this.conteyBase.setVisible(true);
        // contyzBase		
        this.contyzBase.setBoundLabelText(resHelper.getString("contyzBase.boundLabelText"));		
        this.contyzBase.setBoundLabelLength(100);		
        this.contyzBase.setBoundLabelUnderline(true);		
        this.contyzBase.setVisible(true);
        // contmbBase		
        this.contmbBase.setBoundLabelText(resHelper.getString("contmbBase.boundLabelText"));		
        this.contmbBase.setBoundLabelLength(100);		
        this.contmbBase.setBoundLabelUnderline(true);		
        this.contmbBase.setVisible(true);
        // contclinicBase		
        this.contclinicBase.setBoundLabelText(resHelper.getString("contclinicBase.boundLabelText"));		
        this.contclinicBase.setBoundLabelLength(100);		
        this.contclinicBase.setBoundLabelUnderline(true);		
        this.contclinicBase.setVisible(true);
        // contsumMoney		
        this.contsumMoney.setBoundLabelText(resHelper.getString("contsumMoney.boundLabelText"));		
        this.contsumMoney.setBoundLabelLength(100);		
        this.contsumMoney.setBoundLabelUnderline(true);		
        this.contsumMoney.setVisible(true);
        // txtNumber		
        this.txtNumber.setMaxLength(80);		
        this.txtNumber.setVisible(false);
        // txtName		
        this.txtName.setVisible(false);
        // txtSimpleName		
        this.txtSimpleName.setMaxLength(80);		
        this.txtSimpleName.setVisible(false);
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
        // txtclinicName		
        this.txtclinicName.setHorizontalAlignment(2);		
        this.txtclinicName.setMaxLength(100);		
        this.txtclinicName.setRequired(false);
        // txtjyCount		
        this.txtjyCount.setHorizontalAlignment(2);		
        this.txtjyCount.setDataType(1);		
        this.txtjyCount.setSupportedEmpty(true);		
        this.txtjyCount.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtjyCount.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtjyCount.setPrecision(10);		
        this.txtjyCount.setRequired(false);
        // txtplaCount		
        this.txtplaCount.setHorizontalAlignment(2);		
        this.txtplaCount.setDataType(1);		
        this.txtplaCount.setSupportedEmpty(true);		
        this.txtplaCount.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtplaCount.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtplaCount.setPrecision(10);		
        this.txtplaCount.setRequired(false);
        // txtzzAchieve		
        this.txtzzAchieve.setHorizontalAlignment(2);		
        this.txtzzAchieve.setDataType(1);		
        this.txtzzAchieve.setSupportedEmpty(true);		
        this.txtzzAchieve.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtzzAchieve.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtzzAchieve.setPrecision(10);		
        this.txtzzAchieve.setRequired(false);
        // txtzzCost		
        this.txtzzCost.setHorizontalAlignment(2);		
        this.txtzzCost.setDataType(1);		
        this.txtzzCost.setSupportedEmpty(true);		
        this.txtzzCost.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtzzCost.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtzzCost.setPrecision(10);		
        this.txtzzCost.setRequired(false);
        // txtgdjzAchieve		
        this.txtgdjzAchieve.setHorizontalAlignment(2);		
        this.txtgdjzAchieve.setDataType(1);		
        this.txtgdjzAchieve.setSupportedEmpty(true);		
        this.txtgdjzAchieve.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtgdjzAchieve.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtgdjzAchieve.setPrecision(10);		
        this.txtgdjzAchieve.setRequired(false);
        // txtgdjzCost		
        this.txtgdjzCost.setHorizontalAlignment(2);		
        this.txtgdjzCost.setDataType(1);		
        this.txtgdjzCost.setSupportedEmpty(true);		
        this.txtgdjzCost.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtgdjzCost.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtgdjzCost.setPrecision(10);		
        this.txtgdjzCost.setRequired(false);
        // txtyxjzAchieve		
        this.txtyxjzAchieve.setHorizontalAlignment(2);		
        this.txtyxjzAchieve.setDataType(1);		
        this.txtyxjzAchieve.setSupportedEmpty(true);		
        this.txtyxjzAchieve.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtyxjzAchieve.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtyxjzAchieve.setPrecision(10);		
        this.txtyxjzAchieve.setRequired(false);
        // txtyxjzCost		
        this.txtyxjzCost.setHorizontalAlignment(2);		
        this.txtyxjzCost.setDataType(1);		
        this.txtyxjzCost.setSupportedEmpty(true);		
        this.txtyxjzCost.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtyxjzCost.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtyxjzCost.setPrecision(10);		
        this.txtyxjzCost.setRequired(false);
        // txtzyAchieve		
        this.txtzyAchieve.setHorizontalAlignment(2);		
        this.txtzyAchieve.setDataType(1);		
        this.txtzyAchieve.setSupportedEmpty(true);		
        this.txtzyAchieve.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtzyAchieve.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtzyAchieve.setPrecision(10);		
        this.txtzyAchieve.setRequired(false);
        // txtyzCost		
        this.txtyzCost.setHorizontalAlignment(2);		
        this.txtyzCost.setDataType(1);		
        this.txtyzCost.setSupportedEmpty(true);		
        this.txtyzCost.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtyzCost.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtyzCost.setPrecision(10);		
        this.txtyzCost.setRequired(false);
        // txtknwAchieve		
        this.txtknwAchieve.setHorizontalAlignment(2);		
        this.txtknwAchieve.setDataType(1);		
        this.txtknwAchieve.setSupportedEmpty(true);		
        this.txtknwAchieve.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtknwAchieve.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtknwAchieve.setPrecision(10);		
        this.txtknwAchieve.setRequired(false);
        // txtknwCost		
        this.txtknwCost.setHorizontalAlignment(2);		
        this.txtknwCost.setDataType(1);		
        this.txtknwCost.setSupportedEmpty(true);		
        this.txtknwCost.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtknwCost.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtknwCost.setPrecision(10);		
        this.txtknwCost.setRequired(false);
        // txtmbAchieve		
        this.txtmbAchieve.setHorizontalAlignment(2);		
        this.txtmbAchieve.setDataType(1);		
        this.txtmbAchieve.setSupportedEmpty(true);		
        this.txtmbAchieve.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtmbAchieve.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtmbAchieve.setPrecision(10);		
        this.txtmbAchieve.setRequired(false);
        // txtmbCost		
        this.txtmbCost.setHorizontalAlignment(2);		
        this.txtmbCost.setDataType(1);		
        this.txtmbCost.setSupportedEmpty(true);		
        this.txtmbCost.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtmbCost.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtmbCost.setPrecision(10);		
        this.txtmbCost.setRequired(false);
        // txtxfAchieve		
        this.txtxfAchieve.setHorizontalAlignment(2);		
        this.txtxfAchieve.setDataType(1);		
        this.txtxfAchieve.setSupportedEmpty(true);		
        this.txtxfAchieve.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtxfAchieve.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtxfAchieve.setPrecision(10);		
        this.txtxfAchieve.setRequired(false);
        // txtxfCost		
        this.txtxfCost.setHorizontalAlignment(2);		
        this.txtxfCost.setDataType(1);		
        this.txtxfCost.setSupportedEmpty(true);		
        this.txtxfCost.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtxfCost.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtxfCost.setPrecision(10);		
        this.txtxfCost.setRequired(false);
        // txteyAchieve		
        this.txteyAchieve.setHorizontalAlignment(2);		
        this.txteyAchieve.setDataType(1);		
        this.txteyAchieve.setSupportedEmpty(true);		
        this.txteyAchieve.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txteyAchieve.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txteyAchieve.setPrecision(10);		
        this.txteyAchieve.setRequired(false);
        // txteyCost		
        this.txteyCost.setHorizontalAlignment(2);		
        this.txteyCost.setDataType(1);		
        this.txteyCost.setSupportedEmpty(true);		
        this.txteyCost.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txteyCost.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txteyCost.setPrecision(10);		
        this.txteyCost.setRequired(false);
        // txtsumAchieve		
        this.txtsumAchieve.setHorizontalAlignment(2);		
        this.txtsumAchieve.setDataType(1);		
        this.txtsumAchieve.setSupportedEmpty(true);		
        this.txtsumAchieve.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtsumAchieve.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtsumAchieve.setPrecision(10);		
        this.txtsumAchieve.setRequired(false);
        // txtzzMoney		
        this.txtzzMoney.setHorizontalAlignment(2);		
        this.txtzzMoney.setDataType(1);		
        this.txtzzMoney.setSupportedEmpty(true);		
        this.txtzzMoney.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtzzMoney.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtzzMoney.setPrecision(10);		
        this.txtzzMoney.setRequired(false);
        // txtgdjzMoney		
        this.txtgdjzMoney.setHorizontalAlignment(2);		
        this.txtgdjzMoney.setDataType(1);		
        this.txtgdjzMoney.setSupportedEmpty(true);		
        this.txtgdjzMoney.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtgdjzMoney.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtgdjzMoney.setPrecision(10);		
        this.txtgdjzMoney.setRequired(false);
        // txtyxjzMoney		
        this.txtyxjzMoney.setHorizontalAlignment(2);		
        this.txtyxjzMoney.setDataType(1);		
        this.txtyxjzMoney.setSupportedEmpty(true);		
        this.txtyxjzMoney.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtyxjzMoney.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtyxjzMoney.setPrecision(10);		
        this.txtyxjzMoney.setRequired(false);
        // txtknwMoney		
        this.txtknwMoney.setHorizontalAlignment(2);		
        this.txtknwMoney.setDataType(1);		
        this.txtknwMoney.setSupportedEmpty(true);		
        this.txtknwMoney.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtknwMoney.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtknwMoney.setPrecision(10);		
        this.txtknwMoney.setRequired(false);
        // txtyzMoney		
        this.txtyzMoney.setHorizontalAlignment(2);		
        this.txtyzMoney.setDataType(1);		
        this.txtyzMoney.setSupportedEmpty(true);		
        this.txtyzMoney.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtyzMoney.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtyzMoney.setPrecision(10);		
        this.txtyzMoney.setRequired(false);
        // txtmbMoney		
        this.txtmbMoney.setHorizontalAlignment(2);		
        this.txtmbMoney.setDataType(1);		
        this.txtmbMoney.setSupportedEmpty(true);		
        this.txtmbMoney.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtmbMoney.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtmbMoney.setPrecision(10);		
        this.txtmbMoney.setRequired(false);
        // txtxfMoney		
        this.txtxfMoney.setHorizontalAlignment(2);		
        this.txtxfMoney.setDataType(1);		
        this.txtxfMoney.setSupportedEmpty(true);		
        this.txtxfMoney.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtxfMoney.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtxfMoney.setPrecision(10);		
        this.txtxfMoney.setRequired(false);
        // txteyMoney		
        this.txteyMoney.setHorizontalAlignment(2);		
        this.txteyMoney.setDataType(1);		
        this.txteyMoney.setSupportedEmpty(true);		
        this.txteyMoney.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txteyMoney.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txteyMoney.setPrecision(10);		
        this.txteyMoney.setRequired(false);
        // txtotherMoney		
        this.txtotherMoney.setHorizontalAlignment(2);		
        this.txtotherMoney.setDataType(1);		
        this.txtotherMoney.setSupportedEmpty(true);		
        this.txtotherMoney.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtotherMoney.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtotherMoney.setPrecision(10);		
        this.txtotherMoney.setRequired(false);
        // txtzzBase		
        this.txtzzBase.setVisible(true);		
        this.txtzzBase.setHorizontalAlignment(2);		
        this.txtzzBase.setDataType(1);		
        this.txtzzBase.setSupportedEmpty(true);		
        this.txtzzBase.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtzzBase.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtzzBase.setPrecision(10);		
        this.txtzzBase.setRequired(false);
        // txtclinicAchieve		
        this.txtclinicAchieve.setVisible(true);		
        this.txtclinicAchieve.setHorizontalAlignment(2);		
        this.txtclinicAchieve.setDataType(1);		
        this.txtclinicAchieve.setSupportedEmpty(true);		
        this.txtclinicAchieve.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtclinicAchieve.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtclinicAchieve.setPrecision(10);		
        this.txtclinicAchieve.setRequired(false);
        // txtyxjzBase		
        this.txtyxjzBase.setVisible(true);		
        this.txtyxjzBase.setHorizontalAlignment(2);		
        this.txtyxjzBase.setDataType(1);		
        this.txtyxjzBase.setSupportedEmpty(true);		
        this.txtyxjzBase.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtyxjzBase.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtyxjzBase.setPrecision(10);		
        this.txtyxjzBase.setRequired(false);
        // txtgdjzBase		
        this.txtgdjzBase.setVisible(true);		
        this.txtgdjzBase.setHorizontalAlignment(2);		
        this.txtgdjzBase.setDataType(1);		
        this.txtgdjzBase.setSupportedEmpty(true);		
        this.txtgdjzBase.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtgdjzBase.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtgdjzBase.setPrecision(10);		
        this.txtgdjzBase.setRequired(false);
        // txtknwBase		
        this.txtknwBase.setVisible(true);		
        this.txtknwBase.setHorizontalAlignment(2);		
        this.txtknwBase.setDataType(1);		
        this.txtknwBase.setSupportedEmpty(true);		
        this.txtknwBase.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtknwBase.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtknwBase.setPrecision(10);		
        this.txtknwBase.setRequired(false);
        // txtxfBase		
        this.txtxfBase.setVisible(true);		
        this.txtxfBase.setHorizontalAlignment(2);		
        this.txtxfBase.setDataType(1);		
        this.txtxfBase.setSupportedEmpty(true);		
        this.txtxfBase.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtxfBase.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtxfBase.setPrecision(10);		
        this.txtxfBase.setRequired(false);
        // txteyBase		
        this.txteyBase.setVisible(true);		
        this.txteyBase.setHorizontalAlignment(2);		
        this.txteyBase.setDataType(1);		
        this.txteyBase.setSupportedEmpty(true);		
        this.txteyBase.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txteyBase.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txteyBase.setPrecision(10);		
        this.txteyBase.setRequired(false);
        // txtyzBase		
        this.txtyzBase.setVisible(true);		
        this.txtyzBase.setHorizontalAlignment(2);		
        this.txtyzBase.setDataType(1);		
        this.txtyzBase.setSupportedEmpty(true);		
        this.txtyzBase.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtyzBase.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtyzBase.setPrecision(10);		
        this.txtyzBase.setRequired(false);
        // txtmbBase		
        this.txtmbBase.setVisible(true);		
        this.txtmbBase.setHorizontalAlignment(2);		
        this.txtmbBase.setDataType(1);		
        this.txtmbBase.setSupportedEmpty(true);		
        this.txtmbBase.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtmbBase.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtmbBase.setPrecision(10);		
        this.txtmbBase.setRequired(false);
        // txtclinicBase		
        this.txtclinicBase.setVisible(true);		
        this.txtclinicBase.setHorizontalAlignment(2);		
        this.txtclinicBase.setDataType(1);		
        this.txtclinicBase.setSupportedEmpty(true);		
        this.txtclinicBase.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtclinicBase.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtclinicBase.setPrecision(10);		
        this.txtclinicBase.setRequired(false);
        // txtsumMoney		
        this.txtsumMoney.setVisible(true);		
        this.txtsumMoney.setHorizontalAlignment(2);		
        this.txtsumMoney.setDataType(1);		
        this.txtsumMoney.setSupportedEmpty(true);		
        this.txtsumMoney.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtsumMoney.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtsumMoney.setPrecision(10);		
        this.txtsumMoney.setRequired(false);
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {txtgdjzMoney,txtyxjzMoney,txtknwMoney,txtyzMoney,txtmbMoney,txtxfMoney,txteyMoney,txtName,txtNumber,txtDescription,txtSimpleName,txtbusinessDate,txtempNumber,txtempName,txtclinicNumber,txtcityNumber,txtcityName,txtclinicName,txtjyCount,txtplaCount,txtzzAchieve,txtzzCost,txtgdjzAchieve,txtgdjzCost,txtyxjzAchieve,txtyxjzCost,txtzyAchieve,txtyzCost,txtknwAchieve,txtknwCost,txtmbAchieve,txtmbCost,txtxfAchieve,txtxfCost,txteyAchieve,txteyCost,txtsumAchieve,txtzzMoney,txtotherMoney,txtclinicAchieve,txtzzBase,txtyxjzBase,txtgdjzBase,txtknwBase,txtxfBase,txteyBase,txtyzBase,txtmbBase,txtclinicBase,txtsumMoney}));
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
        this.setBounds(new Rectangle(0, 0, 1013, 437));
        this.setLayout(null);
        kDLabelContainer1.setBounds(new Rectangle(672, 370, 270, 19));
        this.add(kDLabelContainer1, null);
        kDLabelContainer2.setBounds(new Rectangle(341, 370, 270, 19));
        this.add(kDLabelContainer2, null);
        kDLabelContainer3.setBounds(new Rectangle(341, 394, 270, 19));
        this.add(kDLabelContainer3, null);
        kDLabelContainer4.setBounds(new Rectangle(10, 394, 270, 19));
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
        contjyCount.setBounds(new Rectangle(341, 58, 270, 19));
        this.add(contjyCount, null);
        contplaCount.setBounds(new Rectangle(672, 58, 270, 19));
        this.add(contplaCount, null);
        contzzAchieve.setBounds(new Rectangle(10, 82, 270, 19));
        this.add(contzzAchieve, null);
        contzzCost.setBounds(new Rectangle(341, 82, 270, 19));
        this.add(contzzCost, null);
        contgdjzAchieve.setBounds(new Rectangle(10, 130, 270, 19));
        this.add(contgdjzAchieve, null);
        contgdjzCost.setBounds(new Rectangle(341, 130, 270, 19));
        this.add(contgdjzCost, null);
        contyxjzAchieve.setBounds(new Rectangle(10, 106, 270, 19));
        this.add(contyxjzAchieve, null);
        contyxjzCost.setBounds(new Rectangle(341, 106, 270, 19));
        this.add(contyxjzCost, null);
        contzyAchieve.setBounds(new Rectangle(10, 226, 270, 19));
        this.add(contzyAchieve, null);
        contyzCost.setBounds(new Rectangle(341, 226, 270, 19));
        this.add(contyzCost, null);
        contknwAchieve.setBounds(new Rectangle(10, 154, 270, 19));
        this.add(contknwAchieve, null);
        contknwCost.setBounds(new Rectangle(341, 154, 270, 19));
        this.add(contknwCost, null);
        contmbAchieve.setBounds(new Rectangle(10, 250, 270, 19));
        this.add(contmbAchieve, null);
        contmbCost.setBounds(new Rectangle(341, 250, 270, 19));
        this.add(contmbCost, null);
        contxfAchieve.setBounds(new Rectangle(10, 178, 270, 19));
        this.add(contxfAchieve, null);
        contxfCost.setBounds(new Rectangle(341, 178, 270, 19));
        this.add(contxfCost, null);
        conteyAchieve.setBounds(new Rectangle(10, 202, 270, 19));
        this.add(conteyAchieve, null);
        conteyCost.setBounds(new Rectangle(341, 202, 270, 19));
        this.add(conteyCost, null);
        contsumAchieve.setBounds(new Rectangle(672, 274, 270, 19));
        this.add(contsumAchieve, null);
        contzzMoney.setBounds(new Rectangle(672, 82, 270, 19));
        this.add(contzzMoney, null);
        contgdjzMoney.setBounds(new Rectangle(672, 130, 270, 19));
        this.add(contgdjzMoney, null);
        contyxjzMoney.setBounds(new Rectangle(672, 106, 270, 19));
        this.add(contyxjzMoney, null);
        contknwMoney.setBounds(new Rectangle(672, 154, 270, 19));
        this.add(contknwMoney, null);
        contyzMoney.setBounds(new Rectangle(672, 226, 270, 19));
        this.add(contyzMoney, null);
        contmbMoney.setBounds(new Rectangle(672, 250, 270, 19));
        this.add(contmbMoney, null);
        contxfMoney.setBounds(new Rectangle(672, 178, 270, 19));
        this.add(contxfMoney, null);
        conteyMoney.setBounds(new Rectangle(672, 202, 270, 19));
        this.add(conteyMoney, null);
        contotherMoney.setBounds(new Rectangle(10, 274, 270, 19));
        this.add(contotherMoney, null);
        contzzBase.setBounds(new Rectangle(10, 298, 270, 19));
        this.add(contzzBase, null);
        contclinicAchieve.setBounds(new Rectangle(341, 274, 270, 19));
        this.add(contclinicAchieve, null);
        contyxjzBase.setBounds(new Rectangle(341, 298, 270, 19));
        this.add(contyxjzBase, null);
        contgdjzBase.setBounds(new Rectangle(672, 298, 270, 19));
        this.add(contgdjzBase, null);
        contknwBase.setBounds(new Rectangle(10, 322, 270, 19));
        this.add(contknwBase, null);
        contxfBase.setBounds(new Rectangle(341, 322, 270, 19));
        this.add(contxfBase, null);
        conteyBase.setBounds(new Rectangle(672, 322, 270, 19));
        this.add(conteyBase, null);
        contyzBase.setBounds(new Rectangle(10, 346, 270, 19));
        this.add(contyzBase, null);
        contmbBase.setBounds(new Rectangle(341, 346, 270, 19));
        this.add(contmbBase, null);
        contclinicBase.setBounds(new Rectangle(672, 346, 270, 19));
        this.add(contclinicBase, null);
        contsumMoney.setBounds(new Rectangle(10, 370, 270, 19));
        this.add(contsumMoney, null);
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
        //contjyCount
        contjyCount.setBoundEditor(txtjyCount);
        //contplaCount
        contplaCount.setBoundEditor(txtplaCount);
        //contzzAchieve
        contzzAchieve.setBoundEditor(txtzzAchieve);
        //contzzCost
        contzzCost.setBoundEditor(txtzzCost);
        //contgdjzAchieve
        contgdjzAchieve.setBoundEditor(txtgdjzAchieve);
        //contgdjzCost
        contgdjzCost.setBoundEditor(txtgdjzCost);
        //contyxjzAchieve
        contyxjzAchieve.setBoundEditor(txtyxjzAchieve);
        //contyxjzCost
        contyxjzCost.setBoundEditor(txtyxjzCost);
        //contzyAchieve
        contzyAchieve.setBoundEditor(txtzyAchieve);
        //contyzCost
        contyzCost.setBoundEditor(txtyzCost);
        //contknwAchieve
        contknwAchieve.setBoundEditor(txtknwAchieve);
        //contknwCost
        contknwCost.setBoundEditor(txtknwCost);
        //contmbAchieve
        contmbAchieve.setBoundEditor(txtmbAchieve);
        //contmbCost
        contmbCost.setBoundEditor(txtmbCost);
        //contxfAchieve
        contxfAchieve.setBoundEditor(txtxfAchieve);
        //contxfCost
        contxfCost.setBoundEditor(txtxfCost);
        //conteyAchieve
        conteyAchieve.setBoundEditor(txteyAchieve);
        //conteyCost
        conteyCost.setBoundEditor(txteyCost);
        //contsumAchieve
        contsumAchieve.setBoundEditor(txtsumAchieve);
        //contzzMoney
        contzzMoney.setBoundEditor(txtzzMoney);
        //contgdjzMoney
        contgdjzMoney.setBoundEditor(txtgdjzMoney);
        //contyxjzMoney
        contyxjzMoney.setBoundEditor(txtyxjzMoney);
        //contknwMoney
        contknwMoney.setBoundEditor(txtknwMoney);
        //contyzMoney
        contyzMoney.setBoundEditor(txtyzMoney);
        //contmbMoney
        contmbMoney.setBoundEditor(txtmbMoney);
        //contxfMoney
        contxfMoney.setBoundEditor(txtxfMoney);
        //conteyMoney
        conteyMoney.setBoundEditor(txteyMoney);
        //contotherMoney
        contotherMoney.setBoundEditor(txtotherMoney);
        //contzzBase
        contzzBase.setBoundEditor(txtzzBase);
        //contclinicAchieve
        contclinicAchieve.setBoundEditor(txtclinicAchieve);
        //contyxjzBase
        contyxjzBase.setBoundEditor(txtyxjzBase);
        //contgdjzBase
        contgdjzBase.setBoundEditor(txtgdjzBase);
        //contknwBase
        contknwBase.setBoundEditor(txtknwBase);
        //contxfBase
        contxfBase.setBoundEditor(txtxfBase);
        //conteyBase
        conteyBase.setBoundEditor(txteyBase);
        //contyzBase
        contyzBase.setBoundEditor(txtyzBase);
        //contmbBase
        contmbBase.setBoundEditor(txtmbBase);
        //contclinicBase
        contclinicBase.setBoundEditor(txtclinicBase);
        //contsumMoney
        contsumMoney.setBoundEditor(txtsumMoney);

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
		dataBinder.registerBinding("clinicName", String.class, this.txtclinicName, "text");
		dataBinder.registerBinding("jyCount", java.math.BigDecimal.class, this.txtjyCount, "value");
		dataBinder.registerBinding("plaCount", java.math.BigDecimal.class, this.txtplaCount, "value");
		dataBinder.registerBinding("zzAchieve", java.math.BigDecimal.class, this.txtzzAchieve, "value");
		dataBinder.registerBinding("zzCost", java.math.BigDecimal.class, this.txtzzCost, "value");
		dataBinder.registerBinding("gdjzAchieve", java.math.BigDecimal.class, this.txtgdjzAchieve, "value");
		dataBinder.registerBinding("gdjzCost", java.math.BigDecimal.class, this.txtgdjzCost, "value");
		dataBinder.registerBinding("yxjzAchieve", java.math.BigDecimal.class, this.txtyxjzAchieve, "value");
		dataBinder.registerBinding("yxjzCost", java.math.BigDecimal.class, this.txtyxjzCost, "value");
		dataBinder.registerBinding("zyAchieve", java.math.BigDecimal.class, this.txtzyAchieve, "value");
		dataBinder.registerBinding("yzCost", java.math.BigDecimal.class, this.txtyzCost, "value");
		dataBinder.registerBinding("knwAchieve", java.math.BigDecimal.class, this.txtknwAchieve, "value");
		dataBinder.registerBinding("knwCost", java.math.BigDecimal.class, this.txtknwCost, "value");
		dataBinder.registerBinding("mbAchieve", java.math.BigDecimal.class, this.txtmbAchieve, "value");
		dataBinder.registerBinding("mbCost", java.math.BigDecimal.class, this.txtmbCost, "value");
		dataBinder.registerBinding("xfAchieve", java.math.BigDecimal.class, this.txtxfAchieve, "value");
		dataBinder.registerBinding("xfCost", java.math.BigDecimal.class, this.txtxfCost, "value");
		dataBinder.registerBinding("eyAchieve", java.math.BigDecimal.class, this.txteyAchieve, "value");
		dataBinder.registerBinding("eyCost", java.math.BigDecimal.class, this.txteyCost, "value");
		dataBinder.registerBinding("sumAchieve", java.math.BigDecimal.class, this.txtsumAchieve, "value");
		dataBinder.registerBinding("zzMoney", java.math.BigDecimal.class, this.txtzzMoney, "value");
		dataBinder.registerBinding("gdjzMoney", java.math.BigDecimal.class, this.txtgdjzMoney, "value");
		dataBinder.registerBinding("yxjzMoney", java.math.BigDecimal.class, this.txtyxjzMoney, "value");
		dataBinder.registerBinding("knwMoney", java.math.BigDecimal.class, this.txtknwMoney, "value");
		dataBinder.registerBinding("yzMoney", java.math.BigDecimal.class, this.txtyzMoney, "value");
		dataBinder.registerBinding("mbMoney", java.math.BigDecimal.class, this.txtmbMoney, "value");
		dataBinder.registerBinding("xfMoney", java.math.BigDecimal.class, this.txtxfMoney, "value");
		dataBinder.registerBinding("eyMoney", java.math.BigDecimal.class, this.txteyMoney, "value");
		dataBinder.registerBinding("otherMoney", java.math.BigDecimal.class, this.txtotherMoney, "value");
		dataBinder.registerBinding("zzBase", java.math.BigDecimal.class, this.txtzzBase, "value");
		dataBinder.registerBinding("clinicAchieve", java.math.BigDecimal.class, this.txtclinicAchieve, "value");
		dataBinder.registerBinding("yxjzBase", java.math.BigDecimal.class, this.txtyxjzBase, "value");
		dataBinder.registerBinding("gdjzBase", java.math.BigDecimal.class, this.txtgdjzBase, "value");
		dataBinder.registerBinding("knwBase", java.math.BigDecimal.class, this.txtknwBase, "value");
		dataBinder.registerBinding("xfBase", java.math.BigDecimal.class, this.txtxfBase, "value");
		dataBinder.registerBinding("eyBase", java.math.BigDecimal.class, this.txteyBase, "value");
		dataBinder.registerBinding("yzBase", java.math.BigDecimal.class, this.txtyzBase, "value");
		dataBinder.registerBinding("mbBase", java.math.BigDecimal.class, this.txtmbBase, "value");
		dataBinder.registerBinding("clinicBase", java.math.BigDecimal.class, this.txtclinicBase, "value");
		dataBinder.registerBinding("sumMoney", java.math.BigDecimal.class, this.txtsumMoney, "value");		
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
	    return "com.kingdee.eas.mw.pay.app.DocDetailBonusEditUIHandler";
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
        this.txtgdjzMoney.requestFocusInWindow();
    }

	
	

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject)
    {
        IObjectValue ov = dataObject;        	    	
        super.setDataObject(ov);
        this.editData = (com.kingdee.eas.mw.pay.DocDetailBonusInfo)ov;
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
		getValidateHelper().registerBindProperty("empNumber", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("empName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("clinicNumber", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("cityNumber", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("cityName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("clinicName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("jyCount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("plaCount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("zzAchieve", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("zzCost", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("gdjzAchieve", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("gdjzCost", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("yxjzAchieve", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("yxjzCost", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("zyAchieve", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("yzCost", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("knwAchieve", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("knwCost", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("mbAchieve", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("mbCost", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("xfAchieve", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("xfCost", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("eyAchieve", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("eyCost", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("sumAchieve", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("zzMoney", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("gdjzMoney", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("yxjzMoney", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("knwMoney", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("yzMoney", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("mbMoney", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("xfMoney", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("eyMoney", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("otherMoney", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("zzBase", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("clinicAchieve", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("yxjzBase", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("gdjzBase", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("knwBase", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("xfBase", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("eyBase", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("yzBase", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("mbBase", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("clinicBase", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("sumMoney", ValidateHelper.ON_SAVE);    		
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
        sic.add(new SelectorItemInfo("clinicName"));
        sic.add(new SelectorItemInfo("jyCount"));
        sic.add(new SelectorItemInfo("plaCount"));
        sic.add(new SelectorItemInfo("zzAchieve"));
        sic.add(new SelectorItemInfo("zzCost"));
        sic.add(new SelectorItemInfo("gdjzAchieve"));
        sic.add(new SelectorItemInfo("gdjzCost"));
        sic.add(new SelectorItemInfo("yxjzAchieve"));
        sic.add(new SelectorItemInfo("yxjzCost"));
        sic.add(new SelectorItemInfo("zyAchieve"));
        sic.add(new SelectorItemInfo("yzCost"));
        sic.add(new SelectorItemInfo("knwAchieve"));
        sic.add(new SelectorItemInfo("knwCost"));
        sic.add(new SelectorItemInfo("mbAchieve"));
        sic.add(new SelectorItemInfo("mbCost"));
        sic.add(new SelectorItemInfo("xfAchieve"));
        sic.add(new SelectorItemInfo("xfCost"));
        sic.add(new SelectorItemInfo("eyAchieve"));
        sic.add(new SelectorItemInfo("eyCost"));
        sic.add(new SelectorItemInfo("sumAchieve"));
        sic.add(new SelectorItemInfo("zzMoney"));
        sic.add(new SelectorItemInfo("gdjzMoney"));
        sic.add(new SelectorItemInfo("yxjzMoney"));
        sic.add(new SelectorItemInfo("knwMoney"));
        sic.add(new SelectorItemInfo("yzMoney"));
        sic.add(new SelectorItemInfo("mbMoney"));
        sic.add(new SelectorItemInfo("xfMoney"));
        sic.add(new SelectorItemInfo("eyMoney"));
        sic.add(new SelectorItemInfo("otherMoney"));
        sic.add(new SelectorItemInfo("zzBase"));
        sic.add(new SelectorItemInfo("clinicAchieve"));
        sic.add(new SelectorItemInfo("yxjzBase"));
        sic.add(new SelectorItemInfo("gdjzBase"));
        sic.add(new SelectorItemInfo("knwBase"));
        sic.add(new SelectorItemInfo("xfBase"));
        sic.add(new SelectorItemInfo("eyBase"));
        sic.add(new SelectorItemInfo("yzBase"));
        sic.add(new SelectorItemInfo("mbBase"));
        sic.add(new SelectorItemInfo("clinicBase"));
        sic.add(new SelectorItemInfo("sumMoney"));
        return sic;
    }        

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.mw.pay.client", "DocDetailBonusEditUI");
    }

    /**
     * output getEditUIName method
     */
    protected String getEditUIName()
    {
        return com.kingdee.eas.mw.pay.client.DocDetailBonusEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.mw.pay.DocDetailBonusFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.mw.pay.DocDetailBonusInfo objectValue = new com.kingdee.eas.mw.pay.DocDetailBonusInfo();
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