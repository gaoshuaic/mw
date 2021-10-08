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
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.framework.ICoreBillBase;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.util.*;

public interface ISaleIssueHisLog extends ICoreBillBase
{
    public SaleIssueHisLogCollection getSaleIssueHisLogCollection() throws BOSException;
    public SaleIssueHisLogCollection getSaleIssueHisLogCollection(EntityViewInfo view) throws BOSException;
    public SaleIssueHisLogCollection getSaleIssueHisLogCollection(String oql) throws BOSException;
    public SaleIssueHisLogInfo getSaleIssueHisLogInfo(IObjectPK pk) throws BOSException, EASBizException;
    public SaleIssueHisLogInfo getSaleIssueHisLogInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public SaleIssueHisLogInfo getSaleIssueHisLogInfo(String oql) throws BOSException, EASBizException;
}