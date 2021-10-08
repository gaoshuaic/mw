package com.kingdee.eas.mw.srqr;

import java.io.Serializable;

public class ClinicItemInfo extends AbstractClinicItemInfo implements Serializable 
{
    public ClinicItemInfo()
    {
        super();
    }
    protected ClinicItemInfo(String pkField)
    {
        super(pkField);
    }
}