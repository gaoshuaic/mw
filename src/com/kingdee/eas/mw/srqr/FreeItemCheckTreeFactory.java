package com.kingdee.eas.mw.srqr;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class FreeItemCheckTreeFactory
{
    private FreeItemCheckTreeFactory()
    {
    }
    public static com.kingdee.eas.mw.srqr.IFreeItemCheckTree getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.mw.srqr.IFreeItemCheckTree)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("6D8D942B") ,com.kingdee.eas.mw.srqr.IFreeItemCheckTree.class);
    }
    
    public static com.kingdee.eas.mw.srqr.IFreeItemCheckTree getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.mw.srqr.IFreeItemCheckTree)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("6D8D942B") ,com.kingdee.eas.mw.srqr.IFreeItemCheckTree.class, objectCtx);
    }
    public static com.kingdee.eas.mw.srqr.IFreeItemCheckTree getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.mw.srqr.IFreeItemCheckTree)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("6D8D942B"));
    }
    public static com.kingdee.eas.mw.srqr.IFreeItemCheckTree getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.mw.srqr.IFreeItemCheckTree)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("6D8D942B"));
    }
}