package com.kingdee.eas.mw.srqr.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface SaleIssueSyncFacadeController extends BizController
{
    public void syncSaleIssueBill(Context ctx) throws BOSException, RemoteException;
    public void syncIssueLogToMid(Context ctx, String database) throws BOSException, RemoteException;
    public void syncSaleIssByCompany(Context ctx, String companyId) throws BOSException, RemoteException;
}