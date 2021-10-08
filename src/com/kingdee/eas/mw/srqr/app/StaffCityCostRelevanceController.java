package com.kingdee.eas.mw.srqr.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.mw.srqr.StaffCityCostRelevanceInfo;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.eas.mw.srqr.StaffCityCostRelevanceCollection;
import com.kingdee.eas.framework.app.DataBaseController;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface StaffCityCostRelevanceController extends DataBaseController
{
    public StaffCityCostRelevanceInfo getStaffCityCostRelevanceInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public StaffCityCostRelevanceInfo getStaffCityCostRelevanceInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public StaffCityCostRelevanceInfo getStaffCityCostRelevanceInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public StaffCityCostRelevanceCollection getStaffCityCostRelevanceCollection(Context ctx) throws BOSException, RemoteException;
    public StaffCityCostRelevanceCollection getStaffCityCostRelevanceCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public StaffCityCostRelevanceCollection getStaffCityCostRelevanceCollection(Context ctx, String oql) throws BOSException, RemoteException;
}