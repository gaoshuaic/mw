package com.kingdee.eas.mw.pay;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractCityChannelInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractCityChannelInfo()
    {
        this("id");
    }
    protected AbstractCityChannelInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 渠道折扣配置 's 城市 property 
     */
    public com.kingdee.eas.basedata.org.AdminOrgUnitInfo getCity()
    {
        return (com.kingdee.eas.basedata.org.AdminOrgUnitInfo)get("city");
    }
    public void setCity(com.kingdee.eas.basedata.org.AdminOrgUnitInfo item)
    {
        put("city", item);
    }
    /**
     * Object:渠道折扣配置's 渠道类型property 
     */
    public com.kingdee.eas.mw.pay.app.ChannelTypeEnum getChannelType()
    {
        return com.kingdee.eas.mw.pay.app.ChannelTypeEnum.getEnum(getString("channelType"));
    }
    public void setChannelType(com.kingdee.eas.mw.pay.app.ChannelTypeEnum item)
    {
		if (item != null) {
        setString("channelType", item.getValue());
		}
    }
    /**
     * Object:渠道折扣配置's 渠道property 
     */
    public String getChannel()
    {
        return getString("channel");
    }
    public void setChannel(String item)
    {
        setString("channel", item);
    }
    /**
     * Object:渠道折扣配置's 折扣property 
     */
    public java.math.BigDecimal getDiscount()
    {
        return getBigDecimal("discount");
    }
    public void setDiscount(java.math.BigDecimal item)
    {
        setBigDecimal("discount", item);
    }
    /**
     * Object:渠道折扣配置's 是否包括咨询师property 
     */
    public boolean isIncludezx()
    {
        return getBoolean("includezx");
    }
    public void setIncludezx(boolean item)
    {
        setBoolean("includezx", item);
    }
    /**
     * Object:渠道折扣配置's 是否包括医生property 
     */
    public boolean isIncludedoc()
    {
        return getBoolean("includedoc");
    }
    public void setIncludedoc(boolean item)
    {
        setBoolean("includedoc", item);
    }
    /**
     * Object:渠道折扣配置's 业务期间property 
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
        return new BOSObjectType("EDEDC6A6");
    }
}