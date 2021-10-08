package com.kingdee.eas.mw.pay;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractConsultTypeInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractConsultTypeInfo()
    {
        this("id");
    }
    protected AbstractConsultTypeInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: ��ѯ���� 's ���� property 
     */
    public com.kingdee.eas.basedata.org.CompanyOrgUnitInfo getCity()
    {
        return (com.kingdee.eas.basedata.org.CompanyOrgUnitInfo)get("city");
    }
    public void setCity(com.kingdee.eas.basedata.org.CompanyOrgUnitInfo item)
    {
        put("city", item);
    }
    /**
     * Object:��ѯ����'s ��ѯ���ͱ���property 
     */
    public String getZxNumber()
    {
        return getString("zxNumber");
    }
    public void setZxNumber(String item)
    {
        setString("zxNumber", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("1B8FD2D4");
    }
}