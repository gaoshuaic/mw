package com.kingdee.eas.mw.pay;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class ReferralBonusCollection extends AbstractObjectCollection 
{
    public ReferralBonusCollection()
    {
        super(ReferralBonusInfo.class);
    }
    public boolean add(ReferralBonusInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(ReferralBonusCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(ReferralBonusInfo item)
    {
        return removeObject(item);
    }
    public ReferralBonusInfo get(int index)
    {
        return(ReferralBonusInfo)getObject(index);
    }
    public ReferralBonusInfo get(Object key)
    {
        return(ReferralBonusInfo)getObject(key);
    }
    public void set(int index, ReferralBonusInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(ReferralBonusInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(ReferralBonusInfo item)
    {
        return super.indexOf(item);
    }
}