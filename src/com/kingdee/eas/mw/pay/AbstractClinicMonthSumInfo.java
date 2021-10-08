package com.kingdee.eas.mw.pay;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractClinicMonthSumInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractClinicMonthSumInfo()
    {
        this("id");
    }
    protected AbstractClinicMonthSumInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object:门诊月汇总's 业务年月property 
     */
    public String getBusinessDate()
    {
        return getString("businessDate");
    }
    public void setBusinessDate(String item)
    {
        setString("businessDate", item);
    }
    /**
     * Object:门诊月汇总's 城市编码property 
     */
    public String getCityNumber()
    {
        return getString("cityNumber");
    }
    public void setCityNumber(String item)
    {
        setString("cityNumber", item);
    }
    /**
     * Object:门诊月汇总's 城市property 
     */
    public String getCity()
    {
        return getString("city");
    }
    public void setCity(String item)
    {
        setString("city", item);
    }
    /**
     * Object:门诊月汇总's 门诊编码property 
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
     * Object:门诊月汇总's 门诊名称property 
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
     * Object:门诊月汇总's 支付(流水)property 
     */
    public java.math.BigDecimal getDiary()
    {
        return getBigDecimal("diary");
    }
    public void setDiary(java.math.BigDecimal item)
    {
        setBigDecimal("diary", item);
    }
    /**
     * Object:门诊月汇总's 营收(划扣)property 
     */
    public java.math.BigDecimal getInCome()
    {
        return getBigDecimal("inCome");
    }
    public void setInCome(java.math.BigDecimal item)
    {
        setBigDecimal("inCome", item);
    }
    /**
     * Object:门诊月汇总's 城市IDproperty 
     */
    public String getCityid()
    {
        return getString("cityid");
    }
    public void setCityid(String item)
    {
        setString("cityid", item);
    }
    /**
     * Object:门诊月汇总's 门诊idproperty 
     */
    public String getClinicid()
    {
        return getString("clinicid");
    }
    public void setClinicid(String item)
    {
        setString("clinicid", item);
    }
    /**
     * Object:门诊月汇总's 流水property 
     */
    public java.math.BigDecimal getLiushui()
    {
        return getBigDecimal("liushui");
    }
    public void setLiushui(java.math.BigDecimal item)
    {
        setBigDecimal("liushui", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("90056865");
    }
}