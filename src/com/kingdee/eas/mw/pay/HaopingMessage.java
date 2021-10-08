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

public class HaopingMessage extends CoreBillBase implements IHaopingMessage
{
    public HaopingMessage()
    {
        super();
        registerInterface(IHaopingMessage.class, this);
    }
    public HaopingMessage(Context ctx)
    {
        super(ctx);
        registerInterface(IHaopingMessage.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("E7834991");
    }
    private HaopingMessageController getController() throws BOSException
    {
        return (HaopingMessageController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public HaopingMessageCollection getHaopingMessageCollection() throws BOSException
    {
        try {
            return getController().getHaopingMessageCollection(getContext());
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
    public HaopingMessageCollection getHaopingMessageCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getHaopingMessageCollection(getContext(), view);
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
    public HaopingMessageCollection getHaopingMessageCollection(String oql) throws BOSException
    {
        try {
            return getController().getHaopingMessageCollection(getContext(), oql);
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
    public HaopingMessageInfo getHaopingMessageInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getHaopingMessageInfo(getContext(), pk);
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
    public HaopingMessageInfo getHaopingMessageInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getHaopingMessageInfo(getContext(), pk, selector);
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
    public HaopingMessageInfo getHaopingMessageInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getHaopingMessageInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}