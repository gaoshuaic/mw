package com.kingdee.eas.mw.srqr;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class SaleIssueSyncFacadeFactory
{
    private SaleIssueSyncFacadeFactory()
    {
    }
    public static com.kingdee.eas.mw.srqr.ISaleIssueSyncFacade getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.mw.srqr.ISaleIssueSyncFacade)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("4847D8CB") ,com.kingdee.eas.mw.srqr.ISaleIssueSyncFacade.class);
    }
    
    public static com.kingdee.eas.mw.srqr.ISaleIssueSyncFacade getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.mw.srqr.ISaleIssueSyncFacade)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("4847D8CB") ,com.kingdee.eas.mw.srqr.ISaleIssueSyncFacade.class, objectCtx);
    }
    public static com.kingdee.eas.mw.srqr.ISaleIssueSyncFacade getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.mw.srqr.ISaleIssueSyncFacade)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("4847D8CB"));
    }
    public static com.kingdee.eas.mw.srqr.ISaleIssueSyncFacade getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.mw.srqr.ISaleIssueSyncFacade)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("4847D8CB"));
    }
}