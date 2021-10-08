package com.kingdee.eas.mw.pay;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractBudgetDateInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractBudgetDateInfo()
    {
        this("id");
    }
    protected AbstractBudgetDateInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object:预算表's 公司编码property 
     */
    public String getComNumber()
    {
        return getString("comNumber");
    }
    public void setComNumber(String item)
    {
        setString("comNumber", item);
    }
    /**
     * Object:预算表's 公司名称property 
     */
    public String getComName()
    {
        return getString("comName");
    }
    public void setComName(String item)
    {
        setString("comName", item);
    }
    /**
     * Object:预算表's 目标业绩property 
     */
    public java.math.BigDecimal getTarget()
    {
        return getBigDecimal("target");
    }
    public void setTarget(java.math.BigDecimal item)
    {
        setBigDecimal("target", item);
    }
    /**
     * Object:预算表's 人数property 
     */
    public java.math.BigDecimal getPerNum()
    {
        return getBigDecimal("perNum");
    }
    public void setPerNum(java.math.BigDecimal item)
    {
        setBigDecimal("perNum", item);
    }
    /**
     * Object:预算表's 预算（金额）property 
     */
    public java.math.BigDecimal getAmount()
    {
        return getBigDecimal("amount");
    }
    public void setAmount(java.math.BigDecimal item)
    {
        setBigDecimal("amount", item);
    }
    /**
     * Object:预算表's 编制property 
     */
    public String getOrganization()
    {
        return getString("organization");
    }
    public void setOrganization(String item)
    {
        setString("organization", item);
    }
    /**
     * Object:预算表's 业务日期(年月)property 
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
     * Object:预算表's 导入日期property 
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
     * Object:预算表's 类型property 
     */
    public com.kingdee.eas.mw.pay.app.BudgeType getType()
    {
        return com.kingdee.eas.mw.pay.app.BudgeType.getEnum(getString("type"));
    }
    public void setType(com.kingdee.eas.mw.pay.app.BudgeType item)
    {
		if (item != null) {
        setString("type", item.getValue());
		}
    }
    /**
     * Object:预算表's 门诊大小property 
     */
    public com.kingdee.eas.mw.pay.app.ClinicOtherSize getClinicShop()
    {
        return com.kingdee.eas.mw.pay.app.ClinicOtherSize.getEnum(getString("clinicShop"));
    }
    public void setClinicShop(com.kingdee.eas.mw.pay.app.ClinicOtherSize item)
    {
		if (item != null) {
        setString("clinicShop", item.getValue());
		}
    }
    /**
     * Object: 预算表 's 公司 property 
     */
    public com.kingdee.eas.basedata.org.CompanyOrgUnitInfo getCompany()
    {
        return (com.kingdee.eas.basedata.org.CompanyOrgUnitInfo)get("company");
    }
    public void setCompany(com.kingdee.eas.basedata.org.CompanyOrgUnitInfo item)
    {
        put("company", item);
    }
    /**
     * Object:预算表's 牙椅数量property 
     */
    public java.math.BigDecimal getYlNum()
    {
        return getBigDecimal("ylNum");
    }
    public void setYlNum(java.math.BigDecimal item)
    {
        setBigDecimal("ylNum", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("65CCD545");
    }
}