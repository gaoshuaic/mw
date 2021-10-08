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

public class DianpingDedBJ extends CoreBillBase implements IDianpingDedBJ
{
    public DianpingDedBJ()
    {
        super();
        registerInterface(IDianpingDedBJ.class, this);
    }
    public DianpingDedBJ(Context ctx)
    {
        super(ctx);
        registerInterface(IDianpingDedBJ.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("A5507015");
    }
    private DianpingDedBJController getController() throws BOSException
    {
        return (DianpingDedBJController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public DianpingDedBJCollection getDianpingDedBJCollection() throws BOSException
    {
        try {
            return getController().getDianpingDedBJCollection(getContext());
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
    public DianpingDedBJCollection getDianpingDedBJCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getDianpingDedBJCollection(getContext(), view);
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
    public DianpingDedBJCollection getDianpingDedBJCollection(String oql) throws BOSException
    {
        try {
            return getController().getDianpingDedBJCollection(getContext(), oql);
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
    public DianpingDedBJInfo getDianpingDedBJInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getDianpingDedBJInfo(getContext(), pk);
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
    public DianpingDedBJInfo getDianpingDedBJInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getDianpingDedBJInfo(getContext(), pk, selector);
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
    public DianpingDedBJInfo getDianpingDedBJInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getDianpingDedBJInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}