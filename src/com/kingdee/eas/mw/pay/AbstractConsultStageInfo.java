package com.kingdee.eas.mw.pay;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractConsultStageInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractConsultStageInfo()
    {
        this("id");
    }
    protected AbstractConsultStageInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: ��ѯ�׶����� 's ���� property 
     */
    public com.kingdee.eas.basedata.org.AdminOrgUnitInfo getCity()
    {
        return (com.kingdee.eas.basedata.org.AdminOrgUnitInfo)get("city");
    }
    public void setCity(com.kingdee.eas.basedata.org.AdminOrgUnitInfo item)
    {
        put("city", item);
    }
    /**
     * Object:��ѯ�׶�����'s ҵ���ڼ�property 
     */
    public String getBusinessDate()
    {
        return getString("BusinessDate");
    }
    public void setBusinessDate(String item)
    {
        setString("BusinessDate", item);
    }
    /**
     * Object: ��ѯ�׶����� 's ��ѯ���� property 
     */
    public com.kingdee.eas.mw.pay.ConsultTypeInfo getType()
    {
        return (com.kingdee.eas.mw.pay.ConsultTypeInfo)get("type");
    }
    public void setType(com.kingdee.eas.mw.pay.ConsultTypeInfo item)
    {
        put("type", item);
    }
    /**
     * Object:��ѯ�׶�����'s ��ʼ�׶ν��property 
     */
    public java.math.BigDecimal getBeginAmount()
    {
        return getBigDecimal("beginAmount");
    }
    public void setBeginAmount(java.math.BigDecimal item)
    {
        setBigDecimal("beginAmount", item);
    }
    /**
     * Object:��ѯ�׶�����'s �����׶ν��property 
     */
    public java.math.BigDecimal getEndAmount()
    {
        return getBigDecimal("endAmount");
    }
    public void setEndAmount(java.math.BigDecimal item)
    {
        setBigDecimal("endAmount", item);
    }
    /**
     * Object:��ѯ�׶�����'s �׶α���property 
     */
    public java.math.BigDecimal getPro()
    {
        return getBigDecimal("pro");
    }
    public void setPro(java.math.BigDecimal item)
    {
        setBigDecimal("pro", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("5659F2A4");
    }
}