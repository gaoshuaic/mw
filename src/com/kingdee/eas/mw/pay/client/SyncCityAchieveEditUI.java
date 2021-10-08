/**
 * output package name
 */
package com.kingdee.eas.mw.pay.client;

import java.awt.AWTEvent;
import java.awt.AWTException;
import java.awt.AWTKeyStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.FocusTraversalPolicy;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.ImageCapabilities;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.MenuComponent;
import java.awt.Point;
import java.awt.PopupMenu;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.dnd.DropTarget;
import java.awt.event.*;
import java.awt.im.InputContext;
import java.awt.im.InputMethodRequests;
import java.awt.image.ColorModel;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.awt.image.VolatileImage;
import java.awt.peer.ComponentPeer;
import java.beans.PropertyChangeListener;
import java.beans.PropertyVetoException;
import java.beans.VetoableChangeListener;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.EventListener;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import javax.accessibility.AccessibleContext;
import javax.swing.InputVerifier;
import javax.swing.JButton;
import javax.swing.JPopupMenu;
import javax.swing.JRootPane;
import javax.swing.JToolTip;
import javax.swing.KeyStroke;
import javax.swing.TransferHandler;
import javax.swing.border.Border;
import javax.swing.event.AncestorListener;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.PanelUI;

import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.ui.face.IUIObject;
import com.kingdee.eas.base.permission.UserInfo;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.basedata.org.CtrlUnitInfo;
import com.kingdee.eas.common.client.SysContext;

import org.apache.log4j.Logger;

import com.kingdee.bos.metadata.IMetaDataPK;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ui.face.IUIObject;
import com.kingdee.bos.ui.face.IUIWindow;
import com.kingdee.bos.ui.face.ItemAction;
import com.kingdee.bos.ui.face.UIParam;
import com.kingdee.bos.ui.util.IUIActionPostman;
import com.kingdee.bos.appframework.uip.ControllerBase;
import com.kingdee.bos.appframework.uip.UINavigator;
import com.kingdee.bos.appframework.uistatemanage.ActionManager;
import com.kingdee.bos.appframework.validator.Validator;
import com.kingdee.bos.ctrl.swing.KDMenuBar;
import com.kingdee.bos.ctrl.swing.KDPanel;
import com.kingdee.bos.ctrl.swing.KDStatusBar;
import com.kingdee.bos.ctrl.swing.KDToolBar;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.query.ISQLExecutor;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.mw.pay.ISyncDataFacade;
import com.kingdee.eas.mw.pay.SyncDataFacadeFactory;
import com.kingdee.eas.mw.srqr.app.util.PayBeiJingDocFunctionService;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.jdbc.rowset.IRowSet;

/**
 * output class name
 */
public class SyncCityAchieveEditUI extends AbstractSyncCityAchieveEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(SyncCityAchieveEditUI.class);
    
    /**
     * output class constructor
     */
    public SyncCityAchieveEditUI() throws Exception
    {
        super();
    }

	/**
     * output storeFields method
     */
    public void storeFields()
    {
        super.storeFields();
    }

    
	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();  
		
		UserInfo userInfo=  SysContext.getSysContext().getCurrentUserInfo(); 
		String cuid = userInfo.getCU().getId().toString();
        String userid =  userInfo.getId().toString(); 
         
        boolean flagOrg = false;  
		String orgSql  = " SELECT count(1) as C FROM  T_PM_UserRoleOrg roleorg left  join T_PM_Role role on roleorg.FROLEID = role.fid  where role.fnumber ='xinchoucity' and   roleorg.FUSERID  =  '"+userid+"'  ";
        ISQLExecutor executorOrg =  SQLExecutorFactory.getRemoteInstance(orgSql);
        IRowSet orgrs = executorOrg.executeSQL(); //获取结果集 
        if(orgrs!=null && orgrs.size() > 0){
			  while(orgrs.next()){	
				  if(orgrs.getObject("C")!=null && !"".equals(orgrs.getObject("C").toString()))
					 if( Integer.parseInt(orgrs.getObject("C").toString()) > 0 )
						 flagOrg = true; 
			  }
		 }  
        if("256c221a-0106-1000-e000-10d7c0a813f413B7DE7F".equals(userid)){flagOrg = true; }
        if(flagOrg){
        	String citysql = "";
        	if("00000000-0000-0000-0000-000000000000CCE7AED4".equals(cuid)){
        		citysql = " select CFCityID from  CT_PAY_PayCity  ";
        	}else{
        		citysql = "  select distinct  bill.cfcityid as  CFCityID from  CT_PAY_PayCity bill left join CT_PAY_PayCityentry entry on bill.fid = entry.fparentid  where entry.cfincludecityid = '"+cuid+"'  ";
        	}
        	 
    		//String citysql = " select CFCityID from  CT_PAY_PayCity  ";
    		String cityStr = "";
    		ISQLExecutor executor = SQLExecutorFactory.getRemoteInstance(citysql);
    		IRowSet rs = executor.executeSQL(); //获取结果集
    		while(rs.next()){ 
    			String cityid = rs.getString("CFCITYID"); 
    			cityStr = cityStr + cityid + ",";
    		}
    		 
    		cityStr = cityStr.substring(0,cityStr.length()-1);
    		
    		EntityViewInfo view = new EntityViewInfo();
    		FilterInfo filter = new FilterInfo();
    		filter.getFilterItems().add(new FilterItemInfo("ID", cityStr,CompareType.INCLUDE));
    		kDBizPromptBoxCity.setEntityViewInfo(view);
    		view.setFilter(filter);
    		 
        }else{
        	EntityViewInfo view = new EntityViewInfo();
    		FilterInfo filter = new FilterInfo();
    		filter.getFilterItems().add(new FilterItemInfo("ID", "",CompareType.INCLUDE));
    		kDBizPromptBoxCity.setEntityViewInfo(view);
    		view.setFilter(filter);
        }
        
 
	}

	@Override
	protected void kDButtonOK_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		//super.kDButtonOK_actionPerformed(e);  
		
    	if(this.kDBizPromptBoxCity.getText() != null && !this.kDBizPromptBoxCity.getText().equals("")){
    		String cityNumber = ((CtrlUnitInfo)this.kDBizPromptBoxCity.getData()).getNumber();
    		String cityName = ((CtrlUnitInfo)this.kDBizPromptBoxCity.getData()).getName();
    		ISyncDataFacade iSyncDataFacade = SyncDataFacadeFactory.getRemoteInstance();
        	String msg = iSyncDataFacade.SyncCityMessage(cityNumber, cityName);
        	if(msg.equals("")){
        		this.disposeUIWindow();
            	MsgBox.showConfirm2("同步信息已发送。");
        	}else{
        		MsgBox.showConfirm2("系统出现异常。");
        	}
    		
			 
		}else{ 
			MsgBox.showConfirm2("请选择城市。");
		}
    
    	
		
	}

	@Override
	protected void kDButtonOFF_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.kDButtonOFF_actionPerformed(e);
		this.disposeUIWindow();
	} 
    
}