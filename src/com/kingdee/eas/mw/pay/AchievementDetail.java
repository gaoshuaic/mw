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

public class AchievementDetail extends CoreBillBase implements IAchievementDetail
{
    public AchievementDetail()
    {
        super();
        registerInterface(IAchievementDetail.class, this);
    }
    public AchievementDetail(Context ctx)
    {
        super(ctx);
        registerInterface(IAchievementDetail.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("3251FB6E");
    }
    private AchievementDetailController getController() throws BOSException
    {
        return (AchievementDetailController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public AchievementDetailCollection getAchievementDetailCollection() throws BOSException
    {
        try {
            return getController().getAchievementDetailCollection(getContext());
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
    public AchievementDetailCollection getAchievementDetailCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getAchievementDetailCollection(getContext(), view);
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
    public AchievementDetailCollection getAchievementDetailCollection(String oql) throws BOSException
    {
        try {
            return getController().getAchievementDetailCollection(getContext(), oql);
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
    public AchievementDetailInfo getAchievementDetailInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getAchievementDetailInfo(getContext(), pk);
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
    public AchievementDetailInfo getAchievementDetailInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getAchievementDetailInfo(getContext(), pk, selector);
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
    public AchievementDetailInfo getAchievementDetailInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getAchievementDetailInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}