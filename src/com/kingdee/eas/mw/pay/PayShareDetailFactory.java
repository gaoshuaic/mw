package com.kingdee.eas.mw.pay;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class PayShareDetailFactory
{
    private PayShareDetailFactory()
    {
    }
    public static com.kingdee.eas.mw.pay.IPayShareDetail getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IPayShareDetail)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("1CE472FA") ,com.kingdee.eas.mw.pay.IPayShareDetail.class);
    }
    
    public static com.kingdee.eas.mw.pay.IPayShareDetail getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IPayShareDetail)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("1CE472FA") ,com.kingdee.eas.mw.pay.IPayShareDetail.class, objectCtx);
    }
    public static com.kingdee.eas.mw.pay.IPayShareDetail getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IPayShareDetail)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("1CE472FA"));
    }
    public static com.kingdee.eas.mw.pay.IPayShareDetail getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IPayShareDetail)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("1CE472FA"));
    }
}