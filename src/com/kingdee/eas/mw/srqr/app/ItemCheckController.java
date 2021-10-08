package com.kingdee.eas.mw.srqr.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.mw.srqr.ItemCheckInfo;
import com.kingdee.eas.framework.app.CoreBillBaseController;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.mw.srqr.ItemCheckCollection;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface ItemCheckController extends CoreBillBaseController
{
    public ItemCheckCollection getItemCheckCollection(Context ctx) throws BOSException, RemoteException;
    public ItemCheckCollection getItemCheckCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public ItemCheckCollection getItemCheckCollection(Context ctx, String oql) throws BOSException, RemoteException;
    public ItemCheckInfo getItemCheckInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public ItemCheckInfo getItemCheckInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public ItemCheckInfo getItemCheckInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
}