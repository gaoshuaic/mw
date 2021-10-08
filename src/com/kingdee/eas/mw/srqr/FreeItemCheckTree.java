package com.kingdee.eas.mw.srqr;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.eas.framework.ITreeBase;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.mw.srqr.app.*;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.eas.framework.TreeBase;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class FreeItemCheckTree extends TreeBase implements IFreeItemCheckTree
{
    public FreeItemCheckTree()
    {
        super();
        registerInterface(IFreeItemCheckTree.class, this);
    }
    public FreeItemCheckTree(Context ctx)
    {
        super(ctx);
        registerInterface(IFreeItemCheckTree.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("6D8D942B");
    }
    private FreeItemCheckTreeController getController() throws BOSException
    {
        return (FreeItemCheckTreeController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public FreeItemCheckTreeInfo getFreeItemCheckTreeInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getFreeItemCheckTreeInfo(getContext(), pk);
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
    public FreeItemCheckTreeInfo getFreeItemCheckTreeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getFreeItemCheckTreeInfo(getContext(), pk, selector);
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
    public FreeItemCheckTreeInfo getFreeItemCheckTreeInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getFreeItemCheckTreeInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public FreeItemCheckTreeCollection getFreeItemCheckTreeCollection() throws BOSException
    {
        try {
            return getController().getFreeItemCheckTreeCollection(getContext());
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
    public FreeItemCheckTreeCollection getFreeItemCheckTreeCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getFreeItemCheckTreeCollection(getContext(), view);
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
    public FreeItemCheckTreeCollection getFreeItemCheckTreeCollection(String oql) throws BOSException
    {
        try {
            return getController().getFreeItemCheckTreeCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}