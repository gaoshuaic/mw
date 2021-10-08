package com.kingdee.eas.mw.pay;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractDoctorCostsInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractDoctorCostsInfo()
    {
        this("id");
    }
    protected AbstractDoctorCostsInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object:ҽ�������ɱ�'s �������property 
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
     * Object:ҽ�������ɱ�'s ��������property 
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
     * Object:ҽ�������ɱ�'s Ա������property 
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
     * Object:ҽ�������ɱ�'s Ա������property 
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
     * Object:ҽ�������ɱ�'s ҵ������property 
     */
    public java.math.BigDecimal getPerformanceBase()
    {
        return getBigDecimal("PerformanceBase");
    }
    public void setPerformanceBase(java.math.BigDecimal item)
    {
        setBigDecimal("PerformanceBase", item);
    }
    /**
     * Object:ҽ�������ɱ�'s ��ֲ�����ɱ�property 
     */
    public java.math.BigDecimal getZjCost()
    {
        return getBigDecimal("zjCost");
    }
    public void setZjCost(java.math.BigDecimal item)
    {
        setBigDecimal("zjCost", item);
    }
    /**
     * Object:ҽ�������ɱ�'s �̶����������ɱ�property 
     */
    public java.math.BigDecimal getGdCost()
    {
        return getBigDecimal("gdCost");
    }
    public void setGdCost(java.math.BigDecimal item)
    {
        setBigDecimal("gdCost", item);
    }
    /**
     * Object:ҽ�������ɱ�'s ���ν��������ɱ�property 
     */
    public java.math.BigDecimal getYxCost()
    {
        return getBigDecimal("yxCost");
    }
    public void setYxCost(java.math.BigDecimal item)
    {
        setBigDecimal("yxCost", item);
    }
    /**
     * Object:ҽ�������ɱ�'s �޸����������ɱ�property 
     */
    public java.math.BigDecimal getXfCost()
    {
        return getBigDecimal("xfCost");
    }
    public void setXfCost(java.math.BigDecimal item)
    {
        setBigDecimal("xfCost", item);
    }
    /**
     * Object:ҽ�������ɱ�'s �������������ɱ�property 
     */
    public java.math.BigDecimal getEyCost()
    {
        return getBigDecimal("eyCost");
    }
    public void setEyCost(java.math.BigDecimal item)
    {
        setBigDecimal("eyCost", item);
    }
    /**
     * Object:ҽ�������ɱ�'s ����������ɱ�property 
     */
    public java.math.BigDecimal getKnCost()
    {
        return getBigDecimal("knCost");
    }
    public void setKnCost(java.math.BigDecimal item)
    {
        setBigDecimal("knCost", item);
    }
    /**
     * Object:ҽ�������ɱ�'s ���׵����ɱ�property 
     */
    public java.math.BigDecimal getMbCost()
    {
        return getBigDecimal("mbCost");
    }
    public void setMbCost(java.math.BigDecimal item)
    {
        setBigDecimal("mbCost", item);
    }
    /**
     * Object:ҽ�������ɱ�'s �ܱߵ����ɱ�property 
     */
    public java.math.BigDecimal getZbCost()
    {
        return getBigDecimal("zbCost");
    }
    public void setZbCost(java.math.BigDecimal item)
    {
        setBigDecimal("zbCost", item);
    }
    /**
     * Object:ҽ�������ɱ�'s ���������ɱ�property 
     */
    public java.math.BigDecimal getQtCost()
    {
        return getBigDecimal("qtCost");
    }
    public void setQtCost(java.math.BigDecimal item)
    {
        setBigDecimal("qtCost", item);
    }
    /**
     * Object:ҽ�������ɱ�'s ��������property 
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
     * Object:ҽ�������ɱ�'s ҵ������(����)property 
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
     * Object:ҽ�������ɱ�'s ���б���property 
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
     * Object:ҽ�������ɱ�'s ��������property 
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
     * Object:ҽ�������ɱ�'s ��������property 
     */
    public com.kingdee.eas.mw.pay.app.costType getCostType()
    {
        return com.kingdee.eas.mw.pay.app.costType.getEnum(getString("costType"));
    }
    public void setCostType(com.kingdee.eas.mw.pay.app.costType item)
    {
		if (item != null) {
        setString("costType", item.getValue());
		}
    }
    /**
     * Object: ҽ�������ɱ� 's ���� property 
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
     * Object:ҽ�������ɱ�'s �Ƿ��Դ�property 
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
     * Object: ҽ�������ɱ� 's ���� property 
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
        return new BOSObjectType("83964DF5");
    }
}