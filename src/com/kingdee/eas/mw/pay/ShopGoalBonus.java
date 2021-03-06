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

public class ShopGoalBonus extends DataBase implements IShopGoalBonus
{
    public ShopGoalBonus()
    {
        super();
        registerInterface(IShopGoalBonus.class, this);
    }
    public ShopGoalBonus(Context ctx)
    {
        super(ctx);
        registerInterface(IShopGoalBonus.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("AD71DC84");
    }
    private ShopGoalBonusController getController() throws BOSException
    {
        return (ShopGoalBonusController)getBizController();
    }
    /**
     *ȡֵ-System defined method
     *@param pk ȡֵ
     *@return
     */
    public ShopGoalBonusInfo getShopGoalBonusInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getShopGoalBonusInfo(getContext(), pk);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡֵ-System defined method
     *@param pk ȡֵ
     *@param selector ȡֵ
     *@return
     */
    public ShopGoalBonusInfo getShopGoalBonusInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getShopGoalBonusInfo(getContext(), pk, selector);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡֵ-System defined method
     *@param oql ȡֵ
     *@return
     */
    public ShopGoalBonusInfo getShopGoalBonusInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getShopGoalBonusInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡ????-System defined method
     *@return
     */
    public ShopGoalBonusCollection getShopGoalBonusCollection() throws BOSException
    {
        try {
            return getController().getShopGoalBonusCollection(getContext());
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡ????-System defined method
     *@param view ȡ????
     *@return
     */
    public ShopGoalBonusCollection getShopGoalBonusCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getShopGoalBonusCollection(getContext(), view);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡ????-System defined method
     *@param oql ȡ????
     *@return
     */
    public ShopGoalBonusCollection getShopGoalBonusCollection(String oql) throws BOSException
    {
        try {
            return getController().getShopGoalBonusCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}