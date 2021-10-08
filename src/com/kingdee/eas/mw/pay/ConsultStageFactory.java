package com.kingdee.eas.mw.pay;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ConsultStageFactory
{
    private ConsultStageFactory()
    {
    }
    public static com.kingdee.eas.mw.pay.IConsultStage getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IConsultStage)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("5659F2A4") ,com.kingdee.eas.mw.pay.IConsultStage.class);
    }
    
    public static com.kingdee.eas.mw.pay.IConsultStage getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IConsultStage)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("5659F2A4") ,com.kingdee.eas.mw.pay.IConsultStage.class, objectCtx);
    }
    public static com.kingdee.eas.mw.pay.IConsultStage getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IConsultStage)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("5659F2A4"));
    }
    public static com.kingdee.eas.mw.pay.IConsultStage getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IConsultStage)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("5659F2A4"));
    }
}