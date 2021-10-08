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

public interface IWhiteProportion extends IDataBase
{
    public WhiteProportionInfo getWhiteProportionInfo(IObjectPK pk) throws BOSException, EASBizException;
    public WhiteProportionInfo getWhiteProportionInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public WhiteProportionInfo getWhiteProportionInfo(String oql) throws BOSException, EASBizException;
    public WhiteProportionCollection getWhiteProportionCollection() throws BOSException;
    public WhiteProportionCollection getWhiteProportionCollection(EntityViewInfo view) throws BOSException;
    public WhiteProportionCollection getWhiteProportionCollection(String oql) throws BOSException;
}