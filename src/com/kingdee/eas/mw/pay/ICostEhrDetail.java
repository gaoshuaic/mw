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

public interface ICostEhrDetail extends ICoreBillBase
{
    public CostEhrDetailCollection getCostEhrDetailCollection() throws BOSException;
    public CostEhrDetailCollection getCostEhrDetailCollection(EntityViewInfo view) throws BOSException;
    public CostEhrDetailCollection getCostEhrDetailCollection(String oql) throws BOSException;
    public CostEhrDetailInfo getCostEhrDetailInfo(IObjectPK pk) throws BOSException, EASBizException;
    public CostEhrDetailInfo getCostEhrDetailInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public CostEhrDetailInfo getCostEhrDetailInfo(String oql) throws BOSException, EASBizException;
    public void syncMiddata(CostEhrDetailInfo model) throws BOSException;
}