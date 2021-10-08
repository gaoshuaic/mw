package com.kingdee.eas.mw.pay;

import java.io.Serializable;

public class HolderDataSourceInfo extends AbstractHolderDataSourceInfo implements Serializable 
{
    public HolderDataSourceInfo()
    {
        super();
    }
    protected HolderDataSourceInfo(String pkField)
    {
        super(pkField);
    }
}