package com.kingdee.eas.mw.pay;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class AchienementSumFactory
{
    private AchienementSumFactory()
    {
    }
    public static com.kingdee.eas.mw.pay.IAchienementSum getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IAchienementSum)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("4AF58046") ,com.kingdee.eas.mw.pay.IAchienementSum.class);
    }
    
    public static com.kingdee.eas.mw.pay.IAchienementSum getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IAchienementSum)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("4AF58046") ,com.kingdee.eas.mw.pay.IAchienementSum.class, objectCtx);
    }
    public static com.kingdee.eas.mw.pay.IAchienementSum getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IAchienementSum)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("4AF58046"));
    }
    public static com.kingdee.eas.mw.pay.IAchienementSum getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IAchienementSum)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("4AF58046"));
    }
}