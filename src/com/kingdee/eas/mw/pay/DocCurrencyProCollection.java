package com.kingdee.eas.mw.pay;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class DocCurrencyProCollection extends AbstractObjectCollection 
{
    public DocCurrencyProCollection()
    {
        super(DocCurrencyProInfo.class);
    }
    public boolean add(DocCurrencyProInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(DocCurrencyProCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(DocCurrencyProInfo item)
    {
        return removeObject(item);
    }
    public DocCurrencyProInfo get(int index)
    {
        return(DocCurrencyProInfo)getObject(index);
    }
    public DocCurrencyProInfo get(Object key)
    {
        return(DocCurrencyProInfo)getObject(key);
    }
    public void set(int index, DocCurrencyProInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(DocCurrencyProInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(DocCurrencyProInfo item)
    {
        return super.indexOf(item);
    }
}