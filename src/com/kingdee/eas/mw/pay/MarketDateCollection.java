package com.kingdee.eas.mw.pay;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class MarketDateCollection extends AbstractObjectCollection 
{
    public MarketDateCollection()
    {
        super(MarketDateInfo.class);
    }
    public boolean add(MarketDateInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(MarketDateCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(MarketDateInfo item)
    {
        return removeObject(item);
    }
    public MarketDateInfo get(int index)
    {
        return(MarketDateInfo)getObject(index);
    }
    public MarketDateInfo get(Object key)
    {
        return(MarketDateInfo)getObject(key);
    }
    public void set(int index, MarketDateInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(MarketDateInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(MarketDateInfo item)
    {
        return super.indexOf(item);
    }
}