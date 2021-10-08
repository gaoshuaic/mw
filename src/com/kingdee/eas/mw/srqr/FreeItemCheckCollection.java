package com.kingdee.eas.mw.srqr;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class FreeItemCheckCollection extends AbstractObjectCollection 
{
    public FreeItemCheckCollection()
    {
        super(FreeItemCheckInfo.class);
    }
    public boolean add(FreeItemCheckInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(FreeItemCheckCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(FreeItemCheckInfo item)
    {
        return removeObject(item);
    }
    public FreeItemCheckInfo get(int index)
    {
        return(FreeItemCheckInfo)getObject(index);
    }
    public FreeItemCheckInfo get(Object key)
    {
        return(FreeItemCheckInfo)getObject(key);
    }
    public void set(int index, FreeItemCheckInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(FreeItemCheckInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(FreeItemCheckInfo item)
    {
        return super.indexOf(item);
    }
}