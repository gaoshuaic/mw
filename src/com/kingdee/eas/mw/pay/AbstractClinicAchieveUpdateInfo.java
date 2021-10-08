package com.kingdee.eas.mw.pay;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractClinicAchieveUpdateInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractClinicAchieveUpdateInfo()
    {
        this("id");
    }
    protected AbstractClinicAchieveUpdateInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object:����ҵ������'s ����/���б���property 
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
     * Object:����ҵ������'s ����/��������property 
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
     * Object:����ҵ������'s ����ҵ��property 
     */
    public java.math.BigDecimal getClinicAchieve()
    {
        return getBigDecimal("clinicAchieve");
    }
    public void setClinicAchieve(java.math.BigDecimal item)
    {
        setBigDecimal("clinicAchieve", item);
    }
    /**
     * Object:����ҵ������'s Ӫ��(����)property 
     */
    public java.math.BigDecimal getIncome()
    {
        return getBigDecimal("income");
    }
    public void setIncome(java.math.BigDecimal item)
    {
        setBigDecimal("income", item);
    }
    /**
     * Object:����ҵ������'s ֧��(��ˮ)property 
     */
    public java.math.BigDecimal getDiary()
    {
        return getBigDecimal("diary");
    }
    public void setDiary(java.math.BigDecimal item)
    {
        setBigDecimal("diary", item);
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
     * Object:����ҵ������'s �Ƿ�Ϊ����property 
     */
    public com.kingdee.eas.mw.pay.app.CityOrClinic getIsClinic()
    {
        return com.kingdee.eas.mw.pay.app.CityOrClinic.getEnum(getString("isClinic"));
    }
    public void setIsClinic(com.kingdee.eas.mw.pay.app.CityOrClinic item)
    {
		if (item != null) {
        setString("isClinic", item.getValue());
		}
    }
    /**
     * Object: ����ҵ������ 's ����/��˾ property 
     */
    public com.kingdee.eas.basedata.org.AdminOrgUnitInfo getClinic()
    {
        return (com.kingdee.eas.basedata.org.AdminOrgUnitInfo)get("clinic");
    }
    public void setClinic(com.kingdee.eas.basedata.org.AdminOrgUnitInfo item)
    {
        put("clinic", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("4E75FE00");
    }
}