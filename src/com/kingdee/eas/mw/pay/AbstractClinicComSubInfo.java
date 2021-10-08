package com.kingdee.eas.mw.pay;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractClinicComSubInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractClinicComSubInfo()
    {
        this("id");
    }
    protected AbstractClinicComSubInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object:门诊点评扣款's 员工编码property 
     */
    public String getEmpNumber()
    {
        return getString("empNumber");
    }
    public void setEmpNumber(String item)
    {
        setString("empNumber", item);
    }
    /**
     * Object:门诊点评扣款's 员工名称property 
     */
    public String getEmpName()
    {
        return getString("empName");
    }
    public void setEmpName(String item)
    {
        setString("empName", item);
    }
    /**
     * Object:门诊点评扣款's 门诊编码property 
     */
    public String getClinicNumber()
    {
        return getString("clinicNumber");
    }
    public void setClinicNumber(String item)
    {
        setString("clinicNumber", item);
    }
    /**
     * Object:门诊点评扣款's 门诊名称property 
     */
    public String getClinicName()
    {
        return getString("clinicName");
    }
    public void setClinicName(String item)
    {
        setString("clinicName", item);
    }
    /**
     * Object:门诊点评扣款's 岗位property 
     */
    public com.kingdee.eas.mw.pay.app.PaypostType getPostNumber()
    {
        return com.kingdee.eas.mw.pay.app.PaypostType.getEnum(getString("postNumber"));
    }
    public void setPostNumber(com.kingdee.eas.mw.pay.app.PaypostType item)
    {
		if (item != null) {
        setString("postNumber", item.getValue());
		}
    }
    /**
     * Object: 门诊点评扣款 's 门诊 property 
     */
    public com.kingdee.eas.basedata.org.CompanyOrgUnitInfo getClinic()
    {
        return (com.kingdee.eas.basedata.org.CompanyOrgUnitInfo)get("clinic");
    }
    public void setClinic(com.kingdee.eas.basedata.org.CompanyOrgUnitInfo item)
    {
        put("clinic", item);
    }
    /**
     * Object: 门诊点评扣款 's 城市 property 
     */
    public com.kingdee.eas.basedata.org.CtrlUnitInfo getCity()
    {
        return (com.kingdee.eas.basedata.org.CtrlUnitInfo)get("city");
    }
    public void setCity(com.kingdee.eas.basedata.org.CtrlUnitInfo item)
    {
        put("city", item);
    }
    /**
     * Object:门诊点评扣款's 业务期间property 
     */
    public String getBusinessdate()
    {
        return getString("businessdate");
    }
    public void setBusinessdate(String item)
    {
        setString("businessdate", item);
    }
    /**
     * Object:门诊点评扣款's 差评数property 
     */
    public java.math.BigDecimal getBadNum()
    {
        return getBigDecimal("badNum");
    }
    public void setBadNum(java.math.BigDecimal item)
    {
        setBigDecimal("badNum", item);
    }
    /**
     * Object:门诊点评扣款's 扣款金额property 
     */
    public java.math.BigDecimal getSubAmount()
    {
        return getBigDecimal("subAmount");
    }
    public void setSubAmount(java.math.BigDecimal item)
    {
        setBigDecimal("subAmount", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("E02A0439");
    }
}