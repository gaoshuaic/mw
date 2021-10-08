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
public class UpdateCostStatus extends StringEnum
{
    public static final String WSH_VALUE = "wsh";//alias=未审核
    public static final String YSH_VALUE = "ysh";//alias=已审核
    public static final String YQR_VALUE = "yqr";//alias=已确认
    public static final String WQR_VALUE = "wqr";//alias=未确认

    public static final UpdateCostStatus wsh = new UpdateCostStatus("wsh", WSH_VALUE);
    public static final UpdateCostStatus ysh = new UpdateCostStatus("ysh", YSH_VALUE);
    public static final UpdateCostStatus yqr = new UpdateCostStatus("yqr", YQR_VALUE);
    public static final UpdateCostStatus wqr = new UpdateCostStatus("wqr", WQR_VALUE);

    /**
     * construct function
     * @param String updateCostStatus
     */
    private UpdateCostStatus(String name, String updateCostStatus)
    {
        super(name, updateCostStatus);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static UpdateCostStatus getEnum(String updateCostStatus)
    {
        return (UpdateCostStatus)getEnum(UpdateCostStatus.class, updateCostStatus);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(UpdateCostStatus.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(UpdateCostStatus.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(UpdateCostStatus.class);
    }
}