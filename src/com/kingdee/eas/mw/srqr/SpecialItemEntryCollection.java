package com.kingdee.eas.mw.srqr;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class SpecialItemEntryCollection extends AbstractObjectCollection 
{
    public SpecialItemEntryCollection()
    {
        super(SpecialItemEntryInfo.class);
    }
    public boolean add(SpecialItemEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(SpecialItemEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(SpecialItemEntryInfo item)
    {
        return removeObject(item);
    }
    public SpecialItemEntryInfo get(int index)
    {
        return(SpecialItemEntryInfo)getObject(index);
    }
    public SpecialItemEntryInfo get(Object key)
    {
        return(SpecialItemEntryInfo)getObject(key);
    }
    public void set(int index, SpecialItemEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(SpecialItemEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(SpecialItemEntryInfo item)
    {
        return super.indexOf(item);
    }
}