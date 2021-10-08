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
public class status extends StringEnum
{
    public static final String AUDIT_VALUE = "1";//alias=…Û∫À
    public static final String UNAUDIT_VALUE = "2";//alias=∑¥…Û∫À
    public static final String COST_VALUE = "3";//alias=≥ˆø‚∫ÀÀ„

    public static final status audit = new status("audit", AUDIT_VALUE);
    public static final status unaudit = new status("unaudit", UNAUDIT_VALUE);
    public static final status Cost = new status("Cost", COST_VALUE);

    /**
     * construct function
     * @param String status
     */
    private status(String name, String status)
    {
        super(name, status);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static status getEnum(String status)
    {
        return (status)getEnum(status.class, status);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(status.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(status.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(status.class);
    }
}