package com.kingdee.eas.mw.pay;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class AchieveDetailFactory
{
    private AchieveDetailFactory()
    {
    }
    public static com.kingdee.eas.mw.pay.IAchieveDetail getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IAchieveDetail)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("C9F3CC10") ,com.kingdee.eas.mw.pay.IAchieveDetail.class);
    }
    
    public static com.kingdee.eas.mw.pay.IAchieveDetail getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IAchieveDetail)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("C9F3CC10") ,com.kingdee.eas.mw.pay.IAchieveDetail.class, objectCtx);
    }
    public static com.kingdee.eas.mw.pay.IAchieveDetail getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IAchieveDetail)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("C9F3CC10"));
    }
    public static com.kingdee.eas.mw.pay.IAchieveDetail getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IAchieveDetail)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("C9F3CC10"));
    }
}