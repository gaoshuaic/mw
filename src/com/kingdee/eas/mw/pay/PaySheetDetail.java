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

public class PaySheetDetail extends DataBase implements IPaySheetDetail
{
    public PaySheetDetail()
    {
        super();
        registerInterface(IPaySheetDetail.class, this);
    }
    public PaySheetDetail(Context ctx)
    {
        super(ctx);
        registerInterface(IPaySheetDetail.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("4104607A");
    }
    private PaySheetDetailController getController() throws BOSException
    {
        return (PaySheetDetailController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public PaySheetDetailInfo getPaySheetDetailInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getPaySheetDetailInfo(getContext(), pk);
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
    public PaySheetDetailInfo getPaySheetDetailInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getPaySheetDetailInfo(getContext(), pk, selector);
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
    public PaySheetDetailInfo getPaySheetDetailInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getPaySheetDetailInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public PaySheetDetailCollection getPaySheetDetailCollection() throws BOSException
    {
        try {
            return getController().getPaySheetDetailCollection(getContext());
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
    public PaySheetDetailCollection getPaySheetDetailCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getPaySheetDetailCollection(getContext(), view);
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
    public PaySheetDetailCollection getPaySheetDetailCollection(String oql) throws BOSException
    {
        try {
            return getController().getPaySheetDetailCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}