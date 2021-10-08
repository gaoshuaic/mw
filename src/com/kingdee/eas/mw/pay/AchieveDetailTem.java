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

public class AchieveDetailTem extends CoreBillBase implements IAchieveDetailTem
{
    public AchieveDetailTem()
    {
        super();
        registerInterface(IAchieveDetailTem.class, this);
    }
    public AchieveDetailTem(Context ctx)
    {
        super(ctx);
        registerInterface(IAchieveDetailTem.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("69F141EC");
    }
    private AchieveDetailTemController getController() throws BOSException
    {
        return (AchieveDetailTemController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public AchieveDetailTemCollection getAchieveDetailTemCollection() throws BOSException
    {
        try {
            return getController().getAchieveDetailTemCollection(getContext());
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
    public AchieveDetailTemCollection getAchieveDetailTemCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getAchieveDetailTemCollection(getContext(), view);
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
    public AchieveDetailTemCollection getAchieveDetailTemCollection(String oql) throws BOSException
    {
        try {
            return getController().getAchieveDetailTemCollection(getContext(), oql);
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
    public AchieveDetailTemInfo getAchieveDetailTemInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getAchieveDetailTemInfo(getContext(), pk);
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
    public AchieveDetailTemInfo getAchieveDetailTemInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getAchieveDetailTemInfo(getContext(), pk, selector);
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
    public AchieveDetailTemInfo getAchieveDetailTemInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getAchieveDetailTemInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *同步中间表-User defined method
     *@param model model
     */
    public void syncMiddata(AchieveDetailTemInfo model) throws BOSException
    {
        try {
            getController().syncMiddata(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}