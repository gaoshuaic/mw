package com.kingdee.eas.mw.pay;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractPayCityEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractPayCityEntryInfo()
    {
        this("id");
    }
    protected AbstractPayCityEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 第1个表体 's null property 
     */
    public com.kingdee.eas.mw.pay.PayCityInfo getParent()
    {
        return (com.kingdee.eas.mw.pay.PayCityInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.mw.pay.PayCityInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: 第1个表体 's 包含城市 property 
     */
    public com.kingdee.eas.basedata.org.AdminOrgUnitInfo getIncludeCity()
    {
        return (com.kingdee.eas.basedata.org.AdminOrgUnitInfo)get("includeCity");
    }
    public void setIncludeCity(com.kingdee.eas.basedata.org.AdminOrgUnitInfo item)
    {
        put("includeCity", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("1894DE31");
    }
}