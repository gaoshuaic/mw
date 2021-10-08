package com.kingdee.eas.mw.pay;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class ClinicMonthSumCollection extends AbstractObjectCollection 
{
    public ClinicMonthSumCollection()
    {
        super(ClinicMonthSumInfo.class);
    }
    public boolean add(ClinicMonthSumInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(ClinicMonthSumCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(ClinicMonthSumInfo item)
    {
        return removeObject(item);
    }
    public ClinicMonthSumInfo get(int index)
    {
        return(ClinicMonthSumInfo)getObject(index);
    }
    public ClinicMonthSumInfo get(Object key)
    {
        return(ClinicMonthSumInfo)getObject(key);
    }
    public void set(int index, ClinicMonthSumInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(ClinicMonthSumInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(ClinicMonthSumInfo item)
    {
        return super.indexOf(item);
    }
}