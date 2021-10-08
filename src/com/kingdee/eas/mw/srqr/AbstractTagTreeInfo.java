package com.kingdee.eas.mw.srqr;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractTagTreeInfo extends com.kingdee.eas.framework.TreeBaseInfo implements Serializable 
{
    public AbstractTagTreeInfo()
    {
        this("id");
    }
    protected AbstractTagTreeInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: Tag组别 's 父节点 property 
     */
    public com.kingdee.eas.mw.srqr.TagTreeInfo getParent()
    {
        return (com.kingdee.eas.mw.srqr.TagTreeInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.mw.srqr.TagTreeInfo item)
    {
        put("parent", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("FDCE479C");
    }
}