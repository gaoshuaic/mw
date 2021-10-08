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

public interface IClinicCheck extends IDataBase
{
    public ClinicCheckInfo getClinicCheckInfo(IObjectPK pk) throws BOSException, EASBizException;
    public ClinicCheckInfo getClinicCheckInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public ClinicCheckInfo getClinicCheckInfo(String oql) throws BOSException, EASBizException;
    public ClinicCheckCollection getClinicCheckCollection() throws BOSException;
    public ClinicCheckCollection getClinicCheckCollection(EntityViewInfo view) throws BOSException;
    public ClinicCheckCollection getClinicCheckCollection(String oql) throws BOSException;
}