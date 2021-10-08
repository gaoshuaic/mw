package com.kingdee.eas.mw.srqr;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class SaleIssueHisLogFactory
{
    private SaleIssueHisLogFactory()
    {
    }
    public static com.kingdee.eas.mw.srqr.ISaleIssueHisLog getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.mw.srqr.ISaleIssueHisLog)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("EE852308") ,com.kingdee.eas.mw.srqr.ISaleIssueHisLog.class);
    }
    
    public static com.kingdee.eas.mw.srqr.ISaleIssueHisLog getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.mw.srqr.ISaleIssueHisLog)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("EE852308") ,com.kingdee.eas.mw.srqr.ISaleIssueHisLog.class, objectCtx);
    }
    public static com.kingdee.eas.mw.srqr.ISaleIssueHisLog getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.mw.srqr.ISaleIssueHisLog)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("EE852308"));
    }
    public static com.kingdee.eas.mw.srqr.ISaleIssueHisLog getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.mw.srqr.ISaleIssueHisLog)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("EE852308"));
    }
}