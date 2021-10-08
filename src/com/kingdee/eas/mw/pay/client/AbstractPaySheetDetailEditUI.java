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
public abstract class AbstractPaySheetDetailEditUI extends com.kingdee.eas.framework.client.EditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractPaySheetDetailEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer2;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer3;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer4;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcityid;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcompanyid;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contpersonid;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcostCenterNumber;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contpostTypeNumber;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contiscount;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbusinessdate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contjibengongzi;
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
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contperYanglao;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contperYiliao;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contperShiye;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contperGongjijin;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contgeshui;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contshifa;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcomdabing;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contemptype;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcityNumber;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcityName;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcompanyNumber;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcompanyName;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contpersonNumber;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contpersonName;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contpost;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contpostType;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contindate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contleaveDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contworkYear;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbingjiaPro;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcardNumber;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contpostAllow;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contworkYearAllow;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contlearnAllow;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcardAllow;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conthouseAllow;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contachieveMoney;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contmonthMoney;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contqueqin;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contshijia;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbingjia;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contkaoqinSub;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contchidaoSub;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contgdAllow;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contallWorkAllow;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfoodAllow;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contaddWorkAllow;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contother;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contgdMoney;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contXRayAllow;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contholderMoney;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contassMoney;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contzbPro;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contshopHelp;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contzxCard;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsplitUp;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contzxLeave;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contdocLeave;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contotherWaiMoney;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contwaiAllMoney;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contmarktMoney;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contscalMoney;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contmbAmount;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contdocAmount;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contkfAmount;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conthlAmount;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contzxAmount;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contshopTarMoney;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contotherNeiMoney;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbdProjectAll;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contmonthBase;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbdMonthProject;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contpayble;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contachieveAll;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contseaBase;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contseaBuzu;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contshouldPay;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contrealShouldPay;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contperDaBing;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contperAll;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbeforeTaxMoney;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfreeTaxMoney;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contljyssde;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contgrzxkcAmount;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contyssde;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conttax;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsjkcs;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contljgrsds;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contdkgrsds;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contmwBase;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contdianpingSub;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contkfSub;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contpayUp;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbuchangAmount;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contjifenAll;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conttiepiaoSer;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contguanaitongSer;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contotherSer;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contserviceAll;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contshouldYearBouns;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contyearTax;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contrealyearAmount;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contrealAmount;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contshuijin;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcomAll;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contLC;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbasemoney;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfentanother;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contnianzhongfentan;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contjidufentan;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contnianzhong;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contjidu;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contyuedurenliAll;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contdocAssCost;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contclinicAchiMoney;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contassToDoc;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contBaoDiBonus;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox txtName;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtSimpleName;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox txtDescription;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtcityid;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtcompanyid;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtpersonid;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtcostCenterNumber;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtpostTypeNumber;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtiscount;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtbusinessdate;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtjibengongzi;
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
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtperYanglao;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtperYiliao;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtperShiye;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtperGongjijin;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtgeshui;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtshifa;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtcomdabing;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtemptype;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtcityNumber;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtcityName;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtcompanyNumber;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtcompanyName;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtpersonNumber;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtpersonName;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtpost;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtpostType;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtindate;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtleaveDate;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtworkYear;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtbingjiaPro;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtcardNumber;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtpostAllow;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtworkYearAllow;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtlearnAllow;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtcardAllow;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txthouseAllow;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtachieveMoney;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtmonthMoney;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtqueqin;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtshijia;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtbingjia;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtkaoqinSub;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtchidaoSub;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtgdAllow;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtallWorkAllow;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtfoodAllow;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtaddWorkAllow;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtother;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtgdMoney;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtXRayAllow;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtholderMoney;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtassMoney;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtzbPro;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtshopHelp;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtzxCard;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtsplitUp;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtzxLeave;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtdocLeave;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtotherWaiMoney;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtwaiAllMoney;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtmarktMoney;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtscalMoney;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtmbAmount;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtdocAmount;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtkfAmount;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txthlAmount;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtzxAmount;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtshopTarMoney;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtotherNeiMoney;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtbdProjectAll;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtmonthBase;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtbdMonthProject;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtpayble;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtachieveAll;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtseaBase;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtseaBuzu;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtshouldPay;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtrealShouldPay;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtperDaBing;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtperAll;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtbeforeTaxMoney;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtfreeTaxMoney;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtljyssde;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtgrzxkcAmount;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtyssde;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txttax;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtsjkcs;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtljgrsds;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtdkgrsds;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtmwBase;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtdianpingSub;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtkfSub;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtpayUp;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtbuchangAmount;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtjifenAll;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txttiepiaoSer;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtguanaitongSer;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtotherSer;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtserviceAll;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtshouldYearBouns;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtyearTax;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtrealyearAmount;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtrealAmount;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtshuijin;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtcomAll;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtLC;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtbasemoney;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtfentanother;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtnianzhongfentan;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtjidufentan;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtnianzhong;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtjidu;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtyuedurenliAll;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtdocAssCost;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtclinicAchiMoney;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtassToDoc;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtBaoDiBonus;
    protected com.kingdee.eas.mw.pay.PaySheetDetailInfo editData = null;
    /**
     * output class constructor
     */
    public AbstractPaySheetDetailEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractPaySheetDetailEditUI.class.getName());
        this.setUITitle(resHelper.getString("this.title"));
        this.kDLabelContainer1 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer2 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer3 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer4 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcityid = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcompanyid = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contpersonid = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcostCenterNumber = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contpostTypeNumber = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contiscount = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbusinessdate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contjibengongzi = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
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
        this.contperYanglao = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contperYiliao = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contperShiye = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contperGongjijin = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contgeshui = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contshifa = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcomdabing = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contemptype = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcityNumber = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcityName = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcompanyNumber = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcompanyName = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contpersonNumber = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contpersonName = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contpost = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contpostType = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contindate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contleaveDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contworkYear = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbingjiaPro = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcardNumber = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contpostAllow = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contworkYearAllow = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contlearnAllow = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcardAllow = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conthouseAllow = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contachieveMoney = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contmonthMoney = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contqueqin = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contshijia = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbingjia = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contkaoqinSub = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contchidaoSub = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contgdAllow = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contallWorkAllow = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfoodAllow = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contaddWorkAllow = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contother = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contgdMoney = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contXRayAllow = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contholderMoney = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contassMoney = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contzbPro = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contshopHelp = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contzxCard = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contsplitUp = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contzxLeave = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contdocLeave = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contotherWaiMoney = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contwaiAllMoney = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contmarktMoney = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contscalMoney = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contmbAmount = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contdocAmount = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contkfAmount = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conthlAmount = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contzxAmount = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contshopTarMoney = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contotherNeiMoney = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbdProjectAll = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contmonthBase = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbdMonthProject = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contpayble = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contachieveAll = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contseaBase = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contseaBuzu = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contshouldPay = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contrealShouldPay = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contperDaBing = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contperAll = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbeforeTaxMoney = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfreeTaxMoney = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contljyssde = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contgrzxkcAmount = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contyssde = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conttax = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contsjkcs = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contljgrsds = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contdkgrsds = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contmwBase = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contdianpingSub = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contkfSub = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contpayUp = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbuchangAmount = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contjifenAll = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conttiepiaoSer = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contguanaitongSer = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contotherSer = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contserviceAll = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contshouldYearBouns = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contyearTax = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contrealyearAmount = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contrealAmount = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contshuijin = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcomAll = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contLC = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbasemoney = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfentanother = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contnianzhongfentan = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contjidufentan = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contnianzhong = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contjidu = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contyuedurenliAll = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contdocAssCost = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contclinicAchiMoney = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contassToDoc = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contBaoDiBonus = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtName = new com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox();
        this.txtSimpleName = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtDescription = new com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox();
        this.txtcityid = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtcompanyid = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtpersonid = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtcostCenterNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtpostTypeNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtiscount = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtbusinessdate = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtjibengongzi = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
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
        this.txtperYanglao = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtperYiliao = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtperShiye = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtperGongjijin = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtgeshui = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtshifa = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtcomdabing = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtemptype = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtcityNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtcityName = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtcompanyNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtcompanyName = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtpersonNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtpersonName = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtpost = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtpostType = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtindate = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtleaveDate = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtworkYear = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtbingjiaPro = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtcardNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtpostAllow = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtworkYearAllow = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtlearnAllow = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtcardAllow = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txthouseAllow = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtachieveMoney = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtmonthMoney = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtqueqin = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtshijia = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtbingjia = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtkaoqinSub = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtchidaoSub = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtgdAllow = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtallWorkAllow = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtfoodAllow = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtaddWorkAllow = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtother = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtgdMoney = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtXRayAllow = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtholderMoney = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtassMoney = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtzbPro = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtshopHelp = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtzxCard = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtsplitUp = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtzxLeave = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtdocLeave = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtotherWaiMoney = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtwaiAllMoney = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtmarktMoney = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtscalMoney = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtmbAmount = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtdocAmount = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtkfAmount = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txthlAmount = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtzxAmount = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtshopTarMoney = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtotherNeiMoney = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtbdProjectAll = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtmonthBase = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtbdMonthProject = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtpayble = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtachieveAll = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtseaBase = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtseaBuzu = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtshouldPay = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtrealShouldPay = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtperDaBing = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtperAll = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtbeforeTaxMoney = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtfreeTaxMoney = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtljyssde = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtgrzxkcAmount = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtyssde = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txttax = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtsjkcs = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtljgrsds = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtdkgrsds = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtmwBase = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtdianpingSub = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtkfSub = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtpayUp = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtbuchangAmount = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtjifenAll = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txttiepiaoSer = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtguanaitongSer = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtotherSer = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtserviceAll = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtshouldYearBouns = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtyearTax = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtrealyearAmount = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtrealAmount = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtshuijin = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtcomAll = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtLC = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtbasemoney = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtfentanother = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtnianzhongfentan = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtjidufentan = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtnianzhong = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtjidu = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtyuedurenliAll = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtdocAssCost = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtclinicAchiMoney = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtassToDoc = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtBaoDiBonus = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.kDLabelContainer1.setName("kDLabelContainer1");
        this.kDLabelContainer2.setName("kDLabelContainer2");
        this.kDLabelContainer3.setName("kDLabelContainer3");
        this.kDLabelContainer4.setName("kDLabelContainer4");
        this.contcityid.setName("contcityid");
        this.contcompanyid.setName("contcompanyid");
        this.contpersonid.setName("contpersonid");
        this.contcostCenterNumber.setName("contcostCenterNumber");
        this.contpostTypeNumber.setName("contpostTypeNumber");
        this.contiscount.setName("contiscount");
        this.contbusinessdate.setName("contbusinessdate");
        this.contjibengongzi.setName("contjibengongzi");
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
        this.contperYanglao.setName("contperYanglao");
        this.contperYiliao.setName("contperYiliao");
        this.contperShiye.setName("contperShiye");
        this.contperGongjijin.setName("contperGongjijin");
        this.contgeshui.setName("contgeshui");
        this.contshifa.setName("contshifa");
        this.contcomdabing.setName("contcomdabing");
        this.contemptype.setName("contemptype");
        this.contcityNumber.setName("contcityNumber");
        this.contcityName.setName("contcityName");
        this.contcompanyNumber.setName("contcompanyNumber");
        this.contcompanyName.setName("contcompanyName");
        this.contpersonNumber.setName("contpersonNumber");
        this.contpersonName.setName("contpersonName");
        this.contpost.setName("contpost");
        this.contpostType.setName("contpostType");
        this.contindate.setName("contindate");
        this.contleaveDate.setName("contleaveDate");
        this.contworkYear.setName("contworkYear");
        this.contbingjiaPro.setName("contbingjiaPro");
        this.contcardNumber.setName("contcardNumber");
        this.contpostAllow.setName("contpostAllow");
        this.contworkYearAllow.setName("contworkYearAllow");
        this.contlearnAllow.setName("contlearnAllow");
        this.contcardAllow.setName("contcardAllow");
        this.conthouseAllow.setName("conthouseAllow");
        this.contachieveMoney.setName("contachieveMoney");
        this.contmonthMoney.setName("contmonthMoney");
        this.contqueqin.setName("contqueqin");
        this.contshijia.setName("contshijia");
        this.contbingjia.setName("contbingjia");
        this.contkaoqinSub.setName("contkaoqinSub");
        this.contchidaoSub.setName("contchidaoSub");
        this.contgdAllow.setName("contgdAllow");
        this.contallWorkAllow.setName("contallWorkAllow");
        this.contfoodAllow.setName("contfoodAllow");
        this.contaddWorkAllow.setName("contaddWorkAllow");
        this.contother.setName("contother");
        this.contgdMoney.setName("contgdMoney");
        this.contXRayAllow.setName("contXRayAllow");
        this.contholderMoney.setName("contholderMoney");
        this.contassMoney.setName("contassMoney");
        this.contzbPro.setName("contzbPro");
        this.contshopHelp.setName("contshopHelp");
        this.contzxCard.setName("contzxCard");
        this.contsplitUp.setName("contsplitUp");
        this.contzxLeave.setName("contzxLeave");
        this.contdocLeave.setName("contdocLeave");
        this.contotherWaiMoney.setName("contotherWaiMoney");
        this.contwaiAllMoney.setName("contwaiAllMoney");
        this.contmarktMoney.setName("contmarktMoney");
        this.contscalMoney.setName("contscalMoney");
        this.contmbAmount.setName("contmbAmount");
        this.contdocAmount.setName("contdocAmount");
        this.contkfAmount.setName("contkfAmount");
        this.conthlAmount.setName("conthlAmount");
        this.contzxAmount.setName("contzxAmount");
        this.contshopTarMoney.setName("contshopTarMoney");
        this.contotherNeiMoney.setName("contotherNeiMoney");
        this.contbdProjectAll.setName("contbdProjectAll");
        this.contmonthBase.setName("contmonthBase");
        this.contbdMonthProject.setName("contbdMonthProject");
        this.contpayble.setName("contpayble");
        this.contachieveAll.setName("contachieveAll");
        this.contseaBase.setName("contseaBase");
        this.contseaBuzu.setName("contseaBuzu");
        this.contshouldPay.setName("contshouldPay");
        this.contrealShouldPay.setName("contrealShouldPay");
        this.contperDaBing.setName("contperDaBing");
        this.contperAll.setName("contperAll");
        this.contbeforeTaxMoney.setName("contbeforeTaxMoney");
        this.contfreeTaxMoney.setName("contfreeTaxMoney");
        this.contljyssde.setName("contljyssde");
        this.contgrzxkcAmount.setName("contgrzxkcAmount");
        this.contyssde.setName("contyssde");
        this.conttax.setName("conttax");
        this.contsjkcs.setName("contsjkcs");
        this.contljgrsds.setName("contljgrsds");
        this.contdkgrsds.setName("contdkgrsds");
        this.contmwBase.setName("contmwBase");
        this.contdianpingSub.setName("contdianpingSub");
        this.contkfSub.setName("contkfSub");
        this.contpayUp.setName("contpayUp");
        this.contbuchangAmount.setName("contbuchangAmount");
        this.contjifenAll.setName("contjifenAll");
        this.conttiepiaoSer.setName("conttiepiaoSer");
        this.contguanaitongSer.setName("contguanaitongSer");
        this.contotherSer.setName("contotherSer");
        this.contserviceAll.setName("contserviceAll");
        this.contshouldYearBouns.setName("contshouldYearBouns");
        this.contyearTax.setName("contyearTax");
        this.contrealyearAmount.setName("contrealyearAmount");
        this.contrealAmount.setName("contrealAmount");
        this.contshuijin.setName("contshuijin");
        this.contcomAll.setName("contcomAll");
        this.contLC.setName("contLC");
        this.contbasemoney.setName("contbasemoney");
        this.contfentanother.setName("contfentanother");
        this.contnianzhongfentan.setName("contnianzhongfentan");
        this.contjidufentan.setName("contjidufentan");
        this.contnianzhong.setName("contnianzhong");
        this.contjidu.setName("contjidu");
        this.contyuedurenliAll.setName("contyuedurenliAll");
        this.contdocAssCost.setName("contdocAssCost");
        this.contclinicAchiMoney.setName("contclinicAchiMoney");
        this.contassToDoc.setName("contassToDoc");
        this.contBaoDiBonus.setName("contBaoDiBonus");
        this.txtNumber.setName("txtNumber");
        this.txtName.setName("txtName");
        this.txtSimpleName.setName("txtSimpleName");
        this.txtDescription.setName("txtDescription");
        this.txtcityid.setName("txtcityid");
        this.txtcompanyid.setName("txtcompanyid");
        this.txtpersonid.setName("txtpersonid");
        this.txtcostCenterNumber.setName("txtcostCenterNumber");
        this.txtpostTypeNumber.setName("txtpostTypeNumber");
        this.txtiscount.setName("txtiscount");
        this.txtbusinessdate.setName("txtbusinessdate");
        this.txtjibengongzi.setName("txtjibengongzi");
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
        this.txtperYanglao.setName("txtperYanglao");
        this.txtperYiliao.setName("txtperYiliao");
        this.txtperShiye.setName("txtperShiye");
        this.txtperGongjijin.setName("txtperGongjijin");
        this.txtgeshui.setName("txtgeshui");
        this.txtshifa.setName("txtshifa");
        this.txtcomdabing.setName("txtcomdabing");
        this.txtemptype.setName("txtemptype");
        this.txtcityNumber.setName("txtcityNumber");
        this.txtcityName.setName("txtcityName");
        this.txtcompanyNumber.setName("txtcompanyNumber");
        this.txtcompanyName.setName("txtcompanyName");
        this.txtpersonNumber.setName("txtpersonNumber");
        this.txtpersonName.setName("txtpersonName");
        this.txtpost.setName("txtpost");
        this.txtpostType.setName("txtpostType");
        this.txtindate.setName("txtindate");
        this.txtleaveDate.setName("txtleaveDate");
        this.txtworkYear.setName("txtworkYear");
        this.txtbingjiaPro.setName("txtbingjiaPro");
        this.txtcardNumber.setName("txtcardNumber");
        this.txtpostAllow.setName("txtpostAllow");
        this.txtworkYearAllow.setName("txtworkYearAllow");
        this.txtlearnAllow.setName("txtlearnAllow");
        this.txtcardAllow.setName("txtcardAllow");
        this.txthouseAllow.setName("txthouseAllow");
        this.txtachieveMoney.setName("txtachieveMoney");
        this.txtmonthMoney.setName("txtmonthMoney");
        this.txtqueqin.setName("txtqueqin");
        this.txtshijia.setName("txtshijia");
        this.txtbingjia.setName("txtbingjia");
        this.txtkaoqinSub.setName("txtkaoqinSub");
        this.txtchidaoSub.setName("txtchidaoSub");
        this.txtgdAllow.setName("txtgdAllow");
        this.txtallWorkAllow.setName("txtallWorkAllow");
        this.txtfoodAllow.setName("txtfoodAllow");
        this.txtaddWorkAllow.setName("txtaddWorkAllow");
        this.txtother.setName("txtother");
        this.txtgdMoney.setName("txtgdMoney");
        this.txtXRayAllow.setName("txtXRayAllow");
        this.txtholderMoney.setName("txtholderMoney");
        this.txtassMoney.setName("txtassMoney");
        this.txtzbPro.setName("txtzbPro");
        this.txtshopHelp.setName("txtshopHelp");
        this.txtzxCard.setName("txtzxCard");
        this.txtsplitUp.setName("txtsplitUp");
        this.txtzxLeave.setName("txtzxLeave");
        this.txtdocLeave.setName("txtdocLeave");
        this.txtotherWaiMoney.setName("txtotherWaiMoney");
        this.txtwaiAllMoney.setName("txtwaiAllMoney");
        this.txtmarktMoney.setName("txtmarktMoney");
        this.txtscalMoney.setName("txtscalMoney");
        this.txtmbAmount.setName("txtmbAmount");
        this.txtdocAmount.setName("txtdocAmount");
        this.txtkfAmount.setName("txtkfAmount");
        this.txthlAmount.setName("txthlAmount");
        this.txtzxAmount.setName("txtzxAmount");
        this.txtshopTarMoney.setName("txtshopTarMoney");
        this.txtotherNeiMoney.setName("txtotherNeiMoney");
        this.txtbdProjectAll.setName("txtbdProjectAll");
        this.txtmonthBase.setName("txtmonthBase");
        this.txtbdMonthProject.setName("txtbdMonthProject");
        this.txtpayble.setName("txtpayble");
        this.txtachieveAll.setName("txtachieveAll");
        this.txtseaBase.setName("txtseaBase");
        this.txtseaBuzu.setName("txtseaBuzu");
        this.txtshouldPay.setName("txtshouldPay");
        this.txtrealShouldPay.setName("txtrealShouldPay");
        this.txtperDaBing.setName("txtperDaBing");
        this.txtperAll.setName("txtperAll");
        this.txtbeforeTaxMoney.setName("txtbeforeTaxMoney");
        this.txtfreeTaxMoney.setName("txtfreeTaxMoney");
        this.txtljyssde.setName("txtljyssde");
        this.txtgrzxkcAmount.setName("txtgrzxkcAmount");
        this.txtyssde.setName("txtyssde");
        this.txttax.setName("txttax");
        this.txtsjkcs.setName("txtsjkcs");
        this.txtljgrsds.setName("txtljgrsds");
        this.txtdkgrsds.setName("txtdkgrsds");
        this.txtmwBase.setName("txtmwBase");
        this.txtdianpingSub.setName("txtdianpingSub");
        this.txtkfSub.setName("txtkfSub");
        this.txtpayUp.setName("txtpayUp");
        this.txtbuchangAmount.setName("txtbuchangAmount");
        this.txtjifenAll.setName("txtjifenAll");
        this.txttiepiaoSer.setName("txttiepiaoSer");
        this.txtguanaitongSer.setName("txtguanaitongSer");
        this.txtotherSer.setName("txtotherSer");
        this.txtserviceAll.setName("txtserviceAll");
        this.txtshouldYearBouns.setName("txtshouldYearBouns");
        this.txtyearTax.setName("txtyearTax");
        this.txtrealyearAmount.setName("txtrealyearAmount");
        this.txtrealAmount.setName("txtrealAmount");
        this.txtshuijin.setName("txtshuijin");
        this.txtcomAll.setName("txtcomAll");
        this.txtLC.setName("txtLC");
        this.txtbasemoney.setName("txtbasemoney");
        this.txtfentanother.setName("txtfentanother");
        this.txtnianzhongfentan.setName("txtnianzhongfentan");
        this.txtjidufentan.setName("txtjidufentan");
        this.txtnianzhong.setName("txtnianzhong");
        this.txtjidu.setName("txtjidu");
        this.txtyuedurenliAll.setName("txtyuedurenliAll");
        this.txtdocAssCost.setName("txtdocAssCost");
        this.txtclinicAchiMoney.setName("txtclinicAchiMoney");
        this.txtassToDoc.setName("txtassToDoc");
        this.txtBaoDiBonus.setName("txtBaoDiBonus");
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
        // contcityid		
        this.contcityid.setBoundLabelText(resHelper.getString("contcityid.boundLabelText"));		
        this.contcityid.setBoundLabelLength(100);		
        this.contcityid.setBoundLabelUnderline(true);		
        this.contcityid.setVisible(true);
        // contcompanyid		
        this.contcompanyid.setBoundLabelText(resHelper.getString("contcompanyid.boundLabelText"));		
        this.contcompanyid.setBoundLabelLength(100);		
        this.contcompanyid.setBoundLabelUnderline(true);		
        this.contcompanyid.setVisible(true);
        // contpersonid		
        this.contpersonid.setBoundLabelText(resHelper.getString("contpersonid.boundLabelText"));		
        this.contpersonid.setBoundLabelLength(100);		
        this.contpersonid.setBoundLabelUnderline(true);		
        this.contpersonid.setVisible(true);
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
        // contcompanyNumber		
        this.contcompanyNumber.setBoundLabelText(resHelper.getString("contcompanyNumber.boundLabelText"));		
        this.contcompanyNumber.setBoundLabelLength(100);		
        this.contcompanyNumber.setBoundLabelUnderline(true);		
        this.contcompanyNumber.setVisible(true);
        // contcompanyName		
        this.contcompanyName.setBoundLabelText(resHelper.getString("contcompanyName.boundLabelText"));		
        this.contcompanyName.setBoundLabelLength(100);		
        this.contcompanyName.setBoundLabelUnderline(true);		
        this.contcompanyName.setVisible(true);
        // contpersonNumber		
        this.contpersonNumber.setBoundLabelText(resHelper.getString("contpersonNumber.boundLabelText"));		
        this.contpersonNumber.setBoundLabelLength(100);		
        this.contpersonNumber.setBoundLabelUnderline(true);		
        this.contpersonNumber.setVisible(true);
        // contpersonName		
        this.contpersonName.setBoundLabelText(resHelper.getString("contpersonName.boundLabelText"));		
        this.contpersonName.setBoundLabelLength(100);		
        this.contpersonName.setBoundLabelUnderline(true);		
        this.contpersonName.setVisible(true);
        // contpost		
        this.contpost.setBoundLabelText(resHelper.getString("contpost.boundLabelText"));		
        this.contpost.setBoundLabelLength(100);		
        this.contpost.setBoundLabelUnderline(true);		
        this.contpost.setVisible(true);
        // contpostType		
        this.contpostType.setBoundLabelText(resHelper.getString("contpostType.boundLabelText"));		
        this.contpostType.setBoundLabelLength(100);		
        this.contpostType.setBoundLabelUnderline(true);		
        this.contpostType.setVisible(true);
        // contindate		
        this.contindate.setBoundLabelText(resHelper.getString("contindate.boundLabelText"));		
        this.contindate.setBoundLabelLength(100);		
        this.contindate.setBoundLabelUnderline(true);		
        this.contindate.setVisible(true);
        // contleaveDate		
        this.contleaveDate.setBoundLabelText(resHelper.getString("contleaveDate.boundLabelText"));		
        this.contleaveDate.setBoundLabelLength(100);		
        this.contleaveDate.setBoundLabelUnderline(true);		
        this.contleaveDate.setVisible(true);
        // contworkYear		
        this.contworkYear.setBoundLabelText(resHelper.getString("contworkYear.boundLabelText"));		
        this.contworkYear.setBoundLabelLength(100);		
        this.contworkYear.setBoundLabelUnderline(true);		
        this.contworkYear.setVisible(true);
        // contbingjiaPro		
        this.contbingjiaPro.setBoundLabelText(resHelper.getString("contbingjiaPro.boundLabelText"));		
        this.contbingjiaPro.setBoundLabelLength(100);		
        this.contbingjiaPro.setBoundLabelUnderline(true);		
        this.contbingjiaPro.setVisible(true);
        // contcardNumber		
        this.contcardNumber.setBoundLabelText(resHelper.getString("contcardNumber.boundLabelText"));		
        this.contcardNumber.setBoundLabelLength(100);		
        this.contcardNumber.setBoundLabelUnderline(true);		
        this.contcardNumber.setVisible(true);
        // contpostAllow		
        this.contpostAllow.setBoundLabelText(resHelper.getString("contpostAllow.boundLabelText"));		
        this.contpostAllow.setBoundLabelLength(100);		
        this.contpostAllow.setBoundLabelUnderline(true);		
        this.contpostAllow.setVisible(true);
        // contworkYearAllow		
        this.contworkYearAllow.setBoundLabelText(resHelper.getString("contworkYearAllow.boundLabelText"));		
        this.contworkYearAllow.setBoundLabelLength(100);		
        this.contworkYearAllow.setBoundLabelUnderline(true);		
        this.contworkYearAllow.setVisible(true);
        // contlearnAllow		
        this.contlearnAllow.setBoundLabelText(resHelper.getString("contlearnAllow.boundLabelText"));		
        this.contlearnAllow.setBoundLabelLength(100);		
        this.contlearnAllow.setBoundLabelUnderline(true);		
        this.contlearnAllow.setVisible(true);
        // contcardAllow		
        this.contcardAllow.setBoundLabelText(resHelper.getString("contcardAllow.boundLabelText"));		
        this.contcardAllow.setBoundLabelLength(100);		
        this.contcardAllow.setBoundLabelUnderline(true);		
        this.contcardAllow.setVisible(true);
        // conthouseAllow		
        this.conthouseAllow.setBoundLabelText(resHelper.getString("conthouseAllow.boundLabelText"));		
        this.conthouseAllow.setBoundLabelLength(100);		
        this.conthouseAllow.setBoundLabelUnderline(true);		
        this.conthouseAllow.setVisible(true);
        // contachieveMoney		
        this.contachieveMoney.setBoundLabelText(resHelper.getString("contachieveMoney.boundLabelText"));		
        this.contachieveMoney.setBoundLabelLength(100);		
        this.contachieveMoney.setBoundLabelUnderline(true);		
        this.contachieveMoney.setVisible(true);
        // contmonthMoney		
        this.contmonthMoney.setBoundLabelText(resHelper.getString("contmonthMoney.boundLabelText"));		
        this.contmonthMoney.setBoundLabelLength(100);		
        this.contmonthMoney.setBoundLabelUnderline(true);		
        this.contmonthMoney.setVisible(true);
        // contqueqin		
        this.contqueqin.setBoundLabelText(resHelper.getString("contqueqin.boundLabelText"));		
        this.contqueqin.setBoundLabelLength(100);		
        this.contqueqin.setBoundLabelUnderline(true);		
        this.contqueqin.setVisible(true);
        // contshijia		
        this.contshijia.setBoundLabelText(resHelper.getString("contshijia.boundLabelText"));		
        this.contshijia.setBoundLabelLength(100);		
        this.contshijia.setBoundLabelUnderline(true);		
        this.contshijia.setVisible(true);
        // contbingjia		
        this.contbingjia.setBoundLabelText(resHelper.getString("contbingjia.boundLabelText"));		
        this.contbingjia.setBoundLabelLength(100);		
        this.contbingjia.setBoundLabelUnderline(true);		
        this.contbingjia.setVisible(true);
        // contkaoqinSub		
        this.contkaoqinSub.setBoundLabelText(resHelper.getString("contkaoqinSub.boundLabelText"));		
        this.contkaoqinSub.setBoundLabelLength(100);		
        this.contkaoqinSub.setBoundLabelUnderline(true);		
        this.contkaoqinSub.setVisible(true);
        // contchidaoSub		
        this.contchidaoSub.setBoundLabelText(resHelper.getString("contchidaoSub.boundLabelText"));		
        this.contchidaoSub.setBoundLabelLength(100);		
        this.contchidaoSub.setBoundLabelUnderline(true);		
        this.contchidaoSub.setVisible(true);
        // contgdAllow		
        this.contgdAllow.setBoundLabelText(resHelper.getString("contgdAllow.boundLabelText"));		
        this.contgdAllow.setBoundLabelLength(100);		
        this.contgdAllow.setBoundLabelUnderline(true);		
        this.contgdAllow.setVisible(true);
        // contallWorkAllow		
        this.contallWorkAllow.setBoundLabelText(resHelper.getString("contallWorkAllow.boundLabelText"));		
        this.contallWorkAllow.setBoundLabelLength(100);		
        this.contallWorkAllow.setBoundLabelUnderline(true);		
        this.contallWorkAllow.setVisible(true);
        // contfoodAllow		
        this.contfoodAllow.setBoundLabelText(resHelper.getString("contfoodAllow.boundLabelText"));		
        this.contfoodAllow.setBoundLabelLength(100);		
        this.contfoodAllow.setBoundLabelUnderline(true);		
        this.contfoodAllow.setVisible(true);
        // contaddWorkAllow		
        this.contaddWorkAllow.setBoundLabelText(resHelper.getString("contaddWorkAllow.boundLabelText"));		
        this.contaddWorkAllow.setBoundLabelLength(100);		
        this.contaddWorkAllow.setBoundLabelUnderline(true);		
        this.contaddWorkAllow.setVisible(true);
        // contother		
        this.contother.setBoundLabelText(resHelper.getString("contother.boundLabelText"));		
        this.contother.setBoundLabelLength(100);		
        this.contother.setBoundLabelUnderline(true);		
        this.contother.setVisible(true);
        // contgdMoney		
        this.contgdMoney.setBoundLabelText(resHelper.getString("contgdMoney.boundLabelText"));		
        this.contgdMoney.setBoundLabelLength(100);		
        this.contgdMoney.setBoundLabelUnderline(true);		
        this.contgdMoney.setVisible(true);
        // contXRayAllow		
        this.contXRayAllow.setBoundLabelText(resHelper.getString("contXRayAllow.boundLabelText"));		
        this.contXRayAllow.setBoundLabelLength(100);		
        this.contXRayAllow.setBoundLabelUnderline(true);		
        this.contXRayAllow.setVisible(true);
        // contholderMoney		
        this.contholderMoney.setBoundLabelText(resHelper.getString("contholderMoney.boundLabelText"));		
        this.contholderMoney.setBoundLabelLength(100);		
        this.contholderMoney.setBoundLabelUnderline(true);		
        this.contholderMoney.setVisible(true);
        // contassMoney		
        this.contassMoney.setBoundLabelText(resHelper.getString("contassMoney.boundLabelText"));		
        this.contassMoney.setBoundLabelLength(100);		
        this.contassMoney.setBoundLabelUnderline(true);		
        this.contassMoney.setVisible(true);
        // contzbPro		
        this.contzbPro.setBoundLabelText(resHelper.getString("contzbPro.boundLabelText"));		
        this.contzbPro.setBoundLabelLength(100);		
        this.contzbPro.setBoundLabelUnderline(true);		
        this.contzbPro.setVisible(true);
        // contshopHelp		
        this.contshopHelp.setBoundLabelText(resHelper.getString("contshopHelp.boundLabelText"));		
        this.contshopHelp.setBoundLabelLength(100);		
        this.contshopHelp.setBoundLabelUnderline(true);		
        this.contshopHelp.setVisible(true);
        // contzxCard		
        this.contzxCard.setBoundLabelText(resHelper.getString("contzxCard.boundLabelText"));		
        this.contzxCard.setBoundLabelLength(100);		
        this.contzxCard.setBoundLabelUnderline(true);		
        this.contzxCard.setVisible(true);
        // contsplitUp		
        this.contsplitUp.setBoundLabelText(resHelper.getString("contsplitUp.boundLabelText"));		
        this.contsplitUp.setBoundLabelLength(100);		
        this.contsplitUp.setBoundLabelUnderline(true);		
        this.contsplitUp.setVisible(true);
        // contzxLeave		
        this.contzxLeave.setBoundLabelText(resHelper.getString("contzxLeave.boundLabelText"));		
        this.contzxLeave.setBoundLabelLength(100);		
        this.contzxLeave.setBoundLabelUnderline(true);		
        this.contzxLeave.setVisible(true);
        // contdocLeave		
        this.contdocLeave.setBoundLabelText(resHelper.getString("contdocLeave.boundLabelText"));		
        this.contdocLeave.setBoundLabelLength(100);		
        this.contdocLeave.setBoundLabelUnderline(true);		
        this.contdocLeave.setVisible(true);
        // contotherWaiMoney		
        this.contotherWaiMoney.setBoundLabelText(resHelper.getString("contotherWaiMoney.boundLabelText"));		
        this.contotherWaiMoney.setBoundLabelLength(100);		
        this.contotherWaiMoney.setBoundLabelUnderline(true);		
        this.contotherWaiMoney.setVisible(true);
        // contwaiAllMoney		
        this.contwaiAllMoney.setBoundLabelText(resHelper.getString("contwaiAllMoney.boundLabelText"));		
        this.contwaiAllMoney.setBoundLabelLength(100);		
        this.contwaiAllMoney.setBoundLabelUnderline(true);		
        this.contwaiAllMoney.setVisible(true);
        // contmarktMoney		
        this.contmarktMoney.setBoundLabelText(resHelper.getString("contmarktMoney.boundLabelText"));		
        this.contmarktMoney.setBoundLabelLength(100);		
        this.contmarktMoney.setBoundLabelUnderline(true);		
        this.contmarktMoney.setVisible(true);
        // contscalMoney		
        this.contscalMoney.setBoundLabelText(resHelper.getString("contscalMoney.boundLabelText"));		
        this.contscalMoney.setBoundLabelLength(100);		
        this.contscalMoney.setBoundLabelUnderline(true);		
        this.contscalMoney.setVisible(true);
        // contmbAmount		
        this.contmbAmount.setBoundLabelText(resHelper.getString("contmbAmount.boundLabelText"));		
        this.contmbAmount.setBoundLabelLength(100);		
        this.contmbAmount.setBoundLabelUnderline(true);		
        this.contmbAmount.setVisible(true);
        // contdocAmount		
        this.contdocAmount.setBoundLabelText(resHelper.getString("contdocAmount.boundLabelText"));		
        this.contdocAmount.setBoundLabelLength(100);		
        this.contdocAmount.setBoundLabelUnderline(true);		
        this.contdocAmount.setVisible(true);
        // contkfAmount		
        this.contkfAmount.setBoundLabelText(resHelper.getString("contkfAmount.boundLabelText"));		
        this.contkfAmount.setBoundLabelLength(100);		
        this.contkfAmount.setBoundLabelUnderline(true);		
        this.contkfAmount.setVisible(true);
        // conthlAmount		
        this.conthlAmount.setBoundLabelText(resHelper.getString("conthlAmount.boundLabelText"));		
        this.conthlAmount.setBoundLabelLength(100);		
        this.conthlAmount.setBoundLabelUnderline(true);		
        this.conthlAmount.setVisible(true);
        // contzxAmount		
        this.contzxAmount.setBoundLabelText(resHelper.getString("contzxAmount.boundLabelText"));		
        this.contzxAmount.setBoundLabelLength(100);		
        this.contzxAmount.setBoundLabelUnderline(true);		
        this.contzxAmount.setVisible(true);
        // contshopTarMoney		
        this.contshopTarMoney.setBoundLabelText(resHelper.getString("contshopTarMoney.boundLabelText"));		
        this.contshopTarMoney.setBoundLabelLength(100);		
        this.contshopTarMoney.setBoundLabelUnderline(true);		
        this.contshopTarMoney.setVisible(true);
        // contotherNeiMoney		
        this.contotherNeiMoney.setBoundLabelText(resHelper.getString("contotherNeiMoney.boundLabelText"));		
        this.contotherNeiMoney.setBoundLabelLength(100);		
        this.contotherNeiMoney.setBoundLabelUnderline(true);		
        this.contotherNeiMoney.setVisible(true);
        // contbdProjectAll		
        this.contbdProjectAll.setBoundLabelText(resHelper.getString("contbdProjectAll.boundLabelText"));		
        this.contbdProjectAll.setBoundLabelLength(100);		
        this.contbdProjectAll.setBoundLabelUnderline(true);		
        this.contbdProjectAll.setVisible(true);
        // contmonthBase		
        this.contmonthBase.setBoundLabelText(resHelper.getString("contmonthBase.boundLabelText"));		
        this.contmonthBase.setBoundLabelLength(100);		
        this.contmonthBase.setBoundLabelUnderline(true);		
        this.contmonthBase.setVisible(true);
        // contbdMonthProject		
        this.contbdMonthProject.setBoundLabelText(resHelper.getString("contbdMonthProject.boundLabelText"));		
        this.contbdMonthProject.setBoundLabelLength(100);		
        this.contbdMonthProject.setBoundLabelUnderline(true);		
        this.contbdMonthProject.setVisible(true);
        // contpayble		
        this.contpayble.setBoundLabelText(resHelper.getString("contpayble.boundLabelText"));		
        this.contpayble.setBoundLabelLength(100);		
        this.contpayble.setBoundLabelUnderline(true);		
        this.contpayble.setVisible(true);
        // contachieveAll		
        this.contachieveAll.setBoundLabelText(resHelper.getString("contachieveAll.boundLabelText"));		
        this.contachieveAll.setBoundLabelLength(100);		
        this.contachieveAll.setBoundLabelUnderline(true);		
        this.contachieveAll.setVisible(true);
        // contseaBase		
        this.contseaBase.setBoundLabelText(resHelper.getString("contseaBase.boundLabelText"));		
        this.contseaBase.setBoundLabelLength(100);		
        this.contseaBase.setBoundLabelUnderline(true);		
        this.contseaBase.setVisible(true);
        // contseaBuzu		
        this.contseaBuzu.setBoundLabelText(resHelper.getString("contseaBuzu.boundLabelText"));		
        this.contseaBuzu.setBoundLabelLength(100);		
        this.contseaBuzu.setBoundLabelUnderline(true);		
        this.contseaBuzu.setVisible(true);
        // contshouldPay		
        this.contshouldPay.setBoundLabelText(resHelper.getString("contshouldPay.boundLabelText"));		
        this.contshouldPay.setBoundLabelLength(100);		
        this.contshouldPay.setBoundLabelUnderline(true);		
        this.contshouldPay.setVisible(true);
        // contrealShouldPay		
        this.contrealShouldPay.setBoundLabelText(resHelper.getString("contrealShouldPay.boundLabelText"));		
        this.contrealShouldPay.setBoundLabelLength(100);		
        this.contrealShouldPay.setBoundLabelUnderline(true);		
        this.contrealShouldPay.setVisible(true);
        // contperDaBing		
        this.contperDaBing.setBoundLabelText(resHelper.getString("contperDaBing.boundLabelText"));		
        this.contperDaBing.setBoundLabelLength(100);		
        this.contperDaBing.setBoundLabelUnderline(true);		
        this.contperDaBing.setVisible(true);
        // contperAll		
        this.contperAll.setBoundLabelText(resHelper.getString("contperAll.boundLabelText"));		
        this.contperAll.setBoundLabelLength(100);		
        this.contperAll.setBoundLabelUnderline(true);		
        this.contperAll.setVisible(true);
        // contbeforeTaxMoney		
        this.contbeforeTaxMoney.setBoundLabelText(resHelper.getString("contbeforeTaxMoney.boundLabelText"));		
        this.contbeforeTaxMoney.setBoundLabelLength(100);		
        this.contbeforeTaxMoney.setBoundLabelUnderline(true);		
        this.contbeforeTaxMoney.setVisible(true);
        // contfreeTaxMoney		
        this.contfreeTaxMoney.setBoundLabelText(resHelper.getString("contfreeTaxMoney.boundLabelText"));		
        this.contfreeTaxMoney.setBoundLabelLength(100);		
        this.contfreeTaxMoney.setBoundLabelUnderline(true);		
        this.contfreeTaxMoney.setVisible(true);
        // contljyssde		
        this.contljyssde.setBoundLabelText(resHelper.getString("contljyssde.boundLabelText"));		
        this.contljyssde.setBoundLabelLength(100);		
        this.contljyssde.setBoundLabelUnderline(true);		
        this.contljyssde.setVisible(true);
        // contgrzxkcAmount		
        this.contgrzxkcAmount.setBoundLabelText(resHelper.getString("contgrzxkcAmount.boundLabelText"));		
        this.contgrzxkcAmount.setBoundLabelLength(100);		
        this.contgrzxkcAmount.setBoundLabelUnderline(true);		
        this.contgrzxkcAmount.setVisible(true);
        // contyssde		
        this.contyssde.setBoundLabelText(resHelper.getString("contyssde.boundLabelText"));		
        this.contyssde.setBoundLabelLength(100);		
        this.contyssde.setBoundLabelUnderline(true);		
        this.contyssde.setVisible(true);
        // conttax		
        this.conttax.setBoundLabelText(resHelper.getString("conttax.boundLabelText"));		
        this.conttax.setBoundLabelLength(100);		
        this.conttax.setBoundLabelUnderline(true);		
        this.conttax.setVisible(true);
        // contsjkcs		
        this.contsjkcs.setBoundLabelText(resHelper.getString("contsjkcs.boundLabelText"));		
        this.contsjkcs.setBoundLabelLength(100);		
        this.contsjkcs.setBoundLabelUnderline(true);		
        this.contsjkcs.setVisible(true);
        // contljgrsds		
        this.contljgrsds.setBoundLabelText(resHelper.getString("contljgrsds.boundLabelText"));		
        this.contljgrsds.setBoundLabelLength(100);		
        this.contljgrsds.setBoundLabelUnderline(true);		
        this.contljgrsds.setVisible(true);
        // contdkgrsds		
        this.contdkgrsds.setBoundLabelText(resHelper.getString("contdkgrsds.boundLabelText"));		
        this.contdkgrsds.setBoundLabelLength(100);		
        this.contdkgrsds.setBoundLabelUnderline(true);		
        this.contdkgrsds.setVisible(true);
        // contmwBase		
        this.contmwBase.setBoundLabelText(resHelper.getString("contmwBase.boundLabelText"));		
        this.contmwBase.setBoundLabelLength(100);		
        this.contmwBase.setBoundLabelUnderline(true);		
        this.contmwBase.setVisible(true);
        // contdianpingSub		
        this.contdianpingSub.setBoundLabelText(resHelper.getString("contdianpingSub.boundLabelText"));		
        this.contdianpingSub.setBoundLabelLength(100);		
        this.contdianpingSub.setBoundLabelUnderline(true);		
        this.contdianpingSub.setVisible(true);
        // contkfSub		
        this.contkfSub.setBoundLabelText(resHelper.getString("contkfSub.boundLabelText"));		
        this.contkfSub.setBoundLabelLength(100);		
        this.contkfSub.setBoundLabelUnderline(true);		
        this.contkfSub.setVisible(true);
        // contpayUp		
        this.contpayUp.setBoundLabelText(resHelper.getString("contpayUp.boundLabelText"));		
        this.contpayUp.setBoundLabelLength(100);		
        this.contpayUp.setBoundLabelUnderline(true);		
        this.contpayUp.setVisible(true);
        // contbuchangAmount		
        this.contbuchangAmount.setBoundLabelText(resHelper.getString("contbuchangAmount.boundLabelText"));		
        this.contbuchangAmount.setBoundLabelLength(100);		
        this.contbuchangAmount.setBoundLabelUnderline(true);		
        this.contbuchangAmount.setVisible(true);
        // contjifenAll		
        this.contjifenAll.setBoundLabelText(resHelper.getString("contjifenAll.boundLabelText"));		
        this.contjifenAll.setBoundLabelLength(100);		
        this.contjifenAll.setBoundLabelUnderline(true);		
        this.contjifenAll.setVisible(true);
        // conttiepiaoSer		
        this.conttiepiaoSer.setBoundLabelText(resHelper.getString("conttiepiaoSer.boundLabelText"));		
        this.conttiepiaoSer.setBoundLabelLength(100);		
        this.conttiepiaoSer.setBoundLabelUnderline(true);		
        this.conttiepiaoSer.setVisible(true);
        // contguanaitongSer		
        this.contguanaitongSer.setBoundLabelText(resHelper.getString("contguanaitongSer.boundLabelText"));		
        this.contguanaitongSer.setBoundLabelLength(100);		
        this.contguanaitongSer.setBoundLabelUnderline(true);		
        this.contguanaitongSer.setVisible(true);
        // contotherSer		
        this.contotherSer.setBoundLabelText(resHelper.getString("contotherSer.boundLabelText"));		
        this.contotherSer.setBoundLabelLength(100);		
        this.contotherSer.setBoundLabelUnderline(true);		
        this.contotherSer.setVisible(true);
        // contserviceAll		
        this.contserviceAll.setBoundLabelText(resHelper.getString("contserviceAll.boundLabelText"));		
        this.contserviceAll.setBoundLabelLength(100);		
        this.contserviceAll.setBoundLabelUnderline(true);		
        this.contserviceAll.setVisible(true);
        // contshouldYearBouns		
        this.contshouldYearBouns.setBoundLabelText(resHelper.getString("contshouldYearBouns.boundLabelText"));		
        this.contshouldYearBouns.setBoundLabelLength(100);		
        this.contshouldYearBouns.setBoundLabelUnderline(true);		
        this.contshouldYearBouns.setVisible(true);
        // contyearTax		
        this.contyearTax.setBoundLabelText(resHelper.getString("contyearTax.boundLabelText"));		
        this.contyearTax.setBoundLabelLength(100);		
        this.contyearTax.setBoundLabelUnderline(true);		
        this.contyearTax.setVisible(true);
        // contrealyearAmount		
        this.contrealyearAmount.setBoundLabelText(resHelper.getString("contrealyearAmount.boundLabelText"));		
        this.contrealyearAmount.setBoundLabelLength(100);		
        this.contrealyearAmount.setBoundLabelUnderline(true);		
        this.contrealyearAmount.setVisible(true);
        // contrealAmount		
        this.contrealAmount.setBoundLabelText(resHelper.getString("contrealAmount.boundLabelText"));		
        this.contrealAmount.setBoundLabelLength(100);		
        this.contrealAmount.setBoundLabelUnderline(true);		
        this.contrealAmount.setVisible(true);
        // contshuijin		
        this.contshuijin.setBoundLabelText(resHelper.getString("contshuijin.boundLabelText"));		
        this.contshuijin.setBoundLabelLength(100);		
        this.contshuijin.setBoundLabelUnderline(true);		
        this.contshuijin.setVisible(true);
        // contcomAll		
        this.contcomAll.setBoundLabelText(resHelper.getString("contcomAll.boundLabelText"));		
        this.contcomAll.setBoundLabelLength(100);		
        this.contcomAll.setBoundLabelUnderline(true);		
        this.contcomAll.setVisible(true);
        // contLC		
        this.contLC.setBoundLabelText(resHelper.getString("contLC.boundLabelText"));		
        this.contLC.setBoundLabelLength(100);		
        this.contLC.setBoundLabelUnderline(true);		
        this.contLC.setVisible(true);
        // contbasemoney		
        this.contbasemoney.setBoundLabelText(resHelper.getString("contbasemoney.boundLabelText"));		
        this.contbasemoney.setBoundLabelLength(100);		
        this.contbasemoney.setBoundLabelUnderline(true);		
        this.contbasemoney.setVisible(true);
        // contfentanother		
        this.contfentanother.setBoundLabelText(resHelper.getString("contfentanother.boundLabelText"));		
        this.contfentanother.setBoundLabelLength(100);		
        this.contfentanother.setBoundLabelUnderline(true);		
        this.contfentanother.setVisible(true);
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
        // contyuedurenliAll		
        this.contyuedurenliAll.setBoundLabelText(resHelper.getString("contyuedurenliAll.boundLabelText"));		
        this.contyuedurenliAll.setBoundLabelLength(100);		
        this.contyuedurenliAll.setBoundLabelUnderline(true);		
        this.contyuedurenliAll.setVisible(true);
        // contdocAssCost		
        this.contdocAssCost.setBoundLabelText(resHelper.getString("contdocAssCost.boundLabelText"));		
        this.contdocAssCost.setBoundLabelLength(100);		
        this.contdocAssCost.setBoundLabelUnderline(true);		
        this.contdocAssCost.setVisible(true);
        // contclinicAchiMoney		
        this.contclinicAchiMoney.setBoundLabelText(resHelper.getString("contclinicAchiMoney.boundLabelText"));		
        this.contclinicAchiMoney.setBoundLabelLength(100);		
        this.contclinicAchiMoney.setBoundLabelUnderline(true);		
        this.contclinicAchiMoney.setVisible(true);
        // contassToDoc		
        this.contassToDoc.setBoundLabelText(resHelper.getString("contassToDoc.boundLabelText"));		
        this.contassToDoc.setBoundLabelLength(100);		
        this.contassToDoc.setBoundLabelUnderline(true);		
        this.contassToDoc.setVisible(true);
        // contBaoDiBonus		
        this.contBaoDiBonus.setBoundLabelText(resHelper.getString("contBaoDiBonus.boundLabelText"));		
        this.contBaoDiBonus.setBoundLabelLength(100);		
        this.contBaoDiBonus.setBoundLabelUnderline(true);		
        this.contBaoDiBonus.setVisible(true);
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
        // txtcityid		
        this.txtcityid.setHorizontalAlignment(2);		
        this.txtcityid.setMaxLength(100);		
        this.txtcityid.setRequired(false);
        // txtcompanyid		
        this.txtcompanyid.setHorizontalAlignment(2);		
        this.txtcompanyid.setMaxLength(100);		
        this.txtcompanyid.setRequired(false);
        // txtpersonid		
        this.txtpersonid.setHorizontalAlignment(2);		
        this.txtpersonid.setMaxLength(100);		
        this.txtpersonid.setRequired(false);
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
        // txtcityNumber		
        this.txtcityNumber.setHorizontalAlignment(2);		
        this.txtcityNumber.setMaxLength(100);		
        this.txtcityNumber.setRequired(false);
        // txtcityName		
        this.txtcityName.setHorizontalAlignment(2);		
        this.txtcityName.setMaxLength(100);		
        this.txtcityName.setRequired(false);
        // txtcompanyNumber		
        this.txtcompanyNumber.setHorizontalAlignment(2);		
        this.txtcompanyNumber.setMaxLength(100);		
        this.txtcompanyNumber.setRequired(false);
        // txtcompanyName		
        this.txtcompanyName.setHorizontalAlignment(2);		
        this.txtcompanyName.setMaxLength(100);		
        this.txtcompanyName.setRequired(false);
        // txtpersonNumber		
        this.txtpersonNumber.setHorizontalAlignment(2);		
        this.txtpersonNumber.setMaxLength(100);		
        this.txtpersonNumber.setRequired(false);
        // txtpersonName		
        this.txtpersonName.setHorizontalAlignment(2);		
        this.txtpersonName.setMaxLength(100);		
        this.txtpersonName.setRequired(false);
        // txtpost		
        this.txtpost.setHorizontalAlignment(2);		
        this.txtpost.setMaxLength(100);		
        this.txtpost.setRequired(false);
        // txtpostType		
        this.txtpostType.setHorizontalAlignment(2);		
        this.txtpostType.setMaxLength(100);		
        this.txtpostType.setRequired(false);
        // txtindate		
        this.txtindate.setHorizontalAlignment(2);		
        this.txtindate.setMaxLength(100);		
        this.txtindate.setRequired(false);
        // txtleaveDate		
        this.txtleaveDate.setHorizontalAlignment(2);		
        this.txtleaveDate.setMaxLength(100);		
        this.txtleaveDate.setRequired(false);
        // txtworkYear		
        this.txtworkYear.setHorizontalAlignment(2);		
        this.txtworkYear.setDataType(1);		
        this.txtworkYear.setSupportedEmpty(true);		
        this.txtworkYear.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtworkYear.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtworkYear.setPrecision(10);		
        this.txtworkYear.setRequired(false);
        // txtbingjiaPro		
        this.txtbingjiaPro.setHorizontalAlignment(2);		
        this.txtbingjiaPro.setDataType(1);		
        this.txtbingjiaPro.setSupportedEmpty(true);		
        this.txtbingjiaPro.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtbingjiaPro.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtbingjiaPro.setPrecision(10);		
        this.txtbingjiaPro.setRequired(false);
        // txtcardNumber		
        this.txtcardNumber.setHorizontalAlignment(2);		
        this.txtcardNumber.setMaxLength(100);		
        this.txtcardNumber.setRequired(false);
        // txtpostAllow		
        this.txtpostAllow.setHorizontalAlignment(2);		
        this.txtpostAllow.setDataType(1);		
        this.txtpostAllow.setSupportedEmpty(true);		
        this.txtpostAllow.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtpostAllow.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtpostAllow.setPrecision(10);		
        this.txtpostAllow.setRequired(false);
        // txtworkYearAllow		
        this.txtworkYearAllow.setHorizontalAlignment(2);		
        this.txtworkYearAllow.setDataType(1);		
        this.txtworkYearAllow.setSupportedEmpty(true);		
        this.txtworkYearAllow.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtworkYearAllow.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtworkYearAllow.setPrecision(10);		
        this.txtworkYearAllow.setRequired(false);
        // txtlearnAllow		
        this.txtlearnAllow.setHorizontalAlignment(2);		
        this.txtlearnAllow.setDataType(1);		
        this.txtlearnAllow.setSupportedEmpty(true);		
        this.txtlearnAllow.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtlearnAllow.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtlearnAllow.setPrecision(10);		
        this.txtlearnAllow.setRequired(false);
        // txtcardAllow		
        this.txtcardAllow.setHorizontalAlignment(2);		
        this.txtcardAllow.setDataType(1);		
        this.txtcardAllow.setSupportedEmpty(true);		
        this.txtcardAllow.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtcardAllow.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtcardAllow.setPrecision(10);		
        this.txtcardAllow.setRequired(false);
        // txthouseAllow		
        this.txthouseAllow.setHorizontalAlignment(2);		
        this.txthouseAllow.setDataType(1);		
        this.txthouseAllow.setSupportedEmpty(true);		
        this.txthouseAllow.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txthouseAllow.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txthouseAllow.setPrecision(10);		
        this.txthouseAllow.setRequired(false);
        // txtachieveMoney		
        this.txtachieveMoney.setHorizontalAlignment(2);		
        this.txtachieveMoney.setDataType(1);		
        this.txtachieveMoney.setSupportedEmpty(true);		
        this.txtachieveMoney.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtachieveMoney.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtachieveMoney.setPrecision(10);		
        this.txtachieveMoney.setRequired(false);
        // txtmonthMoney		
        this.txtmonthMoney.setHorizontalAlignment(2);		
        this.txtmonthMoney.setDataType(1);		
        this.txtmonthMoney.setSupportedEmpty(true);		
        this.txtmonthMoney.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtmonthMoney.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtmonthMoney.setPrecision(10);		
        this.txtmonthMoney.setRequired(false);
        // txtqueqin		
        this.txtqueqin.setHorizontalAlignment(2);		
        this.txtqueqin.setDataType(1);		
        this.txtqueqin.setSupportedEmpty(true);		
        this.txtqueqin.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtqueqin.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtqueqin.setPrecision(10);		
        this.txtqueqin.setRequired(false);
        // txtshijia		
        this.txtshijia.setHorizontalAlignment(2);		
        this.txtshijia.setDataType(1);		
        this.txtshijia.setSupportedEmpty(true);		
        this.txtshijia.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtshijia.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtshijia.setPrecision(10);		
        this.txtshijia.setRequired(false);
        // txtbingjia		
        this.txtbingjia.setHorizontalAlignment(2);		
        this.txtbingjia.setDataType(1);		
        this.txtbingjia.setSupportedEmpty(true);		
        this.txtbingjia.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtbingjia.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtbingjia.setPrecision(10);		
        this.txtbingjia.setRequired(false);
        // txtkaoqinSub		
        this.txtkaoqinSub.setHorizontalAlignment(2);		
        this.txtkaoqinSub.setDataType(1);		
        this.txtkaoqinSub.setSupportedEmpty(true);		
        this.txtkaoqinSub.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtkaoqinSub.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtkaoqinSub.setPrecision(10);		
        this.txtkaoqinSub.setRequired(false);
        // txtchidaoSub		
        this.txtchidaoSub.setHorizontalAlignment(2);		
        this.txtchidaoSub.setDataType(1);		
        this.txtchidaoSub.setSupportedEmpty(true);		
        this.txtchidaoSub.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtchidaoSub.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtchidaoSub.setPrecision(10);		
        this.txtchidaoSub.setRequired(false);
        // txtgdAllow		
        this.txtgdAllow.setHorizontalAlignment(2);		
        this.txtgdAllow.setDataType(1);		
        this.txtgdAllow.setSupportedEmpty(true);		
        this.txtgdAllow.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtgdAllow.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtgdAllow.setPrecision(10);		
        this.txtgdAllow.setRequired(false);
        // txtallWorkAllow		
        this.txtallWorkAllow.setHorizontalAlignment(2);		
        this.txtallWorkAllow.setDataType(1);		
        this.txtallWorkAllow.setSupportedEmpty(true);		
        this.txtallWorkAllow.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtallWorkAllow.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtallWorkAllow.setPrecision(10);		
        this.txtallWorkAllow.setRequired(false);
        // txtfoodAllow		
        this.txtfoodAllow.setHorizontalAlignment(2);		
        this.txtfoodAllow.setDataType(1);		
        this.txtfoodAllow.setSupportedEmpty(true);		
        this.txtfoodAllow.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtfoodAllow.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtfoodAllow.setPrecision(10);		
        this.txtfoodAllow.setRequired(false);
        // txtaddWorkAllow		
        this.txtaddWorkAllow.setHorizontalAlignment(2);		
        this.txtaddWorkAllow.setDataType(1);		
        this.txtaddWorkAllow.setSupportedEmpty(true);		
        this.txtaddWorkAllow.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtaddWorkAllow.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtaddWorkAllow.setPrecision(10);		
        this.txtaddWorkAllow.setRequired(false);
        // txtother		
        this.txtother.setHorizontalAlignment(2);		
        this.txtother.setDataType(1);		
        this.txtother.setSupportedEmpty(true);		
        this.txtother.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtother.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtother.setPrecision(10);		
        this.txtother.setRequired(false);
        // txtgdMoney		
        this.txtgdMoney.setHorizontalAlignment(2);		
        this.txtgdMoney.setDataType(1);		
        this.txtgdMoney.setSupportedEmpty(true);		
        this.txtgdMoney.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtgdMoney.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtgdMoney.setPrecision(10);		
        this.txtgdMoney.setRequired(false);
        // txtXRayAllow		
        this.txtXRayAllow.setHorizontalAlignment(2);		
        this.txtXRayAllow.setDataType(1);		
        this.txtXRayAllow.setSupportedEmpty(true);		
        this.txtXRayAllow.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtXRayAllow.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtXRayAllow.setPrecision(10);		
        this.txtXRayAllow.setRequired(false);
        // txtholderMoney		
        this.txtholderMoney.setHorizontalAlignment(2);		
        this.txtholderMoney.setDataType(1);		
        this.txtholderMoney.setSupportedEmpty(true);		
        this.txtholderMoney.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtholderMoney.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtholderMoney.setPrecision(10);		
        this.txtholderMoney.setRequired(false);
        // txtassMoney		
        this.txtassMoney.setHorizontalAlignment(2);		
        this.txtassMoney.setDataType(1);		
        this.txtassMoney.setSupportedEmpty(true);		
        this.txtassMoney.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtassMoney.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtassMoney.setPrecision(10);		
        this.txtassMoney.setRequired(false);
        // txtzbPro		
        this.txtzbPro.setHorizontalAlignment(2);		
        this.txtzbPro.setDataType(1);		
        this.txtzbPro.setSupportedEmpty(true);		
        this.txtzbPro.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtzbPro.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtzbPro.setPrecision(10);		
        this.txtzbPro.setRequired(false);
        // txtshopHelp		
        this.txtshopHelp.setHorizontalAlignment(2);		
        this.txtshopHelp.setDataType(1);		
        this.txtshopHelp.setSupportedEmpty(true);		
        this.txtshopHelp.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtshopHelp.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtshopHelp.setPrecision(10);		
        this.txtshopHelp.setRequired(false);
        // txtzxCard		
        this.txtzxCard.setHorizontalAlignment(2);		
        this.txtzxCard.setDataType(1);		
        this.txtzxCard.setSupportedEmpty(true);		
        this.txtzxCard.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtzxCard.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtzxCard.setPrecision(10);		
        this.txtzxCard.setRequired(false);
        // txtsplitUp		
        this.txtsplitUp.setHorizontalAlignment(2);		
        this.txtsplitUp.setDataType(1);		
        this.txtsplitUp.setSupportedEmpty(true);		
        this.txtsplitUp.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtsplitUp.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtsplitUp.setPrecision(10);		
        this.txtsplitUp.setRequired(false);
        // txtzxLeave		
        this.txtzxLeave.setHorizontalAlignment(2);		
        this.txtzxLeave.setDataType(1);		
        this.txtzxLeave.setSupportedEmpty(true);		
        this.txtzxLeave.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtzxLeave.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtzxLeave.setPrecision(10);		
        this.txtzxLeave.setRequired(false);
        // txtdocLeave		
        this.txtdocLeave.setHorizontalAlignment(2);		
        this.txtdocLeave.setDataType(1);		
        this.txtdocLeave.setSupportedEmpty(true);		
        this.txtdocLeave.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtdocLeave.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtdocLeave.setPrecision(10);		
        this.txtdocLeave.setRequired(false);
        // txtotherWaiMoney		
        this.txtotherWaiMoney.setHorizontalAlignment(2);		
        this.txtotherWaiMoney.setDataType(1);		
        this.txtotherWaiMoney.setSupportedEmpty(true);		
        this.txtotherWaiMoney.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtotherWaiMoney.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtotherWaiMoney.setPrecision(10);		
        this.txtotherWaiMoney.setRequired(false);
        // txtwaiAllMoney		
        this.txtwaiAllMoney.setHorizontalAlignment(2);		
        this.txtwaiAllMoney.setDataType(1);		
        this.txtwaiAllMoney.setSupportedEmpty(true);		
        this.txtwaiAllMoney.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtwaiAllMoney.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtwaiAllMoney.setPrecision(10);		
        this.txtwaiAllMoney.setRequired(false);
        // txtmarktMoney		
        this.txtmarktMoney.setHorizontalAlignment(2);		
        this.txtmarktMoney.setDataType(1);		
        this.txtmarktMoney.setSupportedEmpty(true);		
        this.txtmarktMoney.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtmarktMoney.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtmarktMoney.setPrecision(10);		
        this.txtmarktMoney.setRequired(false);
        // txtscalMoney		
        this.txtscalMoney.setHorizontalAlignment(2);		
        this.txtscalMoney.setDataType(1);		
        this.txtscalMoney.setSupportedEmpty(true);		
        this.txtscalMoney.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtscalMoney.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtscalMoney.setPrecision(10);		
        this.txtscalMoney.setRequired(false);
        // txtmbAmount		
        this.txtmbAmount.setHorizontalAlignment(2);		
        this.txtmbAmount.setDataType(1);		
        this.txtmbAmount.setSupportedEmpty(true);		
        this.txtmbAmount.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtmbAmount.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtmbAmount.setPrecision(10);		
        this.txtmbAmount.setRequired(false);
        // txtdocAmount		
        this.txtdocAmount.setHorizontalAlignment(2);		
        this.txtdocAmount.setDataType(1);		
        this.txtdocAmount.setSupportedEmpty(true);		
        this.txtdocAmount.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtdocAmount.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtdocAmount.setPrecision(10);		
        this.txtdocAmount.setRequired(false);
        // txtkfAmount		
        this.txtkfAmount.setHorizontalAlignment(2);		
        this.txtkfAmount.setDataType(1);		
        this.txtkfAmount.setSupportedEmpty(true);		
        this.txtkfAmount.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtkfAmount.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtkfAmount.setPrecision(10);		
        this.txtkfAmount.setRequired(false);
        // txthlAmount		
        this.txthlAmount.setHorizontalAlignment(2);		
        this.txthlAmount.setDataType(1);		
        this.txthlAmount.setSupportedEmpty(true);		
        this.txthlAmount.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txthlAmount.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txthlAmount.setPrecision(10);		
        this.txthlAmount.setRequired(false);
        // txtzxAmount		
        this.txtzxAmount.setHorizontalAlignment(2);		
        this.txtzxAmount.setDataType(1);		
        this.txtzxAmount.setSupportedEmpty(true);		
        this.txtzxAmount.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtzxAmount.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtzxAmount.setPrecision(10);		
        this.txtzxAmount.setRequired(false);
        // txtshopTarMoney		
        this.txtshopTarMoney.setHorizontalAlignment(2);		
        this.txtshopTarMoney.setDataType(1);		
        this.txtshopTarMoney.setSupportedEmpty(true);		
        this.txtshopTarMoney.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtshopTarMoney.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtshopTarMoney.setPrecision(10);		
        this.txtshopTarMoney.setRequired(false);
        // txtotherNeiMoney		
        this.txtotherNeiMoney.setHorizontalAlignment(2);		
        this.txtotherNeiMoney.setDataType(1);		
        this.txtotherNeiMoney.setSupportedEmpty(true);		
        this.txtotherNeiMoney.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtotherNeiMoney.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtotherNeiMoney.setPrecision(10);		
        this.txtotherNeiMoney.setRequired(false);
        // txtbdProjectAll		
        this.txtbdProjectAll.setHorizontalAlignment(2);		
        this.txtbdProjectAll.setDataType(1);		
        this.txtbdProjectAll.setSupportedEmpty(true);		
        this.txtbdProjectAll.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtbdProjectAll.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtbdProjectAll.setPrecision(10);		
        this.txtbdProjectAll.setRequired(false);
        // txtmonthBase		
        this.txtmonthBase.setHorizontalAlignment(2);		
        this.txtmonthBase.setDataType(1);		
        this.txtmonthBase.setSupportedEmpty(true);		
        this.txtmonthBase.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtmonthBase.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtmonthBase.setPrecision(10);		
        this.txtmonthBase.setRequired(false);
        // txtbdMonthProject		
        this.txtbdMonthProject.setHorizontalAlignment(2);		
        this.txtbdMonthProject.setDataType(1);		
        this.txtbdMonthProject.setSupportedEmpty(true);		
        this.txtbdMonthProject.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtbdMonthProject.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtbdMonthProject.setPrecision(10);		
        this.txtbdMonthProject.setRequired(false);
        // txtpayble		
        this.txtpayble.setHorizontalAlignment(2);		
        this.txtpayble.setDataType(1);		
        this.txtpayble.setSupportedEmpty(true);		
        this.txtpayble.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtpayble.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtpayble.setPrecision(10);		
        this.txtpayble.setRequired(false);
        // txtachieveAll		
        this.txtachieveAll.setHorizontalAlignment(2);		
        this.txtachieveAll.setDataType(1);		
        this.txtachieveAll.setSupportedEmpty(true);		
        this.txtachieveAll.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtachieveAll.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtachieveAll.setPrecision(10);		
        this.txtachieveAll.setRequired(false);
        // txtseaBase		
        this.txtseaBase.setHorizontalAlignment(2);		
        this.txtseaBase.setDataType(1);		
        this.txtseaBase.setSupportedEmpty(true);		
        this.txtseaBase.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtseaBase.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtseaBase.setPrecision(10);		
        this.txtseaBase.setRequired(false);
        // txtseaBuzu		
        this.txtseaBuzu.setHorizontalAlignment(2);		
        this.txtseaBuzu.setDataType(1);		
        this.txtseaBuzu.setSupportedEmpty(true);		
        this.txtseaBuzu.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtseaBuzu.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtseaBuzu.setPrecision(10);		
        this.txtseaBuzu.setRequired(false);
        // txtshouldPay		
        this.txtshouldPay.setHorizontalAlignment(2);		
        this.txtshouldPay.setDataType(1);		
        this.txtshouldPay.setSupportedEmpty(true);		
        this.txtshouldPay.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtshouldPay.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtshouldPay.setPrecision(10);		
        this.txtshouldPay.setRequired(false);
        // txtrealShouldPay		
        this.txtrealShouldPay.setHorizontalAlignment(2);		
        this.txtrealShouldPay.setDataType(1);		
        this.txtrealShouldPay.setSupportedEmpty(true);		
        this.txtrealShouldPay.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtrealShouldPay.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtrealShouldPay.setPrecision(10);		
        this.txtrealShouldPay.setRequired(false);
        // txtperDaBing		
        this.txtperDaBing.setHorizontalAlignment(2);		
        this.txtperDaBing.setDataType(1);		
        this.txtperDaBing.setSupportedEmpty(true);		
        this.txtperDaBing.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtperDaBing.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtperDaBing.setPrecision(10);		
        this.txtperDaBing.setRequired(false);
        // txtperAll		
        this.txtperAll.setHorizontalAlignment(2);		
        this.txtperAll.setDataType(1);		
        this.txtperAll.setSupportedEmpty(true);		
        this.txtperAll.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtperAll.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtperAll.setPrecision(10);		
        this.txtperAll.setRequired(false);
        // txtbeforeTaxMoney		
        this.txtbeforeTaxMoney.setHorizontalAlignment(2);		
        this.txtbeforeTaxMoney.setDataType(1);		
        this.txtbeforeTaxMoney.setSupportedEmpty(true);		
        this.txtbeforeTaxMoney.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtbeforeTaxMoney.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtbeforeTaxMoney.setPrecision(10);		
        this.txtbeforeTaxMoney.setRequired(false);
        // txtfreeTaxMoney		
        this.txtfreeTaxMoney.setHorizontalAlignment(2);		
        this.txtfreeTaxMoney.setDataType(1);		
        this.txtfreeTaxMoney.setSupportedEmpty(true);		
        this.txtfreeTaxMoney.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtfreeTaxMoney.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtfreeTaxMoney.setPrecision(10);		
        this.txtfreeTaxMoney.setRequired(false);
        // txtljyssde		
        this.txtljyssde.setHorizontalAlignment(2);		
        this.txtljyssde.setDataType(1);		
        this.txtljyssde.setSupportedEmpty(true);		
        this.txtljyssde.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtljyssde.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtljyssde.setPrecision(10);		
        this.txtljyssde.setRequired(false);
        // txtgrzxkcAmount		
        this.txtgrzxkcAmount.setHorizontalAlignment(2);		
        this.txtgrzxkcAmount.setDataType(1);		
        this.txtgrzxkcAmount.setSupportedEmpty(true);		
        this.txtgrzxkcAmount.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtgrzxkcAmount.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtgrzxkcAmount.setPrecision(10);		
        this.txtgrzxkcAmount.setRequired(false);
        // txtyssde		
        this.txtyssde.setHorizontalAlignment(2);		
        this.txtyssde.setDataType(1);		
        this.txtyssde.setSupportedEmpty(true);		
        this.txtyssde.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtyssde.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtyssde.setPrecision(10);		
        this.txtyssde.setRequired(false);
        // txttax		
        this.txttax.setHorizontalAlignment(2);		
        this.txttax.setDataType(1);		
        this.txttax.setSupportedEmpty(true);		
        this.txttax.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txttax.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txttax.setPrecision(10);		
        this.txttax.setRequired(false);
        // txtsjkcs		
        this.txtsjkcs.setHorizontalAlignment(2);		
        this.txtsjkcs.setDataType(1);		
        this.txtsjkcs.setSupportedEmpty(true);		
        this.txtsjkcs.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtsjkcs.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtsjkcs.setPrecision(10);		
        this.txtsjkcs.setRequired(false);
        // txtljgrsds		
        this.txtljgrsds.setHorizontalAlignment(2);		
        this.txtljgrsds.setDataType(1);		
        this.txtljgrsds.setSupportedEmpty(true);		
        this.txtljgrsds.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtljgrsds.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtljgrsds.setPrecision(10);		
        this.txtljgrsds.setRequired(false);
        // txtdkgrsds		
        this.txtdkgrsds.setHorizontalAlignment(2);		
        this.txtdkgrsds.setDataType(1);		
        this.txtdkgrsds.setSupportedEmpty(true);		
        this.txtdkgrsds.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtdkgrsds.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtdkgrsds.setPrecision(10);		
        this.txtdkgrsds.setRequired(false);
        // txtmwBase		
        this.txtmwBase.setHorizontalAlignment(2);		
        this.txtmwBase.setDataType(1);		
        this.txtmwBase.setSupportedEmpty(true);		
        this.txtmwBase.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtmwBase.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtmwBase.setPrecision(10);		
        this.txtmwBase.setRequired(false);
        // txtdianpingSub		
        this.txtdianpingSub.setHorizontalAlignment(2);		
        this.txtdianpingSub.setDataType(1);		
        this.txtdianpingSub.setSupportedEmpty(true);		
        this.txtdianpingSub.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtdianpingSub.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtdianpingSub.setPrecision(10);		
        this.txtdianpingSub.setRequired(false);
        // txtkfSub		
        this.txtkfSub.setHorizontalAlignment(2);		
        this.txtkfSub.setDataType(1);		
        this.txtkfSub.setSupportedEmpty(true);		
        this.txtkfSub.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtkfSub.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtkfSub.setPrecision(10);		
        this.txtkfSub.setRequired(false);
        // txtpayUp		
        this.txtpayUp.setHorizontalAlignment(2);		
        this.txtpayUp.setDataType(1);		
        this.txtpayUp.setSupportedEmpty(true);		
        this.txtpayUp.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtpayUp.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtpayUp.setPrecision(10);		
        this.txtpayUp.setRequired(false);
        // txtbuchangAmount		
        this.txtbuchangAmount.setHorizontalAlignment(2);		
        this.txtbuchangAmount.setDataType(1);		
        this.txtbuchangAmount.setSupportedEmpty(true);		
        this.txtbuchangAmount.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtbuchangAmount.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtbuchangAmount.setPrecision(10);		
        this.txtbuchangAmount.setRequired(false);
        // txtjifenAll		
        this.txtjifenAll.setHorizontalAlignment(2);		
        this.txtjifenAll.setDataType(1);		
        this.txtjifenAll.setSupportedEmpty(true);		
        this.txtjifenAll.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtjifenAll.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtjifenAll.setPrecision(10);		
        this.txtjifenAll.setRequired(false);
        // txttiepiaoSer		
        this.txttiepiaoSer.setHorizontalAlignment(2);		
        this.txttiepiaoSer.setDataType(1);		
        this.txttiepiaoSer.setSupportedEmpty(true);		
        this.txttiepiaoSer.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txttiepiaoSer.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txttiepiaoSer.setPrecision(10);		
        this.txttiepiaoSer.setRequired(false);
        // txtguanaitongSer		
        this.txtguanaitongSer.setHorizontalAlignment(2);		
        this.txtguanaitongSer.setDataType(1);		
        this.txtguanaitongSer.setSupportedEmpty(true);		
        this.txtguanaitongSer.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtguanaitongSer.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtguanaitongSer.setPrecision(10);		
        this.txtguanaitongSer.setRequired(false);
        // txtotherSer		
        this.txtotherSer.setHorizontalAlignment(2);		
        this.txtotherSer.setDataType(1);		
        this.txtotherSer.setSupportedEmpty(true);		
        this.txtotherSer.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtotherSer.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtotherSer.setPrecision(10);		
        this.txtotherSer.setRequired(false);
        // txtserviceAll		
        this.txtserviceAll.setHorizontalAlignment(2);		
        this.txtserviceAll.setDataType(1);		
        this.txtserviceAll.setSupportedEmpty(true);		
        this.txtserviceAll.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtserviceAll.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtserviceAll.setPrecision(10);		
        this.txtserviceAll.setRequired(false);
        // txtshouldYearBouns		
        this.txtshouldYearBouns.setHorizontalAlignment(2);		
        this.txtshouldYearBouns.setDataType(1);		
        this.txtshouldYearBouns.setSupportedEmpty(true);		
        this.txtshouldYearBouns.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtshouldYearBouns.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtshouldYearBouns.setPrecision(10);		
        this.txtshouldYearBouns.setRequired(false);
        // txtyearTax		
        this.txtyearTax.setHorizontalAlignment(2);		
        this.txtyearTax.setDataType(1);		
        this.txtyearTax.setSupportedEmpty(true);		
        this.txtyearTax.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtyearTax.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtyearTax.setPrecision(10);		
        this.txtyearTax.setRequired(false);
        // txtrealyearAmount		
        this.txtrealyearAmount.setHorizontalAlignment(2);		
        this.txtrealyearAmount.setDataType(1);		
        this.txtrealyearAmount.setSupportedEmpty(true);		
        this.txtrealyearAmount.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtrealyearAmount.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtrealyearAmount.setPrecision(10);		
        this.txtrealyearAmount.setRequired(false);
        // txtrealAmount		
        this.txtrealAmount.setHorizontalAlignment(2);		
        this.txtrealAmount.setDataType(1);		
        this.txtrealAmount.setSupportedEmpty(true);		
        this.txtrealAmount.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtrealAmount.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtrealAmount.setPrecision(10);		
        this.txtrealAmount.setRequired(false);
        // txtshuijin		
        this.txtshuijin.setHorizontalAlignment(2);		
        this.txtshuijin.setDataType(1);		
        this.txtshuijin.setSupportedEmpty(true);		
        this.txtshuijin.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtshuijin.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtshuijin.setPrecision(10);		
        this.txtshuijin.setRequired(false);
        // txtcomAll		
        this.txtcomAll.setHorizontalAlignment(2);		
        this.txtcomAll.setDataType(1);		
        this.txtcomAll.setSupportedEmpty(true);		
        this.txtcomAll.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtcomAll.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtcomAll.setPrecision(10);		
        this.txtcomAll.setRequired(false);
        // txtLC		
        this.txtLC.setHorizontalAlignment(2);		
        this.txtLC.setDataType(1);		
        this.txtLC.setSupportedEmpty(true);		
        this.txtLC.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtLC.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtLC.setPrecision(10);		
        this.txtLC.setRequired(false);
        // txtbasemoney		
        this.txtbasemoney.setHorizontalAlignment(2);		
        this.txtbasemoney.setDataType(1);		
        this.txtbasemoney.setSupportedEmpty(true);		
        this.txtbasemoney.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtbasemoney.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtbasemoney.setPrecision(10);		
        this.txtbasemoney.setRequired(false);
        // txtfentanother		
        this.txtfentanother.setHorizontalAlignment(2);		
        this.txtfentanother.setDataType(1);		
        this.txtfentanother.setSupportedEmpty(true);		
        this.txtfentanother.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtfentanother.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtfentanother.setPrecision(10);		
        this.txtfentanother.setRequired(false);
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
        // txtyuedurenliAll		
        this.txtyuedurenliAll.setHorizontalAlignment(2);		
        this.txtyuedurenliAll.setDataType(1);		
        this.txtyuedurenliAll.setSupportedEmpty(true);		
        this.txtyuedurenliAll.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtyuedurenliAll.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtyuedurenliAll.setPrecision(10);		
        this.txtyuedurenliAll.setRequired(false);
        // txtdocAssCost		
        this.txtdocAssCost.setHorizontalAlignment(2);		
        this.txtdocAssCost.setDataType(1);		
        this.txtdocAssCost.setSupportedEmpty(true);		
        this.txtdocAssCost.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtdocAssCost.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtdocAssCost.setPrecision(10);		
        this.txtdocAssCost.setRequired(false);
        // txtclinicAchiMoney		
        this.txtclinicAchiMoney.setHorizontalAlignment(2);		
        this.txtclinicAchiMoney.setDataType(1);		
        this.txtclinicAchiMoney.setSupportedEmpty(true);		
        this.txtclinicAchiMoney.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtclinicAchiMoney.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtclinicAchiMoney.setPrecision(10);		
        this.txtclinicAchiMoney.setRequired(false);
        // txtassToDoc		
        this.txtassToDoc.setHorizontalAlignment(2);		
        this.txtassToDoc.setDataType(1);		
        this.txtassToDoc.setSupportedEmpty(true);		
        this.txtassToDoc.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtassToDoc.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtassToDoc.setPrecision(10);		
        this.txtassToDoc.setRequired(false);
        // txtBaoDiBonus		
        this.txtBaoDiBonus.setVisible(true);		
        this.txtBaoDiBonus.setHorizontalAlignment(2);		
        this.txtBaoDiBonus.setDataType(1);		
        this.txtBaoDiBonus.setSupportedEmpty(true);		
        this.txtBaoDiBonus.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtBaoDiBonus.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtBaoDiBonus.setPrecision(10);		
        this.txtBaoDiBonus.setRequired(false);
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {txtName,txtNumber,txtDescription,txtSimpleName,txtcityid,txtcityNumber,txtcityName,txtcompanyid,txtcompanyNumber,txtcompanyName,txtpersonid,txtpersonNumber,txtpersonName,txtcostCenterNumber,txtpostTypeNumber,txtiscount,txtbusinessdate,txtpost,txtemptype,txtpostType,txtindate,txtleaveDate,txtworkYear,txtbingjiaPro,txtcardNumber,txtjibengongzi,txtpostAllow,txtworkYearAllow,txtlearnAllow,txtcardAllow,txthouseAllow,txtachieveMoney,txtmonthMoney,txtqueqin,txtshijia,txtbingjia,txtkaoqinSub,txtchidaoSub,txtgdAllow,txtallWorkAllow,txtfoodAllow,txtaddWorkAllow,txtother,txtgdMoney,txtXRayAllow,txtholderMoney,txtassMoney,txtzbPro,txtshopHelp,txtzxCard,txtsplitUp,txtzxLeave,txtdocLeave,txtdocAssCost,txtassToDoc,txtotherWaiMoney,txtwaiAllMoney,txtmarktMoney,txtscalMoney,txtmbAmount,txtdocAmount,txtclinicAchiMoney,txtshopTarMoney,txtkfAmount,txthlAmount,txtzxAmount,txtotherNeiMoney,txtbdProjectAll,txtmonthBase,txtbdMonthProject,txtpayble,txtachieveAll,txtseaBase,txtseaBuzu,txtshouldPay,txtrealShouldPay,txtperYanglao,txtperYiliao,txtperDaBing,txtperShiye,txtperGongjijin,txtperAll,txtbeforeTaxMoney,txtfreeTaxMoney,txtgrzxkcAmount,txtljyssde,txtyssde,txttax,txtsjkcs,txtljgrsds,txtdkgrsds,txtmwBase,txtdianpingSub,txtkfSub,txtpayUp,txtbuchangAmount,txtshifa,txttiepiao,txtguaiaitong,txtlaowuMoney,txtqitamoshi,txtjifenAll,txttiepiaoSer,txtguanaitongSer,txtshouxufei,txtotherSer,txtserviceAll,txtshouldYearBouns,txtyearTax,txtrealyearAmount,txtrealAmount,txtcomyanglao,txtcomyiliao,txtcomdabing,txtcomshiye,txtcomgongshang,txtcomshengyu,txtcomgongjijin,txtfuwufei,txtshuijin,txtcomAll,txtLC,txtbasemoney,txtfentanother,txtnianzhongfentan,txtjidufentan,txtnianzhong,txtjidu,txtyuedurenliAll,txtyingshuiMoney,txtgeshui,txtBaoDiBonus}));
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
        this.setBounds(new Rectangle(0, 0, 1013, 1085));
        this.setLayout(null);
        kDLabelContainer1.setBounds(new Rectangle(672, 1018, 270, 19));
        this.add(kDLabelContainer1, null);
        kDLabelContainer2.setBounds(new Rectangle(672, 994, 270, 19));
        this.add(kDLabelContainer2, null);
        kDLabelContainer3.setBounds(new Rectangle(341, 1018, 270, 19));
        this.add(kDLabelContainer3, null);
        kDLabelContainer4.setBounds(new Rectangle(341, 1042, 270, 19));
        this.add(kDLabelContainer4, null);
        contcityid.setBounds(new Rectangle(10, 10, 270, 19));
        this.add(contcityid, null);
        contcompanyid.setBounds(new Rectangle(10, 34, 270, 19));
        this.add(contcompanyid, null);
        contpersonid.setBounds(new Rectangle(10, 58, 270, 19));
        this.add(contpersonid, null);
        contcostCenterNumber.setBounds(new Rectangle(341, 82, 270, 19));
        this.add(contcostCenterNumber, null);
        contpostTypeNumber.setBounds(new Rectangle(341, 106, 270, 19));
        this.add(contpostTypeNumber, null);
        contiscount.setBounds(new Rectangle(672, 82, 270, 19));
        this.add(contiscount, null);
        contbusinessdate.setBounds(new Rectangle(10, 82, 270, 19));
        this.add(contbusinessdate, null);
        contjibengongzi.setBounds(new Rectangle(672, 154, 270, 19));
        this.add(contjibengongzi, null);
        conttiepiao.setBounds(new Rectangle(672, 706, 270, 19));
        this.add(conttiepiao, null);
        contguaiaitong.setBounds(new Rectangle(341, 730, 270, 19));
        this.add(contguaiaitong, null);
        contlaowuMoney.setBounds(new Rectangle(672, 730, 270, 19));
        this.add(contlaowuMoney, null);
        contqitamoshi.setBounds(new Rectangle(672, 754, 270, 19));
        this.add(contqitamoshi, null);
        contyingshuiMoney.setBounds(new Rectangle(341, 922, 270, 19));
        this.add(contyingshuiMoney, null);
        contshouxufei.setBounds(new Rectangle(672, 778, 270, 19));
        this.add(contshouxufei, null);
        contcomyanglao.setBounds(new Rectangle(341, 826, 270, 19));
        this.add(contcomyanglao, null);
        contcomyiliao.setBounds(new Rectangle(672, 826, 270, 19));
        this.add(contcomyiliao, null);
        contcomshiye.setBounds(new Rectangle(341, 850, 270, 19));
        this.add(contcomshiye, null);
        contcomgongshang.setBounds(new Rectangle(672, 850, 270, 19));
        this.add(contcomgongshang, null);
        contcomshengyu.setBounds(new Rectangle(341, 874, 270, 19));
        this.add(contcomshengyu, null);
        contcomgongjijin.setBounds(new Rectangle(672, 874, 270, 19));
        this.add(contcomgongjijin, null);
        contfuwufei.setBounds(new Rectangle(672, 898, 270, 19));
        this.add(contfuwufei, null);
        contperYanglao.setBounds(new Rectangle(672, 538, 270, 19));
        this.add(contperYanglao, null);
        contperYiliao.setBounds(new Rectangle(341, 562, 270, 19));
        this.add(contperYiliao, null);
        contperShiye.setBounds(new Rectangle(672, 562, 270, 19));
        this.add(contperShiye, null);
        contperGongjijin.setBounds(new Rectangle(672, 586, 270, 19));
        this.add(contperGongjijin, null);
        contgeshui.setBounds(new Rectangle(672, 922, 270, 19));
        this.add(contgeshui, null);
        contshifa.setBounds(new Rectangle(341, 706, 270, 19));
        this.add(contshifa, null);
        contcomdabing.setBounds(new Rectangle(341, 898, 270, 19));
        this.add(contcomdabing, null);
        contemptype.setBounds(new Rectangle(672, 946, 270, 19));
        this.add(contemptype, null);
        contcityNumber.setBounds(new Rectangle(341, 10, 270, 19));
        this.add(contcityNumber, null);
        contcityName.setBounds(new Rectangle(672, 10, 270, 19));
        this.add(contcityName, null);
        contcompanyNumber.setBounds(new Rectangle(341, 34, 270, 19));
        this.add(contcompanyNumber, null);
        contcompanyName.setBounds(new Rectangle(672, 34, 270, 19));
        this.add(contcompanyName, null);
        contpersonNumber.setBounds(new Rectangle(341, 58, 270, 19));
        this.add(contpersonNumber, null);
        contpersonName.setBounds(new Rectangle(672, 58, 270, 19));
        this.add(contpersonName, null);
        contpost.setBounds(new Rectangle(10, 106, 270, 19));
        this.add(contpost, null);
        contpostType.setBounds(new Rectangle(672, 106, 270, 19));
        this.add(contpostType, null);
        contindate.setBounds(new Rectangle(10, 130, 270, 19));
        this.add(contindate, null);
        contleaveDate.setBounds(new Rectangle(341, 130, 270, 19));
        this.add(contleaveDate, null);
        contworkYear.setBounds(new Rectangle(672, 130, 270, 19));
        this.add(contworkYear, null);
        contbingjiaPro.setBounds(new Rectangle(10, 154, 270, 19));
        this.add(contbingjiaPro, null);
        contcardNumber.setBounds(new Rectangle(341, 154, 270, 19));
        this.add(contcardNumber, null);
        contpostAllow.setBounds(new Rectangle(10, 178, 270, 19));
        this.add(contpostAllow, null);
        contworkYearAllow.setBounds(new Rectangle(341, 178, 270, 19));
        this.add(contworkYearAllow, null);
        contlearnAllow.setBounds(new Rectangle(672, 178, 270, 19));
        this.add(contlearnAllow, null);
        contcardAllow.setBounds(new Rectangle(10, 202, 270, 19));
        this.add(contcardAllow, null);
        conthouseAllow.setBounds(new Rectangle(341, 202, 270, 19));
        this.add(conthouseAllow, null);
        contachieveMoney.setBounds(new Rectangle(672, 202, 270, 19));
        this.add(contachieveMoney, null);
        contmonthMoney.setBounds(new Rectangle(10, 226, 270, 19));
        this.add(contmonthMoney, null);
        contqueqin.setBounds(new Rectangle(341, 226, 270, 19));
        this.add(contqueqin, null);
        contshijia.setBounds(new Rectangle(672, 226, 270, 19));
        this.add(contshijia, null);
        contbingjia.setBounds(new Rectangle(10, 250, 270, 19));
        this.add(contbingjia, null);
        contkaoqinSub.setBounds(new Rectangle(341, 250, 270, 19));
        this.add(contkaoqinSub, null);
        contchidaoSub.setBounds(new Rectangle(672, 250, 270, 19));
        this.add(contchidaoSub, null);
        contgdAllow.setBounds(new Rectangle(10, 274, 270, 19));
        this.add(contgdAllow, null);
        contallWorkAllow.setBounds(new Rectangle(341, 274, 270, 19));
        this.add(contallWorkAllow, null);
        contfoodAllow.setBounds(new Rectangle(672, 274, 270, 19));
        this.add(contfoodAllow, null);
        contaddWorkAllow.setBounds(new Rectangle(10, 298, 270, 19));
        this.add(contaddWorkAllow, null);
        contother.setBounds(new Rectangle(341, 298, 270, 19));
        this.add(contother, null);
        contgdMoney.setBounds(new Rectangle(672, 298, 270, 19));
        this.add(contgdMoney, null);
        contXRayAllow.setBounds(new Rectangle(10, 322, 270, 19));
        this.add(contXRayAllow, null);
        contholderMoney.setBounds(new Rectangle(341, 322, 270, 19));
        this.add(contholderMoney, null);
        contassMoney.setBounds(new Rectangle(672, 322, 270, 19));
        this.add(contassMoney, null);
        contzbPro.setBounds(new Rectangle(10, 346, 270, 19));
        this.add(contzbPro, null);
        contshopHelp.setBounds(new Rectangle(341, 346, 270, 19));
        this.add(contshopHelp, null);
        contzxCard.setBounds(new Rectangle(672, 346, 270, 19));
        this.add(contzxCard, null);
        contsplitUp.setBounds(new Rectangle(10, 370, 270, 19));
        this.add(contsplitUp, null);
        contzxLeave.setBounds(new Rectangle(341, 370, 270, 19));
        this.add(contzxLeave, null);
        contdocLeave.setBounds(new Rectangle(672, 370, 270, 19));
        this.add(contdocLeave, null);
        contotherWaiMoney.setBounds(new Rectangle(672, 394, 270, 19));
        this.add(contotherWaiMoney, null);
        contwaiAllMoney.setBounds(new Rectangle(10, 418, 270, 19));
        this.add(contwaiAllMoney, null);
        contmarktMoney.setBounds(new Rectangle(341, 418, 270, 19));
        this.add(contmarktMoney, null);
        contscalMoney.setBounds(new Rectangle(672, 418, 270, 19));
        this.add(contscalMoney, null);
        contmbAmount.setBounds(new Rectangle(10, 442, 270, 19));
        this.add(contmbAmount, null);
        contdocAmount.setBounds(new Rectangle(341, 442, 270, 19));
        this.add(contdocAmount, null);
        contkfAmount.setBounds(new Rectangle(672, 442, 270, 19));
        this.add(contkfAmount, null);
        conthlAmount.setBounds(new Rectangle(10, 466, 270, 19));
        this.add(conthlAmount, null);
        contzxAmount.setBounds(new Rectangle(341, 466, 270, 19));
        this.add(contzxAmount, null);
        contshopTarMoney.setBounds(new Rectangle(672, 466, 270, 19));
        this.add(contshopTarMoney, null);
        contotherNeiMoney.setBounds(new Rectangle(341, 490, 270, 19));
        this.add(contotherNeiMoney, null);
        contbdProjectAll.setBounds(new Rectangle(672, 490, 270, 19));
        this.add(contbdProjectAll, null);
        contmonthBase.setBounds(new Rectangle(10, 514, 270, 19));
        this.add(contmonthBase, null);
        contbdMonthProject.setBounds(new Rectangle(341, 514, 270, 19));
        this.add(contbdMonthProject, null);
        contpayble.setBounds(new Rectangle(672, 514, 270, 19));
        this.add(contpayble, null);
        contachieveAll.setBounds(new Rectangle(10, 538, 270, 19));
        this.add(contachieveAll, null);
        contseaBase.setBounds(new Rectangle(341, 538, 270, 19));
        this.add(contseaBase, null);
        contseaBuzu.setBounds(new Rectangle(10, 562, 270, 19));
        this.add(contseaBuzu, null);
        contshouldPay.setBounds(new Rectangle(10, 586, 270, 19));
        this.add(contshouldPay, null);
        contrealShouldPay.setBounds(new Rectangle(341, 586, 270, 19));
        this.add(contrealShouldPay, null);
        contperDaBing.setBounds(new Rectangle(10, 610, 270, 19));
        this.add(contperDaBing, null);
        contperAll.setBounds(new Rectangle(341, 610, 270, 19));
        this.add(contperAll, null);
        contbeforeTaxMoney.setBounds(new Rectangle(672, 610, 270, 19));
        this.add(contbeforeTaxMoney, null);
        contfreeTaxMoney.setBounds(new Rectangle(10, 634, 270, 19));
        this.add(contfreeTaxMoney, null);
        contljyssde.setBounds(new Rectangle(341, 634, 270, 19));
        this.add(contljyssde, null);
        contgrzxkcAmount.setBounds(new Rectangle(672, 634, 270, 19));
        this.add(contgrzxkcAmount, null);
        contyssde.setBounds(new Rectangle(10, 658, 270, 19));
        this.add(contyssde, null);
        conttax.setBounds(new Rectangle(341, 658, 270, 19));
        this.add(conttax, null);
        contsjkcs.setBounds(new Rectangle(672, 658, 270, 19));
        this.add(contsjkcs, null);
        contljgrsds.setBounds(new Rectangle(10, 682, 270, 19));
        this.add(contljgrsds, null);
        contdkgrsds.setBounds(new Rectangle(341, 682, 270, 19));
        this.add(contdkgrsds, null);
        contmwBase.setBounds(new Rectangle(672, 682, 270, 19));
        this.add(contmwBase, null);
        contdianpingSub.setBounds(new Rectangle(10, 706, 270, 19));
        this.add(contdianpingSub, null);
        contkfSub.setBounds(new Rectangle(10, 730, 270, 19));
        this.add(contkfSub, null);
        contpayUp.setBounds(new Rectangle(10, 754, 270, 19));
        this.add(contpayUp, null);
        contbuchangAmount.setBounds(new Rectangle(341, 754, 270, 19));
        this.add(contbuchangAmount, null);
        contjifenAll.setBounds(new Rectangle(10, 778, 270, 19));
        this.add(contjifenAll, null);
        conttiepiaoSer.setBounds(new Rectangle(341, 778, 270, 19));
        this.add(conttiepiaoSer, null);
        contguanaitongSer.setBounds(new Rectangle(10, 802, 270, 19));
        this.add(contguanaitongSer, null);
        contotherSer.setBounds(new Rectangle(341, 802, 270, 19));
        this.add(contotherSer, null);
        contserviceAll.setBounds(new Rectangle(672, 802, 270, 19));
        this.add(contserviceAll, null);
        contshouldYearBouns.setBounds(new Rectangle(10, 826, 270, 19));
        this.add(contshouldYearBouns, null);
        contyearTax.setBounds(new Rectangle(10, 850, 270, 19));
        this.add(contyearTax, null);
        contrealyearAmount.setBounds(new Rectangle(10, 874, 270, 19));
        this.add(contrealyearAmount, null);
        contrealAmount.setBounds(new Rectangle(10, 898, 270, 19));
        this.add(contrealAmount, null);
        contshuijin.setBounds(new Rectangle(10, 922, 270, 19));
        this.add(contshuijin, null);
        contcomAll.setBounds(new Rectangle(10, 946, 270, 19));
        this.add(contcomAll, null);
        contLC.setBounds(new Rectangle(341, 946, 270, 19));
        this.add(contLC, null);
        contbasemoney.setBounds(new Rectangle(10, 970, 270, 19));
        this.add(contbasemoney, null);
        contfentanother.setBounds(new Rectangle(341, 970, 270, 19));
        this.add(contfentanother, null);
        contnianzhongfentan.setBounds(new Rectangle(672, 970, 270, 19));
        this.add(contnianzhongfentan, null);
        contjidufentan.setBounds(new Rectangle(10, 994, 270, 19));
        this.add(contjidufentan, null);
        contnianzhong.setBounds(new Rectangle(341, 994, 270, 19));
        this.add(contnianzhong, null);
        contjidu.setBounds(new Rectangle(10, 1018, 270, 19));
        this.add(contjidu, null);
        contyuedurenliAll.setBounds(new Rectangle(10, 1042, 270, 19));
        this.add(contyuedurenliAll, null);
        contdocAssCost.setBounds(new Rectangle(10, 394, 270, 19));
        this.add(contdocAssCost, null);
        contclinicAchiMoney.setBounds(new Rectangle(10, 490, 270, 19));
        this.add(contclinicAchiMoney, null);
        contassToDoc.setBounds(new Rectangle(341, 394, 270, 19));
        this.add(contassToDoc, null);
        contBaoDiBonus.setBounds(new Rectangle(672, 1042, 270, 19));
        this.add(contBaoDiBonus, null);
        //kDLabelContainer1
        kDLabelContainer1.setBoundEditor(txtNumber);
        //kDLabelContainer2
        kDLabelContainer2.setBoundEditor(txtName);
        //kDLabelContainer3
        kDLabelContainer3.setBoundEditor(txtSimpleName);
        //kDLabelContainer4
        kDLabelContainer4.setBoundEditor(txtDescription);
        //contcityid
        contcityid.setBoundEditor(txtcityid);
        //contcompanyid
        contcompanyid.setBoundEditor(txtcompanyid);
        //contpersonid
        contpersonid.setBoundEditor(txtpersonid);
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
        //contcomdabing
        contcomdabing.setBoundEditor(txtcomdabing);
        //contemptype
        contemptype.setBoundEditor(txtemptype);
        //contcityNumber
        contcityNumber.setBoundEditor(txtcityNumber);
        //contcityName
        contcityName.setBoundEditor(txtcityName);
        //contcompanyNumber
        contcompanyNumber.setBoundEditor(txtcompanyNumber);
        //contcompanyName
        contcompanyName.setBoundEditor(txtcompanyName);
        //contpersonNumber
        contpersonNumber.setBoundEditor(txtpersonNumber);
        //contpersonName
        contpersonName.setBoundEditor(txtpersonName);
        //contpost
        contpost.setBoundEditor(txtpost);
        //contpostType
        contpostType.setBoundEditor(txtpostType);
        //contindate
        contindate.setBoundEditor(txtindate);
        //contleaveDate
        contleaveDate.setBoundEditor(txtleaveDate);
        //contworkYear
        contworkYear.setBoundEditor(txtworkYear);
        //contbingjiaPro
        contbingjiaPro.setBoundEditor(txtbingjiaPro);
        //contcardNumber
        contcardNumber.setBoundEditor(txtcardNumber);
        //contpostAllow
        contpostAllow.setBoundEditor(txtpostAllow);
        //contworkYearAllow
        contworkYearAllow.setBoundEditor(txtworkYearAllow);
        //contlearnAllow
        contlearnAllow.setBoundEditor(txtlearnAllow);
        //contcardAllow
        contcardAllow.setBoundEditor(txtcardAllow);
        //conthouseAllow
        conthouseAllow.setBoundEditor(txthouseAllow);
        //contachieveMoney
        contachieveMoney.setBoundEditor(txtachieveMoney);
        //contmonthMoney
        contmonthMoney.setBoundEditor(txtmonthMoney);
        //contqueqin
        contqueqin.setBoundEditor(txtqueqin);
        //contshijia
        contshijia.setBoundEditor(txtshijia);
        //contbingjia
        contbingjia.setBoundEditor(txtbingjia);
        //contkaoqinSub
        contkaoqinSub.setBoundEditor(txtkaoqinSub);
        //contchidaoSub
        contchidaoSub.setBoundEditor(txtchidaoSub);
        //contgdAllow
        contgdAllow.setBoundEditor(txtgdAllow);
        //contallWorkAllow
        contallWorkAllow.setBoundEditor(txtallWorkAllow);
        //contfoodAllow
        contfoodAllow.setBoundEditor(txtfoodAllow);
        //contaddWorkAllow
        contaddWorkAllow.setBoundEditor(txtaddWorkAllow);
        //contother
        contother.setBoundEditor(txtother);
        //contgdMoney
        contgdMoney.setBoundEditor(txtgdMoney);
        //contXRayAllow
        contXRayAllow.setBoundEditor(txtXRayAllow);
        //contholderMoney
        contholderMoney.setBoundEditor(txtholderMoney);
        //contassMoney
        contassMoney.setBoundEditor(txtassMoney);
        //contzbPro
        contzbPro.setBoundEditor(txtzbPro);
        //contshopHelp
        contshopHelp.setBoundEditor(txtshopHelp);
        //contzxCard
        contzxCard.setBoundEditor(txtzxCard);
        //contsplitUp
        contsplitUp.setBoundEditor(txtsplitUp);
        //contzxLeave
        contzxLeave.setBoundEditor(txtzxLeave);
        //contdocLeave
        contdocLeave.setBoundEditor(txtdocLeave);
        //contotherWaiMoney
        contotherWaiMoney.setBoundEditor(txtotherWaiMoney);
        //contwaiAllMoney
        contwaiAllMoney.setBoundEditor(txtwaiAllMoney);
        //contmarktMoney
        contmarktMoney.setBoundEditor(txtmarktMoney);
        //contscalMoney
        contscalMoney.setBoundEditor(txtscalMoney);
        //contmbAmount
        contmbAmount.setBoundEditor(txtmbAmount);
        //contdocAmount
        contdocAmount.setBoundEditor(txtdocAmount);
        //contkfAmount
        contkfAmount.setBoundEditor(txtkfAmount);
        //conthlAmount
        conthlAmount.setBoundEditor(txthlAmount);
        //contzxAmount
        contzxAmount.setBoundEditor(txtzxAmount);
        //contshopTarMoney
        contshopTarMoney.setBoundEditor(txtshopTarMoney);
        //contotherNeiMoney
        contotherNeiMoney.setBoundEditor(txtotherNeiMoney);
        //contbdProjectAll
        contbdProjectAll.setBoundEditor(txtbdProjectAll);
        //contmonthBase
        contmonthBase.setBoundEditor(txtmonthBase);
        //contbdMonthProject
        contbdMonthProject.setBoundEditor(txtbdMonthProject);
        //contpayble
        contpayble.setBoundEditor(txtpayble);
        //contachieveAll
        contachieveAll.setBoundEditor(txtachieveAll);
        //contseaBase
        contseaBase.setBoundEditor(txtseaBase);
        //contseaBuzu
        contseaBuzu.setBoundEditor(txtseaBuzu);
        //contshouldPay
        contshouldPay.setBoundEditor(txtshouldPay);
        //contrealShouldPay
        contrealShouldPay.setBoundEditor(txtrealShouldPay);
        //contperDaBing
        contperDaBing.setBoundEditor(txtperDaBing);
        //contperAll
        contperAll.setBoundEditor(txtperAll);
        //contbeforeTaxMoney
        contbeforeTaxMoney.setBoundEditor(txtbeforeTaxMoney);
        //contfreeTaxMoney
        contfreeTaxMoney.setBoundEditor(txtfreeTaxMoney);
        //contljyssde
        contljyssde.setBoundEditor(txtljyssde);
        //contgrzxkcAmount
        contgrzxkcAmount.setBoundEditor(txtgrzxkcAmount);
        //contyssde
        contyssde.setBoundEditor(txtyssde);
        //conttax
        conttax.setBoundEditor(txttax);
        //contsjkcs
        contsjkcs.setBoundEditor(txtsjkcs);
        //contljgrsds
        contljgrsds.setBoundEditor(txtljgrsds);
        //contdkgrsds
        contdkgrsds.setBoundEditor(txtdkgrsds);
        //contmwBase
        contmwBase.setBoundEditor(txtmwBase);
        //contdianpingSub
        contdianpingSub.setBoundEditor(txtdianpingSub);
        //contkfSub
        contkfSub.setBoundEditor(txtkfSub);
        //contpayUp
        contpayUp.setBoundEditor(txtpayUp);
        //contbuchangAmount
        contbuchangAmount.setBoundEditor(txtbuchangAmount);
        //contjifenAll
        contjifenAll.setBoundEditor(txtjifenAll);
        //conttiepiaoSer
        conttiepiaoSer.setBoundEditor(txttiepiaoSer);
        //contguanaitongSer
        contguanaitongSer.setBoundEditor(txtguanaitongSer);
        //contotherSer
        contotherSer.setBoundEditor(txtotherSer);
        //contserviceAll
        contserviceAll.setBoundEditor(txtserviceAll);
        //contshouldYearBouns
        contshouldYearBouns.setBoundEditor(txtshouldYearBouns);
        //contyearTax
        contyearTax.setBoundEditor(txtyearTax);
        //contrealyearAmount
        contrealyearAmount.setBoundEditor(txtrealyearAmount);
        //contrealAmount
        contrealAmount.setBoundEditor(txtrealAmount);
        //contshuijin
        contshuijin.setBoundEditor(txtshuijin);
        //contcomAll
        contcomAll.setBoundEditor(txtcomAll);
        //contLC
        contLC.setBoundEditor(txtLC);
        //contbasemoney
        contbasemoney.setBoundEditor(txtbasemoney);
        //contfentanother
        contfentanother.setBoundEditor(txtfentanother);
        //contnianzhongfentan
        contnianzhongfentan.setBoundEditor(txtnianzhongfentan);
        //contjidufentan
        contjidufentan.setBoundEditor(txtjidufentan);
        //contnianzhong
        contnianzhong.setBoundEditor(txtnianzhong);
        //contjidu
        contjidu.setBoundEditor(txtjidu);
        //contyuedurenliAll
        contyuedurenliAll.setBoundEditor(txtyuedurenliAll);
        //contdocAssCost
        contdocAssCost.setBoundEditor(txtdocAssCost);
        //contclinicAchiMoney
        contclinicAchiMoney.setBoundEditor(txtclinicAchiMoney);
        //contassToDoc
        contassToDoc.setBoundEditor(txtassToDoc);
        //contBaoDiBonus
        contBaoDiBonus.setBoundEditor(txtBaoDiBonus);

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
		dataBinder.registerBinding("cityid", String.class, this.txtcityid, "text");
		dataBinder.registerBinding("companyid", String.class, this.txtcompanyid, "text");
		dataBinder.registerBinding("personid", String.class, this.txtpersonid, "text");
		dataBinder.registerBinding("costCenterNumber", String.class, this.txtcostCenterNumber, "text");
		dataBinder.registerBinding("postTypeNumber", String.class, this.txtpostTypeNumber, "text");
		dataBinder.registerBinding("iscount", String.class, this.txtiscount, "text");
		dataBinder.registerBinding("businessdate", String.class, this.txtbusinessdate, "text");
		dataBinder.registerBinding("jibengongzi", java.math.BigDecimal.class, this.txtjibengongzi, "value");
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
		dataBinder.registerBinding("perYanglao", java.math.BigDecimal.class, this.txtperYanglao, "value");
		dataBinder.registerBinding("perYiliao", java.math.BigDecimal.class, this.txtperYiliao, "value");
		dataBinder.registerBinding("perShiye", java.math.BigDecimal.class, this.txtperShiye, "value");
		dataBinder.registerBinding("perGongjijin", java.math.BigDecimal.class, this.txtperGongjijin, "value");
		dataBinder.registerBinding("geshui", java.math.BigDecimal.class, this.txtgeshui, "value");
		dataBinder.registerBinding("shifa", java.math.BigDecimal.class, this.txtshifa, "value");
		dataBinder.registerBinding("comdabing", java.math.BigDecimal.class, this.txtcomdabing, "value");
		dataBinder.registerBinding("emptype", String.class, this.txtemptype, "text");
		dataBinder.registerBinding("cityNumber", String.class, this.txtcityNumber, "text");
		dataBinder.registerBinding("cityName", String.class, this.txtcityName, "text");
		dataBinder.registerBinding("companyNumber", String.class, this.txtcompanyNumber, "text");
		dataBinder.registerBinding("companyName", String.class, this.txtcompanyName, "text");
		dataBinder.registerBinding("personNumber", String.class, this.txtpersonNumber, "text");
		dataBinder.registerBinding("personName", String.class, this.txtpersonName, "text");
		dataBinder.registerBinding("post", String.class, this.txtpost, "text");
		dataBinder.registerBinding("postType", String.class, this.txtpostType, "text");
		dataBinder.registerBinding("indate", String.class, this.txtindate, "text");
		dataBinder.registerBinding("leaveDate", String.class, this.txtleaveDate, "text");
		dataBinder.registerBinding("workYear", java.math.BigDecimal.class, this.txtworkYear, "value");
		dataBinder.registerBinding("bingjiaPro", java.math.BigDecimal.class, this.txtbingjiaPro, "value");
		dataBinder.registerBinding("cardNumber", String.class, this.txtcardNumber, "text");
		dataBinder.registerBinding("postAllow", java.math.BigDecimal.class, this.txtpostAllow, "value");
		dataBinder.registerBinding("workYearAllow", java.math.BigDecimal.class, this.txtworkYearAllow, "value");
		dataBinder.registerBinding("learnAllow", java.math.BigDecimal.class, this.txtlearnAllow, "value");
		dataBinder.registerBinding("cardAllow", java.math.BigDecimal.class, this.txtcardAllow, "value");
		dataBinder.registerBinding("houseAllow", java.math.BigDecimal.class, this.txthouseAllow, "value");
		dataBinder.registerBinding("achieveMoney", java.math.BigDecimal.class, this.txtachieveMoney, "value");
		dataBinder.registerBinding("monthMoney", java.math.BigDecimal.class, this.txtmonthMoney, "value");
		dataBinder.registerBinding("queqin", java.math.BigDecimal.class, this.txtqueqin, "value");
		dataBinder.registerBinding("shijia", java.math.BigDecimal.class, this.txtshijia, "value");
		dataBinder.registerBinding("bingjia", java.math.BigDecimal.class, this.txtbingjia, "value");
		dataBinder.registerBinding("kaoqinSub", java.math.BigDecimal.class, this.txtkaoqinSub, "value");
		dataBinder.registerBinding("chidaoSub", java.math.BigDecimal.class, this.txtchidaoSub, "value");
		dataBinder.registerBinding("gdAllow", java.math.BigDecimal.class, this.txtgdAllow, "value");
		dataBinder.registerBinding("allWorkAllow", java.math.BigDecimal.class, this.txtallWorkAllow, "value");
		dataBinder.registerBinding("foodAllow", java.math.BigDecimal.class, this.txtfoodAllow, "value");
		dataBinder.registerBinding("addWorkAllow", java.math.BigDecimal.class, this.txtaddWorkAllow, "value");
		dataBinder.registerBinding("other", java.math.BigDecimal.class, this.txtother, "value");
		dataBinder.registerBinding("gdMoney", java.math.BigDecimal.class, this.txtgdMoney, "value");
		dataBinder.registerBinding("XRayAllow", java.math.BigDecimal.class, this.txtXRayAllow, "value");
		dataBinder.registerBinding("holderMoney", java.math.BigDecimal.class, this.txtholderMoney, "value");
		dataBinder.registerBinding("assMoney", java.math.BigDecimal.class, this.txtassMoney, "value");
		dataBinder.registerBinding("zbPro", java.math.BigDecimal.class, this.txtzbPro, "value");
		dataBinder.registerBinding("shopHelp", java.math.BigDecimal.class, this.txtshopHelp, "value");
		dataBinder.registerBinding("zxCard", java.math.BigDecimal.class, this.txtzxCard, "value");
		dataBinder.registerBinding("splitUp", java.math.BigDecimal.class, this.txtsplitUp, "value");
		dataBinder.registerBinding("zxLeave", java.math.BigDecimal.class, this.txtzxLeave, "value");
		dataBinder.registerBinding("docLeave", java.math.BigDecimal.class, this.txtdocLeave, "value");
		dataBinder.registerBinding("otherWaiMoney", java.math.BigDecimal.class, this.txtotherWaiMoney, "value");
		dataBinder.registerBinding("waiAllMoney", java.math.BigDecimal.class, this.txtwaiAllMoney, "value");
		dataBinder.registerBinding("marktMoney", java.math.BigDecimal.class, this.txtmarktMoney, "value");
		dataBinder.registerBinding("scalMoney", java.math.BigDecimal.class, this.txtscalMoney, "value");
		dataBinder.registerBinding("mbAmount", java.math.BigDecimal.class, this.txtmbAmount, "value");
		dataBinder.registerBinding("docAmount", java.math.BigDecimal.class, this.txtdocAmount, "value");
		dataBinder.registerBinding("kfAmount", java.math.BigDecimal.class, this.txtkfAmount, "value");
		dataBinder.registerBinding("hlAmount", java.math.BigDecimal.class, this.txthlAmount, "value");
		dataBinder.registerBinding("zxAmount", java.math.BigDecimal.class, this.txtzxAmount, "value");
		dataBinder.registerBinding("shopTarMoney", java.math.BigDecimal.class, this.txtshopTarMoney, "value");
		dataBinder.registerBinding("otherNeiMoney", java.math.BigDecimal.class, this.txtotherNeiMoney, "value");
		dataBinder.registerBinding("bdProjectAll", java.math.BigDecimal.class, this.txtbdProjectAll, "value");
		dataBinder.registerBinding("monthBase", java.math.BigDecimal.class, this.txtmonthBase, "value");
		dataBinder.registerBinding("bdMonthProject", java.math.BigDecimal.class, this.txtbdMonthProject, "value");
		dataBinder.registerBinding("payble", java.math.BigDecimal.class, this.txtpayble, "value");
		dataBinder.registerBinding("achieveAll", java.math.BigDecimal.class, this.txtachieveAll, "value");
		dataBinder.registerBinding("seaBase", java.math.BigDecimal.class, this.txtseaBase, "value");
		dataBinder.registerBinding("seaBuzu", java.math.BigDecimal.class, this.txtseaBuzu, "value");
		dataBinder.registerBinding("shouldPay", java.math.BigDecimal.class, this.txtshouldPay, "value");
		dataBinder.registerBinding("realShouldPay", java.math.BigDecimal.class, this.txtrealShouldPay, "value");
		dataBinder.registerBinding("perDaBing", java.math.BigDecimal.class, this.txtperDaBing, "value");
		dataBinder.registerBinding("perAll", java.math.BigDecimal.class, this.txtperAll, "value");
		dataBinder.registerBinding("beforeTaxMoney", java.math.BigDecimal.class, this.txtbeforeTaxMoney, "value");
		dataBinder.registerBinding("freeTaxMoney", java.math.BigDecimal.class, this.txtfreeTaxMoney, "value");
		dataBinder.registerBinding("ljyssde", java.math.BigDecimal.class, this.txtljyssde, "value");
		dataBinder.registerBinding("grzxkcAmount", java.math.BigDecimal.class, this.txtgrzxkcAmount, "value");
		dataBinder.registerBinding("yssde", java.math.BigDecimal.class, this.txtyssde, "value");
		dataBinder.registerBinding("tax", java.math.BigDecimal.class, this.txttax, "value");
		dataBinder.registerBinding("sjkcs", java.math.BigDecimal.class, this.txtsjkcs, "value");
		dataBinder.registerBinding("ljgrsds", java.math.BigDecimal.class, this.txtljgrsds, "value");
		dataBinder.registerBinding("dkgrsds", java.math.BigDecimal.class, this.txtdkgrsds, "value");
		dataBinder.registerBinding("mwBase", java.math.BigDecimal.class, this.txtmwBase, "value");
		dataBinder.registerBinding("dianpingSub", java.math.BigDecimal.class, this.txtdianpingSub, "value");
		dataBinder.registerBinding("kfSub", java.math.BigDecimal.class, this.txtkfSub, "value");
		dataBinder.registerBinding("payUp", java.math.BigDecimal.class, this.txtpayUp, "value");
		dataBinder.registerBinding("buchangAmount", java.math.BigDecimal.class, this.txtbuchangAmount, "value");
		dataBinder.registerBinding("jifenAll", java.math.BigDecimal.class, this.txtjifenAll, "value");
		dataBinder.registerBinding("tiepiaoSer", java.math.BigDecimal.class, this.txttiepiaoSer, "value");
		dataBinder.registerBinding("guanaitongSer", java.math.BigDecimal.class, this.txtguanaitongSer, "value");
		dataBinder.registerBinding("otherSer", java.math.BigDecimal.class, this.txtotherSer, "value");
		dataBinder.registerBinding("serviceAll", java.math.BigDecimal.class, this.txtserviceAll, "value");
		dataBinder.registerBinding("shouldYearBouns", java.math.BigDecimal.class, this.txtshouldYearBouns, "value");
		dataBinder.registerBinding("yearTax", java.math.BigDecimal.class, this.txtyearTax, "value");
		dataBinder.registerBinding("realyearAmount", java.math.BigDecimal.class, this.txtrealyearAmount, "value");
		dataBinder.registerBinding("realAmount", java.math.BigDecimal.class, this.txtrealAmount, "value");
		dataBinder.registerBinding("shuijin", java.math.BigDecimal.class, this.txtshuijin, "value");
		dataBinder.registerBinding("comAll", java.math.BigDecimal.class, this.txtcomAll, "value");
		dataBinder.registerBinding("LC", java.math.BigDecimal.class, this.txtLC, "value");
		dataBinder.registerBinding("basemoney", java.math.BigDecimal.class, this.txtbasemoney, "value");
		dataBinder.registerBinding("fentanother", java.math.BigDecimal.class, this.txtfentanother, "value");
		dataBinder.registerBinding("nianzhongfentan", java.math.BigDecimal.class, this.txtnianzhongfentan, "value");
		dataBinder.registerBinding("jidufentan", java.math.BigDecimal.class, this.txtjidufentan, "value");
		dataBinder.registerBinding("nianzhong", java.math.BigDecimal.class, this.txtnianzhong, "value");
		dataBinder.registerBinding("jidu", java.math.BigDecimal.class, this.txtjidu, "value");
		dataBinder.registerBinding("yuedurenliAll", java.math.BigDecimal.class, this.txtyuedurenliAll, "value");
		dataBinder.registerBinding("docAssCost", java.math.BigDecimal.class, this.txtdocAssCost, "value");
		dataBinder.registerBinding("clinicAchiMoney", java.math.BigDecimal.class, this.txtclinicAchiMoney, "value");
		dataBinder.registerBinding("assToDoc", java.math.BigDecimal.class, this.txtassToDoc, "value");
		dataBinder.registerBinding("BaoDiBonus", java.math.BigDecimal.class, this.txtBaoDiBonus, "value");		
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
	    return "com.kingdee.eas.mw.pay.app.PaySheetDetailEditUIHandler";
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
        this.editData = (com.kingdee.eas.mw.pay.PaySheetDetailInfo)ov;
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
		getValidateHelper().registerBindProperty("cityid", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("companyid", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("personid", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("costCenterNumber", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("postTypeNumber", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("iscount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("businessdate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("jibengongzi", ValidateHelper.ON_SAVE);    
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
		getValidateHelper().registerBindProperty("perYanglao", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("perYiliao", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("perShiye", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("perGongjijin", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("geshui", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("shifa", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("comdabing", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("emptype", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("cityNumber", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("cityName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("companyNumber", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("companyName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("personNumber", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("personName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("post", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("postType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("indate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("leaveDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("workYear", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("bingjiaPro", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("cardNumber", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("postAllow", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("workYearAllow", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("learnAllow", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("cardAllow", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("houseAllow", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("achieveMoney", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("monthMoney", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("queqin", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("shijia", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("bingjia", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("kaoqinSub", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("chidaoSub", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("gdAllow", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("allWorkAllow", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("foodAllow", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("addWorkAllow", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("other", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("gdMoney", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("XRayAllow", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("holderMoney", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("assMoney", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("zbPro", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("shopHelp", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("zxCard", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("splitUp", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("zxLeave", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("docLeave", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("otherWaiMoney", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("waiAllMoney", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("marktMoney", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("scalMoney", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("mbAmount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("docAmount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("kfAmount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("hlAmount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("zxAmount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("shopTarMoney", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("otherNeiMoney", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("bdProjectAll", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("monthBase", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("bdMonthProject", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("payble", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("achieveAll", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("seaBase", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("seaBuzu", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("shouldPay", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("realShouldPay", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("perDaBing", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("perAll", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("beforeTaxMoney", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("freeTaxMoney", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("ljyssde", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("grzxkcAmount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("yssde", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("tax", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("sjkcs", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("ljgrsds", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("dkgrsds", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("mwBase", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("dianpingSub", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("kfSub", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("payUp", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("buchangAmount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("jifenAll", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("tiepiaoSer", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("guanaitongSer", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("otherSer", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("serviceAll", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("shouldYearBouns", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("yearTax", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("realyearAmount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("realAmount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("shuijin", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("comAll", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("LC", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("basemoney", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("fentanother", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("nianzhongfentan", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("jidufentan", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("nianzhong", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("jidu", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("yuedurenliAll", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("docAssCost", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("clinicAchiMoney", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("assToDoc", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("BaoDiBonus", ValidateHelper.ON_SAVE);    		
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
        sic.add(new SelectorItemInfo("cityid"));
        sic.add(new SelectorItemInfo("companyid"));
        sic.add(new SelectorItemInfo("personid"));
        sic.add(new SelectorItemInfo("costCenterNumber"));
        sic.add(new SelectorItemInfo("postTypeNumber"));
        sic.add(new SelectorItemInfo("iscount"));
        sic.add(new SelectorItemInfo("businessdate"));
        sic.add(new SelectorItemInfo("jibengongzi"));
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
        sic.add(new SelectorItemInfo("perYanglao"));
        sic.add(new SelectorItemInfo("perYiliao"));
        sic.add(new SelectorItemInfo("perShiye"));
        sic.add(new SelectorItemInfo("perGongjijin"));
        sic.add(new SelectorItemInfo("geshui"));
        sic.add(new SelectorItemInfo("shifa"));
        sic.add(new SelectorItemInfo("comdabing"));
        sic.add(new SelectorItemInfo("emptype"));
        sic.add(new SelectorItemInfo("cityNumber"));
        sic.add(new SelectorItemInfo("cityName"));
        sic.add(new SelectorItemInfo("companyNumber"));
        sic.add(new SelectorItemInfo("companyName"));
        sic.add(new SelectorItemInfo("personNumber"));
        sic.add(new SelectorItemInfo("personName"));
        sic.add(new SelectorItemInfo("post"));
        sic.add(new SelectorItemInfo("postType"));
        sic.add(new SelectorItemInfo("indate"));
        sic.add(new SelectorItemInfo("leaveDate"));
        sic.add(new SelectorItemInfo("workYear"));
        sic.add(new SelectorItemInfo("bingjiaPro"));
        sic.add(new SelectorItemInfo("cardNumber"));
        sic.add(new SelectorItemInfo("postAllow"));
        sic.add(new SelectorItemInfo("workYearAllow"));
        sic.add(new SelectorItemInfo("learnAllow"));
        sic.add(new SelectorItemInfo("cardAllow"));
        sic.add(new SelectorItemInfo("houseAllow"));
        sic.add(new SelectorItemInfo("achieveMoney"));
        sic.add(new SelectorItemInfo("monthMoney"));
        sic.add(new SelectorItemInfo("queqin"));
        sic.add(new SelectorItemInfo("shijia"));
        sic.add(new SelectorItemInfo("bingjia"));
        sic.add(new SelectorItemInfo("kaoqinSub"));
        sic.add(new SelectorItemInfo("chidaoSub"));
        sic.add(new SelectorItemInfo("gdAllow"));
        sic.add(new SelectorItemInfo("allWorkAllow"));
        sic.add(new SelectorItemInfo("foodAllow"));
        sic.add(new SelectorItemInfo("addWorkAllow"));
        sic.add(new SelectorItemInfo("other"));
        sic.add(new SelectorItemInfo("gdMoney"));
        sic.add(new SelectorItemInfo("XRayAllow"));
        sic.add(new SelectorItemInfo("holderMoney"));
        sic.add(new SelectorItemInfo("assMoney"));
        sic.add(new SelectorItemInfo("zbPro"));
        sic.add(new SelectorItemInfo("shopHelp"));
        sic.add(new SelectorItemInfo("zxCard"));
        sic.add(new SelectorItemInfo("splitUp"));
        sic.add(new SelectorItemInfo("zxLeave"));
        sic.add(new SelectorItemInfo("docLeave"));
        sic.add(new SelectorItemInfo("otherWaiMoney"));
        sic.add(new SelectorItemInfo("waiAllMoney"));
        sic.add(new SelectorItemInfo("marktMoney"));
        sic.add(new SelectorItemInfo("scalMoney"));
        sic.add(new SelectorItemInfo("mbAmount"));
        sic.add(new SelectorItemInfo("docAmount"));
        sic.add(new SelectorItemInfo("kfAmount"));
        sic.add(new SelectorItemInfo("hlAmount"));
        sic.add(new SelectorItemInfo("zxAmount"));
        sic.add(new SelectorItemInfo("shopTarMoney"));
        sic.add(new SelectorItemInfo("otherNeiMoney"));
        sic.add(new SelectorItemInfo("bdProjectAll"));
        sic.add(new SelectorItemInfo("monthBase"));
        sic.add(new SelectorItemInfo("bdMonthProject"));
        sic.add(new SelectorItemInfo("payble"));
        sic.add(new SelectorItemInfo("achieveAll"));
        sic.add(new SelectorItemInfo("seaBase"));
        sic.add(new SelectorItemInfo("seaBuzu"));
        sic.add(new SelectorItemInfo("shouldPay"));
        sic.add(new SelectorItemInfo("realShouldPay"));
        sic.add(new SelectorItemInfo("perDaBing"));
        sic.add(new SelectorItemInfo("perAll"));
        sic.add(new SelectorItemInfo("beforeTaxMoney"));
        sic.add(new SelectorItemInfo("freeTaxMoney"));
        sic.add(new SelectorItemInfo("ljyssde"));
        sic.add(new SelectorItemInfo("grzxkcAmount"));
        sic.add(new SelectorItemInfo("yssde"));
        sic.add(new SelectorItemInfo("tax"));
        sic.add(new SelectorItemInfo("sjkcs"));
        sic.add(new SelectorItemInfo("ljgrsds"));
        sic.add(new SelectorItemInfo("dkgrsds"));
        sic.add(new SelectorItemInfo("mwBase"));
        sic.add(new SelectorItemInfo("dianpingSub"));
        sic.add(new SelectorItemInfo("kfSub"));
        sic.add(new SelectorItemInfo("payUp"));
        sic.add(new SelectorItemInfo("buchangAmount"));
        sic.add(new SelectorItemInfo("jifenAll"));
        sic.add(new SelectorItemInfo("tiepiaoSer"));
        sic.add(new SelectorItemInfo("guanaitongSer"));
        sic.add(new SelectorItemInfo("otherSer"));
        sic.add(new SelectorItemInfo("serviceAll"));
        sic.add(new SelectorItemInfo("shouldYearBouns"));
        sic.add(new SelectorItemInfo("yearTax"));
        sic.add(new SelectorItemInfo("realyearAmount"));
        sic.add(new SelectorItemInfo("realAmount"));
        sic.add(new SelectorItemInfo("shuijin"));
        sic.add(new SelectorItemInfo("comAll"));
        sic.add(new SelectorItemInfo("LC"));
        sic.add(new SelectorItemInfo("basemoney"));
        sic.add(new SelectorItemInfo("fentanother"));
        sic.add(new SelectorItemInfo("nianzhongfentan"));
        sic.add(new SelectorItemInfo("jidufentan"));
        sic.add(new SelectorItemInfo("nianzhong"));
        sic.add(new SelectorItemInfo("jidu"));
        sic.add(new SelectorItemInfo("yuedurenliAll"));
        sic.add(new SelectorItemInfo("docAssCost"));
        sic.add(new SelectorItemInfo("clinicAchiMoney"));
        sic.add(new SelectorItemInfo("assToDoc"));
        sic.add(new SelectorItemInfo("BaoDiBonus"));
        return sic;
    }        

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.mw.pay.client", "PaySheetDetailEditUI");
    }

    /**
     * output getEditUIName method
     */
    protected String getEditUIName()
    {
        return com.kingdee.eas.mw.pay.client.PaySheetDetailEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.mw.pay.PaySheetDetailFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.mw.pay.PaySheetDetailInfo objectValue = new com.kingdee.eas.mw.pay.PaySheetDetailInfo();
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