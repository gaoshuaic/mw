package com.kingdee.eas.mw.srqr;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ItemCheckFactory
{
    private ItemCheckFactory()
    {
    }
    public static com.kingdee.eas.mw.srqr.IItemCheck getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.mw.srqr.IItemCheck)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("D86829F9") ,com.kingdee.eas.mw.srqr.IItemCheck.class);
    }
    
    public static com.kingdee.eas.mw.srqr.IItemCheck getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.mw.srqr.IItemCheck)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("D86829F9") ,com.kingdee.eas.mw.srqr.IItemCheck.class, objectCtx);
    }
    public static com.kingdee.eas.mw.srqr.IItemCheck getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.mw.srqr.IItemCheck)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("D86829F9"));
    }
    public static com.kingdee.eas.mw.srqr.IItemCheck getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.mw.srqr.IItemCheck)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("D86829F9"));
    }
}