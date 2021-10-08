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

public class ItemCheckEntry extends CoreBillEntryBase implements IItemCheckEntry
{
    public ItemCheckEntry()
    {
        super();
        registerInterface(IItemCheckEntry.class, this);
    }
    public ItemCheckEntry(Context ctx)
    {
        super(ctx);
        registerInterface(IItemCheckEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("CC3041F9");
    }
    private ItemCheckEntryController getController() throws BOSException
    {
        return (ItemCheckEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public ItemCheckEntryInfo getItemCheckEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getItemCheckEntryInfo(getContext(), pk);
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
    public ItemCheckEntryInfo getItemCheckEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getItemCheckEntryInfo(getContext(), pk, selector);
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
    public ItemCheckEntryInfo getItemCheckEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getItemCheckEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public ItemCheckEntryCollection getItemCheckEntryCollection() throws BOSException
    {
        try {
            return getController().getItemCheckEntryCollection(getContext());
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
    public ItemCheckEntryCollection getItemCheckEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getItemCheckEntryCollection(getContext(), view);
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
    public ItemCheckEntryCollection getItemCheckEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getItemCheckEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}