package com.kingdee.eas.mw.pay.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface SyncDataFacadeController extends BizController
{
    public void SyncItemFirstClass(Context ctx, String dataBase) throws BOSException, RemoteException;
    public void SyncItemSecondClass(Context ctx, String dataBase) throws BOSException, RemoteException;
    public void SyncItem(Context ctx, String dataBase) throws BOSException, RemoteException;
    public void SyncItemCity(Context ctx, String dataBase) throws BOSException, RemoteException;
    public void SyncClinicCheck(Context ctx, String dataBase) throws BOSException, RemoteException;
    public void setAchieveSum(Context ctx, String dataBase, String cityNumber) throws BOSException, RemoteException;
    public void SyncClinicMonthSum(Context ctx, String dataBase) throws BOSException, RemoteException;
    public void putCostDetailAndAll(Context ctx, String businessdate) throws BOSException, RemoteException;
    public void createCostBuUser(Context ctx, String businessdate) throws BOSException, RemoteException;
    public void initBaseDate(Context ctx, String businessDate) throws BOSException, RemoteException;
    public void splitFentanDate(Context ctx, String businessDate) throws BOSException, RemoteException;
    public String SyncCityMessage(Context ctx, String cityNumber, String cityName) throws BOSException, RemoteException;
    public void syncEHRAchieve(Context ctx, String businessdate) throws BOSException, RemoteException;
    public void SyncCostAchieve(Context ctx, String businessdate) throws BOSException, RemoteException;
}