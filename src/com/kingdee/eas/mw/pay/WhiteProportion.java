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

public class WhiteProportion extends DataBase implements IWhiteProportion
{
    public WhiteProportion()
    {
        super();
        registerInterface(IWhiteProportion.class, this);
    }
    public WhiteProportion(Context ctx)
    {
        super(ctx);
        registerInterface(IWhiteProportion.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("773C8031");
    }
    private WhiteProportionController getController() throws BOSException
    {
        return (WhiteProportionController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public WhiteProportionInfo getWhiteProportionInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getWhiteProportionInfo(getContext(), pk);
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
    public WhiteProportionInfo getWhiteProportionInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getWhiteProportionInfo(getContext(), pk, selector);
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
    public WhiteProportionInfo getWhiteProportionInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getWhiteProportionInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public WhiteProportionCollection getWhiteProportionCollection() throws BOSException
    {
        try {
            return getController().getWhiteProportionCollection(getContext());
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
    public WhiteProportionCollection getWhiteProportionCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getWhiteProportionCollection(getContext(), view);
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
    public WhiteProportionCollection getWhiteProportionCollection(String oql) throws BOSException
    {
        try {
            return getController().getWhiteProportionCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}