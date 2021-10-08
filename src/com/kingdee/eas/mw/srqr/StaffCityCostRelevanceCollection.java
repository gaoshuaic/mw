package com.kingdee.eas.mw.srqr;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class StaffCityCostRelevanceCollection extends AbstractObjectCollection 
{
    public StaffCityCostRelevanceCollection()
    {
        super(StaffCityCostRelevanceInfo.class);
    }
    public boolean add(StaffCityCostRelevanceInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(StaffCityCostRelevanceCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(StaffCityCostRelevanceInfo item)
    {
        return removeObject(item);
    }
    public StaffCityCostRelevanceInfo get(int index)
    {
        return(StaffCityCostRelevanceInfo)getObject(index);
    }
    public StaffCityCostRelevanceInfo get(Object key)
    {
        return(StaffCityCostRelevanceInfo)getObject(key);
    }
    public void set(int index, StaffCityCostRelevanceInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(StaffCityCostRelevanceInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(StaffCityCostRelevanceInfo item)
    {
        return super.indexOf(item);
    }
}