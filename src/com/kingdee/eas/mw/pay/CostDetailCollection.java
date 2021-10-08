package com.kingdee.eas.mw.pay;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class CostDetailCollection extends AbstractObjectCollection 
{
    public CostDetailCollection()
    {
        super(CostDetailInfo.class);
    }
    public boolean add(CostDetailInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(CostDetailCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(CostDetailInfo item)
    {
        return removeObject(item);
    }
    public CostDetailInfo get(int index)
    {
        return(CostDetailInfo)getObject(index);
    }
    public CostDetailInfo get(Object key)
    {
        return(CostDetailInfo)getObject(key);
    }
    public void set(int index, CostDetailInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(CostDetailInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(CostDetailInfo item)
    {
        return super.indexOf(item);
    }
}