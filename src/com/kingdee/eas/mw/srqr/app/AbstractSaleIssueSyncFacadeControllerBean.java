package com.kingdee.eas.mw.srqr.app;

import javax.ejb.*;
import java.rmi.RemoteException;
import com.kingdee.bos.*;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.metadata.IMetaDataPK;
import com.kingdee.bos.metadata.rule.RuleExecutor;
import com.kingdee.bos.metadata.MetaDataPK;
//import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.framework.ejb.AbstractEntityControllerBean;
import com.kingdee.bos.framework.ejb.AbstractBizControllerBean;
//import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.IObjectCollection;
import com.kingdee.bos.service.ServiceContext;
import com.kingdee.bos.service.IServiceContext;
import com.kingdee.eas.framework.Result;
import com.kingdee.eas.framework.LineResult;
import com.kingdee.eas.framework.exception.EASMultiException;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;

import java.lang.String;



public abstract class AbstractSaleIssueSyncFacadeControllerBean extends AbstractBizControllerBean implements SaleIssueSyncFacadeController
{
    protected AbstractSaleIssueSyncFacadeControllerBean()
    {
    }

    protected BOSObjectType getBOSType()
    {
        return new BOSObjectType("4847D8CB");
    }

    public void syncSaleIssueBill(Context ctx) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("d6e100c1-1b10-40f8-9bf3-3c1b1bb300c1"), new Object[]{ctx});
            invokeServiceBefore(svcCtx);
              if(!svcCtx.invokeBreak()) {
            _syncSaleIssueBill(ctx);
            }
            invokeServiceAfter(svcCtx);
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected void _syncSaleIssueBill(Context ctx) throws BOSException
    {    	
        return;
    }

    public void syncIssueLogToMid(Context ctx, String database) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("040a36b8-541f-49ab-a17e-346211b6960b"), new Object[]{ctx, database});
            invokeServiceBefore(svcCtx);
              if(!svcCtx.invokeBreak()) {
            _syncIssueLogToMid(ctx, database);
            }
            invokeServiceAfter(svcCtx);
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected void _syncIssueLogToMid(Context ctx, String database) throws BOSException
    {    	
        return;
    }

    public void syncSaleIssByCompany(Context ctx, String companyId) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("b0e5d9ad-cac9-4720-a4f4-22d77bfd9d32"), new Object[]{ctx, companyId});
            invokeServiceBefore(svcCtx);
              if(!svcCtx.invokeBreak()) {
            _syncSaleIssByCompany(ctx, companyId);
            }
            invokeServiceAfter(svcCtx);
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected void _syncSaleIssByCompany(Context ctx, String companyId) throws BOSException
    {    	
        return;
    }

}