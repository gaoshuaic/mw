package com.kingdee.eas.mw.srqr;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractTagInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractTagInfo()
    {
        this("id");
    }
    protected AbstractTagInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: ±êÇ© 's ×é±ð property 
     */
    public com.kingdee.eas.mw.srqr.TagTreeInfo getTreeid()
    {
        return (com.kingdee.eas.mw.srqr.TagTreeInfo)get("treeid");
    }
    public void setTreeid(com.kingdee.eas.mw.srqr.TagTreeInfo item)
    {
        put("treeid", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("641CFEDE");
    }
}