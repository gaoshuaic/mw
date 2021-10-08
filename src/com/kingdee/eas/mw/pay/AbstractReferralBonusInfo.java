package com.kingdee.eas.mw.pay;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractReferralBonusInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractReferralBonusInfo()
    {
        this("id");
    }
    protected AbstractReferralBonusInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object:ת�ｱ��'s ת��Ա������property 
     */
    public String getIntoEmpNumber()
    {
        return getString("intoEmpNumber");
    }
    public void setIntoEmpNumber(String item)
    {
        setString("intoEmpNumber", item);
    }
    /**
     * Object:ת�ｱ��'s ת��Ա������property 
     */
    public String getIntoEmpName()
    {
        return getString("intoEmpName");
    }
    public void setIntoEmpName(String item)
    {
        setString("intoEmpName", item);
    }
    /**
     * Object:ת�ｱ��'s ת��ҵ��property 
     */
    public String getReferralAchieve()
    {
        return getString("ReferralAchieve");
    }
    public void setReferralAchieve(String item)
    {
        setString("ReferralAchieve", item);
    }
    /**
     * Object:ת�ｱ��'s ת��Ա������property 
     */
    public String getOutEmpNumber()
    {
        return getString("outEmpNumber");
    }
    public void setOutEmpNumber(String item)
    {
        setString("outEmpNumber", item);
    }
    /**
     * Object:ת�ｱ��'s ת��Ա������property 
     */
    public String getOutEmpName()
    {
        return getString("outEmpName");
    }
    public void setOutEmpName(String item)
    {
        setString("outEmpName", item);
    }
    /**
     * Object:ת�ｱ��'s �ɱ�property 
     */
    public java.math.BigDecimal getCost()
    {
        return getBigDecimal("cost");
    }
    public void setCost(java.math.BigDecimal item)
    {
        setBigDecimal("cost", item);
    }
    /**
     * Object:ת�ｱ��'s ҵ������(����)property 
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
     * Object:ת�ｱ��'s ��עproperty 
     */
    public String getRemake()
    {
        return getString("remake");
    }
    public void setRemake(String item)
    {
        setString("remake", item);
    }
    /**
     * Object:ת�ｱ��'s ��������property 
     */
    public java.util.Date getImportDate()
    {
        return getDate("importDate");
    }
    public void setImportDate(java.util.Date item)
    {
        setDate("importDate", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("0BC9EC90");
    }
}