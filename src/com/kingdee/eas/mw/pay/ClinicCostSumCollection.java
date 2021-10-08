package com.kingdee.eas.mw.pay;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class ClinicCostSumCollection extends AbstractObjectCollection 
{
    public ClinicCostSumCollection()
    {
        super(ClinicCostSumInfo.class);
    }
    public boolean add(ClinicCostSumInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(ClinicCostSumCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(ClinicCostSumInfo item)
    {
        return removeObject(item);
    }
    public ClinicCostSumInfo get(int index)
    {
        return(ClinicCostSumInfo)getObject(index);
    }
    public ClinicCostSumInfo get(Object key)
    {
        return(ClinicCostSumInfo)getObject(key);
    }
    public void set(int index, ClinicCostSumInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(ClinicCostSumInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(ClinicCostSumInfo item)
    {
        return super.indexOf(item);
    }
}