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

public interface IScalingBonusUpdate extends IDataBase
{
    public ScalingBonusUpdateInfo getScalingBonusUpdateInfo(IObjectPK pk) throws BOSException, EASBizException;
    public ScalingBonusUpdateInfo getScalingBonusUpdateInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public ScalingBonusUpdateInfo getScalingBonusUpdateInfo(String oql) throws BOSException, EASBizException;
    public ScalingBonusUpdateCollection getScalingBonusUpdateCollection() throws BOSException;
    public ScalingBonusUpdateCollection getScalingBonusUpdateCollection(EntityViewInfo view) throws BOSException;
    public ScalingBonusUpdateCollection getScalingBonusUpdateCollection(String oql) throws BOSException;
}