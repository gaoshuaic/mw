package com.kingdee.eas.mw.pay;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CommentMessageFactory
{
    private CommentMessageFactory()
    {
    }
    public static com.kingdee.eas.mw.pay.ICommentMessage getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.mw.pay.ICommentMessage)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("3090D45A") ,com.kingdee.eas.mw.pay.ICommentMessage.class);
    }
    
    public static com.kingdee.eas.mw.pay.ICommentMessage getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.ICommentMessage)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("3090D45A") ,com.kingdee.eas.mw.pay.ICommentMessage.class, objectCtx);
    }
    public static com.kingdee.eas.mw.pay.ICommentMessage getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.ICommentMessage)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("3090D45A"));
    }
    public static com.kingdee.eas.mw.pay.ICommentMessage getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.ICommentMessage)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("3090D45A"));
    }
}