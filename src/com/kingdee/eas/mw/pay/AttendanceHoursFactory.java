package com.kingdee.eas.mw.pay;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class AttendanceHoursFactory
{
    private AttendanceHoursFactory()
    {
    }
    public static com.kingdee.eas.mw.pay.IAttendanceHours getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IAttendanceHours)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("6F469034") ,com.kingdee.eas.mw.pay.IAttendanceHours.class);
    }
    
    public static com.kingdee.eas.mw.pay.IAttendanceHours getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IAttendanceHours)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("6F469034") ,com.kingdee.eas.mw.pay.IAttendanceHours.class, objectCtx);
    }
    public static com.kingdee.eas.mw.pay.IAttendanceHours getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IAttendanceHours)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("6F469034"));
    }
    public static com.kingdee.eas.mw.pay.IAttendanceHours getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IAttendanceHours)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("6F469034"));
    }
}