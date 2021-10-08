package com.kingdee.eas.mw.pay;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class DocStageFactory
{
    private DocStageFactory()
    {
    }
    public static com.kingdee.eas.mw.pay.IDocStage getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IDocStage)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("A1CD41D8") ,com.kingdee.eas.mw.pay.IDocStage.class);
    }
    
    public static com.kingdee.eas.mw.pay.IDocStage getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IDocStage)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("A1CD41D8") ,com.kingdee.eas.mw.pay.IDocStage.class, objectCtx);
    }
    public static com.kingdee.eas.mw.pay.IDocStage getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IDocStage)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("A1CD41D8"));
    }
    public static com.kingdee.eas.mw.pay.IDocStage getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IDocStage)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("A1CD41D8"));
    }
}