package com.kingdee.eas.mw.srqr;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class PostTypeCollection extends AbstractObjectCollection 
{
    public PostTypeCollection()
    {
        super(PostTypeInfo.class);
    }
    public boolean add(PostTypeInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(PostTypeCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(PostTypeInfo item)
    {
        return removeObject(item);
    }
    public PostTypeInfo get(int index)
    {
        return(PostTypeInfo)getObject(index);
    }
    public PostTypeInfo get(Object key)
    {
        return(PostTypeInfo)getObject(key);
    }
    public void set(int index, PostTypeInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(PostTypeInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(PostTypeInfo item)
    {
        return super.indexOf(item);
    }
}