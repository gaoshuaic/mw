package com.kingdee.eas.mw.pay.app.util; 

import com.kingdee.bos.Context;

public class TextPayFunctionService {
	 

	/**
	 * 获取洁牙奖金
	 */
	public double getScalingBonus(Context ctx,String empNum,String orgNumber,String periodnum,java.util.HashMap tempMap){
		//com.kingdee.bos.Context ctx = com.kingdee.shr.compensation.app.formula.data.Tools.getInstance().getCtx(); 
		double money = 0.0D;
		if(empNum == null || empNum.equals("")){
			return 0.0D;
		}else if(periodnum == null || periodnum.equals("")){ 
			return 0.0D;
		}
		if(periodnum.length() == 5){
			periodnum = periodnum.substring(0,4)+"0"+periodnum.substring(4,5);
		}
		try { 
			//if((null == tempMap) || (null == tempMap.get(empNum+"JY"))){
			if((null == tempMap) || (null == tempMap.get("JY"))){
				tempMap.put("JY", "1" );
				String cityNumber = "";
				String citysql = "  SELECT fnumber AS NUMBER  FROM  T_ORG_BaseUnit where fid = ( SELECT FCONTROLUNITID  FROM  T_ORG_BaseUnit  where fnumber = '"+orgNumber+"' )";
				com.kingdee.jdbc.rowset.IRowSet cityrs =  com.kingdee.eas.util.app.DbUtil.executeQuery(ctx,citysql);
				if(cityrs!=null && cityrs.size() > 0){
					  while(cityrs.next()){	
						  if(cityrs.getString("NUMBER").equals("CG01")){
							  cityNumber =  "MS3101" ; 
						  }else{
							  cityNumber =  cityrs.getString("NUMBER") ; 
						  }
					  }
				} 
				
				String postSql = "/*dialect*/ SELECT sum(CFScalingBonus) as SUMSCALING,CFEmpNumber FROM   CT_PAY_AchienementSum  where cfcitynumber='"+cityNumber+"'  and  cfbusinessdate='"+periodnum+"'  group  by   CFEmpNumber ";
				
				com.kingdee.jdbc.rowset.IRowSet rs =  com.kingdee.eas.util.app.DbUtil.executeQuery(ctx,postSql);
				if(rs!=null && rs.size() > 0){
					  while(rs.next()){	
						  tempMap.put( rs.getString("CFEMPNUMBER")+"JY", rs.getString("SUMSCALING") );
					  }
				 }   
				
				
			}
			  
			//先判断是不是洁牙师
			if((null == tempMap) || (null == tempMap.get(empNum+"JY")) || "".equals(tempMap.get(empNum+"JY").toString()) ){
				return 0.0D;
			}else{
				//是洁牙师 
				java.math.BigDecimal  moneyBig = java.math.BigDecimal.ZERO; 
				if((null != tempMap.get(empNum+ "JY"))  &&  !"".equals(tempMap.get(empNum+ "JY").toString())){
					moneyBig = moneyBig.add( new java.math.BigDecimal(tempMap.get(empNum+ "JY").toString()));
				}
				money =moneyBig.doubleValue();
			} 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			 
		}  
		
		
		return money;
		
	}
	
