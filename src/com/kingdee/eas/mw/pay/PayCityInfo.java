package com.kingdee.eas.mw.pay;

import java.io.Serializable;

public class PayCityInfo extends AbstractPayCityInfo implements Serializable 
{
    public PayCityInfo()
    {
        super();
    }
    protected PayCityInfo(String pkField)
    {
        super(pkField);
    }
}