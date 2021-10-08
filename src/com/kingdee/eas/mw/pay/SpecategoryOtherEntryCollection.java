package com.kingdee.eas.mw.pay;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class SpecategoryOtherEntryCollection extends AbstractObjectCollection 
{
    public SpecategoryOtherEntryCollection()
    {
        super(SpecategoryOtherEntryInfo.class);
    }
    public boolean add(SpecategoryOtherEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(SpecategoryOtherEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(SpecategoryOtherEntryInfo item)
    {
        return removeObject(item);
    }
    public SpecategoryOtherEntryInfo get(int index)
    {
        return(SpecategoryOtherEntryInfo)getObject(index);
    }
    public SpecategoryOtherEntryInfo get(Object key)
    {
        return(SpecategoryOtherEntryInfo)getObject(key);
    }
    public void set(int index, SpecategoryOtherEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(SpecategoryOtherEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(SpecategoryOtherEntryInfo item)
    {
        return super.indexOf(item);
    }
}