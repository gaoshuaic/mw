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
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.framework.ICoreBillBase;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.util.*;

public interface IDoctorPerformance extends ICoreBillBase
{
    public DoctorPerformanceCollection getDoctorPerformanceCollection() throws BOSException;
    public DoctorPerformanceCollection getDoctorPerformanceCollection(EntityViewInfo view) throws BOSException;
    public DoctorPerformanceCollection getDoctorPerformanceCollection(String oql) throws BOSException;
    public DoctorPerformanceInfo getDoctorPerformanceInfo(IObjectPK pk) throws BOSException, EASBizException;
    public DoctorPerformanceInfo getDoctorPerformanceInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public DoctorPerformanceInfo getDoctorPerformanceInfo(String oql) throws BOSException, EASBizException;
}