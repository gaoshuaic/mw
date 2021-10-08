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
     * Object:成本EHR详情's 城市property 
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
     * Object:成本EHR详情's 病历号property 
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
     * Object:成本EHR详情's 门诊编码property 
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
     * Object:成本EHR详情's 门诊property 
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
     * Object:成本EHR详情's 姓名property 
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
     * Object:成本EHR详情's 一级来源property 
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
     * Object:成本EHR详情's 二级来源property 
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
     * Object:成本EHR详情's 三级来源property 
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
     * Object:成本EHR详情's 主诉编码property 
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
     * Object:成本EHR详情's 主诉property 
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
     * Object:成本EHR详情's 初诊日期property 
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
     * Object:成本EHR详情's 创建机构property 
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
     * Object:成本EHR详情's 创建人property 
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
     * Object:成本EHR详情's 状态property 
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
     * Object:成本EHR详情's 预约人property 
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
     * Object:成本EHR详情's 接诊医生编码property 
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
     * Object:成本EHR详情's 接诊医生property 
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
     * Object:成本EHR详情's 护士编码property 
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
     * Object:成本EHR详情's 接诊护士property 
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
     * Object:成本EHR详情's 护士洁牙点诊property 
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
     * Object:成本EHR详情's 接诊咨询编码property 
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
     * Object:成本EHR详情's 接诊咨询property 
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
     * Object:成本EHR详情's 专属咨询编码property 
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
     * Object:成本EHR详情's 专属咨询property 
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
     * Object:成本EHR详情's 一级分类编码property 
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
     * Object:成本EHR详情's 一级分类property 
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
     * Object:成本EHR详情's 二级分类编码property 
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
     * Object:成本EHR详情's 二级分类property 
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
     * Object:成本EHR详情's 收费项property 
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
     * Object:成本EHR详情's 收款人property 
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
     * Object:成本EHR详情's 数量property 
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
     * Object:成本EHR详情's 城市编码property 
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
     * Object:成本EHR详情's 收费项目编码property 
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
     * Object:成本EHR详情's 是否常规property 
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
     * Object:成本EHR详情's his消费订单IDproperty 
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
     * Object:成本EHR详情's 成本property 
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
     * Object:成本EHR详情's 业务日期(年月)property 
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