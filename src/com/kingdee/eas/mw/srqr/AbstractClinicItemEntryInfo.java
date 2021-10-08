package com.kingdee.eas.mw.srqr;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractClinicItemEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractClinicItemEntryInfo()
    {
        this("id");
    }
    protected AbstractClinicItemEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 分录 's 单据头 property 
     */
    public com.kingdee.eas.mw.srqr.ClinicItemInfo getParent()
    {
        return (com.kingdee.eas.mw.srqr.ClinicItemInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.mw.srqr.ClinicItemInfo item)
    {
        put("parent", item);
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
        return new BOSObjectType("59161A5B");
    }
}