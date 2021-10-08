package com.kingdee.eas.mw.pay.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.BOSException;
import com.kingdee.eas.mw.pay.CostSumCollection;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.eas.mw.pay.CostSumInfo;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.app.CoreBillBaseController;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface CostSumController extends CoreBillBaseController
{
    public CostSumCollection getCostSumCollection(Context ctx) throws BOSException, RemoteException;
    public CostSumCollection getCostSumCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public CostSumCollection getCostSumCollection(Context ctx, String oql) throws BOSException, RemoteException;
    public CostSumInfo getCostSumInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public CostSumInfo getCostSumInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public CostSumInfo getCostSumInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public String auditCost(Context ctx, CostSumInfo model) throws BOSException, RemoteException;
    public String unAuditCost(Context ctx, CostSumInfo model) throws BOSException, RemoteException;
    public void setAllCost(Context ctx, String type, String id) throws BOSException, RemoteException;
    public void produceCost(Context ctx, CostSumInfo model) throws BOSException, RemoteException;
}