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
public abstract class AbstractSyncCityAchieveEditUI extends CoreUIObject
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractSyncCityAchieveEditUI.class);
    protected ResourceBundleHelper resHelper = null;
    protected com.kingdee.bos.ctrl.swing.KDToolBar SyncCityAchieveEditUI_toolbar;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox kDBizPromptBoxCity;
    protected com.kingdee.bos.ctrl.swing.KDLabel kDLabel1;
    protected com.kingdee.bos.ctrl.swing.KDButton kDButtonOK;
    protected com.kingdee.bos.ctrl.swing.KDButton kDButtonOFF;
    /**
     * output class constructor
     */
    public AbstractSyncCityAchieveEditUI() throws Exception
    {
        super();
        jbInit();
        
        initUIP();
    }

    /**
     * output jbInit method
     */
    private void jbInit() throws Exception
    {
        this.resHelper = new ResourceBundleHelper(AbstractSyncCityAchieveEditUI.class.getName());
        this.setUITitle(resHelper.getString("this.title"));
        this.toolBar = new com.kingdee.bos.ctrl.swing.KDToolBar();
        this.menuBar = new com.kingdee.bos.ctrl.swing.KDMenuBar();
        this.kDBizPromptBoxCity = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDLabel1 = new com.kingdee.bos.ctrl.swing.KDLabel();
        this.kDButtonOK = new com.kingdee.bos.ctrl.swing.KDButton();
        this.kDButtonOFF = new com.kingdee.bos.ctrl.swing.KDButton();
        this.setName("SyncCityAchieveEditUI");
        this.toolBar.setName("SyncCityAchieveEditUI_toolbar");
        this.menuBar.setName("SyncCityAchieveEditUI_menubar");
        this.kDBizPromptBoxCity.setName("kDBizPromptBoxCity");
        this.kDLabel1.setName("kDLabel1");
        this.kDButtonOK.setName("kDButtonOK");
        this.kDButtonOFF.setName("kDButtonOFF");
        // SyncCityAchieveEditUI
        // SyncCityAchieveEditUI_toolbar
        // SyncCityAchieveEditUI_menubar
        // kDBizPromptBoxCity		
        this.kDBizPromptBoxCity.setQueryInfo("com.kingdee.eas.cp.bc.app.CtrlUnitF7Query");		
        this.kDBizPromptBoxCity.setDisplayFormat("$name$");		
        this.kDBizPromptBoxCity.setEditFormat("$number$");		
        this.kDBizPromptBoxCity.setCommitFormat("$number$");		
        this.kDBizPromptBoxCity.setEditable(true);
        // kDLabel1		
        this.kDLabel1.setText(resHelper.getString("kDLabel1.text"));
        // kDButtonOK		
        this.kDButtonOK.setText(resHelper.getString("kDButtonOK.text"));
        this.kDButtonOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    kDButtonOK_actionPerformed(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
        // kDButtonOFF		
        this.kDButtonOFF.setText(resHelper.getString("kDButtonOFF.text"));
        this.kDButtonOFF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    kDButtonOFF_actionPerformed(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
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
		list.add(this.toolBar);
		return (com.kingdee.bos.ctrl.swing.KDToolBar[])list.toArray(new com.kingdee.bos.ctrl.swing.KDToolBar[list.size()]);
	}




    /**
     * output initUIContentLayout method
     */
    public void initUIContentLayout()
    {
        this.setBounds(new Rectangle(10, 10, 300, 150));
        this.setLayout(null);
        kDBizPromptBoxCity.setBounds(new Rectangle(115, 34, 170, 19));
        this.add(kDBizPromptBoxCity, null);
        kDLabel1.setBounds(new Rectangle(26, 34, 100, 19));
        this.add(kDLabel1, null);
        kDButtonOK.setBounds(new Rectangle(32, 96, 73, 21));
        this.add(kDButtonOK, null);
        kDButtonOFF.setBounds(new Rectangle(200, 96, 73, 21));
        this.add(kDButtonOFF, null);

    }


    /**
     * output initUIMenuBarLayout method
     */
    public void initUIMenuBarLayout()
    {

    }

    /**
     * output initUIToolBarLayout method
     */
    public void initUIToolBarLayout()
    {


    }

	//Regiester control's property binding.
	private void registerBindings(){		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.mw.pay.app.SyncCityAchieveEditUIHandler";
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

    /**
     * output kDButtonOK_actionPerformed method
     */
    protected void kDButtonOK_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
    }

    /**
     * output kDButtonOFF_actionPerformed method
     */
    protected void kDButtonOFF_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
    }

    /**
     * output getSelectors method
     */
    public SelectorItemCollection getSelectors()
    {
        SelectorItemCollection sic = new SelectorItemCollection();
        return sic;
    }        

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.mw.pay.client", "SyncCityAchieveEditUI");
    }




}