package com.kingdee.eas.mw.pay;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ClinicAchieveCosthInitFactory
{
    private ClinicAchieveCosthInitFactory()
    {
    }
    public static com.kingdee.eas.mw.pay.IClinicAchieveCosthInit getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IClinicAchieveCosthInit)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("F965A954") ,com.kingdee.eas.mw.pay.IClinicAchieveCosthInit.class);
    }
    
    public static com.kingdee.eas.mw.pay.IClinicAchieveCosthInit getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IClinicAchieveCosthInit)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("F965A954") ,com.kingdee.eas.mw.pay.IClinicAchieveCosthInit.class, objectCtx);
    }
    public static com.kingdee.eas.mw.pay.IClinicAchieveCosthInit getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IClinicAchieveCosthInit)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("F965A954"));
    }
    public static com.kingdee.eas.mw.pay.IClinicAchieveCosthInit getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IClinicAchieveCosthInit)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("F965A954"));
    }
}