package com.kingdee.eas.mw.pay;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class ServiceAmountCollection extends AbstractObjectCollection 
{
    public ServiceAmountCollection()
    {
        super(ServiceAmountInfo.class);
    }
    public boolean add(ServiceAmountInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(ServiceAmountCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(ServiceAmountInfo item)
    {
        return removeObject(item);
    }
    public ServiceAmountInfo get(int index)
    {
        return(ServiceAmountInfo)getObject(index);
    }
    public ServiceAmountInfo get(Object key)
    {
        return(ServiceAmountInfo)getObject(key);
    }
    public void set(int index, ServiceAmountInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(ServiceAmountInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(ServiceAmountInfo item)
    {
        return super.indexOf(item);
    }
}