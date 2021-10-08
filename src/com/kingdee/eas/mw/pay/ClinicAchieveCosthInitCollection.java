package com.kingdee.eas.mw.pay;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class ClinicAchieveCosthInitCollection extends AbstractObjectCollection 
{
    public ClinicAchieveCosthInitCollection()
    {
        super(ClinicAchieveCosthInitInfo.class);
    }
    public boolean add(ClinicAchieveCosthInitInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(ClinicAchieveCosthInitCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(ClinicAchieveCosthInitInfo item)
    {
        return removeObject(item);
    }
    public ClinicAchieveCosthInitInfo get(int index)
    {
        return(ClinicAchieveCosthInitInfo)getObject(index);
    }
    public ClinicAchieveCosthInitInfo get(Object key)
    {
        return(ClinicAchieveCosthInitInfo)getObject(key);
    }
    public void set(int index, ClinicAchieveCosthInitInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(ClinicAchieveCosthInitInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(ClinicAchieveCosthInitInfo item)
    {
        return super.indexOf(item);
    }
}