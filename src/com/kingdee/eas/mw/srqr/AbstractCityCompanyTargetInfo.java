package com.kingdee.eas.mw.srqr;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractCityCompanyTargetInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractCityCompanyTargetInfo()
    {
        this("id");
    }
    protected AbstractCityCompanyTargetInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: ���й�˾Ŀ�� 's ���� property 
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
     * Object: ���й�˾Ŀ�� 's ��˾ property 
     */
    public com.kingdee.eas.basedata.org.CompanyOrgUnitInfo getCompany()
    {
        return (com.kingdee.eas.basedata.org.CompanyOrgUnitInfo)get("company");
    }
    public void setCompany(com.kingdee.eas.basedata.org.CompanyOrgUnitInfo item)
    {
        put("company", item);
    }
    /**
     * Object:���й�˾Ŀ��'s ����property 
     */
    public java.math.BigDecimal getPersonNum()
    {
        return getBigDecimal("personNum");
    }
    public void setPersonNum(java.math.BigDecimal item)
    {
        setBigDecimal("personNum", item);
    }
    /**
     * Object:���й�˾Ŀ��'s Ŀ��ҵ��property 
     */
    public java.math.BigDecimal getTarachieve()
    {
        return getBigDecimal("tarachieve");
    }
    public void setTarachieve(java.math.BigDecimal item)
    {
        setBigDecimal("tarachieve", item);
    }
    /**
     * Object:���й�˾Ŀ��'s Ԥ��ɱ�property 
     */
    public java.math.BigDecimal getBudcost()
    {
        return getBigDecimal("budcost");
    }
    public void setBudcost(java.math.BigDecimal item)
    {
        setBigDecimal("budcost", item);
    }
    /**
     * Object:���й�˾Ŀ��'s ����property 
     */
    public com.kingdee.eas.mw.pay.app.BudgeType getType()
    {
        return com.kingdee.eas.mw.pay.app.BudgeType.getEnum(getString("type"));
    }
    public void setType(com.kingdee.eas.mw.pay.app.BudgeType item)
    {
		if (item != null) {
        setString("type", item.getValue());
		}
    }
    /**
     * Object:���й�˾Ŀ��'s ҽ��(��Ժ��)����property 
     */
    public java.math.BigDecimal getYlyz()
    {
        return getBigDecimal("ylyz");
    }
    public void setYlyz(java.math.BigDecimal item)
    {
        setBigDecimal("ylyz", item);
    }
    /**
     * Object:���й�˾Ŀ��'s ҽ��(�ж�����������=ҽ��)����property 
     */
    public java.math.BigDecimal getYzys()
    {
        return getBigDecimal("yzys");
    }
    public void setYzys(java.math.BigDecimal item)
    {
        setBigDecimal("yzys", item);
    }
    /**
     * Object:���й�˾Ŀ��'s רְ������ʿ����property 
     */
    public java.math.BigDecimal getZzjyhs()
    {
        return getBigDecimal("zzjyhs");
    }
    public void setZzjyhs(java.math.BigDecimal item)
    {
        setBigDecimal("zzjyhs", item);
    }
    /**
     * Object:���й�˾Ŀ��'s ��ѯ(���곤����ҽ)����property 
     */
    public java.math.BigDecimal getZx()
    {
        return getBigDecimal("zx");
    }
    public void setZx(java.math.BigDecimal item)
    {
        setBigDecimal("zx", item);
    }
    /**
     * Object:���й�˾Ŀ��'s ����(�����ڡ�ҽ��)����property 
     */
    public java.math.BigDecimal getQt()
    {
        return getBigDecimal("qt");
    }
    public void setQt(java.math.BigDecimal item)
    {
        setBigDecimal("qt", item);
    }
    /**
     * Object:���й�˾Ŀ��'s ����(����)����property 
     */
    public java.math.BigDecimal getHq()
    {
        return getBigDecimal("hq");
    }
    public void setHq(java.math.BigDecimal item)
    {
        setBigDecimal("hq", item);
    }
    /**
     * Object:���й�˾Ŀ��'s ҽ��(�޶�����������=��ʿ)����property 
     */
    public java.math.BigDecimal getYzhs()
    {
        return getBigDecimal("yzhs");
    }
    public void setYzhs(java.math.BigDecimal item)
    {
        setBigDecimal("yzhs", item);
    }
    /**
     * Object:���й�˾Ŀ��'s ����(����������������)����property 
     */
    public java.math.BigDecimal getHl()
    {
        return getBigDecimal("hl");
    }
    public void setHl(java.math.BigDecimal item)
    {
        setBigDecimal("hl", item);
    }
    /**
     * Object:���й�˾Ŀ��'s �ͷ�(��������ǰ̨)����property 
     */
    public java.math.BigDecimal getKf()
    {
        return getBigDecimal("kf");
    }
    public void setKf(java.math.BigDecimal item)
    {
        setBigDecimal("kf", item);
    }
    /**
     * Object:���й�˾Ŀ��'s ������������property 
     */
    public java.math.BigDecimal getRlxz()
    {
        return getBigDecimal("rlxz");
    }
    public void setRlxz(java.math.BigDecimal item)
    {
        setBigDecimal("rlxz", item);
    }
    /**
     * Object:���й�˾Ŀ��'s ҽ��(����)����property 
     */
    public java.math.BigDecimal getYh()
    {
        return getBigDecimal("yh");
    }
    public void setYh(java.math.BigDecimal item)
    {
        setBigDecimal("yh", item);
    }
    /**
     * Object:���й�˾Ŀ��'s �ܾ������property 
     */
    public java.math.BigDecimal getZjb()
    {
        return getBigDecimal("zjb");
    }
    public void setZjb(java.math.BigDecimal item)
    {
        setBigDecimal("zjb", item);
    }
    /**
     * Object:���й�˾Ŀ��'s �������property 
     */
    public java.math.BigDecimal getCw()
    {
        return getBigDecimal("cw");
    }
    public void setCw(java.math.BigDecimal item)
    {
        setBigDecimal("cw", item);
    }
    /**
     * Object:���й�˾Ŀ��'s �󻮱���property 
     */
    public java.math.BigDecimal getQh()
    {
        return getBigDecimal("qh");
    }
    public void setQh(java.math.BigDecimal item)
    {
        setBigDecimal("qh", item);
    }
    /**
     * Object:���й�˾Ŀ��'s ��������property 
     */
    public java.math.BigDecimal getQd()
    {
        return getBigDecimal("qd");
    }
    public void setQd(java.math.BigDecimal item)
    {
        setBigDecimal("qd", item);
    }
    /**
     * Object:���й�˾Ŀ��'s ������ѯ����property 
     */
    public java.math.BigDecimal getWdzx()
    {
        return getBigDecimal("wdzx");
    }
    public void setWdzx(java.math.BigDecimal item)
    {
        setBigDecimal("wdzx", item);
    }
    /**
     * Object:���й�˾Ŀ��'s �������property 
     */
    public java.math.BigDecimal getWl()
    {
        return getBigDecimal("wl");
    }
    public void setWl(java.math.BigDecimal item)
    {
        setBigDecimal("wl", item);
    }
    /**
     * Object:���й�˾Ŀ��'s ��ý�����property 
     */
    public java.math.BigDecimal getXmt()
    {
        return getBigDecimal("xmt");
    }
    public void setXmt(java.math.BigDecimal item)
    {
        setBigDecimal("xmt", item);
    }
    /**
     * Object:���й�˾Ŀ��'s ҵ������property 
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
     * Object:���й�˾Ŀ��'s �ɹ�����property 
     */
    public java.math.BigDecimal getCg()
    {
        return getBigDecimal("cg");
    }
    public void setCg(java.math.BigDecimal item)
    {
        setBigDecimal("cg", item);
    }
    /**
     * Object:���й�˾Ŀ��'s սͶ������property 
     */
    public java.math.BigDecimal getZtb()
    {
        return getBigDecimal("ztb");
    }
    public void setZtb(java.math.BigDecimal item)
    {
        setBigDecimal("ztb", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("14463D07");
    }
}