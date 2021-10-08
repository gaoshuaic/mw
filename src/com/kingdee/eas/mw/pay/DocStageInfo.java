package com.kingdee.eas.mw.pay;

import java.io.Serializable;

public class DocStageInfo extends AbstractDocStageInfo implements Serializable 
{
    public DocStageInfo()
    {
        super();
    }
    protected DocStageInfo(String pkField)
    {
        super(pkField);
    }
}