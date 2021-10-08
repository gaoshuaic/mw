package com.kingdee.eas.mw.pay;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class PayPostCollection extends AbstractObjectCollection 
{
    public PayPostCollection()
    {
        super(PayPostInfo.class);
    }
    public boolean add(PayPostInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(PayPostCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(PayPostInfo item)
    {
        return removeObject(item);
    }
    public PayPostInfo get(int index)
    {
        return(PayPostInfo)getObject(index);
    }
    public PayPostInfo get(Object key)
    {
        return(PayPostInfo)getObject(key);
    }
    public void set(int index, PayPostInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(PayPostInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(PayPostInfo item)
    {
        return super.indexOf(item);
    }
}