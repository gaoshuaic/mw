package com.kingdee.eas.mw.srqr;

import java.io.Serializable;

public class ItemCheckEntryInfo extends AbstractItemCheckEntryInfo implements Serializable 
{
    public ItemCheckEntryInfo()
    {
        super();
    }
    protected ItemCheckEntryInfo(String pkField)
    {
        super(pkField);
    }
}