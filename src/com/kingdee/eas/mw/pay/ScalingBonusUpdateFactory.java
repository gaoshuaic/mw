package com.kingdee.eas.mw.pay;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ScalingBonusUpdateFactory
{
    private ScalingBonusUpdateFactory()
    {
    }
    public static com.kingdee.eas.mw.pay.IScalingBonusUpdate getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IScalingBonusUpdate)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("7A9C8E73") ,com.kingdee.eas.mw.pay.IScalingBonusUpdate.class);
    }
    
    public static com.kingdee.eas.mw.pay.IScalingBonusUpdate getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IScalingBonusUpdate)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("7A9C8E73") ,com.kingdee.eas.mw.pay.IScalingBonusUpdate.class, objectCtx);
    }
    public static com.kingdee.eas.mw.pay.IScalingBonusUpdate getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IScalingBonusUpdate)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("7A9C8E73"));
    }
    public static com.kingdee.eas.mw.pay.IScalingBonusUpdate getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IScalingBonusUpdate)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("7A9C8E73"));
    }
}