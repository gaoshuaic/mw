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
public class PayPostStatus extends StringEnum
{
    public static final String QY_VALUE = "qy";//alias=∆Ù”√
    public static final String JY_VALUE = "jy";//alias=Ω˚”√

    public static final PayPostStatus qy = new PayPostStatus("qy", QY_VALUE);
    public static final PayPostStatus jy = new PayPostStatus("jy", JY_VALUE);

    /**
     * construct function
     * @param String payPostStatus
     */
    private PayPostStatus(String name, String payPostStatus)
    {
        super(name, payPostStatus);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static PayPostStatus getEnum(String payPostStatus)
    {
        return (PayPostStatus)getEnum(PayPostStatus.class, payPostStatus);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(PayPostStatus.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(PayPostStatus.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(PayPostStatus.class);
    }
}