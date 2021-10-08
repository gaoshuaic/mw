package com.kingdee.eas.mw.srqr;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ClinicItemFactory
{
    private ClinicItemFactory()
    {
    }
    public static com.kingdee.eas.mw.srqr.IClinicItem getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.mw.srqr.IClinicItem)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("EDB11C57") ,com.kingdee.eas.mw.srqr.IClinicItem.class);
    }
    
    public static com.kingdee.eas.mw.srqr.IClinicItem getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.mw.srqr.IClinicItem)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("EDB11C57") ,com.kingdee.eas.mw.srqr.IClinicItem.class, objectCtx);
    }
    public static com.kingdee.eas.mw.srqr.IClinicItem getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.mw.srqr.IClinicItem)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("EDB11C57"));
    }
    public static com.kingdee.eas.mw.srqr.IClinicItem getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.mw.srqr.IClinicItem)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("EDB11C57"));
    }
}