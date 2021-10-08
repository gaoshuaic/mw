package com.kingdee.eas.mw.srqr;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class ClinicCheckCollection extends AbstractObjectCollection 
{
    public ClinicCheckCollection()
    {
        super(ClinicCheckInfo.class);
    }
    public boolean add(ClinicCheckInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(ClinicCheckCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(ClinicCheckInfo item)
    {
        return removeObject(item);
    }
    public ClinicCheckInfo get(int index)
    {
        return(ClinicCheckInfo)getObject(index);
    }
    public ClinicCheckInfo get(Object key)
    {
        return(ClinicCheckInfo)getObject(key);
    }
    public void set(int index, ClinicCheckInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(ClinicCheckInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(ClinicCheckInfo item)
    {
        return super.indexOf(item);
    }
}