package com.kingdee.eas.mw.pay;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractPayPostInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractPayPostInfo()
    {
        this("id");
    }
    protected AbstractPayPostInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object:н�ʸ�λ's ״̬property 
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
     * Object:н�ʸ�λ's ��λ����property 
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
     * Object:н�ʸ�λ's Ա������property 
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
     * Object:н�ʸ�λ's Ա������property 
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
     * Object:н�ʸ�λ's �������property 
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
     * Object:н�ʸ�λ's ��������property 
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
     * Object:н�ʸ�λ's ��λproperty 
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
     * Object: н�ʸ�λ 's ���� property 
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
     * Object: н�ʸ�λ 's ���� property 
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
     * Object:н�ʸ�λ's ҵ���ڼ�property 
     */
    public String getBusinessdate()
    {
        return getString("businessdate");
    }
    public void setBusinessdate(String item)
    {
        setString("businessdate", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("F5B6C9F6");
    }
}