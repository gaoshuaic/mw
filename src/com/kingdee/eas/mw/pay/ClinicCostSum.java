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

public class ClinicCostSum extends DataBase implements IClinicCostSum
{
    public ClinicCostSum()
    {
        super();
        registerInterface(IClinicCostSum.class, this);
    }
    public ClinicCostSum(Context ctx)
    {
        super(ctx);
        registerInterface(IClinicCostSum.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("25799344");
    }
    private ClinicCostSumController getController() throws BOSException
    {
        return (ClinicCostSumController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public ClinicCostSumInfo getClinicCostSumInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getClinicCostSumInfo(getContext(), pk);
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
    public ClinicCostSumInfo getClinicCostSumInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getClinicCostSumInfo(getContext(), pk, selector);
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
    public ClinicCostSumInfo getClinicCostSumInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getClinicCostSumInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public ClinicCostSumCollection getClinicCostSumCollection() throws BOSException
    {
        try {
            return getController().getClinicCostSumCollection(getContext());
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
    public ClinicCostSumCollection getClinicCostSumCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getClinicCostSumCollection(getContext(), view);
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
    public ClinicCostSumCollection getClinicCostSumCollection(String oql) throws BOSException
    {
        try {
            return getController().getClinicCostSumCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}