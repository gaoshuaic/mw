package com.kingdee.eas.mw.srqr;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractItemCheckInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractItemCheckInfo()
    {
        this("id");
    }
    protected AbstractItemCheckInfo(String pkField)
    {
        super(pkField);
        put("Entrysec", new com.kingdee.eas.mw.srqr.ItemCheckEntrysecCollection());
        put("Entrythi", new com.kingdee.eas.mw.srqr.ItemCheckEntrythiCollection());
        put("entrys", new com.kingdee.eas.mw.srqr.ItemCheckEntryCollection());
    }
    /**
     * Object: 收费项目管理 's 分录 property 
     */
    public com.kingdee.eas.mw.srqr.ItemCheckEntryCollection getEntrys()
    {
        return (com.kingdee.eas.mw.srqr.ItemCheckEntryCollection)get("entrys");
    }
    /**
     * Object: 收费项目管理 's 城市 property 
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
     * Object:收费项目管理's 类型编码property 
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
     * Object:收费项目管理's 类型名称property 
     */
    public String getTypeName()
    {
        return getString("typeName");
    }
    public void setTypeName(String item)
    {
        setString("typeName", item);
    }
    /**
     * Object: 收费项目管理 's 二级分录 property 
     */
    public com.kingdee.eas.mw.srqr.ItemCheckEntrysecCollection getEntrysec()
    {
        return (com.kingdee.eas.mw.srqr.ItemCheckEntrysecCollection)get("Entrysec");
    }
    /**
     * Object: 收费项目管理 's 收费项分录 property 
     */
    public com.kingdee.eas.mw.srqr.ItemCheckEntrythiCollection getEntrythi()
    {
        return (com.kingdee.eas.mw.srqr.ItemCheckEntrythiCollection)get("Entrythi");
    }
    /**
     * Object:收费项目管理's 是否属于洁牙property 
     */
    public boolean isIsJy()
    {
        return getBoolean("isJy");
    }
    public void setIsJy(boolean item)
    {
        setBoolean("isJy", item);
    }
    /**
     * Object: 收费项目管理 's 所属洁牙类型 property 
     */
    public com.kingdee.eas.mw.pay.ScalingTypeInfo getJyType()
    {
        return (com.kingdee.eas.mw.pay.ScalingTypeInfo)get("jyType");
    }
    public void setJyType(com.kingdee.eas.mw.pay.ScalingTypeInfo item)
    {
        put("jyType", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("D86829F9");
    }
}