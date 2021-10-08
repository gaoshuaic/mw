package com.kingdee.eas.mw.pay;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ServiceAmountFactory
{
    private ServiceAmountFactory()
    {
    }
    public static com.kingdee.eas.mw.pay.IServiceAmount getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IServiceAmount)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("6DE2E57B") ,com.kingdee.eas.mw.pay.IServiceAmount.class);
    }
    
    public static com.kingdee.eas.mw.pay.IServiceAmount getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IServiceAmount)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("6DE2E57B") ,com.kingdee.eas.mw.pay.IServiceAmount.class, objectCtx);
    }
    public static com.kingdee.eas.mw.pay.IServiceAmount getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IServiceAmount)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("6DE2E57B"));
    }
    public static com.kingdee.eas.mw.pay.IServiceAmount getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IServiceAmount)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("6DE2E57B"));
    }
}