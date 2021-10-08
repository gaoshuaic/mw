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
public class costType extends StringEnum
{
    public static final String DZ_VALUE = "dz";//alias=µÍÖµ
    public static final String TZ_VALUE = "tz";//alias=µ÷Õû
    public static final String YK_VALUE = "yk";//alias=ÑÓ¿Û

    public static final costType dz = new costType("dz", DZ_VALUE);
    public static final costType tz = new costType("tz", TZ_VALUE);
    public static final costType yk = new costType("yk", YK_VALUE);

    /**
     * construct function
     * @param String costType
     */
    private costType(String name, String costType)
    {
        super(name, costType);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static costType getEnum(String costType)
    {
        return (costType)getEnum(costType.class, costType);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(costType.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(costType.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(costType.class);
    }
}