package com.kingdee.eas.mw.srqr;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class FenTanAchieveFactory
{
    private FenTanAchieveFactory()
    {
    }
    public static com.kingdee.eas.mw.srqr.IFenTanAchieve getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.mw.srqr.IFenTanAchieve)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("34BFB6A3") ,com.kingdee.eas.mw.srqr.IFenTanAchieve.class);
    }
    
    public static com.kingdee.eas.mw.srqr.IFenTanAchieve getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.mw.srqr.IFenTanAchieve)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("34BFB6A3") ,com.kingdee.eas.mw.srqr.IFenTanAchieve.class, objectCtx);
    }
    public static com.kingdee.eas.mw.srqr.IFenTanAchieve getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.mw.srqr.IFenTanAchieve)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("34BFB6A3"));
    }
    public static com.kingdee.eas.mw.srqr.IFenTanAchieve getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.mw.srqr.IFenTanAchieve)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("34BFB6A3"));
    }
}