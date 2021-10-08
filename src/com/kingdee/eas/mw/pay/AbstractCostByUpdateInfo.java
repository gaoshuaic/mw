package com.kingdee.eas.mw.pay;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractCostByUpdateInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractCostByUpdateInfo()
    {
        this("id");
    }
    protected AbstractCostByUpdateInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object:成本调整's 医生编码property 
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
     * Object:成本调整's 医生姓名property 
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
     * Object:成本调整's 期间property 
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
     * Object:成本调整's 加工费隐形矫正property 
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
     * Object:成本调整's 加工费常规矫正property 
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
     * Object:成本调整's 加工费口内外property 
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
     * Object:成本调整's 加工费修复property 
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
     * Object:成本调整's 加工费儿牙property 
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
     * Object:成本调整's 加工费牙周property 
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
     * Object:成本调整's 加工费美白property 
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
     * Object:成本调整's 加工费种植property 
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
     * Object:成本调整's 消耗种植property 
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
     * Object:成本调整's 消耗隐形矫正property 
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
     * Object:成本调整's 消耗常规矫正property 
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
     * Object:成本调整's 消耗口内外property 
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
     * Object:成本调整's 消耗修复property 
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
     * Object:成本调整's 消耗儿牙property 
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
     * Object:成本调整's 消耗牙周property 
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
     * Object:成本调整's 门诊编码property 
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
     * Object:成本调整's 门诊名称property 
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
     * Object:成本调整's 美白property 
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
     * Object:成本调整's 城市编码property 
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
     * Object:成本调整's 城市名称property 
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
     * Object:成本调整's 状态property 
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
     * Object:成本调整's 汇总消耗种植property 
     */
    public java.math.BigDecimal getSumxhzz()
    {
        return getBigDecimal("sumxhzz");
    }
    public void setSumxhzz(java.math.BigDecimal item)
    {
        setBigDecimal("sumxhzz", item);
    }
    /**
     * Object:成本调整's 汇总消耗隐形矫正property 
     */
    public java.math.BigDecimal getSumxhyxjz()
    {
        return getBigDecimal("sumxhyxjz");
    }
    public void setSumxhyxjz(java.math.BigDecimal item)
    {
        setBigDecimal("sumxhyxjz", item);
    }
    /**
     * Object:成本调整's 汇总消耗常规矫正property 
     */
    public java.math.BigDecimal getSumxhcgjz()
    {
        return getBigDecimal("sumxhcgjz");
    }
    public void setSumxhcgjz(java.math.BigDecimal item)
    {
        setBigDecimal("sumxhcgjz", item);
    }
    /**
     * Object:成本调整's 汇总消耗口内外property 
     */
    public java.math.BigDecimal getSumxhknw()
    {
        return getBigDecimal("sumxhknw");
    }
    public void setSumxhknw(java.math.BigDecimal item)
    {
        setBigDecimal("sumxhknw", item);
    }
    /**
     * Object:成本调整's 汇总消耗修复property 
     */
    public java.math.BigDecimal getSumxhxf()
    {
        return getBigDecimal("sumxhxf");
    }
    public void setSumxhxf(java.math.BigDecimal item)
    {
        setBigDecimal("sumxhxf", item);
    }
    /**
     * Object:成本调整's 汇总消耗儿牙property 
     */
    public java.math.BigDecimal getSumxhey()
    {
        return getBigDecimal("sumxhey");
    }
    public void setSumxhey(java.math.BigDecimal item)
    {
        setBigDecimal("sumxhey", item);
    }
    /**
     * Object:成本调整's 汇总消耗牙周property 
     */
    public java.math.BigDecimal getSumxhyz()
    {
        return getBigDecimal("sumxhyz");
    }
    public void setSumxhyz(java.math.BigDecimal item)
    {
        setBigDecimal("sumxhyz", item);
    }
    /**
     * Object:成本调整's 汇总消耗美白property 
     */
    public java.math.BigDecimal getSumxhmb()
    {
        return getBigDecimal("sumxhmb");
    }
    public void setSumxhmb(java.math.BigDecimal item)
    {
        setBigDecimal("sumxhmb", item);
    }
    /**
     * Object:成本调整's 汇总加工费种植property 
     */
    public java.math.BigDecimal getSumjgfzz()
    {
        return getBigDecimal("sumjgfzz");
    }
    public void setSumjgfzz(java.math.BigDecimal item)
    {
        setBigDecimal("sumjgfzz", item);
    }
    /**
     * Object:成本调整's 汇总加工费隐形矫正property 
     */
    public java.math.BigDecimal getSumjgfyxjz()
    {
        return getBigDecimal("sumjgfyxjz");
    }
    public void setSumjgfyxjz(java.math.BigDecimal item)
    {
        setBigDecimal("sumjgfyxjz", item);
    }
    /**
     * Object:成本调整's 汇总加工费常规矫正property 
     */
    public java.math.BigDecimal getSumjgfcgjz()
    {
        return getBigDecimal("sumjgfcgjz");
    }
    public void setSumjgfcgjz(java.math.BigDecimal item)
    {
        setBigDecimal("sumjgfcgjz", item);
    }
    /**
     * Object:成本调整's 汇总加工费口内外property 
     */
    public java.math.BigDecimal getSumjgfknw()
    {
        return getBigDecimal("sumjgfknw");
    }
    public void setSumjgfknw(java.math.BigDecimal item)
    {
        setBigDecimal("sumjgfknw", item);
    }
    /**
     * Object:成本调整's 汇总加工费修复property 
     */
    public java.math.BigDecimal getSumjgfxf()
    {
        return getBigDecimal("sumjgfxf");
    }
    public void setSumjgfxf(java.math.BigDecimal item)
    {
        setBigDecimal("sumjgfxf", item);
    }
    /**
     * Object:成本调整's 汇总加工费儿牙property 
     */
    public java.math.BigDecimal getSumjgfey()
    {
        return getBigDecimal("sumjgfey");
    }
    public void setSumjgfey(java.math.BigDecimal item)
    {
        setBigDecimal("sumjgfey", item);
    }
    /**
     * Object:成本调整's 汇总加工费美白property 
     */
    public java.math.BigDecimal getSumjgfmb()
    {
        return getBigDecimal("sumjgfmb");
    }
    public void setSumjgfmb(java.math.BigDecimal item)
    {
        setBigDecimal("sumjgfmb", item);
    }
    /**
     * Object:成本调整's 汇总加工费牙周property 
     */
    public java.math.BigDecimal getSumjgfyz()
    {
        return getBigDecimal("sumjgfyz");
    }
    public void setSumjgfyz(java.math.BigDecimal item)
    {
        setBigDecimal("sumjgfyz", item);
    }
    /**
     * Object:成本调整's 加工费隐形矫正合计property 
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
     * Object:成本调整's 加工费常规矫正合计property 
     */
    public java.math.BigDecimal getAlljgfcgjz()
    {
        return getBigDecimal("alljgfcgjz");
    }
    public void setAlljgfcgjz(java.math.BigDecimal item)
    {
        setBigDecimal("alljgfcgjz", item);
    }
    /**
     * Object:成本调整's 加工费口内外合计property 
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
     * Object:成本调整's 加工费修复合计property 
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
     * Object:成本调整's 加工费儿牙合计property 
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
     * Object:成本调整's 加工费牙周合计property 
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
     * Object:成本调整's 加工费美白合计property 
     */
    public java.math.BigDecimal getAlljgdmb()
    {
        return getBigDecimal("alljgdmb");
    }
    public void setAlljgdmb(java.math.BigDecimal item)
    {
        setBigDecimal("alljgdmb", item);
    }
    /**
     * Object:成本调整's 加工费种植合计property 
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
     * Object:成本调整's 消耗种植合计property 
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
     * Object:成本调整's 消耗隐形矫正合计property 
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
     * Object:成本调整's 消耗常规矫正合计property 
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
     * Object:成本调整's 消耗口内外合计property 
     */
    public java.math.BigDecimal getAllzhknw()
    {
        return getBigDecimal("allzhknw");
    }
    public void setAllzhknw(java.math.BigDecimal item)
    {
        setBigDecimal("allzhknw", item);
    }
    /**
     * Object:成本调整's 消耗修复合计property 
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
     * Object:成本调整's 消耗儿牙合计property 
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
     * Object:成本调整's 消耗牙周合计property 
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
     * Object:成本调整's 消耗美白合计property 
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
     * Object: 成本调整 's 医生 property 
     */
    public com.kingdee.eas.basedata.person.PersonInfo getDoctor()
    {
        return (com.kingdee.eas.basedata.person.PersonInfo)get("doctor");
    }
    public void setDoctor(com.kingdee.eas.basedata.person.PersonInfo item)
    {
        put("doctor", item);
    }
    /**
     * Object:成本调整's 备注property 
     */
    public String getRemake()
    {
        return getString("remake");
    }
    public void setRemake(String item)
    {
        setString("remake", item);
    }
    /**
     * Object:成本调整's 是否自带property 
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
        return new BOSObjectType("7A8DD31F");
    }
}