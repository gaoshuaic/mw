package com.kingdee.eas.mw.pay;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractAchienementSumInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractAchienementSumInfo()
    {
        this("id");
    }
    protected AbstractAchienementSumInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object:奖金汇总's 业务期间property 
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
     * Object:奖金汇总's 员工编码property 
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
     * Object:奖金汇总's 员工名称property 
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
     * Object:奖金汇总's 门诊编码property 
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
     * Object:奖金汇总's 城市编码property 
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
     * Object:奖金汇总's 城市名称property 
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
     * Object:奖金汇总's 洁牙奖金property 
     */
    public java.math.BigDecimal getScalingBonus()
    {
        return getBigDecimal("scalingBonus");
    }
    public void setScalingBonus(java.math.BigDecimal item)
    {
        setBigDecimal("scalingBonus", item);
    }
    /**
     * Object:奖金汇总's 美白奖金property 
     */
    public java.math.BigDecimal getWhiteBonus()
    {
        return getBigDecimal("whiteBonus");
    }
    public void setWhiteBonus(java.math.BigDecimal item)
    {
        setBigDecimal("whiteBonus", item);
    }
    /**
     * Object:奖金汇总's 咨询/客服奖金property 
     */
    public java.math.BigDecimal getConBonus()
    {
        return getBigDecimal("conBonus");
    }
    public void setConBonus(java.math.BigDecimal item)
    {
        setBigDecimal("conBonus", item);
    }
    /**
     * Object:奖金汇总's 其他奖金property 
     */
    public java.math.BigDecimal getOtherPostBonus()
    {
        return getBigDecimal("otherPostBonus");
    }
    public void setOtherPostBonus(java.math.BigDecimal item)
    {
        setBigDecimal("otherPostBonus", item);
    }
    /**
     * Object:奖金汇总's 医生奖金property 
     */
    public java.math.BigDecimal getDocBonus()
    {
        return getBigDecimal("docBonus");
    }
    public void setDocBonus(java.math.BigDecimal item)
    {
        setBigDecimal("docBonus", item);
    }
    /**
     * Object:奖金汇总's 医生成本property 
     */
    public java.math.BigDecimal getDocCost()
    {
        return getBigDecimal("docCost");
    }
    public void setDocCost(java.math.BigDecimal item)
    {
        setBigDecimal("docCost", item);
    }
    /**
     * Object:奖金汇总's 门店目标奖金property 
     */
    public java.math.BigDecimal getShopGoalBonus()
    {
        return getBigDecimal("shopGoalBonus");
    }
    public void setShopGoalBonus(java.math.BigDecimal item)
    {
        setBigDecimal("shopGoalBonus", item);
    }
    /**
     * Object:奖金汇总's 门诊名称property 
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
     * Object:奖金汇总's 岗位property 
     */
    public com.kingdee.eas.mw.pay.app.PaypostType getPostType()
    {
        return com.kingdee.eas.mw.pay.app.PaypostType.getEnum(getString("postType"));
    }
    public void setPostType(com.kingdee.eas.mw.pay.app.PaypostType item)
    {
		if (item != null) {
        setString("postType", item.getValue());
		}
    }
    /**
     * Object:奖金汇总's 岗位名称property 
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
     * Object:奖金汇总's 医助转医生奖金property 
     */
    public java.math.BigDecimal getAssToDocBouns()
    {
        return getBigDecimal("assToDocBouns");
    }
    public void setAssToDocBouns(java.math.BigDecimal item)
    {
        setBigDecimal("assToDocBouns", item);
    }
    /**
     * Object:奖金汇总's 客服奖金property 
     */
    public java.math.BigDecimal getKfBonus()
    {
        return getBigDecimal("kfBonus");
    }
    public void setKfBonus(java.math.BigDecimal item)
    {
        setBigDecimal("kfBonus", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("4AF58046");
    }
}