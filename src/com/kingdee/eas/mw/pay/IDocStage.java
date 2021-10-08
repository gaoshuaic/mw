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

public interface IDocStage extends IDataBase
{
    public DocStageInfo getDocStageInfo(IObjectPK pk) throws BOSException, EASBizException;
    public DocStageInfo getDocStageInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public DocStageInfo getDocStageInfo(String oql) throws BOSException, EASBizException;
    public DocStageCollection getDocStageCollection() throws BOSException;
    public DocStageCollection getDocStageCollection(EntityViewInfo view) throws BOSException;
    public DocStageCollection getDocStageCollection(String oql) throws BOSException;
}