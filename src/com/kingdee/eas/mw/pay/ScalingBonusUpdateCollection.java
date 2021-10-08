package com.kingdee.eas.mw.pay;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class ScalingBonusUpdateCollection extends AbstractObjectCollection 
{
    public ScalingBonusUpdateCollection()
    {
        super(ScalingBonusUpdateInfo.class);
    }
    public boolean add(ScalingBonusUpdateInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(ScalingBonusUpdateCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(ScalingBonusUpdateInfo item)
    {
        return removeObject(item);
    }
    public ScalingBonusUpdateInfo get(int index)
    {
        return(ScalingBonusUpdateInfo)getObject(index);
    }
    public ScalingBonusUpdateInfo get(Object key)
    {
        return(ScalingBonusUpdateInfo)getObject(key);
    }
    public void set(int index, ScalingBonusUpdateInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(ScalingBonusUpdateInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(ScalingBonusUpdateInfo item)
    {
        return super.indexOf(item);
    }
}