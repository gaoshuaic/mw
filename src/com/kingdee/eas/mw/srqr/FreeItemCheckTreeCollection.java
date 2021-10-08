package com.kingdee.eas.mw.srqr;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class FreeItemCheckTreeCollection extends AbstractObjectCollection 
{
    public FreeItemCheckTreeCollection()
    {
        super(FreeItemCheckTreeInfo.class);
    }
    public boolean add(FreeItemCheckTreeInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(FreeItemCheckTreeCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(FreeItemCheckTreeInfo item)
    {
        return removeObject(item);
    }
    public FreeItemCheckTreeInfo get(int index)
    {
        return(FreeItemCheckTreeInfo)getObject(index);
    }
    public FreeItemCheckTreeInfo get(Object key)
    {
        return(FreeItemCheckTreeInfo)getObject(key);
    }
    public void set(int index, FreeItemCheckTreeInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(FreeItemCheckTreeInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(FreeItemCheckTreeInfo item)
    {
        return super.indexOf(item);
    }
}