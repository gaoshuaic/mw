package com.kingdee.eas.mw.pay;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractDianpingDedBJInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractDianpingDedBJInfo()
    {
        this("id");
    }
    protected AbstractDianpingDedBJInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object:�����ۿ��'s Ա������property 
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
     * Object:�����ۿ��'s Ա������property 
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
     * Object:�����ۿ��'s ���ڵ�������property 
     */
    public java.math.BigDecimal getDianpingNum()
    {
        return getBigDecimal("dianpingNum");
    }
    public void setDianpingNum(java.math.BigDecimal item)
    {
        setBigDecimal("dianpingNum", item);
    }
    /**
     * Object:�����ۿ��'s ����̨����property 
     */
    public java.math.BigDecimal getTVNum()
    {
        return getBigDecimal("TVNum");
    }
    public void setTVNum(java.math.BigDecimal item)
    {
        setBigDecimal("TVNum", item);
    }
    /**
     * Object:�����ۿ��'s ��������̨����property 
     */
    public java.math.BigDecimal getOtherTVNum()
    {
        return getBigDecimal("otherTVNum");
    }
    public void setOtherTVNum(java.math.BigDecimal item)
    {
        setBigDecimal("otherTVNum", item);
    }
    /**
     * Object:�����ۿ��'s ��������property 
     */
    public java.math.BigDecimal getWebNum()
    {
        return getBigDecimal("webNum");
    }
    public void setWebNum(java.math.BigDecimal item)
    {
        setBigDecimal("webNum", item);
    }
    /**
     * Object:�����ۿ��'s ������ʶproperty 
     */
    public java.math.BigDecimal getBidNum()
    {
        return getBigDecimal("bidNum");
    }
    public void setBidNum(java.math.BigDecimal item)
    {
        setBigDecimal("bidNum", item);
    }
    /**
     * Object:�����ۿ��'s ����ҵ��property 
     */
    public java.math.BigDecimal getPersonYJ()
    {
        return getBigDecimal("personYJ");
    }
    public void setPersonYJ(java.math.BigDecimal item)
    {
        setBigDecimal("personYJ", item);
    }
    /**
     * Object:�����ۿ��'s н������property 
     */
    public java.math.BigDecimal getBussDate()
    {
        return getBigDecimal("bussDate");
    }
    public void setBussDate(java.math.BigDecimal item)
    {
        setBigDecimal("bussDate", item);
    }
    /**
     * Object:�����ۿ��'s ��������property 
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
        return new BOSObjectType("A5507015");
    }
}