package com.kingdee.eas.mw.srqr;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class CityCompanyTargetCollection extends AbstractObjectCollection 
{
    public CityCompanyTargetCollection()
    {
        super(CityCompanyTargetInfo.class);
    }
    public boolean add(CityCompanyTargetInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(CityCompanyTargetCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(CityCompanyTargetInfo item)
    {
        return removeObject(item);
    }
    public CityCompanyTargetInfo get(int index)
    {
        return(CityCompanyTargetInfo)getObject(index);
    }
    public CityCompanyTargetInfo get(Object key)
    {
        return(CityCompanyTargetInfo)getObject(key);
    }
    public void set(int index, CityCompanyTargetInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(CityCompanyTargetInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(CityCompanyTargetInfo item)
    {
        return super.indexOf(item);
    }
}