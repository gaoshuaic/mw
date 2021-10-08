package com.kingdee.eas.mw.srqr;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class TagCollection extends AbstractObjectCollection 
{
    public TagCollection()
    {
        super(TagInfo.class);
    }
    public boolean add(TagInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(TagCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(TagInfo item)
    {
        return removeObject(item);
    }
    public TagInfo get(int index)
    {
        return(TagInfo)getObject(index);
    }
    public TagInfo get(Object key)
    {
        return(TagInfo)getObject(key);
    }
    public void set(int index, TagInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(TagInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(TagInfo item)
    {
        return super.indexOf(item);
    }
}