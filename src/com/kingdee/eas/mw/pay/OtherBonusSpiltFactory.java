package com.kingdee.eas.mw.pay;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class OtherBonusSpiltFactory
{
    private OtherBonusSpiltFactory()
    {
    }
    public static com.kingdee.eas.mw.pay.IOtherBonusSpilt getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IOtherBonusSpilt)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("F9613513") ,com.kingdee.eas.mw.pay.IOtherBonusSpilt.class);
    }
    
    public static com.kingdee.eas.mw.pay.IOtherBonusSpilt getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IOtherBonusSpilt)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("F9613513") ,com.kingdee.eas.mw.pay.IOtherBonusSpilt.class, objectCtx);
    }
    public static com.kingdee.eas.mw.pay.IOtherBonusSpilt getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IOtherBonusSpilt)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("F9613513"));
    }
    public static com.kingdee.eas.mw.pay.IOtherBonusSpilt getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IOtherBonusSpilt)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("F9613513"));
    }
}