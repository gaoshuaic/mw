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
public class bonusType extends StringEnum
{
    public static final String HLJJ_VALUE = "hljj";//alias=护理奖金
    public static final String KFJJ_VALUE = "kfjj";//alias=客服奖金

    public static final bonusType hljj = new bonusType("hljj", HLJJ_VALUE);
    public static final bonusType kfjj = new bonusType("kfjj", KFJJ_VALUE);

    /**
     * construct function
     * @param String bonusType
     */
    private bonusType(String name, String bonusType)
    {
        super(name, bonusType);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static bonusType getEnum(String bonusType)
    {
        return (bonusType)getEnum(bonusType.class, bonusType);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(bonusType.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(bonusType.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(bonusType.class);
    }
}