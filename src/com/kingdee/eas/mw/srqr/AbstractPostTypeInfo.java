package com.kingdee.eas.mw.srqr;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractPostTypeInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractPostTypeInfo()
    {
        this("id");
    }
    protected AbstractPostTypeInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 岗位类别 's 成本中心 property 
     */
    public com.kingdee.eas.mw.srqr.CostCenterInfo getCostConter()
    {
        return (com.kingdee.eas.mw.srqr.CostCenterInfo)get("costConter");
    }
    public void setCostConter(com.kingdee.eas.mw.srqr.CostCenterInfo item)
    {
        put("costConter", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("173CF736");
    }
}