package com.kingdee.eas.mw.srqr;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractStaffCityCostRelevanceInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractStaffCityCostRelevanceInfo()
    {
        this("id");
    }
    protected AbstractStaffCityCostRelevanceInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: ��Ա���гɱ����Ĺ����� 's ��Ա property 
     */
    public com.kingdee.eas.basedata.person.PersonInfo getPerson()
    {
        return (com.kingdee.eas.basedata.person.PersonInfo)get("Person");
    }
    public void setPerson(com.kingdee.eas.basedata.person.PersonInfo item)
    {
        put("Person", item);
    }
    /**
     * Object: ��Ա���гɱ����Ĺ����� 's ��λ��� property 
     */
    public com.kingdee.eas.mw.srqr.PostTypeInfo getPostType()
    {
        return (com.kingdee.eas.mw.srqr.PostTypeInfo)get("PostType");
    }
    public void setPostType(com.kingdee.eas.mw.srqr.PostTypeInfo item)
    {
        put("PostType", item);
    }
    /**
     * Object: ��Ա���гɱ����Ĺ����� 's ���� property 
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
     * Object:��Ա���гɱ����Ĺ�����'s �ڼ�property 
     */
    public String getPeriod()
    {
        return getString("period");
    }
    public void setPeriod(String item)
    {
        setString("period", item);
    }
    /**
     * Object: ��Ա���гɱ����Ĺ����� 's �ɱ����� property 
     */
    public com.kingdee.eas.mw.srqr.CostCenterInfo getCostCenter()
    {
        return (com.kingdee.eas.mw.srqr.CostCenterInfo)get("CostCenter");
    }
    public void setCostCenter(com.kingdee.eas.mw.srqr.CostCenterInfo item)
    {
        put("CostCenter", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("2D427D9D");
    }
}