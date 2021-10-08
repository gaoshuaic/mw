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

public class SaleIssueHisLog extends CoreBillBase implements ISaleIssueHisLog
{
    public SaleIssueHisLog()
    {
        super();
        registerInterface(ISaleIssueHisLog.class, this);
    }
    public SaleIssueHisLog(Context ctx)
    {
        super(ctx);
        registerInterface(ISaleIssueHisLog.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("EE852308");
    }
    private SaleIssueHisLogController getController() throws BOSException
    {
        return (SaleIssueHisLogController)getBizController();
    }
    /**
     *ȡ����-System defined method
     *@return
     */
    public SaleIssueHisLogCollection getSaleIssueHisLogCollection() throws BOSException
    {
        try {
            return getController().getSaleIssueHisLogCollection(getContext());
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
    public SaleIssueHisLogCollection getSaleIssueHisLogCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getSaleIssueHisLogCollection(getContext(), view);
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
    public SaleIssueHisLogCollection getSaleIssueHisLogCollection(String oql) throws BOSException
    {
        try {
            return getController().getSaleIssueHisLogCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡֵ-System defined method
     *@param pk ȡֵ
     *@return
     */
    public SaleIssueHisLogInfo getSaleIssueHisLogInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getSaleIssueHisLogInfo(getContext(), pk);
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
    public SaleIssueHisLogInfo getSaleIssueHisLogInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getSaleIssueHisLogInfo(getContext(), pk, selector);
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
    public SaleIssueHisLogInfo getSaleIssueHisLogInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getSaleIssueHisLogInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}