package com.kingdee.eas.mw.pay;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractDocHISBiLiInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractDocHISBiLiInfo()
    {
        this("id");
    }
    protected AbstractDocHISBiLiInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object:ҽ��His��������'s һ���ۼ�property 
     */
    public java.math.BigDecimal getYijikou()
    {
        return getBigDecimal("yijikou");
    }
    public void setYijikou(java.math.BigDecimal item)
    {
        setBigDecimal("yijikou", item);
    }
    /**
     * Object:ҽ��His��������'s �����ۼ�property 
     */
    public java.math.BigDecimal getErjikou()
    {
        return getBigDecimal("erjikou");
    }
    public void setErjikou(java.math.BigDecimal item)
    {
        setBigDecimal("erjikou", item);
    }
    /**
     * Object:ҽ��His��������'s ���οۼ�property 
     */
    public java.math.BigDecimal getYxkou()
    {
        return getBigDecimal("yxkou");
    }
    public void setYxkou(java.math.BigDecimal item)
    {
        setBigDecimal("yxkou", item);
    }
    /**
     * Object:ҽ��His��������'s �̶��ۼ�property 
     */
    public java.math.BigDecimal getGdkou()
    {
        return getBigDecimal("gdkou");
    }
    public void setGdkou(java.math.BigDecimal item)
    {
        setBigDecimal("gdkou", item);
    }
    /**
     * Object:ҽ��His��������'s ����ʣ��property 
     */
    public java.math.BigDecimal getYxshengyukou()
    {
        return getBigDecimal("yxshengyukou");
    }
    public void setYxshengyukou(java.math.BigDecimal item)
    {
        setBigDecimal("yxshengyukou", item);
    }
    /**
     * Object:ҽ��His��������'s �̶�ʣ��property 
     */
    public java.math.BigDecimal getGdshengyukou()
    {
        return getBigDecimal("gdshengyukou");
    }
    public void setGdshengyukou(java.math.BigDecimal item)
    {
        setBigDecimal("gdshengyukou", item);
    }
    /**
     * Object:ҽ��His��������'s һ���ۼ�����property 
     */
    public String getYijiqudao()
    {
        return getString("yijiqudao");
    }
    public void setYijiqudao(String item)
    {
        setString("yijiqudao", item);
    }
    /**
     * Object:ҽ��His��������'s �����ۼ�����property 
     */
    public String getErjiqudao()
    {
        return getString("erjiqudao");
    }
    public void setErjiqudao(String item)
    {
        setString("erjiqudao", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("D3693B30");
    }
}