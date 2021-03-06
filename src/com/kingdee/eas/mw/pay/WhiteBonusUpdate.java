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

public class WhiteBonusUpdate extends DataBase implements IWhiteBonusUpdate
{
    public WhiteBonusUpdate()
    {
        super();
        registerInterface(IWhiteBonusUpdate.class, this);
    }
    public WhiteBonusUpdate(Context ctx)
    {
        super(ctx);
        registerInterface(IWhiteBonusUpdate.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("83F86911");
    }
    private WhiteBonusUpdateController getController() throws BOSException
    {
        return (WhiteBonusUpdateController)getBizController();
    }
    /**
     *ȡֵ-System defined method
     *@param pk ȡֵ
     *@return
     */
    public WhiteBonusUpdateInfo getWhiteBonusUpdateInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getWhiteBonusUpdateInfo(getContext(), pk);
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
    public WhiteBonusUpdateInfo getWhiteBonusUpdateInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getWhiteBonusUpdateInfo(getContext(), pk, selector);
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
    public WhiteBonusUpdateInfo getWhiteBonusUpdateInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getWhiteBonusUpdateInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡ????-System defined method
     *@return
     */
    public WhiteBonusUpdateCollection getWhiteBonusUpdateCollection() throws BOSException
    {
        try {
            return getController().getWhiteBonusUpdateCollection(getContext());
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡ????-System defined method
     *@param view ȡ????
     *@return
     */
    public WhiteBonusUpdateCollection getWhiteBonusUpdateCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getWhiteBonusUpdateCollection(getContext(), view);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡ????-System defined method
     *@param oql ȡ????
     *@return
     */
    public WhiteBonusUpdateCollection getWhiteBonusUpdateCollection(String oql) throws BOSException
    {
        try {
            return getController().getWhiteBonusUpdateCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}