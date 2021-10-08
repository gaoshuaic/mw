package com.kingdee.eas.mw.srqr;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractClinicItemInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractClinicItemInfo()
    {
        this("id");
    }
    protected AbstractClinicItemInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.mw.srqr.ClinicItemEntryCollection());
    }
    /**
     * Object: �����շ���Ŀ 's ��¼ property 
     */
    public com.kingdee.eas.mw.srqr.ClinicItemEntryCollection getEntrys()
    {
        return (com.kingdee.eas.mw.srqr.ClinicItemEntryCollection)get("entrys");
    }
    /**
     * Object:�����շ���Ŀ's �Ƿ�����ƾ֤property 
     */
    public boolean isFivouchered()
    {
        return getBoolean("Fivouchered");
    }
    public void setFivouchered(boolean item)
    {
        setBoolean("Fivouchered", item);
    }
    /**
     * Object: �����շ���Ŀ 's ���� property 
     */
    public com.kingdee.eas.basedata.org.CompanyOrgUnitInfo getClinic()
    {
        return (com.kingdee.eas.basedata.org.CompanyOrgUnitInfo)get("clinic");
    }
    public void setClinic(com.kingdee.eas.basedata.org.CompanyOrgUnitInfo item)
    {
        put("clinic", item);
    }
    /**
     * Object:�����շ���Ŀ's ��������property 
     */
    public String getProject()
    {
        return getString("project");
    }
    public void setProject(String item)
    {
        setString("project", item);
    }
    /**
     * Object: �����շ���Ŀ 's �����շ���Ŀ property 
     */
    public com.kingdee.eas.mw.srqr.PaytypeitemInfo getItemType()
    {
        return (com.kingdee.eas.mw.srqr.PaytypeitemInfo)get("itemType");
    }
    public void setItemType(com.kingdee.eas.mw.srqr.PaytypeitemInfo item)
    {
        put("itemType", item);
    }
    /**
     * Object: �����շ���Ŀ 's ���� property 
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
        return new BOSObjectType("EDB11C57");
    }
}