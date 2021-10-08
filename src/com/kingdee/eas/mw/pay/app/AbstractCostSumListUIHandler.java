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
public abstract class AbstractCostSumListUIHandler extends com.kingdee.eas.framework.app.CoreBillListUIHandler

{
	public void handleActionTDPrint(RequestContext request,ResponseContext response, Context context) throws Exception {
		_handleActionTDPrint(request,response,context);
	}
	protected void _handleActionTDPrint(RequestContext request,ResponseContext response, Context context) throws Exception {
	}
	public void handleActionTDPrintPreview(RequestContext request,ResponseContext response, Context context) throws Exception {
		_handleActionTDPrintPreview(request,response,context);
	}
	protected void _handleActionTDPrintPreview(RequestContext request,ResponseContext response, Context context) throws Exception {
	}
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
	public void handleActionProduceCost(RequestContext request,ResponseContext response, Context context) throws Exception {
		_handleActionProduceCost(request,response,context);
	}
	protected void _handleActionProduceCost(RequestContext request,ResponseContext response, Context context) throws Exception {
	}
}