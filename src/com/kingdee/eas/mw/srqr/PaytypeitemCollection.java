package com.kingdee.eas.mw.srqr;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class PaytypeitemCollection extends AbstractObjectCollection 
{
    public PaytypeitemCollection()
    {
        super(PaytypeitemInfo.class);
    }
    public boolean add(PaytypeitemInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(PaytypeitemCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(PaytypeitemInfo item)
    {
        return removeObject(item);
    }
    public PaytypeitemInfo get(int index)
    {
        return(PaytypeitemInfo)getObject(index);
    }
    public PaytypeitemInfo get(Object key)
    {
        return(PaytypeitemInfo)getObject(key);
    }
    public void set(int index, PaytypeitemInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(PaytypeitemInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(PaytypeitemInfo item)
    {
        return super.indexOf(item);
    }
}