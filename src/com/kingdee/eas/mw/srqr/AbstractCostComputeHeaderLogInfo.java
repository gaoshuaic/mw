package com.kingdee.eas.mw.srqr;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractCostComputeHeaderLogInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractCostComputeHeaderLogInfo()
    {
        this("id");
    }
    protected AbstractCostComputeHeaderLogInfo(String pkField)
    {
        super(pkField);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("F93A7229");
    }
}