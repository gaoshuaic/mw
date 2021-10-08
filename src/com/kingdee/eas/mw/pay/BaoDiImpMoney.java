package com.kingdee.eas.mw.pay;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.eas.mw.pay.app.*;
import com.kingdee.bos.dao.IObjectPK;
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

public class BaoDiImpMoney extends DataBase implements IBaoDiImpMoney
{
    public BaoDiImpMoney()
    {
        super();
        registerInterface(IBaoDiImpMoney.class, this);
    }
    public BaoDiImpMoney(Context ctx)
    {
        super(ctx);
        registerInterface(IBaoDiImpMoney.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("6C26B637");
    }
    private BaoDiImpMoneyController getController() throws BOSException
    {
        return (BaoDiImpMoneyController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public BaoDiImpMoneyInfo getBaoDiImpMoneyInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getBaoDiImpMoneyInfo(getContext(), pk);
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
    public BaoDiImpMoneyInfo getBaoDiImpMoneyInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getBaoDiImpMoneyInfo(getContext(), pk, selector);
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
    public BaoDiImpMoneyInfo getBaoDiImpMoneyInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getBaoDiImpMoneyInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public BaoDiImpMoneyCollection getBaoDiImpMoneyCollection() throws BOSException
    {
        try {
            return getController().getBaoDiImpMoneyCollection(getContext());
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
    public BaoDiImpMoneyCollection getBaoDiImpMoneyCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getBaoDiImpMoneyCollection(getContext(), view);
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
    public BaoDiImpMoneyCollection getBaoDiImpMoneyCollection(String oql) throws BOSException
    {
        try {
            return getController().getBaoDiImpMoneyCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}