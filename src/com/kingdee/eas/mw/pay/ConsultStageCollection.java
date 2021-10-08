package com.kingdee.eas.mw.pay;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class ConsultStageCollection extends AbstractObjectCollection 
{
    public ConsultStageCollection()
    {
        super(ConsultStageInfo.class);
    }
    public boolean add(ConsultStageInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(ConsultStageCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(ConsultStageInfo item)
    {
        return removeObject(item);
    }
    public ConsultStageInfo get(int index)
    {
        return(ConsultStageInfo)getObject(index);
    }
    public ConsultStageInfo get(Object key)
    {
        return(ConsultStageInfo)getObject(key);
    }
    public void set(int index, ConsultStageInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(ConsultStageInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(ConsultStageInfo item)
    {
        return super.indexOf(item);
    }
}