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
public class ShopSize extends StringEnum
{
    public static final String DD_VALUE = "dd";//alias=´óµê
    public static final String XD_VALUE = "xd";//alias=Ð¡µê

    public static final ShopSize dd = new ShopSize("dd", DD_VALUE);
    public static final ShopSize xd = new ShopSize("xd", XD_VALUE);

    /**
     * construct function
     * @param String shopSize
     */
    private ShopSize(String name, String shopSize)
    {
        super(name, shopSize);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static ShopSize getEnum(String shopSize)
    {
        return (ShopSize)getEnum(ShopSize.class, shopSize);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(ShopSize.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(ShopSize.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(ShopSize.class);
    }
}