package com.kingdee.eas.mw.pay;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class CommentMessageCollection extends AbstractObjectCollection 
{
    public CommentMessageCollection()
    {
        super(CommentMessageInfo.class);
    }
    public boolean add(CommentMessageInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(CommentMessageCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(CommentMessageInfo item)
    {
        return removeObject(item);
    }
    public CommentMessageInfo get(int index)
    {
        return(CommentMessageInfo)getObject(index);
    }
    public CommentMessageInfo get(Object key)
    {
        return(CommentMessageInfo)getObject(key);
    }
    public void set(int index, CommentMessageInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(CommentMessageInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(CommentMessageInfo item)
    {
        return super.indexOf(item);
    }
}