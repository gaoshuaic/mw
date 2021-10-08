package com.kingdee.eas.mw.pay;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class AchieveDetailTemCollection extends AbstractObjectCollection 
{
    public AchieveDetailTemCollection()
    {
        super(AchieveDetailTemInfo.class);
    }
    public boolean add(AchieveDetailTemInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(AchieveDetailTemCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(AchieveDetailTemInfo item)
    {
        return removeObject(item);
    }
    public AchieveDetailTemInfo get(int index)
    {
        return(AchieveDetailTemInfo)getObject(index);
    }
    public AchieveDetailTemInfo get(Object key)
    {
        return(AchieveDetailTemInfo)getObject(key);
    }
    public void set(int index, AchieveDetailTemInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(AchieveDetailTemInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(AchieveDetailTemInfo item)
    {
        return super.indexOf(item);
    }
}