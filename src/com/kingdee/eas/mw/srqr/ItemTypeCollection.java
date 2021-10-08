package com.kingdee.eas.mw.srqr;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class ItemTypeCollection extends AbstractObjectCollection 
{
    public ItemTypeCollection()
    {
        super(ItemTypeInfo.class);
    }
    public boolean add(ItemTypeInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(ItemTypeCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(ItemTypeInfo item)
    {
        return removeObject(item);
    }
    public ItemTypeInfo get(int index)
    {
        return(ItemTypeInfo)getObject(index);
    }
    public ItemTypeInfo get(Object key)
    {
        return(ItemTypeInfo)getObject(key);
    }
    public void set(int index, ItemTypeInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(ItemTypeInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(ItemTypeInfo item)
    {
        return super.indexOf(item);
    }
}