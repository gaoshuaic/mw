package com.kingdee.eas.mw.pay;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractDepartMonthMsgInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractDepartMonthMsgInfo()
    {
        this("id");
    }
    protected AbstractDepartMonthMsgInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object:门诊月度信息's 门诊编码property 
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
     * Object:门诊月度信息's 门诊名称property 
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
     * Object:门诊月度信息's 差评数量property 
     */
    public java.math.BigDecimal getBadNum()
    {
        return getBigDecimal("badNum");
    }
    public void setBadNum(java.math.BigDecimal item)
    {
        setBigDecimal("badNum", item);
    }
    /**
     * Object:门诊月度信息's 导入日期property 
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
     * Object:门诊月度信息's 业务日期(年月)property 
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
     * Object:门诊月度信息's 状态property 
     */
    public com.kingdee.eas.mw.pay.app.msgStatus getStatus()
    {
        return com.kingdee.eas.mw.pay.app.msgStatus.getEnum(getString("status"));
    }
    public void setStatus(com.kingdee.eas.mw.pay.app.msgStatus item)
    {
		if (item != null) {
        setString("status", item.getValue());
		}
    }
    /**
     * Object: 门诊月度信息 's 城市 property 
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
     * Object: 门诊月度信息 's 门诊 property 
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
        return new BOSObjectType("01ACB8A7");
    }
}