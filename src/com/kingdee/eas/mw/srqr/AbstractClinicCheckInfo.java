package com.kingdee.eas.mw.srqr;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractClinicCheckInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractClinicCheckInfo()
    {
        this("id");
    }
    protected AbstractClinicCheckInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object:门诊校验's 总数property 
     */
    public java.math.BigDecimal getCount()
    {
        return getBigDecimal("count");
    }
    public void setCount(java.math.BigDecimal item)
    {
        setBigDecimal("count", item);
    }
    /**
     * Object:门诊校验's 日期property 
     */
    public java.util.Date getBizdate()
    {
        return getDate("bizdate");
    }
    public void setBizdate(java.util.Date item)
    {
        setDate("bizdate", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("C8186C44");
    }
}