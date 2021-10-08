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
public class BudgeType extends StringEnum
{
    public static final String MZ_VALUE = "MZ";//alias=门诊
    public static final String CSSC_VALUE = "CSSC";//alias=市场
    public static final String SCZN_VALUE = "SCZN";//alias=职能

    public static final BudgeType MZ = new BudgeType("MZ", MZ_VALUE);
    public static final BudgeType CSSC = new BudgeType("CSSC", CSSC_VALUE);
    public static final BudgeType SCZN = new BudgeType("SCZN", SCZN_VALUE);

    /**
     * construct function
     * @param String budgeType
     */
    private BudgeType(String name, String budgeType)
    {
        super(name, budgeType);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static BudgeType getEnum(String budgeType)
    {
        return (BudgeType)getEnum(BudgeType.class, budgeType);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(BudgeType.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(BudgeType.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(BudgeType.class);
    }
}