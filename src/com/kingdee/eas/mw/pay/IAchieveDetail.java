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

public interface IAchieveDetail extends ICoreBillBase
{
    public AchieveDetailCollection getAchieveDetailCollection() throws BOSException;
    public AchieveDetailCollection getAchieveDetailCollection(EntityViewInfo view) throws BOSException;
    public AchieveDetailCollection getAchieveDetailCollection(String oql) throws BOSException;
    public AchieveDetailInfo getAchieveDetailInfo(IObjectPK pk) throws BOSException, EASBizException;
    public AchieveDetailInfo getAchieveDetailInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public AchieveDetailInfo getAchieveDetailInfo(String oql) throws BOSException, EASBizException;
    public void syncMiddata(AchieveDetailInfo model) throws BOSException;
}