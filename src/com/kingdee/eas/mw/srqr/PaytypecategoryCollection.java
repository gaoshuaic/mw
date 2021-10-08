package com.kingdee.eas.mw.srqr;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class PaytypecategoryCollection extends AbstractObjectCollection 
{
    public PaytypecategoryCollection()
    {
        super(PaytypecategoryInfo.class);
    }
    public boolean add(PaytypecategoryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(PaytypecategoryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(PaytypecategoryInfo item)
    {
        return removeObject(item);
    }
    public PaytypecategoryInfo get(int index)
    {
        return(PaytypecategoryInfo)getObject(index);
    }
    public PaytypecategoryInfo get(Object key)
    {
        return(PaytypecategoryInfo)getObject(key);
    }
    public void set(int index, PaytypecategoryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(PaytypecategoryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(PaytypecategoryInfo item)
    {
        return super.indexOf(item);
    }
}