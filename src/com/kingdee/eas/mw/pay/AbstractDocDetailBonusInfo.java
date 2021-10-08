package com.kingdee.eas.mw.pay;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractDocDetailBonusInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractDocDetailBonusInfo()
    {
        this("id");
    }
    protected AbstractDocDetailBonusInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object:ҽ��������ϸ����'s ҵ���ڼ�property 
     */
    public String getBusinessDate()
    {
        return getString("businessDate");
    }
    public void setBusinessDate(String item)
    {
        setString("businessDate", item);
    }
    /**
     * Object:ҽ��������ϸ����'s Ա������property 
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
     * Object:ҽ��������ϸ����'s Ա������property 
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
     * Object:ҽ��������ϸ����'s �������property 
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
     * Object:ҽ��������ϸ����'s ���б���property 
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
     * Object:ҽ��������ϸ����'s ��������property 
     */
    public String getCityName()
    {
        return getString("cityName");
    }
    public void setCityName(String item)
    {
        setString("cityName", item);
    }
    /**
     * Object:ҽ��������ϸ����'s ��������property 
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
     * Object:ҽ��������ϸ����'s ��������property 
     */
    public java.math.BigDecimal getJyCount()
    {
        return getBigDecimal("jyCount");
    }
    public void setJyCount(java.math.BigDecimal item)
    {
        setBigDecimal("jyCount", item);
    }
    /**
     * Object:ҽ��������ϸ����'s �����´���property 
     */
    public java.math.BigDecimal getPlaCount()
    {
        return getBigDecimal("plaCount");
    }
    public void setPlaCount(java.math.BigDecimal item)
    {
        setBigDecimal("plaCount", item);
    }
    /**
     * Object:ҽ��������ϸ����'s ��ֲҵ��property 
     */
    public java.math.BigDecimal getZzAchieve()
    {
        return getBigDecimal("zzAchieve");
    }
    public void setZzAchieve(java.math.BigDecimal item)
    {
        setBigDecimal("zzAchieve", item);
    }
    /**
     * Object:ҽ��������ϸ����'s ��ֲ�ɱ�property 
     */
    public java.math.BigDecimal getZzCost()
    {
        return getBigDecimal("zzCost");
    }
    public void setZzCost(java.math.BigDecimal item)
    {
        setBigDecimal("zzCost", item);
    }
    /**
     * Object:ҽ��������ϸ����'s �̶�����ҵ��property 
     */
    public java.math.BigDecimal getGdjzAchieve()
    {
        return getBigDecimal("gdjzAchieve");
    }
    public void setGdjzAchieve(java.math.BigDecimal item)
    {
        setBigDecimal("gdjzAchieve", item);
    }
    /**
     * Object:ҽ��������ϸ����'s �̶������ɱ�property 
     */
    public java.math.BigDecimal getGdjzCost()
    {
        return getBigDecimal("gdjzCost");
    }
    public void setGdjzCost(java.math.BigDecimal item)
    {
        setBigDecimal("gdjzCost", item);
    }
    /**
     * Object:ҽ��������ϸ����'s ���ν���ҵ��property 
     */
    public java.math.BigDecimal getYxjzAchieve()
    {
        return getBigDecimal("yxjzAchieve");
    }
    public void setYxjzAchieve(java.math.BigDecimal item)
    {
        setBigDecimal("yxjzAchieve", item);
    }
    /**
     * Object:ҽ��������ϸ����'s ���ν����ɱ�property 
     */
    public java.math.BigDecimal getYxjzCost()
    {
        return getBigDecimal("yxjzCost");
    }
    public void setYxjzCost(java.math.BigDecimal item)
    {
        setBigDecimal("yxjzCost", item);
    }
    /**
     * Object:ҽ��������ϸ����'s ����ҵ��property 
     */
    public java.math.BigDecimal getZyAchieve()
    {
        return getBigDecimal("zyAchieve");
    }
    public void setZyAchieve(java.math.BigDecimal item)
    {
        setBigDecimal("zyAchieve", item);
    }
    /**
     * Object:ҽ��������ϸ����'s ���ܳɱ�property 
     */
    public java.math.BigDecimal getYzCost()
    {
        return getBigDecimal("yzCost");
    }
    public void setYzCost(java.math.BigDecimal item)
    {
        setBigDecimal("yzCost", item);
    }
    /**
     * Object:ҽ��������ϸ����'s ������ҵ��property 
     */
    public java.math.BigDecimal getKnwAchieve()
    {
        return getBigDecimal("knwAchieve");
    }
    public void setKnwAchieve(java.math.BigDecimal item)
    {
        setBigDecimal("knwAchieve", item);
    }
    /**
     * Object:ҽ��������ϸ����'s ������ɱ�property 
     */
    public java.math.BigDecimal getKnwCost()
    {
        return getBigDecimal("knwCost");
    }
    public void setKnwCost(java.math.BigDecimal item)
    {
        setBigDecimal("knwCost", item);
    }
    /**
     * Object:ҽ��������ϸ����'s ����ҵ��property 
     */
    public java.math.BigDecimal getMbAchieve()
    {
        return getBigDecimal("mbAchieve");
    }
    public void setMbAchieve(java.math.BigDecimal item)
    {
        setBigDecimal("mbAchieve", item);
    }
    /**
     * Object:ҽ��������ϸ����'s ���׳ɱ�property 
     */
    public java.math.BigDecimal getMbCost()
    {
        return getBigDecimal("mbCost");
    }
    public void setMbCost(java.math.BigDecimal item)
    {
        setBigDecimal("mbCost", item);
    }
    /**
     * Object:ҽ��������ϸ����'s �޸�ҵ��property 
     */
    public java.math.BigDecimal getXfAchieve()
    {
        return getBigDecimal("xfAchieve");
    }
    public void setXfAchieve(java.math.BigDecimal item)
    {
        setBigDecimal("xfAchieve", item);
    }
    /**
     * Object:ҽ��������ϸ����'s �޸��ɱ�property 
     */
    public java.math.BigDecimal getXfCost()
    {
        return getBigDecimal("xfCost");
    }
    public void setXfCost(java.math.BigDecimal item)
    {
        setBigDecimal("xfCost", item);
    }
    /**
     * Object:ҽ��������ϸ����'s ����ҵ��property 
     */
    public java.math.BigDecimal getEyAchieve()
    {
        return getBigDecimal("eyAchieve");
    }
    public void setEyAchieve(java.math.BigDecimal item)
    {
        setBigDecimal("eyAchieve", item);
    }
    /**
     * Object:ҽ��������ϸ����'s �����ɱ�property 
     */
    public java.math.BigDecimal getEyCost()
    {
        return getBigDecimal("eyCost");
    }
    public void setEyCost(java.math.BigDecimal item)
    {
        setBigDecimal("eyCost", item);
    }
    /**
     * Object:ҽ��������ϸ����'s ҵ���ܺ�property 
     */
    public java.math.BigDecimal getSumAchieve()
    {
        return getBigDecimal("sumAchieve");
    }
    public void setSumAchieve(java.math.BigDecimal item)
    {
        setBigDecimal("sumAchieve", item);
    }
    /**
     * Object:ҽ��������ϸ����'s ��ֲ����property 
     */
    public java.math.BigDecimal getZzMoney()
    {
        return getBigDecimal("zzMoney");
    }
    public void setZzMoney(java.math.BigDecimal item)
    {
        setBigDecimal("zzMoney", item);
    }
    /**
     * Object:ҽ��������ϸ����'s �̶���������property 
     */
    public java.math.BigDecimal getGdjzMoney()
    {
        return getBigDecimal("gdjzMoney");
    }
    public void setGdjzMoney(java.math.BigDecimal item)
    {
        setBigDecimal("gdjzMoney", item);
    }
    /**
     * Object:ҽ��������ϸ����'s ���ν�������property 
     */
    public java.math.BigDecimal getYxjzMoney()
    {
        return getBigDecimal("yxjzMoney");
    }
    public void setYxjzMoney(java.math.BigDecimal item)
    {
        setBigDecimal("yxjzMoney", item);
    }
    /**
     * Object:ҽ��������ϸ����'s �����⽱��property 
     */
    public java.math.BigDecimal getKnwMoney()
    {
        return getBigDecimal("knwMoney");
    }
    public void setKnwMoney(java.math.BigDecimal item)
    {
        setBigDecimal("knwMoney", item);
    }
    /**
     * Object:ҽ��������ϸ����'s ���ܽ���property 
     */
    public java.math.BigDecimal getYzMoney()
    {
        return getBigDecimal("yzMoney");
    }
    public void setYzMoney(java.math.BigDecimal item)
    {
        setBigDecimal("yzMoney", item);
    }
    /**
     * Object:ҽ��������ϸ����'s ���׽���property 
     */
    public java.math.BigDecimal getMbMoney()
    {
        return getBigDecimal("mbMoney");
    }
    public void setMbMoney(java.math.BigDecimal item)
    {
        setBigDecimal("mbMoney", item);
    }
    /**
     * Object:ҽ��������ϸ����'s �޸�����property 
     */
    public java.math.BigDecimal getXfMoney()
    {
        return getBigDecimal("xfMoney");
    }
    public void setXfMoney(java.math.BigDecimal item)
    {
        setBigDecimal("xfMoney", item);
    }
    /**
     * Object:ҽ��������ϸ����'s ��������property 
     */
    public java.math.BigDecimal getEyMoney()
    {
        return getBigDecimal("eyMoney");
    }
    public void setEyMoney(java.math.BigDecimal item)
    {
        setBigDecimal("eyMoney", item);
    }
    /**
     * Object:ҽ��������ϸ����'s ��������property 
     */
    public java.math.BigDecimal getOtherMoney()
    {
        return getBigDecimal("otherMoney");
    }
    public void setOtherMoney(java.math.BigDecimal item)
    {
        setBigDecimal("otherMoney", item);
    }
    /**
     * Object:ҽ��������ϸ����'s ��ֲҵ������property 
     */
    public java.math.BigDecimal getZzBase()
    {
        return getBigDecimal("zzBase");
    }
    public void setZzBase(java.math.BigDecimal item)
    {
        setBigDecimal("zzBase", item);
    }
    /**
     * Object:ҽ��������ϸ����'s ��ҽ������ҵ��property 
     */
    public java.math.BigDecimal getClinicAchieve()
    {
        return getBigDecimal("clinicAchieve");
    }
    public void setClinicAchieve(java.math.BigDecimal item)
    {
        setBigDecimal("clinicAchieve", item);
    }
    /**
     * Object:ҽ��������ϸ����'s ���ν���ҵ������property 
     */
    public java.math.BigDecimal getYxjzBase()
    {
        return getBigDecimal("yxjzBase");
    }
    public void setYxjzBase(java.math.BigDecimal item)
    {
        setBigDecimal("yxjzBase", item);
    }
    /**
     * Object:ҽ��������ϸ����'s �̶�����ҵ������property 
     */
    public java.math.BigDecimal getGdjzBase()
    {
        return getBigDecimal("gdjzBase");
    }
    public void setGdjzBase(java.math.BigDecimal item)
    {
        setBigDecimal("gdjzBase", item);
    }
    /**
     * Object:ҽ��������ϸ����'s ������ҵ������property 
     */
    public java.math.BigDecimal getKnwBase()
    {
        return getBigDecimal("knwBase");
    }
    public void setKnwBase(java.math.BigDecimal item)
    {
        setBigDecimal("knwBase", item);
    }
    /**
     * Object:ҽ��������ϸ����'s �޸�ҵ������property 
     */
    public java.math.BigDecimal getXfBase()
    {
        return getBigDecimal("xfBase");
    }
    public void setXfBase(java.math.BigDecimal item)
    {
        setBigDecimal("xfBase", item);
    }
    /**
     * Object:ҽ��������ϸ����'s ����ҵ������property 
     */
    public java.math.BigDecimal getEyBase()
    {
        return getBigDecimal("eyBase");
    }
    public void setEyBase(java.math.BigDecimal item)
    {
        setBigDecimal("eyBase", item);
    }
    /**
     * Object:ҽ��������ϸ����'s ����ҵ������property 
     */
    public java.math.BigDecimal getYzBase()
    {
        return getBigDecimal("yzBase");
    }
    public void setYzBase(java.math.BigDecimal item)
    {
        setBigDecimal("yzBase", item);
    }
    /**
     * Object:ҽ��������ϸ����'s ����ҵ������property 
     */
    public java.math.BigDecimal getMbBase()
    {
        return getBigDecimal("mbBase");
    }
    public void setMbBase(java.math.BigDecimal item)
    {
        setBigDecimal("mbBase", item);
    }
    /**
     * Object:ҽ��������ϸ����'s ����ҵ������property 
     */
    public java.math.BigDecimal getClinicBase()
    {
        return getBigDecimal("clinicBase");
    }
    public void setClinicBase(java.math.BigDecimal item)
    {
        setBigDecimal("clinicBase", item);
    }
    /**
     * Object:ҽ��������ϸ����'s �����ܺ�property 
     */
    public java.math.BigDecimal getSumMoney()
    {
        return getBigDecimal("sumMoney");
    }
    public void setSumMoney(java.math.BigDecimal item)
    {
        setBigDecimal("sumMoney", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("832E15A8");
    }
}