/**
 * output package name
 */
package com.kingdee.eas.mw.srqr.client;

import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.log4j.Logger;

import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.mw.srqr.PayItemInfo;
import com.kingdee.eas.mw.srqr.PaytypeitemInfo;
import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.swing.event.DataChangeEvent;
import com.kingdee.bos.ctrl.swing.event.DataChangeListener;

/**
 * output class name
 */
public class SpecialItemEditUI extends AbstractSpecialItemEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(SpecialItemEditUI.class);
    PaytypeitemInfo oldPayItemInfo = null;
    /**
     * output class constructor
     */
    public SpecialItemEditUI() throws Exception
    {
        super();
    }
    /**
     * output loadFields method
     */
    public void loadFields()
    {
        super.loadFields();
        
        prmtcity.setQueryInfo("com.kingdee.eas.cp.bc.app.CtrlUnitF7Query"); 
        
        KDBizPromptBox prmtHfPerson = (KDBizPromptBox) kdtEntrys.getColumn("secondItem").getEditor().getComponent(); //获取表格特定列绑定的F7
    	prmtHfPerson.setEnabledMultiSelection(true);
    	EntityViewInfo view = new EntityViewInfo();
    	FilterInfo filter = new FilterInfo(); //过滤条件
    	filter.getFilterItems().add(new FilterItemInfo("status", "N")); //条件2，#1 
    	filter.setMaskString("#0 "); //3个过滤条件设定关系
    	view.setFilter(filter);
    	prmtHfPerson.setEntityViewInfo(view); //F7重新设定视图
    	prmtHfPerson.addDataChangeListener(new DataChangeListener() {
            public void dataChanged(DataChangeEvent e) {
                datachangeAction_dataChanged(e);
            }
        });
    }
    
    public void datachangeAction_dataChanged(DataChangeEvent e) {
    	KDBizPromptBox bizMaterialBox = (KDBizPromptBox)e.getSource(); 
    	ArrayList<PaytypeitemInfo> paytypeitemInfos =new ArrayList<PaytypeitemInfo>();
    	if(e.getOldValue() instanceof Object[]){
    		oldPayItemInfo = (PaytypeitemInfo) ((Object[]) e.getOldValue())[0];
    	}else if(e.getOldValue() instanceof PaytypeitemInfo){
    		oldPayItemInfo = (PaytypeitemInfo) e.getOldValue();
    	}else if(e.getOldValue() == null ){
    		oldPayItemInfo = null;
    	}
    	
    	if(bizMaterialBox.getValue() != null){
    		if (bizMaterialBox.getValue() instanceof Object[]) {
        		Object[] objArr = (Object[])bizMaterialBox.getValue();
        		 
        		for(int i=0;i<objArr.length;i++){
        			paytypeitemInfos.add((PaytypeitemInfo) objArr[i]);
        		}
        	} else if (bizMaterialBox.getValue() instanceof Object) {
        		Object obj  = (Object)bizMaterialBox.getValue();
        		paytypeitemInfos.add((PaytypeitemInfo) obj);
        	}
        	int rowCount = this.kdtEntrys.getRowCount();
        	
        	
        	int needRemove = 9999;
        	int jiluC = 99999;
        	HashMap<String, String> oldMap = new HashMap<String, String>(); 
        	if( !(bizMaterialBox.getValue() instanceof  PaytypeitemInfo) ){
        		for(int i=0;i<rowCount;i++){
            		if(this.kdtEntrys.getCell(i, 1).getValue()  != null  ){
            			if(this.kdtEntrys.getCell(i, 1).getValue()instanceof  PaytypeitemInfo ){
            				PaytypeitemInfo oldInfo=  (PaytypeitemInfo)this.kdtEntrys.getCell(i, 1).getValue() ;
            				if(oldPayItemInfo!= null && oldPayItemInfo.getNumber().equals(oldInfo.getNumber())){
            					needRemove = i ; 
            				}else{
            					oldMap.put(oldInfo.getNumber(), oldInfo.getNumber());
            				}
                    		
            			}else{
            				PaytypeitemInfo oldInfo=  (PaytypeitemInfo)(((Object[])this.kdtEntrys.getCell(i, 1).getValue())[0]);
            				if(oldPayItemInfo!= null && oldPayItemInfo.getNumber().equals(oldInfo.getNumber())){
            					needRemove = i ;
            				}else{
            					oldMap.put(oldInfo.getNumber(), oldInfo.getNumber());
            				}
                    		
            			}
            			
            		}else{
            			jiluC = i;
            		}
            		
            	}
        		
        		if(  needRemove!= 99999  ){
        			kdtEntrys.removeRow(needRemove);
            	}
        		//刚一开始  并且只选择一个
        		//if(rowCount == 1 && payItemInfos.size()==1){
        		if(rowCount == 1 || jiluC!= 99999  ){
        			kdtEntrys.removeRow(jiluC);
            	}
        		for(PaytypeitemInfo info :paytypeitemInfos){
            		String number = info.getNumber();
            		if( oldMap.get(number)==null  || "".equals(oldMap.get(number).toString())){
            			IRow row2 = this.kdtEntrys.addRow();  
                    	row2.getCell("secondItem").setValue(info);
            		}
            		
            	}
            	
        	}
        	
        	
    	}
    	 
    }  

    /**
     * output storeFields method
     */
    public void storeFields()
    {
        super.storeFields();
    }  

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.mw.srqr.SpecialItemFactory.getRemoteInstance();
    }

    /**
     * output createNewDetailData method
     */
    protected IObjectValue createNewDetailData(KDTable table)
    {
		
        return null;
    }

    /**
     * output createNewData method
     */
    protected com.kingdee.bos.dao.IObjectValue createNewData()
    {
        com.kingdee.eas.mw.srqr.SpecialItemInfo objectValue = new com.kingdee.eas.mw.srqr.SpecialItemInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
		
        return objectValue;
    }

}