package com.kingdee.eas.mw.pay;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class WhiteProportionFactory
{
    private WhiteProportionFactory()
    {
    }
    public static com.kingdee.eas.mw.pay.IWhiteProportion getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IWhiteProportion)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("773C8031") ,com.kingdee.eas.mw.pay.IWhiteProportion.class);
    }
    
    public static com.kingdee.eas.mw.pay.IWhiteProportion getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IWhiteProportion)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("773C8031") ,com.kingdee.eas.mw.pay.IWhiteProportion.class, objectCtx);
    }
    public static com.kingdee.eas.mw.pay.IWhiteProportion getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IWhiteProportion)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("773C8031"));
    }
    public static com.kingdee.eas.mw.pay.IWhiteProportion getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IWhiteProportion)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("773C8031"));
    }
}