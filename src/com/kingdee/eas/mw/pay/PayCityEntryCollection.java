package com.kingdee.eas.mw.pay;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class PayCityEntryCollection extends AbstractObjectCollection 
{
    public PayCityEntryCollection()
    {
        super(PayCityEntryInfo.class);
    }
    public boolean add(PayCityEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(PayCityEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(PayCityEntryInfo item)
    {
        return removeObject(item);
    }
    public PayCityEntryInfo get(int index)
    {
        return(PayCityEntryInfo)getObject(index);
    }
    public PayCityEntryInfo get(Object key)
    {
        return(PayCityEntryInfo)getObject(key);
    }
    public void set(int index, PayCityEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(PayCityEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(PayCityEntryInfo item)
    {
        return super.indexOf(item);
    }
}