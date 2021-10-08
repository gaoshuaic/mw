package com.kingdee.eas.mw.pay;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class PaySheetDetailFactory
{
    private PaySheetDetailFactory()
    {
    }
    public static com.kingdee.eas.mw.pay.IPaySheetDetail getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IPaySheetDetail)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("4104607A") ,com.kingdee.eas.mw.pay.IPaySheetDetail.class);
    }
    
    public static com.kingdee.eas.mw.pay.IPaySheetDetail getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IPaySheetDetail)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("4104607A") ,com.kingdee.eas.mw.pay.IPaySheetDetail.class, objectCtx);
    }
    public static com.kingdee.eas.mw.pay.IPaySheetDetail getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IPaySheetDetail)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("4104607A"));
    }
    public static com.kingdee.eas.mw.pay.IPaySheetDetail getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IPaySheetDetail)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("4104607A"));
    }
}