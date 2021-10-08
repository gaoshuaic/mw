package com.kingdee.eas.mw.pay;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractPaySheetDetailInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractPaySheetDetailInfo()
    {
        this("id");
    }
    protected AbstractPaySheetDetailInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object:���ʱ�����'s ����idproperty 
     */
    public String getCityid()
    {
        return getString("cityid");
    }
    public void setCityid(String item)
    {
        setString("cityid", item);
    }
    /**
     * Object:���ʱ�����'s ��˾idproperty 
     */
    public String getCompanyid()
    {
        return getString("companyid");
    }
    public void setCompanyid(String item)
    {
        setString("companyid", item);
    }
    /**
     * Object:���ʱ�����'s ��Աidproperty 
     */
    public String getPersonid()
    {
        return getString("personid");
    }
    public void setPersonid(String item)
    {
        setString("personid", item);
    }
    /**
     * Object:���ʱ�����'s �ɱ����ı���property 
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
     * Object:���ʱ�����'s ��Ա��λ����property 
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
     * Object:���ʱ�����'s �Ƿ�ͳ������property 
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
     * Object:���ʱ�����'s ҵ���ڼ�property 
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
     * Object:���ʱ�����'s ��������property 
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
     * Object:���ʱ�����'s ��Ʊ���property 
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
     * Object:���ʱ�����'s �ذ�ͨ���property 
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
     * Object:���ʱ�����'s ����˾���property 
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
     * Object:���ʱ�����'s ����ģʽ���property 
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
     * Object:���ʱ�����'s Ӧ˰����property 
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
     * Object:���ʱ�����'s ������property 
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
     * Object:���ʱ�����'s ��˾����property 
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
     * Object:���ʱ�����'s ��˾ҽ��property 
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
     * Object:���ʱ�����'s ��˾ʧҵproperty 
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
     * Object:���ʱ�����'s ��˾����property 
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
     * Object:���ʱ�����'s ��˾����property 
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
     * Object:���ʱ�����'s ��˾������property 
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
     * Object:���ʱ�����'s �����property 
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
     * Object:���ʱ�����'s ��������property 
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
     * Object:���ʱ�����'s ����ҽ��property 
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
     * Object:���ʱ�����'s ����ʧҵproperty 
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
     * Object:���ʱ�����'s ���˹�����property 
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
     * Object:���ʱ�����'s ��˰property 
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
     * Object:���ʱ�����'s ʵ��property 
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
     * Object:���ʱ�����'s ��˾��property 
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
     * Object:���ʱ�����'s �ù�״̬property 
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
     * Object:���ʱ�����'s ���б���property 
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
     * Object:���ʱ�����'s ��������property 
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
     * Object:���ʱ�����'s ��˾����property 
     */
    public String getCompanyNumber()
    {
        return getString("companyNumber");
    }
    public void setCompanyNumber(String item)
    {
        setString("companyNumber", item);
    }
    /**
     * Object:���ʱ�����'s ��˾����property 
     */
    public String getCompanyName()
    {
        return getString("companyName");
    }
    public void setCompanyName(String item)
    {
        setString("companyName", item);
    }
    /**
     * Object:���ʱ�����'s ��Ա����property 
     */
    public String getPersonNumber()
    {
        return getString("personNumber");
    }
    public void setPersonNumber(String item)
    {
        setString("personNumber", item);
    }
    /**
     * Object:���ʱ�����'s ��Ա����property 
     */
    public String getPersonName()
    {
        return getString("personName");
    }
    public void setPersonName(String item)
    {
        setString("personName", item);
    }
    /**
     * Object:���ʱ�����'s ְλproperty 
     */
    public String getPost()
    {
        return getString("post");
    }
    public void setPost(String item)
    {
        setString("post", item);
    }
    /**
     * Object:���ʱ�����'s ��Ա���property 
     */
    public String getPostType()
    {
        return getString("postType");
    }
    public void setPostType(String item)
    {
        setString("postType", item);
    }
    /**
     * Object:���ʱ�����'s ��ְ����property 
     */
    public String getIndate()
    {
        return getString("indate");
    }
    public void setIndate(String item)
    {
        setString("indate", item);
    }
    /**
     * Object:���ʱ�����'s ��ְ����property 
     */
    public String getLeaveDate()
    {
        return getString("leaveDate");
    }
    public void setLeaveDate(String item)
    {
        setString("leaveDate", item);
    }
    /**
     * Object:���ʱ�����'s ����property 
     */
    public java.math.BigDecimal getWorkYear()
    {
        return getBigDecimal("workYear");
    }
    public void setWorkYear(java.math.BigDecimal item)
    {
        setBigDecimal("workYear", item);
    }
    /**
     * Object:���ʱ�����'s ���ٹ��ʱ���property 
     */
    public java.math.BigDecimal getBingjiaPro()
    {
        return getBigDecimal("bingjiaPro");
    }
    public void setBingjiaPro(java.math.BigDecimal item)
    {
        setBigDecimal("bingjiaPro", item);
    }
    /**
     * Object:���ʱ�����'s ���֤����property 
     */
    public String getCardNumber()
    {
        return getString("cardNumber");
    }
    public void setCardNumber(String item)
    {
        setString("cardNumber", item);
    }
    /**
     * Object:���ʱ�����'s ��λ����property 
     */
    public java.math.BigDecimal getPostAllow()
    {
        return getBigDecimal("postAllow");
    }
    public void setPostAllow(java.math.BigDecimal item)
    {
        setBigDecimal("postAllow", item);
    }
    /**
     * Object:���ʱ�����'s ���䲹��property 
     */
    public java.math.BigDecimal getWorkYearAllow()
    {
        return getBigDecimal("workYearAllow");
    }
    public void setWorkYearAllow(java.math.BigDecimal item)
    {
        setBigDecimal("workYearAllow", item);
    }
    /**
     * Object:���ʱ�����'s ѧ��/ְ��/����/֤�����property 
     */
    public java.math.BigDecimal getLearnAllow()
    {
        return getBigDecimal("learnAllow");
    }
    public void setLearnAllow(java.math.BigDecimal item)
    {
        setBigDecimal("learnAllow", item);
    }
    /**
     * Object:���ʱ�����'s ��֤����property 
     */
    public java.math.BigDecimal getCardAllow()
    {
        return getBigDecimal("cardAllow");
    }
    public void setCardAllow(java.math.BigDecimal item)
    {
        setBigDecimal("cardAllow", item);
    }
    /**
     * Object:���ʱ�����'s ס������property 
     */
    public java.math.BigDecimal getHouseAllow()
    {
        return getBigDecimal("houseAllow");
    }
    public void setHouseAllow(java.math.BigDecimal item)
    {
        setBigDecimal("houseAllow", item);
    }
    /**
     * Object:���ʱ�����'s ��Ч����property 
     */
    public java.math.BigDecimal getAchieveMoney()
    {
        return getBigDecimal("achieveMoney");
    }
    public void setAchieveMoney(java.math.BigDecimal item)
    {
        setBigDecimal("achieveMoney", item);
    }
    /**
     * Object:���ʱ�����'s �¹���property 
     */
    public java.math.BigDecimal getMonthMoney()
    {
        return getBigDecimal("monthMoney");
    }
    public void setMonthMoney(java.math.BigDecimal item)
    {
        setBigDecimal("monthMoney", item);
    }
    /**
     * Object:���ʱ�����'s ȱ��property 
     */
    public java.math.BigDecimal getQueqin()
    {
        return getBigDecimal("queqin");
    }
    public void setQueqin(java.math.BigDecimal item)
    {
        setBigDecimal("queqin", item);
    }
    /**
     * Object:���ʱ�����'s �¼�property 
     */
    public java.math.BigDecimal getShijia()
    {
        return getBigDecimal("shijia");
    }
    public void setShijia(java.math.BigDecimal item)
    {
        setBigDecimal("shijia", item);
    }
    /**
     * Object:���ʱ�����'s ����property 
     */
    public java.math.BigDecimal getBingjia()
    {
        return getBigDecimal("bingjia");
    }
    public void setBingjia(java.math.BigDecimal item)
    {
        setBigDecimal("bingjia", item);
    }
    /**
     * Object:���ʱ�����'s ���ڿۿ�property 
     */
    public java.math.BigDecimal getKaoqinSub()
    {
        return getBigDecimal("kaoqinSub");
    }
    public void setKaoqinSub(java.math.BigDecimal item)
    {
        setBigDecimal("kaoqinSub", item);
    }
    /**
     * Object:���ʱ�����'s �ٵ��ۿ�property 
     */
    public java.math.BigDecimal getChidaoSub()
    {
        return getBigDecimal("chidaoSub");
    }
    public void setChidaoSub(java.math.BigDecimal item)
    {
        setBigDecimal("chidaoSub", item);
    }
    /**
     * Object:���ʱ�����'s �̶�����property 
     */
    public java.math.BigDecimal getGdAllow()
    {
        return getBigDecimal("gdAllow");
    }
    public void setGdAllow(java.math.BigDecimal item)
    {
        setBigDecimal("gdAllow", item);
    }
    /**
     * Object:���ʱ�����'s ȫ�ڽ�property 
     */
    public java.math.BigDecimal getAllWorkAllow()
    {
        return getBigDecimal("allWorkAllow");
    }
    public void setAllWorkAllow(java.math.BigDecimal item)
    {
        setBigDecimal("allWorkAllow", item);
    }
    /**
     * Object:���ʱ�����'s �ͷѲ���property 
     */
    public java.math.BigDecimal getFoodAllow()
    {
        return getBigDecimal("foodAllow");
    }
    public void setFoodAllow(java.math.BigDecimal item)
    {
        setBigDecimal("foodAllow", item);
    }
    /**
     * Object:���ʱ�����'s �Ӱ��property 
     */
    public java.math.BigDecimal getAddWorkAllow()
    {
        return getBigDecimal("addWorkAllow");
    }
    public void setAddWorkAllow(java.math.BigDecimal item)
    {
        setBigDecimal("addWorkAllow", item);
    }
    /**
     * Object:���ʱ�����'s ����property 
     */
    public java.math.BigDecimal getOther()
    {
        return getBigDecimal("other");
    }
    public void setOther(java.math.BigDecimal item)
    {
        setBigDecimal("other", item);
    }
    /**
     * Object:���ʱ�����'s �̶����ʺϼ�property 
     */
    public java.math.BigDecimal getGdMoney()
    {
        return getBigDecimal("gdMoney");
    }
    public void setGdMoney(java.math.BigDecimal item)
    {
        setBigDecimal("gdMoney", item);
    }
    /**
     * Object:���ʱ�����'s X-Ray����property 
     */
    public java.math.BigDecimal getXRayAllow()
    {
        return getBigDecimal("XRayAllow");
    }
    public void setXRayAllow(java.math.BigDecimal item)
    {
        setBigDecimal("XRayAllow", item);
    }
    /**
     * Object:���ʱ�����'s ѹĤ����������property 
     */
    public java.math.BigDecimal getHolderMoney()
    {
        return getBigDecimal("holderMoney");
    }
    public void setHolderMoney(java.math.BigDecimal item)
    {
        setBigDecimal("holderMoney", item);
    }
    /**
     * Object:���ʱ�����'s ҽ������property 
     */
    public java.math.BigDecimal getAssMoney()
    {
        return getBigDecimal("assMoney");
    }
    public void setAssMoney(java.math.BigDecimal item)
    {
        setBigDecimal("assMoney", item);
    }
    /**
     * Object:���ʱ�����'s �ܱ߲�Ʒ���property 
     */
    public java.math.BigDecimal getZbPro()
    {
        return getBigDecimal("zbPro");
    }
    public void setZbPro(java.math.BigDecimal item)
    {
        setBigDecimal("zbPro", item);
    }
    /**
     * Object:���ʱ�����'s �ŵ�֧Ԯproperty 
     */
    public java.math.BigDecimal getShopHelp()
    {
        return getBigDecimal("shopHelp");
    }
    public void setShopHelp(java.math.BigDecimal item)
    {
        setBigDecimal("shopHelp", item);
    }
    /**
     * Object:���ʱ�����'s ��ѯ�������property 
     */
    public java.math.BigDecimal getZxCard()
    {
        return getBigDecimal("zxCard");
    }
    public void setZxCard(java.math.BigDecimal item)
    {
        setBigDecimal("zxCard", item);
    }
    /**
     * Object:���ʱ�����'s �������property 
     */
    public java.math.BigDecimal getSplitUp()
    {
        return getBigDecimal("splitUp");
    }
    public void setSplitUp(java.math.BigDecimal item)
    {
        setBigDecimal("splitUp", item);
    }
    /**
     * Object:���ʱ�����'s ��ѯԤ��property 
     */
    public java.math.BigDecimal getZxLeave()
    {
        return getBigDecimal("zxLeave");
    }
    public void setZxLeave(java.math.BigDecimal item)
    {
        setBigDecimal("zxLeave", item);
    }
    /**
     * Object:���ʱ�����'s ҽ��Ԥ��property 
     */
    public java.math.BigDecimal getDocLeave()
    {
        return getBigDecimal("docLeave");
    }
    public void setDocLeave(java.math.BigDecimal item)
    {
        setBigDecimal("docLeave", item);
    }
    /**
     * Object:���ʱ�����'s ��������(������)property 
     */
    public java.math.BigDecimal getOtherWaiMoney()
    {
        return getBigDecimal("otherWaiMoney");
    }
    public void setOtherWaiMoney(java.math.BigDecimal item)
    {
        setBigDecimal("otherWaiMoney", item);
    }
    /**
     * Object:���ʱ�����'s �����뱣����Ŀ�ϼ�property 
     */
    public java.math.BigDecimal getWaiAllMoney()
    {
        return getBigDecimal("waiAllMoney");
    }
    public void setWaiAllMoney(java.math.BigDecimal item)
    {
        setBigDecimal("waiAllMoney", item);
    }
    /**
     * Object:���ʱ�����'s �г�����property 
     */
    public java.math.BigDecimal getMarktMoney()
    {
        return getBigDecimal("marktMoney");
    }
    public void setMarktMoney(java.math.BigDecimal item)
    {
        setBigDecimal("marktMoney", item);
    }
    /**
     * Object:���ʱ�����'s ��������property 
     */
    public java.math.BigDecimal getScalMoney()
    {
        return getBigDecimal("scalMoney");
    }
    public void setScalMoney(java.math.BigDecimal item)
    {
        setBigDecimal("scalMoney", item);
    }
    /**
     * Object:���ʱ�����'s �������׽���property 
     */
    public java.math.BigDecimal getMbAmount()
    {
        return getBigDecimal("mbAmount");
    }
    public void setMbAmount(java.math.BigDecimal item)
    {
        setBigDecimal("mbAmount", item);
    }
    /**
     * Object:���ʱ�����'s ҽ������property 
     */
    public java.math.BigDecimal getDocAmount()
    {
        return getBigDecimal("docAmount");
    }
    public void setDocAmount(java.math.BigDecimal item)
    {
        setBigDecimal("docAmount", item);
    }
    /**
     * Object:���ʱ�����'s �ͷ�����property 
     */
    public java.math.BigDecimal getKfAmount()
    {
        return getBigDecimal("kfAmount");
    }
    public void setKfAmount(java.math.BigDecimal item)
    {
        setBigDecimal("kfAmount", item);
    }
    /**
     * Object:���ʱ�����'s ������property 
     */
    public java.math.BigDecimal getHlAmount()
    {
        return getBigDecimal("hlAmount");
    }
    public void setHlAmount(java.math.BigDecimal item)
    {
        setBigDecimal("hlAmount", item);
    }
    /**
     * Object:���ʱ�����'s ��ѯʦ����property 
     */
    public java.math.BigDecimal getZxAmount()
    {
        return getBigDecimal("zxAmount");
    }
    public void setZxAmount(java.math.BigDecimal item)
    {
        setBigDecimal("zxAmount", item);
    }
    /**
     * Object:���ʱ�����'s �곤�ŵ��ɽ���property 
     */
    public java.math.BigDecimal getShopTarMoney()
    {
        return getBigDecimal("shopTarMoney");
    }
    public void setShopTarMoney(java.math.BigDecimal item)
    {
        setBigDecimal("shopTarMoney", item);
    }
    /**
     * Object:���ʱ�����'s �������𣨱����ڣ�property 
     */
    public java.math.BigDecimal getOtherNeiMoney()
    {
        return getBigDecimal("otherNeiMoney");
    }
    public void setOtherNeiMoney(java.math.BigDecimal item)
    {
        setBigDecimal("otherNeiMoney", item);
    }
    /**
     * Object:���ʱ�����'s ������Ŀ�ϼ�property 
     */
    public java.math.BigDecimal getBdProjectAll()
    {
        return getBigDecimal("bdProjectAll");
    }
    public void setBdProjectAll(java.math.BigDecimal item)
    {
        setBigDecimal("bdProjectAll", item);
    }
    /**
     * Object:���ʱ�����'s �±��׻���property 
     */
    public java.math.BigDecimal getMonthBase()
    {
        return getBigDecimal("monthBase");
    }
    public void setMonthBase(java.math.BigDecimal item)
    {
        setBigDecimal("monthBase", item);
    }
    /**
     * Object:���ʱ�����'s �±�����Ŀ����property 
     */
    public java.math.BigDecimal getBdMonthProject()
    {
        return getBigDecimal("bdMonthProject");
    }
    public void setBdMonthProject(java.math.BigDecimal item)
    {
        setBigDecimal("bdMonthProject", item);
    }
    /**
     * Object:���ʱ�����'s Ӧ����ɽ���ϼ�property 
     */
    public java.math.BigDecimal getPayble()
    {
        return getBigDecimal("payble");
    }
    public void setPayble(java.math.BigDecimal item)
    {
        setBigDecimal("payble", item);
    }
    /**
     * Object:���ʱ�����'s ��Ч�ϼ�property 
     */
    public java.math.BigDecimal getAchieveAll()
    {
        return getBigDecimal("achieveAll");
    }
    public void setAchieveAll(java.math.BigDecimal item)
    {
        setBigDecimal("achieveAll", item);
    }
    /**
     * Object:���ʱ�����'s �����׻���property 
     */
    public java.math.BigDecimal getSeaBase()
    {
        return getBigDecimal("seaBase");
    }
    public void setSeaBase(java.math.BigDecimal item)
    {
        setBigDecimal("seaBase", item);
    }
    /**
     * Object:���ʱ�����'s �����ײ���property 
     */
    public java.math.BigDecimal getSeaBuzu()
    {
        return getBigDecimal("seaBuzu");
    }
    public void setSeaBuzu(java.math.BigDecimal item)
    {
        setBigDecimal("seaBuzu", item);
    }
    /**
     * Object:���ʱ�����'s Ӧ������property 
     */
    public java.math.BigDecimal getShouldPay()
    {
        return getBigDecimal("shouldPay");
    }
    public void setShouldPay(java.math.BigDecimal item)
    {
        setBigDecimal("shouldPay", item);
    }
    /**
     * Object:���ʱ�����'s ʵ��Ӧ������property 
     */
    public java.math.BigDecimal getRealShouldPay()
    {
        return getBigDecimal("realShouldPay");
    }
    public void setRealShouldPay(java.math.BigDecimal item)
    {
        setBigDecimal("realShouldPay", item);
    }
    /**
     * Object:���ʱ�����'s ���˴�property 
     */
    public java.math.BigDecimal getPerDaBing()
    {
        return getBigDecimal("perDaBing");
    }
    public void setPerDaBing(java.math.BigDecimal item)
    {
        setBigDecimal("perDaBing", item);
    }
    /**
     * Object:���ʱ�����'s ���˺ϼ�property 
     */
    public java.math.BigDecimal getPerAll()
    {
        return getBigDecimal("perAll");
    }
    public void setPerAll(java.math.BigDecimal item)
    {
        setBigDecimal("perAll", item);
    }
    /**
     * Object:���ʱ�����'s ˰ǰ����property 
     */
    public java.math.BigDecimal getBeforeTaxMoney()
    {
        return getBigDecimal("beforeTaxMoney");
    }
    public void setBeforeTaxMoney(java.math.BigDecimal item)
    {
        setBigDecimal("beforeTaxMoney", item);
    }
    /**
     * Object:���ʱ�����'s ��˰���property 
     */
    public java.math.BigDecimal getFreeTaxMoney()
    {
        return getBigDecimal("freeTaxMoney");
    }
    public void setFreeTaxMoney(java.math.BigDecimal item)
    {
        setBigDecimal("freeTaxMoney", item);
    }
    /**
     * Object:���ʱ�����'s �ۼ�Ӧ˰���ö�property 
     */
    public java.math.BigDecimal getLjyssde()
    {
        return getBigDecimal("ljyssde");
    }
    public void setLjyssde(java.math.BigDecimal item)
    {
        setBigDecimal("ljyssde", item);
    }
    /**
     * Object:���ʱ�����'s ����ר��۳����property 
     */
    public java.math.BigDecimal getGrzxkcAmount()
    {
        return getBigDecimal("grzxkcAmount");
    }
    public void setGrzxkcAmount(java.math.BigDecimal item)
    {
        setBigDecimal("grzxkcAmount", item);
    }
    /**
     * Object:���ʱ�����'s Ӧ˰���ö�property 
     */
    public java.math.BigDecimal getYssde()
    {
        return getBigDecimal("yssde");
    }
    public void setYssde(java.math.BigDecimal item)
    {
        setBigDecimal("yssde", item);
    }
    /**
     * Object:���ʱ�����'s ˰��property 
     */
    public java.math.BigDecimal getTax()
    {
        return getBigDecimal("tax");
    }
    public void setTax(java.math.BigDecimal item)
    {
        setBigDecimal("tax", item);
    }
    /**
     * Object:���ʱ�����'s ����۳���property 
     */
    public java.math.BigDecimal getSjkcs()
    {
        return getBigDecimal("sjkcs");
    }
    public void setSjkcs(java.math.BigDecimal item)
    {
        setBigDecimal("sjkcs", item);
    }
    /**
     * Object:���ʱ�����'s �ۼƸ�������˰V2property 
     */
    public java.math.BigDecimal getLjgrsds()
    {
        return getBigDecimal("ljgrsds");
    }
    public void setLjgrsds(java.math.BigDecimal item)
    {
        setBigDecimal("ljgrsds", item);
    }
    /**
     * Object:���ʱ�����'s ���۵ĸ�������˰property 
     */
    public java.math.BigDecimal getDkgrsds()
    {
        return getBigDecimal("dkgrsds");
    }
    public void setDkgrsds(java.math.BigDecimal item)
    {
        setBigDecimal("dkgrsds", item);
    }
    /**
     * Object:���ʱ�����'s ��ά����property 
     */
    public java.math.BigDecimal getMwBase()
    {
        return getBigDecimal("mwBase");
    }
    public void setMwBase(java.math.BigDecimal item)
    {
        setBigDecimal("mwBase", item);
    }
    /**
     * Object:���ʱ�����'s �����ۿ�property 
     */
    public java.math.BigDecimal getDianpingSub()
    {
        return getBigDecimal("dianpingSub");
    }
    public void setDianpingSub(java.math.BigDecimal item)
    {
        setBigDecimal("dianpingSub", item);
    }
    /**
     * Object:���ʱ�����'s �ͷ�����property 
     */
    public java.math.BigDecimal getKfSub()
    {
        return getBigDecimal("kfSub");
    }
    public void setKfSub(java.math.BigDecimal item)
    {
        setBigDecimal("kfSub", item);
    }
    /**
     * Object:���ʱ�����'s ����˰�����property 
     */
    public java.math.BigDecimal getPayUp()
    {
        return getBigDecimal("payUp");
    }
    public void setPayUp(java.math.BigDecimal item)
    {
        setBigDecimal("payUp", item);
    }
    /**
     * Object:���ʱ�����'s ���ò�����property 
     */
    public java.math.BigDecimal getBuchangAmount()
    {
        return getBigDecimal("buchangAmount");
    }
    public void setBuchangAmount(java.math.BigDecimal item)
    {
        setBigDecimal("buchangAmount", item);
    }
    /**
     * Object:���ʱ�����'s ���ֺϼ�property 
     */
    public java.math.BigDecimal getJifenAll()
    {
        return getBigDecimal("jifenAll");
    }
    public void setJifenAll(java.math.BigDecimal item)
    {
        setBigDecimal("jifenAll", item);
    }
    /**
     * Object:���ʱ�����'s ��Ʊ������property 
     */
    public java.math.BigDecimal getTiepiaoSer()
    {
        return getBigDecimal("tiepiaoSer");
    }
    public void setTiepiaoSer(java.math.BigDecimal item)
    {
        setBigDecimal("tiepiaoSer", item);
    }
    /**
     * Object:���ʱ�����'s �ذ�ͨ������property 
     */
    public java.math.BigDecimal getGuanaitongSer()
    {
        return getBigDecimal("guanaitongSer");
    }
    public void setGuanaitongSer(java.math.BigDecimal item)
    {
        setBigDecimal("guanaitongSer", item);
    }
    /**
     * Object:���ʱ�����'s ����ģʽ������property 
     */
    public java.math.BigDecimal getOtherSer()
    {
        return getBigDecimal("otherSer");
    }
    public void setOtherSer(java.math.BigDecimal item)
    {
        setBigDecimal("otherSer", item);
    }
    /**
     * Object:���ʱ�����'s �����Ѻϼ�property 
     */
    public java.math.BigDecimal getServiceAll()
    {
        return getBigDecimal("serviceAll");
    }
    public void setServiceAll(java.math.BigDecimal item)
    {
        setBigDecimal("serviceAll", item);
    }
    /**
     * Object:���ʱ�����'s Ӧ�����ս���property 
     */
    public java.math.BigDecimal getShouldYearBouns()
    {
        return getBigDecimal("shouldYearBouns");
    }
    public void setShouldYearBouns(java.math.BigDecimal item)
    {
        setBigDecimal("shouldYearBouns", item);
    }
    /**
     * Object:���ʱ�����'s ���ս���˰property 
     */
    public java.math.BigDecimal getYearTax()
    {
        return getBigDecimal("yearTax");
    }
    public void setYearTax(java.math.BigDecimal item)
    {
        setBigDecimal("yearTax", item);
    }
    /**
     * Object:���ʱ�����'s ���ս���ʵ��property 
     */
    public java.math.BigDecimal getRealyearAmount()
    {
        return getBigDecimal("realyearAmount");
    }
    public void setRealyearAmount(java.math.BigDecimal item)
    {
        setBigDecimal("realyearAmount", item);
    }
    /**
     * Object:���ʱ�����'s ʵ���ϼ�property 
     */
    public java.math.BigDecimal getRealAmount()
    {
        return getBigDecimal("realAmount");
    }
    public void setRealAmount(java.math.BigDecimal item)
    {
        setBigDecimal("realAmount", item);
    }
    /**
     * Object:���ʱ�����'s ˰��property 
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
     * Object:���ʱ�����'s ��˾����һ��ϼ�property 
     */
    public java.math.BigDecimal getComAll()
    {
        return getBigDecimal("comAll");
    }
    public void setComAll(java.math.BigDecimal item)
    {
        setBigDecimal("comAll", item);
    }
    /**
     * Object:���ʱ�����'s LCproperty 
     */
    public java.math.BigDecimal getLC()
    {
        return getBigDecimal("LC");
    }
    public void setLC(java.math.BigDecimal item)
    {
        setBigDecimal("LC", item);
    }
    /**
     * Object:���ʱ�����'s ��������property 
     */
    public java.math.BigDecimal getBasemoney()
    {
        return getBigDecimal("basemoney");
    }
    public void setBasemoney(java.math.BigDecimal item)
    {
        setBigDecimal("basemoney", item);
    }
    /**
     * Object:���ʱ�����'s ��̯����property 
     */
    public java.math.BigDecimal getFentanother()
    {
        return getBigDecimal("fentanother");
    }
    public void setFentanother(java.math.BigDecimal item)
    {
        setBigDecimal("fentanother", item);
    }
    /**
     * Object:���ʱ�����'s ���ս���̯/12property 
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
     * Object:���ʱ�����'s ���Ƚ����̯/3property 
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
     * Object:���ʱ�����'s ���ս����ŵ���property 
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
     * Object:���ʱ�����'s ���Ƚ��𷢷ŵ���property 
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
     * Object:���ʱ�����'s �¶������ɱ��ܶ�property 
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
     * Object:���ʱ�����'s ҽ���ɱ�property 
     */
    public java.math.BigDecimal getDocAssCost()
    {
        return getBigDecimal("docAssCost");
    }
    public void setDocAssCost(java.math.BigDecimal item)
    {
        setBigDecimal("docAssCost", item);
    }
    /**
     * Object:���ʱ�����'s �ŵ�ҵ�����property 
     */
    public java.math.BigDecimal getClinicAchiMoney()
    {
        return getBigDecimal("clinicAchiMoney");
    }
    public void setClinicAchiMoney(java.math.BigDecimal item)
    {
        setBigDecimal("clinicAchiMoney", item);
    }
    /**
     * Object:���ʱ�����'s ҽ��תҽ������property 
     */
    public java.math.BigDecimal getAssToDoc()
    {
        return getBigDecimal("assToDoc");
    }
    public void setAssToDoc(java.math.BigDecimal item)
    {
        setBigDecimal("assToDoc", item);
    }
    /**
     * Object:���ʱ�����'s ���׽���property 
     */
    public java.math.BigDecimal getBaoDiBonus()
    {
        return getBigDecimal("BaoDiBonus");
    }
    public void setBaoDiBonus(java.math.BigDecimal item)
    {
        setBigDecimal("BaoDiBonus", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("4104607A");
    }
}