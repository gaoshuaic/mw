package com.kingdee.eas.mw.srqr;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.mw.srqr.app.*;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.DataBase;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.IDataBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class Paytypeitem extends DataBase implements IPaytypeitem
{
    public Paytypeitem()
    {
        super();
        registerInterface(IPaytypeitem.class, this);
    }
    public Paytypeitem(Context ctx)
    {
        super(ctx);
        registerInterface(IPaytypeitem.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("F28E2139");
    }
    private PaytypeitemController getController() throws BOSException
    {
        return (PaytypeitemController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public PaytypeitemInfo getPaytypeitemInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getPaytypeitemInfo(getContext(), pk);
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
    public PaytypeitemInfo getPaytypeitemInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getPaytypeitemInfo(getContext(), pk, selector);
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
    public PaytypeitemInfo getPaytypeitemInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getPaytypeitemInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public PaytypeitemCollection getPaytypeitemCollection() throws BOSException
    {
        try {
            return getController().getPaytypeitemCollection(getContext());
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
    public PaytypeitemCollection getPaytypeitemCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getPaytypeitemCollection(getContext(), view);
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
    public PaytypeitemCollection getPaytypeitemCollection(String oql) throws BOSException
    {
        try {
            return getController().getPaytypeitemCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}