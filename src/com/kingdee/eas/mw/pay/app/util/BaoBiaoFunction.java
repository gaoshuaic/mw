package com.kingdee.eas.mw.pay.app.util;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.eas.base.core.fm.ContextHelperFactory;
import com.kingdee.eas.basedata.framework.app.ParallelSqlExecutor;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.jdbc.rowset.IRowSet;

public class BaoBiaoFunction {


	public  void setCityBaoBiao(Context ctx, String businessDate ,String cityId) {
		try {
			System.out.println("=======================setCityBaoBiao:"+cityId);
		    String userId = ContextHelperFactory.getLocalInstance(ctx).getCurrentUser().getId().toString(); 
		    
		    //查询需要薪酬统计的城市
        	String citySql = " /*dialect*/select distinct unit.fid as id ,unit.fnumber as fnumber ,unit.fname_l2 as name "+
        		"from CT_PAY_PayCity paycity left join T_ORG_BaseUnit unit on paycity.cfcityid = unit.fid "
        		+" where paycity. fsimplename = '1'"; // and  paycity.cfcityid = 'DeJU1u+zSN+d41DA4hTamsznrtQ='
        	if(cityId.length() > 0 ){
        		citySql = citySql + "  and  paycity.cfcityid = '"+cityId+"' ";
        	}
        	
        	IRowSet cityrow = DbUtil.executeQuery(ctx, citySql );
        	while (cityrow.next()) { 
        		String cityNumber = cityrow.getString("FNUMBER"); 
            	String cityName = cityrow.getString("NAME"); 
            	String cityID = cityrow.getString("ID"); 
            	String existIs = "/*dialect*/ select count(1) as C from   T_HR_SCMPCALTABLE where FHRORGUNITID = '"+cityID+"' and FPERIODYEAR  = "+businessDate.substring(0, 4)+" and FPERIODMONTH = "+businessDate.substring(4,6)+" ";
            	IRowSet existrow = DbUtil.executeQuery(ctx, existIs );
            	boolean flag = false;
            	while (existrow.next()) { 
            		String count = existrow.getString("C"); 
            		if(count !=null && !count.equals("")&&  !count.equals("0")){
            			flag = true;
            		}
            	} 
            	if( cityID.equals("DeJU1u+zSN+d41DA4hTamsznrtQ=")  && flag){
            		baobiaoBeiJing(ctx,cityID,businessDate,userId);
            		
            	}else if(!cityID.equals("DeJU1u+zSN+d41DA4hTamsznrtQ=")  && flag){
            		baobiaoShanghai(ctx,cityID,businessDate,userId);
            	}
        	} 
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private void baobiaoBeiJing(Context ctx, String cityID,String businessDate,String userId) throws Exception {

    	
	    
		String deleteSql = "/*dialect*/ delete  CT_PAY_PayShareDetail  where cfthiscityid = '"+cityID+"' and cfbusinessdate  = '"+businessDate +"' ";
    	DbUtil.execute(ctx, deleteSql ); 
		
    	
    	HashMap<String,String> costMap = new HashMap<String,String>();
    	StringBuffer  costSql = new StringBuffer().append(" /*dialect*/SELECT  fid ,fnumber from  CT_SRQ_CostCenter "); 
    	IRowSet costrow = DbUtil.executeQuery(ctx, costSql.toString() );
    	while (costrow.next()) { 
    		costMap.put(costrow.getString("FNUMBER"), costrow.getString("FID"));
    	}
    	
    	HashMap<String,String> postMap = new HashMap<String,String>();
    	StringBuffer   postSql = new StringBuffer().append(" /*dialect*/SELECT  fid ,fnumber from  CT_SRQ_PostType "); 
    	IRowSet  postrow = DbUtil.executeQuery(ctx,  postSql.toString() );
    	while (postrow.next()) { 
    		postMap.put(postrow.getString("FNUMBER"), postrow.getString("FID"));
    	}
    	 
    	//组织层级   城市  --区域  -- 公司  -- 其他 -- 部门 
    	
    	//城市 - 公司  - 部门
    	String sql = "select  count(1) as C  FROM  T_HR_SCMPCALTABLE scmptable inner join T_ORG_BaseUnit dep on dep.fid = scmptable.FCostBearOrgID "+
    				" inner join T_ORG_BaseUnit company on company.fid = dep.fparentid   and company.fparentid =  '"+cityID+"' "+
    				" where scmptable.FHRORGUNITID  = '"+cityID+"' and  scmptable.FPERIODYEAR = "+businessDate.substring(0,4)+" and scmptable.FPERIODMONTH = "+businessDate.substring(4,6)+" ";
    	IRowSet tablerow = DbUtil.executeQuery(ctx, sql.toString() );
    	while (tablerow.next()) { //238
    		int count = tablerow.getInt("C");
    		if(count > 0){
    			doOtherCityBaoBiao(ctx,cityID,businessDate,userId,costMap,postMap," baseunit.fparentid as COMPANYID "," inner join T_ORG_BaseUnit baseunit on baseunit.fid = scmptable.FCostBearOrgID  inner join T_ORG_BaseUnit company on company.fid = baseunit.fparentid  and company.FPARENTID  = '"+cityID+"'  ");
    		}
    	}
    	//城市 - 公司   - 其他- 部门
    	sql = "select  count(1) as C  FROM  T_HR_SCMPCALTABLE scmptable inner join T_ORG_BaseUnit dep on dep.fid = scmptable.FCostBearOrgID "+
    				" inner join T_ORG_BaseUnit qita on qita.fid = dep.fparentid  "+
    				" inner join T_ORG_BaseUnit company on company.fid = qita.fparentid   and company.fparentid =  '"+cityID+"' "+
    				" where scmptable.FHRORGUNITID  = '"+cityID+"' and  scmptable.FPERIODYEAR = "+businessDate.substring(0,4)+" and scmptable.FPERIODMONTH = "+businessDate.substring(4,6)+" ";
    	tablerow = DbUtil.executeQuery(ctx, sql.toString() );
    	while (tablerow.next()) { 
    		int count = tablerow.getInt("C");
    		if(count > 0){
    			doOtherCityBaoBiao(ctx,cityID,businessDate,userId,costMap,postMap," baseunit.fparentid as COMPANYID ",
    					" inner join T_ORG_BaseUnit dep on dep.fid = scmptable.FCostBearOrgID inner join T_ORG_BaseUnit baseunit on baseunit.fid = dep.fparentid   inner join T_ORG_BaseUnit company on company.fid = baseunit.fparentid  and company.FPARENTID  = '"+cityID+"' ");
    		}
    		
    	}
    	//城市 - 公司  
    	sql = "select  count(1) as C  FROM  T_HR_SCMPCALTABLE scmptable inner join T_ORG_BaseUnit company on company.fid = scmptable.FCostBearOrgID   and company.fparentid =  '"+cityID+"' "+
    				" where scmptable.FHRORGUNITID  = '"+cityID+"' and  scmptable.FPERIODYEAR = "+businessDate.substring(0,4)+" and scmptable.FPERIODMONTH = "+businessDate.substring(4,6)+" ";
    	tablerow = DbUtil.executeQuery(ctx, sql.toString() );
    	while (tablerow.next()) { 
    		int count = tablerow.getInt("C");
    		if(count > 0){
    			doOtherCityBaoBiao(ctx,cityID,businessDate,userId,costMap,postMap," baseunit.fid as COMPANYID "," inner join T_ORG_BaseUnit baseunit on baseunit.fid = scmptable.FCostBearOrgID  and baseunit.FPARENTID  = '"+cityID+"'  ");
    		}
    	}
		
	}
	
    private void doOtherCityBaoBiao(Context ctx, String cityID,String businessDate,String userId,HashMap<String,String> costMap,HashMap<String,String> postMap,String sqlCompany,String sqlgetCompany)throws Exception {
    	ExecutorService pool = Executors.newFixedThreadPool(6);
	    ParallelSqlExecutor pe = new ParallelSqlExecutor(pool); 
    	
    	StringBuffer  tableSql = new StringBuffer()
    	//( case when  baseunit.FPARENTID  =  '"+cityID+"' then  baseunit.fid else baseunit.FPARENTID end  ) as COMPANYID
    	.append(" /*dialect*/SELECT scmptable.FPERSONID ,scmptable.fname_l2 , "+sqlCompany+",postType.fnumber as POSTTYPENUMBER  , costCenter.fnumber as  COSTCENTERNUMBER , (case when  emptype.fnumber in  ('001','002','007','S04','009') then 'S001'  when  emptype.fnumber in ('003','004','005','006','011','012','013','020','021','030','031','036','S01','S02','S03','S05','S06','S07','S08','S10','S11','S12') then 'S002'   end ) as TYPENUMBER, ").append("\r\n") 
    	//20210303   固定工资基数  被替换成  实际基本薪资    实际补贴  实际绩效奖金    S116  -->S97 S99  S101  nvl(S97,0)+nvl(S99,0)+nvl(S101,0)
    	//.append(" nvl(S97,0) as GUDINGGONGZI , (nvl(S97,0)+nvl(S99,0)+nvl(S101,0)-nvl(S218,0)-nvl(S129,0)+nvl(S67,0)+nvl(S115,0)+nvl(S147,0)+nvl(S225,0)+nvl(S226,0)-nvl(S97,0)) as QITA ,(nvl(S97,0)+nvl(S99,0)+nvl(S101,0)-nvl(S218,0)-nvl(S129,0)+nvl(S67,0)+nvl(S115,0)+nvl(S147,0)+nvl(S225,0)+nvl(S226,0)) as DUDINGGONGZI,  ") .append("\r\n") 
    	.append(" nvl(S97,0) as GUDINGGONGZI ,  ") .append("\r\n")
    	.append(" (nvl(S104,0)-nvl(S103,0)-nvl(S97,0)) as QITA , ") .append("\r\n")
    	.append(" (nvl(S104,0)-nvl(S103,0)) as DUDINGGONGZI,  ") .append("\r\n")
    	
    	.append(" nvl(S125,0) as BAODI , nvl(S200,0) as FUDONG ,nvl(S134,0) as BAODIBUZU , nvl(S134,0)+nvl(S200,0) as JIANGJINHEJI , ") .append("\r\n") 
    	
    	//(nvl(S97,0)+nvl(S99,0)+nvl(S101,0)-nvl(S218,0)-nvl(S129,0)+nvl(S67,0)+nvl(S115,0)+nvl(S147,0)+nvl(S225,0)+nvl(S226,0)+nvl(S134,0)+nvl(S200,0)) as  YINGFAGONGZI, 
    	.append(" nvl(S104,0) as  YINGFAGONGZI,  ") .append("\r\n") 
    	
    	.append(" nvl(S141,0) as TIEPIAO , nvl(S207,0) as GUANAITONG , nvl(S143,0) as LAOWUGONGSI , nvl(S213,0) as QITAMOSHI ,   ") .append("\r\n") 
    	// (nvl(S97,0)+nvl(S99,0)+nvl(S101,0)-nvl(S218,0)-nvl(S129,0)+nvl(S67,0)+nvl(S115,0)+nvl(S147,0)+nvl(S225,0)+nvl(S226,0) +nvl(S134,0)+nvl(S200,0)-nvl(S141,0)-nvl(S207,0)-nvl(S143,0)-nvl(S213,0)) as YINGSHUIGONGZI   ,
    	.append(" nvl(S105,0) as  YINGSHUIGONGZI , ") .append("\r\n") 
    	
    	.append(" nvl(S214,0) as SHOUXUFEI,nvl(S179,0) as GONGSIYANGLAO,nvl(S180,0)+ nvl(S295,0) as GONGSIYILIAO,nvl(S181,0) as GONGSISHIYE,nvl(S182,0) as GONGSIGONGSHANG,nvl(S183,0) as GONGSISHENGYU,nvl(S206,0) as QIYEDABING,nvl(S186,0) as GONGSIGONGJIJIN,nvl(S303,0) as FUWUFEI,nvl(S138,0) as SHUIJIN,nvl(S252,0)  as GONGSIXIAOJI,  ") .append("\r\n") 
    	
    	.append(" nvl(S89,0) as MWJIJIN,nvl(S66,0) as SHUIHOUQITA,nvl(S135,0) as JINGJIBUCHANGJIN,  ") .append("\r\n") 
    	//(nvl(S97,0)+nvl(S99,0)+nvl(S101,0)-nvl(S218,0)-nvl(S129,0)+nvl(S67,0)+nvl(S115,0)+nvl(S147,0)+nvl(S225,0)+nvl(S226,0)+nvl(S134,0)+nvl(S200,0)+nvl(S214,0)+nvl(S252,0) ) as YUDURENLI,
    	.append("  nvl(S139,0) as YUDURENLI,  ") .append("\r\n") 
    	//.append(" (nvl(S97,0)+nvl(S99,0)+nvl(S101,0)-nvl(S218,0)-nvl(S129,0)+nvl(S67,0)+nvl(S115,0)+nvl(S147,0)+nvl(S225,0)+nvl(S226,0)+nvl(S134,0)+nvl(S200,0)+nvl(S214,0)+nvl(S252,0) +nvl(S216,0)+nvl(S217,0)) as YUDURENLIALL,
    	.append("  (nvl(S139,0)+nvl(S216,0)+nvl(S217,0)) as YUDURENLIALL,  ") .append("\r\n") 
    	.append("  nvl(S174,0) as GERENYANGLAO,nvl(S175,0) as GERENYILIAO,   ") .append("\r\n") 
    	.append(" nvl(S176,0) as GERENSHIYE, nvl(S205,0) as GERENDABING, nvl(S177,0) as GERENGONGJIJIN,nvl(S187,0) as GESHUI,   ") .append("\r\n") 
    	//.append(" (nvl(S97,0)+nvl(S99,0)+nvl(S101,0)-nvl(S218,0)-nvl(S129,0)+nvl(S67,0)+nvl(S115,0)+nvl(S147,0)+nvl(S225,0)+nvl(S226,0) +nvl(S134,0)+nvl(S200,0)-nvl(S174,0)-nvl(S175,0)-nvl(S176,0)-nvl(S205,0)-nvl(S177,0)-nvl(S187,0)+nvl(S89,0)-nvl(S141,0)-nvl(S207,0)-nvl(S143,0)-nvl(S213,0)) as SHIFA  ") .append("\r\n")
    	.append(" (nvl(S111,0)) as SHIFA  ") .append("\r\n")
    	.append("  ,nvl(S296,0) as TPSHOUXUFEI,nvl(S302,0) as GATSHOUXUFEI,nvl(S145,0) as LWSHOUXUFEI,nvl(S297,0) as QTSHOUXUFEI, nvl(S106,0) as YEARSENDMONTH,nvl(S219,0) as QUASENDMONTH ,nvl(S216,0) as NINAZHONGFENTAN, nvl(S217,0) as JIDUFENTAN ").append("\r\n") // 年终奖金发放当月    季度奖金发放当月   年终奖金分摊 季度奖金分摊
    	
    	.append(" FROM  T_HR_SCMPCALTABLE  scmptable  ").append("\r\n") 
    	.append(" inner join T_BD_Person person  on person.fid = scmptable.FPERSONID   inner join T_HR_BDEmployeeType emptype on  emptype.fid = scmptable.FEMPLOYEETYPEID  ").append("\r\n") 
    	//.append(" inner join T_ORG_BaseUnit baseunit on baseunit.fid = scmptable.FCostBearOrgID or ( scmptable.FCostBearOrgID =baseunit.fid and baseunit.FPARENTID  =  '"+cityID+"')   ").append("\r\n") 
    	.append( sqlgetCompany ).append("\r\n")
    	
    	//.append(" inner join  CT_SRQ_StaffCityCostRelevance perrelevance on   person.fid   = perrelevance.cfpersonid and  perrelevance.cfcityid = '"+cityID+"'  ").append("\r\n") 
    	//.append(" inner join CT_SRQ_CostCenter  costCenter on perrelevance.cfCostCenterid = costCenter.fid  inner join CT_SRQ_PostType postType   on  perrelevance.CFPostTypeID = postType.fid    ").append("\r\n") 
    	 
    	
    	.append(" inner join CT_SRQ_CostCenter  costCenter on person.cfcostcenterid = costCenter.fid  inner join CT_SRQ_PostType postType   on  person.cfpostTypeid = postType.fid    ") .append("\r\n") 
    	.append(" where scmptable.FHRORGUNITID  = '"+cityID+"' and  scmptable.FPERIODYEAR = "+businessDate.substring(0,4)+" and scmptable.FPERIODMONTH = "+businessDate.substring(4,6)+" ").append("\r\n") 
    	.append(" and person.CFPOSTTYPEID is not null and  person.CFCOSTCENTERID   is not null  ");
    	//System.out.print(tableSql.toString());
    	IRowSet tablerow = DbUtil.executeQuery(ctx, tableSql.toString() );
    	while (tablerow.next()) { 
    		BigDecimal bili = BigDecimal.ONE;
    		//人员id
    		String personid = tablerow.getString("FPERSONID");
    		String personname = tablerow.getString("FNAME_L2");
    		String company = tablerow.getString("COMPANYID");
    		String postTypeNumber = tablerow.getString("POSTTYPENUMBER");
    		String costCenterNumber = tablerow.getString("COSTCENTERNUMBER"); 
    		//用工关系状态
    		String empTypeNumber = tablerow.getString("TYPENUMBER");  
    		//基本工资
    		BigDecimal jibenMoney =tablerow.getBigDecimal("GUDINGGONGZI"); 
    		//其他
    		BigDecimal qita = tablerow.getBigDecimal("QITA"); 
    		//固定工资
    		BigDecimal gudingMoney = tablerow.getBigDecimal("DUDINGGONGZI");   
    		
    		//保底奖金
    		BigDecimal baodiMoney = tablerow.getBigDecimal("BAODI"); 
    		//浮动奖金 
    		BigDecimal fudongMoney = tablerow.getBigDecimal("FUDONG"); 
    		//保底奖金补足
    		BigDecimal baodibuzuMoney = tablerow.getBigDecimal("BAODIBUZU");  
    		//奖金合计
    		BigDecimal jiangjinMoney = tablerow.getBigDecimal("JIANGJINHEJI"); 
    		//应发工资小计  ==========
    		BigDecimal yingfaMoney = tablerow.getBigDecimal("YINGFAGONGZI");   
    		
    		//贴票金额
    		BigDecimal tiepiao = tablerow.getBigDecimal("TIEPIAO"); 
    		//关爱通金额
    		BigDecimal guanaitong = tablerow.getBigDecimal("GUANAITONG"); 
    		//劳务公司金额
    		BigDecimal laowugongsi = tablerow.getBigDecimal("LAOWUGONGSI");  
    		//其他模式金额
    		BigDecimal qitamoshi = tablerow.getBigDecimal("QITAMOSHI"); 
    		//应税工资==============
    		BigDecimal yingshuigongzi = tablerow.getBigDecimal("YINGSHUIGONGZI");    
    		 
    		 
    		//贴票手续费
     		BigDecimal tpshouxufei = tablerow.getBigDecimal("TPSHOUXUFEI");  
    		//关爱通手续费
     		BigDecimal gatshouxufei = tablerow.getBigDecimal("GATSHOUXUFEI");  
     		//劳务手续费
    		BigDecimal lwshouxufei = tablerow.getBigDecimal("LWSHOUXUFEI");  
    		//其他手续费
    		BigDecimal qtshouxufei = tablerow.getBigDecimal("QTSHOUXUFEI");  
    		
    		//手续费
    		BigDecimal shouxufei = tablerow.getBigDecimal("SHOUXUFEI");  
    		
    		//公司养老
    		BigDecimal comyanglao = tablerow.getBigDecimal("GONGSIYANGLAO");  
    		//公司医疗
    		BigDecimal comyiliao = tablerow.getBigDecimal("GONGSIYILIAO");  
    		//公司失业
    		BigDecimal comshiye = tablerow.getBigDecimal("GONGSISHIYE");  
    		//公司工伤
    		BigDecimal comgongshang = tablerow.getBigDecimal("GONGSIGONGSHANG");  
    		//公司生育
    		BigDecimal comshengyu = tablerow.getBigDecimal("GONGSISHENGYU");  
    		//企业大病
    		BigDecimal comdabing = tablerow.getBigDecimal("QIYEDABING");   
    		//公司公积金
    		BigDecimal comgongjijin = tablerow.getBigDecimal("GONGSIGONGJIJIN");  
    		//服务费
    		BigDecimal fuwufei = tablerow.getBigDecimal("FUWUFEI");  
    		//税金
    		BigDecimal shuijin = tablerow.getBigDecimal("SHUIJIN");  
    		//公司社保公积金小计
    		BigDecimal comall = tablerow.getBigDecimal("GONGSIXIAOJI");   
    		
    		
    		
    		//美维基金
    		BigDecimal mwjijin = tablerow.getBigDecimal("MWJIJIN");  
    		//税后其他
    		BigDecimal shuihouqita = tablerow.getBigDecimal("SHUIHOUQITA");  
    		//经济补偿金
    		BigDecimal jingjinbuchang = tablerow.getBigDecimal("JINGJIBUCHANGJIN");  
    		//月度人力成本==================
    		BigDecimal yuedurenli = tablerow.getBigDecimal("YUDURENLI");   
    		//月度人力成本总额=============
    		BigDecimal yuedurenliAll = tablerow.getBigDecimal("YUDURENLIALL");  
    		
    		//个人养老
    		BigDecimal personYanglao = tablerow.getBigDecimal("GERENYANGLAO");  
    		//个人医疗
    		BigDecimal personYiliao = tablerow.getBigDecimal("GERENYILIAO");   
    		
    		//个人失业
    		BigDecimal personShiye = tablerow.getBigDecimal("GERENSHIYE"); 
    		
    		//个人大病
    		BigDecimal personDabing = tablerow.getBigDecimal("GERENDABING");  
    		//个人公积金
    		BigDecimal personGongjijin = tablerow.getBigDecimal("GERENGONGJIJIN"); 
    		//个税
    		BigDecimal personShui = tablerow.getBigDecimal("GESHUI"); 
    		//年终奖分摊
    		BigDecimal nianzhongfentan = tablerow.getBigDecimal("NINAZHONGFENTAN"); 
    		//季度奖金分摊
    		BigDecimal jidufentan = tablerow.getBigDecimal("JIDUFENTAN");  
    		//实发=======================
    		BigDecimal shifa = tablerow.getBigDecimal("SHIFA"); 
    		
    		//年终奖发放当月
    		BigDecimal yearSendMonth = tablerow.getBigDecimal("YEARSENDMONTH");  
    		//季度奖金发放当月
    		BigDecimal quaSendMonth = tablerow.getBigDecimal("QUASENDMONTH");  
    		
    		//年终奖分摊
    		BigDecimal yearFenTan = tablerow.getBigDecimal("NINAZHONGFENTAN");  
    		//季度奖金分摊
    		BigDecimal jiduFenTan = tablerow.getBigDecimal("JIDUFENTAN");  
    		 
    		StringBuffer  fentanSql = new StringBuffer(); 
        	fentanSql.append("/*dialect*/ SELECT fentan.CFCompanyID ,fentan.CFPersonID,costCenter.fnumber as COSTNUMBER ,postType.FNUMBER AS POSTNUMBER,fentan.CFMoney ,nvl( fentan.FSIMPLENAME,'') as FSIMPNAME from  CT_SRQ_FenTanAchieve fentan ")
        	.append(" inner join CT_SRQ_CostCenter  costCenter on fentan.CFCostCenterID = costCenter.fid  inner join CT_SRQ_PostType postType   on  fentan.CFPostTypeID = postType.fid    ")
        	.append("  where  fentan.cfcityid =  '"+cityID+"' and  fentan.CFBusinessdate ='"+businessDate+"'  and  fentan.cfpersonid = '"+personid+"' ");
        	IRowSet fentanPersonrow = DbUtil.executeQuery(ctx, fentanSql.toString() );
        	while (fentanPersonrow.next()) { 
        		String companyid = fentanPersonrow.getObject("CFCOMPANYID") ==null?"":fentanPersonrow.getString("CFCOMPANYID"); 
        		String costNumber = fentanPersonrow.getObject("COSTNUMBER") ==null?"":fentanPersonrow.getString("COSTNUMBER");
        		String postNumber = fentanPersonrow.getObject("POSTNUMBER") ==null?"":fentanPersonrow.getString("POSTNUMBER");
        		String biliStr = fentanPersonrow.getObject("CFMONEY") ==null?"":fentanPersonrow.getString("CFMONEY");
        		String type = fentanPersonrow.getObject("FSIMPNAME") ==null?"":fentanPersonrow.getString("FSIMPNAME"); 

        		if(!costCenterNumber.equals("MZ")){
        			companyid.equals("");
        		}
        		
        		BigDecimal jibenMoney1 = jibenMoney;
        		BigDecimal qita1 = qita;
        		BigDecimal gudingMoney1 = gudingMoney; 
			 		
        		String empTypeNumber1 = empTypeNumber;
        		
        		//如果为兼职  个人 公司 相关扣款是0
    			//贴票金额
    			BigDecimal tiepiao1 = BigDecimal.ZERO;
        		//关爱通金额
    			BigDecimal guanaitong1 = BigDecimal.ZERO;
        		//劳务公司金额
    			BigDecimal laowugongsi1 = BigDecimal.ZERO;
        		//其他模式金额
    			BigDecimal qitamoshi1 = BigDecimal.ZERO;
    			
    			//贴票手续费
         		BigDecimal tpshouxufei1 = BigDecimal.ZERO;
        		//关爱通手续费
         		BigDecimal gatshouxufei1 = BigDecimal.ZERO;
         		//劳务手续费
        		BigDecimal lwshouxufei1 = BigDecimal.ZERO;
        		//其他手续费
        		BigDecimal qtshouxufei1 = BigDecimal.ZERO;
    			//手续费
    			BigDecimal shouxufei1 = BigDecimal.ZERO;
        		//公司养老
    			BigDecimal comyanglao1 = BigDecimal.ZERO;
        		//公司医疗
    			BigDecimal comyiliao1 = BigDecimal.ZERO;
        		//公司失业
    			BigDecimal comshiye1 = BigDecimal.ZERO;
        		//公司工伤
    			BigDecimal comgongshang1 = BigDecimal.ZERO;
        		//公司生育
    			BigDecimal comshengyu1 = BigDecimal.ZERO;
        		//企业大病
    			BigDecimal comdabing1 = BigDecimal.ZERO;  
        		//公司公积金
    			BigDecimal comgongjijin1 = BigDecimal.ZERO;
        		//服务费
    			BigDecimal fuwufei1 = BigDecimal.ZERO;
        		//税金
    			BigDecimal shuijin1 = BigDecimal.ZERO;
        		//公司社保公积金小计
    			BigDecimal comall1 = BigDecimal.ZERO; 
        		//美维基金
    			BigDecimal mwjijin1 = BigDecimal.ZERO;
        		//税后其他
    			BigDecimal shuihouqita1 = BigDecimal.ZERO;
        		//经济补偿金
    			BigDecimal jingjinbuchang1 = BigDecimal.ZERO;
        		//个人养老
    			BigDecimal personYanglao1 = BigDecimal.ZERO;
        		//个人医疗
    			BigDecimal personYiliao1 = BigDecimal.ZERO;
        		//个人失业
    			BigDecimal personShiye1 = BigDecimal.ZERO;
    			//个人大病
        		BigDecimal personDabing1 = BigDecimal.ZERO;
        		//个人公积金
    			BigDecimal personGongjijin1 = BigDecimal.ZERO;
        		//个税
    			BigDecimal personShui1 = BigDecimal.ZERO;
        		//年终奖分摊==============暂定不拆分
    			BigDecimal nianzhongfentan1 = BigDecimal.ZERO;
        		//季度奖金分摊==================暂定不拆分
    			BigDecimal jidufentan1 = BigDecimal.ZERO;
    			
        		//年终奖发放当月
        		BigDecimal yearSendMonth1 = BigDecimal.ZERO;
        		//季度奖金发放当月
        		BigDecimal quaSendMonth1 = BigDecimal.ZERO;
        		
        		String coungPerson = "";
        		//主成本中心是门诊 并且成本中心  岗位  公司都可以对应上   ||  主成本中心不是门诊 并且成本中心  岗位   可以对应上    说明是主  需要记录人数
        		if( (costCenterNumber.equals("MZ")&&costCenterNumber.equals(costNumber)  && postTypeNumber.equals(postNumber) && company.equals(companyid))
        				|| (!costCenterNumber.equals("MZ")&&costCenterNumber.equals(costNumber)  && postTypeNumber.equals(postNumber) ) ){
        			//需要统计人数
        			coungPerson = "1"; 
        			tiepiao1 = tiepiao; 
        			guanaitong1 = guanaitong; 
        			laowugongsi1 = laowugongsi; 
        			qitamoshi1 = qitamoshi; 
        			shouxufei1 = shouxufei; 
        			comyanglao1 = comyanglao; 
        			comyiliao1 = comyiliao; 
        			comshiye1 = comshiye; 
        			comgongshang1 = comgongshang; 
        			comshengyu1 = comshengyu; 
        			comdabing1 = comdabing;   
        			comgongjijin1 = comgongjijin; 
        			fuwufei1 = fuwufei; 
        			shuijin1 = shuijin; 
        			comall1 = comall;  
        			mwjijin1 = mwjijin; 
        			shuihouqita1 = shuihouqita; 
        			jingjinbuchang1 = jingjinbuchang;
        			personYanglao1 = personYanglao; 
        			personYiliao1 = personYiliao; 
        			personShiye1 = personShiye; 
        			personDabing1 = personDabing;
        			personGongjijin1 = personGongjijin; 
        			personShui1 = personShui; 
        			nianzhongfentan1 = nianzhongfentan; 
        			jidufentan1 = jidufentan;
        		}else{
        			//empTypeNumber1 = "S002";
        			jibenMoney1 = BigDecimal.ZERO;
   			 		qita1 = BigDecimal.ZERO;
   			 		gudingMoney1 = BigDecimal.ZERO;
        		}
        		
        		//存在就拆分
        		BigDecimal baodiMoney1 = getMathBybili(baodiMoney,biliStr);
        		BigDecimal fudongMoney1 = getMathBybili(fudongMoney,biliStr);
        		BigDecimal baodibuzuMoney1 = getMathBybili(baodibuzuMoney,biliStr);
        		BigDecimal jiangjinMoney1 = getMathBybili(jiangjinMoney,biliStr);
   			 	
        		//判断是什么拆分 
   			 	if(type == null  || type.equals("")){//奖金拆分
       			 	/*baodiMoney = getMathBybili(baodiMoney,biliStr);
       			 	fudongMoney = getMathBybili(fudongMoney,biliStr);
       			 	baodibuzuMoney = getMathBybili(baodibuzuMoney,biliStr);
       			 	jiangjinMoney = getMathBybili(jiangjinMoney,biliStr);*/
       			 	
   			 	}else{//奖金 工资 补助拆分
   			 		jibenMoney1 = getMathBybili(jibenMoney,biliStr);
   			 		qita1 = getMathBybili(qita,biliStr);
   			 		gudingMoney1 = jibenMoney1.add(qita1); 
   			 	} 
        		 
   			 	//应发工资重新计算
   			 	BigDecimal yingfaMoney1 = jiangjinMoney1.add(gudingMoney1);
   			 	//应税工资重新计算 
   			 	BigDecimal yingshuigongzi1 = yingfaMoney1.subtract(tiepiao1).subtract(guanaitong1).subtract(laowugongsi1).subtract(qitamoshi1);   
        		// 月度人力成本 重新计算 
   			 	BigDecimal yuedurenli1 = yingfaMoney1.add(shouxufei).add(comall1).add(jingjinbuchang1);   
        		//月度人力成本总额
   			 	BigDecimal yuedurenliAll1 = yuedurenli1.add(nianzhongfentan1).add(jidufentan1); 
        		//实发=======================
   			 	BigDecimal shifa1 = yingfaMoney1.subtract(personYanglao1).subtract(personYiliao1).subtract(personShiye1).subtract(personGongjijin1).subtract(personShui1)
        				.add(mwjijin1).subtract(tiepiao1).subtract(guanaitong1).subtract(laowugongsi1).subtract(qitamoshi1);  
           	 
   			 	
   			 	String costID = costMap.get(costNumber);
   			 	String postid = postMap.get(postNumber);
   			 	
        		String insertSql = " /*dialect*/insert into CT_PAY_PayShareDetail ( FID,FCreatorID,FCreateTime,FLastUpdateUserID,FLastUpdateTime, "+
        		"  CFThiscityID,CFComID,CFPerid ,CFCostCenterNumber ,cfpostTypeNumber,CFIscount,CFBusinessdate,cfemptype,CFCostID,CFPostID,"+
        		"  CFJibengongzi,CFQita,CFGudingmoney,CFBaodiMoney,CFFudongMoney,CFBaodibuzu,CFJiangjinAll,CFYingfaMoney,"+
        		"  CFTiepiao,CFGuaiaitong,CFLaowuMoney,CFQitamoshi,CFYingshuiMoney, "+ 
        		"  CFShouxufei,CFComyanglao,CFComyiliao,CFComshiye,CFComgongshang,CFComshengyu,CFCOMDABING ,CFComgongjijin,CFFuwufei,CFShuijin ,CFComshebaoAll,   "+
        		"  CFMwMoney,CFShuihouqita ,CFJingjibuchang,CFYuefurenli,CFYuedurenliAll,  "+
        		"  CFPerYanglao,CFPerYiliao,CFPerShiye ,CFPERDABING,CFPerGongjijin,CFGeshui, CFNianzhongfentan ,CFJidufentan,CFShifa,"+ 
        		"  CFTPShouxufei,CFGATShouxufei,CFLWShouxufei,CFQTShouxufei,cfnianzhong,cfjidu )  "+
        		" values(newbosid('1CE472FA'),'"+userId+"',sysdate,'"+userId+"',sysdate, "+
        		" '"+cityID+"','"+companyid+"','"+personid+"','"+costNumber+"','"+postNumber+"','"+coungPerson+"','"+businessDate+"','"+empTypeNumber1+"','"+costID+"','"+postid+"', " +
        		" "+jibenMoney1+","+qita1+","+gudingMoney1+","+baodiMoney1+","+fudongMoney1+","+baodibuzuMoney1+","+jiangjinMoney1+","+yingfaMoney1+","+
        		" "+tiepiao1+","+guanaitong1+","+laowugongsi1+","+qitamoshi1+","+yingshuigongzi1+","+
        		" "+shouxufei1+","+comyanglao1+","+comyiliao1+","+comshiye1+","+comgongshang1+","+comshengyu1+","+comdabing1+","+comgongjijin1+","+fuwufei1+","+shuijin1+","+comall1+", "+
        		" "+mwjijin1+","+shuihouqita1+","+jingjinbuchang1+","+yuedurenli1+","+yuedurenliAll1+", "+
        		" "+personYanglao1+","+personYiliao1+","+personShiye1+","+personDabing1+","+personGongjijin1+","+personShui1+","+nianzhongfentan1+","+jidufentan1+" ,"+shifa1+", " +
        		" "+tpshouxufei1+","+gatshouxufei1+","+lwshouxufei1+","+qtshouxufei1+" ,"+yearSendMonth1+" ,"+quaSendMonth1+" )" ; 
        		pe.getSqlList().add(insertSql); 
        		
        	}
        	//没有 说明就直接全比例计算
        	if(fentanPersonrow.size() == 0){ 
        		String costID = costMap.get(costCenterNumber);
   			 	String postid = postMap.get(postTypeNumber);
        		String coungPerson = "1"; 
        		String insertSql = " /*dialect*/insert into CT_PAY_PayShareDetail ( FID,FCreatorID,FCreateTime,FLastUpdateUserID,FLastUpdateTime, "+
        		"  CFThiscityID,CFComID,CFPerid  ,CFCostCenterNumber ,cfpostTypeNumber,CFIscount,CFBusinessdate,cfemptype,CFCostID,CFPostID,"+
        		"  CFJibengongzi,CFQita,CFGudingmoney,CFBaodiMoney,CFFudongMoney,CFBaodibuzu,CFJiangjinAll,CFYingfaMoney,"+
        		"  CFTiepiao,CFGuaiaitong,CFLaowuMoney,CFQitamoshi,CFYingshuiMoney, "+ 
        		"  CFShouxufei,CFComyanglao,CFComyiliao,CFComshiye,CFComgongshang,CFComshengyu,CFCOMDABING ,CFComgongjijin,CFFuwufei,CFShuijin ,CFComshebaoAll,    "+
        		"  CFMwMoney,CFShuihouqita ,CFJingjibuchang,CFYuefurenli,CFYuedurenliAll,  "+
        		"  CFPerYanglao,CFPerYiliao,CFPerShiye ,CFPERDABING,CFPerGongjijin,CFGeshui, CFNianzhongfentan ,CFJidufentan,CFShifa,"+ 
        		"  CFTPShouxufei,CFGATShouxufei,CFLWShouxufei,CFQTShouxufei,cfnianzhong,cfjidu )  "+
        		" values(newbosid('1CE472FA'),'"+userId+"',sysdate,'"+userId+"',sysdate, "+
        		" '"+cityID+"','"+company+"','"+personid+"','"+costCenterNumber+"','"+postTypeNumber+"','"+coungPerson+"','"+businessDate+"','"+empTypeNumber+"','"+costID+"','"+postid+"',  " +
        		" "+jibenMoney+","+qita+","+gudingMoney+","+baodiMoney+","+fudongMoney+","+baodibuzuMoney+","+jiangjinMoney+","+yingfaMoney+","+
        		" "+tiepiao+","+guanaitong+","+laowugongsi+","+qitamoshi+","+yingshuigongzi+","+
        		" "+shouxufei+","+comyanglao+","+comyiliao+","+comshiye+","+comgongshang+","+comshengyu+","+comdabing+","+comgongjijin+","+fuwufei+","+shuijin+","+comall+", "+
        		" "+mwjijin+","+shuihouqita+","+jingjinbuchang+","+yuedurenli+","+yuedurenliAll+", "+
        		" "+personYanglao+","+personYiliao+","+personShiye+","+personDabing+","+personGongjijin+","+personShui+","+nianzhongfentan+","+jidufentan+" ,"+shifa+", " +
        		" "+tpshouxufei+","+gatshouxufei+","+lwshouxufei+","+qtshouxufei+","+yearSendMonth+" ,"+quaSendMonth+" )" ; 
        		pe.getSqlList().add(insertSql);
        	} 
    	}
    	try {
			pe.executeUpdate(ctx);
			pool.shutdown(); 
		} catch (EASBizException e) { 
			e.printStackTrace();
			pool.shutdown(); 
		} catch (BOSException e) { 
			e.printStackTrace();
			pool.shutdown(); 
		}
		pool.shutdown();  
    }
    
    private void baobiaoShanghai(Context ctx, String cityID,String businessDate,String userId) throws Exception {

    	ExecutorService pool = Executors.newFixedThreadPool(6);
	    ParallelSqlExecutor pe = new ParallelSqlExecutor(pool);  
		String deleteSql = " delete  CT_PAY_PaySheetDetail  where cfcityid = '"+cityID+"' and cfbusinessdate  = '"+businessDate +"' ";
    	DbUtil.execute(ctx, deleteSql ); 
    	
    	String cityname = "";
    	String citynumber = "";
    	
    	String citySql = " select  fname_l2 as name , fnumber as number   from  T_ORG_BaseUnit where fid =  '"+cityID+"'  ";
    	IRowSet cityrow = DbUtil.executeQuery(ctx, citySql.toString() );
    	while (cityrow.next()) { 
    		cityname = cityrow.getString("NAME");
    		citynumber = cityrow.getString("NUMBER");
    	}
    	
    	HashMap<String, HashMap<String, BigDecimal>> bonusMap  = new HashMap<String, HashMap<String, BigDecimal>>();
    	//把整体上得相关人员的奖金项目查询出来 
    	StringBuffer bonusSql = new StringBuffer() 
    	.append(" /*dialect*/ select  a.pernumber as pernumber , a.pername as pername,a.comnumber as comnumber ,a.comname as comname ,NVL(b.scalbonus,0) as scalbonus ,NVL(b.whitebonus,0) as whitebonus ,NVL(b.conbonus,0) as conbonus ,").append("\r\n") 
    	.append(" NVL(b.docbonus,0) as docbonus ,NVL(b.shopgoalbonus,0) as shopgoalbonus ,NVL(b.asstodocbonus,0)as asstodocbonus ,NVL(b.kfbonus,0) as kfbonus , NVL(b.clinicbonus,0) as clinicbonus  ,NVL(c.XARY,0) as XARY , NVL(c.card,0) as card ,NVL(c.one,0) as one ,NVL(c.two,0) as two ,NVL(c.shophelp,0) as shophelp ,").append("\r\n") 
    	.append(" NVL(c.good,0) as good ,NVL(c.markt,0) as markt ,NVL(c.docass,0) as docass ,NVL(c.keep,0) as keep ,NVL(c.kefu,0) as kefu ,NVL(c.huli,0) as huli ,NVL(c.conver,0) as conver ,NVL(c.hold,0) as hold ,NVL(d.SUBAMOUNT ,0) as SUBAMOUNT ,  NVL(c.NIANZHONGMONEY,0) AS NIANZHONGMONEY , NVL(c.JIDUMONEY,0) AS  JIDUMONEY,nvl(c.NIANZHONGFENTAN,0) as NIANZHONGFENTAN,nvl(c.JIDUFENTAN,0) as JIDUFENTAN   ").append("\r\n")  
    	.append(" from ( SELECT  person.fid as personid ,person.fname_l2 as pername,person.fnumber as  pernumber ,baseunit.fid as comid,baseunit.fnumber as comnumber ,baseunit.fname_l2 as comname ").append("\r\n") 
    	.append(" FROM  T_HR_SCMPCALTABLE  scmptable  inner join T_BD_Person person  on person.fid = scmptable.FPERSONID , T_ORG_BaseUnit baseunit where baseunit.FPARENTID in ( 'DeJU1u+zSN+d41DA4hTamsznrtQ=','jbYAAACYvKjM567U')  and  baseunit.FISASSISTANTORG  = 0 ").append("\r\n") 
    	.append(" and scmptable.FHRORGUNITID ='"+cityID+"' and  scmptable.FPERIODYEAR ="+businessDate.substring(0,4)+"  and  scmptable.FPERIODMONTH ="+businessDate.substring(4,6)+" order by  person.fname_l2,baseunit.fname_l2 ) a  ").append("\r\n") 
    	.append("  left join ( SELECT cfempnumber as pernumber ,cfclinicnumber as comnumber ,sum(NVL(CFSCALINGBONUS,0)) as scalbonus,sum(NVL(CFWHITEBONUS,0)) as whitebonus ,sum(NVL(CFCONBONUS,0)) as conbonus, ").append("\r\n") 
    	.append(" sum(NVL(CFDOCBONUS,0)) as docbonus,sum(NVL(CFSHOPGOALBONUS,0)) as  shopgoalbonus ,sum(NVL(CFASSTODOCBOUNS,0)) as asstodocbonus ,sum(NVL(CFKFBONUS,0)) as kfbonus , sum(NVL(cfotherpostbonus,0)) as clinicbonus    FROM    CT_PAY_AchienementSum   ").append("\r\n") 
    	.append(" where  cfbusinessdate='"+businessDate+"' and  cfcitynumber = '"+citynumber+"' group by cfempnumber ,cfclinicnumber  ) b on a.pernumber = b.pernumber and b.comnumber = a.comnumber  ").append("\r\n") 
    	.append("  left join (select  cfempnumber as pernumber,cfclinicnumber as comnumber, sum(NVL(CFXRAYALLOW,0)) as XARY  ,sum(NVL(CFCardSellBonus,0)) as card ,(sum(NVL(CFOtherBounsOne,0))) as one,(sum(NVL(CFOtherBounsTwo,0))+ sum(NVL(CFConvertBouns,0))) as two,(sum(NVL(CFShopHelp,0))+sum(NVL(CFGoodBouns,0))) as shophelp, ").append("\r\n") 
    	.append(" sum(NVL(CFGoodBouns,0)) as good,sum(NVL(CFMarktBouns,0)) as markt,sum(NVL(CFDocAssBouns,0)) as docass ,sum(NVL(CFDocKeepBouns,0)) as keep,sum(NVL(CFKefuBouns,0)) as kefu,sum(NVL(CFHuliBouns,0)) as huli , ").append("\r\n") 
    	.append(" sum(NVL(CFConvertBouns,0)) as conver,sum(NVL(CFHoldAmount,0)) as hold ,sum(NVL(CFNIANZHONGMONEY,0)) as NIANZHONGMONEY ,sum(NVL(CFJIDUMONEY,0)) as JIDUMONEY ,sum(NVL(CFNIANZHONGFENTAN,0)) as NIANZHONGFENTAN ,sum(NVL(CFJIDUFENTAN,0)) as JIDUFENTAN from  CT_PAY_OtherBonusSpilt  where cfcityid = '"+cityID+"' and cfbusinessdate = '"+businessDate+"' group by cfempnumber ,cfclinicnumber ) c on a.pernumber = c.pernumber and c.comnumber = a.comnumber  ").append("\r\n") 
    	.append("  left join  (SELECT  clinicsub.cfempnumber as pernumber,baseunit.fnumber as comnumber , sum(NVL(clinicsub.CFSUBAMOUNT,0))  as SUBAMOUNT   FROM  CT_PAY_ClinicComSub clinicsub  inner join T_ORG_BaseUnit baseunit ").append("\r\n") 
    	.append(" on  clinicsub.cfclinicid = baseunit.fid  where clinicsub.cfcityid = '"+cityID+"' and clinicsub.cfbusinessdate = '"+businessDate+"' group by clinicsub.cfempnumber ,baseunit.fnumber ) ").append("\r\n") 
    	.append(" d on a.pernumber = d.pernumber and d.comnumber = a.comnumber  ").append("\r\n") 
    	.append(" where    ( (NVL(b.scalbonus,0)+NVL(b.whitebonus,0)+NVL(b.conbonus,0)+NVL(b.docbonus,0)+NVL(b.shopgoalbonus,0) +NVL(b.asstodocbonus,0)+NVL(b.kfbonus,0)+NVL(b.clinicbonus,0)+NVL(c.card,0) +NVL(c.one,0)+NVL(c.two,0)+ ").append("\r\n") 
    	.append(" NVL(c.shophelp,0)+NVL(c.markt,0)+NVL(c.docass,0) +NVL(c.keep,0)+NVL(c.kefu,0)+NVL(c.huli,0) +NVL(c.hold,0) + nvl(c.XARY,0)) != 0 or  NVL(d.SUBAMOUNT ,0)  !=0  or  NVL(c.NIANZHONGMONEY ,0)  !=0 or  NVL(c.JIDUMONEY ,0)  !=0 ) ");
    	//+NVL(c.good,0)   +NVL(c.conver,0)
    	//System.out.print(bonusSql.toString());
    	IRowSet bonusrow = DbUtil.executeQuery(ctx, bonusSql.toString() );
    	while (bonusrow.next()) { 
    		HashMap<String, BigDecimal>  map= new HashMap<String, BigDecimal>();
    		map.put("scalbonus", bonusrow.getBigDecimal("SCALBONUS"));
    		map.put("whitebonus", bonusrow.getBigDecimal("WHITEBONUS"));
    		map.put("conbonus", bonusrow.getBigDecimal("CONBONUS")); 
    		map.put("clinicbonus", bonusrow.getBigDecimal("CLINICBONUS")); 
    		
    		
    		map.put("docbonus", bonusrow.getBigDecimal("DOCBONUS"));
    		map.put("shopgoalbonus", bonusrow.getBigDecimal("SHOPGOALBONUS"));
    		map.put("asstodocbonus", bonusrow.getBigDecimal("ASSTODOCBONUS"));  
    		map.put("kfbonus", bonusrow.getBigDecimal("KFBONUS"));  
    		map.put("XARY", bonusrow.getBigDecimal("XARY")); 
    		map.put("card", bonusrow.getBigDecimal("CARD")); 
    		map.put("one", bonusrow.getBigDecimal("ONE"));
    		map.put("two", bonusrow.getBigDecimal("TWO")); 
    		
    		//map.put("one", BigDecimal.ZERO);
    		//map.put("two", BigDecimal.ZERO); 
    		map.put("shophelp", bonusrow.getBigDecimal("SHOPHELP"));  
    		
    		map.put("good", bonusrow.getBigDecimal("GOOD"));
    		map.put("markt", bonusrow.getBigDecimal("MARKT"));
    		map.put("docass", bonusrow.getBigDecimal("DOCASS")); 
    		//map.put("docass", BigDecimal.ZERO); 
    		
    		map.put("keep", bonusrow.getBigDecimal("KEEP")); 
    		map.put("kefu", bonusrow.getBigDecimal("KEFU"));
    		map.put("huli", bonusrow.getBigDecimal("HULI")); 
    		map.put("conver", bonusrow.getBigDecimal("CONVER"));  
    		map.put("hold", bonusrow.getBigDecimal("HOLD")); 
    		map.put("SUBAMOUNT", bonusrow.getBigDecimal("SUBAMOUNT"));  
    		 
    		map.put("NIANZHONGMONEY", bonusrow.getBigDecimal("NIANZHONGMONEY"));  
    		map.put("JIDUMONEY", bonusrow.getBigDecimal("JIDUMONEY"));  
    		
    		map.put("NIANZHONGFENTAN", bonusrow.getBigDecimal("NIANZHONGFENTAN"));  
    		map.put("JIDUFENTAN", bonusrow.getBigDecimal("JIDUFENTAN")); 
    		
    		//人员 -公司    奖金项
    		bonusMap.put(bonusrow.getString("PERNUMBER")+"-"+bonusrow.getString("COMNUMBER"), map);
    	}
    	
    	int  yrar = Integer.valueOf( businessDate.substring(0,4));
		int  month = Integer.valueOf( businessDate.substring(4,6));
		String monthStr= month+"";
		if(month == 12 ){
			yrar = yrar+1;
			month = 1;
		}
		if(month < 10){
			monthStr = "0"+monthStr;
		}
		
		HashMap<String, BigDecimal> docTypeMap  = new HashMap<String, BigDecimal>();
		
    	HashMap<String, HashMap<String, Object>> perMsgMap  = new HashMap<String, HashMap<String, Object>>(); 
		
		StringBuffer  tableSql = new StringBuffer() 
		.append(" /*dialect*/select   person.fname_l2 as personName , person.fnumber as personNumber , person.fid as personid ,  ").append("\r\n") 
		.append("   case when company.fname_l2  is null then  company2.fname_l2 else company.fname_l2  end  as COMNAME ,   case when company.fnumber  is null then  company2.fnumber else company.fnumber  end  as comnumber , case when company.fid  is null  then  company2.fid else company.fid  end  as comid  ,  ").append("\r\n") 
		
	    .append("  position.fname_l2 as postName , postType.fname_l2 as  postType , postType.fnumber as  postTypeNumber  ,costCenter.fnumber as  costnumber, ").append("\r\n") 
	    .append(" (case    when  emptype.fnumber in  ('001','002','007','S04','009' ) then '正式员工'  when  emptype.fnumber in  ('003','004','005','006','011','012','013','020','021','030','031', '036','S01','S02','S03','S05','S06','S07','S08','S10','S11','S12' ) then '兼职员工（有固定工资）'   else '其他' end )    as empType ,").append("\r\n")  
	    .append(" to_char(EmpLaborRelation.FEnterDate,'yyyy-mm-dd')  as  indate ,  to_char( PERSONPOSITION.FLeftDate,'yyyy-mm-dd')  as leavedate , round(months_between(case when PERSONPOSITION.FLeftDate is null then sysdate else PERSONPOSITION.FLeftDate end,EmpLaborRelation.FEnterDate)/12,1) as  workyear ,").append("\r\n") 
	    .append(" NVL(scmptable.S117,0) as  bingjiapro , nvl( person.FIDCARDNO ,'') as  cardnumber , NVL(scmptable.S97,0) as  jibengongzi , ").append("\r\n") 
	    //--
	    .append(" NVL(scmptable.S99,0) AS postallow,  NVL(scmptable.S221,0) AS  workyearallow,  NVL(scmptable.S222,0) AS  learnallow,  NVL(scmptable.S223,0) AS cardAllow, NVL(scmptable.S224,0) AS houseallow,").append("\r\n") 
	    .append(" NVL(scmptable.S101,0) as achieveMoney,   (nvl(scmptable.S97,0)+nvl(scmptable.S99,0)+nvl(scmptable.S101,0)) as  monthMoney,  NVL(scmptable.S126,0) as  queqin, NVL(scmptable.S119,0) as shijia ,  NVL(scmptable.S118,0) as bingjia,  NVL(scmptable.S218,0) as kaoqinsub, NVL(scmptable.S129,0) as chidaosub,").append("\r\n") 
	    .append(" NVL(scmptable.S225,0) as gdAllow,  NVL(scmptable.S226,0) as allWorkAllow,NVL(scmptable.S67,0) as foodAllow,  NVL(scmptable.S115,0) as addWorkAllow,  NVL(scmptable.S147 ,0)as other,").append("\r\n") 

		.append("  (nvl(scmptable.S97,0)+nvl(scmptable.S99,0)+nvl(scmptable.S101,0))-NVL(scmptable.S218,0)-NVL(scmptable.S129,0)+NVL(scmptable.S67,0)+NVL(scmptable.S115,0)+NVL(scmptable.S147 ,0)+NVL(scmptable.S225,0) +NVL(scmptable.S226 ,0)  as  gdMoney,").append("\r\n") //所有得扣款项目  是为正还是为负
		//--保底外
		.append(" NVL(scmptable.S90 ,0) as XRayAllow,NVL(scmptable.S227 ,0) as holderMoney,NVL(scmptable.S228 ,0) as assMoney,NVL(scmptable.S229 ,0) as zbPro,NVL(scmptable.S230 ,0) as shopHelp,NVL(scmptable.S231 ,0) as zxCard,NVL(scmptable.S232 ,0) as splitUp,NVL(scmptable.S233 ,0) as zxLeave,NVL(scmptable.S234 ,0) as docLeave,").append("\r\n") 
		.append(" nvl(scmptable.S286,0) AS DOCASSCOST ,NVL(scmptable.S146 ,0) as otherWaiMoney,NVL(scmptable.S146 ,0) as otherWaiMoney ,NVL(scmptable.S90 ,0)+NVL(scmptable.S227 ,0)+NVL(scmptable.S228 ,0)+NVL(scmptable.S229 ,0)+NVL(scmptable.S230 ,0)+NVL(scmptable.S231 ,0)+NVL(scmptable.S232 ,0)+NVL(scmptable.S233 ,0)+NVL(scmptable.S234 ,0)+NVL(scmptable.S286 ,0)+NVL(scmptable.S146 ,0) as waiAllMoney,").append("\r\n") 
		//--保底内
		.append(" NVL(scmptable.S236 ,0) as marktMoney, NVL(scmptable.S148 ,0) as scalMoney,NVL(scmptable.S153 ,0) as mbAmount, NVL(scmptable.S172 ,0) as docAmount,NVL(scmptable.S156 ,0) as kfAmount,").append("\r\n") 
		.append(" NVL(scmptable.S157 ,0) as hlAmount,NVL(scmptable.S161 ,0) as zxAmount,NVL(scmptable.S171 ,0) as shopTarMoney,NVL(scmptable.S132 ,0) as otherNeiMoney,").append("\r\n") 
		
		.append(" NVL(scmptable.S133,0) as bdProjectAll,NVL(scmptable.S144 ,0) as monthBase,NVL(scmptable.S134 ,0)  as bdMonthProject,NVL(scmptable.S133,0) +NVL(scmptable.S142 ,0)  as payble,").append("\r\n") 
		.append(" NVL(scmptable.S103 ,0)  as achieveAll, NVL(scmptable.S237 ,0) as seaBase,NVL(scmptable.S238 ,0) as seaBuzu,").append("\r\n") 
		
		.append(" NVL(scmptable.S104,0)  as shouldPay,NVL(scmptable.S105,0) as realShouldPay, NVL(scmptable.S174,0) as perYanglao,NVL(scmptable.S175,0) as perYiliao,NVL(scmptable.S205,0) as perDaBing,NVL(scmptable.S176,0) as perShiye,").append("\r\n") 
		.append(" NVL(scmptable.S177,0) as perGongjijin,NVL(scmptable.S174,0)+NVL(scmptable.S175,0)+NVL(scmptable.S176,0)+NVL(scmptable.S177,0)+NVL(scmptable.S205,0) as perAll, NVL(scmptable.S109,0) as beforeTaxMoney,").append("\r\n") 
		.append(" NVL(scmptable.S191,0) as freeTaxMoney,NVL(scmptable.S203,0) as grzxkcAmount,NVL(scmptable.S192,0) as ljyssde,NVL(scmptable.S5,0) as yssde,NVL(scmptable.S305,0) as tax,NVL(scmptable.S304,0) as sjkcs,NVL(scmptable.S301,0) as ljgrsds,NVL(scmptable.S187,0) as dkgrsds,NVL(scmptable.S89,0)  as mwBase,").append("\r\n") 
		     
		.append(" NVL(scmptable.S239,0) as dianpingSub,NVL(scmptable.S240 ,0) as kfSub,NVL(scmptable.S66 ,0) as payUp,NVL(scmptable.S110,0)  as buchangAmount,NVL(scmptable.S111,0) as shifa, ").append("\r\n") 
		
		.append(" nvl( scmptable.S141 ,0) as tiepiao , nvl( scmptable.S207 ,0) as guaiaitong , nvl( scmptable.S143 ,0) as laowuMoney , nvl( scmptable.S213 ,0) as qitamoshi, nvl( scmptable.S141 ,0)+nvl( scmptable.S207 ,0)+nvl( scmptable.S143 ,0)+nvl( scmptable.S213 ,0) as jifenAll , ").append("\r\n")  
		
		.append(" nvl( scmptable.S296 ,0) as tiepiaoSer , nvl(scmptable.S302 ,0) as guanaitongSer , nvl( scmptable.S145 ,0) as shouxufei , nvl( scmptable.S297 ,0) as otherSer ,  nvl( scmptable.S296 ,0)+nvl(scmptable.S302 ,0) +nvl( scmptable.S145 ,0) + nvl( scmptable.S297 ,0) as serviceAll, ").append("\r\n")  // nvl( scmptable.S303 ,0) as shouxufei
		
		.append(" NVL(scmptable.S106,0) as shouldYearBouns,NVL(scmptable.S189,0) as yearTax,NVL(scmptable.S107,0) as realyearAmount,NVL(scmptable.S108,0) as realAmount,NVL(scmptable.S179,0) as comyanglao,NVL(scmptable.S180,0)+NVL(scmptable.S295,0) as comyiliao,NVL(scmptable.S181,0) as comshiye,NVL(scmptable.S182,0) as comgongshang, ").append("\r\n") 
		.append(" NVL(scmptable.S183,0) as comshengyu,nvl(scmptable.S206,0)  as comdabing,NVL(scmptable.S186,0) as comgongjijin,NVL(scmptable.S303,0) as fuwufei, NVL(scmptable.S138,0) as shuijin,nvl(scmptable.S252,0) as comAll,NVL(scmptable.S139,0) as LC, ").append("\r\n") 
		//																				年终分摊										季度分摊
		.append(" nvl(scmptable.S97,0) as GUDINGGONGZI,nvl(0,0) as FENTANOTHER  ,nvl(scmptable.S216,0) as NIANZHONGFENTAN,nvl(scmptable.S217,0) as JIDUFENTAN,nvl(scmptable.S107,0) as YEARSENDMONTH,nvl(scmptable.S219,0) as QUASENDMONTH, nvl(scmptable.S125,0) as KAOQINMONTHBASE   ").append("\r\n") 
		 
		     
		.append(" FROM  T_HR_SCMPCALTABLE  scmptable  inner join T_BD_Person person  on person.fid = scmptable.FPERSONID  ").append("\r\n")
		.append(" inner join T_HR_PERSONPOSITION PERSONPOSITION on PERSONPOSITION.FPERSONID = person.fid ").append("\r\n") 
		.append(" inner join T_HR_EmpLaborRelation EmpLaborRelation on EmpLaborRelation.FPERSONID = person.fid ").append("\r\n") 
		.append(" inner join T_HR_BDEmployeeType emptype on  emptype.fid = scmptable.FEMPLOYEETYPEID   ").append("\r\n") 
		.append(" left join T_ORG_BaseUnit dept  on dept.fid = scmptable.FCostBearOrgID   and dept.flevel ='5' left join T_ORG_BaseUnit company on  company.fid = dept.fparentid  ").append("\r\n") 
		.append(" left join T_ORG_BaseUnit company2 on company2.fid = scmptable.FCostBearOrgID and company2.flevel ='4' ").append("\r\n")  
		//.append(" left join T_HR_EmpPostExperienceHis his on scmptable.FPERSONID = his.FPERSONID   and (company.fid = his.FCompanyID  or company2.fid = his.FCompanyID)  ").append("\r\n")  
		.append(" left join  T_ORG_Position position on  position.fid = scmptable.fpositionid ").append("\r\n")  
		
		//.append(" inner join  CT_SRQ_StaffCityCostRelevance perrelevance on   person.fid   = perrelevance.cfpersonid and  perrelevance.cfcityid = '"+cityID+"'  ")
    	//.append(" inner join CT_SRQ_CostCenter  costCenter on perrelevance.cfCostCenterid = costCenter.fid  inner join CT_SRQ_PostType postType   on  perrelevance.CFPostTypeID = postType.fid    ")
    	 
    	
    	//.append(" inner join CT_SRQ_CostCenter  costCenter on person.cfcostcenterid = costCenter.fid  inner join CT_SRQ_PostType postType   on  person.cfpostTypeid = postType.fid    ")
		.append(" left join CT_SRQ_CostCenter  costCenter on person.cfcostcenterid = costCenter.fid  ").append("\r\n") 
		.append(" left join CT_SRQ_PostType postType   on  person.cfpostTypeid = postType.fid  ").append("\r\n") 
		     
		.append(" where        scmptable.fhrorgunitid ='"+cityID+"' and  scmptable.FPERIODYEAR = "+businessDate.substring(0,4)+"  and scmptable.FPERIODMONTH = "+businessDate.substring(4,6)+"    ")
		//.append("  and  person.fnumber='MS310100270' ");
		.append(" ");
		  
		HashMap<String, String> perClinicMap= new HashMap<String, String>();
    	//System.out.print(tableSql.toString());
    	IRowSet tablerow = DbUtil.executeQuery(ctx, tableSql.toString() );
    	while (tablerow.next()) {  
    		
    		
    		HashMap<String, Object> perMap= new HashMap<String, Object>();
    		
    		String costNumber = tablerow.getString("COSTNUMBER");
    		
    		BigDecimal bili = BigDecimal.ONE;
    		//人员id
    		String personid = tablerow.getString("PERSONID");
    		String personname = tablerow.getString("PERSONNAME");
    		String personnumber = tablerow.getString("PERSONNUMBER");
    		
    		if(tablerow.getBigDecimal("DOCAMOUNT") != null && tablerow.getBigDecimal("DOCAMOUNT").compareTo(BigDecimal.ZERO) >0  ){
    			docTypeMap.put(personnumber, tablerow.getBigDecimal("DOCAMOUNT"));
    		}
    		
    		//所在公司
    		String companyid = tablerow.getString("COMID");
    		String comname = tablerow.getString("COMNAME");
    		String comnumber = tablerow.getString("COMNUMBER");
    		
    		perClinicMap.put(personnumber+"-"+comnumber,"1");
    		//职位
    		String postname = tablerow.getString("POSTNAME");
    		//岗位类别
    		String posttype = tablerow.getString("POSTTYPE"); 
    		//岗位类别编码
    		String postTypeNumber = tablerow.getString("POSTTYPENUMBER"); 
    		
    		
    		//人员类别
    		String emptype = tablerow.getString("EMPTYPE");  
    		//入职日期
    		String indate =tablerow.getString("INDATE"); 
    		//离职日期
    		String leavedate = tablerow.getString("LEAVEDATE")== null?"":tablerow.getString("LEAVEDATE"); 
    		//工龄
    		BigDecimal workyear = tablerow.getBigDecimal("WORKYEAR");   
    		
    		//病假工资比例
    		BigDecimal bingjiaPro = tablerow.getBigDecimal("BINGJIAPRO"); 
    		//身份证号码
    		String cardnumber = tablerow.getString("CARDNUMBER")== null?"": tablerow.getString("CARDNUMBER");  ; 
    		
    		perMap.put("PERSONID", personid);
    		perMap.put("PERSONNAME", personname);
    		perMap.put("PERSONNUMBER", personnumber);
    		perMap.put("COMID", companyid);
    		perMap.put("COMNAME", comname);
    		perMap.put("COMNUMBER", comnumber);
    		perMap.put("POSTNAME", postname);
    		
    		perMap.put("POSTTYPE", posttype);
    		perMap.put("POSTTYPENUMBER", postTypeNumber);
    		perMap.put("EMPTYPE", emptype);
    		perMap.put("INDATE", indate);
    		perMap.put("LEAVEDATE", leavedate);
    		perMap.put("WORKYEAR", workyear);
    		perMap.put("BINGJIAPRO", bingjiaPro);
    		perMap.put("CARDNUMBER", cardnumber); 
    		
    		perMap.put("COSTNUMBER", costNumber); 
    		
    		perMsgMap.put(personnumber, perMap);
    		 
    		StringBuffer  fentanSql = new StringBuffer(); 
        	fentanSql.append("/*dialect*/   SELECT attend.cfempnumber as CFEMPNUMBER,attend.cfempname AS CFEMPNAME,baseunit.fnumber  AS CFCLINICNUMBER,baseunit.fname_l2 AS CFCLINICNAME,attend.CFAttendPro AS CFAttendPro ,baseunit.fid as clinicid  FROM  CT_PAY_AttendancePro attend left join T_ORG_BaseUnit baseunit  on  attend.cfclinicid = baseunit.fid    ")
        	.append("  where attend.cfcityid =  '"+cityID+"'  and attend.cfbusinessdate = '"+businessDate+"'  and attend.cfempnumber = '"+personnumber+"'");
        	IRowSet fentanPersonrow = DbUtil.executeQuery(ctx, fentanSql.toString() );
        	while (fentanPersonrow.next()) { 
        		personnumber = fentanPersonrow.getObject("CFEMPNUMBER") ==null?"":fentanPersonrow.getString("CFEMPNUMBER"); 
        		String clinicid = fentanPersonrow.getObject("CLINICID") ==null?"":fentanPersonrow.getString("CLINICID");
        		String clinicnumber = fentanPersonrow.getObject("CFCLINICNUMBER") ==null?"":fentanPersonrow.getString("CFCLINICNUMBER");
        		String clinicname = fentanPersonrow.getObject("CFCLINICNAME") ==null?"":fentanPersonrow.getString("CFCLINICNAME");
        		BigDecimal attendPro = fentanPersonrow.getObject("CFATTENDPRO") ==null? BigDecimal.ZERO:fentanPersonrow.getBigDecimal("CFATTENDPRO"); 

        		/* 这个是员工所属的公司
        		String companyid = tablerow.getString("COMID");
        		String comname = tablerow.getString("COMNAME");
        		String comnumber = tablerow.getString("COMNUMBER");
        		*/
        		HashMap<String, BigDecimal>  map= new HashMap<String, BigDecimal>(); 
        		if(bonusMap.get(personnumber+"-"+clinicnumber) != null ){
        			map = bonusMap.get(personnumber+"-"+clinicnumber);
        		}
        		
        		BigDecimal docTypeAmount = BigDecimal.ZERO; 

				if( docTypeMap.get(personnumber) !=null ){
					docTypeAmount = docTypeMap.get(personnumber);
				}
			 
				String iscount = "0";
        		if(comnumber.equals(clinicnumber) ){
        			iscount= "1";
        			perClinicMap.remove(personnumber+"-"+clinicnumber);
        		}
        		
        		//分为考勤拆分和奖金拆分
				String sql = "";
        		if(personnumber.equals("MS310100550") || personnumber.equals("MS310100268") || personnumber.equals("MS310100243")){
        			 sql = jisuanByBouns(ctx,businessDate, tablerow, attendPro, personnumber, clinicnumber,cityID ,map,userId,docTypeAmount,iscount);
        		}else{
        			sql = jisuan(ctx,businessDate, tablerow, attendPro, personnumber, clinicnumber,cityID ,map,userId,docTypeAmount);
        		}
        		bonusMap.remove(personnumber+"-"+clinicnumber); 
        		//奖金拆分
        		
        		//如果员工编码是黄丽芳  就把编码给成杨国平
        		if(personnumber.equals("MS310100550")){
        			personnumber = "MS310100268";
        			
        			StringBuffer  perGeSql = new StringBuffer()
        	    	.append("  /*dialect*/select   person.fname_l2 as personName , person.fnumber as personNumber , person.fid as personid ,position.fname_l2 as postName , postType.fname_l2 as  postType , postType.fnumber as  postTypeNumber  ,costCenter.fnumber as  costnumber,  ").append("\r\n") 
        			.append(" (case    when  emptype.fnumber in  ('001','002','007','S04','009' ) then '正式员工'  when  emptype.fnumber in  ('003','004','005','006','011','012','013','020','021','030','031', '036','S01','S02','S03','S05','S06','S07','S08','S10','S11','S12' ) then '兼职员工（有固定工资）'   else '其他' end )    as empType ,").append("\r\n") 
        			.append(" to_char(EmpLaborRelation.FEnterDate,'yyyy-mm-dd')  as  indate ,  to_char( PERSONPOSITION.FLeftDate,'yyyy-mm-dd')  as leavedate , round(months_between(case when PERSONPOSITION.FLeftDate is null then sysdate else PERSONPOSITION.FLeftDate end,EmpLaborRelation.FEnterDate)/12,1) as  workyear, ").append("\r\n") 
        			.append(" NVL(scmptable.S117,0) as  bingjiapro ,  person.FIDCARDNO as  cardnumber FROM  T_HR_SCMPCALTABLE  scmptable  inner join T_BD_Person person  on person.fid = scmptable.FPERSONID  ").append("\r\n") 
        			.append(" inner join T_HR_PERSONPOSITION PERSONPOSITION on PERSONPOSITION.FPERSONID = person.fid ").append("\r\n") 
        			.append(" inner join T_HR_EmpLaborRelation EmpLaborRelation on EmpLaborRelation.FPERSONID = person.fid ").append("\r\n") 
        			.append(" inner join T_HR_BDEmployeeType emptype on  emptype.fid = scmptable.FEMPLOYEETYPEID   ").append("\r\n")
        			.append(" left join  T_ORG_Position position on  position.fid = scmptable.fpositionid ").append("\r\n") 
        			.append(" left join CT_SRQ_CostCenter  costCenter on person.cfcostcenterid = costCenter.fid  ").append("\r\n") 
        			.append(" left join CT_SRQ_PostType postType   on  person.cfpostTypeid = postType.fid  ").append("\r\n") 
        			.append(" where   person.fnumber = 'MS310100268'  and scmptable.fhrorgunitid ='DeJU1u+zSN+d41DA4hTamsznrtQ=' and  scmptable.FPERIODYEAR = 2020  and scmptable.FPERIODMONTH = 09 ");
        			//System.out.print(tableSql.toString());
        	    	IRowSet perGerow = DbUtil.executeQuery(ctx, perGeSql.toString() ); 
        	    	while (perGerow.next()) {    
        	    		costNumber = perGerow.getString("COSTNUMBER");
        	    		 
        	    		//人员id
        	    		personid = perGerow.getString("PERSONID");
        	    		personname = perGerow.getString("PERSONNAME")+"1";
        	    		personnumber = perGerow.getString("PERSONNUMBER"); 
        	    		//职位
        	    		postname = perGerow.getString("POSTNAME");
        	    		//岗位类别
        	    		posttype = perGerow.getString("POSTTYPE"); 
        	    		//岗位类别编码
        	    		postTypeNumber = perGerow.getString("POSTTYPENUMBER");  
        	    		//人员类别
        	    		emptype = perGerow.getString("EMPTYPE");  
        	    		//入职日期
        	    		indate =perGerow.getString("INDATE"); 
        	    		//离职日期
        	    		leavedate = perGerow.getString("LEAVEDATE")== null?"":perGerow.getString("LEAVEDATE"); 
        	    		//工龄
        	    		workyear = perGerow.getBigDecimal("WORKYEAR");    
        	    		//身份证号码
        	    		cardnumber = perGerow.getString("CARDNUMBER"); 
        	    	 
        	    	} 
        		}  
        		String insertSql = " /*dialect*/insert into CT_PAY_PaySheetDetail ( FID,FCreatorID,FCreateTime,FLastUpdateUserID,FLastUpdateTime, "+
        		"  CFCityid,CFCITYNUMBER,CFCITYNAME, CFCompanyid,CFCOMPANYNUMBER,CFCOMPANYNAME,CFPersonid ,CFPERSONNUMBER,CFPERSONNAME ,CFBusinessdate,CFIscount,cfcostcenternumber,"+
        		"  cfpost,cfposttype,cfposttypenumber,cfindate,cfleavedate,cfworkyear,cfbingjiapro,cfcardnumber,"+ 
        		"  cfjibengongzi ,cfpostallow ,cfworkyearallow ,cflearnallow ,cfcardAllow,cfhouseallow,cfachieveMoney,cfmonthMoney ,cfqueqin,cfshijia ,cfbingjia,cfkaoqinsub,cfchidaosub, cfgdAllow,cfallWorkAllow,cffoodAllow,cfaddWorkAllow,cfother,cfgdMoney,cfXRayAllow ,cfholderMoney, "+
        		"  cfassMoney,cfzbPro,cfshopHelp,cfzxCard,cfsplitUp,cfzxLeave,cfdocLeave,cfdocasscost,cfasstodoc,cfotherWaiMoney,cfwaiAllMoney,cfmarktMoney,cfscalMoney,cfmbAmount,cfdocAmount,cfkfAmount,cfhlAmount,cfzxAmount,cfshopTarMoney,cfclinicachimoney,cfotherNeiMoney,cfbdProjectAll,cfmonthBase,cfbdMonthProject, "+
        		"  cfpayble,cfachieveAll ,cfseaBase,cfseaBuzu,cfshouldPay,cfrealShouldPay,cfperYanglao ,cfperYiliao ,cfperDaBing ,cfperShiye,cfperGongjijin,cfperAll ,cfbeforeTaxMoney ,cffreeTaxMoney ,cfgrzxkcAmount,cfljyssde,cfyssde,cftax,cfsjkcs,cfljgrsds ,cfdkgrsds ,cfmwBase,cfdianpingSub,cfkfSub,  "+
        		"  cfpayUp,cfbuchangAmount,cfshifa ,cftiepiao,cfguaiaitong ,cflaowuMoney ,cfqitamoshi,cfjifenAll,cftiepiaoSer ,cfguanaitongSer,cfshouxufei,cfotherSer,cfserviceAll,cfshouldYearBouns,cfyearTax,cfrealyearAmount ,cfrealAmount,cfcomyanglao ,cfcomyiliao,cfcomshiye ,  "+
        		"  cfcomgongshang ,cfcomdabing,cfcomshengyu ,cfcomgongjijin,cffuwufei,cfshuijin ,cfcomAll ,cfLC ,   "+  
            	"  cfbasemoney ,CFFentanother,CFNianzhongfentan ,CFJidufentan,CFNianzhong,CFJidu ,CFYuedurenliAll ,CFBAODIBONUS )  "+  
        		" values(newbosid('4104607A'),'"+userId+"',sysdate,'"+userId+"',sysdate, "+
        		" '"+cityID+"','"+citynumber+"','"+cityname+"','"+clinicid+"','"+clinicnumber+"','"+clinicname+"','"+personid+"','"+personnumber+"','"+personname+"','"+businessDate+"','"+iscount+"','"+costNumber+"', " +
        		" '"+postname+"','"+emptype+"','"+postTypeNumber+"','"+indate+"','"+leavedate+"',"+workyear+","+bingjiaPro+",'"+cardnumber+"', " +
        		"  "+sql+" )" ;
        		pe.getSqlList().add(insertSql); 
        	}
        	
        	//没有 说明就直接考勤全比例计算
        	if(fentanPersonrow.size() == 0){ 
        		if(bonusMap.get(personnumber+"-"+comnumber) != null ){  
        		}
        		BigDecimal docTypeAmount = BigDecimal.ZERO; 

				if( docTypeMap.get(personnumber) !=null ){
					docTypeAmount = docTypeMap.get(personnumber);
				}
				
    			String sql = jisuan(ctx,businessDate, tablerow, BigDecimal.ONE, personnumber, comnumber,cityID ,bonusMap.get(personnumber+"-"+comnumber),userId,docTypeAmount);
        		bonusMap.remove(personnumber+"-"+comnumber);
        		perClinicMap.remove(personnumber+"-"+comnumber);
        		String insertSql = " /*dialect*/insert into CT_PAY_PaySheetDetail ( FID,FCreatorID,FCreateTime,FLastUpdateUserID,FLastUpdateTime, "+
        		"  CFCityid,CFCITYNUMBER,CFCITYNAME, CFCompanyid,CFCOMPANYNUMBER,CFCOMPANYNAME,CFPersonid ,CFPERSONNUMBER,CFPERSONNAME ,CFBusinessdate,CFIscount,cfcostcenternumber,"+
        		"  cfpost,cfposttype,cfposttypenumber,cfindate,cfleavedate,cfworkyear,cfbingjiapro,cfcardnumber,"+ 
        		"  cfjibengongzi ,cfpostallow ,cfworkyearallow ,cflearnallow ,cfcardAllow,cfhouseallow,cfachieveMoney,cfmonthMoney ,cfqueqin,cfshijia ,cfbingjia,cfkaoqinsub,cfchidaosub, cfgdAllow,cfallWorkAllow,cffoodAllow,cfaddWorkAllow,cfother,cfgdMoney,cfXRayAllow ,cfholderMoney, "+
        		"  cfassMoney,cfzbPro,cfshopHelp,cfzxCard,cfsplitUp,cfzxLeave,cfdocLeave,cfdocasscost,cfasstodoc,cfotherWaiMoney,cfwaiAllMoney,cfmarktMoney,cfscalMoney,cfmbAmount,cfdocAmount,cfkfAmount,cfhlAmount,cfzxAmount,cfshopTarMoney,cfclinicachimoney,cfotherNeiMoney,cfbdProjectAll,cfmonthBase,cfbdMonthProject, "+
        		"  cfpayble,cfachieveAll ,cfseaBase,cfseaBuzu,cfshouldPay,cfrealShouldPay,cfperYanglao ,cfperYiliao ,cfperDaBing ,cfperShiye,cfperGongjijin,cfperAll ,cfbeforeTaxMoney ,cffreeTaxMoney ,cfgrzxkcAmount,cfljyssde,cfyssde,cftax,cfsjkcs,cfljgrsds ,cfdkgrsds ,cfmwBase,cfdianpingSub,cfkfSub,  "+
        		"  cfpayUp,cfbuchangAmount,cfshifa ,cftiepiao,cfguaiaitong ,cflaowuMoney ,cfqitamoshi,cfjifenAll,cftiepiaoSer ,cfguanaitongSer,cfshouxufei,cfotherSer,cfserviceAll,cfshouldYearBouns,cfyearTax,cfrealyearAmount ,cfrealAmount,cfcomyanglao ,cfcomyiliao,cfcomshiye ,  "+
        		"  cfcomgongshang ,cfcomdabing,cfcomshengyu ,cfcomgongjijin,cffuwufei,cfshuijin ,cfcomAll ,cfLC ,   "+  
            	"  cfbasemoney ,CFFentanother,CFNianzhongfentan ,CFJidufentan,CFNianzhong,CFJidu ,CFYuedurenliAll  ,CFBAODIBONUS )  "+  
        		" values(newbosid('4104607A'),'"+userId+"',sysdate,'"+userId+"',sysdate, "+
        		" '"+cityID+"','"+citynumber+"','"+cityname+"','"+companyid+"','"+comnumber+"','"+comname+"','"+personid+"','"+personnumber+"','"+personname+"','"+businessDate+"','1','"+costNumber+"', " +
        		" '"+postname+"','"+emptype+"','"+postTypeNumber+"','"+indate+"','"+leavedate+"',"+workyear+","+bingjiaPro+",'"+cardnumber+"', " +
        		"  "+sql+" )" ;
        		pe.getSqlList().add(insertSql); 
        	}   
    	}
    	//如果大于0 说明还有奖金大于0 但是没有在这个门诊考勤的数据
    	if(bonusMap.size() >0){
    		for (String key : bonusMap.keySet()) {
    			HashMap<String, BigDecimal>  map= new HashMap<String, BigDecimal>(); 
    			String[] arr = key.split("-");
    			map = bonusMap.get(key);
    			String comnumber = arr[1]; 
    			/**/
    			HashMap<String, Object> perMap = perMsgMap.get(arr[0]);
    			
    			
    			if(perMap != null){
    				String iscount = "0";
            		if(comnumber.equals(perMap.get("COMNUMBER").toString()) ){
            			iscount= "1";
            		}
            		
            		String comid ="";
        			String comname = "";
        			String comsql = "   select  fnumber,fid ,  fname_l2 as name  from   t_org_company  where fnumber = '"+comnumber+"' ";
        			IRowSet rows = DbUtil.executeQuery(ctx,comsql); 
    				if (rows != null  && rows.size() > 0 ) {
    					 while(rows.next()){
    						 comname = rows.getString("NAME"); 
    						 comid = rows.getString("FID"); 
    					 }
    				} 
    				
    				BigDecimal docTypeAmount = BigDecimal.ZERO; 

    				if( docTypeMap.get(arr[0]) !=null ){
    					docTypeAmount = docTypeMap.get(arr[0]);
    				}
        			String sql = jisuan(ctx,businessDate, null, BigDecimal.ZERO, arr[0], arr[1],cityID ,map,userId,docTypeAmount); 
        			String insertSql = " /*dialect*/insert into CT_PAY_PaySheetDetail ( FID,FCreatorID,FCreateTime,FLastUpdateUserID,FLastUpdateTime, "+
            		"  CFCityid,CFCITYNUMBER,CFCITYNAME, CFCompanyid,CFCOMPANYNUMBER,CFCOMPANYNAME,CFPersonid ,CFPERSONNUMBER,CFPERSONNAME ,CFBusinessdate,CFIscount,cfcostcenternumber,"+
            		"  cfpost,cfposttype,cfposttypenumber,cfindate,cfleavedate,cfworkyear,cfbingjiapro,cfcardnumber,"+ 
            		"  cfjibengongzi ,cfpostallow ,cfworkyearallow ,cflearnallow ,cfcardAllow,cfhouseallow,cfachieveMoney,cfmonthMoney ,cfqueqin,cfshijia ,cfbingjia,cfkaoqinsub,cfchidaosub, cfgdAllow,cfallWorkAllow,cffoodAllow,cfaddWorkAllow,cfother,cfgdMoney,cfXRayAllow ,cfholderMoney, "+
            		"  cfassMoney,cfzbPro,cfshopHelp,cfzxCard,cfsplitUp,cfzxLeave,cfdocLeave,cfdocasscost,cfasstodoc,cfotherWaiMoney,cfwaiAllMoney,cfmarktMoney,cfscalMoney,cfmbAmount,cfdocAmount,cfkfAmount,cfhlAmount,cfzxAmount,cfshopTarMoney,cfclinicachimoney,cfotherNeiMoney,cfbdProjectAll,cfmonthBase,cfbdMonthProject, "+
            		"  cfpayble,cfachieveAll ,cfseaBase,cfseaBuzu,cfshouldPay,cfrealShouldPay,cfperYanglao ,cfperYiliao ,cfperDaBing ,cfperShiye,cfperGongjijin,cfperAll ,cfbeforeTaxMoney ,cffreeTaxMoney ,cfgrzxkcAmount,cfljyssde,cfyssde,cftax,cfsjkcs,cfljgrsds ,cfdkgrsds ,cfmwBase,cfdianpingSub,cfkfSub,  "+
            		"  cfpayUp,cfbuchangAmount,cfshifa ,cftiepiao,cfguaiaitong ,cflaowuMoney ,cfqitamoshi,cfjifenAll,cftiepiaoSer ,cfguanaitongSer,cfshouxufei,cfotherSer,cfserviceAll,cfshouldYearBouns,cfyearTax,cfrealyearAmount ,cfrealAmount,cfcomyanglao ,cfcomyiliao,cfcomshiye ,  "+
            		"  cfcomgongshang ,cfcomdabing,cfcomshengyu ,cfcomgongjijin,cffuwufei,cfshuijin ,cfcomAll ,cfLC ,   "+  
                	"  cfbasemoney ,CFFentanother,CFNianzhongfentan ,CFJidufentan,CFNianzhong,CFJidu ,CFYuedurenliAll  ,CFBAODIBONUS )  "+  
            		" values(newbosid('4104607A'),'"+userId+"',sysdate,'"+userId+"',sysdate, "+
            		" '"+cityID+"','"+citynumber+"','"+cityname+"','"+comid+"','"+comnumber+"','"+comname+"','"+perMap.get("PERSONID")+"','"+perMap.get("PERSONNUMBER")+"','"+perMap.get("PERSONNAME")+"','"+businessDate+"','"+iscount+"','"+perMap.get("COSTNUMBER")+"', " +
            		" '"+perMap.get("POSTNAME")+"','"+perMap.get("EMPTYPE")+"','"+perMap.get("POSTTYPENUMBER")+"' ,'"+perMap.get("INDATE")+"','"+perMap.get("LEAVEDATE")+"',"+perMap.get("WORKYEAR")+","+perMap.get("BINGJIAPRO")+",'"+perMap.get("CARDNUMBER")+"', " +
            		"  "+sql+" )" ;
            		pe.getSqlList().add(insertSql);  
    			} 
    		}
    	}
    	
    	if(perClinicMap.size()>0){
    		for (String key : perClinicMap.keySet()) {
				HashMap<String, Object> personMap= new HashMap<String, Object>();
				personMap = perMsgMap.get(key.split("-")[0]);
				//人员id
	    		String personid = personMap.get("PERSONID")== null? "":personMap.get("PERSONID").toString();
	    		String personname = personMap.get("PERSONNAME")== null? "":personMap.get("PERSONNAME").toString();
	    		String personnumber = personMap.get("PERSONNUMBER")== null? "":personMap.get("PERSONNUMBER").toString();
	    		  
	    		//所在公司
	    		String companyid = personMap.get("COMID")== null? "":personMap.get("COMID").toString();
	    		String comname = personMap.get("COMNAME")== null? "":personMap.get("COMNAME").toString();
	    		String comnumber = personMap.get("COMNUMBER")== null? "":personMap.get("COMNUMBER").toString();
	    		   
	    		HashMap<String, BigDecimal>  map= new HashMap<String, BigDecimal>();  
    			map = bonusMap.get(key);
    			BigDecimal docTypeAmount = BigDecimal.ZERO; 
	    		String sql = jisuan(ctx,businessDate, null, BigDecimal.ZERO, personnumber, companyid,cityID ,map,userId,docTypeAmount); 
    			String insertSql = " /*dialect*/insert into CT_PAY_PaySheetDetail ( FID,FCreatorID,FCreateTime,FLastUpdateUserID,FLastUpdateTime, "+
        		"  CFCityid,CFCITYNUMBER,CFCITYNAME, CFCompanyid,CFCOMPANYNUMBER,CFCOMPANYNAME,CFPersonid ,CFPERSONNUMBER,CFPERSONNAME ,CFBusinessdate,CFIscount,cfcostcenternumber,"+
        		"  cfpost,cfposttype,cfposttypenumber,cfindate,cfleavedate,cfworkyear,cfbingjiapro,cfcardnumber,"+ 
        		"  cfjibengongzi ,cfpostallow ,cfworkyearallow ,cflearnallow ,cfcardAllow,cfhouseallow,cfachieveMoney,cfmonthMoney ,cfqueqin,cfshijia ,cfbingjia,cfkaoqinsub,cfchidaosub, cfgdAllow,cfallWorkAllow,cffoodAllow,cfaddWorkAllow,cfother,cfgdMoney,cfXRayAllow ,cfholderMoney, "+
        		"  cfassMoney,cfzbPro,cfshopHelp,cfzxCard,cfsplitUp,cfzxLeave,cfdocLeave,cfdocasscost,cfasstodoc,cfotherWaiMoney,cfwaiAllMoney,cfmarktMoney,cfscalMoney,cfmbAmount,cfdocAmount,cfkfAmount,cfhlAmount,cfzxAmount,cfshopTarMoney,cfclinicachimoney,cfotherNeiMoney,cfbdProjectAll,cfmonthBase,cfbdMonthProject, "+
        		"  cfpayble,cfachieveAll ,cfseaBase,cfseaBuzu,cfshouldPay,cfrealShouldPay,cfperYanglao ,cfperYiliao ,cfperDaBing ,cfperShiye,cfperGongjijin,cfperAll ,cfbeforeTaxMoney ,cffreeTaxMoney ,cfgrzxkcAmount,cfljyssde,cfyssde,cftax,cfsjkcs,cfljgrsds ,cfdkgrsds ,cfmwBase,cfdianpingSub,cfkfSub,  "+
        		"  cfpayUp,cfbuchangAmount,cfshifa ,cftiepiao,cfguaiaitong ,cflaowuMoney ,cfqitamoshi,cfjifenAll,cftiepiaoSer ,cfguanaitongSer,cfshouxufei,cfotherSer,cfserviceAll,cfshouldYearBouns,cfyearTax,cfrealyearAmount ,cfrealAmount,cfcomyanglao ,cfcomyiliao,cfcomshiye ,  "+
        		"  cfcomgongshang ,cfcomdabing,cfcomshengyu ,cfcomgongjijin,cffuwufei,cfshuijin ,cfcomAll ,cfLC ,   "+  
            	"  cfbasemoney ,CFFentanother,CFNianzhongfentan ,CFJidufentan,CFNianzhong,CFJidu ,CFYuedurenliAll  ,CFBAODIBONUS )  "+  
        		" values(newbosid('4104607A'),'"+userId+"',sysdate,'"+userId+"',sysdate, "+
        		" '"+cityID+"','"+citynumber+"','"+cityname+"','"+companyid+"','"+comnumber+"','"+comname+"','"+personMap.get("PERSONID")+"','"+personMap.get("PERSONNUMBER")+"','"+personMap.get("PERSONNAME")+"','"+businessDate+"',1,'"+personMap.get("COSTNUMBER")+"', " +
        		" '"+personMap.get("POSTNAME")+"','"+personMap.get("EMPTYPE")+"','"+personMap.get("POSTTYPENUMBER")+"' ,'"+personMap.get("INDATE")+"','"+personMap.get("LEAVEDATE")+"',"+personMap.get("WORKYEAR")+","+personMap.get("BINGJIAPRO")+",'"+personMap.get("CARDNUMBER")+"', " +
        		"  "+sql+" )" ;
        		pe.getSqlList().add(insertSql);  
   		 	}
    	}
    	
    	try {
			pe.executeUpdate(ctx);
			pool.shutdown(); 
		} catch (EASBizException e) { 
			e.printStackTrace();
			pool.shutdown(); 
		} catch (BOSException e) { 
			e.printStackTrace();
			pool.shutdown(); 
		}
		pool.shutdown();  
		
		//在执行分摊明细表     一边生成对应的分摊表数据
		splitData(ctx,cityID,citynumber,cityname,businessDate,userId);
		
		
		
	}
    
    
    //从工资表明细中得数据 整理插入到分摊表明细
    protected  String splitData(Context ctx,String cityID ,String  citynumber ,String cityname ,String  businessDate, String userId) throws SQLException, BOSException{
    	String deleteSql = " delete  CT_PAY_PayShareDetail  where CFThiscityID = '"+cityID+"' and CFBusinessdate  = '"+businessDate +"' ";
    	DbUtil.execute(ctx, deleteSql ); 
    	
//    	StringBuffer  splitSql = new StringBuffer() 
//		.append(" select   CFCityid,CFCITYNUMBER,CFCITYNAME, CFCompanyid,CFCOMPANYNUMBER,CFCOMPANYNAME,CFPersonid ,CFPERSONNUMBER,CFPERSONNAME ,CFBusinessdate,CFIscount,cfcostcenternumber, ").append("\r\n") 
//    	.append(" cfpost,cfposttypenumber,cfposttype,cfindate,cfleavedate,cfworkyear,cfbingjiapro,cfcardnumber,  ").append("\r\n") 
//    	.append(" nvl(cfjibengongzi,0) ,nvl(cfpostallow,0) ,nvl(cfworkyearallow,0) ,nvl(cflearnallow,0) ,nvl(cfcardAllow,0),nvl(cfhouseallow,0),nvl(cfachieveMoney,0),nvl(cfmonthMoney ,0),nvl(cfqueqin,0),nvl(cfshijia ,0),nvl(cfbingjia,0),nvl(cfkaoqinsub,0),nvl(cfchidaosub,0), nvl(cfgdAllow,0),nvl(cfallWorkAllow,0),nvl(cffoodAllow,0),nvl(cfaddWorkAllow,0),nvl(cfother,0),nvl(cfgdMoney,0),nvl(cfXRayAllow ,0),nvl(cfholderMoney,0), ").append("\r\n") 
//    	.append(" nvl(cfassMoney,0),nvl(cfzbPro,0),nvl(cfshopHelp,0),nvl(cfzxCard,0),nvl(cfsplitUp,0),nvl(cfzxLeave,0),nvl(cfdocLeave,0),nvl(cfotherWaiMoney,0),nvl(cfwaiAllMoney,0),nvl(cfmarktMoney,0),nvl(cfscalMoney,0),nvl(cfmbAmount,0),nvl(cfdocAmount,0),nvl(cfkfAmount,0),nvl(cfhlAmount,0),nvl(cfzxAmount,0),nvl(cfshopTarMoney,0),nvl(cfotherNeiMoney,0),nvl(cfbdProjectAll,0),nvl(cfmonthBase,0),nvl(cfbdMonthProject,0), ").append("\r\n") 
//    	.append(" nvl(cfpayble,0),nvl(cfachieveAll,0) ,nvl(cfseaBase,0),nvl(cfseaBuzu,0),nvl(cfshouldPay,0),nvl(cfrealShouldPay,0),nvl(cfperYanglao,0) ,nvl(cfperYiliao,0) ,nvl(cfperDaBing ,0),nvl(cfperShiye,0),nvl(cfperGongjijin,0),nvl(cfperAll,0) ,nvl(cfbeforeTaxMoney,0) ,nvl(cffreeTaxMoney ,0),nvl(cfgrzxkcAmount,0),nvl(cfljyssde,0),nvl(cfyssde,0),nvl(cftax,0),nvl(cfsjkcs,0),nvl(cfljgrsds,0) ,nvl(cfdkgrsds,0) ,nvl(cfmwBase,0),nvl(cfdianpingSub,0),nvl(cfkfSub,0),  ").append("\r\n") 
//    	.append(" nvl(cfpayUp,0),nvl(cfbuchangAmount,0),nvl(cfshifa,0) ,nvl(cftiepiao,0),nvl(cfguaiaitong ,0),nvl(cflaowuMoney ,0),nvl(cfqitamoshi,0),nvl(cfjifenAll,0),nvl(cftiepiaoSer,0) ,nvl(cfguanaitongSer,0),nvl(cfshouxufei,0),nvl(cfotherSer,0),nvl(cfserviceAll,0),nvl(cfshouldYearBouns,0),nvl(cfyearTax,0),nvl(cfrealyearAmount,0) ,nvl(cfrealAmount,0),nvl(cfcomyanglao ,0),nvl(cfcomyiliao,0),nvl(cfcomshiye ,0),  ").append("\r\n") 
//    	.append(" nvl(cfcomgongshang,0) ,nvl(cfcomdabing,0),nvl(cfcomshengyu ,0),nvl(cfcomgongjijin,0),nvl(cffuwufei,0),nvl(cfshuijin ,0),nvl(cfcomAll,0) ,nvl(cfLC ,0)  from  CT_PAY_PaySheetDetail where  CFCityid='"+cityID+"' and CFBusinessdate='"+businessDate+"'  ");
//    	
//    	System.out.print(splitSql.toString());
//    	IRowSet spiltsrow = DbUtil.executeQuery(ctx, splitSql.toString() );
//    	while (spiltsrow.next()) {
//    		//所在公司
//    		String companyid = spiltsrow.getString("CFCOMPANYID");
//    		String comname = spiltsrow.getString("CFCOMPANYNUMBER");
//    		String comnumber = spiltsrow.getString("CFCOMPANYNAME");
//    		
//    		//人员id
//    		String personid = spiltsrow.getString("PERSONID");
//    		String personname = spiltsrow.getString("PERSONNAME");
//    		String personnumber = spiltsrow.getString("PERSONNUMBER");
//    	}
    	
    	StringBuffer  insertsplitSql = new StringBuffer().append(" /*dialect*/insert into CT_PAY_PayShareDetail ( FID,FCreatorID,FCreateTime,FLastUpdateUserID,FLastUpdateTime, ").append("\r\n") 
    	//城市id    公司id  人员id   成本中心编码     岗位类别编码   是否统计   业务期间  岗位    成本中心id  岗位类别id
		.append("  CFThiscityID,CFComID,CFPerid  ,CFCostCenterNumber ,cfpostTypeNumber,CFIscount,CFBusinessdate,cfemptype,CFCostID,CFPostID, ").append("\r\n") 
		//固定工资      保底奖金      浮动奖金    保底奖金补足     奖金合计
		.append("  CFGudingmoney,CFBaodiMoney,CFFudongMoney,CFBaodibuzu,CFJiangjinAll, ").append("\r\n") 
		//应发工资小计   贴票金额   关爱通金额  劳务公司金额   其他模式金额   应税工资
		.append(" CFYingfaMoney, CFTiepiao,CFGuaiaitong,CFLaowuMoney,CFQitamoshi,CFYingshuiMoney, ").append("\r\n") 
		//贴票手续费   关爱通手续费   LW手续费  其他模式手续费    手续费    
		.append(" CFTPShouxufei,CFGATShouxufei,CFLWShouxufei,CFQTShouxufei, CFShouxufei,   ").append("\r\n") 
		//公司养老  公司医疗  公司失业  公司工伤  公司生育  公司大病 公司公积金   服务费  税金  公司五险一金合计
		.append(" CFComyanglao,CFComyiliao,CFComshiye,CFComgongshang,CFComshengyu,CFCOMDABING ,CFComgongjijin,CFFuwufei,CFShuijin ,CFComshebaoAll, ").append("\r\n") 
		//美维基金  工资税后调整  经济补偿金   月度人力成本
		.append(" CFMwMoney,CFShuihouqita ,CFJingjibuchang,CFYuefurenli, ").append("\r\n") 
		//个人养老  个人医疗  个人失业  个人大病   个人公积金  个税 个人合计  实发
		.append("  CFPerYanglao,CFPerYiliao,CFPerShiye ,CFPERDABING,CFPerGongjijin,CFGeshui ,CFShifa , ").append("\r\n") 

		//基本工资  其他   年终奖分摊/12   季度奖金分摊/3    年终奖发放当月   季度奖金发放当月    月度人力成本总额
		.append("  cfjibengongzi,cfqita,CFNianzhongfentan ,CFJidufentan,CFNianzhong,CFJidu ,CFYuedurenliAll ) ").append("\r\n") 
		
    	.append(" select newbosid('1CE472FA'),'"+userId+"',sysdate,'"+userId+"',sysdate, ").append("\r\n") 
    	//城市id   公司id  人员id  成本中心编码     岗位类别编码   是否统计   业务期间  岗位    成本中心id  岗位类别id
    	.append(" CFCityid,CFCompanyid,cfpersonid , cfcostcenternumber,cfposttypenumber,CFIscount ,CFBusinessdate,case when cfposttype='正式员工' THEN 'S001' ELSE 'S002' END ,cost.fid,posttype.fid, ").append("\r\n") 
    	//固定工资      保底奖金      浮动奖金    保底奖金补足     奖金合计
    	.append(" nvl(cfgdMoney,0),nvl(cfmonthBase,0),nvl(cfpayble,0),nvl(cfbdMonthProject,0), nvl(cfpayble,0)+nvl(cfbdMonthProject,0),  ").append("\r\n") 
    	//应发工资小计   贴票金额   关爱通金额  劳务公司金额   其他模式金额   应税工资
    	.append(" nvl(cfshouldPay,0),nvl(cftiepiao,0),nvl(cfguaiaitong ,0),nvl(cflaowuMoney ,0),nvl(cfqitamoshi,0),nvl(cfrealShouldPay,0), ").append("\r\n") 
    	//贴票手续费   关爱通手续费   LW手续费  其他模式手续费    手续费    
    	.append(" nvl(cftiepiaoSer,0) ,nvl(cfguanaitongSer,0),nvl(cfshouxufei,0),nvl(cfotherSer,0),nvl(cfserviceAll,0), ").append("\r\n") 
    	//公司养老  公司医疗  公司失业  公司工伤  公司生育  公司大病 公司公积金   服务费  税金  公司五险一金合计
    	.append(" nvl(cfcomyanglao ,0),nvl(cfcomyiliao,0),nvl(cfcomshiye ,0),nvl(cfcomgongshang,0) ,nvl(cfcomshengyu ,0),nvl(cfcomdabing,0),nvl(cfcomgongjijin,0),nvl(cffuwufei,0),nvl(cfshuijin ,0),nvl(cfcomAll,0) ,  ").append("\r\n") 
    	//美维基金  工资税后调整  经济补偿金   月度人力成本
    	.append(" nvl(cfmwBase,0),nvl(cfpayUp,0),nvl(cfbuchangAmount,0),nvl(cfLC ,0) , ").append("\r\n") 
    	//个人养老  个人医疗  个人失业  个人大病   个人公积金  个税 个人合计  实发
    	.append("  nvl(cfperYanglao,0) ,nvl(cfperYiliao,0) ,nvl(cfperShiye,0),nvl(cfperDaBing ,0),nvl(cfperGongjijin,0), nvl(cfgeshui ,0)  ,nvl(cfshifa,0),").append("\r\n")  
    	//基本工资  其他   年终奖分摊/12   季度奖金分摊/3    年终奖发放当月   季度奖金发放当月    月度人力成本总额
    	.append("  nvl(cfbasemoney,0) ,nvl(CFFentanother,0) ,nvl(CFNianzhongfentan,0),nvl(CFJidufentan ,0),nvl(CFNianzhong,0), nvl(CFJidu ,0)  ,nvl(CFYuedurenliAll,0)").append("\r\n") 
    	 
    	.append(" from   CT_PAY_PaySheetDetail detail left join  CT_SRQ_CostCenter cost on cost.fnumber = detail.cfcostcenternumber  left join  CT_SRQ_PostType posttype on  posttype.fnumber = detail.cfposttypenumber where  detail.CFCityid='"+cityID+"' and detail.CFBusinessdate='"+businessDate+"'    ");
    	
    	DbUtil.execute(ctx, insertsplitSql.toString());
    	
    	StringBuffer  updateSql = new StringBuffer().append(" update CT_PAY_PayShareDetail  set  cfcomid  = null  where  CFCOSTCENTERNUMBER IN ('CSSC','SCZN') AND cfthiscityid = '"+cityID+"' ");
    	DbUtil.execute(ctx, updateSql.toString());
    	
    	return "";
    }
    
    protected  String jisuan(Context ctx,String businessdate,IRowSet tablerow,BigDecimal attendPro,String personnumber,String clinicnumber,String cityID ,HashMap<String, BigDecimal>  map,String userId,BigDecimal docTypeAmount) throws SQLException, BOSException{
    	
    	
    	//考勤拆分
		//基本工资
    	
		BigDecimal jibengongzi =BigDecimal.ZERO;
		if(personnumber.equals("MS310100270") ){
			if( clinicnumber.equals("MS3101MWGL002")){
				jibengongzi = new BigDecimal("25000").add((tablerow==null? BigDecimal.ZERO:tablerow.getBigDecimal("JIBENGONGZI")).multiply(attendPro));
			}else{
				jibengongzi = (tablerow==null? BigDecimal.ZERO:tablerow.getBigDecimal("JIBENGONGZI").subtract(new BigDecimal("25000"))).multiply(attendPro);
			}
		}else{
			jibengongzi =  (tablerow==null? BigDecimal.ZERO:tablerow.getBigDecimal("JIBENGONGZI")).multiply(attendPro);
		}
		//岗位津贴  
		BigDecimal postallow = (tablerow==null? BigDecimal.ZERO:tablerow.getBigDecimal("POSTALLOW")).multiply(attendPro);
		//工龄补贴
		BigDecimal workyearallow =  (tablerow==null? BigDecimal.ZERO:tablerow.getBigDecimal("WORKYEARALLOW")).multiply(attendPro);
		//学历/职称/技能/证书津贴
		BigDecimal learnallow =  (tablerow==null? BigDecimal.ZERO:tablerow.getBigDecimal("LEARNALLOW")).multiply(attendPro);
		//挂证津贴
		BigDecimal cardAllow =  (tablerow==null? BigDecimal.ZERO:tablerow.getBigDecimal("CARDALLOW")).multiply(attendPro); 
		//住房补贴
		BigDecimal houseallow =  (tablerow==null? BigDecimal.ZERO:tablerow.getBigDecimal("HOUSEALLOW")).multiply(attendPro);
		
		//补贴总和
		BigDecimal allAllow = postallow.add(workyearallow).add(learnallow).add(cardAllow).add(houseallow);
		
		//绩效工资
		BigDecimal achieveMoney =  (tablerow==null? BigDecimal.ZERO:tablerow.getBigDecimal("ACHIEVEMONEY")).multiply(attendPro);
		//月工资
		BigDecimal monthMoney =  (tablerow==null? BigDecimal.ZERO:tablerow.getBigDecimal("MONTHMONEY")).multiply(attendPro);
		monthMoney = jibengongzi.add(allAllow).add(workyearallow).add(achieveMoney);
		//缺勤
		BigDecimal queqin = (tablerow==null? BigDecimal.ZERO:tablerow.getBigDecimal("QUEQIN")).multiply(attendPro); 
		//事假
		BigDecimal shijia = (tablerow==null? BigDecimal.ZERO:tablerow.getBigDecimal("SHIJIA")).multiply(attendPro);  
		//病假
		BigDecimal bingjia = (tablerow==null? BigDecimal.ZERO:tablerow.getBigDecimal("BINGJIA")).multiply(attendPro); 
		//考勤扣款
		BigDecimal kaoqinsub = (tablerow==null? BigDecimal.ZERO:tablerow.getBigDecimal("KAOQINSUB")).multiply(attendPro);   
		//迟到扣款
		BigDecimal chidaosub = (tablerow==null? BigDecimal.ZERO:tablerow.getBigDecimal("CHIDAOSUB")).multiply(attendPro); 
		//固定补贴
		BigDecimal gdAllow = (tablerow==null? BigDecimal.ZERO:tablerow.getBigDecimal("GDALLOW")).multiply(attendPro); 
		//全勤奖
		BigDecimal allWorkAllow = (tablerow==null? BigDecimal.ZERO:tablerow.getBigDecimal("ALLWORKALLOW")).multiply(attendPro);  
		//餐费补贴
		BigDecimal foodAllow =  (tablerow==null? BigDecimal.ZERO:tablerow.getBigDecimal("FOODALLOW")).multiply(attendPro);  
		//加班费
		BigDecimal addWorkAllow = (tablerow==null? BigDecimal.ZERO:tablerow.getBigDecimal("ADDWORKALLOW")).multiply(attendPro);   
		//其他
		BigDecimal other = (tablerow==null? BigDecimal.ZERO:tablerow.getBigDecimal("OTHER")).multiply(attendPro);  
		
		//其他合计
		BigDecimal otherAll = gdAllow.add(allWorkAllow).add(foodAllow).add(addWorkAllow).add(other);
		
		//固定工资合计
		BigDecimal gdMoney = (tablerow==null? BigDecimal.ZERO:tablerow.getBigDecimal("GDMONEY")).multiply(attendPro); 
		gdMoney = monthMoney.subtract(kaoqinsub).add(otherAll);
		
		//个人养老
		BigDecimal perYanglao =  (tablerow==null? BigDecimal.ZERO:tablerow.getBigDecimal("PERYANGLAO")).multiply(attendPro);  
		//个人医疗
		BigDecimal perYiliao = (tablerow==null? BigDecimal.ZERO:tablerow.getBigDecimal("PERYILIAO")).multiply(attendPro);   
		//个人大病
		BigDecimal perDaBing = (tablerow==null? BigDecimal.ZERO:tablerow.getBigDecimal("PERDABING")).multiply(attendPro);   
		//个人失业
		BigDecimal perShiye = (tablerow==null? BigDecimal.ZERO:tablerow.getBigDecimal("PERSHIYE")).multiply(attendPro); 
		//个人公积金
		BigDecimal perGongjijin = (tablerow==null? BigDecimal.ZERO:tablerow.getBigDecimal("PERGONGJIJIN")).multiply(attendPro); 
		//个税合计
		BigDecimal perAll = (tablerow==null? BigDecimal.ZERO:tablerow.getBigDecimal("PERALL")).multiply(attendPro); 
		
		
	
		//免税金额
		BigDecimal freeTaxMoney = (tablerow==null? BigDecimal.ZERO:tablerow.getBigDecimal("FREETAXMONEY")).multiply(attendPro);  
		//个人专项扣除金额
		BigDecimal grzxkcAmount = (tablerow==null? BigDecimal.ZERO:tablerow.getBigDecimal("GRZXKCAMOUNT")).multiply(attendPro);   
		//累计应税所得额
		BigDecimal ljyssde = (tablerow==null? BigDecimal.ZERO:tablerow.getBigDecimal("LJYSSDE")).multiply(attendPro); 
		//应税所得额
		BigDecimal yssde = (tablerow==null? BigDecimal.ZERO:tablerow.getBigDecimal("YSSDE")).multiply(attendPro); 
		//税率
		BigDecimal tax = (tablerow==null? BigDecimal.ZERO:tablerow.getBigDecimal("TAX")).multiply(attendPro);  
		//速算扣除数
		BigDecimal sjkcs = (tablerow==null? BigDecimal.ZERO:tablerow.getBigDecimal("SJKCS")).multiply(attendPro); 
		//累计个人所得税V2
		BigDecimal ljgrsds = (tablerow==null? BigDecimal.ZERO:tablerow.getBigDecimal("LJGRSDS")).multiply(attendPro); 
		//代扣的个人所得税
		BigDecimal dkgrsds = (tablerow==null? BigDecimal.ZERO:tablerow.getBigDecimal("DKGRSDS")).multiply(attendPro); 
		//美维基金
		BigDecimal mwBase = (tablerow==null? BigDecimal.ZERO:tablerow.getBigDecimal("MWBASE")).multiply(attendPro); 
		
		//工资税后调整
		BigDecimal payUp = (tablerow==null? BigDecimal.ZERO:tablerow.getBigDecimal("PAYUP")).multiply(attendPro); 
		//经济补偿金
		BigDecimal buchangAmount = (tablerow==null? BigDecimal.ZERO:tablerow.getBigDecimal("BUCHANGAMOUNT")).multiply(attendPro);  
		
		  
		//公司养老
		BigDecimal comyanglao = (tablerow==null? BigDecimal.ZERO:tablerow.getBigDecimal("COMYANGLAO")).multiply(attendPro);  
		//公司医疗
		BigDecimal comyiliao = (tablerow==null? BigDecimal.ZERO:tablerow.getBigDecimal("COMYILIAO")).multiply(attendPro);  
		//公司失业
		BigDecimal comshiye = (tablerow==null? BigDecimal.ZERO:tablerow.getBigDecimal("COMSHIYE")).multiply(attendPro);  
		//公司工伤
		BigDecimal comgongshang = (tablerow==null? BigDecimal.ZERO:tablerow.getBigDecimal("COMGONGSHANG")).multiply(attendPro);  
		//企业大病
		BigDecimal comdabing = (tablerow==null? BigDecimal.ZERO:tablerow.getBigDecimal("COMDABING")).multiply(attendPro);   
		//公司生育
		BigDecimal comshengyu = (tablerow==null? BigDecimal.ZERO:tablerow.getBigDecimal("COMSHENGYU")).multiply(attendPro);   
		//公司公积金
		BigDecimal comgongjijin = (tablerow==null? BigDecimal.ZERO:tablerow.getBigDecimal("COMGONGJIJIN")).multiply(attendPro);  
		//服务费
		BigDecimal fuwufei = (tablerow==null? BigDecimal.ZERO:tablerow.getBigDecimal("FUWUFEI")).multiply(attendPro);  
		//税金
		BigDecimal shuijin = (tablerow==null? BigDecimal.ZERO:tablerow.getBigDecimal("SHUIJIN")).multiply(attendPro);  
		//公司社保公积金小计
		BigDecimal comAll = (tablerow==null? BigDecimal.ZERO:tablerow.getBigDecimal("COMALL")).multiply(attendPro);   


		
		
		//月保底基数
		BigDecimal monthBase = (tablerow==null? BigDecimal.ZERO:tablerow.getBigDecimal("MONTHBASE")).multiply(attendPro) ;
		//月保底项目补足
		BigDecimal bdMonthProject = (tablerow==null? BigDecimal.ZERO:tablerow.getBigDecimal("BDMONTHPROJECT")).multiply(attendPro); 
		
		//医助成本 
		//BigDecimal docassCost = (tablerow==null? BigDecimal.ZERO:tablerow.getBigDecimal("DOCASSCOST")).multiply(attendPro); 
		BigDecimal docassCost =  BigDecimal.ZERO; 
		
		//季保底基数
		BigDecimal seaBase = (tablerow==null? BigDecimal.ZERO:tablerow.getBigDecimal("SEABASE")); 
		//季保底补足
		BigDecimal seaBuzu = (tablerow==null? BigDecimal.ZERO:tablerow.getBigDecimal("SEABUZU")); 
		
		//X-Ray津贴
		BigDecimal XRayAllow = BigDecimal.ZERO;  
		//压膜保持器奖金
		BigDecimal holderMoney = BigDecimal.ZERO;
		//医助奖金
		BigDecimal assMoney = BigDecimal.ZERO;  
		//周边产品提成
		BigDecimal zbPro = BigDecimal.ZERO;
		//门店支援
		BigDecimal shopHelp = BigDecimal.ZERO;
		//咨询卡项提成
		BigDecimal zxCard = BigDecimal.ZERO; 
		//分销提成
		BigDecimal splitUp = BigDecimal.ZERO;
		//咨询预留
		BigDecimal zxLeave = BigDecimal.ZERO;
		//医生预留
		BigDecimal docLeave = BigDecimal.ZERO; 
		//医助转医生奖金
		BigDecimal asstodocbonus = BigDecimal.ZERO; 
		
		//其他奖金(保底外)
		BigDecimal otherWaiMoney = BigDecimal.ZERO;
		//不计入保底项目合计
		BigDecimal waiAllMoney = BigDecimal.ZERO;
		//市场奖金
		BigDecimal marktMoney = BigDecimal.ZERO;
		//洁牙奖金
		BigDecimal scalMoney = BigDecimal.ZERO;
		//牙周美白奖金
		BigDecimal mbAmount = BigDecimal.ZERO;
		
		//客服奖金
		BigDecimal kfAmount = BigDecimal.ZERO;
		//护理奖金
		BigDecimal hlAmount = BigDecimal.ZERO;
		//咨询师奖金
		BigDecimal zxAmount = BigDecimal.ZERO;  
		//店长门店达成奖励
		BigDecimal shopTarMoney = BigDecimal.ZERO;
		//门店业绩提成
		BigDecimal clinicbonus = BigDecimal.ZERO; 
		
		//其他奖金（保底内）
		BigDecimal otherNeiMoney = BigDecimal.ZERO;
		//保底项目合计
		BigDecimal bdProjectAll = BigDecimal.ZERO;
		
		//医生奖金
		BigDecimal docAmount = BigDecimal.ZERO;
		
		
		//医生全部奖金 
		BigDecimal docAllAmount = docTypeAmount; 
		//月保底基数（折算完考勤后的）
		BigDecimal kaoqinMonthBase = (tablerow==null? BigDecimal.ZERO:tablerow.getBigDecimal("KAOQINMONTHBASE")); 
		    
		if(docAllAmount!=null && docAllAmount.compareTo(BigDecimal.ZERO) > 0 ){
			if(docAllAmount.compareTo(kaoqinMonthBase) >0 ){
				//百分之40按考勤  百分之60按提成比例
				BigDecimal kaoqinAmount = BigDecimal.ZERO;
				BigDecimal tichengAmount = BigDecimal.ZERO;
				if(docAllAmount.compareTo(BigDecimal.ZERO) != 0 ){
					kaoqinAmount = docAllAmount.multiply(new BigDecimal("0.4"));
					tichengAmount = docAllAmount.multiply(new BigDecimal("0.6"));	
				}
				
				//获得该门诊的奖金
				if( map != null && map.size()>0){
					docAmount = map.get("docbonus");  
				}
				kaoqinAmount = kaoqinAmount.multiply(attendPro);
				tichengAmount = tichengAmount.multiply(docAmount.divide(docAllAmount, 4, BigDecimal.ROUND_HALF_UP));
				
				docAmount = kaoqinAmount.add(tichengAmount);
			}else{
				if(docAllAmount.compareTo(BigDecimal.ZERO) != 0 ){
					docAmount = docAllAmount.multiply(attendPro); 
				} 
			}
		}
		//System.out.println(docAmount+"---"+clinicnumber);
		//月保底基数（折算完考勤后的）
		kaoqinMonthBase = (tablerow==null? BigDecimal.ZERO:tablerow.getBigDecimal("KAOQINMONTHBASE")).multiply(attendPro) ;
		
		//应发提成奖金合计
		BigDecimal payble = BigDecimal.ZERO;
		//绩效合计
		BigDecimal achieveAll = BigDecimal.ZERO;
		
		
		//点评扣款
		BigDecimal dianpingSub = BigDecimal.ZERO;
		//客服奖罚
		BigDecimal kfSub = BigDecimal.ZERO;
		
		//------------------应发工资比例拆分
		//贴票金额
		BigDecimal tiepiao = (tablerow==null? BigDecimal.ZERO:tablerow.getBigDecimal("TIEPIAO")); 
		//关爱通金额
		BigDecimal guaiaitong =  (tablerow==null? BigDecimal.ZERO:tablerow.getBigDecimal("GUAIAITONG")); 
		//劳务公司金额
		BigDecimal laowuMoney = (tablerow==null? BigDecimal.ZERO:tablerow.getBigDecimal("LAOWUMONEY")); 
		//其他模式金额
		BigDecimal qitamoshi =  (tablerow==null? BigDecimal.ZERO:tablerow.getBigDecimal("QITAMOSHI")); 
		//其他途径合计
		BigDecimal jifenAll = (tablerow==null? BigDecimal.ZERO:tablerow.getBigDecimal("JIFENALL")); 
		
		//贴票手续费
		BigDecimal tiepiaoSer =  (tablerow==null? BigDecimal.ZERO:tablerow.getBigDecimal("TIEPIAOSER")); 
		//关爱通手续费
		BigDecimal guanaitongSer = (tablerow==null? BigDecimal.ZERO:tablerow.getBigDecimal("GUANAITONGSER")); 
		//LW手续费
		BigDecimal shouxufei =  (tablerow==null? BigDecimal.ZERO:tablerow.getBigDecimal("SHOUXUFEI")); 
		//其他模式手续费
		BigDecimal otherSer =  (tablerow==null? BigDecimal.ZERO:tablerow.getBigDecimal("OTHERSER")); 
		//手续费合计
		BigDecimal serviceAll = (tablerow==null? BigDecimal.ZERO:tablerow.getBigDecimal("SERVICEALL")); 
		//----------------应发工资比例拆分
		
		 
//		String oldBusiness = "";
//		String oldS = "";
//		if(businessdate.substring(4,6).equals("01")){
//			int year = Integer.parseInt(businessdate.substring(0,4));
//			oldBusiness = (year-1)+"";
//			oldS = "'"+oldBusiness+"01','"+oldBusiness+"02','"+oldBusiness+"03','"+oldBusiness+"04','"+oldBusiness+"05','"+oldBusiness+"06'"; 
//		}else if(businessdate.substring(4,6).equals("07")){
//			int year = Integer.parseInt(businessdate.substring(0,4));
//			oldBusiness = (year-1)+"";
//			oldS = "'"+oldBusiness+"07','"+oldBusiness+"08','"+oldBusiness+"09','"+oldBusiness+"10','"+oldBusiness+"11','"+oldBusiness+"12'"; 
//		}
//		if(oldS.length() >0 ){
//			String zxYuLiuSql = "/*dialect*/ SELECT nvl( sum(nvl(cfkeepbouns,0)),0) as amount FROM  CT_PAY_ConsultKeep where CFCITYID = '"+cityID+"' AND CFEMPNUMBER='"+personnumber+"' AND CFCLINICNUMBER='"+clinicnumber+"' and  cfbusinessdate in ("+oldS+")";
//			IRowSet zxrow = DbUtil.executeQuery(ctx, zxYuLiuSql);
//	    	while (zxrow.next()) { 
//	    		//咨询预留 
//				zxLeave = zxrow.getBigDecimal("AMOUNT");  
//	    	} 
//		}
		String zxYuLiuSql = "/*dialect*/ SELECT nvl( sum(nvl(cfkeepbouns,0)),0) as amount FROM  CT_PAY_ConsultKeep where CFCITYID = '"+cityID+"' AND CFEMPNUMBER='"+personnumber+"' AND CFCLINICNUMBER='"+clinicnumber+"' and  cfbusinessdate  ='"+businessdate+"'";
		IRowSet zxrow = DbUtil.executeQuery(ctx, zxYuLiuSql);
    	while (zxrow.next()) { 
    		//咨询预留 
			zxLeave = zxrow.getBigDecimal("AMOUNT");  
    	} 
		if( map != null && map.size()>0){
			//X-Ray津贴
			XRayAllow = map.get("XARY");  
			//压膜保持器奖金
			holderMoney =  map.get("hold"); 
			//医助奖金
			assMoney = map.get("docass");  
			//周边产品提成
			zbPro = map.get("kfbonus");  
			//门店支援
			shopHelp = map.get("shophelp");  
			//咨询卡项提成  ？
			zxCard =map.get("card");  
			//分销提成 ？
			//splitUp = map.get("docass");  
			
			//医助转医生奖金
			//asstodocbonus = map.get("asstodocbonus");
			
			//医生预留？
			docLeave = map.get("keep");  
			//其他奖金(保底外)
			otherWaiMoney = map.get("two");  
			//不计入保底项目合计
			waiAllMoney = XRayAllow.add(holderMoney).add(assMoney).add(zbPro).add(shopHelp).add(zxCard).add(splitUp).subtract(zxLeave).subtract(docLeave).add(docassCost).add(otherWaiMoney).add(asstodocbonus);
			
			
			//市场奖金
			marktMoney = map.get("markt");
			//洁牙奖金
			scalMoney = map.get("scalbonus");  
			//牙周美白奖金
			mbAmount = map.get("whitebonus");  
			
			//医生奖金
			//docAmount = map.get("docbonus");  
			
			
			//客服奖金
			kfAmount = map.get("kefu");  
			//护理奖金
			hlAmount = map.get("huli");  
			//咨询师奖金
			zxAmount = map.get("conbonus").add(zxLeave);  
			//店长门店达成奖励
			shopTarMoney = map.get("shopgoalbonus");  
			
			//门店业绩提成
			clinicbonus = map.get("clinicbonus");  
			//其他奖金（保底内）
			otherNeiMoney = map.get("one");  
			//保底项目合计
			bdProjectAll = marktMoney.add(scalMoney).add(mbAmount).add(docAmount).add(kfAmount).add(hlAmount).add(zxAmount).add(shopTarMoney).add(otherNeiMoney).add(clinicbonus);
			  
			//点评扣款(负数)
			dianpingSub = map.get("SUBAMOUNT"); 
			//客服奖罚(负数)
			//kfSub = map.get("kefu");  
			
			
			//payble =waiAllMoney.add(bdProjectAll).add(bdMonthProject);
			payble =waiAllMoney.add(bdProjectAll);
			achieveAll =waiAllMoney.add(bdProjectAll).add(bdMonthProject);
		}else{
			
			//不计入保底项目合计
			waiAllMoney = XRayAllow.add(holderMoney).add(assMoney).add(zbPro).add(shopHelp).add(zxCard).add(splitUp).subtract(zxLeave).subtract(docLeave).add(docassCost).add(otherWaiMoney).add(asstodocbonus);
			
			//保底项目合计
			bdProjectAll = marktMoney.add(scalMoney).add(mbAmount).add(docAmount).add(kfAmount).add(hlAmount).add(zxAmount).add(shopTarMoney).add(otherNeiMoney).add(clinicbonus);
			//payble =waiAllMoney.add(bdProjectAll).add(bdMonthProject);
			payble =waiAllMoney.add(bdProjectAll);
			achieveAll =waiAllMoney.add(bdProjectAll).add(bdMonthProject);
		}
		 
		
		BigDecimal allShouldPay = (tablerow==null? BigDecimal.ZERO:tablerow.getBigDecimal("SHOULDPAY")); 
		//应发工资
		//BigDecimal shouldPay = BigDecimal.ZERO;  
		BigDecimal shouldPay =  gdMoney.add(achieveAll);  
		
		if(allShouldPay.compareTo(BigDecimal.ZERO) != 0 ){
			//贴票金额
			tiepiao = tiepiao.multiply(shouldPay.divide(allShouldPay, 4, BigDecimal.ROUND_HALF_UP));
			//关爱通金额
			guaiaitong =  guaiaitong.multiply(shouldPay.divide(allShouldPay, 4, BigDecimal.ROUND_HALF_UP));
			//劳务公司金额
			laowuMoney =  laowuMoney.multiply(shouldPay.divide(allShouldPay, 4, BigDecimal.ROUND_HALF_UP));
			//其他模式金额
			qitamoshi = qitamoshi.multiply(shouldPay.divide(allShouldPay, 4, BigDecimal.ROUND_HALF_UP));
			//其他途径合计
			jifenAll = jifenAll.multiply(shouldPay.divide(allShouldPay, 4, BigDecimal.ROUND_HALF_UP));
			
			//贴票手续费
			tiepiaoSer =  tiepiaoSer.multiply(shouldPay.divide(allShouldPay, 4, BigDecimal.ROUND_HALF_UP));
			//关爱通手续费
			guanaitongSer = guanaitongSer.multiply(shouldPay.divide(allShouldPay, 4, BigDecimal.ROUND_HALF_UP));
			//LW手续费
			shouxufei =  shouxufei.multiply(shouldPay.divide(allShouldPay, 4, BigDecimal.ROUND_HALF_UP));
			//其他模式手续费
			otherSer =  otherSer.multiply(shouldPay.divide(allShouldPay, 4, BigDecimal.ROUND_HALF_UP));
			//手续费合计
			serviceAll = serviceAll.multiply(shouldPay.divide(allShouldPay, 4, BigDecimal.ROUND_HALF_UP));
			
		}
		
		 
		//实际应发工资
		BigDecimal realShouldPay = shouldPay.subtract(jifenAll);
		 
		//税前工资
		//BigDecimal beforeTaxMoney = tablerow==null? BigDecimal.ZERO:tablerow.getBigDecimal("BEFORETAXMONEY").multiply(attendPro);  
		BigDecimal beforeTaxMoney = realShouldPay.subtract(perYanglao).subtract(perYiliao).subtract(perDaBing).subtract(perShiye).subtract(perGongjijin);
		
		
		//个人扣除费用
		BigDecimal subPer = dkgrsds.add(mwBase).add(payUp).add(dianpingSub).add(kfSub);
		
		//实发 
		//BigDecimal shifa = tablerow==null? BigDecimal.ZERO:tablerow.getBigDecimal("SHIFA").multiply(attendPro);  
		BigDecimal shifa = beforeTaxMoney.subtract(subPer).add( buchangAmount);
		
		//应发年终奖金(所有门诊)
		BigDecimal shouldAllYearBouns = (tablerow==null? BigDecimal.ZERO:tablerow.getBigDecimal("SHOULDYEARBOUNS"));   
		//年终奖个税
		BigDecimal yearTax = (tablerow==null? BigDecimal.ZERO:tablerow.getBigDecimal("YEARTAX"));  
		
		//应发年终奖金(一个门诊)
		BigDecimal shouldYearBouns = BigDecimal.ZERO;   
		//年终奖金实发
		BigDecimal realyearAmount =  BigDecimal.ZERO; 
		
//		map.put("NIANZHONGMONEY", bonusrow.getBigDecimal("NIANZHONGMONEY"));  
//		map.put("JIDUMONEY", bonusrow.getBigDecimal("JIDUMONEY"));  
//		
//		map.put("NIANZHONGFENTAN", bonusrow.getBigDecimal("NIANZHONGFENTAN"));  
//		map.put("JIDUFENTAN", bonusrow.getBigDecimal("JIDUFENTAN")); 
		
		
		//年终奖分摊/12
		//BigDecimal nianzhongfentan = BigDecimal.ZERO;     
		BigDecimal nianzhongfentan =(tablerow==null? BigDecimal.ZERO:tablerow.getBigDecimal("NIANZHONGFENTAN")).multiply(attendPro); 
		//年终奖发放当月
		BigDecimal yearmonth = BigDecimal.ZERO;     
		
		
		if( map != null && map.size()>0){
			shouldYearBouns = map.get("NIANZHONGMONEY");
			if(shouldAllYearBouns.compareTo(BigDecimal.ZERO)>0){
				yearTax = yearTax.multiply(shouldYearBouns.divide(shouldAllYearBouns ,4, BigDecimal.ROUND_HALF_UP));
			}else{
				yearTax = BigDecimal.ZERO;
			}
			realyearAmount = shouldYearBouns.subtract(yearTax);
			//nianzhongfentan = realyearAmount.divide(new BigDecimal("12"),4, BigDecimal.ROUND_HALF_UP);  
			yearmonth = realyearAmount;  
			 
		}
		
		/*if( map != null && map.size()>0){//有值 
			nianzhongfentan = map.get("NIANZHONGFENTAN");
			if(nianzhongfentan.compareTo(BigDecimal.ZERO) != 0){//有分摊年终奖 说明有年终奖
				if(businessdate.substring(4,6).equals("01")){// 是 发年终奖得月份
					
					shouldYearBouns = map.get("NIANZHONGMONEY");
					if(shouldAllYearBouns.compareTo(BigDecimal.ZERO)>0){
						yearTax = yearTax.multiply(shouldYearBouns.divide(shouldAllYearBouns ,4, BigDecimal.ROUND_HALF_UP));
					}else{
						yearTax = BigDecimal.ZERO;
					}
					realyearAmount = shouldYearBouns.subtract(yearTax);
					nianzhongfentan = realyearAmount.divide(new BigDecimal("12"),4, BigDecimal.ROUND_HALF_UP);  
					yearmonth = realyearAmount;  
				}else{//不是年终奖金发放当月  需要查询对应得年终奖个税  以及 对应年终奖得值
					int year = Integer.parseInt(businessdate.substring(0,4));
					String nianzhongSql = " select NVL(scmptable.S106,0) as shouldYearBouns,NVL(scmptable.S189,0) as yearTax  from  T_HR_SCMPCALTABLE  scmptable   "+
						 "inner join T_BD_Person person  on person.fid = scmptable.FPERSONID where person.fnumber  ='"+personnumber+"'  and  scmptable.fhrorgunitid ='"+cityID+"'  "+
						 "	and  scmptable.FPERIODYEAR = "+year+"  and scmptable.FPERIODMONTH = 1  ";
					IRowSet nianzhongrow = DbUtil.executeQuery(ctx, nianzhongSql.toString() );
			    	while (nianzhongrow.next()) { 
			    		//所有公司的
			    		BigDecimal allclinicNianzhong = nianzhongrow.getBigDecimal("SHOULDYEARBOUNS");
			    		BigDecimal allyeartax = nianzhongrow.getBigDecimal("YEARTAX");
			    		
			    		BigDecimal nianzhongfentan12 = nianzhongfentan.multiply(new BigDecimal("12"));
			    		
			    		//一个门诊的
			    		BigDecimal yigeyearTax = allyeartax.multiply(nianzhongfentan12.divide(allclinicNianzhong ,4, BigDecimal.ROUND_HALF_UP)).divide( new BigDecimal("12"),4, BigDecimal.ROUND_HALF_UP);
			    		nianzhongfentan = nianzhongfentan.subtract(yigeyearTax);
			    	}
						 
				}
			}
		}*/
		
		
		  
		//----------------------分摊表的数据信息
		//基本工资
		BigDecimal shijijibengongzi = (tablerow==null? BigDecimal.ZERO:tablerow.getBigDecimal("GUDINGGONGZI")).multiply(attendPro);  
		//分摊其他
		BigDecimal fentanother = gdMoney.subtract(shijijibengongzi); 
		  
		//季度奖金发放当月
		BigDecimal jidumonth = BigDecimal.ZERO;   
		
		//季度奖金分摊/3
		//BigDecimal jidufentan = BigDecimal.ZERO;    
		BigDecimal jidufentan = (tablerow==null? BigDecimal.ZERO:tablerow.getBigDecimal("JIDUFENTAN")).multiply(attendPro);  
		if( map != null && map.size()>0){
			jidumonth = map.get("JIDUMONEY");
			
		}
		
		//--------------------------------------------------
		
		//实发合计
		//BigDecimal realAmount = tablerow==null? BigDecimal.ZERO:tablerow.getBigDecimal("REALAMOUNT").multiply(attendPro);  
		BigDecimal realAmount = shifa.add(realyearAmount);
		//LC
		//BigDecimal LC = tablerow==null? BigDecimal.ZERO:tablerow.getBigDecimal("LC").multiply(attendPro); 
		//BigDecimal LC = shouldPay.add(comyanglao).add(comyiliao).add(comshiye).add(comgongshang).add(comdabing).add(comshengyu).add(comgongjijin).add(fuwufei).add(shuijin).add(shouldYearBouns).add(serviceAll).add(buchangAmount);
		BigDecimal LC = shouldPay.add(comAll).add(shouldYearBouns).add(serviceAll).add(buchangAmount);
		//月度人力成本总额
		BigDecimal all = nianzhongfentan.add(jidufentan).add(LC);  
		   
		
	  
		 String insertSql = " "+jibengongzi +","+postallow+","+workyearallow +","+learnallow +","+cardAllow+","+houseallow+","+achieveMoney+","+monthMoney +","+queqin+","+shijia +","+bingjia+","+kaoqinsub+","+chidaosub+","+ gdAllow +","+allWorkAllow +","+foodAllow+","+addWorkAllow +","+other +","+gdMoney +","+XRayAllow +","+holderMoney+","+ 
		 " "+assMoney+","+zbPro+","+shopHelp+","+ zxCard+","+splitUp+","+zxLeave+","+docLeave+","+docassCost+","+asstodocbonus+","+ otherWaiMoney+","+waiAllMoney+","+marktMoney+","+scalMoney+","+mbAmount+","+docAmount+","+kfAmount+","+hlAmount+","+zxAmount+","+shopTarMoney+","+clinicbonus+","+otherNeiMoney+","+bdProjectAll+","+monthBase+","+bdMonthProject+","+ 
		 " "+payble+","+achieveAll +","+seaBase+","+seaBuzu+","+shouldPay+","+realShouldPay+","+perYanglao +","+perYiliao +","+perDaBing +","+perShiye+","+perGongjijin+","+perAll +","+beforeTaxMoney +","+freeTaxMoney +","+grzxkcAmount+","+ljyssde+","+yssde+","+tax+","+sjkcs+","+ljgrsds +","+dkgrsds +","+mwBase+","+dianpingSub+","+kfSub+","+ 
		 " "+payUp+","+buchangAmount+","+shifa +","+tiepiao+","+guaiaitong +","+laowuMoney +","+qitamoshi+","+jifenAll+","+tiepiaoSer +","+guanaitongSer+","+shouxufei+","+otherSer+","+serviceAll+","+shouldYearBouns+","+yearTax+","+realyearAmount +","+realAmount+","+comyanglao +","+comyiliao+","+comshiye +","+ 
		 " "+comgongshang +","+comdabing+","+comshengyu +","+comgongjijin+","+fuwufei+","+shuijin +","+comAll +","+LC+" ,"+
		 " "+shijijibengongzi +","+fentanother+","+nianzhongfentan +","+jidufentan+","+yearmonth+","+jidumonth +","+all+" ,"+kaoqinMonthBase+"" ;
		
    	return insertSql.toString();
    }
    
    
    protected  String jisuanByBouns(Context ctx,String businessdate,IRowSet tablerow,BigDecimal attendPro,String personnumber,String clinicnumber,String cityID ,HashMap<String, BigDecimal>  map,String userId,BigDecimal docTypeAmount,String  iscount) throws SQLException, BOSException{
    	
	 
	 	//医生奖金
		BigDecimal docAmount = BigDecimal.ZERO;
		if( map != null && map.size()>0){
			docAmount = map.get("docbonus");  
		}
		
		//医生全部奖金 
		BigDecimal docAllAmount = docTypeAmount; 
		attendPro = BigDecimal.ZERO;
		if(docAllAmount.compareTo(BigDecimal.ZERO) >0 ){
			attendPro = docAmount.divide(docAllAmount, 4, BigDecimal.ROUND_HALF_UP);
		}else if(docAllAmount.compareTo(BigDecimal.ZERO) == 0 && iscount.equals("1")){
			attendPro = BigDecimal.ONE;
		}
		
		//月保底基数（折算完考勤后的）
		BigDecimal kaoqinMonthBase = (tablerow==null? BigDecimal.ZERO:tablerow.getBigDecimal("KAOQINMONTHBASE")); 
		      
    	//考勤拆分
		//基本工资
    	
		BigDecimal jibengongzi =  (tablerow==null? BigDecimal.ZERO:tablerow.getBigDecimal("JIBENGONGZI")).multiply(attendPro); 
		//岗位津贴  
		BigDecimal postallow = (tablerow==null? BigDecimal.ZERO:tablerow.getBigDecimal("POSTALLOW")).multiply(attendPro);
		//工龄补贴
		BigDecimal workyearallow =  (tablerow==null? BigDecimal.ZERO:tablerow.getBigDecimal("WORKYEARALLOW")).multiply(attendPro);
		//学历/职称/技能/证书津贴
		BigDecimal learnallow =  (tablerow==null? BigDecimal.ZERO:tablerow.getBigDecimal("LEARNALLOW")).multiply(attendPro);
		//挂证津贴
		BigDecimal cardAllow =  (tablerow==null? BigDecimal.ZERO:tablerow.getBigDecimal("CARDALLOW")).multiply(attendPro); 
		//住房补贴
		BigDecimal houseallow =  (tablerow==null? BigDecimal.ZERO:tablerow.getBigDecimal("HOUSEALLOW")).multiply(attendPro);
		
		//补贴总和
		BigDecimal allAllow = postallow.add(workyearallow).add(learnallow).add(cardAllow).add(houseallow);
		
		//绩效工资
		BigDecimal achieveMoney =  (tablerow==null? BigDecimal.ZERO:tablerow.getBigDecimal("ACHIEVEMONEY")).multiply(attendPro);
		//月工资
		BigDecimal monthMoney =  (tablerow==null? BigDecimal.ZERO:tablerow.getBigDecimal("MONTHMONEY")).multiply(attendPro);
		monthMoney = jibengongzi.add(allAllow).add(workyearallow).add(achieveMoney);
		//缺勤
		BigDecimal queqin = (tablerow==null? BigDecimal.ZERO:tablerow.getBigDecimal("QUEQIN")).multiply(attendPro); 
		//事假
		BigDecimal shijia = (tablerow==null? BigDecimal.ZERO:tablerow.getBigDecimal("SHIJIA")).multiply(attendPro);  
		//病假
		BigDecimal bingjia = (tablerow==null? BigDecimal.ZERO:tablerow.getBigDecimal("BINGJIA")).multiply(attendPro); 
		//考勤扣款
		BigDecimal kaoqinsub = (tablerow==null? BigDecimal.ZERO:tablerow.getBigDecimal("KAOQINSUB")).multiply(attendPro);   
		//迟到扣款
		BigDecimal chidaosub = (tablerow==null? BigDecimal.ZERO:tablerow.getBigDecimal("CHIDAOSUB")).multiply(attendPro); 
		//固定补贴
		BigDecimal gdAllow = (tablerow==null? BigDecimal.ZERO:tablerow.getBigDecimal("GDALLOW")).multiply(attendPro); 
		//全勤奖
		BigDecimal allWorkAllow = (tablerow==null? BigDecimal.ZERO:tablerow.getBigDecimal("ALLWORKALLOW")).multiply(attendPro);  
		//餐费补贴
		BigDecimal foodAllow =  (tablerow==null? BigDecimal.ZERO:tablerow.getBigDecimal("FOODALLOW")).multiply(attendPro);  
		//加班费
		BigDecimal addWorkAllow = (tablerow==null? BigDecimal.ZERO:tablerow.getBigDecimal("ADDWORKALLOW")).multiply(attendPro);   
		//其他
		BigDecimal other = (tablerow==null? BigDecimal.ZERO:tablerow.getBigDecimal("OTHER")).multiply(attendPro);  
		
		//其他合计
		BigDecimal otherAll = gdAllow.add(allWorkAllow).add(foodAllow).add(addWorkAllow).add(other);
		
		//固定工资合计
		BigDecimal gdMoney = (tablerow==null? BigDecimal.ZERO:tablerow.getBigDecimal("GDMONEY")).multiply(attendPro); 
		gdMoney = monthMoney.subtract(kaoqinsub).add(otherAll);
		
		//个人养老
		BigDecimal perYanglao =  (tablerow==null? BigDecimal.ZERO:tablerow.getBigDecimal("PERYANGLAO")).multiply(attendPro);  
		//个人医疗
		BigDecimal perYiliao = (tablerow==null? BigDecimal.ZERO:tablerow.getBigDecimal("PERYILIAO")).multiply(attendPro);   
		//个人大病
		BigDecimal perDaBing = (tablerow==null? BigDecimal.ZERO:tablerow.getBigDecimal("PERDABING")).multiply(attendPro);   
		//个人失业
		BigDecimal perShiye = (tablerow==null? BigDecimal.ZERO:tablerow.getBigDecimal("PERSHIYE")).multiply(attendPro); 
		//个人公积金
		BigDecimal perGongjijin = (tablerow==null? BigDecimal.ZERO:tablerow.getBigDecimal("PERGONGJIJIN")).multiply(attendPro); 
		//个税合计
		BigDecimal perAll = (tablerow==null? BigDecimal.ZERO:tablerow.getBigDecimal("PERALL")).multiply(attendPro); 
		
		
	
		//免税金额
		BigDecimal freeTaxMoney = (tablerow==null? BigDecimal.ZERO:tablerow.getBigDecimal("FREETAXMONEY")).multiply(attendPro);  
		//个人专项扣除金额
		BigDecimal grzxkcAmount = (tablerow==null? BigDecimal.ZERO:tablerow.getBigDecimal("GRZXKCAMOUNT")).multiply(attendPro);   
		//累计应税所得额
		BigDecimal ljyssde = (tablerow==null? BigDecimal.ZERO:tablerow.getBigDecimal("LJYSSDE")).multiply(attendPro); 
		//应税所得额
		BigDecimal yssde = (tablerow==null? BigDecimal.ZERO:tablerow.getBigDecimal("YSSDE")).multiply(attendPro); 
		//税率
		BigDecimal tax = (tablerow==null? BigDecimal.ZERO:tablerow.getBigDecimal("TAX")).multiply(attendPro);  
		//速算扣除数
		BigDecimal sjkcs = (tablerow==null? BigDecimal.ZERO:tablerow.getBigDecimal("SJKCS")).multiply(attendPro); 
		//累计个人所得税V2
		BigDecimal ljgrsds = (tablerow==null? BigDecimal.ZERO:tablerow.getBigDecimal("LJGRSDS")).multiply(attendPro); 
		//代扣的个人所得税
		BigDecimal dkgrsds = (tablerow==null? BigDecimal.ZERO:tablerow.getBigDecimal("DKGRSDS")).multiply(attendPro); 
		//美维基金
		BigDecimal mwBase = (tablerow==null? BigDecimal.ZERO:tablerow.getBigDecimal("MWBASE")).multiply(attendPro); 
		
		//工资税后调整
		BigDecimal payUp = (tablerow==null? BigDecimal.ZERO:tablerow.getBigDecimal("PAYUP")).multiply(attendPro); 
		//经济补偿金
		BigDecimal buchangAmount = (tablerow==null? BigDecimal.ZERO:tablerow.getBigDecimal("BUCHANGAMOUNT")).multiply(attendPro);  
		
		  
		//公司养老
		BigDecimal comyanglao = (tablerow==null? BigDecimal.ZERO:tablerow.getBigDecimal("COMYANGLAO")).multiply(attendPro);  
		//公司医疗
		BigDecimal comyiliao = (tablerow==null? BigDecimal.ZERO:tablerow.getBigDecimal("COMYILIAO")).multiply(attendPro);  
		//公司失业
		BigDecimal comshiye = (tablerow==null? BigDecimal.ZERO:tablerow.getBigDecimal("COMSHIYE")).multiply(attendPro);  
		//公司工伤
		BigDecimal comgongshang = (tablerow==null? BigDecimal.ZERO:tablerow.getBigDecimal("COMGONGSHANG")).multiply(attendPro);  
		//企业大病
		BigDecimal comdabing = (tablerow==null? BigDecimal.ZERO:tablerow.getBigDecimal("COMDABING")).multiply(attendPro);   
		//公司生育
		BigDecimal comshengyu = (tablerow==null? BigDecimal.ZERO:tablerow.getBigDecimal("COMSHENGYU")).multiply(attendPro);   
		//公司公积金
		BigDecimal comgongjijin = (tablerow==null? BigDecimal.ZERO:tablerow.getBigDecimal("COMGONGJIJIN")).multiply(attendPro);  
		//服务费
		BigDecimal fuwufei = (tablerow==null? BigDecimal.ZERO:tablerow.getBigDecimal("FUWUFEI")).multiply(attendPro);  
		//税金
		BigDecimal shuijin = (tablerow==null? BigDecimal.ZERO:tablerow.getBigDecimal("SHUIJIN")).multiply(attendPro);  
		//公司社保公积金小计
		BigDecimal comAll = (tablerow==null? BigDecimal.ZERO:tablerow.getBigDecimal("COMALL")).multiply(attendPro);   


		
		
		//月保底基数
		BigDecimal monthBase = (tablerow==null? BigDecimal.ZERO:tablerow.getBigDecimal("MONTHBASE")).multiply(attendPro) ;
		//月保底项目补足
		BigDecimal bdMonthProject = (tablerow==null? BigDecimal.ZERO:tablerow.getBigDecimal("BDMONTHPROJECT")).multiply(attendPro); 
		
		//医助成本 
		//BigDecimal docassCost = (tablerow==null? BigDecimal.ZERO:tablerow.getBigDecimal("DOCASSCOST")).multiply(attendPro); 
		BigDecimal docassCost =  BigDecimal.ZERO; 
		
		//季保底基数
		BigDecimal seaBase = (tablerow==null? BigDecimal.ZERO:tablerow.getBigDecimal("SEABASE")); 
		//季保底补足
		BigDecimal seaBuzu = (tablerow==null? BigDecimal.ZERO:tablerow.getBigDecimal("SEABUZU")); 
		
		//X-Ray津贴
		BigDecimal XRayAllow = BigDecimal.ZERO;  
		//压膜保持器奖金
		BigDecimal holderMoney = BigDecimal.ZERO;
		//医助奖金
		BigDecimal assMoney = BigDecimal.ZERO;  
		//周边产品提成
		BigDecimal zbPro = BigDecimal.ZERO;
		//门店支援
		BigDecimal shopHelp = BigDecimal.ZERO;
		//咨询卡项提成
		BigDecimal zxCard = BigDecimal.ZERO; 
		//分销提成
		BigDecimal splitUp = BigDecimal.ZERO;
		//咨询预留
		BigDecimal zxLeave = BigDecimal.ZERO;
		//医生预留
		BigDecimal docLeave = BigDecimal.ZERO; 
		//医助转医生奖金
		BigDecimal asstodocbonus = BigDecimal.ZERO; 
		
		//其他奖金(保底外)
		BigDecimal otherWaiMoney = BigDecimal.ZERO;
		//不计入保底项目合计
		BigDecimal waiAllMoney = BigDecimal.ZERO;
		//市场奖金
		BigDecimal marktMoney = BigDecimal.ZERO;
		//洁牙奖金
		BigDecimal scalMoney = BigDecimal.ZERO;
		//牙周美白奖金
		BigDecimal mbAmount = BigDecimal.ZERO;
		
		//客服奖金
		BigDecimal kfAmount = BigDecimal.ZERO;
		//护理奖金
		BigDecimal hlAmount = BigDecimal.ZERO;
		//咨询师奖金
		BigDecimal zxAmount = BigDecimal.ZERO;  
		//店长门店达成奖励
		BigDecimal shopTarMoney = BigDecimal.ZERO;
		//门店业绩提成
		BigDecimal clinicbonus = BigDecimal.ZERO; 
		
		//其他奖金（保底内）
		BigDecimal otherNeiMoney = BigDecimal.ZERO;
		//保底项目合计
		BigDecimal bdProjectAll = BigDecimal.ZERO;
		
		/*//医生奖金
		BigDecimal docAmount = BigDecimal.ZERO;
		
		
		//医生全部奖金 
		BigDecimal docAllAmount = docTypeAmount; 
		//月保底基数（折算完考勤后的）
		BigDecimal kaoqinMonthBase = (tablerow==null? BigDecimal.ZERO:tablerow.getBigDecimal("KAOQINMONTHBASE")); 
		    
		if(docAllAmount!=null && docAllAmount.compareTo(BigDecimal.ZERO) > 0 ){
			if(docAllAmount.compareTo(kaoqinMonthBase) >0 ){
				//百分之40按考勤  百分之60按提成比例
				BigDecimal kaoqinAmount = BigDecimal.ZERO;
				BigDecimal tichengAmount = BigDecimal.ZERO;
				if(docAllAmount.compareTo(BigDecimal.ZERO) != 0 ){
					kaoqinAmount = docAllAmount.multiply(new BigDecimal("0.4"));
					tichengAmount = docAllAmount.multiply(new BigDecimal("0.6"));	
				}
				
				//获得该门诊的奖金
				if( map != null && map.size()>0){
					docAmount = map.get("docbonus");  
				}
				kaoqinAmount = kaoqinAmount.multiply(attendPro);
				tichengAmount = tichengAmount.multiply(docAmount.divide(docAllAmount, 4, BigDecimal.ROUND_HALF_UP));
				
				docAmount = kaoqinAmount.add(tichengAmount);
			}else{
				if(docAllAmount.compareTo(BigDecimal.ZERO) != 0 ){
					docAmount = docAllAmount.multiply(attendPro); 
				} 
			}
		}*/
		//月保底基数（折算完考勤后的）
		kaoqinMonthBase = (tablerow==null? BigDecimal.ZERO:tablerow.getBigDecimal("KAOQINMONTHBASE")).multiply(attendPro) ;
		
		//应发提成奖金合计
		BigDecimal payble = BigDecimal.ZERO;
		//绩效合计
		BigDecimal achieveAll = BigDecimal.ZERO;
		
		
		//点评扣款
		BigDecimal dianpingSub = BigDecimal.ZERO;
		//客服奖罚
		BigDecimal kfSub = BigDecimal.ZERO;
		
		//------------------应发工资比例拆分
		//贴票金额
		BigDecimal tiepiao = (tablerow==null? BigDecimal.ZERO:tablerow.getBigDecimal("TIEPIAO")); 
		//关爱通金额
		BigDecimal guaiaitong =  (tablerow==null? BigDecimal.ZERO:tablerow.getBigDecimal("GUAIAITONG")); 
		//劳务公司金额
		BigDecimal laowuMoney = (tablerow==null? BigDecimal.ZERO:tablerow.getBigDecimal("LAOWUMONEY")); 
		//其他模式金额
		BigDecimal qitamoshi =  (tablerow==null? BigDecimal.ZERO:tablerow.getBigDecimal("QITAMOSHI")); 
		//其他途径合计
		BigDecimal jifenAll = (tablerow==null? BigDecimal.ZERO:tablerow.getBigDecimal("JIFENALL")); 
		
		//贴票手续费
		BigDecimal tiepiaoSer =  (tablerow==null? BigDecimal.ZERO:tablerow.getBigDecimal("TIEPIAOSER")); 
		//关爱通手续费
		BigDecimal guanaitongSer = (tablerow==null? BigDecimal.ZERO:tablerow.getBigDecimal("GUANAITONGSER")); 
		//LW手续费
		BigDecimal shouxufei =  (tablerow==null? BigDecimal.ZERO:tablerow.getBigDecimal("SHOUXUFEI")); 
		//其他模式手续费
		BigDecimal otherSer =  (tablerow==null? BigDecimal.ZERO:tablerow.getBigDecimal("OTHERSER")); 
		//手续费合计
		BigDecimal serviceAll = (tablerow==null? BigDecimal.ZERO:tablerow.getBigDecimal("SERVICEALL")); 
		//----------------应发工资比例拆分
		
		
//		String oldBusiness = "";
//		String oldS = "";
//		if(businessdate.substring(4,6).equals("01")){
//			int year = Integer.parseInt(businessdate.substring(0,4));
//			oldBusiness = (year-1)+"";
//			oldS = "'"+oldBusiness+"01','"+oldBusiness+"02','"+oldBusiness+"03','"+oldBusiness+"04','"+oldBusiness+"05','"+oldBusiness+"06'"; 
//		}else if(businessdate.substring(4,6).equals("07")){
//			int year = Integer.parseInt(businessdate.substring(0,4));
//			oldBusiness = (year-1)+"";
//			oldS = "'"+oldBusiness+"07','"+oldBusiness+"08','"+oldBusiness+"09','"+oldBusiness+"10','"+oldBusiness+"11','"+oldBusiness+"12'"; 
//		}
//		if(oldS.length() >0 ){
//			String zxYuLiuSql = "/*dialect*/ SELECT nvl( sum(nvl(cfkeepbouns,0)),0) as amount FROM  CT_PAY_ConsultKeep where CFCITYID = '"+cityID+"' AND CFEMPNUMBER='"+personnumber+"' AND CFCLINICNUMBER='"+clinicnumber+"' and  cfbusinessdate in ("+oldS+")";
//			IRowSet zxrow = DbUtil.executeQuery(ctx, zxYuLiuSql);
//	    	while (zxrow.next()) { 
//	    		//咨询预留 
//				zxLeave = zxrow.getBigDecimal("AMOUNT");  
//	    	} 
//		}
		String zxYuLiuSql = "/*dialect*/ SELECT nvl( sum(nvl(cfkeepbouns,0)),0) as amount FROM  CT_PAY_ConsultKeep where CFCITYID = '"+cityID+"' AND CFEMPNUMBER='"+personnumber+"' AND CFCLINICNUMBER='"+clinicnumber+"' and  cfbusinessdate  ='"+businessdate+"'";
		IRowSet zxrow = DbUtil.executeQuery(ctx, zxYuLiuSql);
    	while (zxrow.next()) { 
    		//咨询预留 
			zxLeave = zxrow.getBigDecimal("AMOUNT");  
    	} 
		
		if( map != null && map.size()>0){
			//X-Ray津贴
			XRayAllow = map.get("XARY");  
			//压膜保持器奖金
			holderMoney =  map.get("hold"); 
			//医助奖金
			assMoney = map.get("docass");  
			//周边产品提成
			zbPro = map.get("kfbonus");  
			//门店支援
			shopHelp = map.get("shophelp");  
			//咨询卡项提成  ？
			zxCard =map.get("card");  
			//分销提成 ？
			//splitUp = map.get("docass");  
			
			//医助转医生奖金
			//asstodocbonus = map.get("asstodocbonus");
			
			//医生预留？
			docLeave = map.get("keep");  
			//其他奖金(保底外)
			otherWaiMoney = map.get("two");  
			//不计入保底项目合计
			waiAllMoney = XRayAllow.add(holderMoney).add(assMoney).add(zbPro).add(shopHelp).add(zxCard).add(splitUp).subtract(zxLeave).subtract(docLeave).add(docassCost).add(otherWaiMoney).add(asstodocbonus);
			
			
			//市场奖金
			marktMoney = map.get("markt");
			//洁牙奖金
			scalMoney = map.get("scalbonus");  
			//牙周美白奖金
			mbAmount = map.get("whitebonus");  
			
			//医生奖金
			//docAmount = map.get("docbonus");  
			
			
			//客服奖金
			kfAmount = map.get("kefu");  
			//护理奖金
			hlAmount = map.get("huli");  
			//咨询师奖金
			zxAmount = map.get("conbonus").add(zxLeave);  
			//店长门店达成奖励
			shopTarMoney = map.get("shopgoalbonus");  
			
			//门店业绩提成
			clinicbonus = map.get("clinicbonus");  
			//其他奖金（保底内）
			otherNeiMoney = map.get("one");  
			//保底项目合计
			bdProjectAll = marktMoney.add(scalMoney).add(mbAmount).add(docAmount).add(kfAmount).add(hlAmount).add(zxAmount).add(shopTarMoney).add(otherNeiMoney).add(clinicbonus);
			  
			//点评扣款(负数)
			dianpingSub = map.get("SUBAMOUNT"); 
			//客服奖罚(负数)
			//kfSub = map.get("kefu");  
			
			
			//payble =waiAllMoney.add(bdProjectAll).add(bdMonthProject);
			payble =waiAllMoney.add(bdProjectAll);
			achieveAll =waiAllMoney.add(bdProjectAll).add(bdMonthProject);
		}else{
			
			//不计入保底项目合计
			waiAllMoney = XRayAllow.add(holderMoney).add(assMoney).add(zbPro).add(shopHelp).add(zxCard).add(splitUp).subtract(zxLeave).subtract(docLeave).add(docassCost).add(otherWaiMoney).add(asstodocbonus);
			
			//保底项目合计
			bdProjectAll = marktMoney.add(scalMoney).add(mbAmount).add(docAmount).add(kfAmount).add(hlAmount).add(zxAmount).add(shopTarMoney).add(otherNeiMoney).add(clinicbonus);
			//payble =waiAllMoney.add(bdProjectAll).add(bdMonthProject);
			payble =waiAllMoney.add(bdProjectAll);
			achieveAll =waiAllMoney.add(bdProjectAll).add(bdMonthProject);
		}
		 
		
		BigDecimal allShouldPay = (tablerow==null? BigDecimal.ZERO:tablerow.getBigDecimal("SHOULDPAY")); 
		//应发工资
		//BigDecimal shouldPay = BigDecimal.ZERO;  
		BigDecimal shouldPay =  gdMoney.add(achieveAll);  
		
		if(allShouldPay.compareTo(BigDecimal.ZERO) != 0 ){
			//贴票金额
			tiepiao = tiepiao.multiply(shouldPay.divide(allShouldPay, 4, BigDecimal.ROUND_HALF_UP));
			//关爱通金额
			guaiaitong =  guaiaitong.multiply(shouldPay.divide(allShouldPay, 4, BigDecimal.ROUND_HALF_UP));
			//劳务公司金额
			laowuMoney =  laowuMoney.multiply(shouldPay.divide(allShouldPay, 4, BigDecimal.ROUND_HALF_UP));
			//其他模式金额
			qitamoshi = qitamoshi.multiply(shouldPay.divide(allShouldPay, 4, BigDecimal.ROUND_HALF_UP));
			//其他途径合计
			jifenAll = jifenAll.multiply(shouldPay.divide(allShouldPay, 4, BigDecimal.ROUND_HALF_UP));
			
			//贴票手续费
			tiepiaoSer =  tiepiaoSer.multiply(shouldPay.divide(allShouldPay, 4, BigDecimal.ROUND_HALF_UP));
			//关爱通手续费
			guanaitongSer = guanaitongSer.multiply(shouldPay.divide(allShouldPay, 4, BigDecimal.ROUND_HALF_UP));
			//LW手续费
			shouxufei =  shouxufei.multiply(shouldPay.divide(allShouldPay, 4, BigDecimal.ROUND_HALF_UP));
			//其他模式手续费
			otherSer =  otherSer.multiply(shouldPay.divide(allShouldPay, 4, BigDecimal.ROUND_HALF_UP));
			//手续费合计
			serviceAll = serviceAll.multiply(shouldPay.divide(allShouldPay, 4, BigDecimal.ROUND_HALF_UP));
		}
		
		 
		//实际应发工资
		BigDecimal realShouldPay = shouldPay.subtract(jifenAll);
		 
		//税前工资
		//BigDecimal beforeTaxMoney = tablerow==null? BigDecimal.ZERO:tablerow.getBigDecimal("BEFORETAXMONEY").multiply(attendPro);  
		BigDecimal beforeTaxMoney = realShouldPay.subtract(perYanglao).subtract(perYiliao).subtract(perDaBing).subtract(perShiye).subtract(perGongjijin);
		
		
		//个人扣除费用
		BigDecimal subPer = dkgrsds.add(mwBase).add(payUp).add(dianpingSub).add(kfSub);
		
		//实发 
		//BigDecimal shifa = tablerow==null? BigDecimal.ZERO:tablerow.getBigDecimal("SHIFA").multiply(attendPro);  
		BigDecimal shifa = beforeTaxMoney.subtract(subPer).add( buchangAmount);
		
		//应发年终奖金(所有门诊)
		BigDecimal shouldAllYearBouns = (tablerow==null? BigDecimal.ZERO:tablerow.getBigDecimal("SHOULDYEARBOUNS"));   
		//年终奖个税
		BigDecimal yearTax = (tablerow==null? BigDecimal.ZERO:tablerow.getBigDecimal("YEARTAX"));  
		
		//应发年终奖金(一个门诊)
		BigDecimal shouldYearBouns = BigDecimal.ZERO;   
		//年终奖金实发
		BigDecimal realyearAmount =  BigDecimal.ZERO; 
		
//		map.put("NIANZHONGMONEY", bonusrow.getBigDecimal("NIANZHONGMONEY"));  
//		map.put("JIDUMONEY", bonusrow.getBigDecimal("JIDUMONEY"));  
//		
//		map.put("NIANZHONGFENTAN", bonusrow.getBigDecimal("NIANZHONGFENTAN"));  
//		map.put("JIDUFENTAN", bonusrow.getBigDecimal("JIDUFENTAN")); 
		
		
		//年终奖分摊/12
		//BigDecimal nianzhongfentan = BigDecimal.ZERO;     
		BigDecimal nianzhongfentan =(tablerow==null? BigDecimal.ZERO:tablerow.getBigDecimal("NIANZHONGFENTAN")).multiply(attendPro); 
		//年终奖发放当月
		BigDecimal yearmonth = BigDecimal.ZERO;     
		
		
		if( map != null && map.size()>0){
			shouldYearBouns = map.get("NIANZHONGMONEY");
			if(shouldAllYearBouns.compareTo(BigDecimal.ZERO)>0){
				yearTax = yearTax.multiply(shouldYearBouns.divide(shouldAllYearBouns ,4, BigDecimal.ROUND_HALF_UP));
			}else{
				yearTax = BigDecimal.ZERO;
			}
			realyearAmount = shouldYearBouns.subtract(yearTax);
			//nianzhongfentan = realyearAmount.divide(new BigDecimal("12"),4, BigDecimal.ROUND_HALF_UP);  
			yearmonth = realyearAmount;  
			 
		}
		
		/*if( map != null && map.size()>0){//有值 
			nianzhongfentan = map.get("NIANZHONGFENTAN");
			if(nianzhongfentan.compareTo(BigDecimal.ZERO) != 0){//有分摊年终奖 说明有年终奖
				if(businessdate.substring(4,6).equals("01")){// 是 发年终奖得月份
					
					shouldYearBouns = map.get("NIANZHONGMONEY");
					if(shouldAllYearBouns.compareTo(BigDecimal.ZERO)>0){
						yearTax = yearTax.multiply(shouldYearBouns.divide(shouldAllYearBouns ,4, BigDecimal.ROUND_HALF_UP));
					}else{
						yearTax = BigDecimal.ZERO;
					}
					realyearAmount = shouldYearBouns.subtract(yearTax);
					nianzhongfentan = realyearAmount.divide(new BigDecimal("12"),4, BigDecimal.ROUND_HALF_UP);  
					yearmonth = realyearAmount;  
				}else{//不是年终奖金发放当月  需要查询对应得年终奖个税  以及 对应年终奖得值
					int year = Integer.parseInt(businessdate.substring(0,4));
					String nianzhongSql = " select NVL(scmptable.S106,0) as shouldYearBouns,NVL(scmptable.S189,0) as yearTax  from  T_HR_SCMPCALTABLE  scmptable   "+
						 "inner join T_BD_Person person  on person.fid = scmptable.FPERSONID where person.fnumber  ='"+personnumber+"'  and  scmptable.fhrorgunitid ='"+cityID+"'  "+
						 "	and  scmptable.FPERIODYEAR = "+year+"  and scmptable.FPERIODMONTH = 1  ";
					IRowSet nianzhongrow = DbUtil.executeQuery(ctx, nianzhongSql.toString() );
			    	while (nianzhongrow.next()) { 
			    		//所有公司的
			    		BigDecimal allclinicNianzhong = nianzhongrow.getBigDecimal("SHOULDYEARBOUNS");
			    		BigDecimal allyeartax = nianzhongrow.getBigDecimal("YEARTAX");
			    		
			    		BigDecimal nianzhongfentan12 = nianzhongfentan.multiply(new BigDecimal("12"));
			    		
			    		//一个门诊的
			    		BigDecimal yigeyearTax = allyeartax.multiply(nianzhongfentan12.divide(allclinicNianzhong ,4, BigDecimal.ROUND_HALF_UP)).divide( new BigDecimal("12"),4, BigDecimal.ROUND_HALF_UP);
			    		nianzhongfentan = nianzhongfentan.subtract(yigeyearTax);
			    	}
						 
				}
			}
		}*/
		
		
		  
		//----------------------分摊表的数据信息
		//基本工资
		BigDecimal shijijibengongzi = (tablerow==null? BigDecimal.ZERO:tablerow.getBigDecimal("GUDINGGONGZI")).multiply(attendPro);  
		//分摊其他
		BigDecimal fentanother = gdMoney.subtract(shijijibengongzi); 
		  
		//季度奖金发放当月
		BigDecimal jidumonth = BigDecimal.ZERO;   
		
		//季度奖金分摊/3
		//BigDecimal jidufentan = BigDecimal.ZERO;    
		BigDecimal jidufentan = (tablerow==null? BigDecimal.ZERO:tablerow.getBigDecimal("JIDUFENTAN")).multiply(attendPro);  
		if( map != null && map.size()>0){
			jidumonth = map.get("JIDUMONEY");
			
		}
		
		//--------------------------------------------------
		
		//实发合计
		//BigDecimal realAmount = tablerow==null? BigDecimal.ZERO:tablerow.getBigDecimal("REALAMOUNT").multiply(attendPro);  
		BigDecimal realAmount = shifa.add(realyearAmount);
		//LC
		//BigDecimal LC = tablerow==null? BigDecimal.ZERO:tablerow.getBigDecimal("LC").multiply(attendPro); 
		//BigDecimal LC = shouldPay.add(comyanglao).add(comyiliao).add(comshiye).add(comgongshang).add(comdabing).add(comshengyu).add(comgongjijin).add(fuwufei).add(shuijin).add(shouldYearBouns).add(serviceAll).add(buchangAmount);
		BigDecimal LC = shouldPay.add(comAll).add(shouldYearBouns).add(serviceAll).add(buchangAmount);
		//月度人力成本总额
		BigDecimal all = nianzhongfentan.add(jidufentan).add(LC);  
		   
		
	  
		 String insertSql = " "+jibengongzi +","+postallow+","+workyearallow +","+learnallow +","+cardAllow+","+houseallow+","+achieveMoney+","+monthMoney +","+queqin+","+shijia +","+bingjia+","+kaoqinsub+","+chidaosub+","+ gdAllow +","+allWorkAllow +","+foodAllow+","+addWorkAllow +","+other +","+gdMoney +","+XRayAllow +","+holderMoney+","+ 
		 " "+assMoney+","+zbPro+","+shopHelp+","+ zxCard+","+splitUp+","+zxLeave+","+docLeave+","+docassCost+","+asstodocbonus+","+ otherWaiMoney+","+waiAllMoney+","+marktMoney+","+scalMoney+","+mbAmount+","+docAmount+","+kfAmount+","+hlAmount+","+zxAmount+","+shopTarMoney+","+clinicbonus+","+otherNeiMoney+","+bdProjectAll+","+monthBase+","+bdMonthProject+","+ 
		 " "+payble+","+achieveAll +","+seaBase+","+seaBuzu+","+shouldPay+","+realShouldPay+","+perYanglao +","+perYiliao +","+perDaBing +","+perShiye+","+perGongjijin+","+perAll +","+beforeTaxMoney +","+freeTaxMoney +","+grzxkcAmount+","+ljyssde+","+yssde+","+tax+","+sjkcs+","+ljgrsds +","+dkgrsds +","+mwBase+","+dianpingSub+","+kfSub+","+ 
		 " "+payUp+","+buchangAmount+","+shifa +","+tiepiao+","+guaiaitong +","+laowuMoney +","+qitamoshi+","+jifenAll+","+tiepiaoSer +","+guanaitongSer+","+shouxufei+","+otherSer+","+serviceAll+","+shouldYearBouns+","+yearTax+","+realyearAmount +","+realAmount+","+comyanglao +","+comyiliao+","+comshiye +","+ 
		 " "+comgongshang +","+comdabing+","+comshengyu +","+comgongjijin+","+fuwufei+","+shuijin +","+comAll +","+LC+" ,"+
		 " "+shijijibengongzi +","+fentanother+","+nianzhongfentan +","+jidufentan+","+yearmonth+","+jidumonth +","+all+" ,"+kaoqinMonthBase+"" ;
		
    	return insertSql.toString();
    }
	
    
	
	
	
	protected  BigDecimal getMathBybili( BigDecimal money,String biliStr){
		BigDecimal bili = BigDecimal.ONE;
		if(money == null){
			return BigDecimal.ZERO;
		}
		if(biliStr != null && !biliStr.equals("") ){
			bili = new BigDecimal(biliStr);
		}
		money = money.multiply(bili);
		return money;
	}
}
