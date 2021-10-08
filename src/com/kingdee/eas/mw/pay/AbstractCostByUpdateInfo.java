package com.kingdee.eas.mw.pay;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractCostByUpdateInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractCostByUpdateInfo()
    {
        this("id");
    }
    protected AbstractCostByUpdateInfo(String pkField)
    {
        super(pkField);
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
     * Object:�ɱ�����'s �ӹ������ν���property 
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
     * Object:�ɱ�����'s �ӹ��ѳ������property 
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
     * Object:�ɱ�����'s �ӹ��ѿ�����property 
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
     * Object:�ɱ�����'s �ӹ����޸�property 
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
     * Object:�ɱ�����'s �ӹ��Ѷ���property 
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
     * Object:�ɱ�����'s �ӹ�������property 
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
     * Object:�ɱ�����'s �ӹ�������property 
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
     * Object:�ɱ�����'s �ӹ�����ֲproperty 
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
     * Object:�ɱ�����'s ������ֲproperty 
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
     * Object:�ɱ�����'s �������ν���property 
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
     * Object:�ɱ�����'s ���ĳ������property 
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
     * Object:�ɱ�����'s ���Ŀ�����property 
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
     * Object:�ɱ�����'s �����޸�property 
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
     * Object:�ɱ�����'s ���Ķ���property 
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
     * Object:�ɱ�����'s ��������property 
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
     * Object:�ɱ�����'s ����property 
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
    public java.math.BigDecimal getSumxhzz()
    {
        return getBigDecimal("sumxhzz");
    }
    public void setSumxhzz(java.math.BigDecimal item)
    {
        setBigDecimal("sumxhzz", item);
    }
    /**
     * Object:�ɱ�����'s �����������ν���property 
     */
    public java.math.BigDecimal getSumxhyxjz()
    {
        return getBigDecimal("sumxhyxjz");
    }
    public void setSumxhyxjz(java.math.BigDecimal item)
    {
        setBigDecimal("sumxhyxjz", item);
    }
    /**
     * Object:�ɱ�����'s �������ĳ������property 
     */
    public java.math.BigDecimal getSumxhcgjz()
    {
        return getBigDecimal("sumxhcgjz");
    }
    public void setSumxhcgjz(java.math.BigDecimal item)
    {
        setBigDecimal("sumxhcgjz", item);
    }
    /**
     * Object:�ɱ�����'s �������Ŀ�����property 
     */
    public java.math.BigDecimal getSumxhknw()
    {
        return getBigDecimal("sumxhknw");
    }
    public void setSumxhknw(java.math.BigDecimal item)
    {
        setBigDecimal("sumxhknw", item);
    }
    /**
     * Object:�ɱ�����'s ���������޸�property 
     */
    public java.math.BigDecimal getSumxhxf()
    {
        return getBigDecimal("sumxhxf");
    }
    public void setSumxhxf(java.math.BigDecimal item)
    {
        setBigDecimal("sumxhxf", item);
    }
    /**
     * Object:�ɱ�����'s �������Ķ���property 
     */
    public java.math.BigDecimal getSumxhey()
    {
        return getBigDecimal("sumxhey");
    }
    public void setSumxhey(java.math.BigDecimal item)
    {
        setBigDecimal("sumxhey", item);
    }
    /**
     * Object:�ɱ�����'s ������������property 
     */
    public java.math.BigDecimal getSumxhyz()
    {
        return getBigDecimal("sumxhyz");
    }
    public void setSumxhyz(java.math.BigDecimal item)
    {
        setBigDecimal("sumxhyz", item);
    }
    /**
     * Object:�ɱ�����'s ������������property 
     */
    public java.math.BigDecimal getSumxhmb()
    {
        return getBigDecimal("sumxhmb");
    }
    public void setSumxhmb(java.math.BigDecimal item)
    {
        setBigDecimal("sumxhmb", item);
    }
    /**
     * Object:�ɱ�����'s ���ܼӹ�����ֲproperty 
     */
    public java.math.BigDecimal getSumjgfzz()
    {
        return getBigDecimal("sumjgfzz");
    }
    public void setSumjgfzz(java.math.BigDecimal item)
    {
        setBigDecimal("sumjgfzz", item);
    }
    /**
     * Object:�ɱ�����'s ���ܼӹ������ν���property 
     */
    public java.math.BigDecimal getSumjgfyxjz()
    {
        return getBigDecimal("sumjgfyxjz");
    }
    public void setSumjgfyxjz(java.math.BigDecimal item)
    {
        setBigDecimal("sumjgfyxjz", item);
    }
    /**
     * Object:�ɱ�����'s ���ܼӹ��ѳ������property 
     */
    public java.math.BigDecimal getSumjgfcgjz()
    {
        return getBigDecimal("sumjgfcgjz");
    }
    public void setSumjgfcgjz(java.math.BigDecimal item)
    {
        setBigDecimal("sumjgfcgjz", item);
    }
    /**
     * Object:�ɱ�����'s ���ܼӹ��ѿ�����property 
     */
    public java.math.BigDecimal getSumjgfknw()
    {
        return getBigDecimal("sumjgfknw");
    }
    public void setSumjgfknw(java.math.BigDecimal item)
    {
        setBigDecimal("sumjgfknw", item);
    }
    /**
     * Object:�ɱ�����'s ���ܼӹ����޸�property 
     */
    public java.math.BigDecimal getSumjgfxf()
    {
        return getBigDecimal("sumjgfxf");
    }
    public void setSumjgfxf(java.math.BigDecimal item)
    {
        setBigDecimal("sumjgfxf", item);
    }
    /**
     * Object:�ɱ�����'s ���ܼӹ��Ѷ���property 
     */
    public java.math.BigDecimal getSumjgfey()
    {
        return getBigDecimal("sumjgfey");
    }
    public void setSumjgfey(java.math.BigDecimal item)
    {
        setBigDecimal("sumjgfey", item);
    }
    /**
     * Object:�ɱ�����'s ���ܼӹ�������property 
     */
    public java.math.BigDecimal getSumjgfmb()
    {
        return getBigDecimal("sumjgfmb");
    }
    public void setSumjgfmb(java.math.BigDecimal item)
    {
        setBigDecimal("sumjgfmb", item);
    }
    /**
     * Object:�ɱ�����'s ���ܼӹ�������property 
     */
    public java.math.BigDecimal getSumjgfyz()
    {
        return getBigDecimal("sumjgfyz");
    }
    public void setSumjgfyz(java.math.BigDecimal item)
    {
        setBigDecimal("sumjgfyz", item);
    }
    /**
     * Object:�ɱ�����'s �ӹ������ν����ϼ�property 
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
     * Object:�ɱ�����'s �ӹ��ѳ�������ϼ�property 
     */
    public java.math.BigDecimal getAlljgfcgjz()
    {
        return getBigDecimal("alljgfcgjz");
    }
    public void setAlljgfcgjz(java.math.BigDecimal item)
    {
        setBigDecimal("alljgfcgjz", item);
    }
    /**
     * Object:�ɱ�����'s �ӹ��ѿ�����ϼ�property 
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
     * Object:�ɱ�����'s �ӹ����޸��ϼ�property 
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
     * Object:�ɱ�����'s �ӹ��Ѷ����ϼ�property 
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
     * Object:�ɱ�����'s �ӹ������ܺϼ�property 
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
     * Object:�ɱ�����'s �ӹ������׺ϼ�property 
     */
    public java.math.BigDecimal getAlljgdmb()
    {
        return getBigDecimal("alljgdmb");
    }
    public void setAlljgdmb(java.math.BigDecimal item)
    {
        setBigDecimal("alljgdmb", item);
    }
    /**
     * Object:�ɱ�����'s �ӹ�����ֲ�ϼ�property 
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
     * Object:�ɱ�����'s ������ֲ�ϼ�property 
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
     * Object:�ɱ�����'s �������ν����ϼ�property 
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
     * Object:�ɱ�����'s ���ĳ�������ϼ�property 
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
     * Object:�ɱ�����'s ���Ŀ�����ϼ�property 
     */
    public java.math.BigDecimal getAllzhknw()
    {
        return getBigDecimal("allzhknw");
    }
    public void setAllzhknw(java.math.BigDecimal item)
    {
        setBigDecimal("allzhknw", item);
    }
    /**
     * Object:�ɱ�����'s �����޸��ϼ�property 
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
     * Object:�ɱ�����'s ���Ķ����ϼ�property 
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
     * Object:�ɱ�����'s �������ܺϼ�property 
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
     * Object:�ɱ�����'s �������׺ϼ�property 
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
     * Object: �ɱ����� 's ҽ�� property 
     */
    public com.kingdee.eas.basedata.person.PersonInfo getDoctor()
    {
        return (com.kingdee.eas.basedata.person.PersonInfo)get("doctor");
    }
    public void setDoctor(com.kingdee.eas.basedata.person.PersonInfo item)
    {
        put("doctor", item);
    }
    /**
     * Object:�ɱ�����'s ��עproperty 
     */
    public String getRemake()
    {
        return getString("remake");
    }
    public void setRemake(String item)
    {
        setString("remake", item);
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
        return new BOSObjectType("7A8DD31F");
    }
}