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
public class imjyType extends StringEnum
{
    public static final String WU_VALUE = "wu";//alias=Œﬁ
    public static final String SSJY_VALUE = "ssjy";//alias= Ê  Ω‡—¿

    public static final imjyType wu = new imjyType("wu", WU_VALUE);
    public static final imjyType ssjy = new imjyType("ssjy", SSJY_VALUE);

    /**
     * construct function
     * @param String imjyType
     */
    private imjyType(String name, String imjyType)
    {
        super(name, imjyType);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static imjyType getEnum(String imjyType)
    {
        return (imjyType)getEnum(imjyType.class, imjyType);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(imjyType.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(imjyType.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(imjyType.class);
    }
}