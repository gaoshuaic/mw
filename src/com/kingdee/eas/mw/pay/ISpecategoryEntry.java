package com.kingdee.eas.mw.pay;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.Context;
import com.kingdee.eas.framework.ICoreBillEntryBase;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import java.lang.String;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.util.*;

public interface ISpecategoryEntry extends ICoreBillEntryBase
{
    public SpecategoryEntryInfo getSpecategoryEntryInfo(IObjectPK pk) throws BOSException, EASBizException;
    public SpecategoryEntryInfo getSpecategoryEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public SpecategoryEntryInfo getSpecategoryEntryInfo(String oql) throws BOSException, EASBizException;
    public SpecategoryEntryCollection getSpecategoryEntryCollection() throws BOSException;
    public SpecategoryEntryCollection getSpecategoryEntryCollection(EntityViewInfo view) throws BOSException;
    public SpecategoryEntryCollection getSpecategoryEntryCollection(String oql) throws BOSException;
}