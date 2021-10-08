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
public class CalculationType extends StringEnum
{
    public static final String CALSTAGEACHIEVE_VALUE = "CalStageAchieve";//alias=计算各阶段业绩
    public static final String GETTHISSTAGEPRO_VALUE = "GetThisStagePro";//alias=获得业绩所属阶段比例

    public static final CalculationType CalStageAchieve = new CalculationType("CalStageAchieve", CALSTAGEACHIEVE_VALUE);
    public static final CalculationType GetThisStagePro = new CalculationType("GetThisStagePro", GETTHISSTAGEPRO_VALUE);

    /**
     * construct function
     * @param String calculationType
     */
    private CalculationType(String name, String calculationType)
    {
        super(name, calculationType);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static CalculationType getEnum(String calculationType)
    {
        return (CalculationType)getEnum(CalculationType.class, calculationType);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(CalculationType.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(CalculationType.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(CalculationType.class);
    }
}