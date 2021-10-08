package com.kingdee.eas.mw.pay;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractPayShareDetailInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractPayShareDetailInfo()
    {
        this("id");
    }
    protected AbstractPayShareDetailInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object:��̯��ϸ��'s �ɱ����ı���property 
     */
    public String getCostCenterNumber()
    {
        return getString("costCenterNumber");
    }
    public void setCostCenterNumber(String item)
    {
        setString("costCenterNumber", item);
    }
    /**
     * Object:��̯��ϸ��'s ��Ա��λ����property 
     */
    public String getPostTypeNumber()
    {
        return getString("postTypeNumber");
    }
    public void setPostTypeNumber(String item)
    {
        setString("postTypeNumber", item);
    }
    /**
     * Object:��̯��ϸ��'s �Ƿ�ͳ������property 
     */
    public String getIscount()
    {
        return getString("iscount");
    }
    public void setIscount(String item)
    {
        setString("iscount", item);
    }
    /**
     * Object:��̯��ϸ��'s ҵ���ڼ�property 
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
     * Object:��̯��ϸ��'s ��������property 
     */
    public java.math.BigDecimal getJibengongzi()
    {
        return getBigDecimal("jibengongzi");
    }
    public void setJibengongzi(java.math.BigDecimal item)
    {
        setBigDecimal("jibengongzi", item);
    }
    /**
     * Object:��̯��ϸ��'s ����property 
     */
    public java.math.BigDecimal getQita()
    {
        return getBigDecimal("qita");
    }
    public void setQita(java.math.BigDecimal item)
    {
        setBigDecimal("qita", item);
    }
    /**
     * Object:��̯��ϸ��'s �̶�����property 
     */
    public java.math.BigDecimal getGudingmoney()
    {
        return getBigDecimal("gudingmoney");
    }
    public void setGudingmoney(java.math.BigDecimal item)
    {
        setBigDecimal("gudingmoney", item);
    }
    /**
     * Object:��̯��ϸ��'s ���׽���property 
     */
    public java.math.BigDecimal getBaodiMoney()
    {
        return getBigDecimal("baodiMoney");
    }
    public void setBaodiMoney(java.math.BigDecimal item)
    {
        setBigDecimal("baodiMoney", item);
    }
    /**
     * Object:��̯��ϸ��'s ��������property 
     */
    public java.math.BigDecimal getFudongMoney()
    {
        return getBigDecimal("fudongMoney");
    }
    public void setFudongMoney(java.math.BigDecimal item)
    {
        setBigDecimal("fudongMoney", item);
    }
    /**
     * Object:��̯��ϸ��'s ���׽�����property 
     */
    public java.math.BigDecimal getBaodibuzu()
    {
        return getBigDecimal("baodibuzu");
    }
    public void setBaodibuzu(java.math.BigDecimal item)
    {
        setBigDecimal("baodibuzu", item);
    }
    /**
     * Object:��̯��ϸ��'s ����ϼ�property 
     */
    public java.math.BigDecimal getJiangjinAll()
    {
        return getBigDecimal("jiangjinAll");
    }
    public void setJiangjinAll(java.math.BigDecimal item)
    {
        setBigDecimal("jiangjinAll", item);
    }
    /**
     * Object:��̯��ϸ��'s Ӧ������property 
     */
    public java.math.BigDecimal getYingfaMoney()
    {
        return getBigDecimal("yingfaMoney");
    }
    public void setYingfaMoney(java.math.BigDecimal item)
    {
        setBigDecimal("yingfaMoney", item);
    }
    /**
     * Object:��̯��ϸ��'s ��Ʊ���property 
     */
    public java.math.BigDecimal getTiepiao()
    {
        return getBigDecimal("tiepiao");
    }
    public void setTiepiao(java.math.BigDecimal item)
    {
        setBigDecimal("tiepiao", item);
    }
    /**
     * Object:��̯��ϸ��'s �ذ�ͨ���property 
     */
    public java.math.BigDecimal getGuaiaitong()
    {
        return getBigDecimal("guaiaitong");
    }
    public void setGuaiaitong(java.math.BigDecimal item)
    {
        setBigDecimal("guaiaitong", item);
    }
    /**
     * Object:��̯��ϸ��'s ����˾���property 
     */
    public java.math.BigDecimal getLaowuMoney()
    {
        return getBigDecimal("laowuMoney");
    }
    public void setLaowuMoney(java.math.BigDecimal item)
    {
        setBigDecimal("laowuMoney", item);
    }
    /**
     * Object:��̯��ϸ��'s ����ģʽ���property 
     */
    public java.math.BigDecimal getQitamoshi()
    {
        return getBigDecimal("qitamoshi");
    }
    public void setQitamoshi(java.math.BigDecimal item)
    {
        setBigDecimal("qitamoshi", item);
    }
    /**
     * Object:��̯��ϸ��'s Ӧ˰����property 
     */
    public java.math.BigDecimal getYingshuiMoney()
    {
        return getBigDecimal("yingshuiMoney");
    }
    public void setYingshuiMoney(java.math.BigDecimal item)
    {
        setBigDecimal("yingshuiMoney", item);
    }
    /**
     * Object:��̯��ϸ��'s ������property 
     */
    public java.math.BigDecimal getShouxufei()
    {
        return getBigDecimal("shouxufei");
    }
    public void setShouxufei(java.math.BigDecimal item)
    {
        setBigDecimal("shouxufei", item);
    }
    /**
     * Object:��̯��ϸ��'s ��˾����property 
     */
    public java.math.BigDecimal getComyanglao()
    {
        return getBigDecimal("comyanglao");
    }
    public void setComyanglao(java.math.BigDecimal item)
    {
        setBigDecimal("comyanglao", item);
    }
    /**
     * Object:��̯��ϸ��'s ��˾ҽ��property 
     */
    public java.math.BigDecimal getComyiliao()
    {
        return getBigDecimal("comyiliao");
    }
    public void setComyiliao(java.math.BigDecimal item)
    {
        setBigDecimal("comyiliao", item);
    }
    /**
     * Object:��̯��ϸ��'s ��˾ʧҵproperty 
     */
    public java.math.BigDecimal getComshiye()
    {
        return getBigDecimal("comshiye");
    }
    public void setComshiye(java.math.BigDecimal item)
    {
        setBigDecimal("comshiye", item);
    }
    /**
     * Object:��̯��ϸ��'s ��˾����property 
     */
    public java.math.BigDecimal getComgongshang()
    {
        return getBigDecimal("comgongshang");
    }
    public void setComgongshang(java.math.BigDecimal item)
    {
        setBigDecimal("comgongshang", item);
    }
    /**
     * Object:��̯��ϸ��'s ��˾����property 
     */
    public java.math.BigDecimal getComshengyu()
    {
        return getBigDecimal("comshengyu");
    }
    public void setComshengyu(java.math.BigDecimal item)
    {
        setBigDecimal("comshengyu", item);
    }
    /**
     * Object:��̯��ϸ��'s ��˾������property 
     */
    public java.math.BigDecimal getComgongjijin()
    {
        return getBigDecimal("comgongjijin");
    }
    public void setComgongjijin(java.math.BigDecimal item)
    {
        setBigDecimal("comgongjijin", item);
    }
    /**
     * Object:��̯��ϸ��'s �����property 
     */
    public java.math.BigDecimal getFuwufei()
    {
        return getBigDecimal("fuwufei");
    }
    public void setFuwufei(java.math.BigDecimal item)
    {
        setBigDecimal("fuwufei", item);
    }
    /**
     * Object:��̯��ϸ��'s ˰��property 
     */
    public java.math.BigDecimal getShuijin()
    {
        return getBigDecimal("shuijin");
    }
    public void setShuijin(java.math.BigDecimal item)
    {
        setBigDecimal("shuijin", item);
    }
    /**
     * Object:��̯��ϸ��'s ��˾�籣������С��property 
     */
    public java.math.BigDecimal getComshebaoAll()
    {
        return getBigDecimal("comshebaoAll");
    }
    public void setComshebaoAll(java.math.BigDecimal item)
    {
        setBigDecimal("comshebaoAll", item);
    }
    /**
     * Object:��̯��ϸ��'s ��ά����property 
     */
    public java.math.BigDecimal getMwMoney()
    {
        return getBigDecimal("mwMoney");
    }
    public void setMwMoney(java.math.BigDecimal item)
    {
        setBigDecimal("mwMoney", item);
    }
    /**
     * Object:��̯��ϸ��'s ˰������property 
     */
    public java.math.BigDecimal getShuihouqita()
    {
        return getBigDecimal("shuihouqita");
    }
    public void setShuihouqita(java.math.BigDecimal item)
    {
        setBigDecimal("shuihouqita", item);
    }
    /**
     * Object:��̯��ϸ��'s ���ò�����property 
     */
    public java.math.BigDecimal getJingjibuchang()
    {
        return getBigDecimal("jingjibuchang");
    }
    public void setJingjibuchang(java.math.BigDecimal item)
    {
        setBigDecimal("jingjibuchang", item);
    }
    /**
     * Object:��̯��ϸ��'s �¶������ɱ�property 
     */
    public java.math.BigDecimal getYuefurenli()
    {
        return getBigDecimal("yuefurenli");
    }
    public void setYuefurenli(java.math.BigDecimal item)
    {
        setBigDecimal("yuefurenli", item);
    }
    /**
     * Object:��̯��ϸ��'s �¶������ɱ��ܶ�property 
     */
    public java.math.BigDecimal getYuedurenliAll()
    {
        return getBigDecimal("yuedurenliAll");
    }
    public void setYuedurenliAll(java.math.BigDecimal item)
    {
        setBigDecimal("yuedurenliAll", item);
    }
    /**
     * Object:��̯��ϸ��'s ��������property 
     */
    public java.math.BigDecimal getPerYanglao()
    {
        return getBigDecimal("perYanglao");
    }
    public void setPerYanglao(java.math.BigDecimal item)
    {
        setBigDecimal("perYanglao", item);
    }
    /**
     * Object:��̯��ϸ��'s ����ҽ��property 
     */
    public java.math.BigDecimal getPerYiliao()
    {
        return getBigDecimal("perYiliao");
    }
    public void setPerYiliao(java.math.BigDecimal item)
    {
        setBigDecimal("perYiliao", item);
    }
    /**
     * Object:��̯��ϸ��'s ����ʧҵproperty 
     */
    public java.math.BigDecimal getPerShiye()
    {
        return getBigDecimal("perShiye");
    }
    public void setPerShiye(java.math.BigDecimal item)
    {
        setBigDecimal("perShiye", item);
    }
    /**
     * Object:��̯��ϸ��'s ���˹�����property 
     */
    public java.math.BigDecimal getPerGongjijin()
    {
        return getBigDecimal("perGongjijin");
    }
    public void setPerGongjijin(java.math.BigDecimal item)
    {
        setBigDecimal("perGongjijin", item);
    }
    /**
     * Object:��̯��ϸ��'s ��˰property 
     */
    public java.math.BigDecimal getGeshui()
    {
        return getBigDecimal("geshui");
    }
    public void setGeshui(java.math.BigDecimal item)
    {
        setBigDecimal("geshui", item);
    }
    /**
     * Object:��̯��ϸ��'s ʵ��property 
     */
    public java.math.BigDecimal getShifa()
    {
        return getBigDecimal("shifa");
    }
    public void setShifa(java.math.BigDecimal item)
    {
        setBigDecimal("shifa", item);
    }
    /**
     * Object:��̯��ϸ��'s ���ս���̯/12property 
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
     * Object:��̯��ϸ��'s ���Ƚ����̯/3property 
     */
    public java.math.BigDecimal getJidufentan()
    {
        return getBigDecimal("jidufentan");
    }
    public void setJidufentan(java.math.BigDecimal item)
    {
        setBigDecimal("jidufentan", item);
    }
    /**
     * Object:��̯��ϸ��'s ���ս����ŵ���property 
     */
    public java.math.BigDecimal getNianzhong()
    {
        return getBigDecimal("nianzhong");
    }
    public void setNianzhong(java.math.BigDecimal item)
    {
        setBigDecimal("nianzhong", item);
    }
    /**
     * Object:��̯��ϸ��'s ���Ƚ��𷢷ŵ���property 
     */
    public java.math.BigDecimal getJidu()
    {
        return getBigDecimal("jidu");
    }
    public void setJidu(java.math.BigDecimal item)
    {
        setBigDecimal("jidu", item);
    }
    /**
     * Object:��̯��ϸ��'s ��˾��property 
     */
    public java.math.BigDecimal getComdabing()
    {
        return getBigDecimal("comdabing");
    }
    public void setComdabing(java.math.BigDecimal item)
    {
        setBigDecimal("comdabing", item);
    }
    /**
     * Object:��̯��ϸ��'s �ù�״̬property 
     */
    public String getEmptype()
    {
        return getString("emptype");
    }
    public void setEmptype(String item)
    {
        setString("emptype", item);
    }
    /**
     * Object:��̯��ϸ��'s ��Ʊ������property 
     */
    public java.math.BigDecimal getTPShouxufei()
    {
        return getBigDecimal("TPShouxufei");
    }
    public void setTPShouxufei(java.math.BigDecimal item)
    {
        setBigDecimal("TPShouxufei", item);
    }
    /**
     * Object:��̯��ϸ��'s �ذ�ͨ������property 
     */
    public java.math.BigDecimal getGATShouxufei()
    {
        return getBigDecimal("GATShouxufei");
    }
    public void setGATShouxufei(java.math.BigDecimal item)
    {
        setBigDecimal("GATShouxufei", item);
    }
    /**
     * Object:��̯��ϸ��'s ����������property 
     */
    public java.math.BigDecimal getLWShouxufei()
    {
        return getBigDecimal("LWShouxufei");
    }
    public void setLWShouxufei(java.math.BigDecimal item)
    {
        setBigDecimal("LWShouxufei", item);
    }
    /**
     * Object:��̯��ϸ��'s ����������property 
     */
    public java.math.BigDecimal getQTShouxufei()
    {
        return getBigDecimal("QTShouxufei");
    }
    public void setQTShouxufei(java.math.BigDecimal item)
    {
        setBigDecimal("QTShouxufei", item);
    }
    /**
     * Object: ��̯��ϸ�� 's ���� property 
     */
    public com.kingdee.eas.basedata.org.CtrlUnitInfo getThiscity()
    {
        return (com.kingdee.eas.basedata.org.CtrlUnitInfo)get("thiscity");
    }
    public void setThiscity(com.kingdee.eas.basedata.org.CtrlUnitInfo item)
    {
        put("thiscity", item);
    }
    /**
     * Object: ��̯��ϸ�� 's ��˾ property 
     */
    public com.kingdee.eas.basedata.org.CompanyOrgUnitInfo getCom()
    {
        return (com.kingdee.eas.basedata.org.CompanyOrgUnitInfo)get("com");
    }
    public void setCom(com.kingdee.eas.basedata.org.CompanyOrgUnitInfo item)
    {
        put("com", item);
    }
    /**
     * Object: ��̯��ϸ�� 's ��Ա property 
     */
    public com.kingdee.eas.basedata.person.PersonInfo getPer()
    {
        return (com.kingdee.eas.basedata.person.PersonInfo)get("per");
    }
    public void setPer(com.kingdee.eas.basedata.person.PersonInfo item)
    {
        put("per", item);
    }
    /**
     * Object: ��̯��ϸ�� 's �ɱ����� property 
     */
    public com.kingdee.eas.mw.srqr.CostCenterInfo getCost()
    {
        return (com.kingdee.eas.mw.srqr.CostCenterInfo)get("cost");
    }
    public void setCost(com.kingdee.eas.mw.srqr.CostCenterInfo item)
    {
        put("cost", item);
    }
    /**
     * Object: ��̯��ϸ�� 's ��λ property 
     */
    public com.kingdee.eas.mw.srqr.PostTypeInfo getPost()
    {
        return (com.kingdee.eas.mw.srqr.PostTypeInfo)get("post");
    }
    public void setPost(com.kingdee.eas.mw.srqr.PostTypeInfo item)
    {
        put("post", item);
    }
    /**
     * Object:��̯��ϸ��'s ���˴�property 
     */
    public java.math.BigDecimal getPerDabing()
    {
        return getBigDecimal("perDabing");
    }
    public void setPerDabing(java.math.BigDecimal item)
    {
        setBigDecimal("perDabing", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("1CE472FA");
    }
}