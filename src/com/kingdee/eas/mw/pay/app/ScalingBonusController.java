package com.kingdee.eas.mw.pay.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.eas.mw.pay.ScalingBonusCollection;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.eas.mw.pay.ScalingBonusInfo;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.eas.framework.app.DataBaseController;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface ScalingBonusController extends DataBaseController
{
    public ScalingBonusInfo getScalingBonusInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public ScalingBonusInfo getScalingBonusInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public ScalingBonusInfo getScalingBonusInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public ScalingBonusCollection getScalingBonusCollection(Context ctx) throws BOSException, RemoteException;
    public ScalingBonusCollection getScalingBonusCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public ScalingBonusCollection getScalingBonusCollection(Context ctx, String oql) throws BOSException, RemoteException;
}