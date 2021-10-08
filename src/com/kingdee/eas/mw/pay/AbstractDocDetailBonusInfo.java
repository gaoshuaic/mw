package com.kingdee.eas.mw.pay;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractDocDetailBonusInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractDocDetailBonusInfo()
    {
        this("id");
    }
    protected AbstractDocDetailBonusInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object:医生奖金详细数据's 业务期间property 
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
     * Object:医生奖金详细数据's 员工编码property 
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
     * Object:医生奖金详细数据's 员工名称property 
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
     * Object:医生奖金详细数据's 门诊编码property 
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
     * Object:医生奖金详细数据's 城市编码property 
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
     * Object:医生奖金详细数据's 城市名称property 
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
     * Object:医生奖金详细数据's 门诊名称property 
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
     * Object:医生奖金详细数据's 洁牙次数property 
     */
    public java.math.BigDecimal getJyCount()
    {
        return getBigDecimal("jyCount");
    }
    public void setJyCount(java.math.BigDecimal item)
    {
        setBigDecimal("jyCount", item);
    }
    /**
     * Object:医生奖金详细数据's 派力奥次数property 
     */
    public java.math.BigDecimal getPlaCount()
    {
        return getBigDecimal("plaCount");
    }
    public void setPlaCount(java.math.BigDecimal item)
    {
        setBigDecimal("plaCount", item);
    }
    /**
     * Object:医生奖金详细数据's 种植业绩property 
     */
    public java.math.BigDecimal getZzAchieve()
    {
        return getBigDecimal("zzAchieve");
    }
    public void setZzAchieve(java.math.BigDecimal item)
    {
        setBigDecimal("zzAchieve", item);
    }
    /**
     * Object:医生奖金详细数据's 种植成本property 
     */
    public java.math.BigDecimal getZzCost()
    {
        return getBigDecimal("zzCost");
    }
    public void setZzCost(java.math.BigDecimal item)
    {
        setBigDecimal("zzCost", item);
    }
    /**
     * Object:医生奖金详细数据's 固定矫正业绩property 
     */
    public java.math.BigDecimal getGdjzAchieve()
    {
        return getBigDecimal("gdjzAchieve");
    }
    public void setGdjzAchieve(java.math.BigDecimal item)
    {
        setBigDecimal("gdjzAchieve", item);
    }
    /**
     * Object:医生奖金详细数据's 固定矫正成本property 
     */
    public java.math.BigDecimal getGdjzCost()
    {
        return getBigDecimal("gdjzCost");
    }
    public void setGdjzCost(java.math.BigDecimal item)
    {
        setBigDecimal("gdjzCost", item);
    }
    /**
     * Object:医生奖金详细数据's 隐形矫正业绩property 
     */
    public java.math.BigDecimal getYxjzAchieve()
    {
        return getBigDecimal("yxjzAchieve");
    }
    public void setYxjzAchieve(java.math.BigDecimal item)
    {
        setBigDecimal("yxjzAchieve", item);
    }
    /**
     * Object:医生奖金详细数据's 隐形矫正成本property 
     */
    public java.math.BigDecimal getYxjzCost()
    {
        return getBigDecimal("yxjzCost");
    }
    public void setYxjzCost(java.math.BigDecimal item)
    {
        setBigDecimal("yxjzCost", item);
    }
    /**
     * Object:医生奖金详细数据's 牙周业绩property 
     */
    public java.math.BigDecimal getZyAchieve()
    {
        return getBigDecimal("zyAchieve");
    }
    public void setZyAchieve(java.math.BigDecimal item)
    {
        setBigDecimal("zyAchieve", item);
    }
    /**
     * Object:医生奖金详细数据's 牙周成本property 
     */
    public java.math.BigDecimal getYzCost()
    {
        return getBigDecimal("yzCost");
    }
    public void setYzCost(java.math.BigDecimal item)
    {
        setBigDecimal("yzCost", item);
    }
    /**
     * Object:医生奖金详细数据's 口内外业绩property 
     */
    public java.math.BigDecimal getKnwAchieve()
    {
        return getBigDecimal("knwAchieve");
    }
    public void setKnwAchieve(java.math.BigDecimal item)
    {
        setBigDecimal("knwAchieve", item);
    }
    /**
     * Object:医生奖金详细数据's 口内外成本property 
     */
    public java.math.BigDecimal getKnwCost()
    {
        return getBigDecimal("knwCost");
    }
    public void setKnwCost(java.math.BigDecimal item)
    {
        setBigDecimal("knwCost", item);
    }
    /**
     * Object:医生奖金详细数据's 美白业绩property 
     */
    public java.math.BigDecimal getMbAchieve()
    {
        return getBigDecimal("mbAchieve");
    }
    public void setMbAchieve(java.math.BigDecimal item)
    {
        setBigDecimal("mbAchieve", item);
    }
    /**
     * Object:医生奖金详细数据's 美白成本property 
     */
    public java.math.BigDecimal getMbCost()
    {
        return getBigDecimal("mbCost");
    }
    public void setMbCost(java.math.BigDecimal item)
    {
        setBigDecimal("mbCost", item);
    }
    /**
     * Object:医生奖金详细数据's 修复业绩property 
     */
    public java.math.BigDecimal getXfAchieve()
    {
        return getBigDecimal("xfAchieve");
    }
    public void setXfAchieve(java.math.BigDecimal item)
    {
        setBigDecimal("xfAchieve", item);
    }
    /**
     * Object:医生奖金详细数据's 修复成本property 
     */
    public java.math.BigDecimal getXfCost()
    {
        return getBigDecimal("xfCost");
    }
    public void setXfCost(java.math.BigDecimal item)
    {
        setBigDecimal("xfCost", item);
    }
    /**
     * Object:医生奖金详细数据's 儿牙业绩property 
     */
    public java.math.BigDecimal getEyAchieve()
    {
        return getBigDecimal("eyAchieve");
    }
    public void setEyAchieve(java.math.BigDecimal item)
    {
        setBigDecimal("eyAchieve", item);
    }
    /**
     * Object:医生奖金详细数据's 儿牙成本property 
     */
    public java.math.BigDecimal getEyCost()
    {
        return getBigDecimal("eyCost");
    }
    public void setEyCost(java.math.BigDecimal item)
    {
        setBigDecimal("eyCost", item);
    }
    /**
     * Object:医生奖金详细数据's 业绩总和property 
     */
    public java.math.BigDecimal getSumAchieve()
    {
        return getBigDecimal("sumAchieve");
    }
    public void setSumAchieve(java.math.BigDecimal item)
    {
        setBigDecimal("sumAchieve", item);
    }
    /**
     * Object:医生奖金详细数据's 种植奖金property 
     */
    public java.math.BigDecimal getZzMoney()
    {
        return getBigDecimal("zzMoney");
    }
    public void setZzMoney(java.math.BigDecimal item)
    {
        setBigDecimal("zzMoney", item);
    }
    /**
     * Object:医生奖金详细数据's 固定矫正奖金property 
     */
    public java.math.BigDecimal getGdjzMoney()
    {
        return getBigDecimal("gdjzMoney");
    }
    public void setGdjzMoney(java.math.BigDecimal item)
    {
        setBigDecimal("gdjzMoney", item);
    }
    /**
     * Object:医生奖金详细数据's 隐形矫正奖金property 
     */
    public java.math.BigDecimal getYxjzMoney()
    {
        return getBigDecimal("yxjzMoney");
    }
    public void setYxjzMoney(java.math.BigDecimal item)
    {
        setBigDecimal("yxjzMoney", item);
    }
    /**
     * Object:医生奖金详细数据's 口内外奖金property 
     */
    public java.math.BigDecimal getKnwMoney()
    {
        return getBigDecimal("knwMoney");
    }
    public void setKnwMoney(java.math.BigDecimal item)
    {
        setBigDecimal("knwMoney", item);
    }
    /**
     * Object:医生奖金详细数据's 牙周奖金property 
     */
    public java.math.BigDecimal getYzMoney()
    {
        return getBigDecimal("yzMoney");
    }
    public void setYzMoney(java.math.BigDecimal item)
    {
        setBigDecimal("yzMoney", item);
    }
    /**
     * Object:医生奖金详细数据's 美白奖金property 
     */
    public java.math.BigDecimal getMbMoney()
    {
        return getBigDecimal("mbMoney");
    }
    public void setMbMoney(java.math.BigDecimal item)
    {
        setBigDecimal("mbMoney", item);
    }
    /**
     * Object:医生奖金详细数据's 修复奖金property 
     */
    public java.math.BigDecimal getXfMoney()
    {
        return getBigDecimal("xfMoney");
    }
    public void setXfMoney(java.math.BigDecimal item)
    {
        setBigDecimal("xfMoney", item);
    }
    /**
     * Object:医生奖金详细数据's 儿牙奖金property 
     */
    public java.math.BigDecimal getEyMoney()
    {
        return getBigDecimal("eyMoney");
    }
    public void setEyMoney(java.math.BigDecimal item)
    {
        setBigDecimal("eyMoney", item);
    }
    /**
     * Object:医生奖金详细数据's 其他奖金property 
     */
    public java.math.BigDecimal getOtherMoney()
    {
        return getBigDecimal("otherMoney");
    }
    public void setOtherMoney(java.math.BigDecimal item)
    {
        setBigDecimal("otherMoney", item);
    }
    /**
     * Object:医生奖金详细数据's 种植业绩基数property 
     */
    public java.math.BigDecimal getZzBase()
    {
        return getBigDecimal("zzBase");
    }
    public void setZzBase(java.math.BigDecimal item)
    {
        setBigDecimal("zzBase", item);
    }
    /**
     * Object:医生奖金详细数据's 此医生门诊业绩property 
     */
    public java.math.BigDecimal getClinicAchieve()
    {
        return getBigDecimal("clinicAchieve");
    }
    public void setClinicAchieve(java.math.BigDecimal item)
    {
        setBigDecimal("clinicAchieve", item);
    }
    /**
     * Object:医生奖金详细数据's 隐形矫正业绩基数property 
     */
    public java.math.BigDecimal getYxjzBase()
    {
        return getBigDecimal("yxjzBase");
    }
    public void setYxjzBase(java.math.BigDecimal item)
    {
        setBigDecimal("yxjzBase", item);
    }
    /**
     * Object:医生奖金详细数据's 固定矫正业绩基数property 
     */
    public java.math.BigDecimal getGdjzBase()
    {
        return getBigDecimal("gdjzBase");
    }
    public void setGdjzBase(java.math.BigDecimal item)
    {
        setBigDecimal("gdjzBase", item);
    }
    /**
     * Object:医生奖金详细数据's 口内外业绩基数property 
     */
    public java.math.BigDecimal getKnwBase()
    {
        return getBigDecimal("knwBase");
    }
    public void setKnwBase(java.math.BigDecimal item)
    {
        setBigDecimal("knwBase", item);
    }
    /**
     * Object:医生奖金详细数据's 修复业绩基数property 
     */
    public java.math.BigDecimal getXfBase()
    {
        return getBigDecimal("xfBase");
    }
    public void setXfBase(java.math.BigDecimal item)
    {
        setBigDecimal("xfBase", item);
    }
    /**
     * Object:医生奖金详细数据's 儿牙业绩基数property 
     */
    public java.math.BigDecimal getEyBase()
    {
        return getBigDecimal("eyBase");
    }
    public void setEyBase(java.math.BigDecimal item)
    {
        setBigDecimal("eyBase", item);
    }
    /**
     * Object:医生奖金详细数据's 牙周业绩基数property 
     */
    public java.math.BigDecimal getYzBase()
    {
        return getBigDecimal("yzBase");
    }
    public void setYzBase(java.math.BigDecimal item)
    {
        setBigDecimal("yzBase", item);
    }
    /**
     * Object:医生奖金详细数据's 美白业绩基数property 
     */
    public java.math.BigDecimal getMbBase()
    {
        return getBigDecimal("mbBase");
    }
    public void setMbBase(java.math.BigDecimal item)
    {
        setBigDecimal("mbBase", item);
    }
    /**
     * Object:医生奖金详细数据's 门诊业绩基数property 
     */
    public java.math.BigDecimal getClinicBase()
    {
        return getBigDecimal("clinicBase");
    }
    public void setClinicBase(java.math.BigDecimal item)
    {
        setBigDecimal("clinicBase", item);
    }
    /**
     * Object:医生奖金详细数据's 奖金总和property 
     */
    public java.math.BigDecimal getSumMoney()
    {
        return getBigDecimal("sumMoney");
    }
    public void setSumMoney(java.math.BigDecimal item)
    {
        setBigDecimal("sumMoney", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("832E15A8");
    }
}