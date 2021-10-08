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

public class BudgetDate extends CoreBillBase implements IBudgetDate
{
    public BudgetDate()
    {
        super();
        registerInterface(IBudgetDate.class, this);
    }
    public BudgetDate(Context ctx)
    {
        super(ctx);
        registerInterface(IBudgetDate.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("65CCD545");
    }
    private BudgetDateController getController() throws BOSException
    {
        return (BudgetDateController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public BudgetDateCollection getBudgetDateCollection() throws BOSException
    {
        try {
            return getController().getBudgetDateCollection(getContext());
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
    public BudgetDateCollection getBudgetDateCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getBudgetDateCollection(getContext(), view);
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
    public BudgetDateCollection getBudgetDateCollection(String oql) throws BOSException
    {
        try {
            return getController().getBudgetDateCollection(getContext(), oql);
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
    public BudgetDateInfo getBudgetDateInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getBudgetDateInfo(getContext(), pk);
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
    public BudgetDateInfo getBudgetDateInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getBudgetDateInfo(getContext(), pk, selector);
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
    public BudgetDateInfo getBudgetDateInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getBudgetDateInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}