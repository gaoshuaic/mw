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

public interface IPaytypecategory extends IDataBase
{
    public PaytypecategoryInfo getPaytypecategoryInfo(IObjectPK pk) throws BOSException, EASBizException;
    public PaytypecategoryInfo getPaytypecategoryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public PaytypecategoryInfo getPaytypecategoryInfo(String oql) throws BOSException, EASBizException;
    public PaytypecategoryCollection getPaytypecategoryCollection() throws BOSException;
    public PaytypecategoryCollection getPaytypecategoryCollection(EntityViewInfo view) throws BOSException;
    public PaytypecategoryCollection getPaytypecategoryCollection(String oql) throws BOSException;
}