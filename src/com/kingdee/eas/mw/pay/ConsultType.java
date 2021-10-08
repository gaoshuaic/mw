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

public class ConsultType extends DataBase implements IConsultType
{
    public ConsultType()
    {
        super();
        registerInterface(IConsultType.class, this);
    }
    public ConsultType(Context ctx)
    {
        super(ctx);
        registerInterface(IConsultType.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("1B8FD2D4");
    }
    private ConsultTypeController getController() throws BOSException
    {
        return (ConsultTypeController)getBizController();
    }
    /**
     *ȡֵ-System defined method
     *@param pk ȡֵ
     *@return
     */
    public ConsultTypeInfo getConsultTypeInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getConsultTypeInfo(getContext(), pk);
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
    public ConsultTypeInfo getConsultTypeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getConsultTypeInfo(getContext(), pk, selector);
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
    public ConsultTypeInfo getConsultTypeInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getConsultTypeInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡ����-System defined method
     *@return
     */
    public ConsultTypeCollection getConsultTypeCollection() throws BOSException
    {
        try {
            return getController().getConsultTypeCollection(getContext());
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
    public ConsultTypeCollection getConsultTypeCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getConsultTypeCollection(getContext(), view);
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
    public ConsultTypeCollection getConsultTypeCollection(String oql) throws BOSException
    {
        try {
            return getController().getConsultTypeCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}