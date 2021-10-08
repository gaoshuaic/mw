package com.kingdee.eas.mw.pay;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class DocHISBiLiFactory
{
    private DocHISBiLiFactory()
    {
    }
    public static com.kingdee.eas.mw.pay.IDocHISBiLi getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IDocHISBiLi)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("D3693B30") ,com.kingdee.eas.mw.pay.IDocHISBiLi.class);
    }
    
    public static com.kingdee.eas.mw.pay.IDocHISBiLi getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IDocHISBiLi)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("D3693B30") ,com.kingdee.eas.mw.pay.IDocHISBiLi.class, objectCtx);
    }
    public static com.kingdee.eas.mw.pay.IDocHISBiLi getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IDocHISBiLi)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("D3693B30"));
    }
    public static com.kingdee.eas.mw.pay.IDocHISBiLi getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IDocHISBiLi)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("D3693B30"));
    }
}