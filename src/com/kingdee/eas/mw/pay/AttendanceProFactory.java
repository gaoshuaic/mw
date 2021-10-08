package com.kingdee.eas.mw.pay;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class AttendanceProFactory
{
    private AttendanceProFactory()
    {
    }
    public static com.kingdee.eas.mw.pay.IAttendancePro getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IAttendancePro)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("D2D48112") ,com.kingdee.eas.mw.pay.IAttendancePro.class);
    }
    
    public static com.kingdee.eas.mw.pay.IAttendancePro getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IAttendancePro)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("D2D48112") ,com.kingdee.eas.mw.pay.IAttendancePro.class, objectCtx);
    }
    public static com.kingdee.eas.mw.pay.IAttendancePro getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IAttendancePro)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("D2D48112"));
    }
    public static com.kingdee.eas.mw.pay.IAttendancePro getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IAttendancePro)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("D2D48112"));
    }
}