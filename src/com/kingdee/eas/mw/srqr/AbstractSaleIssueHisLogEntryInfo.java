package com.kingdee.eas.mw.srqr;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractSaleIssueHisLogEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractSaleIssueHisLogEntryInfo()
    {
        this("id");
    }
    protected AbstractSaleIssueHisLogEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 分录 's 单据头 property 
     */
    public com.kingdee.eas.mw.srqr.SaleIssueHisLogInfo getParent()
    {
        return (com.kingdee.eas.mw.srqr.SaleIssueHisLogInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.mw.srqr.SaleIssueHisLogInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:分录's 数量property 
     */
    public java.math.BigDecimal getQty()
    {
        return getBigDecimal("qty");
    }
    public void setQty(java.math.BigDecimal item)
    {
        setBigDecimal("qty", item);
    }
    /**
     * Object:分录's 金额property 
     */
    public java.math.BigDecimal getAmount()
    {
        return getBigDecimal("amount");
    }
    public void setAmount(java.math.BigDecimal item)
    {
        setBigDecimal("amount", item);
    }
    /**
     * Object:分录's HIS收费项目明细property 
     */
    public String getHISPayItem()
    {
        return getString("HISPayItem");
    }
    public void setHISPayItem(String item)
    {
        setString("HISPayItem", item);
    }
    /**
     * Object:分录's his请求明细IDproperty 
     */
    public String getHISID()
    {
        return getString("HISID");
    }
    public void setHISID(String item)
    {
        setString("HISID", item);
    }
    /**
     * Object:分录's 销售出库单分录idproperty 
     */
    public String getIssEntryID()
    {
        return getString("IssEntryID");
    }
    public void setIssEntryID(String item)
    {
        setString("IssEntryID", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("27DF9A4A");
    }
}