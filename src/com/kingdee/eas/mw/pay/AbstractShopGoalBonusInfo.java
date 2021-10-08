package com.kingdee.eas.mw.pay;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractShopGoalBonusInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractShopGoalBonusInfo()
    {
        this("id");
    }
    protected AbstractShopGoalBonusInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object:�ŵ�Ŀ�꽱��'s ����property 
     */
    public java.math.BigDecimal getMoney()
    {
        return getBigDecimal("money");
    }
    public void setMoney(java.math.BigDecimal item)
    {
        setBigDecimal("money", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("AD71DC84");
    }
}