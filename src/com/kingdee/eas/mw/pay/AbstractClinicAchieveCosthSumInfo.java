package com.kingdee.eas.mw.pay;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractClinicAchieveCosthSumInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractClinicAchieveCosthSumInfo()
    {
        this("id");
    }
    protected AbstractClinicAchieveCosthSumInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object:业绩汇总's 业务期间property 
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
     * Object:业绩汇总's 员工编码property 
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
     * Object:业绩汇总's 员工名称property 
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
     * Object:业绩汇总's 门诊编码property 
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
     * Object:业绩汇总's 城市编码property 
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
     * Object:业绩汇总's 城市名称property 
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
     * Object:业绩汇总's 门诊名称property 
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
     * Object:业绩汇总's 洁牙次数property 
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
     * Object:业绩汇总's 派力奥次数property 
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
     * Object:业绩汇总's 美白业绩(洁牙师)property 
     */
    public java.math.BigDecimal getWhiteAchieve()
    {
        return getBigDecimal("whiteAchieve");
    }
    public void setWhiteAchieve(java.math.BigDecimal item)
    {
        setBigDecimal("whiteAchieve", item);
    }
    /**
     * Object:业绩汇总's 咨询业绩property 
     */
    public java.math.BigDecimal getZxAchieve()
    {
        return getBigDecimal("zxAchieve");
    }
    public void setZxAchieve(java.math.BigDecimal item)
    {
        setBigDecimal("zxAchieve", item);
    }
    /**
     * Object:业绩汇总's 种植业绩property 
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
     * Object:业绩汇总's 种植成本property 
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
     * Object:业绩汇总's 固定矫正业绩property 
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
     * Object:业绩汇总's 固定矫正成本property 
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
     * Object:业绩汇总's 隐形矫正业绩property 
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
     * Object:业绩汇总's 隐形矫正成本property 
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
     * Object:业绩汇总's 牙周业绩property 
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
     * Object:业绩汇总's 牙周成本property 
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
     * Object:业绩汇总's 口内外业绩property 
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
     * Object:业绩汇总's 口内外成本property 
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
     * Object:业绩汇总's 美白业绩property 
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
     * Object:业绩汇总's 美白成本property 
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
     * Object:业绩汇总's 修复业绩property 
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
     * Object:业绩汇总's 修复成本property 
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
     * Object:业绩汇总's 儿牙业绩property 
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
     * Object:业绩汇总's 儿牙成本property 
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
     * Object:业绩汇总's 业绩总和property 
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
     * Object:业绩汇总's 种植奖金property 
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
     * Object:业绩汇总's 固定矫正奖金property 
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
     * Object:业绩汇总's 隐形矫正奖金property 
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
     * Object:业绩汇总's 口内外奖金property 
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
     * Object:业绩汇总's 牙周奖金property 
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
     * Object:业绩汇总's 美白奖金property 
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
     * Object:业绩汇总's 修复奖金property 
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
     * Object:业绩汇总's 儿牙奖金property 
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
     * Object:业绩汇总's 其他奖金property 
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
     * Object:业绩汇总's 岗位property 
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
     * Object:业绩汇总's 是否自带property 
     */
    public boolean isIszidai()
    {
        return getBoolean("iszidai");
    }
    public void setIszidai(boolean item)
    {
        setBoolean("iszidai", item);
    }
    /**
     * Object:业绩汇总's 调整派力奥次数property 
     */
    public java.math.BigDecimal getImplacount()
    {
        return getBigDecimal("implacount");
    }
    public void setImplacount(java.math.BigDecimal item)
    {
        setBigDecimal("implacount", item);
    }
    /**
     * Object:业绩汇总's 调整洁牙次数property 
     */
    public java.math.BigDecimal getImjycount()
    {
        return getBigDecimal("imjycount");
    }
    public void setImjycount(java.math.BigDecimal item)
    {
        setBigDecimal("imjycount", item);
    }
    /**
     * Object:业绩汇总's 调整美白业绩(洁牙师)property 
     */
    public java.math.BigDecimal getImwhiteAchieve()
    {
        return getBigDecimal("imwhiteAchieve");
    }
    public void setImwhiteAchieve(java.math.BigDecimal item)
    {
        setBigDecimal("imwhiteAchieve", item);
    }
    /**
     * Object:业绩汇总's 调整咨询业绩property 
     */
    public java.math.BigDecimal getImzxAchieve()
    {
        return getBigDecimal("imzxAchieve");
    }
    public void setImzxAchieve(java.math.BigDecimal item)
    {
        setBigDecimal("imzxAchieve", item);
    }
    /**
     * Object:业绩汇总's 调整种植业绩property 
     */
    public java.math.BigDecimal getImzzAchieve()
    {
        return getBigDecimal("imzzAchieve");
    }
    public void setImzzAchieve(java.math.BigDecimal item)
    {
        setBigDecimal("imzzAchieve", item);
    }
    /**
     * Object:业绩汇总's 调整隐形矫正业绩property 
     */
    public java.math.BigDecimal getImyxjzAchieve()
    {
        return getBigDecimal("imyxjzAchieve");
    }
    public void setImyxjzAchieve(java.math.BigDecimal item)
    {
        setBigDecimal("imyxjzAchieve", item);
    }
    /**
     * Object:业绩汇总's 调整固定矫正业绩property 
     */
    public java.math.BigDecimal getImgdjzAchieve()
    {
        return getBigDecimal("imgdjzAchieve");
    }
    public void setImgdjzAchieve(java.math.BigDecimal item)
    {
        setBigDecimal("imgdjzAchieve", item);
    }
    /**
     * Object:业绩汇总's 调整牙周业绩property 
     */
    public java.math.BigDecimal getImyzAchieve()
    {
        return getBigDecimal("imyzAchieve");
    }
    public void setImyzAchieve(java.math.BigDecimal item)
    {
        setBigDecimal("imyzAchieve", item);
    }
    /**
     * Object:业绩汇总's 调整修复业绩property 
     */
    public java.math.BigDecimal getImxfAchieve()
    {
        return getBigDecimal("imxfAchieve");
    }
    public void setImxfAchieve(java.math.BigDecimal item)
    {
        setBigDecimal("imxfAchieve", item);
    }
    /**
     * Object:业绩汇总's 调整口内外业绩property 
     */
    public java.math.BigDecimal getImknwAchieve()
    {
        return getBigDecimal("imknwAchieve");
    }
    public void setImknwAchieve(java.math.BigDecimal item)
    {
        setBigDecimal("imknwAchieve", item);
    }
    /**
     * Object:业绩汇总's 调整儿牙业绩property 
     */
    public java.math.BigDecimal getImeyAchieve()
    {
        return getBigDecimal("imeyAchieve");
    }
    public void setImeyAchieve(java.math.BigDecimal item)
    {
        setBigDecimal("imeyAchieve", item);
    }
    /**
     * Object:业绩汇总's 调整美白业绩property 
     */
    public java.math.BigDecimal getImmbAchieve()
    {
        return getBigDecimal("immbAchieve");
    }
    public void setImmbAchieve(java.math.BigDecimal item)
    {
        setBigDecimal("immbAchieve", item);
    }
    /**
     * Object:业绩汇总's 系统洁牙次数property 
     */
    public java.math.BigDecimal getXtjyCount()
    {
        return getBigDecimal("xtjyCount");
    }
    public void setXtjyCount(java.math.BigDecimal item)
    {
        setBigDecimal("xtjyCount", item);
    }
    /**
     * Object:业绩汇总's 系统派力奥次数property 
     */
    public java.math.BigDecimal getXtplaCount()
    {
        return getBigDecimal("xtplaCount");
    }
    public void setXtplaCount(java.math.BigDecimal item)
    {
        setBigDecimal("xtplaCount", item);
    }
    /**
     * Object:业绩汇总's 系统咨询业绩property 
     */
    public java.math.BigDecimal getXtzxAchieve()
    {
        return getBigDecimal("xtzxAchieve");
    }
    public void setXtzxAchieve(java.math.BigDecimal item)
    {
        setBigDecimal("xtzxAchieve", item);
    }
    /**
     * Object:业绩汇总's 系统种植业绩property 
     */
    public java.math.BigDecimal getXtzzAchieve()
    {
        return getBigDecimal("xtzzAchieve");
    }
    public void setXtzzAchieve(java.math.BigDecimal item)
    {
        setBigDecimal("xtzzAchieve", item);
    }
    /**
     * Object:业绩汇总's 系统隐形矫正property 
     */
    public java.math.BigDecimal getXtyxjzAchieve()
    {
        return getBigDecimal("xtyxjzAchieve");
    }
    public void setXtyxjzAchieve(java.math.BigDecimal item)
    {
        setBigDecimal("xtyxjzAchieve", item);
    }
    /**
     * Object:业绩汇总's 系统固定矫正业绩property 
     */
    public java.math.BigDecimal getXtgdjzAchieve()
    {
        return getBigDecimal("xtgdjzAchieve");
    }
    public void setXtgdjzAchieve(java.math.BigDecimal item)
    {
        setBigDecimal("xtgdjzAchieve", item);
    }
    /**
     * Object:业绩汇总's 系统口内外业绩property 
     */
    public java.math.BigDecimal getXtknwAchieve()
    {
        return getBigDecimal("xtknwAchieve");
    }
    public void setXtknwAchieve(java.math.BigDecimal item)
    {
        setBigDecimal("xtknwAchieve", item);
    }
    /**
     * Object:业绩汇总's 系统修复业绩property 
     */
    public java.math.BigDecimal getXtxfAchieve()
    {
        return getBigDecimal("xtxfAchieve");
    }
    public void setXtxfAchieve(java.math.BigDecimal item)
    {
        setBigDecimal("xtxfAchieve", item);
    }
    /**
     * Object:业绩汇总's 系统儿牙业绩property 
     */
    public java.math.BigDecimal getXteyAchieve()
    {
        return getBigDecimal("xteyAchieve");
    }
    public void setXteyAchieve(java.math.BigDecimal item)
    {
        setBigDecimal("xteyAchieve", item);
    }
    /**
     * Object:业绩汇总's 系统牙周业绩property 
     */
    public java.math.BigDecimal getXtyzAchieve()
    {
        return getBigDecimal("xtyzAchieve");
    }
    public void setXtyzAchieve(java.math.BigDecimal item)
    {
        setBigDecimal("xtyzAchieve", item);
    }
    /**
     * Object:业绩汇总's 系统美白业绩(洁牙师)property 
     */
    public java.math.BigDecimal getXtwhiteAchieve()
    {
        return getBigDecimal("xtwhiteAchieve");
    }
    public void setXtwhiteAchieve(java.math.BigDecimal item)
    {
        setBigDecimal("xtwhiteAchieve", item);
    }
    /**
     * Object:业绩汇总's 岗位名称property 
     */
    public String getPostname()
    {
        return getString("postname");
    }
    public void setPostname(String item)
    {
        setString("postname", item);
    }
    /**
     * Object:业绩汇总's 隐形免工作量业绩property 
     */
    public java.math.BigDecimal getFreeyxjzAchieve()
    {
        return getBigDecimal("freeyxjzAchieve");
    }
    public void setFreeyxjzAchieve(java.math.BigDecimal item)
    {
        setBigDecimal("freeyxjzAchieve", item);
    }
    /**
     * Object:业绩汇总's 种植免工作量业绩property 
     */
    public java.math.BigDecimal getFreezzAchieve()
    {
        return getBigDecimal("freezzAchieve");
    }
    public void setFreezzAchieve(java.math.BigDecimal item)
    {
        setBigDecimal("freezzAchieve", item);
    }
    /**
     * Object:业绩汇总's 固定免工作量业绩property 
     */
    public java.math.BigDecimal getFreegdjzAchieve()
    {
        return getBigDecimal("freegdjzAchieve");
    }
    public void setFreegdjzAchieve(java.math.BigDecimal item)
    {
        setBigDecimal("freegdjzAchieve", item);
    }
    /**
     * Object:业绩汇总's 牙周免工作量业绩property 
     */
    public java.math.BigDecimal getFreeyzAchieve()
    {
        return getBigDecimal("freeyzAchieve");
    }
    public void setFreeyzAchieve(java.math.BigDecimal item)
    {
        setBigDecimal("freeyzAchieve", item);
    }
    /**
     * Object:业绩汇总's 口内外免工作量业绩property 
     */
    public java.math.BigDecimal getFreeknwAchieve()
    {
        return getBigDecimal("freeknwAchieve");
    }
    public void setFreeknwAchieve(java.math.BigDecimal item)
    {
        setBigDecimal("freeknwAchieve", item);
    }
    /**
     * Object:业绩汇总's 修复免工作量业绩property 
     */
    public java.math.BigDecimal getFreexfAchieve()
    {
        return getBigDecimal("freexfAchieve");
    }
    public void setFreexfAchieve(java.math.BigDecimal item)
    {
        setBigDecimal("freexfAchieve", item);
    }
    /**
     * Object:业绩汇总's 儿牙免工作量业绩property 
     */
    public java.math.BigDecimal getFreeeyAchieve()
    {
        return getBigDecimal("freeeyAchieve");
    }
    public void setFreeeyAchieve(java.math.BigDecimal item)
    {
        setBigDecimal("freeeyAchieve", item);
    }
    /**
     * Object:业绩汇总's 美白免工作量业绩property 
     */
    public java.math.BigDecimal getFreembAchieve()
    {
        return getBigDecimal("freembAchieve");
    }
    public void setFreembAchieve(java.math.BigDecimal item)
    {
        setBigDecimal("freembAchieve", item);
    }
    /**
     * Object:业绩汇总's 周边产品业绩property 
     */
    public java.math.BigDecimal getAllKeAchieve()
    {
        return getBigDecimal("allKeAchieve");
    }
    public void setAllKeAchieve(java.math.BigDecimal item)
    {
        setBigDecimal("allKeAchieve", item);
    }
    /**
     * Object:业绩汇总's 系统美白业绩property 
     */
    public java.math.BigDecimal getXtmbAchieve()
    {
        return getBigDecimal("xtmbAchieve");
    }
    public void setXtmbAchieve(java.math.BigDecimal item)
    {
        setBigDecimal("xtmbAchieve", item);
    }
    /**
     * Object:业绩汇总's 调整全科业绩property 
     */
    public java.math.BigDecimal getImAllKeAchieve()
    {
        return getBigDecimal("ImAllKeAchieve");
    }
    public void setImAllKeAchieve(java.math.BigDecimal item)
    {
        setBigDecimal("ImAllKeAchieve", item);
    }
    /**
     * Object:业绩汇总's 系统全科业绩property 
     */
    public java.math.BigDecimal getXtAllKeAchieve()
    {
        return getBigDecimal("XtAllKeAchieve");
    }
    public void setXtAllKeAchieve(java.math.BigDecimal item)
    {
        setBigDecimal("XtAllKeAchieve", item);
    }
    /**
     * Object:业绩汇总's 种植业绩基数property 
     */
    public java.math.BigDecimal getZzbase()
    {
        return getBigDecimal("zzbase");
    }
    public void setZzbase(java.math.BigDecimal item)
    {
        setBigDecimal("zzbase", item);
    }
    /**
     * Object:业绩汇总's 固定矫正业绩基数property 
     */
    public java.math.BigDecimal getGdbase()
    {
        return getBigDecimal("gdbase");
    }
    public void setGdbase(java.math.BigDecimal item)
    {
        setBigDecimal("gdbase", item);
    }
    /**
     * Object:业绩汇总's 隐形矫正业绩基数property 
     */
    public java.math.BigDecimal getYxbase()
    {
        return getBigDecimal("yxbase");
    }
    public void setYxbase(java.math.BigDecimal item)
    {
        setBigDecimal("yxbase", item);
    }
    /**
     * Object:业绩汇总's 口内外业绩基数property 
     */
    public java.math.BigDecimal getKnwbase()
    {
        return getBigDecimal("knwbase");
    }
    public void setKnwbase(java.math.BigDecimal item)
    {
        setBigDecimal("knwbase", item);
    }
    /**
     * Object:业绩汇总's 修复业绩基数property 
     */
    public java.math.BigDecimal getXfbase()
    {
        return getBigDecimal("xfbase");
    }
    public void setXfbase(java.math.BigDecimal item)
    {
        setBigDecimal("xfbase", item);
    }
    /**
     * Object:业绩汇总's 牙周业绩基数property 
     */
    public java.math.BigDecimal getYzbase()
    {
        return getBigDecimal("yzbase");
    }
    public void setYzbase(java.math.BigDecimal item)
    {
        setBigDecimal("yzbase", item);
    }
    /**
     * Object:业绩汇总's 儿牙业绩基数property 
     */
    public java.math.BigDecimal getEybase()
    {
        return getBigDecimal("eybase");
    }
    public void setEybase(java.math.BigDecimal item)
    {
        setBigDecimal("eybase", item);
    }
    /**
     * Object:业绩汇总's 美白业绩基数property 
     */
    public java.math.BigDecimal getMbbase()
    {
        return getBigDecimal("mbbase");
    }
    public void setMbbase(java.math.BigDecimal item)
    {
        setBigDecimal("mbbase", item);
    }
    /**
     * Object:业绩汇总's 总业绩基数property 
     */
    public java.math.BigDecimal getAllbase()
    {
        return getBigDecimal("allbase");
    }
    public void setAllbase(java.math.BigDecimal item)
    {
        setBigDecimal("allbase", item);
    }
    /**
     * Object:业绩汇总's 舒适洁牙点诊次数property 
     */
    public java.math.BigDecimal getCosydzCount()
    {
        return getBigDecimal("cosydzCount");
    }
    public void setCosydzCount(java.math.BigDecimal item)
    {
        setBigDecimal("cosydzCount", item);
    }
    /**
     * Object:业绩汇总's 系统舒适洁牙点诊次数property 
     */
    public java.math.BigDecimal getXtcosydzCount()
    {
        return getBigDecimal("xtcosydzCount");
    }
    public void setXtcosydzCount(java.math.BigDecimal item)
    {
        setBigDecimal("xtcosydzCount", item);
    }
    /**
     * Object:业绩汇总's 调整舒适洁牙点诊次数property 
     */
    public java.math.BigDecimal getImcosydzCount()
    {
        return getBigDecimal("imcosydzCount");
    }
    public void setImcosydzCount(java.math.BigDecimal item)
    {
        setBigDecimal("imcosydzCount", item);
    }
    /**
     * Object:业绩汇总's 舒适洁牙非点诊次数property 
     */
    public java.math.BigDecimal getCosyfdzCount()
    {
        return getBigDecimal("cosyfdzCount");
    }
    public void setCosyfdzCount(java.math.BigDecimal item)
    {
        setBigDecimal("cosyfdzCount", item);
    }
    /**
     * Object:业绩汇总's 系统舒适洁牙非点诊次数property 
     */
    public java.math.BigDecimal getXtcosyfdzCount()
    {
        return getBigDecimal("xtcosyfdzCount");
    }
    public void setXtcosyfdzCount(java.math.BigDecimal item)
    {
        setBigDecimal("xtcosyfdzCount", item);
    }
    /**
     * Object:业绩汇总's 调整舒适洁牙非点诊次数property 
     */
    public java.math.BigDecimal getImcosyfdzCount()
    {
        return getBigDecimal("imcosyfdzCount");
    }
    public void setImcosyfdzCount(java.math.BigDecimal item)
    {
        setBigDecimal("imcosyfdzCount", item);
    }
    /**
     * Object:业绩汇总's 种植占比property 
     */
    public java.math.BigDecimal getZzpro()
    {
        return getBigDecimal("zzpro");
    }
    public void setZzpro(java.math.BigDecimal item)
    {
        setBigDecimal("zzpro", item);
    }
    /**
     * Object:业绩汇总's 固定矫正占比property 
     */
    public java.math.BigDecimal getGdpro()
    {
        return getBigDecimal("gdpro");
    }
    public void setGdpro(java.math.BigDecimal item)
    {
        setBigDecimal("gdpro", item);
    }
    /**
     * Object:业绩汇总's 隐形矫正占比property 
     */
    public java.math.BigDecimal getYxpro()
    {
        return getBigDecimal("yxpro");
    }
    public void setYxpro(java.math.BigDecimal item)
    {
        setBigDecimal("yxpro", item);
    }
    /**
     * Object:业绩汇总's 口内外占比property 
     */
    public java.math.BigDecimal getKnwpro()
    {
        return getBigDecimal("knwpro");
    }
    public void setKnwpro(java.math.BigDecimal item)
    {
        setBigDecimal("knwpro", item);
    }
    /**
     * Object:业绩汇总's 修复占比property 
     */
    public java.math.BigDecimal getXfpro()
    {
        return getBigDecimal("xfpro");
    }
    public void setXfpro(java.math.BigDecimal item)
    {
        setBigDecimal("xfpro", item);
    }
    /**
     * Object:业绩汇总's 牙周占比property 
     */
    public java.math.BigDecimal getYzpro()
    {
        return getBigDecimal("yzpro");
    }
    public void setYzpro(java.math.BigDecimal item)
    {
        setBigDecimal("yzpro", item);
    }
    /**
     * Object:业绩汇总's 儿牙占比property 
     */
    public java.math.BigDecimal getEypro()
    {
        return getBigDecimal("eypro");
    }
    public void setEypro(java.math.BigDecimal item)
    {
        setBigDecimal("eypro", item);
    }
    /**
     * Object:业绩汇总's 美白占比property 
     */
    public java.math.BigDecimal getMbpro()
    {
        return getBigDecimal("mbpro");
    }
    public void setMbpro(java.math.BigDecimal item)
    {
        setBigDecimal("mbpro", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("20D1E187");
    }
}