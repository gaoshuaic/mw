package com.kingdee.eas.mw.srqr;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractItemCityInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractItemCityInfo()
    {
        this("id");
    }
    protected AbstractItemCityInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object:�շ���Ŀ����'s �������property 
     */
    public String getClinicNumber()
    {
        return getString("clinicNumber");
    }
    public void setClinicNumber(String item)
    {
        setString("clinicNumber", item);
    }
    /**
     * Object:�շ���Ŀ����'s ����property 
     */
    public String getCity()
    {
        return getString("city");
    }
    public void setCity(String item)
    {
        setString("city", item);
    }
    /**
     * Object:�շ���Ŀ����'s �շ���Ŀproperty 
     */
    public String getItem()
    {
        return getString("item");
    }
    public void setItem(String item)
    {
        setString("item", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("3045725A");
    }
}