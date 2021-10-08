package com.kingdee.eas.mw.pay;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractAchienementSumInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractAchienementSumInfo()
    {
        this("id");
    }
    protected AbstractAchienementSumInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object:�������'s ҵ���ڼ�property 
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
     * Object:�������'s Ա������property 
     */
    public String getEmpNumber()
    {
        return getString("empNumber");
    }
    public void setEmpNumber(String item)
    {
        setString("empNumber", item);
    }
    /**
     * Object:�������'s Ա������property 
     */
    public String getEmpName()
    {
        return getString("empName");
    }
    public void setEmpName(String item)
    {
        setString("empName", item);
    }
    /**
     * Object:�������'s �������property 
     */
    public String getClinicNumber()
    {
        return getString("clinicNumber");
    }
    public void setClinicNumber(String item)
    {
        setString("clinicNumber", item);
    }
    /**
     * Object:�������'s ���б���property 
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
     * Object:�������'s ��������property 
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
     * Object:�������'s ��������property 
     */
    public java.math.BigDecimal getScalingBonus()
    {
        return getBigDecimal("scalingBonus");
    }
    public void setScalingBonus(java.math.BigDecimal item)
    {
        setBigDecimal("scalingBonus", item);
    }
    /**
     * Object:�������'s ���׽���property 
     */
    public java.math.BigDecimal getWhiteBonus()
    {
        return getBigDecimal("whiteBonus");
    }
    public void setWhiteBonus(java.math.BigDecimal item)
    {
        setBigDecimal("whiteBonus", item);
    }
    /**
     * Object:�������'s ��ѯ/�ͷ�����property 
     */
    public java.math.BigDecimal getConBonus()
    {
        return getBigDecimal("conBonus");
    }
    public void setConBonus(java.math.BigDecimal item)
    {
        setBigDecimal("conBonus", item);
    }
    /**
     * Object:�������'s ��������property 
     */
    public java.math.BigDecimal getOtherPostBonus()
    {
        return getBigDecimal("otherPostBonus");
    }
    public void setOtherPostBonus(java.math.BigDecimal item)
    {
        setBigDecimal("otherPostBonus", item);
    }
    /**
     * Object:�������'s ҽ������property 
     */
    public java.math.BigDecimal getDocBonus()
    {
        return getBigDecimal("docBonus");
    }
    public void setDocBonus(java.math.BigDecimal item)
    {
        setBigDecimal("docBonus", item);
    }
    /**
     * Object:�������'s ҽ���ɱ�property 
     */
    public java.math.BigDecimal getDocCost()
    {
        return getBigDecimal("docCost");
    }
    public void setDocCost(java.math.BigDecimal item)
    {
        setBigDecimal("docCost", item);
    }
    /**
     * Object:�������'s �ŵ�Ŀ�꽱��property 
     */
    public java.math.BigDecimal getShopGoalBonus()
    {
        return getBigDecimal("shopGoalBonus");
    }
    public void setShopGoalBonus(java.math.BigDecimal item)
    {
        setBigDecimal("shopGoalBonus", item);
    }
    /**
     * Object:�������'s ��������property 
     */
    public String getClinicName()
    {
        return getString("clinicName");
    }
    public void setClinicName(String item)
    {
        setString("clinicName", item);
    }
    /**
     * Object:�������'s ��λproperty 
     */
    public com.kingdee.eas.mw.pay.app.PaypostType getPostType()
    {
        return com.kingdee.eas.mw.pay.app.PaypostType.getEnum(getString("postType"));
    }
    public void setPostType(com.kingdee.eas.mw.pay.app.PaypostType item)
    {
		if (item != null) {
        setString("postType", item.getValue());
		}
    }
    /**
     * Object:�������'s ��λ����property 
     */
    public String getPostName()
    {
        return getString("postName");
    }
    public void setPostName(String item)
    {
        setString("postName", item);
    }
    /**
     * Object:�������'s ҽ��תҽ������property 
     */
    public java.math.BigDecimal getAssToDocBouns()
    {
        return getBigDecimal("assToDocBouns");
    }
    public void setAssToDocBouns(java.math.BigDecimal item)
    {
        setBigDecimal("assToDocBouns", item);
    }
    /**
     * Object:�������'s �ͷ�����property 
     */
    public java.math.BigDecimal getKfBonus()
    {
        return getBigDecimal("kfBonus");
    }
    public void setKfBonus(java.math.BigDecimal item)
    {
        setBigDecimal("kfBonus", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("4AF58046");
    }
}