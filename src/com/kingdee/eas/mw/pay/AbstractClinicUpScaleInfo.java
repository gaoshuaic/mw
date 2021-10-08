package com.kingdee.eas.mw.pay;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractClinicUpScaleInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractClinicUpScaleInfo()
    {
        this("id");
    }
    protected AbstractClinicUpScaleInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: �ŵ���ɱ������� 's ���� property 
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
     * Object: �ŵ���ɱ������� 's ���� property 
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
     * Object:�ŵ���ɱ�������'s �ⶥ���property 
     */
    public java.math.BigDecimal getHigAmount()
    {
        return getBigDecimal("higAmount");
    }
    public void setHigAmount(java.math.BigDecimal item)
    {
        setBigDecimal("higAmount", item);
    }
    /**
     * Object:�ŵ���ɱ�������'s �������property 
     */
    public java.math.BigDecimal getRewardAmount()
    {
        return getBigDecimal("rewardAmount");
    }
    public void setRewardAmount(java.math.BigDecimal item)
    {
        setBigDecimal("rewardAmount", item);
    }
    /**
     * Object:�ŵ���ɱ�������'s �����property 
     */
    public java.math.BigDecimal getPassPro()
    {
        return getBigDecimal("passPro");
    }
    public void setPassPro(java.math.BigDecimal item)
    {
        setBigDecimal("passPro", item);
    }
    /**
     * Object:�ŵ���ɱ�������'s ����������property 
     */
    public java.math.BigDecimal getAddAmount()
    {
        return getBigDecimal("addAmount");
    }
    public void setAddAmount(java.math.BigDecimal item)
    {
        setBigDecimal("addAmount", item);
    }
    /**
     * Object:�ŵ���ɱ�������'s ҵ����ɱ���property 
     */
    public java.math.BigDecimal getAchievePro()
    {
        return getBigDecimal("achievePro");
    }
    public void setAchievePro(java.math.BigDecimal item)
    {
        setBigDecimal("achievePro", item);
    }
    /**
     * Object:�ŵ���ɱ�������'s ҵ���ڼ�property 
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
     * Object:�ŵ���ɱ�������'s ���ۿ���property 
     */
    public java.math.BigDecimal getBigShopPrice()
    {
        return getBigDecimal("bigShopPrice");
    }
    public void setBigShopPrice(java.math.BigDecimal item)
    {
        setBigDecimal("bigShopPrice", item);
    }
    /**
     * Object:�ŵ���ɱ�������'s С��ۿ���property 
     */
    public java.math.BigDecimal getSmallShopAmount()
    {
        return getBigDecimal("smallShopAmount");
    }
    public void setSmallShopAmount(java.math.BigDecimal item)
    {
        setBigDecimal("smallShopAmount", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("DD941F75");
    }
}