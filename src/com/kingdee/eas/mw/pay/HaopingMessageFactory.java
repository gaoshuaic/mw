package com.kingdee.eas.mw.pay;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class HaopingMessageFactory
{
    private HaopingMessageFactory()
    {
    }
    public static com.kingdee.eas.mw.pay.IHaopingMessage getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IHaopingMessage)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("E7834991") ,com.kingdee.eas.mw.pay.IHaopingMessage.class);
    }
    
    public static com.kingdee.eas.mw.pay.IHaopingMessage getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IHaopingMessage)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("E7834991") ,com.kingdee.eas.mw.pay.IHaopingMessage.class, objectCtx);
    }
    public static com.kingdee.eas.mw.pay.IHaopingMessage getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IHaopingMessage)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("E7834991"));
    }
    public static com.kingdee.eas.mw.pay.IHaopingMessage getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IHaopingMessage)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("E7834991"));
    }
}