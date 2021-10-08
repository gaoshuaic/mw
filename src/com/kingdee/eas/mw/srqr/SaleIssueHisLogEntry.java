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

public class SaleIssueHisLogEntry extends CoreBillEntryBase implements ISaleIssueHisLogEntry
{
    public SaleIssueHisLogEntry()
    {
        super();
        registerInterface(ISaleIssueHisLogEntry.class, this);
    }
    public SaleIssueHisLogEntry(Context ctx)
    {
        super(ctx);
        registerInterface(ISaleIssueHisLogEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("27DF9A4A");
    }
    private SaleIssueHisLogEntryController getController() throws BOSException
    {
        return (SaleIssueHisLogEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public SaleIssueHisLogEntryInfo getSaleIssueHisLogEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getSaleIssueHisLogEntryInfo(getContext(), pk);
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
    public SaleIssueHisLogEntryInfo getSaleIssueHisLogEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getSaleIssueHisLogEntryInfo(getContext(), pk, selector);
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
    public SaleIssueHisLogEntryInfo getSaleIssueHisLogEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getSaleIssueHisLogEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public SaleIssueHisLogEntryCollection getSaleIssueHisLogEntryCollection() throws BOSException
    {
        try {
            return getController().getSaleIssueHisLogEntryCollection(getContext());
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
    public SaleIssueHisLogEntryCollection getSaleIssueHisLogEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getSaleIssueHisLogEntryCollection(getContext(), view);
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
    public SaleIssueHisLogEntryCollection getSaleIssueHisLogEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getSaleIssueHisLogEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}