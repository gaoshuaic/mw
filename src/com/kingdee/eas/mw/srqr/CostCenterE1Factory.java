package com.kingdee.eas.mw.srqr;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CostCenterE1Factory
{
    private CostCenterE1Factory()
    {
    }
    public static com.kingdee.eas.mw.srqr.ICostCenterE1 getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.mw.srqr.ICostCenterE1)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("4685B7CA") ,com.kingdee.eas.mw.srqr.ICostCenterE1.class);
    }
    
    public static com.kingdee.eas.mw.srqr.ICostCenterE1 getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.mw.srqr.ICostCenterE1)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("4685B7CA") ,com.kingdee.eas.mw.srqr.ICostCenterE1.class, objectCtx);
    }
    public static com.kingdee.eas.mw.srqr.ICostCenterE1 getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.mw.srqr.ICostCenterE1)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("4685B7CA"));
    }
    public static com.kingdee.eas.mw.srqr.ICostCenterE1 getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.mw.srqr.ICostCenterE1)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("4685B7CA"));
    }
}