package com.kingdee.eas.mw.pay;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractHaopingMessageInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractHaopingMessageInfo()
    {
        this("id");
    }
    protected AbstractHaopingMessageInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object:好评信息's 门诊编码property 
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
     * Object:好评信息's 门诊名称property 
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
     * Object:好评信息's 员工编码property 
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
     * Object:好评信息's 员工姓名property 
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
     * Object:好评信息's 好评数量property 
     */
    public java.math.BigDecimal getPraiseNum()
    {
        return getBigDecimal("PraiseNum");
    }
    public void setPraiseNum(java.math.BigDecimal item)
    {
        setBigDecimal("PraiseNum", item);
    }
    /**
     * Object:好评信息's 业务日期(年月)property 
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
     * Object:好评信息's 导入日期property 
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
        return new BOSObjectType("E7834991");
    }
}