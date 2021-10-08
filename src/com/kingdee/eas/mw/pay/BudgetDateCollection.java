package com.kingdee.eas.mw.pay;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class BudgetDateCollection extends AbstractObjectCollection 
{
    public BudgetDateCollection()
    {
        super(BudgetDateInfo.class);
    }
    public boolean add(BudgetDateInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(BudgetDateCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(BudgetDateInfo item)
    {
        return removeObject(item);
    }
    public BudgetDateInfo get(int index)
    {
        return(BudgetDateInfo)getObject(index);
    }
    public BudgetDateInfo get(Object key)
    {
        return(BudgetDateInfo)getObject(key);
    }
    public void set(int index, BudgetDateInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(BudgetDateInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(BudgetDateInfo item)
    {
        return super.indexOf(item);
    }
}