package com.kingdee.eas.mw.srqr;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class ItemCheckEntrysecCollection extends AbstractObjectCollection 
{
    public ItemCheckEntrysecCollection()
    {
        super(ItemCheckEntrysecInfo.class);
    }
    public boolean add(ItemCheckEntrysecInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(ItemCheckEntrysecCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(ItemCheckEntrysecInfo item)
    {
        return removeObject(item);
    }
    public ItemCheckEntrysecInfo get(int index)
    {
        return(ItemCheckEntrysecInfo)getObject(index);
    }
    public ItemCheckEntrysecInfo get(Object key)
    {
        return(ItemCheckEntrysecInfo)getObject(key);
    }
    public void set(int index, ItemCheckEntrysecInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(ItemCheckEntrysecInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(ItemCheckEntrysecInfo item)
    {
        return super.indexOf(item);
    }
}