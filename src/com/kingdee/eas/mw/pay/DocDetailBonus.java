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

public class DocDetailBonus extends DataBase implements IDocDetailBonus
{
    public DocDetailBonus()
    {
        super();
        registerInterface(IDocDetailBonus.class, this);
    }
    public DocDetailBonus(Context ctx)
    {
        super(ctx);
        registerInterface(IDocDetailBonus.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("832E15A8");
    }
    private DocDetailBonusController getController() throws BOSException
    {
        return (DocDetailBonusController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public DocDetailBonusInfo getDocDetailBonusInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getDocDetailBonusInfo(getContext(), pk);
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
    public DocDetailBonusInfo getDocDetailBonusInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getDocDetailBonusInfo(getContext(), pk, selector);
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
    public DocDetailBonusInfo getDocDetailBonusInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getDocDetailBonusInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public DocDetailBonusCollection getDocDetailBonusCollection() throws BOSException
    {
        try {
            return getController().getDocDetailBonusCollection(getContext());
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
    public DocDetailBonusCollection getDocDetailBonusCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getDocDetailBonusCollection(getContext(), view);
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
    public DocDetailBonusCollection getDocDetailBonusCollection(String oql) throws BOSException
    {
        try {
            return getController().getDocDetailBonusCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}