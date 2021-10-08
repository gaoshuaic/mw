package com.kingdee.eas.mw.pay;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CostDetailFactory
{
    private CostDetailFactory()
    {
    }
    public static com.kingdee.eas.mw.pay.ICostDetail getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.mw.pay.ICostDetail)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("6D50D330") ,com.kingdee.eas.mw.pay.ICostDetail.class);
    }
    
    public static com.kingdee.eas.mw.pay.ICostDetail getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.ICostDetail)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("6D50D330") ,com.kingdee.eas.mw.pay.ICostDetail.class, objectCtx);
    }
    public static com.kingdee.eas.mw.pay.ICostDetail getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.ICostDetail)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("6D50D330"));
    }
    public static com.kingdee.eas.mw.pay.ICostDetail getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.ICostDetail)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("6D50D330"));
    }
}