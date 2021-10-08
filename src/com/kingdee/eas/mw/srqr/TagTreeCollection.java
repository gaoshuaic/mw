package com.kingdee.eas.mw.srqr;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class TagTreeCollection extends AbstractObjectCollection 
{
    public TagTreeCollection()
    {
        super(TagTreeInfo.class);
    }
    public boolean add(TagTreeInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(TagTreeCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(TagTreeInfo item)
    {
        return removeObject(item);
    }
    public TagTreeInfo get(int index)
    {
        return(TagTreeInfo)getObject(index);
    }
    public TagTreeInfo get(Object key)
    {
        return(TagTreeInfo)getObject(key);
    }
    public void set(int index, TagTreeInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(TagTreeInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(TagTreeInfo item)
    {
        return super.indexOf(item);
    }
}