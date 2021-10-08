package com.kingdee.eas.mw.pay;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class AttendanceHoursCollection extends AbstractObjectCollection 
{
    public AttendanceHoursCollection()
    {
        super(AttendanceHoursInfo.class);
    }
    public boolean add(AttendanceHoursInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(AttendanceHoursCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(AttendanceHoursInfo item)
    {
        return removeObject(item);
    }
    public AttendanceHoursInfo get(int index)
    {
        return(AttendanceHoursInfo)getObject(index);
    }
    public AttendanceHoursInfo get(Object key)
    {
        return(AttendanceHoursInfo)getObject(key);
    }
    public void set(int index, AttendanceHoursInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(AttendanceHoursInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(AttendanceHoursInfo item)
    {
        return super.indexOf(item);
    }
}