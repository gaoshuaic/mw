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

public class ConsultantPro extends DataBase implements IConsultantPro
{
    public ConsultantPro()
    {
        super();
        registerInterface(IConsultantPro.class, this);
    }
    public ConsultantPro(Context ctx)
    {
        super(ctx);
        registerInterface(IConsultantPro.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("8C7BFC40");
    }
    private ConsultantProController getController() throws BOSException
    {
        return (ConsultantProController)getBizController();
    }
    /**
     *ȡֵ-System defined method
     *@param pk ȡֵ
     *@return
     */
    public ConsultantProInfo getConsultantProInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getConsultantProInfo(getContext(), pk);
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
    public ConsultantProInfo getConsultantProInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getConsultantProInfo(getContext(), pk, selector);
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
    public ConsultantProInfo getConsultantProInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getConsultantProInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡ����-System defined method
     *@return
     */
    public ConsultantProCollection getConsultantProCollection() throws BOSException
    {
        try {
            return getController().getConsultantProCollection(getContext());
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
    public ConsultantProCollection getConsultantProCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getConsultantProCollection(getContext(), view);
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
    public ConsultantProCollection getConsultantProCollection(String oql) throws BOSException
    {
        try {
            return getController().getConsultantProCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}