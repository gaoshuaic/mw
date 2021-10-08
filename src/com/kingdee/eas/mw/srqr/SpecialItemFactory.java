package com.kingdee.eas.mw.srqr;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class SpecialItemFactory
{
    private SpecialItemFactory()
    {
    }
    public static com.kingdee.eas.mw.srqr.ISpecialItem getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.mw.srqr.ISpecialItem)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("1E94E6B0") ,com.kingdee.eas.mw.srqr.ISpecialItem.class);
    }
    
    public static com.kingdee.eas.mw.srqr.ISpecialItem getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.mw.srqr.ISpecialItem)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("1E94E6B0") ,com.kingdee.eas.mw.srqr.ISpecialItem.class, objectCtx);
    }
    public static com.kingdee.eas.mw.srqr.ISpecialItem getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.mw.srqr.ISpecialItem)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("1E94E6B0"));
    }
    public static com.kingdee.eas.mw.srqr.ISpecialItem getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.mw.srqr.ISpecialItem)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("1E94E6B0"));
    }
}