package com.kingdee.eas.mw.pay;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class SpecategoryFactory
{
    private SpecategoryFactory()
    {
    }
    public static com.kingdee.eas.mw.pay.ISpecategory getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.mw.pay.ISpecategory)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("9488FC34") ,com.kingdee.eas.mw.pay.ISpecategory.class);
    }
    
    public static com.kingdee.eas.mw.pay.ISpecategory getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.ISpecategory)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("9488FC34") ,com.kingdee.eas.mw.pay.ISpecategory.class, objectCtx);
    }
    public static com.kingdee.eas.mw.pay.ISpecategory getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.ISpecategory)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("9488FC34"));
    }
    public static com.kingdee.eas.mw.pay.ISpecategory getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.ISpecategory)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("9488FC34"));
    }
}