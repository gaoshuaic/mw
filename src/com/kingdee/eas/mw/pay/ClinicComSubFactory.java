package com.kingdee.eas.mw.pay;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ClinicComSubFactory
{
    private ClinicComSubFactory()
    {
    }
    public static com.kingdee.eas.mw.pay.IClinicComSub getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IClinicComSub)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("E02A0439") ,com.kingdee.eas.mw.pay.IClinicComSub.class);
    }
    
    public static com.kingdee.eas.mw.pay.IClinicComSub getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IClinicComSub)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("E02A0439") ,com.kingdee.eas.mw.pay.IClinicComSub.class, objectCtx);
    }
    public static com.kingdee.eas.mw.pay.IClinicComSub getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IClinicComSub)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("E02A0439"));
    }
    public static com.kingdee.eas.mw.pay.IClinicComSub getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IClinicComSub)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("E02A0439"));
    }
}