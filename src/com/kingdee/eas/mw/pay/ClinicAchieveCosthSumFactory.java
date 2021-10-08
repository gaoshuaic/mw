package com.kingdee.eas.mw.pay;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ClinicAchieveCosthSumFactory
{
    private ClinicAchieveCosthSumFactory()
    {
    }
    public static com.kingdee.eas.mw.pay.IClinicAchieveCosthSum getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IClinicAchieveCosthSum)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("20D1E187") ,com.kingdee.eas.mw.pay.IClinicAchieveCosthSum.class);
    }
    
    public static com.kingdee.eas.mw.pay.IClinicAchieveCosthSum getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IClinicAchieveCosthSum)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("20D1E187") ,com.kingdee.eas.mw.pay.IClinicAchieveCosthSum.class, objectCtx);
    }
    public static com.kingdee.eas.mw.pay.IClinicAchieveCosthSum getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IClinicAchieveCosthSum)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("20D1E187"));
    }
    public static com.kingdee.eas.mw.pay.IClinicAchieveCosthSum getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IClinicAchieveCosthSum)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("20D1E187"));
    }
}