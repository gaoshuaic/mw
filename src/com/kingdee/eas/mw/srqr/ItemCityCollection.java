package com.kingdee.eas.mw.srqr;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class ItemCityCollection extends AbstractObjectCollection 
{
    public ItemCityCollection()
    {
        super(ItemCityInfo.class);
    }
    public boolean add(ItemCityInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(ItemCityCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(ItemCityInfo item)
    {
        return removeObject(item);
    }
    public ItemCityInfo get(int index)
    {
        return(ItemCityInfo)getObject(index);
    }
    public ItemCityInfo get(Object key)
    {
        return(ItemCityInfo)getObject(key);
    }
    public void set(int index, ItemCityInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(ItemCityInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(ItemCityInfo item)
    {
        return super.indexOf(item);
    }
}