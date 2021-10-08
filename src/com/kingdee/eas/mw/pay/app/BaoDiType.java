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
public class BaoDiType extends StringEnum
{
    public static final String WAI_VALUE = "wai";//alias=保底外
    public static final String NEI_VALUE = "nei";//alias=保底内

    public static final BaoDiType wai = new BaoDiType("wai", WAI_VALUE);
    public static final BaoDiType nei = new BaoDiType("nei", NEI_VALUE);

    /**
     * construct function
     * @param String baoDiType
     */
    private BaoDiType(String name, String baoDiType)
    {
        super(name, baoDiType);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static BaoDiType getEnum(String baoDiType)
    {
        return (BaoDiType)getEnum(BaoDiType.class, baoDiType);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(BaoDiType.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(BaoDiType.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(BaoDiType.class);
    }
}