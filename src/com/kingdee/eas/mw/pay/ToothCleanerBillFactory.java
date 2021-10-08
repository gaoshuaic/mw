package com.kingdee.eas.mw.pay;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ToothCleanerBillFactory
{
    private ToothCleanerBillFactory()
    {
    }
    public static com.kingdee.eas.mw.pay.IToothCleanerBill getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IToothCleanerBill)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("2D6E9127") ,com.kingdee.eas.mw.pay.IToothCleanerBill.class);
    }
    
    public static com.kingdee.eas.mw.pay.IToothCleanerBill getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IToothCleanerBill)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("2D6E9127") ,com.kingdee.eas.mw.pay.IToothCleanerBill.class, objectCtx);
    }
    public static com.kingdee.eas.mw.pay.IToothCleanerBill getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IToothCleanerBill)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("2D6E9127"));
    }
    public static com.kingdee.eas.mw.pay.IToothCleanerBill getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IToothCleanerBill)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("2D6E9127"));
    }
}