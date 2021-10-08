package com.kingdee.eas.mw.srqr;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class PostTypeFactory
{
    private PostTypeFactory()
    {
    }
    public static com.kingdee.eas.mw.srqr.IPostType getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.mw.srqr.IPostType)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("173CF736") ,com.kingdee.eas.mw.srqr.IPostType.class);
    }
    
    public static com.kingdee.eas.mw.srqr.IPostType getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.mw.srqr.IPostType)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("173CF736") ,com.kingdee.eas.mw.srqr.IPostType.class, objectCtx);
    }
    public static com.kingdee.eas.mw.srqr.IPostType getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.mw.srqr.IPostType)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("173CF736"));
    }
    public static com.kingdee.eas.mw.srqr.IPostType getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.mw.srqr.IPostType)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("173CF736"));
    }
}