	/**
	 * 获取美白成本  取洁牙师的美白成本
	 */
	public double getWhiteCost(Context ctx,String empNum,String orgNumber,String periodnum,java.util.HashMap tempMap){
		//com.kingdee.bos.Context ctx = com.kingdee.shr.compensation.app.formula.data.Tools.getInstance().getCtx(); 
		double money = 0.0D;
		if(empNum == null || empNum.equals("")){ 
			return 0.0D;
		}else if(periodnum == null || periodnum.equals("")){ 
			return 0.0D;
		}
		if(periodnum.length() == 5){
			periodnum = periodnum.substring(0,4)+"0"+periodnum.substring(4,5);
		}
		try { 
			//if((null == tempMap) || (null == tempMap.get(empNum+"_MB"))){
			if((null == tempMap) || (null == tempMap.get("MBCOST"))){
				tempMap.put("MBCOST", "1" );	
				String postSql = "/*dialect*/ SELECT ( nvl(sum(cfjgfmb),0) +nvl(sum(cfxhmb),0) ) as sum FROM  CT_PAY_CostSum  where  cfperiod = '"+periodnum+"'  AND exists ( select 1 from CT_PAY_PayPost b where b.cfbusinessdate='"+periodnum+"' and  cfpostnumber = 'JYS'  AND CFSTATUS = 'qy' and CT_PAY_CostSum.cfdoctornumber =b.cfempnumber ) group  by  cfdoctornumber   ";
				com.kingdee.jdbc.rowset.IRowSet rs =  com.kingdee.eas.util.app.DbUtil.executeQuery(ctx,postSql);
				if(rs!=null && rs.size() > 0){
					  while(rs.next()){	
						  tempMap.put(rs.getString("DOCNUMBER")+"_MBCOST", rs.getString("SUM") );
					  }
				 }   
					
			} 
			
			if((null == tempMap) || (null == tempMap.get(empNum+"_MBCOST")) || "".equals(tempMap.get(empNum+"_MBCOST").toString()) ){
				return 0.0D;
			}else{
				java.math.BigDecimal  moneyBig = java.math.BigDecimal.ZERO; 
				if((null != tempMap.get(empNum+"_MBCOST"))  &&  !"".equals(tempMap.get(empNum+"_MBCOST").toString())){
					moneyBig = moneyBig.add( new java.math.BigDecimal(tempMap.get(empNum+"_MBCOST").toString()));
				}
				
				money =moneyBig.doubleValue();
				//money = Double.parseDouble(tempMap.get(key).toString()); 
			} 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			 
		}  
		
		return money;
		
	}
	
