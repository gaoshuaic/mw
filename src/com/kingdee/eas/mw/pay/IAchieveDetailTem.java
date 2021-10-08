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

public interface IAchieveDetailTem extends ICoreBillBase
{
    public AchieveDetailTemCollection getAchieveDetailTemCollection() throws BOSException;
    public AchieveDetailTemCollection getAchieveDetailTemCollection(EntityViewInfo view) throws BOSException;
    public AchieveDetailTemCollection getAchieveDetailTemCollection(String oql) throws BOSException;
    public AchieveDetailTemInfo getAchieveDetailTemInfo(IObjectPK pk) throws BOSException, EASBizException;
    public AchieveDetailTemInfo getAchieveDetailTemInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public AchieveDetailTemInfo getAchieveDetailTemInfo(String oql) throws BOSException, EASBizException;
    public void syncMiddata(AchieveDetailTemInfo model) throws BOSException;
}