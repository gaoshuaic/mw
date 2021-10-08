package com.kingdee.eas.mw.pay;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractDoctorCostsInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractDoctorCostsInfo()
    {
        this("id");
    }
    protected AbstractDoctorCostsInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object:医生调整成本's 门诊编码property 
     */
    public String getMzNumber()
    {
        return getString("mzNumber");
    }
    public void setMzNumber(String item)
    {
        setString("mzNumber", item);
    }
    /**
     * Object:医生调整成本's 门诊姓名property 
     */
    public String getMzName()
    {
        return getString("mzName");
    }
    public void setMzName(String item)
    {
        setString("mzName", item);
    }
    /**
     * Object:医生调整成本's 员工编码property 
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
     * Object:医生调整成本's 员工姓名property 
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
     * Object:医生调整成本's 业绩基数property 
     */
    public java.math.BigDecimal getPerformanceBase()
    {
        return getBigDecimal("PerformanceBase");
    }
    public void setPerformanceBase(java.math.BigDecimal item)
    {
        setBigDecimal("PerformanceBase", item);
    }
    /**
     * Object:医生调整成本's 种植调整成本property 
     */
    public java.math.BigDecimal getZjCost()
    {
        return getBigDecimal("zjCost");
    }
    public void setZjCost(java.math.BigDecimal item)
    {
        setBigDecimal("zjCost", item);
    }
    /**
     * Object:医生调整成本's 固定矫正调整成本property 
     */
    public java.math.BigDecimal getGdCost()
    {
        return getBigDecimal("gdCost");
    }
    public void setGdCost(java.math.BigDecimal item)
    {
        setBigDecimal("gdCost", item);
    }
    /**
     * Object:医生调整成本's 隐形矫正调整成本property 
     */
    public java.math.BigDecimal getYxCost()
    {
        return getBigDecimal("yxCost");
    }
    public void setYxCost(java.math.BigDecimal item)
    {
        setBigDecimal("yxCost", item);
    }
    /**
     * Object:医生调整成本's 修复矫正调整成本property 
     */
    public java.math.BigDecimal getXfCost()
    {
        return getBigDecimal("xfCost");
    }
    public void setXfCost(java.math.BigDecimal item)
    {
        setBigDecimal("xfCost", item);
    }
    /**
     * Object:医生调整成本's 儿牙矫正调整成本property 
     */
    public java.math.BigDecimal getEyCost()
    {
        return getBigDecimal("eyCost");
    }
    public void setEyCost(java.math.BigDecimal item)
    {
        setBigDecimal("eyCost", item);
    }
    /**
     * Object:医生调整成本's 口内外调整成本property 
     */
    public java.math.BigDecimal getKnCost()
    {
        return getBigDecimal("knCost");
    }
    public void setKnCost(java.math.BigDecimal item)
    {
        setBigDecimal("knCost", item);
    }
    /**
     * Object:医生调整成本's 美白调整成本property 
     */
    public java.math.BigDecimal getMbCost()
    {
        return getBigDecimal("mbCost");
    }
    public void setMbCost(java.math.BigDecimal item)
    {
        setBigDecimal("mbCost", item);
    }
    /**
     * Object:医生调整成本's 周边调整成本property 
     */
    public java.math.BigDecimal getZbCost()
    {
        return getBigDecimal("zbCost");
    }
    public void setZbCost(java.math.BigDecimal item)
    {
        setBigDecimal("zbCost", item);
    }
    /**
     * Object:医生调整成本's 其它调整成本property 
     */
    public java.math.BigDecimal getQtCost()
    {
        return getBigDecimal("qtCost");
    }
    public void setQtCost(java.math.BigDecimal item)
    {
        setBigDecimal("qtCost", item);
    }
    /**
     * Object:医生调整成本's 导入日期property 
     */
    public java.util.Date getImportDate()
    {
        return getDate("importDate");
    }
    public void setImportDate(java.util.Date item)
    {
        setDate("importDate", item);
    }
    /**
     * Object:医生调整成本's 业务日期(年月)property 
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
     * Object:医生调整成本's 城市编码property 
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
     * Object:医生调整成本's 城市名称property 
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
     * Object:医生调整成本's 导入类型property 
     */
    public com.kingdee.eas.mw.pay.app.costType getCostType()
    {
        return com.kingdee.eas.mw.pay.app.costType.getEnum(getString("costType"));
    }
    public void setCostType(com.kingdee.eas.mw.pay.app.costType item)
    {
		if (item != null) {
        setString("costType", item.getValue());
		}
    }
    /**
     * Object: 医生调整成本 's 城市 property 
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
     * Object:医生调整成本's 是否自带property 
     */
    public boolean isIszidai()
    {
        return getBoolean("iszidai");
    }
    public void setIszidai(boolean item)
    {
        setBoolean("iszidai", item);
    }
    /**
     * Object: 医生调整成本 's 门诊 property 
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
        return new BOSObjectType("83964DF5");
    }
}