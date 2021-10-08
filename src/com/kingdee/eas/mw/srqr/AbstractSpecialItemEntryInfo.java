package com.kingdee.eas.mw.srqr;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractSpecialItemEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractSpecialItemEntryInfo()
    {
        this("id");
    }
    protected AbstractSpecialItemEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 分录 's 单据头 property 
     */
    public com.kingdee.eas.mw.srqr.SpecialItemInfo getParent()
    {
        return (com.kingdee.eas.mw.srqr.SpecialItemInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.mw.srqr.SpecialItemInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: 分录 's 二级收费项目 property 
     */
    public com.kingdee.eas.mw.srqr.PaytypeitemInfo getSecondItem()
    {
        return (com.kingdee.eas.mw.srqr.PaytypeitemInfo)get("secondItem");
    }
    public void setSecondItem(com.kingdee.eas.mw.srqr.PaytypeitemInfo item)
    {
        put("secondItem", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("88DFDFA2");
    }
}