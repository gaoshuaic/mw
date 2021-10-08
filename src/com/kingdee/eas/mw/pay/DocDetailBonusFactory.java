package com.kingdee.eas.mw.pay;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class DocDetailBonusFactory
{
    private DocDetailBonusFactory()
    {
    }
    public static com.kingdee.eas.mw.pay.IDocDetailBonus getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IDocDetailBonus)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("832E15A8") ,com.kingdee.eas.mw.pay.IDocDetailBonus.class);
    }
    
    public static com.kingdee.eas.mw.pay.IDocDetailBonus getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IDocDetailBonus)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("832E15A8") ,com.kingdee.eas.mw.pay.IDocDetailBonus.class, objectCtx);
    }
    public static com.kingdee.eas.mw.pay.IDocDetailBonus getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IDocDetailBonus)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("832E15A8"));
    }
    public static com.kingdee.eas.mw.pay.IDocDetailBonus getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IDocDetailBonus)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("832E15A8"));
    }
}