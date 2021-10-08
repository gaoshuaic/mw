package com.kingdee.eas.mw.pay;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class WhiteBonusUpdateCollection extends AbstractObjectCollection 
{
    public WhiteBonusUpdateCollection()
    {
        super(WhiteBonusUpdateInfo.class);
    }
    public boolean add(WhiteBonusUpdateInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(WhiteBonusUpdateCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(WhiteBonusUpdateInfo item)
    {
        return removeObject(item);
    }
    public WhiteBonusUpdateInfo get(int index)
    {
        return(WhiteBonusUpdateInfo)getObject(index);
    }
    public WhiteBonusUpdateInfo get(Object key)
    {
        return(WhiteBonusUpdateInfo)getObject(key);
    }
    public void set(int index, WhiteBonusUpdateInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(WhiteBonusUpdateInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(WhiteBonusUpdateInfo item)
    {
        return super.indexOf(item);
    }
}