package com.kingdee.eas.mw.pay;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class EmpShopDeployFactory
{
    private EmpShopDeployFactory()
    {
    }
    public static com.kingdee.eas.mw.pay.IEmpShopDeploy getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IEmpShopDeploy)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("A54E3073") ,com.kingdee.eas.mw.pay.IEmpShopDeploy.class);
    }
    
    public static com.kingdee.eas.mw.pay.IEmpShopDeploy getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IEmpShopDeploy)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("A54E3073") ,com.kingdee.eas.mw.pay.IEmpShopDeploy.class, objectCtx);
    }
    public static com.kingdee.eas.mw.pay.IEmpShopDeploy getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IEmpShopDeploy)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("A54E3073"));
    }
    public static com.kingdee.eas.mw.pay.IEmpShopDeploy getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.mw.pay.IEmpShopDeploy)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("A54E3073"));
    }
}