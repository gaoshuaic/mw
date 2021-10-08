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
public class CityComRule extends StringEnum
{
    public static final String CBQR_VALUE = "CBQR";//alias=成本确认
    public static final String ZC_VALUE = "ZC";//alias=正常

    public static final CityComRule CBQR = new CityComRule("CBQR", CBQR_VALUE);
    public static final CityComRule ZC = new CityComRule("ZC", ZC_VALUE);

    /**
     * construct function
     * @param String cityComRule
     */
    private CityComRule(String name, String cityComRule)
    {
        super(name, cityComRule);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static CityComRule getEnum(String cityComRule)
    {
        return (CityComRule)getEnum(CityComRule.class, cityComRule);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(CityComRule.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(CityComRule.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(CityComRule.class);
    }
}