package com.kingdee.eas.mw.pay;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class AchieveDetailTemFactory
{
    private AchieveDetailTemFactory()
    {
    }
    public static com.kingdee.eas.mw.pay.IAchieveDetailTem getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IAchieveDetailTem)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("69F141EC") ,com.kingdee.eas.mw.pay.IAchieveDetailTem.class);
    }
    
    public static com.kingdee.eas.mw.pay.IAchieveDetailTem getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IAchieveDetailTem)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("69F141EC") ,com.kingdee.eas.mw.pay.IAchieveDetailTem.class, objectCtx);
    }
    public static com.kingdee.eas.mw.pay.IAchieveDetailTem getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IAchieveDetailTem)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("69F141EC"));
    }
    public static com.kingdee.eas.mw.pay.IAchieveDetailTem getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IAchieveDetailTem)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("69F141EC"));
    }
}