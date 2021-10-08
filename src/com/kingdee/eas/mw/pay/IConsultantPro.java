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

public interface IConsultantPro extends IDataBase
{
    public ConsultantProInfo getConsultantProInfo(IObjectPK pk) throws BOSException, EASBizException;
    public ConsultantProInfo getConsultantProInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public ConsultantProInfo getConsultantProInfo(String oql) throws BOSException, EASBizException;
    public ConsultantProCollection getConsultantProCollection() throws BOSException;
    public ConsultantProCollection getConsultantProCollection(EntityViewInfo view) throws BOSException;
    public ConsultantProCollection getConsultantProCollection(String oql) throws BOSException;
}