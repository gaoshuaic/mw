package com.kingdee.eas.mw.srqr;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class PayItemFactory
{
    private PayItemFactory()
    {
    }
    public static com.kingdee.eas.mw.srqr.IPayItem getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.mw.srqr.IPayItem)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("2B2E091F") ,com.kingdee.eas.mw.srqr.IPayItem.class);
    }
    
    public static com.kingdee.eas.mw.srqr.IPayItem getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.mw.srqr.IPayItem)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("2B2E091F") ,com.kingdee.eas.mw.srqr.IPayItem.class, objectCtx);
    }
    public static com.kingdee.eas.mw.srqr.IPayItem getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.mw.srqr.IPayItem)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("2B2E091F"));
    }
    public static com.kingdee.eas.mw.srqr.IPayItem getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.mw.srqr.IPayItem)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("2B2E091F"));
    }
}