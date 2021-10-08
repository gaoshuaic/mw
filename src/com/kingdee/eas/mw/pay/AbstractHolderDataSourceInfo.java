package com.kingdee.eas.mw.pay;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractHolderDataSourceInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractHolderDataSourceInfo()
    {
        this("id");
    }
    protected AbstractHolderDataSourceInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object:压膜保持器数据源's 门诊编码property 
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
     * Object:压膜保持器数据源's 门诊名称property 
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
     * Object:压膜保持器数据源's 医生编码property 
     */
    public String getDoctorNumber()
    {
        return getString("doctorNumber");
    }
    public void setDoctorNumber(String item)
    {
        setString("doctorNumber", item);
    }
    /**
     * Object:压膜保持器数据源's 医生姓名property 
     */
    public String getDoctorName()
    {
        return getString("doctorName");
    }
    public void setDoctorName(String item)
    {
        setString("doctorName", item);
    }
    /**
     * Object:压膜保持器数据源's 护士编码property 
     */
    public String getNurseNumber()
    {
        return getString("nurseNumber");
    }
    public void setNurseNumber(String item)
    {
        setString("nurseNumber", item);
    }
    /**
     * Object:压膜保持器数据源's 护士姓名property 
     */
    public String getNurseName()
    {
        return getString("nurseName");
    }
    public void setNurseName(String item)
    {
        setString("nurseName", item);
    }
    /**
     * Object:压膜保持器数据源's 半口数量property 
     */
    public java.math.BigDecimal getBkNum()
    {
        return getBigDecimal("bkNum");
    }
    public void setBkNum(java.math.BigDecimal item)
    {
        setBigDecimal("bkNum", item);
    }
    /**
     * Object:压膜保持器数据源's 全口数量property 
     */
    public java.math.BigDecimal getQkNum()
    {
        return getBigDecimal("qkNum");
    }
    public void setQkNum(java.math.BigDecimal item)
    {
        setBigDecimal("qkNum", item);
    }
    /**
     * Object:压膜保持器数据源's 导入日期property 
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
     * Object:压膜保持器数据源's 业务日期(年月)property 
     */
    public String getBusinessDate()
    {
        return getString("businessDate");
    }
    public void setBusinessDate(String item)
    {
        setString("businessDate", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("B665FE63");
    }
}