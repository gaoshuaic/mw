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
     * Object:成本明细's 是否生成凭证property 
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
     * Object:成本明细's 城市编码property 
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
     * Object:成本明细's 城市property 
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
     * Object:成本明细's 门诊编码property 
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
     * Object:成本明细's 门诊property 
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
     * Object:成本明细's 医生编码property 
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
     * Object:成本明细's 销售出库单号property 
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
     * Object:成本明细's HIS销售订单IDproperty 
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
     * Object:成本明细's HIS销售订单分录IDproperty 
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
     * Object:成本明细's 物料编码property 
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
     * Object:成本明细's 数量property 
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
     * Object:成本明细's 单价property 
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
     * Object:成本明细's 金额property 
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
     * Object:成本明细's 备注property 
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
     * Object:成本明细's 医生姓名property 
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
     * Object:成本明细's his收费项目明细property 
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
     * Object:成本明细's 期间property 
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
     * Object:成本明细's 类型property 
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
     * Object:成本明细's 物料名称property 
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
     * Object:成本明细's 是否常规矫正property 
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
     * Object:成本明细's his二级收费项目property 
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
     * Object:成本明细's 医生门诊编码property 
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
     * Object:成本明细's 一级收费项目property 
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
     * Object:成本明细's his二级收费项目名称property 
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
     * Object:成本明细's 一级收费项目名称property 
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
     * Object:成本明细's his收费项目明细名称property 
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