package com.kingdee.eas.mw.pay;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class ScalingTypeCollection extends AbstractObjectCollection 
{
    public ScalingTypeCollection()
    {
        super(ScalingTypeInfo.class);
    }
    public boolean add(ScalingTypeInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(ScalingTypeCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(ScalingTypeInfo item)
    {
        return removeObject(item);
    }
    public ScalingTypeInfo get(int index)
    {
        return(ScalingTypeInfo)getObject(index);
    }
    public ScalingTypeInfo get(Object key)
    {
        return(ScalingTypeInfo)getObject(key);
    }
    public void set(int index, ScalingTypeInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(ScalingTypeInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(ScalingTypeInfo item)
    {
        return super.indexOf(item);
    }
}