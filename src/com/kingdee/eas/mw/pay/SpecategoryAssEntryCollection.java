package com.kingdee.eas.mw.pay;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class SpecategoryAssEntryCollection extends AbstractObjectCollection 
{
    public SpecategoryAssEntryCollection()
    {
        super(SpecategoryAssEntryInfo.class);
    }
    public boolean add(SpecategoryAssEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(SpecategoryAssEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(SpecategoryAssEntryInfo item)
    {
        return removeObject(item);
    }
    public SpecategoryAssEntryInfo get(int index)
    {
        return(SpecategoryAssEntryInfo)getObject(index);
    }
    public SpecategoryAssEntryInfo get(Object key)
    {
        return(SpecategoryAssEntryInfo)getObject(key);
    }
    public void set(int index, SpecategoryAssEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(SpecategoryAssEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(SpecategoryAssEntryInfo item)
    {
        return super.indexOf(item);
    }
}