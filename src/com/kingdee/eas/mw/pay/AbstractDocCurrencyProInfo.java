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
     * Object:ҽ�����ͨ�ñ���'s ��ֲ����property 
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
     * Object:ҽ�����ͨ�ñ���'s �̶���������property 
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
     * Object:ҽ�����ͨ�ñ���'s ���ν�������property 
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
     * Object:ҽ�����ͨ�ñ���'s ��������property 
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
     * Object:ҽ�����ͨ�ñ���'s ���������property 
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
     * Object:ҽ�����ͨ�ñ���'s ���ױ���property 
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
     * Object:ҽ�����ͨ�ñ���'s �޸�����property 
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
     * Object:ҽ�����ͨ�ñ���'s ��������property 
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
     * Object:ҽ�����ͨ�ñ���'s ������ɱ���property 
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
     * Object:ҽ�����ͨ�ñ���'s ���б���property 
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
     * Object:ҽ�����ͨ�ñ���'s ��������property 
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
     * Object: ҽ�����ͨ�ñ��� 's ���� property 
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
     * Object:ҽ�����ͨ�ñ���'s ���㷽ʽproperty 
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
     * Object:ҽ�����ͨ�ñ���'s ҵ���ڼ�property 
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
     * Object:ҽ�����ͨ�ñ���'s �⹤��������property 
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
     * Object:ҽ�����ͨ�ñ���'s ��������property 
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
     * Object:ҽ�����ͨ�ñ���'s һ�������ۿ�property 
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
     * Object:ҽ�����ͨ�ñ���'s �����ۿ۱���property 
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
     * Object:ҽ�����ͨ�ñ���'s ��ڵ���property 
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
     * Object:ҽ�����ͨ�ñ���'s ȫ�ڵ���property 
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