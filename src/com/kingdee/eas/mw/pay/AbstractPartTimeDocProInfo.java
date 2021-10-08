package com.kingdee.eas.mw.pay;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractPartTimeDocProInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractPartTimeDocProInfo()
    {
        this("id");
    }
    protected AbstractPartTimeDocProInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object:��ְҽ����������'s ҽ������property 
     */
    public String getDocNumber()
    {
        return getString("docNumber");
    }
    public void setDocNumber(String item)
    {
        setString("docNumber", item);
    }
    /**
     * Object:��ְҽ����������'s �����շѱ���property 
     */
    public java.math.BigDecimal getZjpro()
    {
        return getBigDecimal("zjpro");
    }
    public void setZjpro(java.math.BigDecimal item)
    {
        setBigDecimal("zjpro", item);
    }
    /**
     * Object:��ְҽ����������'s �Դ���ֲ��ɱ���property 
     */
    public java.math.BigDecimal getByzzPro()
    {
        return getBigDecimal("byzzPro");
    }
    public void setByzzPro(java.math.BigDecimal item)
    {
        setBigDecimal("byzzPro", item);
    }
    /**
     * Object:��ְҽ����������'s �Դ��̶�������ɱ���property 
     */
    public java.math.BigDecimal getBygdjzPro()
    {
        return getBigDecimal("bygdjzPro");
    }
    public void setBygdjzPro(java.math.BigDecimal item)
    {
        setBigDecimal("bygdjzPro", item);
    }
    /**
     * Object:��ְҽ����������'s �Դ�������ɱ���property 
     */
    public java.math.BigDecimal getByyzPro()
    {
        return getBigDecimal("byyzPro");
    }
    public void setByyzPro(java.math.BigDecimal item)
    {
        setBigDecimal("byyzPro", item);
    }
    /**
     * Object:��ְҽ����������'s �Դ����ν�����ɱ���property 
     */
    public java.math.BigDecimal getByyxjzPro()
    {
        return getBigDecimal("byyxjzPro");
    }
    public void setByyxjzPro(java.math.BigDecimal item)
    {
        setBigDecimal("byyxjzPro", item);
    }
    /**
     * Object:��ְҽ����������'s �Դ���������ɱ���property 
     */
    public java.math.BigDecimal getByknwPro()
    {
        return getBigDecimal("byknwPro");
    }
    public void setByknwPro(java.math.BigDecimal item)
    {
        setBigDecimal("byknwPro", item);
    }
    /**
     * Object:��ְҽ����������'s �Դ�������ɱ���property 
     */
    public java.math.BigDecimal getBymbPro()
    {
        return getBigDecimal("bymbPro");
    }
    public void setBymbPro(java.math.BigDecimal item)
    {
        setBigDecimal("bymbPro", item);
    }
    /**
     * Object:��ְҽ����������'s �Դ��޸���ɱ���property 
     */
    public java.math.BigDecimal getByxfPro()
    {
        return getBigDecimal("byxfPro");
    }
    public void setByxfPro(java.math.BigDecimal item)
    {
        setBigDecimal("byxfPro", item);
    }
    /**
     * Object:��ְҽ����������'s �Դ�������ɱ���property 
     */
    public java.math.BigDecimal getByeyPro()
    {
        return getBigDecimal("byeyPro");
    }
    public void setByeyPro(java.math.BigDecimal item)
    {
        setBigDecimal("byeyPro", item);
    }
    /**
     * Object:��ְҽ����������'s ���Դ���ֲ��ɱ���property 
     */
    public java.math.BigDecimal getZzPro()
    {
        return getBigDecimal("zzPro");
    }
    public void setZzPro(java.math.BigDecimal item)
    {
        setBigDecimal("zzPro", item);
    }
    /**
     * Object:��ְҽ����������'s ���Դ��̶�������ɱ���property 
     */
    public java.math.BigDecimal getGdjzPro()
    {
        return getBigDecimal("gdjzPro");
    }
    public void setGdjzPro(java.math.BigDecimal item)
    {
        setBigDecimal("gdjzPro", item);
    }
    /**
     * Object:��ְҽ����������'s ���Դ����ν�����ɱ���property 
     */
    public java.math.BigDecimal getYxjzPro()
    {
        return getBigDecimal("yxjzPro");
    }
    public void setYxjzPro(java.math.BigDecimal item)
    {
        setBigDecimal("yxjzPro", item);
    }
    /**
     * Object:��ְҽ����������'s ���Դ�������ɱ���property 
     */
    public java.math.BigDecimal getZyPro()
    {
        return getBigDecimal("zyPro");
    }
    public void setZyPro(java.math.BigDecimal item)
    {
        setBigDecimal("zyPro", item);
    }
    /**
     * Object:��ְҽ����������'s ���Դ���������ɱ���property 
     */
    public java.math.BigDecimal getKnwPro()
    {
        return getBigDecimal("knwPro");
    }
    public void setKnwPro(java.math.BigDecimal item)
    {
        setBigDecimal("knwPro", item);
    }
    /**
     * Object:��ְҽ����������'s ���Դ�������ɱ���property 
     */
    public java.math.BigDecimal getMbPro()
    {
        return getBigDecimal("mbPro");
    }
    public void setMbPro(java.math.BigDecimal item)
    {
        setBigDecimal("mbPro", item);
    }
    /**
     * Object:��ְҽ����������'s ���Դ��޸���ɱ���property 
     */
    public java.math.BigDecimal getZfPro()
    {
        return getBigDecimal("zfPro");
    }
    public void setZfPro(java.math.BigDecimal item)
    {
        setBigDecimal("zfPro", item);
    }
    /**
     * Object:��ְҽ����������'s ���Դ�������ɱ���property 
     */
    public java.math.BigDecimal getEyPro()
    {
        return getBigDecimal("eyPro");
    }
    public void setEyPro(java.math.BigDecimal item)
    {
        setBigDecimal("eyPro", item);
    }
    /**
     * Object:��ְҽ����������'s ҽ������property 
     */
    public String getDocName()
    {
        return getString("docName");
    }
    public void setDocName(String item)
    {
        setString("docName", item);
    }
    /**
     * Object:��ְҽ����������'s ���б���property 
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
     * Object:��ְҽ����������'s ��������property 
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
     * Object: ��ְҽ���������� 's ���� property 
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
     * Object:��ְҽ����������'s ҵ���ڼ�property 
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
        return new BOSObjectType("9E09AB87");
    }
}