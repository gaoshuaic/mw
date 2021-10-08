package com.kingdee.eas.mw.pay;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractScalingTypeInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractScalingTypeInfo()
    {
        this("id");
    }
    protected AbstractScalingTypeInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 洁牙类型 's 城市 property 
     */
    public com.kingdee.eas.basedata.org.CompanyOrgUnitInfo getCity()
    {
        return (com.kingdee.eas.basedata.org.CompanyOrgUnitInfo)get("city");
    }
    public void setCity(com.kingdee.eas.basedata.org.CompanyOrgUnitInfo item)
    {
        put("city", item);
    }
    /**
     * Object:洁牙类型's 洁牙类型编码property 
     */
    public String getJyNumber()
    {
        return getString("jyNumber");
    }
    public void setJyNumber(String item)
    {
        setString("jyNumber", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("1FAF8CEF");
    }
}