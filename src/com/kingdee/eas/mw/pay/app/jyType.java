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
public class jyType extends StringEnum
{
    public static final String JY_VALUE = "jy";//alias=Ω‡—¿≈Á…∞
    public static final String PLA_VALUE = "pla";//alias=≈…¡¶∞¬
    public static final String DZ_VALUE = "dz";//alias=µ„’Ô
    public static final String FDZ_VALUE = "fdz";//alias=∑«µ„’Ô
    public static final String SHJYDZ_VALUE = "shjydz";//alias= Ê  Ω‡—¿µ„’Ô
    public static final String SHJYFDZ_VALUE = "shjyfdz";//alias= Ê  Ω‡—¿∑«µ„’Ô

    public static final jyType jy = new jyType("jy", JY_VALUE);
    public static final jyType pla = new jyType("pla", PLA_VALUE);
    public static final jyType dz = new jyType("dz", DZ_VALUE);
    public static final jyType fdz = new jyType("fdz", FDZ_VALUE);
    public static final jyType shjydz = new jyType("shjydz", SHJYDZ_VALUE);
    public static final jyType shjyfdz = new jyType("shjyfdz", SHJYFDZ_VALUE);

    /**
     * construct function
     * @param String jyType
     */
    private jyType(String name, String jyType)
    {
        super(name, jyType);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static jyType getEnum(String jyType)
    {
        return (jyType)getEnum(jyType.class, jyType);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(jyType.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(jyType.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(jyType.class);
    }
}