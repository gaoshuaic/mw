package com.kingdee.eas.mw.pay;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class AchievementDetailCollection extends AbstractObjectCollection 
{
    public AchievementDetailCollection()
    {
        super(AchievementDetailInfo.class);
    }
    public boolean add(AchievementDetailInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(AchievementDetailCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(AchievementDetailInfo item)
    {
        return removeObject(item);
    }
    public AchievementDetailInfo get(int index)
    {
        return(AchievementDetailInfo)getObject(index);
    }
    public AchievementDetailInfo get(Object key)
    {
        return(AchievementDetailInfo)getObject(key);
    }
    public void set(int index, AchievementDetailInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(AchievementDetailInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(AchievementDetailInfo item)
    {
        return super.indexOf(item);
    }
}