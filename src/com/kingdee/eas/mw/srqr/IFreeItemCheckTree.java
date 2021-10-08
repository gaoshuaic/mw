package com.kingdee.eas.mw.srqr;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.Context;
import com.kingdee.eas.framework.ITreeBase;
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

public interface IFreeItemCheckTree extends ITreeBase
{
    public FreeItemCheckTreeInfo getFreeItemCheckTreeInfo(IObjectPK pk) throws BOSException, EASBizException;
    public FreeItemCheckTreeInfo getFreeItemCheckTreeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public FreeItemCheckTreeInfo getFreeItemCheckTreeInfo(String oql) throws BOSException, EASBizException;
    public FreeItemCheckTreeCollection getFreeItemCheckTreeCollection() throws BOSException;
    public FreeItemCheckTreeCollection getFreeItemCheckTreeCollection(EntityViewInfo view) throws BOSException;
    public FreeItemCheckTreeCollection getFreeItemCheckTreeCollection(String oql) throws BOSException;
}