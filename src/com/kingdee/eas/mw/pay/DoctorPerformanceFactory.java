package com.kingdee.eas.mw.pay;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class DoctorPerformanceFactory
{
    private DoctorPerformanceFactory()
    {
    }
    public static com.kingdee.eas.mw.pay.IDoctorPerformance getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IDoctorPerformance)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("9286549F") ,com.kingdee.eas.mw.pay.IDoctorPerformance.class);
    }
    
    public static com.kingdee.eas.mw.pay.IDoctorPerformance getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IDoctorPerformance)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("9286549F") ,com.kingdee.eas.mw.pay.IDoctorPerformance.class, objectCtx);
    }
    public static com.kingdee.eas.mw.pay.IDoctorPerformance getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IDoctorPerformance)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("9286549F"));
    }
    public static com.kingdee.eas.mw.pay.IDoctorPerformance getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IDoctorPerformance)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("9286549F"));
    }
}