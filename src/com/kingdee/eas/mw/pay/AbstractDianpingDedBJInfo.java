package com.kingdee.eas.mw.pay;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractDianpingDedBJInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractDianpingDedBJInfo()
    {
        this("id");
    }
    protected AbstractDianpingDedBJInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object:点评扣款北京's 员工编码property 
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
     * Object:点评扣款北京's 员工名称property 
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
     * Object:点评扣款北京's 大众点评人数property 
     */
    public java.math.BigDecimal getDianpingNum()
    {
        return getBigDecimal("dianpingNum");
    }
    public void setDianpingNum(java.math.BigDecimal item)
    {
        setBigDecimal("dianpingNum", item);
    }
    /**
     * Object:点评扣款北京's 电视台人数property 
     */
    public java.math.BigDecimal getTVNum()
    {
        return getBigDecimal("TVNum");
    }
    public void setTVNum(java.math.BigDecimal item)
    {
        setBigDecimal("TVNum", item);
    }
    /**
     * Object:点评扣款北京's 其他电视台人数property 
     */
    public java.math.BigDecimal getOtherTVNum()
    {
        return getBigDecimal("otherTVNum");
    }
    public void setOtherTVNum(java.math.BigDecimal item)
    {
        setBigDecimal("otherTVNum", item);
    }
    /**
     * Object:点评扣款北京's 网络人数property 
     */
    public java.math.BigDecimal getWebNum()
    {
        return getBigDecimal("webNum");
    }
    public void setWebNum(java.math.BigDecimal item)
    {
        setBigDecimal("webNum", item);
    }
    /**
     * Object:点评扣款北京's 竞价认识property 
     */
    public java.math.BigDecimal getBidNum()
    {
        return getBigDecimal("bidNum");
    }
    public void setBidNum(java.math.BigDecimal item)
    {
        setBigDecimal("bidNum", item);
    }
    /**
     * Object:点评扣款北京's 个人业绩property 
     */
    public java.math.BigDecimal getPersonYJ()
    {
        return getBigDecimal("personYJ");
    }
    public void setPersonYJ(java.math.BigDecimal item)
    {
        setBigDecimal("personYJ", item);
    }
    /**
     * Object:点评扣款北京's 薪资周期property 
     */
    public java.math.BigDecimal getBussDate()
    {
        return getBigDecimal("bussDate");
    }
    public void setBussDate(java.math.BigDecimal item)
    {
        setBigDecimal("bussDate", item);
    }
    /**
     * Object:点评扣款北京's 导入日期property 
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
        return new BOSObjectType("A5507015");
    }
}