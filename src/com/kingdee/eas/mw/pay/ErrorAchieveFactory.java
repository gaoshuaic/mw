package com.kingdee.eas.mw.pay;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ErrorAchieveFactory
{
    private ErrorAchieveFactory()
    {
    }
    public static com.kingdee.eas.mw.pay.IErrorAchieve getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IErrorAchieve)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("6E507F5B") ,com.kingdee.eas.mw.pay.IErrorAchieve.class);
    }
    
    public static com.kingdee.eas.mw.pay.IErrorAchieve getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IErrorAchieve)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("6E507F5B") ,com.kingdee.eas.mw.pay.IErrorAchieve.class, objectCtx);
    }
    public static com.kingdee.eas.mw.pay.IErrorAchieve getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IErrorAchieve)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("6E507F5B"));
    }
    public static com.kingdee.eas.mw.pay.IErrorAchieve getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IErrorAchieve)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("6E507F5B"));
    }
}