package com.kingdee.eas.mw.pay;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractPartTimeDocProInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractPartTimeDocProInfo()
    {
        this("id");
    }
    protected AbstractPartTimeDocProInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object:兼职医生比例配置's 医生编码property 
     */
    public String getDocNumber()
    {
        return getString("docNumber");
    }
    public void setDocNumber(String item)
    {
        setString("docNumber", item);
    }
    /**
     * Object:兼职医生比例配置's 正畸收费比例property 
     */
    public java.math.BigDecimal getZjpro()
    {
        return getBigDecimal("zjpro");
    }
    public void setZjpro(java.math.BigDecimal item)
    {
        setBigDecimal("zjpro", item);
    }
    /**
     * Object:兼职医生比例配置's 自带种植提成比例property 
     */
    public java.math.BigDecimal getByzzPro()
    {
        return getBigDecimal("byzzPro");
    }
    public void setByzzPro(java.math.BigDecimal item)
    {
        setBigDecimal("byzzPro", item);
    }
    /**
     * Object:兼职医生比例配置's 自带固定矫正提成比例property 
     */
    public java.math.BigDecimal getBygdjzPro()
    {
        return getBigDecimal("bygdjzPro");
    }
    public void setBygdjzPro(java.math.BigDecimal item)
    {
        setBigDecimal("bygdjzPro", item);
    }
    /**
     * Object:兼职医生比例配置's 自带牙周提成比例property 
     */
    public java.math.BigDecimal getByyzPro()
    {
        return getBigDecimal("byyzPro");
    }
    public void setByyzPro(java.math.BigDecimal item)
    {
        setBigDecimal("byyzPro", item);
    }
    /**
     * Object:兼职医生比例配置's 自带隐形矫正提成比例property 
     */
    public java.math.BigDecimal getByyxjzPro()
    {
        return getBigDecimal("byyxjzPro");
    }
    public void setByyxjzPro(java.math.BigDecimal item)
    {
        setBigDecimal("byyxjzPro", item);
    }
    /**
     * Object:兼职医生比例配置's 自带口内外提成比例property 
     */
    public java.math.BigDecimal getByknwPro()
    {
        return getBigDecimal("byknwPro");
    }
    public void setByknwPro(java.math.BigDecimal item)
    {
        setBigDecimal("byknwPro", item);
    }
    /**
     * Object:兼职医生比例配置's 自带美白提成比例property 
     */
    public java.math.BigDecimal getBymbPro()
    {
        return getBigDecimal("bymbPro");
    }
    public void setBymbPro(java.math.BigDecimal item)
    {
        setBigDecimal("bymbPro", item);
    }
    /**
     * Object:兼职医生比例配置's 自带修复提成比例property 
     */
    public java.math.BigDecimal getByxfPro()
    {
        return getBigDecimal("byxfPro");
    }
    public void setByxfPro(java.math.BigDecimal item)
    {
        setBigDecimal("byxfPro", item);
    }
    /**
     * Object:兼职医生比例配置's 自带儿牙提成比例property 
     */
    public java.math.BigDecimal getByeyPro()
    {
        return getBigDecimal("byeyPro");
    }
    public void setByeyPro(java.math.BigDecimal item)
    {
        setBigDecimal("byeyPro", item);
    }
    /**
     * Object:兼职医生比例配置's 非自带种植提成比例property 
     */
    public java.math.BigDecimal getZzPro()
    {
        return getBigDecimal("zzPro");
    }
    public void setZzPro(java.math.BigDecimal item)
    {
        setBigDecimal("zzPro", item);
    }
    /**
     * Object:兼职医生比例配置's 非自带固定矫正提成比例property 
     */
    public java.math.BigDecimal getGdjzPro()
    {
        return getBigDecimal("gdjzPro");
    }
    public void setGdjzPro(java.math.BigDecimal item)
    {
        setBigDecimal("gdjzPro", item);
    }
    /**
     * Object:兼职医生比例配置's 非自带隐形矫正提成比例property 
     */
    public java.math.BigDecimal getYxjzPro()
    {
        return getBigDecimal("yxjzPro");
    }
    public void setYxjzPro(java.math.BigDecimal item)
    {
        setBigDecimal("yxjzPro", item);
    }
    /**
     * Object:兼职医生比例配置's 非自带牙周提成比例property 
     */
    public java.math.BigDecimal getZyPro()
    {
        return getBigDecimal("zyPro");
    }
    public void setZyPro(java.math.BigDecimal item)
    {
        setBigDecimal("zyPro", item);
    }
    /**
     * Object:兼职医生比例配置's 非自带口内外提成比例property 
     */
    public java.math.BigDecimal getKnwPro()
    {
        return getBigDecimal("knwPro");
    }
    public void setKnwPro(java.math.BigDecimal item)
    {
        setBigDecimal("knwPro", item);
    }
    /**
     * Object:兼职医生比例配置's 非自带美白提成比例property 
     */
    public java.math.BigDecimal getMbPro()
    {
        return getBigDecimal("mbPro");
    }
    public void setMbPro(java.math.BigDecimal item)
    {
        setBigDecimal("mbPro", item);
    }
    /**
     * Object:兼职医生比例配置's 非自带修复提成比例property 
     */
    public java.math.BigDecimal getZfPro()
    {
        return getBigDecimal("zfPro");
    }
    public void setZfPro(java.math.BigDecimal item)
    {
        setBigDecimal("zfPro", item);
    }
    /**
     * Object:兼职医生比例配置's 非自带儿牙提成比例property 
     */
    public java.math.BigDecimal getEyPro()
    {
        return getBigDecimal("eyPro");
    }
    public void setEyPro(java.math.BigDecimal item)
    {
        setBigDecimal("eyPro", item);
    }
    /**
     * Object:兼职医生比例配置's 医生名称property 
     */
    public String getDocName()
    {
        return getString("docName");
    }
    public void setDocName(String item)
    {
        setString("docName", item);
    }
    /**
     * Object:兼职医生比例配置's 城市编码property 
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
     * Object:兼职医生比例配置's 城市名称property 
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
     * Object: 兼职医生比例配置 's 城市 property 
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
     * Object:兼职医生比例配置's 业务期间property 
     */
    public String getBusinessDate()
    {
        return getString("businessDate");
    }
    public void setBusinessDate(String item)
    {
        setString("businessDate", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("9E09AB87");
    }
}