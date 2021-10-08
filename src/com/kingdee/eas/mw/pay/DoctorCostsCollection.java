package com.kingdee.eas.mw.pay;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class DoctorCostsCollection extends AbstractObjectCollection 
{
    public DoctorCostsCollection()
    {
        super(DoctorCostsInfo.class);
    }
    public boolean add(DoctorCostsInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(DoctorCostsCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(DoctorCostsInfo item)
    {
        return removeObject(item);
    }
    public DoctorCostsInfo get(int index)
    {
        return(DoctorCostsInfo)getObject(index);
    }
    public DoctorCostsInfo get(Object key)
    {
        return(DoctorCostsInfo)getObject(key);
    }
    public void set(int index, DoctorCostsInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(DoctorCostsInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(DoctorCostsInfo item)
    {
        return super.indexOf(item);
    }
}