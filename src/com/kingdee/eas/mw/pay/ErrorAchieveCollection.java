package com.kingdee.eas.mw.pay;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class ErrorAchieveCollection extends AbstractObjectCollection 
{
    public ErrorAchieveCollection()
    {
        super(ErrorAchieveInfo.class);
    }
    public boolean add(ErrorAchieveInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(ErrorAchieveCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(ErrorAchieveInfo item)
    {
        return removeObject(item);
    }
    public ErrorAchieveInfo get(int index)
    {
        return(ErrorAchieveInfo)getObject(index);
    }
    public ErrorAchieveInfo get(Object key)
    {
        return(ErrorAchieveInfo)getObject(key);
    }
    public void set(int index, ErrorAchieveInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(ErrorAchieveInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(ErrorAchieveInfo item)
    {
        return super.indexOf(item);
    }
}