package com.kingdee.eas.mw.pay.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.eas.mw.pay.ScalingTypeInfo;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.eas.mw.pay.ScalingTypeCollection;
import com.kingdee.eas.framework.app.DataBaseController;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface ScalingTypeController extends DataBaseController
{
    public ScalingTypeInfo getScalingTypeInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public ScalingTypeInfo getScalingTypeInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public ScalingTypeInfo getScalingTypeInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public ScalingTypeCollection getScalingTypeCollection(Context ctx) throws BOSException, RemoteException;
    public ScalingTypeCollection getScalingTypeCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public ScalingTypeCollection getScalingTypeCollection(Context ctx, String oql) throws BOSException, RemoteException;
}