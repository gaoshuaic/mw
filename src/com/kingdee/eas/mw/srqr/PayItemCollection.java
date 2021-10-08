package com.kingdee.eas.mw.srqr;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class PayItemCollection extends AbstractObjectCollection 
{
    public PayItemCollection()
    {
        super(PayItemInfo.class);
    }
    public boolean add(PayItemInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(PayItemCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(PayItemInfo item)
    {
        return removeObject(item);
    }
    public PayItemInfo get(int index)
    {
        return(PayItemInfo)getObject(index);
    }
    public PayItemInfo get(Object key)
    {
        return(PayItemInfo)getObject(key);
    }
    public void set(int index, PayItemInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(PayItemInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(PayItemInfo item)
    {
        return super.indexOf(item);
    }
}