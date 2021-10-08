package com.kingdee.eas.mw.srqr;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class SaleIssueHisLogCollection extends AbstractObjectCollection 
{
    public SaleIssueHisLogCollection()
    {
        super(SaleIssueHisLogInfo.class);
    }
    public boolean add(SaleIssueHisLogInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(SaleIssueHisLogCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(SaleIssueHisLogInfo item)
    {
        return removeObject(item);
    }
    public SaleIssueHisLogInfo get(int index)
    {
        return(SaleIssueHisLogInfo)getObject(index);
    }
    public SaleIssueHisLogInfo get(Object key)
    {
        return(SaleIssueHisLogInfo)getObject(key);
    }
    public void set(int index, SaleIssueHisLogInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(SaleIssueHisLogInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(SaleIssueHisLogInfo item)
    {
        return super.indexOf(item);
    }
}