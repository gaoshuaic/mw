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

public class DoctorRelation extends CoreBillBase implements IDoctorRelation
{
    public DoctorRelation()
    {
        super();
        registerInterface(IDoctorRelation.class, this);
    }
    public DoctorRelation(Context ctx)
    {
        super(ctx);
        registerInterface(IDoctorRelation.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("E851A3ED");
    }
    private DoctorRelationController getController() throws BOSException
    {
        return (DoctorRelationController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public DoctorRelationCollection getDoctorRelationCollection() throws BOSException
    {
        try {
            return getController().getDoctorRelationCollection(getContext());
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
    public DoctorRelationCollection getDoctorRelationCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getDoctorRelationCollection(getContext(), view);
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
    public DoctorRelationCollection getDoctorRelationCollection(String oql) throws BOSException
    {
        try {
            return getController().getDoctorRelationCollection(getContext(), oql);
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
    public DoctorRelationInfo getDoctorRelationInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getDoctorRelationInfo(getContext(), pk);
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
    public DoctorRelationInfo getDoctorRelationInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getDoctorRelationInfo(getContext(), pk, selector);
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
    public DoctorRelationInfo getDoctorRelationInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getDoctorRelationInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}