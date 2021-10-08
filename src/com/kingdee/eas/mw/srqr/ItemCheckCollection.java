package com.kingdee.eas.mw.srqr;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class ItemCheckCollection extends AbstractObjectCollection 
{
    public ItemCheckCollection()
    {
        super(ItemCheckInfo.class);
    }
    public boolean add(ItemCheckInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(ItemCheckCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(ItemCheckInfo item)
    {
        return removeObject(item);
    }
    public ItemCheckInfo get(int index)
    {
        return(ItemCheckInfo)getObject(index);
    }
    public ItemCheckInfo get(Object key)
    {
        return(ItemCheckInfo)getObject(key);
    }
    public void set(int index, ItemCheckInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(ItemCheckInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(ItemCheckInfo item)
    {
        return super.indexOf(item);
    }
}