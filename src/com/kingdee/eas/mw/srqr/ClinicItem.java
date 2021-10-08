package com.kingdee.eas.mw.srqr;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.mw.srqr.app.*;
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

public class ClinicItem extends CoreBillBase implements IClinicItem
{
    public ClinicItem()
    {
        super();
        registerInterface(IClinicItem.class, this);
    }
    public ClinicItem(Context ctx)
    {
        super(ctx);
        registerInterface(IClinicItem.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("EDB11C57");
    }
    private ClinicItemController getController() throws BOSException
    {
        return (ClinicItemController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public ClinicItemCollection getClinicItemCollection() throws BOSException
    {
        try {
            return getController().getClinicItemCollection(getContext());
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
    public ClinicItemCollection getClinicItemCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getClinicItemCollection(getContext(), view);
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
    public ClinicItemCollection getClinicItemCollection(String oql) throws BOSException
    {
        try {
            return getController().getClinicItemCollection(getContext(), oql);
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
    public ClinicItemInfo getClinicItemInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getClinicItemInfo(getContext(), pk);
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
    public ClinicItemInfo getClinicItemInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getClinicItemInfo(getContext(), pk, selector);
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
    public ClinicItemInfo getClinicItemInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getClinicItemInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}