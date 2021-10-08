package com.kingdee.eas.mw.srqr;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ItemCityFactory
{
    private ItemCityFactory()
    {
    }
    public static com.kingdee.eas.mw.srqr.IItemCity getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.mw.srqr.IItemCity)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("3045725A") ,com.kingdee.eas.mw.srqr.IItemCity.class);
    }
    
    public static com.kingdee.eas.mw.srqr.IItemCity getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.mw.srqr.IItemCity)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("3045725A") ,com.kingdee.eas.mw.srqr.IItemCity.class, objectCtx);
    }
    public static com.kingdee.eas.mw.srqr.IItemCity getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.mw.srqr.IItemCity)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("3045725A"));
    }
    public static com.kingdee.eas.mw.srqr.IItemCity getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.mw.srqr.IItemCity)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("3045725A"));
    }
}