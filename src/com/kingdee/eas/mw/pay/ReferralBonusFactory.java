package com.kingdee.eas.mw.pay;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ReferralBonusFactory
{
    private ReferralBonusFactory()
    {
    }
    public static com.kingdee.eas.mw.pay.IReferralBonus getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IReferralBonus)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("0BC9EC90") ,com.kingdee.eas.mw.pay.IReferralBonus.class);
    }
    
    public static com.kingdee.eas.mw.pay.IReferralBonus getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IReferralBonus)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("0BC9EC90") ,com.kingdee.eas.mw.pay.IReferralBonus.class, objectCtx);
    }
    public static com.kingdee.eas.mw.pay.IReferralBonus getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IReferralBonus)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("0BC9EC90"));
    }
    public static com.kingdee.eas.mw.pay.IReferralBonus getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IReferralBonus)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("0BC9EC90"));
    }
}