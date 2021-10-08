package com.kingdee.eas.mw.pay;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.eas.mw.pay.app.*;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.framework.CoreBillBase;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.framework.ICoreBillBase;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class HolderDataSource extends CoreBillBase implements IHolderDataSource
{
    public HolderDataSource()
    {
        super();
        registerInterface(IHolderDataSource.class, this);
    }
    public HolderDataSource(Context ctx)
    {
        super(ctx);
        registerInterface(IHolderDataSource.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("B665FE63");
    }
    private HolderDataSourceController getController() throws BOSException
    {
        return (HolderDataSourceController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public HolderDataSourceCollection getHolderDataSourceCollection() throws BOSException
    {
        try {
            return getController().getHolderDataSourceCollection(getContext());
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@param view 取集合
     *@return
     */
    public HolderDataSourceCollection getHolderDataSourceCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getHolderDataSourceCollection(getContext(), view);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@param oql 取集合
     *@return
     */
    public HolderDataSourceCollection getHolderDataSourceCollection(String oql) throws BOSException
    {
        try {
            return getController().getHolderDataSourceCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public HolderDataSourceInfo getHolderDataSourceInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getHolderDataSourceInfo(getContext(), pk);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@param selector 取值
     *@return
     */
    public HolderDataSourceInfo getHolderDataSourceInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getHolderDataSourceInfo(getContext(), pk, selector);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取值-System defined method
     *@param oql 取值
     *@return
     */
    public HolderDataSourceInfo getHolderDataSourceInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getHolderDataSourceInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}