package com.kingdee.eas.mw.pay;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class DocCurrencyProFactory
{
    private DocCurrencyProFactory()
    {
    }
    public static com.kingdee.eas.mw.pay.IDocCurrencyPro getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IDocCurrencyPro)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("21F17836") ,com.kingdee.eas.mw.pay.IDocCurrencyPro.class);
    }
    
    public static com.kingdee.eas.mw.pay.IDocCurrencyPro getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IDocCurrencyPro)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("21F17836") ,com.kingdee.eas.mw.pay.IDocCurrencyPro.class, objectCtx);
    }
    public static com.kingdee.eas.mw.pay.IDocCurrencyPro getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IDocCurrencyPro)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("21F17836"));
    }
    public static com.kingdee.eas.mw.pay.IDocCurrencyPro getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IDocCurrencyPro)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("21F17836"));
    }
}