package com.kingdee.eas.mw.pay;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractMarketDateInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractMarketDateInfo()
    {
        this("id");
    }
    protected AbstractMarketDateInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object:市场数据's 员工编码property 
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
     * Object:市场数据's 员工姓名property 
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
     * Object:市场数据's 出诊人数property 
     */
    public java.math.BigDecimal getVisitNumber()
    {
        return getBigDecimal("visitNumber");
    }
    public void setVisitNumber(java.math.BigDecimal item)
    {
        setBigDecimal("visitNumber", item);
    }
    /**
     * Object:市场数据's 业绩类型property 
     */
    public com.kingdee.eas.mw.pay.app.achieveType getAchieveType()
    {
        return com.kingdee.eas.mw.pay.app.achieveType.getEnum(getString("achieveType"));
    }
    public void setAchieveType(com.kingdee.eas.mw.pay.app.achieveType item)
    {
		if (item != null) {
        setString("achieveType", item.getValue());
		}
    }
    /**
     * Object:市场数据's 业绩property 
     */
    public String getAchieve()
    {
        return getString("achieve");
    }
    public void setAchieve(String item)
    {
        setString("achieve", item);
    }
    /**
     * Object:市场数据's 60场次数property 
     */
    public java.math.BigDecimal getSixtyCount()
    {
        return getBigDecimal("sixtyCount");
    }
    public void setSixtyCount(java.math.BigDecimal item)
    {
        setBigDecimal("sixtyCount", item);
    }
    /**
     * Object:市场数据's 80场次数property 
     */
    public java.math.BigDecimal getEightyCount()
    {
        return getBigDecimal("eightyCount");
    }
    public void setEightyCount(java.math.BigDecimal item)
    {
        setBigDecimal("eightyCount", item);
    }
    /**
     * Object:市场数据's 100场次数property 
     */
    public java.math.BigDecimal getHundredCount()
    {
        return getBigDecimal("hundredCount");
    }
    public void setHundredCount(java.math.BigDecimal item)
    {
        setBigDecimal("hundredCount", item);
    }
    /**
     * Object:市场数据's 业务日期(年月)property 
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
     * Object:市场数据's 备注property 
     */
    public String getRemake()
    {
        return getString("remake");
    }
    public void setRemake(String item)
    {
        setString("remake", item);
    }
    /**
     * Object:市场数据's 导入日期property 
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
        return new BOSObjectType("D18566BC");
    }
}