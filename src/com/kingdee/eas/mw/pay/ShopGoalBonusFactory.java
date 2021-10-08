package com.kingdee.eas.mw.pay;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ShopGoalBonusFactory
{
    private ShopGoalBonusFactory()
    {
    }
    public static com.kingdee.eas.mw.pay.IShopGoalBonus getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IShopGoalBonus)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("AD71DC84") ,com.kingdee.eas.mw.pay.IShopGoalBonus.class);
    }
    
    public static com.kingdee.eas.mw.pay.IShopGoalBonus getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IShopGoalBonus)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("AD71DC84") ,com.kingdee.eas.mw.pay.IShopGoalBonus.class, objectCtx);
    }
    public static com.kingdee.eas.mw.pay.IShopGoalBonus getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IShopGoalBonus)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("AD71DC84"));
    }
    public static com.kingdee.eas.mw.pay.IShopGoalBonus getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IShopGoalBonus)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("AD71DC84"));
    }
}