package com.kingdee.eas.mw.pay;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractDoctorPerformanceInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractDoctorPerformanceInfo()
    {
        this("id");
    }
    protected AbstractDoctorPerformanceInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object:ҽ��ҵ�����̶�����'s �������property 
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
     * Object:ҽ��ҵ�����̶�����'s ��������property 
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
     * Object:ҽ��ҵ�����̶�����'s Ա������property 
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
     * Object:ҽ��ҵ�����̶�����'s Ա������property 
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
     * Object:ҽ��ҵ�����̶�����'s ��ֲ����property 
     */
    public java.math.BigDecimal getZzProportion()
    {
        return getBigDecimal("zzProportion");
    }
    public void setZzProportion(java.math.BigDecimal item)
    {
        setBigDecimal("zzProportion", item);
    }
    /**
     * Object:ҽ��ҵ�����̶�����'s ҵ������property 
     */
    public java.math.BigDecimal getPerformanceBase()
    {
        return getBigDecimal("performanceBase");
    }
    public void setPerformanceBase(java.math.BigDecimal item)
    {
        setBigDecimal("performanceBase", item);
    }
    /**
     * Object:ҽ��ҵ�����̶�����'s ��ֲҵ��property 
     */
    public java.math.BigDecimal getZzBase()
    {
        return getBigDecimal("zzBase");
    }
    public void setZzBase(java.math.BigDecimal item)
    {
        setBigDecimal("zzBase", item);
    }
    /**
     * Object:ҽ��ҵ�����̶�����'s �̶���������property 
     */
    public java.math.BigDecimal getGdProportion()
    {
        return getBigDecimal("gdProportion");
    }
    public void setGdProportion(java.math.BigDecimal item)
    {
        setBigDecimal("gdProportion", item);
    }
    /**
     * Object:ҽ��ҵ�����̶�����'s �̶�����ҵ��property 
     */
    public java.math.BigDecimal getGdBase()
    {
        return getBigDecimal("gdBase");
    }
    public void setGdBase(java.math.BigDecimal item)
    {
        setBigDecimal("gdBase", item);
    }
    /**
     * Object:ҽ��ҵ�����̶�����'s ���ν�������property 
     */
    public java.math.BigDecimal getYxProportion()
    {
        return getBigDecimal("yxProportion");
    }
    public void setYxProportion(java.math.BigDecimal item)
    {
        setBigDecimal("yxProportion", item);
    }
    /**
     * Object:ҽ��ҵ�����̶�����'s ���ν���ҵ��property 
     */
    public java.math.BigDecimal getYxBase()
    {
        return getBigDecimal("yxBase");
    }
    public void setYxBase(java.math.BigDecimal item)
    {
        setBigDecimal("yxBase", item);
    }
    /**
     * Object:ҽ��ҵ�����̶�����'s �޸���������property 
     */
    public java.math.BigDecimal getXfProportion()
    {
        return getBigDecimal("xfProportion");
    }
    public void setXfProportion(java.math.BigDecimal item)
    {
        setBigDecimal("xfProportion", item);
    }
    /**
     * Object:ҽ��ҵ�����̶�����'s �޸�����ҵ��property 
     */
    public java.math.BigDecimal getXfBase()
    {
        return getBigDecimal("xfBase");
    }
    public void setXfBase(java.math.BigDecimal item)
    {
        setBigDecimal("xfBase", item);
    }
    /**
     * Object:ҽ��ҵ�����̶�����'s ������������property 
     */
    public java.math.BigDecimal getEyProportion()
    {
        return getBigDecimal("eyProportion");
    }
    public void setEyProportion(java.math.BigDecimal item)
    {
        setBigDecimal("eyProportion", item);
    }
    /**
     * Object:ҽ��ҵ�����̶�����'s ��������ҵ��property 
     */
    public java.math.BigDecimal getEyBase()
    {
        return getBigDecimal("eyBase");
    }
    public void setEyBase(java.math.BigDecimal item)
    {
        setBigDecimal("eyBase", item);
    }
    /**
     * Object:ҽ��ҵ�����̶�����'s ���������property 
     */
    public java.math.BigDecimal getKnProportion()
    {
        return getBigDecimal("knProportion");
    }
    public void setKnProportion(java.math.BigDecimal item)
    {
        setBigDecimal("knProportion", item);
    }
    /**
     * Object:ҽ��ҵ�����̶�����'s ������ҵ��property 
     */
    public java.math.BigDecimal getKnBase()
    {
        return getBigDecimal("knBase");
    }
    public void setKnBase(java.math.BigDecimal item)
    {
        setBigDecimal("knBase", item);
    }
    /**
     * Object:ҽ��ҵ�����̶�����'s ���ױ���property 
     */
    public java.math.BigDecimal getMbProportion()
    {
        return getBigDecimal("mbProportion");
    }
    public void setMbProportion(java.math.BigDecimal item)
    {
        setBigDecimal("mbProportion", item);
    }
    /**
     * Object:ҽ��ҵ�����̶�����'s ����ҵ��property 
     */
    public java.math.BigDecimal getMbBase()
    {
        return getBigDecimal("mbBase");
    }
    public void setMbBase(java.math.BigDecimal item)
    {
        setBigDecimal("mbBase", item);
    }
    /**
     * Object:ҽ��ҵ�����̶�����'s �ܱ߱���property 
     */
    public java.math.BigDecimal getZbProportion()
    {
        return getBigDecimal("zbProportion");
    }
    public void setZbProportion(java.math.BigDecimal item)
    {
        setBigDecimal("zbProportion", item);
    }
    /**
     * Object:ҽ��ҵ�����̶�����'s �ܱ�ҵ��property 
     */
    public java.math.BigDecimal getZbBase()
    {
        return getBigDecimal("zbBase");
    }
    public void setZbBase(java.math.BigDecimal item)
    {
        setBigDecimal("zbBase", item);
    }
    /**
     * Object:ҽ��ҵ�����̶�����'s ��������property 
     */
    public java.math.BigDecimal getQtProportion()
    {
        return getBigDecimal("qtProportion");
    }
    public void setQtProportion(java.math.BigDecimal item)
    {
        setBigDecimal("qtProportion", item);
    }
    /**
     * Object:ҽ��ҵ�����̶�����'s ����ҵ��property 
     */
    public java.math.BigDecimal getQtBase()
    {
        return getBigDecimal("qtBase");
    }
    public void setQtBase(java.math.BigDecimal item)
    {
        setBigDecimal("qtBase", item);
    }
    /**
     * Object:ҽ��ҵ�����̶�����'s ��������property 
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
     * Object:ҽ��ҵ�����̶�����'s ҵ������(����)property 
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
     * Object:ҽ��ҵ�����̶�����'s ��������property 
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
     * Object:ҽ��ҵ�����̶�����'s ���б���property 
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
     * Object: ҽ��ҵ�����̶����� 's ���� property 
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
     * Object:ҽ��ҵ�����̶�����'s ��������property 
     */
    public java.math.BigDecimal getZjBiLi()
    {
        return getBigDecimal("zjBiLi");
    }
    public void setZjBiLi(java.math.BigDecimal item)
    {
        setBigDecimal("zjBiLi", item);
    }
    /**
     * Object:ҽ��ҵ�����̶�����'s ҽ��Ԥ������property 
     */
    public com.kingdee.eas.mw.pay.app.DocKeepType getDocKeepType()
    {
        return com.kingdee.eas.mw.pay.app.DocKeepType.getEnum(getString("docKeepType"));
    }
    public void setDocKeepType(com.kingdee.eas.mw.pay.app.DocKeepType item)
    {
		if (item != null) {
        setString("docKeepType", item.getValue());
		}
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("9286549F");
    }
}