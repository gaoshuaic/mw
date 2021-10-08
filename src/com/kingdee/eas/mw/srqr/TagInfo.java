package com.kingdee.eas.mw.srqr;

import java.io.Serializable;

public class TagInfo extends AbstractTagInfo implements Serializable 
{
    public TagInfo()
    {
        super();
    }
    protected TagInfo(String pkField)
    {
        super(pkField);
    }
}