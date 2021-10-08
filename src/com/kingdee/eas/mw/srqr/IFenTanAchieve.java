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

public interface IFenTanAchieve extends IDataBase
{
    public FenTanAchieveInfo getFenTanAchieveInfo(IObjectPK pk) throws BOSException, EASBizException;
    public FenTanAchieveInfo getFenTanAchieveInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public FenTanAchieveInfo getFenTanAchieveInfo(String oql) throws BOSException, EASBizException;
    public FenTanAchieveCollection getFenTanAchieveCollection() throws BOSException;
    public FenTanAchieveCollection getFenTanAchieveCollection(EntityViewInfo view) throws BOSException;
    public FenTanAchieveCollection getFenTanAchieveCollection(String oql) throws BOSException;
}