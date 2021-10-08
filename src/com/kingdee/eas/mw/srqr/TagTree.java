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

public class TagTree extends TreeBase implements ITagTree
{
    public TagTree()
    {
        super();
        registerInterface(ITagTree.class, this);
    }
    public TagTree(Context ctx)
    {
        super(ctx);
        registerInterface(ITagTree.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("FDCE479C");
    }
    private TagTreeController getController() throws BOSException
    {
        return (TagTreeController)getBizController();
    }
    /**
     *ȡֵ-System defined method
     *@param pk ȡֵ
     *@return
     */
    public TagTreeInfo getTagTreeInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getTagTreeInfo(getContext(), pk);
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
    public TagTreeInfo getTagTreeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getTagTreeInfo(getContext(), pk, selector);
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
    public TagTreeInfo getTagTreeInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getTagTreeInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡ����-System defined method
     *@return
     */
    public TagTreeCollection getTagTreeCollection() throws BOSException
    {
        try {
            return getController().getTagTreeCollection(getContext());
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
    public TagTreeCollection getTagTreeCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getTagTreeCollection(getContext(), view);
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
    public TagTreeCollection getTagTreeCollection(String oql) throws BOSException
    {
        try {
            return getController().getTagTreeCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}