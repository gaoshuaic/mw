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
public class PaypostType extends StringEnum
{
    public static final String KF_VALUE = "KF";//alias=客服
    public static final String HS_VALUE = "HS";//alias=护士
    public static final String JYS_VALUE = "JYS";//alias=洁牙师
    public static final String ZXS_VALUE = "ZXS";//alias=咨询师
    public static final String YZ_VALUE = "YZ";//alias=院长
    public static final String YS_VALUE = "YS";//alias=医生
    public static final String JZYS_VALUE = "JZYS";//alias=兼职医生
    public static final String MZYYZJ_VALUE = "MZYYZJ";//alias=门诊运营总监
    public static final String FMZYYZJ_VALUE = "FMZYYZJ";//alias=门诊运营副总监
    public static final String CSYYZJ_VALUE = "CSYYZJ";//alias=城市运营总监

    public static final PaypostType KF = new PaypostType("KF", KF_VALUE);
    public static final PaypostType HS = new PaypostType("HS", HS_VALUE);
    public static final PaypostType JYS = new PaypostType("JYS", JYS_VALUE);
    public static final PaypostType ZXS = new PaypostType("ZXS", ZXS_VALUE);
    public static final PaypostType YZ = new PaypostType("YZ", YZ_VALUE);
    public static final PaypostType YS = new PaypostType("YS", YS_VALUE);
    public static final PaypostType JZYS = new PaypostType("JZYS", JZYS_VALUE);
    public static final PaypostType MZYYZJ = new PaypostType("MZYYZJ", MZYYZJ_VALUE);
    public static final PaypostType FMZYYZJ = new PaypostType("FMZYYZJ", FMZYYZJ_VALUE);
    public static final PaypostType CSYYZJ = new PaypostType("CSYYZJ", CSYYZJ_VALUE);

    /**
     * construct function
     * @param String paypostType
     */
    private PaypostType(String name, String paypostType)
    {
        super(name, paypostType);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static PaypostType getEnum(String paypostType)
    {
        return (PaypostType)getEnum(PaypostType.class, paypostType);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(PaypostType.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(PaypostType.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(PaypostType.class);
    }
}