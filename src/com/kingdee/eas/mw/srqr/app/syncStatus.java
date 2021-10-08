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
public class syncStatus extends StringEnum
{
    public static final String NO_SYNC_VALUE = "0";//alias=未同步
    public static final String SYNC_VALUE = "1";//alias=已同步

    public static final syncStatus NO_SYNC = new syncStatus("NO_SYNC", NO_SYNC_VALUE);
    public static final syncStatus SYNC = new syncStatus("SYNC", SYNC_VALUE);

    /**
     * construct function
     * @param String syncStatus
     */
    private syncStatus(String name, String syncStatus)
    {
        super(name, syncStatus);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static syncStatus getEnum(String syncStatus)
    {
        return (syncStatus)getEnum(syncStatus.class, syncStatus);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(syncStatus.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(syncStatus.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(syncStatus.class);
    }
}