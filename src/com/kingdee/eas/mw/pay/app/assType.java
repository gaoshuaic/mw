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
public class assType extends StringEnum
{
    public static final String YZ_VALUE = "yz";//alias=医助
    public static final String HS_VALUE = "hs";//alias=护士
    public static final String QT_VALUE = "qt";//alias=其他

    public static final assType yz = new assType("yz", YZ_VALUE);
    public static final assType hs = new assType("hs", HS_VALUE);
    public static final assType qt = new assType("qt", QT_VALUE);

    /**
     * construct function
     * @param String assType
     */
    private assType(String name, String assType)
    {
        super(name, assType);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static assType getEnum(String assType)
    {
        return (assType)getEnum(assType.class, assType);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(assType.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(assType.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(assType.class);
    }
}