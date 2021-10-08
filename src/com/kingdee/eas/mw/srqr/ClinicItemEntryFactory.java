package com.kingdee.eas.mw.srqr;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ClinicItemEntryFactory
{
    private ClinicItemEntryFactory()
    {
    }
    public static com.kingdee.eas.mw.srqr.IClinicItemEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.mw.srqr.IClinicItemEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("59161A5B") ,com.kingdee.eas.mw.srqr.IClinicItemEntry.class);
    }
    
    public static com.kingdee.eas.mw.srqr.IClinicItemEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.mw.srqr.IClinicItemEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("59161A5B") ,com.kingdee.eas.mw.srqr.IClinicItemEntry.class, objectCtx);
    }
    public static com.kingdee.eas.mw.srqr.IClinicItemEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.mw.srqr.IClinicItemEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("59161A5B"));
    }
    public static com.kingdee.eas.mw.srqr.IClinicItemEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.mw.srqr.IClinicItemEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("59161A5B"));
    }
}