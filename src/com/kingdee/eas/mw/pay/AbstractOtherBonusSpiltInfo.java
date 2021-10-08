package com.kingdee.eas.mw.pay;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractOtherBonusSpiltInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractOtherBonusSpiltInfo()
    {
        this("id");
    }
    protected AbstractOtherBonusSpiltInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object:其他奖金项's 岗位名称property 
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
     * Object:其他奖金项's 员工编码property 
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
     * Object:其他奖金项's 员工名称property 
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
     * Object:其他奖金项's 门诊编码property 
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
     * Object:其他奖金项's 门诊名称property 
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
     * Object:其他奖金项's 岗位property 
     */
    public com.kingdee.eas.mw.pay.app.PaypostType getPostNumber()
    {
        return com.kingdee.eas.mw.pay.app.PaypostType.getEnum(getString("postNumber"));
    }
    public void setPostNumber(com.kingdee.eas.mw.pay.app.PaypostType item)
    {
		if (item != null) {
        setString("postNumber", item.getValue());
		}
    }
    /**
     * Object: 其他奖金项 's 门诊 property 
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
     * Object: 其他奖金项 's 城市 property 
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
     * Object:其他奖金项's 业务期间property 
     */
    public String getBusinessdate()
    {
        return getString("businessdate");
    }
    public void setBusinessdate(String item)
    {
        setString("businessdate", item);
    }
    /**
     * Object:其他奖金项's 卡类销售奖金property 
     */
    public java.math.BigDecimal getCardSellBonus()
    {
        return getBigDecimal("cardSellBonus");
    }
    public void setCardSellBonus(java.math.BigDecimal item)
    {
        setBigDecimal("cardSellBonus", item);
    }
    /**
     * Object:其他奖金项's 其他奖金1保底内property 
     */
    public java.math.BigDecimal getOtherBounsOne()
    {
        return getBigDecimal("otherBounsOne");
    }
    public void setOtherBounsOne(java.math.BigDecimal item)
    {
        setBigDecimal("otherBounsOne", item);
    }
    /**
     * Object:其他奖金项's 其他奖金2保底外property 
     */
    public java.math.BigDecimal getOtherBounsTwo()
    {
        return getBigDecimal("otherBounsTwo");
    }
    public void setOtherBounsTwo(java.math.BigDecimal item)
    {
        setBigDecimal("otherBounsTwo", item);
    }
    /**
     * Object:其他奖金项's 医助奖金property 
     */
    public java.math.BigDecimal getDocAssBouns()
    {
        return getBigDecimal("docAssBouns");
    }
    public void setDocAssBouns(java.math.BigDecimal item)
    {
        setBigDecimal("docAssBouns", item);
    }
    /**
     * Object:其他奖金项's 门店支援property 
     */
    public java.math.BigDecimal getShopHelp()
    {
        return getBigDecimal("shopHelp");
    }
    public void setShopHelp(java.math.BigDecimal item)
    {
        setBigDecimal("shopHelp", item);
    }
    /**
     * Object:其他奖金项's 好评奖金property 
     */
    public java.math.BigDecimal getGoodBouns()
    {
        return getBigDecimal("goodBouns");
    }
    public void setGoodBouns(java.math.BigDecimal item)
    {
        setBigDecimal("goodBouns", item);
    }
    /**
     * Object:其他奖金项's 市场奖金property 
     */
    public java.math.BigDecimal getMarktBouns()
    {
        return getBigDecimal("marktBouns");
    }
    public void setMarktBouns(java.math.BigDecimal item)
    {
        setBigDecimal("marktBouns", item);
    }
    /**
     * Object:其他奖金项's 医助转医生奖金property 
     */
    public java.math.BigDecimal getToDocBouns()
    {
        return getBigDecimal("toDocBouns");
    }
    public void setToDocBouns(java.math.BigDecimal item)
    {
        setBigDecimal("toDocBouns", item);
    }
    /**
     * Object:其他奖金项's 医生奖金预留金额property 
     */
    public java.math.BigDecimal getDocKeepBouns()
    {
        return getBigDecimal("docKeepBouns");
    }
    public void setDocKeepBouns(java.math.BigDecimal item)
    {
        setBigDecimal("docKeepBouns", item);
    }
    /**
     * Object:其他奖金项's 医生预留类型property 
     */
    public com.kingdee.eas.mw.pay.app.DocKeepType getDocKeepType()
    {
        return com.kingdee.eas.mw.pay.app.DocKeepType.getEnum(getString("docKeepType"));
    }
    public void setDocKeepType(com.kingdee.eas.mw.pay.app.DocKeepType item)
    {
		if (item != null) {
        setString("docKeepType", item.getValue());
		}
    }
    /**
     * Object:其他奖金项's 客服奖金property 
     */
    public java.math.BigDecimal getKefuBouns()
    {
        return getBigDecimal("kefuBouns");
    }
    public void setKefuBouns(java.math.BigDecimal item)
    {
        setBigDecimal("kefuBouns", item);
    }
    /**
     * Object:其他奖金项's 护理奖金property 
     */
    public java.math.BigDecimal getHuliBouns()
    {
        return getBigDecimal("huliBouns");
    }
    public void setHuliBouns(java.math.BigDecimal item)
    {
        setBigDecimal("huliBouns", item);
    }
    /**
     * Object:其他奖金项's 洁牙师转换奖金property 
     */
    public java.math.BigDecimal getConvertBouns()
    {
        return getBigDecimal("convertBouns");
    }
    public void setConvertBouns(java.math.BigDecimal item)
    {
        setBigDecimal("convertBouns", item);
    }
    /**
     * Object:其他奖金项's 月保底基数property 
     */
    public java.math.BigDecimal getMonthBase()
    {
        return getBigDecimal("monthBase");
    }
    public void setMonthBase(java.math.BigDecimal item)
    {
        setBigDecimal("monthBase", item);
    }
    /**
     * Object:其他奖金项's 半口数量property 
     */
    public java.math.BigDecimal getBkCount()
    {
        return getBigDecimal("bkCount");
    }
    public void setBkCount(java.math.BigDecimal item)
    {
        setBigDecimal("bkCount", item);
    }
    /**
     * Object:其他奖金项's 全口数量property 
     */
    public java.math.BigDecimal getQkCount()
    {
        return getBigDecimal("qkCount");
    }
    public void setQkCount(java.math.BigDecimal item)
    {
        setBigDecimal("qkCount", item);
    }
    /**
     * Object:其他奖金项's 压膜保持器奖金property 
     */
    public java.math.BigDecimal getHoldAmount()
    {
        return getBigDecimal("holdAmount");
    }
    public void setHoldAmount(java.math.BigDecimal item)
    {
        setBigDecimal("holdAmount", item);
    }
    /**
     * Object:其他奖金项's X-Ray津贴property 
     */
    public java.math.BigDecimal getXrayallow()
    {
        return getBigDecimal("xrayallow");
    }
    public void setXrayallow(java.math.BigDecimal item)
    {
        setBigDecimal("xrayallow", item);
    }
    /**
     * Object:其他奖金项's 年终奖金property 
     */
    public java.math.BigDecimal getNianzhongmoney()
    {
        return getBigDecimal("nianzhongmoney");
    }
    public void setNianzhongmoney(java.math.BigDecimal item)
    {
        setBigDecimal("nianzhongmoney", item);
    }
    /**
     * Object:其他奖金项's 季度奖金property 
     */
    public java.math.BigDecimal getJidumoney()
    {
        return getBigDecimal("jidumoney");
    }
    public void setJidumoney(java.math.BigDecimal item)
    {
        setBigDecimal("jidumoney", item);
    }
    /**
     * Object:其他奖金项's 年终奖金分摊property 
     */
    public java.math.BigDecimal getNianzhongfentan()
    {
        return getBigDecimal("nianzhongfentan");
    }
    public void setNianzhongfentan(java.math.BigDecimal item)
    {
        setBigDecimal("nianzhongfentan", item);
    }
    /**
     * Object:其他奖金项's 季度奖金分摊property 
     */
    public java.math.BigDecimal getJidufentan()
    {
        return getBigDecimal("jidufentan");
    }
    public void setJidufentan(java.math.BigDecimal item)
    {
        setBigDecimal("jidufentan", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("F9613513");
    }
}