	/**
	 * 获取美白奖金
	 */
	public double getWhiteBonus(Context ctx,String empNum, String orgNumber,String periodnum,java.util.HashMap tempMap){
		//com.kingdee.bos.Context ctx = com.kingdee.shr.compensation.app.formula.data.Tools.getInstance().getCtx(); 
		double money = 0.0D;
		if(empNum == null || empNum.equals("")){
			return 0.0D;
		}else if(periodnum == null || periodnum.equals("")){ 
			return 0.0D;
		}
		if(periodnum.length() == 5){
			periodnum = periodnum.substring(0,4)+"0"+periodnum.substring(4,5);
		}
		try { 
			//if((null == tempMap) || (null == tempMap.get(empNum+"_MB"))){
			if((null == tempMap) || (null == tempMap.get("MB"))){
				tempMap.put("MB", "1" );	
				String cityNumber = "";
				String citysql = "  SELECT fnumber AS NUMBER  FROM  T_ORG_BaseUnit where fid = ( SELECT FCONTROLUNITID  FROM  T_ORG_BaseUnit  where fnumber = '"+orgNumber+"' )";
				com.kingdee.jdbc.rowset.IRowSet cityrs =  com.kingdee.eas.util.app.DbUtil.executeQuery(ctx,citysql);
				if(cityrs!=null && cityrs.size() > 0){
					  while(cityrs.next()){	
						  if(cityrs.getString("NUMBER").equals("CG01")){
							  cityNumber =  "MS3101" ; 
						  }else{
							  cityNumber =  cityrs.getString("NUMBER") ; 
						  }
					  }
				 } 
				String postSql = "/*dialect*/ SELECT sum(CFwhiteBonus) as SUMSCALING,CFEmpNumber FROM   CT_PAY_AchienementSum  where cfcitynumber='"+cityNumber+"'  and   cfbusinessdate='"+periodnum+"'  group  by  CFEmpNumber ";
				com.kingdee.jdbc.rowset.IRowSet rs =  com.kingdee.eas.util.app.DbUtil.executeQuery(ctx,postSql);
				if(rs!=null && rs.size() > 0){
					  while(rs.next()){	
						  tempMap.put(rs.getString("CFEMPNUMBER")+"_MB", rs.getString("SUMSCALING") );
					  }
				 }   
					
			} 
			
			if((null == tempMap) || (null == tempMap.get(empNum+"_MB")) || "".equals(tempMap.get(empNum+"_MB").toString()) ){
				return 0.0D;
			}else{
				java.math.BigDecimal  moneyBig = java.math.BigDecimal.ZERO; 
				if((null != tempMap.get(empNum+"_MB"))  &&  !"".equals(tempMap.get(empNum+"_MB").toString())){
					moneyBig = moneyBig.add( new java.math.BigDecimal(tempMap.get(empNum+"_MB").toString()));
				}
				
				money =moneyBig.doubleValue();
				//money = Double.parseDouble(tempMap.get(key).toString()); 
			} 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			 
		}  
		
		return money;
		
	}
	
	
	/**
	 * 获取咨询师奖金
	 */
	public double getConsultantBonus(Context ctx,String empNum, String orgNumber,String periodnum,java.util.HashMap tempMap){
		//com.kingdee.bos.Context ctx = com.kingdee.shr.compensation.app.formula.data.Tools.getInstance().getCtx(); 
		double money = 0.0D;
		if(empNum == null || empNum.equals("")){
			return 0.0D;
		}else if(periodnum == null || periodnum.equals("")){ 
			return 0.0D;
		}
		if(periodnum.length() == 5){
			periodnum = periodnum.substring(0,4)+"0"+periodnum.substring(4,5);
		}
		try { 
			//判断是否是咨询师
			//if((null == tempMap) || (null == tempMap.get(empNum+"_ZX"))){
			if((null == tempMap) || (null == tempMap.get("ZX"))){
				tempMap.put("ZX", "1" );
				
				String cityNumber = "";
				String citysql = "  SELECT fnumber AS NUMBER  FROM  T_ORG_BaseUnit where fid = ( SELECT FCONTROLUNITID  FROM  T_ORG_BaseUnit  where fnumber = '"+orgNumber+"' )";
				com.kingdee.jdbc.rowset.IRowSet cityrs =  com.kingdee.eas.util.app.DbUtil.executeQuery(ctx,citysql);
				if(cityrs!=null && cityrs.size() > 0){
					  while(cityrs.next()){	
						  if(cityrs.getString("NUMBER").equals("CG01")){
							  cityNumber =  "MS3101" ; 
						  }else{
							  cityNumber =  cityrs.getString("NUMBER") ; 
						  }
					  }
				 } 
				
				String postSql = "/*dialect*/ SELECT sum(CFCONBonus) as SUMSCALING,CFEmpNumber FROM   CT_PAY_AchienementSum  where  cfcitynumber='"+cityNumber+"'  and   cfbusinessdate='"+periodnum+"' group  by  CFEmpNumber ";
				com.kingdee.jdbc.rowset.IRowSet rs =  com.kingdee.eas.util.app.DbUtil.executeQuery(ctx,postSql);
				if(rs!=null && rs.size() > 0){
					  while(rs.next()){	
						  tempMap.put(rs.getString("CFEMPNUMBER")+"_ZX", rs.getString("SUMSCALING") );
					  }
				 } 
					
			} 
			
			if((null == tempMap) || (null == tempMap.get(empNum+"_ZX")) || "".equals(tempMap.get(empNum+"_ZX").toString()) ){
				 
			}else{
				java.math.BigDecimal  moneyBig = java.math.BigDecimal.ZERO; 
				if((null != tempMap.get(empNum+"_ZX"))  &&  !"".equals(tempMap.get(empNum+"_ZX").toString())){
					moneyBig = moneyBig.add( new java.math.BigDecimal(tempMap.get(empNum+"_ZX").toString()));
				}
				
				money =moneyBig.doubleValue();
				 
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			 
		}  
		
		return money;
		
	}
	
	 
	/**
	 * 获取其他职位绩效/门店业绩达成提成
	 */
	public double getOtherPostAch(Context ctx,String empNum, String orgNumber,String periodnum,java.util.HashMap tempMap){
		//com.kingdee.bos.Context ctx = com.kingdee.shr.compensation.app.formula.data.Tools.getInstance().getCtx(); 
		double money = 0.0D;
		if(empNum == null || empNum.equals("")){
			return 0.0D;
		}else if(periodnum == null || periodnum.equals("")){ 
			return 0.0D;
		}
		if(periodnum.length() == 5){
			periodnum = periodnum.substring(0,4)+"0"+periodnum.substring(4,5);
		}
		try { 
			//区分岗位  获得不同岗位
			//if((null == tempMap) || (null == tempMap.get(empNum+"_OT"))){
			if((null == tempMap) || (null == tempMap.get("OT"))){
				tempMap.put("OT", "1" );
				
				String postSql = "/*dialect*/ SELECT sum(CFOTHERPOSTBonus) as SUMSCALING,CFEmpNumber FROM   CT_PAY_AchienementSum  where cfcitynumber='"+orgNumber+"'  and   cfbusinessdate='"+periodnum+"' group by  CFEmpNumber ";
				com.kingdee.jdbc.rowset.IRowSet rs =  com.kingdee.eas.util.app.DbUtil.executeQuery(ctx,postSql);
				if(rs!=null && rs.size() > 0){
					  while(rs.next()){	
						  tempMap.put(rs.getString("CFEMPNUMBER")+"_OT", rs.getString("SUMSCALING") );
					  }
				 } 
					
			}  
			if((null == tempMap) || (null == tempMap.get(empNum+"_OT")) || "".equals(tempMap.get(empNum+"_OT").toString()) ){
				 
			}else{
				java.math.BigDecimal  moneyBig = java.math.BigDecimal.ZERO; 
				if((null != tempMap.get(empNum+"_OT"))  &&  !"".equals(tempMap.get(empNum+"_OT").toString())){
					moneyBig = moneyBig.add( new java.math.BigDecimal(tempMap.get(empNum+"_OT").toString()));
				}
				
				money =moneyBig.doubleValue();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			 
		}   
		return money; 
	}
	
	
	/**
	 * 获取门店目标
	 */
	public double getShopGoal(Context ctx,String empNum, String orgNumber,String periodnum,java.util.HashMap tempMap){
		//com.kingdee.bos.Context ctx = com.kingdee.shr.compensation.app.formula.data.Tools.getInstance().getCtx(); 
		double money = 0.0D;
		if(empNum == null || empNum.equals("")){
			return 0.0D;
		}else if(periodnum == null || periodnum.equals("")){ 
			return 0.0D;
		}
		if(periodnum.length() == 5){
			periodnum = periodnum.substring(0,4)+"0"+periodnum.substring(4,5);
		}
		try { 
			//获取岗位map
			//if((null == tempMap) || (null == tempMap.get(empNum+"_MD"))){
			if((null == tempMap) || (null == tempMap.get("MD"))){
				tempMap.put("MD", "1" );
				
				String postSql = "/*dialect*/ SELECT sum(CFshopgoalBonus) as SUMSCALING,CFEmpNumber FROM   CT_PAY_AchienementSum  where cfcitynumber='"+orgNumber+"'  and   cfbusinessdate='"+periodnum+"' group by  CFEmpNumber ";
				com.kingdee.jdbc.rowset.IRowSet rs =  com.kingdee.eas.util.app.DbUtil.executeQuery(ctx,postSql);
				if(rs!=null && rs.size() > 0){
					  while(rs.next()){	
						  tempMap.put(rs.getObject("CFEMPNUMBER")+"_MD", rs.getObject("SUMSCALING") );
					  }
				 }    
			}
			
			
			if((null == tempMap) || (null == tempMap.get(empNum+"_MD")) || "".equals(tempMap.get(empNum+"_MD").toString()) ){
				 
			}else{
				java.math.BigDecimal  moneyBig = java.math.BigDecimal.ZERO; 
				if((null != tempMap.get(empNum+"_MD"))  &&  !"".equals(tempMap.get(empNum+"_MD").toString())){
					moneyBig = moneyBig.add( new java.math.BigDecimal(tempMap.get(empNum+"_MD").toString()));
				}
				money =moneyBig.doubleValue();

				//money = Double.parseDouble(tempMap.get(key).toString()); 
			} 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			 
		}  
		
		return money;
		
	}
	

	/**
	 * 获取周边产品奖金
	 */
	public double getQuanKeBonus(Context ctx,String empNum, String orgNumber,String periodnum,java.util.HashMap tempMap){
		//com.kingdee.bos.Context ctx = com.kingdee.shr.compensation.app.formula.data.Tools.getInstance().getCtx();
		double money = 0.0D;
		if(empNum == null || empNum.equals("")){
			return 0.0D;
		}else if(periodnum == null || periodnum.equals("")){ 
			return 0.0D;
		}
		if(periodnum.length() == 5){
			periodnum = periodnum.substring(0,4)+"0"+periodnum.substring(4,5);
		}
		try { 
			//获取岗位map
			//if((null == tempMap) || (null == tempMap.get(empNum+"_MD"))){
			if((null == tempMap) || (null == tempMap.get("KF"))){
				tempMap.put("KF", "1" );
				
				
				String postSql = "/*dialect*/ SELECT sum(CFKFBONUS) as  KEFUBONUS,CFEmpNumber FROM   CT_PAY_AchienementSum  where cfcitynumber='"+orgNumber+"'  and   cfbusinessdate='"+periodnum+"' group by  CFEmpNumber ";
				com.kingdee.jdbc.rowset.IRowSet rs =  com.kingdee.eas.util.app.DbUtil.executeQuery(ctx,postSql);
				if(rs!=null && rs.size() > 0){
					  while(rs.next()){	
						  tempMap.put(rs.getObject("CFEMPNUMBER")+"KF", rs.getObject("KEFUBONUS") );
					  }
				 }    
			} 
			if((null == tempMap) || (null == tempMap.get(empNum+"KF")) || "".equals(tempMap.get(empNum+"KF").toString()) ){
				 
			}else{
				java.math.BigDecimal  moneyBig = java.math.BigDecimal.ZERO; 
				if((null != tempMap.get(empNum+"KF"))  &&  !"".equals(tempMap.get(empNum+"KF").toString())){
					moneyBig = moneyBig.add( new java.math.BigDecimal(tempMap.get(empNum+"KF").toString()));
				}
				money =moneyBig.doubleValue(); 
				//money = Double.parseDouble(tempMap.get(key).toString()); 
			} 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); 
		}   
		return money;
		
	}
	

	/**
	 * 医助转医生奖金
	 */
	public double getAssToDocBonus(Context ctx,String empNum, String orgNumber,String periodnum,java.util.HashMap tempMap){
		//com.kingdee.bos.Context ctx = com.kingdee.shr.compensation.app.formula.data.Tools.getInstance().getCtx(); 
		double money = 0.0D;
		if(empNum == null || empNum.equals("")){
			return 0.0D;
		}else if(periodnum == null || periodnum.equals("")){ 
			return 0.0D;
		}
		if(periodnum.length() == 5){
			periodnum = periodnum.substring(0,4)+"0"+periodnum.substring(4,5);
		}
		try { 
			//获取岗位map
			//if((null == tempMap) || (null == tempMap.get(empNum+"_MD"))){
			if((null == tempMap) || (null == tempMap.get("ASSTODOC"))){
				tempMap.put("ASSTODOC", "1" ); 
				
				String postSql = "/*dialect*/ SELECT sum(CFASSTODOCBOUNS) as  CFASSTODOCBOUNS,CFEmpNumber FROM   CT_PAY_AchienementSum  where cfcitynumber='"+orgNumber+"'  and   cfbusinessdate='"+periodnum+"' group by  CFEmpNumber ";
				com.kingdee.jdbc.rowset.IRowSet rs =  com.kingdee.eas.util.app.DbUtil.executeQuery(ctx,postSql);
				if(rs!=null && rs.size() > 0){
					  while(rs.next()){	
						  tempMap.put(rs.getObject("CFEMPNUMBER")+"ASSTODOC", rs.getObject("CFASSTODOCBOUNS") );
					  }
				 }    
			} 
			if((null == tempMap) || (null == tempMap.get(empNum+"ASSTODOC")) || "".equals(tempMap.get(empNum+"ASSTODOC").toString()) ){
				 
			}else{
				java.math.BigDecimal  moneyBig = java.math.BigDecimal.ZERO; 
				if((null != tempMap.get(empNum+"ASSTODOC"))  &&  !"".equals(tempMap.get(empNum+"ASSTODOC").toString())){
					moneyBig = moneyBig.add( new java.math.BigDecimal(tempMap.get(empNum+"ASSTODOC").toString()));
				}
				money =moneyBig.doubleValue(); 
				//money = Double.parseDouble(tempMap.get(key).toString()); 
			} 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); 
		}   
		return money; 
	}
	
