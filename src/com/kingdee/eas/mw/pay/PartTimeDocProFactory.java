package com.kingdee.eas.mw.pay;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class PartTimeDocProFactory
{
    private PartTimeDocProFactory()
    {
    }
    public static com.kingdee.eas.mw.pay.IPartTimeDocPro getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IPartTimeDocPro)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("9E09AB87") ,com.kingdee.eas.mw.pay.IPartTimeDocPro.class);
    }
    
    public static com.kingdee.eas.mw.pay.IPartTimeDocPro getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IPartTimeDocPro)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("9E09AB87") ,com.kingdee.eas.mw.pay.IPartTimeDocPro.class, objectCtx);
    }
    public static com.kingdee.eas.mw.pay.IPartTimeDocPro getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IPartTimeDocPro)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("9E09AB87"));
    }
    public static com.kingdee.eas.mw.pay.IPartTimeDocPro getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IPartTimeDocPro)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("9E09AB87"));
    }
}