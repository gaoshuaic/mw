package com.kingdee.eas.mw.srqr;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class FreeItemCheckFactory
{
    private FreeItemCheckFactory()
    {
    }
    public static com.kingdee.eas.mw.srqr.IFreeItemCheck getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.mw.srqr.IFreeItemCheck)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("9DDEEAED") ,com.kingdee.eas.mw.srqr.IFreeItemCheck.class);
    }
    
    public static com.kingdee.eas.mw.srqr.IFreeItemCheck getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.mw.srqr.IFreeItemCheck)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("9DDEEAED") ,com.kingdee.eas.mw.srqr.IFreeItemCheck.class, objectCtx);
    }
    public static com.kingdee.eas.mw.srqr.IFreeItemCheck getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.mw.srqr.IFreeItemCheck)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("9DDEEAED"));
    }
    public static com.kingdee.eas.mw.srqr.IFreeItemCheck getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.mw.srqr.IFreeItemCheck)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("9DDEEAED"));
    }
}