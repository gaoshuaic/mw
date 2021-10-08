package com.kingdee.eas.mw.pay;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class PayCityEntryFactory
{
    private PayCityEntryFactory()
    {
    }
    public static com.kingdee.eas.mw.pay.IPayCityEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IPayCityEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("1894DE31") ,com.kingdee.eas.mw.pay.IPayCityEntry.class);
    }
    
    public static com.kingdee.eas.mw.pay.IPayCityEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IPayCityEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("1894DE31") ,com.kingdee.eas.mw.pay.IPayCityEntry.class, objectCtx);
    }
    public static com.kingdee.eas.mw.pay.IPayCityEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IPayCityEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("1894DE31"));
    }
    public static com.kingdee.eas.mw.pay.IPayCityEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IPayCityEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("1894DE31"));
    }
}