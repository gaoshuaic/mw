package com.kingdee.eas.mw.pay;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractConsultKeepInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractConsultKeepInfo()
    {
        this("id");
    }
    protected AbstractConsultKeepInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object:×ÉÑ¯Ô¤Áô's Ô±¹¤±àÂëproperty 
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
     * Object:×ÉÑ¯Ô¤Áô's Ô±¹¤Ãû³Æproperty 
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
     * Object:×ÉÑ¯Ô¤Áô's ÃÅÕï±àÂëproperty 
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
     * Object:×ÉÑ¯Ô¤Áô's ÃÅÕïÃû³Æproperty 
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
     * Object:×ÉÑ¯Ô¤Áô's ÒµÎñÈÕÆÚproperty 
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
     * Object:×ÉÑ¯Ô¤Áô's ³ÇÊÐ±àÂëproperty 
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
     * Object:×ÉÑ¯Ô¤Áô's ³ÇÊÐÃû³Æproperty 
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
     * Object: ×ÉÑ¯Ô¤Áô 's ³ÇÊÐ property 
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
     * Object:×ÉÑ¯Ô¤Áô's ×ÉÑ¯Ô¤Áô½±½ðproperty 
     */
    public java.math.BigDecimal getKeepBouns()
    {
        return getBigDecimal("keepBouns");
    }
    public void setKeepBouns(java.math.BigDecimal item)
    {
        setBigDecimal("keepBouns", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("1B8B6F1F");
    }
}