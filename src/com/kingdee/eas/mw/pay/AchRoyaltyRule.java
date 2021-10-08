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

public class AchRoyaltyRule extends DataBase implements IAchRoyaltyRule
{
    public AchRoyaltyRule()
    {
        super();
        registerInterface(IAchRoyaltyRule.class, this);
    }
    public AchRoyaltyRule(Context ctx)
    {
        super(ctx);
        registerInterface(IAchRoyaltyRule.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("19F27034");
    }
    private AchRoyaltyRuleController getController() throws BOSException
    {
        return (AchRoyaltyRuleController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public AchRoyaltyRuleInfo getAchRoyaltyRuleInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getAchRoyaltyRuleInfo(getContext(), pk);
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
    public AchRoyaltyRuleInfo getAchRoyaltyRuleInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getAchRoyaltyRuleInfo(getContext(), pk, selector);
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
    public AchRoyaltyRuleInfo getAchRoyaltyRuleInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getAchRoyaltyRuleInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public AchRoyaltyRuleCollection getAchRoyaltyRuleCollection() throws BOSException
    {
        try {
            return getController().getAchRoyaltyRuleCollection(getContext());
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
    public AchRoyaltyRuleCollection getAchRoyaltyRuleCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getAchRoyaltyRuleCollection(getContext(), view);
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
    public AchRoyaltyRuleCollection getAchRoyaltyRuleCollection(String oql) throws BOSException
    {
        try {
            return getController().getAchRoyaltyRuleCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}