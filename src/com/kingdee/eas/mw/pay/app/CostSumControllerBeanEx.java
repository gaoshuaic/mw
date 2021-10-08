package com.kingdee.eas.mw.pay.app;

import java.math.BigDecimal;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.ISQLExecutor;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.bos.util.BOSUuid;
import com.kingdee.eas.base.core.fm.ContextHelperFactory;
import com.kingdee.eas.basedata.framework.app.ParallelSqlExecutor;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.mw.pay.CostByUpdateFactory;
import com.kingdee.eas.mw.pay.CostByUpdateInfo;
import com.kingdee.eas.mw.pay.CostSumFactory;
import com.kingdee.eas.mw.pay.CostSumInfo;
import com.kingdee.eas.mw.pay.ICostSum;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.UuidException;

public class CostSumControllerBeanEx extends com.kingdee.eas.mw.pay.app.CostSumControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.mw.pay.app.CostSumControllerBeanEx");
    protected String _auditCost(Context ctx, IObjectValue model)throws BOSException
    {
	     return super._auditCost(ctx, model);
    }
    protected String _unAuditCost(Context ctx, IObjectValue model)throws BOSException
    {
	     return super._unAuditCost(ctx, model);
    }
    
	@Override
	public String auditCost(Context ctx, CostSumInfo model) throws BOSException {
		// TODO Auto-generated method stub
		//super.auditCost(ctx, model);
		// TODO Auto-generated method stub
		String returnMsg = "";
		String ids = model.getDescription();
		String[] idArr = ids.split(",");
		for(int i=0;i<idArr.length;i++){
			String id = idArr[i];
			try {
				CostSumInfo info = CostSumFactory.getLocalInstance(ctx).getCostSumInfo(new ObjectUuidPK(BOSUuid.read(id)));
				if(info.getStatus() == null || info.getStatus().getValue().toString().equals("") ||info.getStatus().getValue().toString().equals("wsh")){
					info.setStatus(UpdateCostStatus.ysh);
					info.setDescription(null);
					CostSumFactory.getLocalInstance(ctx).save(info);
				}else if(info.getStatus().getValue().toString().equals("yqr")){
					returnMsg =  returnMsg + info.getDoctorName()+";";
				}
				
			} catch (EASBizException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (UuidException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return returnMsg;
	}
	@Override
	public String unAuditCost(Context ctx, CostSumInfo model) throws BOSException {
		// TODO Auto-generated method stub
		//super.unAuditCost(ctx, model);
		String returnMsg = "";
		String ids = model.getDescription();
		String[] idArr = ids.split(",");
		for(int i=0;i<idArr.length;i++){
			String id = idArr[i];
			try {
				CostSumInfo info = CostSumFactory.getLocalInstance(ctx).getCostSumInfo(new ObjectUuidPK(BOSUuid.read(id)));
				if(info.getStatus() == null || info.getStatus().getValue().toString().equals("") ||info.getStatus().getValue().toString().equals("ysh")){
					info.setStatus(UpdateCostStatus.wsh);
					CostSumFactory.getLocalInstance(ctx).save(info);
				}else if(info.getStatus().getValue().toString().equals("yqr")){
					returnMsg =  returnMsg + info.getDoctorName()+";";
				} 
			} catch (EASBizException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (UuidException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return returnMsg;
	}
	@Override
	protected void _setAllCost(Context ctx, String type, String id)
			throws BOSException {
		// TODO Auto-generated method stub
		//super._setAllCost(ctx, type, id);
		try {
			if(type.equals("1")){//成本汇总的值
				CostSumInfo costSumInfo = CostSumFactory.getLocalInstance(ctx).getCostSumInfo(" where id ='"+id+"'");
				String sql = "select FDestObjectID from T_BOT_Relation where fsrcobjectid='" + id + "'"; 
				
	    		IRowSet rowSet = DbUtil.executeQuery(ctx, sql); //获取结果集
	    		if((rowSet.size() > 0)){
	    			while (rowSet.next()) {
	    				String objid = rowSet.getString("FDESTOBJECTID");
	    				CostByUpdateInfo costByUpdateInfo = CostByUpdateFactory.getLocalInstance(ctx).getCostByUpdateInfo(" where id ='"+objid+"'");
	    			
	    				
	    				if(costSumInfo.getXhzz()==null)  costSumInfo.setXhzz(BigDecimal.ZERO);
	    				if(costSumInfo.getXhyxjz()==null)  costSumInfo.setXhyxjz(BigDecimal.ZERO);
	    				if(costSumInfo.getXhcgjz()==null)  costSumInfo.setXhcgjz(BigDecimal.ZERO);
	    				if(costSumInfo.getXhknw()==null)  costSumInfo.setXhknw(BigDecimal.ZERO);
	    				if(costSumInfo.getXhxf()==null)  costSumInfo.setXhxf(BigDecimal.ZERO);
	    				if(costSumInfo.getXhey()==null)  costSumInfo.setXhey(BigDecimal.ZERO);
	    				if(costSumInfo.getXhyz()==null)  costSumInfo.setXhyz(BigDecimal.ZERO);
	    				if(costSumInfo.getXhmb()==null)  costSumInfo.setXhmb(BigDecimal.ZERO);
	    				if(costSumInfo.getJgfzz()==null)  costSumInfo.setJgfzz(BigDecimal.ZERO);
	    				if(costSumInfo.getJgfyxjz()==null)  costSumInfo.setJgfyxjz(BigDecimal.ZERO);
	    				if(costSumInfo.getJgfcgjz()==null)  costSumInfo.setJgfcgjz(BigDecimal.ZERO);
	    				if(costSumInfo.getJgfknw()==null)  costSumInfo.setJgfknw(BigDecimal.ZERO);
	    				if(costSumInfo.getJgfxf()==null)  costSumInfo.setJgfxf(BigDecimal.ZERO);
	    				if(costSumInfo.getJgfey()==null)  costSumInfo.setJgfey(BigDecimal.ZERO);
	    				if(costSumInfo.getJgfyz()==null)  costSumInfo.setJgfyz(BigDecimal.ZERO);
	    				if(costSumInfo.getJgfmb()==null)  costSumInfo.setJgfmb(BigDecimal.ZERO); 
	    				
	    				costSumInfo.setUpxhzz(costByUpdateInfo.getXhzz()==null?BigDecimal.ZERO:costByUpdateInfo.getXhzz());
	    				costSumInfo.setUpxhyxjz(costByUpdateInfo.getXhyxjz()==null?BigDecimal.ZERO:costByUpdateInfo.getXhyxjz());
	    				costSumInfo.setUpxhcgjz(costByUpdateInfo.getXhcgjz()==null?BigDecimal.ZERO:costByUpdateInfo.getXhcgjz());
	    				costSumInfo.setUpxhknw(costByUpdateInfo.getXhknw()==null?BigDecimal.ZERO:costByUpdateInfo.getXhknw());
	    				costSumInfo.setUpxhxf(costByUpdateInfo.getXhxf()==null?BigDecimal.ZERO:costByUpdateInfo.getXhxf());
	    				costSumInfo.setUpxhey(costByUpdateInfo.getXhey()==null?BigDecimal.ZERO:costByUpdateInfo.getXhey());
	    				costSumInfo.setUpxhyz(costByUpdateInfo.getXhyz()==null?BigDecimal.ZERO:costByUpdateInfo.getXhyz());
	    				costSumInfo.setUpxhmb(costByUpdateInfo.getXhmb()==null?BigDecimal.ZERO:costByUpdateInfo.getXhmb());
	    				 
	    				costSumInfo.setUpjgfzz(costByUpdateInfo.getJgfzz()==null?BigDecimal.ZERO:costByUpdateInfo.getJgfzz());
	    				costSumInfo.setUpjgfyxjz(costByUpdateInfo.getJgfyxjz()==null?BigDecimal.ZERO:costByUpdateInfo.getJgfyxjz());
	    				costSumInfo.setUpjgfcgjz(costByUpdateInfo.getJgfcgjz()==null?BigDecimal.ZERO:costByUpdateInfo.getJgfcgjz());
	    				costSumInfo.setUpjgfknw(costByUpdateInfo.getJgfknw()==null?BigDecimal.ZERO:costByUpdateInfo.getJgfknw());
	    				costSumInfo.setUpjgfxf(costByUpdateInfo.getJgfxf()==null?BigDecimal.ZERO:costByUpdateInfo.getJgfxf());
	    				costSumInfo.setUpjgfey(costByUpdateInfo.getJgfey()==null?BigDecimal.ZERO:costByUpdateInfo.getJgfey());
	    				costSumInfo.setUpjgfyz(costByUpdateInfo.getJgfyz()==null?BigDecimal.ZERO:costByUpdateInfo.getJgfyz());
	    				costSumInfo.setUpjgfmb(costByUpdateInfo.getJgfmb()==null?BigDecimal.ZERO:costByUpdateInfo.getJgfmb());
	    				
	    				 
	    				costSumInfo.setAllxhzz(costSumInfo.getXhzz().add(costSumInfo.getUpxhzz()));
	    				costSumInfo.setAllxhyxjz(costSumInfo.getXhyxjz().add(costSumInfo.getUpxhyxjz()));
	    				costSumInfo.setAllxhcgjz(costSumInfo.getXhcgjz().add(costSumInfo.getUpxhcgjz()));
	    				costSumInfo.setAllxhknw(costSumInfo.getXhknw().add(costSumInfo.getUpxhknw()));
	    				costSumInfo.setAllxhxf(costSumInfo.getXhxf().add(costSumInfo.getUpxhxf()));
	    				costSumInfo.setAllxhey(costSumInfo.getXhey().add(costSumInfo.getUpxhey()));
	    				costSumInfo.setAllxhyz(costSumInfo.getXhyz().add(costSumInfo.getUpxhyz()));
	    				costSumInfo.setAllxhmb(costSumInfo.getXhmb().add(costSumInfo.getUpxhmb()));
	    				 
	    				costSumInfo.setAlljgfzz(costSumInfo.getJgfzz().add(costSumInfo.getUpjgfzz()));
	    				costSumInfo.setAlljgfyxjz(costSumInfo.getJgfyxjz().add(costSumInfo.getUpjgfyxjz()));
	    				costSumInfo.setAlljgfgdjz(costSumInfo.getJgfcgjz().add(costSumInfo.getUpjgfcgjz()));
	    				costSumInfo.setAlljgfknw(costSumInfo.getJgfknw().add(costSumInfo.getUpjgfknw()));
	    				costSumInfo.setAlljgfxf(costSumInfo.getJgfxf().add(costSumInfo.getUpjgfxf()));
	    				costSumInfo.setAlljgfey(costSumInfo.getJgfey().add(costSumInfo.getUpjgfey()));
	    				costSumInfo.setAlljgfyz(costSumInfo.getJgfyz().add(costSumInfo.getUpjgfyz()));
	    				costSumInfo.setAlljgfmb(costSumInfo.getJgfmb().add(costSumInfo.getUpjgfmb()));
	    			}
	    		}else{
	    			costSumInfo.setUpxhzz(BigDecimal.ZERO);
    				costSumInfo.setUpxhyxjz(BigDecimal.ZERO);
    				costSumInfo.setUpxhcgjz(BigDecimal.ZERO);
    				costSumInfo.setUpxhknw(BigDecimal.ZERO);
    				costSumInfo.setUpxhxf(BigDecimal.ZERO);
    				costSumInfo.setUpxhey(BigDecimal.ZERO);
    				costSumInfo.setUpxhyz(BigDecimal.ZERO);
    				costSumInfo.setUpxhmb(BigDecimal.ZERO);
    				 
    				costSumInfo.setUpjgfzz(BigDecimal.ZERO);
    				costSumInfo.setUpjgfyxjz(BigDecimal.ZERO);
    				costSumInfo.setUpjgfcgjz(BigDecimal.ZERO);
    				costSumInfo.setUpjgfknw(BigDecimal.ZERO);
    				costSumInfo.setUpjgfxf(BigDecimal.ZERO);
    				costSumInfo.setUpjgfey(BigDecimal.ZERO);
    				costSumInfo.setUpjgfyz(BigDecimal.ZERO);
    				costSumInfo.setUpjgfmb(BigDecimal.ZERO);
    				
    				
    				costSumInfo.setAllxhzz(costSumInfo.getXhzz());
    				costSumInfo.setAllxhyxjz(costSumInfo.getXhyxjz());
    				costSumInfo.setAllxhcgjz(costSumInfo.getXhcgjz());
    				costSumInfo.setAllxhknw(costSumInfo.getXhknw());
    				costSumInfo.setAllxhxf(costSumInfo.getXhxf());
    				costSumInfo.setAllxhey(costSumInfo.getXhey());
    				costSumInfo.setAllxhyz(costSumInfo.getXhyz());
    				costSumInfo.setAllxhmb(costSumInfo.getXhmb());
    				 
    				costSumInfo.setAlljgfzz(costSumInfo.getJgfzz());
    				costSumInfo.setAlljgfyxjz(costSumInfo.getJgfyxjz());
    				costSumInfo.setAlljgfgdjz(costSumInfo.getJgfcgjz());
    				costSumInfo.setAlljgfknw(costSumInfo.getJgfknw());
    				costSumInfo.setAlljgfxf(costSumInfo.getJgfxf());
    				costSumInfo.setAlljgfey(costSumInfo.getJgfey());
    				costSumInfo.setAlljgfyz(costSumInfo.getJgfyz());
    				costSumInfo.setAlljgfmb(costSumInfo.getJgfmb());
	    			 
	    		}  
	    		
	    		CostSumFactory.getLocalInstance(ctx).save(costSumInfo);
			}else{//成本调整
				CostByUpdateInfo costByUpdateInfo = CostByUpdateFactory.getLocalInstance(ctx).getCostByUpdateInfo(" where id ='"+id+"'"); 
				String sql = "select fsrcobjectid from T_BOT_Relation where FDestObjectID ='" + id + "'"; 
	    		 
				
	    		IRowSet rowSet = DbUtil.executeQuery(ctx, sql); //获取结果集
	    		if((rowSet.size() > 0)){
	    			while (rowSet.next()) {
	    				String objid = rowSet.getString("FSRCOBJECTID");
	    				CostSumInfo costSumInfo = CostSumFactory.getLocalInstance(ctx).getCostSumInfo(" where id ='"+objid+"'");
	    				
	    				if(costSumInfo.getXhzz()==null)  costSumInfo.setXhzz(BigDecimal.ZERO);
	    				if(costSumInfo.getXhyxjz()==null)  costSumInfo.setXhyxjz(BigDecimal.ZERO);
	    				if(costSumInfo.getXhcgjz()==null)  costSumInfo.setXhcgjz(BigDecimal.ZERO);
	    				if(costSumInfo.getXhknw()==null)  costSumInfo.setXhknw(BigDecimal.ZERO);
	    				if(costSumInfo.getXhxf()==null)  costSumInfo.setXhxf(BigDecimal.ZERO);
	    				if(costSumInfo.getXhey()==null)  costSumInfo.setXhey(BigDecimal.ZERO);
	    				if(costSumInfo.getXhyz()==null)  costSumInfo.setXhyz(BigDecimal.ZERO);
	    				if(costSumInfo.getXhmb()==null)  costSumInfo.setXhmb(BigDecimal.ZERO);
	    				if(costSumInfo.getJgfzz()==null)  costSumInfo.setJgfzz(BigDecimal.ZERO);
	    				if(costSumInfo.getJgfyxjz()==null)  costSumInfo.setJgfyxjz(BigDecimal.ZERO);
	    				if(costSumInfo.getJgfcgjz()==null)  costSumInfo.setJgfcgjz(BigDecimal.ZERO);
	    				if(costSumInfo.getJgfknw()==null)  costSumInfo.setJgfknw(BigDecimal.ZERO);
	    				if(costSumInfo.getJgfxf()==null)  costSumInfo.setJgfxf(BigDecimal.ZERO);
	    				if(costSumInfo.getJgfey()==null)  costSumInfo.setJgfey(BigDecimal.ZERO);
	    				if(costSumInfo.getJgfyz()==null)  costSumInfo.setJgfyz(BigDecimal.ZERO);
	    				if(costSumInfo.getJgfmb()==null)  costSumInfo.setJgfmb(BigDecimal.ZERO); 
	    				
	    				/*costSumInfo.setUpxhzz(costByUpdateInfo.getXhzz());
	    				costSumInfo.setUpxhyxjz(costByUpdateInfo.getXhyxjz());
	    				costSumInfo.setUpxhcgjz(costByUpdateInfo.getXhcgjz());
	    				costSumInfo.setUpxhknw(costByUpdateInfo.getXhknw());
	    				costSumInfo.setUpxhxf(costByUpdateInfo.getXhxf());
	    				costSumInfo.setUpxhey(costByUpdateInfo.getXhey());
	    				costSumInfo.setUpxhyz(costByUpdateInfo.getXhyz());
	    				costSumInfo.setUpxhmb(costByUpdateInfo.getXhmb());
	    				 
	    				costSumInfo.setUpjgfzz(costByUpdateInfo.getJgfzz());
	    				costSumInfo.setUpjgfyxjz(costByUpdateInfo.getJgfyxjz());
	    				costSumInfo.setUpjgfcgjz(costByUpdateInfo.getJgfcgjz());
	    				costSumInfo.setUpjgfknw(costByUpdateInfo.getJgfknw());
	    				costSumInfo.setUpjgfxf(costByUpdateInfo.getJgfxf());
	    				costSumInfo.setUpjgfey(costByUpdateInfo.getJgfey());
	    				costSumInfo.setUpjgfyz(costByUpdateInfo.getJgfyz());
	    				costSumInfo.setUpjgfmb(costByUpdateInfo.getJgfmb());*/
	    				
	    				costSumInfo.setUpxhzz(costByUpdateInfo.getXhzz()==null?BigDecimal.ZERO:costByUpdateInfo.getXhzz());
	    				costSumInfo.setUpxhyxjz(costByUpdateInfo.getXhyxjz()==null?BigDecimal.ZERO:costByUpdateInfo.getXhyxjz());
	    				costSumInfo.setUpxhcgjz(costByUpdateInfo.getXhcgjz()==null?BigDecimal.ZERO:costByUpdateInfo.getXhcgjz());
	    				costSumInfo.setUpxhknw(costByUpdateInfo.getXhknw()==null?BigDecimal.ZERO:costByUpdateInfo.getXhknw());
	    				costSumInfo.setUpxhxf(costByUpdateInfo.getXhxf()==null?BigDecimal.ZERO:costByUpdateInfo.getXhxf());
	    				costSumInfo.setUpxhey(costByUpdateInfo.getXhey()==null?BigDecimal.ZERO:costByUpdateInfo.getXhey());
	    				costSumInfo.setUpxhyz(costByUpdateInfo.getXhyz()==null?BigDecimal.ZERO:costByUpdateInfo.getXhyz());
	    				costSumInfo.setUpxhmb(costByUpdateInfo.getXhmb()==null?BigDecimal.ZERO:costByUpdateInfo.getXhmb());
	    				 
	    				costSumInfo.setUpjgfzz(costByUpdateInfo.getJgfzz()==null?BigDecimal.ZERO:costByUpdateInfo.getJgfzz());
	    				costSumInfo.setUpjgfyxjz(costByUpdateInfo.getJgfyxjz()==null?BigDecimal.ZERO:costByUpdateInfo.getJgfyxjz());
	    				costSumInfo.setUpjgfcgjz(costByUpdateInfo.getJgfcgjz()==null?BigDecimal.ZERO:costByUpdateInfo.getJgfcgjz());
	    				costSumInfo.setUpjgfknw(costByUpdateInfo.getJgfknw()==null?BigDecimal.ZERO:costByUpdateInfo.getJgfknw());
	    				costSumInfo.setUpjgfxf(costByUpdateInfo.getJgfxf()==null?BigDecimal.ZERO:costByUpdateInfo.getJgfxf());
	    				costSumInfo.setUpjgfey(costByUpdateInfo.getJgfey()==null?BigDecimal.ZERO:costByUpdateInfo.getJgfey());
	    				costSumInfo.setUpjgfyz(costByUpdateInfo.getJgfyz()==null?BigDecimal.ZERO:costByUpdateInfo.getJgfyz());
	    				costSumInfo.setUpjgfmb(costByUpdateInfo.getJgfmb()==null?BigDecimal.ZERO:costByUpdateInfo.getJgfmb());
	    				
	    				
	    				
	    				
	    				costSumInfo.setAllxhzz(costSumInfo.getXhzz().add(costSumInfo.getUpxhzz()));
	    				costSumInfo.setAllxhyxjz(costSumInfo.getXhyxjz().add(costSumInfo.getUpxhyxjz()));
	    				costSumInfo.setAllxhcgjz(costSumInfo.getXhcgjz().add(costSumInfo.getUpxhcgjz()));
	    				costSumInfo.setAllxhknw(costSumInfo.getXhknw().add(costSumInfo.getUpxhknw()));
	    				costSumInfo.setAllxhxf(costSumInfo.getXhxf().add(costSumInfo.getUpxhxf()));
	    				costSumInfo.setAllxhey(costSumInfo.getXhey().add(costSumInfo.getUpxhey()));
	    				costSumInfo.setAllxhyz(costSumInfo.getXhyz().add(costSumInfo.getUpxhyz()));
	    				costSumInfo.setAllxhmb(costSumInfo.getXhmb().add(costSumInfo.getUpxhmb()));
	    				 
	    				costSumInfo.setAlljgfzz(costSumInfo.getJgfzz().add(costSumInfo.getUpjgfzz()));
	    				costSumInfo.setAlljgfyxjz(costSumInfo.getJgfyxjz().add(costSumInfo.getUpjgfyxjz()));
	    				costSumInfo.setAlljgfgdjz(costSumInfo.getJgfcgjz().add(costSumInfo.getUpjgfcgjz()));
	    				costSumInfo.setAlljgfknw(costSumInfo.getJgfknw().add(costSumInfo.getUpjgfknw()));
	    				costSumInfo.setAlljgfxf(costSumInfo.getJgfxf().add(costSumInfo.getUpjgfxf()));
	    				costSumInfo.setAlljgfey(costSumInfo.getJgfey().add(costSumInfo.getUpjgfey()));
	    				costSumInfo.setAlljgfyz(costSumInfo.getJgfyz().add(costSumInfo.getUpjgfyz()));
	    				costSumInfo.setAlljgfmb(costSumInfo.getJgfmb().add(costSumInfo.getUpjgfmb()));
	    				
	    				CostSumFactory.getLocalInstance(ctx).save(costSumInfo);
	    			}
	    		}else{//新增单据 没有上游的成本汇总数据
	    			String sqlMaping = "select fid from T_BOT_Mapping where  FSRCENTITYNAME ='5DA507CC' and FDESTENTITYNAME ='7A8DD31F' and FISTEMPSAVE  = 1 "; 
	    		 
		    		String mapping = "";
		    		IRowSet rowMap =  DbUtil.executeQuery(ctx, sqlMaping); //获取结果集
		    		if((rowMap.size() > 0)){
		    			while (rowMap.next()) {
		    				mapping = rowMap.getString("FID");
		    			}
		    		}
	    			CostSumInfo costSumInfo = new CostSumInfo();
	    			
	    			if(costByUpdateInfo.isIszidai()== true ){
	    				costSumInfo.setIszidai(true);
	    			}
	    			costSumInfo.setCityNumber(costByUpdateInfo.getCityNumber());
	    			costSumInfo.setCityName(costByUpdateInfo.getCityName());
	    			
	    			costSumInfo.setClinicNumber(costByUpdateInfo.getClinicNumber());
	    			costSumInfo.setClinicName(costByUpdateInfo.getClinicName());
	    			
	    			costSumInfo.setDoctorNumber(costByUpdateInfo.getDoctorNumber());
	    			costSumInfo.setDoctorName(costByUpdateInfo.getDoctorName());
	    			
	    			costSumInfo.setPeriod(costByUpdateInfo.getPeriod());
	    			costSumInfo.setUpxhzz(costByUpdateInfo.getXhzz()==null?BigDecimal.ZERO:costByUpdateInfo.getXhzz());
    				costSumInfo.setUpxhyxjz(costByUpdateInfo.getXhyxjz()==null?BigDecimal.ZERO:costByUpdateInfo.getXhyxjz());
    				costSumInfo.setUpxhcgjz(costByUpdateInfo.getXhcgjz()==null?BigDecimal.ZERO:costByUpdateInfo.getXhcgjz());
    				costSumInfo.setUpxhknw(costByUpdateInfo.getXhknw()==null?BigDecimal.ZERO:costByUpdateInfo.getXhknw());
    				costSumInfo.setUpxhxf(costByUpdateInfo.getXhxf()==null?BigDecimal.ZERO:costByUpdateInfo.getXhxf());
    				costSumInfo.setUpxhey(costByUpdateInfo.getXhey()==null?BigDecimal.ZERO:costByUpdateInfo.getXhey());
    				costSumInfo.setUpxhyz(costByUpdateInfo.getXhyz()==null?BigDecimal.ZERO:costByUpdateInfo.getXhyz());
    				costSumInfo.setUpxhmb(costByUpdateInfo.getXhmb()==null?BigDecimal.ZERO:costByUpdateInfo.getXhmb());
    				 
    				costSumInfo.setUpjgfzz(costByUpdateInfo.getJgfzz()==null?BigDecimal.ZERO:costByUpdateInfo.getJgfzz());
    				costSumInfo.setUpjgfyxjz(costByUpdateInfo.getJgfyxjz()==null?BigDecimal.ZERO:costByUpdateInfo.getJgfyxjz());
    				costSumInfo.setUpjgfcgjz(costByUpdateInfo.getJgfcgjz()==null?BigDecimal.ZERO:costByUpdateInfo.getJgfcgjz());
    				costSumInfo.setUpjgfknw(costByUpdateInfo.getJgfknw()==null?BigDecimal.ZERO:costByUpdateInfo.getJgfknw());
    				costSumInfo.setUpjgfxf(costByUpdateInfo.getJgfxf()==null?BigDecimal.ZERO:costByUpdateInfo.getJgfxf());
    				costSumInfo.setUpjgfey(costByUpdateInfo.getJgfey()==null?BigDecimal.ZERO:costByUpdateInfo.getJgfey());
    				costSumInfo.setUpjgfyz(costByUpdateInfo.getJgfyz()==null?BigDecimal.ZERO:costByUpdateInfo.getJgfyz());
    				costSumInfo.setUpjgfmb(costByUpdateInfo.getJgfmb()==null?BigDecimal.ZERO:costByUpdateInfo.getJgfmb());
    				
    				costSumInfo.setAllxhzz(costByUpdateInfo.getAllxhzz()==null?BigDecimal.ZERO:costByUpdateInfo.getAllxhzz());
    				costSumInfo.setAllxhyxjz(costByUpdateInfo.getAllxhyxjz()==null?BigDecimal.ZERO:costByUpdateInfo.getAllxhyxjz());
    				costSumInfo.setAllxhcgjz(costByUpdateInfo.getAllxhcgjz()==null?BigDecimal.ZERO:costByUpdateInfo.getAllxhcgjz());
    				costSumInfo.setAllxhknw(costByUpdateInfo.getAllzhknw()==null?BigDecimal.ZERO:costByUpdateInfo.getAllzhknw());
    				costSumInfo.setAllxhxf(costByUpdateInfo.getAllxhxf()==null?BigDecimal.ZERO:costByUpdateInfo.getAllxhxf());
    				costSumInfo.setAllxhey(costByUpdateInfo.getAllxhey()==null?BigDecimal.ZERO:costByUpdateInfo.getAllxhey());
    				costSumInfo.setAllxhyz(costByUpdateInfo.getAllxhyz()==null?BigDecimal.ZERO:costByUpdateInfo.getAllxhyz());
    				costSumInfo.setAllxhmb(costByUpdateInfo.getAllxhmb()==null?BigDecimal.ZERO:costByUpdateInfo.getAllxhmb());
    				 
    				costSumInfo.setAlljgfzz(costByUpdateInfo.getAlljgfzz()==null?BigDecimal.ZERO:costByUpdateInfo.getAlljgfzz());
    				costSumInfo.setAlljgfyxjz(costByUpdateInfo.getAlljgfyxjz()==null?BigDecimal.ZERO:costByUpdateInfo.getAlljgfyxjz());
    				costSumInfo.setAlljgfgdjz(costByUpdateInfo.getAlljgfcgjz()==null?BigDecimal.ZERO:costByUpdateInfo.getAlljgfcgjz());
    				costSumInfo.setAlljgfknw(costByUpdateInfo.getAlljgfknw()==null?BigDecimal.ZERO:costByUpdateInfo.getAlljgfknw());
    				costSumInfo.setAlljgfxf(costByUpdateInfo.getAlljgfxf()==null?BigDecimal.ZERO:costByUpdateInfo.getAlljgfxf());
    				costSumInfo.setAlljgfey(costByUpdateInfo.getAlljgfey()==null?BigDecimal.ZERO:costByUpdateInfo.getAlljgfey());
    				costSumInfo.setAlljgfyz(costByUpdateInfo.getAlljgfyz()==null?BigDecimal.ZERO:costByUpdateInfo.getAlljgfyz());
    				costSumInfo.setAlljgfmb(costByUpdateInfo.getAlljgdmb()==null?BigDecimal.ZERO:costByUpdateInfo.getAlljgdmb());
    				
	    			costSumInfo.setAmount( costSumInfo.getAllxhzz().add(costSumInfo.getAllxhyxjz()).add(costSumInfo.getAllxhcgjz()).add(costSumInfo.getAllxhknw()).add(costSumInfo.getAllxhxf())
	    					 .add(costSumInfo.getAllxhey()).add(costSumInfo.getAllxhyz()).add(costSumInfo.getAllxhmb()).add(costSumInfo.getAlljgfzz()).add(costSumInfo.getAlljgfyxjz())
	    					 .add(costSumInfo.getAlljgfgdjz()).add(costSumInfo.getAlljgfknw()).add(costSumInfo.getAlljgfxf()).add(costSumInfo.getAlljgfey()).add(costSumInfo.getAlljgfyz()).add(costSumInfo.getAlljgfmb()));
	    			costSumInfo.setStatus(UpdateCostStatus.ysh);
	    			
	    			
	    			costSumInfo.setXhzz(BigDecimal.ZERO);
    				costSumInfo.setXhyxjz(BigDecimal.ZERO);
    				costSumInfo.setXhcgjz(BigDecimal.ZERO);
    				costSumInfo.setXhknw(BigDecimal.ZERO);
    				costSumInfo.setXhxf(BigDecimal.ZERO);
    				costSumInfo.setXhey(BigDecimal.ZERO);
    				costSumInfo.setXhyz(BigDecimal.ZERO);
    				costSumInfo.setXhmb(BigDecimal.ZERO);
    				 
    				costSumInfo.setJgfzz(BigDecimal.ZERO);
    				costSumInfo.setJgfyxjz(BigDecimal.ZERO);
    				costSumInfo.setJgfcgjz(BigDecimal.ZERO);
    				costSumInfo.setJgfknw(BigDecimal.ZERO);
    				costSumInfo.setJgfxf(BigDecimal.ZERO);
    				costSumInfo.setJgfey(BigDecimal.ZERO);
    				costSumInfo.setJgfyz(BigDecimal.ZERO);
    				costSumInfo.setJgfmb(BigDecimal.ZERO);
    				
    				IObjectPK  newid =  CostSumFactory.getLocalInstance(ctx).save(costSumInfo);
    				String userNumber = ContextHelperFactory.getLocalInstance(ctx).getCurrentUser().getNumber().toString(); 
    				ExecutorService pool = Executors.newFixedThreadPool(1);
    			    ParallelSqlExecutor pe = new ParallelSqlExecutor(pool); 
    				StringBuffer sbr  = new StringBuffer("insert into T_BOT_Relation (FID,FDate,FOperatorID,FisEffected,FType, ");
		    		sbr.append(" FSrcEntityID,FDestEntityID,FSrcObjectID,FDestObjectID ,FBOTMappingID) ");
		    		sbr.append("values(newbosid('59302EC6'),sysdate ,'"+userNumber+"',1, 0,");
		    		sbr.append("'5DA507CC','7A8DD31F','"+newid.toString()+"','"+id+"','"+mapping+"' )"); 
		    		pe.getSqlList().add(sbr);
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
	    		}  
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void produceCost(Context ctx, CostSumInfo model) throws BOSException {
		// TODO Auto-generated method stub
		super.produceCost(ctx, model);
	}
    
	
	
	
    
}				
