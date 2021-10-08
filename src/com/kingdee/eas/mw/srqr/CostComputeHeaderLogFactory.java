package com.kingdee.eas.mw.srqr;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CostComputeHeaderLogFactory
{
    private CostComputeHeaderLogFactory()
    {
    }
    public static com.kingdee.eas.mw.srqr.ICostComputeHeaderLog getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.mw.srqr.ICostComputeHeaderLog)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("F93A7229") ,com.kingdee.eas.mw.srqr.ICostComputeHeaderLog.class);
    }
    
    public static com.kingdee.eas.mw.srqr.ICostComputeHeaderLog getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.mw.srqr.ICostComputeHeaderLog)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("F93A7229") ,com.kingdee.eas.mw.srqr.ICostComputeHeaderLog.class, objectCtx);
    }
    public static com.kingdee.eas.mw.srqr.ICostComputeHeaderLog getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.mw.srqr.ICostComputeHeaderLog)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("F93A7229"));
    }
    public static com.kingdee.eas.mw.srqr.ICostComputeHeaderLog getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.mw.srqr.ICostComputeHeaderLog)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("F93A7229"));
    }
}