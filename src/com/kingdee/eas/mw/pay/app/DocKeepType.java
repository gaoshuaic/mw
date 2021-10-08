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
public class DocKeepType extends StringEnum
{
    public static final String WU_VALUE = "wu";//alias=0
    public static final String TWO_VALUE = "two";//alias=2000
    public static final String FOUR_VALUE = "four";//alias=4000
    public static final String EIGHT_VALUE = "eight";//alias=8000
    public static final String PRO_VALUE = "pro";//alias=20%

    public static final DocKeepType wu = new DocKeepType("wu", WU_VALUE);
    public static final DocKeepType two = new DocKeepType("two", TWO_VALUE);
    public static final DocKeepType four = new DocKeepType("four", FOUR_VALUE);
    public static final DocKeepType eight = new DocKeepType("eight", EIGHT_VALUE);
    public static final DocKeepType pro = new DocKeepType("pro", PRO_VALUE);

    /**
     * construct function
     * @param String docKeepType
     */
    private DocKeepType(String name, String docKeepType)
    {
        super(name, docKeepType);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static DocKeepType getEnum(String docKeepType)
    {
        return (DocKeepType)getEnum(DocKeepType.class, docKeepType);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(DocKeepType.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(DocKeepType.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(DocKeepType.class);
    }
}