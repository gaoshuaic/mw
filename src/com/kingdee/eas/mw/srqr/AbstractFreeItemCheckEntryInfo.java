package com.kingdee.eas.mw.srqr;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractFreeItemCheckEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractFreeItemCheckEntryInfo()
    {
        this("id");
    }
    protected AbstractFreeItemCheckEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 分录 's null property 
     */
    public com.kingdee.eas.mw.srqr.FreeItemCheckInfo getParent()
    {
        return (com.kingdee.eas.mw.srqr.FreeItemCheckInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.mw.srqr.FreeItemCheckInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: 分录 's 一级分录 property 
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
     * Object: 分录 's 二级分类 property 
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
     * Object: 分录 's 收费项目 property 
     */
    public com.kingdee.eas.mw.srqr.PayItemInfo getItem()
    {
        return (com.kingdee.eas.mw.srqr.PayItemInfo)get("item");
    }
    public void setItem(com.kingdee.eas.mw.srqr.PayItemInfo item)
    {
        put("item", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("434FF985");
    }
}