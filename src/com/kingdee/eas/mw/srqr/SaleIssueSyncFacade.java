package com.kingdee.eas.mw.srqr;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import com.kingdee.eas.mw.srqr.app.*;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;

public class SaleIssueSyncFacade extends AbstractBizCtrl implements ISaleIssueSyncFacade
{
    public SaleIssueSyncFacade()
    {
        super();
        registerInterface(ISaleIssueSyncFacade.class, this);
    }
    public SaleIssueSyncFacade(Context ctx)
    {
        super(ctx);
        registerInterface(ISaleIssueSyncFacade.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("4847D8CB");
    }
    private SaleIssueSyncFacadeController getController() throws BOSException
    {
        return (SaleIssueSyncFacadeController)getBizController();
    }
    /**
     *ͬ�����۳��ⵥ-User defined method
     */
    public void syncSaleIssueBill() throws BOSException
    {
        try {
            getController().syncSaleIssueBill(getContext());
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *���۳��ⵥ��־ͬ���м��-User defined method
     *@param database ���ݿ�
     */
    public void syncIssueLogToMid(String database) throws BOSException
    {
        try {
            getController().syncIssueLogToMid(getContext(), database);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ͬ�����۳��ⵥ-User defined method
     *@param companyId ��˾ID
     */
    public void syncSaleIssByCompany(String companyId) throws BOSException
    {
        try {
            getController().syncSaleIssByCompany(getContext(), companyId);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}