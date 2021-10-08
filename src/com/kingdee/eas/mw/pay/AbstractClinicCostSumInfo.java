package com.kingdee.eas.mw.pay;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractClinicCostSumInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractClinicCostSumInfo()
    {
        this("id");
    }
    protected AbstractClinicCostSumInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object:�ɱ�ͳ��'s ҵ���ڼ�property 
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
     * Object:�ɱ�ͳ��'s Ա������property 
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
     * Object:�ɱ�ͳ��'s Ա������property 
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
     * Object:�ɱ�ͳ��'s �������property 
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
     * Object:�ɱ�ͳ��'s ���б���property 
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
     * Object:�ɱ�ͳ��'s ��������property 
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
     * Object:�ɱ�ͳ��'s ��������property 
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
     * Object:�ɱ�ͳ��'s ��ֲ�ɱ�property 
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
     * Object:�ɱ�ͳ��'s �̶������ɱ�property 
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
     * Object:�ɱ�ͳ��'s ���ν����ɱ�property 
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
     * Object:�ɱ�ͳ��'s ���ܳɱ�property 
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
     * Object:�ɱ�ͳ��'s ������ɱ�property 
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
     * Object:�ɱ�ͳ��'s ���׳ɱ�property 
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
     * Object:�ɱ�ͳ��'s �޸��ɱ�property 
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
     * Object:�ɱ�ͳ��'s �����ɱ�property 
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
     * Object:�ɱ�ͳ��'s ������ֲ�ɱ�property 
     */
    public java.math.BigDecimal getImzzCost()
    {
        return getBigDecimal("imzzCost");
    }
    public void setImzzCost(java.math.BigDecimal item)
    {
        setBigDecimal("imzzCost", item);
    }
    /**
     * Object:�ɱ�ͳ��'s ����̶������ɱ�property 
     */
    public java.math.BigDecimal getImgdjzCost()
    {
        return getBigDecimal("imgdjzCost");
    }
    public void setImgdjzCost(java.math.BigDecimal item)
    {
        setBigDecimal("imgdjzCost", item);
    }
    /**
     * Object:�ɱ�ͳ��'s �������ν����ɱ�property 
     */
    public java.math.BigDecimal getImyxjzCost()
    {
        return getBigDecimal("imyxjzCost");
    }
    public void setImyxjzCost(java.math.BigDecimal item)
    {
        setBigDecimal("imyxjzCost", item);
    }
    /**
     * Object:�ɱ�ͳ��'s �������ܳɱ�property 
     */
    public java.math.BigDecimal getImyzCost()
    {
        return getBigDecimal("imyzCost");
    }
    public void setImyzCost(java.math.BigDecimal item)
    {
        setBigDecimal("imyzCost", item);
    }
    /**
     * Object:�ɱ�ͳ��'s ���������ɱ�property 
     */
    public java.math.BigDecimal getImknwCost()
    {
        return getBigDecimal("imknwCost");
    }
    public void setImknwCost(java.math.BigDecimal item)
    {
        setBigDecimal("imknwCost", item);
    }
    /**
     * Object:�ɱ�ͳ��'s �������׳ɱ�property 
     */
    public java.math.BigDecimal getImmbCost()
    {
        return getBigDecimal("immbCost");
    }
    public void setImmbCost(java.math.BigDecimal item)
    {
        setBigDecimal("immbCost", item);
    }
    /**
     * Object:�ɱ�ͳ��'s ��������ɱ�property 
     */
    public java.math.BigDecimal getImeyCost()
    {
        return getBigDecimal("imeyCost");
    }
    public void setImeyCost(java.math.BigDecimal item)
    {
        setBigDecimal("imeyCost", item);
    }
    /**
     * Object:�ɱ�ͳ��'s �����޸��ɱ�property 
     */
    public java.math.BigDecimal getImxfCost()
    {
        return getBigDecimal("imxfCost");
    }
    public void setImxfCost(java.math.BigDecimal item)
    {
        setBigDecimal("imxfCost", item);
    }
    /**
     * Object:�ɱ�ͳ��'s �Ƿ��Դ�property 
     */
    public boolean isIzzidai()
    {
        return getBoolean("izzidai");
    }
    public void setIzzidai(boolean item)
    {
        setBoolean("izzidai", item);
    }
    /**
     * Object:�ɱ�ͳ��'s ������ֲ�ɱ�property 
     */
    public java.math.BigDecimal getUpzzCost()
    {
        return getBigDecimal("upzzCost");
    }
    public void setUpzzCost(java.math.BigDecimal item)
    {
        setBigDecimal("upzzCost", item);
    }
    /**
     * Object:�ɱ�ͳ��'s �������γɱ�property 
     */
    public java.math.BigDecimal getUpyxjzCost()
    {
        return getBigDecimal("upyxjzCost");
    }
    public void setUpyxjzCost(java.math.BigDecimal item)
    {
        setBigDecimal("upyxjzCost", item);
    }
    /**
     * Object:�ɱ�ͳ��'s �����̶������ɱ�property 
     */
    public java.math.BigDecimal getUpgdjzCost()
    {
        return getBigDecimal("upgdjzCost");
    }
    public void setUpgdjzCost(java.math.BigDecimal item)
    {
        setBigDecimal("upgdjzCost", item);
    }
    /**
     * Object:�ɱ�ͳ��'s ����������ɱ�property 
     */
    public java.math.BigDecimal getUpknwCost()
    {
        return getBigDecimal("upknwCost");
    }
    public void setUpknwCost(java.math.BigDecimal item)
    {
        setBigDecimal("upknwCost", item);
    }
    /**
     * Object:�ɱ�ͳ��'s �����޸��ɱ�property 
     */
    public java.math.BigDecimal getUpxfCost()
    {
        return getBigDecimal("upxfCost");
    }
    public void setUpxfCost(java.math.BigDecimal item)
    {
        setBigDecimal("upxfCost", item);
    }
    /**
     * Object:�ɱ�ͳ��'s ���������ɱ�property 
     */
    public java.math.BigDecimal getUpeyCost()
    {
        return getBigDecimal("upeyCost");
    }
    public void setUpeyCost(java.math.BigDecimal item)
    {
        setBigDecimal("upeyCost", item);
    }
    /**
     * Object:�ɱ�ͳ��'s �޸����׳ɱ�property 
     */
    public java.math.BigDecimal getUpmbCost()
    {
        return getBigDecimal("upmbCost");
    }
    public void setUpmbCost(java.math.BigDecimal item)
    {
        setBigDecimal("upmbCost", item);
    }
    /**
     * Object:�ɱ�ͳ��'s ������ֲ�ɱ�property 
     */
    public java.math.BigDecimal getAllzzCost()
    {
        return getBigDecimal("allzzCost");
    }
    public void setAllzzCost(java.math.BigDecimal item)
    {
        setBigDecimal("allzzCost", item);
    }
    /**
     * Object:�ɱ�ͳ��'s ���̶ܹ������ɱ�property 
     */
    public java.math.BigDecimal getAllgdjzCost()
    {
        return getBigDecimal("allgdjzCost");
    }
    public void setAllgdjzCost(java.math.BigDecimal item)
    {
        setBigDecimal("allgdjzCost", item);
    }
    /**
     * Object:�ɱ�ͳ��'s ���ܿ�����ɱ�property 
     */
    public java.math.BigDecimal getAllknwCost()
    {
        return getBigDecimal("allknwCost");
    }
    public void setAllknwCost(java.math.BigDecimal item)
    {
        setBigDecimal("allknwCost", item);
    }
    /**
     * Object:�ɱ�ͳ��'s �����޸��ɱ�property 
     */
    public java.math.BigDecimal getAllxfCost()
    {
        return getBigDecimal("allxfCost");
    }
    public void setAllxfCost(java.math.BigDecimal item)
    {
        setBigDecimal("allxfCost", item);
    }
    /**
     * Object:�ɱ�ͳ��'s ���ܶ����ɱ�property 
     */
    public java.math.BigDecimal getAlleyCost()
    {
        return getBigDecimal("alleyCost");
    }
    public void setAlleyCost(java.math.BigDecimal item)
    {
        setBigDecimal("alleyCost", item);
    }
    /**
     * Object:�ɱ�ͳ��'s �������ܳɱ�property 
     */
    public java.math.BigDecimal getAllyzCost()
    {
        return getBigDecimal("allyzCost");
    }
    public void setAllyzCost(java.math.BigDecimal item)
    {
        setBigDecimal("allyzCost", item);
    }
    /**
     * Object:�ɱ�ͳ��'s �������׳ɱ�property 
     */
    public java.math.BigDecimal getAllmbCost()
    {
        return getBigDecimal("allmbCost");
    }
    public void setAllmbCost(java.math.BigDecimal item)
    {
        setBigDecimal("allmbCost", item);
    }
    /**
     * Object:�ɱ�ͳ��'s �������ܳɱ�property 
     */
    public java.math.BigDecimal getUpyzCost()
    {
        return getBigDecimal("upyzCost");
    }
    public void setUpyzCost(java.math.BigDecimal item)
    {
        setBigDecimal("upyzCost", item);
    }
    /**
     * Object:�ɱ�ͳ��'s �������ν����ɱ�property 
     */
    public java.math.BigDecimal getAllyxjzCost()
    {
        return getBigDecimal("allyxjzCost");
    }
    public void setAllyxjzCost(java.math.BigDecimal item)
    {
        setBigDecimal("allyxjzCost", item);
    }
    /**
     * Object:�ɱ�ͳ��'s ״̬property 
     */
    public com.kingdee.eas.mw.pay.app.UpdateCostStatus getStatus()
    {
        return com.kingdee.eas.mw.pay.app.UpdateCostStatus.getEnum(getString("status"));
    }
    public void setStatus(com.kingdee.eas.mw.pay.app.UpdateCostStatus item)
    {
		if (item != null) {
        setString("status", item.getValue());
		}
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("25799344");
    }
}