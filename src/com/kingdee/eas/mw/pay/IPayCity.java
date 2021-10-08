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

public interface IPayCity extends IDataBase
{
    public PayCityInfo getPayCityInfo(IObjectPK pk) throws BOSException, EASBizException;
    public PayCityInfo getPayCityInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public PayCityInfo getPayCityInfo(String oql) throws BOSException, EASBizException;
    public PayCityCollection getPayCityCollection() throws BOSException;
    public PayCityCollection getPayCityCollection(EntityViewInfo view) throws BOSException;
    public PayCityCollection getPayCityCollection(String oql) throws BOSException;
    public void syncMessage(PayCityInfo model) throws BOSException;
    public void syncCostAndAchieve(PayCityInfo model) throws BOSException;
}