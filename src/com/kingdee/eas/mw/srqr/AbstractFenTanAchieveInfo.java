package com.kingdee.eas.mw.srqr;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractFenTanAchieveInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractFenTanAchieveInfo()
    {
        this("id");
    }
    protected AbstractFenTanAchieveInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: ����ҵ������ 's ���� property 
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
     * Object: ����ҵ������ 's ��˾ property 
     */
    public com.kingdee.eas.basedata.org.CompanyOrgUnitInfo getCompany()
    {
        return (com.kingdee.eas.basedata.org.CompanyOrgUnitInfo)get("company");
    }
    public void setCompany(com.kingdee.eas.basedata.org.CompanyOrgUnitInfo item)
    {
        put("company", item);
    }
    /**
     * Object:����ҵ������'s ҵ������property 
     */
    public String getBusinessdate()
    {
        return getString("businessdate");
    }
    public void setBusinessdate(String item)
    {
        setString("businessdate", item);
    }
    /**
     * Object: ����ҵ������ 's Ա�� property 
     */
    public com.kingdee.eas.basedata.person.PersonInfo getPerson()
    {
        return (com.kingdee.eas.basedata.person.PersonInfo)get("person");
    }
    public void setPerson(com.kingdee.eas.basedata.person.PersonInfo item)
    {
        put("person", item);
    }
    /**
     * Object:����ҵ������'s ����property 
     */
    public java.math.BigDecimal getMoney()
    {
        return getBigDecimal("money");
    }
    public void setMoney(java.math.BigDecimal item)
    {
        setBigDecimal("money", item);
    }
    /**
     * Object: ����ҵ������ 's ��λ��� property 
     */
    public com.kingdee.eas.mw.srqr.PostTypeInfo getPostType()
    {
        return (com.kingdee.eas.mw.srqr.PostTypeInfo)get("postType");
    }
    public void setPostType(com.kingdee.eas.mw.srqr.PostTypeInfo item)
    {
        put("postType", item);
    }
    /**
     * Object: ����ҵ������ 's �ɱ����� property 
     */
    public com.kingdee.eas.mw.srqr.CostCenterInfo getCostCenter()
    {
        return (com.kingdee.eas.mw.srqr.CostCenterInfo)get("costCenter");
    }
    public void setCostCenter(com.kingdee.eas.mw.srqr.CostCenterInfo item)
    {
        put("costCenter", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("34BFB6A3");
    }
}