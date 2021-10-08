package com.kingdee.eas.mw.pay;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class SpecialDocFactory
{
    private SpecialDocFactory()
    {
    }
    public static com.kingdee.eas.mw.pay.ISpecialDoc getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.mw.pay.ISpecialDoc)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("5378D271") ,com.kingdee.eas.mw.pay.ISpecialDoc.class);
    }
    
    public static com.kingdee.eas.mw.pay.ISpecialDoc getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.ISpecialDoc)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("5378D271") ,com.kingdee.eas.mw.pay.ISpecialDoc.class, objectCtx);
    }
    public static com.kingdee.eas.mw.pay.ISpecialDoc getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.ISpecialDoc)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("5378D271"));
    }
    public static com.kingdee.eas.mw.pay.ISpecialDoc getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.ISpecialDoc)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("5378D271"));
    }
}