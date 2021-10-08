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

public class SpePartTimeDocPro extends DataBase implements ISpePartTimeDocPro
{
    public SpePartTimeDocPro()
    {
        super();
        registerInterface(ISpePartTimeDocPro.class, this);
    }
    public SpePartTimeDocPro(Context ctx)
    {
        super(ctx);
        registerInterface(ISpePartTimeDocPro.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("0C10B2AB");
    }
    private SpePartTimeDocProController getController() throws BOSException
    {
        return (SpePartTimeDocProController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public SpePartTimeDocProInfo getSpePartTimeDocProInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getSpePartTimeDocProInfo(getContext(), pk);
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
    public SpePartTimeDocProInfo getSpePartTimeDocProInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getSpePartTimeDocProInfo(getContext(), pk, selector);
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
    public SpePartTimeDocProInfo getSpePartTimeDocProInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getSpePartTimeDocProInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public SpePartTimeDocProCollection getSpePartTimeDocProCollection() throws BOSException
    {
        try {
            return getController().getSpePartTimeDocProCollection(getContext());
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
    public SpePartTimeDocProCollection getSpePartTimeDocProCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getSpePartTimeDocProCollection(getContext(), view);
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
    public SpePartTimeDocProCollection getSpePartTimeDocProCollection(String oql) throws BOSException
    {
        try {
            return getController().getSpePartTimeDocProCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}