package com.kingdee.eas.mw.pay;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class DocAchieveUpdateCollection extends AbstractObjectCollection 
{
    public DocAchieveUpdateCollection()
    {
        super(DocAchieveUpdateInfo.class);
    }
    public boolean add(DocAchieveUpdateInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(DocAchieveUpdateCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(DocAchieveUpdateInfo item)
    {
        return removeObject(item);
    }
    public DocAchieveUpdateInfo get(int index)
    {
        return(DocAchieveUpdateInfo)getObject(index);
    }
    public DocAchieveUpdateInfo get(Object key)
    {
        return(DocAchieveUpdateInfo)getObject(key);
    }
    public void set(int index, DocAchieveUpdateInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(DocAchieveUpdateInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(DocAchieveUpdateInfo item)
    {
        return super.indexOf(item);
    }
}