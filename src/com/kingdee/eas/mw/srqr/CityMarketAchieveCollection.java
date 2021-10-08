package com.kingdee.eas.mw.srqr;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class CityMarketAchieveCollection extends AbstractObjectCollection 
{
    public CityMarketAchieveCollection()
    {
        super(CityMarketAchieveInfo.class);
    }
    public boolean add(CityMarketAchieveInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(CityMarketAchieveCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(CityMarketAchieveInfo item)
    {
        return removeObject(item);
    }
    public CityMarketAchieveInfo get(int index)
    {
        return(CityMarketAchieveInfo)getObject(index);
    }
    public CityMarketAchieveInfo get(Object key)
    {
        return(CityMarketAchieveInfo)getObject(key);
    }
    public void set(int index, CityMarketAchieveInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(CityMarketAchieveInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(CityMarketAchieveInfo item)
    {
        return super.indexOf(item);
    }
}