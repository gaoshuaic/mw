package com.kingdee.eas.mw.pay;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ConsultTypeFactory
{
    private ConsultTypeFactory()
    {
    }
    public static com.kingdee.eas.mw.pay.IConsultType getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IConsultType)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("1B8FD2D4") ,com.kingdee.eas.mw.pay.IConsultType.class);
    }
    
    public static com.kingdee.eas.mw.pay.IConsultType getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IConsultType)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("1B8FD2D4") ,com.kingdee.eas.mw.pay.IConsultType.class, objectCtx);
    }
    public static com.kingdee.eas.mw.pay.IConsultType getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IConsultType)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("1B8FD2D4"));
    }
    public static com.kingdee.eas.mw.pay.IConsultType getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IConsultType)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("1B8FD2D4"));
    }
}