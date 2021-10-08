package com.kingdee.eas.scm.im.inv.app;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.mw.srqr.app.status;
import com.kingdee.eas.mw.srqr.app.util.SaleIssueSyncTool;
import com.kingdee.eas.scm.im.inv.SaleIssueBillFactory;
import com.kingdee.eas.scm.im.inv.SaleIssueBillInfo;

public class SaleIssueBillControllerBeanEx extends SaleIssueBillControllerBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8982150855269493619L;
	
	//Ã·Ωª
	@Override
	protected IObjectPK _submit(Context arg0, IObjectValue arg1)
			throws BOSException, EASBizException {
 		System.out.println("########_submit########");
 		IObjectPK pk = super._submit(arg0, arg1);
		SaleIssueBillInfo info = SaleIssueBillFactory.getLocalInstance(arg0).getSaleIssueBillInfo(pk);
		 SaleIssueSyncTool.saveHisLog(arg0,info,status.audit);
 		return pk;
	}
	
	//∑¥…Û∫À
	@Override
	protected void _unAudit(Context ctx, IObjectPK pk) throws BOSException,
			EASBizException {
 		System.out.println("########_unAudit########");
 		super._unAudit(ctx, pk);
 		SaleIssueBillInfo info = SaleIssueBillFactory.getLocalInstance(ctx).getSaleIssueBillInfo(pk);
 		SaleIssueSyncTool.saveHisLog(ctx,info,status.unaudit);
	}
	
	 
	
}
