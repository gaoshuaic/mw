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
     *同步收费项目一级分类-User defined method
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
     *同步收费项目二级分类-User defined method
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
     *同步收费项目-User defined method
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
     *同步收费项目城市-User defined method
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
     *同步门诊校验-User defined method
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
     *设置业绩汇总-User defined method
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
     *同步门诊月汇总-User defined method
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
     *生成成本数据-User defined method
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
     *生成成本(根据登录用户)-User defined method
     *@param businessdate 业务年月
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
     *初始化基础数据-User defined method
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
     *拆分分摊数据-User defined method
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
     *发送城市同步业绩信息-User defined method
     *@param cityNumber 城市编码
     *@param cityName 城市名称
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
     *同步ehr报表数据-User defined method
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
     *根据成本核对数据-User defined method
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