package com.kingdee.eas.mw.pay;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class HolderDataSourceCollection extends AbstractObjectCollection 
{
    public HolderDataSourceCollection()
    {
        super(HolderDataSourceInfo.class);
    }
    public boolean add(HolderDataSourceInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(HolderDataSourceCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(HolderDataSourceInfo item)
    {
        return removeObject(item);
    }
    public HolderDataSourceInfo get(int index)
    {
        return(HolderDataSourceInfo)getObject(index);
    }
    public HolderDataSourceInfo get(Object key)
    {
        return(HolderDataSourceInfo)getObject(key);
    }
    public void set(int index, HolderDataSourceInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(HolderDataSourceInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(HolderDataSourceInfo item)
    {
        return super.indexOf(item);
    }
}