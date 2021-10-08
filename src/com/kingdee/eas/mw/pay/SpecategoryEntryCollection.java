package com.kingdee.eas.mw.pay;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class SpecategoryEntryCollection extends AbstractObjectCollection 
{
    public SpecategoryEntryCollection()
    {
        super(SpecategoryEntryInfo.class);
    }
    public boolean add(SpecategoryEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(SpecategoryEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(SpecategoryEntryInfo item)
    {
        return removeObject(item);
    }
    public SpecategoryEntryInfo get(int index)
    {
        return(SpecategoryEntryInfo)getObject(index);
    }
    public SpecategoryEntryInfo get(Object key)
    {
        return(SpecategoryEntryInfo)getObject(key);
    }
    public void set(int index, SpecategoryEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(SpecategoryEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(SpecategoryEntryInfo item)
    {
        return super.indexOf(item);
    }
}