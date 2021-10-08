package com.kingdee.eas.mw.srqr;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ItemCheckEntryFactory
{
    private ItemCheckEntryFactory()
    {
    }
    public static com.kingdee.eas.mw.srqr.IItemCheckEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.mw.srqr.IItemCheckEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("CC3041F9") ,com.kingdee.eas.mw.srqr.IItemCheckEntry.class);
    }
    
    public static com.kingdee.eas.mw.srqr.IItemCheckEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.mw.srqr.IItemCheckEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("CC3041F9") ,com.kingdee.eas.mw.srqr.IItemCheckEntry.class, objectCtx);
    }
    public static com.kingdee.eas.mw.srqr.IItemCheckEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.mw.srqr.IItemCheckEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("CC3041F9"));
    }
    public static com.kingdee.eas.mw.srqr.IItemCheckEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.mw.srqr.IItemCheckEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("CC3041F9"));
    }
}