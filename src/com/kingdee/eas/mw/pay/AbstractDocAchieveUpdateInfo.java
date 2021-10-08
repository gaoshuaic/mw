package com.kingdee.eas.mw.pay;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractDocAchieveUpdateInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractDocAchieveUpdateInfo()
    {
        this("id");
    }
    protected AbstractDocAchieveUpdateInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object:ҽ��ҵ������'s ҽ������property 
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
     * Object:ҽ��ҵ������'s ҽ������property 
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
     * Object:ҽ��ҵ������'s ҵ���ڼ�(����)property 
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
     * Object:ҽ��ҵ������'s ��ֲҵ��property 
     */
    public java.math.BigDecimal getZzAchieve()
    {
        return getBigDecimal("zzAchieve");
    }
    public void setZzAchieve(java.math.BigDecimal item)
    {
        setBigDecimal("zzAchieve", item);
    }
    /**
     * Object:ҽ��ҵ������'s ���ν���ҵ��property 
     */
    public java.math.BigDecimal getYxjzAchieve()
    {
        return getBigDecimal("yxjzAchieve");
    }
    public void setYxjzAchieve(java.math.BigDecimal item)
    {
        setBigDecimal("yxjzAchieve", item);
    }
    /**
     * Object:ҽ��ҵ������'s �̶�����ҵ��property 
     */
    public java.math.BigDecimal getGdjzAchieve()
    {
        return getBigDecimal("gdjzAchieve");
    }
    public void setGdjzAchieve(java.math.BigDecimal item)
    {
        setBigDecimal("gdjzAchieve", item);
    }
    /**
     * Object:ҽ��ҵ������'s ������ҵ��property 
     */
    public java.math.BigDecimal getKnwAchieve()
    {
        return getBigDecimal("knwAchieve");
    }
    public void setKnwAchieve(java.math.BigDecimal item)
    {
        setBigDecimal("knwAchieve", item);
    }
    /**
     * Object:ҽ��ҵ������'s �޸�ҵ��property 
     */
    public java.math.BigDecimal getXfAchieve()
    {
        return getBigDecimal("xfAchieve");
    }
    public void setXfAchieve(java.math.BigDecimal item)
    {
        setBigDecimal("xfAchieve", item);
    }
    /**
     * Object:ҽ��ҵ������'s ����ҵ��property 
     */
    public java.math.BigDecimal getEyAchieve()
    {
        return getBigDecimal("eyAchieve");
    }
    public void setEyAchieve(java.math.BigDecimal item)
    {
        setBigDecimal("eyAchieve", item);
    }
    /**
     * Object:ҽ��ҵ������'s ����ҵ��property 
     */
    public java.math.BigDecimal getYzAchieve()
    {
        return getBigDecimal("yzAchieve");
    }
    public void setYzAchieve(java.math.BigDecimal item)
    {
        setBigDecimal("yzAchieve", item);
    }
    /**
     * Object:ҽ��ҵ������'s �ϼ�property 
     */
    public java.math.BigDecimal getAllAchieve()
    {
        return getBigDecimal("allAchieve");
    }
    public void setAllAchieve(java.math.BigDecimal item)
    {
        setBigDecimal("allAchieve", item);
    }
    /**
     * Object:ҽ��ҵ������'s ���𲹲�property 
     */
    public java.math.BigDecimal getJzmoney()
    {
        return getBigDecimal("jzmoney");
    }
    public void setJzmoney(java.math.BigDecimal item)
    {
        setBigDecimal("jzmoney", item);
    }
    /**
     * Object:ҽ��ҵ������'s �������property 
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
     * Object:ҽ��ҵ������'s ��������property 
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
     * Object:ҽ��ҵ������'s ����ҵ��property 
     */
    public java.math.BigDecimal getMbAchieve()
    {
        return getBigDecimal("mbAchieve");
    }
    public void setMbAchieve(java.math.BigDecimal item)
    {
        setBigDecimal("mbAchieve", item);
    }
    /**
     * Object:ҽ��ҵ������'s ���б���property 
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
     * Object:ҽ��ҵ������'s ��������property 
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
     * Object: ҽ��ҵ������ 's ���� property 
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
     * Object:ҽ��ҵ������'s �Ƿ��Դ�property 
     */
    public boolean isIszidai()
    {
        return getBoolean("iszidai");
    }
    public void setIszidai(boolean item)
    {
        setBoolean("iszidai", item);
    }
    /**
     * Object: ҽ��ҵ������ 's ���� property 
     */
    public com.kingdee.eas.basedata.org.CompanyOrgUnitInfo getClinic()
    {
        return (com.kingdee.eas.basedata.org.CompanyOrgUnitInfo)get("clinic");
    }
    public void setClinic(com.kingdee.eas.basedata.org.CompanyOrgUnitInfo item)
    {
        put("clinic", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("09907354");
    }
}