package com.kingdee.eas.mw.srqr;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class TagFactory
{
    private TagFactory()
    {
    }
    public static com.kingdee.eas.mw.srqr.ITag getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.mw.srqr.ITag)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("641CFEDE") ,com.kingdee.eas.mw.srqr.ITag.class);
    }
    
    public static com.kingdee.eas.mw.srqr.ITag getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.mw.srqr.ITag)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("641CFEDE") ,com.kingdee.eas.mw.srqr.ITag.class, objectCtx);
    }
    public static com.kingdee.eas.mw.srqr.ITag getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.mw.srqr.ITag)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("641CFEDE"));
    }
    public static com.kingdee.eas.mw.srqr.ITag getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.mw.srqr.ITag)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("641CFEDE"));
    }
}