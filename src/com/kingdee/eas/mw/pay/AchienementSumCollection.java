package com.kingdee.eas.mw.pay;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class AchienementSumCollection extends AbstractObjectCollection 
{
    public AchienementSumCollection()
    {
        super(AchienementSumInfo.class);
    }
    public boolean add(AchienementSumInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(AchienementSumCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(AchienementSumInfo item)
    {
        return removeObject(item);
    }
    public AchienementSumInfo get(int index)
    {
        return(AchienementSumInfo)getObject(index);
    }
    public AchienementSumInfo get(Object key)
    {
        return(AchienementSumInfo)getObject(key);
    }
    public void set(int index, AchienementSumInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(AchienementSumInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(AchienementSumInfo item)
    {
        return super.indexOf(item);
    }
}