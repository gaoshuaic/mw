package com.kingdee.eas.mw.srqr.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.BOSException;
import com.kingdee.eas.mw.srqr.ClinicItemInfo;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.app.CoreBillBaseController;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.mw.srqr.ClinicItemCollection;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface ClinicItemController extends CoreBillBaseController
{
    public ClinicItemCollection getClinicItemCollection(Context ctx) throws BOSException, RemoteException;
    public ClinicItemCollection getClinicItemCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public ClinicItemCollection getClinicItemCollection(Context ctx, String oql) throws BOSException, RemoteException;
    public ClinicItemInfo getClinicItemInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public ClinicItemInfo getClinicItemInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public ClinicItemInfo getClinicItemInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
}