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
     * Object: ���۳���HIS��¼ 's ��¼ property 
     */
    public com.kingdee.eas.mw.srqr.SaleIssueHisLogEntryCollection getEntrys()
    {
        return (com.kingdee.eas.mw.srqr.SaleIssueHisLogEntryCollection)get("entrys");
    }
    /**
     * Object:���۳���HIS��¼'s �Ƿ�����ƾ֤property 
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
     * Object:���۳���HIS��¼'s ���۳��ⵥ��property 
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
     * Object:���۳���HIS��¼'s ������֯IDproperty 
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
     * Object:���۳���HIS��¼'s his����IDproperty 
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
     * Object:���۳���HIS��¼'s ҵ�����property 
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
     * Object:���۳���HIS��¼'s ҵ���ڼ�property 
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
     * Object:���۳���HIS��¼'s ���۳��ⵥIDproperty 
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
     * Object:���۳���HIS��¼'s ͬ��״̬property 
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
     * Object:���۳���HIS��¼'s ����״̬property 
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