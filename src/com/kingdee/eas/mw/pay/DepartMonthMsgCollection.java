package com.kingdee.eas.mw.pay;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class DepartMonthMsgCollection extends AbstractObjectCollection 
{
    public DepartMonthMsgCollection()
    {
        super(DepartMonthMsgInfo.class);
    }
    public boolean add(DepartMonthMsgInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(DepartMonthMsgCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(DepartMonthMsgInfo item)
    {
        return removeObject(item);
    }
    public DepartMonthMsgInfo get(int index)
    {
        return(DepartMonthMsgInfo)getObject(index);
    }
    public DepartMonthMsgInfo get(Object key)
    {
        return(DepartMonthMsgInfo)getObject(key);
    }
    public void set(int index, DepartMonthMsgInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(DepartMonthMsgInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(DepartMonthMsgInfo item)
    {
        return super.indexOf(item);
    }
}