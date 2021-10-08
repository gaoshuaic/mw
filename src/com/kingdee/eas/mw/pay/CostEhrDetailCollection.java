package com.kingdee.eas.mw.pay;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class CostEhrDetailCollection extends AbstractObjectCollection 
{
    public CostEhrDetailCollection()
    {
        super(CostEhrDetailInfo.class);
    }
    public boolean add(CostEhrDetailInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(CostEhrDetailCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(CostEhrDetailInfo item)
    {
        return removeObject(item);
    }
    public CostEhrDetailInfo get(int index)
    {
        return(CostEhrDetailInfo)getObject(index);
    }
    public CostEhrDetailInfo get(Object key)
    {
        return(CostEhrDetailInfo)getObject(key);
    }
    public void set(int index, CostEhrDetailInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(CostEhrDetailInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(CostEhrDetailInfo item)
    {
        return super.indexOf(item);
    }
}