package com.kingdee.eas.mw.pay;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractHolderDataSourceInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractHolderDataSourceInfo()
    {
        this("id");
    }
    protected AbstractHolderDataSourceInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object:ѹĤ����������Դ's �������property 
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
     * Object:ѹĤ����������Դ's ��������property 
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
     * Object:ѹĤ����������Դ's ҽ������property 
     */
    public String getDoctorNumber()
    {
        return getString("doctorNumber");
    }
    public void setDoctorNumber(String item)
    {
        setString("doctorNumber", item);
    }
    /**
     * Object:ѹĤ����������Դ's ҽ������property 
     */
    public String getDoctorName()
    {
        return getString("doctorName");
    }
    public void setDoctorName(String item)
    {
        setString("doctorName", item);
    }
    /**
     * Object:ѹĤ����������Դ's ��ʿ����property 
     */
    public String getNurseNumber()
    {
        return getString("nurseNumber");
    }
    public void setNurseNumber(String item)
    {
        setString("nurseNumber", item);
    }
    /**
     * Object:ѹĤ����������Դ's ��ʿ����property 
     */
    public String getNurseName()
    {
        return getString("nurseName");
    }
    public void setNurseName(String item)
    {
        setString("nurseName", item);
    }
    /**
     * Object:ѹĤ����������Դ's �������property 
     */
    public java.math.BigDecimal getBkNum()
    {
        return getBigDecimal("bkNum");
    }
    public void setBkNum(java.math.BigDecimal item)
    {
        setBigDecimal("bkNum", item);
    }
    /**
     * Object:ѹĤ����������Դ's ȫ������property 
     */
    public java.math.BigDecimal getQkNum()
    {
        return getBigDecimal("qkNum");
    }
    public void setQkNum(java.math.BigDecimal item)
    {
        setBigDecimal("qkNum", item);
    }
    /**
     * Object:ѹĤ����������Դ's ��������property 
     */
    public java.util.Date getImportDate()
    {
        return getDate("importDate");
    }
    public void setImportDate(java.util.Date item)
    {
        setDate("importDate", item);
    }
    /**
     * Object:ѹĤ����������Դ's ҵ������(����)property 
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
        return new BOSObjectType("B665FE63");
    }
}