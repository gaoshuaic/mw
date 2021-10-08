/**
 * output package name
 */
package com.kingdee.eas.mw.srqr.client;

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
public abstract class AbstractCityCompanyTargetEditUI extends com.kingdee.eas.framework.client.EditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractCityCompanyTargetEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer2;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer3;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer4;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcity;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcompany;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contpersonNum;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conttarachieve;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbudcost;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conttype;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contylyz;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contyzys;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contzzjyhs;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contzx;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contqt;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conthq;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contyzhs;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conthl;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contkf;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contrlxz;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contyh;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contzjb;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcw;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contqh;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contqd;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contwdzx;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contwl;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contxmt;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbusinessdate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcg;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contztb;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox txtName;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtSimpleName;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox txtDescription;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcity;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcompany;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtpersonNum;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txttarachieve;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtbudcost;
    protected com.kingdee.bos.ctrl.swing.KDComboBox type;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtylyz;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtyzys;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtzzjyhs;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtzx;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtqt;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txthq;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtyzhs;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txthl;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtkf;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtrlxz;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtyh;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtzjb;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtcw;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtqh;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtqd;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtwdzx;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtwl;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtxmt;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtbusinessdate;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtcg;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtztb;
    protected com.kingdee.eas.mw.srqr.CityCompanyTargetInfo editData = null;
    /**
     * output class constructor
     */
    public AbstractCityCompanyTargetEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractCityCompanyTargetEditUI.class.getName());
        this.setUITitle(resHelper.getString("this.title"));
        this.kDLabelContainer1 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer2 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer3 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer4 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcity = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcompany = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contpersonNum = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conttarachieve = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbudcost = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conttype = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contylyz = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contyzys = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contzzjyhs = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contzx = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contqt = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conthq = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contyzhs = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conthl = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contkf = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contrlxz = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contyh = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contzjb = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcw = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contqh = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contqd = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contwdzx = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contwl = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contxmt = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbusinessdate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcg = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contztb = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtName = new com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox();
        this.txtSimpleName = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtDescription = new com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox();
        this.prmtcity = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtcompany = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtpersonNum = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txttarachieve = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtbudcost = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.type = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.txtylyz = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtyzys = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtzzjyhs = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtzx = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtqt = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txthq = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtyzhs = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txthl = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtkf = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtrlxz = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtyh = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtzjb = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtcw = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtqh = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtqd = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtwdzx = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtwl = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtxmt = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtbusinessdate = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtcg = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtztb = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.kDLabelContainer1.setName("kDLabelContainer1");
        this.kDLabelContainer2.setName("kDLabelContainer2");
        this.kDLabelContainer3.setName("kDLabelContainer3");
        this.kDLabelContainer4.setName("kDLabelContainer4");
        this.contcity.setName("contcity");
        this.contcompany.setName("contcompany");
        this.contpersonNum.setName("contpersonNum");
        this.conttarachieve.setName("conttarachieve");
        this.contbudcost.setName("contbudcost");
        this.conttype.setName("conttype");
        this.contylyz.setName("contylyz");
        this.contyzys.setName("contyzys");
        this.contzzjyhs.setName("contzzjyhs");
        this.contzx.setName("contzx");
        this.contqt.setName("contqt");
        this.conthq.setName("conthq");
        this.contyzhs.setName("contyzhs");
        this.conthl.setName("conthl");
        this.contkf.setName("contkf");
        this.contrlxz.setName("contrlxz");
        this.contyh.setName("contyh");
        this.contzjb.setName("contzjb");
        this.contcw.setName("contcw");
        this.contqh.setName("contqh");
        this.contqd.setName("contqd");
        this.contwdzx.setName("contwdzx");
        this.contwl.setName("contwl");
        this.contxmt.setName("contxmt");
        this.contbusinessdate.setName("contbusinessdate");
        this.contcg.setName("contcg");
        this.contztb.setName("contztb");
        this.txtNumber.setName("txtNumber");
        this.txtName.setName("txtName");
        this.txtSimpleName.setName("txtSimpleName");
        this.txtDescription.setName("txtDescription");
        this.prmtcity.setName("prmtcity");
        this.prmtcompany.setName("prmtcompany");
        this.txtpersonNum.setName("txtpersonNum");
        this.txttarachieve.setName("txttarachieve");
        this.txtbudcost.setName("txtbudcost");
        this.type.setName("type");
        this.txtylyz.setName("txtylyz");
        this.txtyzys.setName("txtyzys");
        this.txtzzjyhs.setName("txtzzjyhs");
        this.txtzx.setName("txtzx");
        this.txtqt.setName("txtqt");
        this.txthq.setName("txthq");
        this.txtyzhs.setName("txtyzhs");
        this.txthl.setName("txthl");
        this.txtkf.setName("txtkf");
        this.txtrlxz.setName("txtrlxz");
        this.txtyh.setName("txtyh");
        this.txtzjb.setName("txtzjb");
        this.txtcw.setName("txtcw");
        this.txtqh.setName("txtqh");
        this.txtqd.setName("txtqd");
        this.txtwdzx.setName("txtwdzx");
        this.txtwl.setName("txtwl");
        this.txtxmt.setName("txtxmt");
        this.txtbusinessdate.setName("txtbusinessdate");
        this.txtcg.setName("txtcg");
        this.txtztb.setName("txtztb");
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
        // contcompany		
        this.contcompany.setBoundLabelText(resHelper.getString("contcompany.boundLabelText"));		
        this.contcompany.setBoundLabelLength(100);		
        this.contcompany.setBoundLabelUnderline(true);		
        this.contcompany.setVisible(true);
        // contpersonNum		
        this.contpersonNum.setBoundLabelText(resHelper.getString("contpersonNum.boundLabelText"));		
        this.contpersonNum.setBoundLabelLength(100);		
        this.contpersonNum.setBoundLabelUnderline(true);		
        this.contpersonNum.setVisible(true);
        // conttarachieve		
        this.conttarachieve.setBoundLabelText(resHelper.getString("conttarachieve.boundLabelText"));		
        this.conttarachieve.setBoundLabelLength(100);		
        this.conttarachieve.setBoundLabelUnderline(true);		
        this.conttarachieve.setVisible(true);
        // contbudcost		
        this.contbudcost.setBoundLabelText(resHelper.getString("contbudcost.boundLabelText"));		
        this.contbudcost.setBoundLabelLength(100);		
        this.contbudcost.setBoundLabelUnderline(true);		
        this.contbudcost.setVisible(true);
        // conttype		
        this.conttype.setBoundLabelText(resHelper.getString("conttype.boundLabelText"));		
        this.conttype.setBoundLabelLength(100);		
        this.conttype.setBoundLabelUnderline(true);		
        this.conttype.setVisible(true);
        // contylyz		
        this.contylyz.setBoundLabelText(resHelper.getString("contylyz.boundLabelText"));		
        this.contylyz.setBoundLabelLength(100);		
        this.contylyz.setBoundLabelUnderline(true);		
        this.contylyz.setVisible(true);
        // contyzys		
        this.contyzys.setBoundLabelText(resHelper.getString("contyzys.boundLabelText"));		
        this.contyzys.setBoundLabelLength(100);		
        this.contyzys.setBoundLabelUnderline(true);		
        this.contyzys.setVisible(true);
        // contzzjyhs		
        this.contzzjyhs.setBoundLabelText(resHelper.getString("contzzjyhs.boundLabelText"));		
        this.contzzjyhs.setBoundLabelLength(100);		
        this.contzzjyhs.setBoundLabelUnderline(true);		
        this.contzzjyhs.setVisible(true);
        // contzx		
        this.contzx.setBoundLabelText(resHelper.getString("contzx.boundLabelText"));		
        this.contzx.setBoundLabelLength(100);		
        this.contzx.setBoundLabelUnderline(true);		
        this.contzx.setVisible(true);
        // contqt		
        this.contqt.setBoundLabelText(resHelper.getString("contqt.boundLabelText"));		
        this.contqt.setBoundLabelLength(100);		
        this.contqt.setBoundLabelUnderline(true);		
        this.contqt.setVisible(true);
        // conthq		
        this.conthq.setBoundLabelText(resHelper.getString("conthq.boundLabelText"));		
        this.conthq.setBoundLabelLength(100);		
        this.conthq.setBoundLabelUnderline(true);		
        this.conthq.setVisible(true);
        // contyzhs		
        this.contyzhs.setBoundLabelText(resHelper.getString("contyzhs.boundLabelText"));		
        this.contyzhs.setBoundLabelLength(100);		
        this.contyzhs.setBoundLabelUnderline(true);		
        this.contyzhs.setVisible(true);
        // conthl		
        this.conthl.setBoundLabelText(resHelper.getString("conthl.boundLabelText"));		
        this.conthl.setBoundLabelLength(100);		
        this.conthl.setBoundLabelUnderline(true);		
        this.conthl.setVisible(true);
        // contkf		
        this.contkf.setBoundLabelText(resHelper.getString("contkf.boundLabelText"));		
        this.contkf.setBoundLabelLength(100);		
        this.contkf.setBoundLabelUnderline(true);		
        this.contkf.setVisible(true);
        // contrlxz		
        this.contrlxz.setBoundLabelText(resHelper.getString("contrlxz.boundLabelText"));		
        this.contrlxz.setBoundLabelLength(100);		
        this.contrlxz.setBoundLabelUnderline(true);		
        this.contrlxz.setVisible(true);
        // contyh		
        this.contyh.setBoundLabelText(resHelper.getString("contyh.boundLabelText"));		
        this.contyh.setBoundLabelLength(100);		
        this.contyh.setBoundLabelUnderline(true);		
        this.contyh.setVisible(true);
        // contzjb		
        this.contzjb.setBoundLabelText(resHelper.getString("contzjb.boundLabelText"));		
        this.contzjb.setBoundLabelLength(100);		
        this.contzjb.setBoundLabelUnderline(true);		
        this.contzjb.setVisible(true);
        // contcw		
        this.contcw.setBoundLabelText(resHelper.getString("contcw.boundLabelText"));		
        this.contcw.setBoundLabelLength(100);		
        this.contcw.setBoundLabelUnderline(true);		
        this.contcw.setVisible(true);
        // contqh		
        this.contqh.setBoundLabelText(resHelper.getString("contqh.boundLabelText"));		
        this.contqh.setBoundLabelLength(100);		
        this.contqh.setBoundLabelUnderline(true);		
        this.contqh.setVisible(true);
        // contqd		
        this.contqd.setBoundLabelText(resHelper.getString("contqd.boundLabelText"));		
        this.contqd.setBoundLabelLength(100);		
        this.contqd.setBoundLabelUnderline(true);		
        this.contqd.setVisible(true);
        // contwdzx		
        this.contwdzx.setBoundLabelText(resHelper.getString("contwdzx.boundLabelText"));		
        this.contwdzx.setBoundLabelLength(100);		
        this.contwdzx.setBoundLabelUnderline(true);		
        this.contwdzx.setVisible(true);
        // contwl		
        this.contwl.setBoundLabelText(resHelper.getString("contwl.boundLabelText"));		
        this.contwl.setBoundLabelLength(100);		
        this.contwl.setBoundLabelUnderline(true);		
        this.contwl.setVisible(true);
        // contxmt		
        this.contxmt.setBoundLabelText(resHelper.getString("contxmt.boundLabelText"));		
        this.contxmt.setBoundLabelLength(100);		
        this.contxmt.setBoundLabelUnderline(true);		
        this.contxmt.setVisible(true);
        // contbusinessdate		
        this.contbusinessdate.setBoundLabelText(resHelper.getString("contbusinessdate.boundLabelText"));		
        this.contbusinessdate.setBoundLabelLength(100);		
        this.contbusinessdate.setBoundLabelUnderline(true);		
        this.contbusinessdate.setVisible(true);
        // contcg		
        this.contcg.setBoundLabelText(resHelper.getString("contcg.boundLabelText"));		
        this.contcg.setBoundLabelLength(100);		
        this.contcg.setBoundLabelUnderline(true);		
        this.contcg.setVisible(true);
        // contztb		
        this.contztb.setBoundLabelText(resHelper.getString("contztb.boundLabelText"));		
        this.contztb.setBoundLabelLength(100);		
        this.contztb.setBoundLabelUnderline(true);		
        this.contztb.setVisible(true);
        // txtNumber		
        this.txtNumber.setMaxLength(80);
        // txtName
        // txtSimpleName		
        this.txtSimpleName.setMaxLength(80);
        // txtDescription
        // prmtcity		
        this.prmtcity.setQueryInfo("com.kingdee.eas.basedata.org.app.CUQuery");		
        this.prmtcity.setVisible(true);		
        this.prmtcity.setEditable(true);		
        this.prmtcity.setDisplayFormat("$name$");		
        this.prmtcity.setEditFormat("$number$");		
        this.prmtcity.setCommitFormat("$number$");		
        this.prmtcity.setRequired(false);
        // prmtcompany		
        this.prmtcompany.setQueryInfo("com.kingdee.eas.basedata.org.app.CompanyOrgUnitQuery");		
        this.prmtcompany.setVisible(true);		
        this.prmtcompany.setEditable(true);		
        this.prmtcompany.setDisplayFormat("$name$");		
        this.prmtcompany.setEditFormat("$number$");		
        this.prmtcompany.setCommitFormat("$number$");		
        this.prmtcompany.setRequired(false);
        // txtpersonNum		
        this.txtpersonNum.setVisible(true);		
        this.txtpersonNum.setHorizontalAlignment(2);		
        this.txtpersonNum.setDataType(1);		
        this.txtpersonNum.setSupportedEmpty(true);		
        this.txtpersonNum.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtpersonNum.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtpersonNum.setPrecision(10);		
        this.txtpersonNum.setRequired(false);
        // txttarachieve		
        this.txttarachieve.setVisible(true);		
        this.txttarachieve.setHorizontalAlignment(2);		
        this.txttarachieve.setDataType(1);		
        this.txttarachieve.setSupportedEmpty(true);		
        this.txttarachieve.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txttarachieve.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txttarachieve.setPrecision(10);		
        this.txttarachieve.setRequired(false);
        // txtbudcost		
        this.txtbudcost.setVisible(true);		
        this.txtbudcost.setHorizontalAlignment(2);		
        this.txtbudcost.setDataType(1);		
        this.txtbudcost.setSupportedEmpty(true);		
        this.txtbudcost.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtbudcost.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtbudcost.setPrecision(10);		
        this.txtbudcost.setRequired(false);
        // type		
        this.type.setVisible(true);		
        this.type.addItems(EnumUtils.getEnumList("com.kingdee.eas.mw.pay.app.BudgeType").toArray());		
        this.type.setRequired(false);
        // txtylyz		
        this.txtylyz.setVisible(true);		
        this.txtylyz.setHorizontalAlignment(2);		
        this.txtylyz.setDataType(1);		
        this.txtylyz.setSupportedEmpty(true);		
        this.txtylyz.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtylyz.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtylyz.setPrecision(10);		
        this.txtylyz.setRequired(false);
        // txtyzys		
        this.txtyzys.setVisible(true);		
        this.txtyzys.setHorizontalAlignment(2);		
        this.txtyzys.setDataType(1);		
        this.txtyzys.setSupportedEmpty(true);		
        this.txtyzys.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtyzys.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtyzys.setPrecision(10);		
        this.txtyzys.setRequired(false);
        // txtzzjyhs		
        this.txtzzjyhs.setVisible(true);		
        this.txtzzjyhs.setHorizontalAlignment(2);		
        this.txtzzjyhs.setDataType(1);		
        this.txtzzjyhs.setSupportedEmpty(true);		
        this.txtzzjyhs.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtzzjyhs.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtzzjyhs.setPrecision(10);		
        this.txtzzjyhs.setRequired(false);
        // txtzx		
        this.txtzx.setVisible(true);		
        this.txtzx.setHorizontalAlignment(2);		
        this.txtzx.setDataType(1);		
        this.txtzx.setSupportedEmpty(true);		
        this.txtzx.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtzx.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtzx.setPrecision(10);		
        this.txtzx.setRequired(false);
        // txtqt		
        this.txtqt.setVisible(true);		
        this.txtqt.setHorizontalAlignment(2);		
        this.txtqt.setDataType(1);		
        this.txtqt.setSupportedEmpty(true);		
        this.txtqt.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtqt.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtqt.setPrecision(10);		
        this.txtqt.setRequired(false);
        // txthq		
        this.txthq.setVisible(true);		
        this.txthq.setHorizontalAlignment(2);		
        this.txthq.setDataType(1);		
        this.txthq.setSupportedEmpty(true);		
        this.txthq.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txthq.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txthq.setPrecision(10);		
        this.txthq.setRequired(false);
        // txtyzhs		
        this.txtyzhs.setVisible(true);		
        this.txtyzhs.setHorizontalAlignment(2);		
        this.txtyzhs.setDataType(1);		
        this.txtyzhs.setSupportedEmpty(true);		
        this.txtyzhs.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtyzhs.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtyzhs.setPrecision(10);		
        this.txtyzhs.setRequired(false);
        // txthl		
        this.txthl.setVisible(true);		
        this.txthl.setHorizontalAlignment(2);		
        this.txthl.setDataType(1);		
        this.txthl.setSupportedEmpty(true);		
        this.txthl.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txthl.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txthl.setPrecision(10);		
        this.txthl.setRequired(false);
        // txtkf		
        this.txtkf.setVisible(true);		
        this.txtkf.setHorizontalAlignment(2);		
        this.txtkf.setDataType(1);		
        this.txtkf.setSupportedEmpty(true);		
        this.txtkf.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtkf.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtkf.setPrecision(10);		
        this.txtkf.setRequired(false);
        // txtrlxz		
        this.txtrlxz.setVisible(true);		
        this.txtrlxz.setHorizontalAlignment(2);		
        this.txtrlxz.setDataType(1);		
        this.txtrlxz.setSupportedEmpty(true);		
        this.txtrlxz.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtrlxz.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtrlxz.setPrecision(10);		
        this.txtrlxz.setRequired(false);
        // txtyh		
        this.txtyh.setVisible(true);		
        this.txtyh.setHorizontalAlignment(2);		
        this.txtyh.setDataType(1);		
        this.txtyh.setSupportedEmpty(true);		
        this.txtyh.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtyh.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtyh.setPrecision(10);		
        this.txtyh.setRequired(false);
        // txtzjb		
        this.txtzjb.setVisible(true);		
        this.txtzjb.setHorizontalAlignment(2);		
        this.txtzjb.setDataType(1);		
        this.txtzjb.setSupportedEmpty(true);		
        this.txtzjb.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtzjb.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtzjb.setPrecision(10);		
        this.txtzjb.setRequired(false);
        // txtcw		
        this.txtcw.setVisible(true);		
        this.txtcw.setHorizontalAlignment(2);		
        this.txtcw.setDataType(1);		
        this.txtcw.setSupportedEmpty(true);		
        this.txtcw.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtcw.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtcw.setPrecision(10);		
        this.txtcw.setRequired(false);
        // txtqh		
        this.txtqh.setVisible(true);		
        this.txtqh.setHorizontalAlignment(2);		
        this.txtqh.setDataType(1);		
        this.txtqh.setSupportedEmpty(true);		
        this.txtqh.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtqh.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtqh.setPrecision(10);		
        this.txtqh.setRequired(false);
        // txtqd		
        this.txtqd.setVisible(true);		
        this.txtqd.setHorizontalAlignment(2);		
        this.txtqd.setDataType(1);		
        this.txtqd.setSupportedEmpty(true);		
        this.txtqd.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtqd.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtqd.setPrecision(10);		
        this.txtqd.setRequired(false);
        // txtwdzx		
        this.txtwdzx.setVisible(true);		
        this.txtwdzx.setHorizontalAlignment(2);		
        this.txtwdzx.setDataType(1);		
        this.txtwdzx.setSupportedEmpty(true);		
        this.txtwdzx.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtwdzx.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtwdzx.setPrecision(10);		
        this.txtwdzx.setRequired(false);
        // txtwl		
        this.txtwl.setVisible(true);		
        this.txtwl.setHorizontalAlignment(2);		
        this.txtwl.setDataType(1);		
        this.txtwl.setSupportedEmpty(true);		
        this.txtwl.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtwl.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtwl.setPrecision(10);		
        this.txtwl.setRequired(false);
        // txtxmt		
        this.txtxmt.setVisible(true);		
        this.txtxmt.setHorizontalAlignment(2);		
        this.txtxmt.setDataType(1);		
        this.txtxmt.setSupportedEmpty(true);		
        this.txtxmt.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtxmt.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtxmt.setPrecision(10);		
        this.txtxmt.setRequired(false);
        // txtbusinessdate		
        this.txtbusinessdate.setVisible(true);		
        this.txtbusinessdate.setHorizontalAlignment(2);		
        this.txtbusinessdate.setMaxLength(100);		
        this.txtbusinessdate.setRequired(false);
        // txtcg		
        this.txtcg.setVisible(true);		
        this.txtcg.setHorizontalAlignment(2);		
        this.txtcg.setDataType(1);		
        this.txtcg.setSupportedEmpty(true);		
        this.txtcg.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtcg.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtcg.setPrecision(10);		
        this.txtcg.setRequired(false);
        // txtztb		
        this.txtztb.setVisible(true);		
        this.txtztb.setHorizontalAlignment(2);		
        this.txtztb.setDataType(1);		
        this.txtztb.setSupportedEmpty(true);		
        this.txtztb.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtztb.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtztb.setPrecision(10);		
        this.txtztb.setRequired(false);
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {prmtcity,prmtcompany,txtpersonNum,txttarachieve,txtbudcost,type,txtylyz,txtyzys,txtyzhs,txthl,txtzzjyhs,txtkf,txtzx,txtqt,txthq,txtrlxz,txtyh,txtzjb,txtcw,txtqh,txtqd,txtwdzx,txtwl,txtxmt,txtbusinessdate,txtcg,txtztb}));
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
        this.setBounds(new Rectangle(0, 0, 1013, 293));
        this.setLayout(null);
        kDLabelContainer1.setBounds(new Rectangle(341, 226, 270, 19));
        this.add(kDLabelContainer1, null);
        kDLabelContainer2.setBounds(new Rectangle(341, 202, 270, 19));
        this.add(kDLabelContainer2, null);
        kDLabelContainer3.setBounds(new Rectangle(672, 202, 270, 19));
        this.add(kDLabelContainer3, null);
        kDLabelContainer4.setBounds(new Rectangle(10, 226, 270, 19));
        this.add(kDLabelContainer4, null);
        contcity.setBounds(new Rectangle(10, 10, 270, 19));
        this.add(contcity, null);
        contcompany.setBounds(new Rectangle(341, 10, 270, 19));
        this.add(contcompany, null);
        contpersonNum.setBounds(new Rectangle(10, 34, 270, 19));
        this.add(contpersonNum, null);
        conttarachieve.setBounds(new Rectangle(341, 34, 270, 19));
        this.add(conttarachieve, null);
        contbudcost.setBounds(new Rectangle(672, 34, 270, 19));
        this.add(contbudcost, null);
        conttype.setBounds(new Rectangle(10, 58, 270, 19));
        this.add(conttype, null);
        contylyz.setBounds(new Rectangle(341, 58, 270, 19));
        this.add(contylyz, null);
        contyzys.setBounds(new Rectangle(672, 58, 270, 19));
        this.add(contyzys, null);
        contzzjyhs.setBounds(new Rectangle(672, 82, 270, 19));
        this.add(contzzjyhs, null);
        contzx.setBounds(new Rectangle(341, 106, 270, 19));
        this.add(contzx, null);
        contqt.setBounds(new Rectangle(672, 106, 270, 19));
        this.add(contqt, null);
        conthq.setBounds(new Rectangle(10, 130, 270, 19));
        this.add(conthq, null);
        contyzhs.setBounds(new Rectangle(10, 82, 270, 19));
        this.add(contyzhs, null);
        conthl.setBounds(new Rectangle(341, 82, 270, 19));
        this.add(conthl, null);
        contkf.setBounds(new Rectangle(10, 106, 270, 19));
        this.add(contkf, null);
        contrlxz.setBounds(new Rectangle(341, 130, 270, 19));
        this.add(contrlxz, null);
        contyh.setBounds(new Rectangle(672, 130, 270, 19));
        this.add(contyh, null);
        contzjb.setBounds(new Rectangle(10, 154, 270, 19));
        this.add(contzjb, null);
        contcw.setBounds(new Rectangle(341, 154, 270, 19));
        this.add(contcw, null);
        contqh.setBounds(new Rectangle(672, 154, 270, 19));
        this.add(contqh, null);
        contqd.setBounds(new Rectangle(10, 178, 270, 19));
        this.add(contqd, null);
        contwdzx.setBounds(new Rectangle(341, 178, 270, 19));
        this.add(contwdzx, null);
        contwl.setBounds(new Rectangle(672, 178, 270, 19));
        this.add(contwl, null);
        contxmt.setBounds(new Rectangle(10, 202, 270, 19));
        this.add(contxmt, null);
        contbusinessdate.setBounds(new Rectangle(672, 10, 270, 19));
        this.add(contbusinessdate, null);
        contcg.setBounds(new Rectangle(672, 226, 270, 19));
        this.add(contcg, null);
        contztb.setBounds(new Rectangle(10, 250, 270, 19));
        this.add(contztb, null);
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
        //contcompany
        contcompany.setBoundEditor(prmtcompany);
        //contpersonNum
        contpersonNum.setBoundEditor(txtpersonNum);
        //conttarachieve
        conttarachieve.setBoundEditor(txttarachieve);
        //contbudcost
        contbudcost.setBoundEditor(txtbudcost);
        //conttype
        conttype.setBoundEditor(type);
        //contylyz
        contylyz.setBoundEditor(txtylyz);
        //contyzys
        contyzys.setBoundEditor(txtyzys);
        //contzzjyhs
        contzzjyhs.setBoundEditor(txtzzjyhs);
        //contzx
        contzx.setBoundEditor(txtzx);
        //contqt
        contqt.setBoundEditor(txtqt);
        //conthq
        conthq.setBoundEditor(txthq);
        //contyzhs
        contyzhs.setBoundEditor(txtyzhs);
        //conthl
        conthl.setBoundEditor(txthl);
        //contkf
        contkf.setBoundEditor(txtkf);
        //contrlxz
        contrlxz.setBoundEditor(txtrlxz);
        //contyh
        contyh.setBoundEditor(txtyh);
        //contzjb
        contzjb.setBoundEditor(txtzjb);
        //contcw
        contcw.setBoundEditor(txtcw);
        //contqh
        contqh.setBoundEditor(txtqh);
        //contqd
        contqd.setBoundEditor(txtqd);
        //contwdzx
        contwdzx.setBoundEditor(txtwdzx);
        //contwl
        contwl.setBoundEditor(txtwl);
        //contxmt
        contxmt.setBoundEditor(txtxmt);
        //contbusinessdate
        contbusinessdate.setBoundEditor(txtbusinessdate);
        //contcg
        contcg.setBoundEditor(txtcg);
        //contztb
        contztb.setBoundEditor(txtztb);

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
		dataBinder.registerBinding("city", com.kingdee.eas.basedata.org.CtrlUnitInfo.class, this.prmtcity, "data");
		dataBinder.registerBinding("company", com.kingdee.eas.basedata.org.CompanyOrgUnitInfo.class, this.prmtcompany, "data");
		dataBinder.registerBinding("personNum", java.math.BigDecimal.class, this.txtpersonNum, "value");
		dataBinder.registerBinding("tarachieve", java.math.BigDecimal.class, this.txttarachieve, "value");
		dataBinder.registerBinding("budcost", java.math.BigDecimal.class, this.txtbudcost, "value");
		dataBinder.registerBinding("type", com.kingdee.eas.mw.pay.app.BudgeType.class, this.type, "selectedItem");
		dataBinder.registerBinding("ylyz", java.math.BigDecimal.class, this.txtylyz, "value");
		dataBinder.registerBinding("yzys", java.math.BigDecimal.class, this.txtyzys, "value");
		dataBinder.registerBinding("zzjyhs", java.math.BigDecimal.class, this.txtzzjyhs, "value");
		dataBinder.registerBinding("zx", java.math.BigDecimal.class, this.txtzx, "value");
		dataBinder.registerBinding("qt", java.math.BigDecimal.class, this.txtqt, "value");
		dataBinder.registerBinding("hq", java.math.BigDecimal.class, this.txthq, "value");
		dataBinder.registerBinding("yzhs", java.math.BigDecimal.class, this.txtyzhs, "value");
		dataBinder.registerBinding("hl", java.math.BigDecimal.class, this.txthl, "value");
		dataBinder.registerBinding("kf", java.math.BigDecimal.class, this.txtkf, "value");
		dataBinder.registerBinding("rlxz", java.math.BigDecimal.class, this.txtrlxz, "value");
		dataBinder.registerBinding("yh", java.math.BigDecimal.class, this.txtyh, "value");
		dataBinder.registerBinding("zjb", java.math.BigDecimal.class, this.txtzjb, "value");
		dataBinder.registerBinding("cw", java.math.BigDecimal.class, this.txtcw, "value");
		dataBinder.registerBinding("qh", java.math.BigDecimal.class, this.txtqh, "value");
		dataBinder.registerBinding("qd", java.math.BigDecimal.class, this.txtqd, "value");
		dataBinder.registerBinding("wdzx", java.math.BigDecimal.class, this.txtwdzx, "value");
		dataBinder.registerBinding("wl", java.math.BigDecimal.class, this.txtwl, "value");
		dataBinder.registerBinding("xmt", java.math.BigDecimal.class, this.txtxmt, "value");
		dataBinder.registerBinding("businessdate", String.class, this.txtbusinessdate, "text");
		dataBinder.registerBinding("cg", java.math.BigDecimal.class, this.txtcg, "value");
		dataBinder.registerBinding("ztb", java.math.BigDecimal.class, this.txtztb, "value");		
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
	    return "com.kingdee.eas.mw.srqr.app.CityCompanyTargetEditUIHandler";
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
        this.editData = (com.kingdee.eas.mw.srqr.CityCompanyTargetInfo)ov;
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
		getValidateHelper().registerBindProperty("city", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("company", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("personNum", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("tarachieve", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("budcost", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("type", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("ylyz", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("yzys", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("zzjyhs", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("zx", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("qt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("hq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("yzhs", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("hl", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("kf", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("rlxz", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("yh", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("zjb", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("cw", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("qh", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("qd", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("wdzx", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("wl", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("xmt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("businessdate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("cg", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("ztb", ValidateHelper.ON_SAVE);    		
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
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("city.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("city.id"));
        	sic.add(new SelectorItemInfo("city.number"));
        	sic.add(new SelectorItemInfo("city.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("company.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("company.id"));
        	sic.add(new SelectorItemInfo("company.number"));
        	sic.add(new SelectorItemInfo("company.name"));
		}
        sic.add(new SelectorItemInfo("personNum"));
        sic.add(new SelectorItemInfo("tarachieve"));
        sic.add(new SelectorItemInfo("budcost"));
        sic.add(new SelectorItemInfo("type"));
        sic.add(new SelectorItemInfo("ylyz"));
        sic.add(new SelectorItemInfo("yzys"));
        sic.add(new SelectorItemInfo("zzjyhs"));
        sic.add(new SelectorItemInfo("zx"));
        sic.add(new SelectorItemInfo("qt"));
        sic.add(new SelectorItemInfo("hq"));
        sic.add(new SelectorItemInfo("yzhs"));
        sic.add(new SelectorItemInfo("hl"));
        sic.add(new SelectorItemInfo("kf"));
        sic.add(new SelectorItemInfo("rlxz"));
        sic.add(new SelectorItemInfo("yh"));
        sic.add(new SelectorItemInfo("zjb"));
        sic.add(new SelectorItemInfo("cw"));
        sic.add(new SelectorItemInfo("qh"));
        sic.add(new SelectorItemInfo("qd"));
        sic.add(new SelectorItemInfo("wdzx"));
        sic.add(new SelectorItemInfo("wl"));
        sic.add(new SelectorItemInfo("xmt"));
        sic.add(new SelectorItemInfo("businessdate"));
        sic.add(new SelectorItemInfo("cg"));
        sic.add(new SelectorItemInfo("ztb"));
        return sic;
    }        

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.mw.srqr.client", "CityCompanyTargetEditUI");
    }

    /**
     * output getEditUIName method
     */
    protected String getEditUIName()
    {
        return com.kingdee.eas.mw.srqr.client.CityCompanyTargetEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.mw.srqr.CityCompanyTargetFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.mw.srqr.CityCompanyTargetInfo objectValue = new com.kingdee.eas.mw.srqr.CityCompanyTargetInfo();
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
		vo.put("type","MZ");
        
    }        
	protected void setFieldsNull(com.kingdee.bos.dao.AbstractObjectValue arg0) {
		super.setFieldsNull(arg0);
		arg0.put("number",null);
	}

}