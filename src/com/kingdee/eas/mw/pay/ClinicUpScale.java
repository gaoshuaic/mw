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

public class ClinicUpScale extends DataBase implements IClinicUpScale
{
    public ClinicUpScale()
    {
        super();
        registerInterface(IClinicUpScale.class, this);
    }
    public ClinicUpScale(Context ctx)
    {
        super(ctx);
        registerInterface(IClinicUpScale.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("DD941F75");
    }
    private ClinicUpScaleController getController() throws BOSException
    {
        return (ClinicUpScaleController)getBizController();
    }
    /**
     *ȡֵ-System defined method
     *@param pk ȡֵ
     *@return
     */
    public ClinicUpScaleInfo getClinicUpScaleInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getClinicUpScaleInfo(getContext(), pk);
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
    public ClinicUpScaleInfo getClinicUpScaleInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getClinicUpScaleInfo(getContext(), pk, selector);
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
    public ClinicUpScaleInfo getClinicUpScaleInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getClinicUpScaleInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡ����-System defined method
     *@return
     */
    public ClinicUpScaleCollection getClinicUpScaleCollection() throws BOSException
    {
        try {
            return getController().getClinicUpScaleCollection(getContext());
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
    public ClinicUpScaleCollection getClinicUpScaleCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getClinicUpScaleCollection(getContext(), view);
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
    public ClinicUpScaleCollection getClinicUpScaleCollection(String oql) throws BOSException
    {
        try {
            return getController().getClinicUpScaleCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}