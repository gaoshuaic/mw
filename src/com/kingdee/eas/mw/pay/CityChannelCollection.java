package com.kingdee.eas.mw.pay;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class CityChannelCollection extends AbstractObjectCollection 
{
    public CityChannelCollection()
    {
        super(CityChannelInfo.class);
    }
    public boolean add(CityChannelInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(CityChannelCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(CityChannelInfo item)
    {
        return removeObject(item);
    }
    public CityChannelInfo get(int index)
    {
        return(CityChannelInfo)getObject(index);
    }
    public CityChannelInfo get(Object key)
    {
        return(CityChannelInfo)getObject(key);
    }
    public void set(int index, CityChannelInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(CityChannelInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(CityChannelInfo item)
    {
        return super.indexOf(item);
    }
}