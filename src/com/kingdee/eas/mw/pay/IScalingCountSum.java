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

public interface IScalingCountSum extends IDataBase
{
    public ScalingCountSumInfo getScalingCountSumInfo(IObjectPK pk) throws BOSException, EASBizException;
    public ScalingCountSumInfo getScalingCountSumInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public ScalingCountSumInfo getScalingCountSumInfo(String oql) throws BOSException, EASBizException;
    public ScalingCountSumCollection getScalingCountSumCollection() throws BOSException;
    public ScalingCountSumCollection getScalingCountSumCollection(EntityViewInfo view) throws BOSException;
    public ScalingCountSumCollection getScalingCountSumCollection(String oql) throws BOSException;
}