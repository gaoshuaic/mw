package com.kingdee.eas.mw.pay;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.eas.mw.pay.app.*;
import com.kingdee.bos.dao.IObjectPK;
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

public class ConsultStage extends DataBase implements IConsultStage
{
    public ConsultStage()
    {
        super();
        registerInterface(IConsultStage.class, this);
    }
    public ConsultStage(Context ctx)
    {
        super(ctx);
        registerInterface(IConsultStage.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("5659F2A4");
    }
    private ConsultStageController getController() throws BOSException
    {
        return (ConsultStageController)getBizController();
    }
    /**
     *ȡֵ-System defined method
     *@param pk ȡֵ
     *@return
     */
    public ConsultStageInfo getConsultStageInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getConsultStageInfo(getContext(), pk);
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
    public ConsultStageInfo getConsultStageInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getConsultStageInfo(getContext(), pk, selector);
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
    public ConsultStageInfo getConsultStageInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getConsultStageInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡ����-System defined method
     *@return
     */
    public ConsultStageCollection getConsultStageCollection() throws BOSException
    {
        try {
            return getController().getConsultStageCollection(getContext());
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
    public ConsultStageCollection getConsultStageCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getConsultStageCollection(getContext(), view);
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
    public ConsultStageCollection getConsultStageCollection(String oql) throws BOSException
    {
        try {
            return getController().getConsultStageCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}