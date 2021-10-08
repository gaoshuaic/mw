package com.kingdee.eas.mw.pay.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.eas.mw.pay.ClinicMonthSumInfo;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.eas.mw.pay.ClinicMonthSumCollection;
import com.kingdee.eas.framework.app.DataBaseController;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface ClinicMonthSumController extends DataBaseController
{
    public ClinicMonthSumInfo getClinicMonthSumInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public ClinicMonthSumInfo getClinicMonthSumInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public ClinicMonthSumInfo getClinicMonthSumInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public ClinicMonthSumCollection getClinicMonthSumCollection(Context ctx) throws BOSException, RemoteException;
    public ClinicMonthSumCollection getClinicMonthSumCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public ClinicMonthSumCollection getClinicMonthSumCollection(Context ctx, String oql) throws BOSException, RemoteException;
}