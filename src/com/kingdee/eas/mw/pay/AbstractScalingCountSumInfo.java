package com.kingdee.eas.mw.pay;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractScalingCountSumInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractScalingCountSumInfo()
    {
        this("id");
    }
    protected AbstractScalingCountSumInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object:������������'s ���б���property 
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
     * Object:������������'s ��������property 
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
     * Object:������������'s �������property 
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
     * Object:������������'s ��������property 
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
     * Object:������������'s Ա������property 
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
     * Object:������������'s Ա������property 
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
     * Object:������������'s ҵ���ڼ�property 
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
     * Object:������������'s ��λproperty 
     */
    public com.kingdee.eas.mw.pay.app.PaypostType getPost()
    {
        return com.kingdee.eas.mw.pay.app.PaypostType.getEnum(getString("post"));
    }
    public void setPost(com.kingdee.eas.mw.pay.app.PaypostType item)
    {
		if (item != null) {
        setString("post", item.getValue());
		}
    }
    /**
     * Object:������������'s ��λ����property 
     */
    public String getPostName()
    {
        return getString("postName");
    }
    public void setPostName(String item)
    {
        setString("postName", item);
    }
    /**
     * Object:������������'s ϵͳͳ�ƴ���property 
     */
    public java.math.BigDecimal getXtCount()
    {
        return getBigDecimal("xtCount");
    }
    public void setXtCount(java.math.BigDecimal item)
    {
        setBigDecimal("xtCount", item);
    }
    /**
     * Object:������������'s �������property 
     */
    public java.math.BigDecimal getImpCount()
    {
        return getBigDecimal("impCount");
    }
    public void setImpCount(java.math.BigDecimal item)
    {
        setBigDecimal("impCount", item);
    }
    /**
     * Object:������������'s ���ܴ���property 
     */
    public java.math.BigDecimal getAllCount()
    {
        return getBigDecimal("allCount");
    }
    public void setAllCount(java.math.BigDecimal item)
    {
        setBigDecimal("allCount", item);
    }
    /**
     * Object: ������������ 's �������� property 
     */
    public com.kingdee.eas.mw.pay.ScalingTypeInfo getType()
    {
        return (com.kingdee.eas.mw.pay.ScalingTypeInfo)get("type");
    }
    public void setType(com.kingdee.eas.mw.pay.ScalingTypeInfo item)
    {
        put("type", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("847C41F1");
    }
}