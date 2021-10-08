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

public interface IClinicAchieveCosthSum extends IDataBase
{
    public ClinicAchieveCosthSumInfo getClinicAchieveCosthSumInfo(IObjectPK pk) throws BOSException, EASBizException;
    public ClinicAchieveCosthSumInfo getClinicAchieveCosthSumInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public ClinicAchieveCosthSumInfo getClinicAchieveCosthSumInfo(String oql) throws BOSException, EASBizException;
    public ClinicAchieveCosthSumCollection getClinicAchieveCosthSumCollection() throws BOSException;
    public ClinicAchieveCosthSumCollection getClinicAchieveCosthSumCollection(EntityViewInfo view) throws BOSException;
    public ClinicAchieveCosthSumCollection getClinicAchieveCosthSumCollection(String oql) throws BOSException;
}