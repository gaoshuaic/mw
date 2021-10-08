package com.kingdee.eas.mw.pay;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class PayCityCollection extends AbstractObjectCollection 
{
    public PayCityCollection()
    {
        super(PayCityInfo.class);
    }
    public boolean add(PayCityInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(PayCityCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(PayCityInfo item)
    {
        return removeObject(item);
    }
    public PayCityInfo get(int index)
    {
        return(PayCityInfo)getObject(index);
    }
    public PayCityInfo get(Object key)
    {
        return(PayCityInfo)getObject(key);
    }
    public void set(int index, PayCityInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(PayCityInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(PayCityInfo item)
    {
        return super.indexOf(item);
    }
}