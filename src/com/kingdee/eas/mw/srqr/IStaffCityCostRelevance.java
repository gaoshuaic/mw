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

public interface IStaffCityCostRelevance extends IDataBase
{
    public StaffCityCostRelevanceInfo getStaffCityCostRelevanceInfo(IObjectPK pk) throws BOSException, EASBizException;
    public StaffCityCostRelevanceInfo getStaffCityCostRelevanceInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public StaffCityCostRelevanceInfo getStaffCityCostRelevanceInfo(String oql) throws BOSException, EASBizException;
    public StaffCityCostRelevanceCollection getStaffCityCostRelevanceCollection() throws BOSException;
    public StaffCityCostRelevanceCollection getStaffCityCostRelevanceCollection(EntityViewInfo view) throws BOSException;
    public StaffCityCostRelevanceCollection getStaffCityCostRelevanceCollection(String oql) throws BOSException;
}