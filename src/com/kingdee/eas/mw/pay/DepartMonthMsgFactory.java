package com.kingdee.eas.mw.pay;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class DepartMonthMsgFactory
{
    private DepartMonthMsgFactory()
    {
    }
    public static com.kingdee.eas.mw.pay.IDepartMonthMsg getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IDepartMonthMsg)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("01ACB8A7") ,com.kingdee.eas.mw.pay.IDepartMonthMsg.class);
    }
    
    public static com.kingdee.eas.mw.pay.IDepartMonthMsg getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IDepartMonthMsg)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("01ACB8A7") ,com.kingdee.eas.mw.pay.IDepartMonthMsg.class, objectCtx);
    }
    public static com.kingdee.eas.mw.pay.IDepartMonthMsg getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IDepartMonthMsg)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("01ACB8A7"));
    }
    public static com.kingdee.eas.mw.pay.IDepartMonthMsg getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IDepartMonthMsg)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("01ACB8A7"));
    }
}