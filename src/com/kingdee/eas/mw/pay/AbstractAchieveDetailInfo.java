package com.kingdee.eas.mw.pay;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractAchieveDetailInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractAchieveDetailInfo()
    {
        this("id");
    }
    protected AbstractAchieveDetailInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object:HISҵ����ϸ's �Ƿ�����ƾ֤property 
     */
    public boolean isFivouchered()
    {
        return getBoolean("Fivouchered");
    }
    public void setFivouchered(boolean item)
    {
        setBoolean("Fivouchered", item);
    }
    /**
     * Object:HISҵ����ϸ's ����property 
     */
    public String getCity()
    {
        return getString("City");
    }
    public void setCity(String item)
    {
        setString("City", item);
    }
    /**
     * Object:HISҵ����ϸ's ������property 
     */
    public String getCaseNumber()
    {
        return getString("CaseNumber");
    }
    public void setCaseNumber(String item)
    {
        setString("CaseNumber", item);
    }
    /**
     * Object:HISҵ����ϸ's �������property 
     */
    public String getClinicNumber()
    {
        return getString("ClinicNumber");
    }
    public void setClinicNumber(String item)
    {
        setString("ClinicNumber", item);
    }
    /**
     * Object:HISҵ����ϸ's ����property 
     */
    public String getClinicName()
    {
        return getString("ClinicName");
    }
    public void setClinicName(String item)
    {
        setString("ClinicName", item);
    }
    /**
     * Object:HISҵ����ϸ's ����property 
     */
    public String getName()
    {
        return getString("Name");
    }
    public void setName(String item)
    {
        setString("Name", item);
    }
    /**
     * Object:HISҵ����ϸ's һ����Դproperty 
     */
    public String getFirSource()
    {
        return getString("FirSource");
    }
    public void setFirSource(String item)
    {
        setString("FirSource", item);
    }
    /**
     * Object:HISҵ����ϸ's ������Դproperty 
     */
    public String getSecSource()
    {
        return getString("SecSource");
    }
    public void setSecSource(String item)
    {
        setString("SecSource", item);
    }
    /**
     * Object:HISҵ����ϸ's ������Դproperty 
     */
    public String getTerSource()
    {
        return getString("TerSource");
    }
    public void setTerSource(String item)
    {
        setString("TerSource", item);
    }
    /**
     * Object:HISҵ����ϸ's ���߱���property 
     */
    public String getComplainNumber()
    {
        return getString("ComplainNumber");
    }
    public void setComplainNumber(String item)
    {
        setString("ComplainNumber", item);
    }
    /**
     * Object:HISҵ����ϸ's ����property 
     */
    public String getComplainName()
    {
        return getString("ComplainName");
    }
    public void setComplainName(String item)
    {
        setString("ComplainName", item);
    }
    /**
     * Object:HISҵ����ϸ's ��������property 
     */
    public String getFirVis()
    {
        return getString("FirVis");
    }
    public void setFirVis(String item)
    {
        setString("FirVis", item);
    }
    /**
     * Object:HISҵ����ϸ's ��������property 
     */
    public String getCreateOrg()
    {
        return getString("CreateOrg");
    }
    public void setCreateOrg(String item)
    {
        setString("CreateOrg", item);
    }
    /**
     * Object:HISҵ����ϸ's ������property 
     */
    public String getCreater()
    {
        return getString("Creater");
    }
    public void setCreater(String item)
    {
        setString("Creater", item);
    }
    /**
     * Object:HISҵ����ϸ's ״̬property 
     */
    public String getStatus()
    {
        return getString("Status");
    }
    public void setStatus(String item)
    {
        setString("Status", item);
    }
    /**
     * Object:HISҵ����ϸ's ԤԼ��property 
     */
    public String getOrder()
    {
        return getString("Order");
    }
    public void setOrder(String item)
    {
        setString("Order", item);
    }
    /**
     * Object:HISҵ����ϸ's ����ҽ������property 
     */
    public String getRecDotNumber()
    {
        return getString("RecDotNumber");
    }
    public void setRecDotNumber(String item)
    {
        setString("RecDotNumber", item);
    }
    /**
     * Object:HISҵ����ϸ's ����ҽ��property 
     */
    public String getRecDotName()
    {
        return getString("RecDotName");
    }
    public void setRecDotName(String item)
    {
        setString("RecDotName", item);
    }
    /**
     * Object:HISҵ����ϸ's ��ʿ����property 
     */
    public String getNurseNUmber()
    {
        return getString("NurseNUmber");
    }
    public void setNurseNUmber(String item)
    {
        setString("NurseNUmber", item);
    }
    /**
     * Object:HISҵ����ϸ's ���ﻤʿproperty 
     */
    public String getRecNurse()
    {
        return getString("RecNurse");
    }
    public void setRecNurse(String item)
    {
        setString("RecNurse", item);
    }
    /**
     * Object:HISҵ����ϸ's ��ʿ��������property 
     */
    public String getNurseOrderDiag()
    {
        return getString("NurseOrderDiag");
    }
    public void setNurseOrderDiag(String item)
    {
        setString("NurseOrderDiag", item);
    }
    /**
     * Object:HISҵ����ϸ's ������ѯ����property 
     */
    public String getRecConNumber()
    {
        return getString("RecConNumber");
    }
    public void setRecConNumber(String item)
    {
        setString("RecConNumber", item);
    }
    /**
     * Object:HISҵ����ϸ's ������ѯproperty 
     */
    public String getRecConName()
    {
        return getString("RecConName");
    }
    public void setRecConName(String item)
    {
        setString("RecConName", item);
    }
    /**
     * Object:HISҵ����ϸ's ר����ѯ����property 
     */
    public String getExcConNumber()
    {
        return getString("ExcConNumber");
    }
    public void setExcConNumber(String item)
    {
        setString("ExcConNumber", item);
    }
    /**
     * Object:HISҵ����ϸ's ר����ѯproperty 
     */
    public String getExcConName()
    {
        return getString("ExcConName");
    }
    public void setExcConName(String item)
    {
        setString("ExcConName", item);
    }
    /**
     * Object:HISҵ����ϸ's һ���������property 
     */
    public String getFirClassNumber()
    {
        return getString("FirClassNumber");
    }
    public void setFirClassNumber(String item)
    {
        setString("FirClassNumber", item);
    }
    /**
     * Object:HISҵ����ϸ's һ������property 
     */
    public String getFirClassName()
    {
        return getString("FirClassName");
    }
    public void setFirClassName(String item)
    {
        setString("FirClassName", item);
    }
    /**
     * Object:HISҵ����ϸ's �����������property 
     */
    public String getSecClassNumber()
    {
        return getString("SecClassNumber");
    }
    public void setSecClassNumber(String item)
    {
        setString("SecClassNumber", item);
    }
    /**
     * Object:HISҵ����ϸ's ��������property 
     */
    public String getSecClassName()
    {
        return getString("SecClassName");
    }
    public void setSecClassName(String item)
    {
        setString("SecClassName", item);
    }
    /**
     * Object:HISҵ����ϸ's �շ���property 
     */
    public String getFeeItemDetail()
    {
        return getString("FeeItemDetail");
    }
    public void setFeeItemDetail(String item)
    {
        setString("FeeItemDetail", item);
    }
    /**
     * Object:HISҵ����ϸ's �տ���property 
     */
    public String getRecPerson()
    {
        return getString("RecPerson");
    }
    public void setRecPerson(String item)
    {
        setString("RecPerson", item);
    }
    /**
     * Object:HISҵ����ϸ's ����property 
     */
    public java.math.BigDecimal getQty()
    {
        return getBigDecimal("Qty");
    }
    public void setQty(java.math.BigDecimal item)
    {
        setBigDecimal("Qty", item);
    }
    /**
     * Object:HISҵ����ϸ's ԭ��property 
     */
    public java.math.BigDecimal getOriPrice()
    {
        return getBigDecimal("OriPrice");
    }
    public void setOriPrice(java.math.BigDecimal item)
    {
        setBigDecimal("OriPrice", item);
    }
    /**
     * Object:HISҵ����ϸ's Ӫҵ����property 
     */
    public java.math.BigDecimal getIncome()
    {
        return getBigDecimal("Income");
    }
    public void setIncome(java.math.BigDecimal item)
    {
        setBigDecimal("Income", item);
    }
    /**
     * Object:HISҵ����ϸ's �ۿ�property 
     */
    public java.math.BigDecimal getDiscount()
    {
        return getBigDecimal("Discount");
    }
    public void setDiscount(java.math.BigDecimal item)
    {
        setBigDecimal("Discount", item);
    }
    /**
     * Object:HISҵ����ϸ's �ܼ�property 
     */
    public java.math.BigDecimal getTotalPrice()
    {
        return getBigDecimal("TotalPrice");
    }
    public void setTotalPrice(java.math.BigDecimal item)
    {
        setBigDecimal("TotalPrice", item);
    }
    /**
     * Object:HISҵ����ϸ's ֧��property 
     */
    public String getPayment()
    {
        return getString("Payment");
    }
    public void setPayment(String item)
    {
        setString("Payment", item);
    }
    /**
     * Object:HISҵ����ϸ's ����֧��property 
     */
    public String getGiftPayment()
    {
        return getString("GiftPayment");
    }
    public void setGiftPayment(String item)
    {
        setString("GiftPayment", item);
    }
    /**
     * Object:HISҵ����ϸ's ���б���property 
     */
    public String getCityNumber()
    {
        return getString("cityNumber");
    }
    public void setCityNumber(String item)
    {
        setString("cityNumber", item);
    }
    /**
     * Object:HISҵ����ϸ's �շ���Ŀ����property 
     */
    public String getFeeItemDetailNumber()
    {
        return getString("feeItemDetailNumber");
    }
    public void setFeeItemDetailNumber(String item)
    {
        setString("feeItemDetailNumber", item);
    }
    /**
     * Object:HISҵ����ϸ's �Ƿ񳣹�property 
     */
    public String getIsRoutine()
    {
        return getString("isRoutine");
    }
    public void setIsRoutine(String item)
    {
        setString("isRoutine", item);
    }
    /**
     * Object:HISҵ����ϸ's ҵ������property 
     */
    public String getBusiType()
    {
        return getString("busiType");
    }
    public void setBusiType(String item)
    {
        setString("busiType", item);
    }
    /**
     * Object:HISҵ����ϸ's his���Ѷ���IDproperty 
     */
    public String getHisOrderId()
    {
        return getString("hisOrderId");
    }
    public void setHisOrderId(String item)
    {
        setString("hisOrderId", item);
    }
    /**
     * Object:HISҵ����ϸ's �Ƿ�ͳ��property 
     */
    public boolean isIscount()
    {
        return getBoolean("iscount");
    }
    public void setIscount(boolean item)
    {
        setBoolean("iscount", item);
    }
    /**
     * Object:HISҵ����ϸ's �Ƿ���Ҫ����property 
     */
    public boolean isIsneedout()
    {
        return getBoolean("isneedout");
    }
    public void setIsneedout(boolean item)
    {
        setBoolean("isneedout", item);
    }
    /**
     * Object:HISҵ����ϸ's �Ƿ����property 
     */
    public boolean isIsout()
    {
        return getBoolean("isout");
    }
    public void setIsout(boolean item)
    {
        setBoolean("isout", item);
    }
    /**
     * Object:HISҵ����ϸ's his���Ѷ�����ϸIDproperty 
     */
    public String getHisdetailid()
    {
        return getString("hisdetailid");
    }
    public void setHisdetailid(String item)
    {
        setString("hisdetailid", item);
    }
    /**
     * Object:HISҵ����ϸ's �տ��˱���property 
     */
    public String getRecPersonNumber()
    {
        return getString("RecPersonNumber");
    }
    public void setRecPersonNumber(String item)
    {
        setString("RecPersonNumber", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("C9F3CC10");
    }
}