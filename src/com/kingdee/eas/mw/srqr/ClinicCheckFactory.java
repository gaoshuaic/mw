package com.kingdee.eas.mw.srqr;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ClinicCheckFactory
{
    private ClinicCheckFactory()
    {
    }
    public static com.kingdee.eas.mw.srqr.IClinicCheck getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.mw.srqr.IClinicCheck)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("C8186C44") ,com.kingdee.eas.mw.srqr.IClinicCheck.class);
    }
    
    public static com.kingdee.eas.mw.srqr.IClinicCheck getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.mw.srqr.IClinicCheck)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("C8186C44") ,com.kingdee.eas.mw.srqr.IClinicCheck.class, objectCtx);
    }
    public static com.kingdee.eas.mw.srqr.IClinicCheck getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.mw.srqr.IClinicCheck)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("C8186C44"));
    }
    public static com.kingdee.eas.mw.srqr.IClinicCheck getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.mw.srqr.IClinicCheck)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("C8186C44"));
    }
}