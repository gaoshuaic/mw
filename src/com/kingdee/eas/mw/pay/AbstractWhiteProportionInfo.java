package com.kingdee.eas.mw.pay;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractWhiteProportionInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractWhiteProportionInfo()
    {
        this("id");
    }
    protected AbstractWhiteProportionInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object:���ױ���'s ����property 
     */
    public java.math.BigDecimal getProportion()
    {
        return getBigDecimal("proportion");
    }
    public void setProportion(java.math.BigDecimal item)
    {
        setBigDecimal("proportion", item);
    }
    /**
     * Object:���ױ���'s ���б���property 
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
     * Object:���ױ���'s ��������property 
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
     * Object:���ױ���'s ���ױ���property 
     */
    public String getMbNumber()
    {
        return getString("mbNumber");
    }
    public void setMbNumber(String item)
    {
        setString("mbNumber", item);
    }
    /**
     * Object: ���ױ��� 's ���� property 
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
     * Object:���ױ���'s ҵ���ڼ�property 
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
        return new BOSObjectType("773C8031");
    }
}