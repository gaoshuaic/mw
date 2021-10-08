package com.kingdee.eas.mw.pay;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractEmpShopDeployInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractEmpShopDeployInfo()
    {
        this("id");
    }
    protected AbstractEmpShopDeployInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object:Ա���ŵ�������'s Ա������property 
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
     * Object:Ա���ŵ�������'s Ա������property 
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
     * Object:Ա���ŵ�������'s ҵ������(����)property 
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
     * Object:Ա���ŵ�������'s �������property 
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
     * Object:Ա���ŵ�������'s ��������property 
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
     * Object:Ա���ŵ�������'s �ŵ��Сproperty 
     */
    public com.kingdee.eas.mw.pay.app.ShopSize getShopSize()
    {
        return com.kingdee.eas.mw.pay.app.ShopSize.getEnum(getString("shopSize"));
    }
    public void setShopSize(com.kingdee.eas.mw.pay.app.ShopSize item)
    {
		if (item != null) {
        setString("shopSize", item.getValue());
		}
    }
    /**
     * Object:Ա���ŵ�������'s ���б���property 
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
     * Object:Ա���ŵ�������'s ��������property 
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
     * Object: Ա���ŵ������� 's ���� property 
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
     * Object: Ա���ŵ������� 's ��ѯ���� property 
     */
    public com.kingdee.eas.mw.pay.ConsultTypeInfo getConType()
    {
        return (com.kingdee.eas.mw.pay.ConsultTypeInfo)get("conType");
    }
    public void setConType(com.kingdee.eas.mw.pay.ConsultTypeInfo item)
    {
        put("conType", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("A54E3073");
    }
}