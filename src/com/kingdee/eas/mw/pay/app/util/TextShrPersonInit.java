package com.kingdee.eas.mw.pay.app.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.ModelMap;

import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.hr.emp.web.handler.EmpQuickAddNewEditHandler;
import com.kingdee.shr.base.syssetting.exception.SHRWebException;

public class TextShrPersonInit extends EmpQuickAddNewEditHandler{

	@Override
	protected IObjectPK runSave(HttpServletRequest request,
			HttpServletResponse response, CoreBaseInfo model) throws Exception {
		// TODO Auto-generated method stub
		return super.runSave(request, response, model);
	}

	@Override
	protected IObjectPK runSaveData(HttpServletRequest request,
			HttpServletResponse response, CoreBaseInfo model) throws Exception {
		// TODO Auto-generated method stub
		return super.runSaveData(request, response, model);
	}

	@Override
	protected IObjectPK runSubmit(HttpServletRequest request,
			HttpServletResponse response, CoreBaseInfo model) throws Exception {
		// TODO Auto-generated method stub
		return super.runSubmit(request, response, model);
	}

	@Override
	public String saveAction(HttpServletRequest arg0, HttpServletResponse arg1,
			ModelMap arg2) throws SHRWebException {
		// TODO Auto-generated method stub
		return super.saveAction(arg0, arg1, arg2);
	}

	
}
