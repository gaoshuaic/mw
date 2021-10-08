package com.kingdee.eas.mw.pay;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractErrorAchieveInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractErrorAchieveInfo()
    {
        this("id");
    }
    protected AbstractErrorAchieveInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object:�쳣ҵ��'s �������property 
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
     * Object:�쳣ҵ��'s ��������property 
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
     * Object:�쳣ҵ��'s ҵ������property 
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
     * Object: �쳣ҵ�� 's ���� property 
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
     * Object: �쳣ҵ�� 's ���� property 
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
     * Object:�쳣ҵ��'s ���۳��ⵥ��property 
     */
    public String getSaleoutNumber()
    {
        return getString("saleoutNumber");
    }
    public void setSaleoutNumber(String item)
    {
        setString("saleoutNumber", item);
    }
    /**
     * Object:�쳣ҵ��'s HIS���㵥IDproperty 
     */
    public String getHisorderid()
    {
        return getString("hisorderid");
    }
    public void setHisorderid(String item)
    {
        setString("hisorderid", item);
    }
    /**
     * Object:�쳣ҵ��'s HIS���㵥��ϸIDproperty 
     */
    public String getHisorderDetailid()
    {
        return getString("hisorderDetailid");
    }
    public void setHisorderDetailid(String item)
    {
        setString("hisorderDetailid", item);
    }
    /**
     * Object:�쳣ҵ��'s �շ���Ŀ����property 
     */
    public String getItemNumber()
    {
        return getString("itemNumber");
    }
    public void setItemNumber(String item)
    {
        setString("itemNumber", item);
    }
    /**
     * Object:�쳣ҵ��'s �շ���Ŀ����property 
     */
    public String getItemName()
    {
        return getString("itemName");
    }
    public void setItemName(String item)
    {
        setString("itemName", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("6E507F5B");
    }
}