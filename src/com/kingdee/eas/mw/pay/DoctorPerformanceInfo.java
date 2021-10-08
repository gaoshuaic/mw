package com.kingdee.eas.mw.pay;

import java.io.Serializable;

public class DoctorPerformanceInfo extends AbstractDoctorPerformanceInfo implements Serializable 
{
    public DoctorPerformanceInfo()
    {
        super();
    }
    protected DoctorPerformanceInfo(String pkField)
    {
        super(pkField);
    }
}