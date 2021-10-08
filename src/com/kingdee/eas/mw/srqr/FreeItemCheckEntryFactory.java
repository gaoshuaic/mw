package com.kingdee.eas.mw.srqr;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class FreeItemCheckEntryFactory
{
    private FreeItemCheckEntryFactory()
    {
    }
    public static com.kingdee.eas.mw.srqr.IFreeItemCheckEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.mw.srqr.IFreeItemCheckEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("434FF985") ,com.kingdee.eas.mw.srqr.IFreeItemCheckEntry.class);
    }
    
    public static com.kingdee.eas.mw.srqr.IFreeItemCheckEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.mw.srqr.IFreeItemCheckEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("434FF985") ,com.kingdee.eas.mw.srqr.IFreeItemCheckEntry.class, objectCtx);
    }
    public static com.kingdee.eas.mw.srqr.IFreeItemCheckEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.mw.srqr.IFreeItemCheckEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("434FF985"));
    }
    public static com.kingdee.eas.mw.srqr.IFreeItemCheckEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.mw.srqr.IFreeItemCheckEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("434FF985"));
    }
}