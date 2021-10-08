package com.kingdee.eas.mw.pay;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CostSumFactory
{
    private CostSumFactory()
    {
    }
    public static com.kingdee.eas.mw.pay.ICostSum getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.mw.pay.ICostSum)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("5DA507CC") ,com.kingdee.eas.mw.pay.ICostSum.class);
    }
    
    public static com.kingdee.eas.mw.pay.ICostSum getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.ICostSum)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("5DA507CC") ,com.kingdee.eas.mw.pay.ICostSum.class, objectCtx);
    }
    public static com.kingdee.eas.mw.pay.ICostSum getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.ICostSum)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("5DA507CC"));
    }
    public static com.kingdee.eas.mw.pay.ICostSum getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.ICostSum)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("5DA507CC"));
    }
}