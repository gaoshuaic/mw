package com.kingdee.eas.mw.pay;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractWhiteBonusUpdateInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractWhiteBonusUpdateInfo()
    {
        this("id");
    }
    protected AbstractWhiteBonusUpdateInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object:洁牙师美白业绩调整's 员工编码property 
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
     * Object:洁牙师美白业绩调整's 员工名称property 
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
     * Object:洁牙师美白业绩调整's 美白业绩property 
     */
    public java.math.BigDecimal getMbAchieve()
    {
        return getBigDecimal("mbAchieve");
    }
    public void setMbAchieve(java.math.BigDecimal item)
    {
        setBigDecimal("mbAchieve", item);
    }
    /**
     * Object:洁牙师美白业绩调整's 门诊编码property 
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
     * Object:洁牙师美白业绩调整's 门诊名称property 
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
     * Object:洁牙师美白业绩调整's 业务日期property 
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
     * Object:洁牙师美白业绩调整's 城市编码property 
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
     * Object:洁牙师美白业绩调整's 城市名称property 
     */
    public String getCityName()
    {
        return getString("cityName");
    }
    public void setCityName(String item)
    {
        setString("cityName", item);
    }
    /**
     * Object: 洁牙师美白业绩调整 's 城市 property 
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
     * Object: 洁牙师美白业绩调整 's 门诊 property 
     */
    public com.kingdee.eas.basedata.org.CompanyOrgUnitInfo getClinic()
    {
        return (com.kingdee.eas.basedata.org.CompanyOrgUnitInfo)get("clinic");
    }
    public void setClinic(com.kingdee.eas.basedata.org.CompanyOrgUnitInfo item)
    {
        put("clinic", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("83F86911");
    }
}