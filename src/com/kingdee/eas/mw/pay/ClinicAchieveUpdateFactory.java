package com.kingdee.eas.mw.pay;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ClinicAchieveUpdateFactory
{
    private ClinicAchieveUpdateFactory()
    {
    }
    public static com.kingdee.eas.mw.pay.IClinicAchieveUpdate getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IClinicAchieveUpdate)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("4E75FE00") ,com.kingdee.eas.mw.pay.IClinicAchieveUpdate.class);
    }
    
    public static com.kingdee.eas.mw.pay.IClinicAchieveUpdate getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IClinicAchieveUpdate)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("4E75FE00") ,com.kingdee.eas.mw.pay.IClinicAchieveUpdate.class, objectCtx);
    }
    public static com.kingdee.eas.mw.pay.IClinicAchieveUpdate getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IClinicAchieveUpdate)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("4E75FE00"));
    }
    public static com.kingdee.eas.mw.pay.IClinicAchieveUpdate getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IClinicAchieveUpdate)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("4E75FE00"));
    }
}