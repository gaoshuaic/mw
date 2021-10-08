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

public interface IConsultStage extends IDataBase
{
    public ConsultStageInfo getConsultStageInfo(IObjectPK pk) throws BOSException, EASBizException;
    public ConsultStageInfo getConsultStageInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public ConsultStageInfo getConsultStageInfo(String oql) throws BOSException, EASBizException;
    public ConsultStageCollection getConsultStageCollection() throws BOSException;
    public ConsultStageCollection getConsultStageCollection(EntityViewInfo view) throws BOSException;
    public ConsultStageCollection getConsultStageCollection(String oql) throws BOSException;
}