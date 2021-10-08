package com.kingdee.eas.mw.pay;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class PayShareDetailCollection extends AbstractObjectCollection 
{
    public PayShareDetailCollection()
    {
        super(PayShareDetailInfo.class);
    }
    public boolean add(PayShareDetailInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(PayShareDetailCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(PayShareDetailInfo item)
    {
        return removeObject(item);
    }
    public PayShareDetailInfo get(int index)
    {
        return(PayShareDetailInfo)getObject(index);
    }
    public PayShareDetailInfo get(Object key)
    {
        return(PayShareDetailInfo)getObject(key);
    }
    public void set(int index, PayShareDetailInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(PayShareDetailInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(PayShareDetailInfo item)
    {
        return super.indexOf(item);
    }
}