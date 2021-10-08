/**
 * output package name
 */
package com.kingdee.eas.mw.srqr.client;

import java.awt.event.*;

import org.apache.log4j.Logger;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.mw.srqr.SaleIssueSyncFacadeFactory;
import com.kingdee.eas.util.client.MsgBox;

/**
 * output class name
 */
public class SaleIssueHisLogListUI extends AbstractSaleIssueHisLogListUI
{
    private static final Logger logger = CoreUIObject.getLogger(SaleIssueHisLogListUI.class);
    
    /**
     * output class constructor
     */
    public SaleIssueHisLogListUI() throws Exception
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
	public void actionAbout_actionPerformed(ActionEvent e) throws Exception {
    	MsgBox.showInfo("ͬ�����۳���--���۳����¼--begin");
    	SaleIssueSyncFacadeFactory.getRemoteInstance().syncSaleIssueBill();
    	MsgBox.showInfo("ͬ�����۳���--���۳����¼--end");
	}
    @Override
    public void actionHelp_actionPerformed(ActionEvent e) throws Exception {
     	MsgBox.showInfo("ͬ�����۳����¼--�м��--begin");
    	SaleIssueSyncFacadeFactory.getRemoteInstance().syncIssueLogToMid("04");
    	MsgBox.showInfo("ͬ�����۳����¼--�м��--end");
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.mw.srqr.SaleIssueHisLogFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected com.kingdee.bos.dao.IObjectValue createNewData()
    {
        com.kingdee.eas.mw.srqr.SaleIssueHisLogInfo objectValue = new com.kingdee.eas.mw.srqr.SaleIssueHisLogInfo();
		
        return objectValue;
    }

}