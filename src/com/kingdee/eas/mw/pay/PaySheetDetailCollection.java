package com.kingdee.eas.mw.pay;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class PaySheetDetailCollection extends AbstractObjectCollection 
{
    public PaySheetDetailCollection()
    {
        super(PaySheetDetailInfo.class);
    }
    public boolean add(PaySheetDetailInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(PaySheetDetailCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(PaySheetDetailInfo item)
    {
        return removeObject(item);
    }
    public PaySheetDetailInfo get(int index)
    {
        return(PaySheetDetailInfo)getObject(index);
    }
    public PaySheetDetailInfo get(Object key)
    {
        return(PaySheetDetailInfo)getObject(key);
    }
    public void set(int index, PaySheetDetailInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(PaySheetDetailInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(PaySheetDetailInfo item)
    {
        return super.indexOf(item);
    }
}