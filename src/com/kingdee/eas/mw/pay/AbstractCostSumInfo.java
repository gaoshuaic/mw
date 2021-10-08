package com.kingdee.eas.mw.pay;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractCostSumInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractCostSumInfo()
    {
        this("id");
    }
    protected AbstractCostSumInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object:�ɱ�����'s �Ƿ�����ƾ֤property 
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
     * Object:�ɱ�����'s ҽ������property 
     */
    public String getDoctorNumber()
    {
        return getString("doctorNumber");
    }
    public void setDoctorNumber(String item)
    {
        setString("doctorNumber", item);
    }
    /**
     * Object:�ɱ�����'s ����property 
     */
    public java.math.BigDecimal getQty()
    {
        return getBigDecimal("qty");
    }
    public void setQty(java.math.BigDecimal item)
    {
        setBigDecimal("qty", item);
    }
    /**
     * Object:�ɱ�����'s ����property 
     */
    public java.math.BigDecimal getPrice()
    {
        return getBigDecimal("price");
    }
    public void setPrice(java.math.BigDecimal item)
    {
        setBigDecimal("price", item);
    }
    /**
     * Object:�ɱ�����'s ���property 
     */
    public java.math.BigDecimal getAmount()
    {
        return getBigDecimal("amount");
    }
    public void setAmount(java.math.BigDecimal item)
    {
        setBigDecimal("amount", item);
    }
    /**
     * Object:�ɱ�����'s ��עproperty 
     */
    public String getRemark()
    {
        return getString("remark");
    }
    public void setRemark(String item)
    {
        setString("remark", item);
    }
    /**
     * Object:�ɱ�����'s ҽ������property 
     */
    public String getDoctorName()
    {
        return getString("doctorName");
    }
    public void setDoctorName(String item)
    {
        setString("doctorName", item);
    }
    /**
     * Object:�ɱ�����'s �ڼ�property 
     */
    public String getPeriod()
    {
        return getString("period");
    }
    public void setPeriod(String item)
    {
        setString("period", item);
    }
    /**
     * Object:�ɱ�����'s ϵͳ�ӹ������ν���property 
     */
    public java.math.BigDecimal getJgfyxjz()
    {
        return getBigDecimal("jgfyxjz");
    }
    public void setJgfyxjz(java.math.BigDecimal item)
    {
        setBigDecimal("jgfyxjz", item);
    }
    /**
     * Object:�ɱ�����'s ϵͳ�ӹ��ѳ������property 
     */
    public java.math.BigDecimal getJgfcgjz()
    {
        return getBigDecimal("jgfcgjz");
    }
    public void setJgfcgjz(java.math.BigDecimal item)
    {
        setBigDecimal("jgfcgjz", item);
    }
    /**
     * Object:�ɱ�����'s ϵͳ�ӹ��ѿ�����property 
     */
    public java.math.BigDecimal getJgfknw()
    {
        return getBigDecimal("jgfknw");
    }
    public void setJgfknw(java.math.BigDecimal item)
    {
        setBigDecimal("jgfknw", item);
    }
    /**
     * Object:�ɱ�����'s ϵͳ�ӹ����޸�property 
     */
    public java.math.BigDecimal getJgfxf()
    {
        return getBigDecimal("jgfxf");
    }
    public void setJgfxf(java.math.BigDecimal item)
    {
        setBigDecimal("jgfxf", item);
    }
    /**
     * Object:�ɱ�����'s ϵͳ�ӹ��Ѷ���property 
     */
    public java.math.BigDecimal getJgfey()
    {
        return getBigDecimal("jgfey");
    }
    public void setJgfey(java.math.BigDecimal item)
    {
        setBigDecimal("jgfey", item);
    }
    /**
     * Object:�ɱ�����'s ϵͳ�ӹ�������property 
     */
    public java.math.BigDecimal getJgfyz()
    {
        return getBigDecimal("jgfyz");
    }
    public void setJgfyz(java.math.BigDecimal item)
    {
        setBigDecimal("jgfyz", item);
    }
    /**
     * Object:�ɱ�����'s ϵͳ�ӹ�������property 
     */
    public java.math.BigDecimal getJgfmb()
    {
        return getBigDecimal("jgfmb");
    }
    public void setJgfmb(java.math.BigDecimal item)
    {
        setBigDecimal("jgfmb", item);
    }
    /**
     * Object:�ɱ�����'s ϵͳ�ӹ�����ֲproperty 
     */
    public java.math.BigDecimal getJgfzz()
    {
        return getBigDecimal("jgfzz");
    }
    public void setJgfzz(java.math.BigDecimal item)
    {
        setBigDecimal("jgfzz", item);
    }
    /**
     * Object:�ɱ�����'s ϵͳ������ֲproperty 
     */
    public java.math.BigDecimal getXhzz()
    {
        return getBigDecimal("xhzz");
    }
    public void setXhzz(java.math.BigDecimal item)
    {
        setBigDecimal("xhzz", item);
    }
    /**
     * Object:�ɱ�����'s ϵͳ�������ν���property 
     */
    public java.math.BigDecimal getXhyxjz()
    {
        return getBigDecimal("xhyxjz");
    }
    public void setXhyxjz(java.math.BigDecimal item)
    {
        setBigDecimal("xhyxjz", item);
    }
    /**
     * Object:�ɱ�����'s ϵͳ���ĳ������property 
     */
    public java.math.BigDecimal getXhcgjz()
    {
        return getBigDecimal("xhcgjz");
    }
    public void setXhcgjz(java.math.BigDecimal item)
    {
        setBigDecimal("xhcgjz", item);
    }
    /**
     * Object:�ɱ�����'s ϵͳ���Ŀ�����property 
     */
    public java.math.BigDecimal getXhknw()
    {
        return getBigDecimal("xhknw");
    }
    public void setXhknw(java.math.BigDecimal item)
    {
        setBigDecimal("xhknw", item);
    }
    /**
     * Object:�ɱ�����'s ϵͳ�����޸�property 
     */
    public java.math.BigDecimal getXhxf()
    {
        return getBigDecimal("xhxf");
    }
    public void setXhxf(java.math.BigDecimal item)
    {
        setBigDecimal("xhxf", item);
    }
    /**
     * Object:�ɱ�����'s ϵͳ���Ķ���property 
     */
    public java.math.BigDecimal getXhey()
    {
        return getBigDecimal("xhey");
    }
    public void setXhey(java.math.BigDecimal item)
    {
        setBigDecimal("xhey", item);
    }
    /**
     * Object:�ɱ�����'s ϵͳ��������property 
     */
    public java.math.BigDecimal getXhyz()
    {
        return getBigDecimal("xhyz");
    }
    public void setXhyz(java.math.BigDecimal item)
    {
        setBigDecimal("xhyz", item);
    }
    /**
     * Object:�ɱ�����'s �������property 
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
     * Object:�ɱ�����'s ��������property 
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
     * Object:�ɱ�����'s ϵͳ��������property 
     */
    public java.math.BigDecimal getXhmb()
    {
        return getBigDecimal("xhmb");
    }
    public void setXhmb(java.math.BigDecimal item)
    {
        setBigDecimal("xhmb", item);
    }
    /**
     * Object:�ɱ�����'s ���б���property 
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
     * Object:�ɱ�����'s ��������property 
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
     * Object:�ɱ�����'s ״̬property 
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
    /**
     * Object:�ɱ�����'s ����������ֲproperty 
     */
    public java.math.BigDecimal getUpxhzz()
    {
        return getBigDecimal("upxhzz");
    }
    public void setUpxhzz(java.math.BigDecimal item)
    {
        setBigDecimal("upxhzz", item);
    }
    /**
     * Object:�ɱ�����'s �����������ν���property 
     */
    public java.math.BigDecimal getUpxhyxjz()
    {
        return getBigDecimal("upxhyxjz");
    }
    public void setUpxhyxjz(java.math.BigDecimal item)
    {
        setBigDecimal("upxhyxjz", item);
    }
    /**
     * Object:�ɱ�����'s �������ĳ������property 
     */
    public java.math.BigDecimal getUpxhcgjz()
    {
        return getBigDecimal("upxhcgjz");
    }
    public void setUpxhcgjz(java.math.BigDecimal item)
    {
        setBigDecimal("upxhcgjz", item);
    }
    /**
     * Object:�ɱ�����'s �������Ŀ�����property 
     */
    public java.math.BigDecimal getUpxhknw()
    {
        return getBigDecimal("upxhknw");
    }
    public void setUpxhknw(java.math.BigDecimal item)
    {
        setBigDecimal("upxhknw", item);
    }
    /**
     * Object:�ɱ�����'s ���������޸�property 
     */
    public java.math.BigDecimal getUpxhxf()
    {
        return getBigDecimal("upxhxf");
    }
    public void setUpxhxf(java.math.BigDecimal item)
    {
        setBigDecimal("upxhxf", item);
    }
    /**
     * Object:�ɱ�����'s �������Ķ���property 
     */
    public java.math.BigDecimal getUpxhey()
    {
        return getBigDecimal("upxhey");
    }
    public void setUpxhey(java.math.BigDecimal item)
    {
        setBigDecimal("upxhey", item);
    }
    /**
     * Object:�ɱ�����'s ������������property 
     */
    public java.math.BigDecimal getUpxhyz()
    {
        return getBigDecimal("upxhyz");
    }
    public void setUpxhyz(java.math.BigDecimal item)
    {
        setBigDecimal("upxhyz", item);
    }
    /**
     * Object:�ɱ�����'s ������������property 
     */
    public java.math.BigDecimal getUpxhmb()
    {
        return getBigDecimal("upxhmb");
    }
    public void setUpxhmb(java.math.BigDecimal item)
    {
        setBigDecimal("upxhmb", item);
    }
    /**
     * Object:�ɱ�����'s �����ӹ�����ֲproperty 
     */
    public java.math.BigDecimal getUpjgfzz()
    {
        return getBigDecimal("upjgfzz");
    }
    public void setUpjgfzz(java.math.BigDecimal item)
    {
        setBigDecimal("upjgfzz", item);
    }
    /**
     * Object:�ɱ�����'s �����ӹ������ν���property 
     */
    public java.math.BigDecimal getUpjgfyxjz()
    {
        return getBigDecimal("upjgfyxjz");
    }
    public void setUpjgfyxjz(java.math.BigDecimal item)
    {
        setBigDecimal("upjgfyxjz", item);
    }
    /**
     * Object:�ɱ�����'s �����ӹ��ѳ������property 
     */
    public java.math.BigDecimal getUpjgfcgjz()
    {
        return getBigDecimal("upjgfcgjz");
    }
    public void setUpjgfcgjz(java.math.BigDecimal item)
    {
        setBigDecimal("upjgfcgjz", item);
    }
    /**
     * Object:�ɱ�����'s �����ӹ��ѿ�����property 
     */
    public java.math.BigDecimal getUpjgfknw()
    {
        return getBigDecimal("upjgfknw");
    }
    public void setUpjgfknw(java.math.BigDecimal item)
    {
        setBigDecimal("upjgfknw", item);
    }
    /**
     * Object:�ɱ�����'s �����ӹ����޸�property 
     */
    public java.math.BigDecimal getUpjgfxf()
    {
        return getBigDecimal("upjgfxf");
    }
    public void setUpjgfxf(java.math.BigDecimal item)
    {
        setBigDecimal("upjgfxf", item);
    }
    /**
     * Object:�ɱ�����'s �����ӹ��Ѷ���property 
     */
    public java.math.BigDecimal getUpjgfey()
    {
        return getBigDecimal("upjgfey");
    }
    public void setUpjgfey(java.math.BigDecimal item)
    {
        setBigDecimal("upjgfey", item);
    }
    /**
     * Object:�ɱ�����'s �����ӹ�������property 
     */
    public java.math.BigDecimal getUpjgfyz()
    {
        return getBigDecimal("upjgfyz");
    }
    public void setUpjgfyz(java.math.BigDecimal item)
    {
        setBigDecimal("upjgfyz", item);
    }
    /**
     * Object:�ɱ�����'s �����ӹ�������property 
     */
    public java.math.BigDecimal getUpjgfmb()
    {
        return getBigDecimal("upjgfmb");
    }
    public void setUpjgfmb(java.math.BigDecimal item)
    {
        setBigDecimal("upjgfmb", item);
    }
    /**
     * Object:�ɱ�����'s ����������ֲproperty 
     */
    public java.math.BigDecimal getAllxhzz()
    {
        return getBigDecimal("allxhzz");
    }
    public void setAllxhzz(java.math.BigDecimal item)
    {
        setBigDecimal("allxhzz", item);
    }
    /**
     * Object:�ɱ�����'s �����������ν���property 
     */
    public java.math.BigDecimal getAllxhyxjz()
    {
        return getBigDecimal("allxhyxjz");
    }
    public void setAllxhyxjz(java.math.BigDecimal item)
    {
        setBigDecimal("allxhyxjz", item);
    }
    /**
     * Object:�ɱ�����'s �������ĳ������property 
     */
    public java.math.BigDecimal getAllxhcgjz()
    {
        return getBigDecimal("allxhcgjz");
    }
    public void setAllxhcgjz(java.math.BigDecimal item)
    {
        setBigDecimal("allxhcgjz", item);
    }
    /**
     * Object:�ɱ�����'s �������Ŀ�����property 
     */
    public java.math.BigDecimal getAllxhknw()
    {
        return getBigDecimal("allxhknw");
    }
    public void setAllxhknw(java.math.BigDecimal item)
    {
        setBigDecimal("allxhknw", item);
    }
    /**
     * Object:�ɱ�����'s ���������޸�property 
     */
    public java.math.BigDecimal getAllxhxf()
    {
        return getBigDecimal("allxhxf");
    }
    public void setAllxhxf(java.math.BigDecimal item)
    {
        setBigDecimal("allxhxf", item);
    }
    /**
     * Object:�ɱ�����'s �������Ķ���property 
     */
    public java.math.BigDecimal getAllxhey()
    {
        return getBigDecimal("allxhey");
    }
    public void setAllxhey(java.math.BigDecimal item)
    {
        setBigDecimal("allxhey", item);
    }
    /**
     * Object:�ɱ�����'s ������������property 
     */
    public java.math.BigDecimal getAllxhyz()
    {
        return getBigDecimal("allxhyz");
    }
    public void setAllxhyz(java.math.BigDecimal item)
    {
        setBigDecimal("allxhyz", item);
    }
    /**
     * Object:�ɱ�����'s ������������property 
     */
    public java.math.BigDecimal getAllxhmb()
    {
        return getBigDecimal("allxhmb");
    }
    public void setAllxhmb(java.math.BigDecimal item)
    {
        setBigDecimal("allxhmb", item);
    }
    /**
     * Object:�ɱ�����'s ���ܼӹ�����ֲproperty 
     */
    public java.math.BigDecimal getAlljgfzz()
    {
        return getBigDecimal("alljgfzz");
    }
    public void setAlljgfzz(java.math.BigDecimal item)
    {
        setBigDecimal("alljgfzz", item);
    }
    /**
     * Object:�ɱ�����'s ���ܼӹ������ν���property 
     */
    public java.math.BigDecimal getAlljgfyxjz()
    {
        return getBigDecimal("alljgfyxjz");
    }
    public void setAlljgfyxjz(java.math.BigDecimal item)
    {
        setBigDecimal("alljgfyxjz", item);
    }
    /**
     * Object:�ɱ�����'s ���ܼӹ��ѳ������property 
     */
    public java.math.BigDecimal getAlljgfgdjz()
    {
        return getBigDecimal("alljgfgdjz");
    }
    public void setAlljgfgdjz(java.math.BigDecimal item)
    {
        setBigDecimal("alljgfgdjz", item);
    }
    /**
     * Object:�ɱ�����'s ���ܼӹ��ѿ�����property 
     */
    public java.math.BigDecimal getAlljgfknw()
    {
        return getBigDecimal("alljgfknw");
    }
    public void setAlljgfknw(java.math.BigDecimal item)
    {
        setBigDecimal("alljgfknw", item);
    }
    /**
     * Object:�ɱ�����'s ���ܼӹ����޸�property 
     */
    public java.math.BigDecimal getAlljgfxf()
    {
        return getBigDecimal("alljgfxf");
    }
    public void setAlljgfxf(java.math.BigDecimal item)
    {
        setBigDecimal("alljgfxf", item);
    }
    /**
     * Object:�ɱ�����'s ���ܼӹ��Ѷ���property 
     */
    public java.math.BigDecimal getAlljgfey()
    {
        return getBigDecimal("alljgfey");
    }
    public void setAlljgfey(java.math.BigDecimal item)
    {
        setBigDecimal("alljgfey", item);
    }
    /**
     * Object:�ɱ�����'s ���ܼӹ�������property 
     */
    public java.math.BigDecimal getAlljgfyz()
    {
        return getBigDecimal("alljgfyz");
    }
    public void setAlljgfyz(java.math.BigDecimal item)
    {
        setBigDecimal("alljgfyz", item);
    }
    /**
     * Object:�ɱ�����'s ���ܼӹ�������property 
     */
    public java.math.BigDecimal getAlljgfmb()
    {
        return getBigDecimal("alljgfmb");
    }
    public void setAlljgfmb(java.math.BigDecimal item)
    {
        setBigDecimal("alljgfmb", item);
    }
    /**
     * Object:�ɱ�����'s �Ƿ��Դ�property 
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
        return new BOSObjectType("5DA507CC");
    }
}