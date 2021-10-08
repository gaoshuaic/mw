package com.kingdee.eas.mw.srqr;

import java.io.Serializable;

public class PayItemInfo extends AbstractPayItemInfo implements Serializable 
{
    public PayItemInfo()
    {
        super();
    }
    protected PayItemInfo(String pkField)
    {
        super(pkField);
    }
}