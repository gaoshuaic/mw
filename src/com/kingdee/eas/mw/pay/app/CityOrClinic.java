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
public class CityOrClinic extends StringEnum
{
    public static final String CS_VALUE = "cs";//alias=≥« –
    public static final String MZ_VALUE = "mz";//alias=√≈’Ô

    public static final CityOrClinic cs = new CityOrClinic("cs", CS_VALUE);
    public static final CityOrClinic mz = new CityOrClinic("mz", MZ_VALUE);

    /**
     * construct function
     * @param String cityOrClinic
     */
    private CityOrClinic(String name, String cityOrClinic)
    {
        super(name, cityOrClinic);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static CityOrClinic getEnum(String cityOrClinic)
    {
        return (CityOrClinic)getEnum(CityOrClinic.class, cityOrClinic);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(CityOrClinic.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(CityOrClinic.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(CityOrClinic.class);
    }
}