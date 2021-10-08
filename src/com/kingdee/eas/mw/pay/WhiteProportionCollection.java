package com.kingdee.eas.mw.pay;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class WhiteProportionCollection extends AbstractObjectCollection 
{
    public WhiteProportionCollection()
    {
        super(WhiteProportionInfo.class);
    }
    public boolean add(WhiteProportionInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(WhiteProportionCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(WhiteProportionInfo item)
    {
        return removeObject(item);
    }
    public WhiteProportionInfo get(int index)
    {
        return(WhiteProportionInfo)getObject(index);
    }
    public WhiteProportionInfo get(Object key)
    {
        return(WhiteProportionInfo)getObject(key);
    }
    public void set(int index, WhiteProportionInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(WhiteProportionInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(WhiteProportionInfo item)
    {
        return super.indexOf(item);
    }
}