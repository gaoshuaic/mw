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

public class ConsultantBonusUpdate extends DataBase implements IConsultantBonusUpdate
{
    public ConsultantBonusUpdate()
    {
        super();
        registerInterface(IConsultantBonusUpdate.class, this);
    }
    public ConsultantBonusUpdate(Context ctx)
    {
        super(ctx);
        registerInterface(IConsultantBonusUpdate.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("8EF4785B");
    }
    private ConsultantBonusUpdateController getController() throws BOSException
    {
        return (ConsultantBonusUpdateController)getBizController();
    }
    /**
     *ȡֵ-System defined method
     *@param pk ȡֵ
     *@return
     */
    public ConsultantBonusUpdateInfo getConsultantBonusUpdateInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getConsultantBonusUpdateInfo(getContext(), pk);
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
    public ConsultantBonusUpdateInfo getConsultantBonusUpdateInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getConsultantBonusUpdateInfo(getContext(), pk, selector);
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
    public ConsultantBonusUpdateInfo getConsultantBonusUpdateInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getConsultantBonusUpdateInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡ����-System defined method
     *@return
     */
    public ConsultantBonusUpdateCollection getConsultantBonusUpdateCollection() throws BOSException
    {
        try {
            return getController().getConsultantBonusUpdateCollection(getContext());
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
    public ConsultantBonusUpdateCollection getConsultantBonusUpdateCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getConsultantBonusUpdateCollection(getContext(), view);
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
    public ConsultantBonusUpdateCollection getConsultantBonusUpdateCollection(String oql) throws BOSException
    {
        try {
            return getController().getConsultantBonusUpdateCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}