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

public interface IItemCheckEntry extends ICoreBillEntryBase
{
    public ItemCheckEntryInfo getItemCheckEntryInfo(IObjectPK pk) throws BOSException, EASBizException;
    public ItemCheckEntryInfo getItemCheckEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public ItemCheckEntryInfo getItemCheckEntryInfo(String oql) throws BOSException, EASBizException;
    public ItemCheckEntryCollection getItemCheckEntryCollection() throws BOSException;
    public ItemCheckEntryCollection getItemCheckEntryCollection(EntityViewInfo view) throws BOSException;
    public ItemCheckEntryCollection getItemCheckEntryCollection(String oql) throws BOSException;
}