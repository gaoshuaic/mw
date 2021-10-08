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

public interface ICostSum extends ICoreBillBase
{
    public CostSumCollection getCostSumCollection() throws BOSException;
    public CostSumCollection getCostSumCollection(EntityViewInfo view) throws BOSException;
    public CostSumCollection getCostSumCollection(String oql) throws BOSException;
    public CostSumInfo getCostSumInfo(IObjectPK pk) throws BOSException, EASBizException;
    public CostSumInfo getCostSumInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public CostSumInfo getCostSumInfo(String oql) throws BOSException, EASBizException;
    public String auditCost(CostSumInfo model) throws BOSException;
    public String unAuditCost(CostSumInfo model) throws BOSException;
    public void setAllCost(String type, String id) throws BOSException;
    public void produceCost(CostSumInfo model) throws BOSException;
}