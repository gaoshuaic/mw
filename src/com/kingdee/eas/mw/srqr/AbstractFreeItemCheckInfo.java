package com.kingdee.eas.mw.srqr;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractFreeItemCheckInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractFreeItemCheckInfo()
    {
        this("id");
    }
    protected AbstractFreeItemCheckInfo(String pkField)
    {
        super(pkField);
        put("Entry", new com.kingdee.eas.mw.srqr.FreeItemCheckEntryCollection());
    }
    /**
     * Object: �շ���Ŀѡ������ 's ��� property 
     */
    public com.kingdee.eas.mw.srqr.FreeItemCheckTreeInfo getTreeid()
    {
        return (com.kingdee.eas.mw.srqr.FreeItemCheckTreeInfo)get("treeid");
    }
    public void setTreeid(com.kingdee.eas.mw.srqr.FreeItemCheckTreeInfo item)
    {
        put("treeid", item);
    }
    /**
     * Object: �շ���Ŀѡ������ 's ��¼ property 
     */
    public com.kingdee.eas.mw.srqr.FreeItemCheckEntryCollection getEntry()
    {
        return (com.kingdee.eas.mw.srqr.FreeItemCheckEntryCollection)get("Entry");
    }
    /**
     * Object: �շ���Ŀѡ������ 's ���� property 
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
     * Object:�շ���Ŀѡ������'s ��Ŀ����property 
     */
    public String getTypeNumber()
    {
        return getString("typeNumber");
    }
    public void setTypeNumber(String item)
    {
        setString("typeNumber", item);
    }
    /**
     * Object:�շ���Ŀѡ������'s ��������property 
     */
    public String getTypename()
    {
        return getString("typename");
    }
    public void setTypename(String item)
    {
        setString("typename", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("9DDEEAED");
    }
}