package com.kingdee.eas.mw.pay;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractClinicAchieveCosthInitInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractClinicAchieveCosthInitInfo()
    {
        this("id");
    }
    protected AbstractClinicAchieveCosthInitInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object:����ҵ���ɱ���ʼ����'s ҵ���ڼ�property 
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
     * Object:����ҵ���ɱ���ʼ����'s Ա������property 
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
     * Object:����ҵ���ɱ���ʼ����'s Ա������property 
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
     * Object:����ҵ���ɱ���ʼ����'s �������property 
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
     * Object:����ҵ���ɱ���ʼ����'s ���б���property 
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
     * Object:����ҵ���ɱ���ʼ����'s ��������property 
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
     * Object:����ҵ���ɱ���ʼ����'s ��������property 
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
     * Object:����ҵ���ɱ���ʼ����'s ��������property 
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
     * Object:����ҵ���ɱ���ʼ����'s �����´���property 
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
     * Object:����ҵ���ɱ���ʼ����'s ����ҵ��(����ʦ)property 
     */
    public java.math.BigDecimal getWhiteAchieve()
    {
        return getBigDecimal("whiteAchieve");
    }
    public void setWhiteAchieve(java.math.BigDecimal item)
    {
        setBigDecimal("whiteAchieve", item);
    }
    /**
     * Object:����ҵ���ɱ���ʼ����'s ��ѯҵ��property 
     */
    public java.math.BigDecimal getZxAchieve()
    {
        return getBigDecimal("zxAchieve");
    }
    public void setZxAchieve(java.math.BigDecimal item)
    {
        setBigDecimal("zxAchieve", item);
    }
    /**
     * Object:����ҵ���ɱ���ʼ����'s ��ֲҵ��property 
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
     * Object:����ҵ���ɱ���ʼ����'s ��ֲ�ɱ�property 
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
     * Object:����ҵ���ɱ���ʼ����'s �̶�����ҵ��property 
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
     * Object:����ҵ���ɱ���ʼ����'s �̶������ɱ�property 
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
     * Object:����ҵ���ɱ���ʼ����'s ���ν���ҵ��property 
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
     * Object:����ҵ���ɱ���ʼ����'s ���ν����ɱ�property 
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
     * Object:����ҵ���ɱ���ʼ����'s ����ҵ��property 
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
     * Object:����ҵ���ɱ���ʼ����'s ���ܳɱ�property 
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
     * Object:����ҵ���ɱ���ʼ����'s ������ҵ��property 
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
     * Object:����ҵ���ɱ���ʼ����'s ������ɱ�property 
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
     * Object:����ҵ���ɱ���ʼ����'s ����ҵ��property 
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
     * Object:����ҵ���ɱ���ʼ����'s ���׳ɱ�property 
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
     * Object:����ҵ���ɱ���ʼ����'s �޸�ҵ��property 
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
     * Object:����ҵ���ɱ���ʼ����'s �޸��ɱ�property 
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
     * Object:����ҵ���ɱ���ʼ����'s ����ҵ��property 
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
     * Object:����ҵ���ɱ���ʼ����'s �����ɱ�property 
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
     * Object:����ҵ���ɱ���ʼ����'s ҵ���ܺ�property 
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
     * Object:����ҵ���ɱ���ʼ����'s ��ֲ����property 
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
     * Object:����ҵ���ɱ���ʼ����'s �̶���������property 
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
     * Object:����ҵ���ɱ���ʼ����'s ���ν�������property 
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
     * Object:����ҵ���ɱ���ʼ����'s �����⽱��property 
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
     * Object:����ҵ���ɱ���ʼ����'s ���ܽ���property 
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
     * Object:����ҵ���ɱ���ʼ����'s ���׽���property 
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
     * Object:����ҵ���ɱ���ʼ����'s �޸�����property 
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
     * Object:����ҵ���ɱ���ʼ����'s ��������property 
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
     * Object:����ҵ���ɱ���ʼ����'s ��������property 
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
     * Object:����ҵ���ɱ���ʼ����'s ��λproperty 
     */
    public com.kingdee.eas.mw.pay.app.PaypostType getPostType()
    {
        return com.kingdee.eas.mw.pay.app.PaypostType.getEnum(getString("postType"));
    }
    public void setPostType(com.kingdee.eas.mw.pay.app.PaypostType item)
    {
		if (item != null) {
        setString("postType", item.getValue());
		}
    }
    /**
     * Object:����ҵ���ɱ���ʼ����'s �Ƿ��Դ�property 
     */
    public boolean isIszidai()
    {
        return getBoolean("iszidai");
    }
    public void setIszidai(boolean item)
    {
        setBoolean("iszidai", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("F965A954");
    }
}