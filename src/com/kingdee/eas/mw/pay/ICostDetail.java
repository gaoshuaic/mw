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

public interface ICostDetail extends ICoreBillBase
{
    public CostDetailCollection getCostDetailCollection() throws BOSException;
    public CostDetailCollection getCostDetailCollection(EntityViewInfo view) throws BOSException;
    public CostDetailCollection getCostDetailCollection(String oql) throws BOSException;
    public CostDetailInfo getCostDetailInfo(IObjectPK pk) throws BOSException, EASBizException;
    public CostDetailInfo getCostDetailInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public CostDetailInfo getCostDetailInfo(String oql) throws BOSException, EASBizException;
}