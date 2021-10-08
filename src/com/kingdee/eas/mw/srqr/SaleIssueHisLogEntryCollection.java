package com.kingdee.eas.mw.srqr;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class SaleIssueHisLogEntryCollection extends AbstractObjectCollection 
{
    public SaleIssueHisLogEntryCollection()
    {
        super(SaleIssueHisLogEntryInfo.class);
    }
    public boolean add(SaleIssueHisLogEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(SaleIssueHisLogEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(SaleIssueHisLogEntryInfo item)
    {
        return removeObject(item);
    }
    public SaleIssueHisLogEntryInfo get(int index)
    {
        return(SaleIssueHisLogEntryInfo)getObject(index);
    }
    public SaleIssueHisLogEntryInfo get(Object key)
    {
        return(SaleIssueHisLogEntryInfo)getObject(key);
    }
    public void set(int index, SaleIssueHisLogEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(SaleIssueHisLogEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(SaleIssueHisLogEntryInfo item)
    {
        return super.indexOf(item);
    }
}