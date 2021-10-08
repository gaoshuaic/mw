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

public interface ISaleIssueHisLogEntry extends ICoreBillEntryBase
{
    public SaleIssueHisLogEntryInfo getSaleIssueHisLogEntryInfo(IObjectPK pk) throws BOSException, EASBizException;
    public SaleIssueHisLogEntryInfo getSaleIssueHisLogEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public SaleIssueHisLogEntryInfo getSaleIssueHisLogEntryInfo(String oql) throws BOSException, EASBizException;
    public SaleIssueHisLogEntryCollection getSaleIssueHisLogEntryCollection() throws BOSException;
    public SaleIssueHisLogEntryCollection getSaleIssueHisLogEntryCollection(EntityViewInfo view) throws BOSException;
    public SaleIssueHisLogEntryCollection getSaleIssueHisLogEntryCollection(String oql) throws BOSException;
}