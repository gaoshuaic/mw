package com.kingdee.eas.mw.srqr;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractItemCheckEntrythiInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractItemCheckEntrythiInfo()
    {
        this("id");
    }
    protected AbstractItemCheckEntrythiInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 收费项分录 's null property 
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
     * Object: 收费项分录 's 收费项目 property 
     */
    public com.kingdee.eas.mw.srqr.PayItemInfo getItem()
    {
        return (com.kingdee.eas.mw.srqr.PayItemInfo)get("item");
    }
    public void setItem(com.kingdee.eas.mw.srqr.PayItemInfo item)
    {
        put("item", item);
    }
    /**
     * Object:收费项分录's 类型property 
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
        return new BOSObjectType("A3CF0FDC");
    }
}