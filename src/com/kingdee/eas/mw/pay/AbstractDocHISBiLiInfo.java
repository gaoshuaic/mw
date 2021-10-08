package com.kingdee.eas.mw.pay;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractDocHISBiLiInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractDocHISBiLiInfo()
    {
        this("id");
    }
    protected AbstractDocHISBiLiInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object:医生His比例配置's 一级扣减property 
     */
    public java.math.BigDecimal getYijikou()
    {
        return getBigDecimal("yijikou");
    }
    public void setYijikou(java.math.BigDecimal item)
    {
        setBigDecimal("yijikou", item);
    }
    /**
     * Object:医生His比例配置's 二级扣减property 
     */
    public java.math.BigDecimal getErjikou()
    {
        return getBigDecimal("erjikou");
    }
    public void setErjikou(java.math.BigDecimal item)
    {
        setBigDecimal("erjikou", item);
    }
    /**
     * Object:医生His比例配置's 隐形扣减property 
     */
    public java.math.BigDecimal getYxkou()
    {
        return getBigDecimal("yxkou");
    }
    public void setYxkou(java.math.BigDecimal item)
    {
        setBigDecimal("yxkou", item);
    }
    /**
     * Object:医生His比例配置's 固定扣减property 
     */
    public java.math.BigDecimal getGdkou()
    {
        return getBigDecimal("gdkou");
    }
    public void setGdkou(java.math.BigDecimal item)
    {
        setBigDecimal("gdkou", item);
    }
    /**
     * Object:医生His比例配置's 隐形剩余property 
     */
    public java.math.BigDecimal getYxshengyukou()
    {
        return getBigDecimal("yxshengyukou");
    }
    public void setYxshengyukou(java.math.BigDecimal item)
    {
        setBigDecimal("yxshengyukou", item);
    }
    /**
     * Object:医生His比例配置's 固定剩余property 
     */
    public java.math.BigDecimal getGdshengyukou()
    {
        return getBigDecimal("gdshengyukou");
    }
    public void setGdshengyukou(java.math.BigDecimal item)
    {
        setBigDecimal("gdshengyukou", item);
    }
    /**
     * Object:医生His比例配置's 一级扣减渠道property 
     */
    public String getYijiqudao()
    {
        return getString("yijiqudao");
    }
    public void setYijiqudao(String item)
    {
        setString("yijiqudao", item);
    }
    /**
     * Object:医生His比例配置's 二级扣减渠道property 
     */
    public String getErjiqudao()
    {
        return getString("erjiqudao");
    }
    public void setErjiqudao(String item)
    {
        setString("erjiqudao", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("D3693B30");
    }
}