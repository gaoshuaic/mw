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

public interface IConsultKeep extends IDataBase
{
    public ConsultKeepInfo getConsultKeepInfo(IObjectPK pk) throws BOSException, EASBizException;
    public ConsultKeepInfo getConsultKeepInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public ConsultKeepInfo getConsultKeepInfo(String oql) throws BOSException, EASBizException;
    public ConsultKeepCollection getConsultKeepCollection() throws BOSException;
    public ConsultKeepCollection getConsultKeepCollection(EntityViewInfo view) throws BOSException;
    public ConsultKeepCollection getConsultKeepCollection(String oql) throws BOSException;
}