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
import com.kingdee.eas.framework.ICoreBillEntryBase;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBillEntryBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class SpecategoryEntry extends CoreBillEntryBase implements ISpecategoryEntry
{
    public SpecategoryEntry()
    {
        super();
        registerInterface(ISpecategoryEntry.class, this);
    }
    public SpecategoryEntry(Context ctx)
    {
        super(ctx);
        registerInterface(ISpecategoryEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("62709C9E");
    }
    private SpecategoryEntryController getController() throws BOSException
    {
        return (SpecategoryEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public SpecategoryEntryInfo getSpecategoryEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getSpecategoryEntryInfo(getContext(), pk);
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
    public SpecategoryEntryInfo getSpecategoryEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getSpecategoryEntryInfo(getContext(), pk, selector);
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
    public SpecategoryEntryInfo getSpecategoryEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getSpecategoryEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public SpecategoryEntryCollection getSpecategoryEntryCollection() throws BOSException
    {
        try {
            return getController().getSpecategoryEntryCollection(getContext());
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
    public SpecategoryEntryCollection getSpecategoryEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getSpecategoryEntryCollection(getContext(), view);
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
    public SpecategoryEntryCollection getSpecategoryEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getSpecategoryEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}