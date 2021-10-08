package com.kingdee.eas.mw.pay;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractServiceAmountInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractServiceAmountInfo()
    {
        this("id");
    }
    protected AbstractServiceAmountInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object:服务金额's 门诊编码property 
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
     * Object:服务金额's 门诊公司名称property 
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
     * Object:服务金额's 员工编码property 
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
     * Object:服务金额's 员工姓名property 
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
     * Object:服务金额's 金额-护理property 
     */
    public java.math.BigDecimal getHlAmount()
    {
        return getBigDecimal("hlAmount");
    }
    public void setHlAmount(java.math.BigDecimal item)
    {
        setBigDecimal("hlAmount", item);
    }
    /**
     * Object:服务金额's 金额-卡类销售property 
     */
    public java.math.BigDecimal getKlxsAmount()
    {
        return getBigDecimal("klxsAmount");
    }
    public void setKlxsAmount(java.math.BigDecimal item)
    {
        setBigDecimal("klxsAmount", item);
    }
    /**
     * Object:服务金额's 金额-门店支援property 
     */
    public java.math.BigDecimal getMdzyAmount()
    {
        return getBigDecimal("mdzyAmount");
    }
    public void setMdzyAmount(java.math.BigDecimal item)
    {
        setBigDecimal("mdzyAmount", item);
    }
    /**
     * Object:服务金额's 金额-客户property 
     */
    public java.math.BigDecimal getKhAmount()
    {
        return getBigDecimal("khAmount");
    }
    public void setKhAmount(java.math.BigDecimal item)
    {
        setBigDecimal("khAmount", item);
    }
    /**
     * Object:服务金额's 业务日期(年月)property 
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
     * Object:服务金额's 导入日期property 
     */
    public java.util.Date getImportDate()
    {
        return getDate("importDate");
    }
    public void setImportDate(java.util.Date item)
    {
        setDate("importDate", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("6DE2E57B");
    }
}