package com.kingdee.eas.mw.srqr;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractSaleIssueHisLogInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractSaleIssueHisLogInfo()
    {
        this("id");
    }
    protected AbstractSaleIssueHisLogInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.mw.srqr.SaleIssueHisLogEntryCollection());
    }
    /**
     * Object: 销售出库HIS记录 's 分录 property 
     */
    public com.kingdee.eas.mw.srqr.SaleIssueHisLogEntryCollection getEntrys()
    {
        return (com.kingdee.eas.mw.srqr.SaleIssueHisLogEntryCollection)get("entrys");
    }
    /**
     * Object:销售出库HIS记录's 是否生成凭证property 
     */
    public boolean isFivouchered()
    {
        return getBoolean("Fivouchered");
    }
    public void setFivouchered(boolean item)
    {
        setBoolean("Fivouchered", item);
    }
    /**
     * Object:销售出库HIS记录's 销售出库单号property 
     */
    public String getIssNumber()
    {
        return getString("IssNumber");
    }
    public void setIssNumber(String item)
    {
        setString("IssNumber", item);
    }
    /**
     * Object:销售出库HIS记录's 财务组织IDproperty 
     */
    public String getCompanyID()
    {
        return getString("CompanyID");
    }
    public void setCompanyID(String item)
    {
        setString("CompanyID", item);
    }
    /**
     * Object:销售出库HIS记录's his请求IDproperty 
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
     * Object:销售出库HIS记录's 业务年度property 
     */
    public int getYear()
    {
        return getInt("year");
    }
    public void setYear(int item)
    {
        setInt("year", item);
    }
    /**
     * Object:销售出库HIS记录's 业务期间property 
     */
    public int getPeriod()
    {
        return getInt("period");
    }
    public void setPeriod(int item)
    {
        setInt("period", item);
    }
    /**
     * Object:销售出库HIS记录's 销售出库单IDproperty 
     */
    public String getIssID()
    {
        return getString("IssID");
    }
    public void setIssID(String item)
    {
        setString("IssID", item);
    }
    /**
     * Object:销售出库HIS记录's 同步状态property 
     */
    public com.kingdee.eas.mw.srqr.app.syncStatus getSyncStatus()
    {
        return com.kingdee.eas.mw.srqr.app.syncStatus.getEnum(getString("syncStatus"));
    }
    public void setSyncStatus(com.kingdee.eas.mw.srqr.app.syncStatus item)
    {
		if (item != null) {
        setString("syncStatus", item.getValue());
		}
    }
    /**
     * Object:销售出库HIS记录's 单据状态property 
     */
    public com.kingdee.eas.mw.srqr.app.status getStatus()
    {
        return com.kingdee.eas.mw.srqr.app.status.getEnum(getString("status"));
    }
    public void setStatus(com.kingdee.eas.mw.srqr.app.status item)
    {
		if (item != null) {
        setString("status", item.getValue());
		}
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("EE852308");
    }
}