package com.kingdee.eas.mw.pay;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class DocHISBiLiCollection extends AbstractObjectCollection 
{
    public DocHISBiLiCollection()
    {
        super(DocHISBiLiInfo.class);
    }
    public boolean add(DocHISBiLiInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(DocHISBiLiCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(DocHISBiLiInfo item)
    {
        return removeObject(item);
    }
    public DocHISBiLiInfo get(int index)
    {
        return(DocHISBiLiInfo)getObject(index);
    }
    public DocHISBiLiInfo get(Object key)
    {
        return(DocHISBiLiInfo)getObject(key);
    }
    public void set(int index, DocHISBiLiInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(DocHISBiLiInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(DocHISBiLiInfo item)
    {
        return super.indexOf(item);
    }
}