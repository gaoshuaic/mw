package com.kingdee.eas.mw.pay;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractClinicMonthSumInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractClinicMonthSumInfo()
    {
        this("id");
    }
    protected AbstractClinicMonthSumInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object:�����»���'s ҵ������property 
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
     * Object:�����»���'s ���б���property 
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
     * Object:�����»���'s ����property 
     */
    public String getCity()
    {
        return getString("city");
    }
    public void setCity(String item)
    {
        setString("city", item);
    }
    /**
     * Object:�����»���'s �������property 
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
     * Object:�����»���'s ��������property 
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
     * Object:�����»���'s ֧��(��ˮ)property 
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
     * Object:�����»���'s Ӫ��(����)property 
     */
    public java.math.BigDecimal getInCome()
    {
        return getBigDecimal("inCome");
    }
    public void setInCome(java.math.BigDecimal item)
    {
        setBigDecimal("inCome", item);
    }
    /**
     * Object:�����»���'s ����IDproperty 
     */
    public String getCityid()
    {
        return getString("cityid");
    }
    public void setCityid(String item)
    {
        setString("cityid", item);
    }
    /**
     * Object:�����»���'s ����idproperty 
     */
    public String getClinicid()
    {
        return getString("clinicid");
    }
    public void setClinicid(String item)
    {
        setString("clinicid", item);
    }
    /**
     * Object:�����»���'s ��ˮproperty 
     */
    public java.math.BigDecimal getLiushui()
    {
        return getBigDecimal("liushui");
    }
    public void setLiushui(java.math.BigDecimal item)
    {
        setBigDecimal("liushui", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("90056865");
    }
}