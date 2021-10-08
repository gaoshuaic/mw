package com.kingdee.eas.mw.pay;

import java.io.Serializable;

public class AttendanceHoursInfo extends AbstractAttendanceHoursInfo implements Serializable 
{
    public AttendanceHoursInfo()
    {
        super();
    }
    protected AttendanceHoursInfo(String pkField)
    {
        super(pkField);
    }
}