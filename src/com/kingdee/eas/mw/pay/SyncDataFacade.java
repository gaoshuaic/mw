package com.kingdee.eas.mw.pay;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import com.kingdee.eas.mw.pay.app.*;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;

public class SyncDataFacade extends AbstractBizCtrl implements ISyncDataFacade
{
    public SyncDataFacade()
    {
        super();
        registerInterface(ISyncDataFacade.class, this);
    }
    public SyncDataFacade(Context ctx)
    {
        super(ctx);
        registerInterface(ISyncDataFacade.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("BD6E9991");
    }
    private SyncDataFacadeController getController() throws BOSException
    {
        return (SyncDataFacadeController)getBizController();
    }
    /**
     *ͬ���շ���Ŀһ������-User defined method
     *@param dataBase dataBase
     */
    public void SyncItemFirstClass(String dataBase) throws BOSException
    {
        try {
            getController().SyncItemFirstClass(getContext(), dataBase);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ͬ���շ���Ŀ��������-User defined method
     *@param dataBase dataBase
     */
    public void SyncItemSecondClass(String dataBase) throws BOSException
    {
        try {
            getController().SyncItemSecondClass(getContext(), dataBase);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ͬ���շ���Ŀ-User defined method
     *@param dataBase dataBase
     */
    public void SyncItem(String dataBase) throws BOSException
    {
        try {
            getController().SyncItem(getContext(), dataBase);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ͬ���շ���Ŀ����-User defined method
     *@param dataBase dataBase
     */
    public void SyncItemCity(String dataBase) throws BOSException
    {
        try {
            getController().SyncItemCity(getContext(), dataBase);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ͬ������У��-User defined method
     *@param dataBase dataBase
     */
    public void SyncClinicCheck(String dataBase) throws BOSException
    {
        try {
            getController().SyncClinicCheck(getContext(), dataBase);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *����ҵ������-User defined method
     *@param dataBase dataBase
     *@param cityNumber cityNumber
     */
    public void setAchieveSum(String dataBase, String cityNumber) throws BOSException
    {
        try {
            getController().setAchieveSum(getContext(), dataBase, cityNumber);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ͬ�������»���-User defined method
     *@param dataBase dataBase
     */
    public void SyncClinicMonthSum(String dataBase) throws BOSException
    {
        try {
            getController().SyncClinicMonthSum(getContext(), dataBase);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *���ɳɱ�����-User defined method
     *@param businessdate businessdate
     */
    public void putCostDetailAndAll(String businessdate) throws BOSException
    {
        try {
            getController().putCostDetailAndAll(getContext(), businessdate);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *���ɳɱ�(���ݵ�¼�û�)-User defined method
     *@param businessdate ҵ������
     */
    public void createCostBuUser(String businessdate) throws BOSException
    {
        try {
            getController().createCostBuUser(getContext(), businessdate);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *��ʼ����������-User defined method
     *@param businessDate businessDate
     */
    public void initBaseDate(String businessDate) throws BOSException
    {
        try {
            getController().initBaseDate(getContext(), businessDate);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *��ַ�̯����-User defined method
     *@param businessDate businessDate
     */
    public void splitFentanDate(String businessDate) throws BOSException
    {
        try {
            getController().splitFentanDate(getContext(), businessDate);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *���ͳ���ͬ��ҵ����Ϣ-User defined method
     *@param cityNumber ���б���
     *@param cityName ��������
     *@return
     */
    public String SyncCityMessage(String cityNumber, String cityName) throws BOSException
    {
        try {
            return getController().SyncCityMessage(getContext(), cityNumber, cityName);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ͬ��ehr��������-User defined method
     *@param businessdate businessdate
     */
    public void syncEHRAchieve(String businessdate) throws BOSException
    {
        try {
            getController().syncEHRAchieve(getContext(), businessdate);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *���ݳɱ��˶�����-User defined method
     *@param businessdate businessdate
     */
    public void SyncCostAchieve(String businessdate) throws BOSException
    {
        try {
            getController().SyncCostAchieve(getContext(), businessdate);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}