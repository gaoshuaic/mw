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
     * Object:分摊明细表's 成本中心编码property 
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
     * Object:分摊明细表's 人员岗位编码property 
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
     * Object:分摊明细表's 是否统计人数property 
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
     * Object:分摊明细表's 业务期间property 
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
     * Object:分摊明细表's 基本工资property 
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
     * Object:分摊明细表's 其他property 
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
     * Object:分摊明细表's 固定工资property 
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
     * Object:分摊明细表's 保底奖金property 
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
     * Object:分摊明细表's 浮动奖金property 
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
     * Object:分摊明细表's 保底奖金补足property 
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
     * Object:分摊明细表's 奖金合计property 
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
     * Object:分摊明细表's 应发工资property 
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
     * Object:分摊明细表's 贴票金额property 
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
     * Object:分摊明细表's 关爱通金额property 
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
     * Object:分摊明细表's 劳务公司金额property 
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
     * Object:分摊明细表's 其他模式金额property 
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
     * Object:分摊明细表's 应税工资property 
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
     * Object:分摊明细表's 手续费property 
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
     * Object:分摊明细表's 公司养老property 
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
     * Object:分摊明细表's 公司医疗property 
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
     * Object:分摊明细表's 公司失业property 
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
     * Object:分摊明细表's 公司工伤property 
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
     * Object:分摊明细表's 公司生育property 
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
     * Object:分摊明细表's 公司公积金property 
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
     * Object:分摊明细表's 服务费property 
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
     * Object:分摊明细表's 税金property 
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
     * Object:分摊明细表's 公司社保公积金小计property 
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
     * Object:分摊明细表's 美维基金property 
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
     * Object:分摊明细表's 税后其他property 
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
     * Object:分摊明细表's 经济补偿金property 
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
     * Object:分摊明细表's 月度人力成本property 
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
     * Object:分摊明细表's 月度人力成本总额property 
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
     * Object:分摊明细表's 个人养老property 
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
     * Object:分摊明细表's 个人医疗property 
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
     * Object:分摊明细表's 个人失业property 
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
     * Object:分摊明细表's 个人公积金property 
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
     * Object:分摊明细表's 个税property 
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
     * Object:分摊明细表's 实发property 
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
     * Object:分摊明细表's 年终奖分摊/12property 
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
     * Object:分摊明细表's 季度奖金分摊/3property 
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
     * Object:分摊明细表's 年终奖发放当月property 
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
     * Object:分摊明细表's 季度奖金发放当月property 
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
     * Object:分摊明细表's 公司大病property 
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
     * Object:分摊明细表's 用工状态property 
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
     * Object:分摊明细表's 贴票手续费property 
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
     * Object:分摊明细表's 关爱通手续费property 
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
     * Object:分摊明细表's 劳务手续费property 
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
     * Object:分摊明细表's 其他手续费property 
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
     * Object: 分摊明细表 's 城市 property 
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
     * Object: 分摊明细表 's 公司 property 
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
     * Object: 分摊明细表 's 人员 property 
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
     * Object: 分摊明细表 's 成本中心 property 
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
     * Object: 分摊明细表 's 岗位 property 
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
     * Object:分摊明细表's 个人大病property 
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