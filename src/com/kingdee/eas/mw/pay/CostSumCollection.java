package com.kingdee.eas.mw.pay;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class CostSumCollection extends AbstractObjectCollection 
{
    public CostSumCollection()
    {
        super(CostSumInfo.class);
    }
    public boolean add(CostSumInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(CostSumCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(CostSumInfo item)
    {
        return removeObject(item);
    }
    public CostSumInfo get(int index)
    {
        return(CostSumInfo)getObject(index);
    }
    public CostSumInfo get(Object key)
    {
        return(CostSumInfo)getObject(key);
    }
    public void set(int index, CostSumInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(CostSumInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(CostSumInfo item)
    {
        return super.indexOf(item);
    }
}