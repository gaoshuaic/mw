package com.kingdee.eas.mw.pay;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ClinicUpScaleFactory
{
    private ClinicUpScaleFactory()
    {
    }
    public static com.kingdee.eas.mw.pay.IClinicUpScale getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IClinicUpScale)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("DD941F75") ,com.kingdee.eas.mw.pay.IClinicUpScale.class);
    }
    
    public static com.kingdee.eas.mw.pay.IClinicUpScale getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IClinicUpScale)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("DD941F75") ,com.kingdee.eas.mw.pay.IClinicUpScale.class, objectCtx);
    }
    public static com.kingdee.eas.mw.pay.IClinicUpScale getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IClinicUpScale)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("DD941F75"));
    }
    public static com.kingdee.eas.mw.pay.IClinicUpScale getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IClinicUpScale)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("DD941F75"));
    }
}