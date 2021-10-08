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

public class CityChannel extends DataBase implements ICityChannel
{
    public CityChannel()
    {
        super();
        registerInterface(ICityChannel.class, this);
    }
    public CityChannel(Context ctx)
    {
        super(ctx);
        registerInterface(ICityChannel.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("EDEDC6A6");
    }
    private CityChannelController getController() throws BOSException
    {
        return (CityChannelController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public CityChannelInfo getCityChannelInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getCityChannelInfo(getContext(), pk);
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
    public CityChannelInfo getCityChannelInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getCityChannelInfo(getContext(), pk, selector);
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
    public CityChannelInfo getCityChannelInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getCityChannelInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public CityChannelCollection getCityChannelCollection() throws BOSException
    {
        try {
            return getController().getCityChannelCollection(getContext());
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
    public CityChannelCollection getCityChannelCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getCityChannelCollection(getContext(), view);
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
    public CityChannelCollection getCityChannelCollection(String oql) throws BOSException
    {
        try {
            return getController().getCityChannelCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}