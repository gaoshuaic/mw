package com.kingdee.eas.mw.pay.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.mw.pay.PayShareDetailCollection;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.eas.framework.app.DataBaseController;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.mw.pay.PayShareDetailInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface PayShareDetailController extends DataBaseController
{
    public PayShareDetailInfo getPayShareDetailInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public PayShareDetailInfo getPayShareDetailInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public PayShareDetailInfo getPayShareDetailInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public PayShareDetailCollection getPayShareDetailCollection(Context ctx) throws BOSException, RemoteException;
    public PayShareDetailCollection getPayShareDetailCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public PayShareDetailCollection getPayShareDetailCollection(Context ctx, String oql) throws BOSException, RemoteException;
}