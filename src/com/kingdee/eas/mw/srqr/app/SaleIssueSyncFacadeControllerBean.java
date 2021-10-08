package com.kingdee.eas.mw.srqr.app;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.eas.mw.srqr.app.util.SaleIssueSyncTool;

public class SaleIssueSyncFacadeControllerBean extends AbstractSaleIssueSyncFacadeControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.mw.srqr.app.SaleIssueSyncFacadeControllerBean");

	@Override
	protected void _syncSaleIssueBill(Context ctx)
			throws BOSException {
  		SaleIssueSyncTool.doCostSync(ctx);
	}

	//日志同步到中间表
	@Override
	protected void _syncIssueLogToMid(Context ctx, String database)
			throws BOSException {
		SaleIssueSyncTool.doSyncIssueLogToMid(ctx, database);
	}

	
}