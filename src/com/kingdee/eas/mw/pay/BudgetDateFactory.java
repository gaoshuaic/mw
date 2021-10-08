package com.kingdee.eas.mw.pay;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class BudgetDateFactory
{
    private BudgetDateFactory()
    {
    }
    public static com.kingdee.eas.mw.pay.IBudgetDate getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IBudgetDate)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("65CCD545") ,com.kingdee.eas.mw.pay.IBudgetDate.class);
    }
    
    public static com.kingdee.eas.mw.pay.IBudgetDate getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IBudgetDate)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("65CCD545") ,com.kingdee.eas.mw.pay.IBudgetDate.class, objectCtx);
    }
    public static com.kingdee.eas.mw.pay.IBudgetDate getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IBudgetDate)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("65CCD545"));
    }
    public static com.kingdee.eas.mw.pay.IBudgetDate getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IBudgetDate)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("65CCD545"));
    }
}