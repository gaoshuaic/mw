package com.kingdee.eas.mw.pay;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class ShopGoalBonusCollection extends AbstractObjectCollection 
{
    public ShopGoalBonusCollection()
    {
        super(ShopGoalBonusInfo.class);
    }
    public boolean add(ShopGoalBonusInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(ShopGoalBonusCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(ShopGoalBonusInfo item)
    {
        return removeObject(item);
    }
    public ShopGoalBonusInfo get(int index)
    {
        return(ShopGoalBonusInfo)getObject(index);
    }
    public ShopGoalBonusInfo get(Object key)
    {
        return(ShopGoalBonusInfo)getObject(key);
    }
    public void set(int index, ShopGoalBonusInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(ShopGoalBonusInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(ShopGoalBonusInfo item)
    {
        return super.indexOf(item);
    }
}