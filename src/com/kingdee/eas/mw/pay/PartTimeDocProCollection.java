package com.kingdee.eas.mw.pay;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class PartTimeDocProCollection extends AbstractObjectCollection 
{
    public PartTimeDocProCollection()
    {
        super(PartTimeDocProInfo.class);
    }
    public boolean add(PartTimeDocProInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(PartTimeDocProCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(PartTimeDocProInfo item)
    {
        return removeObject(item);
    }
    public PartTimeDocProInfo get(int index)
    {
        return(PartTimeDocProInfo)getObject(index);
    }
    public PartTimeDocProInfo get(Object key)
    {
        return(PartTimeDocProInfo)getObject(key);
    }
    public void set(int index, PartTimeDocProInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(PartTimeDocProInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(PartTimeDocProInfo item)
    {
        return super.indexOf(item);
    }
}