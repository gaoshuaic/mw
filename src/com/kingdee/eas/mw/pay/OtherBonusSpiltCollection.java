package com.kingdee.eas.mw.pay;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class OtherBonusSpiltCollection extends AbstractObjectCollection 
{
    public OtherBonusSpiltCollection()
    {
        super(OtherBonusSpiltInfo.class);
    }
    public boolean add(OtherBonusSpiltInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(OtherBonusSpiltCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(OtherBonusSpiltInfo item)
    {
        return removeObject(item);
    }
    public OtherBonusSpiltInfo get(int index)
    {
        return(OtherBonusSpiltInfo)getObject(index);
    }
    public OtherBonusSpiltInfo get(Object key)
    {
        return(OtherBonusSpiltInfo)getObject(key);
    }
    public void set(int index, OtherBonusSpiltInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(OtherBonusSpiltInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(OtherBonusSpiltInfo item)
    {
        return super.indexOf(item);
    }
}