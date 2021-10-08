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
public abstract class AbstractClinicAchieveCosthSumListUI extends com.kingdee.eas.framework.client.ListUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractClinicAchieveCosthSumListUI.class);
    /**
     * output class constructor
     */
    public AbstractClinicAchieveCosthSumListUI() throws Exception
    {
        super();
        this.defaultObjectName = "mainQuery";
        jbInit();
        
        initUIP();
    }

    /**
     * output jbInit method
     */
    private void jbInit() throws Exception
    {
        this.resHelper = new ResourceBundleHelper(AbstractClinicAchieveCosthSumListUI.class.getName());
        this.setUITitle(resHelper.getString("this.title"));
        mainQueryPK = new MetaDataPK("com.kingdee.eas.mw.pay.app", "ClinicAchieveCosthSumQuery");
        // CoreUI
		String tblMainStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol9\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol10\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol11\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol12\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol13\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol14\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol15\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol16\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol17\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol18\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol19\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol20\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol21\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol22\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol23\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol24\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol25\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol26\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol27\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol28\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol29\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol30\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol31\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol32\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol33\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol34\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol35\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol36\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol37\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol38\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol39\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol40\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol41\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol42\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol43\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol44\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol45\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol46\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol47\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol48\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol49\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol50\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol51\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol52\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol53\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol54\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol55\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol56\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol57\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol58\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol59\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol60\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol61\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol62\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol63\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol64\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol65\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol66\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol67\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol68\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol69\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol70\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol71\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol72\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol73\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol74\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol75\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol76\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol77\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol78\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol79\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol80\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol81\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol82\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol83\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol84\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol85\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol86\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol87\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol88\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol89\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol90\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol91\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol92\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol93\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol94\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol95\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol96\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol97\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol98\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol99\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol100\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol101\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol102\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol103\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol104\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol105\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol106\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol107\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"cityNumber\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"cityName\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"clinicNumber\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"clinicName\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"empNumber\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"empName\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"postType\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"iszidai\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"businessDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"xtjyCount\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol9\" /><t:Column t:key=\"imjycount\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol10\" /><t:Column t:key=\"jyCount\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol11\" /><t:Column t:key=\"xtplaCount\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol12\" /><t:Column t:key=\"implacount\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol13\" /><t:Column t:key=\"plaCount\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol14\" /><t:Column t:key=\"xtcosydzCount\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol15\" /><t:Column t:key=\"imcosydzCount\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol16\" /><t:Column t:key=\"cosydzCount\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol17\" /><t:Column t:key=\"xtcosyfdzCount\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol18\" /><t:Column t:key=\"imcosyfdzCount\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol19\" /><t:Column t:key=\"cosyfdzCount\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol20\" /><t:Column t:key=\"xtwhiteAchieve\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol21\" /><t:Column t:key=\"imwhiteAchieve\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol22\" /><t:Column t:key=\"whiteAchieve\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol23\" /><t:Column t:key=\"xtzxAchieve\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol24\" /><t:Column t:key=\"imzxAchieve\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol25\" /><t:Column t:key=\"zxAchieve\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol26\" /><t:Column t:key=\"xtzzAchieve\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol27\" /><t:Column t:key=\"imzzAchieve\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol28\" /><t:Column t:key=\"freezzAchieve\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol29\" /><t:Column t:key=\"zzAchieve\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol30\" /><t:Column t:key=\"zzCost\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol31\" /><t:Column t:key=\"zzbase\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol32\" /><t:Column t:key=\"zzMoney\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol33\" /><t:Column t:key=\"xtyxjzAchieve\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol34\" /><t:Column t:key=\"imyxjzAchieve\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol35\" /><t:Column t:key=\"freeyxjzAchieve\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol36\" /><t:Column t:key=\"yxjzAchieve\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol37\" /><t:Column t:key=\"yxjzCost\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol38\" /><t:Column t:key=\"yxbase\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol39\" /><t:Column t:key=\"yxjzMoney\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol40\" /><t:Column t:key=\"xtgdjzAchieve\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol41\" /><t:Column t:key=\"imgdjzAchieve\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol42\" /><t:Column t:key=\"freegdjzAchieve\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol43\" /><t:Column t:key=\"gdjzAchieve\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol44\" /><t:Column t:key=\"gdjzCost\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol45\" /><t:Column t:key=\"gdbase\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol46\" /><t:Column t:key=\"gdjzMoney\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol47\" /><t:Column t:key=\"xtknwAchieve\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol48\" /><t:Column t:key=\"imknwAchieve\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol49\" /><t:Column t:key=\"freeknwAchieve\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol50\" /><t:Column t:key=\"knwAchieve\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol51\" /><t:Column t:key=\"knwCost\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol52\" /><t:Column t:key=\"knwbase\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol53\" /><t:Column t:key=\"knwMoney\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol54\" /><t:Column t:key=\"xtxfAchieve\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol55\" /><t:Column t:key=\"imxfAchieve\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol56\" /><t:Column t:key=\"freexfAchieve\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol57\" /><t:Column t:key=\"xfAchieve\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol58\" /><t:Column t:key=\"xfCost\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol59\" /><t:Column t:key=\"xfbase\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol60\" /><t:Column t:key=\"xfMoney\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol61\" /><t:Column t:key=\"xteyAchieve\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol62\" /><t:Column t:key=\"imeyAchieve\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol63\" /><t:Column t:key=\"freeeyAchieve\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol64\" /><t:Column t:key=\"eyAchieve\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol65\" /><t:Column t:key=\"eyCost\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol66\" /><t:Column t:key=\"eybase\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol67\" /><t:Column t:key=\"eyMoney\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol68\" /><t:Column t:key=\"xtyzAchieve\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol69\" /><t:Column t:key=\"imyzAchieve\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol70\" /><t:Column t:key=\"freeyzAchieve\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol71\" /><t:Column t:key=\"zyAchieve\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol72\" /><t:Column t:key=\"yzCost\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol73\" /><t:Column t:key=\"yzbase\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol74\" /><t:Column t:key=\"yzMoney\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol75\" /><t:Column t:key=\"xtmbAchieve\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol76\" /><t:Column t:key=\"immbAchieve\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol77\" /><t:Column t:key=\"mbAchieve\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol78\" /><t:Column t:key=\"mbCost\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol79\" /><t:Column t:key=\"mbMoney\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol80\" /><t:Column t:key=\"sumAchieve\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol81\" /><t:Column t:key=\"allbase\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol82\" /><t:Column t:key=\"allKeAchieve\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol83\" /><t:Column t:key=\"ImAllKeAchieve\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol84\" /><t:Column t:key=\"XtAllKeAchieve\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol85\" /><t:Column t:key=\"mbbase\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol86\" /><t:Column t:key=\"zzpro\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol87\" /><t:Column t:key=\"gdpro\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol88\" /><t:Column t:key=\"yxpro\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol89\" /><t:Column t:key=\"knwpro\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol90\" /><t:Column t:key=\"xfpro\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol91\" /><t:Column t:key=\"yzpro\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol92\" /><t:Column t:key=\"eypro\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol93\" /><t:Column t:key=\"mbpro\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol94\" /><t:Column t:key=\"number\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol95\" /><t:Column t:key=\"name\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol96\" /><t:Column t:key=\"simpleName\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol97\" /><t:Column t:key=\"createTime\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol98\" /><t:Column t:key=\"description\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol99\" /><t:Column t:key=\"lastUpdateTime\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol100\" /><t:Column t:key=\"creator.name\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol101\" /><t:Column t:key=\"creator.number\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol102\" /><t:Column t:key=\"lastUpdateUser.number\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol103\" /><t:Column t:key=\"lastUpdateUser.name\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol104\" /><t:Column t:key=\"id\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol105\" /><t:Column t:key=\"freembAchieve\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol106\" /><t:Column t:key=\"otherMoney\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol107\" /><t:Column t:key=\"postname\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{cityNumber}</t:Cell><t:Cell>$Resource{cityName}</t:Cell><t:Cell>$Resource{clinicNumber}</t:Cell><t:Cell>$Resource{clinicName}</t:Cell><t:Cell>$Resource{empNumber}</t:Cell><t:Cell>$Resource{empName}</t:Cell><t:Cell>$Resource{postType}</t:Cell><t:Cell>$Resource{iszidai}</t:Cell><t:Cell>$Resource{businessDate}</t:Cell><t:Cell>$Resource{xtjyCount}</t:Cell><t:Cell>$Resource{imjycount}</t:Cell><t:Cell>$Resource{jyCount}</t:Cell><t:Cell>$Resource{xtplaCount}</t:Cell><t:Cell>$Resource{implacount}</t:Cell><t:Cell>$Resource{plaCount}</t:Cell><t:Cell>$Resource{xtcosydzCount}</t:Cell><t:Cell>$Resource{imcosydzCount}</t:Cell><t:Cell>$Resource{cosydzCount}</t:Cell><t:Cell>$Resource{xtcosyfdzCount}</t:Cell><t:Cell>$Resource{imcosyfdzCount}</t:Cell><t:Cell>$Resource{cosyfdzCount}</t:Cell><t:Cell>$Resource{xtwhiteAchieve}</t:Cell><t:Cell>$Resource{imwhiteAchieve}</t:Cell><t:Cell>$Resource{whiteAchieve}</t:Cell><t:Cell>$Resource{xtzxAchieve}</t:Cell><t:Cell>$Resource{imzxAchieve}</t:Cell><t:Cell>$Resource{zxAchieve}</t:Cell><t:Cell>$Resource{xtzzAchieve}</t:Cell><t:Cell>$Resource{imzzAchieve}</t:Cell><t:Cell>$Resource{freezzAchieve}</t:Cell><t:Cell>$Resource{zzAchieve}</t:Cell><t:Cell>$Resource{zzCost}</t:Cell><t:Cell>$Resource{zzbase}</t:Cell><t:Cell>$Resource{zzMoney}</t:Cell><t:Cell>$Resource{xtyxjzAchieve}</t:Cell><t:Cell>$Resource{imyxjzAchieve}</t:Cell><t:Cell>$Resource{freeyxjzAchieve}</t:Cell><t:Cell>$Resource{yxjzAchieve}</t:Cell><t:Cell>$Resource{yxjzCost}</t:Cell><t:Cell>$Resource{yxbase}</t:Cell><t:Cell>$Resource{yxjzMoney}</t:Cell><t:Cell>$Resource{xtgdjzAchieve}</t:Cell><t:Cell>$Resource{imgdjzAchieve}</t:Cell><t:Cell>$Resource{freegdjzAchieve}</t:Cell><t:Cell>$Resource{gdjzAchieve}</t:Cell><t:Cell>$Resource{gdjzCost}</t:Cell><t:Cell>$Resource{gdbase}</t:Cell><t:Cell>$Resource{gdjzMoney}</t:Cell><t:Cell>$Resource{xtknwAchieve}</t:Cell><t:Cell>$Resource{imknwAchieve}</t:Cell><t:Cell>$Resource{freeknwAchieve}</t:Cell><t:Cell>$Resource{knwAchieve}</t:Cell><t:Cell>$Resource{knwCost}</t:Cell><t:Cell>$Resource{knwbase}</t:Cell><t:Cell>$Resource{knwMoney}</t:Cell><t:Cell>$Resource{xtxfAchieve}</t:Cell><t:Cell>$Resource{imxfAchieve}</t:Cell><t:Cell>$Resource{freexfAchieve}</t:Cell><t:Cell>$Resource{xfAchieve}</t:Cell><t:Cell>$Resource{xfCost}</t:Cell><t:Cell>$Resource{xfbase}</t:Cell><t:Cell>$Resource{xfMoney}</t:Cell><t:Cell>$Resource{xteyAchieve}</t:Cell><t:Cell>$Resource{imeyAchieve}</t:Cell><t:Cell>$Resource{freeeyAchieve}</t:Cell><t:Cell>$Resource{eyAchieve}</t:Cell><t:Cell>$Resource{eyCost}</t:Cell><t:Cell>$Resource{eybase}</t:Cell><t:Cell>$Resource{eyMoney}</t:Cell><t:Cell>$Resource{xtyzAchieve}</t:Cell><t:Cell>$Resource{imyzAchieve}</t:Cell><t:Cell>$Resource{freeyzAchieve}</t:Cell><t:Cell>$Resource{zyAchieve}</t:Cell><t:Cell>$Resource{yzCost}</t:Cell><t:Cell>$Resource{yzbase}</t:Cell><t:Cell>$Resource{yzMoney}</t:Cell><t:Cell>$Resource{xtmbAchieve}</t:Cell><t:Cell>$Resource{immbAchieve}</t:Cell><t:Cell>$Resource{mbAchieve}</t:Cell><t:Cell>$Resource{mbCost}</t:Cell><t:Cell>$Resource{mbMoney}</t:Cell><t:Cell>$Resource{sumAchieve}</t:Cell><t:Cell>$Resource{allbase}</t:Cell><t:Cell>$Resource{allKeAchieve}</t:Cell><t:Cell>$Resource{ImAllKeAchieve}</t:Cell><t:Cell>$Resource{XtAllKeAchieve}</t:Cell><t:Cell>$Resource{mbbase}</t:Cell><t:Cell>$Resource{zzpro}</t:Cell><t:Cell>$Resource{gdpro}</t:Cell><t:Cell>$Resource{yxpro}</t:Cell><t:Cell>$Resource{knwpro}</t:Cell><t:Cell>$Resource{xfpro}</t:Cell><t:Cell>$Resource{yzpro}</t:Cell><t:Cell>$Resource{eypro}</t:Cell><t:Cell>$Resource{mbpro}</t:Cell><t:Cell>$Resource{number}</t:Cell><t:Cell>$Resource{name}</t:Cell><t:Cell>$Resource{simpleName}</t:Cell><t:Cell>$Resource{createTime}</t:Cell><t:Cell>$Resource{description}</t:Cell><t:Cell>$Resource{lastUpdateTime}</t:Cell><t:Cell>$Resource{creator.name}</t:Cell><t:Cell>$Resource{creator.number}</t:Cell><t:Cell>$Resource{lastUpdateUser.number}</t:Cell><t:Cell>$Resource{lastUpdateUser.name}</t:Cell><t:Cell>$Resource{id}</t:Cell><t:Cell>$Resource{freembAchieve}</t:Cell><t:Cell>$Resource{otherMoney}</t:Cell><t:Cell>$Resource{postname}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.tblMain.setFormatXml(resHelper.translateString("tblMain",tblMainStrXML));
                this.tblMain.putBindContents("mainQuery",new String[] {"cityNumber","cityName","clinicNumber","clinicName","empNumber","empName","postType","iszidai","businessDate","xtjyCount","imjycount","jyCount","xtplaCount","implacount","plaCount","xtcosydzCount","imcosydzCount","cosydzCount","xtcosyfdzCount","imcosyfdzCount","cosyfdzCount","xtwhiteAchieve","imwhiteAchieve","whiteAchieve","xtzxAchieve","imzxAchieve","zxAchieve","xtzzAchieve","imzzAchieve","freezzAchieve","zzAchieve","zzCost","zzbase","zzMoney","xtyxjzAchieve","imyxjzAchieve","freeyxjzAchieve","yxjzAchieve","yxjzCost","yxbase","yxjzMoney","xtgdjzAchieve","imgdjzAchieve","freegdjzAchieve","gdjzAchieve","gdjzCost","gdbase","gdjzMoney","xtknwAchieve","imknwAchieve","freeknwAchieve","knwAchieve","knwCost","knwbase","knwMoney","xtxfAchieve","imxfAchieve","freexfAchieve","xfAchieve","xfCost","xfbase","xfMoney","xteyAchieve","imeyAchieve","freeeyAchieve","eyAchieve","eyCost","eybase","eyMoney","xtyzAchieve","imyzAchieve","freeyzAchieve","zyAchieve","yzCost","yzbase","yzMoney","xtmbAchieve","immbAchieve","mbAchieve","mbCost","mbMoney","sumAchieve","allbase","allKeAchieve","ImAllKeAchieve","XtAllKeAchieve","mbbase","zzpro","gdpro","yxpro","knwpro","xfpro","yzpro","eypro","mbpro","number","name","simpleName","createTime","description","lastUpdateTime","creator.name","creator.number","lastUpdateUser.number","lastUpdateUser.name","id","freembAchieve","otherMoney","postname"});


        this.tblMain.checkParsed();
        this.tblMain.getGroupManager().setGroup(true);
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
        this.setBounds(new Rectangle(10, 10, 1013, 629));
        this.setLayout(new KDLayout());
        this.putClientProperty("OriginalBounds", new Rectangle(10, 10, 1013, 629));
        tblMain.setBounds(new Rectangle(10, 10, 996, 580));
        this.add(tblMain, new KDLayout.Constraints(10, 10, 996, 580, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));

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
        this.menuBar.add(menuTools);
        this.menuBar.add(menuHelp);
        //menuFile
        menuFile.add(menuItemAddNew);
        menuFile.add(menuItemImportData);
        menuFile.add(menuItemCloudFeed);
        menuFile.add(menuItemExportData);
        menuFile.add(menuItemCloudScreen);
        menuFile.add(separatorFile1);
        menuFile.add(menuItemCloudShare);
        menuFile.add(MenuItemAttachment);
        menuFile.add(kDSeparator1);
        menuFile.add(kdSeparatorFWFile1);
        menuFile.add(menuItemPageSetup);
        menuFile.add(menuItemPrint);
        menuFile.add(menuItemPrintPreview);
        menuFile.add(kDSeparator2);
        menuFile.add(menuItemExitCurrent);
        //menuEdit
        menuEdit.add(menuItemEdit);
        menuEdit.add(menuItemRemove);
        //MenuService
        MenuService.add(MenuItemKnowStore);
        MenuService.add(MenuItemAnwser);
        MenuService.add(SepratorService);
        MenuService.add(MenuItemRemoteAssist);
        //menuView
        menuView.add(menuItemView);
        menuView.add(menuItemLocate);
        menuView.add(separatorView1);
        menuView.add(menuItemQuery);
        menuView.add(menuItemQueryScheme);
        menuView.add(menuItemRefresh);
        //menuBiz
        menuBiz.add(menuItemCancelCancel);
        menuBiz.add(menuItemCancel);
        //menuTool
        menuTool.add(menuItemSendMessage);
        menuTool.add(menuItemCalculator);
        menuTool.add(menuItemToolBarCustom);
        //menuTools
        menuTools.add(menuMail);
        menuTools.add(menuItemStartWorkFlow);
        menuTools.add(menuItemPublishReport);
        //menuMail
        menuMail.add(menuItemToHTML);
        menuMail.add(menuItemCopyScreen);
        menuMail.add(menuItemToExcel);
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
        this.toolBar.add(btnView);
        this.toolBar.add(btnXunTong);
        this.toolBar.add(btnEdit);
        this.toolBar.add(kDSeparatorCloud);
        this.toolBar.add(btnRemove);
        this.toolBar.add(btnRefresh);
        this.toolBar.add(btnQuery);
        this.toolBar.add(btnLocate);
        this.toolBar.add(btnAttachment);
        this.toolBar.add(separatorFW1);
        this.toolBar.add(btnPageSetup);
        this.toolBar.add(btnPrint);
        this.toolBar.add(btnPrintPreview);
        this.toolBar.add(separatorFW2);
        this.toolBar.add(btnCancelCancel);
        this.toolBar.add(btnCancel);
        this.toolBar.add(btnQueryScheme);


    }

	//Regiester control's property binding.
	private void registerBindings(){		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.mw.pay.app.ClinicAchieveCosthSumListUIHandler";
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
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject)
    {
        IObjectValue ov = dataObject;        	    	
        super.setDataObject(ov);
    }
	protected void Remove() throws Exception {
    	IObjectValue editData = getBizInterface().getValue(new com.kingdee.bos.dao.ormapping.ObjectUuidPK(BOSUuid.read(getSelectedKeyValue())));
    	super.Remove();
    	recycleNumberByOrg(editData,"",editData.getString("number"));
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

    /**
     * output loadFields method
     */
    public void loadFields()
    {
        dataBinder.loadFields();
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
	}



    /**
     * output setOprtState method
     */
    public void setOprtState(String oprtType)
    {
        super.setOprtState(oprtType);
    }

	public SelectorItemCollection getBOTPSelectors() {
			SelectorItemCollection sic = new SelectorItemCollection();
			return sic;
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
        sic.add(new SelectorItemInfo("lastUpdateUser.name"));
        sic.add(new SelectorItemInfo("name"));
        sic.add(new SelectorItemInfo("number"));
        sic.add(new SelectorItemInfo("description"));
        sic.add(new SelectorItemInfo("simpleName"));
        sic.add(new SelectorItemInfo("createTime"));
        sic.add(new SelectorItemInfo("lastUpdateTime"));
        sic.add(new SelectorItemInfo("creator.name"));
        sic.add(new SelectorItemInfo("creator.number"));
        sic.add(new SelectorItemInfo("lastUpdateUser.number"));
        sic.add(new SelectorItemInfo("id"));
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
        sic.add(new SelectorItemInfo("iszidai"));
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
    }            protected java.util.List getQuerySorterFields() 
    { 
        java.util.List sorterFieldList = new ArrayList(); 
        sorterFieldList.add("number"); 
        return sorterFieldList; 
    } 
    protected java.util.List getQueryPKFields() 
    { 
        java.util.List pkList = new ArrayList(); 
        pkList.add("id"); 
        return pkList;
    }

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.mw.pay.client", "ClinicAchieveCosthSumListUI");
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
        return objectValue;
    }




}