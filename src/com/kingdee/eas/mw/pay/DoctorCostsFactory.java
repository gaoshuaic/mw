package com.kingdee.eas.mw.pay;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class DoctorCostsFactory
{
    private DoctorCostsFactory()
    {
    }
    public static com.kingdee.eas.mw.pay.IDoctorCosts getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IDoctorCosts)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("83964DF5") ,com.kingdee.eas.mw.pay.IDoctorCosts.class);
    }
    
    public static com.kingdee.eas.mw.pay.IDoctorCosts getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IDoctorCosts)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("83964DF5") ,com.kingdee.eas.mw.pay.IDoctorCosts.class, objectCtx);
    }
    public static com.kingdee.eas.mw.pay.IDoctorCosts getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IDoctorCosts)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("83964DF5"));
    }
    public static com.kingdee.eas.mw.pay.IDoctorCosts getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IDoctorCosts)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("83964DF5"));
    }
}