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

public interface IFreeItemCheck extends IDataBase
{
    public FreeItemCheckInfo getFreeItemCheckInfo(IObjectPK pk) throws BOSException, EASBizException;
    public FreeItemCheckInfo getFreeItemCheckInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public FreeItemCheckInfo getFreeItemCheckInfo(String oql) throws BOSException, EASBizException;
    public FreeItemCheckCollection getFreeItemCheckCollection() throws BOSException;
    public FreeItemCheckCollection getFreeItemCheckCollection(EntityViewInfo view) throws BOSException;
    public FreeItemCheckCollection getFreeItemCheckCollection(String oql) throws BOSException;
}