package com.kingdee.eas.mw.pay;

import java.io.Serializable;

public class CostDetailInfo extends AbstractCostDetailInfo implements Serializable 
{
    public CostDetailInfo()
    {
        super();
    }
    protected CostDetailInfo(String pkField)
    {
        super(pkField);
    }
}