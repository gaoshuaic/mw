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

public interface IServiceAmount extends ICoreBillBase
{
    public ServiceAmountCollection getServiceAmountCollection() throws BOSException;
    public ServiceAmountCollection getServiceAmountCollection(EntityViewInfo view) throws BOSException;
    public ServiceAmountCollection getServiceAmountCollection(String oql) throws BOSException;
    public ServiceAmountInfo getServiceAmountInfo(IObjectPK pk) throws BOSException, EASBizException;
    public ServiceAmountInfo getServiceAmountInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public ServiceAmountInfo getServiceAmountInfo(String oql) throws BOSException, EASBizException;
}