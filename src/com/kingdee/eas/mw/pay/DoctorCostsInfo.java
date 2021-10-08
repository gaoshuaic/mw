package com.kingdee.eas.mw.pay;

import java.io.Serializable;

public class DoctorCostsInfo extends AbstractDoctorCostsInfo implements Serializable 
{
    public DoctorCostsInfo()
    {
        super();
    }
    protected DoctorCostsInfo(String pkField)
    {
        super(pkField);
    }
}