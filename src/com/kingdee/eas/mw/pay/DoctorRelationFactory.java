package com.kingdee.eas.mw.pay;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class DoctorRelationFactory
{
    private DoctorRelationFactory()
    {
    }
    public static com.kingdee.eas.mw.pay.IDoctorRelation getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IDoctorRelation)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("E851A3ED") ,com.kingdee.eas.mw.pay.IDoctorRelation.class);
    }
    
    public static com.kingdee.eas.mw.pay.IDoctorRelation getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IDoctorRelation)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("E851A3ED") ,com.kingdee.eas.mw.pay.IDoctorRelation.class, objectCtx);
    }
    public static com.kingdee.eas.mw.pay.IDoctorRelation getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IDoctorRelation)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("E851A3ED"));
    }
    public static com.kingdee.eas.mw.pay.IDoctorRelation getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IDoctorRelation)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("E851A3ED"));
    }
}