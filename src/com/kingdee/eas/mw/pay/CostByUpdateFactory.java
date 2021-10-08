package com.kingdee.eas.mw.pay;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CostByUpdateFactory
{
    private CostByUpdateFactory()
    {
    }
    public static com.kingdee.eas.mw.pay.ICostByUpdate getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.mw.pay.ICostByUpdate)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("7A8DD31F") ,com.kingdee.eas.mw.pay.ICostByUpdate.class);
    }
    
    public static com.kingdee.eas.mw.pay.ICostByUpdate getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.ICostByUpdate)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("7A8DD31F") ,com.kingdee.eas.mw.pay.ICostByUpdate.class, objectCtx);
    }
    public static com.kingdee.eas.mw.pay.ICostByUpdate getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.ICostByUpdate)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("7A8DD31F"));
    }
    public static com.kingdee.eas.mw.pay.ICostByUpdate getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.ICostByUpdate)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("7A8DD31F"));
    }
}