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

public class Paytypecategory extends DataBase implements IPaytypecategory
{
    public Paytypecategory()
    {
        super();
        registerInterface(IPaytypecategory.class, this);
    }
    public Paytypecategory(Context ctx)
    {
        super(ctx);
        registerInterface(IPaytypecategory.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("8CB3E024");
    }
    private PaytypecategoryController getController() throws BOSException
    {
        return (PaytypecategoryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public PaytypecategoryInfo getPaytypecategoryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getPaytypecategoryInfo(getContext(), pk);
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
    public PaytypecategoryInfo getPaytypecategoryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getPaytypecategoryInfo(getContext(), pk, selector);
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
    public PaytypecategoryInfo getPaytypecategoryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getPaytypecategoryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public PaytypecategoryCollection getPaytypecategoryCollection() throws BOSException
    {
        try {
            return getController().getPaytypecategoryCollection(getContext());
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
    public PaytypecategoryCollection getPaytypecategoryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getPaytypecategoryCollection(getContext(), view);
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
    public PaytypecategoryCollection getPaytypecategoryCollection(String oql) throws BOSException
    {
        try {
            return getController().getPaytypecategoryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}