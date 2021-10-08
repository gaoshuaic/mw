package com.kingdee.eas.mw.pay;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class ConsultTypeCollection extends AbstractObjectCollection 
{
    public ConsultTypeCollection()
    {
        super(ConsultTypeInfo.class);
    }
    public boolean add(ConsultTypeInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(ConsultTypeCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(ConsultTypeInfo item)
    {
        return removeObject(item);
    }
    public ConsultTypeInfo get(int index)
    {
        return(ConsultTypeInfo)getObject(index);
    }
    public ConsultTypeInfo get(Object key)
    {
        return(ConsultTypeInfo)getObject(key);
    }
    public void set(int index, ConsultTypeInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(ConsultTypeInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(ConsultTypeInfo item)
    {
        return super.indexOf(item);
    }
}