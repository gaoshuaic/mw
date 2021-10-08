package com.kingdee.eas.mw.pay;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractCostDetailInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractCostDetailInfo()
    {
        this("id");
    }
    protected AbstractCostDetailInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object:�ɱ���ϸ's �Ƿ�����ƾ֤property 
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
     * Object:�ɱ���ϸ's ���б���property 
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
     * Object:�ɱ���ϸ's ����property 
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
     * Object:�ɱ���ϸ's �������property 
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
     * Object:�ɱ���ϸ's ����property 
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
     * Object:�ɱ���ϸ's ҽ������property 
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
     * Object:�ɱ���ϸ's ���۳��ⵥ��property 
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
     * Object:�ɱ���ϸ's HIS���۶���IDproperty 
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
     * Object:�ɱ���ϸ's HIS���۶�����¼IDproperty 
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
     * Object:�ɱ���ϸ's ���ϱ���property 
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
     * Object:�ɱ���ϸ's ����property 
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
     * Object:�ɱ���ϸ's ����property 
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
     * Object:�ɱ���ϸ's ���property 
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
     * Object:�ɱ���ϸ's ��עproperty 
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
     * Object:�ɱ���ϸ's ҽ������property 
     */
    public String getDoctorName()
    {
        return getString("doctorName");
    }
    public void setDoctorName(String item)
    {
        setString("doctorName", item);
    }
    /**
     * Object:�ɱ���ϸ's his�շ���Ŀ��ϸproperty 
     */
    public String getHisPayTypeDetail()
    {
        return getString("hisPayTypeDetail");
    }
    public void setHisPayTypeDetail(String item)
    {
        setString("hisPayTypeDetail", item);
    }
    /**
     * Object:�ɱ���ϸ's �ڼ�property 
     */
    public String getPeriod()
    {
        return getString("period");
    }
    public void setPeriod(String item)
    {
        setString("period", item);
    }
    /**
     * Object:�ɱ���ϸ's ����property 
     */
    public String getType()
    {
        return getString("type");
    }
    public void setType(String item)
    {
        setString("type", item);
    }
    /**
     * Object:�ɱ���ϸ's ��������property 
     */
    public String getMaterialName()
    {
        return getString("materialName");
    }
    public void setMaterialName(String item)
    {
        setString("materialName", item);
    }
    /**
     * Object:�ɱ���ϸ's �Ƿ񳣹����property 
     */
    public String getIscgjz()
    {
        return getString("iscgjz");
    }
    public void setIscgjz(String item)
    {
        setString("iscgjz", item);
    }
    /**
     * Object:�ɱ���ϸ's his�����շ���Ŀproperty 
     */
    public String getHisChargeItem()
    {
        return getString("hisChargeItem");
    }
    public void setHisChargeItem(String item)
    {
        setString("hisChargeItem", item);
    }
    /**
     * Object:�ɱ���ϸ's ҽ���������property 
     */
    public String getDocAndClinic()
    {
        return getString("docAndClinic");
    }
    public void setDocAndClinic(String item)
    {
        setString("docAndClinic", item);
    }
    /**
     * Object:�ɱ���ϸ's һ���շ���Ŀproperty 
     */
    public String getFirItem()
    {
        return getString("firItem");
    }
    public void setFirItem(String item)
    {
        setString("firItem", item);
    }
    /**
     * Object:�ɱ���ϸ's his�����շ���Ŀ����property 
     */
    public String getHisChargeItemName()
    {
        return getString("hisChargeItemName");
    }
    public void setHisChargeItemName(String item)
    {
        setString("hisChargeItemName", item);
    }
    /**
     * Object:�ɱ���ϸ's һ���շ���Ŀ����property 
     */
    public String getFirItemName()
    {
        return getString("firItemName");
    }
    public void setFirItemName(String item)
    {
        setString("firItemName", item);
    }
    /**
     * Object:�ɱ���ϸ's his�շ���Ŀ��ϸ����property 
     */
    public String getHisPayTypeDetailName()
    {
        return getString("hisPayTypeDetailName");
    }
    public void setHisPayTypeDetailName(String item)
    {
        setString("hisPayTypeDetailName", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("6D50D330");
    }
}