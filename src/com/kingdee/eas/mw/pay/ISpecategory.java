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

public interface ISpecategory extends ICoreBillBase
{
    public SpecategoryCollection getSpecategoryCollection() throws BOSException;
    public SpecategoryCollection getSpecategoryCollection(EntityViewInfo view) throws BOSException;
    public SpecategoryCollection getSpecategoryCollection(String oql) throws BOSException;
    public SpecategoryInfo getSpecategoryInfo(IObjectPK pk) throws BOSException, EASBizException;
    public SpecategoryInfo getSpecategoryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public SpecategoryInfo getSpecategoryInfo(String oql) throws BOSException, EASBizException;
}