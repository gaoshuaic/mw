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

public class PartTimeDocPro extends DataBase implements IPartTimeDocPro
{
    public PartTimeDocPro()
    {
        super();
        registerInterface(IPartTimeDocPro.class, this);
    }
    public PartTimeDocPro(Context ctx)
    {
        super(ctx);
        registerInterface(IPartTimeDocPro.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("9E09AB87");
    }
    private PartTimeDocProController getController() throws BOSException
    {
        return (PartTimeDocProController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public PartTimeDocProInfo getPartTimeDocProInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getPartTimeDocProInfo(getContext(), pk);
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
    public PartTimeDocProInfo getPartTimeDocProInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getPartTimeDocProInfo(getContext(), pk, selector);
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
    public PartTimeDocProInfo getPartTimeDocProInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getPartTimeDocProInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public PartTimeDocProCollection getPartTimeDocProCollection() throws BOSException
    {
        try {
            return getController().getPartTimeDocProCollection(getContext());
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
    public PartTimeDocProCollection getPartTimeDocProCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getPartTimeDocProCollection(getContext(), view);
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
    public PartTimeDocProCollection getPartTimeDocProCollection(String oql) throws BOSException
    {
        try {
            return getController().getPartTimeDocProCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}