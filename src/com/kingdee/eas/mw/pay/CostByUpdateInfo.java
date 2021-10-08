package com.kingdee.eas.mw.pay;

import java.io.Serializable;

public class CostByUpdateInfo extends AbstractCostByUpdateInfo implements Serializable 
{
    public CostByUpdateInfo()
    {
        super();
    }
    protected CostByUpdateInfo(String pkField)
    {
        super(pkField);
    }
}