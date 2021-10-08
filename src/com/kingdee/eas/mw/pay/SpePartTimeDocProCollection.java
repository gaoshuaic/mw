package com.kingdee.eas.mw.pay;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class SpePartTimeDocProCollection extends AbstractObjectCollection 
{
    public SpePartTimeDocProCollection()
    {
        super(SpePartTimeDocProInfo.class);
    }
    public boolean add(SpePartTimeDocProInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(SpePartTimeDocProCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(SpePartTimeDocProInfo item)
    {
        return removeObject(item);
    }
    public SpePartTimeDocProInfo get(int index)
    {
        return(SpePartTimeDocProInfo)getObject(index);
    }
    public SpePartTimeDocProInfo get(Object key)
    {
        return(SpePartTimeDocProInfo)getObject(key);
    }
    public void set(int index, SpePartTimeDocProInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(SpePartTimeDocProInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(SpePartTimeDocProInfo item)
    {
        return super.indexOf(item);
    }
}