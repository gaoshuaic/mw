package com.kingdee.eas.mw.pay;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractSpePartTimeDocProInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractSpePartTimeDocProInfo()
    {
        this("id");
    }
    protected AbstractSpePartTimeDocProInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object:�����ְҽ����������'s ҽ������property 
     */
    public String getDocNumber()
    {
        return getString("docNumber");
    }
    public void setDocNumber(String item)
    {
        setString("docNumber", item);
    }
    /**
     * Object:�����ְҽ����������'s ҽ������property 
     */
    public String getDocName()
    {
        return getString("docName");
    }
    public void setDocName(String item)
    {
        setString("docName", item);
    }
    /**
     * Object:�����ְҽ����������'s �ߵ���ֲ�����property 
     */
    public java.math.BigDecimal getGdzztPrice()
    {
        return getBigDecimal("gdzztPrice");
    }
    public void setGdzztPrice(java.math.BigDecimal item)
    {
        setBigDecimal("gdzztPrice", item);
    }
    /**
     * Object:�����ְҽ����������'s �е���ֲ�����property 
     */
    public java.math.BigDecimal getZdzztPrice()
    {
        return getBigDecimal("zdzztPrice");
    }
    public void setZdzztPrice(java.math.BigDecimal item)
    {
        setBigDecimal("zdzztPrice", item);
    }
    /**
     * Object:�����ְҽ����������'s �͵���ֲ�����property 
     */
    public java.math.BigDecimal getDdzztPrice()
    {
        return getBigDecimal("ddzztPrice");
    }
    public void setDdzztPrice(java.math.BigDecimal item)
    {
        setBigDecimal("ddzztPrice", item);
    }
    /**
     * Object:�����ְҽ����������'s ����������property 
     */
    public java.math.BigDecimal getNtPrice()
    {
        return getBigDecimal("ntPrice");
    }
    public void setNtPrice(java.math.BigDecimal item)
    {
        setBigDecimal("ntPrice", item);
    }
    /**
     * Object:�����ְҽ����������'s ����������property 
     */
    public java.math.BigDecimal getWtPrice()
    {
        return getBigDecimal("wtPrice");
    }
    public void setWtPrice(java.math.BigDecimal item)
    {
        setBigDecimal("wtPrice", item);
    }
    /**
     * Object:�����ְҽ����������'s �ǽ�ԭ���property 
     */
    public java.math.BigDecimal getGjyPrice()
    {
        return getBigDecimal("gjyPrice");
    }
    public void setGjyPrice(java.math.BigDecimal item)
    {
        setBigDecimal("gjyPrice", item);
    }
    /**
     * Object:�����ְҽ����������'s С�Ƿ����property 
     */
    public java.math.BigDecimal getXgfPrice()
    {
        return getBigDecimal("xgfPrice");
    }
    public void setXgfPrice(java.math.BigDecimal item)
    {
        setBigDecimal("xgfPrice", item);
    }
    /**
     * Object:�����ְҽ����������'s ��Ƿ����property 
     */
    public java.math.BigDecimal getDgfPrice()
    {
        return getBigDecimal("dgfPrice");
    }
    public void setDgfPrice(java.math.BigDecimal item)
    {
        setBigDecimal("dgfPrice", item);
    }
    /**
     * Object:�����ְҽ����������'s С��Ĥ���property 
     */
    public java.math.BigDecimal getXgmPrice()
    {
        return getBigDecimal("xgmPrice");
    }
    public void setXgmPrice(java.math.BigDecimal item)
    {
        setBigDecimal("xgmPrice", item);
    }
    /**
     * Object:�����ְҽ����������'s ���Ĥ���property 
     */
    public java.math.BigDecimal getDgmPrice()
    {
        return getBigDecimal("dgmPrice");
    }
    public void setDgmPrice(java.math.BigDecimal item)
    {
        setBigDecimal("dgmPrice", item);
    }
    /**
     * Object:�����ְҽ����������'s ��ֲ��ɱ���property 
     */
    public java.math.BigDecimal getZzpro()
    {
        return getBigDecimal("zzpro");
    }
    public void setZzpro(java.math.BigDecimal item)
    {
        setBigDecimal("zzpro", item);
    }
    /**
     * Object:�����ְҽ����������'s �̶�������ɱ���property 
     */
    public java.math.BigDecimal getGdjzpro()
    {
        return getBigDecimal("gdjzpro");
    }
    public void setGdjzpro(java.math.BigDecimal item)
    {
        setBigDecimal("gdjzpro", item);
    }
    /**
     * Object:�����ְҽ����������'s ���ν�����ɱ���property 
     */
    public java.math.BigDecimal getYxjzpro()
    {
        return getBigDecimal("yxjzpro");
    }
    public void setYxjzpro(java.math.BigDecimal item)
    {
        setBigDecimal("yxjzpro", item);
    }
    /**
     * Object:�����ְҽ����������'s ������ɱ���property 
     */
    public java.math.BigDecimal getYzpro()
    {
        return getBigDecimal("yzpro");
    }
    public void setYzpro(java.math.BigDecimal item)
    {
        setBigDecimal("yzpro", item);
    }
    /**
     * Object:�����ְҽ����������'s ��������ɱ���property 
     */
    public java.math.BigDecimal getKnwpro()
    {
        return getBigDecimal("knwpro");
    }
    public void setKnwpro(java.math.BigDecimal item)
    {
        setBigDecimal("knwpro", item);
    }
    /**
     * Object:�����ְҽ����������'s ������ɱ���property 
     */
    public java.math.BigDecimal getMbpro()
    {
        return getBigDecimal("mbpro");
    }
    public void setMbpro(java.math.BigDecimal item)
    {
        setBigDecimal("mbpro", item);
    }
    /**
     * Object:�����ְҽ����������'s �޸���ɱ���property 
     */
    public java.math.BigDecimal getXhpro()
    {
        return getBigDecimal("xhpro");
    }
    public void setXhpro(java.math.BigDecimal item)
    {
        setBigDecimal("xhpro", item);
    }
    /**
     * Object:�����ְҽ����������'s ������ɱ���property 
     */
    public java.math.BigDecimal getEypro()
    {
        return getBigDecimal("eypro");
    }
    public void setEypro(java.math.BigDecimal item)
    {
        setBigDecimal("eypro", item);
    }
    /**
     * Object:�����ְҽ����������'s �����շѱ���property 
     */
    public java.math.BigDecimal getZjPro()
    {
        return getBigDecimal("zjPro");
    }
    public void setZjPro(java.math.BigDecimal item)
    {
        setBigDecimal("zjPro", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("0C10B2AB");
    }
}