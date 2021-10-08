package com.kingdee.eas.mw.pay;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractAchRoyaltyRuleInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractAchRoyaltyRuleInfo()
    {
        this("id");
    }
    protected AbstractAchRoyaltyRuleInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object:��Ч��ɹ�������'s ״̬property 
     */
    public com.kingdee.eas.mw.pay.app.PayPostStatus getStatus()
    {
        return com.kingdee.eas.mw.pay.app.PayPostStatus.getEnum(getString("status"));
    }
    public void setStatus(com.kingdee.eas.mw.pay.app.PayPostStatus item)
    {
		if (item != null) {
        setString("status", item.getValue());
		}
    }
    /**
     * Object:��Ч��ɹ�������'s Ա������property 
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
     * Object:��Ч��ɹ�������'s Ա������property 
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
     * Object:��Ч��ɹ�������'s ���б���property 
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
     * Object:��Ч��ɹ�������'s ��������property 
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
     * Object:��Ч��ɹ�������'s ��ҵ������ҵ��property 
     */
    public java.math.BigDecimal getBaseAch()
    {
        return getBigDecimal("baseAch");
    }
    public void setBaseAch(java.math.BigDecimal item)
    {
        setBigDecimal("baseAch", item);
    }
    /**
     * Object:��Ч��ɹ�������'s �ŵ���ɱ���property 
     */
    public java.math.BigDecimal getShopPro()
    {
        return getBigDecimal("shopPro");
    }
    public void setShopPro(java.math.BigDecimal item)
    {
        setBigDecimal("shopPro", item);
    }
    /**
     * Object:��Ч��ɹ�������'s ������ѯ��ɱ���property 
     */
    public java.math.BigDecimal getPersonPro()
    {
        return getBigDecimal("personPro");
    }
    public void setPersonPro(java.math.BigDecimal item)
    {
        setBigDecimal("personPro", item);
    }
    /**
     * Object:��Ч��ɹ�������'s ��ҵ����ɱ���property 
     */
    public java.math.BigDecimal getBusinessPro()
    {
        return getBigDecimal("businessPro");
    }
    public void setBusinessPro(java.math.BigDecimal item)
    {
        setBigDecimal("businessPro", item);
    }
    /**
     * Object:��Ч��ɹ�������'s ���ٽ��property 
     */
    public java.math.BigDecimal getReduceAmount()
    {
        return getBigDecimal("reduceAmount");
    }
    public void setReduceAmount(java.math.BigDecimal item)
    {
        setBigDecimal("reduceAmount", item);
    }
    /**
     * Object:��Ч��ɹ�������'s �������property 
     */
    public java.math.BigDecimal getRewardAmount()
    {
        return getBigDecimal("rewardAmount");
    }
    public void setRewardAmount(java.math.BigDecimal item)
    {
        setBigDecimal("rewardAmount", item);
    }
    /**
     * Object:��Ч��ɹ�������'s �������property 
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
     * Object:��Ч��ɹ�������'s ��������property 
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
     * Object:��Ч��ɹ�������'s ���ñ���property 
     */
    public String getOtherNumber()
    {
        return getString("otherNumber");
    }
    public void setOtherNumber(String item)
    {
        setString("otherNumber", item);
    }
    /**
     * Object: ��Ч��ɹ������� 's ���� property 
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
     * Object: ��Ч��ɹ������� 's ���� property 
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
     * Object:��Ч��ɹ�������'s �ŵ���property 
     */
    public com.kingdee.eas.mw.pay.app.ClinicOtherSize getClinicType()
    {
        return com.kingdee.eas.mw.pay.app.ClinicOtherSize.getEnum(getString("clinicType"));
    }
    public void setClinicType(com.kingdee.eas.mw.pay.app.ClinicOtherSize item)
    {
		if (item != null) {
        setString("clinicType", item.getValue());
		}
    }
    /**
     * Object:��Ч��ɹ�������'s �ŵ���ɱ����ı�property 
     */
    public String getShopProText()
    {
        return getString("shopProText");
    }
    public void setShopProText(String item)
    {
        setString("shopProText", item);
    }
    /**
     * Object:��Ч��ɹ�������'s ��ҵ����ɱ����ı�property 
     */
    public String getBusinessProText()
    {
        return getString("businessProText");
    }
    public void setBusinessProText(String item)
    {
        setString("businessProText", item);
    }
    /**
     * Object:��Ч��ɹ�������'s ������ѯ�����ı�property 
     */
    public String getPersonProText()
    {
        return getString("personProText");
    }
    public void setPersonProText(String item)
    {
        setString("personProText", item);
    }
    /**
     * Object:��Ч��ɹ�������'s ��нproperty 
     */
    public java.math.BigDecimal getBasePay()
    {
        return getBigDecimal("basePay");
    }
    public void setBasePay(java.math.BigDecimal item)
    {
        setBigDecimal("basePay", item);
    }
    /**
     * Object:��Ч��ɹ�������'s �������ҵ��property 
     */
    public java.math.BigDecimal getClinicbaseAch()
    {
        return getBigDecimal("clinicbaseAch");
    }
    public void setClinicbaseAch(java.math.BigDecimal item)
    {
        setBigDecimal("clinicbaseAch", item);
    }
    /**
     * Object:��Ч��ɹ�������'s ҵ���ڼ�property 
     */
    public String getBusinessDate()
    {
        return getString("businessDate");
    }
    public void setBusinessDate(String item)
    {
        setString("businessDate", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("19F27034");
    }
}