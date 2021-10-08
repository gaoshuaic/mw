package com.kingdee.eas.mw.pay;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractConsultantProInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractConsultantProInfo()
    {
        this("id");
    }
    protected AbstractConsultantProInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object:��ѯ��������'s ��һ�㼶property 
     */
    public java.math.BigDecimal getFirst()
    {
        return getBigDecimal("first");
    }
    public void setFirst(java.math.BigDecimal item)
    {
        setBigDecimal("first", item);
    }
    /**
     * Object:��ѯ��������'s ��һ�㼶���property 
     */
    public java.math.BigDecimal getFirstMoney()
    {
        return getBigDecimal("firstMoney");
    }
    public void setFirstMoney(java.math.BigDecimal item)
    {
        setBigDecimal("firstMoney", item);
    }
    /**
     * Object:��ѯ��������'s �ڶ��㼶property 
     */
    public java.math.BigDecimal getSecond()
    {
        return getBigDecimal("second");
    }
    public void setSecond(java.math.BigDecimal item)
    {
        setBigDecimal("second", item);
    }
    /**
     * Object:��ѯ��������'s �ڶ��㼶���property 
     */
    public java.math.BigDecimal getSecondMoney()
    {
        return getBigDecimal("secondMoney");
    }
    public void setSecondMoney(java.math.BigDecimal item)
    {
        setBigDecimal("secondMoney", item);
    }
    /**
     * Object:��ѯ��������'s �����㼶property 
     */
    public java.math.BigDecimal getThird()
    {
        return getBigDecimal("third");
    }
    public void setThird(java.math.BigDecimal item)
    {
        setBigDecimal("third", item);
    }
    /**
     * Object:��ѯ��������'s ��������property 
     */
    public java.math.BigDecimal getYysl()
    {
        return getBigDecimal("yysl");
    }
    public void setYysl(java.math.BigDecimal item)
    {
        setBigDecimal("yysl", item);
    }
    /**
     * Object:��ѯ��������'s ���б���property 
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
     * Object:��ѯ��������'s ��������property 
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
     * Object: ��ѯ�������� 's ���� property 
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
     * Object:��ѯ��������'s �ŵ��Сproperty 
     */
    public com.kingdee.eas.mw.pay.app.ShopSize getShopSize()
    {
        return com.kingdee.eas.mw.pay.app.ShopSize.getEnum(getString("shopSize"));
    }
    public void setShopSize(com.kingdee.eas.mw.pay.app.ShopSize item)
    {
		if (item != null) {
        setString("shopSize", item.getValue());
		}
    }
    /**
     * Object:��ѯ��������'s ҵ���ڼ�property 
     */
    public String getBusinessDate()
    {
        return getString("businessDate");
    }
    public void setBusinessDate(String item)
    {
        setString("businessDate", item);
    }
    /**
     * Object:��ѯ��������'s ��ռ����property 
     */
    public java.math.BigDecimal getBiliPro()
    {
        return getBigDecimal("biliPro");
    }
    public void setBiliPro(java.math.BigDecimal item)
    {
        setBigDecimal("biliPro", item);
    }
    /**
     * Object:��ѯ��������'s �ۿ�property 
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
     * Object:��ѯ��������'s ��������property 
     */
    public String getType()
    {
        return getString("type");
    }
    public void setType(String item)
    {
        setString("type", item);
    }
    /**
     * Object:��ѯ��������'s ��ѯԤ������property 
     */
    public java.math.BigDecimal getKeepPro()
    {
        return getBigDecimal("keepPro");
    }
    public void setKeepPro(java.math.BigDecimal item)
    {
        setBigDecimal("keepPro", item);
    }
    /**
     * Object:��ѯ��������'s �ܱ߲�Ʒ����property 
     */
    public java.math.BigDecimal getZbPro()
    {
        return getBigDecimal("zbPro");
    }
    public void setZbPro(java.math.BigDecimal item)
    {
        setBigDecimal("zbPro", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("8C7BFC40");
    }
}