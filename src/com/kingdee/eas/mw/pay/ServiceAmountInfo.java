package com.kingdee.eas.mw.pay;

import java.io.Serializable;

public class ServiceAmountInfo extends AbstractServiceAmountInfo implements Serializable 
{
    public ServiceAmountInfo()
    {
        super();
    }
    protected ServiceAmountInfo(String pkField)
    {
        super(pkField);
    }
}