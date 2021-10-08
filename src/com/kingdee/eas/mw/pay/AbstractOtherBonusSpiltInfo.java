package com.kingdee.eas.mw.pay;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractOtherBonusSpiltInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractOtherBonusSpiltInfo()
    {
        this("id");
    }
    protected AbstractOtherBonusSpiltInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object:����������'s ��λ����property 
     */
    public String getPostName()
    {
        return getString("postName");
    }
    public void setPostName(String item)
    {
        setString("postName", item);
    }
    /**
     * Object:����������'s Ա������property 
     */
    public String getEmpNumber()
    {
        return getString("empNumber");
    }
    public void setEmpNumber(String item)
    {
        setString("empNumber", item);
    }
    /**
     * Object:����������'s Ա������property 
     */
    public String getEmpName()
    {
        return getString("empName");
    }
    public void setEmpName(String item)
    {
        setString("empName", item);
    }
    /**
     * Object:����������'s �������property 
     */
    public String getClinicNumber()
    {
        return getString("clinicNumber");
    }
    public void setClinicNumber(String item)
    {
        setString("clinicNumber", item);
    }
    /**
     * Object:����������'s ��������property 
     */
    public String getClinicName()
    {
        return getString("clinicName");
    }
    public void setClinicName(String item)
    {
        setString("clinicName", item);
    }
    /**
     * Object:����������'s ��λproperty 
     */
    public com.kingdee.eas.mw.pay.app.PaypostType getPostNumber()
    {
        return com.kingdee.eas.mw.pay.app.PaypostType.getEnum(getString("postNumber"));
    }
    public void setPostNumber(com.kingdee.eas.mw.pay.app.PaypostType item)
    {
		if (item != null) {
        setString("postNumber", item.getValue());
		}
    }
    /**
     * Object: ���������� 's ���� property 
     */
    public com.kingdee.eas.basedata.org.CompanyOrgUnitInfo getClinic()
    {
        return (com.kingdee.eas.basedata.org.CompanyOrgUnitInfo)get("clinic");
    }
    public void setClinic(com.kingdee.eas.basedata.org.CompanyOrgUnitInfo item)
    {
        put("clinic", item);
    }
    /**
     * Object: ���������� 's ���� property 
     */
    public com.kingdee.eas.basedata.org.CtrlUnitInfo getCity()
    {
        return (com.kingdee.eas.basedata.org.CtrlUnitInfo)get("city");
    }
    public void setCity(com.kingdee.eas.basedata.org.CtrlUnitInfo item)
    {
        put("city", item);
    }
    /**
     * Object:����������'s ҵ���ڼ�property 
     */
    public String getBusinessdate()
    {
        return getString("businessdate");
    }
    public void setBusinessdate(String item)
    {
        setString("businessdate", item);
    }
    /**
     * Object:����������'s �������۽���property 
     */
    public java.math.BigDecimal getCardSellBonus()
    {
        return getBigDecimal("cardSellBonus");
    }
    public void setCardSellBonus(java.math.BigDecimal item)
    {
        setBigDecimal("cardSellBonus", item);
    }
    /**
     * Object:����������'s ��������1������property 
     */
    public java.math.BigDecimal getOtherBounsOne()
    {
        return getBigDecimal("otherBounsOne");
    }
    public void setOtherBounsOne(java.math.BigDecimal item)
    {
        setBigDecimal("otherBounsOne", item);
    }
    /**
     * Object:����������'s ��������2������property 
     */
    public java.math.BigDecimal getOtherBounsTwo()
    {
        return getBigDecimal("otherBounsTwo");
    }
    public void setOtherBounsTwo(java.math.BigDecimal item)
    {
        setBigDecimal("otherBounsTwo", item);
    }
    /**
     * Object:����������'s ҽ������property 
     */
    public java.math.BigDecimal getDocAssBouns()
    {
        return getBigDecimal("docAssBouns");
    }
    public void setDocAssBouns(java.math.BigDecimal item)
    {
        setBigDecimal("docAssBouns", item);
    }
    /**
     * Object:����������'s �ŵ�֧Ԯproperty 
     */
    public java.math.BigDecimal getShopHelp()
    {
        return getBigDecimal("shopHelp");
    }
    public void setShopHelp(java.math.BigDecimal item)
    {
        setBigDecimal("shopHelp", item);
    }
    /**
     * Object:����������'s ��������property 
     */
    public java.math.BigDecimal getGoodBouns()
    {
        return getBigDecimal("goodBouns");
    }
    public void setGoodBouns(java.math.BigDecimal item)
    {
        setBigDecimal("goodBouns", item);
    }
    /**
     * Object:����������'s �г�����property 
     */
    public java.math.BigDecimal getMarktBouns()
    {
        return getBigDecimal("marktBouns");
    }
    public void setMarktBouns(java.math.BigDecimal item)
    {
        setBigDecimal("marktBouns", item);
    }
    /**
     * Object:����������'s ҽ��תҽ������property 
     */
    public java.math.BigDecimal getToDocBouns()
    {
        return getBigDecimal("toDocBouns");
    }
    public void setToDocBouns(java.math.BigDecimal item)
    {
        setBigDecimal("toDocBouns", item);
    }
    /**
     * Object:����������'s ҽ������Ԥ�����property 
     */
    public java.math.BigDecimal getDocKeepBouns()
    {
        return getBigDecimal("docKeepBouns");
    }
    public void setDocKeepBouns(java.math.BigDecimal item)
    {
        setBigDecimal("docKeepBouns", item);
    }
    /**
     * Object:����������'s ҽ��Ԥ������property 
     */
    public com.kingdee.eas.mw.pay.app.DocKeepType getDocKeepType()
    {
        return com.kingdee.eas.mw.pay.app.DocKeepType.getEnum(getString("docKeepType"));
    }
    public void setDocKeepType(com.kingdee.eas.mw.pay.app.DocKeepType item)
    {
		if (item != null) {
        setString("docKeepType", item.getValue());
		}
    }
    /**
     * Object:����������'s �ͷ�����property 
     */
    public java.math.BigDecimal getKefuBouns()
    {
        return getBigDecimal("kefuBouns");
    }
    public void setKefuBouns(java.math.BigDecimal item)
    {
        setBigDecimal("kefuBouns", item);
    }
    /**
     * Object:����������'s ������property 
     */
    public java.math.BigDecimal getHuliBouns()
    {
        return getBigDecimal("huliBouns");
    }
    public void setHuliBouns(java.math.BigDecimal item)
    {
        setBigDecimal("huliBouns", item);
    }
    /**
     * Object:����������'s ����ʦת������property 
     */
    public java.math.BigDecimal getConvertBouns()
    {
        return getBigDecimal("convertBouns");
    }
    public void setConvertBouns(java.math.BigDecimal item)
    {
        setBigDecimal("convertBouns", item);
    }
    /**
     * Object:����������'s �±��׻���property 
     */
    public java.math.BigDecimal getMonthBase()
    {
        return getBigDecimal("monthBase");
    }
    public void setMonthBase(java.math.BigDecimal item)
    {
        setBigDecimal("monthBase", item);
    }
    /**
     * Object:����������'s �������property 
     */
    public java.math.BigDecimal getBkCount()
    {
        return getBigDecimal("bkCount");
    }
    public void setBkCount(java.math.BigDecimal item)
    {
        setBigDecimal("bkCount", item);
    }
    /**
     * Object:����������'s ȫ������property 
     */
    public java.math.BigDecimal getQkCount()
    {
        return getBigDecimal("qkCount");
    }
    public void setQkCount(java.math.BigDecimal item)
    {
        setBigDecimal("qkCount", item);
    }
    /**
     * Object:����������'s ѹĤ����������property 
     */
    public java.math.BigDecimal getHoldAmount()
    {
        return getBigDecimal("holdAmount");
    }
    public void setHoldAmount(java.math.BigDecimal item)
    {
        setBigDecimal("holdAmount", item);
    }
    /**
     * Object:����������'s X-Ray����property 
     */
    public java.math.BigDecimal getXrayallow()
    {
        return getBigDecimal("xrayallow");
    }
    public void setXrayallow(java.math.BigDecimal item)
    {
        setBigDecimal("xrayallow", item);
    }
    /**
     * Object:����������'s ���ս���property 
     */
    public java.math.BigDecimal getNianzhongmoney()
    {
        return getBigDecimal("nianzhongmoney");
    }
    public void setNianzhongmoney(java.math.BigDecimal item)
    {
        setBigDecimal("nianzhongmoney", item);
    }
    /**
     * Object:����������'s ���Ƚ���property 
     */
    public java.math.BigDecimal getJidumoney()
    {
        return getBigDecimal("jidumoney");
    }
    public void setJidumoney(java.math.BigDecimal item)
    {
        setBigDecimal("jidumoney", item);
    }
    /**
     * Object:����������'s ���ս����̯property 
     */
    public java.math.BigDecimal getNianzhongfentan()
    {
        return getBigDecimal("nianzhongfentan");
    }
    public void setNianzhongfentan(java.math.BigDecimal item)
    {
        setBigDecimal("nianzhongfentan", item);
    }
    /**
     * Object:����������'s ���Ƚ����̯property 
     */
    public java.math.BigDecimal getJidufentan()
    {
        return getBigDecimal("jidufentan");
    }
    public void setJidufentan(java.math.BigDecimal item)
    {
        setBigDecimal("jidufentan", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("F9613513");
    }
}