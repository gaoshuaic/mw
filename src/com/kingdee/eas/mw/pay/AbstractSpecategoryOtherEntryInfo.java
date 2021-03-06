package com.kingdee.eas.mw.pay;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractSpecategoryOtherEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractSpecategoryOtherEntryInfo()
    {
        this("id");
    }
    protected AbstractSpecategoryOtherEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: HIS收费项目 's null property 
     */
    public com.kingdee.eas.mw.pay.SpecategoryInfo getParent()
    {
        return (com.kingdee.eas.mw.pay.SpecategoryInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.mw.pay.SpecategoryInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:HIS收费项目's 分类编码property 
     */
    public String getNumber()
    {
        return getString("number");
    }
    public void setNumber(String item)
    {
        setString("number", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("5376AA96");
    }
}