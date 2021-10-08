package com.kingdee.eas.mw.pay;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class ConsultantBonusUpdateCollection extends AbstractObjectCollection 
{
    public ConsultantBonusUpdateCollection()
    {
        super(ConsultantBonusUpdateInfo.class);
    }
    public boolean add(ConsultantBonusUpdateInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(ConsultantBonusUpdateCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(ConsultantBonusUpdateInfo item)
    {
        return removeObject(item);
    }
    public ConsultantBonusUpdateInfo get(int index)
    {
        return(ConsultantBonusUpdateInfo)getObject(index);
    }
    public ConsultantBonusUpdateInfo get(Object key)
    {
        return(ConsultantBonusUpdateInfo)getObject(key);
    }
    public void set(int index, ConsultantBonusUpdateInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(ConsultantBonusUpdateInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(ConsultantBonusUpdateInfo item)
    {
        return super.indexOf(item);
    }
}