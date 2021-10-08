package com.kingdee.eas.mw.pay;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.eas.mw.pay.app.*;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.framework.CoreBillBase;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.framework.ICoreBillBase;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class AttendanceHours extends CoreBillBase implements IAttendanceHours
{
    public AttendanceHours()
    {
        super();
        registerInterface(IAttendanceHours.class, this);
    }
    public AttendanceHours(Context ctx)
    {
        super(ctx);
        registerInterface(IAttendanceHours.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("6F469034");
    }
    private AttendanceHoursController getController() throws BOSException
    {
        return (AttendanceHoursController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public AttendanceHoursCollection getAttendanceHoursCollection() throws BOSException
    {
        try {
            return getController().getAttendanceHoursCollection(getContext());
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
    public AttendanceHoursCollection getAttendanceHoursCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getAttendanceHoursCollection(getContext(), view);
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
    public AttendanceHoursCollection getAttendanceHoursCollection(String oql) throws BOSException
    {
        try {
            return getController().getAttendanceHoursCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public AttendanceHoursInfo getAttendanceHoursInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getAttendanceHoursInfo(getContext(), pk);
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
    public AttendanceHoursInfo getAttendanceHoursInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getAttendanceHoursInfo(getContext(), pk, selector);
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
    public AttendanceHoursInfo getAttendanceHoursInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getAttendanceHoursInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}