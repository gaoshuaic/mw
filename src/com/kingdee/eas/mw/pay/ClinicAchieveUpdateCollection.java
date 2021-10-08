package com.kingdee.eas.mw.pay;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class ClinicAchieveUpdateCollection extends AbstractObjectCollection 
{
    public ClinicAchieveUpdateCollection()
    {
        super(ClinicAchieveUpdateInfo.class);
    }
    public boolean add(ClinicAchieveUpdateInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(ClinicAchieveUpdateCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(ClinicAchieveUpdateInfo item)
    {
        return removeObject(item);
    }
    public ClinicAchieveUpdateInfo get(int index)
    {
        return(ClinicAchieveUpdateInfo)getObject(index);
    }
    public ClinicAchieveUpdateInfo get(Object key)
    {
        return(ClinicAchieveUpdateInfo)getObject(key);
    }
    public void set(int index, ClinicAchieveUpdateInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(ClinicAchieveUpdateInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(ClinicAchieveUpdateInfo item)
    {
        return super.indexOf(item);
    }
}