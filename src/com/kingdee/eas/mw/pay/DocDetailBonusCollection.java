package com.kingdee.eas.mw.pay;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class DocDetailBonusCollection extends AbstractObjectCollection 
{
    public DocDetailBonusCollection()
    {
        super(DocDetailBonusInfo.class);
    }
    public boolean add(DocDetailBonusInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(DocDetailBonusCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(DocDetailBonusInfo item)
    {
        return removeObject(item);
    }
    public DocDetailBonusInfo get(int index)
    {
        return(DocDetailBonusInfo)getObject(index);
    }
    public DocDetailBonusInfo get(Object key)
    {
        return(DocDetailBonusInfo)getObject(key);
    }
    public void set(int index, DocDetailBonusInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(DocDetailBonusInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(DocDetailBonusInfo item)
    {
        return super.indexOf(item);
    }
}