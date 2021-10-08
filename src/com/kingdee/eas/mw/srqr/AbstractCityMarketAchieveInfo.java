package com.kingdee.eas.mw.srqr;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractCityMarketAchieveInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractCityMarketAchieveInfo()
    {
        this("id");
    }
    protected AbstractCityMarketAchieveInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 城市市场业绩 's 城市 property 
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
     * Object:城市市场业绩's 目标业绩property 
     */
    public java.math.BigDecimal getTarachieve()
    {
        return getBigDecimal("tarachieve");
    }
    public void setTarachieve(java.math.BigDecimal item)
    {
        setBigDecimal("tarachieve", item);
    }
    /**
     * Object:城市市场业绩's 实际业绩property 
     */
    public java.math.BigDecimal getRelachieve()
    {
        return getBigDecimal("relachieve");
    }
    public void setRelachieve(java.math.BigDecimal item)
    {
        setBigDecimal("relachieve", item);
    }
    /**
     * Object: 城市市场业绩 's 市场部门 property 
     */
    public com.kingdee.eas.mw.srqr.PostTypeInfo getMarketdep()
    {
        return (com.kingdee.eas.mw.srqr.PostTypeInfo)get("marketdep");
    }
    public void setMarketdep(com.kingdee.eas.mw.srqr.PostTypeInfo item)
    {
        put("marketdep", item);
    }
    /**
     * Object:城市市场业绩's 业务年月property 
     */
    public String getBusinessdate()
    {
        return getString("businessdate");
    }
    public void setBusinessdate(String item)
    {
        setString("businessdate", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("64A8C70E");
    }
}