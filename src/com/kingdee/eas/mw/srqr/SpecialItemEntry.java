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

public class SpecialItemEntry extends CoreBillEntryBase implements ISpecialItemEntry
{
    public SpecialItemEntry()
    {
        super();
        registerInterface(ISpecialItemEntry.class, this);
    }
    public SpecialItemEntry(Context ctx)
    {
        super(ctx);
        registerInterface(ISpecialItemEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("88DFDFA2");
    }
    private SpecialItemEntryController getController() throws BOSException
    {
        return (SpecialItemEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public SpecialItemEntryInfo getSpecialItemEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getSpecialItemEntryInfo(getContext(), pk);
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
    public SpecialItemEntryInfo getSpecialItemEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getSpecialItemEntryInfo(getContext(), pk, selector);
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
    public SpecialItemEntryInfo getSpecialItemEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getSpecialItemEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public SpecialItemEntryCollection getSpecialItemEntryCollection() throws BOSException
    {
        try {
            return getController().getSpecialItemEntryCollection(getContext());
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
    public SpecialItemEntryCollection getSpecialItemEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getSpecialItemEntryCollection(getContext(), view);
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
    public SpecialItemEntryCollection getSpecialItemEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getSpecialItemEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}