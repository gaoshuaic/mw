package com.kingdee.eas.mw.pay;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class ToothCleanerBillCollection extends AbstractObjectCollection 
{
    public ToothCleanerBillCollection()
    {
        super(ToothCleanerBillInfo.class);
    }
    public boolean add(ToothCleanerBillInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(ToothCleanerBillCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(ToothCleanerBillInfo item)
    {
        return removeObject(item);
    }
    public ToothCleanerBillInfo get(int index)
    {
        return(ToothCleanerBillInfo)getObject(index);
    }
    public ToothCleanerBillInfo get(Object key)
    {
        return(ToothCleanerBillInfo)getObject(key);
    }
    public void set(int index, ToothCleanerBillInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(ToothCleanerBillInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(ToothCleanerBillInfo item)
    {
        return super.indexOf(item);
    }
}