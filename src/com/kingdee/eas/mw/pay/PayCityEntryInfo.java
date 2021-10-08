package com.kingdee.eas.mw.pay;

import java.io.Serializable;

public class PayCityEntryInfo extends AbstractPayCityEntryInfo implements Serializable 
{
    public PayCityEntryInfo()
    {
        super();
    }
    protected PayCityEntryInfo(String pkField)
    {
        super(pkField);
    }
}