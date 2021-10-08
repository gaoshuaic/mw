package com.kingdee.eas.mw.pay;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class PayPostFactory
{
    private PayPostFactory()
    {
    }
    public static com.kingdee.eas.mw.pay.IPayPost getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IPayPost)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("F5B6C9F6") ,com.kingdee.eas.mw.pay.IPayPost.class);
    }
    
    public static com.kingdee.eas.mw.pay.IPayPost getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IPayPost)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("F5B6C9F6") ,com.kingdee.eas.mw.pay.IPayPost.class, objectCtx);
    }
    public static com.kingdee.eas.mw.pay.IPayPost getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IPayPost)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("F5B6C9F6"));
    }
    public static com.kingdee.eas.mw.pay.IPayPost getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IPayPost)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("F5B6C9F6"));
    }
}