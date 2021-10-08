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

public class ConsultKeep extends DataBase implements IConsultKeep
{
    public ConsultKeep()
    {
        super();
        registerInterface(IConsultKeep.class, this);
    }
    public ConsultKeep(Context ctx)
    {
        super(ctx);
        registerInterface(IConsultKeep.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("1B8B6F1F");
    }
    private ConsultKeepController getController() throws BOSException
    {
        return (ConsultKeepController)getBizController();
    }
    /**
     *ȡֵ-System defined method
     *@param pk ȡֵ
     *@return
     */
    public ConsultKeepInfo getConsultKeepInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getConsultKeepInfo(getContext(), pk);
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
    public ConsultKeepInfo getConsultKeepInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getConsultKeepInfo(getContext(), pk, selector);
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
    public ConsultKeepInfo getConsultKeepInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getConsultKeepInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡ����-System defined method
     *@return
     */
    public ConsultKeepCollection getConsultKeepCollection() throws BOSException
    {
        try {
            return getController().getConsultKeepCollection(getContext());
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
    public ConsultKeepCollection getConsultKeepCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getConsultKeepCollection(getContext(), view);
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
    public ConsultKeepCollection getConsultKeepCollection(String oql) throws BOSException
    {
        try {
            return getController().getConsultKeepCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}