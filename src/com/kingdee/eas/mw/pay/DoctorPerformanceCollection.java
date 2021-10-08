package com.kingdee.eas.mw.pay;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class DoctorPerformanceCollection extends AbstractObjectCollection 
{
    public DoctorPerformanceCollection()
    {
        super(DoctorPerformanceInfo.class);
    }
    public boolean add(DoctorPerformanceInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(DoctorPerformanceCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(DoctorPerformanceInfo item)
    {
        return removeObject(item);
    }
    public DoctorPerformanceInfo get(int index)
    {
        return(DoctorPerformanceInfo)getObject(index);
    }
    public DoctorPerformanceInfo get(Object key)
    {
        return(DoctorPerformanceInfo)getObject(key);
    }
    public void set(int index, DoctorPerformanceInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(DoctorPerformanceInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(DoctorPerformanceInfo item)
    {
        return super.indexOf(item);
    }
}