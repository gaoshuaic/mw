package com.kingdee.eas.mw.pay;

import java.io.Serializable;

public class PaySheetDetailInfo extends AbstractPaySheetDetailInfo implements Serializable 
{
    public PaySheetDetailInfo()
    {
        super();
    }
    protected PaySheetDetailInfo(String pkField)
    {
        super(pkField);
    }
}