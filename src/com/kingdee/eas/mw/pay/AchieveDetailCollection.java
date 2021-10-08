package com.kingdee.eas.mw.pay;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class AchieveDetailCollection extends AbstractObjectCollection 
{
    public AchieveDetailCollection()
    {
        super(AchieveDetailInfo.class);
    }
    public boolean add(AchieveDetailInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(AchieveDetailCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(AchieveDetailInfo item)
    {
        return removeObject(item);
    }
    public AchieveDetailInfo get(int index)
    {
        return(AchieveDetailInfo)getObject(index);
    }
    public AchieveDetailInfo get(Object key)
    {
        return(AchieveDetailInfo)getObject(key);
    }
    public void set(int index, AchieveDetailInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(AchieveDetailInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(AchieveDetailInfo item)
    {
        return super.indexOf(item);
    }
}