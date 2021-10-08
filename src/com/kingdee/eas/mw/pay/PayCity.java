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

public class PayCity extends DataBase implements IPayCity
{
    public PayCity()
    {
        super();
        registerInterface(IPayCity.class, this);
    }
    public PayCity(Context ctx)
    {
        super(ctx);
        registerInterface(IPayCity.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("F5B0CAC1");
    }
    private PayCityController getController() throws BOSException
    {
        return (PayCityController)getBizController();
    }
    /**
     *ȡֵ-System defined method
     *@param pk ȡֵ
     *@return
     */
    public PayCityInfo getPayCityInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getPayCityInfo(getContext(), pk);
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
    public PayCityInfo getPayCityInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getPayCityInfo(getContext(), pk, selector);
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
    public PayCityInfo getPayCityInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getPayCityInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡ����-System defined method
     *@return
     */
    public PayCityCollection getPayCityCollection() throws BOSException
    {
        try {
            return getController().getPayCityCollection(getContext());
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
    public PayCityCollection getPayCityCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getPayCityCollection(getContext(), view);
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
    public PayCityCollection getPayCityCollection(String oql) throws BOSException
    {
        try {
            return getController().getPayCityCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ͬ����Ϣ-User defined method
     *@param model model
     */
    public void syncMessage(PayCityInfo model) throws BOSException
    {
        try {
            getController().syncMessage(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *����ͬ��-User defined method
     *@param model model
     */
    public void syncCostAndAchieve(PayCityInfo model) throws BOSException
    {
        try {
            getController().syncCostAndAchieve(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}