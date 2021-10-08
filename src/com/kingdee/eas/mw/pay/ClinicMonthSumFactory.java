package com.kingdee.eas.mw.pay;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ClinicMonthSumFactory
{
    private ClinicMonthSumFactory()
    {
    }
    public static com.kingdee.eas.mw.pay.IClinicMonthSum getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IClinicMonthSum)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("90056865") ,com.kingdee.eas.mw.pay.IClinicMonthSum.class);
    }
    
    public static com.kingdee.eas.mw.pay.IClinicMonthSum getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IClinicMonthSum)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("90056865") ,com.kingdee.eas.mw.pay.IClinicMonthSum.class, objectCtx);
    }
    public static com.kingdee.eas.mw.pay.IClinicMonthSum getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IClinicMonthSum)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("90056865"));
    }
    public static com.kingdee.eas.mw.pay.IClinicMonthSum getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IClinicMonthSum)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("90056865"));
    }
}