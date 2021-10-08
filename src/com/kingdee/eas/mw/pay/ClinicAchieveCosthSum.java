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

public class ClinicAchieveCosthSum extends DataBase implements IClinicAchieveCosthSum
{
    public ClinicAchieveCosthSum()
    {
        super();
        registerInterface(IClinicAchieveCosthSum.class, this);
    }
    public ClinicAchieveCosthSum(Context ctx)
    {
        super(ctx);
        registerInterface(IClinicAchieveCosthSum.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("20D1E187");
    }
    private ClinicAchieveCosthSumController getController() throws BOSException
    {
        return (ClinicAchieveCosthSumController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public ClinicAchieveCosthSumInfo getClinicAchieveCosthSumInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getClinicAchieveCosthSumInfo(getContext(), pk);
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
    public ClinicAchieveCosthSumInfo getClinicAchieveCosthSumInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getClinicAchieveCosthSumInfo(getContext(), pk, selector);
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
    public ClinicAchieveCosthSumInfo getClinicAchieveCosthSumInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getClinicAchieveCosthSumInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public ClinicAchieveCosthSumCollection getClinicAchieveCosthSumCollection() throws BOSException
    {
        try {
            return getController().getClinicAchieveCosthSumCollection(getContext());
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
    public ClinicAchieveCosthSumCollection getClinicAchieveCosthSumCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getClinicAchieveCosthSumCollection(getContext(), view);
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
    public ClinicAchieveCosthSumCollection getClinicAchieveCosthSumCollection(String oql) throws BOSException
    {
        try {
            return getController().getClinicAchieveCosthSumCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}