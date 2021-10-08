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

public interface IToothCleanerBill extends IDataBase
{
    public ToothCleanerBillInfo getToothCleanerBillInfo(IObjectPK pk) throws BOSException, EASBizException;
    public ToothCleanerBillInfo getToothCleanerBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public ToothCleanerBillInfo getToothCleanerBillInfo(String oql) throws BOSException, EASBizException;
    public ToothCleanerBillCollection getToothCleanerBillCollection() throws BOSException;
    public ToothCleanerBillCollection getToothCleanerBillCollection(EntityViewInfo view) throws BOSException;
    public ToothCleanerBillCollection getToothCleanerBillCollection(String oql) throws BOSException;
}