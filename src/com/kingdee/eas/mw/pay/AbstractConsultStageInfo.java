package com.kingdee.eas.mw.pay;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractConsultStageInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractConsultStageInfo()
    {
        this("id");
    }
    protected AbstractConsultStageInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: ×ÉÑ¯½×¶ÎÅäÖÃ 's ³ÇÊĞ property 
     */
    public com.kingdee.eas.basedata.org.AdminOrgUnitInfo getCity()
    {
        return (com.kingdee.eas.basedata.org.AdminOrgUnitInfo)get("city");
    }
    public void setCity(com.kingdee.eas.basedata.org.AdminOrgUnitInfo item)
    {
        put("city", item);
    }
    /**
     * Object:×ÉÑ¯½×¶ÎÅäÖÃ's ÒµÎñÆÚ¼äproperty 
     */
    public String getBusinessDate()
    {
        return getString("BusinessDate");
    }
    public void setBusinessDate(String item)
    {
        setString("BusinessDate", item);
    }
    /**
     * Object: ×ÉÑ¯½×¶ÎÅäÖÃ 's ×ÉÑ¯ÀàĞÍ property 
     */
    public com.kingdee.eas.mw.pay.ConsultTypeInfo getType()
    {
        return (com.kingdee.eas.mw.pay.ConsultTypeInfo)get("type");
    }
    public void setType(com.kingdee.eas.mw.pay.ConsultTypeInfo item)
    {
        put("type", item);
    }
    /**
     * Object:×ÉÑ¯½×¶ÎÅäÖÃ's ¿ªÊ¼½×¶Î½ğ¶îproperty 
     */
    public java.math.BigDecimal getBeginAmount()
    {
        return getBigDecimal("beginAmount");
    }
    public void setBeginAmount(java.math.BigDecimal item)
    {
        setBigDecimal("beginAmount", item);
    }
    /**
     * Object:×ÉÑ¯½×¶ÎÅäÖÃ's ½áÊø½×¶Î½ğ¶îproperty 
     */
    public java.math.BigDecimal getEndAmount()
    {
        return getBigDecimal("endAmount");
    }
    public void setEndAmount(java.math.BigDecimal item)
    {
        setBigDecimal("endAmount", item);
    }
    /**
     * Object:×ÉÑ¯½×¶ÎÅäÖÃ's ½×¶Î±ÈÀıproperty 
     */
    public java.math.BigDecimal getPro()
    {
        return getBigDecimal("pro");
    }
    public void setPro(java.math.BigDecimal item)
    {
        setBigDecimal("pro", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("5659F2A4");
    }
}