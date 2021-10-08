package com.kingdee.eas.mw.pay;

import java.io.Serializable;

public class CostSumInfo extends AbstractCostSumInfo implements Serializable 
{
    public CostSumInfo()
    {
        super();
    }
    protected CostSumInfo(String pkField)
    {
        super(pkField);
    }
}