package com.kingdee.eas.mw.pay;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class AchRoyaltyRuleCollection extends AbstractObjectCollection 
{
    public AchRoyaltyRuleCollection()
    {
        super(AchRoyaltyRuleInfo.class);
    }
    public boolean add(AchRoyaltyRuleInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(AchRoyaltyRuleCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(AchRoyaltyRuleInfo item)
    {
        return removeObject(item);
    }
    public AchRoyaltyRuleInfo get(int index)
    {
        return(AchRoyaltyRuleInfo)getObject(index);
    }
    public AchRoyaltyRuleInfo get(Object key)
    {
        return(AchRoyaltyRuleInfo)getObject(key);
    }
    public void set(int index, AchRoyaltyRuleInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(AchRoyaltyRuleInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(AchRoyaltyRuleInfo item)
    {
        return super.indexOf(item);
    }
}