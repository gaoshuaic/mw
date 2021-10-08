package com.kingdee.eas.mw.srqr;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CostCenterFactory
{
    private CostCenterFactory()
    {
    }
    public static com.kingdee.eas.mw.srqr.ICostCenter getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.mw.srqr.ICostCenter)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("B60466BE") ,com.kingdee.eas.mw.srqr.ICostCenter.class);
    }
    
    public static com.kingdee.eas.mw.srqr.ICostCenter getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.mw.srqr.ICostCenter)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("B60466BE") ,com.kingdee.eas.mw.srqr.ICostCenter.class, objectCtx);
    }
    public static com.kingdee.eas.mw.srqr.ICostCenter getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.mw.srqr.ICostCenter)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("B60466BE"));
    }
    public static com.kingdee.eas.mw.srqr.ICostCenter getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.mw.srqr.ICostCenter)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("B60466BE"));
    }
}