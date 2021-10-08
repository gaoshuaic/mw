package com.kingdee.eas.mw.srqr;

import java.io.Serializable;

public class ItemTypeInfo extends AbstractItemTypeInfo implements Serializable 
{
    public ItemTypeInfo()
    {
        super();
    }
    protected ItemTypeInfo(String pkField)
    {
        super(pkField);
    }
}