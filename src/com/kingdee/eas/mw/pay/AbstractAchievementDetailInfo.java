package com.kingdee.eas.mw.pay;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractAchievementDetailInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractAchievementDetailInfo()
    {
        this("id");
    }
    protected AbstractAchievementDetailInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object:ҵ����ϸ's �Ƿ�����ƾ֤property 
     */
    public boolean isFivouchered()
    {
        return getBoolean("Fivouchered");
    }
    public void setFivouchered(boolean item)
    {
        setBoolean("Fivouchered", item);
    }
    /**
     * Object:ҵ����ϸ's ���б���property 
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
     * Object:ҵ����ϸ's ����property 
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
     * Object:ҵ����ϸ's �������property 
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
     * Object:ҵ����ϸ's ����property 
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
     * Object:ҵ����ϸ's ҽ������property 
     */
    public String getDoctorNumber()
    {
        return getString("doctorNumber");
    }
    public void setDoctorNumber(String item)
    {
        setString("doctorNumber", item);
    }
    /**
     * Object:ҵ����ϸ's ���۳��ⵥ��property 
     */
    public String getSaleOutNumber()
    {
        return getString("saleOutNumber");
    }
    public void setSaleOutNumber(String item)
    {
        setString("saleOutNumber", item);
    }
    /**
     * Object:ҵ����ϸ's HIS���۶���IDproperty 
     */
    public String getHsiId()
    {
        return getString("hsiId");
    }
    public void setHsiId(String item)
    {
        setString("hsiId", item);
    }
    /**
     * Object:ҵ����ϸ's HIS���۶�����¼IDproperty 
     */
    public String getHisDetailID()
    {
        return getString("hisDetailID");
    }
    public void setHisDetailID(String item)
    {
        setString("hisDetailID", item);
    }
    /**
     * Object:ҵ����ϸ's ���ӹ�����property 
     */
    public String getMaterial()
    {
        return getString("material");
    }
    public void setMaterial(String item)
    {
        setString("material", item);
    }
    /**
     * Object:ҵ����ϸ's ����property 
     */
    public java.math.BigDecimal getQty()
    {
        return getBigDecimal("qty");
    }
    public void setQty(java.math.BigDecimal item)
    {
        setBigDecimal("qty", item);
    }
    /**
     * Object:ҵ����ϸ's ����property 
     */
    public java.math.BigDecimal getPrice()
    {
        return getBigDecimal("price");
    }
    public void setPrice(java.math.BigDecimal item)
    {
        setBigDecimal("price", item);
    }
    /**
     * Object:ҵ����ϸ's ���property 
     */
    public java.math.BigDecimal getAmount()
    {
        return getBigDecimal("amount");
    }
    public void setAmount(java.math.BigDecimal item)
    {
        setBigDecimal("amount", item);
    }
    /**
     * Object:ҵ����ϸ's ��עproperty 
     */
    public String getRemark()
    {
        return getString("remark");
    }
    public void setRemark(String item)
    {
        setString("remark", item);
    }
    /**
     * Object:ҵ����ϸ's ҽ������property 
     */
    public String getDoctorName()
    {
        return getString("doctorName");
    }
    public void setDoctorName(String item)
    {
        setString("doctorName", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("3251FB6E");
    }
}