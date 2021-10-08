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

public interface ITag extends IDataBase
{
    public TagInfo getTagInfo(IObjectPK pk) throws BOSException, EASBizException;
    public TagInfo getTagInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public TagInfo getTagInfo(String oql) throws BOSException, EASBizException;
    public TagCollection getTagCollection() throws BOSException;
    public TagCollection getTagCollection(EntityViewInfo view) throws BOSException;
    public TagCollection getTagCollection(String oql) throws BOSException;
}