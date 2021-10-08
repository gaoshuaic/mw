package com.kingdee.eas.mw.pay.app.util;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.eas.base.core.fm.ContextHelperFactory;
import com.kingdee.eas.basedata.framework.app.ParallelSqlExecutor;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.scm.im.inv.SaleIssueBillCollection;
import com.kingdee.eas.scm.im.inv.SaleIssueBillInfo;

public class SaleIssueUtil {
	 private static void AssignCompany(Context ctx , SaleIssueBillCollection colls){ 
		  ExecutorService pool = Executors.newFixedThreadPool(6);
	      ParallelSqlExecutor pe = new ParallelSqlExecutor(pool); 
	      ArrayList<String> companyIds ;// =getNoAssignCompanyIDS(ctx,ctrlId,supplierId,"purchase");
		  String userId = ContextHelperFactory.getLocalInstance(ctx).getCurrentUser().getId().toString(); 
	     if(colls!=null && colls.size()>0){
	    	 Iterator<SaleIssueBillInfo> it = colls.iterator();
	    	 while(it.hasNext()){
	    		StringBuffer sbr  = new StringBuffer("insert into CT_PAY_CostGZ (mznumber,mzname,empnumber,empname,zjCost,gdCost,yxcost,xfCost,knCost,eyCost,qiCost,amount,impdate)");
		    //	sbr.append("values(newbosid('9920F4D3'),'"+userId+"',sysdate,'"+userId+"',sysdate,'"+ctrlId+"','"+cid+"',0 ,'' ,1 ,");
		    //	sbr.append("'"+supplierId+"','"+supplierId+"',null,'"+supplierId+"',0 ,0 ,0 ,'','' , '' , '' , '' , '' , '' ,0 ,0 ,1 ,1 ,1 ,0 ,0 ,0)"); 
		    	pe.getSqlList().add(sbr);
	    	 }
	     }  
	    if(pe.getSqlList().size()>0)
			try {
				pe.executeUpdate(ctx); 
				pool.shutdown(); 
			} catch (EASBizException e) { 
				e.printStackTrace();
				pool.shutdown(); 
			} catch (BOSException e) { 
				e.printStackTrace();
				pool.shutdown(); 
			}	
		     pool.shutdown(); 
	  } 
	  

}
