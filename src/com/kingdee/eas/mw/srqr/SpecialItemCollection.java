package com.kingdee.eas.mw.srqr;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class SpecialItemCollection extends AbstractObjectCollection 
{
    public SpecialItemCollection()
    {
        super(SpecialItemInfo.class);
    }
    public boolean add(SpecialItemInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(SpecialItemCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(SpecialItemInfo item)
    {
        return removeObject(item);
    }
    public SpecialItemInfo get(int index)
    {
        return(SpecialItemInfo)getObject(index);
    }
    public SpecialItemInfo get(Object key)
    {
        return(SpecialItemInfo)getObject(key);
    }
    public void set(int index, SpecialItemInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(SpecialItemInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(SpecialItemInfo item)
    {
        return super.indexOf(item);
    }
}