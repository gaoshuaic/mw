package com.kingdee.eas.mw.pay;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class BaoDiImpMoneyCollection extends AbstractObjectCollection 
{
    public BaoDiImpMoneyCollection()
    {
        super(BaoDiImpMoneyInfo.class);
    }
    public boolean add(BaoDiImpMoneyInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(BaoDiImpMoneyCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(BaoDiImpMoneyInfo item)
    {
        return removeObject(item);
    }
    public BaoDiImpMoneyInfo get(int index)
    {
        return(BaoDiImpMoneyInfo)getObject(index);
    }
    public BaoDiImpMoneyInfo get(Object key)
    {
        return(BaoDiImpMoneyInfo)getObject(key);
    }
    public void set(int index, BaoDiImpMoneyInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(BaoDiImpMoneyInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(BaoDiImpMoneyInfo item)
    {
        return super.indexOf(item);
    }
}