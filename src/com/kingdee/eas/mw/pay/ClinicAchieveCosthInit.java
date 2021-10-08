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

public class ClinicAchieveCosthInit extends DataBase implements IClinicAchieveCosthInit
{
    public ClinicAchieveCosthInit()
    {
        super();
        registerInterface(IClinicAchieveCosthInit.class, this);
    }
    public ClinicAchieveCosthInit(Context ctx)
    {
        super(ctx);
        registerInterface(IClinicAchieveCosthInit.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("F965A954");
    }
    private ClinicAchieveCosthInitController getController() throws BOSException
    {
        return (ClinicAchieveCosthInitController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public ClinicAchieveCosthInitInfo getClinicAchieveCosthInitInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getClinicAchieveCosthInitInfo(getContext(), pk);
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
    public ClinicAchieveCosthInitInfo getClinicAchieveCosthInitInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getClinicAchieveCosthInitInfo(getContext(), pk, selector);
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
    public ClinicAchieveCosthInitInfo getClinicAchieveCosthInitInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getClinicAchieveCosthInitInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public ClinicAchieveCosthInitCollection getClinicAchieveCosthInitCollection() throws BOSException
    {
        try {
            return getController().getClinicAchieveCosthInitCollection(getContext());
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
    public ClinicAchieveCosthInitCollection getClinicAchieveCosthInitCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getClinicAchieveCosthInitCollection(getContext(), view);
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
    public ClinicAchieveCosthInitCollection getClinicAchieveCosthInitCollection(String oql) throws BOSException
    {
        try {
            return getController().getClinicAchieveCosthInitCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}