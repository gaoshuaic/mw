package com.kingdee.eas.mw.pay;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class DianpingDedBJFactory
{
    private DianpingDedBJFactory()
    {
    }
    public static com.kingdee.eas.mw.pay.IDianpingDedBJ getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IDianpingDedBJ)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("A5507015") ,com.kingdee.eas.mw.pay.IDianpingDedBJ.class);
    }
    
    public static com.kingdee.eas.mw.pay.IDianpingDedBJ getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IDianpingDedBJ)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("A5507015") ,com.kingdee.eas.mw.pay.IDianpingDedBJ.class, objectCtx);
    }
    public static com.kingdee.eas.mw.pay.IDianpingDedBJ getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IDianpingDedBJ)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("A5507015"));
    }
    public static com.kingdee.eas.mw.pay.IDianpingDedBJ getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IDianpingDedBJ)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("A5507015"));
    }
}