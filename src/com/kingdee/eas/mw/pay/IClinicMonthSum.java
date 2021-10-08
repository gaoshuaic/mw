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

public interface IClinicMonthSum extends IDataBase
{
    public ClinicMonthSumInfo getClinicMonthSumInfo(IObjectPK pk) throws BOSException, EASBizException;
    public ClinicMonthSumInfo getClinicMonthSumInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public ClinicMonthSumInfo getClinicMonthSumInfo(String oql) throws BOSException, EASBizException;
    public ClinicMonthSumCollection getClinicMonthSumCollection() throws BOSException;
    public ClinicMonthSumCollection getClinicMonthSumCollection(EntityViewInfo view) throws BOSException;
    public ClinicMonthSumCollection getClinicMonthSumCollection(String oql) throws BOSException;
}