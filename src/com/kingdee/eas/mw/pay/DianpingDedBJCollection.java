package com.kingdee.eas.mw.pay;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class DianpingDedBJCollection extends AbstractObjectCollection 
{
    public DianpingDedBJCollection()
    {
        super(DianpingDedBJInfo.class);
    }
    public boolean add(DianpingDedBJInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(DianpingDedBJCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(DianpingDedBJInfo item)
    {
        return removeObject(item);
    }
    public DianpingDedBJInfo get(int index)
    {
        return(DianpingDedBJInfo)getObject(index);
    }
    public DianpingDedBJInfo get(Object key)
    {
        return(DianpingDedBJInfo)getObject(key);
    }
    public void set(int index, DianpingDedBJInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(DianpingDedBJInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(DianpingDedBJInfo item)
    {
        return super.indexOf(item);
    }
}