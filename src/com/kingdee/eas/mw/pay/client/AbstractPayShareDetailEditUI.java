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
public abstract class AbstractPayShareDetailEditUI extends com.kingdee.eas.framework.client.EditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractPayShareDetailEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer2;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer3;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer4;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcostCenterNumber;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contpostTypeNumber;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contiscount;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbusinessdate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contjibengongzi;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contqita;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contgudingmoney;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbaodiMoney;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfudongMoney;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbaodibuzu;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contjiangjinAll;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contyingfaMoney;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conttiepiao;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contguaiaitong;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contlaowuMoney;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contqitamoshi;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contyingshuiMoney;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contshouxufei;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcomyanglao;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcomyiliao;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcomshiye;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcomgongshang;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcomshengyu;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcomgongjijin;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfuwufei;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contshuijin;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcomshebaoAll;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contmwMoney;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contshuihouqita;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contjingjibuchang;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contyuefurenli;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contyuedurenliAll;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contperYanglao;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contperYiliao;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contperShiye;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contperGongjijin;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contgeshui;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contshifa;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contnianzhongfentan;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contjidufentan;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contnianzhong;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contjidu;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcomdabing;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contemptype;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contTPShouxufei;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contGATShouxufei;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contLWShouxufei;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contQTShouxufei;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contthiscity;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcom;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contper;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcost;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contpost;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contperDabing;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox txtName;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtSimpleName;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox txtDescription;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtcostCenterNumber;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtpostTypeNumber;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtiscount;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtbusinessdate;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtjibengongzi;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtqita;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtgudingmoney;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtbaodiMoney;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtfudongMoney;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtbaodibuzu;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtjiangjinAll;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtyingfaMoney;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txttiepiao;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtguaiaitong;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtlaowuMoney;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtqitamoshi;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtyingshuiMoney;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtshouxufei;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtcomyanglao;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtcomyiliao;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtcomshiye;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtcomgongshang;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtcomshengyu;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtcomgongjijin;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtfuwufei;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtshuijin;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtcomshebaoAll;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtmwMoney;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtshuihouqita;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtjingjibuchang;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtyuefurenli;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtyuedurenliAll;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtperYanglao;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtperYiliao;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtperShiye;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtperGongjijin;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtgeshui;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtshifa;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtnianzhongfentan;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtjidufentan;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtnianzhong;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtjidu;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtcomdabing;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtemptype;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtTPShouxufei;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtGATShouxufei;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtLWShouxufei;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtQTShouxufei;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtthiscity;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcom;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtper;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcost;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtpost;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtperDabing;
    protected com.kingdee.eas.mw.pay.PayShareDetailInfo editData = null;
    /**
     * output class constructor
     */
    public AbstractPayShareDetailEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractPayShareDetailEditUI.class.getName());
        this.setUITitle(resHelper.getString("this.title"));
        this.kDLabelContainer1 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer2 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer3 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer4 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcostCenterNumber = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contpostTypeNumber = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contiscount = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbusinessdate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contjibengongzi = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contqita = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contgudingmoney = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbaodiMoney = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfudongMoney = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbaodibuzu = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contjiangjinAll = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contyingfaMoney = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conttiepiao = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contguaiaitong = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contlaowuMoney = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contqitamoshi = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contyingshuiMoney = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contshouxufei = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcomyanglao = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcomyiliao = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcomshiye = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcomgongshang = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcomshengyu = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcomgongjijin = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfuwufei = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contshuijin = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcomshebaoAll = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contmwMoney = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contshuihouqita = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contjingjibuchang = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contyuefurenli = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contyuedurenliAll = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contperYanglao = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contperYiliao = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contperShiye = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contperGongjijin = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contgeshui = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contshifa = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contnianzhongfentan = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contjidufentan = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contnianzhong = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contjidu = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcomdabing = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contemptype = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contTPShouxufei = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contGATShouxufei = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contLWShouxufei = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contQTShouxufei = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contthiscity = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcom = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contper = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcost = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contpost = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contperDabing = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtName = new com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox();
        this.txtSimpleName = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtDescription = new com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox();
        this.txtcostCenterNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtpostTypeNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtiscount = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtbusinessdate = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtjibengongzi = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtqita = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtgudingmoney = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtbaodiMoney = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtfudongMoney = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtbaodibuzu = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtjiangjinAll = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtyingfaMoney = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txttiepiao = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtguaiaitong = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtlaowuMoney = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtqitamoshi = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtyingshuiMoney = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtshouxufei = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtcomyanglao = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtcomyiliao = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtcomshiye = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtcomgongshang = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtcomshengyu = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtcomgongjijin = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtfuwufei = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtshuijin = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtcomshebaoAll = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtmwMoney = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtshuihouqita = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtjingjibuchang = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtyuefurenli = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtyuedurenliAll = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtperYanglao = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtperYiliao = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtperShiye = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtperGongjijin = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtgeshui = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtshifa = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtnianzhongfentan = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtjidufentan = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtnianzhong = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtjidu = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtcomdabing = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtemptype = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtTPShouxufei = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtGATShouxufei = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtLWShouxufei = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtQTShouxufei = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.prmtthiscity = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtcom = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtper = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtcost = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtpost = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtperDabing = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.kDLabelContainer1.setName("kDLabelContainer1");
        this.kDLabelContainer2.setName("kDLabelContainer2");
        this.kDLabelContainer3.setName("kDLabelContainer3");
        this.kDLabelContainer4.setName("kDLabelContainer4");
        this.contcostCenterNumber.setName("contcostCenterNumber");
        this.contpostTypeNumber.setName("contpostTypeNumber");
        this.contiscount.setName("contiscount");
        this.contbusinessdate.setName("contbusinessdate");
        this.contjibengongzi.setName("contjibengongzi");
        this.contqita.setName("contqita");
        this.contgudingmoney.setName("contgudingmoney");
        this.contbaodiMoney.setName("contbaodiMoney");
        this.contfudongMoney.setName("contfudongMoney");
        this.contbaodibuzu.setName("contbaodibuzu");
        this.contjiangjinAll.setName("contjiangjinAll");
        this.contyingfaMoney.setName("contyingfaMoney");
        this.conttiepiao.setName("conttiepiao");
        this.contguaiaitong.setName("contguaiaitong");
        this.contlaowuMoney.setName("contlaowuMoney");
        this.contqitamoshi.setName("contqitamoshi");
        this.contyingshuiMoney.setName("contyingshuiMoney");
        this.contshouxufei.setName("contshouxufei");
        this.contcomyanglao.setName("contcomyanglao");
        this.contcomyiliao.setName("contcomyiliao");
        this.contcomshiye.setName("contcomshiye");
        this.contcomgongshang.setName("contcomgongshang");
        this.contcomshengyu.setName("contcomshengyu");
        this.contcomgongjijin.setName("contcomgongjijin");
        this.contfuwufei.setName("contfuwufei");
        this.contshuijin.setName("contshuijin");
        this.contcomshebaoAll.setName("contcomshebaoAll");
        this.contmwMoney.setName("contmwMoney");
        this.contshuihouqita.setName("contshuihouqita");
        this.contjingjibuchang.setName("contjingjibuchang");
        this.contyuefurenli.setName("contyuefurenli");
        this.contyuedurenliAll.setName("contyuedurenliAll");
        this.contperYanglao.setName("contperYanglao");
        this.contperYiliao.setName("contperYiliao");
        this.contperShiye.setName("contperShiye");
        this.contperGongjijin.setName("contperGongjijin");
        this.contgeshui.setName("contgeshui");
        this.contshifa.setName("contshifa");
        this.contnianzhongfentan.setName("contnianzhongfentan");
        this.contjidufentan.setName("contjidufentan");
        this.contnianzhong.setName("contnianzhong");
        this.contjidu.setName("contjidu");
        this.contcomdabing.setName("contcomdabing");
        this.contemptype.setName("contemptype");
        this.contTPShouxufei.setName("contTPShouxufei");
        this.contGATShouxufei.setName("contGATShouxufei");
        this.contLWShouxufei.setName("contLWShouxufei");
        this.contQTShouxufei.setName("contQTShouxufei");
        this.contthiscity.setName("contthiscity");
        this.contcom.setName("contcom");
        this.contper.setName("contper");
        this.contcost.setName("contcost");
        this.contpost.setName("contpost");
        this.contperDabing.setName("contperDabing");
        this.txtNumber.setName("txtNumber");
        this.txtName.setName("txtName");
        this.txtSimpleName.setName("txtSimpleName");
        this.txtDescription.setName("txtDescription");
        this.txtcostCenterNumber.setName("txtcostCenterNumber");
        this.txtpostTypeNumber.setName("txtpostTypeNumber");
        this.txtiscount.setName("txtiscount");
        this.txtbusinessdate.setName("txtbusinessdate");
        this.txtjibengongzi.setName("txtjibengongzi");
        this.txtqita.setName("txtqita");
        this.txtgudingmoney.setName("txtgudingmoney");
        this.txtbaodiMoney.setName("txtbaodiMoney");
        this.txtfudongMoney.setName("txtfudongMoney");
        this.txtbaodibuzu.setName("txtbaodibuzu");
        this.txtjiangjinAll.setName("txtjiangjinAll");
        this.txtyingfaMoney.setName("txtyingfaMoney");
        this.txttiepiao.setName("txttiepiao");
        this.txtguaiaitong.setName("txtguaiaitong");
        this.txtlaowuMoney.setName("txtlaowuMoney");
        this.txtqitamoshi.setName("txtqitamoshi");
        this.txtyingshuiMoney.setName("txtyingshuiMoney");
        this.txtshouxufei.setName("txtshouxufei");
        this.txtcomyanglao.setName("txtcomyanglao");
        this.txtcomyiliao.setName("txtcomyiliao");
        this.txtcomshiye.setName("txtcomshiye");
        this.txtcomgongshang.setName("txtcomgongshang");
        this.txtcomshengyu.setName("txtcomshengyu");
        this.txtcomgongjijin.setName("txtcomgongjijin");
        this.txtfuwufei.setName("txtfuwufei");
        this.txtshuijin.setName("txtshuijin");
        this.txtcomshebaoAll.setName("txtcomshebaoAll");
        this.txtmwMoney.setName("txtmwMoney");
        this.txtshuihouqita.setName("txtshuihouqita");
        this.txtjingjibuchang.setName("txtjingjibuchang");
        this.txtyuefurenli.setName("txtyuefurenli");
        this.txtyuedurenliAll.setName("txtyuedurenliAll");
        this.txtperYanglao.setName("txtperYanglao");
        this.txtperYiliao.setName("txtperYiliao");
        this.txtperShiye.setName("txtperShiye");
        this.txtperGongjijin.setName("txtperGongjijin");
        this.txtgeshui.setName("txtgeshui");
        this.txtshifa.setName("txtshifa");
        this.txtnianzhongfentan.setName("txtnianzhongfentan");
        this.txtjidufentan.setName("txtjidufentan");
        this.txtnianzhong.setName("txtnianzhong");
        this.txtjidu.setName("txtjidu");
        this.txtcomdabing.setName("txtcomdabing");
        this.txtemptype.setName("txtemptype");
        this.txtTPShouxufei.setName("txtTPShouxufei");
        this.txtGATShouxufei.setName("txtGATShouxufei");
        this.txtLWShouxufei.setName("txtLWShouxufei");
        this.txtQTShouxufei.setName("txtQTShouxufei");
        this.prmtthiscity.setName("prmtthiscity");
        this.prmtcom.setName("prmtcom");
        this.prmtper.setName("prmtper");
        this.prmtcost.setName("prmtcost");
        this.prmtpost.setName("prmtpost");
        this.txtperDabing.setName("txtperDabing");
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
        // contcostCenterNumber		
        this.contcostCenterNumber.setBoundLabelText(resHelper.getString("contcostCenterNumber.boundLabelText"));		
        this.contcostCenterNumber.setBoundLabelLength(100);		
        this.contcostCenterNumber.setBoundLabelUnderline(true);		
        this.contcostCenterNumber.setVisible(true);
        // contpostTypeNumber		
        this.contpostTypeNumber.setBoundLabelText(resHelper.getString("contpostTypeNumber.boundLabelText"));		
        this.contpostTypeNumber.setBoundLabelLength(100);		
        this.contpostTypeNumber.setBoundLabelUnderline(true);		
        this.contpostTypeNumber.setVisible(true);
        // contiscount		
        this.contiscount.setBoundLabelText(resHelper.getString("contiscount.boundLabelText"));		
        this.contiscount.setBoundLabelLength(100);		
        this.contiscount.setBoundLabelUnderline(true);		
        this.contiscount.setVisible(true);
        // contbusinessdate		
        this.contbusinessdate.setBoundLabelText(resHelper.getString("contbusinessdate.boundLabelText"));		
        this.contbusinessdate.setBoundLabelLength(100);		
        this.contbusinessdate.setBoundLabelUnderline(true);		
        this.contbusinessdate.setVisible(true);
        // contjibengongzi		
        this.contjibengongzi.setBoundLabelText(resHelper.getString("contjibengongzi.boundLabelText"));		
        this.contjibengongzi.setBoundLabelLength(100);		
        this.contjibengongzi.setBoundLabelUnderline(true);		
        this.contjibengongzi.setVisible(true);
        // contqita		
        this.contqita.setBoundLabelText(resHelper.getString("contqita.boundLabelText"));		
        this.contqita.setBoundLabelLength(100);		
        this.contqita.setBoundLabelUnderline(true);		
        this.contqita.setVisible(true);
        // contgudingmoney		
        this.contgudingmoney.setBoundLabelText(resHelper.getString("contgudingmoney.boundLabelText"));		
        this.contgudingmoney.setBoundLabelLength(100);		
        this.contgudingmoney.setBoundLabelUnderline(true);		
        this.contgudingmoney.setVisible(true);
        // contbaodiMoney		
        this.contbaodiMoney.setBoundLabelText(resHelper.getString("contbaodiMoney.boundLabelText"));		
        this.contbaodiMoney.setBoundLabelLength(100);		
        this.contbaodiMoney.setBoundLabelUnderline(true);		
        this.contbaodiMoney.setVisible(true);
        // contfudongMoney		
        this.contfudongMoney.setBoundLabelText(resHelper.getString("contfudongMoney.boundLabelText"));		
        this.contfudongMoney.setBoundLabelLength(100);		
        this.contfudongMoney.setBoundLabelUnderline(true);		
        this.contfudongMoney.setVisible(true);
        // contbaodibuzu		
        this.contbaodibuzu.setBoundLabelText(resHelper.getString("contbaodibuzu.boundLabelText"));		
        this.contbaodibuzu.setBoundLabelLength(100);		
        this.contbaodibuzu.setBoundLabelUnderline(true);		
        this.contbaodibuzu.setVisible(true);
        // contjiangjinAll		
        this.contjiangjinAll.setBoundLabelText(resHelper.getString("contjiangjinAll.boundLabelText"));		
        this.contjiangjinAll.setBoundLabelLength(100);		
        this.contjiangjinAll.setBoundLabelUnderline(true);		
        this.contjiangjinAll.setVisible(true);
        // contyingfaMoney		
        this.contyingfaMoney.setBoundLabelText(resHelper.getString("contyingfaMoney.boundLabelText"));		
        this.contyingfaMoney.setBoundLabelLength(100);		
        this.contyingfaMoney.setBoundLabelUnderline(true);		
        this.contyingfaMoney.setVisible(true);
        // conttiepiao		
        this.conttiepiao.setBoundLabelText(resHelper.getString("conttiepiao.boundLabelText"));		
        this.conttiepiao.setBoundLabelLength(100);		
        this.conttiepiao.setBoundLabelUnderline(true);		
        this.conttiepiao.setVisible(true);
        // contguaiaitong		
        this.contguaiaitong.setBoundLabelText(resHelper.getString("contguaiaitong.boundLabelText"));		
        this.contguaiaitong.setBoundLabelLength(100);		
        this.contguaiaitong.setBoundLabelUnderline(true);		
        this.contguaiaitong.setVisible(true);
        // contlaowuMoney		
        this.contlaowuMoney.setBoundLabelText(resHelper.getString("contlaowuMoney.boundLabelText"));		
        this.contlaowuMoney.setBoundLabelLength(100);		
        this.contlaowuMoney.setBoundLabelUnderline(true);		
        this.contlaowuMoney.setVisible(true);
        // contqitamoshi		
        this.contqitamoshi.setBoundLabelText(resHelper.getString("contqitamoshi.boundLabelText"));		
        this.contqitamoshi.setBoundLabelLength(100);		
        this.contqitamoshi.setBoundLabelUnderline(true);		
        this.contqitamoshi.setVisible(true);
        // contyingshuiMoney		
        this.contyingshuiMoney.setBoundLabelText(resHelper.getString("contyingshuiMoney.boundLabelText"));		
        this.contyingshuiMoney.setBoundLabelLength(100);		
        this.contyingshuiMoney.setBoundLabelUnderline(true);		
        this.contyingshuiMoney.setVisible(true);
        // contshouxufei		
        this.contshouxufei.setBoundLabelText(resHelper.getString("contshouxufei.boundLabelText"));		
        this.contshouxufei.setBoundLabelLength(100);		
        this.contshouxufei.setBoundLabelUnderline(true);		
        this.contshouxufei.setVisible(true);
        // contcomyanglao		
        this.contcomyanglao.setBoundLabelText(resHelper.getString("contcomyanglao.boundLabelText"));		
        this.contcomyanglao.setBoundLabelLength(100);		
        this.contcomyanglao.setBoundLabelUnderline(true);		
        this.contcomyanglao.setVisible(true);
        // contcomyiliao		
        this.contcomyiliao.setBoundLabelText(resHelper.getString("contcomyiliao.boundLabelText"));		
        this.contcomyiliao.setBoundLabelLength(100);		
        this.contcomyiliao.setBoundLabelUnderline(true);		
        this.contcomyiliao.setVisible(true);
        // contcomshiye		
        this.contcomshiye.setBoundLabelText(resHelper.getString("contcomshiye.boundLabelText"));		
        this.contcomshiye.setBoundLabelLength(100);		
        this.contcomshiye.setBoundLabelUnderline(true);		
        this.contcomshiye.setVisible(true);
        // contcomgongshang		
        this.contcomgongshang.setBoundLabelText(resHelper.getString("contcomgongshang.boundLabelText"));		
        this.contcomgongshang.setBoundLabelLength(100);		
        this.contcomgongshang.setBoundLabelUnderline(true);		
        this.contcomgongshang.setVisible(true);
        // contcomshengyu		
        this.contcomshengyu.setBoundLabelText(resHelper.getString("contcomshengyu.boundLabelText"));		
        this.contcomshengyu.setBoundLabelLength(100);		
        this.contcomshengyu.setBoundLabelUnderline(true);		
        this.contcomshengyu.setVisible(true);
        // contcomgongjijin		
        this.contcomgongjijin.setBoundLabelText(resHelper.getString("contcomgongjijin.boundLabelText"));		
        this.contcomgongjijin.setBoundLabelLength(100);		
        this.contcomgongjijin.setBoundLabelUnderline(true);		
        this.contcomgongjijin.setVisible(true);
        // contfuwufei		
        this.contfuwufei.setBoundLabelText(resHelper.getString("contfuwufei.boundLabelText"));		
        this.contfuwufei.setBoundLabelLength(100);		
        this.contfuwufei.setBoundLabelUnderline(true);		
        this.contfuwufei.setVisible(true);
        // contshuijin		
        this.contshuijin.setBoundLabelText(resHelper.getString("contshuijin.boundLabelText"));		
        this.contshuijin.setBoundLabelLength(100);		
        this.contshuijin.setBoundLabelUnderline(true);		
        this.contshuijin.setVisible(true);
        // contcomshebaoAll		
        this.contcomshebaoAll.setBoundLabelText(resHelper.getString("contcomshebaoAll.boundLabelText"));		
        this.contcomshebaoAll.setBoundLabelLength(100);		
        this.contcomshebaoAll.setBoundLabelUnderline(true);		
        this.contcomshebaoAll.setVisible(true);
        // contmwMoney		
        this.contmwMoney.setBoundLabelText(resHelper.getString("contmwMoney.boundLabelText"));		
        this.contmwMoney.setBoundLabelLength(100);		
        this.contmwMoney.setBoundLabelUnderline(true);		
        this.contmwMoney.setVisible(true);
        // contshuihouqita		
        this.contshuihouqita.setBoundLabelText(resHelper.getString("contshuihouqita.boundLabelText"));		
        this.contshuihouqita.setBoundLabelLength(100);		
        this.contshuihouqita.setBoundLabelUnderline(true);		
        this.contshuihouqita.setVisible(true);
        // contjingjibuchang		
        this.contjingjibuchang.setBoundLabelText(resHelper.getString("contjingjibuchang.boundLabelText"));		
        this.contjingjibuchang.setBoundLabelLength(100);		
        this.contjingjibuchang.setBoundLabelUnderline(true);		
        this.contjingjibuchang.setVisible(true);
        // contyuefurenli		
        this.contyuefurenli.setBoundLabelText(resHelper.getString("contyuefurenli.boundLabelText"));		
        this.contyuefurenli.setBoundLabelLength(100);		
        this.contyuefurenli.setBoundLabelUnderline(true);		
        this.contyuefurenli.setVisible(true);
        // contyuedurenliAll		
        this.contyuedurenliAll.setBoundLabelText(resHelper.getString("contyuedurenliAll.boundLabelText"));		
        this.contyuedurenliAll.setBoundLabelLength(100);		
        this.contyuedurenliAll.setBoundLabelUnderline(true);		
        this.contyuedurenliAll.setVisible(true);
        // contperYanglao		
        this.contperYanglao.setBoundLabelText(resHelper.getString("contperYanglao.boundLabelText"));		
        this.contperYanglao.setBoundLabelLength(100);		
        this.contperYanglao.setBoundLabelUnderline(true);		
        this.contperYanglao.setVisible(true);
        // contperYiliao		
        this.contperYiliao.setBoundLabelText(resHelper.getString("contperYiliao.boundLabelText"));		
        this.contperYiliao.setBoundLabelLength(100);		
        this.contperYiliao.setBoundLabelUnderline(true);		
        this.contperYiliao.setVisible(true);
        // contperShiye		
        this.contperShiye.setBoundLabelText(resHelper.getString("contperShiye.boundLabelText"));		
        this.contperShiye.setBoundLabelLength(100);		
        this.contperShiye.setBoundLabelUnderline(true);		
        this.contperShiye.setVisible(true);
        // contperGongjijin		
        this.contperGongjijin.setBoundLabelText(resHelper.getString("contperGongjijin.boundLabelText"));		
        this.contperGongjijin.setBoundLabelLength(100);		
        this.contperGongjijin.setBoundLabelUnderline(true);		
        this.contperGongjijin.setVisible(true);
        // contgeshui		
        this.contgeshui.setBoundLabelText(resHelper.getString("contgeshui.boundLabelText"));		
        this.contgeshui.setBoundLabelLength(100);		
        this.contgeshui.setBoundLabelUnderline(true);		
        this.contgeshui.setVisible(true);
        // contshifa		
        this.contshifa.setBoundLabelText(resHelper.getString("contshifa.boundLabelText"));		
        this.contshifa.setBoundLabelLength(100);		
        this.contshifa.setBoundLabelUnderline(true);		
        this.contshifa.setVisible(true);
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
        // contnianzhong		
        this.contnianzhong.setBoundLabelText(resHelper.getString("contnianzhong.boundLabelText"));		
        this.contnianzhong.setBoundLabelLength(100);		
        this.contnianzhong.setBoundLabelUnderline(true);		
        this.contnianzhong.setVisible(true);
        // contjidu		
        this.contjidu.setBoundLabelText(resHelper.getString("contjidu.boundLabelText"));		
        this.contjidu.setBoundLabelLength(100);		
        this.contjidu.setBoundLabelUnderline(true);		
        this.contjidu.setVisible(true);
        // contcomdabing		
        this.contcomdabing.setBoundLabelText(resHelper.getString("contcomdabing.boundLabelText"));		
        this.contcomdabing.setBoundLabelLength(100);		
        this.contcomdabing.setBoundLabelUnderline(true);		
        this.contcomdabing.setVisible(true);
        // contemptype		
        this.contemptype.setBoundLabelText(resHelper.getString("contemptype.boundLabelText"));		
        this.contemptype.setBoundLabelLength(100);		
        this.contemptype.setBoundLabelUnderline(true);		
        this.contemptype.setVisible(true);
        // contTPShouxufei		
        this.contTPShouxufei.setBoundLabelText(resHelper.getString("contTPShouxufei.boundLabelText"));		
        this.contTPShouxufei.setBoundLabelLength(100);		
        this.contTPShouxufei.setBoundLabelUnderline(true);		
        this.contTPShouxufei.setVisible(true);
        // contGATShouxufei		
        this.contGATShouxufei.setBoundLabelText(resHelper.getString("contGATShouxufei.boundLabelText"));		
        this.contGATShouxufei.setBoundLabelLength(100);		
        this.contGATShouxufei.setBoundLabelUnderline(true);		
        this.contGATShouxufei.setVisible(true);
        // contLWShouxufei		
        this.contLWShouxufei.setBoundLabelText(resHelper.getString("contLWShouxufei.boundLabelText"));		
        this.contLWShouxufei.setBoundLabelLength(100);		
        this.contLWShouxufei.setBoundLabelUnderline(true);		
        this.contLWShouxufei.setVisible(true);
        // contQTShouxufei		
        this.contQTShouxufei.setBoundLabelText(resHelper.getString("contQTShouxufei.boundLabelText"));		
        this.contQTShouxufei.setBoundLabelLength(100);		
        this.contQTShouxufei.setBoundLabelUnderline(true);		
        this.contQTShouxufei.setVisible(true);
        // contthiscity		
        this.contthiscity.setBoundLabelText(resHelper.getString("contthiscity.boundLabelText"));		
        this.contthiscity.setBoundLabelLength(100);		
        this.contthiscity.setBoundLabelUnderline(true);		
        this.contthiscity.setVisible(true);
        // contcom		
        this.contcom.setBoundLabelText(resHelper.getString("contcom.boundLabelText"));		
        this.contcom.setBoundLabelLength(100);		
        this.contcom.setBoundLabelUnderline(true);		
        this.contcom.setVisible(true);
        // contper		
        this.contper.setBoundLabelText(resHelper.getString("contper.boundLabelText"));		
        this.contper.setBoundLabelLength(100);		
        this.contper.setBoundLabelUnderline(true);		
        this.contper.setVisible(true);
        // contcost		
        this.contcost.setBoundLabelText(resHelper.getString("contcost.boundLabelText"));		
        this.contcost.setBoundLabelLength(100);		
        this.contcost.setBoundLabelUnderline(true);		
        this.contcost.setVisible(true);
        // contpost		
        this.contpost.setBoundLabelText(resHelper.getString("contpost.boundLabelText"));		
        this.contpost.setBoundLabelLength(100);		
        this.contpost.setBoundLabelUnderline(true);		
        this.contpost.setVisible(true);
        // contperDabing		
        this.contperDabing.setBoundLabelText(resHelper.getString("contperDabing.boundLabelText"));		
        this.contperDabing.setBoundLabelLength(100);		
        this.contperDabing.setBoundLabelUnderline(true);		
        this.contperDabing.setVisible(true);
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
        // txtcostCenterNumber		
        this.txtcostCenterNumber.setHorizontalAlignment(2);		
        this.txtcostCenterNumber.setMaxLength(100);		
        this.txtcostCenterNumber.setRequired(false);
        // txtpostTypeNumber		
        this.txtpostTypeNumber.setHorizontalAlignment(2);		
        this.txtpostTypeNumber.setMaxLength(100);		
        this.txtpostTypeNumber.setRequired(false);
        // txtiscount		
        this.txtiscount.setHorizontalAlignment(2);		
        this.txtiscount.setMaxLength(100);		
        this.txtiscount.setRequired(false);
        // txtbusinessdate		
        this.txtbusinessdate.setHorizontalAlignment(2);		
        this.txtbusinessdate.setMaxLength(100);		
        this.txtbusinessdate.setRequired(false);
        // txtjibengongzi		
        this.txtjibengongzi.setHorizontalAlignment(2);		
        this.txtjibengongzi.setDataType(1);		
        this.txtjibengongzi.setSupportedEmpty(true);		
        this.txtjibengongzi.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtjibengongzi.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtjibengongzi.setPrecision(10);		
        this.txtjibengongzi.setRequired(false);
        // txtqita		
        this.txtqita.setHorizontalAlignment(2);		
        this.txtqita.setDataType(1);		
        this.txtqita.setSupportedEmpty(true);		
        this.txtqita.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtqita.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtqita.setPrecision(10);		
        this.txtqita.setRequired(false);
        // txtgudingmoney		
        this.txtgudingmoney.setHorizontalAlignment(2);		
        this.txtgudingmoney.setDataType(1);		
        this.txtgudingmoney.setSupportedEmpty(true);		
        this.txtgudingmoney.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtgudingmoney.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtgudingmoney.setPrecision(10);		
        this.txtgudingmoney.setRequired(false);
        // txtbaodiMoney		
        this.txtbaodiMoney.setHorizontalAlignment(2);		
        this.txtbaodiMoney.setDataType(1);		
        this.txtbaodiMoney.setSupportedEmpty(true);		
        this.txtbaodiMoney.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtbaodiMoney.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtbaodiMoney.setPrecision(10);		
        this.txtbaodiMoney.setRequired(false);
        // txtfudongMoney		
        this.txtfudongMoney.setHorizontalAlignment(2);		
        this.txtfudongMoney.setDataType(1);		
        this.txtfudongMoney.setSupportedEmpty(true);		
        this.txtfudongMoney.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtfudongMoney.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtfudongMoney.setPrecision(10);		
        this.txtfudongMoney.setRequired(false);
        // txtbaodibuzu		
        this.txtbaodibuzu.setHorizontalAlignment(2);		
        this.txtbaodibuzu.setDataType(1);		
        this.txtbaodibuzu.setSupportedEmpty(true);		
        this.txtbaodibuzu.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtbaodibuzu.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtbaodibuzu.setPrecision(10);		
        this.txtbaodibuzu.setRequired(false);
        // txtjiangjinAll		
        this.txtjiangjinAll.setHorizontalAlignment(2);		
        this.txtjiangjinAll.setDataType(1);		
        this.txtjiangjinAll.setSupportedEmpty(true);		
        this.txtjiangjinAll.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtjiangjinAll.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtjiangjinAll.setPrecision(10);		
        this.txtjiangjinAll.setRequired(false);
        // txtyingfaMoney		
        this.txtyingfaMoney.setHorizontalAlignment(2);		
        this.txtyingfaMoney.setDataType(1);		
        this.txtyingfaMoney.setSupportedEmpty(true);		
        this.txtyingfaMoney.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtyingfaMoney.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtyingfaMoney.setPrecision(10);		
        this.txtyingfaMoney.setRequired(false);
        // txttiepiao		
        this.txttiepiao.setHorizontalAlignment(2);		
        this.txttiepiao.setDataType(1);		
        this.txttiepiao.setSupportedEmpty(true);		
        this.txttiepiao.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txttiepiao.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txttiepiao.setPrecision(10);		
        this.txttiepiao.setRequired(false);
        // txtguaiaitong		
        this.txtguaiaitong.setHorizontalAlignment(2);		
        this.txtguaiaitong.setDataType(1);		
        this.txtguaiaitong.setSupportedEmpty(true);		
        this.txtguaiaitong.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtguaiaitong.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtguaiaitong.setPrecision(10);		
        this.txtguaiaitong.setRequired(false);
        // txtlaowuMoney		
        this.txtlaowuMoney.setHorizontalAlignment(2);		
        this.txtlaowuMoney.setDataType(1);		
        this.txtlaowuMoney.setSupportedEmpty(true);		
        this.txtlaowuMoney.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtlaowuMoney.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtlaowuMoney.setPrecision(10);		
        this.txtlaowuMoney.setRequired(false);
        // txtqitamoshi		
        this.txtqitamoshi.setHorizontalAlignment(2);		
        this.txtqitamoshi.setDataType(1);		
        this.txtqitamoshi.setSupportedEmpty(true);		
        this.txtqitamoshi.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtqitamoshi.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtqitamoshi.setPrecision(10);		
        this.txtqitamoshi.setRequired(false);
        // txtyingshuiMoney		
        this.txtyingshuiMoney.setHorizontalAlignment(2);		
        this.txtyingshuiMoney.setDataType(1);		
        this.txtyingshuiMoney.setSupportedEmpty(true);		
        this.txtyingshuiMoney.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtyingshuiMoney.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtyingshuiMoney.setPrecision(10);		
        this.txtyingshuiMoney.setRequired(false);
        // txtshouxufei		
        this.txtshouxufei.setHorizontalAlignment(2);		
        this.txtshouxufei.setDataType(1);		
        this.txtshouxufei.setSupportedEmpty(true);		
        this.txtshouxufei.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtshouxufei.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtshouxufei.setPrecision(10);		
        this.txtshouxufei.setRequired(false);
        // txtcomyanglao		
        this.txtcomyanglao.setHorizontalAlignment(2);		
        this.txtcomyanglao.setDataType(1);		
        this.txtcomyanglao.setSupportedEmpty(true);		
        this.txtcomyanglao.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtcomyanglao.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtcomyanglao.setPrecision(10);		
        this.txtcomyanglao.setRequired(false);
        // txtcomyiliao		
        this.txtcomyiliao.setHorizontalAlignment(2);		
        this.txtcomyiliao.setDataType(1);		
        this.txtcomyiliao.setSupportedEmpty(true);		
        this.txtcomyiliao.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtcomyiliao.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtcomyiliao.setPrecision(10);		
        this.txtcomyiliao.setRequired(false);
        // txtcomshiye		
        this.txtcomshiye.setHorizontalAlignment(2);		
        this.txtcomshiye.setDataType(1);		
        this.txtcomshiye.setSupportedEmpty(true);		
        this.txtcomshiye.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtcomshiye.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtcomshiye.setPrecision(10);		
        this.txtcomshiye.setRequired(false);
        // txtcomgongshang		
        this.txtcomgongshang.setHorizontalAlignment(2);		
        this.txtcomgongshang.setDataType(1);		
        this.txtcomgongshang.setSupportedEmpty(true);		
        this.txtcomgongshang.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtcomgongshang.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtcomgongshang.setPrecision(10);		
        this.txtcomgongshang.setRequired(false);
        // txtcomshengyu		
        this.txtcomshengyu.setHorizontalAlignment(2);		
        this.txtcomshengyu.setDataType(1);		
        this.txtcomshengyu.setSupportedEmpty(true);		
        this.txtcomshengyu.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtcomshengyu.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtcomshengyu.setPrecision(10);		
        this.txtcomshengyu.setRequired(false);
        // txtcomgongjijin		
        this.txtcomgongjijin.setHorizontalAlignment(2);		
        this.txtcomgongjijin.setDataType(1);		
        this.txtcomgongjijin.setSupportedEmpty(true);		
        this.txtcomgongjijin.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtcomgongjijin.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtcomgongjijin.setPrecision(10);		
        this.txtcomgongjijin.setRequired(false);
        // txtfuwufei		
        this.txtfuwufei.setHorizontalAlignment(2);		
        this.txtfuwufei.setDataType(1);		
        this.txtfuwufei.setSupportedEmpty(true);		
        this.txtfuwufei.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtfuwufei.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtfuwufei.setPrecision(10);		
        this.txtfuwufei.setRequired(false);
        // txtshuijin		
        this.txtshuijin.setHorizontalAlignment(2);		
        this.txtshuijin.setDataType(1);		
        this.txtshuijin.setSupportedEmpty(true);		
        this.txtshuijin.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtshuijin.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtshuijin.setPrecision(10);		
        this.txtshuijin.setRequired(false);
        // txtcomshebaoAll		
        this.txtcomshebaoAll.setHorizontalAlignment(2);		
        this.txtcomshebaoAll.setDataType(1);		
        this.txtcomshebaoAll.setSupportedEmpty(true);		
        this.txtcomshebaoAll.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtcomshebaoAll.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtcomshebaoAll.setPrecision(10);		
        this.txtcomshebaoAll.setRequired(false);
        // txtmwMoney		
        this.txtmwMoney.setHorizontalAlignment(2);		
        this.txtmwMoney.setDataType(1);		
        this.txtmwMoney.setSupportedEmpty(true);		
        this.txtmwMoney.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtmwMoney.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtmwMoney.setPrecision(10);		
        this.txtmwMoney.setRequired(false);
        // txtshuihouqita		
        this.txtshuihouqita.setHorizontalAlignment(2);		
        this.txtshuihouqita.setDataType(1);		
        this.txtshuihouqita.setSupportedEmpty(true);		
        this.txtshuihouqita.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtshuihouqita.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtshuihouqita.setPrecision(10);		
        this.txtshuihouqita.setRequired(false);
        // txtjingjibuchang		
        this.txtjingjibuchang.setHorizontalAlignment(2);		
        this.txtjingjibuchang.setDataType(1);		
        this.txtjingjibuchang.setSupportedEmpty(true);		
        this.txtjingjibuchang.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtjingjibuchang.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtjingjibuchang.setPrecision(10);		
        this.txtjingjibuchang.setRequired(false);
        // txtyuefurenli		
        this.txtyuefurenli.setHorizontalAlignment(2);		
        this.txtyuefurenli.setDataType(1);		
        this.txtyuefurenli.setSupportedEmpty(true);		
        this.txtyuefurenli.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtyuefurenli.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtyuefurenli.setPrecision(10);		
        this.txtyuefurenli.setRequired(false);
        // txtyuedurenliAll		
        this.txtyuedurenliAll.setHorizontalAlignment(2);		
        this.txtyuedurenliAll.setDataType(1);		
        this.txtyuedurenliAll.setSupportedEmpty(true);		
        this.txtyuedurenliAll.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtyuedurenliAll.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtyuedurenliAll.setPrecision(10);		
        this.txtyuedurenliAll.setRequired(false);
        // txtperYanglao		
        this.txtperYanglao.setHorizontalAlignment(2);		
        this.txtperYanglao.setDataType(1);		
        this.txtperYanglao.setSupportedEmpty(true);		
        this.txtperYanglao.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtperYanglao.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtperYanglao.setPrecision(10);		
        this.txtperYanglao.setRequired(false);
        // txtperYiliao		
        this.txtperYiliao.setHorizontalAlignment(2);		
        this.txtperYiliao.setDataType(1);		
        this.txtperYiliao.setSupportedEmpty(true);		
        this.txtperYiliao.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtperYiliao.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtperYiliao.setPrecision(10);		
        this.txtperYiliao.setRequired(false);
        // txtperShiye		
        this.txtperShiye.setHorizontalAlignment(2);		
        this.txtperShiye.setDataType(1);		
        this.txtperShiye.setSupportedEmpty(true);		
        this.txtperShiye.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtperShiye.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtperShiye.setPrecision(10);		
        this.txtperShiye.setRequired(false);
        // txtperGongjijin		
        this.txtperGongjijin.setHorizontalAlignment(2);		
        this.txtperGongjijin.setDataType(1);		
        this.txtperGongjijin.setSupportedEmpty(true);		
        this.txtperGongjijin.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtperGongjijin.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtperGongjijin.setPrecision(10);		
        this.txtperGongjijin.setRequired(false);
        // txtgeshui		
        this.txtgeshui.setHorizontalAlignment(2);		
        this.txtgeshui.setDataType(1);		
        this.txtgeshui.setSupportedEmpty(true);		
        this.txtgeshui.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtgeshui.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtgeshui.setPrecision(10);		
        this.txtgeshui.setRequired(false);
        // txtshifa		
        this.txtshifa.setHorizontalAlignment(2);		
        this.txtshifa.setDataType(1);		
        this.txtshifa.setSupportedEmpty(true);		
        this.txtshifa.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtshifa.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtshifa.setPrecision(10);		
        this.txtshifa.setRequired(false);
        // txtnianzhongfentan		
        this.txtnianzhongfentan.setHorizontalAlignment(2);		
        this.txtnianzhongfentan.setDataType(1);		
        this.txtnianzhongfentan.setSupportedEmpty(true);		
        this.txtnianzhongfentan.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtnianzhongfentan.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtnianzhongfentan.setPrecision(10);		
        this.txtnianzhongfentan.setRequired(false);
        // txtjidufentan		
        this.txtjidufentan.setHorizontalAlignment(2);		
        this.txtjidufentan.setDataType(1);		
        this.txtjidufentan.setSupportedEmpty(true);		
        this.txtjidufentan.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtjidufentan.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtjidufentan.setPrecision(10);		
        this.txtjidufentan.setRequired(false);
        // txtnianzhong		
        this.txtnianzhong.setHorizontalAlignment(2);		
        this.txtnianzhong.setDataType(1);		
        this.txtnianzhong.setSupportedEmpty(true);		
        this.txtnianzhong.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtnianzhong.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtnianzhong.setPrecision(10);		
        this.txtnianzhong.setRequired(false);
        // txtjidu		
        this.txtjidu.setHorizontalAlignment(2);		
        this.txtjidu.setDataType(1);		
        this.txtjidu.setSupportedEmpty(true);		
        this.txtjidu.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtjidu.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtjidu.setPrecision(10);		
        this.txtjidu.setRequired(false);
        // txtcomdabing		
        this.txtcomdabing.setHorizontalAlignment(2);		
        this.txtcomdabing.setDataType(1);		
        this.txtcomdabing.setSupportedEmpty(true);		
        this.txtcomdabing.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtcomdabing.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtcomdabing.setPrecision(10);		
        this.txtcomdabing.setRequired(false);
        // txtemptype		
        this.txtemptype.setHorizontalAlignment(2);		
        this.txtemptype.setMaxLength(100);		
        this.txtemptype.setRequired(false);
        // txtTPShouxufei		
        this.txtTPShouxufei.setHorizontalAlignment(2);		
        this.txtTPShouxufei.setDataType(1);		
        this.txtTPShouxufei.setSupportedEmpty(true);		
        this.txtTPShouxufei.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtTPShouxufei.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtTPShouxufei.setPrecision(10);		
        this.txtTPShouxufei.setRequired(false);
        // txtGATShouxufei		
        this.txtGATShouxufei.setHorizontalAlignment(2);		
        this.txtGATShouxufei.setDataType(1);		
        this.txtGATShouxufei.setSupportedEmpty(true);		
        this.txtGATShouxufei.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtGATShouxufei.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtGATShouxufei.setPrecision(10);		
        this.txtGATShouxufei.setRequired(false);
        // txtLWShouxufei		
        this.txtLWShouxufei.setHorizontalAlignment(2);		
        this.txtLWShouxufei.setDataType(1);		
        this.txtLWShouxufei.setSupportedEmpty(true);		
        this.txtLWShouxufei.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtLWShouxufei.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtLWShouxufei.setPrecision(10);		
        this.txtLWShouxufei.setRequired(false);
        // txtQTShouxufei		
        this.txtQTShouxufei.setHorizontalAlignment(2);		
        this.txtQTShouxufei.setDataType(1);		
        this.txtQTShouxufei.setSupportedEmpty(true);		
        this.txtQTShouxufei.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtQTShouxufei.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtQTShouxufei.setPrecision(10);		
        this.txtQTShouxufei.setRequired(false);
        // prmtthiscity		
        this.prmtthiscity.setQueryInfo("com.kingdee.eas.basedata.org.app.CUQuery");		
        this.prmtthiscity.setEditable(true);		
        this.prmtthiscity.setDisplayFormat("$name$");		
        this.prmtthiscity.setEditFormat("$number$");		
        this.prmtthiscity.setCommitFormat("$number$");		
        this.prmtthiscity.setRequired(false);
        // prmtcom		
        this.prmtcom.setQueryInfo("com.kingdee.eas.basedata.org.app.CompanyOrgUnitQuery");		
        this.prmtcom.setEditable(true);		
        this.prmtcom.setDisplayFormat("$name$");		
        this.prmtcom.setEditFormat("$number$");		
        this.prmtcom.setCommitFormat("$number$");		
        this.prmtcom.setRequired(false);
        // prmtper		
        this.prmtper.setQueryInfo("com.kingdee.eas.basedata.person.app.PersonFilterQuery");		
        this.prmtper.setEditable(true);		
        this.prmtper.setDisplayFormat("$name$");		
        this.prmtper.setEditFormat("$number$");		
        this.prmtper.setCommitFormat("$number$");		
        this.prmtper.setRequired(false);
        // prmtcost		
        this.prmtcost.setQueryInfo("com.kingdee.eas.mw.srqr.app.CostCenterQuery");		
        this.prmtcost.setEditable(true);		
        this.prmtcost.setDisplayFormat("$name$");		
        this.prmtcost.setEditFormat("$number$");		
        this.prmtcost.setCommitFormat("$number$");		
        this.prmtcost.setRequired(false);
        // prmtpost		
        this.prmtpost.setQueryInfo("com.kingdee.eas.mw.srqr.app.PostTypeQuery");		
        this.prmtpost.setEditable(true);		
        this.prmtpost.setDisplayFormat("$name$");		
        this.prmtpost.setEditFormat("$number$");		
        this.prmtpost.setCommitFormat("$number$");		
        this.prmtpost.setRequired(false);
        // txtperDabing		
        this.txtperDabing.setHorizontalAlignment(2);		
        this.txtperDabing.setDataType(1);		
        this.txtperDabing.setSupportedEmpty(true);		
        this.txtperDabing.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtperDabing.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtperDabing.setPrecision(10);		
        this.txtperDabing.setRequired(false);
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {txtName,txtNumber,txtDescription,txtSimpleName,txtcostCenterNumber,txtpostTypeNumber,txtiscount,txtbusinessdate,txtjibengongzi,txtqita,txtgudingmoney,txtbaodiMoney,txtfudongMoney,txtbaodibuzu,txtjiangjinAll,txtyingfaMoney,txttiepiao,txtguaiaitong,txtlaowuMoney,txtqitamoshi,txtyingshuiMoney,txtshouxufei,txtcomyanglao,txtcomyiliao,txtcomshiye,txtcomgongshang,txtcomshengyu,txtcomgongjijin,txtfuwufei,txtshuijin,txtcomshebaoAll,txtmwMoney,txtshuihouqita,txtjingjibuchang,txtyuefurenli,txtyuedurenliAll,txtperYanglao,txtperYiliao,txtperShiye,txtperGongjijin,txtgeshui,txtshifa,txtnianzhongfentan,txtjidufentan,txtnianzhong,txtjidu,txtcomdabing,txtemptype,txtTPShouxufei,txtGATShouxufei,txtLWShouxufei,txtQTShouxufei,prmtthiscity,prmtcom,prmtper,prmtcost,prmtpost,txtperDabing}));
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
        this.setBounds(new Rectangle(0, 0, 1013, 509));
        this.setLayout(null);
        kDLabelContainer1.setBounds(new Rectangle(10, 10, 270, 19));
        this.add(kDLabelContainer1, null);
        kDLabelContainer2.setBounds(new Rectangle(341, 10, 270, 19));
        this.add(kDLabelContainer2, null);
        kDLabelContainer3.setBounds(new Rectangle(672, 10, 270, 19));
        this.add(kDLabelContainer3, null);
        kDLabelContainer4.setBounds(new Rectangle(10, 34, 270, 19));
        this.add(kDLabelContainer4, null);
        contcostCenterNumber.setBounds(new Rectangle(341, 58, 270, 19));
        this.add(contcostCenterNumber, null);
        contpostTypeNumber.setBounds(new Rectangle(672, 58, 270, 19));
        this.add(contpostTypeNumber, null);
        contiscount.setBounds(new Rectangle(10, 82, 270, 19));
        this.add(contiscount, null);
        contbusinessdate.setBounds(new Rectangle(341, 82, 270, 19));
        this.add(contbusinessdate, null);
        contjibengongzi.setBounds(new Rectangle(672, 82, 270, 19));
        this.add(contjibengongzi, null);
        contqita.setBounds(new Rectangle(10, 106, 270, 19));
        this.add(contqita, null);
        contgudingmoney.setBounds(new Rectangle(341, 106, 270, 19));
        this.add(contgudingmoney, null);
        contbaodiMoney.setBounds(new Rectangle(672, 106, 270, 19));
        this.add(contbaodiMoney, null);
        contfudongMoney.setBounds(new Rectangle(10, 130, 270, 19));
        this.add(contfudongMoney, null);
        contbaodibuzu.setBounds(new Rectangle(341, 130, 270, 19));
        this.add(contbaodibuzu, null);
        contjiangjinAll.setBounds(new Rectangle(672, 130, 270, 19));
        this.add(contjiangjinAll, null);
        contyingfaMoney.setBounds(new Rectangle(10, 154, 270, 19));
        this.add(contyingfaMoney, null);
        conttiepiao.setBounds(new Rectangle(341, 154, 270, 19));
        this.add(conttiepiao, null);
        contguaiaitong.setBounds(new Rectangle(672, 154, 270, 19));
        this.add(contguaiaitong, null);
        contlaowuMoney.setBounds(new Rectangle(10, 178, 270, 19));
        this.add(contlaowuMoney, null);
        contqitamoshi.setBounds(new Rectangle(341, 178, 270, 19));
        this.add(contqitamoshi, null);
        contyingshuiMoney.setBounds(new Rectangle(672, 178, 270, 19));
        this.add(contyingshuiMoney, null);
        contshouxufei.setBounds(new Rectangle(10, 202, 270, 19));
        this.add(contshouxufei, null);
        contcomyanglao.setBounds(new Rectangle(341, 202, 270, 19));
        this.add(contcomyanglao, null);
        contcomyiliao.setBounds(new Rectangle(672, 202, 270, 19));
        this.add(contcomyiliao, null);
        contcomshiye.setBounds(new Rectangle(10, 226, 270, 19));
        this.add(contcomshiye, null);
        contcomgongshang.setBounds(new Rectangle(341, 226, 270, 19));
        this.add(contcomgongshang, null);
        contcomshengyu.setBounds(new Rectangle(672, 226, 270, 19));
        this.add(contcomshengyu, null);
        contcomgongjijin.setBounds(new Rectangle(341, 250, 270, 19));
        this.add(contcomgongjijin, null);
        contfuwufei.setBounds(new Rectangle(672, 250, 270, 19));
        this.add(contfuwufei, null);
        contshuijin.setBounds(new Rectangle(10, 274, 270, 19));
        this.add(contshuijin, null);
        contcomshebaoAll.setBounds(new Rectangle(341, 274, 270, 19));
        this.add(contcomshebaoAll, null);
        contmwMoney.setBounds(new Rectangle(672, 274, 270, 19));
        this.add(contmwMoney, null);
        contshuihouqita.setBounds(new Rectangle(10, 298, 270, 19));
        this.add(contshuihouqita, null);
        contjingjibuchang.setBounds(new Rectangle(341, 298, 270, 19));
        this.add(contjingjibuchang, null);
        contyuefurenli.setBounds(new Rectangle(672, 298, 270, 19));
        this.add(contyuefurenli, null);
        contyuedurenliAll.setBounds(new Rectangle(10, 322, 270, 19));
        this.add(contyuedurenliAll, null);
        contperYanglao.setBounds(new Rectangle(341, 322, 270, 19));
        this.add(contperYanglao, null);
        contperYiliao.setBounds(new Rectangle(672, 322, 270, 19));
        this.add(contperYiliao, null);
        contperShiye.setBounds(new Rectangle(10, 346, 270, 19));
        this.add(contperShiye, null);
        contperGongjijin.setBounds(new Rectangle(341, 346, 270, 19));
        this.add(contperGongjijin, null);
        contgeshui.setBounds(new Rectangle(672, 346, 270, 19));
        this.add(contgeshui, null);
        contshifa.setBounds(new Rectangle(10, 370, 270, 19));
        this.add(contshifa, null);
        contnianzhongfentan.setBounds(new Rectangle(341, 370, 270, 19));
        this.add(contnianzhongfentan, null);
        contjidufentan.setBounds(new Rectangle(672, 370, 270, 19));
        this.add(contjidufentan, null);
        contnianzhong.setBounds(new Rectangle(10, 394, 270, 19));
        this.add(contnianzhong, null);
        contjidu.setBounds(new Rectangle(341, 394, 270, 19));
        this.add(contjidu, null);
        contcomdabing.setBounds(new Rectangle(10, 250, 270, 19));
        this.add(contcomdabing, null);
        contemptype.setBounds(new Rectangle(672, 394, 270, 19));
        this.add(contemptype, null);
        contTPShouxufei.setBounds(new Rectangle(10, 418, 270, 19));
        this.add(contTPShouxufei, null);
        contGATShouxufei.setBounds(new Rectangle(341, 418, 270, 19));
        this.add(contGATShouxufei, null);
        contLWShouxufei.setBounds(new Rectangle(672, 418, 270, 19));
        this.add(contLWShouxufei, null);
        contQTShouxufei.setBounds(new Rectangle(10, 442, 270, 19));
        this.add(contQTShouxufei, null);
        contthiscity.setBounds(new Rectangle(341, 34, 270, 19));
        this.add(contthiscity, null);
        contcom.setBounds(new Rectangle(672, 34, 270, 19));
        this.add(contcom, null);
        contper.setBounds(new Rectangle(10, 58, 270, 19));
        this.add(contper, null);
        contcost.setBounds(new Rectangle(341, 442, 270, 19));
        this.add(contcost, null);
        contpost.setBounds(new Rectangle(672, 442, 270, 19));
        this.add(contpost, null);
        contperDabing.setBounds(new Rectangle(10, 466, 270, 19));
        this.add(contperDabing, null);
        //kDLabelContainer1
        kDLabelContainer1.setBoundEditor(txtNumber);
        //kDLabelContainer2
        kDLabelContainer2.setBoundEditor(txtName);
        //kDLabelContainer3
        kDLabelContainer3.setBoundEditor(txtSimpleName);
        //kDLabelContainer4
        kDLabelContainer4.setBoundEditor(txtDescription);
        //contcostCenterNumber
        contcostCenterNumber.setBoundEditor(txtcostCenterNumber);
        //contpostTypeNumber
        contpostTypeNumber.setBoundEditor(txtpostTypeNumber);
        //contiscount
        contiscount.setBoundEditor(txtiscount);
        //contbusinessdate
        contbusinessdate.setBoundEditor(txtbusinessdate);
        //contjibengongzi
        contjibengongzi.setBoundEditor(txtjibengongzi);
        //contqita
        contqita.setBoundEditor(txtqita);
        //contgudingmoney
        contgudingmoney.setBoundEditor(txtgudingmoney);
        //contbaodiMoney
        contbaodiMoney.setBoundEditor(txtbaodiMoney);
        //contfudongMoney
        contfudongMoney.setBoundEditor(txtfudongMoney);
        //contbaodibuzu
        contbaodibuzu.setBoundEditor(txtbaodibuzu);
        //contjiangjinAll
        contjiangjinAll.setBoundEditor(txtjiangjinAll);
        //contyingfaMoney
        contyingfaMoney.setBoundEditor(txtyingfaMoney);
        //conttiepiao
        conttiepiao.setBoundEditor(txttiepiao);
        //contguaiaitong
        contguaiaitong.setBoundEditor(txtguaiaitong);
        //contlaowuMoney
        contlaowuMoney.setBoundEditor(txtlaowuMoney);
        //contqitamoshi
        contqitamoshi.setBoundEditor(txtqitamoshi);
        //contyingshuiMoney
        contyingshuiMoney.setBoundEditor(txtyingshuiMoney);
        //contshouxufei
        contshouxufei.setBoundEditor(txtshouxufei);
        //contcomyanglao
        contcomyanglao.setBoundEditor(txtcomyanglao);
        //contcomyiliao
        contcomyiliao.setBoundEditor(txtcomyiliao);
        //contcomshiye
        contcomshiye.setBoundEditor(txtcomshiye);
        //contcomgongshang
        contcomgongshang.setBoundEditor(txtcomgongshang);
        //contcomshengyu
        contcomshengyu.setBoundEditor(txtcomshengyu);
        //contcomgongjijin
        contcomgongjijin.setBoundEditor(txtcomgongjijin);
        //contfuwufei
        contfuwufei.setBoundEditor(txtfuwufei);
        //contshuijin
        contshuijin.setBoundEditor(txtshuijin);
        //contcomshebaoAll
        contcomshebaoAll.setBoundEditor(txtcomshebaoAll);
        //contmwMoney
        contmwMoney.setBoundEditor(txtmwMoney);
        //contshuihouqita
        contshuihouqita.setBoundEditor(txtshuihouqita);
        //contjingjibuchang
        contjingjibuchang.setBoundEditor(txtjingjibuchang);
        //contyuefurenli
        contyuefurenli.setBoundEditor(txtyuefurenli);
        //contyuedurenliAll
        contyuedurenliAll.setBoundEditor(txtyuedurenliAll);
        //contperYanglao
        contperYanglao.setBoundEditor(txtperYanglao);
        //contperYiliao
        contperYiliao.setBoundEditor(txtperYiliao);
        //contperShiye
        contperShiye.setBoundEditor(txtperShiye);
        //contperGongjijin
        contperGongjijin.setBoundEditor(txtperGongjijin);
        //contgeshui
        contgeshui.setBoundEditor(txtgeshui);
        //contshifa
        contshifa.setBoundEditor(txtshifa);
        //contnianzhongfentan
        contnianzhongfentan.setBoundEditor(txtnianzhongfentan);
        //contjidufentan
        contjidufentan.setBoundEditor(txtjidufentan);
        //contnianzhong
        contnianzhong.setBoundEditor(txtnianzhong);
        //contjidu
        contjidu.setBoundEditor(txtjidu);
        //contcomdabing
        contcomdabing.setBoundEditor(txtcomdabing);
        //contemptype
        contemptype.setBoundEditor(txtemptype);
        //contTPShouxufei
        contTPShouxufei.setBoundEditor(txtTPShouxufei);
        //contGATShouxufei
        contGATShouxufei.setBoundEditor(txtGATShouxufei);
        //contLWShouxufei
        contLWShouxufei.setBoundEditor(txtLWShouxufei);
        //contQTShouxufei
        contQTShouxufei.setBoundEditor(txtQTShouxufei);
        //contthiscity
        contthiscity.setBoundEditor(prmtthiscity);
        //contcom
        contcom.setBoundEditor(prmtcom);
        //contper
        contper.setBoundEditor(prmtper);
        //contcost
        contcost.setBoundEditor(prmtcost);
        //contpost
        contpost.setBoundEditor(prmtpost);
        //contperDabing
        contperDabing.setBoundEditor(txtperDabing);

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
		dataBinder.registerBinding("costCenterNumber", String.class, this.txtcostCenterNumber, "text");
		dataBinder.registerBinding("postTypeNumber", String.class, this.txtpostTypeNumber, "text");
		dataBinder.registerBinding("iscount", String.class, this.txtiscount, "text");
		dataBinder.registerBinding("businessdate", String.class, this.txtbusinessdate, "text");
		dataBinder.registerBinding("jibengongzi", java.math.BigDecimal.class, this.txtjibengongzi, "value");
		dataBinder.registerBinding("qita", java.math.BigDecimal.class, this.txtqita, "value");
		dataBinder.registerBinding("gudingmoney", java.math.BigDecimal.class, this.txtgudingmoney, "value");
		dataBinder.registerBinding("baodiMoney", java.math.BigDecimal.class, this.txtbaodiMoney, "value");
		dataBinder.registerBinding("fudongMoney", java.math.BigDecimal.class, this.txtfudongMoney, "value");
		dataBinder.registerBinding("baodibuzu", java.math.BigDecimal.class, this.txtbaodibuzu, "value");
		dataBinder.registerBinding("jiangjinAll", java.math.BigDecimal.class, this.txtjiangjinAll, "value");
		dataBinder.registerBinding("yingfaMoney", java.math.BigDecimal.class, this.txtyingfaMoney, "value");
		dataBinder.registerBinding("tiepiao", java.math.BigDecimal.class, this.txttiepiao, "value");
		dataBinder.registerBinding("guaiaitong", java.math.BigDecimal.class, this.txtguaiaitong, "value");
		dataBinder.registerBinding("laowuMoney", java.math.BigDecimal.class, this.txtlaowuMoney, "value");
		dataBinder.registerBinding("qitamoshi", java.math.BigDecimal.class, this.txtqitamoshi, "value");
		dataBinder.registerBinding("yingshuiMoney", java.math.BigDecimal.class, this.txtyingshuiMoney, "value");
		dataBinder.registerBinding("shouxufei", java.math.BigDecimal.class, this.txtshouxufei, "value");
		dataBinder.registerBinding("comyanglao", java.math.BigDecimal.class, this.txtcomyanglao, "value");
		dataBinder.registerBinding("comyiliao", java.math.BigDecimal.class, this.txtcomyiliao, "value");
		dataBinder.registerBinding("comshiye", java.math.BigDecimal.class, this.txtcomshiye, "value");
		dataBinder.registerBinding("comgongshang", java.math.BigDecimal.class, this.txtcomgongshang, "value");
		dataBinder.registerBinding("comshengyu", java.math.BigDecimal.class, this.txtcomshengyu, "value");
		dataBinder.registerBinding("comgongjijin", java.math.BigDecimal.class, this.txtcomgongjijin, "value");
		dataBinder.registerBinding("fuwufei", java.math.BigDecimal.class, this.txtfuwufei, "value");
		dataBinder.registerBinding("shuijin", java.math.BigDecimal.class, this.txtshuijin, "value");
		dataBinder.registerBinding("comshebaoAll", java.math.BigDecimal.class, this.txtcomshebaoAll, "value");
		dataBinder.registerBinding("mwMoney", java.math.BigDecimal.class, this.txtmwMoney, "value");
		dataBinder.registerBinding("shuihouqita", java.math.BigDecimal.class, this.txtshuihouqita, "value");
		dataBinder.registerBinding("jingjibuchang", java.math.BigDecimal.class, this.txtjingjibuchang, "value");
		dataBinder.registerBinding("yuefurenli", java.math.BigDecimal.class, this.txtyuefurenli, "value");
		dataBinder.registerBinding("yuedurenliAll", java.math.BigDecimal.class, this.txtyuedurenliAll, "value");
		dataBinder.registerBinding("perYanglao", java.math.BigDecimal.class, this.txtperYanglao, "value");
		dataBinder.registerBinding("perYiliao", java.math.BigDecimal.class, this.txtperYiliao, "value");
		dataBinder.registerBinding("perShiye", java.math.BigDecimal.class, this.txtperShiye, "value");
		dataBinder.registerBinding("perGongjijin", java.math.BigDecimal.class, this.txtperGongjijin, "value");
		dataBinder.registerBinding("geshui", java.math.BigDecimal.class, this.txtgeshui, "value");
		dataBinder.registerBinding("shifa", java.math.BigDecimal.class, this.txtshifa, "value");
		dataBinder.registerBinding("nianzhongfentan", java.math.BigDecimal.class, this.txtnianzhongfentan, "value");
		dataBinder.registerBinding("jidufentan", java.math.BigDecimal.class, this.txtjidufentan, "value");
		dataBinder.registerBinding("nianzhong", java.math.BigDecimal.class, this.txtnianzhong, "value");
		dataBinder.registerBinding("jidu", java.math.BigDecimal.class, this.txtjidu, "value");
		dataBinder.registerBinding("comdabing", java.math.BigDecimal.class, this.txtcomdabing, "value");
		dataBinder.registerBinding("emptype", String.class, this.txtemptype, "text");
		dataBinder.registerBinding("TPShouxufei", java.math.BigDecimal.class, this.txtTPShouxufei, "value");
		dataBinder.registerBinding("GATShouxufei", java.math.BigDecimal.class, this.txtGATShouxufei, "value");
		dataBinder.registerBinding("LWShouxufei", java.math.BigDecimal.class, this.txtLWShouxufei, "value");
		dataBinder.registerBinding("QTShouxufei", java.math.BigDecimal.class, this.txtQTShouxufei, "value");
		dataBinder.registerBinding("thiscity", com.kingdee.eas.basedata.org.CtrlUnitInfo.class, this.prmtthiscity, "data");
		dataBinder.registerBinding("com", com.kingdee.eas.basedata.org.CompanyOrgUnitInfo.class, this.prmtcom, "data");
		dataBinder.registerBinding("per", com.kingdee.eas.basedata.person.PersonInfo.class, this.prmtper, "data");
		dataBinder.registerBinding("cost", com.kingdee.eas.mw.srqr.CostCenterInfo.class, this.prmtcost, "data");
		dataBinder.registerBinding("post", com.kingdee.eas.mw.srqr.PostTypeInfo.class, this.prmtpost, "data");
		dataBinder.registerBinding("perDabing", java.math.BigDecimal.class, this.txtperDabing, "value");		
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
	    return "com.kingdee.eas.mw.pay.app.PayShareDetailEditUIHandler";
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
        this.editData = (com.kingdee.eas.mw.pay.PayShareDetailInfo)ov;
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
		getValidateHelper().registerBindProperty("costCenterNumber", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("postTypeNumber", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("iscount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("businessdate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("jibengongzi", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("qita", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("gudingmoney", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("baodiMoney", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("fudongMoney", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("baodibuzu", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("jiangjinAll", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("yingfaMoney", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("tiepiao", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("guaiaitong", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("laowuMoney", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("qitamoshi", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("yingshuiMoney", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("shouxufei", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("comyanglao", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("comyiliao", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("comshiye", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("comgongshang", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("comshengyu", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("comgongjijin", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("fuwufei", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("shuijin", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("comshebaoAll", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("mwMoney", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("shuihouqita", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("jingjibuchang", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("yuefurenli", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("yuedurenliAll", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("perYanglao", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("perYiliao", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("perShiye", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("perGongjijin", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("geshui", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("shifa", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("nianzhongfentan", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("jidufentan", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("nianzhong", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("jidu", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("comdabing", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("emptype", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("TPShouxufei", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("GATShouxufei", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("LWShouxufei", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("QTShouxufei", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("thiscity", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("com", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("per", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("cost", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("post", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("perDabing", ValidateHelper.ON_SAVE);    		
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
        sic.add(new SelectorItemInfo("costCenterNumber"));
        sic.add(new SelectorItemInfo("postTypeNumber"));
        sic.add(new SelectorItemInfo("iscount"));
        sic.add(new SelectorItemInfo("businessdate"));
        sic.add(new SelectorItemInfo("jibengongzi"));
        sic.add(new SelectorItemInfo("qita"));
        sic.add(new SelectorItemInfo("gudingmoney"));
        sic.add(new SelectorItemInfo("baodiMoney"));
        sic.add(new SelectorItemInfo("fudongMoney"));
        sic.add(new SelectorItemInfo("baodibuzu"));
        sic.add(new SelectorItemInfo("jiangjinAll"));
        sic.add(new SelectorItemInfo("yingfaMoney"));
        sic.add(new SelectorItemInfo("tiepiao"));
        sic.add(new SelectorItemInfo("guaiaitong"));
        sic.add(new SelectorItemInfo("laowuMoney"));
        sic.add(new SelectorItemInfo("qitamoshi"));
        sic.add(new SelectorItemInfo("yingshuiMoney"));
        sic.add(new SelectorItemInfo("shouxufei"));
        sic.add(new SelectorItemInfo("comyanglao"));
        sic.add(new SelectorItemInfo("comyiliao"));
        sic.add(new SelectorItemInfo("comshiye"));
        sic.add(new SelectorItemInfo("comgongshang"));
        sic.add(new SelectorItemInfo("comshengyu"));
        sic.add(new SelectorItemInfo("comgongjijin"));
        sic.add(new SelectorItemInfo("fuwufei"));
        sic.add(new SelectorItemInfo("shuijin"));
        sic.add(new SelectorItemInfo("comshebaoAll"));
        sic.add(new SelectorItemInfo("mwMoney"));
        sic.add(new SelectorItemInfo("shuihouqita"));
        sic.add(new SelectorItemInfo("jingjibuchang"));
        sic.add(new SelectorItemInfo("yuefurenli"));
        sic.add(new SelectorItemInfo("yuedurenliAll"));
        sic.add(new SelectorItemInfo("perYanglao"));
        sic.add(new SelectorItemInfo("perYiliao"));
        sic.add(new SelectorItemInfo("perShiye"));
        sic.add(new SelectorItemInfo("perGongjijin"));
        sic.add(new SelectorItemInfo("geshui"));
        sic.add(new SelectorItemInfo("shifa"));
        sic.add(new SelectorItemInfo("nianzhongfentan"));
        sic.add(new SelectorItemInfo("jidufentan"));
        sic.add(new SelectorItemInfo("nianzhong"));
        sic.add(new SelectorItemInfo("jidu"));
        sic.add(new SelectorItemInfo("comdabing"));
        sic.add(new SelectorItemInfo("emptype"));
        sic.add(new SelectorItemInfo("TPShouxufei"));
        sic.add(new SelectorItemInfo("GATShouxufei"));
        sic.add(new SelectorItemInfo("LWShouxufei"));
        sic.add(new SelectorItemInfo("QTShouxufei"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("thiscity.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("thiscity.id"));
        	sic.add(new SelectorItemInfo("thiscity.number"));
        	sic.add(new SelectorItemInfo("thiscity.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("com.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("com.id"));
        	sic.add(new SelectorItemInfo("com.number"));
        	sic.add(new SelectorItemInfo("com.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("per.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("per.id"));
        	sic.add(new SelectorItemInfo("per.number"));
        	sic.add(new SelectorItemInfo("per.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("cost.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("cost.id"));
        	sic.add(new SelectorItemInfo("cost.number"));
        	sic.add(new SelectorItemInfo("cost.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("post.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("post.id"));
        	sic.add(new SelectorItemInfo("post.number"));
        	sic.add(new SelectorItemInfo("post.name"));
		}
        sic.add(new SelectorItemInfo("perDabing"));
        return sic;
    }        

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.mw.pay.client", "PayShareDetailEditUI");
    }

    /**
     * output getEditUIName method
     */
    protected String getEditUIName()
    {
        return com.kingdee.eas.mw.pay.client.PayShareDetailEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.mw.pay.PayShareDetailFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.mw.pay.PayShareDetailInfo objectValue = new com.kingdee.eas.mw.pay.PayShareDetailInfo();
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