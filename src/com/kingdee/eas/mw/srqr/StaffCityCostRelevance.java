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

public class StaffCityCostRelevance extends DataBase implements IStaffCityCostRelevance
{
    public StaffCityCostRelevance()
    {
        super();
        registerInterface(IStaffCityCostRelevance.class, this);
    }
    public StaffCityCostRelevance(Context ctx)
    {
        super(ctx);
        registerInterface(IStaffCityCostRelevance.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("2D427D9D");
    }
    private StaffCityCostRelevanceController getController() throws BOSException
    {
        return (StaffCityCostRelevanceController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public StaffCityCostRelevanceInfo getStaffCityCostRelevanceInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getStaffCityCostRelevanceInfo(getContext(), pk);
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
    public StaffCityCostRelevanceInfo getStaffCityCostRelevanceInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getStaffCityCostRelevanceInfo(getContext(), pk, selector);
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
    public StaffCityCostRelevanceInfo getStaffCityCostRelevanceInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getStaffCityCostRelevanceInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public StaffCityCostRelevanceCollection getStaffCityCostRelevanceCollection() throws BOSException
    {
        try {
            return getController().getStaffCityCostRelevanceCollection(getContext());
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
    public StaffCityCostRelevanceCollection getStaffCityCostRelevanceCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getStaffCityCostRelevanceCollection(getContext(), view);
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
    public StaffCityCostRelevanceCollection getStaffCityCostRelevanceCollection(String oql) throws BOSException
    {
        try {
            return getController().getStaffCityCostRelevanceCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}