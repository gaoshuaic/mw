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
public class ChannelTypeEnum extends StringEnum
{
    public static final String CFFIRSOURCE_VALUE = "CFFirSource";//alias=一级来源
    public static final String CFSECSOURCE_VALUE = "CFSecSource";//alias=二级来源
    public static final String CFTERSOURCE_VALUE = "CFTerSource";//alias=三级来源

    public static final ChannelTypeEnum CFFirSource = new ChannelTypeEnum("CFFirSource", CFFIRSOURCE_VALUE);
    public static final ChannelTypeEnum CFSecSource = new ChannelTypeEnum("CFSecSource", CFSECSOURCE_VALUE);
    public static final ChannelTypeEnum CFTerSource = new ChannelTypeEnum("CFTerSource", CFTERSOURCE_VALUE);

    /**
     * construct function
     * @param String channelTypeEnum
     */
    private ChannelTypeEnum(String name, String channelTypeEnum)
    {
        super(name, channelTypeEnum);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static ChannelTypeEnum getEnum(String channelTypeEnum)
    {
        return (ChannelTypeEnum)getEnum(ChannelTypeEnum.class, channelTypeEnum);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(ChannelTypeEnum.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(ChannelTypeEnum.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(ChannelTypeEnum.class);
    }
}