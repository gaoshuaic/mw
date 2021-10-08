package com.kingdee.eas.mw.pay;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractSpecategoryInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractSpecategoryInfo()
    {
        this("id");
    }
    protected AbstractSpecategoryInfo(String pkField)
    {
        super(pkField);
        put("AssEntrys", new com.kingdee.eas.mw.pay.SpecategoryAssEntryCollection());
        put("entrys", new com.kingdee.eas.mw.pay.SpecategoryEntryCollection());
        put("OtherEntrys", new com.kingdee.eas.mw.pay.SpecategoryOtherEntryCollection());
    }
    /**
     * Object: HR特殊分类 's HIS一级分类 property 
     */
    public com.kingdee.eas.mw.pay.SpecategoryEntryCollection getEntrys()
    {
        return (com.kingdee.eas.mw.pay.SpecategoryEntryCollection)get("entrys");
    }
    /**
     * Object: HR特殊分类 's HIS二级分类 property 
     */
    public com.kingdee.eas.mw.pay.SpecategoryAssEntryCollection getAssEntrys()
    {
        return (com.kingdee.eas.mw.pay.SpecategoryAssEntryCollection)get("AssEntrys");
    }
    /**
     * Object: HR特殊分类 's HIS收费项目 property 
     */
    public com.kingdee.eas.mw.pay.SpecategoryOtherEntryCollection getOtherEntrys()
    {
        return (com.kingdee.eas.mw.pay.SpecategoryOtherEntryCollection)get("OtherEntrys");
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("9488FC34");
    }
}