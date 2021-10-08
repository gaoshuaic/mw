package com.kingdee.eas.mw.pay;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractServiceAmountInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractServiceAmountInfo()
    {
        this("id");
    }
    protected AbstractServiceAmountInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object:������'s �������property 
     */
    public String getMzNumber()
    {
        return getString("mzNumber");
    }
    public void setMzNumber(String item)
    {
        setString("mzNumber", item);
    }
    /**
     * Object:������'s ���﹫˾����property 
     */
    public String getMzName()
    {
        return getString("mzName");
    }
    public void setMzName(String item)
    {
        setString("mzName", item);
    }
    /**
     * Object:������'s Ա������property 
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
     * Object:������'s Ա������property 
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
     * Object:������'s ���-����property 
     */
    public java.math.BigDecimal getHlAmount()
    {
        return getBigDecimal("hlAmount");
    }
    public void setHlAmount(java.math.BigDecimal item)
    {
        setBigDecimal("hlAmount", item);
    }
    /**
     * Object:������'s ���-��������property 
     */
    public java.math.BigDecimal getKlxsAmount()
    {
        return getBigDecimal("klxsAmount");
    }
    public void setKlxsAmount(java.math.BigDecimal item)
    {
        setBigDecimal("klxsAmount", item);
    }
    /**
     * Object:������'s ���-�ŵ�֧Ԯproperty 
     */
    public java.math.BigDecimal getMdzyAmount()
    {
        return getBigDecimal("mdzyAmount");
    }
    public void setMdzyAmount(java.math.BigDecimal item)
    {
        setBigDecimal("mdzyAmount", item);
    }
    /**
     * Object:������'s ���-�ͻ�property 
     */
    public java.math.BigDecimal getKhAmount()
    {
        return getBigDecimal("khAmount");
    }
    public void setKhAmount(java.math.BigDecimal item)
    {
        setBigDecimal("khAmount", item);
    }
    /**
     * Object:������'s ҵ������(����)property 
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
     * Object:������'s ��������property 
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
        return new BOSObjectType("6DE2E57B");
    }
}