/**
 * output package name
 */
package com.kingdee.eas.mw.pay.client;

import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.Logger;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.mw.pay.CostSumFactory;
import com.kingdee.eas.mw.pay.ICostSum;
import com.kingdee.eas.mw.pay.ISyncDataFacade;
import com.kingdee.eas.mw.pay.SyncDataFacadeFactory;
import com.kingdee.eas.mw.srqr.app.util.PayBeiJingDocFunctionService;
import com.kingdee.eas.util.client.MsgBox;

/**
 * output class name
 */
public class SelectCostDateEditUI extends AbstractSelectCostDateEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(SelectCostDateEditUI.class);
    
    /**
     * output class constructor
     */
    public SelectCostDateEditUI() throws Exception
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

    /**
     * output kDDatePicker1_dataChanged method
     */
    protected void kDDatePicker1_dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) throws Exception
    {
        super.kDDatePicker1_dataChanged(e);
    }
    @Override
	protected void Butno_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.Butno_actionPerformed(e); 
		this.disposeUIWindow();
	}
    @Override
    public void Butok_actionPerformed(ActionEvent e) throws Exception{
        //write your code here
    	//super.Butok_actionPerformed(e); 
    	String  businessdate = "";
    	
    	if(this.kDDatePicker1.getText() == null || this.kDDatePicker1.getText().equals("")){
    		PayBeiJingDocFunctionService payDocFunctionService= new PayBeiJingDocFunctionService();
    		Calendar cal = Calendar.getInstance();
            cal.setTime(new Date());
            cal.add(Calendar.MONTH, -1);
            
            Date date3 = cal.getTime();
            SimpleDateFormat format3= new SimpleDateFormat("yyyyMM");
            businessdate = format3.format(date3); 
			 
		}else{
			businessdate = this.kDDatePicker1.getText().toString().substring(0,7).replace("-", "");
		}
    	ISyncDataFacade iSyncDataFacade = SyncDataFacadeFactory.getRemoteInstance();
    	iSyncDataFacade.createCostBuUser(businessdate);
    	 this.disposeUIWindow();
    	MsgBox.showConfirm2("成本汇总生成完成。");
	   
  }
    

      
}