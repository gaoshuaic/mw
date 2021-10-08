package com.kingdee.eas.mw.srqr;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class ClinicItemCollection extends AbstractObjectCollection 
{
    public ClinicItemCollection()
    {
        super(ClinicItemInfo.class);
    }
    public boolean add(ClinicItemInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(ClinicItemCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(ClinicItemInfo item)
    {
        return removeObject(item);
    }
    public ClinicItemInfo get(int index)
    {
        return(ClinicItemInfo)getObject(index);
    }
    public ClinicItemInfo get(Object key)
    {
        return(ClinicItemInfo)getObject(key);
    }
    public void set(int index, ClinicItemInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(ClinicItemInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(ClinicItemInfo item)
    {
        return super.indexOf(item);
    }
}