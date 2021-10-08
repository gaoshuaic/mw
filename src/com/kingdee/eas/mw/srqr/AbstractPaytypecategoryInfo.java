package com.kingdee.eas.mw.srqr;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractPaytypecategoryInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractPaytypecategoryInfo()
    {
        this("id");
    }
    protected AbstractPaytypecategoryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object:一级分类's 主业务分类property 
     */
    public String getMiancalss()
    {
        return getString("miancalss");
    }
    public void setMiancalss(String item)
    {
        setString("miancalss", item);
    }
    /**
     * Object:一级分类's 状态property 
     */
    public com.kingdee.eas.mw.srqr.app.ItemStatusEnum getStatus()
    {
        return com.kingdee.eas.mw.srqr.app.ItemStatusEnum.getEnum(getString("status"));
    }
    public void setStatus(com.kingdee.eas.mw.srqr.app.ItemStatusEnum item)
    {
		if (item != null) {
        setString("status", item.getValue());
		}
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("8CB3E024");
    }
}