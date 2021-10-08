package com.kingdee.eas.mw.srqr;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class TagTreeFactory
{
    private TagTreeFactory()
    {
    }
    public static com.kingdee.eas.mw.srqr.ITagTree getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.mw.srqr.ITagTree)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("FDCE479C") ,com.kingdee.eas.mw.srqr.ITagTree.class);
    }
    
    public static com.kingdee.eas.mw.srqr.ITagTree getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.mw.srqr.ITagTree)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("FDCE479C") ,com.kingdee.eas.mw.srqr.ITagTree.class, objectCtx);
    }
    public static com.kingdee.eas.mw.srqr.ITagTree getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.mw.srqr.ITagTree)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("FDCE479C"));
    }
    public static com.kingdee.eas.mw.srqr.ITagTree getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.mw.srqr.ITagTree)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("FDCE479C"));
    }
}