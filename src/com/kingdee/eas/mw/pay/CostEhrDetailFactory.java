package com.kingdee.eas.mw.pay;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CostEhrDetailFactory
{
    private CostEhrDetailFactory()
    {
    }
    public static com.kingdee.eas.mw.pay.ICostEhrDetail getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.mw.pay.ICostEhrDetail)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("611BD221") ,com.kingdee.eas.mw.pay.ICostEhrDetail.class);
    }
    
    public static com.kingdee.eas.mw.pay.ICostEhrDetail getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.ICostEhrDetail)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("611BD221") ,com.kingdee.eas.mw.pay.ICostEhrDetail.class, objectCtx);
    }
    public static com.kingdee.eas.mw.pay.ICostEhrDetail getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.ICostEhrDetail)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("611BD221"));
    }
    public static com.kingdee.eas.mw.pay.ICostEhrDetail getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.ICostEhrDetail)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("611BD221"));
    }
}