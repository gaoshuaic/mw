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
     *ȡ����-System defined method
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
     *ȡ����-System defined method
     *@param view ȡ����
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
     *ȡ����-System defined method
     *@param oql ȡ����
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
     *ȡֵ-System defined method
     *@param pk ȡֵ
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
     *ȡֵ-System defined method
     *@param pk ȡֵ
     *@param selector ȡֵ
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
     *ȡֵ-System defined method
     *@param oql ȡֵ
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
     *��˳ɱ�-User defined method
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
     *����˳ɱ�-User defined method
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
     *���óɱ�����ֵ-User defined method
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
     *���ɳɱ�-User defined method
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