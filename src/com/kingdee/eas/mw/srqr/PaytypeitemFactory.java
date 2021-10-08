package com.kingdee.eas.mw.srqr;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class PaytypeitemFactory
{
    private PaytypeitemFactory()
    {
    }
    public static com.kingdee.eas.mw.srqr.IPaytypeitem getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.mw.srqr.IPaytypeitem)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("F28E2139") ,com.kingdee.eas.mw.srqr.IPaytypeitem.class);
    }
    
    public static com.kingdee.eas.mw.srqr.IPaytypeitem getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.mw.srqr.IPaytypeitem)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("F28E2139") ,com.kingdee.eas.mw.srqr.IPaytypeitem.class, objectCtx);
    }
    public static com.kingdee.eas.mw.srqr.IPaytypeitem getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.mw.srqr.IPaytypeitem)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("F28E2139"));
    }
    public static com.kingdee.eas.mw.srqr.IPaytypeitem getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.mw.srqr.IPaytypeitem)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("F28E2139"));
    }
}