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

public class ClinicComSub extends DataBase implements IClinicComSub
{
    public ClinicComSub()
    {
        super();
        registerInterface(IClinicComSub.class, this);
    }
    public ClinicComSub(Context ctx)
    {
        super(ctx);
        registerInterface(IClinicComSub.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("E02A0439");
    }
    private ClinicComSubController getController() throws BOSException
    {
        return (ClinicComSubController)getBizController();
    }
    /**
     *ȡֵ-System defined method
     *@param pk ȡֵ
     *@return
     */
    public ClinicComSubInfo getClinicComSubInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getClinicComSubInfo(getContext(), pk);
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
    public ClinicComSubInfo getClinicComSubInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getClinicComSubInfo(getContext(), pk, selector);
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
    public ClinicComSubInfo getClinicComSubInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getClinicComSubInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡ����-System defined method
     *@return
     */
    public ClinicComSubCollection getClinicComSubCollection() throws BOSException
    {
        try {
            return getController().getClinicComSubCollection(getContext());
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡ����-System defined method
     *@param view ȡ����
     *@return
     */
    public ClinicComSubCollection getClinicComSubCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getClinicComSubCollection(getContext(), view);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡ����-System defined method
     *@param oql ȡ����
     *@return
     */
    public ClinicComSubCollection getClinicComSubCollection(String oql) throws BOSException
    {
        try {
            return getController().getClinicComSubCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}