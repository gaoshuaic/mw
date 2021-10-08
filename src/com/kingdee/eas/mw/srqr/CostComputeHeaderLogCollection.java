package com.kingdee.eas.mw.srqr;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class CostComputeHeaderLogCollection extends AbstractObjectCollection 
{
    public CostComputeHeaderLogCollection()
    {
        super(CostComputeHeaderLogInfo.class);
    }
    public boolean add(CostComputeHeaderLogInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(CostComputeHeaderLogCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(CostComputeHeaderLogInfo item)
    {
        return removeObject(item);
    }
    public CostComputeHeaderLogInfo get(int index)
    {
        return(CostComputeHeaderLogInfo)getObject(index);
    }
    public CostComputeHeaderLogInfo get(Object key)
    {
        return(CostComputeHeaderLogInfo)getObject(key);
    }
    public void set(int index, CostComputeHeaderLogInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(CostComputeHeaderLogInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(CostComputeHeaderLogInfo item)
    {
        return super.indexOf(item);
    }
}