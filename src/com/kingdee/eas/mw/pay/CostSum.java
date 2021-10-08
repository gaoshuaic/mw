package com.kingdee.eas.mw.pay;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.eas.mw.pay.app.*;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.framework.CoreBillBase;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.framework.ICoreBillBase;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class CostSum extends CoreBillBase implements ICostSum
{
    public CostSum()
    {
        super();
        registerInterface(ICostSum.class, this);
    }
    public CostSum(Context ctx)
    {
        super(ctx);
        registerInterface(ICostSum.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("5DA507CC");
    }
    private CostSumController getController() throws BOSException
    {
        return (CostSumController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public CostSumCollection getCostSumCollection() throws BOSException
    {
        try {
            return getController().getCostSumCollection(getContext());
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@param view 取集合
     *@return
     */
    public CostSumCollection getCostSumCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getCostSumCollection(getContext(), view);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@param oql 取集合
     *@return
     */
    public CostSumCollection getCostSumCollection(String oql) throws BOSException
    {
        try {
            return getController().getCostSumCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public CostSumInfo getCostSumInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getCostSumInfo(getContext(), pk);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@param selector 取值
     *@return
     */
    public CostSumInfo getCostSumInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getCostSumInfo(getContext(), pk, selector);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取值-System defined method
     *@param oql 取值
     *@return
     */
    public CostSumInfo getCostSumInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getCostSumInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *审核成本-User defined method
     *@param model model
     *@return
     */
    public String auditCost(CostSumInfo model) throws BOSException
    {
        try {
            return getController().auditCost(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *反审核成本-User defined method
     *@param model model
     *@return
     */
    public String unAuditCost(CostSumInfo model) throws BOSException
    {
        try {
            return getController().unAuditCost(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *设置成本汇总值-User defined method
     *@param type type
     *@param id id
     */
    public void setAllCost(String type, String id) throws BOSException
    {
        try {
            getController().setAllCost(getContext(), type, id);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *生成成本-User defined method
     *@param model model
     */
    public void produceCost(CostSumInfo model) throws BOSException
    {
        try {
            getController().produceCost(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}