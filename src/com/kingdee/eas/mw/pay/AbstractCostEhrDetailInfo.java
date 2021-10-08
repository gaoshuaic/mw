package com.kingdee.eas.mw.pay;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractCostEhrDetailInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractCostEhrDetailInfo()
    {
        this("id");
    }
    protected AbstractCostEhrDetailInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object:�ɱ�EHR����'s ����property 
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
     * Object:�ɱ�EHR����'s ������property 
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
     * Object:�ɱ�EHR����'s �������property 
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
     * Object:�ɱ�EHR����'s ����property 
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
     * Object:�ɱ�EHR����'s ����property 
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
     * Object:�ɱ�EHR����'s һ����Դproperty 
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
     * Object:�ɱ�EHR����'s ������Դproperty 
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
     * Object:�ɱ�EHR����'s ������Դproperty 
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
     * Object:�ɱ�EHR����'s ���߱���property 
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
     * Object:�ɱ�EHR����'s ����property 
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
     * Object:�ɱ�EHR����'s ��������property 
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
     * Object:�ɱ�EHR����'s ��������property 
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
     * Object:�ɱ�EHR����'s ������property 
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
     * Object:�ɱ�EHR����'s ״̬property 
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
     * Object:�ɱ�EHR����'s ԤԼ��property 
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
     * Object:�ɱ�EHR����'s ����ҽ������property 
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
     * Object:�ɱ�EHR����'s ����ҽ��property 
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
     * Object:�ɱ�EHR����'s ��ʿ����property 
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
     * Object:�ɱ�EHR����'s ���ﻤʿproperty 
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
     * Object:�ɱ�EHR����'s ��ʿ��������property 
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
     * Object:�ɱ�EHR����'s ������ѯ����property 
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
     * Object:�ɱ�EHR����'s ������ѯproperty 
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
     * Object:�ɱ�EHR����'s ר����ѯ����property 
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
     * Object:�ɱ�EHR����'s ר����ѯproperty 
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
     * Object:�ɱ�EHR����'s һ���������property 
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
     * Object:�ɱ�EHR����'s һ������property 
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
     * Object:�ɱ�EHR����'s �����������property 
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
     * Object:�ɱ�EHR����'s ��������property 
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
     * Object:�ɱ�EHR����'s �շ���property 
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
     * Object:�ɱ�EHR����'s �տ���property 
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
     * Object:�ɱ�EHR����'s ����property 
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
     * Object:�ɱ�EHR����'s ���б���property 
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
     * Object:�ɱ�EHR����'s �շ���Ŀ����property 
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
     * Object:�ɱ�EHR����'s �Ƿ񳣹�property 
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
     * Object:�ɱ�EHR����'s his���Ѷ���IDproperty 
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
     * Object:�ɱ�EHR����'s �ɱ�property 
     */
    public java.math.BigDecimal getCost()
    {
        return getBigDecimal("cost");
    }
    public void setCost(java.math.BigDecimal item)
    {
        setBigDecimal("cost", item);
    }
    /**
     * Object:�ɱ�EHR����'s ҵ������(����)property 
     */
    public String getBusinessDate()
    {
        return getString("businessDate");
    }
    public void setBusinessDate(String item)
    {
        setString("businessDate", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("611BD221");
    }
}