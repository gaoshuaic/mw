package com.kingdee.eas.mw.srqr;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class StaffCityCostRelevanceFactory
{
    private StaffCityCostRelevanceFactory()
    {
    }
    public static com.kingdee.eas.mw.srqr.IStaffCityCostRelevance getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.mw.srqr.IStaffCityCostRelevance)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("2D427D9D") ,com.kingdee.eas.mw.srqr.IStaffCityCostRelevance.class);
    }
    
    public static com.kingdee.eas.mw.srqr.IStaffCityCostRelevance getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.mw.srqr.IStaffCityCostRelevance)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("2D427D9D") ,com.kingdee.eas.mw.srqr.IStaffCityCostRelevance.class, objectCtx);
    }
    public static com.kingdee.eas.mw.srqr.IStaffCityCostRelevance getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.mw.srqr.IStaffCityCostRelevance)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("2D427D9D"));
    }
    public static com.kingdee.eas.mw.srqr.IStaffCityCostRelevance getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.mw.srqr.IStaffCityCostRelevance)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("2D427D9D"));
    }
}