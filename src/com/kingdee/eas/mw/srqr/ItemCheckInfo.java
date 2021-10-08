package com.kingdee.eas.mw.srqr;

import java.io.Serializable;

public class ItemCheckInfo extends AbstractItemCheckInfo implements Serializable 
{
    public ItemCheckInfo()
    {
        super();
    }
    protected ItemCheckInfo(String pkField)
    {
        super(pkField);
    }
}