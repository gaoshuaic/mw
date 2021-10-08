package com.kingdee.eas.mw.srqr;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class ItemCheckEntrythiCollection extends AbstractObjectCollection 
{
    public ItemCheckEntrythiCollection()
    {
        super(ItemCheckEntrythiInfo.class);
    }
    public boolean add(ItemCheckEntrythiInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(ItemCheckEntrythiCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(ItemCheckEntrythiInfo item)
    {
        return removeObject(item);
    }
    public ItemCheckEntrythiInfo get(int index)
    {
        return(ItemCheckEntrythiInfo)getObject(index);
    }
    public ItemCheckEntrythiInfo get(Object key)
    {
        return(ItemCheckEntrythiInfo)getObject(key);
    }
    public void set(int index, ItemCheckEntrythiInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(ItemCheckEntrythiInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(ItemCheckEntrythiInfo item)
    {
        return super.indexOf(item);
    }
}