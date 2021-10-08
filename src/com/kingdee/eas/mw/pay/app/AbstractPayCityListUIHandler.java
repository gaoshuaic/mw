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
public abstract class AbstractPayCityListUIHandler extends com.kingdee.eas.framework.app.ListUIHandler

{
	public void handleActionSyncMessage(RequestContext request,ResponseContext response, Context context) throws Exception {
		_handleActionSyncMessage(request,response,context);
	}
	protected void _handleActionSyncMessage(RequestContext request,ResponseContext response, Context context) throws Exception {
	}
	public void handleActionSyncCostAndAchieve(RequestContext request,ResponseContext response, Context context) throws Exception {
		_handleActionSyncCostAndAchieve(request,response,context);
	}
	protected void _handleActionSyncCostAndAchieve(RequestContext request,ResponseContext response, Context context) throws Exception {
	}
}