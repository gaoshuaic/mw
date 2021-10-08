package com.kingdee.eas.mw.pay;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ScalingTypeFactory
{
    private ScalingTypeFactory()
    {
    }
    public static com.kingdee.eas.mw.pay.IScalingType getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IScalingType)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("1FAF8CEF") ,com.kingdee.eas.mw.pay.IScalingType.class);
    }
    
    public static com.kingdee.eas.mw.pay.IScalingType getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IScalingType)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("1FAF8CEF") ,com.kingdee.eas.mw.pay.IScalingType.class, objectCtx);
    }
    public static com.kingdee.eas.mw.pay.IScalingType getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IScalingType)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("1FAF8CEF"));
    }
    public static com.kingdee.eas.mw.pay.IScalingType getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IScalingType)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("1FAF8CEF"));
    }
}