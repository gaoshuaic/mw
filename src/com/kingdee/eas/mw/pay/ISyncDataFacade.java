package com.kingdee.eas.mw.pay;

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

public interface ISyncDataFacade extends IBizCtrl
{
    public void SyncItemFirstClass(String dataBase) throws BOSException;
    public void SyncItemSecondClass(String dataBase) throws BOSException;
    public void SyncItem(String dataBase) throws BOSException;
    public void SyncItemCity(String dataBase) throws BOSException;
    public void SyncClinicCheck(String dataBase) throws BOSException;
    public void setAchieveSum(String dataBase, String cityNumber) throws BOSException;
    public void SyncClinicMonthSum(String dataBase) throws BOSException;
    public void putCostDetailAndAll(String businessdate) throws BOSException;
    public void createCostBuUser(String businessdate) throws BOSException;
    public void initBaseDate(String businessDate) throws BOSException;
    public void splitFentanDate(String businessDate) throws BOSException;
    public String SyncCityMessage(String cityNumber, String cityName) throws BOSException;
    public void syncEHRAchieve(String businessdate) throws BOSException;
    public void SyncCostAchieve(String businessdate) throws BOSException;
}