package com.kingdee.eas.mw.pay;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ConsultantBonusUpdateFactory
{
    private ConsultantBonusUpdateFactory()
    {
    }
    public static com.kingdee.eas.mw.pay.IConsultantBonusUpdate getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IConsultantBonusUpdate)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("8EF4785B") ,com.kingdee.eas.mw.pay.IConsultantBonusUpdate.class);
    }
    
    public static com.kingdee.eas.mw.pay.IConsultantBonusUpdate getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IConsultantBonusUpdate)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("8EF4785B") ,com.kingdee.eas.mw.pay.IConsultantBonusUpdate.class, objectCtx);
    }
    public static com.kingdee.eas.mw.pay.IConsultantBonusUpdate getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IConsultantBonusUpdate)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("8EF4785B"));
    }
    public static com.kingdee.eas.mw.pay.IConsultantBonusUpdate getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IConsultantBonusUpdate)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("8EF4785B"));
    }
}