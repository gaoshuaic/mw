package com.kingdee.eas.mw.srqr;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class FenTanAchieveCollection extends AbstractObjectCollection 
{
    public FenTanAchieveCollection()
    {
        super(FenTanAchieveInfo.class);
    }
    public boolean add(FenTanAchieveInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(FenTanAchieveCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(FenTanAchieveInfo item)
    {
        return removeObject(item);
    }
    public FenTanAchieveInfo get(int index)
    {
        return(FenTanAchieveInfo)getObject(index);
    }
    public FenTanAchieveInfo get(Object key)
    {
        return(FenTanAchieveInfo)getObject(key);
    }
    public void set(int index, FenTanAchieveInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(FenTanAchieveInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(FenTanAchieveInfo item)
    {
        return super.indexOf(item);
    }
}