package com.kingdee.eas.mw.srqr;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class SaleIssueHisLogEntryFactory
{
    private SaleIssueHisLogEntryFactory()
    {
    }
    public static com.kingdee.eas.mw.srqr.ISaleIssueHisLogEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.mw.srqr.ISaleIssueHisLogEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("27DF9A4A") ,com.kingdee.eas.mw.srqr.ISaleIssueHisLogEntry.class);
    }
    
    public static com.kingdee.eas.mw.srqr.ISaleIssueHisLogEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.mw.srqr.ISaleIssueHisLogEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("27DF9A4A") ,com.kingdee.eas.mw.srqr.ISaleIssueHisLogEntry.class, objectCtx);
    }
    public static com.kingdee.eas.mw.srqr.ISaleIssueHisLogEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.mw.srqr.ISaleIssueHisLogEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("27DF9A4A"));
    }
    public static com.kingdee.eas.mw.srqr.ISaleIssueHisLogEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.mw.srqr.ISaleIssueHisLogEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("27DF9A4A"));
    }
}