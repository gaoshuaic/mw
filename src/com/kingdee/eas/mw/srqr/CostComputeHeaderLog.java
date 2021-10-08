package com.kingdee.eas.mw.srqr;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.mw.srqr.app.*;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.DataBase;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.IDataBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class CostComputeHeaderLog extends DataBase implements ICostComputeHeaderLog
{
    public CostComputeHeaderLog()
    {
        super();
        registerInterface(ICostComputeHeaderLog.class, this);
    }
    public CostComputeHeaderLog(Context ctx)
    {
        super(ctx);
        registerInterface(ICostComputeHeaderLog.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("F93A7229");
    }
    private CostComputeHeaderLogController getController() throws BOSException
    {
        return (CostComputeHeaderLogController)getBizController();
    }
    /**
     *ȡֵ-System defined method
     *@param pk ȡֵ
     *@return
     */
    public CostComputeHeaderLogInfo getCostComputeHeaderLogInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getCostComputeHeaderLogInfo(getContext(), pk);
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
    public CostComputeHeaderLogInfo getCostComputeHeaderLogInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getCostComputeHeaderLogInfo(getContext(), pk, selector);
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
    public CostComputeHeaderLogInfo getCostComputeHeaderLogInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getCostComputeHeaderLogInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡ����-System defined method
     *@return
     */
    public CostComputeHeaderLogCollection getCostComputeHeaderLogCollection() throws BOSException
    {
        try {
            return getController().getCostComputeHeaderLogCollection(getContext());
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
    public CostComputeHeaderLogCollection getCostComputeHeaderLogCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getCostComputeHeaderLogCollection(getContext(), view);
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
    public CostComputeHeaderLogCollection getCostComputeHeaderLogCollection(String oql) throws BOSException
    {
        try {
            return getController().getCostComputeHeaderLogCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}