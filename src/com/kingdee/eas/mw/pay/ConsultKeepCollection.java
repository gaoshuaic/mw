package com.kingdee.eas.mw.pay;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class ConsultKeepCollection extends AbstractObjectCollection 
{
    public ConsultKeepCollection()
    {
        super(ConsultKeepInfo.class);
    }
    public boolean add(ConsultKeepInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(ConsultKeepCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(ConsultKeepInfo item)
    {
        return removeObject(item);
    }
    public ConsultKeepInfo get(int index)
    {
        return(ConsultKeepInfo)getObject(index);
    }
    public ConsultKeepInfo get(Object key)
    {
        return(ConsultKeepInfo)getObject(key);
    }
    public void set(int index, ConsultKeepInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(ConsultKeepInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(ConsultKeepInfo item)
    {
        return super.indexOf(item);
    }
}