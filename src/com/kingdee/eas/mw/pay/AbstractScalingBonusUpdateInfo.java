package com.kingdee.eas.mw.pay;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractScalingBonusUpdateInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractScalingBonusUpdateInfo()
    {
        this("id");
    }
    protected AbstractScalingBonusUpdateInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object:����ҵ������'s Ա������property 
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
     * Object:����ҵ������'s Ա������property 
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
     * Object:����ҵ������'s ��������property 
     */
    public java.math.BigDecimal getJyCount()
    {
        return getBigDecimal("jyCount");
    }
    public void setJyCount(java.math.BigDecimal item)
    {
        setBigDecimal("jyCount", item);
    }
    /**
     * Object:����ҵ������'s �����´���property 
     */
    public java.math.BigDecimal getPlaCount()
    {
        return getBigDecimal("plaCount");
    }
    public void setPlaCount(java.math.BigDecimal item)
    {
        setBigDecimal("plaCount", item);
    }
    /**
     * Object:����ҵ������'s ҵ������property 
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
     * Object:����ҵ������'s �������property 
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
     * Object:����ҵ������'s ��������property 
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
     * Object:����ҵ������'s ���б���property 
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
     * Object:����ҵ������'s ��������property 
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
     * Object: ����ҵ������ 's ���� property 
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
     * Object: ����ҵ������ 's ���� property 
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
     * Object:����ҵ������'s ����property 
     */
    public com.kingdee.eas.mw.pay.app.imjyType getImType()
    {
        return com.kingdee.eas.mw.pay.app.imjyType.getEnum(getString("imType"));
    }
    public void setImType(com.kingdee.eas.mw.pay.app.imjyType item)
    {
		if (item != null) {
        setString("imType", item.getValue());
		}
    }
    /**
     * Object: ����ҵ������ 's �������� property 
     */
    public com.kingdee.eas.mw.pay.ScalingTypeInfo getJyType()
    {
        return (com.kingdee.eas.mw.pay.ScalingTypeInfo)get("jyType");
    }
    public void setJyType(com.kingdee.eas.mw.pay.ScalingTypeInfo item)
    {
        put("jyType", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("7A9C8E73");
    }
}