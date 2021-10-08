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
     *ȡֵ-System defined method
     *@param pk ȡֵ
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
     *ȡֵ-System defined method
     *@param pk ȡֵ
     *@param selector ȡֵ
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
     *ȡֵ-System defined method
     *@param oql ȡֵ
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
     *ȡ����-System defined method
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
     *ȡ����-System defined method
     *@param view ȡ����
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
     *ȡ����-System defined method
     *@param oql ȡ����
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