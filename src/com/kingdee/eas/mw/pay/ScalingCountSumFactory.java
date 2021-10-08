package com.kingdee.eas.mw.pay;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ScalingCountSumFactory
{
    private ScalingCountSumFactory()
    {
    }
    public static com.kingdee.eas.mw.pay.IScalingCountSum getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IScalingCountSum)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("847C41F1") ,com.kingdee.eas.mw.pay.IScalingCountSum.class);
    }
    
    public static com.kingdee.eas.mw.pay.IScalingCountSum getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IScalingCountSum)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("847C41F1") ,com.kingdee.eas.mw.pay.IScalingCountSum.class, objectCtx);
    }
    public static com.kingdee.eas.mw.pay.IScalingCountSum getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IScalingCountSum)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("847C41F1"));
    }
    public static com.kingdee.eas.mw.pay.IScalingCountSum getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IScalingCountSum)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("847C41F1"));
    }
}