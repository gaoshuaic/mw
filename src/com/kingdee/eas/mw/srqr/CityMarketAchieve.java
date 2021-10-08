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

public class CityMarketAchieve extends DataBase implements ICityMarketAchieve
{
    public CityMarketAchieve()
    {
        super();
        registerInterface(ICityMarketAchieve.class, this);
    }
    public CityMarketAchieve(Context ctx)
    {
        super(ctx);
        registerInterface(ICityMarketAchieve.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("64A8C70E");
    }
    private CityMarketAchieveController getController() throws BOSException
    {
        return (CityMarketAchieveController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public CityMarketAchieveInfo getCityMarketAchieveInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getCityMarketAchieveInfo(getContext(), pk);
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
    public CityMarketAchieveInfo getCityMarketAchieveInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getCityMarketAchieveInfo(getContext(), pk, selector);
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
    public CityMarketAchieveInfo getCityMarketAchieveInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getCityMarketAchieveInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public CityMarketAchieveCollection getCityMarketAchieveCollection() throws BOSException
    {
        try {
            return getController().getCityMarketAchieveCollection(getContext());
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
    public CityMarketAchieveCollection getCityMarketAchieveCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getCityMarketAchieveCollection(getContext(), view);
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
    public CityMarketAchieveCollection getCityMarketAchieveCollection(String oql) throws BOSException
    {
        try {
            return getController().getCityMarketAchieveCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}