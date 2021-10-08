/**
 * output package name
 */
package com.kingdee.eas.mw.srqr.app;

import java.util.Map;
import java.util.List;
import java.util.Iterator;
import com.kingdee.util.enums.StringEnum;

/**
 * output class name
 */
public class ItemStatusEnum extends StringEnum
{
    public static final String N_VALUE = "N";//alias=∆Ù”√
    public static final String Y_VALUE = "Y";//alias=Ω˚”√

    public static final ItemStatusEnum N = new ItemStatusEnum("N", N_VALUE);
    public static final ItemStatusEnum Y = new ItemStatusEnum("Y", Y_VALUE);

    /**
     * construct function
     * @param String itemStatusEnum
     */
    private ItemStatusEnum(String name, String itemStatusEnum)
    {
        super(name, itemStatusEnum);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static ItemStatusEnum getEnum(String itemStatusEnum)
    {
        return (ItemStatusEnum)getEnum(ItemStatusEnum.class, itemStatusEnum);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(ItemStatusEnum.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(ItemStatusEnum.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(ItemStatusEnum.class);
    }
}