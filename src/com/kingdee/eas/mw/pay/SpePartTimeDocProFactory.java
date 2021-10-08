package com.kingdee.eas.mw.pay;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class SpePartTimeDocProFactory
{
    private SpePartTimeDocProFactory()
    {
    }
    public static com.kingdee.eas.mw.pay.ISpePartTimeDocPro getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.mw.pay.ISpePartTimeDocPro)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("0C10B2AB") ,com.kingdee.eas.mw.pay.ISpePartTimeDocPro.class);
    }
    
    public static com.kingdee.eas.mw.pay.ISpePartTimeDocPro getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.ISpePartTimeDocPro)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("0C10B2AB") ,com.kingdee.eas.mw.pay.ISpePartTimeDocPro.class, objectCtx);
    }
    public static com.kingdee.eas.mw.pay.ISpePartTimeDocPro getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.ISpePartTimeDocPro)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("0C10B2AB"));
    }
    public static com.kingdee.eas.mw.pay.ISpePartTimeDocPro getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.ISpePartTimeDocPro)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("0C10B2AB"));
    }
}