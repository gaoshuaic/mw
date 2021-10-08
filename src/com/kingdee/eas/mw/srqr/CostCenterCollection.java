package com.kingdee.eas.mw.srqr;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class CostCenterCollection extends AbstractObjectCollection 
{
    public CostCenterCollection()
    {
        super(CostCenterInfo.class);
    }
    public boolean add(CostCenterInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(CostCenterCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(CostCenterInfo item)
    {
        return removeObject(item);
    }
    public CostCenterInfo get(int index)
    {
        return(CostCenterInfo)getObject(index);
    }
    public CostCenterInfo get(Object key)
    {
        return(CostCenterInfo)getObject(key);
    }
    public void set(int index, CostCenterInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(CostCenterInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(CostCenterInfo item)
    {
        return super.indexOf(item);
    }
}