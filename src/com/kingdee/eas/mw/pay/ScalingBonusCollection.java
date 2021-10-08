package com.kingdee.eas.mw.pay;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class ScalingBonusCollection extends AbstractObjectCollection 
{
    public ScalingBonusCollection()
    {
        super(ScalingBonusInfo.class);
    }
    public boolean add(ScalingBonusInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(ScalingBonusCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(ScalingBonusInfo item)
    {
        return removeObject(item);
    }
    public ScalingBonusInfo get(int index)
    {
        return(ScalingBonusInfo)getObject(index);
    }
    public ScalingBonusInfo get(Object key)
    {
        return(ScalingBonusInfo)getObject(key);
    }
    public void set(int index, ScalingBonusInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(ScalingBonusInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(ScalingBonusInfo item)
    {
        return super.indexOf(item);
    }
}