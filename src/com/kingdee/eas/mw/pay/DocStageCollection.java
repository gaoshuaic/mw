package com.kingdee.eas.mw.pay;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class DocStageCollection extends AbstractObjectCollection 
{
    public DocStageCollection()
    {
        super(DocStageInfo.class);
    }
    public boolean add(DocStageInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(DocStageCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(DocStageInfo item)
    {
        return removeObject(item);
    }
    public DocStageInfo get(int index)
    {
        return(DocStageInfo)getObject(index);
    }
    public DocStageInfo get(Object key)
    {
        return(DocStageInfo)getObject(key);
    }
    public void set(int index, DocStageInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(DocStageInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(DocStageInfo item)
    {
        return super.indexOf(item);
    }
}