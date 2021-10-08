package com.kingdee.eas.mw.pay;

import java.io.Serializable;

public class PayShareDetailInfo extends AbstractPayShareDetailInfo implements Serializable 
{
    public PayShareDetailInfo()
    {
        super();
    }
    protected PayShareDetailInfo(String pkField)
    {
        super(pkField);
    }
}