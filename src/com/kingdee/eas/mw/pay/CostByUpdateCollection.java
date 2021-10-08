package com.kingdee.eas.mw.pay;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class CostByUpdateCollection extends AbstractObjectCollection 
{
    public CostByUpdateCollection()
    {
        super(CostByUpdateInfo.class);
    }
    public boolean add(CostByUpdateInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(CostByUpdateCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(CostByUpdateInfo item)
    {
        return removeObject(item);
    }
    public CostByUpdateInfo get(int index)
    {
        return(CostByUpdateInfo)getObject(index);
    }
    public CostByUpdateInfo get(Object key)
    {
        return(CostByUpdateInfo)getObject(key);
    }
    public void set(int index, CostByUpdateInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(CostByUpdateInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(CostByUpdateInfo item)
    {
        return super.indexOf(item);
    }
}