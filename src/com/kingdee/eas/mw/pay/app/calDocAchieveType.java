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
public class calDocAchieveType extends StringEnum
{
    public static final String ZSKC_VALUE = "zskc";//alias=’€À„ø€≥˝
    public static final String LJXY_VALUE = "ljxy";//alias=¿€º∆œ¬‘¬

    public static final calDocAchieveType zskc = new calDocAchieveType("zskc", ZSKC_VALUE);
    public static final calDocAchieveType ljxy = new calDocAchieveType("ljxy", LJXY_VALUE);

    /**
     * construct function
     * @param String calDocAchieveType
     */
    private calDocAchieveType(String name, String calDocAchieveType)
    {
        super(name, calDocAchieveType);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static calDocAchieveType getEnum(String calDocAchieveType)
    {
        return (calDocAchieveType)getEnum(calDocAchieveType.class, calDocAchieveType);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(calDocAchieveType.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(calDocAchieveType.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(calDocAchieveType.class);
    }
}