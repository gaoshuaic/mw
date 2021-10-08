package com.kingdee.eas.mw.srqr;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ItemTypeFactory
{
    private ItemTypeFactory()
    {
    }
    public static com.kingdee.eas.mw.srqr.IItemType getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.mw.srqr.IItemType)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("304D6829") ,com.kingdee.eas.mw.srqr.IItemType.class);
    }
    
    public static com.kingdee.eas.mw.srqr.IItemType getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.mw.srqr.IItemType)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("304D6829") ,com.kingdee.eas.mw.srqr.IItemType.class, objectCtx);
    }
    public static com.kingdee.eas.mw.srqr.IItemType getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.mw.srqr.IItemType)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("304D6829"));
    }
    public static com.kingdee.eas.mw.srqr.IItemType getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.mw.srqr.IItemType)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("304D6829"));
    }
}