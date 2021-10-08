package com.kingdee.eas.mw.pay;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class ClinicComSubCollection extends AbstractObjectCollection 
{
    public ClinicComSubCollection()
    {
        super(ClinicComSubInfo.class);
    }
    public boolean add(ClinicComSubInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(ClinicComSubCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(ClinicComSubInfo item)
    {
        return removeObject(item);
    }
    public ClinicComSubInfo get(int index)
    {
        return(ClinicComSubInfo)getObject(index);
    }
    public ClinicComSubInfo get(Object key)
    {
        return(ClinicComSubInfo)getObject(key);
    }
    public void set(int index, ClinicComSubInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(ClinicComSubInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(ClinicComSubInfo item)
    {
        return super.indexOf(item);
    }
}