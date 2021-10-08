package com.kingdee.eas.mw.srqr;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractItemCheckEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractItemCheckEntryInfo()
    {
        this("id");
    }
    protected AbstractItemCheckEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: ��¼ 's ����ͷ property 
     */
    public com.kingdee.eas.mw.srqr.ItemCheckInfo getParent()
    {
        return (com.kingdee.eas.mw.srqr.ItemCheckInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.mw.srqr.ItemCheckInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: ��¼ 's һ������ property 
     */
    public com.kingdee.eas.mw.srqr.PaytypecategoryInfo getFirstItem()
    {
        return (com.kingdee.eas.mw.srqr.PaytypecategoryInfo)get("firstItem");
    }
    public void setFirstItem(com.kingdee.eas.mw.srqr.PaytypecategoryInfo item)
    {
        put("firstItem", item);
    }
    /**
     * Object:��¼'s ����property 
     */
    public String getType()
    {
        return getString("type");
    }
    public void setType(String item)
    {
        setString("type", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("CC3041F9");
    }
}