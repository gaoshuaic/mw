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

public class CityCompanyTarget extends DataBase implements ICityCompanyTarget
{
    public CityCompanyTarget()
    {
        super();
        registerInterface(ICityCompanyTarget.class, this);
    }
    public CityCompanyTarget(Context ctx)
    {
        super(ctx);
        registerInterface(ICityCompanyTarget.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("14463D07");
    }
    private CityCompanyTargetController getController() throws BOSException
    {
        return (CityCompanyTargetController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public CityCompanyTargetInfo getCityCompanyTargetInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getCityCompanyTargetInfo(getContext(), pk);
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
    public CityCompanyTargetInfo getCityCompanyTargetInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getCityCompanyTargetInfo(getContext(), pk, selector);
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
    public CityCompanyTargetInfo getCityCompanyTargetInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getCityCompanyTargetInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public CityCompanyTargetCollection getCityCompanyTargetCollection() throws BOSException
    {
        try {
            return getController().getCityCompanyTargetCollection(getContext());
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
    public CityCompanyTargetCollection getCityCompanyTargetCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getCityCompanyTargetCollection(getContext(), view);
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
    public CityCompanyTargetCollection getCityCompanyTargetCollection(String oql) throws BOSException
    {
        try {
            return getController().getCityCompanyTargetCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}