package com.kingdee.eas.mw.pay;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractAttendanceProInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractAttendanceProInfo()
    {
        this("id");
    }
    protected AbstractAttendanceProInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object:���ڱ�����'s ��λ����property 
     */
    public String getPostName()
    {
        return getString("postName");
    }
    public void setPostName(String item)
    {
        setString("postName", item);
    }
    /**
     * Object:���ڱ�����'s Ա������property 
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
     * Object:���ڱ�����'s Ա������property 
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
     * Object:���ڱ�����'s �������property 
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
     * Object:���ڱ�����'s ��������property 
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
     * Object:���ڱ�����'s ��λproperty 
     */
    public com.kingdee.eas.mw.pay.app.PaypostType getPostNumber()
    {
        return com.kingdee.eas.mw.pay.app.PaypostType.getEnum(getString("postNumber"));
    }
    public void setPostNumber(com.kingdee.eas.mw.pay.app.PaypostType item)
    {
		if (item != null) {
        setString("postNumber", item.getValue());
		}
    }
    /**
     * Object: ���ڱ����� 's ���� property 
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
     * Object: ���ڱ����� 's ���� property 
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
     * Object:���ڱ�����'s ҵ���ڼ�property 
     */
    public String getBusinessdate()
    {
        return getString("businessdate");
    }
    public void setBusinessdate(String item)
    {
        setString("businessdate", item);
    }
    /**
     * Object:���ڱ�����'s ���ڱ���property 
     */
    public java.math.BigDecimal getAttendPro()
    {
        return getBigDecimal("attendPro");
    }
    public void setAttendPro(java.math.BigDecimal item)
    {
        setBigDecimal("attendPro", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("D2D48112");
    }
}