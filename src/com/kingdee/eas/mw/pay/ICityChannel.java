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

public interface ICityChannel extends IDataBase
{
    public CityChannelInfo getCityChannelInfo(IObjectPK pk) throws BOSException, EASBizException;
    public CityChannelInfo getCityChannelInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public CityChannelInfo getCityChannelInfo(String oql) throws BOSException, EASBizException;
    public CityChannelCollection getCityChannelCollection() throws BOSException;
    public CityChannelCollection getCityChannelCollection(EntityViewInfo view) throws BOSException;
    public CityChannelCollection getCityChannelCollection(String oql) throws BOSException;
}