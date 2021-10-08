package com.kingdee.eas.mw.pay;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ConsultKeepFactory
{
    private ConsultKeepFactory()
    {
    }
    public static com.kingdee.eas.mw.pay.IConsultKeep getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IConsultKeep)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("1B8B6F1F") ,com.kingdee.eas.mw.pay.IConsultKeep.class);
    }
    
    public static com.kingdee.eas.mw.pay.IConsultKeep getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IConsultKeep)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("1B8B6F1F") ,com.kingdee.eas.mw.pay.IConsultKeep.class, objectCtx);
    }
    public static com.kingdee.eas.mw.pay.IConsultKeep getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IConsultKeep)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("1B8B6F1F"));
    }
    public static com.kingdee.eas.mw.pay.IConsultKeep getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IConsultKeep)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("1B8B6F1F"));
    }
}