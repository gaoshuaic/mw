package com.kingdee.eas.mw.srqr;

import java.io.Serializable;

public class CostCenterInfo extends AbstractCostCenterInfo implements Serializable 
{
    public CostCenterInfo()
    {
        super();
    }
    protected CostCenterInfo(String pkField)
    {
        super(pkField);
    }
}