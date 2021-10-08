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
public abstract class AbstractClinicAchieveCosthSumEditUI extends com.kingdee.eas.framework.client.EditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractClinicAchieveCosthSumEditUI.class);
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
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contwhiteAchieve;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contzxAchieve;
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
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contpostType;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkiszidai;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contimplacount;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contimjycount;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contimwhiteAchieve;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contimzxAchieve;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contimzzAchieve;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contimyxjzAchieve;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contimgdjzAchieve;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contimyzAchieve;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contimxfAchieve;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contimknwAchieve;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contimeyAchieve;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contimmbAchieve;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contxtjyCount;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contxtplaCount;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contxtzxAchieve;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contxtzzAchieve;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contxtyxjzAchieve;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contxtgdjzAchieve;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contxtknwAchieve;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contxtxfAchieve;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contxteyAchieve;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contxtyzAchieve;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contxtwhiteAchieve;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contpostname;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfreeyxjzAchieve;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfreezzAchieve;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfreegdjzAchieve;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfreeyzAchieve;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfreeknwAchieve;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfreexfAchieve;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfreeeyAchieve;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfreembAchieve;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contallKeAchieve;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contxtmbAchieve;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contImAllKeAchieve;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contXtAllKeAchieve;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contzzbase;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contgdbase;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contyxbase;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contknwbase;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contxfbase;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contyzbase;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conteybase;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contmbbase;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contallbase;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcosydzCount;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contxtcosydzCount;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contimcosydzCount;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcosyfdzCount;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contxtcosyfdzCount;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contimcosyfdzCount;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contzzpro;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contgdpro;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contyxpro;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contknwpro;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contxfpro;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contyzpro;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conteypro;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contmbpro;
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
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtwhiteAchieve;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtzxAchieve;
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
    protected com.kingdee.bos.ctrl.swing.KDComboBox postType;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtimplacount;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtimjycount;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtimwhiteAchieve;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtimzxAchieve;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtimzzAchieve;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtimyxjzAchieve;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtimgdjzAchieve;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtimyzAchieve;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtimxfAchieve;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtimknwAchieve;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtimeyAchieve;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtimmbAchieve;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtxtjyCount;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtxtplaCount;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtxtzxAchieve;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtxtzzAchieve;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtxtyxjzAchieve;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtxtgdjzAchieve;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtxtknwAchieve;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtxtxfAchieve;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtxteyAchieve;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtxtyzAchieve;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtxtwhiteAchieve;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtpostname;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtfreeyxjzAchieve;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtfreezzAchieve;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtfreegdjzAchieve;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtfreeyzAchieve;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtfreeknwAchieve;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtfreexfAchieve;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtfreeeyAchieve;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtfreembAchieve;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtallKeAchieve;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtxtmbAchieve;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtImAllKeAchieve;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtXtAllKeAchieve;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtzzbase;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtgdbase;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtyxbase;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtknwbase;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtxfbase;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtyzbase;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txteybase;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtmbbase;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtallbase;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtcosydzCount;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtxtcosydzCount;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtimcosydzCount;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtcosyfdzCount;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtxtcosyfdzCount;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtimcosyfdzCount;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtzzpro;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtgdpro;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtyxpro;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtknwpro;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtxfpro;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtyzpro;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txteypro;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtmbpro;
    protected com.kingdee.eas.mw.pay.ClinicAchieveCosthSumInfo editData = null;
    /**
     * output class constructor
     */
    public AbstractClinicAchieveCosthSumEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractClinicAchieveCosthSumEditUI.class.getName());
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
        this.contwhiteAchieve = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contzxAchieve = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
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
        this.contpostType = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.chkiszidai = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.contimplacount = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contimjycount = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contimwhiteAchieve = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contimzxAchieve = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contimzzAchieve = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contimyxjzAchieve = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contimgdjzAchieve = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contimyzAchieve = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contimxfAchieve = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contimknwAchieve = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contimeyAchieve = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contimmbAchieve = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contxtjyCount = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contxtplaCount = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contxtzxAchieve = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contxtzzAchieve = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contxtyxjzAchieve = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contxtgdjzAchieve = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contxtknwAchieve = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contxtxfAchieve = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contxteyAchieve = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contxtyzAchieve = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contxtwhiteAchieve = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contpostname = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfreeyxjzAchieve = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfreezzAchieve = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfreegdjzAchieve = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfreeyzAchieve = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfreeknwAchieve = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfreexfAchieve = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfreeeyAchieve = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfreembAchieve = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contallKeAchieve = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contxtmbAchieve = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contImAllKeAchieve = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contXtAllKeAchieve = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contzzbase = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contgdbase = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contyxbase = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contknwbase = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contxfbase = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contyzbase = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conteybase = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contmbbase = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contallbase = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcosydzCount = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contxtcosydzCount = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contimcosydzCount = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcosyfdzCount = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contxtcosyfdzCount = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contimcosyfdzCount = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contzzpro = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contgdpro = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contyxpro = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contknwpro = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contxfpro = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contyzpro = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conteypro = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contmbpro = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
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
        this.txtwhiteAchieve = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtzxAchieve = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
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
        this.postType = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.txtimplacount = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtimjycount = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtimwhiteAchieve = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtimzxAchieve = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtimzzAchieve = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtimyxjzAchieve = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtimgdjzAchieve = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtimyzAchieve = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtimxfAchieve = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtimknwAchieve = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtimeyAchieve = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtimmbAchieve = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtxtjyCount = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtxtplaCount = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtxtzxAchieve = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtxtzzAchieve = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtxtyxjzAchieve = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtxtgdjzAchieve = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtxtknwAchieve = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtxtxfAchieve = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtxteyAchieve = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtxtyzAchieve = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtxtwhiteAchieve = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtpostname = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtfreeyxjzAchieve = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtfreezzAchieve = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtfreegdjzAchieve = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtfreeyzAchieve = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtfreeknwAchieve = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtfreexfAchieve = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtfreeeyAchieve = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtfreembAchieve = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtallKeAchieve = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtxtmbAchieve = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtImAllKeAchieve = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtXtAllKeAchieve = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtzzbase = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtgdbase = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtyxbase = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtknwbase = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtxfbase = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtyzbase = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txteybase = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtmbbase = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtallbase = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtcosydzCount = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtxtcosydzCount = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtimcosydzCount = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtcosyfdzCount = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtxtcosyfdzCount = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtimcosyfdzCount = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtzzpro = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtgdpro = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtyxpro = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtknwpro = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtxfpro = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtyzpro = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txteypro = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtmbpro = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
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
        this.contwhiteAchieve.setName("contwhiteAchieve");
        this.contzxAchieve.setName("contzxAchieve");
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
        this.contpostType.setName("contpostType");
        this.chkiszidai.setName("chkiszidai");
        this.contimplacount.setName("contimplacount");
        this.contimjycount.setName("contimjycount");
        this.contimwhiteAchieve.setName("contimwhiteAchieve");
        this.contimzxAchieve.setName("contimzxAchieve");
        this.contimzzAchieve.setName("contimzzAchieve");
        this.contimyxjzAchieve.setName("contimyxjzAchieve");
        this.contimgdjzAchieve.setName("contimgdjzAchieve");
        this.contimyzAchieve.setName("contimyzAchieve");
        this.contimxfAchieve.setName("contimxfAchieve");
        this.contimknwAchieve.setName("contimknwAchieve");
        this.contimeyAchieve.setName("contimeyAchieve");
        this.contimmbAchieve.setName("contimmbAchieve");
        this.contxtjyCount.setName("contxtjyCount");
        this.contxtplaCount.setName("contxtplaCount");
        this.contxtzxAchieve.setName("contxtzxAchieve");
        this.contxtzzAchieve.setName("contxtzzAchieve");
        this.contxtyxjzAchieve.setName("contxtyxjzAchieve");
        this.contxtgdjzAchieve.setName("contxtgdjzAchieve");
        this.contxtknwAchieve.setName("contxtknwAchieve");
        this.contxtxfAchieve.setName("contxtxfAchieve");
        this.contxteyAchieve.setName("contxteyAchieve");
        this.contxtyzAchieve.setName("contxtyzAchieve");
        this.contxtwhiteAchieve.setName("contxtwhiteAchieve");
        this.contpostname.setName("contpostname");
        this.contfreeyxjzAchieve.setName("contfreeyxjzAchieve");
        this.contfreezzAchieve.setName("contfreezzAchieve");
        this.contfreegdjzAchieve.setName("contfreegdjzAchieve");
        this.contfreeyzAchieve.setName("contfreeyzAchieve");
        this.contfreeknwAchieve.setName("contfreeknwAchieve");
        this.contfreexfAchieve.setName("contfreexfAchieve");
        this.contfreeeyAchieve.setName("contfreeeyAchieve");
        this.contfreembAchieve.setName("contfreembAchieve");
        this.contallKeAchieve.setName("contallKeAchieve");
        this.contxtmbAchieve.setName("contxtmbAchieve");
        this.contImAllKeAchieve.setName("contImAllKeAchieve");
        this.contXtAllKeAchieve.setName("contXtAllKeAchieve");
        this.contzzbase.setName("contzzbase");
        this.contgdbase.setName("contgdbase");
        this.contyxbase.setName("contyxbase");
        this.contknwbase.setName("contknwbase");
        this.contxfbase.setName("contxfbase");
        this.contyzbase.setName("contyzbase");
        this.conteybase.setName("conteybase");
        this.contmbbase.setName("contmbbase");
        this.contallbase.setName("contallbase");
        this.contcosydzCount.setName("contcosydzCount");
        this.contxtcosydzCount.setName("contxtcosydzCount");
        this.contimcosydzCount.setName("contimcosydzCount");
        this.contcosyfdzCount.setName("contcosyfdzCount");
        this.contxtcosyfdzCount.setName("contxtcosyfdzCount");
        this.contimcosyfdzCount.setName("contimcosyfdzCount");
        this.contzzpro.setName("contzzpro");
        this.contgdpro.setName("contgdpro");
        this.contyxpro.setName("contyxpro");
        this.contknwpro.setName("contknwpro");
        this.contxfpro.setName("contxfpro");
        this.contyzpro.setName("contyzpro");
        this.conteypro.setName("conteypro");
        this.contmbpro.setName("contmbpro");
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
        this.txtwhiteAchieve.setName("txtwhiteAchieve");
        this.txtzxAchieve.setName("txtzxAchieve");
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
        this.postType.setName("postType");
        this.txtimplacount.setName("txtimplacount");
        this.txtimjycount.setName("txtimjycount");
        this.txtimwhiteAchieve.setName("txtimwhiteAchieve");
        this.txtimzxAchieve.setName("txtimzxAchieve");
        this.txtimzzAchieve.setName("txtimzzAchieve");
        this.txtimyxjzAchieve.setName("txtimyxjzAchieve");
        this.txtimgdjzAchieve.setName("txtimgdjzAchieve");
        this.txtimyzAchieve.setName("txtimyzAchieve");
        this.txtimxfAchieve.setName("txtimxfAchieve");
        this.txtimknwAchieve.setName("txtimknwAchieve");
        this.txtimeyAchieve.setName("txtimeyAchieve");
        this.txtimmbAchieve.setName("txtimmbAchieve");
        this.txtxtjyCount.setName("txtxtjyCount");
        this.txtxtplaCount.setName("txtxtplaCount");
        this.txtxtzxAchieve.setName("txtxtzxAchieve");
        this.txtxtzzAchieve.setName("txtxtzzAchieve");
        this.txtxtyxjzAchieve.setName("txtxtyxjzAchieve");
        this.txtxtgdjzAchieve.setName("txtxtgdjzAchieve");
        this.txtxtknwAchieve.setName("txtxtknwAchieve");
        this.txtxtxfAchieve.setName("txtxtxfAchieve");
        this.txtxteyAchieve.setName("txtxteyAchieve");
        this.txtxtyzAchieve.setName("txtxtyzAchieve");
        this.txtxtwhiteAchieve.setName("txtxtwhiteAchieve");
        this.txtpostname.setName("txtpostname");
        this.txtfreeyxjzAchieve.setName("txtfreeyxjzAchieve");
        this.txtfreezzAchieve.setName("txtfreezzAchieve");
        this.txtfreegdjzAchieve.setName("txtfreegdjzAchieve");
        this.txtfreeyzAchieve.setName("txtfreeyzAchieve");
        this.txtfreeknwAchieve.setName("txtfreeknwAchieve");
        this.txtfreexfAchieve.setName("txtfreexfAchieve");
        this.txtfreeeyAchieve.setName("txtfreeeyAchieve");
        this.txtfreembAchieve.setName("txtfreembAchieve");
        this.txtallKeAchieve.setName("txtallKeAchieve");
        this.txtxtmbAchieve.setName("txtxtmbAchieve");
        this.txtImAllKeAchieve.setName("txtImAllKeAchieve");
        this.txtXtAllKeAchieve.setName("txtXtAllKeAchieve");
        this.txtzzbase.setName("txtzzbase");
        this.txtgdbase.setName("txtgdbase");
        this.txtyxbase.setName("txtyxbase");
        this.txtknwbase.setName("txtknwbase");
        this.txtxfbase.setName("txtxfbase");
        this.txtyzbase.setName("txtyzbase");
        this.txteybase.setName("txteybase");
        this.txtmbbase.setName("txtmbbase");
        this.txtallbase.setName("txtallbase");
        this.txtcosydzCount.setName("txtcosydzCount");
        this.txtxtcosydzCount.setName("txtxtcosydzCount");
        this.txtimcosydzCount.setName("txtimcosydzCount");
        this.txtcosyfdzCount.setName("txtcosyfdzCount");
        this.txtxtcosyfdzCount.setName("txtxtcosyfdzCount");
        this.txtimcosyfdzCount.setName("txtimcosyfdzCount");
        this.txtzzpro.setName("txtzzpro");
        this.txtgdpro.setName("txtgdpro");
        this.txtyxpro.setName("txtyxpro");
        this.txtknwpro.setName("txtknwpro");
        this.txtxfpro.setName("txtxfpro");
        this.txtyzpro.setName("txtyzpro");
        this.txteypro.setName("txteypro");
        this.txtmbpro.setName("txtmbpro");
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
        // contwhiteAchieve		
        this.contwhiteAchieve.setBoundLabelText(resHelper.getString("contwhiteAchieve.boundLabelText"));		
        this.contwhiteAchieve.setBoundLabelLength(100);		
        this.contwhiteAchieve.setBoundLabelUnderline(true);		
        this.contwhiteAchieve.setVisible(true);
        // contzxAchieve		
        this.contzxAchieve.setBoundLabelText(resHelper.getString("contzxAchieve.boundLabelText"));		
        this.contzxAchieve.setBoundLabelLength(100);		
        this.contzxAchieve.setBoundLabelUnderline(true);		
        this.contzxAchieve.setVisible(true);
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
        // contpostType		
        this.contpostType.setBoundLabelText(resHelper.getString("contpostType.boundLabelText"));		
        this.contpostType.setBoundLabelLength(100);		
        this.contpostType.setBoundLabelUnderline(true);		
        this.contpostType.setVisible(true);
        // chkiszidai		
        this.chkiszidai.setText(resHelper.getString("chkiszidai.text"));		
        this.chkiszidai.setVisible(true);		
        this.chkiszidai.setHorizontalAlignment(2);
        // contimplacount		
        this.contimplacount.setBoundLabelText(resHelper.getString("contimplacount.boundLabelText"));		
        this.contimplacount.setBoundLabelLength(100);		
        this.contimplacount.setBoundLabelUnderline(true);		
        this.contimplacount.setVisible(true);
        // contimjycount		
        this.contimjycount.setBoundLabelText(resHelper.getString("contimjycount.boundLabelText"));		
        this.contimjycount.setBoundLabelLength(100);		
        this.contimjycount.setBoundLabelUnderline(true);		
        this.contimjycount.setVisible(true);
        // contimwhiteAchieve		
        this.contimwhiteAchieve.setBoundLabelText(resHelper.getString("contimwhiteAchieve.boundLabelText"));		
        this.contimwhiteAchieve.setBoundLabelLength(100);		
        this.contimwhiteAchieve.setBoundLabelUnderline(true);		
        this.contimwhiteAchieve.setVisible(true);
        // contimzxAchieve		
        this.contimzxAchieve.setBoundLabelText(resHelper.getString("contimzxAchieve.boundLabelText"));		
        this.contimzxAchieve.setBoundLabelLength(100);		
        this.contimzxAchieve.setBoundLabelUnderline(true);		
        this.contimzxAchieve.setVisible(true);
        // contimzzAchieve		
        this.contimzzAchieve.setBoundLabelText(resHelper.getString("contimzzAchieve.boundLabelText"));		
        this.contimzzAchieve.setBoundLabelLength(100);		
        this.contimzzAchieve.setBoundLabelUnderline(true);		
        this.contimzzAchieve.setVisible(true);
        // contimyxjzAchieve		
        this.contimyxjzAchieve.setBoundLabelText(resHelper.getString("contimyxjzAchieve.boundLabelText"));		
        this.contimyxjzAchieve.setBoundLabelLength(100);		
        this.contimyxjzAchieve.setBoundLabelUnderline(true);		
        this.contimyxjzAchieve.setVisible(true);
        // contimgdjzAchieve		
        this.contimgdjzAchieve.setBoundLabelText(resHelper.getString("contimgdjzAchieve.boundLabelText"));		
        this.contimgdjzAchieve.setBoundLabelLength(100);		
        this.contimgdjzAchieve.setBoundLabelUnderline(true);		
        this.contimgdjzAchieve.setVisible(true);
        // contimyzAchieve		
        this.contimyzAchieve.setBoundLabelText(resHelper.getString("contimyzAchieve.boundLabelText"));		
        this.contimyzAchieve.setBoundLabelLength(100);		
        this.contimyzAchieve.setBoundLabelUnderline(true);		
        this.contimyzAchieve.setVisible(true);
        // contimxfAchieve		
        this.contimxfAchieve.setBoundLabelText(resHelper.getString("contimxfAchieve.boundLabelText"));		
        this.contimxfAchieve.setBoundLabelLength(100);		
        this.contimxfAchieve.setBoundLabelUnderline(true);		
        this.contimxfAchieve.setVisible(true);
        // contimknwAchieve		
        this.contimknwAchieve.setBoundLabelText(resHelper.getString("contimknwAchieve.boundLabelText"));		
        this.contimknwAchieve.setBoundLabelLength(100);		
        this.contimknwAchieve.setBoundLabelUnderline(true);		
        this.contimknwAchieve.setVisible(true);
        // contimeyAchieve		
        this.contimeyAchieve.setBoundLabelText(resHelper.getString("contimeyAchieve.boundLabelText"));		
        this.contimeyAchieve.setBoundLabelLength(100);		
        this.contimeyAchieve.setBoundLabelUnderline(true);		
        this.contimeyAchieve.setVisible(true);
        // contimmbAchieve		
        this.contimmbAchieve.setBoundLabelText(resHelper.getString("contimmbAchieve.boundLabelText"));		
        this.contimmbAchieve.setBoundLabelLength(100);		
        this.contimmbAchieve.setBoundLabelUnderline(true);		
        this.contimmbAchieve.setVisible(true);
        // contxtjyCount		
        this.contxtjyCount.setBoundLabelText(resHelper.getString("contxtjyCount.boundLabelText"));		
        this.contxtjyCount.setBoundLabelLength(100);		
        this.contxtjyCount.setBoundLabelUnderline(true);		
        this.contxtjyCount.setVisible(true);
        // contxtplaCount		
        this.contxtplaCount.setBoundLabelText(resHelper.getString("contxtplaCount.boundLabelText"));		
        this.contxtplaCount.setBoundLabelLength(100);		
        this.contxtplaCount.setBoundLabelUnderline(true);		
        this.contxtplaCount.setVisible(true);
        // contxtzxAchieve		
        this.contxtzxAchieve.setBoundLabelText(resHelper.getString("contxtzxAchieve.boundLabelText"));		
        this.contxtzxAchieve.setBoundLabelLength(100);		
        this.contxtzxAchieve.setBoundLabelUnderline(true);		
        this.contxtzxAchieve.setVisible(true);
        // contxtzzAchieve		
        this.contxtzzAchieve.setBoundLabelText(resHelper.getString("contxtzzAchieve.boundLabelText"));		
        this.contxtzzAchieve.setBoundLabelLength(100);		
        this.contxtzzAchieve.setBoundLabelUnderline(true);		
        this.contxtzzAchieve.setVisible(true);
        // contxtyxjzAchieve		
        this.contxtyxjzAchieve.setBoundLabelText(resHelper.getString("contxtyxjzAchieve.boundLabelText"));		
        this.contxtyxjzAchieve.setBoundLabelLength(100);		
        this.contxtyxjzAchieve.setBoundLabelUnderline(true);		
        this.contxtyxjzAchieve.setVisible(true);
        // contxtgdjzAchieve		
        this.contxtgdjzAchieve.setBoundLabelText(resHelper.getString("contxtgdjzAchieve.boundLabelText"));		
        this.contxtgdjzAchieve.setBoundLabelLength(100);		
        this.contxtgdjzAchieve.setBoundLabelUnderline(true);		
        this.contxtgdjzAchieve.setVisible(true);
        // contxtknwAchieve		
        this.contxtknwAchieve.setBoundLabelText(resHelper.getString("contxtknwAchieve.boundLabelText"));		
        this.contxtknwAchieve.setBoundLabelLength(100);		
        this.contxtknwAchieve.setBoundLabelUnderline(true);		
        this.contxtknwAchieve.setVisible(true);
        // contxtxfAchieve		
        this.contxtxfAchieve.setBoundLabelText(resHelper.getString("contxtxfAchieve.boundLabelText"));		
        this.contxtxfAchieve.setBoundLabelLength(100);		
        this.contxtxfAchieve.setBoundLabelUnderline(true);		
        this.contxtxfAchieve.setVisible(true);
        // contxteyAchieve		
        this.contxteyAchieve.setBoundLabelText(resHelper.getString("contxteyAchieve.boundLabelText"));		
        this.contxteyAchieve.setBoundLabelLength(100);		
        this.contxteyAchieve.setBoundLabelUnderline(true);		
        this.contxteyAchieve.setVisible(true);
        // contxtyzAchieve		
        this.contxtyzAchieve.setBoundLabelText(resHelper.getString("contxtyzAchieve.boundLabelText"));		
        this.contxtyzAchieve.setBoundLabelLength(100);		
        this.contxtyzAchieve.setBoundLabelUnderline(true);		
        this.contxtyzAchieve.setVisible(true);
        // contxtwhiteAchieve		
        this.contxtwhiteAchieve.setBoundLabelText(resHelper.getString("contxtwhiteAchieve.boundLabelText"));		
        this.contxtwhiteAchieve.setBoundLabelLength(100);		
        this.contxtwhiteAchieve.setBoundLabelUnderline(true);		
        this.contxtwhiteAchieve.setVisible(true);
        // contpostname		
        this.contpostname.setBoundLabelText(resHelper.getString("contpostname.boundLabelText"));		
        this.contpostname.setBoundLabelLength(100);		
        this.contpostname.setBoundLabelUnderline(true);		
        this.contpostname.setVisible(true);
        // contfreeyxjzAchieve		
        this.contfreeyxjzAchieve.setBoundLabelText(resHelper.getString("contfreeyxjzAchieve.boundLabelText"));		
        this.contfreeyxjzAchieve.setBoundLabelLength(100);		
        this.contfreeyxjzAchieve.setBoundLabelUnderline(true);		
        this.contfreeyxjzAchieve.setVisible(true);
        // contfreezzAchieve		
        this.contfreezzAchieve.setBoundLabelText(resHelper.getString("contfreezzAchieve.boundLabelText"));		
        this.contfreezzAchieve.setBoundLabelLength(100);		
        this.contfreezzAchieve.setBoundLabelUnderline(true);		
        this.contfreezzAchieve.setVisible(true);
        // contfreegdjzAchieve		
        this.contfreegdjzAchieve.setBoundLabelText(resHelper.getString("contfreegdjzAchieve.boundLabelText"));		
        this.contfreegdjzAchieve.setBoundLabelLength(100);		
        this.contfreegdjzAchieve.setBoundLabelUnderline(true);		
        this.contfreegdjzAchieve.setVisible(true);
        // contfreeyzAchieve		
        this.contfreeyzAchieve.setBoundLabelText(resHelper.getString("contfreeyzAchieve.boundLabelText"));		
        this.contfreeyzAchieve.setBoundLabelLength(100);		
        this.contfreeyzAchieve.setBoundLabelUnderline(true);		
        this.contfreeyzAchieve.setVisible(true);
        // contfreeknwAchieve		
        this.contfreeknwAchieve.setBoundLabelText(resHelper.getString("contfreeknwAchieve.boundLabelText"));		
        this.contfreeknwAchieve.setBoundLabelLength(100);		
        this.contfreeknwAchieve.setBoundLabelUnderline(true);		
        this.contfreeknwAchieve.setVisible(true);
        // contfreexfAchieve		
        this.contfreexfAchieve.setBoundLabelText(resHelper.getString("contfreexfAchieve.boundLabelText"));		
        this.contfreexfAchieve.setBoundLabelLength(100);		
        this.contfreexfAchieve.setBoundLabelUnderline(true);		
        this.contfreexfAchieve.setVisible(true);
        // contfreeeyAchieve		
        this.contfreeeyAchieve.setBoundLabelText(resHelper.getString("contfreeeyAchieve.boundLabelText"));		
        this.contfreeeyAchieve.setBoundLabelLength(100);		
        this.contfreeeyAchieve.setBoundLabelUnderline(true);		
        this.contfreeeyAchieve.setVisible(true);
        // contfreembAchieve		
        this.contfreembAchieve.setBoundLabelText(resHelper.getString("contfreembAchieve.boundLabelText"));		
        this.contfreembAchieve.setBoundLabelLength(100);		
        this.contfreembAchieve.setBoundLabelUnderline(true);		
        this.contfreembAchieve.setVisible(true);
        // contallKeAchieve		
        this.contallKeAchieve.setBoundLabelText(resHelper.getString("contallKeAchieve.boundLabelText"));		
        this.contallKeAchieve.setBoundLabelLength(100);		
        this.contallKeAchieve.setBoundLabelUnderline(true);		
        this.contallKeAchieve.setVisible(true);
        // contxtmbAchieve		
        this.contxtmbAchieve.setBoundLabelText(resHelper.getString("contxtmbAchieve.boundLabelText"));		
        this.contxtmbAchieve.setBoundLabelLength(100);		
        this.contxtmbAchieve.setBoundLabelUnderline(true);		
        this.contxtmbAchieve.setVisible(true);
        // contImAllKeAchieve		
        this.contImAllKeAchieve.setBoundLabelText(resHelper.getString("contImAllKeAchieve.boundLabelText"));		
        this.contImAllKeAchieve.setBoundLabelLength(100);		
        this.contImAllKeAchieve.setBoundLabelUnderline(true);		
        this.contImAllKeAchieve.setVisible(true);
        // contXtAllKeAchieve		
        this.contXtAllKeAchieve.setBoundLabelText(resHelper.getString("contXtAllKeAchieve.boundLabelText"));		
        this.contXtAllKeAchieve.setBoundLabelLength(100);		
        this.contXtAllKeAchieve.setBoundLabelUnderline(true);		
        this.contXtAllKeAchieve.setVisible(true);
        // contzzbase		
        this.contzzbase.setBoundLabelText(resHelper.getString("contzzbase.boundLabelText"));		
        this.contzzbase.setBoundLabelLength(100);		
        this.contzzbase.setBoundLabelUnderline(true);		
        this.contzzbase.setVisible(true);
        // contgdbase		
        this.contgdbase.setBoundLabelText(resHelper.getString("contgdbase.boundLabelText"));		
        this.contgdbase.setBoundLabelLength(100);		
        this.contgdbase.setBoundLabelUnderline(true);		
        this.contgdbase.setVisible(true);
        // contyxbase		
        this.contyxbase.setBoundLabelText(resHelper.getString("contyxbase.boundLabelText"));		
        this.contyxbase.setBoundLabelLength(100);		
        this.contyxbase.setBoundLabelUnderline(true);		
        this.contyxbase.setVisible(true);
        // contknwbase		
        this.contknwbase.setBoundLabelText(resHelper.getString("contknwbase.boundLabelText"));		
        this.contknwbase.setBoundLabelLength(100);		
        this.contknwbase.setBoundLabelUnderline(true);		
        this.contknwbase.setVisible(true);
        // contxfbase		
        this.contxfbase.setBoundLabelText(resHelper.getString("contxfbase.boundLabelText"));		
        this.contxfbase.setBoundLabelLength(100);		
        this.contxfbase.setBoundLabelUnderline(true);		
        this.contxfbase.setVisible(true);
        // contyzbase		
        this.contyzbase.setBoundLabelText(resHelper.getString("contyzbase.boundLabelText"));		
        this.contyzbase.setBoundLabelLength(100);		
        this.contyzbase.setBoundLabelUnderline(true);		
        this.contyzbase.setVisible(true);
        // conteybase		
        this.conteybase.setBoundLabelText(resHelper.getString("conteybase.boundLabelText"));		
        this.conteybase.setBoundLabelLength(100);		
        this.conteybase.setBoundLabelUnderline(true);		
        this.conteybase.setVisible(true);
        // contmbbase		
        this.contmbbase.setBoundLabelText(resHelper.getString("contmbbase.boundLabelText"));		
        this.contmbbase.setBoundLabelLength(100);		
        this.contmbbase.setBoundLabelUnderline(true);		
        this.contmbbase.setVisible(true);
        // contallbase		
        this.contallbase.setBoundLabelText(resHelper.getString("contallbase.boundLabelText"));		
        this.contallbase.setBoundLabelLength(100);		
        this.contallbase.setBoundLabelUnderline(true);		
        this.contallbase.setVisible(true);
        // contcosydzCount		
        this.contcosydzCount.setBoundLabelText(resHelper.getString("contcosydzCount.boundLabelText"));		
        this.contcosydzCount.setBoundLabelLength(100);		
        this.contcosydzCount.setBoundLabelUnderline(true);		
        this.contcosydzCount.setVisible(true);
        // contxtcosydzCount		
        this.contxtcosydzCount.setBoundLabelText(resHelper.getString("contxtcosydzCount.boundLabelText"));		
        this.contxtcosydzCount.setBoundLabelLength(100);		
        this.contxtcosydzCount.setBoundLabelUnderline(true);		
        this.contxtcosydzCount.setVisible(true);
        // contimcosydzCount		
        this.contimcosydzCount.setBoundLabelText(resHelper.getString("contimcosydzCount.boundLabelText"));		
        this.contimcosydzCount.setBoundLabelLength(100);		
        this.contimcosydzCount.setBoundLabelUnderline(true);		
        this.contimcosydzCount.setVisible(true);
        // contcosyfdzCount		
        this.contcosyfdzCount.setBoundLabelText(resHelper.getString("contcosyfdzCount.boundLabelText"));		
        this.contcosyfdzCount.setBoundLabelLength(100);		
        this.contcosyfdzCount.setBoundLabelUnderline(true);		
        this.contcosyfdzCount.setVisible(true);
        // contxtcosyfdzCount		
        this.contxtcosyfdzCount.setBoundLabelText(resHelper.getString("contxtcosyfdzCount.boundLabelText"));		
        this.contxtcosyfdzCount.setBoundLabelLength(100);		
        this.contxtcosyfdzCount.setBoundLabelUnderline(true);		
        this.contxtcosyfdzCount.setVisible(true);
        // contimcosyfdzCount		
        this.contimcosyfdzCount.setBoundLabelText(resHelper.getString("contimcosyfdzCount.boundLabelText"));		
        this.contimcosyfdzCount.setBoundLabelLength(100);		
        this.contimcosyfdzCount.setBoundLabelUnderline(true);		
        this.contimcosyfdzCount.setVisible(true);
        // contzzpro		
        this.contzzpro.setBoundLabelText(resHelper.getString("contzzpro.boundLabelText"));		
        this.contzzpro.setBoundLabelLength(100);		
        this.contzzpro.setBoundLabelUnderline(true);		
        this.contzzpro.setVisible(true);
        // contgdpro		
        this.contgdpro.setBoundLabelText(resHelper.getString("contgdpro.boundLabelText"));		
        this.contgdpro.setBoundLabelLength(100);		
        this.contgdpro.setBoundLabelUnderline(true);		
        this.contgdpro.setVisible(true);
        // contyxpro		
        this.contyxpro.setBoundLabelText(resHelper.getString("contyxpro.boundLabelText"));		
        this.contyxpro.setBoundLabelLength(100);		
        this.contyxpro.setBoundLabelUnderline(true);		
        this.contyxpro.setVisible(true);
        // contknwpro		
        this.contknwpro.setBoundLabelText(resHelper.getString("contknwpro.boundLabelText"));		
        this.contknwpro.setBoundLabelLength(100);		
        this.contknwpro.setBoundLabelUnderline(true);		
        this.contknwpro.setVisible(true);
        // contxfpro		
        this.contxfpro.setBoundLabelText(resHelper.getString("contxfpro.boundLabelText"));		
        this.contxfpro.setBoundLabelLength(100);		
        this.contxfpro.setBoundLabelUnderline(true);		
        this.contxfpro.setVisible(true);
        // contyzpro		
        this.contyzpro.setBoundLabelText(resHelper.getString("contyzpro.boundLabelText"));		
        this.contyzpro.setBoundLabelLength(100);		
        this.contyzpro.setBoundLabelUnderline(true);		
        this.contyzpro.setVisible(true);
        // conteypro		
        this.conteypro.setBoundLabelText(resHelper.getString("conteypro.boundLabelText"));		
        this.conteypro.setBoundLabelLength(100);		
        this.conteypro.setBoundLabelUnderline(true);		
        this.conteypro.setVisible(true);
        // contmbpro		
        this.contmbpro.setBoundLabelText(resHelper.getString("contmbpro.boundLabelText"));		
        this.contmbpro.setBoundLabelLength(100);		
        this.contmbpro.setBoundLabelUnderline(true);		
        this.contmbpro.setVisible(true);
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
        // txtwhiteAchieve		
        this.txtwhiteAchieve.setHorizontalAlignment(2);		
        this.txtwhiteAchieve.setDataType(1);		
        this.txtwhiteAchieve.setSupportedEmpty(true);		
        this.txtwhiteAchieve.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtwhiteAchieve.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtwhiteAchieve.setPrecision(10);		
        this.txtwhiteAchieve.setRequired(false);
        // txtzxAchieve		
        this.txtzxAchieve.setHorizontalAlignment(2);		
        this.txtzxAchieve.setDataType(1);		
        this.txtzxAchieve.setSupportedEmpty(true);		
        this.txtzxAchieve.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtzxAchieve.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtzxAchieve.setPrecision(10);		
        this.txtzxAchieve.setRequired(false);
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
        // postType		
        this.postType.setVisible(true);		
        this.postType.addItems(EnumUtils.getEnumList("com.kingdee.eas.mw.pay.app.PaypostType").toArray());		
        this.postType.setRequired(false);
        // txtimplacount		
        this.txtimplacount.setVisible(true);		
        this.txtimplacount.setHorizontalAlignment(2);		
        this.txtimplacount.setDataType(1);		
        this.txtimplacount.setSupportedEmpty(true);		
        this.txtimplacount.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtimplacount.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtimplacount.setPrecision(10);		
        this.txtimplacount.setRequired(false);
        // txtimjycount		
        this.txtimjycount.setVisible(true);		
        this.txtimjycount.setHorizontalAlignment(2);		
        this.txtimjycount.setDataType(1);		
        this.txtimjycount.setSupportedEmpty(true);		
        this.txtimjycount.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtimjycount.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtimjycount.setPrecision(10);		
        this.txtimjycount.setRequired(false);
        // txtimwhiteAchieve		
        this.txtimwhiteAchieve.setVisible(true);		
        this.txtimwhiteAchieve.setHorizontalAlignment(2);		
        this.txtimwhiteAchieve.setDataType(1);		
        this.txtimwhiteAchieve.setSupportedEmpty(true);		
        this.txtimwhiteAchieve.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtimwhiteAchieve.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtimwhiteAchieve.setPrecision(10);		
        this.txtimwhiteAchieve.setRequired(false);
        // txtimzxAchieve		
        this.txtimzxAchieve.setVisible(true);		
        this.txtimzxAchieve.setHorizontalAlignment(2);		
        this.txtimzxAchieve.setDataType(1);		
        this.txtimzxAchieve.setSupportedEmpty(true);		
        this.txtimzxAchieve.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtimzxAchieve.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtimzxAchieve.setPrecision(10);		
        this.txtimzxAchieve.setRequired(false);
        // txtimzzAchieve		
        this.txtimzzAchieve.setVisible(true);		
        this.txtimzzAchieve.setHorizontalAlignment(2);		
        this.txtimzzAchieve.setDataType(1);		
        this.txtimzzAchieve.setSupportedEmpty(true);		
        this.txtimzzAchieve.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtimzzAchieve.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtimzzAchieve.setPrecision(10);		
        this.txtimzzAchieve.setRequired(false);
        // txtimyxjzAchieve		
        this.txtimyxjzAchieve.setVisible(true);		
        this.txtimyxjzAchieve.setHorizontalAlignment(2);		
        this.txtimyxjzAchieve.setDataType(1);		
        this.txtimyxjzAchieve.setSupportedEmpty(true);		
        this.txtimyxjzAchieve.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtimyxjzAchieve.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtimyxjzAchieve.setPrecision(10);		
        this.txtimyxjzAchieve.setRequired(false);
        // txtimgdjzAchieve		
        this.txtimgdjzAchieve.setVisible(true);		
        this.txtimgdjzAchieve.setHorizontalAlignment(2);		
        this.txtimgdjzAchieve.setDataType(1);		
        this.txtimgdjzAchieve.setSupportedEmpty(true);		
        this.txtimgdjzAchieve.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtimgdjzAchieve.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtimgdjzAchieve.setPrecision(10);		
        this.txtimgdjzAchieve.setRequired(false);
        // txtimyzAchieve		
        this.txtimyzAchieve.setVisible(true);		
        this.txtimyzAchieve.setHorizontalAlignment(2);		
        this.txtimyzAchieve.setDataType(1);		
        this.txtimyzAchieve.setSupportedEmpty(true);		
        this.txtimyzAchieve.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtimyzAchieve.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtimyzAchieve.setPrecision(10);		
        this.txtimyzAchieve.setRequired(false);
        // txtimxfAchieve		
        this.txtimxfAchieve.setVisible(true);		
        this.txtimxfAchieve.setHorizontalAlignment(2);		
        this.txtimxfAchieve.setDataType(1);		
        this.txtimxfAchieve.setSupportedEmpty(true);		
        this.txtimxfAchieve.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtimxfAchieve.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtimxfAchieve.setPrecision(10);		
        this.txtimxfAchieve.setRequired(false);
        // txtimknwAchieve		
        this.txtimknwAchieve.setVisible(true);		
        this.txtimknwAchieve.setHorizontalAlignment(2);		
        this.txtimknwAchieve.setDataType(1);		
        this.txtimknwAchieve.setSupportedEmpty(true);		
        this.txtimknwAchieve.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtimknwAchieve.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtimknwAchieve.setPrecision(10);		
        this.txtimknwAchieve.setRequired(false);
        // txtimeyAchieve		
        this.txtimeyAchieve.setVisible(true);		
        this.txtimeyAchieve.setHorizontalAlignment(2);		
        this.txtimeyAchieve.setDataType(1);		
        this.txtimeyAchieve.setSupportedEmpty(true);		
        this.txtimeyAchieve.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtimeyAchieve.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtimeyAchieve.setPrecision(10);		
        this.txtimeyAchieve.setRequired(false);
        // txtimmbAchieve		
        this.txtimmbAchieve.setVisible(true);		
        this.txtimmbAchieve.setHorizontalAlignment(2);		
        this.txtimmbAchieve.setDataType(1);		
        this.txtimmbAchieve.setSupportedEmpty(true);		
        this.txtimmbAchieve.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtimmbAchieve.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtimmbAchieve.setPrecision(10);		
        this.txtimmbAchieve.setRequired(false);
        // txtxtjyCount		
        this.txtxtjyCount.setVisible(true);		
        this.txtxtjyCount.setHorizontalAlignment(2);		
        this.txtxtjyCount.setDataType(1);		
        this.txtxtjyCount.setSupportedEmpty(true);		
        this.txtxtjyCount.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtxtjyCount.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtxtjyCount.setPrecision(10);		
        this.txtxtjyCount.setRequired(false);
        // txtxtplaCount		
        this.txtxtplaCount.setVisible(true);		
        this.txtxtplaCount.setHorizontalAlignment(2);		
        this.txtxtplaCount.setDataType(1);		
        this.txtxtplaCount.setSupportedEmpty(true);		
        this.txtxtplaCount.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtxtplaCount.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtxtplaCount.setPrecision(10);		
        this.txtxtplaCount.setRequired(false);
        // txtxtzxAchieve		
        this.txtxtzxAchieve.setVisible(true);		
        this.txtxtzxAchieve.setHorizontalAlignment(2);		
        this.txtxtzxAchieve.setDataType(1);		
        this.txtxtzxAchieve.setSupportedEmpty(true);		
        this.txtxtzxAchieve.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtxtzxAchieve.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtxtzxAchieve.setPrecision(10);		
        this.txtxtzxAchieve.setRequired(false);
        // txtxtzzAchieve		
        this.txtxtzzAchieve.setVisible(true);		
        this.txtxtzzAchieve.setHorizontalAlignment(2);		
        this.txtxtzzAchieve.setDataType(1);		
        this.txtxtzzAchieve.setSupportedEmpty(true);		
        this.txtxtzzAchieve.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtxtzzAchieve.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtxtzzAchieve.setPrecision(10);		
        this.txtxtzzAchieve.setRequired(false);
        // txtxtyxjzAchieve		
        this.txtxtyxjzAchieve.setVisible(true);		
        this.txtxtyxjzAchieve.setHorizontalAlignment(2);		
        this.txtxtyxjzAchieve.setDataType(1);		
        this.txtxtyxjzAchieve.setSupportedEmpty(true);		
        this.txtxtyxjzAchieve.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtxtyxjzAchieve.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtxtyxjzAchieve.setPrecision(10);		
        this.txtxtyxjzAchieve.setRequired(false);
        // txtxtgdjzAchieve		
        this.txtxtgdjzAchieve.setVisible(true);		
        this.txtxtgdjzAchieve.setHorizontalAlignment(2);		
        this.txtxtgdjzAchieve.setDataType(1);		
        this.txtxtgdjzAchieve.setSupportedEmpty(true);		
        this.txtxtgdjzAchieve.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtxtgdjzAchieve.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtxtgdjzAchieve.setPrecision(10);		
        this.txtxtgdjzAchieve.setRequired(false);
        // txtxtknwAchieve		
        this.txtxtknwAchieve.setVisible(true);		
        this.txtxtknwAchieve.setHorizontalAlignment(2);		
        this.txtxtknwAchieve.setDataType(1);		
        this.txtxtknwAchieve.setSupportedEmpty(true);		
        this.txtxtknwAchieve.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtxtknwAchieve.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtxtknwAchieve.setPrecision(10);		
        this.txtxtknwAchieve.setRequired(false);
        // txtxtxfAchieve		
        this.txtxtxfAchieve.setVisible(true);		
        this.txtxtxfAchieve.setHorizontalAlignment(2);		
        this.txtxtxfAchieve.setDataType(1);		
        this.txtxtxfAchieve.setSupportedEmpty(true);		
        this.txtxtxfAchieve.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtxtxfAchieve.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtxtxfAchieve.setPrecision(10);		
        this.txtxtxfAchieve.setRequired(false);
        // txtxteyAchieve		
        this.txtxteyAchieve.setVisible(true);		
        this.txtxteyAchieve.setHorizontalAlignment(2);		
        this.txtxteyAchieve.setDataType(1);		
        this.txtxteyAchieve.setSupportedEmpty(true);		
        this.txtxteyAchieve.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtxteyAchieve.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtxteyAchieve.setPrecision(10);		
        this.txtxteyAchieve.setRequired(false);
        // txtxtyzAchieve		
        this.txtxtyzAchieve.setVisible(true);		
        this.txtxtyzAchieve.setHorizontalAlignment(2);		
        this.txtxtyzAchieve.setDataType(1);		
        this.txtxtyzAchieve.setSupportedEmpty(true);		
        this.txtxtyzAchieve.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtxtyzAchieve.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtxtyzAchieve.setPrecision(10);		
        this.txtxtyzAchieve.setRequired(false);
        // txtxtwhiteAchieve		
        this.txtxtwhiteAchieve.setVisible(true);		
        this.txtxtwhiteAchieve.setHorizontalAlignment(2);		
        this.txtxtwhiteAchieve.setDataType(1);		
        this.txtxtwhiteAchieve.setSupportedEmpty(true);		
        this.txtxtwhiteAchieve.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtxtwhiteAchieve.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtxtwhiteAchieve.setPrecision(10);		
        this.txtxtwhiteAchieve.setRequired(false);
        // txtpostname		
        this.txtpostname.setVisible(true);		
        this.txtpostname.setHorizontalAlignment(2);		
        this.txtpostname.setMaxLength(100);		
        this.txtpostname.setRequired(false);
        // txtfreeyxjzAchieve		
        this.txtfreeyxjzAchieve.setVisible(true);		
        this.txtfreeyxjzAchieve.setHorizontalAlignment(2);		
        this.txtfreeyxjzAchieve.setDataType(1);		
        this.txtfreeyxjzAchieve.setSupportedEmpty(true);		
        this.txtfreeyxjzAchieve.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtfreeyxjzAchieve.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtfreeyxjzAchieve.setPrecision(10);		
        this.txtfreeyxjzAchieve.setRequired(false);
        // txtfreezzAchieve		
        this.txtfreezzAchieve.setVisible(true);		
        this.txtfreezzAchieve.setHorizontalAlignment(2);		
        this.txtfreezzAchieve.setDataType(1);		
        this.txtfreezzAchieve.setSupportedEmpty(true);		
        this.txtfreezzAchieve.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtfreezzAchieve.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtfreezzAchieve.setPrecision(10);		
        this.txtfreezzAchieve.setRequired(false);
        // txtfreegdjzAchieve		
        this.txtfreegdjzAchieve.setVisible(true);		
        this.txtfreegdjzAchieve.setHorizontalAlignment(2);		
        this.txtfreegdjzAchieve.setDataType(1);		
        this.txtfreegdjzAchieve.setSupportedEmpty(true);		
        this.txtfreegdjzAchieve.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtfreegdjzAchieve.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtfreegdjzAchieve.setPrecision(10);		
        this.txtfreegdjzAchieve.setRequired(false);
        // txtfreeyzAchieve		
        this.txtfreeyzAchieve.setVisible(true);		
        this.txtfreeyzAchieve.setHorizontalAlignment(2);		
        this.txtfreeyzAchieve.setDataType(1);		
        this.txtfreeyzAchieve.setSupportedEmpty(true);		
        this.txtfreeyzAchieve.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtfreeyzAchieve.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtfreeyzAchieve.setPrecision(10);		
        this.txtfreeyzAchieve.setRequired(false);
        // txtfreeknwAchieve		
        this.txtfreeknwAchieve.setVisible(true);		
        this.txtfreeknwAchieve.setHorizontalAlignment(2);		
        this.txtfreeknwAchieve.setDataType(1);		
        this.txtfreeknwAchieve.setSupportedEmpty(true);		
        this.txtfreeknwAchieve.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtfreeknwAchieve.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtfreeknwAchieve.setPrecision(10);		
        this.txtfreeknwAchieve.setRequired(false);
        // txtfreexfAchieve		
        this.txtfreexfAchieve.setVisible(true);		
        this.txtfreexfAchieve.setHorizontalAlignment(2);		
        this.txtfreexfAchieve.setDataType(1);		
        this.txtfreexfAchieve.setSupportedEmpty(true);		
        this.txtfreexfAchieve.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtfreexfAchieve.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtfreexfAchieve.setPrecision(10);		
        this.txtfreexfAchieve.setRequired(false);
        // txtfreeeyAchieve		
        this.txtfreeeyAchieve.setVisible(true);		
        this.txtfreeeyAchieve.setHorizontalAlignment(2);		
        this.txtfreeeyAchieve.setDataType(1);		
        this.txtfreeeyAchieve.setSupportedEmpty(true);		
        this.txtfreeeyAchieve.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtfreeeyAchieve.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtfreeeyAchieve.setPrecision(10);		
        this.txtfreeeyAchieve.setRequired(false);
        // txtfreembAchieve		
        this.txtfreembAchieve.setVisible(true);		
        this.txtfreembAchieve.setHorizontalAlignment(2);		
        this.txtfreembAchieve.setDataType(1);		
        this.txtfreembAchieve.setSupportedEmpty(true);		
        this.txtfreembAchieve.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtfreembAchieve.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtfreembAchieve.setPrecision(10);		
        this.txtfreembAchieve.setRequired(false);
        // txtallKeAchieve		
        this.txtallKeAchieve.setVisible(true);		
        this.txtallKeAchieve.setHorizontalAlignment(2);		
        this.txtallKeAchieve.setDataType(1);		
        this.txtallKeAchieve.setSupportedEmpty(true);		
        this.txtallKeAchieve.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtallKeAchieve.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtallKeAchieve.setPrecision(10);		
        this.txtallKeAchieve.setRequired(false);
        // txtxtmbAchieve		
        this.txtxtmbAchieve.setVisible(true);		
        this.txtxtmbAchieve.setHorizontalAlignment(2);		
        this.txtxtmbAchieve.setDataType(1);		
        this.txtxtmbAchieve.setSupportedEmpty(true);		
        this.txtxtmbAchieve.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtxtmbAchieve.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtxtmbAchieve.setPrecision(10);		
        this.txtxtmbAchieve.setRequired(false);
        // txtImAllKeAchieve		
        this.txtImAllKeAchieve.setVisible(true);		
        this.txtImAllKeAchieve.setHorizontalAlignment(2);		
        this.txtImAllKeAchieve.setDataType(1);		
        this.txtImAllKeAchieve.setSupportedEmpty(true);		
        this.txtImAllKeAchieve.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtImAllKeAchieve.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtImAllKeAchieve.setPrecision(10);		
        this.txtImAllKeAchieve.setRequired(false);
        // txtXtAllKeAchieve		
        this.txtXtAllKeAchieve.setVisible(true);		
        this.txtXtAllKeAchieve.setHorizontalAlignment(2);		
        this.txtXtAllKeAchieve.setDataType(1);		
        this.txtXtAllKeAchieve.setSupportedEmpty(true);		
        this.txtXtAllKeAchieve.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtXtAllKeAchieve.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtXtAllKeAchieve.setPrecision(10);		
        this.txtXtAllKeAchieve.setRequired(false);
        // txtzzbase		
        this.txtzzbase.setVisible(true);		
        this.txtzzbase.setHorizontalAlignment(2);		
        this.txtzzbase.setDataType(1);		
        this.txtzzbase.setSupportedEmpty(true);		
        this.txtzzbase.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtzzbase.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtzzbase.setPrecision(10);		
        this.txtzzbase.setRequired(false);
        // txtgdbase		
        this.txtgdbase.setVisible(true);		
        this.txtgdbase.setHorizontalAlignment(2);		
        this.txtgdbase.setDataType(1);		
        this.txtgdbase.setSupportedEmpty(true);		
        this.txtgdbase.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtgdbase.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtgdbase.setPrecision(10);		
        this.txtgdbase.setRequired(false);
        // txtyxbase		
        this.txtyxbase.setVisible(true);		
        this.txtyxbase.setHorizontalAlignment(2);		
        this.txtyxbase.setDataType(1);		
        this.txtyxbase.setSupportedEmpty(true);		
        this.txtyxbase.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtyxbase.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtyxbase.setPrecision(10);		
        this.txtyxbase.setRequired(false);
        // txtknwbase		
        this.txtknwbase.setVisible(true);		
        this.txtknwbase.setHorizontalAlignment(2);		
        this.txtknwbase.setDataType(1);		
        this.txtknwbase.setSupportedEmpty(true);		
        this.txtknwbase.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtknwbase.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtknwbase.setPrecision(10);		
        this.txtknwbase.setRequired(false);
        // txtxfbase		
        this.txtxfbase.setVisible(true);		
        this.txtxfbase.setHorizontalAlignment(2);		
        this.txtxfbase.setDataType(1);		
        this.txtxfbase.setSupportedEmpty(true);		
        this.txtxfbase.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtxfbase.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtxfbase.setPrecision(10);		
        this.txtxfbase.setRequired(false);
        // txtyzbase		
        this.txtyzbase.setVisible(true);		
        this.txtyzbase.setHorizontalAlignment(2);		
        this.txtyzbase.setDataType(1);		
        this.txtyzbase.setSupportedEmpty(true);		
        this.txtyzbase.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtyzbase.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtyzbase.setPrecision(10);		
        this.txtyzbase.setRequired(false);
        // txteybase		
        this.txteybase.setVisible(true);		
        this.txteybase.setHorizontalAlignment(2);		
        this.txteybase.setDataType(1);		
        this.txteybase.setSupportedEmpty(true);		
        this.txteybase.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txteybase.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txteybase.setPrecision(10);		
        this.txteybase.setRequired(false);
        // txtmbbase		
        this.txtmbbase.setVisible(true);		
        this.txtmbbase.setHorizontalAlignment(2);		
        this.txtmbbase.setDataType(1);		
        this.txtmbbase.setSupportedEmpty(true);		
        this.txtmbbase.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtmbbase.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtmbbase.setPrecision(10);		
        this.txtmbbase.setRequired(false);
        // txtallbase		
        this.txtallbase.setVisible(true);		
        this.txtallbase.setHorizontalAlignment(2);		
        this.txtallbase.setDataType(1);		
        this.txtallbase.setSupportedEmpty(true);		
        this.txtallbase.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtallbase.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtallbase.setPrecision(10);		
        this.txtallbase.setRequired(false);
        // txtcosydzCount		
        this.txtcosydzCount.setVisible(true);		
        this.txtcosydzCount.setHorizontalAlignment(2);		
        this.txtcosydzCount.setDataType(1);		
        this.txtcosydzCount.setSupportedEmpty(true);		
        this.txtcosydzCount.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtcosydzCount.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtcosydzCount.setPrecision(10);		
        this.txtcosydzCount.setRequired(false);
        // txtxtcosydzCount		
        this.txtxtcosydzCount.setVisible(true);		
        this.txtxtcosydzCount.setHorizontalAlignment(2);		
        this.txtxtcosydzCount.setDataType(1);		
        this.txtxtcosydzCount.setSupportedEmpty(true);		
        this.txtxtcosydzCount.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtxtcosydzCount.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtxtcosydzCount.setPrecision(10);		
        this.txtxtcosydzCount.setRequired(false);
        // txtimcosydzCount		
        this.txtimcosydzCount.setVisible(true);		
        this.txtimcosydzCount.setHorizontalAlignment(2);		
        this.txtimcosydzCount.setDataType(1);		
        this.txtimcosydzCount.setSupportedEmpty(true);		
        this.txtimcosydzCount.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtimcosydzCount.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtimcosydzCount.setPrecision(10);		
        this.txtimcosydzCount.setRequired(false);
        // txtcosyfdzCount		
        this.txtcosyfdzCount.setVisible(true);		
        this.txtcosyfdzCount.setHorizontalAlignment(2);		
        this.txtcosyfdzCount.setDataType(1);		
        this.txtcosyfdzCount.setSupportedEmpty(true);		
        this.txtcosyfdzCount.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtcosyfdzCount.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtcosyfdzCount.setPrecision(10);		
        this.txtcosyfdzCount.setRequired(false);
        // txtxtcosyfdzCount		
        this.txtxtcosyfdzCount.setVisible(true);		
        this.txtxtcosyfdzCount.setHorizontalAlignment(2);		
        this.txtxtcosyfdzCount.setDataType(1);		
        this.txtxtcosyfdzCount.setSupportedEmpty(true);		
        this.txtxtcosyfdzCount.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtxtcosyfdzCount.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtxtcosyfdzCount.setPrecision(10);		
        this.txtxtcosyfdzCount.setRequired(false);
        // txtimcosyfdzCount		
        this.txtimcosyfdzCount.setVisible(true);		
        this.txtimcosyfdzCount.setHorizontalAlignment(2);		
        this.txtimcosyfdzCount.setDataType(1);		
        this.txtimcosyfdzCount.setSupportedEmpty(true);		
        this.txtimcosyfdzCount.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtimcosyfdzCount.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtimcosyfdzCount.setPrecision(10);		
        this.txtimcosyfdzCount.setRequired(false);
        // txtzzpro		
        this.txtzzpro.setVisible(true);		
        this.txtzzpro.setHorizontalAlignment(2);		
        this.txtzzpro.setDataType(1);		
        this.txtzzpro.setSupportedEmpty(true);		
        this.txtzzpro.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtzzpro.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtzzpro.setPrecision(10);		
        this.txtzzpro.setRequired(false);
        // txtgdpro		
        this.txtgdpro.setVisible(true);		
        this.txtgdpro.setHorizontalAlignment(2);		
        this.txtgdpro.setDataType(1);		
        this.txtgdpro.setSupportedEmpty(true);		
        this.txtgdpro.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtgdpro.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtgdpro.setPrecision(10);		
        this.txtgdpro.setRequired(false);
        // txtyxpro		
        this.txtyxpro.setVisible(true);		
        this.txtyxpro.setHorizontalAlignment(2);		
        this.txtyxpro.setDataType(1);		
        this.txtyxpro.setSupportedEmpty(true);		
        this.txtyxpro.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtyxpro.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtyxpro.setPrecision(10);		
        this.txtyxpro.setRequired(false);
        // txtknwpro		
        this.txtknwpro.setVisible(true);		
        this.txtknwpro.setHorizontalAlignment(2);		
        this.txtknwpro.setDataType(1);		
        this.txtknwpro.setSupportedEmpty(true);		
        this.txtknwpro.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtknwpro.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtknwpro.setPrecision(10);		
        this.txtknwpro.setRequired(false);
        // txtxfpro		
        this.txtxfpro.setVisible(true);		
        this.txtxfpro.setHorizontalAlignment(2);		
        this.txtxfpro.setDataType(1);		
        this.txtxfpro.setSupportedEmpty(true);		
        this.txtxfpro.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtxfpro.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtxfpro.setPrecision(10);		
        this.txtxfpro.setRequired(false);
        // txtyzpro		
        this.txtyzpro.setVisible(true);		
        this.txtyzpro.setHorizontalAlignment(2);		
        this.txtyzpro.setDataType(1);		
        this.txtyzpro.setSupportedEmpty(true);		
        this.txtyzpro.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtyzpro.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtyzpro.setPrecision(10);		
        this.txtyzpro.setRequired(false);
        // txteypro		
        this.txteypro.setVisible(true);		
        this.txteypro.setHorizontalAlignment(2);		
        this.txteypro.setDataType(1);		
        this.txteypro.setSupportedEmpty(true);		
        this.txteypro.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txteypro.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txteypro.setPrecision(10);		
        this.txteypro.setRequired(false);
        // txtmbpro		
        this.txtmbpro.setVisible(true);		
        this.txtmbpro.setHorizontalAlignment(2);		
        this.txtmbpro.setDataType(1);		
        this.txtmbpro.setSupportedEmpty(true);		
        this.txtmbpro.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtmbpro.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtmbpro.setPrecision(10);		
        this.txtmbpro.setRequired(false);
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {txtgdjzMoney,txtyxjzMoney,txtknwMoney,txtyzMoney,txtmbMoney,txtxfMoney,txteyMoney,txtName,txtNumber,txtDescription,txtSimpleName,txtbusinessDate,txtempNumber,txtempName,txtclinicNumber,txtcityNumber,txtcityName,txtclinicName,txtjyCount,txtplaCount,txtwhiteAchieve,txtzxAchieve,txtzzAchieve,txtzzCost,txtgdjzAchieve,txtgdjzCost,txtyxjzAchieve,txtyxjzCost,txtzyAchieve,txtyzCost,txtknwAchieve,txtknwCost,txtmbAchieve,txtmbCost,txtxfAchieve,txtxfCost,txteyAchieve,txteyCost,txtsumAchieve,txtzzMoney,txtotherMoney,postType,chkiszidai,txtimjycount,txtimplacount,txtimwhiteAchieve,txtimzxAchieve,txtimzzAchieve,txtimyxjzAchieve,txtimgdjzAchieve,txtimknwAchieve,txtimxfAchieve,txtimyzAchieve,txtimeyAchieve,txtimmbAchieve,txtxtjyCount,txtxtplaCount,txtxtwhiteAchieve,txtxtzxAchieve,txtxtzzAchieve,txtxtyxjzAchieve,txtxtgdjzAchieve,txtxtknwAchieve,txtxtxfAchieve,txtxteyAchieve,txtxtyzAchieve,txtpostname,txtfreezzAchieve,txtfreeyxjzAchieve,txtfreegdjzAchieve,txtfreeyzAchieve,txtfreeknwAchieve,txtfreexfAchieve,txtfreeeyAchieve,txtfreembAchieve,txtallKeAchieve,txtxtmbAchieve,txtImAllKeAchieve,txtXtAllKeAchieve,txtzzbase,txtgdbase,txtyxbase,txtknwbase,txtxfbase,txtyzbase,txteybase,txtmbbase,txtallbase,txtcosydzCount,txtxtcosydzCount,txtimcosydzCount,txtcosyfdzCount,txtxtcosyfdzCount,txtimcosyfdzCount,txtzzpro,txtgdpro,txtyxpro,txtknwpro,txtxfpro,txtyzpro,txteypro,txtmbpro}));
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
        this.setBounds(new Rectangle(0, 0, 1013, 845));
        this.setLayout(null);
        kDLabelContainer1.setBounds(new Rectangle(672, 514, 270, 19));
        this.add(kDLabelContainer1, null);
        kDLabelContainer2.setBounds(new Rectangle(672, 442, 270, 19));
        this.add(kDLabelContainer2, null);
        kDLabelContainer3.setBounds(new Rectangle(672, 370, 270, 19));
        this.add(kDLabelContainer3, null);
        kDLabelContainer4.setBounds(new Rectangle(672, 298, 270, 19));
        this.add(kDLabelContainer4, null);
        contbusinessDate.setBounds(new Rectangle(672, 10, 270, 19));
        this.add(contbusinessDate, null);
        contempNumber.setBounds(new Rectangle(672, 34, 270, 19));
        this.add(contempNumber, null);
        contempName.setBounds(new Rectangle(10, 58, 270, 19));
        this.add(contempName, null);
        contclinicNumber.setBounds(new Rectangle(10, 34, 270, 19));
        this.add(contclinicNumber, null);
        contcityNumber.setBounds(new Rectangle(10, 10, 270, 19));
        this.add(contcityNumber, null);
        contcityName.setBounds(new Rectangle(341, 10, 270, 19));
        this.add(contcityName, null);
        contclinicName.setBounds(new Rectangle(341, 34, 270, 19));
        this.add(contclinicName, null);
        contjyCount.setBounds(new Rectangle(672, 82, 270, 19));
        this.add(contjyCount, null);
        contplaCount.setBounds(new Rectangle(672, 106, 270, 19));
        this.add(contplaCount, null);
        contwhiteAchieve.setBounds(new Rectangle(672, 178, 270, 19));
        this.add(contwhiteAchieve, null);
        contzxAchieve.setBounds(new Rectangle(672, 202, 270, 19));
        this.add(contzxAchieve, null);
        contzzAchieve.setBounds(new Rectangle(10, 274, 270, 19));
        this.add(contzzAchieve, null);
        contzzCost.setBounds(new Rectangle(341, 274, 270, 19));
        this.add(contzzCost, null);
        contgdjzAchieve.setBounds(new Rectangle(10, 418, 270, 19));
        this.add(contgdjzAchieve, null);
        contgdjzCost.setBounds(new Rectangle(341, 418, 270, 19));
        this.add(contgdjzCost, null);
        contyxjzAchieve.setBounds(new Rectangle(10, 346, 270, 19));
        this.add(contyxjzAchieve, null);
        contyxjzCost.setBounds(new Rectangle(341, 346, 270, 19));
        this.add(contyxjzCost, null);
        contzyAchieve.setBounds(new Rectangle(10, 706, 270, 19));
        this.add(contzyAchieve, null);
        contyzCost.setBounds(new Rectangle(341, 706, 270, 19));
        this.add(contyzCost, null);
        contknwAchieve.setBounds(new Rectangle(10, 490, 270, 19));
        this.add(contknwAchieve, null);
        contknwCost.setBounds(new Rectangle(341, 490, 270, 19));
        this.add(contknwCost, null);
        contmbAchieve.setBounds(new Rectangle(10, 778, 270, 19));
        this.add(contmbAchieve, null);
        contmbCost.setBounds(new Rectangle(341, 778, 270, 19));
        this.add(contmbCost, null);
        contxfAchieve.setBounds(new Rectangle(10, 562, 270, 19));
        this.add(contxfAchieve, null);
        contxfCost.setBounds(new Rectangle(341, 562, 270, 19));
        this.add(contxfCost, null);
        conteyAchieve.setBounds(new Rectangle(10, 634, 270, 19));
        this.add(conteyAchieve, null);
        conteyCost.setBounds(new Rectangle(341, 634, 270, 19));
        this.add(conteyCost, null);
        contsumAchieve.setBounds(new Rectangle(672, 730, 270, 19));
        this.add(contsumAchieve, null);
        contzzMoney.setBounds(new Rectangle(341, 298, 270, 19));
        this.add(contzzMoney, null);
        contgdjzMoney.setBounds(new Rectangle(341, 442, 270, 19));
        this.add(contgdjzMoney, null);
        contyxjzMoney.setBounds(new Rectangle(341, 370, 270, 19));
        this.add(contyxjzMoney, null);
        contknwMoney.setBounds(new Rectangle(341, 514, 270, 19));
        this.add(contknwMoney, null);
        contyzMoney.setBounds(new Rectangle(341, 730, 270, 19));
        this.add(contyzMoney, null);
        contmbMoney.setBounds(new Rectangle(341, 802, 270, 19));
        this.add(contmbMoney, null);
        contxfMoney.setBounds(new Rectangle(341, 586, 270, 19));
        this.add(contxfMoney, null);
        conteyMoney.setBounds(new Rectangle(341, 658, 270, 19));
        this.add(conteyMoney, null);
        contotherMoney.setBounds(new Rectangle(672, 658, 270, 19));
        this.add(contotherMoney, null);
        contpostType.setBounds(new Rectangle(341, 58, 270, 19));
        this.add(contpostType, null);
        chkiszidai.setBounds(new Rectangle(672, 58, 270, 19));
        this.add(chkiszidai, null);
        contimplacount.setBounds(new Rectangle(341, 106, 270, 19));
        this.add(contimplacount, null);
        contimjycount.setBounds(new Rectangle(341, 82, 270, 19));
        this.add(contimjycount, null);
        contimwhiteAchieve.setBounds(new Rectangle(341, 178, 270, 19));
        this.add(contimwhiteAchieve, null);
        contimzxAchieve.setBounds(new Rectangle(341, 202, 270, 19));
        this.add(contimzxAchieve, null);
        contimzzAchieve.setBounds(new Rectangle(341, 250, 270, 19));
        this.add(contimzzAchieve, null);
        contimyxjzAchieve.setBounds(new Rectangle(341, 322, 270, 19));
        this.add(contimyxjzAchieve, null);
        contimgdjzAchieve.setBounds(new Rectangle(341, 394, 270, 19));
        this.add(contimgdjzAchieve, null);
        contimyzAchieve.setBounds(new Rectangle(341, 682, 270, 19));
        this.add(contimyzAchieve, null);
        contimxfAchieve.setBounds(new Rectangle(341, 538, 270, 19));
        this.add(contimxfAchieve, null);
        contimknwAchieve.setBounds(new Rectangle(341, 466, 270, 19));
        this.add(contimknwAchieve, null);
        contimeyAchieve.setBounds(new Rectangle(341, 610, 270, 19));
        this.add(contimeyAchieve, null);
        contimmbAchieve.setBounds(new Rectangle(341, 754, 270, 19));
        this.add(contimmbAchieve, null);
        contxtjyCount.setBounds(new Rectangle(10, 82, 270, 19));
        this.add(contxtjyCount, null);
        contxtplaCount.setBounds(new Rectangle(10, 106, 270, 19));
        this.add(contxtplaCount, null);
        contxtzxAchieve.setBounds(new Rectangle(10, 202, 270, 19));
        this.add(contxtzxAchieve, null);
        contxtzzAchieve.setBounds(new Rectangle(10, 250, 270, 19));
        this.add(contxtzzAchieve, null);
        contxtyxjzAchieve.setBounds(new Rectangle(10, 322, 270, 19));
        this.add(contxtyxjzAchieve, null);
        contxtgdjzAchieve.setBounds(new Rectangle(10, 394, 270, 19));
        this.add(contxtgdjzAchieve, null);
        contxtknwAchieve.setBounds(new Rectangle(10, 466, 270, 19));
        this.add(contxtknwAchieve, null);
        contxtxfAchieve.setBounds(new Rectangle(10, 538, 270, 19));
        this.add(contxtxfAchieve, null);
        contxteyAchieve.setBounds(new Rectangle(10, 610, 270, 19));
        this.add(contxteyAchieve, null);
        contxtyzAchieve.setBounds(new Rectangle(10, 682, 270, 19));
        this.add(contxtyzAchieve, null);
        contxtwhiteAchieve.setBounds(new Rectangle(10, 178, 270, 19));
        this.add(contxtwhiteAchieve, null);
        contpostname.setBounds(new Rectangle(672, 586, 270, 19));
        this.add(contpostname, null);
        contfreeyxjzAchieve.setBounds(new Rectangle(672, 322, 270, 19));
        this.add(contfreeyxjzAchieve, null);
        contfreezzAchieve.setBounds(new Rectangle(672, 250, 270, 19));
        this.add(contfreezzAchieve, null);
        contfreegdjzAchieve.setBounds(new Rectangle(672, 394, 270, 19));
        this.add(contfreegdjzAchieve, null);
        contfreeyzAchieve.setBounds(new Rectangle(672, 682, 270, 19));
        this.add(contfreeyzAchieve, null);
        contfreeknwAchieve.setBounds(new Rectangle(672, 466, 270, 19));
        this.add(contfreeknwAchieve, null);
        contfreexfAchieve.setBounds(new Rectangle(672, 538, 270, 19));
        this.add(contfreexfAchieve, null);
        contfreeeyAchieve.setBounds(new Rectangle(672, 610, 270, 19));
        this.add(contfreeeyAchieve, null);
        contfreembAchieve.setBounds(new Rectangle(672, 754, 270, 19));
        this.add(contfreembAchieve, null);
        contallKeAchieve.setBounds(new Rectangle(672, 226, 270, 19));
        this.add(contallKeAchieve, null);
        contxtmbAchieve.setBounds(new Rectangle(10, 754, 270, 19));
        this.add(contxtmbAchieve, null);
        contImAllKeAchieve.setBounds(new Rectangle(341, 226, 270, 19));
        this.add(contImAllKeAchieve, null);
        contXtAllKeAchieve.setBounds(new Rectangle(10, 226, 270, 19));
        this.add(contXtAllKeAchieve, null);
        contzzbase.setBounds(new Rectangle(672, 274, 270, 19));
        this.add(contzzbase, null);
        contgdbase.setBounds(new Rectangle(672, 418, 270, 19));
        this.add(contgdbase, null);
        contyxbase.setBounds(new Rectangle(672, 346, 270, 19));
        this.add(contyxbase, null);
        contknwbase.setBounds(new Rectangle(672, 490, 270, 19));
        this.add(contknwbase, null);
        contxfbase.setBounds(new Rectangle(672, 562, 270, 19));
        this.add(contxfbase, null);
        contyzbase.setBounds(new Rectangle(672, 706, 270, 19));
        this.add(contyzbase, null);
        conteybase.setBounds(new Rectangle(672, 634, 270, 19));
        this.add(conteybase, null);
        contmbbase.setBounds(new Rectangle(672, 778, 270, 19));
        this.add(contmbbase, null);
        contallbase.setBounds(new Rectangle(672, 802, 270, 19));
        this.add(contallbase, null);
        contcosydzCount.setBounds(new Rectangle(672, 130, 270, 19));
        this.add(contcosydzCount, null);
        contxtcosydzCount.setBounds(new Rectangle(10, 130, 270, 19));
        this.add(contxtcosydzCount, null);
        contimcosydzCount.setBounds(new Rectangle(341, 130, 270, 19));
        this.add(contimcosydzCount, null);
        contcosyfdzCount.setBounds(new Rectangle(672, 154, 270, 19));
        this.add(contcosyfdzCount, null);
        contxtcosyfdzCount.setBounds(new Rectangle(10, 154, 270, 19));
        this.add(contxtcosyfdzCount, null);
        contimcosyfdzCount.setBounds(new Rectangle(341, 154, 270, 19));
        this.add(contimcosyfdzCount, null);
        contzzpro.setBounds(new Rectangle(10, 298, 270, 19));
        this.add(contzzpro, null);
        contgdpro.setBounds(new Rectangle(10, 442, 270, 19));
        this.add(contgdpro, null);
        contyxpro.setBounds(new Rectangle(10, 370, 270, 19));
        this.add(contyxpro, null);
        contknwpro.setBounds(new Rectangle(10, 514, 270, 19));
        this.add(contknwpro, null);
        contxfpro.setBounds(new Rectangle(10, 586, 270, 19));
        this.add(contxfpro, null);
        contyzpro.setBounds(new Rectangle(10, 730, 270, 19));
        this.add(contyzpro, null);
        conteypro.setBounds(new Rectangle(10, 658, 270, 19));
        this.add(conteypro, null);
        contmbpro.setBounds(new Rectangle(10, 802, 270, 19));
        this.add(contmbpro, null);
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
        //contwhiteAchieve
        contwhiteAchieve.setBoundEditor(txtwhiteAchieve);
        //contzxAchieve
        contzxAchieve.setBoundEditor(txtzxAchieve);
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
        //contpostType
        contpostType.setBoundEditor(postType);
        //contimplacount
        contimplacount.setBoundEditor(txtimplacount);
        //contimjycount
        contimjycount.setBoundEditor(txtimjycount);
        //contimwhiteAchieve
        contimwhiteAchieve.setBoundEditor(txtimwhiteAchieve);
        //contimzxAchieve
        contimzxAchieve.setBoundEditor(txtimzxAchieve);
        //contimzzAchieve
        contimzzAchieve.setBoundEditor(txtimzzAchieve);
        //contimyxjzAchieve
        contimyxjzAchieve.setBoundEditor(txtimyxjzAchieve);
        //contimgdjzAchieve
        contimgdjzAchieve.setBoundEditor(txtimgdjzAchieve);
        //contimyzAchieve
        contimyzAchieve.setBoundEditor(txtimyzAchieve);
        //contimxfAchieve
        contimxfAchieve.setBoundEditor(txtimxfAchieve);
        //contimknwAchieve
        contimknwAchieve.setBoundEditor(txtimknwAchieve);
        //contimeyAchieve
        contimeyAchieve.setBoundEditor(txtimeyAchieve);
        //contimmbAchieve
        contimmbAchieve.setBoundEditor(txtimmbAchieve);
        //contxtjyCount
        contxtjyCount.setBoundEditor(txtxtjyCount);
        //contxtplaCount
        contxtplaCount.setBoundEditor(txtxtplaCount);
        //contxtzxAchieve
        contxtzxAchieve.setBoundEditor(txtxtzxAchieve);
        //contxtzzAchieve
        contxtzzAchieve.setBoundEditor(txtxtzzAchieve);
        //contxtyxjzAchieve
        contxtyxjzAchieve.setBoundEditor(txtxtyxjzAchieve);
        //contxtgdjzAchieve
        contxtgdjzAchieve.setBoundEditor(txtxtgdjzAchieve);
        //contxtknwAchieve
        contxtknwAchieve.setBoundEditor(txtxtknwAchieve);
        //contxtxfAchieve
        contxtxfAchieve.setBoundEditor(txtxtxfAchieve);
        //contxteyAchieve
        contxteyAchieve.setBoundEditor(txtxteyAchieve);
        //contxtyzAchieve
        contxtyzAchieve.setBoundEditor(txtxtyzAchieve);
        //contxtwhiteAchieve
        contxtwhiteAchieve.setBoundEditor(txtxtwhiteAchieve);
        //contpostname
        contpostname.setBoundEditor(txtpostname);
        //contfreeyxjzAchieve
        contfreeyxjzAchieve.setBoundEditor(txtfreeyxjzAchieve);
        //contfreezzAchieve
        contfreezzAchieve.setBoundEditor(txtfreezzAchieve);
        //contfreegdjzAchieve
        contfreegdjzAchieve.setBoundEditor(txtfreegdjzAchieve);
        //contfreeyzAchieve
        contfreeyzAchieve.setBoundEditor(txtfreeyzAchieve);
        //contfreeknwAchieve
        contfreeknwAchieve.setBoundEditor(txtfreeknwAchieve);
        //contfreexfAchieve
        contfreexfAchieve.setBoundEditor(txtfreexfAchieve);
        //contfreeeyAchieve
        contfreeeyAchieve.setBoundEditor(txtfreeeyAchieve);
        //contfreembAchieve
        contfreembAchieve.setBoundEditor(txtfreembAchieve);
        //contallKeAchieve
        contallKeAchieve.setBoundEditor(txtallKeAchieve);
        //contxtmbAchieve
        contxtmbAchieve.setBoundEditor(txtxtmbAchieve);
        //contImAllKeAchieve
        contImAllKeAchieve.setBoundEditor(txtImAllKeAchieve);
        //contXtAllKeAchieve
        contXtAllKeAchieve.setBoundEditor(txtXtAllKeAchieve);
        //contzzbase
        contzzbase.setBoundEditor(txtzzbase);
        //contgdbase
        contgdbase.setBoundEditor(txtgdbase);
        //contyxbase
        contyxbase.setBoundEditor(txtyxbase);
        //contknwbase
        contknwbase.setBoundEditor(txtknwbase);
        //contxfbase
        contxfbase.setBoundEditor(txtxfbase);
        //contyzbase
        contyzbase.setBoundEditor(txtyzbase);
        //conteybase
        conteybase.setBoundEditor(txteybase);
        //contmbbase
        contmbbase.setBoundEditor(txtmbbase);
        //contallbase
        contallbase.setBoundEditor(txtallbase);
        //contcosydzCount
        contcosydzCount.setBoundEditor(txtcosydzCount);
        //contxtcosydzCount
        contxtcosydzCount.setBoundEditor(txtxtcosydzCount);
        //contimcosydzCount
        contimcosydzCount.setBoundEditor(txtimcosydzCount);
        //contcosyfdzCount
        contcosyfdzCount.setBoundEditor(txtcosyfdzCount);
        //contxtcosyfdzCount
        contxtcosyfdzCount.setBoundEditor(txtxtcosyfdzCount);
        //contimcosyfdzCount
        contimcosyfdzCount.setBoundEditor(txtimcosyfdzCount);
        //contzzpro
        contzzpro.setBoundEditor(txtzzpro);
        //contgdpro
        contgdpro.setBoundEditor(txtgdpro);
        //contyxpro
        contyxpro.setBoundEditor(txtyxpro);
        //contknwpro
        contknwpro.setBoundEditor(txtknwpro);
        //contxfpro
        contxfpro.setBoundEditor(txtxfpro);
        //contyzpro
        contyzpro.setBoundEditor(txtyzpro);
        //conteypro
        conteypro.setBoundEditor(txteypro);
        //contmbpro
        contmbpro.setBoundEditor(txtmbpro);

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
		dataBinder.registerBinding("iszidai", boolean.class, this.chkiszidai, "selected");
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
		dataBinder.registerBinding("whiteAchieve", java.math.BigDecimal.class, this.txtwhiteAchieve, "value");
		dataBinder.registerBinding("zxAchieve", java.math.BigDecimal.class, this.txtzxAchieve, "value");
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
		dataBinder.registerBinding("postType", com.kingdee.eas.mw.pay.app.PaypostType.class, this.postType, "selectedItem");
		dataBinder.registerBinding("implacount", java.math.BigDecimal.class, this.txtimplacount, "value");
		dataBinder.registerBinding("imjycount", java.math.BigDecimal.class, this.txtimjycount, "value");
		dataBinder.registerBinding("imwhiteAchieve", java.math.BigDecimal.class, this.txtimwhiteAchieve, "value");
		dataBinder.registerBinding("imzxAchieve", java.math.BigDecimal.class, this.txtimzxAchieve, "value");
		dataBinder.registerBinding("imzzAchieve", java.math.BigDecimal.class, this.txtimzzAchieve, "value");
		dataBinder.registerBinding("imyxjzAchieve", java.math.BigDecimal.class, this.txtimyxjzAchieve, "value");
		dataBinder.registerBinding("imgdjzAchieve", java.math.BigDecimal.class, this.txtimgdjzAchieve, "value");
		dataBinder.registerBinding("imyzAchieve", java.math.BigDecimal.class, this.txtimyzAchieve, "value");
		dataBinder.registerBinding("imxfAchieve", java.math.BigDecimal.class, this.txtimxfAchieve, "value");
		dataBinder.registerBinding("imknwAchieve", java.math.BigDecimal.class, this.txtimknwAchieve, "value");
		dataBinder.registerBinding("imeyAchieve", java.math.BigDecimal.class, this.txtimeyAchieve, "value");
		dataBinder.registerBinding("immbAchieve", java.math.BigDecimal.class, this.txtimmbAchieve, "value");
		dataBinder.registerBinding("xtjyCount", java.math.BigDecimal.class, this.txtxtjyCount, "value");
		dataBinder.registerBinding("xtplaCount", java.math.BigDecimal.class, this.txtxtplaCount, "value");
		dataBinder.registerBinding("xtzxAchieve", java.math.BigDecimal.class, this.txtxtzxAchieve, "value");
		dataBinder.registerBinding("xtzzAchieve", java.math.BigDecimal.class, this.txtxtzzAchieve, "value");
		dataBinder.registerBinding("xtyxjzAchieve", java.math.BigDecimal.class, this.txtxtyxjzAchieve, "value");
		dataBinder.registerBinding("xtgdjzAchieve", java.math.BigDecimal.class, this.txtxtgdjzAchieve, "value");
		dataBinder.registerBinding("xtknwAchieve", java.math.BigDecimal.class, this.txtxtknwAchieve, "value");
		dataBinder.registerBinding("xtxfAchieve", java.math.BigDecimal.class, this.txtxtxfAchieve, "value");
		dataBinder.registerBinding("xteyAchieve", java.math.BigDecimal.class, this.txtxteyAchieve, "value");
		dataBinder.registerBinding("xtyzAchieve", java.math.BigDecimal.class, this.txtxtyzAchieve, "value");
		dataBinder.registerBinding("xtwhiteAchieve", java.math.BigDecimal.class, this.txtxtwhiteAchieve, "value");
		dataBinder.registerBinding("postname", String.class, this.txtpostname, "text");
		dataBinder.registerBinding("freeyxjzAchieve", java.math.BigDecimal.class, this.txtfreeyxjzAchieve, "value");
		dataBinder.registerBinding("freezzAchieve", java.math.BigDecimal.class, this.txtfreezzAchieve, "value");
		dataBinder.registerBinding("freegdjzAchieve", java.math.BigDecimal.class, this.txtfreegdjzAchieve, "value");
		dataBinder.registerBinding("freeyzAchieve", java.math.BigDecimal.class, this.txtfreeyzAchieve, "value");
		dataBinder.registerBinding("freeknwAchieve", java.math.BigDecimal.class, this.txtfreeknwAchieve, "value");
		dataBinder.registerBinding("freexfAchieve", java.math.BigDecimal.class, this.txtfreexfAchieve, "value");
		dataBinder.registerBinding("freeeyAchieve", java.math.BigDecimal.class, this.txtfreeeyAchieve, "value");
		dataBinder.registerBinding("freembAchieve", java.math.BigDecimal.class, this.txtfreembAchieve, "value");
		dataBinder.registerBinding("allKeAchieve", java.math.BigDecimal.class, this.txtallKeAchieve, "value");
		dataBinder.registerBinding("xtmbAchieve", java.math.BigDecimal.class, this.txtxtmbAchieve, "value");
		dataBinder.registerBinding("ImAllKeAchieve", java.math.BigDecimal.class, this.txtImAllKeAchieve, "value");
		dataBinder.registerBinding("XtAllKeAchieve", java.math.BigDecimal.class, this.txtXtAllKeAchieve, "value");
		dataBinder.registerBinding("zzbase", java.math.BigDecimal.class, this.txtzzbase, "value");
		dataBinder.registerBinding("gdbase", java.math.BigDecimal.class, this.txtgdbase, "value");
		dataBinder.registerBinding("yxbase", java.math.BigDecimal.class, this.txtyxbase, "value");
		dataBinder.registerBinding("knwbase", java.math.BigDecimal.class, this.txtknwbase, "value");
		dataBinder.registerBinding("xfbase", java.math.BigDecimal.class, this.txtxfbase, "value");
		dataBinder.registerBinding("yzbase", java.math.BigDecimal.class, this.txtyzbase, "value");
		dataBinder.registerBinding("eybase", java.math.BigDecimal.class, this.txteybase, "value");
		dataBinder.registerBinding("mbbase", java.math.BigDecimal.class, this.txtmbbase, "value");
		dataBinder.registerBinding("allbase", java.math.BigDecimal.class, this.txtallbase, "value");
		dataBinder.registerBinding("cosydzCount", java.math.BigDecimal.class, this.txtcosydzCount, "value");
		dataBinder.registerBinding("xtcosydzCount", java.math.BigDecimal.class, this.txtxtcosydzCount, "value");
		dataBinder.registerBinding("imcosydzCount", java.math.BigDecimal.class, this.txtimcosydzCount, "value");
		dataBinder.registerBinding("cosyfdzCount", java.math.BigDecimal.class, this.txtcosyfdzCount, "value");
		dataBinder.registerBinding("xtcosyfdzCount", java.math.BigDecimal.class, this.txtxtcosyfdzCount, "value");
		dataBinder.registerBinding("imcosyfdzCount", java.math.BigDecimal.class, this.txtimcosyfdzCount, "value");
		dataBinder.registerBinding("zzpro", java.math.BigDecimal.class, this.txtzzpro, "value");
		dataBinder.registerBinding("gdpro", java.math.BigDecimal.class, this.txtgdpro, "value");
		dataBinder.registerBinding("yxpro", java.math.BigDecimal.class, this.txtyxpro, "value");
		dataBinder.registerBinding("knwpro", java.math.BigDecimal.class, this.txtknwpro, "value");
		dataBinder.registerBinding("xfpro", java.math.BigDecimal.class, this.txtxfpro, "value");
		dataBinder.registerBinding("yzpro", java.math.BigDecimal.class, this.txtyzpro, "value");
		dataBinder.registerBinding("eypro", java.math.BigDecimal.class, this.txteypro, "value");
		dataBinder.registerBinding("mbpro", java.math.BigDecimal.class, this.txtmbpro, "value");		
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
	    return "com.kingdee.eas.mw.pay.app.ClinicAchieveCosthSumEditUIHandler";
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
        this.editData = (com.kingdee.eas.mw.pay.ClinicAchieveCosthSumInfo)ov;
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
		getValidateHelper().registerBindProperty("iszidai", ValidateHelper.ON_SAVE);    
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
		getValidateHelper().registerBindProperty("whiteAchieve", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("zxAchieve", ValidateHelper.ON_SAVE);    
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
		getValidateHelper().registerBindProperty("postType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("implacount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("imjycount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("imwhiteAchieve", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("imzxAchieve", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("imzzAchieve", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("imyxjzAchieve", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("imgdjzAchieve", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("imyzAchieve", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("imxfAchieve", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("imknwAchieve", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("imeyAchieve", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("immbAchieve", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("xtjyCount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("xtplaCount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("xtzxAchieve", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("xtzzAchieve", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("xtyxjzAchieve", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("xtgdjzAchieve", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("xtknwAchieve", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("xtxfAchieve", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("xteyAchieve", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("xtyzAchieve", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("xtwhiteAchieve", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("postname", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("freeyxjzAchieve", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("freezzAchieve", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("freegdjzAchieve", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("freeyzAchieve", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("freeknwAchieve", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("freexfAchieve", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("freeeyAchieve", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("freembAchieve", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("allKeAchieve", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("xtmbAchieve", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("ImAllKeAchieve", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("XtAllKeAchieve", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("zzbase", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("gdbase", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("yxbase", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("knwbase", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("xfbase", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("yzbase", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("eybase", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("mbbase", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("allbase", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("cosydzCount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("xtcosydzCount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("imcosydzCount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("cosyfdzCount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("xtcosyfdzCount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("imcosyfdzCount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("zzpro", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("gdpro", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("yxpro", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("knwpro", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("xfpro", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("yzpro", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("eypro", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("mbpro", ValidateHelper.ON_SAVE);    		
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
        sic.add(new SelectorItemInfo("iszidai"));
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
        sic.add(new SelectorItemInfo("whiteAchieve"));
        sic.add(new SelectorItemInfo("zxAchieve"));
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
        sic.add(new SelectorItemInfo("postType"));
        sic.add(new SelectorItemInfo("implacount"));
        sic.add(new SelectorItemInfo("imjycount"));
        sic.add(new SelectorItemInfo("imwhiteAchieve"));
        sic.add(new SelectorItemInfo("imzxAchieve"));
        sic.add(new SelectorItemInfo("imzzAchieve"));
        sic.add(new SelectorItemInfo("imyxjzAchieve"));
        sic.add(new SelectorItemInfo("imgdjzAchieve"));
        sic.add(new SelectorItemInfo("imyzAchieve"));
        sic.add(new SelectorItemInfo("imxfAchieve"));
        sic.add(new SelectorItemInfo("imknwAchieve"));
        sic.add(new SelectorItemInfo("imeyAchieve"));
        sic.add(new SelectorItemInfo("immbAchieve"));
        sic.add(new SelectorItemInfo("xtjyCount"));
        sic.add(new SelectorItemInfo("xtplaCount"));
        sic.add(new SelectorItemInfo("xtzxAchieve"));
        sic.add(new SelectorItemInfo("xtzzAchieve"));
        sic.add(new SelectorItemInfo("xtyxjzAchieve"));
        sic.add(new SelectorItemInfo("xtgdjzAchieve"));
        sic.add(new SelectorItemInfo("xtknwAchieve"));
        sic.add(new SelectorItemInfo("xtxfAchieve"));
        sic.add(new SelectorItemInfo("xteyAchieve"));
        sic.add(new SelectorItemInfo("xtyzAchieve"));
        sic.add(new SelectorItemInfo("xtwhiteAchieve"));
        sic.add(new SelectorItemInfo("postname"));
        sic.add(new SelectorItemInfo("freeyxjzAchieve"));
        sic.add(new SelectorItemInfo("freezzAchieve"));
        sic.add(new SelectorItemInfo("freegdjzAchieve"));
        sic.add(new SelectorItemInfo("freeyzAchieve"));
        sic.add(new SelectorItemInfo("freeknwAchieve"));
        sic.add(new SelectorItemInfo("freexfAchieve"));
        sic.add(new SelectorItemInfo("freeeyAchieve"));
        sic.add(new SelectorItemInfo("freembAchieve"));
        sic.add(new SelectorItemInfo("allKeAchieve"));
        sic.add(new SelectorItemInfo("xtmbAchieve"));
        sic.add(new SelectorItemInfo("ImAllKeAchieve"));
        sic.add(new SelectorItemInfo("XtAllKeAchieve"));
        sic.add(new SelectorItemInfo("zzbase"));
        sic.add(new SelectorItemInfo("gdbase"));
        sic.add(new SelectorItemInfo("yxbase"));
        sic.add(new SelectorItemInfo("knwbase"));
        sic.add(new SelectorItemInfo("xfbase"));
        sic.add(new SelectorItemInfo("yzbase"));
        sic.add(new SelectorItemInfo("eybase"));
        sic.add(new SelectorItemInfo("mbbase"));
        sic.add(new SelectorItemInfo("allbase"));
        sic.add(new SelectorItemInfo("cosydzCount"));
        sic.add(new SelectorItemInfo("xtcosydzCount"));
        sic.add(new SelectorItemInfo("imcosydzCount"));
        sic.add(new SelectorItemInfo("cosyfdzCount"));
        sic.add(new SelectorItemInfo("xtcosyfdzCount"));
        sic.add(new SelectorItemInfo("imcosyfdzCount"));
        sic.add(new SelectorItemInfo("zzpro"));
        sic.add(new SelectorItemInfo("gdpro"));
        sic.add(new SelectorItemInfo("yxpro"));
        sic.add(new SelectorItemInfo("knwpro"));
        sic.add(new SelectorItemInfo("xfpro"));
        sic.add(new SelectorItemInfo("yzpro"));
        sic.add(new SelectorItemInfo("eypro"));
        sic.add(new SelectorItemInfo("mbpro"));
        return sic;
    }        

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.mw.pay.client", "ClinicAchieveCosthSumEditUI");
    }

    /**
     * output getEditUIName method
     */
    protected String getEditUIName()
    {
        return com.kingdee.eas.mw.pay.client.ClinicAchieveCosthSumEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.mw.pay.ClinicAchieveCosthSumFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.mw.pay.ClinicAchieveCosthSumInfo objectValue = new com.kingdee.eas.mw.pay.ClinicAchieveCosthSumInfo();
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