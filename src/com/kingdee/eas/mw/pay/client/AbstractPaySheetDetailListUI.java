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
public abstract class AbstractPaySheetDetailListUI extends com.kingdee.eas.framework.client.ListUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractPaySheetDetailListUI.class);
    /**
     * output class constructor
     */
    public AbstractPaySheetDetailListUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractPaySheetDetailListUI.class.getName());
        this.setUITitle(resHelper.getString("this.title"));
        mainQueryPK = new MetaDataPK("com.kingdee.eas.mw.pay.app", "PaySheetDetailQuery");
        // CoreUI
		String tblMainStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol1\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol2\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol3\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol4\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol5\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol6\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol7\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol8\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol9\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol10\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol29\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol30\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol32\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol33\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol34\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol35\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol36\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol37\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol38\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol39\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol40\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol41\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol42\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol43\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol44\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol45\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol46\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol47\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol48\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol49\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol50\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol51\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol52\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol53\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol54\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol55\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol56\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol57\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol58\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol59\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol60\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol61\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol62\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol63\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol64\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol65\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol66\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol67\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol68\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol69\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol70\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol71\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol72\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol73\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol74\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol75\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol76\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol77\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol78\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol79\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol80\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol81\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol82\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol83\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol84\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol85\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol86\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol87\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol88\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol89\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol90\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol91\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol92\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol93\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol94\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol95\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol96\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol97\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol98\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol99\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol100\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol101\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol102\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol103\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol104\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol105\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol106\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol107\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol108\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol109\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol110\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol111\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol112\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol113\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol114\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol115\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol116\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol117\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol118\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol119\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol120\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol121\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol122\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol123\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol124\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol125\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol126\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol127\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol128\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol129\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol130\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol131\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol132\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol133\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol134\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol135\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol136\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol137\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol138\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"number\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"name\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol1\" /><t:Column t:key=\"simpleName\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol2\" /><t:Column t:key=\"description\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol3\" /><t:Column t:key=\"createTime\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol4\" /><t:Column t:key=\"lastUpdateTime\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol5\" /><t:Column t:key=\"creator.number\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol6\" /><t:Column t:key=\"creator.name\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol7\" /><t:Column t:key=\"lastUpdateUser.number\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol8\" /><t:Column t:key=\"lastUpdateUser.name\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol9\" /><t:Column t:key=\"id\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol10\" /><t:Column t:key=\"cityid\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"cityNumber\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"cityName\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"companyid\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"companyNumber\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"companyName\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"personid\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"personNumber\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"personName\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"businessdate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"costCenterNumber\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"iscount\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"post\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"emptype\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"postTypeNumber\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"postType\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"indate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"leaveDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"workYear\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol29\" /><t:Column t:key=\"bingjiaPro\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol30\" /><t:Column t:key=\"cardNumber\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"jibengongzi\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol32\" /><t:Column t:key=\"postAllow\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol33\" /><t:Column t:key=\"workYearAllow\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol34\" /><t:Column t:key=\"learnAllow\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol35\" /><t:Column t:key=\"cardAllow\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol36\" /><t:Column t:key=\"houseAllow\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol37\" /><t:Column t:key=\"achieveMoney\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol38\" /><t:Column t:key=\"monthMoney\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol39\" /><t:Column t:key=\"queqin\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol40\" /><t:Column t:key=\"shijia\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol41\" /><t:Column t:key=\"bingjia\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol42\" /><t:Column t:key=\"kaoqinSub\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol43\" /><t:Column t:key=\"chidaoSub\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol44\" /><t:Column t:key=\"gdAllow\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol45\" /><t:Column t:key=\"allWorkAllow\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol46\" /><t:Column t:key=\"foodAllow\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol47\" /><t:Column t:key=\"addWorkAllow\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol48\" /><t:Column t:key=\"other\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol49\" /><t:Column t:key=\"gdMoney\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol50\" /><t:Column t:key=\"XRayAllow\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol51\" /><t:Column t:key=\"holderMoney\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol52\" /><t:Column t:key=\"assMoney\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol53\" /><t:Column t:key=\"zbPro\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol54\" /><t:Column t:key=\"shopHelp\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol55\" /><t:Column t:key=\"zxCard\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol56\" /><t:Column t:key=\"splitUp\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol57\" /><t:Column t:key=\"zxLeave\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol58\" /><t:Column t:key=\"docLeave\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol59\" /><t:Column t:key=\"docAssCost\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol60\" /><t:Column t:key=\"assToDoc\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol61\" /><t:Column t:key=\"otherWaiMoney\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol62\" /><t:Column t:key=\"waiAllMoney\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol63\" /><t:Column t:key=\"marktMoney\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol64\" /><t:Column t:key=\"scalMoney\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol65\" /><t:Column t:key=\"mbAmount\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol66\" /><t:Column t:key=\"docAmount\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol67\" /><t:Column t:key=\"kfAmount\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol68\" /><t:Column t:key=\"hlAmount\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol69\" /><t:Column t:key=\"zxAmount\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol70\" /><t:Column t:key=\"shopTarMoney\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol71\" /><t:Column t:key=\"clinicAchiMoney\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol72\" /><t:Column t:key=\"otherNeiMoney\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol73\" /><t:Column t:key=\"bdProjectAll\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol74\" /><t:Column t:key=\"monthBase\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol75\" /><t:Column t:key=\"bdMonthProject\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol76\" /><t:Column t:key=\"payble\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol77\" /><t:Column t:key=\"achieveAll\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol78\" /><t:Column t:key=\"seaBase\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol79\" /><t:Column t:key=\"seaBuzu\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol80\" /><t:Column t:key=\"shouldPay\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol81\" /><t:Column t:key=\"realShouldPay\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol82\" /><t:Column t:key=\"perYanglao\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol83\" /><t:Column t:key=\"perYiliao\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol84\" /><t:Column t:key=\"perShiye\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol85\" /><t:Column t:key=\"perDaBing\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol86\" /><t:Column t:key=\"perGongjijin\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol87\" /><t:Column t:key=\"perAll\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol88\" /><t:Column t:key=\"beforeTaxMoney\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol89\" /><t:Column t:key=\"freeTaxMoney\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol90\" /><t:Column t:key=\"ljyssde\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol91\" /><t:Column t:key=\"grzxkcAmount\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol92\" /><t:Column t:key=\"yssde\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol93\" /><t:Column t:key=\"tax\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol94\" /><t:Column t:key=\"sjkcs\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol95\" /><t:Column t:key=\"ljgrsds\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol96\" /><t:Column t:key=\"dkgrsds\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol97\" /><t:Column t:key=\"mwBase\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol98\" /><t:Column t:key=\"dianpingSub\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol99\" /><t:Column t:key=\"kfSub\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol100\" /><t:Column t:key=\"payUp\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol101\" /><t:Column t:key=\"buchangAmount\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol102\" /><t:Column t:key=\"shifa\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol103\" /><t:Column t:key=\"tiepiao\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol104\" /><t:Column t:key=\"guaiaitong\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol105\" /><t:Column t:key=\"laowuMoney\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol106\" /><t:Column t:key=\"qitamoshi\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol107\" /><t:Column t:key=\"jifenAll\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol108\" /><t:Column t:key=\"tiepiaoSer\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol109\" /><t:Column t:key=\"guanaitongSer\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol110\" /><t:Column t:key=\"shouxufei\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol111\" /><t:Column t:key=\"otherSer\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol112\" /><t:Column t:key=\"serviceAll\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol113\" /><t:Column t:key=\"shouldYearBouns\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol114\" /><t:Column t:key=\"yearTax\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol115\" /><t:Column t:key=\"realyearAmount\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol116\" /><t:Column t:key=\"realAmount\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol117\" /><t:Column t:key=\"comyanglao\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol118\" /><t:Column t:key=\"comyiliao\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol119\" /><t:Column t:key=\"comdabing\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol120\" /><t:Column t:key=\"comshiye\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol121\" /><t:Column t:key=\"comgongshang\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol122\" /><t:Column t:key=\"comshengyu\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol123\" /><t:Column t:key=\"comgongjijin\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol124\" /><t:Column t:key=\"fuwufei\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol125\" /><t:Column t:key=\"shuijin\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol126\" /><t:Column t:key=\"comAll\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol127\" /><t:Column t:key=\"LC\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol128\" /><t:Column t:key=\"basemoney\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol129\" /><t:Column t:key=\"fentanother\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol130\" /><t:Column t:key=\"nianzhongfentan\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol131\" /><t:Column t:key=\"jidufentan\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol132\" /><t:Column t:key=\"nianzhong\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol133\" /><t:Column t:key=\"jidu\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol134\" /><t:Column t:key=\"yuedurenliAll\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol135\" /><t:Column t:key=\"yingshuiMoney\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol136\" /><t:Column t:key=\"geshui\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol137\" /><t:Column t:key=\"BaoDiBonus\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol138\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{number}</t:Cell><t:Cell>$Resource{name}</t:Cell><t:Cell>$Resource{simpleName}</t:Cell><t:Cell>$Resource{description}</t:Cell><t:Cell>$Resource{createTime}</t:Cell><t:Cell>$Resource{lastUpdateTime}</t:Cell><t:Cell>$Resource{creator.number}</t:Cell><t:Cell>$Resource{creator.name}</t:Cell><t:Cell>$Resource{lastUpdateUser.number}</t:Cell><t:Cell>$Resource{lastUpdateUser.name}</t:Cell><t:Cell>$Resource{id}</t:Cell><t:Cell>$Resource{cityid}</t:Cell><t:Cell>$Resource{cityNumber}</t:Cell><t:Cell>$Resource{cityName}</t:Cell><t:Cell>$Resource{companyid}</t:Cell><t:Cell>$Resource{companyNumber}</t:Cell><t:Cell>$Resource{companyName}</t:Cell><t:Cell>$Resource{personid}</t:Cell><t:Cell>$Resource{personNumber}</t:Cell><t:Cell>$Resource{personName}</t:Cell><t:Cell>$Resource{businessdate}</t:Cell><t:Cell>$Resource{costCenterNumber}</t:Cell><t:Cell>$Resource{iscount}</t:Cell><t:Cell>$Resource{post}</t:Cell><t:Cell>$Resource{emptype}</t:Cell><t:Cell>$Resource{postTypeNumber}</t:Cell><t:Cell>$Resource{postType}</t:Cell><t:Cell>$Resource{indate}</t:Cell><t:Cell>$Resource{leaveDate}</t:Cell><t:Cell>$Resource{workYear}</t:Cell><t:Cell>$Resource{bingjiaPro}</t:Cell><t:Cell>$Resource{cardNumber}</t:Cell><t:Cell>$Resource{jibengongzi}</t:Cell><t:Cell>$Resource{postAllow}</t:Cell><t:Cell>$Resource{workYearAllow}</t:Cell><t:Cell>$Resource{learnAllow}</t:Cell><t:Cell>$Resource{cardAllow}</t:Cell><t:Cell>$Resource{houseAllow}</t:Cell><t:Cell>$Resource{achieveMoney}</t:Cell><t:Cell>$Resource{monthMoney}</t:Cell><t:Cell>$Resource{queqin}</t:Cell><t:Cell>$Resource{shijia}</t:Cell><t:Cell>$Resource{bingjia}</t:Cell><t:Cell>$Resource{kaoqinSub}</t:Cell><t:Cell>$Resource{chidaoSub}</t:Cell><t:Cell>$Resource{gdAllow}</t:Cell><t:Cell>$Resource{allWorkAllow}</t:Cell><t:Cell>$Resource{foodAllow}</t:Cell><t:Cell>$Resource{addWorkAllow}</t:Cell><t:Cell>$Resource{other}</t:Cell><t:Cell>$Resource{gdMoney}</t:Cell><t:Cell>$Resource{XRayAllow}</t:Cell><t:Cell>$Resource{holderMoney}</t:Cell><t:Cell>$Resource{assMoney}</t:Cell><t:Cell>$Resource{zbPro}</t:Cell><t:Cell>$Resource{shopHelp}</t:Cell><t:Cell>$Resource{zxCard}</t:Cell><t:Cell>$Resource{splitUp}</t:Cell><t:Cell>$Resource{zxLeave}</t:Cell><t:Cell>$Resource{docLeave}</t:Cell><t:Cell>$Resource{docAssCost}</t:Cell><t:Cell>$Resource{assToDoc}</t:Cell><t:Cell>$Resource{otherWaiMoney}</t:Cell><t:Cell>$Resource{waiAllMoney}</t:Cell><t:Cell>$Resource{marktMoney}</t:Cell><t:Cell>$Resource{scalMoney}</t:Cell><t:Cell>$Resource{mbAmount}</t:Cell><t:Cell>$Resource{docAmount}</t:Cell><t:Cell>$Resource{kfAmount}</t:Cell><t:Cell>$Resource{hlAmount}</t:Cell><t:Cell>$Resource{zxAmount}</t:Cell><t:Cell>$Resource{shopTarMoney}</t:Cell><t:Cell>$Resource{clinicAchiMoney}</t:Cell><t:Cell>$Resource{otherNeiMoney}</t:Cell><t:Cell>$Resource{bdProjectAll}</t:Cell><t:Cell>$Resource{monthBase}</t:Cell><t:Cell>$Resource{bdMonthProject}</t:Cell><t:Cell>$Resource{payble}</t:Cell><t:Cell>$Resource{achieveAll}</t:Cell><t:Cell>$Resource{seaBase}</t:Cell><t:Cell>$Resource{seaBuzu}</t:Cell><t:Cell>$Resource{shouldPay}</t:Cell><t:Cell>$Resource{realShouldPay}</t:Cell><t:Cell>$Resource{perYanglao}</t:Cell><t:Cell>$Resource{perYiliao}</t:Cell><t:Cell>$Resource{perShiye}</t:Cell><t:Cell>$Resource{perDaBing}</t:Cell><t:Cell>$Resource{perGongjijin}</t:Cell><t:Cell>$Resource{perAll}</t:Cell><t:Cell>$Resource{beforeTaxMoney}</t:Cell><t:Cell>$Resource{freeTaxMoney}</t:Cell><t:Cell>$Resource{ljyssde}</t:Cell><t:Cell>$Resource{grzxkcAmount}</t:Cell><t:Cell>$Resource{yssde}</t:Cell><t:Cell>$Resource{tax}</t:Cell><t:Cell>$Resource{sjkcs}</t:Cell><t:Cell>$Resource{ljgrsds}</t:Cell><t:Cell>$Resource{dkgrsds}</t:Cell><t:Cell>$Resource{mwBase}</t:Cell><t:Cell>$Resource{dianpingSub}</t:Cell><t:Cell>$Resource{kfSub}</t:Cell><t:Cell>$Resource{payUp}</t:Cell><t:Cell>$Resource{buchangAmount}</t:Cell><t:Cell>$Resource{shifa}</t:Cell><t:Cell>$Resource{tiepiao}</t:Cell><t:Cell>$Resource{guaiaitong}</t:Cell><t:Cell>$Resource{laowuMoney}</t:Cell><t:Cell>$Resource{qitamoshi}</t:Cell><t:Cell>$Resource{jifenAll}</t:Cell><t:Cell>$Resource{tiepiaoSer}</t:Cell><t:Cell>$Resource{guanaitongSer}</t:Cell><t:Cell>$Resource{shouxufei}</t:Cell><t:Cell>$Resource{otherSer}</t:Cell><t:Cell>$Resource{serviceAll}</t:Cell><t:Cell>$Resource{shouldYearBouns}</t:Cell><t:Cell>$Resource{yearTax}</t:Cell><t:Cell>$Resource{realyearAmount}</t:Cell><t:Cell>$Resource{realAmount}</t:Cell><t:Cell>$Resource{comyanglao}</t:Cell><t:Cell>$Resource{comyiliao}</t:Cell><t:Cell>$Resource{comdabing}</t:Cell><t:Cell>$Resource{comshiye}</t:Cell><t:Cell>$Resource{comgongshang}</t:Cell><t:Cell>$Resource{comshengyu}</t:Cell><t:Cell>$Resource{comgongjijin}</t:Cell><t:Cell>$Resource{fuwufei}</t:Cell><t:Cell>$Resource{shuijin}</t:Cell><t:Cell>$Resource{comAll}</t:Cell><t:Cell>$Resource{LC}</t:Cell><t:Cell>$Resource{basemoney}</t:Cell><t:Cell>$Resource{fentanother}</t:Cell><t:Cell>$Resource{nianzhongfentan}</t:Cell><t:Cell>$Resource{jidufentan}</t:Cell><t:Cell>$Resource{nianzhong}</t:Cell><t:Cell>$Resource{jidu}</t:Cell><t:Cell>$Resource{yuedurenliAll}</t:Cell><t:Cell>$Resource{yingshuiMoney}</t:Cell><t:Cell>$Resource{geshui}</t:Cell><t:Cell>$Resource{BaoDiBonus}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.tblMain.setFormatXml(resHelper.translateString("tblMain",tblMainStrXML));
                this.tblMain.putBindContents("mainQuery",new String[] {"number","name","simpleName","description","createTime","lastUpdateTime","creator.number","creator.name","lastUpdateUser.number","lastUpdateUser.name","id","cityid","cityNumber","cityName","companyid","companyNumber","companyName","personid","personNumber","personName","businessdate","costCenterNumber","iscount","post","emptype","postTypeNumber","postType","indate","leaveDate","workYear","bingjiaPro","cardNumber","jibengongzi","postAllow","workYearAllow","learnAllow","cardAllow","houseAllow","achieveMoney","monthMoney","queqin","shijia","bingjia","kaoqinSub","chidaoSub","gdAllow","allWorkAllow","foodAllow","addWorkAllow","other","gdMoney","XRayAllow","holderMoney","assMoney","zbPro","shopHelp","zxCard","splitUp","zxLeave","docLeave","docAssCost","assToDoc","otherWaiMoney","waiAllMoney","marktMoney","scalMoney","mbAmount","docAmount","kfAmount","hlAmount","zxAmount","shopTarMoney","clinicAchiMoney","otherNeiMoney","bdProjectAll","monthBase","bdMonthProject","payble","achieveAll","seaBase","seaBuzu","shouldPay","realShouldPay","perYanglao","perYiliao","perShiye","perDaBing","perGongjijin","perAll","beforeTaxMoney","freeTaxMoney","ljyssde","grzxkcAmount","yssde","tax","sjkcs","ljgrsds","dkgrsds","mwBase","dianpingSub","kfSub","payUp","buchangAmount","shifa","tiepiao","guaiaitong","laowuMoney","qitamoshi","jifenAll","tiepiaoSer","guanaitongSer","shouxufei","otherSer","serviceAll","shouldYearBouns","yearTax","realyearAmount","realAmount","comyanglao","comyiliao","comdabing","comshiye","comgongshang","comshengyu","comgongjijin","fuwufei","shuijin","comAll","LC","basemoney","fentanother","nianzhongfentan","jidufentan","nianzhong","jidu","yuedurenliAll","yingshuiMoney","geshui","BaoDiBonus"});


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
	    return "com.kingdee.eas.mw.pay.app.PaySheetDetailListUIHandler";
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
        return new MetaDataPK("com.kingdee.eas.mw.pay.client", "PaySheetDetailListUI");
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
        return objectValue;
    }




}