package com.kingdee.eas.mw.srqr;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractFreeItemCheckTreeInfo extends com.kingdee.eas.framework.TreeBaseInfo implements Serializable 
{
    public AbstractFreeItemCheckTreeInfo()
    {
        this("id");
    }
    protected AbstractFreeItemCheckTreeInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 收费项目选择组别 's 父节点 property 
     */
    public com.kingdee.eas.mw.srqr.FreeItemCheckTreeInfo getParent()
    {
        return (com.kingdee.eas.mw.srqr.FreeItemCheckTreeInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.mw.srqr.FreeItemCheckTreeInfo item)
    {
        put("parent", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("6D8D942B");
    }
}