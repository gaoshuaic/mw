package com.kingdee.eas.mw.srqr;

import java.io.Serializable;

public class PostTypeInfo extends AbstractPostTypeInfo implements Serializable 
{
    public PostTypeInfo()
    {
        super();
    }
    protected PostTypeInfo(String pkField)
    {
        super(pkField);
    }
}