package com.kingdee.eas.mw.pay;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class SyncDataFacadeFactory
{
    private SyncDataFacadeFactory()
    {
    }
    public static com.kingdee.eas.mw.pay.ISyncDataFacade getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.mw.pay.ISyncDataFacade)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("BD6E9991") ,com.kingdee.eas.mw.pay.ISyncDataFacade.class);
    }
    
    public static com.kingdee.eas.mw.pay.ISyncDataFacade getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.ISyncDataFacade)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("BD6E9991") ,com.kingdee.eas.mw.pay.ISyncDataFacade.class, objectCtx);
    }
    public static com.kingdee.eas.mw.pay.ISyncDataFacade getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.ISyncDataFacade)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("BD6E9991"));
    }
    public static com.kingdee.eas.mw.pay.ISyncDataFacade getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.ISyncDataFacade)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("BD6E9991"));
    }
}