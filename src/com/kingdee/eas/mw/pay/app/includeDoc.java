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
public class includeDoc extends StringEnum
{
    public static final String Y_VALUE = "Y";//alias=ÊÇ
    public static final String N_VALUE = "N";//alias=·ñ

    public static final includeDoc Y = new includeDoc("Y", Y_VALUE);
    public static final includeDoc N = new includeDoc("N", N_VALUE);

    /**
     * construct function
     * @param String includeDoc
     */
    private includeDoc(String name, String includeDoc)
    {
        super(name, includeDoc);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static includeDoc getEnum(String includeDoc)
    {
        return (includeDoc)getEnum(includeDoc.class, includeDoc);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(includeDoc.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(includeDoc.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(includeDoc.class);
    }
}