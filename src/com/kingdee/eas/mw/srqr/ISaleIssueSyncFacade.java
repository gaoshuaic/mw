package com.kingdee.eas.mw.srqr;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;

public interface ISaleIssueSyncFacade extends IBizCtrl
{
    public void syncSaleIssueBill() throws BOSException;
    public void syncIssueLogToMid(String database) throws BOSException;
    public void syncSaleIssByCompany(String companyId) throws BOSException;
}