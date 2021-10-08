package com.kingdee.eas.mw.pay;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ConsultantProFactory
{
    private ConsultantProFactory()
    {
    }
    public static com.kingdee.eas.mw.pay.IConsultantPro getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IConsultantPro)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("8C7BFC40") ,com.kingdee.eas.mw.pay.IConsultantPro.class);
    }
    
    public static com.kingdee.eas.mw.pay.IConsultantPro getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IConsultantPro)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("8C7BFC40") ,com.kingdee.eas.mw.pay.IConsultantPro.class, objectCtx);
    }
    public static com.kingdee.eas.mw.pay.IConsultantPro getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IConsultantPro)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("8C7BFC40"));
    }
    public static com.kingdee.eas.mw.pay.IConsultantPro getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IConsultantPro)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("8C7BFC40"));
    }
}