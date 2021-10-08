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

public class CostEhrDetail extends CoreBillBase implements ICostEhrDetail
{
    public CostEhrDetail()
    {
        super();
        registerInterface(ICostEhrDetail.class, this);
    }
    public CostEhrDetail(Context ctx)
    {
        super(ctx);
        registerInterface(ICostEhrDetail.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("611BD221");
    }
    private CostEhrDetailController getController() throws BOSException
    {
        return (CostEhrDetailController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public CostEhrDetailCollection getCostEhrDetailCollection() throws BOSException
    {
        try {
            return getController().getCostEhrDetailCollection(getContext());
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
    public CostEhrDetailCollection getCostEhrDetailCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getCostEhrDetailCollection(getContext(), view);
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
    public CostEhrDetailCollection getCostEhrDetailCollection(String oql) throws BOSException
    {
        try {
            return getController().getCostEhrDetailCollection(getContext(), oql);
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
    public CostEhrDetailInfo getCostEhrDetailInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getCostEhrDetailInfo(getContext(), pk);
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
    public CostEhrDetailInfo getCostEhrDetailInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getCostEhrDetailInfo(getContext(), pk, selector);
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
    public CostEhrDetailInfo getCostEhrDetailInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getCostEhrDetailInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *同步中间表-User defined method
     *@param model model
     */
    public void syncMiddata(CostEhrDetailInfo model) throws BOSException
    {
        try {
            getController().syncMiddata(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}