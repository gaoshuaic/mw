package com.kingdee.eas.mw.pay;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractDocStageInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractDocStageInfo()
    {
        this("id");
    }
    protected AbstractDocStageInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 医生阶段配置 's 城市 property 
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
     * Object:医生阶段配置's 业务期间property 
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
     * Object:医生阶段配置's 类型property 
     */
    public String getType()
    {
        return getString("type");
    }
    public void setType(String item)
    {
        setString("type", item);
    }
    /**
     * Object:医生阶段配置's 门诊编码property 
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
     * Object:医生阶段配置's 门诊名称property 
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
     * Object:医生阶段配置's 开始阶段金额property 
     */
    public java.math.BigDecimal getBrginAmount()
    {
        return getBigDecimal("brginAmount");
    }
    public void setBrginAmount(java.math.BigDecimal item)
    {
        setBigDecimal("brginAmount", item);
    }
    /**
     * Object:医生阶段配置's 结束阶段金额property 
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
     * Object:医生阶段配置's 阶段比例property 
     */
    public java.math.BigDecimal getPro()
    {
        return getBigDecimal("pro");
    }
    public void setPro(java.math.BigDecimal item)
    {
        setBigDecimal("pro", item);
    }
    /**
     * Object:医生阶段配置's 基础业绩property 
     */
    public java.math.BigDecimal getBaseAchieve()
    {
        return getBigDecimal("baseAchieve");
    }
    public void setBaseAchieve(java.math.BigDecimal item)
    {
        setBigDecimal("baseAchieve", item);
    }
    /**
     * Object:医生阶段配置's 包含病种property 
     */
    public String getIncludeBZ()
    {
        return getString("includeBZ");
    }
    public void setIncludeBZ(String item)
    {
        setString("includeBZ", item);
    }
    /**
     * Object:医生阶段配置's 员工编码property 
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
     * Object:医生阶段配置's 员工名称property 
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
     * Object:医生阶段配置's 是否使用全部业绩property 
     */
    public boolean isIsAllAchieve()
    {
        return getBoolean("isAllAchieve");
    }
    public void setIsAllAchieve(boolean item)
    {
        setBoolean("isAllAchieve", item);
    }
    /**
     * Object:医生阶段配置's 计算类型property 
     */
    public com.kingdee.eas.mw.pay.app.CalculationType getCalType()
    {
        return com.kingdee.eas.mw.pay.app.CalculationType.getEnum(getString("calType"));
    }
    public void setCalType(com.kingdee.eas.mw.pay.app.CalculationType item)
    {
		if (item != null) {
        setString("calType", item.getValue());
		}
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("A1CD41D8");
    }
}