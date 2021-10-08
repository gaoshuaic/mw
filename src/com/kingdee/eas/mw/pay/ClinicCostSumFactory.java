package com.kingdee.eas.mw.pay;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ClinicCostSumFactory
{
    private ClinicCostSumFactory()
    {
    }
    public static com.kingdee.eas.mw.pay.IClinicCostSum getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IClinicCostSum)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("25799344") ,com.kingdee.eas.mw.pay.IClinicCostSum.class);
    }
    
    public static com.kingdee.eas.mw.pay.IClinicCostSum getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IClinicCostSum)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("25799344") ,com.kingdee.eas.mw.pay.IClinicCostSum.class, objectCtx);
    }
    public static com.kingdee.eas.mw.pay.IClinicCostSum getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IClinicCostSum)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("25799344"));
    }
    public static com.kingdee.eas.mw.pay.IClinicCostSum getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IClinicCostSum)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("25799344"));
    }
}