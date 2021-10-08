package com.kingdee.eas.mw.srqr;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class CostCenterE1Collection extends AbstractObjectCollection 
{
    public CostCenterE1Collection()
    {
        super(CostCenterE1Info.class);
    }
    public boolean add(CostCenterE1Info item)
    {
        return addObject(item);
    }
    public boolean addCollection(CostCenterE1Collection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(CostCenterE1Info item)
    {
        return removeObject(item);
    }
    public CostCenterE1Info get(int index)
    {
        return(CostCenterE1Info)getObject(index);
    }
    public CostCenterE1Info get(Object key)
    {
        return(CostCenterE1Info)getObject(key);
    }
    public void set(int index, CostCenterE1Info item)
    {
        setObject(index, item);
    }
    public boolean contains(CostCenterE1Info item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(CostCenterE1Info item)
    {
        return super.indexOf(item);
    }
}