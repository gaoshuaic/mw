package com.kingdee.eas.mw.pay;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class DocAchieveUpdateFactory
{
    private DocAchieveUpdateFactory()
    {
    }
    public static com.kingdee.eas.mw.pay.IDocAchieveUpdate getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IDocAchieveUpdate)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("09907354") ,com.kingdee.eas.mw.pay.IDocAchieveUpdate.class);
    }
    
    public static com.kingdee.eas.mw.pay.IDocAchieveUpdate getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IDocAchieveUpdate)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("09907354") ,com.kingdee.eas.mw.pay.IDocAchieveUpdate.class, objectCtx);
    }
    public static com.kingdee.eas.mw.pay.IDocAchieveUpdate getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IDocAchieveUpdate)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("09907354"));
    }
    public static com.kingdee.eas.mw.pay.IDocAchieveUpdate getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IDocAchieveUpdate)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("09907354"));
    }
}