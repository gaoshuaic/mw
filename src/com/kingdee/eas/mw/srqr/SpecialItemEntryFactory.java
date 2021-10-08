package com.kingdee.eas.mw.srqr;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class SpecialItemEntryFactory
{
    private SpecialItemEntryFactory()
    {
    }
    public static com.kingdee.eas.mw.srqr.ISpecialItemEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.mw.srqr.ISpecialItemEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("88DFDFA2") ,com.kingdee.eas.mw.srqr.ISpecialItemEntry.class);
    }
    
    public static com.kingdee.eas.mw.srqr.ISpecialItemEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.mw.srqr.ISpecialItemEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("88DFDFA2") ,com.kingdee.eas.mw.srqr.ISpecialItemEntry.class, objectCtx);
    }
    public static com.kingdee.eas.mw.srqr.ISpecialItemEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.mw.srqr.ISpecialItemEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("88DFDFA2"));
    }
    public static com.kingdee.eas.mw.srqr.ISpecialItemEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.mw.srqr.ISpecialItemEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("88DFDFA2"));
    }
}