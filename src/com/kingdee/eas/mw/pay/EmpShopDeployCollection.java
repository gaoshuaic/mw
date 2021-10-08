package com.kingdee.eas.mw.pay;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class EmpShopDeployCollection extends AbstractObjectCollection 
{
    public EmpShopDeployCollection()
    {
        super(EmpShopDeployInfo.class);
    }
    public boolean add(EmpShopDeployInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(EmpShopDeployCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(EmpShopDeployInfo item)
    {
        return removeObject(item);
    }
    public EmpShopDeployInfo get(int index)
    {
        return(EmpShopDeployInfo)getObject(index);
    }
    public EmpShopDeployInfo get(Object key)
    {
        return(EmpShopDeployInfo)getObject(key);
    }
    public void set(int index, EmpShopDeployInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(EmpShopDeployInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(EmpShopDeployInfo item)
    {
        return super.indexOf(item);
    }
}