package com.kingdee.eas.mw.pay;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class AchievementDetailFactory
{
    private AchievementDetailFactory()
    {
    }
    public static com.kingdee.eas.mw.pay.IAchievementDetail getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IAchievementDetail)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("3251FB6E") ,com.kingdee.eas.mw.pay.IAchievementDetail.class);
    }
    
    public static com.kingdee.eas.mw.pay.IAchievementDetail getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IAchievementDetail)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("3251FB6E") ,com.kingdee.eas.mw.pay.IAchievementDetail.class, objectCtx);
    }
    public static com.kingdee.eas.mw.pay.IAchievementDetail getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IAchievementDetail)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("3251FB6E"));
    }
    public static com.kingdee.eas.mw.pay.IAchievementDetail getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IAchievementDetail)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("3251FB6E"));
    }
}