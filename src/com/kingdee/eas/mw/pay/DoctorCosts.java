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

public class DoctorCosts extends CoreBillBase implements IDoctorCosts
{
    public DoctorCosts()
    {
        super();
        registerInterface(IDoctorCosts.class, this);
    }
    public DoctorCosts(Context ctx)
    {
        super(ctx);
        registerInterface(IDoctorCosts.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("83964DF5");
    }
    private DoctorCostsController getController() throws BOSException
    {
        return (DoctorCostsController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public DoctorCostsCollection getDoctorCostsCollection() throws BOSException
    {
        try {
            return getController().getDoctorCostsCollection(getContext());
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
    public DoctorCostsCollection getDoctorCostsCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getDoctorCostsCollection(getContext(), view);
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
    public DoctorCostsCollection getDoctorCostsCollection(String oql) throws BOSException
    {
        try {
            return getController().getDoctorCostsCollection(getContext(), oql);
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
    public DoctorCostsInfo getDoctorCostsInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getDoctorCostsInfo(getContext(), pk);
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
    public DoctorCostsInfo getDoctorCostsInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getDoctorCostsInfo(getContext(), pk, selector);
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
    public DoctorCostsInfo getDoctorCostsInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getDoctorCostsInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}