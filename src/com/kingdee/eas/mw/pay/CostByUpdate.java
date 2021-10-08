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

public class CostByUpdate extends CoreBillBase implements ICostByUpdate
{
    public CostByUpdate()
    {
        super();
        registerInterface(ICostByUpdate.class, this);
    }
    public CostByUpdate(Context ctx)
    {
        super(ctx);
        registerInterface(ICostByUpdate.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("7A8DD31F");
    }
    private CostByUpdateController getController() throws BOSException
    {
        return (CostByUpdateController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public CostByUpdateCollection getCostByUpdateCollection() throws BOSException
    {
        try {
            return getController().getCostByUpdateCollection(getContext());
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
    public CostByUpdateCollection getCostByUpdateCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getCostByUpdateCollection(getContext(), view);
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
    public CostByUpdateCollection getCostByUpdateCollection(String oql) throws BOSException
    {
        try {
            return getController().getCostByUpdateCollection(getContext(), oql);
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
    public CostByUpdateInfo getCostByUpdateInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getCostByUpdateInfo(getContext(), pk);
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
    public CostByUpdateInfo getCostByUpdateInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getCostByUpdateInfo(getContext(), pk, selector);
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
    public CostByUpdateInfo getCostByUpdateInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getCostByUpdateInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *审核成本-User defined method
     *@param model model
     */
    public void auditCost(CostByUpdateInfo model) throws BOSException
    {
        try {
            getController().auditCost(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *反审核成本-User defined method
     *@param model model
     */
    public void unAuditCost(CostByUpdateInfo model) throws BOSException
    {
        try {
            getController().unAuditCost(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}