package com.kingdee.eas.mw.srqr;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractCostCenterE1Info extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractCostCenterE1Info()
    {
        this("id");
    }
    protected AbstractCostCenterE1Info(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 第1个表体 's null property 
     */
    public com.kingdee.eas.mw.srqr.CostCenterInfo getParent()
    {
        return (com.kingdee.eas.mw.srqr.CostCenterInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.mw.srqr.CostCenterInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: 第1个表体 's 人员类别 property 
     */
    public com.kingdee.eas.hr.base.EmployeeTypeInfo getEmpType()
    {
        return (com.kingdee.eas.hr.base.EmployeeTypeInfo)get("empType");
    }
    public void setEmpType(com.kingdee.eas.hr.base.EmployeeTypeInfo item)
    {
        put("empType", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("4685B7CA");
    }
}