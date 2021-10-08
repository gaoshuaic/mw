package com.kingdee.eas.mw.srqr;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractPayItemInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractPayItemInfo()
    {
        this("id");
    }
    protected AbstractPayItemInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 收费项目 's 二级分类 property 
     */
    public com.kingdee.eas.mw.srqr.PaytypeitemInfo getSecondClass()
    {
        return (com.kingdee.eas.mw.srqr.PaytypeitemInfo)get("secondClass");
    }
    public void setSecondClass(com.kingdee.eas.mw.srqr.PaytypeitemInfo item)
    {
        put("secondClass", item);
    }
    /**
     * Object:收费项目's 状态property 
     */
    public com.kingdee.eas.mw.srqr.app.ItemStatusEnum getStatus()
    {
        return com.kingdee.eas.mw.srqr.app.ItemStatusEnum.getEnum(getString("Status"));
    }
    public void setStatus(com.kingdee.eas.mw.srqr.app.ItemStatusEnum item)
    {
		if (item != null) {
        setString("Status", item.getValue());
		}
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("2B2E091F");
    }
}