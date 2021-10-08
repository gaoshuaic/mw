package com.kingdee.eas.mw.pay;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ScalingBonusFactory
{
    private ScalingBonusFactory()
    {
    }
    public static com.kingdee.eas.mw.pay.IScalingBonus getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IScalingBonus)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("D53FD90A") ,com.kingdee.eas.mw.pay.IScalingBonus.class);
    }
    
    public static com.kingdee.eas.mw.pay.IScalingBonus getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IScalingBonus)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("D53FD90A") ,com.kingdee.eas.mw.pay.IScalingBonus.class, objectCtx);
    }
    public static com.kingdee.eas.mw.pay.IScalingBonus getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IScalingBonus)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("D53FD90A"));
    }
    public static com.kingdee.eas.mw.pay.IScalingBonus getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IScalingBonus)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("D53FD90A"));
    }
}