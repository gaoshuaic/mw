package com.kingdee.eas.mw.srqr;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class PaytypecategoryFactory
{
    private PaytypecategoryFactory()
    {
    }
    public static com.kingdee.eas.mw.srqr.IPaytypecategory getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.mw.srqr.IPaytypecategory)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("8CB3E024") ,com.kingdee.eas.mw.srqr.IPaytypecategory.class);
    }
    
    public static com.kingdee.eas.mw.srqr.IPaytypecategory getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.mw.srqr.IPaytypecategory)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("8CB3E024") ,com.kingdee.eas.mw.srqr.IPaytypecategory.class, objectCtx);
    }
    public static com.kingdee.eas.mw.srqr.IPaytypecategory getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.mw.srqr.IPaytypecategory)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("8CB3E024"));
    }
    public static com.kingdee.eas.mw.srqr.IPaytypecategory getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.mw.srqr.IPaytypecategory)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("8CB3E024"));
    }
}