package com.kingdee.eas.mw.srqr;

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

public interface ISpecialItemEntry extends ICoreBillEntryBase
{
    public SpecialItemEntryInfo getSpecialItemEntryInfo(IObjectPK pk) throws BOSException, EASBizException;
    public SpecialItemEntryInfo getSpecialItemEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public SpecialItemEntryInfo getSpecialItemEntryInfo(String oql) throws BOSException, EASBizException;
    public SpecialItemEntryCollection getSpecialItemEntryCollection() throws BOSException;
    public SpecialItemEntryCollection getSpecialItemEntryCollection(EntityViewInfo view) throws BOSException;
    public SpecialItemEntryCollection getSpecialItemEntryCollection(String oql) throws BOSException;
}