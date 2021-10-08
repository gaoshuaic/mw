package com.kingdee.eas.mw.pay;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class ClinicUpScaleCollection extends AbstractObjectCollection 
{
    public ClinicUpScaleCollection()
    {
        super(ClinicUpScaleInfo.class);
    }
    public boolean add(ClinicUpScaleInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(ClinicUpScaleCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(ClinicUpScaleInfo item)
    {
        return removeObject(item);
    }
    public ClinicUpScaleInfo get(int index)
    {
        return(ClinicUpScaleInfo)getObject(index);
    }
    public ClinicUpScaleInfo get(Object key)
    {
        return(ClinicUpScaleInfo)getObject(key);
    }
    public void set(int index, ClinicUpScaleInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(ClinicUpScaleInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(ClinicUpScaleInfo item)
    {
        return super.indexOf(item);
    }
}