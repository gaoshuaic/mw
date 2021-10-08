package com.kingdee.eas.mw.srqr;

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

public interface IPayItem extends IDataBase
{
    public PayItemInfo getPayItemInfo(IObjectPK pk) throws BOSException, EASBizException;
    public PayItemInfo getPayItemInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public PayItemInfo getPayItemInfo(String oql) throws BOSException, EASBizException;
    public PayItemCollection getPayItemCollection() throws BOSException;
    public PayItemCollection getPayItemCollection(EntityViewInfo view) throws BOSException;
    public PayItemCollection getPayItemCollection(String oql) throws BOSException;
}