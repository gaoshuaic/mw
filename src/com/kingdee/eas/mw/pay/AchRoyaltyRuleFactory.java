package com.kingdee.eas.mw.pay;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class AchRoyaltyRuleFactory
{
    private AchRoyaltyRuleFactory()
    {
    }
    public static com.kingdee.eas.mw.pay.IAchRoyaltyRule getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IAchRoyaltyRule)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("19F27034") ,com.kingdee.eas.mw.pay.IAchRoyaltyRule.class);
    }
    
    public static com.kingdee.eas.mw.pay.IAchRoyaltyRule getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IAchRoyaltyRule)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("19F27034") ,com.kingdee.eas.mw.pay.IAchRoyaltyRule.class, objectCtx);
    }
    public static com.kingdee.eas.mw.pay.IAchRoyaltyRule getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IAchRoyaltyRule)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("19F27034"));
    }
    public static com.kingdee.eas.mw.pay.IAchRoyaltyRule getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IAchRoyaltyRule)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("19F27034"));
    }
}