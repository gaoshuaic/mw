package com.kingdee.eas.mw.pay;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class SpecategoryAssEntryFactory
{
    private SpecategoryAssEntryFactory()
    {
    }
    public static com.kingdee.eas.mw.pay.ISpecategoryAssEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.mw.pay.ISpecategoryAssEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("F389F2C5") ,com.kingdee.eas.mw.pay.ISpecategoryAssEntry.class);
    }
    
    public static com.kingdee.eas.mw.pay.ISpecategoryAssEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.ISpecategoryAssEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("F389F2C5") ,com.kingdee.eas.mw.pay.ISpecategoryAssEntry.class, objectCtx);
    }
    public static com.kingdee.eas.mw.pay.ISpecategoryAssEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.ISpecategoryAssEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("F389F2C5"));
    }
    public static com.kingdee.eas.mw.pay.ISpecategoryAssEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.ISpecategoryAssEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("F389F2C5"));
    }
}