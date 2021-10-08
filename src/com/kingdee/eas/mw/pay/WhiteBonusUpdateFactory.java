package com.kingdee.eas.mw.pay;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class WhiteBonusUpdateFactory
{
    private WhiteBonusUpdateFactory()
    {
    }
    public static com.kingdee.eas.mw.pay.IWhiteBonusUpdate getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IWhiteBonusUpdate)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("83F86911") ,com.kingdee.eas.mw.pay.IWhiteBonusUpdate.class);
    }
    
    public static com.kingdee.eas.mw.pay.IWhiteBonusUpdate getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IWhiteBonusUpdate)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("83F86911") ,com.kingdee.eas.mw.pay.IWhiteBonusUpdate.class, objectCtx);
    }
    public static com.kingdee.eas.mw.pay.IWhiteBonusUpdate getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IWhiteBonusUpdate)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("83F86911"));
    }
    public static com.kingdee.eas.mw.pay.IWhiteBonusUpdate getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IWhiteBonusUpdate)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("83F86911"));
    }
}