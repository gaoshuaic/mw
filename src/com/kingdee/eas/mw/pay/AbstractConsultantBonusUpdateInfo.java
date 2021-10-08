package com.kingdee.eas.mw.pay;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractConsultantBonusUpdateInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractConsultantBonusUpdateInfo()
    {
        this("id");
    }
    protected AbstractConsultantBonusUpdateInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object:��ѯʦҵ������'s Ա������property 
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
     * Object:��ѯʦҵ������'s Ա������property 
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
     * Object:��ѯʦҵ������'s �������property 
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
     * Object:��ѯʦҵ������'s ��������property 
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
     * Object:��ѯʦҵ������'s ��ѯҵ��property 
     */
    public java.math.BigDecimal getZxAchieve()
    {
        return getBigDecimal("zxAchieve");
    }
    public void setZxAchieve(java.math.BigDecimal item)
    {
        setBigDecimal("zxAchieve", item);
    }
    /**
     * Object:��ѯʦҵ������'s ҵ������property 
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
     * Object:��ѯʦҵ������'s ���б���property 
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
     * Object:��ѯʦҵ������'s ��������property 
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
     * Object: ��ѯʦҵ������ 's ���� property 
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
     * Object:��ѯʦҵ������'s ȫ��ҵ��property 
     */
    public java.math.BigDecimal getAllGenAchieve()
    {
        return getBigDecimal("allGenAchieve");
    }
    public void setAllGenAchieve(java.math.BigDecimal item)
    {
        setBigDecimal("allGenAchieve", item);
    }
    /**
     * Object: ��ѯʦҵ������ 's ���� property 
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
     * Object:��ѯʦҵ������'s �ܱ߲�Ʒҵ��property 
     */
    public java.math.BigDecimal getZpAchieve()
    {
        return getBigDecimal("zpAchieve");
    }
    public void setZpAchieve(java.math.BigDecimal item)
    {
        setBigDecimal("zpAchieve", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("8EF4785B");
    }
}