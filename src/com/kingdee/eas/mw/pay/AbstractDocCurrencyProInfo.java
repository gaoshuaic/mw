package com.kingdee.eas.mw.pay;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractDocCurrencyProInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractDocCurrencyProInfo()
    {
        this("id");
    }
    protected AbstractDocCurrencyProInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object:医生提成通用比例's 种植比例property 
     */
    public java.math.BigDecimal getZzbl()
    {
        return getBigDecimal("zzbl");
    }
    public void setZzbl(java.math.BigDecimal item)
    {
        setBigDecimal("zzbl", item);
    }
    /**
     * Object:医生提成通用比例's 固定矫正比例property 
     */
    public java.math.BigDecimal getGdjzbl()
    {
        return getBigDecimal("gdjzbl");
    }
    public void setGdjzbl(java.math.BigDecimal item)
    {
        setBigDecimal("gdjzbl", item);
    }
    /**
     * Object:医生提成通用比例's 隐形矫正比例property 
     */
    public java.math.BigDecimal getYxjzbl()
    {
        return getBigDecimal("yxjzbl");
    }
    public void setYxjzbl(java.math.BigDecimal item)
    {
        setBigDecimal("yxjzbl", item);
    }
    /**
     * Object:医生提成通用比例's 牙周治疗property 
     */
    public java.math.BigDecimal getYzzlbl()
    {
        return getBigDecimal("yzzlbl");
    }
    public void setYzzlbl(java.math.BigDecimal item)
    {
        setBigDecimal("yzzlbl", item);
    }
    /**
     * Object:医生提成通用比例's 口内外比例property 
     */
    public java.math.BigDecimal getKnwbl()
    {
        return getBigDecimal("knwbl");
    }
    public void setKnwbl(java.math.BigDecimal item)
    {
        setBigDecimal("knwbl", item);
    }
    /**
     * Object:医生提成通用比例's 美白比例property 
     */
    public java.math.BigDecimal getMbbl()
    {
        return getBigDecimal("mbbl");
    }
    public void setMbbl(java.math.BigDecimal item)
    {
        setBigDecimal("mbbl", item);
    }
    /**
     * Object:医生提成通用比例's 修复比例property 
     */
    public java.math.BigDecimal getXfbl()
    {
        return getBigDecimal("xfbl");
    }
    public void setXfbl(java.math.BigDecimal item)
    {
        setBigDecimal("xfbl", item);
    }
    /**
     * Object:医生提成通用比例's 儿牙比例property 
     */
    public java.math.BigDecimal getEybl()
    {
        return getBigDecimal("eybl");
    }
    public void setEybl(java.math.BigDecimal item)
    {
        setBigDecimal("eybl", item);
    }
    /**
     * Object:医生提成通用比例's 正畸提成比例property 
     */
    public java.math.BigDecimal getZjbl()
    {
        return getBigDecimal("zjbl");
    }
    public void setZjbl(java.math.BigDecimal item)
    {
        setBigDecimal("zjbl", item);
    }
    /**
     * Object:医生提成通用比例's 城市编码property 
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
     * Object:医生提成通用比例's 城市名称property 
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
     * Object: 医生提成通用比例 's 城市 property 
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
     * Object:医生提成通用比例's 计算方式property 
     */
    public com.kingdee.eas.mw.pay.app.calDocAchieveType getCalType()
    {
        return com.kingdee.eas.mw.pay.app.calDocAchieveType.getEnum(getString("calType"));
    }
    public void setCalType(com.kingdee.eas.mw.pay.app.calDocAchieveType item)
    {
		if (item != null) {
        setString("calType", item.getValue());
		}
    }
    /**
     * Object:医生提成通用比例's 业务期间property 
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
     * Object:医生提成通用比例's 免工作量比例property 
     */
    public java.math.BigDecimal getFreeWorkPro()
    {
        return getBigDecimal("freeWorkPro");
    }
    public void setFreeWorkPro(java.math.BigDecimal item)
    {
        setBigDecimal("freeWorkPro", item);
    }
    /**
     * Object:医生提成通用比例's 渠道比例property 
     */
    public java.math.BigDecimal getSourcePro()
    {
        return getBigDecimal("sourcePro");
    }
    public void setSourcePro(java.math.BigDecimal item)
    {
        setBigDecimal("sourcePro", item);
    }
    /**
     * Object:医生提成通用比例's 一级渠道折扣property 
     */
    public String getFirstSource()
    {
        return getString("firstSource");
    }
    public void setFirstSource(String item)
    {
        setString("firstSource", item);
    }
    /**
     * Object:医生提成通用比例's 赠金折扣比例property 
     */
    public java.math.BigDecimal getGifAmountPro()
    {
        return getBigDecimal("gifAmountPro");
    }
    public void setGifAmountPro(java.math.BigDecimal item)
    {
        setBigDecimal("gifAmountPro", item);
    }
    /**
     * Object:医生提成通用比例's 半口单价property 
     */
    public java.math.BigDecimal getBkPrice()
    {
        return getBigDecimal("bkPrice");
    }
    public void setBkPrice(java.math.BigDecimal item)
    {
        setBigDecimal("bkPrice", item);
    }
    /**
     * Object:医生提成通用比例's 全口单价property 
     */
    public java.math.BigDecimal getQkPrice()
    {
        return getBigDecimal("qkPrice");
    }
    public void setQkPrice(java.math.BigDecimal item)
    {
        setBigDecimal("qkPrice", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("21F17836");
    }
}