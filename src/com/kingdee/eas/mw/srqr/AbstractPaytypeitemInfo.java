package com.kingdee.eas.mw.srqr;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractPaytypeitemInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractPaytypeitemInfo()
    {
        this("id");
    }
    protected AbstractPaytypeitemInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 二级分类 's 一级分类 property 
     */
    public com.kingdee.eas.mw.srqr.PaytypecategoryInfo getCategory()
    {
        return (com.kingdee.eas.mw.srqr.PaytypecategoryInfo)get("category");
    }
    public void setCategory(com.kingdee.eas.mw.srqr.PaytypecategoryInfo item)
    {
        put("category", item);
    }
    /**
     * Object:二级分类's 状态property 
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
        return new BOSObjectType("F28E2139");
    }
}