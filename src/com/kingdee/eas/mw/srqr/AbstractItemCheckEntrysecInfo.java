package com.kingdee.eas.mw.srqr;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractItemCheckEntrysecInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractItemCheckEntrysecInfo()
    {
        this("id");
    }
    protected AbstractItemCheckEntrysecInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 二级分录 's null property 
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
     * Object: 二级分录 's 二级分类 property 
     */
    public com.kingdee.eas.mw.srqr.PaytypeitemInfo getSecondItem()
    {
        return (com.kingdee.eas.mw.srqr.PaytypeitemInfo)get("secondItem");
    }
    public void setSecondItem(com.kingdee.eas.mw.srqr.PaytypeitemInfo item)
    {
        put("secondItem", item);
    }
    /**
     * Object:二级分录's 类型property 
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
        return new BOSObjectType("A3CF0BB8");
    }
}