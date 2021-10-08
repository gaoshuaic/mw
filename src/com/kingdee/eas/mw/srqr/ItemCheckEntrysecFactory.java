package com.kingdee.eas.mw.srqr;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ItemCheckEntrysecFactory
{
    private ItemCheckEntrysecFactory()
    {
    }
    public static com.kingdee.eas.mw.srqr.IItemCheckEntrysec getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.mw.srqr.IItemCheckEntrysec)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("A3CF0BB8") ,com.kingdee.eas.mw.srqr.IItemCheckEntrysec.class);
    }
    
    public static com.kingdee.eas.mw.srqr.IItemCheckEntrysec getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.mw.srqr.IItemCheckEntrysec)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("A3CF0BB8") ,com.kingdee.eas.mw.srqr.IItemCheckEntrysec.class, objectCtx);
    }
    public static com.kingdee.eas.mw.srqr.IItemCheckEntrysec getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.mw.srqr.IItemCheckEntrysec)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("A3CF0BB8"));
    }
    public static com.kingdee.eas.mw.srqr.IItemCheckEntrysec getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.mw.srqr.IItemCheckEntrysec)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("A3CF0BB8"));
    }
}