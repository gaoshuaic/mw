package com.kingdee.eas.mw.pay;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class SpecategoryOtherEntryFactory
{
    private SpecategoryOtherEntryFactory()
    {
    }
    public static com.kingdee.eas.mw.pay.ISpecategoryOtherEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.mw.pay.ISpecategoryOtherEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("5376AA96") ,com.kingdee.eas.mw.pay.ISpecategoryOtherEntry.class);
    }
    
    public static com.kingdee.eas.mw.pay.ISpecategoryOtherEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.ISpecategoryOtherEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("5376AA96") ,com.kingdee.eas.mw.pay.ISpecategoryOtherEntry.class, objectCtx);
    }
    public static com.kingdee.eas.mw.pay.ISpecategoryOtherEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.ISpecategoryOtherEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("5376AA96"));
    }
    public static com.kingdee.eas.mw.pay.ISpecategoryOtherEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.ISpecategoryOtherEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("5376AA96"));
    }
}