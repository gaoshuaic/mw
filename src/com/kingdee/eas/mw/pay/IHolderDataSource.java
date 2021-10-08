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

public interface IHolderDataSource extends ICoreBillBase
{
    public HolderDataSourceCollection getHolderDataSourceCollection() throws BOSException;
    public HolderDataSourceCollection getHolderDataSourceCollection(EntityViewInfo view) throws BOSException;
    public HolderDataSourceCollection getHolderDataSourceCollection(String oql) throws BOSException;
    public HolderDataSourceInfo getHolderDataSourceInfo(IObjectPK pk) throws BOSException, EASBizException;
    public HolderDataSourceInfo getHolderDataSourceInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public HolderDataSourceInfo getHolderDataSourceInfo(String oql) throws BOSException, EASBizException;
}