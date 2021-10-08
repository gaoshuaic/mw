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
public class msgStatus extends StringEnum
{
    public static final String SAVE_VALUE = "save";//alias=±£¥Ê
    public static final String SUBMIT_VALUE = "submit";//alias=Ã·Ωª

    public static final msgStatus save = new msgStatus("save", SAVE_VALUE);
    public static final msgStatus submit = new msgStatus("submit", SUBMIT_VALUE);

    /**
     * construct function
     * @param String msgStatus
     */
    private msgStatus(String name, String msgStatus)
    {
        super(name, msgStatus);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static msgStatus getEnum(String msgStatus)
    {
        return (msgStatus)getEnum(msgStatus.class, msgStatus);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(msgStatus.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(msgStatus.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(msgStatus.class);
    }
}