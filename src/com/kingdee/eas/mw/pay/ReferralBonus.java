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

public class ReferralBonus extends CoreBillBase implements IReferralBonus
{
    public ReferralBonus()
    {
        super();
        registerInterface(IReferralBonus.class, this);
    }
    public ReferralBonus(Context ctx)
    {
        super(ctx);
        registerInterface(IReferralBonus.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("0BC9EC90");
    }
    private ReferralBonusController getController() throws BOSException
    {
        return (ReferralBonusController)getBizController();
    }
    /**
     *ȡ����-System defined method
     *@return
     */
    public ReferralBonusCollection getReferralBonusCollection() throws BOSException
    {
        try {
            return getController().getReferralBonusCollection(getContext());
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
    public ReferralBonusCollection getReferralBonusCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getReferralBonusCollection(getContext(), view);
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
    public ReferralBonusCollection getReferralBonusCollection(String oql) throws BOSException
    {
        try {
            return getController().getReferralBonusCollection(getContext(), oql);
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
    public ReferralBonusInfo getReferralBonusInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getReferralBonusInfo(getContext(), pk);
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
    public ReferralBonusInfo getReferralBonusInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getReferralBonusInfo(getContext(), pk, selector);
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
    public ReferralBonusInfo getReferralBonusInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getReferralBonusInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}