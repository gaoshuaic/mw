package com.kingdee.eas.mw.pay;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import java.lang.String;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.framework.IDataBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.util.*;

public interface IAchRoyaltyRule extends IDataBase
{
    public AchRoyaltyRuleInfo getAchRoyaltyRuleInfo(IObjectPK pk) throws BOSException, EASBizException;
    public AchRoyaltyRuleInfo getAchRoyaltyRuleInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public AchRoyaltyRuleInfo getAchRoyaltyRuleInfo(String oql) throws BOSException, EASBizException;
    public AchRoyaltyRuleCollection getAchRoyaltyRuleCollection() throws BOSException;
    public AchRoyaltyRuleCollection getAchRoyaltyRuleCollection(EntityViewInfo view) throws BOSException;
    public AchRoyaltyRuleCollection getAchRoyaltyRuleCollection(String oql) throws BOSException;
}