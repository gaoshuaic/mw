package com.kingdee.eas.mw.pay;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class SpecialDocCollection extends AbstractObjectCollection 
{
    public SpecialDocCollection()
    {
        super(SpecialDocInfo.class);
    }
    public boolean add(SpecialDocInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(SpecialDocCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(SpecialDocInfo item)
    {
        return removeObject(item);
    }
    public SpecialDocInfo get(int index)
    {
        return(SpecialDocInfo)getObject(index);
    }
    public SpecialDocInfo get(Object key)
    {
        return(SpecialDocInfo)getObject(key);
    }
    public void set(int index, SpecialDocInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(SpecialDocInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(SpecialDocInfo item)
    {
        return super.indexOf(item);
    }
}