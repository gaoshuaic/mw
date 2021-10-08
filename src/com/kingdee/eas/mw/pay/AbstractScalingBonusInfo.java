package com.kingdee.eas.mw.pay;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractScalingBonusInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractScalingBonusInfo()
    {
        this("id");
    }
    protected AbstractScalingBonusInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object:�������𵥼�'s ����property 
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
     * Object:�������𵥼�'s ���б���property 
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
     * Object:�������𵥼�'s ��������property 
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
     * Object:�������𵥼�'s ��������property 
     */
    public com.kingdee.eas.mw.pay.app.jyType getJyNumber()
    {
        return com.kingdee.eas.mw.pay.app.jyType.getEnum(getString("jyNumber"));
    }
    public void setJyNumber(com.kingdee.eas.mw.pay.app.jyType item)
    {
		if (item != null) {
        setString("jyNumber", item.getValue());
		}
    }
    /**
     * Object: �������𵥼� 's ���� property 
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
     * Object:�������𵥼�'s �Ƿ����ҽ��property 
     */
    public com.kingdee.eas.mw.pay.app.includeDoc getIncludeDoc()
    {
        return com.kingdee.eas.mw.pay.app.includeDoc.getEnum(getString("includeDoc"));
    }
    public void setIncludeDoc(com.kingdee.eas.mw.pay.app.includeDoc item)
    {
		if (item != null) {
        setString("includeDoc", item.getValue());
		}
    }
    /**
     * Object:�������𵥼�'s ҵ���ڼ�property 
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
        return new BOSObjectType("D53FD90A");
    }
}