package com.kingdee.eas.mw.pay.app;

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



public abstract class AbstractSyncDataFacadeControllerBean extends AbstractBizControllerBean implements SyncDataFacadeController
{
    protected AbstractSyncDataFacadeControllerBean()
    {
    }

    protected BOSObjectType getBOSType()
    {
        return new BOSObjectType("BD6E9991");
    }

    public void SyncItemFirstClass(Context ctx, String dataBase) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("29b21edd-aa8d-4450-bf44-2f29d2d1b010"), new Object[]{ctx, dataBase});
            invokeServiceBefore(svcCtx);
              if(!svcCtx.invokeBreak()) {
            _SyncItemFirstClass(ctx, dataBase);
            }
            invokeServiceAfter(svcCtx);
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected void _SyncItemFirstClass(Context ctx, String dataBase) throws BOSException
    {    	
        return;
    }

    public void SyncItemSecondClass(Context ctx, String dataBase) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("c8dd0e5d-1743-4955-98cf-7dd44b99448e"), new Object[]{ctx, dataBase});
            invokeServiceBefore(svcCtx);
              if(!svcCtx.invokeBreak()) {
            _SyncItemSecondClass(ctx, dataBase);
            }
            invokeServiceAfter(svcCtx);
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected void _SyncItemSecondClass(Context ctx, String dataBase) throws BOSException
    {    	
        return;
    }

    public void SyncItem(Context ctx, String dataBase) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("a36f991f-135e-4f1e-8029-fe9cf6d54ba9"), new Object[]{ctx, dataBase});
            invokeServiceBefore(svcCtx);
              if(!svcCtx.invokeBreak()) {
            _SyncItem(ctx, dataBase);
            }
            invokeServiceAfter(svcCtx);
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected void _SyncItem(Context ctx, String dataBase) throws BOSException
    {    	
        return;
    }

    public void SyncItemCity(Context ctx, String dataBase) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("16d2828a-9adb-441a-8c94-8987f9c39322"), new Object[]{ctx, dataBase});
            invokeServiceBefore(svcCtx);
              if(!svcCtx.invokeBreak()) {
            _SyncItemCity(ctx, dataBase);
            }
            invokeServiceAfter(svcCtx);
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected void _SyncItemCity(Context ctx, String dataBase) throws BOSException
    {    	
        return;
    }

    public void SyncClinicCheck(Context ctx, String dataBase) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("a5bfa23c-c109-410d-955b-b398b090ee14"), new Object[]{ctx, dataBase});
            invokeServiceBefore(svcCtx);
              if(!svcCtx.invokeBreak()) {
            _SyncClinicCheck(ctx, dataBase);
            }
            invokeServiceAfter(svcCtx);
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected void _SyncClinicCheck(Context ctx, String dataBase) throws BOSException
    {    	
        return;
    }

    public void setAchieveSum(Context ctx, String dataBase, String cityNumber) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("62171eb0-228b-434b-8729-12d947fefde4"), new Object[]{ctx, dataBase, cityNumber});
            invokeServiceBefore(svcCtx);
              if(!svcCtx.invokeBreak()) {
            _setAchieveSum(ctx, dataBase, cityNumber);
            }
            invokeServiceAfter(svcCtx);
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected void _setAchieveSum(Context ctx, String dataBase, String cityNumber) throws BOSException
    {    	
        return;
    }

    public void SyncClinicMonthSum(Context ctx, String dataBase) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("622f1758-4bdf-4ee7-bfac-88fcc141c871"), new Object[]{ctx, dataBase});
            invokeServiceBefore(svcCtx);
              if(!svcCtx.invokeBreak()) {
            _SyncClinicMonthSum(ctx, dataBase);
            }
            invokeServiceAfter(svcCtx);
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected void _SyncClinicMonthSum(Context ctx, String dataBase) throws BOSException
    {    	
        return;
    }

    public void putCostDetailAndAll(Context ctx, String businessdate) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("d3254dbe-4d25-4ed4-90ac-b4e4d708479d"), new Object[]{ctx, businessdate});
            invokeServiceBefore(svcCtx);
              if(!svcCtx.invokeBreak()) {
            _putCostDetailAndAll(ctx, businessdate);
            }
            invokeServiceAfter(svcCtx);
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected void _putCostDetailAndAll(Context ctx, String businessdate) throws BOSException
    {    	
        return;
    }

    public void createCostBuUser(Context ctx, String businessdate) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("b1fc20ca-a156-4726-9ee5-edd3ddd0bccb"), new Object[]{ctx, businessdate});
            invokeServiceBefore(svcCtx);
              if(!svcCtx.invokeBreak()) {
            _createCostBuUser(ctx, businessdate);
            }
            invokeServiceAfter(svcCtx);
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected void _createCostBuUser(Context ctx, String businessdate) throws BOSException
    {    	
        return;
    }

    public void initBaseDate(Context ctx, String businessDate) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("2aa4ae34-1390-4e9d-9c4e-9dfa0d46fa64"), new Object[]{ctx, businessDate});
            invokeServiceBefore(svcCtx);
              if(!svcCtx.invokeBreak()) {
            _initBaseDate(ctx, businessDate);
            }
            invokeServiceAfter(svcCtx);
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected void _initBaseDate(Context ctx, String businessDate) throws BOSException
    {    	
        return;
    }

    public void splitFentanDate(Context ctx, String businessDate) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("3852a8ca-046e-49ba-8334-05434ef19222"), new Object[]{ctx, businessDate});
            invokeServiceBefore(svcCtx);
              if(!svcCtx.invokeBreak()) {
            _splitFentanDate(ctx, businessDate);
            }
            invokeServiceAfter(svcCtx);
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected void _splitFentanDate(Context ctx, String businessDate) throws BOSException
    {    	
        return;
    }

    public String SyncCityMessage(Context ctx, String cityNumber, String cityName) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("853c8317-58d4-496c-a679-6ff03fd39f33"), new Object[]{ctx, cityNumber, cityName});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            String retValue = (String)_SyncCityMessage(ctx, cityNumber, cityName);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
            return (String)svcCtx.getMethodReturnValue();
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected String _SyncCityMessage(Context ctx, String cityNumber, String cityName) throws BOSException
    {    	
        return null;
    }

    public void syncEHRAchieve(Context ctx, String businessdate) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("3ea097ad-9a08-4381-8f8f-5c37012c35de"), new Object[]{ctx, businessdate});
            invokeServiceBefore(svcCtx);
              if(!svcCtx.invokeBreak()) {
            _syncEHRAchieve(ctx, businessdate);
            }
            invokeServiceAfter(svcCtx);
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected void _syncEHRAchieve(Context ctx, String businessdate) throws BOSException
    {    	
        return;
    }

    public void SyncCostAchieve(Context ctx, String businessdate) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("3ec7ea01-5bd9-4fdb-8d63-90e67f0e73b2"), new Object[]{ctx, businessdate});
            invokeServiceBefore(svcCtx);
              if(!svcCtx.invokeBreak()) {
            _SyncCostAchieve(ctx, businessdate);
            }
            invokeServiceAfter(svcCtx);
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected void _SyncCostAchieve(Context ctx, String businessdate) throws BOSException
    {    	
        return;
    }

}