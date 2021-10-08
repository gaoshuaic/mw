package com.kingdee.eas.mw.srqr;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class FreeItemCheckEntryCollection extends AbstractObjectCollection 
{
    public FreeItemCheckEntryCollection()
    {
        super(FreeItemCheckEntryInfo.class);
    }
    public boolean add(FreeItemCheckEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(FreeItemCheckEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(FreeItemCheckEntryInfo item)
    {
        return removeObject(item);
    }
    public FreeItemCheckEntryInfo get(int index)
    {
        return(FreeItemCheckEntryInfo)getObject(index);
    }
    public FreeItemCheckEntryInfo get(Object key)
    {
        return(FreeItemCheckEntryInfo)getObject(key);
    }
    public void set(int index, FreeItemCheckEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(FreeItemCheckEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(FreeItemCheckEntryInfo item)
    {
        return super.indexOf(item);
    }
}