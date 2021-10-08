package com.kingdee.eas.mw.srqr;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CityMarketAchieveFactory
{
    private CityMarketAchieveFactory()
    {
    }
    public static com.kingdee.eas.mw.srqr.ICityMarketAchieve getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.mw.srqr.ICityMarketAchieve)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("64A8C70E") ,com.kingdee.eas.mw.srqr.ICityMarketAchieve.class);
    }
    
    public static com.kingdee.eas.mw.srqr.ICityMarketAchieve getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.mw.srqr.ICityMarketAchieve)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("64A8C70E") ,com.kingdee.eas.mw.srqr.ICityMarketAchieve.class, objectCtx);
    }
    public static com.kingdee.eas.mw.srqr.ICityMarketAchieve getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.mw.srqr.ICityMarketAchieve)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("64A8C70E"));
    }
    public static com.kingdee.eas.mw.srqr.ICityMarketAchieve getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.mw.srqr.ICityMarketAchieve)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("64A8C70E"));
    }
}