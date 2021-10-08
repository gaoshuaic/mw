package com.kingdee.eas.mw.srqr;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CityCompanyTargetFactory
{
    private CityCompanyTargetFactory()
    {
    }
    public static com.kingdee.eas.mw.srqr.ICityCompanyTarget getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.mw.srqr.ICityCompanyTarget)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("14463D07") ,com.kingdee.eas.mw.srqr.ICityCompanyTarget.class);
    }
    
    public static com.kingdee.eas.mw.srqr.ICityCompanyTarget getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.mw.srqr.ICityCompanyTarget)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("14463D07") ,com.kingdee.eas.mw.srqr.ICityCompanyTarget.class, objectCtx);
    }
    public static com.kingdee.eas.mw.srqr.ICityCompanyTarget getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.mw.srqr.ICityCompanyTarget)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("14463D07"));
    }
    public static com.kingdee.eas.mw.srqr.ICityCompanyTarget getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.mw.srqr.ICityCompanyTarget)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("14463D07"));
    }
}