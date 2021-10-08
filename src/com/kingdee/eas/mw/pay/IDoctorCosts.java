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

public interface IDoctorCosts extends ICoreBillBase
{
    public DoctorCostsCollection getDoctorCostsCollection() throws BOSException;
    public DoctorCostsCollection getDoctorCostsCollection(EntityViewInfo view) throws BOSException;
    public DoctorCostsCollection getDoctorCostsCollection(String oql) throws BOSException;
    public DoctorCostsInfo getDoctorCostsInfo(IObjectPK pk) throws BOSException, EASBizException;
    public DoctorCostsInfo getDoctorCostsInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public DoctorCostsInfo getDoctorCostsInfo(String oql) throws BOSException, EASBizException;
}