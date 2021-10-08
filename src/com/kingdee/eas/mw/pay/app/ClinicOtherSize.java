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
public class ClinicOtherSize extends StringEnum
{
    public static final String DD_VALUE = "dd";//alias=���
    public static final String ZD_VALUE = "zd";//alias=�е�
    public static final String XD_VALUE = "xd";//alias=С��
    public static final String WU_VALUE = "wu";//alias=��

    public static final ClinicOtherSize dd = new ClinicOtherSize("dd", DD_VALUE);
    public static final ClinicOtherSize zd = new ClinicOtherSize("zd", ZD_VALUE);
    public static final ClinicOtherSize xd = new ClinicOtherSize("xd", XD_VALUE);
    public static final ClinicOtherSize wu = new ClinicOtherSize("wu", WU_VALUE);

    /**
     * construct function
     * @param String clinicOtherSize
     */
    private ClinicOtherSize(String name, String clinicOtherSize)
    {
        super(name, clinicOtherSize);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static ClinicOtherSize getEnum(String clinicOtherSize)
    {
        return (ClinicOtherSize)getEnum(ClinicOtherSize.class, clinicOtherSize);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(ClinicOtherSize.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(ClinicOtherSize.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(ClinicOtherSize.class);
    }
}