package com.kingdee.eas.mw.srqr;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class ItemCheckEntryCollection extends AbstractObjectCollection 
{
    public ItemCheckEntryCollection()
    {
        super(ItemCheckEntryInfo.class);
    }
    public boolean add(ItemCheckEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(ItemCheckEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(ItemCheckEntryInfo item)
    {
        return removeObject(item);
    }
    public ItemCheckEntryInfo get(int index)
    {
        return(ItemCheckEntryInfo)getObject(index);
    }
    public ItemCheckEntryInfo get(Object key)
    {
        return(ItemCheckEntryInfo)getObject(key);
    }
    public void set(int index, ItemCheckEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(ItemCheckEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(ItemCheckEntryInfo item)
    {
        return super.indexOf(item);
    }
}