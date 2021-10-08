package com.kingdee.eas.mw.pay;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class MarketDateFactory
{
    private MarketDateFactory()
    {
    }
    public static com.kingdee.eas.mw.pay.IMarketDate getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IMarketDate)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("D18566BC") ,com.kingdee.eas.mw.pay.IMarketDate.class);
    }
    
    public static com.kingdee.eas.mw.pay.IMarketDate getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IMarketDate)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("D18566BC") ,com.kingdee.eas.mw.pay.IMarketDate.class, objectCtx);
    }
    public static com.kingdee.eas.mw.pay.IMarketDate getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IMarketDate)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("D18566BC"));
    }
    public static com.kingdee.eas.mw.pay.IMarketDate getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IMarketDate)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("D18566BC"));
    }
}