package com.kingdee.eas.mw.pay;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class DoctorRelationCollection extends AbstractObjectCollection 
{
    public DoctorRelationCollection()
    {
        super(DoctorRelationInfo.class);
    }
    public boolean add(DoctorRelationInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(DoctorRelationCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(DoctorRelationInfo item)
    {
        return removeObject(item);
    }
    public DoctorRelationInfo get(int index)
    {
        return(DoctorRelationInfo)getObject(index);
    }
    public DoctorRelationInfo get(Object key)
    {
        return(DoctorRelationInfo)getObject(key);
    }
    public void set(int index, DoctorRelationInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(DoctorRelationInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(DoctorRelationInfo item)
    {
        return super.indexOf(item);
    }
}