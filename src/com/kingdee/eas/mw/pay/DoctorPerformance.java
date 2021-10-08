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

public class DoctorPerformance extends CoreBillBase implements IDoctorPerformance
{
    public DoctorPerformance()
    {
        super();
        registerInterface(IDoctorPerformance.class, this);
    }
    public DoctorPerformance(Context ctx)
    {
        super(ctx);
        registerInterface(IDoctorPerformance.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("9286549F");
    }
    private DoctorPerformanceController getController() throws BOSException
    {
        return (DoctorPerformanceController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public DoctorPerformanceCollection getDoctorPerformanceCollection() throws BOSException
    {
        try {
            return getController().getDoctorPerformanceCollection(getContext());
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
    public DoctorPerformanceCollection getDoctorPerformanceCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getDoctorPerformanceCollection(getContext(), view);
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
    public DoctorPerformanceCollection getDoctorPerformanceCollection(String oql) throws BOSException
    {
        try {
            return getController().getDoctorPerformanceCollection(getContext(), oql);
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
    public DoctorPerformanceInfo getDoctorPerformanceInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getDoctorPerformanceInfo(getContext(), pk);
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
    public DoctorPerformanceInfo getDoctorPerformanceInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getDoctorPerformanceInfo(getContext(), pk, selector);
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
    public DoctorPerformanceInfo getDoctorPerformanceInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getDoctorPerformanceInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}