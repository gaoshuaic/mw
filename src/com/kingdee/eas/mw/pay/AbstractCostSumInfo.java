package com.kingdee.eas.mw.pay;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractCostSumInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractCostSumInfo()
    {
        this("id");
    }
    protected AbstractCostSumInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object:成本汇总's 是否生成凭证property 
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
     * Object:成本汇总's 医生编码property 
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
     * Object:成本汇总's 数量property 
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
     * Object:成本汇总's 单价property 
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
     * Object:成本汇总's 金额property 
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
     * Object:成本汇总's 备注property 
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
     * Object:成本汇总's 医生姓名property 
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
     * Object:成本汇总's 期间property 
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
     * Object:成本汇总's 系统加工费隐形矫正property 
     */
    public java.math.BigDecimal getJgfyxjz()
    {
        return getBigDecimal("jgfyxjz");
    }
    public void setJgfyxjz(java.math.BigDecimal item)
    {
        setBigDecimal("jgfyxjz", item);
    }
    /**
     * Object:成本汇总's 系统加工费常规矫正property 
     */
    public java.math.BigDecimal getJgfcgjz()
    {
        return getBigDecimal("jgfcgjz");
    }
    public void setJgfcgjz(java.math.BigDecimal item)
    {
        setBigDecimal("jgfcgjz", item);
    }
    /**
     * Object:成本汇总's 系统加工费口内外property 
     */
    public java.math.BigDecimal getJgfknw()
    {
        return getBigDecimal("jgfknw");
    }
    public void setJgfknw(java.math.BigDecimal item)
    {
        setBigDecimal("jgfknw", item);
    }
    /**
     * Object:成本汇总's 系统加工费修复property 
     */
    public java.math.BigDecimal getJgfxf()
    {
        return getBigDecimal("jgfxf");
    }
    public void setJgfxf(java.math.BigDecimal item)
    {
        setBigDecimal("jgfxf", item);
    }
    /**
     * Object:成本汇总's 系统加工费儿牙property 
     */
    public java.math.BigDecimal getJgfey()
    {
        return getBigDecimal("jgfey");
    }
    public void setJgfey(java.math.BigDecimal item)
    {
        setBigDecimal("jgfey", item);
    }
    /**
     * Object:成本汇总's 系统加工费牙周property 
     */
    public java.math.BigDecimal getJgfyz()
    {
        return getBigDecimal("jgfyz");
    }
    public void setJgfyz(java.math.BigDecimal item)
    {
        setBigDecimal("jgfyz", item);
    }
    /**
     * Object:成本汇总's 系统加工费美白property 
     */
    public java.math.BigDecimal getJgfmb()
    {
        return getBigDecimal("jgfmb");
    }
    public void setJgfmb(java.math.BigDecimal item)
    {
        setBigDecimal("jgfmb", item);
    }
    /**
     * Object:成本汇总's 系统加工费种植property 
     */
    public java.math.BigDecimal getJgfzz()
    {
        return getBigDecimal("jgfzz");
    }
    public void setJgfzz(java.math.BigDecimal item)
    {
        setBigDecimal("jgfzz", item);
    }
    /**
     * Object:成本汇总's 系统消耗种植property 
     */
    public java.math.BigDecimal getXhzz()
    {
        return getBigDecimal("xhzz");
    }
    public void setXhzz(java.math.BigDecimal item)
    {
        setBigDecimal("xhzz", item);
    }
    /**
     * Object:成本汇总's 系统消耗隐形矫正property 
     */
    public java.math.BigDecimal getXhyxjz()
    {
        return getBigDecimal("xhyxjz");
    }
    public void setXhyxjz(java.math.BigDecimal item)
    {
        setBigDecimal("xhyxjz", item);
    }
    /**
     * Object:成本汇总's 系统消耗常规矫正property 
     */
    public java.math.BigDecimal getXhcgjz()
    {
        return getBigDecimal("xhcgjz");
    }
    public void setXhcgjz(java.math.BigDecimal item)
    {
        setBigDecimal("xhcgjz", item);
    }
    /**
     * Object:成本汇总's 系统消耗口内外property 
     */
    public java.math.BigDecimal getXhknw()
    {
        return getBigDecimal("xhknw");
    }
    public void setXhknw(java.math.BigDecimal item)
    {
        setBigDecimal("xhknw", item);
    }
    /**
     * Object:成本汇总's 系统消耗修复property 
     */
    public java.math.BigDecimal getXhxf()
    {
        return getBigDecimal("xhxf");
    }
    public void setXhxf(java.math.BigDecimal item)
    {
        setBigDecimal("xhxf", item);
    }
    /**
     * Object:成本汇总's 系统消耗儿牙property 
     */
    public java.math.BigDecimal getXhey()
    {
        return getBigDecimal("xhey");
    }
    public void setXhey(java.math.BigDecimal item)
    {
        setBigDecimal("xhey", item);
    }
    /**
     * Object:成本汇总's 系统消耗牙周property 
     */
    public java.math.BigDecimal getXhyz()
    {
        return getBigDecimal("xhyz");
    }
    public void setXhyz(java.math.BigDecimal item)
    {
        setBigDecimal("xhyz", item);
    }
    /**
     * Object:成本汇总's 门诊编码property 
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
     * Object:成本汇总's 门诊名称property 
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
     * Object:成本汇总's 系统消耗美白property 
     */
    public java.math.BigDecimal getXhmb()
    {
        return getBigDecimal("xhmb");
    }
    public void setXhmb(java.math.BigDecimal item)
    {
        setBigDecimal("xhmb", item);
    }
    /**
     * Object:成本汇总's 城市编码property 
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
     * Object:成本汇总's 城市名称property 
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
     * Object:成本汇总's 状态property 
     */
    public com.kingdee.eas.mw.pay.app.UpdateCostStatus getStatus()
    {
        return com.kingdee.eas.mw.pay.app.UpdateCostStatus.getEnum(getString("status"));
    }
    public void setStatus(com.kingdee.eas.mw.pay.app.UpdateCostStatus item)
    {
		if (item != null) {
        setString("status", item.getValue());
		}
    }
    /**
     * Object:成本汇总's 调整消耗种植property 
     */
    public java.math.BigDecimal getUpxhzz()
    {
        return getBigDecimal("upxhzz");
    }
    public void setUpxhzz(java.math.BigDecimal item)
    {
        setBigDecimal("upxhzz", item);
    }
    /**
     * Object:成本汇总's 调整消耗隐形矫正property 
     */
    public java.math.BigDecimal getUpxhyxjz()
    {
        return getBigDecimal("upxhyxjz");
    }
    public void setUpxhyxjz(java.math.BigDecimal item)
    {
        setBigDecimal("upxhyxjz", item);
    }
    /**
     * Object:成本汇总's 调整消耗常规矫正property 
     */
    public java.math.BigDecimal getUpxhcgjz()
    {
        return getBigDecimal("upxhcgjz");
    }
    public void setUpxhcgjz(java.math.BigDecimal item)
    {
        setBigDecimal("upxhcgjz", item);
    }
    /**
     * Object:成本汇总's 调整消耗口内外property 
     */
    public java.math.BigDecimal getUpxhknw()
    {
        return getBigDecimal("upxhknw");
    }
    public void setUpxhknw(java.math.BigDecimal item)
    {
        setBigDecimal("upxhknw", item);
    }
    /**
     * Object:成本汇总's 调整消耗修复property 
     */
    public java.math.BigDecimal getUpxhxf()
    {
        return getBigDecimal("upxhxf");
    }
    public void setUpxhxf(java.math.BigDecimal item)
    {
        setBigDecimal("upxhxf", item);
    }
    /**
     * Object:成本汇总's 调整消耗儿牙property 
     */
    public java.math.BigDecimal getUpxhey()
    {
        return getBigDecimal("upxhey");
    }
    public void setUpxhey(java.math.BigDecimal item)
    {
        setBigDecimal("upxhey", item);
    }
    /**
     * Object:成本汇总's 调整消耗牙周property 
     */
    public java.math.BigDecimal getUpxhyz()
    {
        return getBigDecimal("upxhyz");
    }
    public void setUpxhyz(java.math.BigDecimal item)
    {
        setBigDecimal("upxhyz", item);
    }
    /**
     * Object:成本汇总's 调整消耗美白property 
     */
    public java.math.BigDecimal getUpxhmb()
    {
        return getBigDecimal("upxhmb");
    }
    public void setUpxhmb(java.math.BigDecimal item)
    {
        setBigDecimal("upxhmb", item);
    }
    /**
     * Object:成本汇总's 调整加工费种植property 
     */
    public java.math.BigDecimal getUpjgfzz()
    {
        return getBigDecimal("upjgfzz");
    }
    public void setUpjgfzz(java.math.BigDecimal item)
    {
        setBigDecimal("upjgfzz", item);
    }
    /**
     * Object:成本汇总's 调整加工费隐形矫正property 
     */
    public java.math.BigDecimal getUpjgfyxjz()
    {
        return getBigDecimal("upjgfyxjz");
    }
    public void setUpjgfyxjz(java.math.BigDecimal item)
    {
        setBigDecimal("upjgfyxjz", item);
    }
    /**
     * Object:成本汇总's 调整加工费常规矫正property 
     */
    public java.math.BigDecimal getUpjgfcgjz()
    {
        return getBigDecimal("upjgfcgjz");
    }
    public void setUpjgfcgjz(java.math.BigDecimal item)
    {
        setBigDecimal("upjgfcgjz", item);
    }
    /**
     * Object:成本汇总's 调整加工费口内外property 
     */
    public java.math.BigDecimal getUpjgfknw()
    {
        return getBigDecimal("upjgfknw");
    }
    public void setUpjgfknw(java.math.BigDecimal item)
    {
        setBigDecimal("upjgfknw", item);
    }
    /**
     * Object:成本汇总's 调整加工费修复property 
     */
    public java.math.BigDecimal getUpjgfxf()
    {
        return getBigDecimal("upjgfxf");
    }
    public void setUpjgfxf(java.math.BigDecimal item)
    {
        setBigDecimal("upjgfxf", item);
    }
    /**
     * Object:成本汇总's 调整加工费儿牙property 
     */
    public java.math.BigDecimal getUpjgfey()
    {
        return getBigDecimal("upjgfey");
    }
    public void setUpjgfey(java.math.BigDecimal item)
    {
        setBigDecimal("upjgfey", item);
    }
    /**
     * Object:成本汇总's 调整加工费牙周property 
     */
    public java.math.BigDecimal getUpjgfyz()
    {
        return getBigDecimal("upjgfyz");
    }
    public void setUpjgfyz(java.math.BigDecimal item)
    {
        setBigDecimal("upjgfyz", item);
    }
    /**
     * Object:成本汇总's 调整加工费美白property 
     */
    public java.math.BigDecimal getUpjgfmb()
    {
        return getBigDecimal("upjgfmb");
    }
    public void setUpjgfmb(java.math.BigDecimal item)
    {
        setBigDecimal("upjgfmb", item);
    }
    /**
     * Object:成本汇总's 汇总消耗种植property 
     */
    public java.math.BigDecimal getAllxhzz()
    {
        return getBigDecimal("allxhzz");
    }
    public void setAllxhzz(java.math.BigDecimal item)
    {
        setBigDecimal("allxhzz", item);
    }
    /**
     * Object:成本汇总's 汇总消耗隐形矫正property 
     */
    public java.math.BigDecimal getAllxhyxjz()
    {
        return getBigDecimal("allxhyxjz");
    }
    public void setAllxhyxjz(java.math.BigDecimal item)
    {
        setBigDecimal("allxhyxjz", item);
    }
    /**
     * Object:成本汇总's 汇总消耗常规矫正property 
     */
    public java.math.BigDecimal getAllxhcgjz()
    {
        return getBigDecimal("allxhcgjz");
    }
    public void setAllxhcgjz(java.math.BigDecimal item)
    {
        setBigDecimal("allxhcgjz", item);
    }
    /**
     * Object:成本汇总's 汇总消耗口内外property 
     */
    public java.math.BigDecimal getAllxhknw()
    {
        return getBigDecimal("allxhknw");
    }
    public void setAllxhknw(java.math.BigDecimal item)
    {
        setBigDecimal("allxhknw", item);
    }
    /**
     * Object:成本汇总's 汇总消耗修复property 
     */
    public java.math.BigDecimal getAllxhxf()
    {
        return getBigDecimal("allxhxf");
    }
    public void setAllxhxf(java.math.BigDecimal item)
    {
        setBigDecimal("allxhxf", item);
    }
    /**
     * Object:成本汇总's 汇总消耗儿牙property 
     */
    public java.math.BigDecimal getAllxhey()
    {
        return getBigDecimal("allxhey");
    }
    public void setAllxhey(java.math.BigDecimal item)
    {
        setBigDecimal("allxhey", item);
    }
    /**
     * Object:成本汇总's 汇总消耗牙周property 
     */
    public java.math.BigDecimal getAllxhyz()
    {
        return getBigDecimal("allxhyz");
    }
    public void setAllxhyz(java.math.BigDecimal item)
    {
        setBigDecimal("allxhyz", item);
    }
    /**
     * Object:成本汇总's 汇总消耗美白property 
     */
    public java.math.BigDecimal getAllxhmb()
    {
        return getBigDecimal("allxhmb");
    }
    public void setAllxhmb(java.math.BigDecimal item)
    {
        setBigDecimal("allxhmb", item);
    }
    /**
     * Object:成本汇总's 汇总加工费种植property 
     */
    public java.math.BigDecimal getAlljgfzz()
    {
        return getBigDecimal("alljgfzz");
    }
    public void setAlljgfzz(java.math.BigDecimal item)
    {
        setBigDecimal("alljgfzz", item);
    }
    /**
     * Object:成本汇总's 汇总加工费隐形矫正property 
     */
    public java.math.BigDecimal getAlljgfyxjz()
    {
        return getBigDecimal("alljgfyxjz");
    }
    public void setAlljgfyxjz(java.math.BigDecimal item)
    {
        setBigDecimal("alljgfyxjz", item);
    }
    /**
     * Object:成本汇总's 汇总加工费常规矫正property 
     */
    public java.math.BigDecimal getAlljgfgdjz()
    {
        return getBigDecimal("alljgfgdjz");
    }
    public void setAlljgfgdjz(java.math.BigDecimal item)
    {
        setBigDecimal("alljgfgdjz", item);
    }
    /**
     * Object:成本汇总's 汇总加工费口内外property 
     */
    public java.math.BigDecimal getAlljgfknw()
    {
        return getBigDecimal("alljgfknw");
    }
    public void setAlljgfknw(java.math.BigDecimal item)
    {
        setBigDecimal("alljgfknw", item);
    }
    /**
     * Object:成本汇总's 汇总加工费修复property 
     */
    public java.math.BigDecimal getAlljgfxf()
    {
        return getBigDecimal("alljgfxf");
    }
    public void setAlljgfxf(java.math.BigDecimal item)
    {
        setBigDecimal("alljgfxf", item);
    }
    /**
     * Object:成本汇总's 汇总加工费儿牙property 
     */
    public java.math.BigDecimal getAlljgfey()
    {
        return getBigDecimal("alljgfey");
    }
    public void setAlljgfey(java.math.BigDecimal item)
    {
        setBigDecimal("alljgfey", item);
    }
    /**
     * Object:成本汇总's 汇总加工费牙周property 
     */
    public java.math.BigDecimal getAlljgfyz()
    {
        return getBigDecimal("alljgfyz");
    }
    public void setAlljgfyz(java.math.BigDecimal item)
    {
        setBigDecimal("alljgfyz", item);
    }
    /**
     * Object:成本汇总's 汇总加工费美白property 
     */
    public java.math.BigDecimal getAlljgfmb()
    {
        return getBigDecimal("alljgfmb");
    }
    public void setAlljgfmb(java.math.BigDecimal item)
    {
        setBigDecimal("alljgfmb", item);
    }
    /**
     * Object:成本汇总's 是否自带property 
     */
    public boolean isIszidai()
    {
        return getBoolean("iszidai");
    }
    public void setIszidai(boolean item)
    {
        setBoolean("iszidai", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("5DA507CC");
    }
}