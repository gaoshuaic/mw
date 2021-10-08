package com.kingdee.eas.mw.pay;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class BaoDiImpMoneyFactory
{
    private BaoDiImpMoneyFactory()
    {
    }
    public static com.kingdee.eas.mw.pay.IBaoDiImpMoney getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IBaoDiImpMoney)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("6C26B637") ,com.kingdee.eas.mw.pay.IBaoDiImpMoney.class);
    }
    
    public static com.kingdee.eas.mw.pay.IBaoDiImpMoney getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IBaoDiImpMoney)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("6C26B637") ,com.kingdee.eas.mw.pay.IBaoDiImpMoney.class, objectCtx);
    }
    public static com.kingdee.eas.mw.pay.IBaoDiImpMoney getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IBaoDiImpMoney)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("6C26B637"));
    }
    public static com.kingdee.eas.mw.pay.IBaoDiImpMoney getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IBaoDiImpMoney)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("6C26B637"));
    }
}