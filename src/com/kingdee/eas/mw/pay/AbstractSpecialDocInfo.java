package com.kingdee.eas.mw.pay;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractSpecialDocInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractSpecialDocInfo()
    {
        this("id");
    }
    protected AbstractSpecialDocInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object:�ض�ҽ��'s ҽ������property 
     */
    public String getDocNumber()
    {
        return getString("docNumber");
    }
    public void setDocNumber(String item)
    {
        setString("docNumber", item);
    }
    /**
     * Object:�ض�ҽ��'s ҽ������property 
     */
    public String getDocName()
    {
        return getString("docName");
    }
    public void setDocName(String item)
    {
        setString("docName", item);
    }
    /**
     * Object:�ض�ҽ��'s ���б���property 
     */
    public String getCityNumber()
    {
        return getString("cityNumber");
    }
    public void setCityNumber(String item)
    {
        setString("cityNumber", item);
    }
    /**
     * Object:�ض�ҽ��'s ��������property 
     */
    public String getCityName()
    {
        return getString("cityName");
    }
    public void setCityName(String item)
    {
        setString("cityName", item);
    }
    /**
     * Object: �ض�ҽ�� 's ���� property 
     */
    public com.kingdee.eas.basedata.org.CtrlUnitInfo getCity()
    {
        return (com.kingdee.eas.basedata.org.CtrlUnitInfo)get("city");
    }
    public void setCity(com.kingdee.eas.basedata.org.CtrlUnitInfo item)
    {
        put("city", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("5378D271");
    }
}