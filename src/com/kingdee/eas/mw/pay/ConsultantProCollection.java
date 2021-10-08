package com.kingdee.eas.mw.pay;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class ConsultantProCollection extends AbstractObjectCollection 
{
    public ConsultantProCollection()
    {
        super(ConsultantProInfo.class);
    }
    public boolean add(ConsultantProInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(ConsultantProCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(ConsultantProInfo item)
    {
        return removeObject(item);
    }
    public ConsultantProInfo get(int index)
    {
        return(ConsultantProInfo)getObject(index);
    }
    public ConsultantProInfo get(Object key)
    {
        return(ConsultantProInfo)getObject(key);
    }
    public void set(int index, ConsultantProInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(ConsultantProInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(ConsultantProInfo item)
    {
        return super.indexOf(item);
    }
}