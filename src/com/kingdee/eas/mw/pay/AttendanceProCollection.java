package com.kingdee.eas.mw.pay;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class AttendanceProCollection extends AbstractObjectCollection 
{
    public AttendanceProCollection()
    {
        super(AttendanceProInfo.class);
    }
    public boolean add(AttendanceProInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(AttendanceProCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(AttendanceProInfo item)
    {
        return removeObject(item);
    }
    public AttendanceProInfo get(int index)
    {
        return(AttendanceProInfo)getObject(index);
    }
    public AttendanceProInfo get(Object key)
    {
        return(AttendanceProInfo)getObject(key);
    }
    public void set(int index, AttendanceProInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(AttendanceProInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(AttendanceProInfo item)
    {
        return super.indexOf(item);
    }
}