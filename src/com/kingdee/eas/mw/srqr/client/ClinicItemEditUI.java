/**
 * output package name
 */
package com.kingdee.eas.mw.srqr.client;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.log4j.Logger;

import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent;
import com.kingdee.bos.ctrl.swing.event.DataChangeEvent;
import com.kingdee.bos.ctrl.swing.event.DataChangeListener;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.eas.basedata.org.CtrlUnitInfo;
import com.kingdee.eas.mw.srqr.PayItemInfo;
import com.kingdee.eas.mw.srqr.PaytypeitemInfo;


/**
 * output class name
 */
public class ClinicItemEditUI extends AbstractClinicItemEditUI  
{
    private static final Logger logger = CoreUIObject.getLogger(ClinicItemEditUI.class); 
    DataChangeListener reqDeptChangeListener = null;
    PayItemInfo oldPayItemInfo = null;
    

    public ClinicItemEditUI() throws Exception
    {
    	super();   
    }  
    /**
     * output class constructor
     */
    @Override
    public void loadFields()
    {
    	super.loadFields(); 
    	try {
    		initCityF7();
    		initItemTypeF7();
			//initEntryF7(false,"");
    		if(prmtcity.getValue() != null &&  prmtitemType.getValue() != null ){
    			initEntryF7(true,((PaytypeitemInfo)prmtitemType.getValue()).getId().toString(),"item");
    		}else{
    			KDBizPromptBox prmtHfPerson = (KDBizPromptBox) kdtEntrys.getColumn("item").getEditor().getComponent(); //获取表格特定列绑定的F7
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
    		
    		
        	
        	//KDBizPromptBox clinicF7 = (KDBizPromptBox) prmtclinic; //获取表格特定列绑定的F7
        	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
    }
        
 
	@Override
	public void onLoad() throws Exception { 
		super.onLoad(); 
		
		 
	} 
	
	 
	public void typeChanged(KDTEditEvent e) throws Exception{
		e.getOldValue();
	}
	
	 public void initCityF7( ) throws Exception {
		 
		 prmtcity.addDataChangeListener(new DataChangeListener(){ 
			@Override
			public void dataChanged(DataChangeEvent paramDataChangeEvent) {
				// TODO Auto-generated method stub
				CtrlUnitInfo in = (CtrlUnitInfo)paramDataChangeEvent.getNewValue();  
				try {
					initEntryF7(true,in.getId().toString(),"city");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} 
		  });
		prmtcity.setQueryInfo("com.kingdee.eas.mw.pay.app.PayCityQuery"); 
		 
		//prmtcity.setQueryInfo("com.kingdee.eas.cp.bc.app.CtrlUnitF7Query"); 
     	EntityViewInfo viewCity = new EntityViewInfo();
//     	FilterInfo filterCity = new FilterInfo(); //过滤条件
//     	filterCity.getFilterItems().add(new FilterItemInfo("id", " select distinct cfcity  from  CT_SRQ_ItemCity ",CompareType.INNER)); //条件2，#1 
//     	filterCity.setMaskString("#0 "); //3个过滤条件设定关系
//     	viewCity.setFilter(filterCity);
     	FilterInfo filterCity = new FilterInfo(); //过滤条件
     	filterCity.getFilterItems().add(new FilterItemInfo("ENTRY.SEQ", "1",CompareType.EQUALS)); //条件2，#1 
     	filterCity.setMaskString("#0 "); //3个过滤条件设定关系
     	viewCity.setFilter(filterCity);
     	
     	prmtcity.setEntityViewInfo(viewCity); //F7重新设定视图
		  
    	 
    }
	
	 public void initItemTypeF7(  ) throws Exception {
		 
			 prmtitemType.addDataChangeListener(new DataChangeListener(){ 
				@Override
				public void dataChanged(DataChangeEvent paramDataChangeEvent) {
					// TODO Auto-generated method stub
					PaytypeitemInfo in = (PaytypeitemInfo)paramDataChangeEvent.getNewValue();  
					try {
						initEntryF7(true,in.getId().toString(),"item");
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} 
			  });
		 	EntityViewInfo view = new EntityViewInfo();
	    	FilterInfo filter = new FilterInfo(); //过滤条件
	    	filter.getFilterItems().add(new FilterItemInfo("status", "N")); //条件2，#1 
        	filter.setMaskString("#0 "); //3个过滤条件设定关系
	    	view.setFilter(filter);
	    	prmtitemType.setEntityViewInfo(view); //F7重新设定视图
			  
	    	 
	    }
	
	
    public void initEntryF7(boolean flag ,String erjiID ,String type) throws Exception {
    	
    	KDBizPromptBox prmtHfPerson = (KDBizPromptBox) kdtEntrys.getColumn("item").getEditor().getComponent(); //获取表格特定列绑定的F7
    	prmtHfPerson.setEnabledMultiSelection(true);
    	EntityViewInfo view = new EntityViewInfo();
    	FilterInfo filter = new FilterInfo(); //过滤条件
    	if(flag){
    		if(type.equals("city")){
    			if(prmtitemType.getData() != null && ((PaytypeitemInfo)prmtitemType.getData()).getId()!= null){
//    				String itemid = ((PaytypeitemInfo)prmtitemType.getData()).getId().toString();
//    				filter.getFilterItems().add(new FilterItemInfo("number", "select  cfitem  from  CT_SRQ_ItemCity where cfcity = '"+erjiID+"'", CompareType.INNER)); //条件1，#0
//    				filter.getFilterItems().add(new FilterItemInfo("secondClass.id", itemid, CompareType.EQUALS)); //条件1，#0
//            		filter.getFilterItems().add(new FilterItemInfo("status", "N",CompareType.EQUALS)); //条件2，#1 
//                	filter.setMaskString("#0 and  #1 and #2 "); //3个过滤条件设定关系
    				
    				filter.getFilterItems().add(new FilterItemInfo("secondClass.id", erjiID, CompareType.EQUALS)); //条件1，#0
            		filter.getFilterItems().add(new FilterItemInfo("status", "N",CompareType.EQUALS)); //条件2，#1  
                	filter.setMaskString("#0 and  #1  "); //3个过滤条件设定关系
    			}else{
//    				filter.getFilterItems().add(new FilterItemInfo("number", "select  cfitem  from  CT_SRQ_ItemCity where cfcity = '"+erjiID+"'", CompareType.INNER)); //条件1，#0
//            		filter.getFilterItems().add(new FilterItemInfo("status", "N",CompareType.EQUALS)); //条件2，#1 
//                	filter.setMaskString("#0 and  #1  "); //3个过滤条件设定关系
    				
    				filter.getFilterItems().add(new FilterItemInfo("secondClass.id", erjiID, CompareType.EQUALS)); //条件1，#0
            		filter.getFilterItems().add(new FilterItemInfo("status", "N",CompareType.EQUALS)); //条件2，#1 
                	filter.setMaskString("#0 and  #1  "); //3个过滤条件设定关系
    			}
    			
    		}else if(type.equals("item")){
    			if(prmtcity.getData() != null && ((CtrlUnitInfo)prmtcity.getData()).getId()!= null){
//    				String cityid = ((CtrlUnitInfo)prmtcity.getData()).getId().toString();
//    				filter.getFilterItems().add(new FilterItemInfo("number", "select  cfitem  from  CT_SRQ_ItemCity where cfcity = '"+cityid+"'", CompareType.INNER)); //条件1，#0
//    				filter.getFilterItems().add(new FilterItemInfo("secondClass.id", erjiID, CompareType.EQUALS)); //条件1，#0
//            		filter.getFilterItems().add(new FilterItemInfo("status", "N",CompareType.EQUALS)); //条件2，#1 
//                	filter.setMaskString("#0 and  #1 and #2 "); //3个过滤条件设定关系
    				
    				filter.getFilterItems().add(new FilterItemInfo("secondClass.id", erjiID, CompareType.EQUALS)); //条件1，#0
            		filter.getFilterItems().add(new FilterItemInfo("status", "N",CompareType.EQUALS)); //条件2，#1 
                	filter.setMaskString("#0 and  #1  "); //3个过滤条件设定关系
    			}else{
    				filter.getFilterItems().add(new FilterItemInfo("secondClass.id", erjiID, CompareType.EQUALS)); //条件1，#0
            		filter.getFilterItems().add(new FilterItemInfo("status", "N",CompareType.EQUALS)); //条件2，#1 
                	filter.setMaskString("#0 and  #1  "); //3个过滤条件设定关系
    			}
    		}
    		
    	}else{
    		filter.getFilterItems().add(new FilterItemInfo("status", "N")); //条件2，#1 
        	filter.setMaskString("#0 "); //3个过滤条件设定关系
    	}
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
    	ArrayList<PayItemInfo> payItemInfos =new ArrayList<PayItemInfo>();
    	if(e.getOldValue() instanceof Object[]){
    		oldPayItemInfo = (PayItemInfo) ((Object[]) e.getOldValue())[0];
    	}else if(e.getOldValue() instanceof PayItemInfo){
    		oldPayItemInfo = (PayItemInfo) e.getOldValue();
    	}else if(e.getOldValue() == null ){
    		oldPayItemInfo = null;
    	}
    	
    	if(bizMaterialBox.getValue() != null){
    		if (bizMaterialBox.getValue() instanceof Object[]) {
        		Object[] objArr = (Object[])bizMaterialBox.getValue();
        		 
        		for(int i=0;i<objArr.length;i++){
        			payItemInfos.add((PayItemInfo) objArr[i]);
        		}
        	} else if (bizMaterialBox.getValue() instanceof Object) {
        		Object obj  = (Object)bizMaterialBox.getValue();
        		payItemInfos.add((PayItemInfo) obj);
        	}
        	int rowCount = this.kdtEntrys.getRowCount();
        	
        	
        	int needRemove = 9999;
        	int jiluC = 99999;
        	HashMap<String, String> oldMap = new HashMap<String, String>(); 
        	if( !(bizMaterialBox.getValue() instanceof  PayItemInfo) ){
        		for(int i=0;i<rowCount;i++){
            		if(this.kdtEntrys.getCell(i, 1).getValue()  != null  ){
            			if(this.kdtEntrys.getCell(i, 1).getValue()instanceof  PayItemInfo ){
            				PayItemInfo oldInfo=  (PayItemInfo)this.kdtEntrys.getCell(i, 1).getValue() ;
            				if(oldPayItemInfo!= null && oldPayItemInfo.getNumber().equals(oldInfo.getNumber())){
            					needRemove = i ; 
            				}else{
            					oldMap.put(oldInfo.getNumber(), oldInfo.getNumber());
            				}
                    		
            			}else{
            				PayItemInfo oldInfo=  (PayItemInfo)(((Object[])this.kdtEntrys.getCell(i, 1).getValue())[0]);
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
        		for(PayItemInfo info :payItemInfos){
            		String number = info.getNumber();
            		if( oldMap.get(number)==null  || "".equals(oldMap.get(number).toString())){
            			IRow row2 = this.kdtEntrys.addRow();  
                    	row2.getCell("item").setValue(info);
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
     * output createNewData method
     */
    protected com.kingdee.bos.dao.IObjectValue createNewData()
    {
        com.kingdee.eas.mw.srqr.ClinicItemInfo objectValue = new com.kingdee.eas.mw.srqr.ClinicItemInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
		
        return objectValue;
    }


	@Override
	protected IObjectValue createNewDetailData(KDTable arg0) {
		// TODO Auto-generated method stub
		return null;
	}
 
}