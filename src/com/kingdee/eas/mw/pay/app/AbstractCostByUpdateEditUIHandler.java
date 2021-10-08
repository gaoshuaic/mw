/**
 * output package name
 */
package com.kingdee.eas.mw.pay.app;

import com.kingdee.bos.Context;
import com.kingdee.eas.framework.batchHandler.RequestContext;
import com.kingdee.eas.framework.batchHandler.ResponseContext;


/**
 * output class name
 */
public abstract class AbstractCostByUpdateEditUIHandler extends com.kingdee.eas.framework.app.CoreBillEditUIHandler

{
	public void handleActionAuditCost(RequestContext request,ResponseContext response, Context context) throws Exception {
		_handleActionAuditCost(request,response,context);
	}
	protected void _handleActionAuditCost(RequestContext request,ResponseContext response, Context context) throws Exception {
	}
	public void handleActionUnAuditCost(RequestContext request,ResponseContext response, Context context) throws Exception {
		_handleActionUnAuditCost(request,response,context);
	}
	protected void _handleActionUnAuditCost(RequestContext request,ResponseContext response, Context context) throws Exception {
	}
}