package com.kingdee.eas.mw.pay;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class SpecategoryCollection extends AbstractObjectCollection 
{
    public SpecategoryCollection()
    {
        super(SpecategoryInfo.class);
    }
    public boolean add(SpecategoryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(SpecategoryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(SpecategoryInfo item)
    {
        return removeObject(item);
    }
    public SpecategoryInfo get(int index)
    {
        return(SpecategoryInfo)getObject(index);
    }
    public SpecategoryInfo get(Object key)
    {
        return(SpecategoryInfo)getObject(key);
    }
    public void set(int index, SpecategoryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(SpecategoryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(SpecategoryInfo item)
    {
        return super.indexOf(item);
    }
}