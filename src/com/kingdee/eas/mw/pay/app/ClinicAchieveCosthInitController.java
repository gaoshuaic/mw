package com.kingdee.eas.mw.pay.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.mw.pay.ClinicAchieveCosthInitInfo;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.eas.mw.pay.ClinicAchieveCosthInitCollection;
import com.kingdee.eas.framework.app.DataBaseController;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface ClinicAchieveCosthInitController extends DataBaseController
{
    public ClinicAchieveCosthInitInfo getClinicAchieveCosthInitInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public ClinicAchieveCosthInitInfo getClinicAchieveCosthInitInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public ClinicAchieveCosthInitInfo getClinicAchieveCosthInitInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public ClinicAchieveCosthInitCollection getClinicAchieveCosthInitCollection(Context ctx) throws BOSException, RemoteException;
    public ClinicAchieveCosthInitCollection getClinicAchieveCosthInitCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public ClinicAchieveCosthInitCollection getClinicAchieveCosthInitCollection(Context ctx, String oql) throws BOSException, RemoteException;
}