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

public class FreeItemCheck extends DataBase implements IFreeItemCheck
{
    public FreeItemCheck()
    {
        super();
        registerInterface(IFreeItemCheck.class, this);
    }
    public FreeItemCheck(Context ctx)
    {
        super(ctx);
        registerInterface(IFreeItemCheck.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("9DDEEAED");
    }
    private FreeItemCheckController getController() throws BOSException
    {
        return (FreeItemCheckController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public FreeItemCheckInfo getFreeItemCheckInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getFreeItemCheckInfo(getContext(), pk);
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
    public FreeItemCheckInfo getFreeItemCheckInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getFreeItemCheckInfo(getContext(), pk, selector);
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
    public FreeItemCheckInfo getFreeItemCheckInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getFreeItemCheckInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public FreeItemCheckCollection getFreeItemCheckCollection() throws BOSException
    {
        try {
            return getController().getFreeItemCheckCollection(getContext());
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
    public FreeItemCheckCollection getFreeItemCheckCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getFreeItemCheckCollection(getContext(), view);
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
    public FreeItemCheckCollection getFreeItemCheckCollection(String oql) throws BOSException
    {
        try {
            return getController().getFreeItemCheckCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}