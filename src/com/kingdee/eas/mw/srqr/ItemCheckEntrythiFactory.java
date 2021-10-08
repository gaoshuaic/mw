package com.kingdee.eas.mw.srqr;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ItemCheckEntrythiFactory
{
    private ItemCheckEntrythiFactory()
    {
    }
    public static com.kingdee.eas.mw.srqr.IItemCheckEntrythi getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.mw.srqr.IItemCheckEntrythi)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("A3CF0FDC") ,com.kingdee.eas.mw.srqr.IItemCheckEntrythi.class);
    }
    
    public static com.kingdee.eas.mw.srqr.IItemCheckEntrythi getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.mw.srqr.IItemCheckEntrythi)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("A3CF0FDC") ,com.kingdee.eas.mw.srqr.IItemCheckEntrythi.class, objectCtx);
    }
    public static com.kingdee.eas.mw.srqr.IItemCheckEntrythi getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.mw.srqr.IItemCheckEntrythi)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("A3CF0FDC"));
    }
    public static com.kingdee.eas.mw.srqr.IItemCheckEntrythi getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.mw.srqr.IItemCheckEntrythi)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("A3CF0FDC"));
    }
}