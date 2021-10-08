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
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.framework.ICoreBillBase;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.util.*;

public interface IAchievementDetail extends ICoreBillBase
{
    public AchievementDetailCollection getAchievementDetailCollection() throws BOSException;
    public AchievementDetailCollection getAchievementDetailCollection(EntityViewInfo view) throws BOSException;
    public AchievementDetailCollection getAchievementDetailCollection(String oql) throws BOSException;
    public AchievementDetailInfo getAchievementDetailInfo(IObjectPK pk) throws BOSException, EASBizException;
    public AchievementDetailInfo getAchievementDetailInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public AchievementDetailInfo getAchievementDetailInfo(String oql) throws BOSException, EASBizException;
}