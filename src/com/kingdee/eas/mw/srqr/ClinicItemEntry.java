package com.kingdee.eas.mw.srqr;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.mw.srqr.app.*;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.eas.framework.ICoreBillEntryBase;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBillEntryBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class ClinicItemEntry extends CoreBillEntryBase implements IClinicItemEntry
{
    public ClinicItemEntry()
    {
        super();
        registerInterface(IClinicItemEntry.class, this);
    }
    public ClinicItemEntry(Context ctx)
    {
        super(ctx);
        registerInterface(IClinicItemEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("59161A5B");
    }
    private ClinicItemEntryController getController() throws BOSException
    {
        return (ClinicItemEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public ClinicItemEntryInfo getClinicItemEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getClinicItemEntryInfo(getContext(), pk);
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
    public ClinicItemEntryInfo getClinicItemEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getClinicItemEntryInfo(getContext(), pk, selector);
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
    public ClinicItemEntryInfo getClinicItemEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getClinicItemEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public ClinicItemEntryCollection getClinicItemEntryCollection() throws BOSException
    {
        try {
            return getController().getClinicItemEntryCollection(getContext());
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
    public ClinicItemEntryCollection getClinicItemEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getClinicItemEntryCollection(getContext(), view);
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
    public ClinicItemEntryCollection getClinicItemEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getClinicItemEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}