package com.kingdee.eas.mw.pay;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class SpecategoryEntryFactory
{
    private SpecategoryEntryFactory()
    {
    }
    public static com.kingdee.eas.mw.pay.ISpecategoryEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.mw.pay.ISpecategoryEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("62709C9E") ,com.kingdee.eas.mw.pay.ISpecategoryEntry.class);
    }
    
    public static com.kingdee.eas.mw.pay.ISpecategoryEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.ISpecategoryEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("62709C9E") ,com.kingdee.eas.mw.pay.ISpecategoryEntry.class, objectCtx);
    }
    public static com.kingdee.eas.mw.pay.ISpecategoryEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.ISpecategoryEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("62709C9E"));
    }
    public static com.kingdee.eas.mw.pay.ISpecategoryEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.ISpecategoryEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("62709C9E"));
    }
}