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
     * Object:业绩明细's 是否生成凭证property 
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
     * Object:业绩明细's 城市编码property 
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
     * Object:业绩明细's 城市property 
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
     * Object:业绩明细's 门诊编码property 
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
     * Object:业绩明细's 门诊property 
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
     * Object:业绩明细's 医生编码property 
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
     * Object:业绩明细's 销售出库单号property 
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
     * Object:业绩明细's HIS销售订单IDproperty 
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
     * Object:业绩明细's HIS销售订单分录IDproperty 
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
     * Object:业绩明细's 技加工物料property 
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
     * Object:业绩明细's 数量property 
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
     * Object:业绩明细's 单价property 
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
     * Object:业绩明细's 金额property 
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
     * Object:业绩明细's 备注property 
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
     * Object:业绩明细's 医生姓名property 
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