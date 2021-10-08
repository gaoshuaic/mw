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
import com.kingdee.eas.mw.srqr.ItemCheckEntryInfo;
import com.kingdee.bos.Context;
import com.kingdee.eas.mw.srqr.ItemCheckEntryCollection;
import com.kingdee.eas.framework.app.CoreBillEntryBaseController;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface ItemCheckEntryController extends CoreBillEntryBaseController
{
    public ItemCheckEntryInfo getItemCheckEntryInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public ItemCheckEntryInfo getItemCheckEntryInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public ItemCheckEntryInfo getItemCheckEntryInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public ItemCheckEntryCollection getItemCheckEntryCollection(Context ctx) throws BOSException, RemoteException;
    public ItemCheckEntryCollection getItemCheckEntryCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public ItemCheckEntryCollection getItemCheckEntryCollection(Context ctx, String oql) throws BOSException, RemoteException;
}