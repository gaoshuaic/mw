package com.kingdee.eas.mw.pay;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class ClinicAchieveCosthSumCollection extends AbstractObjectCollection 
{
    public ClinicAchieveCosthSumCollection()
    {
        super(ClinicAchieveCosthSumInfo.class);
    }
    public boolean add(ClinicAchieveCosthSumInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(ClinicAchieveCosthSumCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(ClinicAchieveCosthSumInfo item)
    {
        return removeObject(item);
    }
    public ClinicAchieveCosthSumInfo get(int index)
    {
        return(ClinicAchieveCosthSumInfo)getObject(index);
    }
    public ClinicAchieveCosthSumInfo get(Object key)
    {
        return(ClinicAchieveCosthSumInfo)getObject(key);
    }
    public void set(int index, ClinicAchieveCosthSumInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(ClinicAchieveCosthSumInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(ClinicAchieveCosthSumInfo item)
    {
        return super.indexOf(item);
    }
}