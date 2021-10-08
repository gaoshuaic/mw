package com.kingdee.eas.mw.pay;

import java.io.Serializable;

public class PayPostInfo extends AbstractPayPostInfo implements Serializable 
{
    public PayPostInfo()
    {
        super();
    }
    protected PayPostInfo(String pkField)
    {
        super(pkField);
    }
}