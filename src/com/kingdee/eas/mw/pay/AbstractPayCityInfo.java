package com.kingdee.eas.mw.pay;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractPayCityInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractPayCityInfo()
    {
        this("id");
    }
    protected AbstractPayCityInfo(String pkField)
    {
        super(pkField);
        put("Entry", new com.kingdee.eas.mw.pay.PayCityEntryCollection());
    }
    /**
     * Object:н��ͳ�Ƴ���'s ����property 
     */
    public com.kingdee.eas.mw.pay.app.CityComRule getRule()
    {
        return com.kingdee.eas.mw.pay.app.CityComRule.getEnum(getString("rule"));
    }
    public void setRule(com.kingdee.eas.mw.pay.app.CityComRule item)
    {
		if (item != null) {
        setString("rule", item.getValue());
		}
    }
    /**
     * Object: н��ͳ�Ƴ��� 's ��1������ property 
     */
    public com.kingdee.eas.mw.pay.PayCityEntryCollection getEntry()
    {
        return (com.kingdee.eas.mw.pay.PayCityEntryCollection)get("Entry");
    }
    /**
     * Object: н��ͳ�Ƴ��� 's ���� property 
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
     * Object:н��ͳ�Ƴ���'s �Ƿ����ɳɱ�property 
     */
    public boolean isIsCreateCost()
    {
        return getBoolean("isCreateCost");
    }
    public void setIsCreateCost(boolean item)
    {
        setBoolean("isCreateCost", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("F5B0CAC1");
    }
}