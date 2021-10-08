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

public class ClinicAchieveUpdate extends DataBase implements IClinicAchieveUpdate
{
    public ClinicAchieveUpdate()
    {
        super();
        registerInterface(IClinicAchieveUpdate.class, this);
    }
    public ClinicAchieveUpdate(Context ctx)
    {
        super(ctx);
        registerInterface(IClinicAchieveUpdate.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("4E75FE00");
    }
    private ClinicAchieveUpdateController getController() throws BOSException
    {
        return (ClinicAchieveUpdateController)getBizController();
    }
    /**
     *ȡֵ-System defined method
     *@param pk ȡֵ
     *@return
     */
    public ClinicAchieveUpdateInfo getClinicAchieveUpdateInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getClinicAchieveUpdateInfo(getContext(), pk);
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
    public ClinicAchieveUpdateInfo getClinicAchieveUpdateInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getClinicAchieveUpdateInfo(getContext(), pk, selector);
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
    public ClinicAchieveUpdateInfo getClinicAchieveUpdateInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getClinicAchieveUpdateInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡ����-System defined method
     *@return
     */
    public ClinicAchieveUpdateCollection getClinicAchieveUpdateCollection() throws BOSException
    {
        try {
            return getController().getClinicAchieveUpdateCollection(getContext());
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
    public ClinicAchieveUpdateCollection getClinicAchieveUpdateCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getClinicAchieveUpdateCollection(getContext(), view);
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
    public ClinicAchieveUpdateCollection getClinicAchieveUpdateCollection(String oql) throws BOSException
    {
        try {
            return getController().getClinicAchieveUpdateCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}