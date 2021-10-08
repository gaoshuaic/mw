package com.kingdee.eas.mw.pay;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractDoctorRelationInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractDoctorRelationInfo()
    {
        this("id");
    }
    protected AbstractDoctorRelationInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object:ҽ������ѯ�������Ӧ��ϵ's ҽ��/��ѯ����property 
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
     * Object:ҽ������ѯ�������Ӧ��ϵ's ҽ��/��ѯ����property 
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
     * Object:ҽ������ѯ�������Ӧ��ϵ's ��������property 
     */
    public com.kingdee.eas.mw.pay.app.assType getAssType()
    {
        return com.kingdee.eas.mw.pay.app.assType.getEnum(getString("assType"));
    }
    public void setAssType(com.kingdee.eas.mw.pay.app.assType item)
    {
		if (item != null) {
        setString("assType", item.getValue());
		}
    }
    /**
     * Object:ҽ������ѯ�������Ӧ��ϵ's �������property 
     */
    public String getAssNumber()
    {
        return getString("assNumber");
    }
    public void setAssNumber(String item)
    {
        setString("assNumber", item);
    }
    /**
     * Object:ҽ������ѯ�������Ӧ��ϵ's ��������property 
     */
    public String getAssName()
    {
        return getString("assName");
    }
    public void setAssName(String item)
    {
        setString("assName", item);
    }
    /**
     * Object:ҽ������ѯ�������Ӧ��ϵ's ҵ������(����)property 
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
     * Object:ҽ������ѯ�������Ӧ��ϵ's ��עproperty 
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
     * Object:ҽ������ѯ�������Ӧ��ϵ's ��������property 
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
     * Object:ҽ������ѯ�������Ӧ��ϵ's ҽ����ռ����property 
     */
    public java.math.BigDecimal getBili()
    {
        return getBigDecimal("bili");
    }
    public void setBili(java.math.BigDecimal item)
    {
        setBigDecimal("bili", item);
    }
    /**
     * Object: ҽ������ѯ�������Ӧ��ϵ 's ���� property 
     */
    public com.kingdee.eas.basedata.org.CtrlUnitInfo getCity()
    {
        return (com.kingdee.eas.basedata.org.CtrlUnitInfo)get("city");
    }
    public void setCity(com.kingdee.eas.basedata.org.CtrlUnitInfo item)
    {
        put("city", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("E851A3ED");
    }
}