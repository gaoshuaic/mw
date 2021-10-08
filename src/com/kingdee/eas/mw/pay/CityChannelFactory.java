package com.kingdee.eas.mw.pay;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CityChannelFactory
{
    private CityChannelFactory()
    {
    }
    public static com.kingdee.eas.mw.pay.ICityChannel getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.mw.pay.ICityChannel)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("EDEDC6A6") ,com.kingdee.eas.mw.pay.ICityChannel.class);
    }
    
    public static com.kingdee.eas.mw.pay.ICityChannel getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.ICityChannel)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("EDEDC6A6") ,com.kingdee.eas.mw.pay.ICityChannel.class, objectCtx);
    }
    public static com.kingdee.eas.mw.pay.ICityChannel getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.ICityChannel)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("EDEDC6A6"));
    }
    public static com.kingdee.eas.mw.pay.ICityChannel getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.ICityChannel)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("EDEDC6A6"));
    }
}