package com.kingdee.eas.mw.pay;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class HolderDataSourceFactory
{
    private HolderDataSourceFactory()
    {
    }
    public static com.kingdee.eas.mw.pay.IHolderDataSource getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IHolderDataSource)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("B665FE63") ,com.kingdee.eas.mw.pay.IHolderDataSource.class);
    }
    
    public static com.kingdee.eas.mw.pay.IHolderDataSource getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IHolderDataSource)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("B665FE63") ,com.kingdee.eas.mw.pay.IHolderDataSource.class, objectCtx);
    }
    public static com.kingdee.eas.mw.pay.IHolderDataSource getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IHolderDataSource)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("B665FE63"));
    }
    public static com.kingdee.eas.mw.pay.IHolderDataSource getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IHolderDataSource)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("B665FE63"));
    }
}