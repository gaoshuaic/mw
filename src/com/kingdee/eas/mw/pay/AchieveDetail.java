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

public class AchieveDetail extends CoreBillBase implements IAchieveDetail
{
    public AchieveDetail()
    {
        super();
        registerInterface(IAchieveDetail.class, this);
    }
    public AchieveDetail(Context ctx)
    {
        super(ctx);
        registerInterface(IAchieveDetail.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("C9F3CC10");
    }
    private AchieveDetailController getController() throws BOSException
    {
        return (AchieveDetailController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public AchieveDetailCollection getAchieveDetailCollection() throws BOSException
    {
        try {
            return getController().getAchieveDetailCollection(getContext());
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
    public AchieveDetailCollection getAchieveDetailCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getAchieveDetailCollection(getContext(), view);
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
    public AchieveDetailCollection getAchieveDetailCollection(String oql) throws BOSException
    {
        try {
            return getController().getAchieveDetailCollection(getContext(), oql);
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
    public AchieveDetailInfo getAchieveDetailInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getAchieveDetailInfo(getContext(), pk);
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
    public AchieveDetailInfo getAchieveDetailInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getAchieveDetailInfo(getContext(), pk, selector);
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
    public AchieveDetailInfo getAchieveDetailInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getAchieveDetailInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *同步中间表-User defined method
     *@param model model
     */
    public void syncMiddata(AchieveDetailInfo model) throws BOSException
    {
        try {
            getController().syncMiddata(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}