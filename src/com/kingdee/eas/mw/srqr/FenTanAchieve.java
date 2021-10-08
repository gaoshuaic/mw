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

public class FenTanAchieve extends DataBase implements IFenTanAchieve
{
    public FenTanAchieve()
    {
        super();
        registerInterface(IFenTanAchieve.class, this);
    }
    public FenTanAchieve(Context ctx)
    {
        super(ctx);
        registerInterface(IFenTanAchieve.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("34BFB6A3");
    }
    private FenTanAchieveController getController() throws BOSException
    {
        return (FenTanAchieveController)getBizController();
    }
    /**
     *ȡֵ-System defined method
     *@param pk ȡֵ
     *@return
     */
    public FenTanAchieveInfo getFenTanAchieveInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getFenTanAchieveInfo(getContext(), pk);
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
    public FenTanAchieveInfo getFenTanAchieveInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getFenTanAchieveInfo(getContext(), pk, selector);
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
    public FenTanAchieveInfo getFenTanAchieveInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getFenTanAchieveInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡ����-System defined method
     *@return
     */
    public FenTanAchieveCollection getFenTanAchieveCollection() throws BOSException
    {
        try {
            return getController().getFenTanAchieveCollection(getContext());
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
    public FenTanAchieveCollection getFenTanAchieveCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getFenTanAchieveCollection(getContext(), view);
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
    public FenTanAchieveCollection getFenTanAchieveCollection(String oql) throws BOSException
    {
        try {
            return getController().getFenTanAchieveCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}