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

public class DocCurrencyPro extends DataBase implements IDocCurrencyPro
{
    public DocCurrencyPro()
    {
        super();
        registerInterface(IDocCurrencyPro.class, this);
    }
    public DocCurrencyPro(Context ctx)
    {
        super(ctx);
        registerInterface(IDocCurrencyPro.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("21F17836");
    }
    private DocCurrencyProController getController() throws BOSException
    {
        return (DocCurrencyProController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public DocCurrencyProInfo getDocCurrencyProInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getDocCurrencyProInfo(getContext(), pk);
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
    public DocCurrencyProInfo getDocCurrencyProInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getDocCurrencyProInfo(getContext(), pk, selector);
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
    public DocCurrencyProInfo getDocCurrencyProInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getDocCurrencyProInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public DocCurrencyProCollection getDocCurrencyProCollection() throws BOSException
    {
        try {
            return getController().getDocCurrencyProCollection(getContext());
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
    public DocCurrencyProCollection getDocCurrencyProCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getDocCurrencyProCollection(getContext(), view);
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
    public DocCurrencyProCollection getDocCurrencyProCollection(String oql) throws BOSException
    {
        try {
            return getController().getDocCurrencyProCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}