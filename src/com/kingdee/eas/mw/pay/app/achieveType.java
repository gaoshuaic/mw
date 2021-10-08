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
public class achieveType extends StringEnum
{
    public static final String QT_VALUE = "qt";//alias=渠道
    public static final String XMT_VALUE = "xmt";//alias=新媒体
    public static final String GGYJ_VALUE = "ggyj";//alias=广告业绩

    public static final achieveType qt = new achieveType("qt", QT_VALUE);
    public static final achieveType xmt = new achieveType("xmt", XMT_VALUE);
    public static final achieveType ggyj = new achieveType("ggyj", GGYJ_VALUE);

    /**
     * construct function
     * @param String achieveType
     */
    private achieveType(String name, String achieveType)
    {
        super(name, achieveType);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static achieveType getEnum(String achieveType)
    {
        return (achieveType)getEnum(achieveType.class, achieveType);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(achieveType.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(achieveType.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(achieveType.class);
    }
}