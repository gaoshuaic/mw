package com.kingdee.eas.mw.pay;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class PayCityFactory
{
    private PayCityFactory()
    {
    }
    public static com.kingdee.eas.mw.pay.IPayCity getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IPayCity)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("F5B0CAC1") ,com.kingdee.eas.mw.pay.IPayCity.class);
    }
    
    public static com.kingdee.eas.mw.pay.IPayCity getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IPayCity)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("F5B0CAC1") ,com.kingdee.eas.mw.pay.IPayCity.class, objectCtx);
    }
    public static com.kingdee.eas.mw.pay.IPayCity getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IPayCity)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("F5B0CAC1"));
    }
    public static com.kingdee.eas.mw.pay.IPayCity getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IPayCity)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("F5B0CAC1"));
    }
}