/**
 * output package name
 */
package com.kingdee.eas.mw.srqr.client;

import java.awt.event.*;
import org.apache.log4j.Logger;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.eas.framework.*;

/**
 * output class name
 */
public class CostComputeHeaderLogListUI extends AbstractCostComputeHeaderLogListUI
{
    private static final Logger logger = CoreUIObject.getLogger(CostComputeHeaderLogListUI.class);
    
    /**
     * output class constructor
     */
    public CostComputeHeaderLogListUI() throws Exception
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
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.mw.srqr.CostComputeHeaderLogFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected com.kingdee.bos.dao.IObjectValue createNewData()
    {
        com.kingdee.eas.mw.srqr.CostComputeHeaderLogInfo objectValue = new com.kingdee.eas.mw.srqr.CostComputeHeaderLogInfo();
		
        return objectValue;
    }

}