/**
 * output package name
 */
package com.kingdee.eas.mw.pay.app;

import java.util.Map;
import java.util.List;
import java.util.Iterator;
import com.kingdee.util.enums.StringEnum;

/**
 * output class name
 */
public class clinicSizeType extends StringEnum
{
    public static final String DD_VALUE = "dd";//alias=´óµê
    public static final String ZD_VALUE = "zd";//alias=ÖÐµê
    public static final String XD_VALUE = "xd";//alias=Ð¡µê

    public static final clinicSizeType dd = new clinicSizeType("dd", DD_VALUE);
    public static final clinicSizeType zd = new clinicSizeType("zd", ZD_VALUE);
    public static final clinicSizeType xd = new clinicSizeType("xd", XD_VALUE);

    /**
     * construct function
     * @param String clinicSizeType
     */
    private clinicSizeType(String name, String clinicSizeType)
    {
        super(name, clinicSizeType);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static clinicSizeType getEnum(String clinicSizeType)
    {
        return (clinicSizeType)getEnum(clinicSizeType.class, clinicSizeType);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(clinicSizeType.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(clinicSizeType.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(clinicSizeType.class);
    }
}