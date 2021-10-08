package com.kingdee.eas.mw.pay;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractBaoDiImpMoneyInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractBaoDiImpMoneyInfo()
    {
        this("id");
    }
    protected AbstractBaoDiImpMoneyInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object:���׵��뽱��'s Ա������property 
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
     * Object:���׵��뽱��'s Ա������property 
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
     * Object:���׵��뽱��'s �������property 
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
     * Object:���׵��뽱��'s ��������property 
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
     * Object:���׵��뽱��'s ҵ������property 
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
     * Object:���׵��뽱��'s ���б���property 
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
     * Object:���׵��뽱��'s ��������property 
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
     * Object: ���׵��뽱�� 's ���� property 
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
     * Object: ���׵��뽱�� 's ���� property 
     */
    public com.kingdee.eas.basedata.org.CompanyOrgUnitInfo getClinic()
    {
        return (com.kingdee.eas.basedata.org.CompanyOrgUnitInfo)get("clinic");
    }
    public void setClinic(com.kingdee.eas.basedata.org.CompanyOrgUnitInfo item)
    {
        put("clinic", item);
    }
    /**
     * Object:���׵��뽱��'s ����ҵ��property 
     */
    public java.math.BigDecimal getImpAchieve()
    {
        return getBigDecimal("impAchieve");
    }
    public void setImpAchieve(java.math.BigDecimal item)
    {
        setBigDecimal("impAchieve", item);
    }
    /**
     * Object:���׵��뽱��'s ����ɱ�property 
     */
    public java.math.BigDecimal getImpCost()
    {
        return getBigDecimal("impCost");
    }
    public void setImpCost(java.math.BigDecimal item)
    {
        setBigDecimal("impCost", item);
    }
    /**
     * Object:���׵��뽱��'s �������property 
     */
    public java.math.BigDecimal getImpPro()
    {
        return getBigDecimal("impPro");
    }
    public void setImpPro(java.math.BigDecimal item)
    {
        setBigDecimal("impPro", item);
    }
    /**
     * Object:���׵��뽱��'s ��������property 
     */
    public com.kingdee.eas.mw.pay.app.BaoDiType getBaodiType()
    {
        return com.kingdee.eas.mw.pay.app.BaoDiType.getEnum(getString("baodiType"));
    }
    public void setBaodiType(com.kingdee.eas.mw.pay.app.BaoDiType item)
    {
		if (item != null) {
        setString("baodiType", item.getValue());
		}
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("6C26B637");
    }
}