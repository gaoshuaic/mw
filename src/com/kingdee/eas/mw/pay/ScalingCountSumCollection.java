package com.kingdee.eas.mw.pay;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class ScalingCountSumCollection extends AbstractObjectCollection 
{
    public ScalingCountSumCollection()
    {
        super(ScalingCountSumInfo.class);
    }
    public boolean add(ScalingCountSumInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(ScalingCountSumCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(ScalingCountSumInfo item)
    {
        return removeObject(item);
    }
    public ScalingCountSumInfo get(int index)
    {
        return(ScalingCountSumInfo)getObject(index);
    }
    public ScalingCountSumInfo get(Object key)
    {
        return(ScalingCountSumInfo)getObject(key);
    }
    public void set(int index, ScalingCountSumInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(ScalingCountSumInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(ScalingCountSumInfo item)
    {
        return super.indexOf(item);
    }
}