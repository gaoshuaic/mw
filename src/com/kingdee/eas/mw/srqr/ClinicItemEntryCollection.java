package com.kingdee.eas.mw.srqr;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class ClinicItemEntryCollection extends AbstractObjectCollection 
{
    public ClinicItemEntryCollection()
    {
        super(ClinicItemEntryInfo.class);
    }
    public boolean add(ClinicItemEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(ClinicItemEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(ClinicItemEntryInfo item)
    {
        return removeObject(item);
    }
    public ClinicItemEntryInfo get(int index)
    {
        return(ClinicItemEntryInfo)getObject(index);
    }
    public ClinicItemEntryInfo get(Object key)
    {
        return(ClinicItemEntryInfo)getObject(key);
    }
    public void set(int index, ClinicItemEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(ClinicItemEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(ClinicItemEntryInfo item)
    {
        return super.indexOf(item);
    }
}