	/**
	 * 咨询医生预留奖金
	 */
	public double getDocKeep(Context ctx,java.lang.String empNum, java.lang.String orgNumber,java.lang.String periodnum,java.util.HashMap tempMap){
		System.out.println("getDocKeep----------------------------------------------");
		//com.kingdee.bos.Context ctx = com.kingdee.shr.compensation.app.formula.data.Tools.getInstance().getCtx(); 
		double money = 0.0D;
		if(empNum == null || empNum.equals("")){
			return 0.0D;
		}else if(periodnum == null || periodnum.equals("")){ 
			return 0.0D;
		}
		if(periodnum.length() == 5){
			periodnum = periodnum.substring(0,4)+"0"+periodnum.substring(4,5);
		}
		String  oldS ="";
		int month =  Integer.parseInt(periodnum.substring(4,6));
		int year = Integer.parseInt(periodnum.substring(0,4));
		
		for(int i=0;i<6;i++){
			if(month == 0){
				month = 12;
				year = year-1;
			}else if(month >0 && month <10){
				oldS = oldS+" '"+year+"0"+month+"',";
			}else if(month >9  ){
				oldS = oldS+" '"+year+month+"',";
			}
			month--;
		} 
		if(oldS.length()>0){
			oldS =oldS.substring(0,oldS.length()-1);
		}
		System.out.println("getDocKeep----------------------------------------------"+oldS);
		try { 
			//获取岗位map
			//if((null == tempMap) || (null == tempMap.get(empNum+"_MD"))){
			if((null == tempMap) || (null == tempMap.get("DOCKEEP"))){
				tempMap.put("DOCKEEP", "1" );
				
				String cityNumber = "";
				String cityid = "";
				String citysql = "  SELECT fnumber AS NUMBER,fid as id  FROM  T_ORG_BaseUnit where fid = ( SELECT FCONTROLUNITID  FROM  T_ORG_BaseUnit  where fnumber = '"+orgNumber+"' )";
				com.kingdee.jdbc.rowset.IRowSet cityrs =  com.kingdee.eas.util.app.DbUtil.executeQuery(ctx,citysql);
				if(cityrs!=null && cityrs.size() > 0){
					  while(cityrs.next()){	
						  if(cityrs.getString("NUMBER").equals("CG01")){
							  cityNumber =  "MS3101" ;
							  cityid =  "DeJU1u+zSN+d41DA4hTamsznrtQ=";
						  }else{
							  cityNumber =  cityrs.getString("NUMBER") ;
							  cityid =  cityrs.getString("ID") ;
						  }
					  }
				 } 
				
				String postSql = "/*dialect*/ SELECT sum(CFDocKeepBouns) as  DOCKEEP,CFEmpNumber FROM   CT_PAY_OtherBonusSpilt  where cfcityid='"+cityid+"'  and   cfbusinessdate in ("+oldS+") group by  CFEmpNumber ";
				com.kingdee.jdbc.rowset.IRowSet rs =  com.kingdee.eas.util.app.DbUtil.executeQuery(ctx,postSql);
				if(rs!=null && rs.size() > 0){
					  while(rs.next()){	
						  tempMap.put(rs.getObject("CFEMPNUMBER")+"DOCKEEP", rs.getObject("DOCKEEP") );
					  }
				 }    
			} 
			if((null == tempMap) || (null == tempMap.get(empNum+"DOCKEEP")) || "".equals(tempMap.get(empNum+"DOCKEEP").toString()) ){
				 
			}else{
				java.math.BigDecimal  moneyBig = java.math.BigDecimal.ZERO; 
				if((null != tempMap.get(empNum+"DOCKEEP"))  &&  !"".equals(tempMap.get(empNum+"DOCKEEP").toString())){
					moneyBig = moneyBig.add( new java.math.BigDecimal(tempMap.get(empNum+"DOCKEEP").toString()));
				}
				money =moneyBig.doubleValue(); 
				//money = Double.parseDouble(tempMap.get(key).toString()); 
			} 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); 
		}   
		return money; 
	}
	
	/**
	 * 咨询预留奖金
	 */
	public double getConKeep (Context ctx,String empNum,String orgNumber,String periodnum,java.util.HashMap tempMap){
		//com.kingdee.bos.Context ctx = com.kingdee.shr.compensation.app.formula.data.Tools.getInstance().getCtx(); 
		double money = 0.0D;
		if(empNum == null || empNum.equals("")){
			return 0.0D;
		}else if(periodnum == null || periodnum.equals("")){ 
			return 0.0D;
		}
		if(periodnum.length() == 5){
			periodnum = periodnum.substring(0,4)+"0"+periodnum.substring(4,5);
		}
		String  oldS ="";
		if(periodnum.substring(4,6).equals("01")){
			int year = Integer.parseInt(periodnum.substring(0,4));
			String oldBusiness = (year-1)+"";
			oldS = "'"+oldBusiness+"01','"+oldBusiness+"02','"+oldBusiness+"03','"+oldBusiness+"04','"+oldBusiness+"05','"+oldBusiness+"06'"; 
		}else if(periodnum.substring(4,6).equals("07")){
			int year = Integer.parseInt(periodnum.substring(0,4));
			String  oldBusiness = (year-1)+"";
			oldS = "'"+oldBusiness+"07','"+oldBusiness+"08','"+oldBusiness+"09','"+oldBusiness+"10','"+oldBusiness+"11','"+oldBusiness+"12'"; 
		  	
		}else{
			return 0.0D;
		}
		
		System.out.println("getConKeep----------------------------------------------"+oldS);
		try { 
			//获取岗位map
			if(periodnum.substring(4,6).equals("01") || periodnum.substring(4,6).equals("07")){
				if((null == tempMap) || (null == tempMap.get("CONKEEP"))){
					tempMap.put("CONKEEP", "1" );
					
					String cityNumber = "";
					String cityid = "";
					String citysql = "  SELECT fnumber AS NUMBER,fid as id  FROM  T_ORG_BaseUnit where fid = ( SELECT FCONTROLUNITID  FROM  T_ORG_BaseUnit  where fnumber = '"+orgNumber+"' )";
					com.kingdee.jdbc.rowset.IRowSet cityrs =  com.kingdee.eas.util.app.DbUtil.executeQuery(ctx,citysql);
					if(cityrs!=null && cityrs.size() > 0){
						  while(cityrs.next()){	
							  if(cityrs.getString("NUMBER").equals("CG01")){
								  cityNumber =  "MS3101" ;
								  cityid =  "DeJU1u+zSN+d41DA4hTamsznrtQ=";
							  }else{
								  cityNumber =  cityrs.getString("NUMBER") ;
								  cityid =  cityrs.getString("ID") ;
							  }
						  }
					 } 
					
					String postSql = "/*dialect*/ SELECT sum(CFKeepBouns) as  CONKEEP,CFEmpNumber FROM   CT_PAY_ConsultKeep  where cfcityid='"+cityid+"'  and   cfbusinessdate in ("+oldS+") group by  CFEmpNumber ";
					com.kingdee.jdbc.rowset.IRowSet rs =  com.kingdee.eas.util.app.DbUtil.executeQuery(ctx,postSql);
					if(rs!=null && rs.size() > 0){
						  while(rs.next()){	
							  tempMap.put(rs.getObject("CFEMPNUMBER")+"CONKEEP", rs.getObject("CONKEEP") );
						  }
					 }    
				} 
				if((null == tempMap) || (null == tempMap.get(empNum+"CONKEEP")) || "".equals(tempMap.get(empNum+"CONKEEP").toString()) ){
					 
				}else{
					java.math.BigDecimal  moneyBig = java.math.BigDecimal.ZERO; 
					if((null != tempMap.get(empNum+"CONKEEP"))  &&  !"".equals(tempMap.get(empNum+"CONKEEP").toString())){
						moneyBig = moneyBig.add( new java.math.BigDecimal(tempMap.get(empNum+"CONKEEP").toString()));
					}
					money =moneyBig.doubleValue(); 
					//money = Double.parseDouble(tempMap.get(key).toString()); 
				}
			} 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); 
		}   
		return money; 
		
		
		
	}
	
	/**
	 * 大众点评扣款
	 */
	public double getDianPingSub (Context ctx,String empNum, String orgNumber,String periodnum,java.util.HashMap tempMap){
		//com.kingdee.bos.Context ctx = com.kingdee.shr.compensation.app.formula.data.Tools.getInstance().getCtx(); 
		double money = 0.0D;
		if(empNum == null || empNum.equals("")){
			return 0.0D;
		}else if(periodnum == null || periodnum.equals("")){ 
			return 0.0D;
		}
		if(periodnum.length() == 5){
			periodnum = periodnum.substring(0,4)+"0"+periodnum.substring(4,5);
		}
		try { 
			//获取岗位map
			//if((null == tempMap) || (null == tempMap.get(empNum+"_MD"))){
			if((null == tempMap) || (null == tempMap.get("DPSUB"))){
				tempMap.put("DPSUB", "1" );
				
				String cityNumber = "";
				String cityid = "";
				String citysql = "  SELECT fnumber AS NUMBER,fid as id  FROM  T_ORG_BaseUnit where fid = ( SELECT FCONTROLUNITID  FROM  T_ORG_BaseUnit  where fnumber = '"+orgNumber+"' )";
				com.kingdee.jdbc.rowset.IRowSet cityrs =  com.kingdee.eas.util.app.DbUtil.executeQuery(ctx,citysql);
				if(cityrs!=null && cityrs.size() > 0){
					  while(cityrs.next()){	
						  if(cityrs.getString("NUMBER").equals("CG01")){
							  cityNumber =  "MS3101" ;
							  cityid =  "DeJU1u+zSN+d41DA4hTamsznrtQ=";
						  }else{
							  cityNumber =  cityrs.getString("NUMBER") ;
							  cityid =  cityrs.getString("ID") ;
						  }
						  
					  }
				 } 
				
				String postSql = "/*dialect*/ SELECT sum(CFSUBAMOUNT) as  DPSUB,CFEmpNumber FROM   CT_PAY_ClinicComSub  where cfcityid='"+cityid+"'  and   cfbusinessdate='"+periodnum+"' group by  CFEmpNumber ";
				com.kingdee.jdbc.rowset.IRowSet rs =  com.kingdee.eas.util.app.DbUtil.executeQuery(ctx,postSql);
				if(rs!=null && rs.size() > 0){
					  while(rs.next()){	
						  tempMap.put(rs.getObject("CFEMPNUMBER")+"DPSUB", rs.getObject("DPSUB") );
					  }
				 }    
			} 
			if((null == tempMap) || (null == tempMap.get(empNum+"DPSUB")) || "".equals(tempMap.get(empNum+"DPSUB").toString()) ){
				 
			}else{
				java.math.BigDecimal  moneyBig = java.math.BigDecimal.ZERO; 
				if((null != tempMap.get(empNum+"DPSUB"))  &&  !"".equals(tempMap.get(empNum+"DPSUB").toString())){
					moneyBig = moneyBig.add( new java.math.BigDecimal(tempMap.get(empNum+"DPSUB").toString()));
				}
				money =moneyBig.doubleValue(); 
				//money = Double.parseDouble(tempMap.get(key).toString()); 
			} 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); 
		}   
		return money; 
	}
	
	
	/**
	 * 压模保持器奖金
	 */
	public double getHoldKeep (Context ctx,String empNum, String orgNumber,String periodnum,java.util.HashMap tempMap){
		//com.kingdee.bos.Context ctx = com.kingdee.shr.compensation.app.formula.data.Tools.getInstance().getCtx(); 
		double money = 0.0D;
		if(empNum == null || empNum.equals("")){
			return 0.0D;
		}else if(periodnum == null || periodnum.equals("")){ 
			return 0.0D;
		}
		if(periodnum.length() == 5){
			periodnum = periodnum.substring(0,4)+"0"+periodnum.substring(4,5);
		}
		try { 
			//获取岗位map
			//if((null == tempMap) || (null == tempMap.get(empNum+"_MD"))){
			if((null == tempMap) || (null == tempMap.get("DPSUB"))){
				tempMap.put("HoldKeep", "1" );
				
				String cityNumber = "";
				String cityid = "";
				String citysql = "  SELECT fnumber AS NUMBER,fid as id  FROM  T_ORG_BaseUnit where fid = ( SELECT FCONTROLUNITID  FROM  T_ORG_BaseUnit  where fnumber = '"+orgNumber+"' )";
				com.kingdee.jdbc.rowset.IRowSet cityrs =  com.kingdee.eas.util.app.DbUtil.executeQuery(ctx,citysql);
				if(cityrs!=null && cityrs.size() > 0){
					  while(cityrs.next()){	
						  if(cityrs.getString("NUMBER").equals("CG01")){
							  cityNumber =  "MS3101" ;
							  cityid =  "DeJU1u+zSN+d41DA4hTamsznrtQ=";
						  }else{
							  cityNumber =  cityrs.getString("NUMBER") ;
							  cityid =  cityrs.getString("ID") ;
						  }
						  
					  }
				 } 
				
				String postSql = "/*dialect*/  SELECT sum(CFHoldAmount) as  HOIDKEEP,CFEmpNumber FROM   CT_PAY_OtherBonusSpilt  where cfcityid='"+cityid+"'  and   cfbusinessdate='"+periodnum+"' group by  CFEmpNumber ";
				com.kingdee.jdbc.rowset.IRowSet rs =  com.kingdee.eas.util.app.DbUtil.executeQuery(ctx,postSql);
				if(rs!=null && rs.size() > 0){
					  while(rs.next()){	
						  tempMap.put(rs.getObject("CFEMPNUMBER")+"HoldKeep", rs.getObject("HOIDKEEP") );
					  }
				 }    
			} 
			if((null == tempMap) || (null == tempMap.get(empNum+"HoldKeep")) || "".equals(tempMap.get(empNum+"HoldKeep").toString()) ){
				 
			}else{
				java.math.BigDecimal  moneyBig = java.math.BigDecimal.ZERO; 
				if((null != tempMap.get(empNum+"HoldKeep"))  &&  !"".equals(tempMap.get(empNum+"HoldKeep").toString())){
					moneyBig = moneyBig.add( new java.math.BigDecimal(tempMap.get(empNum+"HoldKeep").toString()));
				}
				money =moneyBig.doubleValue(); 
				//money = Double.parseDouble(tempMap.get(key).toString()); 
			} 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); 
		}   
		return money; 
	}
}