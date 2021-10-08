package com.kingdee.eas.mw.pay;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class HaopingMessageCollection extends AbstractObjectCollection 
{
    public HaopingMessageCollection()
    {
        super(HaopingMessageInfo.class);
    }
    public boolean add(HaopingMessageInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(HaopingMessageCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(HaopingMessageInfo item)
    {
        return removeObject(item);
    }
    public HaopingMessageInfo get(int index)
    {
        return(HaopingMessageInfo)getObject(index);
    }
    public HaopingMessageInfo get(Object key)
    {
        return(HaopingMessageInfo)getObject(key);
    }
    public void set(int index, HaopingMessageInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(HaopingMessageInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(HaopingMessageInfo item)
    {
        return super.indexOf(item);
    }
}